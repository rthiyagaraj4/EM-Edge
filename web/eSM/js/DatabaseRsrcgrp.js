function create() 
{
	f_query_add_mod.location.href = "../../eSM/jsp/AddModifyDatabaseRsrcgrp.jsp?operation=insert" ;	
}

function deleterecord()
{
	if(f_query_add_mod.document.DBResourceGrp_form!=null){
	if(f_query_add_mod.document.DBResourceGrp_form.function_name.value=="insert") 
	{
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
	else if(f_query_add_mod.document.DBResourceGrp_form.function_name.value=="modify" || f_query_add_mod.document.DBResourceGrp_form.function_name.value=="delete") 
	{		
		if(confirm(f_query_add_mod.getMessage('DELETE_RECORD','Common')))		
		{
		f_query_add_mod.document.DBResourceGrp_form.function_name.value="delete";	
		f_query_add_mod.document.DBResourceGrp_form.submit();
		}
		else
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num= "
	}
	}
else
{
	frames[0].location.reload();
	return false;
}
}

function query() {
	f_query_add_mod.location.href ="../../eSM/jsp/DatabaseRsrcgrpQueryCriteria.jsp?operation=query" ;
}

function apply() 
{	
	if(f_query_add_mod.document.DBResourceGrp_form!=null){

	if(f_query_add_mod.document.DBResourceGrp_form.function_name.value =="delete")	
		f_query_add_mod.document.DBResourceGrp_form.function_name.value="modify";	
		
	var fields = new Array ( f_query_add_mod.document.DBResourceGrp_form.ORA_RSRC_GROUP_ID,
				 f_query_add_mod.document.DBResourceGrp_form.ORA_RSRC_GROUP_NAME
			       );
			       
	var names = new Array ( getLabel("Common.identification.label","Common"), 
				getLabel("Common.name.label","Common")
			      );
				  
	var field = new Array ( f_query_add_mod.document.DBResourceGrp_form.ORA_RSRC_GROUP_ID
			       );
			       
	var name = new Array ( getLabel("Common.identification.label","Common")
			      );	

	if (f_query_add_mod.DBResourceGrp_form.prohibitReuse.value == 'P')
	{
		f_query_add_mod.DBResourceGrp_form.ORA_PWD_REUSE_TIME.value="";
		f_query_add_mod.DBResourceGrp_form.ORA_PWD_REUSE_MAX.value="";
	}

if (f_query_add_mod.DBResourceGrp_form.prohibitReuse.value=='R')
{
//Maheshwaran K added for the Password Validation as on 18/07/2012 to validate the Reuse After field
fields.push(f_query_add_mod.document.DBResourceGrp_form.ORA_PWD_REUSE_TIME);
field.push(f_query_add_mod.document.DBResourceGrp_form.ORA_PWD_REUSE_TIME);
names.push("Reuse After");
name.push("Reuse After");
//End
	if (f_query_add_mod.DBResourceGrp_form.changes.value =="C")
	{
		f_query_add_mod.DBResourceGrp_form.change_type.value="C";
	}
	else
	{
		f_query_add_mod.DBResourceGrp_form.change_type.value="D";
	}
}
else
	{
		f_query_add_mod.DBResourceGrp_form.change_type.value="";
	}

    if(f_query_add_mod.DBResourceGrp_form.elements[3].checked){
    	fields.push(f_query_add_mod.document.DBResourceGrp_form.password_expiry_alert_days);
    	names.push(getLabel("eSM.PasswordExpiryAlert.label","SM"));
    }
    
	if( f_query_add_mod.checkFieldsofMst( fields, names, messageFrame) )
		if (f_query_add_mod.SpecialCharCheck (field,name,messageFrame,'M','MstCodeError.jsp'))
			f_query_add_mod.document.DBResourceGrp_form.submit() ;
}
else
{
	frames[0].location.reload();
	return false;
}
}

function reset()
{
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.location.reload();
}

function onSuccess() 
{
	if(f_query_add_mod.document.DBResourceGrp_form.function_name.value =="delete")	
		f_query_add_mod.location.href='../../eCommon/html/blank.html'
	else
		f_query_add_mod.document.location.reload();

	
}
