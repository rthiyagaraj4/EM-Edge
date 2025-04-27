//var added_patfile_vol = new ActiveXObject("Scripting.Dictionary");
//var added_rem_remarks= new ActiveXObject("Scripting.Dictionary");

//var added_patfile_vol = CreateObject("Scripting.Dictionary");
//var added_rem_remarks= CreateObject("Scripting.Dictionary");

function apply()
{
	var p_total_records = parent.frames[2].frames[1].frames[1].document.forms[0].p_counter.value;
	var p_pull_type = parent.frames[2].frames[1].frames[1].document.forms[0].confirm_yn.value;
	var p_req_select      = "";
	var p_rec_count       = 0;
	var proceed;
	for(var i = 1;i < p_total_records;i++) 
	{
		p_req_select = eval("parent.frames[2].frames[1].frames[1].document.forms[0].pull_yn"+i+".checked");
		if(p_req_select == true) 
			p_rec_count++;
	}
	if(p_rec_count == 0 && p_pull_type=="N" )
	{
 		proceed = false;
	}
	else
	{
		proceed = true;
	}
	if(proceed == true)
	{
		var confirm_yn =parent.frames[2].frames[1].frames[1].document.forms[0].confirm_yn.value;
		
		if (confirm_yn=="Y"||confirm_yn=="N")
		{
			var val_chk = confirm(parent.frames[2].frames[1].frames[1].getMessage("PRINT_CONFIRM_LIST","FM"));
			if(val_chk)
			{
				parent.frames[2].frames[1].frames[1].document.forms[0].print_pulled_list.value='Y';
			}
			else
			{
				parent.frames[2].frames[1].frames[1].document.forms[0].print_pulled_list.value='N';
			}
			var val_chk = confirm(parent.frames[2].frames[1].frames[1].getMessage("PRINT_TRACE_RECORD","FM"));
			if (val_chk)
			{
				parent.frames[2].frames[1].frames[1].document.forms[0].print_tracer_card.value='Y';
			}
			else
			{
				parent.frames[2].frames[1].frames[1].document.forms[0].print_tracer_card.value='N';
			}
		}
		
		parent.frames[2].frames[1].frames[0].document.forms[0].print_only_report.value="N";
		var p_concat_string ='';
		var to_proceed = true;
		var fields = new Array ( parent.frames[2].frames[1].frames[0].document.forms[0].fs_locn_code);
		var names = new Array ( getLabel("eFM.FSLocation.label","common"));	
		var errors = "";
		for(var i=0;i<fields.length;i++) 
		{
			if(trimCheck(fields[i].value)) 
			{
				fields[i].value = trimString(fields[i].value);
			}
			else	
			{
				//errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
				errors = errors + getMessage("CAN_NOT_BE_BLANK","common");
				errors=errors.replace('$',names[i]);
			}
		}
		if(errors.length != 0) 
		{
			parent.frames[1].frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			to_proceed = false;
				return false ;
		}

		p_preferred_date = parent.frames[2].frames[1].frames[1].document.forms[0].preferred_date.value;
		if(localeName=="en"){
		 parent.frames[2].frames[1].frames[1].document.forms[0].preferred_date.value=p_preferred_date;
		}else{
			parent.frames[2].frames[1].frames[1].document.forms[0].preferred_date.value = convertDate(p_preferred_date,"DMY",localeName,"en");	
		}

		 

		if(to_proceed==true)
		{			
			parent.frames[2].frames[1].frames[1].document.forms[0].action='../../servlet/eFM.FMIPConfirmPullingListServlet'
			parent.frames[2].frames[1].frames[1].document.forms[0].target="messageFrame";
			parent.frames[2].frames[1].frames[1].document.forms[0].submit();
		}
	} 
	else 
	{
		var	messag = getMessage("NO_FILE_FOR_CON_PULL","FM");
		parent.frames[1].frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+messag ;
	}
}

function UnselectPullAll(obj)
{
	if (obj.checked==false)
	{
		//parent.frames[1].document.forms[0].select_all.checked=false;
	}
}
function fetchResults(obj, obj1,obj2,obj3,obj5,obj6,obj7,obj8,obj9)
{
	var obj1_value	=	obj1.value;
	if(obj1_value != "")
	{
		//if(validDateObj(obj,"DMY",localeName))
		//{ 
			document.forms[0].CBValStr.value="";
			var preferred_date=document.forms[0].preferred_date.value;
		//	preferred_date=convertDate(preferred_date,"DMY",localeName,"en");
			if(preferred_date !="")
			{
			   if (obj3.value!="")
			   {
					var fields = new Array ( document.forms[0].fm_pract_id,document.forms[0].to_pract_id);
					var f_prat_id=getLabel("Common.from.label","common")+ " " + getLabel("Common.practitionerid.label","common");
					var t_prat_id=getLabel("Common.to.label","common")+ " " + getLabel("Common.practitionerid.label","common");
					var names = new Array ( f_prat_id, t_prat_id);
					var error_jsp="../../eCommon/jsp/error.jsp";
					if (SpecialCharCheck( fields, names, parent.parent.frames[2],'M',error_jsp)){
					document.forms[0].fs_locn_code.disabled=true;				
					document.forms[0].p_gender.disabled=true;
					document.forms[0].fm_nursing_unit_code.disabled=true;
					document.forms[0].fm_pract_id.disabled=true;				
					document.forms[0].confirm_yn.disabled=true;
					document.forms[0].pull_type.disabled=true;
					document.forms[0].pract_id.disabled=true;				
					document.forms[0].subBotton.disabled=true;
					parent.frames[1].location.href='../../eFM/jsp/FMIPConfirmPullingListResults.jsp?preferred_date='+preferred_date+'&fs_locn_code='+obj1.value+'&gender='+obj2.value+'&fm_nursing_unit_code='+obj3.value+'&fm_pract_id='+obj5.value+'&to_pract_id='+obj6.value+'&confirm_yn='+obj7.value+'&appl_user_id='+obj8.value+'&pull_type='+obj9.value+'&flagSelect=fromSelect';
					parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
			  }
			}
			else
			{
				var error = getMessage('CAN_NOT_BE_BLANK','common');
				error = error.replace('$',getLabel("Common.nursingUnit.label","common"));
				parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+error+"&err_value=0";
			}
			}
			else
			{			
				var error = getMessage('CAN_NOT_BE_BLANK','common');
				error = error.replace('$',getLabel("Common.BookingDate.label","common"));
				parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+error+"&err_value=0";
				
			}
		//}
	}
	else
	{
		var msg=getMessage("FILE_STORAGE_NOT_BLANK","FM");
		parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
	}
}
function dispRecord()
{
	var CBValStr	=	parent.frames[0].document.forms[0].CBValStr.value;
	if(CBValStr != "")
	{
		var val	=	CBValStr.split('~')
		for(i=0; i<val.length; i++)
		{
			var assign	=	val[i];
			if(assign!="")
			{
				if(eval('document.forms[0].'+assign))
				{
					eval('document.forms[0].'+assign+'.checked=true');
				}
			}
		}
	}
}
function CBValue(obj1, obj2)
{
	var count;
	var count1;
	var del_obj=obj1.name;
	var del_chk=obj1.checked;
	var del_locn_obj="fs_locn_code"+obj2;
	var temp_cb_str="";
	var temp_locn_str="";
	var chk_locn=eval('document.forms[0].fs_locn_code'+obj2);
	if(!(del_chk))
	{
		var cbString	= parent.frames[0].document.forms[0].CBValStr.value;
		if(cbString =="")chk_locn.value="";
		var split=cbString.split('~');
		for (i=0; i<(split.length-1); i++)
		{
			if(split[i] != del_obj)
			{
				temp_cb_str += split[i]+"~";
			}
			else
			{				
				temp_cb_str=temp_cb_str;
			}
		}
		cbString=temp_cb_str;
		parent.frames[0].document.forms[0].CBValStr.value=cbString;
	}
}
function reset()
{
	parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].frames[2].location.href='../../eFM/jsp/FMIPConfirmPullingListColor.jsp';
	parent.frames[2].frames[1].location.reload();
}
function PrintReport()
{
		var to_proceed=true;
		var fields = new Array ( parent.frames[0].document.forms[0].fs_locn_code,parent.frames[0].document.forms[0].preferred_date);
		var names = new Array ( getLabel("eFM.FSLocation.label","FM"), getLabel("Common.apptdate.label","common"));	
		var errors = "";
		for( var i=0; i<fields.length; i++ ) 
		{
			if(trimCheck(fields[i].value)) {
				fields[i].value = trimString(fields[i].value);
			}
			else	
			{
			//	errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
				errors=errors + getMessage("CAN_NOT_BE_BLANK","common");
				errors=errors.replace('$',names[i]);

			}
		}
		if ( errors.length != 0 ) 
		{
		parent.parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			to_proceed = false;
			return false ;
		}
		if (to_proceed==true)
		{
			parent.frames[0].document.forms[0].print_only_report.value='Y';

			parent.frames[0].document.forms[0].submit();
		}
}
function onSuccess()
{

var access_all = parent.frames[2].frames[1].frames[0].document.getElementById("access_all").value
	parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].frames[2].location.href='../../eFM/jsp/FMIPConfirmPullingListColor.jsp';

	parent.frames[2].frames[1].frames[0].location.reload();
	//parent.frames[2].frames[1].frames[0].location.href='../../eFM/jsp/FMIPConfirmPullingListCriteria.jsp?access_all='+access_all;
}
function searchCode(target,fac_id,target_name)
{
	var retVal = 	new String();
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var tit=getLabel("Common.user.label","common");
	var dispDescFirst="dispDescFirst";			
			
	tit=getLabel("Common.user.label","common");
	sql="Select APPL_USER_ID, APPL_USER_NAME from SM_FACILITY_FOR_USER_VW where facility_id=`"+fac_id+"` ";
	search_code="APPL_USER_ID";
	search_desc= "APPL_USER_NAME";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst="+dispDescFirst,arguments,features);
	if (retVal!=null)
	{
		if(!(unescape(retVal) == null))
		{
			arr=unescape(retVal).split("::");
			target_name.value=arr[0];
			target.value=arr[1];
		}
	}
	else
	{
		target.value="";
		target_name.value="";
	}
}

function changeUpperCase(obj)
	{
		obj.value = obj.value.toUpperCase();
	}

function searchCode1(target,facilityid)
{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";			
				tit=getLabel("Common.user.label","common");
				sql="select nursing_unit_CODE, LONG_DESC from ip_nursing_unit_lang_vw where facility_id=`"+facilityid+"`  and language_id=`"+localeName+"`";
				search_code="nursing_unit_CODE";
				search_desc= "LONG_DESC";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
			//alert("retVal:" + retVal);
			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
}


/*function searchCode2(target,facilityid)
{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";			
			
				tit=getLabel("Common.user.label","common");
				sql="select PRACTITIONER_ID, PRACTITIONER_NAME from am_practitioner_lang_vw where language_id=`"+localeName+"`";
				search_code="PRACTITIONER_ID";
				search_desc= "PRACTITIONER_NAME";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
}*/

async function searchCode2(target,facilityid)
{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";			
			var argumentArray  = new Array() ;
			var dataNameArray  = new Array() ;
			var dataValueArray = new Array() ;
			var dataTypeArray  = new Array() ;
			
			tit=getLabel("Common.user.label","common");
			sql="select PRACTITIONER_ID code, PRACTITIONER_NAME description from am_practitioner_lang_vw where language_id='"+localeName+"' and upper(PRACTITIONER_ID) like upper(?) and upper(PRACTITIONER_NAME) like upper(?)";
			search_code="PRACTITIONER_ID";
			search_desc= "PRACTITIONER_NAME";
			
			argumentArray[0] = sql;
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = target.value;
			argumentArray[6] = CODE_LINK  ;
			argumentArray[7] = CODE_DESC ;

			retVal = await CommonLookup( tit, argumentArray );

			var arr=new Array();
			
			if(retVal != null && retVal != "" ) 
			{
				var retVal=unescape(retVal);
				arr=retVal.split(",");
				target.value=arr[0];
			}
			/*if (!(retVal == null))
			{
				target.value=retVal;
			}*/
			else
				target.focus();
}

function SelectAll(from,to)
{
	var confirm_yn			=document.forms[0].confirm_yn.value;
	var preferred_date			=document.forms[0].preferred_date.value;
	preferred_date=convertDate(preferred_date,"DMY",localeName,"en");
	var p_fm_nursing_unit_code	=document.forms[0].fm_nursing_unit_code.value;
	var p_fm_pract_id		=document.forms[0].fm_pract_id.value;
	var p_to_pract_id		=document.forms[0].to_pract_id.value;
	var p_gender			=document.forms[0].gender.value;
	var pull_type			=document.forms[0].pull_type.value; 
	var p_fs_locn_code		=document.forms[0].fs_locn_code.value;
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	var select_all =document.forms[0].select_all.checked;
	var check="";
	if (select_all==true)
		check="Y"
	else
		check = "N"
	xmlStr ="<root><SEARCH check='"+check+"' preferred_date='"+preferred_date+"' p_fm_nursing_unit_code='"+p_fm_nursing_unit_code+"' p_fm_pract_id='"+p_fm_pract_id+"' p_to_pract_id='"+p_to_pract_id+"' p_gender='"+p_gender+"' pull_type='"+pull_type+"' p_fs_locn_code='"+p_fs_locn_code+"' confirm_yn='"+confirm_yn+"'/></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","FMConfirmPullingListConfirmAll.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText) 
	var select_all = document.forms[0].select_all.checked;
	var check="";
	if (select_all==true)
		check="Y"
	else
		check = "N"	
		var p_total_records = document.forms[0].p_counter.value;
		end = (parseInt(from.value)+parseInt(p_total_records))-1;
		if (select_all==true)
		{
			document.forms[0].check.value = "Y"
			for (var i=from.value;i<end ; i++)
			{
				if (eval("document.forms[0].pull_yn"+i+".disabled")==false)
				{
					var val_chk = eval("document.forms[0].pull_yn"+i).checked=true;
				}
			}	
		}
		else
		{
			document.forms[0].check.value = "N"
			for (var i=from.value;i<end ; i++)
			{
				if (eval("document.forms[0].pull_yn"+i+".disabled")==false)
				{
					var val_chk = eval("document.forms[0].pull_yn"+i).checked=false;
				}
			}	
		}

}

	
function submitPrevNext(from, to){
	    document.forms[0].from.value = from;
	    document.forms[0].to.value = to; 
	    document.forms[0].submit();
}
function loadCurrPage()
{

}


			
function GetRemarks(iVal,remarks)
{

var retVal;
var dialogHeight ='9' ;
var dialogWidth = '30' ;
var	remarksvalue = "";
var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
var arguments;
var comments;
if(comments=='' || comments == "null")
comments ='';
arguments = comments ;
var remarks="";


var p_file_no=eval(document.getElementById('p_file_no'+iVal)).value;
var vol_no=eval(document.getElementById('p_volume_no'+iVal)).value;
var pat_id=eval(document.getElementById('p_patient_id'+iVal)).value;

var pat_file_volume=pat_id+"`"+p_file_no+"`"+vol_no; 

var  added_rem_rem  =parent.frames[0].document.forms[0].added_rem_remarks.value;
var added_rem_rem_val  =parent.frames[0].document.forms[0].added_rem_remarks_values.value;

var patarray="";
var patfilevol="";
var patfilevol_item="";
var tempobj="";
var  patarray_val="";
var tempobj			= "";

if(added_rem_rem!="" && added_rem_rem_val!="")
{  
patarray =added_rem_rem.split(",");
patarray_val =added_rem_rem_val.split(",");
}

for(var i=0;i<=patarray.length;i++)
{
patfilevol=patarray[i];
patfilevol_item=patarray_val[i];
if (!added_rem_remarks.Exists(patfilevol) && patfilevol!=undefined)
{	

added_rem_remarks.add(patfilevol,patfilevol_item);
}
}

if (added_rem_remarks.Exists(pat_file_volume))
{
	
tempobj=added_rem_remarks.Item(pat_file_volume);
if(tempobj==undefined || tempobj==null) tempobj="";
remarks=tempobj;
}
else
remarks=eval("parent.frames[1].document.forms[0].p_remarks"+iVal).value;

retVal = window.showModalDialog('../../eFM/jsp/FMConfirmPullingListRemarks.jsp?p_remarks='+encodeURIComponent(remarks),arguments,features);
var val_chk = eval("parent.frames[1].document.forms[0].p_remarks"+iVal).value =  eval("parent.frames[1].document.forms[0].rem_recnum_"+iVal).value=retVal;


if(retVal!="")
{
		tempobj	= unescape(retVal);

		if(added_rem_rem!="" && added_rem_rem_val!="")
		{  
		patarray =added_rem_rem.split(",");
		patarray_val =added_rem_rem_val.split(",");
		}

		for(var i=0;i<=patarray.length;i++)
		{
		patfilevol=patarray[i];
		patfilevol_item=patarray_val[i];
		if (!added_rem_remarks.Exists(patfilevol) && patfilevol!=undefined)
		{	
		added_rem_remarks.add(patfilevol,patfilevol_item);
		eval('parent.frames[1].document.forms[0].rem_recnum_'+iVal).value=patfilevol_item; 
		}
		}

		if (!added_rem_remarks.Exists(pat_file_volume))
		{	
		added_rem_remarks.add(pat_file_volume,tempobj);
		eval('parent.frames[1].document.forms[0].rem_recnum_'+iVal).value=tempobj; 
		}
		if (added_rem_remarks.Exists(pat_file_volume))
		{	
		added_rem_remarks.remove(pat_file_volume);
		added_rem_remarks.add(pat_file_volume,tempobj);
		eval('parent.frames[1].document.forms[0].rem_recnum_'+iVal).value=tempobj; 		
		}

		var str=((added_rem_remarks.Items()).toArray()).toString();
		var str1=str.replace(",,",",");
		var str2=((added_rem_remarks.Keys()).toArray()).toString();
		var str3=str2.replace(",,",",");
		parent.frames[0].document.forms[0].added_rem_remarks.value=str3;
		parent.frames[0].document.forms[0].added_rem_remarks_values.value=str1;
}

else if( retVal==undefined || retVal=="undefined"||retVal=="")
{	

		tempobj	="" ;
		if(added_rem_rem!="" && added_rem_rem_val!="")
		{  
		patarray =added_rem_rem.split(",");
		patarray_val =added_rem_rem_val.split(",");
		}
		for(var i=0;i<=patarray.length;i++)
		{
		patfilevol=patarray[i];
		patfilevol_item=patarray_val[i];
		if (!added_rem_remarks.Exists(patfilevol))
		{	
		added_rem_remarks.add(patfilevol,patfilevol_item);
		eval('parent.frames[1].document.forms[0].rem_recnum_'+iVal).value=patfilevol_item; 
		}
		}

		pat_file_volume=pat_file_volume;
		if (!added_rem_remarks.Exists(pat_file_volume))
		{	
		if(tempobj!=""){
		added_rem_remarks.add(pat_file_volume,tempobj);
		}
		else
			added_rem_remarks.add(pat_file_volume,tempobj);

		eval('parent.frames[1].document.forms[0].rem_recnum_'+iVal).value=""; 
		}
		if (added_rem_remarks.Exists(pat_file_volume))
		{	

		added_rem_remarks.remove(pat_file_volume);
		added_rem_remarks.add(pat_file_volume,tempobj);
		
		eval('parent.frames[1].document.forms[0].rem_recnum_'+iVal).value=""; 
		}
		parent.frames[0].document.forms[0].added_rem_remarks.value=((added_rem_remarks.Keys()).toArray()).toString();
		parent.frames[0].document.forms[0].added_rem_remarks_values.value=((added_rem_remarks.Items()).toArray()).toString();

		added_rem_remarks.RemoveAll();

}

}			
	


//var added_file_vol = new ActiveXObject("Scripting.Dictionary");
//var added_file_vol = new CreateObject("Scripting.Dictionary");


// Initialize global variables
var added_file_vol = new Map();
var added_rem_remarks = new Map();

// Check if temp exists in added_file_vol
function addFiles_confirm() {
	
    var proceed = true;
    var flag = document.getElementById("flag").value;

    if (flag === "true") {
        added_file_vol.clear(); // clear all entries
        document.getElementById("flag").value = "";
    }

    var fields = [
        document.getElementById("fs_locn_code"),
        document.getElementById("preferred_date"),
        document.getElementById("patient_id"),
        document.getElementById("file_type_code")
    ];

    var names = [
        getLabel("Common.FileStorageLocation.label", "common"),
        getLabel("Common.BookingDate.label", "common"),
        getLabel("Common.patientId.label", "common"),
        getLabel("Common.filetype.label", "common")
    ];

    var errors = "";
    // Validate fields
    for (var i = 0; i < fields.length; i++) {
        if (fields[i] !== undefined && trimCheck(fields[i].value)) {
            fields[i].value = trimString(fields[i].value);
        } else {
            errors += getMessage("CAN_NOT_BE_BLANK", "common").replace("$", names[i]) + "<br>";
        }
    }

    if (errors.length !== 0) {
        parent.parent.frames[2].document.location.href = "../../eCommon/jsp/error.jsp?err_num=" + errors;
        proceed = false;
    }

    // Continue if no errors
    if (proceed === true) {
        if (validDateObj(document.getElementById("preferred_date"), "DMY", localeName)) {
            var fileno = document.getElementById("p_file_no").value;
            var vol = document.getElementById("volume_no").value;
            var patient_id = document.getElementById("patient_id").value;
            var status = document.getElementById("status").value;
            var confirm_yn = document.getElementById("confirm_yn").value;
            document.getElementById("status").value = confirm_yn;

            if (vol === "") vol = 1;

            if (status !== "" && status !== confirm_yn) {
                var temp1 = "('" + document.getElementById("flno").value + "'," + document.getElementById("volumeno").value + ",'" + document.getElementById("patid").value + "')";
				alert("temp1"+temp1);
                if (added_file_vol.has(temp1)) {
                    added_file_vol.delete(temp1);  // Use delete instead of Remove
                    document.getElementById("status").value = "";
                }
            }

            var temp = "('" + fileno + "'," + vol + ",'" + patient_id + "')";
            if (!added_file_vol.has(temp)) {
                added_file_vol.set(temp,temp);
            }
            var added_temp = Array.from(added_file_vol.keys()).toString();
            var HTMLVal = "<html><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMIPConfirmPullingListResults.jsp' target='FMConfirmPullingListResultFrame'>" +
                "<input name='preferred_date' id='preferred_date' type='hidden' value=" + document.getElementById('preferred_date').value + ">" +
                "<input name='fs_locn_code' id='fs_locn_code' type='hidden' value=" + document.getElementById('fs_locn_code').value + ">" +
                "<input name='added_file_vol' id='added_file_vol' type='hidden' value=\"" + added_temp + "\">" +
                "<input name='temp' id='temp' type='hidden' value=\"" + temp + "\">" +
                "</form></BODY></HTML>";
            parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
            parent.parent.frames[2].document.form1.submit();
			parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
        } else {
            var err = getMessage('INVALID_VALUE', 'common');
            err = err.replace('#', getLabel("Common.BookingDate.label", "common"));
            alert(err);
        }
    }
}

// Clear patient ID
function clearpatid() {
    parent.frames[0].document.forms[0].patient_id.value = '';
    parent.frames[0].document.getElementById("patient_id").onblur();
}

// Clear all values
function ClearAllval() {
    parent.frames[1].location.href = '../../eCommon/html/blank.html';
    added_file_vol.clear();
    added_rem_remarks.clear();
    parent.frames[0].document.forms[0].added_rem_remarks.value = "";
    parent.frames[0].document.forms[0].added_rem_remarks_values.value = "";
}


function chkdate(obj)
{
	if(obj.value=='')
	{
		var error = getMessage('CAN_NOT_BE_BLANK','common');
		error = error.replace('$',getLabel("Common.BookingDate.label","common"));
		parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num="+error;
		//obj.focus();
	}
	else
	{
		parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num=";
	}

}


function doOnlineReportPrinting(msg,p_fm_nursing_unit_code,p_to_nursing_unit_code,p_fm_pract_id,p_to_pract_id,p_gender,p_preferred_date,p_pull_list_no,fs_locn_code,appl_user_id,print_pulled_list,print_tracer_card)
	{

	 var flag="Confirm IP Pulling List";
	  
	  
	   parent.parent.frames[2].location.href="../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=1";
	 	   
	   HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' 	action='../eFM/jsp/FMIPGeneratePullListConfirm.jsp'><input name='p_fm_nursing_unit_code' id='p_fm_nursing_unit_code' type='hidden' value='"+p_fm_nursing_unit_code+"'><input name='p_to_nursing_unit_code' id='p_to_nursing_unit_code' type='hidden' value='"+p_to_nursing_unit_code+"'><input name='p_fm_pract_id' id='p_fm_pract_id' type='hidden' value='"+p_fm_pract_id+"'><input name='p_to_pract_id' id='p_to_pract_id' type='hidden' value='"+p_to_pract_id+"'><input name='p_gender' id='p_gender' type='hidden' value='"+p_gender+"'><input name='p_preferred_date' id='p_preferred_date' type='hidden' value='"+p_preferred_date+"'><input name='p_pull_list_no' id='p_pull_list_no' type='hidden' value='"+p_pull_list_no+"'><input name='fs_locn_code' id='fs_locn_code' type='hidden' value='"+fs_locn_code+"'><input name='appl_user_id' id='appl_user_id' type='hidden' value='"+appl_user_id+"'><input name='print_pulled_list' id='print_pulled_list' type='hidden' value='"+print_pulled_list+"'><input name='print_tracer_card' id='print_tracer_card' type='hidden' value='"+print_tracer_card+"'><input name='flag' id='flag' type='hidden' value='"+flag+"'></form></BODY></HTML>";
		parent.parent.frames[3].document.write(HTMLVal);
		parent.parent.frames[3].document.form1.submit();
       
  } 

