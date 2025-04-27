function create()
{
f_query_add_mod.location.href = "../../eIP/jsp/PaintReleaseBed.jsp" ;
}


function apply()
{
	
	if(parent.frames[2].frames[1].frames[1].document.ReleaseBedDetail_Form!=null)
	{	
		var n = parent.frames[2].frames[1].frames[1].document.ReleaseBedDetail_Form.no_of_rec.value;

		var e=0;
		var p="";
		var sel=0;
		
		//Added by Sethu for the EDGE issue 65480 on 30/08/2024 
		parent.frames[2].frames[0].location.href='../../eCommon/jsp/process.jsp';
		
		parent.frames[2].frames[1].frames[1].document.ReleaseBedDetail_Form.action='../../servlet/eIP.ReleaseBedServlet' ;
		parent.frames[2].frames[1].frames[1].document.ReleaseBedDetail_Form.target="messageFrame";
		parent.frames[2].frames[1].frames[1].document.ReleaseBedDetail_Form.submit();
	}
	else
	{
		parent.frames[2].frames[0].location.reload();
	}	
	
}


function reset()
{
	parent.frames[2].frames[1].frames[0].document.forms[0].reset();
	parent.frames[2].frames[1].frames[1].location.href = '../../eCommon/html/blank.html';
	parent.frames[2].frames[1].frames[0].document.forms[0].search.disabled=false;
}

function onSuccess()
{
	//parent.frames[2].frames[1].frames[0].document.location.href='../../eIP/jsp/ReleaseBedMain.jsp';
	parent.frames[2].frames[1].frames[0].document.location.reload();
	parent.frames[2].frames[1].frames[1].location.href = '../../eCommon/html/blank.html';
	
}

function callDetail(call_function)
{
	if(call_function == "null")
		call_function ="" ;
	else
		call_function = "&"+call_function
	
	parent.ReleaseBed_main.document.ReleaseBedMain_Form.search.disabled=true;
	var nursingunit = parent.ReleaseBed_main.document.ReleaseBedMain_Form.nursing_unit.value;
	var bedclass = parent.ReleaseBed_main.document.ReleaseBedMain_Form.Bedcode.value;
	var blocktype = parent.ReleaseBed_main.document.ReleaseBedMain_Form.blocktype.value;
	var bookingtype = parent.ReleaseBed_main.document.ReleaseBedMain_Form.booking_type.value;
	//var fromdate = parent.ReleaseBed_main.document.ReleaseBedMain_Form.from_date.value;
	var fromdate = convertDate( parent.ReleaseBed_main.document.ReleaseBedMain_Form.from_date.value,"DMY",localeName,"en");
	//var untildate = parent.ReleaseBed_main.document.ReleaseBedMain_Form.until_date.value;
	var untildate = convertDate( parent.ReleaseBed_main.document.ReleaseBedMain_Form.until_date.value,"DMY",localeName,"en");
	//var reservedbedyn = parent.ReleaseBed_main.document.ReleaseBedMain_Form.includereservebed_yn.value;
	var select_bed = parent.ReleaseBed_main.document.ReleaseBedMain_Form.select_bed.value;

	//parent.ReleaseBed_details.location.href = "../../eIP/jsp/ReleaseBedDetail.jsp?fromSelect=fromSelect&nursing_unit_code="+escape(nursingunit)+"&bed_class_code="+escape(bedclass)+"&booking_type="+escape(bookingtype)+"&from_date="+fromdate+"&until_date="+untildate +"&block_type="+escape(blocktype)+"&reservebedyn="+reservedbedyn+call_function;
	parent.ReleaseBed_details.location.href = "../../eIP/jsp/ReleaseBedDetail.jsp?fromSelect=fromSelect&nursing_unit_code="+escape(nursingunit)+"&bed_class_code="+escape(bedclass)+"&booking_type="+escape(bookingtype)+"&from_date="+fromdate+"&until_date="+untildate +"&block_type="+escape(blocktype)+"&select_bed="+select_bed+call_function;
	
}

function popDynamicValues(){}

function DateCompare(from,to) 
{
	var flg1 = validDateObj(from,"DMY",localeName);
	var flg2 = validDateObj(to,"DMY",localeName);

	if(flg1 && flg2 )
	{

		var greg_fromdate = convertDate(from.value,"DMY",localeName,"en");
		var greg_todate = convertDate(to.value,"DMY",localeName,"en");
		if(!isBefore(greg_fromdate,greg_todate,"DMY",'en'))
		{
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			to.value = "";
			to.focus();
			to.select();
		}	
	}
	return true;
}
	

function clearValues()
{
	parent.frames[1].location.href = "../../eCommon/html/blank.html";
	document.ReleaseBedMain_Form.search.disabled=false;
}


// Function will check for empty values before calling up the common lookup func..
async function beforeGetNursingUnit(operstn,target_id,target)
{
	if(document.forms[0].nurs_desc_hid.value != document.forms[0].nursing_unit_desc.value)
	{
		if(document.forms[0].nursing_unit_desc.value != "")
			 await Lookup(operstn,target_id,target);
	}
	if (document.forms[0].nursing_unit_desc.value == "")
		document.forms[0].nursing_unit.value = "";
}

// By Annadurai 14/4/2004 ., 
// to open the lookup only when the nursing unit description is empty
async function beforeLookup(operstn,target_id,target)
{
		if (target.value == "") 
			await Lookup(operstn,target_id,target);
}

// To open the lookup only when the Bed Class description is not empty.
async function beforeBedClassLookup(target_id,target)
{
	if (document.forms[0].BedClassHidden.value != document.forms[0].bed_class_desc.value)
		if (target.value != "")
			await BedClassLookup(target_id,target);
	if (document.forms[0].bed_class_desc.value == "")
		document.forms[0].Bedcode.value = "";
}

// to open the lookup only when the Bed Class description is empty.
async function BedClassLookupClick(target_id,target)
{
	if (target.value == "")
		await BedClassLookup(target_id,target);
}


async function Lookup(operstn,target_id,target)
{
	var Facility_ID				=  document.forms[0].facilityID.value;
	var Login_User				=  document.forms[0].loginUser.value;
	var operstation				=  operstn;

	var title="";
	var argumentArray=new Array(8);
	if(target_id.name == "nursing_unit")
	{

		title=getLabel('Common.nursingUnit.label','Common');

		var call_function =document.forms[0].call_function.value;
		var nursingUnitCode=document.forms[0].nursing_unit_desc.value;
		
		var tit			            = getLabel('Common.nursingUnit.label','Common');
		var dialogHeight        = "400px" ;
    var dialogWidth         = "950px"; 
	/*var dialogHeight		= "28" ;
	var dialogWidth			= "43" ;*/
		var status					= "no";
		var features				= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status ;
		var arguments				= "" ;
		var retVal					= new String();

		var jsp_name = "../../eIP/jsp/GeneralNursingUnitSearch.jsp?statics_yn=Y&nursingUnitCode="+encodeURIComponent(nursingUnitCode)+"&login_user="+Login_User+"&oper_id="+operstation+"&title="+encodeURIComponent(tit)+"&facility_id="+Facility_ID+"&call_function="+call_function;
		
		var retVal =  await window.showModalDialog(jsp_name,arguments,features);
		
		var arr=new Array();

}
			
	if(retVal ==null || retVal=="" || !retVal)
	{
		target.value="";
		target_id.value="";
	}
	else
	{
		arr=retVal.split("~");
		target_id.value=arr[0];
		target.value=arr[1];
		document.forms[0].nurs_desc_hid.value = document.forms[0].nursing_unit_desc.value;
	}
}


/************************************************/
/* CREATED ON 10/02/04 by SRIDHAR */
/* START OF COMMON LOOKUP FOR BEDCLASS */
/************************************************/
async function BedClassLookup(target_id,target)
{
	var title="";
	var argumentArray=new Array(8);
	var locale=document.forms[0].locale.value;

	if(target_id.name == "Bedcode")
	{							
		title=getLabel('Common.BedClass.label','common');

		argumentArray[0]="select BED_CLASS_CODE code,SHORT_DESC description from IP_BED_CLASS_LANG_VW where language_id='"+locale+"' and EFF_STATUS like ? and upper(BED_CLASS_CODE) like upper(nvl(?,BED_CLASS_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC)) ";

		argumentArray[1]=new Array("EFF_STATUS");
		argumentArray[2]=new Array("E");
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
}
			
var retVal=await CommonLookup(title,argumentArray);
			
if(retVal ==null || retVal=="" || !retVal)
	{
	target.value="";
	target_id.value="";
	}
	else
	{
		var arr=new Array();
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target_id.value=arr[0];
		target.value=arr[1];
		document.forms[0].BedClassHidden.value = document.forms[0].bed_class_desc.value;
	}
}
/************************************************/
/* END OF COMMON LOOKUP FOR BEDCLASS */
/************************************************/

function submitPrevNext(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
}
function reserveBedChecked(obj)
{
	if(obj.checked==true)
	{
		obj.value='Y';
	}
	else if(obj.checked==false)
	{
		obj.value='N'
	}
}

function checkbill(obj,obj2)
{
	if(obj2 != ""){
		if(obj2 == "BL6364"){
			alert(getMessage("BL6364","BL"));
			obj.checked = false;
		}
		else if(obj2 == "BL6363"){
			alert(getMessage("BL6363","BL"));
			obj.checked = false;
		}
		else if(obj2 == "BL1126"){
			alert(getMessage("BL1126","BL"));
			obj.checked = false;
		}
	}
}
