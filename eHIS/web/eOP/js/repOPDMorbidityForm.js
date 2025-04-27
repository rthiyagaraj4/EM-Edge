function reset() {
	f_query_add_mod.document.repOPDMorbidity.reset() ;
}
function doDateCheckMsg1(from,to,messageFrame,format) 
{
	alert(from.value)
	alert(to.value)
	if (from.value != undefined)
	{
		from = from.value;
	}
	else
	{
		from=from;
	}

	if (to.value != undefined)
	{
		to = to.value;
	}
	else
	{
		to=to;
	}

	if ( to=='' || from=='' )
	{
		return true;
	}

	 if(!isBefore(from,to,format,localeName)){
		 alert("IF")
		var error=getMessage("REMARKS_MUST_GR_EQUAL","common") ;
		error=error.replace("$",getLabel("Common.to.label","Common"));
		alert(error)
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
			return false;
		}else{  
			alert("fds")
			return true;
		}
}
function chkWithSysDt(obj)
	{
		if(obj.value!=''){

			if(isBeforeNow(obj.value,"MY",localeName))
				return true;
			else {
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				obj.select();
				obj.focus();
				return false ;
			}
		}
}
function run() 
{
	var fields = new Array( f_query_add_mod.document.repOPDMorbidity.P_fr_visit_date,
                            f_query_add_mod.document.repOPDMorbidity.P_to_visit_date );

	var visit_frm = f_query_add_mod.getLabel('Common.Visit.label','Common')+" "+f_query_add_mod.getLabel('Common.month.label','Common')+" "+f_query_add_mod.getLabel('Common.from.label','Common');				
	var visit_to = f_query_add_mod.getLabel('Common.Visit.label','Common')+" "+f_query_add_mod.getLabel('Common.month.label','Common')+" "+f_query_add_mod.getLabel('Common.to.label','Common');				
    var names = new Array(visit_frm, visit_to);
    if(f_query_add_mod.checkFields( fields, names, messageFrame)){
		var from = f_query_add_mod.document.repOPDMorbidity.P_fr_visit_date;
		var to     = f_query_add_mod.document.repOPDMorbidity.P_to_visit_date ; 
		var visit_month = f_query_add_mod.getLabel('Common.Visit.label','Common')+" "+f_query_add_mod.getLabel('Common.month.label','Common');
		if( f_query_add_mod.doDateChkWithLabel( from, to, messageFrame,'MY',visit_month) ){
				if (f_query_add_mod.trimCheck(from.value)) {				
					f_query_add_mod.document.repOPDMorbidity.P_fr_visit_date.value = from.value;
				}
				if (f_query_add_mod.trimCheck(to.value)) {				
					f_query_add_mod.document.repOPDMorbidity.P_to_visit_date.value = to.value;
				}
				if(f_query_add_mod.CheckString( visit_month,f_query_add_mod.document.repOPDMorbidity.P_fr_visit_date,f_query_add_mod.document.repOPDMorbidity.P_to_visit_date,messageFrame))     	

				if(f_query_add_mod.CheckString( f_query_add_mod.getLabel('eMR.TabListNo.label','MR'),f_query_add_mod.document.repOPDMorbidity.p_tab_list_fr,f_query_add_mod.document.repOPDMorbidity.p_tab_list_to,messageFrame))     	

				f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.repOPDMorbidity.submit() ;
		}
	}
}
function getTablistData(obj,target){
	if(target.value!=""&&target.value!=null){
			searchCode(obj,target);
	}
}
	async function searchCode(obj,target){
		var sm='';
//		if(target.name=="tab_list"){
			tit="Tab List"
			sql="select TAB_LIST_NO, short_desc from MR_TAB_LIST";
			search_code="TAB_LIST_NO";
			search_desc= "short_desc"
//		}
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;

		argumentArray[0] = "SELECT TAB_LIST_NO CODE,SHORT_DESC DESCRIPTION FROM MR_TAB_LIST WHERE UPPER(TAB_LIST_NO) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?)";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal = await CommonLookup(getLabel("eMR.TabulationListCode.label","eMR"), argumentArray );
		var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if(retVal==null || retVal=="")
				target.value="";
			else
				target.value=arr[0];
}
/*Commented On 12/7/2009 for internationalization */
/*function searchCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var p_user_name = document.repOPDMorbidity.p_user_name.value;
			var p_resp_id = document.repOPDMorbidity.p_resp_id.value;
			
			//alert(obj.name)
			if(obj.name=="tab_list")
			{
				tit="Tab List"
				sql="select TAB_LIST_NO, short_desc from MR_TAB_LIST";
				search_code="TAB_LIST_NO";
				search_desc= "short_desc"
			}
			else if(obj.name=="ICD_code")
			{
				tit="ICD Code"
				sql="select DIAG_SRL_NO, short_desc from MR_ICD_CODE";
				search_code="DIAG_SRL_NO";
				search_desc= "short_desc"
			}
			
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}*/
