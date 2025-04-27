


function loadClassificationDetails(rowNo)
{
	
	var pdoc=parent.PayerSpecClaimSplittingClaimsFrame.document.forms[0];
	var tbl = pdoc.parentNode.document.getElementById('tblType');
	
	var frm = parent.frames[1].document.forms[0];
	var prevClicked = document.forms[0].prevClicked.value;
	var rowClicked = document.forms[0].rowClicked.value;
	
	
	var payerGroup=document.forms[0].payerGroup.value;
	var payer=document.forms[0].payer.value;
	var policy=document.forms[0].policy.value;
	var claimType=pdoc.document.getElementById("claimTypeCode_"+rowNo).value;
	var classifcationName= document.getElementById("cName_"+rowNo).value;
	
	if(classifcationName=='' || classifcationName==claimType){
		classifcationName=claimType;
	
		var eAll= document.getElementById("all_"+rowNo).value;
		var eIP= document.getElementById("appl_ip_"+rowNo).value;
		var eOP= document.getElementById("appl_op_"+rowNo).value;
		var eDC= document.getElementById("appl_dc_"+rowNo).value;
		var eEM= document.getElementById("appl_em_"+rowNo).value;
		if(eAll=='Y'){
			classifcationName+="-All";
							
		}else{
			if(eIP=='Y') classifcationName+="-IP";
			if(eOP=='Y') classifcationName+="-OP";
			if(eDC=='Y') classifcationName+="-DC";
			if(eEM=='Y') classifcationName+="-EM";
		}
		
		document.getElementById("cName_"+rowNo).value=classifcationName;		
	}


	var facility_id = frm.facility_id.value;
	
	if(claimType==''){
					alert("Claim Type Cannot be empty");
					return;
	}else if(classifcationName==claimType){
					alert("You must select at least one episode type");
					return;
	}else{
			if(validateServiceRows()){
				addServiceRowPersist();
				if(prevClicked == 'Y'){
				if(rowClicked != rowNo){				

						for(var i=0;i<7;i++){
							if(document.getElementById('td_'+rowClicked+'_'+i)!=null){
									document.getElementById('td_'+rowClicked+'_'+i).style.background =  "White";
									document.getElementById('td_'+rowClicked+'_'+i).className =  "fields";
							}

						}
			
						for(var i=0;i<7;i++){
							
							document.getElementById('td_'+rowNo+'_'+i).style.background =  "YELLOW";
						}
						document.forms[0].prevClicked.value = 'Y';
						parent.PayerSpecClaimSplittingClassFrame.document.location.href = "../../eBL/jsp/BLInsRCMPayerSpecClaimSplittingClassFrame.jsp?facility_id="+facility_id+"&mode=modify"+"&payer="+payer+"&payergroup="+payerGroup+"&claimType="+claimType+"&classifcationName="+classifcationName+"&policy="+policy;					
						
						
							
				}
				
			}
			else if(prevClicked == 'N'){
					document.forms[0].prevClicked.value = 'Y';
					

					for(var i=0;i<7;i++){
							document.getElementById('td_'+rowNo+'_'+i).style.background =  "YELLOW";	
					}
						parent.PayerSpecClaimSplittingClassFrame.document.location.href = "../../eBL/jsp/BLInsRCMPayerSpecClaimSplittingClassFrame.jsp?facility_id="+facility_id+"&mode=modify"+"&payer="+payer+"&payergroup="+payerGroup+"&claimType="+claimType+"&classifcationName="+classifcationName+"&policy="+policy;
					
			}
			
			document.forms[0].rowClicked.value = rowNo;
			}
	}
}
function deleteServiceRow(button) {
	var pdoc=parent.PayerSpecClaimSplittingClassFrame.document.forms[0];
	var parts= button.name.split("_");
	var index =parts[1];
	var cName= document.getElementById("sName").value;
	var blngServCode= document.getElementById("bg_code_"+index).value;
	
	var xmlStr = "<root><SEARCH ";
            xmlStr += " /></root>";
    var temp_jsp = "../../eBL/jsp/BLInsRCMPayerSpecClaimSplittingPersistence.jsp?func_mode=deleteServiceRow&cName=" +
                cName +"&blngServCode="+ blngServCode;
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
   
	xmlHttp.open("POST", temp_jsp, false);

	xmlHttp.send(xmlDoc);
    var row = button.parentNode.parentNode;
	row.parentNode.removeChild(row); 
	var l=Number(pdoc.parentNode.document.getElementById('serviceRowCount').value);
	l--;
	pdoc.parentNode.document.getElementById('serviceRowCount').value=l;
	changeServiceSerialNumber();
}

function deleteTypeRow(button) {
	
	var pdoc=parent.PayerSpecClaimSplittingClaimsFrame.document.forms[0];
	var parts= button.name.split("_");
	var index =parts[1];
	
	var cName= document.getElementById("cName_"+index).value;
	var xmlStr = "<root><SEARCH ";
            xmlStr += " /></root>";
    var temp_jsp = "../../eBL/jsp/BLInsRCMPayerSpecClaimSplittingPersistence.jsp?func_mode=deleteClaimType&cName=" +
                cName;
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
   
	xmlHttp.open("POST", temp_jsp, false);

	xmlHttp.send(xmlDoc);
	
	var row = button.parentNode.parentNode;
	row.parentNode.removeChild(row); 
	var l=Number(pdoc.parentNode.document.getElementById('typeRowCount').value);
	l--;
	pdoc.parentNode.document.getElementById('typeRowCount').value=l;
	
	var rowClicked = document.forms[0].rowClicked.value;
	if(rowClicked==index){
		parent.PayerSpecClaimSplittingClassFrame.document.location.href="../../eCommon/html/blank.html";
		document.forms[0].prevClicked.value = 'N';
	}
	changeTypeSerialNumber();
	
	
}





function clearField(obj){
	obj.value = '';
}


function callBGDesc(sqlSelect, drop, obj, code, obj1) {
	
    var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility_id.value;

    var argumentArray = new Array();
    var dataNameArray = new Array();
    var dataValueArray = new Array();
    var dataTypeArray = new Array();
    var sql = '';
    var title = '';
    var validCheck='';
    // alert(sqlSelect);
    switch (sqlSelect) {
        case 1:
            {
                var cn = drop.value;
                // alert(cn);
                if (cn == 'C') {
                    sql = "Select description, code from (select short_desc description,clinic_code code from OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '" +
                        locale +
                        "' AND FACILITY_ID = '" +
                        facility_id +
                        "' AND NVL(EFF_STATUS,'D') = 'E' Union Select 'All Clinic','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Clinic';
                } else if (cn == 'N') {
                    sql = "Select description, code from (SELECT LONG_DESC DESCRIPTION, NURSING_UNIT_CODE CODE  FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='" +
                        locale +
                        "' AND  FACILITY_ID = '" +
                        facility_id +
                        "' AND NVL(EFF_STATUS,'D') = 'E' Union Select 'All Nursing Unit','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Nursing Unit';
                } else if (cn == 'A') {
                    sql = "Select description, code from (Select 'All Clinic/ Nursing Unit' DESCRIPTION,'**' CODE From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Clinic / Nursing Unit';
                }

                break;
            }

        case 2:
            {
                var criteria = drop.value;
                if (criteria == 'S') {
                    sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(language_id) = upper('" +
                        locale +
                        "')) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";//V211202
                    title = 'Billing Services';
                } else if (criteria == 'BSG') {
                    sql = "Select description, code from (SELECT short_desc description,SERV_GRP_CODE CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE upper(language_id) = upper('" +
                        locale +
                        "') ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";//V211202
                    title = 'Billing Service Group';
                } else if (criteria == 'BSGC') {
                    sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE  upper(language_id) = upper('" +
                        locale +
                        "')  ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";//V211202
                    title = 'Billing Classification';
                } else if (criteria == 'ESG') {
                    sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE CODE FROM BL_BLNG_PRT_GRP_HDR_LANG_VW WHERE upper(language_id) = upper('" +
                        locale +
                        "') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Enterprise Service Group';
                } else if (criteria == 'ESGL') {
                    sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE||PRT_GRP_LINE_CODE CODE FROM BL_BLNG_PRT_GRP_LINE_LANG_VW WHERE upper(language_id) = upper('" +
                        locale +
                        "') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Enterprise Service Group Line';
                } else if (criteria == 'PG') {
                    sql = "Select description, code from (select short_desc description,package_serv_group_code CODE from bl_package_serv_group_hdr where OPERATING_FACILITY_ID = '"+facility_id+"' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2"; //V211130
                    title = 'Package Group';
                } else if (criteria == 'M') {
                    sql = "Select description, code from (SELECT short_desc description,item_code CODE FROM mm_item_lang_vw WHERE upper(language_id) = upper('" +
                        locale +
                        "')  ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";//V211202
                    title = 'Material Item';
                } else if (criteria == 'T') {
                    sql = "Select description, code from (select short_desc description,sale_category_code CODE from bl_st_item_sale_catg_hdr Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Sale Category';
                } else if (criteria == 'P') {
                    sql = "Select description, code from (select short_desc description,package_code CODE from BL_PACKAGE_LANG_VW WHERE upper(language_id) = upper('" +
                        locale +
                        "') AND OPERATING_FACILITY_ID = '" +
                        facility_id +
                        "' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Package';
                }

                break;
            }

    }

  
    argumentArray[0] = sql;
    argumentArray[1] = dataNameArray;
    argumentArray[2] = dataValueArray;
    argumentArray[3] = dataTypeArray;
    argumentArray[4] = "2,1";
    argumentArray[5] = obj.value;
    argumentArray[6] = DESC_LINK;
    argumentArray[7] = DESC_CODE;

    returnedValues = CommonLookup(title, argumentArray);
    if ((returnedValues != null) && (returnedValues != "")) {
        obj.value = returnedValues[1];
        code.value = returnedValues[0];
    } else {
        obj.value = '';
        code.value = '';
        
    }
}

function callBGDescCode(sqlSelect, drop, obj, code, obj1) {
	
    var locale = document.forms[0].locale.value;
    var facility_id = document.forms[0].facility_id.value;
   
    var argumentArray = new Array();
    var dataNameArray = new Array();
    var dataValueArray = new Array();
    var dataTypeArray = new Array();
    var sql = '';
    var title = '';
    var validCheck='';
	

    switch (sqlSelect) {
        case 1:
            {
                var cn = drop.value;
                // alert(cn);
                if (cn == 'C') {
                    sql = "Select description, code from (select short_desc description,clinic_code code from OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '" +
                        locale +
                        "' AND FACILITY_ID = '" +
                        facility_id +
                        "' AND NVL(EFF_STATUS,'D') = 'E' Union Select 'All Clinic','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Clinic';
                } else if (cn == 'N') {
                    sql = "Select description, code from (SELECT LONG_DESC DESCRIPTION, NURSING_UNIT_CODE CODE  FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='" +
                        locale +
                        "' AND  FACILITY_ID = '" +
                        facility_id +
                        "' AND NVL(EFF_STATUS,'D') = 'E' Union Select 'All Nursing Unit','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Nursing Unit';
                } else if (cn == 'A') {
                    sql = "Select description, code from (Select 'All Clinic/ Nursing Unit' description,'**' code From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Clinic / Nursing Unit';
                }

                break;
            }

        case 2:
            {
                var criteria = drop.value;
                if (criteria == 'S') {
                    sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(language_id) = upper('" +
                        locale +
                        "') ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Billing Services';
                } else if (criteria == 'BSG') {
                    sql = "Select description, code from (SELECT short_desc description,SERV_GRP_CODE CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE upper(language_id) = upper('" +
                        locale +
                        "')) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Billing Service Group';
                } else if (criteria == 'BSGC') {
                    sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE  upper(language_id) = upper('" +
                        locale +
                        "')  ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Billing Classification';
                } else if (criteria == 'ESG') {
                    sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE CODE FROM BL_BLNG_PRT_GRP_HDR_LANG_VW WHERE upper(language_id) = upper('" +
                        locale +
                        "')) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Enterprise Service Group';
                } else if (criteria == 'ESGL') {
                    sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE||PRT_GRP_LINE_CODE CODE FROM BL_BLNG_PRT_GRP_LINE_LANG_VW WHERE upper(language_id) = upper('" +
                        locale +
                        "')) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Enterprise Service Group Line';
                } else if (criteria == 'PG') {
                    sql = "Select description, code from (select short_desc description,package_serv_group_code CODE from bl_package_serv_group_hdr where OPERATING_FACILITY_ID = '"+facility_id+"' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2"; //V211130
                    title = 'Package Group';
                } else if (criteria == 'M') {
                    sql = "Select description, code from (SELECT short_desc description,item_code CODE FROM mm_item_lang_vw WHERE upper(language_id) = upper('" +
                        locale +
                        "') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Material Item';
                } else if (criteria == 'T') {
                    sql = "Select description, code from (select short_desc description,sale_category_code CODE from bl_st_item_sale_catg_hdr Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Sale Category';
                } else if (criteria == 'P') {
                    sql = "Select description, code from (select short_desc description,package_code CODE from BL_PACKAGE_LANG_VW WHERE upper(language_id) = upper('" +
                        locale +
                        "') AND OPERATING_FACILITY_ID = '" +
                        facility_id +
                        "'  ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
                    title = 'Package';
                }

                break;
            }

    }

    argumentArray[0] = sql;
    argumentArray[1] = dataNameArray;
    argumentArray[2] = dataValueArray;
    argumentArray[3] = dataTypeArray;
    argumentArray[4] = "1,2";
    argumentArray[5] = code.value;
    argumentArray[6] = CODE_LINK;
    argumentArray[7] = DESC_CODE;
	

    returnedValues = CommonLookup(title, argumentArray);
    if ((returnedValues != null) && (returnedValues != "")) {
        obj.value = returnedValues[1];
        code.value = returnedValues[0];
    } else {

           obj.value = '';
           code.value = '';
        

    }
}





function clearBillingService(obj) {
    var bgCode = 'bg_code_' + obj;
    var bgDesc = 'bg_desc_' + obj;
    document.getElementById(bgCode).value = '';
    document.getElementById(bgDesc).value = '';
}


function validateAndchangeAll(obj){
	
	
	var parts= obj.name.split("_");
	var index =parts[1];
	var flag= false;
	
	var pdoc=parent.PayerSpecClaimSplittingClaimsFrame.document.forms[0];
	var idx=1;
	var tbl = pdoc.parentNode.document.getElementById('tblType');
	var total=tbl.rows.length-1;
	
	if(obj.value=="N" || obj.value=="" || obj.value==null){
		if(total>1){
			
			for(var i=1;i<tbl.rows.length;i++){
				
				while(document.getElementById("claimTypeCode_"+idx)==null){
					idx++;
				}
				
				if(index!=idx){		
					if(document.getElementById('claimTypeCode_'+idx).value==document.getElementById('claimTypeCode_'+index).value){
					var f=false;
					
					if(document.getElementById('appl_ip_'+idx).value=='Y') f=true;
					if(document.getElementById('appl_op_'+idx).value=='Y') f=true;
					if(document.getElementById('appl_dc_'+idx).value=='Y') f=true;
					if(document.getElementById('appl_em_'+idx).value=='Y') f=true;
					if(f){
						flag=true;
						alert("Claim Type Configuration Cannot be Duplicated for the same Episode Type");
						break;

						}
					}
				}

					idx++;
			}
			if(flag){
				document.getElementById('all_'+index).value='N';
				document.getElementById('all_'+index).checked=false;
				
			}else{
				var flag1=false;
				var ix=1;
				for(var i=1;i<tbl.rows.length;i++){
					f=false;
					while(document.getElementById('appl_ip_'+ix)==null){
						ix++;
					}
					if(index!=ix){
					
						if(document.getElementById('appl_ip_'+ix).value=='Y') f=true;
						if(document.getElementById('appl_op_'+ix).value=='Y') f=true;
						if(document.getElementById('appl_dc_'+ix).value=='Y') f=true;
						if(document.getElementById('appl_em_'+ix).value=='Y') f=true;
						if(f&&document.getElementById('dfltClaimType_'+ix).value=='Y'){
							alert("Default Claim Type Cannot be Duplicated for the same episode type");
							flag1=true;
							break;
						}
					}
					ix++;
							
				}
				if(flag1){
					document.getElementById('all_'+index).value='N';
					document.getElementById('all_'+index).checked=false;	
				}else{
						
					document.getElementById('all_'+index).value='Y';
					document.getElementById('all_'+index).checked=true;
					document.getElementById('appl_ip_'+index).value='Y';
					document.getElementById('appl_ip_'+index).checked=true;

					document.getElementById('appl_op_'+index).value='Y';
					document.getElementById('appl_op_'+index).checked=true;
					
					document.getElementById('appl_dc_'+index).value='Y';
					document.getElementById('appl_dc_'+index).checked=true;
					
					document.getElementById('appl_em_'+index).value='Y';
					document.getElementById('appl_em_'+index).checked=true;
				
				}
				
			}
			
		}else{
			
				document.getElementById('all_'+index).value='Y';
				document.getElementById('all_'+index).checked=true;
				document.getElementById('appl_ip_'+index).value='Y';
				document.getElementById('appl_ip_'+index).checked=true;

				document.getElementById('appl_op_'+index).value='Y';
				document.getElementById('appl_op_'+index).checked=true;
				
				document.getElementById('appl_dc_'+index).value='Y';
				document.getElementById('appl_dc_'+index).checked=true;
				
				document.getElementById('appl_em_'+index).value='Y';
				document.getElementById('appl_em_'+index).checked=true;
				
		}
		
	}else{
		document.getElementById('all_'+index).value='N';
		document.getElementById('all_'+index).checked=false;
		document.getElementById('appl_ip_'+index).value='N';
		document.getElementById('appl_ip_'+index).checked=false;

		document.getElementById('appl_op_'+index).value='N';
		document.getElementById('appl_op_'+index).checked=false;
		
		document.getElementById('appl_dc_'+index).value='N';
		document.getElementById('appl_dc_'+index).checked=false;
		
		document.getElementById('appl_em_'+index).value='N';
		document.getElementById('appl_em_'+index).checked=false;
	}
	
}

function validateCheckClaimType(ip,op,dc,em,idx){
	
	var pdoc=parent.PayerSpecClaimSplittingClaimsFrame.document.forms[0];
	
	var tbl = pdoc.parentNode.document.getElementById('tblType');
	
	var index = tbl.rows.length-1;

	var f=false;
	var ix=1;
	if(index!='0'){
		
		for(var i=1;i<tbl.rows.length;i++){
			f=false;
			
			while(document.getElementById('appl_ip_'+ix)==null){
				ix++;
			}
			if(idx!=ix){
			
				if(document.getElementById('appl_ip_'+ix).value=='Y'&&ip=='Y') f=true;
				if(document.getElementById('appl_op_'+ix).value=='Y'&&op=='Y') f=true;
				if(document.getElementById('appl_dc_'+ix).value=='Y'&&dc=='Y') f=true;
				if(document.getElementById('appl_em_'+ix).value=='Y'&&em=='Y') f=true;
				if(f&&document.getElementById('dfltClaimType_'+ix).value=='Y'){
					alert("Default Claim Type Cannot be Duplicated for the same episode type");
					return false;
				}
			}
			ix++;
					
		}
		return true;
		
	}
	
}

function changeServiceSerialNumber(){
	var pdoc=parent.PayerSpecClaimSplittingClassFrame.document.forms[0];
	var tbl = pdoc.parentNode.document.getElementById('tblService');
	var idx=1;
	for(var i=1;i<tbl.rows.length;i++){

		while(document.getElementById("sNo_"+idx)==null){
			idx++;
		}
	
		document.getElementById("sNo_"+idx).innerHTML=i;
		idx++;
	}
}

function changeTypeSerialNumber(){
	var pdoc=parent.PayerSpecClaimSplittingClaimsFrame.document.forms[0];
	var tbl = pdoc.parentNode.document.getElementById('tblType');
	var idx=1;
	for(var i=1;i<tbl.rows.length;i++){
		
		while(document.getElementById("sNo_"+idx)==null){
			idx++;
		}
		
		document.getElementById("sNo_"+idx).innerHTML=i;
		idx++;
	}
}
	
function validateServiceRows(){
	var pdoc=parent.PayerSpecClaimSplittingClassFrame.document.forms[0];
	var idx="1";
	if(pdoc!=null){
			
			var tbl = pdoc.parentNode.document.getElementById('tblService');
			var index = tbl.rows.length-1;
			if(index!='0'){
				
				for(var i=1;i<tbl.rows.length;i++){
					while(tbl.document.getElementById('bg_code_'+idx)==null){
						idx++;
					}
					if(tbl.document.getElementById("bg_code_"+idx).value==""){
							alert("Billing Services/Items Cannot be Blank");
							return false;
							
					}
					idx++;
				}
				
			}
	}
	return true;
	
	
}

function validateClaimTypeRows(){
	
	var pdoc=parent.PayerSpecClaimSplittingClaimsFrame.document.forms[0];
	
	var tbl = pdoc.parentNode.document.getElementById('tblType');
	
	var index = tbl.rows.length-1;
	
	var episodeTypeFlag=false;
	var idx=1;
	var jdx=1;

	if(index!='0'){
		
		for(var i=1;i<tbl.rows.length;i++){
			
			while(document.getElementById("claimTypeCode_"+idx)==null){
				idx++;
			}
			
			episodeTypeFlag=false;
			if(document.getElementById("claimTypeCode_"+idx).value==""){
					alert("Claim Type Code Cannot be Blank");
					return false;
					
			}else{
				for(var j=1;j<tbl.rows.length;j++){
					jdx=1;
					while(document.getElementById("claimTypeCode_"+jdx)==null){
							jdx++
					}
					
					if(jdx!=idx){		
						if(document.getElementById('claimTypeCode_'+idx).value==document.getElementById('claimTypeCode_'+jdx).value){
							var f=false;
							
							if(document.getElementById('appl_ip_'+idx).value=='Y'&&document.getElementById('appl_ip_'+jdx).value=='Y') f=true;
							if(document.getElementById('appl_op_'+idx).value=='Y'&&document.getElementById('appl_op_'+jdx).value=='Y') f=true;
							if(document.getElementById('appl_dc_'+idx).value=='Y'&&document.getElementById('appl_dc_'+jdx).value=='Y') f=true;
							if(document.getElementById('appl_em_'+idx).value=='Y'&&document.getElementById('appl_em_'+jdx).value=='Y') f=true;
							if(f){
								alert("Claim Type Configuration Cannot be Duplicated for the same Episode Type");
								return false;

							}
						}
					}
					jdx++;
				}
			}
			
	
			if(document.getElementById('all_'+idx).value=='Y') episodeTypeFlag=true;
			if(document.getElementById('appl_ip_'+idx).value=='Y') episodeTypeFlag=true;
			if(document.getElementById('appl_op_'+idx).value=='Y') episodeTypeFlag=true;
			if(document.getElementById('appl_dc_'+idx).value=='Y') episodeTypeFlag=true;
			if(document.getElementById('appl_em_'+idx).value=='Y') episodeTypeFlag=true;
			
			if(!episodeTypeFlag){
				alert("At least one Episode/Encounter Type should be selected");
				return false;
			}
		
			idx++;
		}
		
		return true;
		
	
	}
	return true;
	
	
	
}
function addTypeRow(){
	
	var pdoc=parent.PayerSpecClaimSplittingClaimsFrame.document.forms[0];
	
	var tbl = pdoc.parentNode.document.getElementById('tblType');
	
	var index = tbl.rows.length-1;
	
	var episodeTypeFlag=false;
	var flag=validateClaimTypeRows();


		if(flag){
			
			while(document.getElementById('claimTypeCode_'+(index+1))!=null){
				index++;  
			}

			var allLabel=getLabel('Common.all.label','common');
			var ipLabel=getLabel('Common.IP.label','common');
			var dcLabel=getLabel('Common.DC.label','common'); 
			var opLabel=getLabel('Common.OP.label','common');
			var emLabel=getLabel('Common.EM.label','common');
			
			var newRow = tbl.insertRow();
			
			newRow.id="tr_"+(index+1);
			
			var newCell = newRow.insertCell(0);	
			newCell.innerHTML = "<td class='fields' id='td_"+(index+1)+"_0' style='text-align:center'>"+
			"<span name='sNo_"+(index+1)+"' id='sNo_"+(index+1)+"' class='label'>"+(index+1)+"</span>"+
			"</td>";
			newCell.className ="fields";
			newCell.style.textAlign='center';
			newCell.id="td_"+(index+1)+"_0";
			
			
			newCell = newRow.insertCell(1);	
			newCell.innerHTML = "<td class='fields' id='td_"+(index+1)+"_1' style='text-align:center'>"+
			"<input type='text' name='claimTypeCode_"+(index+1)+"' id='claimTypeCode_"+(index+1)+"' value='' size='10' maxlength='3' onblur='if(this.value.length>0){claimTypeLookup(claimTypeDesc_"+(index+1)+",claimTypeCode_"+(index+1)+");validateClaimTypeCode(this);}else{clearField(claimTypeDesc_"+(index+1)+");}'/>"+
			"<input type='button' class='button' name='claimTypeCodeBtn_"+(index+1)+"' id='claimTypeCodeBtn_"+(index+1)+"' value='?' onClick='claimTypeLookup(claimTypeDesc_"+(index+1)+",claimTypeCode_"+(index+1)+");validateClaimTypeCode(this);' tabindex='2' />"+
			"<input type='hidden' name='cName_"+(index+1)+"' id='cName_"+(index+1)+"' value='' />"+
			"</td> ";
			newCell.className ="fields";
			newCell.style.textAlign='center';
			newCell.id="td_"+(index+1)+"_1";
			
			newCell = newRow.insertCell(2);	
			newCell.innerHTML = "<td class='fields' id='td_"+(index+1)+"_2' style='text-align:center'>"+
			"<input type='text' name='claimTypeDesc_"+(index+1)+"'  id='claimTypeDesc_"+(index+1)+"' value='' maxlength='20' size='20' readonly />"+

		
			"</td> ";
			newCell.className ="fields";
			newCell.style.textAlign='center';
			newCell.id="td_"+(index+1)+"_2";
			
			newCell = newRow.insertCell(3);	
			newCell.innerHTML = "<td class='fields' id='td_"+(index+1)+"_3' style='text-align:center'> "+
			allLabel+" <input type='checkbox' name='all_"+(index+1)+"' id='all_"+(index+1)+"' value='N' onClick='validateAndchangeAll(this);'>  &nbsp; "+
			ipLabel+"  <input type='checkbox' name='appl_ip_"+(index+1)+"' id='appl_ip_"+(index+1)+"' value='N' onClick='checkEpisodeType(this);'>  &nbsp; "+
			dcLabel+"  <input type='checkbox' name='appl_dc_"+(index+1)+"' id='appl_dc_"+(index+1)+"' value='N' onClick='checkEpisodeType(this);'>  &nbsp; "+
			opLabel+"  <input type='checkbox' name='appl_op_"+(index+1)+"' id='appl_op_"+(index+1)+"' value='N' onClick='checkEpisodeType(this);'>  &nbsp; "+
			emLabel+"  <input type='checkbox' name='appl_em_"+(index+1)+"' id='appl_em_"+(index+1)+"' value='N' onClick='checkEpisodeType(this);'>  &nbsp; "+
			"</td> ";
			newCell.className ="fields";
			newCell.style.textAlign='center';
			newCell.id="td_"+(index+1)+"_3";
			
			newCell = newRow.insertCell(4);	
			newCell.innerHTML = "<td class='fields'  id='td_"+(index+1)+"_4' style='text-align:center'>"+
			"<input type='checkbox' name='dfltClaimType_"+(index+1)+"' value='N' id='dfltClaimType_"+(index+1)+"' value='N' onClick='changeDfltClaimType(this);'>"+
			
			"</td> ";
			newCell.className ="fields";
			newCell.style.textAlign='center';
			newCell.id="td_"+(index+1)+"_4";
			
			newCell = newRow.insertCell(5);	
			newCell.innerHTML = "<td class='fields' id='td_"+(index+1)+"_5' style='text-align:center'>"+
			"<input type='text' name='dfltSubgroup_"+(index+1)+"' value='' disabled id='dfltSubgroup_"+(index+1)+"' maxlength='20' size='20' onblur='if(this.value.length>0){claimSubgroupLookup(dfltSubgroup_"+(index+1)+",dfltSubgroupCode_"+(index+1)+");}else{clearField(claimSubgroupCode_"+(index+1)+");}' />  "+
			"<input type='hidden' name='dfltSubgroupCode_"+(index+1)+"' value='' id='dfltSubgroupCode_"+(index+1)+"' />"+
			"<input type='button' name='dfltSubgroupBtn_"+(index+1)+"' disabled id='dfltSubgroupBtn_"+(index+1)+"' value='?'  onClick='claimSubgroupLookup(dfltSubgroup_"+(index+1)+",dfltSubgroupCode_"+(index+1)+");' tabindex='2' />"+
			
			"</td> ";
			newCell.className =  'fields';
			newCell.style.textAlign='center';
			newCell.id="td_"+(index+1)+"_5";
			
			newCell = newRow.insertCell(6);	
			newCell.innerHTML = "<td class='fields' id='td_"+(index+1)+"_6' style='text-align:center'>"+
			"<img src='../../eCommon/images/MarkError.gif' name='deleteBtn_"+(index+1)+"'  id='deleteBtn_"+(index+1)+"' onClick='deleteTypeRow(this)' />"+
			"</td> ";
			newCell.className =  'fields';
			newCell.style.textAlign='center';
			newCell.id="td_"+(index+1)+"_6";
			
		
			
			
		
			 newRow.onclick = function () {
					loadClassificationDetails(index + 1);
			};


			var l=Number(pdoc.parentNode.document.getElementById('typeRowCount').value);
			l++;
			pdoc.parentNode.document.getElementById('typeRowCount').value=l;
			changeTypeSerialNumber();
		}

	
	
	
}

function changeDfltClaimType(obj){
	
	var parts= obj.name.split("_");
	var index =parseInt(parts[1]);
	var ele;
	var ip=document.getElementById('appl_ip_'+index).value;
	var op=document.getElementById('appl_op_'+index).value;
	var dc=document.getElementById('appl_dc_'+index).value;
	var em=document.getElementById('appl_em_'+index).value;
	var flag= false;
	var total=document.getElementById("typeRowCount").value-1;
	
	if(obj.value=="N" || obj.value=="" || obj.value==null){
		flag=validateCheckClaimType(ip,op,dc,em,index);
		if(!flag){
			obj.value="N";
			obj.checked=false;
			document.getElementById('dfltSubgroup_'+index).disabled=true;
			document.getElementById('dfltSubgroupBtn_'+index).disabled=true;
			
		}else{
			obj.value="Y";
			obj.checked=true;
			document.getElementById('dfltSubgroup_'+index).disabled=false;
			document.getElementById('dfltSubgroupBtn_'+index).disabled=false;
		}
	}else{
		
		obj.value="N";
		obj.checked=false;
		document.getElementById('dfltSubgroup_'+index).disabled=true;
		document.getElementById('dfltSubgroupBtn_'+index).disabled=true;
		
	}
	
}




function addServiceRow(){
	var pdoc=parent.PayerSpecClaimSplittingClassFrame.document.forms[0];

	var tbl = pdoc.parentNode.document.getElementById('tblService');
	
	var index = tbl.rows.length-1;
	
	var classTypeDesc = parent.PayerSpecClaimSplittingClassFrame.document.forms[0].classTypeDesc.value;
	
	var classTypeCode = parent.PayerSpecClaimSplittingClassFrame.document.forms[0].classTypeCode.value;

	var classTypeDescArr = classTypeDesc.split(":::");
	var classTypeCodeArr = classTypeCode.split(":::");
	
	var flag=true;
	


	
	
	if(flag){
		
		while(document.getElementById('classType_'+(index+1))!=null){
			index++;  
		}
		
		var allLabel=getLabel('Common.all.label','common');
		var ipLabel=getLabel('Common.IP.label','common');
		var dcLabel=getLabel('Common.DC.label','common'); 
		var opLabel=getLabel('Common.OP.label','common');
		var emLabel=getLabel('Common.EM.label','common');
		
		
			
		
		
			var newRow = tbl.insertRow();
			var newCell = newRow.insertCell(0);	
			newCell.innerHTML = "<td class='fields' style='text-align:center'>"+
			"<span name='sNo_"+(index+1)+"' id='sNo_"+(index+1)+"' class='label'>"+(index+1)+"</span>"+
			"</td>";
			newCell.className = 'fields';
			newCell.style.textAlign='center';
			
			
			newCell = newRow.insertCell(1);	
			var classTypeHtml = "<td class='fields' nowrap style='text-align:center'> "+
								"<Select name='classType_"+(index+1)+"' id='classType_"+(index+1)+"' name='classType_"+(index+1)+"' onchange='clearBillingService("+(index+1)+")'> ";
			
			for(var x=0;x<classTypeCodeArr.length-1;x++){
				classTypeHtml = classTypeHtml+"<option value='"+classTypeCodeArr[x+1]+"'>"+classTypeDescArr[x+1]+"</option> ";
			}
			
			classTypeHtml = classTypeHtml+"</select> "+
								"</td> ";
			newCell.innerHTML = classTypeHtml;
			newCell.className = 'fields'; 
			newCell.style.nowrap='nowrap'; 
			newCell.style.textAlign='center';
			
			newCell = newRow.insertCell(2);	
			newCell.innerHTML = 
					"<td class='fields' style='text-align:center' nowrap> "+
						"<input type='text' id='bg_code_"+(index+1)+"'  value='' name='bg_code_"+(index+1)+"' size='20'  onblur='if(this.value.length>0){callBGDescCode(2,classType_"+(index+1)+",bg_desc_"+(index+1)+",bg_code_"+(index+1)+","+(index+1)+"); validateServiceCode(this); } else{ clearField(bg_desc_"+(index+1)+","+(index+1)+");}' />"+		
						"<input type='button' id='bg_but_"+(index+1)+"' value='?' name='bg_but_"+(index+1)+"' onclick='callBGDescCode(2,classType_"+(index+1)+",bg_desc_"+(index+1)+",bg_code_"+(index+1)+","+(index+1)+");validateServiceCode(this);' />"+
						"<input type='text' id='bg_desc_"+(index+1)+"'  value='' name='bg_desc_"+(index+1)+"' readonly size='40' onblur='if(this.value.length>0){callBGDesc(2,classType_"+(index+1)+",bg_desc_"+(index+1)+",bg_code_"+(index+1)+","+(index+1)+"); } else{ clearField(bg_code_"+(index+1)+","+(index+1)+");}' />"+
			
					"</td> ";
			newCell.className = 'fields';
			newCell.style.nowrap='nowrap';
			newCell.style.textAlign='center';
			
			
			newCell = newRow.insertCell(3);	
			newCell.innerHTML = "<td class='fields' style='text-align:center'>"+
				"<input type='text' name='claimSubgroup_"+(index+1)+"' value='' id='claimSubgroup_"+(index+1)+"' size='30' maxlength='30'  onblur='if(this.value.length>0){claimSubgroupLookup(claimSubgroup_"+(index+1)+",claimSubgroupCode_"+(index+1)+");}else{clearField(claimSubgroupCode_"+(index+1)+");}' />"+
				"<input type='hidden' name='claimSubgroupCode_"+(index+1)+"' value='' id='claimSubgroupCode_"+(index+1)+"' />"+
				"<input type='button' class='button' name='claimSubgroupBtn_"+(index+1)+"' id='claimSubgroupBtn_"+(index+1)+"' value='?' onClick='claimSubgroupLookup(claimSubgroup_"+(index+1)+",claimSubgroupCode_"+(index+1)+");' tabindex='2' />"+
			"</td> ";
			newCell.className =  'fields';
			newCell.style.textAlign='center';
			
			newCell = newRow.insertCell(4);	
			newCell.innerHTML = "<td class='fields' style='text-align:center'>"+
			"<img src='../../eCommon/images/MarkError.gif' name='deleteBtn_"+(index+1)+"'  id='deleteBtn_"+(index+1)+"' onClick='deleteServiceRow(this)' />"+
			"</td> ";
			newCell.className =  'fields';
			newCell.style.textAlign='center';
			
			

			var l=Number(pdoc.parentNode.document.getElementById('serviceRowCount').value);
			l++;
			pdoc.parentNode.document.getElementById('serviceRowCount').value=l;
			changeServiceSerialNumber();
	}
			
}

function validateServiceCode(obj){
	var pdoc=parent.PayerSpecClaimSplittingClassFrame.document.forms[0];
	var tbl = pdoc.parentNode.document.getElementById('tblService');
	var parts= obj.name.split("_");
	var index =parts[2];
	var f=false;
	var bgCode= document.getElementById('bg_code_'+index).value;
	var idx=1;
	for(var i=1;i<tbl.rows.length;i++){
			f=false;
			while(document.getElementById('bg_code_'+idx)==null){
				idx++;
			}
			if(index!=idx){
			
				if(document.getElementById('bg_code_'+idx).value==bgCode){ 
					f=true;	
					break;
				}
			}
		idx++;
	}

	if(f){
		alert("Billing Services/Items Cannot be Duplicated");
		obj.value='';
		document.getElementById('bg_desc_'+index).value='';
		
	}else{
		
		var sName=document.getElementById('sName').value;
		var flag=validateServicePersistance(sName,bgCode);
		if(!flag){
			obj.value='';
			document.getElementById('bg_desc_'+index).value='';
		}
		
	}
}

function validateClaimTypeCode(obj){
	var pdoc=parent.PayerSpecClaimSplittingClaimsFrame.document.forms[0];
	var tbl = pdoc.parentNode.document.getElementById('tblType');
	var parts= obj.name.split("_");
	var index =parts[1];
	var flag = validateClaimRow(index);
	if(!flag){
		document.getElementById("claimTypeCode_"+index).value='';
		document.getElementById('claimTypeDesc_'+index).value='';
		
	}
}

function validateClaimRow(index){
	var pdoc=parent.PayerSpecClaimSplittingClaimsFrame.document.forms[0];
	var tbl = pdoc.parentNode.document.getElementById('tblType');
	
	var claimType= document.getElementById("claimTypeCode_"+index).value;
	var ip= document.getElementById("appl_ip_"+index).checked;
	var op= document.getElementById("appl_op_"+index).checked;
	var dc= document.getElementById("appl_dc_"+index).checked;
	var em= document.getElementById("appl_em_"+index).checked;
	
	var flag=false;
	var f=false;
	var idx=1;
	for(var i=1;i<tbl.rows.length;i++){
			f=false;
			while(document.getElementById('appl_ip_'+idx)==null){
				idx++;
			}
			if(index!=idx){
			
				if(document.getElementById('appl_ip_'+idx).value=='Y'&&ip) f=true;
				if(document.getElementById('appl_op_'+idx).value=='Y'&&op) f=true;
				if(document.getElementById('appl_dc_'+idx).value=='Y'&&dc) f=true;
				if(document.getElementById('appl_em_'+idx).value=='Y'&&em) f=true;
			}
			
			if(document.getElementById('claimTypeCode_'+idx).value==claimType&&f){
				alert("Claim Type Cannot be Duplicated for the same episode type");
				return false;
			}
		idx++;
	}
	return true;
	
}

function checkEpisodeType(obj){
	var pdoc=parent.PayerSpecClaimSplittingClaimsFrame.document.forms[0];
	var tbl = pdoc.parentNode.document.getElementById('tblType');
			
	var parts= obj.name.split("_");
	var index =parts[2];
	var flag=validateClaimRow(index);
	if(flag){
			
			var claimType= document.getElementById("claimTypeCode_"+index);
			
			if(obj.value==='N'){obj.value='Y'}
			else{obj.value='N';}
			
			
			if(document.getElementById("appl_ip_"+index).value=='N' || document.getElementById("appl_em_"+index).value=='N' || document.getElementById("appl_dc_"+index).value=='N' || document.getElementById("appl_op_"+index).value=='N'){
				document.getElementById('all_'+index).value='N';
				document.getElementById('all_'+index).checked=false;
			}
			
			if(document.getElementById("appl_ip_"+index).value=='Y' && document.getElementById("appl_em_"+index).value=='Y' && document.getElementById("appl_dc_"+index).value=='Y' && document.getElementById("appl_op_"+index).value=='Y'){
				document.getElementById('all_'+index).value='Y';
				document.getElementById('all_'+index).checked=true;
			}
	}
	else{
		obj.value='N';
		obj.checked=false;
	}
	
}


function changeStatus(obj){

	if(obj.value==='N'){obj.value='Y'}
	else{obj.value='N';}
	
}


function checkNumberonBlur(obj){
	
              if(isNaN(obj.value)){
                             alert(getMessage('BL8532','BL'));
							 obj.value='';
                             obj.select();
              }
}

/*
function validateBeforeApply(messageFrame,calledFor) {
		
		var flag1=true;
		var flag2=true;
		var claimTypeFrm= BLInsRCMPayerSpecClaimSplittingMain.PayerSpecClaimSplittingClaimsFrame.document.forms[0];
	
		
		var tbl = claimTypeFrm.parentNode.document.getElementById('tblType');
	
		var index = tbl.rows.length-1;
		var episodeTypeFlag=false;
		var idx=1;
		var jdx=1;
		
		
		if(index!='0'){
		
			outerLoop:
			for(var i=1;i<tbl.rows.length;i++){
				
				while(claimTypeFrm.parentNode.document.getElementById("claimTypeCode_"+idx)==null){
					idx++;
				}
				
				episodeTypeFlag=false;
				if(claimTypeFrm.parentNode.document.getElementById("claimTypeCode_"+idx).value==""){
						alert("Claim Type Code Cannot be Blank");
						flag1=false;
						break;
						
				}else{
					for(var j=1;j<tbl.rows.length;j++){
						jdx=1;
						while(claimTypeFrm.parentNode.document.getElementById("claimTypeCode_"+jdx)==null){
								jdx++
						}
						
						if(jdx!=idx){		
							if(claimTypeFrm.parentNode.document.getElementById('claimTypeCode_'+idx).value==claimTypeFrm.parentNode.document.getElementById('claimTypeCode_'+jdx).value){
								var f=false;
								
								if(claimTypeFrm.parentNode.document.getElementById('appl_ip_'+idx).value=='Y'&&claimTypeFrm.parentNode.document.getElementById('appl_ip_'+jdx).value=='Y') f=true;
								if(claimTypeFrm.parentNode.document.getElementById('appl_op_'+idx).value=='Y'&&claimTypeFrm.parentNode.document.getElementById('appl_op_'+jdx).value=='Y') f=true;
								if(claimTypeFrm.parentNode.document.getElementById('appl_dc_'+idx).value=='Y'&&claimTypeFrm.parentNode.document.getElementById('appl_dc_'+jdx).value=='Y') f=true;
								if(claimTypeFrm.parentNode.document.getElementById('appl_em_'+idx).value=='Y'&&claimTypeFrm.parentNode.document.getElementById('appl_em_'+jdx).value=='Y') f=true;
								if(f){
									alert("Claim Type Configuration Cannot be Duplicated for the same Episode Type");
									flag1=false;
									break outerLoop;

								}
							}
						}
						jdx++;
					}
				}
				
		
				if(claimTypeFrm.parentNode.document.getElementById('all_'+idx).value=='Y') episodeTypeFlag=true;
				if(claimTypeFrm.parentNode.document.getElementById('appl_ip_'+idx).value=='Y') episodeTypeFlag=true;
				if(claimTypeFrm.parentNode.document.getElementById('appl_op_'+idx).value=='Y') episodeTypeFlag=true;
				if(claimTypeFrm.parentNode.document.getElementById('appl_dc_'+idx).value=='Y') episodeTypeFlag=true;
				if(claimTypeFrm.parentNode.document.getElementById('appl_em_'+idx).value=='Y') episodeTypeFlag=true;
				
				if(!episodeTypeFlag){
					flag1=false;
					alert("At least one Episode/Encounter Type should be selected");
				}
			
				idx++;
			}
		}
		
		
		if(flag1){
			var classTypeFrm= BLInsRCMPayerSpecClaimSplittingMain.PayerSpecClaimSplittingClassFrame.document.forms[0];
		
			if(classTypeFrm!=null){
				
				tbl = classTypeFrm.parentNode.document.getElementById('tblService');
				
				index = tbl.rows.length-1;
				idx=1;
				if(index!='0'){
					for(var i=1;i<tbl.rows.length;i++){
						while(tbl.document.getElementById('bg_code_'+idx)==null){
							idx++;
						}
						if(tbl.document.getElementById("bg_code_"+idx).value==""){
								alert("Billing Services/Items Cannot be Blank");
								flag2= false;
								break;
								
						}
						idx++;
					}
					
				}
			}
		}
		
		
		
		if(flag1&&flag2){	
				return true;
		}else{
			if(calledFor=="apply){
				messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+"APP-00001 Mandatory flelds Cannot be blank";
			}else{
				alert("APP-00001 Mandatory flelds Cannot be blank");
			}
			return false ;
    
		}
        
    
}
*/
/*
function apply() {

	messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp";
	var mainfrmObj = "";
	var infofrmObj="";
	mainfrmObj = BLInsRCMPayerSpecClaimSplittingMain.PayerSpecClaimSplittingClaimsFrame.document.forms[0];
	infofrmObj=  BLInsRCMPayerSpecClaimSplittingMain.PayerSpecClaimSplittingInfoFrame.document.forms[0];
	var tbl = mainfrmObj.parentNode.document.getElementById('tblType');
	var index= (tbl.rows.length)-1;
	
	var msgFrame=messageFrame;
	
	if(index==0){
		messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+"APP-00001 At least one claim type should be configured";
		return;
	}else{
		if(validateBeforeApply(msgFrame)){
				
				var mode = mainfrmObj.mode.value;
				
				var clickedRow=mainfrmObj.parentNode.document.getElementById('rowClicked').value;
				var xmlString= formXMLStringMain(infofrmObj);
				
				var updation =formValidation(xmlString,"InfoFrame");
				
				xmlString = formXMLStringMain(mainfrmObj);
				updation =formValidation(xmlString,"addClaimTypes");
				
				var frmObj = "";
				frmObj = BLInsRCMPayerSpecClaimSplittingMain.PayerSpecClaimSplittingClassFrame.document.forms[0];
				if(clickedRow!="" && frmObj!=null){
						var claimType=mainfrmObj.parentNode.document.getElementById('claimTypeCode_'+clickedRow).value;
						var appl_all=mainfrmObj.parentNode.document.getElementById('all_'+clickedRow).value;
						var appl_ip=mainfrmObj.parentNode.document.getElementById('appl_ip_'+clickedRow).value;
						var appl_op=mainfrmObj.parentNode.document.getElementById('appl_op_'+clickedRow).value;
						var appl_dc=mainfrmObj.parentNode.document.getElementById('appl_dc_'+clickedRow).value;
						var appl_em=mainfrmObj.parentNode.document.getElementById('appl_em_'+clickedRow).value;
					
						xmlString = formXMLStringMain(frmObj);
						
						updation = serviceFormValidation(xmlString,"validateAndUpdateService",claimType,appl_all,appl_ip,appl_op,appl_dc,appl_em);
						
				}
				
				mainfrmObj.target = 'messageFrame';
				mainfrmObj.method = "post";
				mainfrmObj.action = "../../servlet/eBL.BLInsPayerSpecClaimSplittingServlet?mode=" + mode;
				mainfrmObj.submit();
		}
		
	}

	
}
*/
function formXMLStringMain(frmObj) {
    if (frmObj != null && frmObj != "undefined" && frmObj.length > 0) {
        var xmlStr = "<root><SEARCH ";
	if (true) {
		var arrObj = frmObj.elements;
		for (var i = 0; i < arrObj.length; i++) {
			var val = "";
			if (arrObj[i].type == "checkbox") {
				if (arrObj[i].checked) {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"Y" + "\" ";
				} else {
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"" + "N" + "\" ";
				}
			} else if (arrObj[i].type == "radio") {
				if (arrObj[i].checked) {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != "")
						xmlStr += arrObj[i].name + "=\"" + checkSpl(val) +
						"\" ";
				}
			} else if (arrObj[i].type == "select-multiple") {
				for (var j = 0; j < arrObj[i].options.length; j++) {
					if (arrObj[i].options[j].selected)
						val += arrObj[i].options[j].value + "~"
				}
				val = val.substring(0, val.lastIndexOf('~'))
				if (arrObj[i].name != null && arrObj[i].name != "")
					xmlStr += arrObj[i].name + "=\"" + checkSpl(val) +
					"\" ";
			} else {
				val = arrObj[i].value;
				if (arrObj[i].name != null && arrObj[i].name != "")
					xmlStr += arrObj[i].name + "=\"" + checkSpl(val) +
					"\" ";
			}
		}
        }
        xmlStr += " /></root>";
		
		
    }
    return xmlStr;
}

function formValidation(xmlStr, last_link, event) {
    var temp_jsp = "BLInsRCMPayerSpecClaimSplittingPersistence.jsp?func_mode=" + last_link;

    var xmlDoc="";

    var xmlHttp = new XMLHttpRequest();
	
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
    xmlHttp.open("POST", temp_jsp, false);
    xmlHttp.send(xmlDoc);
	
    var responseText = xmlHttp.responseText;

    eval(responseText);
	
	
    return true;
}

function serviceFormValidation(xmlStr, last_link, claimType,appl_all,appl_ip,appl_op,appl_dc,appl_em) {
    var temp_jsp = "BLInsRCMPayerSpecClaimSplittingPersistence.jsp?func_mode=" + last_link+ "&claimType="+claimType+"&all="+appl_all+"&appl_ip="+appl_ip+"&appl_op="+appl_op+"&appl_dc="+appl_dc+"&appl_em="+appl_em;

    var xmlDoc="";

    var xmlHttp = new XMLHttpRequest();
	
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	
    xmlHttp.open("POST", temp_jsp, false);
    xmlHttp.send(xmlDoc);
	
    var responseText = xmlHttp.responseText;

    eval(responseText);
	
	
    return true;
}


function addTypeRowPersist(code,desc,epiAll,epiIP,epiOP,epiDC,epiEM,dfltClaimType,dfltSubgroupCode,dfltSubgroupDesc) {
            var xmlStr = "<root><SEARCH ";
            xmlStr += " /></root>";
            var temp_jsp = "../../eBL/jsp/BLInsRCMPayerSpecClaimSplittingPersistence.jsp?func_mode=addTypeRowPersist&code=" +
                code+
                "&desc=" +
                desc+
                "&epiAll=" +
                epiAll+
				"&epiIP=" +
                epiIP+
				"&epiOP=" +
                epiOP+
				"&epiDC=" +
                epiDC+
				"&epiEM=" +
                epiEM+
				"&dfltClaimType=" +
                dfltClaimType+
				"&dfltSubgroupCode=" +
                dfltSubgroupCode+
				"&dfltSubgroupDesc=" +
                dfltSubgroupDesc;
            var xmlDoc="";
            var xmlHttp = new XMLHttpRequest();
			
			
            xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
            
            xmlHttp.open("POST", temp_jsp, false);
			
            xmlHttp.send(xmlDoc);
			
            var responseText = trimString(xmlHttp.responseText);
			
           
}



function addServiceRowPersist() {
		
		var pdoc=parent.PayerSpecClaimSplittingClassFrame.document.forms[0];
		if(pdoc!=null){
			var xmlString = formXMLStringMain(pdoc);
		
            var temp_jsp = "../../eBL/jsp/BLInsRCMPayerSpecClaimSplittingPersistence.jsp?func_mode=addServiceRowPersist";
            var xmlDoc="";
            var xmlHttp = new XMLHttpRequest();
			
            xmlDoc.loadXML(xmlString);
            
            xmlHttp.open("POST", temp_jsp, false);
			
            xmlHttp.send(xmlDoc);
			
            var responseText = trimString(xmlHttp.responseText);
		}
		
						
}

function validateServicePersistance(cName,servCode) {
          
			var xmlStr = "<root><SEARCH ";
            xmlStr += " /></root>";
            var temp_jsp = "../../eBL/jsp/BLInsRCMPayerSpecClaimSplittingPersistence.jsp?func_mode=validateServicePersistance&cName=" +
                cName+
                "&servCode=" +
                servCode;
			
            var xmlDoc="";
            var xmlHttp = new XMLHttpRequest();
			
            xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
           
            xmlHttp.open("POST", temp_jsp, false);
		
            xmlHttp.send(xmlDoc);
			
            var responseText = trimString(xmlHttp.responseText);
			if(responseText=='Y'){
				alert("Billing Services/Items Cannot be Duplicated for the same episode type under different claim types");
					return false;
			}
			return true;
			
           
}



function claimTypeLookup(desc, code) {
    


    var argumentArray = new Array();
    var dataNameArray = new Array();
    var dataValueArray = new Array();
    var dataTypeArray = new Array();
    var sql = '';
    var title = '';
    sql="select Description,Code from (Select short_desc Description, claim_type Code from BL_CLAIM_TYPE ) where upper(Code) like upper(?) and upper(Description) like upper(?) ";
	title = "Claim Type";
	
    argumentArray[0] = sql;
    argumentArray[1] = dataNameArray;
    argumentArray[2] = dataValueArray;
    argumentArray[3] = dataTypeArray;
    argumentArray[4] = "2,1";
    argumentArray[5] = code.value;
    argumentArray[6] = DESC_LINK;
    argumentArray[7] = DESC_CODE;

    returnedValues = CommonLookup(title, argumentArray);
	
    if ((returnedValues != null) && (returnedValues != "")) {
        desc.value = returnedValues[1];
        code.value = returnedValues[0];
    } else {
        code.value = '';
        desc.value = '';
       
    }

}


function claimSubgroupLookup(desc, code) {
    

	
    var argumentArray = new Array();
    var dataNameArray = new Array();
    var dataValueArray = new Array();
    var dataTypeArray = new Array();
    var sql = '';
    var title = '';
    sql="select Description,Code from (Select short_desc Description, CLAIM_SUBGROUP_CODE Code from BL_CLAIM_SUBGROUP ) where upper(Description) like upper(?) and upper(Code) like upper(?) ";
	title = "Claim Subgroup";
	
    argumentArray[0] = sql;
    argumentArray[1] = dataNameArray;
    argumentArray[2] = dataValueArray;
    argumentArray[3] = dataTypeArray;
    argumentArray[4] = "2,1";
    argumentArray[5] = desc.value;
    argumentArray[6] = DESC_LINK;
    argumentArray[7] = DESC_CODE;

    returnedValues = CommonLookup(title, argumentArray);
	
    if ((returnedValues != null) && (returnedValues != "")) {
        desc.value = returnedValues[1];
        code.value = returnedValues[0];
    } else {
        code.value = '';
        desc.value = '';
       
    }

}






