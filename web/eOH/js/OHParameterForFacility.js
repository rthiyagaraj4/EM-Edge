//for permanent quadrant chart
var q1_val = "";
var q2_val = "";
var q3_val = "";
var q4_val = "";
var q1_dflt_val = "";
var q2_dflt_val = "";
var q3_dflt_val = "";
var q4_dflt_val = "";
//for deciduous quadrant chart
var dec_q1_val = "";
var dec_q2_val = "";
var dec_q3_val = "";
var dec_q4_val = "";
var dec_q1_dflt_val = "";
var dec_q2_dflt_val = "";
var dec_q3_dflt_val = "";
var dec_q4_dflt_val = "";

//for mixed quadrant chart
var md_q1_val = "";
var md_q2_val = "";
var md_q3_val = "";
var md_q4_val = "";
var md_q1_dflt_val = "";
var md_q2_dflt_val = "";
var md_q3_dflt_val = "";
var md_q4_dflt_val = "";

//for permanent sextant chart
var s1_val="";
var s2_val="";
var s3_val="";
var s4_val="";
var s5_val="";
var s6_val="";
var s1_dflt_val="";
var s2_dflt_val="";
var s3_dflt_val="";
var s4_dflt_val="";
var s5_dflt_val="";
var s6_dflt_val="";

//for deciduous sextant chart
var dec_s1_val="";
var dec_s2_val="";
var dec_s3_val="";
var dec_s4_val="";
var dec_s5_val="";
var dec_s6_val="";
var dec_s1_dflt_val="";
var dec_s2_dflt_val="";
var dec_s3_dflt_val="";
var dec_s4_dflt_val="";
var dec_s5_dflt_val="";
var dec_s6_dflt_val="";

//for mixed sextant chart
var md_s1_val="";
var md_s2_val="";
var md_s3_val="";
var md_s4_val="";
var md_s5_val="";
var md_s6_val="";
var md_s1_dflt_val="";
var md_s2_dflt_val="";
var md_s3_dflt_val="";
var md_s4_dflt_val="";
var md_s5_dflt_val="";
var md_s6_dflt_val="";
var from_mixed="";

var mixed_val="";

function reset(){  
	var formObj = document.OHParameterForFacilityForm;
	var params = "";

	if(formObj!=null) params = formObj.params.value;
	messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
	f_query_add_mod.document.location.href="../../eOH/jsp/OHParameterForFacilityAddModify.jsp?"+params;
   //reset the sextant and quadrant frame on click of  reset,  added by parul
   f_query_add_mod_gs.document.location.href="../../eOH/jsp/OHParamForFacilityAddModifyQuadrant.jsp?"+params;
   f_query_add_mod_gs.document.location.href="../../eOH/jsp/OHParamForFacilityAddModifySextant.jsp?"+params;
  }

function apply(){
	var formObj = f_query_add_mod.document.forms[0];
	var chrt_level = formObj.chrt_level.value;
	var chk_quad=checkRecorded();
		if (chk_quad==false){
			formObj.chk_recorded.value="N";
		}else{
			formObj.chk_recorded.value="Y";
		}
	if (chrt_level=="F"){
		var frm = f_query_add_mod_gs.document.forms[0];
		var tooth_numbering_system = frm.tooth_numbering_system.value;
		var gingival_recording_by=frm.gigival_recorded.value;
		var dflt_mixed_dentition_chart=formObj.dflt_mixed_dentition_chart.value;
		var md="";
		var toothnumsyslable=getLabel("eOH.ToothNumberingSystem.Label","OH");
		var MixedDentitionFromAgeYrs_label=getLabel("eOH.MixedDentitionFromAgeYrs.Label","OH");
		var MixedDentitionToAgeYrs_label=getLabel("eOH.MixedDentitionToAgeYrs.Label","OH");
			if (dflt_mixed_dentition_chart=="D"){
					md=getLabel("eOH.DeciduousMD.Label","OH");
			  } else{
					md=getLabel("eOH.PermanentMD.Label","OH");
			  }

	
			if(frm.name=="OHParameterForFacilityFormForQuadrant"){
				if(formObj.record_gingival_status_yn.checked == true){
				var gs_no_of_tooth_for_Q1_label ="MaxNumOfTooth of"+" "+getLabel("Common.Permanent.label","COMMON")+" "+"UR";
				var gs_no_of_tooth_for_Q2_label ="MaxNumOfTooth of"+" "+getLabel("Common.Permanent.label","COMMON")+" "+"UL";
				var gs_no_of_tooth_for_Q3_label ="MaxNumOfTooth of"+" "+getLabel("Common.Permanent.label","COMMON")+" "+"LR";
				var gs_no_of_tooth_for_Q4_label ="MaxNumOfTooth of"+" "+getLabel("Common.Permanent.label","COMMON")+" "+"LL";

				var dec_gs_no_of_tooth_for_Q1_label ="MaxNumOfTooth of"+" "+getLabel("eOH.Decedious.Label","OH")+" "+"UR";
				var dec_gs_no_of_tooth_for_Q2_label ="MaxNumOfTooth of"+" "+getLabel("eOH.Decedious.Label","OH")+" "+"UL";
				var dec_gs_no_of_tooth_for_Q3_label ="MaxNumOfTooth of"+" "+getLabel("eOH.Decedious.Label","OH")+" "+"LR";
				var dec_gs_no_of_tooth_for_Q4_label ="MaxNumOfTooth of"+" "+getLabel("eOH.Decedious.Label","OH")+" "+"LL";


				var md_gs_no_of_tooth_for_Q1_label ="MaxNumOfTooth of"+" "+md+" "+"UR";
				var md_gs_no_of_tooth_for_Q2_label ="MaxNumOfTooth of"+" "+md+" "+"UL";
				var md_gs_no_of_tooth_for_Q3_label ="MaxNumOfTooth of"+" "+md+" "+"LR";
				var md_gs_no_of_tooth_for_Q4_label ="MaxNumOfTooth of"+" "+md+" "+"LL";
			 
				var p_upper_right = "UR"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("Common.Permanent.label","COMMON");
				var p_upper_left = "UL"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("Common.Permanent.label","COMMON");
				var p_lower_right = "LR"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("Common.Permanent.label","COMMON");
				var p_lower_left = "LL"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("Common.Permanent.label","COMMON");

				var dec_upper_right= "UR"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("eOH.Decedious.Label","OH");
				var dec_upper_left= "UL"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("eOH.Decedious.Label","OH");
				var dec_lower_right= "LR"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("eOH.Decedious.Label","OH");
				var dec_lower_left= "LL"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("eOH.Decedious.Label","OH");

				var md_upper_right ="UR"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+md;
				var md_upper_left ="UL"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+md;
				var md_lower_right ="LR"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+md;
				var md_lower_left ="LL"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+md;

				var fields = new Array(formObj.tooth_numbering_system,formObj.mixed_dentition_from_age_yrs,formObj.mixed_dentition_to_age_yrs,frm.dec_gs_no_of_tooth_for_Q1,frm.dec_gs_no_of_tooth_for_Q2,frm.dec_gs_no_of_tooth_for_Q3,frm.dec_gs_no_of_tooth_for_Q4,frm.dec_gs_dflt_tooth_no_Q1,frm.dec_gs_dflt_tooth_no_Q2,frm.dec_gs_dflt_tooth_no_Q3,frm.dec_gs_dflt_tooth_no_Q4,frm.md_gs_no_of_tooth_for_Q1,frm.md_gs_no_of_tooth_for_Q2,frm.md_gs_no_of_tooth_for_Q3,frm.md_gs_no_of_tooth_for_Q4,frm.gs_no_of_tooth_for_Q1,frm.gs_no_of_tooth_for_Q2,frm.gs_no_of_tooth_for_Q3,frm.gs_no_of_tooth_for_Q4,frm.gs_dflt_tooth_no_Q1,frm.gs_dflt_tooth_no_Q2,frm.gs_dflt_tooth_no_Q3,frm.gs_dflt_tooth_no_Q4);
				var names = new Array (toothnumsyslable,MixedDentitionFromAgeYrs_label,MixedDentitionToAgeYrs_label,dec_gs_no_of_tooth_for_Q1_label,dec_gs_no_of_tooth_for_Q2_label,dec_gs_no_of_tooth_for_Q3_label,dec_gs_no_of_tooth_for_Q4_label,dec_upper_right,dec_upper_left,dec_lower_right,dec_lower_left,md_gs_no_of_tooth_for_Q1_label,md_gs_no_of_tooth_for_Q2_label,md_gs_no_of_tooth_for_Q3_label,md_gs_no_of_tooth_for_Q4_label,gs_no_of_tooth_for_Q1_label,gs_no_of_tooth_for_Q2_label,gs_no_of_tooth_for_Q3_label,gs_no_of_tooth_for_Q4_label,p_upper_right,p_upper_left,p_lower_right,p_lower_left);
				}
				else{
					var fields = new Array (formObj.tooth_numbering_system,formObj.mixed_dentition_from_age_yrs,formObj.mixed_dentition_to_age_yrs);
					var names = new Array (toothnumsyslable,MixedDentitionFromAgeYrs_label,MixedDentitionToAgeYrs_label);
				}
			}else{
				var tooth_numbering_system = formObj.tooth_numbering_system.value;
				var toothnumsyslable=getLabel("eOH.ToothNumberingSystem.Label","OH");
				var MixedDentitionFromAgeYrs_label=getLabel("eOH.MixedDentitionFromAgeYrs.Label","OH");
				var MixedDentitionToAgeYrs_label=getLabel("eOH.MixedDentitionToAgeYrs.Label","OH");
					
				if(formObj.record_gingival_status_yn.checked == true){
					//alert(document.getElementById(Permanent).value)

				var gs_no_of_tooth_for_S1_label ="MaxNumOfTooth of"+" "+getLabel("Common.Permanent.label","COMMON")+" "+"UR";
				var gs_no_of_tooth_for_S2_label ="MaxNumOfTooth of"+" "+getLabel("Common.Permanent.label","COMMON")+" "+"UA";
				var gs_no_of_tooth_for_S3_label ="MaxNumOfTooth of"+" "+getLabel("Common.Permanent.label","COMMON")+" "+"UL";
				var gs_no_of_tooth_for_S4_label ="MaxNumOfTooth of"+" "+getLabel("Common.Permanent.label","COMMON")+" "+"LL";
				var gs_no_of_tooth_for_S5_label ="MaxNumOfTooth of"+" "+getLabel("Common.Permanent.label","COMMON")+" "+"LA";
				var gs_no_of_tooth_for_S6_label ="MaxNumOfTooth of"+" "+getLabel("Common.Permanent.label","COMMON")+" "+"LR";

				var dec_gs_no_of_tooth_for_S1_label ="MaxNumOfTooth of"+" "+getLabel("eOH.Decedious.Label","OH")+" "+"UR";
				var dec_gs_no_of_tooth_for_S2_label ="MaxNumOfTooth of"+" "+getLabel("eOH.Decedious.Label","OH")+" "+"UA";
				var dec_gs_no_of_tooth_for_S3_label ="MaxNumOfTooth of"+" "+getLabel("eOH.Decedious.Label","OH")+" "+"UL";
				var dec_gs_no_of_tooth_for_S4_label ="MaxNumOfTooth of"+" "+getLabel("eOH.Decedious.Label","OH")+" "+"LL";
				var dec_gs_no_of_tooth_for_S5_label ="MaxNumOfTooth of"+" "+getLabel("eOH.Decedious.Label","OH")+" "+"LA";
				var dec_gs_no_of_tooth_for_S6_label ="MaxNumOfTooth of"+" "+getLabel("eOH.Decedious.Label","OH")+" "+"LR";


				var md_gs_no_of_tooth_for_S1_label ="MaxNumOfTooth of"+" "+md+" "+"UR";
				var md_gs_no_of_tooth_for_S2_label ="MaxNumOfTooth of"+" "+md+" "+"UA";
				var md_gs_no_of_tooth_for_S3_label ="MaxNumOfTooth of"+" "+md+" "+"UL";
				var md_gs_no_of_tooth_for_S4_label ="MaxNumOfTooth of"+" "+md+" "+"LL";
				var md_gs_no_of_tooth_for_S5_label ="MaxNumOfTooth of"+" "+md+" "+"LA";
				var md_gs_no_of_tooth_for_S6_label ="MaxNumOfTooth of"+" "+md+" "+"LR";


				var p_upper_right = "UR"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("Common.Permanent.label","COMMON");
				var p_upper_anterior = "UA"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("Common.Permanent.label","COMMON");
				var p_upper_left = "UL"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("Common.Permanent.label","COMMON");
				var p_lower_left = "LL"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("Common.Permanent.label","COMMON");
				var p_lower_anterior = "LA"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("Common.Permanent.label","COMMON");
				var p_lower_right = "LR"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("Common.Permanent.label","COMMON");
					
				var dec_upper_right= "UR"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("eOH.Decedious.Label","OH");
				var dec_upper_anterior= "UA"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("eOH.Decedious.Label","OH");
				var dec_upper_left= "UL"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("eOH.Decedious.Label","OH");
				var dec_lower_left= "LL"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("eOH.Decedious.Label","OH");
				var dec_lower_anterior= "LA"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("eOH.Decedious.Label","OH");
				var dec_lower_right= "LR"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("eOH.Decedious.Label","OH");

				var md_upper_right ="UR"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+md;
				var md_upper_anterior ="UA"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+md;
				var md_upper_left ="UL"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+md;
				var md_lower_left ="LL"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+md;
				var md_lower_anterior ="LA"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+md;
				var md_lower_right ="LR"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+md;
					
				var fields = new Array(formObj.tooth_numbering_system,formObj.mixed_dentition_from_age_yrs,formObj.mixed_dentition_to_age_yrs,frm.dec_gs_no_of_tooth_for_S1,frm.dec_gs_no_of_tooth_for_S2,frm.dec_gs_no_of_tooth_for_S3,frm.dec_gs_no_of_tooth_for_S4,frm.dec_gs_no_of_tooth_for_S5,frm.dec_gs_no_of_tooth_for_S6,frm.dec_gs_dflt_tooth_no_S1,frm.dec_gs_dflt_tooth_no_S2,frm.dec_gs_dflt_tooth_no_S3,frm.dec_gs_dflt_tooth_no_S4,frm.dec_gs_dflt_tooth_no_S5,frm.dec_gs_dflt_tooth_no_S6,frm.md_gs_no_of_tooth_for_S1,frm.md_gs_no_of_tooth_for_S2,frm.md_gs_no_of_tooth_for_S3,frm.md_gs_no_of_tooth_for_S4,frm.md_gs_no_of_tooth_for_S5,frm.md_gs_no_of_tooth_for_S6,frm.gs_no_of_tooth_for_S1,frm.gs_no_of_tooth_for_S2,frm.gs_no_of_tooth_for_S3,frm.gs_no_of_tooth_for_S4,frm.gs_no_of_tooth_for_S5,frm.gs_no_of_tooth_for_S6,frm.gs_dflt_tooth_no_S1,frm.gs_dflt_tooth_no_S2,frm.gs_dflt_tooth_no_S3,frm.gs_dflt_tooth_no_S4,frm.gs_dflt_tooth_no_S5,frm.gs_dflt_tooth_no_S6);

				var names = new Array (toothnumsyslable,MixedDentitionFromAgeYrs_label,MixedDentitionToAgeYrs_label,dec_gs_no_of_tooth_for_S1_label,dec_gs_no_of_tooth_for_S2_label,dec_gs_no_of_tooth_for_S3_label,dec_gs_no_of_tooth_for_S4_label,dec_gs_no_of_tooth_for_S5_label,dec_gs_no_of_tooth_for_S6_label,dec_upper_right,dec_upper_anterior,dec_upper_left,dec_lower_left,dec_lower_anterior,dec_lower_right,md_gs_no_of_tooth_for_S1_label,md_gs_no_of_tooth_for_S2_label,md_gs_no_of_tooth_for_S3_label,md_gs_no_of_tooth_for_S4_label,md_gs_no_of_tooth_for_S5_label,md_gs_no_of_tooth_for_S6_label,gs_no_of_tooth_for_S1_label,gs_no_of_tooth_for_S2_label,gs_no_of_tooth_for_S3_label,gs_no_of_tooth_for_S4_label,gs_no_of_tooth_for_S5_label,gs_no_of_tooth_for_S6_label,p_upper_right,p_upper_anterior,p_upper_left,p_lower_left,p_lower_anterior,p_lower_right);
					            			
	
				}
				else{
					var fields = new Array (formObj.tooth_numbering_system,formObj.mixed_dentition_from_age_yrs,formObj.mixed_dentition_to_age_yrs);
					var names = new Array (toothnumsyslable,MixedDentitionFromAgeYrs_label,MixedDentitionToAgeYrs_label);
				}
			}  
       
			if(checkFieldsofMst( fields, names, messageFrame)){
				var validate_flag = valdateFields();
				if(validate_flag==true){
					//hidden variable set at OHParamForFacilityAddModifyQuadrant.jsp,OHParamForFacilityAddModifySextant.jsp
					var record_gingival_status_yn_hid;
					var dflt_mixed_dentition_chart_hid;

					//hidden variable set at OHParameterForFacilityAddModify.jsp for quadrant
					var gs_no_of_tooth_for_Q1;
					var gs_no_of_tooth_for_Q2;
					var gs_no_of_tooth_for_Q3;
					var gs_no_of_tooth_for_Q4;
					var gs_dflt_tooth_no_Q1;
					var gs_dflt_tooth_no_Q2;
					var gs_dflt_tooth_no_Q3;
					var gs_dflt_tooth_no_Q4;

					var dec_gs_no_of_tooth_for_Q1;
					var dec_gs_no_of_tooth_for_Q2;
					var dec_gs_no_of_tooth_for_Q3;
					var dec_gs_no_of_tooth_for_Q4;
					var dec_gs_dflt_tooth_no_Q1;
					var dec_gs_dflt_tooth_no_Q2;
					var dec_gs_dflt_tooth_no_Q3;
					var dec_gs_dflt_tooth_no_Q4;

					var md_gs_no_of_tooth_for_Q1;
					var md_gs_no_of_tooth_for_Q2;
					var md_gs_no_of_tooth_for_Q3;
					var md_gs_no_of_tooth_for_Q4;
					var md_gs_dflt_tooth_no_Q1;
					var md_gs_dflt_tooth_no_Q2;
					var md_gs_dflt_tooth_no_Q3;
					var md_gs_dflt_tooth_no_Q4;


					//hidden variable set at OHParameterForFacilityAddModify.jsp for sextant
					var gs_no_of_tooth_for_S1;
					var gs_no_of_tooth_for_S2;
					var gs_no_of_tooth_for_S3;
					var gs_no_of_tooth_for_S4;
					var gs_no_of_tooth_for_S5;
					var gs_no_of_tooth_for_S6;
					var gs_dflt_tooth_no_S1;
					var gs_dflt_tooth_no_S2;
					var gs_dflt_tooth_no_S3;
					var gs_dflt_tooth_no_S4;
					var gs_dflt_tooth_no_S5;
					var gs_dflt_tooth_no_S6;

					var dec_gs_no_of_tooth_for_S1;
					var dec_gs_no_of_tooth_for_S2;
					var dec_gs_no_of_tooth_for_S3;
					var dec_gs_no_of_tooth_for_S4;
					var dec_gs_no_of_tooth_for_S5;
					var dec_gs_no_of_tooth_for_S6;
					var dec_gs_dflt_tooth_no_S1;
					var dec_gs_dflt_tooth_no_S2;
					var dec_gs_dflt_tooth_no_S3;
					var dec_gs_dflt_tooth_no_S4;
					var dec_gs_dflt_tooth_no_S5;
					var dec_gs_dflt_tooth_no_S6;

					var md_gs_no_of_tooth_for_S1;
					var md_gs_no_of_tooth_for_S2;
					var md_gs_no_of_tooth_for_S3;
					var md_gs_no_of_tooth_for_S4;
					var md_gs_no_of_tooth_for_S5;
					var md_gs_no_of_tooth_for_S6;
					var md_gs_dflt_tooth_no_S1;
					var md_gs_dflt_tooth_no_S2;
					var md_gs_dflt_tooth_no_S3;
					var md_gs_dflt_tooth_no_S4;
					var md_gs_dflt_tooth_no_S5;
					var md_gs_dflt_tooth_no_S6;

					var  record_gingival_status_yn=formObj.record_gingival_status_yn.value;
					frm.record_gingival_status_yn_hid.value=record_gingival_status_yn;
					if (gingival_recording_by=="Q"){
						var  gs_no_of_tooth_for_Q1=frm.gs_no_of_tooth_for_Q1.value;
						var  gs_no_of_tooth_for_Q2=frm.gs_no_of_tooth_for_Q2.value;
						var  gs_no_of_tooth_for_Q3=frm.gs_no_of_tooth_for_Q3.value;
						var  gs_no_of_tooth_for_Q4=frm.gs_no_of_tooth_for_Q4.value;
						var  gs_dflt_tooth_no_Q1=frm.gs_dflt_tooth_no_Q1.value;
						var  gs_dflt_tooth_no_Q2=frm.gs_dflt_tooth_no_Q2.value;
						var  gs_dflt_tooth_no_Q3=frm.gs_dflt_tooth_no_Q3.value;
						var  gs_dflt_tooth_no_Q4=frm.gs_dflt_tooth_no_Q4.value;

						var  dec_gs_no_of_tooth_for_Q1=frm.dec_gs_no_of_tooth_for_Q1.value;
						var  dec_gs_no_of_tooth_for_Q2=frm.dec_gs_no_of_tooth_for_Q2.value;
						var  dec_gs_no_of_tooth_for_Q3=frm.dec_gs_no_of_tooth_for_Q3.value;
						var  dec_gs_no_of_tooth_for_Q4=frm.dec_gs_no_of_tooth_for_Q4.value;
						var  dec_gs_dflt_tooth_no_Q1=frm.dec_gs_dflt_tooth_no_Q1.value;
						var  dec_gs_dflt_tooth_no_Q2=frm.dec_gs_dflt_tooth_no_Q2.value;
						var  dec_gs_dflt_tooth_no_Q3=frm.dec_gs_dflt_tooth_no_Q3.value;
						var  dec_gs_dflt_tooth_no_Q4=frm.dec_gs_dflt_tooth_no_Q4.value;

						var  md_gs_no_of_tooth_for_Q1=frm.md_gs_no_of_tooth_for_Q1.value;
						var  md_gs_no_of_tooth_for_Q2=frm.md_gs_no_of_tooth_for_Q2.value;
						var  md_gs_no_of_tooth_for_Q3=frm.md_gs_no_of_tooth_for_Q3.value;
						var  md_gs_no_of_tooth_for_Q4=frm.md_gs_no_of_tooth_for_Q4.value;
						var  md_gs_dflt_tooth_no_Q1=frm.md_gs_dflt_tooth_no_Q1.value;
						var  md_gs_dflt_tooth_no_Q2=frm.md_gs_dflt_tooth_no_Q2.value;
						var  md_gs_dflt_tooth_no_Q3=frm.md_gs_dflt_tooth_no_Q3.value;
						var  md_gs_dflt_tooth_no_Q4=frm.md_gs_dflt_tooth_no_Q4.value;


						formObj.gs_no_of_tooth_for_Q1.value=gs_no_of_tooth_for_Q1;
						formObj.gs_no_of_tooth_for_Q2.value=gs_no_of_tooth_for_Q2;
						formObj.gs_no_of_tooth_for_Q3.value=gs_no_of_tooth_for_Q3;
						formObj.gs_no_of_tooth_for_Q4.value=gs_no_of_tooth_for_Q4;
						formObj.gs_dflt_tooth_no_Q1.value=gs_dflt_tooth_no_Q1;
						formObj.gs_dflt_tooth_no_Q2.value=gs_dflt_tooth_no_Q2;
						formObj.gs_dflt_tooth_no_Q3.value=gs_dflt_tooth_no_Q3;
						formObj.gs_dflt_tooth_no_Q4.value=gs_dflt_tooth_no_Q4;

						formObj.dec_gs_no_of_tooth_for_Q1.value=dec_gs_no_of_tooth_for_Q1;
						formObj.dec_gs_no_of_tooth_for_Q2.value=dec_gs_no_of_tooth_for_Q2;
						formObj.dec_gs_no_of_tooth_for_Q3.value=dec_gs_no_of_tooth_for_Q3;
						formObj.dec_gs_no_of_tooth_for_Q4.value=dec_gs_no_of_tooth_for_Q4;
						formObj.dec_gs_dflt_tooth_no_Q1.value=dec_gs_dflt_tooth_no_Q1;
						formObj.dec_gs_dflt_tooth_no_Q2.value=dec_gs_dflt_tooth_no_Q2;
						formObj.dec_gs_dflt_tooth_no_Q3.value=dec_gs_dflt_tooth_no_Q3;
						formObj.dec_gs_dflt_tooth_no_Q4.value=dec_gs_dflt_tooth_no_Q4;

						formObj.md_gs_no_of_tooth_for_Q1.value=md_gs_no_of_tooth_for_Q1;
						formObj.md_gs_no_of_tooth_for_Q2.value=md_gs_no_of_tooth_for_Q2;
						formObj.md_gs_no_of_tooth_for_Q3.value=md_gs_no_of_tooth_for_Q3;
						formObj.md_gs_no_of_tooth_for_Q4.value=md_gs_no_of_tooth_for_Q4;
						formObj.md_gs_dflt_tooth_no_Q1.value=md_gs_dflt_tooth_no_Q1;
						formObj.md_gs_dflt_tooth_no_Q2.value=md_gs_dflt_tooth_no_Q2;
						formObj.md_gs_dflt_tooth_no_Q3.value=md_gs_dflt_tooth_no_Q3;
						formObj.md_gs_dflt_tooth_no_Q4.value=md_gs_dflt_tooth_no_Q4;

					}else{
						var  gs_no_of_tooth_for_S1=frm.gs_no_of_tooth_for_S1.value;
						var  gs_no_of_tooth_for_S2=frm.gs_no_of_tooth_for_S2.value;
						var  gs_no_of_tooth_for_S3=frm.gs_no_of_tooth_for_S3.value;
						var  gs_no_of_tooth_for_S4=frm.gs_no_of_tooth_for_S4.value;
						var  gs_no_of_tooth_for_S5=frm.gs_no_of_tooth_for_S5.value;
						var  gs_no_of_tooth_for_S6=frm.gs_no_of_tooth_for_S6.value;
						var  gs_dflt_tooth_no_S1=frm.gs_dflt_tooth_no_S1.value;
						var  gs_dflt_tooth_no_S2=frm.gs_dflt_tooth_no_S2.value;
						var  gs_dflt_tooth_no_S3=frm.gs_dflt_tooth_no_S3.value;
						var  gs_dflt_tooth_no_S4=frm.gs_dflt_tooth_no_S4.value;
						var  gs_dflt_tooth_no_S5=frm.gs_dflt_tooth_no_S5.value;
						var  gs_dflt_tooth_no_S6=frm.gs_dflt_tooth_no_S6.value;

						var  dec_gs_no_of_tooth_for_S1=frm.dec_gs_no_of_tooth_for_S1.value;
						var  dec_gs_no_of_tooth_for_S2=frm.dec_gs_no_of_tooth_for_S2.value;
						var  dec_gs_no_of_tooth_for_S3=frm.dec_gs_no_of_tooth_for_S3.value;
						var  dec_gs_no_of_tooth_for_S4=frm.dec_gs_no_of_tooth_for_S4.value;
						var  dec_gs_no_of_tooth_for_S5=frm.dec_gs_no_of_tooth_for_S5.value;
						var  dec_gs_no_of_tooth_for_S6=frm.dec_gs_no_of_tooth_for_S6.value;
						var  dec_gs_dflt_tooth_no_S1=frm.dec_gs_dflt_tooth_no_S1.value;
						var  dec_gs_dflt_tooth_no_S2=frm.dec_gs_dflt_tooth_no_S2.value;
						var  dec_gs_dflt_tooth_no_S3=frm.dec_gs_dflt_tooth_no_S3.value;
						var  dec_gs_dflt_tooth_no_S4=frm.dec_gs_dflt_tooth_no_S4.value;
						var  dec_gs_dflt_tooth_no_S5=frm.dec_gs_dflt_tooth_no_S5.value;
						var  dec_gs_dflt_tooth_no_S6=frm.dec_gs_dflt_tooth_no_S6.value;

						var  md_gs_no_of_tooth_for_S1=frm.md_gs_no_of_tooth_for_S1.value;
						var  md_gs_no_of_tooth_for_S2=frm.md_gs_no_of_tooth_for_S2.value;
						var  md_gs_no_of_tooth_for_S3=frm.md_gs_no_of_tooth_for_S3.value;
						var  md_gs_no_of_tooth_for_S4=frm.md_gs_no_of_tooth_for_S4.value;
						var  md_gs_no_of_tooth_for_S5=frm.md_gs_no_of_tooth_for_S5.value;
						var  md_gs_no_of_tooth_for_S6=frm.md_gs_no_of_tooth_for_S6.value;
						var  md_gs_dflt_tooth_no_S1=frm.md_gs_dflt_tooth_no_S1.value;
						var  md_gs_dflt_tooth_no_S2=frm.md_gs_dflt_tooth_no_S2.value;
						var  md_gs_dflt_tooth_no_S3=frm.md_gs_dflt_tooth_no_S3.value;
						var  md_gs_dflt_tooth_no_S4=frm.md_gs_dflt_tooth_no_S4.value;
						var  md_gs_dflt_tooth_no_S5=frm.md_gs_dflt_tooth_no_S5.value;
						var  md_gs_dflt_tooth_no_S6=frm.md_gs_dflt_tooth_no_S6.value;

						formObj.gs_no_of_tooth_for_S1.value=gs_no_of_tooth_for_S1;
						formObj.gs_no_of_tooth_for_S2.value=gs_no_of_tooth_for_S2;
						formObj.gs_no_of_tooth_for_S3.value=gs_no_of_tooth_for_S3;
						formObj.gs_no_of_tooth_for_S4.value=gs_no_of_tooth_for_S4;
						formObj.gs_no_of_tooth_for_S5.value=gs_no_of_tooth_for_S5;
						formObj.gs_no_of_tooth_for_S6.value=gs_no_of_tooth_for_S6;
						formObj.gs_dflt_tooth_no_S1.value=gs_dflt_tooth_no_S1;
						formObj.gs_dflt_tooth_no_S2.value=gs_dflt_tooth_no_S2;
						formObj.gs_dflt_tooth_no_S3.value=gs_dflt_tooth_no_S3;
						formObj.gs_dflt_tooth_no_S4.value=gs_dflt_tooth_no_S4;
						formObj.gs_dflt_tooth_no_S5.value=gs_dflt_tooth_no_S5;
						formObj.gs_dflt_tooth_no_S6.value=gs_dflt_tooth_no_S6;


						formObj.dec_gs_no_of_tooth_for_S1.value=dec_gs_no_of_tooth_for_S1;
						formObj.dec_gs_no_of_tooth_for_S2.value=dec_gs_no_of_tooth_for_S2;
						formObj.dec_gs_no_of_tooth_for_S3.value=dec_gs_no_of_tooth_for_S3;
						formObj.dec_gs_no_of_tooth_for_S4.value=dec_gs_no_of_tooth_for_S4;
						formObj.dec_gs_no_of_tooth_for_S5.value=dec_gs_no_of_tooth_for_S5;
						formObj.dec_gs_no_of_tooth_for_S6.value=dec_gs_no_of_tooth_for_S6;
						formObj.dec_gs_dflt_tooth_no_S1.value=dec_gs_dflt_tooth_no_S1;
						formObj.dec_gs_dflt_tooth_no_S2.value=dec_gs_dflt_tooth_no_S2;
						formObj.dec_gs_dflt_tooth_no_S3.value=dec_gs_dflt_tooth_no_S3;
						formObj.dec_gs_dflt_tooth_no_S4.value=dec_gs_dflt_tooth_no_S4;
						formObj.dec_gs_dflt_tooth_no_S5.value=dec_gs_dflt_tooth_no_S5;
						formObj.dec_gs_dflt_tooth_no_S6.value=dec_gs_dflt_tooth_no_S6;

						formObj.md_gs_no_of_tooth_for_S1.value=md_gs_no_of_tooth_for_S1;
						formObj.md_gs_no_of_tooth_for_S2.value=md_gs_no_of_tooth_for_S2;
						formObj.md_gs_no_of_tooth_for_S3.value=md_gs_no_of_tooth_for_S3;
						formObj.md_gs_no_of_tooth_for_S4.value=md_gs_no_of_tooth_for_S4;
						formObj.md_gs_no_of_tooth_for_S5.value=md_gs_no_of_tooth_for_S5;
						formObj.md_gs_no_of_tooth_for_S6.value=md_gs_no_of_tooth_for_S6;
						formObj.md_gs_dflt_tooth_no_S1.value=md_gs_dflt_tooth_no_S1;
						formObj.md_gs_dflt_tooth_no_S2.value=md_gs_dflt_tooth_no_S2;
						formObj.md_gs_dflt_tooth_no_S3.value=md_gs_dflt_tooth_no_S3;
						formObj.md_gs_dflt_tooth_no_S4.value=md_gs_dflt_tooth_no_S4;
						formObj.md_gs_dflt_tooth_no_S5.value=md_gs_dflt_tooth_no_S5;
						formObj.md_gs_dflt_tooth_no_S6.value=md_gs_dflt_tooth_no_S6;

					}
				
				if (formObj.record_gingival_status_yn.checked==true)
				{
					 formObj.record_gingival_status_yn.value="Y";
				}else{
					formObj.record_gingival_status_yn.value="N";
				 }
			}
			
		   	formObj.action="../../servlet/eOH.OHParameterForFacilityServlet";
		    //frm.action="../../servlet/eOH.OHParameterForFacilityQuadSextServlet";
			//frm.target="messageFrame";
			//frm.method="post" ;
			formObj.target="messageFrame";
			formObj.method="post" ;
			formObj.submit();

			//frm.submit();
		}
	}else if (chrt_level=="E"){
		 	formObj.action="../../servlet/eOH.OHParameterForFacilityServlet";
			formObj.target="messageFrame";
			formObj.method="post" ;
			formObj.submit();
	}
}

//added by parul on 09/06/2010 for IN021920	
function onSuccess(){
	var delay = function() { onSuccess1(); };
         setTimeout(delay,200);
}

function onSuccess1(){
 f_query_add_mod.location.reload();
}

function valdateFields(){
	var formObj = f_query_add_mod.document.forms[0];
	var mixed_dentition_from_age_yrs = formObj.mixed_dentition_from_age_yrs.value;
	var mixed_dentition_from_age_days = formObj.mixed_dentition_from_age_days.value;
	var mixed_dentition_to_age_yrs = formObj.mixed_dentition_to_age_yrs.value;
	var mixed_dentition_to_age_days = formObj.mixed_dentition_to_age_days.value;
    var all_zero_flag_yn = "N";
	var zero_count = 0;
	var data_count = 0;
	if(mixed_dentition_from_age_yrs!=""){
		data_count++;
		if(parseInt(mixed_dentition_from_age_yrs)==0){
			zero_count++;
		}
	}
	if(mixed_dentition_from_age_days!=""){
		data_count++;
		if(parseInt(mixed_dentition_from_age_days)==0){
			zero_count++;
		}
	}
	if(mixed_dentition_to_age_yrs!=""){ 
		data_count++;
		if(parseInt(mixed_dentition_to_age_yrs)==0){
			zero_count++;
		}
	}
	if(mixed_dentition_to_age_days!=""){
		data_count++;		
		if(parseInt(mixed_dentition_to_age_days)==0){
			zero_count++;
		}
	}
	if(data_count==zero_count){
		var err_msg = getMessage("APP-OH0006","OH");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+err_msg;
		return false;
	}
	return true;
}

function AssignDBValue(gingival_recording_by,record_gingival_status_yn){
	var obj = document.forms[0];
	var frmObj = parent.f_query_add_mod_gs.document.forms[0];
    var mode = document.forms[0].mode.value;
    var dflt_chart = document.forms[0].dflt_chart.value;
    var chrt_level = document.forms[0].chrt_level.value;
    var gingival_recording_by=gingival_recording_by;
	if (chrt_level=="E"){
			parent.f_query_add_mod_gs.document.location.href='../../eCommon/html/blank.html';

	}else if (chrt_level=="F"){
			var dflt_mixed_dentition_chart=obj.dflt_mixed_dentition_chart.value;

		 if (record_gingival_status_yn=="" || record_gingival_status_yn==null || record_gingival_status_yn=="null" || record_gingival_status_yn=="Y") { 
		   obj.gingival[0].disabled=true;
		   obj.gingival[1].disabled=true;
		}
		if(mode == "modify"){
			if(obj.dflt_mixed_dentition_chart.DB_VALUE == "" ){
				obj.dflt_mixed_dentition_chart.value = "";
				obj.dflt_mixed_dentition_chart.disabled = false;
			}
			else{
				var default_val = obj.dflt_mixed_dentition_chart.DB_VALUE;
				obj.dflt_mixed_dentition_chart.value = default_val;
				obj.dflt_mixed_dentition_chart.disabled = true;
			}
			

			if(obj.tooth_numbering_system.DB_VALUE == "" ){
				obj.tooth_numbering_system.value = "";
			}
			else{
				obj.tooth_numbering_system.value = obj.tooth_numbering_system.DB_VALUE
			}


			//added by parul in onLoad if  "quadrant" is checked it will load ..quadrant.jsp otherwise sextant
			if(gingival_recording_by =="Q"){
				obj.gigival_recorded.value="Q";
				parent.f_query_add_mod_gs.document.location.href="../../eOH/jsp/OHParamForFacilityAddModifyQuadrant.jsp?record_gingival_status_yn="+record_gingival_status_yn+"&chart_level="+chrt_level;
			}else{
				obj.gigival_recorded.value="S";
				parent.f_query_add_mod_gs.document.location.href="../../eOH/jsp/OHParamForFacilityAddModifySextant.jsp?record_gingival_status_yn="+record_gingival_status_yn+"&chart_level="+chrt_level;
			}

			if(obj.mixed_dentition_to_age_yrs.value != "" && obj.mixed_dentition_to_age_yrs.value != null && obj.mixed_dentition_to_age_yrs.value != "null"){
				obj.mixed_dentition_to_age_yrs.readOnly = true;
				obj.mixed_dentition_to_age_days.readOnly = true;
			}

			if(obj.mixed_dentition_from_age_yrs.value != "" && obj.mixed_dentition_from_age_yrs.value != null && obj.mixed_dentition_from_age_yrs.value != "null"){
				obj.mixed_dentition_from_age_yrs.readOnly = true;
				obj.mixed_dentition_from_age_days.readOnly = true;
			}
		}else if (mode == "insert"){
						
			parent.f_query_add_mod_gs.document.location.href="../../eOH/jsp/OHParamForFacilityAddModifySextant.jsp?record_gingival_status_yn="+record_gingival_status_yn+"&dflt_mixed_dentition_chart="+dflt_mixed_dentition_chart+"&chart_level="+chrt_level;
		}
	}
}


function setCheckValue(){
	var obj = document.forms[0];
	var frmObj = parent.f_query_add_mod_gs.document.forms[0];
    var gingival_recording_by=frmObj.gigival_recorded.value;
    var record_gingival_status_yn=obj.record_gingival_status_yn.value;
    var tooth_numbering_system=obj.tooth_numbering_system.value;
    var tooth_numbering_system_obj=obj.tooth_numbering_system;
	var default_select_lable=getLabel("eOH.DefaultSelect.Label","OH");
	var dflt_mixed_dentition_chart=obj.dflt_mixed_dentition_chart.value;
	var chrt_level=obj.chrt_level.value;
	var from_mixed_dentition="";
	if (dflt_mixed_dentition_chart=="P"){
		from_mixed_dentition="P";
	}else if (dflt_mixed_dentition_chart=="D"){
		from_mixed_dentition="D";
	}
	if(obj.record_gingival_status_yn.checked==true){
		obj.record_gingival_status_yn.value="Y";
		if (gingival_recording_by=="Q"){
				parent.f_query_add_mod_gs.document.location.href="../../eOH/jsp/OHParamForFacilityAddModifyQuadrant.jsp?record_gingival_status_yn=Y&callFrom=T&tooth_numbering_system="+tooth_numbering_system+"&from_mixed_dentition="+from_mixed_dentition+"&chrt_level="+chrt_level;

			frmObj.gs_no_of_tooth_for_Q1.value = "";
			frmObj.gs_no_of_tooth_for_Q2.value = "";
			frmObj.gs_no_of_tooth_for_Q3.value = "";
			frmObj.gs_no_of_tooth_for_Q4.value = "";
			frmObj.gs_dflt_tooth_no_Q1.value = "";
			frmObj.gs_dflt_tooth_no_Q2.value = "";
			frmObj.gs_dflt_tooth_no_Q3.value = "";
			frmObj.gs_dflt_tooth_no_Q4.value = "";
			obj.gingival[0].disabled=false;
			obj.gingival[1].disabled=false;

			frmObj.dec_gs_no_of_tooth_for_Q1.value = "";
			frmObj.dec_gs_no_of_tooth_for_Q2.value = "";
			frmObj.dec_gs_no_of_tooth_for_Q3.value = "";
			frmObj.dec_gs_no_of_tooth_for_Q4.value = "";
			frmObj.dec_gs_dflt_tooth_no_Q1.value = "";
			frmObj.dec_gs_dflt_tooth_no_Q2.value = "";
			frmObj.dec_gs_dflt_tooth_no_Q3.value = "";
			frmObj.dec_gs_dflt_tooth_no_Q4.value = "";

			frmObj.md_gs_no_of_tooth_for_Q1.value = "";
			frmObj.md_gs_no_of_tooth_for_Q2.value = "";
			frmObj.md_gs_no_of_tooth_for_Q3.value = "";
			frmObj.md_gs_no_of_tooth_for_Q4.value = "";
			frmObj.md_gs_dflt_tooth_no_Q1.value = "";
			frmObj.md_gs_dflt_tooth_no_Q2.value = "";
			frmObj.md_gs_dflt_tooth_no_Q3.value = "";
			frmObj.md_gs_dflt_tooth_no_Q4.value = "";
			 top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" ;


		}else{
	
			parent.f_query_add_mod_gs.document.location.href="../../eOH/jsp/OHParamForFacilityAddModifySextant.jsp?record_gingival_status_yn=Y&callFrom=T&tooth_numbering_system="+tooth_numbering_system+"&from_mixed_dentition="+from_mixed_dentition+"&chrt_level="+chrt_level;

			frmObj.gs_no_of_tooth_for_S1.value = "";
			frmObj.gs_no_of_tooth_for_S2.value = "";
			frmObj.gs_no_of_tooth_for_S3.value = "";
			frmObj.gs_no_of_tooth_for_S4.value = "";
			frmObj.gs_no_of_tooth_for_S5.value = "";
			frmObj.gs_no_of_tooth_for_S6.value = "";
			frmObj.gs_dflt_tooth_no_S1.value = "";
			frmObj.gs_dflt_tooth_no_S2.value = "";
			frmObj.gs_dflt_tooth_no_S3.value = "";
			frmObj.gs_dflt_tooth_no_S4.value = "";
			frmObj.gs_dflt_tooth_no_S5.value = "";
			frmObj.gs_dflt_tooth_no_S6.value = "";

			frmObj.dec_gs_no_of_tooth_for_S1.value = "";
			frmObj.dec_gs_no_of_tooth_for_S2.value = "";
			frmObj.dec_gs_no_of_tooth_for_S3.value = "";
			frmObj.dec_gs_no_of_tooth_for_S4.value = "";
			frmObj.dec_gs_no_of_tooth_for_S5.value = "";
			frmObj.dec_gs_no_of_tooth_for_S6.value = "";
			frmObj.dec_gs_dflt_tooth_no_S1.value = "";
			frmObj.dec_gs_dflt_tooth_no_S2.value = "";
			frmObj.dec_gs_dflt_tooth_no_S3.value = "";
			frmObj.dec_gs_dflt_tooth_no_S4.value = "";
			frmObj.dec_gs_dflt_tooth_no_S5.value = "";
			frmObj.dec_gs_dflt_tooth_no_S6.value = "";

			frmObj.md_gs_no_of_tooth_for_S1.value = "";
			frmObj.md_gs_no_of_tooth_for_S2.value = "";
			frmObj.md_gs_no_of_tooth_for_S3.value = "";
			frmObj.md_gs_no_of_tooth_for_S4.value = "";
			frmObj.md_gs_no_of_tooth_for_S5.value = "";
			frmObj.md_gs_no_of_tooth_for_S6.value = "";
			frmObj.md_gs_dflt_tooth_no_S1.value = "";
			frmObj.md_gs_dflt_tooth_no_S2.value = "";
			frmObj.md_gs_dflt_tooth_no_S3.value = "";
			frmObj.md_gs_dflt_tooth_no_S4.value = "";
			frmObj.md_gs_dflt_tooth_no_S5.value = "";
			frmObj.md_gs_dflt_tooth_no_S6.value = "";

			obj.gingival[0].disabled=false;
			obj.gingival[1].disabled=false;
			 top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" ;

		}

	}else{
		obj.record_gingival_status_yn.value="N";
		if(window.confirm(getMessage("APP-OH00092","OH")) == true)
		{
			if (gingival_recording_by=="Q"){

			var tab="";
			tab+='<input type="text" name="gs_no_of_tooth_for_Q1" id="gs_no_of_tooth_for_Q1" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
         //   tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q1").innerHTML=tab;
			var tab="";
			tab+='<input type="text" name="gs_no_of_tooth_for_Q2" id="gs_no_of_tooth_for_Q2" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q2").innerHTML=tab;
			var tab="";
			tab+='<input type="text" name="gs_no_of_tooth_for_Q3" id="gs_no_of_tooth_for_Q3" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q3").innerHTML=tab;
			var tab="";
			tab+='<input type="text" name="gs_no_of_tooth_for_Q4" id="gs_no_of_tooth_for_Q4" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q4").innerHTML=tab;

		   /* parent.f_query_add_mod_gs.document.getElementById("gs_for_Q1").innerHTML = '<input type="text" name="gs_no_of_tooth_for_Q1" id="gs_no_of_tooth_for_Q1" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q2").innerHTML = '<input type="text" name="gs_no_of_tooth_for_Q2" id="gs_no_of_tooth_for_Q2" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q3").innerHTML = '<input type="text" name="gs_no_of_tooth_for_Q3" id="gs_no_of_tooth_for_Q3" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q4").innerHTML = '<input type="text" name="gs_no_of_tooth_for_Q4" id="gs_no_of_tooth_for_Q4" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';*/
			var tab="";
			tab+='<select name="gs_dflt_tooth_no_Q1" id="gs_dflt_tooth_no_Q1" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
           // tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_Q1").innerHTML=tab;
			var tab="";
			tab+='<select name="gs_dflt_tooth_no_Q2" id="gs_dflt_tooth_no_Q2" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
           // tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_Q2").innerHTML=tab;
			var tab="";
			tab+='<select name="gs_dflt_tooth_no_Q3" id="gs_dflt_tooth_no_Q3" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
           // tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_Q3").innerHTML=tab;
			var tab="";
			tab+='<select name="gs_dflt_tooth_no_Q4" id="gs_dflt_tooth_no_Q4" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_Q4").innerHTML=tab;

			/*parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_Q1").innerHTML ='<select name="gs_dflt_tooth_no_Q1" id="gs_dflt_tooth_no_Q1" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_Q2").innerHTML = '<select name="gs_dflt_tooth_no_Q2" id="gs_dflt_tooth_no_Q2" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_Q3").innerHTML = '<select name="gs_dflt_tooth_no_Q3" id="gs_dflt_tooth_no_Q3" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_Q4").innerHTML = '<select name="gs_dflt_tooth_no_Q4" id="gs_dflt_tooth_no_Q4" value= "" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';*/
			var tab="";
			tab+='<input type="text" name="dec_gs_no_of_tooth_for_Q1" id="dec_gs_no_of_tooth_for_Q1" value="" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)">';
           // tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_for_Q1").innerHTML=tab;
			var tab="";
			tab+='<input type="text" name="dec_gs_no_of_tooth_for_Q2" id="dec_gs_no_of_tooth_for_Q2" value="" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)">';
           // tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_for_Q2").innerHTML=tab;
			var tab="";
			tab+='<input type="text" name="dec_gs_no_of_tooth_for_Q3" id="dec_gs_no_of_tooth_for_Q3" value="" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)">';
           // tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_for_Q3").innerHTML=tab;
			var tab="";
			tab+='<input type="text" name="dec_gs_no_of_tooth_for_Q4" id="dec_gs_no_of_tooth_for_Q4" value="" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)">';
           // tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_for_Q4").innerHTML=tab;


			/*parent.f_query_add_mod_gs.document.getElementById("dec_gs_for_Q1").innerHTML = '<input type="text" name="dec_gs_no_of_tooth_for_Q1" id="dec_gs_no_of_tooth_for_Q1" value="" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_for_Q2").innerHTML = '<input type="text" name="dec_gs_no_of_tooth_for_Q2" id="dec_gs_no_of_tooth_for_Q2" value="" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_for_Q3").innerHTML = '<input type="text" name="dec_gs_no_of_tooth_for_Q3" id="dec_gs_no_of_tooth_for_Q3" value="" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_for_Q4").innerHTML = '<input type="text" name="dec_gs_no_of_tooth_for_Q4" id="dec_gs_no_of_tooth_for_Q4" value="" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)">';*/
			var tab="";
			tab+='<select name="dec_gs_dflt_tooth_no_Q1" id="dec_gs_dflt_tooth_no_Q1" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
           // tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_dflt_for_Q1").innerHTML=tab;
			var tab="";
			tab+='<select name="dec_gs_dflt_tooth_no_Q2" id="dec_gs_dflt_tooth_no_Q2" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
           // tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_dflt_for_Q2").innerHTML=tab;
			var tab="";
			tab+='<select name="dec_gs_dflt_tooth_no_Q3" id="dec_gs_dflt_tooth_no_Q3" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_dflt_for_Q3").innerHTML=tab;
			var tab="";
			tab+='<select name="dec_gs_dflt_tooth_no_Q4" id="dec_gs_dflt_tooth_no_Q4" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
           // tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_dflt_for_Q4").innerHTML=tab;

			/*parent.f_query_add_mod_gs.document.getElementById("dec_gs_dflt_for_Q1").innerHTML ='<select name="dec_gs_dflt_tooth_no_Q1" id="dec_gs_dflt_tooth_no_Q1" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_dflt_for_Q2").innerHTML = '<select name="dec_gs_dflt_tooth_no_Q2" id="dec_gs_dflt_tooth_no_Q2" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_dflt_for_Q3").innerHTML = '<select name="dec_gs_dflt_tooth_no_Q3" id="dec_gs_dflt_tooth_no_Q3" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_dflt_for_Q4").innerHTML = '<select name="dec_gs_dflt_tooth_no_Q4" id="dec_gs_dflt_tooth_no_Q4" value= "" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';*/
			var tab="";
			tab+='<input type="text" name="md_gs_no_of_tooth_for_Q1" id="md_gs_no_of_tooth_for_Q1" value="" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)">';
           // tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("md_gs_for_Q1").innerHTML=tab;
			var tab="";
			tab+='<input type="text" name="md_gs_no_of_tooth_for_Q2" id="md_gs_no_of_tooth_for_Q2" value="" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)">';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("md_gs_for_Q2").innerHTML=tab;
			var tab="";
			tab+='<input type="text" name="md_gs_no_of_tooth_for_Q3" id="md_gs_no_of_tooth_for_Q3" value="" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)">';
           // tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("md_gs_for_Q3").innerHTML=tab;
			var tab="";
			tab+='<input type="text" name="md_gs_no_of_tooth_for_Q4" id="md_gs_no_of_tooth_for_Q4" value="" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)">';
         //   tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("md_gs_for_Q4").innerHTML=tab;


			/* parent.f_query_add_mod_gs.document.getElementById("md_gs_for_Q1").innerHTML = '<input type="text" name="md_gs_no_of_tooth_for_Q1" id="md_gs_no_of_tooth_for_Q1" value="" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("md_gs_for_Q2").innerHTML = '<input type="text" name="md_gs_no_of_tooth_for_Q2" id="md_gs_no_of_tooth_for_Q2" value="" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("md_gs_for_Q3").innerHTML = '<input type="text" name="md_gs_no_of_tooth_for_Q3" id="md_gs_no_of_tooth_for_Q3" value="" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("md_gs_for_Q4").innerHTML = '<input type="text" name="md_gs_no_of_tooth_for_Q4" id="md_gs_no_of_tooth_for_Q4" value="" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)">';*/

			parent.f_query_add_mod_gs.document.getElementById("md_gs_dflt_for_Q1").innerHTML ='<select name="md_gs_dflt_tooth_no_Q1" id="md_gs_dflt_tooth_no_Q1" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("md_gs_dflt_for_Q2").innerHTML = '<select name="md_gs_dflt_tooth_no_Q2" id="md_gs_dflt_tooth_no_Q2" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("md_gs_dflt_for_Q3").innerHTML = '<select name="md_gs_dflt_tooth_no_Q3" id="md_gs_dflt_tooth_no_Q3" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("md_gs_dflt_for_Q4").innerHTML = '<select name="md_gs_dflt_tooth_no_Q4" id="md_gs_dflt_tooth_no_Q4" value= "" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';

			frmObj.gs_no_of_tooth_for_Q1.disabled = true;
			frmObj.gs_no_of_tooth_for_Q2.disabled = true;
			frmObj.gs_no_of_tooth_for_Q3.disabled = true;
			frmObj.gs_no_of_tooth_for_Q4.disabled = true;
			frmObj.gs_dflt_tooth_no_Q1.disabled = true;
			frmObj.gs_dflt_tooth_no_Q2.disabled = true;
			frmObj.gs_dflt_tooth_no_Q3.disabled = true;
			frmObj.gs_dflt_tooth_no_Q4.disabled = true;
			obj.gingival[0].disabled=true;
			obj.gingival[1].disabled=true;

			frmObj.dec_gs_no_of_tooth_for_Q1.disabled = true;
			frmObj.dec_gs_no_of_tooth_for_Q2.disabled = true;
			frmObj.dec_gs_no_of_tooth_for_Q3.disabled = true;
			frmObj.dec_gs_no_of_tooth_for_Q4.disabled = true;
			frmObj.dec_gs_dflt_tooth_no_Q1.disabled = true;
			frmObj.dec_gs_dflt_tooth_no_Q2.disabled = true;
			frmObj.dec_gs_dflt_tooth_no_Q3.disabled = true;
			frmObj.dec_gs_dflt_tooth_no_Q4.disabled = true;

			frmObj.md_gs_no_of_tooth_for_Q1.disabled = true;
			frmObj.md_gs_no_of_tooth_for_Q2.disabled = true;
			frmObj.md_gs_no_of_tooth_for_Q3.disabled = true;
			frmObj.md_gs_no_of_tooth_for_Q4.disabled = true;
			frmObj.md_gs_dflt_tooth_no_Q1.disabled = true;
			frmObj.md_gs_dflt_tooth_no_Q2.disabled = true;
			frmObj.md_gs_dflt_tooth_no_Q3.disabled = true;
			frmObj.md_gs_dflt_tooth_no_Q4.disabled = true;
			top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" ;


		}else{
			frmObj.gs_no_of_tooth_for_S1.value = "";
			frmObj.gs_no_of_tooth_for_S2.value = "";
			frmObj.gs_no_of_tooth_for_S3.value ="";
			frmObj.gs_no_of_tooth_for_S4.value = "";
			frmObj.gs_no_of_tooth_for_S5.value = "";
			frmObj.gs_no_of_tooth_for_S6.value = "";
			frmObj.gs_dflt_tooth_no_S1.value = "";
			frmObj.gs_dflt_tooth_no_S2.value = "";
			frmObj.gs_dflt_tooth_no_S3.value = "";
			frmObj.gs_dflt_tooth_no_S4.value = "";
			frmObj.gs_dflt_tooth_no_S5.value = "";
			frmObj.gs_dflt_tooth_no_S6.value = "";

			frmObj.dec_gs_no_of_tooth_for_S1.value = "";
			frmObj.dec_gs_no_of_tooth_for_S2.value = "";
			frmObj.dec_gs_no_of_tooth_for_S3.value = "";
			frmObj.dec_gs_no_of_tooth_for_S4.value = "";
			frmObj.dec_gs_no_of_tooth_for_S5.value = "";
			frmObj.dec_gs_no_of_tooth_for_S6.value = "";
			frmObj.dec_gs_dflt_tooth_no_S1.value = "";
			frmObj.dec_gs_dflt_tooth_no_S2.value = "";
			frmObj.dec_gs_dflt_tooth_no_S3.value = "";
			frmObj.dec_gs_dflt_tooth_no_S4.value = "";
			frmObj.dec_gs_dflt_tooth_no_S5.value = "";
			frmObj.dec_gs_dflt_tooth_no_S6.value = "";

			frmObj.md_gs_no_of_tooth_for_S1.value = "";
			frmObj.md_gs_no_of_tooth_for_S2.value = "";
			frmObj.md_gs_no_of_tooth_for_S3.value = "";
			frmObj.md_gs_no_of_tooth_for_S4.value = "";
			frmObj.md_gs_no_of_tooth_for_S5.value = "";
			frmObj.md_gs_no_of_tooth_for_S6.value = "";
			frmObj.md_gs_dflt_tooth_no_S1.value = "";
			frmObj.md_gs_dflt_tooth_no_S2.value = "";
			frmObj.md_gs_dflt_tooth_no_S3.value = "";
			frmObj.md_gs_dflt_tooth_no_S4.value = "";
			frmObj.md_gs_dflt_tooth_no_S5.value = "";
			frmObj.md_gs_dflt_tooth_no_S6.value = "";
			var tab="";
			tab+='<input type="text" name="gs_no_of_tooth_for_S1" id="gs_no_of_tooth_for_S1" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q1").innerHTML=tab;
			tab="";
			tab+='<input type="text" name="gs_no_of_tooth_for_S2" id="gs_no_of_tooth_for_S2" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q2").innerHTML=tab;
			tab="";
			tab+='<input type="text" name="gs_no_of_tooth_for_S3" id="gs_no_of_tooth_for_S3" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q3").innerHTML=tab;
			tab="";
			tab+='<input type="text" name="gs_no_of_tooth_for_S4" id="gs_no_of_tooth_for_S4" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q4").innerHTML=tab;
			tab="";
			tab+='<input type="text" name="gs_no_of_tooth_for_S5" id="gs_no_of_tooth_for_S5" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q5").innerHTML=tab;
			tab="";
			tab+='<input type="text" name="gs_no_of_tooth_for_S6" id="gs_no_of_tooth_for_S6" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q6").innerHTML=tab;

			//parent.f_query_add_mod_gs.document.getElementById("gs_for_Q1").innerHTML = '<input type="text" name="gs_no_of_tooth_for_S1" id="gs_no_of_tooth_for_S1" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
			//parent.f_query_add_mod_gs.document.getElementById("gs_for_Q2").innerHTML = '<input type="text" name="gs_no_of_tooth_for_S2" id="gs_no_of_tooth_for_S2" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
			//parent.f_query_add_mod_gs.document.getElementById("gs_for_Q3").innerHTML = '<input type="text" name="gs_no_of_tooth_for_S3" id="gs_no_of_tooth_for_S3" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
			/*parent.f_query_add_mod_gs.document.getElementById("gs_for_Q4").innerHTML = '<input type="text" name="gs_no_of_tooth_for_S4" id="gs_no_of_tooth_for_S4" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q5").innerHTML = '<input type="text" name="gs_no_of_tooth_for_S5" id="gs_no_of_tooth_for_S5" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q6").innerHTML = '<input type="text" name="gs_no_of_tooth_for_S6" id="gs_no_of_tooth_for_S6" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';*/
			tab="";
			tab+='<select name="gs_dflt_tooth_no_S1" id="gs_dflt_tooth_no_S1" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
         //   tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_S1").innerHTML=tab;
			tab="";
			tab+='<select name="gs_dflt_tooth_no_S2" id="gs_dflt_tooth_no_S2" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_S2").innerHTML=tab;
			tab="";
			tab+='<select name="gs_dflt_tooth_no_S3" id="gs_dflt_tooth_no_S3" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
           // tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_S3").innerHTML=tab;
			tab="";
			tab+='<select name="gs_dflt_tooth_no_S4" id="gs_dflt_tooth_no_S4" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_S4").innerHTML=tab;
			tab="";
			tab+='<select name="gs_dflt_tooth_no_S5" id="gs_dflt_tooth_no_S5" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_S5").innerHTML=tab;
			tab="";
			tab+='<select name="gs_dflt_tooth_no_S6" id="gs_dflt_tooth_no_S6" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
         //   tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_S6").innerHTML=tab;

			/*parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_S1").innerHTML ='<select name="gs_dflt_tooth_no_S1" id="gs_dflt_tooth_no_S1" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_S2").innerHTML = '<select name="gs_dflt_tooth_no_S2" id="gs_dflt_tooth_no_S2" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_S3").innerHTML = '<select name="gs_dflt_tooth_no_S3" id="gs_dflt_tooth_no_S3" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_S4").innerHTML = '<select name="gs_dflt_tooth_no_S4" id="gs_dflt_tooth_no_S4" value= "" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_S5").innerHTML = '<select name="gs_dflt_tooth_no_S5" id="gs_dflt_tooth_no_S5" value= "" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_S6").innerHTML = '<select name="gs_dflt_tooth_no_S6" id="gs_dflt_tooth_no_S6" value= "" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';*/

			tab="";
			tab+='<input type="text" name="dec_gs_no_of_tooth_for_S1" id="dec_gs_no_of_tooth_for_S1" value="" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)">';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_for_Q1").innerHTML=tab;

			tab="";
			tab+='<input type="text" name="dec_gs_no_of_tooth_for_S2" id="dec_gs_no_of_tooth_for_S2" value="" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)">';
           // tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_for_Q2").innerHTML=tab;
			tab="";
			tab+='<input type="text" name="dec_gs_no_of_tooth_for_S3" id="dec_gs_no_of_tooth_for_S3" value="" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)">';
           // tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_for_Q3").innerHTML=tab;
			tab="";
			tab+='<input type="text" name="dec_gs_no_of_tooth_for_S4" id="dec_gs_no_of_tooth_for_S4" value="" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)">';
           // tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_for_Q4").innerHTML=tab;
			tab="";
			tab+='<input type="text" name="dec_gs_no_of_tooth_for_S5" id="dec_gs_no_of_tooth_for_S5" value="" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)">';
           // tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_for_Q5").innerHTML=tab;
			tab="";
			tab+='<input type="text" name="dec_gs_no_of_tooth_for_S6" id="dec_gs_no_of_tooth_for_S6" value="" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)">';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_for_Q6").innerHTML=tab;

			/*parent.f_query_add_mod_gs.document.getElementById("dec_gs_for_Q1").innerHTML = '<input type="text" name="dec_gs_no_of_tooth_for_S1" id="dec_gs_no_of_tooth_for_S1" value="" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_for_Q2").innerHTML = '<input type="text" name="dec_gs_no_of_tooth_for_S2" id="dec_gs_no_of_tooth_for_S2" value="" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_for_Q3").innerHTML = '<input type="text" name="dec_gs_no_of_tooth_for_S3" id="dec_gs_no_of_tooth_for_S3" value="" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_for_Q4").innerHTML = '<input type="text" name="dec_gs_no_of_tooth_for_S4" id="dec_gs_no_of_tooth_for_S4" value="" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_for_Q5").innerHTML = '<input type="text" name="dec_gs_no_of_tooth_for_S5" id="dec_gs_no_of_tooth_for_S5" value="" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_for_Q6").innerHTML = '<input type="text" name="dec_gs_no_of_tooth_for_S6" id="dec_gs_no_of_tooth_for_S6" value="" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)">';*/

			tab="";
			tab+='<select name="dec_gs_dflt_tooth_no_S1" id="dec_gs_dflt_tooth_no_S1" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_dflt_for_S1").innerHTML=tab;
			tab="";
			tab+='<select name="dec_gs_dflt_tooth_no_S2" id="dec_gs_dflt_tooth_no_S2" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_dflt_for_S2").innerHTML=tab;
			tab="";
			tab+='<select name="dec_gs_dflt_tooth_no_S3" id="dec_gs_dflt_tooth_no_S3" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_dflt_for_S3").innerHTML=tab;
            tab="";
			tab+='<select name="dec_gs_dflt_tooth_no_S4" id="dec_gs_dflt_tooth_no_S4" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_dflt_for_S4").innerHTML=tab;
			tab="";
			tab+='<select name="dec_gs_dflt_tooth_no_S5" id="dec_gs_dflt_tooth_no_S5" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
           // tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_dflt_for_S5").innerHTML=tab;
			tab="";
			tab+='<select name="dec_gs_dflt_tooth_no_S6" id="dec_gs_dflt_tooth_no_S6" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_dflt_for_S6").innerHTML=tab;



			/*parent.f_query_add_mod_gs.document.getElementById("dec_gs_dflt_for_S1").innerHTML ='<select name="dec_gs_dflt_tooth_no_S1" id="dec_gs_dflt_tooth_no_S1" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_dflt_for_S2").innerHTML ='<select name="dec_gs_dflt_tooth_no_S2" id="dec_gs_dflt_tooth_no_S2" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_dflt_for_S3").innerHTML ='<select name="dec_gs_dflt_tooth_no_S3" id="dec_gs_dflt_tooth_no_S3" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_dflt_for_S4").innerHTML ='<select name="dec_gs_dflt_tooth_no_S4" id="dec_gs_dflt_tooth_no_S4" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_dflt_for_S5").innerHTML ='<select name="dec_gs_dflt_tooth_no_S5" id="dec_gs_dflt_tooth_no_S5" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("dec_gs_dflt_for_S6").innerHTML ='<select name="dec_gs_dflt_tooth_no_S6" id="dec_gs_dflt_tooth_no_S6" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';*/
			tab="";
			tab+='<input type="text" name="md_gs_no_of_tooth_for_S1" id="md_gs_no_of_tooth_for_S1" value="" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)">';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("md_gs_for_Q1").innerHTML=tab;
			tab="";
			tab+='<input type="text" name="md_gs_no_of_tooth_for_S2" id="md_gs_no_of_tooth_for_S2" value="" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)">';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("md_gs_for_Q2").innerHTML=tab;
			tab="";
			tab+='<input type="text" name="md_gs_no_of_tooth_for_S3" id="md_gs_no_of_tooth_for_S3" value="" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)">';
           // tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("md_gs_for_Q3").innerHTML=tab;
            tab="";
			tab+='<input type="text" name="md_gs_no_of_tooth_for_S4" id="md_gs_no_of_tooth_for_S4" value="" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)">';
           // tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("md_gs_for_Q4").innerHTML=tab;
            tab="";
			tab+='<input type="text" name="md_gs_no_of_tooth_for_S5" id="md_gs_no_of_tooth_for_S5" value="" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)">';
           // tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("md_gs_for_Q5").innerHTML=tab;
            tab="";
			tab+='<input type="text" name="md_gs_no_of_tooth_for_S6" id="md_gs_no_of_tooth_for_S6" value="" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)">';
          //  tab+="<img src='../../eCommon/images/mandatory.gif'></img>";
			parent.f_query_add_mod_gs.document.getElementById("md_gs_for_Q6").innerHTML=tab;
    

			/*parent.f_query_add_mod_gs.document.getElementById("md_gs_for_Q1").innerHTML = '<input type="text" name="md_gs_no_of_tooth_for_S1" id="md_gs_no_of_tooth_for_S1" value="" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("md_gs_for_Q2").innerHTML = '<input type="text" name="md_gs_no_of_tooth_for_S2" id="md_gs_no_of_tooth_for_S2" value="" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("md_gs_for_Q3").innerHTML = '<input type="text" name="md_gs_no_of_tooth_for_S3" id="md_gs_no_of_tooth_for_S3" value="" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("md_gs_for_Q4").innerHTML = '<input type="text" name="md_gs_no_of_tooth_for_S4" id="md_gs_no_of_tooth_for_S4" value="" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("md_gs_for_Q5").innerHTML = '<input type="text" name="md_gs_no_of_tooth_for_S5" id="md_gs_no_of_tooth_for_S5" value="" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("md_gs_for_Q6").innerHTML = '<input type="text" name="md_gs_no_of_tooth_for_S6" id="md_gs_no_of_tooth_for_S6" value="" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)">';*/

			parent.f_query_add_mod_gs.document.getElementById("md_gs_dflt_for_S1").innerHTML ='<select name="md_gs_dflt_tooth_no_S1" id="md_gs_dflt_tooth_no_S1" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("md_gs_dflt_for_S2").innerHTML ='<select name="md_gs_dflt_tooth_no_S2" id="md_gs_dflt_tooth_no_S2" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("md_gs_dflt_for_S3").innerHTML ='<select name="md_gs_dflt_tooth_no_S3" id="md_gs_dflt_tooth_no_S3" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("md_gs_dflt_for_S4").innerHTML ='<select name="md_gs_dflt_tooth_no_S4" id="md_gs_dflt_tooth_no_S4" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("md_gs_dflt_for_S5").innerHTML ='<select name="md_gs_dflt_tooth_no_S5" id="md_gs_dflt_tooth_no_S5" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("md_gs_dflt_for_S6").innerHTML ='<select name="md_gs_dflt_tooth_no_S6" id="md_gs_dflt_tooth_no_S6" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';


			frmObj.gs_no_of_tooth_for_S2.disabled = true;
			frmObj.gs_no_of_tooth_for_S3.disabled = true;
			frmObj.gs_no_of_tooth_for_S4.disabled = true;
			frmObj.gs_no_of_tooth_for_S5.disabled = true;
			frmObj.gs_no_of_tooth_for_S6.disabled = true;
			frmObj.gs_dflt_tooth_no_S1.disabled = true;
			frmObj.gs_dflt_tooth_no_S2.disabled = true;
			frmObj.gs_dflt_tooth_no_S3.disabled = true;
			frmObj.gs_dflt_tooth_no_S4.disabled = true;
			frmObj.gs_dflt_tooth_no_S5.disabled = true;
			frmObj.gs_dflt_tooth_no_S6.disabled = true;

			frmObj.dec_gs_no_of_tooth_for_S1.disabled = true;
			frmObj.dec_gs_no_of_tooth_for_S2.disabled = true;
			frmObj.dec_gs_no_of_tooth_for_S3.disabled = true;
			frmObj.dec_gs_no_of_tooth_for_S4.disabled = true;
			frmObj.dec_gs_no_of_tooth_for_S5.disabled = true;
			frmObj.dec_gs_no_of_tooth_for_S6.disabled = true;
			frmObj.dec_gs_dflt_tooth_no_S1.disabled = true;
			frmObj.dec_gs_dflt_tooth_no_S2.disabled = true;
			frmObj.dec_gs_dflt_tooth_no_S3.disabled = true;
			frmObj.dec_gs_dflt_tooth_no_S4.disabled = true;
			frmObj.dec_gs_dflt_tooth_no_S5.disabled = true;
			frmObj.dec_gs_dflt_tooth_no_S6.disabled = true;

			frmObj.md_gs_no_of_tooth_for_S1.disabled = true;
			frmObj.md_gs_no_of_tooth_for_S2.disabled = true;
			frmObj.md_gs_no_of_tooth_for_S3.disabled = true;
			frmObj.md_gs_no_of_tooth_for_S4.disabled = true;
			frmObj.md_gs_no_of_tooth_for_S5.disabled = true;
			frmObj.md_gs_no_of_tooth_for_S6.disabled = true;
			frmObj.md_gs_dflt_tooth_no_S1.disabled = true;
			frmObj.md_gs_dflt_tooth_no_S2.disabled = true;
			frmObj.md_gs_dflt_tooth_no_S3.disabled = true;
			frmObj.md_gs_dflt_tooth_no_S4.disabled = true;
			frmObj.md_gs_dflt_tooth_no_S5.disabled = true;
			frmObj.md_gs_dflt_tooth_no_S6.disabled = true;

			obj.gingival[0].disabled=true;
			obj.gingival[1].disabled=true;
			top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" ;


		}
	 }else{
			if (gingival_recording_by=="Q"){
			obj.record_gingival_status_yn.value="Y";
			obj.record_gingival_status_yn.checked=true;
	        //commented by parul...when u click on "cancel", page should refresh with previous values of max no ,and default tooth no
			
           // var dflt_mixed_dentition_chart_hidden=frmObj.dflt_mixed_dentition_chart.value;
			var gs_no_of_tooth_for_Q1_hidden=frmObj.gs_no_of_tooth_for_Q1.value;
			var gs_no_of_tooth_for_Q2_hidden=frmObj.gs_no_of_tooth_for_Q2.value;
			var gs_no_of_tooth_for_Q3_hidden=frmObj.gs_no_of_tooth_for_Q3.value;
			var gs_no_of_tooth_for_Q4_hidden=frmObj.gs_no_of_tooth_for_Q4.value;
			var gs_dflt_tooth_no_Q1_hidden=frmObj.gs_dflt_tooth_no_Q1.value;
			var gs_dflt_tooth_no_Q2_hidden=frmObj.gs_dflt_tooth_no_Q2.value;
			var gs_dflt_tooth_no_Q3_hidden=frmObj.gs_dflt_tooth_no_Q3.value;
			var gs_dflt_tooth_no_Q4_hidden=frmObj.gs_dflt_tooth_no_Q4.value;

			var dec_gs_no_of_tooth_for_Q1_hidden=frmObj.dec_gs_no_of_tooth_for_Q1.value;
			var dec_gs_no_of_tooth_for_Q2_hidden=frmObj.dec_gs_no_of_tooth_for_Q2.value;
			var dec_gs_no_of_tooth_for_Q3_hidden=frmObj.dec_gs_no_of_tooth_for_Q3.value;
			var dec_gs_no_of_tooth_for_Q4_hidden=frmObj.dec_gs_no_of_tooth_for_Q4.value;
			var dec_gs_dflt_tooth_no_Q1_hidden=frmObj.dec_gs_dflt_tooth_no_Q1.value;
			var dec_gs_dflt_tooth_no_Q2_hidden=frmObj.dec_gs_dflt_tooth_no_Q2.value;
			var dec_gs_dflt_tooth_no_Q3_hidden=frmObj.dec_gs_dflt_tooth_no_Q3.value;
			var dec_gs_dflt_tooth_no_Q4_hidden=frmObj.dec_gs_dflt_tooth_no_Q4.value;

			var md_gs_no_of_tooth_for_Q1_hidden=frmObj.md_gs_no_of_tooth_for_Q1.value;
			var md_gs_no_of_tooth_for_Q2_hidden=frmObj.md_gs_no_of_tooth_for_Q2.value;
			var md_gs_no_of_tooth_for_Q3_hidden=frmObj.md_gs_no_of_tooth_for_Q3.value;
			var md_gs_no_of_tooth_for_Q4_hidden=frmObj.md_gs_no_of_tooth_for_Q4.value;
		    var md_gs_dflt_tooth_no_Q1_hidden=frmObj.md_gs_dflt_tooth_no_Q1.value;
		    var md_gs_dflt_tooth_no_Q2_hidden=frmObj.md_gs_dflt_tooth_no_Q2.value;
		    var md_gs_dflt_tooth_no_Q3_hidden=frmObj.md_gs_dflt_tooth_no_Q3.value;
		    var md_gs_dflt_tooth_no_Q4_hidden=frmObj.md_gs_dflt_tooth_no_Q4.value;

				
		//var params="record_gingival_status_yn=Y&tooth_numbering_system="+tooth_numbering_system+"&gs_no_of_tooth_for_Q1_hidden="+gs_no_of_tooth_for_Q1_hidden+"&gs_no_of_tooth_for_Q2_hidden="+gs_no_of_tooth_for_Q2_hidden+"&gs_no_of_tooth_for_Q3_hidden="+gs_no_of_tooth_for_Q3_hidden+"&gs_no_of_tooth_for_Q4_hidden="+gs_no_of_tooth_for_Q4_hidden+"&gs_dflt_tooth_no_Q1_hidden="+gs_dflt_tooth_no_Q1_hidden+"&gs_dflt_tooth_no_Q2_hidden="+gs_dflt_tooth_no_Q2_hidden+"&gs_dflt_tooth_no_Q3_hidden="+gs_dflt_tooth_no_Q3_hidden+"&gs_dflt_tooth_no_Q4_hidden="+gs_dflt_tooth_no_Q4_hidden+"&callFrom=Q";
			var params="record_gingival_status_yn=Y&tooth_numbering_system="+tooth_numbering_system+"&gs_no_of_tooth_for_Q1_hidden="+gs_no_of_tooth_for_Q1_hidden+"&gs_no_of_tooth_for_Q2_hidden="+gs_no_of_tooth_for_Q2_hidden+"&gs_no_of_tooth_for_Q3_hidden="+gs_no_of_tooth_for_Q3_hidden+"&gs_no_of_tooth_for_Q4_hidden="+gs_no_of_tooth_for_Q4_hidden+"&gs_dflt_tooth_no_Q1_hidden="+gs_dflt_tooth_no_Q1_hidden+"&gs_dflt_tooth_no_Q2_hidden="+gs_dflt_tooth_no_Q2_hidden+"&gs_dflt_tooth_no_Q3_hidden="+gs_dflt_tooth_no_Q3_hidden+"&gs_dflt_tooth_no_Q4_hidden="+gs_dflt_tooth_no_Q4_hidden+"&dec_gs_no_of_tooth_for_Q1_hidden="+dec_gs_no_of_tooth_for_Q1_hidden+"&dec_gs_no_of_tooth_for_Q2_hidden="+dec_gs_no_of_tooth_for_Q2_hidden+"&dec_gs_no_of_tooth_for_Q3_hidden="+dec_gs_no_of_tooth_for_Q3_hidden+"&dec_gs_no_of_tooth_for_Q4_hidden="+dec_gs_no_of_tooth_for_Q4_hidden+"&dec_gs_dflt_tooth_no_Q1_hidden="+dec_gs_dflt_tooth_no_Q1_hidden+"&dec_gs_dflt_tooth_no_Q2_hidden="+dec_gs_dflt_tooth_no_Q2_hidden+"&dec_gs_dflt_tooth_no_Q3_hidden="+dec_gs_dflt_tooth_no_Q3_hidden+"&dec_gs_dflt_tooth_no_Q4_hidden="+dec_gs_dflt_tooth_no_Q4_hidden+"&md_gs_no_of_tooth_for_Q1_hidden="+md_gs_no_of_tooth_for_Q1_hidden+"&md_gs_no_of_tooth_for_Q2_hidden="+md_gs_no_of_tooth_for_Q2_hidden+"&md_gs_no_of_tooth_for_Q3_hidden="+md_gs_no_of_tooth_for_Q3_hidden+"&md_gs_no_of_tooth_for_Q4_hidden="+md_gs_no_of_tooth_for_Q4_hidden+"&md_gs_dflt_tooth_no_Q1_hidden="+md_gs_dflt_tooth_no_Q1_hidden+"&md_gs_dflt_tooth_no_Q2_hidden="+md_gs_dflt_tooth_no_Q2_hidden+"&md_gs_dflt_tooth_no_Q3_hidden="+md_gs_dflt_tooth_no_Q3_hidden+"&md_gs_dflt_tooth_no_Q4_hidden="+md_gs_dflt_tooth_no_Q4_hidden+"&from_mixed_dentition="+from_mixed_dentition+"&chrt_level="+chrt_level+"&callFrom=Q";

			parent.f_query_add_mod_gs.document.location.href="../../eOH/jsp/OHParamForFacilityAddModifyQuadrant.jsp?"+params;
			top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" ;

          }
		  else{
			obj.record_gingival_status_yn.value="Y";
			obj.record_gingival_status_yn.checked=true;

			//commented by parul..when u click on "cancel", page should refresh with previous values of max no ,and default tooth no

			var  gs_no_of_tooth_for_S1_hidden=frmObj.gs_no_of_tooth_for_S1.value;
			var  gs_no_of_tooth_for_S2_hidden=frmObj.gs_no_of_tooth_for_S2.value;
			var  gs_no_of_tooth_for_S3_hidden=frmObj.gs_no_of_tooth_for_S3.value;
			var  gs_no_of_tooth_for_S4_hidden=frmObj.gs_no_of_tooth_for_S4.value;
			var  gs_no_of_tooth_for_S5_hidden=frmObj.gs_no_of_tooth_for_S5.value;
			var  gs_no_of_tooth_for_S6_hidden=frmObj.gs_no_of_tooth_for_S6.value;
			var  gs_dflt_tooth_no_S1_hidden=frmObj.gs_dflt_tooth_no_S1.value;
			var  gs_dflt_tooth_no_S2_hidden=frmObj.gs_dflt_tooth_no_S2.value;
			var  gs_dflt_tooth_no_S3_hidden=frmObj.gs_dflt_tooth_no_S3.value;
			var  gs_dflt_tooth_no_S4_hidden=frmObj.gs_dflt_tooth_no_S4.value;
			var  gs_dflt_tooth_no_S5_hidden=frmObj.gs_dflt_tooth_no_S5.value;
			var  gs_dflt_tooth_no_S6_hidden=frmObj.gs_dflt_tooth_no_S6.value;
					
			var  dec_gs_no_of_tooth_for_S1_hidden=frmObj.dec_gs_no_of_tooth_for_S1.value;
			var  dec_gs_no_of_tooth_for_S2_hidden=frmObj.dec_gs_no_of_tooth_for_S2.value;
			var  dec_gs_no_of_tooth_for_S3_hidden=frmObj.dec_gs_no_of_tooth_for_S3.value;
			var  dec_gs_no_of_tooth_for_S4_hidden=frmObj.dec_gs_no_of_tooth_for_S4.value;
			var  dec_gs_no_of_tooth_for_S5_hidden=frmObj.dec_gs_no_of_tooth_for_S5.value;
			var  dec_gs_no_of_tooth_for_S6_hidden=frmObj.dec_gs_no_of_tooth_for_S6.value;
			var  dec_gs_dflt_tooth_no_S1_hidden=frmObj.dec_gs_dflt_tooth_no_S1.value;
			var  dec_gs_dflt_tooth_no_S2_hidden=frmObj.dec_gs_dflt_tooth_no_S2.value;
			var  dec_gs_dflt_tooth_no_S3_hidden=frmObj.dec_gs_dflt_tooth_no_S3.value;
			var  dec_gs_dflt_tooth_no_S4_hidden=frmObj.dec_gs_dflt_tooth_no_S4.value;
			var  dec_gs_dflt_tooth_no_S5_hidden=frmObj.dec_gs_dflt_tooth_no_S5.value;
			var  dec_gs_dflt_tooth_no_S6_hidden=frmObj.dec_gs_dflt_tooth_no_S6.value;

			var  md_gs_no_of_tooth_for_S1_hidden=frmObj.md_gs_no_of_tooth_for_S1.value;
			var  md_gs_no_of_tooth_for_S2_hidden=frmObj.md_gs_no_of_tooth_for_S2.value;
			var  md_gs_no_of_tooth_for_S3_hidden=frmObj.md_gs_no_of_tooth_for_S3.value;
			var  md_gs_no_of_tooth_for_S4_hidden=frmObj.md_gs_no_of_tooth_for_S4.value;
			var  md_gs_no_of_tooth_for_S5_hidden=frmObj.md_gs_no_of_tooth_for_S5.value;
			var  md_gs_no_of_tooth_for_S6_hidden=frmObj.md_gs_no_of_tooth_for_S6.value;
			var  md_gs_dflt_tooth_no_S1_hidden=frmObj.md_gs_dflt_tooth_no_S1.value;
			var  md_gs_dflt_tooth_no_S2_hidden=frmObj.md_gs_dflt_tooth_no_S2.value;
			var  md_gs_dflt_tooth_no_S3_hidden=frmObj.md_gs_dflt_tooth_no_S3.value;
			var  md_gs_dflt_tooth_no_S4_hidden=frmObj.md_gs_dflt_tooth_no_S4.value;
			var  md_gs_dflt_tooth_no_S5_hidden=frmObj.md_gs_dflt_tooth_no_S5.value;
			var  md_gs_dflt_tooth_no_S6_hidden=frmObj.md_gs_dflt_tooth_no_S6.value;


			//var params= "record_gingival_status_yn=Y&tooth_numbering_system="+tooth_numbering_system+"&gs_no_of_tooth_for_S1_hidden="+gs_no_of_tooth_for_S1_hidden+"&gs_no_of_tooth_for_S2_hidden="+gs_no_of_tooth_for_S2_hidden+"&gs_no_of_tooth_for_S3_hidden="+gs_no_of_tooth_for_S3_hidden+"&gs_no_of_tooth_for_S4_hidden="+gs_no_of_tooth_for_S4_hidden+"&gs_no_of_tooth_for_S5_hidden="+gs_no_of_tooth_for_S5_hidden+"&gs_no_of_tooth_for_S6_hidden="+gs_no_of_tooth_for_S6_hidden+"&gs_dflt_tooth_no_S1_hidden="+gs_dflt_tooth_no_S1_hidden+"&gs_dflt_tooth_no_S2_hidden="+gs_dflt_tooth_no_S2_hidden+"&gs_dflt_tooth_no_S3_hidden="+gs_dflt_tooth_no_S3_hidden+"&gs_dflt_tooth_no_S4_hidden="+gs_dflt_tooth_no_S4_hidden+"&gs_dflt_tooth_no_S5_hidden="+gs_dflt_tooth_no_S5_hidden+"&gs_dflt_tooth_no_S6_hidden="+gs_dflt_tooth_no_S6_hidden+"&callFrom=S";
			var params= "record_gingival_status_yn=Y&tooth_numbering_system="+tooth_numbering_system+"&gs_no_of_tooth_for_S1_hidden="+gs_no_of_tooth_for_S1_hidden+"&gs_no_of_tooth_for_S2_hidden="+gs_no_of_tooth_for_S2_hidden+"&gs_no_of_tooth_for_S3_hidden="+gs_no_of_tooth_for_S3_hidden+"&gs_no_of_tooth_for_S4_hidden="+gs_no_of_tooth_for_S4_hidden+"&gs_no_of_tooth_for_S5_hidden="+gs_no_of_tooth_for_S5_hidden+"&gs_no_of_tooth_for_S6_hidden="+gs_no_of_tooth_for_S6_hidden+"&gs_dflt_tooth_no_S1_hidden="+gs_dflt_tooth_no_S1_hidden+"&gs_dflt_tooth_no_S2_hidden="+gs_dflt_tooth_no_S2_hidden+"&gs_dflt_tooth_no_S3_hidden="+gs_dflt_tooth_no_S3_hidden+"&gs_dflt_tooth_no_S4_hidden="+gs_dflt_tooth_no_S4_hidden+"&gs_dflt_tooth_no_S5_hidden="+gs_dflt_tooth_no_S5_hidden+"&gs_dflt_tooth_no_S6_hidden="+gs_dflt_tooth_no_S6_hidden+"&dec_gs_no_of_tooth_for_S1_hidden="+dec_gs_no_of_tooth_for_S1_hidden+"&dec_gs_no_of_tooth_for_S2_hidden="+dec_gs_no_of_tooth_for_S2_hidden+"&dec_gs_no_of_tooth_for_S3_hidden="+dec_gs_no_of_tooth_for_S3_hidden+"&dec_gs_no_of_tooth_for_S4_hidden="+dec_gs_no_of_tooth_for_S4_hidden+"&dec_gs_no_of_tooth_for_S5_hidden="+dec_gs_no_of_tooth_for_S5_hidden+"&dec_gs_no_of_tooth_for_S6_hidden="+dec_gs_no_of_tooth_for_S6_hidden+"&dec_gs_dflt_tooth_no_S1_hidden="+dec_gs_dflt_tooth_no_S1_hidden+"&dec_gs_dflt_tooth_no_S2_hidden="+dec_gs_dflt_tooth_no_S2_hidden+"&dec_gs_dflt_tooth_no_S3_hidden="+dec_gs_dflt_tooth_no_S3_hidden+"&dec_gs_dflt_tooth_no_S4_hidden="+dec_gs_dflt_tooth_no_S4_hidden+"&dec_gs_dflt_tooth_no_S5_hidden="+dec_gs_dflt_tooth_no_S5_hidden+"&dec_gs_dflt_tooth_no_S6_hidden="+dec_gs_dflt_tooth_no_S6_hidden+"&md_gs_no_of_tooth_for_S1_hidden="+md_gs_no_of_tooth_for_S1_hidden+"&md_gs_no_of_tooth_for_S2_hidden="+md_gs_no_of_tooth_for_S2_hidden+"&md_gs_no_of_tooth_for_S3_hidden="+md_gs_no_of_tooth_for_S3_hidden+"&md_gs_no_of_tooth_for_S4_hidden="+md_gs_no_of_tooth_for_S4_hidden+"&md_gs_no_of_tooth_for_S5_hidden="+md_gs_no_of_tooth_for_S5_hidden+"&md_gs_no_of_tooth_for_S6_hidden="+md_gs_no_of_tooth_for_S6_hidden+"&md_gs_dflt_tooth_no_S1_hidden="+md_gs_dflt_tooth_no_S1_hidden+"&md_gs_dflt_tooth_no_S2_hidden="+md_gs_dflt_tooth_no_S2_hidden+"&md_gs_dflt_tooth_no_S3_hidden="+md_gs_dflt_tooth_no_S3_hidden+"&md_gs_dflt_tooth_no_S4_hidden="+md_gs_dflt_tooth_no_S4_hidden+"&md_gs_dflt_tooth_no_S5_hidden="+md_gs_dflt_tooth_no_S5_hidden+"&md_gs_dflt_tooth_no_S6_hidden="+md_gs_dflt_tooth_no_S6_hidden+"&chrt_level="+chrt_level+"&from_mixed_dentition="+from_mixed_dentition+"&callFrom=S";


			parent.f_query_add_mod_gs.document.location.href="../../eOH/jsp/OHParamForFacilityAddModifySextant.jsp?"+params;
			top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" ;

		 }
	 }
  }
}	 
	 //commented by parul
	  /*
		obj.record_gingival_status_yn.value="N";		
		if (gingival_recording_by=="Q"){
			frmObj.gs_no_of_tooth_for_Q1.value = "";
			frmObj.gs_no_of_tooth_for_Q2.value = "";
			frmObj.gs_no_of_tooth_for_Q3.value = "";
			frmObj.gs_no_of_tooth_for_Q4.value = "";
			frmObj.gs_dflt_tooth_no_Q1.value = "";
			frmObj.gs_dflt_tooth_no_Q2.value = "";
			frmObj.gs_dflt_tooth_no_Q3.value = "";
			frmObj.gs_dflt_tooth_no_Q4.value = "";

			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q1").innerHTML = '<input type="text" name="gs_no_of_tooth_for_Q1" id="gs_no_of_tooth_for_Q1" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q2").innerHTML = '<input type="text" name="gs_no_of_tooth_for_Q2" id="gs_no_of_tooth_for_Q2" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q3").innerHTML = '<input type="text" name="gs_no_of_tooth_for_Q3" id="gs_no_of_tooth_for_Q3" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q4").innerHTML = '<input type="text" name="gs_no_of_tooth_for_Q4" id="gs_no_of_tooth_for_Q4" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';

			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_Q1").innerHTML ='<select name="gs_dflt_tooth_no_Q1" id="gs_dflt_tooth_no_Q1" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_Q2").innerHTML = '<select name="gs_dflt_tooth_no_Q2" id="gs_dflt_tooth_no_Q2" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_Q3").innerHTML = '<select name="gs_dflt_tooth_no_Q3" id="gs_dflt_tooth_no_Q3" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_Q4").innerHTML = '<select name="gs_dflt_tooth_no_Q4" id="gs_dflt_tooth_no_Q4" value= "" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';

			frmObj.gs_no_of_tooth_for_Q1.disabled = true;
			frmObj.gs_no_of_tooth_for_Q2.disabled = true;
			frmObj.gs_no_of_tooth_for_Q3.disabled = true;
			frmObj.gs_no_of_tooth_for_Q4.disabled = true;
			frmObj.gs_dflt_tooth_no_Q1.disabled = true;
			frmObj.gs_dflt_tooth_no_Q2.disabled = true;
			frmObj.gs_dflt_tooth_no_Q3.disabled = true;
			frmObj.gs_dflt_tooth_no_Q4.disabled = true;
		}
		else{
			frmObj.gs_no_of_tooth_for_S1.value = "";
			frmObj.gs_no_of_tooth_for_S2.value = "";
			frmObj.gs_no_of_tooth_for_S3.value ="";
			frmObj.gs_no_of_tooth_for_S4.value = "";
			frmObj.gs_no_of_tooth_for_S5.value = "";
			frmObj.gs_no_of_tooth_for_S6.value = "";
			frmObj.gs_dflt_tooth_no_S1.value = "";
			frmObj.gs_dflt_tooth_no_S2.value = "";
			frmObj.gs_dflt_tooth_no_S3.value = "";
			frmObj.gs_dflt_tooth_no_S4.value = "";
			frmObj.gs_dflt_tooth_no_S5.value = "";
			frmObj.gs_dflt_tooth_no_S6.value = "";

			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q1").innerHTML = '<input type="text" name="gs_no_of_tooth_for_S1" id="gs_no_of_tooth_for_S1" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q2").innerHTML = '<input type="text" name="gs_no_of_tooth_for_S2" id="gs_no_of_tooth_for_S2" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q3").innerHTML = '<input type="text" name="gs_no_of_tooth_for_S3" id="gs_no_of_tooth_for_S3" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q4").innerHTML = '<input type="text" name="gs_no_of_tooth_for_S4" id="gs_no_of_tooth_for_S4" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q5").innerHTML = '<input type="text" name="gs_no_of_tooth_for_S5" id="gs_no_of_tooth_for_S5" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';
			parent.f_query_add_mod_gs.document.getElementById("gs_for_Q6").innerHTML = '<input type="text" name="gs_no_of_tooth_for_S6" id="gs_no_of_tooth_for_S6" value="" size="1" maxlength="1" onBlur="validateNumOfTooth(this)">';

			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_S1").innerHTML ='<select name="gs_dflt_tooth_no_S1" id="gs_dflt_tooth_no_S1" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_S2").innerHTML = '<select name="gs_dflt_tooth_no_S2" id="gs_dflt_tooth_no_S2" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_S3").innerHTML = '<select name="gs_dflt_tooth_no_S3" id="gs_dflt_tooth_no_S3" value="" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_S4").innerHTML = '<select name="gs_dflt_tooth_no_S4" id="gs_dflt_tooth_no_S4" value= "" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_S5").innerHTML = '<select name="gs_dflt_tooth_no_S5" id="gs_dflt_tooth_no_S5" value= "" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';
			parent.f_query_add_mod_gs.document.getElementById("gs_dflt_for_S6").innerHTML = '<select name="gs_dflt_tooth_no_S6" id="gs_dflt_tooth_no_S6" value= "" onChange="populateToothNo(this)"><option value="">'+default_select_lable+'</option></select>';

			frmObj.gs_no_of_tooth_for_S1.disabled = true;
			frmObj.gs_no_of_tooth_for_S2.disabled = true;
			frmObj.gs_no_of_tooth_for_S3.disabled = true;
			frmObj.gs_no_of_tooth_for_S4.disabled = true;
			frmObj.gs_no_of_tooth_for_S5.disabled = true;
			frmObj.gs_no_of_tooth_for_S6.disabled = true;
			frmObj.gs_dflt_tooth_no_S1.disabled = true;
			frmObj.gs_dflt_tooth_no_S2.disabled = true;
			frmObj.gs_dflt_tooth_no_S3.disabled = true;
			frmObj.gs_dflt_tooth_no_S4.disabled = true;
			frmObj.gs_dflt_tooth_no_S5.disabled = true;
			frmObj.gs_dflt_tooth_no_S6.disabled = true;
		}
	}

}*/

function validateNumOfTooth(obj){
	var frmObj = parent.f_query_add_mod_gs.document.forms[0];
    var gingival_recording_by=frmObj.gigival_recorded.value;
	var msg = getMessage("APP-OH0005","OH");
	var msgArray = msg.split("##");
	if(obj.value!=null){
		var retVal = CheckNum(obj);
		if(retVal==true){
			if(gingival_recording_by=="Q"){
				if(parseInt(obj.value)<=0 || parseInt(obj.value)>8){
					alert(msgArray[0]+"1"+msgArray[1] +"8");
					obj.focus();
					obj.select();
					return false;
				}
			}else if (gingival_recording_by=="S"){
					if (obj.name=="gs_no_of_tooth_for_S1" || obj.name=="gs_no_of_tooth_for_S3" || obj.name=="gs_no_of_tooth_for_S4" ||obj.name=="gs_no_of_tooth_for_S6"){
						if(parseInt(obj.value)<=0 || parseInt(obj.value)>5){
							alert(msgArray[0]+"1"+msgArray[1] +"5");
							obj.focus();
							obj.select();
							return false;
						}
					}else{
						if(parseInt(obj.value)<=0 || parseInt(obj.value)>6){
							alert(msgArray[0]+"1"+msgArray[1] +"6");
							obj.focus();
							obj.select();
							return false;
						}
					}
				}
			}
		}
	}

function validateDecNumOfTooth(obj){
	var frmObj = parent.f_query_add_mod_gs.document.forms[0];
    var gingival_recording_by=frmObj.gigival_recorded.value;
	var msg = getMessage("APP-OH0005","OH");
	var msgArray = msg.split("##");
	if(obj.value!=null){
		var retVal = CheckNum(obj);
		if(retVal==true){
			if(gingival_recording_by=="Q"){
				if(parseInt(obj.value)<=0 || parseInt(obj.value)>5){
					alert(msgArray[0]+"1"+msgArray[1] +"5");
					obj.focus();
					obj.select();
					return false;
				}
			}else if (gingival_recording_by=="S"){
				if (obj.name=="dec_gs_no_of_tooth_for_S1" || obj.name=="dec_gs_no_of_tooth_for_S3" || obj.name=="dec_gs_no_of_tooth_for_S4" ||obj.name=="dec_gs_no_of_tooth_for_S6"){
					if(parseInt(obj.value)<=0 || parseInt(obj.value)>2){
						alert(msgArray[0]+"1"+msgArray[1] +"2");
						obj.focus();
						obj.select();
						return false;
					}
				}else{
					if(parseInt(obj.value)<=0 || parseInt(obj.value)>6){
						alert(msgArray[0]+"1"+msgArray[1] +"6");
						obj.focus();
						obj.select();
						return false;
					}
				}
			}
		}
	}
}

function validateMDNumOfTooth(obj){
	var frmObj = parent.f_query_add_mod_gs.document.forms[0];
    var gingival_recording_by=frmObj.gigival_recorded.value;
	if(obj.value!=null){
		var retVal = CheckNum(obj);
		if(retVal==true){
			if(gingival_recording_by=="Q"){
				if(parseInt(obj.value)<=0 || parseInt(obj.value)>7){
					alert(msgArray[0]+"1"+msgArray[1] +"7");
					obj.focus();
					obj.select();
					return false;
				}
			}else if (gingival_recording_by=="S"){
				if (obj.name=="md_gs_no_of_tooth_for_S1" || obj.name=="md_gs_no_of_tooth_for_S3" || obj.name=="md_gs_no_of_tooth_for_S4" ||obj.name=="md_gs_no_of_tooth_for_S6"){
					if(parseInt(obj.value)<=0 || parseInt(obj.value)>4){
						alert(msgArray[0]+"1"+msgArray[1] +"4");
						obj.focus();
						obj.select();
						return false;
					}
				}else{
					if(parseInt(obj.value)<=0 || parseInt(obj.value)>6){
						alert(msgArray[0]+"1"+msgArray[1] +"6");
						obj.focus();
						obj.select();
						return false;
					}
				}
			}
		}
	}
}

function addToothNoList(obj,value,desc) {
	var element 	=document.createElement('OPTION');
    element.value 	=  value ;
	element.text 	= desc ;
	obj.add(element);
  
} // End of addCategoryList


function clearToothNoList( target_search_obj ) {
	var formObj = document.forms[0];
	var len =target_search_obj.options.length;
	for(var i=0;i<len;i++){
		eval("target_search_obj.remove(\"tooth_no_text\")") ;
	}
	var tp 		= getLabel("eOH.DefaultSelect.Label","OH"); 
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	opt.value 	= "" ;
	target_search_obj.add(opt) ;
} // End of clearCategoryList


function populateToothNo(obj,mixed_val,from_mixed){
	var frmObj = parent.f_query_add_mod_gs.document.forms[0];
	var formObj = document.forms[0];
	
    var gingival_recording_by=frmObj.gigival_recorded.value;
	if (mixed_val=="undefined" || mixed_val==undefined ){
		mixed_val=frmObj.from_mixed_dentition.value;
		if (mixed_val=="" || mixed_val==null || mixed_val=="null"){
			mixed_val=frmObj.dflt_mixed_dentition_chart.value;

		}
	}else if (mixed_val=="" || mixed_val==null || mixed_val=="null")
	{
		mixed_val=from_mixed;

	}	
	
	if (gingival_recording_by=="Q"){
		q1_val = frmObj.gs_no_of_tooth_for_Q1.value;
		q2_val=frmObj.gs_no_of_tooth_for_Q2.value;
		q3_val=frmObj.gs_no_of_tooth_for_Q3.value;
		q4_val=frmObj.gs_no_of_tooth_for_Q4.value;

		q1_dflt_val=frmObj.gs_dflt_tooth_no_Q1.value;
		q2_dflt_val=frmObj.gs_dflt_tooth_no_Q2.value;
		q3_dflt_val=frmObj.gs_dflt_tooth_no_Q3.value;
		q4_dflt_val=frmObj.gs_dflt_tooth_no_Q4.value;

		dec_q1_val = frmObj.dec_gs_no_of_tooth_for_Q1.value;
		dec_q2_val = frmObj.dec_gs_no_of_tooth_for_Q2.value;
		dec_q3_val = frmObj.dec_gs_no_of_tooth_for_Q3.value;
		dec_q4_val = frmObj.dec_gs_no_of_tooth_for_Q4.value;
		dec_q1_dflt_val=frmObj.dec_gs_dflt_tooth_no_Q1.value;
		dec_q2_dflt_val=frmObj.dec_gs_dflt_tooth_no_Q2.value;
		dec_q3_dflt_val=frmObj.dec_gs_dflt_tooth_no_Q3.value;
		dec_q4_dflt_val=frmObj.dec_gs_dflt_tooth_no_Q4.value;
		md_q1_val = frmObj.md_gs_no_of_tooth_for_Q1.value;
		md_q2_val = frmObj.md_gs_no_of_tooth_for_Q2.value;
		md_q3_val = frmObj.md_gs_no_of_tooth_for_Q3.value;
		md_q4_val = frmObj.md_gs_no_of_tooth_for_Q4.value;
		md_q1_dflt_val=frmObj.md_gs_dflt_tooth_no_Q1.value;
		md_q2_dflt_val=frmObj.md_gs_dflt_tooth_no_Q2.value;
		md_q3_dflt_val=frmObj.md_gs_dflt_tooth_no_Q3.value;
		md_q4_dflt_val=frmObj.md_gs_dflt_tooth_no_Q4.value;

		var	tooth_no_obj1 = frmObj.gs_dflt_tooth_no_Q1;
		var	tooth_no_obj2 = frmObj.gs_dflt_tooth_no_Q2;
		var	tooth_no_obj3 = frmObj.gs_dflt_tooth_no_Q3;
		var	tooth_no_obj4 = frmObj.gs_dflt_tooth_no_Q4;
       
	  	var	dec_tooth_no_obj1 = frmObj.dec_gs_dflt_tooth_no_Q1;
	   	var	dec_tooth_no_obj2 = frmObj.dec_gs_dflt_tooth_no_Q2;
	   	var	dec_tooth_no_obj3 = frmObj.dec_gs_dflt_tooth_no_Q3;
	   	var	dec_tooth_no_obj4 = frmObj.dec_gs_dflt_tooth_no_Q4;

	  	var	md_tooth_no_obj1 = frmObj.md_gs_dflt_tooth_no_Q1;
	  	var	md_tooth_no_obj2 = frmObj.md_gs_dflt_tooth_no_Q2;
	  	var	md_tooth_no_obj3 = frmObj.md_gs_dflt_tooth_no_Q3;
	  	var	md_tooth_no_obj4 = frmObj.md_gs_dflt_tooth_no_Q4;



		var	tooth_numbering_system = obj.value;
		var mode = formObj.mode.value;
		if(obj!=null && obj!=""){
			//Clear the Existing (if any) List of Treatment Types
			clearToothNoList(tooth_no_obj1);
			clearToothNoList(tooth_no_obj2);
			clearToothNoList(tooth_no_obj3);
			clearToothNoList(tooth_no_obj4);

			clearToothNoList(dec_tooth_no_obj1);
			clearToothNoList(dec_tooth_no_obj2);
			clearToothNoList(dec_tooth_no_obj3);
			clearToothNoList(dec_tooth_no_obj4);

			clearToothNoList(md_tooth_no_obj1);
			clearToothNoList(md_tooth_no_obj2);
			clearToothNoList(md_tooth_no_obj3);
			clearToothNoList(md_tooth_no_obj4);
			
			// get the Treatment Types for the selected Splty Module Id
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_numbering_system="+tooth_numbering_system+"&mode="+mode;

			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateToothNo&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);

			// add the list of Tooth Nos for the selected Splty Module Id
			if(retVal.length>1){
				var retVal_arr = retVal.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("##");
					if(i <8){
						addToothNoList(tooth_no_obj1,code_desc_arr[0],code_desc_arr[1]);
					}else if(i >= 8 && i < 16){
						addToothNoList(tooth_no_obj2,code_desc_arr[0],code_desc_arr[1]);
					}
					else if(i >= 16 && i < 24){
						addToothNoList(tooth_no_obj4,code_desc_arr[0],code_desc_arr[1]);
					}
					else if(i >= 24 && i < 32){
						addToothNoList(tooth_no_obj3,code_desc_arr[0],code_desc_arr[1]);
					}
				}
			}
			// for deciduous
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_numbering_system="+tooth_numbering_system+"&mode="+mode;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateDeciduousToothNo&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal.length>1){
				var retVal_arr = retVal.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("##");
					if(i <5){
						addToothNoList(dec_tooth_no_obj1,code_desc_arr[0],code_desc_arr[1]);
					}else if(i >= 5 && i < 10){
						addToothNoList(dec_tooth_no_obj2,code_desc_arr[0],code_desc_arr[1]);
					}
					else if(i >= 10&& i < 15){
						addToothNoList(dec_tooth_no_obj4,code_desc_arr[0],code_desc_arr[1]);
					}
					else if(i >= 15 && i < 20){
						addToothNoList(dec_tooth_no_obj3,code_desc_arr[0],code_desc_arr[1]);
					}
				}
			}
		
		//FOR MD
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_numbering_system="+tooth_numbering_system+"&dflt_mixed_dentition_chart="+mixed_val+"&mode="+mode;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateMDToothNo&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal.length>1){
				var retVal_arr = retVal.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("##");
					if(i >= 1 && i < 8){
						addToothNoList(md_tooth_no_obj1,code_desc_arr[0],code_desc_arr[1]);
					}else if(i >= 8 && i < 15){
						addToothNoList(md_tooth_no_obj2,code_desc_arr[0],code_desc_arr[1]);
					}
					else if(i >= 17&& i < 24){
						addToothNoList(md_tooth_no_obj4,code_desc_arr[0],code_desc_arr[1]);
					}
					else if(i >= 24 && i < 31){
						addToothNoList(md_tooth_no_obj3,code_desc_arr[0],code_desc_arr[1]);
					}
				}
			}
		}
		if(formObj.record_gingival_status_yn.checked==true){
			frmObj.dflt_mixed_dentition_chart.value = mixed_val;
			frmObj.gs_no_of_tooth_for_Q1.value = q1_val;
			frmObj.gs_no_of_tooth_for_Q2.value = q2_val;
			frmObj.gs_no_of_tooth_for_Q3.value = q3_val;
			frmObj.gs_no_of_tooth_for_Q4.value = q4_val;

			frmObj.gs_dflt_tooth_no_Q1.value = q1_dflt_val;
			frmObj.gs_dflt_tooth_no_Q2.value = q2_dflt_val;
			frmObj.gs_dflt_tooth_no_Q3.value = q3_dflt_val;
			frmObj.gs_dflt_tooth_no_Q4.value = q4_dflt_val;

			frmObj.dec_gs_no_of_tooth_for_Q1.value = dec_q1_val;
			frmObj.dec_gs_no_of_tooth_for_Q2.value = dec_q2_val;
			frmObj.dec_gs_no_of_tooth_for_Q3.value = dec_q3_val;
			frmObj.dec_gs_no_of_tooth_for_Q4.value = dec_q4_val;
			frmObj.dec_gs_dflt_tooth_no_Q1.value = dec_q1_dflt_val;
			frmObj.dec_gs_dflt_tooth_no_Q2.value = dec_q2_dflt_val;
			frmObj.dec_gs_dflt_tooth_no_Q3.value = dec_q3_dflt_val;
			frmObj.dec_gs_dflt_tooth_no_Q4.value = dec_q4_dflt_val;

			frmObj.md_gs_no_of_tooth_for_Q1.value = md_q1_val;
			frmObj.md_gs_no_of_tooth_for_Q2.value = md_q2_val;
			frmObj.md_gs_no_of_tooth_for_Q3.value = md_q3_val;
			frmObj.md_gs_no_of_tooth_for_Q4.value = md_q4_val;
			frmObj.md_gs_dflt_tooth_no_Q1.value = md_q1_dflt_val;
			frmObj.md_gs_dflt_tooth_no_Q2.value = md_q2_dflt_val;
			frmObj.md_gs_dflt_tooth_no_Q3.value = md_q3_dflt_val;
			frmObj.md_gs_dflt_tooth_no_Q4.value = md_q4_dflt_val;

		}
	}
	else{
		 s1_val = frmObj.gs_no_of_tooth_for_S1.value;
		 s2_val = frmObj.gs_no_of_tooth_for_S2.value;
		 s3_val = frmObj.gs_no_of_tooth_for_S3.value;
		 s4_val = frmObj.gs_no_of_tooth_for_S4.value;
		 s5_val = frmObj.gs_no_of_tooth_for_S5.value;
		 s6_val = frmObj.gs_no_of_tooth_for_S6.value;

		 s1_dflt_val=frmObj.gs_dflt_tooth_no_S1.value ;
		 s2_dflt_val=frmObj.gs_dflt_tooth_no_S2.value ;
		 s3_dflt_val=frmObj.gs_dflt_tooth_no_S3.value ;
		 s4_dflt_val=frmObj.gs_dflt_tooth_no_S4.value ;
		 s5_dflt_val=frmObj.gs_dflt_tooth_no_S5.value ;
		 s6_dflt_val=frmObj.gs_dflt_tooth_no_S6.value ;

		 dec_s1_val = frmObj.dec_gs_no_of_tooth_for_S1.value;
		 dec_s2_val = frmObj.dec_gs_no_of_tooth_for_S2.value;
		 dec_s3_val = frmObj.dec_gs_no_of_tooth_for_S3.value;
		 dec_s4_val = frmObj.dec_gs_no_of_tooth_for_S4.value;
		 dec_s5_val = frmObj.dec_gs_no_of_tooth_for_S5.value;
		 dec_s6_val = frmObj.dec_gs_no_of_tooth_for_S6.value;

		 dec_s1_dflt_val=frmObj.dec_gs_dflt_tooth_no_S1.value ;
		 dec_s2_dflt_val=frmObj.dec_gs_dflt_tooth_no_S2.value ;
		 dec_s3_dflt_val=frmObj.dec_gs_dflt_tooth_no_S3.value ;
		 dec_s4_dflt_val=frmObj.dec_gs_dflt_tooth_no_S4.value ;
		 dec_s5_dflt_val=frmObj.dec_gs_dflt_tooth_no_S5.value ;
		 dec_s6_dflt_val=frmObj.dec_gs_dflt_tooth_no_S6.value ;

		 md_s1_val = frmObj.md_gs_no_of_tooth_for_S1.value;
		 md_s2_val = frmObj.md_gs_no_of_tooth_for_S2.value;
		 md_s3_val = frmObj.md_gs_no_of_tooth_for_S3.value;
		 md_s4_val = frmObj.md_gs_no_of_tooth_for_S4.value;
		 md_s5_val = frmObj.md_gs_no_of_tooth_for_S5.value;
		 md_s6_val = frmObj.md_gs_no_of_tooth_for_S6.value;

		 md_s1_dflt_val=frmObj.md_gs_dflt_tooth_no_S1.value ;
		 md_s2_dflt_val=frmObj.md_gs_dflt_tooth_no_S2.value ;
		 md_s3_dflt_val=frmObj.md_gs_dflt_tooth_no_S3.value ;
		 md_s4_dflt_val=frmObj.md_gs_dflt_tooth_no_S4.value ;
		 md_s5_dflt_val=frmObj.md_gs_dflt_tooth_no_S5.value ;
		 md_s6_dflt_val=frmObj.md_gs_dflt_tooth_no_S6.value ;


		 var	tooth_no_obj1 = frmObj.gs_dflt_tooth_no_S1;
		 var	tooth_no_obj2 = frmObj.gs_dflt_tooth_no_S2;
		 var	tooth_no_obj3 = frmObj.gs_dflt_tooth_no_S3;
		 var	tooth_no_obj4 = frmObj.gs_dflt_tooth_no_S4;
		 var	tooth_no_obj5 = frmObj.gs_dflt_tooth_no_S5;
		 var	tooth_no_obj6 = frmObj.gs_dflt_tooth_no_S6;

		  var	dec_tooth_no_obj1 = frmObj.dec_gs_dflt_tooth_no_S1;
		  var	dec_tooth_no_obj2 = frmObj.dec_gs_dflt_tooth_no_S2;
		  var	dec_tooth_no_obj3 = frmObj.dec_gs_dflt_tooth_no_S3;
		  var	dec_tooth_no_obj4 = frmObj.dec_gs_dflt_tooth_no_S4;
		  var	dec_tooth_no_obj5 = frmObj.dec_gs_dflt_tooth_no_S5;
		  var	dec_tooth_no_obj6 = frmObj.dec_gs_dflt_tooth_no_S6;

		  var	md_tooth_no_obj1 = frmObj.md_gs_dflt_tooth_no_S1;
		  var	md_tooth_no_obj2 = frmObj.md_gs_dflt_tooth_no_S2;
		  var	md_tooth_no_obj3 = frmObj.md_gs_dflt_tooth_no_S3;
		  var	md_tooth_no_obj4 = frmObj.md_gs_dflt_tooth_no_S4;
		  var	md_tooth_no_obj5 = frmObj.md_gs_dflt_tooth_no_S5;
		  var	md_tooth_no_obj6 = frmObj.md_gs_dflt_tooth_no_S6;

		 var tooth_numbering_system = obj.value;
		 var mode = formObj.mode.value;

		if(obj!=null && obj!=""){
			//Clear the Existing (if any) List of Treatment Types
			clearToothNoList(tooth_no_obj1);
			clearToothNoList(tooth_no_obj2);
			clearToothNoList(tooth_no_obj3);
			clearToothNoList(tooth_no_obj4);
			clearToothNoList(tooth_no_obj5);
			clearToothNoList(tooth_no_obj6);

			clearToothNoList(dec_tooth_no_obj1);
			clearToothNoList(dec_tooth_no_obj2);
			clearToothNoList(dec_tooth_no_obj3);
			clearToothNoList(dec_tooth_no_obj4);
			clearToothNoList(dec_tooth_no_obj5);
			clearToothNoList(dec_tooth_no_obj6);

			clearToothNoList(md_tooth_no_obj1);
			clearToothNoList(md_tooth_no_obj2);
			clearToothNoList(md_tooth_no_obj3);
			clearToothNoList(md_tooth_no_obj4);
			clearToothNoList(md_tooth_no_obj5);
			clearToothNoList(md_tooth_no_obj6);


			// get the Treatment Types for the selected Splty Module Id
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_numbering_system="+tooth_numbering_system+"&mode="+mode;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateToothNo&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			// add the list of Tooth Nos for the selected Splty Module Id
			if(retVal.length>1){
				var retVal_arr = retVal.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("##");
					if(i < 5){
						 addToothNoList(tooth_no_obj1,code_desc_arr[0],code_desc_arr[1]);
					}
					else if(i >= 5 && i < 11){
						addToothNoList(tooth_no_obj2,code_desc_arr[0],code_desc_arr[1]);
					}
					else if(i >= 16 && i < 21){
						addToothNoList(tooth_no_obj4,code_desc_arr[0],code_desc_arr[1]);
					}
					else if(i >= 11 && i < 16){
						addToothNoList(tooth_no_obj3,code_desc_arr[0],code_desc_arr[1]);
					}
					else if(i >= 21 && i < 27){
							addToothNoList(tooth_no_obj5,code_desc_arr[0],code_desc_arr[1]);
					}
					else if(i >= 27&& i < 32){
							addToothNoList(tooth_no_obj6,code_desc_arr[0],code_desc_arr[1]);
					}
				}
			}
			// for deciduous
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_numbering_system="+tooth_numbering_system+"&mode="+mode;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateDeciduousToothNo&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal.length>1){
				var retVal_arr = retVal.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("##");
					if(i < 2){
						 addToothNoList(dec_tooth_no_obj1,code_desc_arr[0],code_desc_arr[1]);
					}
					else if(i >= 2 && i < 8){
						addToothNoList(dec_tooth_no_obj2,code_desc_arr[0],code_desc_arr[1]);
					}
					else if(i >= 8 && i < 10){
						addToothNoList(dec_tooth_no_obj3,code_desc_arr[0],code_desc_arr[1]);
					}
						else if(i >= 10 && i < 12){
						addToothNoList(dec_tooth_no_obj4,code_desc_arr[0],code_desc_arr[1]);
					}
					else if(i >= 12 && i < 18){
							addToothNoList(dec_tooth_no_obj5,code_desc_arr[0],code_desc_arr[1]);
					}
					else if(i >= 18&& i < 20){
							addToothNoList(dec_tooth_no_obj6,code_desc_arr[0],code_desc_arr[1]);
					}
				}
			}

			//FOR MD
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "tooth_numbering_system="+tooth_numbering_system+"&dflt_mixed_dentition_chart="+mixed_val+"&mode="+mode;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateMDToothNo&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal.length>1){
				var retVal_arr = retVal.split("~");
				for(var i=0;i<retVal_arr.length-1;i++){
					var code_desc_arr = retVal_arr[i].split("##");
					if(i >= 1 && i < 5){
					
						 addToothNoList(md_tooth_no_obj1,code_desc_arr[0],code_desc_arr[1]);
					}
					else if(i >= 5 && i < 11){
						addToothNoList(md_tooth_no_obj2,code_desc_arr[0],code_desc_arr[1]);
					}
					else if(i >= 11 && i < 15){
						addToothNoList(md_tooth_no_obj3,code_desc_arr[0],code_desc_arr[1]);
					}
						else if(i >= 17 && i < 21){
						addToothNoList(md_tooth_no_obj4,code_desc_arr[0],code_desc_arr[1]);
					}
					else if(i >= 21 && i < 27){
							addToothNoList(md_tooth_no_obj5,code_desc_arr[0],code_desc_arr[1]);
					}
					else if(i >= 27&& i < 31){
							addToothNoList(md_tooth_no_obj6,code_desc_arr[0],code_desc_arr[1]);
					}
				}
			}
		}

		if(formObj.record_gingival_status_yn.checked==true){
			frmObj.dflt_mixed_dentition_chart.value = mixed_val;
			formObj.dflt_mixed_dentition_chart.value = mixed_val;
			frmObj.gs_no_of_tooth_for_S1.value = s1_val;
			frmObj.gs_no_of_tooth_for_S2.value = s2_val;
			frmObj.gs_no_of_tooth_for_S3.value = s3_val;
			frmObj.gs_no_of_tooth_for_S4.value = s4_val;
			frmObj.gs_no_of_tooth_for_S5.value = s5_val;
			frmObj.gs_no_of_tooth_for_S6.value = s6_val;

			frmObj.dec_gs_no_of_tooth_for_S1.value = dec_s1_val;
			frmObj.dec_gs_no_of_tooth_for_S2.value = dec_s2_val;
			frmObj.dec_gs_no_of_tooth_for_S3.value = dec_s3_val;
			frmObj.dec_gs_no_of_tooth_for_S4.value = dec_s4_val;
			frmObj.dec_gs_no_of_tooth_for_S5.value = dec_s5_val;
			frmObj.dec_gs_no_of_tooth_for_S6.value = dec_s6_val;

			frmObj.md_gs_no_of_tooth_for_S1.value = md_s1_val;
			frmObj.md_gs_no_of_tooth_for_S2.value = md_s2_val;
			frmObj.md_gs_no_of_tooth_for_S3.value = md_s3_val;
			frmObj.md_gs_no_of_tooth_for_S4.value = md_s4_val;
			frmObj.md_gs_no_of_tooth_for_S5.value = md_s5_val;
			frmObj.md_gs_no_of_tooth_for_S6.value = md_s6_val;

			frmObj.gs_dflt_tooth_no_S1.value = s1_dflt_val;
			frmObj.gs_dflt_tooth_no_S2.value = s2_dflt_val;
			frmObj.gs_dflt_tooth_no_S3.value = s3_dflt_val;
			frmObj.gs_dflt_tooth_no_S4.value = s4_dflt_val;
			frmObj.gs_dflt_tooth_no_S5.value = s5_dflt_val;
			frmObj.gs_dflt_tooth_no_S6.value = s6_dflt_val;

			frmObj.dec_gs_dflt_tooth_no_S1.value = dec_s1_dflt_val;
			frmObj.dec_gs_dflt_tooth_no_S2.value = dec_s2_dflt_val;
			frmObj.dec_gs_dflt_tooth_no_S3.value = dec_s3_dflt_val;
			frmObj.dec_gs_dflt_tooth_no_S4.value = dec_s4_dflt_val;
			frmObj.dec_gs_dflt_tooth_no_S5.value = dec_s5_dflt_val;
			frmObj.dec_gs_dflt_tooth_no_S6.value = dec_s6_dflt_val;

			frmObj.md_gs_dflt_tooth_no_S1.value = md_s1_dflt_val;
			frmObj.md_gs_dflt_tooth_no_S2.value = md_s2_dflt_val;
			frmObj.md_gs_dflt_tooth_no_S3.value = md_s3_dflt_val;
			frmObj.md_gs_dflt_tooth_no_S4.value = md_s4_dflt_val;
			frmObj.md_gs_dflt_tooth_no_S5.value = md_s5_dflt_val;
			frmObj.md_gs_dflt_tooth_no_S6.value = md_s6_dflt_val;
			
		}
	}
}

function checkGraterToageValidation(from_age,to_age){
	var frm=document.forms[0];
	var from_age_int = parseInt(from_age.value);
	var to_age_int = parseInt(to_age.value);
	if(to_age_int < from_age_int){
		alert(getMessage("APP-OH00021","OH"));
		//to_age.focus();
		//to_age.select();
	    frm.mixed_dentition_to_age_yrs.value="";
		frm.mixed_dentition_to_age_yrs.focus();

	}
		
}


function checkGraterFromageValidation(from_age,to_age){
	var from_age_int = parseInt(from_age.value);
	var to_age_int = parseInt(to_age.value);
	var frm=document.forms[0];
		if(to_age_int > from_age_int){
		alert(getMessage("APP-OH00021","OH"));
		//from_age.focus();
		//from_age.select();
		frm.mixed_dentition_from_age_yrs.value="";
		frm.mixed_dentition_from_age_yrs.focus();
	}
}


function checkGraterFromDaysValidation(){
	var frm=document.forms[0];
	 if (frm.mixed_dentition_from_age_days.value>31) {
		 //alert("from days should not greater than 30 ")
		alert(getMessage("APP-OH000121","OH"));
		frm.mixed_dentition_from_age_days.value="";
		frm.mixed_dentition_from_age_days.focus();
	}
}

function checkGraterToDaysValidation(){
	var frm=document.forms[0];
	 if (frm.mixed_dentition_to_age_days.value >31) {
		//alert("to days should not greater than 31")
		alert(getMessage("APP-OH000122","OH"));
		frm.mixed_dentition_to_age_days.value="";
		frm.mixed_dentition_to_age_days.focus();
	}
}

		
		
function setUpParameterForFacility(obj){
	 var formObj = document.forms[0];
	if(formObj.bl_interface_flag.checked==true){
		formObj.bl_interface_flag.value="Y";
	}else{
		formObj.bl_interface_flag.value="N";
	}
}

/*function setORInterface(obj){ //parul 160908
	 var formObj = document.forms[0];
	if(obj.checked==true)
		obj.value="Y";
	else{
		obj.value=="N";
	}
}*/


 //function loadQuadDtls(),loadSextantDtls(),AssignSextantValue(),AssignQuadrantValue() added by parul for sextant and quadrant

function loadQuadDtls(){
	var formObj = document.forms[0];
	var record_gingival_status_yn = formObj.record_gingival_status_yn.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	if(formObj.record_gingival_status_yn.checked == true){
		record_gingival_status_yn = "Y";
	}
	if(formObj.gigival_recorded.value!="Q"){
		formObj.gigival_recorded.value="Q";
	   parent.f_query_add_mod_gs.document.location.href="../../eOH/jsp/OHParamForFacilityAddModifyQuadrant.jsp?record_gingival_status_yn="+record_gingival_status_yn+"&tooth_numbering_system="+tooth_numbering_system;

	}//parent.f_query_add_mod_gs.document.location.href="../../eOH/jsp/OHParamForFacilityAddModifyQuadrant.jsp?record_gingival_status_yn="+record_gingival_status_yn;
	parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
	
	
}

function loadSextantDtls(){
	var formObj = document.forms[0];
	var record_gingival_status_yn = formObj.record_gingival_status_yn.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;


	if(formObj.record_gingival_status_yn.checked == true){
		record_gingival_status_yn = "Y";
	}
	if(formObj.gigival_recorded.value!="S"){

		formObj.gigival_recorded.value="S";
		//parent.f_query_add_mod_gs.document.location.href="../../eOH/jsp/OHParamForFacilityAddModifySextant.jsp?record_gingival_status_yn="+record_gingival_status_yn;
		parent.f_query_add_mod_gs.document.location.href="../../eOH/jsp/OHParamForFacilityAddModifySextant.jsp?record_gingival_status_yn="+record_gingival_status_yn+"&tooth_numbering_system="+tooth_numbering_system;
	}
    parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
     
	
	 
}


function AssignSextantValue(tooth_numbering_system,record_gingival_status_yn){
	var obj = document.forms[0];
	var mode = document.forms[0].mode.value;
	var formObj = parent.frames[1].document.forms[0];
	var tooth_numbering_system=tooth_numbering_system;
	if(mode == "modify"){
		if(document.forms[0].checked_yn.value == "checked"){
		
			document.getElementById("gs_for_Q1").innerHTML = '<input type="text" name="gs_no_of_tooth_for_S1" id="gs_no_of_tooth_for_S1" value="'+obj.gs_no_of_tooth_for_S1.DB_VALUE+'" size="1" maxlength="1" onBlur="validateNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			document.getElementById("gs_for_Q2").innerHTML = '<input type="text" name="gs_no_of_tooth_for_S2" id="gs_no_of_tooth_for_S2" value="'+obj.gs_no_of_tooth_for_S2.DB_VALUE+'" size="1" maxlength="1" onBlur="validateNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			document.getElementById("gs_for_Q3").innerHTML = '<input type="text" name="gs_no_of_tooth_for_S3" id="gs_no_of_tooth_for_S3" value="'+obj.gs_no_of_tooth_for_S3.DB_VALUE+'" size="1" maxlength="1" onBlur="validateNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			document.getElementById("gs_for_Q4").innerHTML = '<input type="text" name="gs_no_of_tooth_for_S4" id="gs_no_of_tooth_for_S4" value="'+obj.gs_no_of_tooth_for_S4.DB_VALUE+'" size="1" maxlength="1" onBlur="validateNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			document.getElementById("gs_for_Q5").innerHTML = '<input type="text" name="gs_no_of_tooth_for_S5" id="gs_no_of_tooth_for_S5" value="'+obj.gs_no_of_tooth_for_S5.DB_VALUE+'" size="1" maxlength="1" onBlur="validateNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			document.getElementById("gs_for_Q6").innerHTML = '<input type="text" name="gs_no_of_tooth_for_S6" id="gs_no_of_tooth_for_S6" value="'+obj.gs_no_of_tooth_for_S6.DB_VALUE+'" size="1" maxlength="1" onBlur="validateNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';


			document.getElementById("dec_gs_for_Q1").innerHTML = '<input type="text" name="dec_gs_no_of_tooth_for_S1" id="dec_gs_no_of_tooth_for_S1" value="'+obj.dec_gs_no_of_tooth_for_S1.DB_VALUE+'" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			document.getElementById("dec_gs_for_Q2").innerHTML = '<input type="text" name="dec_gs_no_of_tooth_for_S2" id="dec_gs_no_of_tooth_for_S2" value="'+obj.dec_gs_no_of_tooth_for_S2.DB_VALUE+'" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			document.getElementById("dec_gs_for_Q3").innerHTML = '<input type="text" name="dec_gs_no_of_tooth_for_S3" id="dec_gs_no_of_tooth_for_S3" value="'+obj.dec_gs_no_of_tooth_for_S3.DB_VALUE+'" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			document.getElementById("dec_gs_for_Q4").innerHTML = '<input type="text" name="dec_gs_no_of_tooth_for_S4" id="dec_gs_no_of_tooth_for_S4" value="'+obj.dec_gs_no_of_tooth_for_S4.DB_VALUE+'" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			document.getElementById("dec_gs_for_Q5").innerHTML = '<input type="text" name="dec_gs_no_of_tooth_for_S5" id="dec_gs_no_of_tooth_for_S5" value="'+obj.dec_gs_no_of_tooth_for_S5.DB_VALUE+'" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			document.getElementById("dec_gs_for_Q6").innerHTML = '<input type="text" name="dec_gs_no_of_tooth_for_S6" id="dec_gs_no_of_tooth_for_S6" value="'+obj.dec_gs_no_of_tooth_for_S6.DB_VALUE+'" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';

			document.getElementById("md_gs_for_Q1").innerHTML = '<input type="text" name="md_gs_no_of_tooth_for_S1" id="md_gs_no_of_tooth_for_S1" value="'+obj.md_gs_no_of_tooth_for_S1.DB_VALUE+'" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			document.getElementById("md_gs_for_Q2").innerHTML = '<input type="text" name="md_gs_no_of_tooth_for_S2" id="md_gs_no_of_tooth_for_S2" value="'+obj.md_gs_no_of_tooth_for_S2.DB_VALUE+'" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			document.getElementById("md_gs_for_Q3").innerHTML = '<input type="text" name="md_gs_no_of_tooth_for_S3" id="md_gs_no_of_tooth_for_S3" value="'+obj.md_gs_no_of_tooth_for_S3.DB_VALUE+'" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			document.getElementById("md_gs_for_Q4").innerHTML = '<input type="text" name="md_gs_no_of_tooth_for_S4" id="md_gs_no_of_tooth_for_S4" value="'+obj.md_gs_no_of_tooth_for_S4.DB_VALUE+'" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			document.getElementById("md_gs_for_Q5").innerHTML = '<input type="text" name="md_gs_no_of_tooth_for_S5" id="md_gs_no_of_tooth_for_S5" value="'+obj.md_gs_no_of_tooth_for_S5.DB_VALUE+'" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			document.getElementById("md_gs_for_Q6").innerHTML = '<input type="text" name="md_gs_no_of_tooth_for_S6" id="md_gs_no_of_tooth_for_S6" value="'+obj.md_gs_no_of_tooth_for_S6.DB_VALUE+'" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';


		}
	}
	from_mixed=obj.dflt_mixed_dentition_chart.value;
	//populateToothNo(parent.frames[1].document.forms[0].tooth_numbering_system);//changed by parul on 211008 forSCR#6126 
	mixed_val=parent.frames[1].document.forms[0].dflt_mixed_dentition_chart.value;
	populateToothNo(formObj.tooth_numbering_system,mixed_val,from_mixed);	

	s1_val = obj.gs_no_of_tooth_for_S1.value;
	s2_val = obj.gs_no_of_tooth_for_S2.value;
	s3_val = obj.gs_no_of_tooth_for_S3.value;
	s4_val = obj.gs_no_of_tooth_for_S4.value;
	s5_val = obj.gs_no_of_tooth_for_S5.value;
	s6_val = obj.gs_no_of_tooth_for_S6.value;
	
	s1_dflt_val = obj.gs_dflt_tooth_no_S1.value;
	s2_dflt_val = obj.gs_dflt_tooth_no_S2.value;
	s3_dflt_val = obj.gs_dflt_tooth_no_S3.value;
	s4_dflt_val = obj.gs_dflt_tooth_no_S4.value;
	s5_dflt_val = obj.gs_dflt_tooth_no_S5.value;
	s6_dflt_val = obj.gs_dflt_tooth_no_S6.value;

	dec_s1_val = obj.dec_gs_no_of_tooth_for_S1.value;
	dec_s2_val = obj.dec_gs_no_of_tooth_for_S2.value;
	dec_s3_val = obj.dec_gs_no_of_tooth_for_S3.value;
	dec_s4_val = obj.dec_gs_no_of_tooth_for_S4.value;
	dec_s5_val = obj.dec_gs_no_of_tooth_for_S5.value;
	dec_s6_val = obj.dec_gs_no_of_tooth_for_S6.value;

	dec_s1_dflt_val = obj.dec_gs_dflt_tooth_no_S1.value;
	dec_s2_dflt_val = obj.dec_gs_dflt_tooth_no_S2.value;
	dec_s3_dflt_val = obj.dec_gs_dflt_tooth_no_S3.value;
	dec_s4_dflt_val = obj.dec_gs_dflt_tooth_no_S4.value;
	dec_s5_dflt_val = obj.dec_gs_dflt_tooth_no_S5.value;
	dec_s6_dflt_val = obj.dec_gs_dflt_tooth_no_S6.value;

	md_s1_val = obj.md_gs_no_of_tooth_for_S1.value;
	md_s2_val = obj.md_gs_no_of_tooth_for_S2.value;
	md_s3_val = obj.md_gs_no_of_tooth_for_S3.value;
	md_s4_val = obj.md_gs_no_of_tooth_for_S4.value;
	md_s5_val = obj.md_gs_no_of_tooth_for_S5.value;
	md_s6_val = obj.md_gs_no_of_tooth_for_S6.value;

	md_s1_dflt_val = obj.md_gs_dflt_tooth_no_S1.value;
	md_s2_dflt_val = obj.md_gs_dflt_tooth_no_S2.value;
	md_s3_dflt_val = obj.md_gs_dflt_tooth_no_S3.value;
	md_s4_dflt_val = obj.md_gs_dflt_tooth_no_S4.value;
	md_s5_dflt_val = obj.md_gs_dflt_tooth_no_S5.value;
	md_s6_dflt_val = obj.md_gs_dflt_tooth_no_S6.value;

	if(obj.gs_dflt_tooth_no_S1.DB_VALUE == "" ){
		obj.gs_dflt_tooth_no_S1.value = "";
	}
	else{
		obj.gs_dflt_tooth_no_S1.value = obj.gs_dflt_tooth_no_S1.DB_VALUE
	}
	if(obj.gs_dflt_tooth_no_S2.DB_VALUE == "" ){
		obj.gs_dflt_tooth_no_S2.value = "";
	}
	else{
		obj.gs_dflt_tooth_no_S2.value = obj.gs_dflt_tooth_no_S2.DB_VALUE
	}
	if(obj.gs_dflt_tooth_no_S3.DB_VALUE == "" ){
		obj.gs_dflt_tooth_no_S3.value = "";
	}
	else{
		obj.gs_dflt_tooth_no_S3.value = obj.gs_dflt_tooth_no_S3.DB_VALUE
	}
	if(obj.gs_dflt_tooth_no_S4.DB_VALUE == "" ){
		obj.gs_dflt_tooth_no_S4.value = "";
	}
	else{
		obj.gs_dflt_tooth_no_S4.value = obj.gs_dflt_tooth_no_S4.DB_VALUE
	}
	if(obj.gs_dflt_tooth_no_S5.DB_VALUE == "" ){
		obj.gs_dflt_tooth_no_S5.value = "";
	}
	else{
		obj.gs_dflt_tooth_no_S5.value = obj.gs_dflt_tooth_no_S5.DB_VALUE
	}
		if(obj.gs_dflt_tooth_no_S6.DB_VALUE == "" ){
		obj.gs_dflt_tooth_no_S6.value = "";
	}
	else{
		obj.gs_dflt_tooth_no_S6.value = obj.gs_dflt_tooth_no_S6.DB_VALUE
	}

	if(obj.dec_gs_dflt_tooth_no_S1.DB_VALUE == "" ){
		obj.dec_gs_dflt_tooth_no_S1.value = "";
	}
	else{
		obj.dec_gs_dflt_tooth_no_S1.value = obj.dec_gs_dflt_tooth_no_S1.DB_VALUE
	}
	if(obj.dec_gs_dflt_tooth_no_S2.DB_VALUE == "" ){
		obj.dec_gs_dflt_tooth_no_S2.value = "";
	}
	else{
		obj.dec_gs_dflt_tooth_no_S2.value = obj.dec_gs_dflt_tooth_no_S2.DB_VALUE
	}
	if(obj.dec_gs_dflt_tooth_no_S3.DB_VALUE == "" ){
		obj.dec_gs_dflt_tooth_no_S3.value = "";
	}
	else{
		obj.dec_gs_dflt_tooth_no_S3.value = obj.dec_gs_dflt_tooth_no_S3.DB_VALUE
	}
	if(obj.dec_gs_dflt_tooth_no_S4.DB_VALUE == "" ){
		obj.dec_gs_dflt_tooth_no_S4.value = "";
	}
	else{
		obj.dec_gs_dflt_tooth_no_S4.value = obj.dec_gs_dflt_tooth_no_S4.DB_VALUE
	}
	if(obj.dec_gs_dflt_tooth_no_S5.DB_VALUE == "" ){
		obj.dec_gs_dflt_tooth_no_S5.value = "";
	}
	else{
		obj.dec_gs_dflt_tooth_no_S5.value = obj.dec_gs_dflt_tooth_no_S5.DB_VALUE
	}
	if(obj.dec_gs_dflt_tooth_no_S6.DB_VALUE == "" ){
		obj.dec_gs_dflt_tooth_no_S6.value = "";
	}
	else{
		obj.dec_gs_dflt_tooth_no_S6.value = obj.dec_gs_dflt_tooth_no_S6.DB_VALUE
	}

	if(obj.md_gs_dflt_tooth_no_S1.DB_VALUE == "" ){
			obj.md_gs_dflt_tooth_no_S1.value = "";
	}
	else{
		obj.md_gs_dflt_tooth_no_S1.value = obj.md_gs_dflt_tooth_no_S1.DB_VALUE
	}
	if(obj.md_gs_dflt_tooth_no_S2.DB_VALUE == "" ){
			obj.md_gs_dflt_tooth_no_S2.value = "";
	}
	else{
		obj.md_gs_dflt_tooth_no_S2.value = obj.md_gs_dflt_tooth_no_S2.DB_VALUE
	}
	if(obj.md_gs_dflt_tooth_no_S3.DB_VALUE == "" ){
			obj.md_gs_dflt_tooth_no_S3.value = "";
	}
	else{
		obj.md_gs_dflt_tooth_no_S3.value = obj.md_gs_dflt_tooth_no_S3.DB_VALUE
	}
	if(obj.md_gs_dflt_tooth_no_S4.DB_VALUE == "" ){
			obj.md_gs_dflt_tooth_no_S4.value = "";
	}
	else{
		obj.md_gs_dflt_tooth_no_S4.value = obj.md_gs_dflt_tooth_no_S4.DB_VALUE
	}
	if(obj.md_gs_dflt_tooth_no_S5.DB_VALUE == "" ){
			obj.md_gs_dflt_tooth_no_S5.value = "";
	}
	else{
		obj.md_gs_dflt_tooth_no_S5.value = obj.md_gs_dflt_tooth_no_S5.DB_VALUE
	}
	if(obj.md_gs_dflt_tooth_no_S6.DB_VALUE == "" ){
			obj.md_gs_dflt_tooth_no_S6.value = "";
	}
	else{
		obj.md_gs_dflt_tooth_no_S6.value = obj.md_gs_dflt_tooth_no_S6.DB_VALUE
	}
	//if(formObj.record_gingival_status_yn.checked == false){// changed by parul on 211008 forSCR#6126 
	//if(record_gingival_status_yn!="Y"){
	if(formObj.record_gingival_status_yn.checked==false){
		obj.gs_no_of_tooth_for_S1.disabled = true;
		obj.gs_no_of_tooth_for_S2.disabled = true;
		obj.gs_no_of_tooth_for_S3.disabled = true;
		obj.gs_no_of_tooth_for_S4.disabled = true;
		obj.gs_no_of_tooth_for_S5.disabled = true;
		obj.gs_no_of_tooth_for_S6.disabled = true;
		obj.gs_dflt_tooth_no_S1.disabled = true;
		obj.gs_dflt_tooth_no_S2.disabled = true;
		obj.gs_dflt_tooth_no_S3.disabled = true;
		obj.gs_dflt_tooth_no_S4.disabled = true;
		obj.gs_dflt_tooth_no_S5.disabled = true;
		obj.gs_dflt_tooth_no_S6.disabled = true;

		obj.dec_gs_no_of_tooth_for_S1.disabled = true;
		obj.dec_gs_no_of_tooth_for_S2.disabled = true;
		obj.dec_gs_no_of_tooth_for_S3.disabled = true;
		obj.dec_gs_no_of_tooth_for_S4.disabled = true;
		obj.dec_gs_no_of_tooth_for_S5.disabled = true;
		obj.dec_gs_no_of_tooth_for_S6.disabled = true;
		obj.dec_gs_dflt_tooth_no_S1.disabled = true;
		obj.dec_gs_dflt_tooth_no_S2.disabled = true;
		obj.dec_gs_dflt_tooth_no_S3.disabled = true;
		obj.dec_gs_dflt_tooth_no_S4.disabled = true;
		obj.dec_gs_dflt_tooth_no_S5.disabled = true;
		obj.dec_gs_dflt_tooth_no_S6.disabled = true;

		obj.md_gs_no_of_tooth_for_S1.disabled = true;
		obj.md_gs_no_of_tooth_for_S2.disabled = true;
		obj.md_gs_no_of_tooth_for_S3.disabled = true;
		obj.md_gs_no_of_tooth_for_S4.disabled = true;
		obj.md_gs_no_of_tooth_for_S5.disabled = true;
		obj.md_gs_no_of_tooth_for_S6.disabled = true;
		obj.md_gs_dflt_tooth_no_S1.disabled = true;
		obj.md_gs_dflt_tooth_no_S2.disabled = true;
		obj.md_gs_dflt_tooth_no_S3.disabled = true;
		obj.md_gs_dflt_tooth_no_S4.disabled = true;
		obj.md_gs_dflt_tooth_no_S5.disabled = true;
		obj.md_gs_dflt_tooth_no_S6.disabled = true;

	}
}

function AssignQuadrantValue(){
	var obj = document.forms[0];
	var mode ="";
	if(document.forms[0].mode == null || document.forms[0].mode == "null"){
		mode = "";
	}
	var formObj = parent.frames[1].document.forms[0];
	 if(mode == "modify"){
		if(document.forms[0].checked_yn.value == "checked"){
			document.getElementById("gs_for_Q1").innerHTML = '<input type="text" name="gs_no_of_tooth_for_Q1" id="gs_no_of_tooth_for_Q1" value="'+obj.gs_no_of_tooth_for_Q1.DB_VALUE+'" size="1" maxlength="1" onBlur="validateNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			document.getElementById("gs_for_Q2").innerHTML = '<input type="text" name="gs_no_of_tooth_for_Q2" id="gs_no_of_tooth_for_Q2" value="'+obj.gs_no_of_tooth_for_Q2.DB_VALUE+'" size="1" maxlength="1" onBlur="validateNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			document.getElementById("gs_for_Q3").innerHTML = '<input type="text" name="gs_no_of_tooth_for_Q3" id="gs_no_of_tooth_for_Q3" value="'+obj.gs_no_of_tooth_for_Q3.DB_VALUE+'" size="1" maxlength="1" onBlur="validateNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			document.getElementById("gs_for_Q4").innerHTML = '<input type="text" name="gs_no_of_tooth_for_Q4" id="gs_no_of_tooth_for_Q4" value="'+obj.gs_no_of_tooth_for_Q4.DB_VALUE+'" size="1" maxlength="1" onBlur="validateNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			
			document.getElementById("dec_gs_for_Q1").innerHTML = '<input type="text" name="dec_gs_no_of_tooth_for_Q1" id="dec_gs_no_of_tooth_for_Q1" value="'+obj.dec_gs_no_of_tooth_for_Q1.DB_VALUE+'" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			document.getElementById("dec_gs_for_Q2").innerHTML = '<input type="text" name="dec_gs_no_of_tooth_for_Q2" id="dec_gs_no_of_tooth_for_Q2" value="'+obj.dec_gs_no_of_tooth_for_Q2.DB_VALUE+'" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			document.getElementById("dec_gs_for_Q3").innerHTML = '<input type="text" name="dec_gs_no_of_tooth_for_Q3" id="dec_gs_no_of_tooth_for_Q3" value="'+obj.dec_gs_no_of_tooth_for_Q3.DB_VALUE+'" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			document.getElementById("dec_gs_for_Q4").innerHTML = '<input type="text" name="dec_gs_no_of_tooth_for_Q4" id="dec_gs_no_of_tooth_for_Q4" value="'+obj.dec_gs_no_of_tooth_for_Q4.DB_VALUE+'" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';

			document.getElementById("md_gs_for_Q1").innerHTML = '<input type="text" name="md_gs_no_of_tooth_for_Q1" id="md_gs_no_of_tooth_for_Q1" value="'+obj.md_gs_no_of_tooth_for_Q1.DB_VALUE+'" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			document.getElementById("md_gs_for_Q2").innerHTML = '<input type="text" name="md_gs_no_of_tooth_for_Q2" id="md_gs_no_of_tooth_for_Q2" value="'+obj.md_gs_no_of_tooth_for_Q2.DB_VALUE+'" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			document.getElementById("md_gs_for_Q3").innerHTML = '<input type="text" name="md_gs_no_of_tooth_for_Q3" id="md_gs_no_of_tooth_for_Q3" value="'+obj.md_gs_no_of_tooth_for_Q3.DB_VALUE+'" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';
			document.getElementById("md_gs_for_Q4").innerHTML = '<input type="text" name="md_gs_no_of_tooth_for_Q4" id="md_gs_no_of_tooth_for_Q4" value="'+obj.md_gs_no_of_tooth_for_Q4.DB_VALUE+'" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)"><img src="../../eCommon/images/mandatory.gif"></img>';

		}
	
    }
	from_mixed=obj.dflt_mixed_dentition_chart.value;
	mixed_val=formObj.dflt_mixed_dentition_chart.value;
	populateToothNo(formObj.tooth_numbering_system,mixed_val,from_mixed);	
	q1_val = obj.gs_no_of_tooth_for_Q1.value;
	q2_val = obj.gs_no_of_tooth_for_Q2.value;
	q3_val = obj.gs_no_of_tooth_for_Q3.value;
	q4_val = obj.gs_no_of_tooth_for_Q4.value;
	q1_dflt_val = obj.gs_dflt_tooth_no_Q1.value;
	q2_dflt_val = obj.gs_dflt_tooth_no_Q2.value;
	q3_dflt_val = obj.gs_dflt_tooth_no_Q3.value;
	q4_dflt_val = obj.gs_dflt_tooth_no_Q4.value;

	dec_q1_val = obj.dec_gs_no_of_tooth_for_Q1.value;
	dec_q2_val = obj.dec_gs_no_of_tooth_for_Q2.value;
	dec_q3_val = obj.dec_gs_no_of_tooth_for_Q3.value;
	dec_q4_val = obj.dec_gs_no_of_tooth_for_Q4.value;
	dec_q1_dflt_val = obj.dec_gs_dflt_tooth_no_Q1.value;
	dec_q2_dflt_val = obj.dec_gs_dflt_tooth_no_Q2.value;
	dec_q3_dflt_val = obj.dec_gs_dflt_tooth_no_Q3.value;
	dec_q4_dflt_val = obj.dec_gs_dflt_tooth_no_Q4.value;

	md_q1_val = obj.md_gs_no_of_tooth_for_Q1.value;
	md_q2_val = obj.md_gs_no_of_tooth_for_Q2.value;
	md_q3_val = obj.md_gs_no_of_tooth_for_Q3.value;
	md_q4_val = obj.md_gs_no_of_tooth_for_Q4.value;
	md_q1_dflt_val=obj.md_gs_dflt_tooth_no_Q1.value;
	md_q2_dflt_val=obj.md_gs_dflt_tooth_no_Q2.value;
	md_q3_dflt_val=obj.md_gs_dflt_tooth_no_Q3.value;
	md_q4_dflt_val=obj.md_gs_dflt_tooth_no_Q4.value;



	if(obj.gs_dflt_tooth_no_Q1.DB_VALUE == "" ){
		obj.gs_dflt_tooth_no_Q1.value = "";
	}
	else{
		obj.gs_dflt_tooth_no_Q1.value = obj.gs_dflt_tooth_no_Q1.DB_VALUE
	}
	if(obj.gs_dflt_tooth_no_Q2.DB_VALUE == "" ){
		obj.gs_dflt_tooth_no_Q2.value = "";
	}
	else{
		obj.gs_dflt_tooth_no_Q2.value = obj.gs_dflt_tooth_no_Q2.DB_VALUE
	}
	if(obj.gs_dflt_tooth_no_Q3.DB_VALUE == "" ){
		obj.gs_dflt_tooth_no_Q3.value = "";
	}
	else{
		obj.gs_dflt_tooth_no_Q3.value = obj.gs_dflt_tooth_no_Q3.DB_VALUE
	}
	if(obj.gs_dflt_tooth_no_Q4.DB_VALUE == "" ){
		obj.gs_dflt_tooth_no_Q4.value = "";
	}
	else{
		obj.gs_dflt_tooth_no_Q4.value = obj.gs_dflt_tooth_no_Q4.DB_VALUE
	}

	
	if(obj.dec_gs_dflt_tooth_no_Q1.DB_VALUE == "" ){
		obj.dec_gs_dflt_tooth_no_Q1.value = "";
	}
	else{
		obj.dec_gs_dflt_tooth_no_Q1.value = obj.dec_gs_dflt_tooth_no_Q1.DB_VALUE
	}

	if(obj.dec_gs_dflt_tooth_no_Q2.DB_VALUE == "" ){
		obj.dec_gs_dflt_tooth_no_Q2.value = "";
	}
	else{
		obj.dec_gs_dflt_tooth_no_Q2.value = obj.dec_gs_dflt_tooth_no_Q2.DB_VALUE
	}

	if(obj.dec_gs_dflt_tooth_no_Q3.DB_VALUE == "" ){
		obj.dec_gs_dflt_tooth_no_Q3.value = "";
	}
	else{
		obj.dec_gs_dflt_tooth_no_Q3.value = obj.dec_gs_dflt_tooth_no_Q3.DB_VALUE
	}


	if(obj.dec_gs_dflt_tooth_no_Q4.DB_VALUE == "" ){
		obj.dec_gs_dflt_tooth_no_Q4.value = "";
	}
	else{
		obj.dec_gs_dflt_tooth_no_Q4.value = obj.dec_gs_dflt_tooth_no_Q4.DB_VALUE
	}
	if(obj.md_gs_dflt_tooth_no_Q1.DB_VALUE == "" ){
		obj.md_gs_dflt_tooth_no_Q1.value = "";
	}
	else{
		obj.md_gs_dflt_tooth_no_Q1.value = obj.md_gs_dflt_tooth_no_Q1.DB_VALUE
	}
	if(obj.md_gs_dflt_tooth_no_Q2.DB_VALUE == "" ){
		obj.md_gs_dflt_tooth_no_Q2.value = "";
	}
	else{
		obj.md_gs_dflt_tooth_no_Q2.value = obj.md_gs_dflt_tooth_no_Q2.DB_VALUE
	}
	if(obj.md_gs_dflt_tooth_no_Q3.DB_VALUE == "" ){
		obj.md_gs_dflt_tooth_no_Q3.value = "";
	}
	else{
		obj.md_gs_dflt_tooth_no_Q3.value = obj.md_gs_dflt_tooth_no_Q3.DB_VALUE
	}
	if(obj.md_gs_dflt_tooth_no_Q4.DB_VALUE == "" ){
		obj.md_gs_dflt_tooth_no_Q4.value = "";
	}
	else{
		obj.md_gs_dflt_tooth_no_Q4.value = obj.md_gs_dflt_tooth_no_Q4.DB_VALUE
	}

	if(formObj.record_gingival_status_yn.checked == false){

		obj.gs_no_of_tooth_for_Q1.disabled = true;
		obj.gs_no_of_tooth_for_Q2.disabled = true;
		obj.gs_no_of_tooth_for_Q3.disabled = true;
		obj.gs_no_of_tooth_for_Q4.disabled = true;
		obj.gs_dflt_tooth_no_Q1.disabled = true;
		obj.gs_dflt_tooth_no_Q2.disabled = true;
		obj.gs_dflt_tooth_no_Q3.disabled = true;
		obj.gs_dflt_tooth_no_Q4.disabled = true;

		obj.dec_gs_no_of_tooth_for_Q1.disabled = true;
		obj.dec_gs_no_of_tooth_for_Q2.disabled = true;
		obj.dec_gs_no_of_tooth_for_Q3.disabled = true;
		obj.dec_gs_no_of_tooth_for_Q4.disabled = true;
		obj.dec_gs_dflt_tooth_no_Q1.disabled = true;
		obj.dec_gs_dflt_tooth_no_Q2.disabled = true;
		obj.dec_gs_dflt_tooth_no_Q3.disabled = true;
		obj.dec_gs_dflt_tooth_no_Q4.disabled = true;

		obj.md_gs_no_of_tooth_for_Q1.disabled = true;
		obj.md_gs_no_of_tooth_for_Q2.disabled = true;
		obj.md_gs_no_of_tooth_for_Q3.disabled = true;
		obj.md_gs_no_of_tooth_for_Q4.disabled = true;
		obj.md_gs_dflt_tooth_no_Q1.disabled = true;
		obj.md_gs_dflt_tooth_no_Q2.disabled = true;
		obj.md_gs_dflt_tooth_no_Q3.disabled = true;
		obj.md_gs_dflt_tooth_no_Q4.disabled = true;
	}
}


function checkRadio(){
	var formObj = document.forms[0];
	var frmObj = parent.f_query_add_mod_gs.document.forms[0];
	var tooth_numbering_system=formObj.tooth_numbering_system.value;
	var gingival_recording_by=formObj.gingival_recording_by.value;
	var dflt_mixed_dentition_chart=formObj.dflt_mixed_dentition_chart.value;
	var from_mixed_dentition="";
	if (dflt_mixed_dentition_chart=="P"){
		from_mixed_dentition="P";
	}else if (dflt_mixed_dentition_chart=="D"){
		from_mixed_dentition="D";
	}
	 if(formObj.record_gingival_status_yn.checked==true){

			formObj.record_gingival_status_yn.value="Y";
			var gingival_recording=frmObj.gigival_recorded.value;
		//	var final_msg="Do you want to change radio button option";

			var final_msg ="";
			var msg="";
			var msg_arr="";
			var validate_gingival = checkForFacilityGingival()
			 if(validate_gingival==true){

				 msg=getMessage("APP-OH00093","OH");//Data entered for ## will be lost. Would you like to continue
				 msg_arr=msg.split("##");

				if (gingival_recording=="Q"){
					var final_msg=msg_arr[0]+getLabel("eOH.Quadrant.Label","OH")+msg_arr[1];
				}else{
					var final_msg=msg_arr[0]+getLabel("eOH.Sextant.Label","OH")+msg_arr[1];
				}
			var chk_msg="";
			  if(gingival_recording==formObj.gigival_recorded.value){
				  chk_msg="N";
			  
			  }else{
				chk_msg="Y";			  
			  }
		if(chk_msg=="Y"){
			if(window.confirm(final_msg) == true){
				
				var gingival_recording=frmObj.gigival_recorded.value;
				if (gingival_recording=="S"){
						formObj.gigival_recorded.value="Q"; //gingival recorded by if value iS "S",we are loading quadrant  so gigival_recorded is set as a "Q";
						parent.f_query_add_mod_gs.document.location.href="../../eOH/jsp/OHParamForFacilityAddModifyQuadrant.jsp?record_gingival_status_yn=Y&tooth_numbering_system="+tooth_numbering_system+"&from_mixed_dentition="+from_mixed_dentition;
				}
				else{
						formObj.gigival_recorded.value="S";
						parent.f_query_add_mod_gs.document.location.href="../../eOH/jsp/OHParamForFacilityAddModifySextant.jsp?record_gingival_status_yn=Y&tooth_numbering_system="+tooth_numbering_system+"&from_mixed_dentition="+from_mixed_dentition;

				}
			}else{
			if (gingival_recording=="S"){

				formObj.record_gingival_status_yn.value="Y";
				formObj.record_gingival_status_yn.checked=true;
				formObj.gigival_recorded.value="S";
				formObj.gingival[1].checked=true;
				formObj.gingival[1].value="Y";
				//formObj.gigival_recorded.checked=true;
								
				var  gs_no_of_tooth_for_S1_hidden=frmObj.gs_no_of_tooth_for_S1.value;
				var  gs_no_of_tooth_for_S2_hidden=frmObj.gs_no_of_tooth_for_S2.value;
				var  gs_no_of_tooth_for_S3_hidden=frmObj.gs_no_of_tooth_for_S3.value;
				var  gs_no_of_tooth_for_S4_hidden=frmObj.gs_no_of_tooth_for_S4.value;
				var  gs_no_of_tooth_for_S5_hidden=frmObj.gs_no_of_tooth_for_S5.value;
				var  gs_no_of_tooth_for_S6_hidden=frmObj.gs_no_of_tooth_for_S6.value;
				var  gs_dflt_tooth_no_S1_hidden=frmObj.gs_dflt_tooth_no_S1.value;
				var  gs_dflt_tooth_no_S2_hidden=frmObj.gs_dflt_tooth_no_S2.value;
				var  gs_dflt_tooth_no_S3_hidden=frmObj.gs_dflt_tooth_no_S3.value;
				var  gs_dflt_tooth_no_S4_hidden=frmObj.gs_dflt_tooth_no_S4.value;
				var  gs_dflt_tooth_no_S5_hidden=frmObj.gs_dflt_tooth_no_S5.value;
				var  gs_dflt_tooth_no_S6_hidden=frmObj.gs_dflt_tooth_no_S6.value;

				var  dec_gs_no_of_tooth_for_S1_hidden=frmObj.dec_gs_no_of_tooth_for_S1.value;
				var  dec_gs_no_of_tooth_for_S2_hidden=frmObj.dec_gs_no_of_tooth_for_S2.value;
				var  dec_gs_no_of_tooth_for_S3_hidden=frmObj.dec_gs_no_of_tooth_for_S3.value;
				var  dec_gs_no_of_tooth_for_S4_hidden=frmObj.dec_gs_no_of_tooth_for_S4.value;
				var  dec_gs_no_of_tooth_for_S5_hidden=frmObj.dec_gs_no_of_tooth_for_S5.value;
				var  dec_gs_no_of_tooth_for_S6_hidden=frmObj.dec_gs_no_of_tooth_for_S6.value;
				var  dec_gs_dflt_tooth_no_S1_hidden=frmObj.dec_gs_dflt_tooth_no_S1.value;
				var  dec_gs_dflt_tooth_no_S2_hidden=frmObj.dec_gs_dflt_tooth_no_S2.value;
				var  dec_gs_dflt_tooth_no_S3_hidden=frmObj.dec_gs_dflt_tooth_no_S3.value;
				var  dec_gs_dflt_tooth_no_S4_hidden=frmObj.dec_gs_dflt_tooth_no_S4.value;
				var  dec_gs_dflt_tooth_no_S5_hidden=frmObj.dec_gs_dflt_tooth_no_S5.value;
				var  dec_gs_dflt_tooth_no_S6_hidden=frmObj.dec_gs_dflt_tooth_no_S6.value;

				var  md_gs_no_of_tooth_for_S1_hidden=frmObj.md_gs_no_of_tooth_for_S1.value;
				var  md_gs_no_of_tooth_for_S2_hidden=frmObj.md_gs_no_of_tooth_for_S2.value;
				var  md_gs_no_of_tooth_for_S3_hidden=frmObj.md_gs_no_of_tooth_for_S3.value;
				var  md_gs_no_of_tooth_for_S4_hidden=frmObj.md_gs_no_of_tooth_for_S4.value;
				var  md_gs_no_of_tooth_for_S5_hidden=frmObj.md_gs_no_of_tooth_for_S5.value;
				var  md_gs_no_of_tooth_for_S6_hidden=frmObj.md_gs_no_of_tooth_for_S6.value;
				var  md_gs_dflt_tooth_no_S1_hidden=frmObj.md_gs_dflt_tooth_no_S1.value;
				var  md_gs_dflt_tooth_no_S2_hidden=frmObj.md_gs_dflt_tooth_no_S2.value;
				var  md_gs_dflt_tooth_no_S3_hidden=frmObj.md_gs_dflt_tooth_no_S3.value;
				var  md_gs_dflt_tooth_no_S4_hidden=frmObj.md_gs_dflt_tooth_no_S4.value;
				var  md_gs_dflt_tooth_no_S5_hidden=frmObj.md_gs_dflt_tooth_no_S5.value;
				var  md_gs_dflt_tooth_no_S6_hidden=frmObj.md_gs_dflt_tooth_no_S6.value;

				//var params= "record_gingival_status_yn=Y&tooth_numbering_system="+tooth_numbering_system+"&gs_no_of_tooth_for_S1_hidden="+gs_no_of_tooth_for_S1_hidden+"&gs_no_of_tooth_for_S2_hidden="+gs_no_of_tooth_for_S2_hidden+"&gs_no_of_tooth_for_S3_hidden="+gs_no_of_tooth_for_S3_hidden+"&gs_no_of_tooth_for_S4_hidden="+gs_no_of_tooth_for_S4_hidden+"&gs_no_of_tooth_for_S5_hidden="+gs_no_of_tooth_for_S5_hidden+"&gs_no_of_tooth_for_S6_hidden="+gs_no_of_tooth_for_S6_hidden+"&gs_dflt_tooth_no_S1_hidden="+gs_dflt_tooth_no_S1_hidden+"&gs_dflt_tooth_no_S2_hidden="+gs_dflt_tooth_no_S2_hidden+"&gs_dflt_tooth_no_S3_hidden="+gs_dflt_tooth_no_S3_hidden+"&gs_dflt_tooth_no_S4_hidden="+gs_dflt_tooth_no_S4_hidden+"&gs_dflt_tooth_no_S5_hidden="+gs_dflt_tooth_no_S5_hidden+"&gs_dflt_tooth_no_S6_hidden="+gs_dflt_tooth_no_S6_hidden+"&callFrom=S";
				var params= "record_gingival_status_yn=Y&tooth_numbering_system="+tooth_numbering_system+"&gs_no_of_tooth_for_S1_hidden="+gs_no_of_tooth_for_S1_hidden+"&gs_no_of_tooth_for_S2_hidden="+gs_no_of_tooth_for_S2_hidden+"&gs_no_of_tooth_for_S3_hidden="+gs_no_of_tooth_for_S3_hidden+"&gs_no_of_tooth_for_S4_hidden="+gs_no_of_tooth_for_S4_hidden+"&gs_no_of_tooth_for_S5_hidden="+gs_no_of_tooth_for_S5_hidden+"&gs_no_of_tooth_for_S6_hidden="+gs_no_of_tooth_for_S6_hidden+"&gs_dflt_tooth_no_S1_hidden="+gs_dflt_tooth_no_S1_hidden+"&gs_dflt_tooth_no_S2_hidden="+gs_dflt_tooth_no_S2_hidden+"&gs_dflt_tooth_no_S3_hidden="+gs_dflt_tooth_no_S3_hidden+"&gs_dflt_tooth_no_S4_hidden="+gs_dflt_tooth_no_S4_hidden+"&gs_dflt_tooth_no_S5_hidden="+gs_dflt_tooth_no_S5_hidden+"&gs_dflt_tooth_no_S6_hidden="+gs_dflt_tooth_no_S6_hidden+"&dec_gs_no_of_tooth_for_S1_hidden="+dec_gs_no_of_tooth_for_S1_hidden+"&dec_gs_no_of_tooth_for_S2_hidden="+dec_gs_no_of_tooth_for_S2_hidden+"&dec_gs_no_of_tooth_for_S3_hidden="+dec_gs_no_of_tooth_for_S3_hidden+"&dec_gs_no_of_tooth_for_S4_hidden="+dec_gs_no_of_tooth_for_S4_hidden+"&dec_gs_no_of_tooth_for_S5_hidden="+dec_gs_no_of_tooth_for_S5_hidden+"&dec_gs_no_of_tooth_for_S6_hidden="+dec_gs_no_of_tooth_for_S6_hidden+"&dec_gs_dflt_tooth_no_S1_hidden="+dec_gs_dflt_tooth_no_S1_hidden+"&dec_gs_dflt_tooth_no_S2_hidden="+dec_gs_dflt_tooth_no_S2_hidden+"&dec_gs_dflt_tooth_no_S3_hidden="+dec_gs_dflt_tooth_no_S3_hidden+"&dec_gs_dflt_tooth_no_S4_hidden="+dec_gs_dflt_tooth_no_S4_hidden+"&dec_gs_dflt_tooth_no_S5_hidden="+dec_gs_dflt_tooth_no_S5_hidden+"&dec_gs_dflt_tooth_no_S6_hidden="+dec_gs_dflt_tooth_no_S6_hidden+"&md_gs_no_of_tooth_for_S1_hidden="+md_gs_no_of_tooth_for_S1_hidden+"&md_gs_no_of_tooth_for_S2_hidden="+md_gs_no_of_tooth_for_S2_hidden+"&md_gs_no_of_tooth_for_S3_hidden="+md_gs_no_of_tooth_for_S3_hidden+"&md_gs_no_of_tooth_for_S4_hidden="+md_gs_no_of_tooth_for_S4_hidden+"&md_gs_no_of_tooth_for_S5_hidden="+md_gs_no_of_tooth_for_S5_hidden+"&md_gs_no_of_tooth_for_S6_hidden="+md_gs_no_of_tooth_for_S6_hidden+"&md_gs_dflt_tooth_no_S1_hidden="+md_gs_dflt_tooth_no_S1_hidden+"&md_gs_dflt_tooth_no_S2_hidden="+md_gs_dflt_tooth_no_S2_hidden+"&md_gs_dflt_tooth_no_S3_hidden="+md_gs_dflt_tooth_no_S3_hidden+"&md_gs_dflt_tooth_no_S4_hidden="+md_gs_dflt_tooth_no_S4_hidden+"&md_gs_dflt_tooth_no_S5_hidden="+md_gs_dflt_tooth_no_S5_hidden+"&md_gs_dflt_tooth_no_S6_hidden="+md_gs_dflt_tooth_no_S6_hidden+"&from_mixed_dentition="+from_mixed_dentition+"&callFrom=S";
				
				parent.f_query_add_mod_gs.document.location.href="../../eOH/jsp/OHParamForFacilityAddModifySextant.jsp?"+params;
			} else{
				var gingival_recording=frmObj.gigival_recorded.value;
				formObj.record_gingival_status_yn.value="Y";
				formObj.record_gingival_status_yn.checked=true;
				formObj.gigival_recorded.value="Q";
				//formObj.gigival_recorded.checked=true;
				formObj.gingival[0].checked=true;
				formObj.gingival[0].value="Y";	
				
				//var dflt_mixed_dentition_chart_hidden=frmObj.dflt_mixed_dentition_chart.value;
				var gs_no_of_tooth_for_Q1_hidden=frmObj.gs_no_of_tooth_for_Q1.value;
				var gs_no_of_tooth_for_Q2_hidden=frmObj.gs_no_of_tooth_for_Q2.value;
				var gs_no_of_tooth_for_Q3_hidden=frmObj.gs_no_of_tooth_for_Q3.value;
				var gs_no_of_tooth_for_Q4_hidden=frmObj.gs_no_of_tooth_for_Q4.value;
				var gs_dflt_tooth_no_Q1_hidden=frmObj.gs_dflt_tooth_no_Q1.value;
				var gs_dflt_tooth_no_Q2_hidden=frmObj.gs_dflt_tooth_no_Q2.value;
				var gs_dflt_tooth_no_Q3_hidden=frmObj.gs_dflt_tooth_no_Q3.value;
				var gs_dflt_tooth_no_Q4_hidden=frmObj.gs_dflt_tooth_no_Q4.value;

				var dec_gs_no_of_tooth_for_Q1_hidden=frmObj.dec_gs_no_of_tooth_for_Q1.value;
				var dec_gs_no_of_tooth_for_Q2_hidden=frmObj.dec_gs_no_of_tooth_for_Q2.value;
				var dec_gs_no_of_tooth_for_Q3_hidden=frmObj.dec_gs_no_of_tooth_for_Q3.value;
				var dec_gs_no_of_tooth_for_Q4_hidden=frmObj.dec_gs_no_of_tooth_for_Q4.value;
				var dec_gs_dflt_tooth_no_Q1_hidden=frmObj.dec_gs_dflt_tooth_no_Q1.value;
				var dec_gs_dflt_tooth_no_Q2_hidden=frmObj.dec_gs_dflt_tooth_no_Q2.value;
				var dec_gs_dflt_tooth_no_Q3_hidden=frmObj.dec_gs_dflt_tooth_no_Q3.value;
				var dec_gs_dflt_tooth_no_Q4_hidden=frmObj.dec_gs_dflt_tooth_no_Q4.value;

				var md_gs_no_of_tooth_for_Q1_hidden=frmObj.md_gs_no_of_tooth_for_Q1.value;
				var md_gs_no_of_tooth_for_Q2_hidden=frmObj.md_gs_no_of_tooth_for_Q2.value;
				var md_gs_no_of_tooth_for_Q3_hidden=frmObj.md_gs_no_of_tooth_for_Q3.value;
				var md_gs_no_of_tooth_for_Q4_hidden=frmObj.md_gs_no_of_tooth_for_Q4.value;
				var md_gs_dflt_tooth_no_Q1_hidden=frmObj.md_gs_dflt_tooth_no_Q1.value;
				var md_gs_dflt_tooth_no_Q2_hidden=frmObj.md_gs_dflt_tooth_no_Q2.value;
				var md_gs_dflt_tooth_no_Q3_hidden=frmObj.md_gs_dflt_tooth_no_Q3.value;
				var md_gs_dflt_tooth_no_Q4_hidden=frmObj.md_gs_dflt_tooth_no_Q4.value;

			//params="record_gingival_status_yn=Y&tooth_numbering_system="+tooth_numbering_system+"&gs_no_of_tooth_for_Q1_hidden="+gs_no_of_tooth_for_Q1_hidden+"&gs_no_of_tooth_for_Q2_hidden="+gs_no_of_tooth_for_Q2_hidden+"&gs_no_of_tooth_for_Q3_hidden="+gs_no_of_tooth_for_Q3_hidden+"&gs_no_of_tooth_for_Q4_hidden="+gs_no_of_tooth_for_Q4_hidden+"&gs_dflt_tooth_no_Q1_hidden="+gs_dflt_tooth_no_Q1_hidden+"&gs_dflt_tooth_no_Q2_hidden="+gs_dflt_tooth_no_Q2_hidden+"&gs_dflt_tooth_no_Q3_hidden="+gs_dflt_tooth_no_Q3_hidden+"&gs_dflt_tooth_no_Q4_hidden="+gs_dflt_tooth_no_Q4_hidden+"&from_mixed_dentition="+from_mixed_dentition+"&dflt_mixed_dentition_chart="+dflt_mixed_dentition_chart+"&callFrom=Q";
			params="record_gingival_status_yn=Y&tooth_numbering_system="+tooth_numbering_system+"&gs_no_of_tooth_for_Q1_hidden="+gs_no_of_tooth_for_Q1_hidden+"&gs_no_of_tooth_for_Q2_hidden="+gs_no_of_tooth_for_Q2_hidden+"&gs_no_of_tooth_for_Q3_hidden="+gs_no_of_tooth_for_Q3_hidden+"&gs_no_of_tooth_for_Q4_hidden="+gs_no_of_tooth_for_Q4_hidden+"&gs_dflt_tooth_no_Q1_hidden="+gs_dflt_tooth_no_Q1_hidden+"&gs_dflt_tooth_no_Q2_hidden="+gs_dflt_tooth_no_Q2_hidden+"&gs_dflt_tooth_no_Q3_hidden="+gs_dflt_tooth_no_Q3_hidden+"&gs_dflt_tooth_no_Q4_hidden="+gs_dflt_tooth_no_Q4_hidden+"&dec_gs_no_of_tooth_for_Q1_hidden="+dec_gs_no_of_tooth_for_Q1_hidden+"&dec_gs_no_of_tooth_for_Q2_hidden="+dec_gs_no_of_tooth_for_Q2_hidden+"&dec_gs_no_of_tooth_for_Q3_hidden="+dec_gs_no_of_tooth_for_Q3_hidden+"&dec_gs_no_of_tooth_for_Q4_hidden="+dec_gs_no_of_tooth_for_Q4_hidden+"&dec_gs_dflt_tooth_no_Q1_hidden="+dec_gs_dflt_tooth_no_Q1_hidden+"&dec_gs_dflt_tooth_no_Q2_hidden="+dec_gs_dflt_tooth_no_Q2_hidden+"&dec_gs_dflt_tooth_no_Q3_hidden="+dec_gs_dflt_tooth_no_Q3_hidden+"&dec_gs_dflt_tooth_no_Q4_hidden="+dec_gs_dflt_tooth_no_Q4_hidden+"&md_gs_no_of_tooth_for_Q1_hidden="+md_gs_no_of_tooth_for_Q1_hidden+"&md_gs_no_of_tooth_for_Q2_hidden="+md_gs_no_of_tooth_for_Q2_hidden+"&md_gs_no_of_tooth_for_Q3_hidden="+md_gs_no_of_tooth_for_Q3_hidden+"&md_gs_no_of_tooth_for_Q4_hidden="+md_gs_no_of_tooth_for_Q4_hidden+"&md_gs_dflt_tooth_no_Q1_hidden="+md_gs_dflt_tooth_no_Q1_hidden+"&md_gs_dflt_tooth_no_Q2_hidden="+md_gs_dflt_tooth_no_Q2_hidden+"&md_gs_dflt_tooth_no_Q3_hidden="+md_gs_dflt_tooth_no_Q3_hidden+"&md_gs_dflt_tooth_no_Q4_hidden="+md_gs_dflt_tooth_no_Q4_hidden+"&from_mixed_dentition="+from_mixed_dentition+"&callFrom=Q";
				
			parent.f_query_add_mod_gs.document.location.href="../../eOH/jsp/OHParamForFacilityAddModifyQuadrant.jsp?"+params;
			}
		}
	}
 }else {
		 	/*if (gingival_recording=="S"){
					formObj.gigival_recorded.value="Q"; //gingival recorded by if value iS "S",we are loading quadrant  so gigival_recorded is set as a "Q";
					parent.f_query_add_mod_gs.document.location.href="../../eOH/jsp/OHParamForFacilityAddModifyQuadrant.jsp?record_gingival_status_yn=Y&tooth_numbering_system="+tooth_numbering_system+"&from_mixed_dentition="+from_mixed_dentition;
				}
				else if (gingival_recording=="Q"){
					formObj.gigival_recorded.value="S";
					parent.f_query_add_mod_gs.document.location.href="../../eOH/jsp/OHParamForFacilityAddModifySextant.jsp?record_gingival_status_yn=Y&tooth_numbering_system="+tooth_numbering_system+"&from_mixed_dentition="+from_mixed_dentition;
				}*/
			if (formObj.gigival_recorded.value=="S"){

				parent.f_query_add_mod_gs.document.location.href="../../eOH/jsp/OHParamForFacilityAddModifySextant.jsp?record_gingival_status_yn=Y&tooth_numbering_system="+tooth_numbering_system+"&from_mixed_dentition="+from_mixed_dentition;			
			}else if(formObj.gigival_recorded.value=="Q"){
				parent.f_query_add_mod_gs.document.location.href="../../eOH/jsp/OHParamForFacilityAddModifyQuadrant.jsp?record_gingival_status_yn=Y&tooth_numbering_system="+tooth_numbering_system+"&from_mixed_dentition="+from_mixed_dentition;			
			}
		
	  
		}
	// }
	 }
}

/* function setEnterpriseSpecific(obj){  // added by parul for Enterprise Specific Chart Applicable
	 var formObj = document.forms[0];
	  if(obj.checked==true)
			obj.value="Y";
	else{
		 obj.value=="N";
	}
}*/

function populateMixedDentition(){
	var obj = document.forms[0];
	var frmObj = parent.f_query_add_mod_gs.document.forms[0];
	var dflt_mixed_dentition_chart = document.forms[0].dflt_mixed_dentition_chart.value;
	var tooth_numbering_system = document.forms[0].tooth_numbering_system.value;
	var record_gingival_status=document.forms[0].record_gingival_status_yn.value;
	var gigival_recorded=frmObj.gigival_recorded.value;
	var from_mixed_dentition="";

	if (dflt_mixed_dentition_chart=="P"){
		from_mixed_dentition="P";
	}else if (dflt_mixed_dentition_chart=="D"){
		from_mixed_dentition="D";
	}
	var params= "from_mixed_dentition="+from_mixed_dentition+"&tooth_numbering_system="+tooth_numbering_system+"&record_gingival_status_yn="+record_gingival_status;
	if (gigival_recorded=='S'){								   
		parent.f_query_add_mod_gs.document.location.href="../../eOH/jsp/OHParamForFacilityAddModifySextant.jsp?"+params;
	}else if (gigival_recorded=='Q'){
		parent.f_query_add_mod_gs.document.location.href="../../eOH/jsp/OHParamForFacilityAddModifyQuadrant.jsp?"+params;

	}
}

function loadGingivalStatus(){
	var cmf=parent.commontoolbarFrame.document.forms[0];
	var obj = document.forms[0];
	var chrt_level=obj.chrt_level.value;
	if (chrt_level=="" || chrt_level=="null" || chrt_level==null){
		alert(getMessage("APP-OH000116","OH"))
		 cmf.apply.disabled=true;
		 cmf.reset.disabled=true;
	}else if (chrt_level=="E"){
		parent.f_query_add_mod_gs.document.location.href='../../eCommon/html/blank.html'
	}
}

	function checkForFacilityGingival(){
	
		var frm = parent.f_query_add_mod.document.forms[0];
		var chart_level_label="ChartLevel";
		var formObj = parent.f_query_add_mod_gs.document.forms[0];
		var dflt_mixed_dentition_chart=formObj.dflt_mixed_dentition_chart.value;
		var md="";
		var toothnumsyslable=getLabel("eOH.ToothNumberingSystem.Label","OH");
		var MixedDentitionFromAgeYrs_label=getLabel("eOH.MixedDentitionFromAgeYrs.Label","OH");
		var MixedDentitionToAgeYrs_label=getLabel("eOH.MixedDentitionToAgeYrs.Label","OH");
		if (dflt_mixed_dentition_chart=="D"){
				md=getLabel("eOH.DeciduousMD.Label","OH");;
		  } else{
				md=getLabel("eOH.PermanentMD.Label","OH");;
		  }

		if (formObj.name=="OHParameterForFacilityFormForSextant"){

			if(frm.record_gingival_status_yn.checked == true){
				var tooth_numbering_system = formObj.tooth_numbering_system.value;
				var toothnumsyslable=getLabel("eOH.ToothNumberingSystem.Label","OH");
				var MixedDentitionFromAgeYrs_label=getLabel("eOH.MixedDentitionFromAgeYrs.Label","OH");
				var MixedDentitionToAgeYrs_label=getLabel("eOH.MixedDentitionToAgeYrs.Label","OH");
				
				var gs_no_of_tooth_for_S1_label ="MaxNumOfTooth of"+" "+getLabel("Common.Permanent.label","COMMON")+" "+"UR";
				var gs_no_of_tooth_for_S2_label ="MaxNumOfTooth of"+" "+getLabel("Common.Permanent.label","COMMON")+" "+"UA";
				var gs_no_of_tooth_for_S3_label ="MaxNumOfTooth of"+" "+getLabel("Common.Permanent.label","COMMON")+" "+"UL";
				var gs_no_of_tooth_for_S4_label ="MaxNumOfTooth of"+" "+getLabel("Common.Permanent.label","COMMON")+" "+"LL";
				var gs_no_of_tooth_for_S5_label ="MaxNumOfTooth of"+" "+getLabel("Common.Permanent.label","COMMON")+" "+"LA";
				var gs_no_of_tooth_for_S6_label ="MaxNumOfTooth of"+" "+getLabel("Common.Permanent.label","COMMON")+" "+"LR";

				var dec_gs_no_of_tooth_for_S1_label ="MaxNumOfTooth of"+" "+getLabel("eOH.Decedious.Label","OH")+" "+"UR";
				var dec_gs_no_of_tooth_for_S2_label ="MaxNumOfTooth of"+" "+getLabel("eOH.Decedious.Label","OH")+" "+"UA";
				var dec_gs_no_of_tooth_for_S3_label ="MaxNumOfTooth of"+" "+getLabel("eOH.Decedious.Label","OH")+" "+"UL";
				var dec_gs_no_of_tooth_for_S4_label ="MaxNumOfTooth of"+" "+getLabel("eOH.Decedious.Label","OH")+" "+"LL";
				var dec_gs_no_of_tooth_for_S5_label ="MaxNumOfTooth of"+" "+getLabel("eOH.Decedious.Label","OH")+" "+"LA";
				var dec_gs_no_of_tooth_for_S6_label ="MaxNumOfTooth of"+" "+getLabel("eOH.Decedious.Label","OH")+" "+"LR";


				var md_gs_no_of_tooth_for_S1_label ="MaxNumOfTooth of"+" "+md+" "+"UR";
				var md_gs_no_of_tooth_for_S2_label ="MaxNumOfTooth of"+" "+md+" "+"UA";
				var md_gs_no_of_tooth_for_S3_label ="MaxNumOfTooth of"+" "+md+" "+"UL";
				var md_gs_no_of_tooth_for_S4_label ="MaxNumOfTooth of"+" "+md+" "+"LL";
				var md_gs_no_of_tooth_for_S5_label ="MaxNumOfTooth of"+" "+md+" "+"LA";
				var md_gs_no_of_tooth_for_S6_label ="MaxNumOfTooth of"+" "+md+" "+"LR";


				var p_upper_right = "UR"+" "+getLabel("Common.Default.label","COMMON")+getLabel("eOH.For.Label","OH")+" "+getLabel("Common.Permanent.label","COMMON");
				var p_upper_anterior = "UA"+" "+getLabel("Common.Default.label","COMMON")+getLabel("eOH.For.Label","OH")+" "+getLabel("Common.Permanent.label","COMMON");
				var p_upper_left = "UL"+" "+getLabel("Common.Default.label","COMMON")+getLabel("eOH.For.Label","OH")+" "+getLabel("Common.Permanent.label","COMMON");
				var p_lower_left = "LL"+" "+getLabel("Common.Default.label","COMMON")+getLabel("eOH.For.Label","OH")+" "+getLabel("Common.Permanent.label","COMMON");
				var p_lower_anterior = "LA"+" "+getLabel("Common.Default.label","COMMON")+getLabel("eOH.For.Label","OH")+" "+getLabel("Common.Permanent.label","COMMON");
				var p_lower_right = "LR"+" "+getLabel("Common.Default.label","COMMON")+getLabel("eOH.For.Label","OH")+" "+getLabel("Common.Permanent.label","COMMON");
					
				var dec_upper_right= "UR"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("eOH.Decedious.Label","OH");
				var dec_upper_anterior= "UA"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("eOH.Decedious.Label","OH");
				var dec_upper_left= "UL"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("eOH.Decedious.Label","OH");
				var dec_lower_left= "LL"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("eOH.Decedious.Label","OH");
				var dec_lower_anterior= "LA"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("eOH.Decedious.Label","OH");
				var dec_lower_right= "LR"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("eOH.Decedious.Label","OH");

				var md_upper_right ="UR"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+md;
				var md_upper_anterior ="UA"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+md;
				var md_upper_left ="UL"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+md;
				var md_lower_left ="LL"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+md;
				var md_lower_anterior ="LA"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+md;
				var md_lower_right ="LR"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+md;
			//	var fields = new Array(frm.tooth_numbering_system,frm.mixed_dentition_from_age_yrs,frm.mixed_dentition_to_age_yrs,formObj.dec_gs_no_of_tooth_for_S1,formObj.dec_gs_no_of_tooth_for_S2,formObj.dec_gs_no_of_tooth_for_S3,formObj.dec_gs_no_of_tooth_for_S4,formObj.dec_gs_no_of_tooth_for_S5,formObj.dec_gs_no_of_tooth_for_S6,formObj.dec_gs_dflt_tooth_no_S1,formObj.dec_gs_dflt_tooth_no_S2,formObj.dec_gs_dflt_tooth_no_S3,formObj.dec_gs_dflt_tooth_no_S4,formObj.dec_gs_dflt_tooth_no_S5,formObj.dec_gs_dflt_tooth_no_S6,formObj.md_gs_no_of_tooth_for_S1,formObj.md_gs_no_of_tooth_for_S2,formObj.md_gs_no_of_tooth_for_S3,formObj.md_gs_no_of_tooth_for_S4,formObj.md_gs_no_of_tooth_for_S5,formObj.md_gs_no_of_tooth_for_S6,formObj.gs_no_of_tooth_for_S1,formObj.gs_no_of_tooth_for_S2,formObj.gs_no_of_tooth_for_S3,formObj.gs_no_of_tooth_for_S4,formObj.gs_no_of_tooth_for_S5,formObj.gs_no_of_tooth_for_S6,formObj.gs_dflt_tooth_no_S1,formObj.gs_dflt_tooth_no_S2,formObj.gs_dflt_tooth_no_S3,formObj.gs_dflt_tooth_no_S4,formObj.gs_dflt_tooth_no_S5,formObj.gs_dflt_tooth_no_S6);
				var fields = new Array(formObj.dec_gs_no_of_tooth_for_S1,formObj.dec_gs_no_of_tooth_for_S2,formObj.dec_gs_no_of_tooth_for_S3,formObj.dec_gs_no_of_tooth_for_S4,formObj.dec_gs_no_of_tooth_for_S5,formObj.dec_gs_no_of_tooth_for_S6,formObj.dec_gs_dflt_tooth_no_S1,formObj.dec_gs_dflt_tooth_no_S2,formObj.dec_gs_dflt_tooth_no_S3,formObj.dec_gs_dflt_tooth_no_S4,formObj.dec_gs_dflt_tooth_no_S5,formObj.dec_gs_dflt_tooth_no_S6,formObj.md_gs_no_of_tooth_for_S1,formObj.md_gs_no_of_tooth_for_S2,formObj.md_gs_no_of_tooth_for_S3,formObj.md_gs_no_of_tooth_for_S4,formObj.md_gs_no_of_tooth_for_S5,formObj.md_gs_no_of_tooth_for_S6,formObj.gs_no_of_tooth_for_S1,formObj.gs_no_of_tooth_for_S2,formObj.gs_no_of_tooth_for_S3,formObj.gs_no_of_tooth_for_S4,formObj.gs_no_of_tooth_for_S5,formObj.gs_no_of_tooth_for_S6,formObj.gs_dflt_tooth_no_S1,formObj.gs_dflt_tooth_no_S2,formObj.gs_dflt_tooth_no_S3,formObj.gs_dflt_tooth_no_S4,formObj.gs_dflt_tooth_no_S5,formObj.gs_dflt_tooth_no_S6);

				//var names = new Array (toothnumsyslable,MixedDentitionFromAgeYrs_label,MixedDentitionToAgeYrs_label,dec_gs_no_of_tooth_for_S1_label,dec_gs_no_of_tooth_for_S2_label,dec_gs_no_of_tooth_for_S3_label,dec_gs_no_of_tooth_for_S4_label,dec_gs_no_of_tooth_for_S5_label,dec_gs_no_of_tooth_for_S6_label,dec_upper_right,dec_upper_anterior,dec_upper_left,dec_lower_left,dec_lower_anterior,dec_lower_right,md_gs_no_of_tooth_for_S1_label,md_gs_no_of_tooth_for_S2_label,md_gs_no_of_tooth_for_S3_label,md_gs_no_of_tooth_for_S4_label,md_gs_no_of_tooth_for_S5_label,md_gs_no_of_tooth_for_S6_label,gs_no_of_tooth_for_S1_label,gs_no_of_tooth_for_S2_label,gs_no_of_tooth_for_S3_label,gs_no_of_tooth_for_S4_label,gs_no_of_tooth_for_S5_label,gs_no_of_tooth_for_S6_label,p_upper_right,p_upper_anterior,p_upper_left,p_lower_left,p_lower_anterior,p_lower_right);
				var names = new Array (dec_gs_no_of_tooth_for_S1_label,dec_gs_no_of_tooth_for_S2_label,dec_gs_no_of_tooth_for_S3_label,dec_gs_no_of_tooth_for_S4_label,dec_gs_no_of_tooth_for_S5_label,dec_gs_no_of_tooth_for_S6_label,dec_upper_right,dec_upper_anterior,dec_upper_left,dec_lower_left,dec_lower_anterior,dec_lower_right,md_gs_no_of_tooth_for_S1_label,md_gs_no_of_tooth_for_S2_label,md_gs_no_of_tooth_for_S3_label,md_gs_no_of_tooth_for_S4_label,md_gs_no_of_tooth_for_S5_label,md_gs_no_of_tooth_for_S6_label,gs_no_of_tooth_for_S1_label,gs_no_of_tooth_for_S2_label,gs_no_of_tooth_for_S3_label,gs_no_of_tooth_for_S4_label,gs_no_of_tooth_for_S5_label,gs_no_of_tooth_for_S6_label,p_upper_right,p_upper_anterior,p_upper_left,p_lower_left,p_lower_anterior,p_lower_right);
			}else{
					var fields = new Array (frm.tooth_numbering_system,frm.mixed_dentition_from_age_yrs,frm.mixed_dentition_to_age_yrs);
					var names = new Array (toothnumsyslable,MixedDentitionFromAgeYrs_label,MixedDentitionToAgeYrs_label);
				}

		}else{
				var tooth_numbering_system = formObj.tooth_numbering_system.value;
				var toothnumsyslable=getLabel("eOH.ToothNumberingSystem.Label","OH");
				var MixedDentitionFromAgeYrs_label=getLabel("eOH.MixedDentitionFromAgeYrs.Label","OH");
				var MixedDentitionToAgeYrs_label=getLabel("eOH.MixedDentitionToAgeYrs.Label","OH");
			if(frm.record_gingival_status_yn.checked == true){

				 var gs_no_of_tooth_for_Q1_label ="MaxNumOfTooth of"+" "+getLabel("Common.Permanent.label","COMMON")+" "+"UR";
				var gs_no_of_tooth_for_Q2_label ="MaxNumOfTooth of"+" "+getLabel("Common.Permanent.label","COMMON")+" "+"UL";
				var gs_no_of_tooth_for_Q3_label ="MaxNumOfTooth of"+" "+getLabel("Common.Permanent.label","COMMON")+" "+"LR";
				var gs_no_of_tooth_for_Q4_label ="MaxNumOfTooth of"+" "+getLabel("Common.Permanent.label","COMMON")+" "+"LL";

				var dec_gs_no_of_tooth_for_Q1_label ="MaxNumOfTooth of"+" "+getLabel("eOH.Decedious.Label","OH")+" "+"UR";
				var dec_gs_no_of_tooth_for_Q2_label ="MaxNumOfTooth of"+" "+getLabel("eOH.Decedious.Label","OH")+" "+"UL";
				var dec_gs_no_of_tooth_for_Q3_label ="MaxNumOfTooth of"+" "+getLabel("eOH.Decedious.Label","OH")+" "+"LR";
				var dec_gs_no_of_tooth_for_Q4_label ="MaxNumOfTooth of"+" "+getLabel("eOH.Decedious.Label","OH")+" "+"LL";


				var md_gs_no_of_tooth_for_Q1_label ="MaxNumOfTooth of"+" "+md+" "+"UR";
				var md_gs_no_of_tooth_for_Q2_label ="MaxNumOfTooth of"+" "+md+" "+"UL";
				var md_gs_no_of_tooth_for_Q3_label ="MaxNumOfTooth of"+" "+md+" "+"LR";
				var md_gs_no_of_tooth_for_Q4_label ="MaxNumOfTooth of"+" "+md+" "+"LL";
			 
				var p_upper_right = "UR"+" "+getLabel("Common.Default.label","COMMON")+getLabel("eOH.For.Label","OH")+" "+getLabel("Common.Permanent.label","COMMON");
				var p_upper_left = "UL"+" "+getLabel("Common.Default.label","COMMON")+getLabel("eOH.For.Label","OH")+" "+getLabel("Common.Permanent.label","COMMON");
				var p_lower_right = "LR"+" "+getLabel("Common.Default.label","COMMON")+getLabel("eOH.For.Label","OH")+" "+getLabel("Common.Permanent.label","COMMON");
				var p_lower_left = "LL"+" "+getLabel("Common.Default.label","COMMON")+getLabel("eOH.For.Label","OH")+" "+getLabel("Common.Permanent.label","COMMON");

				var dec_upper_right= "UR"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("eOH.Decedious.Label","OH");
				var dec_upper_left= "UL"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("eOH.Decedious.Label","OH");
				var dec_lower_right= "LR"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("eOH.Decedious.Label","OH");
				var dec_lower_left= "LL"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+getLabel("eOH.Decedious.Label","OH");

				var md_upper_right ="UR"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+md;
				var md_upper_left ="UL"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+md;
				var md_lower_right ="LR"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+md;
				var md_lower_left ="LL"+" "+getLabel("Common.Default.label","COMMON")+" "+getLabel("eOH.For.Label","OH")+" "+md;
				//var fields = new Array(frm.tooth_numbering_system,frm.mixed_dentition_from_age_yrs,frm.mixed_dentition_to_age_yrs,formObj.dec_gs_no_of_tooth_for_Q1,formObj.dec_gs_no_of_tooth_for_Q2,formObj.dec_gs_no_of_tooth_for_Q3,formObj.dec_gs_no_of_tooth_for_Q4,formObj.dec_gs_dflt_tooth_no_Q1,formObj.dec_gs_dflt_tooth_no_Q2,formObj.dec_gs_dflt_tooth_no_Q3,formObj.dec_gs_dflt_tooth_no_Q4,formObj.md_gs_no_of_tooth_for_Q1,formObj.md_gs_no_of_tooth_for_Q2,formObj.md_gs_no_of_tooth_for_Q3,formObj.md_gs_no_of_tooth_for_Q4,formObj.gs_no_of_tooth_for_Q1,formObj.gs_no_of_tooth_for_Q2,formObj.gs_no_of_tooth_for_Q3,formObj.gs_no_of_tooth_for_Q4,formObj.gs_dflt_tooth_no_Q1,formObj.gs_dflt_tooth_no_Q2,formObj.gs_dflt_tooth_no_Q3,formObj.gs_dflt_tooth_no_Q4);
				var fields = new Array(formObj.dec_gs_no_of_tooth_for_Q1,formObj.dec_gs_no_of_tooth_for_Q2,formObj.dec_gs_no_of_tooth_for_Q3,formObj.dec_gs_no_of_tooth_for_Q4,formObj.dec_gs_dflt_tooth_no_Q1,formObj.dec_gs_dflt_tooth_no_Q2,formObj.dec_gs_dflt_tooth_no_Q3,formObj.dec_gs_dflt_tooth_no_Q4,formObj.md_gs_no_of_tooth_for_Q1,formObj.md_gs_no_of_tooth_for_Q2,formObj.md_gs_no_of_tooth_for_Q3,formObj.md_gs_no_of_tooth_for_Q4,formObj.gs_no_of_tooth_for_Q1,formObj.gs_no_of_tooth_for_Q2,formObj.gs_no_of_tooth_for_Q3,formObj.gs_no_of_tooth_for_Q4,formObj.gs_dflt_tooth_no_Q1,formObj.gs_dflt_tooth_no_Q2,formObj.gs_dflt_tooth_no_Q3,formObj.gs_dflt_tooth_no_Q4);
				//var names = new Array (toothnumsyslable,MixedDentitionFromAgeYrs_label,MixedDentitionToAgeYrs_label,dec_gs_no_of_tooth_for_Q1_label,dec_gs_no_of_tooth_for_Q2_label,dec_gs_no_of_tooth_for_Q3_label,dec_gs_no_of_tooth_for_Q4_label,dec_upper_right,dec_upper_left,dec_lower_right,dec_lower_left,md_gs_no_of_tooth_for_Q1_label,md_gs_no_of_tooth_for_Q2_label,md_gs_no_of_tooth_for_Q3_label,md_gs_no_of_tooth_for_Q4_label,gs_no_of_tooth_for_Q1_label,gs_no_of_tooth_for_Q2_label,gs_no_of_tooth_for_Q3_label,gs_no_of_tooth_for_Q4_label,p_upper_right,p_upper_left,p_lower_right,p_lower_left);
				var names = new Array (dec_gs_no_of_tooth_for_Q1_label,dec_gs_no_of_tooth_for_Q2_label,dec_gs_no_of_tooth_for_Q3_label,dec_gs_no_of_tooth_for_Q4_label,dec_upper_right,dec_upper_left,dec_lower_right,dec_lower_left,md_gs_no_of_tooth_for_Q1_label,md_gs_no_of_tooth_for_Q2_label,md_gs_no_of_tooth_for_Q3_label,md_gs_no_of_tooth_for_Q4_label,gs_no_of_tooth_for_Q1_label,gs_no_of_tooth_for_Q2_label,gs_no_of_tooth_for_Q3_label,gs_no_of_tooth_for_Q4_label,p_upper_right,p_upper_left,p_lower_right,p_lower_left);
		
			}else{
					var fields = new Array (frm.tooth_numbering_system,frm.mixed_dentition_from_age_yrs,frm.mixed_dentition_to_age_yrs);
					var names = new Array (toothnumsyslable,MixedDentitionFromAgeYrs_label,MixedDentitionToAgeYrs_label);
				}
		}
			var gingval_chk=checkFieldsofMstFacilityGingival(fields,names);
			return gingval_chk;
			
	}	


	function checkFieldsofMstFacilityGingival(fields,names) {
		var errors = "" ;
		for( var i=0; i<fields.length; i++ ){
			if(trimCheck(fields[i].value)){
				fields[i].value = trimString(fields[i].value);
				  errors=1;
				  break;
			}else{ 
				  errors=0;
			}
		}
		if (errors==1){
			return  true;
		}else{
		   return  false;
		}
	}


function checkRecorded(){
	var formObj = f_query_add_mod.document.forms[0];
	var frm = f_query_add_mod_gs.document.forms[0];
	var chrt_level=formObj.chrt_level.value;
	var errors = "" ;
	if (chrt_level=="F"){
		if (formObj.tooth_numbering_system.value==formObj.tooth_numbering_system.DB_VALUE){
			errors=0;
		}else{
			errors=1;
			return;

		}
		 if (formObj.deciduous_grace_period_days.value==formObj.deciduous_grace_period_days_hid.value){
			errors=0;
		}else{

			errors=1;
			return;

		}
		if(formObj.rest_chrt_validity_days.value==formObj.rest_chrt_validity_days_hid.value){
				errors=0;
		}else{
				errors=1;
				return;
		}

		if(formObj.peri_chrt_validity_days.value==formObj.peri_chrt_validity_days_hid.value){
				errors=0;
		}else{
				errors=1;
				return;
		}
		
		if (formObj.bl_interface_flag_hid.value=="" ||formObj.bl_interface_flag_hid.value=="null" || formObj.bl_interface_flag_hid.value==null)
		{
			formObj.bl_interface_flag_hid.value="N";
		}
		if(formObj.bl_interface_flag.value==formObj.bl_interface_flag_hid.value){
				errors=0;
		}else{
				errors=1;
				return;
		}
		if(formObj.gigival_recorded.value=="S"){
		
			if(frm.gs_no_of_tooth_for_S1.value==frm.gs_no_of_tooth_for_S1_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
			if(frm.gs_no_of_tooth_for_S2.value==frm.gs_no_of_tooth_for_S2_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
			if(frm.gs_no_of_tooth_for_S3.value==frm.gs_no_of_tooth_for_S3_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
			if(frm.gs_no_of_tooth_for_S4.value==frm.gs_no_of_tooth_for_S4_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
			if(frm.gs_no_of_tooth_for_S5.value==frm.gs_no_of_tooth_for_S5_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
			if(frm.gs_no_of_tooth_for_S6.value==frm.gs_no_of_tooth_for_S6_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
			if(frm.dec_gs_no_of_tooth_for_S1.value==frm.dec_gs_no_of_tooth_for_S1_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
			if(frm.dec_gs_no_of_tooth_for_S2.value==frm.dec_gs_no_of_tooth_for_S2_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
			if(frm.dec_gs_no_of_tooth_for_S3.value==frm.dec_gs_no_of_tooth_for_S3_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
			if(frm.dec_gs_no_of_tooth_for_S4.value==frm.dec_gs_no_of_tooth_for_S4_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
			if(frm.dec_gs_no_of_tooth_for_S5.value==frm.dec_gs_no_of_tooth_for_S5_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
			if(frm.dec_gs_no_of_tooth_for_S6.value==frm.dec_gs_no_of_tooth_for_S6_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
			if(frm.md_gs_no_of_tooth_for_S1.value==frm.md_gs_no_of_tooth_for_S1_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
			if(frm.md_gs_no_of_tooth_for_S2.value==frm.md_gs_no_of_tooth_for_S2_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
			if(frm.md_gs_no_of_tooth_for_S3.value==frm.md_gs_no_of_tooth_for_S3_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
			if(frm.md_gs_no_of_tooth_for_S4.value==frm.md_gs_no_of_tooth_for_S4_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
			if(frm.md_gs_no_of_tooth_for_S5.value==frm.md_gs_no_of_tooth_for_S5_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
			if(frm.md_gs_no_of_tooth_for_S6.value==frm.md_gs_no_of_tooth_for_S6_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
			if(frm.md_gs_dflt_tooth_no_S1.value==frm.md_gs_dflt_tooth_no_S1_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
			if(frm.md_gs_dflt_tooth_no_S2.value==frm.md_gs_dflt_tooth_no_S2_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
			if(frm.md_gs_dflt_tooth_no_S3.value==frm.md_gs_dflt_tooth_no_S3_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
			if(frm.md_gs_dflt_tooth_no_S4.value==frm.md_gs_dflt_tooth_no_S4_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
			if(frm.md_gs_dflt_tooth_no_S5.value==frm.md_gs_dflt_tooth_no_S5_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
			if(frm.md_gs_dflt_tooth_no_S6.value==frm.md_gs_dflt_tooth_no_S6_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
	}else{
		if(frm.gs_no_of_tooth_for_Q1.value==frm.gs_no_of_tooth_for_Q1_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
		if(frm.gs_no_of_tooth_for_Q2.value==frm.gs_no_of_tooth_for_Q2_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
		if(frm.gs_no_of_tooth_for_Q3.value==frm.gs_no_of_tooth_for_Q3_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
		if(frm.gs_no_of_tooth_for_Q4.value==frm.gs_no_of_tooth_for_Q3_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
		if(frm.dec_gs_no_of_tooth_for_Q1.value==frm.dec_gs_no_of_tooth_for_Q1_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
		if(frm.dec_gs_no_of_tooth_for_Q2.value==frm.dec_gs_no_of_tooth_for_Q2_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
		if(frm.dec_gs_no_of_tooth_for_Q3.value==frm.dec_gs_no_of_tooth_for_Q3_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
		if(frm.dec_gs_no_of_tooth_for_Q4.value==frm.dec_gs_no_of_tooth_for_Q4_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
		if(frm.md_gs_no_of_tooth_for_Q1.value==frm.md_gs_no_of_tooth_for_Q1_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
		if(frm.md_gs_no_of_tooth_for_Q2.value==frm.md_gs_no_of_tooth_for_Q2_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
		if(frm.md_gs_no_of_tooth_for_Q3.value==frm.md_gs_no_of_tooth_for_Q3_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
		if(frm.md_gs_no_of_tooth_for_Q4.value==frm.md_gs_no_of_tooth_for_Q4_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
		if(frm.md_gs_dflt_tooth_no_Q1.value==frm.md_gs_dflt_tooth_no_Q1_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
		if(frm.md_gs_dflt_tooth_no_Q2.value==frm.md_gs_dflt_tooth_no_Q2_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
		if(frm.md_gs_dflt_tooth_no_Q3.value==frm.md_gs_dflt_tooth_no_Q3_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}
		if(frm.md_gs_dflt_tooth_no_Q4.value==frm.md_gs_dflt_tooth_no_Q4_hid.value){	
					errors=0;
			}else{
					errors=1;
					return;
			}

	}
}else{

		if (formObj.bl_interface_flag.value=="Y"){
			if(formObj.bl_interface_flag_hid.value=="N"){
			errors=0;
			}else if(formObj.bl_interface_flag.value==formObj.bl_interface_flag_hid.value){
				}else{
				errors=1;
				return;
			}

		}else if (formObj.bl_interface_flag.value=="N"){
			if(formObj.bl_interface_flag_hid.value=="Y"){
				errors=1;
				return;
			}else if (formObj.bl_interface_flag_hid.value==""){
				errors=0;
			}else{
				errors=1;
				return;
			}
		}else{
			errors=0;
		
		}
}
	if (errors==1){
			return  true;
		}else {
		   return  false;
		}
}
//Added by Sharon Crasta on 11/17/2009 for IN016376
//Added to disable the backspace key.
function checkBackspaceKey(obj){
	if(event.keyCode==8 || event.keyCode==13)
	{
	   return false;
	}
}


