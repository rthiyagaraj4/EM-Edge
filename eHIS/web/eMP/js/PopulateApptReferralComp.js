function popLocValues(obj)
{
	if(obj.value != '')
	{
		var sStyle = document.forms[0].sStyle.value;

		var HTMLVal = new String();
				
		HTMLVal = "<HTML><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY class='message' onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/PatRegExpChk.jsp'><input name='funcId' id='funcId' type='hidden' value='registerPatient'><input name='calledFor' id='calledFor' type='hidden' value='popLocation'><input name='location' id='location' type='hidden' value='"+obj.value+"'></form></BODY></HTML>";
		
		parent.frames[2].document.open() ;
		parent.frames[2].document.write(HTMLVal);
		parent.frames[2].document.form1.submit();
		
	}
	else
	{
		var obj = document.forms[0].locationValue;
		var len = Math.abs(obj.length);
		for(i=0;i<len;i++) obj.remove(0);
		var opt = document.createElement("OPTION");
		opt.text = '---'+getLabel("Common.defaultSelect.label","Common")+'---';
		opt.value = '';
		document.forms[0].locationValue.add(opt);
	}
}
function callResultPage()
{ 
	var refrlAappt = '';
	if ( document.forms[0].refrlAappt )
	 refrlAappt = document.forms[0].refrlAappt.value;

	var selectedLocation = '';
	if ( document.forms[0].selectedLocation )
	 selectedLocation = document.forms[0].location.value;
	
	var patName = '';
	if ( document.forms[0].patName )
	 patName = document.forms[0].patName.value;
	
	var genderValue = '';
	if ( document.forms[0].genderValue )
	 genderValue = document.forms[0].genderValue.value;
	
	var refNo = '';
	if ( document.forms[0].refNo )
	 refNo = document.forms[0].refNo.value;
	
	var periodFrom = '';
	if ( document.forms[0].periodFrom )
	 periodFrom = document.forms[0].periodFrom.value;
	if (periodFrom != "")
	{
		periodFrom=convertDate(periodFrom,"DMY",localeName,"en");
	}


	var periodTo = '';
	if ( document.forms[0].periodTo )
	 periodTo = document.forms[0].periodTo.value;
	if (periodTo != "")
	{
		periodTo=convertDate(periodTo,"DMY",localeName,"en");
	}


	var locationValue = '';
	if ( document.forms[0].locationValue )
	 locationValue = document.forms[0].locationValue.value;
	
	var national_id_no = '';
	if ( document.forms[0].national_id_no )
	 national_id_no = document.forms[0].national_id_no.value;
	
	var alt_id1_no="";
	var alt_id2_no="";
	var alt_id3_no="";
	var alt_id4_no="";
	if(document.forms[0].alt_id1_no)
	alt_id1_no = document.forms[0].alt_id1_no.value;
	if(document.forms[0].alt_id2_no)
	alt_id2_no = document.forms[0].alt_id2_no.value;
	if(document.forms[0].alt_id3_no)
	alt_id3_no = document.forms[0].alt_id3_no.value;
	if(document.forms[0].alt_id4_no)
	alt_id4_no = document.forms[0].alt_id4_no.value;
	
	var other_alt_type = '';
	if ( document.forms[0].other_alt_type )
	 other_alt_type = document.forms[0].other_alt_type.value;
	
	var other_alt_Id = '';
	if ( document.forms[0].other_alt_Id )
	 other_alt_Id = document.forms[0].other_alt_Id.value;


	
	parent.frames[1].location.href="../../eMP/jsp/PopulateApptReferralCompResult.jsp?refrlAappt="+refrlAappt+"&patName="+patName+"&genderValue="+genderValue+"&refNo="+refNo+"&periodFrom="+periodFrom+"&periodTo="+periodTo+"&locationValue="+locationValue+"&national_id_no="+national_id_no+"&alt_id1_no="+alt_id1_no+"&other_alt_type="+other_alt_type+"&other_alt_Id="+other_alt_Id+"&selectedLocation="+selectedLocation+"&alt_id2_no="+alt_id2_no+"&alt_id3_no="+alt_id3_no+"&alt_id4_no="+alt_id4_no;
}

function submitPrevNext(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value	 = to; 
	document.forms[0].submit();
}
/*
function enbToPeriod(obj)
{
	if(obj.value == '')
	{
		document.forms[0].periodTo.value	= '';
		document.forms[0].periodTo.disabled	= true;
		document.forms[0].all.to.disabled	= true;
	}
	else
	{
		document.forms[0].periodTo.disabled	= false;
		document.forms[0].all.to.disabled	= false;
	}
}
*/
function dispRefNum(referenceNo)
{
	top.window.returnValue = referenceNo;
	top.window.close();
}
function chkForFromDate(from,to_date,format) 
{ 
	//args objects 1st is this object & second is the date in dd/mm/yyyy
	if(from.value !="" )
	{
		//if (validDateObj(from))
		if(validDateObj(from,format,localeName))
		{
			var fromdate =from.value ;
			if (! isAfterNow(fromdate,format,localeName))
			{
					var msg= getMessage("CANNOT_LESSER","MP");
					msg = msg.replace("#",getLabel('Common.fromdate.label','common'));
					msg = msg.replace("$",getLabel('Common.SystemDate.label','common'));
					alert(msg);
					from.focus();
					from.select();
					return false;
			}
		}
	}
	if(to_date.value !="" )
	{
		//if (validDateObj(to_date))
		if(validDateObj(to_date,format,localeName))

		{
			var todate =to_date.value ;
			if (!isBefore(from.value,todate,localeName))
			{
					var msg= getMessage("CANNOT_GREATER","MP");
					msg = msg.replace("#",getLabel('Common.fromdate.label','common'));
					msg = msg.replace("$",getLabel('Common.todate.label','common'));
					alert(msg);
					from.value = '';
					from.select();
					return false;
			}
		}
	}
	return true;
}
/*	if(today != "" && from.value !="" )
	 {
		if(CheckDate(from) == true)
		{
			var fromarray;
			var toarray;
			var periodTOarray;
			var fromdate =from.value ;
			var todate =today ;
			var periodTO = to_date.value	

			if (periodTO != "")
			{
				periodTO=convertDate(periodTO,"DMY",localeName,"en");
			}
			if (fromdate != "")
			{
				fromdate=convertDate(fromdate,"DMY",localeName,"en");
			}
			
			if(fromdate.length > 0 && todate.length > 0 ) 
			{
				fromarray = fromdate.split("/");
				toarray = todate.split("/");
				var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
				var todt = new Date(toarray[2],toarray[1],toarray[0]);
				if(Date.parse(todt) > Date.parse(fromdt))
				{


					var msg= getMessage("CANNOT_LESSER","MP");
					//msg = msg.replace("#",todt);
					//msg = msg.replace("$",fromdt);
					msg = msg.replace("#",getLabel('Common.fromdate.label','common'));
					msg = msg.replace("$",getLabel('Common.SystemDate.label','common'));
					alert(msg);
					from.focus();
					from.select();
					return false;
				}
				
				if(periodTO.length > 0) 
				{
					
					periodTOarray = periodTO.split("/");
					var to_datedt = new Date(periodTOarray[2],periodTOarray[1],periodTOarray[0]);
					if(Date.parse(fromdt) > Date.parse(to_datedt))
					{
						


						var msg= getMessage("CANNOT_GREATER","MP");
						msg = msg.replace("#",getLabel('Common.fromdate.label','common'));
						msg = msg.replace("$",getLabel('Common.todate.label','common'));
						//msg = msg.replace("#",fromdt);
						//msg = msg.replace("$",to_datedt);
						alert(msg);
						from.value = '';

						from.select();
						return false;
					}
				}
			}
		}
		return true;
	}
	return true;
}*/
function chkForToDate(to_date,from,today) 
{ 
	//args objects 1st is this object & second is the date in dd/mm/yyyy
	if(to_date.value !="" )
	{
		//if (validDateObj(to_date))
		if(validDateObj(to_date,today,localeName))

		{
			var todate =to_date.value ;
			if (! isAfterNow(todate,format,localeName))
			{
					var msg= getMessage("CANNOT_LESSER","MP");
					msg = msg.replace("#",getLabel('Common.todate.label','common'));
					msg = msg.replace("$",getLabel('Common.SystemDate.label','common'));
					alert(msg);
					from.focus();
					from.select();
					return false;
			}
		
		}
	}
	if(from.value !="" )
	{
	//if (validDateObj(from))
		if(validDateObj(from,today,localeName))
		{
			var fromdate =from.value ;
			if (!isBefore(from.value,to_date.value,localeName))
			{
					var msg= getMessage("CANNOT_GREATER","MP");
					msg = msg.replace("#",getLabel('Common.fromdate.label','common'));
					msg = msg.replace("$",getLabel('Common.todate.label','common'));
					alert(msg);
					from.value = '';
					from.select();
					return false;
			}
		}
	}
	return true;
}
/*
	if(today != "" && to_date.value !="" )
	{
		if(CheckDate(to_date) == true)
		{
			var to_datearray;
			var toarray;
			var periodFromarray;
			var to_datedate =to_date.value ;
			var todate =today ;
			var fromdate =from.value ;
			if (to_datedate != "")
			{
				to_datedate=convertDate(to_datedate,"DMY",localeName,"en");
			}
			if (fromdate != "")
			{
				fromdate=convertDate(fromdate,"DMY",localeName,"en");
			}


			if(to_datedate.length > 0 && todate.length > 0 ) 
			{
				to_datearray = to_datedate.split("/");
				toarray = todate.split("/");
				var to_datedt = new Date(to_datearray[2],to_datearray[1],to_datearray[0]);
				var todt = new Date(toarray[2],toarray[1],toarray[0]);
				if(Date.parse(todt) > Date.parse(to_datedt))
				{
					
					var msg= getMessage("CANNOT_LESSER","MP");
					msg = msg.replace("#",getLabel('Common.todate.label','common'));
					msg = msg.replace("$",getLabel('Common.SystemDate.label','common'));
					alert(msg);
					to_date.focus();
					to_date.select();
					return false;
				}
				
				if(fromdate.length > 0 ) 
				{
					periodFromarray = fromdate.split("/");
					var fromdt = new Date(periodFromarray[2],periodFromarray[1],periodFromarray[0]);
					
					if(Date.parse(fromdt) > Date.parse(to_datedt))
					{
						

						var msg= getMessage("CANNOT_GREATER","MP");
						msg = msg.replace("#",getLabel('Common.fromdate.label','common'));
						msg = msg.replace("$",getLabel('Common.todate.label','common'));
						alert(msg);
						to_date.value = '';
						to_date.select();
						return false;
					}
				}
			}
			
		}
		return true;
	}
	return true;
}
*/
function closeModWindow()
{
	top.window.returnValue = '';
	top.window.close();
}
function clearResPage()
{ 
	parent.frames[1].location.href="../../eCommon/html/blank.html";
}

//newly added

function DateCompare_from(obj2,obj)
{

var Sys_date =document.forms[0].sysdate;

if(obj.value!="")
		{
		if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
		else{
		var obj1=convertDate(obj.value,"DMY",localeName,"en");

		
if(obj2 =="from")
			{
			if(isBefore(Sys_date.value,obj1,'DMY',localeName)==false)
				{
					var msg= getMessage("CANNOT_LESSER","MP");
					msg = msg.replace("#",getLabel('Common.fromdate.label','common'));
					msg = msg.replace("$",getLabel('Common.SystemDate.label','common'));
					alert(msg);
					obj.value="";
					obj.select();	
					return false;
			}
			else
				return true;

			}else
			{
					if(isBefore(Sys_date.value,obj1,'DMY',localeName)==false)
				{
					var msg= getMessage("CANNOT_LESSER","MP");
					msg = msg.replace("#",getLabel('Common.todate.label','common'));
					msg = msg.replace("$",getLabel('Common.SystemDate.label','common'));
					alert(msg);
					obj.value="";
				obj.select();	
				return false;
			}
			else
				return true;
			}
		}
}

}

function validate_date_to(to,from)
{
	if(to.value!="")
		{
		if(!validDateObj(to,"DMY",localeName))
		{
			to.value="";
			return ;
		}

		if(from.value!="" && to.value!="" )
		{
			if(isBefore(from.value,to.value,'DMY',localeName)==false)
				{
				var msg= getMessage("CANNOT_GREATER","MP");
				msg = msg.replace("#",getLabel('Common.fromdate.label','common'));
				msg = msg.replace("$",getLabel('Common.todate.label','common'));
				alert(msg);
				to.value="";
				to.select();	
				return false;
			}
			else
				return true;
		}
}
}

function validate_date_from(from,to)
{
	if(from.value!="")
		{
		if(!validDateObj(from,"DMY",localeName))
		{
			from.value="";
			return ;
		}

		if(from.value!="" && to.value!="" )
		{
			if(isBefore(from.value,to.value,'DMY',localeName)==false)
				{
				var msg= getMessage("CANNOT_GREATER","MP");
				msg = msg.replace("#",getLabel('Common.fromdate.label','common'));
				msg = msg.replace("$",getLabel('Common.todate.label','common'));
				alert(msg);
				to.value="";
				to.select();	
				return false;
			}
			else
				return true;
		}
}
}

