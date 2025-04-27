 function create() {
	f_query_add_mod.location.href = "../../eIP/jsp/AddModifyBedClass.jsp" ;
}

function query() {
	f_query_add_mod.location.href ="../../eIP/jsp/BedClassQueryCriteria.jsp" ;
}

function checkIsValidForProceed(){
	var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
}
function apply() 
{
	 if (! (checkIsValidForProceed())){
		parent.frames[2].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}else
	{
	var fields = new Array (f_query_add_mod.document.BedClass_form.bed_class_code);
	
	var names  =  new Array ( getLabel('eIP.BedClassCode.label','IP') );
	
	//var messageFrame = parent.frames[1].frames[2]; 
	var messageFrame = frames[2]; 
	
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page))
	{  


	var fields=new Array();
	if(f_query_add_mod.document.BedClass_form.percent_amt_ind_surgery.value == 'P' || f_query_add_mod.document.BedClass_form.percent_amt_ind_surgery.value == 'A' )
	{
		fields[0] = f_query_add_mod.document.BedClass_form.bed_class_code;
		fields[1] = f_query_add_mod.document.BedClass_form.long_desc;
		fields[2] = f_query_add_mod.document.BedClass_form.short_desc;
		fields[3] = f_query_add_mod.document.BedClass_form.label_text;

		var text = f_query_add_mod.document.getElementById("label").innerText;
		var names = new Array (	getLabel('Common.code.label','common'),getLabel('Common.longdescription.label','common'),getLabel('Common.shortdescription.label','common'),text);
	}
	else
	{
		fields[0]= f_query_add_mod.document.BedClass_form.bed_class_code;
		fields[1]= f_query_add_mod.document.BedClass_form.long_desc;
		fields[2]= f_query_add_mod.document.BedClass_form.short_desc;

		var names = new Array (	getLabel('Common.code.label','common'),
														getLabel('Common.longdescription.label','common'),
														getLabel('Common.shortdescription.label','common')
												   );
	}
	
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){
		f_query_add_mod.document.BedClass_form.percent_amt_ind_surgery.disabled = false;

		//added on 29-09-2003 by dhanasekaran
		f_query_add_mod.document.BedClass_form.ALLOW_BED_SWAP_YN.disabled = false;
		//end addition

		f_query_add_mod.document.BedClass_form.submit();
	}	 
   }	
}

}


function onSuccess() {

	if(f_query_add_mod.document.BedClass_form.function_name.value =="insert"){
		f_query_add_mod.document.BedClass_form.reset();
		f_query_add_mod.document.BedClass_form.bed_class_code.focus();
		}
		else
		f_query_add_mod.document.location.reload();
}


function reset() {
			if (! (checkIsValidForProceed())){
		parent.frames[2].frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}else{
			if(f_query_add_mod.document.forms[0].name == "BedClass_form"){
					f_query_add_mod.document.BedClass_form.reset();
					f_query_add_mod.document.BedClass_form.bed_class_code.focus();
				}	
					
			if(f_query_add_mod.document.forms[0].name == "query_form")
					f_query_add_mod.document.query_form.reset() ;
	}
}


function calculateAmount(obj)	{
		if(obj.value != '')
		{
			if(!(self.CheckNum(obj) == false))
			{
					var peramt = self.document.BedClass_form.percent_amt_ind_surgery.value;
					var depoamt = self.document.BedClass_form.deposit_amt_normal.value;
					
					if( depoamt == '' || depoamt == ' ')
					{
						alert(parent.parent.parent.frames[0].getMessage("SHOULD_NOT_BE_BLANK","common"));
						self.document.BedClass_form.deposit_amt_normal.focus();
					}
					else
					{
						if(peramt == 'P')
						{
							var amt = (depoamt * self.document.BedClass_form.label_text.value)/100;
							self.document.BedClass_form.deposit_charge_surgery.value = amt;
						}
						else
							self.document.BedClass_form.deposit_charge_surgery.value = self.document.BedClass_form.label_text.value;
					}
			}
		}
}


function setLegend(obj){
	self.document.BedClass_form.deposit_charge_surgery.value = '';
	self.document.BedClass_form.label_text.value = '';
	var val = obj.value;
	if(val != '')
	{
		self.document.BedClass_form.label_text.readOnly = false;
		if( val == 'P')
			self.document.getElementById("label").innerText = getLabel('eIP.PercentageonDepositAmount.label','IP');
		else 
			self.document.getElementById("label").innerText = getLabel('Common.amount.label','common');
	}
	else
	{
		self.document.BedClass_form.label_text.readOnly = true;
		self.document.getElementById("label").innerText = getLabel('eIP.PercentAmount.label','IP');
		self.document.BedClass_form.label_text.value = '';
		self.document.BedClass_form.deposit_charge_surgery.value = '';
	}

}


function chkCalculate(obj){
		if(!(self.CheckNum(obj) == false))
		{
			if(obj.value == '' &&  self.document.BedClass_form.percent_amt_ind_surgery.value != '' )
			{
				alert(parent.parent.parent.frames[0].getMessage("SHOULD_NOT_BE_BLANK","common"));
				obj.focus();
			}
			else if(self.document.BedClass_form.percent_amt_ind_surgery.value != '' &&  self.document.BedClass_form.percent_amt_ind_surgery.value == 'P')
			{
				var amt = (obj.value * self.document.BedClass_form.label_text.value)/100;
				self.document.BedClass_form.deposit_charge_surgery.value = amt;
			}
			else if(self.document.BedClass_form.percent_amt_ind_surgery.value != '' &&  self.document.BedClass_form.percent_amt_ind_surgery.value == 'A')
				self.document.BedClass_form.deposit_charge_surgery.value = self.document.BedClass_form.label_text.value;

		}
}


function setLabelText(){
	var val = self.document.BedClass_form.percent_amt_ind_surgery.value;
	if(val != '')
	{
		if(self.document.BedClass_form.eff_status.checked == false)
			self.document.BedClass_form.label_text.readOnly = true;
		else
			self.document.BedClass_form.label_text.readOnly = false;
		if( val == 'P'){
			self.document.getElementById("label").innerText = getLabel('eIP.PercentageonDepositAmount.label','IP');
			self.document.BedClass_form.label_text.value = ((100*self.document.BedClass_form.deposit_charge_surgery.value)/self.document.BedClass_form.deposit_amt_normal.value );
		}
		else {
			self.document.getElementById("label").innerText = getLabel('Common.amount.label','common');
			self.document.BedClass_form.label_text.value = self.document.BedClass_form.deposit_charge_surgery.value;
		}
	}
	else
	{
		self.document.BedClass_form.label_text.readOnly = true;
		self.document.getElementById("label").innerText = getLabel('eIP.PercentAmount.label','IP');
		self.document.BedClass_form.label_text.value = '';
	}
}

//added from AddModifyBedClass.jsp

function focusTxt()
{	
	document.BedClass_form.bed_class_code.focus();
}

//function added on 29-09-2003 by dhanasekaran
function checkBedStatus()
{
	if ( BedClass_form.eff_status.checked == false)
	{
		/*if(BedClass_form.bed_count.value > 0) Thursday, October 01, 2009 IN015003*/
		if(BedClass_form.bed_count.value > 0 || BedClass_form.bedtype_count.value > 0)
		{
			alert(getMessage("BED_CLASS_ASSOCIATED","IP"));
			BedClass_form.eff_status.checked = true ;
			return;
		}
	}
}
