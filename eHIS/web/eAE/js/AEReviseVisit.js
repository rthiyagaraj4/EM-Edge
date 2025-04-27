  function reset()
  {
		searchCriteria.SearchVisit.reset();
		document.location.reload();
  }
// Added/Modified By Nanda 10/23/2002 
function AECheckMaxLen(lab,obj,max,messageFrame) 
{		
	  if(obj.value.length > max) { 
		  var error=getMessage("REMARKS_CANNOT_EXCEED",'Common');		  
		  error=error.replace("$",lab);
		  error=error.replace("#",max)			  
			//messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=APP-SM0045 - " + lab + " cannot exceed " + max  + " characters" ;
			top.content.frames[4].location.href="../../eCommon/jsp/error.jsp?err_num="+error ;
			return false;
		} else return true;
}
 
function callCheckMaxLen(obj,noOfChars,Legend)
{
	if(AECheckMaxLen(Legend,obj,noOfChars,top.content.frames[1])==false)
	{
		top.content.frames[3].document.getElementById("ArriveTab").style.display='inline';		
		obj.focus();
		return false;
	}
	else 
	{
		top.content.frames[4].location.href="../../eCommon/jsp/error.jsp";
		return true;
	}  
}

  function apply()
  {
        top.content.frames[3].document.forms[0].empyr_employment_status.disabled=false;
		top.content.frames[3].document.forms[0].referal_id.disabled=false;
		top.content.frames[3].document.forms[0].occ_of_per.disabled=false;
		top.content.frames[3].document.forms[0].first_contact_relation.disabled=false;
		top.content.frames[3].document.forms[0].next_country1.disabled=false;

		remarks			 = top.content.frames[3].document.forms[0].arrival_remarks;
		var	returnval	 = callCheckMaxLen(remarks,2000,getLabel("Common.remarks.label","Common"));
		var errs="";
		var flag=false;

		//below block implementing for icn:20409

		if(top.content.frames[3].document.forms[0].nat_id_no)  
	{
		if(top.content.frames[3].document.forms[0].nat_id_no.value != "")
		{
			var nat_id_check_digit_id="";
			var validate_len_yn="";
			var nat_id_prompt="";

				var Nat_Id=top.content.frames[3].document.forms[0].nat_id_no ;
				if(top.content.frames[3].document.forms[0].nat_id_check_digit_id)
					nat_id_check_digit_id=top.content.frames[3].document.forms[0].nat_id_check_digit_id.value ;
				if(top.content.frames[3].document.forms[0].nat_id_chk_len)
					validate_len_yn=top.content.frames[3].document.forms[0].nat_id_chk_len.value ;
				if(top.content.frames[3].document.forms[0].nat_id_prompt)
					nat_id_prompt=top.content.frames[3].document.forms[0].nat_id_prompt.value ;

				var Nat_IdName = Nat_Id.name;
				var isNumber = new Boolean();
				isNumber = true;
				var ind = -1;

				if ( Nat_Id.value.length > 0 )
				{
					if ( (ind = Nat_Id.value.indexOf('X')) != -1)
					{
						if (ind < 12)           // X can be entered only at 13th position
						{
							msg = getMessage('INVALID_NAT_ID','MP');
							msg = msg.replace("#",nat_id_prompt);
							Nat_Id.focus();
							errs=msg;
							return false;
						}
					}
				}

			if ( isNumber )
			{
			   var nid = new String();
			   nid = trimString(Nat_Id.value);
			   Nat_Id.value = nid;

			   if(validate_len_yn == "Y")
			   if ( nid.length == Nat_Id.maxLength )   isNumber = true
			   else
					isNumber = false

				    if ( nid.length != Nat_Id.maxLength )
						 isNumber = false

					if(isNumber && Nat_Id.value!='')
					{
					  var NatIdFlag = "Y"; 
					 
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						var param="callfunc=Reg&Nat_IdName="+Nat_IdName+"&Nat_Id="+Nat_Id.value+"&nat_id_check_digit_id="+nat_id_check_digit_id+"&NatIdFlag="+NatIdFlag+"&nat_id_prompt="+nat_id_prompt

						var temp_jsp="../../eAE/jsp/AEcommonValidation.jsp?"+param;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest() ;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST",temp_jsp,false);
						xmlHttp.send(xmlDoc);
						var retVal=trimString(xmlHttp.responseText);
						
						
						if(retVal=='N')
						{
							 var msg = getMessage("INVALID_NAT_ID","MP");
							 msg = msg.replace('#',nat_id_prompt);
							errs=msg;
							
						}
					

					}
					else
						{
							if ( Nat_Id.value != '' )
							{
								var val = getMessage("NAT_ID_CHARS",'MP');
								val = val.replace("@",top.content.frames[3].document.forms[0].nat_id_no.maxLength);
								val = val.replace("#",nat_id_prompt)
								errs=val;
							//	Nat_Id.focus();
							}
						}
			}

	}

}

if( top.content.frames[3].document.forms[0].contact1_new_nat_id_no)
	  {

		if(top.content.frames[3].document.forms[0].contact1_new_nat_id_no.value != "")
		{
			var nat_id_check_digit_id="";
			var validate_len_yn="";
			var nat_id_prompt="";

				var Nat_Id=top.content.frames[3].document.forms[0].contact1_new_nat_id_no ;
				if(top.content.frames[3].document.forms[0].nat_id_check_digit_id)
					nat_id_check_digit_id=top.content.frames[3].document.forms[0].nat_id_check_digit_id.value ;
				if(top.content.frames[3].document.forms[0].nat_id_chk_len)
					validate_len_yn=top.content.frames[3].document.forms[0].nat_id_chk_len.value ;
				if(top.content.frames[3].document.forms[0].nat_id_prompt)
					nat_id_prompt=top.content.frames[3].document.forms[0].nat_id_prompt.value ;

				var Nat_IdName = Nat_Id.name;
				var isNumber = new Boolean();
				isNumber = true;
				var ind = -1;

				if ( Nat_Id.value.length > 0 )
				{
					if ( (ind = Nat_Id.value.indexOf('X')) != -1)
					{
						if (ind < 12)           // X can be entered only at 13th position
						{
							msg = getMessage('INVALID_NAT_ID','MP');
							msg = msg.replace("#",nat_id_prompt);
							Nat_Id.focus();
							errs=msg;
							return false;
						}
					}
				}

			if ( isNumber )
			{
			   var nid = new String();
			   nid = trimString(Nat_Id.value);
			   Nat_Id.value = nid;

			   if(validate_len_yn == "Y")
			   if ( nid.length == Nat_Id.maxLength )   isNumber = true
			   else
					isNumber = false

				    if ( nid.length != Nat_Id.maxLength )
						 isNumber = false

					if(isNumber && Nat_Id.value!='')
					{
					  var NatIdFlag = "Y"; 
					 
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						var param="callfunc=Reg&Nat_IdName="+Nat_IdName+"&Nat_Id="+Nat_Id.value+"&nat_id_check_digit_id="+nat_id_check_digit_id+"&NatIdFlag="+NatIdFlag+"&nat_id_prompt="+nat_id_prompt

						var temp_jsp="../../eAE/jsp/AEcommonValidation.jsp?"+param;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest() ;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST",temp_jsp,false);
						xmlHttp.send(xmlDoc);
						var retVal=trimString(xmlHttp.responseText);
						//alert(retVal);
						
						if(retVal=='N')
						{
							 var msg = getMessage("INVALID_NAT_ID","MP");
							 msg = msg.replace('#',nat_id_prompt);
							errs=msg;
							
						}
					

					}
					else
						{
							if ( Nat_Id.value != '' )
							{
								var val = getMessage("NAT_ID_CHARS",'MP');
								val = val.replace("@",top.content.frames[3].document.forms[0].contact1_new_nat_id_no.maxLength);
								val = val.replace("#",nat_id_prompt)
								errs=val;
								//Nat_Id.focus();
							}
						}
			}

	}

	  }

	  if( top.content.frames[3].document.forms[0].contact2_nat_id_no)
	  {

		if(top.content.frames[3].document.forms[0].contact2_nat_id_no.value != "")
		{
			var nat_id_check_digit_id="";
			var validate_len_yn="";
			var nat_id_prompt="";

				var Nat_Id=top.content.frames[3].document.forms[0].contact2_nat_id_no ;
				if(top.content.frames[3].document.forms[0].nat_id_check_digit_id)
					nat_id_check_digit_id=top.content.frames[3].document.forms[0].nat_id_check_digit_id.value ;
				if(top.content.frames[3].document.forms[0].nat_id_chk_len)
					validate_len_yn=top.content.frames[3].document.forms[0].nat_id_chk_len.value ;
				if(top.content.frames[3].document.forms[0].nat_id_prompt)
					nat_id_prompt=top.content.frames[3].document.forms[0].nat_id_prompt.value ;

				var Nat_IdName = Nat_Id.name;
				var isNumber = new Boolean();
				isNumber = true;
				var ind = -1;

				if ( Nat_Id.value.length > 0 )
				{
					if ( (ind = Nat_Id.value.indexOf('X')) != -1)
					{
						if (ind < 12)           // X can be entered only at 13th position
						{
							msg = getMessage('INVALID_NAT_ID','MP');
							msg = msg.replace("#",nat_id_prompt);
							Nat_Id.focus();
							errs=msg;
							return false;
						}
					}
				}

			if ( isNumber )
			{
			   var nid = new String();
			   nid = trimString(Nat_Id.value);
			   Nat_Id.value = nid;

			   if(validate_len_yn == "Y")
			   if ( nid.length == Nat_Id.maxLength )   isNumber = true
			   else
					isNumber = false

				    if ( nid.length != Nat_Id.maxLength )
						 isNumber = false



					if(isNumber && Nat_Id.value!='')
					{
					  var NatIdFlag = "Y"; 
					 
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						var param="callfunc=Reg&Nat_IdName="+Nat_IdName+"&Nat_Id="+Nat_Id.value+"&nat_id_check_digit_id="+nat_id_check_digit_id+"&NatIdFlag="+NatIdFlag+"&nat_id_prompt="+nat_id_prompt

						var temp_jsp="../../eAE/jsp/AEcommonValidation.jsp?"+param;
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest() ;
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST",temp_jsp,false);
						xmlHttp.send(xmlDoc);
						var retVal=trimString(xmlHttp.responseText);
						//alert(retVal);
						
						if(retVal=='N')
						{
							 var msg = getMessage("INVALID_NAT_ID","MP");
							 msg = msg.replace('#',nat_id_prompt);
							errs=msg;
							
						}
					

					}
					else
						{
							if ( Nat_Id.value != '' )
							{
								var val = getMessage("NAT_ID_CHARS",'MP');
								val = val.replace("@",top.content.frames[3].document.forms[0].contact2_nat_id_no.maxLength);
								val = val.replace("#",nat_id_prompt)
								errs=val;
							//	Nat_Id.focus();
							}
						}
			}

	}

	  }

		/*Added by Thamizh selvi on 6th Aug 2018 against ML-MMOH-CRF-1177 Start*/
		if(top.content.frames[3].document.forms[0].isAutoPopulateNOKDOBAppl.value == 'true' && top.content.frames[3].document.forms[0].contact1_birth_date && top.content.frames[3].document.forms[0].contact1_birth_date.value!="") {
			if (!top.content.frames[3].isBeforeNow(top.content.frames[3].document.forms[0].contact1_birth_date.value,"DMY",localeName)) 
			{
				var errMsg = top.content.frames[3].getMessage('DOB_CHECK','Common');
				var repMsg = getLabel('eMP.NOK.label','MP')+" "+getLabel('Common.date.label','common');
				errMsg = errMsg.replace('Date', repMsg);
				errs += errMsg + ' <br>';
			}
		}if (top.content.frames[3].document.forms[0].isAutoPopulateNOKDOBAppl.value == 'true' && top.content.frames[3].document.forms[0].contact1_new_nat_id_no.value.length >= 6){
			
			var dob1 = top.content.frames[3].document.forms[0].contact1_birth_date.value;
			dob1 = dob1.substring(8,10) + dob1.substring(3,5) + dob1.substring(0,2);
			
			if ( (top.content.frames[3].document.forms[0].natDataSourceId.value=="NRIC") && (top.content.frames[3].document.forms[0].natInvokeRoutine.value=="Y") &&  (dob1 != top.content.frames[3].document.forms[0].contact1_new_nat_id_no.value.substring(0,6)) ){
				var natmsg = top.content.frames[3].getMessage('MISMATCH_NAT_DOB','MP');
				natmsg = natmsg.replace('#', top.content.frames[3].document.forms[0].nat_id_prompt.value);
				errs += natmsg + ' ' + getLabel('Common.in.label','common')+ " " +getLabel('Common.nextofkin.label','common')+' <br>';
			}
		}/*End*/

		if(errs=="")
	  {
		if(top.content.frames[3].document.forms[0].referal_id.value!='')
           {
		     refferalValid();
		   }
		   else{
		     if(returnval){
				 top.content.frames[3].document.forms[0].target	="messageFrame";
		         top.content.frames[3].document.forms[0].submit();
               }
		   }

  }
  else
	  {
		top.content.frames[4].location.href="../../eCommon/jsp/error.jsp?err_num="+errs ;
	  }
  }

function refferalValid()
{
	 	 if(top.content.frames[3].document.forms[0].referal_id.value!='')
           {
			      var params =top.content.frames[3].document.forms[0].params.value;
			      var revisVisitFlag = "Y";
				 var referal_id =top.content.frames[3].document.forms[0].referal_id.value;
				 var patient_id =top.content.frames[3].document.forms[0].patient_id.value;
				 var submitFlag ="Y";
                 var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' method='post' action='../../eAE/jsp/AEServerValidation.jsp'?<input type='hidden' name='referal_id' id='referal_id' value='"+referal_id+"'><input type='hidden' name='referal_id' id='referal_id' value='"+referal_id+"'><input type='hidden' name='revisVisitFlag' id='revisVisitFlag' value='"+revisVisitFlag+"'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='process_id' id='process_id' value='1'><input type='hidden' name='params' id='params' value='"+params+"'><input type='hidden' name='submitFlag' id='submitFlag' value='"+submitFlag+"'></form></BODY></HTML>";
		  	top.content.frames[4].document.write(HTMLVal);
            top.content.frames[4].form1.submit();
	  }
}
  function onSuccess()
  {

	  //alert(getMessage('RECORD_MODIFIED'));
      //parent.frames[1].frames[1].location.href='../../eAE/jsp/AEReviseVisitFrameset.jsp';
  }
	
  // For Incident Remarks Details
  async function incidentRemarksDisplay()
	{
       var retVal;
	   var dialogHeight = "15vh" ;
	   var dialogWidth  = "30vw" ;
	   var dialogTop    = "230";
	   var dialogLeft   = "230";
	   var arguments	= document.forms[0].incident_Remarks_val.value;
	   var disabled;
	   if(arguments==null || arguments=='') 
		{
		   arguments	= '';
		   disabled			= 'readOnly';
		}
		else{
			disabled			= 'readOnly';
		}

	   var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
	   retVal			=await window.showModalDialog("../../eAE/jsp/AERegisterMLCDetails.jsp?call_from=IR&disabled="+disabled,arguments,features);
	   if(!((retVal==null) ))
		{
		   document.forms[0].incident_Remarks_val.value = retVal;
		}
	}  

// For MLC Details
  async function mlcRemarksDisplay()
	{
       var retVal;
	   var dialogHeight = "15vh" ;
	   var dialogWidth  = "30vw" ;
	   var dialogTop    = "230";
	   var dialogLeft   = "230";
	   var arguments	= document.forms[0].mlc_details_val.value;
	   var disabled;
	   if(arguments==null || arguments=='') 
		{
		   arguments	= '';
		   disabled			= 'readOnly';
		}
	   else
		{
			disabled			= 'readOnly';
		}

	   var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
	   retVal			=await window.showModalDialog("../../eAE/jsp/AERegisterMLCDetails.jsp?call_from=MLC&disabled="+disabled,arguments,features);
	   if(!((retVal==null) ))
		{
		   document.forms[0].mlc_details_val.value = retVal;
		}
	}

	 function chkValue(obj)
     {
		  if(obj.checked==true)
		   {
				obj.checked=true;
				obj.value='Y';
		   }
		  else
		   {
				obj.checked=false;
				obj.value='N';
		   }
    }

	// For the Postal Code.. Button
	// For Postal Code
async	function callCommonPostalSearch(target)
{
		if(target=="undefined") target.value = "";
		if(target.value=="undefined") target.value = "";
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		sql="select postal_code code, short_desc description  from mp_postal_code where upper(postal_code) like upper(?) and upper(short_desc) like upper(?)";
		
		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ; 
       
		retVal = await CommonLookup( getLabel("eMP.postalcode.label","MP"), argumentArray );
       
		if(retVal != null && retVal != "" )  
		{
 			target.value = retVal[0] ; /* if code need to be returned */	 		
		} 
		else
	{
	target.value="";
	}

} 
function sendToValidation(Val,areaobj,messageFrame)
{
var HTMLVal = new String();
if ( Val == 7 )
{
        if(areaobj.value !='')
        {
            HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eAE/jsp/AEServerValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='7'><input type='hidden' name='rev_flag' id='rev_flag' value='Y'>";
			
			var mode =areaobj.name
			
			if( mode=="m_region_code")
				HTMLVal += "<input name='region_code' id='region_code' type='hidden' value='"+document.getElementById("m_region").value + "'>";
			if( mode=="m_area_code")
				HTMLVal += "<input name='res_area_code' id='res_area_code' type='hidden' value='"+document.getElementById("m_area").value + "'>";
			if( mode=="m_town_code")
				HTMLVal += "<input name='res_town_code' id='res_town_code' type='hidden' value='"+document.getElementById("m_town").value + "'>";
			if( mode=="contact1_region_code")
				HTMLVal += "<input name='region_code' id='region_code' type='hidden' value='"+document.getElementById("n_region").value+ "'>";
			if( mode=="contact2_region_code")
				HTMLVal += "<input name='region_code' id='region_code' type='hidden' value='"+document.getElementById("f_region").value + "'>";
			if( mode=="contact3_region_code")
				HTMLVal += "<input name='region_code' id='region_code' type='hidden' value='"+document.getElementById("e_region").value + "'>";
			if( mode=="contact1_res_area_code")
				HTMLVal += "<input name='res_area_code' id='res_area_code' type='hidden' value='"+document.getElementById("n_area").value + "'>";
			if( mode=="contact2_res_area_code")
				HTMLVal += "<input name='res_area_code' id='res_area_code' type='hidden' value='"+document.getElementById("f_area").value + "'>";
			if( mode=="contact3_res_area_code")
				HTMLVal += "<input name='res_area_code' id='res_area_code' type='hidden' value='"+document.getElementById("e_area").value + "'>";
			if( mode=="contact1_res_town_code")
				HTMLVal += "<input name='res_town_code' id='res_town_code' type='hidden' value='"+document.getElementById("n_town").value + "'>";
			if( mode=="contact2_res_town_code")
				HTMLVal += "<input name='res_town_code' id='res_town_code' type='hidden' value='"+document.getElementById("f_town").value + "'>";
			if( mode=="contact3_res_town_code")
				HTMLVal += "<input name='res_town_code' id='res_town_code' type='hidden' value='"+document.getElementById("e_town").value + "'>";
			if ( mode== "m_postal_code" || mode == "next_postal_code" || mode=="first_postal_code" || mode=="employ_postal_code")
				HTMLVal += "<input name='postal_code' id='postal_code' type='hidden' value='"+areaobj.value + "'>";
           
            HTMLVal += "<input type='hidden' name='mode' id='mode' value='"+mode+"'></form></BODY></HTML>" ;
           
			parent.messageFrame.document.write(HTMLVal);
			parent.messageFrame.form1.submit();
        }
    }
} // END OF THE FUNCTION

function searchPatient(obj)
{
	 	 if(document.forms[0].referal_id.value!='')
           {
	         if(obj.value!='')	
	         {	
				  var params =document.forms[0].params.value;
			     var revisVisitFlag = "Y";
				 var referal_id =document.forms[0].referal_id.value;
				 var patient_id =document.forms[0].patient_id.value;
                 var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='form1' method='post' action='../../eAE/jsp/AEServerValidation.jsp'?<input type='hidden' name='referal_id' id='referal_id' value='"+referal_id+"'><input type='hidden' name='referal_id' id='referal_id' value='"+referal_id+"'><input type='hidden' name='revisVisitFlag' id='revisVisitFlag' value='"+revisVisitFlag+"'><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'><input type='hidden' name='process_id' id='process_id' value='1'><input type='hidden' name='params' id='params' value='"+params+"'></form></BODY></HTML>";
		  	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
            parent.messageFrame.form1.submit();
		 }
	  }
}

function enableocpn()
	{
		if(document.forms[0].occ_of_per.selectedIndex != 0)
		{
			document.forms[0].occu_of_per_desc.value = '';  
			document.forms[0].occu_of_per_desc.disabled = true;
		}
		else if (document.forms[0].occ_of_per.selectedIndex == 0)
		{
		    document.forms[0].occu_of_per_desc.disabled = false;
		}
		
	} 


/**
	SearchLookup for Country.
	@param  - Lookup title,Target fieldname
**/
 async function searchCountry(obj,target)
 {
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
	if(obj.name=="contry_code" )
	{
		if(target.name=="nationality_desc"){
		tit=getLabel("Common.nationality.label","Common");
		sql="Select country_code code,long_desc description from MP_COUNTRY_LANG_VW where language_id='"+localeName+"' and eff_status='E' and  upper(country_code) like upper(?) and upper(long_desc) like upper(?) order by 2";
		} 
		else{
		tit=getLabel("Common.country.label","Common");
		sql="Select country_code code,long_name description from MP_COUNTRY_LANG_VW where language_id='"+localeName+"' and eff_status='E' and upper(country_code) like upper(?) and upper(long_name) like upper(?) order by 2";
		}
	}
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == 'nationality_desc')
			document.forms[0].nationality_code.value= arr[0];
		else if(target.name == 'e_country_desc')
			document.forms[0].e_country_code.value= arr[0];
		else if(target.name == 'first_country_desc')
			document.forms[0].first_country_code.value= arr[0];
		else if(target.name == 'next_country_desc')
			document.forms[0].next_country_code.value= arr[0];
		else if(target.name == 'empyr_country_desc')
			document.forms[0].empyr_country_code.value= arr[0];
	}
	else{
		target.value='';
		}
 }

/**
Used to Validate Birth Date.
**/ 
function doDate(obj)
	{
	  if(obj.value != '') 
	  {
		if(!validDate(obj.value,'DMY',localeName))
		{
			alert(getMessage("INVALID_DATE_TIME",'SM'))
			obj.select();
		}
		else
		{
			if((!isBeforeNow(obj.value,'DMY',localeName)))
			{
				alert(getMessage("DOB_CHECK",'Common'));
				document.forms[0].contact1_birth_date.select();
			}
		}
	  }
    }


function ClearAltID()
{
   document.forms[0].oth_alt_id.value= "";
}

 function callFocus(tabno)
 {
	
 	if(tabno == 1)
	 {
	  tab1.scrollIntoView();
	 }
	else if(tabno == 2)
	 {
	  if (!document.forms[0].accompany_by.disabled) 
	    document.forms[0].accompany_by.focus();
	    tab2.scrollIntoView();
	 }
	else if(tabno == 3)
	 {
	   if(document.forms[0].next_contact_name.disabled==false)
	        document.forms[0].next_contact_name.focus();
	   tab3.scrollIntoView();
	 }
	 if(tabno=="#kin")
			{
				document.getElementById("kin").scrollIntoView();
				document.getElementById("next_contact_name").focus();
			}
	if(tabno=="#kin1") 
			{
				document.getElementById("kin1").scrollIntoView();
				document.getElementById("notify_name").focus();
			}
			if(tabno=="#empyr")
			{
				document.getElementById("empyr").scrollIntoView();
				document.getElementById("organization_name").focus();
			}
 }

function setOccOfPerson()
{
	var occ_of_per	= document.forms[0].occ_of_per;
	while(occ_of_per.options.length > 1)
	occ_of_per.remove(1);
	var occ_class =document.getElementById("occ_class").value;
    var occ_classFlag = "Y";
	var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='occ_class' id='occ_class' value='"+occ_class+"'><input type='hidden' name='occ_classFlag' id='occ_classFlag' value='"+occ_classFlag+"'><input type='hidden' name='from_rev' id='from_rev' value='from_rev'></form></BODY></HTML>";
	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.messageFrame.visit_form.submit();
}

function validateNationalID(Nat_Id,nat_id_check_digit_id,validate_len_yn,nat_id_prompt)
{
	var Nat_IdName = Nat_Id.name;
	var isNumber   = new Boolean();
	isNumber       = true;
	var ind        = -1;

	if ( Nat_Id.value.length > 0 )
	{
		if ( (ind = Nat_Id.value.indexOf('X')) != -1)
		{
			if (ind < 12)           // X can be entered only at 13th position
			{
				msg = getMessage('INVALID_NAT_ID','MP');
				msg = msg.replace("#",nat_id_prompt);
				Nat_Id.focus();
				alert(msg);
				return false;
			}
		}
	}

	if ( isNumber )
	{
	   var nid = new String();
       nid = trimString(Nat_Id.value);
       Nat_Id.value = nid;

       if(validate_len_yn == "Y")
       if ( nid.length == Nat_Id.maxLength )   isNumber = true
       else
        {
            isNumber = false

        }

		if(isNumber && Nat_Id.value!='')
		{
          var NatIdFlag = "Y"; 
		  var HTMLVal = "<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY onKeyDown = 'lockKey()'><form name='visit_form' id='visit_form' method='post' action='../../eAE/jsp/AERegisterPopulate.jsp'><input type='hidden' name='CalledFrom' id='CalledFrom' value='Rev'><input type='hidden' name='Nat_IdName' id='Nat_IdName' value='"+Nat_IdName+"'><input type='hidden' name='Nat_Id' id='Nat_Id' value='"+Nat_Id.value+"'><input type='hidden' name='nat_id_check_digit_id' id='nat_id_check_digit_id' value='"+nat_id_check_digit_id+"'><input type='hidden' name='NatIdFlag' id='NatIdFlag' value='"+NatIdFlag+"'><input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value='"+nat_id_prompt+"'></form></BODY></HTML>";
		  parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		  parent.messageFrame.visit_form.submit();
		}
		else
		{
			if ( Nat_Id.value != '' )
			{
				var val = getMessage("NAT_ID_CHARS",'MP');
				val = val.replace("@",document.forms[0].nat_id_no.maxLength);
				val = val.replace("#",nat_id_prompt)
				alert(val)
				Nat_Id.focus();
			}
		}
	}

}


function checkMaxLen(obj)
{
	if (obj.value.length>2000){
		var error = getMessage("REMARKS_CANNOT_EXCEED",'Common');
		error = error.replace("$",getLabel("eAE.EscortDetail.label","AE"));
		error = error.replace("#","2000");
		alert(error)
		obj.focus(); 
	}
}

async function getReferralID()
{
	var params =document.forms[0].params.value;
	var retVal;
	var dialogTop       = "85";
	var dialogHeight    = "45vh" ;
	var dialogWidth     = "68vw" ;    
	var arguments       = "" ;
	var center = "1" ;
	var status="no";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + "; scrolling :" + "NO" ;
	var arguments   = "" ;
	var assign_care_locn_code =  document.forms[0].location_code.value;
	var service_code =  document.forms[0].service_code.value;
	var visit_type_code =  document.forms[0].visit_type_code.value;
	var speciality_code =  document.forms[0].speciality_code.value;
	var resorce_type =  document.forms[0].resorce_type.value;
	oth_params = "p_patient_id="+document.getElementById("patient_id").value+"&p_referral_id="+document.getElementById("referal_id").value
	var url = "../../eMP/jsp/ReferralSearchFrameset.jsp?p_to_locn_code="+assign_care_locn_code+"&p_service_code="+service_code+"&p_calling_function=CHG_REG_DTLS&p_select=YES&p_reg_patient=YES&p_speciality_code="+speciality_code+"&resorce_type="+resorce_type+"&p_to_locn_type="+visit_type_code+"&"+oth_params;
	retVal =await window.showModalDialog(url,arguments,features);
	if(retVal==null){ retVal="";
	
	document.forms[0].referal_id.value= retVal;
	document.forms[0].referal_id.focus();
	document.forms[0].params.value = params;
	return false;
	}
	else
	{
	document.forms[0].referal_id.value= retVal;
	document.forms[0].referal_id.focus();
	return false;
	}
}

function closewindow()
	{
		 parent.window.close();
		 document.location.href="../../eCommon/jsp/dmenu.jsp";
	}

function query()
{
     top.content.location.href='../../eAE/jsp/AEReviseVisit.jsp?module_id=AE&function_id=AE_REVISE_VISIT&function_name=Revise%20Attendance%20Details&function_type=F&menu_id=AE_TRANSACTIONS&access=NYYNN';

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

	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-';
	
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

// code added for 20409


function CheckSplCharsNatID(Obj){
		var nat_id_accept_alphanumeric_yn = document.forms[0].nat_id_accept_alphanumeric_yn.value;
        var str = Obj.value;
        var specCharsExist = true;

		if(nat_id_accept_alphanumeric_yn=="Y")
			strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-';
		else
			strCheck = '0123456789X';
		
        for (i=0;i<str.length;i++){
            if (strCheck.indexOf(str.charAt(i)) == -1) 
			{
				alert(getMessage("NAT_ID_SPL_NOT_ALLOWED",'MP'));
				Obj.focus();
				return false;  
			}
        }
        return specCharsExist;
    }
	
// added by mujafar for ML-MMOH-CRF-0632 START
	
function searchPatient1(obj)
{     
	
	
   if(document.forms[0].patient_id1_val.value !="")
   {
	   if(document.forms[0].patient_id1.value == "")
	   {
		   
	if(document.forms[0].contact1_new_nat_id_no)document.forms[0].contact1_new_nat_id_no.value='';
	if(document.forms[0].next_contact_name)document.forms[0].next_contact_name.value = '';
	if(document.forms[0].contact1_birth_date)document.forms[0].contact1_birth_date.value='';
	if(document.forms[0].next_addr_line1)document.forms[0].next_addr_line1.value='';
	if(document.forms[0].next_addr_line2)document.forms[0].next_addr_line2.value='';
	if(document.forms[0].next_addr_line3)document.forms[0].next_addr_line3.value='';
	if(document.forms[0].next_addr_line4)document.forms[0].next_addr_line4.value=''; 
	if(document.forms[0].contact1_res_town_code){document.forms[0].contact1_res_town_code.value='';document.forms[0].n_town.value = '';}
	if(document.forms[0].contact1_res_area_code){document.forms[0].contact1_res_area_code.value='';document.forms[0].n_area.value = '';}
	if(document.forms[0].contact1_region_code){document.forms[0].contact1_region_code.value=''; document.forms[0].n_region.value = '';}
	if(document.forms[0].next_postal_code1){document.forms[0].next_postal_code1.value='';document.forms[0].next_postal_code.value = '';}
	if(document.forms[0].next_country_desc){document.forms[0].next_country_desc.value='';document.forms[0].next_country_code.value = '';}
	if(document.forms[0].next_res_tel_no)document.forms[0].next_res_tel_no.value='';
	if(document.forms[0].contact1_mob_tel_no)document.forms[0].contact1_mob_tel_no.value='';
	if(document.forms[0].contact1_email_id)	document.forms[0].contact1_email_id.value='';
	if(document.forms[0].next_contact_relation)document.forms[0].next_contact_relation.options[0].selected=true;
	if(document.forms[0].next_job_title)document.forms[0].next_job_title.value='';
	if(document.forms[0].next_off_tel_no)document.forms[0].next_off_tel_no.value='';
		   
	document.forms[0].patient_id1_val.value='';	   
		   
		   
		   
		   
	   }
   }
   
   if(document.forms[0].patient_id1.value!='' && document.forms[0].patient_id1_val.value != document.forms[0].patient_id1.value)
   { 
		

	if(obj!='')
	{
		var sou_value="3";
		
		
	parent.frames[4].document.location.href="../../eAE/jsp/AEcommonValidation.jsp?P_Patient_ID="+obj.value+"&sou_value="+sou_value;
	}
	  
	setTimeout('populateData()',1000); 
	 
   }  
}

function PopulatePatData( res_addr_line1,res_addr_line2,res_addr_line3,res_addr_line4,res_town_desc,res_area_desc,res_region_desc,postal_desc,res_country_desc,res_tel_no,res_mob_no,res_mail_id,date_of_birth,res_national_id_no,pat_name,res_town_code,res_area_code,res_region_code,postal_code,res_country_code,ocpn_desc)
{  
	if(document.forms[0].contact1_new_nat_id_no)
		document.forms[0].contact1_new_nat_id_no.value=res_national_id_no;
	if(document.forms[0].next_contact_name)
		document.forms[0].next_contact_name.value = pat_name;
	if(document.forms[0].contact1_birth_date)
		document.forms[0].contact1_birth_date.value=date_of_birth;
	if(document.forms[0].next_addr_line1)
		document.forms[0].next_addr_line1.value=res_addr_line1;
	if(document.forms[0].next_addr_line2)
		document.forms[0].next_addr_line2.value=res_addr_line2;
	if(document.forms[0].next_addr_line3)
		document.forms[0].next_addr_line3.value=res_addr_line3;
	if(document.forms[0].next_addr_line4)
		document.forms[0].next_addr_line4.value=res_addr_line4; 
	if(document.forms[0].contact1_res_town_code)
	{
		document.forms[0].contact1_res_town_code.value=res_town_desc;
		document.forms[0].n_town.value = res_town_code;
	}
	if(document.forms[0].contact1_res_area_code)
	{
		document.forms[0].contact1_res_area_code.value=res_area_desc;
		document.forms[0].n_area.value = res_area_code;
	}
	if(document.forms[0].contact1_region_code)
	{
		document.forms[0].contact1_region_code.value=res_region_desc;
		 document.forms[0].n_region.value = res_region_code;
	}
	if(document.forms[0].next_postal_code1)
	{
		document.forms[0].next_postal_code1.value=postal_desc;
		document.forms[0].next_postal_code.value = postal_code;

	}
	if(document.forms[0].next_country_desc)
	{
		document.forms[0].next_country_desc.value=res_country_desc;
		document.forms[0].next_country_code.value = res_country_code;

	}
	if(document.forms[0].next_res_tel_no)
		document.forms[0].next_res_tel_no.value=res_tel_no;
	if(document.forms[0].contact1_mob_tel_no)
		document.forms[0].contact1_mob_tel_no.value=res_mob_no;
	if(document.forms[0].contact1_email_id)
		document.forms[0].contact1_email_id.value=res_mail_id;
	if(document.forms[0].next_contact_relation)
	document.forms[0].next_contact_relation.options[0].selected=true;
    if(document.forms[0].next_job_title)
	document.forms[0].next_job_title.value=ocpn_desc;
	if(document.forms[0].next_off_tel_no)
	document.forms[0].next_off_tel_no.value=''; 
	 
	
	
	document.forms[0].patient_id1_val.value=document.forms[0].patient_id1.value;
	
}

function populateData()
{ 
	if(document.forms[0].patient_id1.value!="")
	{
		
		var patientId			= document.forms[0].patient_id1.value;
	if(patientId!=""){ 
		
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		xmlStr ="<root><SEARCH patientId=\""+patientId+"\" action='PopulatePatientData' /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eAE/jsp/AEIntermediate.jsp",false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
	}
	
	}
	
	
}
function callPatientSearch1()
{
	var patientid = PatientSearch('','','','','','','','','','');
	

	if(patientid !=null)
	{

		document.forms[0].patient_id1.value = patientid;
		document.forms[0].patient_id1.focus();
	}
	else
	{
		document.forms[0].patient_id1.value = '';
	}
}

function changeCase(obj)
{
	  obj.value=obj.value.toUpperCase();
}

// added by mujafar for ML-MMOH-CRF-0632 END

//Added by Ashwini on 12-Feb-2020 for AAKH-CRF-0079.11
async function UploadDocument()
{
	var patient_id = document.forms[0].patient_id.value;
	var encounter_id = document.forms[0].encounter_id.value;

	var dialogHeight = "45vh";
	var dialogWidth	= "75vw";
	var status = "no";
	var arguments = "";
	var function_id = "UPLOAD_DOC";
	
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll = auto; status:" + status;

	await window.showModalDialog('../../eMP/jsp/MPUploadDocument.jsp?function_id='+function_id+'&patient_id='+patient_id+'&encounter_id='+encounter_id,arguments,features);			
}

