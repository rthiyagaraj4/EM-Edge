
function doDateCheckFrom(from,today) { //args objects 1st is this object & second is the date object
 if(from.value != "")
	 {
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today.value ;
				var siteSpecficappllicable = searchFrame.document.workLoadStatistics.workloadstatistic.value;
				
				if(fromdate.length > 0 && todate.length > 0 ) {
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						if(Date.parse(todt) > Date.parse(fromdt)) {

							var error=getMessage("REMARKS_MUST_GR_EQUAL","common");
							if(siteSpecficappllicable == 'true'){
							error=error.replace("$",getLabel('Common.to.label','common_labels')+ ' ' +getLabel('Common.TransactionDate.label','common_labels'));
							error=error.replace("#",getLabel('Common.TransactionDate.label','common_labels')); 
							//var msg = getMessage('FROM_DATE_GREATER_TO_DATE','FM');
							}
							else
							{
							error=error.replace("$",getLabel('Common.to.label','common_labels')+ ' ' +getLabel('Common.issueddate.label','common_labels'));
							error=error.replace("#",getLabel('Common.issueddate.label','common_labels')); 	
							}
							messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+error;
							from.focus();
							from.select();
							return false;
						}
						else if(Date.parse(todt) <= Date.parse(fromdt))
						{
							messageFrame.location.href='../../eCommon/jsp/error.jsp?' ;
							return true;
						}
						}
			return true;
	 }
	return true;
}

 function doDateCheckto(from,today) { //args objects 1st is this object & second is the date object
 if(today.value != "")
	 {
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today.value ;
				
				if(fromdate.length > 0 && todate.length > 0 ) {
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						if (isBefore(fromdate,todate,"DMY",localeName))
						{
							var msg = getMessage('TO_DATE_LESSER_FROM_DATE','FM');
							messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							from.focus();
							from.select();
							return false;
						}
						/*if(Date.parse(todt) > Date.parse(fromdt)) {
							var msg = getMessage('TO_DATE_LESSER_FROM_DATE','FM');
							messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							from.focus();
							from.select();
							return false;
						}*/
						else if(Date.parse(todt) <= Date.parse(fromdt))
						{
							messageFrame.location.href='../../eCommon/jsp/error.jsp?' ;
							return true;
						}
						}
			return true;
	 }
	return true;
}

 
   
   
   
function CheckSystemDateLesser(from,today) { //args objects 1st is this object & second is the date in dd/mm/yyyy
 if(today != "" && from.value !="" )
	 {
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today ;
				
				if(fromdate.length > 0 && todate.length > 0 )
				{
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						//if(Date.parse(todt) < Date.parse(fromdt))
						if (!isBeforeNow(fromdate,"DMY", localeName))
						{
						//	var msg ="APP-FM0041 Date Entered should be lesser than System Date"
							var msg=getMessage("DATE_NOT_GREATER_SYSDATE","common");
							messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
							from.focus();
							from.select();
							return false;
						}
						else if(Date.parse(todt) >= Date.parse(fromdt))
						{
							messageFrame.location.href='../../eCommon/jsp/error.jsp?' ;
							return true;
						}
				}
			return true;
	 }
	 return true;
}
 
 
 function reset()
 {
	searchFrame.document.forms[0].reset(); 
 }

  
 function run()
 {
	var siteSpecficappllicable = searchFrame.document.workLoadStatistics.workloadstatistic.value;  //added by Mano against ML-MMOH-CRF-0936
	var flag = 'Yes'
	
	if(!CheckString(getLabel('Common.userid.label','common') ,searchFrame.document.workLoadStatistics.p_from_dest_id,
		searchFrame.document.workLoadStatistics.p_to_dest_id, messageFrame ) )
  flag='No';		
if(siteSpecficappllicable!=="true")
{
	if(!CheckString(getLabel('eFM.FSLocationCode.label','FM') ,searchFrame.document.workLoadStatistics.p_from_locn_id,
		searchFrame.document.workLoadStatistics.p_to_locn_id, messageFrame ) )
		flag='No';

	if(!CheckString(getLabel('Common.ReasonCode.label','COMMON'),searchFrame.document.workLoadStatistics.p_from_narration_code,
		searchFrame.document.workLoadStatistics.p_to_narration_code, messageFrame ) )
		flag='No';

	if( searchFrame.document.workLoadStatistics.p_report_option_by.value=='U' ||
		 searchFrame.document.workLoadStatistics.p_report_option_by.value=='L' ||
			searchFrame.document.workLoadStatistics.p_report_option_by.value=='N' )
					searchFrame.document.workLoadStatistics.p_report_id.value='FMBWKSTS';
	else
					searchFrame.document.workLoadStatistics.p_report_id.value='FMBWKSLN';
}
else
{
    if(searchFrame.document.workLoadStatistics.p_report_option.value=='U')
        searchFrame.document.workLoadStatistics.p_report_id.value='FMBWKSTS';
 
    else
          searchFrame.document.workLoadStatistics.p_report_id.value='FMBWKSLN';	
}
	  if(flag == 'Yes')
	 {
		if(doDateCheckFrom(searchFrame.document.workLoadStatistics.p_to_date,
							searchFrame.document.workLoadStatistics.p_from_date))
			searchFrame.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
		    searchFrame.document.forms[0].target="messageFrame";
			searchFrame.document.forms[0].submit(); 
	 }
 }
function searchCodeOnBlur(obj,target)
{
     if(target.value == "")
		{
			target.value="";
			return;
		}else{
    searchCode(obj,target);
     }
}

async function searchCode(obj,target)
{
			var retVal = 	new String();
			var dialogHeight= "65vh" ;
			var dialogWidth	= "55vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var p_facility_id = document.forms[0].p_facility_id.value ;
			
			if(obj.name=="useridFromButton")
			{
				tit=getLabel("Common.user.label","common");
			//sql="select APPL_USER_ID, SM_GET_DESC.SM_APPL_USER(APPL_USER_ID,`"+localeName+"`,`1`) APPL_USER_NAME from sm_facility_for_user where FACILITY_ID=`" + p_facility_id + "`";
			sql="SELECT a.APPL_USER_ID, a.APPL_USER_NAME FROM SM_APPL_USER_LANG_VW a, SM_FACILITY_FOR_USER b where  a.APPL_USER_ID=b.APPL_USER_ID AND B.FACILITY_ID=`" + p_facility_id + "` AND a.language_id=`"+localeName+"`"
				//sql="select APPL_USER_ID,APPL_USER_NAME from sm_facility_for_user_vw where FACILITY_ID=`" + p_facility_id + "`";
				//var ex="(SM_GET_DESC.SM_APPL_USER(APPL_USER_ID,`"+localeName+"`,`1`))";
				search_code="b.APPL_USER_ID";
				search_desc="a.APPL_USER_NAME" ;
			}
		
			if(obj.name=="useridToButton")
			{
				tit=getLabel("Common.user.label","common");
				//sql="select APPL_USER_ID,SM_GET_DESC.SM_APPL_USER(APPL_USER_ID,`"+localeName+"`,`1`) APPL_USER_NAME from sm_facility_for_user where FACILITY_ID=`" + p_facility_id + "`";
				sql="SELECT a.APPL_USER_ID, a.APPL_USER_NAME FROM SM_APPL_USER_LANG_VW a, SM_FACILITY_FOR_USER b where  a.APPL_USER_ID=b.APPL_USER_ID AND B.FACILITY_ID=`" + p_facility_id + "` AND a.language_id=`"+localeName+"`"
				search_code="a.APPL_USER_ID";
				search_desc="a.APPL_USER_NAME" ;
			}			
			
			
			if(obj.name=="fsLocationFromButton")
			{
				tit=getLabel('eFM.FSLocation.label','FM')
				sql="select FS_LOCN_CODE, SHORT_DESC from fm_storage_locn_lang_vw where EFF_STATUS=`E` and  " +  "FACILITY_ID=`" + p_facility_id + "` and language_id=`"+localeName+"`";
				search_code="FS_LOCN_CODE";
				search_desc= "SHORT_DESC";
			}
		
			if(obj.name=="fsLocationToButton")
			{
				tit=getLabel('eFM.FSLocation.label','FM')
				sql="select FS_LOCN_CODE, SHORT_DESC from fm_storage_locn_lang_vw where EFF_STATUS=`E` and  " +  "FACILITY_ID=`" + p_facility_id + "` and language_id=`"+localeName+"`";
				search_code="FS_LOCN_CODE";
				search_desc= "SHORT_DESC";
			}
		
			if(obj.name=="narrationFromButton")
			{
				tit=getLabel('Common.reason.label','common');
				sql="select NARRATION_CODE, SHORT_DESC from fm_narration_lang_vw where EFF_STATUS=`E` and language_id=`"+localeName+"`";
				search_code="NARRATION_CODE";
				search_desc= "SHORT_DESC";
			}
		
			if(obj.name=="narrationToButton")
			{
				tit=getLabel('Common.reason.label','common');
				sql="select NARRATION_CODE, SHORT_DESC from fm_narration_lang_vw where EFF_STATUS=`E` and language_id=`"+localeName+"`";
				search_code="NARRATION_CODE";
				search_desc= "SHORT_DESC";
			}
			
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal =await  
			window.showModalDialog('../../eCommon/jsp/GeneralSearch.jsp?SQL='+sql+'&search_code='+search_code+'&search_desc='+search_desc+'&title='+encodeURIComponent(tit),arguments,features);
			var ret1=unescape(retVal);
			 var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
					arr[0]="";	
					arr[1]="";	
				}
			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
}
 
 
function setDate(Object)    { // function to set either Date of Birth or Day Month Age

       var currentDate = new Date();
       if(Object.value!="")
	{
	   if (isBeforeNow(Object.value,"DMY",localeName))
        {
          return true;
        }
        else
        {
               alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
				Object.value="";
                Object.focus();
            
        }
    }
	}
