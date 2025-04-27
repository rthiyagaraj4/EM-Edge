//saved on 26/10/2005
var function_id = "";
var result		= false;
var message		= "";
var flag		= "";

function create() {	
	f_query_add_mod.location.href="../../ePH/jsp/TpnConsNsRegimenFrames.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}

function apply() {
	var formObj1=f_query_add_mod.f_tpn_cons_ns_regimen_top.document.frmTpnConstNsRegimenConsDetails;
	var formObj2=f_query_add_mod.f_tpn_cons_ns_regimen_middle.document.frmTpnConstNsRegimenInvItemDetails;
	
	var fields;
	var names ;

	/*if(formObj1.all.conc_mand.style.visibility=="visible") {
		fields = new Array ( formObj1.concentration_percent,formObj1.const_generic_code ,formObj1.const_short_name,formObj1.const_long_name,formObj1.physical_form);
		names = new Array (getLabel("ePH.Concentration.label","PH"), getLabel("ePH.ConstituentGenericName.label","PH"),getLabel("Common.shortname.label","Common"),getLabel("Common.longname.label","Common"),getLabel("ePH.PhysicalForm.label","PH"));
	} else {*/
		fields = new Array ( formObj1.const_generic_code ,formObj1.const_short_name,formObj1.const_long_name,formObj1.physical_form);
		names = new Array (getLabel("ePH.ConstituentGenericName.label","PH"),getLabel("Common.shortname.label","Common"),getLabel("Common.longname.label","Common"),getLabel("ePH.PhysicalForm.label","PH"));
	/*}*/

	if(f_query_add_mod.f_tpn_cons_ns_regimen_top.checkFieldsofMst( fields, names, messageFrame)) {
		var tabellength=parent.window[2].window[1].window[1].document.getElementById('inv_item_details_table').rows.length;
    
		if(tabellength>2){
			var flag = false;
			for (var i=1;i<tabellength-1 ;i++ ){
					if(eval("formObj2.item_add"+i).value=="Y"){
						flag=true;
						break;
					}			
			}
			if(!flag){
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PH_ATLEAST_ONE_ITEM_ADDED");	
				return false;
			}
			formObj2.tot_no_of_rows.value=tabellength-2;
			var formArray = new Array(formObj1,formObj2);
			
			eval(formApply( formArray,PH_CONTROLLER ));
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;		
			if( result ) {
				onSuccess();		
			}
		}else{
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PH_ATLEAST_ONE_ITEM_ADDED");	
		}
	}
}

function reset() {
	f_query_add_mod.f_tpn_cons_ns_regimen_top.document.frmTpnConstNsRegimenConsDetails.reset();
//added for ml-mmoh-crf-1201
	f_query_add_mod.f_tpn_cons_ns_regimen_bottom.document.frmTpnConstNsRegimenButtons.reset();
	f_query_add_mod.f_tpn_cons_ns_regimen_middle.document.frmTpnConstNsRegimenInvItemDetails.reset();
	f_query_add_mod.location.href="../../ePH/jsp/TpnConsNsRegimenFrames.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}


function assignResult( _result, _message, _flag ) {
	result	= _result;
	message	= _message;
	flag	= _flag;
}
function beforePost(xmlStr) {
	//alert(xmlStr);
}

function onSuccess(){
	
	var formObj1=f_query_add_mod.f_tpn_cons_ns_regimen_top.document.frmTpnConstNsRegimenConsDetails;

	if(formObj1.mode.value=="1"){
		f_query_add_mod.location.href="../../ePH/jsp/TpnConsNsRegimenFrames.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
	}else if(formObj1.mode.value=="2"){
		var const_generic_code = formObj1.const_generic_code.value;
		var const_srl_no =  formObj1.const_srl_no.value;	
		f_query_add_mod.location.href="../../ePH/jsp/TpnConsNsRegimenFrames.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&const_generic_code="+const_generic_code+"&const_srl_no="+const_srl_no;
	}
}

/*
var groupCode="";
function loadMolecule(generic_group_code){
groupCode=generic_group_code;
//alert("group_code......85....>"+groupCode);
	if(groupCode=="EL" || groupCode=="MN") {
//		alert("it is in EL || MN...");
	}
	else{
//		alert("it is in NOT .. EL ()(_)( ||  MN()(_)(...");
	}
}
*/


function disbleBtn(){
	var formObjTop=parent.f_tpn_cons_ns_regimen_top.frmTpnConstNsRegimenConsDetails;
	var formObj = document.frmTpnConstNsRegimenButtons;
	var mode = formObj.mode.value;

	if (mode==1)
	{
	document.getElementById("updBtn").style.visibility="hidden";
	}

	else if (mode == 2) {
	document.getElementById("updBtn").style.visibility="hidden";
	}

}

async function populateItemLookup(target){
	var formObj = document.frmTpnConstNsRegimenButtons;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	argumentArray[0]   = formObj.SQL_PH_TPN_CONS_NS_REGIMEN_SELECT3.value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = CODE_DESC ;

	var retVal = await CommonLookup( getLabel("ePH.ItemLookup.label","PH"), argumentArray );
	if(retVal != null && retVal != "" )  {
		var ret1=unescape(retVal);
		var arr=ret1.split(",");
		formObj.item_code.value = arr[0];
		formObj.item_desc.value = arr[1];
		formObj.item_code.disabled = true;
		document.getElementById('lbl_item_desc').innerText = arr[1];
		getStockUOM(arr[0]);
		document.getElementById('lbl_sale_uom_desc').innerText = sale_uom_code;
		var generic_code = formObj.generic_code.value;
		document.getElementById('content_in_pres_base_uom').value = getContentInPresBaseUOM(sale_uom_code);
		document.getElementById('lbl_content_in_pres_base_uom').innerText = document.getElementById('content_in_pres_base_uom').value;
	} 	
}

function getStockUOM(obj){
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " item_code=\"" + obj + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TpnConsNsRegimenValidate.jsp?identity=getStockUOM", false ) ;
	xmlHttp.send( xmlDoc ) ;
	eval(xmlHttp.responseText);
}
var content_in_pres_base_uom="";
function getContentInPresBaseUOM(sale_uom_code){
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
//	xmlStr += " item_code=\"" + item_code + "\"";
//	xmlStr += " generic_code=\"" + generic_code + "\"";
	xmlStr += " item_stock_uom=\"" + sale_uom_code + "\"";

	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TpnConsNsRegimenValidate.jsp?identity=getContentInPresBaseUOM", false ) ;
	xmlHttp.send( xmlDoc ) ;
//	alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);
	return content_in_pres_base_uom;
}

function assignContentInPresBaseUOM(obj){
	if(obj=="NO"){
		alert(getMessage("PH_CONV_FACTOR_NOT_DEFINED","PH"));		
		//alert(getMessage("PH_CONV_FACTOR_NOT_DEFINED"));		
//		parent.document.location.href="../../ePH/jsp/TpnConsNsRegimenFrames.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
		clearAll();
		return false;
	}else{
		content_in_pres_base_uom=obj;
	}	
}


var sale_uom_code="";
function assignSaleUOMCode(obj){
	sale_uom_code = obj;
}

function clearAll(){
	var formObj = document.frmTpnConstNsRegimenButtons;
	var formObjMiddle = parent.f_tpn_cons_ns_regimen_middle.frmTpnConstNsRegimenInvItemDetails;
	var site_moh_YN=formObj.site_moh_YN.value;//added for ml-mmoh-crf-1201
	formObj.item_code.value="";
	document.getElementById('lbl_item_desc').innerText = "";
	document.getElementById('lbl_sale_uom_desc').innerText = "";
	document.getElementById('lbl_content_in_pres_base_uom').innerText = "";
	formObj.molecule.value="";
	formObj.osmolar_value.value="";
	if(site_moh_YN == "Y"){
	formObj.item_concentration.value="";//Added for ML-MMOH-CRF-1201
	formObj.volume.value="";//Added for ML-MMOH-CRF-1201
	}
	formObj.item_code.disabled=false;
	formObj.btnItemLookup.disabled=false;

	if(formObj.btnAdd.value=="Delete"){
		formObj.btnAdd.value="Add";	
	}
	formObj.btnUpdate.style.visibility="hidden";
}


function updateItems(){

	var formObjTop=parent.f_tpn_cons_ns_regimen_top.frmTpnConstNsRegimenConsDetails;
	var formObjMiddle = parent.f_tpn_cons_ns_regimen_middle.frmTpnConstNsRegimenInvItemDetails;
	var formObjBottom = parent.f_tpn_cons_ns_regimen_bottom.frmTpnConstNsRegimenButtons;
	var row_no = parent.window[1].document.getElementById('inv_item_details_table').rows.length;
	var const_generic_code = formObjTop.const_generic_code.value;
//	var moleculeCode=formObjBottom.molecule_code.value;
	var moleculeCode;
	var site_moh_YN=formObjTop.site_moh_YN.value;//added for ml-mmoh-crf-1201
	var pres_base_uom = document.getElementById('lbl_content_in_pres_base_uom').innerText;
	for (var i=1;i<row_no-1 ;i++ )
	 {
	if((eval("formObjMiddle.item_code"+i).value)== formObjBottom.item_code.value)
		{		
	 		curr_row	=	parent.window[1].document.getElementById('inv_item_details_table').rows[i+1];
			var classval;	

//	curr_row.cells(3).innerHTML = formObjBottom.osmolar_value.value;
//	curr_row.cells(2).innerText= formObjBottom.molecule_desc.value;

//|| (formObjTop.const_generic_code.value =="Ca") || (formObjTop.const_generic_code.value =="Cl") || (formObjTop.const_generic_code.value =="Mg") || (formObjTop.const_generic_code.value =="PO4") || (formObjTop.const_generic_code.value =="K") || (formObjTop.const_generic_code.value =="Na"))


if (formObjBottom.molecule.selectedIndex != -1) 	{
		curr_row.cells[2].innerHTML = formObjBottom.molecule.options[formObjBottom.molecule.selectedIndex].text+"<input type='hidden' name=\"molecule"+i+"\" id=\"molecule"+i+"\" value='"+formObjBottom.molecule.value+"' >";
//	curr_row.cells(2).innerHTML = formObjBottom.molecule.options(formObjBottom.molecule.selectedIndex).text;
	
	moleculeCode = formObjBottom.molecule.options[formObjBottom.molecule.selectedIndex].value;
	}else {
	curr_row.cells[2].innerHTML ="<input type='hidden' name=\"molecule"+i+"\" id=\"molecule"+i+"\" value='' >";
	moleculeCode="";
	}
	curr_row.cells[3].innerText= formObjBottom.osmolar_value.value;
	if(site_moh_YN =="Y"){
	curr_row.cells[4].innerText= formObjBottom.item_concentration.value;//Added for ML-MMOH-CRF-1201
	curr_row.cells[5].innerText= formObjBottom.volume.value;//Added for ML-MMOH-CRF-1201
	}

//	eval("formObjMiddle.osmolar_value"+i).value=formObjBottom.osmolar_value.value;

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " item_code=\"" +(eval("formObjMiddle.item_code"+i).value)+ "\"";
//	xmlStr += " osmolar_value=\"" + curr_row.cells(3).innerHTML + "\"";
	xmlStr += " molecule_value=\"" + curr_row.cells[2].innerText + "\"";
	xmlStr += " osmolar_value=\"" + curr_row.cells[3].innerText + "\"";
	if(site_moh_YN =="Y"){
	xmlStr += " item_concentration=\"" + curr_row.cells[4].innerText + "\"";//Added for ML-MMOH-CRF-1201
	xmlStr += " volume=\"" + curr_row.cells[5].innerText + "\"";//Added for ML-MMOH-CRF-1201
	}
	xmlStr += " molecule_code=\"" + moleculeCode+ "\"";
	xmlStr += " pres_base_uom=\"" + pres_base_uom+ "\"";
//	xmlStr += " item_stock_uom=\"" + sale_uom_code + "\"";

	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TpnConsNsRegimenValidate.jsp?identity=getOsmolarValue", false ) ;
	xmlHttp.send( xmlDoc ) ;
//	alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);
		} 
	}
	clearAll();	
	formObjBottom.btnUpdate.style.visibility="hidden";
}

function addItemDetails(){

	var formObjTop=parent.f_tpn_cons_ns_regimen_top.frmTpnConstNsRegimenConsDetails;
	var formObjMiddle = parent.f_tpn_cons_ns_regimen_middle.frmTpnConstNsRegimenInvItemDetails;
	var formObjBottom = parent.f_tpn_cons_ns_regimen_bottom.frmTpnConstNsRegimenButtons;
	var site_moh_YN=formObjTop.site_moh_YN.value;//Added for ML-MMOH-CRF-1201
	
	 var iCount;//Added for ML-MMOH-CRF-1201
var getval=formObjTop.elements.length;

//This is to Check the Button Valu
	if(formObjBottom.btnAdd.value=="Add")
	{
		for(i=0;i<getval;i++)
				{
				formObjTop.elements[i].disabled=true;
				}
	}
	else if(formObjBottom.btnAdd.value=="Delete")
	{
			for(i=0;i<getval;i++)
				{
					formObjTop.elements[i].disabled=false;
				}
	}
	if(formObjBottom.btnAdd.value=="Delete")
	{
		parent.window[1].document.getElementById('inv_item_details_table').rows[formObjBottom.delete_row.value].style.display="none";
	
	eval("formObjMiddle.item_add"+(formObjBottom.delete_row.value-1)).value="N";
	eval("formObjMiddle.item_code"+(formObjBottom.delete_row.value-1)).value = "";
	clearAll();
	formObjBottom.btnAdd.value="Add";
	}else{
		if(formObjBottom.item_code.value != ""){
			var row_no = parent.window[1].document.getElementById('inv_item_details_table').rows.length;
			if(row_no % 2 == 0 )
				classval	=	"QRYEVEN";
			else
				classval	=	"QRYODD";
 for (var i=1;i<row_no-1 ;i++ )
	 {
	if((eval("formObjMiddle.item_code"+i).value)== formObjBottom.item_code.value)
		{
            parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PH_DUPLICATE_ITEM_NOT_ALLOWED");	
					return false;
		}
 }

			curr_row	= parent.window[1].document.getElementById('inv_item_details_table').insertRow();
			var classval;
	  //Added for ML-MMOH-CRF-1201 start
	   if(site_moh_YN == "Y"){
		   iCount=7; 
	   }
	   else{
		   iCount=4;
	   }//Added for ML-MMOH-CRF-1201 end
	  
			for(i=0; i<iCount; i++)	{	//Cahnged 4 to 6//Added for ML-MMOH-CRF-1201
				cell	=	curr_row.insertCell();

			if (i==0){

					curr_row.cells[0].className	= classval;
					//Added for ML-MMOH-CRF-1201 start
					if(site_moh_YN == "Y"){
						  curr_row.cells[0].innerHTML = "<A HREF='javascript:loadDataForAmend(this,"+(row_no-1)+")'>"+formObjBottom.item_code.value+"/"+formObjBottom.item_desc.value+"</A><input type='hidden' name=\"item_code"+(row_no-1)+"\" id=\"item_code"+(row_no-1)+"\" value='"+formObjBottom.item_code.value+"'><input type='hidden' name=\"item_add"+(row_no-1)+"\" id=\"item_add"+(row_no-1)+"\" value='Y'><input type=hidden name=\"item_desc"+(row_no-1)+"\" id=\"item_desc"+(row_no-1)+"\" value='"+document.getElementById('lbl_item_desc').innerText+"'><input type='hidden' name=\"content_in_pres_base_uom"+(row_no-1)+"\" id=\"content_in_pres_base_uom"+(row_no-1)+"\" value="+formObjBottom.content_in_pres_base_uom.value+">"; 
					   }
					   else{
						   curr_row.cells[0].innerHTML = "<A HREF='javascript:loadDataForAmend(this,"+(row_no-1)+")'>"+formObjBottom.item_code.value+"</A><input type='hidden' name=\"item_code"+(row_no-1)+"\" id=\"item_code"+(row_no-1)+"\" value='"+formObjBottom.item_code.value+"'><input type='hidden' name=\"item_add"+(row_no-1)+"\" id=\"item_add"+(row_no-1)+"\" value='Y'><input type=hidden name=\"item_desc"+(row_no-1)+"\" id=\"item_desc"+(row_no-1)+"\" value='"+document.getElementById('lbl_item_desc').innerText+"'><input type='hidden' name=\"content_in_pres_base_uom"+(row_no-1)+"\" id=\"content_in_pres_base_uom"+(row_no-1)+"\" value="+formObjBottom.content_in_pres_base_uom.value+">";
					   }
					   //Added for ML-MMOH-CRF-1201 end
				}else if (i==1){
					curr_row.cells[1].className	= classval;
					curr_row.cells[1].innerHTML =document.getElementById('lbl_sale_uom_desc').innerText+"<input type='hidden' name=\"stock_uom_code"+(row_no-1)+"\" id=\"stock_uom_code"+(row_no-1)+"\" value="+document.getElementById('lbl_sale_uom_desc').innerText+"> ";

				}else if (i==2){
					curr_row.cells[2].className	= classval;
					if(formObjBottom.molecule.value != ""){
						curr_row.cells[2].innerHTML = formObjBottom.molecule.options(formObjBottom.molecule.selectedIndex).text+"<input type='hidden' name=\"molecule"+(row_no-1)+"\" id=\"molecule"+(row_no-1)+"\" value='"+formObjBottom.molecule.value+"' >";
					 }
					 else{
						curr_row.cells[2].innerHTML = "&nbsp;<input type='hidden'  name=\"molecule"+(row_no-1)+"\" id=\"molecule"+(row_no-1)+"\" value=''>";;
					}
				}
				else if (i==3){
					curr_row.cells[3].className	= classval;
					curr_row.cells[3].innerHTML = formObjBottom.osmolar_value.value+"<input type='hidden' name=\"osmolar_value"+(row_no-1)+"\" id=\"osmolar_value"+(row_no-1)+"\" value='"+formObjBottom.osmolar_value.value+"'> ";
				}	
				else if (i==4){//Adding start for ML-MMOH-CRF-1201

					curr_row.cells[4].className	= classval;
					curr_row.cells[4].innerHTML = formObjBottom.item_concentration.value+"<input type='hidden' name=\"item_concentration"+(row_no-1)+"\" id=\"item_concentration"+(row_no-1)+"\" value='"+formObjBottom.item_concentration.value+"'> ";
					
				}	
				else if (i==5){
					curr_row.cells[5].className	= classval;
					curr_row.cells[5].innerHTML = formObjBottom.volume.value+"<input type='hidden' name=\"volume"+(row_no-1)+"\" id=\"volume"+(row_no-1)+"\" value='"+formObjBottom.volume.value+"'> ";
					
				}
				else if (i==6){
					curr_row.cells[6].className	= classval;
					curr_row.cells[6].innerHTML = "<b><a href='javascript:applicibilitySettingmodify(frmTpnConstNsRegimenInvItemDetails.item_code"+(row_no-1)+")'>Link</a></b>";
					
				}
			
			//Addign end for ML-MMOH-CRF-1201
			}
			clearAll();
		}else{
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=APP-000001 Item Code cannot be blank..." ;		
		}
	}
}

var cont_base_uom_mod_asgn ="";

function getcontPresbaseUOM(item_code,const_generic_code){

var formObjTop=parent.f_tpn_cons_ns_regimen_top.frmTpnConstNsRegimenConsDetails;
var formObjMiddle = parent.f_tpn_cons_ns_regimen_middle.frmTpnConstNsRegimenInvItemDetails;
var formObjBottom = parent.f_tpn_cons_ns_regimen_bottom.frmTpnConstNsRegimenButtons;

//var cons_press_uom =formObjBottom.all.lbl_content_in_pres_base_uom.innerText;
var const_generic_code = formObjTop.const_generic_code.value;

/*
	for (var i=1;i<row_no-1 ;i++ )
	{
			var item_code=(eval("formObjMiddle.item_code"+i).value);
	}
	*/

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();


	xmlStr	="<root><SEARCH " ;
//	xmlStr += " item_code=\"" +(eval("formObjMiddle.item_code"+i).value)+ "\"";
	xmlStr += " item_code=\"" +item_code+ "\"";
	xmlStr += " const_generic_code=\"" + const_generic_code + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TpnConsNsRegimenValidate.jsp?identity=getcontPresbaseUOM", false ) ;
	xmlHttp.send( xmlDoc ) ;
//  alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);
//	 }

	 return cont_base_uom_mod_asgn;
}


function assigncontPresbaseUOM(obj){
		cont_base_uom_mod_asgn=obj;
}




function loadContPresUOM() {
	var formObjTop=parent.f_tpn_cons_ns_regimen_top.frmTpnConstNsRegimenConsDetails;
	var formObjMiddle = parent.f_tpn_cons_ns_regimen_middle.frmTpnConstNsRegimenInvItemDetails;
	
	var row_no = document.getElementById('inv_item_details_table').rows.length;
	var const_generic_code = formObjTop.const_generic_code.value;

for (var i=1;i<row_no-1 ;i++ )
	{
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " item_code=\"" +(eval("formObjMiddle.item_code"+i).value)+ "\"";
	xmlStr += " const_generic_code=\"" + const_generic_code + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TpnConsNsRegimenValidate.jsp?identity=loadcontPresUOM", false ) ;
	xmlHttp.send( xmlDoc ) ;
//	alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);
	 }
}

function loadDataForAmend(obj,row_no){

	var frmObj=obj.name;
	var formObj = document.frmTpnConstNsRegimenButtons;
	var formObjTop=parent.f_tpn_cons_ns_regimen_top.frmTpnConstNsRegimenConsDetails;
	var const_generic_code = formObjTop.const_generic_code.value;
	var formObjMiddle = parent.f_tpn_cons_ns_regimen_middle.frmTpnConstNsRegimenInvItemDetails;
	var site_moh_YN=formObjTop.site_moh_YN.value;//Added for ML-MMOH-CRF-1201
	for (var i=1;i<=row_no;i++ ){
	curr_row	=	document.getElementById('inv_item_details_table').rows[i+1];
   }

	var formObjBottom = parent.f_tpn_cons_ns_regimen_bottom.frmTpnConstNsRegimenButtons;
	console.log(formObjBottom);
	var formObjMiddle = parent.f_tpn_cons_ns_regimen_middle.frmTpnConstNsRegimenInvItemDetails;
	formObjBottom.btnAdd.value="Delete";

	formObjBottom.item_code.disabled=true;
	formObjBottom.btnItemLookup.disabled=true;
	formObjBottom.item_code.value=eval("formObjMiddle.item_code"+row_no).value;
//if(eval("formObjMiddle.molecule"+row_no) != undefined){
	formObjBottom.molecule.value=eval("formObjMiddle.molecule"+row_no).value;	
//}
//	var DISP_LOCN_DESC=obj.cells[1].innerText;
//	formObjBottom.osmolar_value.value=eval("formObjMiddle.osmolar_value"+row_no).value;	
	formObjBottom.osmolar_value.value=curr_row.cells[3].innerText;	
	if(site_moh_YN == "Y"){
	formObjBottom.item_concentration.value=curr_row.cells[4].innerText;	//Added for ML-MMOH-CRF-1201
    formObjBottom.volume.value=curr_row.cells[5].innerText;	//Added for ML-MMOH-CRF-1201
	}

	parent.window[2].document.getElementById('lbl_item_desc').innerText = eval("formObjMiddle.item_desc"+row_no).value;
	parent.window[2].document.getElementById('lbl_sale_uom_desc').innerText = eval("formObjMiddle.stock_uom_code"+row_no).value;

	parent.window[2].document.getElementById('lbl_content_in_pres_base_uom').innerText = getcontPresbaseUOM(formObjBottom.item_code.value);

//	formObjBottom.all.content_in_pres_base_uom.value = getcontPresbaseUOM(formObjBottom.item_code.value);
//	formObjBottom.all.lbl_content_in_pres_base_uom.innerText = formObjBottom.all.content_in_pres_base_uom.value;

	formObjBottom.delete_row.value=(parseFloat(row_no)+1);
	formObjBottom.btnUpdate.style.visibility="visible";
}

function query() {
    f_query_add_mod.location.href="../../ePH/jsp/TpnConsNsRegimenQueryCriteria.jsp?function_id="+function_id ;
}

function Modify(obj){
	var const_generic_code = obj.cells[0].innerText;
	var item_code = obj.cells[1].innerText;	
	var conc_percent = obj.cells[2].innerText;	

	document.location.href="../../ePH/jsp/TpnConsNsRegimenFrames.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&const_generic_code="+const_generic_code+"&const_srl_no="+item_code+"&conc_percent="+conc_percent;	
}



function showMolecule(generic_code,const_generic_code,const_srl_no,mode){
	var formObjTop=parent.f_tpn_cons_ns_regimen_top.frmTpnConstNsRegimenConsDetails;
	group_code	=	eval("document.frmTpnConstNsRegimenConsDetails."+generic_code.value+".value");
	if(generic_code == ""){
		parent.f_tpn_cons_ns_regimen_middle.location.href="../../eCommon/html/blank.html";
		parent.f_tpn_cons_ns_regimen_bottom.location.href="../../eCommon/html/blank.html";
		return false;
	}



//	if(group_code=="EL" || group_code=="MN") {
	/*if(group_code=="EL") {
		document.getElementById("conc_mand").style.visibility ="visible";
	} else {
		document.getElementById("conc_mand").style.visibility ="hidden";
	}
*/

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr += " generic_code=\"" + generic_code.value + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "TpnConsNsRegimenValidate.jsp?identity=getGroupCode", false ) ;
	xmlHttp.send( xmlDoc ) ;
	var group_code = xmlHttp.responseText;

	parent.f_tpn_cons_ns_regimen_middle.location.href="../../ePH/jsp/TpnConsNsRegimenInvItemDetails.jsp?const_generic_code="+const_generic_code+"&const_srl_no="+const_srl_no+"&mode="+mode+"&group_code="+group_code;
	parent.f_tpn_cons_ns_regimen_bottom.location.href ="../../ePH/jsp/TpnConsNsRegimenButtons.jsp?const_generic_code="+const_generic_code+"&const_srl_no="+const_srl_no+"&mode="+mode+"&group_code="+group_code+"&generic_code="+generic_code.value;
}

//added for ML-MMOH-CRF-1201 START

async function applicibilitySetting(obj){
	//alert("//added for ML-MMOH-CRF-1201 START");
	var dialogHeight= "30vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop = "270" ;
	var center = "1" ;
	var status="no";
	var drug_code=obj.value;
	var regimen_code = parent.f_tpn_cons_ns_regimen_top.frmTpnConstNsRegimenConsDetails.const_generic_code.value;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+";scrolling :no";
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/TPNConsApplicibilitySetting.jsp?drug_code="+drug_code+"&regimen_code="+regimen_code+"&mode=create",arguments,features);

}

async function applicibilitySettingmodify(obj){
	//alert("//added for ML-MMOH-CRF-1201 START");
	var dialogHeight= "30vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop = "270" ;
	var center = "1" ;
	var status="no";
	var drug_code=obj.value;
	var regimen_code = parent.f_tpn_cons_ns_regimen_top.frmTpnConstNsRegimenConsDetails.const_generic_code.value;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+";scrolling :no";
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/TPNConsApplicibilitySetting.jsp?drug_code="+drug_code+"&regimen_code="+regimen_code+"&mode=MODIFY",arguments,features);

}
async function applicibilitySettingmodeEdit(obj){
	//alert("//added for ML-MMOH-CRF-1201 START");
	var dialogHeight= "30vh" ;
	var dialogWidth	= "50vw" ;
	var dialogTop = "270" ;
	var center = "1" ;
	var status="no";
	var drug_code=obj.value;
	var regimen_code = parent.f_tpn_cons_ns_regimen_top.frmTpnConstNsRegimenConsDetails.const_generic_code.value;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop+";scrolling :no";
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../ePH/jsp/TPNConsApplicibilitySetting.jsp?drug_code="+drug_code+"&regimen_code="+regimen_code+"&mode=EDIT",arguments,features);

}

function setOnlineSetuptoBean(action_type) {
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlAppend	=	"";
    
	var count = eval("applicabulitySettingsForm.count").value;
	var drug_code = eval("applicabulitySettingsForm.drug_code").value;
	var regimen_code = eval("applicabulitySettingsForm.regimen_code").value;
     for(var i=0;i<count;i++){
    //alert(eval("applicabulitySettingsForm.age"+i).value);
    //alert(eval("applicabulitySettingsForm.applicibulity"+i).value);
    xmlAppend += "code"+i+"=\""+eval("applicabulitySettingsForm.age"+i).value+"\" " ;
    xmlAppend += "value"+i+"=\""+eval("applicabulitySettingsForm.applicibulity"+i).value+"\" " ;
   
     }
     xmlAppend += " count=\"" +count+ "\"";
     xmlAppend += " drug_code=\"" +drug_code+ "\"";
     xmlAppend += " regimen_code=\"" +regimen_code+ "\"";
     xmlAppend += " action_type=\"" +action_type.value+ "\"";
     var  xmlStr ="<root><SEARCH " ;
 	xmlStr = xmlStr + xmlAppend ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		
	xmlHttp.open( "POST", "TpnConsNsRegimenValidate.jsp?identity=applicable_ok_cancel", false);

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
	window.close();
	//return true;
}
function AssignValues(obj){
	var count = eval("applicabulitySettingsForm.count").value;
	//alert(count);
	var obj1;
	if(obj=="*A"){
		if(eval("applicabulitySettingsForm.applicibulity0").value === "A")
		{
			for(var i=1;i<count;i++){
			
				obj1=eval("applicabulitySettingsForm.applicibulity"+i);
			    obj1.disabled=true;
		}
			
		}
		else{
			for(var i=1;i<count;i++){
				obj1=eval("applicabulitySettingsForm.applicibulity"+i);
				obj1.disabled=false;
			
			}
		}
	}
}
//added for ML-MMOH-CRF-1201 end

