function reset() {
	f_query_add_mod.document.repOPDAttByEnt.reset() ;
}
function chkWithSysDt(obj)
	{
		if(obj.value!=''){

			if(isBeforeNow(obj.value,"DMY",localeName))
				return true;
			else {
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				obj.select();
				obj.focus();
				return false ;
			}
		}
}
function run() {
			var fields = new Array( f_query_add_mod.document.repOPDAttByEnt.P_fr_visit_date,
			f_query_add_mod.document.repOPDAttByEnt.P_to_visit_date );
			var visit_dt_frm = f_query_add_mod.getLabel('Common.VisitDate.label','Common')+" "+f_query_add_mod.getLabel('Common.from.label','Common');
			var visit_dt_to = f_query_add_mod.getLabel('Common.VisitDate.label','Common')+" "+f_query_add_mod.getLabel('Common.to.label','Common');
			var names = new Array(visit_dt_frm, visit_dt_to);
			var from_date			=	f_query_add_mod.document.repOPDAttByEnt.P_fr_visit_date;
			var to_date				=	f_query_add_mod.document.repOPDAttByEnt.P_to_visit_date;
			var visit_date_lbl		=	f_query_add_mod.getLabel('Common.VisitDate.label','Common');
			if(f_query_add_mod.checkFields( fields, names, messageFrame)){
				if( f_query_add_mod.doDateChkWithLabel( from_date,to_date, messageFrame,'DMY',visit_date_lbl ) ){
				var org_lbl = f_query_add_mod.getLabel('Common.Organization.label','Common');
				if(f_query_add_mod.CheckString( f_query_add_mod.getLabel('Common.VisitDate.label','Common'),f_query_add_mod.document.repOPDAttByEnt.P_fr_visit_date,f_query_add_mod.document.repOPDAttByEnt.P_to_visit_date,messageFrame))     	
				if(f_query_add_mod.CheckString( org_lbl,f_query_add_mod.document.repOPDAttByEnt.p_fr_org_id,f_query_add_mod.document.repOPDAttByEnt.p_to_org_id,messageFrame))  
			    f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
				f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.repOPDAttByEnt.submit() ;
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
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;

		argumentArray[0] = "SELECT FAMILY_ORG_ID CODE,FAMILY_ORG_NAME DESCRIPTION FROM MP_FAMILY_ORG WHERE UPPER(FAMILY_ORG_ID) LIKE UPPER(?) AND UPPER(FAMILY_ORG_NAME) LIKE UPPER(?) ";
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC
		retVal = await CommonLookup(getLabel("Common.Organization.label","Common"), argumentArray );
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
			var p_user_name = document.repOPDAttByEnt.p_user_name.value;
			var p_resp_id = document.repOPDAttByEnt.p_resp_id.value;
			
			//alert(obj.name)
			if(obj.name=="organization")
			{
				tit=getLabel('Common.Organization.label','common');
				sql="select family_org_id, family_org_name from mp_family_org";
				search_code="family_org_id";
				search_desc= "family_org_name"
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