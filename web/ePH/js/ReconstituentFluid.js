var function_id = "PH_RECONST_FLUID" ;
var result = false ;
var message = "" ;
var flag = "" ;
var selectDefaultFacility = "";
var runningCounter =0;
function create() {
		ReconstituentFluidFrame.location.href="../../ePH/jsp/ReconstituentFluidFrame.jsp?function_id="+function_id+"&mode="+MODE_INSERT ;			
		//ReconstituentFluidFrame.reconstituentfluid_top.document.forms[0].RF_ID.focus();
}

function query(){
	ReconstituentFluidFrame.location.href="../../ePH/jsp/ReconstituentFluidQueryCriteria.jsp?function_id="+function_id ;
}

function apply() {
	if(ReconstituentFluidFrame.location.href.indexOf("ReconstituentFluidFrame")!=-1)
	{

	var fields= new Array (ReconstituentFluidFrame.reconstituentfluid_top.document.forms[0].RF_ID, ReconstituentFluidFrame.reconstituentfluid_top.document.forms[0].RF_NAME, ReconstituentFluidFrame.reconstituentfluid_top.document.forms[0].RF_BASE_UNIT);
	var names= new Array(getLabel("ePH.FluidID.label","PH"), getLabel("Common.FluidName.label","Common"),getLabel("ePH.BaseUnit.label","PH")); 
		
	var formObj1=ReconstituentFluidFrame.reconstituentfluid_top.document.formReconstituentFluid;

	var formArray = "";
	var ImmoduleYn = formObj1.Immodule_Yn.value

	if(ImmoduleYn == 1){

		var formObj2 = ReconstituentFluidFrame.reconstituentfluid_middle.document.frmInvItemReconstituentFluidDisplay;

/*		for (i=0;i<formObj2.elements.length ;i++ )
		{
			alert(formObj2.elements[i].name);
		}
		*/
		
		var fluid_id	= formObj1.RF_ID.value;
		var fluid_name	= formObj1.RF_NAME.value;
		var base_unit	= formObj1.RF_BASE_UNIT.value;
		formObj2.RF_ID.value = fluid_id;
		formObj2.RF_NAME.value = fluid_name;
		formObj2.RF_BASE_UNIT.value = base_unit;

		formArray = (formObj2);

	}else{

		formArray = (formObj1);
	}

	if(checkFieldsofMst(fields,names,messageFrame) ) 
	{
		if (ImmoduleYn==1)
		{
			//var row_no = formObj2.all.tab.rows.length-2;
			var row_no = ReconstituentFluidFrame.reconstituentfluid_middle.document.getElementById("tab").rows.length-2;
					 
			if(row_no < 1)
			{
				message = getMessage("NO_ITEM_ADDED_FLUID","PH");
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;				
				return false;
			}
		}
		
//		alert(formApply(formArray,PH_CONTROLLER ));		
		eval(formApply(formArray,PH_CONTROLLER ));	
//		alert(message);
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;		
		if( result ) {
			onSuccess();		
		}
	}
	}
	else
	{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
}

function onSuccess() {

	create();
	
}

function editRow(obj) {
	if(obj.value==getLabel("Common.Add.label","Common")) {
		AddRow(obj);

	} else if(obj.value==getLabel("Common.Modify.label","Common")) {
		ModifyRow(obj);
	} 
}

function ModifyRow(obj) {
	var formObjMiddle	= parent.reconstituentfluid_middle.frmInvItemReconstituentFluidDisplay;
	var formObjBottom	= parent.reconstituentfluid_bottom.document.frmInvItemReconstituentFluidAddModify;
	var formObj = parent.reconstituentfluid_bottom.document.frmInvItemReconstituentFluidAddModify;

	item_code			= formObjBottom.ITEM_CODE.value;
	item_desc			= formObjBottom.ITEM_DESC.value;
	content_in_base_uom = formObjBottom.CONTENT_IN_BASE_UOM.value;

	var row_num		=	parseInt(formObj.rowNum.value);
 
	var row_obj		=	"";
	row_obj		=	 parent.reconstituentfluid_middle.document.getElementById("tab").rows[row_num+2];
	
	



	row_obj.cells[0].innerHTML = "<a href='javascript:showDetail(\""+item_code+"\",\""+item_desc+"\",\""+content_in_base_uom+"\",\""+row_num+"\")'> "+item_desc+"</a><input type='hidden' name='item_code"+row_num+"' id='item_code"+row_num+"' value='"+item_code+"'>";
	row_obj.cells[1].innerHTML = content_in_base_uom+"<input type='hidden' name='content_in_base_uom"+row_num+"' id='content_in_base_uom"+row_num+"' value='"+content_in_base_uom+"'>";

	formObjBottom.butt1.value		= getLabel("Common.Add.label","Common");
	formObjBottom.butt2.value		= getLabel("Common.clear.label","Common");
	formObjBottom.ITEM_CODE.value	= "";
	formObjBottom.ITEM_DESC.value	= "";	
	formObjBottom.CONTENT_IN_BASE_UOM.value = "";
}

function AddRow(obj){


	var formObjTop		= parent.reconstituentfluid_top.formReconstituentFluid;
	var formObjMiddle	= parent.reconstituentfluid_middle.frmInvItemReconstituentFluidDisplay;
	var formObjBottom	= parent.reconstituentfluid_bottom.document.frmInvItemReconstituentFluidAddModify;
	var item_code="";
	var content_in_base_uom="";
	var message = "";
	var cfld = "0";

	var fields= new Array (parent.reconstituentfluid_bottom.document.forms[0].ITEM_CODE, parent.reconstituentfluid_bottom.document.forms[0].CONTENT_IN_BASE_UOM);

	var names= new Array (getLabel("Common.ItemCode.label","Common"), getLabel("ePH.ContentinBaseUom.label","PH"));
		
	if(formObjTop.RF_ID.value == "")
	{
		message = getMessage("FLUID_ID_CANNOT_BE_BLANK","PH")+"<BR>"; //"APP-000001 Fluid Id cannot be blank..."
		cfld = "1";
	}

	if(formObjTop.RF_NAME.value == "")
	{
		message = getMessage("FLUID_NAME_CANNOT_BE_BLANK","PH")+"<BR>";
		cfld = "1";
	}
	if(formObjTop.RF_BASE_UNIT.value == "")
	{
		message = getMessage("BASE_UNIT_CANNOT_BE_BLANK","PH")+"<BR>";
		cfld = "1";
	}

	if(cfld=="1")
	{
		parent.parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
		return false;
	}



	if(checkFieldsofMst(fields,names,parent.parent.messageFrame) ) 
	{
		item_code			= formObjBottom.ITEM_CODE.value;
		item_desc			= formObjBottom.ITEM_DESC.value;
		content_in_base_uom = formObjBottom.CONTENT_IN_BASE_UOM.value;

		//if (findDuplicate(item_code,content_in_base_uom,formObjMiddle.all.tab.rows.length,obj))
		if (findDuplicate(item_code,content_in_base_uom,parent.reconstituentfluid_middle.document.getElementById("tab").rows.length,obj))
		{
		   formObjBottom.ITEM_DESC.focus();
			return false;
		}

		
		parent.parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;

		var classval;
		
		//var row_no = formObjMiddle.all.tab.rows.length-2;
		var row_no = parent.reconstituentfluid_middle.document.getElementById("tab").rows.length-2;
		


		formObjMiddle.number_of_rows.value=row_no;

		// curr_row	=	formObjMiddle.all.tab.insertRow();
		 curr_row	=	parent.reconstituentfluid_middle.document.getElementById("tab").insertRow();


		if(row_no % 2 == 0 )
			classval	=	"QRYEVEN";
		else
			classval	=	"QRYODD";

		for(i=0; i<2; i++)	
		{	
			cell	=	curr_row.insertCell();
			if (i==0)
			{
				
				curr_row.cells[0].className	= classval;
				curr_row.cells[0].innerHTML = "<a href='javascript:showDetail(\""+item_code+"\",\""+item_desc+"\",\""+content_in_base_uom+"\",\""+row_no+"\")'> "+item_desc+"</a><input type='hidden' name='item_code"+row_no+"' id='item_code"+row_no+"' value='"+item_code+"'>";
							
			}
			else if (i==1)
			{
				curr_row.cells[1].className	= classval;
				curr_row.cells[1].innerHTML = content_in_base_uom+"<input type='hidden' name='content_in_base_uom"+row_no+"' id='content_in_base_uom"+row_no+"' value='"+content_in_base_uom+"'>";
			
			}
		}
	
		ResetToDefaultValues();	
	}
}
function rePaintTable(obj,frm)
{
	count=0;
	for (i=2;i<obj.rows.length ;i++ )
	{
//		alert(i);
		if(i % 2 == 0 )
			classval	=	"QRYEVEN";
		else
			classval	=	"QRYODD";

		
			cell1										=	obj.rows(i).cells(0);
			cell1.className								=	classval;
			item_desc									=  cell1.innerText;
			cell2										=	obj.rows(i).cells(1);
			cell2.className								=	classval;
			content_in_base_uom							=	cell2.innerText;
			//get item code and content_in_base_uom ids and change it.
pos1	=	cell1.innerHTML.indexOf("value=");
pos2	=	cell1.innerHTML.indexOf("name=");
var item_code	=	"";
if(pos1!=-1) {	
for(q=(pos1+6); q<(pos2); q++)  
	item_code	= item_code.concat(cell1.innerHTML.charAt(q));
	item_code	= trimString(item_code)
}
	if(trimString(item_code)!="") {
		cell1.innerHTML = "<a href='javascript:showDetail(\""+item_code+"\",\""+item_desc+"\",\""+content_in_base_uom+"\",\""+count+"\")'> "+item_desc+"</a><input type='hidden' name='item_code"+count+"' id='item_code"+count+"' value='"+item_code+"'>";
	} else {
		cell1.innerHTML = "<a href='javascript:showDetail(\""+item_code+"\",\""+item_desc+"\",\""+content_in_base_uom+"\",\""+count+"\")'> "+item_desc+"</a>";

	}
	cell2.innerHTML = content_in_base_uom+"<input type='hidden' name='content_in_base_uom"+count+"' id='content_in_base_uom"+count+"' value='"+content_in_base_uom+"'>";
			
		count++;
	}
}

// for duplicate check

function findDuplicate(chk_fld1,chk_fld2,max_rows,obj){

	var formObjMiddle = parent.reconstituentfluid_middle.frmInvItemReconstituentFluidDisplay;
	//var row_no = formObjMiddle.all.tab.rows.length-2;
	var row_no = parent.reconstituentfluid_middle.document.getElementById("tab").rows.length-2;
	var formObjBottom=parent.reconstituentfluid_bottom.frmInvItemReconstituentFluidAddModify;
	var old_text1="";
	if(max_rows>=1){
	  for(var i=2;i<max_rows;i++){

//var old_text1 = parent.reconstituentfluid_middle.frmInvItemReconstituentFluidDisplay.all.tab.rows[i].cells(0).innerText;

//old_text1= eval("formObjMiddle.all.item_code"+(i-2)).value;
		  
		     
		  old_text1= eval("formObjMiddle.item_code"+(i-2)).value;

//var old_text2 = parent.reconstituentfluid_middle.frmInvItemReconstituentFluidDisplay.all.tab.rows[i].cells(1).innerText;



		if(chk_fld1==old_text1){

			if (obj.value==getLabel("Common.Add.label","Common"))
			{
//				alert(getMessage("PH_DUPLICATE_CODE_EXISTS","PH"));
				message= getMessage("PH_DUPLICATE_CODE_EXISTS","PH");
	parent.parent.frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	

				ResetToDefaultValues();
				return true;
			}
			else
			{
				ResetToDefaultValues();
				return false;
			}
		}
	  }
	}
    return false;
}


// on click of clear button
function ResetToDefaultValues(){
	

	var formObj = parent.reconstituentfluid_bottom.document.frmInvItemReconstituentFluidAddModify;
	var formObjMiddle = parent.reconstituentfluid_middle.frmInvItemReconstituentFluidDisplay;
    if(parent.reconstituentfluid_bottom.document.frmInvItemReconstituentFluidAddModify.butt2.value =="Delete")
	{

		var rowNum = formObj.rowNum.value;
		//var myTab = formObjMiddle.all.tab;
		var myTab = parent.reconstituentfluid_middle.document.getElementById("tab");
		// parent.reconstituentfluid_middle.document.getElementById("tab").rows(row_num+2);
		 
//		alert("Deleting row"+rowNum);
		myTab.deleteRow(parseInt(rowNum)+2);
		//rePaintTable(formObjMiddle.all.tab,formObjMiddle);
		rePaintTable(myTab,formObjMiddle);
	
	}

	parent.reconstituentfluid_bottom.document.frmInvItemReconstituentFluidAddModify.butt1.value = getLabel("Common.Add.label","Common");
	parent.reconstituentfluid_bottom.document.frmInvItemReconstituentFluidAddModify.butt2.value = getLabel("Common.clear.label","Common");
	parent.reconstituentfluid_bottom.document.frmInvItemReconstituentFluidAddModify.ITEM_CODE.value = "";
	parent.reconstituentfluid_bottom.document.frmInvItemReconstituentFluidAddModify.ITEM_DESC.value = "";	parent.reconstituentfluid_bottom.document.frmInvItemReconstituentFluidAddModify.CONTENT_IN_BASE_UOM.value = "";
		
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function beforePost(str){
//alert("Reconstituent Fluid ::"+str);  
}

function checkIsValidForProceed( frameName, urlName ) {
	//alert(frameName.location.href);
	if ( (frameName.location.href.indexOf( urlName ) != -1) )
		return true;
	else
		return false;
}


function reset(){
	
	if(ReconstituentFluidFrame.location.href.indexOf("ReconstituentFluidFrame")!=-1)
	{
if(ReconstituentFluidFrame.reconstituentfluid_top.location.href.indexOf("ReconstituentFluidAddModify")!= -1)
		ReconstituentFluidFrame.reconstituentfluid_top.document.formReconstituentFluid.reset();
if(ReconstituentFluidFrame.frames.length > 1) 
		{
if(ReconstituentFluidFrame.reconstituentfluid_middle.location.href.indexOf("InvItemReconstituentFluidDisplay") != -1){
	var mode =  ReconstituentFluidFrame.reconstituentfluid_top.document.formReconstituentFluid.mode.value;
	if (mode =='1')
	{
		ReconstituentFluidFrame.reconstituentfluid_middle.location.href="../../ePH/jsp/InvItemReconstituentFluidDisplay.jsp?mode="+MODE_INSERT;
	}
	else{
		ReconstituentFluidFrame.reconstituentfluid_middle.document.location.reload();
	}
		
	}

if(ReconstituentFluidFrame.reconstituentfluid_bottom.location.href.indexOf("InvItemReconstituentFluidAddModify") != -1)
		ReconstituentFluidFrame.reconstituentfluid_bottom.document.frmInvItemReconstituentFluidAddModify.reset();
		}
	}
	if(ReconstituentFluidFrame.location.href.indexOf("ReconstituentFluidQueryCriteria")!=-1)
	{
		ReconstituentFluidFrame.location.href = "../../ePH/jsp/ReconstituentFluidQueryCriteria.jsp?function_id="+function_id ;
	}

}

function showDetail(code,str1, str2, rowNum)
{
	//alert("rowNum :"+rowNum);
	parent.reconstituentfluid_bottom.document.frmInvItemReconstituentFluidAddModify.ITEM_CODE.value = code;
	parent.reconstituentfluid_bottom.document.frmInvItemReconstituentFluidAddModify.ITEM_DESC.value = str1;
	parent.reconstituentfluid_bottom.document.frmInvItemReconstituentFluidAddModify.CONTENT_IN_BASE_UOM.value = str2;
	parent.reconstituentfluid_bottom.document.frmInvItemReconstituentFluidAddModify.butt1.value = getLabel("Common.Modify.label","Common");
	parent.reconstituentfluid_bottom.document.frmInvItemReconstituentFluidAddModify.butt2.value = getLabel("Common.delete.label","Common");
	parent.reconstituentfluid_bottom.document.frmInvItemReconstituentFluidAddModify.rowNum.value = rowNum
}

async function searchCode(obj)	{

	var formObj = parent.reconstituentfluid_bottom.document.frmInvItemReconstituentFluidAddModify;
	
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

/*	
   dataNameArray[0]   = "rf_id" ;
   dataValueArray[0]  = formObj.rf_id.value;
   dataTypeArray[0]   = STRING ;
*/
   
   argumentArray[0]   = formObj.SQL_PH_RECONSTITUENT_FLUID_SELECT4.value;
 

	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = obj.value ;
	argumentArray[6]   = DESC_LINK ;
	argumentArray[7]   = DESC_CODE ;
	retVal = await CommonLookup( getLabel("Common.ItemName.label","Common"), argumentArray ); 	
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != "" )  {
	formObj.ITEM_CODE.value=arr[0];

		obj.value = arr[1] ;
	//parent.reconstituentfluid_bottom.document.frmInvItemReconstituentFluidAddModify.ITEM_CODE.value=retVal[0];
		validateCode(arr[0]);

	}

}



function validateCode(item_code)	{

	uom_code	=	parent.reconstituentfluid_top.document.formReconstituentFluid.RF_BASE_UNIT.value;
	if( item_code!=null && item_code!="" )	{
		var bean_id		=	parent.reconstituentfluid_bottom.document.frmInvItemReconstituentFluidAddModify.bean_id.value;
		var bean_name	=	parent.reconstituentfluid_bottom.document.frmInvItemReconstituentFluidAddModify.bean_name.value;
		

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " item_code=\""+item_code+"\"";
		xmlStr += " base_uom=\""+uom_code+"\"";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr +=" /></root>";

		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

		xmlHttp.open("POST","ReconstituentFluidValidation.jsp",false);

		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);

	}
}

function Test1(obj){
	var fluide=obj.value;
		parent.reconstituentfluid_top.location.href = "../../ePH/jsp/ReconstituentFluidAddModify.jsp?fluide="+fluide;
}

function FluidTest(obj){
	
	    var fluid=obj.value;
		var bean_id		=	parent.reconstituentfluid_bottom.document.forms[0].bean_id.value;
		var bean_name	=	parent.reconstituentfluid_bottom.document.forms[0].bean_name.value;
        var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr += " fluid=\""+fluid+"\"";
		xmlStr += " bean_id=\""+bean_id+"\"";
		xmlStr += " bean_name=\""+bean_name+"\"";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","ReconstituentFluidValidation.jsp",false);
		xmlHttp.send(xmlDoc);
		eval(xmlHttp.responseText);
	
	}
function sample()
{

		parent.frames[2].location.href="../../ePH/jsp/InvItemReconstituentFluidAddModify.jsp";

}
function fluidCheck(obj)
{
	message = getMessage("CODE_ALREADY_EXISTS","Common");
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message+"...:"+"<b>"+obj+"</b>";	
	parent.reconstituentfluid_top.document.formReconstituentFluid.RF_ID.value="";
	parent.reconstituentfluid_top.document.formReconstituentFluid.RF_ID.focus();
}

function assignBaseUnit(obj){
	parent.reconstituentfluid_bottom.document.frmInvItemReconstituentFluidAddModify.CONTENT_IN_BASE_UOM.value = obj;
	//alert(obj);@
	parent.reconstituentfluid_bottom.document.frmInvItemReconstituentFluidAddModify.CONTENT_IN_BASE_UOM.focus();
}

function Modify(obj) {
	var rf_id=obj.cells[0].innerText;
	parent.ReconstituentFluidFrame.location.href="../../ePH/jsp/ReconstituentFluidFrame.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&rf_id="+rf_id;
}

function charsCapsSpaceDotCamasOnly()
  {
	
  if(event.keyCode >=65 && event.keyCode<=90)
	  event.keyCode = event.keyCode;
  else if(event.keyCode >=97 && event.keyCode<=122)
      event.keyCode = event.keyCode;
  else if(event.keyCode >=48 && event.keyCode<=57)
      event.keyCode = event.keyCode;
   else 
     event.keyCode=0;
  }

