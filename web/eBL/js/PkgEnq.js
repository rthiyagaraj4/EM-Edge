
function showTabDetail(link,packageCode,packageSeqNo)	
{
	if(link == "PACKAGE_PRICE")
	{
		parent.frames[2].location.href='../../eBL/jsp/PkgEnqBasePrice.jsp?packageCode='+packageCode+'&packageSeqNo='+packageSeqNo;
	} 
	else if(link=="CHARGE_BASED")
	{
	
		parent.frames[2].location.href='../../eBL/jsp/PkgEnqChargeBasedMain.jsp?packageCode='+packageCode+'&packageSeqNo='+packageSeqNo;
	}  
	else if(link=="RATE_BASED")
	{  
		parent.frames[2].location.href='../../eBL/jsp/PkgEnqRateFrame.jsp?packageCode='+packageCode+'&packageSeqNo='+packageSeqNo;
	}
}

//Function to load Charge based limit page
function loadChargeBasedServiceLimit(packageCode,packageSeqNo,serviceCode)
{	
	 parent.ChargeBasedExCln.location.href='../../eBL/jsp/PkgEnqChargeBasedExclusion.jsp?packageCode='+packageCode+'&serviceCode='+serviceCode+'&packageSeqNo='+packageSeqNo;

}
//Function to load Rate based limit page
function serviceLimitDtls(packageSeqNo,index,packageCode,type,serviceCode)
{
	parent.frames[1].location.href="../../eBL/jsp/PkgEnqExclude.jsp?packageSeqNo="+packageSeqNo+"&packageCode="+packageCode+"&type="+type+"&service_code="+serviceCode+"&parent_indx="+index
}

async function showReplaceDtls(index){	
	var type=eval("document.rate_based_dtl.type"+index).value;
	var service_code=eval("document.rate_based_dtl.service_code"+index).value;
	var service_desc=eval("document.rate_based_dtl.service_desc"+index).value;
	var order_associated=document.rate_based_dtl.order_associated.value;
	var catalog_code="";
	var catalog_desc="";
	//alert("order_associated="+order_associated)
	if(order_associated=="Y"){
		var catalog_code=eval("document.rate_based_dtl.catalog_code"+index).value;
		var catalog_desc=eval("document.rate_based_dtl.catalog_desc"+index).value;
	}
	var replaceSrv_code=eval("document.rate_based_dtl.replaceSrv_code"+index).value;
	var replaceSrv_desc=eval("document.rate_based_dtl.replaceSrv_desc"+index).value;	
	var replaceSrv_cat_code="";
	var replaceSrv_cat_desc="";
	if(order_associated=="Y"){
		var replaceSrv_cat_code=eval("document.rate_based_dtl.replaceSrv_cat_code"+index).value;
		var replaceSrv_cat_desc=eval("document.rate_based_dtl.replaceSrv_cat_desc"+index).value;
	}
	var queryString = "order_associated="+order_associated+"&type="+type+"&service_code="+service_code+"&service_desc="+service_desc+"&catalog_code="+catalog_code+"&catalog_desc="+catalog_desc+"&replaceSrv_code="+replaceSrv_code+"&replaceSrv_desc="+replaceSrv_desc+"&replaceSrv_cat_code="+replaceSrv_cat_code+"&replaceSrv_cat_desc="+replaceSrv_cat_desc;
	var retVal = 	new String();
	var dialogHeight= "19" ;
	var dialogWidth	= "30" ;
	var status = "no";
	var arguments	= "" ;
	var title=getLabel("eBL.replaceableService.label","BL");	
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no;  status:" + status;
	retVal=await window.showModalDialog("../../eBL/jsp/PkgEnqReplaceableSrv.jsp?"+queryString,arguments,features);
	
}

async function srvLimitShowReplaceDtls(index){	
	var type=eval("document.srvLimit_rate_based_dtl.srvLimit_type"+index).value;
	var service_code=eval("document.srvLimit_rate_based_dtl.srvLimit_service_code"+index).value;
	var service_desc=eval("document.srvLimit_rate_based_dtl.srvLimit_service_desc"+index).value;
	var catalog_code="";
	var catalog_desc="";
	var order_associated = "N";
	var replaceSrv_code=eval("document.srvLimit_rate_based_dtl.srvLimit_replaceSrv_code"+index).value;
	var replaceSrv_desc=eval("document.srvLimit_rate_based_dtl.srvLimit_replaceSrv_desc"+index).value;	
	var replaceSrv_cat_code="";
	var replaceSrv_cat_desc="";
	var queryString = "order_associated="+order_associated+"&type="+type+"&service_code="+service_code+"&service_desc="+encodeURIComponent(service_desc)+"&catalog_code="+catalog_code+"&catalog_desc="+catalog_desc+"&replaceSrv_code="+replaceSrv_code+"&replaceSrv_desc="+encodeURIComponent(replaceSrv_desc)+"&replaceSrv_cat_code="+replaceSrv_cat_code+"&replaceSrv_cat_desc="+replaceSrv_cat_desc;
	var retVal = 	new String();
	var dialogHeight= "19" ;
	var dialogWidth	= "30" ;
	var status = "no";
	var arguments	= "" ;
	var title=getLabel("eBL.replaceableService.label","BL");	
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no;  status:" + status;
	retVal=await window.showModalDialog("../../eBL/jsp/PkgEnqReplaceableSrv.jsp?"+queryString,arguments,features);
	
}
