function apply()
{

	//if(parent.frames[1].frames[1].frames[0].document.forms[0].nursing_unit_desc.value == "")
	if(frames[1].frames[0].document.forms[0].nursing_unit_desc.value == "")
	{
		var msg = getMessage('NU_NOTNULL','IP');
		messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=0' ;
	}
	else
	{
		//parent.frames[1].frames[1].frames[1].document.forms[0].allValues.value=parent.frames[1].frames[1].frames[2].document.forms[0].E.value;
		frames[1].frames[1].document.forms[0].allValues.value=frames[1].frames[2].document.forms[0].E.value;
		//parent.frames[1].frames[1].frames[1].document.forms[0].action="../../servlet/eIP.NursUnitSpecialityServlet";
		frames[1].frames[1].document.forms[0].action="../../servlet/eIP.NursUnitSpecialityServlet";
		//parent.frames[1].frames[1].frames[1].document.forms[0].target="messageFrame";
		frames[1].frames[1].document.forms[0].target="messageFrame";
		//parent.frames[1].frames[1].frames[1].document.forms[0].submit();
		 frames[1].frames[1].document.forms[0].submit();
	}
}

function create() {
	//f_query_add_mod.location.href = "../../eIP/jsp/NursingUnitMain.jsp?param=create&called_from=3" ;
	var paramStr = "../../eIP/jsp/NursingUnitMain.jsp?param=create&called_from=3";
	var params = (f_query_add_mod.location.href).split('&');

		for (i=1;i<params.length ;++i )
		{
			if 	(params[i].indexOf('function_id')>-1)
			{
				paramStr = paramStr + '&' + params[i];
			}
		}

	f_query_add_mod.location.href = paramStr ;
}

function query() {
	//f_query_add_mod.location.href ="../../eIP/jsp/NursUnitSpecialityQueryCriteria.jsp" ;
	var paramStr = "../../eIP/jsp/NursUnitSpecialityQueryCriteria.jsp?param=create&called_from=1";
	var params = (f_query_add_mod.location.href).split('&');

		for (i=1;i<params.length ;++i )
		{
			if 	(params[i].indexOf('function_id')>-1)
			{
				paramStr = paramStr + '&' + params[i];
			}
		}

	f_query_add_mod.location.href = paramStr ;
}

function reset()
{
	var loc=frames[1].document.forms[0]

	if (loc!=null )
	{
			f_query_add_mod.document.forms[0].reset();
	}
	else  if(frames[1].frames[0])
	{
	create();
	}
}

function onSuccess() {
	
	//parent.frames[1].frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	//parent.frames[1].frames[1].frames[0].location.reload();
	frames[1].frames[0].location.reload();
}

//functions from AddModifyNursUnit.jsp

function submitPrevNext(from, to)
{
/*var maxRecord=document.forms[0].maxRecord.value;
var count=0;
 for(var j=1;j<maxRecord;j++){
 if(eval("document.forms[0].chk"+j)) {
		if(eval("document.forms[0].chk"+j).checked==false){
				count++;
				

				

		}

	}
 }
var c1=to-count;
alert("c1="+c1);
alert("from=="+from);
alert("to=="+to);
if((count==0) && (c1<to)){
	alert("1");
      document.forms[0].chkAll.checked=true;
}
else{
      document.forms[0].chkAll.checked=false;		
}*/
if(document.getElementById("chkAll").checked==true)
			document.forms[0].selctAllCHk.value='Y';
			else
				document.forms[0].selctAllCHk.value='N';
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
	
	

}


function selectAll(Obj,start,end)
{
	if(Obj.checked)
	{
		for(var i=start;i<=end;i++)
		{
			if(eval("document.forms[0].chk"+i))
			{
			
			 	eval("document.forms[0].chk"+i).checked=true;



			}
		}

		var nursing_unit_code = document.forms[0].nursing_unit_code.value;

		var search_by = parent.frames[1].document.forms[0].search_by.value;
		var search_txt = parent.frames[1].document.forms[0].search_txt.value;

		var HTMLVal = " <HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='NursUnitSpecialityDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'><input type='hidden' name='search_by' id='search_by' value='"+search_by+"'><input type='hidden' name='search_txt' id='search_txt' value='"+search_txt+"'><input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value='"+nursing_unit_code+"'></form></BODY></HTML>";
		
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.form1.submit();
			document.getElementById("selectChk").value='Y';


	}
	else
	{
		for(var i=start;i<=end;i++)
		{
			if(eval("document.forms[0].chk"+i))
			eval("document.forms[0].chk"+i).checked=false;
		}
	
		var HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='NursUnitSpecialityDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'></form></BODY></HTML>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.form1.submit();
			document.getElementById("selectChk").value='N';

	}
}

function chkForSelectAll(start,end)
{


	if(parent.frames[2].document.forms[0].E.value == 'selectAll')
	{
		document.forms[0].chkAll.checked=true;
		selectAll(document.forms[0].chkAll,start,end)
	}
		

}

function chekSelectAll(){
	var chkcount1=document.forms[0].chkcount1.value;

var maxRecord=document.forms[0].maxRecord.value;
var count = 0;
for(var j=1;j<maxRecord;j++){
if(eval("document.forms[0].chk"+j)) {
		if(eval("document.forms[0].chk"+j).checked==false){
				count++;
				//alert("on load count"===+count);
		}
	}
 }
 chkcount1=chkcount1+count
//alert("chkcount1=="+chkcount1);
if(chkcount1==0){
     // document.forms[0].chkAll.checked=true;
}
else{
      //document.forms[0].chkAll.checked=false;		
}


}



