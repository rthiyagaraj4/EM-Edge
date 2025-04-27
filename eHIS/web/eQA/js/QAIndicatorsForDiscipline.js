function submitPrevNext(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
var count = parseInt(document.forms[0].n.value)
for(var index = 0; index < count ;index++)
{
	
	
		var strValue = eval("document.forms[0].strValue"+index)
	strValue.value= "I";
	
	
	}
	document.forms[0].submit();
}
var func="";
function query()
{  f_query_add_mod.location.href = "../../eQA/jsp/QAIndicatorsForDisciplineQueryCriteria.jsp" ;

    func="modify";

}
function create()
{

f_query_add_mod.location.href = "../../eQA/jsp/addModifyQAIndicatorsForDiscipline.jsp" ;
func="insert";

}
function reset()
{
//window.frames[1].frames[0].document.forms[0].reset();
//window.frames[1].frames[1].location.href='../../eCommon/html/blank.html';
	if(f_query_add_mod.document.forms[0]!=null)
	     f_query_add_mod.document.location.reload() ;
}


function onSuccess() {
parent.frames[1].frames[1].location.reload();


}






function submitPage()
{ 
	
	
	var dispid = document.forms[0].disipid.value;
	var indi = document.forms[0].indi.value;
	
	if (dispid=="")
	{
		alert("APP-000001 Discipline cannot be blank");
	document.forms[0].disipid.focus();
		 return;
	}
		
		parent.frames[1].location.href = "../../eQA/jsp/QAIndicatorsForDiscipline2.jsp?dispid="+dispid+"&indi="+indi;
	
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

	if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }	

if (window.frames[1].frames[1].document.forms[0])
	{
window.frames[1].frames[1].document.forms[0].action='../../servlet/eQA.QAIndicatorsForDisciplineServlet'
window.frames[1].frames[1].document.forms[0].target='messageFrame'
window.frames[1].frames[1].document.forms[0].method='post'
var count = parseInt(window.frames[1].frames[1].document.forms[0].n.value)

	for(var index = 0; index < count ;index++)
	{

		var  chkyn = eval("window.frames[1].frames[1].document.forms[0].strKey"+index)
		if(chkyn.checked==true)
		{
		var strValue = eval("window.frames[1].frames[1].document.forms[0].strValue"+index)
		strValue.value= "I" ;

		}

	}
window.frames[1].frames[1].document.forms[0].submit();
}
	else
	{
		/*parent.frames[1].frames[1].document.forms[0].action='../../servlet/eQA.QAIndicatorForDisciplineServlet'
		parent.frames[1].frames[1].document.forms[0].target='messageFrame'
		parent.frames[1].frames[1].document.forms[0].method='post'
		parent.frames[1].frames[1].document.forms[0].submit();*/
	messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
	}
}

function chkValue(obj,val)
   {
	   var removeValue = eval("document.forms[0].removedValue"+val)
	   if(obj.checked == false)
	   {
			removeValue.value = obj.value
	   }
	   else
	   {
		   return false
	   }
   }

function clearAll()
{
	parent.frames[1].location.href = '../../eCommon/html/blank.html';
	parent.parent.frames[2].location.href = '../../eCommon/jsp/MstCodeError.jsp';
	//parent.frames[0].document.forms[0].reset();
	
		
}





