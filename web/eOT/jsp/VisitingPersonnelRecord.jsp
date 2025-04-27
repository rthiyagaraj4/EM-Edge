<!DOCTYPE html>


<HTML>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page import ="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>


<%
//Added Against MMS Vulnerability Issue - Starts
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
//Added Against MMS Vulnerability Issue - Ends

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

request.setCharacterEncoding("UTF-8");

String locale = (String)session.getAttribute("LOCALE");
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>


<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<% String tab = checkForNull(request.getParameter("tab")); 
String disable_flag="";
String nursing_doc_comp_yn = checkForNull(request.getParameter("nursing_doc_comp_yn")); 
String surgeon_doc_comp_yn = checkForNull(request.getParameter("surgeon_doc_comp_yn"));

if(tab.equals("record_surgeon")){ 
	disable_flag = (surgeon_doc_comp_yn.equals("Y") )?"disabled":""; %>
<script language="JavaScript" src="../../eOT/js/RecordSurgeon.js"></script>

   <% } else if(tab.equals("record_nursing")){ 
	   disable_flag = (nursing_doc_comp_yn.equals("Y") )?"disabled":""; %>
<script language="JavaScript" src="../../eOT/js/RecordNursing.js"></script>
   <%}%>
<script language="JavaScript">
function refresh(){
	var params = document.forms[0].params.value;
	 parent.DetailFrame.location.href='../../eOT/jsp/VisitingPersonnelDtls.jsp?'+params;
}

function Class_row(){
  this.speciality_code ="";
  this.speciality_desc="";
  this.visit_desc="";
  this.db_mode="";
  this.recId="";
  this.verify_flag="OFF";
}

function loadDBRows(speciality_code,speciality_desc,visit_desc,index,mode){ 
  var objrow = newRow();
  var rows=parent.parent.parent.ObjectCollect.visit_pers_rows;
  var rowLength=parent.parent.parent.ObjectCollect.visit_pers_len; // Modified on 13/02/2009 for display  problem of records.
  if(mode=='L' && rowLength==0){
	  objrow.speciality_code=speciality_code;
	  objrow.speciality_desc=speciality_desc;
	  objrow.visit_desc=decodeURIComponent(visit_desc,"UTF-8").replace(/\+/g," ");
	  objrow.recId = index;
	  objrow.db_mode="L";
	  rows.push(objrow);
	 }
}

function addRow(){
  var objrow = newRow();
  var msg = trimString(getMessage("CODE_ALREADY_EXISTS","Common"));
  var rows=parent.parent.parent.ObjectCollect.visit_pers_rows;
  var formObj = document.VisitingPersonnelRecordForm;
  var params = formObj.params.value;
  var mode =formObj.mode.value;
  var obj = formObj.speciality;
  if(chkEmpty()){
	if(mode=='I'){
	   if(alreadyExist()){
		  objrow.speciality_code=formObj.speciality.value;
		  objrow.speciality_desc=formObj.speciality.options[obj.selectedIndex].text;
		  objrow.visit_desc=formObj.visit_txt.value;
		  objrow.recId = rows.length+1;
		  objrow.db_mode="I";
		  rows.push(objrow);
		  resetFields();
		parent.DetailFrame.location.href='../../eOT/jsp/VisitingPersonnelDtls.jsp?'+params;
		  parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
		} else{
			parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
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
	var formObj = document.VisitingPersonnelRecordForm;
	var codeDtl = parent.DetailFrame.code; 
	var speciality_code=formObj.speciality.value;
	var codeRecord = speciality_code;
	if(codeDtl.indexOf(codeRecord)>=0)
	   return false;
	else
	  return true;
 }

function removeRow(){
var formObj = document.VisitingPersonnelRecordForm;
var params = formObj.params.value;
var rows=parent.parent.parent.ObjectCollect.visit_pers_rows;
var recId = document.forms[0].recId.value;
var mode = document.forms[0].mode.value;
var cannotdelete = getMessage("CANNOT_DELETE","SM");
var data_exist = getMessage("APP-OT0195","OT");
if(rows.length>0 && mode=='U'){        
  for(var jj=0;jj<rows.length;jj++){

	 if(rows[jj]!=null){

		if(rows[jj].recId==recId){

			 if(rows[jj].db_mode=='L' || rows[jj].db_mode=='U' ){
				alert(data_exist);
				  break;

				}
			 else {
				delete rows[jj];
				 resetFields();
				parent.DetailFrame.location.href='../../eOT/jsp/VisitingPersonnelDtls.jsp?'+params;
				parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
			    break;
			 }
		}
	 }else
	continue;
 }//end for-Loop
 
}else
   resetFields();
}

function updateRow(){
	var formObj = document.VisitingPersonnelRecordForm;
	var params = formObj.params.value;
	var	visit_desc=formObj.visit_txt.value;
	var mode =formObj.mode.value;
	var recId = formObj.recId.value;
	var rows=parent.parent.parent.ObjectCollect.visit_pers_rows;
		if(rows.length>0 && mode=='U'){        
			for(var jj=0;jj<rows.length;jj++){
				if(rows[jj]!=null) {
					if(rows[jj].recId==recId){
						rows[jj].visit_desc=visit_desc;
						if(rows[jj].db_mode=='L')
						   	rows[jj].db_mode='U';
							break;
					}
		         }else  
			continue;
		 }
      resetFields();
	 parent.DetailFrame.location.href='../../eOT/jsp/VisitingPersonnelDtls.jsp?'+params;
 }
}

function chkEmpty(){
	return true;
}

function splitString(strVal){
    var arr = strVal.split('::');
	var formObj = document.VisitingPersonnelRecordForm;
	formObj.speciality.value=arr[0];
	formObj.visit_txt.value = arr[2];
	formObj.recId.value = arr[3];
	formObj.mode.value = arr[4];

	formObj.speciality.disabled=true;
}

function resetFields(){
	var formObj = document.VisitingPersonnelRecordForm;
	formObj.visit_txt.value='';
	formObj.mode.value='I';
	formObj.speciality.disabled=false;

}

 function assignSpeciality(){
	var formObjHdr = parent.parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var doc_level = formObjHdr.doc_level.value;
	if(document.forms[0].tab.value !="record_surgeon")
	{
	callPopulateList(doc_level);
	}else
	{
		if(doc_level=="IS")
		{
				var facility_id=document.forms[0].facility_id.value;
				var db_mode=parent.parent.parent.frames[4].RecordSurgeonTabForm.db_mode.value;
				var status_value=parent.parent.parent.frames[4].RecordSurgeonTabForm.status_value.value;
				var oper_code_all=parent.parent.parent.frames[4].RecordSurgeonTabForm.oper_code_all.value;
				var oper_code_new=parent.parent.parent.frames[4].RecordSurgeonTabForm.oper_code_new.value;
				var spec_code_final=parent.parent.parent.frames[4].RecordSurgeonTabForm.spec_code_final.value;
				var oper_num=document.forms[0].oper_num.value;
				var arr2=oper_code_all.split("*");
				var arr3=status_value.split("*");
				var arr1=db_mode.split("*");
	
				var oper_code="";
				var chk_status="";
				var db_mode_val="";
				
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			    xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=exist_operation_speciality&spec_code_final="+spec_code_final,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				var arr_spec=retVal.split("*");
				var spec_code_new="";
				var spec_code_old="";
				var arr2_spec="";
				var opt ="";
				for (var m=0;m<arr_spec.length-1;m++ )
				{
					spec_code_new=arr_spec[m];
					 arr2_spec=spec_code_new.split(",");
					 opt = parent.frames[0].document.createElement('OPTION');
					opt.text =arr2_spec[1];
					opt.value=arr2_spec[0];
					document.forms[0].speciality.add(opt);
				}
		}else
		{
			assignListItems('*ALL','All Specialities');
		}

	}
}
function disableDocLevel(){
   var formObj = parent.parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
   if(formObj.doc_level.disabled==false)
	   formObj.doc_level.disabled=true;
}
function assignRecId(){
	var rows = parent.parent.parent.ObjectCollect.visit_pers_rows;
	parent.parent.parent.ObjectCollect.visit_pers_len=rows.length;

}

	function checkForSpecCharsforID1(event)
{  
    //var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.,!@#$%^&*()_+|}{[]\:?><,./;';
	var strCheck = "\"`'";
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode); 
    //if (strCheck.indexOf(key) == -1 && event.keyCode!=13) return false;  // Not a valid key
	if (strCheck.indexOf(key) != -1) return false;  // Not a valid key
	return true ;
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<body onLoad="assignSpeciality()">
<form name = "VisitingPersonnelRecordForm">
<input type='hidden' name="params" id="params" value="<%=request.getQueryString()%>" >

<% 
	String oper_num = checkForNull(request.getParameter("oper_num"));
	String facility_id = checkForNull(request.getParameter("facility_id"));
	/*String surgeon_doc_comp_yn = checkForNull(request.getParameter("surgeon_doc_comp_yn"));
	

	String disable_flag="";

	if(surgeon_doc_comp_yn.equals("Y"))
		disable_flag="disabled";
	else 
		disable_flag="";*/

	String SQL = "SELECT A.SPECIALITY_CODE SPL_CODE,DECODE(A.SPECIALITY_CODE,'*ALL','All Specialities',B.SHORT_DESC) SPL_DESC,A.VISITING_PERSONNEL VISIT_DESC FROM OT_POST_OPER_DTL2 A,AM_SPECIALITY B WHERE A.SPECIALITY_CODE=B.SPECIALITY_CODE(+) AND A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=?";
		
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;

	int index=0;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(SQL);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();
		while(rst.next()){
			++index;
	out.println("<script>loadDBRows('"+checkForNull(rst.getString("SPL_CODE"))+"','"+checkForNull(rst.getString("SPL_DESC"))+"',\""+java.net.URLEncoder.encode(checkForNull(rst.getString("VISIT_DESC")),"UTF-8")+"\",'"+index+"','L'); </script>");
	}
	    out.println("<script>assignRecId();</script>"); 
		out.println("<script>refresh();</script>");
	}catch(Exception e){
		System.err.println("Err Msg in VisitingPersonnelRecord.jsp"+e.getMessage());
	} finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}

%>

<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>
<tr> 

	 
	<td class="label" width="25%" >
	<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
	</td>
	 <td class="fields" width="25%">
		<select name="speciality" id="speciality" <%=disable_flag%> >
		</select>
	 </td>

 </tr>
<tr> <td class="label" width="25%" >
		<fmt:message key="eOT.VisitingPersonnel.Label" bundle="${ot_labels}"/></td>
	<td  class="fields"  width='25%'>
			<input type="hidden" name="wound_code" id="wound_code" >
			<textarea name='visit_txt' rows='3' cols='35'  <%=disable_flag%> onChange="checkLimit(this,500)"  Onblur="makeValidString(this);" onKeyPress="return checkForSpecCharsforID1(event)"></textarea>
	</td>
	
</tr>
<tr>
    <td width="25%"></td>
	<td width="25%"></td>
	<td width="25%"></td>
<td class="button" width="25%" colspan='2'>
		<input type='button' name='record' id='record' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='addRow();disableDocLevel()' <%=disable_flag%> >
		<input type='button' name='cancel' id='cancel' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow();' <%=disable_flag%> >
</td>

</tr>
</table>
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
<input type='hidden' name='mode' id='mode' value='I'>
<input type='hidden' name='recId' id='recId' value=''>
<input type='hidden' name='tab_id' id='tab_id' value='<%=checkForNull(request.getParameter("tab_id"))%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='tab' id='tab' value="<%=tab%>">
<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
<input type='hidden' name='oper_num' id='oper_num' value="<%=oper_num%>">
</form>
</body>
</HTML>


