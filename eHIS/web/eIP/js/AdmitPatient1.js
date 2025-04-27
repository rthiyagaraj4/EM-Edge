var proceedFurther	=	true;
var actionOnField	=	"";
	
/*
 *	This function is used to compare the given dates
 *  and returns true or false
 */
function ValidateDateTime (from,to)
{	
	from = from.value
	to	 = to.value

	var a = from.split(" ")
	splitdate=a[0];
	splittime=a[1]

	var splitdate1 =a[0].split("/")
	var splittime1= a[1].split(":")

	var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

	a = to.split(" ")
	splitdate=a[0];
	splittime=a[1]

	splitdate1 =a[0].split("/")
	splittime1= a[1].split(":")

	var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

	
	if(Date.parse(to_date) < Date.parse(from_date))
		return false
	else 
		return true;
}

/*
 *	This funtion is used to populate practioner details
 *  Arg1	: search button
 *	Arg2	: User entered value(Search value)
 */
function getPractID(obj,target)
{
	var sStyle	= document.forms[0].sStyle.value;
	var Spl_code= document.forms[0].SplDesc.value;
	if((Spl_code == null) || (Spl_code == ""))
	{	
		msg=getMessage('SPLTY_NOTNULL','IP');
		if (msg !="")
		{
			parent.parent.messageFrame.document.open();
			var s = "<html> <head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link></head>" +
			"<body class='message' onKeyDown='lockKey()'><script>document.writeln(\""+msg+"\");";
			s += "<\/script></body></html>"
			parent.parent.messageFrame.document.writeln(s);
		}
		document.forms[0].practid_desc.value = "";
		document.forms[0].att_practid_desc.value = "";
		document.forms[0].SplDesc.focus();
	}
	else
	{
		var sql					= "";
		var sql2				= "";
		var facility			= document.forms[0].hddfacility.value;
		var locale				= document.forms[0].locale.value;
		var nursing_unit_cd		= document.forms[0].nursing_unit.value;
		var splty				= document.forms[0].Splcode.value;
		var practName_FName		= target.name;
		var practName_FValue	= target.value;

		getPractitioner(obj, target, facility, splty,nursing_unit_cd,"Q5");

		/*sql = " SELECT a.practitioner_id practitioner_id,AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"','1') practitioner_name,AM_GET_DESC.AM_PRACT_TYPE(b.PRACT_TYPE,'"+locale+"','1') practitioner_type, AM_GET_DESC.AM_SPECIALITY(b.PRIMARY_SPECIALITY_CODE,'"+locale+"','2') primary_specialty,gender,AM_GET_DESC.AM_POSITION(b.position_code,'"+locale+"','1') job_title FROM IP_NURSING_UNIT_FOR_PRACT_VW a, AM_PRACT_ALL_SPLTY_VW b WHERE a.practitioner_id = b.practitioner_id AND a.facility_id = '"+facility+"' AND b.SPECIALTY_CODE = '"+splty+"' and a.facility_id = b.facility_id AND nursing_unit_code = '"+nursing_unit_cd+"' AND b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER (?) AND (UPPER (b.practitioner_id) LIKE UPPER (NVL (?, b.practitioner_id)) OR UPPER (AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"','1')) LIKE  UPPER (NVL (?, b.practitioner_name))) AND b.gender LIKE (?) AND (b.position_code LIKE (?) OR b.position_code IS NULL) ";

		sql2 = " SELECT a.practitioner_id practitioner_id,AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"','1') practitioner_name,AM_GET_DESC.AM_PRACT_TYPE(b.PRACT_TYPE,'"+locale+"','1') practitioner_type, AM_GET_DESC.AM_SPECIALITY(b.PRIMARY_SPECIALITY_CODE,'"+locale+"','2') primary_specialty,gender,AM_GET_DESC.AM_POSITION(b.position_code,'"+locale+"','1') job_title FROM IP_NURSING_UNIT_FOR_PRACT_VW a, AM_PRACT_ALL_SPLTY_VW b WHERE a.practitioner_id = b.practitioner_id AND a.facility_id = '"+facility+"' AND b.SPECIALTY_CODE = '"+splty+"' and a.facility_id = b.facility_id AND nursing_unit_code = '"+nursing_unit_cd+"' AND b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER (?) AND (   UPPER (b.practitioner_id) LIKE UPPER (NVL (?, b.practitioner_id)) and UPPER (AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"','1')) LIKE  UPPER (NVL (?, b.practitioner_name))) AND b.gender LIKE (?) AND (b.position_code LIKE (?) OR b.position_code IS NULL) ";

		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " practName_FName=\"" + practName_FName + "\"";
		xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
		xmlStr += " sql=\"" +escape(sql)+ "\"";
		xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
		xmlStr += " practitioner_type=\"" + "" + "\"";
		xmlStr += " specialty_code=\"" + splty+ "\"";
		xmlStr += " job_title=\"" + "" + "\"";
		xmlStr += " gender=\"" + "" + "\"";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);	
		*/
	}
}

/*
 *	This function is setting the practioner values 
 *	Arg1	:Practioner Id and practioner description
 *	Arg2	:Target name
 */

function PractLookupRetVal(retVal,objName)
{
	var arr;
	
	if (retVal != null)
	{
		arr=retVal.split("~");
		if(objName=='practid_desc')
		{
			document.forms[0].practid.value=arr[0];
			document.forms[0].practid_desc.value=arr[1];
			document.forms[0].practid_desc_hid.value = document.forms[0].practid_desc.value;
			PopulateMedicalTeam();
		}
		if(objName=='att_practid_desc')
		{
			document.forms[0].att_practid.value=arr[0];
			document.forms[0].att_practid_desc.value=arr[1];
			document.forms[0].att_practid_desc_hid.value = document.forms[0].att_practid_desc.value;
		}

	}
	else
	{
		if(objName=='practid_desc'){
		
			document.forms[0].practid.value="";
			document.forms[0].practid_desc.value="";
			document.forms[0].team_id.value="";
		}
		if(objName=='att_practid_desc'){
		
			document.forms[0].att_practid.value="";
			document.forms[0].att_practid_desc.value="";			
		}
	
	}
}


// * This fucntion is used to populate the medical team for given practioner-
 function PopulateMedicalTeam()
 { 
	 spy_code = document.forms[0].Splcode.value;
	var selected = AdmitPatient_form.team_id;
    while ( selected.options.length > 0 )
        selected.remove(selected.options[0]);

    var ippractid = AdmitPatient_form.practid.value;
    var getservice=AdmitPatient_form.practid.value;
    if (ippractid != null && ippractid != "")
    {
        var HTMLVal = "<html><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='querydept' id='querydept' method='post' action='../../eIP/jsp/MedicalTeamPopulate.jsp'><input type='hidden' name='spy_code' id='spy_code' value='"+spy_code+"'><input type='hidden' name='ippractid' id='ippractid' value='"+ippractid+"'><input type='hidden' name='booking' id='booking' value='admit'></form></body></html>";
        parent.parent.messageFrame.document.write(HTMLVal);
        parent.parent.messageFrame.document.querydept.submit();
    }
}


/* 
 *	This funtion is concatenated and passing to common contact details page
 *	and return values setting back to admit patient page fields 
 *  Arg1	: calling object
 */
async function Modal_Contact_Details(obj)
{       
		var isAlternateAddressAppl = parent.frames[2].document.AdmitPatient_form.isAlternateAddressAppl.value;//Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601
		var retVal =    new String();
		var dialogHeight= "90vh" ;
		var dialogWidth = "70vw" ;
		/*Modified by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
		if(isAlternateAddressAppl == "true")
			dialogWidth = "80" ;
		/*End*/
		var status = "no";
		var patient_id = parent.Select_frame.document.forms[0].patient_id.value;
		var concat_address_hidden= parent.frames[2].document.AdmitPatient_form.concat_address_hidden.value;

		var concat_address_hidden= parent.frames[2].document.AdmitPatient_form.addr1_type.value					+"^^"
		+ parent.frames[2].document.AdmitPatient_form.addr_line1.value						+"^^"
		+ parent.frames[2].document.AdmitPatient_form.addr_line2.value						+"^^"
		+ parent.frames[2].document.AdmitPatient_form.addr_line3.value						+"^^"
		+ parent.frames[2].document.AdmitPatient_form.addr_line4.value						+"^^"
		+ parent.frames[2].document.AdmitPatient_form.res_town_code.value			+"^^"
		+ parent.frames[2].document.AdmitPatient_form.res_area_code.value				+"^^"
		+ parent.frames[2].document.AdmitPatient_form.postal_code.value					+"^^"
		+ parent.frames[2].document.AdmitPatient_form.region_code.value					+"^^"
		+ parent.frames[2].document.AdmitPatient_form.country_code.value				+"^^"
		+ parent.frames[2].document.AdmitPatient_form.contact1_name.value				+"^^"
		+ parent.frames[2].document.AdmitPatient_form.invalid1_yn.value				+"^^"
		+ parent.frames[2].document.AdmitPatient_form.addr2_type.value					+"^^"
		+ parent.frames[2].document.AdmitPatient_form.mail_addr_line1.value			+"^^"
		+ parent.frames[2].document.AdmitPatient_form.mail_addr_line2.value			+"^^"
		+ parent.frames[2].document.AdmitPatient_form.mail_addr_line3.value			+"^^"
		+ parent.frames[2].document.AdmitPatient_form.mail_addr_line4.value			+"^^"
		+ parent.frames[2].document.AdmitPatient_form.mail_res_town_code.value	+"^^"
		+ parent.frames[2].document.AdmitPatient_form.mail_res_area_code.value	+"^^"
		+ parent.frames[2].document.AdmitPatient_form.mail_postal_code.value	    +"^^"
		+ parent.frames[2].document.AdmitPatient_form.mail_region_code.value		+"^^"
		+ parent.frames[2].document.AdmitPatient_form.mail_country_code.value+"^^"
		+ parent.frames[2].document.AdmitPatient_form.contact2_name.value		+"^^"
		+ parent.frames[2].document.AdmitPatient_form.invalid2_yn.value +"^^"
		+ parent.frames[2].document.AdmitPatient_form.contact1_no.value +"^^"
		+ parent.frames[2].document.AdmitPatient_form.contact2_no.value +"^^"
		+ parent.frames[2].document.AdmitPatient_form.email.value +"^^"
		+ parent.frames[2].document.AdmitPatient_form.change_address.value +"^^"
		+ parent.frames[2].document.AdmitPatient_form.res_town_desc.value +"^^"
		+ parent.frames[2].document.AdmitPatient_form.res_area_desc.value +"^^"
		+ parent.frames[2].document.AdmitPatient_form.region_desc.value +"^^"
		+ parent.frames[2].document.AdmitPatient_form.mail_res_town_desc.value +"^^"
		+ parent.frames[2].document.AdmitPatient_form.mail_res_area_desc.value +"^^"
		+ parent.frames[2].document.AdmitPatient_form.mail_region_desc.value +"^^" 
		+ parent.frames[2].document.AdmitPatient_form.country_desc.value  +"^^" +parent.frames[2].document.AdmitPatient_form.mail_country_desc.value+"^^" +parent.frames[2].document.AdmitPatient_form.postal_desc.value+"^^" +parent.frames[2].document.AdmitPatient_form.mail_postal_desc.value;
		
		/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
		if(isAlternateAddressAppl == "true"){
			concat_address_hidden = concat_address_hidden+"^^"
									+parent.frames[2].document.AdmitPatient_form.alt_addr_line1.value+"^^"
									+parent.frames[2].document.AdmitPatient_form.alt_addr_line2.value+"^^"
									+parent.frames[2].document.AdmitPatient_form.alt_addr_line3.value+"^^"
									+parent.frames[2].document.AdmitPatient_form.alt_addr_line4.value+"^^"
									+parent.frames[2].document.AdmitPatient_form.alt_town_code.value	+"^^"
									+parent.frames[2].document.AdmitPatient_form.alt_area_code.value	+"^^"
									+parent.frames[2].document.AdmitPatient_form.alt_postal_code.value +"^^"
									+parent.frames[2].document.AdmitPatient_form.alt_region_code.value +"^^"
									+parent.frames[2].document.AdmitPatient_form.alt_country_code.value +"^^"
									+parent.frames[2].document.AdmitPatient_form.alt_town_desc.value +"^^"
									+parent.frames[2].document.AdmitPatient_form.alt_area_desc.value +"^^"
									+parent.frames[2].document.AdmitPatient_form.alt_postal_desc.value +"^^"
									+parent.frames[2].document.AdmitPatient_form.alt_region_desc.value +"^^"
									+parent.frames[2].document.AdmitPatient_form.alt_country_desc.value ;
		}/*End*/
	
		var arguments	=concat_address_hidden;
		var calling_from = "";
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = await window.showModalDialog( "../../eMP/jsp/ContactDetailsFrame.jsp?patient_id="+patient_id,arguments,features);
		if(retVal != null)
		{
			 parent.frames[2].document.AdmitPatient_form.concat_address_hidden.value=retVal;
			 var arr_concat_vals=retVal.split("^^");
			
			 parent.frames[2].document.AdmitPatient_form.addr1_type.value					= arr_concat_vals[0];  
			 parent.frames[2].document.AdmitPatient_form.addr_line1.value						= arr_concat_vals[1]; 
			 parent.frames[2].document.AdmitPatient_form.addr_line2.value						= arr_concat_vals[2]; 
			 parent.frames[2].document.AdmitPatient_form.addr_line3.value						= arr_concat_vals[3]; 
			 parent.frames[2].document.AdmitPatient_form.addr_line4.value						= arr_concat_vals[4]; 
			 parent.frames[2].document.AdmitPatient_form.res_town_code.value			= arr_concat_vals[5]; 
			 parent.frames[2].document.AdmitPatient_form.res_area_code.value				= arr_concat_vals[6]; 
			 parent.frames[2].document.AdmitPatient_form.postal_code.value					= arr_concat_vals[7]; 
			 parent.frames[2].document.AdmitPatient_form.region_code.value					= arr_concat_vals[8]; 
			 parent.frames[2].document.AdmitPatient_form.country_code.value				= arr_concat_vals[9]; 
			 parent.frames[2].document.AdmitPatient_form.contact1_name.value			= arr_concat_vals[10]; 
			 parent.frames[2].document.AdmitPatient_form.invalid1_yn.value				= arr_concat_vals[11]; 

			 parent.frames[2].document.AdmitPatient_form.addr2_type.value					= arr_concat_vals[12]; 
			 parent.frames[2].document.AdmitPatient_form.mail_addr_line1.value			= arr_concat_vals[13];
			 parent.frames[2].document.AdmitPatient_form.mail_addr_line2.value			= arr_concat_vals[14];
			 parent.frames[2].document.AdmitPatient_form.mail_addr_line3.value			= arr_concat_vals[15];
			 parent.frames[2].document.AdmitPatient_form.mail_addr_line4.value			= arr_concat_vals[16]; 
			 parent.frames[2].document.AdmitPatient_form.mail_res_town_code.value	= arr_concat_vals[17]; 
			 parent.frames[2].document.AdmitPatient_form.mail_res_area_code.value	= arr_concat_vals[18]; 
			 parent.frames[2].document.AdmitPatient_form.mail_postal_code.value	    = arr_concat_vals[19]; 

			 parent.frames[2].document.AdmitPatient_form.mail_region_code.value		=  arr_concat_vals[20]; 
			 parent.frames[2].document.AdmitPatient_form.mail_country_code.value		=  arr_concat_vals[21]; 
			 parent.frames[2].document.AdmitPatient_form.contact2_name.value		=  arr_concat_vals[22]; 
			 parent.frames[2].document.AdmitPatient_form.invalid2_yn.value		=  arr_concat_vals[23]; 
			 parent.frames[2].document.AdmitPatient_form.contact1_no.value		=  arr_concat_vals[24];
			 parent.frames[2].document.AdmitPatient_form.contact2_no.value		=  arr_concat_vals[25];
			 parent.frames[2].document.AdmitPatient_form.email.value		=  arr_concat_vals[26];
			 parent.frames[2].document.AdmitPatient_form.change_address.value  = 'Y';

			 parent.frames[2].document.AdmitPatient_form.res_town_desc.value =arr_concat_vals[27];
		     parent.frames[2].document.AdmitPatient_form.res_area_desc.value =arr_concat_vals[28];
		     parent.frames[2].document.AdmitPatient_form.region_desc.value =arr_concat_vals[29];

		     parent.frames[2].document.AdmitPatient_form.mail_res_town_desc.value =arr_concat_vals[30];
		     parent.frames[2].document.AdmitPatient_form.mail_res_area_desc.value =arr_concat_vals[31];
		     parent.frames[2].document.AdmitPatient_form.mail_region_desc.value =arr_concat_vals[32];
			 parent.frames[2].document.AdmitPatient_form.country_desc.value =arr_concat_vals[33];
			 parent.frames[2].document.AdmitPatient_form.mail_country_desc.value =arr_concat_vals[34];
			 parent.frames[2].document.AdmitPatient_form.postal_desc.value =arr_concat_vals[35];
			 parent.frames[2].document.AdmitPatient_form.mail_postal_desc.value =arr_concat_vals[36];
			 /*Added by Thamizh selvi on 25th Jan 2018 against ML-MMOH-CRF-0601 Start*/
			 if(isAlternateAddressAppl == "true"){
				parent.frames[2].document.AdmitPatient_form.alt_addr_line1.value	= arr_concat_vals[37];
				parent.frames[2].document.AdmitPatient_form.alt_addr_line2.value	= arr_concat_vals[38];
				parent.frames[2].document.AdmitPatient_form.alt_addr_line3.value	= arr_concat_vals[39];
				parent.frames[2].document.AdmitPatient_form.alt_addr_line4.value	= arr_concat_vals[40];
				parent.frames[2].document.AdmitPatient_form.alt_town_code.value		= arr_concat_vals[41];
				parent.frames[2].document.AdmitPatient_form.alt_area_code.value		= arr_concat_vals[42];
				parent.frames[2].document.AdmitPatient_form.alt_postal_code.value	= arr_concat_vals[43];
				parent.frames[2].document.AdmitPatient_form.alt_region_code.value	= arr_concat_vals[44];
				parent.frames[2].document.AdmitPatient_form.alt_country_code.value	= arr_concat_vals[45];
				parent.frames[2].document.AdmitPatient_form.alt_town_desc.value		= arr_concat_vals[46];
				parent.frames[2].document.AdmitPatient_form.alt_area_desc.value		= arr_concat_vals[47];
				parent.frames[2].document.AdmitPatient_form.alt_postal_desc.value	= arr_concat_vals[48];
				parent.frames[2].document.AdmitPatient_form.alt_region_desc.value	= arr_concat_vals[49];
				parent.frames[2].document.AdmitPatient_form.alt_country_desc.value	= arr_concat_vals[50];
			 }/*End*/
		}
}

/*
 *	This funtion is used to assign the values to all fields after splitting the contact details
 */
function contactDetailsAssign()
{
	var isAlternateAddressAppl = parent.frames[1].frames[2].document.AdmitPatient_form.isAlternateAddressAppl.value;//Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601
	var concat_address_hidden = parent.frames[1].frames[2].document.AdmitPatient_form.concat_address_hidden.value;
	if(concat_address_hidden != "")
	{
		var arr_concat_vals=concat_address_hidden.split("^^");

		parent.frames[1].frames[2].document.AdmitPatient_form.addr1_type.value= arr_concat_vals[0];
		parent.frames[1].frames[2].document.AdmitPatient_form.addr_line1.value= arr_concat_vals[1]; 
		parent.frames[1].frames[2].document.AdmitPatient_form.addr_line2.value= arr_concat_vals[2]; 
		parent.frames[1].frames[2].document.AdmitPatient_form.addr_line3.value= arr_concat_vals[3]; 
		parent.frames[1].frames[2].document.AdmitPatient_form.addr_line4.value= arr_concat_vals[4]; 
		parent.frames[1].frames[2].document.AdmitPatient_form.res_town_code.value= arr_concat_vals[5]; 
		parent.frames[1].frames[2].document.AdmitPatient_form.res_area_code.value= arr_concat_vals[6]; 
		parent.frames[1].frames[2].document.AdmitPatient_form.postal_code.value= arr_concat_vals[7]; 
		parent.frames[1].frames[2].document.AdmitPatient_form.region_code.value= arr_concat_vals[8]; 
		parent.frames[1].frames[2].document.AdmitPatient_form.country_code.value= arr_concat_vals[9]; 
		parent.frames[1].frames[2].document.AdmitPatient_form.contact1_name.value= arr_concat_vals[10];
		parent.frames[1].frames[2].document.AdmitPatient_form.invalid1_yn.value= arr_concat_vals[11];
		parent.frames[1].frames[2].document.AdmitPatient_form.addr2_type.value= arr_concat_vals[12];
		parent.frames[1].frames[2].document.AdmitPatient_form.mail_addr_line1.value= arr_concat_vals[13];
		parent.frames[1].frames[2].document.AdmitPatient_form.mail_addr_line2.value= arr_concat_vals[14];
		parent.frames[1].frames[2].document.AdmitPatient_form.mail_addr_line3.value= arr_concat_vals[15];
		parent.frames[1].frames[2].document.AdmitPatient_form.mail_addr_line4.value= arr_concat_vals[16]; 
		parent.frames[1].frames[2].document.AdmitPatient_form.mail_res_town_code.value= arr_concat_vals[17]; 
		parent.frames[1].frames[2].document.AdmitPatient_form.mail_res_area_code.value= arr_concat_vals[18]; 
		parent.frames[1].frames[2].document.AdmitPatient_form.mail_postal_code.value= arr_concat_vals[19]; 
		parent.frames[1].frames[2].document.AdmitPatient_form.mail_region_code.value=  arr_concat_vals[20]; 
		parent.frames[1].frames[2].document.AdmitPatient_form.mail_country_code.value=  arr_concat_vals[21]; 
		parent.frames[1].frames[2].document.AdmitPatient_form.contact2_name.value=  arr_concat_vals[22]; 
		parent.frames[1].frames[2].document.AdmitPatient_form.invalid2_yn.value=  arr_concat_vals[23]; 
		parent.frames[1].frames[2].document.AdmitPatient_form.contact1_no.value=  arr_concat_vals[24];
		parent.frames[1].frames[2].document.AdmitPatient_form.contact2_no.value=  arr_concat_vals[25];
		parent.frames[1].frames[2].document.AdmitPatient_form.email.value=  arr_concat_vals[26];
		parent.frames[1].frames[2].document.AdmitPatient_form.change_address.value  = 'Y';
		parent.frames[1].frames[2].document.AdmitPatient_form.res_town_desc.value =arr_concat_vals[28];
		parent.frames[1].frames[2].document.AdmitPatient_form.res_area_desc.value =arr_concat_vals[29];
		parent.frames[1].frames[2].document.AdmitPatient_form.region_desc.value =arr_concat_vals[30];
		parent.frames[1].frames[2].document.AdmitPatient_form.mail_res_town_desc.value =arr_concat_vals[31];
		parent.frames[1].frames[2].document.AdmitPatient_form.mail_res_area_desc.value =arr_concat_vals[32];
		parent.frames[1].frames[2].document.AdmitPatient_form.mail_region_desc.value =arr_concat_vals[33];
		parent.frames[1].frames[2].document.AdmitPatient_form.country_desc.value= arr_concat_vals[34];
		parent.frames[1].frames[2].document.AdmitPatient_form.mail_country_desc.value= arr_concat_vals[35];
		parent.frames[1].frames[2].document.AdmitPatient_form.postal_desc.value= arr_concat_vals[36];
		parent.frames[1].frames[2].document.AdmitPatient_form.mail_postal_desc.value= arr_concat_vals[37];
		/*Added by Thamizh selvi on 31st Jan 2018 against ML-MMOH-CRF-0601 Start*/
		if(isAlternateAddressAppl == "true"){
			parent.frames[1].frames[2].document.AdmitPatient_form.alt_addr_line1.value		= arr_concat_vals[38];
			parent.frames[1].frames[2].document.AdmitPatient_form.alt_addr_line2.value		= arr_concat_vals[39];
			parent.frames[1].frames[2].document.AdmitPatient_form.alt_addr_line3.value		= arr_concat_vals[40];
			parent.frames[1].frames[2].document.AdmitPatient_form.alt_addr_line4.value		= arr_concat_vals[41];
			parent.frames[1].frames[2].document.AdmitPatient_form.alt_town_code.value		= arr_concat_vals[42];
			parent.frames[1].frames[2].document.AdmitPatient_form.alt_town_desc.value		= arr_concat_vals[43];
			parent.frames[1].frames[2].document.AdmitPatient_form.alt_area_code.value		= arr_concat_vals[44];
			parent.frames[1].frames[2].document.AdmitPatient_form.alt_area_desc.value		= arr_concat_vals[45];
			parent.frames[1].frames[2].document.AdmitPatient_form.alt_region_code.value		= arr_concat_vals[46];
			parent.frames[1].frames[2].document.AdmitPatient_form.alt_region_desc.value		= arr_concat_vals[47];
			parent.frames[1].frames[2].document.AdmitPatient_form.alt_postal_code.value		= arr_concat_vals[48];
			parent.frames[1].frames[2].document.AdmitPatient_form.alt_postal_desc.value		= arr_concat_vals[49];
			parent.frames[1].frames[2].document.AdmitPatient_form.alt_country_code.value	= arr_concat_vals[50];
			parent.frames[1].frames[2].document.AdmitPatient_form.alt_country_desc.value	= arr_concat_vals[51];
		}
		/*End*/
	}
			
}

function onServiceChange()
{
	if(document.forms[0].service.value!='')
	PopulateSubService('A');
}

function PopulateSubService(fVal)
{
	var from = fVal;
	var nursingunit = "";
	var serviceCode = "";
	var patient_class_id = "";
	var bed_no		= "";

	if(fVal == 'G')
		{
			nursingunit = parent.frames[1].frames[2].document.forms[0].nursing_unit.value;
			bed_no		= parent.frames[1].frames[2].document.AdmitPatient_form.bed_no.value
	}else
	{
			nursingunit = parent.frames[2].document.forms[0].nursing_unit.value;
			bed_no		= parent.frames[2].document.forms[0].bed_no.value;
	}
	var from_adv_bed_mgmt="";
	if(document.forms[0].from_adv_bed_mgmt){
		from_adv_bed_mgmt=document.forms[0].from_adv_bed_mgmt.value;
	}
	var HTMLVal =	" <html><body class='MESSAGE' onKeyDown='lockKey()'> <form name='dum_form' id='dum_form' "+
			" method='post' action='../../eIP/jsp/AdmissionValidation.jsp'>"+
			" <input type='hidden' name='field1' id='field1' value=''> "+
			" <input type='hidden' name='field2' id='field2' value=''> "+
			" <input type='hidden' name='field3' id='field3' value='"+nursingunit+"'> "+
			" <input type='hidden' name='field4' id='field4' value='Main_form'> "+
			" <input type='hidden' name='fVal' id='fVal' value='"+from+"'> "+
			" <input type='hidden' name='from_adv_bed_mgmt' id='from_adv_bed_mgmt' value='"+from_adv_bed_mgmt+"'> "+
			" <input type='hidden' name='field5' id='field5' value='"+bed_no+"'> ";
	if(fVal == 'G')
	{
		serviceCode = parent.frames[1].frames[2].document.forms[0].service.value;
		patient_class_id = parent.frames[1].frames[2].document.forms[0].patient_class_id.value
		HTMLVal += 
			" <input type='hidden' name='serviceCode' id='serviceCode' value='"+serviceCode+"'> "+" <input type='hidden' name='Patient_class' id='Patient_class' value='"+patient_class_id+"'> "+" <input type='hidden' name='frame_ref' id='frame_ref' value='parent.frames[2]'>  </form></body></html>";
		
		if(parent.frames[1].frames[4].document.body != null)
		{		

			parent.frames[1].frames[4].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.frames[1].frames[4].document.dum_form.submit();
		}
	}
	else
	{
		serviceCode = parent.frames[2].document.forms[0].service.value;
		patient_class_id = parent.frames[2].document.forms[0].patient_class_id.value
		HTMLVal += 
			" <input type='hidden' name='serviceCode' id='serviceCode' value='"+serviceCode+"'> "+" <input type='hidden' name='Patient_class' id='Patient_class' value='"+patient_class_id+"'> "+" <input type='hidden' name='frame_ref' id='frame_ref' value='parent.frames[1].frames[2]'>  </form></body></html>";
		if(parent.parent.messageFrame.document.body != null)
		{	

			parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.parent.messageFrame.document.dum_form.submit();
		}
	}

}
//Added to assign the value from the servlet while calling the file component.
function assignnewfileno(val)
{
	if(document.forms[0].new_file_no != null)
	{
		document.forms[0].new_file_no.value=val;
		document.forms[0].new_file_no.value=val;
	}
}
/*
	 * This function is used to populate the modal windows based on selection
	 * Ex: for booking ref no booking list look up
	 *     for referral id referral list look up		
	 */
	async function callSearchScreen(val)
	{
		if(val == 'P')
		{
			if (document.Select_form.register_pat_in_admn_yn.value=="Y")
				var patID=await PatientSearch('','','','','','','','Y','Y','AdmitPatient');
			else
				var patID=await PatientSearch();
 
			if(patID == 'undefined' || patID == null)
			{
				document.Select_form.patient_id.value = '';
			}
			else
			{
			
			document.Select_form.patient_id.value = patID;
					
				/*Below Added for MOHE-SCF-0177-TF*/
				pat_flag=patID[0];
				var pat_len  = patID.length;
				var Patient_Id_Length= document.Select_form.Patient_Id_Length.value;
               
				if((pat_flag == 'Y') && (pat_len > Patient_Id_Length))
				{  
					var patientid=patID.substring(1,patID.length);
					document.Select_form.patient_id.value = patientid;
					document.Select_form.pat_flag.value=pat_flag;
					
				}
				else
				{   
					document.Select_form.patient_id.value = patID;
					pat_flag = 'N';
					document.Select_form.pat_flag.value=pat_flag;
				}
			}
			
			//document.Select_form.patient_id.focus();
			document.Select_form.patient_id.onblur();
			if((top && top.f_query_add_mod) && (top.f_query_add_mod.Main_frame && (top.f_query_add_mod.Main_frame.AdmitPatient_form.from_adv_bed_mgmt && top.f_query_add_mod.Main_frame.AdmitPatient_form.from_adv_bed_mgmt.value=='Y'))){
				top.commontoolbarFrame.location.href='../../eIP/jsp/AdmitPatientToolbar.jsp?from_adv_bed_mgmt=Y'
			}else if(parent.content!=null)
			{
				parent.content.frames[0].location.href='../../eCommon/jsp/commonToolbar.jsp?'+parent.parent.f_query_add_mod.frames[0].document.forms[0].queryString.value;
			}
			else
			{		
				parent.parent.frames[0].location.href='../../eCommon/jsp/commonToolbar.jsp?'+parent.parent.f_query_add_mod.frames[0].document.forms[0].queryString.value;
			}
		}
		else if(val == 'B')
		{
			var retVal =    new String();
			var operatorstation  = document.Select_form.operator_station.value;
			var dialogTop   = "10";
			var dialogHeight= "900px" ;
			var dialogWidth = "1300px" ;
			var features    ="dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
			var arguments   = "" ;
	        
			var admission_for  = document.Select_form.admission_for.value;
			var noshow_bkng_period = parent.frames[0].document.Select_form.noshow_bkng_period.value;
			retVal= await window.showModalDialog("../../eIP/jsp/BookingReferenceLookup.jsp?param=ADMIT&oper_stn_id="+operatorstation+"&admission_for="+admission_for+"&noshow_bkng_period="+noshow_bkng_period+"&call_function=AT",arguments,features);
						
			if(retVal != null)
			{
				var bkr_ref = retVal.split(",")
				var value1=bkr_ref[0];
				var	value2=bkr_ref[1];
				var	value3=bkr_ref[2];
				var value4=bkr_ref[3];
				var value5="";
				value5=bkr_ref[4];
				document.Select_form.patient_id.value = value5;
				
				document.Select_form.booking_ref_no.value = value1
				if(value2 != '' && value2 != null);
				document.Select_form.bkg_type.value = value2;
				if(value3 != '' && value3 != null)
				document.Select_form.clin_code.value = value3;
				if(value4 != '' && value4 != null)
				document.Select_form.referral_id.value = value4;
				parent.frames[2].document.AdmitPatient_form.d_referral_id.value=value4;
				parent.frames[2].document.AdmitPatient_form.d_clinic_code.value=value3;
				document.Select_form.booking_ref_no.onblur();

								
			}
			document.Select_form.book_ref_no_search.focus();
		}
	/*	else if(val=='E')
		{
			var retVal =    new String();
			var dialogHeight = "33.4" ;
			var dialogWidth  = "50" ;
			var dialogTop    = "65";
			 var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;"+"dialogTop:" + dialogTop ;
			var arguments   = "" ;
			retVal = window.showModalDialog("../../eMP/jsp/PaintSearchVisit.jsp",arguments,features);
			if(retVal != null)
			{
				retVal = retVal.split("|");
				document.Select_form.encounter_id.value = retVal[0];
				document.Select_form.encounter_id.focus();
			}
		}*/
			
	 }
	 
	 // added by munisekhar for MMS-QH-CRF-0162
async function getPatientDetails(patient_id,fun_id){

	var dialogHeight = '90vh';
	var dialogWidth = '95vw';
	var wintop = '65';
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +  '; dialogTop: ' + wintop +';status=no';
	var arguments = '';
	var retVal = '';
	//called_from_newborn changed as "N" by Dharma against MMS-DM-SCF-0611 [IN:070200] on 15th Apr 2019
	//var param = "../../eMP/jsp/ChangePatientDetails.jsp?step=1&menu_id=MP&called_from_newborn=Y&module_id=MP&function_id=CHG_PAT_DTLS&function_name=Change Patient Details&function_type=F&home_required_yn=N&access=NYNNN&Patient_ID="+patient_id;
	var param = "../../eMP/jsp/ChangePatientDetails.jsp?step=1&menu_id=MP&called_from_newborn=N&module_id=MP&function_id=CHG_PAT_DTLS&function_name=Change Patient Details&function_type=F&home_required_yn=N&access=NYNNN&Patient_ID="+patient_id;
	
	var retVal = await top.window.showModalDialog(param,arguments,features);
	if(retVal == true)
	{
	parent.frames[1].location.href='../../eCommon/jsp/pline.jsp?Patient_Id='+patient_id;
   if(document.forms[0].booking_ref_no.value!=""){ 
	parent.frames[2].document.forms[0].reset();
	document.Select_form.validatePat_yn.value='N';
	//Belw line added for this insident 52345
	if(parent.frames[2].document.AdmitPatient_form.attend_img&&parent.frames[2].document.AdmitPatient_form.attend_img.style.visibility){parent.frames[2].document.AdmitPatient_form.attend_img.style.visibility="hidden";}
	validatePat(document.forms[0].booking_ref_no,'Booking Ref No');
	} else if(document.forms[0].referral_id.value!=""){ 
	parent.frames[2].document.forms[0].reset();
	document.Select_form.validatePat_yn.value='N';
	//Belw line added for this incident 52345
	if(parent.frames[2].document.AdmitPatient_form.attend_img&&parent.frames[2].document.AdmitPatient_form.attend_img.style.visibility){parent.frames[2].document.AdmitPatient_form.attend_img.style.visibility="hidden";}
	validatePat(document.forms[0].referral_id,'Referral ID');
	}else {
	parent.frames[2].document.forms[0].reset();
	document.Select_form.validatePat_yn.value='N';
	//Belw line added for this incident 52345
	if(parent.frames[2].document.AdmitPatient_form.attend_img&&parent.frames[2].document.AdmitPatient_form.attend_img.style.visibility){parent.frames[2].document.AdmitPatient_form.attend_img.style.visibility="hidden";}
	validatePat(document.forms[0].patient_id,'Patient ID');
	}
	
	}/*Below line added for this CRF MMS-QH-CRF-0162.1*/
	if(retVal == undefined){
	parent.frames[2].document.forms[0].reset();
	document.Select_form.validatePat_yn.value='N'; parent.frames[2].document.AdmitPatient_form.bed_no
	//Belw line added for this incident 52345
    if(parent.frames[2].document.AdmitPatient_form.attend_img&&parent.frames[2].document.AdmitPatient_form.attend_img.style.visibility){parent.frames[2].document.AdmitPatient_form.attend_img.style.visibility="hidden";}
	
	validatePat(document.forms[0].patient_id,'Patient ID');
	}//End MMS-QH-CRF-0162.1
	
	if(retVal == undefined || retVal == true) {
		changeToolBar(fun_id);
	} 
	
}
// added by munisekhar for MMS-QH-CRF-0162
function changeToolBar(fun_id) {

        if(fun_id="Y")
		{ 	 
         home_required_yn = 'N';	
		}else{
		    home_required_yn = 'Y';
			parent.parent.commontoolbarFrame.location.href = '../../eCommon/jsp/commonToolbar.jsp?module_id=IP&function_id=ADMISSION&function_name=Admit Patient &function_type=F&access=NYNNN&home_required_yn='+home_required_yn;
			parent.parent.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
		}
		}
	 
	 // added by munisekhar for MMS-QH-CRF-0162
	 function ChangePatVisHid(){
	 if(parent.frames[1].frames[0].document.forms[0]){
		var isSiteSpe_change_pat_dtls=parent.frames[1].frames[0].document.forms[0].isSiteSpe_change_pat_dtls.value
		var userFunRightsCount	= parseInt(parent.frames[1].frames[0].document.forms[0].userFunRightsCount.value);//Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]
	 }

	if(isSiteSpe_change_pat_dtls=="true" && userFunRightsCount > 0){
		if(parent.frames[1].frames[0].document.forms[0].patient_id.value!="" ){
		parent.frames[1].frames[0].document.getElementById("Update_pat").style.visibility="visible";
		}else{
		parent.frames[1].frames[0].document.getElementById("Update_pat").style.visibility="hidden";
		}
		}
		}

	
	/*
	* This function will call the AdmissionValidation.jsp if patient id or referral id * or enocutner id or booking ref no exists
	*/
    function validateSelect(obj)
    {

		parent.frames[1].location.href = '../../eCommon/html/blank.html';
		
		if( document.Select_form.patient_id.value != "")
			var patient     = document.Select_form.patient_id.value;
		else
			var patient="";
		
		initFields();

        var admission_for  = document.Select_form.admission_for.value;
        var bookingref  = document.Select_form.booking_ref_no.value;
        var referralid      = document.Select_form.referral_id.value;
		var operatorstation  = document.Select_form.operator_station.value;
		if(patient != '')
		{
			if(bookingref != '' && document.Select_form.bkg_type.value != 'D')
			{
				document.Select_form.bkg_type.value='I';
			}
			else
				document.Select_form.bkg_type.value='D';
		}
		var bkg_type		=document.Select_form.bkg_type.value;
		var queryString = document.Select_form.queryString.value;
		var visit_adm_date_time = "";
		if(parent.frames[2].document.AdmitPatient_form.visit_adm_date_time != null)
		{
			//visit_adm_date_time	=	parent.frames[2].document.AdmitPatient_form.visit_adm_date_time.value;
			visit_adm_date_time	=	convertDate(parent.frames[2].document.AdmitPatient_form.visit_adm_date_time.value,'DMYHM',localeName,'en');
		}
		parent.frames[2].document.forms[0].team_id.disabled = false;

		
		if( !(proceedFurther) && actionOnField!=obj ) 
		{
			
			return false;
		}
		proceedFurther	=	false;
		actionOnField	=	obj;
	
        if(referralid !=''  || bookingref != '' || patient != '' )
        {
			
			var HTMLVal = "<html><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='dum_form' id='dum_form' method='post' action='../../eIP/jsp/AdmissionValidation1.jsp'><input type='hidden' name='field1' id='field1' value=\""+bookingref+"\"> "+
			" <input type='hidden' name='field2' id='field2' value=\""+patient+"\"><input type='hidden' name='field3' id='field3' value=''>"+
			"<input type='hidden' name='field4' id='field4' value='Select_form'>"+
			"<input type='hidden' name='field5' id='field5' value=\""+referralid+"\"> "+
			"<input type='hidden' name='queryString' id='queryString' value=\""+queryString+"\"> "+
			"<input type='hidden' name='visit_adm_date_time' id='visit_adm_date_time' value=\""+visit_adm_date_time+"\"> "+
			"<input type='hidden' name='booking_type' id='booking_type' value=\""+bkg_type+"\"> "+
			"<input type='hidden' name='operator_station' id='operator_station' value=\""+operatorstation+"\"> "+
			"<input type='hidden' name='admission_for' id='admission_for' value=\""+admission_for+"\"> "+
			"</form></body></html>";
			
			parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		    parent.parent.messageFrame.document.dum_form.submit();
			if(parent.frames[2].document.AdmitPatient_form.pat_check_in_allowed_yn.value != "Y")
			{
				parent.frames[2].document.AdmitPatient_form.attend_img.style.visibility = 'visible';
			}
			
        }
    }
	function initFields(patientid)
	 {
			if(parent.frames[2].document.AdmitPatient_form)
			{
				if(	parent.frames[2].document.AdmitPatient_form.exp_days_stay != null)
					parent.frames[2].document.AdmitPatient_form.exp_days_stay.readOnly = true;
				parent.frames[2].document.AdmitPatient_form.team_id.disabled = true;
			 
//				parent.frames[2].document.AdmitPatient_form.Bedcode.disabled = true;
				parent.frames[2].document.AdmitPatient_form.nursing_unit.disabled = true;
//				parent.frames[2].document.AdmitPatient_form.visit_adm_type.disabled = true;
				
				parent.frames[2].document.AdmitPatient_form.arrival_code.disabled = true;
				parent.frames[2].document.AdmitPatient_form.ambulatory_status.disabled = true;
				if(parent.frames[2].document.AdmitPatient_form.visit_adm_date_time != null)
				{
					parent.frames[2].document.AdmitPatient_form.visit_adm_date_time.readOnly = true;
				}
				parent.frames[2].document.AdmitPatient_form.ot_date_time.readOnly = true;
//				parent.frames[2].document.AdmitPatient_form.bed_no.readOnly = true;
//				parent.frames[2].document.AdmitPatient_form.room_no.readOnly = true;
		 
				parent.frames[2].document.AdmitPatient_form.escort_name.readOnly = true;
				if(parent.frames[2].document.AdmitPatient_form.escort_add_ln1)
					parent.frames[2].document.AdmitPatient_form.escort_add_ln1.readOnly = true;
				if(parent.frames[2].document.AdmitPatient_form.escort_add_ln2)
					parent.frames[2].document.AdmitPatient_form.escort_add_ln2.readOnly = true;
				if(parent.frames[2].document.AdmitPatient_form.escort_add_ln3)
					parent.frames[2].document.AdmitPatient_form.escort_add_ln3.readOnly = true;
				if(parent.frames[2].document.AdmitPatient_form.escort_add_ln4)
					parent.frames[2].document.AdmitPatient_form.escort_add_ln4.readOnly = true;
				if(parent.frames[2].document.AdmitPatient_form.escort_add_postal_code)
					parent.frames[2].document.AdmitPatient_form.escort_add_postal_code.readOnly = true;
				parent.frames[2].document.AdmitPatient_form.escort_tel_num.readOnly = true;
				parent.frames[2].document.AdmitPatient_form.escort_mv_regn_no.readOnly = true;
				parent.frames[2].document.AdmitPatient_form.emergency_detail.readOnly = true;
				parent.frames[3].document.getElementById('referal_details').disabled = true;
				parent.frames[3].document.getElementById('PrevIPVisit').disabled = true;
				if(patientid != '' && patientid != null)
				{
					parent.Select_frame.document.getElementById('patient_id').value = patientid;
					parent.Select_frame.validateSelect('R');
				}
				else if(parent.frames[2].document.AdmitPatient_form.call_func.value == 'ADMIT')
				{
					parent.parent.frames[0].document.forms[0].apply.disabled = false;
					
					if(parent.frames[2].document.forms[0].from_adv_bed_mgmt && parent.frames[2].document.forms[0].from_adv_bed_mgmt.value=='N'){//added for ABM
						parent.parent.frames[0].document.forms[0].reset.disabled = false;
					}

					var p ='';
					if(parent.frames[2].document.AdmitPatient_form.bed_class_code.value!='')
					{
						p = parent.frames[2].document.AdmitPatient_form.Bedcode.options;
						for (i=0; i<p.options.length; i++) {
							if(p.options[i].value ==parent.frames[2].document.AdmitPatient_form.bed_class_code.value)
								p.options[i].selected = true;
						}
					}
			  
				}
				else
				{
						
				}
			}

	 }
	 

	
	// This function is called for populating the modal windoe for high risk patients

	async function HighRisk()
	{
		
		var retVal =    new String()
	
		var dialogHeight= "400px" ;
		var dialogWidth	= "700px" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no" 
		var arguments   = '';
		url ='../../eCA/jsp/AuthorizeMRAccess.jsp?Patient_Id=patient_id&modal_yn=Y';

		var retVal=	await window.showModalDialog(url,arguments,features);
		dialogHeight    = '400px';
		dialogWidth = '700px';
			features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;';

		if(retVal =="T"){
			var retVal=	await window.showModalDialog('../../eCA/jsp/PatHighRiskQueryResult.jsp?Patient_Id=patient_id&modal_yn=Y',arguments,features);
		}

	}
    function validateBilling() {

		var patientId = document.Select_form.patient_id.value;
        if( patientId != "" || patientId !=null ) {
            HTMLVal = "<HTML><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='InsureChk' id='InsureChk' method='post' action='../../eIP/jsp/CalulateOutStdAmt.jsp'><input name='patientId' id='patientId' type='hidden' value=\""+patientId+"\"></form></BODY></HTML>";
            parent.dummy.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
            parent.dummy.document.InsureChk.submit();
        }
    }
	// This function is populating the medical team
	function populateTeam()
	{
		if(parent.frames[2].document.forms[0].practid.value != "" && parent.frames[2].document.forms[0].Splcode.value != "")
		{
			var spy_code = parent.frames[2].document.forms[0].Splcode.value;
			var ippractid = parent.frames[2].document.forms[0].practid.value;
			var team = document.forms[0].teamid.value;
			parent.frames[2].document.forms[0].team_id.disabled = false;
			var selected = parent.frames[2].document.forms[0].team_id;
		    while ( selected.options.length > 0 )
		       selected.remove(selected.options[0]);
            var HTMLVal = "<html><body CLASS='MESSAGE' onKeyDown='lockKey()'><form name='dummi_form' id='dummi_form' method='post' action='../../eIP/jsp/MedicalTeamPopulate.jsp'><input type='hidden' name='spy_code' id='spy_code' value=\""+spy_code+"\"> "+
            "<input type='hidden' name='ippractid' id='ippractid' value=\""+ippractid+"\"><input type='hidden' name='booking' id='booking' value='admit'>"+
			"<input type='hidden' name='team_id' id='team_id' value=\""+team+"\"> "+
			"</form></body></html>";
            parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.parent.messageFrame.document.dummi_form.submit();
		}
	}

	/*
	 * This function is used to validate the encounter id
	 */
    function ChkNumValidate(obj)
    {
        var encid = obj.value;
		if(trimCheck(encid)=="") return false;
        if(CheckForNumber(encid))
        { 
			validateSelect(encid);
        }
    }

	// This function is populating the patient details if patient id exists 
	function popload()
	{
		var patTmp = document.forms[0].patient_id.value;
		if(patTmp != "")
		 validatePat(document.forms[0].patient_id,'Patient ID');
	}

	// These function's will check for null values & then call up CommonLookup function if the value in the textbox is not null.
	// Added by Sridhar R
	// Added on 2 FEB 2004
	function BeforeReasonLookup()
	{	
		var oldValFlag = false;
		if(document.forms[0].chief_complaint_hid.value != document.forms[0].chief_complaint.value)
			oldValFlag = true;
		if(oldValFlag)
		{
			if(document.forms[0].chief_complaint.value!="")
				ReasonLookup();
		}
	}

	//Added for MMS-QH-CRF-0144 - LnkdInc:47233
	function refresherrmsg()
	{  //alert("refresherrmsg");
		if(document.forms[0].reason_reqd_Flag.value == "Y")
		{
			if(document.forms[0].chief_complaint.value != '')
				parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';		
		}
	}
	
	function chkbedno()
	{
		if((document.forms[0].bed_no.value!="") && (document.forms[0].bed_no.value!=null))
		{
			if(parent.frames[2].document.AdmitPatient_form.pat_check_in_allowed_yn.value == "N")
				parent.frames[2].document.AdmitPatient_form.attend_img.style.visibility="visible";
		}
		else if((document.forms[0].bed_no.value=="") || (document.forms[0].bed_no.value==null))
		{
			document.forms[0].attend_img.style.visibility = "hidden";
		}

		if(document.forms[0].bed_no != "")
		{
			validateFields(document.forms[0].bed_no);
		}
		/*else
		if((document.forms[0].bed_no.value=="")||(document.forms[0].bed_no.value==null))
		{
		document.forms[0].attend_img.style.visibility = "hidden";
		}*/
	}

	function enableBed(nursingUnit)
	{
		if(nursingUnit.value != '')
		{
			if(document.forms[0].nurs_unt_auth_val.value == "Y")
			{
//				document.forms[0].bed_no.readOnly = false;
				document.forms[0].bed_no.value = '';
				document.forms[0].bed_avail_chart.disabled = false;
			}/*Tuesday, February 16, 2010 , 19382 ,disable bed no lookup button if Admit Patient with Bed is unchecked in AM->Operator Station */
			else if(document.forms[0].nurs_unt_auth_val.value == "N" && document.forms[0].bed_mandatory_for_admn_yn.value == "N")
			{
				document.forms[0].bed_no.value = '';
				document.forms[0].bed_avail_chart.disabled = true;
			}

				if(!parent.frames[0].document.Select_form.bkg_type.value=='D')
					document.forms[0].room_no.value = '';
				document.forms[0].room_no.readOnly = true;
		}
		else if(nursingUnit.value == '')
		{
//			document.forms[0].bed_no.readOnly = false;
			document.forms[0].bed_no.value = '';
			if(document.forms[0].nurs_unt_auth_val.value == "Y")
				document.forms[0].bed_avail_chart.disabled = false;
			/*Tuesday, February 16, 2010 , 19382 ,disable bed no lookup button if Admit Patient with Bed is unchecked in AM->Operator Station */
			else if(document.forms[0].nurs_unt_auth_val.value == "N" && document.forms[0].bed_mandatory_for_admn_yn.value == "N")
				document.forms[0].bed_avail_chart.disabled = true;

			if(!parent.frames[0].document.Select_form.bkg_type.value=='D')
				document.forms[0].room_no.value = '';

			document.forms[0].room_no.readOnly = true;
		}
	}

	function BeforeNursingUnitLookup(facilityID,User,OperationStation)
	{
		
		var oldValFlag = false;
		if(document.forms[0].nursing_unit_desc.value == '')
		{
			document.forms[0].nurs_unit_desc_hid.value = "";
			document.forms[0].bed_no.value = "";
//			document.forms[0].bed_no.readOnly = false;
			if(document.forms[0].nurs_unt_auth_val.value == "Y")
				document.forms[0].bed_avail_chart.disabled = false;
			/*Tuesday, February 16, 2010 , 19382 ,disable bed no lookup button if Admit Patient with Bed is unchecked in AM->Operator Station */
			else if(document.forms[0].nurs_unt_auth_val.value == "N" && document.forms[0].bed_mandatory_for_admn_yn.value == "N")
				document.forms[0].bed_avail_chart.disabled = true;
			document.AdmitPatient_form.attend_img.style.visibility = "hidden";
//			document.forms[0].SplDesc.value ="";
//			document.forms[0].Splcode.value="";

			document.forms[0].practid_desc.value="";
			document.forms[0].practid.value="";
			document.forms[0].practid_desc_hid.value="";

			document.forms[0].att_practid_desc.value="";
			document.forms[0].att_practid.value="";
		}

		if((document.forms[0].nurs_unit_desc_hid.value != document.forms[0].nursing_unit_desc.value)|| (document.forms[0].from_adv_bed_mgmt && document.forms[0].from_adv_bed_mgmt.value=='Y'))
			oldValFlag = true;

		if(oldValFlag)
		{
			document.forms[0].patient_class_id.value = "";
			document.forms[0].nursing_unit.value ="";
			var obj		= document.forms[0].service; 
			var length  = obj.length;
			for(i=0;i<length;i++) 
			{obj.remove(1);}
			var obj1		= document.forms[0].sub_service; 
			var length1		= obj1.length;
			for(i=0;i<length1;i++) 
			{obj1.remove(1);}
			var obj2		= document.forms[0].bed_type; 
			var length2		= obj2.length;
			for(i=0;i<length2;i++) 
			{obj2.remove(1);}
			document.forms[0].Bedcode.value="";

			if(document.forms[0].nursing_unit_desc.value!="")
			{
				if(parent.frames[0].document.forms[0].booking_ref_no.value == "")
					document.forms[0].patient_class_id.value = "";
				NursingUnitLookup(facilityID,User,OperationStation);
			}
			else
			{
				validateFields(document.forms[0].nursing_unit_desc);
			}
		}
	}

	function BeforegetSpecialty(obj)
	{
		
		if(document.forms[0].SplDesc.value == "")
		{
			document.forms[0].Splcode.value="";
			document.forms[0].SplDesc_hid.value=""; //Added by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779
			if(document.forms[0].from_adv_bed_mgmt && document.forms[0].from_adv_bed_mgmt.value=='N'){//added for ABM
				document.forms[0].nursing_unit_desc.value="";
				document.forms[0].nursing_unit_desc.onblur();
			}

			document.forms[0].practid_desc.value="";
			document.forms[0].practid.value="";

			document.forms[0].att_practid_desc.value="";
			document.forms[0].att_practid.value="";
		}
	

		if(document.forms[0].SplDesc_hid.value != document.forms[0].SplDesc.value){
			if(document.forms[0].SplDesc.value != "")
			{
				document.forms[0].Splcode.value="";
				if(document.forms[0].from_adv_bed_mgmt && document.forms[0].from_adv_bed_mgmt.value=='N'){
					document.forms[0].nursing_unit_desc.value="";
					document.forms[0].nursing_unit_desc.onblur();
				}

				document.forms[0].practid_desc.value="";
				document.forms[0].practid.value="";

				document.forms[0].att_practid_desc.value="";
				document.forms[0].att_practid.value="";
				getSpecialty(obj);
			}
		}

		if(document.forms[0].SplDesc.value == "")
			document.forms[0].bed_avail_chart.disabled=true;
		else
		{
			/*Tuesday, February 16, 2010 , 19382 ,disable bed no lookup button if Admit Patient with Bed is unchecked in AM->Operator Station */
		
			if((document.forms[0].nurs_unt_auth_val.value == "N" && document.forms[0].bed_mandatory_for_admn_yn.value == "N") || (document.forms[0].from_adv_bed_mgmt && document.forms[0].from_adv_bed_mgmt.value=='Y'))
				document.forms[0].bed_avail_chart.disabled=true;
			else
				document.forms[0].bed_avail_chart.disabled=false;
		}




	}

	function BeforeGetPractID1(obj1,obj2)
	{
		var oldValFlag			= false;
		if(document.forms[0].practid_desc_hid.value != document.forms[0].practid_desc.value)
			oldValFlag = true;
		if(oldValFlag)
		{
			if(document.forms[0].practid_desc.value!="")
			getPractID(obj1,obj2);
		}
	}

	function BeforeGetPractID2(obj1,obj2)
	{
		var oldValFlag			= false;
		if(document.forms[0].att_practid_desc_hid.value != document.forms[0].att_practid_desc.value)
			oldValFlag = true;
		if(oldValFlag)
		{
			if(document.forms[0].att_practid_desc.value!="")
				getPractID(obj1,obj2);
		}
	}
	/*
	 *	This function is used to populate the reasons for admission
	 */
	async function ReasonLookup()
	{
		var tit				= getLabel("Common.ReasonforAdmission.label","Common");
		var retVal			= new String();
		var argumentArray	= new Array() ;
		var dataNameArray	= new Array() ;
		var dataValueArray	= new Array() ;
		var dataTypeArray	= new Array() ;
		var locale = document.forms[0].locale.value;
		// This sql populates the reasons for admission with given search value
		sql="select complaint_code code,complaint_desc description from AM_COMPLAINT_LANG_VW where language_id ='"+locale+"' and eff_status like ? and  upper(complaint_code) like upper(?) and upper(complaint_desc)  like upper(?)" ;	   
		dataNameArray[0]	= "eff_status" ;
		dataValueArray[0]	= "E";
		dataTypeArray[0]	= STRING;
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,3";
		argumentArray[5] = document.forms[0].chief_complaint.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;
		retVal = await CommonLookup( tit, argumentArray );
		if(retVal != null && retVal != "" )
		{
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			document.forms[0].chief_complaint.value=arr[1];
			document.forms[0].complaintcode.value=arr[0];
			document.forms[0].chief_complaint_hid.value = document.forms[0].chief_complaint.value
		}
		else
		{
			document.forms[0].chief_complaint.value="";
			document.forms[0].complaintcode.value="";
		}
	}
	/*
	 * This function is used to show the bed availability chart
	 * Arg1		: Constant value(BED_AVAIL)
	 */
	async function callModal(ref)
	{
		var nursingunit = "";
		var practitionerid = "";
		var specialitycode = "";
		if(parent.frames[2].document.AdmitPatient_form.nursing_unit_desc.value != "")
			nursingunit = parent.frames[2].document.AdmitPatient_form.nursing_unit.value;
		if(parent.frames[2].document.AdmitPatient_form.practid_desc.value != "")
			practitionerid = parent.frames[2].document.AdmitPatient_form.practid.value;
		if(parent.frames[2].document.AdmitPatient_form.SplDesc.value != "")
			specialitycode = parent.frames[2].document.AdmitPatient_form.Splcode.value;
		var bedclasscode = parent.frames[2].document.AdmitPatient_form.Bedcode.value;
		var bedtypecode = parent.frames[2].document.AdmitPatient_form.bed_type.value;
		var gender = parent.frames[2].document.AdmitPatient_form.gender.value;
		var agevalue = parent.frames[2].document.AdmitPatient_form.age.value;
		var bkgtype=parent.frames[0].document.Select_form.bkg_type.value;
		var admission_for=parent.frames[0].document.Select_form.admission_for.value;
		var patientclass='';
		if(admission_for == 'D')
			patientclass='DC';
		else if(admission_for =='I')
			patientclass='IP';

		
		if(bkgtype == 'D')
			patientclass='DC';
		else if(bkgtype == 'I')
			patientclass='IP';
		if(patientclass=='')
		patientclass = parent.frames[2].document.AdmitPatient_form.patient_class_id.value;

		var room_num;
		var obj = parent.frames[2].document.AdmitPatient_form.sub_service;
		var n = obj.length;
		for(i=0;i<n;i++)
			obj.remove(0);
		var opt = parent.frames[2].document.createElement('Option');
		opt.text = "--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
		opt.value = "";
		obj.add(opt);
		if(bkgtype =='D')
		{
			room_num=parent.frames[2].document.AdmitPatient_form.room_no.value;
		}
		else
		{
			room_num='';
		}
		var age = "";
		if(agevalue != '')
		{
			var yr = eval(agevalue.indexOf("Y"));
			var mon = eval(agevalue.indexOf("M"));
			if(mon>=0 && yr>=0)
			{
				age = agevalue.substring(0,yr);
				agevalue = "Y";
			}
			else if(mon >= 0)
			{
				age = agevalue.substring(0,mon);
				agevalue = "M";
			}
			else
			{
				age = agevalue.substring(0,yr);
				agevalue = "Y";
			}
		}
		var retVal = 	new String();
		var wherecondn = "ADMIT_PAT_YN";
		var dialogHeight= "100vh";
		var dialogWidth = "85vw";
		var dialogTop	= "72";

		var status = "no";
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = await top.window.showModalDialog("../../eIP/jsp/BedAvailabilityChart.jsp?disable_field=specialty&nursing_unit_code="+nursingunit+"&speciality_code="+specialitycode+"&practitioner_id="+practitionerid+"&bed_class_code="+bedclasscode+"&bed_type="+bedtypecode+"&room_no_code="+room_num+"&age_value="+agevalue+"&age="+age+"&gender="+gender+"&patient_class="+patientclass+"&wherecondn="+wherecondn,arguments,features);

		if(retVal != null)
		{
			retVal = retVal.replace("|","&");
			var arr = retVal.split("^");
			if (arr.length > 2)
			{
				parent.frames[2].document.AdmitPatient_form.nursing_unit.value=arr[0];
				parent.frames[2].document.AdmitPatient_form.nursing_unit_desc.value=arr[9];
				parent.frames[2].document.AdmitPatient_form.nurs_unit_desc_hid.value = parent.frames[2].document.AdmitPatient_form.nursing_unit_desc.value;
				parent.frames[2].document.AdmitPatient_form.bedtypecode.value=arr[2];
				var arrsplty = arr[11].split("*All SPLTY*");
				if (arrsplty.length==1)
				{
					parent.frames[2].document.AdmitPatient_form.Splcode.value=arr[10];
					parent.frames[2].document.AdmitPatient_form.SplDesc.value=arr[11];
				}
				if (arr .length > 1)
				{
					var arr1 = arr[1].split("/");
					parent.frames[2].document.AdmitPatient_form.bed_no.value = arr1[0];
				//	parent.frames[2].document.AdmitPatient_form.bed_no.onblur();
					p = parent.frames[2].document.AdmitPatient_form.Bedcode.options;
					for (i=0; i<p.length; i++) 
					{
						if(p[i].value ==arr[3])
							p[i].selected = true;
					}
				}
				parent.frames[2].document.AdmitPatient_form.patient_class_id.value = arr[15];
				
				
				if(parent.frames[2].document.AdmitPatient_form.patient_class_id.value =='DC')
				{
					parent.frames[2].AdmitPatient_form.exp_days_stay.value = '1';
					parent.frames[2].AdmitPatient_form.exp_days_stay.onblur();
					parent.frames[2].AdmitPatient_form.exp_days_stay.readOnly = true;
				}
			//if(bkgtype !='D')
				
				if(bkgtype !='D' && parent.frames[2].document.AdmitPatient_form.bed_no.value !=""){
					
					parent.frames[2].document.AdmitPatient_form.room_no.value = arr[4];
				}
//				parent.frames[2].document.AdmitPatient_form.bed_no.focus();
				validateFields(document.forms[0].nursing_unit_desc);
			}
			else
			{
				arr = retVal.split("^");
				parent.frames[2].document.AdmitPatient_form.nursing_unit.value = arr[0];
				if (arr.length == 2)
					parent.frames[2].document.AdmitPatient_form.nursing_unit_desc.value = arr[1];
					parent.frames[2].document.AdmitPatient_form.nurs_unit_desc_hid.value = parent.frames[2].document.AdmitPatient_form.nursing_unit_desc.value;
			}
			if(parent.frames[2].document.AdmitPatient_form.nursing_unit.value != '')
			{
				if(parent.frames[2].document.AdmitPatient_form.pat_check_in_allowed_yn.value == "Y")
				{
					parent.frames[2].document.AdmitPatient_form.attend_img.style.visibility="hidden";
					parent.frames[3].document.getElementById("valuables").disabled = false;
				}
				else if(parent.frames[2].document.AdmitPatient_form.pat_check_in_allowed_yn.value == "N" && parent.frames[2].document.AdmitPatient_form.bed_no.value !='')
				{
					parent.frames[2].document.AdmitPatient_form.attend_img.style.visibility="visible";
				}
			}
		}
	}
	
	function moveToNextItem()
	{
		tab_click('admission_tab');
		if(!document.forms[0].Bedcode.disabled)
			document.forms[0].Bedcode.focus();	
	}

	async function callSearchScreenForMultBkgRefNo()
	{
		 var retVal =    new String();
		//var operatorstation  = document.Select_form.operator_station.value;
		var operatorstation  = parent.frames[1].frames[0].document.Select_form.operator_station.value;
		var dialogTop   = "10";
		var dialogHeight= "400px" ;
		var dialogWidth = "700px" ;
		var features    ="dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments   = "" ;
		
		var admission_for  = parent.frames[1].frames[0].document.Select_form.admission_for.value;
		var patient_id = parent.frames[1].frames[0].document.Select_form.patient_id.value;
	
		//retVal=window.showModalDialog("../../eIP/jsp/BookingReferenceLookup.jsp?param=ADMIT&oper_stn_id="+operatorstation+"&admission_for="+admission_for+"&call_function=AT&ismult_bkg_yn=Y&patient_id="+parent.frames[1].document.frames[0].document.Select_form.patient_id.value,arguments,features);
		retVal=await window.showModalDialog("../../eIP/jsp/BookingReferenceLookup.jsp?param=BOOK_ADMIT&oper_stn_id="+operatorstation+"&admission_for="+admission_for+"&call_function=Booking_Admission&ismult_bkg_yn=Y&patient_id="+patient_id,arguments,features);
			
		
		if(retVal != null)
		{
			var bkr_ref = retVal.split(",");
			var value1=bkr_ref[0];
			var	value2=bkr_ref[1];
			var	value3=bkr_ref[2];
			var value4=bkr_ref[3];
			var value5=bkr_ref[4];

			parent.frames[1].frames[0].document.Select_form.patient_id.value = value5;
			parent.frames[1].frames[0].document.Select_form.booking_ref_no.value = value1;
			
			if(value2 != '' && value2 != null)
				parent.frames[1].frames[0].document.Select_form.bkg_type.value = value2;
			if(value3 != '' && value3 != null)
				parent.frames[1].frames[0].document.Select_form.clin_code.value = value3;
			if(value4 != '' && value4 != null)
				parent.frames[1].frames[0].document.Select_form.referral_id.value = value4;
			
			parent.frames[1].frames[2].document.AdmitPatient_form.d_referral_id.value = value4;
			parent.frames[1].frames[2].document.AdmitPatient_form.d_clinic_code.value = value3;
			//setTimeout("parent.frames[1].document.frames[0].document.Select_form.patient_id.onblur()",200);
			parent.frames[1].frames[0].document.Select_form.validatePat_yn.value = 'N';
			parent.frames[1].frames[0].document.Select_form.patient_id.onblur();
			
		}
		/*else
			parent.frames[1].document.frames[0].document.Select_form.patient_id.value="";*/

		var field2=parent.frames[1].frames[0].document.Select_form.patient_id.value
		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dum_frm' id='dum_frm' method='post'  action='../../eIP/jsp/AdmissionValidation.jsp'><input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field2' id='field2' value='"+field2+"'><input type='hidden' name='field1' id='field1' value=''><input type='hidden' name='field4' id='field4' value='Select_form'></form></body></html>";
		
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.dum_frm.submit();
			
	}
function removeitems(obj)
{
	var len=obj.length;
	var i=1;
	while(i<len)
	{
		len=obj.length
		obj.remove(i)
	}
}

//Added by Sangeetha on 23/05/17 for GDOH-CRF-0151
function chkforVacantNormalBed(){
	var bed_no			  = document.forms[0].bed_no.value;
	var nursing_unit_code = document.forms[0].nursing_unit.value;
	var facility_id		  = document.forms[0].hddfacility.value;
	var Bedcode			  = document.forms[0].Bedcode.value;
	var bed_type		  = document.forms[0].bed_type.value;

 if(bed_no!="" && nursing_unit_code!=""){
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH bed_no=\""+bed_no+"\"  nursing_unit_code=\""+nursing_unit_code+"\" action='chkforVacantNormalBed' facility_id=\""+facility_id+"\" Bedcode=\""+Bedcode+"\" bed_type=\""+bed_type+"\" /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)

		if(responseText == "Y"){
			var msg = getMessage("RESTRICT_PSEUDO_BED","IP");
			alert(msg);
			document.forms[0].bed_no.value  ="";
			document.forms[0].room_no.value ="";
			document.forms[0].Bedcode.value ="";
			document.forms[0].bed_type.value ="";
			document.forms[0].bed_avail_chart.focus();
		}
	}

}

