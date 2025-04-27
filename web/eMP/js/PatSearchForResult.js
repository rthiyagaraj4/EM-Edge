function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eMP/jsp/PatSearchResultFormatQuery.jsp?function=Patient Search For Result" ;
}

function apply()
{
	
 if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	
	
	var fields = new Array ();
	fields[0]=f_query_add_mod.document.patient_form.long_desc;
	var names = new Array ();
	names[0]=getLabel('eMP.FieldTitle.label','MP');

	if(f_query_add_mod.document.patient_form.select1.checked)
	{
		f_query_add_mod.document.patient_form.order1.disabled=false;
		fields[1]=f_query_add_mod.document.patient_form.order1;
		names[1]=getLabel('eMP.Ordernumber.label','MP');
	}
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
		var cc=true;
		if(f_query_add_mod.document.patient_form.order3.value!='readonly')
			cc=chkOrder();
		if(cc)
		{
			var order = f_query_add_mod.document.patient_form.order1.value;
			var fldnm = f_query_add_mod.document.patient_form.fld_nm.value;

/*			if (order == "")
			{
				order = 0;
			}
*/
			if (f_query_add_mod.document.patient_form.select1.checked==true)
			{
			
				var HTMLVal = new String();
					HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/OrderCheck.jsp'><input type='hidden' name='order' id='order' value='"+order+"'>"+
					"<input type='hidden' name='fldnm' id='fldnm' value='"+fldnm+"'>"+ "</form></BODY></HTML>"; 
					messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
					messageFrame.document.form1.submit();
			}
			else if (f_query_add_mod.document.patient_form.select1.checked==false)
			{
				f_query_add_mod.document.patient_form.submit();
			}
			//f_query_add_mod.document.patient_form.submit();
			//f_query_add_mod.location.href ="../../eCommon/html/blank.html" ;
		}
	}
}

function reset()
{

	if(f_query_add_mod.document.forms[0].name == "patient_form") 
	{
//		f_query_add_mod.document.patient_form.reset() ;
		f_query_add_mod.location.reload() ;
		if (f_query_add_mod.document.patient_form.select1.checked == false)
		{
			f_query_add_mod.document.patient_form.order1.disabled=true;
			f_query_add_mod.document.patient_form.order1.value ="";
		}
		else if (f_query_add_mod.document.patient_form.select1.checked == true)
		{
			f_query_add_mod.document.patient_form.order1.disabled=false;
		}
	}
	//else f_query_add_mod.document.query_form.reset() ;
}

function chkOrder()
{
	var bool=true;
	var s=""
	var num=f_query_add_mod.document.patient_form.order1.value;
	start = f_query_add_mod.document.patient_form.start.value;
	stop = f_query_add_mod.document.patient_form.stop.value;
	if(num!="")
	{
		if(!isNaN(num))
		{
			num=parseInt(num)
			if(num<start)
			{
				bool=false;
				s=f_query_add_mod.getMessage("ORDER_NOT_LESS_ZERO",'MP');
			}
			else
			{
				if(num>stop)
				{
				bool=false;
				s= f_query_add_mod.getMessage("ORDER_BET",'MP');
				s = s.replace('$', start);
				s = s.replace('#', stop);				
				}
			}
		}
	}

	messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+s;
	return bool
}

function onSuccess()
{

//	f_query_add_mod.document.forms[0].reset();
}
var i=0;
function clk()
{
	if (patient_form.fld_nm.value !='Pat_Photo')
	{
		if (patient_form.select1.checked == false)
		{
			patient_form.order1.disabled=true;
			patient_form.order1.value ="";
		}
		else if (patient_form.select1.checked == true)
		{
			patient_form.order1.disabled=false;
		}
	}
	else
		patient_form.order1.value = '<%=maxVal%>';
/*	var prop="";
	//var prop='<%=rdonly%>'
	//if(!patient_form.select1.checked)
	//	patient_form.order1.value=""

	i++;
	var newval=patient_form.long_desc.value
	var oldval=patient_form.long_desc1.value

	var onval=patient_form.order1.value
	var ooval=patient_form.order2.value

	if(prop=="readonly" && patient_form.select1.checked)
		patient_form.order1.value='<%=(maxVal)%>';
	else
	{
		if(i>1 && oldval!=newval)
		{
			patient_form.long_desc.value=patient_form.long_desc1.value
		}
		if(i>1 && ooval!=onval)
		{
			patient_form.order1.value=patient_form.order2.value
			if(!patient_form.select1.checked)
			patient_form.order1.value=""
		}
	}*/
}

function chkk(comp)
{
/*	//var prop='<%=rdonly%>'
	var prop="";
	if(!patient_form.select1.checked)
	{
		comp.blur();patient_form.order1.value=""
	}
	else
		if(prop=="readonly")
			patient_form.order1.value='18';
*/
}
function checkIsValidForProceed()
{

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}

