<!DOCTYPE html>
   <%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager,webbeans.eCommon.ConnectionManager,eCommon.Common.*,eOT.*,eOR.OrderEntryBillingQueryBean,eST.OTTransactionBean,eST.*,java.sql.*,java.sql.ResultSet,java.util.HashMap,eOR.OrderEntryBillingQueryBean,eCommon.XSSRequestWrapper,eCommon.Common.*" contentType=" text/html;charset=UTF-8" %> 
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
    <%@include file="../../eCommon/jsp/Common.jsp" %>
	<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
	<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<% 
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE"); 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

	String or_bean_id 				    = "Or_billingQueryBean";
	String or_bean_name 			    = "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean	= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;

	String bean_id 				= "OTBillingBean";
	String bean_name 			= "eOT.OTBillingBean";
	OTBillingBean billing_bean	= (OTBillingBean)getBeanObject( bean_id, bean_name, request ) ;

	String st_bean_id 				    = "ottransactionbean";
	String st_bean_name 			    = "eST.OTTransactionBean";
	OTTransactionBean st_bean	= (OTTransactionBean)getBeanObject(st_bean_id, st_bean_name, request ) ;
	
	//Added Against ML-MMOH-CRF-1939-US4...starts
	String facility_id     = (String)session.getValue("facility_id");
	String tab_name     = checkForNull((String)request.getParameter("tab_name"));//Added Against ML-MMOH-SCF-2510
	Connection con=null;
	String fpp_category="";
	String Include_Fpp_yn = "";
	boolean isIncludeFpp = false;
	ArrayList Fpplist = new ArrayList();
    String fpp_order_yn = "N";
	String fpp_def_category = "";
	Integer count =0;
	String ot_bean_id = "OTCommonBean";
	String ot_bean_name = "eOT.OTCommonBean";
	OTCommonBean bean = (OTCommonBean)mh.getBeanObject( ot_bean_id, request, ot_bean_name );
	try{	
			con = ConnectionManager.getConnection(request);
			Include_Fpp_yn = bean.getIncludeFpp(facility_id);
			isIncludeFpp = CommonBean.isSiteSpecific(con,"OT","OT_FPP");
			count = bean.getFppIcon();
		}catch(Exception e)
		{
			e.printStackTrace();
			//out.println("Error="+e);
		}
	//Added Against ML-MMS-QH-CRF-1939-US4...ends
 %>
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
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js" ></script>
		<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
		<script Language="javascript" src="../../eOT/js/AdministrativeFunctionforAllCharges.js"></script>
		<script language="JavaScript" src="../../eST/js/Sales.js"></script> 
		<script language="Javascript" src="../../framework/js/PopupWindow.js"></script>
		<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script><!--MMS-QH-CRF-0199 -->
		<% String bill_flag = checkForNull(request.getParameter("bill_flag")); %>
<!--MMS-QH-CRF-0199-->
<style type="text/css">		
	.my_dropdown {		    
	    width: 180px ; min-width: 100px; max-width: 200px;		    
	}
	select:focus{width:200px !important;}	
	</style>
	<!--MMS-QH-CRF-0199-->
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
<!--MMS-QH-CRF-0199 -->
		<script language="javascript">
		var rightSide_title=getLabel("eOT.RightSide.Label","ot");
		var leftSide_title=getLabel("eOT.LeftSide.Label","ot");
		var notApplicable_title=getLabel("Common.notapplicable.label","common");
		var bilateral_title=getLabel("eOT.Bilateral.Label","ot");
		var operation_title=getLabel("Common.operation.label","common");
		var sideApplicable_title=getLabel("eOT.SideApplicable.Label","ot");
	    var code_pi = new String();
	    var code_cons = new String();
	    var code_eq = new String();
	    var code_ic = new String();
		var remarks_value=getLabel("Common.remarks.label","common");
		//Added by muthu on 6-1-2012
		var equip_image=getLabel("Common.equipment.label","common");
		var instr_image=getLabel("Common.Instrument.label","common");

		function checkEmpty(obj){
			if((obj == null) || (obj == ''))
				obj='&nbsp;';
			return obj;
		}

		//Added by Muthu for RUT-CRF-0057
function openDialogWindow_eq_img(strVal,index,equip_code){
  var rows = parent.parent.parent.AdminObjectCollect.equipment_rows[index];
  var equip_code=encodeURIComponent(rows.equip_code);
 var title=encodeURIComponent(getLabel("Common.equipment.label","Common"));
	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var params = equip_code;
	var xmlStr ="<root><SEARCH ";
	xmlStr +="/></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");	
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=check_Image_flag&equipment_code="+equip_code,false);
	xmlHttp.send(xmlDoc);	
	var sql_image_flag = trimString(xmlHttp.responseText);	
//Newly Added on 12-1-2012
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
		retVal=window.showModalDialog("../../eOT/jsp/AdminEquipmentFrame.jsp?"+param,arguments,features);}
	else
	{
		alert(getMessage("NO_RECORD_FOUND","Common"));
		//Modified by rajesh for CRF-0057 26-9-12
	}	
}

function openDialogWindow_ic_img(strVal,index,instr_code){
  var rows = parent.parent.parent.AdminObjectCollect.instrument_rows[index];
  var instr_code=encodeURIComponent(rows.instr_code);
  var instr_desc=encodeURIComponent(rows.instr_desc);

	var title=encodeURIComponent(getLabel("Common.equipment.label","Common"));
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
	loc_ic=encodeURIComponent(ins_location_array[0]);
	image_ic=ins_location_array[1];
	//RUT-CRF-0091 by MuthuN Ends Here
	//Modified by Rajesh for CRF-0057 for opening image always
	var dialogHeight 		= "0";
		var dialogWidth  		= "40";
		var dialogTop   		= "200";
		var dialogLeft   		= "100";
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "";
		
		var	param="instr_code="+instr_code+"&instr_desc="+instr_desc; 
		param=param+"&image="+image_ic;
		param=param+"&location="+loc_ic;
		retVal=window.showModalDialog("../../eOT/jsp/AdminInstrumentFrame.jsp?"+param,arguments,features);
	//Modified by Rajesh for CRF-0057 for opening image always
}	//Added by Muthu for RUT-CRF-0057
	
		function createTable_pi()
		{   
		var rows=parent.parent.parent.AdminObjectCollect.implants_rows;
		var st_interface_flag=document.forms[0].st_interface_flag.value;
		var implant_entry_cmp_yn=localTrimString(document.forms[0].implant_entry_cmp_yn.value);
		var tab_data="";
		tab_data="<table border='0' cellpadding='0' cellspacing='0' width='100%'>"
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.operation.label" bundle="${common_labels}"/></td>"
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Implant.label" bundle="${common_labels}"/></td>"
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.ActualUnits.Label" bundle="${ot_labels}"/></td>"
		if(st_interface_flag=='Y')
	    {
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.ReservedPicklistUnits.Label" bundle="${ot_labels}"/></td>"
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.RequestedPicklistUnits.Label" bundle="${ot_labels}"/></td>"
		}
		if(st_interface_flag=="N")
		{
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/></td>"
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Batch.label" bundle="${common_labels}"/></td>"
		}
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>";
		if(st_interface_flag=='Y')
	    {
        tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.ConsumptionStore.Label" bundle="${ot_labels}"/></td>" 
		}
       
	    <% if(("true").equals(bill_flag)){%>
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Charge.label" bundle="${common_labels}"/></td>"
		tab_data+="<td class='columnHeaderCenter'></td>"
		<%}%>
		var args='';
        if(rows!=null){
	      for(var jj=0;jj<rows.length;jj++) {
		     if(rows[jj]!=null && rows[jj].db_mode!='D'){
				args=jj;
				code_pi+= rows[jj].oper_code+rows[jj].implant_code+",";
			    if(jj%2==0)
			     qryVal="gridData";
			   else
				 qryVal="gridData";

			     if(implant_entry_cmp_yn=="Y"){  
			       tab_data+="<tr>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].oper_desc)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].implant_desc)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].quantity)+"</td>";
				    if(st_interface_flag=='Y')
	               {
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].reserved_qty)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].requested_qty)+"</td>";
				   }
				   if(st_interface_flag=="N")
		           {
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].manufacturer)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].batch)+"</td>";
				   }
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow_pi(remarks_value,'"+jj+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a><input type='hidden' name='Stockavail' id='Stockavail' value='"+rows[jj].Stockavail+"'></a></td>";
				   if(st_interface_flag=="Y")
				   {
				    tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].Store_desc)+"</td>";
				   }
				    <% if(("true").equals(bill_flag)){%>
				   var arr = rows[jj].bill_str.split("::");
                    var inclexcl="";
				   var approvalreqd="";
				   if(arr[6]=='S'){
				   if(arr[8]=="E" ||arr[8]=='' ||arr[8]=='null') inclexcl="<img src='../../eCommon/images/disabled.gif'  width='15px' align='texttop' ></img>";
				   if(arr[8]=="I") inclexcl="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
				   if(arr[5]=="Y") approvalreqd="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
				   if(arr[5]=="N") approvalreqd="<img src='../../eCommon/images/disabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
				   }else{
					   inclexcl="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
					   approvalreqd="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
				   }
				   
				  if(arr !="")
				{
					  tab_data+="<td  class=gridData><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson'>&nbsp;<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green'><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font></B><br><fmt:message key="Common.Included.label" bundle="${common_labels}"/>?"+inclexcl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?"+approvalreqd+"";
				}else
				  {
				  tab_data+="<td  class=gridData><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;0.0</font>&nbsp;&nbsp;<font color='crimson'>&nbsp;<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;0.0</font>&nbsp;&nbsp;<font color='green'><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;0.0</font></B><br><fmt:message key="Common.Included.label" bundle="${common_labels}"/>?"+inclexcl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?"+approvalreqd+"";
				  }
				   if(st_interface_flag=="N"){
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_pi("+jj+");\"><img src='../../eOT/images/dollar.png'></img></a></td>";
				   }else{
					   var Appr_reqd=arr[5];
					   var include_exclude=arr[8];
					   arr[0]=trimString(arr[0]);
					   tab_data+="<td nowrap class="+qryVal+"><img src='../../eOT/images/dollar.png'></img></a></td>";
				  }
				   <%}%>
				  tab_data+="</tr>"; 
				}else
				   {
				   tab_data+="<tr>";
				   
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:sendparams_pi("+args+");\">"+checkEmpty(rows[jj].oper_desc)+"</a></td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].implant_desc)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].quantity)+"</td>";
				   if(st_interface_flag=='Y')
	               {
					   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].reserved_qty)+"</td>";
					   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].requested_qty)+"</td>";
				   }
				   if(st_interface_flag=="N")
		           {
					   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].manufacturer)+"</td>";
					   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].batch)+"</td>";
				   }
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow_pi(remarks_value,'"+jj+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a><input type='hidden' name='Stockavail' id='Stockavail' value='"+rows[jj].Stockavail+"'></a></td>";
				   if(st_interface_flag=="Y")
				   {
					   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows[jj].Store_desc)+"</td>";
				   }
			 <% if(("true").equals(bill_flag)){%>
				   var arr = rows[jj].bill_str.split("::");
					
				   if(arr[6]=='S'){
				   if(arr[8]=="E" ||arr[8]=='' ||arr[8]=='null') inclexcl="<img src='../../eCommon/images/disabled.gif'  width='15px' align='texttop' ></img>";
				   if(arr[8]=="I") inclexcl="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
				   if(arr[5]=="Y") approvalreqd="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
				   if(arr[5]=="N") approvalreqd="<img src='../../eCommon/images/disabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
				   }else{
					   inclexcl="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
					   approvalreqd="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
				   }
				  if(arr !="")
				  {
				  tab_data+="<td  class=gridData><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson'>&nbsp;<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green'><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font></B><br><fmt:message key="Common.Included.label" bundle="${common_labels}"/>?"+inclexcl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?"+approvalreqd+"";
				  }
				  else{
				  tab_data+="<td  class=gridData><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;0.0</font>&nbsp;&nbsp;<font color='crimson'>&nbsp;<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;0.0</font>&nbsp;&nbsp;<font color='green'><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;0.0</font></B><br><fmt:message key="Common.Included.label" bundle="${common_labels}"/>?"+inclexcl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?"+approvalreqd+"";
				  }
				  if(st_interface_flag=="N"){
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_pi("+jj+");\"><img src='../../eOT/images/dollar.png'></img></a></td>";

				  }else{
					   var Appr_reqd=arr[5];
					   var include_exclude=arr[8];
					   arr[0]=trimString(arr[0])

					   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_st('"+jj+"','"+Appr_reqd+"','"+include_exclude+"','"+arr[0]+"','"+arr[1]+"',"+arr[2]+",'"+arr[7]+"','"+rows[jj].req_store_code+"','"+rows[jj].quantity+"','"+rows[jj].implant_code+"','"+rows[jj].sale_document_no+"',  '"+rows[jj].sale_document_type+"','"+arr[9]+"');\"><img src='../../eOT/images/dollar.png'></img></a></td>";
				  }
				   <%}%>
				   tab_data+="</tr>"; 
					}
		     }
	        }
	      }
		 document.getElementById("menuExpand4").innerHTML = tab_data;
		}
		function createTable_cons(){   				
			var rows=parent.parent.parent.AdminObjectCollect.packs_rows;
			var consumable_entry_cmp_yn=localTrimString(document.forms[0].consumable_entry_cmp_yn.value);
			var tab_data="";
			tab_data="<table border='1' cellpadding=0 cellspacing='0' width='100%' align='center'>"
			tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.operation.label" bundle="${common_labels}"/></td>"
			tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Package.label" bundle="${common_labels}"/></td>"
			tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.ActualUnits.Label" bundle="${ot_labels}"/></td>"
			tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>"
			<%if(("true").equals(bill_flag)){%>
			tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Charge.label" bundle="${common_labels}"/></td>";
			tab_data+="<td class='columnHeaderCenter'></td>";
			<%}%>
			var args='';
			if(rows!=null){
			   for(var jj=0;jj<rows.length;jj++) {
				   if(rows[jj]!=null  && rows[jj].db_mode!='D'){
						args=jj;
						code_cons+= rows[jj].oper_code+rows[jj].package_code+",";
						if(jj%2==0)
						 qryVal="gridData";
					   else
						 qryVal="gridData";
						 if( consumable_entry_cmp_yn=="Y") { 
						   tab_data+="<tr>";
						   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].oper_desc+"</td>";
						   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].package_desc+"</td>";
						   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].quantity+"</td>";
						   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow_cons(remarks_value,'"+jj+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>";
						   <%if(("true").equals(bill_flag)){%>
						   var arr = rows[jj].bill_str.split("::");
							var inclexcl="";
							var approvalreqd="";
							if(arr[6]=='S')
							{
							if(arr[8]=="E" ||arr[8]=='' ||arr[8]=='null') inclexcl="<img src='../../eCommon/images/disabled.gif'  width='15px' align='texttop' ></img>";
							if(arr[8]=="I") inclexcl="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
							if(arr[5]=="Y") approvalreqd="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
							if(arr[5]=="N") approvalreqd="<img src='../../eCommon/images/disabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
							}else{
							inclexcl="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
							approvalreqd="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
							}
						  tab_data+="<td  class=gridData><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson'>&nbsp;<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green'><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font></B><br><fmt:message key="Common.Included.label" bundle="${common_labels}"/>?"+inclexcl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?"+approvalreqd+"";
						  tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_cons("+jj+");\"><img src='../../eOT/images/dollar.png'></img></a></td>";
						   <%}%>
						  tab_data+="</tr>"; 
						 } else {
						   tab_data+="<tr>";
						   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:sendparams_cons("+args+");\">"+rows[jj].oper_desc+"</a></td>";
						   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].package_desc+"</td>";
						   tab_data+="<td nowrap class="+qryVal+">"+rows[jj].quantity+"</td>";
						   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow_cons(remarks_value,'"+jj+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>";
						   <%if(("true").equals(bill_flag)){%>
						   var arr = rows[jj].bill_str.split("::");
							var inclexcl="";
							var approvalreqd="";
							if(arr[6]=='S')
							{
							if(arr[8]=="E" ||arr[8]=='' ||arr[8]=='null') inclexcl="<img src='../../eCommon/images/disabled.gif'  width='15px' align='texttop' ></img>";
							if(arr[8]=="I") inclexcl="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
							if(arr[5]=="Y") approvalreqd="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
							if(arr[5]=="N") approvalreqd="<img src='../../eCommon/images/disabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
							}else{
							inclexcl="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
							approvalreqd="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
							}
						    tab_data+="<td  class=gridData><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson'>&nbsp;<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green'><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font></B><br><fmt:message key="Common.Included.label" bundle="${common_labels}"/>?"+inclexcl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?"+approvalreqd+"";
						  tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_cons("+jj+");\"><img src='../../eOT/images/dollar.png'></img></a></td>";
						  <%}%>
						   tab_data+="</tr>";
						 }
			   }
			 }
			}
			document.getElementById("menuExpand5").innerHTML = tab_data;
		}
		
		function createTable_eq1()
		{
		  var equipment_entry_cmp_yn=localTrimString(document.forms[0].equipment_entry_cmp_yn.value);
		  var customer_id = document.forms[0].customer_id1.value;
		  var tab_data="";
          
		  tab_data+="<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center'>";
			//Added by Muthu for RUT-CRF-0057
		  tab_data+="<td class='columnHeaderCenter'></td>"
			//Added by Muthu for RUT-CRF-0057
		  tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.operation.label" bundle="${common_labels}"/></td>"
		  tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Package.label" bundle="${common_labels}"/></td>";
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.DateTime.label" bundle="${ot_labels}"/></td>";<!-- 047546 -->
		  tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.ActualUnits.Label" bundle="${ot_labels}"/></td>";
		//Added by MuthuN against RUT-CRF-0091 on 10-05-13 starts here
		if(customer_id == "RTN"){
		  tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>"
	}else{
			tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.EquipmentID.Label" bundle="${ot_labels}"/></td>";
	}
	//Added by MuthuN against RUT-CRF-0091 on 10-05-13 ends here
		 tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>"; 
		 <%if(("true").equals(bill_flag)){%>
		  tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Charge.label" bundle="${common_labels}"/></td>";
		  tab_data+="<td class='columnHeaderCenter'></td>";
		  <%}%>
			var  rows_eq=parent.parent.parent.AdminObjectCollect.equipment_rows;
              var args3='';
			  if(rows_eq!=null){
				   for(var kk=0;kk<rows_eq.length;kk++) {
					   if(rows_eq[kk]!=null  && rows_eq[kk].db_mode!='D'){
							args3=kk;
							code_eq+= rows_eq[kk].oper_code+rows_eq[kk].equip_code+",";
							if(kk%2==0)
							 qryVal="gridData";
						   else
							 qryVal="gridData";
							var remarks=rows_eq[kk].remarks_eq;
							 if(equipment_entry_cmp_yn=="Y") { 
								   tab_data+="<tr>";
//Added by Muthu for RUT-CRF-0057
							   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\" javascript:openDialogWindow_eq_img(equip_image,'"+kk+"','"+rows_eq[kk].equip_code+"');\"><img src='../../eOT/images/nolines_plus.gif'></img></a></td>";
//Added by Muthu for RUT-CRF-0057
							   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].oper_desc)+"</td>";
							   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].equip_desc)+"</td>";
							   	tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].desiredDate)+"</td>";
							   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].quantity)+"</td>";
							 if(customer_id == "RTN"){							
								  tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].st_location)+"</td>";
							  }else{tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].equip_code)+"</td>";
							  }
							   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow_eq(remarks_value,'"+kk+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>";
								<%if(("true").equals(bill_flag)){%>
								var arr = rows_eq[kk].bill_str.split("::");
								var inclexcl="";
								var approvalreqd="";
								if(arr[6]=='S')
								{
								if(arr[8]=="E" ||arr[8]=='' ||arr[8]=='null') inclexcl="<img src='../../eCommon/images/disabled.gif'  width='15px' align='texttop' ></img>";
								if(arr[8]=="I") inclexcl="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
								if(arr[5]=="Y") approvalreqd="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
								if(arr[5]=="N") approvalreqd="<img src='../../eCommon/images/disabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
								}else{
								   inclexcl="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
								   approvalreqd="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
								}
							   tab_data+="<td  class=gridData><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson'>&nbsp;<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green'><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font></B><br><fmt:message key="Common.Included.label" bundle="${common_labels}"/>?"+inclexcl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?"+approvalreqd+"";
				              tab_data+="</font></td>";
							  tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_eq("+kk+");\"><img src='../../eOT/images/dollar.png'></img></a></td>";
							   <%}%>
							   tab_data+="</tr>";
							   }else {
							   tab_data+="<tr>";
			
//Added by Muthu for RUT-CRF-0057
							   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\" javascript:openDialogWindow_eq_img(equip_image,'"+kk+"','"+rows_eq[kk].equip_code+"');\"><img src='../../eOT/images/nolines_plus.gif'></img></a></td>";
//Added by Muthu for RUT-CRF-0057

							   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:sendparams_eq("+args3+");\">"+checkEmpty(rows_eq[kk].oper_desc)+"</a></td>";
							   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].equip_desc)+"</td>";
							   	tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].desiredDate)+"</td>";
							   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].quantity)+"</td>";
							    if(customer_id == "RTN"){
								  tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].st_location)+"</td>";
							  }else{
							tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].equip_code)+"</td>";//Added by MuthuN against 39535 on 13/05/2013
							  }
							   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow_eq(remarks_value,'"+kk+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>";
								<%if(("true").equals(bill_flag)){%>
								var arr = rows_eq[kk].bill_str.split("::");
								var inclexcl="";
								var approvalreqd="";
								if(arr[6]=='S')
								{
								if(arr[8]=="E" ||arr[8]=='' ||arr[8]=='null') inclexcl="<img src='../../eCommon/images/disabled.gif'  width='15px' align='texttop' ></img>";
								if(arr[8]=="I") inclexcl="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
								if(arr[5]=="Y") approvalreqd="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
								if(arr[5]=="N") approvalreqd="<img src='../../eCommon/images/disabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
								}else{
								   inclexcl="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
								   approvalreqd="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
								}
							   tab_data+="<td  class=gridData><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson'>&nbsp;<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green'><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font></B><br><fmt:message key="Common.Included.label" bundle="${common_labels}"/>?"+inclexcl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?"+approvalreqd+"";
				               tab_data+="</font></td>";
							  tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_eq("+kk+");\"><img src='../../eOT/images/dollar.png'></img></a></td>";
							   <%}%>
							   tab_data+="</tr>"; 
							   }			 
				    }
				 }
			  }	 
			 tab_data+="</table>";
			 tab_data+="</div>";
			 tab_data+="</tr>";
			 document.getElementById("menuExpand6").innerHTML = tab_data;
		}
function createTable_eq()
{
		  var equipment_entry_cmp_yn=localTrimString(document.forms[0].equipment_entry_cmp_yn.value);
		  var customer_id = document.forms[0].customer_id1.value;
		  var tab_data="";
          
		  tab_data+="<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center'>";
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.operation.label" bundle="${common_labels}"/></td>"
		  tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Package.label" bundle="${common_labels}"/></td>";
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.DateTime.label" bundle="${ot_labels}"/></td>";<!-- 047546 -->
		  tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.ActualUnits.Label" bundle="${ot_labels}"/></td>";
//Added by MuthuN against RUT-CRF-0091 on 10-05-13 starts here
		if(customer_id == "RTN")
		{
		  tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>"
		}
		else
		{
			tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.EquipmentID.Label" bundle="${ot_labels}"/></td>";
	}
//Added by MuthuN against RUT-CRF-0091 on 10-05-13 ends here
		 tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>"; 
		 <%if(("true").equals(bill_flag)){%>
		  tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Charge.label" bundle="${common_labels}"/></td>";
		  tab_data+="<td class='columnHeaderCenter'></td>";
		  <%}%>
		  /* Added Start Against AMRI-CRF-0294 [IN049121(Header) step-1*/ 
		  tab_data+="<td nowrap class='columnHeaderCenter'><fmt:message key="Common.status.label" bundle="${	common_labels}"/></td>"  
		  /* Added End Against AMRI-CRF-0294 [IN049121*/
			var  rows_eq=parent.parent.parent.AdminObjectCollect.equipment_rows;
              		var args3='';
			  if(rows_eq!=null){
				   for(var kk=0;kk<rows_eq.length;kk++) {
					   if(rows_eq[kk]!=null){ //Added Against AMRI-CRF-0294 [IN049121]
							args3=kk;
							code_eq+= rows_eq[kk].oper_code+rows_eq[kk].equip_code+",";
							if(kk%2==0)
							 qryVal="gridData";
						   else
							 qryVal="gridData";

							var remarks=rows_eq[kk].remarks_eq;
							 /*Added Start Against 294-CRF*/	
							var oper_line_status1=rows_eq[kk].oper_line_status; 
							if(oper_line_status1 == null)  oper_line_status1="";
							/*Added End Against 294-CRF*/
							 if(equipment_entry_cmp_yn=="Y") { 
								   tab_data+="<tr>";
							tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].oper_desc)+"</td>";
							   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].equip_desc)+"</td>";
							   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].desiredDate)+"</td>";
							   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].quantity)+"</td>";
							   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].equip_code)+"</td>";
							   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow_eq(remarks_value,'"+kk+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>";
								<%if(("true").equals(bill_flag)){%>
								var arr = rows_eq[kk].bill_str.split("::");
								var inclexcl="";
								var approvalreqd="";
								if(arr[6]=='S')
								{
								if(arr[8]=="E" ||arr[8]=='' ||arr[8]=='null') inclexcl="<img src='../../eCommon/images/disabled.gif'  width='15px' align='texttop' ></img>";
								if(arr[8]=="I") inclexcl="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
								if(arr[5]=="Y") approvalreqd="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
								if(arr[5]=="N") approvalreqd="<img src='../../eCommon/images/disabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
								}else{
								   inclexcl="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
								   approvalreqd="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
								}
							   tab_data+="<td  class=gridData><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson'>&nbsp;<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green'><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font></B><br><fmt:message key="Common.Included.label" bundle="${common_labels}"/>?"+inclexcl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?"+approvalreqd+"";
				              tab_data+="</font></td>";
							  tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_eq("+kk+");\"><img src='../../eOT/images/dollar.png'></img></a></td>";
							   <%}%>
							   // Added Against Start AMRI-CRF-0294 [IN049121] step-3
							 	if(rows_eq[kk].db_mode=='D' || oper_line_status1=='99')
								{
								tab_data+="<td nowrap class="+qryVal+"><img src='../../eCommon/images/RRnwd.gif'></img></td>";
								} 
								// Added Against End AMRI-CRF-0294 [IN049121
							   tab_data+="</tr>";
							   }else {
							   tab_data+="<tr>";
							if(rows_eq[kk].db_mode=="D" || oper_line_status1=='99') 
								{
								tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].oper_desc)+"</td>";
								}
								else{ 	
								tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:sendparams_eq("+args3+");\">"+checkEmpty(rows_eq[kk].oper_desc)+"</a></td>";
								} 
							  tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].equip_desc)+"</td>";
							   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].desiredDate)+"</td>";
							   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].quantity)+"</td>";
							   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_eq[kk].equip_code)+"</td>";
							   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow_eq(remarks_value,'"+kk+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>";
								<%if(("true").equals(bill_flag)){%>
								var arr = rows_eq[kk].bill_str.split("::");
								var inclexcl="";
								var approvalreqd="";
								if(arr[6]=='S')
								{
								if(arr[8]=="E" ||arr[8]=='' ||arr[8]=='null') inclexcl="<img src='../../eCommon/images/disabled.gif'  width='15px' align='texttop' ></img>";
								if(arr[8]=="I") inclexcl="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
								if(arr[5]=="Y") approvalreqd="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
								if(arr[5]=="N") approvalreqd="<img src='../../eCommon/images/disabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
								}else{
								   inclexcl="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
								   approvalreqd="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
								}
							   tab_data+="<td  class=gridData><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson'>&nbsp;<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green'><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font></B><br><fmt:message key="Common.Included.label" bundle="${common_labels}"/>?"+inclexcl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?"+approvalreqd+"";
				               tab_data+="</font></td>";
							  tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_eq("+kk+");\"><img src='../../eOT/images/dollar.png'></img></a></td>";
							   <%}%>
							   // Added Against Start AMRI-CRF-0294 [IN049121] step-3
							  	 if(rows_eq[kk].db_mode=='D' || oper_line_status1=='99')
								{	
								tab_data+="<td nowrap class="+qryVal+"><img src='../../eCommon/images/RRnwd.gif'></img></td>";
								}  
								// Added Against End AMRI-CRF-0294 [IN049121
							   tab_data+="</tr>"; 
							   }			 
				    }
				 }
			  }	 
			 tab_data+="</table>";
			 tab_data+="</div>";
			 tab_data+="</tr>";
			 document.getElementById("menuExpand6").innerHTML = tab_data;
		}

		function createTable_ic()
		{
		var instrument_entry_cmp_yn=localTrimString(document.forms[0].instrument_entry_cmp_yn.value);
		var tab_data="";
	    tab_data+="<table border='1' cellpadding='3' cellspacing='0' width='100%' align='center'>"
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.operation.label" bundle="${common_labels}"/></td>"
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Instrument.label" bundle="${common_labels}"/></td>"
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.ActualUnits.Label" bundle="${ot_labels}"/></td>"
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.TrayNo.label" bundle="${common_labels}"/></td>"
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>" 
		<%if(("true").equals(bill_flag)){%>
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Charge.label" bundle="${common_labels}"/></td>";
		tab_data+="<td class='columnHeaderCenter'></td>";
		<%}%>
		rows_ic=parent.parent.parent.AdminObjectCollect.instrument_rows;
       if(rows_ic!=null){
	   for(var mm=0;mm<rows_ic.length;mm++) {
		   if(rows_ic[mm]!=null  && rows_ic[mm].db_mode!='D'){
				args4=mm;
				code_ic+= rows_ic[mm].oper_code+rows_ic[mm].instr_code+",";
			    if(mm%2==0)
			     qryVal="gridData";
			   else
				 qryVal="gridData";

			   var remarks=rows_ic[mm].remarks_ic;

			      if(instrument_entry_cmp_yn=="Y" ) {  
			       tab_data+="<tr>";
					tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].oper_desc)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].instr_desc)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].quantity)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].tray_no)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow_ic(remarks_value,'"+mm+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>";
				   <%if(("true").equals(bill_flag)){%>
				   var arr = rows_ic[mm].bill_str.split("::");
				   var inclexcl="";
		           var approvalreqd="";
				  
					if(arr[6]=='S')
					{
					if(arr[8]=="E" ||arr[8]=='' ||arr[8]=='null') inclexcl="<img src='../../eCommon/images/disabled.gif'  width='15px' align='texttop' ></img>";
					if(arr[8]=="I") inclexcl="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
					if(arr[5]=="Y") approvalreqd="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
					if(arr[5]=="N") approvalreqd="<img src='../../eCommon/images/disabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
					}
				   else{
					   inclexcl="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
					   approvalreqd="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
				   }
				  tab_data+="<td  class=gridData><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson'>&nbsp;<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green'><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font></B><br><fmt:message key="Common.Included.label" bundle="${common_labels}"/>?"+inclexcl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?"+approvalreqd+"";
				  tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_ic("+mm+");\"><img src='../../eOT/images/dollar.png'></img></a></td>";
				   <%}%>
				   tab_data+="</tr>"; 
				   } else { 
				   tab_data+="<tr>";
		 
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:sendparams_ic("+args4+");\">"+checkEmpty(rows_ic[mm].oper_desc)+"</a></td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].instr_desc)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].quantity)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].tray_no)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow_ic(remarks_value,'"+mm+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>";
				  <%if(("true").equals(bill_flag)){%>
				   var arr = rows_ic[mm].bill_str.split("::");
				   var inclexcl="";
				   var approvalreqd="";
				   if(arr[6]=='S')
				   {
					if(arr[8]=="E" ||arr[8]=='' ||arr[8]=='null') inclexcl="<img src='../../eCommon/images/disabled.gif'  width='15px' align='texttop' ></img>";
					if(arr[8]=="I") inclexcl="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
					if(arr[5]=="Y") approvalreqd="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
					if(arr[5]=="N") approvalreqd="<img src='../../eCommon/images/disabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
				   }else{
					   inclexcl="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
					   approvalreqd="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
				  }
				  tab_data+="<td  class=gridData><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson'>&nbsp;<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green'><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font></B><br><fmt:message key="Common.Included.label" bundle="${common_labels}"/>?"+inclexcl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?"+approvalreqd+"";
				  tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_ic("+mm+");\"><img src='../../eOT/images/dollar.png'></img></a></td>";
				   <%}%>
				   tab_data+="</tr>";
				   } 
	            }
	          }
             }
        tab_data+="</table>";
		tab_data+="</div>";
		tab_data+="</tr>";
		document.getElementById("menuExpand7").innerHTML = tab_data;
	  }

//Added by lakshmi against CRF-0058
	  function createTable_ic1()
		{
		var instrument_entry_cmp_yn=localTrimString(document.forms[0].instrument_entry_cmp_yn.value);
		var tab_data="";
	    tab_data+="<table border='1' cellpadding='3' cellspacing='0' width='100%' align='center'>"
		tab_data+="<td class='columnHeaderCenter'></td>"//Added by Muthu for RUT-CRF-0057
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.operation.label" bundle="${common_labels}"/></td>"
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Instrument.label" bundle="${common_labels}"/></td>"
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="eOT.ActualUnits.Label" bundle="${ot_labels}"/></td>"		
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>"//Added by lakshmi against CRF-0058		
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>" 
		<%if(("true").equals(bill_flag)){%>
		tab_data+="<td class='columnHeaderCenter'><fmt:message key="Common.Charge.label" bundle="${common_labels}"/></td>";
		tab_data+="<td class='columnHeaderCenter'></td>";
		<%}%>
		rows_ic=parent.parent.parent.AdminObjectCollect.instrument_rows;
       if(rows_ic!=null){
	   for(var mm=0;mm<rows_ic.length;mm++) {
		   if(rows_ic[mm]!=null  && rows_ic[mm].db_mode!='D'){
				args4=mm;
				code_ic+= rows_ic[mm].oper_code+rows_ic[mm].instr_code+",";
			    if(mm%2==0)
			     qryVal="gridData";
			   else
				 qryVal="gridData";

			   var remarks=rows_ic[mm].remarks_ic;

			      if(instrument_entry_cmp_yn=="Y" ) {  
			       tab_data+="<tr>";
//Added by Muthu for RUT-CRF-0057
		tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow_ic_img(instr_image,'"+mm+"','"+rows_ic[mm].instr_code+"');\"><img src='../../eOT/images/nolines_plus.gif'></img></a></td>";
//Added by Muthu for RUT-CRF-0057

				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].oper_desc)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].instr_desc)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].quantity)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].tray_no)+"</td>";				   
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow_ic(remarks_value,'"+mm+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>";
				   <%if(("true").equals(bill_flag)){%>
				   var arr = rows_ic[mm].bill_str.split("::");
				   var inclexcl="";
		           var approvalreqd="";
				  
					if(arr[6]=='S')
					{
					if(arr[8]=="E" ||arr[8]=='' ||arr[8]=='null') inclexcl="<img src='../../eCommon/images/disabled.gif'  width='15px' align='texttop' ></img>";
					if(arr[8]=="I") inclexcl="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
					if(arr[5]=="Y") approvalreqd="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
					if(arr[5]=="N") approvalreqd="<img src='../../eCommon/images/disabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
					}
				   else{
					   inclexcl="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
					   approvalreqd="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
				   }
				  tab_data+="<td  class=gridData><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson'>&nbsp;<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green'><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font></B><br><fmt:message key="Common.Included.label" bundle="${common_labels}"/>?"+inclexcl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?"+approvalreqd+"";
				  tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_ic("+mm+");\"><img src='../../eOT/images/dollar.png'></img></a></td>";
				   <%}%>
				   tab_data+="</tr>"; 
				   } else { 
				   tab_data+="<tr>";
	tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow_ic_img(instr_image,'"+mm+"','"+rows_ic[mm].instr_code+"');\"><img src='../../eOT/images/nolines_plus.gif'></img></a></td>";
//Added by Muthu for RUT-CRF-0057

				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:sendparams_ic("+args4+");\">"+checkEmpty(rows_ic[mm].oper_desc)+"</a></td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].instr_desc)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].quantity)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+checkEmpty(rows_ic[mm].tray_no)+"</td>";
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow_ic(remarks_value,'"+mm+"');\"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>";
				  <%if(("true").equals(bill_flag)){%>
				   var arr = rows_ic[mm].bill_str.split("::");
				   var inclexcl="";
				   var approvalreqd="";
				   if(arr[6]=='S')
				   {
					if(arr[8]=="E" ||arr[8]=='' ||arr[8]=='null') inclexcl="<img src='../../eCommon/images/disabled.gif'  width='15px' align='texttop' ></img>";
					if(arr[8]=="I") inclexcl="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
					if(arr[5]=="Y") approvalreqd="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
					if(arr[5]=="N") approvalreqd="<img src='../../eCommon/images/disabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
				   }else{
					   inclexcl="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
					   approvalreqd="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
				  }
				  tab_data+="<td  class=gridData><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson'>&nbsp;<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green'><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font></B><br><fmt:message key="Common.Included.label" bundle="${common_labels}"/>?"+inclexcl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?"+approvalreqd+"";
				  tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_ic("+mm+");\"><img src='../../eOT/images/dollar.png'></img></a></td>";
				   <%}%>
				   tab_data+="</tr>";
				   } 
	            }
	          }
             }
        tab_data+="</table>";
		tab_data+="</div>";
		tab_data+="</tr>";
		document.getElementById("menuExpand7").innerHTML = tab_data;
	  }
		function createTable_op()
		{
		var objFrm = parent.parent.parent.AdminObjectCollect;
		var bill_flag=document.forms[0].bill_flag.value;
		var proc_chrg_cmp_yn=document.forms[0].proc_chrg_cmp_yn.value;
		var tab_data="";
		var bill_data="";
		var oper_code="";
		var side_applicable="";
		var remarks="";
		var chk_status="";
		var cancel_remarks="";
		var oper_line_status="";
		var oper_line_num="";
		var doc_send_val="";
		var bill_yn="";// now not using this flags proc_chrg_cmp_yn flag only using.
		var billed_yn="";
		var fpp_category="";//Added Against ML-MMS-QH-CRF-1939-US4
		var fpp_order_yn="";//Added Against ML-MMS-QH-CRF-1939-US4
		var chk_status="";
		var obj=document.getElementById("menuExpand1");
		tab_data="<table border='1' cellpadding='3' cellspacing='0' width='100%' align='center'>"
		tab_data+="<td nowrap class='columnHeaderCenter'><fmt:message key="eOT.OperationCode.Label" bundle="${ot_labels}"/> </td>";
		tab_data+="<td nowrap class='columnHeaderCenter'> <fmt:message key="Common.description.label" bundle="${common_labels}"/> </td>";
		tab_data+="<td nowrap class='columnHeaderCenter'><fmt:message key="eOT.SideApplicable.Label" bundle="${ot_labels}"/></td>";
		tab_data+="<td nowrap class='columnHeaderCenter'><fmt:message key="eOT.PreOperativeComments.Label" bundle="${ot_labels}"/></td>";  

		if(bill_flag=="true"){
		tab_data+="<td nowrap class='columnHeaderCenter'><fmt:message key="Common.Charge.label" bundle="${common_labels}"/></td>";
		tab_data+="<td nowrap class='columnHeaderCenter'></td>";
		}
		tab_data+="<td nowrap class='columnHeaderCenter'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>"  
		if(objFrm.op_rows!=null){
		for(var jj=0;jj<objFrm.op_rows.length;jj++) {
		if(objFrm.op_rows[jj]!=null){
		oper_code=objFrm.op_rows[jj].oper_code;
		oper_desc=objFrm.op_rows[jj].oper_desc;        
		side_applicable=objFrm.op_rows[jj].side_applicable;
		side_applicable_desc=objFrm.op_rows[jj].side_applicable_desc;
		chk_status=objFrm.op_rows[jj].chk_status;
		cancel_remarks=objFrm.op_rows[jj].cancel_remarks;
		remarks=objFrm.op_rows[jj].remarks;
		oper_line_num=objFrm.op_rows[jj].line_no;
		oper_line_status=objFrm.op_rows[jj].oper_line_status;
		bill_yn =objFrm.op_rows[jj].bill_yn;
		billed_yn =objFrm.op_rows[jj].billed_yn;
		//Added Against ML-MMS-QH-CRF-1939-US4...starts
	<% if(Include_Fpp_yn.equals("Y") && isIncludeFpp && count==1 && (bill_flag.equals("true"))){%>
				var arr=new Array();
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				var param="func_mode=getFppList&oper_code="+oper_code;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
				xmlHttp.send(xmlDoc);
				var retVal = localTrimString(xmlHttp.responseText);
				if(retVal!=''){
				ar=retVal.split("::");
				fpp_order_yn=ar[0];
				}		
		fpp_category =trimString(objFrm.op_rows[jj].fpp_category);
		
		if(fpp_category == "S" || fpp_category == "M" || fpp_category == "C")
			{
					 // fpp_order_yn = "Y";
			if(fpp_category == "S") fpp_category ="Simple";
			if(fpp_category == "M") fpp_category ="Moderate";
			if(fpp_category == "C") fpp_category ="Complex";
			}
	<%
	}
	%>
		//Added Against ML-MMS-QH-CRF-1939-US4...ends
		
		if(jj%2==0)
		qryVal="gridData";
		else
		qryVal="gridData";
		
		remarks=encodeURIComponent(remarks);
		cancel_remarks=encodeURIComponent(cancel_remarks);
		
		var tab_name = document.forms[0].tab_name.value
		
		tab_data+="<tr>";
		tab_data+="<td nowrap class="+qryVal+">"+oper_code+"</td>";
		tab_data+="<td nowrap class="+qryVal+">"+objFrm.op_rows[jj].oper_desc+"</td>";
		tab_data+="<td nowrap class="+qryVal+">"+objFrm.op_rows[jj].side_applicable_desc+"</td>";
		tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow_op(remarks_value,'"+jj+"');\"><fmt:message key="eOT.PreOperativeComments.Label" bundle="${ot_labels}"/></a><input type='hidden' name='chk_status' id='chk_status' value='"+chk_status+"'><input type='hidden' name='cancel_remarks' id='cancel_remarks' value='"+cancel_remarks+"'></td>";
		if(bill_flag=="true"){
		if(chk_status !="99"){
		var arr = objFrm.op_rows[jj].bill_str.split("::");
		var inclexcl="";
		var approvalreqd="";
		if(arr[6]=='S')
		{
		if(arr[8]=="E" ||arr[8]==''||arr[8]=='null') inclexcl="<img src='../../eCommon/images/disabled.gif'  width='15px' align='texttop' ></img>";
		if(arr[8]=="I") inclexcl="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
		if(arr[5]=="Y") approvalreqd="<img src='../../eCommon/images/enabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
		if(arr[5]=="N") approvalreqd="<img src='../../eCommon/images/disabled.gif' hegiht='15px' width='15px' align='texttop'></img>";
		}else{
		inclexcl="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
		approvalreqd="<img src='../../eCommon/images/blank.gif' hegiht='15px' width='15px' align='texttop'></img>";
		}
		if(fpp_order_yn=="Y" && tab_name === 'SCHEDULED')
		{	
		tab_data+="<td  class=gridData><B><font color='Indigo' ><fmt:message key="eOT.FppCategory.Label" bundle="${ot_labels}"/>:&nbsp"+fpp_category+"&nbsp;<fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson'>&nbsp;<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green'><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font></B><br><fmt:message key="Common.Included.label" bundle="${common_labels}"/>?"+inclexcl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?"+approvalreqd+"";
		tab_data+="</font></td>";
		}
		else
		{
			tab_data+="<td  class=gridData><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson'>&nbsp;<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green'><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font></B><br><fmt:message key="Common.Included.label" bundle="${common_labels}"/>?"+inclexcl+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?"+approvalreqd+"";
		tab_data+="</font></td>";
		}
		if(proc_chrg_cmp_yn=="N")
		{
		tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_op("+jj+");\"><img src='../../eOT/images/dollar.png'></img></a></td>";
		}
		else{
		tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow_op("+jj+");\"><img src='../../eOT/images/dollar.png'></img></a></td>";
		}
		}else {
		tab_data+="<td nowrap class=gridData><B><font color='Indigo' >&nbsp</td>";
		tab_data+="<td nowrap class="+qryVal+">&nbsp</td>"
		}
		}
		if(chk_status=="99") {
		tab_data+="<td nowrap class="+qryVal+"><img src='../../eCommon/images/RRnwd.gif'></img></td>";
		}else
		{
		tab_data+="<td nowrap class="+qryVal+">&nbsp;</td>";
		}
		tab_data+="</tr>";
		}
		}            
		}
		document.getElementById("menuExpand1").innerHTML = tab_data;
		} 
	    </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	</head>
<%
	String frm_pick_list = "N";
    String disable_flag = "";
	String flag_op = checkForNull(request.getParameter("flag_op"))==""?"Y":request.getParameter("flag_op");
	String flag_ac = checkForNull(request.getParameter("flag_ac"))==""?"Y":request.getParameter("flag_ac");
	String flag_dc = checkForNull(request.getParameter("flag_dc"))==""?"Y":request.getParameter("flag_dc");
	String flag_pi = checkForNull(request.getParameter("flag_pi"))==""?"Y":request.getParameter("flag_pi");
	String flag_cp = checkForNull(request.getParameter("flag_cp"))==""?"Y":request.getParameter("flag_cp");
	String flag_eq = checkForNull(request.getParameter("flag_eq"))==""?"Y":request.getParameter("flag_eq");
	String flag_ic = checkForNull(request.getParameter("flag_ic"))==""?"Y":request.getParameter("flag_ic");
	String flag_or = checkForNull(request.getParameter("flag_or"))==""?"Y":request.getParameter("flag_or");
	String flag_ha = checkForNull(request.getParameter("flag_ha"))==""?"Y":request.getParameter("flag_ha");
	String flag_rr = checkForNull(request.getParameter("flag_rr"))==""?"Y":request.getParameter("flag_rr");
	String flag_asc = checkForNull(request.getParameter("flag_asc"))==""?"Y":request.getParameter("flag_asc");
	//Added by lakshmi
	String flag_pr = checkForNull(request.getParameter("flag_pr"))==""?"Y":request.getParameter("flag_pr");
	String slate_user_id   = checkForNull(request.getParameter("slate_user_id"));
	String module_id       = CommonBean.checkForNull(request.getParameter("module_id"));
	String called_from     = checkForNull(request.getParameter("called_from"));
	String oper_num        = checkForNull(request.getParameter("oper_num"));
	String patient_id      = checkForNull(request.getParameter("patient_id"));
	String booking_num     = checkForNull(request.getParameter("booking_num"));
	String surgeon_code    = checkForNull(request.getParameter("surgeon_code"));
	String surgeon_code1    = "";
	String speciality_code = checkForNull(request.getParameter("speciality_code"));
	String params	       = request.getQueryString();
	String oper_code= "";
	String description= "";
	String oper_remarks= "";
	String order_line_no = "";
	String side_applicable="";
	String st_charge_based_yn="";
	
	String serv_date="";
	String rate="";
	String posted_yn="";
	//added by lakshmi for crf-0601
	String p_report_id="";
	CallableStatement statement =null;
	String arr[]=null;
	String val= "";
	HashMap line_no_map = new HashMap();
	String line_no="";
	boolean exist_rec_pi   = false;
	boolean exist_rec_cons = false;
	boolean exist_rec_eq   = false;
	boolean exist_rec_ic   = false;
	boolean pick_list      = false;
	StringBuffer oper_codes = new StringBuffer();
	String side_applicalbe_desc= "";
	String rightSide_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.RightSide.Label","ot_labels");
	String leftSide_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LeftSide.Label","ot_labels");
	String bilateral=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Bilateral.Label","ot_labels");
	String notApplicable_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
	con=null;
	PreparedStatement pstmt_sm_report_display = null; //muthu
	PreparedStatement pstmt_ot_post_oper_hdr = null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt2=null;
	PreparedStatement pstmt_bl=null;
	PreparedStatement pstmt_st = null;
	PreparedStatement pstmt_pi = null;
	PreparedStatement pstmt_cons=null;
	PreparedStatement pstmt_eq=null;
	PreparedStatement pstmt_ic=null;
	PreparedStatement pstmt_ha_room = null;
	PreparedStatement pstmt_rec_chargeyn = null;
	PreparedStatement pstmt_or_chargeableyn= null;
	PreparedStatement pstmt_req_store= null;
	PreparedStatement pstm_bl= null;
	PreparedStatement pstmt_param_for_facility= null;
	ResultSet rs=null;
	ResultSet rst_sm_report_display=null; //muthu
	ResultSet rst_ot_post_oper_hdr=null;
	ResultSet rs_bl=null;
	ResultSet rst_bl=null;
	ResultSet rset_req_store=null;
	ResultSet rst_st = null;
	ResultSet rst_pi = null;
	ResultSet rst_cons=null;
	ResultSet rst_eq=null;
	ResultSet rst_ic=null;
	ResultSet rst_ha_room = null;
	ResultSet rst_rec_chargeyn = null;
	ResultSet rst_or_chargeyn = null;
	PreparedStatement pstmt_ord_phy_id=null;
	ResultSet rset_one=null;
	ResultSet rst_param_for_facility=null;
	String tr_no="";
	String ref_source_code="";
	String req_store_code="";
	String bill_yn="";
	String billed_yn="";
    String rec_implants_in_admin_notes_yn="";
	String rec_equp_in_admin_notes_yn="";
	String rec_instr_in_admin_notes_yn="";
	String rec_packs_in_admin_notes_yn="";
	String st_interface_flag="";
	String st_doc_type_rti="";
	String st_doc_type_sli="";
	String operation_sub_services_yn="";
	String charge_holding_area_yn="";
	String charge_operating_room_yn="";
	String charge_recovery_room_yn="";
	String oper_line_num="";
	String oper_finalization_stage="";
	String recy_room_finalization_stage="";
	String hold_finalization_stage="";
	String oper_room_finalization_stage="";
	String finalize_packs_in="";
	    //Bharati
	String st_location="";
	String desiredDate = "";
	String currentDateTime = "";
	String oneWeekDate = "";
	HashMap bill_info     =new HashMap();
	HashMap bill_info_pi  =new HashMap();
	HashMap bill_info_cons=new HashMap();
	HashMap bill_info_eq  =new HashMap();
	HashMap bill_info_ic  =new HashMap();
	HashMap bill_info_reqd_dtls =new HashMap();
//Added by lakshmi against CRF-0058
	PreparedStatement pstmt_sm_report_display1 = null;
	ResultSet rst_sm_report_display1=null;
try{
	con = ConnectionManager.getConnection(request);
	//Added by lakshmi against CRF-0058 starts here	
	
		String Ot_param="";
		//Modified by Rajesh
		String sql_sm_report1="select NVL(INSTRUMENT_CSSD_IMAGE,'N') PICKLIST from OT_PARAM where rownum = 1";
		//Modified by Rajesh
		pstmt_sm_report_display1=con.prepareStatement(sql_sm_report1);
		rst_sm_report_display1=pstmt_sm_report_display1.executeQuery();
		if(rst_sm_report_display1 !=null && rst_sm_report_display1.next())
	   {
		Ot_param=checkForNull(rst_sm_report_display1.getString("PICKLIST"));
		
	   }
	   if(rst_sm_report_display1!=null)rst_sm_report_display1.close();
	   if(pstmt_sm_report_display1!=null)pstmt_sm_report_display1.close();
	   //Added by lakshmi against CRF-0058 ends here
	String sql_param_for_facility="SELECT OPER_FINALIZATION_STAGE,NVL(RECY_ROOM_FINALIZATION_STAGE,'X') RECY_ROOM_FINALIZATION_STAGE, NVL(HOLD_FINALIZATION_STAGE,'X') HOLD_FINALIZATION_STAGE, NVL(OPER_ROOM_FINALIZATION_STAGE,'X')OPER_ROOM_FINALIZATION_STAGE,OPERATION_SUB_SERVICES_YN,CHARGE_HOLDING_AREA_YN, CHARGE_OPERATING_ROOM_YN, CHARGE_RECOVERY_ROOM_YN,NVL(REC_IMPLANTS_IN_ADMIN_YN,'N') REC_IMPLANTS_IN_ADMIN_YN, NVL(REC_EQUP_IN_ADMIN_YN,'N') REC_EQUP_IN_ADMIN_YN,NVL(REC_INSTR_IN_ADMIN_YN,'N')REC_INSTR_IN_ADMIN_YN,NVL(REC_PACKS_IN_ADMIN_YN,'N')REC_PACKS_IN_ADMIN_YN,NVL(ST_INTERFACE_FLAG,'N') ST_INTERFACE_FLAG,NVL(FINALIZE_PACKS_IN,'N')FINALIZE_PACKS_IN,ST_DOC_TYPE_RTI,ST_DOC_TYPE_SLI FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID='"+facility_id+"'";

	pstmt_param_for_facility=con.prepareStatement(sql_param_for_facility);
	rst_param_for_facility=pstmt_param_for_facility.executeQuery(sql_param_for_facility);
	if(rst_param_for_facility !=null && rst_param_for_facility.next())
    {
	oper_finalization_stage=checkForNull(rst_param_for_facility.getString("OPER_FINALIZATION_STAGE"));
	recy_room_finalization_stage=checkForNull(rst_param_for_facility.getString("RECY_ROOM_FINALIZATION_STAGE"));
	hold_finalization_stage=checkForNull(rst_param_for_facility.getString("HOLD_FINALIZATION_STAGE"));
	oper_room_finalization_stage=checkForNull(rst_param_for_facility.getString("OPER_ROOM_FINALIZATION_STAGE"));
	operation_sub_services_yn=checkForNull(rst_param_for_facility.getString("OPERATION_SUB_SERVICES_YN"));
	charge_holding_area_yn=checkForNull(rst_param_for_facility.getString("CHARGE_HOLDING_AREA_YN"));
	charge_operating_room_yn=checkForNull(rst_param_for_facility.getString("CHARGE_OPERATING_ROOM_YN"));
	charge_recovery_room_yn=checkForNull(rst_param_for_facility.getString("CHARGE_RECOVERY_ROOM_YN"));
	rec_implants_in_admin_notes_yn=checkForNull(rst_param_for_facility.getString("REC_IMPLANTS_IN_ADMIN_YN"));
	rec_equp_in_admin_notes_yn=checkForNull(rst_param_for_facility.getString("REC_EQUP_IN_ADMIN_YN"));
	rec_instr_in_admin_notes_yn=checkForNull(rst_param_for_facility.getString("REC_INSTR_IN_ADMIN_YN"));
	rec_packs_in_admin_notes_yn=checkForNull(rst_param_for_facility.getString("REC_PACKS_IN_ADMIN_YN"));
	st_interface_flag=checkForNull(rst_param_for_facility.getString("ST_INTERFACE_FLAG"));

	finalize_packs_in=checkForNull(rst_param_for_facility.getString("FINALIZE_PACKS_IN"));
	st_doc_type_rti =checkForNull(rst_param_for_facility.getString("ST_DOC_TYPE_RTI"));
	st_doc_type_sli=checkForNull(rst_param_for_facility.getString("ST_DOC_TYPE_SLI"));

	if(("Y").equals(st_interface_flag))
	{
	 if(("").equals(st_doc_type_rti) || ("").equals(st_doc_type_sli))
	 {
		out.println("<script>alert(getMessage('PRC-OT0055','OT')); window.close();</script>");
	 }
	}
	}
	currentDateTime = com.ehis.util.DateUtils.getCurrentDate("DMYHM", locale);
	if(locale.equals("th"))
	currentDateTime = com.ehis.util.DateUtils.getCurrentDate("DMYHM", "en"); //Modified against SKR-SCF-1289
	System.err.println("currentDateTime===>"+currentDateTime);
	oneWeekDate = com.ehis.util.DateUtils.plusDate((com.ehis.util.DateUtils.plusDate(com.ehis.util.DateUtils.getCurrentDate("DMY", locale), "DMY", locale, 1, "d")), "DMY", locale, 1, "w");	//048580
		
     String SQL_OP = "";
    if(isIncludeFpp  && count==1 && Include_Fpp_yn.equals("Y") && ("true").equals(bill_flag)){
		SQL_OP="SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM,A.RIGHT_LEFT_FLAG,A.OPER_REMARKS,A.ORDER_LINE_NUM ORDER_LINE_NUM,A.ORDER_ID ORDER_ID,A.OPER_LINE_STATUS OPER_LINE_STATUS,A.CANCEL_REMARKS CANCEL_REMARKS ,B.LONG_DESC OPR_DESC,B.ORDER_CATALOG_CODE ORDER_CATALOG_CODE,A.FPP_CATEGORY FROM OT_POST_OPER_DTLS A, OT_OPER_MAST_LANG_VW B WHERE  A.OPERATING_FACILITY_ID  = '"+facility_id+"' AND A.OPER_NUM = '"+oper_num+"' AND A.OPER_CODE = B.OPER_CODE AND B.LANGUAGE_ID = '"+locale+"'" ; //MODIFIED Against ML-MMS-QH-CRF-1939-US4
		}else{
		SQL_OP="SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM,A.RIGHT_LEFT_FLAG,A.OPER_REMARKS,A.ORDER_LINE_NUM ORDER_LINE_NUM,A.ORDER_ID ORDER_ID,A.OPER_LINE_STATUS OPER_LINE_STATUS,A.CANCEL_REMARKS CANCEL_REMARKS ,B.LONG_DESC OPR_DESC,B.ORDER_CATALOG_CODE ORDER_CATALOG_CODE FROM OT_POST_OPER_DTLS A, OT_OPER_MAST_LANG_VW B WHERE  A.OPERATING_FACILITY_ID ='"+facility_id+"' AND A.OPER_NUM = '"+oper_num+"' AND A.OPER_CODE = B.OPER_CODE AND B.LANGUAGE_ID = '"+locale+"'";//MMS-QH-CRF-0199			
		}
	
	pstmt = con.prepareStatement(SQL_OP,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	rs  = pstmt.executeQuery();	
    
	String p_qty = "";
	String key = "";
	String key_pi = "";
	String key_cons = "";
	String key_eq = "";
	String key_ic = "";
	String key_line="";
	String key_line_pi="";
	String key_line_cons="";
	String key_line_eq="";
	String key_line_ic="";
	String bill_str="";
	String panel_str="";
	
	StringBuilder bl_bfr = new StringBuilder();
	String order_id="";
	String order_line_num="";
	String booking_date  = "";
	String encounter_id   = "";
	String patient_class   = "";
	String visit_id   = "";
	String catalog_code   = "";

	String item_id="";
	String req_store="";
	String sql_mm_code="";
	String mm_item_code="";
	String avail_stock="";
	String oper_room_code="";
    String sale_document_no="";
	String no_of_units="";
	String sale_document_type="";
	
	String recovery_start_time="";
	String recovery_start_time1="";
	String recovery_end_time="";
	String recovery_end_time1="";
	String recv_calc_chargeable_units="";
	String recv_chargeable_units="";
	String recv_bl_accession_num="";
	String recovery_room_code="";
	String holding_area_code="";
	String holding_seq_num="";
	String checked_in_date_time="";
	String checked_out_date_time="";
	String checked_in_date_time1="";
	String checked_out_date_time1="";
	String calc_chargeable_units="";
	String chargeable_units="";
	String bl_accession_num="";
   	String trfr_ward_code="";
	String oper_status="";    
	String oper_room_code_or="";
	String check_into_or_time="";
	String check_into_or_time1="";
	String check_out_or_time="";
	String check_out_or_time1="";
	String or_calc_chargeable_units="";
	String or_chargeable_units="";
	String or_bl_accession_num="";
	String disable_rec=""; 
	String disable_or=""; 
	String disable_ha=""; 

	String encounter_id1="";
	String episode_id="";
	String episode_type="";
	String visit_id1="";
	String nature_type="";
	String nature_code="";
	String order_id1="";
	String str_order_catalog_code="";
	String order_catalog="";
	
	String implant_entry_cmp_yn="";
	String consumable_entry_cmp_yn="";
	String equipment_entry_cmp_yn="";
	String instrument_entry_cmp_yn="";
	
	String rec_chargeable_yn="";
	String or_chargeable_yn="";
	String hld_chrg_cmp_yn="";
    String or_chrg_cmp_yn="";
    String rec_chrg_cmp_yn="";
	String checkInTime = "";
	String impl_disable_flag="";
	String cons_disable_flag="";
	String eq_disable_flag="";
	String ic_disable_flag="";
	String bl_episode_type="";
	String cancel_remarks="";
	String oper_line_status= ""; 
	String proc_chrg_cmp_yn= ""; 
	//Muthu Modified on 21-10-11
	String customer_id1="";
	String sql_sm_report="select customer_id from SM_SITE_PARAM where rownum = 1";
	pstmt_sm_report_display=con.prepareStatement(sql_sm_report);
	rst_sm_report_display=pstmt_sm_report_display.executeQuery();
	if(rst_sm_report_display !=null && rst_sm_report_display.next())
	   {
		customer_id1=checkForNull(rst_sm_report_display.getString("customer_id"));
	   }
	   if(rst_sm_report_display!=null)rst_sm_report_display.close();
if(pstmt_sm_report_display!=null)pstmt_sm_report_display.close();
	//Muthu Modified on 21-10-11
  
    int maxRecord=0;
	   String sql_ot_post_oper_hdr="SELECT DECODE (?, 'en', TO_CHAR (check_in_time, 'DD/MM/YYYY HH24:MI'), 'th', TO_CHAR (check_in_time, 'DD/MM/YYYY HH24:MI', 'NLS_CALENDAR=''THAI BUDDHA''' ) ) check_in_time, encounter_id, episode_id, episode_type, visit_id, nature_type,nature_code, order_id, ref_source_code, implant_entry_cmp_yn, consumable_entry_cmp_yn, equipment_entry_cmp_yn, INSTRUMENT_ENTRY_CMP_YN,NVL(HLD_CHRG_CMP_YN,'N')HLD_CHRG_CMP_YN,NVL(OR_CHRG_CMP_YN  ,'N')OR_CHRG_CMP_YN ,NVL(REC_CHRG_CMP_YN  ,'N') REC_CHRG_CMP_YN,PATIENT_CLASS,NVL(PROC_CHRG_CMP_YN  ,'N')PROC_CHRG_CMP_YN,RECVERY_ROOM_CODE,TO_CHAR(RECOVERY_START_TIME,'MM/DD/YYYY HH24:MI') RECOVERY_START_TIME,TO_CHAR(RECOVERY_START_TIME,'DD/MM/YYYY HH24:MI') RECOVERY_START_TIME1,TO_CHAR(RECOVERY_END_TIME,'MM/DD/YYYY HH24:MI') RECOVERY_END_TIME,TO_CHAR(RECOVERY_END_TIME,'DD/MM/YYYY HH24:MI') RECOVERY_END_TIME1,RECV_CALC_CHARGEABLE_UNITS, RECV_CHARGEABLE_UNITS, RECV_BL_ACCESSION_NUM,TRFR_WARD_CODE,OPER_STATUS,OPER_ROOM_CODE,TO_CHAR(CHECK_INTO_OR_TIME,'MM/DD/YYYY HH24:MI') CHECK_INTO_OR_TIME,TO_CHAR(CHECK_INTO_OR_TIME,'DD/MM/YYYY HH24:MI') CHECK_INTO_OR_TIME1,TO_CHAR(CHECK_OUT_TIME,'MM/DD/YYYY HH24:MI') CHECK_OUT_TIME,TO_CHAR(CHECK_OUT_TIME,'DD/MM/YYYY HH24:MI') CHECK_OUT_TIME1,OR_CALC_CHARGEABLE_UNITS, OR_CHARGEABLE_UNITS, OR_BL_ACCESSION_NUM,PATIENT_ID,(SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') FROM DUAL) SERV_DATE,SURGEON_CODE FROM OT_POST_OPER_HDR  WHERE OPERATING_FACILITY_ID ='"+facility_id+"' AND OPER_NUM='"+oper_num+"'"; 	//048580
	   pstmt_ot_post_oper_hdr=con.prepareStatement(sql_ot_post_oper_hdr);
	   pstmt_ot_post_oper_hdr.setString(1, locale);
	   rst_ot_post_oper_hdr=pstmt_ot_post_oper_hdr.executeQuery();
       
	   if(rst_ot_post_oper_hdr !=null && rst_ot_post_oper_hdr.next())
	   {
		encounter_id1=checkForNull(rst_ot_post_oper_hdr.getString("ENCOUNTER_ID"));
		episode_id=checkForNull(rst_ot_post_oper_hdr.getString("EPISODE_ID"));
		episode_type=checkForNull(rst_ot_post_oper_hdr.getString("EPISODE_TYPE"));
		visit_id1=checkForNull(rst_ot_post_oper_hdr.getString("VISIT_ID"));
		nature_type=checkForNull(rst_ot_post_oper_hdr.getString("NATURE_TYPE"));
		nature_code=checkForNull(rst_ot_post_oper_hdr.getString("NATURE_CODE"));
		order_id1=checkForNull(rst_ot_post_oper_hdr.getString("ORDER_ID"));
		ref_source_code=checkForNull(rst_ot_post_oper_hdr.getString("REF_SOURCE_CODE"));
		implant_entry_cmp_yn=checkForNull(rst_ot_post_oper_hdr.getString("IMPLANT_ENTRY_CMP_YN"));
		consumable_entry_cmp_yn=checkForNull(rst_ot_post_oper_hdr.getString("CONSUMABLE_ENTRY_CMP_YN"));
		equipment_entry_cmp_yn=checkForNull(rst_ot_post_oper_hdr.getString("EQUIPMENT_ENTRY_CMP_YN"));
		instrument_entry_cmp_yn=checkForNull(rst_ot_post_oper_hdr.getString("INSTRUMENT_ENTRY_CMP_YN"));
		hld_chrg_cmp_yn=checkForNull(rst_ot_post_oper_hdr.getString("HLD_CHRG_CMP_YN"));
		or_chrg_cmp_yn=checkForNull(rst_ot_post_oper_hdr.getString("OR_CHRG_CMP_YN"));
		rec_chrg_cmp_yn=checkForNull(rst_ot_post_oper_hdr.getString("REC_CHRG_CMP_YN"));
		patient_class=checkForNull(rst_ot_post_oper_hdr.getString("PATIENT_CLASS"));
		proc_chrg_cmp_yn=checkForNull(rst_ot_post_oper_hdr.getString("PROC_CHRG_CMP_YN"));
		recovery_room_code=checkForNull(rst_ot_post_oper_hdr.getString("RECVERY_ROOM_CODE"));
		recovery_start_time1=checkForNull(com.ehis.util.DateUtils.convertDate(rst_ot_post_oper_hdr.getString("RECOVERY_START_TIME1"),"DMYHM","en",locale));
		recovery_start_time=checkForNull(rst_ot_post_oper_hdr.getString("RECOVERY_START_TIME"));
		recovery_end_time1=checkForNull(com.ehis.util.DateUtils.convertDate(rst_ot_post_oper_hdr.getString("RECOVERY_END_TIME1"),"DMYHM","en",locale));
		recovery_end_time=checkForNull(rst_ot_post_oper_hdr.getString("RECOVERY_END_TIME"));
		recv_calc_chargeable_units=checkForNull(rst_ot_post_oper_hdr.getString("RECV_CALC_CHARGEABLE_UNITS"));
		recv_chargeable_units=checkForNull(rst_ot_post_oper_hdr.getString("RECV_CHARGEABLE_UNITS"));
		recv_bl_accession_num=checkForNull(rst_ot_post_oper_hdr.getString("RECV_BL_ACCESSION_NUM"));
		trfr_ward_code=checkForNull(rst_ot_post_oper_hdr.getString("TRFR_WARD_CODE"));
		oper_status=checkForNull(rst_ot_post_oper_hdr.getString("OPER_STATUS"));
		oper_room_code=checkForNull(rst_ot_post_oper_hdr.getString("OPER_ROOM_CODE"));
		oper_room_code_or=checkForNull(rst_ot_post_oper_hdr.getString("OPER_ROOM_CODE"));
		check_into_or_time1=checkForNull(com.ehis.util.DateUtils.convertDate(rst_ot_post_oper_hdr.getString("CHECK_INTO_OR_TIME1"),"DMYHM","en",locale));
		check_into_or_time=checkForNull(rst_ot_post_oper_hdr.getString("CHECK_INTO_OR_TIME"));
		check_out_or_time1=checkForNull(com.ehis.util.DateUtils.convertDate(rst_ot_post_oper_hdr.getString("CHECK_OUT_TIME1"),"DMYHM","en",locale));
		check_out_or_time=checkForNull(rst_ot_post_oper_hdr.getString("CHECK_OUT_TIME"));
		or_calc_chargeable_units=checkForNull(rst_ot_post_oper_hdr.getString("OR_CALC_CHARGEABLE_UNITS"));
		or_chargeable_units=checkForNull(rst_ot_post_oper_hdr.getString("OR_CHARGEABLE_UNITS"));
		or_bl_accession_num=checkForNull(rst_ot_post_oper_hdr.getString("OR_BL_ACCESSION_NUM"));
		patient_id=checkForNull(rst_ot_post_oper_hdr.getString("PATIENT_ID"));
		serv_date=checkForNull(rst_ot_post_oper_hdr.getString("SERV_DATE"));
		surgeon_code1=checkForNull(rst_ot_post_oper_hdr.getString("SURGEON_CODE"));	
		checkInTime = checkForNull(rst_ot_post_oper_hdr.getString("check_in_time"));
		System.err.println("AdministrativeFunctionforAllChargesFrame.jsp, locale====>"+locale);
		//Added Against SKR-SCF-1289 Starts
		if(locale.equals("th"))
		{
			String arr1[]=null;
			String arr2[]=null;
			arr1 = checkInTime.split(" ");
			arr2 = arr1[0].split("/");
			int a = Integer.parseInt(arr2[2]);
			a = a-543;
			checkInTime = arr2[0] + "/" + arr2[1] + "/" + a + " " + arr1[1];
			}
		//Added Against SKR-SCF-1289 Ends
		}
		String p_ord_practitioner_id="";
		String sql_phy_id="SELECT ORD_PRACT_ID from or_order where order_id='"+order_id1+"'";
		pstmt_ord_phy_id=con.prepareStatement(sql_phy_id);
		rset_one=pstmt_ord_phy_id.executeQuery();
		if(rset_one !=null && rset_one.next())
		{
		p_ord_practitioner_id =rset_one.getString("ORD_PRACT_ID");
		if(p_ord_practitioner_id ==null) p_ord_practitioner_id="";	
		}

		String sql_bl_epi_type="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = '"+patient_class+"' AND EPISODE_TYPE ='"+episode_type+"' ";
		pstmt_bl = con.prepareStatement(sql_bl_epi_type);
		rst_bl=pstmt_bl.executeQuery();
		if(rst_bl !=null && rst_bl.next())
		{
		bl_episode_type=checkForNull(rst_bl.getString(1));
		}
				
		bill_info_reqd_dtls.put("patient_id",patient_id);
		bill_info_reqd_dtls.put("encounter_id",encounter_id1);
		bill_info_reqd_dtls.put("episode_id",episode_id);
		bill_info_reqd_dtls.put("visit_id",visit_id1);
		bill_info_reqd_dtls.put("serv_date",serv_date);
		bill_info_reqd_dtls.put("pract_staff_id",surgeon_code1);
		bill_info_reqd_dtls.put("patient_class",patient_class);
		bill_info_reqd_dtls.put("bl_episode_type",bl_episode_type);
		bill_info_reqd_dtls.put("order_id",order_id1);

		if(("Y").equals(implant_entry_cmp_yn))    impl_disable_flag="disabled";
		if(("Y").equals(consumable_entry_cmp_yn)) cons_disable_flag="disabled";
		if(("Y").equals(equipment_entry_cmp_yn))  eq_disable_flag="disabled";
		if(("Y").equals(instrument_entry_cmp_yn)) ic_disable_flag="disabled";
		if(("Y").equals(rec_chrg_cmp_yn))         disable_rec="disabled";
		if(("Y").equals(hld_chrg_cmp_yn))         disable_ha="disabled";
		if(("Y").equals(or_chrg_cmp_yn))          disable_or="disabled";

	if(("R").equals(recy_room_finalization_stage))disable_rec="disabled";
    if(("H").equals(hold_finalization_stage))     disable_ha="disabled";
    if(("O").equals(oper_room_finalization_stage))disable_or="disabled";

	String sql_rec_chargeyn="SELECT NVL(CHARGEABLE_YN,'N') FROM OT_RECOVERY_ROOM_LANG_VW WHERE RECOVERY_ROOM_CODE ='"+recovery_room_code+"' AND OPERATING_FACILITY_ID='"+facility_id+"' and language_id='"+locale+"'";
	pstmt_rec_chargeyn=con.prepareStatement(sql_rec_chargeyn);
	rst_rec_chargeyn=pstmt_rec_chargeyn.executeQuery();
		if(rst_rec_chargeyn !=null && rst_rec_chargeyn.next())
		{
			rec_chargeable_yn=rst_rec_chargeyn.getString(1);
		}
	if(("").equals(recovery_start_time) || ("").equals(recovery_end_time)) disable_rec="disabled";

    String SQL_HA_ROOM="SELECT HOLDING_AREA_CODE,TO_CHAR(CHECKED_IN_DATE_TIME,'DD/MM/YYYY HH24:MI') CHECKED_IN_DATE_TIME,TO_CHAR(CHECKED_OUT_DATE_TIME,'DD/MM/YYYY HH24:MI') CHECKED_OUT_DATE_TIME,TO_CHAR(CHECKED_IN_DATE_TIME,'MM/DD/YYYY HH24:MI') CHECKED_IN_DATE_TIME1,TO_CHAR(CHECKED_OUT_DATE_TIME,'MM/DD/YYYY HH24:MI') CHECKED_OUT_DATE_TIME1, CALC_CHARGEABLE_UNITS,CHARGEABLE_UNITS, BL_ACCESSION_NUM, HOLDING_SEQ_NUM FROM OT_OPER_HOLDING_DTLS WHERE  OPERATING_FACILITY_ID   ='"+facility_id+"' AND OPER_NUM='"+oper_num+"' AND HOLDING_AREA_CODE IN (SELECT HOLDING_AREA_CODE FROM OT_HOLDING_AREAS WHERE OPERATING_FACILITY_ID ='"+facility_id+"'AND NVL(CHARGEABLE_YN,'N') ='Y')	ORDER BY HOLDING_SEQ_NUM";
    pstmt_ha_room=con.prepareStatement(SQL_HA_ROOM,ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
	rst_ha_room = pstmt_ha_room.executeQuery();
	int total=0;
	while(rst_ha_room.next()){
			total++;
	}
	maxRecord = total;
	if(maxRecord==0)disable_ha="disabled";
	rst_ha_room.beforeFirst();
   
	String sql_or_chargeableyn="SELECT NVL(CHARGEABLE_YN,'N') FROM OT_OPER_ROOM_LANG_VW WHERE OPER_ROOM_CODE ='"+oper_room_code_or+"' AND OPERATING_FACILITY_ID='"+facility_id+"' and language_id='"+locale+"'";

    pstmt_or_chargeableyn=con.prepareStatement(sql_or_chargeableyn);
	rst_or_chargeyn=pstmt_or_chargeableyn.executeQuery();
	if(rst_or_chargeyn !=null && rst_or_chargeyn.next())
	{
	  or_chargeable_yn=rst_or_chargeyn.getString(1);
	}

    if(("").equals(check_into_or_time) || ("").equals(check_out_or_time)) disable_or="disabled";
	
	//below query checks whether we have already record in OT_PICK_LISTS Table if returns true="PICK_LIST_DEFINED Qry is executed "
	String PICK_LIST_EXIST_YN = "SELECT OPER_CODE FROM OT_PICK_LISTS WHERE OPERATING_FACILITY_ID='"+facility_id+"' AND (BOOKING_NUM='"+booking_num+"' OR OPER_NUM='"+oper_num+"') AND ROWNUM=1";
    PreparedStatement pstmt_pl = null;
	ResultSet rst_pl = null;
	String rst_acc_code = "";
	String rst_tr_no = "";
	int index=0;
	  /* just Checking pick list exist or not particular accessory_type as told by Dilip on 24-06-2009*/
		pstmt_pl = con.prepareStatement(PICK_LIST_EXIST_YN);
		rst_pl = pstmt_pl.executeQuery();
		if(rst_pl.next()){
			pick_list=true;
		}
		if(rst_pl!=null)rst_pl.close();
		if(pstmt_pl!=null)pstmt_pl.close();
		int fetch_count = 0;
		while(rs.next()){
			oper_line_status = checkForNull(rs.getString("OPER_LINE_STATUS"));
			if(!("99").equals(oper_line_status))
			{
			++fetch_count;
			if(fetch_count==1)
			oper_codes.append("'"+rs.getString("OPR_CODE")+"'");
			else
			 oper_codes.append(","+"'"+rs.getString("OPR_CODE")+"'");
			 line_no_map.put(rs.getString("OPR_CODE"),rs.getString("LN_NUM"));
			}
		}
	    /* below query added by sathish as told by Dilip */
		if(("Y").equals(st_interface_flag))
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
           /* &&&&&&&&&&&&&&& Prothesis Impalnts Query &&&&&&&&&&&&&&&&*/
			if(("Y").equals(rec_implants_in_admin_notes_yn))
		    {
			String SQL_PI = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.ACCESSORY_CODE) ACC_DESC,GET_DESC('"+locale+"','MM_STORE_LANG_VW','SHORT_DESC','STORE_CODE',A.REQ_STORE_CODE) Store_desc, A.QUANTITY TR_NO, A.PROSTHESIS_MFR MFR,A.PROSTHESIS_BATCH_NO BTCH, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE,A.REQ_STORE_CODE, A.RESERVED_QTY, A.REQUESTED_QTY,A.SALE_DOCUMENT_TYPE SALE_DOCUMENT_TYPE ,A.SALE_DOCUMENT_NO SALE_DOCUMENT_NO,A.EXCL_INCL_IND, A.ACTION_REASON_CODE FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_PROSTHESIS_LANG_VW C WHERE A.OPERATING_FACILITY_ID='"+facility_id+"'AND A.OPER_NUM='"+oper_num+"' AND ACCESSORY_TYPE = 'S' AND  A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.PROSTHESIS_CODE AND C.LANGUAGE_ID='"+locale+"' ";//MMS-QH-CRF-0199

			pstmt_pi = con.prepareStatement(SQL_PI,ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			rst_pi = pstmt_pi.executeQuery();

            if(rst_pi.next()){
			exist_rec_pi=true;
		    }
		 if(exist_rec_pi==true){
            rst_pi.beforeFirst();
			while(rst_pi.next()){
				++index;	
			
			key_pi = checkForNull(rst_pi.getString("KEY"));
			key_line_pi = checkForNull(rst_pi.getString("KEY_LINE"));
			item_id=checkForNull(rst_pi.getString("ACC_CODE"));
			req_store_code=	checkForNull(rst_pi.getString("REQ_STORE_CODE"));
			sale_document_type=	checkForNull(rst_pi.getString("SALE_DOCUMENT_TYPE"));
			sale_document_no=	checkForNull(rst_pi.getString("SALE_DOCUMENT_NO"));
			String excl_incl_ind_st=	checkForNull(rst_pi.getString("EXCL_INCL_IND"));
			String action_reason_code_st=	checkForNull(rst_pi.getString("ACTION_REASON_CODE"));

            if(excl_incl_ind_st=="") excl_incl_ind_st=null;
            if(action_reason_code_st=="") action_reason_code_st=null;
			
			if(("true").equals(bill_flag))
			{
			bill_info_pi = or_bean.getOrderBillDtls(key_pi+key_line_pi);
		   if(!("").equals(item_id))
		    {
			try 
			{
			sql_mm_code="select MM_ITEM_CODE from OT_PROSTHESIS where PROSTHESIS_CODE='"+item_id+"'";
			pstmt_st=con.prepareStatement(sql_mm_code);
			rst_st=pstmt_st.executeQuery();
			if(rst_st !=null && rst_st.next())
			{
			mm_item_code=checkForNull(rst_st.getString(1));
			}
			String[] stParameters = {mm_item_code,req_store_code , "0", "N", "", "N", "" };
			HashMap hmStockAvailabilityStatus = st_bean.getStockAvailabilityStatus(stParameters);
			avail_stock = (String)hmStockAvailabilityStatus.get("available_stock");
			}catch(Exception e)
			{
			avail_stock="";
			e.printStackTrace();
			}
			}
			if(("N").equals(st_interface_flag))
			{
			if(bill_info_pi==null){
				bill_info_pi = new HashMap();
				bill_info_pi.put("key",key_pi);
				bill_info_pi.put("key_line_no",key_line_pi);
				rst_acc_code = rst_pi.getString("ACC_CODE");
				bill_info_pi.put("oper_code",rst_acc_code);//pass acc_code in oper_code
				bill_info_pi.put("acc_type","I");
				bill_info_pi.put("oper_num",oper_num);
				bill_info_pi.put("locale",locale);
				bill_info_pi.put("module_id","OT");
				rst_tr_no = rst_pi.getString("TR_NO");
				bill_info_pi.put("quantity",rst_tr_no);
				bill_info_pi.put("rate",rate);
				//populate billing details from OTBillingBean........	
				
				bill_info_pi = billing_bean.getBillingParamsForAdmin(bill_info_pi,"C",bill_info_reqd_dtls);//C-> for Surgical Accessories Billing

			   //set billing details from OTBillingBean........	

				or_bean.setOrderBillDtls(key_pi+key_line_pi,bill_info_pi);
				putObjectInBean(or_bean_id,or_bean,request);
				}
			panel_str = (String) bill_info_pi.get("bl_panel_str");	
			bl_bfr.append(checkForNull(""+bill_info_pi.get("total_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_pi.get("patient_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_pi.get("patient_paid_amt"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_pi.get("charged_yn"),"N")).append("::");
			bl_bfr.append(excl_incl_ind_st).append("::");
			bl_bfr.append(checkForNull(""+bill_info_pi.get("preapp_yn"),"N")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_pi.get("serv_panel_ind"),"S")).append("::");
			bl_bfr.append(action_reason_code_st).append("::");
			bl_bfr.append(checkForNull(""+bill_info_pi.get("incl_excl_ind"),"E"));
			bill_str = bl_bfr.toString();
			bl_bfr.setLength(0);
			}else
			{
		   if(!("").equals(req_store_code))
		   {//Maheshwaran K modified for  SKR-SCF-0788 [IN:039522] as on 24/09/2013
			statement=con.prepareCall("{ call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
		   String sal_trn_type="";
		   rst_tr_no = rst_pi.getString("TR_NO");
		   if(("IP").equals(patient_class))
			{
				sal_trn_type="I";
			}else if(("OP").equals(patient_class))
			{
			sal_trn_type="O";
			}else if(("EM").equals(patient_class))
			{
			sal_trn_type="E";
			}else if(("DC").equals(patient_class))
			{
			sal_trn_type="D";
			}else if(("XT").equals(patient_class))
			{
			sal_trn_type="R";
			}
			p_qty=rst_tr_no;
			
			statement.setString(1, facility_id);
			statement.setString(2, patient_id);
			statement.setString(3, "ST");
			statement.setString(4, encounter_id1);
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
			   
				if(excl_incl_ind_st=="") excl_incl_ind_st=null;
				if(action_reason_code_st=="") action_reason_code_st=null;
				
                String override_value=statement.getString(37);
				bl_bfr.append(checkForNull(""+statement.getString(21),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(25),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(38),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+st_charge_based_yn,"N")).append("::");
				bl_bfr.append(excl_incl_ind_st).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(36),"N")).append("::");
				bl_bfr.append(checkForNull(""+"S")).append("::");//Note: when ST is on serv_panel_ind value passing as "S" for showing excl_incl value always in the screen   but there is no concept of service or panel through St billing.
				bl_bfr.append(action_reason_code_st).append("::");
				bl_bfr.append(checkForNull(""+excl_incl_ind_st,"E")).append("::");// this value is for just front end screen purpose not inserting into databse.
				bl_bfr.append(override_value);
			
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0); 
					}
			}
			}
			 frm_pick_list="N";
			            //Added encode for REMKS on 10/18/2010 by AnithaJ
			out.println("<script>loadDBRows_pi('"+checkForNull(rst_pi.getString("OPR_CODE"))+"','"+encode(checkForNull(rst_pi.getString("OPR_DESC")))+"','"+checkForNull(rst_pi.getString("LN_NUM"))+"','"+checkForNull(rst_pi.getString("ACC_CODE"))+"','"+encode(checkForNull(rst_pi.getString("ACC_DESC")))+"','"+checkForNull(rst_pi.getString("TR_NO"))+"','"+checkForNull(rst_pi.getString("MFR"))+"','"+checkForNull(rst_pi.getString("BTCH"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_pi.getString("REMKS")),"UTF-8")+"','"+index+"','L','1','"+bill_str+"','"+panel_str+"','"+key_pi+"','"+key_line_pi+"','"+checkForNull(rst_pi.getString("REQ_STORE_CODE"))+"','"+checkForNull(rst_pi.getString("RESERVED_QTY"))+"','"+checkForNull(rst_pi.getString("REQUESTED_QTY"))+"','"+no_of_units+"','"+sale_document_no+"','"+sale_document_type+"','"+avail_stock+"','"+checkForNull(rst_pi.getString("Store_desc"))+"','"+frm_pick_list+"','"+booking_num+"'); </script>");	
		}
		if(rst_pi!=null)rst_pi.close();
		if(pstmt_pi!=null)pstmt_pi.close();
		out.println("<script>assignRecId_pi()</script>");
		}
	    else if(("").equals(implant_entry_cmp_yn))
	     { 
		  if(pick_list==true)
		  { 
			String PICK_LIST_DEFINED_PI="SELECT A.OPER_CODE OPR_CODE,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC,A.ITEM_ID ACC_CODE,GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.ITEM_ID) ACC_DESC,GET_DESC('"+locale+"','MM_STORE_LANG_VW','SHORT_DESC','STORE_CODE',A.REQ_STORE_CODE) Store_desc,NVL(A.NO_OF_UNITS,1) TR_NO,A.REQ_STORE_CODE, A.RESERVED_QTY RESERVED_QTY, A.REQUESTED_QTY REQUESTED_QTY,A.SALE_DOCUMENT_TYPE SALE_DOCUMENT_TYPE,A.SALE_DOCUMENT_NO SALE_DOCUMENT_NO,A.REQ_DOCUMENT_TYPE REQ_DOCUMENT_TYPE,A.REQ_DOCUMENT_NO REQ_DOCUMENT_NO,NVL(A.NO_OF_UNITS,1) NO_OF_UNITS FROM  OT_PICK_LISTS A, OT_PROSTHESIS_LANG_VW B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'S' AND A.ITEM_ID = B.PROSTHESIS_CODE AND B.LANGUAGE_ID='"+locale+"'"; //MMS-QH-CRF-0199

			pstmt_pi = con.prepareStatement(PICK_LIST_DEFINED_PI);
			pstmt_pi.setString(1,facility_id);
			pstmt_pi.setString(2,patient_id);
			pstmt_pi.setString(3,booking_num);
			pstmt_pi.setString(4,oper_num);
			rst_pi = pstmt_pi.executeQuery();
		   while(rst_pi.next()){
			++index;	
			line_no = (String)line_no_map.get(rst_pi.getString("OPR_CODE"));
		    if(("true").equals(bill_flag))
			{
			item_id=checkForNull(rst_pi.getString("ACC_CODE"));
			req_store=checkForNull(rst_pi.getString("REQ_STORE_CODE"));
			sale_document_no=checkForNull(rst_pi.getString("SALE_DOCUMENT_NO"));
			sale_document_type=checkForNull(rst_pi.getString("SALE_DOCUMENT_TYPE"));
			no_of_units=checkForNull(rst_pi.getString("NO_OF_UNITS"));
		   if(!item_id.equals(""))
		  {
            try 
			 {
				sql_mm_code="select MM_ITEM_CODE from OT_PROSTHESIS where PROSTHESIS_CODE='"+item_id+"'";
				pstmt_st=con.prepareStatement(sql_mm_code);
				rst_st=pstmt_st.executeQuery();
				if(rst_st !=null && rst_st.next())
				{
				mm_item_code=rst_st.getString(1);
				}
				
				String[] stParameters = {mm_item_code,req_store , "0", "N", "", "N", "" };
				HashMap hmStockAvailabilityStatus = st_bean.getStockAvailabilityStatus(stParameters);
				avail_stock = (String)hmStockAvailabilityStatus.get("available_stock");
			  }catch(Exception e)
				{
				avail_stock="";
				e.printStackTrace();
				}
              }
			    if(("N").equals(st_interface_flag))
				{
				HashMap hash = billing_bean.getORBillingParamsForAdmin(oper_num,bill_info_reqd_dtls);
				catalog_code = "I#"+rst_pi.getString("ACC_CODE");
				key_pi = oper_num+"@"+rst_pi.getString("OPR_CODE")+"@S@"+rst_pi.getString("ACC_CODE");
				key_line_pi="";
				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				p_qty = rst_pi.getString("TR_NO");
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info_pi			 = billing_bean.formatBillingDetails(bill_dtls);
				bill_info_pi.putAll(hash);
				bill_info_pi.put("quantity",p_qty);
				//set billing details from OTBillingBean........	
				or_bean.setOrderBillDtls(key_pi,bill_info_pi);
				putObjectInBean(or_bean_id,or_bean,request);

				panel_str = (String) bill_info_pi.get("bl_panel_str");	
				String overridden_action_reason_code=null;
				String overridden_incl_excl_ind=null;
				bl_bfr.append(checkForNull(""+bill_info_pi.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_pi.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_pi.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_pi.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info_pi.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_pi.get("serv_panel_ind"),"S")).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info_pi.get("incl_excl_ind"),"E"));
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
			  }else
			 {
			  if(!("").equals(req_store))
			  {//Maheshwaran K modified for  SKR-SCF-0788 [IN:039522] as on 24/09/2013
			  statement=con.prepareCall("{ call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			 String sal_trn_type="";
			 p_qty = rst_pi.getString("TR_NO");
		     if(("IP").equals(patient_class))
			 {
				sal_trn_type="I";
			 }else if(("OP").equals(patient_class))
			 {
			 sal_trn_type="O";
			 }else if(("EM").equals(patient_class))
			 {
			 sal_trn_type="E";
			 }else if(("DC").equals(patient_class))
			 {
			 sal_trn_type="D";
			 }else if(("XT").equals(patient_class))
			 {
			 sal_trn_type="R";
			 }
			 
			 statement.setString(1, facility_id);
			 statement.setString(2, patient_id);
			 statement.setString(3, "ST");
			 statement.setString(4, encounter_id1);
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
			
                String overridden_action_reason_code=null;
			    String incl_excl=null;
			    incl_excl=statement.getString(35);
                String override_value=statement.getString(37);
				bl_bfr.append(checkForNull(""+statement.getString(21),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(25),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(38),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+st_charge_based_yn,"N")).append("::");
				bl_bfr.append(incl_excl).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(36),"N")).append("::");
				bl_bfr.append(checkForNull(""+"S")).append("::");//Note: when ST is on serv_panel_ind value passing as "S" for showing excl_incl value always in the screen   but there is no concept of service or panel through St billing.
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+incl_excl,"E")).append("::");// this value is for just front end screen purpose not inserting into databse.
				bl_bfr.append(override_value);
			
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0); 
			 }
			}
			}//end of if bill_flag

		    frm_pick_list="Y";
			out.println("<script>loadDBRows_pi('"+checkForNull(rst_pi.getString("OPR_CODE"))+"','"+encode(checkForNull(rst_pi.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst_pi.getString("ACC_CODE"))+"','"+encode(checkForNull(rst_pi.getString("ACC_DESC")))+"','"+checkForNull(rst_pi.getString("TR_NO"))+"','','','','"+index+"','L','2','"+bill_str+"','"+panel_str+"','"+key_pi+"','"+key_line_pi+"','"+checkForNull(rst_pi.getString("REQ_STORE_CODE"))+"','"+checkForNull(rst_pi.getString("RESERVED_QTY"))+"','"+checkForNull(rst_pi.getString("REQUESTED_QTY"))+"','"+no_of_units+"','"+sale_document_no+"','"+sale_document_type+"','"+avail_stock+"','"+checkForNull(rst_pi.getString("Store_desc"))+"','"+frm_pick_list+"','"+booking_num+"'); </script>");	
			}//end of while loop
			if(rst_pi!=null)rst_pi.close();
			if(pstmt_pi!=null)pstmt_pi.close();
			
			out.println("<script>assignRecId_pi()</script>");
			 }else{
				 if(rst_pi!=null)rst_pi.close();
				 if(pstmt_pi!=null)pstmt_pi.close();
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
					String PICK_LIST_UNDEFINED_PI="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.PROSTHESIS_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.PROSTHESIS_CODE) ACC_DESC,   NVL(A.NO_OF_UNITS,1) TR_NO FROM  OT_OPER_PROSTHESIS A, OT_PROSTHESIS B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'AOPR' AND A.PROSTHESIS_CODE = B.PROSTHESIS_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+")   UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.PROSTHESIS_CODE ACC_CODE, B.SHORT_DESC ACC_DESC,NVL(A.NO_OF_UNITS,1) TR_NO FROM OT_OPER_PROSTHESIS A, OT_PROSTHESIS B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+") AND A.PROSTHESIS_CODE = B.PROSTHESIS_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.PROSTHESIS_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.PROSTHESIS_CODE) ACC_DESC,  NVL(A.NO_OF_UNITS,1) TR_NO FROM OT_OPER_PROSTHESIS A, OT_PROSTHESIS B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SCAT' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE AND D.OPER_CODE  IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE AND A.PROSTHESIS_CODE  = B.PROSTHESIS_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.PROSTHESIS_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.PROSTHESIS_CODE) ACC_DESC, NVL(A.NO_OF_UNITS,1) TR_NO   FROM OT_OPER_PROSTHESIS A, OT_PROSTHESIS B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB'AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND  A.OPER_CAT_CODE = D.OPER_CAT_CODE AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE     AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE      AND A.PROSTHESIS_CODE = B.PROSTHESIS_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.PROSTHESIS_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.PROSTHESIS_CODE) ACC_DESC,  NVL(A.NO_OF_UNITS,1) TR_NO FROM OT_OPER_PROSTHESIS A, OT_PROSTHESIS B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SOPR' AND A.OPER_CODE IN ("+oper_codes.toString()+") AND A.OPER_CODE = C.OPER_CODE AND A.PROSTHESIS_CODE = B.PROSTHESIS_CODE";  //MMS-QH-CRF-0199
					
							pstmt_pi = con.prepareStatement(PICK_LIST_UNDEFINED_PI);
							rst_pi = pstmt_pi.executeQuery();
			     while(rst_pi.next()){
					++index;	
					
					line_no = (String)line_no_map.get(rst_pi.getString("OPR_CODE"));
					item_id=checkForNull(rst_pi.getString("ACC_CODE"));
				if(!("").equals(item_id))
				{
				try 
				{    
				 sql_mm_code="select MM_ITEM_CODE from OT_PROSTHESIS where PROSTHESIS_CODE='"+item_id+"'";
				 pstmt_st=con.prepareStatement(sql_mm_code);
				 rst_st=pstmt_st.executeQuery();
				 if(rst_st !=null && rst_st.next())
				 {
				 mm_item_code=checkForNull(rst_st.getString(1));
				 }
				 String[] stParameters = {mm_item_code,req_store_code , "0", "N", "", "N", "" };
				 HashMap hmStockAvailabilityStatus = st_bean.getStockAvailabilityStatus(stParameters);
				 avail_stock = (String)hmStockAvailabilityStatus.get("available_stock");
				 }catch(Exception e)
				 {
				avail_stock="";
				e.printStackTrace();
				 }
				}

				if(("true").equals(bill_flag))
			    {
				if(("N").equals(st_interface_flag))
				{
				HashMap hash = billing_bean.getORBillingParamsForAdmin(oper_num,bill_info_reqd_dtls);
				catalog_code = "I#"+rst_pi.getString("ACC_CODE");
				key = oper_num+"@"+rst_pi.getString("OPR_CODE")+"@S@"+rst_pi.getString("ACC_CODE");
				key_line="";
				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				p_qty		= rst_pi.getString("TR_NO");
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info			 = billing_bean.formatBillingDetails(bill_dtls);
					hash.put("key",key);
					hash.put("key_line_no",key_line);
					hash.put("oper_code",rst_pi.getString("ACC_CODE"));//pass acc_code in oper_code
					hash.put("acc_type","I");
					hash.put("oper_num",oper_num);
					hash.put("locale",locale);
					hash.put("quantity",rst_pi.getString("TR_NO"));

				bill_info.putAll(hash);
				bill_info.put("quantity",p_qty);
				//set billing details from OTBillingBean........	
				or_bean.setOrderBillDtls(key,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);

				panel_str = (String) bill_info.get("bl_panel_str");	
				String overridden_action_reason_code=null;
				String overridden_incl_excl_ind=null;
				bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
			    bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"),"S")).append("::");
			    bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E"));
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
		     }else{
		     if(!("").equals(req_store_code))
		     {
			 //Maheshwaran K modified for  SKR-SCF-0788 [IN:039522] as on 24/09/2013
			 statement=con.prepareCall("{ call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
		     String sal_trn_type="";
		     p_qty		= rst_pi.getString("TR_NO");
		     if(("IP").equals(patient_class))
			 {
			 sal_trn_type="I";
			 }else if(("OP").equals(patient_class))
			 {
			 sal_trn_type="O";
			 }else if(("EM").equals(patient_class))
			 {
			 sal_trn_type="E";
			 }else if(("DC").equals(patient_class))
			 {
			 sal_trn_type="D";
			 }else if(("XT").equals(patient_class))
			 {
			 sal_trn_type="R";
			 }
			int p_qty1=Integer.parseInt(p_qty);
			statement.setString(1, facility_id);
			statement.setString(2, patient_id);
			statement.setString(3, "ST");
			statement.setString(4, encounter_id1);
			statement.setString(5, sal_trn_type);
			statement.setString(6, com.ehis.util.DateUtils.getCurrentDate("DMY","en"));
			statement.setString(7, mm_item_code);
			statement.setString(8, req_store);
			statement.setInt(9, p_qty1);
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
			
                String overridden_action_reason_code=null;
			    String incl_excl=null;
                incl_excl=statement.getString(35);
                String override_value=statement.getString(37);
				
				bl_bfr.append(checkForNull(""+statement.getString(21),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(25),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(38),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+st_charge_based_yn,"N")).append("::");
				bl_bfr.append(incl_excl).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(36),"N")).append("::");
				bl_bfr.append(checkForNull(""+"S")).append("::");//Note: when ST is on serv_panel_ind value passing as "S" for showing excl_incl value always in the screen   but there is no concept of service or panel through St billing.
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+incl_excl,"E")).append("::");//this value is just for showing front end screen only, its ot for inserting into database.
				bl_bfr.append(override_value);

				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0); 
				}	
				}
				}
             if(pstmt_st!=null)pstmt_st.close();
			 if(rst_st!=null)rst_st.close();

			frm_pick_list="N";
			out.println("<script>loadDBRows_pi('"+checkForNull(rst_pi.getString("OPR_CODE"))+"','"+checkForNull(rst_pi.getString("OPR_DESC"))+"','"+line_no+"','"+checkForNull(rst_pi.getString("ACC_CODE"))+"','"+checkForNull(rst_pi.getString("ACC_DESC"))+"','"+checkForNull(rst_pi.getString("TR_NO"))+"','','','','"+index+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','"+req_store_code+"','','','','','','"+avail_stock+"','"+Store_desc+"','"+frm_pick_list+"','"+booking_num+"'); </script>");	


		}//end of while loop
		  if(pstmt_st!=null)pstmt_st.close();
		  if(rst_st!=null)rst_st.close();
		  if(rst_pi!=null)rst_pi.close();
		  if(pstmt_pi!=null)pstmt_pi.close();
		   out.println("<script>assignRecId_pi()</script>");
			 }
			}
		} else{
            out.println("<script>assignRecId_pi()</script>");
		}

	/* ################### Consumable Packs  Starts Here ################# */
        if(("Y").equals(rec_packs_in_admin_notes_yn))
	    {
		String SQL_CONS = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',C.PACKAGE_CODE) ACC_DESC, A.QUANTITY TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE,A.REQ_STORE_CODE, A.RESERVED_QTY, A.REQUESTED_QTY FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_PACKAGE_HDR_LANG_VW C WHERE A.OPERATING_FACILITY_ID='"+facility_id+"' AND A.OPER_NUM='"+oper_num+"' AND ACCESSORY_TYPE = 'P' AND  A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.PACKAGE_CODE AND C.LANGUAGE_ID='"+locale+"' ORDER BY BILL_SUB_REGN_LINE_NUM"; //MMS-QH-CRF-0199

			pstmt_cons = con.prepareStatement(SQL_CONS,ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			rst_cons = pstmt_cons.executeQuery();
            if(rst_cons.next()){
			exist_rec_cons=true;
		    }
        if(exist_rec_cons==true)
	      {
			rst_cons.beforeFirst();
			while(rst_cons.next()){
			   ++index;	
			key_cons = rst_cons.getString("KEY");
			key_line_cons = rst_cons.getString("KEY_LINE");
			if(("true").equals(bill_flag))
			{
			bill_info_cons = or_bean.getOrderBillDtls(key_cons+key_line_cons);
			if(bill_info_cons==null){
				bill_info_cons = new HashMap();
				bill_info_cons.put("key",key_cons);
				bill_info_cons.put("key_line_no",key_line_cons);
				rst_acc_code = rst_cons.getString("ACC_CODE");
				bill_info_cons.put("oper_code",rst_acc_code);//pass acc_code in oper_code
				bill_info_cons.put("acc_type","C");
				bill_info_cons.put("oper_num",oper_num);
				bill_info_cons.put("locale",locale);
				bill_info_cons.put("module_id","OT");
				//populate billing details from OTBillingBean........	
				rst_tr_no = rst_cons.getString("TR_NO");
				bill_info_cons.put("quantity",rst_tr_no);
				bill_info_cons = billing_bean.getBillingParamsForAdmin(bill_info_cons,"C",bill_info_reqd_dtls);//C-> for Surgical Accessories Billing
				or_bean.setOrderBillDtls(key_cons+key_line_cons,bill_info_cons);
				putObjectInBean(or_bean_id,or_bean,request);
			}
			panel_str = (String) bill_info_cons.get("bl_panel_str");
			String overridden_action_reason_code=null;
			String overridden_incl_excl_ind=null;
			bl_bfr.append(checkForNull(""+bill_info_cons.get("total_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_cons.get("patient_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_cons.get("patient_paid_amt"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_cons.get("charged_yn"),"N")).append("::");
			bl_bfr.append(overridden_incl_excl_ind).append("::");
			bl_bfr.append(checkForNull(""+bill_info_cons.get("preapp_yn"),"N")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_cons.get("serv_panel_ind"),"S")).append("::");
			bl_bfr.append(overridden_action_reason_code).append("::");
			bl_bfr.append(checkForNull(""+bill_info_cons.get("incl_excl_ind"),"E"));
			bill_str = bl_bfr.toString();
			bl_bfr.setLength(0); 
			}//end of if bill_flag
			out.println("<script>loadDBRows_cons('"+checkForNull(rst_cons.getString("OPR_CODE"))+"','"+encode(checkForNull(rst_cons.getString("OPR_DESC")))+"','"+checkForNull(rst_cons.getString("LN_NUM"))+"','"+checkForNull(rst_cons.getString("ACC_CODE"))+"','"+encode(checkForNull(rst_cons.getString("ACC_DESC")))+"','"+checkForNull(rst_cons.getString("TR_NO"))+"',\""+java.net.URLEncoder.encode(checkForNull(rst_cons.getString("REMKS")),"UTF-8")+"\",'"+index+"','L','1','"+bill_str+"','"+panel_str+"','"+key_cons+"','"+key_line_cons+"');</script>");	

		}
		out.println("<script>assignRecId_cons()</script>");
		}
	  else if(("").equals(consumable_entry_cmp_yn)) {
		     if(pstmt_cons!=null)	pstmt_cons.close();
		     if(rst_cons!=null)      rst_cons.close();
			if(pick_list==true){
			    String PICK_LIST_DEFINED_CONS="SELECT A.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.ITEM_ID ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,NVL(A.NO_OF_UNITS,1) TR_NO,A.REQ_STORE_CODE, A.RESERVED_QTY, A.REQUESTED_QTY FROM  OT_PICK_LISTS A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'P' AND A.ITEM_ID = B.PACKAGE_CODE";//MMS-QH-CRF-0199

				pstmt_cons = con.prepareStatement(PICK_LIST_DEFINED_CONS);
				pstmt_cons.setString(1,facility_id);
				pstmt_cons.setString(2,patient_id);
				pstmt_cons.setString(3,booking_num);
				pstmt_cons.setString(4,oper_num);
		
				rst_cons = pstmt_cons.executeQuery();
				while(rst_cons.next()){
					++index;	
					line_no = (String)line_no_map.get(rst_cons.getString("OPR_CODE"));
                if(("true").equals(bill_flag))
			    {
				HashMap hash = billing_bean.getORBillingParamsForAdmin(oper_num,bill_info_reqd_dtls);
				catalog_code = "C#"+rst_cons.getString("ACC_CODE");
				key_cons = oper_num+"@"+rst_cons.getString("OPR_CODE")+"@S@"+rst_cons.getString("ACC_CODE");
				key_line_cons="";
				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				p_qty		= rst_cons.getString("TR_NO");
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info_cons			 = billing_bean.formatBillingDetails(bill_dtls);
				bill_info_cons.putAll(hash);
				bill_info_cons.put("quantity",p_qty);
				//set billing details from OTBillingBean........	
				or_bean.setOrderBillDtls(key_cons,bill_info_cons);
				putObjectInBean(or_bean_id,or_bean,request);

				panel_str = (String) bill_info_cons.get("bl_panel_str");	
				String overridden_action_reason_code=null;
				String overridden_incl_excl_ind=null;
				bl_bfr.append(checkForNull(""+bill_info_cons.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_cons.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_cons.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_cons.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info_cons.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_cons.get("serv_panel_ind"),"S")).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info_cons.get("incl_excl_ind"),"E"));
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end of if bill_flag
		       /*oper_code,oper_desc,line_no,package_code,package_desc,quantity,remarks,index,mode,order	*/	  out.println("<script>loadDBRows_cons('"+checkForNull(rst_cons.getString("OPR_CODE"))+"','"+encode(checkForNull(rst_cons.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst_cons.getString("ACC_CODE"))+"','"+encode(checkForNull(rst_cons.getString("ACC_DESC")))+"','"+checkForNull(rst_cons.getString("TR_NO"))+"','','"+index+"','L','2','"+bill_str+"','"+panel_str+"','"+key_cons+"','"+key_line_cons+"'); </script>");	
			}//end of while loop
			if(pstmt_cons!=null)    pstmt_cons.close();
			if(rst_cons!=null)      rst_cons.close();
			out.println("<script>assignRecId_cons()</script>");
			}else {
				String PICK_LIST_UNDEFINED_CONS="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE,   GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO FROM    OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'AOPR' AND A.PACKAGE_CODE     = B.PACKAGE_CODE  AND C.OPER_CODE IN ("+oper_codes.toString()+") UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO FROM    OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SSPL'AND A.SPECIALITY_CODE = C.SPECIALITY_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+") AND A.PACKAGE_CODE     = B.PACKAGE_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO  FROM OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SCAT' AND A.SPECIALITY_CODE   = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE    = D.OPER_CAT_CODE    AND D.OPER_CODE  IN ("+oper_codes.toString()+") AND C.OPER_CODE  = D.OPER_CODE     AND A.PACKAGE_CODE     = B.PACKAGE_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO  FROM OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND A.OPER_SUB_CAT_CODE  = D.OPER_SUB_CAT_CODE  AND D.OPER_CODE IN ("+oper_codes.toString()+")  AND C.OPER_CODE = D.OPER_CODE AND A.PACKAGE_CODE     = B.PACKAGE_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO FROM    OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SOPR' AND A.OPER_CODE IN ("+oper_codes.toString()+") AND A.OPER_CODE  = C.OPER_CODE  AND A.PACKAGE_CODE = B.PACKAGE_CODE";//MMS-QH-CRF-0199
			pstmt_cons = con.prepareStatement(PICK_LIST_UNDEFINED_CONS);
		
			rst_cons = pstmt_cons.executeQuery();
			while(rst_cons.next()){
				++index;	
				line_no = (String)line_no_map.get(rst_cons.getString("OPR_CODE"));
				HashMap hash = billing_bean.getORBillingParamsForAdmin(oper_num,bill_info_reqd_dtls);
				catalog_code = "C#"+rst_cons.getString("ACC_CODE");
				key = oper_num+"@"+rst_cons.getString("OPR_CODE")+"@S@"+rst_cons.getString("ACC_CODE");
				key_line="";
				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				p_qty		= rst_cons.getString("TR_NO");
				if(("true").equals(bill_flag))
			    {
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info			 = billing_bean.formatBillingDetails(bill_dtls);
					hash.put("key",key);
					hash.put("key_line_no",key_line);
					hash.put("oper_code",rst_cons.getString("ACC_CODE"));//pass acc_code in oper_code
					hash.put("acc_type","C");
					hash.put("oper_num",oper_num);
					hash.put("locale",locale);
					hash.put("quantity",p_qty);
				bill_info.putAll(hash);
				bill_info.put("quantity",rst_cons.getString("TR_NO"));
				//set billing details from OTBillingBean........	
				or_bean.setOrderBillDtls(key,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);
				panel_str = (String) bill_info.get("bl_panel_str");	
				String overridden_action_reason_code=null;
				String overridden_incl_excl_ind=null;
				bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"),"S")).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E"));// just for front end screnn pupose only not inserting this value in to database.
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end of if bill_flag
			/*oper_code,oper_desc,line_no,package_code,package_desc,quantity,remarks,index,mode,order	*/
	out.println("<script>loadDBRows_cons('"+checkForNull(rst_cons.getString("OPR_CODE"))+"','"+encode(checkForNull(rst_cons.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst_cons.getString("ACC_CODE"))+"','"+encode(checkForNull(rst_cons.getString("ACC_DESC")) )+"','"+checkForNull(rst_cons.getString("TR_NO"))+"','','"+index+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"'); </script>");	
		}//end of while loop
		if(pstmt_cons!=null)			pstmt_cons.close();
		if(rst_cons!=null)           rst_cons.close();
		//out.println("<script>refresh()</script>");
		out.println("<script>assignRecId_cons()</script>");

			}
	   }
	  }else {
		   out.println("<script>assignRecId_cons()</script>");
	   }

		/* ############################ END of Consumable Packs  ###################### */

		/* @@@@@@@@@@@@@@@@@@ Equipments  Starts Here @@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
        if(("Y").equals(rec_equp_in_admin_notes_yn))
	    {
		//SKR-SCF-0984 [IN:048580]
		String SQL_EQ = "SELECT a.oper_code opr_code, a.oper_line_num ln_num,get_desc ('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',a.oper_code) opr_desc,a.accessory_code acc_code,get_desc ('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',a.accessory_code) acc_desc,a.equipment_id euip_id, a.quantity tr_no, a.remarks remks,bill_sub_regn_num KEY, bill_sub_regn_line_num key_line, c.LOCATION,DECODE (?, 'en', NVL (TO_CHAR (desired_date, 'DD/MM/YYYY HH24:MI'),TO_CHAR (a.added_date, 'DD/MM/YYYY HH24:MI')), 'th', NVL (TO_CHAR (desired_date, 'DD/MM/YYYY HH24:MI','NLS_CALENDAR=''THAI BUDDHA'''),TO_CHAR (a.added_date, 'DD/MM/YYYY HH24:MI','NLS_CALENDAR=''THAI BUDDHA''')) ) desired_date,a.STATUS as OPER_LINE_STATUS FROM ot_surgical_accessories a, ot_oper_mast b, ot_equipment c WHERE a.operating_facility_id = '"+facility_id+"' AND a.oper_num = '"+oper_num+"' AND accessory_type = 'E' AND a.oper_code = b.oper_code AND a.accessory_code = c.equipment_code";//MMS-QH-CRF-0199
		pstmt_eq = con.prepareStatement(SQL_EQ,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);	
		pstmt_eq.setString(1,locale);
		rst_eq = pstmt_eq.executeQuery();
		if(rst_eq.next()){
			exist_rec_eq=true;
		}
		 if(exist_rec_eq==true)
	   	 {
			 rst_eq.beforeFirst();
			 while(rst_eq.next()){
		  	 ++index;	
			
			key_eq = rst_eq.getString("KEY");
			key_line_eq = rst_eq.getString("KEY_LINE");
			    //IN048103
			 st_location = checkForNull(rst_eq.getString("LOCATION"));
			 desiredDate = checkForNull(rst_eq.getString("desired_date"));
			if(("true").equals(bill_flag))// added this condition by sathish on 10-01-2009 to disabling billingpart 
			{
				bill_info_eq = or_bean.getOrderBillDtls(key_eq+key_line_eq);
				if(bill_info_eq==null){
					bill_info_eq = new HashMap();
					bill_info_eq.put("key",key_eq);
					bill_info_eq.put("key_line_no",key_line_eq);
					rst_acc_code = rst_eq.getString("ACC_CODE");
					String p_qty_eq= checkForNull(rst_eq.getString("TR_NO"));
					bill_info_eq.put("oper_code",rst_acc_code);//pass acc_code in oper_code
					bill_info_eq.put("acc_type","E");
					bill_info_eq.put("oper_num",oper_num);
					bill_info_eq.put("locale",locale);
					bill_info_eq.put("module_id","OT");
					bill_info_eq.put("quantity",p_qty_eq);
					//populate billing details from OTBillingBean........	
					bill_info_eq = billing_bean.getBillingParamsForAdmin(bill_info_eq,"C",bill_info_reqd_dtls);//C-> for Surgical Accessories Billing

					or_bean.setOrderBillDtls(key_eq+key_line_eq,bill_info_eq);
					putObjectInBean(or_bean_id,or_bean,request);
			}
				panel_str = (String) bill_info_eq.get("bl_panel_str");	
				String overridden_action_reason_code=null;
				String overridden_incl_excl_ind=null;

				bl_bfr.append(checkForNull(""+bill_info_eq.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("serv_panel_ind"),"S")).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("incl_excl_ind"),"E"));
				bill_str = bl_bfr.toString();

				bl_bfr.setLength(0);
			
			  }//end of if bill_flag
			out.println("<script>loadDBRows_eq('"+checkForNull(rst_eq.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_eq.getString("OPR_DESC")),"UTF-8")+"','"+checkForNull(rst_eq.getString("LN_NUM"))+"','"+checkForNull(rst_eq.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_eq.getString("ACC_DESC")),"UTF-8")+"','"+checkForNull(rst_eq.getString("EUIP_ID"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_eq.getString("REMKS")),"UTF-8")+"','"+checkForNull(rst_eq.getString("OPER_LINE_STATUS"))+"','"+index+"','L','1','"+bill_str+"','"+panel_str+"','"+key_eq+"','"+key_line_eq+"','"+checkForNull(rst_eq.getString("TR_NO"))+"','"+checkForNull(rst_eq.getString("LOCATION"))+"','"+desiredDate+"'); </script>"); 
			//Added(STATUS) for AMRI CRF 294
			
		  }
			if(rst_eq!=null)	 rst_eq.close();
			if(pstmt_eq !=null)  pstmt_eq.close();
			out.println("<script>assignRecId_eq()</script>");
		} 
		else if(equipment_entry_cmp_yn.equals("")||equipment_entry_cmp_yn.equals("N"))
		{ 
			 if(rst_eq!=null)	  rst_eq.close();
			 if(pstmt_eq !=null)  pstmt_eq.close();
             if(pick_list==true)
             {
			String PICK_LIST_DEFINED_EQ="SELECT A.OPER_CODE OPR_CODE,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC ,A.ITEM_ID ACC_CODE,GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.ITEM_ID)  ACC_DESC,NVL(A.NO_OF_UNITS,1) TR_NO FROM  OT_PICK_LISTS A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'E' AND A.ITEM_ID = B.EQUIPMENT_CODE";//MMS-QH-CRF-0199
			 pstmt_eq = con.prepareStatement(PICK_LIST_DEFINED_EQ);
			 pstmt_eq.setString(1,facility_id);
			 pstmt_eq.setString(2,patient_id);
			 pstmt_eq.setString(3,booking_num);
			 pstmt_eq.setString(4,oper_num);
			 rst_eq = pstmt_eq.executeQuery();
			 while(rst_eq.next()){
					++index;	
					line_no = (String)line_no_map.get(rst_eq.getString("OPR_CODE"));
				HashMap hash = billing_bean.getORBillingParamsForAdmin(oper_num,bill_info_reqd_dtls);
				catalog_code = "E#"+rst_eq.getString("ACC_CODE");
				key_eq = oper_num+"@"+rst_eq.getString("OPR_CODE")+"@S@"+rst_eq.getString("ACC_CODE");
				key_line_eq="";
				booking_date    = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id    = (String)hash.get("encounter_id");
				surgeon_code    = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id	    = (String)hash.get("visit_id");
				
				if(("true").equals(bill_flag))
			    {
             		       String p_qty_eq= checkForNull(rst_eq.getString("TR_NO"));
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty_eq,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info_eq			 = billing_bean.formatBillingDetails(bill_dtls);
				bill_info_eq.putAll(hash);
				
				bill_info_eq.put("quantity",p_qty_eq);
				//set billing details from OTBillingBean........	
				or_bean.setOrderBillDtls(key_eq,bill_info_eq);
				putObjectInBean(or_bean_id,or_bean,request);

				panel_str = (String) bill_info_eq.get("bl_panel_str");	
				String overridden_action_reason_code=null;
				String overridden_incl_excl_ind=null;
				bl_bfr.append(checkForNull(""+bill_info_eq.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("serv_panel_ind"),"S")).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("incl_excl_ind"),"E"));
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end of if bill_flag
				String equip_id="";//Added Against Common Equipment Issue
		         //IN048103
			 out.println("<script>loadDBRows_eq('"+checkForNull(rst_eq.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_eq.getString("OPR_DESC")),"UTF-8")+"','"+line_no+"','"+checkForNull(rst_eq.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_eq.getString("ACC_DESC")),"UTF-8")+"','"+equip_id+"','','"+index+"','L','2','"+bill_str+"','"+panel_str+"','"+key_eq+"','"+key_line_eq+"','"+checkForNull(rst_eq.getString("TR_NO"))+"','"+st_location+"','"+currentDateTime+"'); </script>");	//047546
			 }//end of while loop
			 if(rst_eq!=null)	  rst_eq.close();
		     if(pstmt_eq !=null)  pstmt_eq.close();
			out.println("<script>assignRecId_eq()</script>");
			 }
			 else
		    {    if(rst_eq!=null)	  rst_eq.close();
		         if(pstmt_eq !=null)  pstmt_eq.close();
				 String PICK_LIST_UNDEFINED_EQ="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE, GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC, NVL(A.NO_OF_UNITS,1) TR_NO,B.location LOCATION FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE  A.APPLICABILITY = 'AOPR' AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE   AND C.OPER_CODE IN ("+oper_codes.toString()+") UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC, NVL(A.NO_OF_UNITS,1) TR_NO,B.location LOCATION 	FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE   A.APPLICABILITY   = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN  ("+oper_codes.toString()+") AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION	SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,   NVL(A.NO_OF_UNITS,1) TR_NO,B.location LOCATION  FROM OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY  = 'SCAT' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE    = D.OPER_CAT_CODE AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE, GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,   NVL(A.NO_OF_UNITS,1) TR_NO,B.location LOCATION  FROM OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB'  AND A.SPECIALITY_CODE       = D.OPER_GROUP_CODE  AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE AND D.OPER_CODE  IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE  AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,  NVL(A.NO_OF_UNITS,1) TR_NO,B.location LOCATION FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY   = 'SOPR' AND A.OPER_CODE IN ("+oper_codes.toString()+") AND A.OPER_CODE  = C.OPER_CODE AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE";//MMS-QH-CRF-0199
				pstmt_eq = con.prepareStatement(PICK_LIST_UNDEFINED_EQ);
				rst_eq = pstmt_eq.executeQuery();
				while(rst_eq.next()){
					++index;	
					
					line_no = (String)line_no_map.get(rst_eq.getString("OPR_CODE"));
				
				HashMap hash = billing_bean.getORBillingParamsForAdmin(oper_num,bill_info_reqd_dtls);
				catalog_code = "E#"+rst_eq.getString("ACC_CODE");
				key = oper_num+"@"+rst_eq.getString("OPR_CODE")+"@S@"+rst_eq.getString("ACC_CODE");
				key_line="";
				booking_date	= (String)hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id	= (String)hash.get("encounter_id");
				surgeon_code	= (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id		= (String)hash.get("visit_id");
				    //IN048103
				 st_location= checkForNull(rst_eq.getString("LOCATION"));
					   if(("true").equals(bill_flag))
			    {
				String p_qty_eq= checkForNull(rst_eq.getString("TR_NO"));
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty_eq,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info_eq			 = billing_bean.formatBillingDetails(bill_dtls);
					hash.put("key",key);
					hash.put("key_line_no",key_line);
					hash.put("oper_code",rst_eq.getString("ACC_CODE"));//pass acc_code in oper_code
					hash.put("acc_type","E");
					hash.put("oper_num",oper_num);
					hash.put("locale",locale);
					hash.put("quantity",p_qty_eq);
				bill_info_eq.putAll(hash);
				
				bill_info_eq.put("quantity",p_qty_eq);
				//set billing details from OTBillingBean........	
				or_bean.setOrderBillDtls(key,bill_info_eq);
				putObjectInBean(or_bean_id,or_bean,request);

				panel_str = (String) bill_info_eq.get("bl_panel_str");	
				String overridden_action_reason_code=null;
				String overridden_incl_excl_ind=null;
				bl_bfr.append(checkForNull(""+bill_info_eq.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("serv_panel_ind"),"S")).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("incl_excl_ind"),"E"));
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end of if bill_flag
				String equip_id="";
				
		
		out.println("<script>loadDBRows_eq('"+checkForNull(rst_eq.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_eq.getString("OPR_DESC")),"UTF-8")+"','"+line_no+"','"+checkForNull(rst_eq.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_eq.getString("ACC_DESC")),"UTF-8")+"','"+equip_id+"','','"+index+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','"+checkForNull(rst_eq.getString("TR_NO"))+"','"+checkForNull(rst_eq.getString("LOCATION"))+"','"+currentDateTime+"'); </script>");	 //047546
			 }//end of while loop
			if(rst_eq!=null)		rst_eq.close();
		    if(pstmt_eq !=null)  pstmt_eq.close();
			
			out.println("<script>assignRecId_eq()</script>");
		    }
	   }
		}else{
		   out.println("<script>assignRecId_eq()</script>");
	   }
        /* @@@@@@@@@@@@@@@@@@ Equipments Ends Here @@@@@@@@@@@@@@@@@@@@*/
       
	   /* $$$$$$$$$$$$ Instrument/CSSD packs Code Starts Here$$$$$$$$$$$*/

		  if(("Y").equals(rec_instr_in_admin_notes_yn))
	        {
			  String SQL_IC="";
			  //Added by lakshmi agianst CRF-0058
			  if(Ot_param.equalsIgnoreCase("Y")){			
					SQL_IC = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE',A.ACCESSORY_CODE) ACC_DESC, A.TRAY_NO TRAY_NO,A.QUANTITY TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE, D.LOCATION LOCATION FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_INSTRUMENT_LANG_VW C, OT_INSTRUMENT D WHERE A.OPERATING_FACILITY_ID='"+facility_id+"' AND C.LANGUAGE_ID='"+locale+"' AND ACCESSORY_TYPE='I' AND A.OPER_NUM='"+oper_num+"' AND A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.INSTR_CODE AND A.ACCESSORY_CODE=D.INSTR_CODE";//MMS-QH-CRF-0199
			  }
			  else {
			       SQL_IC = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE',A.ACCESSORY_CODE) ACC_DESC, A.TRAY_NO TRAY_NO,A.QUANTITY TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE  FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_INSTRUMENT_LANG_VW C WHERE A.OPERATING_FACILITY_ID='"+facility_id+"' AND C.LANGUAGE_ID='"+locale+"' AND ACCESSORY_TYPE='I' AND A.OPER_NUM='"+oper_num+"' AND A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.INSTR_CODE "; //MMS-QH-CRF-0199
			  }

            pstmt_ic = con.prepareStatement(SQL_IC,ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			rst_ic = pstmt_ic.executeQuery();
            if(rst_ic.next()){
			exist_rec_ic=true;
		    }
           if(exist_rec_ic==true)
	       {
			rst_ic.beforeFirst();
			while(rst_ic.next()){
			   ++index;	
			key_ic = rst_ic.getString("KEY");
			key_line_ic = rst_ic.getString("KEY_LINE");
            if(("true").equals(bill_flag)) 
			{
			bill_info_ic = or_bean.getOrderBillDtls(key_ic+key_line_ic);

			if(bill_info_ic==null){
				bill_info_ic = new HashMap();
				bill_info_ic.put("key",key_ic);
				bill_info_ic.put("key_line_no",key_line_ic);
				rst_acc_code = rst_ic.getString("ACC_CODE");
				tr_no = checkForNull(rst_ic.getString("TR_NO"));
				bill_info_ic.put("oper_code",rst_acc_code);//pass acc_code in oper_code
				bill_info_ic.put("acc_type","S");
				bill_info_ic.put("oper_num",oper_num);
				bill_info_ic.put("locale",locale);
				bill_info_ic.put("module_id","OT");
				bill_info_ic.put("quantity",tr_no);
				//populate billing details from OTBillingBean........	
				bill_info_ic = billing_bean.getBillingParamsForAdmin(bill_info_ic,"C",bill_info_reqd_dtls);//C-> for Surgical Accessories Billing
				
				or_bean.setOrderBillDtls(key_ic+key_line_ic,bill_info_ic);
				putObjectInBean(or_bean_id,or_bean,request);
				}
			panel_str = (String) bill_info_ic.get("bl_panel_str");	
			String overridden_action_reason_code=null;
			String overridden_incl_excl_ind=null;
			bl_bfr.append(checkForNull(""+bill_info_ic.get("total_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_ic.get("patient_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_ic.get("patient_paid_amt"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_ic.get("charged_yn"),"N")).append("::");
			bl_bfr.append(overridden_incl_excl_ind).append("::");
			bl_bfr.append(checkForNull(""+bill_info_ic.get("preapp_yn"),"N")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_ic.get("serv_panel_ind"),"S")).append("::");
			bl_bfr.append(overridden_action_reason_code).append("::");
			bl_bfr.append(checkForNull(""+bill_info_ic.get("incl_excl_ind"),"E"));
			bill_str = bl_bfr.toString();
			bl_bfr.setLength(0);
		    }//end of if bill_flag
			 
			//Added by Rajesh for CRF-0058
		    if(Ot_param.equalsIgnoreCase("Y")){
			 	out.println("<script>loadDBRows_ic('"+checkForNull(rst_ic.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("OPR_DESC")))+"','"+checkForNull(rst_ic.getString("LN_NUM"))+"','"+checkForNull(rst_ic.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("ACC_DESC")))+"','"+checkForNull(rst_ic.getString("LOCATION"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("REMKS")),"UTF-8")+"','"+index+"','"+oper_num+"','L','1','"+bill_str+"','"+panel_str+"','"+key_ic+"','"+key_line_ic+"','"+checkForNull(rst_ic.getString("TR_NO"))+"');</script>");
		    }
		    else{
			 	out.println("<script>loadDBRows_ic('"+checkForNull(rst_ic.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("OPR_DESC")))+"','"+checkForNull(rst_ic.getString("LN_NUM"))+"','"+checkForNull(rst_ic.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("ACC_DESC")))+"','"+checkForNull(rst_ic.getString("TRAY_NO"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("REMKS")),"UTF-8")+"','"+index+"','"+oper_num+"','L','1','"+bill_str+"','"+panel_str+"','"+key_ic+"','"+key_line_ic+"','"+checkForNull(rst_ic.getString("TR_NO"))+"');</script>");
		    }
		  //Added by Rajesh for CRF-0058 
		  
			}
			if(rst_ic!=null)rst_ic.close();
			if(pstmt_ic!=null)pstmt_ic.close();
			out.println("<script>assignRecId_ic()</script>");
			}
		  else if(("").equals(instrument_entry_cmp_yn))
    	  {      
			    if(rst_ic!=null)		rst_ic.close();
		        if(pstmt_ic !=null)  pstmt_ic.close();

				if(pick_list==true){
				//Modified By Rajesh for CRF-0058
				 String PICK_LIST_DEFINED_IC = "" ;
				 if(Ot_param.equalsIgnoreCase("Y")){
					PICK_LIST_DEFINED_IC = "SELECT A.OPER_CODE OPR_CODE,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC ,A.ITEM_ID ACC_CODE,GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE',A.ITEM_ID) ACC_DESC,NVL(A.NO_OF_UNITS,1) TR_NO, B.location LOCATION FROM  OT_PICK_LISTS A, OT_INSTRUMENT_LANG_VW B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'I' AND A.ITEM_ID = B.INSTR_CODE AND B.LANGUAGE_ID='"+locale+"' ";//MMS-QH-CRF-0199
				 }
				 else{
					 PICK_LIST_DEFINED_IC = "SELECT A.OPER_CODE OPR_CODE,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC ,A.ITEM_ID ACC_CODE,GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE',A.ITEM_ID) ACC_DESC,NVL(A.NO_OF_UNITS,1) TR_NO FROM  OT_PICK_LISTS A, OT_INSTRUMENT_LANG_VW B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'I' AND A.ITEM_ID = B.INSTR_CODE AND B.LANGUAGE_ID='"+locale+"' ";//MMS-QH-CRF-0199
				 }
				//Modified By Rajesh for CRF-0058
			     pstmt_ic = con.prepareStatement(PICK_LIST_DEFINED_IC);
				 pstmt_ic.setString(1,facility_id);
				 pstmt_ic.setString(2,patient_id);
				 pstmt_ic.setString(3,booking_num);
				 pstmt_ic.setString(4,oper_num);
				 rst_ic = pstmt_ic.executeQuery();
				 while(rst_ic.next()){
					++index;	
					line_no = (String)line_no_map.get(rst_ic.getString("OPR_CODE"));
				
				if(("true").equals(bill_flag))
			    {
				HashMap hash = billing_bean.getORBillingParamsForAdmin(oper_num,bill_info_reqd_dtls);
				catalog_code = "S#"+rst_ic.getString("ACC_CODE");
				key_ic = oper_num+"@"+rst_ic.getString("OPR_CODE")+"@S@"+rst_ic.getString("ACC_CODE");
				key_line_ic="";
				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				String p_qty_ic= checkForNull(rst_ic.getString("TR_NO"));
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty_ic,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info_ic			 = billing_bean.formatBillingDetails(bill_dtls);
				bill_info_ic.putAll(hash);
				bill_info_ic.put("quantity",p_qty_ic);
				//set billing details from OTBillingBean........	
				or_bean.setOrderBillDtls(key_ic,bill_info_ic);
				putObjectInBean(or_bean_id,or_bean,request);

				panel_str = (String) bill_info_ic.get("bl_panel_str");	
				String overridden_action_reason_code=null;
				String overridden_incl_excl_ind=null;
				bl_bfr.append(checkForNull(""+bill_info_ic.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("serv_panel_ind"),"S")).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("incl_excl_ind"),"E"));
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end ofm if bill_flag
                String tray_no="";
				//Modified By Rajesh for CRF-0058
				if(Ot_param.equalsIgnoreCase("Y")){
					out.println("<script>loadDBRows_ic('"+checkForNull(rst_ic.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst_ic.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("ACC_DESC")))+"','"+checkForNull(rst_ic.getString("LOCATION"))+"','','"+index+"','"+oper_num+"','L','2','"+bill_str+"','"+panel_str+"','"+key_ic+"','"+key_line_ic+"','"+checkForNull(rst_ic.getString("TR_NO"))+"');</script>");	
				}
				else{
					out.println("<script>loadDBRows_ic('"+checkForNull(rst_ic.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst_ic.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("ACC_DESC")))+"','"+tray_no+"','','"+index+"','"+oper_num+"','L','2','"+bill_str+"','"+panel_str+"','"+key_ic+"','"+key_line_ic+"','"+checkForNull(rst_ic.getString("TR_NO"))+"');</script>");	
				}
				//Modified By Rajesh for CRF-0058	
			 }//end of while loop
			if(rst_ic!=null)		rst_ic.close();
		    if(pstmt_ic !=null)  pstmt_ic.close();
			out.println("<script>assignRecId_ic()</script>");
			}else
			 {
				//Modified By Rajesh for CRF-0058
				String PICK_LIST_UNDEFINED_IC = "";
				if(Ot_param.equalsIgnoreCase("Y")){
					PICK_LIST_UNDEFINED_IC="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE,GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   NVL(A.NO_OF_UNITS,1) TR_NO, b.location  LOCATION 	FROM   OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'AOPR' AND A.INSTR_CODE  = B.INSTR_CODE  AND C.OPER_CODE  IN ("+oper_codes.toString()+") UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   NVL(A.NO_OF_UNITS,1) TR_NO, b.location  LOCATION FROM    OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+")  AND A.INSTR_CODE = B.INSTR_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,NVL(A.NO_OF_UNITS,1) TR_NO, b.location  LOCATION FROM OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SCAT' AND A.SPECIALITY_CODE   = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE  = D.OPER_CODE  AND A.INSTR_CODE = B.INSTR_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   NVL(A.NO_OF_UNITS,1) TR_NO, b.location  LOCATION 	FROM OT_OPER_INSTRUMENT A, OT_INSTRUMENT  B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE AND A.INSTR_CODE = B.INSTR_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   NVL(A.NO_OF_UNITS,1) TR_NO, b.location  LOCATION FROM    OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SOPR'  AND A.OPER_CODE  IN ("+oper_codes.toString()+") AND A.OPER_CODE = C.OPER_CODE AND A.INSTR_CODE = B.INSTR_CODE";//MMS-QH-CRF-0199
				}
				else{
					PICK_LIST_UNDEFINED_IC="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE,GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   NVL(A.NO_OF_UNITS,1) TR_NO 	FROM   OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'AOPR' AND A.INSTR_CODE  = B.INSTR_CODE  AND C.OPER_CODE  IN ("+oper_codes.toString()+") UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   NVL(A.NO_OF_UNITS,1) TR_NO FROM    OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+")  AND A.INSTR_CODE = B.INSTR_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,NVL(A.NO_OF_UNITS,1) TR_NO FROM OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SCAT' AND A.SPECIALITY_CODE   = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE  = D.OPER_CODE  AND A.INSTR_CODE = B.INSTR_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   NVL(A.NO_OF_UNITS,1) TR_NO 	FROM OT_OPER_INSTRUMENT A, OT_INSTRUMENT  B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE AND A.INSTR_CODE = B.INSTR_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   NVL(A.NO_OF_UNITS,1) TR_NO FROM    OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SOPR'  AND A.OPER_CODE  IN ("+oper_codes.toString()+") AND A.OPER_CODE = C.OPER_CODE AND A.INSTR_CODE = B.INSTR_CODE";//MMS-QH-CRF-0199
				}
				//Modified By Rajesh for CRF-0058
				pstmt_ic = con.prepareStatement(PICK_LIST_UNDEFINED_IC);
				rst_ic = pstmt_ic.executeQuery();
				while(rst_ic.next()){
					++index;	
					line_no = (String)line_no_map.get(rst_ic.getString("OPR_CODE"));
				if(("true").equals(bill_flag))
			    {	
				bill_info = new HashMap();
				HashMap hash = billing_bean.getORBillingParamsForAdmin(oper_num,bill_info_reqd_dtls);
				catalog_code = "S#"+rst_ic.getString("ACC_CODE");
				key = oper_num+"@"+rst_ic.getString("OPR_CODE")+"@S@"+rst_ic.getString("ACC_CODE");
				key_line="";
				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				String p_qty_ic= checkForNull(rst_ic.getString("TR_NO"));
				ArrayList bill_dtls =or_bean.getBillChargeDetails(p_qty_ic,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info			 = billing_bean.formatBillingDetails(bill_dtls);
					hash.put("key",key);
					hash.put("key_line_no",key_line);
					hash.put("oper_code",rst_ic.getString("ACC_CODE"));//pass acc_code in oper_code
					hash.put("acc_type","C");
					hash.put("oper_num",oper_num);
					hash.put("locale",locale);
					hash.put("quantity",p_qty_ic);
				bill_info.putAll(hash);
				bill_info.put("quantity",checkForNull(rst_ic.getString("TR_NO")));
				//set billing details from OTBillingBean........	
				or_bean.setOrderBillDtls(key,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);

				panel_str = (String) bill_info.get("bl_panel_str");	
				String overridden_action_reason_code=null;
				String overridden_incl_excl_ind=null;
				bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"),"S")).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E"));
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end of if bill_flag	
				String tray_no="";
				//Modified By Rajesh for CRF-0058
				if(Ot_param.equalsIgnoreCase("Y")){
					out.println("<script>loadDBRows_ic('"+checkForNull(rst_ic.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst_ic.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("ACC_DESC")))+"','"+checkForNull(rst_ic.getString("LOCATION"))+"','','"+index+"','"+oper_num+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','"+checkForNull(rst_ic.getString("TR_NO"))+"'); </script>");	
				}
				else{
					out.println("<script>loadDBRows_ic('"+checkForNull(rst_ic.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst_ic.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("ACC_DESC")))+"','"+tray_no+"','','"+index+"','"+oper_num+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','"+checkForNull(rst_ic.getString("TR_NO"))+"'); </script>");	
				}
				//Modified By Rajesh for CRF-0058
			 }//end of while loop
			 if(rst_ic!=null)rst_ic.close();
			 if(pstmt_ic!=null)pstmt_ic.close();
			 out.println("<script>assignRecId_ic()</script>");
			 }
	     }
	  }else
	      {
		  out.println("<script>assignRecId_ic()</script>");
	      }
       /* $$$$$$$$$$$$$$$ Instrument/CSSD packs Code Ends Here$$$$$$$$$$$$$$$$$$$$*/
%>

	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onLoad="loadCodes();callChargeableUnits();callChargeableUnits_or();callChargeableUnits_ha('<%=maxRecord%>')">
		<form name="AdministrativeFunctionforAllChargesForm" id="AdministrativeFunctionforAllChargesForm">
			<table width="100%" border="0" cellspacing="0" cellpadding="1">
				<tr >
					<td valign="top">		

					<%  rs.beforeFirst();
						while (rs != null && rs.next())
						{
							oper_code = checkForNull(rs.getString("OPR_CODE"));
							Fpplist = billing_bean.getFPPDetails(oper_code);
							for (int j = 0; j < Fpplist.size(); j++){
							if(j==0) fpp_order_yn=checkForNull((String)Fpplist.get(j));
							if(j==1) fpp_def_category=checkForNull((String)Fpplist.get(j));
							}
							oper_line_num = checkForNull(rs.getString("LN_NUM"));
							description = checkForNull(rs.getString("OPR_DESC"));
							side_applicable = checkForNull(rs.getString("RIGHT_LEFT_FLAG"));
							oper_remarks =  checkForNull(rs.getString("OPER_REMARKS"));
							System.err.println("oper_remarks @@@"+oper_remarks);
                            oper_remarks=java.net.URLEncoder.encode(oper_remarks,"UTF-8");
							order_id = checkForNull(rs.getString("ORDER_ID"));
							order_line_no = checkForNull(rs.getString("ORDER_LINE_NUM"));
							cancel_remarks = checkForNull(rs.getString("CANCEL_REMARKS"));
							cancel_remarks=java.net.URLEncoder.encode(cancel_remarks,"UTF-8");
							oper_line_status = checkForNull(rs.getString("OPER_LINE_STATUS"));
							order_catalog=(rs.getString("ORDER_CATALOG_CODE"));
							//Added Against ML-MMS-QH-CRF-1939-US4...starts
							if(isIncludeFpp  && count==1 && Include_Fpp_yn.equals("Y") && ("true").equals(bill_flag)){
							fpp_category=checkForNull(rs.getString("FPP_CATEGORY"));
							}
							//Added Against ML-MMS-QH-CRF-1939-US4...ends
						    str_order_catalog_code=str_order_catalog_code+order_catalog+"|";
							if(rs_bl!=null) rs_bl.close();
	                        if(pstm_bl!=null) pstm_bl.close();
							pstm_bl = con.prepareStatement("select BILL_YN, BILLED_YN from   or_order_line where  order_id   = '"+order_id+"' and order_line_num  ='"+order_line_no+"'");
							rs_bl  = pstm_bl.executeQuery();
							while (rs_bl != null && rs_bl.next())
							{
								bill_yn=checkForNull(rs_bl.getString("BILL_YN"));
								billed_yn=checkForNull(rs_bl.getString("BILLED_YN"));
							}
							if(("").equals(side_applicable) || ("N").equals(side_applicable))
							{
								side_applicalbe_desc=notApplicable_title;
							}else if(("R").equals(side_applicable))
							{
								side_applicalbe_desc=rightSide_title;
							}
							else if(("L").equals(side_applicable))
							{
								side_applicalbe_desc=leftSide_title;
							}
							else if(("B").equals(side_applicable))
							{
								side_applicalbe_desc=bilateral;
							}
							posted_yn = billing_bean.billingPostedYN(oper_num,oper_line_num);
							bill_info = or_bean.getOrderBillDtls(order_id+order_line_no);	
							if((bill_info == null || bill_info.size() == 0) && !"".equals(called_from))
							{
							bill_info = new HashMap();
						/*	if("X".equals(posted_yn) && fpp_order_yn.equals("N"))
								{
							module_id = "OT";
							bill_info.put("module_id",module_id);
							bill_info.put("key",order_id);//changed insted of oper_num we used order_id
							bill_info.put("key_line_no",oper_line_num);
								}
								else*/ //Commented Against KDAH-SCF-0891
								 if("X".equals(posted_yn))
								{
							module_id = "OT";
							bill_info.put("module_id",module_id);
							bill_info.put("key",oper_num);//changed insted of oper_num we used order_id
							bill_info.put("key_line_no",oper_line_num);
								}
								else
								{
							module_id = "OR";
							bill_info.put("module_id",module_id);
							bill_info.put("key",order_id);
							bill_info.put("key_line_no",order_line_no);
							}
							bill_info.put("oper_code",oper_code);
							bill_info.put("oper_num",oper_num);
							bill_info.put("locale",locale);
							bill_info.put("quantity","1");
							bill_info.put("oper_line_status",oper_line_status);
							bill_info.put("called_from",called_from);
							bill_info.put("order_line_no", order_line_no);//50485
							//ML-MMOH-CRF-1939-US4
							//if(Include_Fpp_yn.equals("Y") && isIncludeFpp && count==1 && (bill_flag.equals("true"))){
							if(fpp_category.equals("S") || fpp_category.equals("M") || fpp_category.equals("C"))
									bill_info.put("fpp_category", fpp_category);
							else
									bill_info.put("fpp_category", fpp_def_category);
							//}
							//ML-MMOH-CRF-1939-US4
							bill_info = billing_bean.getBillingParamsForAdmin(bill_info,"S",bill_info_reqd_dtls);
							or_bean.setOrderBillDtls(order_id+order_line_no,bill_info);
							putObjectInBean(or_bean_id,or_bean,request);
							}
						    panel_str = (String) bill_info.get("bl_panel_str");
							String overridden_action_reason_code=null;
							String overridden_incl_excl_ind=null;
							bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
							bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
							bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
							bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
							bl_bfr.append(overridden_incl_excl_ind).append("::");
							bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
							bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"),"S")).append("::");
							bl_bfr.append(overridden_action_reason_code).append("::");
							bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E")).append("::");
							bl_bfr.append(checkForNull(posted_yn,"N")).append("::");
							bill_str = bl_bfr.toString();
                            bl_bfr.setLength(0);
                            arr = bill_str.split("::");
							
						
						out.println("<script>loadDBRows_op('"+oper_line_num+"','"+oper_code+"','"+encode(description) +"','"+side_applicable+"','"+oper_remarks+"','"+order_line_no+"','"+order_id+"','"+bill_str+"','"+panel_str+"','L','"+oper_line_status+"','"+cancel_remarks+"','"+bill_yn+"','"+billed_yn+"','"+fpp_category+"','"+Include_Fpp_yn+"','"+isIncludeFpp+"','"+count+"','"+bill_flag+"');</script>"); // Modified Against ML-MMS-QH-CRF-1939-US4
						
                       %>
					   
					   <%}%>
					   <jsp:include page="AdministrativeFunctionforAllChargesFrame1.jsp">
					   <jsp:param name="sStyle" value="<%=sStyle%>" />
					   <jsp:param name="flag_op" value="<%=flag_op%>" />
					   <jsp:param name="oper_finalization_stage" value="<%=oper_finalization_stage%>" />
					   <jsp:param name="proc_chrg_cmp_yn" value="<%=proc_chrg_cmp_yn%>"/>
					   <jsp:param name="operation_sub_services_yn" value="<%=operation_sub_services_yn%>"/>
					   <jsp:param name="flag_asc" value="<%=flag_asc%>"/>
					   <jsp:param name="flag_dc" value="<%=flag_dc%>"/>
					   <jsp:param name="rec_packs_in_admin_notes_yn" value="<%=rec_packs_in_admin_notes_yn%>"/>
					   <jsp:param name="consumable_entry_cmp_yn" value="<%=consumable_entry_cmp_yn%>"/>
					   <jsp:param name="rec_implants_in_admin_notes_yn" value="<%=rec_implants_in_admin_notes_yn%>"/>
					   <jsp:param name="rec_equp_in_admin_notes_yn" value="<%=rec_equp_in_admin_notes_yn%>"/>
					   <jsp:param name="rec_instr_in_admin_notes_yn" value="<%=rec_instr_in_admin_notes_yn%>"/>
					   <jsp:param name="flag_ac" value="<%=flag_ac%>"/>
					   </jsp:include>
						
                       
						<%  if(("Y").equals(rec_implants_in_admin_notes_yn))
			            {%>
						<tr>
						<div id="menuExpand2A" style='display:none;visibility:visible;overflow:auto;height:158px;width:100%'>
						<table id="AC_arrow" style='display:visible;overflow:auto;width:100%'>
						<tr>
						<td class="label" width='25%'>
								<fmt:message key="eOT.AccessoryType.Label" bundle="${ot_labels}"/> </td>
						<td class="fields" width='25%'>
						<select name="accesstype" id="accesstype"  <%=impl_disable_flag%> disabled>
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
							  <input type='text' name='implant_desc' id='implant_desc' onBlur="if(this.value!='')searchProsthesis(implant_code,implant_desc);"> 
							  <input type='button' class='button' value='?' name='ImplantLookUp' id='ImplantLookUp' onClick='searchProsthesis(implant_code,implant_desc);' <%=impl_disable_flag%> > <img src='../../eCommon/images/mandatory.gif'></img>
						  </td>
					 </tr>

						 <tr>
							 <td class="label" width='25%'>
									<fmt:message key="Common.operation.label" bundle="${common_labels}"/> </td>
							 <td class="fields" width='25%'>
									<select class="my_dropdown" id="menuPI" name="operation_pi" id="operation_pi"  <%=impl_disable_flag%> ><!--MMS-QH-CRF-0199-->
								<% 
						        rs.beforeFirst();
						        while(rs.next())
	                            {
								oper_line_status = checkForNull(rs.getString("OPER_LINE_STATUS"));
									if(!("99").equals(oper_line_status))
									{
									val = checkForNull(rs.getString("OPR_CODE"))+"##"+checkForNull(rs.getString("LN_NUM"));
									%>
									<option value='<%=val%>' title="<%=checkForNull(rs.getString("OPR_DESC"))%>"> <%=checkForNull(rs.getString("OPR_DESC"))%>  </option><!--MMS-QH-CRF-0199-->
									<%
									}
								}
								%>
									</select>
									 <img src='../../eCommon/images/mandatory.gif'></img>
							</td>
                            <%if(("Y").equals(st_interface_flag)){%>
							  <td class="label" width='25%'><fmt:message key="eOT.ConsumptionStore.Label" bundle="${ot_labels}"/></td>
							  <td class="fields" width='25%'><input type='text' name='conns_store_pi' id='conns_store_pi' onblur="if(this.value!='')searchStore(this,conns_store_pi,document.forms[0].operation);else{}"> 
							   <input type='hidden' name='reqstore_code' id='reqstore_code' value=''> 
								  <input type='button' class='button' value='?' name='Cons_store_LookUp' id='Cons_store_LookUp' onClick='searchStore(this,conns_store_pi);' <%=impl_disable_flag%> > <img src='../../eCommon/images/mandatory.gif'></img>
							  </td>	
							  <%}%>
								
						 </tr>
                        <%if(("N").equals(st_interface_flag)){%>
						<tr>

							 <td class="label" width='25%'><fmt:message key="Common.Manufacturer.label" bundle="${common_labels}"/> </td>
							 <td class="fields" width='25%'><input type='text' name='manufacturer' id='manufacturer' maxlength='30' size='20' <%=impl_disable_flag%> ></td>

							 <td class="label" width='25%'><fmt:message key="Common.Batch.label" bundle="${common_labels}"/> </td>
							 <td class="fields" width='25%'><input type='text' name='batch' id='batch' maxlength='30' size='20'  <%=impl_disable_flag%> ></td>

						</tr>
						<%}%>
						<%if(("Y").equals(st_interface_flag)){%>
						<tr>

							 <td class="label" width='25%'><fmt:message key="eOT.ReservedPicklistUnits.Label" bundle="${ot_labels}"/> </td>
							 <td class="fields" width='25%'><input type='text' name='Reservepicklist_pi' id='Reservepicklist_pi' maxlength='6' size='6' disabled <%=impl_disable_flag%> ></td>

							 <td class="label" width='25%'><fmt:message key="eOT.RequestedPicklistUnits.Label" bundle="${ot_labels}"/> </td>
							 <td class="fields" width='25%'><input type='text' name='Requestpicklist_pi' id='Requestpicklist_pi' maxlength='6' size='6'  disabled <%=impl_disable_flag%> ></td>

						</tr>
						<%}%>
						<tr>
							
							 <%if(("Y").equals(st_interface_flag)){%>
							 <input type='hidden' name='sale_document_no' id='sale_document_no' value=''>
                             <input type='hidden' name='sale_document_type' id='sale_document_type' value=''>
							 <td class="label" width='25%'><fmt:message key="eOT.StockAvailable.Label" bundle="${ot_labels}"/> </td>
							 <td class="fields" width='25%'><input type='text' name='Stockavail_pi' id='Stockavail_pi' maxlength='6' size='6'  <%=impl_disable_flag%> ></td>
							 <%}%>
							 <td class="label" width='25%'><fmt:message key="eOT.ActualUnits.Label" bundle="${ot_labels}"/></td>
							 <td class="fields" width='25%'><input type='text' name='quantity_pi' id='quantity_pi' maxlength='3' size='2' onBlur="ChkNumber(this);" <%=disable_flag%>><img src='../../eCommon/images/mandatory.gif'></img></td>

							 
						</tr>

							<td class="label" width="25%"></td>
							<td class="label" width="25%"></td>
							<td class="label" width='25%'>
							  <input type='hidden' name='remarks_pi' id='remarks_pi' value="">
			                 <a  class="gridLink" href="javascript:openRemarksWindow(document.forms[0].remarks_pi,'implants');">
				           <fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>
							<td width='20%' class="button">
								<input type='button' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='assignCodes_pi(document.forms[0].operation_pi);addRow_pi();' <%=impl_disable_flag%> >
								<input type='button' name="btn_cancel" id="btn_cancel" class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow();' <%=impl_disable_flag%> >
							</td>
						</tr>
						</table>
													
						</tr>
						</table>
						</div>
						</tr>   
						<%}%>
						<%  if(("Y").equals(rec_packs_in_admin_notes_yn))
	                     {%>
						<tr>
						<div id="menuExpand2B" style='display:none;visibility:visible;overflow:auto;height:158px;width:100%'>
						<br>
						<br>
						<table id="AC_arrow" style='display:visible;overflow:auto;width:100%'>

						<tr>

						<td class="label" width='25%'>
						<fmt:message key="eOT.AccessoryType.Label" bundle="${ot_labels}"/> </td>
						<td class="fields" width='25%'>
						<select name="accesstype" id="accesstype"  <%=cons_disable_flag%> disabled>
						<option value='PI' >
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
						<select class="my_dropdown" id="menuCP" name="operation_cons" id="operation_cons"  <%=cons_disable_flag%> ><!--MMS-QH-CRF-0199-->
						<% 
                                rs.beforeFirst();
						        while(rs.next())
	                            {
								//Added by DhanasekarV on 14/11/2011
								oper_line_status = checkForNull(rs.getString("OPER_LINE_STATUS"));
									if(!("99").equals(oper_line_status))
									{
								val = checkForNull(rs.getString("OPR_CODE"))+"##"+checkForNull(rs.getString("LN_NUM"));

								%>
								<option value='<%=val%>' title="<%=checkForNull(rs.getString("OPR_DESC"))%>"> <%=checkForNull(rs.getString("OPR_DESC"))%>  </option><!--MMS-QH-CRF-0199-->
								<%
									}	
								}%>
						</select>
						<img src='../../eCommon/images/mandatory.gif'></img>
						</td>
						</tr>
                        <tr>
						<td class="label" width="25%" ><fmt:message key="Common.Package.label" bundle="${common_labels}"/> </td>
						<td class="fields" width="25%">
						<input type='hidden' name='package_code' id='package_code' > 
						<input type='text' name='package_desc' id='package_desc' onBlur="if(this.value!='')searchPackage(package_code,package_desc);"> 
						<input type='button' class='button' value='?' name='PackageLookUp' id='PackageLookUp' onClick='searchPackage(package_code,package_desc);'<%=cons_disable_flag%> > <img src='../../eCommon/images/mandatory.gif'></img>
						</td>
						<td class="label" width='25%'><fmt:message key="eOT.ActualUnits.Label" bundle="${ot_labels}"/></td>
						<td class="fields" width='25%'><input type='text' name='quantity_cons' id='quantity_cons' maxlength='3' size='2' onBlur="ChkNumber(this);" <%=cons_disable_flag%>><img src='../../eCommon/images/mandatory.gif'></img></td>
						</tr>
						<tr>
						<td class="fields" width="25%"></td>
					    <td class="fields" width="25%"></td>
						<td class="label" width='25%'> <input type='hidden' name='remarks_cons' id='remarks_cons' value="">
			                 <a  class="gridLink" href="javascript:openRemarksWindow(document.forms[0].remarks_cons,'consumables');">
				            <fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>
						<td width='25%' class="button">
						<input type='button' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='assignCodes_cons(document.forms[0].operation_cons);addRow_cons();' <%=cons_disable_flag%> >
						<input type='button' name="btn_cancel" id="btn_cancel" class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow_cons();' <%=cons_disable_flag%> >
						</td>
						</tr>
						</table>
						</tr>
						</table>
						</div>
						</tr> 
                        <%}%>
						<%  if(("Y").equals(rec_equp_in_admin_notes_yn))
	                     {%>
                        <tr>
						<div id="menuExpand2C" style='display:none;visibility:visible;overflow:auto;height:158px;width:100%'>
							<table id="AC_arrow" style='display:visible;overflow:auto;width:100%'>
                            <br>
							<tr>
						<td class="label" width='25%'>
						<fmt:message key="eOT.AccessoryType.Label" bundle="${ot_labels}"/> </td>
						<td class="fields" width='25%'>
						<select name="accesstype" id="accesstype"  <%=cons_disable_flag%> disabled>
						<option value='PI' >
						<fmt:message key="eOT.ProsthesisImplants.Label" bundle="${ot_labels}"/>
						</option>
						<option value='CP'>
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
						<select class="my_dropdown" id="menuEq" name="operation_eq" id="operation_eq" <%=eq_disable_flag%> ><!--MMS-QH-CRF-0199-->
						<% 
		                rs.beforeFirst();
						while(rs.next())
						{
							//Added by DhanasekarV on 14/11/2011
						oper_line_status = checkForNull(rs.getString("OPER_LINE_STATUS"));
						if(!("99").equals(oper_line_status))
						{

						val = checkForNull(rs.getString("OPR_CODE"))+"##"+checkForNull(rs.getString("LN_NUM"));

						%>
						<option value='<%=val%>' title="<%=checkForNull(rs.getString("OPR_DESC"))%>"> <%=checkForNull(rs.getString("OPR_DESC"))%>  </option><!--MMS-QH-CRF-0199-->
						<%}
							}%>
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
						<input type='text' name='equip_desc' id='equip_desc' onBlur="if(this.value!='')searchEquipments(equip_code,equip_desc);"> 
						<input type='button' class='button' value='?' name='EquipmentLookUp' id='EquipmentLookUp' onClick='searchEquipments(equip_code,equip_desc);' <%=eq_disable_flag%> > <img src='../../eCommon/images/mandatory.gif'></img>
						</td>
<!--Added by MuthuN against RUT-CRF-0091 on 13-May-2013 starts here-->
<% if(customer_id1.equalsIgnoreCase("RTN")){%>
	<td class="label" width="25%" >
	<fmt:message key="Common.Location.label" bundle="${common_labels}"/> </td>
     <td width="25%" class="fields">
	  <input type='text' name='st_location' id='st_location' maxlength='20' size='20' <%=eq_disable_flag%>>
		<input type='hidden' name='equip_id' id='equip_id' value="">
	</td>
	<%}else{%>
		<td class="label" width="25%" ><fmt:message key="eOT.EquipmentID.Label" bundle="${ot_labels}"/>  </td>
		<td width="25%" class="fields">
		<input type='text' name='equip_id' id='equip_id' maxlength='20' size='20' <%=eq_disable_flag%> > 
		</td>
	<%}%>
<!--Added by MuthuN against RUT-CRF-0091 ends here-->		
					    </tr>
						<tr>
						 <td class="label" width='25%'><fmt:message key="eOT.ActualUnits.Label" bundle="${ot_labels}"/></td>
						<td class="fields" width='25%'><input type='text' name='quantity_eq' id='quantity_eq' maxlength='3' size='2' onBlur="ChkNumber(this);" onkeypress="return checkForSpecCharsforID(event);"  <%=eq_disable_flag%>><img src='../../eCommon/images/mandatory.gif'></img></td>
					    <td class="label" width='25%'>
						<input type='hidden' name='remarks_eq' id='remarks_eq' value="">
			            <a  class="gridLink" href="javascript:openRemarksWindow(document.forms[0].remarks_eq,'equipments');">
				        <fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>
						<td class="fields" width="25%">
						<input type='button' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='assignCodes_eq(document.forms[0].operation_eq);addRow_eq();'  <%=eq_disable_flag%>  >
						<input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow_eq();' <%=eq_disable_flag%> >
						</td>
						</tr>
							<tr>
								<td class='label' width='25%'><fmt:message key="eOT.DateTime.label" bundle="${ot_labels}"/></td><!-- 047546 -->
								<td class='fields' width='25%'>
									<input type="text" name="desiredDate" id="desiredDate" id="desiredDate" size="16" value="<%=currentDateTime%>" maxlength="16" onkeypress="return checkForSpecCharsforID(event);" onblur="if(this.value!=''){ validateDate(this.value); chkDateRangeValidity(this.value); }">
									<img src='../../eCommon/images/CommonCalendar.gif' onclick="return showCalWithTime('desiredDate','%d/%m/%Y %H:%M','24',true,'desiredDate');"><img src='../../eCommon/images/mandatory.gif'></img>
								</td>
							</tr>
						</tr>
							</table>
							</tr>
							</table>
							</div>
							</tr> 
                        <%}%>
						<% if(("Y").equals(rec_instr_in_admin_notes_yn)){%>
						<tr>
						<div id="menuExpand2D" style='display:none;visibility:visible;overflow:auto;height:158px;width:100%'>
						<table id="AC_arrow" style='display:visible;overflow:auto;width:100%'>
                        <br>
						<tr>
						<td class="label" width='25%'>
						<fmt:message key="eOT.AccessoryType.Label" bundle="${ot_labels}"/> </td>
						<td class="fields" width='25%'>
						<select name="accesstype" id="accesstype"  <%=cons_disable_flag%> disabled>
						<option value='PI' >
						<fmt:message key="eOT.ProsthesisImplants.Label" bundle="${ot_labels}"/>
						</option>
						<option value='CP'>
						<fmt:message key="eOT.ConsumablePacks.Label" bundle="${ot_labels}"/>
						</option>
						<option value='EQ'>
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
						<select class="my_dropdown" id="menuIC" name="operation_ic" id="operation_ic"  <%=ic_disable_flag%> ><!--MMS-QH-CRF-0199-->
						<% 
		                rs.beforeFirst();
						while(rs.next())
						{
						//Added by DhanasekarV on 14/11/2011
						oper_line_status = checkForNull(rs.getString("OPER_LINE_STATUS"));
						if(!("99").equals(oper_line_status))
						{
						val = checkForNull(rs.getString("OPR_CODE"))+"##"+checkForNull(rs.getString("LN_NUM"));

						%>
						<option value='<%=val%>' title="<%=checkForNull(rs.getString("OPR_DESC"))%>"> <%=checkForNull(rs.getString("OPR_DESC"))%>  </option><!--MMS-QH-CRF-0199-->
						<%
						}
							}%>

						</select>
						<img src='../../eCommon/images/mandatory.gif'></img>
						</td>

						</tr>

						<tr>

						<td class="label" width="25%" >
						<fmt:message key="Common.Instrument.label" bundle="${common_labels}"/> </td>
						<td class="fields" width="25%">
						<input type='hidden' name='instr_code' id='instr_code' > 
						<input type='text' name='instr_desc' id='instr_desc' onBlur="if(this.value!='')searchInstrument(instr_code,instr_desc);"> 
						<input type='button' class='button' value='?' name='InstrumentLookUp' id='InstrumentLookUp' onClick='searchInstrument(instr_code,instr_desc);' <%=ic_disable_flag%> > <img src='../../eCommon/images/mandatory.gif'></img>
						</td>
						<!-- </tr>
						<tr> -->
						<%if(Ot_param.equalsIgnoreCase("Y")){%> <!--Added by lakshmi against RUT-CRF-0058-->
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
						<input type='text' name='tray_no' id='tray_no' maxlength='30' size='20' <%=ic_disable_flag%> > 
						</td>
						<%}%>
						</tr>

                        <tr>
						<td class="label" width='25%'><fmt:message key="eOT.ActualUnits.Label" bundle="${ot_labels}"/></td>
	                    <td class="fields" width='25%'><input type='text' name='quantity_ic' id='quantity_ic' maxlength='3' size='2' onBlur="ChkNumber(this);" onkeypress="return checkForSpecCharsforID(event);"  <%=ic_disable_flag%>><img src='../../eCommon/images/mandatory.gif'></img></td>
						<td class="label" width='25%'>
						<input type='hidden' name='remarks_ic' id='remarks_ic' value="">
			            <a  class="gridLink" href="javascript:openRemarksWindow(document.forms[0].remarks_ic,'instrumnets');">
				        <fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>
						<td width="25%" >
						<input type='button' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='assignCodes_ic(document.forms[0].operation_ic);addRow_ic();' <%=ic_disable_flag%> >
						<input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow_ic();' <%=ic_disable_flag%> >
						</td>
						</tr>
						</table>
						</tr>
						</table>
						</div>
						</tr> 
                        <%}%>
                    
   
						<%  if(("Y").equals(rec_implants_in_admin_notes_yn))
			            {%>
						<tr>
						<td><table width="100%" border="0" onclick="createTable_pi();">
							<tr>
								<th align="left">&nbsp;&nbsp;&nbsp;<img name="PI_arrow" src="../../eCommon/images/tree_handlerightlast.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuPI',this);" /><fmt:message key="eOT.ProsthesisImplants.Label" bundle="${ot_labels}"/></th>
							</tr>
						</table></td>
						</tr>
							<%
						if(("Y").equals(flag_pi)){
						%>
						<table border='0' cellpadding='0' cellspacing='0' width='100%'  id='moreCriteriaPI' name='moreCriteriaPI' id='moreCriteriaPI' style='visible:hidden;display:none;' 
                        bordercolor='white'> 
						<%}else{%>
						<table border='0' cellpadding='0' cellspacing='0' width='100%'  id='moreCriteriaPI' name='moreCriteriaPI' id='moreCriteriaPI' style='display:inline;'  bordercolor='white'> 
						<%}%>
						</table>
						<tr>
						<div id="menuExpand4" style='display:none;visibility:visible;height:60px;width:100%' >
						<table id="PI_arrow" style='display:visible;' >
					
                        </table>
						</div>
						</tr>
                        <%}%>
						<%  if(("Y").equals(rec_packs_in_admin_notes_yn))
	                     {%>
						<tr>
						<td><table width="100%" border="0" onclick="createTable_cons();">
							<tr>
								<th align="left">&nbsp;&nbsp;&nbsp;<img name="CP_arrow" src="../../eCommon/images/tree_handlerightlast.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuCP',this);" /><fmt:message key="eOT.ConsumablePacks.Label" bundle="${ot_labels}"/></th>
							</tr>
						</table></td>
						</tr>
							<%
						if(("Y").equals(flag_cp)){
						%>
						<table border='0' cellpadding='0' cellspacing=0 width='100%'  id='moreCriteriaCP' name='moreCriteriaCP' id='moreCriteriaCP' style='visible:hidden;display:none;overflow:auto;' 
                        bordercolor='white' > 
						<%}else{%>
						<table border='0' cellpadding='0' cellspacing=0 width='100%'  id='moreCriteriaCP' name='moreCriteriaCP' id='moreCriteriaCP' style='visible:inline;overflow:auto;'  bordercolor='white'> 
						<%}%>
						</table>
						
						<tr>
						<div id="menuExpand5" style='display:none;visibility:visible;height:60px;width:100%'>
						<table id="CP_arrow" style='display:visible;overflow:auto;'>
                      
                        </table>
						</div>
						</tr>
						  <%}%>
						<%if(("Y").equals(rec_equp_in_admin_notes_yn)){%>
						<tr>
						<!--Modified by lakshmi against CRF-0057 starts here-->
						<%if(Ot_param.equalsIgnoreCase("Y")){%>
						<td><table width="100%" border="0"  onclick="createTable_eq1();">
							<tr>
								<th align="left">&nbsp;&nbsp;&nbsp;<img name="Eq_arrow" src="../../eCommon/images/tree_handlerightlast.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuEq',this);" /><fmt:message key="eOT.Equipments.Label" bundle="${ot_labels}"/></th>
							</tr>
						</table></td>
						<%}
						else{%>
						<td><table width="100%" border="0"  onclick="createTable_eq();">
							<tr>
							<!-- Modified By rajesh 29-8-2012 -->
								<th align="left">&nbsp;&nbsp;&nbsp;<img name="Eq_arrow" src="../../eCommon/images/tree_handlerightlast.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuEq',this);" /><fmt:message key="eOT.Equipments.Label" bundle="${ot_labels}"/></th>
							<!-- Modified By rajesh 29-8-2012 -->
							</tr>
						</table></td>
						<%}%>
						<!--Modified by lakshmi against CRF-0057 ends here-->
							<%
						if(("Y").equals(flag_eq)){
						%>
						<table border='0' cellpadding='0' cellspacing=0 width='100%'  id='moreCriteriaEq' name='moreCriteriaEq' id='moreCriteriaEq' style='visible:hidden;display:none;overflow:auto;' 
                        bordercolor='white' > 
						<%}else{%>
						<table border='0' cellpadding='0' cellspacing=0 width='100%'  id='moreCriteriaEq' name='moreCriteriaEq' id='moreCriteriaEq' style='visible:inline;overflow:auto;'  bordercolor='white'> 
						<%}%>
						</table>
						<tr>
						<div id="menuExpand6" style='display:none;visibility:visible;height:60px;width:100%'>
						<table id="Eq_arrow" style='display:visible;overflow:auto;'>
                        
                        </table>
						</div>
						</tr>
						<%}%>
						<%if(("Y").equals(rec_instr_in_admin_notes_yn)){%>
						<tr>
						<%if(Ot_param.equalsIgnoreCase("Y")){%>
						<td><table width="100%" border="0"  onclick="createTable_ic1();">
							<tr>
								<th align="left">&nbsp;&nbsp;&nbsp;<img name="IC_arrow" src="../../eCommon/images/tree_handlerightlast.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuIC',this);" /><fmt:message key="eOT.InstrumentsCSSDPacks.Label" bundle="${ot_labels}"/></th>
							</tr>
						</table></td>
						<%}
						else{%>
						<td><table width="100%" border="0"  onclick="createTable_ic();">
							<tr>
								<th align="left">&nbsp;&nbsp;&nbsp;<img name="IC_arrow" src="../../eCommon/images/tree_handlerightlast.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuIC',this);" /><fmt:message key="eOT.InstrumentsCSSDPacks.Label" bundle="${ot_labels}"/></th>
							</tr>
						</table></td>
						<%}%>
						<!--Modified by lakshmi against CRF-0058 ends here-->
						</tr>
							<%
						if(("Y").equals(flag_ic)){
						%>
						<table border='0' cellpadding='0' cellspacing=0 width='100%'  id='moreCriteriaIC' name='moreCriteriaIC' id='moreCriteriaIC' style='visible:hidden;display:none;overflow:auto;' 
                        bordercolor='white' > 
						<%}else{%>
						<table border='0' cellpadding='0' cellspacing=0 width='100%'  id='moreCriteriaIC' name='moreCriteriaIC' id='moreCriteriaIC' style='visible:inline;overflow:auto;'  bordercolor='white'> 
						<%}%>
						</table>
						<tr>
						<div id="menuExpand7" style='display:none;visibility:visible;height:60px;width:100%'>
						<table id="IC_arrow" style='display:visible;overflow:auto;'>
                       
                        </table>
						</div>
						</tr>
                        <%}%>
						<%if(("true").equals(bill_flag) && ("Y").equals(charge_operating_room_yn) && ("Y").equals(or_chargeable_yn)){%>
						<tr>
						<td><table width="100%" border="0" >
							<tr>
								<th align="left"><img name="OR_arrow" src="../../eCommon/images/tree_handlerightlast.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuOR',this);" /><fmt:message key="eOT.OperatingRoomUsage.Label" bundle="${ot_labels}"/></th>
							</tr>
						</table></td>
						</tr>
							<%
						if(("Y").equals(flag_or)){
						%>
						<table border='0' cellpadding='0' cellspacing=0 width='100%'  id='moreCriteriaOR' name='moreCriteriaOR' id='moreCriteriaOR' style='visible:hidden;display:none;overflow:auto;' 
                        bordercolor='white' > 
						<%}else{%>
						<table border='0' cellpadding='0' cellspacing=0 width='100%'  id='moreCriteriaOR' name='moreCriteriaOR' id='moreCriteriaOR' style='visible:inline;overflow:auto;'  bordercolor='white'> 
						<%}%>
						</table>
						<tr>
						<div id="menuExpand8" style='display:none;visibility:visible;overflow:auto;height:92px;width:100%'>
						<table id="OR_arrow" style='display:visible;overflow:auto;'>
                       <tr>
						<td class='fields' width="32%">
						<fmt:message key="eOT.CheckinToORDateTime.Label" bundle="${ot_labels}"/>  &nbsp;&nbsp;
						   <input type='text' class='fields' name='chk_in_or_date_time' id='chk_in_or_date_time' size='12'  value='<%=check_into_or_time1%>'  disabled>
						   
						    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
						
                        <td class='fields' width="32%">
							<fmt:message key="eOT.CheckOutFromORDateTime.Label" bundle="${ot_labels}"/>&nbsp;&nbsp; 
						       <input type='text' class='fields' name='chk_out_or_date_time' id='chk_out_or_date_time' size='12'  value='<%=check_out_or_time1%>' onblur='validateDate();' onkeypress="return checkForSpecCharsforID(event);" disabled>
								
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td> 

						<td class='fields' width="36%">
						   <fmt:message key="eOT.ChargableUnits.Label" bundle="${ot_labels}"/> &nbsp;&nbsp;
						
						    <input type='text' class='fields' name='charge_units_or' id='charge_units_or' size='3'  maxlength='3' value='<%=or_chargeable_units%>' onblur="getServPanelDtls(this,'OR');" <%=disable_or%>><img src='../../eCommon/images/mandatory.gif'></img>
						</td> 
						<tr>
						<td class='label'></td>
						<td class="gridData" colspan ='3' >
						<div id="charge_details_or" style='visible:hidden;display:none'>
						</div>
						</td>
						</tr>
						</tr>
						<tr>
						<%if(("Y").equals(or_chrg_cmp_yn))
						{%>
						<td  class='Label' width="25%">
						<fmt:message key="Common.completed.label" bundle="${common_labels}"/>	
					    &nbsp;&nbsp;&nbsp;
					
						<input type='checkbox'  class='label' name='doc_compl_or' id='doc_compl_or' onClick='validateCheckBox_or();' disabled checked>
						</td>	
						<%}else {%>
						<td  class='Label' width="25%">
						<fmt:message key="Common.completed.label" bundle="${common_labels}"/>	
					    &nbsp;&nbsp;&nbsp;
					
						<input type='checkbox'  class='label' name='doc_compl_or' id='doc_compl_or' onClick='validateCheckBox_or();' <%=disable_or%> >
						</td>
						<%}%>
						</tr>
                        </table>
						</div>
						</tr>
						<%}%>
                        <%if(("true").equals(bill_flag) && ("Y").equals(charge_holding_area_yn) && maxRecord>0){%>
						<tr>
						<td><table width="100%" border="0" >
							<tr>
								<th align="left"><img name="HA_arrow" src="../../eCommon/images/tree_handlerightlast.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuHA',this);" /><fmt:message key="eOT.HoldingAreaUsage.Label" bundle="${ot_labels}"/></th>
							</tr>
						</table></td>
						</tr>
							<%
						if(("Y").equals(flag_ha)){
						%>
						<table border='0' cellpadding='0' cellspacing=0 width='100%'  id='moreCriteriaHA' name='moreCriteriaHA' id='moreCriteriaHA' style='visible:hidden;display:none;overflow:auto;' 
                        bordercolor='white' > 
						<%}else{%>
						<table border='0' cellpadding='0' cellspacing=0 width='100%'  id='moreCriteriaHA' name='moreCriteriaHA' id='moreCriteriaHA' style='visible:inline;overflow:auto;'  bordercolor='white'> 
						<%}%>
						</table>
						<tr>
						<div id="menuExpand9" style='display:none;visibility:visible;overflow:auto;height:92px;width:100%'>
						<table id="HA_arrow" style='display:visible;overflow:auto;'>                     
						
						<%int i=0;
						if(maxRecord>0)
	                    {
							while(rst_ha_room !=null && rst_ha_room.next())
	                    { 
						holding_area_code=checkForNull(rst_ha_room.getString("HOLDING_AREA_CODE"));
						checked_in_date_time=checkForNull(com.ehis.util.DateUtils.convertDate(rst_ha_room.getString("CHECKED_IN_DATE_TIME"),"DMYHM","en",locale));
						checked_out_date_time=checkForNull(com.ehis.util.DateUtils.convertDate(rst_ha_room.getString("CHECKED_OUT_DATE_TIME"),"DMYHM","en",locale));
						checked_in_date_time1=checkForNull(rst_ha_room.getString("CHECKED_IN_DATE_TIME1"));
						checked_out_date_time1=checkForNull(rst_ha_room.getString("CHECKED_OUT_DATE_TIME1"));
						calc_chargeable_units=checkForNull(rst_ha_room.getString("CALC_CHARGEABLE_UNITS"));
						chargeable_units=checkForNull(rst_ha_room.getString("CHARGEABLE_UNITS"));
						bl_accession_num=checkForNull(rst_ha_room.getString("BL_ACCESSION_NUM"));
						holding_seq_num=checkForNull(rst_ha_room.getString("HOLDING_SEQ_NUM"));
						 if(("").equals(checked_in_date_time) || ("").equals(checked_out_date_time)) disable_ha="disabled";

						%>
						<tr>
						 <td class='fields' width="32%">
						<fmt:message key="eOT.CheckedInDateTime.Label" bundle="${ot_labels}"/> &nbsp;&nbsp;
						   <input type='text' class='fields' name='chk_in_ha_date_time_<%=i%>' id='chk_in_ha_date_time_<%=i%>' size='12'  value='<%=checked_in_date_time%>'  disabled>
					
						    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
						
                        <td class='fields' width="32%">
							<fmt:message key="eOT.CheckedOutDateTime.Label" bundle="${ot_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						       <input type='text' class='fields' name='chk_out_ha_date_time_<%=i%>' id='chk_out_ha_date_time_<%=i%>' size='12'  value='<%=checked_out_date_time%>' onblur='validateDate();' onkeypress="return checkForSpecCharsforID(event);" disabled>
								
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td> 

						<td class='fields' width="36%">
						   <fmt:message key="eOT.ChargableUnits.Label" bundle="${ot_labels}"/> &nbsp;&nbsp;
						
						    <input type='text' class='fields' name='charge_units_ha_<%=i%>' id='charge_units_ha_<%=i%>' size='3'  maxlength='3' value='<%=chargeable_units%>'  onblur="getServPanelDtls(this,'HA','<%=i%>');" <%=disable_ha%>><img src='../../eCommon/images/mandatory.gif'></img>
						</td> 
						<tr>
						<td class='label'></td>
						<td class="gridData" colspan ='3' >
						<div id="charge_details_ha_<%=i%>" style='visible:hidden;display:none'>
						</div>
						</td>
						</tr>
						</tr>
						<input type='hidden' name='checked_in_date_time_<%=i%>' id='checked_in_date_time_<%=i%>'   value='<%=checked_in_date_time1%>'>
						<input type='hidden' name='checked_out_date_time_<%=i%>' id='checked_out_date_time_<%=i%>'   value='<%=checked_out_date_time1%>'>
						<input type='hidden' name='bl_accession_num_<%=i%>' id='bl_accession_num_<%=i%>'   value='<%=bl_accession_num%>'>	
						<input type='hidden' name='holding_seq_num_<%=i%>' id='holding_seq_num_<%=i%>'    value='<%=holding_seq_num%>'>	
						<input type='hidden' name='holding_area_code_<%=i%>' id='holding_area_code_<%=i%>'  value='<%=holding_area_code%>'>	
						<input type='hidden' name='calc_charge_units_<%=i%>' id='calc_charge_units_<%=i%>'  value='<%=chargeable_units%>'>	
						<input type='hidden' name='modified_charge_units_ha_<%=i%>' id='modified_charge_units_ha_<%=i%>'  value=''>	
						<input type='hidden' name='serv_code_ha_<%=i%>' id='serv_code_ha_<%=i%>'  value=''>	
						<input type='hidden' name='include_exclude_ha_<%=i%>' id='include_exclude_ha_<%=i%>'  value=''>	
						<input type='hidden' name='appr_reqd_val_ha_<%=i%>' id='appr_reqd_val_ha_<%=i%>'  value=''>	
						<input type='hidden' name='action_reason_code_ha_<%=i%>' id='action_reason_code_ha_<%=i%>'  value=''>	
                        <% 
						
						i++;maxRecord=i;
						}
						}else {%>
						<tr>
						 <td class='fields' width="32%">
						<fmt:message key="eOT.CheckedInDateTime.Label" bundle="${ot_labels}"/> &nbsp;&nbsp;
						   <input type='text' class='fields' name='chk_in_ha_date_time_<%=i%>' id='chk_in_ha_date_time_<%=i%>' size='12'  value='<%=checked_in_date_time%>'  disabled>
					
						    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
						
                        <td class='fields' width="32%">
							<fmt:message key="eOT.CheckedOutDateTime.Label" bundle="${ot_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						       <input type='text' class='fields' name='chk_out_ha_date_time_<%=i%>' id='chk_out_ha_date_time_<%=i%>' size='12'  value='<%=checked_out_date_time%>' onblur='validateDate();' onkeypress="return checkForSpecCharsforID(event);" disabled>
								
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td> 

						<td class='fields' width="36%">
						   <fmt:message key="eOT.ChargableUnits.Label" bundle="${ot_labels}"/> &nbsp;&nbsp;
						
						    <input type='text' class='fields' name='charge_units_ha_<%=i%>' id='charge_units_ha_<%=i%>' size='3'  maxlength='3' value='<%=chargeable_units%>'  onblur="getServPanelDtls(this,'HA','<%=i%>');" <%=disable_ha%> ><img src='../../eCommon/images/mandatory.gif'></img>
						</td> 
						</tr>
						<input type='hidden' name='bl_accession_num_<%=i%>' id='bl_accession_num_<%=i%>'  value='<%=bl_accession_num%>'>	
						<input type='hidden' name='chargeable_units_<%=i%>' id='chargeable_units_<%=i%>'  value='<%=chargeable_units%>'>	
						<input type='hidden' name='holding_area_code_<%=i%>' id='holding_area_code_<%=i%>'  value='<%=holding_area_code%>'>	
						<input type='hidden' name='modified_charge_units_ha_<%=i%>' id='modified_charge_units_ha_<%=i%>'  value=''>	
						<input type='hidden' name='serv_code_ha_<%=i%>' id='serv_code_ha_<%=i%>'  value=''>	

						<%} %>
						
						<tr>
						<%if(("Y").equals(hld_chrg_cmp_yn)){%>
						<td  class='Label' width="25%">
						<fmt:message key="Common.completed.label" bundle="${common_labels}"/>	
						&nbsp;&nbsp;&nbsp;
						<input type='checkbox'  class='label' name='doc_compl_ha' id='doc_compl_ha' onClick='validateCheckBox_ha();' disabled checked >
						</td>	
						<%}else{%>
						<td  class='Label' width="25%">
						<fmt:message key="Common.completed.label" bundle="${common_labels}"/>	
						&nbsp;&nbsp;&nbsp;
						<input type='checkbox'  class='label' name='doc_compl_ha' id='doc_compl_ha' onClick='validateCheckBox_ha();' <%=disable_ha%> >
						</td>	
						<%}%>
						</tr>
		
                        </table>
						</div>
						</tr>
					   <%}%>
                      <%if(("true").equals(bill_flag) && ("Y").equals(charge_recovery_room_yn) && ("Y").equals(rec_chargeable_yn)){%>
						<tr>
						<td><table width="100%" border="0" >
							<tr>
								<th align="left"><img name="RR_arrow" src="../../eCommon/images/tree_handlerightlast.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuRR',this);" /><fmt:message key="eOT.RecoveryRoomUsage.Label" bundle="${ot_labels}"/></th>
							</tr>
						</table></td>
						</tr>
							<%
						if(("Y").equals(flag_rr)){
						%>
						<table border='0' cellpadding='0' cellspacing=0 width='100%'  id='moreCriteriaRR' name='moreCriteriaRR' id='moreCriteriaRR' style='visible:hidden;display:none;overflow:auto;' 
                        bordercolor='white' > 
						<%}else{%>
						<table border='0' cellpadding='0' cellspacing=0 width='100%'  id='moreCriteriaRR' name='moreCriteriaRR' id='moreCriteriaRR' style='visible:inline;overflow:auto;'  bordercolor='white'> 
						<%}%>
						</table>
						<tr>
						<div id="menuExpand10" style='display:none;visibility:visible;overflow:auto;height:92px;width:100%'>
						<table id="RR_arrow" style='display:visible;overflow:auto;'>
                        <tr>
						<td class='fields' width="32%">
						<fmt:message key="eOT.CheckedInDateTime.Label" bundle="${ot_labels}"/> &nbsp;&nbsp;
						   <input type='text' class='fields' name='chk_in_rec_date_time' id='chk_in_rec_date_time' size='12'  value='<%=recovery_start_time1%>'  disabled>
						   
						    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
						
                        <td class='fields' width="32%">
							<fmt:message key="eOT.CheckedOutDateTime.Label" bundle="${ot_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						       <input type='text' class='fields' name='chk_out_rec_date_time' id='chk_out_rec_date_time' size='12'  value='<%=recovery_end_time1%>' onblur='validateDate();' onkeypress="return checkForSpecCharsforID(event);" disabled>
								
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td> 

						<td class='fields' width="36%">
						   <fmt:message key="eOT.ChargableUnits.Label" bundle="${ot_labels}"/> &nbsp;&nbsp;
						
						    <input type='text' class='fields' name='charge_units_rec' id='charge_units_rec' size='3'  maxlength='3' value='<%=recv_chargeable_units%>' onblur="getServPanelDtls(this,'REC');" <%=disable_rec%>><img src='../../eCommon/images/mandatory.gif'></img>
						</td> 
						<tr>
						<td class='label' ></td>
						<td class="gridData" colspan ='4' >
						<div id="charge_details_1" style='visible:hidden;display:none'>
						</div>
						</td>
						<tr>
						

						</tr>
						<tr>
						<%if(("Y").equals(rec_chrg_cmp_yn))
						{%>
						<td  class='Label' width="25%">
						<fmt:message key="Common.completed.label" bundle="${common_labels}"/>	
						&nbsp;&nbsp;&nbsp;
						<input type='checkbox'  class='label' name='doc_compl_rec' id='doc_compl_rec' onClick='validateCheckBox_rec();' disabled checked>
						</td>	
						<%}else {%>
						<td  class='Label' width="25%">
						<fmt:message key="Common.completed.label" bundle="${common_labels}"/>	
						&nbsp;&nbsp;&nbsp;
						<input type='checkbox'  class='label' name='doc_compl_rec' id='doc_compl_rec' onClick='validateCheckBox_rec();' <%=disable_rec%>>
						</td>	
						<%}%>
						</tr>	
                        </table>
						</div>
						</tr>
						<%}%>

				<!--Added by lakshmi for crf-0601 starts here-->
				<%if(customer_id1.equalsIgnoreCase("SRR")){%> <!--Muthu Modified -->
						<table width="100%" border="0" >
						<tr>
						<th align="left"><img name="PR_arrow" src="../../eCommon/images/tree_handlerightlast.gif" alt="Arrow" height="20" align="middle" onclick="expandMenu('menuPR',this);" /> <fmt:message key="eOT.PrintReports.Label" bundle="${ot_labels}"/></th>
						</tr>
						</table>
							<%}%>			
						<%
						if(("Y").equals(flag_pr)){							
						%>
						<table border='0' cellpadding='0' cellspacing=0 width='100%'  id='moreCriteriaPR' name='moreCriteriaPR' id='moreCriteriaPR' style='visible:hidden;display:none;overflow:auto;' 
						bordercolor='white' > </table>
						<%}						
					    else{%>
						<table border='0' cellpadding='0' cellspacing=0 width='100%'  id='moreCriteriaPR' name='moreCriteriaPR' id='moreCriteriaPR' style='visible:inline;overflow:auto;'  bordercolor='white'> 
						<%}%>
						</table>
						
						<div id="menuExpand11" style='display:none;visibility:visible;overflow:auto;height:92px;width:100%'>
						<table id="PR_arrow" style='display:visible;overflow:auto;'>
                        <tr>
						<td  class='Label' width="25%">
						<fmt:message key="eOT.SummaryOfMedicalTreatmentInOT.Label" bundle="${ot_labels}"/>	
						&nbsp;&nbsp;&nbsp;
							
						<input type='checkbox'  class='label' name='summary' id='summary' onClick='validateCheckboxSummary()' >
						</td>
												
						<td  class='Label' width="25%">
						<fmt:message key="eOT.ProsthesisImplantsUsedForTreatment.Label" bundle="${ot_labels}"/>	
						&nbsp;&nbsp;&nbsp;
							
						<input type='checkbox'  class='label' name='pros_impl' id='pros_impl' onClick='validateCheckboxProsthesis()' >
						</td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
						<td class='Label' width="25%">
						<input type='button'  class='label' name='print' id='print' value='Print' onClick='OnPrintReport()' >
						</td>
                        </tr>
						</table>
						<!--Added by lakshmi for crf-0601 ends here-->
           <input type='hidden' name='module_id' id='module_id'       value='<%=module_id%>'>
			<input type='hidden' name='hld_chrg_cmp_yn' id='hld_chrg_cmp_yn' value='<%=hld_chrg_cmp_yn%>'>
			<input type='hidden' name='or_chrg_cmp_yn' id='or_chrg_cmp_yn'  value='<%=or_chrg_cmp_yn%>'>
			<input type='hidden' name='rec_chrg_cmp_yn' id='rec_chrg_cmp_yn' value='<%=rec_chrg_cmp_yn%>'>
			<input type='hidden' name='serv_date' id='serv_date'       value='<%=serv_date%>'>
			<input type = "hidden" name= "rec_implants_in_admin_notes_yn" value="<%=rec_implants_in_admin_notes_yn%>">
			<input type = "hidden" name= "rec_packs_in_admin_notes_yn"  value ="<%=rec_packs_in_admin_notes_yn%>">
			<input type = "hidden" name= "rec_equp_in_admin_notes_yn"  value ="<%=rec_equp_in_admin_notes_yn%>">
			<input type = "hidden" name= "rec_instr_in_admin_notes_yn"  value ="<%=rec_instr_in_admin_notes_yn%>">
			<input type = "hidden" name= "st_interface_flag"  value ="<%=st_interface_flag%>">
			<input type = "hidden" name= "oper_room_code"  value ="<%=oper_room_code%>">
			<input type = "hidden" name= "params"       value = "<%=params%>">
			<input type = "hidden" name= "patient_class1"       value = "<%=patient_class%>">
			<input type = "hidden" name= "locale"       value = "<%=locale%>">
			<input type = "hidden" name= "facility_id"  value=<%=facility_id%> >
		    <input type = "hidden" name= "flag_op"      value="<%=flag_op%>">
		    <input type = "hidden" name= "flag_ac"      value="<%=flag_ac%>">
		    <input type = "hidden" name= "flag_dc"      value="<%=flag_dc%>">
		    <input type = "hidden" name= "flag_pi"      value="<%=flag_pi%>">
		    <input type = "hidden" name= "flag_cp"      value="<%=flag_cp%>">
		    <input type = "hidden" name= "flag_eq"      value="<%=flag_eq%>">
		    <input type = "hidden" name= "flag_ic"      value="<%=flag_ic%>">
		    <input type = "hidden" name= "flag_or"      value="<%=flag_or%>">
		    <input type = "hidden" name= "flag_ha"      value="<%=flag_ha%>">
		    <input type = "hidden" name= "flag_rr"      value="<%=flag_rr%>">
		    <input type = "hidden" name= "flag_asc"     value="<%=flag_asc%>">
			<!--Added by lakshmi for crf-0601-->
			<input type = "hidden" name= "flag_pr"      value="<%=flag_pr%>">
			<input type='hidden' name='recId' id='recId' value=''>
			<input type='hidden' name='oper_code' id='oper_code' value=''>
			<input type='hidden' name='oper_line_no' id='oper_line_no' value=''>
			<input type='hidden' name='mode' id='mode' value='I'>
			<input type='hidden' name='oper_num' id='oper_num' value="<%=oper_num%>">
			<input type='hidden' name='bill_flag' id='bill_flag' value="<%=bill_flag%>">
			<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>">
			<input type='hidden' name='speciality_code' id='speciality_code' value="<%=speciality_code%>">
			<input type='hidden' name='check_into_or_time' id='check_into_or_time' value="<%=check_into_or_time%>">
			<input type='hidden' name='check_out_or_time' id='check_out_or_time' value="<%=check_out_or_time%>">
			<input type='hidden' name='oper_room_code_or' id='oper_room_code_or' value="<%=oper_room_code_or%>">
		    <input type='hidden' name='serv_code_or' id='serv_code_or' value="">
			<input type='hidden' name='modified_charge_units_or' id='modified_charge_units_or' value="">
			<input type='hidden' name='or_bl_accession_num' id='or_bl_accession_num' value="<%=or_bl_accession_num%>">
			<input type='hidden' name='booking_num' id='booking_num' value="<%=booking_num%>">
			<input type='hidden' name='surgeon_code' id='surgeon_code' value="<%=surgeon_code%>">
			<input type='hidden' name='order_id' id='order_id' value="<%=order_id%>">
			<input type='hidden' name='recovery_room_code' id='recovery_room_code' value="<%=recovery_room_code%>">
			<input type='hidden' name='recovery_start_time' id='recovery_start_time' value="<%=recovery_start_time%>">
			<input type='hidden' name='recovery_end_time' id='recovery_end_time' value="<%=recovery_end_time%>">
			<input type='hidden' name='serv_code' id='serv_code' value="">
			<input type='hidden' name='recv_bl_accession_num' id='recv_bl_accession_num' value="<%=recv_bl_accession_num%>">
			<input type='hidden' name='modified_charge_units' id='modified_charge_units' value="">
			<input type='hidden' name='maxRecord' id='maxRecord' value="<%=maxRecord%>">
			<input type='hidden' name='encounter_id1' id='encounter_id1' value="<%=encounter_id1%>">
			<input type='hidden' name='episode_id' id='episode_id' value="<%=episode_id%>">
			<input type='hidden' name='visit_id1' id='visit_id1' value="<%=visit_id1%>">
			<input type='hidden' name='episode_type' id='episode_type' value="<%=bl_episode_type%>">
			<input type='hidden' name='order_id1' id='order_id1' value="<%=order_id1%>">
			<input type='hidden' name='str_order_catalog_code' id='str_order_catalog_code' value="<%=str_order_catalog_code%>">
			<input type='hidden' name='ref_source_code' id='ref_source_code' value="<%=ref_source_code%>">
			<input type='hidden' name='operation_sub_services_yn' id='operation_sub_services_yn' value="<%=operation_sub_services_yn%>">
			<input type='hidden' name='trfr_ward_code' id='trfr_ward_code' value="<%=trfr_ward_code%>">
			<input type='hidden' name='implant_entry_cmp_yn' id='implant_entry_cmp_yn' value="<%=implant_entry_cmp_yn%>">
			<input type='hidden' name='consumable_entry_cmp_yn' id='consumable_entry_cmp_yn' value="<%=consumable_entry_cmp_yn%>">
			<input type='hidden' name='equipment_entry_cmp_yn' id='equipment_entry_cmp_yn' value="<%=equipment_entry_cmp_yn%>">
			<input type='hidden' name='instrument_entry_cmp_yn' id='instrument_entry_cmp_yn' value="<%=instrument_entry_cmp_yn%>">
			<input type='hidden' name='recy_room_finalization_stage' id='recy_room_finalization_stage' value="<%=recy_room_finalization_stage%>">
			<input type='hidden' name='hold_finalization_stage' id='hold_finalization_stage' value="<%=hold_finalization_stage%>">
			<input type='hidden' name='oper_room_finalization_stage' id='oper_room_finalization_stage' value="<%=oper_room_finalization_stage%>">
			<input type='hidden' name='charge_holding_area_yn' id='charge_holding_area_yn' value="<%=charge_holding_area_yn%>">
			<input type='hidden' name='charge_operating_room_yn' id='charge_operating_room_yn' value="<%=charge_operating_room_yn%>">
			<input type='hidden' name='charge_recovery_room_yn' id='charge_recovery_room_yn' value="<%=charge_recovery_room_yn%>">
			<input type='hidden' name='rec_chargeable_yn' id='rec_chargeable_yn' value="<%=rec_chargeable_yn%>">
			<input type='hidden' name='or_chargeable_yn' id='or_chargeable_yn' value="<%=or_chargeable_yn%>">
			<input type='hidden' name='oper_finalization_stage' id='oper_finalization_stage' value="<%=oper_finalization_stage%>">
			<input type='hidden' name='proc_chrg_cmp_yn' id='proc_chrg_cmp_yn' value="<%=proc_chrg_cmp_yn%>">
			<input type='hidden' name='slate_user_id' id='slate_user_id' value="<%=slate_user_id%>">
			<input type='hidden' name='st_charge_based_yn' id='st_charge_based_yn' value="<%=st_charge_based_yn%>">
			<input type='hidden' name='mm_item_code' id='mm_item_code' value="<%=mm_item_code%>">
			<input type='hidden' name='surgeon_code1' id='surgeon_code1' value="<%=surgeon_code1%>">
			<input type='hidden' name='include_exclude1' id='include_exclude1' value=''>
			<input type='hidden' name='include_exclude_or' id='include_exclude_or' value=''>
			<input type='hidden' name='appr_reqd_val1' id='appr_reqd_val1' value=''>
			<input type='hidden' name='appr_reqd_val_or' id='appr_reqd_val_or' value=''>
			<input type='hidden' name='calc_chrge_units_rec' id='calc_chrge_units_rec' value=''>
			<input type='hidden' name='calc_chrge_units_or' id='calc_chrge_units_or' value=''>
			<input type='hidden' name='action_reason_code1' id='action_reason_code1' value=''>
			<input type='hidden' name='action_reason_code_or' id='action_reason_code_or' value=''>
			<input type='hidden' name='p_ord_practitioner_id' id='p_ord_practitioner_id' value='<%=p_ord_practitioner_id%>'>	
			<!-- Modified by Muthukumar on 21-10-11-->
		<input type='hidden' name='customer_id1' id='customer_id1' value="<%=customer_id1%>">
			<!-- Modified by Muthukumar on 21-10-11-->
			<!--Added by lakshmi for crf-0601 starts here-->
			<input type='hidden' name='p_oper_num' id='p_oper_num' value="<%=oper_num%>">
			<input type='hidden' name='p_patient_id' id='p_patient_id' value="<%=patient_id%>">
			<input type ='hidden' name='p_facility_id' id='p_facility_id' value="<%=facility_id%>">
			<input type='hidden' name='p_report_id' id='p_report_id' value="<%=p_report_id%>">
			<!--Added by lakshmi for crf-0601 ends here-->
			<input type='hidden' name='Ot_param' id='Ot_param' value="<%=Ot_param%>"><!--Added by lakshmi against crf-0058-->
			<input type="hidden" name="checkInTime" id="checkInTime" id="checkInTime" value="<%=checkInTime%>">
			<input type='hidden' name='oneWeekDate' id='oneWeekDate' id='oneWeekDate' value="<%=oneWeekDate%>">
			<input type='hidden' name='tab_name' id='tab_name' value="<%=tab_name%>">

		</form>
	</body>
</html>
<% 
 oper_codes.setLength(0);
}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null)                rs.close();
		if(pstmt!=null)             pstmt.close();
		if(pstmt2!=null)            pstmt2.close();
		if(rst_bl!=null) rst_bl.close();
		if(pstmt_bl!=null)pstmt_bl.close();
		if(statement!=null)statement.close();
		if(rst_ha_room!=null)rst_ha_room.close();
		if(pstmt_ha_room!=null)pstmt_ha_room.close();
		if(pstmt_pi!=null)   pstmt_pi.close();
		if(rst_pi!=null)     rst_pi.close();
		if(pstmt_cons!=null) pstmt_cons.close();
		if(rst_cons!=null)   rst_cons.close();
		if(rst_eq!=null)	  rst_eq.close();
		if(pstmt_eq !=null)   pstmt_eq.close();
		if(rst_ic!=null)	  rst_ic.close();
		if(pstmt_ic !=null)   pstmt_ic.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}
%>

