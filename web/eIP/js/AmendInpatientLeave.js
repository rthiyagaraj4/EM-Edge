/// Added by Sridhar R on 15 JUNE 2004
/// Function validatePseudoBed will enable Pseudobed Lookup Button..to select a Peseudo bed if release bed Check Box is enabled & only for Revise Leave Transaction Type..
function validatePseudoBed(obj)
{
	if(document.forms[0].trans_type.value == '1')
	{
		if(obj.checked == true)
		{
			document.forms[0].release_bed.value			= "Y";
			document.forms[0].PseudoBed_chart.disabled	= false;
			document.forms[0].pseudoImg.style.visibility= "visible";	
		}
		else
		{
			document.forms[0].release_bed.value			= "N";
			document.forms[0].pseudo_bed.value			= "";
			document.forms[0].PseudoBed_chart.disabled	= true;
			document.forms[0].pseudoImg.style.visibility= "hidden";	
		}
	}
}

function focusNext()
{

}

/// Added by Sridhar R on 15 JUNE 2004
/// Function searchPseudoBed will open bed Availibility Chart to select a Peseudo bed if release bed Check Box is enabled & only for Revise Leave Transaction Type..
async function searchPseudoBed()
{
	var nursingunit		= document.forms[0].nursing_unit.value;
	var specialitycode	= document.forms[0].old_speciality_code.value;
	var retVal			= new String();
	var dialogHeight	= "41" ;
	var dialogWidth		= "65" ;
	var dialogTop		= "72";
	var status			= "no";
	var bed_type		= 'pseudo';
	var bedClass_dis_yn = "Y";

	var wherecondn	= "";
	var arguments   = "" ;
	var features    = "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	retVal = await window.showModalDialog( "../jsp/BedAvailabilityChart.jsp?disable_field=NursingUnitSpecialty&nursing_unit_code="+nursingunit+"&speciality_code="+specialitycode+"&bed_type="+bed_type+"&bedClass_dis_yn="+bedClass_dis_yn+"&wherecondn="+wherecondn,arguments,features);
	if(retVal!=null)
	{
		var arr=retVal.split("^");

		if (arr.length>2)
		{
			if(arr[1] != null)

			document.forms[0].pseudo_bed.value			= arr[1]
			document.forms[0].nursing_unit.value		= arr[0]
			document.forms[0].bed_type_code.value		= arr[2]
			document.forms[0].bed_typ_code.value		= arr[2]
			document.forms[0].Bedcode.value				= arr[3]
			document.forms[0].bed_cls_code.value		= arr[3]
			document.forms[0].room_no.value				= arr[4]  
			document.forms[0].disp_room_no.value		= arr[4]  
			document.forms[0].nursing_unit_desc.value	= arr[9]

			document.forms[0].hdd_peudobed_val.value	= arr[14];
							
			document.forms[0].nursing_unit_desc.disabled	= true;
			document.forms[0].nursing_unit_lookup.disabled	= true;
			document.forms[0].bed_no.disabled				= true;		document.forms[0].bed_chart.disabled			= true;
			document.forms[0].disp_room_no.disabled			= true;
			document.forms[0].Bedcode.disabled				= true;
			document.forms[0].bed_type_code.disabled		= true;

			for(var i=0;i<document.forms[0].Bedcode.options.length;i++ )
			{
				if(document.forms[0].Bedcode.options[i].value == arr[3])
					document.forms[0].Bedcode.options[i].selected=true
			}
			for(var i=0;i<document.forms[0].bed_type_code.options.length;i++ )
			{
				if(document.forms[0].bed_type_code.options[i].value == arr[2])
					document.forms[0].bed_type_code.options[i].selected=true
			}
		}
		else
		{
			document.forms[0].nursing_unit.value		= arr[0];
			if (arr.length == 2)
				document.forms[0].nursing_unit_desc.value	= arr[1];
		}
	}
}

/// END of addition

function changeAbsStatus(obj)
{
	if(obj.checked  == true)
		obj.value ="Y";
	else
		obj.value ="N";
}

			
function ChkAbsTime(Obj)
{
	if (Obj.value != '')
	{
		if(!doDateTimeChk(Obj))
		{
			alert(getMessage("INVALID_DATE_TIME","SM"))
			Obj.select();
		}
	}
}

function compareDates()
{
	var from = document.getElementById("from_date");
	var to = document.getElementById("to_date");

	if(from.value !='' && to.value !='')
	{
		if(validDate(from.value,"DMYHM",localeName) && validDate(to.value,"DMYHM",localeName))
		{			
			var fromDt	= convertDate(document.getElementById("from_date").value,"DMYHM",localeName,"en");
			var toDt	= convertDate(document.getElementById("to_date").value,"DMYHM",localeName,"en");
			if(!isBefore(fromDt,toDt,'DMYHM',localeName))// DateUtils.js
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				document.getElementById("to_date").select();
			}
		}
	}
}

function validateDate(from,obj)
{
		var CurrentDate = getCurrentDate("DMYHM","<%=locale%>")
			//alert(CurrentDate);
			//alert(CurrentDate);

	var leave_status = document.forms[0].leave_stat.value;
	if(obj.value != '')
	{
		if(validDateObj(obj,'DMYHM',localeName))
		{
			var greg_FromToDateTime = convertDate(obj.value,'DMYHM',localeName,'en');
			if(from == 'F' && obj.readOnly == false)
			{
				/*Thursday, July 29, 2010 , commented for IN022982*/
				/*if(isBefore(greg_FromToDateTime,document.getElementById("admdate").value,'DMYHM','en'))
				{
					alert(getMessage('FRM_DT_GREATER_ADDMISSION_DT','IP'));
					obj.value = "";
					obj.focus();
				}
				else*/ if(!isAfterNow(greg_FromToDateTime,'DMYHM','en'))
				{
					alert(getMessage('FRM_DT_GREATER_CURRENT_DT','IP'));
					obj.value = "";
					obj.focus();
				}	
			}
			else if(from == 'T' )
			{
				var greg_FromDateTime = convertDate(document.getElementById("from_date").value,'DMYHM',localeName,'en');
				if(document.getElementById("from_date").value == '')
				{
					//Commented for IN018663 on Thursday, January 28, 2010 by sathish
					/*alert(getMessage('FRM_DT_TIME_NOT_NULL','IP')); 
					document.getElementById("from_date").select();
					document.getElementById("from_date").focus();*/
				}				
				else if(isBefore(greg_FromToDateTime,greg_FromDateTime,'DMYHM','en'))
				{
					alert(getMessage('TO_DT_TIME_GREATER_FROM','IP'));
					document.getElementById("to_date").select();
					document.getElementById("to_date").focus();
				}
				else
				{
					var	to_proceed=false;					
					if(ValidateFromToDateTime(greg_FromDateTime,greg_FromToDateTime))
						to_proceed =true;
					else
					{
						document.getElementById("to_date").select();
						document.getElementById("to_date").focus();
					}
				}
			}
			else if(from == 'R')
			{
				//if(isAfterNow(greg_FromToDateTime,'DMYHM','en'))
	//  if(<greg_FromToDateTime)

	//alert(CurrentDate)returned_date_time
				//if(isBefore(CurrentDate,greg_FromToDateTime,'DMYHM','en'))
				//if(isBefore(greg_FromToDateTime,document.getElementById("returned_date_time").value,'DMYHM','en'))

//modified for 17609 Wednesday, December 23, 2009
				var greg_fromDateTime = convertDate(document.getElementById("returned_date_time").value,'DMYHM',localeName,'en');
				if(!isBeforeNow(greg_fromDateTime,"DMYHM","en"))
				{
					var err1 = getMessage("DATE1_GT_DATE2","IP");
					err1 = err1.replace('$',getLabel("Common.datetime.label","Common"))
					err1 = err1.replace('#',getLabel("Common.CurrentDateTime.label","Common"))
					alert(err1);
					document.getElementById("returned_date_time").value = "";
					obj.focus();
				}
				else  if(!isBefore(document.getElementById("leave_fr_date").value,greg_fromDateTime,'DMYHM','en'))
				{
					var err1 = getMessage("DATE1_LT_DATE2","IP");
					err1 = err1.replace('$',getLabel("Common.datetime.label","Common"))
					/*Friday, January 29, 2010 18646*/
					if(leave_status == '4')
						err1 = err1.replace('#',getLabel("eIP.AbscondedFrom.label","IP"))
					else
						err1 = err1.replace('#',getLabel("Common.LeavePeriod.label","Common")+" "+getLabel("Common.from.label","Common"))
					//err1 = err1.replace('#',getLabel("eIP.LeaveDatefrom.label","IP"))
					alert(err1);
					document.getElementById("returned_date_time").value = "";
					obj.focus(); 
				}
			}
			/*Thursday, January 28, 2010 SRR20056-SCF-4085 [IN:018634] , to validate absconding date*/
			else if (from == 'AB')
			{
				var greg_AbsDateTime = convertDate(document.getElementById("AbsDate").value,'DMYHM',localeName,'en');
				if(!isBeforeNow(greg_AbsDateTime,"DMYHM","en"))
				{
					var err1 = getMessage("DATE1_GT_DATE2","IP");
					err1 = err1.replace('$',getLabel("eIP.Absconding.label","IP")+" "+getLabel("Common.datetime.label","Common"))
					err1 = err1.replace('#',getLabel("Common.CurrentDateTime.label","Common"))
					alert(err1);
					document.getElementById("AbsDate").value = "";
					obj.focus();
				}
				else  if(!isBefore(document.getElementById("leave_fr_date").value,greg_AbsDateTime,'DMYHM','en'))
				{
					var err1 = getMessage("DATE1_LT_DATE2","IP");
					err1 = err1.replace('$',getLabel("eIP.Absconding.label","IP")+" "+getLabel("Common.datetime.label","Common"))
					err1 = err1.replace('#',getLabel("Common.LeavePeriod.label","Common")+" "+getLabel("Common.from.label","Common"))
					//err1 = err1.replace('#',getLabel("eIP.LeaveDatefrom.label","IP"))
					alert(err1);
					document.getElementById("AbsDate").value = "";
					obj.focus(); 
				}
			}/**/
		}
	}
}

function ValidateFromToDateTime(from,to)
{	  	

	
	/*var a=  from.split(" ")
  	splitdate=a[0];
  	splittime=a[1]
  
  	var splitdate1 =a[0].split("/")
  	var splittime1= a[1].split(":")
  
  	var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
  	 
  	a=  to.split(" ")
  	splitdate=a[0];
  	splittime=a[1]
  
  	 splitdate1 =a[0].split("/")
  	 splittime1= a[1].split(":")
  
  	 var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
  	
	
  	if(Date.parse(from_date) > Date.parse(to_date))
  	{   
		return false;
  	}
  	else
	{
  		var dat = Date.parse(from_date) - Date.parse(to_date);
		var s= (-dat/1000);
	  	var hrVal =((s/3600));
		*/
		var minVal = minutesBetween(from,to,'DMYHM','en');
		var hrVal = ((minVal/60));
	  	
  		var maxallowedlvperiod = document.forms[0].max_allowed_lv_period.value;
  		var warnorerrormaxleave= document.forms[0].warn_or_error_max_leave.value;
  		
		
		if(hrVal > maxallowedlvperiod)
  		{  			
  			if(warnorerrormaxleave == "W")
  			{
  				alert(getMessage("XDS_MAX_LV_PERIOD","IP"));
				//document.forms[0].todate.focus();
  				//document.forms[0].todate.select(); 	
  				return true;
  			}	
  			else	
  			{
  				alert(getMessage("XDS_MAX_LV_PERIOD","IP"));  				
				document.forms[0].todate.focus();
  				document.forms[0].todate.select(); 	
  				return false
  			}
  		}
  		else
	  		return true;
	//} 		
}  

function obClick(obj,val)
{
	if(val == "Y")
		obj.checked = !obj.checked
}

async function searchBed()
{
	var nursingunit = document.forms[0].nursing_unit.value;
	var specialitycode=document.forms[0].old_speciality_code.value;
	var bedclasscode=document.forms[0].Bedcode.value;
	var bed_type=document.forms[0].bed_type_code.value;
	var retVal		= new String();
	var dialogHeight= "41";
	var dialogWidth = "65";
	var dialogTop	= "72";

	var status		= "no";
	var wherecondn	= "REVISE_LEAVE_YN";
	var arguments   = "" ;
	var features    = "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog( "../../eIP/jsp/BedAvailabilityChart.jsp?disable_field=NursingUnit&nursing_unit_code="+nursingunit+"&speciality_code="+specialitycode+"&bed_class_code="+bedclasscode+"&bed_type="+bed_type+"&wherecondn="+wherecondn,arguments,features);

	if(retVal!=null)
	{
		var arr=retVal.split("^");

		if (arr.length>2)
		{
			if(arr[1] != null)
			document.forms[0].bed_no.value      = arr[1]
			if(document.forms[0].release_bed_yn.value == "N")
				document.forms[0].old_bed_no.value		= arr[1]
			document.forms[0].bed_typ_code.value		= arr[2]
			document.forms[0].Bedcode.value  = arr[3]
			document.forms[0].bed_cls_code.value  = arr[3]

			if(document.forms[0].release_bed_yn.value == "N")
				document.forms[0].room_no.value			= arr[4]  
			document.forms[0].disp_room_no.value	= arr[4]  
			document.forms[0].nursing_unit.value    = arr[0]
			document.forms[0].nursing_unit_desc.value= arr[9]

			for(var i=0;i<document.forms[0].Bedcode.options.length;i++ )
			{
				if(document.forms[0].Bedcode.options[i].value == arr[3])
					document.forms[0].Bedcode.options[i].selected=true
			}
			for(var i=0;i<document.forms[0].bed_type_code.options.length;i++ )
			{
				if(document.forms[0].bed_type_code.options[i].value == arr[2])
					document.forms[0].bed_type_code.options[i].selected=true
			}
		}
		else
		{
				document.forms[0].nursing_unit.value		= arr[0];
			if (arr.length == 2)
				document.forms[0].nursing_unit_desc.value	= arr[1];
		}
	}
}

function LoadToDate(obj, leaveind)
{

}



async function apply()
{

	if(document.forms[0].trans_type.value == '2')
	{
		document.forms[0].release_bed.value=document.forms[0].release_bed_yn.value;
		document.forms[0].bed_no_val.value=  "Y";
	}
	if(document.forms[0].trans_type.value == '1')
	{
		if(document.forms[0].hdd_allow_release_bed_on_lv.value == 'Y' && document.forms[0].hdd_allow_rel_bed.value == 'Y' )
		{
			if(document.forms[0].release_bed.checked == true)
			{
				if(document.forms[0].pseudo_bed.value == '') 
				{
					checkFieldLocal(document.forms[0].pseudo_bed,getLabel("eIP.PseudoBed.label","IP"))
					document.forms[0].PseudoBed_chart.focus();
					return 
				}
			}
		}
	}
	var submitVal = "<html><body onKeyDown='lockKey()'><form name='AmendInpatientLeave_form' id='AmendInpatientLeave_form' method='post' action='../../servlet/eIP.IPAmendIPLeaveServlet'>"

	for(var i=0; i<document.forms[0].elements.length;i++)
	{
		if(document.forms[0].elements[i].type == "checkbox")
		{
			if( document.forms[0].elements[i].checked )
				submitVal += "<input type='hidden' name='"+document.forms[0].elements[i].name+"' id='"+document.forms[0].elements[i].name+"' value=\""+document.forms[0].elements[i].value+"\">"
		}
		else
			submitVal += "<input type='hidden' name='"+document.forms[0].elements[i].name+"' id='"+document.forms[0].elements[i].name+"' value=\""+document.forms[0].elements[i].value+"\">"
	}
	submitVal+="</form></body></html>"

	parent.parent.frames[2].document.write(submitVal);
	if(await checkMandatory())
	{
		document.getElementById("release_bed").disabled = false;
		if(eval(document.getElementById("amend_remarks").value.length) >= 500){
			alert(getMessage('CANT_XCEED_500_CHARS','IP'));
		}
		else
		{
			
			if(document.forms[0].leave_remarks.disabled == true)
				document.forms[0].leave_remarks.disabled = false;
			document.forms[0].record.disabled = true;
			if(document.forms[0].trans_type.value == '1' && document.forms[0].bed_no.disabled)
				document.forms[0].bed_no.disabled = false;

					
			if(document.forms[0].leave_remarks.disabled==true)
				document.forms[0].leave_remarks.disabled=false;
			
			if(document.forms[0].AbsDate.disabled==true)
				document.forms[0].AbsDate.disabled=false;
			
			if(document.forms[0].returned_date_time.disabled==true)
				document.forms[0].returned_date_time.disabled=false;
			
			if(document.forms[0].informed_date.disabled==true)
				document.forms[0].informed_date.disabled=false;
			
			if(document.forms[0].Bedcode.disabled==true)
				document.forms[0].Bedcode.disabled=false;
			
			if(document.forms[0].bed_type_code.disabled==true)
				document.forms[0].bed_type_code.disabled=false;
			
			if(document.forms[0].inform_to.disabled==true)
				document.forms[0].inform_to.disabled=false;
			document.AmendInpatientLeave_form.action = '../../servlet/eIP.IPAmendIPLeaveServlet' ;
			document.AmendInpatientLeave_form.submit();
		}
	}
}
            
            function checkMandatory()
            {
                var trntype = document.getElementById("trans_type").value;
				var ackchktype=document.getElementById("Absconding_yn").value;
				var bedcodevalue=document.forms[0].Bedcode.value;
				if(document.forms[0].bed_no.disabled == false)
				var bed_no = document.forms[0].bed_no.value;

                if (trntype == '3' && document.forms[0].Absconding_yn.checked==true)
				{
					if(checkFieldLocal(document.getElementById("AbsDate"),getLabel("eIP.AbscondingDateTime.label","IP")))
					{
						if(document.getElementById("inform_to") != "")
						{
						if(document.getElementById("inform_to").selectedIndex != "0")
						{
								if(checkFieldLocal(document.getElementById("informed_date"),getLabel("Common.InformedDate/Time.label","Common")))
								return true;
							else
								return false;
						}
						}
						else
							if(document.getElementById("inform_to") == "")
						{
							return true;	
						}
					}
					else return false; 
				}
				else 
				if (trntype == '3' && document.forms[0].Absconding_yn.checked==false)
				{
					if(checkFieldLocal(document.getElementById("returned_date_time"),getLabel("eIP.RecordNoShowDateTime.label","IP")))
					{
						return true;
					}
					else return false;
				}
				if(trntype == '1')
                {
                    if(checkFieldLocal(document.getElementById("from_date"),getLabel("Common.fromdatetime.label","Common")))
                    {
                        if(checkFieldLocal(document.getElementById("to_date"),getLabel("Common.ToDateTime.label","Common")))
                        {
                            if(document.getElementById("release_bed").checked == true) 
                            {	
								return true;
                            }
                            else return true;
                        }else return false;
                    }else return false;
                }
                else if(trntype == '2') 
                {
               if(checkFieldLocal(document.getElementById("returned_date_time"),getLabel("eIP.DateTimeReturned.label","IP")))
                    {
                        if(checkFieldLocal(document.getElementById("bed_no"),getLabel("Common.bedno.label","Common")))
                        {				        
							if(checkFieldLocal(document.getElementById("Bedcode"),getLabel("eIP.BedClassCode.label","IP")))
								return true;
							else
								return false;
                    	}
					else 
						return false;
                }
                else
                    return false;
            }
			 else if(trntype == '9')
			{
                   
                 if(checkFieldLocal(document.getElementById("Bedcode"),getLabel("eIP.BedClassCode.label","IP")))
					{
						if(checkFieldLocal(document.getElementById("bed_no"),getLabel("Common.bedno.label","Common")))
							return true;
						else
							return false;
					}
                else
                    return false;
            }

                else
                    return true;
	}

            function popDynamicValues(val)
            {

			  if (val.value.length>0)
				{
					if(val == 'bn')
						document.forms[0].bed_no_val.value=  "N";
					else{}
				}

					document.forms[0].Bedcode.value='';
                    document.forms[0].bed_type_code.value= '';
					document.forms[0].bed_no.value='';
            }
            
			function checkbed()
			{
				if(document.forms[0].bed_no.value =='')
				{
				document.forms[0].Bedcode.value ='';
				document.forms[0].disp_room_no.value ='';
				document.forms[0].bed_type_code.value ='';
				}
			}

            function validate_Bed_No()
            {
				
				var sStyle = document.forms[0].sStyle.value;
				if(validateSplchars())
                {
					if(document.forms[0].bed_no_val.value == "N" && document.forms[0].bed_no.value !='')
                    {
						var HTMLVal = " <html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head> "+
						" <body class='message' onKeyDown='lockKey()'><form name='fetchtoleavedate' id='fetchtoleavedate' method='post' action='../jsp/FetchToLeaveDate.jsp'> "+
						" <input type='hidden' name='bed_no' id='bed_no' value=\""+document.forms[0].old_bed_no.value+"\">"+
						" <input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value=\""+document.forms[0].nursing_unit.value+"\">"+ " <input type='hidden' name='patient_id' id='patient_id' value=\""+document.forms[0].patient_id.value+"\">"+
						" <input type='hidden' name='operation' id='operation' value='bed_no'>"
						HTMLVal = HTMLVal+"</form></body></html>";       
						parent.frames[2].document.write(HTMLVal);
						parent.frames[2].document.fetchtoleavedate.submit();
                    }
                }
				
            }
            
            function validateSplchars()
            {
                var fields = new Array(document.getElementById("bed_no"));
                var names = new Array(getLabel('Common.bedno.label','common'));

                if(!SpecialCharCheck(fields,names,'',"A",'') )
                {
                    obj.select()
                    obj.focus()
                    return false;
                }
                return true;
            }

async function NursingUnitLookup(Facility_ID,Login_User,Operator_Station_ID)
{
	var msg="";
	var Facility_ID				=	"`"+Facility_ID+"`";
	var Login_User				=	"`"+Login_User+"`";
	var Operator_Station_ID		=	"`"+Operator_Station_ID+"`";

	var target			= document.forms[0].nursing_unit_desc;
	var retVal			=    new String();
	var dialogTop			= "40";
	var dialogHeight		= "400px" ;
	var dialogWidth			= "700px" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var sql				= "";
	var search_desc			= "";
	var tit				= "";

	sql=" select a.nursing_unit_code,a.short_desc from ip_nursing_unit a, am_os_user_locn_access_vw b where a.facility_id="+Facility_ID+" and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code  and b.oper_stn_id="+Operator_Station_ID+" and b.appl_user_id="+Login_User+" and revise_leave_yn=`Y` and a.locn_type=b.locn_type ";

	search_code="a.nursing_unit_code";
	search_desc="a.short_desc";
	tit=getLabel("Common.nursingUnit.label","Common");
	retVal= await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst=dispDescFirst",arguments,features);
	
	var arr=new Array(); 

	if (!(retVal == null))
	{
		var retVal=unescape(retVal);
		arr=retVal.split("::");
		document.forms[0].nursing_unit_desc.value	=	arr[0];
		document.forms[0].nursing_unit.value		=	arr[1];
	}
	else
	{
		target.focus();
	}
}

function setFocus(obj)
{
	var val = obj.value
	if(val=='2')
		document.forms[0].nursing_unit.focus();
	else if(val=='1')
		document.forms[0].leave_to_date.focus();
	else if(val=='9')
		document.forms[0].amend_remarks.focus();
}

function validateTransType(obj)
{
	
	var val = obj.value

/// Coded on 16 FEB 2004... By Sridhar R
/// Code added to enable & disable Absconding Status & Date Fields 		
/// If transaction type = Record no show then the fields will be enabled else disabled..
	if(obj.value == "1" || obj.value == "2"  || obj.value == "9")
	{
		document.forms[0].Absconding_yn.disabled = true;
		document.forms[0].AbsDate.disabled = true;
		document.forms[0].AbsDate.value = "";
		document.forms[0].absgif.style.visibility="hidden";
		document.getElementById("AbsDateImg").disabled = true;
		//@reported_to,AbsDate Added by kishore on 4/20/2004 
		document.forms[0].reported_to.disable = true;
		document.forms[0].reported_to.readOnly = true;
		document.forms[0].amend_remarks.focus();
		if(document.forms[0].Absconding_yn.checked==true)
		{
		document.forms[0].Absconding_yn.checked=false;
		}
		document.getElementById("date_time_lgd").innerHTML= getLabel("eIP.DateTimeReturned.label","IP");
		document.getElementById("im").style.visibility = 'hidden';
		document.getElementById("im2").disabled	=	true;
	}
	else 
	{
		document.forms[0].Absconding_yn.disabled = false;
	 
	}
// Friday, February 05, 2010 18916 (Venkat S)
	if(document.forms[0].Absconding_yn)
	{
		absChecked(document.forms[0].Absconding_yn);
	}
	// end  18916
	document.forms[0].Bedcode.value=document.forms[0].old_bed_class_code.value          
	document.forms[0].bed_type_code.value=document.forms[0].old_bed_type_code.value         
	obj.value = val;
	
	if(obj.value == "1")
	{   
		var rdonly = "readonly";
		var disonly= "disabled";

		//if(ValidateDateTime(document.getElementById("sys_date"),document.getElementById("leave_fr_date")))
		if(isAfterNow(document.getElementById("leave_fr_date").value,'DMYHM','en'))
		{
			rdonly = "";
			disonly="";
		}
		
		//document.getElementById("from_date1").innerHTML = "<input type=text id= fromdate name=from_date size=16 maxlength=16 value=\""+document.getElementById("sys_date").value+"\"  onBlur=\"validateDate('F',this)\"><input type='image' name='frmdt' id='frmdt' src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].from_date.select();return showCalendar('fromdate',null,'hh:mm');\">&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img> - <input type=text id=todate name=to_date size=16 maxlength=16 value=\""+document.getElementById("def_leave_to_date").value+"\"  onBlur=\"validateDate('T',this)\"><input type='image' name='tofdt' id='tofdt' src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].to_date.select();return showCalendar('todate',null,'hh:mm');\" >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>"

		document.getElementById("from_date1").innerHTML = "<input type=text id= from_date name=from_date size=16 maxlength=16 value=\""+ convertDate(document.getElementById("sys_date").value,'DMYHM','en',localeName)+"\"  onBlur=\"validateDate('F',this);compareDates();\"><img name='frmdt' id='frmdt' src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].from_date.select();return showCalendar('from_date',null,'hh:mm');\">&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img> - <input type=text id=to_date name=to_date size=16 maxlength=16 value=\""+convertDate(document.getElementById("def_leave_to_date").value,'DMYHM','en',localeName)+"\"  onBlur=\"validateDate('T',this)\"><img name='tofdt' src='../../eCommon/images/CommonCalendar.gif' onClick=\"document.forms[0].to_date.select();return showCalendar('to_date',null,'hh:mm');\" >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>"

			
		if (document.forms[0].release_bed != null)
		{	
			var s =  document.getElementById("old_release_bed_yn").value;
			//Ragha 9/29/2004
			if((document.forms[0].release_bed_yn.value != 'Y') && (document.forms[0].hdd_allow_release_bed_on_lv.value == 'Y') && (document.forms[0].hdd_allow_rel_bed.value == 'Y'))
			{
				document.forms[0].release_bed.disabled = false;
			}

			if(document.forms[0].release_bed_yn.value == 'Y')
			{
				document.forms[0].release_bed.checked = true;
			}

			if(document.forms[0].release_bed.checked)
			{   
				document.forms[0].nursing_unit_lookup.disabled= true;
				document.forms[0].nursing_unit.readonly=true;
				document.forms[0].nursing_unit_desc.readonly=true;
				document.forms[0].Bedcode.disabled= true
				document.forms[0].Bedcode.readonly=true;
				document.forms[0].disp_room_no.readonly=true;
				document.forms[0].bed_type_code.disabled= true;
				document.forms[0].bed_type_code.readonly=true;
				document.forms[0].bed_chart.disabled = true
				document.forms[0].leave_remarks.readOnly = true 
				document.forms[0].bed_no.disabled = true
				document.forms[0].bed_no.readonly = true;
				document.forms[0].returned_date_time.readOnly = true;
				document.forms[0].returned_date_time.value = '';
				document.getElementById("redt").disabled = true;
				document.getElementById("date_time_lgd").innerHTML= getLabel("eIP.DateTimeReturned.label","IP");
				if(document.forms[0].Absconding_yn.checked==true)
				{
				document.forms[0].Absconding_yn.checked=false;
				}
				
				document.getElementById("AbsDate").value = "";

				document.forms[0].release_bed.disabled = true ;
				document.forms[0].release_bed.value			= "Y";
				document.forms[0].PseudoBed_chart.disabled	= true;
				document.forms[0].pseudoImg.style.visibility= "hidden";
				document.forms[0].gifpop1.style.visibility="hidden";
				document.forms[0].gifpop3.style.visibility="hidden";
				document.forms[0].gifpop4.style.visibility="hidden";
			}
			else
			{
				document.forms[0].release_bed.disabled = false;   
				document.forms[0].leave_remarks.readOnly = true ;                         
				document.forms[0].bed_no.readOnly = true;
				document.forms[0].nursing_unit_lookup.disabled = true;
				document.forms[0].Bedcode.disabled= true;
				document.forms[0].bed_type_code.disabled= true;
				document.forms[0].bed_chart.disabled = true;
				document.forms[0].returned_date_time.readOnly = true;
				document.forms[0].returned_date_time.value = "";
				document.getElementById("redt").disabled = true;
				document.getElementById("date_time_lgd").innerHTML= getLabel("eIP.DateTimeReturned.label","IP");
				if(document.forms[0].Absconding_yn.checked==true)
				{
				document.forms[0].Absconding_yn.checked=false;
				}
				document.getElementById("AbsDate").value = "";
				document.forms[0].gifpop1.style.visibility="hidden";
				document.forms[0].gifpop3.style.visibility="hidden";
				document.forms[0].gifpop4.style.visibility="hidden";					
			}
		}
		else
		{
			document.forms[0].leave_remarks.readOnly = true                               
			document.forms[0].bed_no.readOnly = false
			document.forms[0].nursing_unit_lookup.disabled = true
			document.forms[0].Bedcode.disabled= true
			document.forms[0].bed_type_code.disabled= true
			document.forms[0].bed_chart.disabled = true
			document.forms[0].returned_date_time.readOnly = true;
			document.forms[0].returned_date_time.value = '';
			document.getElementById("redt").disabled = true;
		   document.getElementById("date_time_lgd").innerHTML= getLabel("eIP.DateTimeReturned.label","IP");
			if(document.forms[0].Absconding_yn.checked==true)
			{
			document.forms[0].Absconding_yn.checked=false;
			}
			document.getElementById("AbsDate").value = "";
			document.forms[0].release_bed.disabled = true
			document.forms[0].gifpop1.style.visibility="hidden";
		}
		document.forms[0].bed_no.readonly = true;	
		if(document.forms[0].Absconding_yn.checked==true)
		{
		document.forms[0].Absconding_yn.checked=false;
		}
		document.getElementById("date_time_lgd").innerHTML= getLabel("eIP.DateTimeReturned.label","IP");
		document.getElementById("AbsDate").value = "";
	}
	else if(obj.value == "2")
	{
		
		if (document.forms[0].leave_stat.value == "4")
		{
		  //document.getElementById("from_date1").innerText = document.getElementById("leave_fr_date").value
		  document.getElementById("from_date1").innerText = convertDate(document.getElementById("leave_fr_date").value,'DMYHM','en',localeName);
		}
		else
		{
		   //document.getElementById("from_date1").innerText = document.getElementById("leave_fr_date").value+"  "+document.getElementById("leave_to_date").value
			document.getElementById("from_date1").innerText = convertDate(document.getElementById("leave_fr_date").value,'DMYHM','en',localeName)+" - "+convertDate(document.getElementById("leave_to_date").value,'DMYHM','en',localeName);
		}

		document.getElementById("to_date1").innerText = '';
		document.forms[0].gifpop3.style.visibility="visible";
		document.forms[0].gifpop4.style.visibility="visible";
		document.forms[0].amend_remarks.focus();

		if (document.forms[0].release_bed != null)
		{
			if((document.forms[0].release_bed_yn.value == 'Y'))
			{
			document.forms[0].release_bed.checked = true;
			}
			else
			document.forms[0].release_bed.checked = false;

			if(document.forms[0].release_bed.checked)
			{   
				document.forms[0].bed_no.readOnly				= true
				document.forms[0].nursing_unit_lookup.disabled	= true
				document.forms[0].Bedcode.disabled				= true
				document.forms[0].Bedcode.value					='';
				document.forms[0].bed_type_code.disabled		= true
				document.forms[0].bed_type_code.value			='';

				document.forms[0].leave_remarks.readOnly		= true             
				document.forms[0].bed_chart.disabled			= true
				document.forms[0].returned_date_time.readOnly	= false
				document.forms[0].returned_date_time.value  	= '';
				document.getElementById("redt").disabled						= false
				if(document.forms[0].Absconding_yn.checked==true)
				{
				document.forms[0].Absconding_yn.checked=false;
				}
				document.getElementById("AbsDate").value = "";
				document.getElementById("date_time_lgd").innerHTML= getLabel("eIP.DateTimeReturned.label","IP");
				document.forms[0].release_bed.disabled			= true
				document.forms[0].gifpop1.style.visibility		="visible";
				document.forms[0].gifpop3.style.visibility		="visible";
				document.forms[0].gifpop4.style.visibility		="visible";
			}
			else
			{                                           
				document.forms[0].nursing_unit_lookup.disabled	= true
				document.forms[0].Bedcode.disabled				= true
				document.forms[0].bed_type_code.disabled		= true
				document.forms[0].leave_remarks.readOnly		= true 
				document.forms[0].bed_no.readOnly				= true    
				document.forms[0].release_bed.disabled			= true   
				document.forms[0].bed_chart.disabled			= true
				document.forms[0].returned_date_time.readOnly	= false
				document.forms[0].returned_date_time.value  	= '';
				document.getElementById("redt").disabled						= false
				if(document.forms[0].Absconding_yn.checked==true)
				{
				document.forms[0].Absconding_yn.checked=false;
				}
				document.getElementById("AbsDate").value = "";
				document.getElementById("date_time_lgd").innerHTML= getLabel("eIP.DateTimeReturned.label","IP");
				document.forms[0].gifpop1.style.visibility		="visible";
				document.forms[0].gifpop3.style.visibility		="hidden";
				document.forms[0].gifpop4.style.visibility		="hidden";
			}
		document.forms[0].bed_type_code.value=document.forms[0].old_bed_type_code.value;
		document.forms[0].Bedcode.value=document.forms[0].old_bed_class_code.value    
		}
		else
		{                                           
			document.forms[0].nursing_unit_lookup.disabled	= true
			document.forms[0].Bedcode.disabled				= true
			document.forms[0].bed_type_code.disabled		= true
			document.forms[0].leave_remarks.readOnly		= true 
			document.forms[0].bed_no.readOnly				= true    
			document.forms[0].bed_chart.disabled			= true
			document.forms[0].returned_date_time.readOnly	= true
			document.forms[0].returned_date_time.value  	= '';
			document.getElementById("redt").disabled						= true;
			if(document.forms[0].Absconding_yn.checked==true)
			{
			document.forms[0].Absconding_yn.checked=false;
			}
			document.getElementById("AbsDate").value = "";
			document.getElementById("date_time_lgd").innerHTML= getLabel("eIP.DateTimeReturned.label","IP");
			document.forms[0].release_bed.disabled			= true
			document.forms[0].gifpop1.style.visibility	=	"hidden";
		}
	}

	if( obj.value == "3")
	{
		
		document.forms[0].gifpop1.style.visibility="hidden";
		document.forms[0].gifpop3.style.visibility="hidden";
		document.forms[0].gifpop4.style.visibility="hidden";
		//document.getElementById("from_date1").innerText = document.getElementById("leave_fr_date").value +" - " + document.getElementById("leave_to_date").value
		document.getElementById("from_date1").innerText = convertDate(document.getElementById("leave_fr_date").value,'DMYHM','en',localeName)+" - "+convertDate(document.getElementById("leave_to_date").value,'DMYHM','en',localeName);
		
		document.getElementById("to_date1").innerText = '';
		document.forms[0].bed_no.readOnly				= true
		document.forms[0].nursing_unit_lookup.disabled	= true
		document.forms[0].Bedcode.disabled				= true
		document.forms[0].bed_type_code.disabled		= true
		document.forms[0].leave_remarks.disabled		= true             
		document.forms[0].release_bed.checked = false;
		document.forms[0].release_bed.disabled	= true   
		document.forms[0].bed_chart.disabled	= true
		document.forms[0].returned_date_time.readOnly = false;
		document.forms[0].returned_date_time.value	  = '';
		document.forms[0].gifpop1.style.visibility = "visible";
		document.getElementById("date_time_lgd").innerHTML= getLabel("eIP.RecordNoShowDateTime.label","IP")

		document.getElementById("redt").disabled				= false

	if (document.forms[0].release_bed != null)
		{	
			if((document.forms[0].release_bed_yn.value == 'Y'))
			{
				document.forms[0].release_bed.checked = true;
			}
			else
				document.forms[0].release_bed.checked = false;
		}
	}
	
	if(obj.value == "9")
	{   
		//document.getElementById("from_date1").innerText = document.getElementById("leave_fr_date").value+" - "+document.getElementById("leave_to_date").value
		document.getElementById("from_date1").innerText = convertDate(document.getElementById("leave_fr_date").value,'DMYHM','en',localeName)+" - "+convertDate(document.getElementById("leave_to_date").value,'DMYHM','en',localeName);
	  
		document.getElementById("to_date1").innerText = ''

		 if(document.forms[0].release_bed != null)
		 {
			if((document.forms[0].release_bed_yn.value == 'Y'))
			{
				document.forms[0].release_bed.checked = true;
			}
			else
				document.forms[0].release_bed.checked = false;

			 if(document.forms[0].release_bed.checked )
			{   
				document.forms[0].leave_remarks.disabled		= true 
				document.forms[0].release_bed.disabled			= true
				document.forms[0].returned_date_time.readOnly	= true
				document.getElementById("redt").disabled						= true
				if(document.forms[0].Absconding_yn.checked==true)
				{
				document.forms[0].Absconding_yn.checked=false;
				}
				document.getElementById("AbsDate").value = "";
				document.getElementById("date_time_lgd").innerHTML= getLabel("eIP.DateTimeReturned.label","IP");
				document.forms[0].gifpop1.style.visibility		= "hidden"; 
				document.forms[0].gifpop3.style.visibility		= "visible";
				document.forms[0].gifpop4.style.visibility		= "visible"; 
			}
			else
			{                           
				document.forms[0].bed_no.readOnly = true
				document.forms[0].nursing_unit_lookup.disabled = true
				document.forms[0].leave_remarks.disabled = true                           
				document.forms[0].release_bed.disabled = true                             
				document.forms[0].bed_chart.disabled = true
				document.forms[0].returned_date_time.readOnly = true
				document.getElementById("redt").disabled = true
				if(document.forms[0].Absconding_yn.checked==true)
				{
				document.forms[0].Absconding_yn.checked=false;
				}
				document.getElementById("AbsDate").value = "";
				document.getElementById("date_time_lgd").innerHTML= getLabel("eIP.DateTimeReturned.label","IP");
				document.forms[0].gifpop3.style.visibility="hidden";
				document.forms[0].gifpop4.style.visibility="hidden";
				document.forms[0].gifpop1.style.visibility="hidden";
			}
		}
		else
		{                           
			document.forms[0].bed_no.readOnly = true
			document.forms[0].nursing_unit_lookup.disabled = true
			document.forms[0].Bedcode.disabled= true
			document.forms[0].bed_type_code.disabled= true
			document.forms[0].leave_remarks.disabled = true                             
			document.forms[0].release_bed.disabled = true                                 
			document.forms[0].bed_chart.disabled = true
			document.forms[0].returned_date_time.readOnly = true
			document.getElementById("redt").disabled = true
			if(document.forms[0].Absconding_yn.checked==true)
			{
			document.forms[0].Absconding_yn.checked=false;
			}
			document.getElementById("AbsDate").value = "";
			document.getElementById("date_time_lgd").innerHTML= getLabel("eIP.DateTimeReturned.label","IP");
		}
	}


/// Added by Sridhar R on 14 JUNE 2004
/// This block of cade will Enable/Disable Release Bed check Box based on transaction type 
/*
	LEAVE_STATUS 
--------------------------------
	obj.value = '1'>Revise Leave
	obj.value = '2'>Record Return
	obj.value = '3'>Record No Show
	obj.value = '9'>Cancel Leave


Transaction Type		Release BEd Chk Box
*********************************************************************
Revise Leave			Enable - Release Bed Chk Box if [IP_Param] & [IP_nursing_unit] 							Value is 'Y'
Record Return			Disable
Record no Show			Disable
Cancel Leave			Disable

*/
	if(obj.value == "2" || obj.value == "3" || obj.value == "9" )
	{
		document.forms[0].release_bed.disabled		= true;
		document.forms[0].release_bed.value			= "N";
		document.forms[0].PseudoBed_chart.disabled	= true;
		document.forms[0].pseudoImg.style.visibility="hidden";	
	}
	else if(obj.value == "1" )
	{
		if(	document.forms[0].hdd_allow_release_bed_on_lv.value == 'Y' && document.forms[0].hdd_allow_rel_bed.value == 'Y' )
		{
			if(document.forms[0].release_bed.checked==false)
			 document.forms[0].release_bed.disabled		= false;
		}
		else
		{
			document.forms[0].release_bed.disabled		= true;
			document.forms[0].release_bed.value			= "";				document.forms[0].PseudoBed_chart.disabled	= true;
			document.forms[0].pseudoImg.style.visibility="hidden";	
		}
	}

	if(obj.value == "2")
	{
		if(document.forms[0].release_bed.checked)
		{
			document.forms[0].pseudo_bed.value = document.forms[0].hddPseudobed.value;
		}
	}   
}

function gifdisp(getVal)
{
	if (getVal == '1' )
	{
		document.forms[0].gifpop1.style.visibility="hidden";
		document.forms[0].gifpop3.style.visibility="hidden";
		document.forms[0].gifpop4.style.visibility="hidden";
	}
	else if (getVal == '2' )
	{
		document.forms[0].gifpop1.style.visibility="visible";
		document.forms[0].gifpop3.style.visibility="visible";
		document.forms[0].gifpop4.style.visibility="visible";
	}
	else if (getVal == '9')
	{
		document.forms[0].gifpop1.style.visibility="hidden";
		document.forms[0].gifpop3.style.visibility="visible";
		document.forms[0].gifpop4.style.visibility="visible";
	}
}

/**Chk the max Limit of the entered Value **/
function checkMaxLimit1(obj,maxSize)	
{
	makeValidString(obj);
	var len  = obj.value;
	if ( len.length >= maxSize )
	{
		alert(getMessage('CANT_XCEED_500_CHARS','IP'));
		event.returnValue = false;
		obj.focus();
	}	
}	

function chklim(obj,maxSize)	
{
	var len  = obj.value;
	if ( obj.value.length >= maxSize )
	{
	   obj.focus();
		event.returnValue = false;
	}
}

/*
@param: obj
@function name: absChecked()
@Name & Date: Kishore on 4/20/2004
@Reason: If Absconding Checked then only allow to enter AbsDate, reported_to
*/
function absChecked(obj)
{
	if(obj.checked  == true)
	{
		document.forms[0].reported_to.readOnly = false;
		document.forms[0].AbsDate.readOnly = false;
		document.forms[0].AbsDate.disabled = false;
		document.getElementById("AbsDateImg").disabled = false;
		document.getElementById("absgif").disabled=false;
		document.forms[0].absgif.style.visibility="visible";
		document.getElementById("inform_to").disabled  = false;

		document.getElementById("pol_rep_no").disabled		=	false;
		document.getElementById("pol_stn_id").disabled		=	false;
		document.getElementById("pol_id").disabled			=	false;

		document.forms[0].gifpop1.style.visibility = "hidden";
		document.forms[0].returned_date_time.readOnly = true;
		document.forms[0].returned_date_time.value = '';
		document.getElementById("redt").disabled = true;
	}
	else
	{
		if(!document.getElementById("reported_to"))//Wednesday, June 30, 2010 , added for SRR20056-SCF-4765-IN022431
			document.forms[0].reported_to.value="";
		document.forms[0].reported_to.readOnly = true;
		document.forms[0].AbsDate.readOnly = true;
		document.forms[0].AbsDate.value="";
		document.getElementById("AbsDateImg").disabled = true;
		document.getElementById("absgif").disabled=true;
		document.forms[0].absgif.style.visibility="hidden";
		document.getElementById("inform_to").disabled  = true;
		document.getElementById("informed_name").disabled  = true;
		document.getElementById("informed_date").disabled  = true;  
		if(document.getElementById("inform_to").value == "" )
		{
			document.getElementById("inform_to").options[0].selected  = true;
			document.getElementById("inform_to").disabled  = true;
			document.getElementById("informed_name").disabled  = true;
			document.getElementById("informed_name").value  = "";
			document.getElementById("informed_date").disabled  = true;   
			document.getElementById("informed_date").value  = "";   
		}
		
		document.forms[0].absgif.style.visibility = "hidden";
		document.getElementById("AbsDateImg").disabled = true;

		document.getElementById("im").style.visibility = 'hidden';
		document.getElementById("im2").disabled	=	true;

		document.getElementById("pol_rep_no").disabled		=	true;
		document.getElementById("pol_stn_id").disabled		=	true;
		document.getElementById("pol_id").disabled		    =	true;
		
		
		if(!document.getElementById("pol_rep_no"))//Wednesday, June 30, 2010 , added for SRR20056-SCF-4765-IN022431
			document.getElementById("pol_rep_no").value		=	"";
		if(!document.getElementById("pol_stn_id"))//Wednesday, June 30, 2010 , added for SRR20056-SCF-4765-IN022431			
			document.getElementById("pol_stn_id").value		=	"";
		if(!document.getElementById("pol_id"))//Wednesday, June 30, 2010 , added for SRR20056-SCF-4765-IN022431
			document.getElementById("pol_id").value			=	"";
		

		document.forms[0].gifpop1.style.visibility = "visible";
		document.forms[0].returned_date_time.readOnly = false;
		document.getElementById("redt").disabled = false;
	}
}

	function dispAmendDetail()
    {
		//document.getElementById("amend_dtl").innerText=" "+getLabel("eIP.RecordNoShowDetails.label","IP");
		/*Thursday, December 30, 2010 , SRR20056-SCF-6324 [IN:025707]*/
		if(document.forms[0].trans_type.value == '2')
			document.getElementById("amend_dtl").innerText=" "+getLabel("eIP.RecordReturnDetails.label","IP");
		else if(document.forms[0].trans_type.value == '3')
			document.getElementById("amend_dtl").innerText=" "+getLabel("eIP.RecordNoShowDetails.label","IP");
		else if(document.forms[0].trans_type.value == '1')
			document.getElementById("amend_dtl").innerText=" "+getLabel("eIP.ReviseLeaveDetails.label","IP");
		else if(document.forms[0].trans_type.value == '9')
			document.getElementById("amend_dtl").innerText=" "+getLabel("eIP.CancelLeaveDetails.label","IP");
		/**/
		document.getElementById("reported_to_lgd").innerHTML=getLabel("eIP.InformedOthers.label","IP");
		document.forms[0].bed_type_code.value = document.forms[0].old_bed_type_code.value;
		document.forms[0].Bedcode.value = document.forms[0].old_bed_class_code.value;
		document.getElementById("pol_rep_no").disabled		= true;
		document.getElementById("pol_stn_id").disabled		= true;
		document.getElementById("pol_id").disabled			= true;
		document.getElementById("inform_to").disabled			= true;
		
	}
        
	function populateAmenddtls(Obj) 
	{
		if(Obj.value =='2')
		{
			document.getElementById("amend_dtl").innerText=getLabel("eIP.RecordReturnDetails.label","IP");
			document.forms[0].amend_remarks.value ='';  // Friday, February 05, 2010 18916 (Venkat S)
		}
		else if(Obj.value =='3')
		{
			document.getElementById("amend_dtl").innerText=getLabel("eIP.RecordNoShowDetails.label","IP");
		    document.forms[0].amend_remarks.value =''; // Friday, February 05, 2010 18916 (Venkat S)
		}
		else if(Obj.value =='1')
		{
			document.getElementById("amend_dtl").innerText=getLabel("eIP.ReviseLeaveDetails.label","IP");
			document.forms[0].amend_remarks.value =''; // Friday, February 05, 2010 18916 (Venkat S)
		}
		else if(Obj.value =='9')
		{
			document.getElementById("amend_dtl").innerText=getLabel("eIP.CancelLeaveDetails.label","IP"); 
			document.forms[0].amend_remarks.value =''; // Friday, February 05, 2010 18916 (Venkat S)
		}
	}

function enableInformName()
{
	if (document.getElementById("inform_to").value!="")
	{
		document.getElementById("im").style.visibility = 'visible';
		document.getElementById("informed_date").disabled	=	false;
		document.getElementById("infocalimg").disabled		=	false;
		document.getElementById("informed_name").disabled	=	false;
	}
	if (document.getElementById("inform_to").value=="")
	{
		document.getElementById("im").style.visibility = 'hidden';
		document.getElementById("informed_date").disabled	=	true;
		document.getElementById("informed_name").disabled	=	true;
		document.getElementById("informed_name").value	=	'';
		document.getElementById("informed_date").value	=	'';
		document.getElementById("infocalimg").disabled		=	false;
	}
	if ((document.forms[0].inform_to.value == "01") || (document.forms[0].inform_to.value == "02"))
	{
		var patientid	= document.forms[0].patient_id.value;
		var informTo	= document.forms[0].inform_to.value;

		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dummy_form' id='dummy_form' method='post'  action='../../eIP/jsp/ValidateRenewPeriod.jsp' ><input type='hidden' name='field1' id='field1' value='InformDetails'><input type='hidden' name='field2' id='field2' value='"+patientid+"'><input type='hidden' name='field3' id='field3' value='"+informTo+"'><input type='hidden' name='field4' id='field4' value='RecordInpatientLeave'><input type='hidden' name='field5' id='field5' value='Leave'></form></body></html>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.dummy_form.submit();
		document.getElementById("informed_name").disabled	=	false;
	}
}
function checkFieldLocal( field, name ) {
    var errors = '' ;
    if( trimCheck(field.value) )
    {
        field.value = trimString(field.value);
        return true;
    }
    else
    {
		errors = errors + getMessage("CAN_NOT_BE_BLANK","Common");
		errors = errors.replace('$',name);
        alert(errors) ;
        field.focus();
        return false ;
    }
}


