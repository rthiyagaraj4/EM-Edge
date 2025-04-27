// Function Reset
//**************************************************************************************/
function reset()
{
	if(window.f_query_header.document.forms[0])
	{
	window.f_query_header.document.forms[0].reset();
	window.f_query_detail.location.href="../../eCommon/html/blank.html";
	window.f_query_add_mod.location.href="../../eCommon/html/blank.html";
	}
}
//***********************************************************************************
function validDateCheck()
{

	var d1Array=new Array();
	var date1=this.document.forms[0].amsg_dt1.value;
	var d2Array=new Array();
	var date2=this.document.forms[0].amsg_dt2.value;
	var d1object;
	var d2object;
	if((date1!="")&&(date2!=""))
	{
		d1Array=date1.split('/');
		d1object=new Date(d1Array[2],d1Array[1],d1Array[0]);
		d2Array=date2.split('/');
		d2object=new Date(d2Array[2],d2Array[1],d2Array[0]);
		if(d1object > d2object)
		{
			alert(getMessage('XH1009','XH'));
			return false;
		}
		
		else return true;  
	}
	else return true;
   
}
//*********************************************************************************************
function goSearch()
{
    parent.f_query_detail.location.href="../../eCommon/html/blank.html";
	if(validDateCheck()&&(Checkcurrdate(this.document.forms[0].amsg_dt1))&&(Checkcurrdate(this.document.forms[0].amsg_dt2)))
	{
	    this.document.forms[0].action='../../eXH/jsp/ViewMsgInteractiveAuditLogDtl.jsp';
		this.document.forms[0].target='f_query_add_mod';
		this.document.forms[0].action_type.value='S';
		this.document.forms[0].submit();
	}
}
//**************************************************************************************
function populateAction(obj)
{
	
	this.document.forms[0].action='../../eXH/jsp/ViewMsgAuditLogHeader.jsp';
	this.document.forms[0].target='f_query_header';
	this.document.forms[0].submit();
}
//**************************************************************************************
//***************************************************************************************************/
function Checkcurrdate(from) {
	var fromarray; var toarray;
	var fromdate = from.value ;
	var d =  new Date(); 
	if(fromdate.length > 0 ) {
			fromarray = fromdate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(d.getYear(),d.getMonth() + 1,d.getDate());	
			if(Date.parse(todt) < Date.parse(fromdt)) {
				alert(getMessage('XH1010','XH'));
				from.focus();
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
return true;
}

/***************************************************************************************************/
