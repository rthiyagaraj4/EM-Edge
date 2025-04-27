
// Function Reset
function reset()
{
	if(window.frames[1].document.forms[0])
	{
		
	window.frames[1].document.forms[0].reset();
	
	}
}
function query()
{
	
	window.frames[1].location.href='../../eXH/jsp/ViewQryMsgHeader.jsp?';
	window.messageFrame.location.href='../../eCommon/html/blank.html'
}
//************************************************************************************************
function validDateCheck()
{
 
	var d1Array=new Array();
	var date1=this.document.forms[0].qmsg_dt1.value;
	var d2Array=new Array();   
	var date2=this.document.forms[0].qmsg_dt2.value;
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
			alert(getMessage('XH1009',"XH"));
			return false;
		} 
		else return true;
	}
	else return true;
   
}
//****************************************************************************************************
function sysDateCheck(from,to) {

    var fromarray;
    var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
	
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
            var todt = new Date(toarray[2],toarray[1],toarray[0]);

            if(Date.parse(todt) > Date.parse(fromdt)) 
            {
                var invaldt = getMessage("START_DATE_GREATER_SYSDATE","common") ;
                alert(invaldt);
                to.select();
                to.focus();
                    
            }
            else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
    }
    return true;
}
function validate_date(Obj,ref) {
  
//	var formObj = document.frames.f_query_add_mod.f_query_criteria.queryPatientDrugProfileCriteria;
var formObj = document.forms[0];
	if (CheckDate(Obj)) 
	{ 
	 if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = formObj.qmsg_dt2;
	  to = formObj.qmsg_dt1;
	//  error_id = getMessage("TO_DT_GR_EQ_FM_DT");  
	 	   error_id = getMessage("XH1009","XH");   
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = formObj.qmsg_dt1;
	  to = formObj.qmsg_dt2;
	  //error_id = getMessage("TO_DT_GR_EQ_FM_DT"); 
	 	error_id = getMessage("XH1009","XH");
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
//	  from = parent.frames[1].formObj.dt_to;
//	  to = parent.frames[1].formObj.dt_from;
 from = formObj.qmsg_dt2;
 to = formObj.qmsg_dt1;
	 // error_id = getMessage("TO_DT_GR_EQ_FM_DT");
	  	error_id = getMessage("XH1009","XH");
	}
	
	var fromarray;
	var toarray;
	var fromdate = eval(from).value ;
	var todate = eval(to).value ;
	
	if(fromdate.length > 0 && todate.length > 0 ) {
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
	
		if(Date.parse(todt) > Date.parse(fromdt)) {		   
			alert(error_id);
			from.value="";
 		    from.focus();
		}
		else if(Date.parse(todt) <= Date.parse(fromdt))
		     {
	       //parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
		       return true;
		      } 
	}
	return true;
}
}







async function goSearch()
{


	var flag=true;
	flag=checkcurrdate(document.forms[0].qmsg_dt1);
	if(flag)
	{
		flag=checkcurrdate(document.forms[0].qmsg_dt2);
	}
	else
	{
		document.forms[0].qmsg_dt1.focus();
		return;
	}	
	if(flag==true)
	{

parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp';
var dispMode = document.forms[0].dispMode.value;
        if(dispMode == "display")
		{
			var fields = new Array (  document.forms[0].qostatus,document.forms[0].sub_module);
            var names = new Array (getLabel("eXH.QueryOption.Label","XH"),getLabel("eXH.InterfaceDomain.Label","XH")); 

				if(!checkFieldsofMst( fields, names, parent.messageFrame,'1'))
			{


			}
			else
			{
			   if(validDateCheck()&&(Checkcurrdate(this.document.forms[0].qmsg_dt1))&&(Checkcurrdate(this.document.forms[0].qmsg_dt2)))
				{

					this.document.forms[0].action='../../eXH/jsp/ViewQryMsgDtl.jsp';
					this.document.forms[0].target='f_query_header'; 
					this.document.forms[0].action_type.value='S';
					 document.forms[0].submit();
					
				} 
				
			}
 
				parent.commontoolbarFrame.document.location.reload();	
		}
		else if(dispMode=='Review')
		{
			
			var dialogHeight = "45vh";
			var dialogWidth  = "55vw";
			var dialogTop    = "230";
			var dialogLeft   = "230";
			var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
			var arguments  ="";
			var url="../../eXH/jsp/ViewQueryReviewPage.jsp?qapplname="+this.document.forms[0].qapplname.value+"&qfacility="+this.document.forms[0].qfacility.value+"&qry_id2="+this.document.forms[0].qry_id2.value+"&qry_id1="+this.document.forms[0].qry_id1.value+"&eventtype="+this.document.forms[0].eventtype.value+"&protocol_link_id="+this.document.forms[0].protocol_link_id.value+"&qmsg_dt1="+this.document.forms[0].qmsg_dt1.value+"&qmsg_dt2="+this.document.forms[0].qmsg_dt2.value+"&purge_status="+this.document.forms[0].purge_status.value+"&posi=1&qstatus="+this.document.forms[0].qstatus.value; 
					  await window.showModalDialog(url,arguments,features); 

  

		}
		else
		{
			
			document.forms[0].action='../../servlet/eXH.GenerateQueryEventsToXLServlet';
				 document.forms[0].submit();
	
		}

	//	parent.f_query_detail.location.href="../../eCommon/html/blank.html";
	//	parent.frames[2].location.href="../../eCommon/html/blank.html";

	}
}








//***************************************************************************************************
//**************************************************************************************
function populateAction(obj)
{
	this.document.forms[0].action='../../eXH/jsp/ViewQryMsgHeader.jsp';
	this.document.forms[0].target='f_query_header';
	this.document.forms[0].submit();
} 

//**********************************************************************************************
function Checkcurrdate(from) {
	var fromarray; var toarray;
	var fromdate = from.value ;
	var d =  new Date(); 
	if(fromdate.length > 0 ) {
			fromarray = fromdate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(d.getYear(),d.getMonth() + 1,d.getDate());	
			if(Date.parse(todt) < Date.parse(fromdt)) {
				alert(getMessage('XH1010',"XH"));
				from.focus();
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
return true;
}
//***************************************************************************************************/
async function Responce()
{

var dialogHeight = "45vh";
var dialogWidth  = "55vw";
var dialogTop    = "230";
var dialogLeft   = "230";
var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
var arguments  ="";
await window.showModalDialog("../../eXH/jsp/ViewQryMeesageMenu.jsp?application_id="+document.forms[0].application_id.value+"&Facility_id="+document.forms[0].Facility_id.value+"&eventype="+document.forms[0].eventype.value+"&protocollinkid="+document.forms[0].protocollinkid.value,arguments,features);  
} 
