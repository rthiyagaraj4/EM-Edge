/*
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      		Name        		Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
10/07/2017	IN061903			Krishna Gowtham J 			10/07/2017		Ramesh G		ML-MMOH-CRF-0555		
------------------------------------------------------------------------------------------------------------------------------------------------------
*/
function create()
{
	f_query_add_mod.location.href="../../eCA/jsp/TaskForRespRelnMain.jsp";
}


function query(){
	f_query_add_mod.location.href='../../eCA/jsp/QueryCriteriaTaskForResp.jsp';
}


function apply()
{
	var msg="";
	var fldName="";
	if(f_query_add_mod.frameTaskForRespRelnHdr != undefined)
	{
	if(f_query_add_mod.frameTaskForRespRelnHdr.document.formTaskForRespRelnHdr.group_by.value=="")
	{	
		  msg =getMessage("GROUPBY_NOT_BLANK",'CA');
		  messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
		return false;
	}
	else
	{
        var group_by_code = f_query_add_mod.frameTaskForRespRelnDtl.document.formTaskForRespRelnDtl.grp_by_desc.value;
		var group_by_task = f_query_add_mod.frameTaskForRespRelnHdr.document.formTaskForRespRelnHdr.group_by.value;
		if(group_by_code == "")
		{
			if(group_by_task == "TS")
              fldName = getLabel("Common.Task.label","Common");
            else if(group_by_task == "RS")
		      fldName = getLabel("Common.responsibility.label","Common");
            else if(group_by_task == "RL")
		      fldName = getLabel("Common.relationship.label","Common");
			msg = getMessage("CAN_NOT_BE_BLANK","Common");
		    msg = msg.replace('$', fldName);
		    messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
		    return false;
          
		}
		if( f_query_add_mod.frameTaskForRespRelnResult.document.forms[0]==null)
		{
			commontoolbarFrame.location.reload();
			return false
		}
		else
			var from = f_query_add_mod.frameTaskForRespRelnResult.document.formTaskRespRelnResult.fm_disp.value;
		
		var to = f_query_add_mod.frameTaskForRespRelnResult.document.formTaskRespRelnResult.to_disp.value;
		var row_count = f_query_add_mod.frameTaskForRespRelnResult.document.formTaskRespRelnResult.row_count.value;
		f_query_add_mod.frameTaskForRespRelnDtl.document.formTaskForRespRelnDtl.from.value = from;
		f_query_add_mod.frameTaskForRespRelnDtl.document.formTaskForRespRelnDtl.to.value = to;
		f_query_add_mod.frameTaskForRespRelnDtl.document.formTaskForRespRelnDtl.row_count.value = row_count;

		var formResultObj = f_query_add_mod.frameTaskForRespRelnResult.document.formTaskRespRelnResult;
		var group_by = f_query_add_mod.frameTaskForRespRelnHdr.document.formTaskForRespRelnHdr.group_by.value;
		var group_by_desc = f_query_add_mod.frameTaskForRespRelnDtl.document.formTaskForRespRelnDtl.grp_by_code.value;
		var optionValStr = "", listValue = "", listName = "",access_rights="",listdesc="";

		for (i=from; i<=to; i++)
		{
			listValue = eval("formResultObj.select_yn"+i+".value");
			listName  = eval("formResultObj.select_yn"+i+".name");			
			listdesc  = eval("formResultObj.description"+i+".value");//This line added by channaveer B for crf MO-CRF-0033
			//below block added by channaveer B for crf MO-CRF-33
			//IN061903 start
			//if(group_by == "TS" && (group_by_desc == "AMEND_ORDER" || group_by_desc == "CANCEL_ORDER" || group_by_desc == "DISCONTINUE" || group_by_desc == "HOLD")){
			if(group_by == "TS" && (group_by_desc == "AMEND_ORDER" || group_by_desc == "CANCEL_ORDER" || group_by_desc == "DISCONTINUE" || group_by_desc == "HOLD" || group_by_desc == "NOTDONE")){
			//IN061903 ends
			access_rights=eval("formResultObj.access_rights"+i+".value");
			if(access_rights == ""){
            access_rights = "NA";
			}	
			}
			//IN061903 start
			//else if((group_by == "RS" || group_by == "RL") && (listdesc == "AMEND_ORDER" || listdesc == "CANCEL_ORDER" || listdesc == "HOLD" || listdesc == "DISCONTINUE") ){
			else if((group_by == "RS" || group_by == "RL") && (listdesc == "AMEND_ORDER" || listdesc == "CANCEL_ORDER" || listdesc == "HOLD" || listdesc == "DISCONTINUE" || listdesc == "NOTDONE") ){
			//IN061903 ends	
			access_rights=eval("formResultObj.access_rights"+i+".value");
			if(access_rights == ""){
            access_rights = "NA";
			}
            }
			else {
			access_rights = "N";
			}
			//ENDS HERE
			if(listValue == "") 
				listValue = "0";
			
			//optionValStr += listName +"||"+listValue+"~";commented by channaveer B for crf MO-CRF-33
			optionValStr += listName +"||"+access_rights+"||"+listValue+"~";//Added by channaveer B for crf MO-CRF-33
		}

		f_query_add_mod.frameTaskForRespRelnDtl.document.formTaskForRespRelnDtl.optionValStr.value = optionValStr;
		f_query_add_mod.frameTaskForRespRelnDtl.document.forms[0].action="../../servlet/eCA.TaskForRespServlet";
		f_query_add_mod.frameTaskForRespRelnDtl.document.formTaskForRespRelnDtl.target="messageFrame";
		f_query_add_mod.frameTaskForRespRelnDtl.document.formTaskForRespRelnDtl.method="post";
		f_query_add_mod.frameTaskForRespRelnDtl.document.formTaskForRespRelnDtl.submit();

	}
  }
  else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}
}

function onSuccess()
{
	f_query_add_mod.location.reload();
}


function reset()
{
	f_query_add_mod.location.reload();
}


function fetchDetailsRecords(obj)
{
	var val = obj.value;
	var msg = "";

	if(val != "")
	{
		parent.frameTaskForRespRelnDtl.location.href="../../eCA/jsp/TaskForRespRelnDtl.jsp?group_by="+val;
		parent.frameTaskForRespRelnResult.location.href="../../eCommon/html/blank.html";
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	}
	else if(val == "")
	{
		parent.frameTaskForRespRelnDtl.location.href="../../eCommon/html/blank.html";
		parent.frameTaskForRespRelnResult.location.href="../../eCommon/html/blank.html";
		parent.parent.messageFrame.location.href="../../eCommon/html/blank.html";
		//msg = getMessage("GROUPBY_NOT_BLANK",'CA');Commented By Channaveer B on 05/07/2010.
		//parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";Commented By Channaveer B on 05/07/2010.
		return false;
	}
}

function fetchResults(){
	
	var group_by			= parent.frameTaskForRespRelnHdr.formTaskForRespRelnHdr.group_by.value;
	var	grp_by_code			= parent.frameTaskForRespRelnDtl.formTaskForRespRelnDtl.grp_by_code.value;
	var	grp_by_desc			= parent.frameTaskForRespRelnDtl.formTaskForRespRelnDtl.grp_by_desc.value;
	var dtl_grp_by_code		="";
	var fldName = "";
	var msg = "";

	if(group_by == "TS")

		fldName = getLabel("Common.Task.label","Common");

	else if(group_by == "RS")
		fldName = getLabel("Common.responsibility.label","Common");

	else if(group_by == "RL")
		fldName = getLabel("Common.relationship.label","Common");
		

	if(group_by != "" && grp_by_desc != ""){
		if(parent.frameTaskForRespRelnDtl.formTaskForRespRelnDtl.dtl_grp_by_code){
			if(parent.frameTaskForRespRelnDtl.formTaskForRespRelnDtl.dtl_grp_by_code[0].checked){
				dtl_grp_by_code		= parent.frameTaskForRespRelnDtl.formTaskForRespRelnDtl.dtl_grp_by_code[0].value;
			}else if(parent.frameTaskForRespRelnDtl.formTaskForRespRelnDtl.dtl_grp_by_code[1].checked){
				dtl_grp_by_code		= parent.frameTaskForRespRelnDtl.formTaskForRespRelnDtl.dtl_grp_by_code[1].value;
			}
		}

		parent.frameTaskForRespRelnResult.location.href="TaskForRespRelnResult.jsp?group_by="+group_by+"&grp_by_code="+grp_by_code+"&dtl_grp_by_code="+dtl_grp_by_code;
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";

	}
	else if(grp_by_desc =="")
	{
		//parent.frameTaskForRespRelnResult.location.href=="../../eCommon/html/blank.html";Commented By Channaveer B on 05/07/2010.
		parent.frameTaskForRespRelnResult.location.href="TaskForRespRelnResult.jsp?group_by="+group_by+"&grp_by_code="+grp_by_desc+"&dtl_grp_by_code="+dtl_grp_by_code;// Added By Channaveer B on 05/07/2010.
		//msg = "APP-000001 "+fldName+" cannot be blank...";
		msg = getMessage("CAN_NOT_BE_BLANK","Common");
		msg = msg.replace('$', fldName);
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
		return false;
	}
}

function checkVal(obj)
{
	document.forms[0].dispMode.value = obj;
	document.forms[0].submit();
}

function validateGrpBy(obj)
{
	if(parent.frameTaskForRespRelnResult.location.href.indexOf(".jsp") != -1)
		parent.frameTaskForRespRelnResult.location.href = "../../eCommon/html/blank.html";
}


function CheckForSpecCharsWithSpaceBlur(ObjText)
{
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*& ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}



function getGroup(groupObject)
{
	if(groupObject.name=='grp_by_desc')
	{
		var target  = formTaskForRespRelnDtl.grp_by_desc;		
		if((target.value) == "null" || (target.value ==""))
		{
			return false;			
		}
		else
		{
			getGroupWindow();
		}
	}
	else if(groupObject.name=='grp_by_desc_search')
	{		
		
		getGroupWindow();
	}
}


async function getGroupWindow()
{		
		var target = "";
		var i = 0;
		var retArray			=  new String();
		var targetObject  = formTaskForRespRelnDtl.grp_by_desc;
		var search_desc	= "";
		var group_by		= formTaskForRespRelnDtl.group_by.value;

		if(group_by == 'RS')
			var title			= getLabel('Common.responsibility.label','COMMON');
		else if(group_by == 'TS')
				var title			= getLabel('Common.Task.label','COMMON');
		else if(group_by == 'RL')
				var title		= getLabel('Common.relationship.label','COMMON');
		else
				var title			= ' ';

		var sql = formTaskForRespRelnDtl.sql_query.value;
		
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = targetObject.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray = await CommonLookup( title,argArray );
		var str =unescape(retArray);
		var arr = str.split(",");
		
		if(retArray != null && retArray !="")	
		{
			document.forms[0].grp_by_desc.value = arr[1];
			document.forms[0].grp_by_code.value = arr[0];
		}
		else
		{
			document.forms[0].grp_by_desc.value = '';
			document.forms[0].grp_by_code.value = ''
		}
}
function clearColumnList(obj)
{	
	var len = obj.options.length ;
	for(var i=0;i<len;i++)
	{
		obj.remove('atc_class_l2_code') ;
	}
	
}
function checkNoteTypeForRes(obj1,obj2, obj3,i)
{	
	var group_by =parent.frameTaskForRespRelnHdr.document.formTaskForRespRelnHdr.group_by.value;			
	var amend_order =document.formTaskRespRelnResult.amend_order.value;
	var cancel_order =document.formTaskRespRelnResult.cancel_order.value;
	var discontinue =document.formTaskRespRelnResult.discontinue.value;
	var hold =document.formTaskRespRelnResult.hold.value;			
	var not_done =document.formTaskRespRelnResult.not_done.value;//IN061903			
	var app_access_rights_obj = "";
	var disable1 = "";
	var enable ="";
	var group_by_desc ="";
	if(obj1.value == ""|| obj1.value == "X" )
	{
		if(group_by == "TS"){
			 group_by_desc =parent.frameTaskForRespRelnDtl.document.formTaskForRespRelnDtl.grp_by_code.value;
			//IN061903 start
			//if(group_by_desc == "AMEND_ORDER" || group_by_desc == "CANCEL_ORDER" || group_by_desc == "DISCONTINUE" || group_by_desc == "HOLD"){	
			if(group_by_desc == "AMEND_ORDER" || group_by_desc == "CANCEL_ORDER" || group_by_desc == "DISCONTINUE" || group_by_desc == "HOLD" || group_by_desc == "NOTDONE"){
			//IN061903 ends
				app_access_rights_obj=eval("document.formTaskRespRelnResult.access_rights"+i+"");
				clearColumnList(app_access_rights_obj);
				var element = document.createElement('OPTION') ;			
					element.value =  "NA" ;
					element.text = getLabel("Common.notapplicable.label","Common");	
					app_access_rights_obj.add(element);		
					app_access_rights_obj.disabled=true;						
			}
		}else if(group_by == "RS" || group_by == "RL"){ 
			 group_by_desc = eval("document.formTaskRespRelnResult.description"+i+".value");
			//IN061903 start
			//if(group_by_desc == "AMEND_ORDER" || group_by_desc == "CANCEL_ORDER" || group_by_desc == "HOLD" || group_by_desc == "DISCONTINUE"){
			if(group_by_desc == "AMEND_ORDER" || group_by_desc == "CANCEL_ORDER" || group_by_desc == "HOLD" || group_by_desc == "DISCONTINUE" || group_by_desc == "NOTDONE"){
			//IN061903 ends
				app_access_rights_obj=eval("document.formTaskRespRelnResult.access_rights"+i+"");
				clearColumnList(app_access_rights_obj);
				var element = document.createElement('OPTION') ;			
					element.value =  "NA" ;
					element.text = getLabel("Common.notapplicable.label","Common");	
					app_access_rights_obj.add(element);		
					app_access_rights_obj.disabled=true;											
		}
	}
	}else
	{
		if(group_by == "TS"){ 
			 group_by_desc =parent.frameTaskForRespRelnDtl.document.formTaskForRespRelnDtl.grp_by_code.value;
			//IN061903 start
			//if(group_by_desc == "AMEND_ORDER" || group_by_desc == "CANCEL_ORDER" || group_by_desc == "DISCONTINUE" || group_by_desc == "HOLD"){
			if(group_by_desc == "AMEND_ORDER" || group_by_desc == "CANCEL_ORDER" || group_by_desc == "DISCONTINUE" || group_by_desc == "HOLD" || group_by_desc == "NOTDONE"){
			//IN061903 ends
				app_access_rights_obj=eval("document.formTaskRespRelnResult.access_rights"+i+"");
				app_access_rights_obj.disabled=false;
				clearColumnList(app_access_rights_obj);
				var element = document.createElement('OPTION') ;			
				element.value =  "ALL" ;
				element.text = getLabel("Common.all.label","Common");	
				app_access_rights_obj.add(element);				
				var element = document.createElement('OPTION') ;
				element.value =  "MO" ;
				element.text = getLabel("eCA.SelfOrder.label","CA");	
				app_access_rights_obj.add(element);		
				var element = document.createElement('OPTION') ;
				element.value =  "MS" ;
				element.text = getLabel("eCA.SelfSpltyOrders.label","CA");	
				app_access_rights_obj.add(element);																							
		   }
		}else if(group_by == "RS" || group_by == "RL")
		{ 
			 group_by_desc = eval("document.formTaskRespRelnResult.description"+i+".value");
			//IN061903 start
			//if(group_by_desc == "AMEND_ORDER" || group_by_desc == "CANCEL_ORDER" || group_by_desc == "HOLD" || group_by_desc == "DISCONTINUE"){
			if(group_by_desc == "AMEND_ORDER" || group_by_desc == "CANCEL_ORDER" || group_by_desc == "HOLD" || group_by_desc == "DISCONTINUE" || group_by_desc == "NOTDONE"){
			//IN061903 ends
				app_access_rights_obj=eval("document.formTaskRespRelnResult.access_rights"+i+"");
				app_access_rights_obj.disabled=false;
				clearColumnList(app_access_rights_obj);
				var element = document.createElement('OPTION') ;			
				element.value =  "ALL" ;
				element.text = getLabel("Common.all.label","Common");	
				app_access_rights_obj.add(element);				
				var element = document.createElement('OPTION') ;
				element.value =  "MO" ;
				element.text = getLabel("eCA.SelfOrder.label","CA");	
				app_access_rights_obj.add(element);		
				var element = document.createElement('OPTION') ;
				element.value =  "MS" ;
				element.text = getLabel("eCA.SelfSpltyOrders.label","CA");	
				app_access_rights_obj.add(element);	
				
			 }
		}
		//IN061903 start
		//if(group_by_desc == "AMEND_ORDER" || group_by_desc == "CANCEL_ORDER" || group_by_desc == "HOLD" || group_by_desc == "DISCONTINUE"){
		if(group_by_desc == "AMEND_ORDER" || group_by_desc == "CANCEL_ORDER" || group_by_desc == "HOLD" || group_by_desc == "DISCONTINUE" || group_by_desc == "NOTDONE"){
		//IN061903 ends
			var len = app_access_rights_obj.options.length ;		
			if (group_by_desc == "AMEND_ORDER"){							
				for(var i=0;i<len;i++)
				{
					if (app_access_rights_obj.options[i].value==amend_order)
					{
						app_access_rights_obj.options[i].selected = true;
					}								
				}
				
			}else if (group_by_desc == "CANCEL_ORDER"){
				for(var i=0;i<len;i++)
				{													
					if (app_access_rights_obj.options[i].value==cancel_order)
					{
						app_access_rights_obj.options[i].selected = true;
					}								
				}
			}else if (group_by_desc == "DISCONTINUE"){
				for(var i=0;i<len;i++)
				{
					if (app_access_rights_obj.options[i].value==discontinue)
					{
						app_access_rights_obj.options[i].selected = true;
					}								
				}
			}else if (group_by_desc == "HOLD"){
				for(var i=0;i<len;i++)
				{
					if (app_access_rights_obj.options[i].value==hold)
					{
						app_access_rights_obj.options[i].selected = true;
					}								
				}						
			}
			//IN061903 start
			else if (group_by_desc == "NOTDONE"){
				for(var i=0;i<len;i++)
				{
					if (app_access_rights_obj.options[i].value==not_done)
					{
						app_access_rights_obj.options[i].selected = true;
					}								
				}						
			}//IN061903 ends
		}
	}
}
