function create()
{
	f_query_details.location.href = "../../eSM/jsp/AccountingParametersMain.jsp";
}

function reset()
{
		f_query_details.document.forms[0].reset();
}

function apply()
{

	//var fields=new Array(f_query_details.document.forms[0].entity_desc_long,f_query_details.document.forms[0].entity_desc_short,f_query_details.document.forms[0].no_acct_periods,f_query_details.document.forms[0].start_fiscal_month,f_query_details.document.forms[0].department_length,f_query_details.document.forms[0].currency_name,f_query_details.document.forms[0].decimal_name);
	var fields=new Array(f_query_details.document.getElementById("entity_desc_long"),f_query_details.document.getElementById("entity_desc_short"),f_query_details.document.getElementById("no_acct_periods"),f_query_details.document.getElementById("start_fiscal_month"),f_query_details.document.getElementById("department_length"),f_query_details.document.getElementById("currency_name"),f_query_details.document.getElementById("decimal_name"));
	var names = new Array (getLabel("eSM.AccountEntLongname.label","SM"),getLabel("eSM.AccountEntShortname.label","SM"),getLabel("eSM.NoofAccountingPeriods.label","SM"), getLabel("eSM.StartFiscalMonth.label","SM"),getLabel("eSM.DepartmentLength.label","SM"),getLabel("eSM.CurrencyName.label","SM"),getLabel("eSM.DecimalName.label","SM"))

	if(f_query_details.checkFieldsofMst(fields,names,messageFrame))
	{
			f_query_details.document.forms[0].prefix_dept_by_facility.disabled = false;
			f_query_details.document.forms[0].submit();
	}
}

function onSuccess() 
{
	f_query_details.document.location.reload();
}
