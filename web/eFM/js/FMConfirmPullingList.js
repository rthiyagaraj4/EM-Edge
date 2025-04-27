function apply()
{
	if(parent.frames[2].frames[1].frames[1].document.forms[0])
	{
	var p_total_records = parent.frames[2].frames[1].frames[1].document.forms[0].p_counter.value;
	
	var p_pull_type = parent.frames[2].frames[1].frames[1].document.forms[0].confirm_yn.value;
	var p_req_select      = "";
	var p_rec_count       = 0;
	var proceed;	
	for(i = 1;i < p_total_records;i++) 
	{
		p_req_select = eval("parent.frames[2].frames[1].frames[1].document.forms[0].pull_yn"+i+".checked");
		if(p_req_select == true) 
			p_rec_count++;
	}
	if(p_rec_count == 0 && p_pull_type=="N")
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
			if(val_chk)
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
		var fields = new Array (parent.frames[2].frames[1].frames[0].document.forms[0].fs_locn_code,
								 parent.frames[2].frames[1].frames[0].document.forms[0].appt_date );

/*	var fields = new Array (parent.frames[2].frames[1].frames[0].document.forms[0].fs_locn_code,
								 parent.frames[2].frames[1].frames[0].document.forms[0].appt_date,
								 parent.frames[2].frames[1].frames[0].document.forms[0].p_location_type1,
								 parent.frames[2].frames[1].frames[0].document.forms[0].fm_clinic_desc
							   );*/
	//	var names = new Array (getLabel("Common.FileStorageLocation.label","common"), getLabel("Common.apptdate.label","common"), getLabel("Common.locationtype.label","common"), getLabel("Common.Location.label","common"));	
		var names = new Array (getLabel("Common.FileStorageLocation.label","common"), getLabel("Common.apptdate.label","common"));	
		var errors = "";
		for(var i=0; i<fields.length; i++) 
		{
			if(trimCheck(fields[i].value)) 
			{
				fields[i].value = trimString(fields[i].value);
			}
			else
			{
				//errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
				errors=getMessage("CAN_NOT_BE_BLANK","common")+ "<br>" ;
				errors=errors.replace('$',names[i]);
			}

		}
		if(errors.length != 0) 
		{
			parent.frames[1].frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			to_proceed = false;
			return false ;
		}
		if(to_proceed==true)
		{			
	parent.frames[2].frames[1].frames[1].document.forms[0].action='../../servlet/eFM.FMConfirmPullingListServlet'
	parent.frames[2].frames[1].frames[1].document.forms[0].target="messageFrame";
	parent.frames[2].frames[1].frames[1].document.forms[0].submit();
	}
	}
	else 
	{ 
		var	messag = getMessage("NO_FILE_FOR_CON_PULL","FM");
	    messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+messag ;
	//	parent.frames[1].frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+messag ;
	
	}
	
	}else{

	 var	messag = getMessage("NO_FILE_FOR_CON_PULL","FM");
	 messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+messag ;
     	return false;
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
	if(obj.value !="")
	{
	if(obj1_value != "")
	{
		if(validDateObj(obj,"DMY",localeName))
		{
			document.forms[0].CBValStr.value="";
			var appt_date=document.forms[0].appt_date.value;
			if(appt_date !="")
			appt_date=convertDate(appt_date,"DMY",localeName,"en");
			if(appt_date !="")
			{				
			   if (obj3.value!="")
			   {
				var fields = new Array ( document.forms[0].fm_pract_id,document.forms[0].to_pract_id);
				var namesele1= getLabel("Common.from.label","common")+ " "+ getLabel("Common.practitionerid.label","common");
				var namesele2=getLabel("Common.to.label","common")+" " + getLabel("Common.practitionerid.label","common");
				var names = new Array ( namesele1,namesele2);
				var error_jsp="../../eCommon/jsp/error.jsp";
				if (SpecialCharCheck( fields, names, parent.parent.frames[2],'M',error_jsp)){
					
					/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 24th 2014 Start*/
					var start_time	= document.forms[0].start_time.value;
					var end_time	= document.forms[0].end_time.value;
					if(start_time!="" || end_time!=""){
						if(start_time=="" || end_time==""){
							var error	=  getMessage('START_END_TIME_CANNOT_BE_BLANK','FM');
							parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+error+"&err_value=0";
							parent.frames[1].location.href='../../eCommon/html/blank.html';
							return false;
						}
					}
					/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 24th 2014 End*/	
					
					document.forms[0].fs_locn_code.disabled=true;
					document.forms[0].appt_date.disabled=true;
					document.forms[0].p_gender.disabled=true;
					document.forms[0].fm_clinic_code.disabled=true;
					document.forms[0].fm_pract_id.disabled=true;				
					document.forms[0].confirm_yn.disabled=true;
					document.forms[0].pull_type.disabled=true;
					document.forms[0].pract_id.disabled=true;				
					document.forms[0].subBotton.disabled=true;
	
					//start_time and end_time passed for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014
						
					HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMConfirmPullingListResults.jsp' target='FMConfirmPullingListResultFrame'><input name='appt_date' id='appt_date' type='hidden' value="+appt_date+"><input name='fs_locn_code' id='fs_locn_code' type='hidden' value="+obj1.value+"><input name='gender' id='gender' type='hidden' value="+obj2.value+"><input name='fm_clinic_code' id='fm_clinic_code' type='hidden' value="+obj3.value+"><input name='fm_pract_id' id='fm_pract_id' type='hidden' value="+obj5.value+"><input name='to_pract_id' id='to_pract_id' type='hidden' value="+obj6.value+"><input name='confirm_yn' id='confirm_yn' type='hidden' value="+obj7.value+"><input name='appl_user_id' id='appl_user_id' type='hidden' value="+obj8.value+"><input name='pull_type' id='pull_type' type='hidden' value="+obj9.value+"><input name='start_time' id='start_time' type='hidden' value="+start_time+"><input name='end_time' id='end_time' type='hidden' value="+end_time+"><input name='flagSelect' id='flagSelect' type='hidden' value='fromSelect'></form></BODY></HTML>";
	
					parent.parent.frames[2].document.write(HTMLVal);
					parent.parent.frames[2].document.form1.submit();
					//parent.frames[1].location.href='../../eFM/jsp/FMConfirmPullingListResults.jsp?appt_date='+appt_date+'&fs_locn_code='+obj1.value+'&gender='+obj2.value+'&fm_clinic_code='+obj3.value+'&fm_pract_id='+obj5.value+'&to_pract_id='+obj6.value+'&confirm_yn='+obj7.value+'&appl_user_id='+obj8.value+'&pull_type='+obj9.value+'&flagSelect=fromSelect';
					parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
				}
			 }
			 else
			 {
				var error = "";
				if(document.forms[0].p_location_type1.value==''){				
					error=getMessage("CAN_NOT_BE_BLANK","common")+ "<br>" ;
					error=error.replace('$',getLabel("Common.locationtype.label","common"));}

				error=error + getMessage("CAN_NOT_BE_BLANK","common");
				error=error.replace('$',getLabel("Common.Location.label","common"));
				parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+error+"&err_value=0";
				parent.frames[1].location.href='../../eCommon/html/blank.html';
			  }
			}
			else
			{
				var msg=getMessage("APPT_DATE_CANNOT_BLANK","FM");
				parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
				parent.frames[1].location.href='../../eCommon/html/blank.html';
			}
		}
	}
	else
	{
		var msg=getMessage("FILE_STORAGE_NOT_BLANK","FM");
		parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
		parent.frames[1].location.href='../../eCommon/html/blank.html';
	}
	}
	else
	{
		var msg=getMessage("APPT_DATE_CANNOT_BLANK","FM");
		parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		obj.focus();	
		parent.frames[1].location.href='../../eCommon/html/blank.html';
		return false;
        
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
	parent.frames[2].frames[1].frames[2].location.href='../../eFM/jsp/FMConfirmPullingListColor.jsp';
	parent.frames[2].frames[1].location.reload();
	
}

function PrintReport()
{
		var to_proceed=true;

		var fields = new Array ( parent.frames[0].document.forms[0].fs_locn_code,parent.frames[0].document.forms[0].appt_date);
		var names = new Array ( getLabel("Common.FileStorageLocation.label","common") , getLabel("Common.apptdate.label","common"));	

		var errors = "";

		for( var i=0; i<fields.length; i++ ) 
		{
			if(trimCheck(fields[i].value)) {
				fields[i].value = trimString(fields[i].value);
			}
			else	{
				errors=getMessage("CAN_NOT_BE_BLANK","common")+ "<br>" ;
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
	parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].frames[2].location.href='../../eFM/jsp/FMConfirmPullingListColor.jsp';
	parent.frames[2].frames[1].location.reload();
}
async function search(target,fac_id,target_name)
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
		retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst="+dispDescFirst,arguments,features);

			if (retVal!=null){
			if (!(unescape(retVal) == null))
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



function call_common(sql,objName)
{
		var tit				= getLabel("Common.resource.label","common");
		var retVal			= new String();
		var argumentArray	= new Array() ;
		var dataNameArray	= new Array() ;
		var dataValueArray	= new Array() ;
		var dataTypeArray	= new Array() ;
		var yyy;
		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
	
		if(objName=="pract_id")
		{     
			argumentArray[5] = document.forms[0].fm_pract_id.value;
		}
		else 
		{
			argumentArray[5] = document.forms[0].to_pract_id.value;
		}
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;
		
		retVal = CommonLookup(tit,argumentArray );
		
		if(retVal != null && retVal != "" )	
		{
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			
			if(objName=="pract_id")
			{
				document.forms[0].fm_pract_id.value=arr[0];
			}
			else
			{
				document.forms[0].to_pract_id.value=arr[0];
			}
		}
		else
		{
			if(objName=="pract_id")
			{
				document.forms[0].fm_pract_id.focus();
				document.forms[0].fm_pract_id.value="";
			}
			else	
			{
				document.forms[0].to_pract_id.focus();
				document.forms[0].to_pract_id.value="";
			}
		}
}
async function onblurcheck(obj,target)
{
		if(target.value == "")
		{
			if(obj.name=="fm_pract_id")
			{
				document.forms[0].fm_pract_id.value ="";
				return;
			}
			if(obj.name=="to_pract_id")
			{
				document.forms[0].to_pract_id.value="";
				return;
			}
		}
		await callPractSearch(obj,target)
}



/*function searchCode(obj,target,obj1)
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
		var facilityid = document.forms[0].facility_id.value;
		var p_location_type1=document.forms[0].p_location_type1.value;
			
		var facility=obj1.value;
		if(obj.name=="locn")
		{
			tit=getLabel("Common.Location.label","common");
			if(p_location_type1!='')
			{
				sql="select clinic_code, long_desc from op_clinic_lang_vw where facility_id=`"+facilityid+"` and language_id=`"+localeName+"` and level_of_care_ind = `A` and CARE_LOCN_TYPE_IND=`"+p_location_type1+"` ";
				search_code="clinic_code";
				search_desc= "long_desc";
			}
			else
			{
				sql="select clinic_code, long_desc from op_clinic_lang_vw where facility_id=`"+facilityid+"` and language_id=`"+localeName+"`  and level_of_care_ind = `A`";
				search_code="clinic_code";
				search_desc= "long_desc";
			}
		}				
		
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst=dispDescFirst",arguments,features);

		var arr=new Array();

		if (!(retVal == null)) {
			var retVal=unescape(retVal);
		    arr=retVal.split("::");
			document.forms[0].fm_clinic_desc.value=arr[0];
			document.forms[0].fm_clinic_code.value=arr[1];
		}
		else
		{
			document.forms[0].fm_clinic_desc.value="";
			document.forms[0].fm_clinic_code.value="";
		}
}*/

async function searchCode(obj,target,obj1)
{      
		var retVal = 	new String();
		var dialogHeight= "28" ;
		var dialogWidth	= "43" ;
		var status = "no";
		var arguments	= "" ;
		var sql="";
		var search_code="";
		var search_desc="";
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var tit="";
		var facilityid = document.forms[0].facility_id.value;
		var p_location_type1=document.forms[0].p_location_type1.value;
			
		var facility=obj1.value;
/*Added eff_status='E' in below Query by Senthil on 14-Oct-2011 [IN029281]*/
		if(obj.name=="locn")
		{
			tit=getLabel("Common.Location.label","common");
			if(p_location_type1!='')
			{   
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facilityid+"' and language_id='"+localeName+"' and level_of_care_ind = 'A' and eff_status='E' and CARE_LOCN_TYPE_IND='"+p_location_type1+"' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?)";
							
				search_code="clinic_code";
				search_desc= "long_desc";
			}
			else
			{   
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facilityid+"' and language_id='"+localeName+"'  and level_of_care_ind = 'A' and eff_status='E' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?)";
				search_code="clinic_code";
				search_desc= "long_desc";
			}
		}				
		
		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].fm_clinic_desc.value;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;

		retVal = await CommonLookup( tit, argumentArray );

		var arr=new Array();

		if(retVal != null && retVal != "" ) {	
			var retVal=unescape(retVal);
		    arr=retVal.split(",");
			document.forms[0].fm_clinic_desc.value=arr[1];
			document.forms[0].fm_clinic_code.value=arr[0];
		}
		else
		{
			document.forms[0].fm_clinic_desc.value="";
			document.forms[0].fm_clinic_code.value="";
		//	target.value='';
		}
}


function PractLookupRetVal(retVal,objName)
{
		var arr;
		if(!(retVal == null))
		{
			arr=retVal.split("~");
			if(objName=="fm_pract_id")
			{				
				document.forms[0].fm_pract_id.value=arr[0];
				
			}
			else
			{
				document.forms[0].to_pract_id.value=arr[0];
			}
		}
		else
		{
			if(objName=="fm_pract_id")
			{
				document.forms[0].fm_pract_id.focus();
				document.forms[0].fm_pract_id.value="";
			}
			else	
			{
				document.forms[0].to_pract_id.focus();
				document.forms[0].to_pract_id.value="";
			}
		}
}
function EnableDisableCheckbox(obj)
{
		if (obj.checked==true)
		{
			obj.value = 'Y';
		}
		else
		{
			obj.value = 'N';
		}
}

function changeUpperCase(obj)
{
		obj.value = obj.value.toUpperCase();
}

function SelectAll(from,to)
{
	var confirm_yn			=document.forms[0].confirm_yn.value;
	var appt_date			=document.forms[0].appt_date.value;
	var p_fm_clinic_code	=document.forms[0].fm_clinic_code.value;
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
	xmlStr ="<root><SEARCH check='"+check+"' appt_date='"+appt_date+"' p_fm_clinic_code='"+p_fm_clinic_code+"' p_fm_pract_id='"+p_fm_pract_id+"' p_to_pract_id='"+p_to_pract_id+"' p_gender='"+p_gender+"' pull_type='"+pull_type+"' p_fs_locn_code='"+p_fs_locn_code+"' confirm_yn='"+confirm_yn+"'/></root>";
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
			/*var added_patfile_vol = new ActiveXObject("Scripting.Dictionary");
			var added_rem_remarks= new ActiveXObject("Scripting.Dictionary");*/

		// Replacing ActiveXObject with a plain JavaScript object
		var added_patfile_vol = new Map();
		var added_rem_remarks = new Map();

		// Example of adding values to the object
		added_patfile_vol.set('key1','value1');
		added_rem_remarks.set('key2','value2');
		async function GetRemarks(iVal,remarks)
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

			//var p_file_no=eval("document.getElementById("p_file_no")"+iVal).value;
			//var vol_no=eval("document.getElementById("p_volume_no")"+iVal).value;
			//var pat_id=eval("document.getElementById("p_patient_id")"+iVal).value;
			/*var p_file_no=eval("document.getElementById('p_file_no' + " + iVal + ").value");
			var vol_no=eval("document.getElementById('p_volume_no' + "+iVal+ ").value");
			var pat_id=eval("document.getElementById('p_patient_id'+ "+iVal+ ").value");*/
			var p_file_no = document.getElementById('p_file_no' + iVal).value;
			var vol_no = document.getElementById('p_volume_no' + iVal).value;
			var pat_id = document.getElementById('p_patient_id' + iVal).value;


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
			if (!added_rem_remarks.has(patfilevol) && patfilevol!=undefined)
			{	

			added_rem_remarks.set(patfilevol,patfilevol_item);
			}
			}

			if (added_rem_remarks.has(pat_file_volume))
			{
				
			tempobj=added_rem_remarks.get(pat_file_volume);
			if(tempobj==undefined || tempobj==null) tempobj="";
			remarks=tempobj;
			}
			else
			remarks=eval("parent.frames[1].document.forms[0].p_remarks"+iVal).value;



		
			retVal =await window.showModalDialog('../../eFM/jsp/FMConfirmPullingListRemarks.jsp?p_remarks='+encodeURIComponent(remarks),arguments,features);

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
		if (!added_rem_remarks.has(patfilevol) && patfilevol!=undefined)
		{	
		added_rem_remarks.set(patfilevol,patfilevol_item);
		eval('parent.frames[1].document.forms[0].rem_recnum_'+iVal).value=patfilevol_item; 
		}
		}

		if (!added_rem_remarks.has(pat_file_volume))
		{	
		added_rem_remarks.set(pat_file_volume,tempobj);
		eval('parent.frames[1].document.forms[0].rem_recnum_'+iVal).value=tempobj; 
		}
		if (added_rem_remarks.has(pat_file_volume))
		{	
		added_rem_remarks.delete(pat_file_volume);
		added_rem_remarks.set(pat_file_volume,tempobj);
		eval('parent.frames[1].document.forms[0].rem_recnum_'+iVal).value=tempobj; 		
		}

		var str=((Array.from(added_rem_remarks.values())).toString());
		var str1=str.replace(",,",",");
		var str2=((Array.from(added_rem_remarks.keys())).toString());
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
		if (!added_rem_remarks.has(patfilevol))
		{	
		added_rem_remarks.set(patfilevol,patfilevol_item);
		eval('parent.frames[1].document.forms[0].rem_recnum_'+iVal).value=patfilevol_item; 
		}
		}

		pat_file_volume=pat_file_volume;
		if (!added_rem_remarks.has(pat_file_volume))
		{	
		if(tempobj!=""){
		added_rem_remarks.set(pat_file_volume,tempobj);
		}
		else
			added_rem_remarks.set(pat_file_volume,tempobj);

		eval('parent.frames[1].document.forms[0].rem_recnum_'+iVal).value=""; 
		}
		if (added_rem_remarks.has(pat_file_volume))
		{	

		added_rem_remarks.delete(pat_file_volume);
		added_rem_remarks.set(pat_file_volume,tempobj);
		
		eval('parent.frames[1].document.forms[0].rem_recnum_'+iVal).value=""; 
		}
		parent.frames[0].document.forms[0].added_rem_remarks.value=((Array.from(added_rem_remarks.keys())).toString());
		parent.frames[0].document.forms[0].added_rem_remarks_values.value=((Array.from(added_rem_remarks.values())).toString());

		added_rem_remarks.clear();

}

	
		}

function checkMaxLimit(obj,maxSize)	
{
		if ( obj.value.length >= maxSize )
		{
			event.returnValue = false;
		}
}

function closeWin()
{
	if(document.getElementById("comments").value.length > 0)
	window.returnValue = document.getElementById("comments").value;
	else
	window.returnValue ='';
	window.close();
}

function doClose()	
{
	window.returnValue = document.getElementById("comments").value;
	window.close();
}

function ClearAllval()
{
parent.frames[1].location.href='../../eCommon/html/blank.html';
added_file_vol.clear();
added_rem_remarks.clear();
parent.frames[0].document.forms[0].added_rem_remarks.value="";
parent.frames[0].document.forms[0].added_rem_remarks_values.value="";
}

/*function display_mangimages()
{
	if(parent.frames[0].document.getElementById("p_patient_id").value != "")
	{
	parent.frames[0].document.getElementById("loc_type").style.visibility='hidden';
	parent.frames[0].document.getElementById("location1").style.visibility='hidden';
	}
	else
	{
	parent.frames[0].document.getElementById("loc_type").style.visibility='visible';
	parent.frames[0].document.getElementById("location1").style.visibility='visible';
	}
}*/

//var added_file_vol = new ActiveXObject("Scripting.Dictionary");
// Replacing ActiveXObject with a plain JavaScript object
var added_file_vol =  new Map();
// Example of adding values to the object
added_file_vol.set('key1','value1');
		
function addFiles_confirm()
{
	var porceed=true;
	var flag=document.getElementById("flag").value;	
	
	/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 24th 2014 Start*/
	var start_time		= document.forms[0].start_time.value;
	var end_time		= document.forms[0].end_time.value;
	/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 24th 2014 End*/

	if(flag=="true")
	{
    added_file_vol.clear();
	document.getElementById("flag").value="";
	}
	
	var fields = new Array ( document.getElementById("fs_locn_code"),
				 document.getElementById("appt_date"),
				 document.getElementById("patient_id"),document.getElementById("file_type")
			       );	
			       
	var names = new Array ( getLabel('Common.FileStorageLocation.label','common'), getLabel('Common.apptdate.label','common'),getLabel('Common.patientId.label','common'),getLabel('Common.filetype.label','common'));

	var errors = "";
	
	for( var i=0; i<fields.length; i++ )
	{
		
		if(fields[i]!=undefined)
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else	
		{
		errors=errors + getMessage("CAN_NOT_BE_BLANK","common");
		errors=errors.replace("$",names[i]);
		errors=errors+"<br>";
		
		}//errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
		
	}
	/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 24th 2014 Start*/
	if(start_time!="" || end_time!=""){
		if(start_time=="" || end_time==""){
			errors	+=  getMessage('START_END_TIME_CANNOT_BE_BLANK','FM');;
		}
	}
	/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 24th 2014 End*/

	if ( errors.length != 0 )
	{
		parent.parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		porceed=false;
	}
	
if(porceed == true)
{
	if(validDateObj(document.getElementById("appt_date"),"DMY",localeName))
	{
		var fileno=document.getElementById("p_file_no").value;
		var vol=document.getElementById("volume_no").value;
		var fs_locn_code=document.getElementById("fs_locn_code").value;
		var patient_id =document.getElementById("patient_id").value;
		var status =document.getElementById("status").value;
		var  confirm_yn=document.getElementById("confirm_yn").value;
	//alert("confirm_yn-->"+confirm_yn);
	
		document.getElementById("status").value=confirm_yn;
		
		document.getElementById("flno").value=fileno;
		document.getElementById("volumeno").value=vol;
		document.getElementById("patid").value=patient_id;
		
		if(vol =="")
			vol=1;
		
	if(status!="" && status!=confirm_yn){
	  var temp1="('"+document.getElementById("flno").value+"',"+document.getElementById("volumeno").value+",'"+document.getElementById("patid").value+"')";	
          if (added_file_vol.has(temp1)) { 
            added_file_vol.delete(temp1);
		    document.getElementById("status").value="";
		 }
	  }
			
		document.getElementById("flno").value=fileno;
		document.getElementById("volumeno").value=vol;
		document.getElementById("patid").value=patient_id;
		
		var temp="('"+fileno+"',"+vol+",'"+patient_id+"')";	
	  
		if (!added_file_vol.has(temp))
			added_file_vol.set(temp, temp);			
		
		var added_temp=((Array.from(added_file_vol.keys())).toString());
		var appt_date=document.getElementById("appt_date").value;
//alert("pulling_type-->"+document.getElementById("pull_type").value);
		if(appt_date !="")
		appt_date=convertDate(appt_date,"DMY",localeName,"en");
//New parameter 'temp' added for SRR20056-SCF-7380.1 [IN:028088] by Venkatesh S on 09.08.2011
		
		/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 Start*/
		var start_time	= document.getElementById("start_time").value;
		var end_time	= document.getElementById("end_time").value;
		/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 End*/
		//start_time and end_time passed for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014
		HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eFM/jsp/FMConfirmPullingListResults.jsp' target='FMConfirmPullingListResultFrame'><input name='appt_date' id='appt_date' type='hidden' value="+appt_date+"><input name='fs_locn_code' id='fs_locn_code' type='hidden' value="+document.getElementById("fs_locn_code").value+"><input name='gender' id='gender' type='hidden' value="+document.getElementById("p_gender").value+"><input name='fm_clinic_code' id='fm_clinic_code' type='hidden' value="+document.getElementById("fm_clinic_code").value+"><input name='fm_pract_id' id='fm_pract_id' type='hidden' value="+document.getElementById("fm_pract_id").value+"><input name='to_pract_id' id='to_pract_id' type='hidden' value="+document.getElementById("to_pract_id").value+"><input name='confirm_yn' id='confirm_yn' type='hidden' value="+document.getElementById("confirm_yn").value+"><input name='appl_user_id' id='appl_user_id' type='hidden' value="+document.getElementById("appl_user_id").value+"><input name='pull_type' id='pull_type' type='hidden' value="+document.getElementById("pull_type").value+"><input name='flagSelect' id='flagSelect' type='hidden' value='fromSelect'><input name='added_file_vol' id='added_file_vol' type='hidden' value=\""+added_temp+"\"><input name='temp' id='temp' type='hidden' value=\""+temp+"\"><input name='patient_id' id='patient_id' type='hidden' value=\""+patient_id+"\"><input name='filenum' id='filenum' type='hidden' value=\""+fileno+"\"><input name='volume_no' id='volume_no' type='hidden' value=\""+vol+"\"><input name='start_time' id='start_time' type='hidden' value=\""+start_time+"\"><input name='end_time' id='end_time' type='hidden' value=\""+end_time+"\"></form></BODY></HTML>";
		parent.parent.frames[2].document.write(HTMLVal);
		parent.parent.frames[2].document.form1.submit();
		//alert(((added_file_vol.Keys()).toArray()).toString());
		parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
	}
	else
	{
		var err=getMessage('INVALID_VALUE','common');
		err = err.replace('#',getLabel("Common.apptdate.label","common"));
		alert(err);
	}
}
}



function valChkDate(obj)
{
	if(obj.value !="")
	{
		parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num=';

	}
	else
	{
		var msg=getMessage("APPT_DATE_CANNOT_BLANK","FM");
		parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		//obj.focus();		    
		return false;
	}
}

function clearcliniccode(obj)
{
	if(obj.value=='')
		document.forms[0].fm_clinic_code.value='';
}

