function show() {
	parent.parent.window.document.title = f_query_add_mod.getLabel('Common.setup.label','common')+ " " + f_query_add_mod.getLabel('eMP.region.label','MP') ;
}

function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/addRegion.jsp" ;
}

function query() {
	//f_query_add_mod.location.href ="../../eMP/jsp/queryRegion.jsp?function=Region";
	f_query_add_mod.location.href ="../../eMP/jsp/RegionQueryPage.jsp?function=Region";
}

function apply() {	
	/*Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132*/
	if(f_query_add_mod.document.region_form!=null){
	var isGSTCodeApplicable = f_query_add_mod.document.region_form.isGSTCodeApplicable.value;	
	var function_name = f_query_add_mod.document.region_form.function_name.value;

	if(isGSTCodeApplicable == "true")
	{	
		var GST_Region = f_query_add_mod.document.region_form.GST_Region.value;
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH GST_Region=\""+GST_Region+"\" action='validateRegion' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../eMP/jsp/MPIntermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		var GSTRegion	= responseText;

			if (! (checkIsValidForProceed()) )
			{
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
			return false;
			 }
		/*Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132*/
		var fields = new Array ( f_query_add_mod.document.region_form.region_code,
						f_query_add_mod.document.region_form.GST_Region,
						f_query_add_mod.document.region_form.long_desc,
						f_query_add_mod.document.region_form.short_desc,
						f_query_add_mod.document.region_form.country_code
					    );	
		var names = new Array ( f_query_add_mod.getLabel('Common.code.label','common'), 
						f_query_add_mod.getLabel('Common.GoodsandServicesTax.label','common')+ " " + f_query_add_mod.getLabel('eMP.Regioncode.label','MP'),
						f_query_add_mod.getLabel('Common.longdescription.label','common'),
						f_query_add_mod.getLabel('Common.shortdescription.label','common'),
						f_query_add_mod.getLabel('Common.country.label','common')
					      );
		var transform = new Array (	f_query_add_mod.document.region_form,
							f_query_add_mod.document.region_form.eff_date_from,
							f_query_add_mod.document.region_form.eff_date_from1,
							f_query_add_mod.document.region_form.eff_date_to,
							f_query_add_mod.document.region_form.eff_date_to1
						   );		
		var splField = new Array ( f_query_add_mod.document.region_form.region_code);
		var splFieldName = new Array (f_query_add_mod.getLabel('Common.code.label','common'));
		if(f_query_add_mod.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){	
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			/*Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132*/
			if(function_name == "insert")
			{ 
				if(GSTRegion > 0 )
				{ 
				var error = f_query_add_mod.getMessage("GST_ALREADY_EXISTS","common");
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+error; 
				return false;
				} else{ 
				if(f_query_add_mod.DateTransform(transform,messageFrame)) {
				}
				}
			} else if (function_name == "modify")
			{ 
				if (f_query_add_mod.document.region_form.GST_Region.readOnly == true)
				{ 
					if(f_query_add_mod.DateTransform(transform,messageFrame)) {
					}
				} else if (f_query_add_mod.document.region_form.GST_Region.readOnly == false)
				{ 
					if(GSTRegion > 0 )
					{ 
					var error = f_query_add_mod.getMessage("GST_ALREADY_EXISTS","common");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+error; 
					return false;
					} else{ 
					if(f_query_add_mod.DateTransform(transform,messageFrame)) {
					}
					}
				}
			}
			
			}
		}
		
	} else{
	
	if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }

	var fields = new Array ( f_query_add_mod.document.region_form.region_code,
						f_query_add_mod.document.region_form.long_desc,
						f_query_add_mod.document.region_form.short_desc,
						f_query_add_mod.document.region_form.country_code
					    );	
	var names = new Array ( f_query_add_mod.getLabel('Common.code.label','common'), 
						f_query_add_mod.getLabel('Common.longdescription.label','common'),
						f_query_add_mod.getLabel('Common.shortdescription.label','common'),
						f_query_add_mod.getLabel('Common.country.label','common')
					      );	
	var transform = new Array (	f_query_add_mod.document.region_form,
							f_query_add_mod.document.region_form.eff_date_from,
							f_query_add_mod.document.region_form.eff_date_from1,
							f_query_add_mod.document.region_form.eff_date_to,
							f_query_add_mod.document.region_form.eff_date_to1
						   );		
	var splField = new Array ( f_query_add_mod.document.region_form.region_code);
	var splFieldName = new Array (f_query_add_mod.getLabel('Common.code.label','common'));

	if(f_query_add_mod.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){	
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			if(f_query_add_mod.DateTransform(transform,messageFrame)) {
			}
		}
	}
	}
	} else {
		frames[0].location.reload();
	    return false;
	}
}

function reset() {
	if(f_query_add_mod.document.forms[0].name == "region_form") f_query_add_mod.document.region_form.reset() ;
	else f_query_add_mod.document.query_form.reset() ;
}

function onSuccess() {
	f_query_add_mod.location.reload() 
}

function checkIsValidForProceed()
{
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}

/*Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132*/
function NumChkForRegion(event)
{
	var strCheck = '1234567890';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
} 

function ZeroChkForRegion(obj2){	
	if(obj2.value!=""){
		if (obj2.value <= 0){
			alert(getMessage('GST_CODE_NOT_LESS_ZERO',"MP"));
			obj2.value="";
			obj2.focus();		
		}	
	}
}

function CodeLen(Obj)
{
	var message = getMessage('CODE_2_CH',"MP");
	message = message.replace("Code", getLabel('Common.GoodsandServicesTax.label','common')+ " " +getLabel('eMP.Regioncode.label','MP'));
		if(Obj.value.length<2 && Obj.value!="")
		{
			alert(message);
			Obj.select();
			Obj.focus();
		}
}
/*End AMS-CRF-0132*/
