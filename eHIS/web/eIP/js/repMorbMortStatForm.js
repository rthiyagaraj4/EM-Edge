function reset() {
	f_query_add_mod.document.repMorbMortStat.reset() ;
}

function run()
{
if (f_query_add_mod.document.repMorbMortStat.p_report_type.value=='DBN')
	 {
		run1()
	 }else
	{
		 run2()
	}
}

function run1() 
{	 
	var formOBJ				= f_query_add_mod.document.repMorbMortStat;
	var  p_fr_visit_date	= formOBJ.p_fr_visit_date;
	var  p_to_visit_date = formOBJ.p_to_visit_date;
	var  p_range_id		= formOBJ.p_range_id;

	var discharge_label	= f_query_add_mod.getLabel('Common.Discharge.label','Common');
	var dis_frm_lbl			=	discharge_label+" "+f_query_add_mod.getLabel('Common.month.label','Common')+" "+f_query_add_mod.getLabel('Common.from.label','Common');				
	var dis_to_lbl			=	discharge_label+" "+f_query_add_mod.getLabel('Common.month.label','Common')+" "+f_query_add_mod.getLabel('Common.to.label','Common');	
	var age_range_lbl		=	f_query_add_mod.getLabel('eIP.agerange.label','IP');

	var fields = new Array( p_fr_visit_date,p_to_visit_date,p_range_id );
    var names = new Array(dis_frm_lbl, dis_to_lbl,age_range_lbl);
    if(f_query_add_mod.checkFields( fields, names, messageFrame)){	
		if( f_query_add_mod.doDateChkWithLabel( f_query_add_mod.document.repMorbMortStat.p_fr_visit_date, f_query_add_mod.document.repMorbMortStat.p_to_visit_date, messageFrame,'MY',discharge_label) ){
			f_query_add_mod.document.repMorbMortStat.action="../../eCommon/jsp/report_options.jsp";
			f_query_add_mod.document.repMorbMortStat.target="messageFrame";
			f_query_add_mod.document.repMorbMortStat.submit() ;
		}
	}

}

function run2(){ 

	var formOBJ				= f_query_add_mod.document.repMorbMortStat;
	var  p_fr_visit_date	= formOBJ.p_fr_visit_date;
	var  p_to_visit_date = formOBJ.p_to_visit_date;
	var  p_range_id		= formOBJ.p_range_id;
	var  p_tab_list_fr		= formOBJ.p_tab_list_fr;
	var  p_tab_list_to		= formOBJ.p_tab_list_to;

	var discharge_label	= f_query_add_mod.getLabel('Common.Discharge.label','Common');
	var dis_frm_lbl			=	discharge_label+" "+f_query_add_mod.getLabel('Common.month.label','Common')+" "+f_query_add_mod.getLabel('Common.from.label','Common');				
	var dis_to_lbl			=	discharge_label+" "+f_query_add_mod.getLabel('Common.month.label','Common')+" "+f_query_add_mod.getLabel('Common.to.label','Common');	
	var age_range_lbl		=	f_query_add_mod.getLabel('eIP.agerange.label','IP');
	var tab_list_lbl			=	f_query_add_mod.getLabel('eMR.TabListNo.label','MR');

	var fields = new Array( p_fr_visit_date,p_to_visit_date,p_range_id );
	var names = new Array(dis_frm_lbl, dis_to_lbl,age_range_lbl);
    if(f_query_add_mod.checkFields( fields, names, messageFrame)){	
		if( f_query_add_mod.doDateChkWithLabel( p_fr_visit_date, p_to_visit_date, messageFrame,'MY',discharge_label+" "+f_query_add_mod.getLabel('Common.month.label','Common') ) ){
		if( f_query_add_mod.CheckString(tab_list_lbl, p_tab_list_fr,p_tab_list_to, messageFrame )  ){
				f_query_add_mod.document.repMorbMortStat.action="../../eCommon/jsp/report_options.jsp";
				f_query_add_mod.document.repMorbMortStat.target="messageFrame";
				f_query_add_mod.document.repMorbMortStat.submit() ;
			}
		}
	}

}
function chkWithSysDt(obj){
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


function searchCode(obj,target)
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
			var p_user_name = document.repMorbMortStat.p_user_name.value;
			var p_resp_id = document.repMorbMortStat.p_resp_id.value;
			
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
	}

function changerepIPMrbnMor()
 {
	 if (document.repMorbMortStat.p_report_type.value=='DBN')
	 {	
		 document.repMorbMortStat.p_report_id.value="IPBDTNAT";
		 document.getElementById("MY1").innerHTML="";
		 document.getElementById("MY").innerHTML = "";
		 document.getElementById("MY2").innerHTML = "";
//		 document.getElementById("MY3").innerHTML = "";
	  }
	 else  
	 {		 	
		 document.getElementById("MY1").innerHTML=getLabel('eMR.TabListNo.label','MR');
		 document.getElementById("MY").innerHTML = "<input type='text' name='p_tab_list_fr' id='p_tab_list_fr' id='age_type' maxlength='10' size='10' readonly><input type='button' name='tab_list' id='tab_list' value='?' class='button' onClick=\"document.repMorbMortStat.p_tab_list_fr.select();searchCode(this, p_tab_list_fr)\">";
//		 document.getElementById("MY3").innerHTML="To"
		 document.getElementById("MY2").innerHTML = "<input type='text' name='p_tab_list_to' id='p_tab_list_to' id='age_type' maxlength='10' size='10' readonly><input type='button' name='tab_list' id='tab_list' value='?' class='button' onClick=\"document.repMorbMortStat.p_tab_list_to.select();searchCode(this, p_tab_list_to)\">";
		 if (document.repMorbMortStat.p_report_type.value=='MR')
		 {
			document.repMorbMortStat.p_report_id.value="IPBMRMOT";
		 }
		 else  if (document.repMorbMortStat.p_report_type.value=='MT')
		 {
			document.repMorbMortStat.p_report_id.value="IPBMRMOT";
		 }
		 else  if (document.repMorbMortStat.p_report_type.value=='ECD')
		 {
			document.repMorbMortStat.p_report_id.value="IPBEXCDT";
		 }
	 }
 }

