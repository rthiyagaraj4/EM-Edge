var result = false;
var message = "" ;
var flag = "" ;

/****************************************************************************/
function create() {
	
	//parent.frames[1].f_query_add_mod.location.href = "../../eRS/jsp/AccessRightsFrameSet.jsp";  ----comented on 24/11/08----
	parent.frames[2].f_query_add_mod.location.href = "../../eRS/jsp/AccessRightsFrameSet.jsp";

} 

/*****************************************************************************/
function query() {
	f_query_add_mod.location.href="../../eRS/jsp/AccessRightsQueryCriteria.jsp";
}

/*****************************************************************************/
function reset(){
	var url=f_query_add_mod.location.href;

	if(url.indexOf("blank")==-1) {
		if((url.indexOf("Query")==-1)){
				parent.frames[2].frames[1].frameAccessHdr.document.forms[0].reset();
				parent.frames[2].frames[1].frameAccessHdr.document.forms[0].elements(0).focus();
				parent.frames[2].frames[1].frameAccessDtl.location.href='../../eCommon/html/blank.html';
				parent.frames[2].frames[1].Dummy.location.href='../../eCommon/html/blank.html';
		}else
			parent.frames[2].frames[1].document.forms[0].reset();
	}
}

/*****************************************************************************/
function showDetails()
{

    var messageFrame=parent.parent.frames[2];
	var formObj=document.AccessRightsHeader_Form;
	var workplace=formObj.workplace1.value;
	var workplace_code=formObj.workplace_code1.value;
	var user_id=formObj.user_code.value;
		
		
	
       var formObj=parent.parent.frames[1].frames[0].document.AccessRightsHeader_Form;
	   var user_name=formObj.user_name;
	   var fields = new Array (user_name);
	   var names = new Array (getLabel("Common.username.label","Common"));	  
	   parent.Dummy.location.href="../../eRS/jsp/AccessRightsDynamicValues.jsp";
	if(parent.parent.f_query_add_mod.checkFieldsofMst(fields,names,messageFrame))
	{
	 if((workplace !='') && (workplace_code!=''))
	{
		 
	
	parent.frames[1].location.href = "../../eRS/jsp/AccessRightsDtl.jsp?user_id="+user_id+"&workplace="+workplace+"&workplace_code="+workplace_code+"&fromSearch=true";
	}
	else if((workplace =='') && (workplace_code==''))
	{	
        parent.frames[1].location.href = "../../eRS/jsp/AccessRightsDtl.jsp?user_id="+user_id+"&fromSearch=true";
		
	}

	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';
	}
	
}

/***************************************************************************/
//*************used for displaying the user common look up****************//
/**************************************************************************/
function apply(){
	
	//var messageFrame = parent.frames[1].frames[2]; 
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	if (! checkIsValidForProceed()) {
		
		message  = "";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
		return false ;
	}

	if (! checkIsValidForProceed1()) {
		
		message  = "";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
		return false ;
	}

	if (! checkIsValidForProceed2()) {
		
		//message  = getMessage("NOT_VALID","Common");
		//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		var frmobj=f_query_add_mod.frameAccessHdr.document.AccessRightsHeader_Form;

		var fields = new Array (frmobj.user_name);
		var names = new Array (getLabel("Common.user.label","Common"));
		if(f_query_add_mod.frameAccessHdr.checkFieldsofMst( fields, names, messageFrame))
		parent.frames[1].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		
		
		return false ;
	}


        //var formObj=parent.frames[1].frames[1].frames[0].document.forms[0];// Commented on 24/11/08
        var formObj=parent.frames[2].frames[1].frames[0].document.forms[0];
       	var workplace=formObj.workplace1.value;
	var workplace_code=formObj.workplace_code1.value;

	if(workplace_code!='' && workplace!='')
	{
        var formDtl=parent.frames[2].frames[1].frames[1].document.forms[0];

	if(formDtl.Setup.checked==true)
	{
	  formDtl.setup.value="Y";
        }
	else
	{
	  formDtl.setup.value="N";
	}
	
	if(formDtl.Allocate.checked==true)
	{
	  formDtl.allocate.value="Y";
        }
	else
	{
	  formDtl.allocate.value="N";
	}

	if(formDtl.Reallocate.checked==true)
	{
	  formDtl.reallocate.value="Y";
        }
	else
	{
	  formDtl.reallocate.value="N";
	}

	if(formDtl.Cancel.checked==true)
	{
	  formDtl.cancel.value="Y";
        }
	else
	{
	  formDtl.cancel.value="N";
	}

	if(formDtl.select.checked==true)
	{
	  formDtl.select1.value="Y";
        }
	else
	{
	  formDtl.select1.value="N";
	}
	parent.frames[2].frames[1].frames[1].document.forms[0].action="../../servlet/eRS.AccessRightsServlet";
	parent.frames[2].frames[1].frames[1].document.forms[0].target="messageFrame";
	parent.frames[2].frames[1].frames[1].document.forms[0].submit();
       }
	else if(workplace_code=='' && workplace=='')
	{
	var Obj=parent.frames[2].frames[1].frames[1].document.forms[0];
	var from=Obj.from.value;
	var to=Obj.to.value;
	var workplace="";
	var select="";
	var setup="";
	var allocate="";
	var reallocate="";
	var cancel="";
	var dbaction="";
        for(var a=parseInt(from);a<parseInt(to);a++)
	{
	  if(eval("Obj.workplace_code"+a))
	  {
	  workplace=eval("Obj.workplace_code"+a);
	  select=eval("Obj.select"+a);
	  setup=eval("Obj.Setup"+a);
	  allocate=eval("Obj.Allocate"+a);
	  reallocate=eval("Obj.Reallocate"+a);
	  cancel=eval("Obj.Cancel"+a);
	  dbaction=eval("Obj.db_action"+a);
	  if(setup.checked==true)
	     setup.value="Y";
	  else
	     setup.value="N";
	  if(allocate.checked==true)
	      allocate.value="Y";
	  else
	      allocate.value="N";
	  if(reallocate.checked==true)
	     reallocate.value="Y";
	  else
	     reallocate.value="N";
	  if(cancel.checked==true)
	     cancel.value="Y";
	  else
	     cancel.value="N";
          if(select.checked==true)
	     select.value="Y";
	  else
	     select.value="N";
	     }
	     }
        Obj.allValues.value=parent.frames[2].frames[1].frames[2].document.forms[0].E.value;
	Obj.action="../../servlet/eRS.AccessRightsServlet";
	Obj.target="messageFrame";
	Obj.submit();
	}
}
/*****************************************************************************/
function onSuccess(){
	frames[1].frames[0].document.forms[0].reset();
	frames[1].frames[0].document.forms[0].elements(0).focus();
	frames[1].frames[1].location.href='../../eCommon/html/blank.html';
}
/****************************************************************************/
function checkIsValidForProceed()
{		
		var url = f_query_add_mod.location.href;
                url = url.toLowerCase();
		if ((url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
			return true;
		else
			return false;
}
/*************************************************************************/
function checkIsValidForProceed1()
{	
		var url = f_query_add_mod.frameAccessHdr.location.href;
                url = url.toLowerCase();
		if ((url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}
//*************************************************************************************8
function checkIsValidForProceed2()
{			
		var url = f_query_add_mod.frameAccessDtl.location.href;
                url = url.toLowerCase();
		if ((url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}
//*************************************************************************
function displayUser(obj,target_desc,target_code)
{
	var retVal = 	new String();
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var dialogLeft="500";
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var dispDescFirst="dispDescFirst";
	var tit="User Name";
	var practtype="";
	
	var facility_id=document.AccessRightsHeader_Form.facility_id.value;
	var locale=document.AccessRightsHeader_Form.locale.value;
  

	parent.frames[1].location.href='../../eCommon/html/blank.html';

	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
	sql  = "select a.appl_user_id , b.appl_user_name from sm_facility_for_user a, sm_appl_user_lang_vw b where a.facility_id =`"+facility_id+"` and b.language_id =`"+locale+"` and b.appl_user_id = a.appl_user_id and b.eff_status = `E` and sysdate between nvl(a.access_eff_date_from, sysdate) and nvl(a.access_eff_date_to, sysdate)";
	  

	search_code = "a.appl_user_id";
	search_desc="b.appl_user_name";

	
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status+";dialogLeft:"+dialogLeft+";";
	retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst="+dispDescFirst,arguments,features);
	
		var arr=new Array();
		if (!(retVal == null))
		{
			var ret1=unescape(retVal);
			arr=ret1.split("::");
			target_desc.value=arr[0];
			target_code.value=arr[1];
			document.AccessRightsHeader_Form.user_code.value=arr[1];
         	}
		else
		{
			target_desc.value="";
			target_code.value="";
	        }
}
//*******************************************************************************
function displayWorkPlace(obj,target_desc,target_code)
{   
	
	var retVal = 	new String();
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var dialogLeft="500";
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var dispDescFirst="dispDescFirst";
	var tit="WorkPlace Name";
	var practtype="";
	

	var facility_id=document.AccessRightsHeader_Form.facility_id.value;
	var user_id=document.AccessRightsHeader_Form.user_code.value;
	var locale=document.AccessRightsHeader_Form.locale.value;
	parent.frames[1].location.href='../../eCommon/html/blank.html';
	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';

	//sql  = "select distinct workplace_code,workplace_desc from rs_workplace a,sm_facility_for_user b where a.facility_id =`"+facility_id+"` and a.facility_id=b.facility_id";
	sql  = "select distinct workplace_code,workplace_desc from rs_workplace_lang_vw a,sm_facility_for_user b where a.facility_id =`"+facility_id+"` and a.facility_id=b.facility_id and a.language_id =`"+locale+"`"; 
	search_code="workplace_code";
	search_desc="workplace_desc";

	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status+";dialogLeft:"+dialogLeft+";";
	retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst="+dispDescFirst,arguments,features);
	var arr=new Array();
       
		if (!(retVal == null))
		{
			var ret1=unescape(retVal);
			arr=ret1.split("::");
			target_desc.value=arr[0];
			target_code.value=arr[1];
			document.AccessRightsHeader_Form.workplace_code1.value=arr[1];
		}
		else
		{
                        target_desc.value="";
			target_code.value="";
		}
}
//******************************************************************
function submitPrevNext(from,to)
{
document.AccessRightsDetail_form.from.value=from;
document.AccessRightsDetail_form.to.value=to;
document.AccessRightsDetail_form.submit();
}
//***********************************************************************************
function selectAll(Obj,start,end){
	
	if(Obj.checked){
	        for(var i=start;i<=end;i++)
		{
		 if(eval("document.forms[0].select"+i))
		 eval("document.forms[0].select"+i).checked=true;
		}
		var facility_id=parent.frames[0].document.forms[0].facility_id.value
		var user_id=parent.frames[0].document.forms[0].user_code.value;

		var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='AccessRightsDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='notCleared'><input type='hidden' name='facility_id' id='facility_id' value='"+facility_id+"'><input type='hidden' name='user_id' id='user_id' value='"+user_id+"'></form></BODY></HTML>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.form1.submit();
	}
	else{
		for(var i=start;i<=end;i++){
			if(eval("document.forms[0].select"+i))
			eval("document.forms[0].select"+i).checked=false;
			}
		var HTMLVal = "<HTML><BODY><form name='form1' id='form1' method='post' action='AccessRightsDynamicValues.jsp'><input type='hidden' name='clearAll' id='clearAll' value='clearAll'></form></BODY></HTML>";
		parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.form1.submit();
	}
}
//*****************************************************************************
function chkForSelectAll(start,end){
	
	if(parent.Dummy.document.forms[0].E.value == 'notCleared'){
			
        	document.forms[0].selectall.checked=true;
		selectAll(document.forms[0].selectall,start,end)
	}
}

//*******************************************************************************
function onuncheck(obj){
	var frmObj=document.forms[0];
	if(obj.checked == false)
		frmObj.selectall.checked=false;
}
//*********************************************************************************

