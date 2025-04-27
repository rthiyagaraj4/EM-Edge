function reset() {
	f_query_add_mod.location.href = "../../eOA/jsp/AddModifyApptsrlInsert.jsp" ;
}

function create() {	
	f_query_add_mod.location.href = "../../eOA/jsp/AddModifyApptsrlInsert.jsp" ;
}

function apply(){
	var fields=new Array();		
		
	f_query_add_mod.document.appt_form.next_srl_no.value=f_query_add_mod.document.appt_form.next_srl_no1.value;
	f_query_add_mod.document.appt_form.max_srl_no.value=f_query_add_mod.document.appt_form.max_srl_no1.value;

		
	var p_srl=	f_query_add_mod.document.appt_form.old_srl_no.value;
	
	var p_max=f_query_add_mod.document.appt_form.old_max_no.value;
	var c_srl=f_query_add_mod.document.appt_form.next_srl_no.value;
	var c_max=f_query_add_mod.document.appt_form.max_srl_no.value
	var concat="Previous Values : "+p_srl+"/"+p_max+"     Current Values :"+c_srl+"/"+c_max;
		
	f_query_add_mod.document.appt_form.remark.value=concat;		
	
	fields[0]= f_query_add_mod.document.appt_form.next_srl_no1;
	fields[1]= f_query_add_mod.document.appt_form.max_srl_no1;


	var names = new Array (	getLabel("Common.nextsrlno.label","Common"),
							getLabel("Common.maxserialno.label","Common")
						);

	if(f_query_add_mod.checkFields( fields, names, messageFrame)){
		var  holarr =  new Array ( f_query_add_mod.document.appt_form.next_srl_no1,
							f_query_add_mod.document.appt_form.max_srl_no1);
		
			
		var c_srl=f_query_add_mod.document.appt_form.next_srl_no1.value;
		var c_max=f_query_add_mod.document.appt_form.max_srl_no1.value;

		var n_c_no=parseInt(c_srl);
		var m_no=parseInt(c_max);
		var old_next_srl_no=parseInt(f_query_add_mod.document.forms[0].old_srl_no.value);

		if(m_no < n_c_no){	
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage('NXT_SRL_NOT_LESS_MAX','OA');
			f_query_add_mod.document.appt_form.next_srl_no1.focus();
		}else{		
			f_query_add_mod.document.forms[0].submit();
		}
	}
}


function allowValidNumber(fld, e, maxInt, deci){
	var count=fld.value.length;
	var whichCode = (window.Event) ? e.which : e.keyCode;

	if(count>=maxInt){
		if(count==maxInt){
		    var dotOccurance = fld.value.indexOf('.');
			if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt))	{
				if(whichCode!=46){
					return false;
				}
			}
		}else if(count>maxInt){
			var objectValue = fld.value;
		    var dotOccurance = objectValue.indexOf('.');

			if((objectValue.charAt(maxInt))!='.'){
				if(dotOccurance==-1){
					fld.value = objectValue.substring(0,maxInt)+".";
					return false;
				}
			}
		}
	}

	if (parseInt(deci)==1)//For Minus,Decimal Point and 0-9
	  var strCheck = '.0123456789-';
	else if (parseInt(deci)==2) //For Decimal Point and 0-9
	{
	   var strCheck = '.0123456789';
	}
	else if (parseInt(deci)==0)//For Only Nos 0 - 9
	{
		var strCheck = '0123456789';
	}
	else if (parseInt(deci)==3)//For Minus and 0-9 Only
	{
		var strCheck = '0123456789-';
	}

	if (parseInt(deci)==1)
	{
		var fldvalue=fld.value;
		if (whichCode == 45 && (fldvalue.length==0)) return true;  // minus 
		if (whichCode == 45 && (fldvalue.length>0)) return false;  // minus 
	}

	var fldvalue=fld.value;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) return true;  // Enter
	var pointCount=0;
	for(var i=0;i<fldvalue.length;i++)
	{
		if(fldvalue.charAt(i)=='.') pointCount++;
	}
	if (pointCount>0 && whichCode == 46) return false;

	var fldValue	=	fld.value;
	var dotIndex	=	fldValue.indexOf(".");
	var fldLength	=	fldValue.length;

	if(dotIndex!=-1)
		if( fldLength > (dotIndex+3) ) return false;

	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true;
}

function onSuccess(){ // dummy function to handle script errors
}
