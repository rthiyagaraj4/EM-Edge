
function en_Able(){
	if(parent.parent.f_query_add_mod){//Register New Born Function Starts Here
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.noOfBirths.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.gravida.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.parity.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.gestational_period.disabled=false;
if(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.gestational_period_days) {
parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.gestational_period_days.disabled=false;
}
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.nod_type.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.pract_id_search1.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.pract_id_search1.readonly=false;

	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.att_nurse_newborn.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.att_nurse_search.disabled=false;
//	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.community_nurse.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.comple_ofdel_newborn.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.comple_of_button.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.complications_delivery_text.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.complications_delivery_search.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.remarks.disabled=false;

//	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.mother_pmi_no.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.del_indica_button.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.del_indica_newborn.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.proc_class_desc.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.vaginal_del_type_desc.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.del_serv_class.disabled=false;
			
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.father_patient_id.disabled=false;
			
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.pat_id_search.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.pat_id_search.readonly=false;
	if(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.invoked_from.value != 'details_page'){
		parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.father_patient_name.disabled=false;
	}

	if(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.invoked_from.value != 'details_page')
{
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.nb_patient_name.disabled=false;
}
    if(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.National_id)
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.National_id.disabled=false;
	if(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.cboOtherAltID)
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.cboOtherAltID.disabled=false;
	if(parent.parent.f_query_add_mod.frames[2].document.forms[0].txtOtherAltID)
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.txtOtherAltID.disabled=false;
	
	//parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.cboNationality.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.forms[0].cboNationality_button.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.forms[0].cboNationality_desc.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.cboEthnicGroup.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.cboEthnicGroupDesc.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.cboEthnicGroupBtn.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.fthGovtEmpl.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.cboReligion.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.cboOccupationClass.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.cboOccupation.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.Occupation_Desc.disabled=false;
	parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.fatherRemarks.disabled=false;
	//Register New Born Function ends Here
	}else{//Maintain Birth Register Function Starts Here
		f_query_add_mod.frames[2].document.NewbornRegistration_form.noOfBirths.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.gravida.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.parity.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.gestational_period.disabled=false;
		if(f_query_add_mod.frames[2].document.NewbornRegistration_form.gestational_period_days) {
			f_query_add_mod.frames[2].document.NewbornRegistration_form.gestational_period_days.disabled=false;
		}

		f_query_add_mod.frames[2].document.NewbornRegistration_form.nod_type.disabled=false;

		f_query_add_mod.frames[2].document.NewbornRegistration_form.pract_id_search1.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.pract_id_search1.readonly=false;

		f_query_add_mod.frames[2].document.NewbornRegistration_form.att_nurse_newborn.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.att_nurse_search.disabled=false;
		//	f_query_add_mod.frames[2].document.NewbornRegistration_form.community_nurse.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.comple_ofdel_newborn.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.comple_of_button.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.complications_delivery_text.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.complications_delivery_search.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.remarks.disabled=false;

		//	f_query_add_mod.frames[2].document.NewbornRegistration_form.mother_pmi_no.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.del_indica_button.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.del_indica_newborn.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.proc_class_desc.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.vaginal_del_type_desc.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.del_serv_class.disabled=false;

		f_query_add_mod.frames[2].document.NewbornRegistration_form.father_patient_id.disabled=false;

		f_query_add_mod.frames[2].document.NewbornRegistration_form.pat_id_search.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.pat_id_search.readonly=false;
		if(f_query_add_mod.frames[2].document.NewbornRegistration_form.invoked_from.value != 'details_page')
		{
			f_query_add_mod.frames[2].document.NewbornRegistration_form.father_patient_name.disabled=false;
		}
		if(f_query_add_mod.frames[2].document.NewbornRegistration_form.invoked_from.value != 'details_page')
		{
			f_query_add_mod.frames[2].document.NewbornRegistration_form.nb_patient_name.disabled=false;
		}
		if(f_query_add_mod.frames[2].document.NewbornRegistration_form.National_id)
		f_query_add_mod.frames[2].document.NewbornRegistration_form.National_id.disabled=false;
		if(f_query_add_mod.frames[2].document.NewbornRegistration_form.cboOtherAltID)
		f_query_add_mod.frames[2].document.NewbornRegistration_form.cboOtherAltID.disabled=false;
		if(f_query_add_mod.frames[2].document.forms[0].txtOtherAltID)
		f_query_add_mod.frames[2].document.NewbornRegistration_form.txtOtherAltID.disabled=false;

		//f_query_add_mod.frames[2].document.NewbornRegistration_form.cboNationality.disabled=false;
		f_query_add_mod.frames[2].document.forms[0].cboNationality_button.disabled=false;
		f_query_add_mod.frames[2].document.forms[0].cboNationality_desc.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.cboEthnicGroup.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.cboEthnicGroupDesc.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.cboEthnicGroupBtn.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.fthGovtEmpl.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.cboReligion.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.cboOccupationClass.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.cboOccupation.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.Occupation_Desc.disabled=false;
		f_query_add_mod.frames[2].document.NewbornRegistration_form.fatherRemarks.disabled=false;
	}//Maintain Birth Register Function Ends Here

}

function clearfields() {

	if(document.forms[0].cboEthnicGroupDesc) {
		if(document.forms[0].cboEthnicGroupDesc.value=='') {
		document.forms[0].cboEthnicGroup.value=''; 
		}
	}	
}

async function searchRace(obj,target,locale)
{
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;		
	var tit="";	 	
	
	if(target.name == 'cboEthnicGroupDesc')
	{
		tit=getLabel("Common.race.label","common");
    		sql="SELECT race_code code, initcap(long_desc) description FROM mp_race_lang_vw WHERE language_id = '"+locale+"' and eff_status = 'E'  and upper(long_desc) like upper(?) and  upper(race_code) like upper(?) ORDER BY 2";
	}
	
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		document.forms[0].cboEthnicGroup.value= arr[0];		
	}
	else{
		target.value='';
		document.forms[0].cboEthnicGroup.value= '';			
	}	
}

function birthDateCheck(from,to,messageFrame,val,function_id) {
    var func_id = function_id.value;
    var fromarray;
    var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
    var msg='';
    if(fromdate.length > 0 && todate.length > 0 )
    {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
            var todt = new Date(toarray[2],toarray[1],toarray[0]);

            if(Date.parse(fromdt)> Date.parse(todt))
            {
	            msg = getMessage('BIRTH_DATE_GREATER_SYSDATE',"MP");
                from.focus();
                from.select();
				from.value='';
            }
            else if(val!='')
            {
                var days = eval(eval(toarray[0])- eval(val));
                todt = new Date(toarray[2],toarray[1],days);
                if(Date.parse(fromdt)< Date.parse(todt))
                {
					msg = getMessage('REGN_RESTRICTED_FOR_NB',"MP");					
                    from.focus();
                    from.select();
					from.value='';
                }
            }
            if(msg!='')
            {
                messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+msg;
                if(func_id!="")
                    setTimeout('disable_home();',1000);
                return false;
            }
            return true;
    }
}
function disable_home()
{
//parent.parent.frames[0].document.getElementById("home").disabled=true;
}

function checkPatientId()   {
		
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr ="<root><SEARCH ";
	document.getElementById('patient_id').value = document.getElementById('patient_id').value.toUpperCase();
	if (document.getElementById('patient_id').value.length != document.getElementById('patient_id').maxLength && document.getElementById('patient_id').value.length > 0) 
  {
		var msg1 = getMessage("PAT_ID_CH", "MP");
		msg1 = msg1.replace('$', document.getElementById('patient_id').maxLength);
		alert(msg1);
		document.getElementById('patient_id').focus();
	}

	if (document.getElementById('patient_id').value.length == document.getElementById('patient_id').maxLength) 
  {
		var pat_id = document.getElementById('patient_id').value;
		pat_id = pat_id.substring(0, 2);
		if (pat_id != parent.frames[1].document.forms[0].pat_ser_grp_code.value && parent.frames[1].document.forms[0].pat_ser_prefix_reqd_yn.value == "Y") 
    {
			var msg = getMessage("PAT_SER_PREFIX", "MP");
			msg = msg.replace('$',parent.frames[1].document.forms[0].pat_ser_grp_code.value);
			alert(msg);
			document.getElementById('patient_id').focus();
      		} 
              else 
                  {
			xmlStr += " process_id=\"13\" ";
			xmlStr += " pat_id=\"" + document.getElementById('patient_id').value + "\"";
			xmlStr += " /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

			var url = "../../eMP/jsp/ServerValidationXML.jsp";
			xmlHttp.open("POST", url, false);
			xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xmlHttp.send(xmlDoc);
			eval(xmlHttp.responseText);

		}
	}
  
  
}

/*function query()
{
var accessRights="";
parent.frames[1].document.frames[2].location.href='../../eMP/jsp/NewbornRegistrationInvoke.jsp?accessRights='+accessRights

}*/
function query()
{
	//var fid=parent.frames[1].frames[2].document.forms[0].function_id_mg.value;
	
	frames[1].document.location.href='../../eMP/jsp/MaintainBirthRegisterFirst.jsp'
}

async function callOnlineReportsPrinting(patient_id)
{
var retVal =    new String();
var dialogHeight    = '30' ;
var dialogWidth = '70' ;
var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;'
var arguments   = '' ;
retVal = await window.showModalDialog("../../eCommon/jsp/InternalReportsReprint.jsp?module_id=MP&step=0&patient_id="+patient_id+"&target=step2",arguments,features);
}

function enableDisable(obj)
{
	if (obj.name=="born_where")
	{
		var opt = "";
		if (obj.value=="B")
		{
			document.NewbornRegistration_form.born_at.disabled = false;
			while (document.NewbornRegistration_form.born_at.options.length >0)
      					document.NewbornRegistration_form.born_at.remove(document.NewbornRegistration_form.born_at.options[0]);			
			opt = document.createElement("OPTION");
			opt.text = getLabel("Common.home.label","common");
			opt.value= 'H';
			opt1 = document.createElement("OPTION");
			opt1.text = getLabel("eMP.Ambulance.label","MP");
			opt1.value= 'A';
			opt2 = document.createElement("OPTION");
			opt2.text = getLabel("eMP.OtherModesofTpt.label","MP");
			opt2.value= 'O';

			document.NewbornRegistration_form.born_at.add(opt)
			document.NewbornRegistration_form.born_at.add(opt1)
			document.NewbornRegistration_form.born_at.add(opt2)
			document.NewbornRegistration_form.Umb_cord_cut_by.value='';
			document.NewbornRegistration_form.Umb_cord_cut_by.disabled=false;
			document.getElementById("UmbCrd").innerHTML="&nbsp";
			document.getElementById("nmdesig").innerHTML="&nbsp";
		}
		else
		{
			while (document.NewbornRegistration_form.born_at.options.length >0)
					document.NewbornRegistration_form.born_at.remove(document.NewbornRegistration_form.born_at.options[0]);
			opt = document.createElement("OPTION");
			opt.text =  '---'+getLabel("Common.defaultSelect.label","Common")+'---';
			opt.value= '';
			document.NewbornRegistration_form.born_at.add(opt)
			document.NewbornRegistration_form.born_at.value = "";
			document.NewbornRegistration_form.born_at.disabled = true;
			document.NewbornRegistration_form.Umb_cord_cut_by.value='';
			document.NewbornRegistration_form.Umb_cord_cut_by.disabled=true;
			
			document.getElementById("UmbCrd").innerHTML="<input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick=\"umb_crd_cutby();getNewBornRegnValues('Umb_cord_cut_by')\"><input type='hidden' name='Umb_cord_cut_by_physician_id' id='Umb_cord_cut_by_physician_id'>";
		}
	}
}

function checkMinMax()
{	
	if(parent.parent.f_query_add_mod){
	var str = "";

	if (parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.weight.value != '0')
	{
		if (parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.min_weight.value !='0')
		{
			if (parseFloat(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.weight.value) < parseFloat(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.min_weight.value))
			{
				str = getMessage("RANGE_CHK_FOR_MIN","MP") + "<br>";
				str = str.replace('$', getLabel("eMP.BirthWeight.label","MP"));
				str = str.replace('#', parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.min_weight.value);
			}
		}
		if (parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.max_weight.value !='0')
		{
			if (parseFloat(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.weight.value) > parseFloat(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.max_weight.value))
			{
				str += getMessage("RANGE_CHK_FOR_MAX","MP") + "<br>";
				str = str.replace('$', getLabel("eMP.BirthWeight.label","MP"));
				str = str.replace('#', parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.max_weight.value);
			}
		}
	}
	if (parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.min_length.value !='0')
	{
		if (parseFloat(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.length1.value) < parseFloat(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.min_length.value))
		{
			str = getMessage("RANGE_CHK_FOR_MIN","MP") + "<br>";
			str = str.replace('$', getLabel("eMP.LengthofBaby.label","MP"));
			str = str.replace('#', parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.min_length.value);
		}
	}
	if (parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.max_length.value !='0')
	{
		if (parseFloat(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.length1.value) > parseFloat(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.max_length.value))
		{
			str += getMessage("RANGE_CHK_FOR_MAX","MP") + "<br>";
			str = str.replace('$', getLabel("eMP.LengthofBaby.label","MP"));
			str = str.replace('#', parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.max_length.value);
		}
	}
	if (parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.min_head_circum.value !='0')
	{
		if (parseFloat(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.circumference.value) < parseFloat(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.min_head_circum.value))
		{
			str = getMessage("RANGE_CHK_FOR_MIN","MP") + "<br>";
			str = str.replace('$', getLabel("Common.HeadCircumference.label","common"));
			str = str.replace('#', parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.min_head_circum.value);
		}
	}
	if (parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.max_head_circum.value !='0')
	{
		if (parseFloat(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.circumference.value) > parseFloat(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.max_head_circum.value))
		{
			str += getMessage("RANGE_CHK_FOR_MAX","MP") + "<br>";
			str = str.replace('$', getLabel("Common.HeadCircumference.label","common"));
			str = str.replace('#', parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.max_head_circum.value);
		}
	}
	if (parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.min_chest_circum.value !='0')
	{
		if (parseFloat(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.chest_circumference.value) < parseFloat(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.min_chest_circum.value))
		{
			str = getMessage("RANGE_CHK_FOR_MIN","MP") + "<br>";
			str = str.replace('$', getLabel("eMP.ChestCircum.label","MP"));
			str = str.replace('#', parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.min_chest_circum.value);
		}
	}
	if (parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.max_chest_circum.value !='0')
	{
		if (parseFloat(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.chest_circumference.value) > parseFloat(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.max_chest_circum.value))
		{
			str += getMessage("RANGE_CHK_FOR_MAX","MP") + "<br>";
			str = str.replace('$', getLabel("eMP.ChestCircum.label","MP"));
			str = str.replace('#', parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.max_chest_circum.value);
		}
	}
	if (parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.min_gestation.value !='0')
	{
		if (parseFloat(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.gestational_period.value) < parseFloat(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.min_gestation.value))
		{
			str = getMessage("RANGE_CHK_FOR_MIN","MP") + "<br>";
			str = str.replace('$', getLabel("eMP.Gestation.label","MP"));
			str = str.replace('#', parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.min_gestation.value);
		}
	}
	if (parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.max_gestation.value !='0')
	{
		if (parseFloat(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.gestational_period.value) > parseFloat(parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.max_gestation.value))
		{
			str += getMessage("RANGE_CHK_FOR_MAX","MP") + "<br>";
			str = str.replace('$', getLabel("eMP.Gestation.label","MP"));
			str = str.replace('#', parent.parent.f_query_add_mod.frames[2].document.NewbornRegistration_form.max_gestation.value);
		}
	}
	LocalErrors += "<br>"+str;
	if (str!='')
		return false;
	else
		return true;
}else{

		
	var str = "";

	if (f_query_add_mod.frames[2].document.NewbornRegistration_form.weight.value != '0')
	{
		if (f_query_add_mod.frames[2].document.NewbornRegistration_form.min_weight.value !='0')
		{
			if (parseFloat(f_query_add_mod.frames[2].document.NewbornRegistration_form.weight.value) < parseFloat(f_query_add_mod.frames[2].document.NewbornRegistration_form.min_weight.value))
			{
				str = getMessage("RANGE_CHK_FOR_MIN","MP") + "<br>";
				str = str.replace('$', getLabel("eMP.BirthWeight.label","MP"));
				str = str.replace('#', f_query_add_mod.frames[2].document.NewbornRegistration_form.min_weight.value);
			}
		}
		if (f_query_add_mod.frames[2].document.NewbornRegistration_form.max_weight.value !='0')
		{
			if (parseFloat(f_query_add_mod.frames[2].document.NewbornRegistration_form.weight.value) > parseFloat(f_query_add_mod.frames[2].document.NewbornRegistration_form.max_weight.value))
			{
				str += getMessage("RANGE_CHK_FOR_MAX","MP") + "<br>";
				str = str.replace('$', getLabel("eMP.BirthWeight.label","MP"));
				str = str.replace('#', f_query_add_mod.frames[2].document.NewbornRegistration_form.max_weight.value);
			}
		}
	}
	if (f_query_add_mod.frames[2].document.NewbornRegistration_form.min_length.value !='0')
	{
		if (parseFloat(f_query_add_mod.frames[2].document.NewbornRegistration_form.length1.value) < parseFloat(f_query_add_mod.frames[2].document.NewbornRegistration_form.min_length.value))
		{
			str = getMessage("RANGE_CHK_FOR_MIN","MP") + "<br>";
			str = str.replace('$', getLabel("eMP.LengthofBaby.label","MP"));
			str = str.replace('#', f_query_add_mod.frames[2].document.NewbornRegistration_form.min_length.value);
		}
	}
	if (f_query_add_mod.frames[2].document.NewbornRegistration_form.max_length.value !='0')
	{
		if (parseFloat(f_query_add_mod.frames[2].document.NewbornRegistration_form.length1.value) > parseFloat(f_query_add_mod.frames[2].document.NewbornRegistration_form.max_length.value))
		{
			str += getMessage("RANGE_CHK_FOR_MAX","MP") + "<br>";
			str = str.replace('$', getLabel("eMP.LengthofBaby.label","MP"));
			str = str.replace('#', f_query_add_mod.frames[2].document.NewbornRegistration_form.max_length.value);
		}
	}
	if (f_query_add_mod.frames[2].document.NewbornRegistration_form.min_head_circum.value !='0')
	{
		if (parseFloat(f_query_add_mod.frames[2].document.NewbornRegistration_form.circumference.value) < parseFloat(f_query_add_mod.frames[2].document.NewbornRegistration_form.min_head_circum.value))
		{
			str = getMessage("RANGE_CHK_FOR_MIN","MP") + "<br>";
			str = str.replace('$', getLabel("Common.HeadCircumference.label","common"));
			str = str.replace('#', f_query_add_mod.frames[2].document.NewbornRegistration_form.min_head_circum.value);
		}
	}
	if (f_query_add_mod.frames[2].document.NewbornRegistration_form.max_head_circum.value !='0')
	{
		if (parseFloat(f_query_add_mod.frames[2].document.NewbornRegistration_form.circumference.value) > parseFloat(f_query_add_mod.frames[2].document.NewbornRegistration_form.max_head_circum.value))
		{
			str += getMessage("RANGE_CHK_FOR_MAX","MP") + "<br>";
			str = str.replace('$', getLabel("Common.HeadCircumference.label","common"));
			str = str.replace('#', f_query_add_mod.frames[2].document.NewbornRegistration_form.max_head_circum.value);
		}
	}
	if (f_query_add_mod.frames[2].document.NewbornRegistration_form.min_chest_circum.value !='0')
	{
		if (parseFloat(f_query_add_mod.frames[2].document.NewbornRegistration_form.chest_circumference.value) < parseFloat(f_query_add_mod.frames[2].document.NewbornRegistration_form.min_chest_circum.value))
		{
			str = getMessage("RANGE_CHK_FOR_MIN","MP") + "<br>";
			str = str.replace('$', getLabel("eMP.ChestCircum.label","MP"));
			str = str.replace('#', f_query_add_mod.frames[2].document.NewbornRegistration_form.min_chest_circum.value);
		}
	}
	if (f_query_add_mod.frames[2].document.NewbornRegistration_form.max_chest_circum.value !='0')
	{
		if (parseFloat(f_query_add_mod.frames[2].document.NewbornRegistration_form.chest_circumference.value) > parseFloat(f_query_add_mod.frames[2].document.NewbornRegistration_form.max_chest_circum.value))
		{
			str += getMessage("RANGE_CHK_FOR_MAX","MP") + "<br>";
			str = str.replace('$', getLabel("eMP.ChestCircum.label","MP"));
			str = str.replace('#', f_query_add_mod.frames[2].document.NewbornRegistration_form.max_chest_circum.value);
		}
	}
	if (f_query_add_mod.frames[2].document.NewbornRegistration_form.min_gestation.value !='0')
	{
		if (parseFloat(f_query_add_mod.frames[2].document.NewbornRegistration_form.gestational_period.value) < parseFloat(f_query_add_mod.frames[2].document.NewbornRegistration_form.min_gestation.value))
		{
			str = getMessage("RANGE_CHK_FOR_MIN","MP") + "<br>";
			str = str.replace('$', getLabel("eMP.Gestation.label","MP"));
			str = str.replace('#', f_query_add_mod.frames[2].document.NewbornRegistration_form.min_gestation.value);
		}
	}
	if (f_query_add_mod.frames[2].document.NewbornRegistration_form.max_gestation.value !='0')
	{
		if (parseFloat(f_query_add_mod.frames[2].document.NewbornRegistration_form.gestational_period.value) > parseFloat(f_query_add_mod.frames[2].document.NewbornRegistration_form.max_gestation.value))
		{
			str += getMessage("RANGE_CHK_FOR_MAX","MP") + "<br>";
			str = str.replace('$', getLabel("eMP.Gestation.label","MP"));
			str = str.replace('#', f_query_add_mod.frames[2].document.NewbornRegistration_form.max_gestation.value);
		}
	}
	LocalErrors += "<br>"+str;
	if (str!='')
		return false;
	else
		return true;
}
}


function validateDate(obj){

	if(obj.value != '')	{
		
		if(!parent.frames[2].validDate(obj.value,'DMY',localeName)){
				
				var msg = self.getMessage("INVALID_DATE_FMT","SM");
				alert(msg);				
				obj.focus();
				obj.value='';
		}else{
			
			if((!parent.frames[2].isBeforeNow(obj.value,'DMY',localeName))) {	
				alert(getMessage("DOB_NOT_GR_TODAY","MP"));
				//parent.frames[2].document.forms[0].date_of_birth.value='';					
				//parent.frames[2].document.forms[0].date_of_birth.focus();
				parent.frames[2].document.forms[0].birth_date.value='';
				parent.frames[2].document.forms[0].birth_date.focus();				
			} else {  
				date_Validate(obj);
			}
		}
	}
}

function validateTime(obj){

	if(obj.value != '')	{
		
		if(!parent.frames[2].validDate(obj.value,'HM',localeName)){
				
				var msg = self.getMessage("INVALID_TIME_FMT","SM");
				alert(msg);				
				obj.focus();
				obj.value='';
		}else{ 			
			date_Validate(obj);
		}
	}
}

function leapyear(a) {
	if(((a % 4 == 0) && (a % 100 != 0)) || (a % 400 == 0))
		return true;
	else
		return false;
}

function doDateTimeChk(obj)
{
	var comp=obj
	obj=obj.value
	var dttime = obj.split(" ");
	var dt
	var time
	var retval=true
	if(dttime.length>1)
	{
		dt=dttime[0]
		time=dttime[1]
		if(!checkDt(dt) )
		{
			retval= false
			comp.focus()
		}
		else
		{
			if(time==null || time=="")
			{
				retval= false;
				comp.focus()
			}

			else
			{
				if(!chkTime(time))
				{
						retval= false						
						comp.focus()
				}
			}
		}
	}
	else
	{
		retval= false		
		comp.focus()
	}

	if(retval)
	{
		//callDateFunction(comp)
	}
return retval
}


function checkDt(date1){
    retval=true
    var date1arr=new Array()

    date1arr=date1.split("/")

    if(date1arr.length==3){
        var date1d=date1arr[0]
        var date1m=date1arr[1]
        var date1y=date1arr[2]

        date1d=eval(date1d)
        date1m=eval(date1m)
        date1yy=eval(date1y);

		if(date1d==0)
			retval= false
		
		if(date1m==0)
			retval= false

		if(date1yy==0)
			retval= false


        if(date1m<=12){
            if((date1m==1 || date1m==3 || date1m==5 || date1m==7 || date1m==8 || date1m==10 || date1m==12) && (date1d>31)){
				retval= false
			}
            if((date1m==4 || date1m==6 || date1m==9 || date1m==11 ) && (date1d>30)){
				retval= false
			}

			if ((date1y.length <4) || (date1y.length >4)){
				retval= false
			}
        }else{
            retval= false;
		}
    }else{
		retval= false;
	}
    return retval;
}

function chkTime(time1)
{
	var retval=true;

	if( (time1.charAt(time1.length-1) )!=":")
	{
		var time1arr=new Array()
		time1arr=time1.split(":")

		if(time1arr.length==2)
		{
			var time1hr=time1arr[0]
			var time1min=time1arr[1]

			time1hr=parseInt(time1hr)
			time1min=parseInt(time1min)
			if(time1hr<=23)
			{
				if(time1min>60)
				{
						retval=false;
						
				}
			}
			else
					retval=false;
					
		}
		else
			retval=false;
			
	}
	else
			retval=false;
			

	return retval
}


function date_Validate(obj){
	var flag=0;

	var birthDateTime = '';

	//var dtVal=parent.frames[2].document.forms[0].date_of_birth.value;
	var birth_date = parent.frames[2].document.forms[0].birth_date.value;
	var birth_time = parent.frames[2].document.forms[0].birth_time.value;

	if(birth_date!="" && birth_time!="") {

		var dtVal = birth_date+" "+birth_time;
		parent.frames[2].document.forms[0].date_of_birth.value = dtVal;

		var hddDTTM=getCurrentDate('DMYHM',localeName);		
		var diff_bt = parent.frames[2].daysBetween(dtVal,getCurrentDate('DMYHM',localeName),'DMYHM',localeName);
		
		/*	
		if((!parent.frames[2].isBeforeNow(dtVal,'DMYHM',localeName)) && diff_bt!=0) {	
				alert(getMessage("DOB_NOT_GR_TODAY","MP"));
				//parent.frames[2].document.forms[0].date_of_birth.value='';					
				//parent.frames[2].document.forms[0].date_of_birth.focus();
				parent.frames[2].document.forms[0].birth_date.value='';
				parent.frames[2].document.forms[0].birth_date.focus();	
				flag=1;
		} 
		*/
			
		if(diff_bt==0){			

			if(!parent.frames[2].isBeforeNow(dtVal,'DMYHM',localeName)) {
					var msg = self.getMessage("BIRTH_TIME_GREATER_SYSTIME","MP");
					alert(msg);
					//parent.frames[2].document.forms[0].date_of_birth.value='';	
					//parent.frames[2].document.forms[0].date_of_birth.focus();
					parent.frames[2].document.forms[0].birth_time.value='';	
					parent.frames[2].document.forms[0].date_of_birth.value = '';
					parent.frames[2].document.forms[0].birth_time.focus();
					flag=1;
				}
		}

		if(parent.frames[2].document.forms[0].mp_parm_reqdate.value!='' && flag==0)
			mp_parm_reqdate(obj);
		
		if(parent.frames[2].document.forms[0].BDVal1.value != ''){
			getNewBornRegnValues('DtTm');		
		}
	} 
}

function mp_parm_reqdate(obj)
{
	
	var birthdate=parent.frames[2].document.forms[0].mp_parm_reqdate.value;
	var sysdate=parent.frames[2].document.forms[0].mp_parm_systemdate.value;
	var birthenterddate=parent.frames[2].document.forms[0].date_of_birth.value;

	// Added codes for IN023224 by Suresh M on 10.08.2010
	var allow_nb_regn_within_days = parent.frames[2].document.forms[0].allow_nb_regn_within_days.value;
	var allow_nb_regn_unit = parent.frames[2].document.forms[0].allow_nb_regn_unit.value;
	var current_date = getCurrentDate('DMYHM', localeName);

	var allow_ext_nb_regn_within_days = parent.frames[2].document.forms[0].allow_ext_nb_regn_within_days.value;
	var isAllow_External_Newborn = parent.frames[2].document.forms[0].isAllow_External_Newborn.value;
	var born_where = parent.frames[2].document.forms[0].born_where.value;
	var ext_allow_nb_regn_unit = 'd';

	if (allow_nb_regn_unit == 'H')
		allow_nb_regn_unit = 'h'
	else if(allow_nb_regn_unit == 'D')
		allow_nb_regn_unit = 'd'
	 
	var param_date = minusDate(current_date,'DMYHM',localeName,allow_nb_regn_within_days,allow_nb_regn_unit);

	if (isAllow_External_Newborn == "true"
			&& allow_ext_nb_regn_within_days != ''
			&& allow_ext_nb_regn_within_days != null) {
		if (born_where == 'I') {
			if (!isBetween(param_date, current_date, birthenterddate, 'DMYHM',
					localeName)) {
				if (parent.frames[2].document.forms[0].birth_date.value != ''
						&& parent.frames[2].document.forms[0].birth_date.value != null) {
					if (parent.frames[2].document.forms[0].birth_time.value != ''
							&& parent.frames[2].document.forms[0].birth_time.value != null) {
						alert(getMessage('REGN_RESTRICTED_FOR_NB', "MP"));
						parent.frames[2].document.forms[0].birth_date.value = '';
						parent.frames[2].document.forms[0].birth_time.value = '';
						if (parent.frames[2].document.forms[0].birth_date.disabled == true)
							parent.frames[2].document.forms[0].birth_date.disabled = false;
						if (parent.frames[2].document.forms[0].birth_time.disabled == true)
							parent.frames[2].document.forms[0].birth_time.disabled = false;
						if (parent.frames[2].document.forms[0].nb_calander.disabled == true)
							parent.frames[2].document.forms[0].nb_calander.disabled = false;

						// below line added for this CRF MMS-QH-CRF-0145.1
						// [IN:047497]
						if (parent.frames[2].document.forms[0].hij_appl_YN
								&& parent.frames[2].document.forms[0].hij_appl_YN.value == "Y")
							parent.frames[2].document.forms[0].date_of_birth_hj.value = '';
						parent.frames[2].document.forms[0].birth_date.focus();
					}
				}
			}
		}
	} else {
		if (!isBetween(param_date, current_date, birthenterddate, 'DMYHM',
				localeName)) {
			if (parent.frames[2].document.forms[0].birth_date.value != ''
					&& parent.frames[2].document.forms[0].birth_date.value != null) {
				if (parent.frames[2].document.forms[0].birth_time.value != ''
						&& parent.frames[2].document.forms[0].birth_time.value != null) {
					alert(getMessage('REGN_RESTRICTED_FOR_NB', "MP"));
					parent.frames[2].document.forms[0].birth_date.value = '';
					parent.frames[2].document.forms[0].birth_time.value = '';
					if (parent.frames[2].document.forms[0].birth_date.disabled == true)
						parent.frames[2].document.forms[0].birth_date.disabled = false;
					if (parent.frames[2].document.forms[0].birth_time.disabled == true)
						parent.frames[2].document.forms[0].birth_time.disabled = false;
					if (parent.frames[2].document.forms[0].nb_calander.disabled == true)
						parent.frames[2].document.forms[0].nb_calander.disabled = false;

					// below line added for this CRF MMS-QH-CRF-0145.1
					// [IN:047497]
					if (parent.frames[2].document.forms[0].hij_appl_YN
							&& parent.frames[2].document.forms[0].hij_appl_YN.value == "Y")
						parent.frames[2].document.forms[0].date_of_birth_hj.value = '';
					parent.frames[2].document.forms[0].birth_date.focus();
				}
			}
		}
	}

	var param_date_ext = minusDate(current_date, 'DMYHM', localeName,
			allow_ext_nb_regn_within_days, ext_allow_nb_regn_unit);
	if (born_where != 'I' && isAllow_External_Newborn == "true"
			&& allow_ext_nb_regn_within_days != ''
			&& allow_ext_nb_regn_within_days != null) {
		if (!isBetween(param_date_ext, current_date, birthenterddate, 'DMYHM',
				localeName)) {
			if (parent.frames[2].document.forms[0].birth_date.value != ''
					&& parent.frames[2].document.forms[0].birth_date.value != null) {
				if (parent.frames[2].document.forms[0].birth_time.value != ''
						&& parent.frames[2].document.forms[0].birth_time.value != null) {
					alert(getMessage('EXTERNAL_REGN_RESTRICTED_FOR_NB', "MP"));
					parent.frames[2].document.forms[0].birth_date.value = '';
					parent.frames[2].document.forms[0].birth_time.value = '';
					if (parent.frames[2].document.forms[0].birth_date.disabled == true)
						parent.frames[2].document.forms[0].birth_date.disabled = false;
					if (parent.frames[2].document.forms[0].birth_time.disabled == true)
						parent.frames[2].document.forms[0].birth_time.disabled = false;
					if (parent.frames[2].document.forms[0].nb_calander.disabled == true)
						parent.frames[2].document.forms[0].nb_calander.disabled = false;
					// below line added for this CRF MMS-QH-CRF-0145.1
					// [IN:047497]
					if (parent.frames[2].document.forms[0].hij_appl_YN
							&& parent.frames[2].document.forms[0].hij_appl_YN.value == "Y")
						parent.frames[2].document.forms[0].date_of_birth_hj.value = '';
					parent.frames[2].document.forms[0].birth_date.focus();
				}
			}
		}
	}

	// code Ends

	//
		to   = birthdate
	    from = sysdate
		//new
	var a=  birthenterddate.split(" ")
        splitdate=a[0];
        splittime=a[1]
	    
		
		var splitdate1 =splitdate.split("/")
		var splittime1= splittime.split(":")
			
			

		var entered_Date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
	//
        
	 
		a=  to.split(" ")
		splitdate=a[0];
		splittime=a[1]
		splitdate1 =splitdate.split("/")
		splittime1= splittime.split(":")


		 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]),eval(splittime1[1]) )
        
     /*
	// if(Date.parse(birthenterddate) <= Date.parse(birthdate))
	 if(parent.frames[2].isBefore(birthenterddate,birthdate,'DMYHM',localeName))
      {
	     alert(getMessage('REGN_RESTRICTED_FOR_NB',"MP"));		 
		 parent.frames[2].document.forms[0].birth_date.value = '';
		 parent.frames[2].document.forms[0].birth_time.value = '';
		 parent.frames[2].document.forms[0].birth_date.focus();		 
      }
	  */
}
function loadPatSeriesManual(){
	if (document.getElementById("patient_id").value.length==0)
	{
		var arLength = PSGCodeArray.length;
		var q = 0;
		while ( q <= arLength  )
		{
			if ( PSGCodeArray[q] == document.getElementById("pat_ser_grp_code").value )
			{
				if ( PSGPRYNArray[q] == 'Y' )
				{
					if (PSGYNArray[q]=='N')
						parent.frames[1].document.forms[0].patient_id.value = document.getElementById("pat_ser_grp_code").value;
					parent.frames[1].document.forms[0].pat_ser_prefix_reqd_yn.value = "Y";
				}
				else
					parent.frames[1].document.forms[0].pat_ser_prefix_reqd_yn.value = "N";
			}
		q++;
		}		
	}
}

function chk_with_sysdate(obj)
{
	if(obj.value!='')
	{
	var to = getCurrentDate('DMYHM',localeName);

	if(ValidateDateTime(to,obj))
	{
		var str = getMessage("CANNOT_GREATER","MP");
		str = str.replace('#', getLabel('eCommon.date.label','Common'));
		str = str.replace('$', getLabel('Common.SystemDate.label','Common'));
		alert(str);	
		obj.select();
		obj.focus();								
	}
	}
}

function chk_with_birthdate(obj)
{
	
	var obj1=obj;
	if(obj.value!='')
	{
		var to = parent.frames[2].document.forms[0].date_of_birth.value;		
		if(to!='')
		{
			
			if(!isBefore(to,obj1.value,'DMYHM',localeName))
			{
				var str = getMessage("CANNOT_LESSER","MP");
				str = str.replace('#', getLabel('Common.AdmissionDateTime.label','Common'));
				str = str.replace('$', getLabel('Common.birthDate.label','Common'));
				alert(str);
				obj.value='';
				obj.select();
				obj.focus();			
			}
		}

		/*To compare with Sys Date also*/
		if (obj.value!='')
		{
			//var to = parent.frames[2].document.forms[0].system_date.value;			
			var to = getCurrentDate('DMYHM',localeName);			
			if(!isBefore(obj1.value,to,'DMYHM',localeName))
			{
				var str = getMessage("CANNOT_GREATER","MP");
				str = str.replace('#', getLabel('Common.AdmissionDateTime.label','Common'));
				str = str.replace('$', getLabel('Common.SystemDate.label','Common'));
				alert(str);	
				obj.value='';
				obj.select();
				obj.focus();								
			}
		}
	}
}
/*To validate the condition "Adm Date Time >= Birth Date". OnBlur of Birth Date
	- by Vinod 4/10/2006*/
function chkAdmnDate(obj)
{
	var obj1=obj.value;
	if(obj.value!='')
	{
		var to = parent.frames[2].document.forms[0].bcg_datetime.value;
		if(localeName!="en")
		{
			to=convertDate(to,"DMYHM",localeName,"en")
		}
		if(to!='')
		{
			if(!ValidateDateTime(obj1,to))
			{
				var str = getMessage("CANNOT_LESSER","MP");
				str = str.replace('#', getLabel("eMP.BCG.label",'MP')+"/"+getLabel("Common.AdmissionDateTime.label","common"));
				str = str.replace('$', getLabel("Common.birthDate.label","common") + "/" + getLabel("Common.time.label","common"));
				alert(str);
				obj.value='';
				obj.select();
				obj.focus();			
			}
		}
				
		var to = parent.frames[2].document.forms[0].vitk_datetime.value;
		if(localeName!="en")
		{
			to=convertDate(to.value,"DMYHM",localeName,"en")
		}
		if( (to!='') && (obj.value != '') )
		{
			if(!ValidateDateTime(obj1,to))
			{
				var str = getMessage("CANNOT_LESSER","MP");
				str = str.replace('#', getLabel("eMP.VitaminK.label",'MP')+"/"+getLabel("Common.datetime.label","common"));
				str = str.replace('$', getLabel("Common.birthDate.label","common") + "/" + getLabel("Common.time.label","common"));
				alert(str);
				obj.value='';
				obj.select();
				obj.focus();			
			}
		}

		var to = parent.frames[2].document.forms[0].hepb_datetime.value;
		if(localeName!="en")
		{
			to=convertDate(to,"DMYHM",localeName,"en")
		}
		if((to!='') && (obj.value != ''))
		{
			if(!ValidateDateTime(obj1,to))
			{
				var str = getMessage("CANNOT_LESSER","MP");
				str = str.replace('#',getLabel("eMP.HepatitisB.label",'MP')+"/"+getLabel("Common.datetime.label","common") );
				str = str.replace('$', getLabel("Common.birthDate.label","common") + "/" + getLabel("Common.time.label","common"));
				alert(str);
				obj.value='';
				obj.select();
				obj.focus();			
			}
		}
	}
}
function populate_bornat(obj,ctxPath)
{
	var value = obj.value;
	var function_idborn=document.forms[0].function_id_mg.value;
	var ipatenatalfun="";
	if(obj.name=="ate_born_at_locn_type")
	ipatenatalfun="ate_born_at_locn_code";
	else
     ipatenatalfun="born_at_locn_code";
	if(obj.value!='')
	{
		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_form2' id='dum_form2' method='post' action='"+ctxPath+"/eMP/jsp/getNewBornRegnValues.jsp'>"+
                            " <input type='hidden' name='born_at_type' id='born_at_type' value=\""+value+"\">"+
							" <input type='hidden' name='ipatenatalfun' id='ipatenatalfun' value=\""+ipatenatalfun+"\">"+
                            " <input type='hidden' name='field1' id='field1' value='born_at'><input type='hidden' name='function_idborn' id='function_idborn' value=\""+function_idborn+"\">"+
                            " </form></body></html>";
		
		parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.parent.messageFrame.document.dum_form2.action='../../eMP/jsp/getNewBornRegnValues.jsp'
		parent.parent.messageFrame.document.dum_form2.target = "messageFrame";
		parent.parent.messageFrame.document.dum_form2.submit();
	}
	else
	{
		
			var n = parent.frames[2].document.NewbornRegistration_form.born_at_locn_code.options.length;
			for(var i=0;i<n;i++)
			{
				parent.frames[2].document.forms[0].born_at_locn_code.remove("born_at_locn_code");		
			}
			
			var tp =  '---'+getLabel("Common.defaultSelect.label","Common")+'---';
			var opt=parent.frames[2].document.createElement("OPTION");
			opt.text=tp;
			opt.value="";
			parent.frames[2].document.forms[0].born_at_locn_code.add(opt);


			if(obj.name=="ate_born_at_locn_type"){
			var n = parent.frames[2].document.NewbornRegistration_form.ate_born_at_locn_code.options.length;
			for(var i=0;i<n;i++)
			{
				parent.frames[2].document.forms[0].ate_born_at_locn_code.remove("ate_born_at_locn_code");		
			}
			
			var tp =  '---'+getLabel("Common.defaultSelect.label","Common")+'---';
			var opt=parent.frames[2].document.createElement("OPTION");
			opt.text=tp;
			opt.value="";
			parent.frames[2].document.forms[0].ate_born_at_locn_code.add(opt);
		}			
	}
}

async function create() {			
 var patientid=await PatientSearchWithDefaultGender('F','N');
 if(patientid!=null)
	 self.location.href = '../../eMP/jsp/NewbornRegistrationFirst.jsp?patient_id='+patientid+'&accessRights=<%=accessRights%>&parent_details=<%=parent_details%>&function_invoked=<%=function_invoked%>&mother_nursing_unit=<%=mother_nursing_unit%>&mother_bed_no=<%=mother_bed_no%>';		
}
function call_ip() {			
	self.location.href='../../eCommon/html/blank.html';
	parent.parent.frames[1].location.href='../../eMP/jsp/NewbornCurrentInpatients.jsp?accessRights=<%=accessRights%>&parent_details=<%=parent_details%>&function_invoked=<%=function_invoked%>&mother_nursing_unit=<%=mother_nursing_unit%>&mother_bed_no=<%=mother_bed_no%>';			
}
function focusObject()
    {			
		document.getElementById("mother_tab").style.visibility='visible';
		document.getElementById("child_tab").style.visibility='hidden';
		document.getElementById("father_tab").style.visibility='hidden';
	}


function PractLookupRetVal(retVal,objName) //Part of callPractSearch function.
{ 

	var arr;	
	
	
	if(document.NewbornRegistration_form.isRegNewbornApplicable && document.NewbornRegistration_form.isRegNewbornApplicable.value=="true" && objName=="resuscit_practid_desc"){
	
		if(retVal != null){
			arr=retVal.split("~");	
			document.forms[0].resuscit_temp_desc.value=arr[1];
			document.forms[0].resuscit_physician_id.value=arr[0];
            document.forms[0].resuscit_practid_desc.value=arr[1]; 
            document.forms[0].resuscit_attend_pract_id.value=arr[0];					
			//document.forms[0].temp_physician_job_title.value=arr[5];
		}
		else{
			document.forms[0].resuscit_temp_desc.value="";
			document.forms[0].resuscit_physician_id.value="";
			document.forms[0].resuscit_practid_desc.value=""; 
            document.forms[0].resuscit_attend_pract_id.value="";
		}		
	}
	else
	{
		if (retVal != null)
		{
			
			arr=retVal.split("~");	
			document.forms[0].temp_desc.value=arr[1]; 
			document.forms[0].temp_physician_id.value=arr[0];		
			document.forms[0].temp_physician_job_title.value=arr[5];
		}	
		else
		{
			document.forms[0].temp_desc.value = "";
			document.forms[0].temp_physician_id.value = "";
			document.forms[0].temp_physician_job_title.value = "";
		}
	}
		if(objName=="practid_desc")
		fixvaluespractitioner();
		if(objName=="Umb_cord_cut_by1")
		fixvaluesumbcordcutby();
}

async function callPractSearch(obj,target){ //Function for practitioner search.
	
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";
	
	var facility_id = document.forms[0].facility_id.value;
	
	var sqlSec="";
	practName_FName=target.name;
	
	practName_FValue=target.value;
	splty=target.value;
	
	practId_FName=document.forms[0].temp_physician_id.name;	
//do not forget to give aliases as mentioned below

//sql = " SELECT   a.practitioner_id  practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+localeName+"',1) practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, am_get_desc.am_position(position_code,'"+localeName+"',1) job_title FROM am_practitioner_lang_vw a, am_pract_type_lang_vw b,am_speciality_lang_vw c WHERE a.pract_type=b.pract_type AND a.language_id=b.language_id   AND b.language_id=c.language_id AND c.language_id='"+localeName+"' AND a.primary_speciality_code=c.speciality_code AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND ( UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR  UPPER(am_get_desc.am_practitioner(a.practitioner_id,'"+localeName+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(a.practitioner_id,'"+localeName+"',1)))) AND  a.gender LIKE (?) AND upper(nvl(position_code,'123')) like upper(nvl(?,nvl(position_code,'123')))  ";


sql="SELECT a.practitioner_id practitioner_id, a.practitioner_name,a.POSITION_CODE job_title,(CASE  WHEN a.pract_type IS NOT NULL THEN (SELECT desc_sysdef FROM am_pract_type_lang_vw  WHERE language_id = a.language_id AND pract_type = a.pract_type) ELSE NULL END) practitioner_type, am_get_desc.am_speciality (b.primary_speciality_code,  '"+localeName+"', 2 ) primary_specialty, DECODE (a.gender, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender, am_get_desc.am_position (b.position_code, '"+localeName+"', 1) job_title  FROM am_practitioner_lang_vw a, am_pract_all_splty_vw b WHERE a.PRACTITIONER_ID = b.PRACTITIONER_ID AND b.facility_id=NVL('"+facility_id+"',b.facility_id) AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND UPPER(b.primary_speciality_code) LIKE  UPPER(nvl(replace(?,'%',''),a.primary_speciality_code)) AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.PRACTITIONER_NAME)  LIKE UPPER(NVL(?, a.PRACTITIONER_NAME))) AND UPPER(a.gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND a.LANGUAGE_ID = '"+localeName+"' ORDER BY 2 ";

sqlSec="SELECT a.practitioner_id practitioner_id, a.practitioner_name,a.POSITION_CODE job_title,(CASE  WHEN a.pract_type IS NOT NULL  THEN (SELECT desc_sysdef FROM am_pract_type_lang_vw  WHERE language_id = a.language_id                   AND pract_type = a.pract_type) ELSE NULL   END ) practitioner_type, am_get_desc.am_speciality (b.primary_speciality_code,  '"+localeName+"', 2 ) primary_specialty, DECODE (a.gender, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender, am_get_desc.am_position (b.position_code, '"+localeName+"', 1) job_title   FROM am_practitioner_lang_vw a, am_pract_all_splty_vw b  WHERE a.PRACTITIONER_ID = b.PRACTITIONER_ID AND b.facility_id=NVL('"+facility_id+"',b.facility_id) AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))  AND UPPER(b.primary_speciality_code) LIKE  UPPER(nvl(replace(?,'%',''),a.primary_speciality_code)) AND  ( UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) AND UPPER(a.PRACTITIONER_NAME)  LIKE UPPER(NVL(?, a.PRACTITIONER_NAME))) AND UPPER(a.gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND a.LANGUAGE_ID = '"+localeName+"' ORDER BY 2";

//sql = "SELECT   a.practitioner_id  practitioner_id, practitioner_name ,(case when a.pract_type is not null then (select desc_sysdef from am_pract_type_lang_vw where language_id = a.language_id and pract_type = a.pract_type) else null end) practitioner_type, a.primary_speciality_desc primary_specialty,DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, am_get_desc.am_position(position_code,'"+localeName+"',1) job_title FROM am_practitioner_lang_vw a WHERE a.language_id='"+localeName+"' AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND ( UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  OR  UPPER(practitioner_name) LIKE UPPER(NVL(?,practitioner_name))) AND  a.gender LIKE (?) AND upper(nvl(position_code,'123')) like upper(nvl(?,nvl(position_code,'123')))";

//sqlSec= "SELECT   a.practitioner_id  practitioner_id, practitioner_name ,(case when a.pract_type is not null then (select desc_sysdef from am_pract_type_lang_vw where language_id = a.language_id and pract_type = a.pract_type) else null end) practitioner_type, a.primary_speciality_desc primary_specialty,DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, am_get_desc.am_position(position_code,'"+localeName+"',1) job_title FROM am_practitioner_lang_vw a WHERE a.language_id='"+localeName+"' AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND ( UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  AND  UPPER(practitioner_name) LIKE UPPER(NVL(?,practitioner_name))) AND  a.gender LIKE (?) AND upper(nvl(position_code,'123')) like upper(nvl(?,nvl(position_code,'123')))";
//sqlSec= " SELECT   a.practitioner_id  practitioner_id, am_get_desc.am_practitioner(a.practitioner_id,'"+localeName+"',1) practitioner_name ,b.desc_sysdef practitioner_type, c.short_desc primary_specialty, DECODE(a.gender,'M','Male','F','Female','U','Unknown') gender, am_get_desc.am_position(position_code,'"+localeName+"',1) job_title FROM am_practitioner_lang_vw a, am_pract_type_lang_vw b,am_speciality_lang_vw c WHERE a.pract_type=b.pract_type AND a.language_id=b.language_id   AND b.language_id=c.language_id AND c.language_id='"+localeName+"' AND a.primary_speciality_code=c.speciality_code AND a.pract_type LIKE (?)  AND a.primary_speciality_code LIKE UPPER(?)  AND ( UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id))  and  UPPER(am_get_desc.am_practitioner(a.practitioner_id,'"+localeName+"',1)) LIKE UPPER(NVL(?,am_get_desc.am_practitioner(a.practitioner_id,'"+localeName+"',1)))) AND  a.gender LIKE (?) AND upper(nvl(position_code,'123')) like upper(nvl(?,nvl(position_code,'123')))  ";

/*
* if you are passing User Defined SQL and in that if you want to pass any of the folowing in where criteria  :-
*	1.  practioner type
*   2. Speciality /Clinic code
*   3. Job Title
*   4. Gender
*
* then you must pass them in the query string below with folowing names
*	1.  practioner type               ----->practitioner_type
*   2. Speciality /Clinic code    ----->specialty_code
*   3. Job Title							----->job_title
*   4. Gender							----->gender
*
*
*/
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				xmlStr	="<root><SEARCH " ;
				xmlStr += " practName_FName=\"" + practName_FName + "\"";
				xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
				xmlStr += " sql=\"" +escape(sql)+ "\"";
				xmlStr += " sqlSec=\"" +escape(sqlSec)+ "\"";
				xmlStr += " practitioner_type=\"" + "" + "\"";
				xmlStr += " specialty_code=\"" + ""+ "\"";
				xmlStr += " job_title=\"" + "" + "\"";
				xmlStr += " gender=\"" + "" + "\"";

				//escape(sql)
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				responseText = trimString(responseText);
				
				//eval(responseText);
			eval(await practSearch(encodeURIComponent(practName_FName),encodeURIComponent(practName_FValue),splty,responseText));				
}

async function practSearch(practName_FName,practName_FValue,splty,responseText) {
	
	var retVal = 	new String();
	var dialogTop = "" ;
	var dialogHeight= "94vh" ;
	var dialogWidth	= "46vw" ;
		
	if(responseText =="true") {        	
	    dialogWidth="70.5";
	}
	
	var status = "no";
	var arguments	= "" ;
	var tit="Pract Search";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	var sqlArray= new Array();
	//var objName="<%=practName_FName%>";
	var objName=practName_FName;
    arguments='';
	
	//retVal = window.showModalDialog("<%=request.getContextPath()%>/eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+"<%=practName_FValue%>"+"&practitioner_type="+"<%=practitioner_type%>"+"&primary_specialty="+"<%=specialty_code%>"+"&job_title="+"<%=job_title%>"+"&gender="+"<%=gender%>",arguments,features);
	
	retVal = await window.showModalDialog("../../eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+practName_FValue+"&practitioner_type="+"\""+"&primary_specialty="+splty+"&job_title="+"\""+"&gender="+"\"",arguments,features);
	PractLookupRetVal(retVal,objName);
}

function fixvaluespractitioner() //used to set the practitioner information obtained from callpractsearch function.
{
   
	document.forms[0].practid_desc.value=document.forms[0].temp_desc.value;
	document.forms[0].attend_physician_id.value=document.forms[0].temp_physician_id.value;
	document.forms[0].temp_desc.value="";
	document.forms[0].temp_physician_job_title.value="";
	/*Below line added for this CRF ML-MMOH-CRF-0621*/
	if(document.NewbornRegistration_form.isRegNewbornApplicable && document.NewbornRegistration_form.isRegNewbornApplicable.value=="true"){
	
	if(document.forms[0].attend_physician_id && document.forms[0].attend_physician_id.value!="") getNationalId();
	
	}
		
	
	//End ML-MMOH-CRF-0621
}

function getumbcordcutby(Obj) {	
	if(document.forms[0].born_where.value!='I') {
		document.forms[0].Umb_cord_cut_by_physician_id.value = Obj.value;	
		document.forms[0].Umb_cord_cut_by.value = Obj.value;	
	} 
}

function fixvaluesumbcordcutby() //used to set the umblical cord cut by field from callpractsearch function.
{
	if (document.forms[0].born_where.value!='I') {}
	else {
	document.forms[0].Umb_cord_cut_by1.value=document.forms[0].temp_desc.value;
	document.forms[0].Umb_cord_cut_by.value=document.forms[0].temp_physician_job_title.value;
	document.forms[0].Umb_cord_cut_by_physician_id.value=document.forms[0].temp_physician_id.value;
	if(document.forms[0].temp_physician_job_title.value=="CO")
				document.forms[0].Umb_cord_cut_by_desig.value=getLabel("Common.consultant.label","common");
	else if (document.forms[0].temp_physician_job_title.value=="SC")
				document.forms[0].Umb_cord_cut_by_desig.value=getLabel("Common.seniorconsultant.label","common");
	else if (document.forms[0].temp_physician_job_title.value=="SS")
				document.forms[0].Umb_cord_cut_by_desig.value=getLabel("Common.seniorspecialist.label","common");
	else if (document.forms[0].temp_physician_job_title.value=="TR")
				document.forms[0].Umb_cord_cut_by_desig.value=getLabel("Common.trainee.label","common");
	else if (document.forms[0].temp_physician_job_title.value=="SP")
				document.forms[0].Umb_cord_cut_by_desig.value=getLabel("Common.specialist.label","common");
	else if (document.forms[0].temp_physician_job_title.value=="CC")
				document.forms[0].Umb_cord_cut_by_desig.value=getLabel("Common.chiefconsultant.label","common");
	else if (document.forms[0].temp_physician_job_title.value=="IN")
				document.forms[0].Umb_cord_cut_by_desig.value=getLabel("Common.intern.label","common");
	else if (document.forms[0].temp_physician_job_title.value=="RG")
				document.forms[0].Umb_cord_cut_by_desig.value=getLabel("Common.registrar.label","common");
	else if (document.forms[0].temp_physician_job_title.value=="MW")
				document.forms[0].Umb_cord_cut_by_desig.value=getLabel("Common.midwife.label","common");
	else if (document.forms[0].temp_physician_job_title.value=="NS")
				document.forms[0].Umb_cord_cut_by_desig.value=getLabel("Common.nurse.label","common");
	else document.forms[0].Umb_cord_cut_by_desig.value="";
	value_umb_cord_cut_by=document.forms[0].Umb_cord_cut_by_desig.value;
	document.getElementById("nmdesig").innerHTML=value_umb_cord_cut_by;
	}
}

async function getattndpract () // function to call callpractsearch if the text
// field is empty.
{	
	var isAllow_External_Newborn = document.forms[0].isAllow_External_Newborn.value;
	var allow_ext_nb_regn_within_days = document.forms[0].allow_ext_nb_regn_within_days.value;
	var born_where = document.forms[0].born_where.value;
	var temp_desc = document.forms[0].temp_desc.value;
	var temp_physician_id = document.forms[0].temp_physician_id.value;
	if (document.forms[0].practid_desc.value=="")
		{ 
		/*below line added for this CRF ML-MMOH-CRF-0621*/
		if(document.NewbornRegistration_form.isRegNewbornApplicable && document.NewbornRegistration_form.isRegNewbornApplicable.value=="true"){
			if(document.NewbornRegistration_form.attend_physician_id)document.NewbornRegistration_form.attend_physician_id.value="";
			
			if(document.getElementById('nationality_id')!=null)document.getElementById('nationality_id').innerHTML="";
			
			if(document.getElementById('oth_alternate_id')!=null)document.getElementById('oth_alternate_id').innerHTML="";
		}
		//End ML-MMOH-CRF-0621
				} else	{	
        await callPractSearch(document.forms[0].pract_id_search1,
        document.forms[0].practid_desc); 		 	
        fixvaluespractitioner();
         }
	if (temp_desc == "" && isAllow_External_Newborn == "true"
			&& allow_ext_nb_regn_within_days != ''
			&& allow_ext_nb_regn_within_days != null) {
		document.forms[0].temp_physician_id.value = "";
		document.forms[0].attend_physician_id.value = "";
		fixvaluespractitioner();
	}
}

async function getfatherid() //function not in use currently
{
	if (document.forms[0].father_patient_id.value=="")
		{ }
	else
		{	await callPatSearch();}
}

async function getumbcordcutby () //function to call callpractsearch if the text field is empty.	
{
	if (document.forms[0].Umb_cord_cut_by1.value=="")
		{ }
	else
		{	if (document.forms[0].born_where.value!='I') 
			{
				document.forms[0].Umb_cord_cut_by.value=document.forms[0].Umb_cord_cut_by1.value;
				document.forms[0].Umb_cord_cut_by_physician_id.value=document.forms[0].Umb_cord_cut_by1.value;
			}
			else 
			{
				await callPractSearch(document.forms[0].pract_id_search,document.forms[0].Umb_cord_cut_by1); 	fixvaluesumbcordcutby();
			}
		}
}

function enableParity(obj) // Function to enable /disable parity
{
	var invokeMenstrualHistYN = document.getElementById('invokeMenstrualHistYN').value; // 68508
	if (obj.value != "") {
		if ((!isNaN(obj.value)) && parseInt(obj.value) >= 0) {

			if (document.forms[0].parity.disabled) {

				document.forms[0].parity.disabled = false;
				if (document.forms[0].multiple_birth_yn.disabled == false) {
					document.forms[0].parity.select();
				}
			}
		} else {
			alert(getMessage("NUM_ALLOWED", "SM"));
			obj.select();
			obj.focus();
			document.forms[0].parity.value = "";
			document.forms[0].parity.disabled = true;
			return false;
		}
	} else {
		if(invokeMenstrualHistYN == 'Y'){
		document.forms[0].parity.disabled = false;   
		document.forms[0].parity.value = "";    
		if (document.forms[0].practid_desc.style.visibility == "visible") {
			document.forms[0].practid_desc.focus();
		}
		}//end 68508
		else
			{
		document.forms[0].parity.disabled = true;
		document.forms[0].parity.value = "";
		if (document.forms[0].practid_desc.style.visibility == "visible") {
			document.forms[0].practid_desc.focus();
			}
		}
	}
	return true;
}

function disOccpDesc() // Function to enable disable Occupation description
						// text box depending on occupation class.
{
	if (document.forms[0].cboOccupationClass.selectedIndex != 0) {
		if (document.forms[0].cboOccupation.selectedIndex == 0) {
			document.forms[0].Occupation_Desc.disabled = false;
		} else {
			document.forms[0].Occupation_Desc.value = "";
			document.forms[0].Occupation_Desc.disabled = true;
		}
	} else {
		document.forms[0].Occupation_Desc.value = "";
		document.forms[0].Occupation_Desc.disabled = true;
	}
}

function set_foc() {

	// document.forms[0].date_of_birth.focus();
	document.forms[0].birth_date.focus();
}

    function checkwithgravida() //Function to check gravida and parity
    {	
    	var called_function =document.getElementById("called_function").value;//Added by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565
		var isLabelChangeApplicable =document.getElementById("isLabelChangeApplicable").value;//Added by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565
		
		//Below line added for this CRF ML-MMOH-CRF-0621
		var isRegNewbornApplicable =document.getElementById("isRegNewbornApplicable").value; 
	var invokeMenstrualHistYN = document.getElementById('invokeMenstrualHistYN').value; // 68508
	if ((document.forms[0].gravida.value != '' && isRegNewbornApplicable == "false")
			|| (document.forms[0].parity.value != '' && isRegNewbornApplicable == "false")) {

		// 68508 start.
		if (invokeMenstrualHistYN == 'Y') {
			var parity = document.forms[0].parity.value;
			if (parity == "")
				parity = 0;
			parity1 = document.forms[0].parity1.value;
			if (parity1 == "")
				parity1 = 0;
			var parity = parseInt(parity) + parseInt(parity1);
		}// end. 68508
		else
			var parity = parseInt(document.forms[0].parity.value);

		var gravida = parseInt(document.forms[0].gravida.value);
		if (gravida != 0) {
			if (gravida < parity) {
				if ((isLabelChangeApplicable == "true")
						&& (called_function == "IP")) {// Added by Rameswar on
														// 23rd June 2015
														// against HSA-CRF-0223
														// IN050565
					alert(getMessage("PARITYADM_GR_GRAVIDAADM", "MP"));
				} else {
					alert(getMessage("PARITY_GR_GRAVIDA", "MP"));
				}
				document.forms[0].parity.value = ''; // 68508
				document.forms[0].parity1.value = ''; // 68508
				document.forms[0].parity.focus();
				document.forms[0].parity.select();
			}
		} else {
			document.forms[0].gravida.focus();
			document.forms[0].gravida.select();
		}
		return true;

	}
}
function checkGravida() {
	var temp = parseInt(document.forms[0].gravida.value);
	 if(temp==0)
	{	
		alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","Common"));	
		document.forms[0].gravida.value="";
		document.forms[0].gravida.focus();
		document.forms[0].gravida.select();

	}
}
function checkParity()
{	
	var temp = parseInt(document.forms[0].parity.value);	
	if(temp<0)
	{	
		alert(getMessage("ONLY_POSITIVE_NUM","SM"));
		document.forms[0].parity.value = "";
		document.forms[0].parity.focus();
		document.forms[0].parity.select();
	}
}
  
 async  function mothersearch() //Function to invoke search lookup for mother when need for changing the mother id arises.
	{
		var function_id_mg = document.forms[0].function_id_mg.value;

		var patient_id1= new String();
	  	 patient_id1=await PatientSearchWithDefaultGender('F','N');
		 
		 if(patient_id1!=null) 
			 {
				 document.NewbornRegistration_form.mother_patient_id1.value=patient_id1;
				 document.NewbornRegistration_form.mother_patient_id.value=patient_id1;
				 q_mother_patient_id=patient_id1;

				 //Newly added Changing the MothersName 
				 var HTMLVal="<html><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eMP/jsp/GetRelationship.jsp'><input type='hidden' name=callfunction value='namechange'><input type='hidden' name=patient_id1 value="+patient_id1+"><input type='hidden' name='function_id_mg' id='function_id_mg' value = '"+function_id_mg+"'></form></body></html>";
				 parent.parent.frames[2].document.write(HTMLVal);
				 parent.parent.frames[2].document.tempform1.submit()
				 //
			 }		
	} 	

function callcareValidate(captureAntenatalDtlsYN,eventType)
{	
	//if(document.forms[0].ip_install_yn.value == 'Y' && document.forms[0].called_function.value == 'IP')
	if(captureAntenatalDtlsYN == 'Y')
	{
		if (document.forms[0].antenatal_care.checked==true)
		{
			document.getElementById("locngif").style.visibility='visible';
			document.forms[0].antenatal_care.value = 'Y';

			if(eventType == 'onClickEvent')
				document.forms[0].ate_born_where.disabled=false;
			/*
			if(document.forms[0].invoked_from.value!='details_page' && document.forms[0].invoked_from.value!='servlet') {
				document.forms[0].ate_born_where.disabled=false;
			}
			*/
		} else {

			document.getElementById("locngif").style.visibility='hidden';
			document.forms[0].ate_born_where.disabled=true;
			document.forms[0].ate_born_where.value='';
			document.forms[0].ate_born_at_locn_type.disabled=true;
			document.forms[0].ate_born_at_locn_type.value='';

			document.forms[0].antenatal_care.value = 'N';
			

				var n = parent.frames[2].document.NewbornRegistration_form.ate_born_at_locn_code.options.length;
				for(var i=0;i<n;i++)
				{
					parent.frames[2].document.forms[0].ate_born_at_locn_code.remove("ate_born_at_locn_code");		
				}
				
				var tp =  '---'+getLabel("Common.defaultSelect.label","Common")+'---';
				var opt=parent.frames[2].document.createElement("OPTION");
				opt.text=tp;
				opt.value="";
				parent.frames[2].document.forms[0].ate_born_at_locn_code.add(opt);

				document.forms[0].ate_born_at_locn_code.disabled=true;
				
			
		}
	}
}

function checkPatSex(frm)  {
    var arLength = frm.NamePrefixArray.length; 
    var q = 0;
	/*Added By Dharma Start*/
	var called_function	= frm.document.getElementById("called_function").value;
	var isNewBornChngsAppl	= "";
	if(frm.document.getElementById("isNewBornChngsAppl")){
		isNewBornChngsAppl	= frm.document.getElementById("isNewBornChngsAppl").value;
	}
	var newBornDtlsIndex		= 1;
	if(called_function=="IP" && isNewBornChngsAppl	=="true"){
		var newBornDtlsIndex	= 0;
	}
	/*Added By Dharma End*/
    var res = new Boolean(false);
        while ( q <= arLength  )
        {
			if ( (frm.document.getElementById("name_prefix")[newBornDtlsIndex].value!='')  && ( unescape(frm.NamePrefixArray[q]) == frm.document.getElementById("name_prefix")[newBornDtlsIndex].value ) )
            {
				if(frm.PrefixSexArray[q] != frm.document.getElementById("new_born_sex").value && frm.PrefixSexArray[q] != 'B')
                {
					var msg = frm.getMessage("PATIENT_SEX_MISMATCH",'MP');
					if(localeName=='en')
					{
						msg = msg.replace('$',frm.document.forms[0].name_prefix_prompt[newBornDtlsIndex].value);
					}
					else
					{
						msg = msg.replace('$',frm.document.forms[0].name_prefix_oth_prompt[newBornDtlsIndex].value);
					}					
					LocalErrors = LocalErrors +msg	+ " <br>";
                res = false;
                }
                else
                    res = true;
            }
            q++;
        }
    return res;
}

function checkFatherSex(frm)  {
    var arLength = frm.NamePrefixArray.length; 
    var q = 0;
		/*Added By Dharma Start*/
	var called_function	= frm.document.getElementById("called_function").value;
	var isNewBornChngsAppl	= "";
	if(frm.document.getElementById("isNewBornChngsAppl")){
		isNewBornChngsAppl	= frm.document.getElementById("isNewBornChngsAppl").value;
	}
	var fatherDtlsIndex		= 0;
	if(called_function=="IP" && isNewBornChngsAppl	=="true"){
		var fatherDtlsIndex	= 1;
	}
	/*Added By Dharma End*/
    var res = new Boolean(false);
        while ( q <= arLength  )
        {
			if ( (frm.document.getElementById("name_prefix")[fatherDtlsIndex].value!='')  && ( unescape(frm.NamePrefixArray[q]) == frm.document.getElementById("name_prefix")[fatherDtlsIndex].value ) )
            {
				if(frm.PrefixSexArray[q] != 'M' && frm.PrefixSexArray[q] != 'B')
                {
					var msg = frm.getMessage("FATHER_SEX_MISMATCH",'MP');
					if(localeName=='en')
					{
						msg = msg.replace('$',frm.document.forms[0].name_prefix_prompt[fatherDtlsIndex].value);
					}
					else
					{
						msg = msg.replace('$',frm.document.forms[0].name_prefix_oth_prompt[fatherDtlsIndex].value);
					}					
					LocalErrors = LocalErrors +msg	+ " <br>";
                res = false;
                }
                else
                    res = true;
            }
            q++;
        }
    return res;
}

function checkPatSuffixSex(frm)  {
    var arLength = frm.NameSuffixArray.length;
    var q = 0;
    var res = new Boolean(false);
        while ( q <= arLength  )
        {
			if ( (frm.document.getElementById("name_suffix")[1].value!='')  && ( unescape(frm.NameSuffixArray[q]) == frm.document.getElementById("name_suffix")[1].value ) )
            {
				if(frm.SuffixSexArray[q] != frm.document.getElementById("new_born_sex").value && frm.SuffixSexArray[q] != 'B')
                {
					var msg = frm.getMessage("PATIENT_SEX_MISMATCH",'MP');
					if(localeName=='en')
					{
						msg = msg.replace('$',frm.document.getElementById("name_suffix_prompt")[1].value);
					}
					else
					{
						msg = msg.replace('$',frm.document.getElementById("name_suffix_oth_prompt")[1].value);
					}
					LocalErrors = LocalErrors +msg	+ " <br>";
                res = false;
                }
                else
                    res = true;
            }
            q++;
        }
    return res;
}

//Added by Rameswar on 19-Jan-16 for ML-MMOH-CRF-0382
function getPatencyCheckBy () // function to call callpractsearch if the text field is empty.
{	
	if (document.forms[0].PatencyofAnusCheckedBy.value=="")
		{ document.forms[0].pract_id_search_patency_hidden.value='';}
	else
		{	callPractSearch(document.forms[0].pract_id_search_patency,document.forms[0].PatencyofAnusCheckedBy); 	
			
			Patencyvaluespractitioner();
			}
}

function Patencyvaluespractitioner() //used to set the practitioner information obtained from callpractsearch function.
{
	document.forms[0].PatencyofAnusCheckedBy.value=document.forms[0].temp_desc.value;
	document.forms[0].pract_id_search_patency_hidden.value=document.forms[0].temp_physician_id.value;
	document.forms[0].temp_desc.value="";
	document.forms[0].temp_physician_job_title.value="";
	
}
function enablepatencyprac(obj){
if(obj.value!=""){
document.forms[0].PatencyofAnusCheckedBy.disabled=false;
document.forms[0].pract_id_search_patency.disabled=false;
}else{
document.forms[0].PatencyofAnusCheckedBy.value='';
document.forms[0].pract_id_search_patency_hidden.value='';
document.forms[0].PatencyofAnusCheckedBy.disabled=true;
document.forms[0].pract_id_search_patency.disabled=true;
}
}
//Added by Rameswar on 19-Jan-16 for ML-MMOH-CRF-0382

/*Below line added for this CRF ML-MMOH-CRF-0621*/
function getNationalId(){ 
var attend_physician_id=document.NewbornRegistration_form.attend_physician_id.value; 
var accept_national_id_no_yn=document.NewbornRegistration_form.accept_national_id_no_yn.value;
var national_id_no=document.NewbornRegistration_form.national_id_no.value;

            //var xmlDoc=new ActiveXObject("Microsoft.XMLDom")
			var xmlDoc='';
			var xmlHttp = new XMLHttpRequest()			
			xmlStr ="<root><SEARCH " ;
			xmlStr+=" process_id=\"32\" ";
			//xmlStr+=" attend_physician_id=\""+attend_physician_id+"\"";
			xmlStr +=" /></root>" ;			
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml") 
			//xmlHttp.open("POST","ServerValidationXML.jsp?attend_physician_id="+encodeURIComponent(attend_physician_id)+"&process_id=32",false)
			xmlHttp.open("POST","ServerValidationXML.jsp?attend_physician_id="+encodeURIComponent(attend_physician_id)+"&accept_national_id_no_yn="+encodeURIComponent(accept_national_id_no_yn)+"&national_id_no="+encodeURIComponent(national_id_no),false)
			xmlHttp.send(xmlDoc) 
			responseText=xmlHttp.responseText ; 
			responseText = trimString(responseText);
			eval(responseText)
	
}

async function getresuscitpract () // function to call callpractsearch if the text field is empty.
{	
	if (document.forms[0].resuscit_practid_desc && document.forms[0].resuscit_practid_desc.value=="")
		{ 
		/*below line added for this CRF ML-MMOH-CRF-0621*/
		//alert(document.NewbornRegistration_form.isRegNewbornApplicable.value);
		if(document.NewbornRegistration_form.isRegNewbornApplicable && document.NewbornRegistration_form.isRegNewbornApplicable.value=="true"){
			if(document.NewbornRegistration_form.resuscit_physician_id)document.NewbornRegistration_form.resuscit_physician_id.value="";
			
			//if(document.getElementById('nationality_id')!=null)document.getElementById('nationality_id').innerHTML="";
			
			//if(document.getElementById('oth_alternate_id')!=null)document.getElementById('oth_alternate_id').innerHTML="";
		}
		//End ML-MMOH-CRF-0621
		
		}
	else
		{	await callPractSearch1(document.forms[0].resuscit_pract_id_search1,document.forms[0].resuscit_practid_desc); 			fixvaluespractitioner1();}
}

async function callPractSearch1(obj,target){ //Function for practitioner search.
	
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";
	var facility_id = document.forms[0].facility_id.value;
	var sqlSec="";
	practName_FName=target.name;
	practName_FValue=target.value;
	practId_FName=document.forms[0].resuscit_physician_id.name;	


sql="SELECT a.practitioner_id practitioner_id, a.practitioner_name,a.POSITION_CODE job_title,(CASE  WHEN a.pract_type IS NOT NULL THEN (SELECT desc_sysdef FROM am_pract_type_lang_vw  WHERE language_id = a.language_id AND pract_type = a.pract_type) ELSE NULL END) practitioner_type, am_get_desc.am_speciality (b.primary_speciality_code,  '"+localeName+"', 2 ) primary_specialty, DECODE (a.gender, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender, am_get_desc.am_position (b.position_code, '"+localeName+"', 1) job_title  FROM am_practitioner_lang_vw a, am_pract_all_splty_vw b WHERE a.PRACTITIONER_ID = b.PRACTITIONER_ID AND b.facility_id=NVL('"+facility_id+"',b.facility_id) AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type)) AND UPPER(b.primary_speciality_code) LIKE  UPPER(nvl(replace(?,'%',''),a.primary_speciality_code)) AND  (UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) OR UPPER(a.PRACTITIONER_NAME)  LIKE UPPER(NVL(?, a.PRACTITIONER_NAME))) AND UPPER(a.gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND a.LANGUAGE_ID = '"+localeName+"' ORDER BY 2 ";

sqlSec="SELECT a.practitioner_id practitioner_id, a.practitioner_name,a.POSITION_CODE job_title,(CASE  WHEN a.pract_type IS NOT NULL  THEN (SELECT desc_sysdef FROM am_pract_type_lang_vw  WHERE language_id = a.language_id                   AND pract_type = a.pract_type) ELSE NULL   END ) practitioner_type, am_get_desc.am_speciality (b.primary_speciality_code,  '"+localeName+"', 2 ) primary_specialty, DECODE (a.gender, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender, am_get_desc.am_position (b.position_code, '"+localeName+"', 1) job_title   FROM am_practitioner_lang_vw a, am_pract_all_splty_vw b  WHERE a.PRACTITIONER_ID = b.PRACTITIONER_ID AND b.facility_id=NVL('"+facility_id+"',b.facility_id) AND UPPER(a.pract_type) LIKE UPPER(NVL(?,a.pract_type))  AND UPPER(b.primary_speciality_code) LIKE  UPPER(nvl(replace(?,'%',''),a.primary_speciality_code)) AND  ( UPPER(a.practitioner_id) LIKE UPPER(NVL(?,a.practitioner_id)) AND UPPER(a.PRACTITIONER_NAME)  LIKE UPPER(NVL(?, a.PRACTITIONER_NAME))) AND UPPER(a.gender) LIKE NVL(UPPER(?), UPPER(a.gender)) AND UPPER(NVL(a.POSITION_CODE, '123')) LIKE UPPER(NVL(?,NVL(a.POSITION_CODE,'123'))) AND a.LANGUAGE_ID = '"+localeName+"' ORDER BY 2";

				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				xmlStr	="<root><SEARCH " ;
				xmlStr += " practName_FName=\"" + practName_FName + "\"";
				xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
				xmlStr += " sql=\"" +escape(sql)+ "\"";
				xmlStr += " sqlSec=\"" +escape(sqlSec)+ "\"";
				xmlStr += " practitioner_type=\"" + "" + "\"";
				xmlStr += " specialty_code=\"" + ""+ "\"";
				xmlStr += " job_title=\"" + "" + "\"";
				xmlStr += " gender=\"" + "" + "\"";

				//escape(sql)
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				responseText = trimString(responseText);
				//eval(responseText);	
				eval(await practSearch(practName_FName,encodeURIComponent(practName_FValue),responseText));
}

async function practSearch(practName_FName,practName_FValue,responseText) {
	var retVal = 	new String();
	var dialogTop = "10px" ;
	var dialogHeight= "450px" ;
	var dialogWidth	= "700px" ;
		
	if(responseText =="true") {        	
	    dialogWidth="70.5";
	}
	
	var status = "no";
	var arguments	= "" ;
	var tit="Pract Search";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	var sqlArray= new Array();
	//var objName="<%=practName_FName%>";
	var objName=practName_FName;
    arguments='';
	
	//retVal = window.showModalDialog("<%=request.getContextPath()%>/eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+"<%=practName_FValue%>"+"&practitioner_type="+"<%=practitioner_type%>"+"&primary_specialty="+"<%=specialty_code%>"+"&job_title="+"<%=job_title%>"+"&gender="+"<%=gender%>",arguments,features);
	
	retVal = await window.showModalDialog("../../eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+practName_FValue+"&practitioner_type="+"\""+"&primary_specialty="+"\""+"&job_title="+"\""+"&gender="+"\"",arguments,features);
	PractLookupRetVal(retVal,objName);
}


function fixvaluespractitioner1() //used to set the practitioner information obtained from callpractsearch function.
{ 
   
	document.forms[0].resuscit_practid_desc.value=document.forms[0].resuscit_temp_desc.value;
	document.forms[0].resuscit_attend_pract_id.value=document.forms[0].resuscit_physician_id.value;
	document.forms[0].resuscit_temp_desc.value="";
	//document.forms[0].temp_physician_job_title.value="";
	/*Below line added for this CRF ML-MMOH-CRF-0621*/
	//if(document.NewbornRegistration_form.isRegNewbornApplicable && document.NewbornRegistration_form.isRegNewbornApplicable.value=="true"){
	//if(document.forms[0].attend_physician_id && document.forms[0].attend_physician_id.value!="") getNationalId();
	//}
		
	
	//End ML-MMOH-CRF-0621
}


//End ML-MMOH-CRF-0621

function disableonload(){
	if(document.forms[0].patency_of_anus_yn.value==""){
		document.forms[0].PatencyofAnusCheckedBy.value='';
		document.forms[0].pract_id_search_patency_hidden.value='';
		document.forms[0].PatencyofAnusCheckedBy.disabled=true;
		document.forms[0].pract_id_search_patency.disabled=true;
	}
	if(document.getElementById("linkNeonatalResuscitation")){
		var CalledFromFunction			= document.forms[0].CalledFromFunction.value;
		var disable_finalized_button_yn = document.forms[0].disable_finalized_button_yn.value;
		var sel_accession_num			= document.forms[0].sel_accession_num.value;
		var calling_module_id			= document.forms[0].calling_module_id.value;
		if(CalledFromFunction=="MAINTAIN_BIRTH" && disable_finalized_button_yn=="Y" && sel_accession_num==""){
			document.getElementById("linkNeonatalResuscitation").style.display="none";
		}
	}
}

function tab_click1(id,id1){
	tab_click(id);
}

function expandCollapse(calledFrom) {										
	if(calledFrom == 'MD') {
		if(document.getElementById("mother_dtls").style.display == '')
			document.getElementById("mother_dtls").style.display='inline';
		if(document.getElementById("mother_dtls").style.display == 'inline') {
			document.getElementById("mother_dtls").style.display='none';	
			document.getElementById("mother_dtls_link").innerHTML="<input type='button' class='button' value='+'>";											
		} else {
			document.getElementById("mother_dtls").style.display='inline';		
			document.getElementById("mother_dtls_link").innerHTML="<input type='button' class='button' value='-'>"; 							
		} 	
	} else if(calledFrom == 'FD') {
		if(document.getElementById("father_dtls").style.display == '')
			document.getElementById("father_dtls").style.display='inline';
		if(document.getElementById("father_dtls").style.display == 'inline') {
			document.getElementById("father_dtls").style.display='none';
			document.getElementById("father_dtls_link").innerHTML="<input type='button' class='button' value='+'>";							
		} else {
			document.getElementById("father_dtls").style.display='inline';		
			document.getElementById("father_dtls_link").innerHTML="<input type='button' class='button' value='-'>";							
		}	
	} else if(calledFrom == 'ND') {
		if(document.getElementById("newborn_dtls").style.display == '')
			document.getElementById("newborn_dtls").style.display='inline';
		if(document.getElementById("newborn_dtls").style.display == 'inline') {
			document.getElementById("newborn_dtls").style.display='none';							
			document.getElementById("newborn_dtls_link").innerHTML="<input type='button' class='button' value='+'>"; 							
		} else {
			document.getElementById("newborn_dtls").style.display='inline';		
			document.getElementById("newborn_dtls_link").innerHTML="<input type='button' class='button' value='-'>"; 							
		} 	
	} else if(calledFrom == 'VD') {
		if(document.getElementById("vaccin_dtls").style.display == '')
			document.getElementById("vaccin_dtls").style.display='inline';  
		if(document.getElementById("vaccin_dtls").style.display == 'inline') {
			document.getElementById("vaccin_dtls").style.display='none';							
			document.getElementById("vaccin_dtls_link").innerHTML="<input type='button' class='button' value='+'>";							
		} else {
			document.getElementById("vaccin_dtls").style.display='inline';		
			document.getElementById("vaccin_dtls_link").innerHTML="<input type='button' class='button' value='-'>"; 							
		} 	
	}
}

function apgarLink(obj){
	var apgarLinkValue=document.getElementById("apgar_dtls_name").value;
	if(obj.value=="+"){
		obj.value="-";
		document.getElementById("apgarDivID").style.visibility="visible";
		//document.getElementById("apgarDivID").style.display="";
		document.getElementById("apgarDivID").style = "display";
		//document.getElementById("apgarDivID").style.display="inline-table";
	}else{
		obj.value="+";
		document.getElementById("apgarDivID").style.visibility="hidden";
		document.getElementById("apgarDivID").style.display="None";
	}
}

function apgarSelect(obj){
	if(document.getElementById("function_id_mg") && document.getElementById("function_id_mg").value=="MAINTAIN_BIRTH"){
		document.getElementById("apgar_score_changedYN").value="Y";
	}
	var min_1_1;
	var min_1_2;
	var min_1_3;
	var min_1_4;
	var min_1_5;
	var name=obj.name;	
	if(name=='heart_rate_in_1_min_sel'){
		document.getElementById("heart_rate_in_1_min").value=obj.value;
	}else if(name=='heart_rate_in_5_min_sel'){
		document.getElementById("heart_rate_in_5_min").value=obj.value;
	}else if(name=='heart_rate_in_10_min_sel'){
		document.getElementById("heart_rate_in_10_min").value=obj.value;
	}else if(name=='breathing_in_1_min_sel'){
		document.getElementById("breathing_in_1_min").value=obj.value;
	}else if(name=='breathing_in_5_min_sel'){
		document.getElementById("breathing_in_5_min").value=obj.value;
	}else if(name=='breathing_in_10_min_sel'){
		document.getElementById("breathing_in_10_min").value=obj.value;
	}else if(name=='grimace_in_1_min_sel'){
		document.getElementById("grimace_in_1_min").value=obj.value;
	}else if(name=='grimace_in_5_min_sel'){
		document.getElementById("grimace_in_5_min").value=obj.value;
	}else if(name=='grimace_in_10_min_sel'){
		document.getElementById("grimace_in_10_min").value=obj.value;
	}else if(name=='activity_in_1_min_sel'){
		document.getElementById("activity_in_1_min").value=obj.value;
	}else if(name=='activity_in_5_min_sel'){
		document.getElementById("activity_in_5_min").value=obj.value;
	}else if(name=='activity_in_10_min_sel'){
		document.getElementById("activity_in_10_min").value=obj.value;
	}else if(name=='appearance_in_1_min_sel'){
		document.getElementById("appearance_in_1_min").value=obj.value;
	}else if(name=='appearance_in_5_min_sel'){
		document.getElementById("appearance_in_5_min").value=obj.value;
	}else if(name=='appearance_in_10_min_sel'){
		document.getElementById("appearance_in_10_min").value=obj.value;
	}
	if(name=='heart_rate_in_1_min_sel'|| name=='breathing_in_1_min_sel' || name=='grimace_in_1_min_sel' || name=='activity_in_1_min_sel' || name=='appearance_in_1_min_sel'){
		min_1_1=document.getElementById("heart_rate_in_1_min").value;
		min_1_2=document.getElementById("breathing_in_1_min").value;
		min_1_3=document.getElementById("grimace_in_1_min").value;
		min_1_4=document.getElementById("activity_in_1_min").value;
		min_1_5=document.getElementById("appearance_in_1_min").value;
		if(min_1_1=="" && min_1_2 =="" && min_1_3 =="" && min_1_4 =="" && min_1_5==""){
			document.getElementById("apgar_score").value="";
		}else{
			if(min_1_1==""){
				min_1_1=0;
			}
			if(min_1_2==""){
				min_1_2=0;
			}
			if(min_1_3==""){
				min_1_3=0;
			}
			if(min_1_4==""){
				min_1_4=0;
			}
			if(min_1_5==""){
				min_1_5=0;
			}
			var totalValue=eval(min_1_1)+eval(min_1_2)+eval(min_1_3)+eval(min_1_4)+eval(min_1_5);
			document.getElementById("apgar_score").value=totalValue;
		}
	}else if(name=='heart_rate_in_5_min_sel'|| name=='breathing_in_5_min_sel' || name=='grimace_in_5_min_sel' || name=='activity_in_5_min_sel' || name=='appearance_in_5_min_sel'){
		var min_1_1=document.getElementById("heart_rate_in_5_min").value;
		var min_1_2=document.getElementById("breathing_in_5_min").value;
		var min_1_3=document.getElementById("grimace_in_5_min").value;
		var min_1_4=document.getElementById("activity_in_5_min").value;
		var min_1_5=document.getElementById("appearance_in_5_min").value;
		if(min_1_1=="" && min_1_2 =="" && min_1_3 =="" && min_1_4 =="" && min_1_5==""){
			document.getElementById("apgar_score_five_min").value="";
		}else{
			if(min_1_1==""){
				min_1_1=0;
			}
			if(min_1_2==""){
				min_1_2=0;
			}
			if(min_1_3==""){
				min_1_3=0;
			}
			if(min_1_4==""){
				min_1_4=0;
			}
			if(min_1_5==""){
				min_1_5=0;
			}
			var totalValue=eval(min_1_1)+eval(min_1_2)+eval(min_1_3)+eval(min_1_4)+eval(min_1_5);
			document.getElementById("apgar_score_five_min").value=totalValue;
		}
	}else if(name=='heart_rate_in_10_min_sel'|| name=='breathing_in_10_min_sel' || name=='grimace_in_10_min_sel' || name=='activity_in_10_min_sel' || name=='appearance_in_10_min_sel'){
		var min_1_1=document.getElementById("heart_rate_in_10_min").value;
		var min_1_2=document.getElementById("breathing_in_10_min").value;
		var min_1_3=document.getElementById("grimace_in_10_min").value;
		var min_1_4=document.getElementById("activity_in_10_min").value;
		var min_1_5=document.getElementById("appearance_in_10_min").value;
		if(min_1_1=="" && min_1_2 =="" && min_1_3 =="" && min_1_4 =="" && min_1_5==""){
			document.getElementById("apgar_score_ten_min").value="";
		}else{
			if(min_1_1==""){
				min_1_1=0;
			}
			if(min_1_2==""){
				min_1_2=0;
			}
			if(min_1_3==""){
				min_1_3=0;
			}
			if(min_1_4==""){
				min_1_4=0;
			}
			if(min_1_5==""){
				min_1_5=0;
			}
			var totalValue=eval(min_1_1)+eval(min_1_2)+eval(min_1_3)+eval(min_1_4)+eval(min_1_5);
			document.getElementById("apgar_score_ten_min").value=totalValue;
		}
	}
}

