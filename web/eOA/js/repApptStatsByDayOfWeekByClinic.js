function run() 
{
var fields = new Array( f_query_add_mod.document.forms[0].dat);
var names = new Array(getLabel("Common.StartDate.label","Common"));



if(f_query_add_mod.checkFields( fields, names, messageFrame))
{
	f_query_add_mod.document.forms[0].P_From_Clinic_Code.value = f_query_add_mod.document.forms[0].from_clinic_code.value;
	f_query_add_mod.document.forms[0].P_To_Clinic_Code.value = f_query_add_mod.document.forms[0].to_clinic_code.value; f_query_add_mod.document.forms[0].P_Start_Date.value=f_query_add_mod.document.forms[0].dat.value;
	//alert(" P_Start_Date :"+f_query_add_mod.document.forms[0].P_Start_Date.value);
	if( f_query_add_mod.CheckString1(getLabel("Common.locationcode.label","Common"), f_query_add_mod.document.forms[0].P_From_Clinic_Code,f_query_add_mod.document.forms[0].P_To_Clinic_Code, messageFrame )  )
    if( f_query_add_mod.CheckString1(getLabel("Common.SpecialityCode.label","Common") , f_query_add_mod.document.forms[0].p_fm_special,f_query_add_mod.document.forms[0].p_to_special, messageFrame )  ) {
	f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
	f_query_add_mod.document.forms[0].target="messageFrame";
	f_query_add_mod.document.forms[0].submit();  }
}
}
function reset()
{
	   f_query_add_mod.document.location.reload();
}

function changeVal(obj)
{
	document.forms[0].P_LOCATION_TYPE.value=obj.value;
	document.forms[0].from_clinic_code.value='';
	document.forms[0].to_clinic_code.value='';
}


 function CheckString1(str ,fromobj,toobj,messageFrame) {

	 var arr = new Array(toobj.value,fromobj.value);
    if( trimCheck(fromobj.value) && trimCheck(toobj.value) ) {
        if(fromobj.value <= toobj.value) {
            return true;
        }
        else {
			var error=getMessage("REMARKS_MUST_GR_EQUAL","common",arr);
		
			error=error.replace("$",getLabel('Common.to.label','common_labels')+ ' ' +str);
			error=error.replace("#",str);
            messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
            return false;
        }
    }
    else {
        return true;
    }
}



/*function searchCode(obj,target)
{
	var retVal = 	new String();
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var p_location_type1=document.forms[0].p_location_type1.value;
	var facilityid = document.forms[0].P_Facility_id.value;
	var locale=document.forms[0].locale.value;
	var tit="";
	if(obj.name=="locn")
	{
		tit=encodeURIComponent(getLabel("Common.Location.label","Common"));
		sql="select clinic_code, long_desc from op_clinic_lang_vw where facility_id=`"+facilityid+"` and language_id=`"+locale+"` and CARE_LOCN_TYPE_IND=nvl(`"+p_location_type1+"`,CARE_LOCN_TYPE_IND)";
		search_code="clinic_code";
		search_desc= "long_desc";
		
	}	
	if(obj.name=="spec")
	{
		tit=encodeURIComponent(getLabel("Common.speciality.label","Common"));
		sql="select speciality_code,short_Desc from am_speciality_lang_vw where language_id=`"+locale+"`";
		search_code=" speciality_code";
		search_desc= "short_desc";
		
	}	
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

	if (!(retVal == null))
	{
		target.value=retVal;
	}
	else
		target.focus();
}*/



			async function searchCode1(obj,target_code,target_desc)
				{


				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var locale=document.forms[0].locale.value;
				var tit="";
				var sql="";

			var p_location_type1=document.forms[0].p_location_type1.value;
			var facilityid = document.forms[0].P_Facility_id.value;
			var locale=document.forms[0].locale.value;
			

			if(obj.name=="locn" || obj.name=="from_clinic_code" || obj.name=="to_clinic_code")
			{
				tit=getLabel("Common.Location.label","Common");
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facilityid+"' and language_id='"+locale+"' and CARE_LOCN_TYPE_IND=nvl('"+p_location_type1+"',CARE_LOCN_TYPE_IND) and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2";
				
				
			}	
			if(obj.name=="spec" || obj.name=="p_fm_special" || obj.name=="p_to_special")
			{
				tit=getLabel("Common.speciality.label","Common");
				sql="select speciality_code code,short_Desc description from am_speciality_lang_vw where language_id='"+locale+"'  and upper(speciality_code) like upper(?) and upper(short_Desc) like upper(?) order by 2";
								
			}	

			
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target_code.value;
				argumentArray[6] = CODE_LINK ;
				argumentArray[7] = CODE_DESC ;
				
				retVal = await CommonLookup( tit, argumentArray );
				if (retVal !=null && retVal !="")
				{
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target_desc.value=arr[1];
					target_code.value=arr[0];
				}else
				{
				target_desc.value="";
				target_code.value="";
				}
			
			}

function getDay(){

	var d_dates = document.forms[0].dat.value;
	var greg_obj1 = convertDate(d_dates,"DMY",localeName,"en");
	var dayOfWeek = getDayOfWeek(greg_obj1,"DMY", 'en');
	var Vdate= parseInt(dayOfWeek);

	//Added by Ashwini on 27-Nov-2017 for ML-MMOH-SCF-0875
	var end_date = document.forms[0].end_date.value;
	var greg_obj = convertDate(end_date,"DMY",localeName,"en");
	var dayOfEndDate = getDayOfWeek(greg_obj,"DMY", 'en');
	var Edate= parseInt(dayOfEndDate);

	   if((Vdate != "NaN") ||  (Edate != "NaN"))
	   {
	   	switch(Vdate)
	   	{
			case 1:
			  Vdate=getLabel("Common.mon.label","Common");
			  break;	  
			case 2:
			  Vdate=getLabel("Common.tue.label","Common");
			  break;
			case 3:
			  Vdate=getLabel("Common.wed.label","Common");
			  break;
			case 4:
			  Vdate=getLabel("Common.thu.label","Common");
			  break;
			case 5:
			  Vdate=getLabel("Common.fri.label","Common");
			  break;
			case 6:
			  Vdate=getLabel("Common.sat.label","Common");
			  break; 
			case 7:
			  Vdate=getLabel("Common.sun.label","Common");
			  break;
	   	}

		//Added by Ashwini on 27-Nov-2017 for ML-MMOH-SCF-0875
		switch(Edate)
	   	{
			case 1:
			  Edate=getLabel("Common.mon.label","Common");
			  break;	  
			case 2:
			  Edate=getLabel("Common.tue.label","Common");
			  break;
			case 3:
			  Edate=getLabel("Common.wed.label","Common");
			  break;
			case 4:
			  Edate=getLabel("Common.thu.label","Common");
			  break;
			case 5:
			  Edate=getLabel("Common.fri.label","Common");
			  break;
			case 6:
			  Edate=getLabel("Common.sat.label","Common");
			  break; 
			case 7:
			  Edate=getLabel("Common.sun.label","Common");
			  break;
	   	}
	  }
	if((Vdate != "NaN") ||  (Edate != "NaN"))
	{
	   document.getElementById('sys1').innerHTML=Vdate;
	   document.getElementById('endDate').innerHTML=Edate;
	}
	else
	{
		document.getElementById('sys1').innerHTML="&nbsp;";
		document.getElementById('endDate').innerHTML="&nbsp;";
	}
}

/*function DateSetup()
{
document.forms[0].p_report_id.value="OADWKCLST";
var dates = document.forms[0].dat.value;
//var greg_dates = convertDate(dates,"DMY",localeName,"en");
//alert("greg_dates :"+greg_dates);
var dd = dates.split("/");

var dat = eval(dd[0]);
var dd1 = eval(dd[0])+6;
var mm = eval(dd[1]);
var yy = eval(dd[2]);
	if(mm=="04"||mm=="06"||mm=="09"||mm=="11")
	{
		if(dd1>"30")
		{
			var dd2 = dd1-30;
			mm = eval(dd[1])+1;
			document.forms[0].end_date.value = dd2+"/"+mm+"/"+dd[2];
		}
		else
		{
			document.forms[0].end_date.value = dd1+"/"+mm+"/"+dd[2];
		}
	}
	if(mm=="01"||mm=="03"||mm=="05"||mm=="07"
		||mm=="08"||mm=="10")
	{
		if(dd1>"31")
		{
			var dd2 = dd1-31;
			mm = eval(dd[1])+1;
			document.forms[0].end_date.value = dd2+"/"+mm+"/"+dd[2];
		}
		else
		{
			document.forms[0].end_date.value = dd1+"/"+mm+"/"+dd[2];
		}
	}
	if(mm=="12")
	{
		if(dd1>"31")
		{
			var dd2 = dd1-31;
			mm = "01";
			yy = eval(dd[2])+1;
			document.forms[0].end_date.value = dd2+"/"+mm+"/"+yy;
		}
		else
		{
			document.forms[0].end_date.value = dd1+"/"+mm+"/"+dd[2];
		}
	}
	else if(mm=="02")
	{
		if (yy % 100 == 0)
		{
			if (yy % 400 == 0)
			{
				if(dd1>"29")
				{
					var dd2 = dd1-29;
					mm = eval(dd[1])+1;
					document.forms[0].end_date.value =dd2+"/"+mm+"/"+dd[2];
				}
				else
				{
				document.forms[0].end_date.value = dd1+"/"+mm+"/"+dd[2];
				}
			}
		}
		else if ((yy % 4) == 0)
		{
			if(dd1>"29")
			{
				var dd2 = dd1-29;
				mm = eval(dd[1])+1;
				document.forms[0].end_date.value = dd2+"/"+mm+"/"+dd[2];
			}
			else
			{
				document.forms[0].end_date.value = dd1+"/"+mm+"/"+dd[2];
			}
		}
		else 
		{
			if(dd1>"28")
			{
				var dd2 = dd1-28;
				mm = eval(dd[1])+1;
				document.forms[0].end_date.value = dd2+"/"+mm+"/"+dd[2];
			}
			else
			{
				document.forms[0].end_date.value = dd1+"/"+mm+"/"+dd[2];
			}
		}
	}
}	
*/


function ValidateDate(obj)
{
	if(obj.value!="")
	{
	if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
		else
		{
			DateSetup();
			getDay();
		}
	}else
	{
		document.forms[0].end_date.value ="";
		document.getElementById('sys1').innerHTML="&nbsp;";
		//Added by Ashwini on 27-Nov-2017 for ML-MMOH-SCF-0875
		document.getElementById('endDate').innerHTML="&nbsp;";
	}
}




function DateSetup()
{
	document.forms[0].p_report_id.value="OADWKCLST";
	var dates = document.forms[0].dat.value;

	if(dates.value!="")
	{
		var con_date= plusDate(dates,"DMY",localeName,6,"d");
	}
	
	document.forms[0].end_date.value = con_date;
}
