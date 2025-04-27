<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<%@ page import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.HashMap,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*,eCommon.Common.*" %>

<% //qry_mode=YES used in surgeryHistory 
	String qry_mode=CommonBean.checkForNull(request.getParameter("qry_mode")); %>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="JavaScript" src="../../eOT/js/RecordSurgeon.js"></script>
<!-- <script language="javascript" src="../../eOT/js/OTMessages.js"></script>-->

<script language='javascript'>

function Class_row()
{
  this.icd_code ="";
  this.icd_desc="";
  this.scheme_code="";
  this.primary="";
  this.significant="";
  this.onset_date ="";
  this.close_date="";
  this.notifiable="";
  this.sensitive="";
  this.srl_no="";
  this.patient_id="";
  this.surgeon_code="";
  this.source_code="";
  this.source_type="";
  this.v_stat="";
  this.remarks ="";
  this.db_mode="";
  this.recId="";
}



/*function disableDocLevel(){
   var formObj = parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
   formObj.doc_level.disabled=true;
}*/

/*function loadDBRows(oper_code,oper_desc,line_no,implant_code,implant_desc,quantity,mfgr,batch,remarks,index,mode){ 
  var objrow = newRow();
  var rows=parent.parent.parent.ObjectCollect.diagnosis_rows;
  var rowLength=parent.parent.parent.parent.ObjectCollect.implants_len;
  if(mode=='L' && rowLength==0){
	  objrow.oper_code=oper_code;
	  objrow.oper_desc=oper_desc;
	  objrow.implant_code=implant_code;
	  objrow.implant_desc=implant_desc;
	  objrow.oper_line_no=line_no;
	  objrow.quantity=quantity;
	  objrow.manufacturer=mfgr
	  objrow.batch=batch;
	  objrow.remarks=remarks;
	  objrow.recId = index;
	  objrow.db_mode="L";
	  rows.push(objrow);
	 }
}*/

function loadDiagCodes(scheme_code,diag_code,srl_no,index,mode){ 
  //alert(scheme_code+diag_code+srl_no);
  var objrow = newRow();
  var rows= parent.parent.ObjectCollect.diagnosis_rows;
  var rowLength=rows.length;
  var db_flag=parent.parent.ObjectCollect.db_flag;
  //alert('flag'+db_flag);
  if(mode=='L' &&db_flag=='ON'){
	  objrow.icd_code=diag_code;
	  objrow.scheme_code=scheme_code;
	  objrow.srl_no=srl_no;
	  objrow.recId = index;
	  objrow.db_mode="L";	  
	  rows.push(objrow);
	 }
	// alert('dhana'+rows.length);

}

function loadDiagDesc(desc,code,notifiable,sensitive,mode){ 
  var rows= parent.parent.ObjectCollect.diagnosis_rows;
  //alert(code+"="+desc+"Mode="+mode+"notify_yn="+notifiable+"sensitive_yn="+sensitive);
  for(i=0;i<rows.length;i++){
	  if( mode=='L' && rows[i].icd_code==code ){
			rows[i].icd_desc=desc;
			rows[i].notifiable=notifiable;
			rows[i].sensitive=sensitive;
			  //alert('icd_desc'+rows[i].icd_desc);
		  break;
	  }else		 continue;
  }
  
}

function loadDiagDtls(primary,significant,onset_date,close_date,remarks,srl_no,mode){ 
  var rows= parent.parent.ObjectCollect.diagnosis_rows;
   //var rowLength=rows.length;
  //alert(primary+significant+onset_date+close_date+remarks);
   for(i=0;i<rows.length;i++){
	 if(mode=='L' && rows[i].srl_no==srl_no){
		rows[i].primary=primary;
		rows[i].significant=significant;
		rows[i].onset_date=onset_date;
		rows[i].close_date = close_date;
		if(close_date!="")
			rows[i].date_flag = "Y";
		else 
			rows[i].date_flag = "N";
		rows[i].remarks = remarks;
		break;
	}else
		continue;
   }
}

function refresh(){
  	var formObj = document.PostOperDiagnosisRecordForm;
	var params = formObj.params.value;
	parent.DetailFrame.location.href='../../eOT/jsp/PostOperDiagnosisDtls.jsp?'+params;
 }

function addRow(){
  var objrow = newRow();
  var msg = trimString(getMessage("CODE_ALREADY_EXISTS","Common"));
  var rows=parent.parent.ObjectCollect.diagnosis_rows;
  //alert(parent.parent.ObjectCollect.name);
  var formObj = document.forms[0];
  var params = formObj.params.value;
  //var primary = formObj.primary;
  //var siginficant = formObj.significant;
  var mode =formObj.mode.value;
  if(chkEmpty() && validateDate()){
	  if(mode=='I'){
	   if(alreadyExist()){
		objrow.icd_code=formObj.icd_code.value;
		objrow.icd_desc =formObj.icd_desc.value;
		objrow.scheme_code=formObj.scheme_code.value;
		if(formObj.primary.checked==true){
			objrow.primary="Y";
		}else{
			objrow.primary="N";
		}
		if(formObj.significant.checked==true){
			objrow.significant="Y";
		}else{
			objrow.significant="N";
		}

		objrow.onset_date=formObj.onset_date.value;
		objrow.close_date = formObj.close_date.value
		if(formObj.close_date.value!=""){
			objrow.v_stat="C";
		}else{
			objrow.v_stat="A";
		}
		objrow.srl_no = getSerialNumber();
		objrow.remarks = formObj.remarks.value;
		objrow.notifiable = formObj.notifiable.value;
		objrow.sensitive = formObj.sensitive.value;
		objrow.patient_id =formObj.patient_id.value;
		objrow.encounter_id = formObj.encounter_id.value;
		objrow.surgeon_code = formObj.surgeon_code.value;
		objrow.source_type = formObj.source_type.value;
		objrow.source_code = formObj.source_code.value;
		objrow.db_mode="I";
		objrow.recId = rows.length+1;
		//objrow.db_mode="I";
		rows.push(objrow);
		resetFields();
		parent.DetailFrame.location.href='../../eOT/jsp/PostOperDiagnosisDtls.jsp?'+params;
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
	} else{
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
	}
	}else
	  updateRow();
  }
}

function newRow(){
  var objrow = new Class_row();
   return(objrow);
}

function alreadyExist(){
	var formObj = document.PostOperDiagnosisRecordForm;
	var codeDtl = parent.DetailFrame.code; 
	var icd_code=formObj.icd_code.value;
	var icd_code = formObj.icd_code.value;
	if(codeDtl.indexOf(icd_code)>=0)
	   return false;
	else
	  return true;
}

 function assignRecId(){
	var rows = parent.parent.ObjectCollect.diagnosis_rows;
	parent.parent.ObjectCollect.diagnosis_len=rows.length;
	
}

function getRecId(){
    var rowLength=parent.parent.diagnosis_len;
	var recId = rowLength+1;
	parent.parent.ObjectCollect.diagnosis_len = recId;
	return recId;
}

function chkEmpty(){
	var formObj = document.PostOperDiagnosisRecordForm;
	var fields = new Array(formObj.icd_code,formObj.onset_date);
	var icd_value=getLabel("Common.ICD.label","common");
	var onsetDate_value=getLabel("Common.onsetdate.label","common");
	var names = new Array(icd_value,onsetDate_value );
	var messageFrame = parent.parent.messageFrame;
	if(checkFields( fields, names, messageFrame))
		return true;
}

function removeRow(){
var formObj = document.PostOperDiagnosisRecordForm;
var params = formObj.params.value;
var rows=parent.parent.ObjectCollect.diagnosis_rows;
var recId = document.forms[0].recId.value;
var mode = document.forms[0].mode.value;
if(rows.length>0 && mode=='U'){        
  for(var jj=0;jj<rows.length;jj++){
	 if(rows[jj]!=null){
		if(rows[jj].recId==recId){
			 if(rows[jj].db_mode=='L'){
				//alert("Existing Records Cannot be Deleted");
				alert(getMessage("CANNOT_DELETE","SM");
				resetFields();
				break;
			 }else{
			     delete rows[jj];
			     resetFields();
			     parent.DetailFrame.location.href='../../eOT/jsp/PostOperDiagnosisDtls.jsp?'+params;
			     parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';	
			     break;
			 }
		}
	 }else
	continue;
 }//end for-Loop
 }else
  resetFields();
}

function callPopulateList(flag){}

function updateRow(){
	var formObj = document.PostOperDiagnosisRecordForm;
	var params = formObj.params.value;
	var	onset_date = formObj.onset_date.value;
	var close_date = formObj.close_date.value;
	var primary = "";
	var significant = "";
	
	//for primary check Box
	if(formObj.primary.checked==true){
		primary="Y";	
	}else {
		primary="N";
	}
	//for significant check Box
	if(formObj.significant.checked==true){
		significant="Y";	
	}else {
		significant="N";
	}

	var	remarks = formObj.remarks.value;
	var mode =formObj.mode.value;
	var recId = formObj.recId.value;
	var rows=parent.parent.parent.ObjectCollect.diagnosis_rows;
		if(rows.length>0 && mode=='U'){        
			for(var jj=0;jj<rows.length;jj++){
				if(rows[jj]!=null) {
					if(rows[jj].recId==recId){
						//rows[jj].implant_code=implant_code;
						//rows[jj].implant_desc=implant_desc;	
						if(formObj.close_date.value!=""){
							rows[jj].v_stat="C";
						}else{
								rows[jj].v_stat="A";
						}
						rows[jj].patient_id =formObj.patient_id.value;
						rows[jj].encounter_id = formObj.encounter_id.value;
						rows[jj].surgeon_code = formObj.surgeon_code.value;
						rows[jj].source_type = formObj.source_type.value;
						rows[jj].source_code = formObj.source_code.value;
			            rows[jj].significant=significant;
						rows[jj].primary = primary
						rows[jj].onset_date=onset_date;
						rows[jj].close_date=close_date;
						rows[jj].remarks=remarks;
			            if(rows[jj].db_mode=='L')
							rows[jj].db_mode='U'
							break;
					}
		         }else  
			continue;
		 }
     resetFields();
	 parent.DetailFrame.location.href='../../eOT/jsp/PostOperDiagnosisDtls.jsp?'+params;
 }
}

function splitString(strVal){
    var arr = strVal.split('::');
	var formObj = document.PostOperDiagnosisRecordForm;
	formObj.icd_code.value=arr[0];
	formObj.icd_desc.value=arr[1];
	if(arr[2]=="Y"){
		formObj.primary.checked=true;
		
	}else{
		formObj.primary.checked=false;
		
	}

	if(arr[3]=="Y"){
		formObj.significant.checked=true;
		
	}else{
		formObj.significant.checked=false;
		
	}

	formObj.onset_date.value = arr[4];
	formObj.close_date.value=arr[5];
	formObj.remarks.value=arr[6];
	formObj.recId.value = arr[7];
	formObj.mode.value=arr[8];
	formObj.ICDCodeLookUp.disabled=true;
}

function resetFields(){
	var formObj = document.PostOperDiagnosisRecordForm;
	formObj.icd_code.value='';
	formObj.icd_desc.value='';
	formObj.primary.checked=false;
	formObj.significant.checked=false;
	formObj.onset_date.value='';
	formObj.close_date.value='';
	formObj.remarks.value='';
	formObj.mode.value='I';
	formObj.ICDCodeLookUp.disabled=false;
	formObj.primary.disabled=false;
	formObj.significant.disabled=false;
  }

  function setSerialNumber(serial_no){
	//alert(serial_no);
   var frmObj = parent.parent.ObjectCollect;
   if(frmObj.serial_no==0){
		frmObj.serial_no = parseInt(serial_no,10);
   }
   //alert("assing "+frmObj.serial_no); 
}

function getSerialNumber(){
   frmObj = parent.parent.ObjectCollect;
   //alert("Before Incrementing "+frmObj.serial_no);
   var serial_no= frmObj.serial_no + 1;
  // alert("After Incrementing "+serial_no);
   parent.parent.ObjectCollect.serial_no = serial_no;
   //alert("After  assing "+frmObj.serial_no);
   //alert("serial_no"+serial_no);
   return serial_no;
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%if(qry_mode.equals("YES")){ %>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%}else{%>
<body onLoad="assignHdrDtls();setPrimaryFlag();">
<%}%>

<% String params = request.getQueryString(); %>
<form name = 'PostOperDiagnosisRecordForm' >

<input type='hidden' name='params' id='params' value='<%=params%>' >

<%
	
	
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
	
	String max_srl_no ="";
	String  surgeon_doc_comp_yn = CommonBean.checkForNull(request.getParameter("surgeon_doc_comp_yn"));
	String disable_flag="";
	if( surgeon_doc_comp_yn.equals("Y") )
	  disable_flag="disabled";
	 else 
	   disable_flag="";
	
	//MAX SERIAL NO QUERY
	String MAX_SRL_NO = "SELECT NVL(MAX(SRL_NO),0) FROM PR_PROBLEM WHERE PATIENT_ID=?";
	
	String SQL = "SELECT NVL(DIAG_CODE_SCHEME,'1') DIAG_CODE_SCHEME FROM OT_PARAM"; 
	String SQL1 = "SELECT PRIMARY_YN FROM PR_PROBLEM WHERE PATIENT_ID =? AND PRIMARY_YN='Y'";
	
	//INITIAL POPULATION QUERY
	String SQL2 ="SELECT DIAG_CODING_SCHEME,DIAG_CODE,SRL_NO FROM OT_POST_OPER_DIAG WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=?";
	
	//QUERY FOR DIAG_CODE_SCHEME=1
	String SQL3 ="SELECT SHORT_DESC,NOTIFIABLE_YN,SENSITIVE_YN FROM MR_ICD_MAST WHERE ICD_CODE=? AND RECORD_TYPE='D' AND CAUSE_INDICATOR IS NULL";
	
	//QUERY FOR DIAG_CODE_SCHEME=2
	String SQL4= "SELECT SHORT_DESC, NOTIFIABLE_YN, SENSITIVE_YN FROM MR_ICD_MAST WHERE ICD_CODE = ? AND NVL(RECORD_TYPE,'#')='#' AND CAUSE_INDICATOR IS NULL";

	//QUERY FOR SELECTING ADDN INFORMATION PRIMARY_YN,ONSET_DATE,SIGNIFICANT_YN,CLOSE_DATE,REMARKS
	String SQL5= "SELECT PRIMARY_YN,SIGNIFICANT_YN,TO_CHAR(ONSET_DATE,'DD/MM/YYYY'),TO_CHAR(CLOSE_DATE,'DD/MM/YYYY'),PROBLEM_REMARKS FROM PR_PROBLEM WHERE PATIENT_ID=? AND SRL_NO=?";
		
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String diag_code_scheme="";
	String diag_code_sch="";
	HashMap diag_code=new HashMap();
	HashMap srl_no=new HashMap();
	String primary_yn="";
	int size=0;
	int index=0;
	try{
		con = ConnectionManager.getConnection(request);
		//pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_PERSONNEL_SELECT2")) ;
		pstmt = con.prepareStatement(SQL);
		rst = pstmt.executeQuery();
		if(rst.next()){
			diag_code_scheme = rst.getString(1);
		}else
			diag_code_scheme = "1";

		if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();

		pstmt = con.prepareStatement(SQL1);
		pstmt.setString(1,patient_id);
		rst = pstmt.executeQuery();
		if(rst.next()){
			primary_yn = rst.getString(1);
		}else
			primary_yn = "N";
			
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
		// ("primary_yn====="+primary_yn);
		
		pstmt = con.prepareStatement(SQL2);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();
		index=0;
		while(rst.next()){
			
			++index;
			diag_code_sch=rst.getString(1);
			diag_code.put(""+index,rst.getString(2)); //diagnosis_code
			srl_no.put(""+index,rst.getString(3)); // srl_no
			//1 diagnosis_coding_scheme, 2 diagnosis_code, 3 srl_no
		   out.println("<script>loadDiagCodes('"+CommonBean.checkForNull(rst.getString(1))+"','"+CommonBean.checkForNull(rst.getString(2))+"','"+CommonBean.checkForNull(rst.getString(3))+"','"+index+"','L')</script>");
		}
		
		if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();

		
		if(!diag_code_sch.equals("") ){
			if(diag_code_sch.equals("2") ){
				pstmt = con.prepareStatement(SQL4);
			}else{
				pstmt = con.prepareStatement(SQL3);
			}	 
			size = diag_code.size();
			if(size>0){
				for(int i=1;i<=size;i++){
				  pstmt.setString(1,(String)diag_code.get(""+i));
				  rst = pstmt.executeQuery();
				  while(rst.next()){
				out.println("<script>loadDiagDesc('"+CommonBean.checkForNull(rst.getString(1))+"','"+(String) diag_code.get(""+i)+"','"+CommonBean.checkForNull(rst.getString(2))+"','"+CommonBean.checkForNull(rst.getString(3))+"','L')</script>");
				  }
				}// end of for
	         }// end if
		}
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
		size=srl_no.size();	
		if(size>0){
			
			pstmt = con.prepareStatement(SQL5);
			for(int i=1;i<=size;i++){
				pstmt.setString(1,patient_id);
				pstmt.setString(2,(String) srl_no.get(""+i));
				
				rst = pstmt.executeQuery();
				while(rst.next()){
					
				   //1 primary_yn,signifacnt_yn,onset_date,close_date,remarks
				  out.println("<script>loadDiagDtls('"+CommonBean.checkForNull(rst.getString(1))+"','"+CommonBean.checkForNull(rst.getString(2))+"','"+CommonBean.checkForNull(rst.getString(3))+"','"+CommonBean.checkForNull(rst.getString(4))+"','"+CommonBean.checkForNull(rst.getString(5))+"','"+(String) srl_no.get(""+i)+"','L')</script>");
				}// END WHILE
		    } // END FOR
		}// END IF
		if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();

		pstmt = con.prepareStatement(MAX_SRL_NO);
		pstmt.setString(1,patient_id);
		rst = pstmt.executeQuery();
		while(rst.next()){
			max_srl_no = rst.getString(1);
			
		}
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
		out.println("<script>setSerialNumber('"+max_srl_no+"')</script>");
		out.println("<script>refresh()</script>");
	}catch(Exception e){
		 System.err.println("Err Msg in PostOperDiagnosisRecord "+e.getMessage());
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
%>
<table border='0' cellpadding=3  cellspacing='0' width='100%'>
<tr>
	 
<tr> 
	  <td class='label' align='right'>
	  <fmt:message key="Common.ICD.label" bundle="${common_labels}"/> </td>
	  <td align='left'  nowrap>
		  <input type='hidden' name='icd_code' id='icd_code' > 
		  <input type='text' name='icd_desc' id='icd_desc'  size='25'disabled > 
		  <input type='button' class='button' value='?' name='ICDCodeLookUp' id='ICDCodeLookUp' onClick=' searchICD(icd_code,icd_desc);' <%=disable_flag%> >
		   <img src='../../eCommon/images/mandatory.gif'></img>
	  </td>
 </tr>

<tr> 
	  <td class='label' align='right' ><fmt:message key="Common.primary.label" bundle="${common_labels}"/> </td>
	  <td align='left' nowrap>
		  <input type='checkbox'  name='primary' id='primary' onClick="validatePrimaryChkBox(this);" <%=disable_flag%> >
	  </td>
 </tr>
<tr> 
	  <td class='label' align='right' ><fmt:message key="Common.significant.label" bundle="${common_labels}"/> </td>
	  <td align='left' nowrap>
		  <input type='checkbox'  name='significant' id='significant'  <%=disable_flag%> >
	  </td>
 </tr>
<tr>
	 <td class='label' align='right' nowrap>
	 <fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/>  </td>
     <td align='left' nowrap>
		<input type='text' name='onset_date' id='onset_date'  size='7' readonly > 
		 <image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('onset_date'); "  > <img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	</td>
</tr>

<tr>
	 <td class='label' align='right' nowrap>
		<fmt:message key="eCA.CloseDate.label" bundle="${ca_labels}"/> </td>
     <td align='left' nowrap>
		<input type='text' name='close_date' id='close_date' size='7' readonly > 
		 <image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('close_date');">
		
	</td>
</tr>

<tr>
	 <td class='label' align='right' nowrap ></td>
     <td align='left' nowrap>
	<a href="javascript:openNewDialogWindow('Remarks',document.forms[0].remarks,1500,'<%=disable_flag%>');"> <fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </a>
	</td>
</tr>
<tr>

	<td></td>
	<td class='label' align='right' nowrap width='100%'>
		<input type='button' class='button' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='addRow();' <%=disable_flag%> >
		<input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow();' <%=disable_flag%> >
	</td>
</tr>
</table>
<input type='hidden' name='recId' id='recId' value=''>
<input type='hidden' name='scheme_code' id='scheme_code' value='<%=diag_code_scheme%>' >

<input type='hidden' name='remarks' id='remarks' value=''>
<input type='hidden' name='mode' id='mode' value='I'>
<input type='hidden' name='primary_yn' id='primary_yn' value='<%=primary_yn%>'>
<input type='hidden' name='primary_flag' id='primary_flag' value=''>

<input type='hidden' name='sensitive' id='sensitive' value=''>
<input type='hidden' name='notifiable' id='notifiable' value=''>

<input type='hidden' name='patient_id' id='patient_id' value=''>
<input type='hidden' name='encounter_id' id='encounter_id' value=''>
<input type='hidden' name='surgeon_code' id='surgeon_code' value=''>
<input type='hidden' name='source_code' id='source_code' value=''>
<input type='hidden' name='source_type' id='source_type' value=''>

<!--<input type='hidden' name="facility_id" id="facility_id" value='<%=request.getParameter("slate_user_id")%>'> -->
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

