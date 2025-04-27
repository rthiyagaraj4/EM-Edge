 function callOnMouseOver(obj)
	 {
		if(obj.className != "WHITE"){
			currClass = obj.className ;
			 if("H" == "H") 	obj.className = currClass;
			 else	obj.className = 'FIRSTNORMAL';
		 }
	  }

function callOnMouseOut(obj)
	{
		if(obj.className != "WHITE"){
			obj.className = currClass;
		}
	}

function callResult(val)
{


if(val == "S")
	{
top.content.master_pages.maintabs.document.getElementById("setup").className ="CAHIGHERLEVELCOLOR";
top.content.master_pages.maintabs.document.getElementById("relink").className ="CAFOURTHLEVELCOLOR";
parent.subtabs.location.href="../../eCA/jsp/ClinicalEventGroupSubTabs.jsp";
	}
else if(val == "R")
	{
	top.content.master_pages.maintabs.document.getElementById("relink").className ="CAHIGHERLEVELCOLOR";
	top.content.master_pages.maintabs.document.getElementById("setup").className ="CAFOURTHLEVELCOLOR";
	parent.subtabs.location.href="../../eCommon/html/blank.html";
	parent.res.cols="0%,100%";
	top.content.master_pages.criteria.location.href="../../eCA/jsp/ClinicalEventGroupRelinkMain.jsp";
	top.content.master_pages.add.location.href="../../eCommon/html/blank.html";
	}
else if(val == "I")
{
	
	top.content.master_pages.subtabs.document.getElementById("ind").className ="CAHIGHERLEVELCOLOR";
	top.content.master_pages.subtabs.document.getElementById("batch").className ="CAFOURTHLEVELCOLOR";
	parent.res.cols="50%,50%";
	parent.criteria.location.href="../../eCA/jsp/ClinicalEventGroupIndTabCriteria.jsp";
	top.content.master_pages.add.location.href="../../eCommon/html/blank.html";
	top.content.master_pages.result.location.href="../../eCommon/html/blank.html";

}
else if(val == "B")
{
	top.content.master_pages.subtabs.document.getElementById("batch").className ="CAHIGHERLEVELCOLOR";
	top.content.master_pages.subtabs.document.getElementById("ind").className ="CAFOURTHLEVELCOLOR";
	parent.criteria.location.href="../../eCA/jsp/ClinicalEventGroupBatchEventMain.jsp";
	top.content.master_pages.add.location.href="../../eCommon/html/blank.html";
	parent.res.cols="0%,100%";
	//parent.add.location.href="../../eCA/jsp/ClinicalEventGroupBatchEventSearch.jsp";
}

}

function display()
{
var radio="";
if (document.EventIndTabCriteriaForm.source(0).checked)
radio=document.EventIndTabCriteriaForm.source(0).value;
else
radio=document.EventIndTabCriteriaForm.source(1).value;


if(radio=="M")
	{
document.getElementById("grp").style.display="block";
document.getElementById("grp2").style.display="none";
document.forms[0].groupcode.value='';
document.forms[0].long_desc.value = '';
document.forms[0].short_desc.value = '';
	}
	else
	{
document.getElementById("grp").style.display="none";
document.getElementById("grp2").style.display="block";
document.forms[0].groupcode2.value='';
document.forms[0].long_desc.value = '';
document.forms[0].short_desc.value = '';
	}

}
function populateCntrSys(obj)
{

//if(flag != "frompanel")	
{
var optlen = document.forms[0].contr.options.length;

for (i=0; i<optlen; i++)
document.forms[0].contr.remove(0);

var opt=document.createElement('OPTION'); 
opt.text	=	'   ---- Select ----   ';
opt.value	=	'';
document.forms[0].contr.add(opt); 

if(obj.value == "CLNT")
	{
var opt=document.createElement('OPTION'); 
opt.text	=	'CA';
opt.value	=	'CA';
document.forms[0].contr.add(opt); 
    }
else if(obj.value == "PTCR")
	{

var opt=document.createElement('OPTION'); 
opt.text	=	'OR';
opt.value	=	'OR';
document.forms[0].contr.add(opt); 
    }
else if(obj.value == "TRET")
	{
var opt=document.createElement('OPTION'); 
opt.text	=	'OR';
opt.value	=	'OR';
document.forms[0].contr.add(opt); 
    }
else if(obj.value == "LBIN")
	{
var opt=document.createElement('OPTION'); 
opt.text	=	'OR';
opt.value	=	'OR';
document.forms[0].contr.add(opt); 
var opt=document.createElement('OPTION'); 
opt.text	=	'LB';
opt.value	=	'LB';
document.forms[0].contr.add(opt); 
    }
else if(obj.value == "RDIN")
	{
var opt=document.createElement('OPTION'); 
opt.text	=	'OR';
opt.value	=	'OR';
document.forms[0].contr.add(opt); 
var opt=document.createElement('OPTION'); 
opt.text	=	'RD';
opt.value	=	'RD';
document.forms[0].contr.add(opt); 
    }
else if(obj.value == "SUNT")
	{
var opt=document.createElement('OPTION'); 
opt.text	=	'OR';
opt.value	=	'OR';
document.forms[0].contr.add(opt); 
    }


}
}
function callAddElement(obj)
{
var radio="";
if (document.EventIndTabCriteriaForm.source(0).checked)
radio=document.EventIndTabCriteriaForm.source(0).value;
else
radio=document.EventIndTabCriteriaForm.source(1).value;

	if(radio == "M")
	document.forms[0].groupcode.value = '';
	else
    document.forms[0].groupcode2.value = '';

	document.forms[0].long_desc.value = '';
	document.forms[0].short_desc.value = '';

   parent.add.location.href="../../eCA/jsp/ClinicalEventGroupIndTabAddElement.jsp?from=criteria";
   parent.result.location.href="../../eCommon/html/blank.html";
}
async function callGroup()
{
	   

        var target				= document.forms[0].groupcode;
        var eventgroup=parent.add.document.forms[0].groupcode.value;
		var contr  = parent.add.document.forms[0].contr.value;
		var histype = parent.criteria.document.forms[0].histype.value;
		
		var retVal				=  new String();
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc="";
		var title=getLabel("eCA.EventGroup.label","CA");
		
		var sql="Select event_group, short_desc from cr_clin_event_group A where hist_rec_type = `"+histype+"` and event_group_type = `"+contr+"` and not exists (select 1 from cr_clin_event_group_link where hist_rec_type = a.hist_rec_type and contr_sys_event_group != a.event_group and event_group = a.event_group and event_group_type = a.event_group_type)";
		
		//var sql="Select event_group, short_desc from cr_clin_event_group A where hist_rec_type = `"+histype+"` and event_group_type = `"+contr+"` ";//and not exists (select 1 from cr_clin_event_group_link where hist_rec_type = a.hist_rec_type and contr_sys_event_group != a.event_group and event_group = a.event_group and event_group_type = a.event_group_type) order by 2";
      		
		search_code="event_group";
		search_desc="short_desc";
		retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
		 
		var arr=new Array();

		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
		   	arr=retVal.split("::");

		    document.forms[0].shortdesc.value=arr[0];
			document.forms[0].groupcode.value=arr[1];
			
		}
		else
		{
			document.forms[0].groupcode.value="";
			document.forms[0].shortdesc.value="";
			
		}
}

function addEventGroup()
{
	
	var contr=parent.add.document.forms[0].contr.value;
	var groupcode= parent.add.document.forms[0].groupcode.value;
	var shortdesc= parent.add.document.forms[0].shortdesc.value;
	var mode=parent.add.document.forms[0].mode.value;
	var disp_flag=parent.add.document.forms[0].disp_flag.value;
	var clearvalue=parent.add.document.forms[0].clearvalue.value;
	var code=parent.add.document.forms[0].code.value;
	
	
	if(groupcode==null || groupcode=="")
	{
		alert(getMessage('EVENT_GROUP_NOT_BLANK','CA'));
		return false;
	}	
	else
	{
		parent.result.location.href="../../eCA/jsp/ClinicalEventGroupIndTabResult.jsp?contr="+escape(contr)+"&groupcode="+escape(groupcode)+"&shortdesc="+escape(shortdesc)+"&disp_flag="+disp_flag+"&code="+code+"&clearvalue="+clearvalue+"&removebean=Y";
	}
parent.add.location.href="../../eCA/jsp/ClinicalEventGroupIndTabAddElement.jsp?mode="+mode+" ";
}
function clearFields()
{

	var mode=parent.add.document.forms[0].mode.value;
	parent.add.location.href="../../eCA/jsp/ClinicalEventGroupIndTabAddElement.jsp?mode="+mode+" ";

}
function deleteRecord()
{
		var mode=parent.add.document.forms[0].mode.value;
		var chkval = parent.add.document.forms[0].delval.value;
		
		if(chkval != '' && chkval != null)
	{
var flag="false";
			
parent.result.location.href="../../eCA/jsp/ClinicalEventGroupIndTabResult.jsp?code="+chkval+"&flag="+flag+"";
parent.add.location.href="../../eCA/jsp/ClinicalEventGroupIndTabAddElement.jsp?mode="+mode+" ";		
	}
	
}
function Reassaign(obj)
{
	
	
		if(!obj.checked)
		{
			if(window.confirm(getMessage("DELETE_RECORD","Common")) == true)
			{
			
			var chkval = obj.value;
			var flag="false";
			parent.result.location.href="../../eCA/jsp/ClinicalEventGroupIndTabResult.jsp?code="+chkval+"&flag="+flag+"";
		}
	}
}

function panelposition(position,last)
{

if(parent.result.document.forms[0].first.value != position)
	{
if(last != 'X')
last ='';

var mode=parent.result.document.forms[0].mode.value
var temp=parent.result.document.forms[0].first.value
if(temp==''){showvis();	
parent.result.document.forms[0].first.value=	position;
}
else
	{
	var pos1=parent.result.document.forms[0].first.value;
	parent.result.document.forms[0].first.value='';
	parent.result.location.href="../../eCA/jsp/ClinicalEventGroupIndTabResult.jsp?change=Y&pos1="+pos1+"&pos2="+position+"&mode="+mode+"&lastlink="+last+"";
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
//parent.frames[2].document.getElementById("last").style.visibility = 'visible';
}

async function callGroupCode()
{
       // var target				= parent.criteria.document.forms[0].groupcode;
       // var eventgroup=parent.criteria.document.forms[0].groupcode.value;
		var contr  = parent.criteria.document.forms[0].contr.value;
		var histype = parent.criteria.document.forms[0].histype.value;
		if(contr == '')
        alert(getMessage("CONTRID","CA"));
		else
	{
		var retVal				=  new String();
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc="";
		var search_code="";
		var title=getLabel("eCA.EventGroup.label","CA");
		
		//Select event_group, short_desc from cr_clin_event_group A where hist_rec_type = `"+histype+"` and event_group_type = `"+contr+"`

		if(histype=="CLNT" && contr == "CA")
	{
		var sql="Select note_group code, note_group_desc short_desc from ca_note_group a where eff_status = `E` ";//and not exists (select 1 from cr_clin_event_group_link where hist_rec_type = a.hist_rec_type and contr_sys_event_group != a.event_group and event_group = a.event_group and event_group_type = a.event_group_type)";
      	var sql2 =""; 
		search_code="note_group code";
		search_desc="note_group_desc";
	}
	else if((histype=="PTCR" && contr == "OR") || (histype=="TRET" && contr == "OR") || (histype=="LBIN" && contr == "OR") || (histype=="RDIN" && contr == "OR") || (histype=="SUNT" && contr == "OR"))
	{
     var sql="Select discr_msr_id code, short_desc from am_discr_msr where eff_status = `E` and result_type in (`Z`,`V`,`G`)";
//and not exists (select 1 from cr_clin_event_group_link where hist_rec_type = a.hist_rec_type and contr_sys_event_group != a.event_group and event_group = a.event_group and event_group_type = a.event_group_type) order by 2";
     var sql2 ="select long_desc long_desc from am_discr_msr where discr_msr_id="; 
      		
		search_code="discr_msr_id";
		search_desc="short_desc";
	}
	else if(histype=="RDIN" && contr == "RD")
	{
		var sql="Select exam_code code, short_desc from rd_examination";
		var sql2 ="select long_desc long_desc from rd_examination where exam_code="; 

		search_code = "exam_code";
        search_desc="short_desc"; 
	}
	else if(histype=="LBIN" && contr == "LB")
	{
    var sql="Select test_code code, short_desc from rl_test_code where group_test_yn = `Y` and nvl(status,`E`) = `E` ";
	var sql2 ="select long_desc long_desc from rl_test_code where test_code="; 

		search_code = "test_code";
        search_desc="short_desc"; 
	}
		retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
		 
		var arr=new Array();

		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
		   	arr=retVal.split("::");
           
		    document.forms[0].short_desc.value=arr[0];
			document.forms[0].groupcode.value=arr[1];
			
		}
		else
		{
	
			document.forms[0].groupcode.value="";
			document.forms[0].long_desc.value="";
			document.forms[0].short_desc.value="";
			
		}
		
  if(sql2 != "" && arr[1] != "")
	{ 
	  sql2+= "'"+arr[1]+"'";
	  getLongDesc(document.forms[0].groupcode.value,sql2);
	}
	else
	{
		document.forms[0].long_desc.value= arr[0];
	}
	}
}
function getLongDesc(val,sqlquery)
{
	
if(val != '')
	{
parent.messageFrame.location.href="../../eCommon/html/blank.html";
var action_url = "../../eCA/jsp/ClinicalEventGroupGetDesc.jsp";
var HTMLVal			=	"<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><body onKeyDown='lockKey()'><form name='dummy8' id='dummy8' method='POST' action='"+action_url+"' >"+
							"<input type='hidden' name='groupid' id='groupid' value='"+val+"'>"+
							"<input type='hidden' name='sqlquery' id='sqlquery' value="+escape(sqlquery)+">"+
							"</form></body></html >";
    
	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	
	parent.messageFrame.document.dummy8.submit();
	}
}
function setLongDesc(longdesc)
{

parent.criteria.document.forms[0].long_desc.value=longdesc;
parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
}
function apply()
{
//var mode= f_query_add_mod.document.forms[0].mode.value;
	
	if(top.content.master_pages.criteria.document.EventIndTabCriteriaForm != null)
	{


var radio="";
if (top.content.master_pages.criteria.document.EventIndTabCriteriaForm.source(0).checked)
radio=top.content.master_pages.criteria.document.EventIndTabCriteriaForm.source(0).value;
else
radio=top.content.master_pages.criteria.document.EventIndTabCriteriaForm.source(1).value;

if(radio == "M")
		{
	var fields = new Array(top.content.master_pages.criteria.document.forms[0].histype,
		                    top.content.master_pages.criteria.document.forms[0].contr,  
							top.content.master_pages.criteria.document.forms[0].groupcode,
							top.content.master_pages.criteria.document.forms[0].long_desc,
							top.content.master_pages.criteria.document.forms[0].short_desc
							);
		}
		else
		{
			var fields = new Array(top.content.master_pages.criteria.document.forms[0].histype,
		                    top.content.master_pages.criteria.document.forms[0].contr,  
							top.content.master_pages.criteria.document.forms[0].groupcode2,
							top.content.master_pages.criteria.document.forms[0].long_desc,
							top.content.master_pages.criteria.document.forms[0].short_desc
							);

		}
	
	var names = new Array ( getLabel("Common.HistoryType.label",'COMMON'),
							getLabel("eCA.ContributingSystem.label",'CA'),
		                   getLabel("eCA.EventGroupCode.label",'CA'),
							getLabel("Common.longdescription.label",'COMMON'),	
							getLabel("Common.shortdescription.label",'COMMON')
							);		
							


	if(top.content.master_pages.criteria.checkFields( fields, names, messageFrame))
	{
	
	if(radio == "M")
 top.content.master_pages.criteria.document.forms[0].groupcodeval.value=top.content.master_pages.criteria.document.forms[0].groupcode.value;
	else
  top.content.master_pages.criteria.document.forms[0].groupcodeval.value=top.content.master_pages.criteria.document.forms[0].groupcode2.value;
  
  	top.content.master_pages.criteria.document.EventIndTabCriteriaForm.submit();
	
	}
	}
else if(top.content.master_pages.criteria.batchcriteria!=null)
	{
		
  if(top.content.master_pages.criteria.batchcriteria.document.forms[0].dataset(0).checked==true)
		{
	  top.content.master_pages.criteria.batchcriteria.document.forms[0].datasetval.value= top.content.master_pages.criteria.batchcriteria.document.forms[0].dataset(0).value;
		}
		else
		{
      top.content.master_pages.criteria.batchcriteria.document.forms[0].datasetval.value=top.content.master_pages.criteria.batchcriteria.document.forms[0].dataset(1).value;    
		}
  var fields = new Array(top.content.master_pages.criteria.batchcriteria.document.forms[0].histype,
          top.content.master_pages.criteria.batchcriteria.document.forms[0].contr  
														);
	
	var names = new Array ( getLabel("Common.HistoryType.label",'COMMON'),
							getLabel("eCA.ContributingSystem.label",'CA'));	
							

	if(top.content.master_pages.criteria.batchcriteria.checkFields( fields, names, top.content.master_pages.messageFrame))
	{

top.content.master_pages.criteria.batchcriteria.document.EventBatchTabCriteriaForm.submit();
	}
	}
	else if(top.content.master_pages.criteria.linkcri != null)
	{
     var contr  = top.content.master_pages.criteria.linkcri.document.forms[0].contr.value;
var histype = top.content.master_pages.criteria.linkcri.document.forms[0].histype.value;
var groupcode = top.content.master_pages.criteria.linkcri.document.forms[0].groupcode.value;

var fields = new Array(top.content.master_pages.criteria.linkcri.document.forms[0].histype,
		                    top.content.master_pages.criteria.linkcri.document.forms[0].contr,  
							top.content.master_pages.criteria.linkcri.document.forms[0].groupcode
							);
var names = new Array (  getLabel("Common.HistoryType.label",'COMMON'),
							getLabel("eCA.ContributingSystem.label",'CA'),
		                    getLabel("eCA.EventGroupCode.label",'CA')
				
							);		
							


	if(top.content.master_pages.criteria.linkcri.checkFields( fields, names, top.content.master_pages.messageFrame))
	{	  
   top.content.master_pages.criteria.linkcri.document.EventRelinkTabCriteriaForm.submit();
	}
	}
		
}

function onSuccess(obj) {
	top.content.master_pages.maintabs.location.href = "../../eCA/jsp/ClinicalEventGroupMainTabs.jsp" ;
	top.content.master_pages.subtabs.location.href = "../../eCommon/html/blank.html";
	top.content.master_pages.criteria.location.href = "../../eCommon/html/blank.html" ;
	top.content.master_pages.result.location.href = "../../eCommon/html/blank.html" ;
	top.content.master_pages.add.location.href = "../../eCommon/html/blank.html" ;

	
}

function populateBatCntrSys(obj)
{

//if(flag != "frompanel")	
{
var optlen = document.forms[0].contr.options.length;

for (i=0; i<optlen; i++)
document.forms[0].contr.remove(0);

var opt=document.createElement('OPTION'); 
opt.text	=	'   ---- Select ----   ';
opt.value	=	'';
document.forms[0].contr.add(opt); 

if(obj.value == "CLNT")
	{
var opt=document.createElement('OPTION'); 
opt.text	=	'CA';
opt.value	=	'CA';
document.forms[0].contr.add(opt); 
    }
else if(obj.value == "PTCR")
	{

var opt=document.createElement('OPTION'); 
opt.text	=	'OR';
opt.value	=	'OR';
document.forms[0].contr.add(opt); 
    }
else if(obj.value == "TRET")
	{
var opt=document.createElement('OPTION'); 
opt.text	=	'OR';
opt.value	=	'OR';
document.forms[0].contr.add(opt); 
    }
else if(obj.value == "LBIN")
	{
var opt=document.createElement('OPTION'); 
opt.text	=	'OR';
opt.value	=	'OR';
document.forms[0].contr.add(opt); 
var opt=document.createElement('OPTION'); 
opt.text	=	'LB';
opt.value	=	'LB';
document.forms[0].contr.add(opt); 
    }
else if(obj.value == "RDIN")
	{
var opt=document.createElement('OPTION'); 
opt.text	=	'OR';
opt.value	=	'OR';
document.forms[0].contr.add(opt); 
var opt=document.createElement('OPTION'); 
opt.text	=	'RD';
opt.value	=	'RD';
document.forms[0].contr.add(opt); 
    }
else if(obj.value == "SUNT")
	{
var opt=document.createElement('OPTION'); 
opt.text	=	'OR';
opt.value	=	'OR';
document.forms[0].contr.add(opt); 
    }


}
}
function dispbatsearch()
{
var radio="";
if(document.EventBatchTabCriteriaForm.dataset(0).checked)
radio=document.EventBatchTabCriteriaForm.dataset(0).value;
else
radio=document.EventBatchTabCriteriaForm.dataset(1).value;

if(radio == "S")
	{
 
 top.content.master_pages.add.location.href="../../eCA/jsp/ClinicalEventGroupBatchEventSearch.jsp";
 
	}
	else
	{
     top.content.master_pages.criteria.batchbean.location.href="../../eCommon/html/blank.html";
    top.content.master_pages.add.location.href="../../eCommon/html/blank.html";
	}

}
function searchBatchEventGroup()
{




	var fields = new Array(top.content.master_pages.criteria.batchcriteria.document.forms[0].histype,
          top.content.master_pages.criteria.batchcriteria.document.forms[0].contr  
														);
	
	var names = new Array ( getLabel("Common.HistoryType.label",'COMMON'),
	getLabel("eCA.ContributingSystem.label",'CA'));	
							


	if(top.content.master_pages.criteria.batchcriteria.checkFields( fields, names, top.content.master_pages.messageFrame))
	{

var histype=parent.parent.criteria.batchcriteria.document.forms[0].histype.value;
var contr = parent.parent.criteria.batchcriteria.document.forms[0].contr.value;
var searchby = "";
if(top.content.master_pages.add.batsearchcri.document.forms[0].search_by(0).checked)
searchby=top.content.master_pages.add.batsearchcri.document.forms[0].search_by(0).value;
else
searchby=top.content.master_pages.add.batsearchcri.document.forms[0].search_by(1).value;

var criteria = top.content.master_pages.add.batsearchcri.document.forms[0].search_criteria.value;
var text= top.content.master_pages.add.batsearchcri.document.forms[0].search_text.value;


top.content.master_pages.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
parent.batsearchres.location.href = "../../eCA/jsp/ClinicalEventGroupBatchEventSearchResult.jsp?histype="+histype+"&contr="+contr+"&searchby="+searchby+"&criteria="+criteria+"&text="+text;
	}
}

function perform(ctrlChkBoxObj)
{
	var return_format="";
	var val ="";
	var retstr2="";
    var strval="";
	parent.parent.messageFrame.location.href="../../eCommon/html/blank.html"
	if(ctrlChkBoxObj.checked==true)
	{
		
		for(cnt=0; cnt<parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.count.value; cnt++)
		{
			
			val = eval("parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.chkbox"+cnt);
			if(!val.checked)
            {
				val.checked = true;
            strval=eval("parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.ret_value"+cnt);
			retstr2 = retstr2 + strval.value+"@";
			}
			
			
		}
		
		HTMLVal = "<form name='dummy_form' id='dummy_form' method='post' action='../../eCA/jsp/ClinicalEventGroupBatchEventSelected.jsp'><input type=hidden name='ret_str' id='ret_str' value='"+escape(retstr2)+"'><input type=hidden name='return_format' id='return_format' value='"+return_format+"'><input type=hidden name='sel_all' id='sel_all' value='select'></form>";
		parent.parent.messageFrame.document.body.insertAdjacentHTML('beforeend',HTMLVal);
		
		parent.parent.messageFrame.document.dummy_form.target = "batchbean";
		parent.parent.messageFrame.document.dummy_form.submit();
		
	   	//parent.RecClinicalNotesLinkDiagSelectButtonsFrame.document.RecClinicalNotesLinkDiagSelectButtonsForm.select.disabled=false;
		
	}
	
	else
	{
		for(cnt=0; cnt<parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.count.value; cnt++)
		{
			
			val = eval("parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.chkbox"+cnt);
			val.checked = false;
		}
		
		parent.parent.criteria.batchbean.document.location = "../../eCA/jsp/ClinicalEventGroupBatchEventSelected.jsp?return_format="+return_format+"&flag=clear&ret_str=";
	}

parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}
function scrollTitle()
{
	
  var y = parent.batsearchres.ClinicalEventGroupBatchEventSearchResultForm.document.body.scrollTop;

  if(y == 0){
	parent.batsearchres.ClinicalEventGroupBatchEventSearchResultForm.document.getElementById("divDataTitle").style.position = 'static';
	parent.batsearchres.ClinicalEventGroupBatchEventSearchResultForm.document.getElementById("divDataTitle").style.posTop  = 0;
  }else{
	parent.batsearchres.ClinicalEventGroupBatchEventSearchResultForm.document.getElementById("divDataTitle").style.position = 'relative';
	parent.batsearchres.ClinicalEventGroupBatchEventSearchResultForm.document.getElementById("divDataTitle").style.posTop  = y-2;
  }

}
var ret_str='';
function Reassaignbatch(obj)
{
	var return_format="";
		
	if(obj.checked)
	{
		var chkval = obj.value;
		//ret_str=parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.ret_value[parseInt(chkval)].value+"@";
		ret_str=eval("parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.ret_value"+chkval+".value")+"@";
					
		parent.parent.criteria.batchbean.location.href="../../eCA/jsp/ClinicalEventGroupBatchEventSelected.jsp?return_format="+return_format+"&ret_str="+escape(ret_str)+"";
		//parent.RecClinicalNotesLinkDiagSelectButtonsFrame.document.RecClinicalNotesLinkDiagSelectButtonsForm.select.disabled=false;
	}
			
	else
		{
			var chkval=obj.value;
			var remval=eval("parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.chk_value"+chkval+".value")
			
			//parent.ret_str=parent.ret_str+parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.ret_value[parseInt(remval)].value+"@";
			parent.parent.criteria.batchbean.location.href="../../eCA/jsp/ClinicalEventGroupBatchEventSelected.jsp?return_format="+return_format+"&remval="+escape(remval)+"&ret_str="+escape(ret_str)+"&removebean=Y";
			
		}	
}

function chkunchk(objCheck)
{
	var index = 0;
	if(objCheck.checked==false)
	{
		parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.ctrlChkBox.checked=false
	}
	else
	{
		for(cnt=0; cnt<parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.count.value; cnt++)
		{
			val = eval("parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.chkbox"+cnt);
			if(val.checked == true) index++;
		}
		if(index == cnt)
		{
			parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.ctrlChkBox.checked=true
		}
	}	
}
function selText(obj1)
{
	var return_format="";
	var clearchkval='';
	var clearremval='';
	if(!obj1.checked)
	{
		clearchkval=obj1.value;
		clearremval=eval("parent.batchbean.document.ClinicalEventGroupBatchBeanForm.clear"+clearchkval+".value");

		
	 	parent.batchbean.location.href="../../eCA/jsp/ClinicalEventGroupBatchEventSelected.jsp?return_format="+return_format+"&remval="+escape(clearremval)+"&removebean=Y";
		makeresultcheck(clearremval)

	}
}
function makeresultcheck(remval)
{
	
	for(cnt=0; cnt<parent.parent.add.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.count.value; cnt++)
	{
			val = eval("parent.parent.add.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.chkbox"+cnt);
			strval=eval("parent.parent.add.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.chk_value"+cnt+".value");
					
			if(strval==remval)
		{
				val.checked = false
   
			parent.parent.add.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.ctrlChkBox.checked = false 
		}

	}
	
   
  
}
function scrollTitle1()
{
	
  var y = document.body.scrollTop;
  

  if(y == 0){
	  document.getElementById("divDataTitle").style.position = 'static';
	  document.getElementById("divDataTitle").style.posTop  = 0;
  }else{
	  document.getElementById("divDataTitle").style.position = 'relative';
	  document.getElementById("divDataTitle").style.posTop  = y-2;
  }

}	
async function callrelinkGroup()
{

        var target				= document.forms[0].groupcode;
       // var eventgroup=top.contentdocument.forms[0].groupcode.value;
		var contr  = top.content.master_pages.criteria.linkcri.document.forms[0].contr.value;
		var histype = top.content.master_pages.criteria.linkcri.document.forms[0].histype.value;
		
		var retVal				=  new String();
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc="";
		var title=getLabel("eCA.EventGroup.label","CA");
		
		var sql="Select event_group, short_desc from cr_clin_event_group A where hist_rec_type = `"+histype+"` and event_group_type = `"+contr+"` " ; //and not exists (select 1 from cr_clin_event_group_link where hist_rec_type = a.hist_rec_type and contr_sys_event_group != a.event_group and event_group = a.event_group and event_group_type = a.event_group_type)";
      		
		search_code="event_group";
		search_desc="short_desc";
		retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
		 
		var arr=new Array();

		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
		   	arr=retVal.split("::");

		    //document.forms[0].shortdesc.value=arr[0];
			document.forms[0].groupcode.value=arr[1];
			document.forms[0].groupcoder.value=arr[0];
			
		}
		else
		{
			document.forms[0].groupcode.value="";
			document.forms[0].groupcoder.value="";
			//document.forms[0].shortdesc.value="";
			
		}
}

function searchrelinkEventGroup()
{
var contr  = top.content.master_pages.criteria.linkcri.document.forms[0].contr.value;
var histype = top.content.master_pages.criteria.linkcri.document.forms[0].histype.value;
var groupcode = top.content.master_pages.criteria.linkcri.document.forms[0].groupcode.value;

var fields = new Array(top.content.master_pages.criteria.linkcri.document.forms[0].histype,
		                    top.content.master_pages.criteria.linkcri.document.forms[0].contr,  
							top.content.master_pages.criteria.linkcri.document.forms[0].groupcode
							);
var names = new Array ( getLabel("Common.HistoryType.label",'COMMON'),
							getLabel("eCA.ContributingSystem.label",'CA'),
		                    getLabel("eCA.EventGroupCode.label",'CA')
				
							);		
							


	if(top.content.master_pages.criteria.linkcri.checkFields( fields, names, top.content.master_pages.messageFrame))
	{	

top.content.master_pages.criteria.linkbean.location.href="../../eCA/jsp/ClinicalEventGroupRelinkSelected.jsp?mode=ins&histype="+histype+"&contr="+contr+"&groupcode="+groupcode+"";
top.content.master_pages.add.location.href="../../eCA/jsp/ClinicalEventGroupRelinkSearch.jsp"
;
top.content.master_pages.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	}

}
function searchGroup()
{

var contr  = top.content.master_pages.criteria.linkcri.document.forms[0].contr.value;
var histype = top.content.master_pages.criteria.linkcri.document.forms[0].histype.value;

var searchby = "";
if(top.content.master_pages.add.linksearchcri.document.forms[0].search_by(0).checked)
searchby=top.content.master_pages.add.linksearchcri.document.forms[0].search_by(0).value;
else
searchby=top.content.master_pages.add.linksearchcri.document.forms[0].search_by(1).value;

var criteria = top.content.master_pages.add.linksearchcri.document.forms[0].search_criteria.value;
var text= top.content.master_pages.add.linksearchcri.document.forms[0].search_text.value;

 top.content.master_pages.add.linksearchres.location.href="../../eCA/jsp/ClinicalEventGroupRelinkSearchResult.jsp?histype="+histype+"&contr="+contr+"&searchby="+searchby+"&criteria="+criteria+"&text="+text+"";
	
}
function scrollTitleRelink()
{
	
  var y = parent.linksearchres.ClinicalEventGroupRelinkEventSearchResultForm.document.body.scrollTop;

  if(y == 0){
	parent.linksearchres.ClinicalEventGroupRelinkEventSearchResultForm.document.getElementById("divDataTitle").style.position = 'static';
	parent.linksearchres.ClinicalEventGroupRelinkEventSearchResultForm.document.getElementById("divDataTitle").style.posTop  = 0;
  }else{
	parent.linksearchres.ClinicalEventGroupRelinkEventSearchResultForm.document.getElementById("divDataTitle").style.position = 'relative';
	parent.linksearchres.ClinicalEventGroupRelinkEventSearchResultForm.document.getElementById("divDataTitle").style.posTop  = y-2;
  }

}

function performRelink(ctrlChkBoxObj)
{
	var return_format="";
	var val ="";
	var retstr2="";
    var strval="";
	parent.parent.messageFrame.location.href="../../eCommon/html/blank.html"
	if(ctrlChkBoxObj.checked==true)
	{
		
		for(cnt=0; cnt<parent.linksearchres.document.ClinicalEventGroupRelinkEventSearchResultForm.count.value; cnt++)
		{
			
			val = eval("parent.linksearchres.document.ClinicalEventGroupRelinkEventSearchResultForm.chkbox"+cnt);
			if(!val.checked)
            {
				val.checked = true;
            strval=eval("parent.linksearchres.document.ClinicalEventGroupRelinkEventSearchResultForm.ret_value"+cnt);
			retstr2 = retstr2 + strval.value+"@";
			}
			
			
		}
		
		HTMLVal = "<form name='dummy_form' id='dummy_form' method='post' action='../../eCA/jsp/ClinicalEventGroupRelinkSelected.jsp'><input type=hidden name='ret_str' id='ret_str' value='"+escape(retstr2)+"'><input type=hidden name='return_format' id='return_format' value='"+return_format+"'><input type=hidden name='sel_all' id='sel_all' value='select'></form>";
		parent.parent.messageFrame.document.body.insertAdjacentHTML('beforeend',HTMLVal);
		
		parent.parent.messageFrame.document.dummy_form.target = "linkbean";
		parent.parent.messageFrame.document.dummy_form.submit();
		
	   	//parent.RecClinicalNotesLinkDiagSelectButtonsFrame.document.RecClinicalNotesLinkDiagSelectButtonsForm.select.disabled=false;
		
	}
	
	else
	{
		for(cnt=0; cnt<parent.linksearchres.document.ClinicalEventGroupRelinkEventSearchResultForm.count.value; cnt++)
		{
			
			val = eval("parent.linksearchres.document.ClinicalEventGroupRelinkEventSearchResultForm.chkbox"+cnt);
			val.checked = false;
		}
		
		parent.parent.criteria.linkbean.document.location = "../../eCA/jsp/ClinicalEventGroupRelinkSelected.jsp?return_format="+return_format+"&flag=clear&ret_str=";
	}

parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}

function Reassaignrelink(obj)
{
	var return_format="";
		
	if(obj.checked)
	{
		var chkval = obj.value;
		//ret_str=parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.ret_value[parseInt(chkval)].value+"@";
		ret_str=eval("parent.linksearchres.document.ClinicalEventGroupRelinkEventSearchResultForm.ret_value"+chkval+".value")+"@";
		parent.parent.criteria.linkbean.location.href="../../eCA/jsp/ClinicalEventGroupRelinkSelected.jsp?return_format="+return_format+"&ret_str="+escape(ret_str)+"";
		//parent.RecClinicalNotesLinkDiagSelectButtonsFrame.document.RecClinicalNotesLinkDiagSelectButtonsForm.select.disabled=false;
	}
			
	else
		{
			var chkval=obj.value;
			var remval=eval("parent.linksearchres.document.ClinicalEventGroupRelinkEventSearchResultForm.chk_value"+chkval+".value")
			//parent.ret_str=parent.ret_str+parent.batsearchres.document.ClinicalEventGroupBatchEventSearchResultForm.ret_value[parseInt(remval)].value+"@";
			parent.parent.criteria.linkbean.location.href="../../eCA/jsp/ClinicalEventGroupRelinkSelected.jsp?return_format="+return_format+"&remval="+escape(remval)+"&ret_str="+escape(ret_str)+"&removebean=Y";
			
		}	
}

function chkunchkrelink(objCheck)
{
	var index = 0;
	if(objCheck.checked==false)
	{
		parent.linksearchres.document.ClinicalEventGroupRelinkEventSearchResultForm.ctrlChkBox.checked=false
	}
	else
	{
		for(cnt=0; cnt<parent.linksearchres.document.ClinicalEventGroupRelinkEventSearchResultForm.count.value; cnt++)
		{
			val = eval("parent.linksearchres.document.ClinicalEventGroupRelinkEventSearchResultForm.chkbox"+cnt);
			if(val.checked == true) index++;
		}
		if(index == cnt)
		{
			parent.linksearchres.document.ClinicalEventGroupRelinkEventSearchResultForm.ctrlChkBox.checked=true
		}
	}	
}

function selTextrelink(obj1)
{
	var return_format="";
	var clearchkval='';
	var clearremval='';
	if(!obj1.checked)
	{
		clearchkval=obj1.value;
		clearremval=eval("parent.linkbean.document.ClinicalEventGroupRelinkBeanForm.clear"+clearchkval+".value");

		
	 	parent.linkbean.location.href="../../eCA/jsp/ClinicalEventGroupRelinkSelected.jsp?return_format="+return_format+"&remval="+escape(clearremval)+"&removebean=Y";
		makeresultcheckrelink(clearremval)

	}
}
function makeresultcheckrelink(remval)
{
	if(parent.parent.add.linksearchres.document.ClinicalEventGroupRelinkEventSearchResultForm != null)
	{
	for(cnt=0; cnt<parent.parent.add.linksearchres.document.ClinicalEventGroupRelinkEventSearchResultForm.count.value; cnt++)
	{
			val = eval("parent.parent.add.linksearchres.document.ClinicalEventGroupRelinkEventSearchResultForm.chkbox"+cnt);
			strval=eval("parent.parent.add.linksearchres.document.ClinicalEventGroupRelinkEventSearchResultForm.chk_value"+cnt+".value");
			
					
			if(strval==remval)
		{
				val.checked = false
   
			parent.parent.add.linksearchres.document.ClinicalEventGroupRelinkEventSearchResultForm.ctrlChkBox.checked = false 
		}

	}
	}
}
function clearRelink()
{
top.content.master_pages.criteria.location.href="../../eCA/jsp/ClinicalEventGroupRelinkMain.jsp";
top.content.master_pages.add.location.href="../../eCommon/html/blank.html";
}

