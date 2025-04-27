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
-----------------------------------------------------------------------
-->
<%@page import="java.util.*,eOR.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

    
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrderEntryFormats.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>


<SCRIPT LANGUAGE="JavaScript">


var i=0;
var dontChk="";

function closeWindow(){
	/*var level			= document.list_dtl.level.value;
	var topPageForm = parent.list_top.document.forms[0];
	var finalString = "";
	if(parent.list_top.seq_arr.length>0){
		for(count=0; count<parent.list_top.seq_arr.length; count++){
			if( (level == "L") && (topPageForm.defFlag.value  == '1')){
				if((parent.list_top.seq_arr[count] == "1")||(parent.list_top.seq_arr[count] == "2")||(parent.list_top.seq_arr[count] == "3")){
					parent.list_top.agegroup_arr[count] = " ";
					//parent.list_top.dependency_arr[i]	= " ";
					parent.list_top.object_type_arr[count] = " ";
					parent.list_top.value_arr1[count] = " ";
					parent.list_top.value_arr2[count] = " ";
				}
			}
			if(parent.list_top.deflt_value_arr[count] == "")
				parent.list_top.deflt_value_arr[count] = " ";
			if(parent.list_top.agegroup_arr[count] == "")
				parent.list_top.agegroup_arr[count] = " ";
			if(parent.list_top.dependency_arr[count] == "" ||parent.list_top.dependency_arr[count]=="N")
				parent.list_top.dependency_arr[count] = " ";
			if(parent.list_top.dependency_arr[count] == "Y")
			{						
			populateDependencyvalues(parent.list_top.seq_arr[count],parent.list_top.mnemonic_arr[count])
			parent.list_top.dependency_arr[count] = document.list_dtl.dependency_arr.value;
			
			}		
		
			finalString += parent.list_top.seq_arr[count]+"~"+parent.list_top.mnemonic_arr[count]+"~"+parent.list_top.label_text_arr[count]+"~"+parent.list_top.accept_option_arr[count]+"~"+parent.list_top.deflt_value_arr[count]+"~"+parent.list_top.agegroup_arr[count]+"~"+parent.list_top.dependency_arr[count]+"~"+parent.list_top.object_type_arr[count]+"~"+parent.list_top.value_arr1[count]+"~"+parent.list_top.value_arr2[count]+"~"+parent.list_top.occ_no_arr[count]+"`"
			// "~"+parent.list_top.dependency_arr[count]+
		}//setFinalString(finalString);
		//alert("close Values:::"+finalString);
	}
	document.list_dtl.finalString.value = finalString;	
	window.returnValue = document.list_dtl.finalString.value;*/
	//window.close();
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
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
var tmp_dependency_arr		= new Array();


var count = 0;
	
	if(document.list_dtl.seq_no.value == "" ){
		alert(getMessage('SELECT_TO_CLEAR','OR'))
		return false;
	}
	dontChk = document.list_dtl.dontChk.value ;
	for(i=0; i<parent.list_top.seq_arr.length; i++){
		if( (dontChk == "") || (i != dontChk)){
			tmp_seq_arr[count] =  parent.list_top.seq_arr[i];
			tmp_mnemonic_arr[count] =  parent.list_top.mnemonic_arr[i]
			tmp_lbl_txt_arr[count] =  parent.list_top.label_text_arr[i]
			tmp_accept_option_arr[count] =  parent.list_top.accept_option_arr[i]
			tmp_agegroup_arr[count] =  parent.list_top.agegroup_arr[i]
			tmp_dflt_val_arr[count] =  parent.list_top.deflt_value_arr[i]
			tmp_dependency_arr[count] = parent.list_top.dependency_arr[i]
			count++;
		}
		else
		{
			//finalString = parent.list_top.seq_arr[count]+"~"+parent.list_top.mnemonic_arr[count]+"~"+parent.list_top.label_text_arr[count]+"~"+parent.list_top.accept_option_arr[count]+"~"+parent.list_top.deflt_value_arr[count]+"~"+parent.list_top.agegroup_arr[count]+"~"+parent.list_top.dependency_arr[count]+"~"+parent.list_top.mnemonic_arr[count];
			setFinal_String(count,"","clear");//added by Ambiga
		}
	}
	parent.list_top.seq_arr				= tmp_seq_arr;
	parent.list_top.mnemonic_arr		= tmp_mnemonic_arr;
	parent.list_top.label_text_arr		= tmp_lbl_txt_arr;
	parent.list_top.accept_option_arr	= tmp_accept_option_arr;
	parent.list_top.deflt_value_arr		= tmp_dflt_val_arr;
	if(tmp_agegroup_arr == ""){tmp_agegroup_arr= "";}
	parent.list_top.agegroup_arr		= tmp_agegroup_arr;
	parent.list_top.dependency_arr		= tmp_dependency_arr;
	var finalString = "";	
	if(parent.list_top.seq_arr.length>0){
		for(count=0; count<parent.list_top.seq_arr.length; count++){
			//finalString += parent.list_top.seq_arr[count]+"~"+parent.list_top.mnemonic_arr[count]+"~"+parent.list_top.label_text_arr[count]+"~"+parent.list_top.accept_option_arr[count]+"~"+parent.list_top.deflt_value_arr[count]+"~"+parent.list_top.agegroup_arr[count]+"~"+parent.list_top.dependency_arr[count]+"~"+parent.list_top.mnemonic_arr[count]+"`"
			//+"~"+parent.list_top.position_arr[count]+"`"			
		}
	}
	

	document.list_dtl.finalString.value =finalString;//
	document.list_dtl.mode.value = "insert";
	document.list_dtl.action  = "OrderEntryFormatTop.jsp";
	document.list_dtl.target = "list_top";
	//document.list_dtl.submit(); -----------err


	/***This is in case where Order Category is Laboratroy******/
	var topPageForm1 = parent.list_top.document.forms[0];
	var ord_cat= "";
	if(topPageForm1.defFlag.value  == '1'){//in case of Lab in create mode
			ord_cat = "LB" ;
	}

    //--commented by Ambiga var test = setFinalString(finalString)
 	//if(test == finalString) {
 	//	alert("done");
 	//}
	if(ord_cat == "")
		ord_cat = document.list_dtl.ord_cat.value;
	//parent.list_top.document.location.href="../jsp/OrderEntryFormatTop.jsp?finalString="+finalString+"&ord_cat="+ord_cat+"&age_group_sd="+age_group_sd+"&age_group_cd="+age_group_cd;
	parent.list_top.document.location.href="../jsp/OrderEntryFormatTop.jsp?ord_cat="+ord_cat+"&age_group_sd="+age_group_sd+"&age_group_cd="+age_group_cd;


	document.list_dtl.seq_no.value = "";
	document.list_dtl.mnemonic.value = "";
	document.list_dtl.lbl_txt.value = "";
	document.list_dtl.accept_option.selectedIndex = 0;
	if(document.list_dtl.dflt_val)
		document.list_dtl.dflt_val.value = "";
	document.list_dtl.agegroup.value = "";
	document.list_dtl.finalValue.value = "";

	document.getElementById("deflt_value1").innerHTML = ""
	document.getElementById("deflt_value2").innerHTML = ""
	document.getElementById("depend1").innerHTML = ""
	document.getElementById("depend2").innerHTML = ""
	document.list_dtl.dontChk.value = "";

	parent.list_depend.location.href="../../eCommon/html/blank.html";
}

function chkMandatory(){
	
	var ord_cat = "";
	var count=0;
	var finalString = "";
	var seq_num= document.list_dtl.seq_no.value;
	var dontChkVal= document.list_dtl.dontChk.value;
	if(dontChkVal=="")
		dontChkVal="0";
	var mnemonic = document.list_dtl.mnemonic.value;
	var position = document.list_dtl.mnemonic.selectedIndex;
	var indexVal = document.list_dtl.mnemonic.selectedIndex
	var agegroup = document.list_dtl.agegroup.value;
	var age_group_sd= document.list_dtl.age_group_sd.value;
	var age_group_cd= document.list_dtl.age_group_cd.value;
	var dependency = document.list_dtl.finalValue.value;
	ord_cat = document.list_dtl.ord_cat.value;
	var request_comment_count=0;
	var level= document.list_dtl.level.value;

	var isSpace = 0;

	for(i=0; i<mnemonic.length; i++){
		if(mnemonic.charAt(i) != " "){
			isSpace = 1
			break;
		}
	}

if(document.list_dtl.seq_no.value == ""){
		alert(getMessage('SEQ_NO_NOT_BLANK','OR'))
		if(document.list_dtl.seq_no)
		{
			document.list_dtl.seq_no.focus();
			return false;
		}
	}else if(isNaN(document.list_dtl.seq_no.value) == true){
		alert(getMessage('ONLY_NUMBERS','OR'))
		document.list_dtl.seq_no.value="";
		if(document.list_dtl.seq_no)
		{
			document.list_dtl.seq_no.focus();
			return false;
		}		
	}else if(document.list_dtl.seq_num == 0){
		alert(getMessage('SEQ_NO_NOT_ZERO','OR'))
		if(document.list_dtl.seq_no)
		{
			document.list_dtl.seq_no.focus();
			return false;
		}
	}else if(document.list_dtl.mnemonic.value == ""){
		//alert('Mnemonic can not be Blank...')
		alert(getMessage('FIELD_MNEMONIC_CANNOT_BE_EMPTY','OR'))
		if(document.list_dtl.mnemonic)
		{
			document.list_dtl.mnemonic.focus();
			return false;
		}
	}else if(document.list_dtl.lbl_txt.value == ""){
		//alert('Label Text can not be Blank...')
		alert(getMessage('LABEL_TEXT_CANNOT_BE_BLANK','OR'))
		if(document.list_dtl.lbl_txt)
		{
			document.list_dtl.lbl_txt.focus();
			return false;
		}
	}else if(((seq_num.charAt(0) == "0") && (seq_num.length == "1")) || ((seq_num.charAt(0) == "0") && (seq_num.charAt(1) == "0") &&  (seq_num.length == "2"))){
		alert(getMessage('SEQ_NO_NOT_ZERO','OR'))
		return false
	}else if(seq_num.substring(0,1) == '0'){
		document.list_dtl.seq_no.value = seq_num.substring(1,seq_num.length);
	}
	var mnemonic_type = (eval("document.list_dtl.hdn_fld_type"+indexVal).value)
	var tmp_seq_no			= document.list_dtl.seq_no.value;
	
	var tmp_agegroup		= document.list_dtl.agegroup.value;
	var tmp_mnemonic		= document.list_dtl.mnemonic.value;
	//alert(document.list_dtl.lbl_txt.value);
	var tmp_lbl_txt			= document.list_dtl.lbl_txt.value;

/*	if((tmp_lbl_txt!=undefined) ||(tmp_lbl_txt!=null))
	{
		setFormatValues("labeltextValue_array"+dontChkVal,tmp_lbl_txt);
	}	*/
	var tmp_accept_option	= document.list_dtl.accept_option.value;
	var tmp_dependency		= document.list_dtl.finalValue.value;
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
	
	var tmp_dflt_val;
	if(document.list_dtl.dflt_val.type   == "checkbox"){
		if(document.list_dtl.dflt_val.checked)
			tmp_dflt_val = 'Y'
		else
			tmp_dflt_val  = 'N';
	}else{ 
		tmp_dflt_val		= document.list_dtl.dflt_val.value;

	}		
	/*if((tmp_dflt_val!=undefined) ||(tmp_dflt_val!=null))
	{		
		setFormatValues("descValue_array"+dontChkVal,tmp_dflt_val);
	}*/
	var tmp_mnemonic_type	= mnemonic_type;
	var tmp_position1		= eval("document.list_dtl.hdn_minVal"+position).value;
	var tmp_position2		= eval("document.list_dtl.hdn_maxVal"+position).value;



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
					alert(getMessage('MAX_NO_DECIMAL',"OR"))
					//alert('Cannot have more than 3 decimal numbers')
					return false
				}
			}

			if(tmp_position1 != "" && tmp_position2 != ""){
				if((checkDecimalRange(tmp_dflt_val,tmp_position1,tmp_position2)) == false){
					//alert("Invalid Decimal Range...")
					alert(getMessage('INVALID_DECIMAL_RANGE',"OR"))  ;
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
	if(tmp_dependency == "")	tmp_dependency = " ";
	if(document.list_dtl.chk_depnd){
		if(document.list_dtl.chk_depnd.checked == false)
			tmp_dependency = ' ';
	}
	


	/*******CHK FOR SINGLE MULTIPLE *******************/
	if(parent.list_top.mnemonic_arr.length>0)
	{
		var single_multiple =  eval("document.getElementById('single_multiple"+position+"').value");
		var presentation_type= eval("document.getElementById('presentation_type"+position+"').value");
		if (presentation_type == null) presentation_type="";
		
		for(count=0; count<parent.list_top.mnemonic_arr.length; count++)
		{
			
			count = parseInt(count,10);
			dontChk = parseInt(dontChk,10);
		 	if(count != dontChk)
			{
				if((mnemonic=="REQUEST_COMMENT")&&(ord_cat=="LB")&&(level=="H"))
				{
					if(parent.list_top.mnemonic_arr[count] == mnemonic)
					{
						request_comment_count++;	
					}
				}
				
				if(single_multiple == 'S')
				{
					
					if(parent.list_top.mnemonic_arr[count] == mnemonic)
					{
						
						if(presentation_type != 'M')
						{
							alert(getMessage('SINGLE_RECORD_CHK','OR'))  ;
							return false;
						}
					}
				}else if (single_multiple == 'M')
				{
					if(parent.list_top.mnemonic_arr[count] == mnemonic)
					{
						if(presentation_type == 'M')
						{
							alert(getMessage('SINGLE_RECORD_CHK','OR'))  ;
							return false;
						}
					}
				}
			}
		}
	}
	if(request_comment_count==3)
	{
		alert(getMessage("MORE_THAN_THREE_RECORDS_NOT_ALLOWED","OR"));
		return false;
	}
	/********/

	/****CHK FOR DUPLICATE*******/
	
	var topPageForm = parent.list_top.document.forms[0];
	if(level == "L"){
		if(topPageForm.defFlag.value  == '1' ){//in case of Order Category is Lab
			/*if(tmp_seq_no == 2  ) {  //tmp_seq_no == 1 ||
				alert(getOrMessage('DUP_SEQ_NUM')) ;
				document.list_dtl.seq_no.value= "";
				document.list_dtl.seq_no.focus();
				return false;
			}//seq no duolicated for  Order Category is Lab*/
		}
	}

	if(parent.list_top.seq_arr.length>0){
		for(count=0; count<parent.list_top.seq_arr.length; count++){

			count = parseInt(count,10);
			dontChk = parseInt(dontChk,10)
				
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
		var ref_val = parseInt(dontChk,10)

		for(count=0; count<parent.list_top.seq_arr.length; count++){			
			if(tmp_position1 == "") tmp_position1 = " ";
			if(tmp_position2 == "") tmp_position2 = " ";
			if(parent.list_top.seq_arr[count] == document.list_dtl.old_seq_no.value){
				parent.list_top.seq_arr[count]				= tmp_seq_no;
				parent.list_top.mnemonic_arr[count]			= tmp_mnemonic;
				if((tmp_lbl_txt!=undefined) ||(tmp_lbl_txt!=null))
				{
					setFormatValues("labeltextValue_array"+count,tmp_lbl_txt);
				}		
				parent.list_top.label_text_arr[count]		= "labeltextValue_array"+count;
				parent.list_top.accept_option_arr[ref_val]	= tmp_accept_option;
				parent.list_top.value_arr1[count]			= tmp_position1;
				parent.list_top.value_arr2[count]			= tmp_position2;
				parent.list_top.object_type_arr[count]		= tmp_mnemonic_type;
				if((tmp_dflt_val!=undefined) ||(tmp_dflt_val!=null))
				{		
					setFormatValues("descValue_array"+count,tmp_dflt_val);
				}
				//parent.list_top.deflt_value_arr[count]		= tmp_dflt_val;				
				parent.list_top.deflt_value_arr[count]		= "descValue_array"+count;		
				parent.list_top.agegroup_arr[count]			= tmp_agegroup;
				parent.list_top.dependency_arr[count]		= tmp_dependency;
			}
			
			/***This is in case where Order Category is Laboratroy******/
			var topPageForm1 = parent.list_top.document.forms[0];
			if(topPageForm1.defFlag.value  == '1')
			{//in case of Lab in create mode
				ord_cat = "LB" ;
			}
				//parent.list_top.deflt_value_arr[ref_val] = tmp_dflt_val;				

		}
	}else {
		
		var level			= document.list_dtl.level.value;
		var arrLength = parent.list_top.seq_arr.length
		if(parseInt(arrLength,10) !=0){
				i = parseInt(arrLength,10);
		}else if(level == 'L'){
				i=0;

			if(topPageForm.defFlag.value  == '1'){//in case of Lab in create mode

				parent.list_top.seq_arr[i]			= "1";
			//	parent.list_top.cseq_arr[i]			= "1";
				parent.list_top.mnemonic_arr[i]		= "SPECIMEN_TYPE";
				//parent.list_top.label_text_arr[i]	= "Specimen Type";
				//if((tmp_lbl_txt!=undefined) ||(tmp_lbl_txt!=null))
				//{
				setFormatValues("labeltextValue_array"+i,"Specimen Type");
				//}	

				parent.list_top.accept_option_arr[i]= "R";
				//parent.list_top.deflt_value_arr[i]	= " ";
					setFormatValues("descValue_array"+i,"");
				parent.list_top.agegroup_arr[i]		= " ";
				parent.list_top.dependency_arr[i]	= " ";
				parent.list_top.object_type_arr[i]	= " ";
				parent.list_top.value_arr1[i]		= " ";
				parent.list_top.value_arr2[i]		= " ";
				i++;


				parent.list_top.seq_arr[i]			= "2";
			//	parent.list_top.cseq_arr[i]			= "1";
				parent.list_top.mnemonic_arr[i]		= "NURSE_COLLECT_YN";
				setFormatValues("labeltextValue_array"+i,"Nurse Collect");
				//parent.list_top.label_text_arr[i]	= "Nurse Collect";
				parent.list_top.accept_option_arr[i]= "O";
				//parent.list_top.deflt_value_arr[i]	= " ";
				setFormatValues("descValue_array"+i,"");
				parent.list_top.agegroup_arr[i]		= " ";
				parent.list_top.dependency_arr[i]	= " ";
				parent.list_top.object_type_arr[i]	= " ";
				parent.list_top.value_arr1[i]		= " ";
				parent.list_top.value_arr2[i]		= " ";
				i++;

                parent.list_top.seq_arr[i]			= "3";
			//	parent.list_top.cseq_arr[i]			= "1";
				parent.list_top.mnemonic_arr[i]		= "COLLECTION_STAGE";
				//parent.list_top.label_text_arr[i]	= "Collection Stage";
				setFormatValues("labeltextValue_array"+i,"Collection Stage");
				parent.list_top.accept_option_arr[i]= "O";
				//parent.list_top.deflt_value_arr[i]	= "Separate";
				setFormatValues("descValue_array"+i,"Separate");
				parent.list_top.agegroup_arr[i]		= " ";
				parent.list_top.dependency_arr[i]	= " ";
				parent.list_top.object_type_arr[i]	= " ";
				parent.list_top.value_arr1[i]		= " ";
				parent.list_top.value_arr2[i]		= " ";
				i++;

				ord_cat = "LB" ;
			 }	 //if lab in create mode
		}



			if(topPageForm.defFlag.value  == '1'){//in case of Lab in create mode
			ord_cat = "LB" ;
			}

			
			if(tmp_position1 == "") tmp_position1 = " ";
			if(tmp_position2 == "") tmp_position2 = " ";

			parent.list_top.seq_arr[i]			= tmp_seq_no;
			parent.list_top.mnemonic_arr[i]		= tmp_mnemonic;
			//parent.list_top.label_text_arr[i]	= tmp_lbl_txt;
			if((tmp_lbl_txt!=undefined) ||(tmp_lbl_txt!=null))
			{
				setFormatValues("labeltextValue_array"+i,tmp_lbl_txt);
			}
			parent.list_top.label_text_arr[i]	= "labeltextValue_array"+i;
			parent.list_top.accept_option_arr[i]= tmp_accept_option;
			//parent.list_top.deflt_value_arr[i]	= tmp_dflt_val;
			if((tmp_dflt_val!=undefined) ||(tmp_dflt_val!=null))
			{		
				setFormatValues("descValue_array"+i,tmp_dflt_val);
			}
			parent.list_top.deflt_value_arr[i]	= "descValue_array"+i;	
			parent.list_top.agegroup_arr[i]		= tmp_agegroup;
			parent.list_top.object_type_arr[i]	= tmp_mnemonic_type
			parent.list_top.value_arr1[i]		= tmp_position1;
			parent.list_top.value_arr2[i]		= tmp_position2;

			parent.list_top.dependency_arr[i]	= tmp_dependency;			


	}	//insert mode

	

	if(parent.list_top.seq_arr.length>0){
		
	
		for(count=0; count<parent.list_top.seq_arr.length; count++){
			
			if(parent.list_top.deflt_value_arr[count] == "")
				parent.list_top.deflt_value_arr[count] = " ";
			if(parent.list_top.agegroup_arr[count] == "")
				parent.list_top.agegroup_arr[count] = " ";
			if(parent.list_top.dependency_arr[count] == "")
				parent.list_top.dependency_arr[count] = " ";			
			
			//finalString += parent.list_top.seq_arr[count]+"~"+parent.list_top.mnemonic_arr[count]+"~"+parent.list_top.label_text_arr[count]+"~"+parent.list_top.accept_option_arr[count]+"~"+parent.list_top.deflt_value_arr[count]+"~"+parent.list_top.agegroup_arr[count]+"~"+parent.list_top.dependency_arr[count]+"~"+parent.list_top.object_type_arr[count]+"~"+parent.list_top.value_arr1[count]+"~"+parent.list_top.value_arr2[count]+"~"+parent.list_top.occ_no_arr[count]+"`"
			finalString = parent.list_top.seq_arr[count]+"~"+parent.list_top.mnemonic_arr[count]+"~"+parent.list_top.label_text_arr[count]+"~"+parent.list_top.accept_option_arr[count]+"~"+parent.list_top.deflt_value_arr[count]+"~"+parent.list_top.agegroup_arr[count]+"~"+parent.list_top.dependency_arr[count]+"~"+parent.list_top.object_type_arr[count]+"~"+parent.list_top.value_arr1[count]+"~"+parent.list_top.value_arr2[count]+"~"+parent.list_top.occ_no_arr[count];			
				
			//setFinal_String(parent.list_top.seq_arr[count],finalString);
			setFinal_String(count,finalString);
			
		}
		
		
	}
	//var test = setFinalString(finalString)
 	//if(test == finalString) {
 	//	alert("done");
 	//}
	//document.list_dtl.finalString.value =finalString;//here  encodeURIComponent(

	document.list_dtl.mode.value = "insert";
	document.list_dtl.action	 = "OrderEntryFormatTop.jsp";
	document.list_dtl.target	 = "list_top";
//	document.list_dtl.submit();	 ---cannot get the err....

	//Add line
//	alert("AGE Short DEsc:"+age_group_sd);//bellow encodeURIComponent(
	if(ord_cat == "")
		ord_cat = document.list_dtl.ord_cat.value;

//parent.list_top.document.location.href="../jsp/OrderEntryFormatTop.jsp?finalString="+finalString+"&ord_cat="+ord_cat+"&age_group_sd="+age_group_sd+"&age_group_cd="+age_group_cd;
parent.list_top.document.location.href="../jsp/OrderEntryFormatTop.jsp?ord_cat="+ord_cat+"&age_group_sd="+age_group_sd+"&age_group_cd="+age_group_cd;
	//parent.list_top.document.location.href="../jsp/OrderEntryFormatTop.jsp?ord_cat="+ord_cat;

	document.list_dtl.seq_no.value = "";
	document.list_dtl.mnemonic.value = "";
	document.list_dtl.lbl_txt.value = "";
	document.list_dtl.accept_option.selectedIndex = 0;
	document.list_dtl.dflt_val.value = "";
	document.list_dtl.agegroup.value= "";
	document.list_dtl.dontChk.value = "";
	document.list_dtl.finalValue.value = "";	
	document.getElementById("deflt_value1").innerHTML = ""
	document.getElementById("deflt_value2").innerHTML = ""
	document.getElementById("depend1").innerHTML = ""
	document.getElementById("depend2").innerHTML = ""

	parent.list_bottom.list_dtl.clear.disabled = false;
	parent.list_bottom.list_dtl.seq_no.disabled = false;
	parent.list_bottom.list_dtl.mnemonic.disabled = false;
	parent.list_bottom.list_dtl.accept_option.disabled = false;
	
	parent.list_depend.location.href="../../eCommon/html/blank.html";
}

function takeValues(){
	var level			= document.list_dtl.level.value;
//	var ord_cat			= document.ord_cat.level.value;
//alert(document.list_dtl.order_catalog.value+","+document.list_dtl.order_type.value);
	var topPageForm = parent.list_top.document.forms[0];
	var finalString = "";
	if(parent.list_top.seq_arr.length>0){
		for(count=0; count<parent.list_top.seq_arr.length; count++){
			//if((parent.list_top.deflt_value_arr[count]!=undefined)||(parent.list_top.deflt_value_arr[count]!=null))
			//{		
			//setFormatValues("descValue_array"+parent.list_top.seq_arr[count],parent.list_top.deflt_value_arr[count]);
			//}
			//if((parent.list_top.label_text_arr[count]!=undefined)||(parent.list_top.label_text_arr[count]!=null))
			//{		
			//setFormatValues("labeltextValue_array"+parent.list_top.seq_arr[count],parent.list_top.label_text_arr[count]);
			//}

			if( (level == "L") && (topPageForm.defFlag.value  == '1')){
				if((parent.list_top.seq_arr[count] == "1")||(parent.list_top.seq_arr[count] == "2")||(parent.list_top.seq_arr[count] == "3")){
					parent.list_top.agegroup_arr[count] = " ";
				//	parent.list_top.dependency_arr[count] = " ";
					parent.list_top.object_type_arr[count] = " ";
					parent.list_top.value_arr1[count] = " ";
					parent.list_top.value_arr2[count] = " ";
				}
			}
			if(parent.list_top.deflt_value_arr[count] == "")
				parent.list_top.deflt_value_arr[count] = " ";
			if(parent.list_top.agegroup_arr[count] == "")
				parent.list_top.agegroup_arr[count] = " ";
			if(parent.list_top.dependency_arr[count] == "" ||parent.list_top.dependency_arr[count]=="N")
				parent.list_top.dependency_arr[count] = " ";
			
			if(parent.list_top.dependency_arr[count] == "Y")
			{						
			populateDependencyvalues(parent.list_top.seq_arr[count],parent.list_top.mnemonic_arr[count])
			parent.list_top.dependency_arr[count] = document.list_dtl.dependency_arr.value;
			
			}
			var chking=parent.list_top.mnemonic_arr[count];
			var tempchk;
			if(chking.indexOf!=-1){
			tempchk=chking.split("||");
			}
			else{
				tempchk[1]=chking;}
			
			//setFormatValues("labeltextValue_array"+3,"Collection Stage");
			
			//alert("b4-label_text_arr[count]"+parent.list_top.label_text_arr[count]);

			//finalString += parent.list_top.seq_arr[count]+"~"+parent.list_top.mnemonic_arr[count]+"~"+"labeltextValue_array"+parent.list_top.seq_arr[count]+"~"+parent.list_top.accept_option_arr[count]+"~"+"descValue_array"+parent.list_top.seq_arr[count]+"~"+parent.list_top.agegroup_arr[count]+"~"+parent.list_top.dependency_arr[count]+"~"+parent.list_top.object_type_arr[count]+"~"+parent.list_top.value_arr1[count]+"~"+parent.list_top.value_arr2[count]+"~"+parent.list_top.occ_no_arr[count]+"`"
			//finalString += parent.list_top.seq_arr[count]+"~"+parent.list_top.mnemonic_arr[count]+"~"+parent.list_top.label_text_arr[count]+"~"+parent.list_top.accept_option_arr[count]+"~"+parent.list_top.deflt_value_arr[count]+"~"+parent.list_top.agegroup_arr[count]+"~"+parent.list_top.dependency_arr[count]+"~"+parent.list_top.object_type_arr[count]+"~"+parent.list_top.value_arr1[count]+"~"+parent.list_top.value_arr2[count]+"~"+parent.list_top.occ_no_arr[count]+"`"
			//alert("finalStringonok"+finalString);
			//+"~"+parent.list_top.position_arr[count]
		}//setFinalString(finalString);
		//alert("takevalues :"+finalString)
	}
	//document.list_dtl.finalString.value = finalString; //encodeURIComponent(finalString);
//	alert('dfdfd ::: '+document.list_dtl.finalString.value)
	//window.returnValue = document.list_dtl.finalString.value
	//window.returnValue =finalString;
//	alert(window.name);
//alert("window return"+window.returnValue);
	//window.close();
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
}



function checkIntegerRange(val,position1,position2){
	if(val == "" )
		return true ;

		val = parseInt(val,10)
		position1 = parseInt(position1,10)
		position2 = parseInt(position2,10)

		if(!((val >= position1) && (val <= position2))){
			return false
		}
	return true
}

// this is to check whether the decimal is a valid decimal - should validate number like 23.3.44
function isValidDecimal(val){
	if(isNaN(val)){
		alert(getMessage('INVALID_DECIMAL_NUMBER',"OR"))
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

	 String imgUrl="";
	 if(sStyle.equals("IeStyle.css"))
	 {
		 imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
 
</head>
<html>
<body onload='FocusFirstElement();' onunload="javascript:closeWindow()" OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">

<form name="list_dtl" id="list_dtl" >
<%
try{
	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String ord_cat = request.getParameter("ord_cat")==null?"":request.getParameter("ord_cat");
	String level = request.getParameter("level")==null?"":request.getParameter("level");
	String format_id = request.getParameter("format_id")==null?"":request.getParameter("format_id");	
	String order_type =  request.getParameter("order_type")==null?"":request.getParameter("order_type");
	String object_format_type =  request.getParameter("object_format_type")==null?"":request.getParameter("object_format_type");
	String order_catalog = request.getParameter("ord_catalog")==null?"":request.getParameter("ord_catalog");
	//String finalString = request.getParameter("finalString");	
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
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
<tr><td width="40%" class="label" ><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></td><td class="fields"><input type=text name="seq_no" id="seq_no" value="" size=2 maxlength=2 onKeyPress='return allowPositiveNumber()' onBlur="return checkPositiveNumber(this)" onChange="populateListValues('<%=ord_cat%>','mnemonic','','seqTop')" ><img src="../../eCommon/images/mandatory.gif"></td></tr>

<!-- <tr><td width="40%" class="label" align="right"> Column Sequence No&nbsp;</td><td><input type=text name="cseq_no" id="cseq_no" value="" size=2 maxlength=1 onKeyPress="return limitNumber()" >&nbsp;<img src="../../eCommon/images/mandatory.gif"></td></tr>
 -->
<tr>
	<td width="40%" class="label" ><fmt:message key="eOR.FieldMnemonicDesc.label" bundle="${or_labels}"/></td>
	<td class="fields">
		<SELECT name="mnemonic" id="mnemonic" onChange="populateValues()" >
			<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
			<%try{
				Mnemonic_Data = bean.getMnemonic(ord_cat,level);//IN038529 added level

				for(int i=0; i<Mnemonic_Data.size(); i++){
					String[] record = (String [])Mnemonic_Data.get(i);
					//String[] record1=(String [])Mnemonic_Data.get(i);					
					
				%>
				<option value='<%=record[0]%>'><%=record[6]%></option>
			<%}
			}catch(Exception e){
				e.printStackTrace();
			}
		%>
		</SELECT><img src="../../eCommon/images/mandatory.gif">
		<input type="hidden" name="mnemonichdn" id="mnemonichdn" value="">
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
	<tr><td width="40%" class="label"  ><fmt:message key="Common.labelText.label" bundle="${common_labels}"/></td><td class="fields"><input type=text name="lbl_txt" id="lbl_txt" value="" size=50 maxlength=50  onKeyPress='checkSpecialChar(event);'  onBlur='return checkSpecialCharBlur(this)'><img src="../../eCommon/images/mandatory.gif"></td></tr>   <!--onKeyPress = 'return CheckForSpecCharsWithoutSpace(event)' -->
	<tr><td width="40%" class="label" ><fmt:message key="Common.AcceptOption.label" bundle="${common_labels}"/></td><td class="fields"><SELECT name="accept_option" id="accept_option" onChange='onChangeAcceptOption(this);'><option value="O"><fmt:message key="Common.Optional.label" bundle="${common_labels}"/></option><option value="R"><fmt:message key="Common.required.label" bundle="${common_labels}"/></option><option value="D"><fmt:message key="Common.DisplayOnly.label" bundle="${common_labels}"/></option></SELECT></td></tr>
	<tr>
		<td  id='deflt_value1' class=label ></td>

		<td  id='deflt_value2' class="fields" ><!--   style="visibility:hidden"-->
			<!-- <select name="dflt_val" id="dflt_val"><option value=''>-----Select-----</select> -->
		</td>
	</tr>
	<tr><td width="40%" class="label" ><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/> </td>
	    <td class="fields">
		<SELECT name="agegroup" id="agegroup" >
		<option value="">  --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---  
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
	<tr>
		<td  id='depend1' class=label > </td>

		<td  id='depend2' class="fields" >
		</td>
	</tr>
	
<tr>
	<td  class='button' align="right" colspan=2 width="100vw">
	<input type=hidden name='presentation_type0' id='presentation_type0' value="">
	<input type=hidden name="finalString" id="finalString" value="">
	<input type=button class="button" name="select" id="select" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")%>" onClick="chkMandatory();">
	<input type=button class="button" name="ok" id="ok" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick="takeValues();">
	<input type=button  class="button" name="clear" id="clear" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>"  onClick="removeValues();">
	<input type=button class="button" name="close" id="close" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick="closeWindow()" >
	</td>
</tr>
</table>
<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
<input type=hidden name='ord_cat' id='ord_cat' value="<%=ord_cat%>">

<input type=hidden name='order_type' id='order_type' value="<%=order_type%>">
<input type=hidden name='order_catalog' id='order_catalog' value="<%=order_catalog%>">
<input type=hidden name='level1' id='level1' value="<%=level%>">
<input type=hidden name='finalString' id='finalString' value="">
<input type=hidden name='finalValue' id='finalValue' value=" ">

<input type=hidden name='mode' id='mode' value="">
<input type=hidden name='old_mnemonic' id='old_mnemonic' value="">
<input type=hidden name='old_seq_no' id='old_seq_no' value="">
<input type=hidden name='old_lbl_txt' id='old_lbl_txt' value="">
<input type=hidden name='old_accept_opt' id='old_accept_opt' value="">
<input type=hidden name='old_dflt_val' id='old_dflt_val' value="">
<input type=hidden name='old_agegroup' id='old_agegroup' value="">
<input type=hidden name='old_order_type' id='old_order_type' value="">
<input type=hidden name='old_position' id='old_position' value="">
<input type=hidden name='dontChk' id='dontChk' value="">
<input type=hidden name='old_finalValue' id='old_finalValue' value="">
<input type=hidden name='dependency_arr' id='dependency_arr' value="">
<input type=hidden name='format_id' id='format_id' value="<%=format_id%>">
<input type=hidden name='object_format_type' id='object_format_type' value="<%=object_format_type%>">

</form>

</body>

</html>


<%	putObjectInBean(bean_id,bean,request);
			
}catch(Exception e){
	e.printStackTrace();
}
		
 
%>

