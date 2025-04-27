function apply()
{
	var chk_val	= "";
	
	if(parent.frames[2].frames[1].frames[1].document.forms[0])
	{
		chk_val = f_query_add_mod.frames[1].document.forms[0].return_date_time.value;
		var fields = new Array(parent.frames[2].frames[1].frames[1].document.forms[0].return_date_time);
		var names = new Array(getLabel("Common.returndatetime.label","common"));
		if(checkFields( fields, names, messageFrame))
		{
			var from	 = f_query_add_mod.frames[1].document.forms[0].return_date_time;
			var to		 = f_query_add_mod.frames[1].document.forms[0].iss_date_time;
			var sys_date = f_query_add_mod.frames[1].document.forms[0].sys_date;
			if(ValidateDateTime1(from,to,sys_date))
			{
				if(CheckMaxLen(getLabel("Common.remarks.label","common"),parent.frames[2].frames[1].frames[1].document.forms[0].remarks,100,parent.parent.frames[2].frames[2]))
				{
					parent.frames[2].frames[1].frames[1].document.forms[0].method='post';
					parent.frames[2].frames[1].frames[1].document.forms[0].action='../../servlet/eFM.FMChangeReturnDateServlet';
					parent.frames[2].frames[1].frames[1].document.forms[0].target='messageFrame';
					parent.frames[2].frames[1].frames[1].document.forms[0].submit();
				}
			}
			else
			{
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
			}
		}
	}
	else
	{
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	}
}
function ValidateDateTime1(from,to,sys_date)
{
	
	var from1=from.value;
	if(parent.frames[2].frames[1].frames[1].validDate(from1,"DMYHM",localeName))
	{
		if(!parent.frames[2].frames[1].frames[1].isAfterNow(from1,"DMYHM", localeName))
		{
		  alert(getMessage("RETURN_DATE_NOT_LESS_SYSDATE",'FM'));
			from.focus();
			from.select();
			return false;
		}
		else
			return true;
	}
	else
	{
		var msg = getMessage('FM_INVALID_DATE_TIME','FM');
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		from.focus();
		from.select();
		return false;
	}

	
	/*var obj=from;
	if(from.value!="")
	{
		if(doDateTimeChk(from))
		{
			from = from.value
			to		= to.value
			sys_date =	sys_date.value
			
			var a     =  from.split(" ")
			splitdate = a[0];
			splittime = a[1]

			var splitdate1 =a[0].split("/")
			var splittime1= a[1].split(":")

			var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
			if(to != '')
			{
				a=  to.split(" ")
				splitdate=a[0];
				splittime=a[1]

				splitdate1 =a[0].split("/")
				splittime1= a[1].split(":")

				var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
			}			
			a= sys_date.split(" ")
			splitdate=a[0];
			splittime=a[1]

			splitdate1 =a[0].split("/")
			splittime1= a[1].split(":")

			var sys_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1]), eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
			if(Date.parse(from_date) >= Date.parse(sys_date))
			{
				var msg = "";
				messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
				return true;
			}
			else
			{
				var msg = getMessage('RETURN_DATE_NOT_LESS_SYSDATE','FM');
				alert(msg);
				obj.focus();
				obj.select();
				messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
				return false;
			}
		}
		else if(doDateTimeChk(from)== false)
		{
			return false;	
		}
	}*/
}
/*function doDateTimeChk(obj)
{
	var comp=obj
	obj=obj.value
	var dttime = obj.split(" ");
	var dt
	var time
	var retval=true
	if(dttime.length>1)
	{
		dt=dttime[0]
		time=dttime[1]
		if(!checkDt(dt) )
		{
			retval= false
		}
		else
		{
			if(time==null || time=="")
			{
				retval= false;
			}
			else
			{
				if(!chkTime(time))
				{
					retval= false
				}
			}
		}
	}
	else
	{
		retval= false
	}
	if(retval)
	{
		//callDateFunction(comp)
	}
	else
	{
		var msg = getMessage('FM_INVALID_DATE_TIME','FM');
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		comp.focus();
		comp.select();
	}
	return retval
}*/
function fetchResults(val)
{
 var obj=val;
 var patient_id="";
 var filenum="";
 var volume_no="";
 var to_proceed=true;
	var file_type_appl_yn = FMChFileRetDateCriteriaForm.file_type_appl_yn.value;	
	var doc_or_file = FMChFileRetDateCriteriaForm.maintain_doc_or_file.value;
	if(doc_or_file == 'D')
	{
		var fields = new Array ( FMChFileRetDateCriteriaForm.p_curr_fs_loc,FMChFileRetDateCriteriaForm.doc_folder_id,FMChFileRetDateCriteriaForm.doc_type_id);
		var issfsloc= getLabel("Common.Issue.label","Common") + getLabel("eFM.FSLocation.label","FM");
		var names = new Array ( issfsloc, getLabel("eFM.DocumentFolder.label","FM"), getLabel("Common.documenttype.label","common"));	
	}
	else if(doc_or_file == 'F')
	{
		if(file_type_appl_yn == 'N')
		{
			var fields = new Array ( FMChFileRetDateCriteriaForm.p_curr_fs_loc,FMChFileRetDateCriteriaForm.patient_id,FMChFileRetDateCriteriaForm.file_no,FMChFileRetDateCriteriaForm.volume_no);
			var issfsloc= getLabel("Common.Issue.label","Common") + getLabel("eFM.FSLocation.label","FM");
			var names = new Array ( issfsloc , getLabel("Common.patientId.label","common"), getLabel("Common.fileno.label","common"),getLabel("eFM.VolumeNo.label","FM"));	
		}
		else if(file_type_appl_yn == 'Y')
		{
			var fields = new Array ( FMChFileRetDateCriteriaForm.p_curr_fs_loc,FMChFileRetDateCriteriaForm.patient_id,FMChFileRetDateCriteriaForm.patient_file_type,FMChFileRetDateCriteriaForm.volume_no);
			var issfsloc= getLabel("Common.Issue.label","Common") + getLabel("eFM.FSLocation.label","FM");
			var names = new Array ( issfsloc , getLabel("Common.patientId.label","common"), getLabel("Common.filetype.label","common"),getLabel("eFM.VolumeNo.label","FM"));	
		}
	}
	
	var errors = "";
	for( var i=0; i<fields.length; i++ ) 
	{
		if(trimCheck(fields[i].value)) 
		{
			fields[i].value = trimString(fields[i].value);
		}
		else	
		{	
			//errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
			errors=errors + getMessage("CAN_NOT_BE_BLANK","common") + "<br>";
			errors=errors.replace('$',names[i]);
		}
	}
	if ( errors.length != 0 ) 
	{
		parent.parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		to_proceed = false;
		return false ;
	}
	var whereClause="and";
	var selectClause="";
	var strand = "";
	var empty = 0;
	var count_sql = "";
	var i=0;
	
	if(obj=='search')
	{
		if(doc_or_file == 'D')
		{
			var fields = new Array(FMChFileRetDateCriteriaForm.file_no, FMChFileRetDateCriteriaForm.patient_id,FMChFileRetDateCriteriaForm.patient_file_type);
		}
		else if(doc_or_file == 'F')
		{
		if(file_type_appl_yn == 'N')
		{
			var fields = new Array(FMChFileRetDateCriteriaForm.file_no, FMChFileRetDateCriteriaForm.patient_id,FMChFileRetDateCriteriaForm.volume_no);
		}
		else if(file_type_appl_yn == 'Y')
		{
			var fields = new Array(FMChFileRetDateCriteriaForm.file_no, FMChFileRetDateCriteriaForm.patient_id,FMChFileRetDateCriteriaForm.volume_no,FMChFileRetDateCriteriaForm.patient_file_type);
		}
		}
	}
	
	  patient_id=FMChFileRetDateCriteriaForm.patient_id.value;
	  filenum=FMChFileRetDateCriteriaForm.file_no.value;
	  volume_no=FMChFileRetDateCriteriaForm.volume_no.value;
	
	for(i=0;i<fields.length;i++) 
	{
		if(fields[i] != null)
		{
			if(trimCheck(fields[i].value))  empty++;
		}
	}
	if(empty != 0) 
	{
		flag=true;
		if(fields[0] != null)
        {
			if(trimCheck(fields[0].value)) 
			{
				whereClause = whereClause + " file_no = trim('" + fields[0].value + "') and ";
			}
		}
		if(fields[1] != null)
        {
			if( trimCheck(fields[1].value)) 
			{
				whereClause = whereClause + " patient_id = trim('" + fields[1].value + "') and ";
			}
		}
		if(doc_or_file != 'D')
		{
			if(fields[2] != null)
			{
				if(trimCheck(fields[2].value)) 
				{
					whereClause = whereClause + " volume_no = trim('" + fields[2].value + "') and ";
				}
			}
		}
		if(file_type_appl_yn == 'Y')
		{
			if(fields[3] != null)
			{
				if(trimCheck(fields[3].value)) 
				{
					whereClause = whereClause + " file_type_code = trim('" + fields[3].value + "') and ";
				}
			}
		}
		var p_curr_fs_loc = FMChFileRetDateCriteriaForm.p_curr_fs_loc.value;
		var user_id		  = FMChFileRetDateCriteriaForm.user_id.value;	
		//whereClause = whereClause + " mr_pat_fs_locn_code = trim('" + p_curr_fs_loc+ "') and ";
		whereClause = whereClause + " PERM_FS_LOCN_CODE = trim('" + p_curr_fs_loc+ "') and ";

		whereClause = whereClause + strand;
		var replace_url		= 	/%/g ;
		whereClause   	= whereClause.replace(replace_url,"~" );
		if(whereClause.lastIndexOf("and") != -1)
		whereClause = whereClause.substring(0,whereClause.lastIndexOf("and"));

		var user_security_yn = document.forms[0].user_security_yn.value;			
		var p_access_all	 = document.forms[0].p_access_all.value;			
		var sysDate			 = document.forms[0].sysDate.value;			
				
		if(obj=='search')
		{
			FMChFileRetDateCriteriaForm.search_dtl.disabled=true;
			FMChFileRetDateCriteriaForm.reset1.disabled=true;
			if(doc_or_file != 'D')
			{
				FMChFileRetDateCriteriaForm.pat_search.disabled=true;
			}
			FMChFileRetDateCriteriaForm.p_curr_fs_loc.disabled=true;
			
			if(doc_or_file == 'D')
			{
				parent.FMChFileRetDateResultFrame.location.href='../../eFM/jsp/DTChFileRetDateResult.jsp?whereClause='+whereClause+'&user_security_yn='+user_security_yn+'&p_access_all='+p_access_all+'&sysDate='+sysDate+'&patient_id='+patient_id+'&filenum='+filenum+'&volume_no='+volume_no+'&user_id='+user_id;
			}
			else if(doc_or_file == 'F')
			{
				parent.FMChFileRetDateResultFrame.location.href='../../eFM/jsp/FMChFileRetDateResult.jsp?whereClause='+whereClause+'&user_security_yn='+user_security_yn+'&p_access_all='+p_access_all+'&sysDate='+sysDate+'&patient_id='+patient_id+'&filenum='+filenum+'&volume_no='+volume_no+'&user_id='+user_id;
			}
			parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
		}
		return true;
	}
	else
	{
		if(doc_or_file == 'D')
		{
		var msg =	getMessage('DOC_CAN_NOT_BE_BLANK','FM');
		}
		else if(doc_or_file == 'F')
		{
		var msg =	getMessage('FILE_CAN_NOT_BE_BLANK','FM');
		}
		if(msg!="")
		{
			parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
			return false;
		}
	}
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
				if(time1min>60)
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
function checkFileNo(obj)
{
	obj.value = obj.value.toUpperCase();

	var file_no=obj.value;
	if(file_no != "")
	{
		var HTMLVal="<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='FMCheckFileNo' id='FMCheckFileNo' method='post' action='../../eFM/jsp/FMCheckFileNumber.jsp'>"+
		"<input type='hidden' name='file_no' id='file_no' value='"+file_no+"'>"+
		"</form></body></html>";
		parent.parent.messageFrame.document.write( HTMLVal);
		parent.parent.messageFrame.document.FMCheckFileNo.submit();
	}
}
async function showNonValidRec()
{
	var retVal;
	var dialogHeight ='15' ;
	var dialogWidth = '48' ;
	var dialogTop = '185' ;
	var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no';
	var arguments;
	var patient_id = document.forms[0].patient_id.value;	

	retVal =await window.showModalDialog('../../eFM/jsp/FMNonValidRecsMain.jsp?patient_id='+patient_id,arguments,features);
}
///************** JS functions of FMChRetDateCriteria.jsp  *********************//

async function searchCode(target,facilityid)
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
			
	tit=getLabel("Common.user.label","common");
	sql="select APPL_USER_ID, APPL_USER_NAME from SM_FACILITY_FOR_USER_VW where facility_id=`"+facilityid+"` ";
	search_code="APPL_USER_ID";
	search_desc= "APPL_USER_NAME";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit)+"&dispDescFirst=dispDescFirst",arguments,features);

	var arr=new Array();
	if(!(retVal == null))
	{
		var retVal=unescape(retVal);
	    arr=retVal.split("::");

	    document.forms[0].appl_user_id1.value=arr[0];
		document.forms[0].appl_user_id.value=arr[1];
	}
}
///////************** End of  JS functions of FMChRetDateCriteria.jsp **************************//
/*function checkPatientID(obj)
{
	var patient_id=obj.value;
	if(patient_id != "")
	{
		var HTMLVal="<html><body><form name='FMValidatePatientID' id='FMValidatePatientID' method='post' action='../../eFM/jsp/FMValidatePatientID.jsp'>"+
		"<input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'>"+
		"</form></body></html>";
		parent.parent.messageFrame.document.write( HTMLVal);
		parent.parent.messageFrame.document.FMValidatePatientID.submit();
	}
}*/
function onSuccess()
{
	parent.frames[2].frames[1].location.reload();
	//var messag="APP-SM0001 Operation Completed Successfully ....";
	var message=getMessage("RECORD_INSERTED","SM");
	parent.frames[2].frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+message ;
	//messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';

	/*parent.frames[1].frames[1].frames[0].location.href='../../eFM/jsp/FMChFileRetDateCriteria.jsp';
	parent.frames[1].frames[1].frames[1].location.href='../../eCommon/html/blank.html';*/
}
function reset()
{
	parent.frames[2].frames[1].location.reload();
	parent.frames[2].frames[2].location.href='../../eCommon/html/blank.html';
	messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
}
function clearAll()
{
	parent.FMChFileRetDateResultFrame.location.href='../../eCommon/html/blank.html';
	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
}
function clearvalue(obj)
{
FMChFileRetDateCriteriaForm.patient_id.value="";
FMChFileRetDateCriteriaForm.patient_id.onblur();

}

	/*Below line added for this CRF HSA-CRF-0306.1*/

function holidayvalidation(facility_id,fileno,volume_no,Patient_Id,strLocn)
{              
	var retdate=document.FMChFileRetDateResultFrame.return_date_time; 
	 
	var obj1 = eval(retdate); 
    var localeName=document.FMChFileRetDateResultFrame.localeName.value;	
	var returndate =obj1.value ;	
	
	var strDate1;
	if(returndate.length>0 && returndate.length==16)
	{
	   returndate=returndate.substring(0,10);
	   strDate1=convertDate(returndate,"DMY",localeName,"en");
			
			   var xmlDoc = "";
				var xmlHttp = new XMLHttpRequest();
				xmlStr ="<root><SEARCH steps='Holiday_Date_Check' facility_id=\""+facility_id+"\" fileno=\""+fileno+"\" volume_no=\""+volume_no+"\" Patient_Id=\""+Patient_Id+"\" strLocn=\""+strLocn+"\" retdate=\""+strDate1+"\" /></root>";
				
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","FMConfirmPullingListConfirmAll.jsp",false);
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				responseText = trimString(responseText);  	
				eval(responseText); 
               			
				if(flag=="1")	
				{
						var error = getMessage('DATE_ALREADY_HOLIDAY','FM');                      
						var str1="''";						
					    var strDate2=str1.concat(strDate1).concat(str1); 
                        error = error.replace('#',strDate2);					   
						alert(error);
						
						document.FMChFileRetDateResultFrame.return_date_time.value="";
						document.FMChFileRetDateResultFrame.return_date_time.focus();
					
					//tosubmit=false;
				}//else
				//{
				//tosubmit=true;
				//}
	
          }
}

