 function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyMedicalTeam.jsp" ;
}

function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/MedicalTeamQueryCriteria.jsp" ;
}

function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }
function apply()
{
	
var messageFrame = frames[2]; 
	/*var from_date_gerg =f_query_add_mod.convertDate(f_query_add_mod.document.forms[0].from_date.value,"DMY",localeName,"en");
	var to_date_gerg =f_query_add_mod.convertDate(f_query_add_mod.document.forms[0].to_date.value,"DMY",localeName,"en");

	f_query_add_mod.document.facilityteam_form.greg_from_date.value=from_date;
	f_query_add_mod.document.facilityteam_form.greg_to_date.value=to_date;*/
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	

	var fields		 = new Array (f_query_add_mod.document.facilityteam_form.teamid);
	var names		 =  new Array (getLabel("Common.identification.label","Common")
); 
//	var messageFrame = parent.frames[1].frames[2]; 
	
	var error_page	 = "../../eCommon/jsp/MstCodeError.jsp";
	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page))
	{	
		var fields = new Array();
		
		fields[0]= f_query_add_mod.document.facilityteam_form.teamid;
		fields[1]= f_query_add_mod.document.facilityteam_form.long_desc;
		fields[2]= f_query_add_mod.document.facilityteam_form.short_desc;	
		fields[3]=f_query_add_mod.document.facilityteam_form.specialty;
		fields[4]=f_query_add_mod.document.facilityteam_form.facility_id;
		
		var names = new Array (				
				getLabel("Common.identification.label","Common"),
				getLabel("Common.longdescription.label","Common"),
				getLabel("Common.shortdescription.label","Common"),
				getLabel("Common.speciality.label","Common"),
				getLabel("Common.facility.label","Common")
				);
		if(f_query_add_mod.document.facilityteam_form.appl_for_ip_yn.disabled == true )
			f_query_add_mod.document.facilityteam_form.appl_for_ip_yn.disabled= false;
		if(f_query_add_mod.document.facilityteam_form.appl_for_op_yn.disabled == true)
			f_query_add_mod.document.facilityteam_form.appl_for_op_yn.disabled= false;
		
		if(f_query_add_mod.document.facilityteam_form.appl_for_ip_yn.value == 'N' && f_query_add_mod.document.facilityteam_form.appl_for_op_yn.value == 'N' )
		{
			f_query_add_mod.document.facilityteam_form.appl_for_op_yn.value='';
			fields[5] =f_query_add_mod.document.facilityteam_form.appl_for_op_yn
			names[5]=getLabel("eAM.ApplicableForOutpatientsInpatients.label","AM");
		}
		if(f_query_add_mod.checkFieldsofMst(fields,names,messageFrame))
		{
			var from_date = f_query_add_mod.document.forms[0].from_date.value;
			var to_date = f_query_add_mod.document.forms[0].to_date.value;

			if(DateCompare4(f_query_add_mod.document.forms[0].from_date,f_query_add_mod.document.forms[0].to_date))
			 
			{	f_query_add_mod.document.forms[0].action="../../servlet/eAM.MedicalTeamServlet";
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.facilityteam_form.submit();
				
			}
		}	
		else
			f_query_add_mod.document.facilityteam_form.appl_for_op_yn.value = 'N';
	}	
}

/*
function doDateCheckFrom(from,today) 
{ //args objects 1st is this object & second is the date object

	if(from.value != "")
	{
		var fromarray;
		var toarray;
		var fromdate =f_query_add_mod.convertDate(from.value,"DMY",localeName,"en");
		var todate =f_query_add_mod.convertDate(today.value,"DMY",localeName,"en");
		
		if(fromdate.length > 0 && todate.length > 0 ) 
		{
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);
			if(Date.parse(todt) > Date.parse(fromdt)) 
			{
				//var msg = f_query_add_mod.getMessage('FROM_DATE_GREATER_TO_DATE');
				var msg = f_query_add_mod.getMessage('TO_DT_GR_EQ_FM_DT','SM');
				messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
				today.focus();
				today.select();
				return false;
			}
			else if(Date.parse(todt) <= Date.parse(fromdt))
			{
				messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?' ;
				return true;
			}
		}
		return true;
	}
	return true;
}
*/
/*
function doDateCheckto(from,today) 
{ //args objects 1st is this object & second is the date object
	
	if(today.value != "")
	{
		var fromarray;
		var toarray;
		var fromdate =from.value ;
		var todate =today.value ;
	
		if(fromdate.length > 0 && todate.length > 0 ) 
		{
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);
			
			if(Date.parse(todt) > Date.parse(fromdt)) 
			{
				var msg = f_query_add_mod.getMessage('TO_DATE_LESSER_FROM_DATE');
				messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
				from.focus();
				from.select();
				return false;
			}
			else if(Date.parse(todt) <= Date.parse(fromdt))
			{
				messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?' ;
				return true;
			}
		}
		return true;
	}
	return true;
}
*/

var facId='';
function onSuccess() { 
   facId=f_query_add_mod.document.forms[0].facility_id.value;
	if(f_query_add_mod.document.forms[0].function_name.value == 'modify')
		f_query_add_mod.document.location.reload();
	else
		f_query_add_mod.document.location.href="../../eAM/jsp/addModifyMedicalTeam.jsp?facility_id="+facId;
}

function reset() {

/*	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }  */

	var loc=frames[2].document.forms[0]

	if (loc!=null )
	{
		
	//	f_query_add_mod.document.forms[0].reset();
		f_query_add_mod.document.location.reload();
	}
	else  if(loc==null)
	{
		//f_query_add_mod.document.forms[0].reset();
		f_query_add_mod.document.location.reload();
	
	}
}
	
	
			

/*function ValidateDate(obj)
{
	if(obj.value!="")
	{
	if(!validDateObj(obj,"DMY",localeName))
		{
			return ;
		}
		//else
			//getDay();
	}
}
*/


function DateCompare_from(obj2,obj,Sys_date)
{

if(obj.value!="")
		{
		if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
		else{
		var obj1=convertDate(obj.value,"DMY",localeName,"en");

		
if(obj2 =="from")
			{
			if(isBefore(Sys_date.value,obj1,'DMY',localeName)==false)
				{
				alert(getMessage("FROM_DATE_LESS_SYSDATE","SM"));
				obj.value="";
				obj.select();	
				return false;
			}
			else
				return true;

			}else
			{
					if(isBefore(Sys_date.value,obj1,'DMY',localeName)==false)
				{
				alert(getMessage("TO_DATE_LESS_SYSDATE","SM"));
				obj.value="";
				obj.select();	
				return false;
			}
			else
				return true;
			}
		}
}

}

function DateCompare3(from,to)
{
	
//alert("3");
if(from.value!="" && to.value!="" )
		{
			if(isBefore(from.value,to.value,'DMY',localeName)==false)
				{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.value="";
				to.select();	
				return false;
			}
			else
				return true;
		}

}


function DateCompare4(from,to)
{
	if(from.value!="" && to.value!="" )
		{
	
			if(isBefore(from.value,to.value,'DMY',localeName)==false)
				{
				var msg = f_query_add_mod.getMessage('TO_DT_GR_EQ_FM_DT','SM');
				messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
				to.value="";
				to.select();					
				return false;
			}
			else
				return true;
		}else
	{
			return true;
	}


}
