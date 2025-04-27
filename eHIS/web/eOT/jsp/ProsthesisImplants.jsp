<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<HTML>
<%@ page import ="java.sql.Connection,java.sql.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.util.HashMap,eOR.OrderEntryBillingQueryBean,eOT.OTBillingBean,eST.OTTransactionBean,eST.*, org.joda.time.DateTime,eCommon.XSSRequestWrapper,eCommon.Common.*" contentType=" text/html;charset=UTF-8"  %>
<% String locale = (String)session.getAttribute("LOCALE"); 
//Added code to get seesion values in OperationEquipmentsTab.jsp for scf-5515 by Anitha on 11/25/2010
HashMap temp = new HashMap();
temp=(HashMap)session.getAttribute("NursingDetails");
%>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<%@ include file="../../eCommon/jsp/Common.jsp"%>
<%! 
	String encode(String data){	  
		String outDat = "";
		byte byteData[] = data.getBytes();
		for (int i=0; i<byteData.length; i++){
			outDat = outDat +"%"+Integer.toHexString((int)byteData[i]);
		}
		return(outDat);
   }
%>
<%
	String or_bean_id 				= "Or_billingQueryBean";
	String or_bean_name 			= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean			= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	
	String bean_id 				= "OTBillingBean";
	String bean_name 			= "eOT.OTBillingBean";
	OTBillingBean billing_bean			= (OTBillingBean)getBeanObject( bean_id, bean_name, request ) ;

	String st_bean_id 				    = "ottransactionbean";
	String st_bean_name 			    = "eST.OTTransactionBean";
	OTTransactionBean bean	= (OTTransactionBean)getBeanObject(st_bean_id, st_bean_name, request ) ;

	//String tab = checkForNull(request.getParameter("tab"));
	String tab = (String)temp.get("tab");


String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
String style = "";
				style = "color:blue;cursor:pointer";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language="JavaScript" src="../../eOT/js/RecordNursing.js"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="Javascript" src="../../framework/js/PopupWindow.js"></script>
<script language='javascript' src='../../eOT/js/jquery-latest.js'></script>
<!--MMS-QH-CRF-0199-->
<style type="text/css">
.my_dropdown {    
    width: 180px ; min-width: 100px; max-width: 200px;    
}
select:focus{width:200px !important;}
</style>

<script>
$(document).ready(function() {
	var maxLength = 30;
    $('#my_dropdown > option').text(function(i, text) {
    if (text.length > maxLength) {
        return text.substr(0, maxLength) + '...';  
        }
    });
});
</script>
<!--MMS-QH-CRF-0199-->
<script language='javascript'>

function disableSelectButton(obj)
{

 obj.disabled = true;
}
function openCheckListRemarksWindow(obj)
{

		var remarks=encodeURIComponent(document.ImplantsRecordForm.remarks.value);
		var flag="1"	;
		var size="100";
		var heading = getLabel("Common.remarks.label","common");
		var dialogHeight		= "9";
		var dialogWidth			= "32";
		var features			="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "";
		heading=encodeURIComponent(heading);
		var param='remarks='+remarks+'&heading='+heading+'&flag='+flag+'&size='+size;
		//var params=unescape(param);
		var ret=""+window.showModalDialog("../../eOT/jsp/TextArea.jsp?"+param,arguments,features);
		if(flag=='1' && ret!="undefined" ){
			ret=ret.slice(0,ret.length);
			obj.value=ret;
		}
}
function openCheckListRemarksWindow_cp(obj)
{

		var remarks=encodeURIComponent(obj.value);
		var flag="1"	;
		var size="100";
		var heading = getLabel("Common.remarks.label","common");
		var dialogHeight		= "9";
		var dialogWidth			= "32";
		var features			="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "";
		heading=encodeURIComponent(heading);
		var param='remarks='+remarks+'&heading='+heading+'&flag='+flag+'&size='+size;
		var ret=""+window.showModalDialog("../../eOT/jsp/TextArea.jsp?"+param,arguments,features);
		if(flag=='1' && ret!="undefined" ){
		ret=ret.slice(0,ret.length);
		obj.value=ret;
	}
}

function openCheckListRemarksWindow_eq(obj)
{

		var remarks=encodeURIComponent(obj.value);
		var flag="1"	;
		var size="100";
		var heading = getLabel("Common.remarks.label","common");
		var dialogHeight		= "9";
		var dialogWidth			= "32";
		var features			="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "";
		heading=encodeURIComponent(heading);
	var param='remarks='+remarks+'&heading='+heading+'&flag='+flag+'&size='+size;
//	var params=unescape(param);
	var ret=""+window.showModalDialog("../../eOT/jsp/TextArea.jsp?"+param,arguments,features);
	if(flag=='1' && ret!="undefined" ){
		ret=ret.slice(0,ret.length);
		obj.value=ret;
	}
}

function openCheckListRemarksWindow_ic(obj)
{

		var remarks=encodeURIComponent(obj.value);
		var flag="1"	;
		var size="100";
		var heading = getLabel("Common.remarks.label","common");
		var dialogHeight		= "9";
		var dialogWidth			= "32";
		var features			="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "";
		heading=encodeURIComponent(heading);
	var param='remarks='+remarks+'&heading='+heading+'&flag='+flag+'&size='+size;
//	var params=unescape(param);
	var ret=""+window.showModalDialog("../../eOT/jsp/TextArea.jsp?"+param,arguments,features);
	if(flag=='1' && ret!="undefined" ){
		ret=ret.slice(0,ret.length);
		obj.value=ret;
	}
}

function Class_row()
{
  this.oper_code ="";
  this.oper_desc="";
  this.implants_code="";
  this.implants_desc="";
  this.oper_line_no ="";
  this.manufacturer="";
  this.batch="";
  this.order="";
  this.quantity ="";
  this.remarks ="";
  this.accessory_type="";
  this.db_mode="";
  this.recId="";
  this.reserved_qty="";
  this.requested_qty="";
  this.frm_pick_list="";
  this.sale_document_no ="";
  this.sale_document_type ="";
  this.req_store_code="";
  this.Stockavail = "";
  this.bill_str="";
  this.bill_str_conspack="";
  this.panel_str="";
  this.panel_str_conspack="";
  this.key="";
  this.key_line="";
  this.rate="";
}

function Class_row_eq()
{
  this.oper_code ="";
  this.oper_desc="";
  this.equip_code="";
  this.equip_desc="";
  this.oper_line_no ="";
  this.equip_id ="";
  this.remarks ="";
  this.order="";
  this.accessory_type="";
  this.db_mode="";
  this.frm_pick_list="";
  this.recId="";
  this.bill_str="";
  this.panel_str="";
  this.key="";
  this.key_line="";
   this.rate="";
	this.desiredDate="";
}


/*function addRow(){
  var objrow = newRow();
  var msg = trimString(getMessage("CODE_ALREADY_EXISTS","Common"));
  var rows=parent.parent.parent.ObjectCollect.implants_rows;
  var index_val=rows.length+1;
  var formObj = document.forms[0];
  var params = formObj.params.value;
  var rec_implants_in_nurs_notes_yn=formObj.rec_implants_in_nurs_notes_yn.value;
  var rec_equp_in_nurs_notes_yn=formObj.rec_equp_in_nurs_notes_yn.value;
  var rec_instr_in_nurs_notes_yn=formObj.rec_instr_in_nurs_notes_yn.value;
  var rec_packs_in_nurs_notes_yn=formObj.rec_packs_in_nurs_notes_yn.value;
  var st_interface_flag=formObj.st_interface_flag.value;
  var fromval=formObj.fromval.value;
  var mode =formObj.mode.value;
   var key = formObj.oper_num.value+"@"+formObj.oper_code.value+"@I"+"@"+formObj.implant_code.value;
  var obj = formObj.operation;
  var bill_flag = formObj.bill_flag.value;

  if(chkEmpty()){
	if(mode=='I'){
	  if(alreadyExist()){
		if(bill_flag=="true")// added by sathish to disable Billing Part
		{
			if(st_interface_flag=="N" && fromval=="prosimplants")
			{
		var retVal = callOrderLineCreation(formObj.quantity.value);
		retVal=trimString(retVal);
		
		var arr = retVal.split("@@");
		if(arr[0]=="BL0639"){
			alert(getMessage("BL0639","BL"));
			return false;
		}
		
		if(localTrimString(arr[2])!='')
			{
			var err_pat=localTrimString(arr[2]);
			alert(err_pat);
			return false;
			}
			}
		}
			objrow.oper_code=formObj.oper_code.value;
			objrow.oper_desc=formObj.operation.options[obj.selectedIndex].text;
			objrow.quantity = formObj.quantity.value;
			if(st_interface_flag=="Y" && fromval=="prosimplants")
			{
			objrow.reserved_qty=formObj.Reservepicklist.value;
			objrow.requested_qty=formObj.Requestpicklist.value;
			objrow.sale_document_no = formObj.sale_document_no.value
			objrow.sale_document_type = formObj.sale_document_type.value
			objrow.Stockavail = formObj.Stockavail.value;
			objrow.Store_desc=formObj.conns_store.value;
			objrow.req_store_code=formObj.req_store_code.value;

			if(formObj.Stockavail.value =="" || formObj.Stockavail.value =="0")
							{
						alert(getMessage("PRC-OT0054","OT"));
						return false;
							}
			}
			objrow.implant_code=formObj.implant_code.value;
			objrow.implant_desc=formObj.implant_desc.value;
			objrow.oper_line_no = formObj.oper_line_no.value;
			objrow.remarks = formObj.remarks.value;
			
			
			
			if(st_interface_flag=="N")
		    {
			objrow.manufacturer = formObj.manufacturer.value;
			objrow.batch = formObj.batch.value;
			}
		    
			objrow.recId = getRecId();
			if(bill_flag=="true")
		    {
			var retVal = callOrderLineCreation(formObj.quantity.value);
			if(st_interface_flag=="N" && fromval=="prosimplants")
			{
			var arr = retVal.split("@@");
			objrow.panel_str = arr[0];
			objrow.bill_str = arr[1];
			}else
			{
				var retVal = Callbilling_ST(formObj.quantity.value,formObj.req_store_code.value,formObj.patient_id.value,formObj.encounter_id.value,formObj.patient_class.value,formObj.implant_code.value);

				objrow.bill_str = retVal;
			}
			}
			objrow.key=key;
			objrow.key_line="";
			objrow.db_mode="I";
			rows.push(objrow);
			resetFields();
			//alert("params  in pi"+params);
				//Commented by AnithaJ on 22/11/2010 for scf-5515
			//params=params+"&rec_implants_in_nurs_notes_yn="+rec_implants_in_nurs_notes_yn+"&rec_instr_in_nurs_notes_yn="+rec_instr_in_nurs_notes_yn+"&rec_packs_in_nurs_notes_yn="+rec_packs_in_nurs_notes_yn+"&rec_equp_in_nurs_notes_yn="+rec_equp_in_nurs_notes_yn+"&st_interface_flag="+st_interface_flag;

			parent.ResultsFrame.location.href='../../eOT/jsp/SurgicalAccessoriesResult.jsp?'+params;
			parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
		
	} else{
		 parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		 resetFields();
	}
	}else{
	  updateRow();
	}
  }
if(st_interface_flag=="Y" && fromval=="prosimplants")
			{
		document.forms[0].Stockavail.value="";
			}
}*/
function addRow()
{
	var objrow = newRow();
	var msg = trimString(getMessage("CODE_ALREADY_EXISTS","Common"));
	var rows=parent.parent.parent.ObjectCollect.implants_rows;
	var index_val=rows.length+1;
	var formObj = document.forms[0];
	var params = formObj.params.value;
	var rec_implants_in_nurs_notes_yn=formObj.rec_implants_in_nurs_notes_yn.value;
	var rec_equp_in_nurs_notes_yn=formObj.rec_equp_in_nurs_notes_yn.value;
	var rec_instr_in_nurs_notes_yn=formObj.rec_instr_in_nurs_notes_yn.value;
	var rec_packs_in_nurs_notes_yn=formObj.rec_packs_in_nurs_notes_yn.value;
	var st_interface_flag=formObj.st_interface_flag.value;
	var fromval=formObj.fromval.value;
	var mode =formObj.mode.value;
	var key = formObj.oper_num.value+"@"+formObj.oper_code.value+"@I"+"@"+formObj.implant_code.value;
	var obj = formObj.operation;
	var bill_flag = formObj.bill_flag.value;
	if(chkEmpty())
	{
		if(mode=='I')
		{
			if(alreadyExist())
			{
				if(bill_flag=="true")// added by sathish to disable Billing Part
				{
					if(st_interface_flag=="N" && fromval=="prosimplants")
					{
						var retVal = callOrderLineCreation(formObj.quantity.value);
						retVal=trimString(retVal);
						var arr = retVal.split("@@");
						
						//if(arr[0]=="BL0639")
						if(arr[0]=='BL0639' || (~(arr[0]).indexOf('BL0639')!=0))
						{
							alert(getMessage("BL0639","BL"));
							return false;
						}
						if(localTrimString(arr[2])!='')
						{
							var err_pat=localTrimString(arr[2]);
							alert(err_pat);
							return false;
						}
						objrow.panel_str = arr[0];
						objrow.bill_str = arr[1];
					}
					else
					{
						var retVal = Callbilling_ST(formObj.quantity.value,formObj.req_store_code.value,formObj.patient_id.value,formObj.encounter_id.value,formObj.patient_class.value,formObj.implant_code.value);
						objrow.bill_str = retVal;
					}
				}
				objrow.oper_code=formObj.oper_code.value;
				objrow.oper_desc=formObj.operation.options[obj.selectedIndex].title;//MMS-QH-CRF-0199
				objrow.quantity = formObj.quantity.value;
				if(st_interface_flag=="Y" && fromval=="prosimplants")
				{
					objrow.reserved_qty=formObj.Reservepicklist.value;
					objrow.requested_qty=formObj.Requestpicklist.value;
					objrow.sale_document_no = formObj.sale_document_no.value
					objrow.sale_document_type = formObj.sale_document_type.value
					objrow.Stockavail = formObj.Stockavail.value;
					objrow.Store_desc=formObj.conns_store.value;
					objrow.req_store_code=formObj.req_store_code.value;
					if(formObj.Stockavail.value =="" || formObj.Stockavail.value =="0")
					{
						alert(getMessage("PRC-OT0054","OT"));
						return false;
					}
				}
				objrow.implant_code=formObj.implant_code.value;
				objrow.implant_desc=formObj.implant_desc.value;
				objrow.oper_line_no = formObj.oper_line_no.value;
				objrow.remarks = formObj.remarks.value;
				if(st_interface_flag=="N")
				{
					objrow.manufacturer = formObj.manufacturer.value;
					objrow.batch = formObj.batch.value;
				}
				objrow.recId = getRecId();
	/*************   Commented    duplicate  call -  callOrderLineCreation as per site informed  performance issue
				if(bill_flag=="true")
				{
					if(st_interface_flag=="N" && fromval=="prosimplants")
					{
						var retVal = callOrderLineCreation(formObj.quantity.value);
						var arr = retVal.split("@@");
						objrow.panel_str = arr[0];
						objrow.bill_str = arr[1];
					}
					else
					{
						var retVal = Callbilling_ST(formObj.quantity.value,formObj.req_store_code.value,formObj.patient_id.value,formObj.encounter_id.value,formObj.patient_class.value,formObj.implant_code.value);
						objrow.bill_str = retVal;
					}
				}
				***************************/
				objrow.key=key;
				objrow.key_line="";
				objrow.db_mode="I";
				rows.push(objrow);
				resetFields();
				//alert("params  in pi"+params);
				//Commented by AnithaJ on 22/11/2010 for scf-5515
				//params=params+"&rec_implants_in_nurs_notes_yn="+rec_implants_in_nurs_notes_yn+"&rec_instr_in_nurs_notes_yn="+rec_instr_in_nurs_notes_yn+"&rec_packs_in_nurs_notes_yn="+rec_packs_in_nurs_notes_yn+"&rec_equp_in_nurs_notes_yn="+rec_equp_in_nurs_notes_yn+"&st_interface_flag="+st_interface_flag;
				parent.ResultsFrame.location.href='../../eOT/jsp/SurgicalAccessoriesResult.jsp?'+params;
				parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
			}
			else
			{
				parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
				resetFields();
			}
		}
		else
		{
			updateRow();
		}
	}
	if(st_interface_flag=="Y" && fromval=="prosimplants")
	{
		document.forms[0].Stockavail.value="";
	}
}

function Callbilling_ST(Qty,req_store,patient_id,encounter_id,pat_class,item_code)
{

	var formObj = document.forms[0];
	var oper_num = formObj.oper_num.value;
	//var item_code = formObj.item_id.value;
	var locale = formObj.locale.value;
	var param = "oper_num="+oper_num+"&p_Qty="+Qty+"&req_store="+req_store+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&pat_class="+pat_class+"&item_code="+item_code;
	var xmlStr ="<root></root>";
	var temp_jsp="STbillingcharges.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	return responseText;

}



function addRow_ic(){
  var objrow = newRow_ic();
  var msg = trimString(getMessage("CODE_ALREADY_EXISTS","Common"));
  var rows=parent.parent.parent.ObjectCollect.instrument_rows;
  var formObj = document.forms[0];
  var rec_implants_in_nurs_notes_yn=formObj.rec_implants_in_nurs_notes_yn.value;
  var rec_equp_in_nurs_notes_yn=formObj.rec_equp_in_nurs_notes_yn.value;
  var rec_instr_in_nurs_notes_yn=formObj.rec_instr_in_nurs_notes_yn.value;
  var rec_packs_in_nurs_notes_yn=formObj.rec_packs_in_nurs_notes_yn.value;
  var st_interface_flag=formObj.st_interface_flag.value;
  var params = formObj.params.value;
  var mode =formObj.mode.value;
  var obj = formObj.operation_ic;
  var bill_flag=document.forms[0].bill_flag.value;
  
  if(chkEmpty_ic()){
	if(mode=='I'){
	   if(alreadyExist_ic()){
		if(bill_flag=="true") // added by satihsh on 10-01-2009to diable billing part when interfaceto Patient billing check box unchecked 
		{

		var retVal = callOrderLineCreation_ic(formObj.quantity_ic.value);
		retVal=trimString(retVal);
		var arr = retVal.split("@@");
		
		//if(arr[0]=="BL0639")
		if(arr[0]=='BL0639' || (~(arr[0]).indexOf('BL0639')!=0))	
		{
			alert(getMessage("BL0639","BL"));
			return false;
		 }

		 if(localTrimString(arr[2])!='')
			{
			var err_pat=localTrimString(arr[2]);
			alert(err_pat);
			return false;
			}
		 }
		var key = formObj.oper_num.value+"@"+formObj.oper_code.value+"@S"+"@"+formObj.instr_code.value;
		objrow.oper_code=formObj.oper_code.value;
		objrow.oper_desc=formObj.operation_ic.options[obj.selectedIndex].title;//MMS-QH-CRF-0199
		objrow.instr_code=formObj.instr_code.value;
		objrow.instr_desc=formObj.instr_desc.value;
		objrow.oper_line_no = formObj.oper_line_no.value;
		objrow.tray_no = formObj.tray_no.value;
		objrow.remarks = formObj.remarks_ic.value;
		objrow.quantity = formObj.quantity_ic.value;

		objrow.recId = getRecId_ic();
        if(bill_flag=="true")
		{
		var arr = retVal.split("@@");
		objrow.panel_str = arr[0];
		objrow.bill_str = arr[1];
		}
		objrow.key=key;
		objrow.key_line="";
		objrow.db_mode="I";
		//alert('objrow '+key);
		rows.push(objrow);
		resetFields_ic();
		
	//Commented by AnithaJ on 22/11/2010 for scf-5515
	/*params=params+"&rec_implants_in_nurs_notes_yn="+rec_implants_in_nurs_notes_yn+"&rec_instr_in_nurs_notes_yn="+rec_instr_in_nurs_notes_yn+"&rec_packs_in_nurs_notes_yn="+rec_packs_in_nurs_notes_yn+"&rec_equp_in_nurs_notes_yn="+rec_equp_in_nurs_notes_yn+"&st_interface_flag="+st_interface_flag;*/
		//alert("params  "+params);

		parent.ResultsFrame.location.href='../../eOT/jsp/SurgicalAccessoriesResult.jsp?'+params;
		//alert(parent.ResultsFrame.location.href);
		parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
		
	} else{
		parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		resetFields_ic();
	}
	}else
	  updateRow_ic();	
  }
}
function addRow_cp(){
  var objrow = newRow();
  var msg = trimString(getMessage("CODE_ALREADY_EXISTS","Common"));
  var rows=parent.parent.parent.ObjectCollect.packs_rows;
  var formObj = document.forms[0];
  var params = formObj.params.value;
  var mode =formObj.mode.value;
  var obj = formObj.operation_cp;
  var bill_flag = formObj.bill_flag.value;
  var rec_implants_in_nurs_notes_yn=formObj.rec_implants_in_nurs_notes_yn.value;
  var rec_equp_in_nurs_notes_yn=formObj.rec_equp_in_nurs_notes_yn.value;
  var rec_instr_in_nurs_notes_yn=formObj.rec_instr_in_nurs_notes_yn.value;
  var rec_packs_in_nurs_notes_yn=formObj.rec_packs_in_nurs_notes_yn.value;
  var st_interface_flag=formObj.st_interface_flag.value;
   var key = formObj.oper_num.value+"@"+formObj.oper_code.value+"@C"+"@"+formObj.package_code.value;
  if(chkEmpty_cp()){
	if(mode=='I'){
	   if(alreadyExist_cp()){
		if(bill_flag=="true") //added by sathish to disable Billing Part
		{
		var retVal = callOrderLineCreation_cp(formObj.quantity_cp.value);
		retVal=trimString(retVal);
		var arr = retVal.split("@@");
		//if(arr[0]=="BL0639")
		if(arr[0]=='BL0639' || (~(arr[0]).indexOf('BL0639')!=0))
		{
			alert(getMessage("BL0639","BL"));
			return false;
		}
		if(localTrimString(arr[2])!='')
			{
			var err_pat=localTrimString(arr[2]);
			alert(err_pat);
			return false;
			}
		}
			objrow.oper_code=formObj.oper_code.value;
			objrow.oper_desc=formObj.operation_cp.options[obj.selectedIndex].title;//MMS-QH-CRF-0199
			objrow.package_code=formObj.package_code.value;
			objrow.package_desc=formObj.package_desc.value;
			objrow.oper_line_no = formObj.oper_line_no.value;
			objrow.quantity = formObj.quantity_cp.value;
			objrow.remarks = formObj.remarks_cp.value;

			objrow.recId = getRecId_copk();
			//var retVal = callOrderLineCreation();
			if(bill_flag=="true")
		    {
				
			var arr = retVal.split("@@");
			objrow.panel_str = arr[0];
			objrow.bill_str_conspack = arr[1];
		    }
			objrow.key=key;
			objrow.key_line="";
			objrow.db_mode="I";
			rows.push(objrow);
			resetFields_cp();
			
			//Commented by Anitha on 11/23/2010 for scf-5515
			//params=params+"&rec_implants_in_nurs_notes_yn="+rec_implants_in_nurs_notes_yn+"&rec_instr_in_nurs_notes_yn="+rec_instr_in_nurs_notes_yn+"&rec_packs_in_nurs_notes_yn="+rec_packs_in_nurs_notes_yn+"&rec_equp_in_nurs_notes_yn="+rec_equp_in_nurs_notes_yn+"&st_interface_flag="+st_interface_flag;
			//alert("params   in cp"+params);
			parent.ResultsFrame.location.href='../../eOT/jsp/SurgicalAccessoriesResult.jsp?'+params;
			parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='

	} else{
		parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		resetFields_cp();
	}
	}else
	  updateRow_cp();
  }
  expandselec('Conspack')
}


function updateBillingDetailsValidation(key,key_line,p_qty,implant_code,acc_type){
	var formObj = document.ImplantsRecordForm;
	var oper_code = formObj.oper_code.value;
	var locale = formObj.locale.value;
	var oper_num = formObj.oper_num.value;
	
	var order_id = "";
	var order_line_num = "";
	var param = "order_id="+order_id+"&order_line_num="+order_line_num+"&oper_code="+oper_code+"&key="+key+"&key_line="+key_line+"&locale="+locale+"&p_qty="+p_qty+"&oper_num="+oper_num+"&oper_code="+oper_code+"&acc_code="+implant_code+"&acc_type="+acc_type;
	var xmlStr ="<root></root>";
	var temp_jsp="UpdateBillingDetailsValidation.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	return responseText;


}

function DeleteKey(key){
	var xmlStr ="<root></root>";
	var temp_jsp="DeletePersistenceBeankey.jsp?del_key="+key;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	return responseText;
}


function callOrderLineCreation(quantity){
	var formObj = document.forms[0];
	var oper_num = formObj.oper_num.value;
	var implant_code = formObj.implant_code.value;
	var oper_code = (formObj.operation.value).split("##")[0];
	var param = "oper_num="+oper_num+"&acc_type=I&called_from=ACC_TAB&acc_code="+implant_code+"&oper_code="+oper_code+"&quantity="+quantity;
	var xmlStr ="<root></root>";
	var temp_jsp="OTOrderLineCreation.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	return responseText;
}
function callOrderLineCreation_cp(quantity){
	var formObj = document.forms[0];
	var oper_num = formObj.oper_num.value;
	var implant_code = formObj.package_code.value;
	var oper_code = (formObj.operation_cp.value).split("##")[0];
	var param = "oper_num="+oper_num+"&acc_type=C&called_from=ACC_TAB&acc_code="+implant_code+"&oper_code="+oper_code+"&quantity="+quantity;
	var xmlStr ="<root></root>";
	var temp_jsp="OTOrderLineCreation.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	return responseText;
}

function callOrderLineCreation_eq(quantity){
	var formObj = document.forms[0];
	var oper_num = formObj.oper_num.value;
	var implant_code = formObj.equip_code.value;
	var oper_code = (formObj.operation_eq.value).split("##")[0];
	var param = "oper_num="+oper_num+"&acc_type=E&called_from=ACC_TAB&acc_code="+implant_code+"&oper_code="+oper_code+"&quantity="+quantity;
	var xmlStr ="<root></root>";
	var temp_jsp="OTOrderLineCreation.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	return responseText;
}

function callOrderLineCreation_ic(quantity){
	var formObj = document.forms[0];
	var oper_num = formObj.oper_num.value;
	var implant_code = formObj.instr_code.value;
	var oper_code = (formObj.operation_ic.value).split("##")[0];
	var param = "oper_num="+oper_num+"&acc_type=S&called_from=ACC_TAB&acc_code="+implant_code+"&oper_code="+oper_code+"&quantity="+quantity;
	var xmlStr ="<root></root>";
	var temp_jsp="OTOrderLineCreation.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	return responseText;
}

function newRow(){
  var objrow = new Class_row();
   return(objrow);
} 
function newRow_cons(){
  var objrow = new Class_row_cons();
   return(objrow);
}  
function newRow_eq(){
  var objrow = new Class_row_eq();
   return(objrow);
} 
function newRow_ic(){
  var objrow = new Class_row_ic();
   return(objrow);
} 
function Class_row_ic(){
  this.oper_code ="";
  this.oper_desc="";
  this.instr_code="";
  this.instr_desc="";
  this.oper_line_no ="";
  this.tray_no ="";
  this.remarks ="";
  this.accessory_type="";
  this.db_mode="";
  this.recId="";
  this.order="";
  this.key="";
  this.key_line="";
  this.panel_str="";
  this.bill_str="";
  this.rate="";
  this.frm_pick_list="";

}

function Class_row_cons()
	{
	  this.oper_code ="";
	  this.oper_desc="";
	  this.package_code="";
	  this.package_desc="";
	  this.oper_line_no ="";
	  this.quantity ="";
	  this.remarks ="";
	  this.order="";
	  this.accessory_type="";
	  this.db_mode="";
	  this.recId="";
	   this.frm_pick_list="";
	  this.bill_str="";
	  this.panel_str="";
	  this.key="";
	  this.key_line="";
	  this.reserved_qty="";
	  this.requested_qty="";
	  this.req_store_code="";
	  this.rate="";
	}

function alreadyExist(){
	var formObj = document.ImplantsRecordForm;
	var codeDtl = parent.ResultsFrame.code; 
	var oper_code=formObj.oper_code.value;
	var implant_code = formObj.implant_code.value;
	var codeRecord = oper_code+implant_code;
	if(codeDtl.indexOf(codeRecord)>=0)
	   return false;
	else
	  return true;
}
function alreadyExist_eq(){
	var formObj = document.forms[0];
	var codeDtl = parent.ResultsFrame.code_eq; 
	var oper_code=formObj.oper_code.value;
	var equip_code = formObj.equip_code.value;
	var codeRecord = oper_code + equip_code + ',';
	if(codeDtl.indexOf(codeRecord)>=0)
	{
	   return false;
	}
	else{
	  return true;
	}
}
function alreadyExist_ic(){
	var formObj = document.forms[0];
	var codeDtl = parent.ResultsFrame.code_ic; 
	var oper_code=formObj.oper_code.value;
	var instr_code = formObj.instr_code.value;
	var codeRecord = oper_code+instr_code;
	if(codeDtl.indexOf(codeRecord)>=0)
	   return false;
	else
	  return true;
}
function alreadyExist_cp(){
	var formObj = document.forms[0];
	var codeDtl = parent.ResultsFrame.code_copk; 
	var oper_code=formObj.oper_code.value;
	var package_code = formObj.package_code.value;
	var codeRecord = oper_code+package_code;
	if(codeDtl.indexOf(codeRecord)>=0)
	   return false;
	else
	  return true;
}
 function assignRecId(){
	 
	var tab="<%=tab%>";
	
	if(tab !="record_surgeon")
	 {
	var rows = parent.parent.parent.ObjectCollect.implants_rows;
	var rows_copk = parent.parent.parent.ObjectCollect.packs_rows;
	var rows_eq = parent.parent.parent.ObjectCollect.equipment_rows;
	var rows_ic = parent.parent.parent.ObjectCollect.instrument_rows;
	 }else
	 {
	var rows = parent.parent.parent.ObjectCollect.implants_rows;

	 }

	

	if(tab !="record_surgeon")
	 {
	parent.parent.parent.parent.ObjectCollect.implants_len=rows.length;
	parent.parent.parent.parent.ObjectCollect.packs_len=rows_copk.length;
	//alert('rows_eq.length '+rows_eq.length);
	parent.parent.parent.parent.ObjectCollect.equipment_len=rows_eq.length;
	parent.parent.parent.parent.ObjectCollect.instrument_len=rows_ic.length;
	 }else
	 {
		 	parent.parent.parent.parent.ObjectCollect.implants_len=rows.length;

	 }


	
}

function getRecId(){
    var rowLength=parent.parent.parent.parent.ObjectCollect.implants_len;
	var recId = rowLength+1;
	parent.parent.parent.parent.ObjectCollect.implants_len = recId;
	return recId;
}
// commented by DhanasekarV against issue IN026038 on 24/01/2011
/*function getRecId_copk(){
    var rowLength_copk=parent.parent.parent.parent.ObjectCollect.packs_len;
	var recId_copk = rowLength_copk+2;
	parent.parent.parent.parent.ObjectCollect.packs_len = recId_copk;
	return recId_copk;
}

function getRecId_eq(){
    var rowLength_copk=parent.parent.parent.parent.ObjectCollect.equipment_len;
	alert('getRecId eq '+rowLength_copk);
	var recId_eq = rowLength_copk+2;
	parent.parent.parent.parent.ObjectCollect.equipment_len = recId_eq;
	return recId_eq;
}

function getRecId_ic(){
    var rowLength_copk=parent.parent.parent.parent.ObjectCollect.instrument_len;
	var recId_ic = rowLength_copk+2;
	parent.parent.parent.parent.ObjectCollect.instrument_len = recId_ic;
	return recId_ic;
}*/

function getRecId_copk(){
    var rowLength_copk=parent.parent.parent.parent.ObjectCollect.packs_len;
	var recId_copk = rowLength_copk+1;
	parent.parent.parent.parent.ObjectCollect.packs_len = recId_copk;
	return recId_copk;
}

function getRecId_eq(){
    var rowLength_copk=parent.parent.parent.parent.ObjectCollect.equipment_len;
	//alert('getRecId eq '+rowLength_copk);
	var recId_eq = rowLength_copk+1;
	parent.parent.parent.parent.ObjectCollect.equipment_len = recId_eq;
	return recId_eq;
}

function getRecId_ic(){
    var rowLength_copk=parent.parent.parent.parent.ObjectCollect.instrument_len;
	var recId_ic = rowLength_copk+1;
	parent.parent.parent.parent.ObjectCollect.instrument_len = recId_ic;
	return recId_ic;
}



function chkEmpty(){
	var formObj = document.ImplantsRecordForm;
	var st_interface_flag=formObj.st_interface_flag.value;
	var operation			=getLabel("Common.operation.label","Common");
	var implant				=getLabel("Common.Implant.label","Common");
	var consum_store		=getLabel("eOT.ConsumptionStore.Label","OT");
	var no_of_units		=getLabel("eOT.ActualUnits.Label","OT");

if(st_interface_flag =="Y")
	{
	var fields = new Array(formObj.operation,formObj.implant_desc,formObj.conns_store,formObj.quantity);
	var names = new Array(operation,implant,consum_store,no_of_units);
	}else
	{
	var fields = new Array(formObj.operation,formObj.implant_desc,formObj.quantity);
	var names = new Array(operation,implant,no_of_units);
	}
	var messageFrame = parent.parent.parent.parent.messageFrame;
	if(checkFields( fields, names, messageFrame))
		return true;
}
function chkEmpty_eq(){
	var formObj = document.ImplantsRecordForm;
	var operation			=getLabel("Common.operation.label","Common");
	var equipment			=getLabel("Common.equipment.label","Common");
	var no_of_units		=getLabel("eOT.ActualUnits.Label","OT");
	var desiredDate = getLabel("eOT.DateTime.label","OT");//047546
	var customer_id = document.forms[0].customer_id.value;
		var fields = new Array(formObj.operation_eq, formObj.equip_desc, formObj.quantity_eq, formObj.desiredDate);
		var names = new Array(operation, equipment, no_of_units, desiredDate);
	var messageFrame = parent.parent.parent.parent.messageFrame;
	if(checkFieldsOt(fields, names, messageFrame))
		return true;
}

function chkEmpty_ic(){
	var formObj = document.ImplantsRecordForm;
	var operation			=getLabel("Common.operation.label","Common");
	var instrument			=getLabel("Common.Instrument.label","Common");
	var no_of_units		=getLabel("eOT.ActualUnits.Label","OT");

	var fields = new Array(formObj.operation_ic,formObj.instr_desc,formObj.quantity_ic);
	var names = new Array(operation,instrument,no_of_units);
	var messageFrame = parent.parent.parent.parent.messageFrame;
	if(checkFields( fields, names, messageFrame))
		return true;
}
function chkEmpty_cp(){
	var formObj = document.ImplantsRecordForm;
		var operation			=getLabel("Common.operation.label","Common");
		var package_cp			=getLabel("Common.Package.label","Common");
		var no_of_units		=getLabel("eOT.ActualUnits.Label","OT");

	var fields = new Array(formObj.operation_cp,formObj.package_desc,formObj.quantity_cp);
	var names = new Array(operation,package_cp,no_of_units);
	var messageFrame = parent.parent.parent.messageFrame;
	if(checkFields( fields, names, messageFrame))
		return true;
}


function removeRow(){
var formObj = document.ImplantsRecordForm;
var params = formObj.params.value;
var rows=parent.parent.parent.ObjectCollect.implants_rows;
var recId = document.forms[0].recId.value;
var mode = document.forms[0].mode.value;



if(rows.length>0 && mode=='U'){        
  for(var  jj=rows.length; jj>-1; jj--){
	 if(rows[jj]!=null){
		if(rows[jj].recId==recId){

			DeleteKey(rows[jj].key+rows[jj].key_line);
			 if( (rows[jj].db_mode=='L' || rows[jj].db_mode=='U') && (rows[jj].order=='1' ) )
			{
				rows[jj].db_mode='D';
			}
			 else
			{
				
			  delete rows[jj];
			}
				
			   break;
		}
	 }else
	continue;
 }//end for-Lo op
 resetFields();
 parent.ResultsFrame.location.href='../../eOT/jsp/SurgicalAccessoriesResult.jsp?'+params;
 parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
}else
   resetFields();
}
function removeRow_cp(){
var formObj = document.forms[0];
var params = formObj.params.value;
var rows=parent.parent.parent.ObjectCollect.packs_rows;
var recId = document.forms[0].recId.value;
var mode = document.forms[0].mode.value;
if(rows.length>0 && mode=='U'){ 

  for(var  jj=rows.length; jj>-1; jj-- ){
	 if(rows[jj]!=null){
		if(rows[jj].recId==recId){
			
			DeleteKey(rows[jj].key+rows[jj].key_line);
			 if( (rows[jj].db_mode=='L' || rows[jj].db_mode=='U') && (rows[jj].order=='1' ) )
			{
			rows[jj].db_mode='D';
			}
			 else
			{
				  
			delete rows[jj];
			}
			   break;
		}
	 }else
	continue;
 }//end for-Loop
 resetFields_cp();
 parent.ResultsFrame.location.href='../../eOT/jsp/SurgicalAccessoriesResult.jsp?'+params;
 parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
}else
   resetFields_cp();
}

function removeRow_eq(){
var formObj = document.ImplantsRecordForm;
var params = formObj.params.value;
var rows=parent.parent.parent.ObjectCollect.equipment_rows;
var recId = document.forms[0].recId.value;
var mode = document.forms[0].mode.value;

if(rows.length>0 && mode=='U'){        
  for(var  jj=rows.length; jj>-1; jj--){
	 if(rows[jj]!=null){
		if(rows[jj].recId==recId){
			DeleteKey(rows[jj].key+rows[jj].key_line);
			 if( (rows[jj].db_mode=='L' || rows[jj].db_mode=='U') && (rows[jj].order=='1' ) )
			 rows[jj].db_mode='D';
			else
			  delete rows[jj];
			  break;		   
		}
	 }else
	continue;
 }//end for-Loop
 resetFields_eq();
 parent.ResultsFrame.location.href='../../eOT/jsp/SurgicalAccessoriesResult.jsp?'+params;
 parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
}else
   resetFields_eq();
}

function removeRow_ic()
{
var formObj = document.ImplantsRecordForm;
var params = formObj.params.value;
var rows=parent.parent.parent.ObjectCollect.instrument_rows;
var recId = document.forms[0].recId.value;
var mode = document.forms[0].mode.value;
if(rows.length>0 && mode=='U' )
{
  for(var  jj=rows.length; jj>-1; jj--)
  {
	 if(rows[jj]!=null)
	 {
		if(rows[jj].recId==recId)
		{
			DeleteKey(rows[jj].key+rows[jj].key_line);
			if( (rows[jj].db_mode=='L' || rows[jj].db_mode=='U') && (rows[jj].order=='1' ) )
				rows[jj].db_mode='D';
			 else
			  delete rows[jj];
			   break;
		}
	 }else
	continue;
 }//end for-Loop
 resetFields_ic();
 parent.ResultsFrame.location.href='../../eOT/jsp/SurgicalAccessoriesResult.jsp?'+params;
 parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
}else
   resetFields_ic();
}


function updateRow(){

	var formObj			= document.ImplantsRecordForm;
	var rec_implants_in_nurs_notes_yn=formObj.rec_implants_in_nurs_notes_yn.value;
	var rec_equp_in_nurs_notes_yn=formObj.rec_equp_in_nurs_notes_yn.value;
	var rec_instr_in_nurs_notes_yn=formObj.rec_instr_in_nurs_notes_yn.value;
	var rec_packs_in_nurs_notes_yn=formObj.rec_packs_in_nurs_notes_yn.value;
	var st_interface_flag=formObj.st_interface_flag.value;
	var fromval=formObj.fromval.value;

	var params			= formObj.params.value;
	var	implant_code	= formObj.implant_code.value;
	var	implant_desc	= formObj.implant_desc.value;
	var	quantity		= formObj.quantity.value;
	if(st_interface_flag=="N")
	{
	var mfr				= formObj.manufacturer.value;
	var batch			= formObj.batch.value;
	}
	var	remarks			= formObj.remarks.value;
	var mode			= formObj.mode.value;
	var recId			= formObj.recId.value;
    var	oper_code		= formObj.oper_code.value;                          
	var oper_desc		= formObj.operation.options[formObj.operation.selectedIndex].text;
	var line_no			= formObj.oper_line_no.value;
	var rows			= parent.parent.parent.ObjectCollect.implants_rows;
	var bill_flag       = formObj.bill_flag.value;
	

		if(rows.length>0 && mode=='U'){        
			for(var jj=0;jj<rows.length;jj++){
				if(rows[jj]!=null) {
					if(rows[jj].recId==recId){
						var new_bill_str = "";
						var new_panel_str = "";
						if(mode=="U" && bill_flag=="true"){

							if(st_interface_flag=="N" && fromval=="prosimplants")
						{
														
							var result = updateBillingDetailsValidation(rows[jj].key,rows[jj].key_line,quantity,implant_code,"I");
							
							var result_arr = result.split("OTMS_SEP");
							new_bill_str = result_arr[0];
							new_panel_str = result_arr[1];
							
			}else
		{
				
				
							
							var retVal = Callbilling_ST(formObj.quantity.value,formObj.req_store_code.value,formObj.patient_id.value,formObj.encounter_id.value,formObj.patient_class.value,formObj.implant_code.value);
							
							new_bill_str = retVal;
		}
						}

						rows[jj].quantity=quantity;

						if(st_interface_flag=="Y")
						{
						rows[jj].reserved_qty=formObj.Reservepicklist.value;
			            rows[jj].requested_qty=formObj.Requestpicklist.value;
			            rows[jj].req_store_code=formObj.req_store_code.value;
						rows[jj].Store_desc=formObj.conns_store.value;
			            rows[jj].Stockavail=formObj.Stockavail.value;
						if(formObj.Stockavail.value =="" || formObj.Stockavail.value =="0")
							{
						alert(getMessage("PRC-OT0054","OT"));
						return false;
							}

						}
						if(st_interface_flag=="N")
	                    {
						rows[jj].manufacturer=mfr;
						rows[jj].batch=batch;
						}
						rows[jj].remarks=remarks;
			            if(rows[jj].db_mode=='L' && rows[jj].order=='1'){
							rows[jj].db_mode='U';
						}else if(rows[jj].db_mode=='L' && rows[jj].order=='2'){
							rows[jj].db_mode='I';
						}else if(rows[jj].db_mode=='L' || rows[jj].db_mode=="I" && rows[jj].order=='3'){
							rows[jj].oper_code=oper_code;
							rows[jj].oper_desc=oper_desc;
							rows[jj].oper_line_no=line_no;
							rows[jj].db_mode='I';
						}
						if(bill_flag=="true")
						{
							if(st_interface_flag=="N" && fromval=="prosimplants")
						{
						rows[jj].panel_str = new_panel_str;
						rows[jj].bill_str = new_bill_str;
						}else
						{
						rows[jj].bill_str = new_bill_str;
						}
						}
						break;
					}
		         }else  
			continue;
		 }
      resetFields();
 parent.ResultsFrame.location.href='../../eOT/jsp/SurgicalAccessoriesResult.jsp?'+params;
 parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
 }
}

function updateRow_cp(){
	var formObj = document.ImplantsRecordForm;
	var params = formObj.params.value;
	var	package_code=formObj.package_code.value;
	var	package_desc=formObj.package_desc.value;
	var	quantity = formObj.quantity_cp.value;
	var	remarks = formObj.remarks_cp.value;
	var mode =formObj.mode.value;
	var recId = formObj.recId.value;
	var bill_flag       = formObj.bill_flag.value;
	var rows=parent.parent.parent.ObjectCollect.packs_rows;
		if(rows.length>0 && mode=='U'){        
			for(var jj=0;jj<rows.length;jj++){
				if(rows[jj]!=null) {

					if(rows[jj].recId==recId){
						var new_bill_str = "";
						var new_panel_str = "";
						if(mode=="U" && bill_flag=="true"){
							
							var result = updateBillingDetailsValidation(rows[jj].key,rows[jj].key_line,quantity,package_code,"C");
							
							var result_arr = result.split("OTMS_SEP");
							new_bill_str = result_arr[0];
							new_panel_str = result_arr[1];
						
						}	
			            rows[jj].quantity=quantity;
						rows[jj].remarks=remarks;
			            if(rows[jj].db_mode=='L' && rows[jj].order=='1'){
							rows[jj].db_mode='U';
						}else if(rows[jj].db_mode=='L' && rows[jj].order=='2'){
							rows[jj].db_mode='I';
						}else if(rows[jj].db_mode=='L' && rows[jj].order=='3'){
							rows[jj].db_mode='I';
						}
						if(bill_flag=="true")
						{
						rows[jj].panel_str = new_panel_str;
						rows[jj].bill_str_conspack = new_bill_str;
						}
						break;
					}
		         }else  
			continue;
		 }
			resetFields_cp();

 parent.ResultsFrame.location.href='../../eOT/jsp/SurgicalAccessoriesResult.jsp?'+params;
 parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
 }
}

function updateRow_eq(){
	var formObj = document.ImplantsRecordForm;
	var params = formObj.params.value;
	var	equip_code=formObj.equip_code.value;
	var	equip_desc=formObj.equip_desc.value;
	var	equip_id = formObj.equip_id.value;
	var	quantity = formObj.quantity_eq.value;
	var	remarks = formObj.remarks_eq.value;
	var mode =formObj.mode.value;
	var bill_flag       = formObj.bill_flag.value;
	var recId = formObj.recId.value;
	var desiredDate = '';
	if(formObj.desiredDate != null)
		desiredDate = formObj.desiredDate.value;

	var rows=parent.parent.parent.ObjectCollect.equipment_rows;

	if(rows.length>0 && mode=='U')
	{
		for(var jj=0;jj<rows.length;jj++)
		{
			if(rows[jj] != null)
			{
				if(rows[jj].recId == recId)
				{
							var new_bill_str = "";
						var new_panel_str = "";
					if(mode=="U" && bill_flag=="true")
					{
							var result = updateBillingDetailsValidation(rows[jj].key,rows[jj].key_line,quantity,equip_code,"E");
							var result_arr = result.split("OTMS_SEP");
							new_bill_str = result_arr[0];
							new_panel_str = result_arr[1];
						}
			            rows[jj].equip_id=equip_id;
						rows[jj].remarks=remarks;
						rows[jj].quantity=quantity;
					rows[jj].desiredDate=desiredDate;
					if(rows[jj].db_mode=='L' && rows[jj].order=='1')
							rows[jj].db_mode='U';
					else if(rows[jj].db_mode=='L' && rows[jj].order=='2')
							rows[jj].db_mode='I';
					else if(rows[jj].db_mode=='L' && rows[jj].order=='3')
							rows[jj].db_mode='I';
							if(bill_flag=="true")
						{
						rows[jj].panel_str = new_panel_str;
						rows[jj].bill_str = new_bill_str;
						}
						break;
					}
			}
			else  
			continue;
		 }
      resetFields_eq();
	 parent.ResultsFrame.location.href='../../eOT/jsp/SurgicalAccessoriesResult.jsp?'+params;
     parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
	}
}

function updateRow_ic(){
	var formObj = document.ImplantsRecordForm;
	var params = formObj.params.value;
	var	instr_code=formObj.instr_code.value;
	var	instr_desc=formObj.instr_desc.value;
	var	tray_no = formObj.tray_no.value;
	var	quantity = formObj.quantity_ic.value;
	var	remarks = formObj.remarks_ic.value;
	var oper_line_no = formObj.oper_line_no.value;
	var mode =formObj.mode.value;
	var recId = formObj.recId.value;
	var bill_flag       = formObj.bill_flag.value;
	var rows=parent.parent.parent.ObjectCollect.instrument_rows;
		if(rows.length>0 && mode=='U'){        
			for(var jj=0;jj<rows.length;jj++){
				if(rows[jj]!=null) {
					if(rows[jj].recId==recId){
							var new_bill_str = "";
						var new_panel_str = "";
						if(mode=="U" && bill_flag=="true"){
						
							var result = updateBillingDetailsValidation(rows[jj].key,rows[jj].key_line,quantity,instr_code,"S");
							
							var result_arr = result.split("OTMS_SEP");
							new_bill_str = result_arr[0];
							new_panel_str = result_arr[1];
						
						}
						rows[jj].tray_no=tray_no;
						rows[jj].remarks=remarks;
						rows[jj].quantity=quantity;
						if(rows[jj].db_mode=='L' && rows[jj].order=='1'){
							rows[jj].db_mode='U';
						}else if(rows[jj].db_mode=='L' && (rows[jj].order=='2' || rows[jj].order=='3' ) ){
							rows[jj].db_mode='I';
						}
							if(bill_flag=="true")
						{
							
						rows[jj].panel_str = new_panel_str;
						rows[jj].bill_str = new_bill_str;
						}
						break;
      				}
		         }else  
			continue;
		 }
      resetFields_ic();
	 parent.ResultsFrame.location.href='../../eOT/jsp/SurgicalAccessoriesResult.jsp?'+params;
     parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
}
}

function splitString(strVal){
    var arr = strVal.split('::');
	var formObj = document.ImplantsRecordForm;
	var st_interface_flag=formObj.st_interface_flag.value
	formObj.oper_code.value=arr[0];
	formObj.operation.value=arr[1];
	formObj.oper_line_no.value = arr[2];
	formObj.implant_code.value=arr[3];
	formObj.implant_desc.value=arr[4];
	formObj.quantity.value=arr[5];
	if(st_interface_flag=="N")
	{
	formObj.manufacturer.value=arr[6];
	formObj.batch.value=arr[7];
	}
	formObj.remarks.value=arr[8];
	formObj.recId.value = arr[9];
	formObj.mode.value = arr[10];
	if(st_interface_flag =="Y")
	{
	formObj.Reservepicklist.value = arr[12];
	formObj.Requestpicklist.value = arr[13];
	formObj.req_store_code.value = arr[14];
	formObj.Stockavail.value = arr[15];
	formObj.conns_store.value = arr[16];
	formObj.Stockavail.disabled=true;
	}

	formObj.operation.disabled=true;
	formObj.btn_cancel.disabled=false;
	formObj.ImplantLookUp.disabled=true;
	formObj.implant_desc.disabled=true;
	
}

function splitString_cp(strVal){
    var arr = strVal.split('::');
	var formObj = document.ImplantsRecordForm;
	formObj.oper_code.value=arr[0];
	formObj.operation_cp.value=arr[1];
	formObj.oper_line_no.value = arr[2];
	formObj.package_code.value=arr[3];
	formObj.package_desc.value=arr[4];
	formObj.remarks_cp.value=arr[5];
	formObj.quantity_cp.value=arr[6];
	formObj.recId.value = arr[7];
	formObj.mode.value = arr[8];
	formObj.operation_cp.disabled=true;
	formObj.PackageLookUp.disabled=true;
	formObj.package_desc.disabled=true;
	
}
function splitString_eq(strVal){
    var arr = strVal.split('::');
	var equip_code_id=(arr[6]==null ||arr[6]=="" )?arr[3]:arr[6];//Added by MuthuN against 39535 on 13/05/2013
	var formObj = document.forms[0];
	var customer_id =formObj.customer_id.value;
	formObj.oper_code.value=arr[0];
	formObj.operation_eq.value=arr[1];
	formObj.oper_line_no.value = arr[2];
	formObj.equip_code.value=arr[3];
	formObj.equip_desc.value=arr[4];
	formObj.remarks_eq.value=arr[5];
	formObj.equip_id.value=equip_code_id;//Added by MuthuN against 39535 on 13/05/2013
	formObj.recId.value = arr[7];
	formObj.mode.value = arr[8];
	formObj.quantity_eq.value = arr[9];
	if(customer_id == "RTN")
	formObj.st_location.value = arr[10];
	formObj.operation_eq.disabled=true;
	formObj.EquipmentLookUp.disabled=true;
	formObj.equip_desc.disabled=true;
	if(customer_id == "RTN")
	{
	if(formObj.st_location.value == "undefined")
			formObj.st_location.value='';
		else
		{
			formObj.st_location.value = arr[10];
			formObj.st_location.disabled=true;
		}
		if(formObj.desiredDate.value == "undefined")
			formObj.desiredDate.value='';
		else
			formObj.desiredDate.value = arr[11];
	}
	else
	{
		if(formObj.desiredDate.value == "undefined")
			formObj.desiredDate.value='';
		else
			formObj.desiredDate.value = arr[10];
	}
		formObj.equip_id.value=equip_code_id;//Added by MuthuN against 39535 on 13/05/2013
		formObj.equip_id.disabled=true;//Added by Rameez for equipment issue on 02/05/2013
}

function splitString_ic(strVal){
    var arr = strVal.split('::');
	var formObj = document.forms[0];
	formObj.oper_code.value=arr[0];
	formObj.operation_ic.value=arr[1];
	formObj.oper_line_no.value = arr[2];
	formObj.instr_code.value=arr[3];
	formObj.instr_desc.value=arr[4];
	formObj.remarks_ic.value=arr[5];
	formObj.tray_no.value=arr[6];
	formObj.recId.value = arr[7];
	formObj.mode.value = arr[8];
	formObj.quantity_ic.value = arr[9];
	formObj.operation_ic.disabled=true;
	formObj.InstrumentLookUp.disabled=true;
	formObj.instr_desc.disabled=true;
}
function resetFields(){
	var formObj = document.ImplantsRecordForm;
	var st_interface_flag=formObj.st_interface_flag.value;
	formObj.implant_desc.value='';
	formObj.quantity.value='';
	if(st_interface_flag=="N")
	{
	formObj.manufacturer.value='';
	formObj.batch.value='';
	}else
	{
	formObj.Reservepicklist.value='';
	formObj.Requestpicklist.value='';
	formObj.conns_store.value='';
	formObj.Stockavail.value="";
	}
	formObj.mode.value='I';
	// DhanasekarV modified for IN023814   - Remarks value is unchanged  remarks =''
	formObj.remarks.value='';
	formObj.operation.disabled=false;
    formObj.operation.focus();
	formObj.ImplantLookUp.disabled=false;
	formObj.implant_desc.disabled=false;
	formObj.btn_cancel.disabled=false

}
function resetFields_eq(){
	var formObj = document.forms[0];
	var customer_id = document.forms[0].customer_id.value;
	formObj.equip_code.value='';
	formObj.equip_desc.value='';
	formObj.oper_code.value='';
	formObj.equip_id.value='';
		formObj.desiredDate.value='';
	if (customer_id =="RTN")
		formObj.st_location.value='';
	formObj.mode.value='I';
	// DhanasekarV modified for IN023814   - Remarks value is unchanged  remarks =''
	formObj.remarks_eq.value='';
	formObj.quantity_eq.value='';	
	formObj.operation_eq.disabled=false;
	formObj.EquipmentLookUp.disabled=false;
	formObj.equip_desc.disabled=false;
    formObj.operation_eq.focus();
}

function resetFields_ic(){
	var formObj = document.forms[0];
	formObj.instr_code.value='';
	formObj.instr_desc.value='';
	formObj.oper_line_no.value='';
	formObj.oper_code.value='';
	formObj.tray_no.value='';
	formObj.remarks_ic.value='';
	formObj.mode.value='I';
	formObj.quantity_ic.value='';
	formObj.operation_ic.disabled=false;
	formObj.InstrumentLookUp.disabled=false;
	formObj.instr_desc.disabled=false;
    formObj.operation_ic.focus();
		
}
function resetFields_cp(){
	var formObj = document.forms[0];
	formObj.package_code.value='';
	formObj.package_desc.value='';
	formObj.oper_code.value='';
	formObj.oper_line_no.value='';
	formObj.quantity_cp.value='';
	formObj.remarks_cp.value='';
	formObj.mode.value='I';
	formObj.operation_cp.disabled=false;
	formObj.PackageLookUp.disabled=false;
	formObj.package_desc.disabled=false;
    formObj.operation_cp.focus();
	
}
function setOperLineNumber(line_no){
   var frmObj = parent.parent.ObjectCollect;
   if(frmObj.line_no==0){
		frmObj.line_no = parseInt(line_no,10);
   }
}

function getOperLineNumber(){
   frmObj = parent.parent.ObjectCollect;
   var line_no= frmObj.line_no + 1;
   parent.parent.ObjectCollect.line_no = line_no;
   return line_no;
}

function loadCodes()
{
	var formObj = document.ImplantsRecordForm;
	parent.ResultsFrame.location.reload();
}

function assignCodes(obj){
	var formObj=document.ImplantsRecordForm;
	var codes =  obj.value;
    var arr = codes.split("##");
	formObj.oper_code.value=arr[0];
	formObj.oper_line_no.value=arr[1];
}

function assignCodes_eq(obj){
	var formObj=document.ImplantsRecordForm;
	var codes =  obj.value;
    var arr = codes.split("##");
	formObj.oper_code.value=arr[0];
	formObj.oper_line_no.value=arr[1];
}

function assignCodes_ic(obj){
	var formObj = document.ImplantsRecordForm;
	var codes =  obj.value;
    var arr = codes.split("##");
	formObj.oper_code.value=arr[0];
	formObj.oper_line_no.value=arr[1];
}
function assignCodes_cp(obj){
	var formObj = document.ImplantsRecordForm;
	var codes =  obj.value;
    var arr = codes.split("##");
	formObj.oper_code.value=arr[0];
	formObj.oper_line_no.value=arr[1];
}
function localTrimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}

function addRow_eq()
{
  var objrow = newRow_eq();
  var customer_id = document.forms[0].customer_id.value;
  var msg = trimString(getMessage("CODE_ALREADY_EXISTS","Common"));
  var rows=parent.parent.parent.ObjectCollect.equipment_rows;
  var formObj = document.ImplantsRecordForm;
  var rec_implants_in_nurs_notes_yn=formObj.rec_implants_in_nurs_notes_yn.value;
  var rec_equp_in_nurs_notes_yn=formObj.rec_equp_in_nurs_notes_yn.value;
  var rec_instr_in_nurs_notes_yn=formObj.rec_instr_in_nurs_notes_yn.value;
  var rec_packs_in_nurs_notes_yn=formObj.rec_packs_in_nurs_notes_yn.value;
  var st_interface_flag=formObj.st_interface_flag.value;
  var params = formObj.params.value;
  var mode =formObj.mode.value;
  
  var obj = formObj.operation_eq;
  var chkDateRangeValidityFlag = true;
  var bill_flag=document.forms[0].bill_flag.value;
	chkDateRangeValidityFlag = chkDateRangeValidity(formObj.desiredDate.value);
  var key = formObj.oper_num.value+"@"+formObj.oper_code.value+"@E"+"@"+formObj.equip_code.value;


	if(chkEmpty_eq())
	{
		if(chkDateRangeValidityFlag)
		{
			if(mode=='I')
			{
				if(alreadyExist_eq())
				{
		if(bill_flag=="true")  // added by sathish to disable Billing part
		{
		var retVal =callOrderLineCreation_eq(formObj.quantity_eq.value);
		retVal=trimString(retVal);
		var arr = retVal.split("@@");
						//if(arr[0]=="BL0639")
						if(arr[0]=='BL0639' || (~(arr[0]).indexOf('BL0639')!=0))	
						{
			alert(getMessage("BL0639","BL"));
			return false;
		}
		if(localTrimString(arr[2])!='')
			{
			var err_pat=localTrimString(arr[2]);
			alert(err_pat);
			return false;
			}
		}
			objrow.oper_code=formObj.oper_code.value;
			objrow.oper_desc=formObj.operation_eq.options[obj.selectedIndex].title;//MMS-QH-CRF-0199
			objrow.equip_code=formObj.equip_code.value;
			objrow.equip_desc=formObj.equip_desc.value;
			objrow.oper_line_no = formObj.oper_line_no.value;
						objrow.desiredDate = formObj.desiredDate.value;
			if (customer_id == "RTN")
				objrow.st_location = formObj.st_location.value;
			objrow.equip_id = formObj.equip_id.value;			
			objrow.remarks = formObj.remarks_eq.value;
			objrow.quantity = formObj.quantity_eq.value;		
			objrow.recId = getRecId_eq();
			objrow.db_mode="I";
			if(bill_flag=="true")
		    {
			var arr = retVal.split("@@");
			objrow.panel_str = arr[0];
			objrow.bill_str = arr[1];
			}
			objrow.key=key;
			objrow.key_line="";
			rows.push(objrow);
			resetFields_eq();

			//Commented by AnithaJ on 22/11/2010 for scf-5515
			//params=params+"&rec_implants_in_nurs_notes_yn="+rec_implants_in_nurs_notes_yn+"&rec_instr_in_nurs_notes_yn="+rec_instr_in_nurs_notes_yn+"&rec_packs_in_nurs_notes_yn="+rec_packs_in_nurs_notes_yn+"&rec_equp_in_nurs_notes_yn="+rec_equp_in_nurs_notes_yn+"&st_interface_flag="+st_interface_flag;

			parent.ResultsFrame.location.href='../../eOT/jsp/SurgicalAccessoriesResult.jsp?'+params;
			parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
				}
				else
				{
		parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
			resetFields_eq();
	}
			}
			else
	  updateRow_eq();	  
  }
}
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="loadCodes();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name = 'ImplantsRecordForm'>
<%
	String rec_implants_in_nurs_notes_yn="";
	String rec_equp_in_nurs_notes_yn="";
	String rec_instr_in_nurs_notes_yn="";
	String rec_packs_in_nurs_notes_yn="";
	String st_interface_flag="";
	String st_doc_type_rti="";
	String st_doc_type_sli="";
	String frm_pick_list="";

	char fromvalFlag  = 'N';
%>
<input type='hidden' name='params' id='params' value='<%=request.getQueryString()%>' >
<input type='hidden' name='tab' id='tab' value="<%=tab%>">

<%  
	String p_qty = "";
	String st_location ="";//Added for CRF 091
	String desiredDate = "";
	String from_val_overload = request.getParameter("from_val_overload");
	if(from_val_overload ==null) from_val_overload="N";
	String flag_acc=checkForNull(request.getParameter("flag_acc"));
    if(flag_acc==null)flag_acc ="";  
	String fromval="";


	String oper_num		= checkForNull((String)temp.get("oper_num"));
	String facility_id	= checkForNull((String)temp.get("facility_id"));
	String patient_id	= checkForNull((String)temp.get("patient_id"));
	String booking_num = checkForNull((String)temp.get("booking_num"));
	String surgeon_code = checkForNull((String)temp.get("surgeon_code"));
	String bill_flag = checkForNull((String)temp.get("bill_flag"));

	

	if(flag_acc.equals(""))
	{

	fromval=checkForNull(request.getParameter("fromval"));

	}else
	{
		fromval=checkForNull(request.getParameter("from_values"));

	}
	String item_type="";
	if(fromval.equals("prosimplants"))
	{
		item_type="S";
	}else if(fromval.equals("Conspack"))
	{
		item_type="P";
	}else if(fromval.equals("equipments"))
	{
		item_type="E";
	}else if(fromval.equals("InstruCSSD"))
	{
		item_type="I";
	}

%>
<input type='hidden' name='booking_num' id='booking_num' value="<%=booking_num%>">
<%
	HashMap line_no_map = new HashMap();
	String line_no="";
	boolean exist_rec = false;
	boolean exist_rec_con = false;
	boolean exist_rec_eq = false;
	boolean exist_rec_inst = false;
	boolean pick_list = false;
	StringBuffer oper_codes = new StringBuffer();
	String surgeon_doc_comp_yn ="",nursing_doc_comp_yn ="", implant_entry_cmp_yn ="",consumable_entry_cmp_yn ="",equipment_entry_cmp_yn ="",instrument_entry_cmp_yn ="";
	String currentDateTime = com.ehis.util.DateUtils.getCurrentDate("DMYHM", locale);
	String oneWeekDate = com.ehis.util.DateUtils.plusDate((com.ehis.util.DateUtils.plusDate(com.ehis.util.DateUtils.getCurrentDate("DMY", locale), "DMY", locale, 1, "d")), "DMY", locale, 1, "w");	//048580

	String oper_room_code = (String)temp.get("oper_room_code");
	String encounter_id = (String)temp.get("encounter_id");
	String onLoadFlag = request.getParameter("onLoadFlag") == null ? "" : request.getParameter("onLoadFlag");

	String rec_implants_in_surg_notes_yn = checkForNull((String)temp.get("rec_implants_in_surg_notes_yn"));
	rec_implants_in_nurs_notes_yn = checkForNull((String)temp.get("rec_implants_in_nurs_notes_yn"));
	rec_equp_in_nurs_notes_yn = checkForNull((String)temp.get("rec_equp_in_nurs_notes_yn"));
	rec_instr_in_nurs_notes_yn = checkForNull((String)temp.get("rec_instr_in_nurs_notes_yn"));
	rec_packs_in_nurs_notes_yn = checkForNull((String)temp.get("rec_packs_in_nurs_notes_yn"));
	st_interface_flag = checkForNull((String)temp.get("st_interface_flag"));
	String episode_type = checkForNull((String)temp.get("episode_type"));
	String patient_class = checkForNull((String)temp.get("patient_class"));

	if(tab.equals("record_surgeon")){
		surgeon_doc_comp_yn = checkForNull((String)temp.get("surgeon_doc_comp_yn"));
		nursing_doc_comp_yn = checkForNull((String)temp.get("nursing_doc_comp_yn"));
		rec_implants_in_nurs_notes_yn=rec_implants_in_surg_notes_yn;
		implant_entry_cmp_yn = checkForNull((String)temp.get("implant_entry_cmp_yn"));

	} else if(tab.equals("record_nursing")){
		
		nursing_doc_comp_yn = checkForNull((String)temp.get("nursing_doc_comp_yn"));
		implant_entry_cmp_yn = checkForNull((String)temp.get("implant_entry_cmp_yn"));
		consumable_entry_cmp_yn = checkForNull((String)temp.get("consumable_entry_cmp_yn"));
		equipment_entry_cmp_yn = checkForNull((String)temp.get("equipment_entry_cmp_yn"));
		instrument_entry_cmp_yn = checkForNull((String)temp.get("instrument_entry_cmp_yn"));
			
	}
	//Below condition changed by Sanjay for SRR20056-SCF-7684 on 21-Jun-2011
	if(consumable_entry_cmp_yn.equals("N")) consumable_entry_cmp_yn="";
		String disable_flag="",disable_flag1="",disable_flag2="",disable_flag3="";

	CallableStatement statement =null;

	String key = "",key_line="",key_eq = "", key_eq1 = "",key_line_eq="", key_ic = "",key_ic1 = "",key_cp = "", key_cp1 = "",key_pi = "",key_line_ic="",key_line_cp="",bill_str="",panel_str="",bill_str_conspack="";

	HashMap bill_info=new HashMap();
	HashMap bill_info_conspack=new HashMap();
	HashMap bill_info_eq=new HashMap();
	HashMap bill_info_ic=new HashMap();
	StringBuilder bl_bfr = new StringBuilder();
	StringBuilder bl_bfr_conspack = new StringBuilder();
	String order_id="",order_line_num="",booking_date  = "",visit_id   = "",catalog_code   = "",item_id="",req_store="", mm_item_code="",avail_stock="",sale_document_no="",no_of_units="",sale_document_type="",reserve_qty="",request_qty="",req_store_code="";
	int total_stock_val=0;

	 String SQL_EXIST = "SELECT ACCESSORY_CODE FROM OT_SURGICAL_ACCESSORIES WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? AND ACCESSORY_TYPE=? AND ROWNUM=1";
	//this query checks whether we have already record in OT_PICK_LISTS Table if returns true="PICK_LIST_DEFINED Qry is executed otherwise PICKlIST_UNDEFINED Qry is executed"
	String PICK_LIST_EXIST_YN = "SELECT OPER_CODE FROM OT_PICK_LISTS WHERE OPERATING_FACILITY_ID=? AND (BOOKING_NUM=? OR OPER_NUM=?) AND ROWNUM=1";
 	String PICK_LIST_DEFINED="SELECT A.OPER_CODE OPR_CODE,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC,A.ITEM_ID ACC_CODE,GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.ITEM_ID) ACC_DESC,GET_DESC('"+locale+"','MM_STORE_LANG_VW','SHORT_DESC','STORE_CODE',A.REQ_STORE_CODE) Store_desc,NVL(A.NO_OF_UNITS,1) TR_NO,A.REQ_STORE_CODE, A.RESERVED_QTY RESERVED_QTY, A.REQUESTED_QTY REQUESTED_QTY,A.SALE_DOCUMENT_TYPE SALE_DOCUMENT_TYPE,A.SALE_DOCUMENT_NO SALE_DOCUMENT_NO,A.REQ_DOCUMENT_TYPE REQ_DOCUMENT_TYPE,A.REQ_DOCUMENT_NO REQ_DOCUMENT_NO,A.NO_OF_UNITS NO_OF_UNITS, 'Y' FRM_PICK_LIST ,B.MM_ITEM_CODE FROM  OT_PICK_LISTS A, OT_PROSTHESIS_LANG_VW B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'S' AND A.ITEM_ID = B.PROSTHESIS_CODE AND B.LANGUAGE_ID='"+locale+"' ";//MMS-QH-CRF-0199
	String PICK_LIST_DEFINED_CONSPACK="SELECT A.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.ITEM_ID ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,NVL(A.NO_OF_UNITS,1) TR_NO,A.REQ_STORE_CODE, A.RESERVED_QTY, A.REQUESTED_QTY, 'Y' FRM_PICK_LIST FROM  OT_PICK_LISTS A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'P' AND A.ITEM_ID = B.PACKAGE_CODE";//MMS-QH-CRF-0199
	String SQL = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.ACCESSORY_CODE) ACC_DESC,GET_DESC('"+locale+"','MM_STORE_LANG_VW','SHORT_DESC','STORE_CODE',A.REQ_STORE_CODE) Store_desc, A.QUANTITY TR_NO, A.PROSTHESIS_MFR MFR,A.PROSTHESIS_BATCH_NO BTCH, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE,A.REQ_STORE_CODE, A.RESERVED_QTY, A.REQUESTED_QTY,A.SALE_DOCUMENT_TYPE SALE_DOCUMENT_TYPE ,A.SALE_DOCUMENT_NO SALE_DOCUMENT_NO,A.EXCL_INCL_IND EXCL_INCL_IND , A.ACTION_REASON_CODE  ACTION_REASON_CODE,C.MM_ITEM_CODE FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_PROSTHESIS_LANG_VW C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND ACCESSORY_TYPE = 'S' AND  A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.PROSTHESIS_CODE AND C.LANGUAGE_ID='"+locale+"'" ;//MMS-QH-CRF-0199
	String SQL1 = "SELECT A.OPER_CODE OPR_CODE,A.OPER_LINE_NUM LN_NUM,B.LONG_DESC OPR_DESC FROM OT_POST_OPER_DTLS A, OT_OPER_MAST B WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE AND NVL(A.OPER_LINE_STATUS,'X' ) NOT IN '99' ";//MMS-QH-CRF-0199
	String PICK_LIST_DEFINED_EQ="SELECT A.OPER_CODE OPR_CODE,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC ,A.ITEM_ID ACC_CODE,GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.ITEM_ID)  ACC_DESC,A.NO_OF_UNITS TR_NO, 'Y' FRM_PICK_LIST, B.LOCATION LOCATION FROM  OT_PICK_LISTS A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'E' AND A.ITEM_ID = B.EQUIPMENT_CODE";//MMS-QH-CRF-0199
	String PICK_LIST_DEFINED_IC="SELECT A.OPER_CODE OPR_CODE,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC ,A.ITEM_ID ACC_CODE,GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE',A.ITEM_ID) ACC_DESC,A.NO_OF_UNITS TR_NO, 'Y' FRM_PICK_LIST FROM  OT_PICK_LISTS A, OT_INSTRUMENT_LANG_VW B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'I' AND A.ITEM_ID = B.INSTR_CODE AND B.LANGUAGE_ID='"+locale+"' ";//MMS-QH-CRF-0199
	//Added Site Specific Query by Rajesh for CRF-0058
	String PICK_LIST_DEFINED_IC_SS = "SELECT A.OPER_CODE OPR_CODE,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC ,A.ITEM_ID ACC_CODE,GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE',A.ITEM_ID) ACC_DESC,A.NO_OF_UNITS TR_NO, 'Y' FRM_PICK_LIST, b.location LOCATION  FROM  OT_PICK_LISTS A, OT_INSTRUMENT_LANG_VW B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'I' AND A.ITEM_ID = B.INSTR_CODE AND B.LANGUAGE_ID='"+locale+"' ";//MMS-QH-CRF-0199
	String sqlForCheckInTime = "SELECT DECODE (?, 'en', TO_CHAR (a.check_in_time, 'DD/MM/YYYY HH24:MI'), 'th', TO_CHAR (a.check_in_time, 'DD/MM/YYYY HH24:MI', 'NLS_CALENDAR=''THAI BUDDHA''' ) ) check_in_time, CANCELLED_BY,TO_CHAR(CANCELLATION_DATE_TIME,'DD/MM/YYYY HH24:MI') CANCELLATION_DATE_TIME, DECODE(CANCEL_REASON,NULL,'',(SELECT REASON_DESC FROM OT_REASONS_LANG_VW WHERE LANGUAGE_ID = ? AND REASON_CODE = CANCEL_REASON)) CANCEL_REASON, TO_CHAR(A.CHECK_INTO_HOLDING_AREA_TIME,'DD/MM/YYYY HH24:MI') CHECK_INTO_HOLDING_AREA_TIME, TO_CHAR(A.CHECK_INTO_OR_TIME,'DD/MM/YYYY HH24:MI') CHECK_INTO_OR_TIME,TO_CHAR(A.NURSING_DOC_COMP_TIME,'DD/MM/YYYY HH24:MI') NURSING_DOC_COMP_TIME,TO_CHAR(A.SURGEON_DOC_COMP_TIME,'DD/MM/YYYY HH24:MI') SURGEON_DOC_COMP_TIME,TO_CHAR(A.ANAESTHETIST_DOC_COMP_TIME,'DD/MM/YYYY HH24:MI') ANAESTHETIST_DOC_COMP_TIME,TO_CHAR(A.RECOVERY_START_TIME,'DD/MM/YYYY HH24:MI') RECOVERY_START_TIME,TO_CHAR(A.RECOVERY_END_TIME,'DD/MM/YYYY HH24:MI') RECOVERY_END_TIME,TO_CHAR(A.CHECK_OUT_TIME,'DD/MM/YYYY HH24:MI') CHECK_OUT_TIME FROM OT_POST_OPER_HDR A WHERE A.OPERATING_FACILITY_ID = ? AND A.OPER_NUM =?"; 	//048580
	//Added Site Specific Query by Rajesh for CRF-0058
	Connection con = null;
	PreparedStatement pstmt = null,pstmt_bl = null,pstmt_doc_type = null,pstmt_Conspack = null,pstmt_eq = null,pstmt_ic = null,pstmt_acc_reqyn = null,pstmt_st = null,pstmt_room = null,pstmt_req_store = null;

	//Added by lakshmi against CRF-0058
	PreparedStatement pstmt_sm_report_display = null;
	PreparedStatement pstmtForCheckInTime = null;
	ResultSet rst_sm_report_display=null;
	ResultSet rsForCheckInTime = null;
	String Ot_param="";

	//Added by muthuN RUT-CRF-0091 on 05-13-2013
	//PreparedStatement pstmt_st = null;
	ResultSet rst_st=null;
	String customer_id="";
	Statement stmt=null;
	String val= "";
	String checkInTime = "";
	String checkIntoOrTime = "";
	String checkOutTime = "";
	ResultSet rst = null,rst_bl = null,rset = null,rset_req_store = null,rset_doc_type = null,rst_Conspack = null,rst_eq = null,rst_ic = null,rst_room = null,rst_acc_reqyn = null;

	String rst_acc_code = "", rst_tr_no = "", bl_episode_type = "",st_charge_based_yn="";

	String overridden_action_reason_code=null;
	con = ConnectionManager.getConnection(request);
	int index=0;
	try{

		pstmtForCheckInTime = con.prepareStatement(sqlForCheckInTime) ;
		pstmtForCheckInTime.setString(1,locale);
		pstmtForCheckInTime.setString(2,locale);
		pstmtForCheckInTime.setString(3,facility_id);
		pstmtForCheckInTime.setString(4,oper_num);
		rsForCheckInTime = pstmtForCheckInTime.executeQuery();
		if(rsForCheckInTime != null && rsForCheckInTime.next())
		{
			checkInTime = checkForNull(rsForCheckInTime.getString("CHECK_IN_TIME"));
			checkIntoOrTime = checkForNull(rsForCheckInTime.getString("CHECK_INTO_OR_TIME"));
			checkOutTime = checkForNull(rsForCheckInTime.getString("CHECK_OUT_TIME"));
		}

		//Added by lakshmi against CRF-0058 starts here
		//Modified by Rajesh 28-8-2012
		//String sql_sm_report="select NVL(PICKLIST_BY_WARD,'N') PICKLIST  from OT_PARAM where rownum = 1";
		String sql_sm_report="select NVL(INSTRUMENT_CSSD_IMAGE,'N') PICKLIST  from OT_PARAM where rownum = 1";
		//Modified by Rajesh 28-8-2012
		pstmt_sm_report_display=con.prepareStatement(sql_sm_report);
		rst_sm_report_display=pstmt_sm_report_display.executeQuery();
		if(rst_sm_report_display !=null && rst_sm_report_display.next())
		Ot_param=checkForNull(rst_sm_report_display.getString("PICKLIST"));
		if(rst_sm_report_display!=null)
			rst_sm_report_display.close();
		if(pstmt_sm_report_display!=null)
			pstmt_sm_report_display.close();
	   //Added by lakshmi against CRF-0058 ends here
//Added by muthuN for RUT-CRF-0091 on 05-13-2013
	   pstmt_st = con.prepareStatement("select CUSTOMER_ID from sm_site_param");				
			rst_st = pstmt_st.executeQuery();	
			if ( rst_st.next() && rst_st != null )
			{
				customer_id  =  rst_st.getString(1);
			}
//Added by muthuN for RUT-CRF-0091 on 05-13-2013
		stmt=con.createStatement();
	String sql_bl_epi_type="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = '"+patient_class+"' AND EPISODE_TYPE ='"+episode_type+"' ";
		pstmt_bl = con.prepareStatement(sql_bl_epi_type);
		rst_bl=pstmt_bl.executeQuery();
		if(rst_bl !=null && rst_bl.next())
		{
			bl_episode_type=checkForNull(rst_bl.getString(1));
		}

		if(implant_entry_cmp_yn.equals("Y"))
		{
			disable_flag="disabled";
		}
		
		if(consumable_entry_cmp_yn.equals("Y"))
		{
			disable_flag1="disabled";
		}

		if(equipment_entry_cmp_yn.equals("Y"))
		{
			disable_flag2="disabled";
		}

		if(instrument_entry_cmp_yn.equals("Y"))
		{
			disable_flag3="disabled";
		}

		if(st_interface_flag.equals("Y"))
			 {

	String sql_doc_type="SELECT ST_DOC_TYPE_RTI,ST_DOC_TYPE_SLI  FROM ot_param_for_facility WHERE OPERATING_FACILITY_ID='"+facility_id+"'";

			pstmt_doc_type=con.prepareStatement(sql_doc_type);
			rset_doc_type=pstmt_doc_type.executeQuery();

			if(rset_doc_type !=null && rset_doc_type.next())
			{
				st_doc_type_rti =rset_doc_type.getString("ST_DOC_TYPE_RTI");
				if(st_doc_type_rti==null) st_doc_type_rti="";
				st_doc_type_sli=rset_doc_type.getString("ST_DOC_TYPE_SLI");
				if(st_doc_type_sli==null) st_doc_type_sli="";
			}
		if(st_doc_type_rti.equals("") || st_doc_type_sli.equals(""))
		{
			out.println("<script>alert(getMessage('PRC-OT0055','OT')); window.close();</script>");
		}
  }
		if (fromval == "") 
					fromvalFlag = 'Y';
		else   fromvalFlag = 'N';

		if(fromval =="" && rec_implants_in_nurs_notes_yn.equals("Y") )  {fromval="prosimplants";}
	    else if(fromval =="" && rec_implants_in_nurs_notes_yn.equals("N") && rec_packs_in_nurs_notes_yn.equals("Y")) {fromval="Conspack";}
		else if(fromval =="" && rec_implants_in_nurs_notes_yn.equals("N") && rec_packs_in_nurs_notes_yn.equals("N") && rec_equp_in_nurs_notes_yn.equals("Y")) {fromval="equipments";}
		else if(fromval =="" && rec_implants_in_nurs_notes_yn.equals("N") && rec_packs_in_nurs_notes_yn.equals("N") && rec_equp_in_nurs_notes_yn.equals("N")) {fromval="InstruCSSD";}

		if(rst_acc_reqyn!=null)   rst_acc_reqyn.close();
		if(pstmt_acc_reqyn!=null) pstmt_acc_reqyn.close();

		pstmt = con.prepareStatement(SQL1);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);

		rst = pstmt.executeQuery();
		int fetch_count = 0;
		while(rst.next()){
			++fetch_count;
			if(fetch_count==1)
			oper_codes.append("'"+rst.getString(1)+"'");
			else
			 oper_codes.append(","+"'"+rst.getString(1)+"'");
			line_no_map.put(rst.getString(1),rst.getString(2));
		}
		
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		pstmt = con.prepareStatement(SQL_EXIST);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		pstmt.setString(3,"S");
		rst = pstmt.executeQuery();
		if(rst.next()){
			exist_rec=true;
		}
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();

	    /* **************************** Prothesis/Impalnts Starts Here******************************************/
			String rate="";
		
	if(st_interface_flag.equals("Y"))
		{
		PreparedStatement pstmt_charge_based= null;
		ResultSet rs_charge_based=null;
		String sql_chrage_based_yn="SELECT BL_INTERFACE_YN  FROM ST_ACC_ENTITY_PARAM";
		pstmt_charge_based=con.prepareStatement(sql_chrage_based_yn);

		rs_charge_based=pstmt_charge_based.executeQuery();
		if(rs_charge_based !=null && rs_charge_based.next())
		 {
		st_charge_based_yn=checkForNull(rs_charge_based.getString("BL_INTERFACE_YN"));
		 }
		}
		if(exist_rec==true){
			if(rec_implants_in_nurs_notes_yn.equals("Y"))
			{
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,oper_num);
			rst = pstmt.executeQuery();
			index = 0;
			while(rst.next()){
				++index;	
			key = rst.getString("KEY");
			key_line = rst.getString("KEY_LINE");
				item_id=checkForNull(rst.getString("ACC_CODE"));
			req_store=	checkForNull(rst.getString("REQ_STORE_CODE"));
			p_qty=	checkForNull(rst.getString("TR_NO"));
			if(p_qty == null) p_qty="";
			sale_document_type=	checkForNull(rst.getString("SALE_DOCUMENT_TYPE"));
			sale_document_no=	checkForNull(rst.getString("SALE_DOCUMENT_NO"));
			String excl_incl_ind_st=	checkForNull(rst.getString("EXCL_INCL_IND"));
			String action_reason_code_st=	checkForNull(rst.getString("ACTION_REASON_CODE"));
			mm_item_code=rst.getString("MM_ITEM_CODE");
				if(mm_item_code ==null) mm_item_code="";
			
		if(!item_id.equals("") )
		 {
try 
			 {
				/*	 sql_mm_code="select MM_ITEM_CODE from OT_PROSTHESIS where PROSTHESIS_CODE='"+item_id+"'";

					    pstmt_st=con.prepareStatement(sql_mm_code);
					  rst_st=pstmt_st.executeQuery();
				if(rst_st !=null && rst_st.next())
				{
					mm_item_code=rst_st.getString(1);
					if(mm_item_code ==null) mm_item_code="";
				}*/
       
		String[] stParameters = {mm_item_code,req_store , "0", "N", "", "N", "" };
		HashMap hmStockAvailabilityStatus = bean.getStockAvailabilityStatus(stParameters);
    	avail_stock = (String)hmStockAvailabilityStatus.get("available_stock");

			 }catch(Exception e)
			 {
				System.err.println("2096,Err Msg in Pros=========="+e.getMessage());
				e.printStackTrace();
				//out.println("<script>alert('Stock is not available for the Item/Store combination') return;</script>");
				avail_stock="";
			 }
		 }

		 if(("true").equals(bill_flag))
			{

				if(st_interface_flag.equals("N"))
				{
			bill_info = or_bean.getOrderBillDtls(key+key_line);

			if(bill_info==null){
				bill_info = new HashMap();
				bill_info.put("key",key);
				bill_info.put("key_line_no",key_line);
				rst_acc_code = rst.getString("ACC_CODE");
				bill_info.put("oper_code",rst_acc_code);//pass acc_code in oper_code
				bill_info.put("acc_type","I");
				bill_info.put("oper_num",oper_num);
				bill_info.put("locale",locale);
				bill_info.put("module_id","OT");
				rst_tr_no = rst.getString("TR_NO");
				bill_info.put("quantity",rst_tr_no);
				bill_info.put("rate",rate);
				bill_info = billing_bean.getBillingParams(bill_info,"C");//C-> for Surgical Accessories Billing
				if(from_val_overload.equals("N"))
		{
				or_bean.setOrderBillDtls(key+key_line,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);
		}
			}
			panel_str = (String) bill_info.get("bl_panel_str");	
	//		String overridden_incl_excl_ind=null;

			bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
			bl_bfr.append(excl_incl_ind_st).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"),"S")).append("::");
			bl_bfr.append(action_reason_code_st).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E"));
			
				bill_str = bl_bfr.toString();
				}else
					{


					if(!req_store.equals(""))
					{
					System.err.println("ST_BL_GET_ITEM_CHARGE_DTLS =b4====111=="+System.currentTimeMillis());
					statement=con.prepareCall("{call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");//Maheshwaran K modified for  SKR-SCF-0788 [IN:039522] as on 24/09/2013
					System.err.println("ST_BL_GET_ITEM_CHARGE_DTLS =a4====111=="+System.currentTimeMillis());
				String sal_trn_type="";
					p_qty=	checkForNull(rst.getString("TR_NO"));
								if(patient_class.equals("IP"))
									{
										sal_trn_type="I";
									}else if(patient_class.equals("OP"))
									{
									sal_trn_type="O";
									}else if(patient_class.equals("EM"))
									{
									sal_trn_type="E";
									}else if(patient_class.equals("DC"))
									{
									sal_trn_type="D";
									}else if(patient_class.equals("XT"))
									{
									sal_trn_type="R";
									}

			statement.setString(1, facility_id);
			statement.setString(2, patient_id);
			statement.setString(3, "ST");
			statement.setString(4, encounter_id);
			statement.setString(5, sal_trn_type);
			statement.setString(6, com.ehis.util.DateUtils.getCurrentDate("DMY","en"));
			statement.setString(7, mm_item_code);
			statement.setString(8, req_store);
			statement.setInt(9, Integer.parseInt(p_qty));
			statement.setString(10, ";");
			statement.registerOutParameter(11, Types.VARCHAR);
			statement.registerOutParameter(12, Types.VARCHAR);
			statement.registerOutParameter(13, Types.VARCHAR);
			statement.registerOutParameter(14, Types.VARCHAR);
			statement.registerOutParameter(15, Types.FLOAT);
			statement.registerOutParameter(16, Types.FLOAT);
			statement.registerOutParameter(17, Types.FLOAT);
			statement.registerOutParameter(18, Types.FLOAT);
			statement.registerOutParameter(19, Types.FLOAT);
			statement.registerOutParameter(20, Types.FLOAT);
			statement.registerOutParameter(21, Types.FLOAT);
			statement.registerOutParameter(22, Types.FLOAT);
			statement.registerOutParameter(23, Types.FLOAT);
			statement.registerOutParameter(24, Types.FLOAT);
			statement.registerOutParameter(25, Types.FLOAT);
			statement.registerOutParameter(26, Types.FLOAT);
			statement.registerOutParameter(27, Types.FLOAT);
			statement.registerOutParameter(28, Types.FLOAT);
			statement.registerOutParameter(29, Types.VARCHAR);
			statement.registerOutParameter(30, Types.FLOAT);
			statement.registerOutParameter(31, Types.VARCHAR);
			statement.registerOutParameter(32, Types.VARCHAR);
			statement.registerOutParameter(33, Types.VARCHAR);
			statement.registerOutParameter(34, Types.VARCHAR);
			statement.registerOutParameter(35, Types.VARCHAR);
			statement.registerOutParameter(36, Types.VARCHAR);
			statement.registerOutParameter(37, Types.VARCHAR);
			statement.registerOutParameter(38, Types.VARCHAR);
			statement.setString(39, excl_incl_ind_st);
			statement.setString(40, action_reason_code_st);
			statement.setString(41, "N"); //Internal Adjestment
           statement.setString(42, sale_document_type);
		   statement.setString(43, sale_document_no);
		   statement.setString(44, "1");
		   //Maheshwaran K added for the  SKR-SCF-0788 [IN:039522] as on 24/09/2013
			//Start
			statement.setString(45, "N");//p_discharge_ind
			statement.registerOutParameter(46, Types.VARCHAR);//p_drug_penalty_str
			//End
			statement.execute();
//				String overridden_incl_excl_ind=null;
				if(excl_incl_ind_st=="") excl_incl_ind_st=null;
				if(action_reason_code_st=="") action_reason_code_st=null;
				String override_value=statement.getString(37);
				bl_bfr.append(checkForNull(""+statement.getString(21),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(25),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(38),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+st_charge_based_yn,"N")).append("::");
				bl_bfr.append(excl_incl_ind_st).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(36),"N")).append("::");
				bl_bfr.append(checkForNull(""+"S")).append("::");//Note: when ST is on serv_panel_ind value passing as "S" for showing excl_incl value always in the screen   but there is no concept of service or panel through ST billing.
				bl_bfr.append(action_reason_code_st).append("::");
				bl_bfr.append(checkForNull(""+excl_incl_ind_st,"E")).append("::");
				bl_bfr.append(override_value);
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
					}
				}
			bl_bfr.setLength(0);
			}

frm_pick_list="N";
           //Added encode for REMKS on 10/18/2010 by AnithaJ 
			out.println("<script>loadDBRows_pi('"+tab+"','"+checkForNull(rst.getString("OPR_CODE"))+"','"+encode(checkForNull(rst.getString("OPR_DESC")))+"','"+checkForNull(rst.getString("LN_NUM"))+"','"+item_id+"','"+encode(checkForNull(rst.getString("ACC_DESC")))+"','"+checkForNull(rst.getString("TR_NO"))+"','"+checkForNull(rst.getString("MFR"))+"','"+checkForNull(rst.getString("BTCH"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("REMKS")),"UTF-8")+"','"+index+"','L','1','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','"+checkForNull(rst.getString("REQ_STORE_CODE"))+"','"+checkForNull(rst.getString("RESERVED_QTY"))+"','"+checkForNull(rst.getString("REQUESTED_QTY"))+"','"+no_of_units+"','"+sale_document_no+"','"+sale_document_type+"','"+avail_stock+"','"+checkForNull(rst.getString("Store_desc"))+"','"+frm_pick_list+"'); </script>");	
 		   }
           if(rst!=null)rst.close();
		   if(pstmt!=null)pstmt.close();
			}
		}
		else if(implant_entry_cmp_yn.equals("N") || implant_entry_cmp_yn.equals("")) //commented on 2/15/2011 by Anitha for 25110
		{
			if(rec_implants_in_nurs_notes_yn.equals("Y"))
			{
			pstmt = con.prepareStatement(PICK_LIST_EXIST_YN);
		
			pstmt.setString(1,facility_id);
			pstmt.setString(2,booking_num);
			pstmt.setString(3,oper_num);
			rst = pstmt.executeQuery();
			if(rst.next()){
				pick_list=true;
			}
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			//pick_list=true;
			if(pick_list==true)
			{

				 pstmt = con.prepareStatement(PICK_LIST_DEFINED);
				 pstmt.setString(1,facility_id);
				 pstmt.setString(2,patient_id);
				 //pstmt.setString(3,surgeon_code);// as vishawa told to remove team_doctor_code 
				 pstmt.setString(3,booking_num);
				 pstmt.setString(4,oper_num);
				 rst = pstmt.executeQuery();
				 int r=0;
				 index =0;
				if(rst !=null)	
				{
				while(rst.next()){
					++index;	
					++r;
					line_no = (String)line_no_map.get(rst.getString("OPR_CODE"));
					item_id=checkForNull(rst.getString("ACC_CODE"));
					req_store=checkForNull(rst.getString("REQ_STORE_CODE"));
					sale_document_no=checkForNull(rst.getString("SALE_DOCUMENT_NO"));
					sale_document_type=checkForNull(rst.getString("SALE_DOCUMENT_TYPE"));
					no_of_units=checkForNull(rst.getString("NO_OF_UNITS"));
					reserve_qty=checkForNull(rst.getString("RESERVED_QTY"));
					request_qty=checkForNull(rst.getString("REQUESTED_QTY"));
					p_qty = rst.getString("TR_NO");
					if(p_qty == null) p_qty="";
					frm_pick_list=rst.getString("FRM_PICK_LIST");
					if(frm_pick_list ==null) frm_pick_list="N";
						mm_item_code=rst.getString("MM_ITEM_CODE");
				if(mm_item_code ==null) mm_item_code="";
							
			if(!item_id.equals("") )
		 {
			try 
			 {
		String[] stParameters = {mm_item_code,req_store , "0", "N", "", "N", "" };
		HashMap hmStockAvailabilityStatus = bean.getStockAvailabilityStatus(stParameters);
    		avail_stock = (String)hmStockAvailabilityStatus.get("available_stock");

			 }catch(Exception e)
			 {
				System.err.println("2309,Err Msg in Pros=========="+e.getMessage());		 
				e.printStackTrace();
				 avail_stock="";
			 }
		 }
	if(("true").equals(bill_flag))
			    {
				
					if(st_interface_flag.equals("N"))
				{
			
					HashMap hash = billing_bean.getORBillingParams(oper_num);
				catalog_code = "I#"+rst.getString("ACC_CODE");
				key = oper_num+"@"+rst.getString("OPR_CODE")+"@S@"+rst.getString("ACC_CODE")+r;
				key_pi = oper_num+"@"+rst.getString("OPR_CODE")+"@S@"+rst.getString("ACC_CODE");

				key_line="";
				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info			 = billing_bean.formatBillingDetails(bill_dtls);
				bill_info.putAll(hash);
				bill_info.put("quantity",p_qty);
				//set billing details from OTBillingBean........	
				if(from_val_overload.equals("N"))
		{
				or_bean.setOrderBillDtls(key,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);
		}
				String overridden_incl_excl_ind=null;
				panel_str = (String) bill_info.get("bl_panel_str");	
				bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");				
				bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");;
				bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"),"S")).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E")).append("::");
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}else
				{
					if(!req_store.equals(""))
					{
						System.err.println("ST_BL_GET_ITEM_CHARGE_DTLS =b4====222=="+System.currentTimeMillis());
					statement=con.prepareCall("{call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");//Maheshwaran K modified for  SKR-SCF-0788 [IN:039522] as on 24/09/2013
					System.err.println("ST_BL_GET_ITEM_CHARGE_DTLS =a4====222=="+System.currentTimeMillis());
				String sal_trn_type="";
				p_qty = rst.getString("TR_NO");
								if(patient_class.equals("IP"))
									{
										sal_trn_type="I";
									}else if(patient_class.equals("OP"))
									{
									sal_trn_type="O";
									}else if(patient_class.equals("EM"))
									{
									sal_trn_type="E";
									}else if(patient_class.equals("DC"))
									{
									sal_trn_type="D";
									}else if(patient_class.equals("XT"))
									{
									sal_trn_type="R";
									}
		   String incl_excl=null;
			statement.setString(1, facility_id);
			statement.setString(2, patient_id);
			statement.setString(3, "ST");
			statement.setString(4, encounter_id);
			statement.setString(5, sal_trn_type);
			statement.setString(6, com.ehis.util.DateUtils.getCurrentDate("DMY","en"));
			statement.setString(7, mm_item_code);
			statement.setString(8, req_store);
			statement.setInt(9, Integer.parseInt(p_qty));
			statement.setString(10, ";");
			statement.registerOutParameter(11, Types.VARCHAR);
			statement.registerOutParameter(12, Types.VARCHAR);
			statement.registerOutParameter(13, Types.VARCHAR);
			statement.registerOutParameter(14, Types.VARCHAR);
			statement.registerOutParameter(15, Types.FLOAT);
			statement.registerOutParameter(16, Types.FLOAT);
			statement.registerOutParameter(17, Types.FLOAT);
			statement.registerOutParameter(18, Types.FLOAT);
			statement.registerOutParameter(19, Types.FLOAT);
			statement.registerOutParameter(20, Types.FLOAT);
			statement.registerOutParameter(21, Types.FLOAT);
			statement.registerOutParameter(22, Types.FLOAT);
			statement.registerOutParameter(23, Types.FLOAT);
			statement.registerOutParameter(24, Types.FLOAT);
			statement.registerOutParameter(25, Types.FLOAT);
			statement.registerOutParameter(26, Types.FLOAT);
			statement.registerOutParameter(27, Types.FLOAT);
			statement.registerOutParameter(28, Types.FLOAT);
			statement.registerOutParameter(29, Types.VARCHAR);
			statement.registerOutParameter(30, Types.FLOAT);
			statement.registerOutParameter(31, Types.VARCHAR);
			statement.registerOutParameter(32, Types.VARCHAR);
			statement.registerOutParameter(33, Types.VARCHAR);
			statement.registerOutParameter(34, Types.VARCHAR);
			statement.registerOutParameter(35, Types.VARCHAR);
			statement.registerOutParameter(36, Types.VARCHAR);
			statement.registerOutParameter(37, Types.VARCHAR);
			statement.registerOutParameter(38, Types.VARCHAR);
			statement.setString(39, "");
			statement.setString(40, "");
			statement.setString(41, "N"); //Internal Adjestment
           statement.setString(42, sale_document_type);
		   statement.setString(43, sale_document_no);
		   statement.setString(44, "1");
		   //Maheshwaran K added for the  SKR-SCF-0788 [IN:039522] as on 24/09/2013
			//Start
			statement.setString(45, "N");//p_discharge_ind
			statement.registerOutParameter(46, Types.VARCHAR);//p_drug_penalty_str
			//End
		statement.execute();
			  incl_excl=statement.getString(35);
			String override_value=statement.getString(37);
				bl_bfr.append(checkForNull(""+statement.getString(21),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(25),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(38),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+st_charge_based_yn,"N")).append("::");
				bl_bfr.append(incl_excl).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(36),"N")).append("::");
				bl_bfr.append(checkForNull(""+"S")).append("::");//Note: when ST is on serv_panel_ind value passing as "S" for showing excl_incl value always in the screen   but there is no concept of service or panel through ST billing.
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+incl_excl,"E")).append("::");
				bl_bfr.append(override_value);
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
					}
				}
				}//end of if bill_flag
out.println("<script>loadDBRows_pi('"+tab+"','"+checkForNull(rst.getString("OPR_CODE"))+"','"+encode(checkForNull(rst.getString("OPR_DESC")))+"','"+line_no+"','"+item_id+"','"+encode(checkForNull(rst.getString("ACC_DESC")))+"','"+checkForNull(rst.getString("TR_NO"))+"','','','','"+index+"','L','2','"+bill_str+"','"+panel_str+"','"+key_pi+"','"+key_line+"','"+req_store+"','"+checkForNull(rst.getString("RESERVED_QTY"))+"','"+checkForNull(rst.getString("REQUESTED_QTY"))+"','"+no_of_units+"','"+sale_document_no+"','"+sale_document_type+"','"+avail_stock+"','"+checkForNull(rst.getString("Store_desc"))+"','"+frm_pick_list+"'); </script>");	
			}//end of while loop
			}
              if(rst!=null)rst.close();
			  if(pstmt!=null)pstmt.close();
			}
			else 
			{
				String Store_desc="";
				String sql_req_code="SELECT a.STORE_CODE,b.SHORT_DESC FROM OT_STORES_FOR_THEATRE a, MM_STORE_LANG_VW b WHERE a.STORE_CODE=b.STORE_CODE AND  a.STORE_TYPE='R' AND a.OPERATING_FACILITY_ID='"+facility_id+"' AND a.OPER_ROOM_CODE='"+oper_room_code+"' and b.language_id='"+locale+"' and DEFAULT_YN='Y'";
				pstmt_req_store=con.prepareStatement(sql_req_code);
				rset_req_store = pstmt_req_store.executeQuery();
				if(rset_req_store !=null && rset_req_store.next())
				{
					req_store_code=rset_req_store.getString("STORE_CODE");
					Store_desc=rset_req_store.getString("SHORT_DESC");
					if(req_store_code ==null) req_store_code="";
					if(Store_desc ==null) Store_desc="";
				}
					String PICK_LIST_UNDEFINED="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.PROSTHESIS_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.PROSTHESIS_CODE) ACC_DESC,   NVL(A.NO_OF_UNITS,1) TR_NO,B.MM_ITEM_CODE FROM  OT_OPER_PROSTHESIS A, OT_PROSTHESIS B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'AOPR' AND A.PROSTHESIS_CODE = B.PROSTHESIS_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+")   UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.PROSTHESIS_CODE ACC_CODE, B.SHORT_DESC ACC_DESC,NVL(A.NO_OF_UNITS,1) TR_NO,B.MM_ITEM_CODE FROM OT_OPER_PROSTHESIS A, OT_PROSTHESIS B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+") AND A.PROSTHESIS_CODE = B.PROSTHESIS_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.PROSTHESIS_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.PROSTHESIS_CODE) ACC_DESC,  NVL(A.NO_OF_UNITS,1) TR_NO,B.MM_ITEM_CODE FROM OT_OPER_PROSTHESIS A, OT_PROSTHESIS B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SCAT' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE AND D.OPER_CODE  IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE AND A.PROSTHESIS_CODE  = B.PROSTHESIS_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.PROSTHESIS_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.PROSTHESIS_CODE) ACC_DESC, NVL(A.NO_OF_UNITS,1) TR_NO,B.MM_ITEM_CODE   FROM OT_OPER_PROSTHESIS A, OT_PROSTHESIS B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB'AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND  A.OPER_CAT_CODE = D.OPER_CAT_CODE AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE     AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE      AND A.PROSTHESIS_CODE = B.PROSTHESIS_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.PROSTHESIS_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.PROSTHESIS_CODE) ACC_DESC,  NVL(A.NO_OF_UNITS,1) TR_NO,B.MM_ITEM_CODE FROM OT_OPER_PROSTHESIS A, OT_PROSTHESIS B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SOPR' AND A.OPER_CODE IN ("+oper_codes.toString()+") AND A.OPER_CODE = C.OPER_CODE AND A.PROSTHESIS_CODE = B.PROSTHESIS_CODE";//MMS-QH-CRF-0199 
					pstmt = con.prepareStatement(PICK_LIST_UNDEFINED);
					rst = pstmt.executeQuery();
					index=0;
					while(rst.next()){
						++index;	
						line_no = (String)line_no_map.get(rst.getString("OPR_CODE"));
						item_id=checkForNull(rst.getString("ACC_CODE"));
						mm_item_code=rst.getString("MM_ITEM_CODE");
						if(mm_item_code ==null) mm_item_code="";
							if(!item_id.equals("") ){
								try {
									/*	 sql_mm_code="select MM_ITEM_CODE from OT_PROSTHESIS where PROSTHESIS_CODE='"+item_id+"'";
								    pstmt_st=con.prepareStatement(sql_mm_code);
									rst_st=pstmt_st.executeQuery();
									if(rst_st !=null && rst_st.next()){
									mm_item_code=checkForNull(rst_st.getString(1));
									}*/
									String[] stParameters = {mm_item_code,req_store_code , "0", "N", "", "N", "" };
									HashMap hmStockAvailabilityStatus = bean.getStockAvailabilityStatus(stParameters);
							    	avail_stock = (String)hmStockAvailabilityStatus.get("available_stock");
								}catch(Exception e){
									e.printStackTrace();
									//out.println("<script>alert('Stock is not available for the Item/Store combination')</script>");
									avail_stock="";
								}
							}
						if(("true").equals(bill_flag)){
							p_qty= rst.getString("TR_NO");
							if(p_qty == null) p_qty="";
							if(st_interface_flag.equals("N")){
								HashMap hash = billing_bean.getORBillingParams(oper_num);
								catalog_code = "I#"+rst.getString("ACC_CODE");
								key = oper_num+"@"+rst.getString("OPR_CODE")+"@S@"+rst.getString("ACC_CODE");
								key_line="";
								booking_date = (String) hash.get("service_date");
								patient_id = (String)hash.get("patient_id");
								encounter_id = (String)hash.get("encounter_id");
								surgeon_code = (String)hash.get("pract_staff_id");
								patient_class = (String)hash.get("patient_class");
								visit_id = (String)hash.get("visit_id");
								ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
								bill_info = billing_bean.formatBillingDetails(bill_dtls);
								hash.put("key",key);
								hash.put("key_line_no",key_line);
								hash.put("oper_code",rst.getString("ACC_CODE"));//pass acc_code in oper_code
								hash.put("acc_type","I");
								hash.put("oper_num",oper_num);
								hash.put("locale",locale);
								hash.put("quantity",rst.getString("TR_NO"));
								bill_info.putAll(hash);
								bill_info.put("quantity",p_qty);
								//set billing details from OTBillingBean........	
								if(from_val_overload.equals("N")){
									or_bean.setOrderBillDtls(key,bill_info);
									putObjectInBean(or_bean_id,or_bean,request);
								}
								String overridden_incl_excl_ind=null;
								panel_str = (String) bill_info.get("bl_panel_str");	
								bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
								bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
								bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
								bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
								bl_bfr.append(overridden_incl_excl_ind).append("::");
								bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
								bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"))).append("::");
								bl_bfr.append(overridden_action_reason_code).append("::");
								bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E")).append("::");
								bill_str = bl_bfr.toString();
								bl_bfr.setLength(0);
							}else{					
								if(!req_store_code.equals("")){
						System.err.println("ST_BL_GET_ITEM_CHARGE_DTLS =b4====333333=="+System.currentTimeMillis());
									statement=con.prepareCall("{call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");//Maheshwaran K modified for  SKR-SCF-0788 [IN:039522] as on 24/09/2013
						System.err.println("ST_BL_GET_ITEM_CHARGE_DTLS =a4====333333=="+System.currentTimeMillis());
									String sal_trn_type="";
									if(patient_class.equals("IP")){
										sal_trn_type="I";
									}else if(patient_class.equals("OP")){
								sal_trn_type="O";
								}else if(patient_class.equals("EM")){
									sal_trn_type="E";
								}else if(patient_class.equals("DC")){
									sal_trn_type="D";
								}else if(patient_class.equals("XT")){
									sal_trn_type="R";
								}
								statement.setString(1, facility_id);
								statement.setString(2, patient_id);
								statement.setString(3, "ST");
								statement.setString(4, encounter_id);
								statement.setString(5, sal_trn_type);
								statement.setString(6, com.ehis.util.DateUtils.getCurrentDate("DMY","en"));
								statement.setString(7, mm_item_code);
								statement.setString(8, req_store_code);
								statement.setInt(9, Integer.parseInt(p_qty));
								statement.setString(10, ";");
								statement.registerOutParameter(11, Types.VARCHAR);
								statement.registerOutParameter(12, Types.VARCHAR);
								statement.registerOutParameter(13, Types.VARCHAR);
								statement.registerOutParameter(14, Types.VARCHAR);
								statement.registerOutParameter(15, Types.FLOAT);
								statement.registerOutParameter(16, Types.FLOAT);
								statement.registerOutParameter(17, Types.FLOAT);
								statement.registerOutParameter(18, Types.FLOAT);
								statement.registerOutParameter(19, Types.FLOAT);
								statement.registerOutParameter(20, Types.FLOAT);
								statement.registerOutParameter(21, Types.FLOAT);
								statement.registerOutParameter(22, Types.FLOAT);
								statement.registerOutParameter(23, Types.FLOAT);
								statement.registerOutParameter(24, Types.FLOAT);
								statement.registerOutParameter(25, Types.FLOAT);
								statement.registerOutParameter(26, Types.FLOAT);
								statement.registerOutParameter(27, Types.FLOAT);
								statement.registerOutParameter(28, Types.FLOAT);
								statement.registerOutParameter(29, Types.VARCHAR);
								statement.registerOutParameter(30, Types.FLOAT);
								statement.registerOutParameter(31, Types.VARCHAR);
								statement.registerOutParameter(32, Types.VARCHAR);
								statement.registerOutParameter(33, Types.VARCHAR);
								statement.registerOutParameter(34, Types.VARCHAR);
								statement.registerOutParameter(35, Types.VARCHAR);
								statement.registerOutParameter(36, Types.VARCHAR);
								statement.registerOutParameter(37, Types.VARCHAR);
								statement.registerOutParameter(38, Types.VARCHAR);
								statement.setString(39, "");
								statement.setString(40, "");
								statement.setString(41, "N"); //Internal Adjestment
								statement.setString(42, sale_document_type);
								statement.setString(43, sale_document_no);
								statement.setString(44, "1");
								//Maheshwaran K added for the  SKR-SCF-0788 [IN:039522] as on 24/09/2013
								//Start
								statement.setString(45, "N");//p_discharge_ind
								statement.registerOutParameter(46, Types.VARCHAR);//p_drug_penalty_str
								//End
								statement.execute();
								String incl_excl=null;
								incl_excl=statement.getString(35);
								String	override_value=statement.getString(37);
								bl_bfr.append(checkForNull(""+statement.getString(21),"0.0")).append("::");
								bl_bfr.append(checkForNull(""+statement.getString(25),"0.0")).append("::");
								bl_bfr.append(checkForNull(""+statement.getString(38),"0.0")).append("::");
								bl_bfr.append(checkForNull(""+st_charge_based_yn,"N")).append("::");
								bl_bfr.append(incl_excl).append("::");
								bl_bfr.append(checkForNull(""+statement.getString(36),"N")).append("::");
								bl_bfr.append(checkForNull(""+"S")).append("::");//Note: when ST is on serv_panel_ind value passing as "S" for showing excl_incl value always in the screen   but there is no concept of service or panel through ST billing.
								bl_bfr.append(overridden_action_reason_code).append("::");
								bl_bfr.append(checkForNull(""+incl_excl,"E")).append("::");
								bl_bfr.append(override_value);
								bill_str = bl_bfr.toString();
								bl_bfr.setLength(0);

								}			
							}
						}
					frm_pick_list="N";	
					out.println("<script>loadDBRows_pi('"+tab+"','"+checkForNull(rst.getString("OPR_CODE"))+"','"+checkForNull(rst.getString("OPR_DESC"))+"','"+line_no+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+checkForNull(rst.getString("ACC_DESC"))+"','"+checkForNull(rst.getString("TR_NO"))+"','','','','"+index+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','"+req_store_code+"','','','','','','"+avail_stock+"','"+Store_desc+"','"+frm_pick_list+"'); </script>");	
				}//end of while loop
				}
			}
		}//else
		out.println("<script>refresh_acc('"+flag_acc+"','"+rec_implants_in_nurs_notes_yn+"','"+rec_equp_in_nurs_notes_yn+"','"+rec_instr_in_nurs_notes_yn+"','"+rec_packs_in_nurs_notes_yn+"','"+st_interface_flag+"')</script>");
		out.println("<script>assignRecId()</script>");
		
		if (!tab.equals("record_surgeon") )
		{
		/*	pstmt = con.prepareStatement(SQL_EXIST);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		pstmt.setString(3,"P");
		rst = pstmt.executeQuery();
		if(rst.next()){
			exist_rec_con=true;
		}
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		if(exist_rec_con ==true)
		{*/
			/* ########################### Consumable packs Code Starts Here#########################################*/
			if(rec_packs_in_nurs_notes_yn.equals("Y"))
			{
					
					String SQL_Conspack = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',C.PACKAGE_CODE) ACC_DESC, A.QUANTITY TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE,A.REQ_STORE_CODE, A.RESERVED_QTY, A.REQUESTED_QTY FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_PACKAGE_HDR_LANG_VW C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND ACCESSORY_TYPE = 'P' AND  A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.PACKAGE_CODE AND C.LANGUAGE_ID=? ORDER BY BILL_SUB_REGN_LINE_NUM";//MMS-QH-CRF-0199
					

					pstmt_Conspack = con.prepareStatement(SQL_Conspack,ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			pstmt_Conspack.setString(1,facility_id);
			pstmt_Conspack.setString(2,oper_num);
			pstmt_Conspack.setString(3,locale);
			
			rst_Conspack = pstmt_Conspack.executeQuery();
			
            if(rst_Conspack.next()){
					exist_rec_con=true;
		    }
			if(exist_rec_con ==true)
				{
				rst_Conspack.beforeFirst();
				index = 0;
			while(rst_Conspack.next()){
			   ++index;	
			key_cp = rst_Conspack.getString("KEY");
			key_line_cp = rst_Conspack.getString("KEY_LINE");
			//or_bean.clearBean();
			//System.err.println("bill_flag :" +bill_flag);

			if(("true").equals(bill_flag))
			{
			bill_info_conspack = or_bean.getOrderBillDtls(key_cp+key_line_cp);

			if(bill_info_conspack==null){
				bill_info_conspack = new HashMap();
				bill_info_conspack.put("key",key_cp);
				bill_info_conspack.put("key_line_no",key_line_cp);
				rst_acc_code = rst_Conspack.getString("ACC_CODE");
				bill_info_conspack.put("oper_code",rst_acc_code);//pass acc_code in oper_code
				bill_info_conspack.put("acc_type","C");
				bill_info_conspack.put("oper_num",oper_num);
				bill_info_conspack.put("locale",locale);
				bill_info_conspack.put("module_id","OT");
				//populate billing details from OTBillingBean........	

				rst_tr_no = rst_Conspack.getString("TR_NO");
				bill_info_conspack.put("quantity",rst_tr_no);
				bill_info_conspack = billing_bean.getBillingParams(bill_info_conspack,"C");//C-> for Surgical Accessories Billing
				//bill_info.put("quantity",rst.getString("TR_NO"));
if(from_val_overload.equals("N"))
		{
				or_bean.setOrderBillDtls(key_cp+key_line_cp,bill_info_conspack);
				putObjectInBean(or_bean_id,or_bean,request);
		}
			}

			String overridden_incl_excl_ind=null;

			panel_str = (String) bill_info_conspack.get("bl_panel_str");	
			bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("total_payable"),"0.0")).append("::");
			bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("patient_payable"),"0.0")).append("::");
			bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("patient_paid_amt"),"0.0")).append("::");
			bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("charged_yn"),"N")).append("::");
			bl_bfr_conspack.append(overridden_incl_excl_ind).append("::");
			
			bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("preapp_yn"),"N")).append("::");
			bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("serv_panel_ind"))).append("::");
			bl_bfr_conspack.append(overridden_action_reason_code).append("::");
			bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("incl_excl_ind"),"E")).append("::");

			bill_str_conspack = bl_bfr_conspack.toString();
		
			bl_bfr_conspack.setLength(0); 
			}//end of if bill_flag
		String frompickli="";	
			//Added encode for REMKS on 10/27/2010 by AnithaJ
			out.println("<script>loadDBRows_conspack('"+checkForNull(rst_Conspack.getString("OPR_CODE"))+"','"+encode(checkForNull(rst_Conspack.getString("OPR_DESC")))+"','"+checkForNull(rst_Conspack.getString("LN_NUM"))+"','"+checkForNull(rst_Conspack.getString("ACC_CODE"))+"','"+encode(checkForNull(rst_Conspack.getString("ACC_DESC")))+"','"+checkForNull(rst_Conspack.getString("TR_NO"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_Conspack.getString("REMKS")),"UTF-8")+"','"+index+"','L','1','"+bill_str_conspack+"','"+panel_str+"','"+key_cp+"','"+key_line_cp+"','"+checkForNull(rst_Conspack.getString("REQ_STORE_CODE"))+"','"+checkForNull(rst_Conspack.getString("RESERVED_QTY"))+"','"+checkForNull(rst_Conspack.getString("REQUESTED_QTY"))+"','"+frompickli+"');</script>");

			}
			//}else if(consumable_entry_cmp_yn.equals("N")) //commented on 2/15/2011 by Anitha for 25110
			}//Below condition changed by Sanjay for SRR20056-SCF-7684 on 21-Jun-2011
			else if(("").equals(consumable_entry_cmp_yn)||("N").equals(consumable_entry_cmp_yn))
		{

			/* ########################### Consumable packs Code Starts Here#######################################*/
			
			pstmt = con.prepareStatement(PICK_LIST_EXIST_YN);
			/*SELECT OPER_CODE FROM OT_PICK_LISTS WHERE OPERATING_FACILITY_ID=? AND (BOOKING_NUM=? OR OPER_NUM=?) AND ROWNUM=1*/
			pstmt.setString(1,facility_id);
			pstmt.setString(2,booking_num);
			pstmt.setString(3,oper_num);
		//6/19/2009trace="4";
			rst = pstmt.executeQuery();
			if(rst.next()){
				pick_list=true;
			}
			if(pstmt!=null)			pstmt.close();
			if(rst!=null)           rst.close();

			if(pick_list==true){


				pstmt_Conspack = con.prepareStatement(PICK_LIST_DEFINED_CONSPACK);
				pstmt_Conspack.setString(1,facility_id);
				pstmt_Conspack.setString(2,patient_id);
				//pstmt_Conspack.setString(3,surgeon_code);// as vishawa told to remove team_doctor_code
				pstmt_Conspack.setString(3,booking_num);
				pstmt_Conspack.setString(4,oper_num);
				rst_Conspack = pstmt_Conspack.executeQuery();
					int s=0;
					if(rst_Conspack !=null)
			{
					index=0;
			    while(rst_Conspack.next()){
					++index;	
					++s;
					line_no = (String)line_no_map.get(rst_Conspack.getString("OPR_CODE"));
					frm_pick_list=rst_Conspack.getString("FRM_PICK_LIST");
					if(frm_pick_list ==null) frm_pick_list="N";
				if(("true").equals(bill_flag))
			    {
				HashMap hash_Conspack = billing_bean.getORBillingParams(oper_num);
				catalog_code = "C#"+rst_Conspack.getString("ACC_CODE");
				key_cp = oper_num+"@"+rst_Conspack.getString("OPR_CODE")+"@S@"+rst_Conspack.getString("ACC_CODE")+s;
				key_cp1 = oper_num+"@"+rst_Conspack.getString("OPR_CODE")+"@S@"+rst_Conspack.getString("ACC_CODE");
				key_line_cp="";
				booking_date  = (String) hash_Conspack.get("service_date");
				patient_id	    = (String)hash_Conspack.get("patient_id");
				encounter_id   = (String)hash_Conspack.get("encounter_id");
				surgeon_code  = (String)hash_Conspack.get("pract_staff_id");
				patient_class   = (String)hash_Conspack.get("patient_class");
				visit_id			 =	(String)hash_Conspack.get("visit_id");
				p_qty = rst_Conspack.getString("TR_NO");
				if(p_qty == null) p_qty="";
		
				ArrayList bill_dtls_Conspack=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info_conspack			 = billing_bean.formatBillingDetails(bill_dtls_Conspack);
				bill_info_conspack.putAll(hash_Conspack);
				bill_info_conspack.put("quantity",p_qty);


				//set billing details from OTBillingBean........	
				if(from_val_overload.equals("N"))
		{
				or_bean.setOrderBillDtls(key_cp1,bill_info_conspack);
				putObjectInBean(or_bean_id,or_bean,request);
		}
				String overridden_incl_excl_ind=null;
				panel_str = (String) bill_info_conspack.get("bl_panel_str");	
				bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("total_payable"),"0.0")).append("::");
				bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("patient_payable"),"0.0")).append("::");
				bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("charged_yn"),"N")).append("::");
				bl_bfr_conspack.append(overridden_incl_excl_ind).append("::");
				bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("preapp_yn"),"N")).append("::");
				bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("serv_panel_ind"))).append("::");
				bl_bfr_conspack.append(overridden_action_reason_code).append("::");
				bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("incl_excl_ind"),"E")).append("::");
				bill_str = bl_bfr_conspack.toString();
				bl_bfr_conspack.setLength(0);
				}//end of if bill_flag
			out.println("<script>loadDBRows_conspack('"+checkForNull(rst_Conspack.getString("OPR_CODE"))+"','"+encode(checkForNull(rst_Conspack.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst_Conspack.getString("ACC_CODE"))+"','"+encode(checkForNull(rst_Conspack.getString("ACC_DESC")))+"','"+checkForNull(rst_Conspack.getString("TR_NO"))+"','','"+index+"','L','2','"+bill_str+"','"+panel_str+"','"+key_cp1+"','"+key_line_cp+"','"+checkForNull(rst_Conspack.getString("REQ_STORE_CODE"))+"','"+checkForNull(rst_Conspack.getString("RESERVED_QTY"))+"','"+checkForNull(rst_Conspack.getString("REQUESTED_QTY"))+"','"+frm_pick_list+"'); </script>");	

			}//end of while loop
			}
		}else
		{

				String PICK_LIST_UNDEFINED_CONSPACK="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE,   GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO FROM    OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'AOPR' AND A.PACKAGE_CODE     = B.PACKAGE_CODE  AND C.OPER_CODE IN ("+oper_codes.toString()+") UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO FROM    OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SSPL'AND A.SPECIALITY_CODE = C.SPECIALITY_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+") AND A.PACKAGE_CODE     = B.PACKAGE_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO  FROM OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SCAT' AND A.SPECIALITY_CODE   = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE    = D.OPER_CAT_CODE    AND D.OPER_CODE  IN ("+oper_codes.toString()+") AND C.OPER_CODE  = D.OPER_CODE     AND A.PACKAGE_CODE     = B.PACKAGE_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO  FROM OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND A.OPER_SUB_CAT_CODE  = D.OPER_SUB_CAT_CODE  AND D.OPER_CODE IN ("+oper_codes.toString()+")  AND C.OPER_CODE = D.OPER_CODE AND A.PACKAGE_CODE     = B.PACKAGE_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO FROM    OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SOPR' AND A.OPER_CODE IN ("+oper_codes.toString()+") AND A.OPER_CODE  = C.OPER_CODE  AND A.PACKAGE_CODE = B.PACKAGE_CODE";//MMS-QH-CRF-0199
			//System.err.println("PICK_LIST_UNDEFINED_CONSPACK :" +PICK_LIST_UNDEFINED_CONSPACK);

			pstmt = con.prepareStatement(PICK_LIST_UNDEFINED_CONSPACK);
			rst = pstmt.executeQuery();
			 index =0;
			while(rst.next()){
				++index;	
				line_no = (String)line_no_map.get(rst.getString("OPR_CODE"));
				HashMap hash = billing_bean.getORBillingParams(oper_num);
				catalog_code = "C#"+rst.getString("ACC_CODE");
				key = oper_num+"@"+rst.getString("OPR_CODE")+"@S@"+rst.getString("ACC_CODE");
				key_line="";
				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				p_qty		= rst.getString("TR_NO");
				if(p_qty == null) p_qty="";

				if(("true").equals(bill_flag))
			    {
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info			 = billing_bean.formatBillingDetails(bill_dtls);
					hash.put("key",key);
					hash.put("key_line_no",key_line);
					hash.put("oper_code",rst.getString("ACC_CODE"));//pass acc_code in oper_code
					hash.put("acc_type","C");
					hash.put("oper_num",oper_num);
					hash.put("locale",locale);
					hash.put("quantity",p_qty);
				bill_info.putAll(hash);
				bill_info.put("quantity",rst.getString("TR_NO"));
				//set billing details from OTBillingBean........	
				if(from_val_overload.equals("N"))
		{
				or_bean.setOrderBillDtls(key,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);
		}

				String overridden_incl_excl_ind=null;

				panel_str = (String) bill_info.get("bl_panel_str");	
				bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"))).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E")).append("::");
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end of if bill_flag
			/*oper_code,oper_desc,line_no,package_code,package_desc,quantity,remarks,index,mode,order	*/
	out.println("<script>loadDBRows_conspack('"+checkForNull(rst.getString("OPR_CODE"))+"','"+encode(checkForNull(rst.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+encode(checkForNull(rst.getString("ACC_DESC")) )+"','"+checkForNull(rst.getString("TR_NO"))+"','','"+index+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','','','','N'); </script>");	
			}//end of while loop
		if(pstmt!=null)			pstmt.close();
			if(rst!=null)           rst.close();


	}
		
			if(rst_Conspack!=null)rst_Conspack.close();
			if(pstmt_Conspack!=null)pstmt_Conspack.close();

		}else
		{
		   out.println("<script>refresh_acc('"+flag_acc+"','"+rec_implants_in_nurs_notes_yn+"','"+rec_equp_in_nurs_notes_yn+"','"+rec_instr_in_nurs_notes_yn+"','"+rec_packs_in_nurs_notes_yn+"','"+st_interface_flag+"')</script>");
		out.println("<script>assignRecId()</script>");
		}	
		
			if(rst_Conspack !=null)rst_Conspack.close();
			if(pstmt_Conspack !=null)pstmt_Conspack.close();
			}


			/* @@@@@@@@@@@@@@@@@@@@@@@@@@@ Equipments Code Starts Here @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
		if(rec_equp_in_nurs_notes_yn.equals("Y"))
		{
			//String SQL_EQ = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.ACCESSORY_CODE) ACC_DESC, A.EQUIPMENT_ID TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE, A.Quantity actual_units,C.LOCATION LOCATION, NVL (TO_CHAR (desired_date, 'DD/MM/YYYY HH24:MI'), TO_CHAR (a.added_date, 'DD/MM/YYYY HH24:MI') ) desired_date FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_EQUIPMENT C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND ACCESSORY_TYPE = 'E' AND A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.EQUIPMENT_CODE"; //047546
		//SKR-SCF-0984 [IN:048580]
		String SQL_EQ = "SELECT a.oper_code opr_code, a.oper_line_num ln_num, get_desc ('"+locale+"', 'OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',a.oper_code) opr_desc, a.accessory_code acc_code,get_desc ('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',a.accessory_code) acc_desc, a.equipment_id tr_no, a.remarks remks, bill_sub_regn_num KEY,bill_sub_regn_line_num key_line, a.quantity actual_units,c.LOCATION LOCATION,DECODE (:P_languageid, 'en', NVL (TO_CHAR (desired_date, 'DD/MM/YYYY HH24:MI'),TO_CHAR (a.added_date, 'DD/MM/YYYY HH24:MI')), 'th', NVL (TO_CHAR (desired_date, 'DD/MM/YYYY HH24:MI','NLS_CALENDAR=''THAI BUDDHA'''), TO_CHAR (a.added_date, 'DD/MM/YYYY HH24:MI','NLS_CALENDAR=''THAI BUDDHA''')) ) desired_date,a.STATUS as OPER_LINE_STATUS FROM ot_surgical_accessories a, ot_oper_mast b, ot_equipment c WHERE a.operating_facility_id = ? AND a.oper_num = ?   AND accessory_type = 'E'   AND a.oper_code = b.oper_code   AND a.accessory_code = c.equipment_code";//MMS-QH-CRF-0199 & CRF-294
                pstmt_eq = con.prepareStatement(SQL_EQ,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);		
		pstmt_eq.setString(1,locale);
		pstmt_eq.setString(2,facility_id);
		pstmt_eq.setString(3,oper_num);
		rst_eq = pstmt_eq.executeQuery();
			if(rst_eq.next())
			{
			exist_rec_eq=true;
		}
			if(exist_rec_eq==true)
		{
		 rst_eq.beforeFirst();
		index=0;
				while(rst_eq.next())
				{
		   ++index;	
			key_eq = rst_eq.getString("KEY");
			key_line_eq = rst_eq.getString("KEY_LINE");
			rst_acc_code = rst_eq.getString("ACC_CODE");
			p_qty = rst_eq.getString("actual_units");
					if(p_qty == null)
						p_qty="";
			st_location = checkForNull(rst_eq.getString("LOCATION"));//Added for CRF 091
						desiredDate = checkForNull(rst_eq.getString("desired_date"));
			if(("true").equals(bill_flag))// added this condition by sathish on 10-01-2009 to disabling billingpart 
			{
			bill_info_eq = or_bean.getOrderBillDtls(key_eq+key_line_eq);
						if(bill_info_eq==null)
						{
				bill_info_eq = new HashMap();
				bill_info_eq.put("key",key_eq);
				bill_info_eq.put("key_line_no",key_line_eq);
				bill_info_eq.put("oper_code",rst_acc_code);//pass acc_code in oper_code
				bill_info_eq.put("acc_type","E");
				bill_info_eq.put("oper_num",oper_num);
				bill_info_eq.put("locale",locale);
				bill_info_eq.put("module_id","OT");
				bill_info_eq.put("quantity",p_qty);
				//populate billing details from OTBillingBean........	
				bill_info_eq = billing_bean.getBillingParams(bill_info_eq,"C");//C-> for Surgical Accessories Billing
				if(from_val_overload.equals("N"))
		{
				or_bean.setOrderBillDtls(key_eq+key_line_eq,bill_info_eq);
				putObjectInBean(or_bean_id,or_bean,request);
		}
				//bill_info_eq.clear();
			}
			String overridden_incl_excl_ind=null;
			panel_str = (String) bill_info_eq.get("bl_panel_str");	
			bl_bfr.append(checkForNull(""+bill_info_eq.get("total_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_eq.get("patient_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_eq.get("patient_paid_amt"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_eq.get("charged_yn"),"N")).append("::");
			bl_bfr.append(overridden_incl_excl_ind).append("::");
			bl_bfr.append(checkForNull(""+bill_info_eq.get("preapp_yn"),"N")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_eq.get("serv_panel_ind"))).append("::");
			bl_bfr.append(overridden_action_reason_code).append("::");
			bl_bfr.append(checkForNull(""+bill_info_eq.get("incl_excl_ind"),"E")).append("::");
			bill_str = bl_bfr.toString();
			bl_bfr.setLength(0);
			}//end of if bill_flag
			String from_pick="";
			//Added encode for REMKS on 10/27/2010 by AnithaJ 
					out.println("<script>loadDBRows_eq('"+checkForNull(rst_eq.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_eq.getString("OPR_DESC")),"UTF-8")+"','"+checkForNull(rst_eq.getString("LN_NUM"))+"','"+checkForNull(rst_eq.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_eq.getString("ACC_DESC")),"UTF-8")+"','"+checkForNull(rst_eq.getString("TR_NO"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_eq.getString("REMKS")),"UTF-8")+"','"+checkForNull(rst_eq.getString("OPER_LINE_STATUS"))+"','"+index+"','L','1','"+bill_str+"','"+panel_str+"','"+key_eq+"','"+key_line_eq+"', '"+from_pick+"','"+p_qty+"','"+st_location+"','"+desiredDate+"'); </script>");//Added(STATUS) for AMRI CRF 294
				}
		}
			else if(equipment_entry_cmp_yn.equals("")||equipment_entry_cmp_yn.equals("N"))
		{
				 /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@ Equipments packs Code StartsHer@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
			pstmt = con.prepareStatement(PICK_LIST_EXIST_YN);

			pstmt.setString(1,facility_id);
			pstmt.setString(2,booking_num);
			pstmt.setString(3,oper_num);
			rst = pstmt.executeQuery();
				if(rst.next())
				pick_list=true;

				if(pstmt!=null)
					pstmt.close();
				if(rst!=null)
					rst.close();
				if(pick_list==true)
				{
			 if(rec_equp_in_nurs_notes_yn.equals("Y"))
		     {
			 pstmt_eq = con.prepareStatement(PICK_LIST_DEFINED_EQ);
			 pstmt_eq.setString(1,facility_id);
			 pstmt_eq.setString(2,patient_id);
			 //pstmt_eq.setString(3,surgeon_code);//as vishwa told to remove team_doctor_code
			 pstmt_eq.setString(3,booking_num);
			 pstmt_eq.setString(4,oper_num);
			 rst_eq = pstmt_eq.executeQuery();
			 int m=0;
			index =0;
						while(rst_eq.next())
						{
					++index;	
					++m;
					line_no = (String)line_no_map.get(rst_eq.getString("OPR_CODE"));
					frm_pick_list=rst_eq.getString("FRM_PICK_LIST");
					if(frm_pick_list ==null) frm_pick_list="N";
				HashMap hash = billing_bean.getORBillingParams(oper_num);
				catalog_code = "E#"+rst_eq.getString("ACC_CODE");
				key_eq = oper_num+"@"+rst_eq.getString("OPR_CODE")+"@S@"+rst_eq.getString("ACC_CODE")+m;
				key_eq1 = oper_num+"@"+rst_eq.getString("OPR_CODE")+"@S@"+rst_eq.getString("ACC_CODE");
					p_qty = rst_eq.getString("TR_NO");
				if(p_qty == null) p_qty="";
				st_location = checkForNull(rst_eq.getString("LOCATION"));//Added for CRF 091
				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				
				if(("true").equals(bill_flag))
			    {
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info_eq			 = billing_bean.formatBillingDetails(bill_dtls);
				bill_info_eq.putAll(hash);
				bill_info_eq.put("quantity",p_qty);
				//set billing details from OTBillingBean........	
				if(from_val_overload.equals("N"))
		{
				or_bean.setOrderBillDtls(key_eq1,bill_info_eq);
				putObjectInBean(or_bean_id,or_bean,request);
						}
				key_line_eq="";
				String overridden_incl_excl_ind=null;
				panel_str = (String) bill_info_eq.get("bl_panel_str");	
				bl_bfr.append(checkForNull(""+bill_info_eq.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("serv_panel_ind"))).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("incl_excl_ind"),"E")).append("::");
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end of if bill_flag
							out.println("<script>loadDBRows_eq('"+checkForNull(rst_eq.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_eq.getString("OPR_DESC")),"UTF-8")+"','"+line_no+"','"+checkForNull(rst_eq.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_eq.getString("ACC_DESC")),"UTF-8")+"','','','"+index+"','L','2','"+bill_str+"','"+panel_str+"','"+key_eq1+"','"+key_line_eq+"','"+frm_pick_list+"','"+p_qty+"','"+st_location+"','"+currentDateTime+"'); </script>");	//047546
			 }//end of while loop
						if(rst_eq!=null)
							rst_eq.close();
						if(pstmt_eq !=null)
							pstmt_eq.close();
					}
			 }
				else
			{ 
				// commented for testing------------ String PICK_LIST_UNDEFINED="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE, GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE  A.APPLICABILITY = 'AOPR' AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE   AND C.OPER_CODE IN ("+oper_codes.toString()+") UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC, A.NO_OF_UNITS TR_NO 	FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE   A.APPLICABILITY   = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN  ("+oper_codes.toString()+") AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION	SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO  FROM OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY  = 'SCAT' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE    = D.OPER_CAT_CODE AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE, GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO  FROM OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB'  AND A.SPECIALITY_CODE       = D.OPER_GROUP_CODE  AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE AND D.OPER_CODE  IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE  AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,  A.NO_OF_UNITS TR_NO FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY   = 'SOPR' AND A.OPER_CODE IN ("+oper_codes.toString()+") AND A.OPER_CODE  = C.OPER_CODE AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE";
				String PICK_LIST_UNDEFINED="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE, GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO ,b.location LOCATION FROM  OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE  A.APPLICABILITY = 'AOPR' AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE   AND C.OPER_CODE IN ("+oper_codes.toString()+") UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC, A.NO_OF_UNITS TR_NO ,b.location LOCATION	FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE   A.APPLICABILITY   = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN  ("+oper_codes.toString()+") AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION	SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO ,b.location LOCATION FROM OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY  = 'SCAT' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE    = D.OPER_CAT_CODE AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE, GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO ,b.location LOCATION FROM OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB'  AND A.SPECIALITY_CODE       = D.OPER_GROUP_CODE  AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE AND D.OPER_CODE  IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE  AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,  A.NO_OF_UNITS TR_NO ,b.location LOCATION FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY   = 'SOPR' AND A.OPER_CODE IN ("+oper_codes.toString()+") AND A.OPER_CODE  = C.OPER_CODE AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE";//MMS-QH-CRF-0199
				pstmt = con.prepareStatement(PICK_LIST_UNDEFINED);
				rst = pstmt.executeQuery();
					index =0;
					while(rst.next())
					{
					++index;	
					line_no = (String)line_no_map.get(rst.getString("OPR_CODE"));
					HashMap hash = billing_bean.getORBillingParams(oper_num);
				catalog_code = "E#"+rst.getString("ACC_CODE");
				key = oper_num+"@"+rst.getString("OPR_CODE")+"@S@"+rst.getString("ACC_CODE");
				p_qty = rst.getString("TR_NO");
				st_location = checkForNull(rst.getString("LOCATION"));//Added for CRF 091
						if(p_qty == null)
							p_qty="";
				key_line="";
				booking_date	= (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id	= (String)hash.get("encounter_id");
				surgeon_code	= (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id		= (String)hash.get("visit_id");
	
               		 if(("true").equals(bill_flag))
			    {
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				//ArrayList bill_dtls=or_bean.getBillChargeDetails(visit_id,catalog_code,"31/10/2007 10:00",locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info			 = billing_bean.formatBillingDetails(bill_dtls);
					hash.put("key",key);
					hash.put("key_line_no",key_line);
					hash.put("oper_code",rst.getString("ACC_CODE"));//pass acc_code in oper_code
					hash.put("acc_type","E");
					hash.put("oper_num",oper_num);
					hash.put("locale",locale);
					hash.put("quantity",p_qty);

				bill_info.putAll(hash);
				bill_info.put("quantity",p_qty);
				//set billing details from OTBillingBean........	
						if(from_val_overload.equals("N"))
		{
				or_bean.setOrderBillDtls(key,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);
		}
String overridden_incl_excl_ind=null;
				panel_str = (String) bill_info.get("bl_panel_str");	
    
				bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"))).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E")).append("::");
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end of if bill_flag
						out.println("<script>loadDBRows_eq('"+checkForNull(rst.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("OPR_DESC")),"UTF-8")+"','"+line_no+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("ACC_DESC")),"UTF-8")+"','"+checkForNull(rst.getString("ACC_CODE"))+"','','"+index+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','N','"+p_qty+"','"+st_location+"','"+currentDateTime+"'); </script>");	//047546 Equipment Id
		 }//end of while loop
					if(rst!=null)
						rst.close();
					if(pstmt !=null)
						pstmt.close();
		}
			 /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@ Equipments packs Code Ends Her@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
			}
			else
		{
		   out.println("<script>refresh_acc('"+flag_acc+"','"+rec_implants_in_nurs_notes_yn+"','"+rec_equp_in_nurs_notes_yn+"','"+rec_instr_in_nurs_notes_yn+"','"+rec_packs_in_nurs_notes_yn+"','"+st_interface_flag+"')</script>");
		out.println("<script>assignRecId()</script>");
		}
			if(rst_eq!=null)
				rst_eq.close();
			if(pstmt_eq !=null)
				pstmt_eq.close();
		}
          /* @@@@@@@@@@@@@@@@@@@@@@@@@@@ Equipments Code Ends Here @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

		//}
		
	/*	pstmt = con.prepareStatement(SQL_EXIST);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		pstmt.setString(3,"I");
		rst = pstmt.executeQuery();
		if(rst.next()){
			exist_rec_inst=true;
		}
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		
		if(exist_rec_inst==true)
		{*/
		    /* $$$$$$$$$$$$$$$$$$$$$$$$$ Instrument?Cssc packs Code Starts Her$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/
			if(rec_instr_in_nurs_notes_yn.equals("Y"))
			{
					String SQL_IC="";
					if(Ot_param.equalsIgnoreCase("Y")){
						SQL_IC = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE',A.ACCESSORY_CODE) ACC_DESC, A.TRAY_NO TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE, A.Quantity actual_units ,D.LOCATION LOCATION FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_INSTRUMENT_LANG_VW C, OT_INSTRUMENT D WHERE A.OPERATING_FACILITY_ID=? AND C.LANGUAGE_ID=? AND ACCESSORY_TYPE='I' AND A.OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.INSTR_CODE AND A.ACCESSORY_CODE=D.INSTR_CODE"; //MMS-QH-CRF-0199
					}
					else{
						SQL_IC = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE',A.ACCESSORY_CODE) ACC_DESC, A.TRAY_NO TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE, A.Quantity actual_units  FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_INSTRUMENT_LANG_VW C WHERE A.OPERATING_FACILITY_ID=? AND C.LANGUAGE_ID=? AND ACCESSORY_TYPE='I' AND A.OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.INSTR_CODE "; //MMS-QH-CRF-0199
					}
					 pstmt_ic = con.prepareStatement(SQL_IC,ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
		//	pstmt_ic = con.prepareStatement(SQL_IC);
			pstmt_ic.setString(1,facility_id);
			pstmt_ic.setString(2,locale);
			pstmt_ic.setString(3,oper_num);

			rst_ic = pstmt_ic.executeQuery();

			if(rst_ic.next()){
			exist_rec_inst=true;
		}
		  if(exist_rec_inst==true)
	       {
			rst_ic.beforeFirst();
				index = 0;
			while(rst_ic.next()){
			   ++index;	
			key_ic = rst_ic.getString("KEY");
			key_line_ic = rst_ic.getString("KEY_LINE");
			p_qty = rst_ic.getString("actual_units");
			if(p_qty == null) p_qty="";

            if(("true").equals(bill_flag)) //added by sathish on 10-01-2009 to diable billing part when unchecked interfaced to patient billing check box in masters
			{
			bill_info_ic = or_bean.getOrderBillDtls(key_ic+key_line_ic);
			if(bill_info_ic==null){
				bill_info_ic = new HashMap();
				bill_info_ic.put("key",key_ic);
				bill_info_ic.put("key_line_no",key_line_ic);
				rst_acc_code = rst_ic.getString("ACC_CODE");
				bill_info_ic.put("oper_code",rst_acc_code);//pass acc_code in oper_code
				bill_info_ic.put("acc_type","S");
				bill_info_ic.put("oper_num",oper_num);
				bill_info_ic.put("locale",locale);
				bill_info_ic.put("module_id","OT");
				bill_info_ic.put("quantity",p_qty);
				//populate billing details from OTBillingBean........	
				bill_info_ic = billing_bean.getBillingParams(bill_info_ic,"C");//C-> for Surgical Accessories Billing

		if(from_val_overload.equals("N"))
		{
			

				or_bean.setOrderBillDtls(key_ic+key_line_ic,bill_info_ic);
				putObjectInBean(or_bean_id,or_bean,request);
		}
			}
			String overridden_incl_excl_ind=null;
			panel_str = (String) bill_info_ic.get("bl_panel_str");	
				bl_bfr.append(checkForNull(""+bill_info_ic.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("serv_panel_ind"))).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("incl_excl_ind"),"E")).append("::");
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);

			bl_bfr.setLength(0);
		    }//end of if bill_flag
			 
			 	//Added encode for REMKS on 10/27/2010 by AnithaJ
				//Added by lakshmi against CRF-0058
			if(Ot_param.equalsIgnoreCase("Y")){ out.println("<script>loadDBRows_ic('"+checkForNull(rst_ic.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("OPR_DESC")))+"','"+checkForNull(rst_ic.getString("LN_NUM"))+"','"+checkForNull(rst_ic.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("ACC_DESC")))+"','"+checkForNull(rst_ic.getString("LOCATION"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("REMKS")),"UTF-8")+"','"+index+"','"+oper_num+"','L','1','"+bill_str+"','"+panel_str+"','"+key_ic+"','"+key_line_ic+"','"+frm_pick_list+"','"+p_qty+"');</script>");
							}
			else{										out.println("<script>loadDBRows_ic('"+checkForNull(rst_ic.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("OPR_DESC")))+"','"+checkForNull(rst_ic.getString("LN_NUM"))+"','"+checkForNull(rst_ic.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("ACC_DESC")))+"','"+checkForNull(rst_ic.getString("TR_NO"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("REMKS")),"UTF-8")+"','"+index+"','"+oper_num+"','L','1','"+bill_str+"','"+panel_str+"','"+key_ic+"','"+key_line_ic+"','"+frm_pick_list+"','"+p_qty+"');</script>");
				}
			 
			}
			//}else if(instrument_entry_cmp_yn.equals("N")) //commented on 2/15/2011 by Anitha for 25110
			}//Below condition changed by Sanjay for SRR20056-SCF-7684 on 21 Jun 2011
			else if(instrument_entry_cmp_yn.equals("")||instrument_entry_cmp_yn.equals("N"))
		{
			   /* $$$$$$$$$$$$$$$$$$$$$$$$$ Instrument?Cssc packs Code Starts Her$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/

				pstmt = con.prepareStatement(PICK_LIST_EXIST_YN);
			/*SELECT OPER_CODE FROM OT_PICK_LISTS WHERE OPERATING_FACILITY_ID=? AND (BOOKING_NUM=? OR OPER_NUM=?) AND ROWNUM=1*/
			pstmt.setString(1,facility_id);
			pstmt.setString(2,booking_num);
			pstmt.setString(3,oper_num);
		//6/19/2009trace="4";
			rst = pstmt.executeQuery();
			if(rst.next()){
				pick_list=true;
			}
			if(pstmt!=null)			pstmt.close();
			if(rst!=null)           rst.close();
			if(pick_list==true){
                 if(rec_instr_in_nurs_notes_yn.equals("Y"))
			    {
					  int j=0;
				if(Ot_param.equalsIgnoreCase("Y")){		
					pstmt_ic = con.prepareStatement(PICK_LIST_DEFINED_IC_SS);				
				}
				else{
					pstmt_ic = con.prepareStatement(PICK_LIST_DEFINED_IC);
				}
				 pstmt_ic.setString(1,facility_id);
				 pstmt_ic.setString(2,patient_id);
				 //pstmt_ic.setString(3,surgeon_code); as viShwa told to remove team_doctor_code from query
				 pstmt_ic.setString(3,booking_num);
				 pstmt_ic.setString(4,oper_num);
				 rst_ic = pstmt_ic.executeQuery();
				  index =0;
				 while(rst_ic.next()){
					++index;	
					++j;
					line_no = (String)line_no_map.get(rst_ic.getString("OPR_CODE"));
						frm_pick_list=rst_ic.getString("FRM_PICK_LIST");
					if(frm_pick_list ==null) frm_pick_list="N";
				
				if(("true").equals(bill_flag))
			    {
				HashMap hash = billing_bean.getORBillingParams(oper_num);
				catalog_code = "S#"+rst_ic.getString("ACC_CODE");
				key_ic = oper_num+"@"+rst_ic.getString("OPR_CODE")+"@S@"+rst_ic.getString("ACC_CODE")+j;
				key_ic1 = oper_num+"@"+rst_ic.getString("OPR_CODE")+"@S@"+rst_ic.getString("ACC_CODE");
				p_qty = rst_ic.getString("TR_NO");
				if(p_qty == null) p_qty="";
				key_line_ic="";
				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				//ArrayList bill_dtls=or_bean.getBillChargeDetails(visit_id,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info_ic			 = billing_bean.formatBillingDetails(bill_dtls);
				bill_info_ic.putAll(hash);
				bill_info_ic.put("quantity",p_qty);
				//set billing details from OTBillingBean........	
						if(from_val_overload.equals("N"))
		{
			
				or_bean.setOrderBillDtls(key_ic1,bill_info_ic);
				putObjectInBean(or_bean_id,or_bean,request);
		}
String overridden_incl_excl_ind=null;
				panel_str = (String) bill_info_ic.get("bl_panel_str");	
				bl_bfr.append(checkForNull(""+bill_info_ic.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("serv_panel_ind"))).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("incl_excl_ind"),"E")).append("::");
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end ofm if bill_flag
				//Modified for CRF-0058 by Rajesh
				if(Ot_param.equalsIgnoreCase("Y")){
					out.println("<script>loadDBRows_ic('"+checkForNull(rst_ic.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst_ic.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("ACC_DESC")))+"','"+checkForNull(rst_ic.getString("LOCATION"))+"','','"+index+"','"+oper_num+"','L','2','"+bill_str+"','"+panel_str+"','"+key_ic1+"','"+key_line_ic+"','"+frm_pick_list+"','"+p_qty+"');</script>");	
				}
				else{
					out.println("<script>loadDBRows_ic('"+checkForNull(rst_ic.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst_ic.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("ACC_DESC")))+"','','','"+index+"','"+oper_num+"','L','2','"+bill_str+"','"+panel_str+"','"+key_ic1+"','"+key_line_ic+"','"+frm_pick_list+"','"+p_qty+"');</script>");	
				}
				//Modified for CRF-0058 by Rajesh	
			 }//end of while loop
			if(rst_ic!=null)		rst_ic.close();
		    if(pstmt_ic !=null)  pstmt_ic.close();
			
				}
			}else
			{
				//Query modified for CRF-0058 by Rajesh
				String PICK_LIST_UNDEFINED = "";
				if(Ot_param.equalsIgnoreCase("Y")){
				PICK_LIST_UNDEFINED="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE,GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO, b.location  LOCATION	FROM   OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'AOPR' AND A.INSTR_CODE  = B.INSTR_CODE  AND C.OPER_CODE  IN ("+oper_codes.toString()+") UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO, b.location  LOCATION  FROM    OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+")  AND A.INSTR_CODE = B.INSTR_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,A.NO_OF_UNITS TR_NO, b.location  LOCATION  FROM OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SCAT' AND A.SPECIALITY_CODE   = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE  = D.OPER_CODE  AND A.INSTR_CODE = B.INSTR_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO, b.location 	LOCATION  FROM OT_OPER_INSTRUMENT A, OT_INSTRUMENT  B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE AND A.INSTR_CODE = B.INSTR_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO, b.location LOCATION  FROM    OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SOPR'  AND A.OPER_CODE  IN ("+oper_codes.toString()+") AND A.OPER_CODE = C.OPER_CODE AND A.INSTR_CODE = B.INSTR_CODE";//MMS-QH-CRF-0199
				}
				else{
				PICK_LIST_UNDEFINED="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE,GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO 	FROM   OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'AOPR' AND A.INSTR_CODE  = B.INSTR_CODE  AND C.OPER_CODE  IN ("+oper_codes.toString()+") UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO FROM    OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+")  AND A.INSTR_CODE = B.INSTR_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,A.NO_OF_UNITS TR_NO FROM OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SCAT' AND A.SPECIALITY_CODE   = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE  = D.OPER_CODE  AND A.INSTR_CODE = B.INSTR_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO 	FROM OT_OPER_INSTRUMENT A, OT_INSTRUMENT  B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE AND A.INSTR_CODE = B.INSTR_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO FROM    OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SOPR'  AND A.OPER_CODE  IN ("+oper_codes.toString()+") AND A.OPER_CODE = C.OPER_CODE AND A.INSTR_CODE = B.INSTR_CODE";//MMS-QH-CRF-0199
				}
				//Query modified for CRF-0058 by Rajesh
				
				pstmt = con.prepareStatement(PICK_LIST_UNDEFINED);
				rst = pstmt.executeQuery();
				index =0;
				while(rst.next()){
					++index;	
					line_no = (String)line_no_map.get(rst.getString("OPR_CODE"));
				if(("true").equals(bill_flag))
			    {	
				bill_info = new HashMap();
				HashMap hash = billing_bean.getORBillingParams(oper_num);
				catalog_code = "S#"+rst.getString("ACC_CODE");
				key = oper_num+"@"+rst.getString("OPR_CODE")+"@S@"+rst.getString("ACC_CODE");
					p_qty = rst.getString("TR_NO");
					if(p_qty == null) p_qty="";
				key_line="";

				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				//ArrayList bill_dtls =or_bean.getBillChargeDetails(visit_id,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				ArrayList bill_dtls =or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info			 = billing_bean.formatBillingDetails(bill_dtls);
					hash.put("key",key);
					hash.put("key_line_no",key_line);
					hash.put("oper_code",rst.getString("ACC_CODE"));//pass acc_code in oper_code
					hash.put("acc_type","C");
					hash.put("oper_num",oper_num);
					hash.put("locale",locale);
					hash.put("quantity",p_qty);
				bill_info.putAll(hash);
				bill_info.put("quantity",p_qty);
				//set billing details from OTBillingBean........	
						if(from_val_overload.equals("N"))
		{
			
				or_bean.setOrderBillDtls(key,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);
		}
				String overridden_incl_excl_ind=null;

				panel_str = (String) bill_info.get("bl_panel_str");	
				bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"))).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E")).append("::");
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end of if bill_flag	
			//Modified for CRF-0058 by Rajesh
			if(Ot_param.equalsIgnoreCase("Y")){
			out.println("<script>loadDBRows_ic('"+checkForNull(rst.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("ACC_DESC")))+"','"+checkForNull(rst.getString("LOCATION"))+"','','"+index+"','"+oper_num+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','N','"+p_qty+"'); </script>");	
			}
			else{
				out.println("<script>loadDBRows_ic('"+checkForNull(rst.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("ACC_DESC")))+"','','','"+index+"','"+oper_num+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','N','"+p_qty+"'); </script>");
			}
			//Modified for CRF-0058 by Rajesh
			 }//end of while loop
			 if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
		
						
		}
								
				out.println("<script>refresh_acc('"+flag_acc+"','"+rec_implants_in_nurs_notes_yn+"','"+rec_equp_in_nurs_notes_yn+"','"+rec_instr_in_nurs_notes_yn+"','"+rec_packs_in_nurs_notes_yn+"','"+st_interface_flag+"')</script>");
				out.println("<script>assignRecId()</script>");
             
			   /* $$$$$$$$$$$$$$$$$$$$$$ Instrument?Cssc packs Code Ends Her$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/
		}else
		{
		   out.println("<script>refresh_acc('"+flag_acc+"','"+rec_implants_in_nurs_notes_yn+"','"+rec_equp_in_nurs_notes_yn+"','"+rec_instr_in_nurs_notes_yn+"','"+rec_packs_in_nurs_notes_yn+"','"+st_interface_flag+"')</script>");
		out.println("<script>assignRecId()</script>");
		}
			if(rst_ic!=null)rst_ic.close();
			if(pstmt_ic!=null)pstmt_ic.close();
			//out.println("<script>refresh_acc('"+flag_acc+"','"+rec_implants_in_nurs_notes_yn+"','"+rec_equp_in_nurs_notes_yn+"','"+rec_instr_in_nurs_notes_yn+"','"+rec_packs_in_nurs_notes_yn+"','"+st_interface_flag+"')</script>");
	//		out.println("<script>assignRecId()</script>");
			}

			   /* $$$$$$$$$$$$$$$$$$$$$$ Instrument?Cssc packs Code Ends Her$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/


	//	}
		}
		pstmt = con.prepareStatement(SQL1);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();


 
	%>

<% if(fromval.equals("prosimplants") && rec_implants_in_nurs_notes_yn.equals("Y")) {%>

<table border='0' cellpadding=3  cellspacing='0' width='100%' align="center">
<tr>

	  <td class="label" width='25%'>
				<fmt:message key="eOT.AccessoryType.Label" bundle="${ot_labels}"/> </td>
	  <td class="fields" width='25%'>
	    <select name="accesstype" id="accesstype"  <%=disable_flag%> disabled >
			 <option value='PI'  Selected>
			<fmt:message key="eOT.ProsthesisImplants.Label" bundle="${ot_labels}"/>
			</option>
			<option value='CP' >
			<fmt:message key="eOT.ConsumablePacks.Label" bundle="${ot_labels}"/>
			</option>
			<option value='EQ' >
			<fmt:message key="eOT.Equipments.Label" bundle="${ot_labels}"/>
			</option>
			<option value='IC' >
			<fmt:message key="eOT.InstrumentsCSSDPacks.Label" bundle="${ot_labels}"/>
			</option>
	    </select>
    </td>


	  <td class="label" width='25%'>
				<fmt:message key="Common.Implant.label" bundle="${common_labels}"/> </td>
	  <td class="fields" width='25%'>
		  <input type='hidden' name='implant_code' id='implant_code' > 
		  <input type='text' name='implant_desc' id='implant_desc' onBlur="if(this.value!='')searchProsthesis(implant_code,implant_desc);else{}"> 
		  <input type='button' class='button' value='?' name='ImplantLookUp' id='ImplantLookUp' onClick='searchProsthesis(implant_code,implant_desc);' <%=disable_flag%> > <img src='../../eCommon/images/mandatory.gif'></img>
	  </td>
 </tr>

 <tr>
 	 <td class="label" width='25%'>
			<fmt:message key="Common.operation.label" bundle="${common_labels}"/> </td>
     <td class="fields" width='25%'>
			<select class="my_dropdown" id="my_dropdown" name="operation" id="operation"  <%=disable_flag%> ><!--MMS-QH-CRF-0199-->
			<% while(rst.next()){ 
				val = rst.getString(1)+"##"+rst.getString(2);
				
			%>
			<option value='<%=val%>' title='<%=rst.getString(3)%>'> <%=rst.getString(3)%>  </option><!--MMS-QH-CRF-0199-->			
			<%}
			
			if(rst!=null)rst.close();
				if(pstmt!=null)pstmt.close();
			%>
			</select>
			 <img src='../../eCommon/images/mandatory.gif'></img>
    </td>
	<%if(("Y").equals(st_interface_flag)){%>

	  <td class="label" width='25%'><fmt:message key="eOT.ConsumptionStore.Label" bundle="${ot_labels}"/></td>
	  <td class="fields" width='25%'><input type='text' name='conns_store' id='conns_store' onblur="if(this.value!='')searchStore(this,conns_store,document.forms[0].operation);else{}"> <input type='hidden' name='req_store_code' id='req_store_code' value=''><input type='button' class='button' value='?' name='Cons_store_LookUp' id='Cons_store_LookUp' onClick='searchStore(this,conns_store,document.forms[0].operation);' <%=disable_flag%> ><img src='../../eCommon/images/mandatory.gif'></img> </td>	
<%}%>
 </tr>
<%if(("N").equals(st_interface_flag)){%>
<tr>

	 <td class="label" width='25%'><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/> </td>
     <td class="fields" width='25%'><input type='text' name='manufacturer' id='manufacturer' maxlength='30' size='20' <%=disable_flag%> ></td>

	 <td class="label" width='25%'><fmt:message key="Common.Batch.label" bundle="${common_labels}"/> </td>
     <td class="fields" width='25%'><input type='text' name='batch' id='batch' maxlength='30' size='20'  <%=disable_flag%> ></td>

</tr>
<%}%>
<%if(("Y").equals(st_interface_flag)){%>

<tr>

	 <td class="label" width='25%'><fmt:message key="eOT.ReservedPicklistUnits.Label" bundle="${ot_labels}"/> </td>
     <td class="fields" width='25%'><input type='text' name='Reservepicklist' id='Reservepicklist' maxlength='6' size='6'  disabled <%=disable_flag%> ></td>

	 <td class="label" width='25%'><fmt:message key="eOT.RequestedPicklistUnits.Label" bundle="${ot_labels}"/> </td>
     <td class="fields" width='25%'><input type='text' name='Requestpicklist' id='Requestpicklist' maxlength='6' size='6'  disabled <%=disable_flag%> ></td>

</tr>
<input type='hidden' name='sale_document_no' id='sale_document_no' value='<%=sale_document_no%>'>
<input type='hidden' name='sale_document_type' id='sale_document_type' value='<%=sale_document_type%>'>
<%}%>

<tr>
	 
	<%if(("Y").equals(st_interface_flag)){%>
 
	 <td class="label" width='25%'><fmt:message key="eOT.StockAvailable.Label" bundle="${ot_labels}"/> </td>
     <td class="fields" width='25%'><input type='text' name='Stockavail' id='Stockavail' maxlength='6' size='6'  value="" <%=disable_flag%> ></td>
	<%}%>
 
	 <td class="label" width='25%'><fmt:message key="eOT.ActualUnits.Label" bundle="${ot_labels}"/></td>
	 <td class="fields" width='25%'>
	 <%if(total_stock_val>0) {%><input type='text' name='quantity' id='quantity' maxlength='3' size='2' onkeypress="return checkForSpecCharsforID(event);"  onBlur="ChkNumber(this);"  value="<%=total_stock_val%>" <%=disable_flag%>>
	 <%}else {%><input type='text' name='quantity' id='quantity' maxlength='3' size='2' onkeypress="return checkForSpecCharsforID(event);"  onBlur="ChkNumber(this);"  <%=disable_flag%>><%}%><img src='../../eCommon/images/mandatory.gif'></img></td>

	 
</tr>

	<td></td>
	<td></td>
	<td class="label" width='25%'><input type='hidden' name='remarks' id='remarks' value="">
			<a  class="gridLink" href="javascript:openCheckListRemarksWindow(document.forms[0].remarks);">
				<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>
   	<td width='20%' class="button">
		<input type='button' class='button' name = 'select' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='assignCodes(document.forms[0].operation);addRow();' <%=disable_flag%> >
		<input type='button' name="btn_cancel" id="btn_cancel" class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow();' <%=disable_flag%> >
	</td>

</tr>
</table>

<% }else if(fromval.equals("Conspack")) {%>

<table border='0' cellpadding=3  cellspacing='0' width='100%' align="center">
<tr>

	  <td class="label" width='25%'>
				<fmt:message key="eOT.AccessoryType.Label" bundle="${ot_labels}"/> </td>
	  <td class="fields" width='25%'>
	    <select name="accesstype" id="accesstype"  <%=disable_flag1%> disabled>
			 <option value='PI'  >
			<fmt:message key="eOT.ProsthesisImplants.Label" bundle="${ot_labels}"/>
			</option>
			<option value='CP' Selected>
			<fmt:message key="eOT.ConsumablePacks.Label" bundle="${ot_labels}"/>
			</option>
			<option value='EQ' >
			<fmt:message key="eOT.Equipments.Label" bundle="${ot_labels}"/>
			</option>
			<option value='IC' >
			<fmt:message key="eOT.InstrumentsCSSDPacks.Label" bundle="${ot_labels}"/>
			</option>
	    </select>
    </td>

	 <td class="label" width='25%'>
			<fmt:message key="Common.operation.label" bundle="${common_labels}"/> </td>
     <td class="fields" width='25%'>
			<select class="my_dropdown" id="my_dropdown" name="operation_cp" id="operation_cp"  <%=disable_flag1%> ><!--MMS-QH-CRF-0199 -->
			<% while(rst.next()){ 
				val = rst.getString(1)+"##"+rst.getString(2);
				
			%>
			<option value='<%=val%>' title="<%=rst.getString(3)%>"> <%=rst.getString(3)%>  </option><!--MMS-QH-CRF-0199 -->
			<%}
			
			if(rst!=null)rst.close();
				if(pstmt!=null)pstmt.close();
			%>
			</select>
			 <img src='../../eCommon/images/mandatory.gif'></img>
    </td>
 </tr>

 <tr>
 
  
	    <td class="label" width="25%" ><fmt:message key="Common.Package.label" bundle="${common_labels}"/> </td>
	  <td width="25%">
		  <input type='hidden' name='package_code' id='package_code' > 
		  <input type='text' name='package_desc' id='package_desc' onBlur="if(this.value!='')searchPackage(package_code,package_desc);else{}"> 
		  <input type='button' class='button' value='?' name='PackageLookUp' id='PackageLookUp' onClick='searchPackage(package_code,package_desc);'<%=disable_flag1%> > <img src='../../eCommon/images/mandatory.gif'></img>
	  </td>

	  	 <td class="label" width='25%'><fmt:message key="eOT.ActualUnits.Label" bundle="${ot_labels}"/></td>
	 <td class="fields" width='25%'><input type='text' name='quantity_cp' id='quantity_cp' maxlength='3' size='2' onBlur="ChkNumber(this);" onkeypress="return checkForSpecCharsforID(event);"  <%=disable_flag1%>><img src='../../eCommon/images/mandatory.gif'></img></td>
		
 </tr>

<tr>
</tr>

	<td></td>
	<td></td>
	<td class="label" width='25%'>
	<input type='hidden' name='remarks_cp' id='remarks_cp' value="">
	<a   class="gridLink" href="javascript:openCheckListRemarksWindow_cp(document.forms[0].remarks_cp);">
	<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>
   	<td width='20%' class="button">
		<input type='button' name = 'select' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='assignCodes_cp(document.forms[0].operation_cp);addRow_cp();' <%=disable_flag1%> >
		<input type='button' name="btn_cancel" id="btn_cancel" class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow_cp();' <%=disable_flag1%> >
	</td>

</tr>
</table>
<% }else if(fromval.equals("equipments") && rec_equp_in_nurs_notes_yn.equals("Y"))
		 {%>


<table border='0' cellpadding=3 cellspacing='0' width='100%' align='center'>
<tr>
	 	  <td class="label" width='25%'>
				<fmt:message key="eOT.AccessoryType.Label" bundle="${ot_labels}"/> </td>
	  <td class="fields" width='25%'>
	    <select name="accesstype" id="accesstype"  <%=disable_flag2%> disabled >
			 <option value='PI'  >
			<fmt:message key="eOT.ProsthesisImplants.Label" bundle="${ot_labels}"/>
			</option>
			<option value='CP' >
			<fmt:message key="eOT.ConsumablePacks.Label" bundle="${ot_labels}"/>
			</option>
			<option value='EQ' Selected>
			<fmt:message key="eOT.Equipments.Label" bundle="${ot_labels}"/>
			</option>
			<option value='IC' >
			<fmt:message key="eOT.InstrumentsCSSDPacks.Label" bundle="${ot_labels}"/>
			</option>
	    </select>
    </td>


<td class="label" width="25%" ><fmt:message key="Common.operation.label" bundle="${common_labels}"/> </td>
     <td class="fields" width="25%" >
		<select class="my_dropdown" id="my_dropdown" name="operation_eq" id="operation_eq" <%=disable_flag2%> ><!--MMS-QH-CRF-0199 -->
		<% while(rst.next()){ 
			val = rst.getString(1)+"##"+rst.getString(2);
					
			
		%>
		<option value='<%=val%>' title="<%=rst.getString(3)%>"> <%=rst.getString(3)%>  </option><!--MMS-QH-CRF-0199 -->
	<%}%>
	</select>
	 <img src='../../eCommon/images/mandatory.gif'></img>
    </td>

	
 </tr>
<tr>



	  <td class="label" width="25%" >
		<fmt:message key="Common.equipment.label" bundle="${common_labels}"/> 
	  </td>
	  <td width="25%" class="fields">
		  <input type='hidden' name='equip_code' id='equip_code' > 
		  <input type='text' name='equip_desc' id='equip_desc' onBlur="if(this.value!='')searchEquipments(equip_code,equip_desc);else{equip_id.value=''}"> 
		  <input type='button' class='button' value='?' name='EquipmentLookUp' id='EquipmentLookUp' onClick='searchEquipments(equip_code,equip_desc);' <%=disable_flag2%> > <img src='../../eCommon/images/mandatory.gif'></img>
	  </td>

<!--Added by MuthuN against RUT-CRF-0091 on 13-May-2013 starts here-->
<% if(customer_id.equalsIgnoreCase("RTN")){%>
	<td class="label" width="25%" >
	<fmt:message key="Common.Location.label" bundle="${common_labels}"/> </td>
     <td width="25%" class="fields">
		<input type='text' name='st_location' id='st_location' maxlength='20' size='20' <%=disable_flag2%> > 
		<input type='hidden' name='equip_id' id='equip_id' value="">
	</td>
	<%}else{%>
		 <td class="label" width="25%" ><fmt:message key="eOT.EquipmentID.Label" bundle="${ot_labels}"/>  </td>
     <td width="25%" class="fields">
		<input type='text' name='equip_id' id='equip_id' maxlength='20' size='20' <%=disable_flag2%> > 
	</td>
	<%}%>
<!--Added by MuthuN against RUT-CRF-0091 ends here-->
</tr>
		 <td class="label" width='25%'><fmt:message key="eOT.ActualUnits.Label" bundle="${ot_labels}"/></td>
	 <td class="fields" width='25%'><input type='text' name='quantity_eq' id='quantity_eq' maxlength='3' size='2' onBlur="ChkNumber(this);" onkeypress="return checkForSpecCharsforID(event);"  <%=disable_flag2%>><img src='../../eCommon/images/mandatory.gif'></img></td>
	<td class="label" width='25%'>	
	<input type='hidden' name='remarks_eq' id='remarks_eq' value="">
	
			<a   class="gridLink" href="javascript:openCheckListRemarksWindow_eq(document.forms[0].remarks_eq);">
				<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>
   	<td width='20%' class="button">

		<input type='button' name = 'select' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='assignCodes_eq(document.forms[0].operation_eq);addRow_eq();'  <%=disable_flag2%>  >
		<input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow_eq();' <%=disable_flag2%> >

	</td>
</tr>
		<tr>
	<td class='label' width='25%'><fmt:message key="eOT.DateTime.label" bundle="${ot_labels}"/></td>	<!-- 047546 -->
			<td class='fields' width='25%'>
				<input type="text" name="desiredDate" id="desiredDate" id="desiredDate" size="16" value="<%=currentDateTime%>" maxlength="16" onkeypress="return checkForSpecCharsforID(event);" onblur="if(this.value!=''){ validateDate(this.value); chkDateRangeValidity(this.value); }">
				<img src='../../eCommon/images/CommonCalendar.gif' onclick="return showCalWithTime('desiredDate','%d/%m/%Y %H:%M','24',true,'desiredDate');"><img src='../../eCommon/images/mandatory.gif'></img>
			</td>
		</tr>

</table>

<%}else if(fromval.equals("InstruCSSD") && rec_instr_in_nurs_notes_yn.equals("Y")) {%>


<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center''>
<tr>

	  <td class="label" width='25%'>
				<fmt:message key="eOT.AccessoryType.Label" bundle="${ot_labels}"/> </td>
	  <td class="fields" width='25%'>
	    <select name="accesstype" id="accesstype"  <%=disable_flag3%> disabled>
			 <option value='PI'  >
			<fmt:message key="eOT.ProsthesisImplants.Label" bundle="${ot_labels}"/>
			</option>
			<option value='CP' >
			<fmt:message key="eOT.ConsumablePacks.Label" bundle="${ot_labels}"/>
			</option>
			<option value='EQ' >
			<fmt:message key="eOT.Equipments.Label" bundle="${ot_labels}"/>
			</option>
			<option value='IC' Selected>
			<fmt:message key="eOT.InstrumentsCSSDPacks.Label" bundle="${ot_labels}"/>
			</option>
	    </select>
    </td>


	<td class="label" width="25%">
			<fmt:message key="Common.operation.label" bundle="${common_labels}"/> </td>
	<td class="fields" width="25%" >
			<select class="my_dropdown" id="my_dropdown" name="operation_ic" id="operation_ic"  <%=disable_flag3%> ><!--MMS-QH-CRF-0199 -->
			<% while(rst.next()){ 
			val = rst.getString(1)+"##"+rst.getString(2);
//			String chk_val=rst.getString(3);
			%>
			<option value='<%=val%>' title="<%=rst.getString(3)%>"> <%=rst.getString(3)%>  </option><!--MMS-QH-CRF-0199 -->
			<% }
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();%>
			</select>
		<img src='../../eCommon/images/mandatory.gif'></img>
    </td>

	 
 </tr>
<tr>

	 <td class="label" width="25%" >
			<fmt:message key="Common.Instrument.label" bundle="${common_labels}"/> </td>
	  <td class="fields" width="25%">
		  <input type='hidden' name='instr_code' id='instr_code' > 
		  <input type='text' name='instr_desc' id='instr_desc' onBlur="if(this.value!='')searchInstrument(instr_code,instr_desc);else{}"> 
		  <input type='button' class='button' value='?' name='InstrumentLookUp' id='InstrumentLookUp' onClick='searchInstrument(instr_code,instr_desc);' <%=disable_flag3%> > <img src='../../eCommon/images/mandatory.gif'></img>
	  </td>
	<% if(Ot_param.equalsIgnoreCase("Y")){%>
	 <td class="label" width="25%" >
			<fmt:message key="Common.Location.label" bundle="${common_labels}"/> </td>
     <td class="fields" width="25%">
     		<!-- Modified By rajesh 29-8-2012 -->
			<input type='text' name='tray_no' id='tray_no' maxlength='30' size='20' disabled > 
			<!-- Modified By rajesh 29-8-2012 -->
	</td>
	<%}
	 else{%>
	  <td class="label" width="25%" >
			<fmt:message key="Common.TrayNo.label" bundle="${common_labels}"/> </td>
     <td class="fields" width="25%">
			<input type='text' name='tray_no' id='tray_no' maxlength='30' size='20' <%=disable_flag3%> > 
	</td>
	<%}%>	
</tr>


<td class="label" width='25%'><fmt:message key="eOT.ActualUnits.Label" bundle="${ot_labels}"/></td>
	 <td class="fields" width='25%'><input type='text' name='quantity_ic' id='quantity_ic' maxlength='3' size='2' onBlur="ChkNumber(this);" onkeypress="return checkForSpecCharsforID(event);"  <%=disable_flag3%>><img src='../../eCommon/images/mandatory.gif'></img></td>
	<td class="label" width='25%'>
	<input type='hidden' name='remarks_ic' id='remarks_ic' value="">
	
			<a   class="gridLink" href="javascript:openCheckListRemarksWindow_ic(document.forms[0].remarks_ic);">
				<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a>
	
	</td>
	<td width="25%" >
		<input type='button' id='sels' name = 'select' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='assignCodes(document.forms[0].operation_ic);addRow_ic();' <%=disable_flag3%> >
		<input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow_ic();' <%=disable_flag3%> >
	</td>
</tr>
</table>
<!-- Starts Added for the incident 38966 -->
<% if (fromvalFlag == 'Y') { %>
<script>		
	//if(ImplantsRecordForm.elements("fromvalFlag").value =='Y'){
		document.getElementById("sels").disabled=true;
		//}/*else{
//		ImplantsRecordForm.elements("sels").disable = false;
//	} */	      
   </script>
     <% } %>   
<!-- Ends Added for the incident 38966 -->
<%}%>

<!-- added by Sathish for Amazon Changes-->
<%if(rec_implants_in_nurs_notes_yn=="Y" || rec_instr_in_nurs_notes_yn=="Y" || rec_packs_in_nurs_notes_yn=="Y" || rec_equp_in_nurs_notes_yn=="Y") {
				if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}
				}%>
	<!-- end -->

	<%
		}catch(Exception e){
		 System.err.println("Err Msg in InstrumentRecord"+e.getMessage());
		 e.printStackTrace();
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(rst_Conspack!=null)rst_Conspack.close();
			if(pstmt_Conspack!=null)pstmt_Conspack.close();
			if(pstmt_room!=null)pstmt_room.close();
			if(rst_room!=null)rst_room.close();
			if(rset!=null)rset.close();
			if(pstmt_bl!=null)pstmt_bl.close();
			if(pstmt_doc_type!=null)pstmt_doc_type.close();
			if(rst_acc_reqyn!=null)   rst_acc_reqyn.close();
			if(pstmt_acc_reqyn!=null) pstmt_acc_reqyn.close();
			if(pstmt_req_store!=null) pstmt_req_store.close();
			if(stmt!=null) stmt.close();
			if(pstmt_st!=null) pstmt_st.close();
			if(rst_bl!=null) rst_bl.close();
			if(rset_req_store!=null) rset_req_store.close();
			if(rset_doc_type!=null) rset_doc_type.close();
			if(rst_eq!=null)		rst_eq.close();
			if(rst_ic!=null)		rst_ic.close();
		    if(pstmt_ic !=null)  pstmt_ic.close();
		    if(pstmt_eq !=null)  pstmt_eq.close();
			 
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){
			System.err.println("4056,Err Msg in Pros=========="+e.getMessage());		 
		 	e.printStackTrace();
		}
	}
  %>
    <input type='hidden' name='chk_val' id='chk_val' value="0">
	<input type='hidden' name='recId' id='recId' value=''>
	<input type='hidden' name='oper_code' id='oper_code' value=''>
	<input type='hidden' name='oper_line_no' id='oper_line_no' value=''>
	<input type='hidden' name='mode' id='mode' value='I'>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='oper_num' id='oper_num' value="<%=oper_num%>">
	<input type='hidden' name='bill_flag' id='bill_flag' value="<%=bill_flag%>">
	<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
	<input type='hidden' name='rec_implants_in_nurs_notes_yn' id='rec_implants_in_nurs_notes_yn' value="<%=rec_implants_in_nurs_notes_yn%>">
	<input type='hidden' name='rec_equp_in_nurs_notes_yn' id='rec_equp_in_nurs_notes_yn' value="<%=rec_equp_in_nurs_notes_yn%>">
	<input type='hidden' name='rec_instr_in_nurs_notes_yn' id='rec_instr_in_nurs_notes_yn' value="<%=rec_instr_in_nurs_notes_yn%>">
	<input type='hidden' name='rec_packs_in_nurs_notes_yn' id='rec_packs_in_nurs_notes_yn' value="<%=rec_packs_in_nurs_notes_yn%>">
	<input type='hidden' name='st_interface_flag' id='st_interface_flag' value="<%=st_interface_flag%>">
	<input type='hidden' name='oper_room_code' id='oper_room_code' value="<%=oper_room_code%>">
	<input type='hidden' name='fromval' id='fromval' value="<%=fromval%>">
	<input type='hidden' name='onLoadFlag' id='onLoadFlag' value="<%=onLoadFlag%>">
	<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>">
	<input type='hidden' name='encounter_id' id='encounter_id' value="<%=encounter_id%>">
	<input type='hidden' name='patient_class' id='patient_class' value="<%=patient_class%>">
	<input type='hidden' name='episode_type' id='episode_type' value="<%=bl_episode_type%>">
	<input type='hidden' name='mm_item_code' id='mm_item_code' value="<%=mm_item_code%>">
	<input type='hidden' name='item_id' id='item_id' value="<%=item_id%>">
	<input type='hidden' name='include_exclude_st' id='include_exclude_st' value="">
	<input type='hidden' name='reason_code_st' id='reason_code_st' value="">
	<input type='hidden' name='Ot_param' id='Ot_param' value="<%=Ot_param%>"><!--Added by lakshmi against crf-0058-->
	<input type='hidden' name='fromvalFlag' id='fromvalFlag' value="<%=fromvalFlag%>"><!-- Added for the incident 38966 -->
	<input type='hidden' name='customer_id' id='customer_id' value="<%=customer_id%>"><!-- Added for the CRF-0091 -->
	<input type='hidden' name='oneWeekDate' id='oneWeekDate' id='oneWeekDate' value="<%=oneWeekDate%>">
	<input type='hidden' name='checkInTime' id='checkInTime' id='checkInTime' value="<%=checkInTime%>">
	<% // if (fromvalFlag == 'Y') { %>
	<script>		
	  // disableSelectButton(document.forms[0].select);
   </script>
    <% //} %>
</form>
</BODY>
</HTML>



