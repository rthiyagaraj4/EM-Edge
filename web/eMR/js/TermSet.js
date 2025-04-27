var	function_id		= "" ;
var	result			= false;
var	flag			= "" ;
var	message			= "" ;
var     previous_level=parseInt(0);
var     previous_level1=parseInt(0);

    
//Function to create a value in insert mode...
function create()
{
    f_query_add_mod.location.href="../../eMR/jsp/TermSetAddModify.jsp?mode=1";
}
//*******************************************************************

//Function to create a value in update mode...
function query() 
{
	f_query_add_mod.location.href="../../eMR/jsp/TermSetQueryCriteria.jsp";
}
//*******************************************************************

//function to check whether on apply,the flow can be proceeded...
 function checkIsValidForProceed()
{

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}


//*******************************************************************
//function to submit the form.......
function apply()

{

	if (! (checkIsValidForProceed()) )
    {

		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 


	   var formObj = f_query_add_mod.document.TermSetAddModify_Form;

        var level=parseInt(0);
	if(formObj.mode.value=="1")
	{
	level=formObj.Classification_Levels.value;

	if(formObj.Diag_Spec_yn.checked==true)
	  formObj.Diag_Spec_yn.value="Y";
	else
	  formObj.Diag_Spec_yn.value="N";

	if(formObj.Proc_Spec_yn.checked==true)
	  formObj.Proc_Spec_yn.value="Y";
	else
	  formObj.Proc_Spec_yn.value="N";

	if(formObj.Build_Statistics_yn.checked==true)
	  formObj.Build_Statistics_yn.value="Y";
	else
	  formObj.Build_Statistics_yn.value="N";

	if(formObj.Build_Episode_yn.checked==true)
	  formObj.Build_Episode_yn.value="Y";
	else
	  formObj.Build_Episode_yn.value="N";

	if(formObj.Priority_yn.checked==true)
	  formObj.Priority_yn.value="Y";
	else
	  formObj.Priority_yn.value="N";

	if(formObj.Age_Group_yn.checked==true)
	  formObj.Age_Group_yn.value="Y";
	else
	  formObj.Age_Group_yn.value="N";

	if(formObj.Notification_yn.checked==true)
	  formObj.Notification_yn.value="Y";
	else
	  formObj.Notification_yn.value="N";

	if(formObj.Sensitivity_yn.checked==true)
	  formObj.Sensitivity_yn.value="Y";
	else
	  formObj.Sensitivity_yn.value="N";

	if(formObj.Diag_Nature_yn.checked==true)
	  formObj.Diag_Nature_yn.value="Y";
	else
	  formObj.Diag_Nature_yn.value="N";

	if(formObj.Diag_Factor_yn.checked==true)
	  formObj.Diag_Factor_yn.value="Y";
	else
	  formObj.Diag_Factor_yn.value="N";

	if(formObj.Severity_yn.checked==true)
	  formObj.Severity_yn.value="Y";
	else
	  formObj.Severity_yn.value="N";

	if(formObj.Onset_Type_yn.checked==true)
	  formObj.Onset_Type_yn.value="Y";
	else
	  formObj.Onset_Type_yn.value="N";

	if(formObj.enc_stage_appl_yn.checked==true)
	  formObj.enc_stage_appl_yn.value="Y";
	else
	  formObj.enc_stage_appl_yn.value="N";
	
	/*Added by Kamatchi S for ML-MMOH-CRF-1581 START*/
		if(formObj.isEnc.value==true){
		if(formObj.inpatient_appl_yn.checked==true)
			formObj.inpatient_appl.value="Y";
		else
			formObj.inpatient_appl.value="N";

		if(formObj.daycare_appl_yn.checked==true)
			formObj.daycare_appl.value="Y";
		else
			formObj.daycare_appl.value="N";
		}
		/*Added by Kamatchi S for ML-MMOH-CRF-1581 START*/


	if(formObj.diag_class_appl.checked==true)
	  formObj.diag_class_appl.value="Y";
	else
	  formObj.diag_class_appl.value="N";

	//Below Added by Suji Keerthi for ML-MMOH-CRF-1395 on Dec-23,2020 
	if(formObj.isDiag.value==true){
	    if(formObj.diagnosis_class_mand_yn.checked==true)
	      formObj.diag_classification_mand.value="Y";
	    else
	      formObj.diag_classification_mand.value="N";
	}
	//Ended by Suji Keerthi for ML-MMOH-CRF-1395 on Dec-23,2020 
	
	}
	else if(formObj.mode.value=="2")
	{

		  level=formObj.classification_level1.value;
		if(formObj.Diag_Spec_yn.checked==true)
		  formObj.diag_spec.value="Y";
		else
		  formObj.diag_spec.value="N";

		if(formObj.Proc_Spec_yn.checked==true)
		  formObj.proc_spec.value="Y";
		else
		  formObj.proc_spec.value="N";

		if(formObj.Build_Statistics_yn.checked==true)
		  formObj.build_stat.value="Y";
		else
		  formObj.build_stat.value="N";

		if(formObj.Build_Episode_yn.checked==true)
		  formObj.build_eoc.value="Y";
		else
		  formObj.build_eoc.value="N";

		if(formObj.Priority_yn.checked==true)
		  formObj.priority.value="Y";
		else
		  formObj.priority.value="N";

		if(formObj.Age_Group_yn.checked==true)
		  formObj.agegroup.value="Y";
		else
		  formObj.agegroup.value="N";

		if(formObj.Notification_yn.checked==true)
		  formObj.notification.value="Y";
		else
		  formObj.notification.value="N";

		if(formObj.Sensitivity_yn.checked==true)
		  formObj.sensitivity.value="Y";
		else
		  formObj.sensitivity.value="N";

		if(formObj.Diag_Nature_yn.checked==true)
		  formObj.nature.value="Y";
		else
		  formObj.nature.value="N";

		if(formObj.Diag_Factor_yn.checked==true)
		  formObj.factors.value="Y";
		else
		  formObj.factors.value="N";

		if(formObj.Severity_yn.checked==true)
		  formObj.severity.value="Y";
		else
		  formObj.severity.value="N";

		if(formObj.Onset_Type_yn.checked==true)
		  formObj.onset_type.value="Y";
		else
		  formObj.onset_type.value="N";

		if(formObj.enc_stage_appl_yn.checked==true)
		  formObj.enc_stage_appl_yn.value="Y";
		else
		  formObj.enc_stage_appl_yn.value="N";

		/*Added by Kamatchi S for ML-MMOH-CRF-1581 START*/
		if(formObj.isEnc.value==true){
	
		if(formObj.inpatient_appl_yn.checked==true)
			formObj.inpatient_appl_yn.value="Y";
		else
			formObj.inpatient_appl_yn.value="N";

		if(formObj.daycare_appl_yn.checked==true)
			formObj.daycare_appl_yn.value="Y";
		else
			formObj.daycare_appl_yn.value="N";
		}
		/*Added by Kamatchi S for ML-MMOH-CRF-1581 START*/

		
		//Below Added by Suji Keerthi for ML-MMOH-CRF-1395 on Dec-23,2020 
		if(formObj.isDiag.value==true){
		 if(formObj.diagnosis_class_mand_yn.checked==true)
		  formObj.diagnosis_class_mand_yn.value="Y";
		else
		  formObj.diagnosis_class_mand_yn.value="N";
		}
	//Ended by Suji Keerthi for ML-MMOH-CRF-1395 on Dec-23,2020 

		if(formObj.diag_class_appl.checked==true)
		  formObj.diag_class_appl.value="Y";
		else
		  formObj.diag_class_appl.value="N";	
		


		if(formObj.appl_for_recoders.checked==true)
		  formObj.appl_for_recoders.value="Y";
		else
		  formObj.appl_for_recoders.value="N";

		if(formObj.diag_spec.value == "Y")
		{
			if(formObj.free_txt_appl.checked==true)
			  formObj.free_txt_appl.value="Y";
			else
			  formObj.free_txt_appl.value="N";
		}
		else
		{
			  formObj.free_txt_appl.value="N";

		}

		
			
}

	var j=parseInt(0);
	var i=parseInt(0);

	var fields = new Array (formObj.TermSet_ID,formObj.TermSet_Desc);
	var names = new Array ( getLabel("Common.identification.label","Common"),getLabel("Common.description.label","Common"));

	if(formObj.CutOff_Period.value!="")
	{
	  i=parseInt(4);
	  fields[2]=formObj.CutOff_Period;
	  names[2]= getLabel("eMP.CutOffPeriod.label","MP");
	  fields[3]=formObj.CutOff_Unit;
	  names[3]= getLabel("eMR.CutOffUnit.label","MR");
      	}
	else if(formObj.CutOff_Period.value=="")
	{
	  i=parseInt(2);
	}

	var k=parseInt(0);
	var codelength=parseInt(0);
	var codelength_sum=parseInt(0);
	for(j=1,k=parseInt(i);j<=level,k<(i+(2*level));j++,k=k+2)
	{
	  codelength=eval("formObj.CodeLength"+j).value;
	  codelength_sum=parseInt(codelength_sum)+parseInt(codelength);
	  fields[k]=eval("formObj.Description"+j);
          fields[k+1]=eval("formObj.CodeLength"+j);
          names[k]=getLabel("Common.Level.label","Common")+" "+j+" "+getLabel("Common.description.label","Common");
	  names[k+1]=getLabel("Common.Level.label","Common")+" "+j+" "+getLabel("eMR.CodeLength.label","MR");

	}			

        if(formObj.eff_status_yn.checked == true)
	{
		formObj.eff_status_yn.value = "E";
	}
	else
	{
        	formObj.eff_status_yn.value = "D";
        }

        var disp_type="M";
	var specfield=new Array(formObj.TermSet_ID);
	var specname=new Array(getLabel("Common.identification.label","Common"));
	var error_jsp="../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.SpecialCharCheck(specfield, specname, messageFrame,disp_type,error_jsp))
	{
        if(f_query_add_mod.checkFieldsofMst(fields, names, messageFrame))
	{
	  if(codelength_sum>30)
          {
	  var msg=getMessage("SUM_CODELENGTH_MAX_30",'MR');
	  messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
	  return false ;
          }
  			formObj.diag_class_appl.disabled = false;		
			formObj.appl_for_recoders.disabled = false;
			formObj.free_txt_appl.disabled = false;

          formObj.submit();
        }
	}
}

//*******************************************************************
//function to retain the values according to the mode on apply
function onSuccess()
{
	
	var frmobj=f_query_add_mod.document.TermSetAddModify_Form;
	if(frmobj.mode.value == "1" )
	{
		frmobj.reset();
	}
	else if(frmobj.mode.value == "2")
	{
		var qry_str="&termset_id="+frmobj.TermSet_ID.value+"&termset_desc="+frmobj.TermSet_Desc.value+"&diag_spec="+frmobj.Diag_Spec_yn.value+"&proc_spec="+frmobj.Proc_Spec_yn.value+"&build_stat="+frmobj.Build_Statistics_yn.value+"&build_eoc="+frmobj.Build_Episode_yn.value+"&priority="+frmobj.Priority_yn.value+"&agegroup="+frmobj.Age_Group_yn.value+"&nature="+frmobj.Diag_Nature_yn.value+"&factors="+frmobj.Diag_Factor_yn.value+"&notification="+frmobj.Notification_yn.value+"&sensitivity="+frmobj.Sensitivity_yn.value+"&severity="+frmobj.Severity_yn.value+"&onset_type="+frmobj.Onset_Type_yn.value+"&enc_stage="+frmobj.enc_stage_appl_yn.value+"&defn_level="+frmobj.classification_level1.value+"&cutoff_period="+frmobj.CutOff_Period.value+"&cutoff_unit="+frmobj.cutoff_unit1.value+"&eff_status="+frmobj.eff_status_yn.value+"&level1_description="+frmobj.Description1.value+"&level2_description="+frmobj.Description2.value+"&level3_description="+frmobj.Description3.value+"&level4_description="+frmobj.Description4.value+"&level5_description="+frmobj.Description5.value+"&level6_description="+frmobj.Description6.value+"&level7_description="+frmobj.Description7.value+"&level8_description="+frmobj.Description8.value+"&level9_description="+frmobj.Description9.value+"&level10_description="+frmobj.Description10.value+"&level1_codelength="+frmobj.CodeLength1.value+"&level2_codelength="+frmobj.CodeLength2.value+"&level3_codelength="+frmobj.CodeLength3.value+"&level4_codelength="+frmobj.CodeLength4.value+"&level5_codelength="+frmobj.CodeLength5.value+"&level6_codelength="+frmobj.CodeLength6.value+"&level7_codelength="+frmobj.CodeLength7.value+"&level8_codelength="+frmobj.CodeLength8.value+"&level9_codelength="+frmobj.CodeLength9.value+"&level10_codelength="+frmobj.CodeLength10.value+"&inpatient_appl="+frmobj.inpatient_appl.value+"&daycare_appl="+frmobj.daycare_appl.value+"&diag_classification_mand="+frmobj.diag_classification_mand.value;
        f_query_add_mod.location.href='../../eMR/jsp/TermSetAddModify.jsp?mode=2'+qry_str;//inpatient_appl and daycare_appl Added by Kamatchi S for ML-MMOH-CRF-1581
		//diag_classification_mand added by Suji Keerthi for ML-MMOH-CRF-1395 US001
	}
}

//*******************************************************************
function reset()
{
	var url=f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1) 
		f_query_add_mod.location.reload();

}
//*******************************************************************
//function to display the levels according to the selected value.
function Display_Level(obj)
{
  var tabObj=document.TermSetAddModify_Form.all.Classification_Level;
  var formObj=document.TermSetAddModify_Form;

  for(var a=3;a<=11;a++)
  {
   tabObj.rows[a].style.display='none';
   tabObj.rows[a].style.visibility='hidden';
  }

  var level=obj.value;  
  if(parseInt(previous_level)>parseInt(level))
  { 
    var a=parseInt(0);
    for(a=parseInt(level)+1;a<=parseInt(previous_level);a++)
    {
      eval("formObj.Description"+a).value="";
      eval("formObj.CodeLength"+a).value="";
    }
  }

  var k=parseInt(0);
  for(k=2;k<=level;k++)
  {
   tabObj.rows[k+1].style.display='';
   tabObj.rows[k+1].style.visibility='visible';
  }
  previous_level=parseInt(level);
}
//*******************************************************************
//function to display the mandatory gif on blur of the cutoff_period textbox
function Display_Mandatory(obj)
{
var formObj=document.TermSetAddModify_Form;
var CutOff_Value=obj.value;

if(CutOff_Value!="")
{
	document.getElementById('Cutoff_Mandatory').style.visibility='visible';
}
else if(CutOff_Value=="")
{
	document.getElementById('Cutoff_Mandatory').style.visibility='hidden';
  formObj.CutOff_Unit.value="";
}
}
//***********************************************************************
function CheckCutoff()
{
  var formObj=document.TermSetAddModify_Form;
  if(formObj.CutOff_Period.value=="")
  {
    formObj.CutOff_Unit.value="";
  }
}
//******************************************************************************
function Cutoff_Change(obj)
{
  document.TermSetAddModify_Form.cutoff_unit1.value=obj.value;
}
//**********************************************************************************
function ModifyMode()
{
  var formObj=document.TermSetAddModify_Form;

  
  if(formObj.mode.value=="2")
  {
    if(formObj.CutOff_Period.value!="")
    {
       document.getElementById('Cutoff_Mandatory1').style.display='';
       document.getElementById('Cutoff_Mandatory1').style.visibility='visible';
    }
    else if(formObj.CutOff_Period.value=="")
    {
//     formObj.all.Cutoff_Mandatory1.style.display='none';
     document.getElementById('Cutoff_Mandatory1').style.display = 'none';
//     formObj.all.Cutoff_Mandatory1.style.visibility='hidden';
     document.getElementById('Cutoff_Mandatory1').style.visibility='hidden';
    }
  }
}
//************************************************************************************
function ModifyDisplay_Mandatory(obj)
{
var formObj=document.TermSetAddModify_Form;
var CutOff_Value=obj.value;
if(CutOff_Value!="" && formObj.eff_status.value=='E')
{
  formObj.CutOff_Unit.disabled=false;
  document.getElementById('Cutoff_Mandatory1').style.visibility='visible';
  document.getElementById('Cutoff_Mandatory1').style.display='';
}
else if(CutOff_Value=="")
{
	formObj.CutOff_Unit.disabled=true;
	document.getElementById('Cutoff_Mandatory1').style.visibility='hidden';
	document.getElementById('Cutoff_Mandatory1').style.display='none';
	formObj.CutOff_Unit.value="";
	formObj.cutoff_unit1.value="";
}
}
//******************************************************************
//function to display the levels in the modify mode according to the value in the list box
function Display_Level_Modify(obj)
{
  var tabObj=document.getElementById("Classification_Level1");
  var formObj=document.TermSetAddModify_Form;

  formObj.classification_level1.value=obj.value;

  var loadlevel=parseInt(formObj.classification_level.value);

  var level=parseInt(obj.value);

  for(a=loadlevel;a<=level;a++)
  {
   tabObj.rows[a+1].style.display='';
   tabObj.rows[a+1].style.visibility='visible';
  }

  if(parseInt(level)<parseInt(loadlevel))
  {
    var x=parseInt(0);
    for(x=parseInt(level+1);x<=parseInt(loadlevel);x++)
    {
      var t=parseInt(x);
      eval("formObj.Description"+t).value="";
      eval("formObj.CodeLength"+t).value="";
      tabObj.rows[x+1].style.display='none';
      tabObj.rows[x+1].style.visibility='hidden';
    }
  }

  if(previous_level1<=level)
  {
    var p=parseInt(0);
    for(p=parseInt(previous_level1);p<=level;p++)
    {
      tabObj.rows[p+1].style.display='';
      tabObj.rows[p+1].style.visibility='visible';
     }
  }
  
  if(parseInt(previous_level1)>parseInt(level))
  {
    var s=parseInt(0);
    for(s=parseInt(level+1);s<=parseInt(previous_level1);s++)
    {
      tabObj.rows[s+1].style.display='none';
      tabObj.rows[s+1].style.visibility='hidden';
    }
  }

  if(parseInt(previous_level1)>parseInt(level))
  { 
    var a=parseInt(0);
    for(a=parseInt(level)+1;a<=parseInt(previous_level1);a++)
    {
      eval("formObj.Description"+a).value="";
      eval("formObj.CodeLength"+a).value="";
    }
  }
  previous_level1=parseInt(level);
}
//**************************************************************************
function CheckZero_CutOff(obj)
{
	
var CutOff_Value=obj.value;
if(CutOff_Value=="0" || CutOff_Value=="00" || CutOff_Value=="000")
{
  alert(getMessage("CUTOFF_PERIOD_CANNOT_ZERO",'MR'));
  obj.focus();
  obj.select();
  return false;
}
else 
return true;
}
//*******************************************************
function CheckZero_Codelength(obj)
{
	var Codelength_value=obj.value;
	var msg="";
	if(Codelength_value<=30)
	{
		if(Codelength_value=="0" || Codelength_value=="00")
		{
			msg=getMessage("CODE_LENGTH_CANNOT_ZERO",'MR');
			alert(msg);
			obj.focus();
			obj.select();
			return false;
		}
		else
		{
			return true;
		}
	}
	else if(Codelength_value>30)
	{
	  msg=getMessage("CODELENGTH_MAX_30",'MR');
	  alert(msg);
	  obj.focus();
	  obj.select();
	  return false;
	}
}
//**************************************************

//Added by Kamatchi S for ML-MMOH-CRF-1581
function ecounterStage(obj)
	{		
		var formObj=document.TermSetAddModify_Form;
		if(obj.checked)
		{
		   document.getElementById('ipchk').style.display = "";
          document.getElementById('dchk').style.display = "";
			document.getElementById('iplbl').style.display = "";
		document.getElementById('dclbl').style.display = "";
		document.getElementById('ipchk').checked = true;
		document.getElementById('dchk').checked = true;
			obj.value="Y";
		}
		else
		{
			document.getElementById('ipchk').style.display = "none";
			document.getElementById('dchk').style.display = "none";
			document.getElementById('iplbl').style.display = "none";
			document.getElementById('dclbl').style.display = "none";
			document.getElementById('ipchk').checked = false;
		document.getElementById('dchk').checked = false;


obj.value = "N";


			document.getElementById('inpatient_appl_yn').value = "N";
			document.getElementById('daycare_appl_yn').value = "N";
		}
	}

 //Below Added by Suji Keerthi for ML-MMOH-CRF-1395 on Dec-24,2020
function diagclassmand()
{
  var formObj=document.TermSetAddModify_Form;
  var diagmand=document.TermSetAddModify_Form.diag_class_mand_yn.value;
  if(formObj.diagclass_mand) //Added by Suji Keerthi for ML-MMOH-CRF-1395 US003
  {
  if(diagmand=='Y' && formObj.eff_status.value=='E') 
	{
     formObj.diagclass_mand.disabled=false;
	}
	else if(diagmand=='N')
	{
	  formObj.diagclass_mand.disabled=true;
      formObj.diagclass_mand.checked=false;
	  diagmand.value="";
	}
	}
  }
  //Ended by Suji Keerthi for ML-MMOH-CRF-1395 on Dec-24,2020


