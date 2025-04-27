function reset() 
{
	f_query_add_mod.document.ChangePatPhone.contact1_no.value = f_query_add_mod.document.ChangePatPhone.old_contact1_no.value;
	f_query_add_mod.document.ChangePatPhone.contact2_no.value = f_query_add_mod.document.ChangePatPhone.old_contact2_no.value;
}

function apply() 
{
	f_query_add_mod.document.ChangePatPhone.submit();
	f_query_add_mod.document.ChangePatPhone.old_contact1_no.value=f_query_add_mod.document.ChangePatPhone.contact1_no.value;
	f_query_add_mod.document.ChangePatPhone.old_contact2_no.value=f_query_add_mod.document.ChangePatPhone.contact2_no.value;
}