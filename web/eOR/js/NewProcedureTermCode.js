/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var radioval    = "G"         ;
function setRadioVal(){
	alert("=="+parent.lookup_head.document.CriteriaForm.tmp_radioval.value+"==");
	if(parent.lookup_head.document.CriteriaForm.tmp_radioval.value == "")
		call("clear_values","");
	else
		call("pre_values","");	
 if(parent.lookup_head.document.CriteriaForm.terminology(0).checked){
	 storeVal(parent.lookup_head.document.CriteriaForm.terminology(0));
	 radioval="G";
 }else if(parent.lookup_head.document.CriteriaForm.terminology(1).checked){
	 storeVal(parent.lookup_head.document.CriteriaForm.terminology(1));
	 radioval="C";
 }	
}
function storeVal(terminology) {
    radioval=terminology.value;
	parent.lookup_head.document.CriteriaForm.Search.disabled = false;
	if(radioval == "C"){
		parent.document.getElementById("procDetails").cols="0%,100%" ;
		document.getElementById("term_set_man").style.visibility = "visible";
		document.getElementById("term_set_man1").style.visibility = "visible";
		parent.lookup_group.location.href = "../../eCommon/html/blank.html";
	}else{
		parent.document.getElementById("procDetails").cols="30%,70%" ;
		document.getElementById("term_set_man").style.visibility = "hidden";
		document.getElementById("term_set_man1").style.visibility = "hidden";
	}
//	if(parent.lookup_head.document.CriteriaForm.tmp_radioval.value != radioval){
	if(parent.lookup_head.document.CriteriaForm.tmp_radioval.value != ''){
//		call("clear_values","");// to clear the bean values
		alert("here");
		call("pre_values","clearValues");
	}else
		call("clear_values","clearValues");// to clear the bean values

	
	parent.lookup_detail.location.href = "../../eCommon/html/blank.html";
}
function changeLevel(obj){
	var level="";
	var term_setid="";
	var splitVal = (obj.value).split("~");
	term_setid =splitVal[0];
	document.CriteriaForm.term_set_id.value = term_setid;
	level= splitVal[1];
	clearList( "document" );
	for(var i=1;i<=level;i++){
		var code = i;
		var value = ("Level "+i);
		addLevelList(code,value);
	
	}

}

function addLevelList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.CriteriaForm.level.add(element);
	
}

function clearList( docObj ) {
	var len = eval(docObj+".CriteriaForm.level.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".CriteriaForm.level.remove(\"atc_class_l2_code\")") ;
	}
	var tp = "--"+getLabel("Common.defaultSelect.label","Common")+"--" ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".CriteriaForm.level.add(opt)") ;
}
function search()
{
	//if(document.CriteriaForm.term_set.value == '' && radioval=="C" ){
	if(document.CriteriaForm.term_set_id.value == '' && radioval=="C" ){
		document.CriteriaForm.Search.disabled = false;
		message = getMessage("TERM_SET_SHOULD_NOT_BE_BLANK","MR");
		alert(message);
		document.CriteriaForm.term_set.focus();
		return false;
	}
	else if(document.CriteriaForm.search_text.value == '' && radioval=="C")
	{
		document.CriteriaForm.Search.disabled = false;
		if(document.CriteriaForm.search_by.value == 'D')
		{
			message = getMessage("TERM_DESC_SHOULD_NOT_BE_BLANK","MR");
			alert(message);
		}
		else
		{
			message = getMessage("TERM_CODE_SHOULD_NOT_BE_BLANK","MR");
			alert(message);
		}
		document.CriteriaForm.search_text.focus();
		return false;
	}
		document.CriteriaForm.Search.disabled = true;

		//var term_set_id		 = document.CriteriaForm.term_set.value;
		var term_set_id		 = document.CriteriaForm.term_set_id.value;
		var code_level		 = document.CriteriaForm.level.value;
		var search_by		 = document.CriteriaForm.search_by.value;
		var term_code		 = document.CriteriaForm.search_text.value;
		var search_criteria	 = document.CriteriaForm.search_criteria.value;
		var multiple_yn		 = document.CriteriaForm.multiple_yn.value;
		var temp_term_code	 = document.CriteriaForm.temp_term_code.value;
		var term_code_associated = document.CriteriaForm.term_code_associated.value;
		var Db_term_code		 = document.CriteriaForm.Db_term_code.value;
		var term_code_associated1 = term_code_associated.split("`") ;
		var term_code_associated2 ="";

		for(var i=0;i< (term_code_associated1.length-1);i++)
		{
			var retVal = term_code_associated1[i].split("~") ;
			term_code_associated2 += retVal[0]+"||"+retVal[3]+"||"+retVal[2]+"||"+retVal[1]+"~";
		} 
		term_code_associated =term_code_associated2;

		//parent.lookup_group.location.href = "../../eOR/jsp/NewProcTermCodeGroup.jsp?term_set_id="+term_set_id+"&term_code="+term_code+"&code_level="+code_level+"&sc="+search_criteria+"&multiple_yn="+multiple_yn+"&search_by="+search_by+"&temp_term_code="+temp_term_code+"&term_code_associated="+term_code_associated+"&Db_term_code="+Db_term_code+"&radioval="+radioval;
		
		if(radioval=="C"){
			parent.lookup_detail.location.href = "../../eOR/jsp/NewProcTermCodeQueryResult.jsp?term_set_id="+term_set_id+"&term_code="+term_code+"&code_level="+code_level+"&sc="+search_criteria+"&multiple_yn="+multiple_yn+"&search_by="+search_by+"&temp_term_code="+temp_term_code+"&term_code_associated="+term_code_associated+"&Db_term_code="+Db_term_code+"&radioval="+radioval;

			parent.lookup_group.location.href = "../../eCommon/html/blank.html";
		}else {
			parent.lookup_group.location.href = "../../eOR/jsp/NewProcTermCodeGroup.jsp?term_set_id="+term_set_id+"&term_code="+term_code+"&code_level="+code_level+"&sc="+search_criteria+"&multiple_yn="+multiple_yn+"&search_by="+search_by+"&temp_term_code="+temp_term_code+"&term_code_associated="+term_code_associated+"&Db_term_code="+Db_term_code+"&radioval="+radioval;

			parent.lookup_detail.location.href = "../../eCommon/html/blank.html";
			document.CriteriaForm.Search.disabled = false;
		}
}
var pass_link=true;
function retainChk()
{
	var frmObj =parent.lookup_detail.document;
	var cnt = frmObj.cnt.value;
	var retVal = frmObj.temp_term_code1.value;
	var ret_term_code = "";
	ret_term_code = frmObj.ret_term_code.value;
	
	if(eval("frmObj.term_chk2")){
	for(var i=2;i<cnt;i++){ 
		if(eval("frmObj.term_chk"+i).checked){
			var code1=frmObj.result_tbl.rows(i-1).cells[0].innerText;
			var test_code1 = code1+"~";
			if(retVal.indexOf(test_code1) == -1 && ret_term_code.indexOf(code1) == -1){
				retVal += code1+"~";
				var code1=frmObj.result_tbl.rows(i-1).cells[0].innerText;
				var code2=frmObj.result_tbl.rows(i-1).cells[1].innerText;
				var code3=frmObj.result_tbl.rows(i-1).cells[2].innerText;
				var code4=frmObj.result_tbl.rows(i-1).cells[3].children(0).value;
				ret_term_code += code1 + "||" + code2 + "||" + code3 + "||" + code4 +"~";
			//alert("retVal=add=="+retVal+"=test_code1="+test_code1+"==code1=="+code1+"==ret_term_code="+ret_term_code+"==");
			}
			
		}else{
			var code1=frmObj.result_tbl.rows(i-1).cells[0].innerText;
			
			if(retVal.indexOf(code1) != -1){
				var ind = retVal.indexOf(code1);
				var tmp_equ, tmp_equ1 ,tmp_equ2 ;
				
				if(ind != 0){
					tmp_equ = retVal.substring(0,ind);
					tmp_equ2= retVal.substring(ind , retVal.length);
					tmp_equ1= tmp_equ2.substring(0 , (tmp_equ2.indexOf("~")));
					
				}else{
					tmp_equ1 = retVal.substring(0,(retVal.indexOf("~")));
				}
				
				if(code1 == tmp_equ1){
					var tmp="";var tmp1="";
					var tmp_desc_equ ="", tmp_desc_equ1="" ,tmp_desc_equ2="" ;
					if((retVal.indexOf(code1)) != 0){
						
						tmp=retVal.substring(0,(retVal.indexOf(code1)));
						var tmp_1= retVal.substring((retVal.indexOf(code1))+1,retVal.length);
						tmp1 = tmp_1.substring((tmp_1.indexOf("~"))+1,tmp_1.length );
												
						tmp_desc_equ =ret_term_code.substring(0,(ret_term_code.indexOf(code1)));
						var tmp_desc = ret_term_code.substring((ret_term_code.indexOf(code1)),ret_term_code.length);
						tmp_desc_equ1 = tmp_desc.substring((tmp_desc.indexOf("~"))+1,tmp_desc.length );
						
					}else{
						tmp = retVal.substring((retVal.indexOf("~"))+1,retVal.length );
						tmp_desc_equ = ret_term_code.substring((ret_term_code.indexOf("~"))+1,ret_term_code.length );
					}
					retVal = tmp + tmp1;
					//alert("===ret_term_code======="+ret_term_code)
					ret_term_code = tmp_desc_equ + tmp_desc_equ1;
				}
			}
		}
	}
	}
	var tmp_retArr = retVal.split("~");
	pass_link=true;
	
	var tmp_ret_term_code_arr = ret_term_code.split("~");
	//alert(retVal+"==="+ret_term_code+"=tmp_retArr="+tmp_retArr.length+"=ret_term_code="+tmp_ret_term_code_arr.length+"=pass_link="+pass_link);

	if(tmp_ret_term_code_arr.length >11){
		pass_link=false;
	}
	if(!pass_link){
		
		alert("APP-OR0023 Only Ten Selections are allowed");
		return false;
	}

	lookup_string = frmObj.qry_string.value;
	var ind_val = lookup_string.indexOf("&temp_term_code=");
	lookup_string = lookup_string.substring(0,ind_val);
	frmObj.temp_term_code.value = retVal; 
	frmObj.ret_term_code.value = ret_term_code; 
	gb_trm_code =retVal;
	gb_term_code_associated = frmObj.ret_term_code.value;
	gb_Db_term_code = frmObj.db_term_code.value;
	

}

function SubmitLink(from, to) {
	
    document.QueryForm.from.value = from;
    document.QueryForm.to.value = to;
    document.QueryForm.submit() ;
}

/*function SubmitLink(from, to) {
	//alert(pass_link);
	
	document.QueryForm.from.value = from;
	document.QueryForm.to.value = to;
	//document.QueryForm.action = "../../eOR/jsp/NewProcTermCodeQueryResult.jsp?"+lookup_string+"&temp_term_code="+escape(gb_trm_code)+"&term_code_associated="+escape(gb_term_code_associated)+"&Db_term_code="+gb_Db_term_code;
	document.QueryForm.submit() ;
}*/
function changeCursor(obj) {
	obj.style.cursor = "hand" ;
}

function disableClick(evnt) {
	evnt.cancelBubble = true ;
}


function Modify(obj){
    var code1=obj.cells[0].innerText;
    var code2=obj.cells[1].innerText;
    var code3=obj.cells[2].innerText;
    var retVal = code1 + "||" + code2 + "||" + code3 +"~";
	top.window.returnValue = retVal ;
    top.close()
}

function resetForm( formObj )
{
    formObj.reset();
	setSearch(document.CriteriaForm.search_by);
	storeVal(document.CriteriaForm.terminology);
	parent.lookup_head.document.CriteriaForm.Search.disabled = false;
    parent.lookup_group.location.href = "../../eCommon/html/blank.html";
    parent.lookup_detail.location.href = "../../eCommon/html/blank.html";

}
function setSearch(obj){
	
		if(obj.value=="D"){
			document.getElementById("term").innerHTML= '<div class="label">Term Description&nbsp;<input type="text" onBlur=""  name="search_text" id="search_text" value="" width="30%" align="left" size="20" maxlength="40" onkeypress="return CheckForSpecChars(event);"><img id="term_set_man1" src="../../eCommon/images/mandatory.gif"></div>';
		}else if(obj.value=="C"){
			document.getElementById("term").innerHTML= '<div class=label>Term Code&nbsp;<input type="text" onBlur=""  name="search_text" id="search_text" value="" width="30%" align="left" size="20" maxlength="40" onkeypress="return CheckForSpecChars(event);"><img id="term_set_man1" src="../../eCommon/images/mandatory.gif"></div>';
		}
}

/*To check for special characters in the Term Description / Code  text  field.*/
function CheckForSpecChars(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) 
		return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}
function call(obj_name,code){


var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script></script></head><body class=MESSAGE><form name='tempform' id='tempform' method='post' action='../../eOR/jsp/NewProcTermCodeValidate.jsp'><input type=hidden name='"+obj_name+"' id='"+obj_name+"' value='"+code+"'><input type=hidden name='textName' id='textName' value='"+obj_name+"'></form></body></html>";
	
	//alert("HtmlVal==="+HtmlVal);
	
	
	parent.lookup_tempframe.document.write(HtmlVal);
	parent.lookup_tempframe.document.tempform.submit();
}
/*************************************************************/
function retainGrpChk(){
	var frmObj =parent.lookup_group.document;
	var cnt = frmObj.grp_tbl.rows.length ;
	var result_type = "";
	for(var i=1;i<cnt;i++)
	{ 
		if(frmObj.grp_tbl.rows(i).cells.length > 2){
			var term_grp_id= frmObj.grp_tbl.rows(i).cells(0).innerText;
			var term_set_id= frmObj.grp_tbl.rows(i).cells(0).children(1).value;
			
			if(frmObj.grp_tbl.rows(i).cells(2).children(0).checked)
				chk_val = "Y";
			else
				chk_val = "N";

			result_type += term_set_id+term_grp_id+"~"+chk_val+"::";
		}
		
	}
	//alert(result_type);
	if(result_type !="")
		call("termgrp_code",result_type);
}

function retainCodeChk(){
	var frmObj =parent.lookup_detail.document;
	var cnt = frmObj.result_tbl.rows.length ;
	var result_type = "";
	for(var i=1;i<cnt;i++)
	{ 
		var code= frmObj.result_tbl.rows(i).cells(0).innerText;
		var desc= frmObj.result_tbl.rows(i).cells(1).innerText;
		var level_desc=frmObj.result_tbl.rows(i).cells(2).innerText;
		var level=frmObj.result_tbl.rows(i).cells(3).children(0).value;
		
		if(frmObj.result_tbl.rows(i).cells(4).children(0).checked)
			chk_val = "Y";
		else
			chk_val = "N";

		//result_type += code+"|"+desc+"|"+level+"|"+level_desc+"~"+chk_val+"::";
		result_type += code+"|"+desc+"~"+chk_val+"::";
			
	}
	//alert(result_type);
	//return false;
	if(result_type !="")
		call("term_code",result_type);
}

