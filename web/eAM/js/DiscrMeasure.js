function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/DiscrMeasureAddModify.jsp" ;
}

function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/DiscrMeasureQueryCriteria.jsp";
}

function apply() {
	//var messageFrame = parent.frames[1].frames[2]; 
	var messageFrame = frames[2]; 
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	var fieldsforspchar = new Array( f_query_add_mod.document.DiscrMeasure_form.discr_measure_id
															 );
	var namesforspchar = new Array(getLabel("Common.DiscreteMeasure.label","Common")+" "+getLabel("Common.identification.label","Common"));

	var fields = new Array ( f_query_add_mod.document.DiscrMeasure_form.discr_measure_id,
							f_query_add_mod.document.DiscrMeasure_form.long_desc,
							f_query_add_mod.document.DiscrMeasure_form.short_desc,
							f_query_add_mod.document.DiscrMeasure_form.service,
							f_query_add_mod.document.DiscrMeasure_form.result_type
						);
	var names = new Array (	getLabel("Common.DiscreteMeasure.label","Common")+" "+getLabel("Common.identification.label","Common"),
							 getLabel("Common.longdescription.label","Common"),
							 getLabel("Common.shortdescription.label","Common"),
							 getLabel("Common.service.label","Common"),
							 getLabel("Common.ResultType.label","Common")
												);

	if(f_query_add_mod.SpecialCharCheck(fieldsforspchar,namesforspchar,messageFrame,"M", error_page))
	{
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		{
//alert(f_query_add_mod.document.DiscrMeasure_form.numeric_details_values.value);		
//alert(f_query_add_mod.document.DiscrMeasure_form.alpha_info_values.value);	
			if(f_query_add_mod.document.DiscrMeasure_form.result_type.value == 'N' && validateMaxMinDec() == false)
				messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='
			else if(f_query_add_mod.document.DiscrMeasure_form.result_type.value == 'N' && validateRefCritical() == false)
				messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='
			else
			{
				f_query_add_mod.document.DiscrMeasure_form.service.disabled = false;
				f_query_add_mod.document.DiscrMeasure_form.free_text_template.disabled = false;
				f_query_add_mod.document.DiscrMeasure_form.submit();
			}
		}
	}
}

function onSuccess() {
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		create();
	else
         f_query_add_mod.location.reload();
}

function reset() {
	if(f_query_add_mod.document.forms[0]) 
		f_query_add_mod.document.forms[0].reset();

	//else 
		//f_query_add_mod.location.reload();
}

function CheckPositiveNumberLocal(obj) {
	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) 
	{		
	}
	else {
  		if ( obj.value.length < 0 ) 
		{
  			//alert("APP-SM0050 - Value should be greater than equal to ZERO");
  			
			obj.select();
  			obj.focus();
  		}
  	}
}



function validateRefCritical()
{
	var reflow = eval(f_query_add_mod.document.getElementById('ref_low').value)==null?0:eval(f_query_add_mod.document.getElementById('ref_low').value);
	var refhigh = eval(f_query_add_mod.document.getElementById('ref_high').value)==null?0:eval(f_query_add_mod.document.getElementById('ref_high').value);
	var critlow = eval(f_query_add_mod.document.getElementById('critical_low').value)==null?0:eval(f_query_add_mod.document.getElementById('critical_low').value);
	var crithigh = eval(f_query_add_mod.document.getElementById('critical_high').value)==null?0:eval(f_query_add_mod.document.getElementById('critical_high').value);
	if(reflow!=0 && refhigh!=0 && reflow > refhigh)
	{
		alert(self.getMessage('REF_LOW_NOT_GREATER_HIGH','AM'));
		f_query_add_mod.document.getElementById('ref_high').select();
		f_query_add_mod.document.getElementById('ref_high').focus();
		return false;
	}
	else if(critlow!=0 && crithigh!=0 && critlow > crithigh)
	{
		alert(self.getMessage('CRITICAL_LOW_NOT_GREATER_HIGH','AM'));
		f_query_add_mod.document.getElementById('critical_high').select();
		f_query_add_mod.document.getElementById('critical_high').focus();
		return false;
	}
	else
	{
		if(critlow!=0 && reflow!=0 && critlow > reflow)
		{
			alert(self.getMessage('CRITICAL_LOW_LESS_REF_LOW','AM'));
			f_query_add_mod.document.getElementById('critical_low').select();
			f_query_add_mod.document.getElementById('critical_low').focus();
			return false;
		}
		else if(crithigh!=0 && refhigh!=0 && crithigh < refhigh)
		{
			alert(self.getMessage('CRITICAL_HIGH_GREATER_REF_HIGH','AM'));
			f_query_add_mod.document.getElementById('critical_high').select();
			f_query_add_mod.document.getElementById('critical_high').focus();
			return false;
		}
		else return true;
	}
}

function validateNumber(obj)
{
	if(CheckNum(obj))
	{
		var n = obj.value;
		var num = n.length;
		var frac = 0;
		if((n.indexOf(".")) >= 0)
		{
			var arr =  new Array();
			arr = n.split(".");
			num = arr[0].length;
			frac = arr[1].length;
			num += frac
		}

		var maxlen = eval(document.getElementById('max').value)
		var minlen = eval(document.getElementById('min').value)
		var preci = eval(document.getElementById('decimal').value)
//alert(maxlen+"  "+minlen+"  "+preci+"  "+n.indexOf("."));
		if(maxlen!=0 && minlen!=0 && minlen > maxlen){
			alert(parent.getMessage('MIN_LESS_THAN_MAX','AM'));
			document.getElementById('min').focus();
			return false;
		}
		else if(preci > (maxlen-minlen)){
			alert(parent.getMessage('INVALID_DEC_VAL','AM'));
			document.getElementById('decimal').focus();
			return false;
		}
		else if(maxlen!=0 && num > maxlen){
			alert(parent.getMessage('MAXIMUM_DIGITS','AM')+' '+maxlen);
			obj.value="";
			obj.focus();
			return false;
		}
		else if(minlen!=0 && num < minlen){
			alert(parent.getMessage('MINIMUM_DIGITS','AM')+' '+minlen);
			obj.value="";
			obj.focus();

			return false;
		}
		/*else if((preci==0 || preci==null ) && (n.indexOf(".") >= 0))
		{
			alert(parent.getMessage('NO_DECIMAL'));
			obj.focus();
			return false;
		}*/
		else if (preci!=null && preci!=0 && frac > preci ){
			alert(parent.getMessage('INVALID_PRECISION','AM'));
			obj.focus();
			return false;
		}
		else 
			return true;
	}
	else
		return false;
}
function validateMinmax(obj)
{
	if(CheckNum(obj))
	{
		var n = obj.value;
		var num = n.length;
		var maxlen = eval(document.getElementById('max').value)
		var minlen = eval(document.getElementById('min').value)	

		if(maxlen!=0 && minlen!=0 && minlen > maxlen){
			alert(parent.getMessage('MIN_LESS_THAN_MAX','AM'));
			document.getElementById('min').value="";
			document.getElementById('min').focus();
			return false;
		}	
	
		else 
			return true;
	}
	else
		return false;
}
function validateDeci(obj)
{
	if(CheckNum(obj))
	{		
		var maxlen = eval(document.getElementById('max').value)
		var minlen = eval(document.getElementById('min').value)
		var preci = eval(document.getElementById('decimal').value)

		 if(preci > (maxlen-minlen)){
			alert(parent.getMessage('INVALID_DEC_VAL','AM'));
			document.getElementById('decimal').value=""
			document.getElementById('decimal').focus();
			return false;
		}
		
		else 
			return true;
	}
	else
		return false;
}
function validateMaxMinDec(val)
{
	var f = '';
	if (val == 'BU')
		f = parent.f_query_add_mod;
	else
		f = f_query_add_mod;
	
	var maxlen = "";
	var minlen  = "";
	var preci = "";
	var dflt_val = "";

	maxlen = f.document.DiscrMeasure_form.document.getElementById('max').value
	minlen = f.document.DiscrMeasure_form.document.getElementById('min').value
	preci = f.document.DiscrMeasure_form.document.getElementById('decimal').value
	dflt_val = f.document.DiscrMeasure_form.document.getElementById('default_val').value

	
	if( dflt_val  != '' ){
		if(maxlen == '' || minlen =='' ) {
			alert(top.header.getMessage('MAX_MIN_MANDATORY','AM'));
			return false;
		}
	}	

	if(maxlen!=0 && minlen >= 0 && minlen > maxlen){
		alert(top.header.getMessage('MIN_LESS_THAN_MAX','AM'));
		f.document.DiscrMeasure_form.document.getElementById('min').focus();
		return false;
	}
	else if(preci > (maxlen-minlen)){
		alert(top.header.getMessage('INVALID_DEC_VAL','AM'));
		f.document.DiscrMeasure_form.document.getElementById('decimal').focus();
		return false;
	}
	else return true;
}

async function showNumericDetails()
{
	var discrmeasure = self.document.forms[0].discr_measure_id.value
	if(validateMaxMinDec('BU') == true)
	{
		var dialogHeight ='18' ;
		var dialogWidth = '40' ;
		var dialogTop	= '315';
		var dialogLeft = '157' ; 

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
		var arguments = "";
		var convals = parent.frames[1].document.forms[0].numeric_details_values.value;
		var maxmindec = (document.getElementById('max').value==''?'0':document.getElementById('max').value)+"$"+(document.getElementById('min').value==''?'0':document.getElementById('min').value)+"$"+(document.getElementById('decimal').value==''?'0':document.getElementById('decimal').value)
		var retVals = await window.showModalDialog('../../eAM/jsp/DiscrMeasureModalFrames.jsp?from=N&discr_measure='+discrmeasure+'&con_vals='+convals+'&max_min_dec='+maxmindec,arguments,features);
//alert(retVals);
		if(retVals !=null)
			parent.frames[1].document.forms[0].numeric_details_values.value=retVals;
	}
}

async function getAlphaInfo()
{
	var discrmeasure = self.document.forms[0].discr_measure_id.value
	
	/*if(discrmeasure != '')
	{*/
		var dialogHeight ='19' ;
		var dialogWidth = '40' ;
		var dialogTop	= '291';
		var dialogLeft = '157' ; 

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
		var arguments = "";
		var convals = parent.frames[1].document.forms[0].alpha_info_values.value;
		
		//added on 31-10-2003 by dhanasekaran ('+' character is not going when it is passed as query string)
		while(convals.indexOf('+')!=-1)
		{
			convals = convals.replace("+", "¤");
		}
		//end addition
			
		var retVals = await window.showModalDialog("../../eAM/jsp/DiscrMeasureModalFrames.jsp?from=A&discr_measure="+discrmeasure+"&con_vals="+escape(convals) + "&abc=Y",arguments,features);
		//window.open('../../eAM/jsp/DiscrMeasureModalFrames.jsp?from=A&discr_measure='+discrmeasure+'&con_vals='+convals,arguments,features);
		
		if(retVals !=null)
			parent.frames[1].document.forms[0].alpha_info_values.value=retVals;
	/*}
	else
	{
		alert('Discr Measure ID to be entered');
		parent.frames[1].document.forms[0].discr_measure_id.focus();
	}*/
}

//DiscrMeasure AddModify
		function resetFields()
			{
				document.getElementById('max').value = '';
				document.getElementById('min').value = '';
				document.getElementById('decimal').value = '';
				document.getElementById('ref_low').value = '';
				document.getElementById('ref_high').value = '';
				document.getElementById('critical_low').value = '';
				document.getElementById('critical_high').value = '';
				document.getElementById('default_val').value = '';
				document.getElementById('unit_of_measure').value = '';
				document.getElementById('free_text_template').value = '';
				document.getElementById('alpha_info_values').value = '';
				document.getElementById('numeric_details_values').value = '';
				document.getElementById('ref_ranges').value='S'
			}

			function showHideFields(val,resetyn)
			{
				if(resetyn == 'Y')  resetFields();
				
				if(val == 'L')
					document.getElementById('alpha_info').style.visibility = 'visible'
				else
					document.getElementById('alpha_info').style.visibility = 'hidden'

				if(val == 'F')
					document.getElementById('free_text').style="display";
				else
					document.getElementById('free_text').style.display= 'none';

				if(val == 'N')
				{
					document.getElementById('tr1').style="display";
					document.getElementById('tr2').style="display";
					document.getElementById('tr3').style="display";
					document.getElementById('tr4').style="display";
					document.getElementById('tr5').style="display";
					document.getElementById('tr6').style="display";
					document.getElementById('tr7').style="display";
				}
				else
				{
					document.getElementById('tr1').style.display= 'none';
					document.getElementById('tr2').style.display= 'none';
					document.getElementById('tr3').style.display= 'none';
					document.getElementById('tr4').style.display= 'none';
					document.getElementById('tr5').style.display= 'none';
					document.getElementById('tr6').style.display= 'none';
					document.getElementById('tr7').style.display= 'none';
				}
				document.getElementById('numeric_details').style.visibility = 'hidden'
			}

			function initFields()
			{
				document.getElementById('tr1').style.display= 'none';
				document.getElementById('tr2').style.display= 'none';
				document.getElementById('tr3').style.display= 'none';
				document.getElementById('tr4').style.display= 'none';
				document.getElementById('tr5').style.display= 'none';
				document.getElementById('tr6').style.display= 'none';
				document.getElementById('tr7').style.display= 'none';
				document.getElementById('free_text').style.display= 'none';
				document.getElementById('alpha_info').style.visibility = 'hidden';
			}

			function setNumericFields(val)
			{
				if(val == 'M')
				{
					document.getElementById('ref_low').value = '';
					document.getElementById('ref_high').value = '';
					document.getElementById('critical_low').value = '';
					document.getElementById('critical_high').value = '';
					document.getElementById('default_val').value = '';
					document.getElementById('unit_of_measure').value = '';

					document.getElementById('tr3').style.display= 'none';
					document.getElementById('tr4').style.display= 'none';
					document.getElementById('tr5').style.display= 'none';
					document.getElementById('tr6').style.display= 'none';
					document.getElementById('tr7').style.display= 'none';

					document.getElementById('numeric_details').style.visibility = 'visible'
				}
				else if(val == 'S')
				{
					document.getElementById('tr3').style="display";
					document.getElementById('tr4').style="display";
					document.getElementById('tr5').style="display";
					document.getElementById('tr6').style="display";
					document.getElementById('tr7').style="display";

					document.getElementById('numeric_details').style.visibility = 'hidden'
				}
			}
