/*function show_window(){
			var s_scheme=top.content.workAreaFrame.procedurelistquery.document.forms[0].s_scheme.value;
			var s_scheme_desc=top.content.workAreaFrame.procedurelistquery.document.forms[0].s_scheme_desc.value;
			var retVal = 	""; //new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll:no; status:" + status;
			retVal = window.showModalDialog("../../eCA/jsp/ProcSearchMain.jsp?s_scheme="+s_scheme+"&s_scheme_desc="+s_scheme_desc,arguments,features);

			if (!(retVal == null))
			{
				var vals=retVal.split("/")	;
				top.content.workAreaFrame.procedurelistquery.document.Procedure_List.proc_code.value=vals[0];
			}else{
				top.content.workAreaFrame.procedurelistquery.document.Procedure_List.proc_code.value="";
				top.content.workAreaFrame.procedurelistquery.document.Procedure_List.proc_code.focus();
			}
	}*/

function getTermCode(obj)
{

	if(!obj.value=="")
	{
		callTermCode(obj);
	}
	else
	{
		document.Procedure_List.proc_desc.value="";
		document.Procedure_List.proc_code.value="";
	}
}


async function callTermCode(obj)
{
		var temp_term_code = "";
		var term_desc = document.Procedure_List.proc_desc.value
		var term_code_associated = "";
		var mode ="";
		
		var mulitple_yn = "";
		var term_set_id= document.Procedure_List.proc_set.value;
		var retVal = new String();
		var dialogHeight= "75vh" ;
		var dialogWidth = "50vw" ;
		var status = "no";
		var tit = getLabel("Common.ProcedureCode.label",'COMMON');
		var dialogUrl    = "../../eMR/jsp/TermCodeFrameSet.jsp?title="+tit+"&term_set_id="+term_set_id+"&mulitple_yn="+mulitple_yn+"&temp_term_code="+temp_term_code+"&term_code_associated="+term_code_associated+"&term_desc="+term_desc;
		if(mode == '2'){
			dialogUrl+= "&Db_term_code="+term_code_associated;
		}
		var dialogArguments = term_set_id ;
		var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		var returnVal = await window.top.showModalDialog(dialogUrl, term_set_id, dialogFeatures);
	
		if( returnVal == null || returnVal == "" ){
			document.Procedure_List.proc_code.value="";
			document.Procedure_List.proc_desc.value="";
			
		}else{
			
			var retValCode = returnVal.split("||") ;
			var retVal		 = retValCode[0].split("\"") ;
			term_code		 = retVal[0];
			term_code_desc	 = retVal[1];
			level_desc		 = retVal[2];
			level			 = retVal[3];
			//alert("==="+term_code+"==="+term_code_desc+"==="+level_desc+"===");
			document.Procedure_List.proc_code.value = term_code;
			document.Procedure_List.proc_desc.value = retValCode[1];
			//document.Procedure_List.proc_desc.readOnly = true;
			
			//document.Procedure_List.proc_code.onblur();
		}
}

async function show_service_window()
{
			var retVal = 	""; //new String();
			var dialogHeight = "70vh" ;
			var dialogWidth = "70vw" ;
			var status = "no";
			var arguments	= "" ;
			var search_code="";
			var search_desc="";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll:no; status:" + status;
			var tit = getLabel("eCA.Services.label","CA");
			var target = document.forms[0].serv_code1;
			var locale = document.Procedure_List.locale.value;
			//target.value="";
			//var sql="Select service_code, short_desc from am_service";

			var sql = "Select service_code code, short_desc description from am_service_lang_vw where language_id = '"+locale+"' and service_code like upper(?) and upper(short_desc) like upper(?) ";

			//search_code= getLabel("eCA.ServiceCode.label","CA");
			//search_desc= "short_desc";
		
			//retVal = 	window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);

			var argArray		= new Array();
			var namesArray		= new Array();
			var valuesArray		= new Array();
			var datatypesArray	= new Array();
			
			argArray[0] = sql;
			argArray[1] = namesArray;
			argArray[2] = valuesArray;
			argArray[3] = datatypesArray;
			argArray[4] = "1,2";
			argArray[5] = target.value;
			argArray[6] = DESC_LINK;
			argArray[7] = CODE_DESC;
			retVal = await CommonLookup( tit, argArray );
			var arr=new Array();
				
			if (retVal != null && retVal !="")
			{
				var retVal=unescape(retVal);
				arr=retVal.split(",");
				if(document.Procedure_List.modal_yn.value=='Y'){
					parent.frames[0].document.forms[0].serv_code.value = arr[0];
					parent.frames[0].document.forms[0].serv_code1.value = arr[1];
				}
				else{
				top.content.workAreaFrame.frames[0].document.forms[0].serv_code.value = arr[0];
				top.content.workAreaFrame.frames[0].document.forms[0].serv_code1.value = arr[1];
				}
			}
			else
			{	
				if(document.Procedure_List.modal_yn.value=='Y'){
					parent.frames[0].document.forms[0].serv_code.value = "";
					parent.frames[0].document.forms[0].serv_code1.value ="";
					parent.frames[0].document.forms[0].serv_code1.focus();				
				}
				else{
					top.content.workAreaFrame.frames[0].document.forms[0].serv_code.value = "";
					top.content.workAreaFrame.frames[0].document.forms[0].serv_code1.value ="";
					top.content.workAreaFrame.frames[0].document.forms[0].serv_code1.focus();
				}
			}

			/*
			if (!(retVal == null)) {
				var vals=retVal.split("/")	;
				top.content.workAreaFrame.procedurelistquery.document.Procedure_List.serv_code.value=vals[0];
			}
			top.content.workAreaFrame.procedurelistquery.document.Procedure_List.serv_code.focus();
			*/
}

function checkProcedurecode(obj)
{
	//serv_code
	if(obj.value!="" )
	{
				document.forms[0].proc_code.value = obj.value;
				HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempForm' id='tempForm' method='post' action='ProcedureListIntermidiate.jsp'><input type=hidden name='procedurecode' id='procedurecode' value='"+obj.value+"'> </form></body></html>"
				top.content.messageFrame.document.write(HTMLVal);
				top.content.messageFrame.document.tempForm.submit();
	}
}

function clear_result(){
	
	if(document.Procedure_List.modal_yn.value=='Y'){		
		parent.procedurelisttitle.document.location.href= '../../eCommon/html/blank.html';
		parent.procedurelistresult.document.location.href = '../../eCommon/html/blank.html'; 
		parent.procedurelistresultdetail.document.location.href = '../../eCommon/html/blank.html'; 
		parent.procedurelistquery.document.forms[0].code_set.selectedIndex=0;
		parent.procedurelistquery.document.forms[0].proc_code.value="";
		parent.procedurelistquery.document.forms[0].proc_desc.value="";
		parent.procedurelistquery.document.forms[0].proc_set.value="";
		parent.procedurelistquery.document.forms[0].searchcode_button1.disabled=true;

		parent.procedurelistquery.document.forms[0].serv_code.value="";
		parent.procedurelistquery.document.forms[0].serv_code1.value="";
		parent.procedurelistquery.document.forms[0].from_date.value="";
		parent.procedurelistquery.document.forms[0].to_date.value="";
}
else{
	top.content.workAreaFrame.procedurelisttitle.document.location.href= '../../eCommon/html/blank.html';
	top.content.workAreaFrame.procedurelistresult.document.location.href = '../../eCommon/html/blank.html'; 
	top.content.workAreaFrame.procedurelistresultdetail.document.location.href = '../../eCommon/html/blank.html'; 
	top.content.workAreaFrame.procedurelistquery.document.forms[0].code_set.selectedIndex=0;
	top.content.workAreaFrame.procedurelistquery.document.forms[0].proc_code.value="";
	top.content.workAreaFrame.procedurelistquery.document.forms[0].proc_desc.value="";
	top.content.workAreaFrame.procedurelistquery.document.forms[0].proc_set.value="";
	top.content.workAreaFrame.procedurelistquery.document.forms[0].searchcode_button1.disabled=true;
	top.content.workAreaFrame.procedurelistquery.document.forms[0].serv_code.value="";
	top.content.workAreaFrame.procedurelistquery.document.forms[0].serv_code1.value="";
	top.content.workAreaFrame.procedurelistquery.document.forms[0].from_date.value="";
	top.content.workAreaFrame.procedurelistquery.document.forms[0].to_date.value="";
	}
}

function search_result(){
	
	if(document.Procedure_List.modal_yn.value=='Y'){		
	parent.procedurelistresult.document.location.href = '../../eCommon/html/blank.html'; 
	parent.procedurelistresultdetail.document.location.href = '../../eCommon/html/blank.html'; 
	parent.procedurelisttitle.document.location.href='../../eCA/jsp/ProcedurelistTitle.jsp';
	var patient_id=parent.procedurelistquery.document.forms[0].patient_id.value;
	var code_set=parent.procedurelistquery.document.forms[0].proc_set.value;
	var proc_code=parent.procedurelistquery.document.forms[0].proc_code.value;
	var serv_code=parent.procedurelistquery.document.forms[0].serv_code.value;
	var from_date=parent.procedurelistquery.document.forms[0].from_date.value;
	var from_date=parent.procedurelistquery.document.forms[0].from_date.value;
	var encounter_id=parent.procedurelistquery.document.forms[0].encounter_id.value;	
	var called_mod=parent.procedurelistquery.document.forms[0].called_mod.value;	
	
	parent.procedurelistresult.document.location.href = '../../eCA/jsp/ProcedurelistResult.jsp?patient_id='+patient_id+'&encounter_id='+encounter_id+'&code_set='+code_set+'&proc_code='+proc_code+'&serv_code='+serv_code+'&from_date='+from_date+'&to_date='+to_date+'&called_mod='+called_mod+"&mode=first"; 	
	//top.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
	}
	else{
	top.content.workAreaFrame.procedurelistresult.document.location.href = '../../eCommon/html/blank.html'; 
	top.content.workAreaFrame.procedurelistresultdetail.document.location.href = '../../eCommon/html/blank.html'; 
	top.content.workAreaFrame.procedurelisttitle.document.location.href='../../eCA/jsp/ProcedurelistTitle.jsp'
	
	var patient_id=top.content.workAreaFrame.procedurelistquery.document.forms[0].patient_id.value;
	var code_set=top.content.workAreaFrame.procedurelistquery.document.forms[0].proc_set.value;
	var proc_code=top.content.workAreaFrame.procedurelistquery.document.forms[0].proc_code.value;
	var serv_code=top.content.workAreaFrame.procedurelistquery.document.forms[0].serv_code.value;
	var from_date=top.content.workAreaFrame.procedurelistquery.document.forms[0].from_date.value;
	var to_date=top.content.workAreaFrame.procedurelistquery.document.forms[0].to_date.value;

/*	if(!CheckSystemDateLesser(top.content.workAreaFrame.procedurelistquery.document.forms[0].to_date,top.content.workAreaFrame.procedurelistquery.document.forms[0].from_date))
	 return ;*/
	// alert("==="+patient_id+"==="+code_set+"==="+proc_code+"==="+serv_code+"===");
	
	
	top.content.workAreaFrame.procedurelistresult.document.location.href = '../../eCA/jsp/ProcedurelistResult.jsp?patient_id='+patient_id+'&code_set='+code_set+'&proc_code='+proc_code+'&serv_code='+serv_code+'&from_date='+from_date+'&to_date='+to_date+"&mode=first"; 
	
	top.content.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
	}
}


/*
function CheckSystemDateLesser(from,today) { //args objects 1st is this object & second is the date in dd/mm/yyyy
 if(today != "" && from.value !="" )
	 {
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today ;
				
				if(fromdate.length > 0 && todate.length > 0 )
				{
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						if(Date.parse(todt) < Date.parse(fromdt))
						{
							var msg =getMessage("DATE_GREATER_SYSDATE","CA");
							alert(msg);
							//top.messageframe.location.href = '../../eCommon/jsp/error.jsp?err_num='+msg;
							from.focus();
							from.select();
							return false;
						}
						else if(Date.parse(todt) >= Date.parse(fromdt))
						{
							top.content.messageFrame.location.href = '../../eCommon/jsp/error.jsp?';
							return true;
						}
				}
			return true;
	 }
	 return true;
}*/

function CheckSystemDateLesser(fromDate,toDate,currDate,format,locale)
{
	if((!fromDate.value==""))
	{
		if(!isBeforeNow(fromDate.value, format, locale))
		{
			alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
			//fromDate.select();
			fromDate.value='';
			fromDate.focus();
			return false;
		}
		else
		{		
			if((!toDate.value==""))
			{
				if(isBeforeNow(toDate.value, format, locale))
				{
					if(isAfter(toDate.value, fromDate.value, format, locale))
						return true;
					else
					{
						alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
						toDate.value='';
						toDate.focus();
						return false;
					}
			    }
				else
				{
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
					//toDate.select();
					toDate.value='';
					toDate.focus();
					return false;
				}
			}
		}	
	}
	else
	{
			if((!toDate.value==""))
			{
				if(!isBeforeNow(toDate.value, format, locale))
				{
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
					//toDate.select();
					toDate.value='';
					toDate.focus();
					return false;
				}
			}
	}
}
  
/*
function doDateCheckFrom(from,today) { //args objects 1st is this object & second is the date object
 if(from.value != "" && today.value !="" )
	 {
				var fromarray;
				var toarray;
				var fromdate =from.value ;
				var todate =today.value ;
				
				if(fromdate.length > 0 && todate.length > 0 ) {
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);
						if(Date.parse(todt) > Date.parse(fromdt)) {
							var msg = getMessage("FROM_DATE_GREAT_EFF","CA");
							alert(msg);
							//top.messageframe.location.href = '../../eCommon/jsp/error.jsp?err_num='+msg;
							today.focus();
							today.select();
							return false;
						}
						else if(Date.parse(todt) <= Date.parse(fromdt))
						{
							top.content.messageFrame.location.href = '../../eCommon/jsp/error.jsp?';
							return true;
						}
						}
			return true;
	 }
	 return true;
}
*/
function showCalendarValidate(str){
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}

/*function checkService(obj){
		if (obj.value!=""){
			HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><body class=MESSAGE><form name='tempForm' id='tempForm' method='post' action='ProcedureListServSearch.jsp'><input type=hidden name='serviceid' id='serviceid' value='"+obj.value+"'> </form></body></html>"
			top.content.messageFrame.document.write(HTMLVal);
			top.content.messageFrame.document.tempForm.submit();
	}
}
*/
function checkService(obj)
{
	if(!obj.value=="")
	{
		show_service_window();
	}
	else
	{
		if(document.Procedure_List.modal_yn.value=='Y'){
			parent.frames[0].document.forms[0].serv_code.value = "";
			parent.frames[0].document.forms[0].serv_code1.value ="";
		}
		else{
		top.content.workAreaFrame.frames[0].document.forms[0].serv_code.value = "";
		top.content.workAreaFrame.frames[0].document.forms[0].serv_code1.value ="";
		}
	}

}

async function callfunction_procedure()
{
							var target			= top.content.workAreaFrame.frames[0].document.forms[0].proc_desc;
							var serviceVal   = top.content.workAreaFrame.frames[0].document.forms[0].proc_code.value;
							var retVal			=  new String();
							var dialogTop	= "40";
							var dialogHeight		= "10" ;
							var dialogWidth= "40" ;
							var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
							var arguments	= "" ;
							var search_desc	= "";
							var title			=getLabel('Common.service.label','COMMON');

							
							var sql="Select diag_code,short_desc from mr_icd_code where  record_type='O'  and upper(SHORT_DESC) like upper(?) "
							var argArray = new Array();
							var namesArray = new Array();
							var valuesArray = new Array();
							var datatypesArray = new Array();

							argArray[0] = sql;
							argArray[1] = namesArray;
							argArray[2] = valuesArray;
							argArray[3] = datatypesArray;
							argArray[4] = "1,2";
							argArray[5] = target.value;
							argArray[6] = DESC_LINK;
							argArray[7] = CODE_DESC;

							retArray = await CommonLookup( title, argArray );
							if(retArray != null && retArray !="")	{
								var ret1=unescape(retArray);
								var arr=ret1.split(",");
								if(arr[1]==undefined) { 
								arr[1]="";
								arr[0]="";
								}	
								top.content.workAreaFrame.frames[0].document.forms[0].proc_code.value = arr[0];
								
							}else{
								top.content.workAreaFrame.frames[0].document.forms[0].proc_code.value = "";
								
							}
							top.content.workAreaFrame.frames[0].document.forms[0].searchcode_button.disabled=false;
							top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp';
		}


async function callfunction()
				{
							var target			= top.content.workAreaFrame.frames[0].document.forms[0].serv_code1;
							var serviceVal   = top.content.workAreaFrame.frames[0].document.forms[0].serv_code1.value;
							var retVal			=  new String();
							var dialogTop	= "40";
							var dialogHeight		= "10" ;
							var dialogWidth= "40" ;
							var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
							var arguments	= "" ;
							var search_desc	= "";
							var title			=getLabel('Common.service.label','COMMON');
							var locale = document.Procedure_List_Search.locale.value;

							//var sql="Select service_code code , short_desc description from am_service where upper(service_code) like upper(?) and upper(short_desc) like upper(?) "

							var sql = "Select service_code code , short_desc  description from am_service_lang_vw where service_code like upper(?) and upper(short_desc) like upper(?) and language_id = '"+locale+"'";

							var argArray = new Array();
							var namesArray = new Array();
							var valuesArray = new Array();
							var datatypesArray = new Array();

							argArray[0] = sql;
							argArray[1] = namesArray;
							argArray[2] = valuesArray;
							argArray[3] = datatypesArray;
							argArray[4] = "1,2";
							argArray[5] = target.value;
							argArray[6] = DESC_LINK;
							argArray[7] = CODE_DESC;

							retArray = await CommonLookup( title, argArray );
							if(retArray != null && retArray !="")
							{
								var ret1=unescape(retArray);
								var arr=ret1.split(",");
								if(arr[1]==undefined) { 
								arr[1]="";
								arr[0]="";
								}	
								top.content.workAreaFrame.frames[0].document.forms[0].serv_code.value = arr[0];
								top.content.workAreaFrame.frames[0].document.forms[0].serv_code1.value = arr[1];
							}
							else
							{
								top.content.workAreaFrame.frames[0].document.forms[0].serv_code.value = "";
								top.content.workAreaFrame.frames[0].document.forms[0].serv_code1.value = "";
							}
							top.content.workAreaFrame.frames[0].document.forms[0].searchcode_button.disabled=false;
							top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp';
				}


	var radioval="D";
	function closew()
	{
		parent.window.close();
	}
	

	function storeVal(currad)
	{
	radioval=currad.value
	 }

function scrollTitle(){
  var y = parent.code_desc.document.body.scrollTop;

  if(y == 0){
	parent.code_desc.document.getElementById("divDataTitle").style.position = 'static';
	parent.code_desc.document.getElementById("divDataTitle").style.posTop  = 0;
  }else{
	parent.code_desc.document.getElementById("divDataTitle").style.position = 'relative';
	parent.code_desc.document.getElementById("divDataTitle").style.posTop  = y-2;
  }

}
function alignWidth(){
	var totalRows =  document.getElementById("dataTable").rows.length;
	var counter = totalRows-1;
	var temp = parent.procedurelisttitle.document.getElementById("dataTitleTable").rows[0].cells.length;
	for(var i=0;i<temp;i++) {
		parent.procedurelisttitle.document.getElementById("dataTitleTable").rows[0].cells[i].width= document.getElementById("dataTable").rows[counter].cells[i].offsetWidth;
		
	}
}

	function closewd(Dcode)
	  {
		while(Dcode.indexOf("%")!=-1)
		Dcode=Dcode.replace('%'," ");

		while(Dcode.indexOf("`")!=-1)
			Dcode=Dcode.replace('`',">");

		window.parent.parent.returnValue=Dcode;
		window.parent.parent.close();
	  }

	  	srl_no_array = new Array();
		var prev=1;
		var i=0;
		var prev1=0;
		var j=0;

function refer(ro,numofcols){
	prev1	=ro.rowIndex
	for (var i=0;i<numofcols;i++)
	{
		document.getElementById('dataTable').rows[prev].cells[i].style.backgroundColor=ro.bgColor;
	}
	for (var i=0;i<numofcols;i++)
	{
	ro.cells[i].style.backgroundColor="#B2B6D7";
	}

	prev	=ro.rowIndex
}

	function scrollTitleProcResult(){
          var y = parent.procedurelistresult.document.body.scrollTop;

          if(y == 0){
			parent.procedurelistresult.document.getElementById("divDataTitle").style.position = 'static';
			parent.procedurelistresult.document.getElementById("divDataTitle").style.posTop  = 0;
          }else{
			parent.procedurelistresult.document.getElementById("divDataTitle").style.position = 'relative';
			parent.procedurelistresult.document.getElementById("divDataTitle").style.posTop  = y-2;
          }

        }
		function alignWidthProcResult(){
			var totalRows =  parent.procedurelistresult.document.getElementById("dataTable").rows.length;
	        var counter = totalRows-1;
            var temp = parent.procedurelistresult.document.getElementById("dataTitleTable").rows[0].cells.length;
            for(var i=0;i<temp;i++) {
				parent.procedurelistresult.document.getElementById("dataTitleTable").rows[0].cells[i].width=parent.procedurelistresult.document.getElementById("dataTable").rows[counter].cells[i].offsetWidth;
				
            }
        }





//Functions for the file name SearchProcedureCustomListGroup.jsp-start

var prevClassName = "";
var prevRowObject = "";
function changeRowColor(obj, changeClassName)
{
	if( changeClassName==null )	changeClassName = "ITEMSELECT";
	if(	prevClassName != "" )
		for(var i=0; i<prevRowObject.cells.length; i++)
			if(prevRowObject.cells[i].className==changeClassName)
				prevRowObject.cells[i].className = prevClassName;

	prevRowObject	=	obj;
	prevClassName	=	obj.cells[0].className;

    for(var i=0; i<obj.cells.length; i++)
		if(obj.cells[i].className=="QRYODD" || obj.cells[i].className == "QRYEVEN" ||  obj.cells[i].className == "" )
			obj.cells[i].className = changeClassName;
}


//Functions for the file name SearchProcedureCustomListGroup.jsp-end 



//Functions for the file name ProcedureListQuery.jsp-start 


function showTable(obj)
{
	//alert("xx"+document.Procedure_List.proc_set.value);
	document.Procedure_List.proc_set.value ="";
	if(obj.value!=null && obj.value!="")
	{
		var code_set = obj.value;
		var split_val = code_set.split("~");
		//alert(split_val[0]);alert(split_val[1]);
		document.Procedure_List.proc_set.value = split_val[0];
		document.Procedure_List.proc_set_desc.value = split_val[1];
		
		//document.Procedure_List.proc_code.readOnly=true;
		document.Procedure_List.proc_desc.readOnly=false;
		
		document.Procedure_List.searchcode_button1.disabled=false;
		document.Procedure_List.proc_code.value="";
		document.Procedure_List.proc_desc.value="";
	}
	else{
		
		document.Procedure_List.proc_code.value="";
		document.Procedure_List.proc_desc.value="";
		document.Procedure_List.proc_desc.readOnly=true;
		
		document.Procedure_List.searchcode_button1.disabled=true;
	}
	
}

function alignHeading()
{
			
	if(parent.procedurelisttitle.document.getElementById("dataTitleTable") != null) 
	{
		var totalRows =  parent.procedurelistresult.document.getElementById("dataTable").rows.length;
		var counter = totalRows-1;
									
			parent.procedurelisttitle.document.getElementById("dataTitleTable").width =	eval(document.getElementById("dataTable").offsetWidth);
										
				for(j=0; j < document.getElementById("dataTable").rows[0].cells.length; j++) 
				{
					var wid=eval(document.getElementById("dataTable").rows[counter].cells[j].offsetWidth);
										
					if(parent.procedurelisttitle.document.getElementById("dataTitleTable").rows[0].cells[j] != null)
						{
							parent.procedurelisttitle.document.getElementById("dataTitleTable").rows[0].cells[j].width=wid;
						}
				}
	}
				
}




