function query() {

	f_query_mod.location.href ="../../eMR/jsp/ICDCodeForTabListQueryPage.jsp";
}

function create()
{
	f_query_mod.location.href ="../../eMR/jsp/ICDCodeForTabListMain.jsp";
	//parent.frames[1].document.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp'
}



function apply() 
{
	
	   var url=frames[1].location.href;
	
	   
	if ( url.indexOf("blank")==-1 && url.indexOf("QueryPage.jsp")==-1&&url.indexOf("QueryPageResult.jsp")==-1)
	{
		
		/*var maxRecord=parent.frames[1].document.frames[1].document.frames[1].document.forms[0].maxRecord1.value;
		
		var concat='';
		for(i=1;i<=maxRecord;i++)
		{
			var obj1=eval("parent.frames[1].document.frames[1].document.frames[1].document.forms[0].icdCodeNum"+i)
			if(obj1.value=="Y")
			{
				tab_list_no=eval("parent.frames[1].document.frames[1].document.frames[1].document.forms[0].tab_list_no"+i);
				diag_srl_no=eval("parent.frames[1].document.frames[1].document.frames[1].document.forms[0].diag_srl_no"+i);
				concat+=tab_list_no.value+"|"+diag_srl_no.value+"#";
			}
		}
		parent.frames[1].document.frames[1].document.frames[1].document.forms[0].concat_string.value=concat;
		*/
//		console.log(parent.frames[2].document.forms[0].querySelector('iframe[name="f_query_mod"]').contentDocument.forms[0].querySelector('iframe[name="queryResult"]').contentDocument.getElementById("age_spec"));
		var queryResultDoc = parent.frames[2].document.forms[0].querySelector('iframe[name="f_query_mod"]').contentDocument.forms[0].querySelector('iframe[name="queryResult"]').contentDocument ;
		
//		var fields = new Array(parent.frames[2].document.frames[1].document.frames[0].document.forms[0].age_spec)
		if(queryResultDoc.getElementById("age_spec") != null)
			var fields = new Array(queryResultDoc.getElementById("age_spec"))
        var names = new Array(getLabel("eMR.TabulationListType.label","MR"))
        if(f_query_mod.parent.frames[1].checkFieldsofMst( fields, names, f_query_mod.parent.frames[2]))
        {
			var fields = new Array (queryResultDoc.getElementById("tabulation_list"),queryResultDoc.getElementById("term_set_id"));
			var names = new Array(getLabel("eMR.TabulationList.label","MR"),"Term Set");		
			

		if(f_query_mod.parent.frames[1].checkFieldsofMst( fields, names, f_query_mod.parent.frames[2]))
		{
			if(parent.frames[2].document.forms[0].querySelector('iframe[name="f_query_mod"]')/*parent.frames[2].document.frames[1].document.frames[1]*/)
			{
				if(parent.frames[2].document.forms[0].querySelector('iframe[name="f_query_mod"]').contentDocument.forms[0]/*parent.frames[2].document.frames[1].document.frames[1].document.forms[0]*/)
				{			
					var criteriaForm = parent.frames[2].frames[1].frames[0].document.forms[0] ;
					var queryResultForm = parent.frames[2].frames[1].frames[1].document.forms[0];
					
					criteriaForm.Criteria_tabulation_list.value = queryResultForm.tabulation_list.value;
					criteriaForm.Criteria_orderBy.value = queryResultForm.orderBy.value;
					criteriaForm.Criteria_searchby.value = queryResultDoc.getElementById("searchby").value;
					criteriaForm.Criteria_searchcrt.value = queryResultForm.searchcrt.value;
					criteriaForm.Criteria_alphadescription.value = queryResultForm.alphadescription.value;
						
					criteriaForm.Criteria_from.value = queryResultForm.from.value;
					criteriaForm.Criteria_to.value = queryResultForm.to.value ;
//					console.log(criteriaForm.Criteria_from.value);
//					console.log(criteriaForm.Criteria_to.value);
					
					
					criteriaForm.Criteria_age_spec.value = queryResultForm.age_spec.value;
					criteriaForm.Criteria_selectedAlpha.value = queryResultForm.selectedAlpha.value;
					criteriaForm.Criteria_diag_code_scheme.value = queryResultForm.diag_code_scheme.value;
//					console.log(queryResultForm) ;
//					console.log(criteriaForm) ;
//					console.log(parent.frames[2].document.forms[0].querySelector('iframe[name="f_query_mod"]').contentDocument.forms[0].outerHTML);
					var icdCodeNumElements = queryResultForm.querySelectorAll('[name*="icdCodeNum"]');
//					console.log(icdCodeNumElements);

					// Add hidden inputs to criteriaForm for each icdCodeNum element and TabList element
					icdCodeNumElements.forEach(function(element, index) {
					    var hiddenInput = document.createElement('input');
					    hiddenInput.type = 'hidden';
					    hiddenInput.name = element.name;
					    hiddenInput.value = element.value;
					    criteriaForm.appendChild(hiddenInput);
//					    console.log("Added hidden input: " + hiddenInput.name + "=" + hiddenInput.value);
					});
					var icdTabListElements = queryResultForm.querySelectorAll('[name*="tab_list_no"]');
					icdTabListElements.forEach(function(element, index) {
					    var hiddenInput = document.createElement('input');
					    hiddenInput.type = 'hidden';
					    hiddenInput.name = element.name;
					    hiddenInput.value = element.value;
					    criteriaForm.appendChild(hiddenInput);
//					    console.log("Added hidden input: " + hiddenInput.name + "=" + hiddenInput.value);
					});
					
					criteriaForm.method= "POST" ;
					criteriaForm.action="../../servlet/eMR.ICDCodeForTabListServlet?mode=apply";
					criteriaForm.target="messageFrame";
					criteriaForm.submit();	
				}
				else
				{
					//frames[1].location.href ="../../eMR/jsp/ICDCodeForTabListMain.jsp";
					message  = getMessage("APPLY_NOT_VALID",'MR');
	                messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					//frames[0].location.reload();
					//history.go(0);
				}
			}
		  }
		}
	}
else {
	message  = getMessage("APPLY_NOT_VALID",'MR');
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
      }
	
}


function onSuccess() 
{	
	if(frames[1].document.forms[0].name=="parentForm")
		frames[1].location.href = "../../eMR/jsp/ICDCodeForTabListMain.jsp";
}

function reset()
{
	if (frames[1].document.location.href.indexOf("blank")==-1)
	{
		if(frames[1].document.forms[0].name=="parentForm")
			frames[1].location.href = "../../eMR/jsp/ICDCodeForTabListMain.jsp";
		else
			frames[1].document.forms[0].reset();
	}
	else
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
}

function ChgVal(Obj)
{
	if(Obj.value == "Y")
		Obj.value="N";
	else if(Obj.value == "N")
		Obj.value="Y";
}

function poptabListType(TabListNo)
{
	var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='tabListForm' id='tabListForm' method='post' action='../../eMR/jsp/GetComments.jsp?criteria=populateTabType&TabListNo="+TabListNo+" '></form></BODY></HTML>";
	parent.frames[2].document.write(HTMLVal);
	parent.frames[2].document.forms[0].submit();
}

function call_searchCode()
{		
	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';
	if(document.forms[0].tabulation_list_desc.value!="") 
		searchCode(document.forms[0].search_button,document.forms[0].tabulation_list_desc);
	else
	{
		//document.forms[0].all.diag_code_disp.innerText='';
		parent.frames[1].location.href="../../eCommon/html/blank.html";
	}
}

async function searchCode(obj,target)
{
	var retVal =    new String();               
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	
	var tit = getLabel("eMR.TabulationList.label","MR");

	var tab_list_type = document.forms[0].age_spec.value; 
	
	//if(tab_list_type == 'P') tab_list_type = 'O';
	
	var sql = "SELECT tab_list_no code, long_desc description FROM mr_tab_list WHERE tab_list_type='"+tab_list_type+"' AND eff_status='E' AND upper(tab_list_no) like upper(?) AND upper(long_desc) LIKE upper(?) ORDER BY 2";		

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );				
	
	if(retVal != null && retVal != "" )
	{	 				
		var ret1=unescape(retVal);
		/*arr=ret1.split(",");
		document.forms[0].tabulation_list_desc.value=arr[1];					
		document.forms[0].tabulation_list.value=arr[0];*/
		/*Below line commented and added for this SCF ML-MMOH-SCF-0501*/
		var indx=ret1.indexOf(",");
		var code=ret1.substring(0,indx); 
		indx++;		
		var decription=ret1.substring(indx,ret1.length);		
		document.forms[0].tabulation_list_desc.value=decription;					
		document.forms[0].tabulation_list.value=code;		
		//End ML-MMOH-SCF-0501
		//poptabListType(arr[0]);	
		//document.forms[0].all.diag_code_disp.style.visibility="visible";
	}
	else
	{		
		document.forms[0].tabulation_list_desc.value="";					
		document.forms[0].tabulation_list.value="";
	}
}
		
function populateResult()
{	
	search();
}

function search()
{
	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';
    var fields = new Array (document.forms[0].age_spec);
	var names = new Array(getLabel("eMR.TabulationListType.label","MR"));
    if(parent.parent.frames[1].checkFieldsofMst( fields, names, parent.parent.frames[2]))
	{
		var fields = new Array (document.forms[0].tabulation_list_desc,document.forms[0].term_set_id);
		var names = new Array(getLabel("eMR.TabulationList.label","MR"),"Term Set");
		document.forms[0].search.disabled = true;
		if(parent.parent.frames[1].checkFieldsofMst( fields, names, parent.parent.frames[2]))
		{
			callMemberquery();
			//to_visible();
			document.forms[0].search.disabled = false;
			return true;		
		}
		else
		{
			parent.frames[1].location.href="../../eCommon/html/blank.html";
			document.forms[0].search.disabled = false;
			return false;
		}
	}
	
}

function clearValues()
{
	document.forms[0].search.disabled = false;
	parent.frames[1].location.href="../../eCommon/html/blank.html";
	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';
}

function to_hide()
{
	//document.getElementById("alpha").style.visibility="hidden";
	parent.frames[1].location.href='../../eCommon/html/blank.html'
}

/*function to_visible()
{
	//document.getElementById("alpha").style.visibility="visible";
	
	parent.frames[1].location.href='../../eCommon/html/blank.html'
	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp'
}*/
	
function callMemberquery()
{	
	var orderBy = document.forms[0].orderBy.value;
	var call_result = document.forms[0].call_result.value;
	var term_set_id=document.forms[0].term_set_id.value;
	

	if(call_result != '1'){}
	else
	{
		var age_spec = document.forms[0].age_spec.value;
		var searchby=document.forms[0].searchby.value;
		var searchcrt=document.forms[0].searchcriteria.value;
		var alphadescription=document.forms[0].alpha_desc.value;
		if(alphadescription.indexOf("'")!=-1)
		{			
			alphadescription = alphadescription.replace("'","''");
		}
		//alert(alphadescription);
	 	//parent.frames[1].location.href="../../eMR/jsp/ICDCodeForTabListQueryResult.jsp?tabulation_list="+document.forms[0].tabulation_list.value+"&age_spec="+age_spec+"&orderBy="+orderBy+"&fromSelect=fromSelect&selectedAlpha=A&diag_code_scheme="+diag_code_scheme+"&searchby="+searchby+"&alphadescription="+alphadescription+"&searchcrt="+searchcrt;
		parent.frames[1].location.href="../../eMR/jsp/ICDCodeForTabListQueryResult.jsp?tabulation_list="+document.forms[0].tabulation_list.value+"&age_spec="+age_spec+"&orderBy="+orderBy+"&fromSelect=fromSelect&selectedAlpha=&term_set_id="+term_set_id+"&searchby="+searchby+"&alphadescription="+encodeURIComponent(alphadescription)+"&searchcrt="+searchcrt;
	}
}


/* previous Function IN 10.2 Mdified on3/3/2008
function submitPrevNext(from, to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	document.forms[0].submit();
}*/

/*New Function Written on 3/3/2008*/
function submitPrevNext(from, to)
{
	
	document.forms[0].from.value = from;
	document.forms[0].to.value = to; 
	


	parent.frames[0].document.forms[0].Criteria_tabulation_list.value=document.forms[0].tabulation_list.value;
	parent.frames[0].document.forms[0].Criteria_orderBy.value=document.forms[0].orderBy.value;
//	parent.frames[0].document.forms[0].Criteria_searchby.value=document.forms[0].document.forms[0].searchby.value;
	parent.frames[0].document.forms[0].Criteria_searchby.value=document.getElementById("searchby").value;

	parent.frames[0].document.forms[0].Criteria_searchcrt.value=document.forms[0].searchcrt.value;
	parent.frames[0].document.forms[0].Criteria_alphadescription.value=document.forms[0].alphadescription.value;
	parent.frames[0].document.forms[0].Criteria_from.value=document.forms[0].from.value;
	parent.frames[0].document.forms[0].Criteria_to.value=document.forms[0].to.value;
	parent.frames[0].document.forms[0].Criteria_age_spec.value=document.forms[0].age_spec.value;
	parent.frames[0].document.forms[0].Criteria_selectedAlpha.value=document.forms[0].selectedAlpha.value;
	parent.frames[0].document.forms[0].Criteria_diag_code_scheme.value=document.forms[0].term_set_id.value;
    
		
	if(confirm(getMessage('WANT_TO_SAVE','common')))
	{	
//		console.log("Inside get message..") ;
		document.forms[0].action = '../../servlet/eMR.ICDCodeForTabListServlet';
		document.forms[0].submit();
	}
	else
	{
		reloadresultPage('C');
	}
}
/*Function Added On 3/3/2008*/
function reloadresultPage(frame)
{
	if(frame == 'C')
	{
		
		var queryCriteriaFrame = parent.document.getElementById('queryCriteria');
		var queryCriteriaDocument = "" ;
		
		if(queryCriteriaFrame != null)
			queryCriteriaDocument = queryCriteriaFrame.contentDocument || queryCriteriaFrame.contentWindow.document;
		else {
			queryCriteriaFrame = document.getElementById('queryCriteria');
			queryCriteriaDocument = queryCriteriaFrame.contentDocument || queryCriteriaFrame.contentWindow.document;
		}
//		console.log(queryCriteriaDocument.getElementById("Criteria_searchby")) ;
		
		
		var tabulation_list=queryCriteriaDocument.getElementById("Criteria_tabulation_list").value;
		var orderBy=queryCriteriaDocument.getElementById("Criteria_orderBy").value;
		var searchby=queryCriteriaDocument.getElementById("Criteria_searchby").value;
		var searchcrt=queryCriteriaDocument.getElementById("Criteria_searchcrt").value;
		
		var alphadescription = queryCriteriaDocument.getElementById("Criteria_alphadescription").value;
		var from=queryCriteriaDocument.getElementById("Criteria_from").value;
		var to=queryCriteriaDocument.getElementById("Criteria_to").value;
		var age_spec=queryCriteriaDocument.getElementById("Criteria_age_spec").value;
		var selectedAlpha=queryCriteriaDocument.getElementById("Criteria_selectedAlpha").value;
		var term_set_id=queryCriteriaDocument.getElementById("Criteria_diag_code_scheme").value;
				
		var queryResultFrame = parent.document.getElementById('queryResult');
		var queryResultDocument = "" ;
		
		if(queryResultFrame != null)
			queryResultDocument = queryResultFrame.contentDocument || queryResultFrame.contentWindow.document;
		else {
			queryResultFrame = document.getElementById('queryResult');
			queryResultDocument = queryResultFrame.contentDocument || queryResultFrame.contentWindow.document;
		}
		queryResultDocument.location.href='../../eMR/jsp/ICDCodeForTabListQueryResult.jsp?tabulation_list='+tabulation_list+'&orderBy='+orderBy+'&searchby='+searchby+'&searchcrt='+searchcrt+'&alphadescription='+alphadescription+'&from='+from+'&to='+to+'&age_spec='+age_spec+'&selectedAlpha='+selectedAlpha+'&term_set_id='+term_set_id;
	}
	else if(frame == 'A')// from apply
	{
		parent.frames[1].frames[1].frames[1].document.location.href='../../eCommon/html/blank.html';
	}
	else if(frame == 'O')
	{
		var tabulation_list=parent.frames[1].frames[0].document.forms[0].Criteria_tabulation_list.value;
		var orderBy=parent.frames[1].frames[0].document.forms[0].Criteria_orderBy.value;
//		var searchby=parent.frames[1].frames[0].document.forms[0].document.forms[0].Criteria_searchby.value;
		var searchby=parent.frames[1].frames[0].document.getElementById("Criteria_searchby").value;
		var searchcrt=parent.frames[1].frames[0].document.forms[0].Criteria_searchcrt.value;
		var alphadescription=parent.frames[1].frames[0].document.forms[0].Criteria_alphadescription.value;
		var from=parent.frames[1].frames[0].document.forms[0].Criteria_from.value;
		var to=parent.frames[1].frames[0].document.forms[0].Criteria_to.value;
		var age_spec=parent.frames[1].frames[0].document.forms[0].Criteria_age_spec.value;
		var selectedAlpha=parent.frames[1].frames[0].document.forms[0].Criteria_selectedAlpha.value;
		var term_set_id=parent.frames[1].frames[0].document.forms[0].Criteria_diag_code_scheme.value;
		parent.frames[1].frames[1].document.location.href='../eMR/jsp/ICDCodeForTabListQueryResult.jsp?tabulation_list='+tabulation_list+'&orderBy='+orderBy+'&searchby='+searchby+'&searchcrt='+searchcrt+'&alphadescription='+alphadescription+'&from='+from+'&to='+to+'&age_spec='+age_spec+'&selectedAlpha='+selectedAlpha+'&term_set_id='+term_set_id;
	}
			
}

//http://localhost:7001/eHIS/eMR/jsp/ICDCodeForTabListQueryResult.jsp?tabulation_list=3W&age_spec=D&orderBy=short_desc&fromSelect=fromSelect&selectedAlpha=&term_set_id=ICD10&searchby=C&alphadescription=&searchcrt=S

function callMember(alpha)
{	
	
	parent.frames[0].document.forms[0].Criteria_alphadescription.value = alpha;
	parent.frames[0].document.forms[0].Criteria_selectedAlpha.value = alpha;

	if(document.forms[0].selectedAlpha){
		document.forms[0].selectedAlpha.value=alpha;

	}
//	if(document.forms[0].from)	
//		document.forms[0].from.value= -1;
//	if(document.forms[0].to)	
//		document.forms[0].to.value= -1;
//	document.forms[0].selectedAlpha.value=alpha;
   
	document.forms[0].action="../../eMR/jsp/ICDCodeForTabListQueryResult.jsp";
	document.forms[0].submit();
	document.getElementById("header").style.visibility="visible";
}

function enbDispTablist(obj)
{
	var age_spec='';
	if(obj.value == '')
	{
		document.forms[0].tabulation_list_desc.value	= '';
		//document.forms[0].diag_code_scheme.value		= '';
		document.getElementById('diag_code_disp').value = '';
		document.getElementById('diag_code_disp').disabled = true;
	    document.forms[0].tabulation_list_desc.disabled = true;
		document.forms[0].search_button.disabled		= true;
        parent.frames[0].document.forms[0].tabulationlistgif.style.visibility='hidden';
		parent.frames[0].document.forms[0].termsetgif.style.visibility='hidden';
		parent.frames[1].location.href='../../eCommon/html/blank.html';
	}
	else
	{
		parent.frames[0].document.forms[0].tabulationlistgif.style.visibility='visible';
		parent.frames[0].document.forms[0].termsetgif.style.visibility='visible';
		if(document.getElementById('diag_code_disp').length>1){
			var len=document.getElementById('diag_code_disp').length;
		for(i=len;i>0;i--){
			document.getElementById('diag_code_disp').remove(i);
			}
		}
		
		document.forms[0].tabulation_list_desc.value	= '';
		document.forms[0].diag_code_scheme.value		= '';
		document.getElementById('diag_code_disp').disabled	= false;
		age_spec=document.getElementById('age_spec').value;
//		age_spec=document.forms[0].all.age_spec.value;
		
		document.forms[0].tabulation_list_desc.disabled	= false;
		document.forms[0].search_button.disabled		= false;
		
		var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'><form name='agespecform' id='agespecform' method='post' action='../../eMR/jsp/GetComments.jsp?age_spec="+age_spec+" '></form></BODY></HTML>";
		parent.parent.frames[2].document.write(HTMLVal);
	    parent.parent.frames[2].document.forms[0].submit();
		parent.frames[1].location.href='../../eCommon/html/blank.html';
	}
}

function clearPage(obj){
	parent.frames[1].location.href='../../eCommon/html/blank.html';
}


