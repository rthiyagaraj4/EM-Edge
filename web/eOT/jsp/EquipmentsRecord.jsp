<!DOCTYPE html>
<%@page   import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.util.HashMap,eOR.OrderEntryBillingQueryBean,eOT.OTBillingBean" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/Common.jsp"%>
<%
	
	String or_bean_id 				= "Or_billingQueryBean";
	String or_bean_name 			= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean			= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	

	String bean_id 				= "OTBillingBean";
	String bean_name 			= "eOT.OTBillingBean";
	OTBillingBean billing_bean			= (OTBillingBean)getBeanObject( bean_id, bean_name, request ) ;
	


	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");

	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>

<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<script language="JavaScript" src="../../eOT/js/RecordNursing.js"></script>
<script language="JavaScript" src="../../eOT/js/Equipment.js"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script language='javascript'>
function Class_row()
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
  this.recId="";
  this.bill_str="";
  this.panel_str="";
  this.key="";
  this.key_line="";
   this.rate="";
	this.desiredDate="";//47546
}

function callPopulateList(flag){}

function loadCodes(){
	var formObj = document.EquipmentRecordForm;
	var codes =  formObj.operation.value;
	var arr = codes.split("##");
	//alert(arr);
	formObj.oper_code.value=arr[0];
	formObj.oper_line_no.value=arr[1];
}

function assignCodes(obj){
	var formObj = document.EquipmentRecordForm;
	var codes =  obj.value;
    var arr = codes.split("##");
	//alert(arr);
	formObj.oper_code.value=arr[0];
	formObj.oper_line_no.value=arr[1];
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

/*function disableDocLevel(){
   var formObj = parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
   formObj.doc_level.disabled=true;
}*/

function loadDBRows(oper_code,oper_desc,line_no,instr_code,instr_desc,tray_no,remarks,index,mode,order,bill_str,panel_str,key,key_line,quantity, desiredDate){ //47546
	//alert("bill_str--->"+bill_str);
  var objrow = newRow();
  var rows=parent.parent.parent.ObjectCollect.equipment_rows;
  var rowLength=parent.parent.parent.ObjectCollect.equipment_len;
  if(mode=='L' && rowLength==0){
	  objrow.oper_code=oper_code;
	  objrow.oper_desc=decodeURIComponent(oper_desc,"UTF-8").replace(/\+/g," ");
	  objrow.equip_code=instr_code;	  
	  objrow.equip_desc=decodeURIComponent(instr_desc,"UTF-8").replace(/\+/g," ");
	  objrow.oper_line_no=line_no;
	  objrow.equip_id=tray_no;
	  objrow.quantity=quantity;
	  objrow.remarks=decodeURIComponent(remarks,"UTF-8").replace(/\+/g," ");
	  objrow.recId = index;
	  objrow.db_mode=(order==1)?"L":"I";
	  objrow.order = order;
	  objrow.bill_str=bill_str;
	  objrow.panel_str=panel_str;
	  objrow.key=key;
	  objrow.key_line=key_line;
	  objrow.desiredDate=desiredDate;//47546
	  objrow.rate="";
	  rows.push(objrow);
	  //alert(rows.toString());
	 }
	 
}
function refresh(){
	 var formObj = document.EquipmentRecordForm;
	 var params = formObj.params.value;
	 parent.ResultsFrame.location.href='../../eOT/jsp/EquipmentsDtls.jsp?'+params;
}

function addRow(){
	var objrow = newRow();
  var msg = trimString(getMessage("CODE_ALREADY_EXISTS","Common"));
  var rows=parent.parent.parent.ObjectCollect.equipment_rows;
  var formObj = document.EquipmentRecordForm;
  var params = formObj.params.value;
  var mode =formObj.mode.value;
  var obj = formObj.operation;
  var bill_flag=document.forms[0].bill_flag.value;
  var key = formObj.oper_num.value+"@"+formObj.oper_code.value+"@E"+"@"+formObj.equip_code.value;
  if(chkEmpty()){
	if(mode=='I'){
	   if(alreadyExist()){
		if(bill_flag=="true")  // added by sathish to disable Billing part
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
			objrow.equip_code=formObj.equip_code.value;
			objrow.equip_desc=formObj.equip_desc.value;
			objrow.oper_line_no = formObj.oper_line_no.value;
			objrow.equip_id = formObj.equip_id.value;
			objrow.remarks = formObj.remarks.value;
			//ADDED FOR BILLING
			/*var retVal = callOrderLineCreation();
			var arr = retval.split("@@");
			panel_str = arr[0];
			bill_str = arr[1];*/
			objrow.recId = getRecId();
			objrow.db_mode="I";
			//var retVal = callOrderLineCreation();
			if(bill_flag=="true")
		    {
			var arr = retVal.split("@@");
			objrow.panel_str = arr[0];
			objrow.bill_str = arr[1];
			}
			objrow.key=key;
			objrow.key_line="";
			rows.push(objrow);
			resetFields();
			parent.ResultsFrame.location.href='../../eOT/jsp/EquipmentsDtls.jsp?'+params;
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
	var equip_code = formObj.equip_code.value;
	var oper_code = (formObj.operation.value).split("##")[0];
	var param = "oper_num="+oper_num+"&acc_type=E&called_from=ACC_TAB&acc_code="+equip_code+"&oper_code="+oper_code;
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
	var formObj = document.EquipmentRecordForm;
	var codeDtl = parent.ResultsFrame.code; 
	var oper_code=formObj.oper_code.value;
	var equip_code = formObj.equip_code.value;
	var codeRecord = oper_code+equip_code;
	if(codeDtl.indexOf(codeRecord)>=0)
	   return false;
	else
	  return true;
}

 function assignRecId(){
	var rows = parent.parent.parent.ObjectCollect.equipment_rows;
	parent.parent.parent.ObjectCollect.equipment_len=rows.length;
}

function getRecId(){
    var rowLength=parent.parent.parent.ObjectCollect.equipment_len;
	var recId = rowLength+1;
	parent.parent.parent.ObjectCollect.equipment_len = recId;
	return recId;
}

function chkEmpty(){
	var formObj = document.EquipmentRecordForm;
	var fields = new Array(formObj.operation,formObj.equip_desc);
	var operation_title=getLabel("Common.operation.label","common");
	var equipment_title=getLabel("Common.equipment.label","common");
	var names = new Array(operation_title,equipment_title);
	var messageFrame = parent.parent.parent.messageFrame;
	if(checkFields( fields, names, messageFrame))
		return true;
}

function removeRow(){

var formObj = document.EquipmentRecordForm;
var params = formObj.params.value;
var rows=parent.parent.parent.ObjectCollect.equipment_rows;
var recId = document.forms[0].recId.value;
var mode = document.forms[0].mode.value;
if(rows.length>0 && mode=='U'){        
  for(var jj=0;jj<rows.length;jj++){
	 if(rows[jj]!=null){
		 //alert("rows[jj].order--->"+rows[jj].order)
		if(rows[jj].recId==recId){
			DeleteKey(rows[jj].key+rows[jj].key_line);
			if( (rows[jj].db_mode=='L' || rows[jj].db_mode=='U') && (rows[jj].order=='1' ) )
			 {rows[jj].db_mode='D';}
			 else
			  delete rows[jj];
			   break;
		}
	 }else
	continue;
 }//end for-Loop
 resetFields();
 parent.ResultsFrame.location.href='../../eOT/jsp/EquipmentsDtls.jsp?'+params;
 parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
}else
   resetFields();
}

function updateRow(){
	var formObj = document.EquipmentRecordForm;
	var params = formObj.params.value;
	var	equip_code=formObj.equip_code.value;
	var	equip_desc=formObj.equip_desc.value;
	var	equip_id = formObj.equip_id.value;
	var	remarks = formObj.remarks.value;
	var mode =formObj.mode.value;
	var recId = formObj.recId.value;
	var rows=parent.parent.parent.ObjectCollect.equipment_rows;
		if(rows.length>0 && mode=='U'){        
			for(var jj=0;jj<rows.length;jj++){
				if(rows[jj]!=null) {
					if(rows[jj].recId==recId){
						//rows[jj].equip_code=equip_code;
						//rows[jj].equip_desc=equip_desc;	
			            rows[jj].equip_id=equip_id;
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
	  parent.ResultsFrame.location.href='../../eOT/jsp/EquipmentsDtls.jsp?'+params;
	}
}

function splitString(strVal){
    var arr = strVal.split('::');
	var formObj = document.EquipmentRecordForm;
	formObj.oper_code.value=arr[0];
	formObj.operation.value=arr[1];
	formObj.oper_line_no.value = arr[2];
	formObj.equip_code.value=arr[3];
	formObj.equip_desc.value=arr[4];
	formObj.remarks.value=arr[5];
	formObj.equip_id.value=arr[6];
	formObj.recId.value = arr[7];
	formObj.mode.value = arr[8];
	formObj.operation.disabled=true;
	formObj.EquipmentLookUp.disabled=true;
	
}

function resetFields(){
	var formObj = document.EquipmentRecordForm;
	//formObj.operation.value=formObj.operation.value;
	formObj.equip_code.value='';
	formObj.equip_desc.value='';
	formObj.oper_code.value='';
	formObj.equip_id.value='';
	formObj.remarks.value='';
	formObj.mode.value='I';
	formObj.operation.disabled=false;
	formObj.EquipmentLookUp.disabled=false;
    formObj.operation.focus();
	//frmObj.InstrumentLookUp.disabled=false;
	
}

function localTrimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="loadCodes();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<% String params = request.getQueryString(); %>
<form name = 'EquipmentRecordForm'>
<input type='hidden' name='params' id='params' value='<%=params%>' >
<%  String bill_flag = request.getParameter("bill_flag");
	String p_qty = "";
	//String called_from =  checkForNull(request.getParameter("called_from"));
	String oper_num = checkForNull(request.getParameter("oper_num"));
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String booking_num = checkForNull(request.getParameter("booking_num"));
	String surgeon_code = checkForNull(request.getParameter("surgeon_code"));
	String key = "";
	String key_line="";
	String desiredDate = "";//47546
	String bill_str="";
	String panel_str="";
	HashMap bill_info=new HashMap();
	StringBuilder bl_bfr = new StringBuilder();
	StringBuffer oper_codes = new StringBuffer();
	String order_id="";
	String order_line_num="";
	String booking_date  = "";
	String encounter_id   = "";
	String patient_class   = "";
	String visit_id   = "";
	String catalog_code   = "";
	String rst_acc_code = "";
	HashMap line_no_map = new HashMap();
	String line_no="";
	boolean exist_rec = false;
	boolean pick_list = false;
	String  nursing_doc_comp_yn = checkForNull(request.getParameter("nursing_doc_comp_yn"));
	String currentDateTime = com.ehis.util.DateUtils.getCurrentDate("DMYHM", locale);//47546
	String disable_flag="";
	if( nursing_doc_comp_yn.equals("Y") )
	  disable_flag="disabled";
	 else 
	   disable_flag="";
	
	String SQL_EXIST = "SELECT ACCESSORY_CODE FROM OT_SURGICAL_ACCESSORIES WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? AND ROWNUM=1";
	//this query checks whether we have already record in OT_PICK_LISTS Table if returns true="PICK_LIST_DEFINED Qry is executed otherwise PICKlIST_UNDEFINED Qry is executed"
	String PICK_LIST_EXIST_YN = "SELECT OPER_CODE FROM OT_PICK_LISTS WHERE OPERATING_FACILITY_ID=? AND (BOOKING_NUM=? OR OPER_NUM=?)";
	String PICK_LIST_DEFINED="SELECT A.OPER_CODE OPR_CODE,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC ,A.ITEM_ID ACC_CODE,GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.ITEM_ID)  ACC_DESC,A.ITEM_QTY TR_NO FROM  OT_PICK_LISTS A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.TEAM_DOCTOR_CODE  = ? AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'E' AND A.ITEM_ID = B.EQUIPMENT_CODE";
	String PICK_LIST_UNDEFINED="";
	//String SQL = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.ACCESSORY_CODE) ACC_DESC, A.EQUIPMENT_ID TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE, A.Quantity actual_units, NVL (TO_CHAR (desired_date, 'DD/MM/YYYY HH24:MI'), TO_CHAR (a.added_date, 'DD/MM/YYYY HH24:MI') ) desired_date  FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_EQUIPMENT C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND ACCESSORY_TYPE = 'E' AND A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.EQUIPMENT_CODE";
	//SKR-SCF-0984 [IN:048580]
	//Modified against MMS-QH-CRF-0199
	String SQL ="SELECT a.oper_code opr_code, a.oper_line_num ln_num,get_desc ('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',a.oper_code) opr_desc, a.accessory_code acc_code,get_desc ('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',a.accessory_code) acc_desc,a.equipment_id tr_no, a.remarks remks, bill_sub_regn_num KEY,bill_sub_regn_line_num key_line, a.quantity actual_units, DECODE (?, 'en', NVL (TO_CHAR (desired_date, 'DD/MM/YYYY HH24:MI'),TO_CHAR (a.added_date, 'DD/MM/YYYY HH24:MI') ), 'th', NVL (TO_CHAR (desired_date, 'DD/MM/YYYY HH24:MI','NLS_CALENDAR=''THAI BUDDHA'''),TO_CHAR (a.added_date, 'DD/MM/YYYY HH24:MI','NLS_CALENDAR=''THAI BUDDHA''') ) ) desired_date  FROM ot_surgical_accessories a, ot_oper_mast b, ot_equipment c WHERE a.operating_facility_id =? AND a.oper_num = ? AND accessory_type = 'E' AND a.oper_code = b.oper_code  AND a.accessory_code = c.equipment_code";
	String SQL1 = "SELECT A.OPER_CODE OPR_CODE,A.OPER_LINE_NUM LN_NUM,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC FROM OT_POST_OPER_DTLS A, OT_OPER_MAST_LANG_VW B WHERE B.LANGUAGE_ID = ? AND OPERATING_FACILITY_ID=? AND OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE";
	Connection con = null;
	PreparedStatement pstmt = null;
	String val= "";
	ResultSet rst = null;
	
	int index=0;
	try{
		con = ConnectionManager.getConnection(request);
		//pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_PERSONNEL_SELECT2")) ;

		pstmt = con.prepareStatement(SQL1);
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,oper_num);
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

		if(rst!=null)		rst.close();
		if(pstmt !=null)  pstmt.close();

		pstmt = con.prepareStatement(SQL_EXIST);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();
		if(rst.next()){
			exist_rec=true;
		}
		if(rst!=null)		rst.close();
		if(pstmt !=null)  pstmt.close();
		if(exist_rec==true){
		pstmt = con.prepareStatement(SQL);		
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,oper_num);
		rst = pstmt.executeQuery();
		while(rst.next()){
		   ++index;	
			
			key = rst.getString("KEY");
			key_line = rst.getString("KEY_LINE");
			desiredDate = checkForNull(rst.getString("desired_date"));//47546
			//or_bean.clearBean();
			if(("true").equals(bill_flag))// added this condition by sathish on 10-01-2009 to disabling billingpart 
			{
			bill_info = or_bean.getOrderBillDtls(key+key_line);
			if(bill_info==null){
				bill_info = new HashMap();
				bill_info.put("key",key);
				bill_info.put("key_line_no",key_line);
				rst_acc_code = rst.getString("ACC_CODE");
				bill_info.put("oper_code",rst_acc_code);//pass acc_code in oper_code
				bill_info.put("acc_type","E");
				bill_info.put("oper_num",oper_num);
				bill_info.put("locale",locale);
				bill_info.put("module_id","OT");
				bill_info.put("quantity","1");
				//populate billing details from OTBillingBean........	
				bill_info = billing_bean.getBillingParams(bill_info,"C");//C-> for Surgical Accessories Billing
/*test code		
				catalog_code = "E#"+rst_acc_code;
				ArrayList bill_dtls=or_bean.getBillChargeDetails("1",catalog_code,(String)bill_info.get("service_date"),locale,order_id,order_line_num,patient_id,(String)bill_info.get("encounter_id"),(String)bill_info.get("patient_class"),(String)bill_info.get("pract_staff_id"));	
				bill_info	= billing_bean.formatBillingDetails(bill_dtls);
				bill_info.putAll(bill_info);
			//set billing details from OTBillingBean........	
// test code ends here  */

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
			out.println("<script>loadDBRows('"+checkForNull(rst.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("OPR_DESC")),"UTF-8")+"','"+checkForNull(rst.getString("LN_NUM"))+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("ACC_DESC")),"UTF-8")+"','"+checkForNull(rst.getString("TR_NO"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("REMKS")),"UTF-8")+"','"+index+"','L','1','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','"+checkForNull(rst.getString("actual_units"))+"','"+desiredDate+"'); </script>");	//47546

		}
		if(rst!=null)		rst.close();
		if(pstmt !=null)  pstmt.close();
		out.println("<script>refresh()</script>");
		out.println("<script>assignRecId()</script>");
	}else if(nursing_doc_comp_yn.equals("N")){

			
		pstmt = con.prepareStatement(PICK_LIST_EXIST_YN);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,booking_num);
		pstmt.setString(3,oper_num);
		
		rst = pstmt.executeQuery();
		if(rst.next()){
			pick_list=true;
		}
		if(rst!=null)		rst.close();
		if(pstmt !=null)  pstmt.close();
		if(pick_list==true){
			 pstmt = con.prepareStatement(PICK_LIST_DEFINED);
			 //pstmt.setString(1,locale);
			 pstmt.setString(1,facility_id);
			 pstmt.setString(2,patient_id);
			 pstmt.setString(3,surgeon_code);
			 pstmt.setString(4,booking_num);
			 pstmt.setString(5,oper_num);
			 rst = pstmt.executeQuery();
			 while(rst.next()){
					++index;	
					line_no = (String)line_no_map.get(rst.getString("OPR_CODE"));
					
				HashMap hash = billing_bean.getORBillingParams(oper_num);
				catalog_code = "E#"+rst.getString("ACC_CODE");
				key = oper_num+"@"+rst.getString("OPR_CODE")+"@S@"+rst.getString("ACC_CODE");
				key_line="";
				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				//ArrayList bill_dtls=or_bean.getBillChargeDetails(visit_id,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				if(("true").equals(bill_flag))
			    {
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
				}//end of if bill_flag
			 out.println("<script>loadDBRows('"+checkForNull(rst.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("OPR_DESC")),"UTF-8")+"','"+line_no+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("ACC_DESC")),"UTF-8")+"','"+checkForNull(rst.getString("TR_NO"))+"','','"+index+"','L','2','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','','"+currentDateTime+"'); </script>");	//47546
			 }//end of while loop
			 if(rst!=null)		rst.close();
		if(pstmt !=null)  pstmt.close();
			out.println("<script>refresh()</script>");
			out.println("<script>assignRecId()</script>");
		} else {
				
				/*PICK_LIST_UNDEFINED="SELECT A.OPER_CODE OPR_CODE,C.SHORT_DESC OPR_DESC,A.EQUIPMENT_CODE ACC_CODE,B.SHORT_DESC ACC_DESC, A.NO_OF_UNITS TR_NO FROM   OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE  A.OPER_CODE IN ("+oper_codes.toString()+") AND A.EQUIPMENT_CODE = B.EQUIPMENT_CODE AND A.OPER_CODE = C.OPER_CODE";*/
				
				/*PICK_LIST_UNDEFINED="SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,  B.SHORT_DESC ACC_DESC,   A.NO_OF_UNITS TR_NO FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY        = 'AOPR'     AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE   AND C.OPER_CODE IN ("+oper_codes.toString()+") UNION SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,  B.SHORT_DESC ACC_DESC,   A.NO_OF_UNITS TR_NO 	FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY   = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN  ("+oper_codes.toString()+") AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION		SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.EQUIPMENT_CODE ACC_CODE, 	  B.SHORT_DESC ACC_DESC,   A.NO_OF_UNITS TR_NO  FROM OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY  = 'SCAT'     AND A.SPECIALITY_CODE   = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE    = D.OPER_CAT_CODE    AND D.OPER_CODE            IN ("+oper_codes.toString()+") AND C.OPER_CODE           = D.OPER_CODE AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.EQUIPMENT_CODE ACC_CODE, B.SHORT_DESC ACC_DESC,   A.NO_OF_UNITS TR_NO  FROM OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB'  AND A.SPECIALITY_CODE       = D.OPER_GROUP_CODE  AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE AND D.OPER_CODE  IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE  AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,  B.SHORT_DESC ACC_DESC,   A.NO_OF_UNITS TR_NO FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY   = 'SOPR' AND A.OPER_CODE IN ("+oper_codes.toString()+") AND A.OPER_CODE  = C.OPER_CODE AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE";*/

				PICK_LIST_UNDEFINED="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE, GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE  A.APPLICABILITY = 'AOPR' AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE   AND C.OPER_CODE IN ("+oper_codes.toString()+") UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC, A.NO_OF_UNITS TR_NO 	FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE   A.APPLICABILITY   = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN  ("+oper_codes.toString()+") AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION	SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO  FROM OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY  = 'SCAT' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE    = D.OPER_CAT_CODE AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE, GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO  FROM OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB'  AND A.SPECIALITY_CODE       = D.OPER_GROUP_CODE  AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE AND D.OPER_CODE  IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE  AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,  A.NO_OF_UNITS TR_NO FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY   = 'SOPR' AND A.OPER_CODE IN ("+oper_codes.toString()+") AND A.OPER_CODE  = C.OPER_CODE AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE";
				
			
				pstmt = con.prepareStatement(PICK_LIST_UNDEFINED);
				rst = pstmt.executeQuery();
				while(rst.next()){
					++index;	
					
					line_no = (String)line_no_map.get(rst.getString("OPR_CODE"));

					//HashMap hash = billing_bean.getORBillingParams(oper_num);
					HashMap hash = billing_bean.getORBillingParams(oper_num);
				catalog_code = "E#"+rst.getString("ACC_CODE");
				key = oper_num+"@"+rst.getString("OPR_CODE")+"@S@"+rst.getString("ACC_CODE");
				key_line="";
				booking_date	= (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id	= (String)hash.get("encounter_id");
				surgeon_code	= (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id		= (String)hash.get("visit_id");
				//ArrayList bill_dtls=or_bean.getBillChargeDetails(visit_id,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
                if(("true").equals(bill_flag))
			    {
				ArrayList bill_dtls=or_bean.getBillChargeDetails("1",catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				//ArrayList bill_dtls=or_bean.getBillChargeDetails(visit_id,catalog_code,"31/10/2007 10:00",locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info			 = billing_bean.formatBillingDetails(bill_dtls);
					hash.put("key",key);
					hash.put("key_line_no",key_line);
					hash.put("oper_code",rst.getString("ACC_CODE"));//pass acc_code in oper_code
					hash.put("acc_type","E");
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
					
		out.println("<script>loadDBRows('"+checkForNull(rst.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("OPR_DESC")),"UTF-8")+"','"+line_no+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("ACC_DESC")),"UTF-8")+"','"+checkForNull(rst.getString("TR_NO"))+"','','"+index+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','','"+currentDateTime+"'); </script>");	//47546
			 }//end of while loop
			 if(rst!=null)		rst.close();
		if(pstmt !=null)  pstmt.close();
			out.println("<script>refresh()</script>");
			out.println("<script>assignRecId()</script>");

		}//end of if loop 
			
	}
	 else
		{
		   out.println("<script>refresh()</script>");
		   out.println("<script>assignRecId()</script>");
		}
		pstmt = con.prepareStatement(SQL1);
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,oper_num);
		rst = pstmt.executeQuery();
	%>


<table border='0' cellpadding=3 cellspacing='0' width='100%' align='center'>
<tr>
	 
<td class="label" width="25%" ><fmt:message key="Common.operation.label" bundle="${common_labels}"/> </td>
     <td class="fields" width="25%" >
		<select name="operation" id="operation" <%=disable_flag%> >
		<% while(rst.next()){ 
			//OPR_CODE + LN_NO
			val = rst.getString(1)+"##"+rst.getString(2);
					
			
		%>
		<option value='<%=val%>' > <%=rst.getString(3)%>  </option>
	<%}%>
	</select>
	 <img src='../../eCommon/images/mandatory.gif'></img>
    </td>
 <!-- </tr> -->
	
	<%
		}catch(Exception e){
		 System.err.println("EQP Record: Err Msg in EquipmentRecord"+e.getMessage());
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
  %>
		

<!-- <tr> --> 
	  <td class="label" width="25%" >
		<fmt:message key="Common.equipment.label" bundle="${common_labels}"/> 
	  </td>
	  <td width="25%" class="fields">
		  <input type='hidden' name='equip_code' id='equip_code' > 
		  <input type='text' name='equip_desc' id='equip_desc' disabled> 
		  <input type='button' class='button' value='?' name='EquipmentLookUp' id='EquipmentLookUp' onClick='searchEquipments(equip_code,equip_desc);' <%=disable_flag%> > <img src='../../eCommon/images/mandatory.gif'></img>
	  </td>
 </tr>
<tr>
	 <td class="label" width="25%" ><fmt:message key="eOT.EquipmentID.Label" bundle="${ot_labels}"/>  </td>
     <td width="25%" class="fields">
		<input type='text' name='equip_id' id='equip_id' maxlength='20' size='20' <%=disable_flag%> > 
	</td>
<!-- </tr>

<tr> -->
	 <td class="label" width="25%" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </td>
     <td width="25%" class="fields">
		<textarea name='remarks' ROWS='3' COLS='40' onBlur="checkLimit(this,100)" <%=disable_flag%> > </textarea>
	</td>
</tr>
	<td class="label" width="25%"></td>
	<td class="label" width="25%"></td>
	<td class="label" width="25%"></td>
	<td class="fields" width="25%">
		<input type='button' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='assignCodes(document.forms[0].operation);addRow();'  <%=disable_flag%>  >
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

