//saved on 31/12/2009

function fillComboOptions(obj,language_id) {
	
	var formObj    = document.formSRRIPFillListUnallocDrugs;
	if( formObj.p_fill_proc_dt1.value != "" ){
		var  xmlAppend = "";
        var p_fill_proc_dt ="";
		var bean_id				= formObj.bean_id.value ;
		var bean_name			= formObj.bean_name.value ;
		var p_fill_proc_type		= formObj.p_fill_proc_type.value;
		p_fill_proc_dt 		= formObj.p_fill_proc_dt1.value;
        //alert("p_fill_proc_dt-------before date---->"+p_fill_proc_dt);
        var locale = formObj.p_language_id.value;
		p_fill_proc_dt = convertDate(p_fill_proc_dt,"DMY",locale); 
		//alert("p_fill_proc_dt1---after--->"+p_fill_proc_dt);
 		removeOptions(formObj ,formObj.p_fill_proc_id);
		
		xmlAppend += "p_fill_proc_type"+"=\""+p_fill_proc_type+"\" " ;
		xmlAppend += "p_fill_proc_dt"+"=\""+p_fill_proc_dt+"\" " ;
		

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr =xmlStr + xmlAppend ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "SRRPhRepDlyDispSummValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode=populateFillProcIDs"+"&locale="+language_id.value,false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		
		eval(responseText ) ;
	}
	else{
		removeOptions(formObj,formObj.p_fill_proc_id);
	}
}

function removeOptions()	{
var len =document.formSRRIPFillListUnallocDrugs.p_fill_proc_id.options.length;
	for(var i=0;i<len;i++) {
		document.formSRRIPFillListUnallocDrugs.p_fill_proc_id.remove("p_fill_proc_id") ;
	}


	var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	document.formSRRIPFillListUnallocDrugs.p_fill_proc_id.add(opt);
}

function addList(desc)	{ 
	var element = document.createElement('OPTION') ;
	element.value		=  desc ;
	element.text		= desc ;
	document.formSRRIPFillListUnallocDrugs.p_fill_proc_id.add(element);
}

function reset()
{
	f_query_add_mod.location.reload();
	/*f_query_add_mod.document.formSRRIPFillListUnallocDrugs.reset();

	var len =f_query_add_mod.document.formSRRIPFillListUnallocDrugs.p_fill_proc_id.options.length;
	for(var i=0;i<len;i++) {
		f_query_add_mod.document.formSRRIPFillListUnallocDrugs.p_fill_proc_id.remove("p_fill_proc_id") ;
	}


	var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---";
	var opt = document.createElement("OPTION") ;
	opt.text = tp ;
	opt.value = "" ;
	f_query_add_mod.document.formSRRIPFillListUnallocDrugs.p_fill_proc_id.add(opt);*/
	
}

function run() {
	
	var frmObject = f_query_add_mod.document.formSRRIPFillListUnallocDrugs;
	if(f_query_add_mod.document.formSRRIPFillListUnallocDrugs) {
	 //alert("P_PATIENT_ID--->"+frmObject.P_PAT_ID.value);
	var fields= new Array (frmObject.p_disp_locn,frmObject.p_fill_proc_dt1,frmObject.p_fill_proc_id,frmObject.p_report_type);
	var names = new Array (getLabel("ePH.DispenseLocation.label","PH"),getLabel("ePH.FillProcessDate.label","PH"),getLabel("ePH.FillProcessID.label","PH"),getLabel("Common.reporttype.label","Common"));

      if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			
			 frmObject.p_fill_proc_dt.value=convertDate(frmObject.p_fill_proc_dt1.value,'DMY', frmObject.p_language_id.value,'en');
			
			 frmObject.submit();
			
		}
	}
}
/* This Function Can Be Added By SureshKumarT For The SRRNo :SRR20056-SCF-7499 [Incident No. 027551] On 20/07/2011 */


function selectReport(obj){
	if(obj.value=="DT"){
		document.formSRRIPFillListUnallocDrugs.p_report_id.value="PHUNALDRGMED";
	}
	else{
		document.formSRRIPFillListUnallocDrugs.p_report_id.value="PHUNALDRGMES";
	}
}
