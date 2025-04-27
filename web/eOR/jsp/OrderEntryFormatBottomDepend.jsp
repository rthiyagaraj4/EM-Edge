<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
-----------------------------------------------------------------------
Date       Edit History      Name        		Description
-----------------------------------------------------------------------
?             100            ?           		created
24/07/2013    IN038529      Chowminya G     Field Mnemonic restriction in format item based on the level value
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
02/07/2014	IN049133		Chowminya									CRF:Disallow user to enter the future date in the LMP date field
-----------------------------------------------------------------------
-->
<%@page import="java.util.*,eOR.*,eCommon.XSSRequestWrapper " contentType="text/html; charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

    
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
 	<script language="JavaScript" src="../js/OrderEntryFormats.js"></script>
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>


<SCRIPT LANGUAGE="JavaScript">


var i=0;
var dontChk="";

function closeWindow(){
	//var level			= document.list_dtl.level.value;
	var level			= document.getElementById("list_dtl").level.value;
	//var topPageForm = parent.list_top.document.forms[0];
	var topPageForm = parent.document.getElementById("list_top");
	var finalString = "";
	if (topPageForm) {
		topPageForm.seq_arr = new Array(); // Make sure to assign the array properly
	}

		if(Array.isArray(topPageForm.seq_arr.length>0) && Array.isArray(topPageForm.seq_arr.length<=5)){
		for(count=0; count<parent.list_top.seq_arr.length; count++){
		/*	if( (level == "L") && (topPageForm.defFlag.value  == '1')){
				if((parent.list_top.seq_arr[count] == "1")||(parent.list_top.seq_arr[count] == "2")||(parent.list_top.seq_arr[count] == "3")){
					parent.list_top.agegroup_arr[count] = " ";
					parent.list_top.object_type_arr[count] = "";
					parent.list_top.value_arr1[count] = "";
					parent.list_top.value_arr2[count] = "";
				}
			}*/
			if(parent.list_top.deflt_value_arr[count] == "")
				parent.list_top.deflt_value_arr[count] = " ";
			if(parent.list_top.agegroup_arr[count] == "")
				parent.list_top.agegroup_arr[count] = " ";
			finalString += parent.list_top.seq_arr[count]+"$"+parent.list_top.mnemonic_arr[count]+"$"+parent.list_top.label_text_arr[count]+"$"+parent.list_top.accept_option_arr[count]+"$"+parent.list_top.deflt_value_arr[count]+"$"+parent.list_top.agegroup_arr[count]+"$"+parent.list_top.object_type_arr[count]+"$"+parent.list_top.value_arr1[count]+"$"+parent.list_top.value_arr2[count]+"$"+parent.list_top.dependency_arr[count]+"!!"

		}
	}
	document.list_dtl.finalString.value = finalString;
	//window.returnValue = document.list_dtl.finalString.value
	//window.close();
	top.document.querySelectorAll("#dialog-body")[top.document.querySelectorAll("#dialog-body").length -1 ].contentWindow.returnValue = document.list_dtl.finalString.value;
	top.document.querySelectorAll("#dialog_tag")[top.document.querySelectorAll("#dialog_tag").length -1].close();
}




function removeValues(){

var age_group_sd= document.list_dtl.age_group_sd.value;
var age_group_cd= document.list_dtl.age_group_cd.value
var tmp_seq_arr				= new Array();
var tmp_mnemonic_arr		= new Array();
var tmp_agegroup_arr		= new Array();
var tmp_lbl_txt_arr			= new Array();
var tmp_accept_option_arr	= new Array();
var tmp_dflt_val_arr		= new Array();
var tmp_dependency_arr		= new Array();//IN049133

var count = 0;
	
	if(document.list_dtl.seq_no.value == "" ){
		alert(getMessage('SELECT_TO_CLEAR','OR'))
		return false;
	}
	
//	document.list_dtl.agegroup.value="select"
	dontChk = document.list_dtl.dontChk.value ;
	for(i=0; i<parent.list_top.seq_arr.length; i++){
		if( (dontChk == "") || (i != dontChk)){
			tmp_seq_arr[count] =  parent.list_top.seq_arr[i];
			tmp_mnemonic_arr[count] =  parent.list_top.mnemonic_arr[i];
			tmp_lbl_txt_arr[count] =  parent.list_top.label_text_arr[i];
			tmp_accept_option_arr[count] =  parent.list_top.accept_option_arr[i];
			tmp_agegroup_arr[count] =  parent.list_top.agegroup_arr[i];
			tmp_dflt_val_arr[count] =  parent.list_top.deflt_value_arr[i];
			tmp_dependency_arr[count] =  parent.list_top.dependency_arr[i];//IN049133
			count++;
		}

	}
	parent.list_top.seq_arr				= tmp_seq_arr;
	parent.list_top.mnemonic_arr		= tmp_mnemonic_arr;
	parent.list_top.label_text_arr		= tmp_lbl_txt_arr;
	parent.list_top.accept_option_arr	= tmp_accept_option_arr;
	parent.list_top.deflt_value_arr		= tmp_dflt_val_arr;
	if(tmp_agegroup_arr == ""){tmp_agegroup_arr= "";}
	parent.list_top.agegroup_arr		= tmp_agegroup_arr;
	parent.list_top.dependency_arr		= tmp_dependency_arr;//IN049133
	var finalString = "";
	if(parent.list_top.seq_arr.length>0){
		for(count=0; count<parent.list_top.seq_arr.length; count++){
			finalString += parent.list_top.seq_arr[count]+"$"+parent.list_top.mnemonic_arr[count]+"$"+parent.list_top.label_text_arr[count]+"$"+parent.list_top.accept_option_arr[count]+"$"+parent.list_top.deflt_value_arr[count]+"$"+parent.list_top.agegroup_arr[count]+"$"+parent.list_top.mnemonic_arr[count]+"$"+parent.list_top.dependency_arr[count]+"!!"
			//+"*"+parent.list_top.position_arr[count]+"^"
		}
	}
	
	document.list_dtl.finalString.value = finalString;
	document.list_dtl.mode.value = "insert";
	document.list_dtl.action  = "OrderEntryFormatTopDepend.jsp";
	document.list_dtl.target = "list_top";
	//document.list_dtl.submit(); -----------err


	/***This is in case where Order Category is Laboratroy******/
	var topPageForm1 = parent.list_top.document.forms[0];
	var ord_cat= "";
	if(topPageForm1.defFlag.value  == '1'){//in case of Lab in create mode
			ord_cat = "LB" ;
	}

    //j var test = setFinalString(finalString)
 	//if(test == finalString) {
 	//	alert("done");
 	//}
	if(ord_cat == "")
		ord_cat = document.list_dtl.ord_cat.value;
	parent.list_top.document.location.href="../jsp/OrderEntryFormatTopDepend.jsp?finalString="+escape(finalString)+"&ord_cat="+ord_cat+"&age_group_sd="+age_group_sd+"&age_group_cd="+age_group_cd;


	document.list_dtl.seq_no.value = "";
	document.list_dtl.mnemonic.value = "";
	document.list_dtl.lbl_txt.value = "";
	document.list_dtl.accept_option.selectedIndex = 0;
	if(	document.list_dtl.dflt_val)
		document.list_dtl.dflt_val.value = "";
	if(document.list_dtl.agegroup)
		document.list_dtl.agegroup.value = "";
	if(document.getElementById("deflt_value1"))
		document.getElementById("deflt_value1").innerHTML = "";
	if(document.getElementById("deflt_value2"))
		document.getElementById("deflt_value2").innerHTML = "";
	if(document.getElementById("depend1"))
		document.getElementById("depend1").innerHTML = "";
	if(document.getElementById("depend2"))
		document.getElementById("depend2").innerHTML = "";
	if(document.list_dtl.dontChk)
		document.list_dtl.dontChk.value = "";
}

function chkMandatory(){
	var count=0;
	var finalString = "";
	var seq_num= document.list_dtl.seq_no.value;
	var parentindex = document.list_dtl.parentindex.value ;
	var dontChkLabel = document.list_dtl.dontChk.value ;
	var indexLabel= document.list_dtl.index.value;
	var mnemonic = document.list_dtl.mnemonic.value;
	var position = document.list_dtl.mnemonic.selectedIndex;
	var indexVal = document.list_dtl.mnemonic.selectedIndex
	var agegroup = document.list_dtl.agegroup.value;
	var age_group_sd= document.list_dtl.age_group_sd.value;
	var age_group_cd= document.list_dtl.age_group_cd.value;
	var isSpace = 0;

	var ord_cat = "";


	for(i=0; i<mnemonic.length; i++){
		if(mnemonic.charAt(i) != " "){
			isSpace = 1
			break;
		}
	}

if(document.list_dtl.seq_no.value == ""){
		alert(getMessage('SEQ_NO_NOT_BLANK','OR'))
		document.list_dtl.seq_no.focus();
		return false;
	}else if(isNaN(document.list_dtl.seq_no.value) == true){
		alert(getMessage('ONLY_NUMBERS','OR'))
		document.list_dtl.seq_no.value="";
		document.list_dtl.seq_no.focus();
		return false;
	}else if(document.list_dtl.seq_num == 0){
		alert(getMessage('SEQ_NO_NOT_ZERO','OR'))
		document.list_dtl.seq_no.focus();
		return false;
	}else if(document.list_dtl.mnemonic.value == ""){
		//alert('Mnemonic can not be Blank...')
		alert(getMessage('FIELD_MNEMONIC_CANNOT_BE_EMPTY','OR'))
		document.list_dtl.mnemonic.focus();
		return false;
	}else if(document.list_dtl.lbl_txt.value == ""){
		//alert('Label Text can not be Blank...')
		alert(getMessage('LABEL_TEXT_CANNOT_BE_BLANK','OR'))
		document.list_dtl.lbl_txt.focus();
		return false;
	}else if(((seq_num.charAt(0) == "0") && (seq_num.length == "1")) || ((seq_num.charAt(0) == "0") && (seq_num.charAt(1) == "0") &&  (seq_num.length == "2"))){
		alert(getMessage('SEQ_NO_NOT_ZERO','OR'))
		return false
	}else if(seq_num.substring(0,1) == '0'){
		document.list_dtl.seq_no.value = seq_num.substring(1,seq_num.length);
	}
	var mnemonic_type = (eval("document.list_dtl.hdn_fld_type"+indexVal).value)
	
	var tmp_seq_no			= document.list_dtl.seq_no.value;
	var tmp_agegroup		=document.list_dtl.agegroup.value;
	var tmp_mnemonic		= document.list_dtl.mnemonic.value;
	var tmp_lbl_txt			= document.list_dtl.lbl_txt.value;
		
	var tmp_accept_option	= document.list_dtl.accept_option.value;
	//IN049133 - Start
	var tmp_depend_yn = "N";
	if(document.list_dtl.chk_depnd)
	{
		tmp_depend_yn		= document.list_dtl.chk_depnd.checked;
		
		if(tmp_depend_yn)
			tmp_depend_yn = "Y";
		else
			tmp_depend_yn = "N";		
	}	
	//IN049133 - End
	/*for (var repl=0;repl < tmp_lbl_txt.length;repl++) {
		if (tmp_lbl_txt.indexOf("&") != -1) {
			tmp_lbl_txt = tmp_lbl_txt.replace("&","�");
		}
		if (tmp_lbl_txt.indexOf("%") != -1) {
			tmp_lbl_txt = tmp_lbl_txt.replace("%","!!");
		}
		if (tmp_lbl_txt.indexOf("!!") != -1) {
			tmp_lbl_txt = tmp_lbl_txt.replace("!!","�");
		}
		if (tmp_lbl_txt.indexOf("+") != -1) {
			tmp_lbl_txt = tmp_lbl_txt.replace("+","�");
		}
		if (tmp_lbl_txt.indexOf("\\") != -1) {
			tmp_lbl_txt = tmp_lbl_txt.replace("\\","�");
		}
	}*/
	//alert(tmp_lbl_txt);
	var tmp_dflt_val;
	if(document.list_dtl.dflt_val.type   == "checkbox"){
		if(document.list_dtl.dflt_val.checked)
			tmp_dflt_val = 'Y'
		else
			tmp_dflt_val  = 'N';
	}else{ 
		tmp_dflt_val		= document.list_dtl.dflt_val.value;
	}
	

	var tmp_mnemonic_type	= mnemonic_type
	var tmp_position1		= eval("document.list_dtl.hdn_minVal"+position).value
	var tmp_position2		= eval("document.list_dtl.hdn_maxVal"+position).value


	var val_length = tmp_dflt_val.length;
	if(tmp_mnemonic_type == "N"){
		if((isValidDecimal(tmp_dflt_val))){

			if(tmp_dflt_val.indexOf(".") != -1){
				int_part = tmp_dflt_val.split(".")
				decimal_val = int_part[1]
				decimal_pos = int_part.length +1
				//alert('ASK:TEMP_DTLT_VAL'+tmp_dflt_val+'ASK:DECIMAL_POS:'+decimal_pos+'ASK:DECIMAL_PART:'+decimal_val+'ASK:DECIMAL_VAL_LENG:'+decimal_val.length)
				//if((val_length - decimal_pos) > 3){
				if(decimal_val.length > 3) {
					alert(getMessage('MAX_NO_DECIMAL','OR'))
					//alert('Cannot have more than 3 decimal numbers')
					return false
				}
			}

			if(tmp_position1 != "" && tmp_position2 != ""){
				if((checkDecimalRange(tmp_dflt_val,tmp_position1,tmp_position2)) == false){
					//alert("Invalid Decimal Range...")
					alert(getMessage('INVALID_DECIMAL_RANGE','OR'))  ;
					document.list_dtl.dflt_val.select()
					return false
				}
			}
		}else{
			return false
		}
	}

	if(tmp_mnemonic_type == "I"){
		if(tmp_position1 != "" && tmp_position2 != ""){
			if((checkIntegerRange(tmp_dflt_val,tmp_position1,tmp_position2)) == false){
				//alert("Invalid Integer Range...")
				alert(getMessage('INVALID_INTEGER_RANGE','OR'))  ;
				return false
			}
		}
	}

	if(tmp_position1 == null)tmp_position1 = " ";
	if(tmp_position2 == null)tmp_position2 = " ";

	dontChk = document.list_dtl.dontChk.value ;



	if(tmp_mnemonic == "")		tmp_mnemonic = " ";
	if(tmp_lbl_txt == "")		tmp_lbl_txt = " ";
	if(tmp_accept_option == "")	tmp_accept_option = " ";
	if(tmp_dflt_val == "")		tmp_dflt_val = " ";
	if(tmp_agegroup == "")		tmp_agegroup = " ";



	/*******CHK FOR SINGLE MULTIPLE *******************/
	if(parent.list_top.mnemonic_arr.length>0){
		var single_multiple =  eval("document.getElementById('single_multiple'"+position+").value");
		for(count=0; count<parent.list_top.mnemonic_arr.length; count++){
			count = parseInt(count);
			dontChk = parseInt(dontChk)
		 	if(count != dontChk){
				if(single_multiple == 'S'){
					if(parent.list_top.mnemonic_arr[count] == mnemonic){
						alert(getMessage('SINGLE_RECORD_CHK','OR'))  ;
						return false;
					}
				}
			}
		}
	}
	/********/

	/****CHK FOR DUPLICATE*******/
	
	var topPageForm = parent.list_top.document.forms[0];
	level			= document.list_dtl.level.value
	/*if(level == "L"){
		if(topPageForm.defFlag.value  == '1' ){//in case of Order Category is Lab
			/*if(tmp_seq_no == 2  ) {  //tmp_seq_no == 1 ||
				alert(getOrMessage('DUP_SEQ_NUM')) ;
				document.list_dtl.seq_no.value= "";
				document.list_dtl.seq_no.focus();
				return false;
			}//seq no duolicated for  Order Category is Lab
		}
	}*/

	if(parent.list_top.seq_arr.length>0){
		for(count=0; count<parent.list_top.seq_arr.length; count++){

			count = parseInt(count);
			dontChk = parseInt(dontChk)
				
			if(count != dontChk){
				if(parent.list_top.seq_arr[count] == tmp_seq_no){
					alert(getMessage('DUP_SEQ_NUM','OR'))
				//	alert(getOrMessage('COL_NO_CANNOT_REPEATED_SAME_ROW'))
					document.list_dtl.seq_no.value= "";
					document.list_dtl.seq_no.focus();
					return false;
				}
			}
		}
	}
	/*******CHK FOR DUP ENDS*********/

	if(document.list_dtl.mode.value == 'update'){
		var ref_val = parseInt(dontChk)
		for(count=0; count<parent.list_top.seq_arr.length; count++){
			//alert(desc_arr[count]);
//			alert(document.list_dtl.old_desc.value);
			/*alert(count);
			for (var repl=0;repl < parent.list_top.label_text_arr[count].length;repl++) {
				if (parent.list_top.label_text_arr[count].indexOf("&") != -1) {
					parent.list_top.label_text_arr[count] = parent.list_top.label_text_arr[count].replace("&","�");
				}
				if (parent.list_top.label_text_arr[count].indexOf("%") != -1) {
					parent.list_top.label_text_arr[count] = parent.list_top.label_text_arr[count].replace("%","!!");
				}
				if (parent.list_top.label_text_arr[count].indexOf("!!") != -1) {
					parent.list_top.label_text_arr[count] = parent.list_top.label_text_arr[count].replace("!!","�");
				}
				if (parent.list_top.label_text_arr[count].indexOf("+") != -1) {
					parent.list_top.label_text_arr[count] = parent.list_top.label_text_arr[count].replace("+","�");
				}
				if (parent.list_top.label_text_arr[count].indexOf("\\") != -1) {
					parent.list_top.label_text_arr[count] = parent.list_top.label_text_arr[count].replace("\\","�");
				}
			}*/
			if(tmp_position1 == "") tmp_position1 = " ";
			if(tmp_position2 == "") tmp_position2 = " ";
			if(parent.list_top.seq_arr[count] == document.list_dtl.old_seq_no.value){
				parent.list_top.seq_arr[count]				= tmp_seq_no;
				parent.list_top.mnemonic_arr[count]			= tmp_mnemonic;
				if((tmp_lbl_txt!=undefined) ||(tmp_lbl_txt!=null))
				{
					setFormatValues("labeltext_"+parentindex+"Othernemonic_"+indexLabel+"array"+dontChkLabel,tmp_lbl_txt);
				}
				parent.list_top.label_text_arr[count]		= "labeltext_"+parentindex+"Othernemonic_"+indexLabel+"array"+dontChkLabel;
				parent.list_top.accept_option_arr[ref_val]	= tmp_accept_option;
				parent.list_top.value_arr1[count]			= tmp_position1;
				parent.list_top.value_arr2[count]			= tmp_position2;
				parent.list_top.object_type_arr[count]		= tmp_mnemonic_type
				if((tmp_dflt_val!=undefined) ||(tmp_dflt_val!=null))
				{
					//setFormatValues("dfltValue_"+dontChkLabel+"Othernemonic_array"+indexLabel,tmp_dflt_val);
					setFormatValues("dfltValue_"+parentindex+"Othernemonic_"+indexLabel+"array"+dontChkLabel,tmp_dflt_val);

				}
				parent.list_top.deflt_value_arr[count]		= "dfltValue_"+parentindex+"Othernemonic_"+indexLabel+"array"+dontChkLabel;
				parent.list_top.agegroup_arr[count]			=tmp_agegroup;
				parent.list_top.dependency_arr[count]		=document.list_dtl.finalValue.value;
			}
		
			/***This is in case where Order Category is Laboratroy******/
			var topPageForm1 = parent.list_top.document.forms[0];
			if(topPageForm1.defFlag.value  == '1'){//in case of Lab in create mode
			ord_cat = "LB" ;
			}



//			if(parent.list_top.deflt_value_arr[count] == document.list_dtl.old_dflt_val.value){
//				alert('here >'+tmp_dflt_val+'<')
				//parent.list_top.deflt_value_arr[ref_val] = "dfltValue_"+dontChkLabel+"Othernemonic_array"+indexLabel;
//			}
		}
	}else {
		var level	  = document.list_dtl.level.value;
		var arrLength = parent.list_top.seq_arr.length
		if(parseInt(arrLength) !=0){
				i = parseInt(arrLength);
		}/*else if(level == 'L'){
				i=0;

			if(topPageForm.defFlag.value  == '1'){//in case of Lab in create mode

				parent.list_top.seq_arr[i]			= "1";
			//	parent.list_top.cseq_arr[i]			= "1";
				parent.list_top.mnemonic_arr[i]		= "SPECIMEN_TYPE";
				parent.list_top.label_text_arr[i]	= "Specimen Type";
				parent.list_top.accept_option_arr[i]= "O";
				parent.list_top.deflt_value_arr[i]	= " ";
				parent.list_top.agegroup_arr[i]	= " ";
				parent.list_top.object_type_arr[i]	= "";
				parent.list_top.value_arr1[i]		= "";
				parent.list_top.value_arr2[i]		= "";
				i++;


				parent.list_top.seq_arr[i]			= "2";
			//	parent.list_top.cseq_arr[i]			= "1";
				parent.list_top.mnemonic_arr[i]		= "NURSE_COLLECT_YN";
				parent.list_top.label_text_arr[i]	= "Nurse Collect";
				parent.list_top.accept_option_arr[i]= "O";
				parent.list_top.deflt_value_arr[i]	= " ";
				parent.list_top.agegroup_arr[i]	= " ";
				parent.list_top.object_type_arr[i]	= "";
				parent.list_top.value_arr1[i]		= "";
				parent.list_top.value_arr2[i]		= "";
				i++;

                parent.list_top.seq_arr[i]			= "3";
			//	parent.list_top.cseq_arr[i]			= "1";
				parent.list_top.mnemonic_arr[i]		= "COLLECTION_STAGE";
				parent.list_top.label_text_arr[i]	= "Collection Stage";
				parent.list_top.accept_option_arr[i]= "O";
				parent.list_top.deflt_value_arr[i]	= "Separate";
				parent.list_top.agegroup_arr[i]	= " ";
				parent.list_top.object_type_arr[i]	= "";
				parent.list_top.value_arr1[i]		= "";
				parent.list_top.value_arr2[i]		= "";
				i++;

				ord_cat = "LB" ;
			 }	 //if lab in create mode
		}*/

//				var topPageForm1 = parent.list_top.document.forms[0];

			if(topPageForm.defFlag.value  == '1'){//in case of Lab in create mode
			ord_cat = "LB" ;
			}
			
			if(tmp_position1 == "") tmp_position1 = " ";
			if(tmp_position2 == "") tmp_position2 = " ";

			parent.list_top.seq_arr[i]			= tmp_seq_no;
			parent.list_top.mnemonic_arr[i]		= tmp_mnemonic;
			if(tmp_depend_yn == "Y"){
				parent.list_top.dependency_arr[i]	= document.list_dtl.finalValue.value;//IN049133
			}	
			else
				parent.list_top.dependency_arr[i]	= tmp_depend_yn;//IN049133
			if((tmp_lbl_txt!=undefined) ||(tmp_lbl_txt!=null))
			{
				setFormatValues("labeltext_"+parentindex+"Othernemonic_"+indexLabel+"array"+i,tmp_lbl_txt);				
			}
			parent.list_top.label_text_arr[i]	= "labeltext_"+parentindex+"Othernemonic_"+indexLabel+"array"+i;
			parent.list_top.accept_option_arr[i]= tmp_accept_option;
			if((tmp_dflt_val!=undefined) ||(tmp_dflt_val!=null))
			{
				setFormatValues("dfltValue_"+parentindex+"Othernemonic_"+indexLabel+"array"+i,tmp_dflt_val);				
			}
			parent.list_top.deflt_value_arr[i]	= "dfltValue_"+parentindex+"Othernemonic_"+indexLabel+"array"+i;
			parent.list_top.agegroup_arr[i]			= tmp_agegroup;
			parent.list_top.object_type_arr[i]	= tmp_mnemonic_type
			parent.list_top.value_arr1[i]		= tmp_position1;
			parent.list_top.value_arr2[i]		= tmp_position2;

	}	//insert mode
	
	if(parent.list_top.seq_arr.length>0){
		/*for (var repl=0;repl < parent.list_top.label_text_arr[count].length;repl++) {
			if (parent.list_top.label_text_arr[count].indexOf("&") != -1) {
				parent.list_top.label_text_arr[count] = parent.list_top.label_text_arr[count].replace("&","�");
			}
			if (parent.list_top.label_text_arr[count].indexOf("%") != -1) {
				parent.list_top.label_text_arr[count] = parent.list_top.label_text_arr[count].replace("%","!!");
			}
			if (parent.list_top.label_text_arr[count].indexOf("!!") != -1) {
				parent.list_top.label_text_arr[count] = parent.list_top.label_text_arr[count].replace("!!","�");
			}
			if (parent.list_top.label_text_arr[count].indexOf("+") != -1) {
				parent.list_top.label_text_arr[count] = parent.list_top.label_text_arr[count].replace("+","�");
			}
			if (parent.list_top.label_text_arr[count].indexOf("\\") != -1) {
				parent.list_top.label_text_arr[count] = parent.list_top.label_text_arr[count].replace("\\","�");
			}
		}*/
		
		for(count=0; count<parent.list_top.seq_arr.length; count++){
			
			finalString += parent.list_top.seq_arr[count]+"$"+parent.list_top.mnemonic_arr[count]+"$"+parent.list_top.label_text_arr[count]+"$"+parent.list_top.accept_option_arr[count]+"$"+parent.list_top.deflt_value_arr[count]+"$"+parent.list_top.agegroup_arr[count]+"$"+parent.list_top.object_type_arr[count]+"$"+parent.list_top.value_arr1[count]+"$"+parent.list_top.value_arr2[count]+"$"+parent.list_top.dependency_arr[count]+"!!";//IN049133 added dependency_arr
			//setFormatValues("dfltValueOthernemonic_array"+tmp_seq_no,tmp_dflt_val);
			

		}
		if(parent.list_top.seq_arr.length>5)
		{
			alert(getMessage('NO_MORE_MNEMONICS_SELECTED','OR'));
			document.list_dtl.seq_no.value = "";
			document.list_dtl.mnemonic.value = "";
			document.list_dtl.lbl_txt.value = "";
		//	document.list_dtl.accept_option.selectedIndex = 0;
			document.list_dtl.dflt_val.value = "";
			document.list_dtl.agegroup.value= "";
			document.getElementById("deflt_value1").innerHTML = ""
			document.getElementById("deflt_value2").innerHTML = ""
			document.list_dtl.chk_depnd.checked = false;//IN049133
			return false;
		}
	}
	//j var test = setFinalString(finalString)
	//alert("test:"+test);
 	//if(test == finalString) {
 	//	alert("done");
 	//}
	document.list_dtl.finalString.value = finalString;
	document.list_dtl.mode.value = "insert";
	document.list_dtl.action	 = "OrderEntryFormatTopDepend.jsp";
	document.list_dtl.target	 = "list_top";
//	document.list_dtl.submit();	 ---cannot get the err....

	//Add line
//	alert("AGE Short DEsc:"+age_group_sd);
//alert("in bottom depend jsp,finalString="+finalString);
//parent.list_top.document.location.href="../jsp/OrderEntryFormatTopDepend.jsp?finalString="+escape(finalString)+"&ord_cat="+ord_cat+"&age_group_sd="+age_group_sd+"&age_group_cd="+age_group_cd;

	if(ord_cat == "")
		ord_cat = document.list_dtl.ord_cat.value;

	parent.list_top.document.location.href="../jsp/OrderEntryFormatTopDepend.jsp?finalString="+finalString+"&ord_cat="+ord_cat+"&age_group_sd="+age_group_sd+"&age_group_cd="+age_group_cd;
	//parent.list_top.document.location.href="../jsp/OrderEntryFormatTop.jsp?ord_cat="+ord_cat;

	document.list_dtl.seq_no.value = "";
	document.list_dtl.mnemonic.value = "";
	document.list_dtl.lbl_txt.value = "";
	document.list_dtl.accept_option.selectedIndex = 0;
	document.list_dtl.dflt_val.value = "";
	document.list_dtl.agegroup.value= "";
	document.list_dtl.dontChk.value = "";
	document.getElementById("deflt_value1").innerHTML = ""
	document.getElementById("deflt_value2").innerHTML = ""
	document.getElementById("depend1").innerHTML = ""
	document.getElementById("depend2").innerHTML = ""

	parent.list_bottom.list_dtl.clear.disabled = false;
	parent.list_bottom.list_dtl.seq_no.disabled = false;
	parent.list_bottom.list_dtl.mnemonic.disabled = false;
	parent.list_bottom.list_dtl.accept_option.disabled = false;
}



function takeValues(){
	var level			= document.list_dtl.level.value;
	//var tempfinalString="";
//	var ord_cat			= document.ord_cat.level.value;
	var topPageForm = parent.list_top.document.forms[0];
	var finalString = "";
	if(parent.list_top.seq_arr.length>0 && parent.list_top.seq_arr.length<=5){
		for(count=0; count<parent.list_top.seq_arr.length; count++){		
			/*if( (level == "L") && (topPageForm.defFlag.value  == '1')){
				if((parent.list_top.seq_arr[count] == "1")||(parent.list_top.seq_arr[count] == "2")||(parent.list_top.seq_arr[count] == "3")){
					parent.list_top.agegroup_arr[count] = " ";
					parent.list_top.object_type_arr[count] = "";
					parent.list_top.value_arr1[count] = "";
					parent.list_top.value_arr2[count] = "";
				}
			}*/
			if(parent.list_top.deflt_value_arr[count] == "")
				parent.list_top.deflt_value_arr[count] = " ";
			if(parent.list_top.agegroup_arr[count] == "")
				parent.list_top.agegroup_arr[count] = " ";
				//IN049133 - Start
			if(parent.list_top.dependency_arr[count] == "" || parent.list_top.dependency_arr[count] == undefined )
				parent.list_top.dependency_arr[count] = " ";
			finalString += parent.list_top.seq_arr[count]+"$"+parent.list_top.mnemonic_arr[count]+"$"+parent.list_top.label_text_arr[count]+"$"+parent.list_top.accept_option_arr[count]+"$"+parent.list_top.deflt_value_arr[count]+"$"+parent.list_top.agegroup_arr[count]+"$"+parent.list_top.object_type_arr[count]+"$"+parent.list_top.value_arr1[count]+"$"+parent.list_top.value_arr2[count]+"$"+parent.list_top.dependency_arr[count]+"!!";
				//IN049133 - End
			//+"*"+parent.list_top.position_arr[count]
		}		
	}
		//var depend=finalString;
		//var depend1=finalString.split("^");
		//if(depend1[1].indexOf("$$")!=-1)
			//	{
			//var applystr=depend1[1].split("$$");
				//	depend1[1]=applystr[1];
				//}
				 //tempfinalString=depend1[0].concat("^").concat(depend1[1]).concat("^").concat(depend1[2]).concat("^").concat(depend1[3]).concat("^").concat(depend1[4]).concat("^").concat(depend1[5]).concat("^").concat(depend1[6]).concat("^").concat(depend1[7]).concat("^").concat(depend1[8]);
	document.list_dtl.finalString.value = finalString;	
	window.returnValue = document.list_dtl.finalString.value;
	window.close();
}



function checkIntegerRange(val,position1,position2){
	if(val == "" )
		return true ;

		val = parseInt(val)
		position1 = parseInt(position1)
		position2 = parseInt(position2)

		if(!((val >= position1) && (val <= position2))){
			return false
		}
	return true
}

// this is to check whether the decimal is a valid decimal - should validate number like 23.3.44
function isValidDecimal(val){
	if(isNaN(val)){
		alert(getMessage('INVALID_DECIMAL_NUMBER','OR'));
		//alert('Not a Valid Decimal Number');
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
		val = parseFloat(val)

		position1 = parseFloat(position1)
		position2 = parseFloat(position2)
		if(!((val >= position1) && (val <= position2))){
			return false
		}

	}else{
		val = parseFloat(val)
		position1 = parseFloat(position1)
		position2 = parseFloat(position2)

		if(!((val >= position1) && (val <= position2))){

			return false
		}
	}
	return true
}
</SCRIPT>

<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
</head>
<html>
<body onload='FocusFirstElement();' onunload="javascript:closeWindow()"  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">

<form name="list_dtl" id="list_dtl" >
<% 	
   request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	String ord_cat = request.getParameter("ord_cat")==null?"":request.getParameter("ord_cat");
	String level = request.getParameter("level")==null?"":request.getParameter("level");
	String index = request.getParameter("index")==null?"":request.getParameter("index");
	String parentindex = request.getParameter("parentindex")==null?"":request.getParameter("parentindex");
	String object_format_type = request.getParameter("object_format_type")==null?"":request.getParameter("object_format_type");
	String format_id = request.getParameter("format_id")==null?"":request.getParameter("format_id");
	String order_type =  request.getParameter("order_type")==null?"":request.getParameter("order_type");
	String order_catalog = request.getParameter("ord_catalog")==null?"":request.getParameter("ord_catalog");
	String finalString = request.getParameter("finalString");
	String mnemonic = request.getParameter("mnemonic");
    out.println("<input type=hidden name='depend_mnemonic' id='depend_mnemonic' value='"+mnemonic+"'>" );
	ArrayList Mnemonic_Data =  new ArrayList();
	ArrayList AgeGroup_Data =  new ArrayList();  
	String bean_id = "Or_OrderEntryFormats" ;
	String bean_name = "eOR.OrderEntryFormats";
	String install_yn = "N";
	OrderEntryFormats bean = (OrderEntryFormats)getBeanObject( bean_id,  bean_name, request ) ;
	if(ord_cat.equals("RD"))
		install_yn = bean.getInstallyn(ord_cat);

%>
<input type=hidden name='install_yn' id='install_yn' value="<%=install_yn%>">
<input type=hidden name='level' id='level' value="<%=level%>">

<table cellpadding=0 cellspacing=0 border=0 width="98%" align=center>

<tr><td colspan=2>&nbsp;</td></tr>

<tr><td width="40%" class="label" align="right"><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></td><td class="fields"><input type=text name="seq_no" id="seq_no" value="" size=2 maxlength=2 onKeyPress='return allowPositiveNumber()' onChange="populateListValues('<%=ord_cat%>','mnemonic','','seqTop')" onBlur="return checkPositiveNumber(this)">&nbsp;<img src="../../eCommon/images/mandatory.gif"></td></tr>

<!-- <tr><td width="40%" class="label" align="right"> Column Sequence No&nbsp;</td><td><input type=text name="cseq_no" id="cseq_no" value="" size=2 maxlength=1 onKeyPress="return limitNumber()" >&nbsp;<img src="../../eCommon/images/mandatory.gif"></td></tr>
 -->
<tr>
	<td width="40%" class="label" ><fmt:message key="eOR.FieldMnemonicDesc.label" bundle="${or_labels}"/></td>
	<td >
		<!--<SELECT name="mnemonic" id="mnemonic" onChange="populateValues2()" > -->
		<SELECT name="mnemonic" id="mnemonic" onChange="populateValues3()" > <!--IN049133-->
			<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
			<%try{
				Mnemonic_Data = bean.getMnemonic(ord_cat,level);//IN038529

				for(int i=0; i<Mnemonic_Data.size(); i++){
					String[] record = (String [])Mnemonic_Data.get(i);
				%>
				<!-- <option value='<%=record[6]%>$$<%=record[0]%>'><%=record[6]%></option> -->
				<option value='<%=record[0]%>'><%=record[6]%></option>
			<%}
			}catch(Exception e){
				e.printStackTrace();
			}
		%>
		</SELECT><img src="../../eCommon/images/mandatory.gif">
	</td>
</tr>

<%
		for(int i=0; i<Mnemonic_Data.size(); i++){
			String[] record = (String [])Mnemonic_Data.get(i);
			if(record[2] == null)record[2] = "";
			if(record[3] == null)record[3] = "";
			out.println("<input type=hidden name='hdn_fld_type"+(i+1)+"' id='hdn_fld_type"+(i+1)+"' value='"+record[1]+"'>" );
			out.println("<input type=hidden name='hdn_minVal"+(i+1)+"' id='hdn_minVal"+(i+1)+"' value='"+record[2]+"'>" );
			out.println("<input type=hidden name='hdn_maxVal"+(i+1)+"' id='hdn_maxVal"+(i+1)+"' value='"+record[3]+"'>" );
			out.println("<input type=hidden name='single_multiple"+(i+1)+"' id='single_multiple"+(i+1)+"' value='"+record[4]+"'>" );
			out.println("<input type=hidden name='presentation_type"+(i+1)+"' id='presentation_type"+(i+1)+"' value='"+record[5]+"'>" );
		}
%>
	<tr><td width="40%" class="label" ><fmt:message key="Common.labelText.label" bundle="${common_labels}"/></td><td><input type=text name="lbl_txt" id="lbl_txt" value="" size=50 maxlength=50  onKeyPress='checkSpecialChar(event);'  onBlur='return checkSpecialCharBlur(this)'><img src="../../eCommon/images/mandatory.gif"></td></tr>   <!--onKeyPress = 'return CheckForSpecCharsWithoutSpace(event)' -->
	<tr><td width="40%" class="label" ><fmt:message key="Common.AcceptOption.label" bundle="${common_labels}"/></td><td class="fields"><SELECT name="accept_option" id="accept_option" ><option value="O"><fmt:message key="Common.Optional.label" bundle="${common_labels}"/></option><option value="R"><fmt:message key="Common.required.label" bundle="${common_labels}"/></option><option value="D"><fmt:message key="Common.DisplayOnly.label" bundle="${common_labels}"/></option></SELECT></td></tr>
	<tr>
		<td  id='deflt_value1' class=label ></td>

		<td  id='deflt_value2' class="fields" ><!--   style="visibility:hidden"-->
			<!-- <select name="dflt_val" id="dflt_val"><option value=''>-----Select-----</select> -->
		</td>
	</tr>
	<tr><td width="40%" class="label" ><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/> </td>
	    <td class="fields">
		<SELECT name="agegroup" id="agegroup" >
		<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---  
		<%try{String res="";String res1="";
				AgeGroup_Data = bean.getAgeGroup();
				for(int i=0; i<AgeGroup_Data.size(); i++){
					String[] record = (String [])AgeGroup_Data.get(i);
			%>
				<option value='<%=record[1]%>'><%=record[0]%></option>
				<!-- <input type=hidden name="" id="" value='<%=record[1]%>'> -->
			             
				<% if(res.equals("") && res1.equals(""))
					 {
						res = record[0];
						res1 = record[1];
					 }
					 else
					 {
						res =res +":"+record[0];
						res1 =res1+":"+record[1];
					 }
				}
				 out.println("<input type=hidden name='age_group_sd' id='age_group_sd' value='"+res+"'>" );
				 out.println("<input type=hidden name='age_group_cd' id='age_group_cd' value='"+res1+"'>" );
			}catch(Exception e){
				e.printStackTrace();
			}
		%>
		</SELECT>
		</td>
	</tr>
	<!-- <tr><td colspan=2>&nbsp;</td></tr> -->
	<!-- IN049133 modified-->
	<!--<tr style='display:none'> -->
	<tr>
		<td  id='depend1' class=label ></td>

		<td  id='depend2' class="fields" >
		</td>
	</tr>
	
<tr>
	<td colspan=2 align=right>
	<input type=hidden name="finalString" id="finalString" value="">
	<input type=button class="button" name="select" id="select" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")%>" onClick="chkMandatory();">
	<input type=button class="button" name="ok" id="ok" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick="takeValues();">
	<input type=button  class="button" name="clear" id="clear" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>"  onClick="removeValues();">
	<input type=button class="button" name="close" id="close" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick="closeWindow();">
	</td>
</tr>
</table>
<input type=hidden name='ord_cat' id='ord_cat' value="<%=ord_cat%>">
<input type=hidden name='object_format_type' id='object_format_type' value="<%=object_format_type%>">
<input type=hidden name='order_type' id='order_type' value="<%=order_type%>">
<input type=hidden name='order_catalog' id='order_catalog' value="<%=order_catalog%>">
<input type=hidden name='level1' id='level1' value="<%=level%>">
<input type=hidden name='finalString' id='finalString' value="<%=finalString%>">
<input type=hidden name='finalValue' id='finalValue' value="">
<input type=hidden name='index' id='index' value="<%=index%>">
<input type=hidden name='format_id' id='format_id' value="<%=format_id%>">
<input type=hidden name='parentindex' id='parentindex' value="<%=parentindex%>">
<input type=hidden name='mode' id='mode' value="">
<input type=hidden name='old_mnemonic' id='old_mnemonic' value="">
<input type=hidden name='old_seq_no' id='old_seq_no' value="">
<input type=hidden name='old_lbl_txt' id='old_lbl_txt' value="">
<input type=hidden name='old_accept_opt' id='old_accept_opt' value="">
<input type=hidden name='old_dflt_val' id='old_dflt_val' value="">
<input type=hidden name='old_agegroup' id='old_agegroup' value="">
<input type=hidden name='old_order_type' id='old_order_type' value="">
<input type=hidden name='old_position' id='old_position' value="">
<input type=hidden name='old_dependency_yn' id='old_dependency_yn' value=""><!--IN049133-->
<input type=hidden name='dontChk' id='dontChk' value="">

</form>

</body>

</html>

<%

		putObjectInBean(bean_id,bean,request);
 
%>

