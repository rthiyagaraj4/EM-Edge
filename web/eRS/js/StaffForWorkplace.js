var function_id = "";
var message="";

function create(){
	f_query_add_mod.location.href='../../eRS/jsp/StaffForWorkplaceFrameset.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
}

function showWorkplace(){
	//alert(parent.parent.frames[1].frames[2].name);
	parent.frameSelect.location.href='../../eRS/jsp/StaffForWorkplaceByWorkplace.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
	parent.frameList.location.href='../../eCommon/html/blank.html';
}

function showShift(){
	parent.frameSelect.location.href='../../eRS/jsp/StaffForWorkplaceByStaff.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
	parent.frameList.location.href='../../eCommon/html/blank.html';
}

function showWorkplaceList(){
	parent.f_query_add_mod_list.location.href='../../eRS/jsp/StaffForWorkplaceShowWorkplace.jsp?mode='+MODE_INSERT+'&function_id='+function_id ;
	parent.frameList.location.href='../../eCommon/html/blank.html';
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	//parent.f_query_add_mod_list.location.href='../../eRS/jsp/StaffForWorkplaceShowWorkplace.jsp';
}

function query() {
	f_query_add_mod.location.href = "../../eRS/jsp/StaffForWorkplaceQueryCriteria.jsp?mode=1&function_id="+function_id;
	//f_query_add_mod_list.location.href ="../../eCommon/html/blank.html";
}

function apply(){
	if (!checkIsValidForProceed()){
		
		message="";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed1()){
		message  = ""
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	if (!checkIsValidForProceed2()){
		
		var frmobj=f_query_add_mod.frameSelect.document.forms[0];
		if(frmobj==null)    //adding condition on 19/11/08-------
		{
			parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false;
		}
		if(frmobj==f_query_add_mod.frameSelect.document.workplace_frm)
		{	
			var fields = new Array (frmobj.workplace_desc);
			var names = new Array (getLabel("eRS.WorkPlace.label","RS"));
			if(f_query_add_mod.frameSelect.checkFieldsofMst( fields, names, messageFrame))
			parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		}

		else if(frmobj==f_query_add_mod.frameSelect.document.staff_frm)
		{
		
			var fields = new Array (frmobj.staff_id);
			var names = new Array (getLabel("eRS.StaffName.label","RS"));
			if(f_query_add_mod.frameSelect.checkFieldsofMst( fields, names, messageFrame))
			parent.frames[2].messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
		return false ;
	}

		var frmObj=f_query_add_mod.frames[2].document.forms[0];
		var frmName=frmObj.name;
		var cnt;
		var flag='';

	outer : for(cnt=0;cnt<frmObj.record_Count.value; cnt++){
	
		if(eval("frmObj.text1"+cnt)!=null){
			eval("frmObj.eff_fro"+cnt).value=(eval("frmObj.text1"+cnt).value);
		}
		if(eval("frmObj.text2"+cnt)!=null)
			eval("frmObj.eff_to"+cnt).value=(eval("frmObj.text2"+cnt).value);
		
		if(eval("frmObj.select"+cnt)!=null)
			var select=eval("frmObj.select"+cnt);
			if(select.checked==true){
				eval("frmObj.chkd"+cnt).value='Y';
				eval("frmObj.eff_status"+cnt).value='E';
			}else{
				eval("frmObj.chkd"+cnt).value='N';
				eval("frmObj.eff_status"+cnt).value='D';
			}

			if(select.checked==true){
				if(eval("frmObj.eff_fro"+cnt).value==''){
				 var errors = getMessage("FROM_DATE_CANNOT_BE_BLANK","RS");
				 flag ='N';
				 messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
				return false ;
			}
		}
	}
	if(flag==''){
		frmObj.submit();
	}
}

  

  
function onSuccess(){
	f_query_add_mod.frames[2].location.href='../../eCommon/html/blank.html';
	//parent.frames[2].document.forms[0].reset();
}

function reset(){	
	//f_query_add_mod.frames[1].document.forms[0].reset();
	//f_query_add_mod.frames[2].location.href='../../eCommon/html/blank.html';
	var url=f_query_add_mod.location.href;
	if(url.indexOf("blank")==-1) {
		if(url.indexOf("Query")==-1){
			url=frames[1].frameSelect.location.href;
			if(url.indexOf("blank")==-1) {
				var frmObj=frames[1].frameSelect.document.forms[0]
				url=frames[1].frameList .location.href;
				if(url.indexOf("blank")==-1) {
					frames[1].frameList.document.forms[0].reset();
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
				}
				else{
					frmObj.reset();
					var i=0;
					while(frmObj.elements(i)!=null){
						frmObj.elements(i).disabled=false;
						i++;
					}
					frmObj.elements(0).focus()
				}
			}
			else
				f_query_add_mod.location.href='../../eCommon/html/blank.html';
			}
		else
			f_query_add_mod.document.forms[0].reset();
	}	
}
/***************************************************/
function checkIsValidForProceed()
{	
	var url = f_query_add_mod.location.href;
		
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
			return false;
}
/**************************************************/
function checkIsValidForProceed1()
{		
		
		var url = f_query_add_mod.frameSearch.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else

			return false;
}
/**************************************************/
function checkIsValidForProceed2()
{		
	
	var url = f_query_add_mod.frameList.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		{
				return true;
		}
		else
		{
		
			return false;
		}
}
/**************************************************/

function showCalendarValidate(str)
{
	var flg = showCalendar(str);
	eval("document.all."+str+".focus();");
	return flg;
}
