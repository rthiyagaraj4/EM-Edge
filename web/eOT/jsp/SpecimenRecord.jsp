<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<HTML>
<%@ page contentType="text/html;charset=UTF-8" import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.CallableStatement,java.sql.ResultSet,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,java.sql.Types" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	String recovery_in_out_flag = CommonBean.checkForNull(request.getParameter("recovery_in_out_flag")); 
	String function_id = CommonBean.checkForNull(request.getParameter("function_id")); 
%>

<%! 
	String encode(String data){	  
	  byte byteData[] = data.getBytes();
		String outDat = "";
	  for (int i=0; i<byteData.length; i++)
	  {
		outDat = outDat +"%"+Integer.toHexString((int)byteData[i]);
	  }
		return(outDat);
	}

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
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="JavaScript" src="../../eOT/js/CheckOutFromOR.js"></script>
<script language="JavaScript" src="../../eOT/js/RecordNursing.js"></script>
<script language='javascript'>

function Class_row(){
  this.specimen_dtls ="";
  this.dept_desc ="";
  this.dept_code ="";
  this.quantity ="";
  this.recId="";
  this.db_mode="";
}
function disableDocLevel(){

	<% if(!recovery_in_out_flag.equals("CHECK_OUT_RECO")){ %>
		var formObj = parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
   
	<%}%>
}
function loadDBRows(specimen_dtls,dept_code,dept_desc,quantity,index,mode){ 
  var objrow = newRow();
  var rows=parent.parent.ObjectCollect.specimen_rows;
  var rowLength=parent.parent.ObjectCollect.specimen_len;
  if(mode=='L' && rowLength==0){
	  //Added decodeURIComponent below for IN024246 on 10/7/2010 by AnithaJ
	  objrow.specimen_dtls=decodeURIComponent(specimen_dtls);
	  objrow.dept_code=dept_code;
	  objrow.dept_desc=unescape(dept_desc);
	  objrow.quantity=quantity;
	  objrow.db_mode="L";
	  objrow.recId = index;
	  rows.push(objrow);
	}
}
function refresh(){
	var formObj = document.forms[0];
	var params = formObj.params.value;
	  parent.DetailFrame.location.href='../../eOT/jsp/SpecimenDtls.jsp?'+params;
}	
function addRow(){
  var objrow = newRow();
  var msg = trimString(getMessage("CODE_ALREADY_EXISTS","Common"));
  var rows=parent.parent.ObjectCollect.specimen_rows;
  var formObj = document.SpecimenRecordForm;
  var mode =formObj.mode.value;
  if(chkEmpty()){
	if(mode=='I'){
	   if(alreadyExist()){
		   objrow.specimen_dtls=formObj.specimen_dtls.value;
		   objrow.dept_code=formObj.dept_code.value;
		   objrow.dept_desc=formObj.dept_desc.value;
		   objrow.quantity=formObj.quantity.value;
		   objrow.db_mode="I";
		   objrow.recId = getRecId();
		   rows.push(objrow);
		   resetFields();
		   parent.DetailFrame.location.href='../../eOT/jsp/SpecimenDtls.jsp';
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
	var formObj = document.SpecimenRecordForm;
	var codeDtl = parent.DetailFrame.code; 
	var rows = parent.parent.ObjectCollect.specimen_rows;
	var specimen_dtls=formObj.specimen_dtls.value;
	var dept_code = formObj.dept_code.value;
	var codeRecord = specimen_dtls+dept_code;
	if(codeDtl.indexOf(codeRecord)>=0)
	   return false;
	else
	  return true;
 }

 function assignRecId(){
	var rows = parent.parent.ObjectCollect.specimen_rows;
	parent.parent.ObjectCollect.specimen_len=rows.length;
	
}

function getRecId(){
    var rowLength=parent.parent.ObjectCollect.specimen_len;
	var recId = rowLength+1;
	parent.parent.ObjectCollect.specimen_len  =  recId;
	return recId;
}

function chkEmpty(){
	
	var specimenDetails_title=getLabel("Common.SpecimenDetails.label","Common");
	var department_title=getLabel("Common.department.label","Common");
	var quantity_title=getLabel("Common.Quantity.label","Common");
	var formObj = document.SpecimenRecordForm;
	var chk_out_flag=formObj.recovery_in_out_flag.value
	var function_id=formObj.function_id.value
	var fields = new Array(formObj.specimen_dtls,formObj.dept_desc,formObj.quantity);
	var names = new Array(specimenDetails_title,department_title,quantity_title);
	var messageFrame = parent.parent.messageFrame;
	if(chk_out_flag=="CHECK_OUT_RECO"){
		parent.parent.frames[0].location.href="../../eCommon/jsp/commonToolbar.jsp?module_id=OT&function_type=F&menu_id=26&access=NYNNY&home_required_yn=N&recovery_in_out_flag=CHECK_OUT_RECO&function_id=OT_CHECKOUT_FROM_RECOVERY&function_name=Check-Out%20From%20Recovery%20Room&called_from=OT_SLATE";
		
	}else if(function_id=="OT_CHECKOUT_FROM_OR"){
		parent.parent.frames[0].location.href="../../eCommon/jsp/commonToolbar.jsp?module_id=OT&function_type=F&menu_id=26&access=NYNNY&home_required_yn=N&function_id=OT_CHECKOUT_FROM_OR&function_name=Check-Out%20From%20OR&called_from=OT_SLATE";
	}
	if(checkFields( fields, names, messageFrame))
	
	
	return true;
}

function removeRow(){
var formObj = document.SpecimenRecordForm;
var rows=parent.parent.ObjectCollect.specimen_rows;
var recId = document.forms[0].recId.value;
var mode = document.forms[0].mode.value;
if(rows.length>0 && mode=='U'){        
  for(var jj=0;jj<rows.length;jj++){
	 if(rows[jj]!=null){
		if(rows[jj].recId==recId){
			 if(rows[jj].db_mode=='L')
				rows[jj].db_mode='D';
			 else
			  delete rows[jj];
			   break;
		}
	 }else
	continue;
 }//end for-Loop
 resetFields();
 parent.DetailFrame.location.href='../../eOT/jsp/SpecimenDtls.jsp';
 parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
}else
   resetFields();
}

function updateRow(){
	var formObj = document.SpecimenRecordForm;
	var specimen_dtls = formObj.specimen_dtls.value;
	var dept_code =  formObj.dept_code.value;
	var dept_desc =  formObj.dept_desc.value;
	var quantity =  formObj.quantity.value;
	var mode =formObj.mode.value
	var recId = formObj.recId.value;
	var rows=parent.parent.ObjectCollect.specimen_rows;
		if(rows.length>0 && mode=='U'){        
			for(var jj=0;jj<rows.length;jj++){
				if(rows[jj]!=null) {
					if(rows[jj].recId==recId){
						rows[jj].specimen_dtls=specimen_dtls;	
			            rows[jj].dept_code=dept_code;
						rows[jj].dept_desc=dept_desc;
			            rows[jj].quantity=quantity;
						if(rows[jj].db_mode=='L')
							rows[jj].db_mode='U'
							break;
					}
		         }else  
			continue;
		 }
      resetFields();
	  parent.DetailFrame.location.href='../../eOT/jsp/SpecimenDtls.jsp';
 }
}



function splitString(strVal){
    var arr = strVal.split('::');
	var frmObj = document.SpecimenRecordForm;
	frmObj.specimen_dtls.value=arr[0];
	frmObj.dept_code.value=arr[1];
	frmObj.dept_desc.value = arr[2];
	frmObj.quantity.value=arr[3];
	frmObj.recId.value=arr[4];
	frmObj.mode.value=arr[5];
	frmObj.dept_desc.disabled=true;
	frmObj.specimen_dtls.disabled=true;
	frmObj.DeptLookUp.disabled=true;
}

function resetFields(){
	var frmObj = document.SpecimenRecordForm;
	frmObj.specimen_dtls.value='';
	frmObj.dept_desc.value='';
	frmObj.quantity.value='';
	frmObj.mode.value='I';
	frmObj.DeptLookUp.disabled=false;
	frmObj.dept_desc.disabled=false;
	frmObj.specimen_dtls.disabled=false;
	frmObj.specimen_dtls.focus();
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<% String params = request.getQueryString(); %>
<form name = 'SpecimenRecordForm'>
<input type='hidden' name='params' id='params' value='<%=params%>'>

<BODY OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%

	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	String  nursing_doc_comp_yn = CommonBean.checkForNull(request.getParameter("nursing_doc_comp_yn"));
	String disable_flag="",lab_module_yn="",SQL="";

	if(nursing_doc_comp_yn.equals("Y") && function_id.equals("OT_CHECKOUT_FROM_OR") )
{
	  disable_flag="";
}else if(nursing_doc_comp_yn.equals("Y") && function_id.equals("OT_CHECKOUT_FROM_RECOVERY") )
{
	disable_flag="";
}else if(nursing_doc_comp_yn.equals("Y") && function_id.equals(""))
{
	   disable_flag="disabled";
}
  	
	String SQL_AM = "SELECT A.SPECIMEN_DTL,A.DEPT_CODE,B.SHORT_DESC,A.QTY FROM OT_POST_OPER_SPECIMENS A, AM_DEPT_LANG_VW B WHERE B.language_id='"+locale+"' and  A.DEPT_CODE = B.DEPT_CODE  AND OPERATING_FACILITY_ID=? AND OPER_NUM=?"; 
	String SQL_RL = "SELECT A.SPECIMEN_DTL,A.DEPT_CODE,B.SHORT_NAME SHORT_DESC,A.QTY FROM OT_POST_OPER_SPECIMENS A, RL_SECTION_CODE B WHERE  A.DEPT_CODE = B.SECTION_CODE  AND OPERATING_FACILITY_ID=? AND OPER_NUM=?"; 
	
	Connection con = null;
	PreparedStatement pstmt = null;
	CallableStatement cstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		cstmt=con.prepareCall("{call GET_OPERATIONAL_MODULES(?,?)}");
		cstmt.setString(1,facility_id);
		cstmt.registerOutParameter(2,Types.VARCHAR);
		cstmt.execute();
		lab_module_yn=cstmt.getString(2);
		if(lab_module_yn.indexOf("RL|")>=0)
			SQL=SQL_RL; // When RL is  Operational
		else
			SQL=SQL_AM; //When RL is not Operational

	pstmt = con.prepareStatement(SQL);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();
		int index = 0;
		while(rst.next()){
			index++;
			out.println("<script>loadDBRows('"+CommonBean.checkForNull(rst.getString("SPECIMEN_DTL"))+"','"+CommonBean.checkForNull(rst.getString("DEPT_CODE"))+"','"+encode(CommonBean.checkForNull(rst.getString("SHORT_DESC")))+"','"+CommonBean.checkForNull(rst.getString("QTY"))+"','"+index+"','L'); </script>");	

		}
	%><script>refresh()</script>
	<script>assignRecId()</script><%
		
	}catch(Exception e){
		 System.err.println("Err Msg in Specimen Records"+e.getMessage());
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(cstmt!=null)cstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
	%>
<input type='hidden' name='lab_module_yn' id='lab_module_yn' value='<%=lab_module_yn%>'>
<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>
<tr>
	 <td class="label"><fmt:message key="eOT.SpecimenNoDtl.Label" bundle="${ot_labels}"/> </td>
      <td>
		<input type='text' name='specimen_dtls' id='specimen_dtls' maxlength='27' size='27' <%=disable_flag%> >
		 <!-- Commented against ML-BRU-SCF-1054 by MuthuN on 10/3/2013
			   <img src='../../eCommon/images/mandatory.gif'></img>-->
	  </td>

	  <td class="label" ><fmt:message key="Common.department.label" bundle="${common_labels}"/> </td>
	  <td class="fields" >
		  <input type='hidden' name='dept_code' id='dept_code' > 
		  <input type='text' name='dept_desc' id='dept_desc' maxlength='15'   <%=disable_flag%> onBlur="if(this.value!='')searchDepartment(dept_code,dept_desc);else dept_code.value=''"> 
		  <input type='button' class='button' value='?' name='DeptLookUp' id='DeptLookUp' onClick='searchDepartment(dept_code,dept_desc);' <%=disable_flag%> > 
		  <!-- Commented against ML-BRU-SCF-1054 by MuthuN on 10/3/2013
				<img src='../../eCommon/images/mandatory.gif'></img>-->
	  </td>
 </tr>
<tr>
	 <td class="label" ><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/> </td>
     <td class="fields" >
		<input type='text' name='quantity' id='quantity' maxlength='3' size='2' onkeypress="return checkForSpecCharsforID(event);" <%=disable_flag%> > 
		<!-- Commented against ML-BRU-SCF-1054 by MuthuN on 10/3/2013
			  <img src='../../eCommon/images/mandatory.gif'></img>-->
	</td>
<td></td>
<td class="button">
		<input type='button' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='addRow();disableDocLevel();'  <%=disable_flag%> >
		<input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow();' <%=disable_flag%> >
	</td>
</tr>
</table>
   <!-- added by Rajesh for Amazon Changes-->
				<%
					if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<!-- end --><input type='hidden' name='recId' id='recId' value=''>
<input type='hidden' name='mode' id='mode' value='I'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='recovery_in_out_flag' id='recovery_in_out_flag' value="<%=recovery_in_out_flag%>">
<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>">
</form>
</BODY>
</HTML>

