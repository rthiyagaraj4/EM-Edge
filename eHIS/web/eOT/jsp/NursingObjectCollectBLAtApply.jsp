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
	String facility_id  = (String) session.getValue("facility_id");
	String trace="0";

	String or_bean_id 				= "Or_billingQueryBean";
	String or_bean_name 			= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean			= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	or_bean.clearBean();

	String bean_id 				= "OTBillingBean";
	String bean_name 			= "eOT.OTBillingBean";
	OTBillingBean billing_bean	= (OTBillingBean)getBeanObject( bean_id, bean_name, request ) ;

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language="JavaScript" src="../../eOT/js/RecordNursing.js"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>

<script language='javascript'>

function Class_row(load_rows_type){
	if(load_rows_type=="S"){
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
	}else if(load_rows_type=="E"){
		this.oper_code ="";
		this.oper_desc="";
		this.equip_code="";
		this.equip_desc="";
		this.oper_line_no ="";
		this.equip_id ="";
		this.remarks ="";
		this.quantity ="";
		this.order="";
		this.accessory_type="";
		this.db_mode="";
		this.recId="";
		this.bill_str="";
		this.panel_str="";
		this.key="";
		this.key_line="";
		this.rate="";
	}else if(load_rows_type=="C"){
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
		this.reserved_qty="";
		this.requested_qty="";
		this.req_store_code="";
		this.rate="";
	}else if(load_rows_type=="I"){
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
		this.sale_document_no ="";
		this.sale_document_type ="";
		this.req_store_code="";
		this.Store_desc="";
		this.Stockavail = "";
		this.bill_str="";
		this.bill_str_conspack="";
		this.panel_str="";
		this.panel_str_conspack="";
		this.key="";
		this.key_line="";
		this.rate="";
	}
}

function loadCodes(){
/*
	var formObj = document.AllAccessoriesRecordForm;
	var codes =  formObj.operation.value;
    var arr = codes.split("##");
	//alert(arr);
	formObj.oper_code.value=arr[0];
	formObj.oper_line_no.value=arr[1];
*/
}

function assignCodes(obj){
	var formObj = document.AllAccessoriesRecordForm;
	var codes =  obj.value;
    var arr = codes.split("##");
	//alert(arr);
	formObj.oper_code.value=arr[0];
	formObj.oper_line_no.value=arr[1];
}

function loadInstrumentRows(oper_code,oper_desc,line_no,instr_code,instr_desc,tray_no,remarks,index,oper_num,mode,order,bill_str,panel_str,key,key_line,frompicklist,quantity){ 
  //alert("In loadInstrumentRows, mode:"+mode);
  //alert("In loadInstrumentRows, rowLength:"+rowLength);
//alert(parent.ObjectCollect.hello);
/*alert("mode---->"+mode)
alert("oper_code---->"+oper_code)
alert("oper_desc---->"+oper_desc)
alert("line_no---->"+line_no)
alert("instr_code---->"+instr_code)
alert("instr_desc---->"+instr_desc)
alert("instr_desc---->"+instr_desc)
alert("order---->"+order)
alert("panel_str---->"+panel_str)
alert("key---->"+key)
alert("key_line---->"+key_line)*/
 //alert("BLAt apply");
 //alert("order----->"+order)
  var rows=parent.ObjectCollect.instrument_rows;
  var rowLength=parent.ObjectCollect.instrument_len;
   //alert("rowLength---->"+rowLength);
   if(mode=='L' && (rowLength==0 || rowLength==undefined || rowLength=="undefined") ){

	   //alert("162");
	  var objrow = newRow("S");
	  objrow.oper_code=oper_code;
	  objrow.oper_desc=decodeUTF8(oper_desc);
	  objrow.instr_code=instr_code;
	  objrow.instr_desc=decodeUTF8(instr_desc);
	  objrow.oper_line_no=line_no;
	  objrow.tray_no=tray_no;
	   objrow.quantity=quantity;
	  objrow.remarks=decodeUTF8(remarks);
	  objrow.recId = index;
	  objrow.db_mode="L";
	  //objrow.db_mode=(order==1)?"L":"I";
	  objrow.order=order;
	  objrow.bill_str=bill_str;
	  objrow.panel_str=panel_str;
	  objrow.key=key;
	  objrow.key_line=key_line;
	  objrow.rate="";
	//  alert("179");
	 // alert("objrow---->"+objrow);
	  rows.push(objrow);
	//  alert("objrow.bill_str======="+objrow.bill_str);
	}
//alert(parent.ObjectCollect.createXMLForInstruments());
}

function decodeUTF8(str){
	 var REG_EXP =/\+/g;
	return decodeURIComponent(str,"UTF-8").replace(REG_EXP," ");
}

function loadEquipmentRows(oper_code,oper_desc,line_no,instr_code,instr_desc,tray_no,remarks,index,mode,order,bill_str,panel_str,key,key_line,from_picklist,quantity){ 
  //alert("In loadEquipmentRows, mode:"+mode);
  //alert("In loadEquipmentRows, rowLength:"+rowLength);
  //alert("bill_str-177-->"+bill_str);
  var objrow = newRow("E");
  var rows=parent.ObjectCollect.equipment_rows;
  var rowLength=parent.ObjectCollect.equipment_len;

  if(mode=='L' && (rowLength==0 || rowLength==undefined || rowLength=="undefined")){
	  objrow.oper_code=oper_code;
	  objrow.oper_desc=decodeURIComponent(oper_desc,"UTF-8").replace(/\+/g," ");
	  objrow.equip_code=instr_code;	  
	  objrow.equip_desc=decodeURIComponent(instr_desc,"UTF-8").replace(/\+/g," ");
	  objrow.oper_line_no=line_no;
	  objrow.equip_id=tray_no;
	  objrow.remarks=decodeURIComponent(remarks,"UTF-8").replace(/\+/g," ");
	  objrow.recId = index;
	   objrow.quantity=quantity;
	  objrow.db_mode="L";
	  //objrow.db_mode=(order==1)?"L":"I";
	  objrow.order = order;
	  objrow.bill_str=bill_str;
	  objrow.panel_str=panel_str;
	  objrow.key=key;
	  objrow.key_line=key_line;
	  objrow.rate="";
	  rows.push(objrow);
	  //alert(rows.toString());
	 }	 
}
function loadPackageRows(oper_code,oper_desc,line_no,package_code,package_desc,quantity,remarks,index,mode,order,bill_str_conspack,panel_str_conspack,key,key_line,req_store_code,reserved_qty, requested_qty){ 
  //alert("In loadPackageRows, mode:"+mode);
  //alert("In loadPackageRows, rowLength:"+rowLength);

	var objrow = newRow("C");
	var rows_copk=parent.parent.parent.ObjectCollect.packs_rows;
  var rowLength=parent.parent.parent.parent.ObjectCollect.packs_len;
 if(mode=='L' && rowLength==0){
	  objrow.oper_code=oper_code;
	  objrow.oper_desc=unescape(oper_desc);
	  objrow.package_code=package_code;
	  objrow.package_desc=unescape(package_desc);
	  objrow.oper_line_no=line_no;
	  objrow.quantity=quantity;
	   
	  objrow.reserved_qty=reserved_qty;
	  objrow.requested_qty=requested_qty;

	  objrow.remarks=unescape(remarks);
	  objrow.recId = index;
	  objrow.db_mode=(order==1)?"L":"I";
	  objrow.order = order;
	  objrow.bill_str_conspack=bill_str_conspack;
	  objrow.panel_str_conspack=panel_str_conspack;
	  objrow.key=key;
	  objrow.key_line=key_line;
	  objrow.rate="";

	  objrow.req_store_code=req_store_code;
	  rows_copk.push(objrow);
	 
	  }
//alert(parent.ObjectCollect.createXMLForPackage());
}

function loadImplantRows(oper_code,oper_desc,line_no,implant_code,implant_desc,quantity,mfgr,batch,remarks,index,mode,order,bill_str,panel_str,key,key_line,req_store_code,reserved_qty, requested_qty,no_of_units,sale_document_no,sale_document_type,Stockavail,Store_desc){ 
  //alert("In loadImplantRows, mode:"+mode);

	var objrow = newRow("I");
	var rows=parent.parent.parent.ObjectCollect.implants_rows;
    var rowLength=parent.parent.parent.parent.ObjectCollect.implants_len;

  
  if(mode=='L' && rowLength==0){
	  //alert("1384")
	  objrow.oper_code=oper_code;
	  objrow.oper_desc=unescape(oper_desc);
	  objrow.implant_code=implant_code;
	  objrow.implant_desc=unescape(implant_desc);
	  objrow.Store_desc=unescape(Store_desc);
	  objrow.oper_line_no=line_no;
	  objrow.quantity=quantity;
	  objrow.sale_document_no=sale_document_no;
	  objrow.sale_document_type=sale_document_type;

	 // objrow.quantity=no_of_units;
	  objrow.reserved_qty=reserved_qty;
	  objrow.requested_qty=requested_qty;


	  //alert("reserved_qty==="+reserved_qty)
	  
	  objrow.manufacturer=mfgr
	  objrow.batch=batch;
	  objrow.remarks=unescape(remarks);
	  objrow.order=order;
	  objrow.recId = index;
	  objrow.db_mode=(order==1)?"L":"I";
	  objrow.bill_str=bill_str;
	  objrow.panel_str=panel_str;
	  objrow.key=key;
	  objrow.key_line=key_line;
	  objrow.rate="";
	  objrow.req_store_code=req_store_code;
	  objrow.Stockavail=Stockavail;

	
	
	  rows.push(objrow);
	}
//alert(parent.ObjectCollect.createXMLForImplants());
}

function newRow(load_rows_type){
  var objrow = new Class_row(load_rows_type);
   return(objrow);
}

function assignRecId(load_rows_type){
	if(load_rows_type=="S"){// For Instruments
		var rows = parent.ObjectCollect.instrument_rows;
		parent.ObjectCollect.instrument_len=rows.length;
	}else if(load_rows_type=="E"){// For Equipments
		var rows = parent.ObjectCollect.equipment_rows;
		parent.ObjectCollect.equipment_len=rows.length;
	}else if(load_rows_type=="C"){// For Consumables
		var rows = parent.ObjectCollect.packs_rows;
		parent.ObjectCollect.packs_len=rows.length;
	}else if(load_rows_type=="I"){// For Implants
		var rows = parent.ObjectCollect.implants_rows;
		parent.ObjectCollect.implants_len=rows.length;
	}	
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="loadCodes();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name = 'AllAccessoriesRecordForm'>
<input type='hidden' name='params' id='params' value='<%=request.getQueryString()%>' >
<%
	String cssd_load_yn	= checkForNull(request.getParameter("cssd_load_yn"));
	String eqp_load_yn	= checkForNull(request.getParameter("eqp_load_yn"));
	String cons_load_yn = checkForNull(request.getParameter("cons_load_yn"));
	String imp_load_yn	= checkForNull(request.getParameter("imp_load_yn"));
	String no_of_units="";


	String oper_num = checkForNull(request.getParameter("oper_num"));
//	String facility_id = checkForNull(request.getParameter("facility_id"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
//	String booking_num = checkForNull(request.getParameter("booking_num"));	
	String surgeon_code = checkForNull(request.getParameter("surgeon_code"));
	String nursing_doc_comp_yn = checkForNull(request.getParameter("nursing_doc_comp_yn"));
	HashMap line_no_map = new HashMap();
	String line_no="";
	boolean exist_rec = false;
	boolean pick_list = false;
	StringBuffer oper_codes = new StringBuffer();

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

	String SQL1 = "SELECT A.OPER_CODE OPR_CODE,A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',B.OPER_CODE) OPR_DESC FROM OT_POST_OPER_DTLS A, OT_OPER_MAST B WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE";

	String CSSD_SQL = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE',A.ACCESSORY_CODE) ACC_DESC, A.TRAY_NO TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE ,A.Quantity actual_units FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_INSTRUMENT_LANG_VW C WHERE A.OPERATING_FACILITY_ID=? AND C.LANGUAGE_ID=? AND ACCESSORY_TYPE='I' AND A.OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.INSTR_CODE "; 
	
	String EQP_SQL = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.ACCESSORY_CODE) ACC_DESC, A.EQUIPMENT_ID TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE,A.Quantity actual_units  FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_EQUIPMENT C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND ACCESSORY_TYPE = 'E' AND A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.EQUIPMENT_CODE";

	//String CONS_SQL = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',C.PACKAGE_CODE) ACC_DESC, A.QUANTITY TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_PACKAGE_HDR_LANG_VW C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND ACCESSORY_TYPE = 'P' AND  A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.PACKAGE_CODE AND C.LANGUAGE_ID=? ORDER BY BILL_SUB_REGN_LINE_NUM"; 
	String CONS_SQL = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',C.PACKAGE_CODE) ACC_DESC, A.QUANTITY TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE,A.REQ_STORE_CODE, A.RESERVED_QTY, A.REQUESTED_QTY FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_PACKAGE_HDR_LANG_VW C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND ACCESSORY_TYPE = 'P' AND  A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.PACKAGE_CODE AND C.LANGUAGE_ID=? ORDER BY BILL_SUB_REGN_LINE_NUM"; 

	//String IMP_SQL = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.ACCESSORY_CODE) ACC_DESC, A.QUANTITY TR_NO, A.PROSTHESIS_MFR MFR,A.PROSTHESIS_BATCH_NO BTCH, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_PROSTHESIS_LANG_VW C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND ACCESSORY_TYPE = 'S' AND  A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.PROSTHESIS_CODE AND C.LANGUAGE_ID='"+locale+"' ";
	String IMP_SQL = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.ACCESSORY_CODE) ACC_DESC,GET_DESC('"+locale+"','MM_STORE_LANG_VW','SHORT_DESC','STORE_CODE',A.REQ_STORE_CODE) Store_desc, A.QUANTITY TR_NO, A.PROSTHESIS_MFR MFR,A.PROSTHESIS_BATCH_NO BTCH, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE,A.REQ_STORE_CODE, A.RESERVED_QTY, A.REQUESTED_QTY ,A.SALE_DOCUMENT_TYPE SALE_DOCUMENT_TYPE ,A.SALE_DOCUMENT_NO SALE_DOCUMENT_NO FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_PROSTHESIS_LANG_VW C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND ACCESSORY_TYPE = 'S' AND  A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.PROSTHESIS_CODE AND C.LANGUAGE_ID='"+locale+"' ";
	
	Connection con = null;
	PreparedStatement pstmt = null;
	String val= "";
	ResultSet rst = null;
	String rst_acc_code = "";
	String rst_tr_no = "";
	int index=0;
	String load_rows_type = "";
	String load_rows_yn = "";
	try{
		con = ConnectionManager.getConnection(request);
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
			for(int k=1;k<=4;k++){			
				// These are fixed consitions just for logic... Nothing functional logic is involved
				// k is iterated from 1 to 4 and for each time different acc_types are considered. k is just a dummy counter
				load_rows_type = "";
				load_rows_yn = "";
				if(k==1 && cssd_load_yn.equals("Y")){ 
					load_rows_type = "S";// Load Instruments
					load_rows_yn = "Y";
				}else if(k==2 && eqp_load_yn.equals("Y")){
					load_rows_type = "E";// Load Equipments
					load_rows_yn = "Y";
				}else if(k==3 && cons_load_yn.equals("Y")){
					load_rows_type = "C";// Load Consumables
					load_rows_yn = "Y";
				}else if(k==4 && imp_load_yn.equals("Y")){
					load_rows_type = "I";// Load Implants
					load_rows_yn = "Y";
				}else{
					load_rows_yn = "N";
				}
				if(load_rows_yn.equals("Y")){
					if(load_rows_type.equals("S")){
						pstmt = con.prepareStatement(CSSD_SQL);
						pstmt.setString(1,facility_id);
						pstmt.setString(2,locale);
						pstmt.setString(3,oper_num);
					}else if(load_rows_type.equals("E")){
						pstmt = con.prepareStatement(EQP_SQL);
						pstmt.setString(1,facility_id);
						pstmt.setString(2,oper_num);
					}else if(load_rows_type.equals("C")){
						pstmt = con.prepareStatement(CONS_SQL);
						pstmt.setString(1,facility_id);
						pstmt.setString(2,oper_num);
						pstmt.setString(3,locale);
					}else if(load_rows_type.equals("I")){
						pstmt = con.prepareStatement(IMP_SQL);
						pstmt.setString(1,facility_id);
						pstmt.setString(2,oper_num);
					}
					trace="3";

					rst = pstmt.executeQuery();
					int count=0;
					while(rst.next()){
                        
					   ++index;	
						key_line = rst.getString("KEY_LINE");
						key = oper_num+"@"+rst.getString("OPR_CODE")+"@S@"+rst.getString("ACC_CODE");
						bill_info = or_bean.getOrderBillDtls(key+key_line);
			
						if(bill_info==null){
							bill_info = new HashMap();
							bill_info.put("key",key);
							bill_info.put("key_line_no",key_line);
							rst_acc_code = rst.getString("ACC_CODE");
							bill_info.put("oper_code",rst_acc_code);//pass acc_code in oper_code
							//bill_info.put("acc_type","C");
							bill_info.put("acc_type",load_rows_type);
							bill_info.put("oper_num",oper_num);
							bill_info.put("locale",locale);
							bill_info.put("module_id","OT");
							//populate billing details from OTBillingBean........	
							if(load_rows_type.equals("C") || load_rows_type.equals("I")){
								// In case of Consumables and Implants, quantity is applicable
								rst_tr_no = rst.getString("TR_NO");
							}else
							{
								rst_tr_no= rst.getString("actual_units");
							}
							bill_info.put("quantity",rst_tr_no);
							bill_info = billing_bean.getBillingParams(bill_info,"C");//C-> for Surgical Accessories Billing
							or_bean.setOrderBillDtls(key+key_line,bill_info);
							putObjectInBean(or_bean_id,or_bean,request);
						}
						String overridden_incl_excl_ind=null;
						String overridden_action_reason_code=null;
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
						if(load_rows_type.equals("S")){
						String from_picklist="";	out.println("<script>loadInstrumentRows('"+checkForNull(rst.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("OPR_DESC")))+"','"+checkForNull(rst.getString("LN_NUM"))+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("ACC_DESC")))+"','"+checkForNull(rst.getString("TR_NO"))+"','"+checkForNull(rst.getString("REMKS"))+"','"+index+"','"+oper_num+"','L','1','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','"+from_picklist+"','"+checkForNull(rst.getString("actual_units"))+"');</script>");
						}else if(load_rows_type.equals("E")){
						String from_picklist="";	out.println("<script>loadEquipmentRows('"+checkForNull(rst.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("OPR_DESC")),"UTF-8")+"','"+checkForNull(rst.getString("LN_NUM"))+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("ACC_DESC")),"UTF-8")+"','"+checkForNull(rst.getString("TR_NO"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("REMKS")),"UTF-8")+"','"+index+"','L','1','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','"+from_picklist+"','"+checkForNull(rst.getString("actual_units"))+"'); </script>");	
						}else if(load_rows_type.equals("C")){
						String from_picklist="";	out.println("<script>loadPackageRows('"+checkForNull(rst.getString("OPR_CODE"))+"','"+encode(checkForNull(rst.getString("OPR_DESC")))+"','"+checkForNull(rst.getString("LN_NUM"))+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+encode(checkForNull(rst.getString("ACC_DESC")))+"','"+checkForNull(rst.getString("TR_NO"))+"','"+encode(checkForNull(rst.getString("REMKS")))+"','"+index+"','L','1','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','"+checkForNull(rst.getString("REQ_STORE_CODE"))+"','"+checkForNull(rst.getString("RESERVED_QTY"))+"','"+checkForNull(rst.getString("REQUESTED_QTY"))+"');</script>");	
						}else if(load_rows_type.equals("I")){
							//out.println("<script>loadImplantRows('"+checkForNull(rst.getString("OPR_CODE"))+"','"+encode(checkForNull(rst.getString("OPR_DESC")))+"','"+checkForNull(rst.getString("LN_NUM"))+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+encode(checkForNull(rst.getString("ACC_DESC")))+"','"+checkForNull(rst.getString("TR_NO"))+"','"+checkForNull(rst.getString("MFR"))+"','"+checkForNull(rst.getString("BTCH"))+"','"+encode(checkForNull(rst.getString("REMKS")))+"','"+index+"','L','1','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"'); </script>");	
						String stock_val="";
						String tabval="";
					String from_picklist="";	out.println("<script>loadImplantRows('"+tabval+"','"+checkForNull(rst.getString("OPR_CODE"))+"','"+encode(checkForNull(rst.getString("OPR_DESC")))+"','"+checkForNull(rst.getString("LN_NUM"))+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+encode(checkForNull(rst.getString("ACC_DESC")))+"','"+checkForNull(rst.getString("TR_NO"))+"','"+checkForNull(rst.getString("MFR"))+"','"+checkForNull(rst.getString("BTCH"))+"','"+encode(checkForNull(rst.getString("REMKS")))+"','"+index+"','L','1','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','"+checkForNull(rst.getString("RESERVED_QTY"))+"','"+checkForNull(rst.getString("REQUESTED_QTY"))+"','"+no_of_units+"','"+checkForNull(rst.getString("SALE_DOCUMENT_NO"))+"','"+checkForNull(rst.getString("SALE_DOCUMENT_TYPE"))+"','"+stock_val+"','"+checkForNull(rst.getString("REQ_STORE_CODE"))+"','"+from_picklist+"'); </script>");	
						}
						count++;
					}
					out.println("<script>assignRecId('"+load_rows_type+"')</script>");
					if(pstmt!=null)			pstmt.close();
					if(rst!=null)           rst.close();
				}
			}
		}
	}catch(Exception e){
		 System.err.println("Err Msg in NursingObjectCollectBLAtApply"+e.getMessage());
		 System.err.println("Err Msg in NursingObjectCollectBLAtApply at trace="+trace);
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
  %>
<input type='hidden' name='recId' id='recId' value=''>
<input type='hidden' name='oper_code' id='oper_code' value=''>
<input type='hidden' name='oper_line_no' id='oper_line_no' value=''>
<input type='hidden' name='mode' id='mode' value='I'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='oper_num' id='oper_num' value="<%=oper_num%>">
</form>
</BODY>
</HTML>

