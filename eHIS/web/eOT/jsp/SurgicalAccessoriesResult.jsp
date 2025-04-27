<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<HTML>
<%//@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.Common.*,eOT.*,eOT.Common.*" contentType=" text/html;charset=" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.util.HashMap,eOR.OrderEntryBillingQueryBean,eOT.OTBillingBean" contentType=" text/html;charset=UTF-8"  %>
<% request.setCharacterEncoding("UTF-8");%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<%@include file="../../eCommon/jsp/Common.jsp"%>

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
//Added code to get seesion values in OperationEquipmentsTab.jsp for scf-5515 by Anitha on 11/25/2010

HashMap temp = new HashMap();
temp=(HashMap)session.getAttribute("NursingDetails");

	 /*String implant_entry_cmp_yn = checkForNull(request.getParameter("implant_entry_cmp_yn")); 
	 String consumable_entry_cmp_yn = checkForNull(request.getParameter("consumable_entry_cmp_yn")); 
	 String equipment_entry_cmp_yn = checkForNull(request.getParameter("equipment_entry_cmp_yn")); 
	 String instrument_entry_cmp_yn = checkForNull(request.getParameter("instrument_entry_cmp_yn")); 
	  String st_interface_flag = checkForNull(request.getParameter("st_interface_flag")); 
	 String tab = checkForNull(request.getParameter("tab")); 
	
	 String bill_flag = request.getParameter("bill_flag");*/
	String oper_num = (String)temp.get("oper_num");

	 String implant_entry_cmp_yn =  (String)temp.get("implant_entry_cmp_yn"); 
	 String consumable_entry_cmp_yn =  (String)temp.get("consumable_entry_cmp_yn"); 
	 String equipment_entry_cmp_yn =  (String)temp.get("equipment_entry_cmp_yn"); 
	 String instrument_entry_cmp_yn =  (String)temp.get("instrument_entry_cmp_yn"); 
	  String st_interface_flag =  (String)temp.get("st_interface_flag"); 
	 String tab =  (String)temp.get("tab"); 
	
	 String bill_flag =  (String)temp.get("bill_flag");





String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
String style = "";
				style = "cursor:pointer";


%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language="JavaScript" src="../../eOT/js/RecordNursing.js"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

var code = new String();
var code_copk = new String();
var code_eq = new String();
var code_ic = new String();

 function setChkValue(obj)
 {
		if(obj.checked==true)
	    {
			obj.value="Y";
		}else 
	    {
			obj.value="N";
		}
			
			
 }
 var remarks_value=getLabel("Common.remarks.label","common");
 var equip_image=getLabel("Common.equipment.label","common"); //muthu
  var instr_image=getLabel("Common.Instrument.label","common"); //muthu

function opendialogwindow_pros(strVal,index,remarks){
//var remarks=encodeURIComponent(remarks,"UTF-8"); Added by anitha on 11/18/2010 for 23758
var rows = parent.parent.parent.ObjectCollect.implants_rows[index];
var remarks=encodeURIComponent(rows.remarks); 

	window.showModalDialog('../../eOT/jsp/TextArea.jsp?heading='+encodeURIComponent(strVal)+'&remarks='+remarks,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}

function opendialogwindow_cons(strVal,index,remarks){
//var remarks=encodeURIComponent(remarks);Added by anitha on 11/18/2010 for 23758
var rows = parent.parent.parent.ObjectCollect.packs_rows[index];
var remarks=encodeURIComponent(rows.remarks); 
 window.showModalDialog('../../eOT/jsp/TextArea.jsp?heading='+encodeURIComponent(strVal)+'&remarks='+remarks,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}

function openDialogWindow_eq(strVal,index,remarks){
//var remarks=encodeURIComponent(remarks);Added by anitha on 11/18/2010 for 23758
var rows = parent.parent.parent.ObjectCollect.equipment_rows[index];
var remarks=encodeURIComponent(rows.remarks); 
 window.showModalDialog('../../eOT/jsp/TextArea.jsp?heading='+encodeURIComponent(strVal)+'&remarks='+remarks,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}

//Added by Muthu for RUT-CRF-0057
function openDialogWindow_sur_eq_img(strVal,index,equip_code){
  var rows = parent.parent.parent.ObjectCollect.equipment_rows[index];
  var equip_code=encodeURIComponent(rows.equip_code);
	var title=encodeURIComponent(getLabel("Common.equipment.label","Common"));
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var params = equip_code;
	var xmlStr ="<root><SEARCH ";
	xmlStr +="/></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");		xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=check_Image_flag&equipment_code="+equip_code,false);
	xmlHttp.send(xmlDoc);	
	var sql_image_flag = trimString(xmlHttp.responseText);
	//RUT-CRF-0091 by MuthuN Starts Here
	var eq_location_array=sql_image_flag.split("~BR~");
	loc_eq=encodeURIComponent(eq_location_array[0]); 
	image_eq=eq_location_array[1];
	//RUT-CRF-0091 by MuthuN Ends Here
if(!sql_image_flag == "")
	{
		var dialogHeight 		= "0";
		var dialogWidth  		= "40";
		var dialogTop   		= "200";
		var dialogLeft   		= "100";
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "";
		var	param="image="+image_eq + "&location=" + loc_eq;
		retVal=window.showModalDialog("../../eOT/jsp/AdminEquipmentFrame.jsp?"+param,arguments,features);
	}
	else
	{
		alert(getMessage("NO_RECORD_FOUND","Common"));
	}	
}

function openDialogWindow_sur_ic_img(strVal,index,instr_code){
	 var rows = parent.parent.parent.ObjectCollect.instrument_rows[index];
     var instr_code=encodeURIComponent(rows.instr_code);
     var instr_desc=encodeURIComponent(rows.instr_desc);
    var title=encodeURIComponent(getLabel("Common.Instrument.label","Common"));
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var params = instr_code;
	var xmlStr ="<root><SEARCH ";
	xmlStr +="/></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=check_CSSD_Image_flag&instr_code="+instr_code,false);
	xmlHttp.send(xmlDoc);	
	var sql_cssd_image_flag = trimString(xmlHttp.responseText);
	//RUT-CRF-0091 by MuthuN Starts Here
	var ins_location_array=sql_cssd_image_flag.split("~BR~");
	loc_ins=encodeURIComponent(ins_location_array[0]);
	image_ins=ins_location_array[1];
	//RUT-CRF-0091 by MuthuN Ends Here
	//Modified by Rajesh for CRF-0057 for opening image always
	/*if(!sql_cssd_image_flag == "")
	{*/
		var dialogHeight 		= "0";
		var dialogWidth  		= "40";
		var dialogTop   		= "200";
		var dialogLeft   		= "100";
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "";
		var	param="instr_code="+instr_code+"&instr_desc="+instr_desc; 
		param=param+"&image="+image_ins;
		param=param+"&location="+loc_ins;
		retVal=window.showModalDialog("../../eOT/jsp/AdminInstrumentFrame.jsp?"+param,arguments,features);
	/*}
	else
	{
		alert(getMessage("NO_RECORD_FOUND","Common"));
	}*/
		//Modified by Rajesh for CRF-0057 for opening image always
}
//Added by Muthu for RUT-CRF-0057

function openDialogWindow_inst(strVal,index,remarks){
//var remarks=encodeURIComponent(remarks);Added by anitha on 11/18/2010 for 23758
var rows = parent.parent.parent.ObjectCollect.instrument_rows[index];
var remarks=encodeURIComponent(rows.remarks); 
 window.showModalDialog('../../eOT/jsp/TextArea.jsp?heading='+encodeURIComponent(strVal)+'&remarks='+remarks,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}
function sendparams(index){
	var rows = parent.parent.parent.ObjectCollect.implants_rows[index];
	var oper_code=rows.oper_code;
	var oper_desc=rows.oper_code+"##"+rows.oper_line_no;
	var line_no = rows.oper_line_no;
	var implant_code= rows.implant_code;
	var implant_desc = rows.implant_desc;
    var quantity=rows.quantity;
		var st_interface_flag=document.forms[0].st_interface_flag.value;
if(st_interface_flag =="Y")
	{
    var sale_document_no=rows.sale_document_no;
    var sale_document_type=rows.sale_document_type;
	}
	var mfr = rows.manufacturer;
	var batch = rows.batch;
	var remarks=rows.remarks;
	  // remarks=encodeURIComponent(remarks,"UTF-8"); 

	var recId = rows.recId;
	var mode = "U";
	var order = rows.order;
	if(st_interface_flag =="Y")
	{
	var reserved_qty =rows.reserved_qty;
    var requested_qty=rows.requested_qty;
    var req_store_code=rows.req_store_code;
    var Store_desc=rows.Store_desc;
    var Stockavail=rows.Stockavail;
	}
	
	var str = oper_code+'::'+oper_desc+'::'+line_no+'::'+implant_code+'::'+implant_desc+'::'+quantity+'::'+mfr+'::'+batch+'::'+remarks+'::'+recId+'::'+mode+'::'+order+'::'+reserved_qty+'::'+requested_qty+'::'+req_store_code+'::'+Stockavail+'::'+Store_desc;
	var frmObj = parent.ChildBaseFrame;
	frmObj.splitString(str);
}

function sendparams_cp(index){
	var rows = parent.parent.parent.ObjectCollect.packs_rows[index];
	var oper_code=rows.oper_code;
	var oper_desc=rows.oper_code+"##"+rows.oper_line_no;
	var line_no = rows.oper_line_no;
	var instr_code= rows.package_code;
	var instr_desc = rows.package_desc;
    var quantity=rows.quantity;
	var remarks=rows.remarks;
	var recId = rows.recId;
	var mode = "U";
	var str = oper_code+'::'+oper_desc+'::'+line_no+'::'+instr_code+'::'+instr_desc+'::'+remarks+'::'+quantity+'::'+recId+'::'+mode;
	var frmObj = parent.ChildBaseFrame;
	frmObj.splitString_cp(str);
}

function sendparams_eq(index){
	var rows = parent.parent.parent.ObjectCollect.equipment_rows[index];
	var customer_id =document.forms[0].customer_id.value;
	var oper_code=rows.oper_code;
	var oper_desc=rows.oper_code+"##"+rows.oper_line_no;
	var line_no = rows.oper_line_no;
	var instr_code= rows.equip_code;
	var instr_desc = rows.equip_desc;
    var tray_no=rows.equip_id; 
    var quantity=rows.quantity;
	var remarks=rows.remarks;
	var recId = rows.recId;
    var location_no=rows.st_location;
    var desiredDate = '';
    	desiredDate = rows.desiredDate;
	var mode = "U";
	var str = "";
	//var str = oper_code+'::'+oper_desc+'::'+line_no+'::'+instr_code+'::'+instr_desc+'::'+remarks+'::'+tray_no+'::'+recId+'::'+mode+'::'+quantity+'::'+location_no;	
	if (customer_id == "RTN")
		str = oper_code+'::'+oper_desc+'::'+line_no+'::'+instr_code+'::'+instr_desc+'::'+remarks+'::'+tray_no+'::'+recId+'::'+mode+'::'+quantity+'::'+location_no+'::'+desiredDate;
	else
		str = oper_code+'::'+oper_desc+'::'+line_no+'::'+instr_code+'::'+instr_desc+'::'+remarks+'::'+tray_no+'::'+recId+'::'+mode+'::'+quantity+'::'+desiredDate;
	var frmObj = parent.ChildBaseFrame;
	frmObj.splitString_eq(str);	
}

function sendparams_ic(index){
	var rows = parent.parent.parent.ObjectCollect.instrument_rows[index];
	var oper_code=rows.oper_code;
	var oper_desc=rows.oper_code+"##"+rows.oper_line_no;
	var line_no = rows.oper_line_no;
	var instr_code= rows.instr_code;
	var instr_desc = rows.instr_desc;
    var tray_no=rows.tray_no;
	  var quantity=rows.quantity;

	var remarks=rows.remarks;
	var recId = rows.recId;
	var mode = "U";
	var str = oper_code+'::'+oper_desc+'::'+line_no+'::'+instr_code+'::'+instr_desc+'::'+remarks+'::'+tray_no+'::'+recId+'::'+mode+'::'+quantity;

	  var frmObj = parent.ChildBaseFrame;
	frmObj.splitString_ic(str);
}


function enableSelectButton()
{
var frmObj =  parent.ChildBaseFrame.document.forms[0];

if(frmObj != null && frmObj.select != null)
	frmObj.select.disabled = false;
}

 function createTable(){
	    var formObj=document.forms[0];
		var rec_implants_in_nurs_notes_yn=formObj.rec_implants_in_nurs_notes_yn.value;
		var rec_instr_in_nurs_notes_yn=formObj.rec_instr_in_nurs_notes_yn.value;
		var rec_packs_in_nurs_notes_yn=formObj.rec_packs_in_nurs_notes_yn.value;
		var rec_equp_in_nurs_notes_yn=formObj.rec_equp_in_nurs_notes_yn.value;
		var st_interface_flag=formObj.st_interface_flag.value;
		var tab="<%=tab%>";
		var bill_flag="<%=bill_flag%>";	      
        	var args1='';
		var args2="";
		var args3="";
		var args4="";
		var row_len=0;
		var rows_copk="";
		var rows_ic="";
		var rows_eq="";
		var rows =parent.parent.parent.ObjectCollect.implants_rows;		
		var tab_data="";
		var imgUrl=document.Resultform.imgUrl.value;
		var style=document.Resultform.style.value;
		var flag_PI=document.Resultform.flag_PI.value;
		var flag_EQ=document.Resultform.flag_EQ.value;
		var flag_IC=document.Resultform.flag_IC.value;
		var flag_CO=document.Resultform.flag_CO.value;
		var OT_PARAM=document.Resultform.Ot_param.value;
		var CUSTOMER_ID=document.Resultform.customer_id.value;//Added by MuthuN against RUT-CRF-0091
	   /* **************************** Prothesis/Impalnts Starts Here******************************************/
	  if(rec_implants_in_nurs_notes_yn=="Y")
	   {
		  
	   tab_data+="<table border='0' cellpadding=0  cellspacing='0' width='100%' align='center'>";
	   tab_data+="<tr>";
	   tab_data+="<td class='label' width='100%' id='prosimplants' visibility:visible'>";
	   if (flag_PI =="Y")
	   {
			tab_data+="<img name='PI_arrow' src='../../eCommon/images/iGridNextNOR16.gif' style="+style+" onclick=\"javascript:expandselec('prosimplants')\"></img>";
	   }else
	   {
			tab_data+="<img name='PI_arrow' src='../../eCommon/images/tree_handledownmiddle.gif' style="+style+" onclick=\"javascript:expandselec('prosimplants')\"></img>";
	   }
		   
			   
	   tab_data+="<fmt:message key="eOT.ProsthesisImplants.Label" bundle="${ot_labels}"/>";
	   
	   <%if(!imgUrl.equals("")){%>
	   tab_data+=" <img src="+imgUrl+" width='100%' height='10'/> ";
	   <%}%>
	   tab_data+="</td></tr></table>";
		

		tab_data+="<tr>";
		tab_data+="<div id='menuExpand1' style='display:none;visibility:VISIBLE;overflow:auto;height:100px;width:100%'>";
		
		tab_data+="<table border='1' cellpadding='3' cellspacing='0' width='100%' align='center'>"
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.operation.label" bundle="${common_labels}"/></td>"
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Implant.label" bundle="${common_labels}"/></td>"
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.ActualUnits.Label" bundle="${ot_labels}"/></td>"
		if(st_interface_flag=="Y")
		{
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.ReservedPicklistUnits.Label" bundle="${common_labels}"/></td>"
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.RequestedPicklistUnits.Label" bundle="${common_labels}"/></td>"
		}
		if(st_interface_flag=="N")
		{
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/></td>"
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Batch.label" bundle="${common_labels}"/></td>"
		}
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>" 
			if(st_interface_flag=="Y")
		{
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.ConsumptionStore.Label" bundle="${common_labels}"/></td>" 
		}
		if(bill_flag=="true" ){
			
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Charge.label" bundle="${common_labels}"/></td>";
		tab_data+="<td class='columnHeaderCenter'>&nbsp;</td>";
		}

		
		
		  if(rows!=null){
			  
			   for(var jj=0;jj<rows.length;jj++) {
				   if(rows[jj]!=null  && rows[jj].db_mode!='D'){
						args1=jj;
						code+= rows[jj].oper_code+rows[jj].implant_code+",";
						if(jj%2==0)
						 qryVal="gridData";
					   else
						 qryVal="gridData";
					   
					   var no_of_units=rows[jj].quantity;
					   var remarks=encodeURIComponent(rows[jj].remarks,"UTF-8");
					   var Stockavail=rows[jj].Stockavail;
					   var manufacturer=rows[jj].manufacturer;
					   var batch=rows[jj].batch;
					   var frm_pick_list=rows[jj].frm_pick_list;
						if(frm_pick_list =="") frm_pick_list="N";


						<% if(implant_entry_cmp_yn.equals("Y") )
	    				  {%>
							//Added checkEmpty function on 9/28/2010 for 23976 by AnithaJ
						   tab_data+="<tr>";
						   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].oper_desc)+"</td>";
						   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].implant_desc)+"</td>";
						   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(no_of_units)+"</td>";
						   if(st_interface_flag=="Y")
							{	
						   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].reserved_qty)+"</td>";
						   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].requested_qty)+"</td>";
							}
						   if(st_interface_flag=="N")
		                   {
						   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(manufacturer)+"</td>";
						   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(batch)+"</td>";
						   }
						   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:opendialogwindow_pros(remarks_value,'"+jj+"','"+remarks+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/><input type='hidden' name='Stockavail' id='Stockavail' value='"+Stockavail+"'></a></td>";
						    if(st_interface_flag=="Y")
							{
						   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].Store_desc)+"</td>";
							}

						   if(bill_flag=="true" ){
						   var arr = rows[jj].bill_str.split("::");

						   var include_exclude=arr[8];
							var Appr_reqd=arr[5];
								var reason=arr[7];
								if(arr!= "")
				  {
						   tab_data+="<td  class="+qryVal+"><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.label" bundle="${or_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;<font color='crimson' ><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;<font color='green' ><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:"+arr[2]+"</font></B><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/>&nbsp;";
						   }else
						{
					   tab_data+="<td  class="+qryVal+"><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.label" bundle="${or_labels}"/>:&nbsp;0.0</font>&nbsp;&nbsp;<font color='crimson' ><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;0.0</font>&nbsp;&nbsp;<font color='green' ><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:0.0</font></B><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/>&nbsp;";
						}
					if(arr[6] == "S")
				  {
							if(include_exclude=="I") {
							tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
						   }else {
								tab_data+="<img width=15px  src='../../eCommon/images/disabled.gif'></img>";
							}
				   
					   tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";

						if(Appr_reqd=="Y") {
							tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
						   }else {
								tab_data+="<img  width=15px src='../../eCommon/images/disabled.gif'></img>";
						}

					}else{
										if(include_exclude=="I") {
										tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
									   }else {
										  tab_data+="<img width=15px  src='../../eCommon/images/blank.gif'></img>";
									  }
								   
									  tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";

										if(Appr_reqd=="Y") {
										tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
									   }else {
											tab_data+="<img  width=15px src='../../eCommon/images/blank.gif'></img>";
										}

							  }  	   


						 if(st_interface_flag=="N")
							   {
						  tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' class='gridLink' href=\"javascript:callBillingWindow_pi("+jj+",'"+frm_pick_list+"');\"><img src='../../eOT/images/dollar.png'></img></a></td>";
							   }else
							   {
								   tab_data+="<td nowrap class="+qryVal+"><img src='../../eOT/images/dollar.png'></img></td>";
							   }


						   }
							 
						 tab_data+="</tr>";
						<% }else
					   {%>
							//Added checkEmpty function on 9/28/2010 for 23976 by AnithaJ
						   tab_data+="<tr>";
						   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:sendparams("+args1+");\">"+checkEmpty(rows[jj].oper_desc)+"</a></td>";
						   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].implant_desc)+"</td>";
						   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(no_of_units)+"</td>";
						    if(st_interface_flag=="Y")
							{
						   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].reserved_qty)+"</td>";
						   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].requested_qty)+"</td>";
							}
						   if(st_interface_flag=="N")
		                   {
						   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].manufacturer)+"</td>";
						   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].batch)+"</td>";
						   }
						   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:opendialogwindow_pros(remarks_value,'"+jj+"','"+remarks+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/><input type='hidden' name='Stockavail' id='Stockavail' value='"+Stockavail+"'></a></td>";
						    if(st_interface_flag=="Y")
							{
						   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].Store_desc)+"</td>";
							}
						   if(bill_flag=="true" ){
						   var arr = rows[jj].bill_str.split("::");
						    var include_exclude=arr[8];
							var Appr_reqd=arr[5];
								var reason=arr[7];
								  if(arr !="")
				{
						   tab_data+="<td  class="+qryVal+"><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.label" bundle="${or_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson' ><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green' ><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:"+arr[2]+"</font></B><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/>&nbsp;";
				}else
						{
					   tab_data+="<td  class="+qryVal+"><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.label" bundle="${or_labels}"/>:&nbsp;0.0</font>&nbsp;&nbsp;<font color='crimson' ><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;0.0</font>&nbsp;&nbsp;<font color='green' ><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:0.0</font></B><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/>&nbsp;";
						}
						if(arr[6] == "S")
						 {
						
								if(include_exclude=="I") {
									tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
								   }else {
										tab_data+="<img width=15px  src='../../eCommon/images/disabled.gif'></img>";
								  }
							   
							   tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";

								if(Appr_reqd=="Y") {
									tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
								   }else {
										tab_data+="<img  width=15px src='../../eCommon/images/disabled.gif'></img>";
								}

						}else{
									if(include_exclude=="I") {
									tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
									}else {
									tab_data+="<img width=15px  src='../../eCommon/images/blank.gif'></img>";
									}
										   
									tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";

									if(Appr_reqd=="Y") {
									tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
									}else {
									tab_data+="<img  width=15px src='../../eCommon/images/blank.gif'></img>";
									}

							 }  		 

						if(st_interface_flag=="N")
							   {
						  tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' class='gridLink' href=\"javascript:callBillingWindow_pi("+jj+",'"+frm_pick_list+"');\"><img src='../../eOT/images/dollar.png'></img></a></td>";
							   }else
							   {
								   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' class='gridLink' href=\"javascript:callBillingWindow_st("+jj+",'"+Appr_reqd+"','"+include_exclude+"','"+arr[0]+"','"+arr[1]+"','"+arr[2]+"','"+arr[7]+"','"+rows[jj].req_store_code+"','"+no_of_units+"','"+rows[jj].implant_code+"','"+tab+"','"+arr[9]+"','"+rows[jj].sale_document_no+"','"+rows[jj].sale_document_type+"');\"><img src='../../eOT/images/dollar.png'></img></a></td>";
							   }
						   }
							 
						 tab_data+="</tr>";
					  <% }%>
				 }
			  }
			 }
         
	     tab_data+="</table>";
		 tab_data+="</div>";
		 tab_data+="</tr>";
	   }
          /* **************************** Prothesis/Impalnts Code Ends Here******************************************/
          
           /* ########################### Consumable packs Code Starts Here#########################################*/

		   if(tab!="record_surgeon")
	 {
		   if(rec_packs_in_nurs_notes_yn=="Y")
	      {
			  
		  tab_data+="<table border='0' cellpadding=0  cellspacing='0' width='100%' align='center'>";
		  tab_data+="<tr>";
	 	  tab_data+="<td class='label' width='100%' id='Conspack' visibility:visible>";
		     
		  if (flag_CO =="Y")
		   {
			    tab_data+="<img name='CO_arrow' src='../../eCommon/images/iGridNextNOR16.gif' style="+style+" onclick=\"javascript:expandselec('Conspack')\"></img>";
		   }else
		   {
			    tab_data+="<img name='CO_arrow' src='../../eCommon/images/tree_handledownmiddle.gif' style="+style+" onclick=\"javascript:expandselec('Conspack')\"></img>";
		   }
		   
			  
		  tab_data+="<fmt:message key="eOT.ConsumablePacks.Label" bundle="${ot_labels}"/>";

	     <%if(!imgUrl.equals("")){ %>
		  tab_data+=" <img src="+imgUrl+" width='100%' height='10'/> ";
	     <%}%>
		tab_data+="</td></tr></table>";

		  tab_data+="<tr>";
		  tab_data+="<div id='menuExpand2' style='display:none;visibility:VISIBLE;overflow:auto;height:100px;width:100%'>";
		
		  tab_data+="<table border='1' cellpadding='3' cellspacing='0' width='100%' align='center'>"
		  tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.operation.label" bundle="${common_labels}"/></td>"
		  tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Package.label" bundle="${common_labels}"/></td>"
		  tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.ActualUnits.Label" bundle="${ot_labels}"/></td>"

		  tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>" 
          <%if(("true").equals(bill_flag)){%>
		  tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Charge.label" bundle="${common_labels}"/></td>";
		  tab_data+="<td class='columnHeaderCenter'></td>";
          <%}%>
			
		   rows_copk= parent.parent.parent.ObjectCollect.packs_rows;
		   
		   row_len=rows_copk.length;
			
				 if(rows_copk!=null){
				   for(var ii=0;ii<rows_copk.length;ii++) {
					  

					   if(rows_copk[ii]!=null  && rows_copk[ii].db_mode!='D'){
						 args2=ii;
							code_copk+= rows_copk[ii].oper_code+rows_copk[ii].package_code+",";
						   if(ii%2==0)
							 qryVal="gridData";
						   else
							 qryVal="gridData";


						var remarks=rows_copk[ii].remarks;
						
						  var frm_pick_list=rows_copk[ii].frm_pick_list;
						if(frm_pick_list =="") frm_pick_list="N";
							 <% if( consumable_entry_cmp_yn.equals("Y") ) { %> 
							   tab_data+="<tr>";
							   tab_data+="<td nowrap class="+qryVal+">"+rows_copk[ii].oper_desc+"</td>";
							   tab_data+="<td nowrap class="+qryVal+">"+rows_copk[ii].package_desc+"</td>";
							   tab_data+="<td nowrap class="+qryVal+">"+rows_copk[ii].quantity+"</td>";
						
							   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:opendialogwindow_cons(remarks_value,'"+ii+"','"+remarks+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>";
							//   tab_data+="<td nowrap class="+qryVal+">"+rows_copk[ii].req_store_code+"</td>";
							   <%if(("true").equals(bill_flag)){//// added this condition by sathish on 10-01-2009 to disabling billingpart when bl_interface_flag unchecked(when billing not required)%>
							    var arr = rows_copk[ii].bill_str_conspack.split("::");
								 var include_exclude=arr[8];
								var Appr_reqd=arr[5];
								var reason=arr[7];
								var serv_panel_ind=arr[6];

							   tab_data+="<td  class="+qryVal+"><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.label" bundle="${or_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson' ><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green' ><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font></b><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/>&nbsp;";

						   if(serv_panel_ind == "S")
						  {
									 if(include_exclude=="I") {
										tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
									   }else {
											tab_data+="<img width=15px  src='../../eCommon/images/disabled.gif'></img>";
									  }
								   
								   tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";

									if(Appr_reqd=="Y") {
										tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
									   }else {
											tab_data+="<img  width=15px src='../../eCommon/images/disabled.gif'></img>";
									}

						}else{
										if(include_exclude=="I") {
										tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
									   }else {
										  tab_data+="<img width=15px  src='../../eCommon/images/blank.gif'></img>";
									  }
								   
									  tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";

										if(Appr_reqd=="Y") {
										tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
									   }else {
											tab_data+="<img  width=15px src='../../eCommon/images/blank.gif'></img>";
										}

							  }      


							//  tab_data+="<td nowrap class="+qryVal+"><img src='../../eOT/images/dollar.png'></img></td>";

 tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_cp("+ii+",'"+frm_pick_list+"');\"><img src='../../eOT/images/dollar.png'></img></a></td>";

							 <%}%>
							   tab_data+="</tr>";
							   <%}else {%>
								   
							   tab_data+="<tr>";
							   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:sendparams_cp("+args2+");\">"+rows_copk[ii].oper_desc+"</a></td>";
							   tab_data+="<td nowrap class="+qryVal+">"+rows_copk[ii].package_desc+"</td>";
							   tab_data+="<td nowrap class="+qryVal+">"+rows_copk[ii].quantity+"</td>";
							//   tab_data+="<td nowrap class="+qryVal+">"+rows_copk[ii].reserved_qty+"</td>";
							//   tab_data+="<td nowrap class="+qryVal+">"+rows_copk[ii].requested_qty+"</td>";6/9/2009
							   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:opendialogwindow_cons(remarks_value,'"+ii+"','"+remarks+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>";
							//   tab_data+="<td nowrap class="+qryVal+">"+rows_copk[ii].req_store_code+"</td>";
							   <%if(("true").equals(bill_flag)){//// added this condition by sathish on 10-01-2009 to disabling billingpart when bl_interface_flag unchecked(when billing not required)%>

								 var arr = rows_copk[ii].bill_str_conspack.split("::");
								 var include_exclude=arr[8];
								var Appr_reqd=arr[5];
								var reason=arr[7];
								var serv_panel_ind=arr[6];

							     tab_data+="<td  class="+qryVal+"><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.label" bundle="${or_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson' ><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green' ><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font></B><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/>&nbsp;";
						   if(serv_panel_ind== "S")
								   {
										  if(include_exclude=="I") {
											tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
										   }else {
												tab_data+="<img width=15px  src='../../eCommon/images/disabled.gif'></img>";
										  }
									   
										   tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";

											if(Appr_reqd=="Y") {
												tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
											   }else {
													tab_data+="<img  width=15px src='../../eCommon/images/disabled.gif'></img>";
											}

								}else{
										if(include_exclude=="I") {
										tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
									   }else {
										  tab_data+="<img width=15px  src='../../eCommon/images/blank.gif'></img>";
									  }
								   
									  tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";

										if(Appr_reqd=="Y") {
										tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
									   }else {
											tab_data+="<img  width=15px src='../../eCommon/images/blank.gif'></img>";
										}

							  }  

							  tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_cp("+ii+",'"+frm_pick_list+"');\"><img src='../../eOT/images/dollar.png'></img></a></td>";
							 <%}%>
							   tab_data+="</tr>";
							<%}%>
					   }
				 }
			  }
			  
		tab_data+="</table>";
		tab_data+="</div>";
		tab_data+="</tr>";
		  }
         
		 /* ########################### Consumable packs Code Ends Here#########################################*/

		 /* @@@@@@@@@@@@@@@@@@@@@@@@@@@ Equipments Code Starts Here @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

		if(rec_equp_in_nurs_notes_yn=="Y")
		{
			if(OT_PARAM=="Y" || OT_PARAM=="y")
			{
				tab_data+="<table border='0' cellpadding=0  cellspacing='0' width='100%' align='center'>";
				tab_data+="<tr>";
				tab_data+="<td class='label' width='100%'  id='equipments'  visibility:visible>";
				if (flag_EQ =="Y")
					tab_data+="<img name='EQ_arrow' src='../../eCommon/images/iGridNextNOR16.gif' style="+style+" onclick=\"javascript:expandselec('equipments')\"></img>";
				else
					tab_data+="<img name='EQ_arrow' src='../../eCommon/images/tree_handledownmiddle.gif' style="+style+" onclick=\"javascript:expandselec('equipments')\"></img>";
				tab_data+="<fmt:message key="eOT.Equipments.Label" bundle="${ot_labels}"/>";
				
				
                
<%
				if(!imgUrl.equals(""))
				{
%>
					tab_data+=" <img src="+imgUrl+" width='100%' height='10'/>"; 
<%
				}
%>
				tab_data+="</td></tr></table>";
				tab_data+="<tr>";
				tab_data+="<div id='menuExpand3' style='display:none;visibility:VISIBLE;overflow:auto;height:100px;width:100%'>";
				tab_data+="<table border='1' cellpadding=3 cellspacing='0' width='100%' align='center'>";
				//Added by Muthu for RUT-CRF-0057
				tab_data+="<td class='columnHeaderCenter'></td>"
				//Added by Muthu for RUT-CRF-0057
				tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.operation.label" bundle="${common_labels}"/></td>"
				tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Package.label" bundle="${common_labels}"/></td>";
				tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.DateTime.label" bundle="${ot_labels}"/></td>";<!-- 047546 -->
				tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.ActualUnits.Label" bundle="${ot_labels}"/></td>"
				//Added by MuthuN against RUT-CRF-0091 on 10-05-13 starts here
				if(CUSTOMER_ID == "RTN")
					tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>"
				else
					tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.EquipmentID.Label" bundle="${ot_labels}"/></td>";
				//Added by MuthuN against RUT-CRF-0091 on 10-05-13 ends here
				tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>";

<%
				if(("true").equals(bill_flag))
				{
%>
					tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Charge.label" bundle="${common_labels}"/></td>";
					tab_data+="<td class='columnHeaderCenter'></td>";
<%
				}
%>


				rows_eq=parent.parent.parent.ObjectCollect.equipment_rows;
				if(rows_eq!=null)
				{
					for(var kk=0;kk<rows_eq.length;kk++)
					{
						if(rows_eq[kk]!=null  && rows_eq[kk].db_mode!='D')
						{
							args3=kk;
							code_eq+= rows_eq[kk].oper_code+rows_eq[kk].equip_code+",";
							if(kk%2==0)
								qryVal="gridData";
							else
								qryVal="gridData";

							var remarks=rows_eq[kk].remarks;
							var equip_code = rows_eq[kk].equip_code; //Added by Muthu for RUT-CRF-0057
							var frm_pick_list=rows_eq[kk].frm_pick_list;
							if(frm_pick_list =="")
								frm_pick_list="N";
							var no_of_units=rows_eq[kk].quantity;
							if(no_of_units ==null)
								no_of_units="";
<%
							System.out.println("====equipment_entry_cmp_yn===="+equipment_entry_cmp_yn);
							if( equipment_entry_cmp_yn.equals("Y") )
							{
%> 
								tab_data+="<tr>";
								//Added by Muthu for RUT-CRF-0057
								tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\" javascript:openDialogWindow_sur_eq_img(equip_image,'"+kk+"','"+rows_eq[kk].equip_code+"');\"><img src='../../eOT/images/nolines_plus.gif'></img></a></td>";
								//Added by Muthu for RUT-CRF-0057
								tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].oper_desc)+"</td>";
								tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].equip_desc)+"</td>";
									tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].desiredDate)+"</td>";
								tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(no_of_units)+"</td>";
								if(CUSTOMER_ID == "RTN")
									tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].st_location)+"</td>";
								else
									tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].equip_id)+"</td>";//Added by MuthuN against 39535 on 13/05/2013
								tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow_eq(remarks_value,'"+kk+"','"+remarks+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>";		   

<%
								if(("true").equals(bill_flag))
								{
%>
									var arr = rows_eq[kk].bill_str.split("::");
									var include_exclude=arr[8];
									var Appr_reqd=arr[5];
									var reason=arr[7];
									tab_data+="<td  class="+qryVal+"><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.label" bundle="${or_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson' ><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green' ><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font></B><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/>&nbsp;";
									if(arr[6]=="S")
									{
										if(include_exclude=="I")
											tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
										else
											tab_data+="<img width=15px  src='../../eCommon/images/disabled.gif'></img>";
										tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";
										if(Appr_reqd=="Y")
											tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
										else
											tab_data+="<img  width=15px src='../../eCommon/images/disabled.gif'></img>";
									}
									else
									{
										if(include_exclude=="I")
											tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
										else 
											tab_data+="<img width=15px  src='../../eCommon/images/blank.gif'></img>";

										tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";

										if(Appr_reqd=="Y")
											tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
										else 
											tab_data+="<img  width=15px src='../../eCommon/images/blank.gif'></img>";
									}

									tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_eq("+kk+",'"+frm_pick_list+"');\"><img src='../../eOT/images/dollar.png'></img></a></td>";
<%
								}
%>
								tab_data+="</tr>";
<%
							}
							else
							{
%>								tab_data+="<tr>";
								//Added by Muthu for RUT-CRF-0057
								tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\" javascript:openDialogWindow_sur_eq_img(equip_image,'"+kk+"','"+rows_eq[kk].equip_code+"');\"><img src='../../eOT/images/nolines_plus.gif'></img></a></td>";
								//Added by Muthu for RUT-CRF-0057
								tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:sendparams_eq("+args3+");\">"+checkEmpty(rows_eq[kk].oper_desc)+"</a></td>";
								//Added by MuthuN against 39535 on 13/05/2013
								var equip_code_id=(rows_eq[kk].equip_code)==null?checkEmpty(rows_eq[kk].equip_id):checkEmpty(rows_eq[kk].equip_code);
								//Added by MuthuN against 39535 on 13/05/2013
								tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].equip_desc)+"</td>";
									tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].desiredDate)+"</td>";
								tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(no_of_units)+"</td>";
								if(CUSTOMER_ID == "RTN")
									tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].st_location)+"</td>";
								else
									tab_data+="<td nowrap class="+qryVal+">"+equip_code_id+"</td>";//Added by MuthuN against 39535 on 13/05/2013
								/*tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].equip_code)+"</td>"; Rameez Alpha-OT-Equipment Id is not displayed in the field [IN:039535]*/
								tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow_eq(remarks_value,'"+kk+"','"+rows_eq[kk].remarks+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>";
<%
								if(("true").equals(bill_flag))
								{
%>									var bill_str = rows_eq[kk].bill_str;
									var arr=bill_str.split("::");
									var include_exclude=arr[8];
									var Appr_reqd=arr[5];
									var reason=arr[7];
									tab_data+="<td  class="+qryVal+"><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.label" bundle="${or_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson' ><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green' ><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font></B><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/>&nbsp;";
									if(arr[6]=="S")
									{
										if(include_exclude=="I")
											tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
										else 
											tab_data+="<img width=15px  src='../../eCommon/images/disabled.gif'></img>";
										tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";
										if(Appr_reqd=="Y") 
											tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
										else 
											tab_data+="<img  width=15px src='../../eCommon/images/disabled.gif'></img>";
									}
									else
									{
										if(include_exclude=="I") 
											tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
										else
											tab_data+="<img width=15px  src='../../eCommon/images/blank.gif'></img>";
										tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";
										if(Appr_reqd=="Y") 
											tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
										else 
											tab_data+="<img  width=15px src='../../eCommon/images/blank.gif'></img>";
									}
									tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_eq("+kk+",'"+frm_pick_list+"');\"><img src='../../eOT/images/dollar.png'></img></a></td>";
<%
								}
%>
								tab_data+="</tr>"; 
<%
							}
%>
						}
					}
				}
				tab_data+="</table>";
				tab_data+="</div>";
				tab_data+="</tr>";
			}
			else
			{
				tab_data+="<table border='0' cellpadding=0  cellspacing='0' width='100%' align='center'>";
				tab_data+="<tr>";
				tab_data+="<td class='label' width='100%'  id='equipments'  visibility:visible>";

				if (flag_EQ =="Y")
					tab_data+="<img name='EQ_arrow' src='../../eCommon/images/iGridNextNOR16.gif' style="+style+" onclick=\"javascript:expandselec('equipments')\"></img>";
				else
					tab_data+="<img name='EQ_arrow' src='../../eCommon/images/tree_handledownmiddle.gif' style="+style+" onclick=\"javascript:expandselec('equipments')\"></img>";

				tab_data+="<fmt:message key="eOT.Equipments.Label" bundle="${ot_labels}"/>";
				

<%
				if(!imgUrl.equals(""))
				{
%>
					tab_data+=" <img src="+imgUrl+" width='100%' height='10'/>"; 
<%
				}
%>
				tab_data+="</td></tr></table>";
				tab_data+="<tr>";
				tab_data+="<div id='menuExpand3' style='display:none;visibility:VISIBLE;overflow:auto;height:100px;width:100%'>";

				tab_data+="<table border='1' cellpadding=3 cellspacing='0' width='100%' align='center'>";
				//Added by Muthu for RUT-CRF-0057
				//		tab_data+="<td class='columnHeaderCenter'></td>"
				//Added by Muthu for RUT-CRF-0057

				tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.operation.label" bundle="${common_labels}"/></td>"
				tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Package.label" bundle="${common_labels}"/></td>";
				tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.DateTime.label" bundle="${ot_labels}"/></td>";<!-- 047546 -->
				tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.ActualUnits.Label" bundle="${ot_labels}"/></td>"
				tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.EquipmentID.Label" bundle="${ot_labels}"/></td>";
				tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>";				
				
<%
				if(("true").equals(bill_flag))
				{
%>
					tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Charge.label" bundle="${common_labels}"/></td>";
					tab_data+="<td class='columnHeaderCenter'></td>";
<%
				}
%>				/* Added newly start AMRI-CRF-0294 [IN049121](Header) step-1*/ 
				tab_data+="<td nowrap class='columnHeaderCenter'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>"  
				/* Added newly End AMRI-CRF-0294 [IN049121*/
        
				rows_eq=parent.parent.parent.ObjectCollect.equipment_rows;
					
				if(rows_eq!=null)
				{
					for(var kk=0;kk<rows_eq.length;kk++) 
					{
						//if(rows_eq[kk]!=null && rows_eq[kk].db_mode!='D') //step-2
						if(rows_eq[kk]!=null  )//&& rows_eq[kk].db_mode!='D') //added AMRI-CRF-0294 [IN049121]
						{	
							args3=kk;
							code_eq+= rows_eq[kk].oper_code+rows_eq[kk].equip_code+",";
							if(kk%2==0)
								qryVal="gridData";
							else
								qryVal="gridData";

							var remarks=rows_eq[kk].remarks;
							var equip_code = rows_eq[kk].equip_code; //Added by Muthu for RUT-CRF-0057
							var frm_pick_list=rows_eq[kk].frm_pick_list;
							if(frm_pick_list =="") 
								frm_pick_list="N";
							var no_of_units=rows_eq[kk].quantity;
							if(no_of_units ==null) 
								no_of_units="";
							//Added for 294-crf
							// oper_line_status is validation for existing records	
							var oper_line_status1=rows_eq[kk].oper_line_status; 	
							if(oper_line_status1 == null)  oper_line_status1="";
							// added for 294-crf
<% 
							if( equipment_entry_cmp_yn.equals("Y") )
							{
%>							tab_data+="<tr>";
						
						/*Added by Muthu for RUT-CRF-0057
								tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\" javascript:openDialogWindow_sur_eq_img(equip_image,'"+kk+"','"+rows_eq[kk].equip_code+"');\"><img src='../../eOT/images/nolines_plus.gif'></img></a></td>";
								//Added by Muthu for RUT-CRF-0057*/	

								tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].oper_desc)+"</td>";
								tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].equip_desc)+"</td>";
								tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].desiredDate)+"</td>";
								tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(no_of_units)+"</td>";
								tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].equip_code)+"</td>";//048103
								tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow_eq(remarks_value,'"+kk+"','"+remarks+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>";
<%
								if(("true").equals(bill_flag))
								{
%>
									var arr = rows_eq[kk].bill_str.split("::");

									var include_exclude=arr[8];
									var Appr_reqd=arr[5];
									var reason=arr[7];
									tab_data+="<td  class="+qryVal+"><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.label" bundle="${or_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson' ><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green' ><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font></B><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/>&nbsp;";
									if(arr[6]=="S")
									{
										if(include_exclude=="I") 
											tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
										else
											tab_data+="<img width=15px  src='../../eCommon/images/disabled.gif'></img>";

										tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";
										if(Appr_reqd=="Y") 
											tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
										else 
											tab_data+="<img  width=15px src='../../eCommon/images/disabled.gif'></img>";
									}
									else
									{
										if(include_exclude=="I") 
											tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
										else 
											tab_data+="<img width=15px  src='../../eCommon/images/blank.gif'></img>";

										tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";
										if(Appr_reqd=="Y") 
											tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
										else 
											tab_data+="<img  width=15px src='../../eCommon/images/blank.gif'></img>";
									}
									tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_eq("+kk+",'"+frm_pick_list+"');\"><img src='../../eOT/images/dollar.png'></img></a></td>";
<%
								}
%>								// Added against start AMRI-CRF-0294 [IN049121] step-3
							 	if(rows_eq[kk].db_mode=='D' || oper_line_status1=='99')
								{
									tab_data+="<td nowrap class="+qryVal+"><img src='../../eCommon/images/RRnwd.gif'></img></td>";
								} 
								// Added against end AMRI-CRF-0294 [IN049121
								tab_data+="</tr>";
<%
							}
							else
							{
%>								tab_data+="<tr>";
								if(rows_eq[kk].db_mode=="D" || oper_line_status1=='99') //added AMRI-CRF-0294 [IN049121] step-4
								{
									tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].oper_desc)+"</td>";
								}
								else{ 	
								tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:sendparams_eq("+args3+");\">"+checkEmpty(rows_eq[kk].oper_desc)+"</a></td>";
								}
								//tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:sendparams_eq("+args3+");\">"+checkEmpty(rows_eq[kk].oper_desc)+"</a></td>"; // commented AMRI-CRF-0294 [IN049121]
								tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].equip_desc)+"</td>";
								tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].desiredDate)+"</td>";
								tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(no_of_units)+"</td>";
								tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].equip_code)+"</td>";//048103
								tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow_eq(remarks_value,'"+kk+"','"+rows_eq[kk].remarks+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>";
<%
								if(("true").equals(bill_flag))
								{
%>
									var bill_str = rows_eq[kk].bill_str;
									var arr=bill_str.split("::");

									var include_exclude=arr[8];
									var Appr_reqd=arr[5];
									var reason=arr[7];

									tab_data+="<td  class="+qryVal+"><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.label" bundle="${or_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson' ><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green' ><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font></B><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/>&nbsp;";
									if(arr[6]=="S")
									{
										if(include_exclude=="I") 
											tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
										else 
											tab_data+="<img width=15px  src='../../eCommon/images/disabled.gif'></img>";
										tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";
										if(Appr_reqd=="Y") 
											tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
										else
											tab_data+="<img  width=15px src='../../eCommon/images/disabled.gif'></img>";
									}
									else
									{
										if(include_exclude=="I") 
											tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
										else 
											tab_data+="<img width=15px  src='../../eCommon/images/blank.gif'></img>";
										tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";
										if(Appr_reqd=="Y")
											tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
										else
											tab_data+="<img  width=15px src='../../eCommon/images/blank.gif'></img>";
									}
									tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_eq("+kk+",'"+frm_pick_list+"');\"><img src='../../eOT/images/dollar.png'></img></a></td>";
<%
								}
%>								// Added against start AMRI-CRF-0294 [IN049121] step-3
							 	if(rows_eq[kk].db_mode=='D' || oper_line_status1=='99')
								{
									tab_data+="<td nowrap class="+qryVal+"><img src='../../eCommon/images/RRnwd.gif'></img></td>";
								} 
								// Added against end AMRI-CRF-0294 [IN049121
								tab_data+="</tr>"; 
<%
							}
%>							 
						}
					}
				}
				tab_data+="</table>";
				tab_data+="</div>";
				tab_data+="</tr>";
			}
		}
          /* @@@@@@@@@@@@@@@@@@@@@@@@@@@ Equipments Code Ends Here @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
		
         /* @@@@@@@@@@@@@@@@@@@@@@@@@@@ Instrumnets/CSSD Code StartsHere @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
		
		 if(rec_instr_in_nurs_notes_yn=="Y"){	
			  if(OT_PARAM=="Y" || OT_PARAM=="y"){				 	
		 tab_data+="<table border='0' cellpadding=0  cellspacing='0' width='100%' align='center'>";
		 tab_data+="<tr>";

		 tab_data+="<td class='label' width='100%'  id='InstruCSSD'  visibility:visible>";
		
		 if (flag_IC =="Y")
		   {
			    tab_data+="<img name='IC_arrow' src='../../eCommon/images/iGridNextNOR16.gif' style="+style+" onclick=\"javascript:expandselec('InstruCSSD')\"></img>";
		   }else
		   {
			    tab_data+="<img name='IC_arrow' src='../../eCommon/images/tree_handledownmiddle.gif' style="+style+" onclick=\"javascript:expandselec('InstruCSSD')\"></img>";
		   }  
			   
		   tab_data+="<fmt:message key="eOT.InstrumentsCSSDPacks.Label" bundle="${ot_labels}"/>";

	 <%if(!imgUrl.equals("")){ %>
		tab_data+=" <img src="+imgUrl+" width='100%' height='10'/> ";
	<%}%>
		tab_data+="</td></tr></table>";

		  tab_data+="<tr>";


		  tab_data+="<div id='menuExpand4' style='display:none;visibility:VISIBLE;overflow:auto;height:100px;width:100%'>";		
		  tab_data+="<table border='1' cellpadding='3' cellspacing='0' width='100%' align='center'>"

//Added by Muthu for RUT-CRF-0057
		tab_data+="<td class='columnHeaderCenter'></td>"
//Added by Muthu for RUT-CRF-0057

		  tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.operation.label" bundle="${common_labels}"/></td>"
		  tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Instrument.label" bundle="${common_labels}"/></td>"
 		  tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.ActualUnits.Label" bundle="${ot_labels}"/></td>"
          tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>"		 
		  tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>" 
		  <%if(("true").equals(bill_flag)){// added this condition by sathish on 10-01-2009 to disabling billingpart when bl_interface_flag unchecked(when billing not required)%>
			tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Charge.label" bundle="${common_labels}"/></td>";
			tab_data+="<td class='columnHeaderCenter'></td>";
			<%}%>
			rows_ic=parent.parent.parent.ObjectCollect.instrument_rows;
			
  if(rows_ic!=null){
	   for(var mm=0;mm<rows_ic.length;mm++) {
		   if(rows_ic[mm]!=null  && rows_ic[mm].db_mode!='D'){
				args4=mm;
				code_ic+= rows_ic[mm].oper_code+rows_ic[mm].instr_code+",";
			    if(mm%2==0)
			     qryVal="gridData";
			   else
				 qryVal="gridData";

			   var remarks=rows_ic[mm].remarks;
			   var instr_code = rows_ic[mm].instr_code; //Added by Muthu for RUT-CRF-0057
					  var frm_pick_list=rows_ic[mm].frm_pick_list;
						if(frm_pick_list =="") frm_pick_list="N";
							  var no_of_units=rows_ic[mm].quantity;
			     <% if( instrument_entry_cmp_yn.equals("Y") ) { %> 
			       tab_data+="<tr>";

//Added by Muthu for RUT-CRF-0057
				tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\" javascript:openDialogWindow_sur_ic_img(instr_image,'"+mm+"','"+rows_ic[mm].instr_code+"');\"><img src='../../eOT/images/nolines_plus.gif'></img></a></td>";
//Added by Muthu for RUT-CRF-0057

				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].oper_desc)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].instr_desc)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].quantity)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].tray_no)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow_inst(remarks_value,'"+mm+"','"+remarks+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>";
				   <%if(("true").equals(bill_flag)){%>
					  
				   var arr = rows_ic[mm].bill_str.split("::");
				    
				    var include_exclude=arr[8];
					var Appr_reqd=arr[5];
					var reason=arr[7];
				   tab_data+="<td  class="+qryVal+"><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.label" bundle="${or_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson' ><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green' ><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font></b><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/>&nbsp;";
					if(arr[6] =="S")
					   {
						      if(include_exclude=="I") {
					    tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
					   }else {
						    tab_data+="<img width=15px  src='../../eCommon/images/disabled.gif'></img>";
					  }
				   
				   tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";

				    if(Appr_reqd=="Y") {
					    tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
					   }else {
						    tab_data+="<img  width=15px src='../../eCommon/images/disabled.gif'></img>";
					}
					}else
					  {
						   if(include_exclude=="I") {
					    tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
					   }else {
						  tab_data+="<img width=15px  src='../../eCommon/images/blank.gif'></img>";
					  }
				   
				   tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";

				    if(Appr_reqd=="Y") {
					    tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
					   }else {
						    tab_data+="<img  width=15px src='../../eCommon/images/blank.gif'></img>";
					}

					  }
				 //  tab_data+="<td nowrap class="+qryVal+"><img src='../../eOT/images/dollar.png'></img></a></td>";
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_inst("+mm+",'"+frm_pick_list+"');\"><img src='../../eOT/images/dollar.png'></img></a></td>";
				   <%}%>
				   tab_data+="</tr>"; 
				   <%} else { %>
				   tab_data+="<tr>";


//Added by Muthu for RUT-CRF-0057
				tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\" javascript:openDialogWindow_sur_ic_img(instr_image,'"+mm+"','"+rows_ic[mm].instr_code+"');\"><img src='../../eOT/images/nolines_plus.gif'></img></a></td>";
//Added by Muthu for RUT-CRF-0057

				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:sendparams_ic("+args4+");\">"+checkEmpty(rows_ic[mm].oper_desc)+"</a></td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].instr_desc)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].quantity)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].tray_no)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow_inst(remarks_value,'"+mm+"','"+remarks+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>";
				   //alert(rows_ic[mm].bill_str);
				  <%if(("true").equals(bill_flag)){%>
				   var arr = rows_ic[mm].bill_str.split("::");
				   var include_exclude=arr[8];
							var Appr_reqd=arr[5];
							var reason=arr[7];
				  //alert(rows_ic[mm].bill_str)
				   tab_data+="<td  class="+qryVal+"><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.label" bundle="${or_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson' ><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green' ><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font></B><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/>&nbsp;";
					if(arr[6] == "S")
					  {
						      if(include_exclude=="I") {
					    tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
					   }else {
						    tab_data+="<img width=15px  src='../../eCommon/images/disabled.gif'></img>";
					  }
				   
				   tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";

				    if(Appr_reqd=="Y") {
					    tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
					   }else {
						    tab_data+="<img  width=15px src='../../eCommon/images/disabled.gif'></img>";
					}						    
					  }else
					  {
						   if(include_exclude=="I") {
					    tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
					   }else {
						  tab_data+="<img width=15px  src='../../eCommon/images/blank.gif'></img>";
					  }
				   
				   tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";

				    if(Appr_reqd=="Y") {
					    tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
					   }else {
						    tab_data+="<img  width=15px src='../../eCommon/images/blank.gif'></img>";
					}

					  }
				  tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_inst("+mm+",'"+frm_pick_list+"');\"><img src='../../eOT/images/dollar.png'></img></a></td>";
				   <%}%>
				   tab_data+="</tr>";
				   <% } %>
			      //alert(tab_data);		
	   }
	 }
  }		
		tab_data+="</table>";
		tab_data+="</div>";
		tab_data+="</tr>";
		 }
		 else{
			 tab_data+="<table border='0' cellpadding=0  cellspacing='0' width='100%' align='center'>";
		 tab_data+="<tr>";
		 tab_data+="<td class='label' width='100%'  id='InstruCSSD'  visibility:visible>";
		
		 if (flag_IC =="Y")
		   {
			    tab_data+="<img name='IC_arrow' src='../../eCommon/images/iGridNextNOR16.gif' style="+style+" onclick=\"javascript:expandselec('InstruCSSD')\"></img>";
		   }else
		   {
			    tab_data+="<img name='IC_arrow' src='../../eCommon/images/tree_handledownmiddle.gif' style="+style+" onclick=\"javascript:expandselec('InstruCSSD')\"></img>";
		   }  
			   
		   tab_data+="<fmt:message key="eOT.InstrumentsCSSDPacks.Label" bundle="${ot_labels}"/>";

	 <%if(!imgUrl.equals("")){ %>
		tab_data+=" <img src="+imgUrl+" width='100%' height='10'/> ";
	<%}%>
		tab_data+="</td></tr></table>";

		  tab_data+="<tr>";
		  tab_data+="<div id='menuExpand4' style='display:none;visibility:VISIBLE;overflow:auto;height:100px;width:100%'>";		
		  tab_data+="<table border='1' cellpadding='3' cellspacing='0' width='100%' align='center'>"
		  tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.operation.label" bundle="${common_labels}"/></td>"
		  tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Instrument.label" bundle="${common_labels}"/></td>"
 		  tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.ActualUnits.Label" bundle="${ot_labels}"/></td>"
          tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.TrayNo.label" bundle="${common_labels}"/></td>"
		  tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>" 
		  <%if(("true").equals(bill_flag)){// added this condition by sathish on 10-01-2009 to disabling billingpart when bl_interface_flag unchecked(when billing not required)%>
			tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Charge.label" bundle="${common_labels}"/></td>";
			tab_data+="<td class='columnHeaderCenter'></td>";
			<%}%>
			rows_ic=parent.parent.parent.ObjectCollect.instrument_rows;
			
  if(rows_ic!=null){
	   for(var mm=0;mm<rows_ic.length;mm++) {
		   if(rows_ic[mm]!=null  && rows_ic[mm].db_mode!='D'){
				args4=mm;
				code_ic+= rows_ic[mm].oper_code+rows_ic[mm].instr_code+",";
//				alert(code_ic);
			    if(mm%2==0)
			     qryVal="gridData";
			   else
				 qryVal="gridData";

			   var remarks=rows_ic[mm].remarks;
					  var frm_pick_list=rows_ic[mm].frm_pick_list;
						if(frm_pick_list =="") frm_pick_list="N";
							  var no_of_units=rows_ic[mm].quantity;
			     <% if( instrument_entry_cmp_yn.equals("Y") ) { %> 
			       tab_data+="<tr>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].oper_desc)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].instr_desc)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].quantity)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].tray_no)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow_inst(remarks_value,'"+mm+"','"+remarks+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>";
				   <%if(("true").equals(bill_flag)){%>
					  
				   var arr = rows_ic[mm].bill_str.split("::");
				    
				    var include_exclude=arr[8];
					var Appr_reqd=arr[5];
					var reason=arr[7];
				   tab_data+="<td  class="+qryVal+"><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.label" bundle="${or_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson' ><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green' ><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font></b><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/>&nbsp;";
					if(arr[6] =="S")
					   {
						      if(include_exclude=="I") {
					    tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
					   }else {
						    tab_data+="<img width=15px  src='../../eCommon/images/disabled.gif'></img>";
					  }
				   
				   tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";

				    if(Appr_reqd=="Y") {
					    tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
					   }else {
						    tab_data+="<img  width=15px src='../../eCommon/images/disabled.gif'></img>";
					}
					}else
					  {
						   if(include_exclude=="I") {
					    tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
					   }else {
						  tab_data+="<img width=15px  src='../../eCommon/images/blank.gif'></img>";
					  }
				   
				   tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";

				    if(Appr_reqd=="Y") {
					    tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
					   }else {
						    tab_data+="<img  width=15px src='../../eCommon/images/blank.gif'></img>";
					}

					  }
				 //  tab_data+="<td nowrap class="+qryVal+"><img src='../../eOT/images/dollar.png'></img></a></td>";
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_inst("+mm+",'"+frm_pick_list+"');\"><img src='../../eOT/images/dollar.png'></img></a></td>";
				   <%}%>
				   tab_data+="</tr>"; 
				   <%} else { %>
				   tab_data+="<tr>";
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:sendparams_ic("+args4+");\">"+checkEmpty(rows_ic[mm].oper_desc)+"</a></td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].instr_desc)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].quantity)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].tray_no)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow_inst(remarks_value,'"+mm+"','"+remarks+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>";
				   //alert(rows_ic[mm].bill_str);
				  <%if(("true").equals(bill_flag)){%>
				   var arr = rows_ic[mm].bill_str.split("::");
				   var include_exclude=arr[8];
							var Appr_reqd=arr[5];
							var reason=arr[7];
				  //alert(rows_ic[mm].bill_str)
				   tab_data+="<td  class="+qryVal+"><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.label" bundle="${or_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson' ><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green' ><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font></B><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/>&nbsp;";
					if(arr[6] == "S")
					  {
						      if(include_exclude=="I") {
					    tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
					   }else {
						    tab_data+="<img width=15px  src='../../eCommon/images/disabled.gif'></img>";
					  }
				   
				   tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";

				    if(Appr_reqd=="Y") {
					    tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
					   }else {
						    tab_data+="<img  width=15px src='../../eCommon/images/disabled.gif'></img>";
					}						    
					  }else
					  {
						   if(include_exclude=="I") {
					    tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
					   }else {
						  tab_data+="<img width=15px  src='../../eCommon/images/blank.gif'></img>";
					  }
				   
				   tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";

				    if(Appr_reqd=="Y") {
					    tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
					   }else {
						    tab_data+="<img  width=15px src='../../eCommon/images/blank.gif'></img>";
					}

					  }
				  tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_inst("+mm+",'"+frm_pick_list+"');\"><img src='../../eOT/images/dollar.png'></img></a></td>";
				   <%}%>
				   tab_data+="</tr>";
				   <% } %>
			      //alert(tab_data);		
	   }
	 }
  }		
		tab_data+="</table>";
		tab_data+="</div>";
		tab_data+="</tr>";
		 }
			 }
	 }
 
  document.getElementById("test").innerHTML = tab_data;
  document.getElementById("test").style.visibility='visible';
}
      /* @@@@@@@@@@@@@@@@@@@@@@@@@@@ Instrumnets/CSSD Code Ends Here @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

// Added checkEmpty function on 9/28/2010 for 23976 by AnithaJ 

function checkEmpty(obj){
	if((obj == null) || (obj == ''))
		obj='&nbsp;';

	return obj;
}

</script>
</head>

<body onload='createTable()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<form name = 'Resultform'>

<%
	//String facility_id = checkForNull(request.getParameter("facility_id"));
	String facility_id =  (String)temp.get("facility_id");



	String flag_PI = checkForNull(request.getParameter("flag_PI"))==""?"Y":request.getParameter("flag_PI");
	String flag_CO = checkForNull(request.getParameter("flag_CO"))==""?"Y":request.getParameter("flag_CO");
	String flag_EQ = checkForNull(request.getParameter("flag_EQ"))==""?"Y":request.getParameter("flag_EQ");
	String flag_IC = checkForNull(request.getParameter("flag_IC"))==""?"Y":request.getParameter("flag_IC");

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	ResultSet rset_doc_type = null;
	String rec_implants_in_nurs_notes_yn="";
	String rec_equp_in_nurs_notes_yn="";
	String rec_instr_in_nurs_notes_yn="";
	String rec_packs_in_nurs_notes_yn="";
	PreparedStatement pstmt_sm_report_display = null;
	ResultSet rst_sm_report_display=null;
	PreparedStatement pstmt_cp = null;//RUT-CRF-0091
	ResultSet rst_cp=null;//RUT-CRF-0091
	String customer_id ="";//RUT-CRF-0091
try{

		con = ConnectionManager.getConnection(request);
	    //Added by lakshmi against CRF-0058 starts here	
		String Ot_param="";	
	    //Modified by Rajesh
	    String sql_sm_report="select NVL(INSTRUMENT_CSSD_IMAGE,'N') PICKLIST from OT_PARAM where rownum = 1";
		//String sql_sm_report="select NVL(PICKLIST_BY_WARD,'N') PICKLIST from OT_PARAM where rownum = 1";
		//Modified by Rajesh
		pstmt_sm_report_display=con.prepareStatement(sql_sm_report);
		rst_sm_report_display=pstmt_sm_report_display.executeQuery();
		if(rst_sm_report_display !=null && rst_sm_report_display.next())
	   {
		Ot_param=checkForNull(rst_sm_report_display.getString("PICKLIST"));		
	   }
	   if(rst_sm_report_display!=null)rst_sm_report_display.close();
	   if(pstmt_sm_report_display!=null)pstmt_sm_report_display.close();
	   //Added by lakshmi against CRF-0058 ends here
	 //Added by MuthuN against RUT-CRF-0091 on 13-May-2013 starts here
			pstmt_cp = con.prepareStatement("select CUSTOMER_ID from sm_site_param");				
			rst_cp = pstmt_cp.executeQuery();	
			if ( rst_cp.next() && rst_cp != null )
			{
				customer_id  =  rst_cp.getString(1);
				System.err.println(" customer_id in Result.jsp ==> "+customer_id);
			}
		//Added by MuthuN against RUT-CRF-0091 on 13-May-2013 Ends here
			
	 String SQL_ACC_REQYN="SELECT NVL(REC_IMPLANTS_IN_SURG_NOTES_YN,'N'),NVL(REC_IMPLANTS_IN_NURS_NOTES_YN,'N'), NVL(REC_EQUP_IN_NURS_NOTES_YN,'N'), NVL(REC_INSTR_IN_NURS_NOTES_YN,'N'), NVL(REC_PACKS_IN_NURS_NOTES_YN,'N'),NVL(ST_INTERFACE_FLAG,'N') FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID ='"+facility_id+"'";

		pstmt=con.prepareStatement(SQL_ACC_REQYN);
		rset_doc_type = pstmt.executeQuery();

		while(rset_doc_type.next())
		{
			if(tab.equals("record_surgeon"))
			{
			rec_implants_in_nurs_notes_yn=checkForNull(rset_doc_type.getString(1));
			}else
			{
			rec_implants_in_nurs_notes_yn=checkForNull(rset_doc_type.getString(2));
			}
		rec_equp_in_nurs_notes_yn=checkForNull(rset_doc_type.getString(3));
		rec_instr_in_nurs_notes_yn=checkForNull(rset_doc_type.getString(4));
		rec_packs_in_nurs_notes_yn=checkForNull(rset_doc_type.getString(5));
		st_interface_flag=checkForNull(rset_doc_type.getString(6));
		}
	%>


<input type = 'hidden' name= 'flag_PI'      value="<%=flag_PI%>">
<input type = 'hidden' name= 'flag_EQ'      value="<%=flag_EQ%>">
<input type = 'hidden' name= 'flag_IC'      value="<%=flag_IC%>">
<input type = 'hidden' name= 'flag_CO'      value="<%=flag_CO%>">
<input type = 'hidden' name= 'imgUrl'      value="<%=imgUrl%>">
<input type = 'hidden' name= 'style'      value="<%=style%>">
<input type = 'hidden' name= 'tab'      value="<%=tab%>">
<input type='hidden' name='rec_implants_in_nurs_notes_yn' id='rec_implants_in_nurs_notes_yn' value="<%=rec_implants_in_nurs_notes_yn%>">
<input type='hidden' name='rec_instr_in_nurs_notes_yn' id='rec_instr_in_nurs_notes_yn' value="<%=rec_instr_in_nurs_notes_yn%>">
<input type='hidden' name='rec_packs_in_nurs_notes_yn' id='rec_packs_in_nurs_notes_yn' value="<%=rec_packs_in_nurs_notes_yn%>">
<input type='hidden' name='rec_equp_in_nurs_notes_yn' id='rec_equp_in_nurs_notes_yn' value="<%=rec_equp_in_nurs_notes_yn%>">
<input type='hidden' name='st_interface_flag' id='st_interface_flag' value="<%=st_interface_flag%>">
<input type='hidden' name='paramsval' id='paramsval' value='<%=request.getQueryString()%>' >
<input type='hidden' name='Ot_param' id='Ot_param' value="<%=Ot_param%>"><!--Added by lakshmi against CRF-0058-->
<input type='hidden' name='customer_id' id='customer_id' value="<%=customer_id%>"><!--Added by lakshmi against CRF-0058-->



	<%
		}catch(Exception e){
		 System.err.println("Err Msg in InstrumentRecord"+e.getMessage());
		 e.printStackTrace();
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
  %>
</form>
<script>
	enableSelectButton();	
</script>
<div id='test'></div>

</BODY>
</HTML>

