function create()
{
//	adv_reac.rows = "42,185,*,40";
	document.getElementById("f_query_add_mod").style.height = "25vh" ;
	document.getElementById("f_query_add_mod2").style.height = "57vh" ;

	frames[1].location.href='../../eMR/jsp/AdverseReactionCriteria.jsp';
	frames[2].location.href='../../eCommon/html/blank.html';

}
function query()
{
//	parent.adv_reac.rows = "42,*,30,40";
	document.getElementById("f_query_add_mod").style.height = "55vh" ;
	document.getElementById("f_query_add_mod2").style.height = "27vh" ;
	frames[1].location.href='../../eMR/jsp/AdverseReactionQueryCriteria.jsp';
	frames[2].location.href='../../eCommon/html/blank.html';
}

 function checkIsValidForProceed()
{

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1))
		return true;
	else
		return false;
}

 function checkIsValidForProceed1()
{

	var url = f_query_add_mod2.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1))
		return true;
	else
		return false;
}

function scrollTitle()
{
  var x = document.body.scrollTop;

  if(x == 0){
	 
   document.getElementById("head1").style.position='static';
   document.getElementById("head1").style.posTop  = 0;
   document.getElementById("head3").style.position='static';
   document.getElementById("head3").style.posTop  = 0;

   }else{
	document.getElementById("head1").style.position = 'relative';
	document.getElementById("head1").style.posTop  = x-5;
	document.getElementById("head3").style.position = 'relative';
	document.getElementById("head3").style.posTop  = x-5;
	
	 }

}

function selectAll_S(obj){
	len=document.querySelectorAll("#check_box").length;
	if (len!=null){
		if (obj.checked){
			for (i=0;i<len;i++){
				document.querySelectorAll("#check_box")[i].checked=true;
			}
		}else{
			for (i=0;i<len;i++){
				document.querySelectorAll("#check_box")[i].checked=false;
			}
		}
	}else{
		if (obj.checked){
			document.getElementById("check_box").checked=true;
		}else{
			document.getElementById("check_box").checked=false;
		}
	}
}

function checkBoxOnClick(obj){

if (obj.checked==false){
	document.getElementById("selectall").checked=false;
}
}
//function to check whether on apply,the flow can be proceeded...
function checkIsValidForProceed()
{
		var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}
//function whether the flow can proceed if on click of apply
function checkIfApply()
{
	var url=f_query_add_mod2.location.href;
	url=url.toLowerCase();
	if(url.indexOf("blank")==-1)
		return true;
	else
		return false;
}

function apply ()
{
		
	if((! checkIsValidForProceed()) || (! checkIfApply()) )
	{
		message  = getMessage("APPLY_NOT_VALID",'MR');
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	var finalval="";
	var cnt= frames[2].document.forms[0].cnt.value;
	var causative_code="";
	var reaction_val="";
	var allergen_code_all="";
	for (var i=0;i<=cnt ;i++ ){
			if(eval("frames[2].document.forms[0].checkBox"+i))
			{
				allergen_code_all = allergen_code_all + frames[2].document.forms[0]["ret_value" + i].value + "|";
				if(eval("frames[2].document.forms[0].checkBox"+i).checked ==true)
				{
					eval("frames[2].document.forms[0].checkBox"+i).value='E';
					var eff_status = frames[2].document.forms[0]["checkBox" + i].value;
					var allergen_code= eval("frames[2].document.forms[0].ret_value"+i).value;

					finalval=finalval + allergen_code+"|"+eff_status +"$";
				}
			}

	}	
	
	frames[2].document.forms[0].finalval.value=finalval;
	frames[2].document.forms[0].allergen_code_all.value=allergen_code_all;
	frames[2].document.forms[0].action="../../servlet/eMR.AdverseReactionServlet";
	frames[2].document.forms[0].target="messageFrame";
	//frames[2].document.forms[0].submit();
	setTimeout(function() {
	    frames[2].document.forms[0].submit();
	}, 700);
}

function callcriteria(code,obj,ADVR_TYPE)
{
	parent.adv_reac.rows = "42,100,*,40";
	parent.frames[1].location.href='../../eMR/jsp/AdverseReactionCriteria.jsp?ADV_REAC_CODE='+code+'&mode=modify';
	parent.frames[2].location.href='../../eMR/jsp/AdverseReactionResult.jsp?ADV_REAC_CODE='+code+'&ADVR_TYPE='+ADVR_TYPE+'&mode=modify';
}
function reset() {


		if(f_query_add_mod.document.forms[0])
		   f_query_add_mod.document.location.reload();

        if(f_query_add_mod2.document.forms[0])
			 f_query_add_mod2.location.href='../../eCommon/html/blank.html';

}

function serach_results()
{
	parent.frames[3].location.href='../../eCommon/jsp/MstCodeError.jsp';
	var reac_code=parent.frames[1].document.forms[0].reac_long_desc.value;
	var adv_event_type=parent.frames[1].document.forms[0].adv_evnt_type.value;
	var adv_event_indicator=parent.frames[1].document.forms[0].sel_rec_type.value;
	adv_event_type=adv_event_type.split("|");
	var adv_event_type_code=adv_event_type[0];
	var search_by=document.forms[0].search_by.value;
	var search_txt=document.forms[0].search_txt.value;

if(adv_event_indicator=="" || adv_event_type =="")
{
	var error=getMessage("CAN_NOT_BE_BLANK",'common');
	error=error.replace("$",getLabel("eMR.AdverseEventTypeIndicator.label","MR"));
	alert(error);
}else
	{
	var url='../../eMR/jsp/AdverseReactionResult.jsp?reac_code='+reac_code+'&adv_event_type='+adv_event_type_code+'&adv_event_indicator='+adv_event_indicator+'&search_by='+search_by+'&search_txt='+search_txt;
	parent.frames[2].location.href=url;
	}
}

function enable_search(obj)
{
	if(obj.value ==null || obj.value =="")
	{	
		document.forms[0].search.disabled=true;
		document.forms[0].sel_rec_type.value="";
		document.forms[0].adv_evnt_type.value="";
		
		parent.frames[2].location.href='../../eCommon/html/blank.html';
		parent.frames[3].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}else 
	{
		document.forms[0].sel_rec_type.value="";
		document.forms[0].adv_evnt_type.value="";
		document.forms[0].search.disabled=false;
		parent.frames[2].location.href='../../eCommon/html/blank.html';
		parent.frames[3].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
}

function onSuccess()
{
	//var err_num="APP-SM0001 Operation Completed Successfully ....";
  //	parent.parent.parent.frames[2].frames[1].frames[3].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+err_num;
 
// parent.parent.parent.frames[2].frames[1].frames[1].location.href='../../eMR/jsp/AdverseReactionCriteria.jsp';
// parent.parent.parent.frames[2].frames[1].frames[2].location.href='../../eCommon/html/blank.html';
 	frames[1].location.href='../../eMR/jsp/AdverseReactionCriteria.jsp';
	frames[2].location.href='../../eCommon/html/blank.html';



}

function get_adv_events(obj)
{
	var adv_evnt_val=obj.value;
//alert(adv_evnt_val);
	if(adv_evnt_val !="")
	{
	document.forms[0].adv_evnt_type.disabled=false;
	}else
	{
			document.forms[0].adv_evnt_type.options.selectedIndex=0;

	document.forms[0].adv_evnt_type.disabled=true;
	}

	var xmlDoc= ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH ADV_EVENT_TYPE_IND=\""+adv_evnt_val+"\" steps='1'/></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","AdverseEventType.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	responseText = responseText.replace(/<[^>]*>/g, ''); // remove any HTML tags from js response
	eval(responseText)

}

function submitPrevNext(from,to,obj)
{
	var finalval="";
	document.forms[0].cnt.value=from;

	var causative_code="";
	var reaction_val="";
	var allergen_code_all="";
	var search_by=document.forms[0].search_by.value;
	var search_txt=document.forms[0].search_txt.value;



	for (var i=0;i<=from ;i++ )
		{
			if(eval("document.forms[0].checkBox"+i))
			{
				allergen_code_all = allergen_code_all + document.forms[0]["ret_value" + i].value + "|";
				if(eval("document.forms[0].checkBox"+i).checked ==true)
				{
					eval("document.forms[0].checkBox"+i).value='E';
					var eff_status = document.forms[0].elements["checkBox" + i].value;
					var allergen_code= eval("document.forms[0].ret_value"+i).value;

					finalval=finalval + allergen_code+"|"+eff_status +"$";
				}
			}

		}
		
			var reaction_code	= document.forms[0].reac_code.value ;
			var adv_event_type_ind	=document.forms[0].adv_event_type_ind.value ;
			var adv_event_type	= document.forms[0].adv_event_type.value ;
/*			document.forms[0].finalval.value=finalval;

if(finalval =="")
	{
			
	parent.frames[2].location.href = '../../eMR/jsp/AdverseReactionResult.jsp?reac_code='+reaction_code+"&adv_event_type="+adv_event_type+"&adv_event_indicator="+adv_event_type_ind+"&from="+from+"&to="+to+'&search_by='+search_by+'&search_txt='+search_txt;

	}else
	{*/
			if(confirm(getMessage('WANT_TO_SAVE','Common')))
	{
		parent.frames[2].document.forms[0].isOnApply.value='Y';
		parent.frames[2].document.forms[0].finalval.value=finalval;
		parent.frames[2].document.forms[0].allergen_code_all.value=allergen_code_all;
		parent.frames[2].document.forms[0].action="../../servlet/eMR.AdverseReactionServlet?to="+to+"";
		parent.frames[2].document.forms[0].target="messageFrame";
		parent.frames[2].document.forms[0].submit();
		}else
		{
			var URL='../../eMR/jsp/AdverseReactionResult.jsp?reac_code='+reaction_code+"&adv_event_type="+adv_event_type+"&adv_event_indicator="+adv_event_type_ind+"&from="+from+"&to="+to+'&search_by='+search_by+'&search_txt='+search_txt;
			
			parent.frames[2].location.href =URL; 
		}
	//}
	
}

function reloadResultPage(to)
{
			var reaction_code	= f_query_add_mod.document.forms[0].reac_long_desc.value ;
			var adv_event_type_ind	=f_query_add_mod.document.forms[0].sel_rec_type.value ;
			var adv_event_type	= f_query_add_mod.document.forms[0].adv_evnt_type.value ;
			
			adv_event_type=adv_event_type.split("|");
	      var adv_event_type_code=adv_event_type[0];
			var from =f_query_add_mod2.document.getElementById("cnt").value;
			//var to = f_query_add_mod2.document.getElementById("cnt_to").value
			var search_by = f_query_add_mod.document.forms[0].search_by.value;
			var search_txt = f_query_add_mod.document.forms[0].search_txt.value;
			var URL='../eMR/jsp/AdverseReactionResult.jsp?reac_code='+reaction_code+'&adv_event_type='+adv_event_type_code+'&adv_event_indicator='+adv_event_type_ind+'&from='+from+'&to='+to+'&search_by='+search_by+'&search_txt='+search_txt;
			
			
			f_query_add_mod2.location.href=URL;
			messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp';
			
}

function claerResultPage(){
	parent.frames[2].location.href='../../eCommon/html/blank.html';
		parent.frames[3].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
}
