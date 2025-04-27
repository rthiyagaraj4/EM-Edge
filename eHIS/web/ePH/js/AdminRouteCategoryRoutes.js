//This file is saved on 18/10/2005.


var curr_obj =document.getElementById("associated_lbl");
var prev_obj= "";

async function selectNature(target)
{
	var frmobj=parent.f_query_header.document.form_AdminRouteCategoryRoutes ;
	//frmobj.short_desc.value='';
	frmobj.admin_route_categ_code.value="";
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
 	
 	//argumentArray[0] ="Select case_type_code code, short_desc description from cp_case_type_lang_vw where eff_status = 'E' and language_id like ? AND UPPER(case_type_code) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?)  order by short_desc";

 	argumentArray[0] ="select ADMIN_ROUTE_CATG_CODE code, ADMIN_ROUTE_CATG_DESC description from PH_ADMIN_ROUTE_CATG_LANG_VW A where eff_status = 'E' and LANGUAGE_ID like ? AND UPPER(A.ADMIN_ROUTE_CATG_CODE) LIKE UPPER(?) AND UPPER(A.ADMIN_ROUTE_CATG_DESC) LIKE UPPER(?) order by 2";

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
		retVal = await CommonLookup(getLabel("ePH.AdminRouteCategory.label",'PH'), argumentArray );
		if(retVal != null && retVal != "") {
			var ret1 =unescape(retVal);
			var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			target.value = arr[1] ;			
			document.forms[0].admin_route_categ_code.value = arr[0];
		}else{
			target.value ="";			
		}		
		frmobj.route_code_desc.value='';
		frmobj.search_criteria.selectedIndex=0;		
		clearDetail();
}
function searchDetails()
  {
	  var frmobj=parent.frames[0].document.forms[0] ;
	  var fields = new Array (frmobj.admin_route_categ_code);
	  var names = new Array (getLabel("ePH.AdminRouteCategory.label",'PH'));
	  var msgFrame=parent.parent.messageFrame;
	  var flag = true ;
	 
	  if(parent.f_query_header.checkFieldsofMst( fields, names, msgFrame))
		{		   				
		 //parent.frames[1].location.href='../../eCP/jsp/TerminologyCodeForCaseTypeHyperLinks.jsp?term_set_id='+frmobj.term_set_id.value+'&type='+frmobj.wellness_yn.value+'&case_type_code='+frmobj.case_type_code.value+'&short_desc='+frmobj.term_code_desc.value+'&search_criteria='+frmobj.search_criteria.value+'&flag='+flag;
		 parent.frames[1].location.href='../../ePH/jsp/AdminRouteCategoryRoutesHyperLinks.jsp?admin_route_categ_code='+frmobj.admin_route_categ_code.value+'&short_desc='+frmobj.route_code_desc.value+'&search_criteria='+frmobj.search_criteria.value+'&flag='+flag;
		 //parent.frames[2].location.href='../../eCP/jsp/TerminologyCodeForCaseTypeDetail.jsp?term_set_id='+frmobj.term_set_id.value+'&type='+frmobj.wellness_yn.value+'&case_type_code='+frmobj.case_type_code.value+'&short_desc='+frmobj.term_code_desc.value+'&search_criteria='+frmobj.search_criteria.value+'&alphalink=Associated';
		 parent.frames[2].location.href='../../ePH/jsp/AdminRouteCategoryRoutesDetail.jsp?admin_route_categ_code='+frmobj.admin_route_categ_code.value+'&short_desc='+frmobj.route_code_desc.value+'&search_criteria='+frmobj.search_criteria.value+'&alphalink=Associated';

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
	if (!checkIsValidForProceed()){
		var frmobj=f_query_add_mod.f_query_header.document.form_AdminRouteCategoryRoutes;
		var fields = new Array (frmobj.admin_route_categ_code);
		var names = new Array (getLabel("ePH.AdminRouteCategory.label",'PH'));		
			if(f_query_add_mod.f_query_header.checkFieldsofMst(fields, names, messageFrame))
			{				
				parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			}
			else
			{
				return false;
			}
	}
	else
	{
		message  = " ";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false;
	}
	//parent.frames[2].frames[1].frames[2].document.forms[0].action="../../servlet/eCP.TerminologyCodeForCaseTypeServlet";
	parent.frames[2].frames[1].frames[2].document.forms[0].action="../../servlet/ePH.AdminRouteCategoryRoutesServlet";
	parent.frames[2].frames[1].frames[2].document.forms[0].target="messageFrame";
	parent.frames[2].frames[1].frames[2].document.forms[0].submit();
}
/*********************************************************************************/

function checkIsValidForProceed()
{	var url = f_query_add_mod.f_query_detail.location.href;
		url = url.toLowerCase();
		//alert(url);
		if ((url.indexOf("adminroutecategoryroutesdetail.jsp")==-1))
			return true;
		else
			return false;
}

/******************************************************************************************/

function reset(){
	parent.frames[2].frames[1].f_query_header.document.forms[0].reset();
	//parent.frames[2].frames[1].f_query_header.document.getElementById("req_nature").innerText="";
	parent.frames[2].frames[1].f_query_hyperlink.location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].f_query_detail.location.href='../../eCommon/html/blank.html';
	parent.frames[2].frames[1].Dummy.location.href='../../eCommon/html/blank.html';
}

	/*********************************************************************************/
	function onSuccess()
   {
	    frames[1].frames[0].document.forms[0].reset();
		//frames[1].f_query_header.document.getElementById("req_nature").innerText="";
		frames[1].f_query_hyperlink.location.href='../../eCommon/html/blank.html';
		frames[1].frames[2].location.href='../../eCommon/html/blank.html';
  }
  /****************************************************************************************/
  function selectAll(obj)
{
	 var frmobj=document.form_AdminRoutedetail;
	 var alphalink=frmobj.alphalink.value;
	 var frmobj1=parent.f_query_header.document.form_AdminRouteCategoryRoutes;
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
	xmlHttp.open( "POST","../../ePH/jsp/AdminRouteCategoryRoutesDynamicValues.jsp?alphalink="+frmobj.alphalink.value+"&admin_route_categ_code="+frmobj.admin_route_categ_code.value+"&flag="+flag+"&search_criteria="+frmobj1.search_criteria.value+"&short_desc="+frmobj1.route_code_desc.value+"&select=SELECTALL", false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
	checkAll(flag);

}

function checkselectAll(){
	 var frmobj=document.form_AdminRoutedetail;
	 var frmobj1=parent.f_query_header.document.form_AdminRouteCategoryRoutes;
	
	 var alphalink=frmobj.alphalink.value;
	 obj=eval("frmobj.chkAll");
	 obj1=eval("frmobj1."+alphalink+"chkAll");
	//alert(alphalink+"->"+obj1.value);
	 if(obj1.value=='Y'){
		 obj.checked=true;
		checkAll(1);
	 }
}
function setchkAll(obj)
{
	var formobj	=document.form_AdminRoutedetail;
	 var frmobj1=parent.f_query_header.document.form_AdminRouteCategoryRoutes;
	 var alphalink=formobj.alphalink.value;
	var obj1=eval("formobj.chkAll");
	var obj2=eval("frmobj1."+alphalink+"chkAll");
	if(obj.checked==true)
		flag="1";
	else 
		flag="0";

	if(obj.checked==false && obj2.value=="Y")
	{
		obj2.value="";
		obj1.checked=false;
	}
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../ePH/jsp/AdminRouteCategoryRoutesDynamicValues.jsp?code="+obj.value+"&flag="+flag+"&select=SELECTONE", false);
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText);
	
}
/****************************************************************************************/
function checkAll(flag)
{
	var frmobj=document.form_AdminRoutedetail;
	//var alphalink=frmobj.alphalink.value;
	var start				=		parseInt(frmobj.start.value)+1;
	var end					=		parseInt(frmobj.end.value)+1;
	var maxrecords		=		parseInt(frmobj.maxRecords.value)+1;
	if(end>maxrecords)
		end=maxrecords;
	for(var index=start-1;index<end-1;index++){
		obj=eval("frmobj.chk"+index);
		//if(obj.disabled == false){
			if(flag==1)
				obj.checked=true;
			else
				obj.checked=false;
		//}

	}

}
/*********************************************************************************************/
function submitPrevNext(from, to, srch_criteria,short_des){
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].search_criteria.value = srch_criteria; 
	document.forms[0].short_desc.value = short_des; 
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
	function loadDetail(obj,admin_route_categ_code,short_desc,search_criteria,alphalink)
	{
		//alert(short_desc+","+search_criteria);
		prev_obj	=	eval(curr_obj);
		curr_obj	=	document.getElementById(obj.id);

		new_obj		=	eval(curr_obj);
		old_obj		=	eval(prev_obj);

		new_obj.innerHTML	=	"<u><font color='maroon'>"+new_obj.innerText+"</font></u>";
		old_obj.innerHTML	=	"<td><u>"+old_obj.innerText+"</u></td>";
		//alert(parent.frames[2].document.forms[0].name);
		url=parent.f_query_detail.location.href;
		//alert(url+" -> "+url.indexOf('TerminologyCodeForCaseTypeDetai'));
		if(url.indexOf('AdminRouteCategoryRoutesDetai')!=-1){
			//alert("he");
			parent.frames[2].document.forms[0].alphalink.value=alphalink;
			parent.frames[2].document.forms[0].search_criteria.value=search_criteria;
			parent.frames[2].document.forms[0].short_desc.value=short_desc;
			parent.frames[2].document.forms[0].from.value='0';
			parent.frames[2].document.forms[0].to.value='7';
			parent.frames[2].document.forms[0].submit();
		}
		else
		{
			//alert("he2");
			parent.f_query_detail.location.href="../../ePH/jsp/AdminRouteCategoryRoutesDetail.jsp?admin_route_categ_code="+admin_route_categ_code+"&short_desc="+short_desc+"&search_criteria="+search_criteria+"&fromSearch=true&alphalink="+alphalink;
		}
	
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
