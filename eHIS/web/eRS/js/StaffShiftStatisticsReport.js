
function run() 
	{
		//alert("inside run");
		var frmObject = searchFrame.document.formStaffShiftStatisticsReport;
		if(searchFrame.document.formStaffShiftStatisticsReport.P_Report_By.value=="A") 
		{
				//alert("if earchFrame.document.formStaffShiftStatisticsReport.value A");
				searchFrame.document.formStaffShiftStatisticsReport.p_report_id.value="RSSTSHST1";
		}
		else if(searchFrame.document.formStaffShiftStatisticsReport.P_Report_By.value=="S")
		{
			//alert("if searchFrame.document.formStaffShiftStatisticsReport.value---S");
			searchFrame.document.formStaffShiftStatisticsReport.p_report_id.value="RSSTSHST2";
		}
		else if(searchFrame.document.formStaffShiftStatisticsReport.P_Report_By.value=="W")
		{
			//alert("if searchFrame.document.formStaffShiftStatisticsReport.value---W");
			searchFrame.document.formStaffShiftStatisticsReport.p_report_id.value="RSSTSHST3";
		}
		else if(searchFrame.document.formStaffShiftStatisticsReport.P_Report_By.value=="F")
		{
			//alert("if searchFrame.document.formStaffShiftStatisticsReport.value---F");
			searchFrame.document.formStaffShiftStatisticsReport.p_report_id.value="RSSTSHST4";
		}
	
		if(frmObject) 
			{
				//alert("inside If frmObject---->" +frmObject.name)
				var fields= new Array (frmObject.p_date_from, frmObject.p_date_to);
				var names= new Array (getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
		      
				if(!CheckString(getLabel("eRS.WorkPlace.label","RS"), frmObject.p_workplace_code_from,frmObject.p_workplace_code_to, messageFrame) ){
	               return;
			  }
			  if(!CheckString(getLabel("Common.Position.label","Common"), frmObject.p_position_code_from,frmObject.p_position_code_to, messageFrame) ){
				   return;
			  }
			  if(!CheckString(getLabel("eRS.Staff.label","RS"), frmObject.p_staff_code_from,frmObject.p_staff_code_to, messageFrame) ){
				   return;
			  }
                if(checkFields(fields,names,messageFrame)) 
					{
						//alert("278--if");
						if(checkDate())
							{ 
								//alert(frmObject.p_staff_code_from.value);
								//frmObject.p_staff_code_from.value=frmObject.p_from_staff_code.value
								//frmObject.p_staff_code_to.value=frmObject.p_to_staff_code.value

								//alert("submit");
								frmObject.submit();
								//frmObject.p_staff_code_from.value=frmObject.p_from_staff_code.value
								//frmObject.p_staff_code_to.value=frmObject.p_to_staff_code.value
//
							}
					}
			}
	}
	/************** Date functions starts here ***************/

function validDateFormat(obj, locale)
	{
		//alert("inside validDateFormat");
		//alert("inside validDateFormat---->" +obj.value);
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
		//alert("Inside allow Date format");
	   var key = window.event.keyCode;
		if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 47)) ) 
			{  // numbers or slash
				return false;
			}
	}

function checkDate()
	{
		
		
		var frmObject = searchFrame.document.formStaffShiftStatisticsReport;
		;
		var p_language_id=frmObject.locale.value;
		var fromDate=convertDate(frmObject.p_date_from.value,'DMY',p_language_id,"en");
		var toDate =convertDate(frmObject.p_date_to.value,'DMY',p_language_id,"en");
		//alert("fromDate--->" +fromDate);
		//alert("toDate--->" +toDate);
		var message;
	
    	if(!doDateCheck(fromDate,toDate,messageFrame))
			{
				message=getMessage("TO_DT_GR_EQ_FM_DT","PH");
				messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
				frmObject.p_date_to.select();
				frmObject.p_date_to.focus();
				return false;
			}
		
        
		 messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
		 return true;
	}
/************** Date functions end here ***************/


/****** Reset method *******/
function reset()
	{
		searchFrame.document.formStaffShiftStatisticsReport.reset();
	}
//For workplace Lookup
function searchCode( target ) {
	
	target.value="";
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var language_id=document.formStaffShiftStatisticsReport.locale.value;
	var locale=language_id;
	argumentArray[0] = "SELECT workplace_code code, workplace_desc description FROM rs_workplace_lang_vw WHERE UPPER(workplace_code) LIKE UPPER(?) AND UPPER(workplace_desc) LIKE UPPER(?) and language_id ='"+locale+"' ORDER BY workplace_desc";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;

	argumentArray[6] = CODE_LINK ;
	argumentArray[7] = CODE_DESC ;
	retArray = CommonLookup( getLabel("eRS.WorkPlace.label","RS"), argumentArray );
	//alert("retArray  ="+retArray);
	if(retArray != null && retArray != "" ) {
		target.value = retArray[0];	/* if code need to be returned */
		target.focus();
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

/****** Function to open Staff lookup dialog *******

function showStaff(target)
{	
	alert("inside showStaff");
	//var frmObj=document.formLeaveDtlsReport;
	var frmObj=document.formStaffShiftStatisticsReport;
	alert("frmObj---->" +frmObj.name);
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

/*function addStaffType(code,value) 
{
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.forms[0].slt_staff_type.add(element);
}

/****** Run method *******/







/****** Function to clear the workplace textbox *******/

function clearWorkPlace()
	{
		var frmObj = document.formLeaveDtlsReport;
		frmObj.txt_work_place1.value = "";
		frmObj.txt_work_place.value = "";
	}

/****** Function to clear the Position and Staff textboxes *******

function clearPositionStaff()
	{
		var frmObj = document.formLeaveDtlsReport;
		frmObj.txt_position.value = "";
		frmObj.p_position_code.value = "";
		frmObj.txt_staff1.value = "";
		frmObj.txt_staff.value = "";
	}





/****** Functions added to populate position textbox *******/

/*function populatePosition(code)
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
}*/
