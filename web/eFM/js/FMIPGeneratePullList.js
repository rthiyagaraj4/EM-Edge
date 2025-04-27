
function apply()
{

	var insert_check =	parent.frames[2].frames[1].document.forms[0].pull_list_yn.checked;

	if(insert_check)
	{

		parent.frames[2].frames[1].document.forms[0].method='post';
		parent.frames[2].frames[1].document.forms[0].action='../../servlet/eFM.FMIPGeneratePullingListServlet';
		parent.frames[2].frames[1].document.forms[0].target='messageFrame';
		parent.frames[2].frames[1].document.forms[0].submit();
		
	}
	else
	{
		parent.frames[2].frames[1].location.href='../../eCommon/html/blank.html';
		var msg="";
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
		return false;
	}

	
}



function create()
{
	parent.frames[2].frames[1].location.href='../../eFM/jsp/FMIPGeneratePullListMain.jsp'
}

function reset()
{
	parent.frames[2].frames[1].location.href='../../eFM/jsp/FMIPGeneratePullListMain.jsp'
}
/*function search(obj,target,obj1)
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
	var facility_id = obj1.value;
		
	if(obj.name=="nursing_unit")
	{
		tit=getLabel("Common.nursingUnit.label","common");
		sql="select nursing_unit_code, long_desc from ip_nursing_unit_lang_vw where facility_id=`"+facility_id+"`and eff_status =`E` and language_id=`"+localeName+"`";
		search_code="nursing_unit_code";
		search_desc= "long_desc"
	}
	if(obj.name=="pract_id")
	{
		tit=getLabel("Common.practitioner.label","common");
		sql="select PRACTITIONER_ID, PRACTITIONER_NAME from am_practitioner_lang_vw where eff_status =`E` and language_id=`"+localeName+"`";
		search_code="PRACTITIONER_ID";
		search_desc= "PRACTITIONER_NAME"
	}
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

	if (!(retVal == null))
	{
		target.value=retVal;
        if (target.name=="fm_nursing_unit_code")
         parent.frames[1].document.forms[0].to_nursing_unit_code.value=retVal;

        if (target.name=="fm_pract_id")
         parent.frames[1].document.forms[0].to_pract_id.value=retVal;


	}
	else
		target.focus();
}*/

async function search(obj,target,obj1)
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
	var facility_id = obj1.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	if(obj.name=="nursing_unit")
	{
		tit=getLabel("Common.nursingUnit.label","common");
		sql="select nursing_unit_code code, long_desc description from ip_nursing_unit_lang_vw where facility_id='"+facility_id+"' and eff_status ='E' and language_id='"+localeName+"' and upper(nursing_unit_code) like upper(?) and upper(long_desc) like upper(?)";
		search_code="nursing_unit_code";
		search_desc= "long_desc"
	}
	if(obj.name=="pract_id")
	{
		tit=getLabel("Common.practitioner.label","common");
		sql="select PRACTITIONER_ID code, PRACTITIONER_NAME description from am_practitioner_lang_vw where eff_status ='E' and language_id='"+localeName+"' and upper(PRACTITIONER_ID) like upper(?) and upper(practitioner_name) like upper(?)";
		search_code="PRACTITIONER_ID";
		search_desc= "PRACTITIONER_NAME"
	}
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
        if (target.name=="fm_nursing_unit_code")
         parent.frames[1].document.forms[0].to_nursing_unit_code.value=arr[0];

        if (target.name=="fm_pract_id")
         parent.frames[1].document.forms[0].to_pract_id.value=arr[0];


	}
	else
		target.focus();
}




function doDateTimeChk(obj)
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
				alert(getMessage("FM_INVALID_DATE_TIME","FM"))
				retval= false;
				comp.focus()
			}
			else
			{
				if(!chkTime(time))
				{
					retval= false
					alert(getMessage("FM_INVALID_DATE_TIME","FM"))
					comp.focus()
				}
				else
				{
					var today = new Date();
					var entDate = new Date(parseInt(dtArr[2]),parseInt(dtArr[1]-1),parseInt(dtArr[0]));
					if(!CompDates(entDate,today))
					{
						retval= false
						alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"))
						comp.focus()
					}
				}
			}
		}
	}
	else
	{
		retval= false
		alert(getMessage("FM_INVALID_DATE_TIME","FM"))
		comp.focus()
	}
	if(retval)
	{
		//callDateFunction(comp)
	}
	return retval
}

function CompDates(dat1,dat2)
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
}

function chkTime(time1)
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

function checkDt(date1)
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
}

function fetchResult(obj)
{
	var val = obj.value;
	if((val != "")) //&& (val1 !=""))
	{
	   var appl_user = document.forms[0].appl_user_id.value;
	parent.frames[1].location.href="../../eFM/jsp/FMIPGeneratePullListResult.jsp?fs_locn_code="+val+"&appl_user="+appl_user;
		parent.frames[2].location.href="../../eFM/jsp/FMIPGeneratePullListNote.jsp";
		var msg="";
		parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
		
	}
	else
	{
		parent.frames[1].location.href="../../eCommon/html/blank.html";
		parent.frames[2].location.href="../../eCommon/html/blank.html";
		var msg=getMessage("FILE_STORAGE_NOT_BLANK","FM");
		parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
		return false;
	}
}

function subForm()
{
	document.forms[0].appl_user_id.value = appl_user_id;

	document.forms[0].method='post';
	document.forms[0].action='../../servlet/eFM.FMIPGeneratePullingListServlet';
	document.forms[0].target=parent.parent.frames[2].name;
	document.forms[0].submit();		
}


function onSuccess()
{    

	parent.frames[2].frames[1].frames[2].location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].frames[0].location.href='../../eFM/jsp/FMIPGeneratePullListCriteria.jsp';
}

function valChkDate(from,to,till) 
{
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	var tilldate = till.value ;
	if(fromdate.length > 0 && todate.length > 0 ) 
	{
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		tillarray = tilldate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		var tilldt = new Date(tillarray[2],tillarray[1],tillarray[0]);
		
		if (!parent.frames[1].isAfterNow(todate,"DMY",localeName))
		{
			var error = getMessage("BOOK_DATE_NOT_LESS_CURRDATE","FM");
			parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num="+error;
			to.focus();
			to.select();
			return false;
		}
		/*if(Date.parse(todt) < Date.parse(fromdt)) 
		{
			var error = getMessage("BOOK_DATE_NOT_LESS_CURRDATE","FM");
			parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num="+error;
			to.focus();
			to.select();
			return false;
		}
		else if(Date.parse(todt) > Date.parse(tilldt)) 
		{	if(Date.parse(fromdt) != Date.parse(tilldt))
			{
			var error = getMessage("BOOK_DATE_NOT_GRT_CURRDATE","FM");
			parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num="+error;
			to.focus();
			to.select();
			return false;
			}
		}*/
		else if(Date.parse(todt) >= Date.parse(fromdt)) 
		{
			parent.frames[1].document.forms[0].to_appt_date_disp.value=todate;
			parent.frames[1].document.forms[0].to_appt_date.value=todate;
			parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num=";
			return true;
		}
	}	
	return true;
	
}

function generateFunc()
{

//		var p_preferred_date		 = document.forms[0].fm_preferred_date.value; //Commented by Shanthi for IN031173 on 22.02.2012 
// IN031173 by Shanthi on 22.02.2012  -- Begin
		if(localeName=="en"){
			var p_preferred_date=document.forms[0].fm_preferred_date.value;	
		}else{
			var p_preferred_date = convertDate(document.forms[0].fm_preferred_date.value,"DMY",localeName,"en");	
		}
// IN031173 -- End
		var p_fm_nursing_unit_code = document.forms[0].fm_nursing_unit_code.value;
		var p_to_nursing_unit_code = document.forms[0].to_nursing_unit_code.value;
		var p_fm_pract_id	 = document.forms[0].fm_pract_id.value;
		var p_to_pract_id	 = document.forms[0].to_pract_id.value;

		var p_fs_locn_code	 = parent.frames[0].document.forms[0].fs_locn_code.value;
		var p_gender	 = parent.frames[1].document.forms[0].p_gender.value;
		var print_req_slip  = document.forms[0].print_req_slip.value; 
			
		if(document.forms[0].print_req_slip.checked==true)
	   {
       document.forms[0].print_req_slip1.value='Y';
		  }else{
          document.forms[0].print_req_slip1.value='N';
	  }
		
		if(parent.frames[2].valChkDate(document.forms[0].sysdate,document.forms[0].fm_preferred_date,document.forms[0].sys_date))
        if (p_preferred_date=="")
        {
			var error = getMessage('CAN_NOT_BE_BLANK','common');
			error = error.replace('$', getLabel('Common.BookingDate.label','common'));
			parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num="+error;
          
		}
       else
	{

		var p_pull_type = document.forms[0].print_pull_list_type.value;
		if( parent.frames[2].CheckString( getLabel('Common.NursingUnitCode.label','common'), document.forms[0].fm_nursing_unit_code,document.forms[0].to_nursing_unit_code, parent.parent.frames[2] )  )	
		if( parent.frames[2].CheckString(getLabel('Common.practitionerid.label','common'), document.forms[0].fm_pract_id,document.forms[0].to_pract_id, parent.parent.frames[2] )  )			
			{ 
				HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' 	action='../../eFM/jsp/FMIPGeneratePullListConfirm.jsp'><input name='p_preferred_date' id='p_preferred_date' type='hidden' value='"+p_preferred_date+"'><input name='p_fm_nursing_unit_code' id='p_fm_nursing_unit_code' type='hidden' value='"+p_fm_nursing_unit_code+"'><input name='p_to_nursing_unit_code' id='p_to_nursing_unit_code' type='hidden' value='"+p_to_nursing_unit_code+"'><input name='p_fm_pract_id' id='p_fm_pract_id' type='hidden' value='"+p_fm_pract_id+"'><input name='p_to_pract_id' id='p_to_pract_id' type='hidden' value='"+p_to_pract_id+"'><input name='p_gender' id='p_gender' type='hidden' value='"+p_gender+"'><input name='p_fs_locn_code' id='p_fs_locn_code' type='hidden' value='"+p_fs_locn_code+"'><input name='p_pull_type' id='p_pull_type' type='hidden' value='"+p_pull_type+"'></form></BODY></HTML>";
				
				parent.parent.frames[2].document.write(HTMLVal);
				parent.parent.frames[2].document.form1.submit();
				parent.frames[1].document.forms[0].generate.disabled=true;
			}
	}

}

function chngnursing_unit(obj)
{
 if (obj.name=="fm_nursing_unit_code")
 parent.frames[1].document.forms[0].to_nursing_unit_code.value=obj.value;
 if (obj.name=="fm_pract_id")
   parent.frames[1].document.forms[0].to_pract_id.value=obj.value;

}

function assignvalue(obj){
        if (obj.checked==true)
			obj.value='Y';
		else
		obj.value='N';
	}    
function chng_appt_date(obj)

	{		if(obj.value == 'A')
			{
				document.forms[0].p_order_term.value = '';
				document.getElementById("ordID").innerHTML	     = "&nbsp;";
			}
			else if(obj.value == 'T')
			{
				document.getElementById("ordID").innerHTML = "<select name='p_order_term' id='p_order_term'><option value='asc' selected>" + getLabel('Common.ascending.label','common')+ "</option><option value='desc'>"+getLabel('Common.descending.label','common')+"</option></select>";	
			}
           if (obj.value=='M')
			{
			//commented on 16/3/2006 to allow to select any date within the param period
			//	document.forms[0].fm_preferred_date.value   =document.forms[0].sys_date.value;
			//	document.forms[0].fm_preferred_date.readOnly=true;
			//	document.getElementById("calend").style.display="none";
			document.forms[0].fm_preferred_date.readOnly=false;
			document.getElementById("calend").style.display="inline";
			document.getElementById("calend").style.visibility="visible";

			}
			else
			{
				document.forms[0].fm_preferred_date.readOnly=false;
				document.getElementById("calend").style.display="inline";
				document.getElementById("calend").style.visibility="visible";
			}

	 }
function EnableDisableBox(obj,getVal)
	{
			if (obj.checked==true)
			{
				obj.value='Y';
				if (getVal=='G')
				{
					document.forms[0].order_by_pull_list.disabled=false;
					if(document.forms[0].print_tel_no) {
						document.forms[0].print_tel_no.checked=false;
						document.forms[0].print_tel_no.disabled=false;
					}
					if(document.forms[0].print_bar_code) {
						document.forms[0].print_bar_code.checked=false;
						document.forms[0].print_bar_code.disabled=false;
					}

				}
				else
				{
					document.forms[0].gen_tracer.value="Y";
				}


			}
			else
			{
				obj.value='N';
				if (getVal=='G')
				{
					document.forms[0].order_by_pull_list.disabled=true;
					if(document.forms[0].print_tel_no) {
						document.forms[0].print_tel_no.checked=false;
						document.forms[0].print_tel_no.disabled=true;
					}
					if(document.forms[0].print_bar_code) {
						document.forms[0].print_bar_code.checked=false;
						document.forms[0].print_bar_code.disabled=true;
					}
				}
				else
				{
					document.forms[0].gen_tracer.value="N";
				}
					
			}
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
				var dispDescFirst="dispDescFirst";			
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


	function doOnlineReportPrinting(msg,fm_preferred_date,to_preferred_date,fm_nursing_unit_code,to_nursing_unit_code,fm_pract_id,to_pract_id,p_gender,pull_list_yn,fs_locn_code,appl_user_id,p_gen_report,print_tel_no,print_bar_code,gen_tracer,operation_type,order_by_pull_list,print_pull_list_type,p_order_term,p_pull_list_seq,p_print_req_slip)
	{

   parent.frames[1].document.forms[0].generate.disabled=false;
	 var flag="Generate IP Pulling List";
	   parent.parent.frames[2].location.href="../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=1";
	   HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' 	action='../eFM/jsp/FMIPGeneratePullListConfirm.jsp'><input name='fm_preferred_date' id='fm_preferred_date' type='hidden' value='"+fm_preferred_date+"'><input name='to_preferred_date' id='to_preferred_date' type='hidden' value='"+to_preferred_date+"'><input name='fm_nursing_unit_code' id='fm_nursing_unit_code' type='hidden' value='"+fm_nursing_unit_code+"'><input name='to_nursing_unit_code' id='to_nursing_unit_code' type='hidden' value='"+to_nursing_unit_code+"'><input name='fm_pract_id' id='fm_pract_id' type='hidden' value='"+fm_pract_id+"'><input name='to_pract_id' id='to_pract_id' type='hidden' value='"+to_pract_id+"'><input name='p_gender' id='p_gender' type='hidden' value='"+p_gender+"'><input name='pull_list_yn' id='pull_list_yn' type='hidden' value='"+pull_list_yn+"'><input name='fs_locn_code' id='fs_locn_code' type='hidden' value='"+fs_locn_code+"'><input name='appl_user_id' id='appl_user_id' type='hidden' value='"+appl_user_id+"'><input name='p_gen_report' id='p_gen_report' type='hidden' value='"+p_gen_report+"'><input name='print_tel_no' id='print_tel_no' type='hidden' value='"+print_tel_no+"'><input name='print_bar_code' id='print_bar_code' type='hidden' value='"+print_bar_code+"'><input name='gen_tracer' id='gen_tracer' type='hidden' value='"+gen_tracer+"'><input name='operation_type' id='operation_type' type='hidden' value='"+operation_type+"'><input name='order_by_pull_list' id='order_by_pull_list' type='hidden' value='"+order_by_pull_list+"'><input name='print_pull_list_type' id='print_pull_list_type' type='hidden' value='"+print_pull_list_type+"'><input name='p_order_term' id='p_order_term' type='hidden' value='"+p_order_term+"'><input name='p_print_req_slip' id='p_print_req_slip' type='hidden' value='"+p_print_req_slip+"'><input name='flag' id='flag' type='hidden' value='"+flag+"'><input name='p_pull_list_seq' id='p_pull_list_seq' type='hidden' value='"+p_pull_list_seq+"'></form></BODY></HTML>";
		parent.parent.frames[3].document.write(HTMLVal);
		parent.parent.frames[3].document.form1.submit();
       
  }  

 

