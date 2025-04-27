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

/*function getTermCode(obj)
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
}*/


/*function callTermCode(obj)
{
		var temp_term_code = "";
		var term_desc = document.Procedure_List.proc_desc.value
		var term_code_associated = "";
		var mode ="";
		
		var mulitple_yn = "";
		var term_set_id= document.Procedure_List.proc_set.value;
		var retVal = new String();
		var dialogHeight= "28" ;
		var dialogWidth = "45" ;
		var status = "no";
		var dialogUrl    = "../../eMR/jsp/TermCodeFrameSet.jsp?title="+document.Procedure_List.proc_set_desc.value+"&term_set_id="+term_set_id+"&mulitple_yn="+mulitple_yn+"&temp_term_code="+temp_term_code+"&term_code_associated="+term_code_associated+"&term_desc="+term_desc;
		if(mode == '2'){
			dialogUrl+= "&Db_term_code="+term_code_associated;
		}
		var dialogArguments = term_set_id ;
		var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		var returnVal = window.showModalDialog(dialogUrl, term_set_id, dialogFeatures);
	
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
}*/

/*function show_service_window()
{
			var retVal = 	""; //new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
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
				top.content.workAreaFrame.frames[0].document.forms[0].serv_code.value = arr[0];
				top.content.workAreaFrame.frames[0].document.forms[0].serv_code1.value = arr[1];
			}
			else
			{
				top.content.workAreaFrame.frames[0].document.forms[0].serv_code.value = "";
				top.content.workAreaFrame.frames[0].document.forms[0].serv_code1.value ="";
				top.content.workAreaFrame.frames[0].document.forms[0].serv_code1.focus();
			}

			
}*/

/*function checkProcedurecode(obj)
{
	//serv_code
	if(obj.value!="" )
	{
				document.forms[0].proc_code.value = obj.value;
				HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><body class=MESSAGE><form name='tempForm' id='tempForm' method='post' action='ProcedureListIntermidiate.jsp'><input type=hidden name='procedurecode' id='procedurecode' value='"+obj.value+"'> </form></body></html>"
				top.content.messageFrame.document.write(HTMLVal);
				top.content.messageFrame.document.tempForm.submit();
	}
}*/

/*function clear_result(){

top.content.workAreaFrame.procedurelisttitle.document.location.href= '../../eCommon/html/blank.html';
top.content.workAreaFrame.procedurelistresult.document.location.href = '../../eCommon/html/blank.html'; 
top.content.workAreaFrame.procedurelistresultdetail.document.location.href = '../../eCommon/html/blank.html'; 
top.content.workAreaFrame.procedurelistquery.document.forms[0].code_set.selectedIndex=0;
top.content.workAreaFrame.procedurelistquery.document.forms[0].proc_code.value="";
top.content.workAreaFrame.procedurelistquery.document.forms[0].proc_set.value="";
top.content.workAreaFrame.procedurelistquery.document.forms[0].serv_code.value="";
top.content.workAreaFrame.procedurelistquery.document.forms[0].serv_code1.value="";
top.content.workAreaFrame.procedurelistquery.document.forms[0].from_date.value="";
top.content.workAreaFrame.procedurelistquery.document.forms[0].to_date.value="";
}*/

/*function search_result(){
	
	
	top.content.workAreaFrame.procedurelistresult.document.location.href = '../../eCommon/html/blank.html'; 
	top.content.workAreaFrame.procedurelistresultdetail.document.location.href = '../../eCommon/html/blank.html'; 
	top.content.workAreaFrame.procedurelisttitle.document.location.href='../../eCA/jsp/ProcedurelistTitle.jsp'
	
	var patient_id=top.content.workAreaFrame.procedurelistquery.document.forms[0].patient_id.value;
	var code_set=top.content.workAreaFrame.procedurelistquery.document.forms[0].proc_set.value;
	var proc_code=top.content.workAreaFrame.procedurelistquery.document.forms[0].proc_code.value;
	var serv_code=top.content.workAreaFrame.procedurelistquery.document.forms[0].serv_code.value;
	var from_date=top.content.workAreaFrame.procedurelistquery.document.forms[0].from_date.value;
	var to_date=top.content.workAreaFrame.procedurelistquery.document.forms[0].to_date.value;


	
	
	top.content.workAreaFrame.procedurelistresult.document.location.href = '../../eCA/jsp/ProcedurelistResult.jsp?patient_id='+patient_id+'&code_set='+code_set+'&proc_code='+proc_code+'&serv_code='+serv_code+'&from_date='+from_date+'&to_date='+to_date+"&mode=first"; 
	
	top.content.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
}
*/

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

/*function CheckSystemDateLesser(fromDate,toDate,currDate,format,locale)
{
	if((!fromDate.value==""))
	{
		if(!isBeforeNow(fromDate.value, format, locale))
		{
			alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
			fromDate.select();
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
						toDate.focus();
						return false;
					}
			    }
				else
				{
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
					toDate.select();
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
					toDate.select();
					toDate.focus();
					return false;
				}
			}
	}
}*/
  
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
/*function showCalendarValidate(str){
	var flg = showCalendar(str);
	eval("document.all."+str+".focus();");
	return flg;
}*/

/*function checkService(obj){
		if (obj.value!=""){
			HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><body class=MESSAGE><form name='tempForm' id='tempForm' method='post' action='ProcedureListServSearch.jsp'><input type=hidden name='serviceid' id='serviceid' value='"+obj.value+"'> </form></body></html>"
			top.content.messageFrame.document.write(HTMLVal);
			top.content.messageFrame.document.tempForm.submit();
	}
}
*/
/*function checkService(obj)
{
	if(!obj.value=="")
	{
		show_service_window();
	}
	else
	{
		top.content.workAreaFrame.frames[0].document.forms[0].serv_code.value = "";
		top.content.workAreaFrame.frames[0].document.forms[0].serv_code1.value ="";
	}

}*/

/*function callfunction_procedure()
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

							retArray = CommonLookup( title, argArray );
							if(retArray != null && retArray !="")	{
								top.content.workAreaFrame.frames[0].document.forms[0].proc_code.value = retArray[0];
								
							}else{
								top.content.workAreaFrame.frames[0].document.forms[0].proc_code.value = "";
								
							}
							top.content.workAreaFrame.frames[0].document.forms[0].searchcode_button.disabled=false;
							top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp';
		}
*/

/*function callfunction()
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

							retArray = CommonLookup( title, argArray );
							if(retArray != null && retArray !="")
							{
								top.content.workAreaFrame.frames[0].document.forms[0].serv_code.value = retArray[0];
								top.content.workAreaFrame.frames[0].document.forms[0].serv_code1.value = retArray[1];
							}
							else
							{
								top.content.workAreaFrame.frames[0].document.forms[0].serv_code.value = "";
								top.content.workAreaFrame.frames[0].document.forms[0].serv_code1.value = "";
							}
							top.content.workAreaFrame.frames[0].document.forms[0].searchcode_button.disabled=false;
							top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp';
				}*/


	
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
/*function alignWidth(){
	var totalRows =  document.getElementById("dataTable").rows.length;
	var counter = totalRows-1;
	var temp = parent.procedurelisttitle.document.getElementById("dataTitleTable").rows(0).cells.length;
	for(var i=0;i<temp;i++) {
		parent.procedurelisttitle.document.getElementById("dataTitleTable").rows(0).cells(i).width= document.getElementById("dataTable").rows(counter).cells(i).offsetWidth;
		
	}
}*/

	function closewd(Dcode)
	  {
		  
		while(Dcode.indexOf("%")!=-1)
		Dcode=Dcode.replace('%'," ");

		while(Dcode.indexOf("`")!=-1)
			Dcode=Dcode.replace('`',">");



		window.parent.parent.returnValue=Dcode;
		window.parent.parent.close();
	  }

	  	/*srl_no_array = new Array();
		var prev=1;
		var i=0;
		var prev1=0;
		var j=0;

function refer(ro,numofcols){
	prev1	=ro.rowIndex
	for (var i=0;i<numofcols;i++)
	{
		document.forms[0].all.dataTable.rows(prev).cells(i).style.backgroundColor=ro.bgColor;
	}
	for (var i=0;i<numofcols;i++)
	{
	ro.cells(i).style.backgroundColor="#B2B6D7";
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
            var temp = parent.procedurelistresult.document.getElementById("dataTitleTable").rows(0).cells.length;
            for(var i=0;i<temp;i++) {
				parent.procedurelistresult.document.getElementById("dataTitleTable").rows(0).cells(i).width=parent.procedurelistresult.document.getElementById("dataTable").rows(counter).cells(i).offsetWidth;
				
            }
        }





//Functions for the file name SearchProcedureCustomListGroup.jsp-start
*/
var prevClassName = "";
var prevRowObject = "";
function changeRowColor(obj, changeClassName)
{
	if( changeClassName==null )	changeClassName = "ITEMSELECT";
	if(	prevClassName != "" )
		for(var i=0; i<prevRowObject.cells.length; i++)
			if(prevRowObject.cells(i).className==changeClassName)
				prevRowObject.cells(i).className = prevClassName;

	prevRowObject	=	obj;
	prevClassName	=	obj.cells(0).className;

    for(var i=0; i<obj.cells.length; i++)
		if(obj.cells(i).className=="QRYODD" || obj.cells(i).className == "QRYEVEN" ||  obj.cells(i).className == "" )
			obj.cells(i).className = changeClassName;
}


//Functions for the file name SearchProcedureCustomListGroup.jsp-end 



//Functions for the file name ProcedureListQuery.jsp-start 

/*
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
										
				for(j=0; j < document.getElementById("dataTable").rows(0).cells.length; j++) 
				{
					var wid=eval(document.getElementById("dataTable").rows(counter).cells(j).offsetWidth);
										
					if(parent.procedurelisttitle.document.getElementById("dataTitleTable").rows(0).cells(j) != null)
						{
							parent.procedurelisttitle.document.getElementById("dataTitleTable").rows(0).cells(j).width=wid;
						}
				}
	}
				
}
*/

var currentTab = new String();
 currentTab = "demogrp_tab";
 function tab_click(objName) {
	 changeTab(objName);

	 if (objName == 'demogrp_tab')
 			Call();
 	else if (objName == 'cmodeaddr_tab')
 		CallSearch();
 		
 }
function Call() {
	 //parent.frames[1].location.href='MRSearchProcedureCustomListMain.jsp?<%=queryString%>'
	 parent.frames[1].location.href='MRSearchProcedureCustomListMain.jsp?'+document.consultation_form.query_string.value;	 
 }

 function CallSearch() {
 	 //parent.frames[1].location.href='MRSearchProc.jsp?<%=queryString%>'
	 parent.frames[1].location.href='MRSearchProc.jsp?'+document.consultation_form.query_string.value;
 }

 function changeTab(TabName)	{
	/*// RESET THE OLD TAB WHICH IS SELECTED FIRST .............
		 if (currentTab == 'demogrp_tab')
			document.getElementById("demogrp_tab").src = '../../eCA/images/Custom List_click.gif';
		else if (currentTab == 'cmodeaddr_tab')
			document.getElementById("cmodeaddr_tab").src = '../../eCA/images/Search_click.gif';
// CHANGE THE CURRENT TAB WHICH IS SELECTED NOW...............

		if (TabName == 'demogrp_tab')
			document.getElementById("demogrp_tab").src = '../../eCA/images/Custom_List.gif';
		else if (TabName == 'cmodeaddr_tab')
			document.getElementById("cmodeaddr_tab").src = '../../eCA/images/Search.gif';
//FINALY SET THE CURRENT TAB TO THE PASSED PARAMETER
		currentTab = TabName;*/

	if(TabName == 'demogrp_tab')
		document.getElementById("customlist").scrollIntoView();
	else if (TabName == 'cmodeaddr_tab')
		document.getElementById("search").scrollIntoView();
	
		currentTab = TabName;
		
}

var radioval="D";
async function valtext(comp)
 {
	var scheme_val = document.proc.qry_string.value;
	  var txt=comp.value
	 if (comp.value=="" || comp.value==null)
		alert(getMessage("SEARCH_TEXT_BLANK","Common"));
	  	 else
		await CallDescFrame(this);
}

 function valtext1(comp)
 {
	 var txt=comp;
		CallDescFrame(this);
}

function storeVal(currad)
{
	radioval=currad.value
}

function closew()
{
	parent.window.close();
}

	
function CallDescFrame()
{
	var listval=document.proc.search_criteria.options.value;
	var txtbox=document.proc.search_text.value;

	parent.code_desc.location.href='../../eMR/jsp/MRProcSearchResult.jsp?'+document.proc.qry_string.value+'&search_by='+radioval+'&search_criteria='+listval+'&search_text='+txtbox
 }
	

	

