<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  contentType=" text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp"%>
<%@page  import ="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,eCommon.Common.CommonBean,java.sql.CallableStatement,webbeans.eCommon.ConnectionManager,eCommon.Common.*,eOT.*,eOT.Common.*,eCommon.XSSRequestWrapper,eOR.OrderEntryBillingQueryBean,java.util.ArrayList" contentType=" text/html;charset=UTF-8" %>
<%  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends

	String tab = checkForNull(request.getParameter("tab"));
	String proc_chrg_cmp_yn = checkForNull(request.getParameter("proc_chrg_cmp_yn"));
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
	String bill_flag = checkForNull(request.getParameter("bill_flag"));
	String mode_one = checkForNull(request.getParameter("mode_one"));
	
	
    // Added Against ML-MMOH-CRF-1939-US3...starts
	String facility_id		= (String)session.getValue("facility_id") ;
	String tab_name = checkForNull(request.getParameter("tab_name"));
	Connection conn = null;
	String Include_Fpp_yn = "N";
	boolean isIncludeFpp = false; 
	Integer Fpp_count = 0;
	
	String bean_id = "OTCommonBean";
	String bean_name = "eOT.OTCommonBean";
	OTCommonBean bean = (OTCommonBean)mh.getBeanObject( bean_id, request, bean_name );

	String ot_bean_id = "OTBillingBean";
	String ot_bean_name= "eOT.OTBillingBean";
	OTBillingBean billing_bean			= (OTBillingBean)mh.getBeanObject( ot_bean_id, request,ot_bean_name  ) ;
try{
	conn = ConnectionManager.getConnection(request);
	Include_Fpp_yn = checkForNull(bean.getIncludeFpp(facility_id));
	System.err.println("Include_Fpp_yn === "+Include_Fpp_yn);
	
	isIncludeFpp = CommonBean.isSiteSpecific(conn,"OT","OT_FPP");
	System.err.println("isIncludeFpp --->"+isIncludeFpp);
    //isIncludeFpp = true;
	
	Fpp_count = bean.getFppIcon();
}catch(Exception ex){
	System.err.println("Error in SurgeonOper Details"+ex);		
}finally{
	ConnectionManager.returnConnection(conn, request);
}	
	// Added Against ML-MMOH-CRF-1939-US3...ends 
%>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script type='text/javascript' src='../../eOT/js/RecordSurgeon.js'></script>
<script language="JavaScript" src="../../eOT/js/Hashtable.js"></script>
<Script src="../../eMP/js/jquery.min.js"></Script>	
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>  
<link href="../../eCommon/html/jquery-ui.css" rel="stylesheet" type="text/css">
<script language="javascript">
// modified by DhanasekarV against remarks
//var remarks_value=getLabel("Common.remarks.label","common");

var remarks_value=getLabel("eOT.PreOperativeComments.Label","ot");
//Added Against ML-MMOH-CRF-1939-US3...starts
var fppForNursing = "";
var selected_value;
function getFPP(){
    var fpp_Cat = document.getElementById("fpp_Cat");
	var selected_value = fpp_Cat.options[fpp_Cat.selectedIndex].value;
//	alert(selected_value.value);
}
//Added Against ML-MMOH-CRF-1939-US3...ends
function sendparams(index){
	$("#fpp_Cat"+index).prop('disabled', false);  // ML-MMOH-CRF-1939- US3
	<% if(tab.equals("record_surgeon")) {%>
		var rows = parent.parent.ObjectCollect.rows[index];

	<% } else if(tab.equals("record_nursing")){ %>
		var rows = parent.parent.parent.ObjectCollect.rows[index];
	<% } %>
	var code=rows.oper_code;
    var desc=rows.oper_desc;
    var sideapplicable=rows.side_applicable;
	var remarks=rows.remarks;
	//remarks=encodeURIComponent(remarks,"UTF-8"); //commemted for remarks issue by Anitha scf-6081
	var cancel_remarks=rows.cancel_remarks;
	var mode = "U";
	var side_applicable_yn=rows.side_applicable_yn;
	var color=rows.color;
	var chk_status=rows.chk_status;
	var spec_code=rows.Speciality_code;
	var fpp_category=rows.fpp_category;
	if(chk_status =="99")
	{
		parent.parent.parent.frames[5].frames[1].document.forms[0].chk_status.checked=true;
		parent.parent.parent.frames[5].frames[1].document.getElementById("remarks_one").innerText=getLabel("eOT.CancelledRemarks.Label","eOT");
	}else
	{
	   parent.parent.parent.frames[5].frames[1].document.forms[0].chk_status.checked=false;
	    // Modified by DhanasekarV against remarks
		   parent.parent.parent.frames[5].frames[1].document.getElementById("remarks_one").innerText=getLabel("eOT.PreOperativeComments.Label","ot");
	//   parent.parent.parent.frames[5].frames[1].document.getElementById("remarks_one").innerText=getLabel("Common.remarks.label","Common");
	}
	parent.parent.parent.frames[5].frames[1].document.forms[0].chk_status.disabled=false;
	parent.parent.parent.frames[5].frames[1].document.forms[0].remarks_hidden.value=rows.remarks;


	/*Below chk_status and index variables were added for the incident 16685 by Suma */
	var str = code+"::"+desc+"::"+sideapplicable+"::"+remarks+"::"+mode+"::"+side_applicable_yn+"::"+color+"::"+cancel_remarks+"::"+chk_status+"::"+index+"::"+spec_code+"::"+fpp_category;
	var frmObj = parent.parent.frames[5].frames[1];
	frmObj.splitString(str);
}
function fppSurgeon(val)
{
parent.frames[1].document.forms[0].fpp_category.value = val;	//RecordOperationForm
}

function openDialogWindow(strVal,index){

		var tab_value=document.forms[0].tab.value
		var rows = parent.parent.parent.ObjectCollect.rows[index];
		var strVal=strVal;
		var remarks=rows.remarks;
		//Added encodeURIComponent on 11/29/2010 by Anitha scf-6081
		remarks=encodeURIComponent(remarks,"UTF-8");
		var chk_status=rows.chk_status; 
		var cancel_remarks=rows.cancel_remarks; 
		
		var oper_num="";
		if(tab_value=="record_surgeon"){
			oper_num = parent.parent.common_patient_hdr_frame.document.forms[0].oper_num.value;
		}else if(tab_value=="record_nursing"){
			oper_num=parent.frames[0].document.forms[0].oper_num.value;
		}

	var temp_check=remarks.substring(0,1);
	/*if(temp_check!="%"){
		remarks=encodeURIComponent(remarks,"UTF-8");
	}*/

		var temp_check_canc=cancel_remarks.substring(0,1);
	if(temp_check_canc!="%"){
		cancel_remarks=encodeURIComponent(cancel_remarks,"UTF-8");
	}
			var called_from="Operation_Dtls";
			var temp_index=index+1
				var flag="1"	;
		var size="100";
// Modiifed by DhanasekarV against remarks
	//	var heading = getLabel("Common.remarks.label","common");
	var heading = getLabel("eOT.PreOperativeComments.Label","ot");
		var dialogHeight		= "9";
		var dialogWidth			= "32";
		var features			="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
		var arguments			= "";
var param='index='+temp_index+'&called_from='+called_from+'&oper_num='+oper_num+'&cancel_remarks='+cancel_remarks+'&chk_status='+chk_status+'&size='+size+'&remarks='+remarks+'&heading='+encodeURIComponent(heading);


window.showModalDialog("../../eOT/jsp/TextArea.jsp?"+param,arguments,features);

}

async function showBillingWindow(str,index){
	    var rows = parent.parent.parent.ObjectCollect.rows[index];
		var arr = str.split("::");
		var panel_str_key="";
		var flag = (rows.order_line_no.length>0)?"OLD":"NEW";
		if(flag=="OLD"){
			var post_flag = (rows.posted_yn=="X")?true:false;
			if(post_flag){
				var oper_num = parent.parent.common_patient_hdr_frame.document.forms[0].oper_num.value;
				var module_id="OT";    
				var order_id= oper_num;
		        var order_line_no=arr[1];
				var key=rows.order_id;
				var key_line_no=arr[1];
			}else{
				var module_id="OR";    
				var order_id= rows.order_id;
		        var order_line_no=arr[1];
				var key=rows.order_id;
				var key_line_no=arr[1];
		   }
		}else{
			var module_id="OR";    
			var order_id="";
	        var order_line_no="";
			var key=arr[0]; 
			var key_line_no="";
		}
		var order_catalog_code=rows.order_catalog_code; 
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
        var bean_id=""; 
        var dialogTop = "100";
        var dialogHeight = "30" ;
        var dialogWidth = "70" ;
        var features= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
        var title=encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"));
		 var arguments = "" ;
        var column_sizes = "";
            var column_descriptions ="";       
            if(rows.db_mode != "I") //050795
            	key_line_no = arr[20];//050795
            var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"episode_type="+episode_type+"&"+"patient_id="+patient_id+"&"+"visit_id="+visit_id+"&"+"episode_id="+episode_id+"&"+"service_panel_code="+service_panel_code+"&"+"service_panel_ind="+service_panel_ind+"&"+"service_date="+service_date+"&"+"order_catalog_code="+order_catalog_code+"&"+"module_id="+module_id+"&encounter_id="+encounter_id+"&key="+key+"&key_line_no="+key_line_no+"&order_id="+order_id+"&order_line_no="+order_line_no+"&bean_id="+bean_id; 
			var retVal = await window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?"+param,arguments,features);
			if(retVal!=null){
				var retArray  = retVal;
				var arr = rows.bill_str.split("::");
				if(arr[6]=='L')
				{
				retArray[6]=null;
				retArray[7]=null;

				}
				rows.bill_str = retArray[1]+"::"+retArray[2]+"::"+retArray[3]+"::"+arr[3]+"::"+retArray[6]+"::"+arr[5]+"::"+arr[6]+"::"+retArray[7]+"::"+retArray[8]+"::"+arr[9];


				rows.rate = retArray[5];
				rows.db_mode = (flag=="OLD")?"U":"I";
				var pnl_str =  getPanelStr(index);
				rows.panel_str =pnl_str.split("::")[13];
				createTable();
			}
}

function trimString(sInString){
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}


function getPanelStr(index){
	var rows = parent.parent.ObjectCollect.rows[index];
	var order_id = rows.order_id;
	var order_line_num = rows.order_line_no;
	var oper_code = rows.oper_code;
	var patient_id = parent.parent.common_patient_hdr_frame.document.forms[0].patient_id.value;
	var param = "order_id="+order_id+"&order_line_num="+order_line_num+"&oper_code="+oper_code+"&patient_id="+patient_id+"&called_from=RECORD_SURGEON";
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	return responseText;
}

function callBillingWindow(index)
{
	var rows = parent.parent.ObjectCollect.rows[index];
	var order_id = rows.order_id;
	var order_line_num = rows.order_line_no;
	var oper_code = rows.oper_code;
	var patient_id = parent.parent.common_patient_hdr_frame.document.forms[0].patient_id.value;
	var param = "order_id="+order_id+"&order_line_num="+order_line_num+"&oper_code="+oper_code+"&patient_id="+patient_id+"&called_from=RECORD_SURGEON";
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="GetBillDetailsFromPersistence.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	showBillingWindow(responseText,index);
		
}

 function trimString(sInString) {
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

//
function getErrtext(err_id){
    var sql="SELECT MESSAGE_TEXT_SYSDEF FROM SM_MESSAGE WHERE MESSAGE_ID ='"+err_id+"' ";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root></root>";
	var param="flag=MED_SER&sql="+sql;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = xmlHttp.responseText;

	return retVal;
}


function callErrMsg(err_id){
	  var err_txt=getMessage(err_id,"BL");
	  alert(err_txt);
	  window.close();
}


function hideToolTip(){
  document.getElementById("tooltiplayer3").style.visibility = 'hidden';
}
function createTable(){
  var isIncludeFpp = document.getElementsByName("isIncludeFpp")[0].value;
  var objFrm = parent.parent.parent.ObjectCollect;
  var tab_name = document.forms[0].tab_name.value;
  var bill_flag=document.forms[0].bill_flag.value;
  var mode='<%=mode_one%>';
  var tab_data="";
  var bill_data="";
  var oper_code="";
  var side_applicable="";
  var remarks="";
  var chk_status="";
  var cancel_remarks="";
  var oper_line_status="";
  var oper_line_num="";
  var fpp_category="";
  var doc_send_val="";
  var obj=document.getElementById("test");
  tab_data="<table border='1' cellpadding='3' cellspacing='0' width='100%' align='center'>"
  tab_data+="<td nowrap class='columnHeaderCenter'><fmt:message key="eOT.OperationCode.Label" bundle="${ot_labels}"/> </td>"
  tab_data+="<td nowrap class='columnHeaderCenter'> <fmt:message key="Common.description.label" bundle="${common_labels}"/> </td>"
  tab_data+="<td nowrap class='columnHeaderCenter'><fmt:message key="eOT.SideApplicable.Label" bundle="${ot_labels}"/></td>"
// Modified by DhanasekarV against remarks
  tab_data+="<td nowrap class='columnHeaderCenter'><fmt:message key="eOT.PreOperativeComments.Label" bundle="${ot_labels}"/></td>"  
//  tab_data+="<td nowrap class='columnHeaderCenter'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>"   
    <% 
	if(bill_flag.equals("true")){
	%> 
  
  tab_data+="<td nowrap class='columnHeaderCenter'><fmt:message key="Common.Charge.label" bundle="${common_labels}"/></td>";
  tab_data+="<td nowrap class='columnHeaderCenter'></td>";
				  <%} %>
  tab_data+="<td nowrap class='columnHeaderCenter'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>"  

   
		if(objFrm.rows!=null){
	  for(var jj=0;jj<objFrm.rows.length;jj++) {
		  if(objFrm.rows[jj]!=null  && objFrm.rows[jj].db_mode!='D'){
			   oper_code=objFrm.rows[jj].oper_code;
			   
			   	
			   oper_desc=objFrm.rows[jj].oper_desc;        
			   side_applicable=objFrm.rows[jj].side_applicable;
			   side_applicable_desc=objFrm.rows[jj].side_applicable_desc;
			   chk_status=objFrm.rows[jj].chk_status;
			    cancel_remarks=objFrm.rows[jj].cancel_remarks;
			    remarks=objFrm.rows[jj].remarks;
			    oper_line_num=objFrm.rows[jj].line_no;
			    oper_line_status=objFrm.rows[jj].oper_line_status;
			   if(chk_status !="99" && oper_line_num!=null)
				{
					chk_status="";
					doc_send_val += oper_line_num +",";
					<% if(tab.equals("record_surgeon") ){%>
					parent.parent.frames[4].document.forms[0].doc_oper_line_sent.value=doc_send_val;
					<%}else
					{%>
						parent.parent.parent.frames[3].document.forms[0].doc_oper_line_sent.value=doc_send_val;
					<%}%>
				}
				
			 if(jj%2==0)
			     qryVal="gridData";
			   else
				 qryVal="gridData";
			
			  <% if(tab.equals("record_surgeon") && (proc_chrg_cmp_yn.equals("N") || proc_chrg_cmp_yn.equals("") ) && ("true").equals(bill_flag)) { %>
				   tab_data+="<tr>";
			  if(oper_line_status!="99" ) 
			  {
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:sendparams("+jj+");\">"+oper_code+"</a></td>";
			}else
				 {	
				   tab_data+="<td nowrap class="+qryVal+">"+oper_code+"</td>";
			  }
				   tab_data+="<td nowrap class="+qryVal+">"+objFrm.rows[jj].oper_desc+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+objFrm.rows[jj].side_applicable_desc+"</td>";
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow(remarks_value,'"+jj+"');\"><fmt:message key="eOT.PreOperativeComments.Label" bundle="${ot_labels}"/></a><input type='hidden' name='chk_status' id='chk_status' value='"+chk_status+"'><input type='hidden' name='cancel_remarks' id='cancel_remarks' value='"+cancel_remarks+"'></td>";
				   var arr = objFrm.rows[jj].bill_str.split("::");
				   var tot_pay="0.0"; //Added by Daniel against 25937
				   var include_exclude="";
				   var Appr_reqd="";
				   var pat_pay="0.0";
				   var pat_paid="0.0";
				   var fpp_yn = "N";
				   if(arr !="")
				  {
					 include_exclude=arr[8];
					 tot_pay=arr[0];//Added by Daniel against 25937
					 Appr_reqd=arr[5];
					 pat_pay=arr[1];
					 pat_paid=arr[2];
					 fpp_category=objFrm.rows[jj].fpp_category;
					if(isIncludeFpp == 'true')
					{						
				var ar=new Array();
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
				fpp_yn=ar[0];
				}
				  }
				  }
				  /*if((fpp_category == "S" || fpp_category == "M" || fpp_category == "C") && tab_name == 'SCHEDULED')
					  fpp_yn = "Y";
				  else
					  fpp_yn = "N";
				  } */
				   var selected1 = "";
				var selected2 = "";
				var selected3 = "";
					if(fpp_category === 'S') selected1="selected";
					if(fpp_category === 'M') selected2="selected";
					if(fpp_category === 'C') selected3="selected";

				   if(arr[9]=="" || arr[9]=="undefined" || arr[9]==null){
					if(oper_line_status!="99" ) {
				// tab_data+="<td  class=gridData><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson'>&nbsp;<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+pat_pay+"</font>&nbsp;&nbsp;<font color='green'><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+pat_paid+"</font></B><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/>&nbsp";
				//Added Against ML-MMOH-CRF-1939-US3...starts
				if(fpp_yn == 'Y'){
				<% if(Include_Fpp_yn.equals("Y") && isIncludeFpp && Fpp_count==1 && tab_name.equals("SCHEDULED")){%>
                   tab_data+="<td  class=gridData><B><font color='blue' ><fmt:message key="eOT.FppCategory.Label" bundle="${ot_labels}"/>:&nbsp<select name='fpp_Cat"+jj+"' id='fpp_Cat"+jj+"' id='fpp_Cat"+jj+"' onChange='javascript:fppSurgeon(this.value)'; disabled ><option value='S' "+selected1+" ><fmt:message key="eOT.Simple.Label" bundle="${ot_labels}"/></option><option value='M' "+selected2+" ><fmt:message key="eOT.Moderate.Label" bundle="${ot_labels}"/></option><option value='C' "+selected3+"  ><fmt:message key="eOT.Complex.Label" bundle="${ot_labels}"/></option></select>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;"+tot_pay+"</font>&nbsp;&nbsp;<font color='crimson'>&nbsp;<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+pat_pay+"</font>&nbsp;&nbsp;<font color='green'><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+pat_paid+"</font></B><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/>&nbsp";
				<% }else{%>
					tab_data+="<td  class=gridData><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;"+tot_pay+"</font>&nbsp;&nbsp;<font color='crimson'>&nbsp;<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+pat_pay+"</font>&nbsp;&nbsp;<font color='green'><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+pat_paid+"</font></B><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/>&nbsp";
				<%}%>				
				}
				else{
					//Added Against ML-MMOH-CRF-1939-US3...ends
				   tab_data+="<td  class=gridData><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;"+tot_pay+"</font>&nbsp;&nbsp;<font color='crimson'>&nbsp;<fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+pat_pay+"</font>&nbsp;&nbsp;<font color='green'><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+pat_paid+"</font></B><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/>&nbsp";
				}	//Added Against ML-MMOH-CRF-1939-US3...
				   if(arr[6]=="S")
						{
				   if(include_exclude=="I") {
					    tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
					   }else if(include_exclude=="E"){
						    tab_data+="<img width=15px  src='../../eCommon/images/disabled.gif'></img>";
					  }

				   tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";

				    if(Appr_reqd=="Y") {
					    tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
					   }else if(Appr_reqd=="N") {
						    tab_data+="<img  width=15px src='../../eCommon/images/disabled.gif'></img>";
					}

				 tab_data+="</font></td>";
						}else{


								   if(include_exclude=="I") {
					    tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
					   }else if(include_exclude=="E") {
						    tab_data+="<img width=15px  src='../../eCommon/images/blank.gif'></img>";
					  }
				   
				   tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";

				    if(Appr_reqd=="Y") {
					    tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
					   }else if(Appr_reqd=="N") {
						    tab_data+="<img  width=15px src='../../eCommon/images/blank.gif'></img>";
					}
				   
				 tab_data+="</font></td>";
			}

				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow("+jj+");\"><img src='../../eOT/images/dollar.png'></img></a></td>"
				  }else {
					    tab_data+="<td nowrap class=gridData><B><font color='Indigo' >&nbsp</td>";
					
						tab_data+="<td nowrap class="+qryVal+">&nbsp</td>"
					   }
					
				   }else{
				   var err_txt=getMessage(arr[9],"BL");//Maheshwaran K has modified for the ML-BRU-SCF-0721 [IN:038279] as on 06/03/2013
				   alert(err_txt);
				   window.close();
				   }
				    if(chk_status=="99") {
				    tab_data+="<td nowrap class="+qryVal+"><img src='../../eCommon/images/RRnwd.gif'></img></td>";
					}else
				   {
					 tab_data+="<td nowrap class="+qryVal+">&nbsp;</td>";
					}
					
			   <% }
			     else if(tab.equals("record_surgeon") && ("false").equals(bill_flag)){
				  %> 
				   tab_data+="<tr>";
				if(oper_line_status!="99") {
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:sendparams("+jj+");\">"+oper_code+"</a></td>";
				}else
				 {
				   tab_data+="<td nowrap class="+qryVal+">"+oper_code+"</td>";
				}
				
				    tab_data+="<td nowrap class="+qryVal+">"+objFrm.rows[jj].oper_desc+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+objFrm.rows[jj].side_applicable_desc+"</td>";
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow(remarks_value,'"+jj+"');\"><fmt:message key="eOT.PreOperativeComments.Label" bundle="${ot_labels}"/><input type='hidden' name='chk_status' id='chk_status' value='"+chk_status+"'></a></td>";
				   
					if(chk_status=="99") {
				    tab_data+="<td nowrap class="+qryVal+"><img src='../../eCommon/images/RRnwd.gif'></img></td>";
					}else
				   {
					 tab_data+="<td nowrap class="+qryVal+">&nbsp;</td>";
					}
					 tab_data+="<tr>";
					<%}else if(tab.equals("record_nursing") && ("true").equals(bill_flag)) { %>	
				   tab_data+="<tr>";
				   tab_data+="<td nowrap class="+qryVal+">"+oper_code+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+objFrm.rows[jj].oper_desc+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+objFrm.rows[jj].side_applicable_desc+"</td>";
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow(remarks_value,'"+jj+"');\"><fmt:message key="eOT.PreOperativeComments.Label" bundle="${ot_labels}"/><input type='hidden' name='chk_status' id='chk_status' value='"+chk_status+"'><input type='hidden' name='cancel_remarks' id='cancel_remarks' value='"+cancel_remarks+"'></a></td>";
				   if(chk_status!="99" ) {
				   var arr = objFrm.rows[jj].bill_str.split("::");
				   var include_exclude="";
				   var Appr_reqd="";
				   var pat_pay="0.0";
				   var pat_paid="0.0";
				   if(arr !="")
				  {
					 include_exclude=arr[8];
					 Appr_reqd=arr[5];
					 pat_pay=arr[1];
					 pat_paid=arr[2];
				  
				  var fpp_yn="N";
				  fppForNursing =localTrimString(objFrm.rows[jj].fpp_category);
				  if(isIncludeFpp == 'true'){
				var ar=new Array();
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
				fpp_yn=ar[0];
				}
				  }
				  }
				   if(fppForNursing === 'S') fppForNursing="Simple";
				   if(fppForNursing === 'M') fppForNursing="Moderate";
				   if(fppForNursing === 'C') fppForNursing="Complex";
				   if(fpp_yn=="Y")
				   {
				  //Added Against ML-MMOH-CRF-1939-US3...starts
				  <%if(Include_Fpp_yn.equals("Y") && isIncludeFpp && Fpp_count==1 && tab_name.equals("SCHEDULED")){%>
				   tab_data+="<td  class=gridData><B><font color='Indigo' ><fmt:message key="eOT.FppCategory.Label" bundle="${ot_labels}"/>:&nbsp"+fppForNursing+"&nbsp;<fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson' ><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+pat_pay+"</font>&nbsp;&nbsp;<font color='green' ><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+pat_paid+"</font></b><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/>&nbsp";
				  <%}else{%>
				   tab_data+="<td  class=gridData><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson' ><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+pat_pay+"</font>&nbsp;&nbsp;<font color='green' ><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+pat_paid+"</font></b><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/>&nbsp";
				   <%}%>
				   }
				   else{
				  //Added Against ML-MMOH-CRF-1939-US3...ends
				   tab_data+="<td  class=gridData><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson' ><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+pat_pay+"</font>&nbsp;&nbsp;<font color='green' ><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+pat_paid+"</font></b><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/>&nbsp";
				   }
				  //Added Against ML-MMOH-CRF-1939-US3...
				if(arr[6]=="S")
						{

				   if(include_exclude=="I") {
					    tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
					   }else if(include_exclude=="E") {
						    tab_data+="<img width=15px  src='../../eCommon/images/disabled.gif'></img>";
					  }
				   
				   tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";

				    if(Appr_reqd=="Y") {
					    tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
					   }else if(Appr_reqd=="N") {
						    tab_data+="<img  width=15px src='../../eCommon/images/disabled.gif'></img>";
					}
						}else
					   {
									   if(include_exclude=="I") {
					    tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
					   }else if(include_exclude=="E") {
						    tab_data+="<img width=15px  src='../../eCommon/images/blank.gif'></img>";
					  }
				   
				   tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";

				    if(Appr_reqd=="Y") {
					    tab_data+="<img width=15px src='../../eCommon/images/blank.gif'></img>";
					   }else if(Appr_reqd=="N"){
						    tab_data+="<img  width=15px src='../../eCommon/images/blank.gif'></img>";
					}

						}
				 tab_data+="</font></td>";

				tab_data+="<td nowrap class="+qryVal+">&nbsp;</td>";
				   }else
					  {
						  tab_data+="<td nowrap class="+qryVal+">&nbsp;</td>";
						  tab_data+="<td nowrap class="+qryVal+">&nbsp;</td>";
					 }
					if(chk_status=="99") {
				    tab_data+="<td nowrap class="+qryVal+"><img src='../../eCommon/images/RRnwd.gif'></img></td>";
					}else
				   {
					 tab_data+="<td nowrap class="+qryVal+">&nbsp;</td>";
					}
				   tab_data+="</tr>";
			   <%}else if(tab.equals("record_nursing") && ("false").equals(bill_flag)) { %>		
				  //remarks=encodeURIComponent(remarks);
				//  cancel_remarks=encodeURIComponent(cancel_remarks);
				   tab_data+="<tr>";
				   tab_data+="<td nowrap class="+qryVal+">"+oper_code+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+objFrm.rows[jj].oper_desc+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+objFrm.rows[jj].side_applicable_desc+"</td>";
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink'  href=\"javascript:openDialogWindow(remarks_value,'"+jj+"');\"><fmt:message key="eOT.PreOperativeComments.Label" bundle="${ot_labels}"/><input type='hidden' name='chk_status' id='chk_status' value='"+chk_status+"'><input type='hidden' name='cancel_remarks' id='cancel_remarks' value='"+cancel_remarks+"'></a></td>";
				   if(chk_status=="99") {
				    tab_data+="<td nowrap class="+qryVal+"><img src='../../eCommon/images/RRnwd.gif'></img></td>";
					}else
				   {
					 tab_data+="<td nowrap class="+qryVal+">&nbsp;</td>";
					}
				   tab_data+="</tr>";
			  <%}else{ %>
			
				   tab_data+="<tr>";
				   tab_data+="<td nowrap class="+qryVal+">"+oper_code+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+objFrm.rows[jj].oper_desc+"</td>";
				   tab_data+="<td nowrap class="+qryVal+">"+objFrm.rows[jj].side_applicable_desc+"</td>";
				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:openDialogWindow(remarks_value,'"+jj+"');\"><fmt:message key="eOT.PreOperativeComments.Label" bundle="${ot_labels}"/><input type='hidden' name='chk_status' id='chk_status' value='"+chk_status+"'><input type='hidden' name='cancel_remarks' id='cancel_remarks' value='"+cancel_remarks+"'></a></td>";
				   if(chk_status!="99" ) {
				   var arr = objFrm.rows[jj].bill_str.split("::");
				   var Appr_reqd="";
				   var include_exclude="";
				   var pat_pay="0.0";
				   var pat_paid="0.0";
				   if(arr !="")
						 {
					  include_exclude=arr[8];
					 Appr_reqd=arr[5];
					 pat_pay=arr[1];
					 pat_paid=arr[2];
						 }

				   tab_data+="<td  class=gridData><B><font color='Indigo' ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eOT.Payable.Label" bundle="${ot_labels}"/>:&nbsp;"+arr[0]+"</font>&nbsp;&nbsp;<font color='crimson' ><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/>:&nbsp;"+arr[1]+"</font>&nbsp;&nbsp;<font color='green' ><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/>:&nbsp;"+arr[2]+"</font><font color='Indigo'><fmt:message key="eOT.Included.Label" bundle="${ot_labels}"/>&nbsp";
				   if(include_exclude=="I") {
					    tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
					   }else if(include_exclude=="E") {
						    tab_data+="<img width=15px  src='../../eCommon/images/disabled.gif'></img>";
					  }
				   
				   tab_data+="<fmt:message key="eOT.ApprovalRequired.Label" bundle="${ot_labels}"/>&nbsp";

				    if(Appr_reqd=="Y") {
					    tab_data+="<img width=15px src='../../eCommon/images/enabled.gif'></img>";
					   }else  if(Appr_reqd=="N")  {
						    tab_data+="<img  width=15px src='../../eCommon/images/disabled.gif'></img>";
					}
				   
				 tab_data+="</font></B></td>";

				   tab_data+="<td nowrap class="+qryVal+"><a class='gridLink' href=\"javascript:callBillingWindow("+jj+");\"><img src='../../eOT/images/dollar.png'></img></a></td>";
					 }else
					  {
						  tab_data+="<td nowrap class="+qryVal+">&nbsp;</td>";
						  tab_data+="<td nowrap class="+qryVal+">&nbsp;</td>";
					 }
				   if(chk_status=="99") {
				    tab_data+="<td nowrap class="+qryVal+"><img src='../../eCommon/images/RRnwd.gif'></img></td>";
					}else
				   {
					 tab_data+="<td nowrap class="+qryVal+">&nbsp;</td>";
					}
				   tab_data+="</tr>";
				<% } %>
	   }
	 }
	 
  }

  document.getElementById("test").innerHTML = tab_data;
  document.getElementById("test").style.visibility='visible';
}


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad='createTable(); ' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='OperationDetailForm' id='OperationDetailForm' >

<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
<input type='hidden' name='bill_flag' id='bill_flag' value="<%=bill_flag%>" >
<input type='hidden' name='tab' id='tab' value="<%=tab%>" >
<input type='hidden' name='tab_name' id='tab_name' value="<%=tab_name%>" >
<input type='hidden' name='proc_chrg_cmp_yn' id='proc_chrg_cmp_yn' value="<%=proc_chrg_cmp_yn%>" >
<input type='hidden' name='isIncludeFpp' id='isIncludeFpp' value="<%=isIncludeFpp%>" >
</form>
<div id='test'></div>
<div id='tooltiplayer3' style='position:relative; width:28%; visibility:hidden;' bgcolor='blue'> 
</div>
</body>
</html>


