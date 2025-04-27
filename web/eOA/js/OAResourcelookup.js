function callPractSearch1(obj,target,locale){ 


	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";
	practName_FName=target.name;
	practName_FValue=target.value;
	var entval="";
	var practitioner_id1="";
	/*Added by S.Sathish for IN020571 on Thursday, April 08, 2010 starts  here*/
	if(document.forms[0].from_page.value =="query" && document.forms[0].called_from.value=="appt_for_res"){
		parent.frames[1].location.href='../../eCommon/html/blank.html';
		if(parent.frames[0].document.forms[0].select)
			if(parent.frames[0].document.forms[0].select.disabled==true)
				parent.frames[0].document.forms[0].select.disabled=false;
	}
    /*Ends Here*/
	if(document.forms[0].from_page.value =="change_resource"){
		practitioner_id1=document.forms[0].pract_from.value;
		entval= document.forms[0].pract_from.value;
	}else{	
		if(document.forms[0].from_page.value !="bulk"){
			if(obj.name=="practitioner_name" || obj.name=="search_pract"){
				practId_FName=document.forms[0].practitioner_name.name;
				entval= document.forms[0].practitioner_name.value;
			}else{
				practId_FName=document.forms[0].practitioner_name2.name;
				entval= document.forms[0].practitioner_name2.value;
			}
		}else{
			practId_FName=document.forms[0].practitioner_name.name;
			entval= document.forms[0].practitioner_name.value;
		}
	}
	var spl_code ="";
	var location1="";
	if(obj.name=="practitioner_name2" || obj.name=="search_pract2"){
		spl_code =document.forms[0].specialty_code2.value;
	}else{
		spl_code =document.forms[0].specialty_code1.value;
	}

	var pract_type="";
	var sql="";
	var sql2="";
	var val    = new Array() ;
	if(obj.name=="practitioner_name2" || obj.name=="search_pract2"){
		location1=document.forms[0].location_code2.value;
	}else{
		location1=document.forms[0].location_code1.value;
	}
	var facilityid = document.forms[0].facilityId.value;
	if(document.forms[0].from_page.value =="schedule_appt" || document.forms[0].from_page.value =="transfer_cancel" || document.forms[0].from_page.value =="query" || document.forms[0].from_page.value =="schedule_appt_diff" ){
		val = location1.split("$");
		if (val !=""){
			var clinic_code=val[1].split("$");
			var open_to_all_pract_yn= val[0].split("$");
		}
		// Thursday, February 18, 2010 19335 
		if(document.forms[0].from_page.value =="query")
		{
		  spl_code =document.forms[0].speciality.value;
		   //Below Condition Added Against JD-CRF-0184 [IN:041354] By Saanthaakumar
			var clinicType="";
			if(document.forms[0].locationType){
		    clinicType=document.forms[0].locationType.value;
					if(clinicType==""){ 
							clinic_code ="";
							} 
			}else if(document.forms[0].location1){
			 clinicType=document.forms[0].location1.value;
						if(clinicType=="") {
								clinic_code ="";  
								} 
				}
		}

	}else if(document.forms[0].from_page.value=="bulk"){
		val = location1.split("$");
		if (val !=""){
			var clinic_code=val[1].split("$");
			var open_to_all_pract_yn= val[0].split("$");
			var resource_type= val[2].split("$");
		}
		var clinicType=document.forms[0].locationType1.value;
	}else if(document.forms[0].from_page.value=="block"){
		val=location1.split("%");
		var clinic_code=val[0];
		var open_to_all_pract_yn= val[2];
	}else if(document.forms[0].from_page.value=="block_lift_cancel" || document.forms[0].from_page.value=="duty_roaster"  || document.forms[0].from_page.value=="change_resource"){
		if(document.forms[0].from_page.value=="duty_roaster" || document.forms[0].from_page.value=="block_lift_cancel"){
			location1=document.forms[0].location.value;
		}
		val=location1.split("|");
		var clinic_code=val[0];
		var clinic_type=val[1];
		var open_to_all_pract_yn= val[2];
	}else if (document.forms[0].from_page.value=="wait_list_modify"){
		location1=document.forms[0].clinic_code.value;
		resource_type=document.forms[0].resourceType1.value;
		val=location1.split("|");
		var clinic_code=val[1];
		var open_to_all_pract_yn= val[0];
		var clinicType= val[2];
	}else{
		if(document.forms[0].from_page.value!="reprint"){
			val = location1.split("$");
			if (val !=""){
				var clinic_code=val[0].split("$");
				var clinic_type=val[1].split("$");
				var open_to_all_pract_yn= val[2].split("$");
				var ident_at_checkin= val[3].split("$");
				var fi_visit_type_appl_yn= val[4].split("$");
				var alcn_criteria= val[5].split("$");
			}
		}
	}
	if(document.forms[0].from_page.value!="wait_list_modify" && document.forms[0].from_page.value!="bulk"){
		if(document.forms[0].from_page.value!="appt_dairy" ){
			if(obj.name!="practitioner_name2" || obj.name!="search_pract2"){
				resource_type=document.forms[0].resourceType1.value;
			}else{
				resource_type=document.forms[0].resourceType3.value;
			}
			tit= getLabel("Common.resource.label","Common");
			if(obj.name!="practitioner_name2" || obj.name!="search_pract2"){
				var clinicType=document.forms[0].locationType1.value;
			}else{
				var clinicType=document.forms[0].locationType2.value;
			}
		}else{
			resource_type=document.forms[0].res_type.value;
			var clinicType=document.forms[0].clinic_type.value;
			open_to_all_pract_yn=document.forms[0].open_to_all_pract_yn.value;
			var clinic_code=document.forms[0].clinic_code.value;
		}
	}
	if (document.forms[0].from_page.value=="wait_list_modify"){
		location1=document.forms[0].clinic_code.value;
		resource_type=document.forms[0].resourceType1.value;
		spl_code=document.forms[0].speciality_code.value;
		val=location1.split("|");
		var clinic_code=val[1];
		var open_to_all_pract_yn= val[0];
		var clinicType= val[2];
	}	
	
	if(clinicType=='N' || clinic_type=="N"){
		getPractitioner(obj,target,facilityid,spl_code,pract_type,clinic_code,practitioner_id1,"Q5");
	}else{			
		if(resource_type=='P'){
			if(document.forms[0].from_page.value=="appt_dairy"){
				if(open_to_all_pract_yn=="Y"){
					getPractitioner(obj,target,facilityid,spl_code,pract_type,clinic_code,practitioner_id1,"Q8");
				}else{
					getPractitioner(obj,target,facilityid,spl_code,pract_type,clinic_code,practitioner_id1,"Q13");
				}
			}else if(document.forms[0].from_page.value!="reprint" && document.forms[0].from_page.value!="appt_dairy"){
				if( open_to_all_pract_yn=="Y"){
					if(clinic_code!=""){
						getPractitioner(obj,target,facilityid,spl_code,pract_type,clinic_code,practitioner_id1,"Q3");
						if(document.forms[0].from_page.value=="schedule"){
							checkRoster('1');
						}
					}else{
						if(spl_code!=""){
							getPractitioner(obj,target,facilityid,spl_code,pract_type,clinic_code,practitioner_id1,"Q6");
						}else{
							getPractitioner(obj,target,facilityid,spl_code,pract_type,clinic_code,practitioner_id1,"Q2");
						}
					}
				}else{
					if(spl_code!="" && clinic_code==""){
							getPractitioner(obj,target,facilityid,spl_code,pract_type,clinic_code,practitioner_id1,"Q6");
						}
						/*Below Condition Added Against JD-CRF-0184 [IN:041354] By Saanthaakumar*/		
						else if((spl_code =="") && (clinic_code=="" || clinic_code ==undefined ) &&(document.forms[0].from_page.value=="query")){ 
							getPractitioner(obj,target,facilityid,spl_code,pract_type,clinic_code,practitioner_id1,"Q15");
						}
											
					else{ 
						
					getPractitioner(obj,target,facilityid,spl_code,pract_type,clinic_code,practitioner_id1,"Q12");
					if(document.forms[0].from_page.value=="schedule"){
						checkRoster('1');
					}}
				
				}
			}else{
				getPractitioner(obj,target,facilityid,spl_code,pract_type,clinic_code,practitioner_id1,"Q2");
			}
		}else{
			if(resource_type=='E' || resource_type=='O'){ 
				if(document.forms[0].from_page.value=="appt_dairy"){
					if (open_to_all_pract_yn != "Y"){
						sql="select practitioner_id code, AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,'"+locale+"','2') description from  op_pract_for_clinic  where resource_class= '"+resource_type+"' and clinic_code='"+clinic_code+"' and Facility_id='"+facilityid+"' and upper(practitioner_id) like upper(?)  and upper(AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,'"+locale+"','2')) like upper(?) order by description";
					}else{
						sql="Select resource_id practitioner_id, short_desc practitioner_name from am_resource_lang_vw where facility_id = '"+facilityid+"' and Resource_Class ='"+resource_type+"'   and language_id = '"+locale+"' order by short_desc";
					}
				}else if(document.forms[0].from_page.value=="change_resource" && obj.name!="from"){
					if (open_to_all_pract_yn != "Y"){
						sql="select b.practitioner_id code,AM_GET_DESC.AM_RESOURCE(b.FACILITY_ID, b.PRACTITIONER_ID,'"+locale+"','2') description from op_pract_for_clinic b where  b.eff_status='E' and b.clinic_code='"+clinic_code+"' and b.RESOURCE_CLASS='"+resource_type+"' and  b.practitioner_id != '"+document.forms[0].pract_from.value+"' and b.Facility_id='"+facilityid+"' and upper(b.practitioner_id) like upper(?) and upper(AM_GET_DESC.AM_RESOURCE(b.FACILITY_ID, b.PRACTITIONER_ID,'"+locale+"','2'))  like upper(?) order by description";	
					}else{
						sql="Select resource_id code,SHORT_DESC description  from am_resource_lang_vw where facility_id = '"+facilityid+"' and Resource_Class ='"+resource_type+"' and resource_id !='"+document.forms[0].pract_from.value+"' and language_id='"+locale+"'  and upper(resource_id) like upper(?) and upper(SHORT_DESC)  like upper(?) order by description";
					}
				}else{
					if( open_to_all_pract_yn!="Y"){
					//modified by N Munisekhar against JD-CRF-0185 [IN041355]
						if(clinic_code!=undefined && clinic_code!="" && clinic_code != null)
						{
						sql="select b.practitioner_id code,AM_GET_DESC.AM_RESOURCE(b.FACILITY_ID, b.PRACTITIONER_ID,'"+locale+"','2') description from op_pract_for_clinic b where  b.eff_status='E' and b.clinic_code='"+clinic_code+"' and b.Facility_id='"+facilityid+"' and b.RESOURCE_CLASS='"+resource_type+"' and upper(b.practitioner_id) like upper(?) and upper(AM_GET_DESC.AM_RESOURCE(b.FACILITY_ID, b.PRACTITIONER_ID,'"+locale+"','2'))  like upper(?) order by description";							
						}else{
							sql="Select resource_id code,SHORT_DESC description  from am_resource_lang_vw where facility_id = '"+facilityid+"' and Resource_Class ='"+resource_type+"' and language_id='"+locale+"'  and upper(resource_id) like upper(?) and upper(SHORT_DESC)  like upper(?) order by description";						
						}
					}else{
						sql="Select resource_id code,SHORT_DESC description  from am_resource_lang_vw where facility_id = '"+facilityid+"' and Resource_Class ='"+resource_type+"' and language_id='"+locale+"'  and upper(resource_id) like upper(?) and upper(SHORT_DESC)  like upper(?) order by description";						
					}
				}
			}else if(resource_type=='R'){ 
				if(document.forms[0].from_page.value=="appt_dairy"){
					if (open_to_all_pract_yn != "Y"){
						sql="select Practitioner_id code, AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, Practitioner_id,'"+locale+"','2') description from op_pract_for_clinic where clinic_code='"+clinic_code+"' and Facility_id ='"+facilityid+"' and resource_class='R'  and upper(Practitioner_id) like upper(?) and upper(AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, Practitioner_id,'"+locale+"','2'))  like upper(?) order by  description";
					}else{ 
						//sql="select room_num practitioner_id, short_desc practitioner_name from am_facility_room_lang_vw where operating_facility_id ='"+facilityid+"' and language_id = '"+locale+"' order by short_desc";
						/*Above Line commented and Below Line Added for this incident [35078]*/
						sql="select room_num code ,short_desc description from am_facility_room_lang_vw where operating_facility_id = '"+facilityid+"'  and language_id='"+locale+"' and upper(room_num) like upper(?) and upper(short_desc)  like upper(?) order by short_desc";
					}
				}else if(document.forms[0].from_page.value=="change_resource" && obj.name!="from"){
					if (open_to_all_pract_yn != "Y"){
					 sql="select Practitioner_id code, AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2') description from op_pract_for_clinic where clinic_code='"+clinic_code+"' and Facility_id ='"+facilityid+"' and eff_status='E' and resource_class='R' and practitioner_id != '"+document.forms[0].pract_from.value+"'and upper(practitioner_id) like upper(?) and upper(AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'))  like upper(?) order by  description";
					}else{
						sql="select room_num code ,short_desc description from am_facility_room_lang_vw where operating_facility_id = '"+facilityid+"'  and language_id='"+locale+"' and room_num != '"+document.forms[0].pract_from.value+"' and upper(room_num) like upper(?) and upper(short_desc)  like upper(?) order by short_desc";
					}
				}else{
					if( open_to_all_pract_yn!="Y"){
					  //modified by N Munisekhar against JD-CRF-0185 [IN041355]
						if(clinic_code!=undefined && clinic_code!="" && clinic_code != null){
						sql="select Practitioner_id code, AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2') description from op_pract_for_clinic where clinic_code='"+clinic_code+"' and Facility_id ='"+facilityid+"' and resource_class='R' and eff_status='E' and upper(practitioner_id) like upper(?) and upper(AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'))  like upper(?) order by  description";
					}else {
						sql="select room_num code ,short_desc description from am_facility_room_lang_vw where operating_facility_id = '"+facilityid+"'  and language_id='"+locale+"' and upper(room_num) like upper(?) and upper(short_desc)  like upper(?) order by short_desc";
						}
					}else{
						sql="select room_num code ,short_desc description from am_facility_room_lang_vw where operating_facility_id = '"+facilityid+"'  and language_id='"+locale+"' and upper(room_num) like upper(?) and upper(short_desc)  like upper(?) order by short_desc";
					}
				}
			}else if(resource_type=='B'){
			}
			//if(document.forms[0].from_page.value =="transfer_cancel"){
			/*Added By Rameswar On 04th August 2015 Against HSA-SCF-0274 IN056358*/
			 if(document.forms[0].from_page.value =="transfer_cancel" && resource_type=='P'){			
				getPractitioner(obj,target,facilityid,spl_code,pract_type,clinic_code,practitioner_id1,"Q2");
		     } else{
				call_common(sql,obj);
			 }
		}
	}
}



function PractLookupRetVal(retVal,objName)
{
	var arr;
if((objName!="p_fm_pract_id") &&  (objName!="p_to_pract_id") && document.forms[0].from_page.value!="change_resource"){
	if (retVal != null)
	{
		arr=unescape(retVal).split("~");
		if(objName!="practitioner_name2")
		{
		if(document.forms[0].from_page.value=='reports_listappt'){
			if(objName=='P_FM_PRACT_ID'){
				document.forms[0].P_FM_PRACT_ID.value=arr[0];
			}else if(objName=='P_TO_PRACT_ID'){
				document.forms[0].P_TO_PRACT_ID.value=arr[0];
			}
		}else{
		document.forms[0].practitioner_name.value=arr[1];
		document.forms[0].practitioner.value=arr[0];
		if (document.forms[0].from_page.value=="duty_roaster")
		{
			Poplocntype(arr[0],arr[1]);
		}
		}
		}else
		{
	
			document.forms[0].practitioner_name2.value=arr[1];
			document.forms[0].practitioner2.value=arr[0];
		}
	}else
	{
		if(document.forms[0].from_page.value=='reports_listappt'){
			if(objName=='P_FM_PRACT_ID'){
				document.forms[0].P_FM_PRACT_ID.value='';
			}else if(objName=='P_TO_PRACT_ID'){
				document.forms[0].P_TO_PRACT_ID.value='';
			}
		}else{
		if(objName!="practitioner_name2")
		{
		document.forms[0].practitioner_name.value= "";
		document.forms[0].practitioner.value="";
		}
		else
		{
			document.forms[0].practitioner_name2.value= "";
			document.forms[0].practitioner2.value="";
		}
	  }
	}
}
else if(document.forms[0].from_page.value!="change_resource")
	{
	if (!(retVal == null))
	{
		arr=retVal.split("~");
		if(objName=="p_fm_pract_id")
		{
			
				
				document.forms[0].p_fm_pract_id.value=arr[0];
		}
		else
		{
			document.forms[0].p_to_pract_id.value=arr[0];
		}
	}else
	{
		if(objName=="p_fm_pract_id")
		{
	document.forms[0].p_fm_pract_id.focus();
	document.forms[0].p_fm_pract_id.value="";
		}
		else	
		{
			
			document.forms[0].p_to_pract_id.focus();
			document.forms[0].p_to_pract_id.value="";
		}
	}

	}
	else
	{
		if (!(retVal == null))
		{
			var ret1=unescape(retVal);
			arr=ret1.split("~");
			if(objName== "pract_from_desc"){
			
				document.forms[0].pract_from_desc.value=arr[1];
				document.forms[0].pract_from.value=arr[0];
				document.forms[0].pract_to_desc.disabled=false;
				document.forms[0].to.disabled=false;
			}else if(objName=="pract_to_desc"){
				document.forms[0].pract_to_desc.value=arr[1];
				document.forms[0].pract_to.value=arr[0];
			}
		}else{
		if(objName=="pract_from_desc")
			{
			document.forms[0].pract_from_desc.value="";
			document.forms[0].pract_from.value="";
			}else if(objName=="pract_to_desc")
			{
				document.forms[0].pract_to_desc.value="";
				document.forms[0].pract_to.value="";
			}
		}

	}
}

async function call_common(sql,obj){   
	var tit				=  getLabel("Common.resource.label","Common");
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";	
	if(document.forms[0].from_page.value=="change_resource"){
		if(obj.name =="from"){
			argumentArray[5] = document.forms[0].pract_from_desc.value;
		}else{
			argumentArray[5] = document.forms[0].pract_to_desc.value;
		}
	}else{
		argumentArray[5] = document.forms[0].practitioner_name.value;
	}
if(document.forms[0].from_page.value=="bulk"){
	if(obj.name=="practitioner_name" || obj.name=="search_pract")
		argumentArray[5] = document.forms[0].practitioner_name.value;
	else
		argumentArray[5] = document.forms[0].practitioner_name2.value;
}	
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retVal = await CommonLookup( tit, argumentArray );
	if(document.forms[0].from_page.value=="change_resource"){
		if(retVal != null && retVal != "" ){
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			if(obj.name == "from"){
				document.forms[0].pract_from_desc.value=arr[1];
				document.forms[0].pract_from.value=arr[0];
				if(document.forms[0].pract_to_desc!=null && document.forms[0].to!=null){
					document.forms[0].pract_to_desc.disabled=false;
					document.forms[0].to.disabled=false;
				}
			}else{
				document.forms[0].pract_to_desc.value=arr[1];
				document.forms[0].pract_to.value=arr[0];
			}	
		}else{
			if (obj.name == "from"){
				document.forms[0].pract_from_desc.value="";
				document.forms[0].pract_from.value="";
			}else{
				document.forms[0].pract_to_desc.value="";
				document.forms[0].pract_to.value="";
			}
		}
	}else if (document.forms[0].from_page.value=="bulk"){			
		if(retVal != null && retVal != "" ){
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			if(obj.name=="practitioner_name" || obj.name=="search_pract"){
				document.forms[0].practitioner_name.value=arr[1];
				document.forms[0].practitioner.value=arr[0];
			}else{
				document.forms[0].practitioner_name2.value=arr[1];
				document.forms[0].practitioner2.value=arr[0];
			}
		}else{
			if(obj.name=="practitioner_name" || obj.name=="search_pract"){
				document.forms[0].practitioner_name.value="";
				document.forms[0].practitioner.value="";
			}else{
				document.forms[0].practitioner_name2.value="";
				document.forms[0].practitioner2.value="";
			}

		}
	}else{
		if(retVal != null && retVal != "" ){
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			document.forms[0].practitioner_name.value=arr[1];
			document.forms[0].practitioner.value=arr[0];
			if (document.forms[0].from_page.value=="duty_roaster"){
				Poplocntype(arr[0],arr[1]);
			}
		}else{
			document.forms[0].practitioner_name.value="";
			document.forms[0].practitioner.value="";
		}
	}
	if(document.forms[0].from_page.value=="schedule"){
		checkRoster('1');
	}
}

function onblurcheck1(obj,target,locale){
	/*Added by S.Sathish for IN020571 on Thursday, April 08, 2010 starts  here*/
	if(obj.value == '' && document.forms[0].from_page.value=="query" && document.forms[0].called_from.value=="appt_for_res"){ 
	//parent.frames[1].location.href='../../eCommon/html/blank.html'; //Commented Added Against JD-CRF-0184 [IN:041354] By Saanthaakumar
		if(parent.frames[0].document.forms[0].select)
			if(parent.frames[0].document.forms[0].select.disabled==true)
					parent.frames[0].document.forms[0].select.disabled=false;
	}
	 /*Ends Here*/

	if(document.forms[0].from_page.value=="change_resource"){
		if(target.value == ""){
			if(obj.name=="pract_from_desc"){
				document.forms[0].pract_from.value ="";
				return;
			}
			if(obj.name=="pract_to_desc"){
				document.forms[0].pract_to.value="";
				return;
			}
		}
		if(obj.name=="pract_from_desc"){
			callPractSearch1(document.forms[0].from,target,locale)
		}
		if(obj.name=="pract_to_desc"){
			callPractSearch1(document.forms[0].to,target,locale)
		}
	}else{
		if(target.value == ""){
			if(obj.name!="practitioner_name2"){
				if(document.forms[0].from_page.value=="duty_roaster"){
					document.forms[0].practitioner.value ="";
					clearData();
					return;
				}else{
					document.forms[0].practitioner.value ="";
					if(document.forms[0].from_page.value=="schedule"){
						checkRoster('1');
					}
					return;
				}
			}else{
				document.forms[0].practitioner2.value ="";
				return;
			}
		}
		if(document.forms[0].from_page.value=="schedule"){
			checkRoster('2');
		}
		
		callPractSearch1(obj,target,locale);
		/*Below Line Added for this SCF SCF ML-BRU-SCF-0240 [IN:033238]*/      	
		if(document.forms[0].from_page && document.forms[0].from_page.value=="appt_dairy")
		change_schedule(document.forms[0].practitioner,document.forms[0].practitioner_name);
	}
}

//duplicate functions start on 21-01-2009
function Webonblurcheck(obj,target,locale){
	if(document.forms[0].from_page.value=="change_resource")
	{
	if(target.value == "")
	{
		if(obj.name=="pract_from_desc")
		{
		document.forms[0].pract_from.value ="";
		return;
		}
		if(obj.name=="pract_to_desc")
		{
			document.forms[0].pract_to.value="";
			return;
		}
	}
		if(obj.name=="pract_from_desc"){
		callPractSearch1(document.forms[0].from,target,locale)
		}
		if(obj.name=="pract_to_desc"){
		callPractSearch1(document.forms[0].to,target,locale)
		}
}
else{

	if(target.value == "")
	{
		if(obj.name!="practitioner_name2")
		{
		document.forms[0].practitioner.value ="";
		return;
		}else
		{
		document.forms[0].practitioner2.value ="";
		return;
		}
	}
	WebcallPractSearch(obj,target,locale)
	}
}
function WebcallPractSearch(obj,target,locale)
{
	var practName_FName="";
		var practName_FValue="";
		var practId_FName="";
		practName_FName=target.name;
		practName_FValue=target.value;
		var entval="";
		var practitioner_id1="";
		
		if(document.forms[0].from_page.value =="change_resource")
		{
			practitioner_id1=document.forms[0].pract_from.value;
			entval= document.forms[0].pract_from.value;
		}else
		{	
		if(document.forms[0].from_page.value !="bulk")
			{
			if(obj.name=="practitioner_name" || obj.name=="search_pract")
				{
					practId_FName=document.forms[0].practitioner_name.name;
					entval= document.forms[0].practitioner_name.value;
				}else
				{
					practId_FName=document.forms[0].practitioner_name2.name;
					entval= document.forms[0].practitioner_name2.value;
				}
			}
			else
			{
				practId_FName=document.forms[0].practitioner_name.name;
				entval= document.forms[0].practitioner_name.value;
			}
		}

		var spl_code ="";
		var location1="";


		if(obj.name=="practitioner_name2" || obj.name=="search_pract2")
		{
		spl_code =document.forms[0].specialty_code2.value;
		}
		else
		{
		spl_code =document.forms[0].specialty_code1.value;
		}
		
		
		var pract_type="";
		
		var sql="";
		var sql2="";
		var val    = new Array() ;
		if(obj.name=="practitioner_name2" || obj.name=="search_pract2")
		{
		location1=document.forms[0].location_code2.value;
		}
		else
		{
		location1=document.forms[0].location_code1.value;
		}
		var facilityid = document.forms[0].facilityId.value;


if(document.forms[0].from_page.value =="schedule_appt" || document.forms[0].from_page.value =="transfer_cancel" || document.forms[0].from_page.value =="query" || document.forms[0].from_page.value =="schedule_appt_diff" )
	{
		val = location1.split("$");
		 if (val !=""){
				var clinic_code=val[1].split("$");
				var open_to_all_pract_yn= val[0].split("$");
		}

	}else if(document.forms[0].from_page.value=="bulk")
	{
		val = location1.split("$");
		 if (val !=""){
				var clinic_code=val[1].split("$");
				var open_to_all_pract_yn= val[0].split("$");
				var resource_type= val[3].split("$");
		}
		var clinicType=document.forms[0].locationType1.value;
	}else if(document.forms[0].from_page.value=="block")
	{
		val=location1.split("%");
		
		var clinic_code=val[0];
		var open_to_all_pract_yn= val[2];

	}else if(document.forms[0].from_page.value=="block_lift_cancel" || document.forms[0].from_page.value=="duty_roaster"  || document.forms[0].from_page.value=="change_resource")
	{
if(document.forms[0].from_page.value=="duty_roaster" || document.forms[0].from_page.value=="block_lift_cancel")
{
	location1=document.forms[0].location.value;
}

		val=location1.split("|");
		var clinic_code=val[0];
		var clinic_type=val[1];
		var open_to_all_pract_yn= val[2];
	}else if (document.forms[0].from_page.value=="wait_list_modify")
	{
		location1=document.forms[0].clinic_code.value;
	resource_type=document.forms[0].resourceType1.value;
		val=location1.split("|");
		var clinic_code=val[1];
		var open_to_all_pract_yn= val[0];
		var clinicType= val[2];
	}else
	{
		if(document.forms[0].from_page.value!="reprint")
		{
		val = location1.split("$");
	    if (val !=""){
			var clinic_code=val[0].split("$");
			var clinic_type=val[1].split("$");
			var open_to_all_pract_yn= val[2].split("$");
			var ident_at_checkin= val[3].split("$");
			var fi_visit_type_appl_yn= val[4].split("$");
			var alcn_criteria= val[5].split("$");
		}
		}
	}
	if(document.forms[0].from_page.value!="wait_list_modify" && document.forms[0].from_page.value!="bulk")
		{
		if(document.forms[0].from_page.value!="appt_dairy" )
		{
			
		if(obj.name!="practitioner_name2" || obj.name!="search_pract2")
		{
			
		resource_type=document.forms[0].resourceType1.value;
		}
		else
		{
		resource_type=document.forms[0].resourceType3.value;
		}
		tit= getLabel("Common.resource.label","Common");

		if(obj.name!="practitioner_name2" || obj.name!="search_pract2")
		{
		var clinicType=document.forms[0].locationType1.value;
		}
		else
		{
		var clinicType=document.forms[0].locationType2.value;

		}
		}else
		{
			resource_type=document.forms[0].res_type.value;
			var clinicType=document.forms[0].clinic_type.value;
			open_to_all_pract_yn=document.forms[0].open_to_all_pract_yn.value;
			var clinic_code=document.forms[0].clinic_code.value;
		}
		}
		if (document.forms[0].from_page.value=="wait_list_modify")
	{
		location1=document.forms[0].clinic_code.value;
		resource_type=document.forms[0].resourceType1.value;
		val=location1.split("|");
		var clinic_code=val[1];
		var open_to_all_pract_yn= val[0];
		var clinicType= val[2];
	}
	getPractitioner(obj,target,facilityid,spl_code,pract_type,clinic_code,practitioner_id1,"Q6");

}

//duplicate functions end on 21-01-2009
/********** for report********/

function callPractSearch_rep(obj,target)
{

var practName_FName="";
var practName_FValue="";
var practId_FName=""; 

practName_FName=target.name;
practName_FValue=target.value;
practId_FName=document.forms[0].p_fm_pract_id.name;
var facilityid = document.forms[0].p_facility_id.value;
var p_resource_class1=document.forms[0].p_resource_class1.value;
var locale=document.forms[0].locale.value;

var clinic_code='';
var splty="";
var practitioner_id="";

var sql="";
var sql2="";
var fm_pract_type ="";
var to_pract_type ="";


if(p_resource_class1=='P'){

	if(obj.name=="pract_id" || obj.name=="p_fm_pract_id")
	{
		// Thursday, February 18, 2010 19335 Venkat S.
		if(parent.frames[1].document.forms[0].name=="repAppointmentsForOPD")
		{
			splty = parent.frames[1].document.forms[0].p_fm_speciality_code.value; 
		}
		else if(parent.frames[1].document.forms[0].name=="menu_form") //Friday, March 26, 2010 venkats 20345
		{
			splty = parent.frames[2].document.forms[0].p_fm_speciality.value; 
		}
	else if(parent.frames[1].document.forms[0].name=="ApptStatsPractform") //Friday, March 26, 2010 venkats 20345
		{
			splty = parent.frames[1].document.forms[0].P_FM_SPECIALITY.value; 
		}
		else if(parent.frames[1].document.forms[0].name=="ApptStatsMonthPractform") //Friday, March 26, 2010 venkats 20345
		{
			splty = parent.frames[1].document.forms[0].P_FM_SPECIAL.value; 
		}
		else
		{
			splty = parent.frames[1].document.forms[0].p_fm_speciality.value;
		}

	if(document.forms[0].from_page.value!="reports1")
	{
	fm_pract_type = parent.frames[1].document.forms[0].fm_pract_type.value;
	}else
	{
	fm_pract_type = repTimeTableList.fm_pract_type.value;
	}
	
	getPractitioner(obj,target,facilityid,splty,fm_pract_type,clinic_code,practitioner_id,"Q1");

	}
				
	if(obj.name=="pract_id1" || obj.name=="p_to_pract_id")
	{
		// Thursday, February 18, 2010 19335 Venkat S.
		if(parent.frames[1].document.forms[0].name=="repAppointmentsForOPD")
		{
			splty = parent.frames[1].document.forms[0].p_to_speciality_code.value;
		}
		else if(parent.frames[1].document.forms[0].name=="menu_form") // Friday, March 26, 2010 20345 venkat s
		{
			splty = parent.frames[2].document.forms[0].p_to_speciality.value; 
		}
			else if(parent.frames[1].document.forms[0].name=="ApptStatsPractform") //Friday, March 26, 2010 venkats 20345
		{
			splty = parent.frames[1].document.forms[0].P_TO_SPECIALITY.value; 
		}
		else if(parent.frames[1].document.forms[0].name=="ApptStatsMonthPractform") //Friday, March 26, 2010 venkats 20345
		{
			splty = parent.frames[1].document.forms[0].P_TO_SPECIAL.value; 
		}
		else
		{
			splty = parent.frames[1].document.forms[0].p_to_speciality.value;
		}
	 
	if(document.forms[0].from_page.value!="reports1")
	{
	 to_pract_type = parent.frames[1].document.forms[0].to_pract_type.value;
	}
	else
	{
	to_pract_type = repTimeTableList.to_pract_type.value;
	}
	
	getPractitioner(obj,target,facilityid,splty,to_pract_type,clinic_code,practitioner_id,"Q1");

	}


}
else if(p_resource_class1=='E' || p_resource_class1=='O'){
	// Equipment and others
	if(obj.name=="pract_id" || obj.name=="p_fm_pract_id")
	{
		if(parent.frames[1].document.forms[0].name=="menu_form") // Monday, March 29, 2010 20345 venkat s
		{
		res_type = parent.frames[2].document.forms[0].fm_pract_type.value;
		} else
		{
		res_type = parent.frames[1].document.forms[0].fm_pract_type.value;
		}
	sql="Select resource_id code,SHORT_DESC description  from am_resource_lang_vw where facility_id = '"+facilityid+"' and Resource_Class ='"+p_resource_class1+"' and language_id='"+locale+"' and resource_type=nvl('"+res_type+"',resource_type) and upper(resource_id) like upper(?) and upper(SHORT_DESC)  like upper(?) order by description";
	call_common1(sql,"pract_id");
	}
	else
	{	
		if(parent.frames[1].document.forms[0].name=="menu_form") // Monday, March 29, 2010 20345 venkat s
		{
		res_type = parent.frames[2].document.forms[0].to_pract_type.value;
		} else
		{
		res_type = parent.frames[1].document.forms[0].to_pract_type.value;
		}

		sql="Select resource_id code,SHORT_DESC description  from am_resource_lang_vw where facility_id = '"+facilityid+"' and Resource_Class ='"+p_resource_class1+"' and language_id='"+locale+"' and resource_type=nvl('"+res_type+"',resource_type) and upper(resource_id) like upper(?) and upper(SHORT_DESC)  like upper(?) order by description";
		call_common1(sql,"pract_id1");
	}


}
else if(p_resource_class1=='R'){//Room
if(obj.name=="pract_id" || obj.name=="p_fm_pract_id")
	{
	if(parent.frames[1].document.forms[0].name=="menu_form") // Monday, March 29, 2010 20345 venkat s
		{
		 clinic_code = parent.frames[2].document.forms[0].p_fm_clinic_code.value;
		 res_type = parent.frames[2].document.forms[0].fm_pract_type.value;
		} 
		else
		{
		 clinic_code = parent.frames[1].document.forms[0].p_fm_locn_code.value;
		 res_type = parent.frames[1].document.forms[0].fm_pract_type.value;
		}
		
		sql="select room_num code ,short_desc description from am_facility_room_lang_vw where operating_facility_id = '"+facilityid+"' and room_type=nvl('"+res_type+"',room_type) and language_id='"+locale+"' AND room_num IN ( SELECT DISTINCT practitioner_id FROM am_facility_room_lang_vw a, oa_clinic_schedule b WHERE a.room_num = b.practitioner_id AND a.operating_facility_id = b.facility_id AND a.operating_facility_id = '"+facilityid+"' AND a.language_id = '"+locale+"' AND b.resource_class = 'R') and upper(room_num) like upper(?) and upper(short_desc)  like upper(?) order by short_desc";

		call_common1(sql,"pract_id");
	}
	else
	{
			if(parent.frames[1].document.forms[0].name=="menu_form") // Monday, March 29, 2010 20345 venkat s
		{
		clinic_code = parent.frames[2].document.forms[0].p_to_clinic_code.value;
		res_type = parent.frames[2].document.forms[0].to_pract_type.value;
		} 
		else
		{
		clinic_code = parent.frames[1].document.forms[0].p_to_locn_code.value;
		res_type = parent.frames[1].document.forms[0].to_pract_type.value;
		}
		
		sql="select room_num code ,short_desc description from am_facility_room_lang_vw where operating_facility_id = '"+facilityid+"' and room_type=nvl('"+res_type+"',room_type) and language_id='"+locale+"' AND room_num IN ( SELECT DISTINCT practitioner_id FROM am_facility_room_lang_vw a, oa_clinic_schedule b WHERE a.room_num = b.practitioner_id AND a.operating_facility_id = b.facility_id AND a.operating_facility_id = '"+facilityid+"' AND a.language_id = '"+locale+"' AND b.resource_class = 'R') and upper(room_num) like upper(?) and upper(short_desc)  like upper(?) order by short_desc";
		call_common1(sql,"pract_id1");
	}

	}
    
}


function callPractSearch_rep_bulk(obj,target)
{
var practName_FName="";
var practName_FValue="";
var practId_FName="";

practName_FName=target.name;
practName_FValue=target.value;
practId_FName=document.forms[0].p_fm_pract_id.name;
var facilityid = document.forms[0].fac_id.value;
var locale=document.forms[0].locale.value;

var clinic_code='';
var splty="";
var practitioner_id="";

var sql="";
var sql2="";
var fm_pract_type ="";
var to_pract_type ="";

var p_resource_class1=document.forms[0].resource_class1.value;
var p_resource_class2=document.forms[0].resource_class2.value;

	fm_pract_type="";

	if(obj.name=="pract_id" || obj.name=="p_fm_pract_id")
	{
		if(p_resource_class1=='P'){
		var clinic_code=document.forms[0].P_LOCATION_CODE_FROM.value;
		 splty=document.forms[0].P_SPECIALTY_CODE_FROM.value; // Thursday, February 18, 2010 19335 Venkat S.

		getPractitioner(obj,target,facilityid,splty,fm_pract_type,clinic_code,practitioner_id,"Q7");
		}else if(p_resource_class1=='E' || p_resource_class1=='O'){
			var clinic_code1=document.forms[0].P_LOCATION_CODE_FROM.value;

		//sql="Select resource_id code,SHORT_DESC description  from am_resource_lang_vw where facility_id = '"+facilityid+"' and Resource_Class ='"+p_resource_class1+"' and language_id='"+locale+"' and resource_type=nvl('"+res_type+"',resource_type) and upper(resource_id) like upper(?) and upper(SHORT_DESC)  like upper(?) order by description";

		sql="select b.practitioner_id code,AM_GET_DESC.AM_RESOURCE(b.FACILITY_ID, b.PRACTITIONER_ID,'"+locale+"','2') description from op_pract_for_clinic b where  b.eff_status='E' and b.clinic_code='"+clinic_code1+"' and b.Facility_id='"+facilityid+"' and b.RESOURCE_CLASS='"+p_resource_class1+"' and upper(b.practitioner_id) like upper(?) and upper(AM_GET_DESC.AM_RESOURCE(b.FACILITY_ID, b.PRACTITIONER_ID,'"+locale+"','2'))  like upper(?) order by description";

		call_common1(sql,"pract_id");
		}else if(p_resource_class1=='R'){//Room
			
			//sql="select room_num code ,short_desc description from am_facility_room_lang_vw where operating_facility_id = '"+facilityid+"' and room_type=nvl('"+res_type+"',room_type) and language_id='"+locale+"' and upper(room_num) like upper(?) and upper(short_desc)  like upper(?) order by short_desc";
			var clinic_code1=document.forms[0].P_LOCATION_CODE_FROM.value;
			sql="select Practitioner_id code, AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2') description from op_pract_for_clinic where clinic_code='"+clinic_code1+"' and Facility_id ='"+facilityid+"' and resource_class='R' and eff_status='E' and upper(practitioner_id) like upper(?) and upper(AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'))  like upper(?) order by  description";
			call_common1(sql,"pract_id");
		}
	

	}else
	{
		if(p_resource_class2=='P'){
	var clinic_code=document.forms[0].P_LOCATION_CODE_TO.value;
	splty=document.forms[0].P_SPECIALTY_CODE_TO.value; 	// Thursday, February 18, 2010 19335 Venkat S.

	getPractitioner(obj,target,facilityid,splty,fm_pract_type,clinic_code,practitioner_id,"Q7");
		}else if(p_resource_class2=='E' || p_resource_class2=='O')
		{
			var clinic_code2=document.forms[0].P_LOCATION_CODE_TO.value;
		sql="select b.practitioner_id code,AM_GET_DESC.AM_RESOURCE(b.FACILITY_ID, b.PRACTITIONER_ID,'"+locale+"','2') description from op_pract_for_clinic b where  b.eff_status='E' and b.clinic_code='"+clinic_code2+"' and b.Facility_id='"+facilityid+"' and b.RESOURCE_CLASS='"+p_resource_class1+"' and upper(b.practitioner_id) like upper(?) and upper(AM_GET_DESC.AM_RESOURCE(b.FACILITY_ID, b.PRACTITIONER_ID,'"+locale+"','2'))  like upper(?) order by description";

		call_common1(sql,"pract_id");
		}else if(p_resource_class2=='R'){
			var clinic_code2=document.forms[0].P_LOCATION_CODE_TO.value;
			sql="select Practitioner_id code, AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2') description from op_pract_for_clinic where clinic_code='"+clinic_code2+"' and Facility_id ='"+facilityid+"' and resource_class='R' and eff_status='E' and upper(practitioner_id) like upper(?) and upper(AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'))  like upper(?) order by  description";
			call_common1(sql,"pract_id");
		}
	}

    
}


async function call_common1(sql,objName){
		
	var tit				= getLabel("Common.resource.label","Common");
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var yyy;
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	
		
	if(objName=="pract_id")
	{     
	argumentArray[5] = document.forms[0].p_fm_pract_id.value;
	}
	else {
	argumentArray[5] = document.forms[0].p_to_pract_id.value;
	}
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		if(objName=="pract_id"){
		document.forms[0].p_fm_pract_id.value=arr[0];
		}
		else{
		document.forms[0].p_to_pract_id.value=arr[0];
		}
		}
	
	else{
		
		if(objName=="pract_id")
		{
	document.forms[0].p_fm_pract_id.focus();
	document.forms[0].p_fm_pract_id.value="";
		}
		else	
		{
			document.forms[0].p_to_pract_id.focus();
			document.forms[0].p_to_pract_id.value="";
		}
	}
}




function onblurcheck_rep(obj,target)
{
	if(target.value == "")
	{
		if(obj.name=="p_fm_pract_id")
		{
		document.forms[0].p_fm_pract_id.value ="";
		return;
		}
		if(obj.name=="p_to_pract_id")
		{
			document.forms[0].p_to_pract_id.value="";
			return;
		}
	}
	
	callPractSearch_rep(obj,target)
}

 function onblurcheck_rep_bulk(obj,target)
{
	if(target.value == "")
	{
		if(obj.name=="p_fm_pract_id")
		{
		document.forms[0].p_fm_pract_id.value ="";
		return;
		}
		if(obj.name=="p_to_pract_id")
		{
			document.forms[0].p_to_pract_id.value="";
			return;
		}
	}
	// Thursday, February 18, 2010 19335 Venkat S.
	callPractSearch_rep_bulk(obj,target)
	//callPractSearch_rep_listappt(obj,target)
}


function callPractSearch_rep_listappt(obj,target)
{
var practName_FName="";
var practName_FValue="";
var practId_FName="";

practName_FName=target.name;
practName_FValue=target.value;
practId_FName=document.forms[0].P_FM_PRACT_ID.name;
var facilityid = document.forms[0].P_FACILITY_ID.value;
var locale=document.forms[0].locale.value;

var clinic_code='';
var splty="";
var practitioner_id="";

var sql="";
var sql2="";
var fm_pract_type ="";
var to_pract_type ="";
//var clinic_code=document.forms[0].P_LOCATION_CODE_FROM.value;
//var p_resource_class1=document.forms[0].resource_class1.value;
//var p_resource_class2=document.forms[0].resource_class2.value;

	fm_pract_type="";




		var clinic_code=document.forms[0].P_LOCATION_CODE_FROM.value;

		getPractitioner(obj,target,facilityid,splty,fm_pract_type,clinic_code,practitioner_id,"Q14");

	

	
    
}


	function onblurcheck_rep_listappt(obj,target)
{
	if(target.value == "")
	{
		if(obj.name=="P_FM_PRACT_ID")
		{
		document.forms[0].P_FM_PRACT_ID.value ="";
		return;
		}
		if(obj.name=="P_TO_PRACT_ID")
		{
		document.forms[0].P_TO_PRACT_ID.value ="";
		return;
		}
		
	}
	
	callPractSearch_rep_listappt(obj,target)
}

function resource_search(obj,target,locale){
	document.forms[0].practitioner.value='';
	if(obj.value !=''){
		resource_search_lookup(obj,target,locale);
	}else{
		document.forms[0].practitioner_name.value='';
	}
}

function resource_search_lookup(obj,target,locale){
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";
	practName_FName=target.name;
	practName_FValue=target.value;
	var entval="";
	var practitioner_id1="";
	practId_FName=document.forms[0].practitioner_name.name;
	entval= document.forms[0].practitioner_name.value;
	var spl_code =document.forms[0].specialty_code.value;
	var pract_type="";
	var sql="";
	var sql2="";
	var val    = new Array() ;
	var clinic_code=document.forms[0].location.value;
	var open_to_all_pract_yn= document.forms[0].open_to_all_pract_yn.value;
	var resource_type=document.forms[0].resource_type.value;
	var clinicType=document.forms[0].location_type.value;
	var facilityid = document.forms[0].facilityid.value;
	if(clinic_code==''){
		open_to_all_pract_yn='Y';
	}	
	if(resource_type=='P'){
		if( open_to_all_pract_yn=="Y"){
			if(clinic_code!=""){
				getPractitioner(obj,target,facilityid,spl_code,pract_type,clinic_code,practitioner_id1,"Q3");
			}else{
				getPractitioner(obj,target,facilityid,spl_code,pract_type,clinic_code,practitioner_id1,"Q6");
			}
		}else{
			getPractitioner(obj,target,facilityid,spl_code,pract_type,clinic_code,practitioner_id1,"Q12");
		}
	}else{
		if(resource_type=='E' || resource_type=='O'){
			if( open_to_all_pract_yn!="Y"){
				sql="select b.practitioner_id code,AM_GET_DESC.AM_RESOURCE(b.FACILITY_ID, b.PRACTITIONER_ID,'"+locale+"','2') description from op_pract_for_clinic b where  b.eff_status='E' and b.clinic_code='"+clinic_code+"' and b.Facility_id='"+facilityid+"' and b.RESOURCE_CLASS='"+resource_type+"' and upper(b.practitioner_id) like upper(?) and upper(AM_GET_DESC.AM_RESOURCE(b.FACILITY_ID, b.PRACTITIONER_ID,'"+locale+"','2'))  like upper(?) order by description";							
			}else{
				sql="Select resource_id code,SHORT_DESC description  from am_resource_lang_vw where facility_id = '"+facilityid+"' and Resource_Class ='"+resource_type+"' and language_id='"+locale+"'  and upper(resource_id) like upper(?) and upper(SHORT_DESC)  like upper(?) order by description";						
			}		
		}else if(resource_type=='R'){
			if( open_to_all_pract_yn!="Y"){
				sql="select Practitioner_id code, AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2') description from op_pract_for_clinic where clinic_code='"+clinic_code+"' and Facility_id ='"+facilityid+"' and resource_class='R' and eff_status='E' and upper(practitioner_id) like upper(?) and upper(AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'))  like upper(?) order by  description";
			}else{
				sql="select room_num code ,short_desc description from am_facility_room_lang_vw where operating_facility_id = '"+facilityid+"'  and language_id='"+locale+"' and upper(room_num) like upper(?) and upper(short_desc)  like upper(?) order by short_desc";
			}
		}
		call_common(sql,obj);
	}
}
