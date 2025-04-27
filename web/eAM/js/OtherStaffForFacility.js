var assignReassign = new Array();
var effStatus= new Array();
var message = "";
var facility_id = "";
function create() {
f_query_add_mod.location.href = "../../eAM/jsp/OtherStaffForFacilityAddModify.jsp?facility_id="+facId ;
}
function query() {
	f_query_add_mod.location.href ="../../eAM/jsp/OtherStaffForFacilityQueryCriteria.jsp" ;
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
function apply() {
	var messageFrame = frames[2]; 
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 

	f_query_add_mod.document.f_query_add_mod_res.document.forms[0].action='../../servlet/eAM.OtherStaffForFacilityServlet'
	f_query_add_mod.document.f_query_add_mod_res.document.forms[0].method='post';
	f_query_add_mod.document.f_query_add_mod_res.document.forms[0].target='messageFrame';
	f_query_add_mod.document.f_query_add_mod_res.document.forms[0].submit();
}
var facId='';
function onSuccess() {
	
f_query_add_mod.location.href = "../../eAM/jsp/OtherStaffForFacilityAddModify.jsp?facility_id="+facId ;
}

function reset() {
				if(f_query_add_mod.document.forms[0] || f_query_add_mod.document.f_query_add_mod_query)
					f_query_add_mod.document.location.reload();

}

function chkPractitionerList()
{
	
	var fields = new Array ( 	parent.frames[0].document.forms[0].facility );
		var names = new Array (	getLabel("Common.facility.label","Common")
);
		if(parent.frames[0].checkFieldsofMst( fields, names, parent.parent.frames[2])) {
			return true;
		}
		else
		return false
}


function chkassignReAssign(Obj,Obj1)
{
	Obj1.disabled=false;
	var arr=new Array();
	if(Obj.checked)
	{
	arr=Obj.value.split("$");
	Obj.value=arr[0]+"$"+"Y"+"$"+arr[2];
	assignReassign+=Obj.value+"~";
	
	}
	else
	{
	arr=Obj.value.split("$");
	Obj.value=arr[0]+"$"+"N"+"$"+arr[2];
	assignReassign+=Obj.value+"~";
	}

	parent.frames[1].document.forms[0].totAssignreassign.value=assignReassign;
}
function chkEnable(Obj,Obj1,totApptCount)
{
	if(totApptCount > 0)
	{
	alert(parent.frames[1].getMessage('FUTURE_APPT_EXISTS','AM'));
	Obj.checked=true;
	}
	else
	{
		Obj1.disabled=false;
		var arr=new Array();
		if(Obj.checked)
		{
		arr=Obj.value.split("$");
		Obj.value=arr[0]+"$"+"E"+"$"+arr[2];
		effStatus+=Obj.value+"~";

		}
		else
		{
			arr=Obj.value.split("$");
			var practid = arr[0].substring(2,arr[0].length-1);
			//var xmlDoc=new ActiveXObject("Microsoft.XMLDom")
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH PractID=\""+practid+"\" /></root>"
			var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","ValidatePract.jsp",false)

			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			eval(responseText);

			if (parent.frames[1].document.forms[0].pract_id_exists.value=='N')
			{
				Obj.value=arr[0]+"$"+"D"+"$"+arr[2];
				effStatus+=Obj.value+"~";
			}
			else
				Obj.checked=true;
		}
		if (parent.frames[1].document.forms[0].pract_id_exists.value=='N')
		{
			parent.frames[1].document.forms[0].effStatus.value=effStatus;
		}
	}
}
var temp='';
/*function finalSelect(Obj1,Obj2,Obj3)
{
	if(Obj1.checked)
	{
	temp+=Obj2.value+Obj3.value+"`"
	parent.frames[1].document.forms[0].finalSelect.value=temp;
	}
}*/

var temp1='';
//var temp2='';

function checkActive(target)
{
	var nameStr = 'select';
	var frmObj = parent.f_query_add_mod.document.f_query_add_mod_res.document.forms[0];
	var name = target.name;
	var len = name.length;
	var index = name.substr(nameStr.length,len);

	var eff_from_date = eval("frmObj.eff_date_from"+index).value;
	var eff_to_date = eval("frmObj.eff_date_to"+index).value;
	var other_staff_id = eval("frmObj.other_staff_id"+index).value;
	var def_db_action=eval("frmObj.def_db_action"+index).value


	 eff_from_date =convertDate(eff_from_date,"DMY",localeName,"en");
	 eff_to_date =convertDate(eff_to_date,"DMY",localeName,"en");

		
	if(eff_from_date=="") eff_from_date=" ";
	if(eff_to_date=="") eff_to_date=" ";

	//alert("temp1 before:"+ temp1);
	if(target.checked == false)
	{
		//alert("false");
		eval("frmObj.curr_db_action"+index).value = "I";
		target.checked = false;

		eval("frmObj.eff_date_from"+index).value="";
		eval("frmObj.eff_date_to"+index).value="";

		var eff_from_date = eval("frmObj.eff_date_from"+index).value;
		var eff_to_date = eval("frmObj.eff_date_to"+index).value;
		
		if(eff_from_date=="") eff_from_date=" ";
		if(eff_to_date=="") eff_to_date=" ";
		temp1+=name+"$"+"D"+"$"+index+"$"+"I"+"$"+def_db_action+"$"+eff_from_date+"$"+eff_to_date+"$"+other_staff_id+"$"+"D"+"~"
		
	}
	else
	{
		//alert("true");
		eval("frmObj.curr_db_action"+index).value = "U";
		target.checked = true;

		temp1+=name+"$"+"E"+"$"+index+"$"+"U"+"$"+def_db_action+"$"+eff_from_date+"$"+eff_to_date+"$"+other_staff_id+"$"+"E"+"~"
		
	}

	
	parent.f_query_add_mod.document.f_query_add_mod_res.document.forms[0].finalSelect.value=temp1;

	
	//alert("temp1 :"+ temp1);
	

}

function refreshFinalValues()
	{
	
	temp1='';
	
	}


function dateValidate(target1,target2)
{
	var frmObj = parent.f_query_add_mod.document.f_query_add_mod_res.document.forms[0];
	var name = target1.name;
	var len = name.length;
	var index = target2;
	var eff_from_date = eval("frmObj.eff_date_from"+index).value;
	var from_dt_arr = eff_from_date.split("/");
	var from_date = from_dt_arr[0];
	var from_mon = from_dt_arr[1];
	var from_year = from_dt_arr[2];
	var eff_to_date = target1.value;
if(eff_from_date !="")	
	{	
	if(eff_to_date!="")
	{
	var to_dt_arr = eff_to_date.split("/");
	var to_date = to_dt_arr[0];
	var to_mon = to_dt_arr[1];
	var to_year = to_dt_arr[2];
	
	if(eff_from_date != null && eff_to_date != null)
	{
		if(to_year >= from_year)
		{
			if(to_mon >= from_mon)
			{
				if(to_date >= from_date)
				{
				}
				else
				{
					var message = getMessage('AM_CANNOT_LESSER','AM');
					var sp=message.split("#");
		            var sp2=sp[1].split("$");
		            var messagefinal=sp[0]+"To Date"+sp2[0]+"From Date";
				
					parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messagefinal;
					target1.value="";
					//target1.focus();
					return;

				}
			}
			else
			{
				var message = getMessage('AM_CANNOT_LESSER','AM');
				var sp=message.split("#");
		            var sp2=sp[1].split("$");
		            var messagefinal=sp[0]+"To Date"+sp2[0]+"From Date";
				
					parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messagefinal;
					target1.value="";
					//target1.focus();
					return;

			}
		}
		else
		{

			var message =getMessage('AM_CANNOT_LESSER','AM');
			var sp=message.split("#");
		            var sp2=sp[1].split("$");
		            var messagefinal=sp[0]+"To Date"+sp2[0]+"From Date";
				
					parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messagefinal;
					target1.value="";
					//target1.focus();
					return;

		}
	}
	}
	}
}
function dateValidate1(target1,target2)
{
	var frmObj = parent.f_query_add_mod.document.f_query_add_mod_res.document.forms[0];
	var name = target1.name;
	var len = name.length;
	var index = target2;
	var eff_to_date = eval("frmObj.eff_date_to"+index).value;
	var from_dt_arr = eff_to_date.split("/");
	var from_date = from_dt_arr[0];
	var from_mon = from_dt_arr[1];
	var from_year = from_dt_arr[2];
	var eff_from_date = target1.value;
if(eff_to_date !="")	
	{	
	if(eff_from_date!="")
	{
	var to_dt_arr = eff_from_date.split("/");
	var to_date = to_dt_arr[0];
	var to_mon = to_dt_arr[1];
	var to_year = to_dt_arr[2];
	
	if(eff_from_date != null && eff_to_date != null)
	{	
		if(to_year <= from_year)
		{
			if(to_mon <= from_mon)
			{
				if(to_date <= from_date)
				{
				}
				else
				{
					
					var message = getMessage('AM_CANNOT_GREATER','AM');
					//alert(message);
					var sp=message.split("#");
		            var sp2=sp[1].split("$");
		            var messagefinal=sp[0]+"From Date"+sp2[0]+"To Date";
				
					parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messagefinal;
					
					target1.value="";
					//target1.focus();
					return;

				}
			}
			else
			{						
				var message = getMessage('AM_CANNOT_GREATER','AM');
				var sp=message.split("#");
		            var sp2=sp[1].split("$");
		            var messagefinal=sp[0]+"From Date"+sp2[0]+"To Date";
				
					parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messagefinal;
					target1.value="";
					//target1.focus();
					return;

			}
		}
		else
		{					

			var message = getMessage('AM_CANNOT_GREATER','AM');
			var sp=message.split("#");
		            var sp2=sp[1].split("$");
		            var messagefinal=sp[0]+"From Date"+sp2[0]+"To Date";
				
					parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messagefinal; 
					target1.value="";
					//target1.focus();
					return;

		}
	}
	}
	}
}
function chkDateForSysdate(target)
{
	if(target.value!="")
	{
		var dateObj = new Date();
	var dateArray = (target.value).split("/");
	var date = dateArray[0];
	var mon = dateArray[1];
	var year = dateArray[2];
	var sysDate = dateObj.getDate();
	var sysMon = dateObj.getMonth()+1;
	var sysYear = dateObj.getYear();
	
	if(year < sysYear)
	{
		var message = getMessage('AM_CANNOT_LESSER','AM');
		var sp=message.split("#");
		var sp2=sp[1].split("$");
		var messagefinal=sp[0]+"Date"+sp2[0]+"Sysdate";
		//alert(messagefinal);
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messagefinal;
					target.value="";
					//target.focus();
					return;

	}
	else
	{

		if( year == sysYear )
		{
			if(mon < sysMon || date < sysDate)
			{
				var message = getMessage('AM_CANNOT_LESSER','AM');
				
		var sp=message.split("#");
		var sp2=sp[1].split("$");
		var messagefinal=sp[0]+"Date"+sp2[0]+"Sysdate";
		//alert(messagefinal);
					parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messagefinal;
					target.value="";
					//target.focus();
					return;

			}
			else
			{
				if( mon == sysMon )
				{
					if(date < sysDate)
					{
						var message = getMessage('AM_CANNOT_LESSER','AM');
						
		var sp=message.split("#");
		var sp2=sp[1].split("$");
		var messagefinal=sp[0]+"Date"+sp2[0]+"Sysdate";
		//alert(messagefinal);
						parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messagefinal;
						target.value="";
						//target.focus();
					return;

					}
					else
					{
						var message = "";
						parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					}
				}
				else
				{
					var message = "";
					parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				}
			}
		}
		else
		{
			var message = "";
			parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		}
		
	}
	}
}
//Added by Suji Keerthi for MOHE-CRF-0013
function enable_txt(obj)
{
	if(obj.value!='00')
	        
	  document.forms[0].search_txt.disabled=false;
	 		
	else
	{
      document.forms[0].search_txt.disabled=true;
	   document.forms[0].search_txt.value="";
	}
}
//ENDED
function callPractitioner()
{
	
	refreshFinalValues();

	if(chkPractitionerList())
	{
		facility_id= document.forms[0].facility.value;
		//Added by Suji Keerthi for MOHE-CRF-0013
		var search_by=document.forms[0].search_by.value;
		 var search_txt=document.forms[0].search_txt.value;
		 if(search_txt.indexOf("'")!=-1)
		{			
			search_txt = search_txt.replace("'","''");
		}
		parent.frames[1].location.href='../../eAM/jsp/OtherStaffForFacilityResult.jsp?facility_id='+facility_id+"&search_txt="+encodeURIComponent(search_txt)+"&search_by="+search_by;
		parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_val=&err_num='
	}
}
///////////////////////////////////////////////////////////////////

function checkDt1(date1)
{
	retval=true
	var date1arr=new Array()
   var val=date1.value
    date1arr=val.split("/")
	if(date1arr.length==3)
	{
		var date1d=date1arr[0]
		var date1m=date1arr[1]
		var date1y=date1arr[2]

		date1d=eval(date1d)
		date1m=eval(date1m)
		date1yy=eval(date1y);

		if(date1m<=12)
		{
			if((date1m==1 || date1m==3 || date1m==5 || date1m==7 || date1m==8 || date1m==10 || date1m==12) && (date1d>31))
			{
				retval= false
			}
			if((date1m==4 || date1m==6 || date1m==8 || date1m==11 ) && (date1d>30))
			{
	 			retval= false
			}
			if ((date1y.length <4) || (date1y.length >4))
			{
				retval= false
			}
		}
		else
		{
			retval= false;
		}
	}
	else
	{
		retval= false;
	}
	return retval;
}



/**********Date************/


function validate_date_from(obj,obj1)
{
	
	if(obj.value!="")
	{
	if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
		var sysdt = parent.f_query_add_mod.document.f_query_add_mod_res.document.forms[0].sysdate.value;
		
		var obj2=convertDate(obj.value,"DMY",localeName,"en");
		if(isBefore(sysdt,obj2,'DMY',localeName)==false)
				{
				var message = getMessage("FROM_DATE_LESS_SYSDATE","SM");
				
				parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				obj.value="";
				//obj.select();	
				return false;
			}
			
			
	}
	
		


	if(obj.value!="" && obj1.value!="" )
		{
	
			if(isBefore(obj.value,obj1.value,'DMY',localeName)==false)
				{
				var msg = getMessage('TO_DT_GR_EQ_FM_DT','SM');
				
				parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
				obj.value="";
				//obj.select();					
				return false;
			}
			
			
		}else
			
			return true;
		

			var frmObj = parent.f_query_add_mod.document.f_query_add_mod_res.document.facility_form_result;
			var nameStr = 'eff_date_from';
			var name = obj.name;
			var len = name.length;
			var index = name.substr(nameStr.length,len);
			checkActive(eval("frmObj.select"+index));


}


function validate_date_to(obj,obj1)
{
	
	if(obj.value!="")
	{
	if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
			var sysdt = parent.f_query_add_mod.document.f_query_add_mod_res.document.forms[0].sysdate.value;
		var obj2=convertDate(obj.value,"DMY",localeName,"en");
		if(isBefore(sysdt,obj2,'DMY',localeName)==false)
				{
				
				var msg1=getMessage("TO_DATE_LESS_SYSDATE","SM");
				parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg1;
				obj.value="";
				//obj.select();	
				return false;
			}
	}

	if(obj.value!="" && obj1.value!="" )
		{
	
			if(isBefore(obj1.value,obj.value,'DMY',localeName)==false)
				{
				var msg = getMessage('TO_DT_GR_EQ_FM_DT','SM');
				
				parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
				obj.value="";
				//obj.select();					
				return false;
			}else
			{
				
	/*		var frmObj = parent.f_query_add_mod.document.frames[1].document.forms[0];
			var nameStr = 'eff_date_to';
			var name = obj.name;
			var len = name.length;
			var index = name.substr(nameStr.length,len);
			
			checkActive(eval("frmObj.select"+index));  */
				return true;
			}
						
		}
	

	/*	var frmObj = parent.f_query_add_mod.document.frames[1].document.forms[0];
			var nameStr = 'eff_date_to';
			var name = obj.name;
			var len = name.length;
			var index = name.substr(nameStr.length,len);
			
			checkActive(eval("frmObj.select"+index)); */



}
