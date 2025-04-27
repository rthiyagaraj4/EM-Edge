function apply()
{
	var appt_date	=	parent.frames[1].frames[1].frames[0].document.forms[0].appt_date.value;
	if(appt_date !="")
	{
		
	//if((parent.frames[1].frames[1].frames[1].location.href.indexOf(".jsp")))
	//{
		var CBValStr	=	parent.frames[1].frames[1].frames[0].document.forms[0].CBValStr.value;

		var fm_cnt		=	parent.frames[1].frames[1].frames[1].document.forms[0].fm_disp.value;
		var to_cnt		=	parent.frames[1].frames[1].frames[1].document.forms[0].to_disp.value;

		for (i=fm_cnt; i<=to_cnt;i++)
		{
			var chk		=	eval("parent.frames[1].frames[1].frames[1].document.forms[0].pull_yn"+i)

			if(chk.checked) 
			{
				if((CBValStr.indexOf(chk.name)) == -1)
					CBValStr += chk.name+"~";
			}
		}
		parent.frames[1].frames[1].frames[0].document.forms[0].CBValStr.value	=	CBValStr;

		//alert("CBValStrfdsfds:"+parent.frames[1].frames[1].frames[0].document.forms[0].CBValStr.value);
	//}
		if(CBValStr != "")
		{
			//alert(parent.frames[1].frames[1].frames[0].document.forms[0].name);
			parent.frames[1].frames[1].frames[0].document.forms[0].method='post';
			parent.frames[1].frames[1].frames[0].document.forms[0].action='../../servlet/eFM.FMRegFilesNotPulledServlet';
			parent.frames[1].frames[1].frames[0].document.forms[0].target='messageFrame';
			parent.frames[1].frames[1].frames[0].document.forms[0].submit();
		}
		else
		{
			var msg=getMessage('VAL_NOT_BLANK');
			if(msg!="")
			{
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
				return false;
			}
		}
	
	}
	else
	{
		//var msg="APP-000001 Appointment Date cannot be blank...";
		var msg=getMessage("CAN_NOT_BE_BLANK","common");
		msg=msg.replace('$',getLabel("Common.apptdate.label","common"));
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
		return false;
	}
	

	//var msg="";
	//messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
	//return false;

}

function fetchResults(obj, obj1)
{
	var obj1_value	=	obj1.value;
	if(obj1_value != "")
	{
		if(validDateObj(obj,"DMY",localeName))
		{
			document.forms[0].CBValStr.value="";
			var appt_date=document.forms[0].appt_date.value;

			if(appt_date !="")
			{
				parent.frames[1].location.href='../../eFM/jsp/FMRegFilesNotPulledResults.jsp?appt_date='+appt_date;
				parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
			}
			else
			{
				//alert("Appt cannot be blank...");
				//var msg="APP-000001 Appointment Date cannot be blank...";
				var msg=getMessage("CAN_NOT_BE_BLANK","common");
				msg=msg.replace('$',getLabel("Common.apptdate.label","common"));
				parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
				//obj.focus();
				//return false;
			}
		}
	}
	else
	{
		//var msg="APP-000001 FS Location cannot be blank...";
		var msg = getMessage("CAN_NOT_BE_BLANK","common");
		msg=msg.replace('$',getLabel("eFM.ToFSLocation.label","FM"));
		parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
	}
}

function dispRecord()
{
	var CBValStr	=	parent.frames[0].document.forms[0].CBValStr.value;

	if(CBValStr != "")
	{
		var val	=	CBValStr.split('~')
		for(i=0; i<val.length; i++)
		{
			var assign	=	val[i];
			if(assign!="")
			{
				if(eval('document.forms[0].'+assign))
				{
					eval('document.forms[0].'+assign+'.checked=true');
				}
			}
		}
	}
}

function CBValue(obj1, obj2)
{
	var count;
	var count1;
	var del_obj=obj1.name;
	var del_chk=obj1.checked;
	var del_locn_obj="fs_locn_code"+obj2;
	var temp_cb_str="";
	var temp_locn_str="";
	var chk_locn=eval('document.forms[0].fs_locn_code'+obj2);

	if(!(del_chk))
	{
		var cbString	= parent.frames[0].document.forms[0].CBValStr.value;
		if(cbString =="")chk_locn.value="";

		var split=cbString.split('~');
		for (i=0; i<(split.length-1); i++)
		{
			if(split[i] != del_obj)
			{
				temp_cb_str += split[i]+"~";
			}
			else
			{
				//eval('document.forms[0].associate_yn'+i+'.value=""');
				temp_cb_str=temp_cb_str;
			}
		}

		cbString=temp_cb_str;
		parent.frames[0].document.forms[0].CBValStr.value=cbString;
	}

}



function checkVal()
{
	var CBValStr	=	parent.frames[0].document.forms[0].CBValStr.value;
	
	var fm_cnt=document.forms[0].fm_disp.value;
	var to_cnt=document.forms[0].to_disp.value;

	for (i=fm_cnt; i<=to_cnt;i++)
	{
		var chk		=	eval("document.forms[0].pull_yn"+i)
		
		if(chk.checked)
		{
			if((CBValStr.indexOf(chk.name)) == -1)
				CBValStr += chk.name+"~";
		}

	}
	parent.frames[0].document.forms[0].CBValStr.value	=	CBValStr;
	
	//alert("After CBValStr   :"+CBValStr);
}

function onSuccess()
{
	parent.frames[1].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[1].frames[1].frames[0].document.forms[0].reset();
}

function searchCode(target,facility_id)
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
			retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}
