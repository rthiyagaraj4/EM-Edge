/*** Created on 19 August 2009 -- Shyampriya ****/

/****** Function to open location type lookup dialog *******/

function showLocationTypeLookup(call_mode, target)
{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var frmObj=document.formLeaveDtlsReport;
	var locationType = frmObj.txt_locn_type1.value;
	var locale = frmObj.locale.value;
	
	if((call_mode =='T')&&(locationType ==''))
		{
			frmObj.txt_locn_type.value='';
			return false;
		}

	if(frmObj.txt_locn_type.value !='')
		{
			frmObj.txt_locn_type.value='';
			frmObj.txt_locn_type1.value='';
		}
	
	var sql_locn_type_lookup = "Select locn_type code, short_desc description from am_care_locn_type  where  upper(locn_type) like(upper(?))  and upper(short_desc) like(upper(?))";
	argumentArray[0] = sql_locn_type_lookup;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC
	
	retVal = CommonLookup(getLabel("Common.locationtype.label","Common"),argumentArray);
	if(retVal != null && retVal != "" )
		{
			frmObj.txt_locn_type.value = retVal[0];
			frmObj.txt_locn_type1.value = retVal[1];
			target.value = retVal[1];
			clearWorkPlace();
		}
}

/****** Function to open Workplace lookup dialog *******/

function showWorkplaceLookup(call_mode, target)
{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var frmObj=document.formLeaveDtlsReport;
	var workplace = frmObj.txt_work_place1.value;
	var locale = frmObj.locale.value;
	
	if((call_mode =='T')&&(workplace ==''))
		{
			frmObj.txt_work_place.value='';
			return false;
		}

	var locn_type = frmObj.txt_locn_type.value;
	if(frmObj.txt_work_place.value !='')
		{
			frmObj.txt_work_place.value='';
			frmObj.txt_work_place1.value='';
		}

	var sql_workplace_lookup = "select workplace_code code,workplace_desc description from rs_workplace_lang_vw where ('"+locn_type+"' is null or locn_type='"+locn_type+"') and eff_status='E' and upper(workplace_code) like(upper(?))  and upper(workplace_desc) like(upper(?)) and language_id = '"+locale+"'";
	argumentArray[0] = sql_workplace_lookup;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC

	retVal = CommonLookup(getLabel("eRS.FindWorkplace.label","RS"),argumentArray);
	if(retVal != null && retVal != "" )
	{
		frmObj.txt_work_place.value = retVal[0];
		frmObj.txt_work_place1.value = retVal[1];
		target.value = retVal[1];
	}else
	{
		//
	}
}

/****** Function to populate Staff Type listbox *******/

function populateStaffType1()
{
	clearStaffType();
	var frmObj=document.formLeaveDtlsReport;
	var role_type=frmObj.slt_role_type[frmObj.slt_role_type.selectedIndex].value;
		
		if(!role_type=="")
			{
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest() ;

				xmlStr ="<root><SEARCH " ;
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST", "../../eRS/jsp/LeaveDtlsRepValidate.jsp?role_type="+role_type+"&func_mode=Staff", false ) ;
				xmlHttp.send( xmlDoc ) ;
				responseText=xmlHttp.responseText ;
				eval(responseText);
				clearPositionStaff();
			}

}

/****** Function to clear Staff Type listbox before re-populating it *******/

function clearStaffType( ) 
{	
	var len = eval("document.forms[0].slt_staff_type.options.length") ;	
	for(var i=0;i<len;i++)	
		{
			eval("document.forms[0].slt_staff_type.remove(\"atc_class_l2_code\")") ;
		}

	var code="";
	var value="  ---Select---  ";
	addStaffType(code,value);

}

/****** Function to open Position lookup dialog *******/

function viewPosition(call_mode, target)
{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var frmObj=document.formLeaveDtlsReport;
	var locale=frmObj.locale.value;
	
	if((call_mode == 'T')&&(frmObj.txt_position.value==""))
		{
			frmObj.p_position_code.value='';
			return false;
		}

	if(!(frmObj.p_position_code.value==""))
		{
			frmObj.p_position_code.value='';
			frmObj.txt_position.value='';
		}
	var role_type = frmObj.slt_role_type[frmObj.slt_role_type.selectedIndex].value;
	var staff_type = frmObj.slt_staff_type[frmObj.slt_staff_type.selectedIndex].value;
	
		msg='';
		dataNameArray[0]="role_type";
		dataNameArray[1]="staff_type";
			
		dataValueArray[0]=role_type;
		dataValueArray[1]=staff_type;
		
		dataTypeArray[0]="String";
		dataTypeArray[1]="String";
		
		argumentArray[0] = "select position_code code ,position_desc description from am_position_lang_vw where eff_status = 'E'  and upper(role_type) like upper(?) and upper(staff_type) like upper(?) and upper(position_code) like upper(?) and upper(position_desc) like upper(?) and  language_id ='"+locale+"' order by position_desc";

		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "3,4";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal = CommonLookup(getLabel("eRS.Positions.label","RS"),argumentArray );
		if(retVal != null && retVal != "") 
			{
				target.value = retVal[1] ;
				frmObj.p_position_code.value = retVal[0];
				frmObj.txt_staff1.value = "";
				frmObj.txt_staff.value = "";
			}
}

/****** Function to open Staff lookup dialog *******/

function showStaff(target)
{
	var frmObj=document.formLeaveDtlsReport;
	var role_type=frmObj.slt_role_type[frmObj.slt_role_type.selectedIndex].value;
	var staff_type=frmObj.slt_staff_type[frmObj.slt_staff_type.selectedIndex].value;
	var position_code = frmObj.p_position_code.value;
	var position_name = frmObj.txt_position.value;
	
		var mode		= "call";
		var url = "../../eRS/jsp/SearchStaff.jsp?p_role_type="+role_type+"&p_staff_type="+staff_type+"&p_position_code="+position_code+"&p_position_desc="+position_name+"&mode="+mode;
	//		var url = "../../eRS/jsp/SearchStaff.jsp?p_role_type="+role_type+"&p_staff_type="+staff_type+"&mode="+mode;

		var dialogHeight =window.screen.height ;
		var dialogWidth = window.screen.width ;
		var dialogTop	= 0;
		var dialogLeft = 0 ;

	    var arguments   = "" ;
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:"+dialogTop+";dialogLeft:"+dialogLeft+"; scroll=no; status=no;";
	    var retVal   = window.showModalDialog( url, arguments, features ) ;
	
		if(retVal != null ) 
			{
				if(role_type != retVal[2])
					{
						var index;
						var len=frmObj.slt_role_type.length;
						for(i=0;i<len;i++)
							{
								if(frmObj.slt_role_type.options[i].value==retVal[2])
									{
										frmObj.slt_role_type.selectedIndex=i;
										break;
									}
							}
					}
		
				if(staff_type != retVal[3])
					{
						populateStaffType1();
						var index;
						var len=frmObj.slt_staff_type.length;
						for(i=0;i<len;i++)
							{
								if(frmObj.slt_staff_type.options[i].value==retVal[3])
									{
										frmObj.slt_staff_type.selectedIndex=i;
										break;
									}
							}
					}
	
				if(position_code!=retVal[4])
					{
						populatePosition(retVal[4]);
					}
				target.value=retVal[1];
				frmObj.txt_staff.value=retVal[0];
			}
}

/****** Called from validate.jsp to dynamically populate the staff type list box *******/

function addStaffType(code,value) 
{
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.forms[0].slt_staff_type.add(element);
}

/****** Run method *******/

function run() 
	{
		var frmObject = searchFrame.document.formLeaveDtlsReport;
	
		if(frmObject) 
			{
				var fields= new Array (frmObject.txt_from_date, frmObject.txt_to_date);
				var names= new Array (getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
		
				if(checkFields(fields,names,messageFrame)) 
					{
						if(checkDate())
							{
								frmObject.submit();
							}
					}
			}
	}

/************** Date functions starts here ***************/

function validDateFormat(obj, locale)
	{
		if(obj.value)
			{
				if(!validDate(obj.value, 'DMY',locale))
					{
						alert(getMessage("INVALID_DATE_TIME", "PH"));
						obj.select();
						obj.focus();
						return false;
					}
			}
	}

function AllowDateFormat()
	{
	   var key = window.event.keyCode;
		if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 47)) ) 
			{  // numbers or slash
				return false;
			}
	}

function checkDate()
	{
	
		var frmObject = searchFrame.document.formLeaveDtlsReport;
		var p_language_id=frmObject.p_language_id.value;
		var fromDate=convertDate(frmObject.txt_from_date.value,'DMY',p_language_id,"en");
		var toDate =convertDate(frmObject.txt_to_date.value,'DMY',p_language_id,"en");
		var message;
	
    	if(!doDateCheck(fromDate,toDate,messageFrame))
			{
				message=getMessage("TO_DT_GR_EQ_FM_DT","PH");
				messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
				frmObject.txt_to_date.select();
				frmObject.txt_to_date.focus();
				return false;
			}
		
         frmObject.p_date_from.value = fromDate;
         frmObject.p_date_to.value  = toDate;
		 messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
		 return true;
	}
/************** Date functions end here ***************/

/****** Function to clear the workplace textbox *******/

function clearWorkPlace()
	{
		var frmObj = document.formLeaveDtlsReport;
		frmObj.txt_work_place1.value = "";
		frmObj.txt_work_place.value = "";
	}

/****** Function to clear the Position and Staff textboxes *******/

function clearPositionStaff()
	{
		var frmObj = document.formLeaveDtlsReport;
		frmObj.txt_position.value = "";
		frmObj.p_position_code.value = "";
		frmObj.txt_staff1.value = "";
		frmObj.txt_staff.value = "";
	}

/****** Reset method *******/

function reset()
	{
		searchFrame.document.formLeaveDtlsReport.reset();
	}

/****** Functions added to populate position textbox *******/

function populatePosition(code)
{
	
	var frmObj=document.formLeaveDtlsReport;
	var p_role_type=frmObj.slt_role_type[frmObj.slt_role_type.selectedIndex].value;
	var p_staff_type=frmObj.slt_staff_type[frmObj.slt_staff_type.selectedIndex].value;
	var locale = frmObj.locale.value;	
		
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;

			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "../../eRS/jsp/LeaveDtlsRepValidate.jsp?role_type="+p_role_type+"&p_staff_type="+p_staff_type+"&p_position_code="+code+"&locale="+locale+"&func_mode=Position", false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText);
}

function addPosition(code,desc)
{
		var frmObj=document.formLeaveDtlsReport;
		frmObj.txt_position.value=desc;
		frmObj.p_position_code.value=code;
}
