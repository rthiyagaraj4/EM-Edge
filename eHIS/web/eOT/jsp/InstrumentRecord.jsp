<!DOCTYPE html>
<HTML>

<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.util.HashMap,eOR.OrderEntryBillingQueryBean,eOT.OTBillingBean,java.util.ArrayList" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp"%>
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
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String rst_acc_code = "";
	String bill_flag = request.getParameter("bill_flag");
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language="JavaScript" src="../../eOT/js/RecordNursing.js"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script language='javascript'>

function Class_row(){
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
}

/*function disableDocLevel(){
   var formObj = parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
   formObj.doc_level.disabled=true;
}*/

//ORDER - 1 default SQL STRING will execute
//ORDER - 2 PICK_LIST_DEFINE QUERY STRING IS EXECUTED
//ORDER - 3 PICK_LIST_UNDEFINE QUERY STRING IS EXECUTED
function loadDBRows(oper_code,oper_desc,line_no,instr_code,instr_desc,tray_no,remarks,index,oper_num,mode,order,bill_str,panel_str,key,key_line,quantity){ 
  
  //alert(key);
  //alert(key_line);
  //alert("order="+order);
  //alert("index="+index);
  //alert(line_no);
 //alert(bill_str);
 //alert(panel_str);

 //alert("instr record");
  var rows=parent.parent.parent.ObjectCollect.instrument_rows;
  var rowLength=parent.parent.parent.ObjectCollect.instrument_len;
   if(mode=='L' && rowLength==0){
	  var objrow = newRow();
	  objrow.oper_code=oper_code;
	  objrow.oper_desc=decodeUTF8(oper_desc);
	  objrow.instr_code=instr_code;
	  objrow.instr_desc=decodeUTF8(instr_desc);
	  objrow.oper_line_no=line_no;
	  objrow.tray_no=tray_no;
	
	  objrow.remarks=decodeUTF8(remarks);
	  objrow.recId = index;
	  objrow.db_mode=(order==1)?"L":"I";
	  objrow.order=order;
	  objrow.bill_str=bill_str;
	  objrow.panel_str=panel_str;
	  objrow.key=key;
	  objrow.key_line=key_line;
	  objrow.rate="";
	  objrow.quantity=quantity;
	  rows.push(objrow);
	}
}

function decodeUTF8(str){
	 var REG_EXP =/\+/g;
	return decodeURIComponent(str,"UTF-8").replace(REG_EXP," ");
}

function callPopulateList(flag){}

function loadCodes(){
	var formObj = document.InstrumentRecordForm;
	var codes =  formObj.operation.value;
    var arr = codes.split("##");
	//alert(arr);
	formObj.oper_code.value=arr[0];
	formObj.oper_line_no.value=arr[1];
}

function assignCodes(obj){
	var formObj = document.InstrumentRecordForm;
	var codes =  obj.value;
    var arr = codes.split("##");
	formObj.oper_code.value=arr[0];
	formObj.oper_line_no.value=arr[1];
}

function refresh(){
	 var formObj = document.InstrumentRecordForm;
	 var params = formObj.params.value;
	 parent.ResultsFrame.location.href='../../eOT/jsp/InstrumentDtls.jsp?'+params;
}

function addRow(){
  var objrow = newRow();
  var msg = trimString(getMessage("CODE_ALREADY_EXISTS","Common"));
  var rows=parent.parent.parent.ObjectCollect.instrument_rows;
  var formObj = document.InstrumentRecordForm;
  var mode =formObj.mode.value;
  var obj = formObj.operation;
  var bill_flag=document.forms[0].bill_flag.value;
  
  if(chkEmpty()){
	if(mode=='I'){
	   if(alreadyExist()){
		if(bill_flag=="true") // added by satihsh on 10-01-2009to diable billing part when interfaceto Patient billing check box unchecked 
		{
		var retVal = callOrderLineCreation();
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
		var key = formObj.oper_num.value+"@"+formObj.oper_code.value+"@S"+"@"+formObj.instr_code.value;
		//alert("Key"+key);
		objrow.oper_code=formObj.oper_code.value;
		//objrow.oper_desc=escape(formObj.operation.options[obj.selectedIndex].text);
		objrow.oper_desc=formObj.operation.options[obj.selectedIndex].text;
		objrow.instr_code=formObj.instr_code.value;
		//objrow.instr_desc=escape(formObj.instr_desc.value);
		objrow.instr_desc=formObj.instr_desc.value;
		objrow.oper_line_no = formObj.oper_line_no.value;
		objrow.tray_no = formObj.tray_no.value;
		objrow.remarks = formObj.remarks.value;
		objrow.recId = getRecId();
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
		//rows.push(encodeURIComponent(objrow));
		resetFields();
		parent.ResultsFrame.location.href='../../eOT/jsp/InstrumentDtls.jsp?bill_flag='+bill_flag;
		parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
		
	} else{
		parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
	}
	}else
	  updateRow();
  }
}

//This method is called when new row are added
function callOrderLineCreation(){
	var formObj = document.forms[0];
	var oper_num = formObj.oper_num.value;
	var instr_code = formObj.instr_code.value;
	var oper_code = (formObj.operation.value).split("##")[0];
	var param = "oper_num="+oper_num+"&acc_type=S&called_from=ACC_TAB&acc_code="+instr_code+"&oper_code="+oper_code;
	//alert(param);
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

//This method is called when we are deleting the row
function DeleteKey(key){
	//alert(param);
	var xmlStr ="<root></root>";
	var temp_jsp="DeletePersistenceBeankey.jsp?del_key="+key;
	//alert(temp_jsp);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText) ;
	//alert(responseText);
	return responseText;
}


function newRow(){
  var objrow = new Class_row();
   return(objrow);
}

function alreadyExist(){
	//alert("already exist");
	var formObj = document.InstrumentRecordForm;
	var codeDtl = parent.ResultsFrame.code; 
	//alert(parent.DetailFrame.code);
	//alert("Detail Code"+codeDtl);
	var oper_code=formObj.oper_code.value;
	var instr_code = formObj.instr_code.value;
	var codeRecord = oper_code+instr_code;
	//alert("Record Code"+codeRecord);
	if(codeDtl.indexOf(codeRecord)>=0)
	   return false;
	else
	  return true;
}

 function assignRecId(){
	var rows = parent.parent.parent.ObjectCollect.instrument_rows;
	parent.parent.parent.ObjectCollect.instrument_len=rows.length;
	
}

function getRecId(){
    var rowLength=parent.parent.parent.ObjectCollect.instrument_len;
	var recId = rowLength+1;
	parent.parent.parent.ObjectCollect.instrument_len = recId;
	return recId;
}

function chkEmpty(){
	var formObj = document.InstrumentRecordForm;
	var fields = new Array(formObj.operation,formObj.instr_desc);
	var names = new Array('Operation','Instrument');
	var messageFrame = parent.parent.parent.messageFrame;
	if(checkFields( fields, names, messageFrame))
		return true;
}

function removeRow(){

var formObj = document.InstrumentRecordForm;
var params = formObj.params.value;
var rows=parent.parent.parent.ObjectCollect.instrument_rows;
var recId = document.forms[0].recId.value;
var mode = document.forms[0].mode.value;
if(rows.length>0 && mode=='U' ){        
  for(var jj=0;jj<rows.length;jj++){
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
 resetFields();
 parent.ResultsFrame.location.href='../../eOT/jsp/InstrumentDtls.jsp?'+params;
 parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
}else
   resetFields();
}

function updateRow(){
	var formObj = document.InstrumentRecordForm;
	var params = formObj.params.value;
	var	instr_code=formObj.instr_code.value;
	var	instr_desc=formObj.instr_desc.value;
	var	tray_no = formObj.tray_no.value;
	var	remarks = formObj.remarks.value;
	var oper_line_no = formObj.oper_line_no.value;
	var mode =formObj.mode.value;
	var recId = formObj.recId.value;
	
	var rows=parent.parent.parent.ObjectCollect.instrument_rows;
		if(rows.length>0 && mode=='U'){        
			for(var jj=0;jj<rows.length;jj++){
				if(rows[jj]!=null) {
					if(rows[jj].recId==recId){
						rows[jj].tray_no=tray_no;
						rows[jj].remarks=remarks;
						if(rows[jj].db_mode=='L' && rows[jj].order=='1'){
							rows[jj].db_mode='U';
						}else if(rows[jj].db_mode=='L' && (rows[jj].order=='2' || rows[jj].order=='3' ) ){
							rows[jj].db_mode='I';
						}
						break;
      				}
		         }else  
			continue;
		 }
      resetFields();
	  parent.ResultsFrame.location.href='../../eOT/jsp/InstrumentDtls.jsp?'+params;
 }
}



function splitString(strVal){
    var arr = strVal.split('::');
	var formObj = document.InstrumentRecordForm;
	formObj.oper_code.value=arr[0];
	formObj.operation.value=arr[1];
	formObj.oper_line_no.value = arr[2];
	formObj.instr_code.value=arr[3];
	formObj.instr_desc.value=arr[4];
	formObj.remarks.value=arr[5];
	formObj.tray_no.value=arr[6];
	formObj.recId.value = arr[7];
	formObj.mode.value = arr[8];
	formObj.operation.disabled=true;
	formObj.InstrumentLookUp.disabled=true;
}

function resetFields(){
	var formObj = document.InstrumentRecordForm;
	//formObj.operation.value=formObj.operation.value;
	formObj.instr_code.value='';
	formObj.instr_desc.value='';
	formObj.oper_line_no.value='';
	formObj.oper_code.value='';
	formObj.tray_no.value='';
	formObj.remarks.value='';
	formObj.mode.value='I';
	formObj.operation.disabled=false;
	formObj.InstrumentLookUp.disabled=false;
    formObj.operation.focus();
		
}
function localTrimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}

/*function assignCodes(){
	var formObj = document.InstrumentRecordForm;
	var codes =  formObj.operation.value;
    var arr = codes.split("##");
	formObj.oper_code.value=arr[0];
	formObj.oper_line_no.value=arr[1];
}*/
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="loadCodes();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name = 'InstrumentRecordForm'>
<input type='hidden' name='params' id='params' value='<%=request.getQueryString()%>' >
<%
	
	String oper_num = checkForNull(request.getParameter("oper_num"));
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String booking_num = checkForNull(request.getParameter("booking_num"));
	String key = "";
	String key_line="";
	String bill_str="";
	String panel_str="";
	HashMap bill_info=new HashMap();
	StringBuilder bl_bfr = new StringBuilder();
	String order_id="";
	String order_line_num="";
	String booking_date  = "";
	String encounter_id   = "";
	String patient_class   = "";
	String visit_id   = "";
	String catalog_code   = "";
	

	String surgeon_code = checkForNull(request.getParameter("surgeon_code"));
	
	String  nursing_doc_comp_yn = checkForNull(request.getParameter("nursing_doc_comp_yn"));
	boolean exist_rec = false;
	boolean pick_list = false;
	
	String disable_flag="";
	if( nursing_doc_comp_yn.equals("Y") )
	  disable_flag="disabled";
	 else 
	   disable_flag="";

	String line_no ="";
	StringBuffer oper_codes = new StringBuffer();


	//this checks whether the given oper_num is already have records in the db(OT_SURGICAL_ACCESSORIES if  record is there execute the query string SQL otherwise execute the query string PICK_LIST_DEFINE
	String SQL_EXIST = "SELECT ACCESSORY_CODE FROM OT_SURGICAL_ACCESSORIES WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? AND ROWNUM=1";

	//this query checks whether we have already record in OT_PICK_LISTS Table if returns true="PICK_LIST_DEFINED Qry is executed otherwise PICKlIST_UNDEFINED Qry is executed"
	String PICK_LIST_EXIST_YN="SELECT OPER_CODE FROM OT_PICK_LISTS WHERE OPERATING_FACILITY_ID=? AND (BOOKING_NUM=? OR OPER_NUM=?) AND ROWNUM=1";

	//String PICK_LIST_DEFINED="SELECT A.OPER_CODE OPR_CODE,C.SHORT_DESC OPR_DESC ,A.ITEM_ID ACC_CODE,B.SHORT_DESC ACC_DESC,A.ITEM_QTY TR_NO FROM  OT_PICK_LISTS A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.TEAM_DOCTOR_CODE  = ? AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'I' AND A.ITEM_ID = B.INSTR_CODE";

	//Code altered by rajesh for PHASE 3

	//String PICK_LIST_DEFINED="SELECT A.OPER_CODE OPR_CODE,C.SHORT_DESC OPR_DESC ,A.ITEM_ID ACC_CODE,B.SHORT_DESC ACC_DESC,A.ITEM_QTY TR_NO FROM  OT_PICK_LISTS A, OT_INSTRUMENT_LANG_VW B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.TEAM_DOCTOR_CODE  = ? AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'I' AND A.ITEM_ID = B.INSTR_CODE AND B.LANGUAGE_ID='"+locale+"' ";
	
	String PICK_LIST_DEFINED="SELECT A.OPER_CODE OPR_CODE,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC ,A.ITEM_ID ACC_CODE,GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE',A.ITEM_ID) ACC_DESC,A.ITEM_QTY TR_NO FROM  OT_PICK_LISTS A, OT_INSTRUMENT_LANG_VW B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.TEAM_DOCTOR_CODE  = ? AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'I' AND A.ITEM_ID = B.INSTR_CODE AND B.LANGUAGE_ID='"+locale+"' ";
	String PICK_LIST_UNDEFINED="";
	
	//String SQL = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, B.SHORT_DESC OPR_DESC, A.ACCESSORY_CODE ACC_CODE, C.SHORT_DESC ACC_DESC, A.TRAY_NO TR_NO, A.REMARKS REMKS FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_INSTRUMENT C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.INSTR_CODE"; 

	// Code altered by rajesh for PHASE-3.
	//String SQL = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, B.SHORT_DESC OPR_DESC, A.ACCESSORY_CODE ACC_CODE, C.SHORT_DESC ACC_DESC, A.TRAY_NO TR_NO, A.REMARKS REMKS FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_INSTRUMENT_LANG_VW C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.INSTR_CODE AND C.LANGUAGE_ID='"+locale+"'"; 
	String SQL = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE',A.ACCESSORY_CODE) ACC_DESC, A.TRAY_NO TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE, A.Quantity actual_units  FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_INSTRUMENT_LANG_VW C WHERE A.OPERATING_FACILITY_ID=? AND C.LANGUAGE_ID=? AND ACCESSORY_TYPE='I' AND A.OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.INSTR_CODE ";	// modified against MMS-QH-CRF-0199

	String SQL1 = "SELECT A.OPER_CODE OPR_CODE,A.OPER_LINE_NUM LN_NUM,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC FROM OT_POST_OPER_DTLS A, OT_OPER_MAST B WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE AND nvl(A.OPER_LINE_STATUS,'x') <> nvl('99',null) ";
	
	Connection con = null;
	PreparedStatement pstmt = null;
	HashMap line_no_map = new HashMap();
	String val= "";
	ResultSet rst = null;
	
	int index=0;
	try{
		con = ConnectionManager.getConnection(request);
		
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
		rst = pstmt.executeQuery();
		if(rst.next()){
			exist_rec=true;
		}
		if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
		// already the record is in surgical accessories table

		if(exist_rec==true){
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,locale);
			pstmt.setString(3,oper_num);
			rst = pstmt.executeQuery();
			while(rst.next()){
			   ++index;	
			key = rst.getString("KEY");
			key_line = rst.getString("KEY_LINE");
			//or_bean.clearBean();
            if(("true").equals(bill_flag)) // added by sathish on 10-01-2009 to diable billing part when unchecked interfaced to patient billing check box in masters
			{
			bill_info = or_bean.getOrderBillDtls(key+key_line);
			if(bill_info==null){
				bill_info = new HashMap();
				bill_info.put("key",key);
				bill_info.put("key_line_no",key_line);
				rst_acc_code = rst.getString("ACC_CODE");
				bill_info.put("oper_code",rst_acc_code);//pass acc_code in oper_code
				bill_info.put("acc_type","S");
				bill_info.put("oper_num",oper_num);
				bill_info.put("locale",locale);
				bill_info.put("module_id","OT");
				bill_info.put("quantity","1");
				//populate billing details from OTBillingBean........	
				bill_info = billing_bean.getBillingParams(bill_info,"C");//C-> for Surgical Accessories Billing
/*test code		
				catalog_code = "S#"+rst_acc_code;
				ArrayList bill_dtls=or_bean.getBillChargeDetails("1",catalog_code,(String)bill_info.get("service_date"),locale,order_id,order_line_num,patient_id,(String)bill_info.get("encounter_id"),(String)bill_info.get("patient_class"),(String)bill_info.get("pract_staff_id"));	
				bill_info	= billing_bean.formatBillingDetails(bill_dtls);
				bill_info.putAll(bill_info);
			//set billing details from OTBillingBean........	
// test code ends here */

				or_bean.setOrderBillDtls(key+key_line,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);
				//bill_info.clear();
			}
			panel_str = (String) bill_info.get("bl_panel_str");	
			bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N"));
			bill_str = bl_bfr.toString();
			bl_bfr.setLength(0);
		    }//end of if bill_flag
			 
			 out.println("<script>loadDBRows('"+checkForNull(rst.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("OPR_DESC")))+"','"+checkForNull(rst.getString("LN_NUM"))+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("ACC_DESC")))+"','"+checkForNull(rst.getString("TR_NO"))+"','"+checkForNull(rst.getString("REMKS"))+"','"+index+"','"+oper_num+"','L','1','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','"+checkForNull(rst.getString("actual_units"))+"');</script>");	
			 
			}
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			//<ACCESORY_TYPE><OPER_NUM><OPER_LINE_NUM>
			
			
			
			//panel_str = (String) bill_info.get("bl_panel_str");
			out.println("<script>refresh()</script>");
			out.println("<script>assignRecId()</script>");
		}else if(nursing_doc_comp_yn.equals("N")){
				//if it is true pick_list_defined query executed.
				// if it is false pick_list_undefined query executed.
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
				
				// if pick_list==true alerady the record is in the ot_pick_list
				 if(pick_list==true){
				 pstmt = con.prepareStatement(PICK_LIST_DEFINED);
				 pstmt.setString(1,facility_id);
				 pstmt.setString(2,patient_id);
				 pstmt.setString(3,surgeon_code);
				 pstmt.setString(4,booking_num);
				 pstmt.setString(5,oper_num);
				 rst = pstmt.executeQuery();
				 while(rst.next()){
					++index;	
					line_no = (String)line_no_map.get(rst.getString("OPR_CODE"));
				
				
				if(("true").equals(bill_flag))
			    {
				HashMap hash = billing_bean.getORBillingParams(oper_num);
				catalog_code = "S#"+rst.getString("ACC_CODE");
				key = oper_num+"@"+rst.getString("OPR_CODE")+"@S@"+rst.getString("ACC_CODE");
				key_line="";
				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				//ArrayList bill_dtls=or_bean.getBillChargeDetails(visit_id,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				ArrayList bill_dtls=or_bean.getBillChargeDetails("1",catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info			 = billing_bean.formatBillingDetails(bill_dtls);
				bill_info.putAll(hash);
				bill_info.put("quantity","1");
				//set billing details from OTBillingBean........	
				or_bean.setOrderBillDtls(key,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);

				panel_str = (String) bill_info.get("bl_panel_str");	
				bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N"));
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end ofm if bill_flag
				out.println("<script>loadDBRows('"+checkForNull(rst.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("ACC_DESC")))+"','"+checkForNull(rst.getString("TR_NO"))+"','','"+index+"','"+oper_num+"','L','2','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','');</script>");	
					
					//out.println("<script>loadDBRows('"+checkForNull(rst.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("ACC_DESC")))+"','"+checkForNull(rst.getString("TR_NO"))+"','','"+index+"','"+oper_num+"','L','2'); </script>");	
			 }//end of while loop
			 if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			out.println("<script>refresh()</script>");
			out.println("<script>assignRecId()</script>");
		}else{
				//if pick_list is undefined this portion get executed. commented on 17/10/2005
				/*PICK_LIST_UNDEFINED="SELECT A.OPER_CODE OPR_CODE,C.SHORT_DESC OPR_DESC,A.INSTR_CODE ACC_CODE,B.SHORT_DESC ACC_DESC, A.NO_OF_UNITS TR_NO FROM   OT_OPER_INSTRUMENT A, OT_INSTRUMENT B,OT_OPER_MAST C WHERE  A.OPER_CODE IN ("+oper_codes.toString()+") AND A.INSTR_CODE  = B.INSTR_CODE AND A.OPER_CODE = C.OPER_CODE";*/
				
				//PICK_LIST_UNDEFINED="SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.INSTR_CODE ACC_CODE,B.SHORT_DESC ACC_DESC,   A.NO_OF_UNITS TR_NO 	FROM   OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'AOPR' AND A.INSTR_CODE  = B.INSTR_CODE AND C.OPER_CODE  IN ("+oper_codes.toString()+") UNION SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.INSTR_CODE ACC_CODE, B.SHORT_DESC ACC_DESC,   A.NO_OF_UNITS TR_NO FROM    OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+") AND A.INSTR_CODE = B.INSTR_CODE UNION SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.INSTR_CODE ACC_CODE, B.SHORT_DESC ACC_DESC,A.NO_OF_UNITS TR_NO FROM OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SCAT' AND A.SPECIALITY_CODE   = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE  = D.OPER_CODE  AND A.INSTR_CODE = B.INSTR_CODE UNION SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.INSTR_CODE ACC_CODE, B.SHORT_DESC ACC_DESC,   A.NO_OF_UNITS TR_NO 	FROM OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE AND D.OPER_CODE              IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE AND A.INSTR_CODE = B.INSTR_CODE  UNION SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.INSTR_CODE ACC_CODE, B.SHORT_DESC ACC_DESC,   A.NO_OF_UNITS TR_NO FROM    OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SOPR'  AND A.OPER_CODE            IN ("+oper_codes.toString()+") AND A.OPER_CODE = C.OPER_CODE AND A.INSTR_CODE = B.INSTR_CODE";

				// Code altered by rajesh for PHASE-3.
				//PICK_LIST_UNDEFINED="SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.INSTR_CODE ACC_CODE,B.SHORT_DESC ACC_DESC,   A.NO_OF_UNITS TR_NO 	FROM   OT_OPER_INSTRUMENT A, OT_INSTRUMENT_LANG_VW B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'AOPR' AND A.INSTR_CODE  = B.INSTR_CODE AND B.LANGUAGE_ID='"+locale+"'  AND C.OPER_CODE  IN ("+oper_codes.toString()+") UNION SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.INSTR_CODE ACC_CODE, B.SHORT_DESC ACC_DESC,   A.NO_OF_UNITS TR_NO FROM    OT_OPER_INSTRUMENT A, OT_INSTRUMENT_LANG_VW B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+") AND B.LANGUAGE_ID='"+locale+"'  AND A.INSTR_CODE = B.INSTR_CODE UNION SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.INSTR_CODE ACC_CODE, B.SHORT_DESC ACC_DESC,A.NO_OF_UNITS TR_NO FROM OT_OPER_INSTRUMENT A, OT_INSTRUMENT_LANG_VW B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SCAT' AND A.SPECIALITY_CODE   = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND B.LANGUAGE_ID='"+locale+"'  AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE  = D.OPER_CODE  AND A.INSTR_CODE = B.INSTR_CODE UNION SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.INSTR_CODE ACC_CODE, B.SHORT_DESC ACC_DESC,   A.NO_OF_UNITS TR_NO 	FROM OT_OPER_INSTRUMENT A, OT_INSTRUMENT_LANG_VW B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE AND B.LANGUAGE_ID='"+locale+"' AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE AND D.OPER_CODE              IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE AND A.INSTR_CODE = B.INSTR_CODE  UNION SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.INSTR_CODE ACC_CODE, B.SHORT_DESC ACC_DESC,   A.NO_OF_UNITS TR_NO FROM    OT_OPER_INSTRUMENT A, OT_INSTRUMENT_LANG_VW B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SOPR' AND B.LANGUAGE_ID='"+locale+"'  AND A.OPER_CODE  IN ("+oper_codes.toString()+") AND A.OPER_CODE = C.OPER_CODE AND A.INSTR_CODE = B.INSTR_CODE";
				PICK_LIST_UNDEFINED="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE,GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO 	FROM   OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'AOPR' AND A.INSTR_CODE  = B.INSTR_CODE  AND C.OPER_CODE  IN ("+oper_codes.toString()+") UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO FROM    OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+")  AND A.INSTR_CODE = B.INSTR_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,A.NO_OF_UNITS TR_NO FROM OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SCAT' AND A.SPECIALITY_CODE   = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE  = D.OPER_CODE  AND A.INSTR_CODE = B.INSTR_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO 	FROM OT_OPER_INSTRUMENT A, OT_INSTRUMENT  B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE AND A.INSTR_CODE = B.INSTR_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO FROM    OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SOPR'  AND A.OPER_CODE  IN ("+oper_codes.toString()+") AND A.OPER_CODE = C.OPER_CODE AND A.INSTR_CODE = B.INSTR_CODE";
				
				pstmt = con.prepareStatement(PICK_LIST_UNDEFINED);
				rst = pstmt.executeQuery();
				while(rst.next()){
					++index;	
					line_no = (String)line_no_map.get(rst.getString("OPR_CODE"));
				if(("true").equals(bill_flag))
			    {	
				bill_info = new HashMap();
				HashMap hash = billing_bean.getORBillingParams(oper_num);
				catalog_code = "S#"+rst.getString("ACC_CODE");
				key = oper_num+"@"+rst.getString("OPR_CODE")+"@S@"+rst.getString("ACC_CODE");
				key_line="";
				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				//ArrayList bill_dtls =or_bean.getBillChargeDetails(visit_id,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				ArrayList bill_dtls =or_bean.getBillChargeDetails("1",catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info			 = billing_bean.formatBillingDetails(bill_dtls);
					hash.put("key",key);
					hash.put("key_line_no",key_line);
					hash.put("oper_code",rst.getString("ACC_CODE"));//pass acc_code in oper_code
					hash.put("acc_type","C");
					hash.put("oper_num",oper_num);
					hash.put("locale",locale);
					hash.put("quantity","1");
				bill_info.putAll(hash);
				bill_info.put("quantity","1");
				//set billing details from OTBillingBean........	
				or_bean.setOrderBillDtls(key,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);

				panel_str = (String) bill_info.get("bl_panel_str");	
				bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N"));
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end of if bill_flag	
			out.println("<script>loadDBRows('"+checkForNull(rst.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("ACC_DESC")))+"','"+checkForNull(rst.getString("TR_NO"))+"','','"+index+"','"+oper_num+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"',''); </script>");	
			 }//end of while loop
			 if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			out.println("<script>refresh()</script>");
			out.println("<script>assignRecId()</script>");
						
		}//end of pick_list if block


	}
	else
		{
		    out.println("<script>refresh()</script>");
			out.println("<script>assignRecId()</script>");
		}//end of exist_rec if block
		//out.println("<script>refresh()</script>");
		pstmt = con.prepareStatement(SQL1);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();
	%>


<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center''>
<tr>
	<td class="label" width="25%">
			<fmt:message key="Common.operation.label" bundle="${common_labels}"/> </td>
	<td class="fields" width="25%" >
			<select name="operation" id="operation"  <%=disable_flag%> >
			<% while(rst.next()){ 
			//OPR_CODE + LN_NO
			val = rst.getString(1)+"##"+rst.getString(2);
			
			%>
			<option value='<%=val%>' > <%=rst.getString(3)%>  </option>
			<% }
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();%>
			</select>
		<img src='../../eCommon/images/mandatory.gif'></img>
    </td>
<!--  </tr> -->
	
			<%
			}catch(Exception e){
			System.err.println("Instrument Record: Err Msg in InstrumentRecord"+e.getMessage());
				}finally{
				try{
					if(rst!=null)rst.close();
					if(pstmt!=null)pstmt.close();
					if(con!=null)
					//empty the string buffer
					oper_codes.setLength(0);
					ConnectionManager.returnConnection(con,request);
				}catch(Exception e){}
			}
		  %>
		

<!-- <tr>  -->
	  <td class="label" width="25%" >
			<fmt:message key="Common.Instrument.label" bundle="${common_labels}"/> </td>
	  <td class="fields" width="25%">
		  <input type='hidden' name='instr_code' id='instr_code' > 
		  <input type='text' name='instr_desc' id='instr_desc' disabled> 
		  <input type='button' class='button' value='?' name='InstrumentLookUp' id='InstrumentLookUp' onClick='searchInstrument(instr_code,instr_desc);' <%=disable_flag%> > <img src='../../eCommon/images/mandatory.gif'></img>
	  </td>
 </tr>
<tr>
	 <td class="label" width="25%" >
			<fmt:message key="Common.TrayNo.label" bundle="${common_labels}"/> </td>
     <td class="fields" width="25%">
			<input type='text' name='tray_no' id='tray_no' maxlength='30' size='20' <%=disable_flag%> > 
	</td>
<!-- </tr>

<tr> -->
	 <td class="label" width="25%" >
			<fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </td>
     <td class="fields" width="25%">
		<textarea  name='remarks' ROWS='3' COLS='40' onBlur="checkLimit(this,100)" <%=disable_flag%> ></textarea>
	</td>
</tr>


	<td class="fields" width="25%"></td>
	<td class="fields" width="25%"></td>
	<td class="fields" width="25%"></td>
	<td width="25%" >
		<input type='button' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='assignCodes(document.forms[0].operation);addRow();' <%=disable_flag%> >
		<input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow();' <%=disable_flag%> >
	</td>
</tr>
</table>
<!-- added by Sathish for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<!-- end -->
<input type='hidden' name='recId' id='recId' value=''>
<input type='hidden' name='oper_code' id='oper_code' value=''>
<input type='hidden' name='oper_line_no' id='oper_line_no' value=''>
<input type='hidden' name='mode' id='mode' value='I'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='oper_num' id='oper_num' value="<%=oper_num%>">
<input type='hidden' name='bill_flag' id='bill_flag' value="<%=bill_flag%>">
</form>
</BODY>
</HTML>

