function codeCheck(Obj)
{
		var u=Obj ;
		if(u==' ')
		{
		parent.searchResultFrame.location.href='../../eCommon/html/blank.html';
		}
		
		if(u=='D')
		{
		parent.searchResultFrame.location.href ="../../eFM/jsp/FMFileDeficiencyType_SRR.jsp";
		}
		
		if(u=='F')
		{
		parent.searchResultFrame.location.href ="../../eFM/jsp/FMFileDeficiencyCriteria_SRR.jsp";
		parent.searchResultFrame1.location.href='../../eCommon/html/blank.html';
		}
		if(u=='P')
		{
		parent.searchResultFrame.location.href ="../../eFM/jsp/FMFileDeficiencyDoctor_SRR.jsp";
		parent.searchResultFrame1.location.href='../../eCommon/html/blank.html';
		}
       if(u=='S')
		{
		parent.searchResultFrame.location.href ="../../eFM/jsp/FMFileDeficiencySpeciality_SRR.jsp";
		parent.searchResultFrame1.location.href='../../eCommon/html/blank.html';
		}
		parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp'; 

}


function searchCode(obj,target)
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
		//	if(obj.name=="DeficiencyFrom")
			//{
				tit=getLabel('eFM.Deficiency.label','FM');
				sql="select DEFICIENCY_CODE, SHORT_DESC from fm_deficiency_lang_vw where EFF_STATUS=`E` and language_id=`"+localeName+"`";
				search_code="DEFICIENCY_CODE";
				search_desc= "SHORT_DESC";
		//	}
		
		/*	if(obj.name=="DeficiencyTo")
			{
				tit=getLabel('eFM.Deficiency.label','FM');
				sql="select DEFICIENCY_CODE, SHORT_DESC from fm_deficiency_lang_vw where EFF_STATUS=`E` and language_id=`"+localeName+"`";
				search_code="DEFICIENCY_CODE";
				search_desc= "SHORT_DESC";
			} */
		
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}

function searchCodePrac1(obj,target)
	{
	
			var serch_type=parent.frames[2].document.forms[0].search_type.value;
 var from_code=parent.frames[2].document.forms[0].p_from_code.value;
  var fromSelect="first";	parent.frames[3].location.href="../../eFM/jsp/FMFileDeficiencyResult_SRR.jsp?serch_type="+serch_type+'&from_code='+from_code+'&fromSelect='+fromSelect; 
		
		/*	var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
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
			/*	sql=" select b.practitioner_id,b.PRACTITIONER_NAME  from am_pract_for_facility a ,AM_PRACTITIONER_LANG_VW b where a.facility_id =`" + p_facility_id + "` and a.eff_status = `E`   AND  b.practitioner_id=a.practitioner_id AND b.language_id=`"+localeName+"`"
				search_code="b.practitioner_id";
				search_desc="b.PRACTITIONER_NAME" ;
			}
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = 
			window.showModalDialog('../../eCommon/jsp/GeneralSearch.jsp?SQL='+sql+'&search_code='+search_code+'&search_desc='+search_desc+'&title='+encodeURIComponent(tit),arguments,features);
			//alert(retVal[0].value);
			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus(); */
	
	}
function searchCodePrac(obj,target)
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
			if(obj.name=="speciacodeButton")
			{
			
				tit=getLabel('Common.speciality.label','common');
				//sql="select practitioner_id, practitioner_name from am_pract_for_facility_vw where operating_facility_id =`" + p_facility_id + "` and eff_status = `E` ";
				/*sql="select practitioner_id, AM_GET_DESC.AM_PRACTITIONER(practitioner_id,`"+localeName+"`,`1`) from am_pract_for_facility where facility_id =`" + p_facility_id + "` and eff_status = `E` ";
				search_code="practitioner_id";
				search_desc= "2";*/
			//sql="Select Short_Desc,Speciality_Code  from Am_Speciality_lang_vw where Eff_Status ='E' and language_id='"+localeName+"' order by 1";
				sql="Select a.Speciality_Code,a.Short_Desc from Am_Speciality_lang_vw a where EFF_STATUS=`E` and language_id=`"+localeName+"`";
				search_code="a.Speciality_Code";
				search_desc="a.Short_Desc" ;
			}
					
				
				
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = 
			window.showModalDialog('../../eCommon/jsp/GeneralSearch.jsp?SQL='+sql+'&search_code='+search_code+'&search_desc='+search_desc+'&title='+encodeURIComponent(tit),arguments,features);
			//alert(retVal[0].value);
			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else{ 
					target.select();
				} 
	
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
						if(Date.parse(todt) > Date.parse(fromdt)) {
						if(isBefore(fromdate,todate,"DMY",localeName)) {
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
							var msg =getMessage("DATE_NOT_GREATER_SYSDATE","eCommon");
							
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
	searchResultFrame.document.location.href="../../eFM/jsp/FMFileDeficiencyType_SRR.jsp"; 	 
	searchResultFrame1.document.location.href="../../eCommon/html/blank.html"; 
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp'; 
 }

 function run()
 {		
	 if(searchResultFrame1.document.forms[0])
	 {
			
			var no_of_rec=searchResultFrame1.document.forms[0].no_of_rec.value;			
			var deficiency_code="";
			var code="";
		//	var to=searchResultFrame1.document.forms[0].to.value
			//var max=parseInt(to);
			for(i=1;i<no_of_rec;i++) 
			{
				if(eval("searchResultFrame1.document.forms[0].select_"+i))
				{
					if (eval("searchResultFrame1.document.forms[0].select_"+i).checked==true)
					{
			 code=eval("searchResultFrame1.document.forms[0].deficiency_code"+i).value;
			   if(deficiency_code=="")
						{
						deficiency_code=code;
						}else{
			   deficiency_code=deficiency_code+"||"+code;
						//alert(deficiency_code);
						}  
					}
			  }
			}	 
			//searchResultFrame1.document.forms[0].p_search_by.value=deficiency_code;
			searchResultFrame.document.forms[0].p_search_by.value=deficiency_code;
        	 }


	if(searchResultFrame.document.forms[0].name == 'Criteria')
	 {
		
		  if(doDateCheckFrom(searchResultFrame.document.forms[0].p_to_date,
								searchResultFrame.document.forms[0].p_from_date)&& 
			CheckSystemDateLesser(searchResultFrame.document.forms[0].p_from_date,	
							  searchResultFrame.document.forms[0].today.value)&&
			CheckSystemDateLesser(searchResultFrame.document.forms[0].p_to_date,
								searchResultFrame.document.forms[0].today.value))
			 searchResultFrame.document.forms[0].submit(); 
		
	}


	if(searchResultFrame.document.forms[0].name == 'Type')
	 {
	
		  var flag = 'Yes'

				/*  if(!CheckString(getLabel('eFM.Deficiency.label','FM'), searchResultFrame.document.Type.p_from_code,
					searchResultFrame.document.Type.p_to_code, messageFrame ) )
					flag='No';
				*/

		   if(flag == 'Yes')
			 {
					if(doDateCheckFrom(searchResultFrame.document.forms[0].p_to_date,
								searchResultFrame.document.forms[0].p_from_date)&& 
					CheckSystemDateLesser(searchResultFrame.document.forms[0].p_from_date,	
							  searchResultFrame.document.forms[0].today.value)&&
					CheckSystemDateLesser(searchResultFrame.document.forms[0].p_to_date,
								searchResultFrame.document.forms[0].today.value))
					searchResultFrame.document.forms[0].submit(); 
					 }
	  }
	if(searchResultFrame.document.forms[0].name == 'Doctor')
	 {
		  var flag = 'Yes'
		   if(flag == 'Yes')
			 {			
					if(doDateCheckFrom(searchResultFrame.document.forms[0].p_to_date,
								searchResultFrame.document.forms[0].p_from_date)&& 
					CheckSystemDateLesser(searchResultFrame.document.forms[0].p_from_date,	
							  searchResultFrame.document.forms[0].today.value)&&
					CheckSystemDateLesser(searchResultFrame.document.forms[0].p_to_date,
								searchResultFrame.document.forms[0].today.value)){
					var fields = new Array (searchResultFrame.document.forms[0].p_pract_id);				
					var names = new Array (getLabel("eFM.ResponsiblePractitioner.label","FM"))
					if(checkFields( fields, names, messageFrame))					
						searchResultFrame.document.forms[0].submit(); 					
			 }
		  }
	 }
	  if(searchResultFrame.document.forms[0].name == 'Speciality')
	 {
		  var flag = 'Yes'
		   if(flag == 'Yes')
			 {				
					if(doDateCheckFrom(searchResultFrame.document.forms[0].p_to_date,
								searchResultFrame.document.forms[0].p_from_date)&& 
					CheckSystemDateLesser(searchResultFrame.document.forms[0].p_from_date,	
							  searchResultFrame.document.forms[0].today.value)&&
					CheckSystemDateLesser(searchResultFrame.document.forms[0].p_to_date,
								searchResultFrame.document.forms[0].today.value)){
					var fields = new Array (searchResultFrame.document.forms[0].p_specialty_code);					
					var names = new Array (getLabel("Common.speciality.label","eCommon"))
					if(checkFields( fields, names, messageFrame))					
						searchResultFrame.document.forms[0].submit(); 
					}				
			 }
	  }

 
 }
function call_next(startVar,endVar){
	 	
		var start=parent.frames[3].document.forms[0].from.value;
		var end=parent.frames[3].document.forms[0].to.value;
    	
		if(start=="")start="0";
		if(end=="")end="0";
	parent.frames[3].document.forms[0].from.value =startVar;
	parent.frames[3].document.forms[0].to.value = endVar; 
	parent.frames[3].document.forms[0].submit();
	//parent.frames[3].document.location.href='../../eFM/jsp/FMFileDeficiencyResult.jsp?from='+(parseInt(startVar))+'&to='+(parseInt(endVar));
		}


// this is called when the previous button is pressed	
function call_previous(startVar,endVar)
{

       var start=parent.frames[3].document.forms[0].from.value;
		var end=parent.frames[3].document.forms[0].to.value;
    	if(start=="")start="0";
		if(end=="")end="0";
	parent.frames[3].document.forms[0].from.value =startVar;
	parent.frames[3].document.forms[0].to.value = endVar; 
	
	parent.frames[3].document.forms[0].submit();	//parent.frames[3].document.location.href="../../eFM/jsp/FMFileDeficiencyResult.jsp?from="+(parseInt(startVar))+"&to="+(parseInt(endVar));  
}
 function replaceStr(str,start,end,str1){

	var len =str.length;
	return(str.substr(0,parseInt(start))+str1+str.substr(parseInt(end)+1,len))
}
function call_rowchk(obj,val)
{
	var deficiency_code_buff=parent.frames[3].document.forms[0].deficiency_code_buff.value;
	if(eval("parent.frames[3].document.forms[0].checkbox"+val).checked==true)
	{
	var deficiency_code=eval("parent.frames[3].document.forms[0].deficiency_code"+val).value;
	 deficiency_code_buff=deficiency_code_buff+"||"+deficiency_code

    parent.frames[3].document.forms[0].deficiency_code_buff.value=deficiency_code_buff;
}
}

function submitPrevNext(from, to)
{
	parent.frames[3].document.forms[0].from.value = from;
	parent.frames[3].document.forms[0].to.value = to; 
	//document.forms[0].submit();
parent.frames[3].document.location.href="../../eFM/jsp/FMFileDeficiencyResult_SRR.jsp";
}

function sel_all_chk() {
	
 var startVar= parent.frames[3].document.forms[0].from.value;
 var	endVar= parent.frames[3].document.forms[0].to.value;
		if(startVar=="") startVar="1";
		if(endVar=="") endVar="10";
	if(parent.frames[3].document.forms[0].sel_all.checked==true)
	{
		for(i=startVar;i<=endVar;i++) 
	        {
		    if(eval("parent.frames[3].document.forms[0].select_"+i))
			{
			eval("parent.frames[3].document.forms[0].select_"+i).checked=true
			}
			}
			}
			else{
                for(i=startVar;i<=endVar;i++) 
				{
				if(eval("parent.frames[3].document.forms[0].select_"+i))
				 {
				 eval("parent.frames[3].document.forms[0].select_"+i).checked=false;
			    }
			}
			}
		}

		function select_chk(obj) {			
			if(obj.checked==false){ 
				parent.frames[3].document.forms[0].sel_all.checked=false;
			}
		}
		
		function enablepfromcode(obj)
		{
           if(obj.value !=' ')
			{
		   parent.frames[2].document.forms[0].p_from_code.disabled=false;
		   parent.frames[2].document.forms[0].p_from_code.value=""; 
			}
		   else
			{
		   parent.frames[2].document.forms[0].p_from_code.disabled=true;
			parent.frames[2].document.forms[0].p_from_code.value="";
			}
		 }
