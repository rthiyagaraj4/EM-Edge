/// CREATED BY SRIDHAR R ON 29 JULY 2004
/// functions are used to reset & run the report
function reset() 
{
	if(f_query_add_mod.document.repRequestStatsForm)
	{
		f_query_add_mod.document.repRequestStatsForm.reset() ;
	}
}


function run()
{
	var fields = new Array (f_query_add_mod.document.repRequestStatsForm.P_FM_DATE,f_query_add_mod.document.repRequestStatsForm.P_TO_DATE);
	var names  = new Array ( getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common"));
		//if(f_query_add_mod.doDateCheck(f_query_add_mod.document.repRequestStatsForm.P_FM_DATE,			f_query_add_mod.document.repRequestStatsForm.P_TO_DATE, messageFrame))
		if(chkGrtrDate(f_query_add_mod.document.repRequestStatsForm.P_FM_DATE,			f_query_add_mod.document.repRequestStatsForm.P_TO_DATE))
		{
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		     f_query_add_mod.document.forms[0].target="messageFrame";
			f_query_add_mod.document.repRequestStatsForm.submit() ;
			}
}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// Added by Sridhar on 29 JULY 2004
// Function will check for empty values before calling up the common lookup func..
		
function beforeGetRequestor(target_id,target)
{
	if(document.forms[0].Requestor_desc_hid.value != document.forms[0].P_REQUESTOR_DESC.value)
	{
		if(document.forms[0].P_REQUESTOR_DESC.value != "")
			 Lookup(target_id,target);
	}
}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/* Modified to CommonLookup on 06/02/04 by Sridhar */
async function Lookup(target_id,target)
{
	var facility_id = document.forms[0].p_facility_id.value;
	var title="";
	var argumentArray=new Array(8);
	title=getLabel("Common.Requestor.label","Common");

	var requestor_type = document.forms[0].P_REQUESTOR_TYPE.value;
	if(requestor_type == '')
	{
		//argumentArray[0]="select REQUESTOR_CODE code, SHORT_DESC description from MR_REQUESTOR_VW where EFF_STATUS like ? and facility_id like ? and upper(REQUESTOR_CODE) like upper(nvl(?,REQUESTOR_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC)) ";

		argumentArray[0]="select REQUESTOR_CODE code, SHORT_NAME description from MR_REQUESTOR_lang_VW where language_id = '"+localeName+"' and EFF_STATUS like ? and facility_id like ? and upper(REQUESTOR_CODE) like upper(nvl(?,REQUESTOR_CODE)) and upper(SHORT_NAME) like upper(nvl(?,SHORT_NAME)) ";
	}
	else
	{
		//argumentArray[0]="select REQUESTOR_CODE code, SHORT_DESC description from MR_REQUESTOR_VW where INDICATOR = '"+requestor_type+"' and EFF_STATUS like ? and facility_id like ? and upper(REQUESTOR_CODE) like upper(nvl(?,REQUESTOR_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC)) ";

		argumentArray[0]="select REQUESTOR_CODE code, SHORT_NAME description from MR_REQUESTOR_lang_VW where language_id = '"+localeName+"' and INDICATOR = '"+requestor_type+"' and EFF_STATUS like ? and facility_id like ? and upper(REQUESTOR_CODE) like upper(nvl(?,REQUESTOR_CODE)) and upper(SHORT_NAME) like upper(nvl(?,SHORT_NAME))"; 
	}

	argumentArray[1]=new Array("EFF_STATUS","facility_id");
	argumentArray[2]=new Array("E",facility_id);
	argumentArray[3]=new Array(STRING,STRING);
	argumentArray[4]="3,4";
	argumentArray[5]=target.value;
	argumentArray[6]=CODE_DESC_LINK;
	argumentArray[7]=CODE_DESC;

	var retVal=await CommonLookup(title,argumentArray);
	
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		document.forms[0].Requestor_desc_hid.value	=	arr[0];	
		document.forms[0].P_REQUESTOR_CODE.value	=	arr[0];	
		document.forms[0].P_REQUESTOR_DESC.value	=	arr[1];
		document.forms[0].Requestor_desc_hid.value = document.forms[0].P_REQUESTOR_DESC.value;
	}
	else
	{
		document.forms[0].Requestor_desc_hid.value	= "";		document.forms[0].P_REQUESTOR_DESC.value	= "";
	}
}

function chkGrtrDate(obj1,obj2)
{
	if( obj1.value != "" && obj2.value != "" )
	{
		if(isBefore(obj1.value,obj2.value,"DMY",localeName) == false)
		{
			var msg = getMessage("TO_DT_GR_EQ_FM_DT","SM");
			alert(msg);
			obj2.select();
			return false;
		}
		else
			return true;
	}
	else 
		return true;
}


function _GRDate2(obj){
	if(obj.name=="P_FM_DATE"){
		var from = obj.value;
		var to   = document.forms[0].CurrentDate.value;
		var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
			if(Date.parse(todt) < Date.parse(fromdt)) {//DATE_NOT_LESS_SYSDATE
				var invaldtFrom = getMessage("FROM_DT_NGE_CURR_DATE","SM") ;
//				var decs_ToDate=getLabel('Common.from.label','common_labels')+" "+getLabel("Visit/Admission Date");
//				invaldtFrom = invaldtFrom.replace('From date',decs_ToDate);
				alert(invaldtFrom);
					document.forms[0].P_FM_DATE.select();
					document.forms[0].P_FM_DATE.focus();

				/*if(parent.f_query_add_mod.document.repDischargeStats)
				{
					document.forms[0].p_to_discharge_date.select();
					document.forms[0].p_to_discharge_date.focus();
				}
				if(parent.f_query_add_mod.document.repDischargeStatsbyNursUnit)
				{
					document.forms[0].p_to_pref_date.select();
					document.forms[0].p_to_pref_date.focus();
				}*/

			}
	}else{
		var from = obj.value;
		var to   = document.forms[0].CurrentDate.value;
		var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
			if(Date.parse(todt) < Date.parse(fromdt)) {//DATE_NOT_LESS_SYSDATE
				var invaldtFrom = getMessage("TO_DT_NGE_CURR_DATE","SM") ;
//				var decs_ToDate=getLabel('Common.to.label','common_labels')+" "+getLabel("Visit/Admission Date";
//				invaldtFrom = invaldtFrom.replace('To Date',decs_ToDate);
				alert(invaldtFrom);
					document.forms[0].P_TO_DATE.select();
					document.forms[0].P_TO_DATE.focus();

				/*if(parent.f_query_add_mod.document.repDischargeStats)
				{
					document.forms[0].p_to_discharge_date.select();
					document.forms[0].p_to_discharge_date.focus();
				}
				if(parent.f_query_add_mod.document.repDischargeStatsbyNursUnit)
				{
					document.forms[0].p_to_pref_date.select();
					document.forms[0].p_to_pref_date.focus();
				}*/

			}

	}
}

/* End of Common Lookup modification */

/*function CheckFromDate(obj)
{
	var flag1=true;
	if(obj.value.length>0)
	CheckDate(obj); // checks for valid date
	var todate=document.forms[0].reqStatTo.value;
	if(obj.value.length > 0 && todate.length > 0 ) 
	{
		if(!doDateCheck(obj,document.forms[0].reqStatTo))
			flag1=false;
	}
	return flag1;
}

function CheckToDate(obj)
{
				var flag=true;
				if(obj.value.length>0)
				{
					CheckDate(obj);
					if(!doDateCheck(document.forms[0].reqStatfrom,obj))
					{
						flag= false;
					}
					
				}
				return flag;
				
}


function doDateCheck(from,to) 
{
		var fromarray; var toarray;
		var fromdate = from.value ;
		var todate = to.value ;

		
		if(fromdate.length<=0 && trimCheck(todate))
		{
			alert(getMessage('FROM_DATE_CANNOT_BE_BLANK','SM') );
			from.select();
			from.focus();
			return false;
		}
		else if(todate.length<=0 && trimCheck(fromdate))
		{
			alert( getMessage('INVALID_TO_DT','SM') );
			to.select();
			to.focus();
			return false;
		}
		else if(fromdate.length > 0 && todate.length > 0 ) 
		{
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);	
			if(Date.parse(todt) < Date.parse(fromdt)) 
			{
				alert( getMessage('TO_DT_GR_EQ_FM_DT','SM') );
				to.select();
				to.focus();
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) 
				return true;
		}
	return true;
}*/
