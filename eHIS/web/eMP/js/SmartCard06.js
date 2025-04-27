var p_Calledfrom;
var p_inst;
var p_theLocation; 
var p_subFrame; 
var p_opCall;
var from_OA='N';


function ReadSmartCard_06(Calledfrom,inst,theLocation,subFrame,opCall){
	if(Calledfrom =='top.f_query_add_mod'){
		Calledfrom='OAAP'
	}
	
	if(Calledfrom =='parent.frames[1].frames[0]'){
		Calledfrom ='REGREF';
		
		if(document.getElementById('p_calling_function').value=='OA_BOOK_APPT'){
			from_OA='Y';
		}
	}

	if(Calledfrom =='parent.frames[1]'){
		if(document.getElementById('call_function')){
			if(document.getElementById('call_function').value="IP_Booking"){
				Calledfrom ='IPBOOKING';
			}
		}else{
			Calledfrom ='WTLST';

		}
	}

	if(Calledfrom =='CC' && inst=='NC'){
		if(document.getElementById('noshow_bkng_period')){
			Calledfrom='CCRB';
		}else if(document.getElementById('function_id')){
			Calledfrom='WTMGMT';
		}else if(document.getElementById('functionId')){
			Calledfrom='VSTREG';
		}else{
			Calledfrom='REFQUR';
		}
	}

	p_Calledfrom=Calledfrom;
	p_inst=inst;
	p_theLocation=theLocation;
	p_subFrame=subFrame;
	p_opCall=opCall;
	//if(Calledfrom=='P' || Calledfrom=='OAAP' || Calledfrom=='PS' ||Calledfrom=='VSTREG' || Calledfrom =='REGREF' || Calledfrom =='REFQUR' || Calledfrom =='AE'|| Calledfrom=='CP' ){
		if(inst=='NC'){
			clear_smart_card_values_06(Calledfrom,inst);
		}
		if(inst=='PS' ){
			clear_smart_card_values_ps_06(Calledfrom,inst);
		}
	callIrisMykadReader(Calledfrom);

}
function getMyKadValue(jsonVal) {
	closeit();
if(jsonVal!=''){
	IrisMykadReader(jsonVal);
}

} 
var myWindow;
function callIrisMykadReader(Calledfrom)
	{
	var retVal = 	new String();
	var dialogHeight= "10" ;
	var dialogTop = "75" ;
	var dialogWidth	= "10" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
//	window.open('../../eMP/jsp/IRISMyKad.jsp');
	//myWindow=window.open('../../eMP/jsp/IRISMyKad.jsp','_blank', 'toolbar=no,status=no,menubar=no,scrollbars=no,resizable=no,left=10000, top=10000, width=10, height=10, visible=none', '');
	var left = (screen.width/2)-(dialogWidth/2)-100;
	var top = (screen.height/2)-(dialogHeight/2)-100;
//	myWindow=window.open('../../eMP/jsp/IRISMyKad.jsp','_blank', 'toolbar=no,status=no,menubar=no,scrollbars=no,resizable=no,left='+left+', top='+top+', width=5, height=5, visible=none', '');
	myWindow=window.open('../../eMP/jsp/IRISMyKad.jsp?func_name='+Calledfrom,'_blank', 'toolbar=no,status=no,menubar=no,scrollbars=no,resizable=no,left='+left+', top='+top+', width=350, height=150, visible=none', '');
//	myWindow.blur();
 
	// myWindow = window.open("../../eMP/jsp/IRISMyKad.jsp", "", "width=10,height=10");
	
	}
	function closeit() {
    myWindow.close();
}

function IrisMykadReader(jsonVal){
	var usr_ID;	
	var my_Kid="N";
	try{
		var pat_name;
		var nric_no;
		var addr_1;
		var addr_2;
		var addr_3;
		var city_desc;
		var state_desc;
		var post_code;
		var b_date;
		var b_place;
		var citizen_yn;
		var race_desc;
		var religion_desc;
		var gender;
		var photo;
		var oth_alt_no;
		var b_birth_time;
		var alt_id_type_desc;
		//
		var birth_cert_no;
		var photopath ;
		var father_name;
		var father_ic_no;
		var father_doc_no;
		var father_doc_type;
		var mother_name;
		var mother_ic_no;
		if (jsonVal.BirthCertNum==undefined) {
			pat_name=jsonVal.Name;
			
			pat_name=pat_name.replace("                         "," ");
			pat_name=pat_name.replace("                        "," ");
			pat_name=pat_name.replace("                       "," ");
			pat_name=pat_name.replace("                     "," ");
			pat_name=pat_name.replace("                    "," ");
			pat_name=pat_name.replace("                   "," ");
			pat_name=pat_name.replace("                  "," ");
			pat_name=pat_name.replace("                 "," ");
			pat_name=pat_name.replace("                "," ");
			pat_name=pat_name.replace("               "," ");
			pat_name=pat_name.replace("              "," ");
			pat_name=pat_name.replace("             "," ");
			pat_name=pat_name.replace("            "," ");
			pat_name=pat_name.replace("           "," ");
			pat_name=pat_name.replace("          "," ");
			pat_name=pat_name.replace("         "," ");
			pat_name=pat_name.replace("        "," ");
			pat_name=pat_name.replace("       "," ");
			pat_name=pat_name.replace("      "," ");
			pat_name=pat_name.replace("     "," ");
			pat_name=pat_name.replace("    "," ");
			pat_name=pat_name.replace("   "," ");
			pat_name=pat_name.replace("  "," ");
			pat_name=	replaceQuotes(pat_name);
			nric_no=trimString(jsonVal.IDNum);
			nric_no=nric_no.replace(/-/g, '');
			addr_1=replaceQuotes(trimString(jsonVal.Address1));		 
			addr_2=replaceQuotes(trimString(jsonVal.Address2));		 
			addr_3=replaceQuotes(trimString(jsonVal.Address3));
			var post=jsonVal.PostcodeCity;
			post_code=post.split(' ')[0];
			city_desc=replaceQuotes(post.substring(post.indexOf(" ")+1));
		//	city_desc=trimString(jsonVal.Locality);
			state_desc=trimString(jsonVal.State);
			BirthDate=trimString(jsonVal.BirthDate);
			b_date=trimString(BirthDate.substring(6,8)+"/"+BirthDate.substring(4,6)+"/"+BirthDate.substring(0,4));
			b_place=trimString(jsonVal.BirthPlace);
			citizen_yn=trimString(jsonVal.Citizenship);
			race_desc=trimString(jsonVal.Race);
			religion_desc=trimString(jsonVal.Religion);
			gender=trimString(jsonVal.Gender);
			photo=trimString(jsonVal.Base64Photo);
			oth_alt_no=trimString(jsonVal.OldIDNum);
			alt_id_type_desc='Old IC';
			populate_Sekure_new_06(p_Calledfrom,p_inst,p_theLocation,p_subFrame,p_opCall,pat_name,nric_no,oth_alt_no,alt_id_type_desc,addr_1,addr_2,addr_3,city_desc,state_desc,post_code,b_date,b_place,citizen_yn,race_desc,religion_desc,gender,'','','','','','',photo,'','');
			}else if (jsonVal.BirthCertNum!=undefined){	
			pat_name=trimString(jsonVal.Name);
			pat_name=pat_name.replace("                         "," ");
			pat_name=pat_name.replace("                        "," ");
			pat_name=pat_name.replace("                       "," ");
			pat_name=pat_name.replace("                     "," ");
			pat_name=pat_name.replace("                    "," ");
			pat_name=pat_name.replace("                   "," ");
			pat_name=pat_name.replace("                  "," ");
			pat_name=pat_name.replace("                 "," ");
			pat_name=pat_name.replace("                "," ");
			pat_name=pat_name.replace("               "," ");
			pat_name=pat_name.replace("              "," ");
			pat_name=pat_name.replace("             "," ");
			pat_name=pat_name.replace("            "," ");
			pat_name=pat_name.replace("           "," ");
			pat_name=pat_name.replace("          "," ");
			pat_name=pat_name.replace("         "," ");
			pat_name=pat_name.replace("        "," ");
			pat_name=pat_name.replace("       "," ");
			pat_name=pat_name.replace("      "," ");
			pat_name=pat_name.replace("     "," ");
			pat_name=pat_name.replace("    "," ");
			pat_name=pat_name.replace("   "," ");
			pat_name=pat_name.replace("  "," ");
			pat_name=	replaceQuotes(pat_name);
			nric_no=trimString(jsonVal.IDNum);
			nric_no=nric_no.replace(/-/g, '');
			addr_1=replaceQuotes(trimString(jsonVal.Address1));
			addr_2=replaceQuotes(trimString(jsonVal.Address2));
			addr_3=replaceQuotes(trimString(jsonVal.Address3));
			city_desc=replaceQuotes(trimString(jsonVal.City));
			state_desc=replaceQuotes(trimString(jsonVal.State));
			post_code=trimString(jsonVal.Postcode);
			b_date=trimString(jsonVal.BirthDate);
			b_date=trimString(jsonVal.BirthDate.substring(6,8)+"/"+jsonVal.BirthDate.substring(4,6)+"/"+jsonVal.BirthDate.substring(0,4));
			b_birth_time=trimString(jsonVal.TimeOfBirth);
			b_place=trimString(jsonVal.BirthPlace1);
			if(b_place==''){
				b_place=trimString(jsonVal.BirthPlace1);
			}
			citizen_yn=trimString(jsonVal.Citizenship);
			gender=trimString(jsonVal.Gender);
			if(jsonVal.MotherRace!=undefined){
			race_desc=trimString(jsonVal.MotherRace);
			if(race_desc==''){
				race_desc=trimString(jsonVal.MotherRace);
			}
			}
			
			father_name=replaceQuotes(trimString(jsonVal.FatherName));
			father_ic_no=trimString(jsonVal.FatherIDNum);
			mother_name=replaceQuotes(trimString(jsonVal.MotherName));		
			mother_ic_no=trimString(jsonVal.MotherIDNum);
			oth_alt_no=trimString(jsonVal.BirthCertNum);
			father_doc_no=trimString(jsonVal.FatherDocNum);
			father_doc_type=trimString(jsonVal.FatherDocType);
			if(father_ic_no==''){
				father_ic_no=trimString(jsonVal.FatherIDNum);
			}
			if(father_doc_no==''){
				father_doc_no=trimString(jsonVal.FatherDocNum);
			}
			if(father_doc_type==''){
				father_doc_type=trimString(jsonVal.FatherDocType);
			}
		
			alt_id_type_desc='Birth Certificate';
			photo='';
			
			populate_Sekure_new_06(p_Calledfrom,p_inst,p_theLocation,p_subFrame,p_opCall,pat_name,nric_no,oth_alt_no,alt_id_type_desc,addr_1,addr_2,addr_3,city_desc,state_desc,post_code,b_date,b_place,citizen_yn,race_desc,religion_desc,gender,b_birth_time,birth_cert_no,father_name,father_ic_no,mother_name,mother_ic_no,photo,father_doc_no,father_doc_type);
        }else{			
            alert(jsonVal.Msg);
        }
		
        
	}catch(exception){
			alert(exception.description)
	}
	 MyKadWrapper = null;
	 InList = null;
	 InfoDataList = null;
		
}


function populate_Sekure_new_06(Calledfrom,inst,theLocation,subFrame,opCall,pat_name,nric_no,oth_alt_no,alt_id_type_desc,addr_1,addr_2,addr_3,city_desc,state_desc,post_code,b_date,b_place,citizen_yn,race_desc,religion_desc,gender,time_of_birth,birth_cert_no,father_name,father_ic_no,mother_name,mother_ic_no,photo,father_doc_no,father_doc_type){
			if(inst=='NC'){
				clear_smart_card_values_06(Calledfrom,inst);
			}
			if(inst=='PS' ){
				clear_smart_card_values_ps_06(Calledfrom,inst);
			}
					

			var flg_pop_dat=0;


			if(inst=='CP'){  
		//	var message='Do you want to overwrite the details ?';
		//	if(confirm(message))
		//	{
				if(flg_pop_dat==0){
					document.getElementById('national_id_no').value=nric_no;
					document.getElementById('national_id_no').focus();

					document.forms[0].national_id_no.blur();
					document.forms[0].txtSmartcard_dup.value="1";
					
									
				}else{
					document.forms[0].txtSmartcard_dup.value="1";					
			
				}

				
		//	} 
			setTimeout("populate_smart_crd_data_06('"+pat_name+"','"+nric_no+"','"+oth_alt_no+"','"+alt_id_type_desc+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"','"+photo+"','"+father_doc_no+"','"+father_doc_type+"')",1000);
			}
 
			
			if(inst=='NC'){  
				if(flg_pop_dat==0){
					document.getElementById('national_id_no').value=nric_no;
					document.getElementById('national_id_no').focus();

					document.forms[0].national_id_no.blur();
					document.forms[0].txtSmartcard_dup.value="1";
					
									
				}else{
					document.forms[0].txtSmartcard_dup.value="1";					
			
				}
		
				setTimeout("populate_smart_crd_data_06('"+pat_name+"','"+nric_no+"','"+oth_alt_no+"','"+alt_id_type_desc+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"','"+photo+"','"+father_doc_no+"','"+father_doc_type+"')",1000);
			}
			if(inst=='PS' || inst=='AE'){ 

				if(flg_pop_dat==0){
					document.getElementById('National_Id_No').value=nric_no;
					document.getElementById('National_Id_No').focus();
					document.forms[0].National_Id_No.blur();
				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
					
				}
				setTimeout("populate_smart_crd_data_ps_06('"+pat_name+"','"+nric_no+"','"+oth_alt_no+"','"+alt_id_type_desc+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"','"+photo+"','"+father_doc_no+"','"+father_doc_type+"')",2000);

			}


			if(Calledfrom=='OAAP' ){ // book appt

				if(flg_pop_dat==0){
					document.getElementById("national_id_no").value=nric_no;
					document.getElementById("national_id_no").focus();
					setTimeout(document.getElementById("national_id_no").blur(),200);					

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

				setTimeout("populate_smart_crd_data_06('"+pat_name+"','"+nric_no+"','"+oth_alt_no+"','"+alt_id_type_desc+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"','"+photo+"','"+father_doc_no+"','"+father_doc_type+"')",1000);
				

			}


			
			if(Calledfrom=='VSTREG'  || Calledfrom=='REFQUR' || Calledfrom=='WTMGMT'){ // Visit registration,Referral query
				if(flg_pop_dat==0){
					document.getElementById("national_id_no").value=nric_no;
					document.getElementById("national_id_no").focus();
					setTimeout(document.getElementById("national_id_no").blur(),200);				

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

				setTimeout("populate_smart_crd_data_06('"+pat_name+"','"+nric_no+"','"+oth_alt_no+"','"+alt_id_type_desc+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"','"+photo+"','"+father_doc_no+"','"+father_doc_type+"')",1000);
				

			}

			if(Calledfrom=='REGREF' ){ // Refferal Regn
				if(flg_pop_dat==0){
					document.getElementById("national_id_no").value=nric_no;
					document.getElementById("national_id_no").focus();
					setTimeout(document.getElementById("national_id_no").blur(),200);					

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

				setTimeout("populate_smart_crd_data_06('"+pat_name+"','"+nric_no+"','"+oth_alt_no+"','"+alt_id_type_desc+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"','"+photo+"','"+father_doc_no+"','"+father_doc_type+"')",1000);
				

			}

			if(Calledfrom=='AE' ){ // Register Attendance
				if(flg_pop_dat==0){
					document.getElementById("National_Id_No").value=nric_no;
					document.getElementById("National_Id_No").focus();
					setTimeout(document.getElementById("National_Id_No").blur(),200);					

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

				setTimeout("populate_smart_crd_data_06('"+pat_name+"','"+nric_no+"','"+oth_alt_no+"','"+alt_id_type_desc+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"','"+photo+"','"+father_doc_no+"','"+father_doc_type+"')",1000);
				

			}

			if(Calledfrom=='WTLST' ){ // Create Waitlist
				if(flg_pop_dat==0){
					document.getElementById("national_id_no").value=nric_no;
					document.getElementById("national_id_no").focus();
					setTimeout(document.getElementById("national_id_no").blur(),200);					

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

				setTimeout("populate_smart_crd_data_06('"+pat_name+"','"+nric_no+"','"+oth_alt_no+"','"+alt_id_type_desc+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"','"+photo+"','"+father_doc_no+"','"+father_doc_type+"')",1000);
			}

			if(Calledfrom=='IPBOOKING' ){ // IP Booking
				if(flg_pop_dat==0){
					document.getElementById("national_id_no").value=nric_no;
					document.getElementById("national_id_no").focus();
					setTimeout(document.getElementById("national_id_no").blur(),200);					

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

				setTimeout("populate_smart_crd_data_06('"+pat_name+"','"+nric_no+"','"+oth_alt_no+"','"+alt_id_type_desc+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"','"+photo+"','"+father_doc_no+"','"+father_doc_type+"')",1000);
			}
			


}

function populate_smart_crd_data_06(pat_name,nric_no,oth_alt_no,alt_id_type_desc,addr_1,addr_2,addr_3,city_desc,state_desc,post_code,b_date,b_place,citizen_yn,race_desc,religion_desc,gender,time_of_birth,birth_cert_no,father_name,father_ic_no,mother_name,mother_ic_no,flg_pop_dat,Calledfrom,inst,photo,father_doc_no,father_doc_type)
{ 

	if(document.forms[0].txtSmartcard_dup.value=="1"){

		if(document.forms[0].national_id_no.value==''){
			/* checkNatioanlity.jsp identified duplicate NRIC  */
		}else{

			set_values_06(pat_name,nric_no,oth_alt_no,alt_id_type_desc,addr_1,addr_2,addr_3,city_desc,state_desc,post_code,b_date,b_place,citizen_yn,race_desc,religion_desc,gender,time_of_birth,birth_cert_no,father_name,father_ic_no,mother_name,mother_ic_no,flg_pop_dat,Calledfrom,inst,photo,father_doc_no,father_doc_type);
		}	
	
	}else if(document.forms[0].txtSmartcard_dup.value=="D"){
		
	}else{

		setTimeout("populate_smart_crd_data_06('"+pat_name+"','"+nric_no+"','"+oth_alt_no+"','"+alt_id_type_desc+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"','"+photo+"','"+father_doc_no+"','"+father_doc_type+"')",3000);

	}

}


function set_values_06(pat_name,nric_no,oth_alt_no,alt_id_type_desc,addr_1,addr_2,addr_3,city_desc,state_desc,post_code,b_date,b_place,citizen_yn,race_desc,religion_desc,gender,time_of_birth,birth_cert_no,father_name,father_ic_no,mother_name,mother_ic_no,flg_pop_dat,Calledfrom,inst,photo,father_doc_no,father_doc_type){
 
			if (document.forms[0].family_name){

				if(pat_name.length > document.getElementById("family_name").maxLength){
					pat_name=pat_name.substr(0,document.getElementById("family_name").maxLength);
				}

				document.forms[0].family_name.value=pat_name;
				document.forms[0].family_name.focus();
				document.forms[0].family_name.blur();
			}
			

			if (document.getElementById("r_addr_line1")){
				if(addr_1.length > document.getElementById("r_addr_line1").maxLength){
					addr_1=addr_1.substr(0,document.getElementById("r_addr_line1").maxLength);
				}

				document.getElementById("r_addr_line1").value=addr_1;			
			}

			if (document.getElementById("r_addr_line2")){
				if(addr_2.length > document.getElementById("r_addr_line2").maxLength){
					addr_2=addr_2.substr(0,document.getElementById("r_addr_line2").maxLength);
				}

				document.getElementById("r_addr_line2").value=addr_2;			
			}

			if (document.getElementById("r_addr_line3")){
				if(addr_3.length > document.getElementById("r_addr_line3").maxLength){
					addr_3=addr_3.substr(0,document.getElementById("r_addr_line3").maxLength);
				}

				document.getElementById("r_addr_line3").value=addr_3;			
			}

			
			if(document.forms[0].date_of_birth){
				document.forms[0].date_of_birth.disabled=false;
				document.forms[0].date_of_birth.value=b_date;
				document.forms[0].date_of_birth.focus();
				setTimeout("document.forms[0].date_of_birth.blur()",2000);
			}

						
			if( document.forms[0].sex){
				if (gender == "LELAKI" || gender == "M" || gender == "L") {
					document.forms[0].sex.value='M';
				} else if (gender == "PEREMPUAN" || gender == "F" || gender == "P") {
					document.forms[0].sex.value='F';
				}else{
					 document.forms[0].sex.value='U';
				}
			}
			
			if( document.forms[0].gender){
				if (gender == "LELAKI" || gender == "M") {
					document.forms[0].gender.value='M';
				} else if (gender == "PEREMPUAN" || gender == "F") {
					document.forms[0].gender.value='F';
				}else{
					 document.forms[0].gender.value='U';
				}
			}

			
			if(document.forms[0].place_of_birth){
				if (b_place!=''){
					b_place=b_place.substring(0,30);	
				}
				document.forms[0].place_of_birth.value=b_place;				
			}

			if(time_of_birth!='' ){
				if( document.forms[0].b_time){
					
					var b_time=time_of_birth.split(/(?=(?:..)*$)/);
					document.forms[0].b_time.value=b_time[0]+":"+b_time[1];
				}				
			}
	
			/*if(birth_cert_no!='' ){
				if( document.forms[0].other_alt_id){
					document.forms[0].other_alt_id.value='08';
				}

				if( document.forms[0].other_alt_Id_text){
					document.forms[0].other_alt_Id_text.value=birth_cert_no;
				}
			}
			*/
		if(oth_alt_no!='' ){
				/*if( document.forms[0].other_alt_id){
					document.forms[0].other_alt_id.value='08';
				}*/

				if( document.forms[0].other_alt_Id_text){
					document.forms[0].other_alt_Id_text.value=oth_alt_no;
				}
			}
			

			var mother_yn="N";
			if(mother_name!='' ){
				if( document.forms[0].next_contact_name){
					document.forms[0].next_contact_name.value=mother_name.substr(0,30);
					mother_yn="Y";		
				}
			}			 
			
			
			if(mother_ic_no!='' ){
				if( document.forms[0].contact1_new_nat_id_no){
					document.forms[0].contact1_new_nat_id_no.value=mother_ic_no;
					
					if(parseInt(mother_ic_no.substr(0,2)) > parseInt(document.forms[0].ServerDate.value.substr(8,2))){
						document.forms[0].contact1_birth_date.value=mother_ic_no.substr(4,2)+"/"+mother_ic_no.substr(2,2)+"/19"+mother_ic_no.substr(0,2);
					}else{
						document.forms[0].contact1_birth_date.value=mother_ic_no.substr(4,2)+"/"+mother_ic_no.substr(2,2)+"/20"+mother_ic_no.substr(0,2);
					}
					
				}
			}
			 
			var father_yn="N";
			if(father_name!='' ){
				if( document.forms[0].first_contact_name){
					document.forms[0].first_contact_name.value=father_name.substr(0,30);
					father_yn="Y";	
				}
			}

			if(father_ic_no!='' ){
				if( document.forms[0].contact2_nat_id_no){
					document.forms[0].contact2_nat_id_no.value=father_ic_no;
				}
			}
			else if(father_doc_no!='' ){
			//		if( document.forms[0].notify_oth_alt_id_type){
			//		document.forms[0].notify_oth_alt_id_type.value=father_doc_type;
			//	}
					if( document.forms[0].notify_oth_alt_id_text){
					document.forms[0].notify_oth_alt_id_text.value=father_doc_no;
				}
				
			}

			var function_name="";

			if(Calledfrom=='R' || Calledfrom=='E'){
				Calledfrom='P';
			}

			if(Calledfrom=='P'){
				function_name="PAT_REGN";
				if(citizen_yn=='WARGANEGARA'){
					document.forms[0].citizen[0].checked=true;
					document.forms[0].citizen[1].checked=false;
					document.forms[0].citizen_yn.value='Y';
					change_stat_dis();
					
				}else{
					document.forms[0].citizen[1].checked=true;
					document.forms[0].citizen[0].checked=false;
					document.forms[0].citizen_yn.value='N';
					change_status();
				}
			}

			if(Calledfrom=='OAAP'){
				function_name="BOOK_APPT";
				document.forms[0].addr_line1.value=addr_1;
				document.forms[0].addr_line2.value=addr_2;
				document.forms[0].addr_line3.value=addr_3;

				if(citizen_yn=='WARGANEGARA'){
					document.forms[0].citizen_yn[0].checked=true;
					document.forms[0].citizen_yn[1].checked=false;
					document.forms[0].citizen_yn.value='Y';						
				}else{
					document.forms[0].citizen_yn[1].checked=true;
					document.forms[0].citizen_yn[0].checked=false;
					document.forms[0].citizen_yn.value='N';					
				}

				disable_Legal_If_Citzen();
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

				document.forms[0].addr_line1.value=addr_1;
				document.forms[0].addr_line2.value=addr_2;
				document.forms[0].addr_line3.value=addr_3;

				if(citizen_yn=='WARGANEGARA'){
					document.forms[0].citizen_yn[0].checked=true;
					document.forms[0].citizen_yn[1].checked=false;
					document.forms[0].citizen_yn.value='Y';						
				}else{
					document.forms[0].citizen_yn[1].checked=true;
					document.forms[0].citizen_yn[0].checked=false;
					document.forms[0].citizen_yn.value='N';					
				}

				disable_Legal_If_Citzen();
			}
			
			if(Calledfrom=='VSTREG'){
				function_name="VSTREG";
			}

			if(Calledfrom=='CP'){
				function_name="CHANGEPAT";
			}

			if(Calledfrom=='WTMGMT'){
				function_name="WTMGMT";
			}

			var flg_pop_dat=0;
			

			

			HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/populateSmartCard.jsp'><input type='hidden' name='inst' id='inst' value=\""+p_inst+"\"><input type='hidden' name='Calledfrom' id='Calledfrom' value=\""+p_Calledfrom+"\"><input type='hidden' name='city_desc' id='city_desc' value=\""+city_desc+"\"><input type='hidden' name='state_desc' id='state_desc' value=\""+state_desc+"\"><input type='hidden' name='post_code' id='post_code' value=\""+post_code+"\"><input type='hidden' name='b_place' id='b_place' value=\""+b_place+"\"><input type='hidden' name='race_desc' id='race_desc' value=\""+race_desc+"\"><input type='hidden' name='religion_desc' id='religion_desc' value=\""+religion_desc+"\"><input type='hidden' name='function_name' id='function_name' value=\""+function_name+"\"><input type='hidden' name='nric_val' id='nric_val' value=\""+nric_no+"\"><input type='hidden' name='father_doc_type_desc' id='father_doc_type_desc' value=\""+father_doc_type+"\"><input type='hidden' name='alt_id_type_desc' id='alt_id_type_desc' value=\""+alt_id_type_desc+"\"><input type='hidden' name='nric' id='nric' value=\""+flg_pop_dat+"\"><input type='hidden' name='caller_form' id='caller_form' value='06'><input type='hidden' name='from_OA' id='from_OA' value=\""+from_OA+"\"><input type='hidden' name='mother_yn' id='mother_yn' value=\""+mother_yn+"\"><input type='hidden' name='father_yn' id='father_yn' value=\""+father_yn+"\"><input type='hidden' name='pat_photo' id='pat_photo' value=\""+photo+"\"><input type='hidden' name='nationality_desc' id='nationality_desc' value='Malaysia'/> </form></body></html>"; 
		//	alert(HTMLVal)
			if(Calledfrom=='P'){				
				parent.parent.messageFrame.document.write(HTMLVal);
				parent.parent.messageFrame.document.form1.submit();	
			}

			if(Calledfrom=='OAAP'){
				parent.frames[4].document.write(HTMLVal);				
				parent.frames[4].document.form1.submit();
			}

			if(Calledfrom=='VSTREG'){
				parent.parent.messageFrame.document.write(HTMLVal);
				parent.parent.messageFrame.document.form1.submit();	
			}
			
			if(Calledfrom=='REGREF'){
				parent.parent.frames[3].document.write(HTMLVal);
				parent.parent.frames[3].document.form1.submit();	
			}

			if(Calledfrom=='WTLST'){
				
				parent.frames[3].document.write(HTMLVal);
				parent.frames[3].document.form1.submit();	
			}

			if(Calledfrom=='IPBOOKING'){
				parent.frames[3].document.write(HTMLVal);
				parent.frames[3].document.form1.submit();	
			}


			if(Calledfrom=='CP'){
				parent.parent.messageFrame.document.write(HTMLVal);
				parent.parent.messageFrame.document.form1.submit();		
			}


			if(Calledfrom=='WTMGMT'){
				parent.messageFrame.document.write(HTMLVal);
				parent.messageFrame.document.form1.submit();		
			}
			
}

function clear_smart_card_values_06(Calledfrom,inst){

	
		document.forms[0].national_id_no.value='';
		
		if (document.forms[0].second_name){
			document.forms[0].second_name.value='';
			document.forms[0].second_name.focus();
			document.forms[0].second_name.blur();
		}
			
		if (document.forms[0].date_of_birth){
			document.forms[0].date_of_birth.value='';
			document.forms[0].date_of_birth.focus();
			document.forms[0].date_of_birth.blur();

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
		
		if(Calledfrom=='P'){
			document.forms[0].citizen[0].checked=true;
			document.forms[0].citizen[1].checked=false;
			document.forms[0].citizen_yn.value='Y';
			change_stat_dis();
		}

		if (document.forms[0].race_desc){
			document.forms[0].race_desc.value='';
		}

		if (document.forms[0].race_code){
			document.forms[0].race_code.value='';					
		}

		if (document.forms[0].relgn_desc){
			document.forms[0].relgn_desc.value='';
		}

		if (document.forms[0].relgn_code){
			document.forms[0].relgn_code.value='';
		}

		if (document.forms[0].r_area){
			document.forms[0].r_area.value='';
		}

		if (document.forms[0].r_area_code){
			document.forms[0].r_area_code.value='';
		}

		if (document.forms[0].r_town){
			document.forms[0].r_town.value='';
		}

		if (document.forms[0].r_town_code){
			document.forms[0].r_town_code.value='';
		}

		if (document.forms[0].r_region){
			document.forms[0].r_region.value='';
		}

		if (document.forms[0].r_region_code){
			document.forms[0].r_region_code.value='';
		}

		if (document.forms[0].r_postal_code1){
			document.forms[0].r_postal_code1.value='';
		}

		if (document.forms[0].place_of_birth_desc){
			document.forms[0].place_of_birth_desc.value='';
		}

		if (document.forms[0].place_of_birth_code){
			document.forms[0].place_of_birth_code.value='';
		}

		if (document.forms[0].place_of_birth){
			document.forms[0].place_of_birth.value='';
		}


		if( document.forms[0].b_time){
			document.forms[0].b_time.value="";
		}

		if( document.forms[0].other_alt_id){
					document.forms[0].other_alt_id.value='';
		}

		if( document.forms[0].other_alt_Id_text){
				document.forms[0].other_alt_Id_text.value='';
		}

		if( document.forms[0].next_contact_name){
					document.forms[0].next_contact_name.value='';
		}			 
			
		if( document.forms[0].contact1_new_nat_id_no){
					document.forms[0].contact1_new_nat_id_no.value='';					
		}
		if( document.forms[0].contact1_birth_date){
					document.forms[0].contact1_birth_date.value='';					
		}
		
		if( document.forms[0].next_contact_relation_desc){
					document.forms[0].next_contact_relation_desc.value='';					
		}

		if( document.forms[0].next_contact_relation){
					document.forms[0].next_contact_relation.value='';					
		}			
		
		if( document.forms[0].first_contact_name){
					document.forms[0].first_contact_name.value='';
		}

		if( document.forms[0].contact2_nat_id_no){
					document.forms[0].contact2_nat_id_no.value='';
		}
		
		if( document.forms[0].first_contact_relation_desc){
					document.forms[0].first_contact_relation_desc.value='';					
		}

		if( document.forms[0].first_contact_relation_desc){
					document.forms[0].first_contact_relation_desc.value='';					
		}
				

}
function populate_smart_crd_data_ps_06(pat_name,nric_no,oth_alt_no,alt_id_type_desc,addr_1,addr_2,addr_3,city_desc,state_desc,post_code,b_date,b_place,citizen_yn,race_desc,religion_desc,gender,time_of_birth,birth_cert_no,father_name,father_ic_no,mother_name,mother_ic_no,flg_pop_dat,Calledfrom,inst,photo){
	var function_name="PS";
	
	if(document.forms[0].Patient_Id.value ==""){
		// populate data 
				
	/*	if (document.forms[0].Second_Name){
			if(pat_name.length > document.getElementById("Second_Name").maxLength){
				pat_name=pat_name.substr(0,document.getElementById("Second_Name").maxLength);
			}			
			document.forms[0].Second_Name.value=pat_name;
			document.forms[0].Second_Name.focus();
			document.forms[0].Second_Name.blur();
		}
		if(oth_alt_no!='' ){
				if( document.forms[0].other_alt_id){
					document.forms[0].other_alt_id.value='08';
				}

				if( document.forms[0].other_alt_Id_text){
					document.forms[0].other_alt_Id_text.value=oth_alt_no;
				}
			}
		

		if (document.getElementById("r_addr_line1")){
			if(addr_1.length > document.getElementById("r_addr_line1").maxLength){
				addr_1=addr_1.substr(0,document.getElementById("r_addr_line1").maxLength);
			}

			document.getElementById("r_addr_line1").value=addr_1;			
		}

		if (document.getElementById("r_addr_line2")){
			if(addr_2.length > document.getElementById("r_addr_line2").maxLength){
				addr_2=addr_2.substr(0,document.getElementById("r_addr_line2").maxLength);
			}

			document.getElementById("r_addr_line2").value=addr_2;			
		}

		if (document.getElementById("r_addr_line3")){
			if(addr_3.length > document.getElementById("r_addr_line3").maxLength){
				addr_3=addr_3.substr(0,document.getElementById("r_addr_line3").maxLength);
			}

			document.getElementById("r_addr_line3").value=addr_3;			
		}
*/
	/*	if (document.forms[0].Dob){
			document.forms[0].Dob.value=b_date;
			document.forms[0].Dob.focus();
			document.forms[0].Dob.blur();
		}

		if (gender == "LELAKI") {
			document.forms[0].Sex.value='M';
		} else if (gender == "PEREMPUAN") {
			document.forms[0].Sex.value='F';
		}else{
			 document.forms[0].Sex.value='U';
		}
		*/

				
		var flg_pop_dat=0;
		var function_name="PAT_SEARCH";
		
		
		HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/populateSmartCard.jsp'><input type='hidden' name='inst' id='inst' value=\""+p_inst+"\"><input type='hidden' name='Calledfrom' id='Calledfrom' value=\""+p_Calledfrom+"\"><input type='hidden' name='city_desc' id='city_desc' value=\""+city_desc+"\"><input type='hidden' name='state_desc' id='state_desc' value=\""+state_desc+"\"><input type='hidden' name='post_code' id='post_code' value=\""+post_code+"\"><input type='hidden' name='b_place' id='b_place' value=\""+b_place+"\"><input type='hidden' name='race_desc' id='race_desc' value=\""+race_desc+"\"><input type='hidden' name='religion_desc' id='religion_desc' value=\""+religion_desc+"\"><input type='hidden' name='nric_val' id='nric_val' value=\""+nric_no+"\"><input type='hidden' name='alt_id_type_desc' id='alt_id_type_desc' value=\""+alt_id_type_desc+"\"><input type='hidden' name='nric' id='nric' value=\""+flg_pop_dat+"\"><input type='hidden' name='caller_form' id='caller_form' value='06'><input type='hidden' name='function_name' id='function_name' value=\""+function_name+"\"><input type='hidden' name='pat_photo' id='pat_photo' value=\""+photo+"\"></form></body></html>"; 
	//	alert("HTMLVal 973 : "+HTMLVal);
		parent.parent.messageFrame.document.write(HTMLVal);
		parent.parent.messageFrame.document.form1.submit();	
			
				
	}	
		
}

function check_clear(){
	if(document.forms[0].National_Id_No.value==''){
		if(document.forms[0].Patient_Id.value==''){


		
			if (document.forms[0].second_name){
				document.forms[0].second_name.value='';
				document.forms[0].second_name.focus();
				document.forms[0].second_name.blur();
			}
			
			if(document.forms[0].date_of_birth){
				document.forms[0].date_of_birth.value='';
				document.forms[0].date_of_birth.focus();
				document.forms[0].date_of_birth.blur();

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
			
			if(Calledfrom=='P'){
				document.forms[0].citizen[0].checked=true;
				document.forms[0].citizen[1].checked=false;
				document.forms[0].citizen_yn.value='Y';
				change_stat_dis();
			}

			if (document.forms[0].race_desc){
				document.forms[0].race_desc.value='';
			}

			if (document.forms[0].race_code){
				document.forms[0].race_code.value='';					
			}

			if (document.forms[0].relgn_desc){
				document.forms[0].relgn_desc.value='';
			}

			if (document.forms[0].relgn_code){
				document.forms[0].relgn_code.value='';
			}

			if (document.forms[0].r_area){
				document.forms[0].r_area.value='';
			}

			if (document.forms[0].r_area_code){
				document.forms[0].r_area_code.value='';
			}

			if (document.forms[0].r_town){
				document.forms[0].r_town.value='';
			}

			if (document.forms[0].r_town_code){
				document.forms[0].r_town_code.value='';
			}

			if (document.forms[0].r_region){
				document.forms[0].r_region.value='';
			}

			if (document.forms[0].r_region_code){
				document.forms[0].r_region_code.value='';
			}

			if (document.forms[0].r_postal_code1){
				document.forms[0].r_postal_code1.value='';
			}

			if (document.forms[0].place_of_birth_desc){
				document.forms[0].place_of_birth_desc.value='';
			}

			if (document.forms[0].place_of_birth_code){
				document.forms[0].place_of_birth_code.value='';
			}
			
		}
	}
}


function clear_smart_card_values_ps_06(Calledfrom,inst){

		document.forms[0].National_Id_No.value='';
		
		if (document.forms[0].Family_Name){
			document.forms[0].Family_Name.value='';
			document.forms[0].Family_Name.focus();
			document.forms[0].Family_Name.blur();
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

		if(Calledfrom=='P'){
			document.forms[0].citizen[0].checked=true;
			document.forms[0].citizen[1].checked=false;
			document.forms[0].citizen_yn.value='Y';
			change_stat_dis();
		}

		if (document.forms[0].race_desc){
			document.forms[0].race_desc.value='';
		}

		if (document.forms[0].race_code){
			document.forms[0].race_code.value='';					
		}

		if (document.forms[0].relgn_desc){
			document.forms[0].relgn_desc.value='';
		}

		if (document.forms[0].relgn_code){
			document.forms[0].relgn_code.value='';
		}

		if (document.forms[0].r_area){
			document.forms[0].r_area.value='';
		}

		if (document.forms[0].r_area_code){
			document.forms[0].r_area_code.value='';
		}

		if (document.forms[0].r_town){
			document.forms[0].r_town.value='';
		}

		if (document.forms[0].r_town_code){
			document.forms[0].r_town_code.value='';
		}

		if (document.forms[0].r_region){
			document.forms[0].r_region.value='';
		}

		if (document.forms[0].r_region_code){
			document.forms[0].r_region_code.value='';
		}

		if (document.forms[0].r_postal_code1){
			document.forms[0].r_postal_code1.value='';
		}

		if (document.forms[0].place_of_birth_desc){
			document.forms[0].place_of_birth_desc.value='';
		}

		if (document.forms[0].place_of_birth_code){
			document.forms[0].place_of_birth_code.value='';
		}


}
function replaceQuotes(val)
{
	return val.replace(/("|')/g, "\\'");
	
}

