
/*
function search_Race(obj,target)
{
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var locale=document.forms[0].locale.value;
	var tit="";	

	if(target.name == 'race_code_desc')
	{
		tit=getLabel("Common.race.label","common");
		sql="SELECT race_code code, initcap(long_desc) description FROM mp_race_lang_vw WHERE language_id = '"+locale+"' and eff_status = 'E' and  upper(race_code) like upper(?) and upper(long_desc) like upper(?) ORDER BY 2";

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
		if(target.name == 'race_code_desc')
		{
			
		document.forms[0].race_code_desc.value= arr[0];	
	//	document.forms[0].ethnic_group.value='';
		}
	}
	else{
		
		target.value='';
		document.forms[0].race_code_desc.value='';	
		document.forms[0].ethnic_group.value='';
	}
}

*/ 

function CheckForNumber_l(Objval) 
{
		val = Objval.value;
		
	if ( trimCheck(val) && isNaN(val) == false && val >=0)
  		return true;
	else
  		if ( val.length > 0 ) {
  			alert(getMessage("NUM_ALLOWED","SM"));
  			Objval.select();
  			Objval.focus();
  			return false;
  			
  		}
}
function checkExpiry1(to)
{
	
    //if (isBeforeNow(to.value,"DMY",localeName) && to.value!="")
	/*Below line modified for this incident [IN:046596]*/
	var sys_dat = getCurrentDate("DMY",localeName);	 
	if(!isBefore(sys_dat,to.value,"DMY",localeName) && to.value!="")
    {
			msg = getMessage('ALT_ID_EXPIRED',"MP");
			if(to.name=="alt_id1_exp_date")
			msg = msg.replace("$",document.getElementById("alt_id1_desc").value)
			if(to.name=="alt_id2_exp_date")
			msg = msg.replace("$",document.getElementById("alt_id2_desc").value)
			if(to.name=="alt_id3_exp_date")
			msg = msg.replace("$",document.getElementById("alt_id3_desc").value)
			if(to.name=="alt_id4_exp_date")
			msg = msg.replace("$",document.getElementById("alt_id4_desc").value)
			alert(msg);			
			if(to.name=="alt_id1_exp_date")document.getElementById("alt_id1_exp_date").value=""; //this line added for the incident[46596]
    }
/*	var today1=new Date()
	var dd1=today1.getDate()
	var	mm1=today1.getMonth()+1
	var	yy1=today1.getYear()
	var fromdate=dd1+"/"+mm1+"/"+yy1
	var fromarray; var toarray;	 
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
	            msg = getMessage('ALT_ID_EXPIRED',"MP");
				if(to.name=="alt_id1_exp_date")
				msg = msg.replace("$",document.getElementById("alt_id1_desc").value)
				if(to.name=="alt_id2_exp_date")
				msg = msg.replace("$",document.getElementById("alt_id2_desc").value)
				if(to.name=="alt_id3_exp_date")
				msg = msg.replace("$",document.getElementById("alt_id3_desc").value)
				if(to.name=="alt_id4_exp_date")
				msg = msg.replace("$",document.getElementById("alt_id4_desc").value)
                alert(msg);
            }
	}    
	*/
 }


/* function dateCheck(Obj,varBodyFrame,varSubmitFrame)	
{
	var maxAge = document.forms[0].max_patient_age.value;
	var msg="";
	
	
		if(eval(varBodyFrame)+".document.getElementById('op_call')")
		{
			if(eval(varBodyFrame)+".document.getElementById('op_call')".value!=null)
				var op_call =  eval(varBodyFrame)+".document.getElementById('op_call')".value;
			if(op_call == "reg_pat" || op_call=="ae_reg_pat")
				varSubmitFrame = "parent.parent.frames[2]";
		}

		if ( (Obj == eval(varBodyFrame)+".document.getElementById('date_of_birth')") && (eval(varBodyFrame)+".document.getElementById('date_of_birth')".value != '') )
		{			
			var DOB = eval(varBodyFrame)+".document.getElementById('date_of_birth')".value
			
			if ( validDate(DOB,"DMY",localeName) == false) 	{							
					alert(getMessage("INVALID_DATE_FMT","SM"));
					eval(varBodyFrame)+".document.getElementById('date_of_birth')".focus();
			} else {							
//				if ( doDateCheckAlert(DOB,eval(varBodyFrame).document.getElementById("ServerDate").value) )
				if ( isBeforeNow(DOB,"DMY",localeName) ) {					
						sendToServer(1,varBodyFrame,varSubmitFrame);
				} else {
					alert(getMessage('DOB_GREATER',"MP"));
					Obj.focus();
				}
			}
		}
		else if ( Obj == eval(varBodyFrame)+".document.getElementById('b_days')" )
		{
			if ( Obj.value > 31 )
			{
				alert(getMessage('DAYS_GREATER_31',"MP"));
				//Obj.focus();
				Obj.value = "";
			}
			
			if(Obj.value > 0){
			if((eval(varBodyFrame)+".document.getElementById('b_age')".value > 0))
				{
					if(parseInt(eval(varBodyFrame)+".document.getElementById('b_age')".value) == parseInt(maxAge) ){						
						msg = getMessage('MAX_PATIENT_AGE','MP');
						msg = msg.replace("#",document.forms[0].max_patient_age.value);
						msg= msg+" "+maxAge+" "+ getLabel("Common.Years.label","common");
						alert(msg);
						Obj.focus();
						Obj.value = "";
					
					}
					else
					  sendToServer(2,varBodyFrame,varSubmitFrame);
				}else
					  sendToServer(2,varBodyFrame,varSubmitFrame);
			}
			
		}
		else if ( Obj == eval(varBodyFrame)+".document.getElementById('b_months')" )
		{			
			if (CheckForNumber_l(Obj) == true )
			{
				if ( Obj.value > 11 )
				{
				alert(getMessage('MONTH_GREATER_11',"MP"));
			//	Obj.focus();
				Obj.value = "";

				}

				if(Obj.value > 0){
					if(parseInt(eval(varBodyFrame)+".document.getElementById('b_age')".value) == parseInt(maxAge) ){ 							
						msg = getMessage('MAX_PATIENT_AGE','MP');
						msg = msg.replace("#",document.forms[0].max_patient_age.value);
						msg= msg+" "+maxAge+" "+ getLabel("Common.Years.label","common");
						alert(msg);
						Obj.focus();
						Obj.value = "";					
					}	
					else
						sendToServer(2,varBodyFrame,varSubmitFrame);
				}				
			}
		}
		else if ( Obj == eval(varBodyFrame)+".document.getElementById('b_age')" )
		{
					//		alert("Obj in 5 "+Obj.value)
			if (CheckForNumber_l(Obj) == true)
			{
				if ( Obj.value < 0)
				{
						alert(getMessage('AGE_LESS_ZERO',"MP"));
						//Obj.focus();
						Obj.value = "";
				}
				else if ( Obj.value == '')
				{
				Obj.value = 0;
				}
				else if (Obj.value > 0)
				{
					//alert("inside exeed"+Obj.value)
					//alert("maxAge"+maxAge)
				//msg=getMessage('MAX_PATIENT_AGE',"MP");
				//alert(getMessage('MAX_PATIENT_AGE',"MP"));
				///msg = msg.replace("#",document.forms[0].nat_id_prompt.value);
					if(parseInt(Obj.value) > parseInt(maxAge) )
					{
						msg = getMessage('MAX_PATIENT_AGE','MP');
						msg = msg.replace("#",document.forms[0].max_patient_age.value);
						msg= msg+" "+maxAge+" "+ getLabel("Common.Years.label","common");
						alert(msg);
						Obj.focus();
						Obj.value = "";
					}
					else if(parseInt(Obj.value) == parseInt(maxAge)){
						if(eval(varBodyFrame)+".document.getElementById('b_months')".value > 0  || eval(varBodyFrame)+".document.getElementById('b_days')".value > 0 ){
							msg = getMessage('MAX_PATIENT_AGE','MP');
							msg = msg.replace("#",document.forms[0].max_patient_age.value);
							msg= msg+" "+maxAge+" "+ getLabel("Common.Years.label","common");
							alert(msg);
							Obj.focus();
							Obj.value = "";
						}
						else
							sendToServer(2,varBodyFrame,varSubmitFrame);
					}
					else
						sendToServer(2,varBodyFrame,varSubmitFrame);
					//else
				//	{
					//	Obj.focus();
					//}
					
			    }	
				else
					return false;
					//Obj.value = "";
				    

			}
			else
				sendToServer(2,varBodyFrame,varSubmitFrame);
			}
		}
		*/

function dateCheck(Obj,varBodyFrame,varSubmitFrame)	
{
	var maxAge = document.forms[0].max_patient_age.value;
	var msg="";
	
	
		if(eval(varBodyFrame+".document.getElementById('op_call')"))
		{			
			if(eval(varBodyFrame+".document.getElementById('op_call')").value!=null)
			{
				var op_call =  eval(varBodyFrame+".document.getElementById('op_call')").value;
			}
			if(op_call == "reg_pat" || op_call=="ae_reg_pat")
				varSubmitFrame = "parent.parent.frames[2]";
		}

		if ( (Obj == eval(varBodyFrame+".document.getElementById('date_of_birth')")) && (eval(varBodyFrame+".document.getElementById('date_of_birth')").value != '') )
		{			
			var DOB = eval(varBodyFrame+".document.getElementById('date_of_birth')").value;
			if ( validDate(DOB,"DMY",localeName) == false) 	{				
					alert(getMessage("INVALID_DATE_FMT","SM"));
					Obj.value="";
					eval(varBodyFrame+".document.getElementById('date_of_birth')").focus();
			} else {							
//				if ( doDateCheckAlert(DOB,eval(varBodyFrame).document.getElementById("ServerDate").value) )
				if ( isBeforeNow(DOB,"DMY",localeName) ) {					
						sendToServer(1,varBodyFrame,varSubmitFrame);
				} else {
					alert(getMessage('DOB_GREATER',"MP"));
					Obj.value="";
					Obj.focus();
				}
			}
		}
		else if ( Obj == eval(varBodyFrame+".document.getElementById('b_days')") )
		{
			if ( Obj.value > 31 )
			{
				alert(getMessage('DAYS_GREATER_31',"MP"));
				//Obj.focus();
				Obj.value = "";
				Obj.focus();
			}
			
			if(Obj.value > 0){
			if((eval(varBodyFrame+".document.getElementById('b_age')").value > 0))
				{
					if(parseInt(eval(varBodyFrame+".document.getElementById('b_age')").value) == parseInt(maxAge) ){						
						msg = getMessage('MAX_PATIENT_AGE','MP');
						msg = msg.replace("#",document.forms[0].max_patient_age.value);
						msg= msg+" "+maxAge+" "+ getLabel("Common.Years.label","common");
						alert(msg);
						//Obj.focus();
						Obj.value = "";
						Obj.focus();
					
					}
					else
					  sendToServer(2,varBodyFrame,varSubmitFrame);
				}else
					  sendToServer(2,varBodyFrame,varSubmitFrame);
			}
			
		}
		else if ( Obj == eval(varBodyFrame+".document.getElementById('b_months')") )
		{
						
			if (CheckForNumber_l(Obj) == true )
			{
				if ( Obj.value > 11 )
				{
				alert(getMessage('MONTH_GREATER_11',"MP"));
			//	Obj.focus();
				Obj.value = "";
				Obj.focus();
				}

				if(Obj.value > 0){
					if(parseInt(eval(varBodyFrame+".document.getElementById('b_age')").value) == parseInt(maxAge) ){ 							
						msg = getMessage('MAX_PATIENT_AGE','MP');
						msg = msg.replace("#",document.forms[0].max_patient_age.value);
						msg= msg+" "+maxAge+" "+ getLabel("Common.Years.label","common");
						alert(msg);
						//Obj.focus();
						Obj.value = "";	
						Obj.focus();
					}	
					else
						sendToServer(2,varBodyFrame,varSubmitFrame);
				}				
			}
		}
		else if ( Obj == eval(varBodyFrame+".document.getElementById('b_age')") )
		{
					//		alert("Obj in 5 "+Obj.value)
			if (CheckForNumber_l(Obj) == true)
			{
				if ( Obj.value < 0)
				{
						alert(getMessage('AGE_LESS_ZERO',"MP"));
						//Obj.focus();
						Obj.value = "";
						Obj.focus();
				}
				else if ( Obj.value == '')
				{
				Obj.value = 0;
				}
				else if (Obj.value > 0)
				{
					//alert("inside exeed"+Obj.value)
					//alert("maxAge"+maxAge)
				//msg=getMessage('MAX_PATIENT_AGE',"MP");
				//alert(getMessage('MAX_PATIENT_AGE',"MP"));
				///msg = msg.replace("#",document.forms[0].nat_id_prompt.value);
					if(parseInt(Obj.value) > parseInt(maxAge) )
					{
						msg = getMessage('MAX_PATIENT_AGE','MP');
						msg = msg.replace("#",document.forms[0].max_patient_age.value);
						msg= msg+" "+maxAge+" "+ getLabel("Common.Years.label","common");
						alert(msg);
						//Obj.focus();
						Obj.value = "";
						Obj.focus();
					}
					else if(parseInt(Obj.value) == parseInt(maxAge)){
						if(eval(varBodyFrame+".document.getElementById('b_months')").value > 0  || eval(varBodyFrame+".document.getElementById('b_days')").value > 0 ){
							msg = getMessage('MAX_PATIENT_AGE','MP');
							msg = msg.replace("#",document.forms[0].max_patient_age.value);
							msg= msg+" "+maxAge+" "+ getLabel("Common.Years.label","common");
							alert(msg);
							//Obj.focus();
							Obj.value = "";
							Obj.focus();
						}
						else
							sendToServer(2,varBodyFrame,varSubmitFrame);
					}
					else
						sendToServer(2,varBodyFrame,varSubmitFrame);
					//else
				//	{
					//	Obj.focus();
					//}
					
			    }	
				else
					return false;
					//Obj.value = "";
				    

			}
			else
				sendToServer(2,varBodyFrame,varSubmitFrame);
			}
		}



function sendToServer(Val,bodyFrameRef,submitFrameRef) {
var HTMLVal = new String();
var op_call =  eval(varBodyFrame).document.getElementById("op_call").value;
var maxAge = document.forms[0].max_patient_age.value;

if (Val == 1)
{
	HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/natAltIdDOB.jsp'><input type='hidden' name='process_id' id='process_id' value='1'><input name='date_of_birth' id='date_of_birth' type='hidden' value='"+eval(bodyFrameRef).document.getElementById("date_of_birth").value+"'><input type='hidden'  name='bodyFrameRef' id='bodyFrameRef' value='"+bodyFrameRef+"'><input type='hidden'  name='op_call' id='op_call' value='"+op_call+"'><input type='hidden'  name='maxAge' id='maxAge' value='"+maxAge+"'></form></BODY></HTML>";
	//eval(submitFrameRef).document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	eval(submitFrameRef).document.write(HTMLVal);
	eval(submitFrameRef).document.form1.submit();
}

if ( Val == 2 )
{
	HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/natAltIdDOB.jsp'><input type='hidden' name='process_id' id='process_id' value='2'><input type='hidden' name='b_age' id='b_age' value='"+eval(bodyFrameRef).document.getElementById("b_age").value+"'><input type='hidden' name='b_months' id='b_months' value='"+eval(bodyFrameRef).document.getElementById("b_months").value+"'><input name='b_days' id='b_days' type='hidden' value='"+eval(bodyFrameRef).document.getElementById("b_days").value+"'><input type='hidden'  name='bodyFrameRef' id='bodyFrameRef' value='"+bodyFrameRef+"'><input type='hidden'  name='op_call' id='op_call' value='"+op_call+"'></form></BODY></HTML>";
	eval(submitFrameRef).document.write(HTMLVal);
	eval(submitFrameRef).document.form1.submit();
}

}

async function Modal_Contact_Details(obj)
{      
		var isAlternateAddressAppl = document.forms[0].isAlternateAddressAppl.value;//Added by Thamizh selvi on 30th Jan 2018 against ML-MMOH-CRF-0601
		var retVal =    new String();
		var dialogHeight= "90vh" ;
		var dialogWidth = "85vw" ;
		/*Modified by Thamizh selvi on 30th Jan 2018 against ML-MMOH-CRF-0601 Start*/
		if(isAlternateAddressAppl == "true")
			dialogWidth = "85vw" ;
		/*End*/
		var status = "no";
		var patient_id = document.forms[0].patient_id.value
		var concat_address_hidden=document.forms[0].concat_address_hidden.value;
		var readonly_yn = document.forms[0].readonly_yn.value;
		var op_call_check=document.forms[0].op_call_check.value
		
//document.forms().change_address.value 
		var concat_address_hidden=document.forms[0].addr1_type.value					+"^^"
		+document.forms[0].addr_line1.value						+"^^"
		+document.forms[0].addr_line2.value						+"^^"
		+document.forms[0].addr_line3.value						+"^^"
		+document.forms[0].addr_line4.value						+"^^"
		+document.forms[0].res_town_code.value			+"^^"
		+document.forms[0].res_area_code.value				+"^^"
		+document.forms[0].postal_code.value					+"^^"
		+document.forms[0].region_code.value					+"^^"
		+document.forms[0].country_code.value				+"^^"
		+document.forms[0].contact1_name.value				+"^^"
		+document.forms[0].invalid1_yn.value				+"^^"
		+document.forms[0].addr2_type.value					+"^^"
		+document.forms[0].mail_addr_line1.value			+"^^"
		+document.forms[0].mail_addr_line2.value			+"^^"
		+document.forms[0].mail_addr_line3.value			+"^^"
		+document.forms[0].mail_addr_line4.value			+"^^"
		+document.forms[0].mail_res_town_code.value	+"^^"
		+document.forms[0].mail_res_area_code.value	+"^^"
		+document.forms[0].mail_postal_code.value	    +"^^"
		+document.forms[0].mail_region_code.value		+"^^"
		+document.forms[0].mail_country_code.value+"^^"
		+document.forms[0].contact2_name.value		+"^^"
		+document.forms[0].invalid2_yn.value +"^^"
		+document.forms[0].contact1_no.value +"^^"
		+document.forms[0].contact2_no.value +"^^"
		+document.forms[0].email.value +"^^"
		+document.forms[0].change_address.value +"^^"
		+document.forms[0].res_town_desc.value +"^^"
		+document.forms[0].res_area_desc.value +"^^"
		+document.forms[0].region_desc.value +"^^"
		+document.forms[0].mail_res_town_desc.value +"^^"
		+document.forms[0].mail_res_area_desc.value +"^^"
		+document.forms[0].mail_region_desc.value  +"^^"
		+document.forms[0].country_desc.value  +"^^"
		+document.forms[0].mail_country_desc.value +"^^"
		+document.forms[0].r_postal_code_desc.value +"^^"
		+document.forms[0].m_postal_code_desc.value;
		
		/*Added by Thamizh selvi on 30th Jan 2018 against ML-MMOH-CRF-0601 Start*/
		if(isAlternateAddressAppl == "true"){
			concat_address_hidden = concat_address_hidden+"^^"
									+document.forms[0].alt_addr_line1.value+"^^"
									+document.forms[0].alt_addr_line2.value+"^^"
									+document.forms[0].alt_addr_line3.value+"^^"
									+document.forms[0].alt_addr_line4.value+"^^"
									+document.forms[0].alt_town_code.value	+"^^"
									+document.forms[0].alt_area_code.value	+"^^"
									+document.forms[0].alt_postal_code.value +"^^"
									+document.forms[0].alt_region_code.value +"^^"
									+document.forms[0].alt_country_code.value +"^^"
									+document.forms[0].alt_town_desc.value +"^^"
									+document.forms[0].alt_area_desc.value +"^^"
									+document.forms[0].alt_postal_desc.value +"^^"
									+document.forms[0].alt_region_desc.value +"^^"
									+document.forms[0].alt_country_desc.value ;
		}/*End*/

		checkVVC();
	//var isVCEnbl = document.getElementById("isVirtualCons").value; //Added by Ajay Hatwate for ML-MMOH-CRF-1930
	//document.forms[0].isVCEnbl1.value = document.getElementById("isVCEnbl").value; //Added by Ajay Hatwate for ML-MMOH-CRF-1930
	//document.forms[0].isVC1.value = isVCEnbl;
		/*Added by Ajay Hatwate for ML-MMOH-CRF-1930 */
		if(document.forms[0].isVirtualConsultation.value == 'true'){
			concat_address_hidden = concat_address_hidden +"^^"+document.forms[0].isVisitVirtualCons.value+"^^"
									+document.forms[0].txtNxtOfKin.value+"^^"+document.forms[0].patCountryCode.value+"^^"+document.forms[0].patTelCode.value+"^^"+document.forms[0].teleCodeHidden.value;
		}
		/* End of ML-MMOH-CRF-1930 */
		var arguments	=concat_address_hidden;
		var calling_from = "";
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

		retVal = await window.showModalDialog( "../../eMP/jsp/ContactDetailsFrame.jsp?patient_id="+patient_id+"&readonly_yn="+readonly_yn+"&op_call_check="+op_call_check,arguments,features);

		if(retVal != null)
		{
			document.forms[0].concat_address_hidden.value=retVal;
			var arr_concat_vals=retVal.split("^^");


			document.forms[0].addr1_type.value					= arr_concat_vals[0];//  
			document.forms[0].addr_line1.value						= arr_concat_vals[1]; 
			document.forms[0].addr_line2.value						= arr_concat_vals[2]; 
			document.forms[0].addr_line3.value						= arr_concat_vals[3]; 
			document.forms[0].addr_line4.value						= arr_concat_vals[4]; 
			document.forms[0].res_town_code.value			= arr_concat_vals[5]; //
			document.forms[0].res_area_code.value				= arr_concat_vals[6]; //
			document.forms[0].postal_code.value					= arr_concat_vals[7]; //
			document.forms[0].region_code.value					= arr_concat_vals[8]; //
			document.forms[0].country_code.value				= arr_concat_vals[9]; //
			document.forms[0].contact1_name.value			= arr_concat_vals[10]; //
			document.forms[0].invalid1_yn.value				= arr_concat_vals[11]; //

			document.forms[0].addr2_type.value					= arr_concat_vals[12]; //
			document.forms[0].mail_addr_line1.value			= arr_concat_vals[13];
			document.forms[0].mail_addr_line2.value			= arr_concat_vals[14];
			document.forms[0].mail_addr_line3.value			= arr_concat_vals[15];
			document.forms[0].mail_addr_line4.value			= arr_concat_vals[16]; //
			document.forms[0].mail_res_town_code.value	= arr_concat_vals[17]; //
			document.forms[0].mail_res_area_code.value	= arr_concat_vals[18]; //
			document.forms[0].mail_postal_code.value	    = arr_concat_vals[19]; //

			document.forms[0].mail_region_code.value		=  arr_concat_vals[20]; //
			document.forms[0].mail_country_code.value		=  arr_concat_vals[21]; //

			document.forms[0].contact2_name.value		=  arr_concat_vals[22]; //
			document.forms[0].invalid2_yn.value		=  arr_concat_vals[23]; //

			document.forms[0].contact1_no.value		=  arr_concat_vals[24];
			document.forms[0].contact2_no.value		=  arr_concat_vals[25];
			document.forms[0].email.value		=  arr_concat_vals[26];
			document.forms[0].change_address.value  = 'Y';

			document.forms[0].res_town_desc.value =arr_concat_vals[27];
		   document.forms[0].res_area_desc.value =arr_concat_vals[28];
		   document.forms[0].region_desc.value =arr_concat_vals[29];

		   document.forms[0].mail_res_town_desc.value =arr_concat_vals[30];
		   document.forms[0].mail_res_area_desc.value =arr_concat_vals[31];
		   document.forms[0].mail_region_desc.value =arr_concat_vals[32];
			
		   document.forms[0].country_desc.value=arr_concat_vals[33];
		   document.forms[0].mail_country_desc.value=arr_concat_vals[34];
		   document.forms[0].r_postal_code_desc.value=arr_concat_vals[35];
		   document.forms[0].m_postal_code_desc.value=arr_concat_vals[36];

			/*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
			if(isAlternateAddressAppl == "true"){
				document.forms[0].alt_addr_line1.value		= arr_concat_vals[37];
				document.forms[0].alt_addr_line2.value		= arr_concat_vals[38];
				document.forms[0].alt_addr_line3.value		= arr_concat_vals[39];
				document.forms[0].alt_addr_line4.value		= arr_concat_vals[40];
				document.forms[0].alt_town_code.value		= arr_concat_vals[41];
				document.forms[0].alt_area_code.value		= arr_concat_vals[42];
				document.forms[0].alt_postal_code.value		= arr_concat_vals[43];
				document.forms[0].alt_region_code.value		= arr_concat_vals[44];
				document.forms[0].alt_country_code.value	= arr_concat_vals[45];
				document.forms[0].alt_town_desc.value		= arr_concat_vals[46];
				document.forms[0].alt_area_desc.value		= arr_concat_vals[47];
				document.forms[0].alt_postal_desc.value		= arr_concat_vals[48];
				document.forms[0].alt_region_desc.value		= arr_concat_vals[49];
				document.forms[0].alt_country_desc.value	= arr_concat_vals[50];
				//Added for ML-MMOH-CRF-1930
				if(document.forms[0].isVirtualConsultation.value == 'true'){
				document.forms[0].teleCodeHidden.value	= arr_concat_vals[52];
				document.forms[0].txtNxtOfKin.value	= arr_concat_vals[51];
				document.forms[0].patCountryCode.value	= arr_concat_vals[53];
				document.forms[0].patTelCode.value	= arr_concat_vals[54];
				//alert(document.forms[0].patCountryCode.value + ' return1 country val ' + document.forms[0].patTelCode.value);
				}
			}else{
				if(document.forms[0].isVirtualConsultation.value == 'true'){
				document.forms[0].teleCodeHidden.value	= arr_concat_vals[38];
				document.forms[0].txtNxtOfKin.value	= arr_concat_vals[37];
				document.forms[0].patCountryCode.value	= arr_concat_vals[39];
				document.forms[0].patTelCode.value	= arr_concat_vals[40];
				//alert(document.forms[0].patCountryCode.value + ' return2 country val ' + document.forms[0].patTelCode.value);
			}/*End*/
	}
}
}
function checkVVC(){
	var obj = document.getElementById("visit_type_short_desc");
	if(document.getElementById("isVirtualCons")){
		var fvc = obj.value.split("~");
		var xmlDoc=""
		var xmlHttp = new XMLHttpRequest()
		var fac_id = document.getElementById("facilityid").value;
		xmlStr = "<root><SEARCH visit_type_code=\""+fvc[0]+"\" facility_id=\""+fac_id+"\" action='isVirtualVisit' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eOP/jsp/OPIntermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText = xmlHttp.responseText
		var response = trimString(xmlHttp.responseText);
		document.forms[0].isVisitVirtualCons.value = response;
		document.getElementById("isVCEnbl").value		= response;
		if(response =='E'){
			document.getElementById("patgif").style.visibility = 'visible';
		}else{
			document.getElementById("patgif").style.visibility = 'hidden';
		}
	}
}

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

function assignSuffixValue()
{
	if(document.getElementById("name_suffix1") != null)
	{
		document.getElementById("name_suffix").value = document.getElementById("name_suffix1").value;
	}
}

function checkPrefix()
{
	var prefix_value = '';
	if(document.getElementById("name_prefix1") != null)
	{
		prefix_value = document.getElementById("name_prefix1").value;
		document.getElementById("name_prefix").value = document.getElementById("name_prefix1").value;
	}
	
	var gender = document.getElementById("sex").value;
	if(prefix_value != '' && gender != '')
	{
		var prefix_check = "Y";
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH prefix_value=\""+prefix_value+"\" gender=\""+gender+"\" /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eMP/jsp/natAltIDComponentPrefixCheck.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		if(eval(responseText)==1)
		{
			//alert(getMessage("SEX_MIS_PREFIX","MP"));

			var msg = getMessage("PATIENT_SEX_MISMATCH",'MP');
			if(localeName=='en')
			{
			msg = msg.replace('$',document.getElementById("name_prefix_prompt").value);
			}else
			{
			msg = msg.replace('$',document.getElementById("name_prefix_oth_prompt").value);
			}

			alert(msg);
			document.getElementById("name_prefix1").value="";
		}
	}
}
function enabledFields(obj)
{   /*Below line mofified for this incident  [IN:046630]*/
    
	if (obj.name=="alt_id1_no" && document.forms[0].alt_id1_no && document.forms[0].alt_id1_no.value!="" &&  document.forms[0].alt_id1_exp_date!=null) 
	{
		document.forms[0].alt_id1_exp_date.disabled = false;
		document.getElementById("alt_id_exp_dt1").style.pointerEvents = "auto";
	
	}else if (obj.name=="alt_id1_no" && document.forms[0].alt_id1_no && document.forms[0].alt_id1_no.value=="" &&  document.forms[0].alt_id1_exp_date!=null) 
	{  
    	document.forms[0].alt_id1_exp_date.value="";
		document.forms[0].alt_id1_exp_date.disabled = true;
		document.getElementById("alt_id_exp_dt1").style.pointerEvents = "none";
	
	}
	else if (obj.name=="alt_id2_no"  && document.forms[0].alt_id2_no && document.forms[0].alt_id2_no.value!="" &&  document.forms[0].alt_id2_exp_date!=null)
	{
		document.forms[0].alt_id2_exp_date.disabled = false;
		document.getElementById("alt_id_exp_dt2").style.pointerEvents = "auto";
	}else if (obj.name=="alt_id2_no"  && document.forms[0].alt_id2_no && document.forms[0].alt_id2_no.value=="" &&  document.forms[0].alt_id2_exp_date!=null)
	{   
	    document.forms[0].alt_id2_exp_date.value="";
		document.forms[0].alt_id2_exp_date.disabled = true;
		document.getElementById("alt_id_exp_dt2").style.pointerEvents = "none";
	}
	else if (obj.name=="alt_id3_no" && document.forms[0].alt_id3_no && document.forms[0].alt_id3_no.value!=""  && document.forms[0].alt_id3_exp_date!=null) 
	{
		
		document.forms[0].alt_id3_exp_date.disabled = false;
		document.getElementById("alt_id_exp_dt3").style.pointerEvents = "auto";
		
	}
	else if (obj.name=="alt_id3_no" && document.forms[0].alt_id3_no && document.forms[0].alt_id3_no.value==""  && document.forms[0].alt_id3_exp_date!=null) 
	{
		document.forms[0].alt_id3_exp_date.value="";
		document.forms[0].alt_id3_exp_date.disabled = true;
		document.getElementById("alt_id_exp_dt3").style.pointerEvents = "none";
		
	}
	else if (obj.name=="alt_id4_no" && document.forms[0].alt_id4_no && document.forms[0].alt_id4_no.value!="" && document.forms[0].alt_id4_exp_date!=null) 
	{
		document.forms[0].alt_id4_exp_date.disabled = false;
		document.getElementById("alt_id_exp_dt4").style.pointerEvents = "auto";
	}
	else if (obj.name=="alt_id4_no" && document.forms[0].alt_id4_no && document.forms[0].alt_id4_no.value=="" && document.forms[0].alt_id4_exp_date!=null) 
	{
	    document.forms[0].alt_id4_exp_date.value="";
		document.forms[0].alt_id4_exp_date.disabled = true;
		document.getElementById("alt_id_exp_dt4").style.pointerEvents = "none";
		//End this  incident [46630]
	}
	else if (obj.name=="other_alt_type") 
	{
		if(document.forms[0].other_alt_type.selectedIndex!=0)
		{
			document.forms[0].other_alt_Id.disabled = false;
			document.forms[0].other_alt_Id.value="";
		}
		else
		{
			document.forms[0].other_alt_Id.disabled = true;
			document.forms[0].other_alt_Id.value="";
		}
	}

}
// End of the function for enabling the fields


// Function for validating ID's and populate the values
function validateID(obj,nat_id_check_digit_id)
{ 
	var id = new String();
	var step ="";
	var oth_id_type ="";
	if (obj.name=="national_id_no")
	{
			if ( !CheckSplCharsNatID(obj) )
			{
				return false;
			}
			if ( (nat_id_check_digit_id=='M11') && ( (ind = obj.value.indexOf('X')) != -1) )
			{
				if (ind < 12)           // X can be entered only at 13th position
				{
					msg = getMessage('INVALID_NAT_ID','MP');
					msg = msg.replace("#",document.forms[0].nat_id_prompt.value);
					//obj.select();
					obj.value = '';
					obj.focus();
					alert(msg);
					return false;
				}
			}
			if(obj.value==''){
				if(document.getElementById("alt_id1_no"))
					document.getElementById("alt_id1_no").value='';
				if(document.getElementById("alt_id1_exp_date"))
					document.getElementById("alt_id1_exp_date").value='';
				if(document.getElementById("name_prefix"))
					document.getElementById("name_prefix").value='';
				if(document.getElementById("first_name"))
					document.getElementById("first_name").value='';
				if(document.getElementById("second_name"))
					document.getElementById("second_name").value='';
				if(document.getElementById("third_name"))
					document.getElementById("third_name").value='';
				if(document.getElementById("family_name"))
					document.getElementById("family_name").value='';
				if(document.getElementById("name_suffix"))
					document.getElementById("name_suffix").value='';
				if(document.getElementById("sex"))
					document.getElementById("sex").value='';
				if(document.getElementById("b_age"))
					document.getElementById("b_age").value='';
				if(document.getElementById("b_months"))
					document.getElementById("b_months").value='';
				if(document.getElementById("b_days"))
					document.getElementById("b_days").value='';
				if(document.getElementById("date_of_birth"))
					document.getElementById("date_of_birth").value='';
				if(document.getElementById("nationality_desc"))
					document.getElementById("nationality_desc").value='';
				if(document.getElementById("nationality_code1"))
					document.getElementById("nationality_code1").value='';
				if(document.getElementById("race_code"))
					document.getElementById("race_code").value='';
				if(document.getElementById("race_desc"))
					document.getElementById("race_desc").value='';
				if(document.forms[0].addr_line1)
					document.forms[0].addr_line1.value='';
				if(document.forms[0].addr_line2)
					document.forms[0].addr_line2.value='';
				if(document.forms[0].addr_line3)
					document.forms[0].addr_line3.value='';
				if(document.forms[0].addr_line4)
					document.forms[0].addr_line4.value='';
					
				if(document.forms[0].res_town_code)
					document.forms[0].res_town_code.value='';
				if(document.forms[0].res_town_desc)
					document.forms[0].res_town_desc.value='';
				if(document.forms[0].res_area_code)
					document.forms[0].res_area_code.value='';
				if(document.forms[0].res_area_desc)
					document.forms[0].res_area_desc.value='';
				if(document.forms[0].postal_code)
					document.forms[0].postal_code.value='';
				if(document.forms[0].r_postal_code_desc)
					document.forms[0].r_postal_code_desc.value='';
				if(document.forms[0].region_code)
					document.forms[0].region_code.value='';
				if(document.forms[0].region_desc)
					document.forms[0].region_desc.value='';
				if(document.forms[0].country_code)
					document.forms[0].country_code.value='';
				if(document.forms[0].country_desc)
					document.forms[0].country_desc.value='';
					putPatientName('');
			}
	}
	if(document.forms[0].other_alt_type)
		oth_id_type=document.forms[0].other_alt_type.value;

	var alert_reqd_yn = document.forms[0].alert_reqd_yn.value;
	id = trimString(obj.value);
	if (obj.name=="national_id_no")
		step ="N";
	else if (obj.name=="alt_id1_no") 
		step ="A1";
	else if (obj.name=="alt_id2_no") 
		step ="A2";
	else if (obj.name=="alt_id3_no") 
		step ="A3";
	else if (obj.name=="alt_id4_no") 
		step ="A4";
	else if (obj.name=="other_alt_Id") 
		step ="A5";
	
	var nat_id_no = "";	
	if (obj.value != null && obj.value != '') 
		nat_id_no = obj.value;

	if(id.length != 0)
	{
		var ifCondition = 'forNatAltOthid';
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest() 
		xmlStr ="<root><SEARCH id=\""+id+"\" alert_reqd_yn=\""+alert_reqd_yn+"\" oth_id_type=\""+oth_id_type+"\" step=\""+step+"\" nat_id_no=\""+nat_id_no+"\"  ifCondition=\""+ifCondition+"\"/></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eMP/jsp/natAltIDComponentValues.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText)
		if(document.forms[0].patient_id.value !='')
		{
			validatePatient(document.forms[0].patient_id);
		}else{  //for smart card

			if(document.getElementById("txtSmartcard_path").value!=''){
				if(document.getElementById("txtSmartcard_dup").value=="D"){
				}else{
					document.getElementById("txtSmartcard_dup").value="1";	
				}
				
			}
			
		}// for smart card
	}
	/*else{ 
		if(document.forms[0].national_id_no && document.forms[0].national_id_no.value ==''){
			if(document.forms[0].alt_id1_no && document.forms[0].alt_id1_no.value ==''){
				if(document.forms[0].alt_id2_no && document.forms[0].alt_id2_no.value ==''){
					if(document.forms[0].alt_id3_no && document.forms[0].alt_id3_no.value ==''){
						if(document.forms[0].alt_id4_no && document.forms[0].alt_id4_no.value ==''){
							clearAll();	
						}
					}
				}
			}
		}
		
	}*/
}
// End of the function for validating the ID's and populating the fields

function populateDetail(filedname, details, addresses,objt)
{
  
	  if (details == "DECEASED"|| details == "SUSPENDED"|| details == "INACTIVE")
	  {
			eval("document.forms[0]."+objt+".value=''");
			eval("document.forms[0]."+objt+".focus()")
	  }
	  else{
					
		var arr = new Array();
		arr = details.split("||");
		if (arr[0]=="NAT_ID_VALUES")
			{
				// Assign the values to the fields	
				document.forms[0].date_of_birth.value = arr[1];
				document.forms[0].b_age.value = arr[2];
				document.forms[0].b_months.value = arr[3];
				document.forms[0].b_days.value = arr[4];
				document.forms[0].sex.value = arr[5];
 				if(document.forms[0].Birth_place_code!=null)
				document.forms[0].Birth_place_code.value = arr[6];
				if(document.forms[0].birth_place!=null)
				document.forms[0].birth_place.value = arr[7];
			}	  
		  else
		  {
				if(document.forms[0].patient_id)
				document.forms[0].patient_id.value = arr[0];
				if(document.forms[0].patient_name)
				document.forms[0].patient_name.value = arr[1];
				if(document.forms[0].national_id_no)
				document.forms[0].national_id_no.value = arr[2];
				
				if(document.forms[0].alt_id1_no)
				document.forms[0].alt_id1_no.value = arr[3];
				
				if(document.forms[0].alt_id2_no)
				document.forms[0].alt_id2_no.value = arr[4];
				
				if(document.forms[0].alt_id3_no)
				document.forms[0].alt_id3_no.value = arr[5];
			
				if(document.forms[0].alt_id4_no)
				document.forms[0].alt_id4_no.value = arr[6];
			
				if(document.forms[0].name_prefix)
				document.forms[0].name_prefix.value = arr[7];
			
				if(document.forms[0].first_name)
				document.forms[0].first_name.value = arr[8];
	
				if(document.forms[0].second_name)
				document.forms[0].second_name.value = arr[9];
			
				if(document.forms[0].third_name)
				document.forms[0].third_name.value = arr[10];
	
				if(document.forms[0].family_name)
				document.forms[0].family_name.value = arr[11];
	
				if(document.forms[0].name_suffix)
				document.forms[0].name_suffix.value = arr[12];

				if(document.forms[0].gender_obj)
				  {
					document.forms[0].gender_obj.value = arr[13];
					document.forms[0].gender_obj.disabled = true;
				}
				if(document.forms[0].b_days)
				document.forms[0].b_days.value = arr[25];
	
				if(document.forms[0].b_months)
				document.forms[0].b_months.value = arr[24];
	
				if(document.forms[0].b_age)
				document.forms[0].b_age.value = arr[23];
	
				if(document.forms[0].date_of_birth)
				document.forms[0].date_of_birth.value = arr[14];
	
				if(document.forms[0].contact1_no)
				document.forms[0].contact1_no.value = arr[15];
	
				if(document.forms[0].contact2_no)
				document.forms[0].contact2_no.value = arr[16];
	
				if(document.forms[0].email_id)
				document.forms[0].email_id.value = arr[17];
	
				if(document.forms[0].nationality)
				document.forms[0].nationality.value = arr[18];
		 }
		}
	}

function CheckSplCharsNatID(Obj){
		var nat_id_accept_alphanumeric_yn = document.forms[0].nat_id_accept_alphanumeric_yn.value;
        var str = Obj.value;
        var specCharsExist = true;

		if(nat_id_accept_alphanumeric_yn=="Y")
			strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-';
		else
			strCheck = '0123456789X';
		
        for (i=0;i<str.length;i++){
            if (strCheck.indexOf(str.charAt(i)) == -1) 
			{
				alert(getMessage("NAT_ID_SPL_NOT_ALLOWED",'MP'));
				Obj.value = '';
				Obj.focus();
				return false;  
			}
        }
        return specCharsExist;
}
function CheckForCharsNatID(event){
    var strCheck = '0123456789X';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

function CheckForAlphaCharsNatID(event){

	//alert("Entering here");

	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-';
	
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}



