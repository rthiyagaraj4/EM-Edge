function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyEncounter.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/queryEncounter.jsp" ;
}

function apply() {

	//var year=f_query_add_mod.document.encounter_form.year.value;
	var next1=f_query_add_mod.document.encounter_form.next_num.value;
	var fields = new Array ( f_query_add_mod.document.encounter_form.next_num);
	var names = new Array ( getLabel("eAM.NextNumber.label","AM"));

	/*
	var transform = new Array (f_query_add_mod.document.encounter_form,
				   f_query_add_mod.document.encounter_form.eff_date_from,
				   f_query_add_mod.document.encounter_form.eff_date_from1,
				  f_query_add_mod.document.encounter_form.eff_date_to,
				  f_query_add_mod.document.encounter_form.eff_date_to1);
	*/
	
		var spFields = new Array (f_query_add_mod.document.encounter_form.next_num);
		var spNames = new Array (getLabel("eAM.NextNumber.label","AM"));
		var error_page="../../eCommon/jsp/MstCodeError.jsp"
	if(SpecialCharCheck (spFields,spNames,messageFrame,"M",error_page))
	{	
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		{
			//var b=isValidYr(year,next1);
			var cont = true;
			if(f_query_add_mod.document.encounter_form.function_name.value=="insert")
			{
				if (parseInt(next1) < 10000000)
				{
					 cont = false;
					 messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("NEXT_NUM_START","AM");
				}
			}
			if(cont==true)
			{
				f_query_add_mod.document.encounter_form.submit();
				var fn_status = f_query_add_mod.document.encounter_form.function_name.value;
				if(fn_status == "insert") {}// f_query_add_mod.document.encounter_form.reset();
			}
		commontoolbarFrame.src="../../eCommon/jsp/MstCodeToolbar.jsp"
		}	
	}
}

function onSuccess() {
	if(f_query_add_mod.document.encounter_form.function_name.value=="insert")
	{
	//f_query_add_mod.document.encounter_form.year.value		= "" ;
	f_query_add_mod.document.encounter_form.next_num.value		= "" ;
	/*
	f_query_add_mod.document.encounter_form.eff_date_from.value	= "" ;
	f_query_add_mod.document.encounter_form.eff_date_to.value	= "" ;
	f_query_add_mod.document.encounter_form.eff_date_from1.value	= "" ;
	f_query_add_mod.document.encounter_form.eff_date_to1.value	= "" ;
	f_query_add_mod.document.encounter_form.eff_status.checked	=true;
	*/
	}
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyEncounter.jsp" ;
}

function reset() 
{
	f_query_add_mod.document.location.reload();
	
}

function isValidYr(y,next1)
{
	var bool
	len=y.length;
	var msg=" " ;

	if(len!=4)
		{
		bool= false;
		msg=getMessage("VALID_YEAR_CHECK","AM");//"APP-OP0001  Enter Valid year"
		}
	else
	{
		y=parseInt(y)
		next1=parseInt(next1)
		var dt=new Date();
		var yr=dt.getYear();

		if(!isNaN(y))
		{
			bool=  true;
			if(y<yr)
			{
			bool= false
			msg=getMessage("YEAR_GR_CURR_YEAR_CHECK","AM");//"APP-OP0004   Year should be Greater than Current Year"
			}
			else
			{
				if(next1<0 || isNaN(next1))
				{
				  bool=false
				}
				else
				 {bool=true;}
			}
		}
		else
		{
		//msg="OP-0001  Enter Valid year"
		msg= getMessage("VALID_YEAR_CHECK","AM");
		bool=false;
		}
	}
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		return bool;
}
function allowValidNumber(fld, e, maxInt, deci)
{
	var count=fld.value.length;
	var whichCode = (window.Event) ? e.which : e.keyCode;
	if(count>=maxInt)
	{
		if(count==maxInt)
		{
		    var dotOccurance = fld.value.indexOf('.');
			//alert("dotOccurance : "+dotOccurance);
			if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt))
			{
				if(whichCode!=46)
				{
					//var errors = "APP-0001 Reached Maximum Integer value";
					var errors = getMessage("AM0126","AM");
					return false;
				}
			}
		}
		else if(count>maxInt)
		{
			var objectValue = fld.value;
		    var dotOccurance = objectValue.indexOf('.');
			//alert(objectValue.charAt(maxInt));
			if((objectValue.charAt(maxInt))!='.')
			{
				if(dotOccurance==-1)
				{
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