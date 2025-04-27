function reset() {


	 f_query_add_mod.document.forms[0].ds_from_date1.disabled=false;
	 f_query_add_mod.document.forms[0].ds_to_date1.disabled=false;
	 f_query_add_mod.document.forms[0].ds_from_date2.disabled=true;
	 f_query_add_mod.document.forms[0].ds_to_date2.disabled=true;
	 f_query_add_mod.document.forms[0].ds_from_date3.disabled=true;
	 f_query_add_mod.document.forms[0].ds_to_date3.disabled=true;
	 while (f_query_add_mod.document.forms[0].p_indicator_mark.options.length >0)
				f_query_add_mod.document.forms[0].p_indicator_mark.remove(f_query_add_mod.document.forms[0].p_indicator_mark.options[0]);	
	 var opt = "";
			opt = document.createElement("OPTION");
			opt.text = '--- '+getLabel("Common.defaultSelect.label","Common")+' ---';
			opt.value= '';
			f_query_add_mod.document.forms[0].p_indicator_mark.add(opt);
			f_query_add_mod.document.forms[0].p_indicator_mark.value="";
	 f_query_add_mod.document.forms[0].p_indicator_mark.disabled=true;

	/* added as per the requirement of of ICN 1003*/
	 f_query_add_mod.document.forms[0].from_date_cal.disabled=false
	 f_query_add_mod.document.forms[0].to_date_cal.disabled=false;
	 f_query_add_mod.document.forms[0].from_month_cal.disabled=true;
	 f_query_add_mod.document.forms[0].to_month_cal.disabled=true;
	 f_query_add_mod.document.forms[0].ds_from_date1_img.style.visibility="visible";
	 f_query_add_mod.document.forms[0].ds_to_date1_img.style.visibility="visible";
	 f_query_add_mod.document.forms[0].ds_from_date2_img.style.visibility="hidden";
	 f_query_add_mod.document.forms[0].ds_to_date2_img.style.visibility="hidden";
	 f_query_add_mod.document.forms[0].ds_from_date3_img.style.visibility="hidden";
	 f_query_add_mod.document.forms[0].ds_to_date3_img.style.visibility="hidden";




	f_query_add_mod.document.repBirthStat.reset() ;

}
/***************************************************************************/
/*function validateMonth_Year(month_year,from,to,messageFrame)
{
fromarray	= from.value.split("/");
Toarray		= to.value.split("/");

if(month_year=="month")
{
	
 f_query_add_mod.document.repBirthStat.p_fm_mon.value=fromarray[0];
 f_query_add_mod.document.repBirthStat.p_fm_year.value=fromarray[1];
 f_query_add_mod.document.repBirthStat.p_to_mon.value=Toarray[0];
 f_query_add_mod.document.repBirthStat.p_to_year.value=Toarray[1];
}
else if (month_year=="year")
{
 f_query_add_mod.document.repBirthStat.p_fm_mon.value=fromarray[0];
 f_query_add_mod.document.repBirthStat.p_fm_year.value=fromarray[0];
 f_query_add_mod.document.repBirthStat.p_to_mon.value=Toarray[0];
 f_query_add_mod.document.repBirthStat.p_to_year.value=Toarray[0];

}
var frommon =  f_query_add_mod.document.repBirthStat.p_fm_mon;
var tomon   =  f_query_add_mod.document.repBirthStat.p_to_mon ; var fromyear= f_query_add_mod.document.repBirthStat.p_fm_year;
var toyear  = f_query_add_mod.document.repBirthStat.p_to_year ;
	
	

if(fromyear.value == toyear.value)
    {
	  if( f_query_add_mod.CheckString(getLabel('Common.month.label','common'), frommon , tomon, messageFrame ) ) 
	  {
		if( f_query_add_mod.CheckString(getLabel('Common.year.label','common'), fromyear , toyear, messageFrame ) ) 
		{
		return true;
		}
	  }		
	}
	else
	{
		if( f_query_add_mod.CheckString(getLabel('Common.year.label','common'), fromyear , toyear, messageFrame ) ) 
		{
			return true;		
		}
	}


}*/

/****************************************************************************/
function run() {
	var chk_flag=false;

if( f_query_add_mod.document.repBirthStat.dmy_ind.value == 'D')
{
	

		var fields2 = new Array (  f_query_add_mod.document.repBirthStat.p_range_id, f_query_add_mod.document.repBirthStat.ds_from_date1, f_query_add_mod.document.repBirthStat.ds_to_date1);

		var names2  = new Array ( getLabel('eMP.WeightRange.label','MP'), getLabel('Common.fromdate.label','common'), getLabel('Common.todate.label','common'));
		
}
else if ( f_query_add_mod.document.repBirthStat.dmy_ind.value == 'M')
{
		
		var fields2 = new Array (  f_query_add_mod.document.repBirthStat.p_range_id,  f_query_add_mod.document.repBirthStat.ds_from_date2, f_query_add_mod.document.repBirthStat.ds_to_date2);

		var names2  = new Array ( getLabel('eMP.WeightRange.label','MP'), getLabel('Common.from.label','common')+" "+ getLabel('Common.month.label','common')+"/"+getLabel('Common.year.label','common'),getLabel('Common.to.label','common')+" "+ getLabel('Common.month.label','common')+"/"+getLabel('Common.year.label','common'));
		
}
else if ( f_query_add_mod.document.repBirthStat.dmy_ind.value == 'Y')
{
		var fields2 = new Array (  f_query_add_mod.document.repBirthStat.p_range_id,  f_query_add_mod.document.repBirthStat.ds_from_date3, f_query_add_mod.document.repBirthStat.ds_to_date3);

		var names2  = new Array (  getLabel('eMP.WeightRange.label','MP'),getLabel('Common.from.label','common')+" " +getLabel('Common.year.label','common'),getLabel('Common.to.label','common')+" "+getLabel('Common.year.label','common'));
		
}


 if( f_query_add_mod.checkFields( fields2, names2, messageFrame))
	{
	 if ( f_query_add_mod.document.forms[0].dmy_ind.value=='D')
	
	 {
		 if(  doDateChkWithLabel(  f_query_add_mod.document.forms[0].ds_from_date1,  f_query_add_mod.document.forms[0].ds_to_date1, messageFrame,'DMY',getLabel('Common.date.label','common') ) ) 
		{
			 chk_flag=true;
			 f_query_add_mod.document.forms[0].ds_from_date.value =  f_query_add_mod.document.forms[0].ds_from_date1.value;
			 f_query_add_mod.document.forms[0].ds_to_date.value =  f_query_add_mod.document.forms[0].ds_to_date1.value;
			//f_query_add_mod.document.repBirthStat.submit();
		}

	 }
 else if( f_query_add_mod.document.forms[0].dmy_ind.value=='M')
	 {
	
	// if( validateMonth_Year("month", f_query_add_mod.document.forms[0].ds_from_date2,  f_query_add_mod.document.forms[0].ds_to_date2, messageFrame ) ) 
		if(doDateChkWithLabel(f_query_add_mod.document.forms[0].ds_from_date2,  f_query_add_mod.document.forms[0].ds_to_date2, messageFrame,'MY',getLabel('Common.month.label','common')+"/"+getLabel('Common.year.label','common') ))
		{		
			 chk_flag=true;		
			 f_query_add_mod.document.forms[0].ds_from_date.value =  f_query_add_mod.document.forms[0].ds_from_date2.value;
			 f_query_add_mod.document.forms[0].ds_to_date.value =  f_query_add_mod.document.forms[0].ds_to_date2.value;
			//f_query_add_mod.document.repBirthStat.submit();
		 }
	 }
 else if ( f_query_add_mod.document.forms[0].dmy_ind.value=='Y')
		 {
		 	 // if( validateMonth_Year("year", f_query_add_mod.document.forms[0].ds_from_date3,  f_query_add_mod.document.forms[0].ds_to_date3, messageFrame ) ) 
	  if( doDateChkWithLabel(f_query_add_mod.document.forms[0].ds_from_date3,  f_query_add_mod.document.forms[0].ds_to_date3, messageFrame,'YY',getLabel('Common.year.label','common') ) ) 
		{		
		     chk_flag=true;
			 f_query_add_mod.document.forms[0].ds_from_date.value =  f_query_add_mod.document.forms[0].ds_from_date3.value;
			 f_query_add_mod.document.forms[0].ds_to_date.value =  f_query_add_mod.document.forms[0].ds_to_date3.value;
			//f_query_add_mod.document.repBirthStat.submit();
		}
	 }	
	 if(chk_flag)
		{
	      if( f_query_add_mod.CheckString( getLabel('eMP.DeliveryType.label','MP'),f_query_add_mod.document.repBirthStat.p_fm_nod_type, f_query_add_mod.document.repBirthStat.p_to_nod_type, messageFrame ) )

		 if( f_query_add_mod.CheckString( getLabel('eMP.AttendingNurse.label','MP'), f_query_add_mod.document.repBirthStat.p_fm_attend_midwife, f_query_add_mod.document.repBirthStat.p_to_attend_midwife, messageFrame ) )
		 if( f_query_add_mod.CheckString( getLabel('Common.AttendingPractitioner.label','common'), f_query_add_mod.document.repBirthStat.p_fm_attend_pract, f_query_add_mod.document.repBirthStat.p_to_attend_pract, messageFrame ) )
			f_query_add_mod.document.repBirthStat.submit();
		}
	
	}


//		f_query_add_mod.document.repBirthStat.submit() ;
}

function changeReportType(obj)
{
	var fieldval = obj.value;

	if (fieldval=='M')
	{
		parent.frames[1].document.forms[0].ds_from_date1.disabled=true;
		parent.frames[1].document.forms[0].ds_from_date1.value="";

		parent.frames[1].document.forms[0].ds_from_date1_img.style.visibility="hidden";
		parent.frames[1].document.forms[0].ds_to_date1.disabled=true;
		parent.frames[1].document.forms[0].ds_to_date1.value="";
		parent.frames[1].document.forms[0].ds_to_date1_img.style.visibility="hidden";
		parent.frames[1].document.forms[0].ds_from_date2.disabled=false;
		parent.frames[1].document.forms[0].ds_from_date2_img.style.visibility="visible";
		parent.frames[1].document.forms[0].ds_to_date2.disabled=false;
		parent.frames[1].document.forms[0].ds_to_date2_img.style.visibility="visible";
		parent.frames[1].document.forms[0].ds_from_date3.disabled=true;
		parent.frames[1].document.forms[0].ds_from_date3.value="";
		parent.frames[1].document.forms[0].ds_from_date3_img.style.visibility="hidden";
		parent.frames[1].document.forms[0].ds_to_date3.disabled=true;
		parent.frames[1].document.forms[0].ds_to_date3.value="";
		parent.frames[1].document.forms[0].ds_to_date3_img.style.visibility="hidden";
		/* added as per the requirement of of ICN 1003*/
		parent.frames[1].document.forms[0].from_date_cal.disabled=true;
		parent.frames[1].document.forms[0].to_date_cal.disabled=true;
		/* added as per the requirement of of ICN 1003*/
		parent.frames[1].document.forms[0].from_month_cal.disabled=false;
		parent.frames[1].document.forms[0].to_month_cal.disabled=false;
	
	}
	else if (fieldval=='Y')
	{
		parent.frames[1].document.forms[0].ds_from_date1.disabled=true;
		parent.frames[1].document.forms[0].ds_from_date1.value="";
		parent.frames[1].document.forms[0].ds_from_date1_img.style.visibility="hidden";
		parent.frames[1].document.forms[0].ds_to_date1.disabled=true;
		parent.frames[1].document.forms[0].ds_to_date1.value="";
		parent.frames[1].document.forms[0].ds_to_date1_img.style.visibility="hidden";
		parent.frames[1].document.forms[0].ds_from_date2.disabled=true;
		parent.frames[1].document.forms[0].ds_from_date2.value="";
		parent.frames[1].document.forms[0].ds_from_date2_img.style.visibility="hidden";
		parent.frames[1].document.forms[0].ds_to_date2.disabled=true;
		parent.frames[1].document.forms[0].ds_to_date2.value="";
		parent.frames[1].document.forms[0].ds_to_date2_img.style.visibility="hidden";
		parent.frames[1].document.forms[0].ds_from_date3.disabled=false;
		parent.frames[1].document.forms[0].ds_from_date3_img.style.visibility="visible";
		parent.frames[1].document.forms[0].ds_to_date3.disabled=false;
		parent.frames[1].document.forms[0].ds_to_date3_img.style.visibility="visible";
		/* added as per the requirement of of ICN 1003*/
		parent.frames[1].document.forms[0].from_date_cal.disabled=true;
		parent.frames[1].document.forms[0].to_date_cal.disabled=true;
		parent.frames[1].document.forms[0].from_month_cal.disabled=true;
		parent.frames[1].document.forms[0].to_month_cal.disabled=true;
	
	}
	else if (fieldval=='D')
	{
		parent.frames[1].document.forms[0].ds_from_date1.disabled=false;
		parent.frames[1].document.forms[0].ds_from_date1_img.style.visibility="visible";
		parent.frames[1].document.forms[0].ds_to_date1.disabled=false;
		parent.frames[1].document.forms[0].ds_to_date1_img.style.visibility="visible";
		parent.frames[1].document.forms[0].ds_from_date3.disabled=true;
		parent.frames[1].document.forms[0].ds_from_date3.value="";
		parent.frames[1].document.forms[0].ds_from_date2_img.style.visibility="hidden";
		parent.frames[1].document.forms[0].ds_to_date3.disabled=true;
		parent.frames[1].document.forms[0].ds_to_date3.value="";
		parent.frames[1].document.forms[0].ds_to_date2_img.style.visibility="hidden";
		parent.frames[1].document.forms[0].ds_from_date2.disabled=true;
		parent.frames[1].document.forms[0].ds_from_date2.value="";
		parent.frames[1].document.forms[0].ds_from_date3_img.style.visibility="hidden";
		parent.frames[1].document.forms[0].ds_to_date2.disabled=true;
		parent.frames[1].document.forms[0].ds_to_date2.value="";
		parent.frames[1].document.forms[0].ds_to_date3_img.style.visibility="hidden";
		/* added as per the requirement of of ICN 1003*/
		parent.frames[1].document.forms[0].from_month_cal.disabled=true;
		parent.frames[1].document.forms[0].to_month_cal.disabled=true;
		/* added as per the requirement of of ICN 1003*/
		parent.frames[1].document.forms[0].from_date_cal.disabled=false;
		parent.frames[1].document.forms[0].to_date_cal.disabled=false;
	
	}

}


// chkOverLap
function ChkOverLap()
	{
	


	var n=parent.parent.frames[1].frames[1].document.repBirthStat.weight_range.value

	var fldvals=new Array(20);
	if(n>=1)
	{

		fldvals[0]= f_query_add_mod.document.repBirthStat.from1.value;
		fldvals[1]= f_query_add_mod.document.repBirthStat.to1.value;
		

		if(n>=2)
		{
			fldvals[2]= f_query_add_mod.document.repBirthStat.from2.value;
			
			fldvals[3]= f_query_add_mod.document.repBirthStat.to2.value;
			

		if(n>=3)
			{
				fldvals[4]= f_query_add_mod.document.repBirthStat.from3.value;
				
				fldvals[5]= f_query_add_mod.document.repBirthStat.to3.value;
				

			if(n>=4)
				{
					fldvals[6]= f_query_add_mod.document.repBirthStat.from4.value;
					
					fldvals[7]= f_query_add_mod.document.repBirthStat.to4.value;
					


				if(n>=5)
					{
						fldvals[8]= f_query_add_mod.document.repBirthStat.from5.value;
					
						fldvals[9]= f_query_add_mod.document.repBirthStat.to5.value;
										

					}

				}

			}

		}

	}




	var i=0;
	var count=0;
	var glb=0;
	var w=0; var y=2;

	var k=0;
	if(n==1)
	 {
	    k=1;
	}
	else if(n==2)
	  k=3;
	else if(n==3)
	  k=5;
	else if(n==4)
	  k=7;
	else if(n==5)
	  k=9;
	



	for(i=0;i<k;i++)
	{


		if(ComRowChk(fldvals[w],fldvals[y]))
		{
			
			w=w+1;
		
			y=y+1;
			
		}
		else
		{
			if(w==1||w==4||w==6||w==8||w==10)
				glb++;
			else
				glb=0;

			return false;

		}



	}

	return true;

	//return false;

}

function ComRowChk(FrValue,ToValue)
{
	var FrVal=FrValue;
	var ToVal=ToValue;
	var nam=parseInt(FrVal);
	var nam1=parseInt(ToVal);

			if(nam >= nam1 )
				{
				alert(getMessage("OVERLAP_NOT_ALLOWED","MP"));
				return false;
				}
			else
				return true;
}


function enableFields(Obj)
{
	if(Obj.value=="L")
	{
		 if (document.forms[0].p_indicator_mark.options.length < 3)
		 {
			while (document.forms[0].p_indicator_mark.options.length >0)
				document.forms[0].p_indicator_mark.remove(document.forms[0].p_indicator_mark.options[0]);	
			var opt = "";
			opt = document.createElement("OPTION");
			opt.text = '--- '+getLabel("Common.defaultSelect.label","Common")+' ---';
			opt.value= '';
			document.forms[0].p_indicator_mark.add(opt)
			opt = document.createElement("OPTION");
			opt.text = getLabel('eMP.Fresh.label','MP');
			opt.value= 'F';
			document.forms[0].p_indicator_mark.add(opt)
			opt = document.createElement("OPTION");
			opt.text = getLabel('eMP.Macerated.label','MP');
			opt.value= 'M';
			document.forms[0].p_indicator_mark.add(opt);

		 }
		 document.forms[0].p_indicator_mark.value="";
		 document.forms[0].p_indicator_mark.disabled=true;	
	}
	if(Obj.value=="S")
	{
		document.forms[0].p_indicator_mark.disabled=false;
		while (document.forms[0].p_indicator_mark.options.length >0)
			document.forms[0].p_indicator_mark.remove(document.forms[0].p_indicator_mark.options[0]);	
		var opt = ""
		opt = document.createElement("OPTION");
		opt.text = getLabel('eMP.Fresh.label','MP');
		opt.value= 'F';
		document.forms[0].p_indicator_mark.add(opt)
		opt = document.createElement("OPTION");
		opt.text = getLabel('eMP.Macerated.label','MP');
		opt.value= 'M';
		document.forms[0].p_indicator_mark.add(opt);
		
		document.forms[0].p_indicator_mark.value="F";
	}
}

async function searchCode(obj,target)
{
	var retVal = 	new String();
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var tit="";
	

	if(obj.name=="fm_attend" || obj.name=="to_attend")
	{
		tit=getLabel('eMP.AttendingNurse.label','MP');
		sql="select practitioner_id, practitioner_name from am_practitioner_lang_vw where language_id=`"+localeName+"`";
		search_code="practitioner_id";
		search_desc= "practitioner_name";
	}
	else if(obj.name=="fm_pract" || obj.name=="to_pract")
	{
		tit=getLabel('Common.AttendingPractitioner.label','common');
		sql="select practitioner_id, practitioner_name from am_practitioner_lang_vw where language_id=`"+localeName+"`";
		search_code="practitioner_id";
		search_desc= "practitioner_name";
	}
	else if(obj.name=="fm_nod" || obj.name=="to_nod")
	{
		tit=getLabel('eMP.DeliveryType.label','MP');
		sql="select nod_type, short_desc from mp_nod_type_lang_vw  where language_id=`"+localeName+"`";
		search_code="nod_type";
		search_desc= "short_desc";
	}
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

	if (!(retVal == null))
	{
		target.value=retVal;
	}
	else
		target.focus();
}

function onChangeFacilityId()
		{
			var facltyid = document.repBirthStat.p_facility_id.value;
			var optlength = document.repBirthStat.p_age_range_code.options.length;
			if(facltyid=='All')
			{
				document.repBirthStat.p_age_range_code.disabled=true;
			}
			else
			{
						document.repBirthStat.p_age_range_code.disabled=false;
			for (var i=0; i<optlength; i++)
			{
				document.repBirthStat.p_age_range_code.options.remove("p_age_range_code");
			}
				var HTMLVal="<html><body onKeyDown='lockKey()'><form name='GetAgeRangeForm' id='GetAgeRangeForm' method='get' action='../../eMP/jsp/GetAgeRange.jsp'>"+
						"<input type='hidden' name='facility' id='facility' value='"+facltyid+"'>"+
				"</form></body></html>";
				parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
				parent.messageFrame.document.GetAgeRangeForm.submit();
			}
		}

function validateDate(obj){
	
	if (obj.value>6)
	{
		alert(getMessage("GESTATION_DAYS_EXCEED","MP"));
		obj.value = "";
		if(obj.name=="p_fm_gest_period ")
		   document.repBirthStat.p_fm_gestation.focus();	
		else
           document.repBirthStat.p_to_gestation.focus();	
	}
}


function enableGestDays(Obj) {
	
		var unit_of_gest_nb=document.repBirthStat.unit_of_gest_nb.value;
		if(Obj.name=="p_fm_gestation")
	    {
		   if(Obj.value != "") 
		   {
		      if(document.repBirthStat.p_fm_gest_period)
               {
			      document.repBirthStat.p_fm_gest_period.disabled = false;
				  if(unit_of_gest_nb=="W")
              	       document.repBirthStat.p_fm_gest_period.focus();				
	            } 
           }
		   else 
		  {
		    if(document.repBirthStat.p_fm_gest_period)
			{
			   document.repBirthStat.p_fm_gest_period.value = "";
			   document.repBirthStat.p_fm_gest_period.disabled = true;
		    }
		  }
       }

       if(Obj.name=="p_to_gestation")
	    {
		   if(Obj.value != "") 
		   {
		      if(document.repBirthStat.p_to_gest_period)
               {
			      document.repBirthStat.p_to_gest_period.disabled = false;
				  if(unit_of_gest_nb=="W")
	                    document.repBirthStat.p_to_gest_period.focus();				
	            } 
           }
		   else 
		  {
		    if(document.repBirthStat.p_to_gest_period)
			{
			   document.repBirthStat.p_to_gest_period.value = "";
			    document.repBirthStat.p_to_gest_period.disabled = true;
		    }
		  }
       }


}//end

function doDateChkWithLabel(from,to,messageFrame,format,stringLabel) 
{
	if (from.value != undefined)
	{
		from = from.value;
	}
	else
	{
		from=from;
	}

	if (to.value != undefined)
	{
		to = to.value;
	}
	else
	{
		to=to;
	}

	if ( to=='' || from=='' )
	{
		return true;
	}
	 if(!f_query_add_mod.isBefore(from,to,format,f_query_add_mod.document.forms[0].locale.value)){
		var error=getMessage("REMARKS_MUST_GR_EQUAL","common") ;		
		error=error.replace("$",getLabel('Common.to.label','common_labels')+ ' ' +stringLabel);
		error=error.replace("#",stringLabel);
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
			return false;
		}
		else  
			return true;
}


