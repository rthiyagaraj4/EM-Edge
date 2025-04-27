function tab_click(objName)
{
	changeTab(objName);
}

var currentTab = new String();
currentTab = "fin_class_tab";
var previousTab = new String();
previousTab = "fin_class_tab";


/*
var currentTab = new String();
currentTab = "fin_dtl_tab";
var previousTab = new String();
previousTab = "fin_dtl_tab";
*/
function changeTab(TabName)
{ 
	var locale = document.forms[0].locale.value;
	var flag = false;
	var  qryStr = "";
	var valid_from ="", valid_to="", last_date="";
	var module_id = document.forms[0].calling_module_id.value;
	var siteSpec=document.forms[0].siteSpec.value;
	var classTypChangeAuthYN		= $("#classTypChangeAuthYN").val(); 
//	alert("Tab To:"+TabName);
//	alert("currentTab:"+currentTab);
    if ((TabName == 'fin_class_tab')  && (currentTab == 'fin_class_tab'))
	{
			document.getElementById("fin_class_tab").className = "tabClicked";
			document.getElementById("FinancialClass").className = "tabSpanclicked";

			document.getElementById("fin_dtl_tab").className = "tabA";
			document.getElementById("FinancialDetails").className = "tabAspan";
	}	
    else if ((TabName == 'fin_dtl_tab')&& (currentTab == 'fin_class_tab'))
	{
    	
//    	alert("parent.frames[1].frames[0]. "+parent.frames[1].frames[0].location);
		parent.frames[1].frames[0].document.forms[0].tabsSwapped.value='Y';
    	
//    	alert("parent.frames[1] >>>> "+parent.frames[1].location);
    	
    	if(siteSpec=='true'){
    		if(module_id == "OP" || module_id == "AE"){
    			if(class_type_prev==class_type){	
    		parent.frames[0].document.forms[0].class_type_prev.value=parent.frames[1].frames[0].document.forms[0].class_type_prev.value;
    		var class_type_prev=parent.frames[0].document.forms[0].class_type_prev.value;
    		var class_type=parent.frames[1].frames[0].document.forms[0].class_type.value;
    		
    		if(class_type_prev==class_type){
    		var class_desc_prev= parent.frames[0].document.forms[0].class_desc_prev.value=parent.frames[1].frames[0].document.forms[0].class_desc_prev.value;
    		var social_pensioner_id_prev= parent.frames[0].document.forms[0].social_pensioner_id_prev.value=parent.frames[1].frames[0].document.forms[0].social_pensioner_id_prev.value;
    		var inc_asset_ind_prev= parent.frames[0].document.forms[0].inc_asset_ind_prev.value=parent.frames[1].frames[0].document.forms[0].inc_asset_ind_prev.value;
    		var ind_inc_prev= parent.frames[0].document.forms[0].ind_inc_prev.value=parent.frames[1].frames[0].document.forms[0].ind_inc_prev.value;
    		var ind_inc_freq_prev= parent.frames[0].document.forms[0].ind_inc_freq_prev.value=parent.frames[1].frames[0].document.forms[0].ind_inc_freq_prev.value;
    		var spouse_inc_prev= parent.frames[0].document.forms[0].spouse_inc_prev.value=parent.frames[1].frames[0].document.forms[0].spouse_inc_prev.value;
    		var spouse_inc_freq_prev= parent.frames[0].document.forms[0].spouse_inc_freq_prev.value=parent.frames[1].frames[0].document.forms[0].spouse_inc_freq_prev.value;	
    		var dependent_inc_prev= parent.frames[0].document.forms[0].dependent_inc_prev.value=parent.frames[1].frames[0].document.forms[0].dependent_inc_prev.value;
    		var dependent_inc_freq_prev= parent.frames[0].document.forms[0].dependent_inc_freq_prev.value=parent.frames[1].frames[0].document.forms[0].dependent_inc_freq_prev.value;
//    		var tot_inc_asset_prev= parent.frames[0].document.forms[0].tot_inc_asset_prev.value=parent.frames[1].frames[0].document.forms[0].tot_inc_asset_prev.value;
    		var no_of_dependants_prev= parent.frames[0].document.forms[0].no_of_dependants_prev.value=parent.frames[1].frames[0].document.forms[0].no_of_dependants_prev.value;
    		var blng_grp_desc_prev= parent.frames[0].document.forms[0].blng_grp_desc_prev.value=parent.frames[1].frames[0].document.forms[0].blng_grp_desc_prev.value;
    		var blng_grp_id_prev= parent.frames[0].document.forms[0].blng_grp_id_prev.value=parent.frames[1].frames[0].document.forms[0].blng_grp_id_prev.value;
    		
    		var class_desc=parent.frames[1].frames[0].document.forms[0].class_desc.value;
    		var social_pensioner_id =parent.frames[1].frames[0].document.forms[0].social_pensioner_id.value;
    		var inc_asset_ind =parent.frames[1].frames[0].document.forms[0].inc_asset_ind.value;
    		var ind_inc =parent.frames[1].frames[0].document.forms[0].ind_inc.value;
    		var ind_inc_freq =parent.frames[1].frames[0].document.forms[0].ind_inc_freq.value;
    		var spouse_inc =parent.frames[1].frames[0].document.forms[0].spouse_inc.value;
    		var spouse_inc_freq =parent.frames[1].frames[0].document.forms[0].spouse_inc_freq.value;	
    		var dependent_inc =parent.frames[1].frames[0].document.forms[0].dependent_inc.value;
    		var dependent_inc_freq =parent.frames[1].frames[0].document.forms[0].dependent_inc_freq.value;
//    		var tot_inc_asset =parent.frames[1].frames[0].document.forms[0].tot_inc_asset.value;
    		var no_of_dependants =parent.frames[1].frames[0].document.forms[0].no_of_dependants.value;
    		var blng_grp_desc =parent.frames[1].frames[0].document.forms[0].blng_grp_desc.value;
    		var blng_grp_id =parent.frames[1].frames[0].document.forms[0].blng_grp_id.value;

    		
//    		alert(" class_desc_prev "+class_desc_prev+"class_desc "+class_desc);
//    		alert(" social_pensioner_id_prev "+social_pensioner_id_prev+"social_pensioner_id "+social_pensioner_id);
//    		alert(" inc_asset_ind_prev "+inc_asset_ind_prev+"inc_asset_ind "+inc_asset_ind);
//    		alert(" ind_inc_prev "+ind_inc_prev+"ind_inc "+ind_inc);
//    		alert(" ind_inc_freq_prev "+ind_inc_freq_prev+"ind_inc_freq "+ind_inc_freq);
//    		alert(" spouse_inc_prev "+spouse_inc_prev+"spouse_inc "+spouse_inc);
//    		alert(" spouse_inc_freq_prev "+spouse_inc_freq_prev+"spouse_inc_freq "+spouse_inc_freq);
//    		alert(" dependent_inc_prev "+dependent_inc_prev+"dependent_inc "+dependent_inc);
//    		alert(" dependent_inc_freq_prev "+dependent_inc_freq_prev+"dependent_inc_freq "+dependent_inc_freq);
//    		alert(" tot_inc_asset_prev "+tot_inc_asset_prev+"tot_inc_asset "+tot_inc_asset);
//    		alert(" no_of_dependants_prev "+no_of_dependants_prev+"no_of_dependants "+no_of_dependants);
//    		alert(" blng_grp_desc_prev "+blng_grp_desc_prev+"blng_grp_desc "+blng_grp_desc);
//    		alert(" blng_grp_id_prev "+blng_grp_id_prev+"blng_grp_id "+blng_grp_id);
//    		
//    		
//    		alert(" bef val"+parent.frames[0].document.forms[0].change_flag.value);
    		
    		if(!(class_type=='EX' || class_type=='SC')){
    			if(!(classTypChangeAuthYN=='Y')){
    		        if(!(class_desc_prev==class_desc)){
    		        	parent.frames[0].document.forms[0].change_flag.value='Y';
    		        }
    		        else if(!(social_pensioner_id_prev==social_pensioner_id)){
    		        	parent.frames[0].document.forms[0].change_flag.value='Y';
    		        }
    		        else if(!(inc_asset_ind_prev==inc_asset_ind)){
    		        	if(!(class_type == 'CR' || class_type == 'SP' || class_type == 'IN')){
    		        		parent.frames[0].document.forms[0].change_flag.value='Y';
    		        	}
    		        }
    		        else if(!(ind_inc_prev==ind_inc)){
    		        	if(!(class_type == 'CR' || class_type == 'SP' || class_type == 'IN')){
    		        		if(!(class_type == 'IA' && inc_asset_ind == 'A')){
    		        			parent.frames[0].document.forms[0].change_flag.value='Y';
    		        		}
    		        	}
    		        }
    		        else if(!(ind_inc_freq_prev==ind_inc_freq)){
    		        	if(!(class_type == 'CR' || class_type == 'SP' || class_type == 'IN')){
    		        	parent.frames[0].document.forms[0].change_flag.value='Y';
    		        	}
    		        }
    		        else if(!(spouse_inc_prev==spouse_inc)){
    		        	if(!(class_type == 'CR' || class_type == 'SP' || class_type == 'IN')){
    		        		if(!(class_type == 'IA' && inc_asset_ind == 'A')){
    		        			parent.frames[0].document.forms[0].change_flag.value='Y';
    		        		}
    		        	}
    		        }
    		        else if(!(spouse_inc_freq_prev==spouse_inc_freq)){
    		        	if(!(class_type == 'CR' || class_type == 'SP' || class_type == 'IN')){
    		        	parent.frames[0].document.forms[0].change_flag.value='Y';
    		        	}
    		        }
    		        else if(!(dependent_inc_prev==dependent_inc)){
    		        	if(!(class_type == 'CR' || class_type == 'SP' || class_type == 'IN')){
    		        		if(!(class_type == 'IA' && inc_asset_ind == 'A')){
    		        			parent.frames[0].document.forms[0].change_flag.value='Y';
    		        		}
    		        	}
    		        }
    		        else if(!(dependent_inc_freq_prev==dependent_inc_freq)){
    		        	if(!(class_type == 'CR' || class_type == 'SP' || class_type == 'IN')){
    		        	parent.frames[0].document.forms[0].change_flag.value='Y';
    		        	}
    		        }
    		        else if(!(no_of_dependants_prev==no_of_dependants)){   
    		        
    		        	if(!(class_type == 'CR' || class_type == 'SP' || class_type == 'IN')){
    		        	  if((no_of_dependants_prev=='' && no_of_dependants== 0) || (no_of_dependants_prev==0 && no_of_dependants=='')) {
    		        		  parent.frames[0].document.forms[0].change_flag.value='N';
    		        	  }
    		        	  else{
    					        parent.frames[0].document.forms[0].change_flag.value='Y'; 
    		        		}
    		        	}
    				    }
    		        else if(!(blng_grp_desc_prev==blng_grp_desc)){
    		        	parent.frames[0].document.forms[0].change_flag.value='Y';
    		        }
    		        else if(!(blng_grp_id_prev==blng_grp_id)){
    		        	parent.frames[0].document.forms[0].change_flag.value='Y';
    		        }
//    		        alert(" aft val"+parent.frames[0].document.forms[0].change_flag.value);
    			}
    		}
    				
    		
    			}
    		}
    		}
    		}
//		if((parent.frames[0].document.forms[0].calling_function_id.value == "CHG_PAT_DTLS") && (parent.frames[0].document.forms[0].modify_flag.value == "N"))
    	/*if((parent.frames[0].document.forms[0].calling_function_id.value != "PAT_REG") && (parent.frames[0].document.forms[0].modify_flag.value == "N"))
		{
			alert(getMessage("BL7115","BL"));
		}
/*
		else if(parent.frames[0].document.forms[0].slmt_ind.value == "")
		{
			alert("Enter patient settlement indicator before proceeding");
//			parent.frames[1].document.forms[0].slmt_ind.focus();
		}
*/
//		else 
    	if(siteSpec=='true'){
			if(module_id == "IP" || module_id == "DC"){
				var encounter_date = parent.frames[1].frames[0].document.forms[0].encounter_date_aft_trunc.value;
				var valid_from = parent.parent.frames[0].document.forms[0].valid_from.value;
				var valid_to = parent.parent.frames[0].document.forms[0].valid_to.value;
				var locale = document.forms[0].locale.value;
    	
				if(valid_from != "" && valid_to != "" )
				{
					//alert("encounter_date / valid_from "+encounter_date+"/"+valid_from+"/"+valid_to);
					if(!isBetween(valid_from,valid_to,encounter_date,'DMY',locale) && parent.parent.frames[0].document.forms[0].value != "MP" )
					{
						alert(getMessage("BL7147","BL")); 
						return false;
					}
    		
				}
			}
		}
    	
		if(parent.frames[0].document.forms[0].blng_grp_id.value == "")
		{
			alert(getMessage("BL9301","BL"));
//			parent.frames[1].document.forms[0].blng_grp_id.focus();

		}
		else if(parent.frames[0].document.forms[0].soc_pensr_id_mand_yn.value=="Y" &&   parent.frames[0].document.forms[0].social_pensioner_id.value=="")
		{
			alert(getMessage("BL7116","BL"));
//			parent.frames[1].document.forms[0].social_pensioner_id.focus();

		}
		else if(parent.frames[0].document.forms[0].inc_asset_mand_YN.value=="Y" &&   parent.frames[0].document.forms[0].inc_asset_ind.Value=="")
		{
			alert(getMessage("BL7117","BL"));
//			parent.frames[1].document.forms[0].inc_asset_ind.focus();

		}
		else if(parent.frames[0].document.forms[0].remarks_mand_YN.value=="Y" &&   parent.frames[0].document.forms[0].remarks.value=="" && parent.frames[0].document.forms[0].calling_module_id.value=="MP")
		{
			alert(getMessage("BL1357","BL"));
//			parent.frames[1].document.forms[0].remarks.focus();
		}
		else if(parent.frames[1].frames[0].document.forms[0].calling_module_id.value != "MP" && parent.frames[1].frames[0].document.forms[0].class_code_valid_YN.value=="N")
		{
			alert(getMessage("BL6454","BL"));
		}
		else
		{ 
			flag = true;
			valid_from = parent.frames[1].frames[0].document.forms[0].valid_from.value;
			valid_to = parent.frames[1].frames[0].document.forms[0].valid_to.value;
			last_date = parent.frames[1].frames[0].document.forms[0].last_date.value;

			if(locale!="en")
			{
				if(valid_from != "")
					valid_from = convertDate(valid_from,"DMY",locale,"en");

				if(valid_to != "")
					valid_to = convertDate(valid_to,"DMY",locale,"en");

				if(last_date != "")
					last_date = convertDate(last_date,"DMY",locale,"en");
			}

			if(valid_from != "" && valid_to != "" )
			{
				var encounter_date = parent.frames[1].frames[0].document.forms[0].encounter_date_aft_trunc.value;

				if(!isBetween(valid_from,valid_to,encounter_date,'DMY',locale) && parent.frames[1].frames[0].document.forms[0].calling_module_id.value != "MP" )
				{
					alert(getMessage("BL7147","BL"));//BL7127
					flag = false;
				}
				else
				{
					flag = true;
				}
			}
				
			if(flag)
			{
				parent.frames[0].document.forms[0].valid_from.value =  valid_from;
				parent.frames[0].document.forms[0].valid_to.value =  valid_to;
				parent.frames[0].document.forms[0].last_date.value =  last_date;
				
				var class_val_load_success_YN = load_class_values();
	//				alert("class_val_load_success_YN:"+class_val_load_success_YN);
				if(class_val_load_success_YN != "")
				{
					qryStr="fin_class_flag_YN=N&autoFinChk=Y&class_blng_grp_id="+parent.frames[0].document.forms[0].blng_grp_id.value+"&class_code="+parent.frames[0].document.forms[0].class_code.value+"&class_type="+parent.frames[0].document.forms[0].class_type.value+"&called_locn=Class_Tab&calling_module_id="+parent.frames[0].document.forms[0].calling_module_id.value;
					qryStr = qryStr + "&billing_mode=Modify&operation=Update&isUserAuthorizedClass="+parent.frames[1].frames[0].document.forms[0].isUsedAuthorized.value;
		/*			
					qryStr = qryStr + "&slmt_ind="+parent.frames[0].document.forms[0].slmt_ind.value+"&remarks="+parent.frames[0].document.forms[0].remarks.value+"&inc_asset_ind="+parent.frames[0].document.forms[0].inc_asset_ind.value+"&tot_inc_asset="+parent.frames[0].document.forms[0].tot_inc_asset.value+"&no_of_dependants="+parent.frames[0].document.forms[0].no_of_dependants.value+"&blng_grp_id="+parent.frames[0].document.forms[0].blng_grp_id.value+"&blng_grp_desc="+parent.frames[0].document.forms[0].blng_grp_desc.value;
		*/			
					qryStr = qryStr+"&"+parent.frames[0].document.forms[0].params.value;
//					qryStr = qryStr + "&package_flag=N&ins_auth_flag=N&upd_pat_flag=N&show_hide_blng_class=SHOW&nationality_yn=Y&bl_data_from_repos_yn=N";
		//			alert(qryStr);
		//			document.getElementById("fin_dtl_tab").src = '../../eBL/images/fin_Dtls_Clas_W.bmp';
		//	        document.getElementById("fin_class_tab").src = '../../eBL/images/fin_Claa_G.bmp';

					document.getElementById("fin_class_tab").className = "tabA";
					document.getElementById("FinancialClass").className = "tabAspan";

					document.getElementById("fin_dtl_tab").className = "tabClicked";
					document.getElementById("FinancialDetails").className = "tabSpanclicked";
					parent.frames[1].location.href='../../eBL/jsp/AddModifyPatFinDetailsMain.jsp?'+qryStr;
				}
				else
				{
//					alert(class_val_load_success_YN);
				}
			}
		}
	}
	else if ((TabName == 'fin_class_tab')&& (currentTab == 'fin_dtl_tab'))
	{	
		var isUserAuthorizedClass = parent.frames[1].frames[0].document.forms[0].isUserAuthorizedClass.value;
		flag = true;
		valid_from = parent.parent.frames[0].document.forms[0].valid_from.value;
		valid_to = parent.parent.frames[0].document.forms[0].valid_to.value;
		last_date = parent.parent.frames[0].document.forms[0].last_date.value;

		if(locale!="en")
		{
			if(valid_from != "")
				valid_from = convertDate(valid_from,"DMY",locale,"en");

			if(valid_to != "")
				valid_to = convertDate(valid_to,"DMY",locale,"en");

			if(last_date != "")
				last_date = convertDate(last_date,"DMY",locale,"en");
		}
		qryStr="fin_class_flag_YN=Y&fin_dtl_call=Y&calling_module_id="+parent.frames[0].document.forms[0].calling_module_id.value+"&calling_function_id="+parent.frames[0].document.forms[0].calling_function_id.value;
		qryStr = qryStr + "&billing_mode=Modify&operation=Update&upd_class_dtls_YN="+isUserAuthorizedClass;
		qryStr = qryStr + "&slmt_ind="+parent.parent.frames[0].document.forms[0].slmt_ind.value+"&class_type="+parent.parent.frames[0].document.forms[0].class_type.value+"&class_code="+parent.parent.frames[0].document.forms[0].class_code.value+"&remarks="+encodeURIComponent(parent.parent.frames[0].document.forms[0].remarks.value)+"&social_pensioner_id="+encodeURIComponent(parent.parent.frames[0].document.forms[0].social_pensioner_id.value)+"&inc_asset_ind="+parent.parent.frames[0].document.forms[0].inc_asset_ind.value+"&ind_inc="+parent.parent.frames[0].document.forms[0].ind_inc.value+"&ind_inc_freq="+parent.parent.frames[0].document.forms[0].ind_inc_freq.value+"&spouse_inc="+parent.parent.frames[0].document.forms[0].spouse_inc.value+"&spouse_inc_freq="+parent.parent.frames[0].document.forms[0].spouse_inc_freq.value+"&dependent_inc="+parent.parent.frames[0].document.forms[0].dependent_inc.value+"&dependent_inc_freq="+parent.parent.frames[0].document.forms[0].dependent_inc_freq.value+"&tot_inc_asset="+parent.parent.frames[0].document.forms[0].tot_inc_asset.value+"&no_of_dependants="+parent.parent.frames[0].document.forms[0].no_of_dependants.value+"&blng_grp_id="+parent.parent.frames[0].document.forms[0].blng_grp_id.value+"&valid_from="+valid_from+"&valid_to="+valid_to+"&facilityId="+parent.parent.frames[0].document.forms[0].facilityId.value+"&sex="+parent.parent.frames[0].document.forms[0].sex.value+"&last_date="+last_date+"&"+parent.parent.frames[0].document.forms[0].params.value;
		//alert(qryStr);
//		document.getElementById("fin_dtl_tab").src = '../../eBL/images/fin_Dtls_Clas_G.bmp';
  //      document.getElementById("fin_class_tab").src = '../../eBL/images/fin_Claa_W.bmp';
			document.getElementById("fin_class_tab").className = "tabClicked";
			document.getElementById("FinancialClass").className = "tabSpanclicked";

			document.getElementById("fin_dtl_tab").className = "tabA";
			document.getElementById("FinancialDetails").className = "tabAspan";
		parent.frames[1].location.href='../../eBL/jsp/AddModifyPatFinClassDetailsMain.jsp?'+qryStr;
	}
 
// FINALY SET THE CURRENT TAB TO THE PASSED PARAMETER
	if(flag)
	{
		if (TabName == currentTab)
			previousTab = 'fin_dtl_tab';
		else
			previousTab = currentTab;
		currentTab = TabName;
	}
}

function encDateCheck(encounter_date){	
//	alert(" encDateCheck ");
	valid_from = parent.parent.frames[0].document.forms[0].valid_from.value;
	valid_to = parent.parent.frames[0].document.forms[0].valid_to.value;
	var locale = document.forms[0].locale.value;
	
	if(valid_from != "" && valid_to != "" )
	{
//		alert("encounter_date "+encounter_date);
		if(!isBetween(valid_from,valid_to,encounter_date,'DMY',locale) && parent.parent.frames[0].document.forms[0].value != "MP" )
		{
			alert(getMessage("BL7147","BL"));
			disableItems();			
		}
		
	}
}

function load_class_values()
{
	var locale = parent.frames[0].document.forms[0].locale.value;
	var slmt_ind= parent.frames[0].document.forms[0].slmt_ind.value;
	var remarks=parent.frames[0].document.forms[0].remarks.value;
	var no_of_dependants=parent.frames[0].document.forms[0].no_of_dependants.value;
	var blng_grp_id=parent.frames[0].document.forms[0].blng_grp_id.value;

	var class_code = parent.frames[0].document.forms[0].class_code.value;
	var class_type = parent.frames[0].document.forms[0].class_type.value;
	var inc_asset_ind = parent.frames[0].document.forms[0].inc_asset_ind.value;
	var ind_inc = parent.frames[0].document.forms[0].ind_inc.value;
	var ind_inc_freq = parent.frames[0].document.forms[0].ind_inc_freq.value;
	var spouse_inc = parent.frames[0].document.forms[0].spouse_inc.value;
	var spouse_inc_freq = parent.frames[0].document.forms[0].spouse_inc_freq.value;
	var dependent_inc = parent.frames[0].document.forms[0].dependent_inc.value;
	var dependent_inc_freq = parent.frames[0].document.forms[0].dependent_inc_freq.value;
	var tot_inc_asset=parent.frames[0].document.forms[0].tot_inc_asset.value;
	var valid_from = parent.frames[0].document.forms[0].valid_from.value;
	var valid_to = parent.frames[0].document.forms[0].valid_to.value;
	var last_date = parent.frames[0].document.forms[0].last_date.value;
	var social_pensioner_id = parent.frames[0].document.forms[0].social_pensioner_id.value;
	var blng_grp_changed_YN = parent.frames[0].document.forms[0].blng_grp_changed_YN.value;
/*
	if(locale != "en")
	{
		if(valid_from != "")
			valid_from = convertDate(valid_from,"DMY",locale,"en");
		if(valid_to != "")
			valid_to = convertDate(valid_to,"DMY",locale,"en");
		if(last_date != "")
			last_date = convertDate(last_date,"DMY",locale,"en");
	}
*/
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	
	var param="called_for_reclass=Y&called_from=CLASS_DET_LOAD&slmt_ind="+slmt_ind+"&remarks="+remarks+"&inc_asset_ind="+inc_asset_ind+"&tot_inc_asset="+tot_inc_asset+"&no_of_dependants="+no_of_dependants+"&blng_grp_id="+blng_grp_id+"&class_code="+class_code+"&class_type="+class_type+"&ind_inc="+ind_inc+"&ind_inc_freq="+ind_inc_freq+"&spouse_inc="+spouse_inc+"&spouse_inc_freq="+spouse_inc_freq+"&dependent_inc="+dependent_inc+"&dependent_inc_freq="+dependent_inc_freq+"&valid_from="+valid_from+"&valid_to="+valid_to+"&last_date="+last_date+"&social_pensioner_id="+social_pensioner_id+"&blng_grp_changed_YN="+blng_grp_changed_YN;

	var temp_jsp="../../eBL/jsp/BLFinDetHiddenFlds.jsp?"+param;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=trimString(xmlHttp.responseText);
//alert(responseText);
	if(responseText!="")
	{
		return responseText;
	}	
}

//Common initialization
function initCommon(class_type,classTypeChange)
{
	var module_id = document.forms[0].calling_module_id.value;
	var function_id = document.forms[0].calling_function_id.value;
	var fin_class_dtls_updated_YN = document.forms[0].fin_class_dtls_updated_YN.value;
	var siteSpec=document.forms[0].siteSpec.value;
	var class_type_prev=document.forms[0].class_type_prev.value;
	//alert("siteSpec "+siteSpec);

	if(siteSpec=='true'){
		if(module_id == "OP" || module_id == "AE"){
			if(classTypeChange=='Y'){
				document.forms[0].tot_inc_asset.value='';
			}
			
		}
		
	}

	if(! class_type == "")
	{
		if(class_type == "SG")
		{
			document.forms[0].class_type.selectedIndex = 1;
			document.forms[0].class_code_btn.disabled = false;
			if(function_id == 'PAT_REG' || function_id == 'CHG_PAT_DTLS')
			{
				document.forms[0].valid_to.value = document.forms[0].last_date.value;
			}
			document.getElementById("valid_to_cal").style.visibility = "hidden";
			
			if(module_id =='MP')
				document.forms[0].remarks_mand_yn.style.visibility = "hidden";

			document.forms[0].social_pensioner_id.readOnly = false;
			document.forms[0].soc_pensr_id_mand_yn.style.visibility = "visible";
			document.forms[0].inc_asset_mand_yn.style.visibility = "hidden";
			parent.parent.frames[0].document.forms[0].soc_pensr_id_mand_yn.value = "Y";
			parent.parent.frames[0].document.forms[0].inc_asset_mand_YN.value = "N";
			parent.parent.frames[0].document.forms[0].remarks_mand_YN.value = "N"; 
//				alert("bye...........");

		}
		else if(class_type == "PV")
		{
			var locale = document.forms[0].locale.value;
			var boolSecurity = document.forms[0].boolSecurity.value; //Added by Subha/GDOH-SCF-0289/V19072018
			document.forms[0].inc_asset_mand_yn.style.visibility = "hidden";
			var valid_to_for_prov_class = document.forms[0].valid_to_for_prov_class.value;
			valid_to_for_prov_class = convertDate(valid_to_for_prov_class,"DMY","en",locale);

			document.forms[0].class_type.selectedIndex = 2;
			if(module_id == "MP")
			{
				document.forms[0].remarks_mand_yn.style.visibility = "visible";
				parent.parent.frames[0].document.forms[0].remarks_mand_YN.value = "Y"; 
			}
			else
			{
				parent.parent.frames[0].document.forms[0].remarks_mand_YN.value = "N"; 
			}
			document.forms[0].blng_grp_btn.disabled = false;
			document.forms[0].social_pensioner_id.value="";
			document.forms[0].soc_pensr_id_mand_yn.style.visibility = "hidden";
			document.forms[0].social_pensioner_id.readOnly = true;
			//if(function_id == 'PAT_REG' || function_id == 'CHG_PAT_DTLS') //Commented by Subha/GDOH-SCF-0289/V19072018
			if(function_id == 'PAT_REG' && (boolSecurity == 'false' || boolSecurity == false) || function_id == 'CHG_PAT_DTLS') //Added by Subha/GDOH-SCF-0289/V19072018
			{
				document.forms[0].valid_to.value = valid_to_for_prov_class;
			}
			document.getElementById("valid_to_cal").style.visibility = "hidden";
			document.forms[0].inc_asset_mand_yn.style.visibility = "hidden";

			parent.parent.frames[0].document.forms[0].soc_pensr_id_mand_yn.value = "N"; 
			parent.parent.frames[0].document.forms[0].inc_asset_mand_YN.value = "N"; 
			
			if(siteSpec=='true'){
				if((module_id=="OP" || module_id=="AE")){
					if(!(class_type_prev=='SG')){					
						document.forms[0].social_pensioner_id_prev.value=document.forms[0].social_pensioner_id.value;
					}
					
				}
			}
			
			
		}
		else if(class_type == "IA")
		{
			document.forms[0].class_type.selectedIndex = 3;
			document.forms[0].inc_asset_mand_yn.style.visibility = "visible";
			document.forms[0].blng_grp_id.readOnly = true;
			if(function_id == 'PAT_REG' || function_id == 'CHG_PAT_DTLS')
			{
				document.forms[0].valid_to.value = document.forms[0].last_date.value;
			}
			document.getElementById("valid_to_cal").style.visibility = "hidden";
			if(module_id =='MP')
				document.forms[0].remarks_mand_yn.style.visibility = "hidden";
			document.forms[0].social_pensioner_id.value="";
			document.forms[0].soc_pensr_id_mand_yn.style.visibility = "hidden";
			document.forms[0].social_pensioner_id.readOnly = true;
			parent.parent.frames[0].document.forms[0].inc_asset_mand_YN.value = "Y"; 
			parent.parent.frames[0].document.forms[0].soc_pensr_id_mand_yn.value = "N";
			parent.parent.frames[0].document.forms[0].remarks_mand_YN.value = "N";

			if(siteSpec=='true'){
				if(module_id == "IP" || module_id == "DC" || module_id == "OP" || module_id == "AE"){
//				alert("if....");
				document.forms[0].class_desc.enabled=true;
				document.forms[0].class_code_btn.enabled=true;
				document.forms[0].inc_asset_ind.enabled=true;
				document.forms[0].ind_inc.enabled=true;
				document.forms[0].ind_inc_freq.enabled=true;
				document.forms[0].spouse_inc.enabled=true;
				document.forms[0].spouse_inc_freq.enabled=true;
				document.forms[0].dependent_inc.enabled=true;
				document.forms[0].dependent_inc_freq.enabled=true;
				document.forms[0].tot_inc_asset.enabled=true;
				document.forms[0].no_of_dependants.enabled = true;				
				document.forms[0].blng_grp_desc.enabled = true;
				document.forms[0].blng_grp_btn.enabled = true;
				
				}
				else if((module_id != "MP"))
				{
//					alert("else if....");
					document.forms[0].class_desc.disabled=true;
					document.forms[0].class_code_btn.disabled=true;
					document.forms[0].inc_asset_ind.disabled=true;
					document.forms[0].ind_inc.disabled=true;
					document.forms[0].ind_inc_freq.disabled=true;
					document.forms[0].spouse_inc.disabled=true;
					document.forms[0].spouse_inc_freq.disabled=true;
					document.forms[0].dependent_inc.disabled=true;
					document.forms[0].dependent_inc_freq.disabled=true;
					document.forms[0].tot_inc_asset.disabled=true;
					document.forms[0].no_of_dependants.disabled = true;				
					document.forms[0].blng_grp_desc.disabled = true;
					document.forms[0].blng_grp_btn.disabled = true;
				}
			}
			else if((module_id != "MP"))
			{
//				alert("else if....");
				document.forms[0].class_desc.disabled=true;
				document.forms[0].class_code_btn.disabled=true;
				document.forms[0].inc_asset_ind.disabled=true;
				document.forms[0].ind_inc.disabled=true;
				document.forms[0].ind_inc_freq.disabled=true;
				document.forms[0].spouse_inc.disabled=true;
				document.forms[0].spouse_inc_freq.disabled=true;
				document.forms[0].dependent_inc.disabled=true;
				document.forms[0].dependent_inc_freq.disabled=true;
				document.forms[0].tot_inc_asset.disabled=true;
				document.forms[0].no_of_dependants.disabled = true;				
				document.forms[0].blng_grp_desc.disabled = true;
				document.forms[0].blng_grp_btn.disabled = true;
			}
			
			if(siteSpec=='true'){
				if((module_id=="OP" || module_id=="AE")){
					if(!(class_type_prev=='SG')){
						document.forms[0].social_pensioner_id_prev.value=document.forms[0].social_pensioner_id.value;
					}
					
				}
			}
			
		}
		else if(class_type == "VS")
		{
			document.forms[0].class_type.selectedIndex = 4;
			document.forms[0].inc_asset_mand_yn.style.visibility = "hidden";
			if(module_id =='MP')
				document.forms[0].remarks_mand_yn.style.visibility = "hidden";
			document.forms[0].social_pensioner_id.value="";
			document.forms[0].soc_pensr_id_mand_yn.style.visibility = "hidden";
			document.forms[0].social_pensioner_id.readOnly = true;
			if(module_id =='MP')
				document.forms[0].remarks_mand_yn.style.visibility = "hidden";
			document.forms[0].blng_grp_btn.disabled = false;
			if(function_id == 'PAT_REG' || function_id == 'CHG_PAT_DTLS')
			{
				document.forms[0].valid_to.value = document.forms[0].last_date.value;
			}
			document.getElementById("valid_to_cal").style.visibility = "hidden";
			parent.parent.frames[0].document.forms[0].inc_asset_mand_YN.value = "N"; 
			parent.parent.frames[0].document.forms[0].soc_pensr_id_mand_yn.value = "N";
			parent.parent.frames[0].document.forms[0].remarks_mand_YN.value = "N";
			
			if(siteSpec=='true'){
				if((module_id=="OP" || module_id=="AE")){
					if(!(class_type_prev=='SG')){
						document.forms[0].social_pensioner_id_prev.value=document.forms[0].social_pensioner_id.value;	
					}
					
				}
			}
			
		}
		else if(class_type == "CR")
		{
			document.forms[0].class_type.selectedIndex = 5;
			document.forms[0].inc_asset_mand_yn.style.visibility = "hidden";
			document.forms[0].social_pensioner_id.value="";
			document.forms[0].soc_pensr_id_mand_yn.style.visibility = "hidden";
			document.forms[0].social_pensioner_id.readOnly = true;
			if(module_id =='MP')
				document.forms[0].remarks_mand_yn.style.visibility = "hidden";
			if(function_id == 'PAT_REG' || function_id == 'CHG_PAT_DTLS')
			{
				document.forms[0].valid_to.value = document.forms[0].last_date.value;
			}
			document.getElementById("valid_to_cal").style.visibility = "hidden";
			document.forms[0].inc_asset_ind.value = "";
			document.forms[0].ind_inc.value = "";
			document.forms[0].ind_inc_freq.value = "";
			document.forms[0].spouse_inc.value = "";
			document.forms[0].spouse_inc_freq.value = "";
			document.forms[0].dependent_inc.value = "";
			document.forms[0].dependent_inc_freq.value = "";
			document.forms[0].no_of_dependants.value = "";

			parent.parent.frames[0].document.forms[0].inc_asset_mand_YN.value = "N"; 
			parent.parent.frames[0].document.forms[0].soc_pensr_id_mand_yn.value = "N";
			parent.parent.frames[0].document.forms[0].remarks_mand_YN.value = "N";

			parent.parent.frames[0].document.forms[0].inc_asset_ind.value = "";
			parent.parent.frames[0].document.forms[0].ind_inc.value = "";
			parent.parent.frames[0].document.forms[0].ind_inc_freq.value = "";
			parent.parent.frames[0].document.forms[0].spouse_inc.value = "";
			parent.parent.frames[0].document.forms[0].spouse_inc_freq.value = "";
			parent.parent.frames[0].document.forms[0].dependent_inc.value = "";
			parent.parent.frames[0].document.forms[0].dependent_inc_freq.value = "";
			parent.parent.frames[0].document.forms[0].no_of_dependants.value = "";
			
			if(siteSpec=='true'){
				if((module_id=="OP" || module_id=="AE")){
					document.forms[0].ind_inc.value=0;
					document.forms[0].spouse_inc.value = 0;
					document.forms[0].dependent_inc.value = 0;
					document.forms[0].no_of_dependants.value = 0;	
					document.forms[0].tot_inc_asset.value = 0;
					put_decimal(document.forms[0].ind_inc,document.forms[0].noofdecimal.value);
					put_decimal(document.forms[0].spouse_inc,document.forms[0].noofdecimal.value);
					put_decimal(document.forms[0].dependent_inc,document.forms[0].noofdecimal.value);	
					put_decimal(document.forms[0].tot_inc_asset,document.forms[0].noofdecimal.value);
					
				}
			}
			
		}
		else if(class_type == "SP")
		{
			document.forms[0].class_type.selectedIndex = 6;
			document.forms[0].inc_asset_mand_yn.style.visibility = "hidden";
			document.forms[0].social_pensioner_id.value="";
			document.forms[0].soc_pensr_id_mand_yn.style.visibility = "hidden";
			document.forms[0].social_pensioner_id.readOnly = true;
			if(module_id =='MP')
				document.forms[0].remarks_mand_yn.style.visibility = "hidden";
			document.forms[0].inc_asset_ind.value = "";
			document.forms[0].ind_inc.value = "";
			document.forms[0].ind_inc_freq.value = "";
			document.forms[0].spouse_inc.value = "";
			document.forms[0].spouse_inc_freq.value = "";
			document.forms[0].dependent_inc.value = "";
			document.forms[0].dependent_inc_freq.value = "";
			document.forms[0].no_of_dependants.value = "";
			if(function_id == 'PAT_REG' || function_id == 'CHG_PAT_DTLS')
			{
				document.forms[0].valid_to.value = document.forms[0].last_date.value;
			}	
			document.getElementById("valid_to_cal").style.visibility = "hidden";			
			parent.parent.frames[0].document.forms[0].inc_asset_mand_YN.value = "N"; 
			parent.parent.frames[0].document.forms[0].soc_pensr_id_mand_yn.value = "N";
			parent.parent.frames[0].document.forms[0].remarks_mand_YN.value = "N";

			parent.parent.frames[0].document.forms[0].inc_asset_ind.value = "";
			parent.parent.frames[0].document.forms[0].ind_inc.value = "";
			parent.parent.frames[0].document.forms[0].ind_inc_freq.value = "";
			parent.parent.frames[0].document.forms[0].spouse_inc.value = "";
			parent.parent.frames[0].document.forms[0].spouse_inc_freq.value = "";
			parent.parent.frames[0].document.forms[0].dependent_inc.value = "";
			parent.parent.frames[0].document.forms[0].dependent_inc_freq.value = "";
			parent.parent.frames[0].document.forms[0].no_of_dependants.value = "";
			
			if(siteSpec=='true'){
				if((module_id=="OP" || module_id=="AE")){
					document.forms[0].ind_inc.value=0;
					document.forms[0].spouse_inc.value = 0;
					document.forms[0].dependent_inc.value = 0;
					document.forms[0].no_of_dependants.value = 0;	
					document.forms[0].tot_inc_asset.value = 0;
					put_decimal(document.forms[0].ind_inc,document.forms[0].noofdecimal.value);
					put_decimal(document.forms[0].spouse_inc,document.forms[0].noofdecimal.value);
					put_decimal(document.forms[0].dependent_inc,document.forms[0].noofdecimal.value);	
					put_decimal(document.forms[0].tot_inc_asset,document.forms[0].noofdecimal.value);
					
				}
			}
			
		}
		else if(class_type == "IN")
		{
			document.forms[0].class_type.selectedIndex = 7;
			document.forms[0].inc_asset_mand_yn.style.visibility = "hidden";
			document.forms[0].social_pensioner_id.value="";
			document.forms[0].soc_pensr_id_mand_yn.style.visibility = "hidden";
			document.forms[0].social_pensioner_id.readOnly = true;
			if(module_id =='MP')
				document.forms[0].remarks_mand_yn.style.visibility = "hidden";
			document.forms[0].inc_asset_ind.value = "";
			document.forms[0].ind_inc.value = "";
			document.forms[0].ind_inc_freq.value = "";
			document.forms[0].spouse_inc.value = "";
			document.forms[0].spouse_inc_freq.value = "";
			document.forms[0].dependent_inc.value = "";
			document.forms[0].dependent_inc_freq.value = "";
			document.forms[0].no_of_dependants.value = "";
			if(function_id == 'PAT_REG' || function_id == 'CHG_PAT_DTLS')
			{
				document.forms[0].valid_to.value = document.forms[0].last_date.value;
			}
			document.getElementById("valid_to_cal").style.visibility = "hidden";
			parent.parent.frames[0].document.forms[0].inc_asset_mand_YN.value = "N"; 
			parent.parent.frames[0].document.forms[0].soc_pensr_id_mand_yn.value = "N";
			parent.parent.frames[0].document.forms[0].remarks_mand_YN.value = "N";

			parent.parent.frames[0].document.forms[0].inc_asset_ind.value = "";
			parent.parent.frames[0].document.forms[0].ind_inc.value = "";
			parent.parent.frames[0].document.forms[0].ind_inc_freq.value = "";
			parent.parent.frames[0].document.forms[0].spouse_inc.value = "";
			parent.parent.frames[0].document.forms[0].spouse_inc_freq.value = "";
			parent.parent.frames[0].document.forms[0].dependent_inc.value = "";
			parent.parent.frames[0].document.forms[0].dependent_inc_freq.value = "";
			parent.parent.frames[0].document.forms[0].no_of_dependants.value = "";
			
			if(siteSpec=='true'){
				if((module_id=="OP" || module_id=="AE")){
					document.forms[0].ind_inc.value=0;
					document.forms[0].spouse_inc.value = 0;
					document.forms[0].dependent_inc.value = 0;
					document.forms[0].no_of_dependants.value = 0;	
					document.forms[0].tot_inc_asset.value = 0;
					put_decimal(document.forms[0].ind_inc,document.forms[0].noofdecimal.value);
					put_decimal(document.forms[0].spouse_inc,document.forms[0].noofdecimal.value);
					put_decimal(document.forms[0].dependent_inc,document.forms[0].noofdecimal.value);	
					put_decimal(document.forms[0].tot_inc_asset,document.forms[0].noofdecimal.value);
					
				}
			}
			
		}
		else if(class_type == "EX")
		{
			document.forms[0].class_type.selectedIndex = 8;
			document.forms[0].inc_asset_mand_yn.style.visibility = "hidden";
			document.forms[0].social_pensioner_id.value="";
			document.forms[0].soc_pensr_id_mand_yn.style.visibility = "hidden";
			document.forms[0].social_pensioner_id.readOnly = true;
			if(module_id =='MP')
				document.forms[0].remarks_mand_yn.style.visibility = "hidden";
			if(function_id == 'PAT_REG' || function_id == 'CHG_PAT_DTLS')
			{
				document.forms[0].valid_to.value = document.forms[0].last_date.value;
			}
			document.getElementById("valid_to_cal").style.visibility = "hidden";
			parent.parent.frames[0].document.forms[0].inc_asset_mand_YN.value = "N"; 
			parent.parent.frames[0].document.forms[0].soc_pensr_id_mand_yn.value = "N";
			parent.parent.frames[0].document.forms[0].remarks_mand_YN.value = "N";
			
			if(siteSpec=='true'){
				if((module_id=="OP" || module_id=="AE")){
					if(!(class_type_prev=='SG')){
						document.forms[0].social_pensioner_id_prev.value=document.forms[0].social_pensioner_id.value;
					}
					
				}
			}
		}
		else if(class_type == "SC")
		{
			document.forms[0].class_type.selectedIndex = 9;
			document.forms[0].inc_asset_mand_yn.style.visibility = "hidden";
			if(module_id =='MP')
				document.forms[0].remarks_mand_yn.style.visibility = "hidden";
			document.forms[0].social_pensioner_id.value="";
			document.forms[0].soc_pensr_id_mand_yn.style.visibility = "hidden";
			document.forms[0].social_pensioner_id.readOnly = true;
			document.forms[0].blng_grp_btn.disabled = false;
			if(function_id == 'PAT_REG' || function_id == 'CHG_PAT_DTLS')
			{
				document.forms[0].valid_to.value = document.forms[0].last_date.value;
			}
			document.getElementById("valid_to_cal").style.visibility = "hidden";
			parent.parent.frames[0].document.forms[0].inc_asset_mand_YN.value = "N"; 
			parent.parent.frames[0].document.forms[0].soc_pensr_id_mand_yn.value = "N";
			parent.parent.frames[0].document.forms[0].remarks_mand_YN.value = "N";
			if(siteSpec=='true'){
				if((module_id=="OP" || module_id=="AE")){
					if(!(class_type_prev=='SG')){
						document.forms[0].social_pensioner_id_prev.value=document.forms[0].social_pensioner_id.value;
					}
					
				}
			}
		}	
		
		
		
			if(siteSpec=='true'){
				if((module_id=="OP" || module_id=="AE")){
					if(classTypeChange=='Y'){
						//alert("class change");
					document.forms[0].ind_inc_freq.value="";
					document.forms[0].spouse_inc_freq.value="";
					document.forms[0].dependent_inc_freq.value="";
					document.forms[0].ind_inc.value="";
					document.forms[0].spouse_inc.value="";
					document.forms[0].dependent_inc.value="";
					document.forms[0].no_of_dependants.value="";
					document.forms[0].inc_asset_ind.value = "";
				}
			
			}
		}
	}
	else
	{
		return true;
	}

}

function class_type_change(obj)
{
//	alert("class_type_change "+document.forms[0].class_type_selectd.value);
	
	existingClassType=document.forms[0].class_type_selectd.value;
	NewClassType=obj.value;
	var module_id = document.forms[0].calling_module_id.value;	
	var siteSpec=document.forms[0].siteSpec.value;	
	var auth;
	
	 if(siteSpec=='true'){
		 if(module_id == "OP" || module_id == "AE"){

		  var patientId 				= $("#patientId").val(); 
		  var prevPatId 				= $("#prevPatId").val(); 
		  var changePatAuthYN 			= $("#changePatAuthYN").val(); 	
		  var called_from				='getSessionVal';	
		  var classTypChangeAuthYN		=$("#classTypChangeAuthYN").val(); 
		  var classTypChangeAuthYnPatId	=''; 
		  var class_type_prev			=$("#class_type_prev").val(); 
		  
		//  alert("class_type_change patientId "+patientId+" prevPatId "+prevPatId);
	
//		$.ajax({
//		
//			type:'POST',
//			url:"../jsp/AddModPatFinClassChangeAuthAjax.jsp?classTypChangeAuthYN="+classTypChangeAuthYN+"&patientId="+patientId+"&called_from="+called_from+"&prevPatId="+prevPatId,
//			async:false,
//			dataType:"json",
//			success : function(data){
//				alert("data"+data);
//				if(data != null)
//				classTypChangeAuthYnPatId=data.classTypChangeAuthYnPatId;
//			},
//
//			error: function(data){
//			}
//		});
	
//		alert("class_type_change classTypChangeAuthYN "+classTypChangeAuthYN+"/ classTypChangeAuthYnPatId"+classTypChangeAuthYnPatId+" patientId "+patientId+" prevPatId "+prevPatId);

			if(!(NewClassType=='EX' || NewClassType=='SC')){
				if(!(patientId == prevPatId) && (prevPatId != '' )){
					//alert("iffffffffffffff ");
					if((classTypChangeAuthYN == 'Y' && !(changePatAuthYN == 'Y'))){
						auth=authUser(obj);
						
					}
				}
				else if(!(patientId == prevPatId) && (prevPatId == '' )){
					//alert("else");
						if(!(classTypChangeAuthYN == 'Y')){
							auth=authUser(obj);
							
					 }
				}			
			
				if(auth=='Y'){
					var classTypChangeAuthYN='Y';
					called_from='authUser';
					$.ajax({
						
						type:'POST',
						url:"../jsp/AddModPatFinClassChangeAuthAjax.jsp?classTypChangeAuthYN="+classTypChangeAuthYN+"&patientId="+patientId+"&called_from="+called_from+"&prevPatId="+prevPatId,
						async:false,
						dataType:"json",
						success : function(data){
						},
						error: function(data){
						}
					});
					
				}
			}
		 }
	 }
//	alert("auth "+auth);
	if(document.forms[0].calling_module_id.value != "MP" && document.forms[0].calling_module_id.value != "IP" && document.forms[0].calling_module_id.value != "DC")
	{
		var mod_id=document.forms[0].calling_module_id.value;
	  
		  if(document.forms[0].class_type_selectd.value != "PV" && document.forms[0].class_type.value == "PV")
		  	{
			alert(getMessage("BL7128","BL"));
			document.forms[0].class_type.value = document.forms[0].class_type_selectd.value ;
			return false;
		  	}
		 
	}
	else if(document.forms[0].calling_module_id.value == "MP")
	{
		if(document.forms[0].class_type_selectd.value != "" && document.forms[0].class_type_selectd.value != "PV" && document.forms[0].class_type.value == "PV")
		{
			alert(getMessage("BL7128","BL"));
			document.forms[0].class_type.value = document.forms[0].class_type_selectd.value ;
			return false;
		}
	}

	document.forms[0].class_code.value = "";
	document.forms[0].class_desc.value = "";
	document.forms[0].blng_grp_id.value = "";
	document.forms[0].blng_grp_desc.value = "";
	document.forms[0].blng_grp_desc.disabled = false;
	document.forms[0].blng_grp_btn.disabled = false;
	parent.parent.frames[0].document.forms[0].class_code.value = "";
	parent.parent.frames[0].document.forms[0].class_desc.value = "";
	parent.parent.frames[0].document.forms[0].blng_grp_id.value = "";
	parent.parent.frames[0].document.forms[0].blng_grp_desc.value = "";

	
	var classTypChange='Y';
	initCommon(obj.value,classTypChange);
//	alert("initCommon class_type_change hereeeeeeeeee111111111");
	var calling_module_id = document.forms[0].calling_module_id.value;

	if(calling_module_id != "MP")
	{
	 if(siteSpec=='true'){
		if( !(calling_module_id=="IP" || calling_module_id=="DC" || calling_module_id=="OP" || calling_module_id=="AE"  )){
			chk_for_IA_class_for_enc();
		}
	 }
	 else{
		 chk_for_IA_class_for_enc();
	 }
	}
	
	
	if(siteSpec=='true'){
		if((calling_module_id=="OP" || calling_module_id=="AE")){
			if(auth=='N'){
				populateExistingValues();
				initCommon(obj.value);
		//	alert("initCommon class_type_change hereeeeeeeeee");
//			calcTotalInc();test
			}
		}
	 }
	
//	alert("populateExistingValues done indInc "+document.forms[0].ind_inc.value+"indIncFreq"+document.forms[0].ind_inc_freq.value+"// blnggrpid  "+document.forms[0].blng_grp_id.value);
//	alert("class_type_change ends ");

}

/*For Classification code & Billing group lookups  */
  
function class_code_lkup(clng_evnt)
{
	var target_code	= document.forms[0].class_code ;
	var target = document.forms[0].class_desc;
	var fam_mem_incl_YN = "";
	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			document.forms[0].class_desc.value='';
			document.forms[0].class_code.value = '';
			parent.parent.frames[0].document.forms[0].class_code.value = "";
			parent.parent.frames[0].document.forms[0].class_desc.value = "";
			document.forms[0].blng_grp_id.value='';
			document.forms[0].blng_grp_desc.value = '';
			parent.parent.frames[0].document.forms[0].blng_grp_id.value = "";
			parent.parent.frames[0].document.forms[0].blng_grp_desc.value = "";

			return;
		}
	}

	var retVal				= new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var message				="";
	var sql					= "";

	if(document.forms[0].class_type.value == "")
	{
		alert(getMessage("BL7119","BL"));
		return false;
	}
	
	var title = getLabel("eBL.CLASS_CODE.label","BL");
	title=encodeURIComponent(title);		

	var column_sizes = escape("30%,70%,0%");
	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);
	var incl_family_yn = "INCL_FAMILY_YN";
	incl_family_yn = encodeURIComponent(incl_family_yn);

	column_descriptions = code+","+desc+","+incl_family_yn;

	var facility_id = document.forms[0].facility_id.value;
	var episode_type = document.forms[0].episode_type.value;
	var class_type = document.forms[0].class_type.value;
	var locale = document.forms[0].locale.value;
	var patientId = document.forms[0].patientId.value;
/*
	var slmt_ind = "";
	if( document.forms[0].cash_pay_pat_YN.checked)
	{
		slmt_ind = "C";
	}
	else
	{
		slmt_ind = "X";
	}
*/
	var sex = document.forms[0].sex.value;
	var age = document.forms[0].age.value;
	var childMinAge = document.forms[0].childMinAge.value;
	var module_id = document.forms[0].calling_module_id.value;
//Modified Query V180228-Gayathri/GDOH-SCF-0281
	sql = "select a.classification_code CLASSIFICATION_CODE,a.short_desc SHORT_DESC,a.INCL_FAMILY_YN INCL_FAMILY_YN from BL_CLASSFCTN_CODE_LANG_VW a where a.operating_facility_id ='"+facility_id+"' and a.classification_type = '"+class_type+"' and a.language_id='"+locale+"' and decode('"+episode_type+"','R',a.VALID_FOR_BASIC_CLSFCTN,'O',a.VALID_FOR_BASIC_OP,'E',a.VALID_FOR_BASIC_EM,'I',a.VALID_FOR_BASIC_IP,'D',a.VALID_FOR_BASIC_DY)='Y'";

	if(module_id != "MP")
	{
		sql = sql + " AND appl_patient_sex in('"+sex+"','B') AND ((APPL_TO_CHILD='Y') OR (APPL_TO_CHILD='N' AND '"+age+"' >= "+childMinAge+")) AND ((NVL(a.CHECK_BASIC_CLSFCTN_BLNG_GRP,'N') = 'N') OR ((NVL(a.CHECK_BASIC_CLSFCTN_BLNG_GRP,'N') = 'Y' AND ((a.operating_facility_id,a.classification_code) in (SELECT b.operating_facility_id,b.classification_code FROM BL_BASIC_BG_BY_CLASSFCTN_CODE b, BL_PATIENT_FIN_DTLS c WHERE  b.operating_facility_id = a.operating_facility_id AND b.classification_code = a.classification_code AND b.basic_blng_grp_id = c.blng_grp_id AND c.patient_id = '"+patientId+"' ))))) ";
	}

//	alert(sql);
	sql=escape(sql);

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YYN";

	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);	
//	alert(retVal);
	if (!(retVal == null))
	{
  	    var retVal=unescape(retVal);
		arr=retVal.split("^~^");

		target.value=arr[1];
		target_code.value = arr[0];
		fam_mem_incl_YN = arr[2];
		document.forms[0].fam_mem_incl_YN.value = fam_mem_incl_YN;
		parent.parent.frames[0].document.forms[0].class_code.value = document.forms[0].class_code.value;
		parent.parent.frames[0].document.forms[0].class_desc.value = document.forms[0].class_desc.value ;
		parent.parent.frames[0].document.forms[0].fam_mem_incl_YN.value = fam_mem_incl_YN;
		document.forms[0].blng_grp_id.value = "";
		document.forms[0].blng_grp_desc.value = "";
		parent.parent.frames[0].document.forms[0].blng_grp_id.value = "";
		parent.parent.frames[0].document.forms[0].blng_grp_desc.value = "" ;
		document.forms[0].class_code_valid_YN.value="Y";
	}
	else
	{	
		target.value='';
		target_code.value = '';
		fam_mem_incl_YN = '';
		parent.parent.frames[0].document.forms[0].class_code.value = document.forms[0].class_code.value;
	 	parent.parent.frames[0].document.forms[0].class_desc.value = document.forms[0].class_desc.value ;
		document.forms[0].blng_grp_id.value = "";
		document.forms[0].blng_grp_desc.value = "";
		parent.parent.frames[0].document.forms[0].blng_grp_id.value = "";
		parent.parent.frames[0].document.forms[0].blng_grp_desc.value = "" ;
		document.forms[0].class_code_valid_YN.value="N";
	}
	defBillGroup();
	check_for_fam_mem_incl(fam_mem_incl_YN);
}

function check_for_fam_mem_incl(fam_mem_incl_YN)
{
	var class_type =  document.forms[0].class_type.value;
	var inc_asset_ind = document.forms[0].inc_asset_ind.value;
	var calling_module_id = document.forms[0].calling_module_id.value;

	if(class_type == "IA")
	{
		if(inc_asset_ind != "A")
		{
			if(fam_mem_incl_YN == "N" || fam_mem_incl_YN == "")
			{
				document.forms[0].spouse_inc.disabled = true;
				document.forms[0].spouse_inc_freq.disabled = true;
				document.forms[0].dependent_inc.disabled = true;
				document.forms[0].dependent_inc_freq.disabled = true;
				document.forms[0].no_of_dependants.disabled = true;
				document.forms[0].no_of_dep_mand_yn.style.visibility = "hidden";
			}
			else
			{
				document.forms[0].spouse_inc.disabled = false;
				document.forms[0].spouse_inc_freq.disabled = false;
				document.forms[0].dependent_inc.disabled = false;
				document.forms[0].dependent_inc_freq.disabled = false;
				document.forms[0].no_of_dependants.disabled = false;
				document.forms[0].no_of_dep_mand_yn.style.visibility = "visible";
			}
		}
	}
}

function blng_grp_lkup(clng_evnt)
{
	var target_code	= document.forms[0].blng_grp_id ;
	var target = document.forms[0].blng_grp_desc;
	if(clng_evnt == 'B')
	{
		if( target.value == "")
		{	
			document.forms[0].blng_grp_desc.value='';
			document.forms[0].blng_grp_id.value = '';
			parent.parent.frames[0].document.forms[0].blng_grp_id.value = '';
			parent.parent.frames[0].document.forms[0].blng_grp_desc.value = '' ;
			return;
		}
	}

	var retVal				= new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var message				="";
	var sql					= "";

	if(document.forms[0].class_type.value == "")
	{
		alert(getMessage("BL7119","BL"));
		return false;
	}
	else
	{
		if(document.forms[0].class_code.value == "")
		{
			alert(getMessage("BL7120","BL"));
			return false;
		}
	}
	
	var title = getLabel("Common.BillingGroup.label","common");
	title=encodeURIComponent(title);		

	var column_sizes = escape("30%,70%");
	var code=getLabel("Common.code.label","common");
	code=encodeURIComponent(code);
	var desc=getLabel("Common.description.label","common");
	desc=encodeURIComponent(desc);

	column_descriptions = code+","+desc;

	var facility_id = document.forms[0].facility_id.value;
	var module_id = document.forms[0].calling_module_id.value;
	var locale = document.forms[0].locale.value;
	var class_type = document.forms[0].class_type.value;
	var class_code = document.forms[0].class_code.value;
	var slmt_ind = "";
	var sex = document.forms[0].sex.value;
	var age = document.forms[0].age.value;
	var condnIP = "";
	var InclFamilyYN = "";
/*
	if( document.forms[0].cash_pay_pat_YN.checked)
	{
		slmt_ind = "C";
	}
	else
	{
		slmt_ind = "X";
	}
*/
	if (module_id == "IP")
		condnIP = " AND B.IP_YN='Y'";

	var	sql = "SELECT DISTINCT A.APPL_BLNG_GRP_ID APPL_BLNG_GRP_ID, B.SHORT_DESC SHORT_DESC FROM BL_APPL_BG_BY_CLASSFCTN A, BL_BLNG_GRP_LANG_VW B,BL_CLASSFCTN_CODE C WHERE A.APPL_BLNG_GRP_ID=B.BLNG_GRP_ID AND A.OPERATING_FACILITY_ID = '"+facility_id+"' AND A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID AND A.CLASSIFICATION_CODE = '"+class_code+"' and A.CLASSIFICATION_CODE = C.CLASSIFICATION_CODE and B.LANGUAGE_ID='"+locale+"'"+condnIP;

	if(document.forms[0].class_type.value == "IA")
	{ 
		if(document.forms[0].inc_asset_ind.value == "")
		{	
			alert(getMessage("BL7117","BL"));
			document.forms[0].inc_asset_ind.focus();
			return false;
		}
		else if(document.forms[0].tot_inc_asset.value == "")
		{
			alert(getMessage("BL7125","BL"));
			return false;
		}
		else
		{

			if(document.forms[0].no_of_dependants.value != '' || document.forms[0].no_of_dependants.value > 0)
				InclFamilyYN = "Y";
			else
				InclFamilyYN = "N";
						
			var income_asset_ind = document.forms[0].inc_asset_ind.value;
			var tot_inc_asset = document.forms[0].tot_inc_asset.value;

//			sql =   "SELECT A.APPL_BLNG_GRP_ID APPL_BLNG_GRP_ID,B.SHORT_DESC SHORT_DESC FROM BL_PAT_AUTO_CLASSFCTN_RULES A,BL_BLNG_GRP  B where A.APPL_BLNG_GRP_ID=B.BLNG_GRP_ID AND A.OPERATING_FACILITY_ID ='"+facility_id+"' AND CLASSIFICATION_CODE = '"+class_code+"' AND INCOME_ASSET_IND = '"+income_asset_ind+"' AND  INCL_FAMILY_YN = '"+InclFamilyYN+"' AND "+tot_inc_asset+" BETWEEN LOWER_LIMIT AND nvl(UPPER_LIMIT,"+(parseInt(tot_inc_asset)+1)+") AND B.settlement_ind =  '"+slmt_ind+"'"+condnIP; 
			sql =   "SELECT DISTINCT A.APPL_BLNG_GRP_ID APPL_BLNG_GRP_ID,B.SHORT_DESC SHORT_DESC FROM BL_PAT_AUTO_CLASSFCTN_RULES A,BL_BLNG_GRP_LANG_VW B,BL_CLASSFCTN_CODE C where A.APPL_BLNG_GRP_ID=B.BLNG_GRP_ID AND A.OPERATING_FACILITY_ID ='"+facility_id+"' AND A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID AND A.CLASSIFICATION_CODE = '"+class_code+"' AND A.CLASSIFICATION_CODE = C.CLASSIFICATION_CODE AND A.INCOME_ASSET_IND = '"+income_asset_ind+"' AND C.INCL_FAMILY_YN = '"+InclFamilyYN+"' AND "+tot_inc_asset+" BETWEEN A.LOWER_LIMIT AND nvl(A.UPPER_LIMIT,"+(parseInt(tot_inc_asset)+1)+") AND  B.LANGUAGE_ID='"+locale+"'"+condnIP; 
		}
	}
	else if(document.forms[0].class_type.value == "EX")
	{ 
		sql = "SELECT DISTINCT A.APPL_BLNG_GRP_ID APPL_BLNG_GRP_ID, b.short_desc SHORT_DESC from BL_APPL_BG_BY_CLASSFCTN A, bl_blng_grp B where a.APPL_BLNG_GRP_ID=b.BLNG_GRP_ID AND OPERATING_FACILITY_ID ='"+facility_id+"' AND CLASSIFICATION_CODE = '"+class_code+"'"+condnIP;
	}

	sql=escape(sql);

	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";

	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);	
//	alert(retVal);
	if (!(retVal == null))
	{
  	    var retVal=unescape(retVal);
		arr=retVal.split("^~^");
		
		if(document.forms[0].blng_grp_id.value == arr[0])
		{
			target.value=arr[1];
			target_code.value = arr[0];
			document.forms[0].blng_grp_changed_YN.value = "N";
			parent.parent.frames[0].document.forms[0].blng_grp_id.value = document.forms[0].blng_grp_id.value;
			parent.parent.frames[0].document.forms[0].blng_grp_desc.value = document.forms[0].blng_grp_desc.value ;
			parent.parent.frames[0].document.forms[0].blng_grp_changed_YN.value = "N";
		}
		else
		{
			target.value=arr[1];
			target_code.value = arr[0];
			document.forms[0].blng_grp_changed_YN.value = "Y";
			parent.parent.frames[0].document.forms[0].blng_grp_id.value = document.forms[0].blng_grp_id.value;
			parent.parent.frames[0].document.forms[0].blng_grp_desc.value = document.forms[0].blng_grp_desc.value ;
			parent.parent.frames[0].document.forms[0].blng_grp_changed_YN.value = "Y";
		}
	}
	else
	{	
		target.value='';
		target_code.value = '';
		document.forms[0].blng_grp_changed_YN.value = "Y";
		parent.parent.frames[0].document.forms[0].blng_grp_id.value = document.forms[0].blng_grp_id.value;
	 	parent.parent.frames[0].document.forms[0].blng_grp_desc.value = document.forms[0].blng_grp_desc.value ;
		parent.parent.frames[0].document.forms[0].blng_grp_changed_YN.value = "Y";
	}
	
	var siteSpec=document.forms[0].siteSpec.value;
	 if(siteSpec=='true'){
		 	if(module_id == "IP" || module_id == "DC"){
//			 var blng_grp_id_temp= document.forms[0].blng_grp_id_temp.value; 
			 var blng_grp_id_MPI=document.forms[0].blGrpIdMPI.value; 
//			 		 alert("blng_grp_id_MPI /target_code  "+blng_grp_id_MPI+"/"+target_code.value);
			 if(!target_code.value==''){
				 if(blng_grp_id_MPI != target_code.value){
					 alert(getMessage("BL00988","BL")+" "+blng_grp_id_MPI);
				 }
			 }
		 }
	 }
}

/*  Calculate Total Income*/
function calcTotalInc(val)
{
	var totInc = 0;


	if(document.forms[0].inc_asset_ind.value == 'I')
	{
		if(document.forms[0].ind_inc.value != "" && document.forms[0].ind_inc.value != 0)
		{
			if(document.forms[0].ind_inc_freq.value=="M")
				totInc = totInc +  parseInt(document.forms[0].ind_inc.value)*12;
			else if(document.forms[0].ind_inc_freq.value=="W")
				totInc = totInc + parseInt(document.forms[0].ind_inc.value)*52;
			else if (document.forms[0].ind_inc_freq.value=="Y")
				totInc = totInc +  parseInt(document.forms[0].ind_inc.value);
			else
				totInc = "";

			if(totInc > 0)
			{
				document.forms[0].tot_inc_asset.readOnly = true;
			}
	//		document.forms[0].tot_inc_asset.value =   totInc;
		}
		else
		{
			document.forms[0].ind_inc_freq.value="";
			document.forms[0].tot_inc_asset.value ="";
		}

		if(document.forms[0].spouse_inc.value != "" && document.forms[0].spouse_inc.value != 0)
		{
			if(document.forms[0].spouse_inc_freq.value=="M")
				totInc = totInc +  parseInt(document.forms[0].spouse_inc.value)*12;
			else if(document.forms[0].spouse_inc_freq.value=="W")
				totInc = totInc +  parseInt(document.forms[0].spouse_inc.value)*52;
			else if (document.forms[0].spouse_inc_freq.value=="Y")
				totInc = totInc +  parseInt(document.forms[0].spouse_inc.value);
			else
				totInc = "";
			
			if(totInc > 0)
			{
				document.forms[0].tot_inc_asset.readOnly = true;
			}
	//		document.forms[0].tot_inc_asset.value =   totInc;
		}
		else
		{
			document.forms[0].spouse_inc_freq.value="";
			document.forms[0].tot_inc_asset.value ="";
		}

		
		if( document.forms[0].dependent_inc.value != "" && document.forms[0].dependent_inc.value != 0)
		{
			if(document.forms[0].incld_dep_inc_yn.value == 'Y')
		{
			if(document.forms[0].dependent_inc_freq.value=="M")
				totInc = totInc +  parseInt(document.forms[0].dependent_inc.value)*12;
			else if(document.forms[0].dependent_inc_freq.value=="W")
				totInc = totInc +  parseInt(document.forms[0].dependent_inc.value)*52;
			else if (document.forms[0].dependent_inc_freq.value=="Y") 
				totInc = totInc +  parseInt(document.forms[0].dependent_inc.value);
			else
				totInc = "";
		}	
			
			if(totInc > 0)
			{
				document.forms[0].tot_inc_asset.readOnly = true;
			}
	//		document.forms[0].tot_inc_asset.value =   totInc;
		}
		else
		{
			document.forms[0].dependent_inc_freq.value="";
			document.forms[0].tot_inc_asset.value ="";
		}
		
	}
	if((document.forms[0].ind_inc.value == "")  && (document.forms[0].spouse_inc.value == "") && (document.forms[0].dependent_inc.value=="") && (document.forms[0].inc_asset_ind.value!="I"))
	{
		document.forms[0].tot_inc_asset.readOnly = false;
	}
	if(document.forms[0].inc_asset_ind.value == 'I')
		document.forms[0].tot_inc_asset.value =   totInc;

	put_decimal(document.forms[0].tot_inc_asset,document.forms[0].noofdecimal.value);

	parent.parent.frames[0].document.forms[0].tot_inc_asset.value = document.forms[0].tot_inc_asset.value;
}

/*Disable/Enable field & calculate total income according to income/Asset value  & Assigning values to BLFinClassDetailsHead hidden variables   */
function disableFields()
{
	if(document.forms[0].inc_asset_ind.value == "A")
	{	
		document.forms[0].ind_inc_freq.disabled = true;
		document.forms[0].ind_inc.readOnly = true;
		document.forms[0].ind_inc_freq.selectedIndex = 0;
		document.forms[0].ind_inc.value = "";

		document.forms[0].spouse_inc_freq.disabled = true;
		document.forms[0].spouse_inc.readOnly = true;
		document.forms[0].spouse_inc_freq.selectedIndex = 0;
		document.forms[0].spouse_inc.value = "";

		document.forms[0].dependent_inc_freq.disabled = true;
		document.forms[0].dependent_inc.readOnly = true;
		document.forms[0].dependent_inc_freq.selectedIndex = 0;
		document.forms[0].dependent_inc.value = "";

		document.forms[0].tot_inc_asset.readOnly = false;
		document.forms[0].tot_inc_asset.value = "";

		if(document.forms[0].class_type.value=="IA")
		{
			document.forms[0].blng_grp_id.value = "";
			document.forms[0].blng_grp_desc.value = "";
		}
	}
	else if(document.forms[0].inc_asset_ind.value == "I")
	{
		if(document.forms[0].class_type.value=="IA")
		{
			document.forms[0].blng_grp_id.value = "";
			document.forms[0].blng_grp_desc.value = "";
		}
		document.forms[0].tot_inc_asset.value = "";

		document.forms[0].tot_inc_asset.readOnly = true;

		document.forms[0].ind_inc_freq.disabled = false;
		document.forms[0].ind_inc.readOnly = false;

		document.forms[0].spouse_inc_freq.disabled = false;
		document.forms[0].spouse_inc.readOnly = false;

		document.forms[0].dependent_inc_freq.disabled = false;
		document.forms[0].dependent_inc.readOnly = false;
		var income = "";
		if(document.forms[0].ind_inc.value != "" && document.forms[0].ind_inc.value != 0)
		{
			if(document.forms[0].ind_inc_freq.value == "M")
				income = document.forms[0].ind_inc.value * 12;
			else if(document.forms[0].ind_inc_freq.value == "W")
				income = income + (document.forms[0].ind_inc.value * 52);
			else
				income = income + document.forms[0].ind_inc.value;
		}
		if(document.forms[0].spouse_inc.value != "" && document.forms[0].spouse_inc.value != 0)
		{
			if(document.forms[0].spouse_inc_freq.value == "M")
				income = document.forms[0].spouse_inc.value * 12;
			else if(document.forms[0].spouse_inc_freq.value == "W")
				income = income + (document.forms[0].spouse_inc.value * 52);
			else
				income = income + document.forms[0].spouse_inc.value;
		}

		if(document.forms[0].incld_dep_inc_yn.value == 'Y' && document.forms[0].dependent_inc.value != "" && document.forms[0].dependent_inc.value != 0)
		{

			if(document.forms[0].dependent_inc_freq.value == "M")
				income = document.forms[0].dependent_inc.value * 12;
			else if(document.forms[0].dependent_inc_freq.value == "W")
				income = income + (document.forms[0].dependent_inc.value * 52);
			else
				income = income + document.forms[0].dependent_inc.value;
		}
		document.forms[0].tot_inc_asset.value = income;
		put_decimal(document.forms[0].tot_inc_asset,document.forms[0].noofdecimal.value);
	}
	check_for_fam_mem_incl(document.forms[0].fam_mem_incl_YN.value);
}

/* Default billing group if classification type is Income/Asset */
function defBillGroup()
{	
	var strModuleId			=  parent.parent.frames[0].document.forms[0].calling_module_id.value;
	
	var siteSpec=document.forms[0].siteSpec.value;
	var condnIP = "";
	if (strModuleId == "IP")
			condnIP = " AND B.IP_YN=`Y`";
	parent.parent.frames[0].document.forms[0].no_of_dependants.value =  document.forms[0].no_of_dependants.value;
	if(document.forms[0].class_type.value == "IA")
	{
		if (!(document.forms[0].class_code.value==""  || document.forms[0].inc_asset_ind.value=="" || document.forms[0].tot_inc_asset.value=="") )
		{		
			var fam_mem_incl_YN = document.forms[0].fam_mem_incl_YN.value;
			if(fam_mem_incl_YN == "Y")
			{
				if(document.forms[0].no_of_dependants.value != '' || document.forms[0].no_of_dependants.value > 0)
					InclFamilyYN = "Y";
				else
					InclFamilyYN = "N";
			}
			else
			{
				InclFamilyYN = "N";
			}

			var ipBlGrp =  document.forms[0].ipBlGrp.value;

			sql ="SELECT A.APPL_BLNG_GRP_ID ,B.SHORT_DESC FROM BL_PAT_AUTO_CLASSFCTN_RULES A,BL_BLNG_GRP B,BL_CLASSFCTN_CODE C where A.APPL_BLNG_GRP_ID=B.BLNG_GRP_ID AND A.OPERATING_FACILITY_ID =`"+document.forms[0].facility_id.value+"` AND A.CLASSIFICATION_CODE = `"+document.forms[0].class_code.value+"` AND A.CLASSIFICATION_CODE = C.CLASSIFICATION_CODE AND A.INCOME_ASSET_IND = `"+document.forms[0].inc_asset_ind.value+"` AND  C.INCL_FAMILY_YN = `"+InclFamilyYN+"` AND   "+document.forms[0].tot_inc_asset.value+" BETWEEN A.LOWER_LIMIT AND nvl(A.UPPER_LIMIT,"+(parseInt(document.forms[0].tot_inc_asset.value)+1)+")"+condnIP; 
//			alert(sql);

			var HTMLVal="<html><body><form name='frmBLFin' id='frmBLFin' method='post' action='../../eBL/jsp/AddModifyPatFinClassDetailsValidation.jsp'><input type='hidden' name='called_for' id='called_for' value='def_blng_grp_id'/><input type='hidden' name='codeField' id='codeField' value='blng_grp_id'/><input type='hidden' name='descField' id='descField' value='blng_grp_desc'/><input type='hidden' name='buttonField' id='buttonField' value='blng_grp_btn'/><input type='hidden' name='sql' id='sql' value='"+sql+"'/><input type='hidden' name='billing_group' id='billing_group' value='"+ipBlGrp+"'/><input type='hidden' name='strModuleId' id='strModuleId' value='"+strModuleId+"'/></form></body></html>";
			parent.frames[1].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
			parent.frames[1].document.forms[0].submit();

			

			 if(siteSpec=='true'){
				 	if(strModuleId == "IP" || strModuleId == "DC"){

						var facilityId=document.forms[0].facility_id.value;
			var classCode=document.forms[0].class_code.value;
			var incAssetInd=document.forms[0].inc_asset_ind.value;
			var totIncAsset=document.forms[0].tot_inc_asset.value;
			var totIncAssetParsed=parseInt(document.forms[0].tot_inc_asset.value)+1;
			var defBlngGrpId='';

			$.ajax({
			
				type:'POST',
				url:"../jsp/AddModPatFinClassDtlsBlGrpDefaultCheckAjax.jsp?facilityId="+facilityId+"&classCode="+classCode+"&incAssetInd="+incAssetInd+"&InclFamilyYN="+InclFamilyYN+"&totIncAsset="+totIncAsset+"&totIncAssetParsed="+totIncAssetParsed+"&strModuleId="+strModuleId,
				async:false,
				dataType:"json",
				success : function(data){
//					alert("data"+data);
					defBlngGrpId=data.defBlngGrpId;
//					alert("defBlngGrpId "+defBlngGrpId);
				},

				error: function(data){
					alert("error:: "+data);
				}
			});

					 var blng_grp_id_MPI=document.forms[0].blGrpIdMPI.value; 
					 if(!defBlngGrpId==''){
						 if(blng_grp_id_MPI != defBlngGrpId){
							 alert(getMessage("BL00988","BL")+" "+blng_grp_id_MPI);
						 }
					 }
				 }
			 }
			return true;
		}
		else
		{
			document.forms[0].blng_grp_id.value = "";
			document.forms[0].blng_grp_desc.value = "";
			document.forms[0].blng_grp_desc.disabled = false;
			document.forms[0].blng_grp_btn.disabled = false;
			parent.parent.frames[0].document.forms[0].blng_grp_id.value = "";
			parent.parent.frames[0].document.forms[0].blng_grp_desc.value = "";		
		}
	}
}

// Date Validations
function chkDate(valid_fromObj,valid_toObj,last_dateObj)
{	
	var valid_from = valid_fromObj.value;
	var valid_to = valid_toObj.value;
	var last_date = last_dateObj.value;
	var locale = document.forms[0].locale.value;
	var class_type = document.forms[0].class_type.value;

	if(valid_to != "")
	{
		if((validDate(valid_toObj.value,'DMY',locale)))
		{
			if(!isBefore(valid_toObj.value,last_date,"DMY",locale))
			{
				alert(getMessage("BL7121","BL")+" "+last_date);
				valid_toObj.select();
				return false;
			}
			else
			{
				if(!isAfter(valid_toObj.value,valid_fromObj.value,"DMY",locale))
				{
					alert(getMessage("BL7122","BL"));
					valid_toObj.select();
					return false;					
				}
				else
				{
					if(class_type == "PV")
					{
						var max_days_for_prov_class = document.forms[0].max_days_for_prov_class.value;
						var no_of_days = eval(daysBetween(valid_from,valid_to,"DMY",locale))+1;

						if(eval(no_of_days) >  eval(max_days_for_prov_class))
						{
							alert(getMessage("BL7123","BL")+" "+max_days_for_prov_class+" "+getLabel("Common.days.label","common"));
							valid_toObj.value = "";
							document.getElementById("valid_to_cal").focus();
							return false;
						}
						else
						{
							return true;
						}
					}
					else
					{
						return true;
					}
				}
			}
		}
		else
		{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			valid_toObj.select();
			return false;
		}

	}
}

function enableAllItems(class_type)
{
		var len = document.forms[0].elements.length;
		for(var i=0;i<len;i++)
		{
			if(! (document.forms[0].elements(i).name == "modify_button"))
			document.forms[0].elements(i).disabled=false;

		}
		initCommon(class_type);
}


// Authorize user for modification
async function authUser(class_type)
{	
//	alert("authUser class_type "+class_type.value);
	var siteSpec=$("#siteSpec").val(); // document.forms[0].siteSpec.value;
	var module_id =$("#calling_module_id").val(); // document.forms[0].calling_module_id.value;
	var finDtlMainTabs		= parent.parent.tab_frames.document;	
//alert("siteSpec "+siteSpec+"module_id"+module_id);
		var upd_class_dtls_YN = document.forms[0].upd_class_dtls_YN.value;
		var retVal=new Array();
		if(upd_class_dtls_YN == "N")
		{
			var dialogHeight= "700px" ;//14
			var dialogWidth	= "400px" ;//22
			var dialogTop = "10px" ;//225
			var center = "1" ;														   
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;	
			retVal = await window.showModalDialog("../../eBL/jsp/BLFinDetailsAuthoriseMain.jsp?mode=s",arguments,features);
		//	alert("retVal "+retVal);
		}
		else
		{
			retVal[0]="Y";
		}
		if(retVal!=undefined)
		{
			if(retVal.length>0)
			{
				if(retVal[0]=="Y")
				{
				//	alert("authorized");
					document.forms[0].isUsedAuthorized.value = 'Y';
					enableAllItems(class_type);
					 
					 
					 if(siteSpec=='true'){
						 if(module_id == "OP" || module_id == "AE"){
								var patientId = $("#patientId").val(); 
								var prevPatId = $("#prevPatId").val(); 		
								//alert("patientId "+patientId+" prevPatId "+prevPatId)
								if(!(patientId == prevPatId) && (prevPatId != '' )){
									$(finDtlMainTabs).find("#changePatAuthYN").val('Y');
									$("#changePatAuthYN").val('Y');  
									//alert($("#changePatAuthYN").val());

								}
								$(finDtlMainTabs).find("#classTypChangeAuthYN").val('Y');
								$("#classTypChangeAuthYN").val('Y'); //").val('Y'); 
						 }
					 }
					else{
							 document.forms[0].modify_button.disabled=true; 
					 }
					
						
					parent.parent.frames[0].document.forms[0].modify_flag.value="Y";
					
					return 'Y';
				}
				else{
				//	alert("not authorized");
					return 'N';
				}
			}
		}
		else{
				//	alert("not authorized");
					return 'N';
		}
		
	//	alert("authUser ends "+document.forms[0].blng_grp_id.value);

}

function populateExistingValues(){
//	alert("populateExistingValues");
	classTypePrev=document.forms[0].class_type_prev.value;
	classCodePrev=document.forms[0].class_code_prev.value;
	classDescPrev=document.forms[0].class_desc_prev.value;

	socialPensionerIdPrev=document.forms[0].social_pensioner_id_prev.value;
	incAssetIndPrev=document.forms[0].inc_asset_ind_prev.value;
	indIncPrev=document.forms[0].ind_inc_prev.value;
	indIncFreqPrev=document.forms[0].ind_inc_freq_prev.value;
	spouseIncPrev=document.forms[0].spouse_inc_prev.value;
	spouseIncFreqPrev=document.forms[0].spouse_inc_freq_prev.value;
	dependentIncPrev=document.forms[0].dependent_inc_prev.value;	
	dependentIncFreqPrev=document.forms[0].dependent_inc_freq_prev.value;
//	totIncAssetPrev=document.forms[0].tot_inc_asset_prev.value;
	noOfDependantsPrev=document.forms[0].no_of_dependants_prev.value;
	blngGrpDescPrev=document.forms[0].blng_grp_desc_prev.value;
	blngGrpIdPrev=document.forms[0].blng_grp_id_prev.value;	
	blngGrpDescPrev=document.forms[0].blng_grp_desc_prev.value;
	
	document.forms[0].class_type.value=classTypePrev;
	document.forms[0].class_code.value=classCodePrev;
	document.forms[0].class_desc.value=classDescPrev;
	document.forms[0].social_pensioner_id.value=socialPensionerIdPrev;
	document.forms[0].inc_asset_ind.value=incAssetIndPrev;
	document.forms[0].ind_inc.value=indIncPrev;
	document.forms[0].ind_inc_freq.value=indIncFreqPrev;
	document.forms[0].spouse_inc.value=spouseIncPrev;
	document.forms[0].spouse_inc_freq.value=spouseIncFreqPrev;
	document.forms[0].dependent_inc.value=dependentIncPrev;
	document.forms[0].dependent_inc_freq.value=dependentIncFreqPrev;	
//	document.forms[0].tot_inc_asset.value=totIncAssetPrev;
	document.forms[0].no_of_dependants.value=noOfDependantsPrev;
	document.forms[0].blng_grp_desc.value=blngGrpDescPrev;
	document.forms[0].blng_grp_id.value=blngGrpIdPrev;
	
	
	parent.parent.frames[0].document.forms[0].class_type.value=classTypePrev;
	parent.parent.frames[0].document.forms[0].class_code.value=classCodePrev;
	parent.parent.frames[0].document.forms[0].class_desc.value=classDescPrev;
	parent.parent.frames[0].document.forms[0].social_pensioner_id.value=socialPensionerIdPrev;
	parent.parent.frames[0].document.forms[0].inc_asset_ind.value=incAssetIndPrev;
	parent.parent.frames[0].document.forms[0].ind_inc.value=indIncPrev;
	parent.parent.frames[0].document.forms[0].ind_inc_freq.value=indIncFreqPrev;
	parent.parent.frames[0].document.forms[0].spouse_inc.value=spouseIncPrev;
	parent.parent.frames[0].document.forms[0].spouse_inc_freq.value=spouseIncFreqPrev;
	parent.parent.frames[0].document.forms[0].dependent_inc.value=dependentIncPrev;
	parent.parent.frames[0].document.forms[0].dependent_inc_freq.value=dependentIncFreqPrev;	
//	parent.parent.frames[0].document.forms[0].tot_inc_asset.value=totIncAssetPrev;
	parent.parent.frames[0].document.forms[0].no_of_dependants.value=noOfDependantsPrev;
	parent.parent.frames[0].document.forms[0].blng_grp_desc.value=blngGrpDescPrev;
	parent.parent.frames[0].document.forms[0].blng_grp_id.value=blngGrpIdPrev;
	
//	alert("parent.parent.frames[0] "+parent.parent.frames[0].location);
//	alert("parent.frames[0]. "+parent.frames[0].document.forms[0].location);
//	alert("ends populateExistingValues new class_type "+document.forms[0].class_type.value+"/ indInc "+document.forms[0].ind_inc.value+"/ blng_grp_id  "+document.forms[0].blng_grp_id.value);

	calcTotalInc(); // added during unit testing
}

function showCalendar_loc(Val1, Val2)
{	
	if (Val2.disabled == true)		
	{
		return false;
	}
	else
	{
		return showCalendar(Val1);
	}
}

function initItems(slmt_ind,class_type,inc_asset_ind,ind_inc_freq,spouse_inc_freq,dependent_inc_freq)
{	
	var siteSpec=$("#siteSpec").val(); 
	var module_id =$("#calling_module_id").val(); 

	if(siteSpec=='true'){
		if(module_id == "OP" || module_id == "AE"){
			var sessionClinicCode	=$("#sessionClinicCode").val(); 
			var reqClinicCode		=$("#reqClinicCode").val(); 
			//alert("sessionClinicCode "+sessionClinicCode+"reqClinicCode"+reqClinicCode);
			if(!(sessionClinicCode=="")){
				if(!(sessionClinicCode==reqClinicCode)){
					alert(getMessage("BL00990","BL"));
				}
			}
			
		}
			
	}
	if(! slmt_ind == "")
	{
//		if(slmt_ind == "C")
//			document.forms[0].cash_pay_pat_YN.CHECKED = true;
//			document.forms[0].slmt_ind.selectedIndex = 1;
//		else
//			document.forms[0].cash_pay_pat_YN.CHECKED = false;
//			document.forms[0].slmt_ind.selectedIndex = 2;
	}

	initCommon(class_type);

	if(! inc_asset_ind == "")
	{	 
		if(inc_asset_ind == "I")
			document.forms[0].inc_asset_ind.selectedIndex = 1;
		else if(inc_asset_ind == "A")
		{
			document.forms[0].inc_asset_ind.selectedIndex = 2;
			document.forms[0].ind_inc_freq.disabled = true;
			document.forms[0].ind_inc.readOnly = true;
			document.forms[0].ind_inc_freq.selectedIndex = 0;
			document.forms[0].ind_inc.value = "";

			document.forms[0].spouse_inc_freq.disabled = true;
			document.forms[0].spouse_inc.readOnly = true;
			document.forms[0].spouse_inc_freq.selectedIndex = 0;
			document.forms[0].spouse_inc.value = "";

			document.forms[0].dependent_inc_freq.disabled = true;
			document.forms[0].dependent_inc.readOnly = true;
			document.forms[0].dependent_inc_freq.selectedIndex = 0;
			document.forms[0].dependent_inc.value = "";
		}
		
	}
	if(! ind_inc_freq == "")
	{
		if(ind_inc_freq == "Y")
			document.forms[0].ind_inc_freq.selectedIndex = 1;
		else if(ind_inc_freq == "M")
			document.forms[0].ind_inc_freq.selectedIndex = 2;
		else if(ind_inc_freq == "W")
			document.forms[0].ind_inc_freq.selectedIndex = 3;
	}
	if(! spouse_inc_freq == "")
	{
		if(spouse_inc_freq == "Y")
			document.forms[0].spouse_inc_freq.selectedIndex = 1;
		else if(spouse_inc_freq == "M")
			document.forms[0].spouse_inc_freq.selectedIndex = 2;
		else if(spouse_inc_freq == "W")
			document.forms[0].spouse_inc_freq.selectedIndex = 3;
	}

	if(! dependent_inc_freq == "")
	{
		if(dependent_inc_freq == "Y")
			document.forms[0].dependent_inc_freq.selectedIndex = 1;
		else if(dependent_inc_freq == "M")
			document.forms[0].dependent_inc_freq.selectedIndex = 2;
		else if(dependent_inc_freq == "W")
			document.forms[0].dependent_inc_freq.selectedIndex = 3;
	}
	var ddd='ddd';
	calcTotalInc();
} 

function disableItems()
{
		var len = parent.frames[0].document.forms[0].elements.length;
		for(var i=0;i<len;i++)
		{
			if(! (parent.frames[0].document.forms[0].elements(i).name == "modify_button"))
			parent.frames[0].document.forms[0].elements(i).disabled=true;
		}

		var upd_class_dtls_YN = document.forms[0].upd_class_dtls_YN.value;

		if(upd_class_dtls_YN == "Y")
			document.forms[0].modify_button.click();
}

function assignValues(name)
{
	var obj = eval("parent.parent.frames[0].document.forms[0]."+name);
	var obj1 = eval("document.forms[0]."+name);

//	if(name != "cash_pay_pat_YN")
//	{
		obj.value =  obj1.value;
/*
	}
	else
	{
		if(obj1.checked)
		{
			obj.value = "Y";
			parent.parent.frames[0].document.forms[0].slmt_ind.value = "C";
		}
		else
		{
			obj.value = "N";
			parent.parent.frames[0].document.forms[0].slmt_ind.value = "R";
		}
	}
*/
} 

function setIncAssetInd(obj)
{
	if(obj.value != null && obj.value != "")
	{
		if(document.forms[0].inc_asset_ind.selectedIndex == 0)
		{
			document.forms[0].inc_asset_ind.selectedIndex = 1;
			parent.parent.frames[0].document.forms[0].inc_asset_ind.value =  "I";
		}
	}
}

function filter_class_type()
{

}

function chk_for_fam_incl()
{
	if(document.forms[0].class_type.value == "IA")
	{
		if (!(document.forms[0].class_code.value==""  || document.forms[0].inc_asset_ind.value=="" || document.forms[0].tot_inc_asset.value=="") )
		{		
			var fam_mem_incl_YN = document.forms[0].fam_mem_incl_YN.value;
			if(fam_mem_incl_YN == "Y")
			{
			//if(document.forms[0].no_of_dependants.value == 0 || document.forms[0].no_of_dependants.value == "")
			if( document.forms[0].no_of_dependants.value == "")
				{
					alert(getMessage("BL7124","BL"));
					document.forms[0].no_of_dependants.value="";
					return false;
				}
			}
		}
	}
}

function chk_for_IA_class_for_enc()
{
	var class_code = document.forms[0].class_code.value;
	var class_type = document.forms[0].class_type.value;
	var strModuleId = document.forms[0].calling_module_id.value;
	var billing_mode = document.forms[0].billing_mode.value;
	var patient_id = document.forms[0].patientId.value;
	var siteSpec=document.forms[0].siteSpec.value;

	var HTMLVal="<html><body><form name='frmBLFin' id='frmBLFin' method='post' action='../../eBL/jsp/AddModifyPatFinClassDetailsValidation.jsp'><input type='hidden' name='called_for' id='called_for' value='enc_level_def_IA_class_dtls'/><input type='hidden' name='class_code' id='class_code' value='"+class_code+"'/><input type='hidden' name='class_type' id='class_type' value='"+class_type+"'/><input type='hidden' name='billing_mode' id='billing_mode' value='"+billing_mode+"'/><input type='hidden' name='strModuleId' id='strModuleId' value='"+strModuleId+"'/><input type='hidden' name='patient_id' id='patient_id' value='"+patient_id+"'/><input type='hidden' name='siteSpec' id='siteSpec' value='"+siteSpec+"'/></form></body></html>";
//	var HTMLVal="<html><body><form name='frmBLFin' id='frmBLFin' method='post' action='../../eBL/jsp/AddModifyPatFinClassDetailsValidation.jsp'><input type='hidden' name='called_for' id='called_for' value='def_blng_grp_id'/><input type='hidden' name='codeField' id='codeField' value='blng_grp_id'/><input type='hidden' name='descField' id='descField' value='blng_grp_desc'/><input type='hidden' name='buttonField' id='buttonField' value='blng_grp_btn'/><input type='hidden' name='sql' id='sql' value='"+sql+"'/><input type='hidden' name='billing_group' id='billing_group' value='"+ipBlGrp+"'/><input type='hidden' name='strModuleId' id='strModuleId' value='"+strModuleId+"'/><input type='hidden' name='siteSpec' id='siteSpec' value='"+siteSpec+"'/></form></body></html>";
	parent.frames[1].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
	parent.frames[1].document.forms[0].submit();
}

function CheckForChar(Obj)
{
	var check_var = Obj.value;

	numList = '1234567890.';
	
	for (i=0;i<check_var.length;i++)
	{
		if (numList.indexOf(check_var.charAt(i)) == -1) 
		{
			alert(getMessage("CANNOT_BE_SPECIAL_CHAR",'Common'));
			Obj.select();
			return false;  
		}
	}
	return true;
}

function CheckIncAmt(Obj)
{
	var flag = CheckForChar(Obj);

	if(flag)
	{
		put_decimal(Obj,document.forms[0].noofdecimal.value);
		return true;
	}
	else
	{
		return false;
	}
}

function IncomeEntry(obj,cald_inc)
{

	if(CheckIncAmt(obj))
	{
		var eee='eee';
		calcTotalInc();
		defBillGroup();
		assignValues(cald_inc);
		setIncAssetInd(obj);
	}
}

function refreshAuthValue(){
	
	var classTypChangeAuthYN=$("#classTypChangeAuthYN").val(); 
	var patientId = $("#patientId").val(); 
	var prevPatId = $("#prevPatId").val(); 
//	alert("refreshAuthValue classTypChangeAuthYN:: "+classTypChangeAuthYN+" patientId "+patientId+" prevPatId "+prevPatId);
	if(classTypChangeAuthYN=='Y'){
		//alert("refreshing ............. ");
		var called_from='onLoad';

		$.ajax({
			
			type:'POST',
			url:"../../eBL/jsp/AddModPatFinClassChangeAuthAjax.jsp?classTypChangeAuthYN="+classTypChangeAuthYN+"&called_from="+called_from+"&patientId="+patientId+"&prevPatId="+prevPatId,
//			url:"../../eBL/jsp/AddModPatFinClassChangeAuthAjax.jsp?classTypChangeAuthYN="+classTypChangeAuthYN+"&refreshAuth="+refreshAuth+"&tabsSwapped="+tabsSwapped+"&called_from"+called_from,

			async:false,
			dataType:"json",
			success : function(data){
			},

			error: function(data){
			}
		});
		
		
		
	}
}

