
function getService1(obj2,facilityid,to_locn_type,obj4)
{
	
		if(obj2.value == "")
		{
			 obj2.value="";
			 obj4.value="";
			 return;
			}
	
	

getService(obj2,facilityid,to_locn_type,obj4)
}

async function getService(obj2,facilityid,to_locn_type,obj4)
{
  //source_type=document.forms[0].source_type.value;
		var sqlservice="";		
		var locale=document.forms[0].localeth.value;
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit=getLabel('Common.service.label','Common');
		var sql="";
	    var speciality=parent.frames[1].document.forms[0].to_speciality_code.value;
		var u=parent.frames[1].document.forms[0].to_locn.value;
	    var loc_type=parent.frames[1].document.forms[0].locationT0.value;	

		// code added for 20854

		strArray = u.split("$");
		var loc_code=strArray[0];
		var open_to_all_pract_yn=strArray[1];

	
	if((loc_type!="") && (loc_code!="") &&( speciality!="")) {
	   if(loc_type=="C") {
			sql="select service_code code ,short_desc description from AM_SERVICE_LANG_VW  where service_code in(select a.service_code from op_clinic a where a.speciality_code = '"+speciality+"' and a.clinic_code ='"+loc_code+"' and a.facility_id='"+facilityid+"' and a.care_locn_type_ind = 'C' and a.clinic_type='C' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+facilityid+"' and b.speciality_code ='"+speciality+"' and a.clinic_code = '"+loc_code+"' )  and language_id='"+locale+"' and  upper(service_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
		}else if(loc_type=="E") {
			sql="select service_code code,short_desc  description from AM_SERVICE_LANG_VW where service_code in(select a.service_code from op_clinic a where a.speciality_code = '"+speciality+"' and a.clinic_code ='"+loc_code+"' and a.facility_id='"+facilityid+"' and a.care_locn_type_ind = 'E' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+facilityid+"' and b.speciality_code ='"+speciality+"' and a.clinic_code = '"+loc_code+"' ) and language_id='"+locale+"'  and  upper(service_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
		}else if(loc_type=="N")	{
			sql="select service_code code,long_desc description from AM_SERVICE_LANG_VW where service_code in(select a.service_code from ip_nursing_unit a where a.nursing_unit_code ='"+loc_code+"' and a.facility_id='"+facilityid+"' and a.appl_patient_class = 'IP' union select a.service_code from ip_nurs_unit_for_service a,ip_nursing_unit b where a.nursing_unit_code = b.nursing_unit_code and a.facility_id=b.facility_id and a.facility_id='"+facilityid+"'and b.appl_patient_class = 'IP' and a.nursing_unit_code = '"+loc_code+"')  and language_id='"+locale+"' and  upper(service_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
		}else if (loc_type=="W") {
			sql="SELECT distinct C.SERVICE_CODE code,D.SHORT_DESC description FROM RD_SECTION_CTL A,RD_WINGS B,RD_SECTION C,AM_SERVICE D WHERE   A.OPERATING_FACILITY_ID='"+facilityid+"' AND A.WING_CODE = NVL('"+loc_code+"',A.WING_CODE) AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.WING_CODE = B.WING_CODE AND A.SECTION_CODE = C.SECTION_CODE AND C.SERVICE_CODE = D.SERVICE_CODE AND B.INT_OR_EXT = 'I'  and  upper(c.service_code) like upper(?) and upper(d.short_desc) like upper(?) order by 2";
		} else	{
			sql="select service_code code,short_desc description from AM_SERVICE_LANG_VW where service_code in(select a.service_code from op_clinic a where a.speciality_code = '"+speciality+"' and a.clinic_code ='"+loc_code+"' and a.facility_id='"+facilityid+"' and a.care_locn_type_ind = 'D' and a.clinic_type='Y' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+facilityid+"' and b.speciality_code ='"+speciality+"' and a.clinic_code = '"+loc_code+"' )  and language_id='"+locale+"'  and  upper(service_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
		}	
	}else {	
		if(to_locn_type=="W") {		
		sql = "SELECT  distinct C.SERVICE_CODE code,D.SHORT_DESC description FROM RD_SECTION_CTL A,RD_WINGS B,RD_SECTION C,AM_SERVICE D WHERE   A.OPERATING_FACILITY_ID='"+facilityid+"' AND A.WING_CODE = NVL('"+to_locn_code+"',A.WING_CODE) AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.WING_CODE = B.WING_CODE AND A.SECTION_CODE = C.SECTION_CODE AND C.SERVICE_CODE = D.SERVICE_CODE AND B.INT_OR_EXT = 'I' and upper(c.service_code) like upper(?) and upper(d.short_desc) like upper(?) order by 2";							
	  }else{	
		//sql = "Select Distinct Service_Code code, Short_Desc description from AM_SERVICE_LANG_VW where eff_status='E' and language_id='"+locale+"' and upper(service_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
		//sql = "SELECT A.SERVICE_CODE CODE, B.SHORT_DESC DESCRIPTION FROM AM_FACILITY_SERVICE A, AM_SERVICE_LANG_VW B  WHERE      A.OPERATING_FACILITY_ID ='"+facilityid+"' AND A.EFF_STATUS='E' AND A.SERVICE_CODE = B.SERVICE_CODE AND B.LANGUAGE_ID='"+locale+"'  and upper(A.service_code) like upper(?) and upper(B.short_desc) like upper(?) order by 2";

		/******
		Issue Des: "Distinct" was added in the below query for the incident SRR20056-SCF-5942 [IN:024960] on 08.11.2010 by Suresh M
		 In Register patient referral function For Refer To tab. Select ??? of Service field and click Search button.
		The system show  duplicate service.

		******/

		sql = "SELECT Distinct A.SERVICE_CODE CODE, B.SHORT_DESC DESCRIPTION FROM AM_FACILITY_SERVICE A, AM_SERVICE_LANG_VW B  WHERE      A.OPERATING_FACILITY_ID ='"+facilityid+"' AND A.EFF_STATUS='E' AND A.SERVICE_CODE = B.SERVICE_CODE AND B.LANGUAGE_ID='"+locale+"'  and upper(A.service_code) like upper(?) and upper(B.short_desc) like upper(?) order by 2";
	  }
	}			
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = obj2.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( tit, argumentArray );

		if (!(retVal == null||retVal == "")) {				
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			obj2.value=arr[1];
			obj4.value=arr[0];			
		}else{
			obj2.value="";
			obj4.value=""; 		
		}
}
function resMove()
{
	//alert('Welcome to eHIS');
	//alert(getMessage("WELCOME","common"));
}
function chkforref()
{		
	if(parent.frames[1].document.forms[0].referred_for_ip )
	{
		parent.frames[1].document.forms[0].referred_for_ip.disabled=true;
	}
	if(parent.frames[1].document.forms[0].refforipimg)
	{
		parent.frames[1].document.forms[0].refforipimg.style.visibility="hidden";
	}
}
function create() 
{
	f_query_add_mod.location.href = "../../eMP/jsp/RegPatReferralMainPage.jsp" ;
}

async function query() 
{
	f_query_add_mod.location.href ="../../eCommon/html/blank.html";
	var retVal = 	new String();
	var dialogHeight= "700px" ;//600px
	var dialogTop = "65" ;
	var dialogWidth	= "1100px" ;//900px
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	var 	callurl="../../eMP/jsp/ReferralSearchFrameset.jsp?function_id=REG_PAT_REF&p_calling_function=CHANGE_PAT_REFERRAL";
	retVal = await window.showModalDialog(callurl,arguments,features);
	if (retVal!=null)
	{
		f_query_add_mod.location.href = "../../eMP/jsp/RegPatReferralMainPage.jsp?mode=modify&referral_id="+retVal ;
	}
}

function delete_values(field)
{
	
	var selected = field;
	while ( selected.options.length > 0 )
				selected.remove(selected.options[0]);
	var opt=parent.frames[1].document.createElement("Option");
	
	if(field.name=="referral_source")
		opt.text="------------"+getLabel('Common.defaultSelect.label','Common')+"----------";
	else
		opt.text="------"+getLabel('Common.defaultSelect.label','Common')+"------";
	opt.value="";
	field.add(opt);
}



function clear_location(obj)
{
	//Added for incident IN023039 by Suresh M on 24.08.2010
	if(obj.value!=""){			 
			if(parent.frames[1].document.getElementById("from_locn"))
				parent.frames[1].document.getElementById("from_locn").disabled = false;
		} else {		
			if(parent.frames[1].document.getElementById("from_locn"))
				parent.frames[1].document.getElementById("from_locn").disabled = true;
		}
	//Ends IN023039
	var ref_type =parent.frames[1].document.forms[0].referral_type.value;
	var referral_source =parent.frames[1].document.forms[0].referral_source_lkp_id.value;
	var referral_sourceArr=referral_source.split("~");
		referral_source=referral_sourceArr[1];
	 parent.frames[1].document.getElementById('to_service_desc').value="";
     parent.frames[1].document.getElementById('to_service_code').value="";
	// Thursday, December 24, 2009 17511
/*	if(ref_type != 'X'){
	 parent.frames[1].document.getElementById('to_practitioner').value="";
	 parent.frames[1].document.getElementById('to_practitioner_id').value="";

	} */

	var loc_type=obj.value;	
	
	if(parent.frames[1].document.forms[0].or_operational_yn.value == "Y")
	{
		parent.frames[1].document.forms[0].order_catalog.value="";
	    parent.frames[1].document.forms[0].order_catalog_desc.value="";

	if(loc_type == "W")
	{	
		parent.frames[1].document.forms[0].catalog_but.disabled=false;
		parent.frames[1].document.forms[0].order_catalog_desc.readOnly=false;
	}		
	else if(loc_type == "N" || loc_type == "")
	{
			parent.frames[1].document.forms[0].catalog_but.disabled=true;
			parent.frames[1].document.forms[0].order_catalog_desc.readOnly=true;
	}
	else 
	{
		 parent.frames[1].document.forms[0].catalog_but.disabled=false;
		 parent.frames[1].document.forms[0].order_catalog_desc.readOnly=false;
	}
	
	}

	if(obj.name == "location0")
	{
		delete_values1(parent.frames[1].document.forms[0].from_locn);
	}
	else
	{			
		delete_values1(parent.frames[1].document.forms[0].to_locn);
			//delete_values1(parent.frames[1].document.forms[0].to_service_code);
	}

	   if(obj.name=="location0")
	   {
		
			var i=1;
			if(ref_type != 'X'){
				parent.frames[1].document.getElementById('from_practitioner').value="";
				parent.frames[1].document.getElementById('from_practitioner_id').value="";
				}
			var speciality=parent.frames[1].document.forms[0].speciality.value;
			if(ref_type=='L' ||  ref_type=='E')
			{
				if(loc_type=='C' || loc_type=='N' ||  loc_type=='Y' || loc_type=='E')
				{
					var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/RegPatReferralValidation.jsp?locale1='en''><input type='hidden' name='process_id' id='process_id' value='10'><input type='hidden' name='objval' id='objval' value='"+obj.name+"'><input name='speciality' id='speciality' type='hidden' value='"+speciality + "'><input name='referral_source' id='referral_source' type='hidden' value='"+referral_source + "'><input name='loc_type' id='loc_type' type='hidden' value='"+loc_type + "'><input name='ref_type' id='ref_type' type='hidden' value='"+ref_type + "'></form></BODY></HTML>";
					
					//Added for incident IN023039 by Suresh M on 24.08.2010
					if(parent.parent.messageFrame.document.body != null ){
						parent.parent.messageFrame.document.write(HTMLVal);
						parent.parent.messageFrame.document.form1.submit();
					}
					// Ends IN023039
					
				}
			}
	}
	else if(obj.name == "locationT0")
	{
		var speciality=parent.frames[1].document.forms[0].to_speciality_code.value;			
		var pcallfunc=parent.frames[1].document.forms[0].p_calling_function.value;
		//Thursday, December 24, 2009 17511

/*		if(ref_type != 'X'){
		parent.frames[1].document.getElementById('from_practitioner').value="";
		parent.frames[1].document.getElementById('from_practitioner_id').value="";
		} */

		 parent.frames[1].document.getElementById('to_practitioner').value="";
	     parent.frames[1].document.getElementById('to_practitioner_id').value="";

		if(obj.value == "N" && parent.frames[1].document.forms[0].p_calling_function.value != 'IP_ADMIT' && parent.frames[1].document.forms[0].p_calling_function.value != 'IP_BOOKING') {
			parent.frames[1].document.forms[0].referred_for_ip.disabled=false;
			parent.frames[1].document.forms[0].referred_for_ip.value="";
			parent.frames[1].document.forms[0].refforipimg.style.visibility="visible";
		} else {
			if(obj.value == "N") {				
				if(parent.frames[1].document.forms[0].p_calling_function.value == 'IP_ADMIT')
					parent.frames[1].document.forms[0].referred_for_ip.value="A";
				else if(parent.frames[1].document.forms[0].p_calling_function.value == 'IP_BOOKING')
					parent.frames[1].document.forms[0].referred_for_ip.value="B";
			} else {
				parent.frames[1].document.forms[0].referred_for_ip.value="";
			}
			parent.frames[1].document.forms[0].referred_for_ip.disabled=true;
			parent.frames[1].document.forms[0].refforipimg.style.visibility="hidden";
		} 		

		/*
		if((obj.value == "C") || (obj.value == "E"))
		{
			
			parent.frames[1].document.forms[0].referred_for_ip.disabled=true; 	
			if( parent.frames[1].document.forms[0].referred_for_ip.disabled == true)
			{
				  parent.frames[1].document.forms[0].referred_for_ip.disabled= false;
				  parent.frames[1].document.forms[0].referred_for_ip.value="";
				  parent.frames[1].document.forms[0].referred_for_ip.disabled=true;

			}  
			parent.frames[1].document.forms[0].refforipimg.style.visibility="hidden";
			if(parent.frames[1].document.forms[0].referred_for_ip.disabled == false && parent.frames[1].document.forms[0].p_calling_function.value != 'IP_ADMIT' && parent.frames[1].document.forms[0].p_calling_function.value != 'IP_BOOKING')
			{
				parent.frames[1].document.forms[0].referred_for_ip.value="";
			}
			
		}
		else if(obj.value == "Y")
		{			
			 parent.frames[1].document.forms[0].referred_for_ip.disabled=true;
			if( parent.frames[1].document.forms[0].referred_for_ip.disabled == true)
			{
					  parent.frames[1].document.forms[0].referred_for_ip.disabled= false;
				  parent.frames[1].document.forms[0].referred_for_ip.value="";
				  parent.frames[1].document.forms[0].referred_for_ip.disabled=true;

			}
			parent.frames[1].document.forms[0].refforipimg.style.visibility="hidden";
		}
		else if (obj.value == "W")
		{
			 parent.frames[1].document.forms[0].referred_for_ip.disabled=true;
			 parent.frames[1].document.forms[0].referred_for_ip.value="";


		}
		else
		{
			if(parent.frames[1].document.forms[0].p_calling_function.value != 'IP_ADMIT' && parent.frames[1].document.forms[0].p_calling_function.value != 'IP_BOOKING')
			{
				parent.frames[1].document.forms[0].referred_for_ip.disabled=false;
				parent.frames[1].document.forms[0].refforipimg.style.visibility="visible";

			}
		}
		*/
	   
	  // delete_values1(parent.frames[1].document.forms[0].to_service_code);

		 if(loc_type=='C' || loc_type=='N' ||  loc_type=='Y' || loc_type=='E' || loc_type=='W')
		 {
			var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/RegPatReferralValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='10'><input type='hidden' name='objval' id='objval' value='"+obj.name+"'><input name='speciality' id='speciality' type='hidden' value='"+speciality + "'><input name='referral_source' id='referral_source' type='hidden' value='"+referral_source + "'><input name='loc_type' id='loc_type' type='hidden' value='"+loc_type + "'><input name='ref_type' id='ref_type' type='hidden' value='"+ref_type + "'><input name='pcallfunc' id='pcallfunc' type='hidden' value='"+pcallfunc+ "'></form></BODY></HTML>";
			
			//parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			//parent.parent.messageFrame.document.form1.submit();
			//Thursday, December 24, 2009 17511
			//top.content.messageFrame.document.write(HTMLVal);
			//top.content.messageFrame.document.form1.submit();	
			parent.parent.messageFrame.document.write(HTMLVal);
		    parent.parent.messageFrame.document.form1.submit();
		}
	}
}

function getval3(obj)
{	
		parent.frames[1].document.forms[0].referral_source.value="";
		parent.frames[1].document.forms[0].referral_source.disabled=false;
		parent.frames[1].document.forms[0].referral_source_lkp_bkup_text.value="";

		parent.frames[1].document.forms[0].referral_source_lkp_but.disabled=false;
		parent.frames[1].document.forms[0].referral_source_lkp_id.value="";

		parent.frames[1].document.getElementById('lng_name').style.visibility="hidden";
		
		parent.frames[1].document.getElementById('from_practitioner').value="";
		parent.frames[1].document.getElementById('from_practitioner_id').value="";


	var ref_type=parent.frames[1].document.forms[0].referral_type.value;
	var hcareType=parent.frames[1].document.forms[0].hcare_type.value;
		location0_array = new Array () ;
		delete_values1(parent.frames[1].document.getElementById('speciality'));
		//delete_values1(parent.frames[1].document.getElementById('referral_source'));
		if(obj.name=='referral_type'){
			parent.frames[1].document.forms[0].hcare_type.options[0].selected=true;
			//parent.frames[1].document.forms[0].referral_source.options(0).selected=true;
			parent.frames[1].document.getElementById("hcare_type").disabled=false;
		}
         var selectt="---------"+getLabel("Common.defaultSelect.label","Common")+"---------";
		if (ref_type=="")
		{
			if(parent.frames[1].document.getElementById('E_location')){
				parent.frames[1].document.getElementById('E_location').innerHTML="<select name=location0 id=location0 onchange='clear_location(this)'><option value=''>"+selectt+"</option>             </select>&nbsp";
			}
			if(parent.frames[1].document.getElementById('Enew_location')){
				parent.frames[1].document.getElementById('Enew_location').innerHTML="<select name='from_locn' id='from_locn' Onchange='clear_pract(this)'><option value=''>"+selectt+"</option></select>";
			}
			if(parent.frames[1].document.getElementById('E_locationtype')){
				parent.frames[1].document.getElementById('E_locationtype').innerHTML=getLabel('Common.locationtype.label','common');	
			}
			if(parent.frames[1].document.getElementById('enew_location1')){
				parent.frames[1].document.getElementById('enew_location1').innerHTML=getLabel('Common.Location.label','common');	
			}
		    parent.frames[1].document.forms[0].speciality.disabled=false;
		    parent.frames[1].document.forms[0].referral_source.disabled=false;
			parent.frames[1].document.getElementById('b_pract').disabled=false;
		    parent.frames[1].document.getElementById('from_practitioner_id').disabled=false;
			parent.frames[1].document.getElementById('bpract').style.visibility='visible';

		}	
			
			if(ref_type == 'X' || ref_type == 'E' ||ref_type == 'L') {				
				parent.frames[1].document.forms[0].tel_no.value="";
				parent.frames[1].document.forms[0].mobile_no.value="";
				parent.frames[1].document.forms[0].pager_no.value="";
				if(ref_type=="X"){
					parent.frames[1].document.forms[0].tel_no.readOnly=false;
					parent.frames[1].document.forms[0].mobile_no.readOnly=false;
					parent.frames[1].document.forms[0].pager_no.readOnly=false;
					parent.frames[1].document.getElementById('hcare_type').disabled=false;
					parent.frames[1].document.getElementById('speciality').disabled=true;
					if(parent.frames[1].document.getElementById('E_location')){ 
						parent.frames[1].document.getElementById('E_location').innerHTML="<input type='text' name='from_locn' id='from_locn' size=30 maxlength=30 onBlur = 'makeValidString(this)' tabIndex='11'>";					 
					}
					if(parent.frames[1].document.getElementById('Enew_location')){
						parent.frames[1].document.getElementById('Enew_location').innerHTML="";
					}
					if(parent.frames[1].document.getElementById('enew_location1')){
						parent.frames[1].document.getElementById('enew_location1').innerHTML="";
					}
					 
					if(parent.frames[1].document.getElementById('E_locationtype')){
						parent.frames[1].document.getElementById('E_locationtype').innerHTML="";
					}
					if(parent.frames[1].document.getElementById('E_locationtype')){
						parent.frames[1].document.getElementById('E_locationtype').innerHTML=getLabel('Common.Location.label','common');	
					}
					
					parent.frames[1].document.getElementById('b_pract').disabled=false;
					parent.frames[1].document.getElementById('from_practitioner_id').disabled=false;
					parent.frames[1].document.getElementById('from_practitioner').value="";
					parent.frames[1].document.getElementById('from_practitioner_id').value=""; 
					parent.frames[1].document.getElementById('from_ext_practitioner_id').value=""; 
					parent.frames[1].document.getElementById('from_ext_practitioner_id').disabled=false; 
						//parent.frames[1].document.getElementById('bpract').style.visibility='hidden'; //May 05
				}else if(ref_type=="E" || ref_type == "L") {
					parent.frames[1].document.forms[0].tel_no.readOnly=true;
					parent.frames[1].document.forms[0].mobile_no.readOnly=true;
					parent.frames[1].document.forms[0].pager_no.readOnly=true;
					if(ref_type=="E") {
						parent.frames[1].document.forms[0].hcare_type.disabled=false;
						parent.frames[1].document.getElementById('b_pract').disabled=true;
						parent.frames[1].document.getElementById('from_practitioner_id').disabled=true;
						parent.frames[1].document.getElementById('speciality').disabled=true;
					}else{
						parent.frames[1].document.getElementById('speciality').disabled=false;
						parent.frames[1].document.forms[0].hcare_type.disabled=true;
						parent.frames[1].document.getElementById('b_pract').disabled=false;
					}
					if(parent.frames[1].document.getElementById('E_locationtype')){
						parent.frames[1].document.getElementById('E_locationtype').innerHTML=getLabel('Common.locationtype.label','common');	
					}
					parent.frames[1].document.getElementById('E_location').innerHTML="<select name=location0 id=location0 onchange='clear_location(this)' disabled><option value=''>"+selectt+"</option>             </select>&nbsp;"   //Added 'disabled' for incident IN023039 by Suresh M on 24.08.2010 
					if(parent.frames[1].document.getElementById('Enew_location')){
						parent.frames[1].document.getElementById('Enew_location').innerHTML="<select name='from_locn' id='from_locn' Onchange='clear_pract(this)' disabled><option value=''>"+selectt+"</option></select>"; //Added 'disabled' for incident IN023039 by Suresh M on 24.08.2010 
					}
					if(parent.frames[1].document.getElementById('enew_location1')){
						parent.frames[1].document.getElementById('enew_location1').innerHTML=getLabel('Common.Location.label','common');
					}					
					parent.frames[1].document.getElementById('from_practitioner').value="";
					parent.frames[1].document.getElementById('from_practitioner_id').value="";
					parent.frames[1].document.getElementById('b_pract').style.visibility='visible';
				}
				var hcare_type="";
				if(ref_type=="E" || ref_type == "X")	{
					parent.frames[1].document.forms[0].hcare_type.disabled=false;
					parent.frames[1].document.forms[0].referral_source.disabled=false;
					hcare_type=parent.frames[1].document.forms[0].hcare_type.value;
				}
				HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/RegPatReferralValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='9'><input name='ref_type' id='ref_type' type='hidden' value='"+ref_type + "'><input name='hcare_type' id='hcare_type' type='hidden' value='"+hcare_type + "'></form></BODY></HTML>";
				
				/*Modified by Dharma on 11th Feb 2016 against ML-MMOH-CRF-0340 [IN057178] Start*/	
				/*parent.parent.messageFrame.document.write(HTMLVal);
				parent.parent.messageFrame.document.form1.submit();*/
				parent.parent.frames[3].document.write(HTMLVal);
				parent.parent.frames[3].document.form1.submit();
				/*Modified by Dharma on 11th Feb 2016 against ML-MMOH-CRF-0340 [IN057178] End*/
			}
			if(ref_type=="X")
				parent.frames[1].document.forms[0].from_ext_practitioner_id.style.display='inline';
			else
			    parent.frames[1].document.forms[0].from_ext_practitioner_id.style.display='none';

		

		 }


/*****************************************************/
function delete_values1(field)
{
		var selectt="---------"+getLabel("Common.defaultSelect.label","Common")+"---------";
		var selected = field;
		while ( selected.options.length > 0 )
					selected.remove(selected.options[0]);
		var opt=parent.frames[1].document.createElement("Option");
		opt.text=selectt;
		opt.value="";
		field.add(opt);
}


/*******************************************************/
async function getPract(target,target_id)
	{
	var retVal = 	new String();
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var dispDescFirst="dispDescFirst";
	var tit="";					
	var u1  = parent.frames[1].document.forms[0].referral_source_lkp_id.value;
	var u   = parent.frames[1].document.forms[0].from_locn.value;	
	var locn_type = parent.frames[1].document.forms[0].location0.value;	
	strArray = u.split("$");
	var open_to_all_pract_yn=strArray[0];
	var clinic_code=strArray[1];
	strArray = u1.split("~");
	var facilityid=strArray[1];	
	tit=getLabel("Common.practitioner.label","Common")
	if (clinic_code!=null){
	  locale=document.forms[0].locale.value;
	  if (locn_type=="C")
	  {
		if( open_to_all_pract_yn=="Y")
		{
				sql="Select a.practitioner_id, am_get_desc.am_practitioner(a.PRACTITIONER_ID,'"+locale+"',1) PRACTITIONER_NAME  from am_pract_for_facility a, "+
			" am_practitioner b , op_clinic c  where b.practitioner_id = a.practitioner_id  "+
			" and a.eff_status = `E` and a.facility_id = `"+facilityid+"`"+
			" and c.facility_id = a.facility_id and c.clinic_code = `"+clinic_code+"`  "+
			" and (c.speciality_code = b.primary_speciality_code or c.speciality_code in  "+
			" (select speciality_code from am_pract_specialities where facility_id = `"+facilityid+"` and  "+
			" practitioner_id = b.practitioner_id ))  "+
			" and nvl(c.pract_type, b.pract_type) = b.pract_type";
			search_code="a.practitioner_id";
			search_desc= "b.PRACTITIONER_NAME"
		}
		else
		{
			sql = " select practitioner_id,am_get_desc.am_practitioner(PRACTITIONER_ID,'"+locale+"',1) practitioner_full_name from " ;
			sql += "op_pract_for_clinic_vw where facility_id = `"+facilityid+"` and clinic_code = `"+clinic_code+"` and " ;
			sql += "eff_status=`E`";
			search_code="practitioner_id";
			search_desc= "practitioner_full_name"
		}
	  }
	  else
		{
           sql = "Select practitioner_id,am_get_desc.am_practitioner(PRACTITIONER_ID,'"+locale+"',1) practitioner_name from am_practitioner where practitioner_id in (Select practitioner_id from ip_nursing_unit_for_pract where facility_id = `"+facilityid+"` and nursing_unit_code = `"+clinic_code+"` and eff_status = `E` ) "
			search_code="practitioner_id";
			search_desc= "practitioner_name"
		}
		}
else
		{
			sql = " select practitioner_id,am_get_desc.am_practitioner(PRACTITIONER_ID,'"+locale+"',1) practitioner_name from " ;
			sql += "am_pract_for_facility_vw where operating_facility_id = `"+facilityid+"` and  eff_status=`E`";
			search_code="practitioner_id";
			search_desc= "practitioner_name"

		}
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst="+dispDescFirst,arguments,features);
		var arr=new Array();
		if(retVal !=null){

		if (!(unescape(retVal) == null))	
		{
			arr=unescape(retVal).split("::");
			target_id.value =arr[0];
			target.value    =arr[1];
		}
		else{
			target.focus();
			target_id.value ="";
			target.value    ="";
		}
		}
		else{
			target_id.value ="";
			target.value    ="";
		}

//function to populate practitioner tel ,mobile,pager

populate_pract_tel_mob_no(parent.frames[1].document.forms[0].from_practitioner);


}

/*******************/
function populate_pract_tel_mob_no(obj)
{

parent.frames[1].document.forms[0].tel_no.value="";
parent.frames[1].document.forms[0].mobile_no.value="";
parent.frames[1].document.forms[0].pager_no.value="";


var ref_type=parent.frames[1].document.forms[0].referral_type.value;
var from_pract_id= obj.value;

if(ref_type=='L' || ref_type=='E'){
	


	HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/RegPatReferralValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='12'><input name='from_pract_id' id='from_pract_id' type='hidden' value='"+from_pract_id + "'></form></BODY></HTML>";
	
	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.messageFrame.document.form1.submit();
	
}

}
/****************************************************************/


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
	

if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }
		if(f_query_add_mod.frames[1].document.getElementById('operation_type').value == 'RegisterMoreReferral')
		{
			for(var i=0; i<f_query_add_mod.frames[1].document.RegPatReferral_form.length; i++)
			{
				if(f_query_add_mod.frames[1].document.RegPatReferral_form.elements[i].disabled ==true)
				{
					if(f_query_add_mod.frames[1].document.RegPatReferral_form.elements[i].name != "referred_for_ip")
					{
					f_query_add_mod.document[1].document.RegPatReferral_form.elements[i].disabled =false;
					}
				}
			}
		}
		
		var fields=new Array ();
		var names = new Array ();

		var callfrom=f_query_add_mod.frames[1].document.getElementById('calling_from').value;
	   var arrnum = 0;

		/* Added for IN:046495 by Dharma on 20th Jan 2014 Start*/
		if(f_query_add_mod.frames[0].document.getElementById("alt_id1_reqd_yn").value == 'Y' && f_query_add_mod.frames[0].document.getElementById("alt_id1_man_non_ctz") && f_query_add_mod.frames[0].document.getElementById("alt_id1_man_non_ctz").value=="true" )	{
					if(f_query_add_mod.frames[0].document.getElementById("alt1_gif").style.visibility == 'visible') {
							fields[arrnum]=f_query_add_mod.frames[0].document.RegPatReferral_form.alt_id1_no;
							names[arrnum]=f_query_add_mod.frames[0].document.RegPatReferral_form.alt_id1_desc.value; 
							arrnum++;
					}		 
		}

		if(f_query_add_mod.frames[0].document.getElementById("alt_date1_reqd_yn").value == 'Y' && f_query_add_mod.frames[0].document.getElementById("alt_id1_man_non_ctz") && f_query_add_mod.frames[0].document.getElementById("alt_id1_man_non_ctz").value=="true" )	{
					if(f_query_add_mod.frames[0].document.getElementById("alt1_exp_date1").style.visibility == 'visible') {
							fields[arrnum]=f_query_add_mod.frames[0].document.RegPatReferral_form.alt_id1_exp_date;
							names[arrnum]=getLabel("Common.expiryDate.label","Common"); 
							arrnum++;
					}		 
		}
			
		/* Added for IN:046495 by Dharma on 20th Jan 2014 End*/



	if(f_query_add_mod.frames[0].document.getElementById("name_prefix_img")) {
		if( f_query_add_mod.frames[0].document.getElementById("name_prefix_img").style.visibility=='visible') 	   
		{
		   fields[arrnum]=f_query_add_mod.frames[0].document.RegPatReferral_form.name_prefix;
		   names[arrnum]=f_query_add_mod.frames[0].document.RegPatReferral_form.name_prefix_prompt.value; 
		   arrnum++;
	  }
	}
	if(f_query_add_mod.frames[0].document.RegPatReferral_form.name_prefix_reqd_yn !=null && f_query_add_mod.frames[0].document.RegPatReferral_form.name_prefix_reqd_yn.value =='Y' )
	   
	  {

	    if(f_query_add_mod.frames[0].document.RegPatReferral_form.name_prefix1 != null)
		  {
	
		   fields[arrnum]=f_query_add_mod.frames[0].document.RegPatReferral_form.name_prefix1;
		   names[arrnum]=f_query_add_mod.frames[0].document.RegPatReferral_form.name_prefix_prompt.value;
		 
		   arrnum++;
		  }
	 
	  }
	 var dflt_patient_name = f_query_add_mod.frames[0].document.RegPatReferral_form.dflt_patient_name.value;
	 if(f_query_add_mod.frames[0].document.RegPatReferral_form.first_name_reqd_yn !=null && f_query_add_mod.frames[0].document.RegPatReferral_form.first_name_reqd_yn.value =='Y' )
	  {
	  if(f_query_add_mod.frames[0].document.RegPatReferral_form.first_name != null)
	  {
		
	if(f_query_add_mod.frames[0].document.RegPatReferral_form.first_name.value == "")	f_query_add_mod.frames[0].document.RegPatReferral_form.first_name.value=dflt_patient_name;
		   fields[arrnum]=f_query_add_mod.frames[0].document.RegPatReferral_form.first_name;
		   names[arrnum]=f_query_add_mod.frames[0].document.RegPatReferral_form.first_name_prompt.value;
		   
		   
		   arrnum++;
		  }
	  }
	  if(f_query_add_mod.frames[0].document.RegPatReferral_form.second_name_reqd_yn !=null && f_query_add_mod.frames[0].document.RegPatReferral_form.second_name_reqd_yn.value =='Y' )
	  {
		  if( f_query_add_mod.frames[0].document.RegPatReferral_form.second_name != null)
		  {
		  
		 if(f_query_add_mod.frames[0].document.RegPatReferral_form.second_name.value == "") f_query_add_mod.frames[0].document.RegPatReferral_form.second_name.value=dflt_patient_name;

		   fields[arrnum]=f_query_add_mod.frames[0].document.RegPatReferral_form.second_name;
		   names[arrnum]=f_query_add_mod.frames[0].document.RegPatReferral_form.second_name_prompt.value;
		   
		   
		   arrnum++;
		  }
	  }
	  if(f_query_add_mod.frames[0].document.RegPatReferral_form.third_name_reqd_yn !=null && f_query_add_mod.frames[0].document.RegPatReferral_form.third_name_reqd_yn.value =='Y' )
	  {
		 if(f_query_add_mod.frames[0].document.RegPatReferral_form.third_name != null)
		  {
		  
		 if(f_query_add_mod.frames[0].document.RegPatReferral_form.third_name.value=="") f_query_add_mod.frames[0].document.RegPatReferral_form.third_name.value=dflt_patient_name;
		  fields[arrnum]=f_query_add_mod.frames[0].document.RegPatReferral_form.third_name;
		   names[arrnum]=f_query_add_mod.frames[0].document.RegPatReferral_form.third_name_prompt.value;
		   
			  
		   arrnum++;
		  }
	  }
	  if(f_query_add_mod.frames[0].document.RegPatReferral_form.family_name_reqd_yn !=null && f_query_add_mod.frames[0].document.RegPatReferral_form.family_name_reqd_yn.value =='Y' )
	  {
		  if(f_query_add_mod.frames[0].document.RegPatReferral_form.family_name != null )
		  {
		 if(f_query_add_mod.frames[0].document.RegPatReferral_form.family_name.value=="") f_query_add_mod.frames[0].document.RegPatReferral_form.family_name.value=dflt_patient_name;
		   fields[arrnum]=f_query_add_mod.frames[0].document.RegPatReferral_form.family_name;
		   names[arrnum]=f_query_add_mod.frames[0].document.RegPatReferral_form.family_name_prompt.value;
		   
		   
		   arrnum++;
		  }
	  }
	  if(f_query_add_mod.frames[0].document.RegPatReferral_form.name_suffix_reqd_yn !=null && f_query_add_mod.frames[0].document.RegPatReferral_form.name_suffix_reqd_yn.value =='Y' )
	  {
		  if(f_query_add_mod.frames[0].document.RegPatReferral_form.name_suffix1 != null )
		  {
		   fields[arrnum]=f_query_add_mod.frames[0].document.RegPatReferral_form.name_suffix1;
		   names[arrnum]=f_query_add_mod.frames[0].document.RegPatReferral_form.name_suffix_prompt.value;
		  

			arrnum++;
		  }
	  }

	//	patient_name
	
	/*	if(f_query_add_mod.frames[0].document.RegPatReferral_form.patient_name !=null && f_query_add_mod.frames[0].document.RegPatReferral_form.patient_name.value =="")
	  {
		
		fields[arrnum]=f_query_add_mod.frames[0].document.RegPatReferral_form.patient_name;
		names[arrnum]="Patient Name";
		
		arrnum++;
	  
	  }*/


		if(f_query_add_mod.frames[0].document.RegPatReferral_form.sex !=null && f_query_add_mod.frames[0].document.RegPatReferral_form.sex.value =="")
	  {
		fields[arrnum]=f_query_add_mod.frames[0].document.RegPatReferral_form.sex;
		names[arrnum]=getLabel("Common.gender.label","Common");
		
		arrnum++;
	  
	  }
		
		if(f_query_add_mod.frames[0].document.RegPatReferral_form.date_of_birth !=null && f_query_add_mod.frames[0].document.RegPatReferral_form.date_of_birth.value =="")
	  {
		fields[arrnum]=f_query_add_mod.frames[0].document.RegPatReferral_form.date_of_birth;
		//names[arrnum]="Birth Date";
		names[arrnum]=getLabel("Common.birthDate.label","Common");
	  
		arrnum++;
	  }

	  if(f_query_add_mod.frames[0].document.RegPatReferral_form.nationality_desc !=null &&
		  f_query_add_mod.frames[0].document.RegPatReferral_form.nationality_desc.value =="")
	  {
		fields[arrnum]=f_query_add_mod.frames[0].document.RegPatReferral_form.nationality_desc;
		//names[arrnum]="Nationality";
		names[arrnum]=getLabel("Common.nationality.label","Common");
		arrnum++;
	  }
	   f_query_add_mod.frames[1].document.RegPatReferral_form.race_code.value = f_query_add_mod.frames[0].document.RegPatReferral_form.race_code.value;
		if(f_query_add_mod.frames[0].document.getElementById("race_required_yn").value=="Y")
		{
			if(f_query_add_mod.frames[0].document.RegPatReferral_form.race_code !=null &&
			f_query_add_mod.frames[0].document.RegPatReferral_form.race_code.value =="")
			{
				fields[arrnum]=f_query_add_mod.frames[0].document.RegPatReferral_form.race_code;
				names[arrnum]=getLabel("Common.race.label","Common");		  
				arrnum++;
			}		
		}

	  if(f_query_add_mod.frames[1].document.RegPatReferral_form.referral_type !=null &&
		  f_query_add_mod.frames[1].document.RegPatReferral_form.referral_type.value =="")
	  {
		fields[arrnum]=f_query_add_mod.frames[1].document.RegPatReferral_form.referral_type;
		names[arrnum]=getLabel("Common.referraltype.label","Common");
	  arrnum++;
	  }	
		
	if(f_query_add_mod.frames[1].document.RegPatReferral_form.hcare_type !=null &&
		  f_query_add_mod.frames[1].document.RegPatReferral_form.hcare_type.value =="")
	  {
		
		
		
		fields[arrnum]=f_query_add_mod.frames[1].document.RegPatReferral_form.hcare_type;
		names[arrnum]=getLabel("Common.HealthcareSettingType.label","Common");
	  arrnum++;
	  }

	  if(f_query_add_mod.frames[1].document.RegPatReferral_form.referral_date !=null &&
		  f_query_add_mod.frames[1].document.RegPatReferral_form.referral_date.value =="")
	  {
		fields[arrnum]=f_query_add_mod.frames[1].document.RegPatReferral_form.referral_date;
		names[arrnum]=getLabel("Common.ReferredDate.label","Common");
	  arrnum++;
	  }

	  if(f_query_add_mod.frames[1].document.RegPatReferral_form && f_query_add_mod.frames[1].document.RegPatReferral_form.refforipimg){
	  if(f_query_add_mod.frames[1].document.RegPatReferral_form.refforipimg.style.visibility == 'visible' && f_query_add_mod.frames[1].document.RegPatReferral_form.referred_for_ip != null &&
		  f_query_add_mod.frames[1].document.RegPatReferral_form.referred_for_ip.value ==""){
		fields[arrnum]=f_query_add_mod.frames[1].document.RegPatReferral_form.referred_for_ip;
		names[arrnum]=getLabel("eMP.ReferredForIP.label","MP");
		arrnum++;
		}
	  }




		if(f_query_add_mod.frames[1].document.RegPatReferral_form.priority!=null &&
		  f_query_add_mod.frames[1].document.RegPatReferral_form.priority.value ==""){
		fields[arrnum]=f_query_add_mod.frames[1].document.RegPatReferral_form.priority;
		names[arrnum]=getLabel("Common.priority.label","Common");
		arrnum++;
		}
		
		if(f_query_add_mod.frames[1].document.RegPatReferral_form.received_date !=null &&
		  f_query_add_mod.frames[1].document.RegPatReferral_form.received_date.value =="")
	  {
		fields[arrnum]=f_query_add_mod.frames[1].document.RegPatReferral_form.received_date;
		names[arrnum]=getLabel("Common.ReceivedDate.label","Common");
		arrnum++;
	  }
		
	if(f_query_add_mod.frames[1].document.RegPatReferral_form.to_speciality_code !=null &&
		  f_query_add_mod.frames[1].document.RegPatReferral_form.to_speciality_code.value =="")
	  {	fields[arrnum]=f_query_add_mod.frames[1].document.RegPatReferral_form.to_speciality_code;
		names[arrnum]=getLabel("Common.ReferredTo.label","Common")+" "+getLabel("Common.speciality.label","Common");
	  arrnum++;
	  }

	  if(f_query_add_mod.frames[1].document.RegPatReferral_form.locationT0 !=null &&
		  f_query_add_mod.frames[1].document.RegPatReferral_form.locationT0.value =="")
	  {	fields[arrnum]=f_query_add_mod.frames[1].document.RegPatReferral_form.locationT0;
		//names[arrnum]="Referred To Location Type";
		names[arrnum]=getLabel("Common.ReferredTo.label","Common")+" "+getLabel("Common.locationtype.label","Common");
	  arrnum++;
	  }


		
	//commented by smita on 19/03/04 as the fields should be allowed to updated from OP
	// ---f_query_add_mod.document.RegPatReferral_form.ethnic_group.disabled=false;
	// ---f_query_add_mod.document.RegPatReferral_form.race_code.disabled=false;
			
			

		if(f_query_add_mod.frames[1].checkFields( fields, names, messageFrame))
		{

// this code is written for validating patient prefix and suffix with the gender.
			var pat_prefix=true;
			var pat_suffix=true;
	
			if (f_query_add_mod.frames[0].document.getElementById('name_prefix') != null ) 
			{
				if (f_query_add_mod.frames[0].document.getElementById('name_prefix').value.length != 0 ) 
				{
					if(f_query_add_mod.frames[0].document.getElementById('sex').value != '' )
					{	
						pat_prefix=checkPatSex(callfrom);
					}
				}
			}

			if (f_query_add_mod.frames[0].document.getElementById('name_suffix') != null ) 
			{
				if (f_query_add_mod.frames[0].document.getElementById('name_suffix').value.length != 0 ) 
				{
					if(f_query_add_mod.frames[0].document.getElementById('sex').value != '' )
					{	
						pat_suffix=checkPatSuffixSex(callfrom);
						
					}
				}
			}
			
			if(LocalErrors!=undefined)
			{
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+LocalErrors;
			}
			

		// the callobj variable was introduced by smita on 11/03/04 as the VARBODYFRAME variable was to be defined seperately depending on the calling_from mode
            
			if((enableNatId1(callfrom)) && (pat_prefix == true && pat_suffix==true))
			{	
				 if(callfrom == "SEARCH")
				{
					varBodyFrame = "window.frames[1].frames[0]";
					varsecFrame = "window.frames[1].frames[1]";

				}
				else
				{
					varBodyFrame = "f_query_add_mod.frames[0]";
					varsecFrame = "f_query_add_mod.frames[1]";
				}

				

				eval(varsecFrame).document.getElementById("addr_line1").value=eval(varBodyFrame).document.getElementById("addr_line1").value;			
				eval(varsecFrame).document.getElementById("addr_line2").value=eval(varBodyFrame).document.getElementById("addr_line2").value;
				eval(varsecFrame).document.getElementById("addr_line3").value=eval(varBodyFrame).document.getElementById("addr_line3").value;
				eval(varsecFrame).document.getElementById("addr_line4").value=eval(varBodyFrame).document.getElementById("addr_line4").value;
				eval(varsecFrame).document.getElementById("res_town_code").value=eval(varBodyFrame).document.getElementById("res_town_code").value;
				eval(varsecFrame).document.getElementById("res_area_code").value=eval(varBodyFrame).document.getElementById("res_area_code").value;
				
				eval(varsecFrame).document.getElementById("postal_code").value=eval(varBodyFrame).document.getElementById("postal_code").value;
				eval(varsecFrame).document.getElementById("region_code").value=eval(varBodyFrame).document.getElementById("region_code").value;
				eval(varsecFrame).document.getElementById("country_code").value=eval(varBodyFrame).document.getElementById("country_code").value;
				eval(varsecFrame).document.getElementById("mail_addr_line1").value=eval(varBodyFrame).document.getElementById("mail_addr_line1").value;
				eval(varsecFrame).document.getElementById("mail_addr_line2").value=eval(varBodyFrame).document.getElementById("mail_addr_line2").value;
				eval(varsecFrame).document.getElementById("mail_addr_line3").value=eval(varBodyFrame).document.getElementById("mail_addr_line3").value;
				eval(varsecFrame).document.getElementById("mail_addr_line4").value=eval(varBodyFrame).document.getElementById("mail_addr_line4").value;
				eval(varsecFrame).document.getElementById("mail_res_town_code").value=eval(varBodyFrame).document.getElementById("mail_res_town_code").value;
				eval(varsecFrame).document.getElementById("mail_res_area_code").value=eval(varBodyFrame).document.getElementById("mail_res_area_code").value;
				eval(varsecFrame).document.getElementById("mail_postal_code").value=eval(varBodyFrame).document.getElementById("mail_postal_code").value;

				/*Added by Thamizh selvi on 6th Feb 2018 against ML-MMOH-CRF-0601 Start*/
				eval(varsecFrame).document.getElementById("alt_addr_line1").value=eval(varBodyFrame).document.getElementById("alt_addr_line1").value;
				eval(varsecFrame).document.getElementById("alt_addr_line2").value=eval(varBodyFrame).document.getElementById("alt_addr_line2").value;
				eval(varsecFrame).document.getElementById("alt_addr_line3").value=eval(varBodyFrame).document.getElementById("alt_addr_line3").value;
				eval(varsecFrame).document.getElementById("alt_addr_line4").value=eval(varBodyFrame).document.getElementById("alt_addr_line4").value;
				eval(varsecFrame).document.getElementById("alt_town_code").value=eval(varBodyFrame).document.getElementById("alt_town_code").value;
				eval(varsecFrame).document.getElementById("alt_area_code").value=eval(varBodyFrame).document.getElementById("alt_area_code").value;
				eval(varsecFrame).document.getElementById("alt_region_code").value=eval(varBodyFrame).document.getElementById("alt_region_code").value;
				eval(varsecFrame).document.getElementById("alt_postal_code").value=eval(varBodyFrame).document.getElementById("alt_postal_code").value;
				eval(varsecFrame).document.getElementById("alt_country_code").value=eval(varBodyFrame).document.getElementById("alt_country_code").value;
				/*End*/
				 
				eval(varsecFrame).document.getElementById("mail_region_code").value=eval(varBodyFrame).document.getElementById("mail_region_code").value;
				eval(varsecFrame).document.getElementById("mail_country_code").value=eval(varBodyFrame).document.getElementById("mail_country_code").value;
				eval(varsecFrame).document.getElementById("contact1_no").value=eval(varBodyFrame).document.getElementById("contact1_no").value;
				eval(varsecFrame).document.getElementById("contact2_no").value=eval(varBodyFrame).document.getElementById("contact2_no").value;
				eval(varsecFrame).document.getElementById("email").value=eval(varBodyFrame).document.getElementById("email").value;
               f_query_add_mod.frames[1].document.RegPatReferral_form.to_service_code.disabled=false;
		       f_query_add_mod.frames[1].document.RegPatReferral_form.referred_for_ip.disabled=false;

			 
		       eval(varBodyFrame).document.getElementById("patient_name_local_lang").disabled=false;
		       
			  if(eval(varBodyFrame).document.getElementById("first_name_oth_lang") != null)
					{
									eval(varBodyFrame).document.getElementById("first_name_oth_lang").disabled=false;
					}

			  if(eval(varBodyFrame).document.getElementById("second_name_oth_lang") != null)
		      	eval(varBodyFrame).document.getElementById("second_name_oth_lang").disabled=false;
		      
			    if(eval(varBodyFrame).document.getElementById("third_name_oth_lang") != null) eval(varBodyFrame).document.getElementById("third_name_oth_lang").disabled=false;

				if(eval(varBodyFrame).document.getElementById("family_name_oth_lang") != null)
		       eval(varBodyFrame).document.getElementById("family_name_oth_lang").disabled=false;
		      
			   
			  if(eval(varBodyFrame).document.getElementById("name_prefix_oth_lang") != null) eval(varBodyFrame).document.getElementById("name_prefix_oth_lang").disabled=false;

				if(eval(varBodyFrame).document.getElementById("name_suffix_oth_lang") != null)
		       eval(varBodyFrame).document.getElementById("name_suffix_oth_lang").disabled=false; 	

				var refChk=true;

				var dob = convertDate(f_query_add_mod.frames[0].document.RegPatReferral_form.date_of_birth.value,"DMY",localeName,"en");
			
				var obj1=f_query_add_mod.frames[1].document.RegPatReferral_form.referral_date.value;
				var dateObj     =obj1.substring(0,10);
				
				var d_obj1 = convertDate(dateObj,"DMY",localeName,"en");
				
				if(dob!="")
			{	//Below localeName parameter is changed to en by Rameswar on 01-Oct-15 for Leap Year Issue
				if(!isBefore(dob,d_obj1,'DMY','en'))// DateUtils.js 
				{
				
					var msg =getMessage('DATE1_LT_DATE2','IP');
					msg	    =	msg.replace("$",getLabel("Common.ReferredDate.label","Common"));
					msg	    =	msg.replace("#",getLabel("Common.birthDate.label","Common"));
					alert(msg)
					f_query_add_mod.frames[1].document.RegPatReferral_form.referral_date.value="";
					f_query_add_mod.frames[1].document.RegPatReferral_form.referral_date.focus();
					f_query_add_mod.frames[1].document.RegPatReferral_form.referral_date.select();
					refChk=false;
				}
			}
				
				if(refChk) {

					//20854 code added

						var from_loc=f_query_add_mod.frames[1].document.RegPatReferral_form.from_locn.value;
						var to_loc=f_query_add_mod.frames[1].document.RegPatReferral_form.to_locn.value;

						
						if(from_loc!="")
					{
							var strArray = from_loc.split("$");
							f_query_add_mod.frames[1].document.RegPatReferral_form.from_locn_hid.value=strArray[0];
					}
					else
						f_query_add_mod.frames[1].document.RegPatReferral_form.from_locn_hid.value="";


					if(to_loc!="")
					{
							var stArry = to_loc.split("$");
							f_query_add_mod.frames[1].document.RegPatReferral_form.to_locn_hid.value=stArry[0];
					}
					else
						f_query_add_mod.frames[1].document.RegPatReferral_form.to_locn_hid.value="";

				f_query_add_mod.frames[1].document.RegPatReferral_form.action="../../servlet/eMP.RegPatReferralServlet";
				f_query_add_mod.frames[1].document.RegPatReferral_form.target="messageFrame";
				f_query_add_mod.frames[1].document.RegPatReferral_form.submit();


				}
					else
				{
					varBodyFrame = "f_query_add_mod.frames[0]";
					varsecFrame = "f_query_add_mod.frames[1]";
					
					
				}
			}
		}

}

var LocalErrors; 
function checkPatSex(callfrom)  {

	if(callfrom == "SEARCH")
	{
		varBodyFrame = "window.frames[1].frames[0]";
	}
	else
	{
		varBodyFrame = "f_query_add_mod.frames[0]";
	}


	LocalErrors = '';
    var arLength = eval(varBodyFrame+".NamePrefixArray.length");
    var q = 0;
    var res = new Boolean(false);
        while ( q <= arLength  )
        {
			if ( (eval(varBodyFrame).document.getElementById("name_prefix").value!='')  && ( unescape(eval(varBodyFrame+".NamePrefixArray[q]")) == eval(varBodyFrame).document.getElementById("name_prefix").value ))
            {
				if(eval(varBodyFrame+".PrefixSexArray[q]") != eval(varBodyFrame).document.getElementById("sex").value && eval(varBodyFrame+".PrefixSexArray[q] != 'B'"))
                {
					var msg = eval(varBodyFrame+".getMessage('PATIENT_SEX_MISMATCH','MP')");
					if(localeName=='en')
					{
					msg = msg.replace('$',eval(varBodyFrame).document.forms[0].name_prefix_prompt.value);
					}
					else
					{
					msg = msg.replace('$',eval(varBodyFrame).document.forms[0].name_prefix_oth_prompt.value);
					}
					LocalErrors = LocalErrors +msg	+ " <br>";
                res = false;
                }
                else
                    res = true;
            }
            q++;
        }
    return res;
}

function checkPatSuffixSex(callfrom)  {

	if(callfrom == "SEARCH")
	{
		varBodyFrame = "window.frames[1].frames[0]";
	}
	else
	{
		varBodyFrame = "f_query_add_mod.frames[0]";
	}

    var arLength = eval(varBodyFrame+".NameSuffixArray.length");
    var q = 0;
    var res = new Boolean(false);
        while ( q <= arLength  )
        {
			if ( (eval(varBodyFrame).document.getElementById("name_suffix").value!='')  && ( unescape(eval(varBodyFrame+".NameSuffixArray[q]")) == eval(varBodyFrame).document.getElementById("name_suffix").value)  )
            {
				if(eval(varBodyFrame+".SuffixSexArray[q]") != eval(varBodyFrame).document.getElementById("sex").value && eval(varBodyFrame+".SuffixSexArray[q]") != 'B')
                {
					var msg = eval(varBodyFrame+".getMessage('PATIENT_SEX_MISMATCH','MP')");
					if(localeName=='en')
					{
					msg = msg.replace('$',eval(varBodyFrame).document.forms[0].name_suffix_prompt.value);
					}
					else
					{
					msg = msg.replace('$',eval(varBodyFrame).document.forms[0].name_suffix_oth_prompt.value);
					}
					LocalErrors = LocalErrors +msg	+ " <br>";
                res = false;
                }
                else
                    res = true;
            }
            q++;
        }
    return res;
}

/***********************************/
function  enableNatId1(callobj)
{			
	// the callobj variable was introduced by smita on 11/03/04 as the VARBODYFRAME variable was to be defined seperately depending on the calling_from mode
	if(callobj == "SEARCH")
	{
		varBodyFrame = "window.frames[1].frames[0]";
		varsecFrame = "window.frames[1].frames[1]";

	}
	else
	{
		varBodyFrame = "window.frames[1].frames[0]";
		varsecFrame = "window.frames[1].frames[1]";
	}			

	

	if(eval(varsecFrame).document.getElementById("referral_source") != null)
	{
		eval(varsecFrame).document.getElementById("referral_source").disabled = false;
		eval(varsecFrame).document.getElementById("referral_source_lkp_but").disabled = false;
	}
	
	if(eval(varsecFrame).document.getElementById("referred_for_ip") != null)
	{
		eval(varsecFrame).document.getElementById("referred_for_ip").disabled = false;
	}
	if(eval(varsecFrame).document.getElementById("to_speciality_code") != null)
	{
		eval(varsecFrame).document.getElementById("to_speciality_code").disabled = false;
	}
	
	if(eval(varsecFrame).document.getElementById("to_locn") != null)
	{
		eval(varsecFrame).document.getElementById("to_locn").disabled = false;
	}
	if(eval(varsecFrame).document.getElementById("locationT0") != null)
	{
		eval(varsecFrame).document.getElementById("locationT0").disabled = false;
	}

	//if(eval(varsecFrame).document.getElementById("to_service_code") != null)
	//{
	//	eval(varsecFrame).document.getElementById("to_service_code").disabled = false;
	//}
	
	if(eval(varBodyFrame).document.getElementById("birth_place") != null)
	{
		eval(varBodyFrame).document.getElementById("birth_place").disabled = false;
		eval(varsecFrame).document.getElementById("birth_place").disabled = false;		
		eval(varsecFrame).document.getElementById("birth_place").value=eval(varBodyFrame).document.getElementById("birth_place").value;
		eval(varsecFrame).document.getElementById("Birth_place_code").value=eval(varBodyFrame).document.getElementById("Birth_place_code").value;
	}
	if(eval(varBodyFrame).document.getElementById("ethnic_group") != null)
	{
		eval(varBodyFrame).document.getElementById("ethnic_group").disabled = false;
		eval(varsecFrame).document.getElementById("ethnic_group").disabled = false;
		eval(varsecFrame).document.getElementById("ethnic_group").value=eval(varBodyFrame).document.getElementById("ethnic_group").value;
		eval(varsecFrame).document.getElementById("race_code1").value=eval(varBodyFrame).document.getElementById("ethnic_group").value;
	}

	if(eval(varBodyFrame).document.getElementById("place_of_birth") != null)
	{
		eval(varBodyFrame).document.getElementById("place_of_birth").disabled = false;
		eval(varsecFrame).document.getElementById("place_of_birth").disabled = false;
		eval(varsecFrame).document.getElementById("place_of_birth").value=eval(varBodyFrame).document.getElementById("place_of_birth").value;
		eval(varsecFrame).document.getElementById("Birth_place_code").value=eval(varBodyFrame).document.getElementById("Birth_place_code").value;
	}

	/*
	if(eval(varBodyFrame).document.getElementById("race_code_desc")) != null)
	{
		eval(varBodyFrame).document.getElementById("race_code_desc")).disabled = false;
		eval(varsecFrame).document.getElementById("race_code_desc")).disabled = false;
		eval(varsecFrame).document.getElementById("race_code_desc").value=eval(varBodyFrame).document.getElementById("race_code").value;
	}
	*/
	
	if(eval(varBodyFrame).document.getElementById("race_desc") != null)
	{   
		eval(varBodyFrame).document.getElementById("race_desc").disabled = false;
		eval(varBodyFrame).document.getElementById("race_desc_id").disabled = false;
		eval(varsecFrame).document.getElementById("race_code").value=eval(varBodyFrame).document.getElementById("race_code").value;
		//eval(varsecFrame).document.getElementById("race_desc").value=eval(varBodyFrame).document.getElementById("race_desc").value;
	}
	
	/*
	if(eval(varBodyFrame).document.getElementById("race_code")) != null)
	{ 
		eval(varsecFrame).document.getElementById("race_code").value=eval(varBodyFrame).document.getElementById("race_code").value;
	}
	*/

	if(eval(varBodyFrame).document.getElementById("patient_id") != null)
	{
		eval(varBodyFrame).document.getElementById("patient_id").disabled = false;
		eval(varsecFrame).document.getElementById("patient_id").disabled = false;
		eval(varsecFrame).document.getElementById("patient_id").value=eval(varBodyFrame).document.getElementById("patient_id").value;
	}
	
	  f_query_add_mod.frames[0].putPatientName(f_query_add_mod.frames[0].document.RegPatReferral_form.first_name);
	  f_query_add_mod.frames[0].putLocalLangPatientName();

	if(eval(varBodyFrame).document.getElementById("patient_name").value != "")
	{
	//	eval(varBodyFrame).document.getElementById("patient_name")).disabled = false;
	//	eval(varsecFrame).document.getElementById("patient_name")).disabled = false;
		eval(varsecFrame).document.getElementById("patient_name").value=eval(varBodyFrame).document.getElementById("patient_name").value;
	}
		
	if(eval(varsecFrame).document.getElementById("name_prefix1") != null && eval(varBodyFrame).document.getElementById("name_prefix") != null)
	{
		eval(varBodyFrame).document.getElementById("name_prefix").disabled = false;
		eval(varsecFrame).document.getElementById("name_prefix1").disabled = false;
		eval(varsecFrame).document.getElementById("name_prefix1").value=eval(varBodyFrame).document.getElementById("name_prefix").value;
	}
		if(eval(varBodyFrame).document.getElementById("first_name") != null)
		{
			eval(varBodyFrame).document.getElementById("first_name").disabled = false;
			eval(varsecFrame).document.getElementById("first_name").disabled = false;
			eval(varsecFrame).document.getElementById("first_name").value=eval(varBodyFrame).document.getElementById("first_name").value;

		}
		if(eval(varBodyFrame).document.getElementById("second_name") != null)
		{
			eval(varBodyFrame).document.getElementById("second_name").disabled = false;
			eval(varsecFrame).document.getElementById("second_name").disabled = false;
			eval(varsecFrame).document.getElementById("second_name").value=eval(varBodyFrame).document.getElementById("second_name").value;
		}
		
		if(eval(varBodyFrame).document.getElementById("third_name") != null)
		{
			eval(varBodyFrame).document.getElementById("third_name").disabled = false;
			eval(varsecFrame).document.getElementById("third_name").disabled = false;
			eval(varsecFrame).document.getElementById("third_name").value=eval(varBodyFrame).document.getElementById("third_name").value;
		}
		if(eval(varBodyFrame).document.getElementById("family_name") != null)
		{
			eval(varBodyFrame).document.getElementById("family_name").disabled = false;
			eval(varsecFrame).document.getElementById("family_name").disabled = false;
			eval(varsecFrame).document.getElementById("family_name").value=eval(varBodyFrame).document.getElementById("family_name").value;
		}
		
		if(eval(varBodyFrame).document.getElementById("name_suffix") != null)
		{
			eval(varBodyFrame).document.getElementById("name_suffix").disabled = false;
			eval(varsecFrame).document.getElementById("name_suffix1").disabled = false;
			eval(varsecFrame).document.getElementById("name_suffix1").value=eval(varBodyFrame).document.getElementById("name_suffix").value;
		}
		
		if(eval(varBodyFrame).document.getElementById("patient_name_local_lang").value != "")
	{
	//	eval(varBodyFrame).document.getElementById("patient_name")).disabled = false;
	//	eval(varsecFrame).document.getElementById("patient_name")).disabled = false;
		eval(varsecFrame).document.getElementById("patient_name_local_lang").value=eval(varBodyFrame).document.getElementById("patient_name_local_lang").value;
	}

	if(eval(varBodyFrame).document.getElementById("patient_name_long").value != "")
	{
		eval(varsecFrame).document.getElementById("patient_name_long").value=eval(varBodyFrame).document.getElementById("patient_name_long").value;
	}

	if(eval(varBodyFrame).document.getElementById("patient_name_loc_lang_long").value != "")
	{
		eval(varsecFrame).document.getElementById("patient_name_loc_lang_long").value=eval(varBodyFrame).document.getElementById("patient_name_loc_lang_long").value;
	}

	if(eval(varBodyFrame).document.getElementById("name_prefix_oth_lang") != null)
	{
		eval(varBodyFrame).document.getElementById("name_prefix_oth_lang").disabled = false;
		eval(varsecFrame).document.getElementById("name_prefix_oth_lang").disabled = false;
		eval(varsecFrame).document.getElementById("name_prefix_oth_lang").value=eval(varBodyFrame).document.getElementById("name_prefix_oth_lang").value;
	}

		if(eval(varBodyFrame).document.getElementById("first_name_oth_lang") != null)
		{
			eval(varBodyFrame).document.getElementById("first_name_oth_lang").disabled = false;
		
			eval(varsecFrame).document.getElementById("first_name_oth_lang").value=eval(varBodyFrame).document.getElementById("first_name_oth_lang").value;

		}

		if(eval(varBodyFrame).document.getElementById("second_name_oth_lang") != null)
		{
			eval(varBodyFrame).document.getElementById("second_name_oth_lang").disabled = false;
			eval(varsecFrame).document.getElementById("second_name_oth_lang").disabled = false;
			eval(varsecFrame).document.getElementById("second_name_oth_lang").value=eval(varBodyFrame).document.getElementById("second_name_oth_lang").value;
		}
		if(eval(varBodyFrame).document.getElementById("third_name_oth_lang") != null)
		{
			eval(varBodyFrame).document.getElementById("third_name_oth_lang").disabled = false;
			eval(varsecFrame).document.getElementById("third_name_oth_lang").disabled = false;
			eval(varsecFrame).document.getElementById("third_name_oth_lang").value=eval(varBodyFrame).document.getElementById("third_name_oth_lang").value;
		}
		if(eval(varBodyFrame).document.getElementById("family_name_oth_lang") != null)
		{
			eval(varBodyFrame).document.getElementById("family_name_oth_lang").disabled = false;
			eval(varsecFrame).document.getElementById("family_name_oth_lang").disabled = false;
			eval(varsecFrame).document.getElementById("family_name_oth_lang").value=eval(varBodyFrame).document.getElementById("family_name_oth_lang").value;
		}
		if(eval(varBodyFrame).document.getElementById("name_suffix_oth_lang") != null)
		{
			eval(varBodyFrame).document.getElementById("name_suffix_oth_lang").disabled = false;
			eval(varsecFrame).document.getElementById("name_suffix_oth_lang").disabled = false;
			eval(varsecFrame).document.getElementById("name_suffix_oth_lang").value=eval(varBodyFrame).document.getElementById("name_suffix_oth_lang").value;
		}



		if(eval(varBodyFrame).document.getElementById("sex") != null)
		{
			eval(varBodyFrame).document.getElementById("sex").disabled = false;
			eval(varsecFrame).document.getElementById("sex").disabled = false;
			eval(varsecFrame).document.getElementById("sex").value=eval(varBodyFrame).document.getElementById("sex").value;
		}
		if(eval(varBodyFrame).document.getElementById("date_of_birth") != null)
		{
			eval(varBodyFrame).document.getElementById("date_of_birth").disabled = false;
			eval(varsecFrame).document.getElementById("date_of_birth").disabled = false;
			eval(varsecFrame).document.getElementById("date_of_birth").value=eval(varBodyFrame).document.getElementById("date_of_birth").value;
		}
		if(eval(varBodyFrame).document.getElementById("b_age") != null)
		{
			eval(varBodyFrame).document.getElementById("b_age").disabled = false;
			eval(varsecFrame).document.getElementById("b_age").disabled = false;
			eval(varsecFrame).document.getElementById("b_age").value=eval(varBodyFrame).document.getElementById("b_age").value;
		}
		if(eval(varBodyFrame).document.getElementById("b_months") != null)
		{
			eval(varBodyFrame).document.getElementById("b_months").disabled = false;
			eval(varsecFrame).document.getElementById("b_months").disabled = false;
			eval(varsecFrame).document.getElementById("b_months").value=eval(varBodyFrame).document.getElementById("b_months").value;
		}
		if(eval(varBodyFrame).document.getElementById("b_days") != null)
		{
			eval(varBodyFrame).document.getElementById("b_days").disabled = false;
			eval(varsecFrame).document.getElementById("b_days").disabled = false;
			eval(varsecFrame).document.getElementById("b_days").value=eval(varBodyFrame).document.getElementById("b_days").value;
		}
		if(eval(varBodyFrame).document.getElementById("dob") != null)
		{
			eval(varBodyFrame).document.getElementById("dob").disabled = false;
			eval(varsecFrame).document.getElementById("dob").disabled = false;
			eval(varsecFrame).document.getElementById("dob").value=eval(varBodyFrame).document.getElementById("dob").value;
		}
		if(eval(varBodyFrame).document.getElementById("nationality_code1") != null)
		{
			eval(varBodyFrame).document.getElementById("nationality_code1").disabled = false
				eval(varsecFrame).document.getElementById("nationality_code1").disabled = false;
				eval(varsecFrame).document.getElementById("nationality_code1").value=eval(varBodyFrame).document.getElementById("nationality_code1").value;
		}
		
	
		
		if(eval(varBodyFrame).citizen_yn[0] != null)
		{
			
			eval(varBodyFrame).citizen_yn[0].disabled = false;				
			eval(varsecFrame).document.getElementById("citizen_yn0").value=eval(varBodyFrame).citizen_yn[0].value;
		   if(eval(varBodyFrame).citizen_yn[0].checked==true)
	{
			eval(varsecFrame).document.getElementById("citizenvalue").value=eval(varsecFrame).document.getElementById("citizen_yn0").value;
		}
	}
		
		if(eval(varBodyFrame).citizen_yn[1] != null)
		{
			eval(varBodyFrame).citizen_yn[1].disabled = false;			
			eval(varsecFrame).document.getElementById("citizen_yn1").value=eval(varBodyFrame).citizen_yn[1].value;	
		   if(eval(varBodyFrame).citizen_yn[1].checked==true)
	{
			eval(varsecFrame).document.getElementById("citizenvalue").value=eval(varsecFrame).document.getElementById("citizen_yn1").value
		
		}
	}
		if(eval(varBodyFrame).legal_yn[0] != null)
		{
			eval(varBodyFrame).legal_yn[0].disabled = false;
			//eval(varsecFrame).document.getElementById("legal_yn")[0].disabled = false;
			eval(varsecFrame).document.getElementById("legal_yn0").value=eval(varBodyFrame).legal_yn[0].value;
			if(eval(varBodyFrame).legal_yn[0].checked==true)
	      {
			eval(varsecFrame).document.getElementById("illegalvalue").value=eval(varsecFrame).document.getElementById("legal_yn0").value
		
		}
		}
		if(eval(varBodyFrame).legal_yn[1] != null)
		{
			eval(varBodyFrame).legal_yn[1].disabled = false;
			//eval(varsecFrame).document.getElementById("legal_yn")[1].disabled = false;
			eval(varsecFrame).document.getElementById("legal_yn1").value=eval(varBodyFrame).legal_yn[1].value;	
			if(eval(varBodyFrame).legal_yn[1].checked==true)
	      {
			eval(varsecFrame).document.getElementById("illegalvalue").value=eval(varsecFrame).document.getElementById("legal_yn1").value
		
		}
		}
		if(eval(varBodyFrame).document.getElementById("national_id_no") != null)
		{
			eval(varBodyFrame).document.getElementById("national_id_no").disabled = false;
			//eval(varsecFrame).document.getElementById("national_id_no").disabled = false;
			eval(varsecFrame).document.getElementById("national_id_no").value=eval(varBodyFrame).document.getElementById("national_id_no").value;	
			if(eval(varBodyFrame).document.getElementById("myKadBtn")){// for smart card
				eval(varBodyFrame).document.getElementById("myKadBtn").disabled = false;
			}	
		}
		if(eval(varBodyFrame).document.getElementById("alt_id1_no") != null)
		{
			eval(varBodyFrame).document.getElementById("alt_id1_no").disabled = false;
			//eval(varsecFrame).document.getElementById("alt_id1_no").disabled = false;
			eval(varsecFrame).document.getElementById("alt_id1_no").value=eval(varBodyFrame).document.getElementById("alt_id1_no").value;	
		}
		if(eval(varBodyFrame).document.getElementById("alt_id2_no") != null)
		{
			eval(varBodyFrame).document.getElementById("alt_id2_no").disabled = false;
			//eval(varsecFrame).document.getElementById("alt_id2_no").disabled = false;
			eval(varsecFrame).document.getElementById("alt_id2_no").value=eval(varBodyFrame).document.getElementById("alt_id2_no").value;	
		}
		if(eval(varBodyFrame).document.getElementById("alt_id3_no") != null)
		{
			eval(varBodyFrame).document.getElementById("alt_id3_no").disabled = false;
			//eval(varsecFrame).document.getElementById("alt_id3_no").disabled = false;
			eval(varsecFrame).document.getElementById("alt_id3_no").value=eval(varBodyFrame).document.getElementById("alt_id3_no").value;

		}
		if(eval(varBodyFrame).document.getElementById("alt_id4_no") != null)
		{
			eval(varBodyFrame).document.getElementById("alt_id4_no").disabled = false;	
			//eval(varsecFrame).document.getElementById("alt_id4_no").disabled = false;
			eval(varsecFrame).document.getElementById("alt_id4_no").value=eval(varBodyFrame).document.getElementById("alt_id4_no").value;
		}

		if(eval(varBodyFrame).document.getElementById("alt_id1_exp_date") != null)
		{
			eval(varBodyFrame).document.getElementById("alt_id1_exp_date").disabled = false;
			//eval(varsecFrame).document.getElementById("alt_id1_exp_date").disabled = false;
			eval(varsecFrame).document.getElementById("alt_id1_exp_date").value=eval(varBodyFrame).document.getElementById("alt_id1_exp_date").value;
			
		}
		
		if(eval(varBodyFrame).document.getElementById("alt_id2_exp_date") != null)
		{
			eval(varBodyFrame).document.getElementById("alt_id2_exp_date").disabled = false;
			//eval(varsecFrame).document.getElementById("alt_id2_exp_date").disabled = false;
			eval(varsecFrame).document.getElementById("alt_id2_exp_date").value=eval(varBodyFrame).document.getElementById("alt_id2_exp_date").value;
			
		}
		if(eval(varBodyFrame).document.getElementById("alt_id3_exp_date") != null)
		{
			eval(varBodyFrame).document.getElementById("alt_id3_exp_date").disabled = false;
			//eval(varsecFrame).document.getElementById("alt_id3_exp_date").disabled = false;
			eval(varsecFrame).document.getElementById("alt_id3_exp_date").value=eval(varBodyFrame).document.getElementById("alt_id3_exp_date").value;
			
		}
		if(eval(varBodyFrame).document.getElementById("alt_id4_exp_date") != null)
		{
			eval(varBodyFrame).document.getElementById("alt_id4_exp_date").disabled = false;
			//eval(varsecFrame).document.getElementById("alt_id4_exp_date").disabled = false;
			eval(varsecFrame).document.getElementById("alt_id4_exp_date").value=eval(varBodyFrame).document.getElementById("alt_id4_exp_date").value;		
			
		}


		if(eval(varBodyFrame).document.getElementById("other_alt_type") != null)
		{
			eval(varBodyFrame).document.getElementById("other_alt_type").disabled = false;
			//eval(varsecFrame).document.getElementById("other_alt_type")).disabled = false;
			eval(varsecFrame).document.getElementById("other_alt_type").value=eval(varBodyFrame).document.getElementById("other_alt_type").value;
			
		}
			if(eval(varBodyFrame).document.getElementById("other_alt_Id") != null)
		{
			eval(varBodyFrame).document.getElementById("other_alt_Id").disabled = false;
			//eval(varsecFrame).document.getElementById("other_alt_Id").disabled = false;
			eval(varsecFrame).document.getElementById("other_alt_Id").value=eval(varBodyFrame).document.getElementById("other_alt_Id").value;
			
		}
	return true;

}

/*****************************************/
function dummy(refid,locncode,locntype,calling_from,patientid,error,error_value) 
{ 

   if(parent.f_query_add_mod)
	parent.f_query_add_mod.location.href = '../eCommon/html/blank.html';

	if (error=="FROM_UPDATE_REFERRAL")
		var message =getMessage("REFERRAL_MODIFIED","Common") ;
	else
		var message =getMessage("REFERRAL_BOOKED","Common") ;

	message+="<b>"+refid+"</b>";

	var error_value = "0" ;
	
	if(parent.messageFrame)
		parent.messageFrame.location.href ="../eCommon/jsp/error.jsp?err_num=" + message + "&err_value="+error_value ;


	if(parent.f_query_add_mod)
		parent.f_query_add_mod.location.href = '../eMP/jsp/RegPatReferralMainPage.jsp';

		if (calling_from!="")
		{
			parent.window.returnValue=refid+"%"+error;
			parent.window.close();
		}

	if(error != "FROM_UPDATE_REFERRAL")
	{
		var truthBeTold = window.confirm(getMessage('CONTINUE_REFERRAL',"Common"));
		if(truthBeTold)
		{
			
			parent.f_query_add_mod.location.href = "../eMP/jsp/RegPatReferralMainPage.jsp?patientid="+patientid+"&referral_id="+refid+"&mode=RegisterMoreReferral" ;
		}
		else
		{
		   if(parent.f_query_add_mod)
				parent.f_query_add_mod.location.href = '../eCommon/html/blank.html';
		}

	}
}


function reset() 
{
	if (!(checkIsValidForProceed()))
    {
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }
	
	
	var bodyfram="";
	var mainfram="";
	
			
	if(window.frames[1].name != "f_query_add_mod")
	{
		bodyfram="window.frames[1].frames[1].frames[1]";
	}
	else
	{
		bodyfram="window.frames[1].frames[1]";
	}
	
		
	if(window.frames[1].name != "f_query_add_mod")
	{
		mainfram="window.frames[1].frames[1]";
	}
	else
	{
		mainfram="window.frames[1]";
	}

	
	var calling_from=eval(bodyfram).document.forms[0].calling_from.value;
	var p_calling_function=eval(bodyfram).document.forms[0].p_calling_function.value;
	var mode=eval(bodyfram).document.forms[0].operation_type.value;
	var referral_id=eval(bodyfram).document.forms[0].referral_id.value;
	var patientid=eval(bodyfram).document.forms[0].pat_id.value;

	if(calling_from == "SEARCH")
	{
		if(p_calling_function != "OP_REG_VISIT" || p_calling_function != "IP_BOOKING" || p_calling_function != "IP_ADMIT")
		{
		var speciality_code=eval(bodyfram).document.forms[0].to_speciality_code.value;
		var service_code=eval(bodyfram).document.forms[0].to_service_code.value;
		var practitioner=eval(bodyfram).document.forms[0].to_practitioner.value;
		var practitioner_name=eval(bodyfram).document.forms[0].to_practitioner_id.value;
		}else
		{
		var speciality_code="";
		var service_code="";
		var practitioner="";
		var practitioner_name="";
		}
	}	
	
	var p_to_locn_type=eval(bodyfram).document.forms[0].p_to_locn_type.value;
	var p_to_locn_code=eval(bodyfram).document.forms[0].p_to_locn_code.value;
    var ass_func_id=eval(bodyfram).document.forms[0].ass_func_id.value;
	eval(mainfram).document.location.href='../../eMP/jsp/RegPatReferralMainPage.jsp?calling_from='+calling_from+'&p_calling_function='+p_calling_function+'&mode='+mode+'&referral_id='+referral_id+'&speciality_code='+speciality_code+'&service_code='+service_code+'&practitioner='+practitioner+'&practitioner_name='+practitioner_name+'&patientid='+patientid+'&p_to_locn_type='+p_to_locn_type+'&p_to_locn_code='+p_to_locn_code+'&ass_func_id='+ass_func_id;

	enableNatId1(eval(bodyfram).document.RegPatReferral_form.calling_from.value);
	
}


/********************/
/*function callSearch(fromobj, toobj)
{
	var jsp_name ="../../eMP/jsp/SearchStdOtherName.jsp" ;

	if(fromobj.name == "family_name" || fromobj.name=="family_name_oth_lang")
		jsp_name ="../../eMP/jsp/SearchStdFamilyName.jsp" ;

		var retVal =    new String();
		var dialogHeight= "28" ;
		var dialogWidth = "43" ;
		var status = "no";
		var arguments   = "" ;
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = window.showModalDialog( jsp_name,arguments,features);

		if(retVal != null)
		{
			var arr = retVal.split("`");

			if( (fromobj.name).indexOf("oth_lang") == -1)
			{
				fromobj.value =arr[0]

				toobj =eval("document.forms[0]."+toobj)
				if(toobj !=null)
					toobj.value = arr[1]
			}
			else
			{
				toobj.value = arr[0]
				fromobj.value =arr[1]
			}
			fromobj.focus();
		}
}*/


/***********************/

var prev_set_objs = new Array() ;
/*function putPatientName()   {

    var logic = new String();
    logic = parent.f_query_add_mod.document.getElementById("name_drvn_logic").value;
    var derivedName = new String();
    derivedName = '';
    var logicElements = new Array();
    logicElements = logic.split('+');
    var i=0;

    for ( i=0;i<logicElements.length;i++)
    {
        if ( logicElements[i] == '1N' && parent.f_query_add_mod.document.getElementById("first_name") != null)
        {
            if ( parent.f_query_add_mod.document.getElementById("first_name").value != '' )
                derivedName = derivedName + parent.f_query_add_mod.document.getElementById("first_name").value;
        }
        else if ( logicElements[i] == '2N' && parent.f_query_add_mod.document.getElementById("second_name") != null )
        {
            if ( parent.f_query_add_mod.document.getElementById("second_name").value != '' )
                derivedName = derivedName + parent.f_query_add_mod.document.getElementById("second_name").value;
        }
        else if ( logicElements[i] == '3N' && parent.f_query_add_mod.document.getElementById("third_name") != null)
        {
            if ( parent.f_query_add_mod.document.getElementById("third_name").value != '' )
                derivedName = derivedName + parent.f_query_add_mod.document.getElementById("third_name").value;
        }
        else if ( logicElements[i] == 'FN' && parent.f_query_add_mod.document.getElementById("family_name") != null)
        {
            if ( parent.f_query_add_mod.document.getElementById("family_name").value != '' )
                derivedName = derivedName + parent.f_query_add_mod.document.getElementById("family_name").value;
        }
        else if ( logicElements[i] == 'PR' && parent.f_query_add_mod.document.getElementById("name_prefix") != null)
        {
            if ( parent.f_query_add_mod.document.getElementById("name_prefix").value != '' )
                derivedName = derivedName + parent.f_query_add_mod.document.getElementById("name_prefix").value;
        }
        else if ( logicElements[i] == 'SF' && parent.f_query_add_mod.document.getElementById("name_suffix") != null)
        {
            if ( parent.f_query_add_mod.document.getElementById("name_suffix").value != '' )
                derivedName = derivedName + parent.f_query_add_mod.document.getElementById("name_suffix").value;
        }
        else
        {
            if ( logicElements[i] != '1N' &&  logicElements[i] != '2N' && logicElements[i] != '3N' && logicElements[i] != 'FN' && logicElements[i] != 'PR' && logicElements[i] != 'SF' )
            {
                var arLen = logicElements[i].length;
                var tempVal = logicElements[i].substring(1,arLen - 1);
                derivedName = derivedName + tempVal;
            }
        }
    }
	if (parent.f_query_add_mod.document.getElementById("pat_name_as_multipart_yn").value=="Y")
	{
		if ( derivedName.length >= 40 )
			derivedName = derivedName.substr(0,40);			
	}
	else
	{
		if ( derivedName.length >= 60 )
			derivedName = derivedName.substr(0,60);
	}

    parent.f_query_add_mod.document.getElementById("patient_name").value = derivedName;
}// End of FUNCTION
*/
/***************/
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


function CheckForNumber_l(Objval) {
    val = Objval.value;

    if ( trimCheck(val) && isNaN(val) == false && val >=0)
        return true;
    else
	{
        if ( val.length > 0 ) {
            
            Objval.focus();
            return false;
        }
		else
			return true;
	}
}
/***************************/
function callPatientSearch()
{
	var patientid = PatientSearch('','','','','','','','','','PAT_REG');
	if(patientid !=null)
	{
		parent.f_query_add_mod.frames[0].document.getElementById("patient_id").value = patientid;
		validatePatientID(parent.f_query_add_mod.frames[0].document.getElementById("patient_id"));
	}
	else
	{
		enableClear()
	}
}

/****************************************************************/
function validateDates(obj,val)
{
var Rflag = "T";
var Pflag = "T";
var REflag = "T";
var myflag="Y"
var obj1=obj.value;

if(obj.value!="")
{
	

	var sysDate =parent.frames[1].document.forms[0].ServerDate11.value;	
	var sysDate_arr=sysDate.split(" ");
	sysDate=sysDate_arr[0];
	var sysDateTime=parent.frames[1].document.forms[0].ServerDatetime.value;
	var referralDate = parent.frames[1].document.getElementById("referral_date").value;
	var received_date = parent.frames[1].document.getElementById("received_date").value;
	
	var dob = convertDate(parent.frames[0].document.forms[0].date_of_birth.value,"DMY",localeName,"en");
	var dateObj     =obj1.substring(0,10);
	var d_obj1 = convertDate(dateObj,"DMY",localeName,"en");

	if(val == 'R' && Rflag =="T")
	{
		
		if (validDate(obj1,'DMYHM',localeName))
		{				
			//if(!self.ValidateDateTime(obj1,sysDateTime))
			
			if(dob!="")
			{	//Below localeName parameter is changed to en by Rameswar on 01-Oct-15 for Leap Year Issue
				if(!isBefore(dob,d_obj1,'DMY','en'))// DateUtils.js
				{
				
					var msg =getMessage('DATE1_LT_DATE2','IP');
					msg	    =	msg.replace("$",getLabel("Common.ReferredDate.label","Common"));
					msg	    =	msg.replace("#",getLabel("Common.birthDate.label","Common"));
					alert(msg)
					obj.value="";
					obj.focus();
					obj.select();
				}
			}
			if(!isBeforeNow(obj1,'DMYHM',localeName))
			{				
				alert(getMessage('REFL_DATE_CHECK',"Common"));
				obj.value="";
				obj.focus();
				obj.select();		
				
				Pflag ="F";
				REflag ="F";

			}

			if(obj.value != "" && trimString(received_date) != "" )
			{				
				if(!isBefore(obj1,received_date,'DMYHM',localeName))
				{					
					alert(getMessage('RECDDATE_REFLDATE_CHECK','Common'));
					Pflag ="F";
					Rflag ="F";
					myflag="N"
				
					obj.value="";
					obj.focus();					
				}
				else
				{
					Rflag ="T";
					Pflag ="T";
					REflag ="T";
				}

			}				
			else
			{
				Rflag ="T";
				Pflag ="T";
				REflag ="T";
			}

			if(Pflag=="F")
			{					
				obj.value="";
				obj.focus();
			}
		}
		else
		{
			var error = getMessage('INVALID_ALT_ID',"MP");
			error = error.replace('$',getLabel("Common.ReferredDate.label","Common"));
			alert(error);
			obj.focus();
			obj.value="";
		}	
		
	}
		else if(val == 'P' && Pflag =="T")
		{
			/*if(localeName != "en")
			{
			obj1=convertDate(obj1,"DMYHM",localeName,"en");
			}*/
		//	if(CheckDate(obj1))
			if(validDate(obj1,'DMY',localeName))
			{
				//if(referralDate != "" && referralDate.value != "")
				if(referralDate != "" )
				{
					if(isBefore(referralDate,obj1,'DMY',localeName))
					//if(!self.doDateCheckAlert(referralDate,obj1))
					{	
						alert(getMessage('PRF_DATE_CHECK',"Common"));
						Rflag ="F";
						REflag ="F";
						obj.focus();
						obj.select();
					}
				}
				if(dob!="")
				{	//Below localeName parameter is changed to en by Rameswar on 01-Oct-15 for Leap Year Issue
					if(!isBefore(dob,d_obj1,'DMY',"en")){
						var msg =getMessage('DATE1_LT_DATE2','IP');
						msg	    =	msg.replace("$",getLabel("Common.PreferredDate.label","Common"));
						msg	    =	msg.replace("#",getLabel("Common.birthDate.label","Common"));
						alert(msg)
						obj.value="";
						obj.focus();
						obj.select();
						return;
					}
				}
				//if(!self.doDateCheckAlert(sysDate,obj1))
				if(!isAfterNow(obj1,'DMY',localeName))
				{	
					
					alert(getMessage('PRF_DATE_NOT_GR_CURR_DATE','Common'));
					obj.focus();
					obj.select();
					Rflag ="F";
					REflag ="F";
				}
	           else
				{
				   
					Rflag ="T";
					Pflag ="T";
					REflag ="T";
				}
			}else
			{
				var error = getMessage('INVALID_ALT_ID',"MP");
				error = error.replace('$',getLabel("Common.PreferredDate.label","Common"));
				alert(error);
				obj.focus();
				obj.value="";
			}
			
		}
		else if(val == 'RE' && REflag =="T")
		{
//			if (doDateTimeChk(obj1))
			if (validDate(obj1,'DMYHM',localeName))
			{
//				if(!self.ValidateDateTime(obj1,sysDateTime))
				
				if(dob!="")
				{	//Below localeName parameter is changed to en by Rameswar on 01-Oct-15 for Leap Year Issue
					if(!isBefore(dob,d_obj1,'DMY',"en"))
					{
						var msg =getMessage('DATE1_LT_DATE2','IP');
						msg	    =	msg.replace("$",getLabel("Common.ReceivedDate.label","Common"));
						msg	    =	msg.replace("#",getLabel("Common.birthDate.label","Common"));
						alert(msg)
					
						obj.value="";
						obj.focus();
						obj.select();
					}
				}
				if(!isBeforeNow(obj1,'DMYHM',localeName))
				{				
					alert(getMessage('RECD_DATE_SYSDATE_CHECK','Common'));
					Pflag ="F";
					Rflag ="F";
					myflag="N";		
				
					obj.value="";
					obj.focus();
					obj.select();
					
				}
				else{
					Rflag ="T";
					Pflag ="T";
					REflag ="T";
				}

				// the below if condition added by smita unnikrishnan on 23/03/04 as the check for date comparison should only be done when there is a value in referral date.

				if(obj.value != "")
				{
					
				//if(referralDate != ""  && referralDate.value != "")
				if(trimString(referralDate) != "" )
				{

					/*alert("referralDate"+referralDate);
					alert("obj1"+obj1);*/
				//	if(!self.ValidateDateTime(referralDate,obj1))
					if(!isBefore(referralDate,obj1,'DMYHM',localeName))
					{					
						alert(getMessage('RECDDATE_REFLDATE_CHECK','Common'));
						Pflag ="F";
						Rflag ="F";
						myflag="N"
				
						obj.value="";
						obj.focus();					
					}
					else
					{
						Rflag ="T";
						Pflag ="T";
						REflag ="T";
					}

				}	
				}
			
				if(Pflag=="F" && myflag=="N")
				{				
					obj.value="";
					obj.focus();
				}

			}
			else
			{
				var error = getMessage('INVALID_ALT_ID',"MP");
				error = error.replace('$',getLabel("Common.ReceivedDate.label","Common"));
				alert(error);
				obj.focus();
				obj.value="";
			}	
		}
	
	
	

}

//}

}

/*******************************/

function validatePatientID(obj)
{
	enableClear();
 	if(obj.value != '')
	{
		var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/RegPatReferralValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='4'><input type='hidden' name='pat_id' id='pat_id' value='" +obj.value + "'></form></BODY></HTML>";
		
		parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.parent.messageFrame.document.form1.submit();
	}
}


/**********************************/
function disableItems()
{
	if(parent.frames[0].document.getElementById('name_prefix') != null)
		parent.frames[0].document.getElementById('name_prefix').disabled = true;

	if(parent.frames[0].document.getElementById('first_name') != null)
	{
		parent.frames[0].document.getElementById('first_name').readOnly = true;
		if(parent.frames[0].document.getElementById('b_first'))
		parent.frames[0].document.getElementById('b_first').disabled = true;
	}
	if(parent.frames[0].document.getElementById('second_name') != null)
	{
		parent.frames[0].document.getElementById('second_name').readOnly = true;
		if(parent.frames[0].document.getElementById('b_second'))
		parent.frames[0].document.getElementById('b_second').disabled = true;
	}
	if(parent.frames[0].document.getElementById('third_name') != null)
	{
		parent.frames[0].document.getElementById('third_name').readOnly = true;
		if(parent.frames[0].document.getElementById('b_third'))
		parent.frames[0].document.getElementById('b_third').disabled = true;
	}
	if(parent.frames[0].document.getElementById('family_name') != null)
	{
		parent.frames[0].document.getElementById('family_name').readOnly = true;
		if(parent.frames[0].document.getElementById('b_family'))
		parent.frames[0].document.getElementById('b_family').disabled = true;
	}
	if(parent.frames[0].document.getElementById('name_suffix') != null)
		parent.frames[0].document.getElementById('name_suffix').disabled = true;

	
	if(parent.frames[0].document.getElementById('name_prefix_oth_lang') != null)
		parent.frames[0].document.getElementById('name_prefix_oth_lang').disabled = true;

	if(parent.frames[0].document.getElementById('first_name_oth_lang') != null)
	{
		parent.frames[0].document.getElementById('first_name_oth_lang').readOnly = true;
	}
	if(parent.frames[0].document.getElementById('second_name_oth_lang') != null)
	{
		parent.frames[0].document.getElementById('second_name_oth_lang').readOnly = true;
	}
	if(parent.frames[0].document.getElementById('third_name_oth_lang') != null)
	{
		parent.frames[0].document.getElementById('third_name_oth_lang').readOnly = true;
	}
	if(parent.frames[0].document.getElementById('family_name_oth_lang') != null)
	{
		parent.frames[0].document.getElementById('family_name_oth_lang').readOnly = true;
	}
	if(parent.frames[0].document.getElementById('name_suffix_oth_lang') != null)
		parent.frames[0].document.getElementById('name_suffix_oth_lang').disabled = true;

	parent.frames[0].document.getElementById('sex').disabled = true;
	parent.frames[0].document.getElementById('date_of_birth').readOnly = true;
	parent.frames[0].document.getElementById('b_age').readOnly = true;
	parent.frames[0].document.getElementById('b_months').readOnly = true;
	parent.frames[0].document.getElementById('b_days').readOnly = true;
//	parent.frames[0].document.getElementById('patient_name').readOnly = true;
}


/**********************/
function enableClear()
{
	if(parent.f_query_add_mod.frames[0].document.getElementById("name_prefix") != null)
	{
		parent.f_query_add_mod.frames[0].document.getElementById("name_prefix").disabled = false;
		parent.f_query_add_mod.frames[0].document.getElementById("name_prefix").value = '';
	}
	if(parent.f_query_add_mod.frames[0].document.getElementById("first_name") != null)
	{
		parent.f_query_add_mod.frames[0].document.getElementById("first_name").readOnly = false;
		parent.f_query_add_mod.frames[0].document.getElementById("first_name").value = '';
		if(parent.f_query_add_mod.frames[0].document.getElementById("b_first"))	parent.f_query_add_mod.frames[0].document.getElementById("b_first").disabled = false
	}
	if(parent.f_query_add_mod.frames[0].document.getElementById("second_name") != null)
	{
		parent.f_query_add_mod.frames[0].document.getElementById("second_name").readOnly = false;
		parent.f_query_add_mod.frames[0].document.getElementById("second_name").value = '';
	if(parent.f_query_add_mod.frames[0].document.getElementById("b_second"))	parent.f_query_add_mod.frames[0].document.getElementById("b_second").disabled = false
	}
	if(parent.f_query_add_mod.frames[0].document.getElementById("third_name") != null)
	{
		parent.f_query_add_mod.frames[0].document.getElementById("third_name").readOnly = false;
		parent.f_query_add_mod.frames[0].document.getElementById("third_name").value = '';
		parent.f_query_add_mod.frames[0].document.getElementById("b_third").disabled = false
	}
	if(parent.f_query_add_mod.frames[0].document.getElementById("family_name") != null)
	{
		parent.f_query_add_mod.frames[0].document.getElementById("family_name").readOnly = false;
		parent.f_query_add_mod.frames[0].document.getElementById("family_name").value = '';
		parent.f_query_add_mod.frames[0].document.getElementById("b_family").disabled = false
	}
	if(parent.f_query_add_mod.frames[0].document.getElementById("name_suffix") != null)
	{
		parent.f_query_add_mod.frames[0].document.getElementById("name_suffix").disabled = false;
		parent.f_query_add_mod.frames[0].document.getElementById("name_suffix").value = '';
	}
	parent.f_query_add_mod.frames[0].document.getElementById("sex").disabled = false;
	parent.f_query_add_mod.frames[0].document.getElementById("sex").options[0].selected = true;
	parent.f_query_add_mod.frames[0].document.getElementById("nationality_code1").disabled = false;
	parent.f_query_add_mod.frames[0].document.getElementById("nationality_code1").options[0].selected = true;

	parent.f_query_add_mod.frames[0].document.getElementById("date_of_birth").readOnly = false;
	parent.f_query_add_mod.frames[0].document.getElementById("b_age").readOnly = false;
	parent.f_query_add_mod.frames[0].document.getElementById("b_months").readOnly = false;
	parent.f_query_add_mod.frames[0].document.getElementById("b_days").readOnly = false;

	parent.f_query_add_mod.frames[0].document.getElementById("patient_name").readOnly = true;

	parent.f_query_add_mod.frames[0].document.getElementById("date_of_birth").value = '';
	parent.f_query_add_mod.frames[0].document.getElementById("b_age").value = '';
	parent.f_query_add_mod.frames[0].document.getElementById("b_months").value = '';
	parent.f_query_add_mod.frames[0].document.getElementById("b_days").value = '';
	parent.f_query_add_mod.frames[0].document.getElementById("patient_name").value = '';
	parent.f_query_add_mod.frames[1].document.getElementById("referral_notes").value = '';
}

/******new function to call temp jsp with timeout*******/
function callHcare_Popext(obj){
	populate_ext_specialty(parent.frames[1].document.forms[0].referral_source_lkp_id);
}
/*****************************/
function populate_ext_specialty(obj)
{

	var ref_type=parent.frames[1].document.forms[0].referral_type.value;
	var ref_to= obj.value;
	var ref_hcare_arr=ref_to.split("~");
	var ref_to_code=ref_hcare_arr[1];
	var hcare_code=ref_hcare_arr[0];

	parent.frames[1].document.forms[0].from_fac_id.value=ref_to_code;
	
	
	if (ref_type!='X')
	{
		if (ref_type == 'E')
		{
			if (obj.value != '')
			{
			   parent.frames[1].document.getElementById('speciality').disabled=false;
			}
			else
			{
				parent.frames[1].document.getElementById('speciality').disabled=true;
				parent.frames[1].document.getElementById('bpract').disabled=true;
			}
		}

		parent.frames[1].document.getElementById('location0').value="";
		delete_values(parent.frames[1].document.getElementById("from_locn"))
		parent.frames[1].document.getElementById('from_practitioner').value="";
		parent.frames[1].document.getElementById('from_practitioner_id').value="";
		delete_values1(parent.frames[1].document.getElementById('speciality'));
	}
	else
	{	
		
		delete_values1(parent.frames[1].document.getElementById('speciality'));							
	}
/******/		




	HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='"+document.forms[0].contextURL.value+"/eMP/jsp/RegPatReferralValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='11'><input name='ref_type' id='ref_type' type='hidden' value='"+ref_type + "'><input name='hcare_code' id='hcare_code' type='hidden' value='"+hcare_code + "'><input name='ref_to_code' id='ref_to_code' type='hidden' value='"+ref_to_code + "'></form></BODY></HTML>";
	
//Added for incident IN023039 by Suresh M on 24.08.2010 
	if(parent.parent.messageFrame.document.body != null ){
				parent.parent.messageFrame.document.write(HTMLVal);
				parent.parent.messageFrame.document.form1.submit();
			}
// Ends IN023039
	
	
}
/************************************/
function setHcareDesc(obj)
{
	var arr = obj.value.split("~") ;
	if(arr[0]!="")
	parent.frames[1].document.getElementById('from_hcare_setting_type').value = arr[0];
	if(arr[1]!="")
	parent.frames[1].document.getElementById('referral_source1').value = arr[1];
	
	if (parent.frames[1].document.getElementById('referral_type').value!="X")
	{
	parent.frames[1].document.getElementById('location0').value="";
	delete_values(parent.frames[1].document.getElementById("from_locn"))
	parent.frames[1].document.getElementById('from_practitioner').value="";
	parent.frames[1].document.getElementById('from_practitioner_id').value="";

	}

		var ref_type=parent.frames[1].document.getElementById('referral_type').value;	
		var referral_source=arr[1];	

		
		if(ref_type=="X")
		{
		
		HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/RegPatReferralValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='14'><input name='referral_source' id='referral_source' type='hidden' value='"+referral_source+ "'></form></BODY></HTML>";
		
		parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.parent.messageFrame.document.form1.submit();
	


		}
}

/*******************/

function populatetolocn(obj)
{	
	

	var len = parent.frames[1].document.getElementById('to_practitioner').length;
	var practitioner = parent.frames[1].document.getElementById('practitioner').value;
	var service_code = parent.frames[1].document.getElementById('service_code').value;
	var ref_type=parent.frames[1].document.forms[0].referral_type.value;
parent.frames[1].document.getElementById('to_service_desc').value="";
parent.frames[1].document.getElementById('to_service_code').value="";

	var rd_operational_yn=parent.frames[1].document.forms[0].rd_operational_yn.value;

	if (practitioner==null)
	{
    practitioner ="";
	}
		parent.frames[1].document.getElementById('to_practitioner').value="";
		parent.frames[1].document.getElementById('to_practitioner_id').value=""
   if (obj.value=="")
	{
	parent.frames[1].document.getElementById('b_pract1').disabled=true;
	parent.frames[1].document.getElementById('to_practitioner_id').disabled=true;

	}
   else
	{
	parent.frames[1].document.getElementById('b_pract1').disabled=false;
	parent.frames[1].document.getElementById('to_practitioner_id').disabled=false;

	}

    len = parent.frames[1].document.getElementById('locationT0').length;
	for(var k=0;k<len;k++)
		parent.frames[1].document.getElementById('locationT0').remove(1);

	len = parent.frames[1].document.getElementById('to_locn').length;
	for(var k=0;k<len;k++)
		parent.frames[1].document.getElementById('to_locn').remove(1);

	if(parent.frames[1].document.forms[0].referred_for_ip) {
		parent.frames[1].document.forms[0].referred_for_ip.disabled=true;
		parent.frames[1].document.forms[0].referred_for_ip.value="";
	}

	if(parent.frames[1].document.forms[0].refforipimg)
		parent.frames[1].document.forms[0].refforipimg.style.visibility="hidden";
   
	var pcallfunc=parent.frames[1].document.forms[0].p_calling_function.value;
	var funid=parent.frames[1].document.forms[0].ass_func_id.value;
	if(obj.value != '')
	{
		var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form12' id='form12' method='post' action='../../eMP/jsp/RegPatReferralValidation.jsp'>"+
									"<input type='hidden' name='process_id' id='process_id' value='5'><input type='hidden' name='objval' value='"+obj.name+"'"+				
									"<input type='hidden' name='speciality_code' id='speciality_code' value='" +obj.value + "'><input name='ref_type' id='ref_type' type='hidden' value='"+ref_type + "'><input name='pcallfunc' id='pcallfunc' type='hidden' value='"+pcallfunc+ "'><input name='funid' id='funid' type='hidden' value='"+funid+ "'><input type='hidden' name='rd_operational_yn' id='rd_operational_yn' value='"+rd_operational_yn+"'>"+
									"</form></BODY></HTML>";
									
		parent.parent.messageFrame.document.write(HTMLVal);
		parent.parent.messageFrame.document.form12.submit();
	}
	
}

/*******************/
function clearLocationList(obj)
{ 		
	if (parent.frames[1].document.forms[0].referral_type.value!='X')
	{
		parent.frames[1].document.getElementById('location0').options[0].selected = true;
		delete_values1(parent.frames[1].document.forms[0].from_locn);
		if (obj.value != '')
		{	
			parent.frames[1].document.getElementById('from_practitioner').value="";
			parent.frames[1].document.getElementById('from_practitioner_id').value="";
	
			parent.frames[1].document.getElementById('b_pract').disabled=false;
			 parent.frames[1].document.getElementById('from_practitioner_id').disabled=false;
	//Added for incident IN023039 by Suresh M on 24.08.2010 // Ends IN023039
			if(parent.frames[1].document.getElementById('location0')){
				parent.frames[1].document.getElementById('location0').disabled = false;	
				if(parent.frames[1].document.getElementById('location0').value == "")
					parent.frames[1].document.getElementById("from_locn").disabled = true;
				}

		}
		else
		{
			parent.frames[1].document.getElementById('b_pract').disabled=true;
			//Added for incident IN023039 by Suresh M on 24.08.2010 // Ends IN023039
			if(parent.frames[1].document.getElementById('location0'))
				parent.frames[1].document.getElementById('location0').disabled = true;			
			if(parent.frames[1].document.getElementById("from_locn"))
				parent.frames[1].document.getElementById("from_locn").disabled = true;
			//Ends
			parent.frames[1].document.getElementById('from_practitioner_id').value="";
			parent.frames[1].document.getElementById('from_practitioner_id').disabled=true;
		}

	}
	if(parent.frames[1].document.forms[0].referral_type.value == 'X')
		{

		  // if(parent.frames[1].document.getElementById('operation_type').value!="modify")

			parent.frames[1].document.getElementById('from_practitioner').value="";
			parent.frames[1].document.getElementById('from_practitioner_id').value="";
			parent.frames[1].document.forms[0].from_ext_practitioner_id.disabled=false;
			parent.frames[1].document.getElementById('from_ext_practitioner_id').value="";
			parent.frames[1].document.forms[0].from_ext_practitioner_id.disabled=false;
			parent.frames[1].document.forms[0].from_practitioner_id.disabled=false;
			parent.frames[1].document.getElementById('bpract').disabled=false;

			if(parent.frames[1].document.forms[0].from_ext_practitioner_id.value!=''){
			parent.frames[1].document.forms[0].from_practitioner_id.disabled=true;
			parent.frames[1].document.getElementById('bpract').disabled=true;	
			}
	
			/*    parent.frames[1].document.forms[0].from_practitioner_id.disabled=false;
		        parent.frames[1].document.getElementById('bpract').disabled=false;
		        parent.frames[1].document.getElementById('pract_ext_name').disabled=false;
		       // parent.frames[1].document.from_ext_practitioner_id.disabled=false; */
			

        }


}

/*********************/
function populatePractitioner(obj)
{
	var len = parent.frames[1].document.getElementById('to_practitioner').length;
	for(var k=0;k<len;k++)
		parent.frames[1].document.getElementById('to_practitioner').remove(1);

	if(obj.value != '')
	{
		var locntype = parent.frames[1].document.getElementById('to_locn_type').value;
		var opentoallyn = obj.options[obj.options.selectedIndex].id;
		var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/RegPatReferralValidation.jsp'>"+
									"<input type='hidden' name='process_id' id='process_id' value='6'>"+
									"<input type='hidden' name='locn_code' id='locn_code' value='" +obj.value + "'>"+
									"<input type='hidden' name='locn_type' id='locn_type' value='" +locntype + "'>"+
									"<input type='hidden' name='open_to_all_yn' id='open_to_all_yn' value='" +opentoallyn + "'>"+
									"</form></BODY></HTML>";
									
		parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.parent.messageFrame.document.form1.submit();
	}
}

async function showModalText()
{
		var features    = "dialogHeight:160px; dialogWidth:400px; scroll=no; status:no";
		var text =  parent.f_query_add_mod.frames[1].document.forms[0].other_doc_att.value+"|"+parent.f_query_add_mod.frames[1].document.getElementById("referral_notes").value;
		var arguments = text;
		var retVal = await window.showModalDialog('../../eMP/jsp/Referral_Notes.jsp',arguments,features);
		if(retVal != null && retVal != 'C')
		{
			var valarr=retVal.split("|");

			parent.f_query_add_mod.frames[1].document.getElementById("referral_notes").value = valarr[1];
			parent.f_query_add_mod.frames[1].document.getElementById("other_doc_att").value = valarr[0];
		}
}

/*function checkAlternateIDs()
{
	var pat_id = parent.f_query_add_mod.frames[1].document.getElementById("patient_id").value;


	var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE'>";
		 HTMLVal = HTMLVal +"<form name='form1' id='form1' method='post' action='../../eMP/jsp/PatSearchCheckAltIDExpiryDate.jsp?function_id=PAT_REG&pat_id="+pat_id+"'>";
		 HTMLVal = HTMLVal +"</form></BODY></HTML>";
	
	parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.parent.messageFrame.document.form1.submit();

	return true;
}*/

async function showTextArea(fromLink,calling_from,mode)
{      
		var retarr;
		var dialogHeight= "400px" ;
        var dialogWidth = "700px" ;
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=no" ;
		var arguments	= escape(parent.frames[1].document.forms[0].other_doc_att.value)+"|"+escape(parent.frames[1].document.forms[0].referral_notes.value);
		var retVal = await window.showModalDialog("../../eMP/jsp/Referral_Notes.jsp?calling_from="+calling_from+"&ref_comp=reg_pat&mode="+mode,arguments,features);
		if(retVal != null)
		{
				retarr=retVal.split("|");
				parent.frames[1].document.forms[0].referral_notes.value=unescape(retarr[1]);
				parent.frames[1].document.forms[0].other_doc_att.value=unescape(retarr[0]);
		}
		

}

/*******************/
async function Modal_Clinical_Details(obj,calling_from,mode)
{

	if(obj.name=="clinical_details")
	{

		var retVal =    new String();
		var dialogHeight= "400px" ;
		var dialogWidth = "700px" ;
		var status = "no";
		
		
		var concat_vals=escape(parent.frames[1].document.forms[0].exm_clinical_find.value)+"&"+escape(parent.frames[1].document.forms[0].diagnosis.value)+"&"+escape(parent.frames[1].document.forms[0].treatment.value);	
		//var concat_vals=encodeURIComponent(parent.frames[1].document.forms[0].exm_clinical_find.value)+"&"+encodeURIComponent(parent.frames[1].document.forms[0].diagnosis.value)+"&"+encodeURIComponent(parent.frames[1].document.forms[0].treatment.value);	
		
			
		var arguments	=concat_vals;
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = await window.showModalDialog( "../../eMP/jsp/RegPatReferralClinicalDtls.jsp?calling_from="+calling_from+"&mode="+mode,arguments,features);

		if(retVal != null)
		{
			var arr = retVal.split("&"); 
			parent.frames[1].document.forms[0].exm_clinical_find.value=unescape(arr[0]);
			parent.frames[1].document.forms[0].diagnosis.value=unescape(arr[1]);
			parent.frames[1].document.forms[0].treatment.value=unescape(arr[2]);
		}


	
	
	}
}
/********************************************************/
function chg_pract(obj){
parent.frames[1].document.forms[0].from_practitioner.value=obj.value
}

/***************************************************************/
async function getPract1(target,target_id)
	{
	var retVal = 	new String();
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var dispDescFirst="dispDescFirst";
	var tit="";					
	var loginfacility     = parent.frames[1].document.forms[0].facilityid.value;	
	var speciality_code   = parent.frames[1].document.forms[0].to_speciality_code.value;	
	tit=getLabel('Common.practitioner.label','Common')
	locale=document.forms[0].locale.value; 
	sql = "select practitioner_id,practitioner_name from (Select a.practitioner_id practitioner_id, am_get_desc.am_practitioner(a.PRACTITIONER_ID,'"+locale+"',1) practitioner_name from am_pract_for_facility a,am_pract_specialities b, am_practitioner c where a.facility_id = b.facility_id and a.practitioner_id =  b.practitioner_id and b.practitioner_id = c.practitioner_id  and a.facility_id = `"+loginfacility+"` and b.speciality_code = `"+speciality_code+"` Union Select a.practitioner_id, am_get_desc.am_practitioner(a.PRACTITIONER_ID,'"+locale+"',1) practitioner_name from am_pract_for_facility a, am_practitioner c where a.practitioner_id = c.practitioner_id and a.facility_id =`"+loginfacility+"` AND c.PRIMARY_speciality_code = `"+speciality_code+"`) where 1 = 1 ";
		search_code= "practitioner_id";
		search_desc= "practitioner_name"
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst="+dispDescFirst,arguments,features);
		var arr=new Array();
		if(retVal !=null){

		if (!(unescape(retVal) == null))
		{
			arr=unescape(retVal).split("::");
			target_id.value =arr[0];
			target.value    =arr[1];
		}
		else{
			target_id.value ="";
			target.value    ="";
			target.focus();
			}
		}
		else{
			target_id.value ="";
			target.value    ="";
		}
}
/**********************************************************/
function clear_pract(obj)
{
 parent.frames[1].document.getElementById('to_service_desc').value="";
parent.frames[1].document.getElementById('to_service_code').value="";
	if(obj.name=="from_locn")
	{
		parent.frames[1].document.getElementById('from_practitioner').value="";
		parent.frames[1].document.getElementById('from_practitioner_id').value="";
	}
	else
	{
		
		parent.frames[1].document.getElementById('to_practitioner').value="";
		parent.frames[1].document.getElementById('to_practitioner_id').value="";

		 var speciality=parent.frames[1].document.forms[0].to_speciality_code.value;
		 var locn_code=parent.frames[1].document.forms[0].to_locn.value;
		 var locn_type=parent.frames[1].document.forms[0].locationT0.value;
		 
		 //delete_values1(parent.frames[1].document.forms[0].to_service_code);
		
		if(parent.frames[1].document.forms[0].or_operational_yn.value == "Y")
		{
		parent.frames[1].document.forms[0].order_catalog.value="";
		parent.frames[1].document.forms[0].order_catalog_desc.value="";

		 if(locn_type == "W")
		{
			 parent.frames[1].document.forms[0].catalog_but.disabled=false;
			 parent.frames[1].document.forms[0].order_catalog_desc.readOnly=false;
		}
		 else if(locn_type == "N" || locn_type == "")
		{
			parent.frames[1].document.forms[0].catalog_but.disabled=true;
			parent.frames[1].document.forms[0].order_catalog_desc.readOnly=true;
		}
		 else
		{
		 parent.frames[1].document.forms[0].catalog_but.disabled=false;
		 parent.frames[1].document.forms[0].order_catalog_desc.readOnly=false;
		}
		}

		/*var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='formsv' id='formsv' method='post' action='../../eMP/jsp/RegPatReferralValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='8'><input type='hidden' name='objval' id='objval' value='"+obj.name+"'><input name='speciality' id='speciality' type='hidden' value='"+speciality + "'><input name='loc_code' id='loc_code' type='hidden' value='"+locn_code + "'><input name='loc_type' id='loc_type' type='hidden' value='"+locn_type + "'></form></BODY></HTML>";
		parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.parent.messageFrame.document.formsv.submit();
		*/
	}

}
/***************************************/
async function getGeneralPractSearch(getFacilitID)
		{
		var msg="";
		var facility_id				=getFacilitID;

		var target			= parent.frames[1].document.forms[0].nursing_unit_desc;
		var retVal			=    new String();
			
		var dialogTop	= "78";
		var dialogHeight= "400px" ; 
		var dialogWidth	= "700px" ;	
		var dialogLeft	= "48" ;
		
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status=no;valign=center; dialogLeft: "+dialogLeft ;
			
			var arguments			= "" ;
			var sql				= "";
			var search_desc			= "";
			var tit				= getLabel("Common.nursingUnit.label","common")
	 locale=document.forms[0].locale.value;
		sql = "select A.nursing_unit_code, B.long_desc, count(A.bed_no) total_beds, sum(case when A.CURRENT_STATUS = 'A' then 1 else 0 end) available, sum(case when A.CURRENT_STATUS = 'O' then 1 else 0 end) Occupied from IP_NURSING_UNIT_BED A, IP_NURSING_UNIT_lang_vw B WHERE a.Facility_id = '"+getFacilitID+"' and A.Eff_status = 'E' and A.Facility_id = B.Facility_id and b.language_id='"+locale+"' and  A.nursing_unit_code = B.nursing_unit_code $ group by A.nursing_unit_code, B.Short_desc Order by 1,2";
		//sql = '';
		var search_code="nursing_unit_code";
		search_desc="long_desc";
		
		retVal=await window.showModalDialog("../../eAM/jsp/GeneralPractitionerSearch?sql="+escape(sql)+"&facility_id="+facility_id+"&search_code="+search_code+"&search_desc="+search_desc+"&nursing_unit_desc="+document.forms[0].nursing_unit_desc.value+"&title="+encodeURIComponent(tit),arguments,features);
	
		var arr=new Array();

		if (!(retVal == null))
		{

  			var retVal=unescape(retVal);
		    arr=retVal.split("~");

		    document.forms[0].nursing_unit_desc.value=arr[1];
			document.forms[0].nursing_unit.value=arr[0];
		    document.forms[0].nursing_unit_desc.focus();
		}
		else
		{
			target.focus();
		}
	}


function populateDetail(filedname, details, addresses)
{
    
	if (details == "DECEASED"|| details == "SUSPENDED"|| details == "INACTIVE")
		alert(details);
	else
	{
		
		var arr = new Array();
		arr = details.split("||");
		alert(details);
	   
		if(arr[0]=="NAT_ID_VALUES")
		{
			// Assign the values to the fields	
			parent.frames[0].document.forms[0].date_of_birth.value = arr[1];
			parent.frames[0].document.forms[0].b_age.value = arr[2];
			parent.frames[0].document.forms[0].b_months.value = arr[3];
			parent.frames[0].document.forms[0].b_days.value = arr[4];
			parent.frames[0].document.forms[0].sex.value = arr[5];
		}
		else
     	{	
			if(parent.frames[0].document.forms[0].patient_id)
			parent.frames[0].document.forms[0].patient_id.value = arr[0];
			
			if(parent.frames[0].document.forms[0].patient_name)
			parent.frames[0].document.forms[0].patient_name.value = arr[1];
			
			if(parent.frames[0].document.forms[0].national_id_no)
			parent.frames[0].document.forms[0].national_id_no.value = arr[2];
			
			if(parent.frames[0].document.forms[0].alt_id1_no)
			parent.frames[0].document.forms[0].alt_id1_no.value = arr[3];
			
			if(parent.frames[0].document.forms[0].alt_id2_no)
			parent.frames[0].document.forms[0].alt_id2_no.value = arr[4];
			
			if(parent.frames[0].document.forms[0].alt_id3_no)
			parent.frames[0].document.forms[0].alt_id3_no.value = arr[5];
		
			if(parent.frames[0].document.forms[0].alt_id4_no)
			parent.frames[0].document.forms[0].alt_id4_no.value = arr[6];
			
			if(parent.frames[0].document.forms[0].name_prefix)
			parent.frames[0].document.forms[0].name_prefix.value = arr[7];
			
			if(parent.frames[0].document.forms[0].first_name)
			parent.frames[0].document.forms[0].first_name.value = arr[8];

			if(parent.frames[0].document.forms[0].second_name)
			parent.frames[0].document.forms[0].second_name.value = arr[9];
			
			if(parent.frames[0].document.forms[0].third_name)
			parent.frames[0].document.forms[0].third_name.value = arr[10];

			if(parent.frames[0].document.forms[0].family_name)
			parent.frames[0].document.forms[0].family_name.value = arr[11];

			if(parent.frames[0].document.forms[0].name_suffix)
					parent.frames[0].document.forms[0].name_suffix.value = arr[12];

			if(parent.frames[0].document.forms[0].sex)
					parent.frames[0].document.forms[0].sex.value = arr[13];

			if(parent.frames[0].document.forms[0].date_of_birth)
					parent.frames[0].document.forms[0].date_of_birth.value = arr[14];

			if(parent.frames[0].document.forms[0].contact1_no)
					parent.frames[0].document.forms[0].contact1_no.value = arr[15];

			if(parent.frames[0].document.forms[0].contact2_no)
					parent.frames[0].document.forms[0].contact2_no.value = arr[16];

			if(parent.frames[0].document.forms[0].email_id)
					parent.frames[0].document.forms[0].email_id.value = arr[17];

			if(parent.frames[0].document.forms[0].nationality_code1)
					parent.frames[0].document.forms[0].nationality_code1.value = arr[18];


			if(parent.frames[0].document.forms[0].alt_id1_exp_date)
					parent.frames[0].document.forms[0].alt_id1_exp_date.value = arr[19];

			if(parent.frames[0].document.forms[0].alt_id2_exp_date)
					parent.frames[0].document.forms[0].alt_id2_exp_date.value = arr[20];

			if(parent.frames[0].document.forms[0].alt_id3_exp_date)
					parent.frames[0].document.forms[0].alt_id3_exp_date.value = arr[21];

			if(parent.frames[0].document.forms[0].alt_id4_exp_date)
					parent.frames[0].document.forms[0].alt_id4_exp_date.value = arr[22];

			if(parent.frames[0].document.forms[0].b_age)
					parent.frames[0].document.forms[0].b_age.value = arr[23];//age in years


			if(parent.frames[0].document.forms[0].b_months)
					parent.frames[0].document.forms[0].b_months.value = arr[24];//months


			if(parent.frames[0].document.forms[0].b_days)
					parent.frames[0].document.forms[0].b_days.value = arr[25];

			//populating the address in a hidden variable on the page
			parent.frames[0].document.forms[0].concat_address_hidden.value = addresses;
			parent.frames[0].document.forms[0].concat_NatIdDetails_hidden.value = details; 
		}
	}
}	

/**************************************************************/

function disable_Legal_If_Citzen(obj)
{
	if(obj.value=='Y')	
	{
		parent.frames[0].document.getElementById('citizen_yn')[1].checked=false;
		parent.frames[0].document.getElementById('citizen_yn')[0].checked=true;
		parent.frames[0].document.getElementById('legal_yn')[0].checked=true;
		parent.frames[0].document.getElementById('legal_yn')[0].disabled=true;
		parent.frames[0].document.getElementById('legal_yn')[1].disabled=true;
		parent.frames[0].document.getElementById('legal_yn')[0].value='Y';
		parent.frames[0].document.getElementById('legal_yn')[1].value='N';
	}
	else 
	{
		parent.frames[0].document.getElementById('citizen_yn')[0].checked=false;
		parent.frames[0].document.getElementById('citizen_yn')[1].checked=true;
		parent.frames[0].document.getElementById('legal_yn')[0].checked=true;
		parent.frames[0].document.getElementById('legal_yn')[0].disabled=false;
		parent.frames[0].document.getElementById('legal_yn')[1].disabled=false;
	}	
}

function ClearList(object)
{
	if (object)
		var length = object.length;

var selectt="---------"+getLabel("Common.defaultSelect.label","Common")+"---------";
	var element = f_query_add_mod.frames[1].document.RegPatReferral_form.document.createElement('OPTION');
    element.text= selectt;
    element.value="";
   
	for(i=1;i<length;i++)
		object.remove(1);
}

function  disableNatId()
{
	varBodyFrame = 'parent.frames[0]';

	if(eval(varBodyFrame).document.getElementById("birth_place") != null)
	{
		eval(varBodyFrame).document.getElementById("birth_place").disabled = true
	}

	if(eval(varBodyFrame).document.getElementById("ethnic_group") != null)
	{
		eval(varBodyFrame).document.getElementById("ethnic_group").disabled = true
	}

	if(eval(varBodyFrame).document.getElementById("place_of_birth") != null)
	{
		eval(varBodyFrame).document.getElementById("place_of_birth").disabled = true;
	}

	/*
	if(eval(varBodyFrame).document.getElementById("race_code") != null)
	{
		eval(varBodyFrame).document.getElementById("race_code").disabled = true;
	}
	*/
	
	if(eval(varBodyFrame).document.getElementById("race_desc") != null) {
		eval(varBodyFrame).document.getElementById("race_desc").disabled = true;
		eval(varBodyFrame).document.getElementById("race_desc_id").disabled = true;
	}
	

	if(eval(varBodyFrame).document.getElementById("b_birth") != null)
	{
		eval(varBodyFrame).document.getElementById("b_birth").disabled = true;
	}

	if(eval(varBodyFrame).document.getElementById("national_id_no") != null)
	{
		eval(varBodyFrame).document.getElementById("national_id_no").disabled = true
			if(eval(varBodyFrame).document.getElementById("myKadBtn")){ // for smart card
			eval(varBodyFrame).document.getElementById("myKadBtn").disabled = true;
		}	
	}

	if(eval(varBodyFrame).document.getElementById("patient_id") != null)
	{
		eval(varBodyFrame).document.getElementById("patient_id").disabled = true
	}

	if(eval(varBodyFrame).document.getElementById("patient_search") != null)
	{
		eval(varBodyFrame).document.getElementById("patient_search").disabled = true
	}

	if(eval(varBodyFrame).document.getElementById("search") != null)
	{
		eval(varBodyFrame).document.getElementById("search").disabled = true
	}

	if(eval(varBodyFrame).document.getElementById("name_prefix") != null)
	{
		eval(varBodyFrame).document.getElementById("name_prefix").disabled = true
	}
	if(eval(varBodyFrame).document.getElementById("first_name") != null)
	{
		eval(varBodyFrame).document.getElementById("first_name").disabled = true;
	}
	if(eval(varBodyFrame).document.getElementById("second_name") != null)
	{
		eval(varBodyFrame).document.getElementById("second_name").disabled = true
	}
	if(eval(varBodyFrame).document.getElementById("third_name") != null)
	{
		eval(varBodyFrame).document.getElementById("third_name").disabled = true;
	}
	if(eval(varBodyFrame).document.getElementById("family_name") != null)
	{
		eval(varBodyFrame).document.getElementById("family_name").disabled = true;
	}
	if(eval(varBodyFrame).document.getElementById("name_suffix") != null)
	{
		eval(varBodyFrame).document.getElementById("name_suffix").disabled = true;
	}


	if(eval(varBodyFrame).document.getElementById("name_prefix_oth_lang") != null)
	{
		eval(varBodyFrame).document.getElementById("name_prefix_oth_lang").disabled = true
	}
	if(eval(varBodyFrame).document.getElementById("first_name_oth_lang") != null)
	{
		eval(varBodyFrame).document.getElementById("first_name_oth_lang").disabled = true;
	}
	if(eval(varBodyFrame).document.getElementById("second_name_oth_lang") != null)
	{
		eval(varBodyFrame).document.getElementById("second_name_oth_lang").disabled = true
	}
	if(eval(varBodyFrame).document.getElementById("third_name_oth_lang") != null)
	{
		eval(varBodyFrame).document.getElementById("third_name_oth_lang").disabled = true;
	}
	if(eval(varBodyFrame).document.getElementById("family_name_oth_lang") != null)
	{
		eval(varBodyFrame).document.getElementById("family_name_oth_lang").disabled = true;
	}
	if(eval(varBodyFrame).document.getElementById("name_suffix_oth_lang") != null)
	{
		eval(varBodyFrame).document.getElementById("name_suffix_oth_lang").disabled = true;
	}	



	if(eval(varBodyFrame).document.getElementById("sex") != null)
	{
		eval(varBodyFrame).document.getElementById("sex").disabled = true;
	}
	if(eval(varBodyFrame).document.getElementById("date_of_birth") != null)
	{
		eval(varBodyFrame).document.getElementById("date_of_birth").disabled = true;
	}
	if(eval(varBodyFrame).document.getElementById("b_age") != null)
	{
		eval(varBodyFrame).document.getElementById("b_age").disabled = true;
	}
	if(eval(varBodyFrame).document.getElementById("b_months") != null)
	{
		eval(varBodyFrame).document.getElementById("b_months").disabled = true;
	}
	if(eval(varBodyFrame).document.getElementById("b_days") != null)
	{
		eval(varBodyFrame).document.getElementById("b_days").disabled = true;
	}
	if(eval(varBodyFrame).document.getElementById("dob") != null)
	{
		eval(varBodyFrame).document.getElementById("dob").disabled = true;
	}
	if(eval(varBodyFrame).document.getElementById("nationality_desc") != null)
	{
		eval(varBodyFrame).document.getElementById("nationality_desc").disabled = true
		eval(varBodyFrame).document.getElementById("nationality_id").disabled = true
	}
	if(eval(varBodyFrame).document.getElementById("citizen_yn")[0] != null)
	{
		eval(varBodyFrame).document.getElementById("citizen_yn")[0].disabled = true;		
	}
	if(eval(varBodyFrame).document.getElementById("citizen_yn")[1] != null)
	{
		eval(varBodyFrame).document.getElementById("citizen_yn")[1].disabled = true;					
	}
	if(eval(varBodyFrame).document.getElementById("legal_yn")[0] != null)
	{
		eval(varBodyFrame).document.getElementById("legal_yn")[0].disabled = true;		
	}
	if(eval(varBodyFrame).document.getElementById("legal_yn")[1] != null)
	{
		eval(varBodyFrame).document.getElementById("legal_yn")[1].disabled = true;					
	}
	if(eval(varBodyFrame).document.getElementById("national_id_no") != null)
	{
		eval(varBodyFrame).document.getElementById("national_id_no").disabled = true;
		if(eval(varBodyFrame).document.getElementById("myKadBtn")){ // for smart card
			eval(varBodyFrame).document.getElementById("myKadBtn").disabled = true;
		}	
	}
	if(eval(varBodyFrame).document.getElementById("alt_id1_no") != null)
	{
		eval(varBodyFrame).document.getElementById("alt_id1_no").disabled = true;
	}
	if(eval(varBodyFrame).document.getElementById("alt_id2_no") != null)
	{
		eval(varBodyFrame).document.getElementById("alt_id2_no").disabled = true;
	}
	if(eval(varBodyFrame).document.getElementById("alt_id3_no") != null)
	{
		eval(varBodyFrame).document.getElementById("alt_id3_no").disabled = true;
	}
	if(eval(varBodyFrame).document.getElementById("alt_id4_no") != null)
	{
		eval(varBodyFrame).document.getElementById("alt_id4_no").disabled = true;					
	}
	if(eval(varBodyFrame).document.getElementById("other_alt_type") != null)
	{
		eval(varBodyFrame).document.getElementById("other_alt_type").disabled = true;
	}
	return true;
}
		
function popEthnicSubGroup(ethnic_group_code,ethnic_group_desc)
{
	var opt=parent.frames[0].document.createElement("Option");
	opt.text=ethnic_group_desc;
	opt.value=ethnic_group_code;
	parent.frames[0].document.forms[0].ethnic_group.add(opt);
	parent.frames[0].document.forms[0].ethnic_group.options[1].selected=true;
	parent.frames[0].document.forms[0].ethnic_group.disabled=true;
}

/*************************************/

function popToLocationType(locType)
{
	var len=parent.frames[1].document.forms[0].locationT0.length;
	if(len == 2)
	{
		parent.frames[1].document.forms[0].locationT0.options[1].selected=true;
	}else if(len == 5)
	{
	if(locType =="C")
		parent.frames[1].document.forms[0].locationT0.options[1].selected=true;
	else if(locType =="Y")
		parent.frames[1].document.forms[0].locationT0.options[2].selected=true;
	else if(locType =="N")
		parent.frames[1].document.forms[0].locationT0.options[3].selected=true;
	else if(locType =="E")
		parent.frames[1].document.forms[0].locationT0.options[4].selected=true;
	}else
	{
	if(locType =="C")
		parent.frames[1].document.forms[0].locationT0.options[1].selected=true;
	else if(locType =="Y")
		parent.frames[1].document.forms[0].locationT0.options[2].selected=true;
	else if(locType =="N")
		parent.frames[1].document.forms[0].locationT0.options[3].selected=true;
	else if(locType =="E")
		parent.frames[1].document.forms[0].locationT0.options[4].selected=true;
    else if(locType =="W")
		parent.frames[1].document.forms[0].locationT0.options[5].selected=true;
	}
}

/************************************/

function popOth_alt_type(oth_alt_type,oth_alt_type_desc)
{

	parent.frames[0].document.forms[0].other_alt_type.disabled=false;
	parent.frames[0].document.forms[0].other_alt_type.value=oth_alt_type;	
	parent.frames[0].document.forms[0].other_alt_type.disabled=true;
}

/***********************************************************************************/

function getReasonForRefblur(obj)
{
	
	var oldValFlag = false;
	if(document.forms[0].reason_for_ref_hid.value != document.forms[0].referral_reason_desc.value)
	{
		oldValFlag = true;
	}
	if(oldValFlag)
	{
		if(document.forms[0].referral_reason_desc.value != "")
		{
			getReasonForRef(obj);
		}
	}

}
async function getReasonForRef(obj)
{
	//if(document.forms[0].referral_reason_desc.value == "")
	//{
		var tit				= getLabel("Common.ReasonforReferral.label",'common'); // (Wednesday, December 23, 2009 17559 (Venkat s) )
		var retVal			= new String();
		var argumentArray	= new Array() ;
		var dataNameArray	= new Array() ;
		var dataValueArray	= new Array() ;
		var dataTypeArray	= new Array() ;
	
		var locale=document.forms[0].localeth.value
			
		
	
		sql="SELECT contact_reason_code code,contact_reason description FROM am_contact_reason_lang_vw WHERE eff_status='E'  and reason_for_referral_yn='Y'  and language_id ='"+locale+"' and upper(contact_reason_code) like upper(?) and upper(contact_reason)  like upper(?)";	
		
//sql="select contact_reason_code code,contact_reason description from am_contact_reason where FOLLOWUP_OF_REFERRAL_YN='Y' and eff_status='E' and upper(contact_reason_code) like upper(?) and upper(contact_reason)  like upper(?)  ";
		//dataNameArray[0]	= "eff_status" ;
		//dataValueArray[0]	= "E";
		//dataTypeArray[0]	= STRING;

		//dataNameArray[1]	= "reason_for_referral_yn" ;
		//dataValueArray[1]	= "Y";
		//dataTypeArray[1]	= STRING;

		//dataNameArray[2]	= "language_id" ;
		//dataValueArray[2]	= locale
		//dataTypeArray[2]	= STRING;

		
		argumentArray[0]	= sql;
		argumentArray[1]	= dataNameArray ;
		argumentArray[2]	= dataValueArray ;
		argumentArray[3]	= dataTypeArray ;
		argumentArray[4]	= "1,2";
		argumentArray[5]	= document.forms[0].referral_reason_desc.value;
		argumentArray[6]	= CODE_LINK;
		argumentArray[7]	= CODE_DESC;
	
		retVal = await CommonLookup( tit, argumentArray );
		
		if(retVal != null && retVal != "" )
		{
			var ret1=unescape(retVal);
			var index=ret1.indexOf(',');
			var arr1=ret1.substring(index+1,ret1.length)//ret1.split(",");
			//arr=ret1.split(",");
			var arr0=ret1.substring(0,index);
			parent.frames[1].document.forms[0].referral_reason_desc.value=arr1;
			parent.frames[1].document.forms[0].referral_reason_code.value=arr0;
			parent.frames[1].document.forms[0].reason_for_ref_hid.value=parent.frames[1].document.forms[0].referral_reason_desc.value;
		}	
		else
		{
			parent.frames[1].document.forms[0].referral_reason_desc.value="";
			parent.frames[1].document.forms[0].referral_reason_code.value="";
			parent.frames[1].document.forms[0].reason_for_ref_hid.value=parent.frames[1].document.forms[0].referral_reason_desc.value;
		}
	//}

}

//This variable is let to show that by default on load Arrived tab is enabled.
var currentTab = new String();
//currentTab = "reffrom_tab";

// This function is used for calling the function for changing the tab img displays and also the function for corresponding page displays for that particular tab.
function tab_click(objName)
{	
	if(objName == "reffrom_tab")
	{		
		 //changeTab(objName);
		
		// moveToTab(1);
	}
	else if(objName == "refto_tab")
	{		
		//changeTab(objName);	

		 
		//moveToTab(2);
	}
	else if(objName == "rejfrom_tab")
	{
		
		//changeTab(objName);
		//moveToTab(3);
	}
}

// function to change the tab display images according to functionality.
function moveToTab(TabIndex) {
	var bookmarkToMove;
	
	if ( TabIndex == 1 )
	{ 
		
		
		if(parent.frames[1].document.getElementById('fromref') != null)
		{	
			
			
			//setTimeout("parent.frames[1].document.getElementById("fromref.scrollIntoView()")",150);
			setTimeout("parent.frames[1].document.getElementById('fromref').scrollIntoView()",150);
		   
            
		}
	}
	else if ( TabIndex == 2 )
	{		
		
		if(parent.frames[1].document.getElementById('toref') != null)
		{
			//setTimeout("parent.frames[1].document.getElementById("toref.scrollIntoView()")",50);
			setTimeout("parent.frames[1].document.getElementById('toref').scrollIntoView()",50);
			if(parent.frames[1].document.forms[0].to_speciality_code != null)
			{
				if(!parent.frames[1].document.forms[0].to_speciality_code.disabled)
					parent.frames[1].document.forms[0].to_speciality_code.focus();
			}
		
		}
	}
	else if (TabIndex == 3)
	{
		if(parent.frames[1].document.getElementById("torej") != null)
		{
			//setTimeout("parent.frames[1].document.getElementById("torej.scrollIntoView()")",50);
			setTimeout("parent.frames[1].document.getElementById('torej').scrollIntoView()",50);
		}
	}
}

async function populate_order(obj)
{  
	var ser_code=parent.frames[1].document.forms[0].to_service_code.value;
	//var ser_code="";
	var loc_code=parent.frames[1].document.forms[0].to_locn.value;
	//var loc_code="";
	var loc_type=parent.frames[1].document.forms[0].locationT0.value;	
	//var loc_type="C";
	var searchText=parent.frames[1].document.forms[0].order_catalog_desc.value;
	//var searchText="";
	var wing_code="";
	var clinic_code="";
	
	if(loc_type == "W") 
	{
		parent.frames[1].document.forms[0].catalog_but.disabled=true;
		parent.frames[1].document.forms[0].order_catalog_desc.readOnly=true;
		
		if(loc_code == "") wing_code="*A";
 		else 
			wing_code=loc_code;
		
		clinic_code="";
		
	}else if(loc_type == "C" || loc_type == "E" || loc_type =="Y")
	{
	   parent.frames[1].document.forms[0].catalog_but.disabled=true;
	  parent.frames[1].document.forms[0].order_catalog_desc.readOnly=true;
	 if(loc_code == "") clinic_code="*A";
		else clinic_code=loc_code;
		wing_code="";
	}
	else
	{
		parent.frames[1].document.forms[0].catalog_but.disabled=true;
		parent.frames[1].document.forms[0].order_catalog_desc.readOnly=true;
		wing_code="";
		clinic_code="";
	}
	
		var retVal			=    new String();
		var dialogTop	= "78";
		var dialogHeight= "400px" ; 
		var dialogWidth	= "700px" ;	
		var dialogLeft	= "48" ;
		
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status=no;valign=center; dialogLeft: "+dialogLeft ;
		
		var arguments			= "" ;
		var location_code="";
			
		if(clinic_code.indexOf("$")!=-1){				
			 clinic_code = clinic_code.substring(0,clinic_code.indexOf("$"));
		}
	  retVal= await window.showModalDialog("../../eOR/jsp/RefusalOrderOrderableFrameSet.jsp?called_from=OP&p_clinic_code="+escape(clinic_code)+"&p_service_code="+escape(ser_code)+"&p_wing_code="+escape(wing_code)+"&searchText="+escape(searchText),arguments,features);
		
	var arr=new Array();
	if(retVal != null && retVal != "")
	{
		
		var arr=retVal.split("&");
		parent.frames[1].document.forms[0].order_catalog.value=arr[0];
		parent.frames[1].document.forms[0].order_catalog_desc.value=arr[1];

	}
	else
	{
		parent.frames[1].document.forms[0].order_catalog.value="";
		parent.frames[1].document.forms[0].order_catalog_desc.value="";
	}

if(loc_type == "C" || loc_type == "E" || loc_type =="Y" || loc_type =="W" )
	{
	 	parent.frames[1].document.forms[0].catalog_but.disabled=false;
		parent.frames[1].document.forms[0].order_catalog_desc.readOnly=false;
	}
}
async function populate_reason(obj)
{
	var reason=parent.frames[1].document.forms[0].action.value;
	
	var tit				= getLabel('Common.reason.label','Common')
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
     locale=document.forms[0].locale.value;
	if(reason !="")
	{
	if(reason == "RF")
	{
	
	sql="select contact_reason_code code,contact_reason description from am_contact_reason_lang_vw where FOLLOWUP_OF_REFERRAL_YN='Y' and eff_status='E' and language_id='"+locale+"' and upper(contact_reason_code) like upper(?) and upper(contact_reason)  like upper(?)  ";
	}
	else 
	{
	sql="select contact_reason_code code,contact_reason description from am_contact_reason_lang_vw where REJECTION_OF_REFERRAL_YN='Y' and language_id='"+locale+"' and eff_status='E' and upper(contact_reason_code) like upper(?) and upper(contact_reason)  like upper(?)  ";
	}

	
	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "1,2";
	argumentArray[5]	= document.forms[0].reason_txt.value;
	argumentArray[6]	= CODE_LINK;
	argumentArray[7]	= CODE_DESC;

	retVal = await CommonLookup( tit, argumentArray );
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		parent.frames[1].document.forms[0].reason_txt.value=arr[1];
		document.forms[0].reason_code.value=arr[0];
	}

	else
	{
		document.forms[0].reason_txt.value="";
		document.forms[0].reason_code.value="";			
	}
	}
}

function clear_text(obj)
{
	parent.frames[1].document.forms[0].reason_txt.value="";
	parent.frames[1].document.forms[0].reason_code.value="";

	if(obj.value != "")
	{
		parent.frames[1].document.forms[0].reason_txt.readOnly=false;
		parent.frames[1].document.forms[0].reason_but.disabled=false;
		parent.frames[1].document.forms[0].remarks.readOnly=false;
	}
	else
	{
		parent.frames[1].document.forms[0].reason_txt.readOnly=true;
		parent.frames[1].document.forms[0].reason_but.disabled=true;
		parent.frames[1].document.forms[0].remarks.readOnly=true;
	}
}

function clear_order(obj)
{
	if(parent.frames[1].document.forms[0].or_operational_yn.value == "Y")
	{
	parent.frames[1].document.forms[0].order_catalog_desc.value="";
	parent.frames[1].document.forms[0].order_catalog.value="";
	}
}

function getFocus(fun)
{
	
	if(fun=='priority')
	{
	if(parent.frames[1].document.forms[0].referred_for_ip.disabled== true)
	{
		
		//parent.frames[1].document.getElementById("referredto1").scrollIntoView();
		
		if(parent.frames[0].document.forms[0].patient_id.disabed == false)
			parent.frames[0].document.forms[0].patient_id.focus();
		else
			parent.frames[0].focus();
		
		
		

		if(document.getElementById('referred_for_ip').disabled==true)
		{
			
		
			if (document.getElementById('to_speciality_code').disabled==false)
				document.getElementById('to_speciality_code').focus();
		}
		else
		{
			
		
			document.getElementById('referred_for_ip').focus();
		}
	}
	}
	else
	{
		
		
		document.getElementById('to_speciality_code').focus();
	}
	
	
	
}
function onSuccess()
{	
	parent.f_query_add_mod.location.reload();
//parent.parent.frames[1].location.reload();
	//parent.messageFrame.location.href=parent.f_query_add_mod.frames[1].document.forms[0].contextURL.value+'/eCommon/jsp/MstCodeError.jsp';
	
}


async function referralSourceLookup(obj){
	var retVal			= new String();	

	var dialogTop			= "0px";
	var dialogHeight		= "400px" ;
	var dialogWidth			= "750px" ;
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var sql1				= "";	
	var target=obj;
	
	var title=getLabel("Common.ReferredFrom.label","common");//Title  modified  for PMG2014-CRF-0007 [IN:046756]
	title=encodeURIComponent(title);
	var column_sizes = escape("10%,20%,20%,20%,20%");
	

	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);	

	var shortDesc=getLabel("Common.shortdescription.label","common");
		shortDesc=encodeURIComponent(shortDesc);	

	var longDesc=getLabel("Common.longdescription.label","common");
	longDesc=encodeURIComponent(longDesc);
	var longname=getLabel("Common.longname.label","common");
		longname=encodeURIComponent(longname);
	var hlthcrsttyp="Healthcaresettingstype";

	var column_descriptions = code+","+shortDesc+","+longDesc+","+longname+","+hlthcrsttyp;
	
	var message = '';
	var p_calling_function=parent.frames[1].document.forms[0].p_calling_function.value;
	
	var facilityid=parent.frames[1].document.forms[0].facilityid.value;			
	var target=parent.frames[1].document.forms[0].referral_source;
	var ref_type=parent.frames[1].document.forms[0].referral_type.value;
	var hcareType=parent.frames[1].document.forms[0].hcare_type.value;
	var locale=document.forms[0].localeth.value;
	var sql = '';
	var param='';

	if(ref_type==''){
		var error= getMessage("CAN_NOT_BE_BLANK",'Common').replace('$','Referral Type')+ "\n" ;
		alert(error)
		parent.frames[1].document.forms[0].referral_type.focus();
		parent.frames[1].document.forms[0].referral_source.value="";

	}else{
		if(hcareType==''){
			var error= getMessage("CAN_NOT_BE_BLANK",'Common').replace('$','Healthcare Setting Type')+ "\n" ;
			alert(error)
			parent.frames[1].document.forms[0].hcare_type.focus();
			parent.frames[1].document.forms[0].referral_source.value="";

		}else{

			if(ref_type=='L'){
				sql="select nvl(a.FACILITY_ID,'') referred_to_id,nvl(a.FACILITY_NAME,'') referred_to_id_desc ,nvl(a.hcare_setting_type_code,'') hcare_setting_type_code,nvl(b.short_desc,'') hcare_setting_type_desc,nvl(a.hcare_setting_type_code,'') hcare_setting_type_code from SM_FACILITY_PARAM_LANG_VW a, AM_HCARE_SETTING_TYPE_LANG_VW b where a.hcare_setting_type_code=b.hcare_setting_type_code and a.hcare_setting_type_code in ( select to_hcare_setting_type_code from am_hcare_setting_type_rstrn where from_hcare_setting_type_code = (select hcare_setting_type_code from SM_FACILITY_PARAM where facility_id = ? ) and (ip_referral_yn = 'Y'  or op_referral_yn = 'Y') ) and a.language_id=? and b.language_id=? and a.facility_id=? ";

				var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+escape(sql)+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&facilityid="+facilityid+"&ref_type="+ref_type+"&hcareType="+hcareType+"&locale="+locale+"&srch_by_clmn_index=2"+"&col_show_hide=YYNNN";

			}else if(ref_type=='X'){
			//	sql="Select nvl(a.REFERRAL_CODE,'') referred_to_id,nvl(a.short_desc,'') referred_to_id_short_desc, nvl(a.LONG_DESC,'') referred_to_id_desc,nvl(a.long_name,'') long_name ,nvl(a.HEALTHCARE_SETTING_TYPE,'') hcare_setting_type_code  from am_referral_lang_vw  a, am_hcare_setting_type_lang_vw   b where a.healthcare_setting_type = b.hcare_setting_type_code and nvl(a.dest_use_at_concl_yn,'N') = 'Y' and a.eff_status = 'E' and  a.healthcare_setting_type=?   and a.language_id=? and b.language_id=? ";
				sql="Select nvl(a.REFERRAL_CODE,'') referred_to_id,nvl(a.short_desc,'') referred_to_id_short_desc, nvl(a.LONG_DESC,'') referred_to_id_desc,nvl(a.long_name,'') long_name ,nvl(a.HEALTHCARE_SETTING_TYPE,'') hcare_setting_type_code  from am_referral_lang_vw  a, am_hcare_setting_type_lang_vw   b where a.healthcare_setting_type = b.hcare_setting_type_code and a.eff_status = 'E' and  a.healthcare_setting_type=?   and a.language_id=? and b.language_id=? ";
				
				if(p_calling_function=="AE_REGISTER_ATTN" || p_calling_function=="OP_REG_VISIT")
				sql=sql+"and SOURCE_USE_AT_VISIT_YN='Y'";
				else if(p_calling_function=="IP_ADMIT")
				 sql=sql+"and SOURCE_USE_AT_ADM_YN='Y'";				
				
				
				
				var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+escape(sql)+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&facilityid="+facilityid+"&ref_type="+ref_type+"&hcareType="+hcareType+"&locale="+locale+"&srch_by_clmn_index=3"+"&col_show_hide=YYYYN";


				
				//var param = "title="+title+"&ref_type="+ref_type+"&hcareType="+hcareType+"&locale="+locale+"&srch_by_clmn_index=3"+"&col_show_hide=YYYYN";

			}else if(ref_type=='E'){
				sql="SELECT nvl(a.FACILITY_ID,'') referred_to_id ,nvl(a.FACILITY_NAME,'') referred_to_id_desc   ,nvl(a.hcare_setting_type_code,'') hcare_setting_type_code, nvl(b.short_desc,'') hcare_setting_type_desc,nvl(a.hcare_setting_type_code,'') hcare_setting_type_code FROM SM_FACILITY_PARAM_LANG_VW a  , AM_HCARE_SETTING_TYPE_LANG_VW b WHERE a.facility_id != ?  AND a.hcare_setting_type_code=?   AND a.hcare_setting_type_code=b.hcare_setting_type_code   AND a.hcare_setting_type_code IN  (SELECT to_hcare_setting_type_code FROM    am_hcare_setting_type_rstrn   WHERE from_hcare_setting_type_code =  a.HCARE_SETTING_TYPE_CODE AND (ip_referral_yn = 'Y' OR op_referral_yn = 'Y'    )   )   AND a.language_id=?  AND b.language_id=? "
				
				var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+escape(sql)+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&facilityid="+facilityid+"&ref_type="+ref_type+"&hcareType="+hcareType+"&locale="+locale+"&srch_by_clmn_index=2"+"&col_show_hide=YYNNN";

			}	

		//	alert(param)
			retVal= await window.showModalDialog("../../eAM/jsp/ReferralSourceLookupFrames.jsp?calling_from=create&"+param,arguments,features);
			
			if(retVal){
				var ret_array = retVal.split("^~^");
				
				parent.frames[1].document.forms[0].referral_source_lkp_id.value=ret_array[4]+'~'+ret_array[0];

				if(ref_type=='X'){
					parent.frames[1].document.forms[0].referral_source.value=ret_array[2];
					parent.frames[1].document.forms[0].referral_source_lkp_bkup_text.value=ret_array[2];
				}else{
					parent.frames[1].document.forms[0].referral_source.value=ret_array[1];
					parent.frames[1].document.forms[0].referral_source_lkp_bkup_text.value=ret_array[1];
				}

				if(ret_array[3] !='' && ref_type=='X' && ret_array[3] !='-select-'){	
					
					parent.frames[1].document.getElementById('lng_name').style.visibility="visible";
					parent.frames[1].document.getElementById('lng_name').alt=ret_array[3];

				}else{
					parent.frames[1].document.getElementById('lng_name').style.visibility="hidden";
				}
			//Added for incident IN023039 by Suresh M on 24.08.2010 
				if(parent.frames[1].document.getElementById('speciality').disabled=true)
					parent.frames[1].document.getElementById('speciality').disabled=false;
				// Ends IN023039

				populate_ext_specialty(parent.frames[1].document.forms[0].referral_source_lkp_id);
			}
		}
	}
	
}

function clear_ref(){

	if(parent.frames[1].document.forms[0].referral_source.value==''){		
		
		//Added for incident IN023039 by Suresh M on 24.08.2010 // Ends IN023039
			parent.frames[1].document.getElementById('speciality').value = "";	
			parent.frames[1].document.getElementById('speciality').disabled=true;
			if(parent.frames[1].document.getElementById('location0')){ 				 
				parent.frames[1].document.getElementById('location0').value = "";
				parent.frames[1].document.getElementById('location0').disabled = true;		
			}			
		//Ends
	
		if(parent.frames[1].document.forms[0].referral_type.value == 'X')
		{
			parent.frames[1].document.getElementById("from_locn").value = "";
			parent.frames[1].document.getElementById('from_practitioner').value="";
			parent.frames[1].document.getElementById('from_practitioner_id').value="";
			parent.frames[1].document.getElementById('from_ext_practitioner_id').value="";
			parent.frames[1].document.forms[0].from_ext_practitioner_id.disabled=false;
			parent.frames[1].document.forms[0].from_practitioner_id.disabled=false;
			parent.frames[1].document.getElementById('bpract').disabled=false;
			if(parent.frames[1].document.forms[0].from_ext_practitioner_id.value!=''){
			parent.frames[1].document.forms[0].from_practitioner_id.disabled=true;
			parent.frames[1].document.getElementById('bpract').disabled=true;	
        }
		/*	if(parent.frames[1].document.getElementById("operation_type").value=="modify"){
			parent.frames[1].document.forms[0].from_practitioner_id.disabled=false;
			parent.frames[1].document.getElementById('bpract').disabled=false;
			parent.frames[1].document.getElementById('pract_ext_name').disabled=false;
			} */
        } else{ //Added for incident IN023039 by Suresh M on 24.08.2010 
			if(parent.frames[1].document.getElementById("from_locn")){
				delete_values1(parent.frames[1].document.getElementById("from_locn"));
				parent.frames[1].document.getElementById("from_locn").disabled = true;
				parent.frames[1].document.getElementById('from_practitioner_id').value="";
			}
			// Ends IN023039
		}
		parent.frames[1].document.getElementById('lng_name').style.visibility="hidden";
		parent.frames[1].document.forms[0].referral_source_lkp_id.value="";
		parent.frames[1].document.forms[0].referral_source.value="";
		parent.frames[1].document.forms[0].referral_source_lkp_bkup_text.value="";

	}else{

		if(parent.frames[1].document.forms[0].referral_source_lkp_bkup_text.value != parent.frames[1].document.forms[0].referral_source.value){
			referralSourceLookup(parent.frames[1].document.forms[0].referral_source_lkp_but)
		}
	}
}
function disable_pract(obj)
{
	
	if(parent.frames[1].document.forms[0].referral_type.value=='X'){
        
		if(obj.value !=''){
		parent.frames[1].document.forms[0].from_practitioner_id.disabled=true;
		parent.frames[1].document.getElementById('bpract').disabled=true;	
		}else{
		parent.frames[1].document.forms[0].from_practitioner_id.disabled=false;
		parent.frames[1].document.getElementById('bpract').disabled=false;	
		}
    
	}
}
function disable_ext_pract(obj)
{
	if(parent.frames[1].document.forms[0].referral_type.value=='X'){

		if(obj.value !='')
		parent.frames[1].document.forms[0].from_ext_practitioner_id.disabled=true;
	    else
		parent.frames[1].document.forms[0].from_ext_practitioner_id.disabled=false;
	}
}
/*Added by Dharma on 11th Feb 2016 against ML-MMOH-CRF-0340 [IN057178] Start*/

function defaultLoginFacility(){
	if(parent.frames[1].document.forms[0].referral_type!=null){
		var dropDown = parent.frames[1].document.forms[0].referral_type;
		var i;
		var isLoginFacility		= "";
		for (i = 0; i < dropDown.length; i++) {
			if(dropDown.options[i].value=="L"){
				isLoginFacility	= "Y";
				break;
			}
		}
		if(isLoginFacility=="Y"){
			parent.frames[1].document.forms[0].referral_type.value	= "L";
			parent.frames[1].document.forms[0].referral_type.onchange();
		}
	}
}
/*Added by Dharma on 11th Feb 2016 against ML-MMOH-CRF-0340 [IN057178] End*/
// Added by Afruddin for ML-MMOH-CRF-1527 US0003 on 28-jun-2020
function ChangeState(obj)
{
 if (obj.checked == true)
  {
	  
	  document.forms[0].transfer_case_yn.value='Y';
	  
	  
  }
  else
  {
	   document.forms[0].transfer_case_yn.value='N';
  }
} 


function reftype() 
{

          var ref_type=parent.frames[1].document.forms[0].from_ref_type.value;
          var isTransferCase = parent.frames[1].document.forms[0].isTransferCase.value;
		  var operation_type=parent.frames[1].document.forms[0].operation_type.value;
		  var transfer_case_yn=parent.frames[1].document.forms[0].transfer_case_yn.value;
		 
		 
		  
		  if(isTransferCase=="true"){ 
			 
             if(ref_type=="X"){
            	parent.frames[1].document.getElementById('transfer_case_yn').style.display="inline";
            	parent.frames[1].document.getElementById('transfer_case').style.display="inline";
				if(operation_type=="insert")
				 {
                
				parent.frames[1].document.RegPatReferral_form.transfer_case_yn.checked=true; 
				parent.frames[1].document.RegPatReferral_form.transfer_case_yn.value='Y';    
				
				 }
				 else{
					 if(transfer_case_yn=="Y"){
				 parent.frames[1].document.RegPatReferral_form.transfer_case_yn.checked=true;
				parent.frames[1].document.RegPatReferral_form.transfer_case_yn.value='Y';
					 }
					 else{
					  parent.frames[1].document.RegPatReferral_form.transfer_case_yn.checked=false;
				parent.frames[1].document.RegPatReferral_form.transfer_case_yn.value='N';
					 }
				 }
				
			}
			else 
			{	
				parent.frames[1].document.getElementById('transfer_case_yn').style.display="none";
				parent.frames[1].document.getElementById('transfer_case').style.display="none";
				parent.frames[1].document.RegPatReferral_form.transfer_case_yn.checked=false;
				parent.frames[1].document.RegPatReferral_form.transfer_case_yn.value='N';
					 
			}   
             
		}
}

function reftypechange()
{

		var isTransferCase = parent.parent.frames[1].frames[1].document.forms[0].isTransferCase.value;
		var ref_type=parent.frames[1].document.forms[0].referral_type.value;	
		if(isTransferCase=="true"){
			
			 if(ref_type=="X")
			{
				 parent.frames[1].document.getElementById('transfer_case_yn').style.display="inline";
            	parent.frames[1].document.getElementById('transfer_case').style.display="inline";
                parent.frames[1].document.RegPatReferral_form.transfer_case_yn.checked=false; 
				parent.frames[1].document.RegPatReferral_form.transfer_case_yn.value='N';   
				
				
			}
             
		   else 
				{
				parent.frames[1].document.getElementById('transfer_case_yn').style.display="none";
            	parent.frames[1].document.getElementById('transfer_case').style.display="none";
                parent.frames[1].document.RegPatReferral_form.transfer_case_yn.checked=false;
				parent.frames[1].document.RegPatReferral_form.transfer_case_yn.value='N';
				}
			    
			
		}
}

//Ended by Afruddin for ML-MMOH-CRF-1527 US0003 on 28-jun-2020



