<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/Common.jsp"%>

<HTML>
<%//@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.Common.*,eOT.*,eOT.Common.*" contentType=" text/html;charset=" %>

<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.util.HashMap,eOR.OrderEntryBillingQueryBean,eOT.OTBillingBean" %>


<%-- Mandatory declarations start --%>



<%-- Mandatory declarations end --%>

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
	String p_qty = "";
	String trace="0";

	String or_bean_id 				= "Or_billingQueryBean";
	String or_bean_name 			= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean			= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;

	String bean_id 				= "OTBillingBean";
	String bean_name 			= "eOT.OTBillingBean";
	OTBillingBean billing_bean	= (OTBillingBean)getBeanObject( bean_id, bean_name, request ) ;

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
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
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- <Script Language="JavaScript" src="../../eCommon/js/messages.js"></Script> -->
<!-- <script language="javascript" src="../../eOT/js/OTMessages.js"></script> --> 


<script language='javascript'>

function Class_row()
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
  this.bill_str="";
  this.panel_str="";
  this.key="";
  this.key_line="";
  this.rate="";
}

/*function disableDocLevel(){
   var formObj = parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
   formObj.doc_level.disabled=true;
}*/

function callPopulateList(flag){}

function loadCodes(){
	var formObj = document.PacksRecordForm;
	var codes =  formObj.operation.value;
    var arr = codes.split("##");
	//alert(arr);
	formObj.oper_code.value=arr[0];
	formObj.oper_line_no.value=arr[1];
}

function assignCodes(obj){
	var formObj = document.PacksRecordForm;
	var codes =  obj.value;
    var arr = codes.split("##");
	//alert(arr);
	formObj.oper_code.value=arr[0];
	formObj.oper_line_no.value=arr[1];
}

function loadDBRows(oper_code,oper_desc,line_no,package_code,package_desc,quantity,remarks,index,mode,order,bill_str,panel_str,key,key_line){ 
  var objrow = newRow();
  //alert("order-110-->"+order);
  var rows=parent.parent.parent.ObjectCollect.packs_rows;
  var rowLength=parent.parent.parent.ObjectCollect.packs_len;
  if(mode=='L' && rowLength==0){
	  objrow.oper_code=oper_code;
	  objrow.oper_desc=unescape(oper_desc);
	  objrow.package_code=package_code;
	  objrow.package_desc=unescape(package_desc);
	  objrow.oper_line_no=line_no;
	  objrow.quantity=quantity;
	  objrow.remarks=remarks;
	  objrow.recId = index;
	  //objrow.db_mode="L";
	  objrow.db_mode=(order==1)?"L":"I";
	  objrow.order = order;
	  objrow.bill_str=bill_str;
	  objrow.panel_str=panel_str;
	  objrow.key=key;
	  objrow.key_line=key_line;
	  objrow.rate="";
	  rows.push(objrow);
	  
	  }
}


function refresh(){
	 var formObj			= document.PacksRecordForm;
	 var params				= formObj.params.value;
	 parent.ResultsFrame.location.href='../../eOT/jsp/ConsumablePacksDtls.jsp?'+params;
}

function addRow(){
  var objrow = newRow();
  var msg = trimString(getMessage("CODE_ALREADY_EXISTS","Common"));
  var rows=parent.parent.parent.ObjectCollect.packs_rows;
  var formObj = document.PacksRecordForm;
  var params = formObj.params.value;
  var mode =formObj.mode.value;
  var obj = formObj.operation;
  var bill_flag = formObj.bill_flag.value;
   var key = formObj.oper_num.value+"@"+formObj.oper_code.value+"@C"+"@"+formObj.package_code.value;
  if(chkEmpty()){
	if(mode=='I'){
	   if(alreadyExist()){
		if(bill_flag=="true") //added by sathish to disable Billing Part
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
			objrow.oper_code=formObj.oper_code.value;
			objrow.oper_desc=formObj.operation.options[obj.selectedIndex].text;
			objrow.package_code=formObj.package_code.value;
			objrow.package_desc=formObj.package_desc.value;
			objrow.oper_line_no = formObj.oper_line_no.value;
			objrow.quantity = formObj.quantity.value;
			objrow.remarks = formObj.remarks.value;
			objrow.recId = getRecId();
			//var retVal = callOrderLineCreation();
			if(bill_flag=="true")
		    {
			var arr = retVal.split("@@");
			objrow.panel_str = arr[0];
			objrow.bill_str = arr[1];
		    }
			objrow.key=key;
			objrow.key_line="";
			objrow.db_mode="I";
			rows.push(objrow);
			resetFields();
			parent.ResultsFrame.location.href='../../eOT/jsp/ConsumablePacksDtls.jsp?'+params;
			parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
		
	} else{
		parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
	}
	}else
	  updateRow();
  }
}

function callOrderLineCreation(){
	var formObj = document.forms[0];
	var oper_num = formObj.oper_num.value;
	var package_code = formObj.package_code.value;
	var oper_code = (formObj.operation.value).split("##")[0];
	var param = "oper_num="+oper_num+"&acc_type=C&called_from=ACC_TAB&acc_code="+package_code+"&oper_code="+oper_code;
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

function newRow(){
  var objrow = new Class_row();
   return(objrow);
}

function alreadyExist(){
	var formObj = document.PacksRecordForm;
	var codeDtl = parent.ResultsFrame.code; 
	//alert(codeDtl);
	var oper_code=formObj.oper_code.value;
	var package_code = formObj.package_code.value;
	var codeRecord = oper_code+package_code;
	if(codeDtl.indexOf(codeRecord)>=0)
	   return false;
	else
	  return true;
}

 function assignRecId(){
	var rows = parent.parent.parent.ObjectCollect.packs_rows;
	parent.parent.parent.ObjectCollect.packs_len=rows.length;
	
}

function getRecId(){
    var rowLength=parent.parent.parent.parent.ObjectCollect.packs_len;
	var recId = rowLength+1;
	parent.parent.parent.parent.ObjectCollect.packs_len = recId;
	return recId;
}

function chkEmpty(){
	var formObj = document.PacksRecordForm;
	var fields = new Array(formObj.operation,formObj.package_desc,formObj.quantity);
	var names = new Array('Operation','package','No of Units');
	var messageFrame = parent.parent.parent.messageFrame;
	if(checkFields( fields, names, messageFrame))
		return true;
}

function removeRow(){
var formObj = document.PacksRecordForm;
var params = formObj.params.value;
var rows=parent.parent.parent.ObjectCollect.packs_rows;
var recId = document.forms[0].recId.value;
var mode = document.forms[0].mode.value;
if(rows.length>0 && mode=='U'){        
  for(var jj=0;jj<rows.length;jj++){
	  //alert("rows[jj].db_mode--->"+rows[jj].db_mode)
	 if(rows[jj]!=null){
		if(rows[jj].recId==recId){
			DeleteKey(rows[jj].key+rows[jj].key_line);
			 if( (rows[jj].db_mode=='L' || rows[jj].db_mode=='U') && (rows[jj].order=='1' ) )
			{
			rows[jj].db_mode='D';
			}
			 else
			delete rows[jj];
			   break;
		}
	 }else
	continue;
 }//end for-Loop
 resetFields();
 parent.ResultsFrame.location.href='../../eOT/jsp/ConsumablePacksDtls.jsp?'+params;
 parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
}else
   resetFields();
}

function updateRow(){
	var formObj = document.PacksRecordForm;
	var params = formObj.params.value;
	var	package_code=formObj.package_code.value;
	var	package_desc=formObj.package_desc.value;
	var	quantity = formObj.quantity.value;
	var	remarks = formObj.remarks.value;
	var mode =formObj.mode.value;
	var recId = formObj.recId.value;
	var rows=parent.parent.parent.ObjectCollect.packs_rows;
		if(rows.length>0 && mode=='U'){        
			for(var jj=0;jj<rows.length;jj++){
				if(rows[jj]!=null) {
					if(rows[jj].recId==recId){
						//rows[jj].package_code=package_code;
						//rows[jj].package_desc=package_desc;	
			            rows[jj].quantity=quantity;
						rows[jj].remarks=remarks;
			            if(rows[jj].db_mode=='L' && rows[jj].order=='1'){
						   //alert("In order 1");
							rows[jj].db_mode='U';
						}else if(rows[jj].db_mode=='L' && rows[jj].order=='2'){
							//alert("In order 2");
							rows[jj].db_mode='I';
						}else if(rows[jj].db_mode=='L' && rows[jj].order=='3'){
							//alert("In order 3");
							rows[jj].db_mode='I';
						}
						break;
					}
		         }else  
			continue;
		 }
      resetFields();
	 parent.ResultsFrame.location.href='../../eOT/jsp/ConsumablePacksDtls.jsp?'+params;
 }
}



function splitString(strVal){
    var arr = strVal.split('::');
	var formObj = document.PacksRecordForm;
	formObj.oper_code.value=arr[0];
	formObj.operation.value=arr[1];
	formObj.oper_line_no.value = arr[2];
	formObj.package_code.value=arr[3];
	formObj.package_desc.value=arr[4];
	formObj.remarks.value=arr[5];
	formObj.quantity.value=arr[6];
	formObj.recId.value = arr[7];
	formObj.mode.value = arr[8];
	formObj.operation.disabled=true;
	formObj.PackageLookUp.disabled=true;
	
}

function resetFields(){
	var formObj = document.PacksRecordForm;
	//formObj.operation.value=formObj.operation.value;
	formObj.package_code.value='';
	formObj.package_desc.value='';
	formObj.oper_code.value='';
	formObj.quantity.value='';
	formObj.remarks.value='';
	formObj.mode.value='I';
	formObj.operation.disabled=false;
	formObj.PackageLookUp.disabled=false;
    formObj.operation.focus();
	//frmObj.InstrumentLookUp.disabled=false;
	
}

function setOperLineNumber(line_no){
   var frmObj = parent.parent.ObjectCollect;
   if(frmObj.line_no==0){
		frmObj.line_no = parseInt(line_no,10);
   }
   //alert("assing "+frmObj.line_no); 
}

function getOperLineNumber(){
   frmObj = parent.parent.ObjectCollect;
   //alert("Before Incrementing "+frmObj.line_no);
   var line_no= frmObj.line_no + 1;
   //alert("After Incrementing "+line_no);
   parent.parent.ObjectCollect.line_no = line_no;
   //alert("After  assing "+frmObj.line_no);
   return line_no;
}

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
function localTrimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}

/*function assignCodes(){
	var formObj = document.PacksRecordForm;
	var codes =  formObj.operation.value;
    var arr = codes.split("##");
	//alert(arr);
	formObj.oper_code.value=arr[0];
	formObj.oper_line_no.value=arr[1];
}*/

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="loadCodes();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name = 'PacksRecordForm' id='PacksRecordForm'>
<% String params = request.getQueryString(); %>
<input type='hidden' name='params' id='params' value='<%=params%>' >
<%
	
	//String called_from =  checkForNull(request.getParameter("called_from"));
	String oper_num = checkForNull(request.getParameter("oper_num"));
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String booking_num = checkForNull(request.getParameter("booking_num"));
	String bill_flag = request.getParameter("bill_flag");
	String surgeon_code = checkForNull(request.getParameter("surgeon_code"));
	
	HashMap line_no_map = new HashMap();
	String line_no="";
	boolean exist_rec = false;
	boolean pick_list = false;
	StringBuffer oper_codes = new StringBuffer();

	String  nursing_doc_comp_yn = checkForNull(request.getParameter("nursing_doc_comp_yn"));
	String disable_flag="";
	if( nursing_doc_comp_yn.equals("Y") )
	  disable_flag="disabled";
	 else 
	   disable_flag="";

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

	 String SQL_EXIST = "SELECT ACCESSORY_CODE FROM OT_SURGICAL_ACCESSORIES WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? AND ROWNUM=1";

	//this query checks whether we have already record in OT_PICK_LISTS Table if returns true="PICK_LIST_DEFINED Qry is executed otherwise PICKlIST_UNDEFINED Qry is executed"
	String PICK_LIST_EXIST_YN = "SELECT OPER_CODE FROM OT_PICK_LISTS WHERE OPERATING_FACILITY_ID=? AND (BOOKING_NUM=? OR OPER_NUM=?) AND ROWNUM=1";
	//Code altered by Selvam for PHASE 3 Delivery
	//	String PICK_LIST_DEFINED="SELECT A.OPER_CODE OPR_CODE,C.SHORT_DESC OPR_DESC,A.ITEM_ID ACC_CODE,B.SHORT_DESC ACC_DESC,A.ITEM_QTY TR_NO FROM  OT_PICK_LISTS A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.TEAM_DOCTOR_CODE  = ? AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'P' AND A.ITEM_ID = B.PACKAGE_CODE";
		String PICK_LIST_DEFINED="SELECT A.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.ITEM_ID ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,NVL(A.ITEM_QTY,1) TR_NO FROM  OT_PICK_LISTS A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.TEAM_DOCTOR_CODE  = ? AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'P' AND A.ITEM_ID = B.PACKAGE_CODE";
 
	String PICK_LIST_UNDEFINED="";	
	//Code altered by Selvam for PHASE 3 Delivery	
	//String SQL = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, B.SHORT_DESC OPR_DESC, A.ACCESSORY_CODE ACC_CODE, C.SHORT_DESC ACC_DESC, A.QUANTITY TR_NO, A.REMARKS REMKS FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_PACKAGE_HDR C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.PACKAGE_CODE"; 
	//Modified against MMS-QH-CRF-0199
	String SQL = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',C.PACKAGE_CODE) ACC_DESC, A.QUANTITY TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_PACKAGE_HDR_LANG_VW C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND ACCESSORY_TYPE = 'P' AND  A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.PACKAGE_CODE AND C.LANGUAGE_ID=? ORDER BY BILL_SUB_REGN_LINE_NUM";
	String SQL1 = "SELECT A.OPER_CODE OPR_CODE,A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',B.OPER_CODE) OPR_DESC FROM OT_POST_OPER_DTLS A, OT_OPER_MAST B WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE";
	
	Connection con = null;
	PreparedStatement pstmt = null;
	String val= "";
	ResultSet rst = null;
	String rst_acc_code = "";
	String rst_tr_no = "";
	int index=0;
	try{
		con = ConnectionManager.getConnection(request);
		//pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_PERSONNEL_SELECT2")) ;

		pstmt = con.prepareStatement(SQL1);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		trace="1";
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
		if(pstmt!=null)			pstmt.close();
			if(rst!=null)           rst.close();

		pstmt = con.prepareStatement(SQL_EXIST);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		trace="2";
		rst = pstmt.executeQuery();
		if(rst.next()){
			exist_rec=true;
		}
		 if(pstmt!=null)			pstmt.close();
			if(rst!=null)           rst.close();
		if(exist_rec==true){
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,oper_num);
			pstmt.setString(3,locale);
		trace="3";
			rst = pstmt.executeQuery();
			while(rst.next()){
			   ++index;	
			key = rst.getString("KEY");
			key_line = rst.getString("KEY_LINE");
			//or_bean.clearBean();
			if(("true").equals(bill_flag))// added by sathish on 10-01-2009 to disable billing Part
			{
			bill_info = or_bean.getOrderBillDtls(key+key_line);
			if(bill_info==null){
				bill_info = new HashMap();
				bill_info.put("key",key);
				bill_info.put("key_line_no",key_line);
				rst_acc_code = rst.getString("ACC_CODE");
				bill_info.put("oper_code",rst_acc_code);//pass acc_code in oper_code
				bill_info.put("acc_type","C");
				bill_info.put("oper_num",oper_num);
				bill_info.put("locale",locale);
				bill_info.put("module_id","OT");
				//populate billing details from OTBillingBean........	
				rst_tr_no = rst.getString("TR_NO");
				bill_info.put("quantity",rst_tr_no);
				bill_info = billing_bean.getBillingParams(bill_info,"C");//C-> for Surgical Accessories Billing
				//bill_info.put("quantity",rst.getString("TR_NO"));
/*test code		
				catalog_code = "C#"+rst_acc_code;
				ArrayList bill_dtls=or_bean.getBillChargeDetails(rst_tr_no,catalog_code,(String)bill_info.get("service_date"),locale,order_id,order_line_num,patient_id,(String)bill_info.get("encounter_id"),(String)bill_info.get("patient_class"),(String)bill_info.get("pract_staff_id"));	
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
			out.println("<script>loadDBRows('"+checkForNull(rst.getString("OPR_CODE"))+"','"+encode(checkForNull(rst.getString("OPR_DESC")))+"','"+checkForNull(rst.getString("LN_NUM"))+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+encode(checkForNull(rst.getString("ACC_DESC")))+"','"+checkForNull(rst.getString("TR_NO"))+"','"+checkForNull(rst.getString("REMKS"))+"','"+index+"','L','1','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"');</script>");	

		}
		out.println("<script>refresh()</script>");
		out.println("<script>assignRecId()</script>");
		
		if(pstmt!=null)			pstmt.close();
			if(rst!=null)           rst.close();
		} else if(nursing_doc_comp_yn.equals("N")) {
			
			pstmt = con.prepareStatement(PICK_LIST_EXIST_YN);
			/*SELECT OPER_CODE FROM OT_PICK_LISTS WHERE OPERATING_FACILITY_ID=? AND (BOOKING_NUM=? OR OPER_NUM=?) AND ROWNUM=1*/
			pstmt.setString(1,facility_id);
			pstmt.setString(2,booking_num);
			pstmt.setString(3,oper_num);
		trace="4";
			rst = pstmt.executeQuery();
			if(rst.next()){
				pick_list=true;
			}
			if(pstmt!=null)			pstmt.close();
			if(rst!=null)           rst.close();
			if(pick_list==true){
				 pstmt = con.prepareStatement(PICK_LIST_DEFINED);
				 pstmt.setString(1,facility_id);
				 pstmt.setString(2,patient_id);
				 pstmt.setString(3,surgeon_code);
				 pstmt.setString(4,booking_num);
				 pstmt.setString(5,oper_num);
		trace="5";
				 rst = pstmt.executeQuery();
				while(rst.next()){
					++index;	
					line_no = (String)line_no_map.get(rst.getString("OPR_CODE"));
                if(("true").equals(bill_flag))
			    {
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
				//ArrayList bill_dtls=or_bean.getBillChargeDetails(visit_id,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info			 = billing_bean.formatBillingDetails(bill_dtls);
				bill_info.putAll(hash);
				bill_info.put("quantity",p_qty);
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
		/*oper_code,oper_desc,line_no,package_code,package_desc,quantity,remarks,index,mode,order	*/	out.println("<script>loadDBRows('"+checkForNull(rst.getString("OPR_CODE"))+"','"+encode(checkForNull(rst.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+encode(checkForNull(rst.getString("ACC_DESC")))+"','"+checkForNull(rst.getString("TR_NO"))+"','','"+index+"','L','2','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"'); </script>");	
			}//end of while loop
			if(pstmt!=null)			pstmt.close();
			if(rst!=null)           rst.close();
			out.println("<script>refresh()</script>");
			out.println("<script>assignRecId()</script>");
		} else {

			//PICK_LIST_UNDEFINED;
			/*PICK_LIST_UNDEFINED="SELECT A.OPER_CODE OPR_CODE,C.SHORT_DESC OPR_DESC,A.PACKAGE_CODE ACC_CODE,B.SHORT_DESC ACC_DESC,A.PACKAGE_QTY TR_NO FROM OT_OPER_PACKAGE A,OT_PACKAGE_HDR B,OT_OPER_MAST C WHERE  A.OPER_CODE IN ("+oper_codes.toString()+") AND  A.PACKAGE_CODE  = B.PACKAGE_CODE AND A.OPER_CODE = C.OPER_CODE";*/
			//PICK_LIST_UNDEFINED="SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.PACKAGE_CODE ACC_CODE,   B.SHORT_DESC ACC_DESC,   A.PACKAGE_QTY TR_NO FROM    OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'AOPR' AND A.PACKAGE_CODE     = B.PACKAGE_CODE  AND C.OPER_CODE IN ("+oper_codes.toString()+") UNION SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.PACKAGE_CODE ACC_CODE,  B.SHORT_DESC ACC_DESC,   A.PACKAGE_QTY TR_NO FROM    OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SSPL'AND A.SPECIALITY_CODE = C.SPECIALITY_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+") AND A.PACKAGE_CODE     = B.PACKAGE_CODE  UNION SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.PACKAGE_CODE ACC_CODE, B.SHORT_DESC ACC_DESC,   A.PACKAGE_QTY TR_NO  FROM OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SCAT' AND A.SPECIALITY_CODE   = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE    = D.OPER_CAT_CODE    AND D.OPER_CODE  IN ("+oper_codes.toString()+") AND C.OPER_CODE  = D.OPER_CODE     AND A.PACKAGE_CODE     = B.PACKAGE_CODE UNION SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.PACKAGE_CODE ACC_CODE, B.SHORT_DESC ACC_DESC,   A.PACKAGE_QTY TR_NO  FROM OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND A.OPER_SUB_CAT_CODE  = D.OPER_SUB_CAT_CODE  AND D.OPER_CODE IN ("+oper_codes.toString()+")  AND C.OPER_CODE = D.OPER_CODE AND A.PACKAGE_CODE     = B.PACKAGE_CODE  UNION SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.PACKAGE_CODE ACC_CODE, B.SHORT_DESC ACC_DESC,   A.PACKAGE_QTY TR_NO FROM    OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SOPR' AND A.OPER_CODE IN ("+oper_codes.toString()+") AND A.OPER_CODE  = C.OPER_CODE  AND A.PACKAGE_CODE = B.PACKAGE_CODE";
			PICK_LIST_UNDEFINED="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE,   GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO FROM    OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'AOPR' AND A.PACKAGE_CODE     = B.PACKAGE_CODE  AND C.OPER_CODE IN ("+oper_codes.toString()+") UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO FROM    OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SSPL'AND A.SPECIALITY_CODE = C.SPECIALITY_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+") AND A.PACKAGE_CODE     = B.PACKAGE_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO  FROM OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SCAT' AND A.SPECIALITY_CODE   = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE    = D.OPER_CAT_CODE    AND D.OPER_CODE  IN ("+oper_codes.toString()+") AND C.OPER_CODE  = D.OPER_CODE     AND A.PACKAGE_CODE     = B.PACKAGE_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO  FROM OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND A.OPER_SUB_CAT_CODE  = D.OPER_SUB_CAT_CODE  AND D.OPER_CODE IN ("+oper_codes.toString()+")  AND C.OPER_CODE = D.OPER_CODE AND A.PACKAGE_CODE     = B.PACKAGE_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO FROM    OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SOPR' AND A.OPER_CODE IN ("+oper_codes.toString()+") AND A.OPER_CODE  = C.OPER_CODE  AND A.PACKAGE_CODE = B.PACKAGE_CODE";
			pstmt = con.prepareStatement(PICK_LIST_UNDEFINED);
		trace="6";
			rst = pstmt.executeQuery();
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
				//ArrayList bill_dtls=or_bean.getBillChargeDetails(visit_id,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
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
			/*oper_code,oper_desc,line_no,package_code,package_desc,quantity,remarks,index,mode,order	*/
	out.println("<script>loadDBRows('"+checkForNull(rst.getString("OPR_CODE"))+"','"+encode(checkForNull(rst.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+encode(checkForNull(rst.getString("ACC_DESC")) )+"','"+checkForNull(rst.getString("TR_NO"))+"','','"+index+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"'); </script>");	
		}//end of while loop
		if(pstmt!=null)			pstmt.close();
			if(rst!=null)           rst.close();
		out.println("<script>refresh()</script>");
		out.println("<script>assignRecId()</script>");

	}


}
    else
		{
		    out.println("<script>refresh()</script>");
			out.println("<script>assignRecId()</script>");
		}
		pstmt = con.prepareStatement(SQL1);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		trace="7";
		rst = pstmt.executeQuery();
	%>


<table border='0' cellpadding=3 cellspacing='0' width='100%' align='center'>
<tr>
	 
<td class="label" width="25%" ><fmt:message key="Common.operation.label" bundle="${common_labels}"/> </td>
     <td width="25%" >
		<select name="operation" id="operation"  <%=disable_flag%> >
		<% while(rst.next()){ 
			//OPR_CODE + LN_NO
			val = rst.getString(1)+"##"+rst.getString(2);
			
		%>
		<option value='<%=val%>' > <%=rst.getString(3)%>  </option>
	<%}%>
	</select>
	 <img src='../../eCommon/images/mandatory.gif'></img>
    </td>
<!--  </tr> -->
	
	<%
		}catch(Exception e){
		 System.err.println("Consumable^^Err Msg in ConsumablePacksRecord"+e.getMessage());
		 System.err.println("Consumable^^Err Msg in ConsumablePacksRecord at trace="+trace);
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
  %>
		

<!-- <tr>  -->
	  <td class="label" width="25%" ><fmt:message key="Common.Package.label" bundle="${common_labels}"/> </td>
	  <td width="25%">
		  <input type='hidden' name='package_code' id='package_code' > 
		  <input type='text' name='package_desc' id='package_desc' disabled> 
		  <input type='button' class='button' value='?' name='PackageLookUp' id='PackageLookUp' onClick='searchPackage(package_code,package_desc);'<%=disable_flag%> > <img src='../../eCommon/images/mandatory.gif'></img>
	  </td>
 </tr>
<tr>
	 <td class="label" width="25%" ><fmt:message key= "eOT.NoofUnits.Label" bundle="${ot_labels}"/></td>
     <td width="25%">
		<input type='text' name='quantity' id='quantity' maxlength='3' size='2' onBlur="ChkNumber(this);"  <%=disable_flag%> > 
		 <img src='../../eCommon/images/mandatory.gif'></img>
	</td>
<!-- </tr>

<tr> -->
	 <td class="label" width="25%" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </td>
     <td width="25%">
		<textarea  name='remarks' ROWS='3'COLS='40' onBlur="checkLimit(this,100)" <%=disable_flag%> ></textarea>
	</td>
</tr>

    <td></td>
	<td></td>
	<td></td>
	<td class="fields" width="25%">
		<input type='button' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='assignCodes(document.forms[0].operation);addRow();'  <%=disable_flag%> >
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

