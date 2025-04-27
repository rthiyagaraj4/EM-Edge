/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;

function reset() {
	f_query_add_mod.document.formLogSheetForAutoclavePlasma.reset();
}

function run()
{
   var formObj=f_query_add_mod.document.formLogSheetForAutoclavePlasma;
 var fields=new Array(formObj.p_sterile_type);
   var names = new Array ( getLabel("eSS.SterileType.label","eSS"));
   var errorPage	=	"../../eCommon/jsp/error.jsp";
   var blankObject	=	null;
	 blankObject	=	checkSSFields( fields, names, messageFrame,errorPage);
	if (blankObject != true) {
		
		return;
	}	
	if (isValidFromToField(formObj.p_load_fm, formObj.p_load_to, LONG, "Load No", messageFrame)) 
    	//if (isValidFromToField(formObj.p_fm_date, formObj.p_to_date, DATE, "Autoclave Date", messageFrame)) 
					formObj.p_fm_date.value=convertDate(formObj.p_fm_date1.value,'DMY',formObj.lang_id.value,"en");
					formObj.p_to_date.value=convertDate(formObj.p_to_date1.value,'DMY',formObj.lang_id.value,"en");
				if(formObj.p_fm_date1.value != "" && formObj.p_to_date1.value != "" ){
		  if(!isBefore(formObj.p_fm_date.value,formObj.p_to_date.value,"DMY",'en'.value)) {
         alert(getMessage("FM_DATE_GR_TO_DATE", "SS"));
         formObj.p_to_date1.focus();
          return ;	
        } 
	  }
	   if(formObj.p_fm_date1.value == ""){
	   alert(getMessage("FROM_DATE_NOT_BLANK", "SS"));
      formObj.p_fm_date1.focus();
      return ;	
	   }
	   
	   if(formObj.p_to_date1.value == ""){
		   alert(getMessage("TO_DATE_NOT_BLANK", "SS"));
	       formObj.p_to_date1.focus();
	       return ;	
		   }
	   

	           		formObj.submit();
}

