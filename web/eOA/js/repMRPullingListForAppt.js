function reset() {
		f_query_add_mod.document.location.reload();
}



function run() 
{
	var fields = new Array( f_query_add_mod.document.repMRPullingListForAppt.p_fm_appt_date1,
					f_query_add_mod.document.repMRPullingListForAppt.p_to_appt_date1 );

var names = new Array(getLabel("eOA.ApptDateFrom.label","OA"), getLabel("eOA.ApptDateTo.label","OA"));
if(f_query_add_mod.checkFields( fields, names, messageFrame))
{
	if( f_query_add_mod.DateCompare4( f_query_add_mod.document.repMRPullingListForAppt.p_fm_appt_date1, f_query_add_mod.document.repMRPullingListForAppt.p_to_appt_date1) ) 
	{
		if( f_query_add_mod.CheckString( getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.repMRPullingListForAppt.p_fm_locn_code, f_query_add_mod.document.repMRPullingListForAppt.p_to_locn_code, messageFrame ) ) 
		{
			if( f_query_add_mod.CheckString( getLabel("Common.resourceid.label","Common"),f_query_add_mod.document.repMRPullingListForAppt.p_fm_pract_id, f_query_add_mod.document.repMRPullingListForAppt.p_to_pract_id, messageFrame ) ) 
			{
				orderbycolumns	=	f_query_add_mod.document.forms[0].orderbycolumns;

				var order_by_columns	=	"";

				if(orderbycolumns.length>0)
				{
					for(var i=0; i<orderbycolumns.length; i++)
					{
						order_by_columns	+=	orderbycolumns[i].value;
						
						if( (i+1) < orderbycolumns.length ) order_by_columns	+=	"__";
					}
				}
				f_query_add_mod.document.repMRPullingListForAppt.p_order_by.value = order_by_columns;
				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.repMRPullingListForAppt.submit() ;
			}
		}
	}	
 }
}




function practValidate(Obj)
		{
	document.forms[0].P_RESOURCE_CLASS.value=Obj.value;
	document.forms[0].p_fm_pract_id.value='';
		document.forms[0].p_to_pract_id.value='';
		if(Obj.value=='')
		{

			document.forms[0].p_fm_pract_id.value='';
			document.forms[0].p_to_pract_id.value='';
			document.forms[0].p_fm_pract_id.disabled=true;
			document.forms[0].pract_id.disabled=true;
			document.forms[0].pract_id1.disabled=true;
			document.forms[0].p_to_pract_id.disabled=true;
		}
		else
			{
		document.forms[0].p_fm_pract_id.disabled=false;
			document.forms[0].p_to_pract_id.disabled=false;
		document.forms[0].pract_id.disabled=false;
		document.forms[0].pract_id1.disabled=false;
			}
		}
function getResource(Obj)
{
	var carelocn="";
	var resource1 = document.forms[0].p_resource_class1.value;
		var n=document.forms[0].fm_pract_type.options.length;
	for(var i=0;i<n;i++){
		document.forms[0].fm_pract_type.remove("clinic");
		document.forms[0].to_pract_type.remove("clinic");
		
	}
	
	var opt=document.createElement("OPTION");
	opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	opt.value="";
	document.forms[0].fm_pract_type.add(opt);	
	var opt1=document.createElement("OPTION");
	opt1.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	opt1.value="";
	document.forms[0].to_pract_type.add(opt1);	
	
if(!(resource1 == null || resource1 == ""))
{
	
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH resource1=\""+resource1+"\" steps='1' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eOA/jsp/ReportsServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
}
}

/*	function checkDt(date1)
	{
		retval=true
		var date1arr=new Array()

		date1arr=date1.split("/")

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
				retval= false}

				if((date1m==4 || date1m==6 || date1m==8 || date1m==11 ) && (date1d>30))
				{
				retval= false}

				if ((date1y.length <4) || (date1y.length >4))
					{
					retval= false}
					}
			else
				{
				retval= false;}
		}
		else
			{retval= false;}
			return retval;
		}   */

	/*function chkTime(time1)
	{
		var retval=true;

		if( (time1.charAt(time1.length-1) )!=":")
		{
			var time1arr=new Array()
			time1arr=time1.split(":")

			if(time1arr.length==2)
			{
				var time1hr=time1arr[0]
				var time1min=time1arr[1]

				time1hr=eval(time1hr)
				time1min=eval(time1min)
				if(time1hr<=23)
				{
					if(time1min>=60)
					{
							retval=false;
					}
				}
				else
						retval=false;
			}
			else
				retval=false;
		}
		else
				retval=false;
		
		return retval
	}
*/
	
/*function CompDates(dat1,dat2)
	{
		var comp = true;
		if (dat1.getFullYear() > dat2.getFullYear()){
			comp = true;
		}else if (dat1.getFullYear() == dat2.getFullYear()){
			if (dat1.getMonth() > dat2.getMonth()){
				comp = true;
			}else if (dat1.getMonth() == dat2.getMonth()){
				if (dat1.getDate() > dat2.getDate()){
					comp = true;
				}else if (dat1.getDate() == dat2.getDate()){
					comp = true;
				}else if (dat1.getDate() < dat2.getDate()){
					comp = false;	
				}
			}else if (dat1.getMonth() < dat2.getMonth()){
				comp = false;
			}
		}else if (dat1.getFullYear() < dat2.getFullYear()){
			comp = false;
		}
		return comp;
	}  */

	/*function doDateTimeChk(obj)
	{
		var comp=obj
		obj=obj.value
		var dttime = obj.split(" ");
		var dtArr=new Array()
		dtArr=obj.split("/")
		var dt
		var time
		var retval=true
		if(dttime == ""){}
		else if(dttime.length>1)
		{
			dt=dttime[0]
			time=dttime[1]

			if(!checkDt(dt) )
			{
				retval= false
				comp.focus()
			}
			else
			{
				if(time==null || time=="")
				{
					alert(getMessage("INVALID_DATE_TIME","SM"))
					retval= false;
					comp.focus()
				}

				else
				{
					if(!chkTime(time))
					{
							retval= false
							alert(getMessage("INVALID_DATE_TIME","SM"))
							comp.focus()
					}
					else
					{
						var today = new Date();
						var entDate = new Date(parseInt(dtArr[2]),parseInt(dtArr[1]-1),parseInt(dtArr[0]));
						if(!CompDates(entDate,today))
						{
								retval= false
								alert(getMessage("PREF_FM_DT_VALIDATION","OA"))
								comp.focus()
						}
					}
				}
			}
		}
		else
		{
			retval= false
			alert(getMessage("INVALID_DATE_TIME","SM"))
			comp.focus()
		}

		if(retval)
		{
			
		}
		return retval
	}*/




function enablepr(obj)
{
	document.forms[0].p_fm_pract_id.value='';
		
	
}
function enablepr1(obj)
{
	document.forms[0].p_to_pract_id.value='';
	
		
}
function changeVal(obj)
{
	document.forms[0].P_LOCATION_TYPE.value=obj.value;
	document.forms[0].p_fm_locn_code.value='';
	document.forms[0].p_to_locn_code.value='';
		}

function PractLookupRetVal(retVal,objName)
{
	var arr;
if (!(retVal == null))
			{

			arr=retVal.split("~");
			if(objName=="p_fm_pract_id")
				{
				
				document.forms[0].p_fm_pract_id.value=arr[0];
			}
			else
				{
				
				document.forms[0].p_to_pract_id.value=arr[0];
				}
			}
			else
				{
				if(objName=="p_fm_pract_id")
					{
					
				document.forms[0].p_fm_pract_id.focus();
				document.forms[0].p_fm_pract_id.value="";
					}
					else
					{
						
					document.forms[0].p_to_pract_id.focus();
					document.forms[0].p_to_pract_id.value="";
					}
			
				}
			
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
		var facilityid = document.forms[0].p_facility_id.value;
		var p_location_type1=document.forms[0].p_location_type1.value;
		var facility=obj1.value;
		var locale=document.forms[0].locale.value;

		if(obj.name=="locn")
			{
				tit=encodeURIComponent(getLabel("Common.Location.label","Common"));
				sql="select clinic_code, long_desc from op_clinic_lang_vw where facility_id=`"+facilityid+"` and language_id=`"+locale+"` and level_of_care_ind = `A`  and CARE_LOCN_TYPE_IND=nvl(`"+p_location_type1+"`,CARE_LOCN_TYPE_IND)";
				search_code="clinic_code";
				search_desc= "long_desc";
			}
			
			if(obj.name=="locn1")
			{
				tit=encodeURIComponent(getLabel("Common.Location.label","Common"));
				sql="select clinic_code, long_desc from op_clinic_lang_vw where facility_id=`"+facilityid+"` and  language_id=`"+locale+"` and level_of_care_ind = `A`  and CARE_LOCN_TYPE_IND=nvl(`"+p_location_type1+"`,CARE_LOCN_TYPE_IND)";
				search_code="clinic_code";
				search_desc= "long_desc";
			}
		
		
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

		if (!(retVal == null))
		{
			target.value=retVal;
		}
		else
			target.focus();
	}*/


	async function searchCode1(obj,target_code,target_desc)
				{


				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var locale=document.forms[0].locale.value;
				var tit="";
				var sql="";

			var facilityid = document.forms[0].p_facility_id.value;
			var p_location_type1=document.forms[0].p_location_type1.value;
		//	var facility=obj1.value;
			var locale=document.forms[0].locale.value;

			if(obj.name=="locn" || obj.name=="p_fm_locn_code")
			{
				tit=getLabel("Common.Location.label","Common");
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facilityid+"' and level_of_care_ind = 'A' and language_id='"+locale+"' and CARE_LOCN_TYPE_IND=nvl('"+p_location_type1+"',CARE_LOCN_TYPE_IND) and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2";
				
			}
			
			if(obj.name=="locn1" || obj.name=="p_to_locn_code")
			{
				tit=getLabel("Common.Location.label","Common");
				sql="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id='"+facilityid+"' and level_of_care_ind = 'A'  and language_id='"+locale+"'  and CARE_LOCN_TYPE_IND=nvl('"+p_location_type1+"',CARE_LOCN_TYPE_IND) and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2";
				
			}

					
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target_code.value;
				argumentArray[6] = CODE_LINK ;
				argumentArray[7] = CODE_DESC ;
				
				retVal = await CommonLookup( tit, argumentArray );
				if (retVal !=null && retVal !="")
				{
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target_desc.value=arr[1];
					target_code.value=arr[0];
				}else
				{
				target_desc.value="";
				target_code.value="";
				}
			
			}



	function addOrderByCol(obj)	
		{ 		
		    var from = document.forms[0].orderbycols;
			if(from.selectedIndex !=-1)
			{
		    if ( from.options.length > 0 ) 
			{
				var to = document.forms[0].orderbycolumns; 
				var element = document.createElement('OPTION'); 
				element.text = from.options[from.selectedIndex].text; 
				element.value= from.options[from.selectedIndex].value; 
				to.add(element); 			
				from.remove(from.selectedIndex); 
			} 
			}
		}                                                                                             

		function removeOrderByCol()
		    { 
				var from = document.forms[0].orderbycolumns;
				if(from.selectedIndex !=-1)
			    {
				if ( from.options.length > 0 )
				{ 
					var to = document.forms[0].orderbycols; 
					var element = document.createElement('OPTION'); 
					element.text = from.options[from.selectedIndex].text; 
					element.value = from.options[from.selectedIndex].value; 
					to.add(element);	
					from.remove(from.selectedIndex); 
				}
				}
		    }




	
	
	
	
	
	function doDateTimeChk(obj)
	{
		if(!validDateObj(obj,"DMYHM",localeName))
		{
			obj.value="";
			return ;
		}
	}


	function DateCompare_from(obj2,obj)
{
var sysdt = parent.frames[1].document.forms[0].sys_date.value;

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
			if(isBefore(sysdt,obj1,'DMY',localeName)==false)
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
					if(isBefore(sysdt,obj1,'DMY',localeName)==false)
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
				var msg = getMessage('TO_DT_GR_EQ_FM_DT','SM');
				parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
				to.value="";
				to.select();					
				return false;
			}
			else
				return true;
		}

}

	function chkFormat(obj){
	if(obj.value!=''){
		if(obj.name=='p_fm_appt_date1'){			
			document.forms[0].p_fm_appt_date.value=convertDate(document.forms[0].p_fm_appt_date1.value,'DMY',localeName);			
		}else{				
			document.forms[0].p_to_appt_date.value=convertDate(document.forms[0].p_to_appt_date1.value,'DMY',localeName);				
		}
	}
}
