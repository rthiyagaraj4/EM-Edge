/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var radioval    = "D"         ;

function storeVal(currad) {
    radioval=currad.value ;
}

function search(search_text)
{
	document.CriteriaForm.Search.disabled = true;

var search_by		 = radioval;

var term_code		 = document.CriteriaForm.search_text.value; //
var search_criteria	 = document.CriteriaForm.search_criteria.value;
var multiple_yn		 = document.CriteriaForm.multiple_yn.value;
var temp_term_code	 = document.CriteriaForm.temp_term_code.value;
var term_code_associated = document.CriteriaForm.term_code_associated.value;
var Db_term_code		 = document.CriteriaForm.Db_term_code.value;


var term_code_associated1 = term_code_associated.split("`") ;
var term_code_associated2 ="";
for(var i=0;i<(term_code_associated1.length-1);i++){
	
	var retVal = term_code_associated1[i].split("~") ;
	//term_code_associated += term_set_id+"~"+level+"~"+level_desc+"~"+eval("document.terminology_level.lvl_code"+i).value+"*";
	term_code_associated2 += retVal[0]+"||"+retVal[3]+"||"+retVal[2]+"||"+retVal[1]+"~";
	
} term_code_associated =term_code_associated2;
parent.lookup_detail.location.href = "../../eOR/jsp/PractLookupQueryResult.jsp?term_set_id=&term_code="+term_code+"&sc="+search_criteria+"&multiple_yn="+multiple_yn+"&search_by="+search_by+"&temp_term_code="+temp_term_code+"&term_code_associated="+term_code_associated+"&Db_term_code="+Db_term_code;
}
function retainChk(){

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
			if(retVal.indexOf(test_code1) == -1){
				retVal += code1+"~";
				var code1=frmObj.result_tbl.rows(i-1).cells[0].innerText;
				var code2=frmObj.result_tbl.rows(i-1).cells[1].innerText;
				var code3=frmObj.result_tbl.rows(i-1).cells[2].innerText;
				var code4=frmObj.result_tbl.rows(i-1).cells[3].children(0).value;
				ret_term_code += code1 + "||" + code2 + "||" + code3 + "||" + code4 +"~";
			}
		}else{
			var code1=frmObj.result_tbl.rows(i-1).cells[0].innerText;
			if(retVal.indexOf(code1) != -1){
				var ind = retVal.indexOf(code1);
				var tmp_equ, tmp_equ1 ,tmp_equ2 ;
				if(ind != 0){
					tmp_equ = retVal.substring(0,ind);
					tmp_equ2= retVal.substring(ind , retVal.length);
					tmp_equ1= retVal.substring(0 , (tmp_equ2.indexOf("~")));
				}else{
					tmp_equ1 = retVal.substring(0,(retVal.indexOf("~")));
				}

				if(code1 == tmp_equ1){
					var tmp="";var tmp1="";
					if((retVal.indexOf(code1)) != 0){
						tmp=retVal.substring(0,(retVal.indexOf(code1)));
						var tmp_1= retVal.substring((retVal.indexOf(code1))+1,tmp.length);
						tmp1 = tmp_1.substring((tmp_1.indexOf("~"))+1,tmp_1.length );
					}else{
						tmp = retVal.substring((retVal.indexOf("~"))+1,retVal.length );
					}
					retVal = tmp + tmp1;
				}
			}
		}
	}
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
	document.QueryForm.action = "../../eOR/jsp/PractLookupQueryResult.jsp?"+lookup_string+"&temp_term_code="+escape(gb_trm_code)+"&term_code_associated="+escape(gb_term_code_associated)+"&Db_term_code="+gb_Db_term_code;
	document.QueryForm.submit() ;
}
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
	setSearch(document.CriteriaForm.search_by)
	parent.lookup_head.document.CriteriaForm.Search.disabled = false;
    parent.lookup_detail.location.href = "../../eCommon/html/blank.html";

}
function setSearch(obj){
		if(obj.value=="D"){
			document.getElementById("term").innerHTML= '<div class="label">Term Description&nbsp;<input type="text" onBlur=""  name="search_text" id="search_text" value="" width="30%" align="left" size="20" maxlength="40" onkeypress="return CheckForSpecChars(event);"><img src="../../eCommon/images/mandatory.gif"></div>';
		}else if(obj.value=="C"){
			document.getElementById("term").innerHTML= '<div class=label>Term Code&nbsp;<input type="text" onBlur=""  name="search_text" id="search_text" value="" width="30%" align="left" size="20" maxlength="40" onkeypress="return CheckForSpecChars(event);"><img src="../../eCommon/images/mandatory.gif"></div>';
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

