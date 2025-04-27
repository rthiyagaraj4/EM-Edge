function create() {
	f_query_add_mod.location.href = "../../eOP/html/PCFirst.html" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eOP/jsp/queryPractitionerClinicPage.jsp?function=PractitionerClinic";
}

function apply() {
var fields = new Array ( f_query_add_mod.document.clinic_form.clinic,
			f_query_add_mod.document.clinic_form.practitioner);

var names = new Array ( getLabel("Common.clinic.label","Common"),getLabel("Common.practitioner.label","Common"));
		var transform = new Array (	f_query_add_mod.document.clinic_form,
						f_query_add_mod.document.clinic_form.eff_date_from,
						f_query_add_mod.document.clinic_form.eff_date_from1,
						f_query_add_mod.document.clinic_form.eff_date_to,
						f_query_add_mod.document.clinic_form.eff_date_to1

					  );


		if(f_query_add_mod.checkFields( fields, names, messageFrame)) {

			if(f_query_add_mod.DateTransform(transform,messageFrame)) {
			}
		}



}


function onSuccess() {
	f_query_add_mod.one.clinic_form.clinic.value	= "" ;
	f_query_add_mod.one.clinic_form.practitioner.value	= "" ;
	f_query_add_mod.one.clinic_form.eff_date_from1.value	= "" ;
	f_query_add_mod.one.clinic_form.eff_date_to1.value	= "" ;
}
