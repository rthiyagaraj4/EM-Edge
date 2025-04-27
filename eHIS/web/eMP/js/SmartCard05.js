/*SmartCard05 JS is used for Taiba Site Specific*/
/*//Maheshwaran K created for the TH-KW-CRF-0019 */
/*
var txt= ""
var license_key="138B3C05-E202-BF45-82EB-286A1498BE40";
var license_verified="N";
*/
var p_Calledfrom;
var p_inst;
var p_theLocation; 
var p_subFrame; 
var p_opCall;
var from_OA='N';
var cardReaderVal="";
	var retdata = ""; 
/*
var Intacq8XBio = new ActiveXObject("Intacq8X.Biometrics");
var Intacq8XMyKad = new ActiveXObject("Intacq8X.MyKad");
var Intacq8XDisplay = new ActiveXObject("Intacq8X.Display");
var Intacq8XDevice = new ActiveXObject("Intacq8X.Device");*/
/*
function VerifyL()
{
	//var szText = document.Intacq.licensekey.value;
	var szText = license_key;

	if( szText == "" )
	{
		alert( "Please enter the License Key" );
		return;
	}
	try
	{
		//document.Intacq.retval.value = ""
		//document.Intacq.retval.value = "Verifying License Please Wait ..." 

		var nRet;
	
		nRet = Intacq8XDevice.VerifyLicense( szText,"c:\\IBS\\l.dat" );

		//document.Intacq.retval.value = "Verify License return " + nRet
		if(nRet==0){
			license_verified="Y";
		}else{
			alert(nRet)
		}
	}
	catch(err)
	{
		//txt = "Error Description:" +err.description +"\n\n"
		alert(err.description)
	}
}
*/
function ReadSmartCard_05(Calledfrom,inst,theLocation,subFrame,opCall){

	
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

	p_Calledfrom=Calledfrom;
	p_inst=inst;
	p_theLocation=theLocation;
	p_subFrame=subFrame;
	p_opCall=opCall;
	//alert('94');
	//if(Calledfrom=='P' || Calledfrom=='OAAP' || Calledfrom=='PS' ||Calledfrom=='VSTREG' || Calledfrom =='REGREF' || Calledfrom =='REFQUR' || Calledfrom =='AE'|| Calledfrom=='CP' ){
		if(inst=='NC'){
			clear_smart_card_values_05(Calledfrom,inst);
		}
		
		//Commented for Patient Search function
		if(inst=='PS' ){
			clear_smart_card_values_ps_05(Calledfrom,inst);
		}
		
		
	/*	var fsoall, f_all; 
		fsoall = new ActiveXObject("Scripting.FileSystemObject");
		f_all = fsoall.GetFolder("C:\\IBS");	
        var fc = new Enumerator(f_all.files);
        for (; !fc.atEnd(); fc.moveNext()) {
            if(fc.item().type=='JPEG image'){
				if(fc.item()=='C:\\IBS\\mylogo.JPG'){
				}else{
					fsoall.deleteFile(fc.item());
				}
			}
        } */
	//	setTimeout("PACIMyKad()",2000);
		PACIMyKad();

	//}
	


}
function PACIMyKad()
	{

	var requestObj = false;
if (window.XMLHttpRequest) {
    requestObj = new XMLHttpRequest();
} else if (window.ActiveXObject) {
   // requestObj = new ActiveXObject("Microsoft.XMLHTTP");
   requestObj = "";
}
//alert('149');
if (requestObj) {
    requestObj.open("POST", "../../eMP/jsp/PACIMyKad.jsp?function_id=05");
    requestObj.onreadystatechange = function ()
    {
        if (requestObj.readyState == 4 && requestObj.status == 200) {
            // alert('requestObj.responseText : '+requestObj.responseText);
             cardReaderVal=requestObj.responseText;
		/*	if(cardReaderVal=="NullPointerException")
				{
				alert("Card Reader is not connected properly. Please connect again");
				}*/
          // alert('cardReaderVal -------: '+cardReaderVal);
        }
    }
    requestObj.send(null);
}
//alert('cardReaderVal $$$$: '+cardReaderVal);
setTimeout('PACIMyKadPopulate()', 10000);
//PACIMyKadPopulate();
		
	}
function PACIMyKadPopulate(){
//alert('PACIMyKadPopulate');
//	VerifyL();
	//license_verified='Y'
//	if(license_verified=='Y'){
		//alert('127');
		//ReadMyKadVerify
		var nRet;
		//var szData;
/*
		Intacq8XMyKad.ComPort = 5
		Intacq8XMyKad.ShowDialog = 1
		nRet = Intacq8XMyKad.VerifyReadMyKadWithPhoto
		Intacq8XMyKad.PhotoPath = "c:\\IBS";
		var nRetPhoto = Intacq8XMyKad.WritePhotoToFile;

		var theLocation ="C:\\IBS\\Photo.jpg";*/
		//alert('139');
		
//alert('before')
 //setTimeout('PACIMyKadPopulate()', 2000);
 //alert('after')
		var pat_name="";
		var nric_no="";
		var dob="";
		var expiry_date="";
		var blood_grp="";
		var nationality="";
		var gender="";
		var passport="";
	//	var pat_name;
	//	var nric_no;
		var addr_1="";
		var addr_2="";
		var addr_3="";
		var city_desc="";
		var state_desc="";
		var post_code="";
		var b_date="";
		var b_place="";
		var citizen_yn="";
		var race_desc="";
		var religion_desc="";
		var time_of_birth="";
		var birth_cert_no="";
		var father_name="";
		var father_ic_no="";
		var mother_name="";
		var mother_ic_no="";
		var old_ic_no ="";
//		var gender;
	/*	if(cardReaderVal=="NullPointerException" || cardReaderVal=="")
				{
				alert("Card Reader is not connected properly. Please connect again");
				} */
	//	alert('cardReaderVal= ???============ : '+cardReaderVal);
		var cardReaderVal1= cardReaderVal.split("$");
	//	alert('cardReaderVal1 : '+cardReaderVal1);
		nric_no= cardReaderVal1[0].toString();
		pat_name= cardReaderVal1[1];
		var dob1= cardReaderVal1[2];
		var expiry_date1= cardReaderVal1[3];
	//	dob=dob1;
	//	expiry_date=expiry_date1;
		dob=trimString(dob1.substring(6,8)+"/"+dob1.substring(4,6)+"/"+dob1.substring(0,4));
		expiry_date=trimString(expiry_date1.substring(6,8)+"/"+expiry_date1.substring(4,6)+"/"+expiry_date1.substring(0,4));
	//	expiry_date= cardReaderVal1[3];
		nationality= cardReaderVal1[4];		
		gender= cardReaderVal1[5];
		blood_grp= cardReaderVal1[6];
		passport= trimString(cardReaderVal1[7]);
	/*	alert('nric_no : '+nric_no);
		alert('pat_name : '+pat_name);
		alert('dob : '+dob);
		alert('nationality : '+nationality);
		alert('expiry_date : '+expiry_date);
		
		alert('gender : '+gender);
		alert('blood_grp : '+blood_grp);
		alert('passport : '+passport);*/
		/*pat_name=trimString(pat_name.substring(1,40));
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
				pat_name=pat_name.replace("  "," ");*/
			//	alert('pat_nameww 222333 : '+pat_name);
		
		//var family_name=fa_name;

		populate_Sekure_new_05(p_Calledfrom,p_inst,p_theLocation,p_subFrame,p_opCall,pat_name,nric_no,dob,expiry_date,blood_grp,nationality,gender,passport,addr_1,addr_2,addr_3,city_desc,state_desc,post_code,b_date,b_place,citizen_yn,race_desc,religion_desc,gender,time_of_birth,birth_cert_no,father_name,father_ic_no,mother_name,mother_ic_no,old_ic_no);

	//	var data = Intacq8XMyKad.GetMyKadData;

		/*if(nRet== -1){  // Block commented as no need to do a recall without verification
			if(window.confirm("Do you want to continue without Verification")){
				nRet = Intacq8XMyKad.NoVerifyReadMyKadWithPhoto;
				data = Intacq8XMyKad.GetMyKadData;
				
				Intacq8XMyKad.PhotoPath = "c:\\IBS";
				nRetPhoto = Intacq8XMyKad.WritePhotoToFile
			}
		}*/ 
		
		if(nRet==0){ 			
			/*
			if(data.substring(0,1)== "0") { //MyKad population
				nric_no=trimString(data.substring(41,53));
				var fso, f;
				fso = new ActiveXObject("Scripting.FileSystemObject");
				if(fso.FileExists(theLocation)){

					f = fso.CopyFile(theLocation, Intacq8XMyKad.PhotoPath+"\\"+nric_no+".jpg");

					
					fso.deleteFile(theLocation);
					
				}

				old_ic_no=trimString(data.substring(54,61));
				pat_name=trimString(data.substring(1,40));
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
				var tmp = data.substring(62,70)
				b_date=trimString(tmp.substring(6,8)+"/"+tmp.substring(4,6)+"/"+tmp.substring(0,4));
				gender=trimString(data.substring(70,71));
				religion_desc=trimString(data.substring(71,81));
				race_desc=trimString(data.substring(82,106));
				citizen_yn=trimString(data.substring(107,124));
				b_place=trimString(data.substring(133,157));
				addr_1=trimString(data.substring(158,187));
				addr_2=trimString(data.substring(188,217));
				addr_3=trimString(data.substring(218,247));
				post_code=trimString(data.substring(248,253));
				state_desc=trimString(data.substring(279,308));	
				city_desc=trimString(data.substring(254,278));	

				if(Calledfrom=='VSTREG' && inst=='NC'){
					if (document.forms[0].appt_ref_no){
						pat_name='';
					}					
				}
				populate_Sekure_new_04(p_Calledfrom,p_inst,p_theLocation,p_subFrame,p_opCall,pat_name,nric_no,addr_1,addr_2,addr_3,city_desc,state_desc,post_code,b_date,b_place,citizen_yn,race_desc,religion_desc,gender,'','','','','','',old_ic_no);

			}else{ // my kid

				var fso, f;
				fso = new ActiveXObject("Scripting.FileSystemObject");
				if(fso.FileExists(theLocation)){				
					
					fso.deleteFile(theLocation);
					
				}
				pat_name=trimString(data.substring(28,178));
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
				nric_no=trimString(data.substring(16,28));
				addr_1=trimString(data.substring(662,692));
				addr_2=trimString(data.substring(692,722));
				addr_3=trimString(data.substring(692,722));
				city_desc=trimString(data.substring(758,788));
				state_desc=trimString(data.substring(788,818));
				post_code=trimString(data.substring(752,758));

				var tmp = data.substring(410,418);
				b_date=trimString(tmp.substring(6,8)+"/"+tmp.substring(4,6)+"/"+tmp.substring(0,4));
		
				b_place=trimString(data.substring(424,464));
				if(b_place==''){
					b_place=trimString(data.substring(464,504));
				}
				citizen_yn=trimString(data.substring(179,196));
				
				race_desc=trimString(data.substring(1364,1394));
				if(race_desc==''){
					race_desc=trimString(data.substring(1076,2006));
				}
				religion_desc=trimString(data.substring(382,396));
				if(religion_desc==''){
					religion_desc=trimString(data.substring(396,410));
				}
				gender=trimString(data.substring(178,179));
				
				var tmp = data.substring(418,424);
				var time_of_birth=trimString(tmp.substring(0,2)+":"+tmp.substring(2,4)+":"+tmp.substring(4,6));
						
				var birth_cert_no=trimString(data.substring(1,16));
				var father_name=trimString(data.substring(1183,1333));
				var father_ic_no=trimString(data.substring(1106,1118));
				var mother_name=trimString(data.substring(895,1045));
				var mother_ic_no=trimString(data.substring(818,830));
				if(Calledfrom=='VSTREG' && inst=='NC'){
					if (document.forms[0].appt_ref_no){
						pat_name='';
					}					
				}

						
				populate_Sekure_new_04(p_Calledfrom,p_inst,p_theLocation,p_subFrame,p_opCall,pat_name,nric_no,addr_1,addr_2,addr_3,city_desc,state_desc,post_code,b_date,b_place,citizen_yn,race_desc,religion_desc,gender,time_of_birth,birth_cert_no,father_name,father_ic_no,mother_name,mother_ic_no,old_ic_no);

				
			}
			*/

		} // no error on card read

//	} // block to check the card is verififed	

		var pat_name1= pat_name.split(" ");
		var first_name=trimString(pat_name1[0]);
		var second_name=trimString(pat_name1[1]);
		var family_name="";
		
		family_name = trimString(pat_name1.toString().replace(first_name,""));
		family_name = trimString(family_name.toString().replace(second_name,""));

		retdata = nric_no+"!~"+first_name+"!~"+second_name+"!~"+family_name+"!~"+dob+"!~"+expiry_date+"!~"+nationality+"!~"+gender+"!~"+blood_grp+"!~"+passport;
		smart_card_data(retdata);

}

function populate_Sekure_new_05(Calledfrom,inst,theLocation,subFrame,opCall,pat_name,nric_no,dob,expiry_date,blood_grp,nationality,gender,passport,addr_1,addr_2,addr_3,city_desc,state_desc,post_code,b_date,b_place,citizen_yn,race_desc,religion_desc,gender,time_of_birth,birth_cert_no,father_name,father_ic_no,mother_name,mother_ic_no,old_ic_no){

//alert('populate_Sekure_new_05 inst : '+inst + "Calledfrom "+Calledfrom);
			if(inst=='NC'){
				clear_smart_card_values_05(Calledfrom,inst);
			}
			
			//Commented for Patient Search
			if(inst=='PS' ){
				clear_smart_card_values_ps_05(Calledfrom,inst);
			}
						

			var flg_pop_dat=0;


			if(inst=='CP'){  
				if(flg_pop_dat==0){
					document.getElementById("national_id_no").value=nric_no;
					document.getElementById("national_id_no").focus();

					document.forms[0].national_id_no.blur();
					document.forms[0].txtSmartcard_dup.value="1";
					
									
				}else{
					document.forms[0].txtSmartcard_dup.value="1";					
			
				}
//dob,expiry_date,blood_grp,nationality,gender,passport

				setTimeout("populate_smart_crd_data_05('"+pat_name+"',"+nric_no+",'"+dob+"','"+expiry_date+"','"+blood_grp+"','"+nationality+"','"+gender+"','"+passport+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"','"+old_ic_no+"')",1000);

				 
			}
			
			
			if(inst=='NC' && Calledfrom=='P'){  
				if(flg_pop_dat==0){
					document.getElementById("national_id_no").value=nric_no;
					document.getElementById("national_id_no").focus();

					document.forms[0].national_id_no.blur();
					document.forms[0].txtSmartcard_dup.value="1";
					
									
				}else{
					document.forms[0].txtSmartcard_dup.value="1";					
			
				}
			//	alert('478')
			//setTimeout("populate_smart_crd_data_051('"+pat_name+"',"+nric_no+",'"+dob+"','"+expiry_date+"','"+blood_grp+"','"+nationality+"','"+gender+"','"+passport+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"','"+old_ic_no+"')",500);
			setTimeout("populate_smart_crd_data_05('"+pat_name+"',"+nric_no+",'"+dob+"','"+expiry_date+"','"+blood_grp+"','"+nationality+"','"+gender+"','"+passport+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"','"+old_ic_no+"')",	1000);
//alert('4ssss8');
				//setTimeout("populate_smart_crd_data_05('"+pat_name+"','"+nric_no+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"','"+old_ic_no+"')",1000);
			}
			
			
			//Commented for Patient Search functions Uncommented  by santhosh for TH-KW-CRF-0019.1
			if(inst=='PS' ){ 

				if(flg_pop_dat==0){
					document.getElementById("National_Id_No").value=nric_no;
					document.getElementById("National_Id_No").focus();
					document.forms[0].National_Id_No.blur();
				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
					
				}

				setTimeout("populate_smart_crd_data_ps_05('"+pat_name+"',"+nric_no+",'"+dob+"','"+expiry_date+"','"+blood_grp+"','"+nationality+"','"+gender+"','"+passport+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"','"+old_ic_no+"')",2000);

			}
			

			//Commeneted for other functions
/*
			if(Calledfrom=='OAAP' ){ // book appt

				if(flg_pop_dat==0){
					document.getElementById("national_id_no").value=nric_no;
					document.getElementById("national_id_no").focus();
					setTimeout(document.getElementById("national_id_no").blur(),200);					

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

				setTimeout("populate_smart_crd_data_05('"+pat_name+"',"+nric_no+",'"+dob+"','"+expiry_date+"','"+blood_grp+"','"+nationality+"','"+gender+"','"+passport+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"','"+old_ic_no+"')",1000);


			}


			
			if(Calledfrom=='VSTREG'  || Calledfrom=='REFQUR' || Calledfrom=='WTMGMT'){ // Visit registration,Referral query
				if(flg_pop_dat==0){
					document.getElementById("national_id_no").value=nric_no;
					//document.getElementById("national_id_no").focus();
					//setTimeout(document.getElementById("national_id_no").blur(),200);					

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

				setTimeout("populate_smart_crd_data_05('"+pat_name+"',"+nric_no+",'"+dob+"','"+expiry_date+"','"+blood_grp+"','"+nationality+"','"+gender+"','"+passport+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"','"+old_ic_no+"')",1000);


			}

			if(Calledfrom=='REGREF' ){ // Refferal Regn
				if(flg_pop_dat==0){
					document.getElementById("national_id_no").value=nric_no;
					document.getElementById("national_id_no").focus();
					setTimeout(document.getElementById("national_id_no").blur(),200);					

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

				setTimeout("populate_smart_crd_data_05('"+pat_name+"',"+nric_no+",'"+dob+"','"+expiry_date+"','"+blood_grp+"','"+nationality+"','"+gender+"','"+passport+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"','"+old_ic_no+"')",1000);


			}
*/
			if(Calledfrom=='AE' ){ // Register Attendance Uncommented  by santhosh for TH-KW-CRF-0019.1
				if(flg_pop_dat==0){
					document.getElementById("National_Id_No").value=nric_no;
					document.getElementById("National_Id_No").focus();
					setTimeout(document.getElementById("National_Id_No").blur(),200);					

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

			setTimeout("populate_smart_crd_data_05('"+pat_name+"',"+nric_no+",'"+dob+"','"+expiry_date+"','"+blood_grp+"','"+nationality+"','"+gender+"','"+passport+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"','"+old_ic_no+"')",1000);


			}
			
			if(Calledfrom=='OP' ){ // Added by santhosh for TH-KW-CRF-0019.1
				if(flg_pop_dat==0){
					document.getElementById("national_id_no").value=nric_no;
					document.getElementById("national_id_no").focus();
					setTimeout(document.getElementById("national_id_no").blur(),200);					

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

			setTimeout("populate_smart_crd_data_05('"+pat_name+"',"+nric_no+",'"+dob+"','"+expiry_date+"','"+blood_grp+"','"+nationality+"','"+gender+"','"+passport+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"','"+old_ic_no+"')",1000);


			}

/*			if(Calledfrom=='WTLST' ){ // Create Waitlist
				if(flg_pop_dat==0){
					document.getElementById("national_id_no").value=nric_no;
					document.getElementById("national_id_no").focus();
					setTimeout(document.getElementById("national_id_no").blur(),200);					

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}
			setTimeout("populate_smart_crd_data_05('"+pat_name+"',"+nric_no+",'"+dob+"','"+expiry_date+"','"+blood_grp+"','"+nationality+"','"+gender+"','"+passport+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"','"+old_ic_no+"')",1000);

			}

			if(Calledfrom=='IPBOOKING' ){ // IP Booking
				if(flg_pop_dat==0){
					document.getElementById("national_id_no").value=nric_no;
					document.getElementById("national_id_no").focus();
					setTimeout(document.getElementById("national_id_no").blur(),200);					

				}else{
					document.forms[0].txtSmartcard_dup.value="1";	
				}

				setTimeout("populate_smart_crd_data_05('"+pat_name+"',"+nric_no+",'"+dob+"','"+expiry_date+"','"+blood_grp+"','"+nationality+"','"+gender+"','"+passport+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"','"+old_ic_no+"')",1000);

			}
			*/


}


function populate_smart_crd_data_05(pat_name,nric_no,dob,expiry_date,blood_grp,nationality,gender,passport,addr_1,addr_2,addr_3,city_desc,state_desc,post_code,b_date,b_place,citizen_yn,race_desc,religion_desc,gender,time_of_birth,birth_cert_no,father_name,father_ic_no,mother_name,mother_ic_no,flg_pop_dat,Calledfrom,inst,old_ic_no){
	//alert('populate_smart_crd_data_05');

	if(document.forms[0].txtSmartcard_dup.value=="1"){

		if(document.forms[0].national_id_no.value==''){
			/* checkNatioanlity.jsp identified duplicate NRIC  */
		}else{
			
			set_values_05(pat_name,nric_no,dob,expiry_date,blood_grp,nationality,gender,passport,addr_1,addr_2,addr_3,city_desc,state_desc,post_code,b_date,b_place,citizen_yn,race_desc,religion_desc,gender,time_of_birth,birth_cert_no,father_name,father_ic_no,mother_name,mother_ic_no,flg_pop_dat,Calledfrom,inst,old_ic_no);
		}	
	
	}else if(document.forms[0].txtSmartcard_dup.value=="D"){
		
	}else{
 
		setTimeout("populate_smart_crd_data_05('"+pat_name+"',"+nric_no+",'"+dob+"','"+expiry_date+"','"+blood_grp+"','"+nationality+"','"+gender+"','"+passport+"','"+addr_1+"','"+addr_2+"','"+addr_3+"','"+city_desc+"','"+state_desc+"','"+post_code+"','"+b_date+"','"+b_place+"','"+citizen_yn+"','"+race_desc+"','"+religion_desc+"','"+gender+"','"+time_of_birth+"','"+birth_cert_no+"','"+father_name+"','"+father_ic_no+"','"+mother_name+"','"+mother_ic_no+"','"+flg_pop_dat+"','"+Calledfrom+"','"+inst+"','"+old_ic_no+"')",1000);

	}

}


function set_values_05(pat_name,nric_no,dob,expiry_date,blood_grp,nationality,gender,passport,addr_1,addr_2,addr_3,city_desc,state_desc,post_code,b_date,b_place,citizen_yn,race_desc,religion_desc,gender,time_of_birth,birth_cert_no,father_name,father_ic_no,mother_name,mother_ic_no,flg_pop_dat,Calledfrom,inst,old_ic_no){

//alert('set_values_05');
var function_name="";
//alert('Calledfrom : '+Calledfrom);
//alert('document.forms[0].nat_id_exp_date fff : '+document.forms[0].nat_id_exp_date.value);
//Values populates only for Patient Registration and Change Patient details
if(Calledfrom=='P' || Calledfrom=='CP')
{
		var pat_name1= pat_name.split(" ");
		var first_name=trimString(pat_name1[0]);
		var second_name=trimString(pat_name1[1]);
		var family_name="";
		family_name = trimString(pat_name.toString().replace(first_name,""));
		family_name = trimString(family_name.toString().replace(second_name,""));
				if (document.forms[0].family_name){
				if(family_name.length > document.getElementById("family_name").maxLength){
				family_name=family_name.substr(0,document.getElementById("family_name").maxLength);
				}
			
				document.forms[0].family_name.value=family_name;
				document.forms[0].family_name.focus();
				document.forms[0].family_name.blur();
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
			if (document.forms[0].alt_id1_no){

				document.forms[0].alt_id1_no.value=passport;
				document.forms[0].alt_id1_no.focus();
				document.forms[0].alt_id1_no.blur();
			}
		
			if (document.forms[0].nat_id_exp_date){
				document.forms[0].nat_id_exp_date.value=expiry_date;
				document.forms[0].nat_id_exp_date.focus();
				document.forms[0].nat_id_exp_date.blur();
			}
			if(document.forms[0].date_of_birth){
				document.forms[0].date_of_birth.disabled=false;
				document.forms[0].date_of_birth.value=dob;
				document.forms[0].date_of_birth.focus();
				setTimeout("document.forms[0].date_of_birth.blur()",2000);
			}

						
			if( document.forms[0].sex){
				if (gender == "M") {
					document.forms[0].sex.value='M';
				} else if (gender == "F") {
					document.forms[0].sex.value='F';
				}else{
					 document.forms[0].sex.value='U';
				}
			}
			
			if( document.forms[0].gender){
				if (gender == "M") {
					document.forms[0].gender.value='M';
				} else if (gender == "F") {
					document.forms[0].gender.value='F';
				}else{
					 document.forms[0].gender.value='U';
				}
			}

			/*
			//Commented for other fields to be populated
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

			if (document.getElementById("r_addr_line4")){
				if(city_desc.length > document.getElementById("r_addr_line4").maxLength){
					city_desc=city_desc.substr(0,document.getElementById("r_addr_line4").maxLength);
				}

				document.getElementById("r_addr_line4").value=city_desc;			
			}
			
			

			
			

			
			if(birth_cert_no !=''){
				if(document.forms[0].place_of_birth){

					document.forms[0].place_of_birth.value=b_place.substring(0,30);				
				}
			}

			if(time_of_birth!='' ){
				if( document.forms[0].b_time){
					var b_time=time_of_birth.split(':');
					document.forms[0].b_time.value=b_time[0]+":"+b_time[1];
				}				
			}
			

			if(old_ic_no!='' ){
				if( document.forms[0].other_alt_id){
					document.forms[0].other_alt_id.value='01';
				}

				if( document.forms[0].other_alt_Id_text){
					document.forms[0].other_alt_Id_text.value=old_ic_no;
				}
			}

			var mother_yn="N";
			if(mother_name!='' ){
				if( document.forms[0].next_contact_name){
					document.forms[0].next_contact_name.value=mother_name.substr(0,30);						
				}
				mother_yn="Y";	
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
				}
				father_yn="Y";
			}

			if(father_ic_no!='' ){
				if( document.forms[0].contact2_nat_id_no){
					document.forms[0].contact2_nat_id_no.value=father_ic_no;
				}
			}
*/

			
			//Commented to Avoid Rapid and Emergency
	/*		if(Calledfrom=='R' || Calledfrom=='E'){
				Calledfrom='P';
			}
*/
}
//Commented for other functions
/*			if(Calledfrom=='P'){
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
*/
	if(Calledfrom=='P'){
	function_name="PAT_REGN";
	}
	if(Calledfrom=='CP'){
	function_name="CHANGEPAT";
	}
//alert('function_name : '+function_name);
//alert('p_Calledfrom : '+p_Calledfrom);
				var flg_pop_dat=0;
			//commented for avoid to send other fields
			HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form2' id='form2' method='post' action='../../eMP/jsp/populateSmartCard.jsp'><input type='hidden' name='inst' id='inst' value=\""+p_inst+"\"><input type='hidden' name='Calledfrom' id='Calledfrom' value=\""+p_Calledfrom+"\"><input type='hidden' name='blood_group_desc' id='blood_group_desc' value=\""+blood_grp+"\"><input type='hidden' name='nationality_code' id='nationality_code' value=\""+nationality+"\"><input type='hidden' name='function_name' id='function_name' value=\""+function_name+"\"><input type='hidden' name='nric_val' id='nric_val' value=\""+nric_no+"\"><input type='hidden' name='nric' id='nric' value=\""+flg_pop_dat+"\"><input type='hidden' name='caller_form' id='caller_form' value='05'></form></body></html>";
			//HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/populateSmartCard.jsp'><input type='hidden' name='inst' id='inst' value=\""+p_inst+"\"><input type='hidden' name='Calledfrom' id='Calledfrom' value=\""+p_Calledfrom+"\"><input type='hidden' name='blood_group_desc' id='blood_group_desc' value=\""+blood_grp+"\"><input type='hidden' name='nationality_code' id='nationality_code' value=\""+nationality+"\"><input type='hidden' name='city_desc' id='city_desc' value=\""+city_desc+"\"><input type='hidden' name='state_desc' id='state_desc' value=\""+state_desc+"\"><input type='hidden' name='post_code' id='post_code' value=\""+post_code+"\"><input type='hidden' name='b_place' id='b_place' value=\""+b_place+"\"><input type='hidden' name='race_desc' id='race_desc' value=\""+race_desc+"\"><input type='hidden' name='religion_desc' id='religion_desc' value=\""+religion_desc+"\"><input type='hidden' name='function_name' id='function_name' value=\""+function_name+"\"><input type='hidden' name='nric_val' id='nric_val' value=\""+nric_no+"\"><input type='hidden' name='nric' id='nric' value=\""+flg_pop_dat+"\"><input type='hidden' name='caller_form' id='caller_form' value='05'><input type='hidden' name='from_OA' id='from_OA' value=\""+from_OA+"\"><input type='hidden' name='mother_yn' id='mother_yn' value=\""+mother_yn+"\"><input type='hidden' name='father_yn' id='father_yn' value=\""+father_yn+"\"><input type='hidden' name='birth_cert_no' id='birth_cert_no' value=\""+birth_cert_no+"\"></form></body></html>"; 
			if(Calledfrom=='P'){				
				parent.parent.messageFrame.document.write(HTMLVal);
				parent.parent.messageFrame.document.form2.submit();	
			}
				if(Calledfrom=='CP'){
				parent.parent.messageFrame.document.write(HTMLVal);
				parent.parent.messageFrame.document.form2.submit();		
			}
			//Commeneted for other functions

	/*		if(Calledfrom=='OAAP'){
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
			
				if(Calledfrom=='WTMGMT'){
				parent.messageFrame.document.write(HTMLVal);
				parent.messageFrame.document.form1.submit();		
			}
			
*/

		


		
}

function clear_smart_card_values_05(Calledfrom,inst){
//alert('clear_smart_card_values_05');
	
		document.forms[0].national_id_no.value='';
		
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
			//document.forms[0].gender.value='';
		}
	
		if (document.forms[0].nat_id_exp_date){
			 
				document.forms[0].nat_id_exp_date.value='';
				document.forms[0].nat_id_exp_date.focus();
				document.forms[0].nat_id_exp_date.blur();
			}
								
		document.forms[0].nationality_code.value='';
		document.forms[0].nationality_desc.value='';
		document.forms[0].blood_group.value='';
	/*	if(Calledfrom=='P'){
			document.forms[0].citizen[0].checked=true;
			document.forms[0].citizen[1].checked=false;
			document.forms[0].citizen_yn.value='Y';
			change_stat_dis();
		}
		*/
		//Commented for other fields to be cleared
	/*	
		if (document.forms[0].r_addr_line1){
			document.forms[0].r_addr_line1.value='';			
		}

		if (document.forms[0].r_addr_line2){
			document.forms[0].r_addr_line2.value='';			
		}

		if (document.forms[0].r_addr_line3){
			document.forms[0].r_addr_line3.value='';			
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
				*/

}

//Commented for patient search function
function populate_smart_crd_data_ps_05(pat_name,nric_no,dob,expiry_date,blood_grp,nationality,gender,passport,addr_1,addr_2,addr_3,city_desc,state_desc,post_code,b_date,b_place,citizen_yn,race_desc,religion_desc,gender,time_of_birth,birth_cert_no,father_name,father_ic_no,mother_name,mother_ic_no,flg_pop_dat,Calledfrom,inst,old_ic_no){

	var function_name="PS";
	
	if(document.forms[0].Patient_Id.value ==""){
		// populate data 
				
		/*var pat_name1= pat_name.split(" ");
		var first_name=trimString(pat_name1[0]);
		var second_name=trimString(pat_name1[1]);
		var family_name="";
		
		family_name = trimString(pat_name1.toString().replace(first_name,""));
		family_name = trimString(family_name.toString().replace(second_name,""));
			
			if (document.forms[0].family_name){
				if(family_name.length > document.getElementById("family_name").maxLength){
				family_name=family_name.substr(0,document.getElementById("family_name").maxLength);
				}
			
				document.forms[0].family_name.value=family_name;
				document.forms[0].family_name.focus();
				document.forms[0].family_name.blur();
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

		if (gender == "L") {
			document.forms[0].Sex.value='M';
		} else if (gender == "P") {
			document.forms[0].Sex.value='F';
		}else{
			 document.forms[0].Sex.value='U';
		}*/
		

				
		var flg_pop_dat=0;
		var function_name="PAT_SEARCH";
		
		
		HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/populateSmartCard.jsp'><input type='hidden' name='inst' id='inst' value=\""+p_inst+"\"><input type='hidden' name='Calledfrom' id='Calledfrom' value=\""+p_Calledfrom+"\"><input type='hidden' name='city_desc' id='city_desc' value=\""+city_desc+"\"><input type='hidden' name='state_desc' id='state_desc' value=\""+state_desc+"\"><input type='hidden' name='post_code' id='post_code' value=\""+post_code+"\"><input type='hidden' name='b_place' id='b_place' value=\""+b_place+"\"><input type='hidden' name='race_desc' id='race_desc' value=\""+race_desc+"\"><input type='hidden' name='religion_desc' id='religion_desc' value=\""+religion_desc+"\"><input type='hidden' name='nric_val' id='nric_val' value=\""+nric_no+"\"><input type='hidden' name='nric' id='nric' value=\""+flg_pop_dat+"\"><input type='hidden' name='caller_form' id='caller_form' value='04'><input type='hidden' name='function_name' id='function_name' value=\""+function_name+"\"><input type='hidden' name='birth_cert_no' id='birth_cert_no' value=\""+birth_cert_no+"\"></form></body></html>"; 
		
		parent.parent.messageFrame.document.write(HTMLVal);
		parent.parent.messageFrame.document.form1.submit();	
			
				
	}	
		
}

/*
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
*/


//Commented for Patient Search function
function clear_smart_card_values_ps_05(Calledfrom,inst){

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

function smart_card_data(params){
	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    var xmlStr ="<root><SEARCH ";
    xmlStr +=" /></root>";
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var param = "smart_card_data="+params;
    xmlHttp.open("POST","../../eMP/jsp/getPatientCount.jsp?"+param,false);
    xmlHttp.send(xmlDoc);
    var retVal = trimString(xmlHttp.responseText);
}

