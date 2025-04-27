var outcomemessage = "";
var region		= '';
var regionval	= '';
var area		= '';
var areaval		= '';
var outcomeValue= '';
var raceVal     = '';
var relgnVal	= '';
var bodyFrame	= '';
var submitFrame	= '';
var op_call	= '';    
function ReadDF1_onclick(Calledfrom,inst,subFrame,opCall)
{


	if(document.forms[0].txtSmartcard_path.value!=''){
		
		
		if(inst=='NC' && Calledfrom=='C' && document.forms[0].operation.value=='modify'){
			// no action on change patient details
			if (document.forms[0].txtSmart_fn_name.value=='02'){
				ReadSmartCard_02('CP','CP',document.forms[0].txtSmartcard_path.value,subFrame,opCall);
			}else if (document.forms[0].txtSmart_fn_name.value=='03'){
				ReadSmartCard_03('CP','CP',document.forms[0].txtSmartcard_path.value,subFrame,opCall);
			}else if (document.forms[0].txtSmart_fn_name.value=='04'){
				ReadSmartCard_04('CP','CP',document.forms[0].txtSmartcard_path.value,subFrame,opCall);
			}else if (document.forms[0].txtSmart_fn_name.value=='05'){
				ReadSmartCard_05('CP','CP',document.forms[0].txtSmartcard_path.value,subFrame,opCall);
			}
			else if (document.forms[0].txtSmart_fn_name.value=='06'){
				ReadSmartCard_06('CP','CP',document.forms[0].txtSmartcard_path.value,subFrame,opCall);
			}
		}else{
			
			if(opCall=='OA'){
				if(document.forms[0].national_id_no.disabled){
					// no action on book appt when teh flow is from create booking of wiat list
				}else{
					if (document.forms[0].txtSmart_fn_name.value=='01'){
						ReadSmartCard_01(Calledfrom,inst,document.forms[0].txtSmartcard_path.value,subFrame,opCall);
					}else if (document.forms[0].txtSmart_fn_name.value=='02'){
						ReadSmartCard_02(Calledfrom,inst,document.forms[0].txtSmartcard_path.value,subFrame,opCall);
					}else if (document.forms[0].txtSmart_fn_name.value=='03'){
						ReadSmartCard_03(Calledfrom,inst,document.forms[0].txtSmartcard_path.value,subFrame,opCall);
					}else if (document.forms[0].txtSmart_fn_name.value=='04'){
						ReadSmartCard_04(Calledfrom,inst,document.forms[0].txtSmartcard_path.value,subFrame,opCall);
					}else if (document.forms[0].txtSmart_fn_name.value=='05'){
						ReadSmartCard_05(Calledfrom,inst,document.forms[0].txtSmartcard_path.value,subFrame,opCall);
					}
					else if (document.forms[0].txtSmart_fn_name.value=='06'){
						ReadSmartCard_06(Calledfrom,inst,document.forms[0].txtSmartcard_path.value,subFrame,opCall);
					}
					else{
						ReadSmartCard(Calledfrom,inst,document.forms[0].txtSmartcard_path.value,subFrame,opCall);
					}
				}
				
			}else{
				if (document.forms[0].txtSmart_fn_name.value=='01'){
					ReadSmartCard_01(Calledfrom,inst,document.forms[0].txtSmartcard_path.value,subFrame,opCall);
				}else if (document.forms[0].txtSmart_fn_name.value=='02'){
					ReadSmartCard_02(Calledfrom,inst,document.forms[0].txtSmartcard_path.value,subFrame,opCall);
				}else if (document.forms[0].txtSmart_fn_name.value=='03'){
					ReadSmartCard_03(Calledfrom,inst,document.forms[0].txtSmartcard_path.value,subFrame,opCall);
				}else if (document.forms[0].txtSmart_fn_name.value=='04'){
					ReadSmartCard_04(Calledfrom,inst,document.forms[0].txtSmartcard_path.value,subFrame,opCall);
				}else if (document.forms[0].txtSmart_fn_name.value=='05'){
					ReadSmartCard_05(Calledfrom,inst,document.forms[0].txtSmartcard_path.value,subFrame,opCall);
				}
				else if (document.forms[0].txtSmart_fn_name.value=='06'){
					ReadSmartCard_06(Calledfrom,inst,document.forms[0].txtSmartcard_path.value,subFrame,opCall);
				}
				else{
					ReadSmartCard(Calledfrom,inst,document.forms[0].txtSmartcard_path.value,subFrame,opCall);
				}
			}
		}
	}else{
		if(subFrame!='' && subFrame!=null && subFrame!='undefined') {
			submitFrame = subFrame;
		}
		bodyFrame = Calledfrom;
		op_call = opCall;
		if(inst == 'NC' || inst == 'IC')
		{
			if(Calledfrom=='P')
			{
				document.PatRegForm.national_id_no.value='';
			}
			else if(Calledfrom=='E')
			{
				document.Emergency_Regn.national_id_no.value='';
			}
			else if(Calledfrom=='R')
			{
				document.Rapid_Regn.national_id_no.value='';
			}
			else if(Calledfrom=='C')
			{
				document.ChangePatDtlForm.national_id_no.value='';
			} else if(inst == 'IC') {
				document.getElementById('national_id_no').value = '';
			}

			setTimeout("ReadDF2_onclick('"+Calledfrom+"','"+inst+"')",1000);
		}
	}
}

function ReadDF2_onclick(Calledfrom,inst,subFrame,opCall){
	if(document.forms[0].txtSmartcard_path.value!=''){
		//setTimeout("ReadDermalog('"+Calledfrom+"','"+inst+"')",1000);
		if (document.forms[0].txtSmart_fn_name.value=='01'){
			ReadSmartCard_01(Calledfrom,inst,document.forms[0].txtSmartcard_path.value,subFrame,opCall);
		}else if (document.forms[0].txtSmart_fn_name.value=='02'){
			ReadSmartCard_02(Calledfrom,inst,document.forms[0].txtSmartcard_path.value,'','N');
		}else if (document.forms[0].txtSmart_fn_name.value=='03'){
			ReadSmartCard_03(Calledfrom,inst,document.forms[0].txtSmartcard_path.value,'','N');
		}else if (document.forms[0].txtSmart_fn_name.value=='04'){
			ReadSmartCard_04(Calledfrom,inst,document.forms[0].txtSmartcard_path.value,'','N');
		}else if (document.forms[0].txtSmart_fn_name.value=='05'){
			ReadSmartCard_05(Calledfrom,inst,document.forms[0].txtSmartcard_path.value,'','N');
		}else if (document.forms[0].txtSmart_fn_name.value=='06'){
			ReadSmartCard_06(Calledfrom,inst,document.forms[0].txtSmartcard_path.value,'','N');
		}
		else{
			ReadSmartCard(Calledfrom,'SR',document.forms[0].txtSmartcard_path.value);
		}
	}else{
		var postal_code = '';
		var continueYN = true;
		if(Calledfrom=='P')
		{
			var thisForm = document.PatRegForm
		}
		else if(Calledfrom=='E')
		{
			var thisForm = document.Emergency_Regn
		}
		else if(Calledfrom=='R')
		{
			var thisForm = document.Rapid_Regn
		}
		else if(Calledfrom=='C')
		{
			var thisForm = document.ChangePatDtlForm
		}
		else if(Calledfrom=='X')
		{
			//var thisForm = document.Patient_Search_Form
			var thisForm = document.Advnc_Patient_Search_Form
		}
		else if(Calledfrom=='XE')
		{
			var thisForm = document.ae_patient_form
		}
		else if(Calledfrom=='CC') {
			var thisForm = document.all
		} else if(inst == 'IC') {
			var thisForm = document.all
		}
		var SekureX;
		try{
		 //SekureX= new ActiveXObject("SekureActiveX.SekureX")
		 SekureX= "";
		}catch(exception)
		{
			if(exception.description=="Automation server can't create object"){
				//alert('Please check environment and install necessary Software.');
			}else{
				alert(exception.description);
			}		
			return;	
		}
		//SekureX= new ActiveXObject("SekureActiveX.SekureX")
		var CardStatus=-8
		
		var ComPort=2
		
		//var LicenseKey="C125FEA3-AEDC-444D-85C6-42C33611031"
		var LicenseKey="";
		
		var DepPath="C:\\Tricubes";
		try
		{
			SekureX.SetDependentPath(DepPath)
			var Key=LicenseKey
			SekureX.LicenseKey=Key
			var ret = SekureX.Connect(ComPort);
			if (ret == 1) {
				alert ("Device is not connected.  Please check the device");
				return;
			}
			else
			{
				GetJpn(Calledfrom);
				var ret = SekureX.DisConnect(ComPort);
			}
		}
		catch(exception)
		{
			if(outcomemessage != "") alert(outcomemessage);
		}

		function GetJpn(Calledfrom)
		{
		
			try
			{
				//var JPN = new ActiveXObject("SekureActiveX.JPN");
				var JPN ="";
				var Ret = JPN.Read	
				if (Ret == 0 && Calledfrom == 'XE')
				{
					var str=trimString(JPN.szID_No);
					str=str.substring(0,12)	;
					if(str != null)
					{
						if(str.length<12)
						{
							var  dig =16-str.length ;
							for(var i=0;i<dig;++i)
							{ 
								str =str+"0"; 
							}
						}
					
					}
					thisForm.National_Id_No.value = str;
				}
				else if (Ret == 0 && Calledfrom == 'X')
				{
					var str=trimString(JPN.szID_No);
					str=str.substring(0,12)	;
					if(str != null)
					{
						if(str.length<12)
						{
							var  dig =16-str.length ;
							for(var i=0;i<dig;++i)
							{ 
								str =str+"0"; 
							}
						}
					
					}				
					thisForm.National_Id_No.value = str;
				}
				else if (Ret == 0 && Calledfrom == 'CC')
				{
					var str=trimString(JPN.szID_No);
					str=str.substring(0,12)	;
					if(str != null)
					{
						if(str.length<12)
						{
							var  dig =16-str.length ;
							for(var i=0;i<dig;++i)
							{ 
								str =str+"0"; 
							}
						}
					
					}
					thisForm.national_id_no.value = str;
				}	
				else if(Ret == 0 && Calledfrom != 'X')
				{
					if(thisForm.family_name != null) 
					{
						var fam_name  =  JPN.szOName;
						fam_name  =  trimString(fam_name) ;
						thisForm.family_name.value = fam_name.substring(0,40);
						putPatientName(thisForm.family_name)
					}
					var str=trimString(JPN.szID_No);
					str=str.substring(0,12)	;
					if(str.length<12)
					{
						var  dig =16-str.length ;
						for(var i=0;i<dig;++i)
						{ 
							str =str+"0"; 
						}
					}
					thisForm.national_id_no.value = str;
					var sex = trimString(JPN.szGender);
					if(sex == 'L') thisForm.sex.value = 'M';
					else thisForm.sex.value = 'F';
					var b_o_p = trimString(JPN.szBirth_Place)
					if(b_o_p == null) b_o_p = "";
					//if(b_o_p != "") thisForm.place_of_birth.value = b_o_p
					if(thisForm.alt_id1_no != null)
					{
						//thisForm.alt_id1_no.value = trimString(JPN.szOld_ID_No);
					}
					
					if(thisForm.date_of_birth != null)
					{
						thisForm.date_of_birth.value = JPN.szBirth_Date;
						if(inst == 'NC') {
							gotoNext(thisForm.date_of_birth);
						} else if(inst == 'IC') {
							if(op_call == 'reg_pat' || op_call == 'ae_reg_pat')	{
								 submitFrame = "parent.parent.frames[2]";
								 bodyFrame	= "parent.parent.frames[1].frames[0]";
							}
							dateCheck(thisForm.date_of_birth,bodyFrame,submitFrame);
						}
					}		
									
					if(thisForm.alt_id2_no!= null)
					thisForm.alt_id2_no.value = trimString(JPN.szOther_ID);				
					
					try
					{
						if(inst == 'NC') {

							if(thisForm.race_code!= null) {							
								raceVal = trimString(JPN.szRace).substring(0,15);					
							}

							if(thisForm.relgn_code != null)	{
								relgnVal = trimString(JPN.szReligion).substring(0,15);					
							}					
							outcomeValue = populateForNC(raceVal,relgnVal);	
							if(outcomeValue != '' && outcomeValue != null && outcomeValue != 'undefined')
							{
								outcomemessage = "";
								var splitValues = outcomeValue.split('~');
								if(splitValues[0] != '' && splitValues[0] != null && splitValues[0] != 'undefined')
								{
									thisForm.race_desc.value = raceVal;
									thisForm.race_code.value = splitValues[0];
								}
								else
								{						
									outcomemessage = outcomemessage+"Race: "+raceVal+" is not matching with master data";
								}
								if(splitValues[1] != '' && splitValues[1] != null && splitValues[1] != 'undefined')
								{
									thisForm.relgn_desc.value = relgnVal;
									thisForm.relgn_code.value = splitValues[1];
								}
								else
								{					
									outcomemessage = outcomemessage+"\n Religion: "+relgnVal+" is not matching with master data";					
								}
							}
							if(outcomemessage != "") alert(outcomemessage);
							
							if(thisForm.r_addr_line1 != null)
							thisForm.r_addr_line1.value = trimString(JPN.szAddress1)  
							if(thisForm.r_addr_line2 != null)
							thisForm.r_addr_line2.value = trimString(JPN.szAddress2 ) 
							if(thisForm.r_addr_line3 != null)
							thisForm.r_addr_line3.value = trimString(JPN.szAddress3 ) 

							if(thisForm.r_postal_code1 != null)
							{
								postal_code = ''+JPN.szPostCode
								if(postal_code.length > 5)
								{	
									postal_code = postal_code.substring(0,5);						
									//thisForm.r_postal_code1.value = postal_code;
								} 							
							}
							
							if(thisForm.r_region_code != null)
							{
								if(Calledfrom=='P'){region = "document.PatRegForm.r_region_code";}
								else if(Calledfrom=='R'){region = "document.Rapid_Regn.r_region_code";}
								else if(Calledfrom=='C'){region = "document.ChangePatDtlForm.r_region_code";}
								if(JPN.szState != null)
								{
									if(trimString(JPN.szState).length > 15)
										regionval = trimString(JPN.szState).substring(0,15);
									else regionval = trimString(JPN.szState);
									regionval  = trimString(regionval);
									
									//populateAddrFlds(region,regionval);
								}
							}
						
							if(thisForm.r_town_code != null)
							{
								if(Calledfrom =='P'){area = "document.PatRegForm.r_town_code";}
								else if(Calledfrom =='R'){area = "document.Rapid_Regn.r_town_code";}
								else if(Calledfrom =='C'){area = "document.ChangePatDtlForm.r_town_code";}
								if(JPN.szCity != null)
								{
									if(trimString(JPN.szCity).length > 15)
										areaval = trimString(JPN.szCity).substring(0,15);
									else areaval= trimString(JPN.szCity);
									areaval = trimString(areaval);	
									
								}
							}
						} else if (inst == 'IC') {
							
							if(thisForm.race_code!= null) {	
								
								raceVal = trimString(JPN.szRace).substring(0,15);
								
								//outcomeValue = populateForIC(raceVal);
								outcomeValue = populateForNC(raceVal,'');

								if(outcomeValue != '' && outcomeValue != null && outcomeValue != 'undefined')
								{
									outcomemessage = "";
									var splitValues = outcomeValue.split('~');
									if(splitValues[0] != '' && splitValues[0] != null && splitValues[0] != 'undefined')
									{
										thisForm.race_desc.value = raceVal;
										thisForm.race_code.value = splitValues[0];
									}
									else
									{						
										outcomemessage = outcomemessage+"Race: "+raceVal+" is not matching with master data";
									}								
								}
								/*
								if(outcomeValue == false){								
									outcomemessage = "";
									outcomemessage = outcomemessage+"Race: "+raceVal+" is not matching with master data";
								}
								*/
							}				

							if(outcomemessage != "") alert(outcomemessage);
							
							region = document.getElementById('region_desc');
							var addrs1 = document.getElementById('addr_line1');
							var addrs2 = document.getElementById('addr_line2');
							var addrs3 = document.getElementById('addr_line3');
							var pstl_code = document.getElementById('postal_code');	
							var pstl_desc = document.getElementById('r_postal_code_desc');						
							addrs1.value = trimString(JPN.szAddress1)  
							addrs2.value = trimString(JPN.szAddress2)  
							addrs3.value = trimString(JPN.szAddress3) 
								
							postal_code = ''+JPN.szPostCode
							if(postal_code.length > 5){	
								postal_code = postal_code.substring(0,5);
								//pstl_code.value = postal_code;							
								//pstl_desc.value = postal_code;							
							}
							
							if(JPN.szState != null){
								if(trimString(JPN.szState).length > 15)
									regionval = trimString(JPN.szState).substring(0,15);
								else regionval = trimString(JPN.szState);
								
								regionval  = trimString(regionval);
								region.value=regionval;
								
							}
							if(JPN.szCity != null)
							{
								if(trimString(JPN.szCity).length > 15)
									 areaval = trimString(JPN.szCity).substring(0,15);
								else areaval= trimString(JPN.szCity);
								areaval = trimString(areaval);
							}
						}
					}
					catch(exception){}				
				}					
				else
				{
					alert("The Card is not connected.Please check the device");
					continueYN = false;
					return;
				}
			}
			catch(exception)
			{
				if(outcomemessage != "") alert(outcomemessage);
			}	
			/*
			if( Calledfrom!= 'X' && Calledfrom!= 'XE' && Calledfrom!= 'CC') {
				if(inst == 'NC') {
					if(parent.parent.messageFrame.document.form1) 
						parent.parent.messageFrame.document.form1.submit();
				} else if(inst == 'IC') {
					if(eval(submitFrame).document.form1) 
						eval(submitFrame).document.form1.submit();
				}
			}
			*/
		}
		try
		{
			if(Calledfrom != 'E' && Calledfrom != 'X' && Calledfrom != 'XE' && Calledfrom!= 'CC' && continueYN == true)
			{
				var return_value = populateAddrValues(regionval,areaval,postal_code);
				
							
				if(return_value != '' && return_value != null && return_value != 'undefined')
				{
					outcomemessage = '';
					var splitValues = return_value.split('~');
					if(splitValues[0] != '' && splitValues[0] != null && splitValues[0] != 'undefined')
					{
						if(Calledfrom == 'P')
						{
							document.PatRegForm.r_region_code.value = regionval;
							document.PatRegForm.r_region.value = splitValues[0];
						}
						else if(Calledfrom == 'R')
						{
							document.Rapid_Regn.r_region_code.value = regionval;
							document.Rapid_Regn.r_region.value = splitValues[0];
						}
						else if(Calledfrom == 'C')
						{
							document.ChangePatDtlForm.r_region_code.value = regionval;
							document.ChangePatDtlForm.r_region.value = splitValues[0];
						}
						else if(inst == 'IC') {
							document.getElementById('region_code').value =splitValues[0] ;
							document.getElementById('region_desc').value =regionval;
						}
					}
					else
					{
						outcomemessage = outcomemessage+"\n State: "+regionval+" is not matching with master data";
					}
					if(splitValues[1] != '' && splitValues[1] != null && splitValues[1] != 'undefined')
					{
						if(Calledfrom == 'P')
						{
							document.PatRegForm.r_town_code.value = areaval; 
							document.PatRegForm.r_town.value = splitValues[1];
						}
						else if(Calledfrom == 'R')
						{
							document.Rapid_Regn.r_town_code.value = areaval;
							document.Rapid_Regn.r_town.value = splitValues[1];
						}
						else if(Calledfrom == 'C')
						{
							document.ChangePatDtlForm.r_town_code.value = areaval;
							document.ChangePatDtlForm.r_town.value = splitValues[1];
						}
						else if(inst == 'IC') {
							document.getElementById('res_town_code').value =splitValues[1] ;
							document.getElementById('res_town_desc').value =areaval;
						}
					}
					else
					{
						outcomemessage = outcomemessage+"\n Town: "+areaval+" is not matching with master data";
					}
					if(splitValues[3] != '' && splitValues[3] != null && splitValues[3] != 'undefined')
					{
						if(splitValues[2] != '' && splitValues[2] != null && splitValues[2] != 'undefined')
						{
							if(Calledfrom == 'P')
							{
								document.PatRegForm.r_area_code.value = splitValues[2]; 
								document.PatRegForm.r_area.value = splitValues[3];
							}
							else if(Calledfrom == 'R')
							{
								document.Rapid_Regn.r_area_code.value = splitValues[2];
								document.Rapid_Regn.r_area.value = splitValues[3];
							}
							else if(Calledfrom == 'C')
							{
								document.ChangePatDtlForm.r_area_code.value = splitValues[2];
								document.ChangePatDtlForm.r_area.value = splitValues[3];
							}
							else if(inst == 'IC') {
								document.getElementById('res_area_code').value = splitValues[3] ;
								document.getElementById('res_area_desc').value = splitValues[2];
							}
						}
					} 				
					if(splitValues[4] != '' && splitValues[4] != null && splitValues[4] != 'undefined')
					{
						if(Calledfrom == 'P')
						{
							document.PatRegForm.r_postal_code1.value = postal_code; 
							document.PatRegForm.r_postal_code.value = splitValues[4];
						}
						else if(Calledfrom == 'R')
						{
							document.Rapid_Regn.r_postal_code1.value = postal_code; 
							document.Rapid_Regn.r_postal_code.value = splitValues[4];
						}
						else if(Calledfrom == 'C')
						{
							document.ChangePatDtlForm.r_postal_code1.value = postal_code;
							document.ChangePatDtlForm.r_postal_code.value = splitValues[4];
						}
						else if(inst == 'IC') {
							document.getElementById('postal_code').value = postal_code;
							document.getElementById('r_postal_code_desc').value = splitValues[4];						
						}
					}
					else
					{
						outcomemessage = outcomemessage+"\n Postal Code: "+postal_code+" is not matching with master data";
					}
					if(outcomemessage != "") alert(outcomemessage);
				}
			}
		}
		catch(exception)
		{
			if(outcomemessage != "") alert(outcomemessage);
		}
		
			if(Calledfrom=='P' && document.PatRegForm.national_id_no)
			{
				document.PatRegForm.national_id_no.focus();
			}
			else if(Calledfrom=='E' && document.Emergency_Regn.national_id_no )
			{
				document.Emergency_Regn.national_id_no.focus();
			}
			else if(Calledfrom=='R' && document.Rapid_Regn.national_id_no)
			{
				document.Rapid_Regn.national_id_no.focus();
			}
			else if(Calledfrom=='C' && document.ChangePatDtlForm.national_id_no)
			{
				document.ChangePatDtlForm.national_id_no.focus();
			}
			else if(Calledfrom=='XE' && document.ae_patient_form.National_Id_No)
			{
				document.ae_patient_form.National_Id_No.focus();
				searchPatient(document.ae_patient_form.National_Id_No);
			}
			else if(Calledfrom == 'CC') {
				document.getElementById('national_id_no').focus();
			} else if(inst == 'IC') {
				//document.getElementById("national_id_no").focus();		
			}
	}
}

//** populateAddrValues() function is called in ReadDF2_onclick() function. It returns State and Town Description concated with '~' delimeter. **//
function populateAddrValues(regionval,areaval,postal_code)
{
	//alert('postal_code-->'+postal_code);
	var ifCondition = 'forSmartCard';
	//var xmlDoc	= new ActiveXObject("Microsoft.XMLDom");
	//var xmlHttp	= new ActiveXObject("Microsoft.XMLHttp");
	var xmlHttp = new XMLHttpRequest();
	xmlStr = "<ROOT><SEARCH regionval=\""+regionval+"\" areaval=\""+areaval+"\" postal_code=\""+postal_code+"\" ifCondition=\""+ifCondition+"\"/></ROOT>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("post","../../eMP/jsp/natAltIDComponentValues.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	responseText =  trimString(responseText);	
	return responseText;
}

function populateForNC(race,religion)
{	
	var succ = false;
	var ifCondition = 'forSmartCard';
	//var xmlDoc	= new ActiveXObject("Microsoft.XMLDom");
	//var xmlHttp	= new ActiveXObject("Microsoft.XMLHttp");
	xmlStr = "<ROOT><SEARCH raceVal=\""+race+"\" relgnVal=\""+religion+"\" ifCondition=\""+ifCondition+"\"/></ROOT>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("post","../../eMP/jsp/natAltIDComponentValues.jsp",false);
	xmlHttp.send(xmlDoc);
	responseText = xmlHttp.responseText;
	responseText =  trimString(responseText);	
	return responseText;	
}

function populateForIC(val)
{
	fieldName = document.getElementById("race_code");
	var succ = false;
	fieldLength = eval(fieldName+".length");
	eval(fieldName+".options[0].selected=true");
	for(var i=0;i<fieldLength;i++)
	{
		if(eval(fieldName+".options["+i+"].text")==val)
		{
			eval(fieldName+".options["+i+"].selected=true");
			succ = true;
		}
	}	
	return succ;
}

//Added func_name as paramter by Ashwin K for AAKH-CRF-0150
function PatSearch_ReadDF1_onclick(func_name)
{ 
	var thisForm = document.Patient_Search_Form;
	
	try
	{
		if(document.forms[0].txtSmartcard_path.value!=''){//smart card			
			if (document.forms[0].txtSmart_fn_name.value=='01'){
				
				//ReadSmartCard_01('PS','PS',document.forms[0].txtSmartcard_path.value);
				if(func_name == "01")
				{
				ret = ReadSmartCard_01('PS','PS',document.forms[0].txtSmartcard_path.value,'','',func_name);
				return ret;
				}
				else
				{
				ReadSmartCard_01('PS','PS',document.forms[0].txtSmartcard_path.value,'','');
				}
			
			}else if (document.forms[0].txtSmart_fn_name.value=='02'){
				ReadSmartCard_02('PS','PS',document.forms[0].txtSmartcard_path.value);
			}else if (document.forms[0].txtSmart_fn_name.value=='03'){
				ReadSmartCard_03('PS','PS',document.forms[0].txtSmartcard_path.value);
			}else if (document.forms[0].txtSmart_fn_name.value=='04'){
				ReadSmartCard_04('PS','PS',document.forms[0].txtSmartcard_path.value);
			}else if (document.forms[0].txtSmart_fn_name.value=='05'){
				ReadSmartCard_05('PS','PS',document.forms[0].txtSmartcard_path.value);
			}else if (document.forms[0].txtSmart_fn_name.value=='06'){
				ReadSmartCard_06('PS','PS',document.forms[0].txtSmartcard_path.value);
			}else{
				ReadSmartCard('PS','PS',document.forms[0].txtSmartcard_path.value);
			}
		}else{
			ReadDF2_onclick('X','YY');
		}
	}
	catch(exception)
	{
	}
}

//Added func_name as paramter by Ashwin K for AAKH-CRF-0150
function RegAttnSearch_ReadDF1_onclick(func_name)
{
	var thisForm = document.ae_patient_form;

	var ret = ""; //Added func_name as paramter by Ashwin K AAKH-CRF-0150
	try
	{
		if(document.forms[0].txtSmartcard_path.value!=''){//smart card			
			if (document.forms[0].txtSmart_fn_name.value=='01'){
				//ReadSmartCard_01('AE','AE',document.forms[0].txtSmartcard_path.value,'','');
				
				//Commented above line and Added by Ashwin K for AAKH-CRF-0150
				if(func_name == "01")
				{
				ret = ReadSmartCard_01('AE','AE',document.forms[0].txtSmartcard_path.value,'','',func_name);
				return ret;
				}
				else
				{
				ReadSmartCard_01(Calledfrom,inst,document.forms[0].txtSmartcard_path.value,'','');
				}
				//Ended by Ashwin K for AAKH-CRF-0150
				
			}else if (document.forms[0].txtSmart_fn_name.value=='02'){
				ReadSmartCard_02('AE','AE',document.forms[0].txtSmartcard_path.value,'','N');
			}else if (document.forms[0].txtSmart_fn_name.value=='03'){
				ReadSmartCard_03('AE','AE',document.forms[0].txtSmartcard_path.value,'','N');
			}else if (document.forms[0].txtSmart_fn_name.value=='04'){
				ReadSmartCard_04('AE','AE',document.forms[0].txtSmartcard_path.value,'','N');
			}else if (document.forms[0].txtSmart_fn_name.value=='05'){
				ReadSmartCard_05('AE','AE',document.forms[0].txtSmartcard_path.value,'','N');
			}else if (document.forms[0].txtSmart_fn_name.value=='06'){
				ReadSmartCard_06('AE','AE',document.forms[0].txtSmartcard_path.value,'','N');
			}else{
				ReadSmartCard('XE','YY',document.forms[0].txtSmartcard_path.value);
			}
		}else{
			ReadDF2_onclick('XE','YY');
		}
	}
	catch(exception)
	{
	}
}
//Added  by santhosh for TH-KW-CRF-0019.1
function OPRegVisit_ReadDF1_onclick(func_name)
{
	var thisForm = document.ae_patient_form;
	
	var ret = ""; //Added func_name as paramter by Ashwin K AAKH-CRF-0150
	try
	{
		if(document.forms[0].txtSmartcard_path.value!=''){//smart card	
			if (document.forms[0].txtSmart_fn_name.value=='01'){
				//ReadSmartCard_01('OP','OP',document.forms[0].txtSmartcard_path.value,'','');
				
				//Commented above line and Added by Ashwin K for AAKH-CRF-0150
				if(func_name == "01")
				{
				
				ret = ReadSmartCard_01('OP','OP',document.forms[0].txtSmartcard_path.value,'','',func_name);
				return ret;
				}
				else
				{
				ReadSmartCard_01(Calledfrom,inst,document.forms[0].txtSmartcard_path.value,'','');
				}
				//Ended by Ashwin K for AAKH-CRF-0150
				
			}else if (document.forms[0].txtSmart_fn_name.value=='02'){
				ReadSmartCard_02('OP','OP',document.forms[0].txtSmartcard_path.value,'','N');
			}else if (document.forms[0].txtSmart_fn_name.value=='03'){
				ReadSmartCard_03('OP','OP',document.forms[0].txtSmartcard_path.value,'','N');
			}else if (document.forms[0].txtSmart_fn_name.value=='04'){
				ReadSmartCard_04('OP','OP',document.forms[0].txtSmartcard_path.value,'','N');
			}else if (document.forms[0].txtSmart_fn_name.value=='05'){
				ReadSmartCard_05('OP','OP',document.forms[0].txtSmartcard_path.value,'','N');
			}else{
				ReadSmartCard('XE','YY',document.forms[0].txtSmartcard_path.value);
			}
		}else{	
			ReadDF2_onclick('XE','YY');
		}
	}
	catch(exception)
	{
	}
}

function initCap(str) 
{
	/* First letter as uppercase, rest lower */
	var str = str.substring(0,1).toUpperCase() + str.substring(1,str.length).toLowerCase();
	return str;
}
function ReadSmartCard(Calledfrom,inst,theLocation,subFrame,opCall){

		var fileContent='';
		var data_line='';
		var bin_pos=-1;
		var binti_pos=-1;
		var com_pos=-1;
		var cntr=0;
		var name_1_val='';
		var name_2_val='';
		var nric_val='';
		var temp_arr='';
		var addr_line_1_val='';
		var temp_str='';
		var nric_add_line_1_val='';
		var nric_add_line_2_val='';
		var nric_add_line_3_val='';
		var dob_val='';
		var gender_val='';
		var nationality_val='';
		var race_val='';
		var prev_line=1;
		var file_empty="Y";
		var nric_strt_val=0;
		
		if(inst=='NC'){
			clear_smart_card_values(Calledfrom,inst);
		}
		var fso, f;
		//fso = new ActiveXObject("Scripting.FileSystemObject");
		fso = "";
		document.forms[0].txtSmartcard_dup.value="";
		
		if(fso.FileExists(theLocation)){
			f = fso.OpenTextFile(theLocation, 1);

						
			while (! f.AtEndOfStream){			
				
				if(! f.AtEndOfLine){

					data_line= trimString(f.ReadLine());					
					file_empty="N";
					cntr=cntr+1;
					if(cntr==1){
						bin_pos= data_line.indexOf("BIN");
						if(bin_pos==-1){
							bin_pos= data_line.indexOf("bin");
						}

						binti_pos= data_line.indexOf("BINTI");
						if(binti_pos==-1){
							binti_pos= data_line.indexOf("binti");

						}

						if(bin_pos==-1 && binti_pos==-1){
							name_1_val=data_line.substr(0,80);
							name_2_val=data_line.substr(81,data_line.length);
						}else{
							
							if(bin_pos>binti_pos ){
								if(binti_pos==-1){
									name_1_val=data_line.substr(0,bin_pos);
									name_2_val=data_line.substr(bin_pos+3,data_line.length);
								}else{
									name_1_val=data_line.substr(0,binti_pos);
									name_2_val=data_line.substr(binti_pos+5,data_line.length);
								}
							}else{
								if(bin_pos==-1){
									name_1_val=data_line.substr(0,binti_pos);
									name_2_val=data_line.substr(binti_pos+5,data_line.length);
								}else{
									if(bin_pos==binti_pos){
										name_1_val=data_line.substr(0,binti_pos);
										name_2_val=data_line.substr(binti_pos+5,data_line.length);
									}else{
										name_1_val=data_line.substr(0,bin_pos);
										name_2_val=data_line.substr(bin_pos+3,data_line.length);
									}
								}

							}
						}

						
						
						/*if(bin_pos==-1){
							bin_pos= data_line.indexOf("BIN");
							
							if(bin_pos==-1){
								bin_pos= data_line.indexOf("bin");
							}

							if(bin_pos==-1){
								name_1_val=data_line.substr(0,80);
								name_2_val=data_line.substr(81,data_line.length);
								
							}else{
								name_1_val=data_line.substr(0,bin_pos);
								name_2_val=data_line.substr(bin_pos+3,data_line.length);
							}


						}else{
							name_1_val=data_line.substr(0,bin_pos);
							name_2_val=data_line.substr(bin_pos+5,data_line.length);
						}
						*/

						
						
					}
					if(cntr==2){
						temp_arr=data_line.split("-");
						for( i=0;i<temp_arr.length;i++){
							nric_val=nric_val+temp_arr[i];
						}				
						
					}

					if(cntr==3){
						com_pos=data_line.indexOf(",");

				
						if(com_pos > -1){
							if(com_pos>30){
								addr_line_1_val=data_line.substr(0,30);
								temp_str=data_line.substr(30,data_line.length);
							}else{
								addr_line_1_val=data_line.substr(0,com_pos);
								temp_str=data_line.substr(com_pos+1,data_line.length);
							}
							
						}else{
							temp_str=data_line;
						}
							nric_add_line_1_val=temp_str.substr(0,30);
							nric_add_line_2_val=temp_str.substr(30,30);
							nric_add_line_3_val=temp_str.substr(60,30);
					
					}

					if(cntr==4){
						dob_val=data_line;					
					}

					if(cntr==5){
						if(data_line=="LELAKI" || data_line=="lelaki"){
							gender_val="M";
						}else if (data_line=="PEREMPUAN" || data_line=="perempuan"){
							gender_val="F";
						}else{
							gender_val="U";
						}
					}


					if(cntr==6){
						nationality_val=data_line;					
					}


					if(cntr==7){
						race_val=data_line;
					}						
				}else{
					cntr=cntr+1;
					f.SkipLine();
				}
				
			}
			

			if(file_empty=="N"){
				
				var nric_strt_val=nric_val.substr(0,2);
				var flg_pop_dat=0;
				if(isNaN(parseInt(nric_strt_val))){
					flg_pop_dat=0;
				}else{
					if(nric_strt_val<=29)	{
						flg_pop_dat=0;
					}else if (nric_strt_val>=30 && nric_strt_val<=49)	{
						flg_pop_dat=1;
					}else if (nric_strt_val>=50 )	{
						flg_pop_dat=2;
					}
				}

			
				if(inst=='NC'){  // Pat regn, Rapid regn, Emergey Regn
					if(flg_pop_dat==0){
						document.getElementById('national_id_no').value=nric_val;
						document.getElementById('national_id_no').focus();
						setTimeout("document.forms[0].national_id_no.blur()",500);
						
										
					}else{
						document.forms[0].txtSmartcard_dup.value="1";					
				
					}
			
					setTimeout("populate_smart_crd_data('"+nric_val+"','"+name_1_val+"','"+name_2_val+"','"+addr_line_1_val+"','"+nric_add_line_1_val+"','"+nric_add_line_2_val+"','"+nric_add_line_3_val+"','"+dob_val+"','"+gender_val+"','"+nationality_val+"','"+race_val+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"')",1000);
				}
				
				if(inst=='YY' ){ // Reg atendance
					if(flg_pop_dat==0){
						document.getElementById('National_Id_No').value=nric_val;
						document.getElementById('National_Id_No').focus();
						setTimeout("document.forms[0].National_Id_No.blur()",200);
					}else{
						msg = getMessage('INVALID_NAT_ID','MP');
						msg = msg.replace("#",document.forms[0].nat_id_prompt.value);
						document.getElementById('National_Id_No').value = '';
						document.getElementById('National_Id_No').focus();
						alert(msg);
					}
				}
				
				
				if(inst=='IC' ){ // Referral, book appt, wait list, ip booking
					if(flg_pop_dat==0){
						document.getElementById("national_id_no").value=nric_val;
						document.getElementById("national_id_no").focus();
						setTimeout(document.getElementById("national_id_no").blur(),200);					

					}else{
						document.forms[0].txtSmartcard_dup.value="1";	
					}

					setTimeout("populate_smart_crd_data('"+nric_val+"','"+name_1_val+"','"+name_2_val+"','"+addr_line_1_val+"','"+nric_add_line_1_val+"','"+nric_add_line_2_val+"','"+nric_add_line_3_val+"','"+dob_val+"','"+gender_val+"','"+nationality_val+"','"+race_val+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"')",1000);

				}

				

				if(inst=='SR' ){ // Reg visit all tabs, manage wt list, conifrm cancel reise booking
					if(flg_pop_dat==0){
						document.getElementById('national_id_no').value=nric_val;
						document.getElementById('national_id_no').focus();
						setTimeout("document.forms[0].national_id_no.blur()",200);
					}else{
						document.forms[0].txtSmartcard_dup.value="1";	
						
					}

					setTimeout("populate_smart_crd_data('"+nric_val+"','"+name_1_val+"','"+name_2_val+"','"+addr_line_1_val+"','"+nric_add_line_1_val+"','"+nric_add_line_2_val+"','"+nric_add_line_3_val+"','"+dob_val+"','"+gender_val+"','"+nationality_val+"','"+race_val+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"')",1000);

				}
				
				if(inst=='PS' ){ // Patient Search
					if(flg_pop_dat==0){
						document.getElementById('National_Id_No').value=nric_val;
						document.getElementById('National_Id_No').focus();
						setTimeout("document.forms[0].National_Id_No.blur()",200);
					}else{
						document.forms[0].txtSmartcard_dup.value="1";	
						
					}

					setTimeout("populate_smart_crd_data_ps('"+nric_val+"','"+name_1_val+"','"+name_2_val+"','"+addr_line_1_val+"','"+nric_add_line_1_val+"','"+nric_add_line_2_val+"','"+nric_add_line_3_val+"','"+dob_val+"','"+gender_val+"','"+nationality_val+"','"+race_val+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"')",1000);

				}



				f.close();
				fso.deleteFile(theLocation);
				

	
			}else{				
				var val = getMessage("EMPTY_SMRT_CRD",'MP');				
				alert(val);
			}
	}else{
		var val = getMessage("SMRT_CRD_FL_UA",'MP');				
		alert(val);
	}
	


}

function populate_smart_crd_data(nric_val,name_1_val,name_2_val,addr_line_1_val,nric_add_line_1_val,nric_add_line_2_val,nric_add_line_3_val,dob_val,gender_val,nationality_val,race_val,flg_pop_dat,Calledfrom,inst){
	
	if(document.forms[0].txtSmartcard_dup.value=="1"){

		if(flg_pop_dat==0){

			if(document.forms[0].national_id_no.value==''){
				/* checkNatioanlity.jsp identified duplicate NRIC  */
			}else{
				if(inst=='SR' ){
					var fn_id=document.getElementById('txtSmartcard_fn').value;
					if(fn_id=='VISIT_REGISTRATION'){
						if(document.getElementById('pat_id1').value==''){
							if(document.getElementById('tabName').value!='addvisit_tab'){
								if(document.getElementById('tabName').value=='checkin_tab' ){
									function_name="APP";
										if(name_1_val !=''){
											if(name_1_val.length > document.getElementById("second_name").maxLength){
												name_1_val=name_1_val.substr(0,document.getElementById("second_name").maxLength);
											}
										}
										if(name_2_val !=''){
											if(name_2_val.length > document.getElementById("third_name").maxLength){
												name_2_val=name_2_val.substr(0,document.getElementById("third_name").maxLength);
											}
										}

									document.forms[0].second_name.value=name_1_val;
									document.forms[0].third_name.value=name_2_val;
									document.forms[0].gender.value=gender_val;
								}else{
									function_name="INV";
								}

								
								HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/populateSmartCard.jsp'><input type='hidden' name='inst' id='inst' value=\""+inst+"\"><input type='hidden' name='Calledfrom' id='Calledfrom' value=\""+Calledfrom+"\"><input type='hidden' name='race_desc' id='race_desc' value=\""+race_val+"\"><input type='hidden' name='nationality_desc' id='nationality_desc' value=\""+nationality_val+"\"><input type='hidden' name='nric_val' id='nric_val' value=\""+nric_val+"\"><input type='hidden' name='nric' id='nric' value=\""+flg_pop_dat+"\"><input type='hidden' name='function_name' id='function_name' value=\""+function_name+"\"><input type='hidden' name='caller_form' id='caller_form' value='00'>";  
								
								parent.parent.messageFrame.document.write(HTMLVal);
								parent.parent.messageFrame.document.form1.submit();
							}
						}
					}else if(fn_id=='BKNG'){
						if(document.getElementById('patient_id').value==''){
								if(name_1_val !=''){
									if(name_1_val.length > document.getElementById("second_name").maxLength){
										name_1_val=name_1_val.substr(0,document.getElementById("second_name").maxLength);
									}
								}
								if(name_2_val !=''){
									if(name_2_val.length > document.getElementById("third_name").maxLength){
										name_2_val=name_2_val.substr(0,document.getElementById("third_name").maxLength);
									}
								}

							document.forms[0].second_name.value=name_1_val;
							document.forms[0].third_name.value=name_2_val;
							document.forms[0].gender.value=gender_val;
						}
					}else{
						if(document.getElementById('patientid').value==''){
							if(document.getElementById('txtSmartcard_fn').value=='POPFROM'){
								function_name="POPFROM";
								document.forms[0].genderValue.value=gender_val;

								/*HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/populateSmartCard.jsp'><input type='hidden' name='inst' id='inst' value=\""+inst+"\"><input type='hidden' name='Calledfrom' id='Calledfrom' value=\""+Calledfrom+"\"><input type='hidden' name='race_desc' id='race_desc' value=\""+race_val+"\"><input type='hidden' name='nationality_desc' id='nationality_desc' value=\""+nationality_val+"\"><input type='hidden' name='nric_val' id='nric_val' value=\""+nric_val+"\"><input type='hidden' name='nric' id='nric' value=\""+flg_pop_dat+"\"><input type='hidden' name='function_name' id='function_name' value=\""+function_name+"\">";  
									
								parent.messageFrame.document.write(HTMLVal);
								parent.messageFrame.document.form1.submit();*/

							}else{
								function_name="MGWLST";
								document.forms[0].gender.value=gender_val;

								HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/populateSmartCard.jsp'><input type='hidden' name='inst' id='inst' value=\""+inst+"\"><input type='hidden' name='Calledfrom' id='Calledfrom' value=\""+Calledfrom+"\"><input type='hidden' name='race_desc' id='race_desc' value=\""+race_val+"\"><input type='hidden' name='nationality_desc' id='nationality_desc' value=\""+nationality_val+"\"><input type='hidden' name='nric_val' id='nric_val' value=\""+nric_val+"\"><input type='hidden' name='nric' id='nric' value=\""+flg_pop_dat+"\"><input type='hidden' name='function_name' id='function_name' value=\""+function_name+"\"><input type='hidden' name='caller_form' id='caller_form' value='00'>";  
									
								parent.messageFrame.document.write(HTMLVal);
								parent.messageFrame.document.form1.submit();
							}
						}
					}
				}else{
					if(document.forms[0].second_name.value!=''){
						/* Data exists for the NRIC in XF_PERSON   */				
					}else{
						/* populate data from text file */
						if(inst=='IC' ){
							document.getElementById('citizen_yn')[0].checked=true; 
							document.getElementById('citizen_yn')[0].click();
						}else{
							document.getElementById('citizenid').checked=true; 
							document.getElementById('citizenid').click();
							if(document.getElementById('citizen_yn')){
								document.getElementById('citizen_yn').value='Y';
							}
						}
						set_values(nric_val,name_1_val,name_2_val,addr_line_1_val,nric_add_line_1_val,nric_add_line_2_val,nric_add_line_3_val,dob_val,gender_val,nationality_val,race_val,flg_pop_dat,Calledfrom,inst);
						

					}
				}
			}
		}else{	
			if(inst=='SR'){
				if(flg_pop_dat==1){
						document.forms[0].other_alt_type.value="0015";// to be replaced as 0015
				}else{
					document.forms[0].other_alt_type.value="0016";// to be replaced as 0016
				}
				if(document.forms[0].other_alt_type.selectedIndex != 0){
					document.forms[0].other_alt_Id.disabled = false;
					document.forms[0].other_alt_Id.value = nric_val;
				}else{
					document.forms[0].other_alt_Id.disabled = true;
					document.forms[0].other_alt_Id.value = ""
					
				}

				var fn_id="";
				try{
					fn_id=document.getElementById('functionId').value;
				}catch(exception){
					try{
						fn_id=document.getElementById('function_id').value;
					}catch(exception){
						fn_id="BKNG";
					}
				}
				try{
				
					if(document.getElementById('cld_frm_pat_regn').value=='Y'){						
						fn_id="POPFROM";
						
						
					}
				}catch(exception){
				}
				document.getElementById('txtSmartcard_fn').value=fn_id;
				
				if(fn_id=="VISIT_REGISTRATION"){
					document.getElementById('pat_id1').value=document.getElementById('txtSmartcard_pat_id').value;
				}else if(fn_id=="BKNG"){
					document.getElementById('patient_id').value=document.getElementById('txtSmartcard_pat_id').value;
				}else{
					document.getElementById('patientid').value=document.getElementById('txtSmartcard_pat_id').value;
				}

				var fn_id=document.getElementById('txtSmartcard_fn').value;
				
					if(fn_id=='VISIT_REGISTRATION'){
						if(document.getElementById('pat_id1').value==''){
							if(document.getElementById('tabName').value!='addvisit_tab'){
								if(document.getElementById('tabName').value=='checkin_tab' ){
									function_name="APP";
										if(name_1_val !=''){
											if(name_1_val.length > document.getElementById("second_name").maxLength){
												name_1_val=name_1_val.substr(0,document.getElementById("second_name").maxLength);
											}
										}
										if(name_2_val !=''){
											if(name_2_val.length > document.getElementById("third_name").maxLength){
												name_2_val=name_2_val.substr(0,document.getElementById("third_name").maxLength);
											}
										}

									document.forms[0].second_name.value=name_1_val;
									document.forms[0].third_name.value=name_2_val;
									document.forms[0].gender.value=gender_val;
								}else{
									function_name="INV";
								}

								
								HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/populateSmartCard.jsp'><input type='hidden' name='inst' id='inst' value=\""+inst+"\"><input type='hidden' name='Calledfrom' id='Calledfrom' value=\""+Calledfrom+"\"><input type='hidden' name='race_desc' id='race_desc' value=\""+race_val+"\"><input type='hidden' name='nationality_desc' id='nationality_desc' value=\""+nationality_val+"\"><input type='hidden' name='nric_val' id='nric_val' value=\""+nric_val+"\"><input type='hidden' name='nric' id='nric' value=\""+flg_pop_dat+"\"><input type='hidden' name='function_name' id='function_name' value=\""+function_name+"\"><input type='hidden' name='caller_form' id='caller_form' value='00'>";  
								
								parent.parent.messageFrame.document.write(HTMLVal);
								parent.parent.messageFrame.document.form1.submit();
							}
						}
					}else if(fn_id=='BKNG'){
						if(document.getElementById('patient_id').value==''){
								if(name_1_val !=''){
									if(name_1_val.length > document.getElementById("second_name").maxLength){
										name_1_val=name_1_val.substr(0,document.getElementById("second_name").maxLength);
									}
								}
								if(name_2_val !=''){
									if(name_2_val.length > document.getElementById("third_name").maxLength){
										name_2_val=name_2_val.substr(0,document.getElementById("third_name").maxLength);
									}
								}
							document.forms[0].second_name.value=name_1_val;
							document.forms[0].third_name.value=name_2_val;
							document.forms[0].gender.value=gender_val;
						}
					}else{
						if(document.getElementById('patientid').value==''){
							if(document.getElementById('txtSmartcard_fn').value=='POPFROM'){
								function_name="POPFROM";
								document.forms[0].genderValue.value=gender_val;

								/*HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/populateSmartCard.jsp'><input type='hidden' name='inst' id='inst' value=\""+inst+"\"><input type='hidden' name='Calledfrom' id='Calledfrom' value=\""+Calledfrom+"\"><input type='hidden' name='race_desc' id='race_desc' value=\""+race_val+"\"><input type='hidden' name='nationality_desc' id='nationality_desc' value=\""+nationality_val+"\"><input type='hidden' name='nric_val' id='nric_val' value=\""+nric_val+"\"><input type='hidden' name='nric' id='nric' value=\""+flg_pop_dat+"\"><input type='hidden' name='function_name' id='function_name' value=\""+function_name+"\">";  
									
								parent.messageFrame.document.write(HTMLVal);
								parent.messageFrame.document.form1.submit();
								*/

							}else{
								function_name="MGWLST";
								document.forms[0].gender.value=gender_val;

								HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/populateSmartCard.jsp'><input type='hidden' name='inst' id='inst' value=\""+inst+"\"><input type='hidden' name='Calledfrom' id='Calledfrom' value=\""+Calledfrom+"\"><input type='hidden' name='race_desc' id='race_desc' value=\""+race_val+"\"><input type='hidden' name='nationality_desc' id='nationality_desc' value=\""+nationality_val+"\"><input type='hidden' name='nric_val' id='nric_val' value=\""+nric_val+"\"><input type='hidden' name='nric' id='nric' value=\""+flg_pop_dat+"\"><input type='hidden' name='function_name' id='function_name' value=\""+function_name+"\"><input type='hidden' name='caller_form' id='caller_form' value='00'>";  
									
								parent.messageFrame.document.write(HTMLVal);
								parent.messageFrame.document.form1.submit();
							}
							
						}
					}
			}else{
				if(inst=='IC' ){  // Referral, book appt, wait list, ip booking
					document.getElementById('citizen_yn')[1].checked=true;
					document.getElementById('citizen_yn')[1].click();
					if(flg_pop_dat==1){
						document.forms[0].other_alt_type.value="0015";// to be replaced as 0015
					}else{
						document.forms[0].other_alt_type.value="0016";// to be replaced as 0016
					}
					if(document.forms[0].other_alt_type.selectedIndex != 0){
						document.forms[0].other_alt_Id.disabled = false;
						document.forms[0].other_alt_Id.value = nric_val;
					}else{
						document.forms[0].other_alt_Id.disabled = true;
						document.forms[0].other_alt_Id.value = ""
						
					}
				}else if(inst=='NC' ){

					document.getElementById('citizenid2').checked=true;
					document.getElementById('citizenid2').click();
					if(document.getElementById('citizen_yn')){
						document.getElementById('citizen_yn').value='N'
					}
					if(flg_pop_dat==1){
						document.forms[0].other_alt_id.value="0015";// to be replaced as 0015
					}else{
						document.forms[0].other_alt_id.value="0016";// to be replaced as 0016
					}
					if(document.forms[0].other_alt_id.selectedIndex != 0){
						document.forms[0].other_alt_Id_text.disabled = false;
						document.forms[0].other_alt_Id_text.value = nric_val;
					}else{
						document.forms[0].other_alt_Id_text.disabled = true;
						document.forms[0].other_alt_Id_text.value = ""
						
					}
				}			
				set_values(nric_val,name_1_val,name_2_val,addr_line_1_val,nric_add_line_1_val,nric_add_line_2_val,nric_add_line_3_val,dob_val,gender_val,nationality_val,race_val,flg_pop_dat,Calledfrom,inst);
			}
		}
		
		if(document.forms[0].func_act){  
				var func_act = document.forms[0].func_act.value;
				if(func_act=="Visitreg" || func_act=="REF_SEARCH" || func_act=="DuplicateRegistration"){
					setTimeout("disableToolBarButtons()", 1000);
				}
		}
	
		if(document.forms[0].appt_yn){
			if(document.forms[0].appt_yn.value=="Appt"){
				setTimeout("disableToolBarButtons()", 1000);
			}
		}
	
	}else if(document.forms[0].txtSmartcard_dup.value=="D"){
	}else{
			setTimeout("populate_smart_crd_data('"+nric_val+"','"+name_1_val+"','"+name_2_val+"','"+addr_line_1_val+"','"+nric_add_line_1_val+"','"+nric_add_line_2_val+"','"+nric_add_line_3_val+"','"+dob_val+"','"+gender_val+"','"+nationality_val+"','"+race_val+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"')",3000);

	}

}


function set_values(nric_val,name_1_val,name_2_val,addr_line_1_val,nric_add_line_1_val,nric_add_line_2_val,nric_add_line_3_val,dob_val,gender_val,nationality_val,race_val,flg_pop_dat,Calledfrom,inst){
		if(name_1_val !=''){
			if(name_1_val.length > document.getElementById("second_name").maxLength){
				name_1_val=name_1_val.substr(0,document.getElementById("second_name").maxLength);
			}
		}
		if(name_2_val !=''){
			if(name_2_val.length > document.getElementById("third_name").maxLength){
				name_2_val=name_2_val.substr(0,document.getElementById("third_name").maxLength);
			}
		}

		
		if(document.forms[0].second_name){
			document.forms[0].second_name.value=name_1_val;
			document.forms[0].second_name.focus();
			document.forms[0].second_name.blur();
		}

		if(document.forms[0].third_name){
			document.forms[0].third_name.value=name_2_val;	
			document.forms[0].third_name.focus();
			document.forms[0].third_name.blur();
		}
				
		
		if(Calledfrom=='P' || Calledfrom=='R'){
			document.forms[0].r_addr_line1.value=addr_line_1_val;
		}
		if(Calledfrom=='P'){
			document.forms[0].addl_field1.value=nric_add_line_1_val;
			document.forms[0].addl_field2.value=nric_add_line_2_val;
			document.forms[0].addl_field3.value=nric_add_line_3_val;
		}
		

		document.forms[0].date_of_birth.value=dob_val;
		document.forms[0].date_of_birth.focus();
		document.forms[0].date_of_birth.blur();
		document.forms[0].sex.value=gender_val;

			
		var function_name
		if(inst=='NC'){
			function_name="PAT_REGN";
			HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/populateSmartCard.jsp'><input type='hidden' name='inst' id='inst' value=\""+inst+"\"><input type='hidden' name='Calledfrom' id='Calledfrom' value=\""+Calledfrom+"\"><input type='hidden' name='race_desc' id='race_desc' value=\""+race_val+"\"><input type='hidden' name='nationality_desc' id='nationality_desc' value=\""+nationality_val+"\"><input type='hidden' name='nric_val' id='nric_val' value=\""+nric_val+"\"><input type='hidden' name='nric' id='nric' value=\""+flg_pop_dat+"\"><input type='hidden' name='function_name' id='function_name' value=\""+function_name+"\"><input type='hidden' name='caller_form' id='caller_form' value='00'>";  
			parent.parent.messageFrame.document.write(HTMLVal);
			parent.parent.messageFrame.document.form1.submit();
		}

		if(inst=='IC'){
			
			var modal_yn='N';
			if(parent.parent.messageFrame){
				function_name="";
				try{
					
					eval(Calledfrom+".document.forms[0]");
					function_name="BOOK_APPT";
					try{
						if(document.forms[0].from){
							function_name="WAIT_LIST";
							if(document.forms[0].from.value !=''){
								modal_yn='Y'
							}
						}
					}catch(exception) {
					}
					
				}catch(exception){
					function_name="REFERRAL";
				}
				
				setTimeout("document.forms[0].date_of_birth.focus();", 500);
				setTimeout("document.forms[0].date_of_birth.blur();", 500);
				
				HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/populateSmartCard.jsp'><input type='hidden' name='inst' id='inst' value=\""+inst+"\"><input type='hidden' name='Calledfrom' id='Calledfrom' value=\""+Calledfrom+"\"><input type='hidden' name='race_desc' id='race_desc' value=\""+race_val+"\"><input type='hidden' name='nationality_desc' id='nationality_desc' value=\""+nationality_val+"\"><input type='hidden' name='nric_val' id='nric_val' value=\""+nric_val+"\"><input type='hidden' name='nric' id='nric' value=\""+flg_pop_dat+"\"><input type='hidden' name='function_name' id='function_name' value=\""+function_name+"\"><input type='hidden' name='modal_yn' id='modal_yn' value=\""+modal_yn+"\"><input type='hidden' name='caller_form' id='caller_form' value='00'>";  
				
				setTimeout("parent.parent.messageFrame.document.write(HTMLVal);", 1000);
				
				setTimeout("parent.parent.messageFrame.document.form1.submit();", 1000);

							

			}else{
				
				function_name="WAIT_LIST";

				setTimeout("document.forms[0].date_of_birth.focus();", 500);
				setTimeout("document.forms[0].date_of_birth.blur();", 500);
				
				HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/populateSmartCard.jsp'><input type='hidden' name='inst' id='inst' value=\""+inst+"\"><input type='hidden' name='Calledfrom' id='Calledfrom' value=\""+Calledfrom+"\"><input type='hidden' name='race_desc' id='race_desc' value=\""+race_val+"\"><input type='hidden' name='nationality_desc' id='nationality_desc' value=\""+nationality_val+"\"><input type='hidden' name='nric_val' id='nric_val' value=\""+nric_val+"\"><input type='hidden' name='nric' id='nric' value=\""+flg_pop_dat+"\"><input type='hidden' name='function_name' id='function_name' value=\""+function_name+"\"><input type='hidden' name='caller_form' id='caller_form' value='00'>";  
				
				setTimeout("parent.messageFrame.document.write(HTMLVal);", 1000);
				setTimeout("parent.messageFrame.document.form1.submit();", 1000);
			
				
			}
		}



						
		
}

function clear_smart_card_values(Calledfrom,inst){

		document.forms[0].national_id_no.value='';
		document.forms[0].national_id_no.focus();
		document.forms[0].national_id_no.blur();
		


		set_values('','','','','','','','','','','','',Calledfrom,inst);


		if(inst=='IC' ){
			document.getElementById('citizen_yn')[1].checked=true;
			document.getElementById('citizen_yn')[1].click();
		}else{
			document.getElementById('citizenid').checked=true;
			document.getElementById('citizenid').click();
			if(document.getElementById('citizen_yn')){
				document.getElementById('citizen_yn').value='Y';
			}
		}
		if(document.forms[0].other_alt_id){
			document.forms[0].other_alt_id.selectedIndex ==0;
			document.forms[0].other_alt_Id_text.disabled = false;
		}

		if(document.forms[0].other_alt_id){
			document.forms[0].other_alt_Id_text.value = '';
			document.forms[0].other_alt_Id_text.disabled = true;
		}

}


function populate_smart_crd_data_ps(nric_val,name_1_val,name_2_val,addr_line_1_val,nric_add_line_1_val,nric_add_line_2_val,nric_add_line_3_val,dob_val,gender_val,nationality_val,race_val,flg_pop_dat,Calledfrom,inst){
	
	var function_name="PS";
	if(document.forms[0].txtSmartcard_dup.value=="1"){

		if(flg_pop_dat==0){

			if(document.forms[0].National_Id_No.value==''){
				/* checkNatioanlity.jsp identified duplicate NRIC  */
			}else{
				
				if(document.forms[0].Second_Name.value!=''){
					/* Data exists for the NRIC in XF_PERSON   */				
				}else{
					/* populate data from text file */

						if(name_1_val !=''){
							if(name_1_val.length > document.getElementById("Second_Name").maxLength){
								name_1_val=name_1_val.substr(0,document.getElementById("Second_Name").maxLength);
							}
						}
						if(name_2_val !=''){
							if(name_2_val.length > document.getElementById("Third_Name").maxLength){
								name_2_val=name_2_val.substr(0,document.getElementById("Third_Name").maxLength);
							}
						}
					
					document.forms[0].Second_Name.value=name_1_val;
					document.forms[0].Third_Name.value=name_2_val;
					document.forms[0].Sex.value=gender_val;
					document.forms[0].Dob.value=dob_val;

					HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/populateSmartCard.jsp'><input type='hidden' name='inst' id='inst' value=\""+inst+"\"><input type='hidden' name='Calledfrom' id='Calledfrom' value=\""+Calledfrom+"\"><input type='hidden' name='race_desc' id='race_desc' value=\""+race_val+"\"><input type='hidden' name='nationality_desc' id='nationality_desc' value=\""+nationality_val+"\"><input type='hidden' name='nric_val' id='nric_val' value=\""+nric_val+"\"><input type='hidden' name='nric' id='nric' value=\""+flg_pop_dat+"\"><input type='hidden' name='function_name' id='function_name' value=\""+function_name+"\"><input type='hidden' name='caller_form' id='caller_form' value='00'>";  
				
					parent.frames[6].document.write(HTMLVal);
					parent.frames[6].document.form1.submit();
				
					
					//set_values(nric_val,name_1_val,name_2_val,addr_line_1_val,nric_add_line_1_val,nric_add_line_2_val,nric_add_line_3_val,dob_val,gender_val,nationality_val,race_val,flg_pop_dat,Calledfrom,inst);
				}
				
			}
		}else{		
			
			if(flg_pop_dat==1){
				document.forms[0].other_alt_id.value="0015";// to be replaced as 0015
			}else{
				document.forms[0].other_alt_id.value="0016";// to be replaced as 0016
			}
			if(document.forms[0].other_alt_id.selectedIndex != 0){
				document.forms[0].other_alt_Id_no.disabled = false;
				document.forms[0].other_alt_Id_no.value = nric_val;
			}else{
				document.forms[0].other_alt_Id_no.disabled = true;
				document.forms[0].other_alt_Id_no.value = "";
				
			}
			if(name_1_val !=''){
				if(name_1_val.length > document.getElementById("Second_Name").maxLength){
					name_1_val=name_1_val.substr(0,document.getElementById("Second_Name").maxLength);
				}
			}
			if(name_2_val !=''){
				if(name_2_val.length > document.getElementById("Third_Name").maxLength){
					name_2_val=name_2_val.substr(0,document.getElementById("Third_Name").maxLength);
				}
			}
			document.forms[0].Second_Name.value=name_1_val;
			document.forms[0].Third_Name.value=name_2_val;
			document.forms[0].Sex.value=gender_val;
			document.forms[0].Dob.value=dob_val;
			
			

			HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/populateSmartCard.jsp'><input type='hidden' name='inst' id='inst' value=\""+inst+"\"><input type='hidden' name='Calledfrom' id='Calledfrom' value=\""+Calledfrom+"\"><input type='hidden' name='race_desc' id='race_desc' value=\""+race_val+"\"><input type='hidden' name='nationality_desc' id='nationality_desc' value=\""+nationality_val+"\"><input type='hidden' name='nric_val' id='nric_val' value=\""+nric_val+"\"><input type='hidden' name='nric' id='nric' value=\""+flg_pop_dat+"\"><input type='hidden' name='function_name' id='function_name' value=\""+function_name+"\"><input type='hidden' name='caller_form' id='caller_form' value='00'>";  
				

			parent.frames[6].document.write(HTMLVal);
			parent.frames[6].document.form1.submit();
		
			
				
				//set_values(nric_val,name_1_val,name_2_val,addr_line_1_val,nric_add_line_1_val,nric_add_line_2_val,nric_add_line_3_val,dob_val,gender_val,nationality_val,race_val,flg_pop_dat,Calledfrom,inst);
			
		}
		
		
	}else if(document.forms[0].txtSmartcard_dup.value=="D"){
	}else{
			setTimeout("populate_smart_crd_data_ps('"+nric_val+"','"+name_1_val+"','"+name_2_val+"','"+addr_line_1_val+"','"+nric_add_line_1_val+"','"+nric_add_line_2_val+"','"+nric_add_line_3_val+"','"+dob_val+"','"+gender_val+"','"+nationality_val+"','"+race_val+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"')",3000);

	}

}
function clear_populated_values(){
	if (typeof parent.parent.frames[1].frames[0].document.getElementById('refIDValue') != "undefined"){
		if(parent.parent.frames[1].frames[0].document.getElementById('refIDValue').value==""){
			if (document.forms[0].txtSmart_fn_name.value=='01'){
				clear_smart_card_values_01('','','','','','','','','','','','','','','','','','','Clear','Clear');
			}else if (document.forms[0].txtSmart_fn_name.value=='02'){
				clear_smart_card_values_02('','','','','','','','','','','','','','','','','','','Clear','Clear');
			}else if (document.forms[0].txtSmart_fn_name.value=='03'){
				clear_smart_card_values_03('','','','','','','','','','','','','','','','','','','Clear','Clear');
			}else if (document.forms[0].txtSmart_fn_name.value=='04'){
				clear_smart_card_values_04('','','','','','','','','','','','','','','','','','','Clear','Clear');
			}
		}
	}
}

