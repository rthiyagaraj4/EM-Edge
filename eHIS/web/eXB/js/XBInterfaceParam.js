/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
 //********************************************************************************************
//FUNCTION APPLY
//********************************************************************************************
function apply() 
{
	f_query_add_mod.document.forms[0].Profile_id.disabled = false;
	var fields = new Array (
		f_query_add_mod.document.forms[0].Profile_id,
		f_query_add_mod.document.forms[0].dbf_table_name,
		f_query_add_mod.document.forms[0].dbf_source_directory,
		f_query_add_mod.document.forms[0].dbf_dest_directory,
		f_query_add_mod.document.forms[0].exe_name, 
		f_query_add_mod.document.forms[0].dbf_table_create_stmt,
		f_query_add_mod.document.forms[0].dbf_column_hdng,
		f_query_add_mod.document.forms[0].log_directory,f_query_add_mod.document.forms[0].sdx_diag_cnt,f_query_add_mod.document.forms[0].proc_diag_cnt,f_query_add_mod.document.forms[0].drg_query,f_query_add_mod.document.forms[0].user_def_str);
 		var names = new Array ( getLabel("eXH.ProfileId.Label","XH"),getLabel("eXH.DbfTableName.Label","XH"),getLabel("eXH.DbfSourceDir.Label","XH"),getLabel("eXH.DbfDestDir.Label","XH"),getLabel("eXH.ExternalExeName.Label","XH"),getLabel("eXH.DbfTableCreateStmt.Label","XH"),getLabel("eXH.DbfColumnHdng.Label","XH"),getLabel("eXH.LogDir.Label","XH"),getLabel("eXH.SecDiagCount.Label","XH"),getLabel("eXH.PrcDiagCount.Label","XH"),getLabel("eXH.DRGQry.Label","XH"),getLabel("eXH.UserDefStr.Label","XH"));
 		if(!f_query_add_mod.checkFields( fields, names, messageFrame))
		{
		  
		}
		else 
		{
	
		f_query_add_mod.document.forms[0].submit();
	}
	f_query_add_mod.document.forms[0].Profile_id.disabled = true;
	window.commontoolbarFrame.document.location.reload();	
}

 //********************************************************************************************
//FUNCTION RESET
//********************************************************************************************
function reset()
{
	window.f_query_add_mod.document.location.reload();	
}
