function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/AddModifyPractRelation.jsp';
}
function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/QueryCriteriaPractRelation.jsp?mode=modify';
}

function apply()
{	 
	if(f_query_add_mod.document.forms[0] != null)
	{	var relationship_type = f_query_add_mod.document.forms[0].nature.value;
		if(f_query_add_mod.document.forms[0].enable_reln.checked == true)
			f_query_add_mod.document.forms[0].enabled.value = 'E';
		else
			f_query_add_mod.document.forms[0].enabled.value = 'D';

		if(f_query_add_mod.document.forms[0].direct_yn.disabled == true)
			f_query_add_mod.document.forms[0].direct_yn.disabled = false;
    
		 if	(f_query_add_mod.document.forms[0].direct_yn.checked==false)
		 {
			if ( f_query_add_mod.document.forms[0].ip_admit.checked== false&& f_query_add_mod.document.forms[0].ip_attend.checked==false&& f_query_add_mod.document.forms[0].op_attend.checked==false) 
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=Atleast one relation should exist";
		 }
	
		 if(f_query_add_mod.document.forms[0].name=="pract_relation_form")
		 {
			if(f_query_add_mod.document.forms[0].mode.value=="modify")
			{
				var fields = new Array ( f_query_add_mod.document.forms[0].relation_id,	f_query_add_mod.document.forms[0].relation_name);
		
				var names = new Array (f_query_add_mod.getLabel("eCA.RelationshipID.label",'CA'),
					f_query_add_mod.getLabel("eCA.RelationshipName.label",'CA'));
			}
			else
			{
				if (relationship_type=="L"){
				var fields = new Array ( f_query_add_mod.document.forms[0].relation_id,
						f_query_add_mod.document.forms[0].relation_name
						);
				var names = new Array(f_query_add_mod.getLabel('eCA.RelationshipID.label','CA'),f_query_add_mod.getLabel("eCA.RelationshipName.label",'CA'));

				}
				else if (relationship_type=="E"){

				var fields = new Array ( f_query_add_mod.document.forms[0].relation_id,
						f_query_add_mod.document.forms[0].relation_name,
						f_query_add_mod.document.forms[0].expiry_rule,
						f_query_add_mod.document.forms[0].expiry_period);

				var names = new Array(f_query_add_mod.getLabel('eCA.RelationshipID.label','CA'),f_query_add_mod.getLabel("eCA.RelationshipName.label",'CA'),f_query_add_mod.getLabel("Common.ExpiryRule.label",'common'),f_query_add_mod.getLabel("Common.ExpiryPeriod.label",'common'));
//				var names = new Array ( getLabel("eCA.RelationshipID.label",'CA'),
//							getLabel("eCA.RelationshipName.label",'CA'),
//			                getLabel("Common.ExpiryRule.label",'common'),
//							getLabel("Common.ExpiryPeriod.label",'common'));
			}
			}
						  
			if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
			{			
				if (f_query_add_mod.document.forms[0].expiry_based1.value=="Y" && f_query_add_mod.document.forms[0].mode.value=="insert")
				{
					var fields1 = new Array ( f_query_add_mod.document.forms[0].expiry_rule,
							f_query_add_mod.document.forms[0].expiry_period);

					var names1 = new Array (  f_query_add_mod.getLabel("Common.ExpiryRule.label",'common'),	f_query_add_mod.getLabel("Common.ExpiryPeriod.label",'common'));

					if(f_query_add_mod.checkFields( fields1, names1, messageFrame)) 
					{
						var field1 = new Array ( f_query_add_mod.document.forms[0].relation_id);
						var name1 = new Array ( f_query_add_mod.getLabel("eCA.RelationshipID.label",'CA'));	

						if (f_query_add_mod.SpecialCharCheck (field1,name1,messageFrame,'M','MstCodeError.jsp')){
							f_query_add_mod.document.forms[0].submit();
						}
					}
				}
				else{
					f_query_add_mod.document.forms[0].submit();
				}
			}
		}
	}
	else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}
}

function onSuccess()
{
	 
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eCA/jsp/AddModifyPractRelation.jsp';
	else
         f_query_add_mod.location.reload();
}

function reset()
{
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset();
}

function populate(obj)
{
	if(obj == 'E')
	{
			delete_values(parent.frames[1].document.forms[0].expiry_rule);
			
			var element = parent.frames[1].document.createElement('OPTION');
			
			element.text = getLabel("eCA.DayAfterEffect.label",'CA')
			element.value= 'DAE'
			parent.frames[1].document.forms[0].expiry_rule.add(element);
			
			element = parent.frames[1].document.createElement('OPTION');
			element.text = getLabel("eCA.DayAfterAdmit.label",'CA')
			element.value= 'DAA'
			parent.frames[1].document.forms[0].expiry_rule.add(element);

			element = parent.frames[1].document.createElement('OPTION');
			element.text = getLabel("eCA.DayAfterTransfer.label",'CA')
			element.value= 'DAT'
			parent.frames[1].document.forms[0].expiry_rule.add(element);

			element = parent.frames[1].document.createElement('OPTION');
			element.text = getLabel("Common.DayAfterDischarge.label",'Common')
			element.value= 'DAD'
			parent.frames[1].document.forms[0].expiry_rule.add(element);

			element = parent.frames[1].document.createElement('OPTION');
			element.text = getLabel("eCA.HourAfterEffect.label",'CA')
			element.value= 'HAE'
			parent.frames[1].document.forms[0].expiry_rule.add(element);
			
			element = parent.frames[1].document.createElement('OPTION');
			element.text = getLabel("eCA.HourAfterAdmit.label",'CA')
			element.value= 'HAA'
			parent.frames[1].document.forms[0].expiry_rule.add(element);

			element = parent.frames[1].document.createElement('OPTION');
			element.text = getLabel("eCA.HourAfterTransfer.label",'CA')
			element.value= 'HAT'
			parent.frames[1].document.forms[0].expiry_rule.add(element);

			element = parent.frames[1].document.createElement('OPTION');
			element.text = getLabel("eCA.HourAfterDischarge.label",'CA')
			element.value= 'HAD'
			parent.frames[1].document.forms[0].expiry_rule.add(element);
	}
	else
		if(obj == 'L')
		{
		
			delete_values(parent.frames[1].document.forms[0].expiry_rule);
			var element = parent.frames[1].document.createElement('OPTION');
			element.text = getLabel("eCA.DayAfterEffect.label",'CA')
			element.value= 'DAE'
			parent.frames[1].document.forms[0].expiry_rule.add(element);
					
			element = parent.frames[1].document.createElement('OPTION');
			element.text = getLabel("eCA.HourAfterEffect.label",'CA')
			element.value= 'HAE'
			parent.frames[1].document.forms[0].expiry_rule.add(element);
		}
}



function pop5(obj)
{
	document.forms[0].relation_name1.value=obj.value;
}

function CheckPositiveNumberLocal(obj) {
	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) 
	{		
	}
	else 
	{
  		if ( obj.value.length > 0 ) 
		{
  			alert(getMessage("POSITIVE_NUMBER_ALLOWED",'CA'));
  			obj.select();
  			obj.focus();
  		}
  	}
}

function add(obj)
{
	var relationship_type=obj.value;
	document.forms[0].nature.value=relationship_type;
	if(relationship_type=="L")
	{
		document.forms[0].direct_yn.checked=true;
		document.forms[0].direct_yn1.value="Y";
		document.forms[0].direct_yn.disabled=true;

		document.forms[0].ip_admit.checked=false;
		document.forms[0].ip_admit1.value="N";
		document.forms[0].ip_admit.disabled=true;

		document.forms[0].ip_attend.checked=false;
		document.forms[0].ip_attend1.value="N";
		document.forms[0].ip_attend.disabled=true;

		document.forms[0].op_attend.checked=false;
		document.forms[0].op_attend1.value="N";
		document.forms[0].op_attend.disabled=true;

		document.forms[0].ae_attend.checked=false;
		document.forms[0].ae_attend1.value="N";
		document.forms[0].ae_attend.disabled=true;

		document.forms[0].nm_attend.checked=false;
		document.forms[0].nm_attend1.value="N";
		document.forms[0].nm_attend.disabled=true;

		document.forms[0].dc_attend.checked=false;
		document.forms[0].dc_attend1.value="N";
		document.forms[0].dc_attend.disabled=true;

		document.forms[0].referral_reln.checked=false;
		document.forms[0].reln_attend1.value="N";
		document.forms[0].referral_reln.disabled=true;

		document.forms[0].ip_default.checked=false;
		document.forms[0].ip_attend_dflt.value="N";
		document.forms[0].ip_default.disabled=true;

		document.forms[0].ip_admit_default.checked=false;
		document.forms[0].ip_admit_dflt.value="N";
		document.forms[0].ip_admit_default.disabled=true;

		document.forms[0].op_default.checked=false;
		document.forms[0].op_attend_dflt.value="N";
		document.forms[0].op_default.disabled=true;

		document.forms[0].ae_default.checked=false;
		document.forms[0].ae_attend_dflt.value="N";
		document.forms[0].ae_default.disabled=true;

		document.forms[0].nm_default.checked=false;
		document.forms[0].nm_attend_dflt.value="N";
		document.forms[0].nm_default.disabled=true;

		document.forms[0].dc_default.checked=false;
		document.forms[0].dc_attend_dflt.value="N";
		document.forms[0].dc_default.disabled=true;

		document.forms[0].referral_deflt.checked=false;
		document.forms[0].reln_attend_dflt.value="N";
		document.forms[0].referral_deflt.disabled=true;
		
		document.forms[0].expiry_based.checked=false;
		document.forms[0].expiry_based1.value="N";
		document.forms[0].expiry_based.disabled=false;
		
		document.forms[0].expiry_period.value="";
		
		document.forms[0].id1.style.visibility="hidden";
		document.forms[0].id2.style.visibility="hidden";

		populate(relationship_type);
	}
	else if(relationship_type=="E")
	{

		document.forms[0].direct_yn.checked=false;
		document.forms[0].direct_yn1.value="N";
		document.forms[0].direct_yn.disabled=false;

		document.forms[0].ip_admit.checked=false;
		document.forms[0].ip_admit1.value="N";
		document.forms[0].ip_admit.disabled=false;

		document.forms[0].ip_attend.checked=false;
		document.forms[0].ip_attend1.value="N";
		document.forms[0].ip_attend.disabled=false;

		document.forms[0].op_attend.checked=false;
		document.forms[0].op_attend1.value="N";
		document.forms[0].op_attend.disabled=false;

		document.forms[0].ae_attend.checked=false;
		document.forms[0].ae_attend1.value="N";
		document.forms[0].ae_attend.disabled=false;

		document.forms[0].nm_attend.checked=false;
		document.forms[0].nm_attend1.value="N";
		document.forms[0].nm_attend.disabled=false;

		document.forms[0].dc_attend.checked=false;
		document.forms[0].dc_attend1.value="N";
		document.forms[0].dc_attend.disabled=false;

		document.forms[0].referral_reln.checked=false;
		document.forms[0].reln_attend1.value="N";
		document.forms[0].referral_reln.disabled=false;

		document.forms[0].ip_default.checked=false;
		document.forms[0].ip_attend_dflt.value="N";
		document.forms[0].ip_default.disabled=true;

		document.forms[0].ip_admit_default.disabled=false;
		document.forms[0].ip_admit_dflt.value="N";
		document.forms[0].ip_admit_default.disabled=true;


		document.forms[0].op_default.checked=false;
		document.forms[0].op_attend_dflt.value="N";
		document.forms[0].op_default.disabled=true;

		document.forms[0].ae_default.checked=false;
		document.forms[0].ae_attend_dflt.value="N";
		document.forms[0].ae_default.disabled=true;

		document.forms[0].nm_default.checked=false;
		document.forms[0].nm_attend_dflt.value="N";
		document.forms[0].nm_default.disabled=true;

		document.forms[0].dc_default.checked=false;
		document.forms[0].dc_attend_dflt.value="N";
		document.forms[0].dc_default.disabled=true;

		document.forms[0].referral_deflt.checked=false;
		document.forms[0].reln_attend_dflt.value="N";
		document.forms[0].referral_deflt.disabled=true;

		delete_values(parent.frames[1].document.forms[0].expiry_rule);

		document.forms[0].expiry_based.checked=true;
		document.forms[0].expiry_based1.value="Y";
		document.forms[0].expiry_based.disabled=true;
		document.forms[0].expiry_period.value="";
		document.forms[0].id1.style.visibility="visible";
		document.forms[0].id2.style.visibility="visible";

		populate(relationship_type);
	}
}

function expiry_rule2(obj)	
{
	if(obj.checked==true)
		document.forms[0].direct_yn1.value="Y";
	else
		document.forms[0].direct_yn1.value="N";

	var direct_yn=obj.checked;
	var relationship_type = document.forms[0].relationship_type[0].checked;

	if(relationship_type==true)
	{
		if(direct_yn==true)
		{
			document.forms[0].ip_attend.checked=false;
			document.forms[0].ip_attend1.value="N";
			document.forms[0].ip_attend.disabled=true;

			document.forms[0].op_attend.checked=false;
			document.forms[0].op_attend1.value="N";
			document.forms[0].op_attend.disabled=true;

			document.forms[0].ip_admit.checked=false;
			document.forms[0].ip_admit1.value="N";
			document.forms[0].ip_admit.disabled=true;

			document.forms[0].nm_attend.checked=false;
			document.forms[0].nm_attend1.value="N";
			document.forms[0].nm_attend.disabled=true;

			document.forms[0].dc_attend.checked=false;
			document.forms[0].dc_attend1.value="N";
			document.forms[0].dc_attend.disabled=true;

			document.forms[0].ae_attend.checked=false;
			document.forms[0].ae_attend1.value="N";
			document.forms[0].ae_attend.disabled=true;

			document.forms[0].referral_reln.checked=false;
			document.forms[0].reln_attend1.value="N";
			document.forms[0].referral_reln.disabled=true;

			document.forms[0].ip_admit_default.checked=false;
			document.forms[0].ip_admit_dflt.value="N";
			document.forms[0].ip_admit_default.disabled=true;

			document.forms[0].ip_default.checked=false;
			document.forms[0].ip_attend_dflt.value="N";
			document.forms[0].ip_default.disabled=true;

			document.forms[0].op_default.checked=false;
			document.forms[0].op_attend_dflt.value="N";
			document.forms[0].op_default.disabled=true;

			document.forms[0].ae_default.checked=false;
			document.forms[0].ae_attend_dflt.value="N";
			document.forms[0].ae_default.disabled=true;

			document.forms[0].nm_default.checked=false;
			document.forms[0].nm_attend_dflt.value="N";
			document.forms[0].nm_default.disabled=true;

			document.forms[0].dc_default.checked=false;
			document.forms[0].dc_attend_dflt.value="N";
			document.forms[0].dc_default.disabled=true;

			document.forms[0].referral_deflt.checked=false;
			document.forms[0].reln_attend_dflt.value="N";
			document.forms[0].referral_deflt.disabled=true;

			document.forms[0].expiry_based.checked=true;
			document.forms[0].expiry_based1.value="Y";
			document.forms[0].expiry_based.disabled=true;
		
			document.forms[0].id1.style.visibility="visible";
			document.forms[0].id2.style.visibility="visible";
		}
		else
		{
			document.forms[0].ip_admit.checked=false;
			document.forms[0].ip_admit1.value="N";
			document.forms[0].ip_admit.disabled=false;

			document.forms[0].ip_attend.checked=false;
			document.forms[0].ip_attend1.value="N";
			document.forms[0].ip_attend.disabled=false;

			document.forms[0].op_attend.checked=false;
			document.forms[0].op_attend1.value="N";
			document.forms[0].op_attend.disabled=false;

			document.forms[0].op_attend.checked=false;
			document.forms[0].op_attend1.value="N";
			document.forms[0].op_attend.disabled=false;

			document.forms[0].ae_attend.checked=false;
			document.forms[0].ae_attend1.value="N";
			document.forms[0].ae_attend.disabled=false;

			document.forms[0].nm_attend.checked=false;
			document.forms[0].nm_attend1.value="N";
			document.forms[0].nm_attend.disabled=false;

			document.forms[0].dc_attend.checked=false;
			document.forms[0].dc_attend1.value="N";
			document.forms[0].dc_attend.disabled=false;

			document.forms[0].referral_reln.checked=false;
			document.forms[0].reln_attend1.value="N";
			document.forms[0].referral_reln.disabled=false;
			
			document.forms[0].ip_admit_default.disabled=false;
			document.forms[0].ip_admit_dflt.value="N";
			document.forms[0].ip_admit_default.disabled=true;

			document.forms[0].ip_default.disabled=false;
			document.forms[0].ip_attend_dflt.value="N";
			document.forms[0].ip_default.disabled=true;

			document.forms[0].op_default.checked=false;
			document.forms[0].op_attend_dflt.value="N";
			document.forms[0].op_default.disabled=true;

			document.forms[0].ae_default.checked=false;
			document.forms[0].ae_attend_dflt.value="N";
			document.forms[0].ae_default.disabled=true;

			document.forms[0].nm_default.checked=false;
			document.forms[0].nm_attend_dflt.value="N";
			document.forms[0].nm_default.disabled=true;

			document.forms[0].dc_default.checked=false;
			document.forms[0].dc_attend_dflt.value="N";
			document.forms[0].dc_default.disabled=true;

			document.forms[0].referral_deflt.checked=false;
			document.forms[0].reln_attend_dflt.value="N";
			document.forms[0].referral_deflt.disabled=true;

			document.forms[0].expiry_based.checked=true;
			document.forms[0].expiry_based1.value="Y";
			document.forms[0].expiry_based.disabled=true;

			document.forms[0].id1.style.visibility="visible";
			document.forms[0].id2.style.visibility="visible";
		}
	}
}
	
function setMode(obj)
{
	if(obj.checked==true)
		document.forms[0].expiry_period.disabled = false ;
	else
	{
		document.forms[0].expiry_period.value="";
		document.forms[0].expiry_period.disabled = true ;	
	}
}

function delete_values(field)
{
	var selected = field;
	while ( selected.options.length > 0 )
				selected.remove(selected.options[0]);
	var opt=parent.frames[1].document.createElement("Option");
	opt.text="----------------------------"+getLabel('Common.defaultSelect.label','COMMON')+"----------------------------"
	opt.value="";
	field.add(opt);
}

function pop1(obj)
{

	if(obj.checked== true)
	{
		document.forms[0].expiry_rule.disabled=false;
		document.forms[0].id1.style.visibility="visible";
		document.forms[0].id2.style.visibility="visible";
		document.forms[0].expiry_based1.value="Y";
	}
	else
	{
		document.forms[0].expiry_rule.disabled=true;
		document.forms[0].id1.style.visibility="hidden";
		document.forms[0].id2.style.visibility="hidden";
		document.forms[0].expiry_based1.value="N";
		document.forms[0].expiry_period.value="";

	}
}


function ShowImages()
{
	document.forms[0].id1.style.visibility="visible";
	document.forms[0].id2.style.visibility="visible";
}


function checkdefault(obj)
{
var object_id = obj.id;
if(obj.checked == true)
{

	if(object_id == 'IPEn'){
		document.forms[0].ip_default.disabled=false;
		document.forms[0].ip_attend1.value="Y";
	}
	else if(object_id == 'IPAd'){
		document.forms[0].ip_admit_default.disabled=false;
		document.forms[0].ip_admit1.value="Y";
	}
	else if(object_id == 'OP'){
		document.forms[0].op_default.disabled=false;
		document.forms[0].op_attend1.value="Y";
	}
	else if(object_id == 'AE'){
		document.forms[0].ae_default.disabled=false;
		document.forms[0].ae_attend1.value="Y";
	}
	else if(object_id == 'DC'){
		document.forms[0].dc_default.disabled=false;
		document.forms[0].dc_attend1.value="Y";
	}
	else if(object_id == 'NM'){
		document.forms[0].nm_default.disabled=false;
		document.forms[0].nm_attend1.value="Y";
	}
	else if(object_id == 'RL'){
		document.forms[0].referral_deflt.disabled=false;
		document.forms[0].reln_attend1.value="Y";
	}
}else{
	if(object_id == 'IPEn'){
		document.forms[0].ip_default.checked=false;
		document.forms[0].ip_default.disabled=true;
		document.forms[0].ip_attend1.value="N";
	}else if(object_id == 'IPAd'){
		document.forms[0].ip_admit_default.checked=false;
		document.forms[0].ip_admit_default.disabled=true;
		document.forms[0].ip_admit1.value="N";
	}else if(object_id == 'OP'){
		document.forms[0].op_default.checked=false;
		document.forms[0].op_default.disabled=true;
		document.forms[0].op_attend1.value="N";
	}else if(object_id == 'AE'){
		document.forms[0].ae_default.checked=false;
		document.forms[0].ae_default.disabled=true;
		document.forms[0].ae_attend1.value="N";
	}else if(object_id == 'DC'){
		document.forms[0].dc_default.checked=false;
		document.forms[0].dc_default.disabled=true;
		document.forms[0].dc_attend1.value="N";
	}else if(object_id == 'NM'){
		document.forms[0].nm_default.checked=false;
		document.forms[0].nm_default.disabled=true;
		document.forms[0].nm_attend1.value="N";
	}else if(object_id == 'RL'){
		document.forms[0].referral_deflt.checked=false;
		document.forms[0].referral_deflt.disabled=true;
		document.forms[0].reln_attend1.value="N";
	}
}
}

function Assigndefault(obj)
{

var object_id = obj.id;
if(obj.checked == true)
{
	if(object_id == 'IPEnD'){
		document.forms[0].ip_default.disabled=false;
		document.forms[0].ip_attend_dflt.value="Y";
	}
	else if(object_id == 'IPAdD'){
		document.forms[0].ip_admit_default.disabled=false;
		document.forms[0].ip_admit_dflt.value="Y";	
	}
	else if(object_id == 'OPD'){
		document.forms[0].op_default.disabled=false;
		document.forms[0].op_attend_dflt.value="Y";
	}
	else if(object_id == 'AED'){
		document.forms[0].ae_default.disabled=false;
		document.forms[0].ae_attend_dflt.value="Y";
	}
	else if(object_id == 'DCD'){
		document.forms[0].dc_default.disabled=false;
		document.forms[0].dc_attend_dflt.value="Y";
	}
	else if(object_id == 'NMD'){
		document.forms[0].nm_default.disabled=false;
		document.forms[0].nm_attend_dflt.value="Y";
	}
	else if(object_id == 'RLD'){
		document.forms[0].referral_deflt.disabled=false;
		document.forms[0].reln_attend_dflt.value="Y";
	}
}
else
{
	
	if(object_id == 'IPEnD'){
		//document.forms[0].ip_default.disabled=false;
		document.forms[0].ip_attend_dflt.value="N";
	}
	else if(object_id == 'IPAdD'){
		//document.forms[0].ip_admit_default.disabled=false;
		document.forms[0].ip_admit_dflt.value="N";	
	}
	else if(object_id == 'OPD'){
		//document.forms[0].op_default.disabled=false;
		document.forms[0].op_attend_dflt.value="N";
	}
	else if(object_id == 'AED'){
		//document.forms[0].ae_default.disabled=false;
		document.forms[0].ae_attend_dflt.value="N";
	}
	else if(object_id == 'DCD'){
		//document.forms[0].dc_default.disabled=false;
		document.forms[0].dc_attend_dflt.value="N";
	}
	else if(object_id == 'NMD'){
		//document.forms[0].nm_default.disabled=false;
		document.forms[0].nm_attend_dflt.value="N";
	}
	else if(object_id == 'RLD'){
		
		document.forms[0].reln_attend_dflt.value="N";
		
	}

}
}
function chkZero(obj)
	{
		if(parseFloat(obj.value) == 0)
			obj.value = "";
	}

		
