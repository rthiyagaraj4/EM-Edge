function run() 
{
	var fields = new Array(f_query_add_mod.document.forms[0].p_fm_date,f_query_add_mod.document.forms[0].p_to_date);
	var names = new Array(getLabel("Common.Period.label","Common")+" "+getLabel("Common.from.label","Common"),getLabel("Common.Period.label","Common")+" "+getLabel("Common.to.label","Common"));	
	if(f_query_add_mod.checkFields(fields,names,messageFrame))
	{
		if(chkGrtr(f_query_add_mod.document.forms[0].p_fm_date,f_query_add_mod.document.forms[0].p_to_date)==true)	
		if(f_query_add_mod.CheckString( getLabel("Common.SpecialtyCode.label",'Common'),f_query_add_mod.document.forms[0].p_fm_specialty_code,f_query_add_mod.document.forms[0].p_to_specialty_code,messageFrame))
		if(f_query_add_mod.CheckString( getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.forms[0].p_fm_locn_code,f_query_add_mod.document.forms[0].p_to_locn_code,messageFrame))
		if(f_query_add_mod.CheckString( getLabel("Common.referralsource.label","Common"),f_query_add_mod.document.forms[0].p_fm_ref_source,f_query_add_mod.document.forms[0].p_to_ref_source,messageFrame))
			{					
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
			f_query_add_mod.document.forms[0].target="messageFrame";	 
			f_query_add_mod.document.forms[0].submit();	
		}
	}
}
function chkGrtr(obj1,obj2)
{
	if(isBefore(obj1.value,obj2.value,"DMY",localeName)==false)
	{
		var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");
		messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
        return false;
	}
	else 
		return true;
}

function reset() 
{
	f_query_add_mod.document.location.reload();
}


function setDate(Object)
{ 
	parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
    if(Object.value!=""){
	   if (isBeforeNow(Object.value,"DMY",localeName)){
          return true;
        }
        else{
          alert(getMessage("DATE_NOT_GREATER_SYSDATE",'common'));
		  Object.value="";
          Object.focus();            
        }
    }
}

async function searchCode(obj,target)
{
   var tit="";
   var p_faclid =document.forms[0].P_facilityid.value;
   var p_usr = document.forms[0].p_user_name.value;
   var p_resp = document.forms[0].p_resp_id.value;
   var locale=document.forms[0].locale.value;
   var location_type=document.forms[0].p_location_type.value;
   target.value=trimString(target.value);
   
   if(target.value=="" && window.event.target == target)
   return;
	
   var argumentArray=new Array(8);
	
	if(obj.name=="tospecialty" || obj.name=="fromspecialty")
    {
        tit=getLabel("Common.speciality.label","Common");
		
        
		argumentArray[0]="select speciality_code code, short_desc description from am_speciality_lang_vw where '1' like ? and language_id='"+locale+"' and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
        
		argumentArray[1]=new Array("'1'");
		argumentArray[2]=new Array("1");
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;

    }
	else if(obj.name=="tolocn" || obj.name=="fromlocn")
	{
		tit=getLabel("Common.Location.label","Common");

		if(obj.name=="tolocn")
			sp=document.forms[0].p_to_specialty_code.value;
		else if(obj.name=="fromlocn")
			sp=document.forms[0].p_fm_specialty_code.value;		

		 if(location_type == "N"){
			argumentArray[0]="Select a.nursing_unit_code code,a.long_desc description from ip_nursing_unit_lang_vw a,ip_nurs_unit_for_specialty b where a.facility_id = b.facility_id and a.nursing_unit_code = b.nursing_unit_code and b.specialty_code ='"+sp+"' and  a.language_id='"+locale+"' and (('"+p_faclid+"' like ? and a.facility_id in (select facility_id from sm_facility_for_user where appl_user_id like ? intersect select facility_id from sm_facility_for_resp where resp_id like ? )) or ('" + p_faclid + "' != ? and a.facility_id like ?)) and a.eff_status = 'E' and a.locn_type='N' and a.Patient_Class = 'IP' and upper(a.nursing_unit_code) like upper(?) and upper(a.long_desc) like upper(?) order by 1"
		}else{
			argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where language_id='"+locale+"' and (('"+p_faclid+"' like ? and facility_id in (select facility_id from sm_facility_for_user where appl_user_id like ? intersect select facility_id from sm_facility_for_resp where resp_id like ? )) or ('" + p_faclid + "' != ? and facility_id like ?)) and speciality_code = '"+sp+"' and clinic_type='"+location_type+"' and eff_status='E' and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";
		}

        argumentArray[1]=new Array("'"+p_faclid+"'","appl_user_id","resp_id","'"+p_faclid+"'","facility_id");
		argumentArray[2]=new Array("All",p_usr,p_resp,"All",p_faclid);
		argumentArray[3]=new Array(STRING,STRING,STRING,STRING,STRING);
		argumentArray[4]="6,7";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;

	}	
	var retVal=await CommonLookup(tit,argumentArray);

	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if(retVal==null || retVal=="")
				target.value="";
			else
				target.value=arr[0];
}
function getval(obj){
	
	    document.forms[0].p_fm_ref_source.value="";
		document.forms[0].p_fm_ref_source.disabled=false;
		document.forms[0].referralfrm.disabled=false;
		document.forms[0].p_to_ref_source.value="";
		document.forms[0].p_to_ref_source.disabled=false;
		document.forms[0].referralto.disabled=false;		
		document.forms[0].p_fm_ref_source_code.value='';	
		document.forms[0].p_to_ref_source_code.value='';	

	var ref_type=document.forms[0].p_referral_type.value;
	var hcareType=document.forms[0].p_hcare_type.value;		
	
		
		if(obj.name=='p_referral_type'){
			document.forms[0].p_hcare_type.options[0].selected=true;			
			document.forms[0].p_hcare_type.disabled=false;
		}        
		if (ref_type=="")
		{
		    document.forms[0].p_fm_ref_source.disabled=false;
		    document.forms[0].referralfrm.disabled=false;
		    document.forms[0].p_to_ref_source.disabled=false;
		    document.forms[0].referralto.disabled=false;

			document.forms[0].referral_source_lkp_bkup_text_frm.value='';
			document.forms[0].referral_source_lkp_id_frm.value='';

			document.forms[0].referral_source_lkp_bkup_text_to.value='';
			document.forms[0].referral_source_lkp_id_to.value='';
		}	
			
		if(ref_type == 'X' || ref_type == 'E' ||ref_type == 'L')
		{			
		if(ref_type=="X"){	
			document.forms[0].p_hcare_type.disabled=false;
			
			document.forms[0].referral_source_lkp_bkup_text_frm.value='';
			document.forms[0].referral_source_lkp_id_frm.value='';

			document.forms[0].referral_source_lkp_bkup_text_to.value='';
			document.forms[0].referral_source_lkp_id_to.value='';
		}
		else if(ref_type=="E" || ref_type == "L")
		{		 
				if(ref_type=="E")	
					document.forms[0].p_hcare_type.disabled=false;
				else				
					document.forms[0].p_hcare_type.disabled=true;	
		}
		var hcare_type="";
		if(ref_type=="E" || ref_type == "X")
		{
			document.forms[0].p_hcare_type.disabled=false;
			document.forms[0].p_fm_ref_source.disabled=false;
			document.forms[0].referralfrm.disabled=false;
			document.forms[0].p_to_ref_source.disabled=false;
			document.forms[0].referralto.disabled=false;
			hcare_type=document.forms[0].p_hcare_type.value;
		}
      	
		HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eOP/jsp/RegPatRefValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='9'><input name='ref_type' id='ref_type' type='hidden' value='"+ref_type + "'><input name='hcare_type' id='hcare_type' type='hidden' value='"+hcare_type + "'><input name='function_name' id='function_name' type='hidden' value='ReferredOutPatientStatistics'></form></BODY></HTML>";		
		
		parent.messageFrame.document.write(HTMLVal);
		parent.messageFrame.document.form1.submit();
		}
	
}
async function referralSourceLookup(obj){
	var retVal			= new String();	

	var dialogTop			= "240";
	var dialogHeight		= "400px" ;
	var dialogWidth			= "750px" ;
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql					= "";
	var sql1				= "";	
	var target=obj;
	
	var title=getLabel("Common.referralsource.label","common");
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
	var target='';
	var facilityid=document.forms[0].p_facility_id.value;	
	if(obj.name=='referralfrm')
	   target=document.forms[0].p_fm_ref_source;
	else
		target=document.forms[0].p_to_ref_source;
	var ref_type=document.forms[0].p_referral_type.value;
	var hcareType=document.forms[0].p_hcare_type.value;
	var locale=document.forms[0].locale.value;
	var sql = '';
	var param='';

	if(ref_type==''){
		var error= getMessage("CAN_NOT_BE_BLANK",'Common').replace('$','Referral Type')+ "\n" ;
		alert(error)
		document.forms[0].p_referral_type.focus();
		if(obj.name=='referralfrm')
			document.forms[0].p_fm_ref_source.value="";
		else
			document.forms[0].p_to_ref_source.value="";
	}else{
		if(hcareType==''){
			var error= getMessage("CAN_NOT_BE_BLANK",'Common').replace('$','Healthcare Setting Type')+ "\n" ;
			alert(error)
			document.forms[0].p_hcare_type.focus();
			if(obj.name=='referralfrm')
				document.forms[0].p_fm_ref_source.value="";
			else
				document.forms[0].p_to_ref_source.value="";

		}else{

			if(ref_type=='L'){
				sql="select nvl(a.FACILITY_ID,'') referred_to_id,nvl(a.FACILITY_NAME,'') referred_to_id_desc ,nvl(a.hcare_setting_type_code,'') hcare_setting_type_code,nvl(b.short_desc,'') hcare_setting_type_desc,nvl(a.hcare_setting_type_code,'') hcare_setting_type_code from SM_FACILITY_PARAM_LANG_VW a, AM_HCARE_SETTING_TYPE_LANG_VW b where a.hcare_setting_type_code=b.hcare_setting_type_code and a.hcare_setting_type_code in ( select to_hcare_setting_type_code from am_hcare_setting_type_rstrn where from_hcare_setting_type_code = (select hcare_setting_type_code from SM_FACILITY_PARAM where facility_id = ? ) and (ip_referral_yn = 'Y'  or op_referral_yn = 'Y') ) and a.language_id=? and b.language_id=? and a.facility_id=? ";

				var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+escape(sql)+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&facilityid="+facilityid+"&ref_type="+ref_type+"&hcareType="+hcareType+"&locale="+locale+"&srch_by_clmn_index=2"+"&col_show_hide=YYNNN";

			}else if(ref_type=='X'){
				sql="Select nvl(a.REFERRAL_CODE,'') referred_to_id,nvl(a.short_desc,'') referred_to_id_short_desc, nvl(a.LONG_DESC,'') referred_to_id_desc,nvl(a.long_name,'') long_name ,nvl(a.HEALTHCARE_SETTING_TYPE,'') hcare_setting_type_code  from am_referral_lang_vw  a, am_hcare_setting_type_lang_vw   b where a.healthcare_setting_type = b.hcare_setting_type_code and nvl(a.dest_use_at_concl_yn,'N') = 'Y' and a.eff_status = 'E' and  a.healthcare_setting_type=?   and a.language_id=? and b.language_id=? ";
				
				var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+escape(sql)+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&facilityid="+facilityid+"&ref_type="+ref_type+"&hcareType="+hcareType+"&locale="+locale+"&srch_by_clmn_index=3"+"&col_show_hide=YYYYN";

			}else if(ref_type=='E'){
				sql="SELECT nvl(a.FACILITY_ID,'') referred_to_id ,nvl(a.FACILITY_NAME,'') referred_to_id_desc   ,nvl(a.hcare_setting_type_code,'') hcare_setting_type_code, nvl(b.short_desc,'') hcare_setting_type_desc,nvl(a.hcare_setting_type_code,'') hcare_setting_type_code FROM SM_FACILITY_PARAM_LANG_VW a  , AM_HCARE_SETTING_TYPE_LANG_VW b WHERE a.facility_id != ?  AND a.hcare_setting_type_code=?   AND a.hcare_setting_type_code=b.hcare_setting_type_code   AND a.hcare_setting_type_code IN  (SELECT to_hcare_setting_type_code FROM    am_hcare_setting_type_rstrn   WHERE from_hcare_setting_type_code =  a.HCARE_SETTING_TYPE_CODE AND (ip_referral_yn = 'Y' OR op_referral_yn = 'Y'    )   )   AND a.language_id=?  AND b.language_id=? "
				
				var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+escape(sql)+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&facilityid="+facilityid+"&ref_type="+ref_type+"&hcareType="+hcareType+"&locale="+locale+"&srch_by_clmn_index=2"+"&col_show_hide=YYNNN";

			}	


			retVal=await window.showModalDialog("../../eAM/jsp/ReferralSourceLookupFrames.jsp?calling_from=create&"+param,arguments,features);
			
			if(retVal){
				var ret_array = retVal.split("^~^");
						if(obj.name=='referralfrm'){
							document.forms[0].referral_source_lkp_id_frm.value=ret_array[4]+'~'+ret_array[0];
							document.forms[0].p_fm_ref_source_code.value=ret_array[0];	
						}
						else{
							document.forms[0].referral_source_lkp_id_to.value=ret_array[4]+'~'+ret_array[0];
							document.forms[0].p_to_ref_source_code.value=ret_array[0];
						}				

				if(ref_type=='X'){
					if(obj.name=='referralfrm'){
						document.forms[0].p_fm_ref_source.value=ret_array[2];
						document.forms[0].referral_source_lkp_bkup_text_frm.value=ret_array[2];
					}else{
						document.forms[0].p_to_ref_source.value=ret_array[2];	
						document.forms[0].referral_source_lkp_bkup_text_to.value=ret_array[2];
					}
				}else{
					if(obj.name=='referralfrm'){
						document.forms[0].p_fm_ref_source.value=ret_array[1];
						document.forms[0].referral_source_lkp_bkup_text_frm.value=ret_array[1];
					}else{
						document.forms[0].p_to_ref_source.value=ret_array[1];	
						document.forms[0].referral_source_lkp_bkup_text_to.value=ret_array[1];
					}					
				}	
			}
		}
	}	
}
function clear_ref(obj){

	if(obj.name=='p_fm_ref_source'){
		if(obj.value==''){			
			document.forms[0].p_fm_ref_source.value="";
			document.forms[0].p_fm_ref_source_code.value="";
			document.forms[0].referral_source_lkp_id_frm.value="";
		}else{		
			referralSourceLookup(document.forms[0].referralfrm)
		}
	}
	else if(obj.name=='p_to_ref_source'){
		if(obj.value==''){			
			document.forms[0].p_to_ref_source.value="";
			document.forms[0].p_to_ref_source_code.value="";
			document.forms[0].referral_source_lkp_id_to.value="";
		}else{		
			referralSourceLookup(document.forms[0].referralto)
		}
	}
}

