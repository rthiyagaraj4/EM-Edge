// Added/Modified By Nanda 10/22/2002
function onSuccess() 
 {
		 f_query_add_mod.document.location.reload();
 }
 


function reset() 
  {
	 //f_query_add_mod.document.forms[0].reset() ;
//	 f_query_add_mod.document.location.reload();

		f_query_add_mod.document.forms[0].er_gcs_code1_weight0.value=f_query_add_mod.document.forms[0].er_gcs_code1_score.value;
		f_query_add_mod.document.forms[0].er_gcs_code1_weight1.value=f_query_add_mod.document.forms[0].er_gcs_code2_score.value;
		f_query_add_mod.document.forms[0].er_gcs_code1_weight2.value=f_query_add_mod.document.forms[0].er_gcs_code3_score.value;
		f_query_add_mod.document.forms[0].er_gcs_code1_weight3.value=f_query_add_mod.document.forms[0].er_gcs_code4_score.value;

		f_query_add_mod.document.forms[0].vr_gcs_code1_weight0.value=f_query_add_mod.document.forms[0].vr_gcs_code1_score.value;
		f_query_add_mod.document.forms[0].vr_gcs_code1_weight1.value=f_query_add_mod.document.forms[0].vr_gcs_code2_score.value;
		f_query_add_mod.document.forms[0].vr_gcs_code1_weight2.value=f_query_add_mod.document.forms[0].vr_gcs_code3_score.value;
		f_query_add_mod.document.forms[0].vr_gcs_code1_weight3.value=f_query_add_mod.document.forms[0].vr_gcs_code4_score.value;
		f_query_add_mod.document.forms[0].vr_gcs_code1_weight4.value=f_query_add_mod.document.forms[0].vr_gcs_code5_score.value;

		f_query_add_mod.document.forms[0].mr_gcs_code1_weight0.value=f_query_add_mod.document.forms[0].mr_gcs_code1_score.value;
		f_query_add_mod.document.forms[0].mr_gcs_code1_weight1.value=f_query_add_mod.document.forms[0].mr_gcs_code2_score.value;
		f_query_add_mod.document.forms[0].mr_gcs_code1_weight2.value=f_query_add_mod.document.forms[0].mr_gcs_code3_score.value;
		f_query_add_mod.document.forms[0].mr_gcs_code1_weight3.value=f_query_add_mod.document.forms[0].mr_gcs_code4_score.value;
		f_query_add_mod.document.forms[0].mr_gcs_code1_weight4.value=f_query_add_mod.document.forms[0].mr_gcs_code5_score.value;
		f_query_add_mod.document.forms[0].mr_gcs_code1_weight5.value=f_query_add_mod.document.forms[0].mr_gcs_code6_score.value;

  } 

function apply()
{ 
	var er_val_repeated = false;
	var vr_val_repeated = false;
	var mr_val_repeated = false;
	var err				= '';
	// Get the Values for the ER Weight Score
	var er_values0 = eval("f_query_add_mod.document.forms[0].er_gcs_code1_weight0.value;");
	var er_values1 = eval("f_query_add_mod.document.forms[0].er_gcs_code1_weight1.value;");
	var er_values2 = eval("f_query_add_mod.document.forms[0].er_gcs_code1_weight2.value;");
	var er_values3 = eval("f_query_add_mod.document.forms[0].er_gcs_code1_weight3.value;");
	// Get the Values for the VR Weight Score
	var vr_values0 = eval("f_query_add_mod.document.forms[0].vr_gcs_code1_weight0.value;");
	var vr_values1 = eval("f_query_add_mod.document.forms[0].vr_gcs_code1_weight1.value;");
	var vr_values2 = eval("f_query_add_mod.document.forms[0].vr_gcs_code1_weight2.value;");
	var vr_values3 = eval("f_query_add_mod.document.forms[0].vr_gcs_code1_weight3.value;");
	var vr_values4 = eval("f_query_add_mod.document.forms[0].vr_gcs_code1_weight4.value;");
	// Get the Values for the MR Weight Score
	var mr_values0 = eval("f_query_add_mod.document.forms[0].mr_gcs_code1_weight0.value;");
	var mr_values1 = eval("f_query_add_mod.document.forms[0].mr_gcs_code1_weight1.value;");
	var mr_values2 = eval("f_query_add_mod.document.forms[0].mr_gcs_code1_weight2.value;");
	var mr_values3 = eval("f_query_add_mod.document.forms[0].mr_gcs_code1_weight3.value;");
	var mr_values4 = eval("f_query_add_mod.document.forms[0].mr_gcs_code1_weight4.value;");
	var mr_values5 = eval("f_query_add_mod.document.forms[0].mr_gcs_code1_weight5.value;");
	

	var er_error_desc = f_query_add_mod.document.forms[0].er_error_desc.value;
	var vr_error_desc = f_query_add_mod.document.forms[0].vr_error_desc.value;
	var mr_error_desc = f_query_add_mod.document.forms[0].mr_error_desc.value;
	// For ER Weight Scores
	if(
		 (er_values0 == er_values1) || (er_values0 == er_values2) || (er_values0 == er_values3) || 
		 (er_values1 == er_values2) || (er_values1 == er_values3) ||
		 (er_values2 == er_values3) || 
		 (er_values3 == er_values1) 
	  )
	 {
		er_val_repeated = true;
		
		var error=getMessage("SCORE_CANNOT_REPE",'AE');
		error=error.replace("$",er_error_desc);
		error = error + "<br>" ;
		err += error;
     }

	 // For VR Weight Scores
	 if(
		 (vr_values0 == vr_values1) || (vr_values0 == vr_values2) || (vr_values0 == vr_values3) || (vr_values0 == vr_values4) || 
		 (vr_values1 == vr_values2) || (vr_values1 == vr_values3) || (vr_values1 == vr_values4) ||
		 (vr_values2 == vr_values3) || (vr_values2 == vr_values4) || 
		 (vr_values3 == vr_values4) 
	  )
	 {
		vr_val_repeated = true;
		
		var error=getMessage("SCORE_CANNOT_REPE",'AE');
		error=error.replace("$",vr_error_desc)
		error = error + "<br>" ;
		err += error;
     }

	 // For MR Weight Scores
	 if(
		 (mr_values0 == mr_values1) || (mr_values0 == mr_values2) || (mr_values0 == mr_values3) || (mr_values0 == mr_values4) || (mr_values0 == mr_values5) || 
		 (mr_values1 == mr_values2) || (mr_values1 == mr_values3) || (mr_values1 == mr_values4) || (mr_values1 == mr_values5) ||
		 (mr_values2 == mr_values3) || (mr_values2 == mr_values4) || (mr_values2 == mr_values5) ||
		 (mr_values3 == mr_values4) || (mr_values3 == mr_values5) || 
		 (mr_values4 == mr_values5) 
	  )
	 {
		mr_val_repeated = true;
		var error=getMessage("SCORE_CANNOT_REPE",'AE');
		error=error.replace("$",mr_error_desc);
		error = error + "<br>" ;
		err += error;
     }

	 if(er_val_repeated || vr_val_repeated || mr_val_repeated)
 	 {
		parent.frames[2].frames[2].document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err;		
	 }
	 else
	 {
		f_query_add_mod.document.forms[0].submit();
	 }
}
