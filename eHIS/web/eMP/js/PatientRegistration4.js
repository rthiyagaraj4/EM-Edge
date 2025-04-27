
function focusBack()
			{
    			document.forms[0].pat_ser_grp_code.focus();
			}
			/**
		    	Used to control the focus of additional fields in ContactAddress tab.
				func1() - called onblur of contact3_mode
				If there are no additionalfields focus is placed in contact4_mode.
				func2() - called onblur of contact4_mode
				If there is one additional field focus is placed on contact5_mode.
				@Author - Gomathi
			*/
			function func1()
			{
			if(document.forms[0].ccount.value < 1)
			document.forms[0].contact4_mode.focus();                      
			}
			function func2()
			{
			if(document.forms[0].ccount.value < 2)
			document.forms[0].contact5_mode.focus();
			}
			/**
				Used to enable or disable the PlaceofBirth(TextField) based on BirthPlaceCode(Lookup).
				If Birthplace code is not entered,TextField(PlaceofBirth) is enabled
				If PlaceofBirth is not entered, Birthplacecode is enabled.
				@author - Gomathi
			*/
			function CheckBirthPlace()
			{
				
				//Added by Sangeetha for ML-MMOH-SCF-0717
				if(document.forms[0].txtSmart_fn_name.value != '03'){
					if(document.forms[0].place_of_birth_desc.value=="")			
					   document.forms[0].place_of_birth.disabled=false;
					else
					   document.forms[0].place_of_birth.disabled=true;
				}
			}
			function CheckBirthCode()
			{
			
			  //Added by Sangeetha for ML-MMOH-SCF-0717
			  if(document.forms[0].txtSmart_fn_name.value != '03'){
					if(document.forms[0].place_of_birth.value=="")
					{
					   document.forms[0].place_of_birth_desc.disabled=false;
						document.forms[0].birth_place.disabled=false;
					}
					else
					{
					   document.forms[0].place_of_birth_code.value="";
					   document.forms[0].place_of_birth_desc.disabled=true;
					   document.forms[0].birth_place.disabled=true;
					}
			  }
		    }
		/**
		   Used to make the mandatory gif of race visible or invisible based on
		   NRIC.
		   @Author - Gomathi
		*/
			function checkNRIC()
		{
			
			if(!(document.forms[0].national_id_no.value==""))
				document.forms[0].image1.style.visibility='visible';

		}
	    /**
		   SearchLookup for BirthPlace.
		   @Author - Gomathi
		   @param  - Lookup title,Target fieldname
			This function is also in PatientRegistration1.js. Use that file to access the function
			
			/**
				SearchLookup for Country.
				@param  - Lookup title,Target fieldname
				*/
				async function searchCountry(obj,target)
				{
				var retVal =    new String();
                var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var localeName=document.forms[0].localeName.value; //Added by Suji Keerthi for ML-MMOH-CRF-1527
				var tit="";
                if(obj.name=="contry_code" || obj.name=="rel_contry_code" || obj.name=="nk_ma_country_code" || obj.name=="ma_country_code") //Modified by Suji Keerthi for ML-MMOH-CRF-1527 US007 & US008
                {

					if(target.name=="nationality_desc" || target.name=="rel_nationality_desc"){ //Modified by Suji Keerthi for ML-MMOH-CRF-1527 US007
					tit=getLabel('Common.nationality.label','common');
						sql="Select country_code code,long_desc description from Mp_Country_lang_vw where eff_status='E' and  upper(country_code) like upper(?) and upper(long_desc) like upper(?) and language_id='"+localeName+"' order by 2";
					}
					else{
						tit=getLabel('Common.country.label','common');
						sql="Select country_code code,long_name description from Mp_Country_lang_vw where eff_status='E' and upper(country_code) like upper(?) and upper(long_name) like upper(?) and language_id='"+localeName+"' order by 2";
					}
					
               	}
				argumentArray[0] =sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;
				retVal = await CommonLookup( tit, argumentArray );
				if(retVal != null && retVal != "" )
                {
					
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target.value=arr[1];
					if(target.name == 'nationality_desc')
						document.forms[0].nationality_code.value= arr[0];
					else if(target.name == 'r_country_desc')
						document.forms[0].r_country_code.value= arr[0];
					else if(target.name == 'm_country_desc')
						document.forms[0].m_country_code.value= arr[0];
					else if(target.name == 'first_country_desc')
						document.forms[0].first_country_code.value= arr[0];
					else if(target.name == 'next_country_desc')
						document.forms[0].next_country_code.value= arr[0];
					else if(target.name == 'empyr_country_desc')
						document.forms[0].empyr_country_code.value= arr[0];
					else if(target.name == 'a_country_desc')
						document.forms[0].a_country_code.value= arr[0];						
					//Below added by Suji Keerthi for ML-MMOH-CRF-1527 US007 & US008
					else if(target.name == 'rel_nationality_desc')
						document.forms[0].rel_nationality_code.value= arr[0];
					else if(target.name == 'nk_ma_country_desc')
						document.forms[0].nkin_mail_country_code.value= arr[0];
					else if(target.name == 'first_mail_country_desc')
						document.forms[0].first_mail_country_code.value= arr[0];
					//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US007 & US008
					/*Above line added for this CRF ML-MMOH-CRF-0860.2*/		
				}
				else{
					target.value='';
					}
			}
          	var disp_in_oth_lang = false;
            var PSGCodeArray = new Array(); 
            var PSGYNArray = new Array(); 


			/**
			   Used to enable or disable the Occupation Description TextField
			   based on the List Item.
			*/
			function enableocpn(){
					if(document.getElementById("occ_of_per").selectedIndex != 0){
						document.getElementById("occu_of_per_desc").value = '';
						document.getElementById("occu_of_per_desc").disabled = true;
					}
					else if (document.getElementById("occ_of_per").selectedIndex == 0)
						document.getElementById("occu_of_per_desc").disabled = false;
			}
			/**
			   Used to select Legal/Illegal based on Citizen/Non-citizen.
			   @Author - Gomathi.
			*/
			function change_status(){ 				

				
				document.PatRegForm.legal[0].disabled=false;
				document.PatRegForm.legal[1].disabled=false;
				document.PatRegForm.nationality_code.value="";
				document.PatRegForm.nationality_desc.value="";
				var isNatIdAltIdMandVisaType=document.PatRegForm.isNatIdAltIdMandVisaType.value;
				document.PatRegForm.race_code.value="";
				document.getElementById("race_desc").value=""; 
				/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] Start*/
				var isForm60Available	= document.PatRegForm.isForm60Available.value;
				var CalledFromFunction	=  document.PatRegForm.CalledFromFunction.value;
				var isForm60Validation	=  document.PatRegForm.isForm60Validation.value;
				/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] End*/
		
				
				if(document.PatRegForm.citizen[0].checked==true) {
					//document.PatRegForm.all.citizen_yn.value='Y';
					//document.PatRegForm.all.legal_yn.value='Y';
					document.getElementById('citizen_yn').value='Y';
					document.getElementById('legal_yn').value='Y';
					/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] Start*/
					if(CalledFromFunction!="EmergencyReg" && isForm60Available=="true" && isForm60Validation=="Y"){
						//document.PatRegForm.formno60.value="N";//Commented by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809] 
						document.PatRegForm.formno60.disabled=false;

						//document.PatRegForm.alt_id3_no.value="";//Commented by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809] k
						if(document.PatRegForm.formno60.value=="N")
							document.PatRegForm.alt_id3_no.disabled=false;
						//Commented by Dharma on July 14th 2016 against KDAH-SCF-0358 [IN:060809]
						/*document.PatRegForm.alt_id3_reqd_yn.value="Y";
						document.getElementById("alt3_gif").style.visibility='visible';*/
			
					}
					//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022
					if(isNatIdAltIdMandVisaType=="true")
						{
						validateDftNationalId(trimString(document.forms[0].national_id_no.value));
						}
					/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] End*/
			
				} else {
					//document.PatRegForm.all.citizen_yn.value='N';
						document.getElementById('citizen_yn').value='N';						
					/*Below line Added for this CRF GHL-CRF-0332 [IN:042060]*/
					if(document.PatRegForm.alt_id1_man_non_ctz && document.PatRegForm.alt_id1_man_non_ctz.value=="true"){ 
					  if(document.getElementById('alt1_gif')){
					     /*document.PatRegForm.all.alt_id1_reqd_yn.value='Y'; 
					     document.forms[0].all.alt1_gif.style.visibility='visible';
						 document.PatRegForm.all.alt_id1_no.disabled=false;*/
						 document.getElementById('alt_id1_reqd_yn').value='Y'; 
					     document.getElementById('alt1_gif').style.visibility='visible';
						 document.getElementById('alt_id1_no').disabled=false;
					  }
					  if(document.getElementById('alt1_exp_date1')){
					     document.getElementById('alt_date1_reqd_yn').value='Y';
					     document.getElementById('alt1_exp_date1').style.visibility='visible';
					  }	
						
					  
					}//End GHL-CRF-0332 [IN:042060] 
					/*Added by Dharma on 25th Jan 2019 MMS-DM-CRF-0152 [IN:069128] Start*/
					/*isNatIdOrAltIdMandVisaType added by Dharma on 20th Mar 2019 NMC-JD-CRF-0018 [IN:069750]*/
					 //Maheshwaran added -isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022
					if((document.PatRegForm.isNatIdOrAltId1MandRes && document.PatRegForm.isNatIdOrAltId1MandRes.value=="true") || (document.PatRegForm.isNatIdOrAltIdMandVisaType.value=="true") || (document.PatRegForm.isNatIdAltIdMandVisaType.value=="true")){
						getVisibleMandNatAltIds();
					}
					/*Added by Dharma on 25th Jan 2019 MMS-DM-CRF-0152 [IN:069128] End*/


					/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] Start*/
					
					if(CalledFromFunction!="EmergencyReg" && isForm60Available=="true" && isForm60Validation=="Y") {
						/*Modified by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809] Start*/
						/*document.PatRegForm.formno60.value="N";
						document.PatRegForm.formno60.disabled=true;

						document.PatRegForm.alt_id3_no.value="";
						document.PatRegForm.alt_id3_no.disabled=true;*/
						/*Modified by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809] End*/
						document.PatRegForm.alt_id3_reqd_yn.value="N";
						document.getElementById("alt3_gif").style.visibility='hidden';
					}

					/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] End*/
					//Maheshwaran K added for AAKH-CRF-0168 as on 22-10-2022
				/*	if(isNatIdAltIdMandVisaType=="true")
						{
								alert('257 in PatientRegistration4.js');
						validateDftNationalId(trimString(document.forms[0].national_id_no.value));
						}*/
				}
			}
			/**
			   Used to set the values when citizen or non-citizen is selected.
			   
			*/
			function change_stat_dis() { 		
				
				
				document.PatRegForm.legal[0].disabled=true;
				document.PatRegForm.legal[1].disabled=true;
				/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] Start*/
				var isForm60Available	= document.PatRegForm.isForm60Available.value;
				var CalledFromFunction	=  document.PatRegForm.CalledFromFunction.value;
				var isForm60Validation	=  document.PatRegForm.isForm60Validation.value;
				/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] End*/
				
				if(document.PatRegForm.citizen[0].checked==true) {
					document.PatRegForm.legal[0].checked=true;
					document.getElementById('citizen_yn').value='Y';
					document.getElementById('legal_yn').value='Y';

					document.PatRegForm.nationality_code.value=document.getElementById("dflt_nationality_code").value;
					document.getElementById("nationality_desc").value=document.getElementById("dft_natDesc").value; 	

					document.PatRegForm.race_code.value=document.getElementById("default_race_code").value;
					document.getElementById("race_desc").value=document.getElementById("default_race_desc").value; 	
					/*Below line Added for this CRF GHL-CRF-0332 [IN:042060]*/
				  if(document.PatRegForm.alt_id1_man_non_ctz && document.PatRegForm.alt_id1_man_non_ctz.value=="true"){ 
					   if(document.getElementById('alt1_gif')){
					      document.getElementById('alt_id1_reqd_yn').value='N'; 
					      document.getElementById('alt1_gif').style.visibility='hidden';
					   }
					   if(document.getElementById('alt1_exp_date1')){
					      document.getElementById('alt_date1_reqd_yn').value='N';
					      document.getElementById('alt1_exp_date1').style.visibility='hidden';			
				       } 
				 }	  //End GHL-CRF-0332 [IN:042060]
				 



				  /*Added by Dharma on 25th Jan 2019 MMS-DM-CRF-0152 [IN:069128] Start*/
				  /*isNatIdOrAltIdMandVisaType added by Dharma on 20th Mar 2019 NMC-JD-CRF-0018 [IN:069750]*/
				  //Maheshwaran added -isNatIdAltIdMandVisaType for AAKH-CRF-0145 as on 22-04-2022
					if((document.getElementById('sNatIdOrAltId1MandRes') && document.getElementById('isNatIdOrAltId1MandRes').value=="true") || (document.getElementById('isNatIdOrAltIdMandVisaType').value=="true") || (document.getElementById('isNatIdAltIdMandVisaType').value=="true")){
						getVisibleMandNatAltIds();
					}
					/*Added by Dharma on 25th Jan 2019 MMS-DM-CRF-0152 [IN:069128] End*/

				/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] Start*/
					if(CalledFromFunction!="EmergencyReg" && isForm60Available=="true" && isForm60Validation=="Y"){

						//document.PatRegForm.formno60.value="N";//Commented by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809] 
						document.PatRegForm.formno60.disabled=false;

						//document.PatRegForm.alt_id3_no.value="";//Commented by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809] 
						if(document.PatRegForm.formno60.value=="N")
							document.PatRegForm.alt_id3_no.disabled=false;
						//Commented by Dharma on July 14th 2016 against KDAH-SCF-0358 [IN:060809]
						/*document.PatRegForm.alt_id3_reqd_yn.value="Y";
						document.getElementById("alt3_gif").style.visibility='visible';*/
					
					}
				/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] End*/




				} else { 
					document.PatRegForm.legal[0].checked=true;
					document.getElementById('citizen_yn').value='N';			
					
					/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] Start*/
					if(CalledFromFunction!="EmergencyReg" && isForm60Available=="true" && isForm60Validation=="Y"){
						/*Modified by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809] Start*/
						/*document.PatRegForm.formno60.value="N";
						document.PatRegForm.formno60.disabled=true;

						document.PatRegForm.alt_id3_no.value="";
						document.PatRegForm.alt_id3_no.disabled=true;*/
						/*Modified by Dharma on July 26th 2016 against KDAH-SCF-0358 [IN:060809] End*/

						document.PatRegForm.alt_id3_reqd_yn.value="N";
						document.getElementById("alt3_gif").style.visibility='hidden';
					}
					/*Added by Dharma on 25th Jan 2016 for KDAH-CRF-0331 [IN058799] End*/

				}
				
			}	
			
			/**
			   Used to enable the Other Alternate ID TextField when Other AltID Type is
			   selected from the list item.
			   @Author - Gomathi.
			*/
			function enableAltID(){
					
				document.getElementById('other_alt_Id_text').value="";
				if(document.getElementById('other_alt_id').selectedIndex != 0){
					document.getElementById('other_alt_Id_text').disabled = false;
					document.getElementById('other_alt_Id_text').value="";
				}
				else 
					document.getElementById('other_alt_Id_text').disabled = true;
			
			}
			/**
			   Used to enable the Other Alternate ID TextField when Other AltID Type is
			   selected from the list item.	(applies to first to notify tab)
			   @Author - Gomathi.
			*/
			function nenableAltID(){
					
				document.getElementById('notify_oth_alt_id_text').value="";
				if(document.getElementById('notify_oth_alt_id_type').selectedIndex != 0){
					document.getElementById('notify_oth_alt_id_text').disabled = false;
					document.getElementById('notify_oth_alt_id_text').value="";
				}
				else 
					document.getElementById('notify_oth_alt_id_text').disabled = true;
			
			}
           async function get_patient_id()
            {
                var patient_id_back = await PatientSearch('','','','','','','','','','PAT_REG');

                if ((patient_id_back != null))
                {
                    patient_id_back = unescape(patient_id_back)
                    document.PatRegForm.family_link_no.value=patient_id_back;
                    document.PatRegForm.family_link_no.focus();
                }
                else document.PatRegForm.family_link_no.focus();
            }

            /**
			  Used for InitCap.
			*/
			function ChangeInitCase(obj)
            { 
              var name=obj.value;
              var spltval = name.split(" ") ;
              var temp_name = ""
             for(var i=0;i<spltval.length;i++)
             {
              var length= obj.value.length;
              var letter = spltval[i].substring(0,length-(length-1));
              var rest = spltval[i].substring(1,length);
              letter=letter.toUpperCase();
              rest=rest.toLowerCase();
              var  namenow= letter.concat(rest);
			  temp_name+= namenow+" ";
             }
			 
             obj.value= temp_name.substring(0,temp_name.length-1);
			}
			/**
			   Used to enable the Contact1 Other Alternate ID TextField when Contact1 Other AltID Type is	selected from the list item.
			   @Author - Gomathi.
			*/
			function enableOtherAltIdText(val)
			{
			if(val != "")
			{
				
				document.getElementById('contact1_oth_alt_id_no').disabled= false;
				document.getElementById('contact1_oth_alt_id_no').value="";
			}
			else
			{
				document.getElementById('contact1_oth_alt_id_no').value="";
				document.getElementById('contact1_oth_alt_id_no').disabled= true;
			}
		}

		
async function dla_interface(CalledFromFunction)
	{
		
		var nationalIdNo = document.getElementById('national_id_no').value;	
       	var patient_id = "";
		var dob="N";
		if(CalledFromFunction=='ChangePatDtls')
			patient_id = document.getElementById('patient_id').value;
		var url="../../eMP/jsp/DlaInterfaceMain.jsp?nationalIdNo="+nationalIdNo+"&CalledFromFunction="+CalledFromFunction+"&patient_id="+patient_id;
		var dialogHeight= "41.2" ;
		var dialogTop = "80" ;
		var dialogWidth	= "150" ;
		var status = "no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;

		var retVal = new String();
		retVal =await window.showModalDialog(url,arguments,features);

		if(retVal)
		{
			var elements=retVal.split("|");
			var deceasedYN=elements[16];
			var deceased_date=elements[17];	
			
			if(deceasedYN != "")
				document.getElementById("deceased_yn").value=deceasedYN;
			else
				document.getElementById("deceased_yn").value="N";			

			if(deceased_date != "")
				document.getElementById("deceased_date").value=deceased_date;
			else
				document.getElementById("deceased_date").value="";
			
			var flag=elements[10];	
			

			if(document.getElementById("first_name_oth_lang"))
			{
				document.getElementById("first_name_oth_lang").value=elements[0];// firstname is populating to first_name_oth_lang as the name will be in Thai		
			}
			if(document.getElementById("family_name_oth_lang"))
			{
				document.getElementById("family_name_oth_lang").value=elements[1];// surname is populating to family_name_oth_lang as the name will be in Thai
			}

			var gender = elements[2];

			if(gender == "1" || gender == "M")
			{
				document.getElementById("sex").selectedIndex=1;
			}
			else if(gender == "2" || gender == "F")
			{
				document.getElementById("sex").selectedIndex=2
			}
			else if(gender == "3" || gender == "U")
			{
				document.getElementById("sex").selectedIndex=3
			}

			document.getElementById("date_of_birth").value=elements[3];

			if(document.getElementById("addl_field3") != undefined)
			{
				document.getElementById("addl_field3").value=elements[4];
			}
			if(document.getElementById("addl_field4") != undefined)
			{					
				document.getElementById("addl_field4").value=elements[5];
			}

			document.getElementById("nationality_code").value=elements[6];			

			document.getElementById("national_id_no").value=elements[8];

			if(document.getElementById("r_addr_line1")) document.getElementById("r_addr_line1").value=elements[19];
			if(document.getElementById("r_addr_line2")) document.getElementById("r_addr_line2").value=elements[20];
			if(document.getElementById("r_addr_line3")) document.getElementById("r_addr_line3").value=elements[21];
			if(document.getElementById("r_addr_line4")) document.getElementById("r_addr_line4").value=elements[22];

			var image= elements[23];				

			var title_eng=elements[15];
			var title_thai=elements[18];

			if(document.getElementById("r_town_code"))
				document.getElementById("r_town_code").value=elements[12];
			if(document.getElementById("r_area_code"))
				document.getElementById("r_area_code").value=elements[13];
			if(document.getElementById("r_region_code"))
				document.getElementById("r_region_code").value=elements[14];
			if(document.getElementById("r_town"))
				document.getElementById("r_town").value=elements[23];
			if(document.getElementById("r_area"))
				document.getElementById("r_area").value=elements[24];
			if(document.getElementById("r_region"))
				document.getElementById("r_region").value=elements[25];
			if(document.getElementById("dla_image_yn"))
				document.getElementById("dla_image_yn").value=elements[26];
			if(document.getElementById("second_name_oth_lang"))
				document.getElementById("second_name_oth_lang").value=elements[27];
			dob=elements[28];
			if(dob=="Y")
			{
             document.getElementById("age_or_dob").checked=true;
			 document.getElementById("age_or_dob").onclick();
			}if(dob=="N"){
             document.getElementById("age_or_dob").checked=false;
			 document.getElementById("age_or_dob").onclick();
			}
			document.getElementById("name_prefix_oth_lang").selectedIndex=2;

			// If title is null then user has to enter the title explicitly.
			// If title is null then user has to enter the title explicitly.
			if(title_eng == "")
			{
				document.getElementById("name_prefix").selectedIndex=0;
				document.getElementById("name_prefix_oth_lang").selectedIndex=0;
			}
			else
			{
				document.getElementById("name_prefix").value=title_eng;
				document.getElementById("name_prefix_oth_lang").value=title_thai;
			}			

			 
			gotoNext(document.getElementById("date_of_birth"));
			putLocalLangPatientName();
			int_nationality_desc(elements[6]);
			document.getElementById("national_id_no1").onblur();			
		}		
	}





function int_nationality_desc(nat_id_code)
{
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr+=" process_id=\"22\" ";
	xmlStr+=" nat_id_code=\""+nat_id_code+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var url = "../../eMP/jsp/ServerValidationXML.jsp";
	xmlHttp.open("POST", url, false);
	xmlHttp.setRequestHeader("Content-type" ,"application/x-www-form-urlencoded");
	xmlHttp.send(xmlDoc);
	eval(xmlHttp.responseText);
}
	/* Added by lakshmanan for MO-CRF-20183.2 US002 start*/
function checkForEmpSrvNum(obj) { 

var pract_id=document.getElementById('loginUser').value
var empServNumCode=document.getElementById('alt_id1_type').value;  
var empservno=document.getElementById('alt_id1_no').value;
var family_link_no=document.getElementById('family_link_no').value;

	//if (family_link_no!="" && empservno!="") {
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH action=\"EmpServNo\" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open('POST','../../eMP/jsp/MPIntermediate.jsp?empServNumCode='+empServNumCode+'&empservno='+empservno+'&headId='+obj.value+'&pract_id='+pract_id+'&fieldName='+obj.name,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText=TrimStr(responseText); 
		if(responseText=="" || responseText=="null"){	 
		document.getElementById('emp_service_no').value='';	
		}
		else if(responseText!=""){ 
		document.getElementById('emp_service_no').value=responseText;
		}
}

