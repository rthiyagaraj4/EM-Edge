function show() {
	parent.window.document.title = "Residence Area" ;
}

function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/ResidenceArea.jsp" ;
}

function query() {
	f_query_add_mod.location.href ="../../eSM/jsp/querySMFunctionForm.jsp?function=SmFunction";
}

function apply() {
	var fields = new Array ( f_query_add_mod.document.res_area_form.res_area_code,
						f_query_add_mod.document.res_area_form.long_desc,
						f_query_add_mod.document.res_area_form.short_desc,
						f_query_add_mod.document.res_area_form.region_code						
					    );	
	var names = new Array ( getLabel("Common.code.label","Common"), 
						getLabel("Common.longdescription.label","Common"),
						getLabel("Common.shortdescription.label","Common"),
						getLabel("eMP.Regioncode.label ","mp")
					      );	
	var transform = new Array (	f_query_add_mod.document.res_area_form,
							f_query_add_mod.document.res_area_form.eff_date_from,
							f_query_add_mod.document.res_area_form.eff_date_from1,
							f_query_add_mod.document.res_area_form.eff_date_to,
							f_query_add_mod.document.res_area_form.eff_date_to1
						   );		
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
		if(f_query_add_mod.DateTransform(transform,messageFrame)) {	
		}	
	}
}

function reset() {
		if(f_query_add_mod.document.forms[0])
		// f_query_add_mod.document.forms[0].reset() ;
		  f_query_add_mod.document.location.reload();

}

function onSuccess() {
	f_query_add_mod.res_area_form.res_area_code.value	= "" ;
	f_query_add_mod.res_area_form.long_desc.value		= "" ;
	f_query_add_mod.res_area_form.short_desc.value	= "" ;
	f_query_add_mod.res_area_form.eff_date_from1.value	= "" ;
	f_query_add_mod.res_area_form.eff_date_to1.value	= "" ;
	f_query_add_mod.res_area_form.region_code.item(0).selected=true;
}
function show() {
	parent.window.document.title = "Residence Area" ;
}

function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/ResidenceArea.jsp" ;
}

function query() {
	f_query_add_mod.location.href ="../../eSM/jsp/querySMFunctionForm.jsp?function=SmFunction";
}

function apply() {
	var fields = new Array ( f_query_add_mod.document.res_area_form.res_area_code,
						f_query_add_mod.document.res_area_form.long_desc,
						f_query_add_mod.document.res_area_form.short_desc,
						f_query_add_mod.document.res_area_form.region_code						
					    );	
	var names = new Array ( getLabel("Common.code.label","Common"), 
						getLabel("Common.longdescription.label","Common"),
						getLabel("Common.shortdescription.label","Common"),
						getLabel("eMP.Regioncode.label ","mp")
					      );	
	var transform = new Array (	f_query_add_mod.document.res_area_form,
							f_query_add_mod.document.res_area_form.eff_date_from,
							f_query_add_mod.document.res_area_form.eff_date_from1,
							f_query_add_mod.document.res_area_form.eff_date_to,
							f_query_add_mod.document.res_area_form.eff_date_to1
						   );		
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
		if(f_query_add_mod.DateTransform(transform,messageFrame)) {	
		}	
	}
}



function onSuccess() {
	f_query_add_mod.res_area_form.res_area_code.value	= "" ;
	f_query_add_mod.res_area_form.long_desc.value		= "" ;
	f_query_add_mod.res_area_form.short_desc.value	= "" ;
	f_query_add_mod.res_area_form.eff_date_from1.value	= "" ;
	f_query_add_mod.res_area_form.eff_date_to1.value	= "" ;
	f_query_add_mod.res_area_form.region_code.item(0).selected=true;
}
