<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.sql.CallableStatement,webbeans.eCommon.ConnectionManager,eCommon.Common.*,eOT.*,eOT.Common.*,eOR.OrderEntryBillingQueryBean,java.util.ArrayList" contentType=" text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%  
	 String locale = (String)session.getAttribute("LOCALE"); 
	 request.setCharacterEncoding("UTF-8");	
	String or_bean_id 				= "Or_billingQueryBean";
	String or_bean_name 			= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean			= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	
	String bean_id 				= "OTBillingBean";
	String bean_name 			= "eOT.OTBillingBean";
	OTBillingBean billing_bean			= (OTBillingBean)getBeanObject( bean_id, bean_name, request ) ;
%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<%	String tab = checkForNull(request.getParameter("tab")); 
	String params = request.getQueryString();
	if(tab.equals("record_surgeon")){ %>
		<script language="JavaScript" src="../../eOT/js/RecordSurgeon.js"></script>
		<script language="JavaScript"> var lblRemarksDiag=getLabel("Common.remarks.label","Common");	</script>
   <%}else if(tab.equals("record_nursing")){ %>
	<script language="JavaScript" src="../../eOT/js/RecordNursing.js"></script>
	<script language="JavaScript"> 
		var lblRemarksDiag=getLabel("Common.remarks.label","Common");	
	</script>
   <%}%>

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

<script language='javascript'>

  var rightSide_title=getLabel("eOT.RightSide.Label","ot");
  var leftSide_title=getLabel("eOT.LeftSide.Label","ot");
  var notApplicable_title=getLabel("Common.notapplicable.label","common");
  var bilateral_title=getLabel("eOT.Bilateral.Label","ot");
  var operation_title=getLabel("Common.operation.label","common");
  var sideApplicable_title=getLabel("eOT.SideApplicable.Label","ot");

  function Class_row(){
     this.oper_code ="";
     this.oper_desc ="";
     this.side_applicable ="";
	 this.side_applicable_desc="";
     this.remarks = "";
	 this.line_no="";
	 this.side_applicable_yn="";
	 this.proc_link="";
	 this.proc_result="";
	 this.term_id="";
	 this.term_code="";
	 this.term_desc="";
	 this.color="";
	 this.order_line_no="";
	 this.order_id="";
	 this.db_mode="";
	 this.bill_str="";
	 this.panel_str="";
	 this.posted_yn="";
	 this.rate="";
	}

/* function moveMandatoryOperations(){
var rows=parent.parent.ObjectCollect.rows;
	for( var j in rows){
		if( rows[j].db_mode!="D" && rows[j].color=="MANDATORY" ){
			 
		}
	}

}*/

/*function disableDocLevel(){
   var formObj = parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
   if(formObj.doc_level.disabled==false)
	   formObj.doc_level.disabled=true;
}*/


function loadDBRows(line_no,oper_code,oper_desc,side_applicable,remarks,proc_link,proc_result,term_id,term_code,color,term_desc,order_line_no,order_id,bill_str,panel_str,mode,oper_line_status,cancel_remarks){ 
	
  var rowLeng=parent.parent.parent.ObjectCollect.rowLength;
  var rows = parent.parent.parent.ObjectCollect.rows;
 
  if(mode=='L' && rowLeng==0){
	   var objrow = newRow();
	   objrow.oper_code=oper_code;
	   objrow.oper_desc=unescape(oper_desc);
	   objrow.side_applicable=side_applicable;
	   if(side_applicable=="R"){
		  objrow.side_applicable_desc=rightSide_title;
		  objrow.side_applicable_yn="Y";
	   }else if(side_applicable=='B'){
		   objrow.side_applicable_yn="Y";
		  objrow.side_applicable_desc=bilateral_title;
	   }else if(side_applicable=='L'){
		   objrow.side_applicable_yn="Y";
		  objrow.side_applicable_desc=leftSide_title;
	   }else if( side_applicable=='N' || side_applicable=='' ){
		   objrow.side_applicable_yn="N";
	      objrow.side_applicable_desc=notApplicable_title;
	   }
	   objrow.line_no=line_no;
	   objrow.remarks=unescape(remarks);
	   objrow.proc_link=proc_link;
	   objrow.proc_result=proc_result;
	   objrow.term_id=term_id;
	   objrow.term_code=term_code;
	   objrow.term_desc=term_desc;
	   objrow.color=color;
	   objrow.order_id = order_id
	   objrow.order_line_no=order_line_no;
	   objrow.db_mode="L";
	   objrow.chk_status=oper_line_status;
	   objrow.oper_line_status=oper_line_status;
	   objrow.cancel_remarks=unescape(cancel_remarks);
	   objrow.bill_str=bill_str;
	   objrow.posted_yn=bill_str.split("::")[4];
	   objrow.panel_str=panel_str;
	   objrow.rate="";
	   
	   rows.push(objrow);
	 }
}



function refresh(){

	var formObj = document.forms[0];
	var param = formObj.params.value
	var tab = formObj.tab.value;
	parent.ResultsFrame.location.href='../../eOT/jsp/SurgeonOperationDtls.jsp?'+param;

}


function chkEmpty(){
	var formObj = document.RecordOperationForm; 
	var side_applicable_yn = formObj.side_applicable_yn.value;
	if(side_applicable_yn=='N'){
		var fields = new Array(formObj.oper_code);
		var names = new Array(operation_title);
	}else{
		var fields = new Array(formObj.oper_code,formObj.side_applicable);
		var names = new Array(operation_title,sideApplicable_title);
	 }
	var messageFrame = parent.parent.messageFrame;
	if(checkFields( fields, names, messageFrame))
		return true;
}

function callPopulateList(flag){}

function addRow(oper_code,oper_desc,side_applicable,remarks,mode,chk_status,cancel_remarks){
	var formObj = document.forms[0];
	var tab = formObj.tab.value;
	var params2 = formObj.params.value;
	var bill_flag = formObj.bill_flag.value;
	var proc_chrg_cmp_yn = formObj.proc_chrg_cmp_yn.value;
	//alert("Enters in New Row");
	var objrow = newRow();
	//alert(parent.RecordFrame.frames[0].name);
	var rows=parent.parent.ObjectCollect.rows;
	//var msg="Code already selected.........";
	var msg=getMessage("CODE_ALREADY_EXISTS","Common");
	//alert(mode);
	if(chk_status !="99")
	{
		chk_status="";
	}
  if(chkEmpty()){
    if(mode=='I'){
	  if(alreadyExist(oper_code,mode)){
		if(bill_flag=="true")
		{
			var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params= "order_catalog_code="+oper_code;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=from_direct_booking&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal1 = trimString(xmlHttp.responseText);


		if(retVal1 =="Y")
			{
		var retVal = callOrderLineCreation();
		retVal=trimString(retVal);
		var arr = retVal.split("@@");
		//alert(arr[0]);
		//alert(arr[2]);
		if(arr[0]=="BL0639" && bill_flag=="true"){
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
		   objrow.oper_code=oper_code;
		   objrow.oper_desc=oper_desc;
		   objrow.side_applicable=side_applicable;
		   objrow.side_applicable_yn=formObj.side_applicable_yn.value;
			if(side_applicable=="R"){
				objrow.side_applicable_desc=rightSide_title;
				//objrow.side_applicable_yn="Y";
			}else if(side_applicable=='B'){
				//objrow.side_applicable_yn="Y";
				objrow.side_applicable_desc=bilateral_title;
			}else if(side_applicable=='L'){
				//objrow.side_applicable_yn="Y";
				objrow.side_applicable_desc=leftSide_title;
			}else if( side_applicable=='N' || side_applicable=='' ){
				//objrow.side_applicable_yn="N";
				objrow.side_applicable_desc=notApplicable_title;
			}   
			objrow.line_no=getOperLineNumber();
		    objrow.db_mode="I";
		    objrow.chk_status=chk_status;

		    objrow.cancel_remarks=escape(cancel_remarks);
		 	objrow.remarks=escape(remarks);
				with(formObj){
				   objrow.proc_link=proc_link.value;
				   objrow.proc_result=proc_result.value;
				   objrow.term_id=term_id.value;
				   objrow.term_code=term_code.value;
				   objrow.term_desc=term_desc.value;
				   objrow.color=color.value;
				   //Billing part called 
				  // var retval = callOrderLineCreation();
				  objrow.order_id = order_id.value;
				  objrow.order_line_no="";
		         }
				  if(bill_flag=="true")
		          {
					  if(retVal1 =="Y")
			{
				   var arr = retVal.split("@@");
				   objrow.panel_str=arr[0];
				   objrow.bill_str=arr[1];
			}
				  }
		   rows.push(objrow);
		   resetFields();
		   //parent.parent.RecordFrame.DetailFrame
		   //parent.parent.RecordFrame.DetailFrame.location.href='../../eOT/jsp/SurgeonOperationDtls.jsp?tab='+tab;
		var mode="I";
		document.forms[0].remarks_one.innerText=getLabel("Common.remarks.label","Common");
		var url_val='../../eOT/jsp/SurgeonOperationDtls.jsp?'+params2+'&mode_one='+mode;
		parent.ResultsFrame.location.href=url_val;
		   parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
	
	  }else
			parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
 } else
	  updateRow(oper_code,oper_desc,side_applicable,remarks,mode,chk_status,cancel_remarks);
  }

  	 /*Added by Suma for incident 16685 Starts here */

		var chk_val="";
	  var oper_desc_val="";
	  var oper_code_val="";
	  var status_value="";
		  if(rows!=null){
		   for (var jj=0;jj<rows.length ;jj++ )
		   {
			   var status_val=rows[jj].chk_status;
			   if(status_val =="")
			   {
				   status_val="1";
			   }
			   chk_val +=rows[jj].oper_code+"*" +status_val+"*"+rows[jj].db_mode+"$";
			   oper_desc_val +=rows[jj].oper_desc +"*";
			   oper_code_val +=rows[jj].oper_code +"*";
			   status_value +=status_val +"*";
		   }
		  }


				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "status_val="+chk_val;
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=new_operation&"+params,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				parent.parent.frames[5].euip_tab.OperationEquipmentsTabForm.oper_code_new.value=retVal;
				parent.parent.frames[5].euip_tab.OperationEquipmentsTabForm.oper_code_all.value=oper_code_val;
				parent.parent.frames[5].euip_tab.OperationEquipmentsTabForm.status_value.value=status_value;
				parent.parent.frames[5].euip_tab.OperationEquipmentsTabForm.oper_desc_val.value=oper_desc_val;

				/*16685 changes ends here*/

}

function assignRowLength(cou){
	//parent.parent.ObjectCollect.rowLength=cou;
	parent.parent.parent.ObjectCollect.rowLength=cou;
}


function newRow(){
  var objrow = new Class_row();
   return(objrow);
}

function alreadyExist(oper_code,mode){
	var rows=parent.parent.ObjectCollect.rows;
	if(rows.length>0 && mode=='I'){
		for(var jj=0;jj<rows.length;jj++){
			if(rows[jj]!=null ){
				if(rows[jj].oper_code==oper_code){
					return false;
					break;
				}
			continue;
		 }
	  }
	}
	return true;
}

/*function removeRow(oper_code,mode){
var formObj = document.forms[0];
var params = formObj.params.value;
var tab = formObj.tab.value;
var rows=parent.parent.ObjectCollect.rows;
if(rows.length==1){ 
	alert("All the Operation Cannot be Deleted...");resetFields(); return;}
if(rows.length>1 && mode=='U'){        
 for(var jj=0;jj<rows.length;jj++){
 if(rows[jj]!=null &&  rows[jj].oper_code!=null && rows[jj].oper_code!="") {
	 if(rows[jj].oper_code==oper_code){
		 if(rows[jj].db_mode=='I')
			//delete rows[jj];
			rows.splice(jj,1);
		 else
			rows[jj].db_mode='D';
	   break;
	 }
  }else
	continue;
 }//end for-Loop
   resetFields();
   parent.DetailFrame.location.href='../../eOT/jsp/SurgeonOperationDtls.jsp?'+params;
   parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
   //parent.parent.RecordFrame.DetailFrame.location.href='../../eOT/jsp/SurgeonOperationDtls.jsp?&tab='+tab;
 }else
   //parent.parent.RecordFrame.resetFields();
   resetFields();
}*/

function updateRow(oper_code,oper_desc,side_applicable,remarks,mode,chk_status,cancel_remarks){

 var formObj = document.forms[0];
 var params = formObj.params.value;
 var tab = formObj.tab.value;
 var rows=parent.parent.ObjectCollect.rows;
 if(rows.length>0 && mode=='U'){        
 for(var jj=0;jj<rows.length;jj++){
 if(rows[jj]!=null && rows[jj].oper_code!=null && rows[jj].oper_code!="") {
      if(rows[jj].oper_code==oper_code){
		  rows[jj].oper_code=oper_code;	
		  rows[jj].oper_desc=oper_desc;
		  rows[jj].side_applicable=side_applicable;
		  rows[jj].side_applicable_yn=formObj.side_applicable_yn.value;
		  if(side_applicable=="R"){
			  //objrow.side_applicable_yn="Y";
			rows[jj].side_applicable_desc=rightSide_title;
		  }else if(side_applicable=='B'){
			  //objrow.side_applicable_yn="Y";
			rows[jj].side_applicable_desc=bilateral_title;
	      }else if(side_applicable=='L'){
			  //objrow.side_applicable_yn="Y";
		    rows[jj].side_applicable_desc=leftSide_title;
	      }else if( side_applicable=='N' || side_applicable=='' ){
			  //objrow.side_applicable_yn="N";
	          rows[jj].side_applicable_desc=notApplicable_title;
	     }
		
		 rows[jj].remarks=escape(remarks);
		 rows[jj].cancel_remarks=escape(cancel_remarks);
		  if(rows[jj].db_mode=='L')
		  {
			rows[jj].db_mode='U'
		  }
		 rows[jj].chk_status=chk_status;
		    break;
	  }
  }else  
	  continue;
 }
   //parent.parent.RecordFrame.resetFields();
   resetFields();
   var mode="M";
   document.forms[0].remarks_one.innerText=getLabel("Common.remarks.label","Common");
   parent.ResultsFrame.location.href='../../eOT/jsp/SurgeonOperationDtls.jsp?'+params+'&mode_one='+mode;
   //parent.parent.RecordFrame.DetailFrame.location.href='../../eOT/jsp/SurgeonOperationDtls.jsp?&tab='+tab;
 }
}

function localTrimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}


function splitString(strVal){
    var arr = strVal.split('::');
	var frmObj = document.forms[0];
	frmObj.oper_code.value=arr[0];
	frmObj.oper_desc.value=arr[1];
	/*if(arr[2]=='Right Side')
	  frmObj.side_applicable.value='R';
     else if(arr[2]=='Both Sides')
		frmObj.side_applicable.value='B';
	 else if(arr[2]=='Left Side')
		 frmObj.side_applicable.value='L';*/
     frmObj.side_applicable.value = (arr[2]=='N')?"":arr[2];
if(arr[8] !="99")
{
	frmObj.remarks.style.visibility="visible";
	frmObj.remarks.style.display="inline";
	frmObj.cancel_remarks.style.visibility="hidden";
	frmObj.cancel_remarks.style.display="none";
}else
{
	frmObj.cancel_remarks.style.visibility="visible";
	frmObj.cancel_remarks.style.display="inline";
	frmObj.remarks.style.visibility="hidden";
	frmObj.remarks.style.display="none";
}

	 frmObj.remarks.value=unescape(arr[3]);
	 frmObj.cancel_remarks.value=unescape(arr[7]);



	frmObj.mode.value=arr[4];
	frmObj.side_applicable_yn.value=arr[5];
	frmObj.count_val.value=arr[9];

	//alert(frmObj.side_applicable_yn.value);
	frmObj.OperationLookUp.disabled=true;
	if(arr[5]!="Y")
		frmObj.side_applicable.disabled=true;
	else
		frmObj.side_applicable.disabled=false;
  }

function resetFields(){
	var frmObj = document.forms[0];
	frmObj.oper_code.value='';
	frmObj.oper_desc.value='';
	frmObj.side_applicable.value='';
	frmObj.remarks.value='';
	frmObj.cancel_remarks.value='';
	frmObj.mode.value='I';
	frmObj.side_applicable_yn.value='';
	frmObj.OperationLookUp.disabled=false;
	frmObj.OperationLookUp.focus();
	frmObj.chk_status.disabled=true;
	frmObj.chk_status.checked=false;
	//frmObj.btn_cancel.disabled=false;
}

function checkLimit(field, limit){
	 if (field.value.length > limit){
		   //alert(limit+'characters only allowed');

		   var msg = getMessage("MAX_LENGTH_DATA","OT");
		   var msgArray = msg.split("#");
		   alert(msgArray[0]+""+msgArray[1]+limit+msgArray[2]);

		   // Truncate at the limit
		   var revertField = field.value.slice(0, limit);
		   field.value = revertField;
		   field.focus();
	  }
}

function setOperLineNumber(line_no){
   //var frmObj = parent.parent.ObjectCollect;
 var  frmObj = parent.parent.parent.ObjectCollect;
   if(frmObj.line_no==0){
		frmObj.line_no = parseInt(line_no,10);
   }
   //alert("assing "+frmObj.line_no); 
}

function getOperLineNumber(){
   //frmObj = parent.parent.ObjectCollect;
	frmObj = parent.parent.parent.ObjectCollect;
   //alert("Before Incrementing "+frmObj.line_no);
  var line_no= (isNaN(frmObj.line_no)==true)?1:frmObj.line_no+1;
  // var line_no= (frmObj.line_no==Number.NaN)?1:frmObj.line_no+1;
   //alert("After Incrementing "+line_no);
   parent.parent.ObjectCollect.line_no = line_no;
   //alert("After  assing "+frmObj.line_no);
   return line_no;
}


function LoadMandatoryFlag(code,flag){
	var flag=true;
	rows = parent.parent.parent.ObjectCollect.mandatory_proc;
	if(rows.length!=0) 
	{
	for(var j in rows) {
		    alert("j==== " +j);
			alert("rows[j] :" +rows[j]);
			if(j==code)
			rows[code]=rows[j];		
	}
	}
	else {
	rows[code]=flag;
	}
	
}

function callOrderLineCreation(){
	var formObj = document.forms[0];
	var order_id = formObj.order_id.value;
	var oper_num = formObj.oper_num.value;
	var oper_code = formObj.oper_code.value;
	var param = "order_id="+order_id+"&oper_num="+oper_num+"&oper_code="+oper_code+"&called_from=RECORD_SURGEON";
	var xmlStr ="<root></root>";
	var temp_jsp="OTOrderLineCreation.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	//alert(responseText);
	return responseText;
}

function trimString(sInString) {
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

</script>
</HEAD>
<BODY OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name = 'RecordOperationForm'>
<input type='hidden' name='rowLength' id='rowLength' value='0'>
<input type='hidden' name='tab' id='tab' value='<%=tab%>'>
<input type='hidden' name='params' id='params' value='<%=params%>'>
<%
	
	String called_from = request.getParameter("called_from");
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String oper_num = checkForNull(request.getParameter("oper_num"));
	String surgeon_doc_comp_yn = checkForNull(request.getParameter("surgeon_doc_comp_yn"));
	String proc_chrg_cmp_yn = checkForNull(request.getParameter("proc_chrg_cmp_yn"));
	String bill_flag = request.getParameter("bill_flag");
	String disable_flag="";
	String line_no="";
	String oper_code="";
	String oper_desc="";
	String side_applicable="";
	String remarks="";
	String max_oper_num="";
	String proc_link=""; 
	String proc_result="";
	String term_set_id="";
	String term_code= ""; 
	String term_desc= ""; 
	String color= ""; 
	String proc_code_entered_yn="";
	String auto_populate_yn = "";
	String auto_param = "";
	String order_line_no = "";
	String order_id = "";
	String panel_str="";
	String posted_yn="";
	String module_id="";

	String oper_line_status="";
	String cancel_remarks="";
	//String service_panel_ind = "";
	//String service_panel_code = "";
	HashMap bill_info = new HashMap();
	StringBuilder bl_bfr = new StringBuilder();
	String bill_str  = "";
	//ArrayList lst = new ArrayList(2);
	

	

	/*String SQL = "SELECT A.OPER_CODE,A.OPER_LINE_NUM, B.SHORT_DESC,A.RIGHT_LEFT_FLAG,A.OPER_REMARKS FROM OT_POST_OPER_DTLS A, OT_OPER_MAST B WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE";*/
	
	/*
	 SELECT A.OPER_CODE, A.OPER_LINE_NUM, B.SHORT_DESC, A.RIGHT_LEFT_FLAG A.OPER_REMARKS, C.PROC_LINK_APPLICABLE,C.PROC_LINK_RESULTING_OPTION,C.TERM_SET_ID,C.TERM_CODE 
	 FROM OT_POST_OPER_DTLS A, OT_OPER_MAST B, OR_ORDER_CATALOG C
	 WHERE A.OPERATING_FACILITY_ID     = ? 
	 AND A.OPER_NUM                               = ? 
	 AND A.OPER_CODE                             = B.OPER_CODE
	 AND B.ORDER_CATALOG_CODE          = C.ORDER_CATABLOG_CODE

	
	*/


	/*SQL =SELECT A.OPER_CODE,A.OPER_LINE_NUM, B.SHORT_DESC,DECODE(A.RIGHT_LEFT_FLAG,'R','Right Side','L','Left Side','B','Both Sides') RIGHT_LEFT_FLAG,A.OPER_REMARKS FROM OT_POST_OPER_DTLS A, OT_OPER_MAST B WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE AND NVL(STATUS,'E')='E'*/

	/*String SQL1 = "SELECT MAX(OPER_LINE_NUM) FROM OT_POST_OPER_DTLS WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=?";*/

	String SQL ="SELECT A.OPER_CODE, A.OPER_LINE_NUM, B.SHORT_DESC, A.RIGHT_LEFT_FLAG, A.OPER_REMARKS,C.PROC_LINK_APPLICABLE,C.PROC_LINK_RESULTING_OPTION,C.TERM_SET_ID,TRIM(C.TERM_CODE) TERM_CODE,DECODE(PROC_LINK_RESULTING_OPTION,'M','MANDATORY','O','OPTIONAL',DECODE(C.PROC_LINK_APPLICABLE,'P','AUTO','NA')) COLOR,A.ORDER_LINE_NUM ORDER_LINE_NUM,A.ORDER_ID ORDER_ID,A.OPER_LINE_STATUS OPER_LINE_STATUS,A.CANCEL_REMARKS CANCEL_REMARKS FROM OT_POST_OPER_DTLS A, OT_OPER_MAST_LANG_VW B, OR_ORDER_CATALOG_LANG_VW C WHERE C.LANGUAGE_ID='"+locale+"' AND B.LANGUAGE_ID=? AND A.OPERATING_FACILITY_ID  = ? AND A.OPER_NUM  =?  AND A.OPER_CODE = B.OPER_CODE AND B.ORDER_CATALOG_CODE = C.ORDER_CATALOG_CODE";

		
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	//CallableStatement cstmt = null;
	ResultSet rst = null;	
	ResultSet rset = null;	
	ResultSet rset2 = null;	
		int count=0;
	try{
		con = ConnectionManager.getConnection(request);
		//pstmt = con.prepareStatement(SQL);
		//pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_OPERATIONS_SELECT1"));


	if(proc_chrg_cmp_yn.equals("Y"))
		disable_flag="disabled";
	else 
		disable_flag="";


		pstmt = con.prepareStatement(SQL);
		//for calling Billing Procedure
		//cstmt=con.prepareCall("{call BL_PROC_FOR_EXT_SERVICE_MP.GET_ORDER_CATALOG_DTLS(?,?,?,?,?,?,?,?,?,?)}");
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,oper_num);
		rst = pstmt.executeQuery();
	
		while(rst.next()){
			count++;
			line_no = checkForNull(rst.getString("OPER_LINE_NUM"));
			oper_code=checkForNull(rst.getString("OPER_CODE"));
			oper_desc= encode(checkForNull(rst.getString("SHORT_DESC")));
			side_applicable= checkForNull(rst.getString("RIGHT_LEFT_FLAG"));
			remarks=encode(checkForNull(rst.getString("OPER_REMARKS")));
			proc_link= checkForNull(rst.getString("PROC_LINK_APPLICABLE"));
			proc_result=checkForNull(rst.getString("PROC_LINK_RESULTING_OPTION"));
			term_set_id = checkForNull(rst.getString("TERM_SET_ID"));
			term_code  = checkForNull(rst.getString("TERM_CODE"));
			color  = checkForNull(rst.getString("COLOR"));

			//KEY and KEY_LINE_NO for Billing Key
			order_id = checkForNull(rst.getString("ORDER_ID"));
			oper_line_status = checkForNull(rst.getString("OPER_LINE_STATUS"));
			cancel_remarks= checkForNull(rst.getString("CANCEL_REMARKS"));
			order_line_no = checkForNull(rst.getString("ORDER_LINE_NUM"));
			posted_yn = billing_bean.billingPostedYN(oper_num,line_no);
			if(("true").equals(bill_flag)){
			bill_info = or_bean.getOrderBillDtls(order_id+order_line_no);	
			if(bill_info==null || (bill_info!=null && bill_info.size()==0)){
				bill_info = new HashMap();
				if("X".equals(posted_yn)){
					module_id = "OT";
					bill_info.put("key",oper_num);
				}else{
					module_id = "OR";
					bill_info.put("key",order_id);
				}
				bill_info.put("key_line_no",order_line_no);
				bill_info.put("oper_code",oper_code);
				bill_info.put("oper_num",oper_num);
				bill_info.put("locale",locale);
				bill_info.put("module_id",module_id);
				bill_info.put("quantity","1");
				bill_info.put("oper_line_status",oper_line_status);
				bill_info.put("cancel_remarks",cancel_remarks);
				
				//populate billing details from OTBillingBean........	
				bill_info = billing_bean.getBillingParams(bill_info,"S");
				or_bean.setOrderBillDtls(order_id+order_line_no,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);
				//bill_info.clear();
			}
			panel_str = (String) bill_info.get("bl_panel_str");
			}//end ofm if bill_flag
			if(!term_code.equals("")){
				pstmt1	 = con.prepareStatement("SELECT SHORT_DESC PROC_DESC FROM MR_TERM_CODE WHERE TERM_CODE=?");
				pstmt1.setString(1,term_code);
				rset = pstmt1.executeQuery();
				while(rset.next()){
					term_desc = rset.getString("PROC_DESC");			
				}
			}


			if("M".equals(proc_result)){
				pstmt1	 = con.prepareStatement("SELECT DECODE(COUNT(PROC_CODE),'0','N','Y') FROM OT_POST_OPER_PROC_DTLS  WHERE  OPERATING_FACILITY_ID = ? AND OPER_NUM =?   AND  OPER_CODE=?");
				pstmt1.setString(1,facility_id);
				pstmt1.setString(2,oper_num);
				pstmt1.setString(3,oper_code);
				rset = pstmt1.executeQuery();
				while(rset.next()){
					proc_code_entered_yn = rset.getString(1);			
				}
				out.println("<script> LoadMandatoryFlag('"+oper_code+"','"+proc_code_entered_yn+"')</script>");
			}

			if( "P".equals(proc_link) ){
				pstmt1	 = con.prepareStatement("SELECT DECODE(COUNT(PROC_CODE),'0','I','L') FROM OT_POST_OPER_PROC_DTLS  WHERE  OPERATING_FACILITY_ID = ? AND OPER_NUM =?   AND  OPER_CODE=?");
				pstmt1.setString(1,facility_id);
				pstmt1.setString(2,oper_num);
				pstmt1.setString(3,oper_code);
				rset = pstmt1.executeQuery();
				while(rset.next()){
					auto_populate_yn = rset.getString(1);			
				}
				if("I".equals(auto_populate_yn)){
					auto_param = line_no+"::"+oper_code+"::"+oper_desc+"::"+term_set_id+"::"+term_code+"::"+color+"::"+term_desc;
					out.println("<script>autoPopulate('"+auto_param+"')</script>");
				}
					
			}

			//out.println("<script>loadDBRows('"+line_no+"','"+oper_code+"','"+oper_desc +"','"+side_applicable +"','"+remarks+"','L'); </script>");
            if(("true").equals(bill_flag)){
			String reason_code=null;
			String overridden_incl_excl_ind=null;
			bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
			bl_bfr.append(overridden_incl_excl_ind).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
			//bl_bfr.append(checkForNull(posted_yn,"N")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"),"S")).append("::");
			bl_bfr.append(reason_code).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("err_id"),""));

			bill_str = bl_bfr.toString();
			bl_bfr.setLength(0);
			}
			out.println("<script>loadDBRows('"+line_no+"','"+oper_code+"','"+oper_desc +"','"+side_applicable +"','"+remarks+"','"+proc_link+"','"+proc_result+"','"+term_set_id+"','"+term_code+"','"+color+"','"+term_desc+"','"+order_line_no+"','"+order_id+"','"+bill_str+"','"+panel_str+"','L','"+oper_line_status+"','"+cancel_remarks+"');</script>");
			//out.println("<script>calldhana();</script>");	
			//addRow(oper_code,oper_desc,side_applicable,line_no,remarks,mode)

		}
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_OPERATIONS_SELECT2"));
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();
		while(rst.next()){
			max_oper_num = rst.getString(1);			
		}
			if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();

    	out.println("<script> assignRowLength('"+count+"');</script>");
		out.println("<script> setOperLineNumber('"+max_oper_num+"');</script>");
		out.println("<script>refresh();</script>");
		out.println("<script>assignAutoLength();</script>");

	}catch(Exception e){
		e.printStackTrace();
		System.err.println("SurgeonOper Record:  Err Msg in RecordSurgeon"+e.getMessage());
		////eOT.LogFile.log("RecordServletDebugger","In Record Surgeon"+e.getMessage(),this);
	}
	finally{
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
		
%>

<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
<tr> 
	  <td class="label" width='0%'><fmt:message key="Common.operation.label" bundle="${common_labels}"/> </td>
	  <td class="fields" width='0%'>
		  <input type='text' name='oper_code' id='oper_code' maxlength='10' readonly> 
		  <input type='button' class='button' value='?' name='OperationLookUp' id='OperationLookUp' onClick='searchOperations(document.forms[0].mode.value);'  <%=disable_flag%> > <img name='imageflag1' src='../../eCommon/images/mandatory.gif'></img>
	  </td>
<!-- </tr>
<tr> -->
 	  <td class="label" width='0%'><fmt:message key="Common.description.label" bundle="${common_labels}"/> </td>
     <td class="fields" width='0%'>
		<input type='text' name='oper_desc' id='oper_desc' size='30' readonly> 
	</td>
</tr>

<tr>
  <td class="label" width='0%' nowrap><fmt:message key="eOT.SideApplicable.Label" bundle="${ot_labels}"/> </td>
	<td class="fields" width='0%'>
		<select name='side_applicable' id='side_applicable' DB_VALUE='' <%=disable_flag%> >
		<option value='' ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
		<option value='R' ><fmt:message key="eOT.RightSide.Label" bundle="${ot_labels}"/> </option>
		<option value='L' ><fmt:message key="eOT.LeftSide.Label" bundle="${ot_labels}"/> </option>
		<option value='B' ><fmt:message key="eOT.Bilateral.Label" bundle="${ot_labels}"/> </option>
		</select>
		<img src='../../eCommon/images/mandatory.gif' name='imageflag'></img>
	</td>
    <td class="label" valign='top'  width='0%'  id='remarks_one'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </td>
	<td class="fields" width='0%'>
		<textarea rows='5' cols='40' name='remarks' <%=disable_flag%> onKeyPress="return checkLimit(this,'1700');"></textarea>
		<textarea rows='5' cols='40'  style='visibility:hidden;display:none' name='cancel_remarks' <%=disable_flag%> onKeyPress="return checkLimit(this,'1700');"></textarea>

	</td> 
	
<!-- </tr>
<tr> -->
	
	</tr>
	<tr>
		<input type='hidden' name='count_val' id='count_val' value="">

	<td  class="label" valign='top'  COLSPAN='2'  ><fmt:message key="Common.cancel.label" bundle="${common_labels}"/>
	<input type="checkbox"  name="chk_status" id="chk_status"  onclick="assignChkBoxVal(this,document.forms[0].mode.value,document.forms[0].oper_code.value,document.forms[0].count_val.value)" disabled >
	</td>
	<td width="25%"></td>
	<td class="button" width='0%' align='right'>
		<input type='button' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' name="btn_select" onClick='addRow(document.forms[0].oper_code.value,document.forms[0].oper_desc.value,document.forms[0].side_applicable.value,document.forms[0].remarks.value,document.forms[0].mode.value,document.forms[0].chk_status.value,document.forms[0].cancel_remarks.value);' <%=disable_flag%> >
		<!-- <input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' name="btn_cancel" onClick='removeRow(document.forms[0].oper_code.value,document.forms[0].mode.value);' <%=disable_flag%> > -->
	</td>
</tr>
</table>
   <!-- added by Sathish for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<!-- end -->
	<input type='hidden' name='recId' id='recId' value=''>
	<input type='hidden' name='mode' id='mode' value='I'>
	<input type='hidden' name='called_from' id='called_from' value='<%=called_from%>'>
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='oper_num' id='oper_num' value='<%=oper_num%>'>
	<input type='hidden' name='collect_speciality_code' id='collect_speciality_code' value=''>
	<input type='hidden' name='side_applicable_yn' id='side_applicable_yn' value=''>
	<input type='hidden' name='proc_link' id='proc_link' value="">
	<input type='hidden' name='proc_result' id='proc_result' value="">
	<input type='hidden' name='term_id' id='term_id' value="">
	<input type='hidden' name='term_code' id='term_code' value="">
	<input type='hidden' name='term_desc' id='term_desc' value="">
	<input type='hidden' name='color' id='color' value="">
	<input type='hidden' name='order_id' id='order_id' value="<%=order_id%>">
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type="hidden" name="bill_flag" id="bill_flag" value="<%=bill_flag%>">
	<input type="hidden" name="remarks_hidden" id="remarks_hidden" value="">
	<input type="hidden" name="count" id="count" value="<%=count%>">
	<input type="hidden" name="oper_line_status" id="oper_line_status" value="">
	<input type="hidden" name="proc_chrg_cmp_yn" id="proc_chrg_cmp_yn" value="<%=proc_chrg_cmp_yn%>">
</form>
</BODY>
</HTML>

