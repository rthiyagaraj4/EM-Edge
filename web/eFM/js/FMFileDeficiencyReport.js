function codeCheck(Obj)
{
		var u=Obj ;
		if(u==' ')
		{
		parent.searchResultFrame.location.href='../../eCommon/html/blank.html';
		}
		
		if(u=='D')
		{
		parent.searchResultFrame.location.href ="../../eFM/jsp/FMFileDeficiencyType.jsp";
		}
		
		if(u=='F')
		{
		parent.searchResultFrame.location.href ="../../eFM/jsp/FMFileDeficiencyCriteria.jsp";
		}
		if(u=='P')
		{
		parent.searchResultFrame.location.href ="../../eFM/jsp/FMFileDeficiencyDoctor.jsp";
		}
		/* if(u=='S')
		{
		parent.searchResultFrame.location.href ="../../eFM/jsp/FMFileDeficiencySpeciality.jsp";
		
		}*/


}


async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "400px" ;//28
			var dialogWidth	= "700px" ;//43
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			
			//alert(obj.name)
			if(obj.name=="DeficiencyFrom")
			{
				tit=getLabel('eFM.Deficiency.label','FM');
				sql="select DEFICIENCY_CODE, SHORT_DESC from fm_deficiency_lang_vw where EFF_STATUS=`E` and language_id=`"+localeName+"`";
				search_code="DEFICIENCY_CODE";
				search_desc= "SHORT_DESC";
			}
		
			if(obj.name=="DeficiencyTo")
			{
				tit=getLabel('eFM.Deficiency.label','FM');
				sql="select DEFICIENCY_CODE, SHORT_DESC from fm_deficiency_lang_vw where EFF_STATUS=`E` and language_id=`"+localeName+"`";
				search_code="DEFICIENCY_CODE";
				search_desc= "SHORT_DESC";
			}
		
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}

async function searchCodePrac(obj,target)
	{
	
			var retVal = 	new String();
			var dialogHeight= "400px" ;//28
			var dialogWidth	= "700px" ;//43
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var p_facility_id = document.forms[0].p_facility_id.value ;
			
			if(obj.name=="fsPractFromButton")
			{
			
				tit=getLabel('Common.practitioner.label','common');
				//sql="select practitioner_id, practitioner_name from am_pract_for_facility_vw where operating_facility_id =`" + p_facility_id + "` and eff_status = `E` ";
				/*sql="select practitioner_id, AM_GET_DESC.AM_PRACTITIONER(practitioner_id,`"+localeName+"`,`1`) from am_pract_for_facility where facility_id =`" + p_facility_id + "` and eff_status = `E` ";
				search_code="practitioner_id";
				search_desc= "2";*/
				sql=" select b.practitioner_id,b.PRACTITIONER_NAME  from am_pract_for_facility a ,AM_PRACTITIONER_LANG_VW b where a.facility_id =`" + p_facility_id + "` and a.eff_status = `E`   AND  b.practitioner_id=a.practitioner_id AND b.language_id=`"+localeName+"`"
				search_code="b.practitioner_id";
				search_desc="b.PRACTITIONER_NAME" ;
			}
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = 
			await window.showModalDialog('../../eCommon/jsp/GeneralSearch.jsp?SQL='+sql+'&search_code='+search_code+'&search_desc='+search_desc+'&title='+encodeURIComponent(tit),arguments,features);
			//alert(retVal[0].value);
			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}

	function doDateCheckFrom(from,today) { //args objects 1st is this object & second is the date object
 if(from.value != "")
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
						//if(Date.parse(todt) > Date.parse(fromdt)) {
											
						if(isBefore(fromdate,todate,"DMY",localeName))
							{
						var msg = getMessage('FROM_DATE_GREATER_TO_DATE','FM');
						messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
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
						if(Date.parse(todt) > Date.parse(fromdt)) {
							var msg = getMessage('TO_DATE_LESSER_FROM_DATE','FM');
							messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
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
							//var msg ="APP-FM0041 Date Entered should be lesser than System Date"
							var msg =getMessage("DATE_LESS_SYS_DATE","FM");
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
	searchResultFrame.document.location.href="../../eFM/jsp/FMFileDeficiencyType.jsp"; 
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp'; 
 }

 function run()
 {
	
	if(searchResultFrame.document.forms[0].name == 'Criteria')
	 {
	  if(doDateCheckFrom(searchResultFrame.document.forms[0].p_to_date,searchResultFrame.document.forms[0].p_from_date)&& CheckSystemDateLesser(searchResultFrame.document.forms[0].p_from_date,searchResultFrame.document.forms[0].today.value)&&CheckSystemDateLesser(searchResultFrame.document.forms[0].p_to_date,searchResultFrame.document.forms[0].today.value))
	  {
		  searchResultFrame.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		  searchResultFrame.document.forms[0].target="messageFrame";
		  searchResultFrame.document.forms[0].submit(); 
	  }
	
	}


	if(searchResultFrame.document.forms[0].name == 'Type')
	 {
	  var flag = 'Yes'
	  if(!CheckString(getLabel('eFM.Deficiency.label','FM'), searchResultFrame.document.Type.p_from_code,
		searchResultFrame.document.Type.p_to_code, messageFrame ) )
		flag='No';

	   if(flag == 'Yes')
		 {
				if(doDateCheckFrom(searchResultFrame.document.forms[0].p_to_date,
							searchResultFrame.document.forms[0].p_from_date)&& 
				CheckSystemDateLesser(searchResultFrame.document.forms[0].p_from_date,	
						  searchResultFrame.document.forms[0].today.value)&&
				CheckSystemDateLesser(searchResultFrame.document.forms[0].p_to_date,
							searchResultFrame.document.forms[0].today.value))
							{
								searchResultFrame.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
								searchResultFrame.document.forms[0].target="messageFrame";
								searchResultFrame.document.forms[0].submit(); 
							}
		 }
	  }

	if(searchResultFrame.document.forms[0].name == 'Doctor')
	 {
	  var flag = 'Yes'
	   if(flag == 'Yes')
		 {
			
				
				var p_pract_id =searchResultFrame.document.forms[0].p_pract_id.value;
				var fields = new Array (searchResultFrame.document.forms[0].p_pract_id);
				var names = new Array (getLabel("eFM.ResponsiblePractitioner.label","FM"))
			
			  if(checkFields( fields, names, messageFrame))
				{
			if(doDateCheckFrom(searchResultFrame.document.forms[0].p_to_date,
		  searchResultFrame.document.forms[0].p_from_date)&& 
		    CheckSystemDateLesser(searchResultFrame.document.forms[0].p_from_date,	
			 searchResultFrame.document.forms[0].today.value)&&
		   CheckSystemDateLesser(searchResultFrame.document.forms[0].p_to_date,
			searchResultFrame.document.forms[0].today.value))
			{
				searchResultFrame.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				searchResultFrame.document.forms[0].target="messageFrame";
				searchResultFrame.document.forms[0].submit(); 
			}
				}
			 }
	  }

 }
