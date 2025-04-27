
var p_Calledfrom;
var p_inst;
var p_theLocation; 
var p_subFrame; 
var p_opCall;
var from_OA='N';

function ReadSmartCard_03(Calledfrom,inst,theLocation,subFrame,opCall){


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
			clear_smart_card_values_03(Calledfrom,inst);
		}
		if(inst=='PS' ){
			clear_smart_card_values_ps_03(Calledfrom,inst);
		}

		var fsoall, f_all; 
		//fsoall = new ActiveXObject("Scripting.FileSystemObject");
		fsoall = "";
		f_all = fsoall.GetFolder("C:\\MyKad");	
        var fc = new Enumerator(f_all.files);
        for (; !fc.atEnd(); fc.moveNext()) {
            if(fc.item().type=='JPEG image'){
				if(fc.item()=='C:\\MyKad\\mylogo.JPG'){
				}else{
					fsoall.deleteFile(fc.item());
				}
			}
        }

		IrisMykadReader();
	//}

}

function IrisMykadReader(){
	/*var MyKadWrapper = new ActiveXObject("WebMyKadObj.MyKad");
    var InList = new ActiveXObject("WebMyKadObj.InputList");
    var InfoDataList = new ActiveXObject("WebMyKadObj.DataList");*/
	var MyKadWrapper = "";
    var InList ="";
    var InfoDataList = "";
	var usr_ID;	
	var my_Kid="N";
	try{
		InfoDataList = MyKadWrapper.ReadJPN("","","");
		if (InfoDataList.Status == 0){
			usr_ID = InfoDataList.KPTNo;
		}else if (InfoDataList.Status == -87){
			InfoDataList = MyKadWrapper.ReadMyKid();
			usr_ID = InfoDataList.KID_IDNum;
			my_Kid="Y";
		}else{			
            alert(InfoDataList.Msg);
        }
	}catch(exception){
		alert(exception.description)
	}
        
	
	var photopath = "C:\\MyKad\\" + usr_ID + ".jpg";
	var thumb1 = "C:\\MyKad\\Thumb1.bin";
	var thumb2 = "C:\\MyKad\\Thumb2.bin";
	//alert(photopath)
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
		//alert('before Mykad call')
		//InfoDataList = MyKadWrapper.ReadJPN(photopath,thumb1,thumb2);

		if(my_Kid=="N"){
			InfoDataList = MyKadWrapper.ReadJPN("C:\\MyKad\\" + usr_ID + ".jpg","C:\\MyKad\\Thumb1.bin","C:\\MyKad\\Thumb2.bin");
		}else{
			InfoDataList = MyKadWrapper.ReadMyKid();
		}

		//alert('after Mykad call')
		//alert(InfoDataList.Status)
		if (InfoDataList.Status == 0 && my_Kid=="N"){
			pat_name=trimString(InfoDataList.Name );
			
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
			

			nric_no=trimString(InfoDataList.KPTNo);
			addr_1=trimString(InfoDataList.Address1);
			addr_2=trimString(InfoDataList.Address2);
			addr_3=trimString(InfoDataList.Address3);
			city_desc=trimString(InfoDataList.City);
			state_desc=trimString(InfoDataList.State);
			post_code=trimString(InfoDataList.Postcode);
			b_date=trimString(InfoDataList.BirthDate);
			b_place=trimString(InfoDataList.BirthPlace);
			citizen_yn=trimString(InfoDataList.Citizenship);
			race_desc=trimString(InfoDataList.Race);
			religion_desc=trimString(InfoDataList.Religion);
			gender=trimString(InfoDataList.Gender);
            

			//alert('pat_name-->'+pat_name+'nric_no-->'+nric_no+'addr_1-->'+addr_1+'addr_2-->'+addr_2+'addr_3-->'+addr_3+'city_desc-->'+city_desc+'state_desc-->'+state_desc+'post_code-->'+post_code+'b_date-->'+b_date+'b_place-->'+b_place+'citizen_yn-->'+citizen_yn+'race_desc-->'+race_desc+'religion_desc-->'+religion_desc+'gender-->'+gender)
			
			populate_Sekure_new_03(p_Calledfrom,p_inst,p_theLocation,p_subFrame,p_opCall,pat_name,nric_no,addr_1,addr_2,addr_3,city_desc,state_desc,post_code,b_date,b_place,citizen_yn,race_desc,religion_desc,gender,'','','','','','');
		}else if (InfoDataList.Status == 0 && my_Kid=="Y"){
			
			pat_name=trimString(InfoDataList.KID_Name);
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
			nric_no=trimString(InfoDataList.KID_IDNum);
			addr_1=trimString(InfoDataList.KID_New_Address1);
			addr_2=trimString(InfoDataList.KID_New_Address2);
			addr_3=trimString(InfoDataList.KID_New_Address3);
			city_desc=trimString(InfoDataList.KID_New_City);
			state_desc=trimString(InfoDataList.KID_New_State);
			post_code=trimString(InfoDataList.KID_New_PostCode);
			b_date=trimString(InfoDataList.KID_DOB);
			b_place=trimString(InfoDataList.KID_BirthPlace1);
			if(b_place==''){
				b_place=trimString(InfoDataList.KID_BirthPlace2);
			}
			citizen_yn=trimString(InfoDataList.KID_Citizenship);
			
			race_desc=trimString(InfoDataList.KID_F_Race);
			if(race_desc==''){
				race_desc=trimString(InfoDataList.KID_M_Race);
			}
			religion_desc=trimString(InfoDataList.KID_F_Religion);
			if(religion_desc==''){
				religion_desc=trimString(InfoDataList.KID_M_RELIGION);
			}
			gender=trimString(InfoDataList.KID_GENDER);
			var time_of_birth=trimString(InfoDataList.KID_TOB);
			var birth_cert_no=trimString(InfoDataList.KID_BirthCertNum);
			var father_name=trimString(InfoDataList.KID_F_Name);
			var father_ic_no=trimString(InfoDataList.KID_F_IDNum);
			var mother_name=trimString(InfoDataList.KID_M_Name);
			var mother_ic_no=trimString(InfoDataList.KID_M_IDNum);

			//alert('pat_name-->'+pat_name+'nric_no-->'+nric_no+'addr_1-->'+addr_1+'addr_2-->'+addr_2+'addr_3-->'+addr_3+'city_desc-->'+city_desc+'state_desc-->'+state_desc+'post_code-->'+post_code+'b_date-->'+b_date+'b_place-->'+b_place+'citizen_yn-->'+citizen_yn+'race_desc-->'+race_desc+'religion_desc-->'+religion_desc+'gender-->'+gender+'time_of_birth-->'+time_of_birth+'birth_cert_no-->'+birth_cert_no+'father_name-->'+father_name+'father_ic_no-->'+father_ic_no+'mother_name-->'+mother_name+'mother_ic_no-->'+mother_ic_no)
			
			populate_Sekure_new_03(p_Calledfrom,p_inst,p_theLocation,p_subFrame,p_opCall,pat_name,nric_no,addr_1,addr_2,addr_3,city_desc,state_desc,post_code,b_date,b_place,citizen_yn,race_desc,religion_desc,gender,time_of_birth,birth_cert_no,father_name,father_ic_no,mother_name,mother_ic_no);
			
		
        }else{			
            alert(InfoDataList.Msg);
        }
		
        
	}catch(exception){
			alert(exception.description)
	}
	 MyKadWrapper = null;
	 InList = null;
	 InfoDataList = null;
		
}


function populate_Sekure_new_03(Calledfrom,inst,theLocation,subFrame,opCall,pat_name,nric_no,addr_1,addr_2,addr_3,city_desc,state_desc,post_code,b_date,b_place,citizen_yn,race_desc,religion_desc,gender,time_of_birth,birth_cert_no,father_name,father_ic_no,mother_name,mother_ic_no){


			/*if(inst=='NC'){
				clear_smart_card_values_03(Calledfrom,inst);
			}
			if(inst=='PS' ){
				clear_smart_card_values_ps_03(Calledfrom,inst);
			}
			*/			

			var flg_pop_dat=0;


			if(inst=='CP'){  
				if(flg_pop_dat==0){
					document.getElementById('national_id_no').value=nric_no;
					document.getElementById('national_id_no').focus();

					document.forms[0].national_id_no.blur();
					document.forms[0].txtSmartcard_dup.value="1";
					
									
				}else{
					document.forms[0].txtSmartcard_dup.value="1";					
			
				}

				setTimeout("populate_smart_crd_data_03('"+pat_name+"','"+nric_no+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"')",1000);
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

				setTimeout("populate_smart_crd_data_03('"+pat_name+"','"+nric_no+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"')",1000);
			}
			
			if(inst=='PS' ){ 

				if(flg_pop_dat==0){
					document.getElementById('National_Id_No').value=nric_no;
					document.getElementById('National_Id_No').focus();
					document.forms[0].National_Id_No.blur();
				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
					
				}

				setTimeout("populate_smart_crd_data_ps_03('"+pat_name+"','"+nric_no+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"')",2000);

			}


			if(Calledfrom=='OAAP' ){ // book appt

				if(flg_pop_dat==0){
					document.getElementById("national_id_no").value=nric_no;
					document.getElementById("national_id_no").focus();
					setTimeout(document.getElementById("national_id_no").blur(),200);					

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

				setTimeout("populate_smart_crd_data_03('"+pat_name+"','"+nric_no+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"')",1000);
				

			}


			
			if(Calledfrom=='VSTREG'  || Calledfrom=='REFQUR' || Calledfrom=='WTMGMT'){ // Visit registration,Referral query
				if(flg_pop_dat==0){
					document.getElementById('national_id_no').value=nric_no;
					//document.getElementById('national_id_no').focus();
					//setTimeout("document.getElementById('national_id_no').blur()",200);					

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

				setTimeout("populate_smart_crd_data_03('"+pat_name+"','"+nric_no+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"')",1000);
				

			}

			if(Calledfrom=='REGREF' ){ // Refferal Regn
				if(flg_pop_dat==0){
					document.getElementById("national_id_no").value=nric_no;
					document.getElementById("national_id_no").focus();
					setTimeout(document.getElementById("national_id_no").blur(),200);					

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

				setTimeout("populate_smart_crd_data_03('"+pat_name+"','"+nric_no+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"')",1000);
				

			}

			if(Calledfrom=='AE' ){ // Register Attendance
				if(flg_pop_dat==0){
					document.getElementById("National_Id_No").value=nric_no;
					document.getElementById("National_Id_No").focus();
					setTimeout(document.getElementById("National_Id_No").blur(),200);					

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

				setTimeout("populate_smart_crd_data_03('"+pat_name+"','"+nric_no+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"')",1000);
				

			}

			if(Calledfrom=='WTLST' ){ // Create Waitlist
				if(flg_pop_dat==0){
					document.getElementById("national_id_no").value=nric_no;
					document.getElementById("national_id_no").focus();
					setTimeout(document.getElementById("national_id_no").blur(),200);					

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

				setTimeout("populate_smart_crd_data_03('"+pat_name+"','"+nric_no+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"')",1000);
			}

			if(Calledfrom=='IPBOOKING' ){ // IP Booking
				if(flg_pop_dat==0){
					document.getElementById("national_id_no").value=nric_no;
					document.getElementById("national_id_no").focus();
					setTimeout(document.getElementById("national_id_no").blur(),200);					

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

				setTimeout("populate_smart_crd_data_03('"+pat_name+"','"+nric_no+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"')",1000);
			}
			


}

function populate_smart_crd_data_03(pat_name,nric_no,addr_1,addr_2,addr_3,city_desc,state_desc,post_code,b_date,b_place,citizen_yn,race_desc,religion_desc,gender,time_of_birth,birth_cert_no,father_name,father_ic_no,mother_name,mother_ic_no,flg_pop_dat,Calledfrom,inst){
	

	if(document.forms[0].txtSmartcard_dup.value=="1"){

		if(document.forms[0].national_id_no.value==''){
			/* checkNatioanlity.jsp identified duplicate NRIC  */
		}else{

			set_values_03(pat_name,nric_no,addr_1,addr_2,addr_3,city_desc,state_desc,post_code,b_date,b_place,citizen_yn,race_desc,religion_desc,gender,time_of_birth,birth_cert_no,father_name,father_ic_no,mother_name,mother_ic_no,flg_pop_dat,Calledfrom,inst);
		}	
	
	}else if(document.forms[0].txtSmartcard_dup.value=="D"){
		
	}else{

		setTimeout("populate_smart_crd_data_03('"+pat_name+"','"+nric_no+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"')",3000);

	}

}


function set_values_03(pat_name,nric_no,addr_1,addr_2,addr_3,city_desc,state_desc,post_code,b_date,b_place,citizen_yn,race_desc,religion_desc,gender,time_of_birth,birth_cert_no,father_name,father_ic_no,mother_name,mother_ic_no,flg_pop_dat,Calledfrom,inst){


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
				if (gender == "LELAKI") {
					document.forms[0].sex.value='M';
				} else if (gender == "PEREMPUAN") {
					document.forms[0].sex.value='F';
				}else{
					 document.forms[0].sex.value='U';
				}
			}
			
			if( document.forms[0].gender){
				if (gender == "LELAKI") {
					document.forms[0].gender.value='M';
				} else if (gender == "PEREMPUAN") {
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
					var b_time=time_of_birth.split(':');
					document.forms[0].b_time.value=b_time[0]+":"+b_time[1];
				}				
			}

			if(birth_cert_no!='' ){
				if( document.forms[0].other_alt_id){
					document.forms[0].other_alt_id.value='08';
				}

				if( document.forms[0].other_alt_Id_text){
					document.forms[0].other_alt_Id_text.value=birth_cert_no;
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
			

			

			HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/populateSmartCard.jsp'><input type='hidden' name='inst' id='inst' value=\""+p_inst+"\"><input type='hidden' name='Calledfrom' id='Calledfrom' value=\""+p_Calledfrom+"\"><input type='hidden' name='city_desc' id='city_desc' value=\""+city_desc+"\"><input type='hidden' name='state_desc' id='state_desc' value=\""+state_desc+"\"><input type='hidden' name='post_code' id='post_code' value=\""+post_code+"\"><input type='hidden' name='b_place' id='b_place' value=\""+b_place+"\"><input type='hidden' name='race_desc' id='race_desc' value=\""+race_desc+"\"><input type='hidden' name='religion_desc' id='religion_desc' value=\""+religion_desc+"\"><input type='hidden' name='function_name' id='function_name' value=\""+function_name+"\"><input type='hidden' name='nric_val' id='nric_val' value=\""+nric_no+"\"><input type='hidden' name='nric' id='nric' value=\""+flg_pop_dat+"\"><input type='hidden' name='caller_form' id='caller_form' value='03'><input type='hidden' name='from_OA' id='from_OA' value=\""+from_OA+"\"><input type='hidden' name='mother_yn' id='mother_yn' value=\""+mother_yn+"\"><input type='hidden' name='father_yn' id='father_yn' value=\""+father_yn+"\"></form></body></html>"; 

			//alert(HTMLVal)
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

function clear_smart_card_values_03(Calledfrom,inst){

	
		document.forms[0].national_id_no.value='';
		
		if (document.forms[0].family_name){
			document.forms[0].family_name.value='';
			document.forms[0].family_name.focus();
			document.forms[0].family_name.blur();
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


function populate_smart_crd_data_ps_03(pat_name,nric_no,addr_1,addr_2,addr_3,city_desc,state_desc,post_code,b_date,b_place,citizen_yn,race_desc,religion_desc,gender,time_of_birth,birth_cert_no,father_name,father_ic_no,mother_name,mother_ic_no,flg_pop_dat,Calledfrom,inst){

	var function_name="PS";
	
	if(document.forms[0].Patient_Id.value ==""){
		// populate data 
				
		if (document.forms[0].Family_Name){

			if(pat_name.length > document.getElementById("Family_Name").maxLength){
				pat_name=pat_name.substr(0,document.getElementById("Family_Name").maxLength);
			}
			
			document.forms[0].Family_Name.value=pat_name;
			document.forms[0].Family_Name.focus();
			document.forms[0].Family_Name.blur();
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

		
		if (document.forms[0].Dob){
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
		

				
		var flg_pop_dat=0;
		var function_name="PAT_SEARCH";
		
		
		HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/populateSmartCard.jsp'><input type='hidden' name='inst' id='inst' value=\""+p_inst+"\"><input type='hidden' name='Calledfrom' id='Calledfrom' value=\""+p_Calledfrom+"\"><input type='hidden' name='city_desc' id='city_desc' value=\""+city_desc+"\"><input type='hidden' name='state_desc' id='state_desc' value=\""+state_desc+"\"><input type='hidden' name='post_code' id='post_code' value=\""+post_code+"\"><input type='hidden' name='b_place' id='b_place' value=\""+b_place+"\"><input type='hidden' name='race_desc' id='race_desc' value=\""+race_desc+"\"><input type='hidden' name='religion_desc' id='religion_desc' value=\""+religion_desc+"\"><input type='hidden' name='nric_val' id='nric_val' value=\""+nric_no+"\"><input type='hidden' name='nric' id='nric' value=\""+flg_pop_dat+"\"><input type='hidden' name='caller_form' id='caller_form' value='03'><input type='hidden' name='function_name' id='function_name' value=\""+function_name+"\"></form></body></html>"; 
		
		parent.parent.messageFrame.document.write(HTMLVal);
		parent.parent.messageFrame.document.form1.submit();	
			
				
	}	
		
}

function check_clear(){
	if(document.forms[0].National_Id_No.value==''){
		if(document.forms[0].Patient_Id.value==''){


		
			if (document.forms[0].family_name){
				document.forms[0].family_name.value='';
				document.forms[0].family_name.focus();
				document.forms[0].family_name.blur();
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


function clear_smart_card_values_ps_03(Calledfrom,inst){

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


