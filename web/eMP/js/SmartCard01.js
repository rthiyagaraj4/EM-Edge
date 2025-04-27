var p_inst;
var p_Calledfrom;
var fileContent='';
var p_funcname="";
var p_jsonObject;
var data_line='';
var cntr=0;
var prev_line=1;
var file_empty="Y";

var name_prefix ='';
var first_name='';
var second_name='';
var third_name='';
var family_name='';		
var nric_val='';
var dob_val='';		
var gender_val='';
var nationality_val='';

var addr_line_1='';
var addr_line_2='';
var addr_line_3='';
var country_val='';				
var mobile_no='';
var passport_no='';
var passport_exp='';
var temp_arr='';	
var finger_data='';

//Added by Ashwin K for AAKH-CRF-0150
var retdata = ""; 
var emirates = "";
function ReadSmartCard_01(Calledfrom,inst,theLocation,subFrame,opCall,funcname)
	{  		
	//Ended by Ashwin K for AAKH-CRF-0150
	if(Calledfrom =='top.f_query_add_mod'){
	Calledfrom='OAAP'
	}
	
	if(Calledfrom =='parent.frames[1].frames[0]'){
		Calledfrom ='REGREF';
		
		if(document.getElementById("p_calling_function").value=='OA_BOOK_APPT'){
			from_OA='Y';
		}
	}

	if(Calledfrom =='parent.frames[1]'){
		if(document.getElementById("call_function")){
			if(document.getElementById("call_function").value="IP_Booking"){
				Calledfrom ='IPBOOKING';
			}
		}else{
			Calledfrom ='WTLST';

		}
	}

	if(Calledfrom =='CC' && inst=='NC'){
		if(document.getElementById("noshow_bkng_period")){
			Calledfrom='CCRB';
		}else if(document.getElementById("function_id")){
			Calledfrom='WTMGMT';
		}else if(document.getElementById("functionId")){
			Calledfrom='VSTREG';
		}else{
			Calledfrom='REFQUR';
		}
	}


	if(inst=='NC'){
		clear_smart_card_values_01(Calledfrom,inst);
	}
	if(inst=='PS' ){
		clear_smart_card_values_ps_01(Calledfrom,inst);
	}
	p_inst=inst;
	p_Calledfrom=Calledfrom;
	p_funcname=funcname;
	callMykadReader(Calledfrom);
	}
function getMyKadValue(jsonVal) {
p_jsonObject=JSON.stringify(jsonVal);
closeit();
if(jsonVal!=''){ 
	MykadReader(jsonVal);
}
} 
var windowReturnVal ="";
function getMyKadValue1(Val) {
if(Val!=''){
readCarderVal(p_jsonObject,Val); 
}

} 
var myWindow;
var myWindow1;
function callMykadReader(Calledfrom)
	{
	var retVal = 	new String();
	var dialogHeight= "10" ;
	var dialogTop = "75" ;
	var dialogWidth	= "10" ;
	var status = "no"; 
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	var left = (screen.width/2)-(dialogWidth/2)-100;
	var top = (screen.height/2)-(dialogHeight/2)-100;
	myWindow=window.open('../../eMP/jsp/PapServiceMyKad.jsp?func_name='+Calledfrom,'_blank', 'toolbar=no,status=no,menubar=no,scrollbars=no,resizable=no,left='+left+', top='+top+', width=350, height=170, visible=none', '');
 	}
	function closeit() {
    myWindow.close();
}

function MykadReader(jsonObject){
		var arr = ""; 
		var publicData="";
		var retVal="false";
		var url = "";
		var fingerIndex="";
		var validationStatus=false;
		var AuthenticationStatus=false;
		//var jsonObject="";
		//Window Open Starts
		var dialogHeight= "20" ;
		var dialogWidth	= "30" ;
		var dialogTop	= "50" ;
		var status = "no";
		var left = (screen.width/2)-(dialogWidth/2)-100;
		//var top = (screen.height/2)-(dialogHeight/2)-100;
		var top ="90";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop+"; left="+left+"; top="+top+";";
		var biometric_authentication_yn=document.forms[0].biometric_authentication_yn.value;
	//	alert("biometric_authentication_yn : "+biometric_authentication_yn);
		  AuthenticationStatus=jsonObject.AuthenticationStatus;	
	//  alert('AuthenticationStatus : '+AuthenticationStatus);
	  if(AuthenticationStatus==true){
				if(biometric_authentication_yn=='Y') 
					{
					fingerIndex=  jsonObject.PublicData.FingerData[0].FingerIndex;
					if(fingerIndex!="0")
						{					
						var dialogHeight= "50" ;
						var dialogWidth	= "150" ;
						var left1 = (screen.width/2)-(dialogWidth/2)-100;
						var top1 = (screen.height/2)-(dialogHeight/2)-100; 
						myWindow1=window.open('../../eMP/jsp/BiometricAuthenticationPopup.jsp?step=01&fingerIndex='+fingerIndex,'_blank', 'toolbar=no,status=no,menubar=no,scrollbars=no,resizable=no,left='+left1+', top='+top1+', width=450, height=330, visible=none', '');
			 			if(retVal==undefined)
							{
							retVal='false'
							readCarderVal(p_jsonObject,retVal)
							}
						}	
					else {
							readCarderVal(p_jsonObject,'true') // This is called for fingerprint with 0 Value
					}						
					}  
				else 
					{
					retVal='true';	
					 readCarderVal(p_jsonObject,retVal)
					}
				}
				
	}
function readCarderVal(p_jsonObject,retVal) {
	var jsonObject=JSON.parse(p_jsonObject);
			if(retVal=="true"){
				var fullname = trimString(jsonObject.PublicData.FullName);
				var fns = fullname.split(" ");
				first_name=fns[0];
				second_name=fns[1];
				third_name=fns[2];
				family_name=fns[5]; 
				name_prefix		= trimString(jsonObject.PublicData.Title);			
				gender_val		= trimString(jsonObject.PublicData.Sex);
				nric_val		= trimString(jsonObject.PublicData.IdNumber);
				dob_val			= trimString(jsonObject.PublicData.DateOfBirth);
				addr_line_1		= trimString(jsonObject.PublicData.HomeAddressFlatNumber) +","+ trimString(jsonObject.PublicData.HomeAddressBuildingName) +","+ trimString(jsonObject.PublicData.HomeAddressStreet) +","+ trimString(jsonObject.PublicData.HomeAddressStreet) +","+ trimString(jsonObject.PublicData.HomeAddressAreaCode);
				mobile_no		= trimString(jsonObject.PublicData.HomeAddressMobilePhoneNumber);
				passport_no		= trimString(jsonObject.PublicData.PassportNumber);
				passport_exp	= trimString(jsonObject.PublicData.PassportExpiryDate);
				nationality_val	= trimString(jsonObject.PublicData.NationalityCode);
				country_val		= trimString(jsonObject.PublicData.PassportCountryCode);
		/*	alert('fullname : '+fullname);
			alert('name_prefix : '+name_prefix);
			alert('gender_val : '+gender_val);
			alert('nric_val : '+nric_val);
			alert('dob_val : '+dob_val);
			alert('addr_line_1 : '+addr_line_1);
			alert('mobile_no : '+mobile_no);
			alert('passport_no : '+passport_no);
			alert('passport_exp : '+passport_exp);
			alert('nationality_val : '+nationality_val);
			alert('country_val : '+country_val); 
  alert('p_inst : '+p_inst); */
 
			 var flg_pop_dat=0;
			 if(p_inst=='NC'){  
				if(flg_pop_dat==0){
					//alert('======');
					document.getElementById("national_id_no").value=nric_val;
					document.getElementById("national_id_no").focus();
					//setTimeout("document.forms[0].national_id_no.blur()",500);
				}else{
					document.forms[0].txtSmartcard_dup.value="1";					
				}
			setTimeout("populate_smart_crd_data_01('"+nric_val+"','"+name_prefix+"','"+first_name+"','"+second_name+"','"+third_name+"','"+family_name+"','"+dob_val+"','"+dob_val+"','"+gender_val+"','"+nationality_val+"','"+addr_line_1+"','"+addr_line_2+"','"+addr_line_3+"','"+country_val+"','"+mobile_no+"','"+passport_no+"','"+passport_exp+"','"+flg_pop_dat+"','"+p_Calledfrom+"','"+p_inst+"')",1000);
			}
			if(p_inst=='PS' ){ 
				if(flg_pop_dat==0){
					//Commented below by Ashwin K for AAKH-CRF-0150
					//document.getElementById("National_Id_No").value=nric_val;
					document.getElementById("Contact_No").value=mobile_no; //Added by Ashwin K for AAKH-CRF-0150
					document.getElementById("Contact_No").focus();
					setTimeout("document.forms[0].National_Id_No.blur()",200);
				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}
				
				setTimeout("populate_smart_crd_data_ps_01('"+nric_val+"','"+name_prefix+"','"+first_name+"','"+second_name+"','"+third_name+"','"+family_name+"','"+dob_val+"','"+dob_val+"','"+gender_val+"','"+nationality_val+"','"+addr_line_1+"','"+addr_line_2+"','"+addr_line_3+"','"+country_val+"','"+mobile_no+"','"+passport_no+"','"+passport_exp+"','"+flg_pop_dat+"','"+p_Calledfrom+"','"+p_inst+"')",2000);
				
			}
 
				if(p_Calledfrom=='AE' ){ // Register Attendance
				if(flg_pop_dat==0){
					document.getElementById("National_Id_No").value=nric_val;
					document.getElementById("National_Id_No").focus();
					setTimeout(document.getElementById("National_Id_No").blur(),200);					

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

				setTimeout("populate_smart_crd_data_01('"+nric_val+"','"+name_prefix+"','"+first_name+"','"+second_name+"','"+third_name+"','"+family_name+"','"+dob_val+"','"+dob_val+"','"+gender_val+"','"+nationality_val+"','"+addr_line_1+"','"+addr_line_2+"','"+addr_line_3+"','"+country_val+"','"+mobile_no+"','"+passport_no+"','"+passport_exp+"','"+flg_pop_dat+"','"+p_Calledfrom+"','"+p_inst+"')",1000);
				

			}
			if(p_Calledfrom=='OAAP' ){ // book appt

				if(flg_pop_dat==0){
					document.getElementById("national_id_no").value=nric_val;
					document.getElementById("national_id_no").focus();
					setTimeout(document.getElementById("national_id_no").blur(),200);			

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

				setTimeout("populate_smart_crd_data_01('"+nric_val+"','"+name_prefix+"','"+first_name+"','"+second_name+"','"+third_name+"','"+family_name+"','"+dob_val+"','"+dob_val+"','"+gender_val+"','"+nationality_val+"','"+addr_line_1+"','"+addr_line_2+"','"+addr_line_3+"','"+country_val+"','"+mobile_no+"','"+passport_no+"','"+passport_exp+"','"+flg_pop_dat+"','"+p_Calledfrom+"','"+p_inst+"')",1000);
				

			}
				
			if(p_Calledfrom=='VSTREG'  || p_Calledfrom=='REFQUR' || p_Calledfrom=='WTMGMT'){ // Visit registration,Referral query
				if(flg_pop_dat==0){
					document.getElementById("national_id_no").value=nric_val;
					document.getElementById("national_id_no").focus();
					setTimeout(document.getElementById("national_id_no").blur(),200);				

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

				setTimeout("populate_smart_crd_data_01('"+nric_val+"','"+name_prefix+"','"+first_name+"','"+second_name+"','"+third_name+"','"+family_name+"','"+dob_val+"','"+dob_val+"','"+gender_val+"','"+nationality_val+"','"+addr_line_1+"','"+addr_line_2+"','"+addr_line_3+"','"+country_val+"','"+mobile_no+"','"+passport_no+"','"+passport_exp+"','"+flg_pop_dat+"','"+p_Calledfrom+"','"+p_inst+"')",1000);
				

			}
			if(p_Calledfrom=='REGREF' ){ // Refferal Regn
				if(flg_pop_dat==0){
					document.getElementById("national_id_no").value=nric_val;
					document.getElementById("national_id_no").focus();
					setTimeout(document.getElementById("national_id_no").blur(),200);				

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

				setTimeout("populate_smart_crd_data_01('"+nric_val+"','"+name_prefix+"','"+first_name+"','"+second_name+"','"+third_name+"','"+family_name+"','"+dob_val+"','"+dob_val+"','"+gender_val+"','"+nationality_val+"','"+addr_line_1+"','"+addr_line_2+"','"+addr_line_3+"','"+country_val+"','"+mobile_no+"','"+passport_no+"','"+passport_exp+"','"+flg_pop_dat+"','"+p_Calledfrom+"','"+p_inst+"')",1000);
				

			}

			if(p_Calledfrom=='AE' ){ // Register Attendance
				if(flg_pop_dat==0){
					document.getElementById("National_Id_No").value=nric_val;
					document.getElementById("National_Id_No").focus();
					setTimeout(document.getElementById("National_Id_No").blur(),200);					

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

				setTimeout("populate_smart_crd_data_01('"+nric_val+"','"+name_prefix+"','"+first_name+"','"+second_name+"','"+third_name+"','"+family_name+"','"+dob_val+"','"+dob_val+"','"+gender_val+"','"+nationality_val+"','"+addr_line_1+"','"+addr_line_2+"','"+addr_line_3+"','"+country_val+"','"+mobile_no+"','"+passport_no+"','"+passport_exp+"','"+flg_pop_dat+"','"+p_Calledfrom+"','"+p_inst+"')",1000);
				

			}

			if(p_Calledfrom=='WTLST' ){ // Create Waitlist
				if(flg_pop_dat==0){
					document.getElementById("national_id_no").value=nric_val;
					document.getElementById("national_id_no").focus();
					setTimeout(document.getElementById("national_id_no").blur(),200);				

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

				setTimeout("populate_smart_crd_data_01('"+nric_val+"','"+name_prefix+"','"+first_name+"','"+second_name+"','"+third_name+"','"+family_name+"','"+dob_val+"','"+dob_val+"','"+gender_val+"','"+nationality_val+"','"+addr_line_1+"','"+addr_line_2+"','"+addr_line_3+"','"+country_val+"','"+mobile_no+"','"+passport_no+"','"+passport_exp+"','"+flg_pop_dat+"','"+p_Calledfrom+"','"+p_inst+"')",1000);
			}

			if(p_Calledfrom=='IPBOOKING' ){ // IP Booking
				if(flg_pop_dat==0){
					document.getElementById("national_id_no").value=nric_val;
					document.getElementById("national_id_no").focus();
					setTimeout(document.getElementById("national_id_no").blur(),200);			

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

				setTimeout("populate_smart_crd_data_01('"+nric_val+"','"+name_prefix+"','"+first_name+"','"+second_name+"','"+third_name+"','"+family_name+"','"+dob_val+"','"+dob_val+"','"+gender_val+"','"+nationality_val+"','"+addr_line_1+"','"+addr_line_2+"','"+addr_line_3+"','"+country_val+"','"+mobile_no+"','"+passport_no+"','"+passport_exp+"','"+flg_pop_dat+"','"+p_Calledfrom+"','"+p_inst+"')",1000);
			}
			
			//Added by Ashwin K for AAKH-CRF-0150
			if(p_funcname == "01")
			{
			if(first_name  == "" || first_name == null)
				{
					first_name = " ";
				}
				if(second_name  == "" || second_name == null)
				{
					second_name = " ";
				}
				if(third_name  == "" || third_name == null)
				{
					third_name = " ";
				}
				if(name_prefix  == "" || name_prefix == null)
				{
					name_prefix = " ";
				}

				if(family_name  == "" || family_name == null)
				{
					family_name = " ";
				}

				if(gender_val  == "" || gender_val == null)
				{
					gender_val = " ";
				}

				if(nric_val  == "" || nric_val == null)
				{
					nric_val = " ";
				}

				if(dob_val  == "" || dob_val == null)
				{
					dob_val = " ";
				}

				if(addr_line_1  == "" || addr_line_1 == null)
				{
					addr_line_1 = " ";
				}

				if(mobile_no  == "" || mobile_no == null)
				{
					mobile_no = " ";
				}

				if(passport_no  == "" || passport_no == null)
				{
					passport_no = " ";
				}

				if(passport_exp  == "" || passport_exp == null)
				{
					passport_exp = " ";
				}

				if(nationality_val  == "" || nationality_val == null)
				{
					nationality_val = " ";
				}

				if(country_val  == "" || country_val == null)
				{
					country_val = " ";
				}

				if(emirates  == "" || emirates == null)
				{
					emirates = " ";
				}
			
				retdata = nric_val+"!~"+mobile_no+"!~"+first_name+"!~"+second_name+"!~"+third_name+"!~"+name_prefix+"!~"+family_name+"!~"+gender_val+"!~"+dob_val+"!~"+addr_line_1+"!~"+passport_no+"!~"+passport_exp+"!~"+nationality_val+"!~"+country_val+"!~"+emirates;
				return retdata;
			} 
			//Ended by Ashwin K for AAKH-CRF-0150
		 }
	//	 else{
		//	var val = getMessage("SMRT_CRD_FL_UA",'MP');			
	//var val =  "Card Reading Failed.  Please check the again";			
	//		alert(val);
	//	}

}
function populate_smart_crd_data_01(nric_val,name_prefix,first_name,second_name,third_name,family_name,dob_val,dob_val,gender_val,nationality_val,addr_line_1,addr_line_2,addr_line_3,country_val,mobile_no,passport_no,passport_exp,flg_pop_dat,Calledfrom,p_inst){
 	if(document.forms[0].txtSmartcard_dup.value=="1"){

		if(document.forms[0].national_id_no.value==''){
			/* checkNatioanlity.jsp identified duplicate NRIC  */
		}else{
			set_values_01(nric_val,name_prefix,first_name,second_name,third_name,family_name,dob_val,dob_val,gender_val,nationality_val,addr_line_1,addr_line_2,addr_line_3,country_val,mobile_no,passport_no,passport_exp,flg_pop_dat,Calledfrom,p_inst);
		}	
	
	}else if(document.forms[0].txtSmartcard_dup.value=="D"){
	}else{
			setTimeout("populate_smart_crd_data_01('"+nric_val+"','"+name_prefix+"','"+first_name+"','"+second_name+"','"+third_name+"','"+family_name+"','"+dob_val+"','"+dob_val+"','"+gender_val+"','"+nationality_val+"','"+addr_line_1+"','"+addr_line_2+"','"+addr_line_3+"','"+country_val+"','"+mobile_no+"','"+passport_no+"','"+passport_exp+"','"+flg_pop_dat+"','"+Calledfrom+"','"+p_inst+"')",3000);

	}

}


function set_values_01(nric_val,name_prefix,first_name,second_name,third_name,family_name,dob_val,dob_val,gender_val,nationality_val,addr_line_1,addr_line_2,addr_line_3,country_val,mobile_no,passport_no,passport_exp,flg_pop_dat,Calledfrom,p_inst){
 
		if (document.forms[0].name_prefix){
			if(name_prefix!=''){
				document.forms[0].name_prefix.value=name_prefix;
			}else{
				document.forms[0].name_prefix.value='';
			}
		}

		if (document.forms[0].first_name){
			if(first_name.length > document.getElementById("first_name").maxLength){
				first_name=first_name.substr(0,document.getElementById("first_name").maxLength);
				
			}	
			document.forms[0].first_name.value=first_name;
			document.forms[0].first_name.focus();
			document.forms[0].first_name.blur();
		}

		if (document.forms[0].second_name){
			if(second_name.length > document.getElementById("second_name").maxLength){
				second_name=second_name.substr(0,document.getElementById("second_name").maxLength);
			}

			document.forms[0].second_name.value=second_name;
			document.forms[0].second_name.focus();
			document.forms[0].second_name.blur();
		}
			

		if (document.forms[0].third_name){
			if(third_name.length > document.getElementById("third_name").maxLength){
				third_name=third_name.substr(0,document.getElementById("third_name").maxLength);
			}

			document.forms[0].third_name.value=third_name;
			document.forms[0].third_name.focus();
			document.forms[0].third_name.blur();
		}
			

		if (document.forms[0].family_name){
			if(family_name.length > document.getElementById("family_name").maxLength){
				family_name=family_name.substr(0,document.getElementById("family_name").maxLength);
			}

			document.forms[0].family_name.value=family_name;
			document.forms[0].family_name.focus();
			document.forms[0].family_name.blur();
		}
			
		if(dob_val!=''){
			temp_arr=dob_val.split("/");
			dob_val=temp_arr[0]+"/"+temp_arr[1]+"/"+temp_arr[2];
		}
		 
		document.forms[0].date_of_birth.value=dob_val;

		if(document.forms[0].date_of_birth.disabled) {
			document.forms[0].date_of_birth.disabled	= false;
			document.forms[0].age_or_dob.checked		= false;
			document.forms[0].age_or_dob.onclick();
		}

		document.forms[0].date_of_birth.focus();
		document.forms[0].date_of_birth.blur();

		if(gender_val=='M' || gender_val=='F' ||gender_val=='U'){
			document.forms[0].sex.value=gender_val;
		}else{
			document.forms[0].sex.value='';
		}
	

		if (document.getElementById("r_addr_line1")){
			if(addr_line_1.length > document.getElementById("r_addr_line1").maxLength){
				addr_line_1=addr_line_1.substr(0,document.getElementById("r_addr_line1").maxLength);
			}

			document.getElementById("r_addr_line1").value=addr_line_1;			
		}

		if (document.getElementById("r_addr_line2")){
			if(addr_line_2.length > document.getElementById("r_addr_line2").maxLength){
				addr_line_2=addr_line_2.substr(0,document.getElementById("r_addr_line2").maxLength);
			}

			document.getElementById("r_addr_line2").value=addr_line_2;			
		}

		if (document.getElementById("r_addr_line3")){
			if(addr_line_3.length > document.getElementById("r_addr_line3").maxLength){
				addr_line_3=addr_line_3.substr(0,document.getElementById("r_addr_line3").maxLength);
			}

			document.getElementById("r_addr_line3").value=addr_line_3;			
		}

		if (document.getElementById("alt_id1_no")){
			document.getElementById("alt_id1_no").value=passport_no;
		}
		if(passport_exp!=''){
			temp_arr=passport_exp.split("/");
			passport_exp=temp_arr[1]+"/"+temp_arr[0]+"/"+temp_arr[2];
		}

		if (document.getElementById("alt_id1_exp_date")){
			document.getElementById("alt_id1_exp_date").value=passport_exp;
		}

		if (document.getElementById("contact1_no")){
			document.getElementById("contact1_no").value=mobile_no;
		}

		if (document.getElementById("contact2_no")){
			document.getElementById("contact2_no").value=mobile_no;
		}
			if(Calledfrom=='OAAP'){
				function_name="BOOK_APPT";
				document.forms[0].addr_line1.value=addr_line_1;
			//	document.forms[0].addr_line2.value=addr_2;
			//	document.forms[0].addr_line3.value=addr_3;

				 
			}
		if(Calledfrom=='REGREF' || Calledfrom=='WTLST' || Calledfrom=='IPBOOKING'){
				if(Calledfrom=='REGREF'){
					function_name="REGREF";
				}

				if(Calledfrom=='WTLST'){
					function_name="WTLST";
				}

				if(Calledfrom=='IPBOOKING'){
					function_name="IPBOOKING";
				}

				document.forms[0].addr_line1.value=addr_line_1;
			//	document.forms[0].addr_line2.value=addr_2;
			//	document.forms[0].addr_line3.value=addr_3;
 
			}
		
		if(p_inst=='NC'){
			function_name="PAT_REGN";
			HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/populateSmartCard.jsp'><input type='hidden' name='p_inst' id='p_inst' value=\""+p_inst+"\"><input type='hidden' name='Calledfrom' id='Calledfrom' value=\""+Calledfrom+"\"><input type='hidden' name='nationality_desc' id='nationality_desc' value=\""+nationality_val+"\"><input type='hidden' name='country_desc' id='country_desc' value=\""+country_val+"\"><input type='hidden' name='nric_val' id='nric_val' value=\""+nric_val+"\"><input type='hidden' name='nric' id='nric' value=\""+flg_pop_dat+"\"><input type='hidden' name='caller_form' id='caller_form' value='01'>";  
			parent.parent.messageFrame.document.write(HTMLVal);
			parent.parent.messageFrame.document.form1.submit();
		}								
}

function clear_smart_card_values_01(Calledfrom,p_inst){
	
		document.forms[0].national_id_no.value='';
		
		
		if (document.forms[0].name_prefix){			
			document.forms[0].name_prefix.value='';
		}

		if (document.forms[0].first_name){
			document.forms[0].first_name.value='';
			document.forms[0].first_name.focus();
			document.forms[0].first_name.blur();
		}

		if (document.forms[0].second_name){
			document.forms[0].second_name.value='';
			document.forms[0].second_name.focus();
			document.forms[0].second_name.blur();
		}
			

		if (document.forms[0].third_name){
			document.forms[0].third_name.value='';
			document.forms[0].third_name.focus();
			document.forms[0].third_name.blur();
		}
			

		if (document.forms[0].family_name){
			document.forms[0].family_name.value='';
			document.forms[0].family_name.focus();
			document.forms[0].family_name.blur();
		}
			
		if(document.forms[0].date_of_birth)
		{
			document.forms[0].date_of_birth.value='';
			if(document.forms[0].date_of_birth.disabled) {
				document.forms[0].date_of_birth.disabled	= false;
				document.forms[0].age_or_dob.checked		= false;
				document.forms[0].age_or_dob.onclick();
			}
			document.forms[0].date_of_birth.focus();
			document.forms[0].date_of_birth.blur();
		}
		
		if(document.forms[0].sex){
			document.forms[0].sex.value='';
		}
		
	

		if (document.forms[0].r_addr_line1){
			document.forms[0].r_addr_line1.value='';			
		}

		if (document.forms[0].r_addr_line2){
			document.forms[0].r_addr_line2.value='';			
		}

		if (document.forms[0].r_addr_line3){
			document.forms[0].r_addr_line3.value='';			
		}

		if (document.forms[0].alt_id1_no){
			document.forms[0].alt_id1_no.value='';
		}

		if (document.forms[0].alt_id1_exp_date){
			document.forms[0].alt_id1_exp_date.value='';
		}

		if (document.forms[0].contact1_no){
			document.forms[0].contact1_no.value='';
		}
		if (document.forms[0].contact2_no){
			document.forms[0].contact2_no.value='';
		}

		if (document.forms[0].nationality_desc){
			document.forms[0].nationality_desc.value='';
			if(document.forms[0].nationality_code)
				document.forms[0].nationality_code.value='';					
		}

		if (document.forms[0].r_country_desc){
			document.forms[0].r_country_desc.value='';
			document.forms[0].r_country_code.value='';
		}
		
	
}


function populate_smart_crd_data_ps_01(nric_val,name_prefix,first_name,second_name,third_name,family_name,dob_val,dob_val,gender_val,nationality_val,addr_line_1,addr_line_2,addr_line_3,country_val,mobile_no,passport_no,passport_exp,flg_pop_dat,Calledfrom,p_inst){

	
	var function_name="PS";
	
	if(document.forms[0].txtSmartcard_dup.value=="1"){

		//if(flg_pop_dat==0){

			//if(document.forms[0].National_Id_No.value==''){
				if(document.forms[0].Contact_No.value==''){
				// checkNatioanlity.jsp identified duplicate NRIC  
			}else{
				
				if(document.forms[0].First_Name.value!=''){
					// Data exists for the NRIC in XF_PERSON   				
				}else{
					// populate data from text file 

					if (document.forms[0].name_prefix){
						if(name_prefix!=''){
							document.forms[0].name_prefix.value=name_prefix;
						}else{
							document.forms[0].name_prefix.value='';
						}
					}

					if (document.forms[0].First_Name){
						if(first_name.length > document.getElementById("First_Name").maxLength){
							first_name=first_name.substr(0,document.getElementById("First_Name").maxLength);
							
						}	
						document.forms[0].First_Name.value=first_name;
						document.forms[0].First_Name.focus();
						document.forms[0].First_Name.blur();
					}

					if (document.forms[0].Second_Name){
						if(second_name.length > document.getElementById("Second_Name").maxLength){
							second_name=second_name.substr(0,document.getElementById("Second_Name").maxLength);
						}

						document.forms[0].Second_Name.value=second_name;
						document.forms[0].Second_Name.focus();
						document.forms[0].Second_Name.blur();
					}
			

					if (document.forms[0].Third_Name){
						if(third_name.length > document.getElementById("Third_Name").maxLength){
							third_name=third_name.substr(0,document.getElementById("Third_Name").maxLength);
						}

						document.forms[0].Third_Name.value=third_name;
						document.forms[0].Third_Name.focus();
						document.forms[0].Third_Name.blur();
					}
						

					if (document.forms[0].Family_Name){
						if(family_name.length > document.getElementById("Family_Name").maxLength){
							family_name=family_name.substr(0,document.getElementById("Family_Name").maxLength);
						}

						document.forms[0].Family_Name.value=family_name;
						document.forms[0].Family_Name.focus();
						document.forms[0].Family_Name.blur();
					}
			
		
					if(dob_val!=''){
						temp_arr=dob_val.split("/");
						dob_val=temp_arr[1]+"/"+temp_arr[0]+"/"+temp_arr[2];
					}
					 
					document.forms[0].Dob.value=dob_val;
					//document.forms[0].Dob.focus();
					//document.forms[0].Dob.blur();

					if(gender_val=='M' || gender_val=='F' ||gender_val=='U'){
						document.forms[0].Sex.value=gender_val;
					}else{
						document.forms[0].Sex.value='';
					}
	

					if (document.getElementById("r_addr_line1")){
						if(addr_line_1.length > document.getElementById("r_addr_line1").maxLength){
							addr_line_1=addr_line_1.substr(0,document.getElementById("r_addr_line1").maxLength);
						}

						document.getElementById("r_addr_line1").value=addr_line_1;			
					}

					if (document.getElementById("r_addr_line2")){
						if(addr_line_2.length > document.getElementById("r_addr_line2").maxLength){
							addr_line_2=addr_line_2.substr(0,document.getElementById("r_addr_line2").maxLength);
						}

						document.getElementById("r_addr_line2").value=addr_line_2;			
					}

					if (document.getElementById("r_addr_line3")){
						if(addr_line_3.length > document.getElementById("r_addr_line3").maxLength){
							addr_line_3=addr_line_3.substr(0,document.getElementById("r_addr_line3").maxLength);
						}

						document.getElementById("r_addr_line3").value=addr_line_3;			
					}

					if (document.getElementById("alt_id1_no")){
						document.getElementById("alt_id1_no").value=passport_no;
					}

					if(passport_exp!=''){
						temp_arr=passport_exp.split("/");
						passport_exp=temp_arr[1]+"/"+temp_arr[0]+"/"+temp_arr[2];
					}
					if (document.getElementById("alt_id1_exp_date")){
						document.getElementById("alt_id1_exp_date").value=passport_exp;
					}

					if (document.getElementById("Contact_No")){
						document.getElementById("Contact_No").value=mobile_no;
					}

					if (document.getElementById("contact2_no")){
						document.getElementById("contact2_no").value=mobile_no;
					}


					HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/populateSmartCard.jsp'><input type='hidden' name='p_inst' id='p_inst' value=\""+p_inst+"\"><input type='hidden' name='Calledfrom' id='Calledfrom' value=\""+Calledfrom+"\"><input type='hidden' name='nationality_desc' id='nationality_desc' value=\""+nationality_val+"\"><input type='hidden' name='country_desc' id='country_desc' value=\""+country_val+"\"><input type='hidden' name='nric_val' id='nric_val' value=\""+nric_val+"\"><input type='hidden' name='nric' id='nric' value=\""+flg_pop_dat+"\"><input type='hidden' name='function_name' id='function_name' value=\""+function_name+"\"><input type='hidden' name='caller_form' id='caller_form' value='01'>";  
							
				
							
				parent.parent.frames[6].document.write(HTMLVal);
				parent.parent.frames[6].document.form1.submit();
				
					
			}
			
		}	
		
	}else if(document.forms[0].txtSmartcard_dup.value=="D"){
	}else{
			setTimeout("populate_smart_crd_data_ps_01('"+nric_val+"','"+name_prefix+"','"+first_name+"','"+second_name+"','"+third_name+"','"+family_name+"','"+dob_val+"','"+dob_val+"','"+gender_val+"','"+nationality_val+"','"+addr_line_1+"','"+addr_line_2+"','"+addr_line_3+"','"+country_val+"','"+mobile_no+"','"+passport_no+"','"+passport_exp+"','"+flg_pop_dat+"','"+Calledfrom+"','"+p_inst+"')",3000);

	}

}

function check_clear(){
	if(document.forms[0].National_Id_No.value==''){
		if(document.forms[0].Patient_Id.value==''){

			if (document.forms[0].name_prefix){			
				document.forms[0].name_prefix.value='';
			}

			if (document.forms[0].First_Name){
				document.forms[0].First_Name.value='';
				
			}

			if (document.forms[0].Second_Name){
				document.forms[0].Second_Name.value='';
				
			}
				

			if (document.forms[0].Third_Name){
				document.forms[0].Third_Name.value='';
				
			}
				

			if (document.forms[0].Family_Name){
				document.forms[0].Family_Name.value='';
				
			}
				
			
			document.forms[0].Dob.value='';
			document.forms[0].Dob.focus();
			document.forms[0].Dob.blur();

			document.forms[0].Sex.value='';
			
		

			if (document.forms[0].r_addr_line1){
				document.forms[0].r_addr_line1.value='';			
			}

			if (document.forms[0].r_addr_line2){
				document.forms[0].r_addr_line2.value='';			
			}

			if (document.forms[0].r_addr_line3){
				document.forms[0].r_addr_line3.value='';			
			}

			if (document.forms[0].alt_id1_no){
				document.forms[0].alt_id1_no.value='';
			}

			if (document.forms[0].alt_id1_exp_date){
				document.forms[0].alt_id1_exp_date.value='';
			}

			if (document.forms[0].contact1_no){
				document.forms[0].contact1_no.value='';
			}
			if (document.forms[0].contact2_no){
				document.forms[0].contact2_no.value='';
			}

			if (document.forms[0].nationality_desc){
				document.forms[0].nationality_desc.value='';
				document.forms[0].nationality_desc_hid.value='';					
				document.forms[0].Nationality_hid.value='';					
			}

			if (document.forms[0].r_country_desc){
				document.forms[0].r_country_desc.value='';
				document.forms[0].r_country_code.value='';
			}
		
		}
	}
}


function clear_smart_card_values_ps_01(Calledfrom,p_inst){

		document.forms[0].National_Id_No.value='';

	
		if (document.forms[0].name_prefix){			
			document.forms[0].name_prefix.value='';			
		}

		if (document.forms[0].First_Name){
			document.forms[0].First_Name.value='';
			document.forms[0].First_Name.focus();
			document.forms[0].First_Name.blur();
		}

		if (document.forms[0].Second_Name){
			document.forms[0].Second_Name.value='';
			document.forms[0].Second_Name.focus();
			document.forms[0].Second_Name.blur();
		}


		if (document.forms[0].Third_Name){
			document.forms[0].Third_Name.value='';
			document.forms[0].Third_Name.focus();
			document.forms[0].Third_Name.blur();
		}
			

		if (document.forms[0].Family_Name){
			document.forms[0].Family_Name.value='';
			document.forms[0].Family_Name.focus();
			document.forms[0].Family_Name.blur();
		}


		if(document.forms[0].Dob)	 
		{
			document.forms[0].Dob.value='';
			document.forms[0].Dob.focus();
			document.forms[0].Dob.blur();
		}

		if(document.forms[0].Sex){
		document.forms[0].Sex.value='';
		}
		


		if (document.getElementById("r_addr_line1")){
			
			document.getElementById("r_addr_line1").value='';			
		}

		if (document.getElementById("r_addr_line2")){
			

			document.getElementById("r_addr_line2").value='';			
		}

		if (document.getElementById("r_addr_line3")){
			

			document.getElementById("r_addr_line3").value='';			
		}

		if (document.getElementById("alt_id1_no")){
			document.getElementById("alt_id1_no").value='';
		}

		
		if (document.getElementById("alt_id1_exp_date")){
			document.getElementById("alt_id1_exp_date").value='';
		}

		if (document.getElementById("Contact_No")){
			document.getElementById("Contact_No").value='';
		}

		if (document.getElementById("contact2_no")){
			document.getElementById("contact2_no").value='';


		}

		if (document.forms[0].nationality_desc){
				document.forms[0].nationality_desc.value='';
				document.forms[0].nationality_desc_hid.value='';					
				document.forms[0].Nationality_hid.value='';					
		}

		if (document.forms[0].r_country_desc){
			document.forms[0].r_country_desc.value='';
			document.forms[0].r_country_code.value='';
		}


}
 function isEmpty(obj) {
    for(var prop in obj) {
        if(obj.hasOwnProperty(prop))
            return false;
    }

    return true;
}

