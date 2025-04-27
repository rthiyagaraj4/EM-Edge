
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------?                              ?           created
25/7/2011  IN27169		     Dinesh T	 OrderEntryFormat dependencies are not filtered properly
20/08/2014 IN050609			 Nijitha S	 CRF-OR-Bru-HIMS-CRF-434/01-Operator value not defaulted to current date at Date depnedency
20/08/2014 IN050630			 Nijitha S									CRF-OR-Bru-HIMS-CRF-434/04-script error while setup to dependency date validation  in Order format
--------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%> 
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%> 
 
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
	<!-- <title>Dependency</title> -->
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrderEntryFormats.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
 	<script language="JavaScript">
<!--
var values_arr				= new Array();
var other_mnemonic_arr		= new Array();
var action_arr				= new Array();
var message_arr				= new Array();
var operator_arr			= new Array();
function closeWindow(){
}
/*function called on onload to build the table according to the default value of the mnemmonic*/
function chkonload(){	
	var	default_val=document.decision_support.default_val.value	
	var	mnemonic=document.decision_support.mnemonic.value			
	var	ord_cat=document.decision_support.ord_cat.value
	var count =document.decision_support.count.value;

	if( default_val == "C" ){
		document.getElementById("values0").innerHTML = "<div class='label'><B>Yes</B></div>"
		document.getElementById("values1").innerHTML = "<div class='label'><B>No</B></div>"
	}else if( default_val ==  "N" || default_val == "E" || default_val == "I" || default_val == "D"){
		document.getElementById("row_id"+i).style="display";
		if(document.decision_support.visible_rows.value > 0){
			var j=	document.decision_support.visible_rows.value
				eval("document.getElementById('del_row0')").style.visibility	= 'hidden';
				
			for(var i=0;i<j;i++){
				eval(document.getElementById('row_id'+i)).style="display";
				eval(document.getElementById('next_row'+i)).style.visibility	= 'hidden';
				
			}var temp= j-1;
			eval(document.getElementById('next_row'+temp)).style.visibility		= 'visible';
			
		}if(default_val == "N" || default_val == "I" ){
			for(var i=0;i<j;i++){
				if(eval("document.decision_support.between_value"+i).value == "")
					eval("document.decision_support.between_val"+i).style.display = 'none';
				else
					eval("document.decision_support.between_val"+i).style="display";
			}
			
		}
	}
	for( var i=0;i<count;i++ ){
		if(eval("document.decision_support.action"+i))
		{
			var action = eval("document.decision_support.action"+i).value ;
			if( default_val == "C" )
				eval(document.getElementById('row_id'+i)).style="display";
			else if( default_val == "L" || default_val == "R" )
				eval(document.getElementById('row_id'+i)).style="display";
			else if( default_val == "E" || default_val == "D"){
				eval("document.getElementById('values')"+i).style.display = 'none';
			}
			if( action == "N" ){
				eval("document.decision_support.mandatory"+i).style.visibility	= 'hidden';
			}
		}
	}
}

/*Operator's check to display and hide the values column*/
function chkforOperator(target,index){
	var	default_val=document.decision_support.default_val.value
	var	oper_value=eval("document.decision_support.operator_value"+index).value
	if(default_val == "N" || default_val == "I" ){
		if(oper_value == ""){
			eval("document.decision_support.between_val"+index).style.display = 'none';
		}else if(oper_value == "B"){
			eval("document.decision_support.between_val"+index).style="display";
		}else if(oper_value == "L" || oper_value == "G"|| oper_value =="E"){
			eval("document.decision_support.between_val"+index).style.display = 'none';
			eval("document.decision_support.between_val"+index).value="";
		}
	}
}
/*inserts new row's dynamically for default value's N and E*/
function insertNextrow(index){
	
	var i		= index;
	var y		= document.decision_support.row_count.value;
	var count	=document.decision_support.count.value;
	var	default_val=document.decision_support.default_val.value
	if(default_val == "E" || default_val == "N" || default_val == "I" || default_val == "D"){
		if(document.decision_support.visible_rows.value > 0 ){
			var j =	document.decision_support.visible_rows.value
			y = j-1;
		}if(i != y)
			y= i;
	}
	if(y<count-1){
		eval(document.getElementById('next_row'+i)).style.visibility	= 'hidden';
		document.decision_support.row_count.value= ++y;
		eval(document.getElementById('row_id'+y)).style="display";
	}else
		alert("APP-OR0231 No more new rows can be created....");

}
function deleteRow(index){
	
	var i		= index;
	var y		= document.decision_support.row_count.value;
	var count	= document.decision_support.count.value;
	var	default_val=document.decision_support.default_val.value
	if(i == 0 || i == 99)
		alert("APP-OR0232 No more rows can be deleted...");
	if(i>0 && i<99){
		eval(document.getElementById('row_id'+i)).style.display			= 'none';
		if(default_val == "E" || default_val == "D" ){		
			
			document.decision_support.visible_rows.value=i;
			eval("document.decision_support.date_val"+i).value		 = "current_date_time" ;
			eval("document.decision_support.operator_value"+i).value = "" ;
			eval("document.decision_support.action"+i).value		 = "N";
			eval("document.decision_support.message"+i).value		 = "" ;
			eval("document.decision_support.depend_finalString"+i).value = "";
	
		}else if(default_val == "N" || default_val == "I" ){	
			document.decision_support.visible_rows.value=i;
			eval("document.decision_support.operator_value"+i).value	 = "" ;
			eval("document.decision_support.list_val"+i).value			 = "";
			eval("document.decision_support.between_val"+i).value		 = "" ;
			eval("document.decision_support.action"+i).value			 = "N";
			eval("document.decision_support.message"+i).value			 = "";
			eval("document.decision_support.depend_finalString"+i).value = "";
			
		}
		if(i ==document.decision_support.row_count.value ){
			i=i-1;
			eval("document.getElementById('next_row')"+i).style.visibility	= 'visible';
			document.decision_support.row_count.value			= i;
		}else if(i < document.decision_support.row_count.value ) {
			y= y-1;
			document.decision_support.row_count.value=y;
		}else if(i > document.decision_support.row_count.value ) {
			y=y-1;
			eval("document.getElementById('next_row')"+y).style.visibility	= 'visible';
			document.decision_support.row_count.value			= y;
		}
		
	}

}
/*function checks for mandatory conditions  */
function chkMandatory(obj,index)
{
	var	default_val=document.decision_support.default_val.value
	var i = index;
	eval("document.decision_support.message"+i).value="";
	
	var action = eval("document.decision_support.action"+i).value ;
	if(action=="N"){
		eval("document.decision_support.mandatory"+i).style.visibility	= 'hidden';
		eval("document.decision_support.oth_mnemonic"+i).disabled		= false ;
		eval("document.decision_support.message"+i).disabled			= true;
	}else if(action=="W"){
		eval("document.decision_support.mandatory"+i).style.visibility	= 'visible';
		eval("document.decision_support.oth_mnemonic"+i).disabled		= false ;
		eval("document.decision_support.message"+i).disabled			= false;
	}else if(action=="S"){
		eval("document.decision_support.mandatory"+i).style.visibility	= 'visible';
		eval("document.decision_support.oth_mnemonic"+i).disabled		= true ;
		eval("document.decision_support.message"+i).disabled			= false;
	}
}
/*****************Between Value check *****************/
function chkBtwn(obj,index){

var between_val_obj	   = eval("document.decision_support.between_val"+index);
var list_val_obj	   = eval("document.decision_support.list_val"+index);

if(eval(between_val_obj.value) == ""){
	//obj.select();
	between_val_obj.focus();
	between_val_obj.select();

}else{
	if(parseFloat(eval(between_val_obj.value)) < parseFloat(eval(list_val_obj.value))){
			alert("APP-OR0232 Please enter a meaningful value ...");
			between_val_obj.value = "";
			between_val_obj.focus();
			between_val_obj.select();
	 }
}

}

function isValidDecimal(val){
	if(isNaN(eval(val))){
		alert(getMessage('INVALID_DECIMAL_NUMBER','OR'));		
		return false
	}else{
		return true
	}
}

function checkDecimalRange(val,position1,position2){
	var val_length = val.length;

	if(val == "" )
		return true ;
	if(val.indexOf(".") != -1){
		val = parseFloat(eval(val))

		position1 = parseFloat(eval(position1))
		position2 = parseFloat(eval(position2))
		if(!((val >= position1) && (val <= position2))){
			return false
		}

	}else{
		val = parseFloat(val)
		position1 = parseFloat(eval(position1))
		position2 = parseFloat(eval(position2))

		if(!((val >= position1) && (val <= position2))){

			return false
		}
	}
	return true
}

function checkIntegerRange(val,position1,position2){
	if(val == "" )
		return true ;

		val = parseInt(eval(val))
		position1 = parseInt(eval(position1))
		position2 = parseInt(eval(position2))

		if(!((val >= position1) && (val <= position2))){
			return false
		}
	return true
}
/**takes values for insertion*/
function chkforValues(){
	var dontChknum=parent.list_bottom.list_dtl.dontChk.value;
	var seq_num_length = parseInt((parent.list_top.seq_arr.length),10)+1;
	var sequencenumber=document.decision_support.seq_no.value;
	var	default_val	= document.decision_support.default_val.value
	var	min_val	= document.decision_support.min_val.value
	var	max_val	= document.decision_support.max_val.value
	var	mnemonic	= document.decision_support.mnemonic.value
	var count		= document.decision_support.count.value
	var values;var action;var message;var finalValue = "";var date_val;var operator_val;var notify;
	var finalValue1 = "";var j;
	var row_count   = document.decision_support.row_count.value
	if( default_val == "C" || default_val == "L" || default_val == "R" )
	{	
		for( var i=0;i<count;i++ ){
			
			values	= eval("document.getElementById('values')"+i).innerText;		
			if((values!=undefined) ||(values!=null))
			{
				if(values!=null||values!="")
				{
					if(dontChknum=="")
					{
						setFormatValues("dependency_"+seq_num_length+"_array"+i,values);
					}
					else
					{
						setFormatValues("dependency_"+dontChknum+"_array"+i,values);
					}
				}
			}
			if(dontChknum=="")
			{
				values="dependency_"+seq_num_length+"_array"+i;
			}
			else
			{
				values="dependency_"+dontChknum+"_array"+i;
			}
			values_arr[i]	= values;
			action	= eval("document.decision_support.action"+i).value ;
			action_arr[i]	= action;
			message	= eval("document.decision_support.message"+i).value ;
			if(eval("document.decision_support.notify_chk"+i).checked == true)
				notify			= "Y" ; 
			else
				notify			= "N" ;
			message_arr[i]	= message;
			depend_finalString = eval("document.decision_support.depend_finalString"+i).value;
			
			j		= i+1;

			if(action == "S" && message == "")
			{	alert('APP-OR237 Please Enter the Message for Action');
				eval("document.decision_support.message"+i).focus() ;
				return false;}
			else if(action == "W" && message == "")
			{	alert('APP-OR237 Please Enter the Message for Action');
				eval("document.decision_support.message"+i).focus() ;
				return false;}
			if(message == "")
				message = " ";
			if(action == "S")
				depend_finalString = " ";
			if(depend_finalString == ""|| depend_finalString == "N")
				depend_finalString = " ";
			
			if(depend_finalString == "Y")
			{	populateOtherMnemonicvalues(j);
				depend_finalString = document.decision_support.depend_finalString.value;
			}
			
			//finalValue += 
				//values+","+j+","+" "+","+" "+","+action+","+(message)+","+notify+","+depend_finalString+"||";

				finalValue += 
				values+","+j+","+" "+","+" "+","+action+","+(message)+","+notify+","+depend_finalString+"||";
			
		}
			
	}else if(default_val == "E" || default_val == "D"){
		for( var i=0;i<=row_count;i++ ){
			if(eval("document.decision_support.operator_value"+i).value != ""){
				temp_oper_val	 =	eval("document.decision_support.operator_value"+i).value ;
				temp_action		 = eval("document.decision_support.action"+i).value ;
				for(var j=i+1;j<=row_count;j++){
					dup_oper_val	= eval("document.decision_support.operator_value"+j).value ;
					dup_actiuon		= eval("document.decision_support.action"+j).value ;
					if(temp_oper_val == dup_oper_val && temp_action == dup_actiuon)
					{	alert("APP-OR0233 Duplicate found in combination of Operator and Action");
						eval("document.decision_support.operator_value"+j).focus();
						return false;
					}
				}	
			}
		}
		for( var i=0;i<=row_count;i++ ){
			if(eval("document.decision_support.operator_value"+i).value =="" ){
			//alert("select anyof the operator values:");
			
			}else{
			
			date_val	= eval("document.decision_support.date_val"+i).value ;
			operator_val= eval("document.decision_support.operator_value"+i).value ;
			action		= eval("document.decision_support.action"+i).value ;
			message		= eval("document.decision_support.message"+i).value ;
			if(eval("document.decision_support.notify_chk"+i).checked == true)
				notify			= "Y" ; 
			else
				notify			= "N" ;
			depend_finalString = eval("document.decision_support.depend_finalString"+i).value;
			j=i+1;values=" ";
			
			if(action == "S" && message == "")
			{	alert('APP-OR237 Please Enter the Message for Action');
				eval("document.decision_support.message"+i).focus() ;
				return false;}
			else if(action == "W" && message == "")
			{	alert('APP-OR237 Please Enter the Message for Action');
				eval("document.decision_support.message"+i).focus() ;
				return false;}
			if(message == "")
				message = " ";
			if(action == "S")
				depend_finalString = " ";
			if(depend_finalString == ""|| depend_finalString == "N")
				depend_finalString = " ";
			if(depend_finalString == "Y")
			{	populateOtherMnemonicvalues(j);
				depend_finalString = document.decision_support.depend_finalString.value;
			}
				
			finalValue += date_val+","+j+","+values+","+operator_val+","+action+","+(message)+","+notify+","+depend_finalString+"||";
			}
		}
	}else if(default_val == "N" || default_val == "I" ){
		for( var i=0;i<=row_count;i++ ){
			if(eval("document.decision_support.operator_value"+i).value != ""){
				temp_oper_val	= eval("document.decision_support.operator_value"+i).value ;
				temp_action		= eval("document.decision_support.action"+i).value ;
				for(var j=i+1;j<=row_count;j++){
					dup_oper_val	= eval("document.decision_support.operator_value"+j).value ;
					dup_action		= eval("document.decision_support.action"+j).value ;
					if(temp_oper_val == dup_oper_val && temp_action == dup_action)
					{	alert("APP-OR0233 Repeatation in the combination of Operator and Action");
						eval("document.decision_support.operator_value"+j).focus();
						return false;
					}
				}
				
			}
		}
		for( var i=0;i<=row_count;i++ ){
			if(eval("document.decision_support.operator_value"+i).value =="" ){
			
			}else{
				operator_val	= eval("document.decision_support.operator_value"+i).value ;
				list_val		= eval("document.decision_support.list_val"+i).value ;
				between_val		= eval("document.decision_support.between_val"+i).value ;
				action			= eval("document.decision_support.action"+i).value ;
				message			= eval("document.decision_support.message"+i).value ;
				
				if(list_val == ""){
					alert('APP-OR237 Values Cannot be blank...');
					eval("document.decision_support.list_val"+i).select()
					eval("document.decision_support.list_val"+i).focus()
					return false;
				}
				if(eval("document.decision_support.operator_value"+i).value =="B" && between_val == ''){
					alert('APP-OR237 Values Cannot be blank...');
					eval("document.decision_support.between_val"+i).select()
					eval("document.decision_support.between_val"+i).focus()
					return false;

				}
				if(eval("document.decision_support.notify_chk"+i).checked == true)
					notify			= "Y" ; 
				else
					notify			= "N" ;

				depend_finalString = eval("document.decision_support.depend_finalString"+i).value;
				j				= i+1;
				if(default_val == "N"){
					if((isValidDecimal(list_val))){

						if(list_val.indexOf(".") != -1){
							int_part = list_val.split(".")
							decimal_val = int_part[1]
							decimal_pos = int_part.length +1
							
							if(decimal_val.length > 3) {
								alert(getMessage('MAX_NO_DECIMAL','OR'))
								eval("document.decision_support.list_val"+i).select()
								eval("document.decision_support.list_val"+i).focus()
								return false
							}
						}

						if(min_val != "" && max_val != ""){
							//alert(checkDecimalRange(list_val,min_val,max_val))
							if((checkDecimalRange(list_val,min_val,max_val)) == false){
								//alert("Invalid Decimal Range...")
								alert(getMessage('INVALID_DECIMAL_RANGE','OR'))  ;
								eval("document.decision_support.list_val"+i).select()
								eval("document.decision_support.list_val"+i).focus()
								return false
							}
						}
					}else{
						eval("document.decision_support.list_val"+i).select()
						eval("document.decision_support.list_val"+i).focus()
						return false
					}
				}
				
				if(default_val == "I"){
					if(min_val != "" && max_val != ""){
						if((checkIntegerRange(list_val,min_val,max_val)) == false){
							//alert("Invalid Integer Range...")
							alert(getMessage('INVALID_INTEGER_RANGE','OR'))  ;
							eval("document.decision_support.list_val"+i).select()
							eval("document.decision_support.list_val"+i).focus()
							return false
						}else if((checkIntegerRange(between_val,min_val,max_val)) == false){
							//alert("Invalid Integer Range...")
							alert(getMessage('INVALID_INTEGER_RANGE','OR'))  ;
							eval("document.decision_support.between_val"+i).select()
							eval("document.decision_support.between_val"+i).focus()
							return false
						}//checkIntegerRange if lup ends
					}//min_val & max_val  if lup ends
				}//default_val  if lup ends
				
				
				
				if(between_val == "")
					between_val = " ";
				if(action == "S" && message == "")
				{	alert('APP-OR237 Please Enter the Message for Action');
					eval("document.decision_support.message"+i).focus() ;
					return false;
				}else if(action == "W" && message == "")
				{	alert('APP-OR237 Please Enter the Message for Action');
					eval("document.decision_support.message"+i).focus() ;
					return false;}
				if(message == "")
					message = " ";
				if(action == "S")
					depend_finalString = " ";
				if(depend_finalString == "" || depend_finalString == "N")
					depend_finalString = " ";
				if(depend_finalString == "Y")
				{	populateOtherMnemonicvalues(j);
					depend_finalString = document.decision_support.depend_finalString.value;
				}
			
				finalValue += list_val+","+j+","+between_val+","+operator_val+","+action+","+(message)+","+notify+","+depend_finalString+"||";

			}	
		}
	}
	
	document.decision_support.finalvalue.value		= finalValue;
	parent.list_bottom.list_dtl.finalValue.value	= finalValue;
	if(finalValue != "")
		parent.list_bottom.list_dtl.chk_depnd.checked = true ;
	else 
		parent.list_bottom.list_dtl.chk_depnd.checked = false ;

	parent.list_top.list_top.disabled				 = false;
	parent.list_bottom.list_dtl.chk_depnd.disabled	 = false;
	parent.list_bottom.list_dtl.depend.disabled		 = false;
	parent.list_bottom.list_dtl.clear.disabled		 = false;
	var dontChk = document.getElementById("dontChk").value;
	if (parent.list_top.mnemonic_arr[dontChk]	== "SPECIMEN_TYPE" || parent.list_top.mnemonic_arr[dontChk] ==  "NURSE_COLLECT_YN" || parent.list_top.mnemonic_arr[dontChk] ==  "COLLECTION_STAGE") 
	{
		if((parent.list_top.occ_no_arr[dontChk]==1)||(parent.list_top.occ_no_arr[dontChk]==undefined)||(parent.list_top.occ_no_arr[dontChk]=="undefined"))
		{
			parent.list_bottom.list_dtl.clear.disabled = true;
		}
		else
		{
			parent.list_bottom.list_dtl.clear.disabled =false;
		}
	}
	parent.list_bottom.list_dtl.mnemonic.disabled	 = false;
	parent.list_bottom.list_dtl.select.disabled		 = false;
	parent.list_bottom.list_dtl.ok.disabled			 = false;
	parent.list_bottom.list_dtl.close.disabled		 = false;
	parent.list_bottom.list_dtl.seq_no.disabled		 = false;
	parent.list_depend.location.href="../../eCommon/html/blank.html";
}

/****funtion called on click of cancel*****/
function clkCancel(){
	var finalValue = document.decision_support.finalvalue.value;
	parent.list_bottom.list_dtl.finalValue.value	 = finalValue;
	
	if(finalValue != "")
		parent.list_bottom.list_dtl.chk_depnd.checked	 = true ;
	if(finalValue == "")
		parent.list_bottom.list_dtl.chk_depnd.checked	 = false ;

	parent.list_top.list_top.disabled					 = false;
	parent.list_bottom.list_dtl.chk_depnd.disabled		 = false;
	parent.list_bottom.list_dtl.depend.disabled			 = false;
	parent.list_bottom.list_dtl.clear.disabled			 = false;
	parent.list_bottom.list_dtl.mnemonic.disabled		 = false;
	parent.list_bottom.list_dtl.select.disabled			 = false;
	parent.list_bottom.list_dtl.seq_no.disabled			 = false;
	parent.list_bottom.list_dtl.ok.disabled				 = false;
	parent.list_bottom.list_dtl.close.disabled			 = false;
	parent.list_depend.location.href="../../eCommon/html/blank.html";
}

-->
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	 
</head>
<body onLoad='chkonload()' onunload=""  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name="decision_support" id="decision_support"  >
<%
try{
	
	String bean_id		= "Or_OrderEntryFormats" ;
	String bean_name	= "eOR.OrderEntryFormats";
	OrderEntryFormats beanObj = (OrderEntryFormats)getBeanObject( bean_id, bean_name, request ) ;
     request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	
	String default_val	= request.getParameter("dflt_val")==null?"":request.getParameter("dflt_val");
	String min_val	= request.getParameter("min_val")==null?"":request.getParameter("min_val");
	String max_val	= request.getParameter("max_val")==null?"":request.getParameter("max_val");
	String mnemonic		= request.getParameter("mnemonic");
	String ord_cat		= request.getParameter("ord_cat")==null?"":request.getParameter("ord_cat");;
	String order_type	=  request.getParameter("order_type")==null?"":request.getParameter("order_type");
	String order_catalog= request.getParameter("ord_catalog")==null?"":request.getParameter("ord_catalog");
	String level		= request.getParameter("level")==null?"":request.getParameter("level");
	String seq_no		= request.getParameter("seq_no")==null?"":request.getParameter("seq_no");
	String finalString	= request.getParameter("finalString")==null?"":request.getParameter("finalString");
	String finalValue	= request.getParameter("finalValue")==null?"":request.getParameter("finalValue");
	String dontChk	= request.getParameter("dontChk")==null?"":request.getParameter("dontChk");
	String format_id = request.getParameter("format_id")==null?"":request.getParameter("format_id");
		
	int i=0,count=1;
	TreeMap OrderTypeData = null;//<IN27169>

	String date_value		 = "";
	String operator_value	 = "";
	String action_value		 = "";
	String other_mnemonic	 = "";
	String message_text		 = "";
	String message_value	 = "";
	String notify			 = "";
	String list_operator_value = "";
	String between_value	 = "";
	String depend_finalString= "";
	//String prev_values		 = "";
	
	String chk_func			 = "";
	//IN050609 Starts
	if(default_val.equals("E"))
		date_value		= "current_date_time"	;
	else
		date_value		= "current_date"	;
	//date_value		= "current_date_time";
	//IN050609 Ends
	action_value	= "N";

	other_mnemonic	= "Y";
	message_text	= "N";
	out.println("<input type=hidden name='default_val' id='default_val' value='"+default_val+"'>" );
	out.println("<input type=hidden name='min_val' id='min_val' value='"+min_val+"'>" );
	out.println("<input type=hidden name='max_val' id='max_val' value='"+max_val+"'>" );
	out.println("<input type=hidden name='mnemonic' id='mnemonic' value='"+mnemonic+"'>" );
	out.println("<input type=hidden name='ord_cat' id='ord_cat' value='"+ord_cat+"'>" );
	out.println("<input type=hidden name='dontChk' id='dontChk' value='"+dontChk+"'>" );
	
	if(finalValue.equals("Y")){
		StringBuffer prev_values = new StringBuffer();
		ArrayList depend_values = new ArrayList();
		depend_values = beanObj.getDependency(level,ord_cat,order_type,order_catalog,seq_no,mnemonic);
		String[] record = null;
		for(int k=0; k<depend_values.size(); k++){
			record = (String [])depend_values.get(k);
			if(record[2]== null)
				record[2]=" ";
			if(record[5] == null)
				record[5] = " ";
			//prev_values.append( record[0]+","+record[1]+","+record[2]+","+record[3]+","+record[4]+","+record[5]+","+record[6]+","+record[7]+"||");

		}
		finalValue = prev_values.toString();		
		record = null;
		prev_values.setLength(0);
		depend_values.clear();
	}

	if(default_val.equals("C"))
		count=2;
	else if(default_val.equals("L") || default_val.equals("R")){
		//OrderTypeData = beanObj.getListTypeData(ord_cat,mnemonic) ;
		if((seq_no!=""||seq_no.equals("")) && (format_id!=""||format_id.equals("")))
		{
			OrderTypeData = beanObj.getListTypeData(ord_cat,mnemonic,seq_no,format_id) ;
		}
		else
		{
		   OrderTypeData = beanObj.getListTypeData(ord_cat,mnemonic) ;
		}
		count=OrderTypeData.size();
	}else if(default_val.equals("E") || default_val.equals("N") || default_val.equals("I")|| default_val.equals("D"))
		count=100;
	
	out.println("<input type=hidden name='count' id='count' value='"+count+"'>" );
	
	if(count  == 0)
	{%>	<script>
			alert('APP-002415 Query caused No records to be retrieved...');
			parent.list_top.list_top.disabled				= false;
			parent.list_bottom.list_dtl.chk_depnd.checked	= false ;
			parent.list_bottom.list_dtl.clear.disabled		= false;
			parent.list_bottom.list_dtl.mnemonic.disabled	= false;
			parent.list_bottom.list_dtl.select.disabled		= false;
			parent.list_bottom.list_dtl.seq_no.disabled		= false;
			parent.list_bottom.list_dtl.ok.disabled			= false;
			parent.list_bottom.list_dtl.close.disabled		= false;

			parent.list_depend.location.href="../../eCommon/html/blank.html";
		</script>

	<%}
	String[] record = null;
	String[] record1 =null ;int j=0;
	
	if(finalValue != null || !finalValue.equals("")){
		StringTokenizer st1		= new StringTokenizer(finalValue,"||");
		String			mainStr = "";
		int cnt=st1.countTokens();
		record1 = new String[cnt] ;
		while(st1.hasMoreTokens()){
			mainStr  = st1.nextToken();
			record1[j]=mainStr;
			j++;
		}
		out.println("<input type=hidden name='visible_rows' id='visible_rows' value='"+j+"'>" );
	}
	
%>
<table cellpadding=3 cellspacing=0 border=1 width='100%'>
<th><fmt:message key="Common.Dependency.label" bundle="${common_labels}"/></th>
</table>
<table class='grid' width='100%'>
<tr>
<%if(default_val.equals("N")||default_val.equals("E") || default_val.equals("I") || default_val.equals("D")){%>
	<th><fmt:message key="Common.Operator.label" bundle="${common_labels}"/></th>
<%} if(!default_val.equals("E") && !default_val.equals("D")){%>
	<th><fmt:message key="Common.Values.label" bundle="${common_labels}"/></th>
<%}%>
	<th><fmt:message key="Common.action.label" bundle="${common_labels}"/> </th>
	<th><fmt:message key="Common.Message.label" bundle="${common_labels}"/> </th>
	<th><fmt:message key="eOR.AlertDept.label" bundle="${or_labels}"/></th>
	<th><fmt:message key="eOR.OtherMnemonic.label" bundle="${or_labels}"/></th>
</tr>
<%
String classValue= "";
String[] record2	 = null ;
StringTokenizer st2	 =null;
for(i=0;i<count;i++){
	classValue			=( (i%2)==0 )? "gridData" : "gridData";
	if(!finalValue.equals("")){
		if((default_val.equals("E") || default_val.equals("N") || default_val.equals("I") || default_val.equals("D"))&& i<j){
			st2	 = new StringTokenizer(record1[i],",");			
			record2	 = new String[8] ;
			int y=0;
			while(st2.hasMoreTokens()){
				record2[y] = st2.nextToken();
				if(default_val.equals("E")|| default_val.equals("D")){
					//IN050609 Starts
					//date_value 		= record2[0];
					if(!"".equals(record2[0].trim()) && !"null".equals(record2[0]) && "Y".equals(record2[0].substring(0,1)))
						date_value		 = record2[0].substring(1);
					else
						date_value 		= record2[0];
					//IN050609 Ends
				//	seq_num			 = record2[1] ;
				//	list_value		 = record2[2] ;
					operator_value	 = record2[3] ;
					action_value	 = record2[4] ;
					message_value	 = record2[5] ;
					notify			 = record2[6] ;
					depend_finalString = record2[7] ;
				}else if(default_val.equals("N")|| default_val.equals("I")){
					
					list_operator_value = record2[0] ;
				//	seq_num			 = record2[1] ;
					between_value	 = record2[2] ;
					operator_value	 = record2[3] ;
					action_value	 = record2[4] ;
					message_value	 = record2[5] ;
					notify			 = record2[6] ;
					depend_finalString = record2[7] ;
				}
				y++;
				
			} record2 = null;
		}else if(default_val.equals("C") || default_val.equals("L") || default_val.equals("R") ){
			st2	 = new StringTokenizer(record1[i],",");
			record2	 = new String[8] ;
			int y=0;
			while(st2.hasMoreTokens()){
				record2[y]		 = st2.nextToken();
				if(default_val.equals("C") || default_val.equals("L") || default_val.equals("R") ){
				//	list_value			 = record2[0] ;
				//	seq_num				 = record2[1] ;
				//	field_mnemonic_value1= record2[2] ;
				//	field_value_type	 = record2[3] ;
					action_value		 = record2[4] ;
					message_value		 = record2[5] ;
					notify				 = record2[6] ;
					depend_finalString	 = record2[7] ;
				}
				y++;
				
			} record2 = null;
		}
		else
		{
			if(default_val.equals("E"))
			date_value		= "current_date_time"	;
			else
			date_value		= "current_date"	;
			operator_value	= ""	;
			action_value	= "N"	;
			message_value	= ""	;
			list_operator_value = "";
			depend_finalString	= "";
			between_value	= "";

			other_mnemonic	= "Y"	;
			message_text	= "N"	;
			notify			= "N"	;
			
		}
		if(message_value.equals(" ")|| message_value == null)
			message_value	= "";
		if(between_value.equals(" ")|| between_value == null)
			between_value	= "";
		if(depend_finalString.equals(" ")|| depend_finalString == null)
			depend_finalString = "";  
		if(action_value.equals("S")){
			other_mnemonic	= "N";
			message_text	= "Y";
		}else if( action_value.equals("W")){
			other_mnemonic	= "Y";
			message_text	= "Y";
		}else if(action_value.equals("N")){
			message_text	= "N";
			other_mnemonic	= "Y";} 

		out.println("<input type=hidden name='between_value"+i+"' id='between_value"+i+"' value='"+between_value+"'>" );
	}
%>
<tr id=row_id<%=i%>>
	<%if(default_val.equals("N") || default_val.equals("E")|| default_val.equals("I") || default_val.equals("D")){%>
	
	<td class='<%=classValue%>' align='center' nowrap>
	<label class='label' id='oper<%=i%>'>
<%	
	if(default_val.equals("E") || default_val.equals("D")){
		
%>
		<select name="date_val<%=i%>" id="date_val<%=i%>" ><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>	
		 <%if(default_val.equals("E")){%><option value='current_date_time' <%=eHISFormatter.select(date_value,"current_date_time")%>><fmt:message key="Common.CurrentDateTime.label" bundle="${common_labels}"/><%}else{%><option value='current_date' <%=eHISFormatter.select(date_value,"current_date")%>><fmt:message key="Common.CurrentDate.label" bundle="${common_labels}"/><%}%></option></select>
<%	}
%></label>
	<select name="operator_value<%=i%>" id="operator_value<%=i%>" onChange='chkforOperator(this,<%=i%>)' >
		<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>	
		<option value='E' <%=eHISFormatter.select(operator_value,"E")%>><fmt:message key="eOR.EqualsTo.label" bundle="${or_labels}"/>  </option>
		<option value='L' <%=eHISFormatter.select(operator_value,"L")%>> <fmt:message key="Common.LessThan.label" bundle="${common_labels}"/> </option>	
		<option value='G' <%=eHISFormatter.select(operator_value,"G")%>><fmt:message key="eOR.GreaterThan.label" bundle="${or_labels}"/>  </option>
<%	if(default_val.equals("N")|| default_val.equals("I"))
%>		<option value='B' <%=eHISFormatter.select(operator_value,"B")%>> <fmt:message key="Common.Between.label" bundle="${common_labels}"/> </option>
	</select>
	</td>
	
<%}%>
		
	<td class='<%=classValue%>' width='' align='center' id='values<%=i%>'>
<%	if(default_val.equals("N") || default_val.equals("I")){
		if(default_val.equals("I")){
			chk_func = "return allowPositiveNumber()";
		}else
			chk_func = "return OrAllowDecimalNumber()";
		
%>
	<input type=text name='list_val<%=i%>' id='list_val<%=i%>' size=5 maxlength=10 value='<%=list_operator_value%>' onkeypress='<%=chk_func%>' >
	<input type=text name='between_val<%=i%>' id='between_val<%=i%>' size=5 maxlength=10 value='<%=between_value%>' onBlur='chkBtwn(this,<%=i%>)' style='display:none' onkeypress='<%=chk_func%>' > 
	<label class='label' id='btw<%=i%>'></label>	
<%	}else if(default_val.equals("L") || default_val.equals("R")){
		record = (String[])OrderTypeData.get(i);%>
		<div class='label'><b><%=record[0]%></b></div>
<%	record = null;}%>
	</td> 	
	<td class='<%=classValue%>' width='' align='center' >
		<select name="action<%=i%>" id="action<%=i%>" onChange='chkMandatory(this,"<%=i%>")' >
			<option value='W' <%=eHISFormatter.select(action_value,"W")%>><fmt:message key="Common.Warning.label" bundle="${common_labels}"/></option>
			<option value='S' <%=eHISFormatter.select(action_value,"S")%>><fmt:message key="Common.Stop.label" bundle="${common_labels}"/>   </option>
			<option value='N' <%=eHISFormatter.select(action_value,"N")%>><fmt:message key="Common.none.label" bundle="${common_labels}"/>  </option>
		</select>
	</td>	
	<td class='<%=classValue%>' width='' align='center' nowrap>
	<input type="text" name="message<%=i%>" id="message<%=i%>" maxlength='255' size='25' onpaste='return false' value='<%=message_value%>' onKeyPress='return checkSpecialChar1(event);' <%=eHISFormatter.chkReturn("y",message_text,"","disabled")%>>
	<img name='mandatory<%=i%>' style="visibility:visible" src="../../eCommon/images/mandatory.gif">
	</td><!--IN050630-->
	<td class='<%=classValue%>' width='' align='center'>
	<input type="checkbox" name="notify_chk<%=i%>" id="notify_chk<%=i%>" value='' <%=eHISFormatter.ChkBoxChecked("Y",notify)%>>
	
	</td>
	<td class='<%=classValue%>' width='' align='center' nowrap><input type=button class='button' name='oth_mnemonic<%=i%>' id='oth_mnemonic<%=i%>'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OtherMnemonic.label","or_labels")%>' OnClick='listDetails1("<%=i%>")' <%=eHISFormatter.chkReturn("y",other_mnemonic,"","disabled")%>>
<%	if(default_val.equals("N") || default_val.equals("E")|| default_val.equals("I")|| default_val.equals("D")){
%>
		<input type=button class='button' name='next_row<%=i%>' id='next_row<%=i%>' value='V' style='visibility:visible' OnClick='insertNextrow(<%=i%>)' >
		<input type=button class='button' name='del_row<%=i%>' id='del_row<%=i%>' value='-' style='visibility:visible' OnClick='deleteRow(<%=i%>)' >
<%	}%>
		
	</td>
</tr>
	<input type=hidden name='depend_finalString<%=i%>' id='depend_finalString<%=i%>' value="<%=depend_finalString%>">		
<%}	
%>
<tr>
<%	if(default_val.equals("N") || default_val.equals("E")|| default_val.equals("I")|| default_val.equals("D")){
%>		<td colspan='6' align='right'>
<%	}else{
%>		<td colspan='5' align='right'>
<%	}%>
	<input type=button class="button" name="ok" id="ok" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick="chkforValues()">
	<input type=button class="button" name="close" id="close" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick='clkCancel()'></td>
</tr>
</table>

<input type=hidden name='order_type' id='order_type' value="<%=order_type%>">
<input type=hidden name='order_catalog' id='order_catalog' value="<%=order_catalog%>">
<input type=hidden name='level' id='level' value="<%=level%>">
<input type=hidden name='seq_no' id='seq_no' value="<%=seq_no%>">
<input type=hidden name='finalString' id='finalString' value="<%=finalString%>">
<input type=hidden name='row_count' id='row_count' value=<%=j%>>
<input type=hidden name='finalvalue' id='finalvalue' value="<%=finalValue%>">
<input type=hidden name='depend_finalString' id='depend_finalString' value="">
<%
if(OrderTypeData !=null)
	OrderTypeData.clear();
putObjectInBean(bean_id,beanObj,request);
}catch(Exception e){
	e.printStackTrace();
}
%>
</form>
</body>
</html>

