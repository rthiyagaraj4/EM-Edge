function create()
{
	f_query_add_mod.location.href = "../../eIP/jsp/AddModifyBlockBed.jsp" ;
}

function query()
{
	f_query_add_mod.location.href ="../../eIP/jsp/BlockBedQueryCriteria.jsp" ;
}

function apply()
{
	setTimeout('submitVal()',500);
}

function submitVal()
{
	//Remarks field added by kishore on 4/16/2004 for mandatory check validaion
	var fields = new Array(
				f_query_add_mod.document.Blocking_Bed_Form.nursing_unit,
	   	        f_query_add_mod.document.Blocking_Bed_Form.bed_no,
				f_query_add_mod.document.Blocking_Bed_Form.blocktype,
				f_query_add_mod.document.Blocking_Bed_Form.remarks,
				f_query_add_mod.document.Blocking_Bed_Form.from_date,
				f_query_add_mod.document.Blocking_Bed_Form.until_date
				
			      );

	
	var names = new Array (	
		    getLabel("Common.nursingUnit.label","Common"),
		    getLabel("Common.bedno.label","Common"),
			getLabel("eIP.BlockType.label","IP"),
			getLabel('Common.remarks.label','Common'),
			getLabel("Common.fromdate.label","Common"),
			getLabel("eIP.UntilDateTime.label","IP")
			
			  );

	var obj1	= f_query_add_mod.document.Blocking_Bed_Form.bed_no;
	if(f_query_add_mod.document.Blocking_Bed_Form.blocking_ref_no!=null)
	{
		fields[fields.length] = f_query_add_mod.document.Blocking_Bed_Form.blocking_ref_no
		names[names.length] = getLabel('eIP.BlockingRefNo.label','eIP');
	}

	// Commented by S.Sathish for SRR20056-SCF-4620 [IN:021843] on Monday, June 07, 2010
	/*if(f_query_add_mod.document.Blocking_Bed_Form.remarks_flag.value=='mandatory')
	{								
	fields[fields.length] = f_query_add_mod.document.Blocking_Bed_Form.remarks
	names[names.length] = getLabel('Common.remarks.label','Common');
	}*/

	var doSubmit = false;
				
	if (f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		doSubmit = true;
	}

	/*if(doSubmit == true)
	{
		if (f_query_add_mod.dateVal(f_query_add_mod.document.Blocking_Bed_Form.from_date))
		{
			doSubmit = false;
		}
	}*/

	if(doSubmit == true)
	{
		if (f_query_add_mod.checkUntilDate(f_query_add_mod.document.Blocking_Bed_Form.until_date,f_query_add_mod.document.Blocking_Bed_Form.grace.value))
		{
			//Added by S.Sathish for SRR20056-SCF-4620 [IN:021843] on Monday, June 07, 2010
			doSubmit = false;		
			frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
			
		}
	}

	if(doSubmit == true)
	{
		//Put values in Dummy Frame variables
		obj1	=    f_query_add_mod.document.Blocking_Bed_Form.bed_no;
		obj2	=    f_query_add_mod.document.Blocking_Bed_Form.nursing_unit;
		f_query_add_mod.document.Blocking_Bed_Form.action = "../../servlet/eIP.BlockBedServlet";
		f_query_add_mod.document.Blocking_Bed_Form.submit();
		f_query_add_mod.document.getElementById("bedclass").innerText="";
		f_query_add_mod.document.getElementById("roomno").innerText="";
	}
}

function sub()
{
}

function reset()
{
	//f_query_add_mod.document.forms[0].all.bedclass.innerText="";
	//f_query_add_mod.document.forms[0].all.roomno.innerText="";	
	f_query_add_mod.document.getElementById("bedclass").innerText="";
	f_query_add_mod.document.getElementById("roomno").innerText="";
	f_query_add_mod.document.Blocking_Bed_Form.reset() ;	
}

function onSuccess()
{
	f_query_add_mod.document.Blocking_Bed_Form.reset();
//	f_query_add_mod.location.href = "../../eIP/jsp/AddModifyBlockBed.jsp" ;  
}


async function searchBed()
{
	var nursingunit =document.forms[0].nursing_unit.value;
	var retVal = 	new String();
	var dialogHeight= "72vh" ;
	var dialogWidth	= "65vw" ;
	var dialogTop	= "72px" ;	
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + ";dialogTop:" + dialogTop + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog( "../../eIP/jsp/BedAvailabilityChart.jsp?nursing_unit_code="+nursingunit+"&wherecondn=BLOCK_BED_YN",arguments,features);
	
	if(retVal!=null)
	{
		var arr=retVal.split("^");
		if (arr.length > 2)
		{
		
			if(arr[1] == null) arr[1]="";
			if(arr[4] == null) arr[4]="";
			if(arr[3] == null) arr[3]="";
			if(arr[2] == null) arr[2]="";
			document.forms[0].nursing_unit.value		=	arr[0];
			document.forms[0].nursing_unit_desc.value	=	arr[9];
			var arr1 = arr[1].split("/");
			document.forms[0].bed_no.value				=	arr1[0]
			document.getElementById("roomno").innerText		=	arr[4]
			document.forms[0].room_no.value				=	arr[4]
			document.forms[0].bed_class.value			=	arr[3]
			if (document.forms[0].bed_class.value != '')
			popDynamicValuesForBed(document.forms[0].bed_no,document.forms[0].nursing_unit,parent.frames[2])				
			document.forms[0].bed_type.value			=	arr[2]
		
		}
		else
		{
			document.forms[0].nursing_unit.value		=	arr[0];
			if (arr.length == 2)
				document.forms[0].nursing_unit_desc.value	=	arr[1];
		}
	}
}

function popDynamicValues(){
	self.document.Blocking_Bed_Form.bed_no.value = '';
	self.document.getElementById("bedclass").innerText = '';
	self.document.getElementById("roomno").innerText = '';
}

function popDynamicValuesForBed(obj,obj2,obj3)
{
	var sStyle = document.forms[0].sStyle.value;
	if(obj2.value=="" && obj.value != '')
	{
		var msg = parent.parent.frames[0].getMessage('CAN_NOT_BE_BLANK',"Common");
		msg = msg.replace('$',getLabel("Common.nursingUnit.label","Common"));
		if(msg != "")
			parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
	}
	if ((obj.value != "") && (obj2.value != ""))
	{		
		var HTMLVal  =  "<html><head><link rel='stylesheet' type='text/css' "+ "href='../../eCommon/html/"+sStyle+"'></link></head>" + 
		"<body class='message' onKeyDown='lockKey()'><form name='f' id='f' "+ "action='../../eIP/jsp/FetchValForBlockBed.jsp'>";
		HTMLVal += "<input type='hidden' name='obj_name' id='obj_name' value='"+obj.name+"'>"; 
		HTMLVal += "<input type='hidden' name='nursing_unit' id='nursing_unit' value='"+obj2.value+"'>";
		HTMLVal += "<input type='hidden' name='bed_no' id='bed_no' value='"+obj.value+"'>";
		HTMLVal += "</form></body></html>";
		
		eval(obj3).document.write(HTMLVal);
 		eval(obj3).document.f.submit();
		return true;
		  
	}
}

function getDetailsForBlock(obj)
{
	var sStyle = document.forms[0].sStyle.value;
	if(obj.value != "")
	{
			
		var HTMLVal  =  "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head> <body class='message' onKeyDown='lockKey()'><form name='f' id='f' action='../../eIP/jsp/FetchValForBlockBed.jsp'>"
		HTMLVal += "<input type='hidden' name='obj_name' id='obj_name' value='"+obj.name+"'>"
		HTMLVal += "<input type='hidden' name='block_type' id='block_type' value='"+obj.value+"'>"
		HTMLVal += "<input type='hidden' name='bed_no' id='bed_no' value='"+obj.value+"'>"
		HTMLVal += "</form></body></html>"
		parent.frames[2].document.write(HTMLVal);
		parent.frames[2].document.f.submit();
	}
	else
		document.forms[0].override.checked = false ;
}

function objChk(obj)
{	
	if (obj.checked)
	{
		document.getElementById("override").value = 'Y';
	}
	else
	{
		document.getElementById("override").value = 'N';
	}
}

function dateVal(obj)
{	
	//mandimg Commented by S.Sathish for SRR20056-SCF-4620 [IN:021843] on Monday, June 07, 2010
	var sStyle = document.forms[0].sStyle.value;
	if(obj!="" && obj!=null)
	{
		/*if(obj.value == '')
		{ 
			document.getElementById("mandimg").style.visibility = "Hidden";
			document.getElementById("remarks_flag").value = 'optional';			
			return false;
		}*/
		if(validDateObj(obj,"DMYHM", localeName)) 
		{
			
			var greg_DateValue = convertDate(obj.value,"DMYHM",localeName,"en");
			if(obj.name == "from_date")
			{				
				if(!isAfterNow(greg_DateValue,"DMYHM","en"))
				{
					alert(getMessage("FROM_DATE_LESS_SYSDATE","SM"));
					document.getElementById("until_date").value="";
					obj.select();
					obj.focus();					
				}
				else
				{
					var HTMLVal  =  "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head> <body class='message' onKeyDown='lockKey()'><form name='f' id='f' action='../../eIP/jsp/FetchValForBlockBed.jsp'>"
					HTMLVal += "<input type='hidden' name='obj_name' id='obj_name' value='"+obj.name+"'>"
					//HTMLVal += "<input type='hidden' name='from_date' id='from_date' value='"+obj.value+"'>"
					HTMLVal += "<input type='hidden' name='from_date' id='from_date' value='"+greg_DateValue+"'>"
					HTMLVal += "<input type='hidden' name='blocking_type_code' id='blocking_type_code' value='"+document.getElementById("blocktype").value+"'>"
					HTMLVal += "</form></body></html>"
					parent.parent.frames[2].frames[2].document.write(HTMLVal);
					parent.parent.frames[2].frames[2].document.f.submit();					
				}
			}
			else
			{
				//document.getElementById("mandimg").style.visibility = "Hidden";
				//document.getElementById("remarks_flag").value = 'optional';
				return true;
			}
		}
		/*else
		{
			document.getElementById("mandimg").style.visibility = "Hidden";
			document.getElementById("remarks_flag").value = 'optional';
			return false;
		}*/
	}
		
	//document.getElementById("mandimg").style.visibility = "Hidden";
	//document.getElementById("remarks_flag").value = 'optional';
	
	
	
}


function dateValRemarks(obj)
{
	
	var sStyle = document.forms[0].sStyle.value;
	if(obj.name == "remarks")
	{
		if(makeValidString(obj))
		{
			var greg_DateValue = convertDate(document.getElementById("from_date").value,"DMYHM",localeName,"en");
		
			var HTMLVal  =  "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head> <body class='message' onKeyDown='lockKey()'><form name='f' id='f' action='../../eIP/jsp/FetchValForBlockBed.jsp'>"
			HTMLVal += "<input type='hidden' name='obj_name' id='obj_name' value='"+obj.name+"'>"
			//HTMLVal += "<input type='hidden' name='from_date' id='from_date' value=\""+obj.value+"\">"
			HTMLVal += "<input type='hidden' name='from_date' id='from_date' value=\""+greg_DateValue+"\">"
			HTMLVal += "</form></body></html>"
			parent.parent.frames[1].frames[2].document.write(HTMLVal);
			parent.parent.frames[1].frames[2].document.f.submit();
		}
	}
}


 function checkUntilDate(object,grace)
{	
	//mandimg Commented by S.Sathish for SRR20056-SCF-4620 [IN:021843] on Monday, June 07, 2010
	var grace_type = document.getElementById("grace_type").value;
	var grace_normal = document.getElementById("grace_normal").value;
	var grace_max = document.getElementById("grace").value;		
	//if((object.value != "") && (grace != "") && date_val != "" && validDate(Object.value,"DMYHM",'en'))
	//if((object.value != "") && (grace != "") && validDateObj(object,"DMYHM",localeName))
	if((object.value != "") && (grace != "") && document.forms[0].from_date.value!='')
	{
		if(grace_type == 'H')
			var graceval = grace; 
		else if(grace_type == 'D')
			var graceval = grace_max * 24; 
		
		var date_until = convertDate(object.value, "DMYHM", localeName,'en');
		var date_val = convertDate(document.forms[0].from_date.value, "DMYHM", localeName,'en');
			
		var dtt2 = plusDate(date_val,"DMYHM",'en' , grace_normal, 'h');
		var dtt3 = "";
	

		if(!isBefore(date_val,date_until,'DMYHM','en'))
		{
			alert(getMessage("UNTIL_DATE_LESS_FM_DATE","IP"));			
			object.focus();
			object.select();
		}

		if(isAfter(date_until,dtt2,"DMYHM",'en'))
		{
			//document.getElementById("mandimg").style.visibility = "Visible";
			//document.getElementById("remarks_flag").value = 'mandatory';
		}
		else if(isBefore(date_until,dtt2,"DMYHM",'en'))
		{
			//document.getElementById("mandimg").style.visibility = "Hidden";
			//document.getElementById("remarks_flag").value = 'optional';
		}
		
		if(grace_type == 'H')
		{	
			//var dtt3 = plusDate(date_val,"DMYHM",localeName , parseInt(grace_max)-1, 'h');
			dtt3 =  plusDate(date_val,"DMYHM",'en' , parseInt(grace_max), 'h');
		}
		else if(grace_type == 'D')
		{
			//var dtt3 = plusDate(date_val,"DMYHM",localeName , parseInt(graceval)-parseInt(grace_normal), 'h');
			dtt3 =  plusDate(date_val,"DMYHM","en" , parseInt(graceval)-parseInt(grace_normal), 'h');
		}
		if(! isBefore(date_until,dtt3,"DMYHM",'en'))
		{
			alert(getMessage('BLK_PRIOD_RANGE_EXCEEDS','IP'));				
			//document.getElementById("mandimg").style.visibility = "Hidden";
			//document.getElementById("remarks_flag").value = 'optional';			   
					parent.parent.frames[2].frames[1].document.forms[0].until_date.select();
					parent.parent.frames[2].frames[1].document.forms[0].until_date.focus();				
			return true;
		}

	}
}

function chkmax()
{
}


//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// Added by Sridhar on 6 APR 2004
// Function will check for empty values & call CommonLookup only when the value in the textbox is empty.......

function checkTxtVal(Facility_ID,Login_User,Operator_Station_ID,target_id,target)
{
	if(document.forms[0].nursing_unit_desc.value == "")
		NursingUnitLookup(Facility_ID,Login_User,Operator_Station_ID,target_id,target);
}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// Added by Sridhar on 5 APR 2004
// Function will check for empty values before calling up the common lookup func..
		
function beforeGetNursingUnit(Facility_ID,Login_User,Operator_Station_ID,target_id,target)
{
	if(document.forms[0].nurs_desc_hid.value != document.forms[0].nursing_unit_desc.value)
	{
		if(document.forms[0].nursing_unit_desc.value != "")
		{
			NursingUnitLookup(Facility_ID,Login_User,Operator_Station_ID,target_id,target); 
			document.forms[0].bed_no.value	=	"";
			document.getElementById("bedclass").innerText	=	"";
			document.getElementById("roomno").innerText	=	"";
		}
	}
}

/* CODED TO COMMON LOOKUP ON 9/17/2004 by kishore */
/* START COMMON LOOKUP */

async function NursingUnitLookup(Facility_ID,Login_User,Operator_Station_ID,target_id,target) 
{
	var Facility_ID				=	Facility_ID;
	var Login_User				=	Login_User;
	var Operator_Station_ID		=	Operator_Station_ID;
	var sql				= "";
	var tit				= "";
	var retVal			= new String();
	var argumentArray	= new Array() ;

	if(target_id.name == "nursing_unit")
	{
	var call_function =document.forms[0].call_function.value;
	var nursingUnitCode=document.forms[0].nursing_unit_desc.value;
	
	var tit			= getLabel("Common.nursingUnit.label","Common");
	var dialogHeight			= "400px" ;
	var dialogWidth				= "700px" ;
	var status					= "no";
	var features				= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status ;
	var arguments				= "" ;
	var retVal =    new String();

	var jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&nursingUnitCode="+encodeURIComponent(nursingUnitCode)+"&login_user="+Login_User+"&oper_id="+Operator_Station_ID+"&title="+encodeURIComponent(tit)+"&facility_id="+Facility_ID+"&call_function="+call_function;
	
	var retVal =  await window.showModalDialog(jsp_name,arguments,features);
	
	var arr=new Array();
	}
		if(retVal != null && retVal != "" )
		{
			arr=retVal.split("~");
			target_id.value=arr[0];
			target.value=arr[1];
			document.forms[0].nurs_desc_hid.value = document.forms[0].nursing_unit_desc.value;
		
		}
		else
		{	
			target.value="";
			target_id.value="";
		}
}

/* END OF COMMON LOOKUP */

// To check the Nursing Unit Value and if the nursing unit is not there then reset the page.
function checkForNursing(val)
{
	if (val=="")
	{
		document.Blocking_Bed_Form.reset();
		document.getElementById("bedclass").innerText	=	"";
		document.getElementById("roomno").innerText	=	"";
	}
}

function checkForBedNo(val)
{
	if (val=="")
	{
		document.getElementById("bedclass").innerText	=	"";
		document.getElementById("roomno").innerText	=	"";
	}
}


function getRoomNo()
{
	popDynamicValuesForBed(document.forms[0].bed_no,document.forms[0].nursing_unit,parent.frames[2])
}

//function from jsp
function validSplchars_ref(obj)
{	
	var val = obj.value.toUpperCase();			
	obj.value = val;	
	var fields=new Array();
	var names=new Array();
	fields[0]=obj;
	names[0]="Blocking Ref. No";
	if(SpecialCharCheck( fields, names,'',"A",''))
		return true;
	else
	{
		obj.select();
		obj.focus();
		return false;
	}
}
//Commented by S.Sathish for SRR20056-SCF-4620 [IN:021843] on Monday, June 07, 2010

/*function focusFirst()
{
	if(document.forms[0].blocking_ref_no) document.forms[0].blocking_ref_no.focus();
	document.getElementById("mandimg").style.visibility  = "Hidden";
}

function chkda()
{
	if(todat > fromdat) 
	{
		document.getElementById("mandimg").style.visibility = "Visible";
		document.getElementById("remarks_flag").value = 'mandatory';
	}
	else
	{
		document.getElementById("mandimg").style.visibility = "hidden";
		document.getElementById("remarks_flag").value = 'optional';
	}
	if(todat > maxdat)
	{
		alert(getMessage('BLK_PRIOD_RANGE_EXCEEDS','IP'));	
		document.Blocking_Bed_Form.until_date.value="";
		document.Blocking_Bed_Form.until_date.focus();
		document.getElementById("mandimg").style.visibility = "hidden";
	}
}*/

