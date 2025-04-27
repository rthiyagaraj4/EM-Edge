<!DOCTYPE html>
<%@ page contentType=" text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<html>
<head>
<% 
	request.setCharacterEncoding("UTF-8");
	String tab = checkForNull(request.getParameter("tab"));
	 String surgeon_doc_comp_yn = checkForNull(request.getParameter("surgeon_doc_comp_yn")); 
	 String nursing_doc_comp_yn = checkForNull(request.getParameter("nursing_doc_comp_yn")); 
	 String bill_flag = request.getParameter("bill_flag");
	 //
	/*if(tab.equals("record_surgeon")){
		 surgeon_doc_comp_yn = checkForNull(request.getParameter("surgeon_doc_comp_yn")); 
	}else if(tab.equals("record_nursing")){
		 nursing_doc_comp_yn = checkForNull(request.getParameter("nursing_doc_comp_yn")); 
	}*/
%>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script type='text/javascript' src='../../eOT/js/RecordSurgeon.js'></script>

<script language="javascript">
var code = new String();
var remarks_value=getLabel("Common.remarks.label","common");
function sendparams(index){
	var rows = parent.parent.parent.ObjectCollect.implants_rows[index];
	var oper_code=rows.oper_code;
	var oper_desc=rows.oper_code+"##"+rows.oper_line_no;
	var line_no = rows.oper_line_no;
	var implant_code= rows.implant_code;
	var implant_desc = rows.implant_desc;
    var quantity=rows.quantity;
	var mfr = rows.manufacturer;
	var batch = rows.batch;
	var remarks=rows.remarks;
	var recId = rows.recId;
	var mode = "U";
	var order = rows.order;
	var str = oper_code+'::'+oper_desc+'::'+line_no+'::'+implant_code+'::'+implant_desc+'::'+quantity+'::'+mfr+'::'+batch+'::'+remarks+'::'+recId+'::'+mode+"::"+order;
	//alert(str);
	var frmObj = parent.RecordFrame;
	frmObj.splitString(str);
}

async function openDialogWindow(strVal,index){
  var rows = parent.parent.parent.ObjectCollect.implants_rows[index];
  var remarks=encodeURIComponent(rows.remarks); 
 // var remarks=rows.remarks; 
 await window.showModalDialog('../../eOT/jsp/TextArea.jsp?heading='+encodeURIComponent(strVal)+'&remarks='+remarks,window,"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;");
}

async function callBillingWindow(index){
	//alert(index);
	var rows = parent.parent.parent.ObjectCollect.implants_rows[index];
	var key = rows.key;
	var key_line = rows.key_line;
	var oper_code = rows.oper_code;
	var param = "order_id="+key+"&order_line_num="+key_line+"&called_from=SURG_ACC";
	//alert(param);
	var xmlStr ="<root></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	//alert(responseText);
	await showBillingWindow(responseText,index);
}

async function showBillingWindow(str,index){
	    var rows =parent.parent.parent.ObjectCollect.implants_rows[index];
		var module_id = (rows.order==1)?"OT":"OR"
		var arr = str.split("::");
		var order_id="";
	    var order_line_no="";
		var key=arr[0]; 
		var key_line_no=arr[1];
		var order_catalog_code=arr[2]; 
		var patient_id = arr[3];          
        var episode_type = arr[4];
		var episode_id=arr[5];         
        var visit_id=arr[6];
        var encounter_id=arr[7]; 
		var service_date=arr[8];  
		var pract_staff_ind=arr[9];          
        var pract_staff_id=arr[10];
        var service_panel_ind=arr[11]; 
        var service_panel_code=arr[12];     
		var original_qty = arr[19];
		var revised_qty = rows.quantity;
		var total_qty = rows.quantity;
		var bl_panel_str = rows.panel_str;
        var bean_id=""; 
        var dialogTop = "100";
        var dialogHeight = "30" ;
        var dialogWidth = "70" ;
        var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
        var title=encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"));
		 var arguments = "" ;
        var column_sizes = "";
            var column_descriptions ="";       
            var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"episode_type="+episode_type+"&"+"patient_id="+patient_id+"&"+"visit_id="+visit_id+"&"+"episode_id="+episode_id+"&"+"service_panel_code="+service_panel_code+"&"+"service_panel_ind="+service_panel_ind+"&"+"service_date="+service_date+"&"+"order_catalog_code="+order_catalog_code+"&"+"module_id="+module_id+"&encounter_id="+encounter_id+"&key="+key+"&key_line_no="+key_line_no+"&order_id="+order_id+"&order_line_no="+order_line_no+"&bean_id="+bean_id+"&total_qty="+total_qty+"&revise_qty="+revised_qty+"&original_qty="+original_qty+"&quantity="+revised_qty+"&qty="+revised_qty+"&p_serv_qty="+revised_qty+"&revised_qty="+revised_qty+"&serv_panel_qty="+revised_qty+"&modify_qty_yn=Y&p_str="+bl_panel_str; 
			//alert(param);
			var retVal = await window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?"+param,arguments,features);
			if(retVal!=null){
				var retArray  = retVal;
				//total_payable::patient_payable::patient_paid
				var arr = rows.bill_str.split("::");
				rows.bill_str = retArray[1]+"::"+retArray[2]+"::"+retArray[3]+"::"+arr[3];
				rows.rate = retArray[5];
				//alert("rows.rate---->"+rows.rate)
				//rows.db_mode = (rows.order==1)?"U":"I";
				if(rows.db_mode!="I"){
					rows.db_mode = (rows.order==1 || rows.order==null || rows.order=="")?"U":"I";
				}
				if(service_panel_ind=="L"){
					var pnl_str =  getPanelStr(patient_id,index);
					rows.panel_str =pnl_str.split("::")[13];
				}
				createTable();
			}
}
function getPanelStr(patient_id,index){
	    var rows =parent.parent.parent.ObjectCollect.implants_rows[index];
	var order_id = rows.order_id;
	var order_line_num = rows.order_line_no;
	var oper_code = rows.oper_code;
	var key = rows.key;
	var key_line = rows.key_line;
	//alert(oper_num);
	//alert(patient_id);
	//var patient_id = "CS00000040";
	//alert(order_id+"--"+order_line_num+"--"+oper_code);
	var param = "key="+key+"&key_line="+key_line+"&order_id="+order_id+"&order_line_num="+order_line_num+"&oper_code="+oper_code+"&patient_id="+patient_id+"&called_from=SURG_ACC_EDIT";
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	//alert(temp_jsp);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	//alert(responseText);
	return responseText;
	//alert(responseText);
	//showBillingWindow(responseText,index);
}
function createTable(){   
  var rows=parent.parent.parent.ObjectCollect.implants_rows;
  var tab_data="";
  tab_data="<table border='1' cellpadding='3' cellspacing='0' width='100%' align='center'>"
  tab_data+="<th class='columnHeaderCenter'><fmt:message key="Common.operation.label" bundle="${common_labels}"/></th>"
  tab_data+="<th class='columnHeaderCenter'><fmt:message key="Common.Implant.label" bundle="${common_labels}"/></th>"
 tab_data+="<th class='columnHeaderCenter'><fmt:message key="Common.Units.label" bundle="${common_labels}"/></th>"
  tab_data+="<th class='columnHeaderCenter'><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/></th>"
  tab_data+="<th class='columnHeaderCenter'><fmt:message key="Common.Batch.label" bundle="${common_labels}"/></th>"
  tab_data+="<th class='columnHeaderCenter'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>" 
  <%if(("true").equals(bill_flag)){%>
  tab_data+="<th class='columnHeaderCenter'><fmt:message key="Common.Charge.label" bundle="${common_labels}"/></th>";
  tab_data+="<th class='columnHeaderCenter'></th>";
  <%}%>
  var args='';
  if(rows!=null){
	   for(var jj=0;jj<rows.length;jj++) {
		   if(rows[jj]!=null  && rows[jj].db_mode!='D'){
				args=jj;
				code+= rows[jj].oper_code+rows[jj].implant_code+",";
			    if(jj%2==0)
			     qryVal="gridData";
			   else
				 qryVal="gridData";
		 <% if (surgeon_doc_comp_yn.equals("Y") ||  nursing_doc_comp_yn.equals("Y") || tab.equals("record_surgeon")){ %>  
			       tab_data+="<tr>";
				   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].oper_desc+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].implant_desc+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].quantity+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].manufacturer+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].batch+"</td>";
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow(remarks_value,'"+jj+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>";
				   <% if(("true").equals(bill_flag)){%>
				   var arr = rows[jj].bill_str.split("::");
				   tab_data+="<td nowrap class="+qryVal+"><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson' ><fmt:message key="eOT.Payable.label" bundle="${or_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green' ><fmt:message key="Common.Paid.label" bundle="${common_labels}"/>:"+arr[2]+"</font></B>";
				   tab_data+="<td nowrap class="+qryVal+"><img src='../../eOT/images/dollar.png'></img></a></td>";
				   <%}%>
				   tab_data+="</tr>"; 
				<%} else {%>
				   tab_data+="<tr>";
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:sendparams("+args+");\">"+rows[jj].oper_desc+"</a></td>";
				   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].implant_desc+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].quantity+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].manufacturer+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].batch+"</td>";
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow(remarks_value,'"+jj+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>";
				   <%if(("true").equals(bill_flag)){%>
				   var arr = rows[jj].bill_str.split("::");
				   tab_data+="<td nowrap class="+qryVal+"><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson' ><fmt:message key="eOT.Payable.label" bundle="${or_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green' ><fmt:message key="Common.Paid.label" bundle="${common_labels}"/>:"+arr[2]+"</font></B>";
				  tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' class='gridLink' href=\"javascript:callBillingWindow("+jj+");\"><img src='../../eOT/images/dollar.png'></img></a></td>";
                  <%}%>
				   tab_data+="</tr>";
     			<% } %>
			      //alert(tab_data);		
	   }
	 }
  }
  document.getElementById("test").innerHTML = tab_data;
  document.getElementById("test").style.visibility='visible';
}


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad='createTable();' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='InstrumentDtlsForm' id='InstrumentDtlsForm' >
</form>
<div id='test'></div>
</body>
</html>

