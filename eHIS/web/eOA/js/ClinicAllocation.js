function addGroup(){
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	var no_solts=document.alcn_add_form.no_solts.value;
	var pat_category=document.alcn_add_form.pat_category.value;
	var selIndex=document.alcn_add_form.pat_category.selectedIndex;
	var selText=document.alcn_add_form.pat_category.options[selIndex].text;
	var max_patients_per_day=document.alcn_add_form.max_patients_per_day.value;
	var fields = new Array (document.alcn_add_form.pat_category,document.alcn_add_form.no_solts);
	var names = new Array ("Nationality Group","Noof Slots");
	var addFlag=true;
	var count=0;
	var otherCount=0;
	var modify = document.alcn_add_form.modify.value;

	if(checkFields(fields, names, parent.parent.messageFrame) &&  modify !='Y'){
		var finalValue=parent.display_allocation.result_form.finalValue.value;//groups already in the result frame
		if(finalValue!=""){
			var finalValueTokens=finalValue.split("|");
			var tokenCount=finalValueTokens.length;
			for(var cnt=0;cnt<tokenCount;cnt++){
				var valToken=finalValueTokens[cnt];
				var grpToken=valToken.split("$");
				if(pat_category==grpToken[0]){
					alert('category already exists')
					addFlag=false;
				}
				count=eval(count)+eval(grpToken[1]);
			}
		}
			if(finalValue==""){
			finalValue=pat_category+"$"+no_solts+"$"+selText;
			otherCount=eval(max_patients_per_day)-eval(no_solts);
			if(eval(no_solts) > eval(max_patients_per_day)){
				//parent.parent.messageFrame.location.href="../eCommon/jsp/error.jsp?err_num=Max slots or greater&err_value=1"
				addFlag=false;
				alert(getMessage('TOT_ALCN_NOT_GT_MX_PAT_DAY','OA'));
			}
		}else{
			count=count+eval(no_solts);
			if(eval(count) > eval(max_patients_per_day)){
				addFlag=false;
				alert(getMessage('TOT_ALCN_NOT_GT_MX_PAT_DAY','OA'));
			}
			if(addFlag){
				otherCount=eval(max_patients_per_day)-eval(count);
				finalValue=finalValue+"|"+pat_category+"$"+no_solts+"$"+selText;
			}
		}
		if(addFlag){
			document.alcn_add_form.no_solts.value="";
			document.alcn_add_form.pat_category.value="";
			var oth_alcn_criteria=parent.display_message.document.other_alcn_form.oth_alcn_criteria.value;
			var oth_time_table_type=parent.display_message.document.other_alcn_form.oth_time_table_type.value;
			var oth_max_patients_per_day=parent.display_message.document.other_alcn_form.oth_max_patients_per_day.value;
			parent.display_allocation.location.href="../../eOA/jsp/AddPatientCategoryResult.jsp?groupvalues="+finalValue;
			parent.display_message.location.href="../../eOA/jsp/OthersCategoryMessage.jsp?step=2&alcn_criteria="+oth_alcn_criteria+"&time_table_type="+oth_time_table_type+"&max_patients_per_day="+oth_max_patients_per_day+"&finalValue="+finalValue+"&otherCount="+otherCount;
		}
	}

if(modify =='Y'){

	var finalValue=parent.display_allocation.result_form.finalValue.value;//groups already in the result frame
		if(finalValue!=""){
			var finalValueTokens=finalValue.split("|");
			var tokenCount=finalValueTokens.length;
			var finalValuesTokens1 = "";
			for(var cnt=0;cnt<tokenCount;cnt++){
				var valToken=finalValueTokens[cnt];
				var grpToken=valToken.split("$");
				var modify_slots = grpToken[1] ;
	
				if(pat_category==grpToken[0]){
					//alert('category already exists')
					addFlag=true;
					modify_slots =  no_solts ;
				}

				finalValuesTokens1=finalValuesTokens1+"|"+grpToken[0]+"$"+modify_slots+"$"+grpToken[2];
				count=eval(count)+eval(modify_slots);
			
			}
		}

	if(finalValue==""){
			finalValue=pat_category+"$"+no_solts+"$"+selText;
			otherCount=eval(max_patients_per_day)-eval(no_solts);
			if(eval(no_solts) > eval(max_patients_per_day)){
				//parent.parent.messageFrame.location.href="../eCommon/jsp/error.jsp?err_num=Max slots or greater&err_value=1"
				addFlag=false;
				alert(getMessage('TOT_ALCN_NOT_GT_MX_PAT_DAY','OA'));
			}
		}else{
				if(eval(count) > eval(max_patients_per_day)){
				addFlag=false;
				alert(getMessage('TOT_ALCN_NOT_GT_MX_PAT_DAY','OA'));
			}
			if(addFlag){
				otherCount=eval(max_patients_per_day)-eval(count);
				finalValue=finalValuesTokens1;
			}
		}
		if(addFlag){
			document.alcn_add_form.no_solts.value="";
			document.alcn_add_form.pat_category.value="";
			var oth_alcn_criteria=parent.display_message.document.other_alcn_form.oth_alcn_criteria.value;
			var oth_time_table_type=parent.display_message.document.other_alcn_form.oth_time_table_type.value;
			var oth_max_patients_per_day=parent.display_message.document.other_alcn_form.oth_max_patients_per_day.value;
			document.alcn_add_form.modify.value='N';
			document.alcn_add_form.Add.value = 'Add';
			
			parent.display_allocation.location.href="../../eOA/jsp/AddPatientCategoryResult.jsp?groupvalues="+finalValue;
			parent.display_message.location.href="../../eOA/jsp/OthersCategoryMessage.jsp?step=2&alcn_criteria="+oth_alcn_criteria+"&time_table_type="+oth_time_table_type+"&max_patients_per_day="+oth_max_patients_per_day+"&finalValue="+finalValue+"&otherCount="+otherCount;
		}
}
}

function closealcnwindow(){
	var otherCount = 0;
	if(parent.display_allocation.result_form.finalValue.value!=""){
		var retAlcn=parent.display_allocation.result_form.finalValue.value;

		var retAlcnArr=retAlcn.split("|");
		var retAlcnCnt=retAlcnArr.length;
		var finalAlcnArr="";
		var cnt=0;
		var deletFlag=false;
		otherCount=parent.display_message.other_alcn_form.otherCount.value;
		for(var cnt1=0;cnt1<retAlcnCnt;cnt1++){
			if(eval("parent.display_allocation.result_form.delete"+cnt1).checked){
				if(cnt=='0'){
					if(window.confirm("Do You Want to delete Record?")){
						deletFlag=true;
						cnt++;
					}else{
						deletFlag=false;
						cnt++;
					}
				}
			}

		}
		cnt=0;
		for(var cnt1=0;cnt1<retAlcnCnt;cnt1++){
			var groupArr=retAlcnArr[cnt1];
			var valueArr=groupArr.split("$");
			var alcnCatCode=valueArr[0];
			var alcnCatSLotNo=valueArr[1];
			var alcnCatDesc=valueArr[2];
			if(eval("parent.display_allocation.result_form.delete"+cnt1).checked && deletFlag){
				otherCount=eval(otherCount)+eval(alcnCatSLotNo);
			}else{
				if(cnt==0){
					finalAlcnArr=alcnCatCode+"$"+alcnCatSLotNo+"$"+alcnCatDesc;
					cnt++;
				}else{
					finalAlcnArr=finalAlcnArr+"|"+alcnCatCode+"$"+alcnCatSLotNo+"$"+alcnCatDesc;
				}
			}
		}
		window.returnValue=finalAlcnArr+"|OTH$"+otherCount+"$Others";
	}else{
		window.returnValue="OTH$"+otherCount+"$Others";
	}
	window.close();
}

function clearGroup()
{
	document.alcn_add_form.reset();
	document.alcn_add_form.Add.value='Add';

}

function CheckForSpecChar(event)
{
    var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	
	return true ;
 }

 function CheckLimit(obj)
 {	 
	 if(obj.value=='0' || obj.value=='00' || obj.value=='000'){
		 		var msg=getMessage("AM0170","AM");
				msg=msg.replace("$",getLabel('eOA.NoofSlots.label','oa_labels'));
				alert(msg);
				obj.value='';
				obj.focus();
	 }
 }
 function CheckForNumber(obj) {
   var sequence = "0123456789";
   var obj_value = obj.value;
   var obj_length = obj_value.length;

   for (i=0; i<obj_length; i++)   {
        if(sequence.indexOf(obj_value.charAt(i))==-1){
			var msg=getMessage("NUM_ALLOWED","SM");			
			alert(msg);
			obj.value='';
			obj.focus();			
			return false;
		}
   }

   return true ;
}
