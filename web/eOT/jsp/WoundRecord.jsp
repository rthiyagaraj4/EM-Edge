<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import ="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,eCommon.XSSRequestWrapper,webbeans.eCommon.*,eCommon.Common.*,eOT.*,eOT.Common.*"%>
<%@page  contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>

<HTML>
<HEAD>

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
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<script language="JavaScript" src="../../eOT/js/RecordSurgeon.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<!-- <script language="javascript" src="../../eOT/js/OTMessages.js"></script>
 -->
 
 <script language="JavaScript">

/*function updateWoundText(){
	var formObjCommon =parent.parent.ObjectCollect;
	var formObj = document.forms[0];
	formObjCommon.diagnosis_text=formObj.wound_txt.value;
	alert(parent.parent.ObjectCollect.wound_text)
}*/

function refresh(){
	var params = document.forms[0].params.value;
	 parent.DetailFrame.location.href='../../eOT/jsp/WoundDtls.jsp?'+params;
}

function Class_row()
{
  this.speciality_code ="";
  this.speciality_desc="";
  this.wound_code="";
  this.wound_desc="";
  this.db_mode="";
  this.recId="";
}

function loadDBRows(speciality_code,speciality_desc,wound_code,wound_desc,index,mode){ 
  var objrow = newRow();
  var rows=parent.parent.parent.ObjectCollect.wound_rows;
  //var rowLength=rows.length;
  var rowLength=parent.parent.parent.ObjectCollect.wound_len; //Modified on 13/02/2009 for display  problem of records.
  
  if(mode=='L' && rowLength==0){
	  objrow.speciality_code=speciality_code;
	  objrow.speciality_desc=speciality_desc;
	  objrow.wound_code=wound_code;
	  objrow.wound_desc=unescape(wound_desc);
	  objrow.recId = index;
	  objrow.db_mode="L";
	  rows.push(objrow);
	 }
}

function addRow(){
  var objrow = newRow();
  var msg = trimString(getMessage("SPECIALITY_DUPLICATE","OT"));
  var rows=parent.parent.parent.ObjectCollect.wound_rows;
  var formObj = document.WoundRecordForm;
  var params = formObj.params.value;
  var mode =formObj.mode.value;
  var obj = formObj.speciality;
  if(chkEmpty()){
	if(mode=='I'){
	   if(alreadyExist()){
		  objrow.speciality_code=formObj.speciality.value;
		  objrow.speciality_desc=formObj.speciality.options[obj.selectedIndex].text;
		  objrow.wound_code=formObj.wound_code.value;
		  objrow.wound_desc=formObj.wound_txt.value;
		  objrow.recId = rows.length+1;
		  objrow.db_mode="I";
		  rows.push(objrow);
		  resetFields();
		  parent.DetailFrame.location.href='../../eOT/jsp/WoundDtls.jsp?'+params;
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
	var formObj = document.WoundRecordForm;
	var codeDtl = parent.DetailFrame.code; 
	var codeRecord = formObj.speciality.value;
	if(codeDtl.indexOf(codeRecord)>=0)
	   return false;
	else
	  return true;
}

function removeRow(){
var formObj = document.WoundRecordForm;
var params = formObj.params.value;
var rows=parent.parent.parent.ObjectCollect.wound_rows;
var recId = document.forms[0].recId.value;
var mode = document.forms[0].mode.value;
var data_exist = getMessage("APP-OT0195","OT");
if(rows.length>0 && mode=='U'){        
  for(var jj=0;jj<rows.length;jj++){
	 if(rows[jj]!=null){
		if(rows[jj].recId==recId){
			 if(rows[jj].db_mode=='L'){
				alert(data_exist);
			    break;
			 }
			 else {
				delete rows[jj];
				resetFields();
				parent.DetailFrame.location.href='../../eOT/jsp/WoundDtls.jsp?'+params;
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
	var formObj = document.WoundRecordForm;
	var params = formObj.params.value;
	var	wound_code=formObj.wound_code.value;
	var	wound_desc=formObj.wound_txt.value;
	var mode =formObj.mode.value;
	var recId = formObj.recId.value;
	var rows=parent.parent.parent.ObjectCollect.wound_rows;
		if(rows.length>0 && mode=='U'){        
			for(var jj=0;jj<rows.length;jj++){
				if(rows[jj]!=null) {
					if(rows[jj].recId==recId){
						rows[jj].wound_code=wound_code;
						rows[jj].wound_desc=wound_desc;
						if(rows[jj].db_mode=='L')
						   	rows[jj].db_mode='U';
							break;
					}
		         }else  
			continue;
		 }
      resetFields();
	 parent.DetailFrame.location.href='../../eOT/jsp/WoundDtls.jsp?'+params;
 }
}

function chkEmpty(){
	return true;
}

function splitString(strVal){
    var arr = strVal.split('::');
	var formObj = document.WoundRecordForm;
	formObj.speciality.value=arr[0];
//alert 
//  alert( 'wound code '+ arr[1]);
//Modified by DhanasekarV against issue 27263 on 05/05/2011
	formObj.wound_code.value=arr[2];
	formObj.wound_txt.value = arr[3];
	formObj.recId.value = arr[4];
	formObj.mode.value = arr[5];
	formObj.speciality.disabled=true;
}

function resetFields(){
	var formObj = document.WoundRecordForm;
	formObj.wound_code.value='';
	formObj.wound_txt.value='';
	formObj.mode.value='I';
	formObj.WoundLookUp.focus();
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
	var rows = parent.parent.parent.ObjectCollect.wound_rows;
	parent.parent.parent.ObjectCollect.wound_len=rows.length;
	//alert(rows.length);
	
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<body onLoad="assignSpeciality()">
<form name = "WoundRecordForm">
<input type='hidden' name="params" id="params" value="<%=request.getQueryString()%>" >

<% 
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	String surgeon_doc_comp_yn = CommonBean.checkForNull(request.getParameter("surgeon_doc_comp_yn"));
		String tab = CommonBean.checkForNull(request.getParameter("tab")); 

	String disable_flag="";
	if(surgeon_doc_comp_yn.equals("Y"))
		disable_flag="disabled";
	else 
		disable_flag="";
	//String SQL = "SELECT A.SPECIALITY_CODE SPL_CODE,DECODE(A.SPECIALITY_CODE,'*ALL','All Specialities',B.SHORT_DESC) SPL_DESC,A.WOUND_TYPE WOUND_CODE,C.WOUND_TEXT WOUND_DESC FROM OT_POST_OPER_DTL2 A,AM_SPECIALITY B,OT_WOUND_TYPE C WHERE A.SPECIALITY_CODE=B.SPECIALITY_CODE(+) AND A.WOUND_TYPE=C.WOUND_TYPE_CODE(+) AND A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=?";


	String SQL = "SELECT A.SPECIALITY_CODE SPL_CODE,DECODE(A.SPECIALITY_CODE,'*ALL','All Specialities',B.SHORT_DESC) SPL_DESC,A.WOUND_TYPE WOUND_CODE,C.WOUND_TEXT WOUND_DESC FROM OT_POST_OPER_DTL2 A,AM_SPECIALITY B,OT_WOUND_TYPE_LANG_VW C WHERE C.LANGUAGE_ID(+)='"+locale+"' AND A.SPECIALITY_CODE=B.SPECIALITY_CODE(+) AND A.WOUND_TYPE=C.WOUND_TYPE_CODE(+) AND A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=?";
		
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
System.err.println("SQL :" +SQL);
	int index=0;
	try{
		con = ConnectionManager.getConnection(request);
		//pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_PERSONNEL_SELECT2")) ;
		pstmt = con.prepareStatement(SQL);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();
		while(rst.next()){
			++index;
		out.println("<script>loadDBRows('"+CommonBean.checkForNull(rst.getString("SPL_CODE"))+"','"+CommonBean.checkForNull(rst.getString("SPL_DESC"))+"','"+CommonBean.checkForNull(rst.getString("WOUND_CODE"))+"','"+CommonBean.checkForNull(rst.getString("WOUND_DESC"))+"','"+index+"','L'); </script>");
			
		}
		out.println("<script>assignRecId();</script>");
		out.println("<script>refresh();</script>");
	}catch(Exception e){
		e.printStackTrace();
		System.err.println("Err Msg in WoundRecord.jsp"+e.getMessage());
	} finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){e.printStackTrace();}
	}

%>

<table border='0' cellpadding=3  cellspacing='0' width='100%'>
<tr> 
	<td class='label' nowrap>
		<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
	</td>
	 <td class='fields'>
		  <select name="speciality" id="speciality" <%=disable_flag%> >
		   </select>
	 </td>
	 <td></td>
</tr>
<tr>
	<td class='label' valign='top' nowrap>
		<fmt:message key="eOT.WoundType.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields'>
		<input type="hidden" name="wound_code" id="wound_code" valign='top'>
		<textarea name='wound_txt' rows='5' cols='35' readonly <%=disable_flag%> > </textarea>
		<td class='label' align='left' valign='top' nowrap >
		<input type='button' name='WoundLookUp' id='WoundLookUp' class='button' value='?' onClick='searchWoundText(wound_code,wound_txt);' <%=disable_flag%> >
		</td>
	</td>
</tr>
<tr>
    <td width="25%"></td>
	<td width="25%"></td>
	<td width="25%"></td>
	<td width="25%"></td>
<td class='label' nowrap colspan=3>
  
	<input type='button' name='record' id='record' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='addRow();disableDocLevel()' <%=disable_flag%> >
	<input type='button' name='cancel' id='cancel' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow();' <%=disable_flag%> >
</td>

</tr>
</table>
<!-- added by Sathish for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
<!-- end -->
<input type='hidden' name='mode' id='mode' value='I'>
<input type='hidden' name='recId' id='recId' value=''>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='tab' id='tab' value="<%=tab%>">
<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
<input type='hidden' name='oper_num' id='oper_num' value="<%=oper_num%>">
<!-- Added below hidden field on march 1,2011 by Anitha -->
<input type='hidden' name='tab_id' id='tab_id' value='<%=CommonBean.checkForNull(request.getParameter("tab_id"))%>'>
</form>
</body>
</HTML>

