
function moveToLink(LinkIndex) {

	if(LinkIndex==1)
	{
			parent.practitioner_sub.document.getElementById('identitylink').scrollIntoView();
			
			parent.practitioner_sub.document.forms[1].sex.focus();
	}
	else if(LinkIndex==2)
	{
			parent.practitioner_sub.document.getElementById('contactnolink').scrollIntoView();
			parent.practitioner_sub.document.forms[1].residencetelno.focus();
	}
	else if(LinkIndex==3)
	{
			parent.practitioner_sub.document.getElementById('deglink').scrollIntoView();
			parent.practitioner_sub.document.forms[1].degree1.focus();
	}
}
function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/PractitionerMain.jsp?function_id=PRACTITIONER" ;	
}
function query() 
{
	f_query_add_mod.location.href ="../../eAM/jsp/PractitionerQueryCriteria.jsp?function_id=PRACTITIONER&function=setup practitioner";
}
function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }

function apply() 
{
	var UniqueCheck=false;
	var splCharCheck=true;
	var EmpserNohiddenfield=f_query_add_mod.document.practitioner_sub.practitioner1_form.employee_service_number_1.value;
	var isPractEmployeeServiceNumber=f_query_add_mod.document.practitioner_sub.practitioner1_form.isPractEmployeeServiceNumber.value;//Added by Kamatchi s for PMG2023-COMN-CRF-0043 
	UniqueCheck = EmpSrvNoUniqueCheck(f_query_add_mod.document.practitioner_sub.practitioner1_form.employee_service_number,EmpserNohiddenfield);
	if(UniqueCheck==true || UniqueCheck=='true'){
		var msg = parent.practitioner_main.getMessage("EMPLOYEE_SERVICE_NO_ALREADY_EXISTS","AM");
		messageFrame.location.href=="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;	
		return false;
		//f_query_add_mod.document.practitioner_sub.practitioner1_form.employee_service_number.value="";
	} else {
		messageFrame.location.href=='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_val='	;
	}
	splCharCheck = CheckSplCharsValidation_EmpSrvNo(f_query_add_mod.document.practitioner_sub.practitioner1_form.employee_service_number);
	
	if(splCharCheck==false||splCharCheck=='false'){
		return false;
	}
	//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
	var isResidencyApplYN = f_query_add_mod.document.practitioner_sub.practitioner1_form.isResidencyApplYN.value;
	var eff_stat = f_query_add_mod.document.practitioner_sub.practitioner1_form.eff_stat.value;
	
	
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.practitioner_main.getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	d = new Date();
	var ye=new Array();

	var year=f_query_add_mod.document.practitioner_sub.practitioner1_form.date_of_birth.value
	var year1=f_query_add_mod.document.practitioner_sub.practitioner1_form.year1.value
     var year2=f_query_add_mod.document.practitioner_sub.practitioner1_form.year2.value
	var year3=f_query_add_mod.document.practitioner_sub.practitioner1_form.year3.value
	var year4=f_query_add_mod.document.practitioner_sub.practitioner1_form.year4.value
   var fun_id_temp=f_query_add_mod.document.practitioner_sub.practitioner1_form.function_id.value;
	ye=year.split("/");
    dobyear=ye[2] 
	currentyear=d.getYear()
	if(!(eval(year1)>eval(dobyear))&&(eval(year1)<=eval(currentyear)))
	{
	
	//alert("APP-AM0024 Year of Passing should be greater than BirthDate")
	alert(getMessage("AM0125","AM"));

	
	
	messageFrame.document.location='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_val='
	
	}else if(!(eval(year2)>eval(dobyear))&&(eval(year2)<=eval(currentyear)))
	{
	
	//alert("APP-AM0024 Year of Passing should be greater than BirthDate")
	alert(getMessage("AM0125","AM"));
	
	
	messageFrame.document.location='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_val='
	
	}else if(!(eval(year3)>eval(dobyear))&&(eval(year3)<=eval(currentyear)))
	{
	
	//alert("APP-AM0024 Year of Passing should be greater than BirthDate ")
	alert(getMessage("AM0125","AM"));
	
	
	messageFrame.document.location='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_val='
	
	}else if(!(eval(year4)>eval(dobyear))&&(eval(year4)<=eval(currentyear)))
	{
	
	//alert("APP-AM0024 Year of Passing should be greater than BirthDate ")
	alert(getMessage("AM0125","AM"));
	
	
	messageFrame.document.location='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_val='
	
	}
	else
	{
    
	f_query_add_mod.document.practitioner_sub.practitioner1_form.job_title1.value=f_query_add_mod.document.practitioner_sub.practitioner1_form.job_title.value

	if(f_query_add_mod.document.practitioner_sub.practitioner1_form.function_name.value == "insert") 
	{

		f_query_add_mod.document.practitioner_sub.practitioner1_form.pract_type1.value = f_query_add_mod.document.practitioner_main.practitioner_form.pract_type.value;
		f_query_add_mod.document.practitioner_sub.practitioner1_form.practitioner_id1.value = f_query_add_mod.document.practitioner_main.practitioner_form.practitioner_id.value;
		f_query_add_mod.document.practitioner_sub.practitioner1_form.practitioner_name1.value = f_query_add_mod.document.practitioner_main.practitioner_form.practitioner_name.value;
		f_query_add_mod.document.practitioner_sub.practitioner1_form.short_name1.value = f_query_add_mod.document.practitioner_main.practitioner_form.short_name.value;
		f_query_add_mod.document.practitioner_sub.practitioner1_form.eff_status1.value = f_query_add_mod.document.practitioner_main.practitioner_form.eff_status.value;
		//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 Started -->
		f_query_add_mod.document.practitioner_sub.practitioner1_form.enable_virtual_consultation1.value = f_query_add_mod.document.practitioner_main.practitioner_form.enable_virtual_consultation.value;
		//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 End -->
		
		
		/*Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184 Start*/
		if(f_query_add_mod.document.practitioner_main.practitioner_form.FPPPract && f_query_add_mod.document.practitioner_main.practitioner_form.FPPPract.checked)
			f_query_add_mod.document.practitioner_sub.practitioner1_form.fpp_pract_yn.value = 'Y';
		else
			f_query_add_mod.document.practitioner_sub.practitioner1_form.fpp_pract_yn.value = 'N';
		/*End*/
		/*Added By Dharma on 19th Sep 2020 against AAKH-CRF-0122.4 Start*/
		if(f_query_add_mod.document.practitioner_main.practitioner_form.supervisorchk && f_query_add_mod.document.practitioner_main.practitioner_form.supervisorchk.checked)
			f_query_add_mod.document.practitioner_sub.practitioner1_form.supervisor_yn.value = 'Y';
		else
			f_query_add_mod.document.practitioner_sub.practitioner1_form.supervisor_yn.value = 'N';
		/*End*/
		f_query_add_mod.document.practitioner_sub.practitioner1_form.date_of_birth1.value = f_query_add_mod.document.practitioner_sub.practitioner1_form.date_of_birth.value;
		f_query_add_mod.document.practitioner_sub.practitioner1_form.primary_speciality_codeh.value = f_query_add_mod.document.practitioner_main.practitioner_form.primary_speciality_code.value;
		f_query_add_mod.document.practitioner_sub.practitioner1_form.long_name1.value = f_query_add_mod.document.practitioner_main.practitioner_form.long_name.value;

		f_query_add_mod.document.practitioner_sub.practitioner1_form.other_alt_no1.value = f_query_add_mod.document.practitioner_sub.practitioner1_form.other_alt_no.value;//Added HSA-CRF-160
		
		//Below line added for this CRF ML-MMOH-CRF-0862
		if(f_query_add_mod.document.practitioner_main.practitioner_form.cerner_practitioner_id1){
		f_query_add_mod.document.practitioner_sub.practitioner1_form.cerner_practitioner_id.value =f_query_add_mod.document.practitioner_main.practitioner_form.cerner_practitioner_id1.value; 
		}		
		//End this CRF ML-MMOH-CRF-0862
		
		//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
		var fields = new Array();
		var names  = new Array();
		
		fields[0] = f_query_add_mod.document.practitioner_sub.practitioner1_form.pract_type1;
		fields[1] = f_query_add_mod.document.practitioner_sub.practitioner1_form.practitioner_id1;
		fields[2] = f_query_add_mod.document.practitioner_sub.practitioner1_form.practitioner_name1;
		fields[3] = f_query_add_mod.document.practitioner_sub.practitioner1_form.short_name1;
		fields[4] = f_query_add_mod.document.practitioner_sub.practitioner1_form.sex;
		fields[5] = f_query_add_mod.document.practitioner_sub.practitioner1_form.empl_status;
		fields[6] = f_query_add_mod.document.practitioner_sub.practitioner1_form.date_of_birth1;
		fields[7] = f_query_add_mod.document.practitioner_sub.practitioner1_form.primary_speciality_codeh;
		if(isResidencyApplYN == "true" && eff_stat == "E")
		{
			fields[8] = f_query_add_mod.document.practitioner_sub.practitioner1_form.citizenshipDesc;
			if(f_query_add_mod.document.practitioner_sub.practitioner1_form.national_id_no && f_query_add_mod.document.practitioner_sub.practitioner1_form.nat_mandatory.style.visibility == "visible")
			{
				fields[9] = f_query_add_mod.document.practitioner_sub.practitioner1_form.national_id_no;
			}
			else if(f_query_add_mod.document.practitioner_sub.practitioner1_form.oth_alt_mand.style.visibility == "visible")
			{
				fields[9] = f_query_add_mod.document.practitioner_sub.practitioner1_form.other_alt_no;
			}
		}
		
		// added by lakshmanan for MO-CRF-20183.2 US001
		//Added by Kamatchi s for PMG2023-COMN-CRF-0043 
		if(isPractEmployeeServiceNumber == "true" || isPractEmployeeServiceNumber == true){
			fields[fields.length]=f_query_add_mod.document.practitioner_sub.practitioner1_form.employee_service_number;
		}
	  
		names[0] = getLabel("Common.type.label","Common");
		names[1] = getLabel("Common.identification.label","Common");
		names[2] = getLabel("Common.FullName.label","Common");
		names[3] = getLabel("Common.shortname.label","Common");
		names[4] = getLabel("Common.gender.label","Common");
		names[5] = getLabel("Common.EmplStatus.label","Common");
		names[6] = getLabel("Common.birthDate.label","Common");
		names[7] = getLabel("Common.primaryspeciality.label","Common");
		if(isResidencyApplYN == "true" && eff_stat == "E")
		{
			names[8] = getLabel("Common.Citizenship.label","Common");
			if(f_query_add_mod.document.practitioner_sub.practitioner1_form.national_id_no && f_query_add_mod.document.practitioner_sub.practitioner1_form.nat_mandatory.style.visibility == "visible")
			{
				names[9] = f_query_add_mod.document.practitioner_sub.practitioner1_form.nat_id_prompt.value;
			}
			else if(f_query_add_mod.document.practitioner_sub.practitioner1_form.oth_alt_mand.style.visibility == "visible")
			{
				names[9] = getLabel("eMP.OtherAltNo.label","MP");
			}
		}
		// added by lakshmanan for MO-CRF-20183.2 US001
		//Added by Kamatchi s for PMG2023-COMN-CRF-0043 
		if(isPractEmployeeServiceNumber == "true" || isPractEmployeeServiceNumber == true){
			names[names.length]=getLabel("eAM.EmployeeServiceNumber.label","AM");
		}

		/*if((f_query_add_mod.document.practitioner_sub.practitioner1_form.empl_status.value=="F") || (f_query_add_mod.document.practitioner_sub.practitioner1_form.empl_status.value == "P")|| (f_query_add_mod.document.practitioner_sub.practitioner1_form.empl_status.value == "S")) {
		fields[fields.length-1] =f_query_add_mod.document.practitioner_sub.practitioner1_form.rep_facility;
		names[names.length-1]="Reporting Facility"
		}
		else {
       	fields.length=fields.length-1;
       	names.length=names.length-1;
        }*/

        var transform = new Array ( f_query_add_mod.document.practitioner_sub.practitioner1_form,
        		    f_query_add_mod.document.practitioner_sub.practitioner1_form.eff_date_from,
				    f_query_add_mod.document.practitioner_main.practitioner_form.eff_date_from1,
				    f_query_add_mod.document.practitioner_sub.practitioner1_form.eff_date_to,
				    f_query_add_mod.document.practitioner_main.practitioner_form.eff_date_to1
			  );
	}
	else if(f_query_add_mod.document.practitioner_sub.practitioner1_form.function_name.value == "modify") 
	  {
	
		f_query_add_mod.document.practitioner_sub.practitioner1_form.pract_type1.value = f_query_add_mod.document.practitioner_main.practitioner_form.pract_type3.value;
		f_query_add_mod.document.practitioner_sub.practitioner1_form.practitioner_id1.value = f_query_add_mod.document.practitioner_main.practitioner_form.practitioner_id.value;
		f_query_add_mod.document.practitioner_sub.practitioner1_form.practitioner_name1.value = f_query_add_mod.document.practitioner_main.practitioner_form.practitioner_name.value;
		f_query_add_mod.document.practitioner_sub.practitioner1_form.short_name1.value = f_query_add_mod.document.practitioner_main.practitioner_form.short_name.value;
		f_query_add_mod.document.practitioner_sub.practitioner1_form.eff_status1.value = f_query_add_mod.document.practitioner_main.practitioner_form.eff_status.value;
		
		//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 Started -->
		f_query_add_mod.document.practitioner_sub.practitioner1_form.enable_virtual_consultation1.value = f_query_add_mod.document.practitioner_main.practitioner_form.enable_virtual_consultation.value;
		//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 End -->
		
		/*Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184 Start*/
		if(f_query_add_mod.document.practitioner_main.practitioner_form.FPPPract && f_query_add_mod.document.practitioner_main.practitioner_form.FPPPract.checked)
			f_query_add_mod.document.practitioner_sub.practitioner1_form.fpp_pract_yn.value = 'Y';
		else
			f_query_add_mod.document.practitioner_sub.practitioner1_form.fpp_pract_yn.value = 'N';
		/*End*/

		/*Added By Dharma on 19th Sep 2020 against AAKH-CRF-0122.4 Start*/
		if(f_query_add_mod.document.practitioner_main.practitioner_form.supervisorchk && f_query_add_mod.document.practitioner_main.practitioner_form.supervisorchk.checked)
			f_query_add_mod.document.practitioner_sub.practitioner1_form.supervisor_yn.value = 'Y';
		else
			f_query_add_mod.document.practitioner_sub.practitioner1_form.supervisor_yn.value = 'N';
		/*End*/
		f_query_add_mod.document.practitioner_sub.practitioner1_form.date_of_birth1.value = f_query_add_mod.document.practitioner_sub.practitioner1_form.date_of_birth.value;
		f_query_add_mod.document.practitioner_sub.practitioner1_form.long_name1.value = f_query_add_mod.document.practitioner_main.practitioner_form.long_name.value;
		
		f_query_add_mod.document.practitioner_sub.practitioner1_form.other_alt_no1.value = f_query_add_mod.document.practitioner_sub.practitioner1_form.other_alt_no.value;//Added HSA-CRF-160
		
		//Below line added for this CRF ML-MMOH-CRF-0862
		//f_query_add_mod.document.practitioner_sub.practitioner1_form.cerner_practitioner_id.value = f_query_add_mod.document.practitioner_sub.practitioner1_form.cerner_practitioner_id1.value; 
		//Below line added for this CRF ML-MMOH-CRF-0862
		if(f_query_add_mod.document.practitioner_main.practitioner_form.cerner_practitioner_id1){
		f_query_add_mod.document.practitioner_sub.practitioner1_form.cerner_practitioner_id.value =f_query_add_mod.document.practitioner_main.practitioner_form.cerner_practitioner_id1.value;
		}
		//End this CRF ML-MMOH-CRF-0862
		
		
		

		//f_query_add_mod.document.practitioner_sub.practitioner1_form.all_facilities1.value=f_query_add_mod.practitioner_sub.practitioner1_form.all_facilities.value;
		f_query_add_mod.document.practitioner_sub.practitioner1_form.primary_speciality_codeh.value = f_query_add_mod.document.practitioner_main.practitioner_form.primary_speciality_code2.value;
       
		//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
		var fields = new Array();
		var names  = new Array();
		
		fields[0] = f_query_add_mod.document.practitioner_sub.practitioner1_form.pract_type1;
		fields[1] = f_query_add_mod.document.practitioner_sub.practitioner1_form.practitioner_id1;
		fields[2] = f_query_add_mod.document.practitioner_sub.practitioner1_form.practitioner_name1;
		fields[3] = f_query_add_mod.document.practitioner_sub.practitioner1_form.short_name1;
		fields[4] = f_query_add_mod.document.practitioner_sub.practitioner1_form.sex2;
		fields[5] = f_query_add_mod.document.practitioner_sub.practitioner1_form.date_of_birth1;
		fields[6] = f_query_add_mod.document.practitioner_sub.practitioner1_form.empl_status2;
		fields[7] = f_query_add_mod.document.practitioner_sub.practitioner1_form.primary_speciality_codeh;
		if(isResidencyApplYN == "true" && eff_stat == "E")
		{
			fields[8] = f_query_add_mod.document.practitioner_sub.practitioner1_form.citizenshipDesc;
			if(f_query_add_mod.document.practitioner_sub.practitioner1_form.national_id_no && f_query_add_mod.document.practitioner_sub.practitioner1_form.nat_mandatory.style.visibility == "visible")
			{
				fields[9] = f_query_add_mod.document.practitioner_sub.practitioner1_form.national_id_no;
			}
			else if(f_query_add_mod.document.practitioner_sub.practitioner1_form.oth_alt_mand.style.visibility == "visible")
			{
				fields[9] = f_query_add_mod.document.practitioner_sub.practitioner1_form.other_alt_no;
			}
		}
		// added by lakshmanan for MO-CRF-20183.2 US001
		//Added by Kamatchi s for PMG2023-COMN-CRF-0043 
		if(isPractEmployeeServiceNumber == "true" || isPractEmployeeServiceNumber == true){
		fields[fields.length]=f_query_add_mod.document.practitioner_sub.practitioner1_form.employee_service_number;
		}	 
		
		names[0] = getLabel("Common.type.label","Common");
		names[1] = getLabel("Common.identification.label","Common");
		names[2] = getLabel("Common.FullName.label","Common");
		names[3] = getLabel("Common.shortname.label","Common");
		names[4] = getLabel("Common.gender.label","Common");
		names[5] = getLabel("Common.birthDate.label","Common");
		names[6] = getLabel("Common.EmplStatus.label","Common");			
		names[7] = getLabel("Common.primaryspeciality.label","Common");
		if(isResidencyApplYN == "true" && eff_stat == "E")
		{
			names[8] = getLabel("Common.Citizenship.label","Common");
			if(f_query_add_mod.document.practitioner_sub.practitioner1_form.national_id_no && f_query_add_mod.document.practitioner_sub.practitioner1_form.nat_mandatory.style.visibility == "visible")
			{
				names[9] = f_query_add_mod.document.practitioner_sub.practitioner1_form.nat_id_prompt.value;
			}
			else if(f_query_add_mod.document.practitioner_sub.practitioner1_form.oth_alt_mand.style.visibility == "visible")
			{
				names[9] = getLabel("eMP.OtherAltNo.label","MP");
			}
		}
		// added by lakshmanan for MO-CRF-20183.2 US001
		//Added by Kamatchi s for PMG2023-COMN-CRF-0043 
		if(isPractEmployeeServiceNumber == "true" || isPractEmployeeServiceNumber == true){
		names[names.length]=getLabel("eAM.EmployeeServiceNumber.label","AM");
		}
		
		
		/*if((f_query_add_mod.document.practitioner_sub.practitioner1_form.empl_status2.value == "F") || (f_query_add_mod.document.practitioner_sub.practitioner1_form.empl_status2.value == "P")) {
	    fields[fields.length-1] =f_query_add_mod.document.practitioner_sub.practitioner1_form.rep_facility2
        names[names.length-1]="Reporting facility";
        }
        else {
       	fields.length=fields.length-1;
       	names.length=names.length-1;
        }*/ 
		var transform = new Array ( f_query_add_mod.document.practitioner_sub.practitioner1_form,
        		    f_query_add_mod.document.practitioner_sub.practitioner1_form.eff_date_from,
				    f_query_add_mod.document.practitioner_main.practitioner_form.eff_date_from1,
				    f_query_add_mod.document.practitioner_sub.practitioner1_form.eff_date_to,
				    f_query_add_mod.document.practitioner_main.practitioner_form.eff_date_to1
			  );
	}
	//////////Added by Manish Anand on 30-06-2002////////////////////
	var spFields = new Array (f_query_add_mod.document.practitioner_main.practitioner_form.practitioner_id);
	var spNames = new Array (getLabel("Common.identification.label","Common"));
	var error_page="../../eCommon/jsp/MstCodeError.jsp"
	if(SpecialCharCheck (spFields,spNames,messageFrame,"M",error_page))
	//////////----------------------------------////////////////////
	if(f_query_add_mod.document.practitioner_sub.checkFieldsofMst( fields, names, messageFrame)) 
	{
	var proceed = true;
	if(f_query_add_mod.document.practitioner_sub.practitioner1_form.b_age.value >150)
		{
		//alert('here');
		proceed = false;
		
		messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("INVALID_AGE_YEAR","AM");
		}

		
		var message = "";
		//if(f_query_add_mod.document.practitioner_sub.DateTransform(transform,messageFrame)) {
		f_query_add_mod.document.practitioner_sub.practitioner1_form.date_of_birth.disabled = false;
		var det1 = f_query_add_mod.document.practitioner_sub.practitioner1_form.det1.value;
		var det2 = f_query_add_mod.document.practitioner_sub.practitioner1_form.det2.value;
		var det3 = f_query_add_mod.document.practitioner_sub.practitioner1_form.det3.value;
		var det4 = f_query_add_mod.document.practitioner_sub.practitioner1_form.det4.value;

		
		
		if((det1 != null) || (det2 != null) || (det3 != null) || (det4 != null))
		{
			if((det1.length > 100) || (det2.length > 100) || (det3.length > 100) || (det4.length > 100))
			{
				messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num="+f_query_add_mod.practitioner_sub.getMessage('TRNG_DTLS_MAX_CHAR','AM');
				proceed = false;
			}
		}
		if(proceed)
		{
			if(fun_id_temp=="PRACTITIONER") {
				f_query_add_mod.document.practitioner_sub.practitioner1_form.all_facilities1.value=f_query_add_mod.practitioner_sub.practitioner1_form.all_facilities.value;
				if(f_query_add_mod.practitioner_sub.practitioner1_form.all_facilities.checked == true){ // added by mujafar for MOH-SCF-0002
					f_query_add_mod.practitioner_sub.practitioner1_form.all_facilities1.value='Y';
					if(f_query_add_mod.practitioner_sub.practitioner1_form.rep_facility.disabled==true){
						 f_query_add_mod.practitioner_sub.practitioner1_form.rep_facility.disabled=false;
					}
				}else{
					f_query_add_mod.practitioner_sub.practitioner1_form.all_facilities1.value='N';									
				}
			  }
		    f_query_add_mod.document.practitioner_sub.practitioner1_form.signimage1.value=f_query_add_mod.document.practitioner_sub.practitioner1_form.signimage.value; // added by mujafar for AAKH-CRF-0079.4
			f_query_add_mod.document.practitioner_sub.practitioner1_form.stampimage1.value=f_query_add_mod.document.practitioner_sub.practitioner1_form.stampimage.value; // added by manjunath for TH-KW-CRF-0161.1
			//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
			if(isResidencyApplYN == "true" && eff_stat == "E" && f_query_add_mod.practitioner_sub.practitioner1_form.other_alt_type.disabled==true){
				 f_query_add_mod.practitioner_sub.practitioner1_form.other_alt_type.disabled=false;
			}

			if(isResidencyApplYN == "true" && eff_stat == "E" && f_query_add_mod.practitioner_sub.practitioner1_form.national_id_no.disabled==true){
				f_query_add_mod.practitioner_sub.practitioner1_form.national_id_no.disabled=false;
			}
			
			f_query_add_mod.document.practitioner_sub.practitioner1_form.action="../../servlet/eAM.PractitionerServlet";
			f_query_add_mod.document.practitioner_sub.practitioner1_form.target="messageFrame";
			f_query_add_mod.document.practitioner_sub.practitioner1_form.submit();
			if(fun_id_temp=="PRACTITIONER"){
				if(f_query_add_mod.practitioner_sub.practitioner1_form.all_facilities.checked == true){
					if(f_query_add_mod.practitioner_sub.practitioner1_form.rep_facility.disabled==false){
						 f_query_add_mod.practitioner_sub.practitioner1_form.rep_facility.disabled=true;
					}
				}	
			}
			//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
			if(isResidencyApplYN == "true" && eff_stat == "E" && f_query_add_mod.practitioner_sub.practitioner1_form.other_alt_type.disabled==false && f_query_add_mod.practitioner_sub.practitioner1_form.res_citizen.item(1).checked == true){
				 f_query_add_mod.practitioner_sub.practitioner1_form.other_alt_type.disabled=true;
			}

			if(isResidencyApplYN == "true" && eff_stat == "E" && f_query_add_mod.practitioner_sub.practitioner1_form.national_id_no.disabled==false && f_query_add_mod.practitioner_sub.practitioner1_form.res_citizen.item(1).checked == true){
				 f_query_add_mod.practitioner_sub.practitioner1_form.national_id_no.disabled=true;
			}

		}
		var fn_status = f_query_add_mod.document.practitioner_sub.practitioner1_form.function_name.value ;
		//}
	}
}


}
function reset() 
{
	if (f_query_add_mod.document.forms[0] != null)
	{
	    f_query_add_mod.document.location.reload() ;
	}
    else 
	{
	   f_query_add_mod.practitioner_main.document.location.reload() ;
	   f_query_add_mod.practitioner_sub.document.location.reload() ;
    }

 }
function onSuccess() {

	f_query_add_mod.location.reload();
}
function sendToServer(Val) 
{
var HTMLVal = new String();
if (Val == 1)
{
	HTMLVal = "<HTML><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAM/jsp/ServerFunction.jsp'><input type='hidden' name='process_d' id='process_d' value='1'><input name='date_of_birth' id='date_of_birth' type='hidden' value='"+document.getElementById("date_of_birth").value+"'></form></BODY></HTML>";
	parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.parent.messageFrame.document.form1.submit();
}
if ( Val == 2 )
{
	HTMLVal = "<HTML><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAM/jsp/ServerFunction.jsp'><input type='hidden' name='process_d' id='process_d' value='2'><input type='hidden' name='b_age' id='b_age' value='" + document.getElementById('b_age').value + "'><input type='hidden' name='b_months' id='b_months' value='" + document.getElementById('b_months').value +"'><input name='b_days' id='b_days' type='hidden' value='"+document.getElementById("b_days").value + "'></form></BODY></HTML>";
	parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.parent.messageFrame.document.form1.submit();
}
}
function gotoNext(Obj)	{
if ( Obj == document.getElementById('date_of_birth') )
{
	if ( CheckDate(document.getElementById('date_of_birth')) == false) {
		document.getElementById('date_of_birth').focus();
	}
	else
	{
		if(doDateCheckAlert(Obj,document.getElementById('server_date')))
		{
			sendToServer(1);
		}
		else
		{
			//alert('APP-MP0071 Date of Birth cannot be greater than TODAY ');
			alert(getMessage("DOB_CHECK","Common"));

			Obj.focus();
		}
	}
}
else if ( Obj == document.getElementById("b_days") )
{
	if ( Obj.value > 31 )
	{
		//alert('APP-MP0073 Days cannot be greater than 31 ');
		alert(getMessage("DAYS_CHECK","Common"));
		Obj.focus();
	}
	else if(Obj.value < 0)
	{
		//alert('APP-MP0070 Age cannot be less than ZERO or Negative');
		alert(getMessage("NEG_AGE_CHECK","Common"));
		Obj.focus();
	}
	else
		sendToServer(2);
}
else if ( Obj == document.getElementById('b_months') )
{
	if ( Obj.value > 11 )
	{
		//alert('APP-MP0069 Months cannot be greater than 11');
		alert(getMessage("MONTHS_CHECK","Common"));
		Obj.focus();
	}
	else if(Obj.value < 0)
	{

		//alert('APP-MP0070 Age cannot be less than ZERO or Negative');
		alert(getMessage("NEG_AGE_CHECK","Common"));
		Obj.focus();
	}
		sendToServer(2);
}
else if ( Obj == document.getElementById('b_age') )
{
	if ( Obj.value < 0)
	{
		//alert('APP-MP0070 Age cannot be less than ZERO or Negative');
		alert(getMessage("NEG_AGE_CHECK","Common"));
		Obj.focus();
	}
	else if ( Obj.value == '')
		Obj.value = 0;
	else
		sendToServer(2);
}

}
function validateNationality(Nat_Id,nat_id_prompt,nat_id_check_digit_id)	
{
//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
var isResidencyApplYN = document.getElementById('isResidencyApplYN').value;
var eff_stat = document.getElementById('eff_stat').value;

var isNumber = new Boolean();
isNumber = true;

var ind = -1;

	if ( Nat_Id.value.length > 0 )
	{
		if ( (nat_id_check_digit_id=='M11') && (ind = Nat_Id.value.indexOf('X')) != -1)
		{
			if (ind < 12)           // X can be entered only at 13th position
			{
				msg = getMessage('INVALID_NAT_ID','MP');
				msg = msg.replace("#",nat_id_prompt);
				Nat_Id.select();
				alert(msg);
				return false;
			}
		}
	}


/*if ( Nat_Id.value.length > 0 )
{
	if ( CheckForNumber(Nat_Id.value) )
		isNumber = true;
	else
	{
		isNumber = false;
		Nat_Id.focus();
	}
}
else if(Nat_Id.value.length == 0 )
{
	Nat_Id.value = '';
	isNumber = true;
}*/

if ( isNumber )
{
	var continue_yn = 'true';
	var nid = new String();
	nid = trimString(Nat_Id.value);
	Nat_Id.value = nid;
	var nat_id_prompt=practitioner1_form.nat_id_prompt.value;

	if ( nid.length == Nat_Id.maxLength  && nid.length != 0)
	{
		if (document.getElementById('function_name').value=='modify')
		{	
			if (document.getElementById('oldnationalid').value ==  nid)
				continue_yn = 'false';
		}
		if (continue_yn=='true')
		{
			//Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011
			if(isResidencyApplYN == "true" && eff_stat == "E")
			{
				duplicateNatIdValidation(Nat_Id,nat_id_prompt);
			}else
			{
				var HTMLVal = new String();
				HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form id='form1' name='form1' method='post' action='../../eAM/jsp/CheckForNationality.jsp?step=second'><input id='national_id_no'  type='hidden' name='national_id_no' value='"+Nat_Id.value+"'><input id='FROM_VAL'  type='hidden' name='FROM_VAL' value='PRACTITIONER'></form></body></html>";
				parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
				parent.parent.messageFrame.document.form1.submit();
			}
		}
	}
	else
	{
		if ( Nat_Id.value != '' )
		{
			alert('APP-MP0068 '+nat_id_prompt+' should be of '+document.getElementById('national_id_no').maxLength+' Characters');
			document.getElementById('national_id_no').focus();
		}
	}
}
}
/*function calcage(obj1,obj2) {
	if(doDateCheckAlert(obj1,document.getElementById('server_date')))
		{
		alert(obj1.value);
		if(CheckDate(obj1) == false)
			{}
		else
		{
		if(obj1.value.length !=0)
		{
		var datecal=obj1.value;
		strDateArray = datecal.split("/");
		if (strDateArray.length != 3) ;
		else {
			strDay = strDateArray[0];
			strMonth = strDateArray[1];
			strYear = strDateArray[2];
		}

	    var ageYears, ageMonths, ageDays
	    var datecal2=document.getElementById('server_date').value;
		 //bornDate = new Date(mm+'/'+ dd +'/'+ yy)
	    bornDate = new Date(strMonth+'/'+strDay+'/'+strYear);
	    mm = bornDate.getMonth()+1 ;
	    dd = bornDate.getDate();
	    yy = bornDate.getFullYear();
		
		strDateArray1 = datecal2.split("/");
				if (strDateArray.length != 3) ;
				else {
					strDay1 = strDateArray1[0];
					strMonth1 = strDateArray1[1];
					strYear1 = strDateArray1[2];
		}

	    testDate = new Date(strMonth1+'/'+strDay1+'/'+strYear1);
	    mm2 = testDate.getMonth()+1 ;
	    dd2 = testDate.getDate();
	    yy2 = testDate.getFullYear();

	if (yy < 100 && yy > 20) {
			        yy = yy + 1900
			        }
				if (yy2 < 100){
					if (yy2 > 20) {
						yy2 = yy2 + 1900
			        }else{
						yy2 = yy2 + 2000
			        }
			    }


	    //calcualate # of years
	    ageYears = yy2 - yy
		//adjust years by looking at months
	    //same month, no birthday yet (add 12 months)
	    if(mm2 == mm){
			if(dd2 < dd){
				mm2 = mm2 + 12;
				ageYears = ageYears - 1;
			}
	    }
	    //earlier month (add 12 months)
	    if(mm2 < mm){
			mm2 = mm2 + 12;
			ageYears = ageYears - 1;
			ageMonths = mm2 - mm;
		}

		ageMonths = mm2 - mm;
		

	    //adjust months by looking at days
	    if (dd2 < dd) {
			ageMonths = ageMonths - 1;
			if((ageMonths == 4) || (ageMonths == 6) || (ageMonths == 9) || (ageMonths == 11))
			{
				dd2 = dd2 + 30;
			}
			else
			if(ageMonths == 2)
			{
				dd2=dd2+30;
			}
			else
			{
				dd2=dd2+30;
			}
			if (mm2 == mm) {
				ageMonths = 0;
				ageYears = ageYears - 1;
				}
	        }
	        ageDays = dd2 - dd;
	
	

	document.getElementById('b_age').value= ageYears ;
	if(document.getElementById('b_age').value.length == 1  && document.getElementById('b_age').value !='0') document.getElementById('b_age').value="0"+ageYears ;
	//if(ageYears > 1 || ageYears < 10) parent.document.practitioner_main.document.forms[0].b_age.value="0"+ageYears ; 
	
	document.getElementById('b_months').value=ageMonths;
	if(document.getElementById('b_months').value.length == 1 && document.getElementById('b_months').value !='0') document.getElementById('b_months').value="0"+ageMonths;
	//if(ageMonths > 1 || ageMonths < 10) parent.document.practitioner_main.document.forms[0].b_months.value="0"+ageMonths;
	
	document.getElementById("b_days").value=ageDays;
	if(document.getElementById("b_days").value.length == 1 && document.getElementById("b_days").value !='0') document.getElementById("b_days").value="0"+ageDays;
	//if(ageDays > 1 || ageDays < 10 ) parent.document.practitioner_main.document.forms[0].b_days.value="0"+ageDays;
	}
}

return true;
}
else
{
//alert('APP-MP0071 Date of Birth cannot be greater than TODAY ');
alert(getMessage('DOB_CHECK','Common'));
document.getElementById('date_of_birth').focus();
return false;
}

}
*/
function doDateCheckAlert(from,to) {
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);	
			if(Date.parse(todt) < Date.parse(fromdt)) {
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
return true;
}




function calculateAge(Obj,Val)
{

var flag=true;
var HTMLVal= new String();

var greg_date_of_birth="";

if ( Val == 1 )
{
	if(Obj.value!="")
	{
		
	if(!validDateObj(Obj,"DMY",localeName))
		{
			Obj.value="";
			return ;
		}
else{
	 greg_date_of_birth = convertDate(Obj.value,"DMY",localeName,"en");

   //if(calcage(document.practitioner1_form.greg_date_of_birth,document.getElementById('ServerDate')))
   //{ 
	   if(BirthDay_check(document.getElementById('server_date'),Obj))
		{
    HTMLVal = "<HTML><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAM/jsp/ServerValidation.jsp'><input type='hidden' name='reference' id='reference' value='parent.practitioner_sub.document.practitioner_sub.document.forms[1]'><input type='hidden' name='process_id' id='process_id' value='1'><input name='date_of_birth' id='date_of_birth' type='hidden' value='"+document.getElementById("greg_date_of_birth").value+ "'></form></BODY></HTML>";
    parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
    parent.parent.messageFrame.document.form1.submit();
		}
  // }
}
	}
}
if ( Val == 2 )
{
	if(Obj.name== 'b_months')
	{
			if(!checkMonth(document.practitioner1_form.greg_date_of_birth))
			{
				flag=false;
				document.getElementById('b_months').value=''
				document.getElementById('b_months').focus();
			}
	}
	if(flag)
	{
		   if(Obj.name == 'b_days')
		   {
		   	if(!chkDays(document.practitioner1_form.greg_date_of_birth))
		   	{
		   		flag=false;
		   		document.getElementById("b_days").focus();
		   		document.getElementById("b_days").value=''
		   	
		   	}
		   
		   
		   }
	}	   
		  if(flag)
		  {
		  HTMLVal = "<HTML><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAM/jsp/ServerValidation.jsp'><input type='hidden' name='reference' id='reference' value='parent.practitioner_sub.document.practitioner_sub.document.forms[1]'><input type='hidden' name='process_id' id='process_id' value='2'><input type='hidden' name='b_age' id='b_age' value='" + document.getElementById("b_age").value + "'><input type='hidden' name='b_months' id='b_months' value='" + document.getElementById("b_months").value +"'><input name='b_days' id='b_days' type='hidden' value='"+document.forms[1].b_days.value + "'></form></BODY></HTML>";
		    parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		    parent.parent.messageFrame.document.form1.submit();
		  }
	
	}
}

function chkDays(Obj)
{
if(parseInt(Obj.value) >31)
	{
		alert(getMessage('DAYS_CHECK','Common'))
		Obj.focus();
		return false;	
	}
	else
	return true;

}

function leapyear(a) {
if(((a % 4 == 0) && (a % 100 != 0)) || (a % 400 == 0))
return true;
else
return false;
}

function checkMonth(Obj)
{
if( Obj.value  > 11) {
//alert('APP-MP0069 Months cannot be greater than 11');
alert(getMessage("MONTHS_CHECK","Common"));
document.getElementById('date_of_birth').value='';
Obj.focus(); 

return false;
}
else{
return true;

}

}

function checkDays(Obj)
{
if( Obj.value  > 31) { //alert('APP-MP0073 Days cannot be greater than 31'); 
alert(getMessage("DAYS_CHECK","Common"));

Obj.focus();
document.getElementById('date_of_birth').value='';
return false;

}else{
	calci(Obj);
}
}

async function searchCode(obj,target,obj2)
			{ 
			
					

				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var tit=getLabel("eMP.postalcode.label","MP");


				sql = "select postal_code code, short_desc description from mp_postal_code where eff_status = 'E' and upper(postal_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
					
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;
				retVal = await CommonLookup( tit, argumentArray );
				if (retVal !=null && retVal !="")
				{
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target.value=arr[0];

					if(target.name=="res_add_postal_code" || target.name=="res_add_postal_code2" )
					{
					practitioner1_form.res_code_value.value=arr[0];
					}else if(target.name=="off_add_postal_code" || target.name=="off_add_postal_code2")
					{
						practitioner1_form.off_code_value.value=arr[0];
					}else
					{
						practitioner1_form.mail_code_value.value=arr[0];
					}
				}else
				{
				target.value="";
				practitioner1_form.postal_code.value="";
				}
					
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
function onkeyPressEvent(e){  // added by mujafar for AAKH-CRF-0079.4 start
	return false;
}

function ValidateFileType(obj){ 
	
 	var condition="";
 		if(obj.value!=""){ 
		var fileTypeArr = obj.value.split(/[\s.]+/);
		var fileType	= fileTypeArr[fileTypeArr.length-1].toUpperCase();
		
		//Modified by Ashwini for NMC-JD-CRF-0058.1
		condition=(fileType!='JPG' && fileType!='JPEG' && fileType!='PNG');
		if(condition){			
			alert(getMessage("INVALID_FILE_TYPE","MP"));
			if(obj.name=="signimage"){
				 var elem = document.getElementById("signimage");
        elem.parentNode.innerHTML = elem.parentNode.innerHTML;
			}
			if(obj.name=="stampimage"){
			var elem = document.getElementById("stampimage");
			elem.parentNode.innerHTML = elem.parentNode.innerHTML;
			}			
		}
			
		}else{
			var fso, f;
			fso = new ActiveXObject("Scripting.FileSystemObject");	 
			if(fso.FileExists(obj.value)){ 
				file=fso.getFile(obj.value);		
				if(file.size > 2147483648){
					alert(getMessage("FILE_GREATER_2GB","MP"));	
					if(obj.name=="signimage"){ 
				var elem = document.getElementById("signimage");
				elem.parentNode.innerHTML = elem.parentNode.innerHTML;
				
				}
				else if(obj.name=="signimage"){ 
				var elem = document.getElementById("stampimage");
				elem.parentNode.innerHTML = elem.parentNode.innerHTML;
				}
				
				}
								
		        }
            }
		}  


async function showPractSign(practitionerid,function_id,sign_stamp) 
{ // added by mujafar for AAKH-CRF-0079.4 end
var dialogHeight = '50vh' ;
var dialogWidth  = '60vw' ;
var features     = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;'
var arguments    = '' ;
 var retVal = await top.window.showModalDialog("../../eAM/jsp/ViewPractSignFrame.jsp?practitionerid="+practitionerid+"&function_id="+function_id+"&sign_stamp="+sign_stamp,arguments,features); 
}

/*Added by Ashwini on 20-Mar-2020 for MOHE-CRF-0011*/
function validateCitizen(nat_desc,nat_code)
{
	document.practitioner1_form.citizenshipDesc.value = nat_desc;
	document.practitioner1_form.citizen.value = nat_code;

	if(document.practitioner1_form.citizen2)
	{
		document.practitioner1_form.citizen2.value = nat_code;
	}
	if(document.practitioner1_form.national_id_no)
	{
		document.practitioner1_form.national_id_no.value = document.practitioner1_form.oldnationalid.value;
		document.practitioner1_form.national_id_no.disabled = false;
		if(document.practitioner1_form.natid_mand_yn.value == "Y")
		{
			document.practitioner1_form.nat_mandatory.style.visibility = "visible";
		}
	}
	if(document.practitioner1_form.other_alt_type_no.value != "")
	{
		document.practitioner1_form.other_alt_type.value = document.practitioner1_form.other_alt_type_no.value;
		document.practitioner1_form.other_alt_type.disabled = false;
		document.practitioner1_form.other_alt_no.value = document.practitioner1_form.other_alt_type_desc.value;
		document.practitioner1_form.other_alt_no.disabled = false;
		document.practitioner1_form.oth_alt_mand.style.visibility = "hidden";
	}else
	{
		document.practitioner1_form.other_alt_type.value = "";
		document.practitioner1_form.other_alt_type.disabled = false;
		document.practitioner1_form.other_alt_no.value = "";
		document.practitioner1_form.other_alt_no.disabled = true;
		document.practitioner1_form.oth_alt_mand.style.visibility = "hidden";
	}
	
	document.practitioner1_form.other_alt_no.maxLength = "20";
}

function validateNonCitizen(nat_desc,nat_code)
{
	var citzn_desc = document.practitioner1_form.citizen_nat_desc.value;
	var alt_id1_type = document.practitioner1_form.alt_id1_type.value;

	if(citzn_desc == nat_desc)
	{
		document.practitioner1_form.citizenshipDesc.value = "";
		document.practitioner1_form.citizen.value = "";
		if(document.practitioner1_form.citizen2) 
		{
			document.practitioner1_form.citizen2.value = "";
		}
	}else
	{
		document.practitioner1_form.citizenshipDesc.value = nat_desc;
		document.practitioner1_form.citizen.value = nat_code;
		if(document.practitioner1_form.citizen2)
		{
			document.practitioner1_form.citizen2.value = nat_code;
		}
	}

	if(document.practitioner1_form.national_id_no)
	{
		document.practitioner1_form.national_id_no.value = "";
		document.practitioner1_form.national_id_no.disabled = true;
		document.practitioner1_form.nat_mandatory.style.visibility = "hidden";
	}
	if(document.practitioner1_form.oth_alt_val.value != "")
	{
		if(document.practitioner1_form.other_alt_type_no.value == document.practitioner1_form.oth_alt_val.value)
		{
			document.practitioner1_form.other_alt_no.value = document.practitioner1_form.other_alt_type_desc.value;
		}
		else
		{
			document.practitioner1_form.other_alt_no.value = "";			
		}
		document.practitioner1_form.other_alt_type.value = document.practitioner1_form.oth_alt_val.value;
		document.practitioner1_form.other_alt_type.disabled = true;
		document.practitioner1_form.other_alt_no.disabled = false;
		document.practitioner1_form.oth_alt_mand.style.visibility = "visible";
	}else
	{
		document.practitioner1_form.other_alt_type.value = "";
		document.practitioner1_form.other_alt_type.disabled = true;
		document.practitioner1_form.other_alt_no.value = "";
		document.practitioner1_form.other_alt_no.disabled = true;
		document.practitioner1_form.oth_alt_mand.style.visibility = "hidden";
	}

	if(document.practitioner1_form.oth_alt_val.value == alt_id1_type)
	{
		document.practitioner1_form.other_alt_no.maxLength = document.practitioner1_form.alt_id1_length.value;
	}else
	{
		document.practitioner1_form.other_alt_no.maxLength = "20";
	}
}

function checkCitznOrNonCitzn()
{
	var citzn_desc = document.practitioner1_form.citizenshipDesc.value;
	var nat_desc = document.practitioner1_form.citizen_nat_desc.value;
	var alt_id1_type = document.practitioner1_form.alt_id1_type.value;

	if(citzn_desc != "")
	{
		if(citzn_desc == nat_desc)
		{
			document.practitioner1_form.res_citizen.item(0).checked = true;

			if(document.practitioner1_form.national_id_no)
			{
				document.practitioner1_form.national_id_no.value = document.practitioner1_form.oldnationalid.value;
				document.practitioner1_form.national_id_no.disabled = false;
				if(document.practitioner1_form.natid_mand_yn.value == "Y")
				{
					document.practitioner1_form.nat_mandatory.style.visibility = "visible";
				}
			}
			if(document.practitioner1_form.other_alt_type_no.value != "")
			{
				document.practitioner1_form.other_alt_type.value = document.practitioner1_form.other_alt_type_no.value;
				document.practitioner1_form.other_alt_type.disabled = false;
				document.practitioner1_form.other_alt_no.value = document.practitioner1_form.other_alt_type_desc.value;
				document.practitioner1_form.other_alt_no.disabled = false;
				document.practitioner1_form.oth_alt_mand.style.visibility = "hidden";
			}else
			{
				document.practitioner1_form.other_alt_type.value = "";
				document.practitioner1_form.other_alt_type.disabled = false;
				document.practitioner1_form.other_alt_no.value = "";
				document.practitioner1_form.other_alt_no.disabled = true;
				document.practitioner1_form.oth_alt_mand.style.visibility = "hidden";
			}

			document.practitioner1_form.other_alt_no.maxLength = "20";
		}else
		{
			document.practitioner1_form.res_citizen.item(1).checked = true;

			if(document.practitioner1_form.national_id_no)
			{
				document.practitioner1_form.national_id_no.value = "";
				document.practitioner1_form.national_id_no.disabled = true;
				document.practitioner1_form.nat_mandatory.style.visibility = "hidden";
			}
			if(document.practitioner1_form.oth_alt_val.value != "")
			{
				if(document.practitioner1_form.other_alt_type_no.value == document.practitioner1_form.oth_alt_val.value)
				{
					document.practitioner1_form.other_alt_no.value = document.practitioner1_form.other_alt_type_desc.value;
				}
				else
				{
					document.practitioner1_form.other_alt_no.value = "";			
				}
				document.practitioner1_form.other_alt_type.value = document.practitioner1_form.oth_alt_val.value;
				document.practitioner1_form.other_alt_type.disabled = true;
				document.practitioner1_form.other_alt_no.disabled = false;
				document.practitioner1_form.oth_alt_mand.style.visibility = "visible";
			}else
			{
				document.practitioner1_form.other_alt_type.value = "";
				document.practitioner1_form.other_alt_type.disabled = true;
				document.practitioner1_form.other_alt_no.value = "";
				document.practitioner1_form.other_alt_no.disabled = true;
				document.practitioner1_form.oth_alt_mand.style.visibility = "hidden";
			}

			if(document.practitioner1_form.oth_alt_val.value == alt_id1_type)
			{
				document.practitioner1_form.other_alt_no.maxLength = document.practitioner1_form.alt_id1_length.value;
			}else
			{
				document.practitioner1_form.other_alt_no.maxLength = "20";
			}
		}
	}
}

function duplicateNatIdValidation(nat_id,nat_id_prompt)
{
	var national_id = nat_id.value;
	var old_nat_id = document.practitioner1_form.oldnationalid.value;

	if(national_id.toUpperCase() != old_nat_id.toUpperCase())
	{
		var xmlDoc=""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH national_id=\""+national_id+"\" action='getPractName' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eAM/jsp/AMIntermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText = xmlHttp.responseText
		var retval = trimString(responseText);
		retval = retval.split("|~|");
		var rec_cnt = retval[0];
		var practitioner_name = retval[1];

		if(rec_cnt == 1)
		{
			msg = getMessage('PRACT_DUP_NAT_ID','AM');
			msg = msg.replace("$",practitioner_name);
			msg = msg.replace("#",nat_id_prompt);
			nat_id.select();
			alert(msg);
			return false;
		}else if(rec_cnt > 1)
		{
			msg = getMessage('PRACT_DUP_NAT_ID_MULTIPLE','AM');
			msg = msg.replace("#",nat_id_prompt);
			nat_id.select();
			alert(msg);
			return false;
		}
	}
}

function duplicateOthAltIdValidation(alt_id,oth_alt_type)
{
	var alt_id1_type = document.practitioner1_form.alt_id1_type.value;

	if(document.practitioner1_form.res_citizen.item(1).checked == true)
	{
		var other_alt_type_desc = document.practitioner1_form.other_alt_type_desc.value;
		var oth_alt_id = alt_id.value;

		if ( oth_alt_id.length == alt_id.maxLength && oth_alt_id.length != 0)
		{
			validateDuplicate(other_alt_type_desc,oth_alt_id,alt_id,oth_alt_type);
		}else
		{
			if (alt_id.value != '')
			{
				if(document.practitioner1_form.oth_alt_val.value == alt_id1_type)
				{
					var err = getMessage('MAX_LENGHT_VALIDATE','AM');
					err= err.replace('$',getLabel("eMP.OtherAltNo.label","MP"));
					err= err.replace('#',document.getElementById('other_alt_no').maxLength);
					alert(err);
					document.getElementById('other_alt_no').focus();
				}else
				{
					validateDuplicate(other_alt_type_desc,oth_alt_id,alt_id,oth_alt_type);
				}
			}
		}
	}
}

function validateDuplicate(other_alt_type_desc,oth_alt_id,alt_id,oth_alt_type)
{
	if(other_alt_type_desc.toUpperCase() != oth_alt_id.toUpperCase())
	{
		var xmlDoc=""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH oth_alt_type=\""+oth_alt_type+"\" oth_alt_id=\""+oth_alt_id+"\" action='getOthAltPractName' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eAM/jsp/AMIntermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText = xmlHttp.responseText
		var retval = trimString(responseText);
		retval = retval.split("|~|");
		var rec_cnt = retval[0];
		var practitioner_name = retval[1];

		if(rec_cnt == 1)
		{
			msg = getMessage('PRACT_DUP_NAT_ID','AM');
			msg = msg.replace("$",practitioner_name);
			msg = msg.replace("#",getLabel("eMP.OtherAltNo.label","MP"));
			alt_id.select();
			alert(msg);
			return false;
		}else if(rec_cnt > 1)
		{
			msg = getMessage('PRACT_DUP_NAT_ID_MULTIPLE','AM');
			msg = msg.replace("#",getLabel("eMP.OtherAltNo.label","MP"));
			alt_id.select();
			alert(msg);
			return false;
		}
	}
}
/*End MOHE-CRF-0011*/


function enaDisSupervisorChkbox(value){
	if(value=="MA"){
		if(document.practitioner_form.supervisorchk){
			document.practitioner_form.supervisorchk.disabled = false;
		}
	}else{
		if(document.practitioner_form.supervisorchk){
			document.practitioner_form.supervisorchk.checked = false;
			document.practitioner_form.supervisorchk.disabled = true;
			document.practitioner1_form.supervisor_yn.value = 'N';
		}
	}
}

//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 Started -->
function changevalue()
{
	
	var enable_virtual_consultation=document.getElementById("enable_virtual_consultation").checked;
	if(enable_virtual_consultation)
	{
		document.getElementById("enable_virtual_consultation").value="E"
	}	
	else
	{
		document.getElementById("enable_virtual_consultation").value="D";
	}

}

//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 Started -->
function validateEnablevirtualConst(value)
{
	
	if(value=="MD")
	{
		document.getElementById("pract_Physician_div").style.display = "block";
	}	
	else
	{
		document.getElementById("pract_Physician_div").style.display = "none";
		document.getElementById("enable_virtual_consultation").checked = false;
		changevalue();
	}
}
// added by Lakshmanan for MO-CRF-20183.2 US001 start
function EmpSrvNoUniqueCheck(obj,actual_val){
	//parent.parent.messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_val=';
	var objValue=obj.value;
	var actualValue=actual_val;
	if(objValue!=actualValue){	
	var servicenocheck=Number(obj.value);
	if(servicenocheck!="" && servicenocheck!='0'){
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		xmlStr ="<root><SEARCH action=\"EmpServNo\" empservno=\""+obj.value+"\" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open('POST','../../eAM/jsp/AMIntermediate.jsp',false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText=TrimStr(responseText);
		if (responseText>0){
			var msg = parent.practitioner_main.getMessage("EMPLOYEE_SERVICE_NO_ALREADY_EXISTS","AM");
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			return true;
			}
		else {
			f_query_add_mod.document.practitioner_sub.practitioner1_form.employee_service_number_1.value = objValue; 
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_val='	
			return false;
		}		
	} else {
		f_query_add_mod.document.practitioner_sub.practitioner1_form.employee_service_number.value=""
		return false;
	}
} else{
	return false;
}
}
 
//Below function allow alphabets & numbers to paste and will not allow special characters while paste
function CheckSplCharsValidation_EmpSrvNo(Obj){
	var str = Obj.value;
	strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-';
	for (i=0;i<str.length;i++){
		if (strCheck.indexOf(str.charAt(i)) == -1) 
		{
			alert(getMessage("SPL_CHAR_NOT_ALLOWED",'MP'));
			Obj.value="";
			Obj.focus();
			return false;  
		}
	}
}
// added by Lakshmanan for MO-CRF-20183.2 US001 end

