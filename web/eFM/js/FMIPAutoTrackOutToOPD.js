function apply()
{
//	if("In Apply :"+parent.frames[1].frames[1].name);
		parent.frames[2].frames[1].document.forms[0].submit();
}

function onSuccess()
{
	parent.frames[2].frames[1].location.reload();
}

function reset()
{
	parent.frames[2].frames[1].location.reload();
}

function refresh(LocnVal)
{
	var obj = parent.frames[1].document.forms[0]

	if(LocnVal != "")
	{
		var recLocnArr = LocnVal.split("|");
		var LocnCode = recLocnArr[0];	
		var LocnIden = recLocnArr[1];
		var LocnMRyn = recLocnArr[2];

		obj.iss_locn_code.value = LocnCode;
		obj.iss_locn_iden.value = LocnIden;
		obj.iss_locn_mryn.value = LocnMRyn;
	}
	else
	{
		obj.iss_locn_code.value = "";
		obj.iss_locn_iden.value = "";
		obj.iss_locn_mryn.value = "";
	} 
}

/*function search(target,obj1)
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
	var facility_id = obj1;
		
		tit=getLabel("Common.nursingUnit.label","common");
		//sql="select nursing_unit_code, short_desc from op_nursing_unit where FACILITY_ID="+facility;
		sql="select nursing_unit_code, long_desc from ip_nursing_unit_lang_vw where facility_id=`"+facility_id+"` and language_id=`"+localeName+"`";
		search_code="nursing_unit_code";
		search_desc= "long_desc"

	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

	if (!(retVal == null))
	{
		target.value=retVal;
	}
	else
		target.focus();
} */

async function search(target,obj1)
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
	var facility_id = obj1;

		
		tit=getLabel("Common.nursingUnit.label","common");
		//sql="select nursing_unit_code, short_desc from op_nursing_unit where FACILITY_ID="+facility;
		sql="select nursing_unit_code code, long_desc description from ip_nursing_unit_lang_vw where facility_id='"+facility_id+"' and language_id='"+localeName+"' and upper(nursing_unit_code) like upper(?) and upper(long_desc) like upper(?)";
		search_code="nursing_unit_code";
		search_desc= "long_desc"

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
		else
			target.focus();

	/*if (!(retVal == null))
	{
		target.value=retVal;
	}
	else
		target.focus();*/
} 


async function TrackoutFiles()
{

	parent.parent.frames[2].commontoolbarFrame.location.href = '../../eCommon/html/process.html';

	var Obj = parent.frames[1].document.forms[0]	

	var fields = new Array ( Obj.iss_locn_code, Obj.preferred_date );
	var names = new Array ( getLabel("eFM.FSLocation.label","FM"), getLabel("Common.BookingDate.label","common"));

	if(parent.frames[1].checkFields( fields, names, parent.messageFrame)) 
	{
		Obj.trackout.disabled=true;
		Obj.nursing_unit1.disabled=true;
		Obj.nursing_unit2.disabled=true;
	//	Obj.issue_locn_code.disabled=true;
	if(parent.frames[1].CheckString(getLabel("Common.nursingUnit.label","common"),Obj.from_nursing_unit, Obj.to_nursing_unit, parent.messageFrame ) )
		{
		parent.frames[1].document.forms[0].action="../../servlet/eFM.FMAutoTrackOutToIPWServlet";
		parent.frames[1].document.forms[0].traget="messageFrame";
		parent.frames[1].document.forms[0].submit();
		Obj.trackout.disabled=false;
		Obj.nursing_unit1.disabled=false;
		Obj.nursing_unit2.disabled=false;
			}else
		{
		Obj.trackout.disabled=false;
		Obj.nursing_unit1.disabled=false;
		Obj.nursing_unit2.disabled=false;
			}
	}
}

function ValidateOPDDate(from,today)
{
	if(today != "" && from.value !="" )
    {
		var fromarray;
		var toarray;
		var reportedarray;
		var fromdate =from.value ;
		var todate =today ;
		
		
		if(fromdate.length > 0 && todate.length > 0 ) 
		{
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);
		/*	if(Date.parse(todt) > Date.parse(fromdt)) 
			{
				//var msg ="APP-FM0041 Booking Date can not be Less than System Date"
				var msg=getMessage("BOOK_DATE_NOT_LESS_CURRDATE","common");
				parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
				from.focus();
				from.select();
				return false;
			}*/
			if (!isAfterNow(fromdate,"DMY",localeName))
			{
				var msg=getMessage("BOOK_DATE_NOT_LESS_CURRDATE","FM");
				parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
				from.focus();
				from.select();
				parent.frames[1].document.forms[0].trackout.disabled=true;
				return false;

			}
			else if(Date.parse(todt) <= Date.parse(fromdt))
			{
				parent.frames[2].location.href='../../eCommon/jsp/error.jsp?' ;
				parent.frames[1].document.forms[0].trackout.disabled=false;
				return true;
			}
		}
	 }
	 else
	 {
			//var msg ="APP-000001Booking Date cannot be blank..."
			var msg=getMessage("CAN_NOT_BE_BLANK","common");
			msg=msg.replace('$',getLabel("Common.booking.label","common"));
			parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
			from.focus();
			from.select();
			return false;
	 }
}

function EnableDisableCheck(obj)
	{
		if (obj.checked==true)
			obj.value='Y';
		else
			obj.value='N';
	}

	function changeUpperCase(obj)
	{
		obj.value = obj.value.toUpperCase();
	}
	
	function searchCode(target,facility_id,target_name)
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
			
			//alert(obj.name)
				tit=getLabel("Common.user.label","common");
				sql="select APPL_USER_ID, APPL_USER_NAME from SM_FACILITY_FOR_USER_VW where facility_id=`"+facility_id+"` ";
				search_code="APPL_USER_ID";
				search_desc= "APPL_USER_NAME";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst=dispDescFirst",arguments,features);

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

	function doOnlineReportPrintingTrackout(error_msg,error_val,login_facility_id,login_user_id,from_nursing_unit,to_nursing_unit,p_fm_pract_id,p_to_pract_id,preferred_date,fs_locn_code)
	{
 	 
	 var flag="AutoTrackouttoIPW";
	  
	  if(error_val==1)
		{
	parent.frames[2].location.href="../eCommon/jsp/error.jsp?err_num="+error_msg+"&err_value=1";
		}
 
  if(error_val==0)
		{
	parent.frames[2].location.href="../eCommon/jsp/error.jsp?err_num="+error_msg+"&err_value=0";
		}
  parent.frames[1].document.forms[0].trackout.disabled=false;
    
     HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' 	action='../eFM/jsp/FMIPGeneratePullListConfirm.jsp'><input name='login_facility_id' id='login_facility_id' type='hidden' value='"+login_facility_id+"'><input name='login_user_id' id='login_user_id' type='hidden' value='"+login_user_id+"'><input name='from_nursing_unit' id='from_nursing_unit' type='hidden' value='"+from_nursing_unit+"'><input name='to_nursing_unit' id='to_nursing_unit' type='hidden' value='"+to_nursing_unit+"'><input name='p_fm_pract_id' id='p_fm_pract_id' type='hidden' value='"+p_fm_pract_id+"'><input name='p_to_pract_id' id='p_to_pract_id' type='hidden' value='"+p_to_pract_id+"'><input name='preferred_date' id='preferred_date' type='hidden' value='"+preferred_date+"'><input name='flag' id='flag' type='hidden' value='"+flag+"'><input name='fs_locn_code' id='fs_locn_code' type='hidden' value='"+fs_locn_code+"'></form></BODY></HTML>";
		parent.frames[3].document.write(HTMLVal);
		parent.frames[3].document.form1.submit();
	}
	

function doOnlineReportPrinting(msg,p_fm_nursing_unit_code,p_to_nursing_unit_code,p_fm_pract_id,p_to_pract_id,p_gender,p_preferred_date,p_pull_list_no,fs_locn_code,appl_user_id,print_pulled_list,print_tracer_card)
	{

	 var flag="Confirm IP Pulling List";
	   parent.parent.frames[2].location.href="../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=1";
	  
	   HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' 	action='../eFM/jsp/FMIPGeneratePullListConfirm.jsp'><input name='p_fm_nursing_unit_code' id='p_fm_nursing_unit_code' type='hidden' value='"+p_fm_nursing_unit_code+"'><input name='p_to_nursing_unit_code' id='p_to_nursing_unit_code' type='hidden' value='"+p_to_nursing_unit_code+"'><input name='p_fm_pract_id' id='p_fm_pract_id' type='hidden' value='"+p_fm_pract_id+"'><input name='p_to_pract_id' id='p_to_pract_id' type='hidden' value='"+p_to_pract_id+"'><input name='p_gender' id='p_gender' type='hidden' value='"+p_gender+"'><input name='p_preferred_date' id='p_preferred_date' type='hidden' value='"+p_preferred_date+"'><input name='p_pull_list_no' id='p_pull_list_no' type='hidden' value='"+p_pull_list_no+"'><input name='fs_locn_code' id='fs_locn_code' type='hidden' value='"+fs_locn_code+"'><input name='appl_user_id' id='appl_user_id' type='hidden' value='"+appl_user_id+"'><input name='print_pulled_list' id='print_pulled_list' type='hidden' value='"+print_pulled_list+"'><input name='print_tracer_card' id='print_tracer_card' type='hidden' value='"+print_tracer_card+"'><input name='flag' id='flag' type='hidden' value='"+flag+"'></form></BODY></HTML>";
		parent.parent.frames[3].document.write(HTMLVal);
		parent.parent.frames[3].document.form1.submit();
       
  } 
	

