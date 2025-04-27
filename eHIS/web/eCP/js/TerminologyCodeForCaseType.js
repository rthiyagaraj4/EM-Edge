//This file is saved on 18/10/2005.


var curr_obj ="document.getElementById('associated_lbl')";
var prev_obj= "";

async function selectNature(target)
{

	var frmobj=parent.f_query_header.document.form_TerminologyCodeForCaseType ;
	frmobj.short_desc.value='';
	frmobj.case_type_code.value="";
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

 	//argumentArray[0] ="Select case_type_code code, short_desc description from cp_case_type where eff_status = 'E' AND UPPER(case_type_code) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?) order by short_desc";
 	argumentArray[0] ="Select case_type_code code, short_desc description from cp_case_type_lang_vw where eff_status = 'E' and language_id like ? AND UPPER(case_type_code) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?)  order by short_desc";

		dataNameArray[0] ="locale";
		dataValueArray[0]= frmobj.locale.value;
		dataTypeArray[0] = STRING;

		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "2,3"; 
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_DESC_LINK;//CODE_LINK
		argumentArray[7] = CODE_DESC;//CODE_DESC
		retVal = await CommonLookup(getLabel("eCP.CaseType.label","CP"), argumentArray );
		
		if(retVal != null && retVal != "") {
				var ret1=unescape(retVal);
				var arr=ret1.split(",");
				if(arr[1]==undefined) 
				{
					arr[0]="";	
					arr[1]="";	
				}
			target.value = arr[1] ;
			var case_type_desc= arr[1] ;

			document.forms[0].case_type_code.value = arr[0];
	
 			var case_type_code=arr[0];
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			//to get the period for selected requirement
			xmlHttp.open( "POST","../../eCP/jsp/TerminologyCodeForCaseTypeDynamicValues.jsp?case_type_code="+case_type_code+"&case_type_desc="+case_type_desc+"&select=lookup", false);
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText);
			
		}else{
			target.value ="";
			frmobj.case_type_nature.value="";
			document.getElementById("req_nature").innerText=" ";
		}
		frmobj.term_set_id.selectedIndex=0;
		frmobj.term_code_desc.value='';
		frmobj.search_criteria.selectedIndex=0;
		frmobj.wellness_yn.selectedIndex=0;
		clearDetail();
}

/********************************************************************************/

function assignNature(case_type_nature){
	
	var frmObj=parent.frames[0].document.forms[0];
	var case_type_nature=case_type_nature;
	frmObj.case_type_nature.value=case_type_nature;
	document.getElementById("req_nature").innerText=case_type_nature;

	}

/************************************************************************************/
function displayNature(obj){
	
	var frmObj=parent.frames[0].document.forms[0];
	var case_type_nature=frmObj.case_type_nature.value;
	obj.innerText="   "+case_type_nature;

}
/*************************************************************************************/
function searchDetails()
  {
	  var frmobj=parent.frames[0].document.forms[0] ;
	  var fields = new Array (frmobj.case_type_code,frmobj.term_set_id);
	  var names = new Array (getLabel("eCP.CaseType.label","CP"),getLabel("Common.TerminologySet.label","Common"));
	  var msgFrame=parent.parent.messageFrame;
	  var flag = true ;
	  if(parent.f_query_header.checkFieldsofMst( fields, names, msgFrame))
		{		   				
		 parent.frames[1].location.href='../../eCP/jsp/TerminologyCodeForCaseTypeHyperLinks.jsp?term_set_id='+frmobj.term_set_id.value+'&type='+frmobj.wellness_yn.value+'&case_type_code='+frmobj.case_type_code.value+'&short_desc='+frmobj.term_code_desc.value+'&search_criteria='+frmobj.search_criteria.value+'&flag='+flag;
		 parent.frames[2].location.href='../../eCP/jsp/TerminologyCodeForCaseTypeDetail.jsp?term_set_id='+frmobj.term_set_id.value+'&type='+frmobj.wellness_yn.value+'&case_type_code='+frmobj.case_type_code.value+'&short_desc='+frmobj.term_code_desc.value+'&search_criteria='+frmobj.search_criteria.value+'&alphalink=Associated';
		 var frmObj=document.forms[0];
		 frmObj.AssociatedchkAll.value='Y';
		 frmObj.AchkAll.value='';
		 frmObj.BchkAll.value='';
		 frmObj.CchkAll.value='';
		 frmObj.DchkAll.value='';
		 frmObj.EchkAll.value='';
		 frmObj.FchkAll.value='';
		 frmObj.GchkAll.value='';
		 frmObj.HchkAll.value='';
		 frmObj.IchkAll.value='';
		 frmObj.JchkAll.value='';
		 frmObj.KchkAll.value='';
		 frmObj.LchkAll.value='';
		 frmObj.MchkAll.value='';
		 frmObj.NchkAll.value='';
		 frmObj.OchkAll.value='';
		 frmObj.PchkAll.value='';
		 frmObj.QchkAll.value='';
		 frmObj.RchkAll.value='';
		 frmObj.SchkAll.value='';
		 frmObj.TchkAll.value='';
		 frmObj.UchkAll.value='';
		 frmObj.VchkAll.value='';
		 frmObj.WchkAll.value='';
		 frmObj.XchkAll.value='';
		 frmObj.YchkAll.value='';
		 frmObj.ZchkAll.value='';
		 frmObj._chkAll.value='';
	 		 
		}
  }

  /*****************************************************************************************/
  function apply()
{
	 var frmobj=parent.frames[2].frames[1].document.forms[0];
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
		//message  = " ";
		//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		//alert(f_query_add_mod.f_query_header.document.form_TerminologyCodeForCaseType.name);
		var frmobj=f_query_add_mod.f_query_header.document.form_TerminologyCodeForCaseType;
		var fields = new Array (frmobj.case_type_code,frmobj.term_set_id);
		
		var names = new Array (getLabel("eCP.CaseType.label","CP"),getLabel("Common.TerminologySet.label","Common"))
			if(f_query_add_mod.f_query_header.checkFieldsofMst( fields, names, messageFrame))
			parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			return false ;
	}
		
	parent.frames[2].frames[1].frames[2].document.forms[0].action="../../servlet/eCP.TerminologyCodeForCaseTypeServlet";
	parent.frames[2].frames[1].frames[2].document.forms[0].target="messageFrame";
	parent.frames[2].frames[1].frames[2].document.forms[0].submit();

}
/*********************************************************************************/

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
{	var url = f_query_add_mod.f_query_detail.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1 ))
				return true;
		else
			return false;
}

/******************************************************************************************/

function reset(){
	parent.frames[2].frames[1].f_query_header.document.forms[0].reset();
	parent.frames[2].frames[1].f_query_header.document.getElementById("req_nature").innerText="";
	parent.frames[2].frames[1].f_query_hyperlink.location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].f_query_detail.location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].Dummy.location.href='../../eCommon/html/blank.html';
}

	/*********************************************************************************/
	function onSuccess()
   {
	    frames[1].frames[0].document.forms[0].reset();
		frames[1].f_query_header.document.getElementById("req_nature").innerText="";
		frames[1].f_query_hyperlink.location.href='../../eCommon/html/blank.html';
		frames[1].frames[2].location.href='../../eCommon/html/blank.html';
  }
  /****************************************************************************************/
  function selectAll(obj)
{
	 var frmobj=document.form_Terminologydetail;
	 var alphalink=frmobj.alphalink.value;
	 var frmobj1=parent.f_query_header.document.form_TerminologyCodeForCaseType;
	 var name=obj.name;
	  var obj1=eval("frmobj1."+alphalink+name);
	  	 flag=0;
	 if(obj.checked==true){
		 flag=1;
		 obj1.value="Y"
	 }else{
		 obj1.value="";

	 }
	 
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCP/jsp/TerminologyCodeForCaseTypeDynamicValues.jsp?alphalink="+frmobj.alphalink.value+"&term_set_id="+frmobj.term_set_id.value+"&case_type_code="+frmobj.case_type_code.value+"&type="+frmobj1.wellness_yn.value+"&flag="+flag+"&select=SELECTALL", false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
	checkAll(flag);

}

function checkselectAll(){
	 var frmobj=document.form_Terminologydetail;
	 var frmobj1=parent.f_query_header.document.form_TerminologyCodeForCaseType;
	
	 var alphalink=frmobj.alphalink.value;
	 obj=eval("frmobj.chkAll");
	 obj1=eval("frmobj1."+alphalink+"chkAll");
	//alert(alphalink+"->"+obj1.value);
	 if(obj1.value=='Y'){
		 obj.checked=true;
		checkAll(1);
	 }
}
/*************************************************************
function natureChange(index){
	var frmObj = document.form_Terminologydetail;
	var nature = eval("frmObj.nature"+index).value;

}
/***************************************************************************************
function updateValue(obj1,mand, nat )
	{
	var frmobj=document.form_Terminologydetail;
	var alphalink=frmobj.alphalink.value;
	var term_set_id=frmobj.term_set_id.value;
	var case_type_code=frmobj.case_type_code.value;
	var code=obj1.value;
	var mandatory=mand.value;
	var nature = nat.value;
	alert(nature+'->'+nat.selectedIndex)
	var flag=0;
	if(obj1.checked==true)
		flag=1;
	if(mand.checked==true)
		mandatory="Y";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCP/jsp/TerminologyCodeForCaseTypeDynamicValues.jsp?code="+code+"&mandatory="+mandatory+"&flag="+flag+"&alphalink="+alphalink+"&term_set_id="+term_set_id+"&case_type_code="+case_type_code+"&nature="+nature+"&select=Update", false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
}
/*****************************************************************************************/
function setchkAll(obj)
{
	var formobj	=document.form_Terminologydetail;
	 var frmobj1=parent.f_query_header.document.form_TerminologyCodeForCaseType;
	 var alphalink=formobj.alphalink.value;
	var obj1=eval("formobj.chkAll");
	var obj2=eval("frmobj1."+alphalink+"chkAll");
	 	if(obj.checked==false && obj2.value=="Y")
	{
		obj2.value="";
		obj1.checked=false;
	}
	
}
/****************************************************************************************/
function checkAll(flag)
{
	var frmobj=document.form_Terminologydetail;
	//var alphalink=frmobj.alphalink.value;
	var start				=		parseInt(frmobj.start.value)+1;
	var end					=		parseInt(frmobj.end.value)+1;
	var maxrecords		=		parseInt(frmobj.maxRecords.value)+1;
	if(end>maxrecords)
		end=maxrecords;
	for(var index=start-1;index<end-1;index++){
		obj=eval("frmobj.chk"+index);
		if(obj.disabled == false){
			if(flag==1)
				obj.checked=true;
			else
				obj.checked=false;
		}

	}

}
/*********************************************************************************************/
function submitPrevNext(from, to){
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
		/*var frmobj=document.form_Terminologydetail;
	    frmobj.from.value=from;
		frmobj.to.value=to;
	    var term_set_id=frmobj.term_set_id.value;
		var case_type_code=frmobj.case_type_code.value;
		var alphalink=frmobj.alphalink.value;
		var type=frmobj.type.value;*/
		//alert('from='+frmobj.from.value+'&to='+frmobj.to.value+'&term_set_id='+term_set_id+'&case_type_code='+case_type_code+'&alphalink='+alphalink+'&type='+type);
		document.forms[0].submit();
//parent.f_query_detail.location.href='../../eCP/jsp/TerminologyCodeForCaseTypeDetail.jsp?from='+frmobj.from.value+'&to='+frmobj.to.value+'&term_set_id='+term_set_id+'&case_type_code='+case_type_code+'&alphalink='+alphalink+'&type='+type;

	}
	/**************************************************************************************/
	function loadDetail(obj,case_type_code,term_set_id,wellness_yn,type,short_desc,search_criteria,alphalink)
	{
		prev_obj	=	eval(curr_obj);
		var curr_obj = document.getElementById(obj.id);

		new_obj		=	eval(curr_obj);
		old_obj		=	eval(prev_obj);

		new_obj.innerHTML	=	"<u><font color='maroon'>"+new_obj.innerText+"</font></u>";
		old_obj.innerHTML	=	"<td><u>"+old_obj.innerText+"</u></td>";
		//alert(parent.frames[2].document.forms[0].name);
		url=parent.f_query_detail.location.href;
		//alert(url+" -> "+url.indexOf('TerminologyCodeForCaseTypeDetai'));
		if(url.indexOf('TerminologyCodeForCaseTypeDetai')!=-1){
			parent.frames[2].document.forms[0].alphalink.value=alphalink;
			parent.frames[2].document.forms[0].from.value='0';
			parent.frames[2].document.forms[0].to.value='7';
			parent.frames[2].document.forms[0].submit();
		}
		else
			//parent.f_query_detail.location.href="../../eCP/Jsp/TerminologyCodeForCaseTypeDetail.jsp?case_type_code="+case_type_code+"&term_set_id="+term_set_id+"&wellness_yn="+wellness_yn+"&type="+type+"&short_desc="+short_desc+"&search_criteria="+search_criteria+"&fromSearch=true&alphalink="+alphalink;//DEMO SERVER ISSUE
			parent.f_query_detail.location.href="../../eCP/jsp/TerminologyCodeForCaseTypeDetail.jsp?case_type_code="+case_type_code+"&term_set_id="+term_set_id+"&wellness_yn="+wellness_yn+"&type="+type+"&short_desc="+short_desc+"&search_criteria="+search_criteria+"&fromSearch=true&alphalink="+alphalink; //DEMO SERVER ISSUE
	
	}
	/************************************************************************************/
	function clearDetail(){
		parent.f_query_hyperlink.location.href='../../eCommon/html/blank.html';
		parent.f_query_detail.location.href='../../eCommon/html/blank.html';
	}
	/*****************************************************/
	function checkValue(target){
		if(target.checked == true)
			target.value='Y';
		else
			target.value='N';
	}
