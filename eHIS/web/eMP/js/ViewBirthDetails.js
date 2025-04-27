function show() {
//	parent.parent.window.document.title = "Setup Contact Modes" ;
}

function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/addContact.jsp" ;
}

function edit() {
//	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	pat_line.document.location.href='../../eCommon/html/blank.html';
	f_query_add_mod.location.href ="../../eMP/jsp/ViewBirthRegisterBlank.jsp?step_1=3";
}

/*
function apply() {
 
	var fields = new Array ( f_query_add_mod.document.contact_form.contact_code,
				 f_query_add_mod.document.contact_form.long_desc,
				 f_query_add_mod.document.contact_form.short_desc
			       );	
				       
        var names = new Array ( "Contact Mode", "Long Description","Short Description" );	
		
        var transform = new Array ( f_query_add_mod.document.contact_form,
				    f_query_add_mod.document.contact_form.eff_date_from,
				    f_query_add_mod.document.contact_form.eff_date_from1,
				    f_query_add_mod.document.contact_form.eff_date_to,
				    f_query_add_mod.document.contact_form.eff_date_to1
				  );		
							   
	if(f_query_add_mod.checkFields( fields, names, messageFrame)) {
		if(f_query_add_mod.DateTransform(transform,messageFrame)) {	
		   var fn_status = f_query_add_mod.document.contact_form.function_name.value ;
/*		   if(fn_status == "insert") {
			     f_query_add_mod.document.contact_form.reset();
		   }
		}	
	} 
}
	*/

function reset() 
{

     //f_query_add_mod.document.forms[0].reset();
            
}
//added for for PMG2014-HSA-CRF-0001 [IN:050020]
function enableOtherAltId(val)
{
	document.forms[0].other_alt_Id_no.value = "";
	if(val != '')
	{
		document.forms[0].other_alt_Id_no.disabled = false;
	}
	else
	{
		document.forms[0].other_alt_Id_no.value = "";
		document.forms[0].other_alt_Id_no.disabled = true;
	}
}
	

function onSuccess()
{
	f_query_add_mod.contact_form.contact_code.value	= "" ;
	f_query_add_mod.contact_form.long_desc.value		        = "" ;
	f_query_add_mod.contact_form.short_desc.value	                = "" ;
	f_query_add_mod.contact_form.eff_date_from1.value	        = "" ;
	f_query_add_mod.contact_form.eff_date_to1.value	                = "" ;
}
async function BirthRegisterSearch(){
	var func_idpassed = document.forms[0].func_idpassed.value;
	var function_id=document.forms[0].function_id.value;
	var url		= "../../eMP/jsp/ViewBirthRegisterMain.jsp?func_idpassed="+func_idpassed+'&function_id='+function_id;  ;
	var dialogTop	= "10px";
	var dialogHeight= "650px" ; 
	var dialogWidth	= "900px" ;	
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
	var returnval =await  window.showModalDialog( url, arguments, features ) ;	
	return returnval;
}
async function aa(){
	var pat_id ="";
	var function_id=document.forms[0].function_id.value;
	pat_id = await BirthRegisterSearch();
	if( pat_id && pat_id != "" && pat_id != null){
		parent.pat_line.document.location.href='../../eCommon/jsp/pline.jsp?Patient_Id='+escape(pat_id);	
		parent.f_query_add_mod.document.location.href='../jsp/ViewBirthRegMain.jsp?Patient_ID='+escape(pat_id)+'&function_id='+function_id;  
	}
}
function handle_view(){
	var control_count=document.getElementById("elements").count;
}

var pat="";
   function ViewGifBlink(str,frm) 
   {	
	var arr=new Array();
	var temp;
	var temp1;
	var temp2;

	var val="";
	arr=str.split("#");
	temp = "document.getElementById('patdetails').firstElementChild.nodeValue =arr[0];";	
	eval(temp);		
	temp1 = document.getElementById("patdetails1").value =arr[0]	
	//alert(temp1)
	//eval(temp1);		
	temp2 = "document.getElementById('patdetails2').firstElementChild.nodeValue =arr[0];";	
	eval(temp2);		
	
   }

function callDummy(){}
function openReg(obj)
{
	//parent.window.returnValue =obj;
	//retval=parent.window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = obj;
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();   
	return obj;
}

//From ViewBirthRegisterCriteria.jsp

function EnableFamSearch(obj)
	{
		if(document.forms[0].searchby !=null)
		{
			document.forms[0].searchby.value = "";
			if (obj.value=='')
			{
				document.forms[0].searchby.disabled = false;
				document.forms[0].searchby.value = "S";
			}
			else
				document.forms[0].searchby.disabled = true;
		}
	}
	function DefaultSelect(sndx) 
	{
		if(sndx=="") document.forms[0].soundex_val.value="";
		if(sndx=="E") document.forms[0].soundex_val.value="E";
		if(sndx=="G") document.forms[0].soundex_val.value="G";
	}
	function checkReadOnly()
	{
		if(document.birth_register_Form.Alt_Id1_No.value =="")
		{   
			document.birth_register_Form.Alt_Id1_Order.value = ""; 
			document.birth_register_Form.Alt_Id1_Order.disabled = true;  
		}
		else
		{
		   document.birth_register_Form.Alt_Id1_Order.disabled = false;
		   document.birth_register_Form.Alt_Id1_Order.focus();
		}
	}

	function makeToDateEnable(obj)
	{
		if(document.birth_register_Form.Dob.value =="")
		{
			document.birth_register_Form.DobTo.value = ""; 
			//document.birth_register_Form.DobTo.disabled = true;
		}
		else
		{
		//	if(CheckDate(obj))
			if(validDateObj(obj,'DMY',localeName))
			{
				document.birth_register_Form.DobTo.disabled = false;
				document.getElementById("dobtoimg").disabled = false;
				document.birth_register_Form.DobTo.focus();
			}
		}
	}

	function ChangeCase(obj)
	{
		var pat_id = obj.value;
		pat_id = pat_id.toUpperCase();
		birth_register_Form.Patient_Id.value = pat_id;
	}

	

	function DobToCheck() 
	{
		var fromarray; var toarray;
		var fromdate = document.birth_register_Form.Dob.value ;
		var todate = document.birth_register_Form.DobTo.value ;

		if(fromdate.length > 0 && todate.length > 0 ) 
			{
				/*fromarray = fromdate.split("/");
				toarray = todate.split("/");
				var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
				var todt = new Date(toarray[2],toarray[1],toarray[0]);*/
				
				//if(Date.parse(todt) < Date.parse(fromdt)) 
				 if(!isBefore(fromdate,todate,'DMY',localeName))
				{

					var msg= getMessage("CANNOT_GREATER","MP");
					msg = msg.replace("#",getLabel('Common.fromdate.label','common'));
				//	msg = msg.replace("#",fromdt);
					msg = msg.replace("$",getLabel('Common.todate.label','common'));
					//msg = msg.replace("$",todt);
					alert(msg);

					document.birth_register_Form.DobTo.select();
					return false;
				}
				else return true;
				//else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
		}	
		return true;
	}

	function changeOtherInput(Obj)
	{
		var objName=Obj.name;

		if(objName == "Patient_Id")
		{
			if(birth_register_Form.Patient_Id.value != "")
			{
				document.birth_register_Form.Mother_Patient_Id.readOnly = true;
				document.birth_register_Form.Alt_Id1_No.readOnly = true;
				document.birth_register_Form.search.disabled =true;
			}
			else
			{
				document.birth_register_Form.Mother_Patient_Id.readOnly = false;
				document.birth_register_Form.Alt_Id1_No.readOnly = false;
				document.birth_register_Form.search.disabled =false;
			}
		}

		if(objName =="Mother_Patient_Id")
		{
			if(birth_register_Form.Mother_Patient_Id.value != "")
			{
					document.birth_register_Form.Patient_Id.readOnly = true;
					document.birth_register_Form.Alt_Id1_No.readOnly = true;
			}
			else
			{
				if(birth_register_Form.Patient_Id.value == "")
				{
					document.birth_register_Form.Patient_Id.readOnly = false;
					document.birth_register_Form.Alt_Id1_No.readOnly = false;
				}
			}
		}

		if(objName =="Alt_Id1_No")
		{
			if(birth_register_Form.Alt_Id1_No.value != "")
			{
				document.birth_register_Form.Patient_Id.readOnly = true;
				document.birth_register_Form.Mother_Patient_Id.readOnly = true;
				document.birth_register_Form.search.disabled =true;
			}
			else
			{
				document.birth_register_Form.Patient_Id.readOnly = false;
				document.birth_register_Form.Mother_Patient_Id.readOnly = false;
				document.birth_register_Form.search.disabled =false;	
			}
		}

	}

	function changeInputFocus(Obj)
	{
		var objName=Obj.name;

		if(objName == "Patient_Id")
		{
			if(document.birth_register_Form.Mother_Patient_Id.value != "")
			{
				document.birth_register_Form.Mother_Patient_Id.focus();
			}
			if(document.birth_register_Form.Alt_Id1_No){
			if(document.birth_register_Form.Alt_Id1_No.value != "")
			{
				document.birth_register_Form.Alt_Id1_No.focus();
			}
			}//added for for PMG2014-HSA-CRF-0001 [IN:050020]
			if(document.birth_register_Form.Alt_Id2_No){
			if(document.birth_register_Form.Alt_Id2_No.value != "")
			{
				document.birth_register_Form.Alt_Id2_No.focus();
			}
			}
			if(document.birth_register_Form.Alt_Id3_No){
			if(document.birth_register_Form.Alt_Id3_No.value != "")
			{
				document.birth_register_Form.Alt_Id3_No.focus();
			}}
			if(document.birth_register_Form.Alt_Id4_No){
			if(document.birth_register_Form.Alt_Id4_No.value != "")
			{
				document.birth_register_Form.Alt_Id4_No.focus();
			}}
			if(document.birth_register_Form.accept_national_id_no_yn.value=='Y'){ 
			if(document.birth_register_Form.nat_id_prompt.value != "")
			{
				document.birth_register_Form.nat_id_prompt.focus();
			}
			}
		}
		if(objName == "Mother_Patient_Id")
		{
			if(document.birth_register_Form.Patient_Id.value != "")
			{
				document.birth_register_Form.Patient_Id.focus();
			}
			if(document.birth_register_Form.Alt_Id1_No){
			if(document.birth_register_Form.Alt_Id1_No.value != "")
			{
				document.birth_register_Form.Alt_Id1_No.focus();
			}
			}//added for for PMG2014-HSA-CRF-0001 [IN:050020]
			if(document.birth_register_Form.Alt_Id2_No){
			if(document.birth_register_Form.Alt_Id2_No.value != "")
			{
				document.birth_register_Form.Alt_Id2_No.focus();
			}}
			if(document.birth_register_Form.Alt_Id3_No){
			if(document.birth_register_Form.Alt_Id3_No.value != "")
			{
				document.birth_register_Form.Alt_Id3_No.focus();
			}}
			if(document.birth_register_Form.Alt_Id4_No){
			if(document.birth_register_Form.Alt_Id4_No.value != "")
			{
				document.birth_register_Form.Alt_Id4_No.focus();
			}}
			if(document.birth_register_Form.accept_national_id_no_yn.value=='Y'){ 
			if(document.birth_register_Form.nat_id_prompt.value != "")
			{
				document.birth_register_Form.nat_id_prompt.focus();
			}
			}
		}
		if(objName == "Alt_Id1_No")
		{
			if(document.birth_register_Form.Patient_Id.value != "")
			{
				document.birth_register_Form.Patient_Id.focus();
			}
			if(document.birth_register_Form.Mother_Patient_Id.value != "")
			{
				document.birth_register_Form.Mother_Patient_Id.focus();
			}//added for for PMG2014-HSA-CRF-0001 [IN:050020]
		    if(document.birth_register_Form.Alt_Id2_No){
			if(document.birth_register_Form.Alt_Id2_No.value != "")
			{
				document.birth_register_Form.Alt_Id2_No.focus();
			}}
			if(document.birth_register_Form.Alt_Id3_No){
			if(document.birth_register_Form.Alt_Id3_No.value != "")
			{
				document.birth_register_Form.Alt_Id3_No.focus();
			}}
			if(document.birth_register_Form.Alt_Id4_No)
			{
			if(document.birth_register_Form.Alt_Id4_No.value != "")
			{
				document.birth_register_Form.Alt_Id4_No.focus();
			}}
			if(document.birth_register_Form.accept_national_id_no_yn.value=='Y'){ 
			if(document.birth_register_Form.nat_id_prompt.value != "")
			{
				document.birth_register_Form.nat_id_prompt.focus();
			}
			}
		}
		
		if(objName == "Alt_Id2_No")
		{
			if(document.birth_register_Form.Patient_Id.value != "")
			{
				document.birth_register_Form.Patient_Id.focus();
			}
			if(document.birth_register_Form.Mother_Patient_Id.value != "")
			{
				document.birth_register_Form.Mother_Patient_Id.focus();
			}
			if(document.birth_register_Form.Alt_Id1_No){
			if(document.birth_register_Form.Alt_Id1_No.value != "")
			{
				document.birth_register_Form.Alt_Id1_No.focus();
			}}
			if(document.birth_register_Form.Alt_Id3_No){
			if(document.birth_register_Form.Alt_Id3_No.value != "")
			{
				document.birth_register_Form.Alt_Id3_No.focus();
			} }
			if(document.birth_register_Form.Alt_Id4_No){
			if(document.birth_register_Form.Alt_Id4_No.value != "")
			{
				document.birth_register_Form.Alt_Id4_No.focus();
			}}
			if(document.birth_register_Form.accept_national_id_no_yn.value=='Y'){ 
			if(document.birth_register_Form.nat_id_prompt.value != "")
			{
				document.birth_register_Form.nat_id_prompt.focus();
			}
			}
		}
		if(objName == "Alt_Id3_No")
		{
			if(document.birth_register_Form.Patient_Id.value != "")
			{
				document.birth_register_Form.Patient_Id.focus();
			}
			if(document.birth_register_Form.Mother_Patient_Id.value != "")
			{
				document.birth_register_Form.Mother_Patient_Id.focus();
			}
			if(document.birth_register_Form.Alt_Id2_No){
			if(document.birth_register_Form.Alt_Id2_No.value != "")
			{
				document.birth_register_Form.Alt_Id2_No.focus();
			}}
			if(document.birth_register_Form.Alt_Id1_No){
			if(document.birth_register_Form.Alt_Id1_No.value != "")
			{
				document.birth_register_Form.Alt_Id1_No.focus();
			}}
			if(document.birth_register_Form.Alt_Id4_No){
			if(document.birth_register_Form.Alt_Id4_No.value != "")
			{
				document.birth_register_Form.Alt_Id4_No.focus();
			}}
			if(document.birth_register_Form.accept_national_id_no_yn.value=='Y'){ 
			if(document.birth_register_Form.nat_id_prompt.value != "")
			{
				document.birth_register_Form.nat_id_prompt.focus();
			}
			}
		}
		
		if(objName == "Alt_Id4_No")
		{
			if(document.birth_register_Form.Patient_Id.value != "")
			{
				document.birth_register_Form.Patient_Id.focus();
			}
			if(document.birth_register_Form.Mother_Patient_Id.value != "")
			{
				document.birth_register_Form.Mother_Patient_Id.focus();
			}
			if(document.birth_register_Form.Alt_Id2_No){
			if(document.birth_register_Form.Alt_Id2_No.value != "")
			{
				document.birth_register_Form.Alt_Id2_No.focus();
			}}
			if(document.birth_register_Form.Alt_Id3_No){
			if(document.birth_register_Form.Alt_Id3_No.value != "")
			{
				document.birth_register_Form.Alt_Id3_No.focus();
			}}
			if(document.birth_register_Form.Alt_Id1_No){
			if(document.birth_register_Form.Alt_Id1_No.value != "")
			{
				document.birth_register_Form.Alt_Id1_No.focus();
			}}
			if(document.birth_register_Form.accept_national_id_no_yn.value=='Y'){ 
			if(document.birth_register_Form.nat_id_prompt.value != "")
			{
				document.birth_register_Form.nat_id_prompt.focus();
			}
			}
		}

		if(objName == "nat_id_prompt")
		{
			if(document.birth_register_Form.Patient_Id.value != "")
			{
				document.birth_register_Form.Patient_Id.focus();
			}
			if(document.birth_register_Form.Mother_Patient_Id.value != "")
			{
				document.birth_register_Form.Mother_Patient_Id.focus();
			}
			if(document.birth_register_Form.Alt_Id1_No){
			if(document.birth_register_Form.Alt_Id1_No.value != "")
			{
				document.birth_register_Form.Alt_Id1_No.focus();
			}
			}
			if(document.birth_register_Form.Alt_Id2_No){
			if(document.birth_register_Form.Alt_Id2_No.value != "")
			{
				document.birth_register_Form.Alt_Id2_No.focus();
			}}
			if(document.birth_register_Form.Alt_Id3_No){
			if(document.birth_register_Form.Alt_Id3_No.value != "")
			{
				document.birth_register_Form.Alt_Id3_No.focus();
			}}
			if(document.birth_register_Form.Alt_Id4_No){
			if(document.birth_register_Form.Alt_Id4_No.value != "")
			{
				document.birth_register_Form.Alt_Id4_No.focus();
			}}
		}
	}

/*	function PatSearch()
	{
		var patientid;
		if(!(document.birth_register_Form.Patient_Id.value != "") && 
			!(document.birth_register_Form.Alt_Id1_No.value != ""))
		{
			patientid=PatientSearchWithDefaultGender('F','N');
			document.birth_register_Form.Mother_Patient_Id.value = patientid;
			if( document.birth_register_Form.Mother_Patient_Id.value == 'undefined')
				document.birth_register_Form.Mother_Patient_Id.value = '';
			document.birth_register_Form.Mother_Patient_Id.focus();
		}
	}			
	*/ //Commented on 21/04/2004
	function PatSearch() //Added to disable validation for View Birth Register
	{
		var patientid;
	//	alert("patsearch"+patientid);
		var func_idpassed = document.forms[0].func_idpassed.value;
		alert("func_idpassed  :"+func_idpassed);
		alert(document.birth_register_Form.Alt_Id1_No);
		alert(document.birth_register_Form.Alt_Id2_No);
		alert(document.birth_register_Form.Alt_Id3_No);
		alert(document.birth_register_Form.Alt_Id4_No);
		alert(document.birth_register_Form.nat_id_prompt);
		if(document.birth_register_Form.Alt_Id1_No!=undefined && document.birth_register_Form.Alt_Id2_No!=undefined && document.birth_register_Form.Alt_Id3_No!=undefined && document.birth_register_Form.Alt_Id4_No!=undefined && document.birth_register_Form.nat_id_prompt!=undefined )		
		{
		
		if(!(document.birth_register_Form.Patient_Id.value != "") && !(document.birth_register_Form.Alt_Id1_No.value != "") && !(document.birth_register_Form.Alt_Id2_No.value != "") && !(document.birth_register_Form.Alt_Id3_No.value != "")  && !(document.birth_register_Form.Alt_Id4_No.value != "") && !(document.birth_register_Form.nat_id_prompt.value != ""))
			
		{
			patientid=PatientSearchWithDefaultGender_mbr(func_idpassed,'F','N');
			alert("patsearch1"+patientid);
			//patientid=PatientSearchWithDefaultGender('F','N');
			document.birth_register_Form.Mother_Patient_Id.value = patientid;
			if( document.birth_register_Form.Mother_Patient_Id.value == 'undefined')
				document.birth_register_Form.Mother_Patient_Id.value = '';
			document.birth_register_Form.Mother_Patient_Id.focus();
		}
		}
	}			


/*
    Funtion     : function PatientSearchWithDefaultGender_mbr(defaultgender, enablegenderyn)
    Developed by    : Chitra
	Modified By : Sen 
    Purpose     : To default the Sex value in Search criteria to the one passed as paramater.
    New Parameter : func_idpassed
    defaultgender = 'M' for male and 'F' for female
    enablegenderyn = 'N' if select item is to be disabled

*/

async function PatientSearchWithDefaultGender_mbr(func_idpassed,defaultgender, enablegenderyn) {
        window_styl='O';
        close_yn='Y';
        jsp_name='';
        win_top= '61';
        win_height= '34';
        win_width= '50';
        act_yn= 'N';
        register_button_yn = 'N';
      //  func_idpassed='MP_VIEW_BIRTH_REG';
		func_act = "";
        srr='Y';

        window_styl = window_styl.toUpperCase();
        close_yn = close_yn.toUpperCase();
        act_yn = act_yn.toUpperCase();

        var url     = "../../eMP/jsp/ModelPatientSearch.jsp?jsp_name="+jsp_name+"&window_styl="+window_styl+"&close_yn="+close_yn+"&win_top="+win_top+"&win_height="+win_height+"&win_width="+win_width+"&act_yn="+act_yn+"&srr="+srr+"&register_button_yn="+register_button_yn+"&func_act="+func_act+"&default_gender="+defaultgender+"&enable_gender_yn="+enablegenderyn+"&func_idpassed="+func_idpassed;
        var dialogTop   = "65";
        var dialogHeight    = "42" ;
        var dialogWidth = "65" ;
        var arguments   = "" ;
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
        var returnval = await window.showModalDialog( url, arguments, features ) ;
        return returnval;
}



	/*function formatFlds(obj)
	{
		if( obj.checked )
		{
			if(document.forms[0].first_name)
			{
				document.forms[0].first_name.value='';
				document.forms[0].first_name.style.textAlign = "right";
				document.forms[0].first_name.className = 'othlangtext'
				document.forms[0].first_name.onfocus = new Function('loadArabic()');
				document.forms[0].first_name.onblur = new Function('loadEnglish()');
			}
			if(document.forms[0].second_name)
			{
				document.forms[0].second_name.value='';
				document.forms[0].second_name.style.textAlign = "right";
				document.forms[0].second_name.className = 'othlangtext'
				document.forms[0].second_name.onfocus = new Function('loadArabic()');
				document.forms[0].second_name.onblur = new Function('loadEnglish()');
			}
			if(document.forms[0].third_name)
			{
				document.forms[0].third_name.value='';
				document.forms[0].third_name.style.textAlign = "right";
				document.forms[0].third_name.className = 'othlangtext'
				document.forms[0].third_name.onfocus = new Function('loadArabic()');
				document.forms[0].third_name.onblur = new Function('loadEnglish()');
			}
			if(document.forms[0].fourth_name)
			{
				document.forms[0].fourth_name.value='';
				document.forms[0].fourth_name.style.textAlign = "right";
				document.forms[0].fourth_name.className = 'othlangtext'
				document.forms[0].fourth_name.onfocus = new Function('loadArabic()');
				document.forms[0].fourth_name.onblur = new Function('loadEnglish()');
			}
			if(document.forms[0].fifth_name)
			{
				document.forms[0].fifth_name.value='';
				document.forms[0].fifth_name.style.textAlign = "right";
				document.forms[0].fifth_name.className = 'othlangtext'
				document.forms[0].fifth_name.onfocus = new Function('loadArabic()');
				document.forms[0].fifth_name.onblur = new Function('loadEnglish()');
			}
			if(document.forms[0].family_name)
			{
				document.forms[0].family_name.value='';
				document.forms[0].family_name.style.textAlign = "right";
				document.forms[0].family_name.className = 'othlangtext'
				document.forms[0].family_name.onfocus = new Function('loadArabic()');
				document.forms[0].family_name.onblur = new Function('loadEnglish()');
			}
		}
		else
		{
			if(document.forms[0].first_name)
			{
				document.forms[0].first_name.value='';
				document.forms[0].first_name.style.textAlign = "left";
				document.forms[0].first_name.className = ''
				document.forms[0].first_name.onfocus = new Function('callEmpty()');
				document.forms[0].first_name.onblur = new Function('callEmpty()');
			}
			if(document.forms[0].second_name)
			{
				document.forms[0].second_name.value='';
				document.forms[0].second_name.style.textAlign = "left";
				document.forms[0].second_name.className = ''
				document.forms[0].second_name.onfocus = new Function('callEmpty()');
				document.forms[0].second_name.onblur = new Function('callEmpty()');
			}
			if(document.forms[0].third_name)
			{
				document.forms[0].third_name.value='';
				document.forms[0].third_name.style.textAlign = "left";
				document.forms[0].third_name.className = ''
				document.forms[0].third_name.onfocus = new Function('callEmpty()');
				document.forms[0].third_name.onblur = new Function('callEmpty()');
			}
			if(document.forms[0].fourth_name)
			{
				document.forms[0].fourth_name.value='';
				document.forms[0].fourth_name.style.textAlign = "left";
				document.forms[0].fourth_name.className = ''
				document.forms[0].fourth_name.onfocus = new Function('callEmpty()');
				document.forms[0].fourth_name.onblur = new Function('callEmpty()');
			}
			if(document.forms[0].fifth_name)
			{
				document.forms[0].fifth_name.value='';
				document.forms[0].fifth_name.style.textAlign = "left";
				document.forms[0].fifth_name.className = ''
				document.forms[0].fifth_name.onfocus = new Function('callEmpty()');
				document.forms[0].fifth_name.onblur = new Function('callEmpty()');
			}
			if(document.forms[0].family_name)
			{
				document.forms[0].family_name.value='';
				document.forms[0].family_name.style.textAlign = "left";
				document.forms[0].family_name.className = ''
				document.forms[0].family_name.onfocus = new Function('callEmpty()');
				document.forms[0].family_name.onblur = new Function('callEmpty()');
			}
		}
	}*/
	function callEmpty() {}
//End ViewBirthRegisterCriteria.jsp
