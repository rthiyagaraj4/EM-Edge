/*
	FileName	: AdaptiveMenu.js
	Version	    : 1.0	
	Created On	: 29-06-2009
	Created By	: Arvind Singh Pal
	Purpose     : for CRF-0544-IP
*/
 async function getLinkedFunction(target)
{
	

		var target				= document.forms[0].panel_id.value;			
		var result_type=parent.frames[1].document.forms[0].ql_type.value;			
	    var argumentArray  = new Array() ;
	    var dataNameArray  = new Array() ;
	    var dataValueArray = new Array() ;
	    var dataTypeArray  = new Array() ;
	    var tit=getLabel("Common.PanelID.label","Common");
        
		var retVal				=  new String();
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;				
		sql = "select ADPT_FUNCTION_REF code,ADPT_FUNCTION_NAME description from SM_QUICK_LINK_ADPT_MNU where LINKED_FUCNTION_YN='Y'";
		
		sql=sql+"and upper(ADPT_FUNCTION_REF) like upper(?) and upper(ADPT_FUNCTION_NAME) like upper(?) ";	
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target;
	argumentArray[5] = document.forms[0].panel_id.value
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = CODE_DESC;	
	
	retVal = await CommonLookup( tit, argumentArray );
	
		 
		var arr=new Array();

		if(retVal != null && retVal != "" )
		{

			var retVal=unescape(retVal);		
		   	 arr=retVal.split(",");
		
		    document.forms[0].desc.value=arr[1];
			document.forms[0].panel_id.value=arr[0];
			
		}
		else
		{
			document.forms[0].panel_id.value="";
			document.forms[0].desc.value="";
			
		}
		
	}
		
function getLinkedFunction1(obj)
{
	
	if(obj.value != null && obj.value != '')
	{
		getLinkedFunction();
	}
	else
	{
		
	}

}
function clearFields()
{
	document.forms[0].panel_id.value="";
	document.forms[0].desc.value="";
}
 
function addPanel()
{
	
	var id=parent.frames[3].document.forms[0].panel_id.value;
	var desc= parent.frames[3].document.forms[0].desc.value;	
	var mode=parent.frames[3].document.forms[0].mode.value;
	var disp_flag=parent.frames[3].document.forms[0].disp_flag.value;
	var clearvalue=parent.frames[3].document.forms[0].clearvalue.value;
	var code=parent.frames[3].document.forms[0].code.value;
	for(var i=0;i<desc.length;i++)
	{		
		if(desc.indexOf("+")!=-1)
		desc=desc.replace("+","|");
	}	
	
	if(desc==null || desc=="")
	{
		var error=getMessage("CAN_NOT_BE_BLANK",'Common');
		error=error.replace("$",getLabel("eCA.FunctionRef.label","ca"));
		alert(error);
		return false;
	}	
	else
	{
		
		parent.frames[2].location.href="../../eCA/jsp/AdaptiveMenuLinkedFunctionsOrder.jsp?id="+id+"&description="+escape(desc)+"&mode="+mode+"&disp_flag="+disp_flag+"&code="+code+"&clearvalue="+clearvalue+"&removebean=Y";
	}
parent.frames[3].location.href="../../eCA/jsp/AdaptiveMenuLinkedFunctions.jsp?mode="+mode+" ";
}

function Reassaign(obj)
{	
		if(!obj.checked)
		{
			//if(window.confirm(getMessage("DELETE_RECORD",'Common')) == true)
			//{
			
			var chkval = obj.value;
			var flag="false";			
			parent.frames[2].location.href="../../eCA/jsp/AdaptiveMenuLinkedFunctionsOrder.jsp?code="+chkval+"&flag="+flag+"";
		//}
	}
}
function deleteRecord()
{		
			
			var chkval = parent.frames[3].document.forms[0].delval.value;
			
			var flag="false";
			
			parent.frames[2].location.href="../../eCA/jsp/AdaptiveMenuLinkedFunctionsOrder.jsp?code="+chkval+"&flag="+flag+"";
		
	
}

function panelposition(position,last)
{

if(parent.frames[2].document.forms[0].first.value != position)
	{
if(last != 'X')
last ='';

var mode=parent.frames[2].document.forms[0].mode.value
var temp=parent.frames[2].document.forms[0].first.value

if(temp==''){showvis();	
parent.frames[2].document.forms[0].first.value=	position;
}
else
	{
	var pos1=parent.frames[2].document.forms[0].first.value;
	parent.frames[2].document.forms[0].first.value='';	

 	parent.frames[2].location.href="../../eCA/jsp/AdaptiveMenuLinkedFunctionsOrder.jsp?change=Y&pos1="+pos1+"&pos2="+position+"&mode="+mode+"&lastlink="+last+"";
	showvis();
	}
	}
}
function showvis(val)
{

if(val == 'true')
document.getElementById("last").style.display='none';
else
document.getElementById("last").style.display='block';
}
