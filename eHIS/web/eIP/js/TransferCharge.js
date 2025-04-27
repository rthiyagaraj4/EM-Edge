var bedTypeArr = new Array();
var bedChargeArr = new Array();
 
function create() {
	f_query_add_mod.location.href = "../../eIP/jsp/AddModifyTransferCharge.jsp" ;
}

function calcbedcharge(Obj)
{
	var flag;
	if(Obj.name == "from_bed_type") flag="from_bed_type";
	else
	flag="to_bed_type";
	if(Obj.name == "from_bed_type") {
		for(j=0; j<bedTypeArr.length; j++) {
			if(Obj.value==bedTypeArr[j])
				document.forms[0].bed_from_charge.value = bedChargeArr[j]
		}
	}
	else if(Obj.name =="to_bed_type"){
		for(j=0; j<bedTypeArr.length; j++) {
			if(Obj.value==bedTypeArr[j])
				document.forms[0].bed_to_charge.value = bedChargeArr[j]
		}
	}
}
function percentAmount(Obj2)
{
if(Obj2.value == 'P')
	{
	parent.frames[1].document.forms[0].calculate.disabled=false;
	parent.frames[1].document.getElementById("calculateimg").style.visibility= "visible";
	if(parent.frames[1].document.forms[0].p_a_amount.value.length !=0)
		{
		if(parent.frames[1].document.forms[0].calculate.value.length !=0)
		calculateAmount(parent.frames[1].document.forms[0].calculate);
		}
	}
else
	{
	parent.frames[1].document.forms[0].calculate.value='';
	parent.frames[1].document.forms[0].calculate.disabled=true;
	parent.frames[1].document.getElementById("calculateimg").style.visibility= "hidden";
	if(parent.frames[1].document.forms[0].p_a_amount.value.length!=0)
		parent.frames[1].document.forms[0].calculated_amount.value=parent.frames[1].document.forms[0].p_a_amount.value;
	}

}

function calculateAmount(Obj1)
{
if(Obj1.value.length > 0)
{
var per=parseInt(parent.frames[1].document.forms[0].p_a_amount.value);
var bed_charge;
if(per !=null)
	{
		if(parent.frames[1].document.forms[0].p_a_amount.value.length !=0)
		{
			if(Obj1.value=='F')
				{
					if(parent.frames[1].document.forms[0].bed_from_charge.value.length!=0)
					{
					bed_charge=parseInt(parent.frames[1].document.forms[0].bed_from_charge.value);
					var temp=(bed_charge/100)*per;
					

				parent.frames[1].document.forms[0].calculated_amount.value=temp;
					}
				}
			else
			if(Obj1.value=='T')
				{	
					if(parent.frames[1].document.forms[0].bed_to_charge.value.length !=0)
					{
						bed_charge=parseInt(parent.frames[1].document.forms[0].bed_to_charge.value);
						var temp=(bed_charge/100)*per;
						

						parent.frames[1].document.forms[0].calculated_amount.value=temp;
					}
				}

		}
	}

}
else
percentAmount(parent.frames[1].document.forms[0].p_a_ind);

}
				

function apply()
{
	if(f_query_add_mod.document.forms[0].eff_status.checked == true)
		f_query_add_mod.document.forms[0].eff_status.value="E";
	else
	f_query_add_mod.document.forms[0].eff_status.value="D";

var fields=new Array();

			fields[0]= f_query_add_mod.document.transfer_charge.from_bed_type;
			fields[1]= f_query_add_mod.document.transfer_charge.to_bed_type;
			fields[2]= f_query_add_mod.document.transfer_charge.p_a_ind;
			fields[3]= f_query_add_mod.document.transfer_charge.p_a_amount;

	var names = new Array (	getLabel('eIP.FromBedType.label','IP'),
							getLabel('eIP.ToBedType.label','IP'),
							getLabel('eIP.PercentAmountIndicator.label','IP'),
							getLabel('eIP.PercentAmount.label','IP')
						   )
	
	if(f_query_add_mod.document.transfer_charge.calculate.disabled == false)
		{
		fields[4]=f_query_add_mod.document.transfer_charge.calculate;
		names[4]="Calculate On";
		}
	

	
	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		f_query_add_mod.document.transfer_charge.submit();

	}


}


function onSuccess(){
	if(f_query_add_mod.document.transfer_charge.function_name.value == 'insert')
		reset();
}

function query()
{
	f_query_add_mod.location.href ="../../eIP/jsp/TransferChargeQueryCriteria.jsp" ;
}

function reset()
{
f_query_add_mod.document.transfer_charge.reset();
}
