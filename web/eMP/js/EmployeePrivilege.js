/*Created by Ashwini on 14-May-2019 for TBMC-CRF-0010.1*/
function chkEmployeePrivilege()
{	
	var National_ID = document.forms[0].national_id_no.value;
	var Language_ID = document.forms[0].localeName.value;
	var nat_id_chk = document.forms[0].nat_id_chk.value;

	var xmlDoc=""
	var xmlHttp = new XMLHttpRequest()
	xmlStr = "<root><SEARCH National_ID=\""+National_ID+"\" Language_ID=\""+Language_ID+"\" action='validateEmpPrivilege' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../jsp/MPIntermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	var returnVal = trimString(responseText);
	var arr = returnVal.split("#");
	var national_id_no = arr[0];
	var employee_or_family = arr[1];

	if(National_ID == national_id_no)
	{
		document.forms[0].emp_privilege_button.style.display = "inline";

		if(document.forms[0].uploaded_pat_yn)
		document.forms[0].uploaded_pat_yn.value = 'Y';

		if(National_ID != nat_id_chk)
		{
			if(document.forms[0].emp_privilege_button.style.display == "inline")
			{
				if(document.forms[0].name_prefix)
				{
					document.forms[0].name_prefix.value = "";
					document.forms[0].name_prefix.onchange();
				}

				if(document.forms[0].first_name)
				{
					document.forms[0].first_name.value = "";
					document.forms[0].first_name.onblur();
				}

				if(document.forms[0].second_name)
				{
					document.forms[0].second_name.value = "";
					document.forms[0].second_name.onblur();
				}

				if(document.forms[0].family_name)
				{
					document.forms[0].family_name.value = "";
					document.forms[0].family_name.onblur();
				}

				if(document.forms[0].other_alt_id)
					document.forms[0].other_alt_id.value = "";

				if(document.forms[0].other_alt_Id_text)
				{
					document.forms[0].other_alt_Id_text.disabled = true;
					document.forms[0].other_alt_Id_text.value = "";
				}

				if(document.getElementById('next_contact_relation_desc'))
					document.getElementById('next_contact_relation_desc').value = "";

				if(document.getElementById('next_contact_relation'))
					document.getElementById('next_contact_relation').value = "";

				if(document.getElementById('contact1_oth_alt_id_type'))
					document.getElementById('contact1_oth_alt_id_type').value = "";

				if(document.getElementById('contact1_oth_alt_id_no'))
				{
					document.getElementById('contact1_oth_alt_id_no').disabled = true;
					document.getElementById('contact1_oth_alt_id_no').value = "";
				}
			}
		}
	}
	else if((National_ID != national_id_no) && National_ID == "")
	{
		if(document.forms[0].emp_privilege_button.style.display == "inline")
		{
			if(document.forms[0].name_prefix)
			{
				document.forms[0].name_prefix.value = "";
				document.forms[0].name_prefix.onchange();
			}

			if(document.forms[0].first_name)
			{
				document.forms[0].first_name.value = "";
				document.forms[0].first_name.onblur();
			}

			if(document.forms[0].second_name)
			{
				document.forms[0].second_name.value = "";
				document.forms[0].second_name.onblur();
			}

			if(document.forms[0].family_name)
			{
				document.forms[0].family_name.value = "";
				document.forms[0].family_name.onblur();
			}

			if(document.forms[0].uploaded_pat_yn)
				document.forms[0].uploaded_pat_yn.value = 'N';

			if(document.forms[0].other_alt_id)
				document.forms[0].other_alt_id.value = "";

			if(document.forms[0].other_alt_Id_text)
			{
				document.forms[0].other_alt_Id_text.disabled = true;
				document.forms[0].other_alt_Id_text.value = "";
			}

			if(document.getElementById('next_contact_relation_desc'))
				document.getElementById('next_contact_relation_desc').value = "";

			if(document.getElementById('next_contact_relation'))
				document.getElementById('next_contact_relation').value = "";

			if(document.getElementById('contact1_oth_alt_id_type'))
				document.getElementById('contact1_oth_alt_id_type').value = "";

			if(document.getElementById('contact1_oth_alt_id_no'))
			{
				document.getElementById('contact1_oth_alt_id_no').disabled = true;
				document.getElementById('contact1_oth_alt_id_no').value = "";
			}
		}

		document.forms[0].emp_privilege_button.style.display = "none";
	}
}

function populateEmpData()
{	
	var National_ID = document.forms[0].national_id_no.value;
	var Language_ID = document.forms[0].localeName.value;

	var xmlDoc=""
	var xmlHttp = new XMLHttpRequest()
	xmlStr = "<root><SEARCH National_ID=\""+National_ID+"\" Language_ID=\""+Language_ID+"\" action='validateEmpPrivilege' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../jsp/MPIntermediate.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	var returnVal = trimString(responseText);

	var arr = returnVal.split("#");
	var national_id_no = arr[0];
	var employee_or_family = arr[1];
	var name_prefix = arr[2];
	var first_name = arr[3];
	var second_name = arr[4];
	var last_name = arr[5];
	var ref_employee_id = arr[6];
	var relationship_to_employee = arr[7];
	var relationship_to_emp_desc = arr[8];
	var prefix_eff_status = arr[9];
	var alt_id_eff_status = arr[10];

	if(document.forms[0].name_prefix && prefix_eff_status == 'E')
	{
		document.forms[0].name_prefix.value = name_prefix;
		document.forms[0].name_prefix.onchange();
	}

	if(document.forms[0].first_name)
	{
		document.forms[0].first_name.value = first_name;
		document.forms[0].first_name.onblur();
	}

	if(document.forms[0].second_name)
	{
		document.forms[0].second_name.value = second_name;
		document.forms[0].second_name.onblur();
	}

	if(document.forms[0].family_name)
	{
		document.forms[0].family_name.value = last_name;
		document.forms[0].family_name.onblur();
	}

	if(document.forms[0].nat_id_chk)
		document.forms[0].nat_id_chk.value = national_id_no;

	if(employee_or_family == 'E')
	{
		if(ref_employee_id != '' && alt_id_eff_status == 'E')
		{
			if(document.forms[0].other_alt_id)
				document.forms[0].other_alt_id.value = 'ID5';

			if(document.forms[0].other_alt_Id_text)
			{
				document.forms[0].other_alt_Id_text.disabled = false;
				document.forms[0].other_alt_Id_text.value = ref_employee_id;
			}
		}
	}
	else if(employee_or_family == 'F')
	{
		if(relationship_to_emp_desc != '')
		{
			if(document.getElementById('next_contact_relation_desc'))
				document.getElementById('next_contact_relation_desc').value = relationship_to_emp_desc;

			if(document.getElementById('next_contact_relation'))
				document.getElementById('next_contact_relation').value = relationship_to_employee;
		}

		if(ref_employee_id != '' && alt_id_eff_status == 'E')
		{
			if(document.getElementById('contact1_oth_alt_id_type'))
				document.getElementById('contact1_oth_alt_id_type').value = 'ID5';

			if(document.getElementById('contact1_oth_alt_id_no'))
			{
				document.getElementById('contact1_oth_alt_id_no').disabled = false;
				document.getElementById('contact1_oth_alt_id_no').value = ref_employee_id;
			}
		}
	}
}
/*End TBMC-CRF-0010.1*/
