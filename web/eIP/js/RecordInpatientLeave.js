
function Record()
{ 
	var fields = new Array();
	var names	 = new Array();
	if((parent.frames[1].document.recordinpatientleave_form.record_status.value == "01") && (validateDate('T',parent.frames[1].document.recordinpatientleave_form.todate)))
	{
		if(validateDate('F',parent.frames[1].document.recordinpatientleave_form.fromdate))
		{
			if(parent.frames[1].document.recordinpatientleave_form.record_status.value == "01")
			{
				fields[0]	= parent.frames[1].document.recordinpatientleave_form.practid;
				names[0]	= getLabel("Common.practitioner.label","Common"); 

				if (parent.frames[1].document.recordinpatientleave_form.release_bed != null)
				if (parent.frames[1].document.recordinpatientleave_form.release_bed.checked)
				{
					fields[fields.length] = 	parent.frames[1].document.recordinpatientleave_form.pseudo_bed;
					names[names.length]	  = getLabel("eIP.PseudoBed.label","IP");
				}

				fields[fields.length]	= parent.frames[1].document.recordinpatientleave_form.fromdate;
				names[names.length]		=	getLabel("Common.fromdatetime.label","Common");

				fields[fields.length]	= parent.frames[1].document.recordinpatientleave_form.todate;
				names[names.length]  	=	getLabel("eIP.ToDateTime.label","IP");

				fields[fields.length]	= parent.frames[1].document.recordinpatientleave_form.Remarks;
				names[names.length]		=	getLabel("Common.remarks.label","Common");

				if(parent.frames[1].document.recordinpatientleave_form.inform_to.value!="")
				{
					fields[fields.length]	= parent.frames[1].document.recordinpatientleave_form.informed_date;
					names[names.length]	=	getLabel("Common.InformedDate/Time.label","Common");
				}
			}

			if(checkFields1( fields, names))
			{  
				var no_of_record = parseInt(parent.frames[1].document.recordinpatientleave_form.no_of_record.value);
				
				if(parent.frames[1].document.recordinpatientleave_form.release_bed!=null && parent.frames[1].document.recordinpatientleave_form.release_bed.value=='Y' &&  no_of_record >0 )
				{
					var is_release_reserve_bed = confirm(getMessage("RELEASE_RESRV_BED","IP"));
					if(is_release_reserve_bed)
						parent.frames[1].document.recordinpatientleave_form.release_reserve_bed_yn.value = "Y"; 
					else
						parent.frames[1].document.recordinpatientleave_form.release_reserve_bed_yn.value = "N"; 
				}
				
				parent.frames[1].document.recordinpatientleave_form.confirm.disabled = true;
				var submitVal = "<html><body onKeyDown='lockKey()'><form name='recordinpatientleave_form' id='recordinpatientleave_form' method='post' action='../../servlet/eIP.RecordInpatientLeaveServlet'>"
				for(var i=0; i<document.forms[0].elements.length;i++)
				{
					if(document.forms[0].elements[i].type == "checkbox")
					{
						if( document.forms[0].elements[i].checked )
						submitVal += "<input type='hidden' name=\""+document.forms[0].elements[i].name+"\" id=\""+document.forms[0].elements[i].name+"\" value=\""+document.forms[0].elements[i].value+"\">"
					}
					else
						submitVal += "<input type='hidden' name=\""+document.forms[0].elements[i].name+"\" id=\""+document.forms[0].elements[i].name+"\" value=\""+document.forms[0].elements[i].value+"\">"
				}
				submitVal+="</form></body></html>"
				parent.frames[2].document.write(submitVal);
				parent.frames[2].document.forms[0].submit();
			}

			function checkFields1( fields, names)
			{
				var errors = "" ;
				for( var i=0; i<fields.length; i++ ) 
				{
					if(trimCheck1(fields[i].value)) 
					{
						fields[i].value = trimString1(fields[i].value);
					}
					else
					{
						errors = errors + getMessage("CAN_NOT_BE_BLANK","Common");
						errors = errors.replace('$',names[i]);
						errors = errors + "\n" ;
					}	
				}
				if ( errors.length != 0 ) 
				{
					alert(errors) ; 
					return false ;
				}
				return true ;
			}

			function trimCheck1(inString) 
			{
				var startPos;
				var ch;
				startPos = 0;
				strlength = inString.length;

				for(var i=0;i<=strlength;i++) 
				{
					ch = inString.charAt(startPos);
					if((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) 
					{
						startPos++;
					}
				}
				if(startPos == inString.length) return false;
				else return true;
			}

			function trimString1(inString) 
			{
				var outString;
				var startPos;
				var endPos;
				var ch;  

				startPos = 0;
				ch = inString.charAt(startPos);
				while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
				startPos++;
				ch = inString.charAt(startPos);
				}

				endPos = inString.length - 1;
				ch = inString.charAt(endPos);
				while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
				endPos--;
				ch = inString.charAt(endPos);
				}

				outString = inString.substring(startPos, endPos + 1);

				return outString;
			}
		}  
	}
	else if (parent.frames[1].document.recordinpatientleave_form.record_status.value == "02")
	{
		var fields = new Array( parent.frames[1].document.recordinpatientleave_form.fromdate, parent.frames[1].document.recordinpatientleave_form.Remarks);

		var names = new Array (getLabel("Common.fromdatetime.label","Common"), getLabel("Common.remarks.label","Common")); 

		if(parent.frames[1].document.recordinpatientleave_form.inform_to.value!="")
		{
			fields[fields.length]	= parent.frames[1].document.recordinpatientleave_form.informed_date;
			names[names.length]	=	getLabel("Common.InformedDate/Time.label","Common")
		}

		parent.frames[1].document.recordinpatientleave_form.todate.value = "";
		if(checkFields1( fields, names))
		{ 
			var no_of_record = parseInt(parent.frames[1].document.recordinpatientleave_form.no_of_record.value);
			
			if(parent.frames[1].document.recordinpatientleave_form.release_bed!=null && parent.frames[1].document.recordinpatientleave_form.release_bed.value=='Y' &&  no_of_record >0 )
				{
				// Below code added for proper message dispaly date:Wednesday, February 10, 2010 19254

					var msg=getMessage("RELEASE_RESRV_BED","IP")
					var is_release_reserve_bed = confirm(msg);
					if(is_release_reserve_bed)
						parent.frames[1].document.recordinpatientleave_form.release_reserve_bed_yn.value = "Y"; 
					else
						parent.frames[1].document.recordinpatientleave_form.release_reserve_bed_yn.value = "N"; 
				}				
			parent.frames[1].document.recordinpatientleave_form.confirm.disabled = true;
			var submitVal = "<html><body onKeyDown='lockKey()'><form name='recordinpatientleave_form' id='recordinpatientleave_form' method='post' action='../../servlet/eIP.RecordInpatientLeaveServlet'>";
			for(var i=0; i<document.forms[0].elements.length;i++)
			{
				if(document.forms[0].elements(i).type == "checkbox")
				{
					if( document.forms[0].elements(i).checked )
						submitVal += "<input type='hidden' name=\""+document.forms[0].elements(i).name+"\" id=\""+document.forms[0].elements(i).name+"\" value=\""+document.forms[0].elements(i).value+"\">"
				}
				else
				{
					submitVal += "<input type='hidden' name=\""+document.forms[0].elements(i).name+"\" id=\""+document.forms[0].elements(i).name+"\" value=\""+document.forms[0].elements(i).value+"\">"
				}
			}
			submitVal+="</form></body></html>"
			parent.frames[2].document.write(submitVal);
			parent.frames[2].document.forms[0].submit();
		}
	}
}
  
function validateToTimeDate(obj,val)
{ 
	var len = obj.value;
	if(len.length > 0)
	{
		var admdate 	  = self.document.recordinpatientleave_form.admissiondatetime.value;
		var dischgdate = self.document.recordinpatientleave_form.expected_discharge_date.value;   

		if(doDatetimeCheckAlert(admdate,dischgdate))
		{
			alert(self.getMessage("DIS_DATE_NOT_LESS_ADM_DATE","IP"));
			obj.focus();
			obj.select();	
		}
		else
		{
			if(obj.value != '')
			{
				if(!self.doDateTimeChk(obj))
				{ 
					var msg = self.getMessage("INVALID_DATE_TIME","SM");  	  
					alert(msg);
					obj.focus();
					obj.select();
				}
				else if(val == 'D')
				{
					self.document.dischargeadvice_form.block_until_date.value = '';
					fr = self.document.recordinpatientleave_form.currdate;
					to = self.document.recordinpatientleave_form.expecteddischargedate;
					if(ValidateDischargeDate(fr,to,'D'))
					{
						alert(self.getMessage("DIS_DATE_LT_EXCEEDED","IP"));
						obj.focus();
						obj.select();
					}
				}
			}
		} 
	}
}


function validateDateTime(obj,val)
{
	
	if(obj.value != '')
	{
		if(self.doDateTimeChk(obj))
		{
			var currdate = self.document.recordinpatientleave_form.currdate;
			if(!ValidateDateTime(currdate,obj))
			{	
				alert(self.getMessage("DATE_NOT_LESS_SYSDATE","IP"));
				obj.focus();
			}
		}
		else
		{
			alert(self.getMessage("INVALID_DATE_TIME","SM"));
			obj.focus();
		}
	}
}

function ValidateDischargeDate(from,to,val)
{
	from = from.value;
	to   = to.value;
	var  maxhrs = 0;
	var  maxdays	= 0;

	if(val == 'A')
	maxdays = self.document.recordinpatientleave_form.admndate.value;
	var a=  from.split(" ")
	splitdate=a[0];
	splittime=a[1]

	var splitdate1 =a[0].split("/")
	var splittime1= a[1].split(":")
	var hrs =eval(splittime1[0])+eval(maxhrs);
	var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), hrs,eval(splittime1[1]))
	a=  to.split(" ")
	splitdate=a[0];
	splittime=a[1]

	splitdate1 =a[0].split("/")
	splittime1= a[1].split(":")
	var days = eval(maxdays)+eval(splitdate1[0]);
	var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1,days, eval(splittime1[0]), eval(splittime1[1]))
	 if(Date.parse(to_date) >= Date.parse(from_date))
		return false;
	else
		return true;	
}


function doDateTimeChk(obj)
{
	var comp=obj
	obj=obj.value
	var dttime = obj.split(" ");
	var dt
	var time
	var retval=true
	if(dttime.length>1)
	{
		dt=dttime[0]
		time=dttime[1]
		if(!checkDt(dt) )
		{
			retval= false
			comp.focus()
		}
		else
		{
			if(time==null || time=="")
			{
				retval= false;
				comp.focus()
			}

			else
			{
				if(!chkTime(time))
				{
						retval= false
						comp.focus()
				}
			}
		}
	}
	else
	{
		retval= false
		comp.focus()
	}

return retval
}


function chkTime(time1)
{
	var retval=true;

	if( (time1.charAt(time1.length-1) )!=":")
	{
		var time1arr=new Array()
		time1arr=time1.split(":")

		if(time1arr.length==2)
		{
			var time1hr=time1arr[0]
			var time1min=time1arr[1]

			time1hr=parseInt(time1hr)
			time1min=parseInt(time1min)
			if(time1hr<=23)
			{
				if(time1min>60)
				{
						retval=false;
				}
			}
			else
					retval=false;
		}
		else
			retval=false;
	}
	else
			retval=false;
	return retval
}

function doDatetimeCheckAlert(from,to) 
 {
	var fromarray; 
	var toarray;
	var fromDt;
	var fromdate = from;
	var todate = to;
	
	if(fromdate.length > 0 && todate.length > 0 ) 
	 {	  	
	  	fromDt = fromdate.split(" ");
	  	fromarray = fromDt[0].split("/");
	  	
	  	toDt = todate.split(" ");
	  	toarray = toDt[0].split("/");		
		
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);				
		var todt = new Date(toarray[2],toarray[1],toarray[0]);				  	
		
		if(Date.parse(todt) == Date.parse(fromdt))
		{		
			fromTime = fromDt[1];
			toTime   = toDt[1];
			
			if(toTime < fromTime)
			{				
				return true;
			}
		}		
		
		if(Date.parse(todt) < Date.parse(fromdt)) 
		 {		     
			return true;
		 }
		else 
		{				
			if(Date.parse(todt) >= Date.parse(fromdt)) 
			return false;
		}		
	}	  
}

function reset()
{
	
parent.frames[2].frames[1].document.forms[0].reset();
if (parent.frames[2].frames[1].document.forms[0].searchby != null)
	    {
			parent.frames[2].frames[1].document.forms[0].searchby.value="";
			parent.frames[2].frames[1].document.forms[0].searchby.disabled=true;
	    }
parent.frames[2].frames[2].location.href='../../eCommon/html/blank.html'
}

async function callBedAvailChart()
{
	var nursingunit = parent.frames[1].document.recordinpatientleave_form.nursing_unit.value;
	var practitionerid = parent.frames[1].document.recordinpatientleave_form.practid.value;
	var specialitycode = parent.frames[1].document.recordinpatientleave_form.spl_code.value;
	var pract_desc = parent.frames[1].document.recordinpatientleave_form.pract_desc.value;
	var bedClass_dis_yn = "Y";

	var retVal = 	new String();
	var dialogHeight= "500px" ;
	var dialogWidth	= "1200px" ;
	var dialogTop	= "72" ;
	var status = "no";
	var arguments	= "" ;
	var wherecondn  = "EMERGENCY_TFR_YN"; 
	var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eIP/jsp/BedAvailabilityChart.jsp?disable_field=NursingUnit&nursing_unit_code="+escape(nursingunit)+"&speciality_code="+escape(specialitycode)+"&bed_type=pseudo"+"&practitioner_id="+escape(practitionerid)+"&practitioner_desc="+escape(pract_desc)+"&bedClass_dis_yn="+bedClass_dis_yn+"&wherecondn="+escape(wherecondn),arguments,features);

	if(retVal!=null)
	{
		var arr = retVal.split("^");
		if(arr.length > 2)
		{
			var arr1 = arr[1].split("/");
			parent.frames[1].document.recordinpatientleave_form.pseudo_bed.value =arr1[0];
			parent.frames[1].document.recordinpatientleave_form.nursing_unit.value=arr[0];
		parent.frames[1].document.recordinpatientleave_form.hdd_peudobed_val.value=arr[14];
			var arrsplty = arr[11].split("*All SPLTY*");
			if (arrsplty.length==1)
			{
				parent.frames[1].document.recordinpatientleave_form.spl_code.value=arr[10];
			}
		}
		else
		{
			parent.frames[1].document.recordinpatientleave_form.nursing_unit.value=arr[0];
			if (arr.length == 2)
			parent.frames[1].document.recordinpatientleave_form.nursing_unit_desc.value=arr[1];
		}
	}
}

function getPractitionerLocal(obj,target, aFacilityID)
{
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";
	
	practName_FName=target.name;
	practName_FValue=target.value;
	practId_FName=document.getElementById("practid").name;

	var nursing_unit_code	= document.getElementById("nursing_unit").value;
	var spl_code			= document.getElementById("spl_code").value;
	var facility_id = aFacilityID;
    locale=document.forms[0].locale1.value

	
	getPractitioner(obj, target, facility_id, spl_code,nursing_unit_code,"Q5");

	/*
		 
	var sql = "SELECT a.practitioner_id practitioner_id,am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)  practitioner_name, am_get_desc.am_pract_type(b.PRACT_TYPE,'"+locale+"',1) practitioner_type, am_get_desc.am_speciality(b.PRIMARY_SPECIALITY_CODE,'"+locale+"',2)   primary_specialty, DECODE (b.gender, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender, am_get_desc.am_position(b.position_code,'"+locale+"',1)  job_title FROM ip_nursing_unit_for_pract a, AM_PRACT_ALL_SPLTY_VW b WHERE A.facility_id = '"+facility_id+"' AND A.FACILITY_ID = B.FACILITY_ID and a.practitioner_id = b.practitioner_id AND A.nursing_unit_code = '"+nursing_unit_code+"' AND B.PRIMARY_SPECIALITY_CODE = '"+spl_code+"'  AND b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER (?) AND (UPPER (b.practitioner_id) LIKE UPPER (NVL (?, b.practitioner_id)) OR UPPER (am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER (NVL (?, b.practitioner_name))) AND b.gender LIKE (?) AND (b.position_code LIKE (?) OR b.position_code IS NULL) ";

	var sql2 = "SELECT a.practitioner_id practitioner_id,am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)  practitioner_name, am_get_desc.am_pract_type(b.PRACT_TYPE,'"+locale+"',1) practitioner_type, am_get_desc.am_speciality(b.PRIMARY_SPECIALITY_CODE,'"+locale+"',2)   primary_specialty, DECODE (b.gender, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender, am_get_desc.am_position(b.position_code,'"+locale+"',1) job_title FROM ip_nursing_unit_for_pract a, AM_PRACT_ALL_SPLTY_VW b WHERE A.facility_id = '"+facility_id+"' AND A.FACILITY_ID = B.FACILITY_ID and a.practitioner_id = b.practitioner_id AND A.nursing_unit_code = '"+nursing_unit_code+"' AND B.PRIMARY_SPECIALITY_CODE = '"+spl_code+"'  AND b.pract_type LIKE (?) AND b.primary_speciality_code LIKE UPPER (?) AND (UPPER (b.practitioner_id) LIKE UPPER (NVL (?, b.practitioner_id)) and UPPER (am_get_desc.am_practitioner(a.practitioner_id,'"+locale+"',1)) LIKE UPPER (NVL (?, b.practitioner_name))) AND b.gender LIKE (?) AND (b.position_code LIKE (?) OR b.position_code IS NULL)";

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	= "<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + encodeURIComponent(practName_FValue) + "\"";
	xmlStr += " practId_FName=\"" + practId_FName + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + spl_code+ "\"";
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

// To set the values to Attending Practitioner when using  
// GeneralPratitionerLookup. It's called by the GeneralPratitionerLookup.
function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		document.getElementById("practid").value=arr[0];
		document.getElementById("pract_desc").value=arr[1];			
	}
	else
	{
		document.getElementById("practid").value="";
		document.getElementById("pract_desc").value="";			
	}
} // End of PractLookupRetVal().

function ChkNumberInput1(fld, e, deci)
{
	if (parseInt(deci)>0)
		var strCheck = '0123456789 /:';
	else
	   var strCheck = '0123456789 /:';

	var whichCode = (window.Event) ? e.which : e.keyCode;
	if (whichCode == 13) return true;  // Enter
		key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

// Populate the To Leave Date 
function LoadToDate(obj)
{
	if(document.getElementById("leaveperiod").value != "" )
	{
	   var radVal = obj.value;   	   
	   if(document.getElementById("elements")[2].checked)	   
	   	var leaveind = 'H';	   	
	   else
	   	var leaveind = 'D'; 

	   var Sdate 	  = document.getElementById("currdate").value;
	   var sStyle 	  = document.getElementById("sStyle").value;
	   var leaveperiod   = document.getElementById("leaveperiod").value;	   
	   var max_leave_period    = document.getElementById("max_allowed_lv_period").value;	   
	   var HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head> <body class='message' onKeyDown='lockKey()'><form name='fetchtoleavedate' id='fetchtoleavedate' method='post' action='../jsp/FetchToLeaveDate.jsp'><input type='hidden' name='currdate' id='currdate' value='"+Sdate+"'><input type='hidden' name='leaveperiod' id='leaveperiod' value='"+leaveperiod+"'><input type='hidden' name='leaveind' id='leaveind' value='"+leaveind+"'><input type= 'hidden' name='maxleave' id='maxleave' value='"+max_leave_period+"'>";
	   HTMLVal = HTMLVal+"</form></body></html>";  		

   	   parent.frames[2].document.write(HTMLVal);
	   parent.frames[2].document.fetchtoleavedate.submit();	     
	}
	else
	{	  	
	 	parent.frames[1].document.getElementById('to_date1').innerText = '' ;
	}	   
}

//Chk the max Limit of the entered Value 
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


async function ButVal(obj)
{
	var butval = obj.value;         
	if (butval == getLabel("Common.record.label","Common"))	 
		await Record();
	else if(butval == getLabel("Common.clear.label","Common"))
	{
		

		   /*document.getElementById("Remarks").value="";
			document.getElementById("inform_to").value="";
			document.getElementById("informed_name").value="";
			document.getElementById("informed_date").value="";
			document.getElementById("informed_date").disabled = true;
			document.getElementById("informed_name").disabled = true;
			document.getElementById("infocalimg").disabled = true;
		    document.getElementById("im").style.visibility			=	"Hidden";
			*/


		if(document.forms[0].record_status.value=='01')
		{
			if(document.getElementById("release_bed")!=null)
			{
			if(document.getElementById("release_bed").checked==true)
			{
				document.getElementById("release_bed").checked=false;
				document.getElementById("pseudo_bed").value="";
				document.getElementById("button1").disabled = true;
				document.getElementById("img5").style.visibility			=	"Hidden";
				
			}
			
		}
		
		document.getElementById("fromdate").value=document.getElementById("Sdate_converted").value;
		document.getElementById("todate").value=document.getElementById("leave_to_date_converted").value;
		document.getElementById("Remarks").value="";
		document.getElementById("inform_to").value="";
		document.getElementById("informed_name").value="";
		document.getElementById("informed_date").value="";
		document.forms[0].reported_to.value=''; 
		document.getElementById("informed_date").disabled = true;
		document.getElementById("informed_name").disabled = true;
		document.getElementById("infocalimg").disabled = true;
		
		document.getElementById("im").style.visibility			=	"Hidden";
		}

		else if(document.forms[0].record_status.value=='02')
		{

			document.getElementById("fromdate").value=document.getElementById("Sdate_converted").value;
			document.getElementById("Remarks").value="";
			document.getElementById("inform_to").value="";
			document.getElementById("informed_name").value="";
			document.getElementById("informed_date").value="";
			document.getElementById("informed_date").disabled = true;
			document.getElementById("informed_name").disabled = true;
			document.getElementById("infocalimg").disabled = true;
		    document.getElementById("im").style.visibility			=	"Hidden";

			document.getElementById("pol_rep_no").value="";
			document.getElementById("pol_stn_id").value="";
			document.getElementById("pol_id").value="";
			document.getElementById("txtarea2").style.visibility      =   "Visible";
			document.getElementById("lbl2").innerHTML					=   getLabel("eIP.InformedOthers.label","IP");
			document.getElementById("txtarea2").value="";
			

			//document.getElementById("infmd_detl").innerText		=getLabel("Common.otherDetails.label","Common");



			

		}

	}
	else	
		top.window.document.getElementById('dialog_tag').close();	     
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

var chk_yn = "";

function chkFromToTime1(Obj)
{
	
	if(Obj.value != '')
    {
		
		if(!validDateObj(Obj,"DMYHM",localeName))
		{
			chk_yn = "N";
		}
		else
		{
			
			var greg_fromDateTime = convertDate(Obj.value,"DMYHM",localeName,"en");
			var greg_maxtfrDateTime = document.getElementById("ip_Trn_Date").value;
			if(isBefore(greg_fromDateTime,document.getElementById("admndate").value,"DMYHM","en"))
			{
				
				alert(getMessage("FRM_DT_GREATER_ADDMISSION_DT","IP"));
				Obj.value = "";
				Obj.focus();
				chk_yn = "N";
			}
			/* below code added for the from date shoud be grette the leave time 17633*/
			else if(!isBefore(greg_maxtfrDateTime,greg_fromDateTime,'DMYHM','en'))
			{
				var error = getMessage('DATE1_LT_DATE2','IP');
					//var last_encounter = getLabel("Common.Last.label","Common")+" "+getLabel("Common.encounterdate.label","Common");
					/*Monday, December 06, 2010 , SRR20056-SCF-6173 [IN:025371]*/
					var last_encounter = getLabel("eIP.LastTransactionDateTime.label","ip_labels");
					
						error = error.replace('$',getLabel("Common.fromdatetime.label",'common_labels'));
					error = error.replace('#',last_encounter);
					alert(error);
					Obj.value = "";
					return false;


			}
			/* below code added for the from date shoud be grette the leave time 17633*/
			else
			{
				

				if(!isBeforeNow(greg_fromDateTime,"DMYHM","en"))
				{
					alert(getMessage("FRM_DT_LESS_CURRENT_DT","IP"));
					Obj.value = "";
					Obj.focus();
					chk_yn = "N";
				}
				else          
				{
					
					
					if(document.getElementById("todate").value.length > 1)
					{
						var greg_toDateTime = convertDate(document.getElementById("todate").value,"DMYHM",localeName,"en");
						if(isBefore(greg_toDateTime,greg_fromDateTime,"DMYHM","en"))
						{
							alert(getMessage("TO_DT_TIME_GREATER_FROM","IP"));
							document.getElementById("todate").value = "";
							Obj.focus();
							//Obj.select();
							chk_yn = "N";							
						}
					}
					else
					{
								if(document.getElementById("informed_date").value.length > 0  )
								{
									var greg_informedDateTime = convertDate(document.getElementById("informed_date").value,"DMYHM",localeName,"en");
									
									if(isBefore(greg_informedDateTime,greg_fromDateTime,"DMYHM","en"))
									{
										var error = getMessage("DATE1_LT_DATE2","IP");
										error = error.replace("$",getLabel("Common.InformedDate/Time.label","Common"));
										error = error.replace("#",getLabel("eIP.AbscondingDateTime.label","IP"));
										alert(error);
										Obj.value = "";
										Obj.focus();
										chk_yn = "N";
										return false;
									}
									else
										chk_yn = "Y";
								}
					}
				}
			}
		}
    }
	else
	{
		chk_yn = "N";
	}
}

function local_CheckDate(Object3)
{
   var strDate;
    var strDay;
    var strMonth;
    var strYear;
    var datefield = Object3;
    var strDateArray = new Array();
	var strDateArray2;
	var strYear1;
	var strTime;
	
    strDate = datefield.value;
    if (strDate.length == 0) return true;

	if(Object3.value.indexOf('.') > 0) return false;

    strDateArray = strDate.split("/");
    if (strDateArray.length != 3) {
        return false;
    }
    else {
        strDay = strDateArray[0];
        strMonth = strDateArray[1];
        strYear = strDateArray[2];
    }

	if(strMonth == 0)
		return false;

	if(strDay == 0)
		return false;

    strDateArray2 = strYear.split(" ");
    if (strDateArray2.length != 2) {
        return false;
    }
    else {
        strYear1 = strDateArray2[0];
        strTime = strDateArray2[1];
    }
	if(strYear1 == 0)
	  return false;

    return true;
}

function chkFromToTime2(Obj)
{
	if(Obj.value != '')
	{
	

		if(!validDateObj(Obj,"DMYHM",localeName))
		{
			chk_yn = "N";
		}
		else
		{
			/* below code added for the from date shoud be grette the leave time and admission validation also 17633 */
			var greg_fromDateTime = convertDate(Obj.value,"DMYHM",localeName,"en");
			var greg_maxtfrDateTime = document.getElementById("ip_Trn_Date").value;
		
			if(isBefore(greg_fromDateTime,document.getElementById("admndate").value,"DMYHM","en"))
			{
				var msg = getMessage("DATE1_SHD_GT_DATE2","IP");
				msg  = msg.replace('$',getLabel("eIP.ToDateTime.label",'ip_labels'));
				msg  = msg.replace('#',getLabel("Common.AdmissionDateTime.label",'common_labels'));
				alert(msg);
				Obj.value = "";
				Obj.focus();
				chk_yn = "N";
			}
			
			else if(!isBefore(greg_maxtfrDateTime,greg_fromDateTime,'DMYHM','en'))
			{
				var error = getMessage('DATE1_LT_DATE2','IP');
					//var last_encounter = getLabel("Common.Last.label","Common")+" "+getLabel("Common.encounterdate.label","Common");
					/*Monday, December 06, 2010 , SRR20056-SCF-6173 [IN:025371]*/
					var last_encounter = getLabel("eIP.LastTransactionDateTime.label","ip_labels")
					
						error = error.replace('$',getLabel("eIP.ToDateTime.label",'ip_labels'));
					error = error.replace('#',last_encounter);
					alert(error);
					Obj.value = "";
					return false;


			}
			/* below code added for the from date shoud be grette the leave time*/
			
				else if(document.getElementById("fromdate").value.length>0)
				{
					var greg_FromDateTime = convertDate(document.getElementById("fromdate").value,"DMYHM",localeName,"en");
					var greg_ToDateTime = convertDate(Obj.value,"DMYHM",localeName,"en");
					
					if(isBefore(greg_ToDateTime,greg_FromDateTime,"DMYHM","en"))
					{
						alert(getMessage("TO_DT_TIME_GREATER_FROM","IP"));
						Obj.value = "";
						Obj.focus();
						
					}
				}
		}
			
	}

}

function validateDate(from,obj)
{
	var to_proceed = true;
	if(obj.value != '')
	{
		/*if(!doDateTimeChk(obj))
		{
			to_proceed = false;
			alert(getMessage("INVALID_DATE_TIME","SM"))
			obj.select();
		}*/

		if(!validDateObj(obj,"DMYHM",localeName))
		{
			to_proceed = false;
		}

		if (to_proceed == true)
		{
			var greg_toDateTime = convertDate(obj.value,"DMYHM",localeName,"en");		
			if(from == 'F')
			{
				
				var admdate = document.getElementById("admndate")
				//var sysdate = document.getElementById("currdate")
				
				if(document.getElementById("fromdate").value == '')
				{
					alert(getMessage("FRM_DT_TIME_NOT_NULL","IP"));
					to_proceed=false;
					document.getElementById("fromdate").focus();
				}
				
				/*else if(!ValidateDateTime(admdate,obj))
				{
					alert(getMessage("LT_ADMN_DATE","IP"));
					to_proceed=false;
					obj.value="";
					obj.focus();
				}*/
				else if(isBefore(greg_toDateTime,admdate,'DMYHM','en'))
				{
					alert(getMessage("LT_ADMN_DATE","IP"));
					to_proceed=false;
					obj.value="";
					obj.focus();
				}
				else
				{
					/*if(!ValidateDateTime(obj,sysdate))
					{
						alert(getMessage("FRM_DT_LESS_CURRENT_DT","IP"));
						to_proceed=false;
					}*/
					if(!isBeforeNow(greg_toDateTime,'DMYHM','en'))
					{
						alert(getMessage("FRM_DT_LESS_CURRENT_DT","IP"));
						to_proceed=false;
					}
				}
			}
			else if(from == 'T' )
			{
				var greg_fromDateTime = convertDate(document.getElementById("fromdate").value,"DMYHM",localeName,"en");		
				if(document.getElementById("fromdate").value == '')
				{
					//alert(getMessage("FRM_DT_TIME_NOT_NULL","IP"));
					//to_proceed=false;
					//document.getElementById("fromdate").value = "";
					//document.getElementById("fromdate").focus();
				}
				/*else if(!ValidateDateTime(document.getElementById("fromdate"),obj))
				{
					alert(getMessage("TO_DT_TIME_GREATER_FROM","IP"));
					
					to_proceed=false;
					obj.value = "";
					obj.focus();
				}*/
				else if(isAfter(greg_fromDateTime,greg_toDateTime,'DMYHM','en'))
				{
					alert(getMessage("TO_DT_TIME_GREATER_FROM","IP"));
					to_proceed=false;
					obj.value = "";
					obj.focus();
				}/*
					
				else
				{
					if(ValidateFromToDateTime(greg_fromDateTime,greg_toDateTime))
						to_proceed =true;
					else
					{		
						to_proceed=false;
						obj.focus();
					}	
				} */
			}
		}
	}
	if (to_proceed==true)
	{
		document.getElementById("fromdate").disabled=false;
		document.getElementById("todate").disabled=false;
	 }
	 return to_proceed;
}


function ValidateFromToDateTime(from,to)
 {	  	

	
	/*var a=  from.split(" ")
  	splitdate=a[0];
  	splittime=a[1]
  
  	var splitdate1 =a[0].split("/")
  	var splittime1= a[1].split(":")
  
  	var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
  	 
  	a	=  to.split(" ")
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

//		var minVal = minutesBetween(from,to,'DMYHM','en');
		var minVal = minutesBetween(convertDate(from.value,'DMYHM','en',localeName),convertDate(to.value,'DMYHM','en',localeName),'DMYHM','en');
		var hrVal = ((minVal/60));
  		var maxallowedlvperiod = document.getElementById("max_allowed_lv_period").value;
  		var warnorerrormaxleave= document.getElementById("warn_or_error_max_leave").value;
  		if(hrVal > maxallowedlvperiod)
  		{  			
  			if(warnorerrormaxleave == "W")
  			{
				alert(getMessage("XDS_MAX_LV_PERIOD","IP"));
  				return true;
  			}	
  			else	
  			{
  				alert(getMessage("XDS_MAX_LV_PERIOD","IP"));  				
				document.getElementById("todate").focus();
  				document.getElementById("todate").select(); 	
  				return false
  			}
  		}
  		else
  			return true;
    //} 		
}  
	  
function TestDateDiff(from,to)
{
	
	if(chk_yn == "Y")
	{
		if((from == "")||(from == null))
		{
			  
			  return false;
		}
		else
		if((to=="")||(to==null))
		{
			 
			  return false;
		}
		else
		{
			
			var a=  from.split(" ")
			splitdate=a[0];
			splittime=a[1]

			var splitdate1 =a[0].split("/")
			var splittime1= a[1].split(":")

			var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

			a=  to.split(" ")
			splitdate=a[0];
			splittime=a[1]  

			 splitdate1 =a[0].split("/")
				if(splittime!=null)
				{
				splittime1= a[1].split(":")
				}

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
				var maxallowedlvperiod = document.getElementById("max_allowed_lv_period").value;
				var warnorerrormaxleave= document.getElementById("warn_or_error_max_leave").value;
		
				if(hrVal > maxallowedlvperiod)
				{  			
					if(warnorerrormaxleave == "W")
					{
						alert(getMessage("XDS_MAX_LV_PERIOD","IP"));
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
			}
		}
	}
}

function setFocus()
{
	document.getElementById("fromdate").focus();
	document.getElementById("fromdate").select();
}

// By Annadurai. 23/4/2004  starts
// To disable All fields except Record Field 
function disableAllFields()     
	{
	if (document.getElementById("record_status").value == "02")
	{
		document.getElementById("pract_desc").disabled				=	true;
		document.getElementById("pract_id_search").disabled			=	true;
		document.getElementById("todate").value						=	'';
		document.getElementById("todate").disabled					=	true;
		document.getElementById("prefdt").disabled					=	true;
		document.forms[0].reported_to.value=''; 
		document.getElementById("reported_to").disabled		=		false;
		document.getElementById("amend_dtl").innerText		= getLabel("eIP.AbscondedDetails.label","IP");
		document.getElementById("infmd_detl").innerText		= getLabel("Common.otherDetails.label","Common");
		document.getElementById("lastrow").innerHTML			    ="<table border='0' cellpadding='2' cellspacing='0' width='100%'><tr> <td  class='label'  width='25%'>"+getLabel("Common.PoliceReportNo.label","Common")+"&nbsp;</td><td class='QUERYDATA' width='30%'><INPUT TYPE='text' name='pol_rep_no' id='pol_rep_no' size='25' maxlength='30'></td><td class='label' width='20%'>&nbsp;</td><td class='label' width='25%'>&nbsp;</td></tr><tr><td  class='label'>  "+getLabel("Common.station.label","Common")+"&nbsp;</td><td class='QUERYDATA' ><INPUT TYPE='text' name='pol_stn_id' id='pol_stn_id' size='25' maxlength='30'></td> <td class='label' >"+getLabel("Common.identification.label","Common")+"&nbsp;</td> <td class='QUERYDATA'><INPUT TYPE='text' name='pol_id' id='pol_id' size='25' maxlength='30'> </td> </tr><table>";

		if(document.getElementById("release_bed"))  
		{
		document.getElementById("release_bed").disabled			=	true;
		document.getElementById("release_bed").checked			=	false;
		document.getElementById("pseudo_button").disabled			=	true;
		document.getElementById("pseudo_bed").value				=	'';
		document.getElementById("img5").style.visibility			=	"Hidden";

		document.getElementById("loadChk1").innerText             =   '';
		document.getElementById("check1").style.visibility		=	"Hidden";
		document.getElementById("loadChk2").innerText             =	"";
		document.getElementById("txt1").style.visibility		    =	"Hidden";
		document.getElementById("button1").style.visibility		=	"Hidden";
		}
		
		document.getElementById("txtarea2").style.visibility      =   "Visible";
		document.getElementById("lbl2").innerHTML					=   getLabel("eIP.InformedOthers.label","IP");
		document.getElementById("lbl1").innerText					=   '';
		document.getElementById("img1").style.visibility			=	"Hidden";
		document.getElementById("imgr").style.visibility			=	"Hidden";
		document.getElementById("img3").style.visibility			=	"Hidden";
		document.getElementById("todate").style.visibility		=	"Hidden";

	}
	else     
	{
		document.getElementById("pract_desc").disabled			=	false;
		document.getElementById("pract_id_search").disabled		=	false;
		document.getElementById("todate").disabled				=	false;
		document.getElementById("todate").value					=   document.getElementById("hdnleave_to_date").value; 
		document.getElementById("prefdt").disabled				=	false;
		document.getElementById("amend_dtl").innerText			=   getLabel("eIP.LeaveDetails.label","IP");
		document.getElementById("reported_to").value				=   '';
		document.getElementById("reported_to").disabled			=   true;
		document.getElementById("infmd_detl").innerText           =   getLabel("eIP.InformedDetails.label","IP");
		document.getElementById("lastrow").innerHTML              =   '';

		if(document.getElementById("release_bed"))    
		{
			document.getElementById("release_bed").disabled				=	false;
			document.getElementById("pseudo_button").disabled				=	true;

		document.getElementById("loadChk1").innerText             =   getLabel("Common.ReleaseBed.label","common");
		document.getElementById("check1").style.visibility		=	"Visible";

		document.getElementById("loadChk2").innerText             =   getLabel("eIP.PseudoBed.label","IP");
		document.getElementById("txt1").style.visibility		    =	"Visible";
		document.getElementById("button1").style.visibility		=	"Visible";
		}

		document.getElementById("img1").style.visibility		    =	"Visible";
		document.getElementById("img3").style.visibility		    =	"Visible";
		document.getElementById("txtarea2").style.visibility      =   "Hidden";
		document.getElementById("imgr").style.visibility			=	"Visible";
		document.getElementById("lbl2").innerText                 =   "";
		document.getElementById("lbl1").innerText                 =   getLabel("Common.ToDateTime.label","Common")
		document.getElementById("todate").style.visibility		=	"Visible";

	}
}

function getPseudoBed(release)
{	
	if (release.checked)
	{
		document.getElementById("pseudo_button").disabled	= false;
		document.getElementById("img5").style.visibility			= "Visible";
	}
	else
	{
		document.getElementById("pseudo_button").disabled	= true;
		document.getElementById("img5").style.visibility			= "Hidden";
		document.getElementById("pseudo_bed").value				= "";
	}
}

function imageInvisible()
{	
	
	document.getElementById("amend_dtl").innerText                = getLabel("eIP.LeaveDetails.label","IP");
	document.getElementById("infmd_detl").innerText           =   getLabel("eIP.InformedDetails.label","IP");
	if (document.getElementById("img5") != null )
	document.getElementById("img5").style.visibility              = 'Hidden';
	document.getElementById("lbl2").innerText                     = "";
	document.getElementById("txtarea2").style.visibility          = "Hidden";
}

//added by kishore on 9/21/2004
function enableInformName()
{
	if (document.getElementById("inform_to").value!="")
	{
		document.getElementById("im").style.visibility     = 'visible';
		document.getElementById("informed_date").disabled	 =	false;
		document.getElementById("infocalimg").disabled	 =	false;
		document.getElementById("informed_name").disabled	 =	false;
	}
	if (document.getElementById("inform_to").value=="")
	{
		document.getElementById("im").style.visibility    = 'hidden';
		document.getElementById("informed_date").disabled	=	true;
		document.getElementById("informed_name").disabled	=	true;
		document.getElementById("informed_name").value	=	'';
		document.getElementById("informed_date").value	=	'';
		document.getElementById("infocalimg").disabled	=	true;
	}

	if (document.forms[0].inform_to.value != "")
	{								
		var patientid	= document.getElementById("hdnPatientId").value;
		var informTo	= document.forms[0].inform_to.value;
		var disp_pat_name="";
		if (informTo == '01')
		{
			disp_pat_name=document.forms[0].contact1_name.value;
		}else if(informTo =='02')
		{
			disp_pat_name=document.forms[0].contact2_name.value;
		}
		document.forms[0].informed_name.value = disp_pat_name;
		document.forms[0].informed_name.disabled=false;
		if(disp_pat_name!='')
			document.forms[0].informed_name.focus();
		
		/*
		var HTMLVal = " <html><body onKeyDown='lockKey()'><form name='dummy_form' id='dummy_form' method='post'  action='../../eIP/jsp/ValidateRenewPeriod.jsp' ><input type='hidden' name='field1' id='field1' value='InformDetails'><input type='hidden' name='field2' id='field2' value='"+patientid+"'><input type='hidden' name='field3' id='field3' value='"+informTo+"'><input type='hidden' name='field4' id='field4' value='RecordInpatientLeave'><input type='hidden' name='field5' id='field5' value='Leave'></form></body></html>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.dummy_form.submit();
		document.getElementById("informed_name").disabled	 =	false;
		*/
	}
	else 
	{
		document.getElementById("informed_name").value =  "";
	}
}

function record_lv(obj)
{
	if((obj.value!="") && (document.getElementById("fromdate").value!=""))
	if(!(ValidateDateTime(document.getElementById("fromdate"),obj)))
	{
		var error = getMessage("DATE1_LT_DATE2","IP"); 
        error = error.replace('$',getLabel("Common.InformedDate/Time.label","Common"));
		if(document.getElementById("record_status").value=="02")
			error = error.replace('#',getLabel("eIP.AbscondingDateTime.label","IP"))
		else
			error = error.replace("#",getLabel("eIP.leavedatetime.label","IP"));
		alert(error);
		obj.value = "";
		obj.focus();
		return false; 
	}
}


