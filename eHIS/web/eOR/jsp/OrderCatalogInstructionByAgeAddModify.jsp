<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%> 

<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>



<script>
var flag = false;

function doClose(){
	//window.close();
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
}
/***************************************************************************/
function setTempInstr(){
	if(!finalChk())
		return ;
	
	eval(doSync(document.forms[0]));	
	if(!flag){
		alert(getMessage("SEX_MAX_MIN_OVERLAP_CHK","OR"));
		return false;
	}
}

/***************************************************************************/

function selectValues(){
	if(!finalChk())
		return ;
	
	eval(doSync(document.forms[0]));	
	
	if(flag){	
		document.chk_select_yn.select_yn.value = "Y";	
		parent.frames[0].document.location.href="../../eOR/jsp/OrderCatalogInstructionByAgeResult.jsp";
		document.forms[0].reset();
	}else{
		alert(getMessage("SEX_MAX_MIN_OVERLAP_CHK","OR"));
	}
}
/***************************************************************************/
function finalChk(){
	if(document.getElementById("sex_spec_ind").value==""){
		checkField( document.getElementById("sex_spec_ind"), "Sex Field" );
		return false;
	}

	if(document.getElementById("min_age_in_yrs").value=="" && 	
			document.getElementById("min_age_in_days").value=="" &&
				 document.getElementById("min_age_in_mths").value==""  )   {
		alert(getMessage("ONE_ENTRY_MIN_AGE","OR"));
		return false;
	}	

	if(document.getElementById("min_age_in_yrs").value=="0" && 	
			document.getElementById("min_age_in_days").value=="0" &&
				 document.getElementById("min_age_in_mths").value=="0"  )   {
		alert(getMessage("ONE_ENTRY_MIN_AGE","OR"));
		return false;
	}	
	 
	 if(document.getElementById("max_age_in_yrs").value=="" && 	
			document.getElementById("max_age_in_days").value=="" &&
				 document.getElementById("max_age_in_mths").value==""  )   {
		alert(getMessage("ONE_ENTRY_MAX_AGE","OR"));
		return false;
	}	

	if(!chkAgeEntries())
		return false;

	var currMsgTxt  = document.getElementById("pat_preps_or_instrns_txt_im").value ;
	if(currMsgTxt == ""){
		alert(getMessage("INSTRN_BLANK_CHK","OR"));
		return false;
	}
		
	return true;

}
/***************************************************************************/
function cancelValues(){
	doClose();
}
/***************************************************************************/
function captureValues(){
	//chk if SELECT button is clicked before OK button.If not retain the old value of Instr	
	if(document.getElementById("index").value == "" || document.getElementById("index").value == null ||
		   parseFloat(document.getElementById("index").value) < 0 )
	{
		document.AgeBySex.reset();
	}
	else if( (document.chk_select_yn.select_yn.value == "N") || (document.chk_select_yn.select_yn.value != "Y")){
		document.AgeBySex.pat_preps_or_instrns_txt_im.value=document.AgeBySex.temp_pat_preps_or_instrns_txt_im.value;
		document.AgeBySex.min_age_in_yrs.value=document.AgeBySex.temp_min_age_in_yrs.value;
		document.AgeBySex.min_age_in_mths.value=document.AgeBySex.temp_min_age_in_mths.value;
		document.AgeBySex.min_age_in_days.value=document.AgeBySex.temp_min_age_in_days.value;
		document.AgeBySex.max_age_in_yrs.value=document.AgeBySex.temp_max_age_in_yrs.value;
		document.AgeBySex.max_age_in_mths.value=document.AgeBySex.temp_min_age_in_mths.value;
		document.AgeBySex.max_age_in_days.value=document.AgeBySex.temp_max_age_in_days.value;
		document.AgeBySex.sex_spec_ind.selectedIndex=document.AgeBySex.temp_sex_spec_ind.value;
		eval(doSync(document.AgeBySex));	
	}
	
	doClose();
}
/***************************************************************************/
function clearValues(){
	if(document.getElementById("index").value == "" || document.getElementById("index").value == null ||
		   parseFloat(document.getElementById("index").value) < 0 )
	{
		document.AgeBySex.reset();
		return ;
	}
	document.getElementById("action").value = "delete";
	selectValues();
}
/***************************************************************************/
function checkMaxLimit(obj,maxSize){

	if ( obj.value.length >= maxSize )
	{
		event.returnValue = false;
	}
}
/***************************************************************************/
function chkLength(Obj,len)
{
	if(Obj.value.length > parseInt(len))
	{
		alert('The number of characters cannot exceed '+len);
		Obj.focus();Obj.value='';
	}
}
/***************************************************************************/
/****doSync This function--Sync the current tab to bean before going to other tab********/
function doSync(frmObj){
	/* var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var  xmlString = buildXml(frmObj);
	xmlDoc.loadXML(xmlString);
	xmlHttp.open("POST","../../eOR/jsp/OrderCatalogInstructionSync.jsp",false);
	xmlHttp.send(xmlDoc);
	return xmlHttp.responseText; */
	
	console.log(" Inside OrderCatlogInstructionsByAgeAddModify 175 frmObj : "+frmObj);
	
	var xmlStr = buildXml(frmObj);
	
	var parser = new DOMParser();
    var xmlDoc = parser.parseFromString(xmlStr, "text/xml");
	console.log(" Inside OrderCatlogInstructionsByAgeAddModify 181 xmlStr : "+xmlStr);
	
	var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("POST", "../../eOR/jsp/OrderCatalogInstructionSync.jsp", false);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    
 	// Send the XML
    xmlHttp.send(new XMLSerializer().serializeToString(xmlDoc));
    // Handle the response
    var responseText = xmlHttp.responseText;
    responseText = trimString(responseText);  
	
    console.log(" Inside OrderCatlogInstructionsByAgeAddModify 193 responseText : "+responseText);
	
	return responseText;
}
/****************this methos is called by the Sync jsp in retrun text******/
function syncStatus(flag1)
{
	flag = flag1;
}
/***********************doSync****************************************/
function buildXml(frmObj){
	
   
    var arrObj = frmObj.elements;

    var frmObjs = new Array()
    if(frmObj.name == null)
        frmObjs = frmObj ;
    else frmObjs[0] = frmObj ;
    var xmlStr ="<root><SEARCH ";

	for(var frmCount=0; frmCount<frmObjs.length; frmCount++) {
	frmObj = frmObjs[frmCount]
	var arrObj = frmObj.elements;

		for(var i=0;i<arrObj.length;i++) {
			var val = "" ;
			if(arrObj[i].type == "checkbox") {
				if(arrObj[i].checked)
					val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
			else if(arrObj[i].type == "radio") {
				if(arrObj[i].checked) {
					val = arrObj[i].value;
					if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
				}
			}
			else if(arrObj[i].type == "select-multiple" )
			{
				for(var j=0; j<arrObj[i].options.length; j++)
				{
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
				}
				val= val.substring(0,val.lastIndexOf('~'))
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;

			}
			else {
				val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
		}
	}

    xmlStr +=" /></root>";

	//alert(xmlStr);
	return xmlStr;

}

/****************************************************************************/
async function showMsgDialog()
{
	var dialogHeight ='34vh' ;
	var dialogWidth = '70vw' ;
	var dialogTop	= '0vh';
	var dialogLeft = '0vw' ; 

	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';		
	var arguments = "";	
	var currMsgTxtObj  = document.getElementById("pat_preps_or_instrns_txt_im") ;
	var msg_val = currMsgTxtObj.value;
	while((msg_val).indexOf("\r\n") != -1){
		msg_val = msg_val.replace("\r\n", " ");
	}
	var currMsgTxt = encodeURIComponent(currMsgTxtObj.value,"UTF-8");

	var indexVal = document.getElementById("index").value;
	var retVals =  await window.showModalDialog("../../eOR/jsp/OrderCatlogInstrByAgeInstr.jsp?mode=1&indexVal="+indexVal+"&currMsgTxt="+currMsgTxt,arguments,features);
	if(retVals != "")
	{
		document.getElementById("pat_preps_or_instrns_txt_im").value = retVals;	
		currMsgTxtObj.value	 =  trimString(retVals);
		if(document.getElementById("temp_pat_preps_or_instrns_txt_im").value != "")
		setTempInstr();
	}
}
/******************************************************************************/
function chkMonths(obj){

if(obj.value == null || obj.value== "")
	return;

if(!(parseFloat(obj.value) >= 0  && parseFloat(obj.value) <= 11)){
	obj.value ="";
	alert(getMessage("ENTER_MONTH_CHK","OR"));
	obj.focus();
}
}

/**************************************************************************/
function chkDaysVal(obj){

if(obj.value == null || obj.value== "")
	return;

if(!(parseFloat(obj.value) >= 1  && parseFloat(obj.value) <= 30)){
	obj.value ="";
	alert(getMessage("ENTER_DAY_CHK","OR"));
	obj.focus();
}
}
/************************************************************************/
function chkAgeEntries(){

	if(parseFloat(chkYrs()) == -1 ){
		alert(getMessage("MIN_MAX_AGE_CHECK","OR"));
		return false;
	}else if(parseFloat(chkYrs()) == 0 ){
		if(parseFloat(chkMnths()) == -1 ){
			alert(getMessage("MIN_MAX_AGE_CHECK","OR"));
			return false;
		 }else if(parseFloat(chkMnths()) == 0 )
			 if(parseFloat(chkDays()) == -1 || parseFloat(chkDays()) == 0){
				alert(getMessage("MIN_MAX_AGE_CHECK","OR"));
				return false;
		 }

   }
   return true;
}
/***********************************************************************/

function chkUtility(objMin,objMax){ //-1,0,1

	if(objMin == "")
	   objMin = 0;

	
	if(objMax == "")
	   objMax = 0;
	
	if(parseFloat(objMin)>parseFloat(objMax))
		return -1 ;
	if(parseFloat(objMin)==parseFloat(objMax))
		return 0 ;
	else
		return 1

}

function chkYrs(){
	return chkUtility(document.getElementById("min_age_in_yrs").value  ,document.getElementById("max_age_in_yrs").value  );
}

function chkMnths(){
	return chkUtility(document.getElementById("min_age_in_mths").value  ,document.getElementById("max_age_in_mths").value  );
}

function chkDays(){
	return chkUtility(document.getElementById("min_age_in_days").value  ,document.getElementById("max_age_in_days").value  );
}

</script>





</head>

<title><fmt:message key="eOR.InstructionbyAgeSex.label" bundle="${or_labels}"/></title>
<body onload='' onUnload ='' style='background-color:#E2E3F0;'  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">

<%
try{
	
	/* Mandatory checks start */
//	String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_OrderCatalog" ;
	String bean_name = "eOR.OrderCatalogBean";
	
    request.setCharacterEncoding("UTF-8");
	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject(bean_id, bean_name,request ) ;

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	
%>

<form name='AgeBySex' id='AgeBySex' action="">
	<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center'>
		
		<tr>
		<th  colspan='4'><b><-------<fmt:message key="Common.MinAge.label" bundle="${common_labels}"/>------------></b></th>
		<th  colspan='4'><b><-------<fmt:message key="Common.MaxAge.label" bundle="${common_labels}"/>------------></b></th>
		</tr>


	<tr>
		<td class='CAHIGHER_LEVEL_COLOR' ><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></td>

		<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.Years.label" bundle="${common_labels}"/></td>
		<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.months.label" bundle="${common_labels}"/></td>
		<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
		
		<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.Years.label" bundle="${common_labels}"/></td>
		<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.months.label" bundle="${common_labels}"/></td>
		<td class='CAHIGHER_LEVEL_COLOR'><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
		
		<td class='CAHIGHER_LEVEL_COLOR'>&nbsp;</td>

		

	</tr>
		
		<tr>
		<td class="fields"><select name='sex_spec_ind' id='sex_spec_ind'><option value='' selected>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--<option value='M' ><fmt:message key="Common.male.label" bundle="${common_labels}"/><option value='F' ><fmt:message key="Common.female.label" bundle="${common_labels}"/><option value='N' ><fmt:message key="Common.Both.label" bundle="${common_labels}"/></select></td>

		<td class="fields"><input type='text' value='' name='min_age_in_yrs' id='min_age_in_yrs' size='3'  class='number' maxlength='3' onKeyPress='return(ChkNumberInput(this,event,0))'></td>
		
		<td class="fields"><input type='text' value=''  name='min_age_in_mths' id='min_age_in_mths' size='2' maxlength='2'  onBlur='chkMonths(this)' class='number' onKeyPress='return(ChkNumberInput(this,event,0))'></td>
		
		<td class="fields"><input type='text' value='' name='min_age_in_days' id='min_age_in_days' size='3' maxlength='3'  onBlur='chkDaysVal(this)'  class='number' onKeyPress='return(ChkNumberInput(this,event,0))'></td>

<!-- Max  -->
		<td class="fields"><input type='text' value='' name='max_age_in_yrs' id='max_age_in_yrs' size='3'  class='number' maxlength='3'  	onKeyPress='return(ChkNumberInput(this,event,0))'></td>
		
		<td class="fields"><input type='text' value='' name='max_age_in_mths' id='max_age_in_mths' size='4' maxlength='4' onBlur='chkMonths(this)'  class='number' onKeyPress='return(ChkNumberInput(this,event,0))'></td>

	

		
		<td class="fields" ><input type='text' value='' name='max_age_in_days' id='max_age_in_days' size='2' maxlength='2' onBlur='chkDaysVal(this)'   class='number' onKeyPress='return(ChkNumberInput(this,event,0))'></td>

		
		
		<td  class=label><A class='gridLink' name='aaa' HREF='javascript:showMsgDialog()'><b><fmt:message key="eOR.Instrn.label" bundle="${or_labels}"/></A></td>	
		
		<INPUT TYPE="hidden" name="pat_preps_or_instrns_txt_im" id="pat_preps_or_instrns_txt_im" value="">
		<INPUT TYPE="hidden" name="temp_pat_preps_or_instrns_txt_im" id="temp_pat_preps_or_instrns_txt_im" value="">
		<input type="hidden" name="temp_sex_spec_ind" id="temp_sex_spec_ind" value="">
		<input type="hidden" name="temp_min_age_in_yrs" id="temp_min_age_in_yrs" value="">
		<input type="hidden" name="temp_min_age_in_mths" id="temp_min_age_in_mths" value="">
		<input type="hidden" name="temp_min_age_in_days" id="temp_min_age_in_days" value="">
		<input type="hidden" name="temp_max_age_in_yrs" id="temp_max_age_in_yrs" value="">
		<input type="hidden" name="temp_max_age_in_mths" id="temp_max_age_in_mths" value="">
		<input type="hidden" name="temp_max_age_in_days" id="temp_max_age_in_days" value="">
	 	</tr>
	
		<tr>
		<td colspan='11' align='right' class='white'>
		<input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")%>' onClick='selectValues()'>
		<input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onClick='captureValues()'>
		<input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearValues()'>
		<input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onClick='cancelValues()'></td>
		</tr>

</table>

<INPUT TYPE="hidden" name="instructionType" id="instructionType"  value="IM">
<INPUT TYPE="hidden" name="instrn_content_type" id="instrn_content_type"  value="T">
<INPUT TYPE="hidden" name="index" id="index"  value="-1">
<INPUT TYPE="hidden" name="action" id="action"  value="add"><!-- valid values add/update/delete -->
</form>
	<form name="chk_select_yn" id="chk_select_yn">
	<input type="hidden" name="select_yn" id="select_yn" value="N">
	</form>
</body>
</html>
<%
		putObjectInBean(bean_id,bean,request);
 
}catch(Exception e){
System.out.println(e.getMessage());
}%>

