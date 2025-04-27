
var func="";
function query()
{  f_query_add_mod.location.href = "../../eQA/jsp/QAIndicatorsForFacilityQueryCriteria.jsp" ;

    func="modify";

}
function create()
{

f_query_add_mod.location.href = "../../eQA/jsp/addModifyQAIndicatorsForFacility.jsp" ;
func="insert";

}
function reset()
{
	//if(parent.frames[1].frames[1].document.forms[0]!=null)
//parent.frames[1].frames[1].location.reload();
	if(f_query_add_mod.document.forms[0]!=null)
	     f_query_add_mod.document.location.reload() ;

}


function onSuccess() {
//facId=parent.frames[1].document.frames[1].document.frames[0].document.forms[0].facility.value;
parent.frames[1].frames[1].location.reload();


}






function submitPage()
{ 
	
	
	var fac_id = document.forms[0].fac_id.value;
	var indi = document.forms[0].indi.value;
	if (fac_id=="")
	{
		alert("APP-000001 Facility cannot be blank");
		 document.forms[0].fac_id.focus();
		 return;
	}
		
		parent.frames[1].location.href = "../../eQA/jsp/QAIndicatorForFacility2.jsp?fac_id="+fac_id+"&indi="+indi;
	
}


function clearAll()
{
	parent.frames[1].location.href = '../../eCommon/html/blank.html';
	parent.frames[0].document.forms[0].reset();
	
		
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

if (frames[1].document.forms[0]==null)
	{
	
window.frames[1].frames[1].document.forms[0].action='../../servlet/eQA.QAIndicatorsForFacilityServlet'
window.frames[1].frames[1].document.forms[0].target='messageFrame'
window.frames[1].frames[1].document.forms[0].method='post'
var count = parseInt(window.frames[1].frames[1].document.forms[0].n.value)

for(var index = 0; index < count ;index++)
{
	
	var age = eval("window.frames[1].frames[1].document.forms[0].age"+index)
	var  period = eval("window.frames[1].frames[1].document.forms[0].period"+index)
	var  gender = eval("window.frames[1].frames[1].document.forms[0].gender"+index)
	var age1=""
	if(gender=="")
		gender="N";
	if(age.value =="")
		{
			age1="X"
		}
		else
		{
			age1=age.value 
		}
	
	var strValue = eval("window.frames[1].frames[1].document.forms[0].strValue"+index)
	strValue.value= period.value + "||" +age1+ "||"+ gender.value 
	

	
}
window.frames[1].frames[1].document.forms[0].submit();
	}
	else 
	{
		frames[1].document.forms[0].action='../../servlet/eQA.QAIndicatorsForFacilityServlet'
		frames[1].document.forms[0].target='messageFrame'
		frames[1].document.forms[0].method='post'
		frames[1].document.forms[0].submit();
		//messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        //return false;
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

//files moved from QAIndicatorForFacility2.jsp

function genYN(obj)
   {
	   if(obj.checked)
		   obj.value="Y"
	   else
		   obj.value="N";
   }
function CheckPositiveNumberLocal(obj) {
	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) 
	{		
	}
	else {
  		if ( obj.value.length < 0 ) 
		{
  			//alert("APP-SM0050 - Value should be greater than equal to ZERO");
  			
			obj.select();
  			obj.focus();
  		}
  	}
}
function rem()
{
//alert(document.forms[0].removedValue0.value)
}
function submitPrevNext(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
var count = parseInt(document.forms[0].n.value)
for(var index = 0; index < count ;index++)
{
	var age = eval("document.forms[0].age"+index)
	var  period = eval("document.forms[0].period"+index)
	var  gender = eval("document.forms[0].gender"+index)

	if(gender.value=="")
	gender.value="N"

	var age1=""
	if(age.value =="")
		{
			age1="X"
		}
		else
		{
			age1 = age.value
		}
	var strValue = eval("document.forms[0].strValue"+index)
	strValue.value= period.value + "||" +age1+ "||" + gender.value
			   
	
	}
	document.forms[0].submit();
}
