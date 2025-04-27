<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<html>
<head>

<script type='text/javascript' src='../../eOT/js/OTCommon.js'></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script type='text/javascript' src='../../eOT/js/AdministrativeFunctionforAllCharges.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script language='javascript'>
var rows = new Array();
var rowLength=0;
var line_no=0;
var op_rows = new Array();
var oprowLength=0;

var personnelrows = new Array();
var personnelrowLength=0;
var specimen_rows = new Array();
var specimen_len=0;
var disposal_rows = new Array();
var disposal_len=0;
var instrument_rows = new Array();
var instrument_len=0;
var equipment_rows = new Array();
var equipment_len = 0;
var packs_rows=new Array();
var packs_len = 0;
var implants_rows = new Array();
var implants_len = 0;
var time_rows = new Array();
var time_len = 0;
var visit_pers_rows=new Array();
var visit_pers_len=0;
//For Sugery History
var diagnosis_rows = new Array();
var diagnosis_len = 0;
//for displaying the rows only one time from db(initially)
var db_flag="ON";
var splty_code="";
var TIME_AND_DETAILS_ENTERED="N";
var VISIT_PERSONEL_ENTERED="N";
var mandatory_proc=new Array();
</script>

<script language='javascript'>

 

function createXMLForOperations(){
  var rows=parent.AdminObjectCollect.op_rows;
  var bill_flag=document.forms[0].bill_flag.value;
  var len = rows.length;
  var table_name = "OT_POST_OPER_DTLS";
  var xmlString ="";


  for(var i=0;i<len;i++){
	 // here we skip the rows db_mode='L' since no modification is done (fetched records from db)
	 //if(rows[i]!=null && rows[i].db_mode!='L'){

	 if(rows[i]!=null){
		xmlString+="<PROC_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="oper_code=\""+rows[i].oper_code+"\""+" ";
		xmlString+="right_left_flag=\""+rows[i].side_applicable+"\""+" ";
		xmlString+="oper_remarks=\""+rows[i].remarks+"\""+" ";
		xmlString+="oper_line_num=\""+rows[i].line_no+"\""+" ";
		xmlString+="order_line_num=\""+rows[i].order_line_no+"\""+" ";
		xmlString+="oper_line_status=\""+rows[i].chk_status+"\""+" ";
		xmlString+="cancel_remarks=\""+rows[i].cancel_remarks+"\""+" ";
		xmlString+="bill_yn=\""+rows[i].bill_yn+"\""+" ";
		xmlString+="billed_yn=\""+rows[i].billed_yn+"\""+" ";
		 // alert("xmlString--->"+xmlString)
		xmlString+="fpp_category=\""+rows[i].fpp_category+"\""+" ";//Added Against ML-MMOH-CRF-1939-US4
		//if(bill_flag=="true")
		//{
		xmlString+="bill_str=\""+rows[i].rate+"::"+rows[i].bill_str+"\""+" ";
		xmlString+="panel_str=\""+escape(rows[i].panel_str)+"\""+" ";
		//}
		xmlString+="order_id=\""+rows[i].order_id+"\""+" ";
		xmlString+="insert_flag=\""+"Operation"+"\""+" ";
		
		if(rows[i].db_mode=="L")
			xmlString+="db_mode=\""+"U"+"\""+" ";
		else
			xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		
		//xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
	 }
  }

 return xmlString;
}


function createXMLForImplants(){
  var rows=parent.AdminObjectCollect.implants_rows;
  var table_name="OT_SURGICAL_ACCESSORIES_IMPLANTS";
  var accessory_type = "S";
  var len = rows.length;
  var xmlString ="";
  var bill_flag=document.forms[0].bill_flag.value;
  var st_interface_flag=document.forms[0].st_interface_flag.value;
  for(var i=0;i<len;i++){
  //Maheshwaran K added for the SKR-SCF-0788 [IN:039522]  as on 30/09/2013   
   //if(rows[i]!=null &&  rows[i].db_mode!='L'){
	 if((rows[i]!=null)||(rows[i]!='undefined')){
		xmlString+="<IMPL_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="oper_code=\""+rows[i].oper_code+"\""+" ";
		xmlString+="implant_code=\""+rows[i].implant_code+"\""+" ";
		xmlString+="key_line=\""+rows[i].key_line+"\""+" "; // Use this during update mode for Billing
		if(bill_flag=="true" )
		{
		xmlString+="bill_str=\""+rows[i].rate+"::"+rows[i].bill_str+"\""+" "; // Newly added by bshankar
		xmlString+="panel_str=\""+escape(rows[i].panel_str)+"\""+" "; // Newly Added by bshankar
		}
		xmlString+="oper_line_no=\""+rows[i].oper_line_no+"\""+" ";
		xmlString+="quantity=\""+rows[i].quantity+"\""+" ";
		xmlString+="reserved_qty=\""+rows[i].quantity+"\""+" ";
		xmlString+="requested_qty=\""+rows[i].requested_qty+"\""+" ";
		xmlString+="req_store_code=\""+rows[i].req_store_code+"\""+" ";
		//xmlString+="Store_desc=\""+rows[i].Store_desc+"\""+" ";
		xmlString+="sale_document_no=\""+rows[i].sale_document_no+"\""+" ";
		xmlString+="sale_document_type=\""+rows[i].sale_document_type+"\""+" ";
		xmlString+="Stockavail=\""+rows[i].Stockavail+"\""+" ";

		xmlString+="insert_flag=\""+"Accessories"+"\""+" ";
		
		
		if(st_interface_flag=="N"){
		xmlString+="manufacturer=\""+rows[i].manufacturer+"\""+" ";
		xmlString+="batch=\""+rows[i].batch+"\""+" ";
		}
		//xmlString+="remarks=\""+rows[i].remarks+"\""+" ";
		//Added encodeURIComponent on 10/19/2010 for IN023758 by AnithaJ
		xmlString+="remarks=\""+encodeURIComponent(rows[i].remarks)+"\""+" ";

		xmlString+="accessory_type=\""+accessory_type+"\""+" ";
		
		if(typeof(rows[i].frm_pick_list)=='undefined') 
		 {
		rows[i].frm_pick_list="N";
		 }
      
		xmlString+="frm_pick_list=\""+rows[i].frm_pick_list+"\""+" ";
		if(rows[i].db_mode=="L")
			xmlString+="db_mode=\""+"U"+"\""+" ";
		else
			xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
	 }
  }
  return xmlString;
}

function createXMLForPackage(){	
  var rows=parent.AdminObjectCollect.packs_rows;
  var table_name="OT_SURGICAL_ACCESSORIES_PACKAGES";
  var accessory_type = "P";
  var len = rows.length;
  var xmlString ="";
  var bill_flag=document.forms[0].bill_flag.value;
  for(var i=0;i<len;i++){
	 //if(rows[i]!=null &&  rows[i].db_mode!='L'){
	 if(rows[i]!=null){
		xmlString+="<PACK_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="oper_code=\""+rows[i].oper_code+"\""+" ";
		xmlString+="package_code=\""+rows[i].package_code+"\""+" ";
		xmlString+="key=\""+rows[i].key+"\""+" ";
		xmlString+="key_line=\""+rows[i].key_line+"\""+" "; // Use this during update mode for Billing
		if(bill_flag=="true")
		{
		xmlString+="bill_str=\""+rows[i].rate+"::"+rows[i].bill_str+"\""+" "; // Newly added by bshankar
		xmlString+="panel_str=\""+escape(rows[i].panel_str)+"\""+" "; // Newly Added by bshankar
		}
		xmlString+="oper_line_no=\""+rows[i].oper_line_no+"\""+" ";
		xmlString+="quantity=\""+rows[i].quantity+"\""+" ";
		//xmlString+="remarks=\""+checkSpl(rows[i].remarks)+"\""+" ";
		//Added encodeURIComponent on 10/19/2010 for IN023758 by AnithaJ
		xmlString+="remarks=\""+encodeURIComponent(rows[i].remarks)+"\""+" ";

		xmlString+="accessory_type=\""+accessory_type+"\""+" ";
		xmlString+="insert_flag=\""+"Accessories"+"\""+" ";
		if(typeof(rows[i].frm_pick_list)=='undefined') 
		{
		rows[i].frm_pick_list="N";
		}
      
		xmlString+="frm_pick_list=\""+rows[i].frm_pick_list+"\""+" ";
		if(rows[i].db_mode=="L")
			xmlString+="db_mode=\""+"U"+"\""+" ";
		else
			xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
	 }
  }
  //alert("xmlString")
  // alert("xmlString---->"+xmlString)
  return xmlString;
}



function createXMLForEquipments(){
  var rows=parent.AdminObjectCollect.equipment_rows;
  var table_name="OT_SURGICAL_ACCESSORIES_EQUIPMENTS";
  var accessory_type = "E";
  var len = rows.length;
  var xmlString ="";
  var bill_flag=document.forms[0].bill_flag.value;
  for(var i=0;i<len;i++){
	 //if(rows[i]!=null &&  rows[i].db_mode!='L'){
	 if(rows[i]!=null)
	 {
		//rows[i].quantity="1";// just for now after adding quantity field remove this one and pass quantity field value
		xmlString+="<EQUIP_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="oper_code=\""+rows[i].oper_code+"\""+" ";
		xmlString+="equip_code=\""+rows[i].equip_code+"\""+" ";
		xmlString+="key_line=\""+rows[i].key_line+"\""+" "; // Use this during update mode for Billing
		if(bill_flag=="true")
		{
		xmlString+="bill_str=\""+rows[i].rate+"::"+rows[i].bill_str+"\""+" "; // Newly added by bshankar
		xmlString+="panel_str=\""+escape(rows[i].panel_str)+"\""+" "; // Newly Added by bshankar
		}
		xmlString+="oper_line_no=\""+rows[i].oper_line_no+"\""+" ";
		xmlString+="equip_id=\""+rows[i].equip_id+"\""+" ";
		//xmlString+="remarks=\""+checkSpl( rows[i].remarks )+"\""+" ";
		//Added encodeURIComponent on 10/28/2010 for IN023758 by AnithaJ
		xmlString+="remarks=\""+encodeURIComponent(rows[i].remarks)+"\""+" ";
		xmlString+="desiredDate=\""+rows[i].desiredDate+"\""+" ";
		xmlString+="accessory_type=\""+accessory_type+"\""+" ";
		xmlString+="insert_flag=\""+"Accessories"+"\""+" ";
		if(typeof(rows[i].frm_pick_list)=='undefined') 
		{
		rows[i].frm_pick_list="N";
		}
		xmlString+="frm_pick_list=\""+rows[i].frm_pick_list+"\""+" ";
		xmlString+="quantity=\""+rows[i].quantity+"\""+" ";
		if(rows[i].db_mode=="L"){
			//Added Against Start AMRI-CRF-0294 [IN049121]
			if(rows[i].oper_line_status=='99'){
				xmlString+="db_mode=\""+"D"+"\""+" ";
			}else{ //Added Against End AMRI-CRF-0294 [IN049121]
			xmlString+="db_mode=\""+"U"+"\""+" ";
			} //Added Against AMRI-CRF-0294 [IN049121]
			}
		else
			xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
			xmlString+="table_name=\""+table_name+"\""+" />";		
	 }
  }
  return xmlString;
}
 function createXMLForInstruments(){
  var rows=parent.AdminObjectCollect.instrument_rows;
  var table_name="OT_SURGICAL_ACCESSORIES_INSTRUMENT";
  var accessory_type = "I";
  var len = rows.length;
  var xmlString ="";
   var bill_flag=document.forms[0].bill_flag.value;
  for(var i=0;i<len;i++){
	 //if(rows[i]!=null &&  rows[i].db_mode!='L'){
	 if(rows[i]!=null){
	    //rows[i].quantity="1";// just for now after adding quantity field remove this one and pass quantity field value
		xmlString+="<INSTR_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="oper_code=\""+rows[i].oper_code+"\""+" ";
		xmlString+="instr_code=\""+rows[i].instr_code+"\""+" ";
		xmlString+="key_line=\""+rows[i].key_line+"\""+" "; // Use this during update mode for Billing
		if(bill_flag=="true")
		{
		xmlString+="bill_str=\""+rows[i].rate+"::"+rows[i].bill_str+"\""+" "; // Newly added by bshankar
		xmlString+="panel_str=\""+escape(rows[i].panel_str)+"\""+" "; // Newly Added by bshankar
		}
		xmlString+="oper_line_no=\""+rows[i].oper_line_no+"\""+" ";
		//Encoded for CRF-0058 by Rajesh
		xmlString+="tray_no=\""+encodeURIComponent(rows[i].tray_no)+"\""+" ";
		//Encoded for CRF-0058 by Rajesh
		//xmlString+="remarks=\""+checkSpl( rows[i].remarks )+"\""+" ";
		//Added encodeURIComponent on 10/19/2010 for IN023758 by AnithaJ
		xmlString+="remarks=\""+encodeURIComponent(rows[i].remarks)+"\""+" ";

		xmlString+="quantity=\""+rows[i].quantity+"\""+" ";
		xmlString+="accessory_type=\""+accessory_type+"\""+" ";
		xmlString+="insert_flag=\""+"Accessories"+"\""+" ";
		if(typeof(rows[i].frm_pick_list)=='undefined') 
		{
		rows[i].frm_pick_list="N";
		}
		xmlString+="frm_pick_list=\""+rows[i].frm_pick_list+"\""+" ";
		
		if(rows[i].db_mode=="L")
			xmlString+="db_mode=\""+"U"+"\""+" ";
		else
			xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
	 }
  }
   return xmlString;
}

//Modified by DhanasekarV on 27/01/2011 against issue IN026046
function assignAdminFunction(param)
{
 parent.AdministrativeFucntionFrame.location.href = "../../eOT/jsp/AdministrativeFunctionforAllChargesFrame.jsp?"+param;
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<% 
String oper_num = checkForNull(request.getParameter("oper_num")); 
String bill_flag = checkForNull(request.getParameter("bill_flag")); 
String st_interface_flag = checkForNull(request.getParameter("st_interface_flag1")); 
%>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<form name="AdminCollectForm" id="AdminCollectForm">
<input type='hidden' name='oper_num' id='oper_num' value='<%=oper_num%>' >
<input type='hidden' name='bill_flag' id='bill_flag' value='<%=bill_flag%>' >
<input type='hidden' name='st_interface_flag' id='st_interface_flag' value='<%=st_interface_flag%>' >
<input type='hidden' name='slate_user_id' id='slate_user_id' value='<%=checkForNull(request.getParameter("slate_user_id"))%>' >
<input type='hidden' name='params' id='params' value='<%=request.getQueryString()%>' >
<!-- Modified by DhanasekarV on 27/01/2011 against issue IN026046   -->
<script>assignAdminFunction('<%=request.getQueryString()%>'); </script>
</form>

</body>
</html>

