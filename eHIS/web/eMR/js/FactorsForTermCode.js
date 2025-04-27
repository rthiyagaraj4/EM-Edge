function create()
{
	//fact_for_term_code.rows = "42,100,*,50,0";
	document.getElementById("fram_fac_termcode_hdr").style.height = "23vh";
	document.getElementById("fram_fac_termcode_result").style.height = "60vh";
	fram_fac_termcode_hdr.location.href="../../eMR/jsp/FactorsForTermCodeHeader.jsp";
	fram_fac_termcode_result.location.href = "../../eCommon/html/blank.html";
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
}
async function gettermcodeval(target)
{
	
	var frmobj=document.factorsfortermcodeheader ;
	var term_set_id = frmobj.term_set_id.value;
	if(term_set_id != "")
	{
		//frmobj.term_code_desc.value="";
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		argumentArray[0] ="select term_code code,short_desc description from mr_term_code where term_set_id = '"+term_set_id+"' and Upper(term_code) like upper(?) and upper(short_desc) like upper(?) and eff_status = 'E' and select_yn = 'Y'";

		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2"; 
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK ;
		argumentArray[7] = CODE_DESC ;
		retVal = await CommonLookup(getLabel("Common.TermCode.label","Common"), argumentArray );
		if(retVal != null && retVal != "")
		{
			target.value = retVal[0].split(',')[1] ;
			document.factorsfortermcodeheader.term_code.value = retVal[0].split(',')[0];
		}
		else
			target.value ="";
	}
	return;
}

function getbeforetermcodeval(target)
{
	
	//if(target.value!="")
	if(trimString(target.value)!='')
	{
		gettermcodeval(target);
	}
}


function disprespg()
{
	
//	parent.blankFrame.document.fact_for_dynaval.chkselect.value = "";
	var term_set_id = document.factorsfortermcodeheader.term_set_id.value;
	var term_code = document.factorsfortermcodeheader.term_code.value;
	var fields = new Array(document.factorsfortermcodeheader.term_set_id,document.factorsfortermcodeheader.term_code);
	var names = new Array(getLabel("Common.TermSetID.label","Common"),getLabel("Common.TermCode.label","Common"));
	if(checkFieldsofMst( fields, names, parent.messageFrame))
	{
		parent.fram_fac_termcode_result.location.href = "../../eMR/jsp/FactorsForTermCodeDetail.jsp?term_set_id="+term_set_id+"&term_code="+term_code+"&flagSelect=true";
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	}
}
function chkValue(obj){
	
if(obj.value=='')
	{
	document.factorsfortermcodeheader.term_code_desc.value = "";
	document.factorsfortermcodeheader.term_code.value = "";
	parent.fram_fac_termcode_result.location.href = "../../eCommon/html/blank.html";
	parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	}
}
function clrresult(obj)
{
	
	if(obj.value!='')
	{
		document.forms[0].term_code_desc.disabled=false;
		
	}
	else
		document.forms[0].term_code_desc.disabled=true;

	document.factorsfortermcodeheader.term_code_desc.value = "";
	document.factorsfortermcodeheader.term_code.value = "";
	parent.fram_fac_termcode_result.location.href = "../../eCommon/html/blank.html";
	parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
}
function reset()
{
	var url = fram_fac_termcode_hdr.location.href;
	if(url.indexOf("Header.jsp")!=-1){
		fram_fac_termcode_hdr.location.href = "../../eMR/jsp/FactorsForTermCodeHeader.jsp";
		fram_fac_termcode_result.location.href = "../../eCommon/html/blank.html";

	}
	else
	{
fram_fac_termcode_hdr.location.reload();	}
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	//blankFrame.location.href = "../../eCommon/html/blank.html";
}
function submitPrevNext(from, to)
{
	document.FactorsForTermCodeDetail.from.value = from;
	document.FactorsForTermCodeDetail.to.value = to; 
	document.FactorsForTermCodeDetail.submit();
	parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
}
function chkallvall(obj,start,end)
{
	var term_set_id = parent.fram_fac_termcode_hdr.document.factorsfortermcodeheader.term_code_desc.value;
	var term_code = parent.fram_fac_termcode_hdr.document.factorsfortermcodeheader.term_code.value;
	if(obj.checked)
		document.FactorsForTermCodeDetail.selectall.value = "SELECTALL";
	else
		document.FactorsForTermCodeDetail.selectall.value = "";
	if(document.FactorsForTermCodeDetail.selectall.value=="SELECTALL")
	{
		for(var i=start;i<=end;i++)
		{
			if(eval("document.FactorsForTermCodeDetail.chks_factor"+i))
			{
				eval("document.FactorsForTermCodeDetail.chks_factor"+i).checked=true;
				eval("document.FactorsForTermCodeDetail.chks_factor"+i).value="U";
			}
		}
		/*var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='dyna_form' id='dyna_form' method='post' action='FactorsForTermCodeDynamicValues.jsp'><input type='hidden' name='factor_val' id='factor_val' value='FACTORSSELECTED'><input type='hidden' name='term_set_id' id='term_set_id' value='"+term_set_id+"'><input type='hidden' name='term_code' id='term_code' value='"+term_code+"'></form></BODY></HTML>";
		parent.blankFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.blankFrame.document.dyna_form.submit();*/
	}
	else
	{
		for(var i=start;i<=end;i++)
		{
			if(eval("document.FactorsForTermCodeDetail.chks_factor"+i))
			{
				eval("document.FactorsForTermCodeDetail.chks_factor"+i).checked=false;
				eval("document.FactorsForTermCodeDetail.chks_factor"+i).value="I";
			}
		}
	/*	var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='dyna_form' id='dyna_form' method='post' action='FactorsForTermCodeDynamicValues.jsp'><input type='hidden' name='factor_val' id='factor_val' value='FACTORSCLEARED'><input type='hidden' name='term_set_id' id='term_set_id' value='"+term_set_id+"'><input type='hidden' name='term_code' id='term_code' value='"+term_code+"'></form></BODY></HTML>";
		parent.blankFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.blankFrame.document.dyna_form.submit();*/
	}

}
function remchk(obj)
{
	document.FactorsForTermCodeDetail.chkall.checked = false;
	if(obj.checked)
		obj.value = "U";
	else
		obj.value = "I";
}

function apply()
{
	
	var url2 = fram_fac_termcode_result.location.href;
	
	var msg = "";
	
	if(fram_fac_termcode_result.document.FactorsForTermCodeDetail)
	{
		fram_fac_termcode_result.document.FactorsForTermCodeDetail.action = "../../servlet/eMR.FactorsForTermCodeServlet";
		fram_fac_termcode_result.document.FactorsForTermCodeDetail.target = "messageFrame";
		fram_fac_termcode_result.document.FactorsForTermCodeDetail.submit();
		onSuccess();
	}
	else
	{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		if  ( ( url2.indexOf("blank.html")!= -1 ))
		{
			msg = getMessage("APPLY_NOT_VALID",'MR');
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			msg = "";

		}
	}
}

function onSuccess()
{
	/*var term_set_id = fram_fac_termcode_hdr.document.factorsfortermcodeheader.term_set_id.value;
	var term_code = fram_fac_termcode_hdr.document.factorsfortermcodeheader.term_code.value;
	fram_fac_termcode_result.location.href = "../../eMR/jsp/FactorsForTermCodeDetail.jsp?term_set_id="+term_set_id+"&term_code="+term_code+"&flagSelect=true";

	*/
	fram_fac_termcode_result.location.href = "../../eCommon/html/blank.html";
	fram_fac_termcode_hdr.location.reload();
}
function chkForSelectAll(start,end)
{
	document.FactorsForTermCodeDetail.chkall.checked = true
	for(var i=start;i<=end;i++)
	{
		if(eval("document.FactorsForTermCodeDetail.chks_factor"+i).checked==false)
		{
			document.FactorsForTermCodeDetail.chkall.checked = false;
		}
	}
	/*if(parent.blankFrame.document.fact_for_dynaval.chkselect.value == 'FACTORSSELECTED')
	{
        document.FactorsForTermCodeDetail.chkall.checked=true;
		chkallvall(document.FactorsForTermCodeDetail.chkall,start,end)
	}*/
}
function query()
{
//	fact_for_term_code.rows = "42,*,0,50,0";
	document.getElementById("fram_fac_termcode_hdr").style.height = "82vh";
	document.getElementById("fram_fac_termcode_result").style.height = "0vh";
	
	fram_fac_termcode_hdr.location.href="../../eMR/jsp/FactorsForTermCodeQueryCriteria.jsp";
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
}

