/* 
Sr No        Version           Incident             SCF/CRF             Developer Name
--------------------------------------------------------------------------------------
1              New           	30618		PMG2021-COMN-CRF-0076.2     Manivel N
2			V230221				41203	BL-TAIBA-Manage Patient Packages	 Mohanapriya
*/



function sendBackExclValues(){
	
	var tot_rec = document.getElementById("cnt").value;

	if(tot_rec == 0){
		alert(getMessage("NO_RECORD_FOUND","common"));
		return false;
	}
	
	var isRecsValid = valExclRecordsOnSave();
	if(isRecsValid == true){
		var delimExclStr = fnForExclStr();
		if(delimExclStr != "")
			window.returnValue = "Y" + "||" + delimExclStr;
		else
			window.returnValue = "N" + "||" + delimExclStr;
		window.close();	
	} else {
		return false;
	}
}	

function valExclRecordsOnSave(){
	var totRec = document.getElementById('cnt').value;
	totRec = parseInt(totRec);

	var daily_pkg_lmt_yn = document.getElementById('daily_pkg_lmt_yn').value;
	var p_daily_pkg_serv_lmt = document.getElementById('p_daily_pkg_serv_lmt').value;
	var p_daily_pkg_serv_lmt_ind = document.getElementById('p_daily_pkg_serv_lmt_ind').value;	

	var validate_flag = true;

	for(var i=1;i<=totRec;i++){
		var pkg_serv_code = document.getElementById("pkg_serv_code"+i).value;
		if(pkg_serv_code == null || pkg_serv_code == "") pkg_serv_code = "";
	
		var hdn_is_newly_added_row_YN = document.getElementById("hdn_is_newly_added_row_YN_"+i).value;
		var chk_exclude_all = document.getElementById("chk_exclude_all"+i).value;

		if(pkg_serv_code == "" && hdn_is_newly_added_row_YN == "N"){
			alert(getMessage("BL8531","BL"));
			document.getElementById("pkg_serv_code"+i).focus();
			return false;
		}else if(pkg_serv_code != "" && chk_exclude_all == "N") {
			var pkg_serv_ind = document.getElementById("pkg_serv_ind"+i);
			var rate_charge_ind = document.getElementById("rate_charge_ind"+i);
			var amt_limit_ind = document.getElementById("amt_limit_ind"+i);
			var qty_limit = document.getElementById("qty_limit"+i);
			var amt_limit = document.getElementById("amt_limit"+i);
			
			var daily_qty_limit = document.getElementById("daily_qty_limit"+i);
			var daily_amt_limit = document.getElementById("daily_amt_limit"+i);
			var daily_limit_ind = document.getElementById("daily_limit_ind"+i);
			var GrossNet = document.getElementById("GrossNet"+i);			
			
			if(amt_limit_ind.value == '' && qty_limit.value == ''){				
				alert(getMessage("BL8555","BL"));
				qty_limit.focus();
				return false;
			} else if(amt_limit_ind.value == 'A' && amt_limit.value == ''){
				alert(getMessage("BL8561","BL"));
				amt_limit.value = "";
				amt_limit.focus();	
				return false;
			} else if (amt_limit_ind.value == 'A' && amt_limit.value == 0){
				alert(getMessage("BL8552","BL"));
				amt_limit.value = "";
				amt_limit.focus();	
				return false;
			} else if(amt_limit_ind.value == 'P' && amt_limit.value == ''){
				alert(getMessage("BL8561","BL"));
				amt_limit.value = "";
				amt_limit.focus();
				return false;				
			} else if(amt_limit_ind.value == 'P' && amt_limit.value == 0){
				alert(getMessage("BL8539","BL"));
				amt_limit.value = "";
				amt_limit.focus();
				return false;				
			}
			
			var replaceable_yn = document.getElementById("replaceable_yn"+i).value;
			var replaceable_serv_code = document.getElementById("replaceable_serv_code"+i);

			if(replaceable_yn == "Y" && replaceable_serv_code.value == ""){
				alert(getMessage("BL8543","BL"));
				replaceable_serv_code.focus();
				return false;
			}
			
			if(daily_pkg_lmt_yn == "Y" && daily_limit_ind.value != ""){
				if(p_daily_pkg_serv_lmt_ind == 'B' || p_daily_pkg_serv_lmt_ind == 'Q'){
					if(daily_qty_limit.value == ''){
						alert(getMessage("BL0847","BL"));
						daily_qty_limit.focus();
						return false;
					}
					
					if(daily_qty_limit.value == 0){
						alert(getMessage("BL0846","BL"));
						daily_qty_limit.value = '';
						daily_qty_limit.focus();
						return false;
					}
				}
				
				if(p_daily_pkg_serv_lmt_ind == 'B' || p_daily_pkg_serv_lmt_ind == 'A'){	
					if(daily_amt_limit.value == ''){
						alert(getMessage("BL0816","BL"));
						daily_amt_limit.focus();
						return false;
					}	

					if(daily_amt_limit.value == 0){
						alert(getMessage("BL0815","BL"));
						daily_amt_limit.value = '';					
						daily_amt_limit.focus();
						return false;
					}					
				}			
			}
			
			var refund_yn = document.getElementById("refund_yn"+i);
			var refund_rate = document.getElementById("refund_rate"+i);	
			
			if(pkg_serv_ind.value != 'S' && refund_yn.value == "Y"){
				if(pkg_serv_ind.value == 'M'){
					alert(getMessage("BL8673","BLEXT"));
					return false;
				}else{
					alert(getMessage("BL8575","BL"));
					return false;
				}				
			}

			if(refund_rate.value == "" && refund_yn.value == "Y"){
				alert(getMessage("BL8666","BL"));
				document.getElementById("refund_rate"+i).focus();
				return false;		
			}
		}
	}
	return validate_flag;
}

function fnForExclStr(){
	var tot_rec = document.getElementById("cnt").value;
	var delimExclStr = "";
	var exclRow = "";

	for(var i=1;i<=tot_rec;i++)
	{
		var excl_serv_ind = document.getElementById("pkg_serv_ind"+i).value;
		if(excl_serv_ind == null || excl_serv_ind == "") excl_serv_ind = " ";
	
		var excl_serv_code = document.getElementById("pkg_serv_code"+i).value;
		if(excl_serv_code == null || excl_serv_code == "") excl_serv_code = "";
		
		if(excl_serv_code != ""){		
			var rate_charge_ind = document.getElementById("rate_charge_ind"+i).value;
			if(rate_charge_ind == null || rate_charge_ind == "") rate_charge_ind = " ";		

			var exclude_yn = document.getElementById("chk_exclude_all"+i).value;
			if(exclude_yn == null || exclude_yn == "") exclude_yn = "N";
			
			var amt_limit_ind = document.getElementById("amt_limit_ind"+i).value;
			if(amt_limit_ind == null || amt_limit_ind == "") amt_limit_ind = " ";
			
			var qty_limit = document.getElementById("qty_limit"+i).value;
			if(qty_limit == null || qty_limit == "") qty_limit = " ";
			
			var amt_limit = document.getElementById("amt_limit"+i).value;
			if(amt_limit == null || amt_limit == "") amt_limit = " ";

			var replaceable_yn = document.getElementById("replaceable_yn"+i).value;
			if(replaceable_yn == null || replaceable_yn == "") replaceable_yn = "N";
			
			var replaceable_serv_code = document.getElementById("replaceable_serv_code"+i).value;
			if(replaceable_serv_code == null || replaceable_serv_code == "") replaceable_serv_code = " ";

			var refund_yn = document.getElementById("refund_yn"+i).value;
			if(refund_yn == null || refund_yn == "") refund_yn = "N";
			
			var refund_rate = document.getElementById("refund_rate"+i).value;
			if(refund_rate == null || refund_rate == "") refund_rate = " ";

			var auto_refund_yn = document.getElementById("auto_refund_yn"+i).value;
			if(auto_refund_yn == null || auto_refund_yn == "") auto_refund_yn = "N";
			//rounding_by_integer,
			//rounding_option, 
			var apply_fact_for_srv_lmt_yn = document.getElementById("apply_fact_for_srv_lmt_yn"+i).value;
			if(apply_fact_for_srv_lmt_yn == null || apply_fact_for_srv_lmt_yn == "") apply_fact_for_srv_lmt_yn = "N";
			//added_by_id,added_date, modified_by_id, modified_date, added_at_ws_no,
			//added_facility_id, modified_at_ws_no, modified_facility_id,

			var split_allowed_yn = document.getElementById("split_allowed_yn"+i).value;
			if(split_allowed_yn == null || split_allowed_yn == "") split_allowed_yn = "N";
			
			var incl_home_medication_yn = document.getElementById("incl_home_medication_yn"+i).value;
			if(incl_home_medication_yn == null || incl_home_medication_yn == "") incl_home_medication_yn = "N";
			
			var home_med_enable_yn = document.getElementById("home_med_enable_yn"+i).value;
			if(home_med_enable_yn == null || home_med_enable_yn == "") home_med_enable_yn = "N";

			var daily_amt_limit_yn = ""; // not available
			if(daily_amt_limit_yn == null || daily_amt_limit_yn == "") daily_amt_limit_yn = "N";
			
			var daily_amt_limit = document.getElementById("daily_amt_limit"+i).value;
			if(daily_amt_limit == null || daily_amt_limit == "") daily_amt_limit = " ";

			var daily_amt_limit_gross_net = document.getElementById("GrossNet"+i).value;
			if(daily_amt_limit_gross_net == null || daily_amt_limit_gross_net == "") daily_amt_limit_gross_net = " ";
			
			var daily_limit_ind = document.getElementById("daily_limit_ind"+i).value;
			if(daily_limit_ind == null || daily_limit_ind == "") daily_limit_ind = " ";

			var daily_qty_limit = document.getElementById("daily_qty_limit"+i).value;
			if(daily_qty_limit == null || daily_qty_limit == "") daily_qty_limit = " ";
			
			var hdn_is_newly_added_row_YN = document.getElementById("hdn_is_newly_added_row_YN_"+i).value;
			if(hdn_is_newly_added_row_YN == null || hdn_is_newly_added_row_YN == "") hdn_is_newly_added_row_YN = "N";

			var hdn_row_marked_for_del = document.getElementById("hdn_row_marked_for_del_"+i).value;
			if(hdn_row_marked_for_del == null || hdn_row_marked_for_del == "") hdn_row_marked_for_del = " ";

			var hdn_rowid = document.getElementById("hdn_rowid"+i).value;
			if(hdn_rowid == null || hdn_rowid == "") hdn_rowid = " ";	

			var dbcnt = document.getElementById("dbcnt").value;
			if(dbcnt == null || dbcnt == "") dbcnt = " ";	

			var utilized_serv_qty = document.getElementById("utilized_serv_qty"+i).value;
			if(utilized_serv_qty == null || utilized_serv_qty == "") utilized_serv_qty = " ";	

			var utilized_serv_amt = document.getElementById("utilized_serv_amt"+i).value;
			if(utilized_serv_amt == null || utilized_serv_amt == "") utilized_serv_amt = " ";	

			var pkg_service_long_desc = document.getElementById("pkg_service_long_desc"+i).value;
			if(pkg_service_long_desc == null || pkg_service_long_desc == "") pkg_service_long_desc = " ";			

			exclRow = exclRow+rate_charge_ind+"~~"+excl_serv_code+"~~"+excl_serv_ind+"~~"+exclude_yn+"~~"+amt_limit_ind+"~~"+qty_limit+"~~"+amt_limit+"~~"+replaceable_yn+"~~"+replaceable_serv_code+"~~"+refund_yn+"~~"+refund_rate+"~~"+auto_refund_yn+"~~"+apply_fact_for_srv_lmt_yn+"~~"+split_allowed_yn+"~~"+incl_home_medication_yn+"~~"+daily_amt_limit_yn+"~~"+daily_amt_limit+"~~"+daily_amt_limit_gross_net+"~~"+daily_limit_ind+"~~"+daily_qty_limit+"~~"+hdn_is_newly_added_row_YN+"~~"+hdn_row_marked_for_del+"~~"+hdn_rowid+"~~"+dbcnt+"~~"+home_med_enable_yn+"~~"+utilized_serv_qty+"~~"+utilized_serv_amt+"~~"+pkg_service_long_desc+"::";
		}
	}	

	return exclRow;
}

async function exclServLookup(index,code,obj){
	var facility_id = document.getElementById("facility_id").value;	
	var pkgservind=document.getElementById("pkg_serv_ind"+index).value;	
	var pkgservdesc=document.getElementById("pkg_service_long_desc").value;
	
	if(pkgservdesc!=''){
		document.getElementById("pkg_service_long_desc").value="";
	}
	
	var parent_service_code = document.getElementById("parent_pkg_serv_code").value;
	var parent_service_ind = document.getElementById("parent_pkg_serv_ind").value;

	var locale  = document.forms[0].locale.value;	
	
	var title ="";
	 var argumentArray = new Array();
	 var dataNameArray = new Array();
	 var dataValueArray = new Array();
	 var dataTypeArray = new Array();
	 if(pkgservind=='S'){
		 title = "List of Billing Services";
	 }else if(pkgservind=='C'){
		 title = "List of Service Classifications";
	 }else if(pkgservind=='G'){
		 title = "List of Service Groups";
	 }else if(pkgservind=='P'){
		 title = "List of Package Groups";
	 }else{
		 title = "List of Items";
	 }
	 
	 var sql="";

	 if(pkgservind=='C'){
		 sql = "select serv_classification_code code,short_Desc description from BL_SERV_CLASSIFICATION_LANG_VW where  language_id='"
				+ locale
				+ "' and ((upper(substr(serv_classification_code,1,2)) = upper('"
				+ parent_service_code
				+ "')) or (upper('"
				+ parent_service_ind
				+ "') ='P')) and upper(serv_classification_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
	 } else {
		if(parent_service_ind == "G"){
			if(pkgservind=='S'){
				sql = "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"
				+ locale
				+ "' and status is null and ((upper(substr(blng_serv_code,1,2)) = upper('"
				+ parent_service_code
				+ "')) or (upper('"
				+ parent_service_ind
				+ "') ='P')) and  upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
			} else if (pkgservind=='M'){
				sql = "select c.item_code code, c.short_Desc description FROM bl_st_item a, bl_st_item_sale_catg_dtl b, mm_item_lang_vw c WHERE a.sale_category_code = b.sale_category_code AND a.item_code = c.item_code AND nvl(a.status,'X') != 'S' AND c.language_id='"
						+ locale
						+ "' and upper(c.item_code) like upper(?) and upper(c.short_desc) like upper(?) order by 2  ";
			} else if (pkgservind=='P'){
				sql = "select PACKAGE_SERV_GROUP_CODE code,LONG_DESC description from BL_PACKAGE_SERV_GROUP_HDR where OPERATING_FACILITY_ID = '"+facility_id+"'  and  upper(PACKAGE_SERV_GROUP_CODE) like upper(?) and upper(LONG_DESC) like upper(?) order by 2";
			} 
		} 
		else if (parent_service_ind == "P") {
			if (pkgservind == "M") {
				sql = "select c.item_code code, c.short_Desc description FROM bl_st_item a, bl_st_item_sale_catg_dtl b, mm_item_lang_vw c WHERE a.sale_category_code = b.sale_category_code AND a.item_code = c.item_code AND nvl(a.status,'X') != 'S' AND c.language_id='"
						+ locale
						+ "' and upper(c.item_code) like upper(?) and upper(c.short_desc) like upper(?) order by 2  ";
			} else if (pkgservind == "S") {
				sql = "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"
						+ locale
						+ "' and status is null and ((upper(substr(blng_serv_code,1,2)) = upper('"
						+ parent_service_code
						+ "')) or (upper('"
						+ parent_service_ind
						+ "') ='P')) and  upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
			} else if (pkgservind == "C") {
				sql = "select serv_classification_code code,short_Desc description from BL_SERV_CLASSIFICATION_LANG_VW where  language_id='"
						+ locale
						+ "' and upper(substr(serv_classification_code,1,2)) = upper('"
						+ parent_service_code
						+ "') and upper(serv_classification_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
			} else if (pkgservind == 'G') {
				sql = "select serv_grp_code code,short_desc description from BL_BLNG_SERV_GRP_LANG_VW where  language_id='"
						+ locale
						+ "' and upper(serv_grp_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
			} else if (pkgservind == 'T') {
				sql = "select SALE_CATEGORY_CODE code,short_desc description from BL_ST_ITEM_SALE_CATG_HDR where upper(SALE_CATEGORY_CODE) like upper(?) and upper(short_desc) like upper(?) order by 2";
			} else if (pkgservind == "P") {
				sql = "select PACKAGE_SERV_GROUP_CODE code,LONG_DESC description from BL_PACKAGE_SERV_GROUP_HDR where OPERATING_FACILITY_ID = '"+facility_id+"'  and  upper(PACKAGE_SERV_GROUP_CODE) like upper(?) and upper(LONG_DESC) like upper(?) order by 2"; //V211130
			}
		} else if (parent_service_ind == "C") {
			if(pkgservind == "S"){
			sql = "select blng_serv_code code,short_Desc description from BL_BLNG_SERV_LANG_VW where  language_id='"
					+ locale
					+ "' and status is null and upper(substr(blng_serv_code,1,4)) = upper('"
					+ parent_service_code
					+ "')  and  upper(blng_serv_code) like upper(?) and upper(short_desc) like upper(?) order by 2  ";
			} else {
				sql="select description, code  from (SELECT short_desc description,serv_code code FROM (SELECT a.short_desc short_desc,a.blng_serv_code serv_code,'S' pkg_serv_ind,a.language_id lang_id "+
				"FROM bl_blng_serv_lang_vw a, bl_blng_serv b WHERE a.blng_serv_code = b.blng_serv_code AND nvl(b.status,'X') != 'S' "+
				 "AND a.language_id = '"+locale+"' UNION SELECT a.short_desc short_desc,a.serv_grp_code serv_code,'G' pkg_serv_ind,"+
				 "a.language_id lang_id FROM bl_blng_serv_grp_lang_vw a, bl_blng_serv_grp b  WHERE a.serv_grp_code = b.serv_grp_code AND nvl(b.status,'X') != 'S'"+
				 "  AND a.language_id = '"+locale+"' UNION SELECT a.short_desc short_desc,a.serv_classification_code serv_code,'C' pkg_serv_ind,"+
				 "a.language_id lang_id FROM bl_serv_classification_lang_vw a, bl_serv_classification b WHERE a.serv_classification_code = b.serv_classification_code"+
				  " AND nvl(b.status,'X') != 'S' AND a.language_id = '"+locale+"' UNION "+
				"SELECT SHORT_DESC short_desc,PACKAGE_SERV_GROUP_CODE serv_code,'P' pkg_serv_ind,'en' lang_id  FROM bl_package_serv_group_hdr"+
			   " union SELECT b.SHORT_DESC SHORT_DESC,b.ITEM_CODE serv_code,'M' pkg_serv_ind, b.language_id lang_id FROM bl_st_item a, mm_item_lang_vw b"+
				" WHERE a.item_code = b.item_code AND b.language_id = '"+locale+"') WHERE pkg_serv_ind = '"+pkgservind+"') where upper(description) like upper(?) "+
				"and upper(code) like upper(?)  order by 2";
			}
		}
	 
	 }

		argumentArray[0] = sql;
	    argumentArray[1] = dataNameArray;
	    argumentArray[2] = dataValueArray;
	    argumentArray[3] = dataTypeArray;
	    argumentArray[4] = "2,1";
	    argumentArray[5] = code.value;
	    argumentArray[6] = DESC_LINK;
	    argumentArray[7] = DESC_CODE;
	//    alert(sql);
	    returnedValues = await CommonLookup(title, argumentArray);
	    if ((returnedValues != null) && (returnedValues != "")) {
	    	var str =unescape(returnedValues);
	    	var arr = str.split(",");
	        obj.value = arr[1];
	        code.value = arr[0];
	        document.getElementById("pkg_service_long_desc").value=arr[1];
			//chkExclHomeMedEnableYN(index, pkgservind, code.value); 
	    } else {
	        obj.value = '';
	        code.value = '';
	        document.getElementById("pkg_service_long_desc").value='';
	    }
	    checkExclDuplicate(index);
}

function chkExclHomeMedEnableYN(index, pkgServInd, pkgServCode){
	var URL = "../../eBL/jsp/MaintainTreatServValidation.jsp?func_mode=HOME_MED_ENABLE_YN&pkgServInd="+pkgServInd+"&pkgServCode="+pkgServCode;

	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", URL, false);
	xmlHttp.send();
	var responseText = trimString(xmlHttp.responseText);

	if(responseText == "Y"){
		document.getElementById("incl_home_medication_yn"+index).disabled = false;
		document.getElementById("home_med_enable_yn"+index).value = "Y";
	} else {
		document.getElementById("incl_home_medication_yn"+index).disabled = true;
		document.getElementById("home_med_enable_yn"+index).value = "N";		
	} 
}

function addExclRow() {

	var mode = "";
	var table = "";
	var rowCount = "";
	var index = "";
	var row = "";
	var order_associated ="";	

	var formObj = document.forms[0];
	table = document.getElementById('maintainTrtPkgExclDtls');
	var parent_pkg_serv_ind = document.getElementById('parent_pkg_serv_ind').value;
	var noofdecimal = document.getElementById('noofdecimal').value;
	var p_daily_pkg_serv_lmt = document.getElementById('p_daily_pkg_serv_lmt').value;

	rowCount = table.rows.length;	
	rowCount = parseInt(rowCount);
	
	document.getElementById('index').value=rowCount;	
	index=rowCount;
	
	var indicatorFldDisabled= formObj.indicatorFldDisabled.value;
	var amtFldDisabled 		= formObj.amtFldDisabled.value;
	var qtyFldDisabled 		= formObj.qtyFldDisabled.value; 
	var grossNetDisabled	= formObj.grossNetDisabled.value;	

	row = document.getElementById('maintainTrtPkgExclDtls').insertRow(rowCount);

	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	var cell4 = row.insertCell(3);
	var cell5 = row.insertCell(4);
	var cell6 = row.insertCell(5);
	var cell7 = row.insertCell(6);
	var cell8 = row.insertCell(7);
	var cell9 = row.insertCell(8);
	var cell10 = row.insertCell(9);
	var cell11 = row.insertCell(10);
	var cell12 = row.insertCell(11);
	var cell13 = row.insertCell(12);
	var cell14 = row.insertCell(13);
	var cell15 = row.insertCell(14);
	var cell16 = row.insertCell(15);
	var cell17 = row.insertCell(16);
	var cell18 = row.insertCell(17);
	var cell19 = row.insertCell(18); 
	var cell20 = row.insertCell(19); 
	var cell21 = row.insertCell(20);
	var cell22 = row.insertCell(21); 
	var cell23 = row.insertCell(22); 
	var cell24 = row.insertCell(23); 
	var cell25 = row.insertCell(24);
	var cell26 = row.insertCell(25);
	//var cell27 = row.insertCell(26);
	var typeHTML = "";
	var indHTML = "";
	var ordCatDisabled = "disabled";

	var temp_str = "<td class='fields' nowrap> "+
	"<select style='width: 150px;' name='pkg_serv_ind" + index + "' id='pkg_serv_ind" + index + "' id='pkg_serv_ind" + index + "' onChange='onCustServiceTypeChange(this,\"" + index	+ "\");'>";
	if(parent_pkg_serv_ind != "G" && parent_pkg_serv_ind !="C"){	
		temp_str = temp_str + "<option value='G'>"+getLabel('eBL.SERVICE_GROUP.label', 'BL')+"</option>";
	}
	if(parent_pkg_serv_ind !="C"){	
		temp_str = temp_str + "<option value='C'>"+getLabel('eBL.SERVICE_CLASSIFICATION.label', 'BL')+"</option>";
	}
	temp_str = temp_str + "<option value='S'>"+getLabel('Common.BillingService.label', 'Common')+"</option>"
						+ "<option value='P'>"+getLabel('eBL.PackageGrouping.label', 'BL')+"</option>"
						+ "<option value='M'>"+getLabel('eBL.Items.label', 'BL')+"</option>"
						+ "</select>"
						+ "</td> ";
	
	cell1.innerHTML = temp_str;
	cell1.className = 'fields'; 
	cell1.style.whiteSpace = "nowrap";
 
	cell2.innerHTML = "<td class='fields' nowrap> "
		+"<input type='text'  name='pkg_serv_code" + index  
		+ "' id='pkg_serv_code" + index  
		+ "'  size = 20 maxlength='10'  value='' onblur='if(this.value.length>0){exclServLookup("+index+",pkg_serv_code"+index+",pkg_serv"+index+");} else{ fnExclClearCode(pkg_serv_code"+index+"); }'><input type='hidden' name='pkg_serv" + index  
		+ "' id='pkg_serv" + index + "' value='' ><input type='button' name='button_pkg_serv_code"
		+ index
		+ "' id='button_pkg_serv_code"
		+ index
		+ "' class='button' value='?' onClick='exclServLookup("+index+",pkg_serv_code"+index+",pkg_serv"+index+");'>"+
		"</td> ";
	cell2.className = 'fields'; 
	cell2.style.whiteSpace = "nowrap"; 
 
	cell3.innerHTML = "<td class='fields' nowrap> "
			+"<input type='text' style='text-align:center;'  name='rate_charge_ind"
			+ index
			+ "' id='rate_charge_ind"
			+ index
			+ "' onblur='ChangeUpperCase( this );' size='10' maxlength='13' readonly >"+
		"</td> ";
	cell3.className = 'fields'; 
	cell3.style.whiteSpace = "nowrap";
	
	cell4.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='checkbox'   name='chk_exclude_all"
		+ index + "' id='chk_exclude_all"
		+ index + "' onClick='handleExclAll(this,\"" + index
		+ "\")' value='N' >"+
			"</td>";
			
	cell4.className = 'fields'; 
	cell4.style.whiteSpace = "nowrap"; 

	cell5.innerHTML = "<td class='fields' nowrap> "
		+"<input type='text' style='text-align:center;' name='qty_limit" + index
		+ "' id='qty_limit" + index
		+ "'  size='10' onBlur='validateExclFactorLmt(document.forms[0].rate_charge_ind"
		+ index
		+ ",this,"+index+",2)' onkeypress='return ChkNumberInput(this,event,\""
		+ "\")'>"+
			"</td>";
	cell5.className = 'fields'; 
	cell5.style.whiteSpace = "nowrap";

	cell6.innerHTML = "<td class='fields' nowrap> "
		+"<select style='width:100px;' name='amt_limit_ind"
		+ index
		+ "' id='amt_limit_ind"
		+ index
		+ "'  onChange='validateExclFactorLmt(document.forms[0].rate_charge_ind"
		+ index
		+ ",this,"+index+",3);'><option value='' selected>"  
		+ getLabel('Common.defaultSelect.label', 'Common')
		+ "</option><option value='A' >"
		+ getLabel('Common.amount.label', 'Common')
		+ "</option><option value='P' >"
		+ getLabel('Common.Percent.label', 'Common')
		+ "</option></select>"+
			"</td>";	
	cell6.className = 'fields'; 
	cell6.style.whiteSpace = "nowrap"; 

	cell7.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='text' style='text-align:center;' name='amt_limit" + index
		+ "' id='amt_limit" + index
		+ "'  size='20' onBlur='validateExclFactorLmt(document.forms[0].rate_charge_ind"
		+ index
		+ ",this,"+index+",4)' onkeypress='return allowValidNumber(this,event,\""
		+ noofdecimal+ "\")'>"+
			"</td>";	
	cell7.className = 'fields'; 
	cell7.style.whiteSpace = "nowrap"; 		

	cell8.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='checkbox'   name='incl_home_medication_yn"
		+ index + "' id='incl_home_medication_yn"
		+ index + "' onClick='chkExclHomeMed(\"" + index
		+ "\")' value='' disabled>"
		+ "<input type='hidden' name='home_med_enable_yn" + index+ "' id='home_med_enable_yn" + index+ "' id='home_med_enable_yn" + index + "' value='N' >"
		+ "</td>";	
	cell8.className = 'fields'; 
	cell8.style.whiteSpace = "nowrap"; 
		
	cell9.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='checkbox'   name='replaceable_yn"
		+ index + "' id='replaceable_yn"
		+ index + "' onClick='chkExclReplacable(this,\"" + index
		+ "\");enableExclReplc(this,\"" + index
		+ "\");' value='N' >"+
			"</td>";	
	cell9.className = 'fields'; 
	cell9.style.whiteSpace = "nowrap";	
	
	cell10.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='text'  name='replaceable_serv_code" + index  
		+ "' id='replaceable_serv_code" + index  
		+ "' size='10' maxlength='10'  value='' onblur='if(this.value.length>0){repExclServLookup("+index+",replaceable_serv_code"+index+",rep_pkg_serv"+index+")} else{ fnExclClearCode(replaceable_serv_code"+index+"); }' disabled> <input type='hidden' name='rep_pkg_serv" + index  
		+ "' id='rep_pkg_serv" + index + "' value='' ><input type='button' name='button_rep_pkg_serv_code"
		+ index
		+ "' id='button_rep_pkg_serv_code"
		+ index
		+ "' class='button' value='?' onClick='repExclServLookup("+index+",replaceable_serv_code"+index+",rep_pkg_serv"+index+")' disabled>"+
		"</td> ";
	cell10.className = 'fields'; 
	//cell10.style.nowrap="nowrap";
	cell10.style.whiteSpace = "nowrap";
	var temp = "<td class='fields' nowrap> "
		+"<select style='width:150px;' name='daily_limit_ind"
		+ index
		+ "' id='daily_limit_ind"
		+ index
		+ "' onChange='dailyExclLmtIndicatorOnChange(this,\""
		+ index
		+ "\") ' "
		+ indicatorFldDisabled
		+ " ><option value='' selected >"
		+ getLabel('Common.defaultSelect.label', 'Common')
		+ "</option>";
	if(p_daily_pkg_serv_lmt == "B" || p_daily_pkg_serv_lmt == "G")
		temp = temp + "<option value='G' >"
		+ getLabel('Common.Group.label', 'Common')
		+ "</option>";
	if(p_daily_pkg_serv_lmt == "B" || p_daily_pkg_serv_lmt == "I")
		temp = temp + "<option value='I' >"
		+ getLabel('eBL.PIPD.label', 'bl')
		+ "</option>";
	
	temp = temp + "</select>"+
			"</td>";

	cell11.innerHTML =  temp;	
	cell11.className = 'fields'; 
	cell11.style.whiteSpace = "nowrap";

	cell12.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='text' style='text-align:center;' name = 'daily_qty_limit" + index
		+ "' id = 'daily_qty_limit" + index
		+ "' size='20' maxlength='3' onBlur='return checkForNegetiveNumber(this,0,\"BL8538\");' "
		+ " onkeypress='return ChkNumberInput(this,event,\""
		+ "\")' "
		+ qtyFldDisabled
		+ " >"+
			"</td>";	
	cell12.className = 'fields'; 
	cell12.style.whiteSpace = "nowrap";
	
	cell13.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='text' style='text-align:center;' name = 'daily_amt_limit" + index
		+ "' id = 'daily_amt_limit" + index
		+ "' size='20' onBlur='return checkForNegetiveNumber(this,0,\"BL8538\");' "
		+ " onkeypress='return allowValidNumber(this,event,\""
		+ noofdecimal+ "\")'  "
		+ amtFldDisabled
		+ " >"
		+"<SELECT  style='width:100px;' NAME='GrossNet" + index
		+ "' id='GrossNet" + index
		+ "' onChange='validateGrossNetInd(this,\"" + index
		+ "\")' "+grossNetDisabled+"><option value='G'>"
		+ getLabel('eBL.Gross.label', 'bl')
		+ "</option><option value='S'>"
		+ getLabel('eBL.Net.label', 'bl')
		+ "</option></select>"+
			"</td>";	
	cell13.className = 'fields'; 
	cell13.style.whiteSpace = "nowrap";

	cell14.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='checkbox'    name='refund_yn"
		+ index + "' id='refund_yn"
		+ index + "' onClick='exclRefundChk(this,\"" + index
		+ "\")' value=\"N\">"+
			"</td>";	
	cell14.className = 'fields'; 
	cell14.style.whiteSpace = "nowrap";

	cell15.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='text' style='text-align:center;' name = 'refund_rate" + index 
		+ "' id = 'refund_rate" + index
		+ "' size='20' maxlength='4' onBlur='validPercentageForRefund(this,\"auto_refund_yn"+index+"\");'"
		+ " onkeypress='return ChkNumberInput(this,event,\""
		+ "\")' value=''  disabled >"+
			"</td>";	
	cell15.className = 'fields'; 
	cell15.style.whiteSpace = "nowrap";
		
	cell16.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='checkbox'    name='auto_refund_yn"
		+ index + "' id='auto_refund_yn"
		+ index + "' onClick='exclAutoRefundChk(\"" + index
		+ "\")' value=\"N\" disabled>"+
			"</td>";	
	cell16.className = 'fields'; 
	cell16.style.whiteSpace = "nowrap";	
	
	cell17.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='checkbox' name='split_allowed_yn" + index
		+ "' id='split_allowed_yn" + index
		+ "' value='N'  onclick='exclSplitChk(\""
		+ index
		+ "\");'>"+
			"</td>";	
	cell17.className = 'fields'; 
	cell17.style.whiteSpace = "nowrap";
	
	cell18.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='checkbox'   name='apply_fact_for_srv_lmt_yn"
		+ index
		+ "' id='apply_fact_for_srv_lmt_yn"
		+ index
		+ "' onClick='applExclFactChk(\""
		+ index
		+ "\")' value='N' disabled >"+
			"</td>";	
	cell18.className = 'fields'; 
	cell18.style.whiteSpace = "nowrap";	
	
	cell19.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='text' name = 'utilized_serv_qty" + index//tex
		+ "' id = 'utilized_serv_qty" + index
		+ "' size='20' maxlength='3' onBlur='return checkForNegetiveNumber(this,0,\"BL8538\");' "
		+ " onkeypress='return allowValidNumber(this,event,10,0);' value=''  disabled >"+
			"</td>";	
	cell19.className = 'fields'; 
	cell19.style.whiteSpace = "nowrap";

	cell20.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='text' name = 'utilized_serv_amt" + index//tex
		+ "' id = 'utilized_serv_amt" + index
		+ "' size='20' onBlur='return checkForNegetiveNumber(this,0,\"BL8538\");' "
		+ " onkeypress='return allowValidNumber(this,event,10,0);' value=''  disabled >"+
			"</td>";	
	cell20.className = 'fields'; 
	cell20.style.whiteSpace = "nowrap";

	cell21.innerHTML =  "<td class='fields' nowrap> "
		+"<input type='checkbox' name='radio" + index
		+ "' id='radio" + index
		+ "' value='' onclick='markRowForDel(this,\""
		+ index
		+ "\");'>"
		+ "<input type='hidden' name='hdn_is_newly_added_row_YN_" + index+ "' id='hdn_is_newly_added_row_YN_" + index+ "' id='hdn_is_newly_added_row_YN_" + index + "' value='Y' >"
		+ "<input type='hidden' name='hdn_row_marked_for_del_" + index+ "' id='hdn_row_marked_for_del_" + index+ "' id='hdn_row_marked_for_del_" + index + "' value='N' >"
		+ "<input type='hidden' name='hdn_rowid" + index+ "' id='hdn_rowid" + index+ "' id='hdn_rowid" + index + "' value='' >"
		+ "<input type='hidden' name='pkg_service_long_desc" + index+ "' id='pkg_service_long_desc" + index+ "' id='pkg_service_long_desc" + index + "' value='' >"
		+ "</td>";	
	cell21.className = 'fields'; 
	cell21.style.whiteSpace = "nowrap";	
	
	formObj.rowcount.value=rowCount;
	
	var total_rec_cnt = formObj.cnt.value;
	
	formObj.cnt.value = parseInt(total_rec_cnt) + 1;
	
}

function checkExclDuplicate(index){   
	var facility_id=document.getElementById("facility_id").value;
	var locale=document.getElementById("locale").value;	
	var dbcnt=document.getElementById("dbcnt").value;	

	var err_id="";
	var hdn_package_code=document.getElementById("hdn_pack_code").value;
	var hdn_package_seq_no=document.getElementById("hdn_pack_seq_no").value;
	var pkgservind=document.getElementById("pkg_serv_ind"+index).value;
	var pkg_serv_code=document.getElementById("pkg_serv_code"+index).value;
	var order_catalog_yn = "N";

$.ajax({
	type : "POST",
	url : "../jsp/MaintainTreatServValidation.jsp?func_mode=chckduplexcl&facility_id="
			+ facility_id + "&hdn_package_code=" + hdn_package_code + "&hdn_package_seq_no="
			+ hdn_package_seq_no + "&pkgservind=" + pkgservind +"&pkg_serv_code="+pkg_serv_code+
			"&p_language_id="+ locale + "&order_catalog_yn=" + order_catalog_yn,
	async : false,
	dataType : "text",
	success : function(data) {
	 try{	
		var n=trimString(data);
		var e=n.indexOf("::");
		var e1=n.indexOf("::",e+1);
		if(e!='-1'){
			   var error_id=n.substring(e+2,e1);
			    //V230221
			   var err_txt=getMessage(error_id, "BL");
			   if(err_txt=="" ||err_txt==null || err_txt=="undefined"){
				  err_txt= getMessage(error_id, "BLEXT")
			   }
			   err_id=error_id;
			   alert(err_txt);
			    //V230221
			 //  alert(getMessage(error_id, "BL"));
			   	document.getElementById("pkg_service_long_desc").value='';	
				document.getElementById("pkg_serv_code"+index).value='';	
				document.getElementById("pkg_serv_code"+index).focus();
			   return false;
			}
			else{
				var error_id="";
				err_id="";
			}
		
		var n1 = n.indexOf("~");
		var n2 = n.indexOf("~",n1+1);
		var n3 = n.indexOf("~",n2+1);
		var n4 = n.indexOf("~",n3+1);
		var n5 = n.indexOf("~",n4+1);
		var n6 = n.indexOf("~",n5+1);
		var n7 = n.indexOf("~",n6+1);
		var n8 = n.indexOf("~",n7+1);
		var n9 = n.indexOf("~",n8+1);
		
		var p_pkg_serv_name     =n.substring(n1+1,n2);
		var p_pkg_serv_status   =n.substring(n2+1,n3);
		var p_rate_charge_ind   =n.substring(n3+1,n4);
		var p_factor_rate_ind   =n.substring(n4+1,n5);
		var p_factor_rate       =n.substring(n5+1,n6);
		var p_home_medication_yn=n.substring(n6+1,n7);
		var p_order_catalog_code=n.substring(n7+1,n8);
		var p_amt_limit_ind     =n.substring(n8+1,n9);

		document.getElementById("rate_charge_ind"+index).value=p_rate_charge_ind;
		
		if(p_rate_charge_ind=='C'){
			document.getElementById("qty_limit"+index).value="";
			document.getElementById("qty_limit"+index).readOnly=true;
		}else{
			document.getElementById("qty_limit"+index).readOnly=false;
		}
	
		if(p_home_medication_yn=='Y'){ 
			document.getElementById("home_med_enable_yn"+index).value="Y";		
			document.getElementById("incl_home_medication_yn"+index).disabled=false;
		}else{
			document.getElementById("home_med_enable_yn"+index).value="N";			
			document.getElementById("incl_home_medication_yn"+index).disabled=true;
			document.getElementById("incl_home_medication_yn"+index).value="N";
			document.getElementById("incl_home_medication_yn"+index).checked=false;
		}

		if(p_amt_limit_ind != "null" && p_amt_limit_ind != "")
			document.getElementById("amt_limit"+index).value = p_amt_limit_ind;
	 }catch(ex){
		 alert("exception in servDuplValidation "+ex.message);
	 }
	},
	 error: function(data){
		 alert("Error in servvalidation  "+String(data));
	 }
});
var dbct=dbcnt++;

if(err_id==""){
	if(index>dbct){
		newRowDuplicatechck(dbcnt,index,pkg_serv_code);
	}
}

	
}

function newRowDuplicatechck(dbcnt,index,pkg_serv_code){

	if( pkg_serv_code!=""){
		for(var m=1;m<index;m++){
			var pkgservcode=document.getElementById("pkg_serv_code"+m).value;
			if(pkg_serv_code==pkgservcode){
				alert(getMessage("BL0931", "BLEXT"));
				document.getElementById("pkg_service_long_desc").value='';	
				document.getElementById("pkg_serv_code"+index).value='';	
				document.getElementById("pkg_serv_code"+index).focus();
				return false;
			}  
		}
	}
}

async function repExclServLookup(index,code,obj){
	var pkgservind=document.getElementById("pkg_serv_ind"+index).value;
	var locale  = document.forms[0].locale.value;	
	
	var title ="";
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	if(pkgservind=='S'){
		title = "List of Billing Services";
	}else if(pkgservind=='C'){
		title = "List of Service Classifications";
	}else if(pkgservind=='G'){
		title = "List of Service Groups";
	}else if(pkgservind=='P'){
		title = "List of Package Groups";
	}else{
		title = "List of Items";
	}
	
	var sql="select description, code  from (SELECT short_desc description,serv_code code FROM (SELECT a.short_desc short_desc,a.blng_serv_code serv_code,'S' pkg_serv_ind,a.language_id lang_id "+
    "FROM bl_blng_serv_lang_vw a, bl_blng_serv b WHERE a.blng_serv_code = b.blng_serv_code AND nvl(b.status,'X') != 'S' "+
     "AND a.language_id = '"+locale+"' UNION SELECT a.short_desc short_desc,a.serv_grp_code serv_code,'G' pkg_serv_ind,"+
     "a.language_id lang_id FROM bl_blng_serv_grp_lang_vw a, bl_blng_serv_grp b  WHERE a.serv_grp_code = b.serv_grp_code AND nvl(b.status,'X') != 'S'"+
     "  AND a.language_id = '"+locale+"' UNION SELECT a.short_desc short_desc,a.serv_classification_code serv_code,'C' pkg_serv_ind,"+
     "a.language_id lang_id FROM bl_serv_classification_lang_vw a, bl_serv_classification b WHERE a.serv_classification_code = b.serv_classification_code"+
      " AND nvl(b.status,'X') != 'S' AND a.language_id = '"+locale+"' UNION "+
    "SELECT SHORT_DESC short_desc,PACKAGE_SERV_GROUP_CODE serv_code,'P' pkg_serv_ind,'en' lang_id  FROM bl_package_serv_group_hdr"+
   " union SELECT b.SHORT_DESC SHORT_DESC,b.ITEM_CODE serv_code,'M' pkg_serv_ind, b.language_id lang_id FROM bl_st_item a, mm_item_lang_vw b"+
    " WHERE a.item_code = b.item_code AND b.language_id = '"+locale+"') WHERE pkg_serv_ind = '"+pkgservind+"') where upper(description) like upper(?) "+
    "and upper(code) like upper(?)  order by 2";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";

	argumentArray[5] = code.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues = await CommonLookup(title, argumentArray);
	if ((returnedValues != null) && (returnedValues != "")) {
		var str =unescape(returnedValues);
		var arr = str.split(",");
		obj.value = arr[1];
		code.value = arr[0];
	} else {
		obj.value = '';
		code.value = '';
	}
}

function chkExclReplacable(val,index){
	var repl_chk=document.getElementById("replaceable_yn"+index).checked;
	if(repl_chk==true){
		repl_chk='Y';
	}else{
		repl_chk='N';
	}

	var pkgservind=document.getElementById("pkg_serv_ind"+index).value;
	var ratechrgind=document.getElementById("rate_charge_ind"+index).value;

	if(repl_chk=='Y' && pkgservind!='S'){
		document.getElementById("replaceable_yn"+index).value='N';
		document.getElementById("replaceable_yn"+index).checked=false;
		alert(getMessage("BL8546", "BL"));
		return false;
	}
	if(repl_chk=='Y' && ratechrgind!='R'){
		document.getElementById("replaceable_yn"+index).value='N';
		document.getElementById("replaceable_yn"+index).checked=false;
		
		alert(getMessage("BL8654", "BLEXT"));
		return false;
	}else if(repl_chk=='N'){
		document.getElementById("replaceable_yn"+index).value='N';		
	} else {
		document.getElementById("replaceable_yn"+index).value='Y';
	}
}

function enableExclReplc(val,index){
	var chcked=document.getElementById("replaceable_yn"+index).checked;
	if(chcked=='true' || chcked==true){
		chck='Y';
	}else{
		chck='N';
	}

	if(chck=='Y'){
		document.getElementById("replaceable_serv_code"+index).disabled=false;
		document.getElementById("button_rep_pkg_serv_code"+index).disabled=false;
	}else if(chck=='Y'){
		document.getElementById("replaceable_serv_code"+index).disabled=false;
		document.getElementById("button_rep_pkg_serv_code"+index).disabled=false;
	}else if(chck=='N'){
		document.getElementById("replaceable_serv_code"+index).value="";
		document.getElementById("replaceable_serv_code"+index).disabled=true;
		document.getElementById("button_rep_pkg_serv_code"+index).disabled=true;
	}
}

function handleExclAll(obj, index){
	if(obj.checked)
		document.getElementById("chk_exclude_all"+index).value = "Y";
	else
		document.getElementById("chk_exclude_all"+index).value = "N";
	
	if(obj.checked){
		document.getElementById("qty_limit"+index).value = "";
		document.getElementById("qty_limit"+index).readOnly = true;
		document.getElementById("amt_limit"+index).value = "";
		document.getElementById("amt_limit"+index).readOnly = true;
		document.getElementById("amt_limit_ind"+index).value = "";
		document.getElementById("amt_limit_ind"+index).disabled = true;
		
		document.getElementById("incl_home_medication_yn"+index).value = "N";
		document.getElementById("incl_home_medication_yn"+index).checked = false;
		document.getElementById("incl_home_medication_yn"+index).disabled = true;
		
		document.getElementById("replaceable_yn"+index).checked = false;
		chkExclReplacable(document.getElementById("replaceable_yn"+index),index)
		enableExclReplc(document.getElementById("replaceable_yn"+index),index);	
		document.getElementById("replaceable_yn"+index).disabled = true;

		var pkg_serv_lmt_YN = document.getElementById("pkg_serv_lmt_YN").value;
		
		if(pkg_serv_lmt_YN == "Y"){
			document.getElementById("daily_limit_ind"+index).value = "";
			dailyExclLmtIndicatorOnChange(document.getElementById("daily_limit_ind"+index),index);			
			document.getElementById("daily_limit_ind"+index).disabled = true;
		}
		
	} else {
		document.getElementById("qty_limit"+index).readOnly = false;
		document.getElementById("amt_limit"+index).readOnly = false;
		document.getElementById("amt_limit_ind"+index).disabled = false;
		
		if(document.getElementById("home_med_enable_yn"+index).value == "Y")
			document.getElementById("incl_home_medication_yn"+index).disabled = false;
		
		document.getElementById("replaceable_yn"+index).checked = false;
		document.getElementById("replaceable_yn"+index).disabled = false;
		
		var pkg_serv_lmt_YN = document.getElementById("pkg_serv_lmt_YN").value;
		
		if(pkg_serv_lmt_YN == "Y"){
			document.getElementById("daily_limit_ind"+index).value = "";
			document.getElementById("daily_limit_ind"+index).disabled = false;
			dailyExclLmtIndicatorOnChange(document.getElementById("daily_limit_ind"+index),index);			
		}
	}
		
}

function markRowForDel(obj, index){
	if(obj.checked)
		document.getElementById("hdn_row_marked_for_del_"+index).value = "Y";
	else
		document.getElementById("hdn_row_marked_for_del_"+index).value = "N";
}

function applExclFactChk(index){
	var refn_chk=document.getElementById("apply_fact_for_srv_lmt_yn"+index).checked;
	
	if(refn_chk==true){
		document.getElementById("apply_fact_for_srv_lmt_yn"+index).value='Y';
	}else{
		document.getElementById("apply_fact_for_srv_lmt_yn"+index).value='N';
	}
}

function exclSplitChk(index){
	var refn_chk=document.getElementById("split_allowed_yn"+index).checked;
	
	if(refn_chk==true){
		document.getElementById("split_allowed_yn"+index).value='Y';
	}else{
		document.getElementById("split_allowed_yn"+index).value='N';
	}
}

function exclRefundChk(val,index){
	var refn_chk=document.getElementById("refund_yn"+index).checked;
	
	if(refn_chk==true){
		document.getElementById("refund_yn"+index).value='Y';
		document.getElementById("refund_rate"+index).disabled=false;
		document.getElementById("auto_refund_yn"+index).disabled=false;
		document.getElementById("refund_rate"+index).focus();
	}else{
		document.getElementById("refund_yn"+index).value='N';
		document.getElementById("refund_rate"+index).value='';
		document.getElementById("refund_rate"+index).disabled=true;
		document.getElementById("auto_refund_yn"+index).checked=false;
		document.getElementById("auto_refund_yn"+index).disabled=true;					
		document.getElementById("auto_refund_yn"+index).value='N';	
	}
}

function validPercentageForRefund(obj, autoRefundAmtObj) {
	var refundRate = parseFloat(obj.value);

	if (obj.value == "" || obj.value == '0') {
		eval("document.forms[0]." + autoRefundAmtObj).value = "N";
		eval("document.forms[0]." + autoRefundAmtObj).checked = false;		
	}
	if (refundRate > 100.00 || refundRate < 1) {
		alert(getMessage("BL8653", "BL"));
		obj.value = "";
		eval("document.forms[0]." + autoRefundAmtObj).value = "N";
		eval("document.forms[0]." + autoRefundAmtObj).checked = false;
		obj.focus();
		return false;
	}
}

function exclAutoRefundChk(index){
	var refn_chk=document.getElementById("auto_refund_yn"+index).checked;
	var refund_rate = document.getElementById("refund_rate"+index).value;
	
	if(refund_rate == "" && refn_chk == true){
		document.getElementById("auto_refund_yn"+index).checked = false;
		return false;		
	}
	
	if(refn_chk==true){
		document.getElementById("auto_refund_yn"+index).value='Y';
	}else{
		document.getElementById("auto_refund_yn"+index).value='N';
	}
}

function validateExclFactorLmt(rateind,val,index,called){
	var chk_exclude_all = document.getElementById('chk_exclude_all'+index).value;
	if(chk_exclude_all != "Y") {
		if(rateind.value=='R'){
			if(called == "1"){
				if(val.value==''){
					alert(getMessage("BL8536", "BL"));
					document.getElementById("factor_rate"+index).focus();
					return false;
				}
			}
			else if(called == "2"){
				//var facRate=document.getElementById("factor_rate"+index).value;
				//alert("facRate "+facRate);
				
				if(val.value == ''){
					var amt_limit_ind=document.getElementById("amt_limit_ind"+index).value; //amt_limit_ind    A P U ""
					var amt_limit=document.getElementById("amt_limit"+index).value; //amt_limit
				//	alert(amt_limit_ind);
					if(amt_limit_ind=='A'){
						if(amt_limit==""){
							alert(getMessage("BL8541", "BL"));
							//document.getElementById("amt_limit"+index).focus();
							return false;
						}
					}else if(amt_limit_ind == 'P'){
						if(amt_limit==""){
							alert(getMessage("BL8541", "BL"));
							//document.getElementById("amt_limit"+index).focus();
							return false;
						}else if(amt_limit<0 || amt_limit>100){ 
							alert(getMessage("BL8539", "BL"));
							document.getElementById("amt_limit"+index).value="";
							document.getElementById("amt_limit"+index).focus();
							return false;
						}
					}else if(amt_limit_ind=='U'){
						document.getElementById("qty_limit"+index).value="";
						document.getElementById("amt_limit"+index).value="";
						return false;
						//document.getElementById("amt_limit"+index).focus();
					}					
				}
				else if(val.value!=''){
					return false;
				}
			}else if(called == "3"){ //amtlmtind 
				/* var facRate=document.getElementById("factor_rate"+index).value;
			//	alert("facRate "+facRate);
				if(facRate==''){
					alert(getMessage("BL8536", "BL"));
					document.getElementById("factor_rate"+index).focus();
					return false;
				}else */
				if(val.value==''){				
					document.getElementById("amt_limit"+index).value = '';
				
					/*var qty_limit=document.getElementById("qty_limit"+index).value;
					if(qty_limit==''){
						alert(getMessage("BL8541", "BL"));
						return false;
					}*/
				}else if(val.value!=''){
					
					var amt_limit=document.getElementById("amt_limit"+index).value; //amt_limit
					var amt_limit_ind=document.getElementById("amt_limit_ind"+index).value; //amt_limit_ind    A P U ""
					var qty_limit=document.getElementById("qty_limit"+index).value;
					
					if((amt_limit_ind == 'A' || amt_limit_ind == 'P') && amt_limit == ''){
							alert(getMessage("BL8561", "BL"));
							return false;
					}

					if(amt_limit_ind == 'P'){
						if(amt_limit<0 || amt_limit>100){ 
							alert(getMessage("BL8539", "BL"));
							document.getElementById("amt_limit"+index).value="";
							document.getElementById("amt_limit"+index).focus();
							return false;
						}
					} else if(amt_limit_ind == 'A'){
						if(amt_limit == 0){ 
							alert(getMessage("BL8552","BL"));
							document.getElementById("amt_limit"+index).value="";
							document.getElementById("amt_limit"+index).focus();
							return false;
						}
					}
				}

			}else if(called == "4"){ //amtlmt 
				/* var facRate=document.getElementById("factor_rate"+index).value;

				if(facRate==''){
					alert(getMessage("BL8536", "BL"));
					document.getElementById("factor_rate"+index).focus();
					return false;
				}*/
				var amt_limit_ind=document.getElementById("amt_limit_ind"+index).value; //amt_limit_ind
				var qtylmt= document.getElementById("qty_limit"+index).value;
				var amt_limit=document.getElementById("amt_limit"+index).value; //amt_limit
			
				if((amt_limit_ind == 'P' || amt_limit_ind == 'A') && amt_limit == ''){
					alert(getMessage("BL8561", "BL"));
					//document.getElementById("amt_limit"+index).focus();
					return false;
				} else if(amt_limit_ind == 'P'){
					if(amt_limit<0 || amt_limit>100){ 
						alert(getMessage("BL8539", "BL"));
						document.getElementById("amt_limit"+index).value="";
						return false;
					}
				} else if(amt_limit_ind == 'A'){
					if(amt_limit == 0){ 
						alert(getMessage("BL8552","BL"));
						document.getElementById("amt_limit"+index).value="";
						return false;
					}
				}
			}
		}else if(rateind.value=='C'){
			if(called=="3"){
				var amt_limit_ind=document.getElementById("amt_limit_ind"+index).value;
				if(amt_limit_ind != ''){
					var amt_limit=document.getElementById("amt_limit"+index).value; //amt_limit
					if(amt_limit_ind == 'A'){
						if(amt_limit == ""){
							alert(getMessage("BL8561", "BL"));
							//document.getElementById("amt_limit"+index).focus();
							return false;
						}
					}else if(amt_limit_ind == 'P'){
						if(amt_limit == ""){
							alert(getMessage("BL8561", "BL"));
							//document.getElementById("amt_limit"+index).focus();
							return false;
						}else if(amt_limit<0 || amt_limit>100){ 
							alert(getMessage("BL8539", "BL"));
							document.getElementById("amt_limit"+index).value="";
							document.getElementById("amt_limit"+index).focus();
							return false;
						}
					}else if(amt_limit_ind=='U'){
						document.getElementById("amt_limit"+index).value = "";
						document.getElementById("amt_limit"+index).readonly = true;
						return false;
						//document.getElementById("amt_limit"+index).focus();
					}
				} else{
					document.getElementById("amt_limit"+index).value = '';	
				}			
			}
			if(called=="4"){
				var amt_limit_ind=document.getElementById("amt_limit_ind"+index).value; //amt_limit_ind
				if(amt_limit_ind !=''){
					var amt_limit=document.getElementById("amt_limit"+index).value; //amt_limit
					if(amt_limit_ind == 'A'){
						if(amt_limit == ""){
							alert(getMessage("BL8561", "BL"));
							//document.getElementById("amt_limit"+index).focus();
							return false;
						}
						if(amt_limit == "0"){
							alert(getMessage("BL8552","BL"));
							document.getElementById("amt_limit"+index).value="";
							return false;
						}						
					}else if(amt_limit_ind == 'P'){
						if(amt_limit == ""){
							alert(getMessage("BL8561", "BL"));
							//document.getElementById("amt_limit"+index).focus();
							return false;
						}else if(amt_limit<0 || amt_limit>100){ 
							alert(getMessage("BL8539", "BL"));
							document.getElementById("amt_limit"+index).value="";
							document.getElementById("amt_limit"+index).focus();
							return false;
						}
					}else if(amt_limit_ind=='U'){
						document.getElementById("amt_limit"+index).value="";
						return false;
						//document.getElementById("amt_limit"+index).focus();
					}
				}else{
					document.getElementById("amt_limit"+index).value = '';	
				}
			}
		}
	}
	return true;
}

function fnExclClearCode(obj){
	obj.value = '';
}

function chkExclHomeMed(index){
	var repl_chk=document.getElementById("incl_home_medication_yn"+index).checked;
	if(repl_chk==true){
		//repl_chk='Y';
		document.getElementById("incl_home_medication_yn"+index).value='Y';
	}else{
		//repl_chk='N';
		document.getElementById("incl_home_medication_yn"+index).value='N';
	}
}

function dailyExclLmtIndicatorOnChange(value,index){
	var daily_lmt_ind=document.getElementById("daily_limit_ind"+index).value;
	var amtFldDisabled=document.getElementById("amtFldDisabled").value;
	var qtyFldDisabled=document.getElementById("qtyFldDisabled").value;
	var grossNetDisabled=document.getElementById("grossNetDisabled").value;
	
	if(daily_lmt_ind==""){
		document.getElementById("daily_qty_limit"+index).disabled=true;
		document.getElementById("daily_amt_limit"+index).disabled=true;
		document.getElementById("daily_qty_limit"+index).value='';
		document.getElementById("daily_amt_limit"+index).value='';
		document.getElementById("GrossNet"+index).disabled=true;
	}else{
		if(qtyFldDisabled == '')
			document.getElementById("daily_qty_limit"+index).disabled=false;
		if(amtFldDisabled == ''){
			document.getElementById("daily_amt_limit"+index).disabled=false;
			document.getElementById("GrossNet"+index).disabled=false;
		}
	}
}

function validPercentage(obj, type) {
	var discPer = parseFloat(obj.value);

	if (discPer > 100.00 || discPer <= 0) {
		if (type == 'P')
			alert(getMessage("BL8664", "BL"));
		else
			alert(getMessage("BL8539", "BL"));
		obj.value = "";
		obj.focus();
		return false;
	}
}

function showExclPackageServiceDesc(index,servDes){
	document.getElementById('pkg_service_long_desc').value=servDes;
}

function disableExclForAuthorisation(pkgServLmtDtlsPrivYN){
	
	if(pkgServLmtDtlsPrivYN == "N") {
		var form = document.getElementById("MaintainTreatmentPkgExclForm");
		var elements = form.elements;
		for (var i = 0, len = elements.length; i < len; ++i) {
			if(elements[i].id != 'Close')
				elements[i].disabled = true;
		}
	}	
}

