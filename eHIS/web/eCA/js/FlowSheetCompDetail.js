/*
------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------
06/02/2017	IN061985		Raja S			06/02/2017		Ramesh G		GHL-SCF-1113
------------------------------------------------------------------------------------------------------------------
*/

function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/FlowSheetCompDetail.jsp?';
}

function apply()
{
	/*if(parent.master_pages.f_query_add_mod.FlowSheetCompDetailCriteria.document.FlowSheetCompCriteriafrm != null)
	{
		var fields = new Array(parent.master_pages.f_query_add_mod.frames[2].document.FlowSheetCompCriteriafrm.history_type,parent.master_pages.f_query_add_mod.frames[2].document.FlowSheetCompCriteriafrm.event_class_id);
		var names = new Array("History Type", "Event Class" );
		if(checkFields( fields, names, messageFrame))
		{
			var flowsheetindex  = parent.frames[1].frames[1].frames[0].document.forms[0].flow_sheet.selectedIndex;
			var flowsheetid = parent.frames[1].frames[1].frames[0].document.forms[0].flow_sheet.options(flowsheetindex).value;
			parent.frames[1].frames[1].frames[1].document.forms[0].flow_sheet_id.value = flowsheetid;
			parent.frames[1].frames[1].frames[1].document.FlowSheetCompDetailResultForm.submit();
		}
	}
	else*/
	
		if(parent.frames[1]!=null)
		{
		if(parent.frames[1].frames[1]!=null)
		{
		if(f_query_add_mod.FlowSheetCompDetail !=null)
		{
		var fields = new Array (f_query_add_mod.FlowSheetCompDetail.document.forms[0].flow_sheet);
		var names = new Array ( getLabel("eCA.FlowSheet.label",'CA') );
		if(( checkFieldsofMst( fields, names, messageFrame)) )
		{
			var flowsheetindex  = f_query_add_mod.FlowSheetCompDetail.document.forms[0].flow_sheet.selectedIndex;
			var flowsheetid = f_query_add_mod.FlowSheetCompDetail.document.forms[0].flow_sheet.options[flowsheetindex].value;
			f_query_add_mod.FlowSheetCompDetailResult.document.forms[0].flow_sheet_id.value = flowsheetid;
			f_query_add_mod.FlowSheetCompDetailResult.document.FlowSheetCompDetailResultForm.submit();
		}
		}
		else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}
		}
		else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
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
function selectEventClass(obj)
{
	parent.frames[3].location.href="../../eCommon/html/blank.html";
	var flowevent = parent.frames[0].document.forms[0].flow_sheet.value;
 
		var hist_type = obj.value;
		var optlength = parent.frames[2].document.forms[0].event_class_id.options.length;

		for (var i=0; i<optlength; i++)
		{
			document.forms[0].event_class_id.options.remove("event_class_id");
		}

		if((hist_type=="") ||(hist_type=="select"))
		{
			var event_class	= '';
			//var short_desc	= '         ---- Select ----         ';
			var short_desc	= '';
			var opt=document.createElement('OPTION');
			opt.text	=	short_desc;
			opt.value	=	event_class;
			document.forms[0].event_class_id.add(opt);
			document.forms[0].event_class_id.selectedIndex = 0;
			//return false;
		}
/******************************************************************************/
		document.forms[0].event_group1.value = '';
		document.forms[0].event_item1.value = '';		
/******************************************************************************/
		var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='EventClassPop' id='EventClassPop' method='post' action='../../eCA/jsp/FlowSheetCompDetailPopEventClass.jsp'>"+
		"<input type='hidden' name='hist_type' id='hist_type' value='"+hist_type+"'>"+
		"</form></body></html>";
		parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
		parent.parent.messageFrame.document.EventClassPop.submit();


}

async function SearchEventGroup(){

	parent.frames[3].location.href="../../eCommon/html/blank.html";

	var his_type = document.forms[0].history_type.value;
	var whereClause = "";

	whereClause = "where hist_rec_type=`"+his_type+"`";

	var retVal = 	new String();
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var tit="Event Group";
	
	var sql=" select EVENT_GROUP,SHORT_DESC SHORT_DESC from CR_CLIN_EVENT_GROUP "+whereClause;
	var search_code="EVENT_GROUP";
	var search_desc="SHORT_DESC";
	var target =parent.frames[2].document.forms[0].event_group1;
	
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
	
	var arr=new Array();
	if (!(retVal == null))
	{
		var retVal=unescape(retVal);
		arr=retVal.split("::");
		
		parent.frames[2].document.forms[0].event_group.value=arr[1];
		parent.frames[2].document.forms[0].event_group1.value=arr[0];
	}
	else
	{
		parent.frames[2].document.forms[0].event_group.value='';
		parent.frames[2].document.forms[0].event_group1.value='';
		target.focus();
	}
}

async function SearchEventItem()
{
	parent.frames[3].location.href="../../eCommon/html/blank.html";

	var his_type = document.forms[0].history_type.value;
	var whereClause = "";
//	if(his_type != "")
//	{
		whereClause = "where hist_rec_type=`"+his_type+"`";
//	}
	var retVal = 	new String();
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var sql=" select EVENT_CODE,short_desc SHORT_DESC from CR_CLIN_EVENT_MAST  "+whereClause;
	var search_code="EVENT_CODE";
	var search_desc="SHORT_DESC";
	var tit="Event Item";
	var target = parent.frames[2].document.forms[0].event_item1;
	
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);

	var arr=new Array();
	if (!(retVal == null))
	{
		var retVal=unescape(retVal);
	   	arr=retVal.split("::");

		parent.frames[2].document.forms[0].event_item.value = arr[1];
		parent.frames[2].document.forms[0].event_item1.value = arr[0];
	}else{
		parent.frames[2].document.forms[0].event_item.value = '';
		parent.frames[2].document.forms[0].event_item1.value ='';
		target.focus();
	}
}

//Functions for the file FlowSheetCompDetailFlow.jsp-start
function ShowList()
	{
		parent.frames[2].location.href="../../eCA/jsp/FlowSheetCompDetailCriteria.jsp?mode=insert&flow_sheet_id="+parent.frames[0].document.forms[0].flow_sheet.value;
		parent.frames[1].location.href="../../eCA/jsp/FlowSheetCompDetailResult.jsp?mode=insert&flow_sheet_id="+parent.frames[0].document.forms[0].flow_sheet.value;
		parent.frames[3].location.href="../../eCommon/html/blank.html";
	}
//Functions for the file FlowSheetCompDetailFlow.jsp-end

//Functions for the file FlowSheetCompDetailCriteria.jsp-start

function clearall()
{
/******************************************************************************/	
	document.forms[0].event_group1.value = '';
	document.forms[0].event_item1.value = '';		
/******************************************************************************/	

	parent.frames[3].location.href='../../eCommon/html/blank.html';
}

function checkGroup(obj){

	if(obj.value!=""){
			HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempForm' id='tempForm' method='post' action='FlowSheetCompGroupSearch.jsp'><input type=hidden name='eventGroup' id='eventGroup' value='"+obj.value+"'><input type=hidden name='history_type' id='history_type' value='"+document.forms[0].history_type.value+"'> </form></body></html>";
			parent.parent.messageFrame.document.write(HTMLVal);
			parent.parent.messageFrame.document.tempForm.submit();
	}else{
		document.getElementById("event_group").value = "";
	}
}

function checkItem(obj){
	if(obj.value!=""){
			HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempForm' id='tempForm' method='post' action='FlowSheetCompItemSearch.jsp'><input type=hidden name='eventItem' id='eventItem' value='"+obj.value+"'><input type=hidden name='history_type' id='history_type' value='"+document.forms[0].history_type.value+"'></form></body></html>"
			parent.parent.messageFrame.document.write(HTMLVal);
			parent.parent.messageFrame.document.tempForm.submit();
	}else{
		document.getElementById("event_item").value = "";
	}
}

function ShowDetails()
{
	parent.frames[3].location.href="../../eCommon/html/blank.html";

	var fields = new Array (parent.frames[0].document.forms[0].flow_sheet,parent.frames[2].document.forms[0].history_type); //,parent.frames[2].document.forms[0].event_class_id)
	
	 var names = new Array ( getLabel("eCA.FlowSheet.label",'CA'),getLabel("eCA.HistoryRecordType.label",'CA'));  //,"Event Class" )

	 var searchby = "";

if(parent.frames[2].document.forms[0].search_by[0].checked)
searchby=parent.frames[2].document.forms[0].search_by[0].value;
else
searchby=parent.frames[2].document.forms[0].search_by[1].value;

var criteria = parent.frames[2].document.forms[0].search_criteria.value;
var text= parent.frames[2].document.forms[0].search_text.value;

	
	if((checkFieldsofMst( fields, names, parent.parent.messageFrame)) )
	{
	//+parent.frames[2].document.forms[0].event_group.value++parent.frames[2].document.forms[0].event_class_id.value
parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
//parent.frames[3].location.href="../../eCA/jsp/FlowSheetCompDetailList.jsp?mode=insert&history_type_id="+parent.frames[2].document.forms[0].history_type.value+"&flow_sheet_id="+parent.frames[0].document.forms[0].flow_sheet.value+"&searchby="+searchby+"&criteria="+criteria+"&text="+text+""; //Commented for GHL-SCF-1113[IN061985]
parent.frames[3].location.href="../../eCA/jsp/FlowSheetCompDetailList.jsp?mode=insert&history_type_id="+parent.frames[2].document.forms[0].history_type.value+"&flow_sheet_id="+parent.frames[0].document.forms[0].flow_sheet.value+"&searchby="+searchby+"&criteria="+criteria+"&text="+escape(text)+""; // Added for GHL-SCF-1113[IN061985]

	
	}
}
//Functions for the file FlowSheetCompDetailCriteria.jsp-end


//Functions for the file FlowSheetCompDetailResult.jsp-start

function CheckFuncList(obj)
{

	var event_grp_id="";
	var event_id="";
    
	if(parent.frames[3].document.forms[0] != null)
	{
	event_grp_id = parent.frames[3].document.forms[0].event_grp_id.value;
	
	event_id = parent.frames[3].document.forms[0].event_id.value;
	
	}
	
    
	
	flow_sheet_id = parent.frames[0].document.forms[0].flow_sheet.value;
	
	history_type_id =parent.frames[2].document.forms[0].history_type.value;
	event_class_id =parent.frames[2].document.forms[0].event_class_id.value;
	
		parent.frames[1].location.href="../../eCA/jsp/FlowSheetCompDetailResult.jsp?mode=modify&flag=operation&eventval="+obj.value;
	
		if(history_type_id!="" )
		{
			//alert('historytypeid');
			parent.frames[3].location.href="../../eCA/jsp/FlowSheetCompDetailList.jsp?mode=insert&flow_sheet_id="+flow_sheet_id+"&history_type_id="+history_type_id+"&event_class_id="+event_class_id+"&eventval="+obj.value+"&event_group="+event_grp_id+"&event_item="+event_id+" ";
		}
}


function scrollTitle2(){
	
  var y = parent.FlowSheetCompDetailResult.document.body.scrollTop;

  if(y == 0){
	parent.FlowSheetCompDetailResult.document.getElementById("divDataTitle").style.position = 'static';
	parent.FlowSheetCompDetailResult.document.getElementById("divDataTitle").style.posTop  = 0;
  }else{
	parent.FlowSheetCompDetailResult.document.getElementById("divDataTitle").style.position = 'relative';
	parent.FlowSheetCompDetailResult.document.getElementById("divDataTitle").style.posTop  = y-2;
  }

}


function alignWidth(){
	var totalRows =  parent.FlowSheetCompDetailResult.document.getElementById("dataTable").rows.length;
	var counter = totalRows-1;
	var temp = parent.FlowSheetCompDetailResult.document.getElementById("dataTitleTable").rows(1).cells.length;
	for(var i=0;i<temp;i++) {
		parent.FlowSheetCompDetailResult.document.getElementById("dataTitleTable").rows(1).cells(i).width=parent.FlowSheetCompDetailResult.document.getElementById("dataTable").rows(counter).cells(i).offsetWidth;
		
	}
}

//Functions for the file FlowSheetCompDetailResult.jsp-end

//Functions for the file FlowSheetCompGroupSearch.jsp-start

function callfunction()
{
	//alert();
	var target			= parent.frames[1].frames[2].document.forms[0].event_group1;
	var serviceVal   = parent.frames[1].frames[2].document.forms[0].event_group1.value;
	var his_type		=  parent.frames[1].frames[2].document.forms[0].history_type.value;
	var whereClause = "";

	whereClause = "and hist_rec_type='"+his_type+"'";
		
	var title			=getLabel("eCA.EventGroup.label","CA");
	
	var sql="select EVENT_GROUP code, long_desc description from CR_CLIN_EVENT_GROUP where  upper(EVENT_GROUP)  like upper(?) and upper(long_desc) like upper(?) "+whereClause;

	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();

	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;

	retArray = CommonLookup( title, argArray );
	if(retArray != null && retArray !="")	{
		parent.frames[1].frames[2].document.forms[0].event_group.value = retArray[0];
		parent.frames[1].frames[2].document.forms[0].event_group1.value = retArray[1];
	}else{
		parent.frames[1].frames[2].document.forms[0].event_group.value = '';
		parent.frames[1].frames[2].document.forms[0].event_group1.value ='';
	}
	parent.frames[1].frames[2].document.forms[0].event_group_but.disabled=false;
parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
}
//Functions for the file FlowSheetCompGroupSearch.jsp-end


//Functions for the file FlowSheetCompItemSearch.jsp-start

function callfunctionitemsearch()
{
	var target			= parent.frames[1].frames[2].document.forms[0].event_item1;
//	var serviceVal   = top.content.workAreaFrame.frames[0].document.forms[0].event_item1.value;
	var his_type		=  parent.frames[1].frames[2].document.forms[0].history_type.value;
	var whereClause = "";
	
//	if (his_type !=""){
				whereClause = "and hist_rec_type='"+his_type+"'";
//	}
//	alert('wc  =>'+whereClause);
	var title			= getLabel("eCA.EventItem.label","CA");
	var sql="select EVENT_CODE code, long_desc description  from CR_CLIN_EVENT_MAST  where upper(EVENT_CODE)   like upper(?) and upper(long_desc) like upper(?)  "+whereClause

	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = CommonLookup( title, argArray );

	if(retArray != null && retArray !="")	{
		parent.frames[1].frames[2].document.forms[0].event_item.value = retArray[0];
		parent.frames[1].frames[2].document.forms[0].event_item1.value = retArray[1];
	}else{
		parent.frames[1].frames[2].document.forms[0].event_item.value = '';
		parent.frames[1].frames[2].document.forms[0].event_item1.value ='';
	}
	parent.frames[1].frames[2].document.forms[0].event_item_but.disabled=false;
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
}

//Functions for the file FlowSheetCompItemSearch.jsp-end	


//Functions for the file FlowSheetCompDetailList.jsp-start	

function selectAll()
{
	var cnt = document.forms[0].count.value;
	if(document.getElementById("chkAll").checked){
		for(var i=0;i<cnt;i++){
			eval("document.forms[0].checkbox"+i+".checked = true");
		}
	}else{
		for(var i=0;i<cnt;i++){
			eval("document.forms[0].checkbox"+i+".checked = false");
		}	
	}
}
function CheckFunc(obj)
{
	
	
	var hist_id = parent.frames[2].document.forms[0].history_type.value;
	var select_index = parent.frames[2].document.forms[0].history_type.selectedIndex;
	var hist_desc = parent.frames[2].document.forms[0].history_type.options(select_index).text;
	//var event_class_id = parent.frames[2].document.forms[0].event_class_id.value;
	//var select_index = parent.frames[2].document.forms[0].event_class_id.selectedIndex;
	//var event_class_desc = parent.frames[2].document.forms[0].event_class_id.options(select_index).text;
	
	
	Chkval = obj.value;
	var splitval = Chkval.split(":");
	var event_group_id ="";
	var event_group ="";
	//alert("splitval[4]---"+Chkval)
	if(splitval[4]!="N")
	{
		event_group = "EG:"+splitval[4]+":"+splitval[2]+":"+splitval[3];
		event_group_id=	splitval[4];
	}
	else{
		event_group = "N";
		event_group_id = "N";
	}
   
	parent.frames[1].location.href="../../eCA/jsp/FlowSheetCompDetailResult.jsp?mode=modify&flag="+obj.checked+"&event_desc="+splitval[0]+"&event_id="+splitval[1]+"&event_group_id="+event_group_id+"&event_group="+event_group+"&hist_id="+hist_id+"&hist_desc="+hist_desc+"&event_code_type="+splitval[5]+"&event_group_type"+splitval[6]+"";
	
}


function scrollTitle(){
	  var y = parent.FlowSheetCompDetailList.document.body.scrollTop;

	  if(y == 0){
		parent.FlowSheetCompDetailList.document.getElementById("divDataTitle").style.position = 'static';
		parent.FlowSheetCompDetailList.document.getElementById("divDataTitle").style.posTop  = 0;
	  }else{
		parent.FlowSheetCompDetailList.document.getElementById("divDataTitle").style.position = 'relative';
		parent.FlowSheetCompDetailList.document.getElementById("divDataTitle").style.posTop  = y-2;
	  }

}
	function alignWidth(){
		var totalRows =  parent.FlowSheetCompDetailList.document.getElementById("dataTable").rows.length;
		var counter = totalRows-1;
		var temp = parent.FlowSheetCompDetailList.document.getElementById("dataTitleTable").rows(1).cells.length;
		for(var i=0;i<temp;i++) {
			parent.FlowSheetCompDetailList.document.getElementById("dataTitleTable").rows(1).cells(i).width=parent.FlowSheetCompDetailList.document.getElementById("dataTable").rows(counter).cells(i).offsetWidth;
			
		}
}

//Functions for the file FlowSheetCompDetailList.jsp-end	




function panelposition(position,last)
{

if(parent.frames[1].document.forms[0].first.value != position)
	{
if(last != 'X')
last ='';

var mode=parent.frames[1].document.forms[0].mode.value
var temp=parent.frames[1].document.forms[0].first.value
if(temp=='')	
parent.frames[1].document.forms[0].first.value=	position;
else
	{
	var pos1=parent.frames[1].document.forms[0].first.value;
	parent.frames[1].document.forms[0].first.value='';
	//alert('pos1'+pos1);
	//alert('position'+position);

 	parent.frames[1].location.href="../../eCA/jsp/FlowSheetCompDetailResult.jsp?change=Y&pos1="+pos1+"&pos2="+position+"&mode=modify&lastlink="+last+"";
	}
	}
}
function showvis(val)
{
//alert();
if(val == 'true')
document.getElementById("last").style.display='none';
else
document.getElementById("last").style.display='block';
//parent.frames[2].document.getElementById("last").style.visibility = 'visible';
}

function scrollTitle()
{
	
  var y = parent.FlowSheetCompDetailList.document.body.scrollTop;

  if(y == 0){
	parent.FlowSheetCompDetailList.document.getElementById("divDataTitle").style.position = 'static';
	parent.FlowSheetCompDetailList.document.getElementById("divDataTitle").style.posTop  = 0;
  }else{
	parent.FlowSheetCompDetailList.document.getElementById("divDataTitle").style.position = 'relative';
	parent.FlowSheetCompDetailList.document.getElementById("divDataTitle").style.posTop  = y-2;
  }

}

function scrollTitle1()
{
	
  var y = document.body.scrollTop;
  //alert(y);

  if(y == 0){
	  document.getElementById("divDataTitle").style.position = 'static';
	  document.getElementById("divDataTitle").style.posTop  = 0;
  }else{
	  document.getElementById("divDataTitle").style.position = 'relative';
	  document.getElementById("divDataTitle").style.posTop  = y-2;
  }

}	


var ret_str='';
function Reassaign(obj)
{
	var return_format="";
		
	if(obj.checked)
	{
		var chkval = obj.value;
		//ret_str=parent.FlowSheetCompDetailList.document.FlowSheetEventSearchResultForm.ret_value[parseInt(chkval)].value+"@";
		ret_str=eval("parent.FlowSheetCompDetailList.document.FlowSheetEventSearchResultForm.ret_value"+chkval+".value")+"@";
			//alert("ret_str"+ret_str);			
		parent.FlowSheetCompDetailResult.location.href="../../eCA/jsp/FlowSheetCompDetailResult.jsp?return_format="+return_format+"&ret_str="+escape(ret_str)+"";
		//parent.RecClinicalNotesLinkDiagSelectButtonsFrame.document.RecClinicalNotesLinkDiagSelectButtonsForm.select.disabled=false;
	}
			
	else
		{
			var chkval=obj.value;
			var remval=eval("parent.FlowSheetCompDetailList.document.FlowSheetEventSearchResultForm.chk_value"+chkval+".value")
			//alert("remval"+remval);
			//parent.ret_str=parent.ret_str+parent.FlowSheetCompDetailList.document.FlowSheetEventSearchResultForm.ret_value[parseInt(remval)].value+"@";
			parent.FlowSheetCompDetailResult.location.href="../../eCA/jsp/FlowSheetCompDetailResult.jsp?return_format="+return_format+"&remval="+escape(remval)+"&ret_str="+escape(ret_str)+"&removebean=Y";
			
		}	
}

function chkunchk(objCheck)
{
	var index = 0;
	if(objCheck.checked==false)
	{
	//	parent.FlowSheetCompDetailList.document.FlowSheetEventSearchResultForm.ctrlChkBox.checked=false
	}
	else
	{
		for(cnt=0; cnt<parent.FlowSheetCompDetailList.document.FlowSheetEventSearchResultForm.count.value; cnt++)
		{
			val = eval("parent.FlowSheetCompDetailList.document.FlowSheetEventSearchResultForm.chkbox"+cnt);
			if(val.checked == true) index++;
		}
		if(index == cnt)
		{
			//parent.FlowSheetCompDetailList.document.FlowSheetEventSearchResultForm.ctrlChkBox.checked=true
		}
	}	
}


/*function perform(ctrlChkBoxObj)
{
	var return_format="";
	var val ="";
	var retstr2="";
    var strval="";
	parent.parent.messageFrame.location.href="../../eCommon/html/blank.html"
	if(ctrlChkBoxObj.checked==true)
	{
		
		for(cnt=0; cnt<parent.FlowSheetCompDetailList.document.FlowSheetEventSearchResultForm.count.value; cnt++)
		{
			
			val = eval("parent.FlowSheetCompDetailList.document.FlowSheetEventSearchResultForm.chkbox"+cnt);
			if(!val.checked)
            {
				val.checked = true;
            strval=eval("parent.FlowSheetCompDetailList.document.FlowSheetEventSearchResultForm.ret_value"+cnt);
			retstr2 = retstr2 + strval.value+"@";
			}
			
			
		}
		
		HTMLVal = "<form name='dummy_form' id='dummy_form' method='post' action='../../eCA/jsp/FlowSheetCompDetailResult.jsp'><input type=hidden name='ret_str' id='ret_str' value='"+escape(retstr2)+"'><input type=hidden name='return_format' id='return_format' value='"+return_format+"'><input type=hidden name='sel_all' id='sel_all' value='select'></form>";
		parent.parent.messageFrame.document.body.insertAdjacentHTML('beforeend',HTMLVal);
		
		parent.parent.messageFrame.document.dummy_form.target = "FlowSheetCompDetailResult";
		parent.parent.messageFrame.document.dummy_form.submit();
		//parent.RecClinicalNotesLinkDiagSelectButtonsFrame.document.RecClinicalNotesLinkDiagSelectButtonsForm.select.disabled=false;
		
	}
	
	else
	{
		for(cnt=0; cnt<parent.FlowSheetCompDetailList.document.FlowSheetEventSearchResultForm.count.value; cnt++)
		{
			
			val = eval("parent.FlowSheetCompDetailList.document.FlowSheetEventSearchResultForm.chkbox"+cnt);
			val.checked = false;
		}
		
		parent.FlowSheetCompDetailResult.document.location = "../../eCA/jsp/FlowSheetCompDetailResult.jsp?return_format="+return_format+"&flag=clear&ret_str=";
		
	}
parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";

}*/
function selText(obj1)
{
	var return_format="";
	var clearchkval='';
	var clearremval='';
	if(!obj1.checked)
	{
		clearchkval=obj1.value;
		clearremval=eval("parent.FlowSheetCompDetailResult.document.FlowSheetCompDetailResultForm.clear"+clearchkval+".value");

		
	 	parent.FlowSheetCompDetailResult.location.href="../../eCA/jsp/FlowSheetCompDetailResult.jsp?return_format="+return_format+"&remval="+escape(clearremval)+"&removebean=Y";
		makeresultcheck(clearremval)

	}
}
function makeresultcheck(remval)
{
	if(parent.FlowSheetCompDetailList.document.FlowSheetEventSearchResultForm != null)
	{
	for(cnt=0; cnt<parent.FlowSheetCompDetailList.document.FlowSheetEventSearchResultForm.count.value; cnt++)
	{
			val = eval("parent.FlowSheetCompDetailList.document.FlowSheetEventSearchResultForm.chkbox"+cnt);
			strval=eval("parent.FlowSheetCompDetailList.document.FlowSheetEventSearchResultForm.chk_value"+cnt+".value");
					
			if(strval==remval)
		{
				val.checked = false
   
			//parent.FlowSheetCompDetailList.document.FlowSheetEventSearchResultForm.ctrlChkBox.checked = false 
		}

	}
	
	}
  
}

