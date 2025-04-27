var curr_obj = "document.getElementById(\"associated_lb\")";
var prev_obj= "";


function searchDetails()
 {
	  parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp'; 
	  var frmobj=parent.frames[0].document.forms[0] ;
	  var fields = new Array (frmobj.age_group_code,frmobj.term_set_id);
	  var names = new Array (getLabel("Common.agegroup.label","Common"),getLabel("Common.TerminologySet.label","Common"));
	  var msgFrame=parent.parent.messageFrame;
	  var flag = true ;

	  


	  
	  if(parent.f_query_header.checkFieldsofMst( fields, names, msgFrame))
	  {		
		
		
	var term_set_id=document.forms[0].term_set_id.value;
	var age_group_code=document.forms[0].age_group_code.value;
	/*
		Getting the termsets which is not select the diffrent age group of same term set
	*/
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eMR/jsp/AgeGroupForTermCodeDynamicValues.jsp?	term_set_id="+encodeURIComponent(term_set_id)+"&age_group_code="+encodeURIComponent(age_group_code)+"&ageGroupCode=1", false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	responseText = responseText.replace(/<[^>]*>/g, '');
	eval(responseText);

	/*
		End here
	*/
			
			parent.frames[1].location.href='../../eMR/jsp/AgeGroupForTermCodeHyperLinks.jsp?term_set_id='+frmobj.term_set_id.value+'&type='+frmobj.type.value+'&age_group_code='+frmobj.age_group_code.value+'&term_code_desc='+frmobj.term_code_desc.value+'&search_criteria='+frmobj.search_criteria.value+'&flag='+flag;
	  }
 }



  function apply()
{

		//if (parent.frames[2].frames[1].frames[0].document.forms[0]=='') {
		 if (! checkIsValidForProceed4()){ 
		message  = getMessage("APPLY_NOT_VALID",'MR');
		frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
		return false ;
	  }

	  var frmobj=parent.frames[2].frames[1].frames[2].document.forms[0];
	if (! checkIsValidForProceed() ) {
		message  =" ";
		frames[2].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	 if (!checkIsValidForProceed1()){
		message  = " ";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed2()){
		message  = " ";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	frmobj.submit();

}
/********************************************************************************/
function checkIsValidForProceed()
{

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}

function checkIsValidForProceed1()
{		var url = f_query_add_mod.f_query_header.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}

function checkIsValidForProceed2()
{		var url = f_query_add_mod.f_query_detail.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}
function checkIsValidForProceed3()
{		var url = f_query_add_mod.Dummy.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}
function checkIsValidForProceed4()
{		var url = f_query_add_mod.f_query_hyperlink.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}


/******************************************************************************************/
function reset()
{
	var f1 = parent.frames[2].frames[1].frames[0].document.forms[0];
	var f2 = parent.frames[2].frames[1].frames[0].document.forms[0];
	var f3 = parent.frames[2].frames[1].frames[0].document.forms[0];
	

	if (f1!=null )
		parent.frames[2].f_query_add_mod.f_query_header.document.location.reload();
	if (f2!=null )
		parent.frames[2].f_query_add_mod.f_query_hyperlink.document.location.href='../../eCommon/html/blank.html';
	if (f3!=null )
		parent.frames[2].f_query_add_mod.f_query_detail.document.location.href='../../eCommon/html/blank.html';
		parent.frames[2].messageFrame.location.href='../../eCommon/html/blank.html';
}

/*********************************************************************************/
function onSuccess()
  {
	    frames[1].frames[0].document.forms[0].reset();
		frames[1].frames[1].location.href='../../eCommon/html/blank.html';
		frames[1].frames[2].location.href='../../eCommon/html/blank.html';
  }

/*****************************************************************************************/
function updateValue(obj)
	{
	var frmobj=document.form_AgeGrupdetail;
	var alphalink=frmobj.alphalink.value;
	var term_set_id=frmobj.term_set_id.value;
	var age_group_code=frmobj.age_group_code.value;
	
	var code=obj.value;
	
	var flag=0;
	if(obj.checked==true)
		flag=1;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eMR/jsp/AgeGroupForTermCodeDynamicValues.jsp?code="+encodeURIComponent(code)+"&flag="+encodeURIComponent(flag)+"&alphalink="+encodeURIComponent(alphalink)+"&term_set_id="+encodeURIComponent(term_set_id)+"&age_group_code="+encodeURIComponent(age_group_code)+"&select=Update", false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	responseText = responseText.replace(/<[^>]*>/g, '');
	eval(responseText);
}
/*****************************************************************************************/
function setchkAll(obj)
{
	var formobj	=document.form_AgeGrupdetail;
	 var frmobj1=parent.f_query_header.document.form_AgeGroupForTermCode;
	 var alphalink=formobj.alphalink.value;
		var obj1 = formobj[alphalink + "chkAll"];
		var obj2 = frmobj1[alphalink + "chkAll"];
	 	if(obj.checked==false && obj2.value=="Y")
	{
		obj2.value="";
		//obj1.checked=false;
	}
}
/****************************************************************************************/
function checkAll(flag)
{
	var frmobj=document.form_AgeGrupdetail;
	var alphalink=frmobj.alphalink.value;
	var start				=		parseInt(frmobj.start.value)+1;
	var end					=		parseInt(frmobj.end.value)+1;
	var maxrecords		=		parseInt(frmobj.maxRecords.value)+1;
	if(end>maxrecords)
		end=maxrecords;
	for(var index=start-1;index<end-1;index++){
		obj = frmobj[alphalink + "chk" + index];
		if(flag==1)
			obj.checked=true;
		else
			obj.checked=false;
	}
}
/*****************************************************************************************/
function submitPrevNext(from, to){
		var frmobj=document.form_AgeGrupdetail;
		var term_code_desc=parent.frames[0].document.forms[0].term_code_desc.value;
		var search_criteria=parent.frames[0].document.forms[0].search_criteria.value;
		//alert("term_code_desc---->"+term_code_desc);
		//alert("search_criteria---->"+search_criteria);
		frmobj.from.value=from;
		frmobj.to.value=to;
	    var term_set_id=frmobj.term_set_id.value;
		var age_group_code=frmobj.age_group_code.value;
		var alphalink=frmobj.alphalink.value;
		var type=frmobj.type.value;	parent.f_query_detail.location.href='../../eMR/jsp/AgeGroupForTermCodeDetail.jsp?from='+frmobj.from.value+'&to='+frmobj.to.value+'&term_set_id='+term_set_id+'&age_group_code='+age_group_code+'&alphalink='+alphalink+'&type='+type+'&term_code_desc='+term_code_desc+'&search_criteria='+search_criteria;
	}
/*************************************************************************************/
function loadDetail(obj,age_group_code,term_set_id,type,term_code_desc,search_criteria,alphalink)
	{
		//alert("term_code_desc---->"+term_code_desc);
		//alert("search_criteria---->"+search_criteria);
		//if(term_code_desc=="")
			term_code_desc=parent.frames[0].document.forms[0].term_code_desc.value;
			search_criteria=parent.frames[0].document.forms[0].search_criteria.value;
		//alert("term_code_desc---->"+term_code_desc);
		//alert("search_criteria---->"+search_criteria);
		prev_obj	=	eval(curr_obj);
		curr_obj	=	document.getElementById(obj.id);
		new_obj		=	eval(curr_obj);
		old_obj		=	eval(prev_obj);
		new_obj.innerHTML	=	"<u><font color='maroon'>"+new_obj.innerText+"</font></u>";
		old_obj.innerHTML	=	"<td><u>"+old_obj.innerText+"</u></td>";
		parent.f_query_detail.location.href="../../eMR/jsp/AgeGroupForTermCodeDetail.jsp?age_group_code="+age_group_code+"&term_set_id="+term_set_id+"&type="+type+"&term_code_desc="+term_code_desc+"&search_criteria="+search_criteria+"&fromSearch=true&alphalink="+alphalink;
	}
	/****************************************************************/
function loadtype(obj)
{
	var term_set_id=obj.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eMR/jsp/AgeGroupForTermCodeDynamicValues.jsp?term_set_id="+term_set_id, false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	responseText = responseText.replace(/<[^>]*>/g, '');
	eval(responseText);
}
/*
1/9/2009
*/
function _cleanResult(){
	parent.parent.frames[2].document.location.href='../../eCommon/jsp/MstCodeError.jsp';
	parent.frames[1].location.href='../../eCommon/html/blank.html';
	parent.frames[2].location.href='../../eCommon/html/blank.html';

	/*
	this is function clear the session
	*/
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eMR/jsp/AgeGroupForTermCodeDynamicValues.jsp?_clearSession=clear", false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	responseText = responseText.replace(/<[^>]*>/g, '');
	eval(responseText);
	/*
	End of clear session
	*/
}
function assignLevels(values)
{
	var levels=values.split("||");
	var frmobj=parent.f_query_header.document.form_AgeGroupForTermCode;
	var obj = eval(frmobj.type);
	var flag=0;
	clearData(obj);
	var diag_spec_yn = levels[0];
	var proc_spec_yn = levels[1];
	if(diag_spec_yn == 'Y' && proc_spec_yn == 'Y')
	{
		var opt	= eval(document.createElement('OPTION'));
		opt.value =	trimString("DX");
		opt.text = getLabel("Common.diagnosis.label","Common");
		obj.add(opt);
		var opt	= eval(document.createElement('OPTION'));
		opt.value =	trimString("PR");
		opt.text = getLabel("Common.Procedure.label","Common");
		obj.add(opt);
		flag=1;
	}
	if(diag_spec_yn == 'Y' && proc_spec_yn == 'N')
	{
		var opt	= eval(document.createElement('OPTION'));
		opt.value =	trimString("DX");
		opt.text = getLabel("Common.diagnosis.label","Common");
		obj.add(opt);
		flag=1;
	}
	if(diag_spec_yn == 'N' && proc_spec_yn == 'Y')
	{
		var opt	= eval(document.createElement('OPTION'));
		opt.value =	trimString("PR");
		opt.text = getLabel("Common.Procedure.label","Common");
		obj.add(opt);
		flag=1;
	}
	if(flag==0)
	{
		var opt	= eval(document.createElement('OPTION'));
		opt.value =	trimString("");
		opt.text ="---"+getLabel("Common.defaultSelect.label","Common")+"---";
		obj.add(opt);
	}
}
function clearData(obj) 
{
	obj = eval(obj);
	var len = obj.length;
	for (var i=0; i<=len; i++) 
	{
		obj.remove("");
	}
}

function CheckForSpecChar(event){
	var strCheck = ' ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode); 
	if (!(strCheck.indexOf(key) == -1) && parent.frames[0].document.forms[0].term_code_desc.value.length==0 )
	   return false;  
	return true ;
}
