function home()
{
	
	 window.returnValue='';
	 window.close();
	
}

function create()
{
	
	f_query_add_mod.location.href = "../../eOA/jsp/ApptWaitListlMainPage.jsp?operation=insert" ;
}

var LocalErrors ="";
var local_error="";
var local_error1="";

function apply()
{
		var submitflag=true;
		var submitflag2=true;
		var submitflag3=true;
		LocalErrors ="";
		local_error="";
		local_error1="";
		var prompt_error="";
		var sstyle=f_query_add_mod.document.getElementById('Bkappt_form').style.value;
		var spl_code =f_query_add_mod.document.Bkappt_form.speciality.value;
		var patient_id=f_query_add_mod.document.Bkappt_form.patient_id.value;
		var categ_code=f_query_add_mod.document.Bkappt_form.walst_category_code.value;
		local_error =getMessage("CAN_NOT_BE_BLANK","Common");
		if(f_query_add_mod.document.Bkappt_form.speciality.value=='')
		{
		
			LocalErrors +=local_error.replace("$",getLabel("Common.speciality.label","Common"))+ '<br>';
			submitflag=false;
			
		}
		if(f_query_add_mod.document.getElementById("ordCatImg") && f_query_add_mod.document.getElementById("ordCatImg").style.visibility=='visible' && f_query_add_mod.document.forms[0].or_catalogue_desc.value=="")
		{
			LocalErrors +=local_error.replace("$",getLabel("Common.ordercatalog.label","Common"))+ '<br>';
			submitflag=false;
		}
		if(f_query_add_mod.document.getElementById("locnManImg") && f_query_add_mod.document.getElementById("locnManImg").style.visibility=='visible' && f_query_add_mod.document.forms[0].b_loc_val.value=="")
		{
			LocalErrors +=local_error.replace("$",getLabel("Common.Location.label","Common"))+ '<br>';
			submitflag=false;
		}
	
		if(f_query_add_mod.document.Bkappt_form.waitlist_category_reqd_yn.value=='Y')
		{
			if (f_query_add_mod.document.Bkappt_form.walst_category.value =='')
			{
			LocalErrors +=local_error.replace("$",getLabel("eOA.WaitlistCategory.label","OA"))+ '<br>';
			submitflag=false;
			submitflag2=false;
			}

		}

		if(f_query_add_mod.document.Bkappt_form.priority.value=='')
		{
			LocalErrors +=local_error.replace("$",getLabel("Common.priority.label","Common"))+ '<br>';
			submitflag=false;
			submitflag2=false;
		}
		if(f_query_add_mod.document.Bkappt_form.locationType.value=='')
		{
			LocalErrors +=local_error.replace("$",getLabel("Common.locationtype.label","Common"))+ '<br>';
			submitflag=false;
			submitflag2=false;
		}

		if(f_query_add_mod.document.Bkappt_form.reason_create.value=='')
		{
			LocalErrors +=local_error.replace("$",getLabel("eOA.ReasonForCreateWaitlist.label","OA"))+ '<br>';
			submitflag=false;
			submitflag2=false;
		}
		
		/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
		if(f_query_add_mod.document.Bkappt_form.remarks_img.style.visibility == 'visible' && f_query_add_mod.document.Bkappt_form.other_remarks.value=='')
		{
			LocalErrors +=local_error.replace("$",getLabel("Common.remarks.label","Common"))+ '<br>';
			submitflag=false;
			submitflag2=false;
		}
		/*End ML-MMOH-CRF-1114*/
		
		if(f_query_add_mod.document.Bkappt_form.patient_name1)
		{
			if(f_query_add_mod.document.Bkappt_form.patient_name1.value=='')
			{
			LocalErrors +=local_error.replace("$",getLabel("Common.PatientName.label","Common"))+ ' <br>';
			submitflag=false;
			
			}
		}

		if(f_query_add_mod.document.Bkappt_form.sex)
		{
			if(f_query_add_mod.document.Bkappt_form.sex.value=='')
			{
			LocalErrors +=local_error.replace("$",getLabel("Common.gender.label","Common"))+ ' <br>';
			submitflag=false;
			}
		}

		if(f_query_add_mod.document.Bkappt_form.date_of_birth)
		{
			if(f_query_add_mod.document.Bkappt_form.date_of_birth.value=='')
			{
			LocalErrors +=local_error.replace("$",getLabel("Common.birthDate.label","Common"))+ ' <br>';
			submitflag=false;
			}
		}

		if(f_query_add_mod.document.getElementById("race_required_yn").value == 'Y')
		{
				
				if(f_query_add_mod.document.getElementById("race_code").value=="")
				{
					LocalErrors +=local_error.replace("$",getLabel("Common.race.label","Common"))+ ' <br>';
					submitflag=false;
				}
				
			}
			
  /*Below line added for this CRF GHL-CRF-0332 [IN:042060]*/ 
			var canSave = new Boolean(true);			
			if(f_query_add_mod.document.getElementById("alt_id1_reqd_yn").value == 'Y' && f_query_add_mod.document.getElementById("alt_id1_man_non_ctz") && f_query_add_mod.document.getElementById("alt_id1_man_non_ctz").value=="true")
			{
				if(f_query_add_mod.document.getElementById("alt1_gif").style.visibility == 'visible') {	

					if(f_query_add_mod.document.getElementById("alt_id1_no").value=="")
					{
						 canSave = checkForNull1(f_query_add_mod.document.getElementById("alt_id1_no"),f_query_add_mod.document.getElementById("alt_id1_desc").value);
					}		 
				}
				if ( canSave == false ){
					submitflag=false;
					
				}
				
			}
			
			if(f_query_add_mod.document.getElementById("alt_date1_reqd_yn").value == 'Y' && f_query_add_mod.document.getElementById("alt_id1_man_non_ctz") && f_query_add_mod.document.getElementById("alt_id1_man_non_ctz").value=="true")
			{
				if(f_query_add_mod.document.getElementById("alt1_exp_date1").style.visibility == 'visible') {
					if(f_query_add_mod.document.getElementById("altidexpdate1").value=="")
					{						
						LocalErrors +=local_error.replace("$",getLabel("Common.expiryDate.label","Common"))+ ' <br>';
						submitflag=false;
					}		 
				}
				
			}
			
          //End this CRF GHL-CRF-0332 [IN:042060]			
			
			
			

if(f_query_add_mod.document.getElementById("name_prefix_reqd_yn"))
		{
		if(f_query_add_mod.document.getElementById("name_prefix_reqd_yn").value=='Y')
		{
			
			if(f_query_add_mod.document.Bkappt_form.name_prefix.value=='')
			{
			prompt_error=f_query_add_mod.document.Bkappt_form.Name_Prefix_Prompt.value;
			LocalErrors +=local_error.replace("$",prompt_error)+ ' <br>';
			submitflag=false;
			}
			
		}
		}

		/****Added to chk Gender mismatch******/

		if ( f_query_add_mod.document.Bkappt_form.name_prefix != null && f_query_add_mod.document.Bkappt_form.sex !=null)
		{
			if ( f_query_add_mod.document.Bkappt_form.name_prefix.value.length != 0 )
			{
				canSave = checkPatSex();
				if ( canSave == false ){
				submitflag = false;
				}
			}
		}

		if ( f_query_add_mod.document.Bkappt_form.name_suffix != null && f_query_add_mod.document.Bkappt_form.sex !=null)
		{
			if ( f_query_add_mod.document.Bkappt_form.name_suffix.value.length != 0 )
			{
				canSave = checkPatSuffixSex();
				if ( canSave == false ){
				submitflag = false;
				}
			}
		}


		/****end of method*****/




		if(f_query_add_mod.document.getElementById("first_name_reqd_yn"))
		{
		if(f_query_add_mod.document.getElementById("first_name_reqd_yn").value=='Y')
		{
			if(f_query_add_mod.document.Bkappt_form.first_name.value=='')
			{
				//prompt_error=f_query_add_mod.document.Bkappt_form.First_Name_Prompt.value;
				//LocalErrors +=local_error.replace("$",prompt_error)+ ' <br>';
				f_query_add_mod.document.Bkappt_form.first_name.value=f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				f_query_add_mod.document.Bkappt_form.patient_name.value +=f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				f_query_add_mod.document.Bkappt_form.all.patient_name1.innerHTML +=f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				//submitflag=false;
			}
		}
		}
		if(f_query_add_mod.document.getElementById("second_name_reqd_yn"))
		{
		if(f_query_add_mod.document.getElementById("second_name_reqd_yn").value=='Y')
		{
			if(f_query_add_mod.document.Bkappt_form.second_name.value=='')
			{
				//prompt_error=f_query_add_mod.document.Bkappt_form.Second_Name_Prompt.value;
				//LocalErrors +=local_error.replace("$",prompt_error)+ ' <br>';
				//submitflag=false;
				f_query_add_mod.document.Bkappt_form.second_name.value=f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				f_query_add_mod.document.Bkappt_form.patient_name.value +=f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				f_query_add_mod.document.Bkappt_form.patient_name1.innerHTML +=f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
			}
		}
		}

			if(f_query_add_mod.document.getElementById("third_name_reqd_yn") )
		{
		if(f_query_add_mod.document.getElementById("third_name_reqd_yn") .value=='Y')
		{
			if(f_query_add_mod.document.Bkappt_form.third_name.value=='')
			{
				//prompt_error=f_query_add_mod.document.Bkappt_form.Third_Name_Prompt.value;
				//LocalErrors +=local_error.replace("$",prompt_error)+ ' <br>';
				//submitflag=false;
				f_query_add_mod.document.Bkappt_form.third_name.value=f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				f_query_add_mod.document.Bkappt_form.patient_name.value +=f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				f_query_add_mod.document.Bkappt_form.patient_name1.innerHTML +=f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
			}
		}
		}
		if(f_query_add_mod.document.getElementById("family_name_reqd_yn"))
		{
		if(f_query_add_mod.document.getElementById("family_name_reqd_yn").value=='Y')
		{
			if(f_query_add_mod.document.Bkappt_form.family_name.value=='')
			{
				//prompt_error=f_query_add_mod.document.Bkappt_form.Family_Name_Prompt.value;
				//LocalErrors +=local_error.replace("$",prompt_error)+ ' <br>';
				//submitflag=false;
				f_query_add_mod.document.Bkappt_form.family_name.value=f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				f_query_add_mod.document.Bkappt_form.patient_name.value +=f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
				f_query_add_mod.document.Bkappt_form.patient_name1.innerHTML +=f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
			}
		}
		}

if(f_query_add_mod.document.getElementById("name_suffix_reqd_yn") )
		{
		if(f_query_add_mod.document.getElementById("name_suffix_reqd_yn") .value=='Y')
		{
			if(f_query_add_mod.document.Bkappt_form.name_suffix.value=='')
			{
				prompt_error=f_query_add_mod.document.Bkappt_form.Name_Suffix_Prompt.value;
				LocalErrors +=local_error.replace("$",prompt_error)+ ' <br>';
				submitflag=false;
			}
		}
		}

		/***************oth lang changes*********************/

if(f_query_add_mod.document.Bkappt_form.name_prefix_oth)
{
	if(f_query_add_mod.document.Bkappt_form.name_prefix_oth.style.visibility == 'visible' )
	{
		if(f_query_add_mod.document.Bkappt_form.name_prefix_oth_lang != null && f_query_add_mod.document.Bkappt_form.name_prefix_oth_lang.disabled ==false)
		{
			prompt_error=f_query_add_mod.document.Bkappt_form.name_prefix_oth_prompt;
			LocalErrors +=local_error.replace("$",prompt_error)+ ' <br>';
			submitflag=false;
		}
		
	}
}


if(f_query_add_mod.document.Bkappt_form.first_oth_name_reqd_yn)
{
if(f_query_add_mod.document.Bkappt_form.first_oth_name_reqd_yn.style.visibility == 'visible' )
{
	if(f_query_add_mod.document.Bkappt_form.first_name_oth_lang != null && f_query_add_mod.document.Bkappt_form.first_name_oth_lang.disabled ==false)
	{
		prompt_error=f_query_add_mod.document.Bkappt_form.first_name_oth_prompt;
		LocalErrors +=local_error.replace("$",prompt_error)+ ' <br>';

		

		f_query_add_mod.document.Bkappt_form.patient_name_local_lang.value +=f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;

		f_query_add_mod.document.Bkappt_form.patient_name_local_lang1.innerHTML +=f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;

		submitflag=false;
	}
	
}
}

if(f_query_add_mod.document.Bkappt_form.second_oth_name_reqd_yn)
{
if(f_query_add_mod.document.Bkappt_form.second_oth_name_reqd_yn.style.visibility == 'visible' )
{
	if(f_query_add_mod.document.Bkappt_form.second_name_oth_lang != null && f_query_add_mod.document.Bkappt_form.second_name_oth_lang.disabled ==false)
	{
		prompt_error=f_query_add_mod.document.Bkappt_form.second_name_oth_prompt;
		LocalErrors +=local_error.replace("$",prompt_error)+ ' <br>';

		

		f_query_add_mod.document.Bkappt_form.patient_name_local_lang.value +=f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;

		f_query_add_mod.document.Bkappt_form.patient_name_local_lang1.innerHTML +=f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;

		submitflag=false;
	}
	
}
}
if(f_query_add_mod.document.Bkappt_form.third_oth_name_reqd_yn)
{
if(f_query_add_mod.document.Bkappt_form.third_oth_name_reqd_yn.style.visibility == 'visible' )
{
	if(f_query_add_mod.document.Bkappt_form.third_name_oth_lang != null && f_query_add_mod.document.Bkappt_form.third_name_oth_lang.disabled ==false)
	{
		prompt_error=f_query_add_mod.document.Bkappt_form.third_name_oth_prompt;
		LocalErrors +=local_error.replace("$",prompt_error)+ ' <br>';

		
		f_query_add_mod.document.Bkappt_form.patient_name_local_lang.value +=f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;

		f_query_add_mod.document.Bkappt_form.patient_name_local_lang1.innerHTML +=f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;

		submitflag=false;
	}
	
}
}

if(f_query_add_mod.document.Bkappt_form.family_oth_name_reqd_yn )
{
if(f_query_add_mod.document.Bkappt_form.family_oth_name_reqd_yn.style.visibility == 'visible' )
{
	if(f_query_add_mod.document.Bkappt_form.family_name_oth_lang != null && f_query_add_mod.document.Bkappt_form.family_name_oth_lang.disabled ==false)
	{
		prompt_error=f_query_add_mod.document.Bkappt_form.family_name_oth_prompt;
		LocalErrors +=local_error.replace("$",prompt_error)+ ' <br>';

		
		f_query_add_mod.document.Bkappt_form.patient_name_local_lang.value +=f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;

		f_query_add_mod.document.Bkappt_form.patient_name_local_lang1.innerHTML +=f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;

		submitflag=false;
	}
	else{
		f_query_add_mod.document.Bkappt_form.patient_name_local_lang.value +=f_query_add_mod.document.Bkappt_form.dflt_patient_name.value;
	}

}
}


if(f_query_add_mod.document.Bkappt_form.name_suffix_oth )
{
if(f_query_add_mod.document.Bkappt_form.name_suffix_oth.style.visibility == 'visible' )
{
	if(f_query_add_mod.document.Bkappt_form.name_suffix_oth_lang != null && f_query_add_mod.document.Bkappt_form.name_suffix_oth_lang.disabled ==false)
	{
		prompt_error=f_query_add_mod.document.Bkappt_form.name_suffix_oth_prompt;
		LocalErrors +=local_error.replace("$",prompt_error)+ ' <br>';
		submitflag=false;
	}
}
}
/**************end************/

			if(f_query_add_mod.document.Bkappt_form.nationality_code1)
			{
				if(f_query_add_mod.document.Bkappt_form.nationality_desc.value==''){
				f_query_add_mod.document.Bkappt_form.nationality_code1.value='';
				}	
        		
				//below line modified for this CRF GHL-CRF-0332 [IN:042060]					
				if(f_query_add_mod.document.Bkappt_form.nat_gif_yn.value=="Y"){ 
					if(f_query_add_mod.document.Bkappt_form.nationality_code1.value=="") 	{ 
						LocalErrors +=local_error.replace("$",getLabel("Common.nationality.label","Common"))+ '<br>';
						submitflag=false;
			    	}
				}
		 	 }	
			
		
			if (submitflag2==true && submitflag==true)
			{
			if(f_query_add_mod.document.Bkappt_form.restrict_wl_cat_agst_splty_yn.value=="Y")
			{

				if (f_query_add_mod.document.Bkappt_form.waitlist_category_reqd_yn.value=="Y" || patient_id !=null || patient_id !="")
				{
				var xmlDoc = ""
				var xmlHttp = new XMLHttpRequest()
				xmlStr	="<root><SEARCH spl_code=\""+spl_code+"\" patient_id=\""+patient_id+"\" categ_code=\""+categ_code+"\" steps='RESTRICT_WAIT_LIST'/></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
				xmlHttp.open("POST","ServerSide.jsp",false)
				xmlHttp.send(xmlDoc)
				responseText=xmlHttp.responseText
				eval(responseText);
				if(resrt_wtlst_Flag1==1)
				{
					
					var error=getMessage("OPEN_WAITLIST","OA");
					alert(error);
					submitflag=false;
				}else
				{
					submitflag=true;
				}

				}else
				{
					submitflag=true;
				}

			}else
			{
				submitflag=true;
			}
}
			
if(submitflag ==true)
	{
        if(f_query_add_mod.document.Bkappt_form.rec_date.value!="")
		{
		var clinic_code_main= f_query_add_mod.document.Bkappt_form.location.value;
		var val=new Array();
		var clinic_code;
			val =f_query_add_mod.document.Bkappt_form.location.value.split("$")
			if(val !="")
			{
				clinic_code=val[0].split("$");
			}else
			{
				clinic_code="";
			}
		var pract_id=f_query_add_mod.document.Bkappt_form.practitioner.value;
		var date_val=f_query_add_mod.document.Bkappt_form.rec_date.value;
		var date_val_greg=convertDate(f_query_add_mod.document.Bkappt_form.rec_date.value,"DMY",localeName,"en");
		
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr	="<root><SEARCH locncode=\""+clinic_code+"\" practid=\""+pract_id+"\" date_val=\""+date_val_greg+"\" steps='validatepref_date_wait_list'/></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","ServerSide.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		eval(responseText)
		if(wtlt_Flag==1)
			{
			
				var error=getMessage("WAIT_LIST_NOT_ALLW","OA");
				alert(error);
				submitflag=false;
				submitflag3=false;
			}

		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr	="<root><SEARCH date_val=\""+date_val_greg+"\" clinic_code=\""+clinic_code+"\" steps='validatepref_date_sunday'/></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","ServerSide.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		eval(responseText)
		if(sunday_flag==1)
		{
			var error=getMessage("WAITLIST_NOT_ALL_SUNDAY","OA");
			alert(error);
			submitflag=false;
				submitflag3=false;
		}
	}

if(patient_id!="" )
	{
	var xmlDoc= "" ;
	var xmlHttp= new XMLHttpRequest();

			xmlStr	="<root><SEARCH " ;
			xmlStr += "patient_id=\""+patient_id+"\"  steps='chk_unknown_patient'";
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST","../../eOA/jsp/ServerSide.jsp", false ) ;
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText);
			eval(responseText);

			if (flag ==true)
			{
				submitflag=true;
			}else
			{
				var error=getMessage( "NOT_KNOWN_PATIENT","AE");
				alert(error);
				submitflag=false;
				
			}

			if(submitflag ==true)
		{
			if(flag1==true)
			{
				submitflag=true;
			}else
			{
				var error=getMessage( "OP_EMERG_PAT_NOT_ALLOWED","OP");
				alert(error);
				submitflag=false;
				
			}
		}
	}

}

			if(submitflag && submitflag2 && submitflag3){
				
				enable_all();
				f_query_add_mod.document.Bkappt_form.action="../../servlet/eOA.AppointmentWtListServlet";
				f_query_add_mod.document.Bkappt_form.target="messageFrame";
				f_query_add_mod.document.Bkappt_form.submit();
			}else{
				if(f_query_add_mod.document.Bkappt_form.from.value!=''){
					var calling_mode=f_query_add_mod.document.Bkappt_form.calling_mode.value;
					var from=f_query_add_mod.document.Bkappt_form.from.value;					 
				
					var s = "<html> <head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sstyle+"'></link></head>" +
					"<body class='message' onKeyDown = 'lockKey()'><script>document.write(\""+LocalErrors+"\");"+
					" parent.frames[0].location.href ='../../eOA/jsp/OAToolbar.jsp?calling_mode="+calling_mode+"&from="+from+"';"+"</script></body></html>";
				 
					messageFrame.document.open('text/html', 'replace');
					messageFrame.document.write(s);
			
				}else{

					var s = "<html><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sstyle+"'></link><head><META HTTP-EQUIV='Content-Type' CONTENT='text/html; charset=windows-1256'>" +
					"</head><body onKeyDown = 'lockKey()'><form name='f' id='f' method='post' action='../../eCommon/jsp/error.jsp'>"+
					"<input type='hidden' name='err_num' id='err_num' value=\""+LocalErrors+"\">"
					"</form></body></html>" ;
					messageFrame.document.body.insertAdjacentHTML('afterbegin',s);
					messageFrame.document.f.submit();
				}
			}


			
					
	
}
	


function checkPatSex()
{
	var arLength = f_query_add_mod.NamePrefixArray.length;
	var q = 0;
	var res = new Boolean(false);

	while ( q <= arLength  )
	{
		
	if ( ( f_query_add_mod.document.Bkappt_form.name_prefix.value!='')  && ( unescape( f_query_add_mod.NamePrefixArray[q]) ==  f_query_add_mod.document.Bkappt_form.name_prefix.value ) )
	{
		if ( f_query_add_mod.PrefixSexArray[q] != f_query_add_mod.document.Bkappt_form.sex.value &&  f_query_add_mod.PrefixSexArray[q] != 'B') 
		{
			var msg = f_query_add_mod.getMessage("PATIENT_SEX_MISMATCH",'MP');
			
			if(localeName=='en')
			{
            msg = msg.replace('$',f_query_add_mod.document.Bkappt_form.name_prefix_prompt.value);
			}
			else
			{
			msg = msg.replace('$',f_query_add_mod.document.Bkappt_form.name_prefix_oth_prompt.value);
			}
			
			LocalErrors +=local_error1+ msg  + " <br>";
		res = false;
		}
		else{ 
			res = true;
		}
	}
	q++;
	}
	return res;
}


function checkPatSuffixSex()  {


    var arLength =f_query_add_mod.NameSuffixArray.length;
    var q = 0;
    var res = new Boolean(false);

        while ( q <= arLength  )
        {
			if ( (f_query_add_mod.document.Bkappt_form.name_suffix.value!='')  && ( unescape(f_query_add_mod.NameSuffixArray[q]) == f_query_add_mod.document.Bkappt_form.name_suffix.value ) )

            {
              if(f_query_add_mod.SuffixSexArray[q] != f_query_add_mod.document.Bkappt_form.sex.value && f_query_add_mod.SuffixSexArray[q] != 'B')

                {
					var msg = f_query_add_mod.getMessage("PATIENT_SEX_MISMATCH",'MP');
					
					if(localeName=='en')
					{
                    msg = msg.replace('$',f_query_add_mod.document.Bkappt_form.name_suffix_prompt.value);
					}
					else
					{
					msg = msg.replace('$',f_query_add_mod.document.Bkappt_form.name_suffix_oth_prompt.value);
					}
				
					LocalErrors +=local_error1+ msg  + " <br>";
					res = false;
               }
               else
                   res = true;
            }
            q++;
       }
    return res;
}



function enable_all()
{


	//if(f_query_add_mod.document.Bkappt_form.category)
		//if(f_query_add_mod.document.Bkappt_form.category.disabled=false;

if(f_query_add_mod.document.Bkappt_form.locationType)
	f_query_add_mod.document.Bkappt_form.locationType.disabled=false;

if(f_query_add_mod.document.Bkappt_form.location)
	f_query_add_mod.document.Bkappt_form.location.disabled=false;

//if(f_query_add_mod.document.Bkappt_form.practitioner_name)
	//f_query_add_mod.document.Bkappt_form.practitioner_name.disabled=false;

//if(f_query_add_mod.document.Bkappt_form.rec_date)
//	f_query_add_mod.document.Bkappt_form.rec_date.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.speciality)
		f_query_add_mod.document.Bkappt_form.speciality.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.patient_id)
		f_query_add_mod.document.Bkappt_form.patient_id.disabled=false;
	
	if(f_query_add_mod.document.Bkappt_form.patient_name)
		f_query_add_mod.document.Bkappt_form.patient_name.disabled=false;
	
	if(f_query_add_mod.document.Bkappt_form.national_id_no)
		f_query_add_mod.document.Bkappt_form.national_id_no.disabled=false;
	
	if(f_query_add_mod.document.Bkappt_form.alt_id1_no)
		f_query_add_mod.document.Bkappt_form.alt_id1_no.disabled=false;
	
	if(f_query_add_mod.document.Bkappt_form.alt_id2_no)
		f_query_add_mod.document.Bkappt_form.alt_id2_no.disabled=false;
	
	if(f_query_add_mod.document.Bkappt_form.alt_id3_no)
		f_query_add_mod.document.Bkappt_form.alt_id3_no.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.alt_id4_no)
		f_query_add_mod.document.Bkappt_form.alt_id4_no.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.name_prefix)
		f_query_add_mod.document.Bkappt_form.name_prefix.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.first_name)
		f_query_add_mod.document.Bkappt_form.first_name.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.second_name)
		f_query_add_mod.document.Bkappt_form.second_name.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.third_name)
		f_query_add_mod.document.Bkappt_form.third_name.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.family_name)
		f_query_add_mod.document.Bkappt_form.family_name.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.name_suffix)
		f_query_add_mod.document.Bkappt_form.name_suffix.disabled=false;

/**********other start************/

	if(f_query_add_mod.document.Bkappt_form.name_prefix_oth_lang)
		f_query_add_mod.document.Bkappt_form.name_prefix_oth_lang.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.first_name_oth_lang)
		f_query_add_mod.document.Bkappt_form.first_name_oth_lang.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.second_name_oth_lang)
		f_query_add_mod.document.Bkappt_form.second_name_oth_lang.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.third_name_oth_lang)
		f_query_add_mod.document.Bkappt_form.third_name_oth_lang.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.family_name_oth_lang)
		f_query_add_mod.document.Bkappt_form.family_name_oth_lang.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.name_suffix_oth_lang)
		f_query_add_mod.document.Bkappt_form.name_suffix_oth_lang.disabled=false;

/**********other end************/

	if(f_query_add_mod.document.Bkappt_form.sex)
		f_query_add_mod.document.Bkappt_form.sex.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.date_of_birth)
		f_query_add_mod.document.Bkappt_form.date_of_birth.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.contact1_no)
		f_query_add_mod.document.Bkappt_form.contact1_no.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.contact2_no)
		f_query_add_mod.document.Bkappt_form.contact2_no.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.email_id)
		f_query_add_mod.document.Bkappt_form.email_id.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.nationality)
		f_query_add_mod.document.Bkappt_form.nationality.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.alt_id1_exp_date)
		f_query_add_mod.document.Bkappt_form.alt_id1_exp_date.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.alt_id2_exp_date)
		f_query_add_mod.document.Bkappt_form.alt_id2_exp_date.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.alt_id3_exp_date)
		f_query_add_mod.document.Bkappt_form.alt_id3_exp_date.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.alt_id4_exp_date)
		f_query_add_mod.document.Bkappt_form.alt_id4_exp_date.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.b_age)
		f_query_add_mod.document.Bkappt_form.b_age.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.b_months)
		f_query_add_mod.document.Bkappt_form.b_months.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.b_days)
		f_query_add_mod.document.Bkappt_form.b_days.disabled=false;
	
	if(f_query_add_mod.document.Bkappt_form.other_alt_type)
		f_query_add_mod.document.Bkappt_form.other_alt_type.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.other_alt_Id)
		f_query_add_mod.document.Bkappt_form.other_alt_Id.disabled=false;

	if(f_query_add_mod.document.Bkappt_form.citizen_yn[0])
		f_query_add_mod.document.Bkappt_form.citizen_yn[0].disabled=false;

	if(f_query_add_mod.document.Bkappt_form.legal_yn[0])
		f_query_add_mod.document.Bkappt_form.legal_yn[0].disabled=false;

	if(f_query_add_mod.document.Bkappt_form.citizen_yn[1])
		f_query_add_mod.document.Bkappt_form.citizen_yn[1].disabled=false;

	if(f_query_add_mod.document.Bkappt_form.legal_yn[1])
		f_query_add_mod.document.Bkappt_form.legal_yn[1].disabled=false;

	if(f_query_add_mod.document.Bkappt_form.ethnic_group)
		f_query_add_mod.document.Bkappt_form.ethnic_group.disabled=false;

	/*
	if(f_query_add_mod.document.Bkappt_form.race_code)
		f_query_add_mod.document.Bkappt_form.race_code.disabled=false;
	*/

	if(f_query_add_mod.document.Bkappt_form.race_desc) {
		f_query_add_mod.document.Bkappt_form.race_desc.disabled=false;
		f_query_add_mod.document.Bkappt_form.race_desc_id.disabled=false;
	}

	 f_query_add_mod.document.Bkappt_form.place_of_birth.disabled=false;
 	 f_query_add_mod.document.Bkappt_form.Birth_place_code.disabled=false;
	 
}



function reset()
{
	  
	var oper_stn_id = f_query_add_mod.document.forms[0].oper_stn_id.value;
	var alcn_criteria_yn = f_query_add_mod.document.forms[0].alcn_criteria_yn.value;
	var install_yn = f_query_add_mod.document.forms[0].install_yn.value;
	var waitlist_category_appl_yn = f_query_add_mod.document.forms[0].waitlist_category_appl_yn.value;
	var invitation_list_appl_yn = f_query_add_mod.document.forms[0].invitation_list_appl_yn.value;
	var waitlist_category_reqd_yn = f_query_add_mod.document.forms[0].waitlist_category_reqd_yn.value;
	var restrict_wl_cat_agst_splty_yn = f_query_add_mod.document.forms[0].restrict_wl_cat_agst_splty_yn.value;
	var dttm = f_query_add_mod.document.forms[0].dttm.value;
	var prd = f_query_add_mod.document.forms[0].prd.value;
	var curr_month = f_query_add_mod.document.forms[0].curr_month.value;
	if (f_query_add_mod.document.forms[0].from.value=='ScheduleAppt')
	{
		f_query_add_mod.location.href = "../../eOA/jsp/ApptWaitListlMainPage.jsp?operation=insert&from=ScheduleAppt&calling_mode='OA'&oper_stn_id="+oper_stn_id+"&alcn_criteria_yn="+alcn_criteria_yn+"&waitlist_category_appl_yn="+waitlist_category_appl_yn+"&invitation_list_appl_yn="+invitation_list_appl_yn+"&waitlist_category_reqd_yn="+waitlist_category_reqd_yn+"&restrict_wl_cat_agst_splty_yn="+restrict_wl_cat_agst_splty_yn+"&dttm="+dttm+"&prd="+prd+"&curr_month="+curr_month+"&install_yn="+install_yn;
	}else{
		
		f_query_add_mod.document.location.reload();
	}

}

function checkColon(dt)
{
	 var time='';	
	 var dtArr=dt.split(' ');
	 time=dtArr[1];
	 charAtpos3=time.charAt(2);
	 
	 if (charAtpos3 == ':')
	   return true;
		 else
	   return false;
}




function Valid_DT(event){
	var strCheck = '0123456789:/ ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

function populateLocations(Obj){/*enabling/disabling location look and location lookup,resourse and resouse lookup*/
	var speciality=document.forms[0].speciality.value;
	var oper_stn_id=document.forms[0].oper_stn_id.value;
	document.forms[0].practitioner.value="";
	document.forms[0].practitioner_name.value="";
	document.forms[0].practitioner_name.disabled=true;
	document.forms[0].search_pract.disabled=true;
	document.getElementById("pract_type").innerHTML="&nbsp;";
	if(speciality=='' && document.forms[0].rd_oa_integration_yn.value=="N"){
		//alert("APP-000001 Speciality cannot be blank");
		var err1= getMessage('CAN_NOT_BE_BLANK','Common');
		err1= err1.replace('$',getLabel("Common.speciality.label","Common"));
		alert(err1);
		Obj.value='';
	}/*else{
	
		document.forms[0].practitioner.value='';
		document.forms[0].practitioner_name.value='';
		document.getElementById("pract_type").innerHTML="&nbsp;";
		document.forms[0].practitioner_name.disabled=true;
		document.forms[0].search_pract.disabled=true;
		document.forms[0].resourceType.value='';
		document.forms[0].location.disabled=false;
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH speciality=\""+speciality+"\" clinic_type=\""+Obj.value+"\" steps='APPTWTLST' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","ServerSide.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText) 
	}*/
	if(Obj.value==null||Obj.value==""){
	document.forms[0].b_loc_val.value="";
	document.forms[0].location.value="";
	document.forms[0].b_loc_val.disabled=true;
	document.forms[0].b_loc_search.disabled=true;
	}else{
	document.forms[0].b_loc_val.value="";
	document.forms[0].location.value="";
	document.forms[0].b_loc_val.disabled=false;
	document.forms[0].b_loc_search.disabled=false;
	}
}


function populatePractitioner(Obj){
	document.forms[0].practitioner.value='';
	document.forms[0].practitioner_name.value='';
	document.forms[0].practitioner_name.disabled=true;
	document.forms[0].search_pract.disabled=true;
	document.forms[0].resourceType.value='';
	var ObjVal=Obj.value;
	var arr=ObjVal.split("$");
	var clnc_cd=arr[0];
	var clinic_type=document.forms[0].locationType.value;
	var specialty_code="";
	specialty_code=document.forms[0].speciality.value;
	document.forms[0].resourceType.value=''
	document.getElementById("pract_type").innerHTML="&nbsp;";
	if(ObjVal==''){
		document.forms[0].practitioner_name.value='';
		document.forms[0].practitioner_name.disabled=true;
		document.forms[0].search_pract.disabled=true;
	}else{
		document.forms[0].practitioner_name.value='';
		document.forms[0].practitioner_name.disabled=false;
		document.forms[0].search_pract.disabled=false;
	}
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH speciality=\""+specialty_code+"\" location=\""+ObjVal+"\" clinic_type=\""+clinic_type+"\" clinic_code1=\""+clnc_cd+"\" steps='XXX' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
}


function clear_vals(){
	if(document.forms[0].or_catalogue_desc.value==''){
		document.forms[0].or_catalogue_code.value='';
	}else{
		callORSearch();
	}
}

async function callORSearch()
{
	var p_speciality_code=document.forms[0].speciality.value;	
	var clinic_code=document.forms[0].location.value;	
	var clinic_cod=clinic_code.split("$");
	var locnCode=clinic_cod[0];
	//var dialogHeight= "29" ;
	//var dialogTop = "125" ;
	//var dialogWidth	= "50" ;
	var dialogHeight= "500px" ;
	var dialogTop = "10px" ;
	var dialogWidth	= "750px" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	var or_catalogue_desc=document.forms[0].or_catalogue_desc.value;
	var rd_appt_yn = "N"
	if(document.forms[0].rd_oa_integration_yn.value=="Y"){	
		if(document.forms[0].rd_waitlist_yn.checked){			
			rd_appt_yn = "Y"
		}else{			
			rd_appt_yn = "N"
		}
	}
	
	var url="../../eOR/jsp/RefusalOrderOrderableFrameSet.jsp?searchText="+escape(or_catalogue_desc)+"&called_from=OA&mode="+MODE_INSERT+"&locnCode="+locnCode+"&rd_appt_yn="+rd_appt_yn+"&p_speciality_code="+p_speciality_code+"&table_name='AM_CATALOG_FOR_SPECIALITY_VW'&order_category=&order_type=";
	

	var retVal = new String();
	retVal = await window.showModalDialog(url,arguments,features);

	if(retVal){
		var secArr=retVal.split("&");
		document.forms[0].or_catalogue_code.value=secArr[0];
		document.forms[0].or_catalogue_desc.value=secArr[1];
	}else{
		document.forms[0].or_catalogue_code.value='';
		document.forms[0].or_catalogue_desc.value='';
	}
}

function onSuccess(obj)
{	
	if(obj == "scheduleappt") {
	var curr_month = parent.f_query_add_mod.document.forms[0].curr_month.value;
	var oper_stn_id = parent.f_query_add_mod.document.forms[0].oper_stn_id.value;
	var alcn_criteria_yn =parent. f_query_add_mod.document.forms[0].alcn_criteria_yn.value;
	var install_yn = parent.f_query_add_mod.document.forms[0].install_yn.value;
	var waitlist_category_appl_yn = parent.f_query_add_mod.document.forms[0].waitlist_category_appl_yn.value;
	var invitation_list_appl_yn = parent.f_query_add_mod.document.forms[0].invitation_list_appl_yn.value;
	var waitlist_category_reqd_yn = parent.f_query_add_mod.document.forms[0].waitlist_category_reqd_yn.value;
	var restrict_wl_cat_agst_splty_yn = parent.f_query_add_mod.document.forms[0].restrict_wl_cat_agst_splty_yn.value;
	var dttm = parent.f_query_add_mod.document.forms[0].dttm.value;
	var prd = parent.f_query_add_mod.document.forms[0].prd.value;
	var curr_month = parent.f_query_add_mod.document.forms[0].curr_month.value;
	window.location.href ="../eOA/jsp/ApptWaitListlMainPage.jsp?operation=insert&from=ScheduleAppt&calling_mode='OA'&oper_stn_id="+oper_stn_id+"&alcn_criteria_yn="+alcn_criteria_yn+"&waitlist_category_appl_yn="+waitlist_category_appl_yn+"&invitation_list_appl_yn="+invitation_list_appl_yn+"&waitlist_category_reqd_yn="+waitlist_category_reqd_yn+"&restrict_wl_cat_agst_splty_yn="+restrict_wl_cat_agst_splty_yn+"&dttm="+dttm+"&prd="+prd+"&curr_month="+curr_month+"&install_yn="+install_yn;
	} else {
		parent.parent.frames[2].frames[1].location.reload();
	}
}


function localValidations(inVal)
{
	setTimeout("validpatient('P')",1000);
}


function validpatient(inVal) 
{
	var location1=document.forms[0].location.value;
	var clinic_cod=location1.split("$");
	var clinic_cod1=clinic_cod[0];
	var careLocnTypeInd= clinic_cod[1];
	if(location1!="" && location1!=null)
	{
		if(document.getElementById("patient_id").value!="")
		{
			var HTMLVal = new String();
			var xmlDoc = ""
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH pat_id=\""+document.getElementById("patient_id").value+"\" wait_clinic_code=\""+clinic_cod1+"\" wait_careLocnTypeInd=\""+careLocnTypeInd+"\" steps='CreateWaitList'/></root>"
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","ServerSide.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			eval(responseText) 
		}
	}
}
function clear_all_fun1(flag)
{
	document.forms[0].patient_id.value="";
	document.getElementById("patient_name1").innerHTML="&nbsp";
	clearAll();
}


/*Lookup to open waitlist category search based on speciality selected*/
async function open_lookup()
{
		var p_speciality_code=document.forms[0].speciality.value;	

		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";

		var sql="select a.WAITLIST_CATEGORY_CODE code, a.LONG_DESC description from OA_WAITLIST_CATEGORY a,OA_WL_CATEGORY_FOR_SPLTY b where a.WAITLIST_CATEGORY_CODE=b.WAITLIST_CATEGORY_CODE AND a.eff_status = 'E' and b.SPECIALTY_CODE='"+p_speciality_code+"' and upper(a.WAITLIST_CATEGORY_CODE) like upper(?) and upper(a.LONG_DESC) like upper(?)  ";

		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].walst_category.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ; 

		retVal = await CommonLookup( getLabel("Common.WaitList.label","Common"), argumentArray );
		var arr=new Array();
		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split(",");
			var desc=arr[1];
			var code=arr[0];
			document.forms[0].walst_category.value=desc;
			document.forms[0].walst_category_code.value=code;
		}else
		{

			document.forms[0].walst_category.value="";
			document.forms[0].walst_category_code.value="";
		}
}

function enable_category(obj){/* enabling/disabling waitlist category code and clearing location values */
	if(document.forms[0].waitlist_category_appl_yn.value=="Y"){
		if(document.forms[0].rd_oa_integration_yn.value=="N"){
		document.forms[0].locationType.value="";
		document.forms[0].b_loc_val.value="";
		document.forms[0].location.value="";
		document.forms[0].b_loc_val.disabled=true;
		document.forms[0].b_loc_search.disabled=true;
		document.forms[0].practitioner.value="";
		document.forms[0].practitioner_name.value="";
		document.forms[0].practitioner_name.disabled=true;
		document.forms[0].search_pract.disabled=true;
		document.getElementById("pract_type").innerHTML="&nbsp;";
			document.forms[0].walst_category.value="";
		}
		if(obj.value !=null && obj.value !=""){
			document.forms[0].walst_category.disabled=false;
			document.forms[0].walst_cate_search.disabled=false;
		}else {
			document.forms[0].walst_category.disabled=true;
			document.forms[0].walst_cate_search.disabled=true;
		}
		
	}
}

async function open_lookup_one()
{
		var p_speciality_code=document.forms[0].speciality.value;	

		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";
		if(document.forms[0].walst_category.value !="")
	{
		var sql="select a.WAITLIST_CATEGORY_CODE code, a.LONG_DESC description from OA_WAITLIST_CATEGORY a,OA_WL_CATEGORY_FOR_SPLTY b where a.WAITLIST_CATEGORY_CODE=b.WAITLIST_CATEGORY_CODE and a.EFF_STATUS='E' and b.SPECIALTY_CODE='"+p_speciality_code+"' and upper(a.LONG_DESC) like upper(?) and upper(a.WAITLIST_CATEGORY_CODE) like upper(?)  ";
		
		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].walst_category.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ; 

		retVal = await CommonLookup( getLabel("Common.WaitList.label","Common"), argumentArray );
		var arr=new Array();
		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split(",");
			var desc=arr[1];
			var code=arr[0];
			document.forms[0].walst_category.value=desc;
			document.forms[0].walst_category_code.value=code;
		}else
		{
			document.forms[0].walst_category.value="";
			document.forms[0].walst_category_code.value="";
			return;
		}
	}else
	{
		document.forms[0].walst_category.value="";
		document.forms[0].walst_category_code.value="";
	}
}



async function invoke_invitation()
{
		 
		var curr_month = document.forms[0].curr_month.value;
		var prd = document.forms[0].prd.value;
		var old_date = document.forms[0].dttm.value;
		var retVal =    new String();
		var dialogLeft   = "45";
		var dialogHeight= "90vh" ;
		var dialogTop = "82" ;
		var dialogWidth	= "160vh" ;
		var status = "no";
		var alcn_criteria='None';
		var argument;
		var calling_from = "";
		var features    = "dialogHeight:" + dialogHeight +";dialogWidth:" + dialogWidth +" ;dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; scroll=no; status:" + status;
		retVal = await window.showModalDialog('../../eOA/jsp/InvitationStatus.jsp?alcn_criteria='+alcn_criteria+'&old_date='+old_date+'&curr_month='+curr_month+'&prd='+prd,arguments,features);	
}

function enable_category_gif()
{
	if(document.forms[0].waitlist_category_appl_yn.value=="Y")
	{
		if(document.forms[0].waitlist_category_reqd_yn.value=="Y")
		{
			document.getElementById("wait_lst_cat").style.visibility="visible";
		}else
		{
			document.getElementById("wait_lst_cat").style.visibility="hidden";

		}
	}
}


/**********Date*******/


function validate_date_from(from)
{
	var sys=document.forms[0].hddDTTM.value;
	
	if(from.value!="")
		{
		if(!validDateObj(from,"DMY",localeName))
		{
			from.value="";
			return ;
		}

		var obj1=convertDate(from.value,"DMY",localeName,"en");

		if(isBefore(sys,obj1,'DMY','en')==false)//localName is changed to en by Rameswar on 01-OCT-15 for Leap Year Issue 
				{
				alert(getMessage("PREF_FM_DT_VALIDATION","OA"));
				from.value="";
				from.select();	
				return false;
			}
			else
				return true;

		}
}

async function open_create_waitlist_reason()
{
		

		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";
		
		var sql="select CONTACT_REASON_CODE code, CONTACT_REASON description from AM_CONTACT_REASON where MODIFY_WAIT_LIST_YN = 'Y' and upper(CONTACT_REASON_CODE) like upper(?) and upper(CONTACT_REASON) like upper(?)  ";

		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].reason_create.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ; 

		retVal = await CommonLookup( getLabel("eOA.ReasonForCreateWaitlist.label","OA"), argumentArray );
		var arr=new Array();

		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split(",");
			var desc=arr[1];
			var code=arr[0];
			document.forms[0].reason_create.value=desc;
			document.forms[0].reason_code.value=code;
		}else
		{
			document.forms[0].reason_create.value="";
			document.forms[0].reason_code.value="";
			return;
		}
	
}

    async function open_loc_lookup(){	
	var location_val=document.forms[0].b_loc_val.value;
	var locn_type=document.forms[0].locationType.value;
	var care_locn_ind=document.forms[0].locationType.value;
	var speciality_code=document.forms[0].speciality.value;
	var rd_appt_yn="N"
	if(document.forms[0].rd_oa_integration_yn.value == "Y")
		if(document.forms[0].rd_waitlist_yn.checked)
			rd_appt_yn="Y";
	//var dialogTop = "60" ;
	//var dialogHeight= "37" ;
	//var dialogWidth	= "60" ;
	var dialogTop = "10px" ;
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;	
	var status = "no";
	var arguments	= "" ;
	var tit="locn_Srch";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	var retVal="";
	retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&speciality_code="+speciality_code+"&care_locn_ind="+care_locn_ind+"&rd_appt_yn="+rd_appt_yn+"&function_id=APPT_WAIT_LIST",arguments,features);
	if(retVal!=null){	
		var rvalues=retVal.split("~");
		var clinic_code=rvalues[0];
		var desc=rvalues[1];		
		var open_to_all_pract_yn=rvalues[2];
		var clinic_type=rvalues[3];
		var ident_at_checkin=rvalues[4];
		var fi_visit_type_appl_yn=rvalues[5];
		var alcn_criteria=rvalues[6];
		var STime=rvalues[7];
		var ETime=rvalues[8];
		var dur=rvalues[9];
        document.forms[0].b_loc_val.value=desc;		document.forms[0].location.value=clinic_code+"$"+clinic_type+"$"+open_to_all_pract_yn+"$"+ident_at_checkin+"$"+fi_visit_type_appl_yn+"$"+alcn_criteria+"$"+STime+"$"+ETime+"$"+dur;
		populatePractitioner(document.forms[0].location);
	}else{
		document.forms[0].b_loc_val.value="";
		document.forms[0].location.value="";
		populatePractitioner(document.forms[0].location);
	}

}


function ena_loc_lookup(obj){
		if(obj.value==null || obj.value==''){
		document.forms[0].b_loc_val.value="";
		document.forms[0].location.value="";
		populatePractitioner(document.forms[0].location);
	}else{
	open_loc_lookup()
	}
}
function ChkNumberInput1(fld, e, deci)
{
if (parseInt(deci)>0)
   var strCheck = '.0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
else
   var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
	
var whichCode = (window.Event) ? e.which : e.keyCode;
if (whichCode == 13) return true;  // Enter

key = String.fromCharCode(whichCode);  // Get key value from key code

if (strCheck.indexOf(key) == -1) return false;  // Not a valid key

if(key == "." && fld.value.indexOf(key) != -1) return false; // Not more than one '.' char

}
function rdWaitListAppl(obj){ 
	if(obj.checked==true){
		document.forms[0].rd_waitlist_yn.value="Y";
		document.forms[0].locationType.value="E";
		document.forms[0].locationType.onchange();
		document.forms[0].locationType.disabled=true;
		document.getElementById("ordCatImg").style.visibility='visible';
		document.getElementById("locnManImg").style.visibility='visible'
	}else if(obj.checked==false){
		document.forms[0].rd_waitlist_yn.value="N";
		document.forms[0].locationType.selectedIndex=0;
		document.forms[0].locationType.onchange();
		document.forms[0].locationType.disabled=false;
		document.getElementById("ordCatImg").style.visibility='hidden';
		document.getElementById("locnManImg").style.visibility='hidden'
	}
}

function checkMultiSpecialityYN(obj){
	if(obj.value!=''){
		var spec_code=obj.value;
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr	="<root><SEARCH speciality_code=\""+spec_code+"\" steps='checkMultiSpec'/></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","ServerSide.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		document.forms[0].multi_speciality_yn.value=trimString(responseText);
	}	
}

