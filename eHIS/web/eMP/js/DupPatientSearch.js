/*Function For Reset */
function reset()
{
  
   var register_button_yn = parent.Pat_Search_Criteria_Frame.forms[0].register_button_yn.value;
   var soundex = parent.Pat_Search_Criteria_Frame.forms[0].soundex_dflt.value;
   var func_act = parent.Pat_Search_Criteria_Frame.forms[0].func_act.value;	
   parent.Pat_Search_Criteria_Frame.forms[0].reset();
   parent.Pat_Search_Toolbar_Frame.location.href = "../../eMP/jsp/DupSearchToolbar.jsp?register_button_yn="+register_button_yn+"&func_act="+func_act+"";
   parent.Pat_Results_Frame.location.href = '../../eCommon/html/blank.html';
   parent.Pat_Search_Criteria_Frame.document.forms[0].Soundex.value = soundex;
   // tab_click2('search_tab');
  //tab_click2('search_tab1','search_tab1');
}
/*Reset Ends*/


function DefaultSelect(sndx) 
{
	if(sndx=="") parent.Pat_Search_Criteria_Frame.document.forms[0].Soundex.value="";
	if(sndx=="E") parent.Pat_Search_Criteria_Frame.document.forms[0].Soundex.value="E";
	if(sndx=="G") parent.Pat_Search_Criteria_Frame.document.forms[0].Soundex.value="G";
}






/****************
	Developed On 12/26/2008
	1.Submitting Form Elements to Respective Pages wheather the Search Criteria from Basic Search Or Advance Search .
	2.Based On the Form Name  Submision was Handled. 
******************/
			var HitLimit;
            var toval;
            var fromval;
            var fullSQLstr;
            var countSQLstr;
            var flag='';
            var str_new;

function searchForRslt(str,str_new,dtyn,ord,oth_lang_str){
/*************Basic Search Tab*****************/
var func_act				= document.getElementById('cr_func_act').value;
var act_yn				= document.getElementById('cr_act_yn').value;
var function_id				= document.getElementById('cr_function_id').value;

if (document.forms[0].name=="Basic_Patient_Search_Form"){
	var pat_id1=document.getElementById('Patient_Id1').value;
	var gender="";
	if (Basic_Patient_Search_Form.Sex){
	gender=Basic_Patient_Search_Form.Sex.value;
	}
	var fieldsFlag=false;
	var national_id_no1="";
	var order_by1="";
	if(document.getElementById('National_Id_No1')){
		national_id_no1=document.getElementById('National_Id_No1').value;
	}
	var alt_id1_no1="";
	if(document.getElementById('Alt_Id1_No1')){
		alt_id1_no1=document.getElementById('Alt_Id1_No1').value;
	}
	var alt_id2_no1="";
	if(document.getElementById('Alt_Id2_No1')){
		alt_id2_no1=document.getElementById('Alt_Id2_No1').value;
	}
	var alt_id3_no1="";
	if(document.getElementById('Alt_Id3_No1')){
		alt_id3_no1=document.getElementById('Alt_Id3_No1').value;
	}
	var alt_id4_no1="";
	if(document.getElementById('Alt_Id4_No1')){
		alt_id4_no1=document.getElementById('Alt_Id4_No1').value;
	}
	/*var pat_name1="";
	if(document.getElementById('pat_name1')){
		pat_name1=document.getElementById('pat_name1').value;
	}
	var pat_name_local1="";
	if(document.getElementById('pat_name_local1')){
		pat_name_local1=document.getElementById('pat_name_local1').value
	}*/
	var First_Name1=""; 
	if(document.getElementById('First_Name1')){
		First_Name1=document.getElementById('First_Name1').value;
	}
	var Second_Name1=""; 
	if(document.getElementById('Second_Name1')){
		Second_Name1=document.getElementById('Second_Name1').value;
	}
	var Third_Name1=""; 
	if(document.getElementById('Third_Name1')){
		Third_Name1=document.getElementById('Third_Name1').value;
	}
	var Family_Name1=""; 
	if(document.getElementById('Family_Name1')){
		Family_Name1=document.getElementById('Family_Name1').value;
	}
	var first_name_loc_lang1=""; 
	if(document.getElementById('first_name_loc_lang1')){
		first_name_loc_lang1=document.getElementById('first_name_loc_lang1').value;
	}
	var second_name_loc_lang1=""; 
	if(document.getElementById('second_name_loc_lang1')){
		second_name_loc_lang1=document.getElementById('second_name_loc_lang1').value;
	}
	var third_name_loc_lang1=""; 
	if(document.getElementById('third_name_loc_lang1')){
		third_name_loc_lang1=document.getElementById('third_name_loc_lang1').value;
	}
	var family_name_loc_lang1=""; 
	if(document.getElementById('family_name_loc_lang1')){
		family_name_loc_lang1=document.getElementById('family_name_loc_lang1').value;
	}
	var pr_resNo1="";
	if(document.getElementById('pr_resNo1')){
		pr_resNo1=document.getElementById('pr_resNo1').value;
	}
	var oth_no1="";
	if(document.getElementById('oth_no1').value){
		oth_no1=document.getElementById('oth_no1').value;
	}
	var search_in ="P";
	if(Basic_Patient_Search_Form.search_in){
		search_in= Basic_Patient_Search_Form.search_in.value;
	}
	order_by1=Basic_Patient_Search_Form.order_by1.value;
//	alert(order_by1)
	if(pat_id1!="")
		fieldsFlag=true;
	if(!fieldsFlag && national_id_no1!="")
		fieldsFlag=true;
	if(!fieldsFlag && alt_id1_no1!="")
		fieldsFlag=true;
	if(!fieldsFlag && alt_id2_no1!="")
		fieldsFlag=true;
	if(!fieldsFlag && alt_id3_no1!="")
		fieldsFlag=true;
	if(!fieldsFlag && alt_id4_no1!="")
		fieldsFlag=true;
	if(!fieldsFlag && pr_resNo1!="")
		fieldsFlag=true;
	if(!fieldsFlag && oth_no1!="")
		fieldsFlag=true;
	if(!fieldsFlag && First_Name1!="")
		fieldsFlag=true;
	if(!fieldsFlag && Second_Name1!="")
		fieldsFlag=true;
	if(!fieldsFlag && Third_Name1!="")
		fieldsFlag=true;
	if(!fieldsFlag && Family_Name1!="")
		fieldsFlag=true;
	if(!fieldsFlag && first_name_loc_lang1!="")
		fieldsFlag=true;
	if(!fieldsFlag && second_name_loc_lang1!="")
		fieldsFlag=true;
	if(!fieldsFlag && third_name_loc_lang1!="")
		fieldsFlag=true;
	if(!fieldsFlag && family_name_loc_lang1!="")
		fieldsFlag=true;

				if(fieldsFlag){
				HTMLVal = "<html><BODY onKeyDown='lockKey()'><form name='Dummy' id='Dummy' method='post' action='../../eMP/jsp/BasicPatientSearchResult.jsp'><input name='pat_id1' id='pat_id1' type='hidden' value='"+pat_id1+"'><input name='national_id_no1' id='national_id_no1' type='hidden' value='"+national_id_no1+"'><input name='alt_id1_no1' id='alt_id1_no1' type='hidden' value='"+alt_id1_no1+"'><input name='alt_id2_no1' id='alt_id2_no1' type='hidden' value='"+alt_id2_no1+"'><input name='alt_id3_no1' id='alt_id3_no1' type='hidden' value='"+alt_id3_no1+"'><input name='alt_id4_no1' id='alt_id4_no1' type='hidden' value='"+alt_id4_no1+"'><input name='First_Name1' id='First_Name1' type='hidden' value='"+First_Name1+"'><input name='Second_Name1' id='Second_Name1' type='hidden' value='"+Second_Name1+"'><input name='Third_Name1' id='Third_Name1' type='hidden' value='"+Third_Name1+"'><input name='Family_Name1' id='Family_Name1' type='hidden' value='"+Family_Name1+"'><input name='first_name_loc_lang1' id='first_name_loc_lang1' type='hidden' value='"+first_name_loc_lang1+"'><input name='second_name_loc_lang1' id='second_name_loc_lang1' type='hidden' value='"+second_name_loc_lang1+"'><input name='third_name_loc_lang1' id='third_name_loc_lang1' type='hidden' value='"+third_name_loc_lang1+"'><input name='family_name_loc_lang1' id='family_name_loc_lang1' type='hidden' value='"+family_name_loc_lang1+"'><input name='pr_resNo1' id='pr_resNo1' type='hidden' value='"+pr_resNo1+"'><input name='oth_no1' id='oth_no1' type='hidden' value='"+oth_no1+"'><input name='search_in' id='search_in' type='hidden' value='"+search_in+"'><input type='hidden' name='func_act' id='func_act' value='"+func_act+"' ><input type='hidden' name='act_yn' id='act_yn' value='"+act_yn+"' ><input type='hidden' name='function_id' id='function_id' value='"+function_id+"'><input name='order_by1' id='order_by1' type='hidden' value='"+order_by1+"'><input name='gender' id='gender' type='hidden' value='"+gender+"'></form></BODY></HTML>";
				parent.Pat_Results_Frame.document.write(HTMLVal);
				parent.commontoolbar.location.href='../../eCommon/jsp/process.jsp';
				parent.Pat_Results_Frame.document.forms[0].submit();
				parent.colurFrame.document.location.href = '../../eMP/jsp/patientsearchcolur.jsp';

			}//End Of   Submision of Basic Form Emlements. if any one of the criteria was  Entered 
				else{
                    alert(getMessage("ANY_ONE_CRITERIA",'Common'));
                    parent.Pat_Results_Frame.location.href="../../eCommon/html/blank.html";
		}//End OF Checking Empty
}//End Of Basic Tab;
			
		/******For Advance Search Tab *************/

	if (document.forms[0].name=="Advnc_Patient_Search_Form"){
		var pat_name_as_multipart_yn =Advnc_Patient_Search_Form.pat_name_as_multipart_yn_hd.value;
		var whereClause="where ";
		var whereClause_dr="where ";
		var whereClause_dr_valid="where ";
		var whereClauseAddlField = "";
		var whereClauseAddlField_dr = "";
		var whereClauseAddlField_dr_valid = "";
		var selectClause="";
		var strand = "";
		var empty = 0;
		var file_no_where = '';
		var old_file_no_where = '';
		var count_sql = "";
		var newBorn_sfx=Advnc_Patient_Search_Form.newborn_suffix;
	     var empty = 0;

var fields = new Array( Advnc_Patient_Search_Form.Patient_Id,
	Advnc_Patient_Search_Form.Alt_Id1_No,
	Advnc_Patient_Search_Form.National_Id_No,
	Advnc_Patient_Search_Form.Family_No,
	Advnc_Patient_Search_Form.MRN,
	Advnc_Patient_Search_Form.First_Name,
	Advnc_Patient_Search_Form.Second_Name,
	Advnc_Patient_Search_Form.Third_Name,
	Advnc_Patient_Search_Form.Family_Name,
	Advnc_Patient_Search_Form.Sex,
	Advnc_Patient_Search_Form.By,
	Advnc_Patient_Search_Form.Dob,
	Advnc_Patient_Search_Form.Mode,
	Advnc_Patient_Search_Form.Contact_No,
	Advnc_Patient_Search_Form.Area,
	Advnc_Patient_Search_Form.Soundex,
	Advnc_Patient_Search_Form.OldFileNo,
	Advnc_Patient_Search_Form.Alt_Id2_No,
	Advnc_Patient_Search_Form.Alt_Id3_No,
	Advnc_Patient_Search_Form.Alt_Id4_No,
	Advnc_Patient_Search_Form.Nationality,
	Advnc_Patient_Search_Form.addl_field1,
	Advnc_Patient_Search_Form.addl_field2,
	Advnc_Patient_Search_Form.addl_field3,
	Advnc_Patient_Search_Form.addl_field4,
	Advnc_Patient_Search_Form.addl_field5,
	Advnc_Patient_Search_Form.ethnic_group,
	Advnc_Patient_Search_Form.other_alt_id,
	Advnc_Patient_Search_Form.other_alt_Id_no,
	Advnc_Patient_Search_Form.sltDocType,
	Advnc_Patient_Search_Form.txtDocType,
	Advnc_Patient_Search_Form.family_org_membership,  
	Advnc_Patient_Search_Form.organization,
	Advnc_Patient_Search_Form.sub_organization,
	Advnc_Patient_Search_Form.mother_maiden_name,
	Advnc_Patient_Search_Form.first_name_loc_lang,
	Advnc_Patient_Search_Form.second_name_loc_lang,
	Advnc_Patient_Search_Form.third_name_loc_lang,
	Advnc_Patient_Search_Form.family_name_loc_lang,
	Advnc_Patient_Search_Form.deceased_yn,
	Advnc_Patient_Search_Form.suspend_yn,
	Advnc_Patient_Search_Form.active_yn,
	Advnc_Patient_Search_Form.reg_mode,
	Advnc_Patient_Search_Form.IP_yn,
	Advnc_Patient_Search_Form.DC_yn,
	Advnc_Patient_Search_Form.OP_yn,
	Advnc_Patient_Search_Form.EM_yn,
	Advnc_Patient_Search_Form.patient_series);
	for(var i=0;i<fields.length;i++) {
		if (i==10 || i==15){
		}else if ( (fields[i] != null) && (fields[i].name != 'undefined') && (fields[i].name != undefined) ){
			 if ((fields[i].name).indexOf("_yn") !=-1){
				 if ( fields[i].checked==true )
				 {
					 empty++;
				 }
			}else if (trimCheck(fields[i].value)){
				empty++;
			}
		}
	}
	if(empty != 0){
		var pat_id_len = document.forms[0].Patient_Id.maxLength;
		var pat_id_val = document.forms[0].Patient_Id.value;
		var usePatIDIndex = "N";	
		parent.colurFrame.document.location.href = '../../eMP/jsp/patientsearchcolur.jsp';
		if (((parseInt(pat_id_val.length) / parseInt(pat_id_len))*100) > 60)
		usePatIDIndex = "Y";
		if (document.forms[0].order_by.value != "")
		ord = document.forms[0].order_by.value;

		var dob_field;
		var arr;
		var strdate;
		var dateFrom;
		var dateTo;		 
		  if( fields[10] && fields[11] && trimCheck(fields[10].value)&& trimCheck(fields[11].value)) {
				if(fields[10].value == "D")  {
					 dob_field=fields[11].value;
					if(fields[11].value != "" && fields[11].value !=  null)
					{
						if(localeName != 'en')
						{
							dob_field=convertDate(fields[11].value,"DMY",localeName,"en");
						}
					}
					dob_field=	trimString(dob_field);
					
				}
				else 
				{
					 arr			=	 new Array();
					 strdate	= fields[11].value ;
					if ( fields[11].value != null && fields[11].value != "" )
					{
						if(localeName != 'en')
						{
							strdate=convertDate(fields[11].value,"DMY",localeName,"en");
						}
					}
					arr = strdate.split("/");
					 dateFrom		= '01/01/'+arr[2];
					 dateTo		= '31/12/'+arr[2];
				}
			}
			parent.commontoolbar.location.href='../../eCommon/jsp/process.jsp';
			parent.Pat_Search_Toolbar_Frame.defaultSetting();
			var hiddenVals   = " <html> <head><META HTTP-EQUIV='Content-Type' CONTENT='text/html;charset=UTF-8'></head> \n"
			var mode="";
			var search_in			 = Advnc_Patient_Search_Form.search_in.value;
			var win_top				= Advnc_Patient_Search_Form.cr_win_top.value;
			var win_width			= Advnc_Patient_Search_Form.cr_win_width.value;
			var win_height			= Advnc_Patient_Search_Form.cr_win_height.value;
//			var act_yn				= Advnc_Patient_Search_Form.cr_act_yn.value;
			var srr						= Advnc_Patient_Search_Form.cr_srr.value;
//			var function_id			= Advnc_Patient_Search_Form.cr_function_id.value;
			var cnt						= Advnc_Patient_Search_Form.cntPrefFac.value;
			var jsp_name 			= Advnc_Patient_Search_Form.jsp_name.value;
			var enablegenderyn	= Advnc_Patient_Search_Form.cr_enablegenderyn.value;
			var allow_nb_review	= Advnc_Patient_Search_Form.allow_nb_review.value;
			var patient_id_length	= Advnc_Patient_Search_Form.patient_id_length.value;
					   
				hiddenVals   += " <body onKeyDown='lockKey()'> <form name='tempform' id='tempform' method='post' action='../../eMP/jsp/DupPatientIDDisplay.jsp'> \n" ; 
				hiddenVals   += " <input type='hidden' name='function_id' id='function_id' value=\""+function_id+"\" > \n" ;

				hiddenVals   += " <input type='hidden' name='search_in' id='search_in' value=\""+search_in+"\" > \n" ; 
//				hiddenVals   += " <input type='hidden' name='cntPrefFac' id='cntPrefFac' value=\""+cnt+"\" > \n" ; 
				hiddenVals   += " <input type='hidden' name='usePatIDIndex' id='usePatIDIndex' value=\""+usePatIDIndex+"\" > \n" ; 

				hiddenVals   += " <input type='hidden' name='enablegenderyn' id='enablegenderyn' value=\""+enablegenderyn+"\" > \n" ;
				hiddenVals   += " <input type='hidden' name='mode' id='mode' value=\""+mode+"\" > \n" ; 
				hiddenVals   += " <input type='hidden' name='p_no' id='p_no' value=\""+fields[0].value+"\" > \n" ; 
				//						hiddenVals   += " <input type='hidden' name='countSQL' id='countSQL' value=\""+countSQLstr+"\" > \n" ; 
				hiddenVals   += " <input type='hidden' name='orderby' id='orderby' value=\""+ord+"\" > \n" ; 
				hiddenVals   += " <input type='hidden' name='Hit_Limit' id='Hit_Limit' value=\""+HitLimit+"\" > \n" ; 
				hiddenVals   += " <input type='hidden' name='jsp_name' id='jsp_name' value=\""+jsp_name+"\" > \n" ; 
//										hiddenVals   += " <input type='hidden' name='na_no' id='na_no' value=\""+na_no+"\" > \n" ; 
				hiddenVals   += " <input type='hidden' name='win_top' id='win_top' value=\""+win_top+"\" > \n" ; 
				hiddenVals   += " <input type='hidden' name='win_width' id='win_width' value=\""+win_width+"\" > \n" ; 
				hiddenVals   += " <input type='hidden' name='win_height' id='win_height' value=\""+win_height+"\" > \n" ; 
				hiddenVals   += " <input type='hidden' name='act_yn' id='act_yn' value=\""+act_yn+"\" > \n" ; 
				hiddenVals   += " <input type='hidden' name='srr' id='srr' value=\""+srr+"\" > \n" ; 
				hiddenVals   += " <input type='hidden' name='func_act' id='func_act' value=\""+func_act+"\" > \n" ; 
				hiddenVals   += " <input type='hidden' name='file_no_where' id='file_no_where' value=\""+file_no_where+"\" > \n" ; 
				hiddenVals   += " <input type='hidden' name=\""+old_file_no_where+"\" id=\""+old_file_no_where+"\" value=\""+old_file_no_where+"\" > \n" ; 
				hiddenVals   += " <input type='hidden' name='order_by' id='order_by' value=\""+ord+"\" > \n" ; 


				 if( fields[0] && fields[0].value != null && fields[1].value != "")
				hiddenVals   += " <input type='hidden' name='p_no' id='p_no' value=\""+fields[0].value+"\" > \n" ; 
				if( fields[1] && fields[1].value != null && fields[1].value != "")
				hiddenVals   += " <input type='hidden' name='Alt_Id1_No' id='Alt_Id1_No' value=\""+fields[1].value+"\" > \n" ; 
				if( fields[2] && fields[2].value != null && fields[2].value != "")
				hiddenVals   += " <input type='hidden' name='National_Id_No' id='National_Id_No' value=\""+fields[2].value+"\" > \n" ; 
				if( fields[3] && fields[3].value != null && fields[3].value != "")
				hiddenVals   += " <input type='hidden' name='Family_No' id='Family_No' value=\""+fields[3].value+"\" > \n" ; 
				if( fields[4] && fields[4].value != null && fields[4].value != "")
				hiddenVals   += " <input type='hidden' name='MRN' id='MRN' value=\""+fields[4].value+"\" > \n" ; 
				if( fields[5] && fields[5].value != null && fields[5].value != "")
				hiddenVals   += " <input type='hidden' name='First_Name' id='First_Name' value=\""+fields[5].value+"\" > \n" ; 
				if( fields[6] && fields[6].value != null && fields[6].value != "")
				hiddenVals   += " <input type='hidden' name='Second_Name' id='Second_Name' value=\""+fields[6].value+"\" > \n" ; 
				if( fields[7] && fields[7].value != null && fields[7].value != "")
				hiddenVals   += " <input type='hidden' name='Third_Name' id='Third_Name' value=\""+fields[7].value+"\" > \n" ; 
				if( fields[8] && fields[8].value != null && fields[8].value != "")
				hiddenVals   += " <input type='hidden' name='Family_Name' id='Family_Name' value=\""+fields[8].value+"\" > \n" ; 
				if( fields[9] && fields[9].value != null && fields[9].value != "")
				hiddenVals   += " <input type='hidden' name='Sex' id='Sex' value=\""+fields[9].value+"\" > \n" ; 
				if( fields[10] && fields[10].value != null && fields[10].value != "")
				hiddenVals   += " <input type='hidden' name='By' id='By' value=\""+fields[10].value+"\" > \n" ; 
				if (dob_field!=null&&dob_field!="")
				{
				hiddenVals   += " <input type='hidden' name='DATE' id='DATE' value=\""+dob_field+"\" > \n" ; 
				}
				if (dateFrom!=""&&dateTo!="")
				{
				hiddenVals   += " <input type='hidden' name='FromDate' id='FromDate' value=\""+dateFrom+"\" > \n" ; 
				hiddenVals   += " <input type='hidden' name='ToDate' id='ToDate' value=\""+dateTo+"\" > \n" ; 
				}

				if( fields[11] && fields[11].value != null && fields[11].value != "")
				hiddenVals   += " <input type='hidden' name='Dob' id='Dob' value=\""+fields[11].value+"\" > \n" ; 
				if( fields[12] && fields[12].value != null && fields[12].value != "")
				hiddenVals   += " <input type='hidden' name='Mode' id='Mode' value=\""+fields[12].value+"\" > \n" ; 
				if( fields[13] && fields[13].value != null && fields[13].value != "")
				hiddenVals   += " <input type='hidden' name='Contact_No' id='Contact_No' value=\""+fields[13].value+"\" > \n" ; 
				if( fields[14] && fields[14].value != null && fields[14].value != "")
				hiddenVals   += " <input type='hidden' name='Area' id='Area' value=\""+fields[14].value+"\" > \n" ; 
				if( fields[15] && fields[15].value != null && fields[15].value != "")
				hiddenVals   += " <input type='hidden' name='Soundex' id='Soundex' value=\""+fields[15].value+"\" > \n" ; 

				if(fields[16] && fields[16].value != null && fields[16].value != "")
				hiddenVals   += " <input type='hidden' name='OldFileNo' id='OldFileNo' value=\""+fields[16].value+"\" > \n" ; 

				if( fields[17] && fields[17].value != null && fields[17].value != "")
				hiddenVals   += " <input type='hidden' name='Alt_Id2_No' id='Alt_Id2_No' value=\""+fields[17].value+"\" > \n" ; 

				if(fields[18] && fields[18].value != null && fields[18].value != "")
				hiddenVals   += " <input type='hidden' name='Alt_Id3_No' id='Alt_Id3_No' value=\""+fields[18].value+"\" > \n" ; 
				if(fields[19] && fields[19].value != null && fields[19].value != "")
				hiddenVals   += " <input type='hidden' name='Alt_Id4_No' id='Alt_Id4_No' value=\""+fields[19].value+"\" > \n" ; 
				if(fields[20] && fields[20].value != null && fields[20].value != "")
				hiddenVals   += " <input type='hidden' name='Nationality' id='Nationality' value=\""+fields[20].value+"\" > \n" ; 
				if(fields[21] && fields[21].value != null && fields[21].value != "")
				hiddenVals   += " <input type='hidden' name='addl_field1' id='addl_field1' value=\""+fields[21].value+"\" > \n" ; 
				if(fields[22] && fields[22].value != null && fields[22].value != "")
				hiddenVals   += " <input type='hidden' name='addl_field2' id='addl_field2' value=\""+fields[22].value+"\" > \n" ; 
				if(fields[23] && fields[23].value != null && fields[23].value != "")
				hiddenVals   += " <input type='hidden' name='addl_field3' id='addl_field3' value=\""+fields[23].value+"\" > \n" ; 

				if(fields[24] && fields[24].value != null && fields[24].value != "")
				hiddenVals   += " <input type='hidden' name='addl_field4' id='addl_field4' value=\""+fields[24].value+"\" > \n" ; 
				if(fields[25] && fields[25].value != null && fields[25].value != "")
				hiddenVals   += " <input type='hidden' name='addl_field5' id='addl_field5' value=\""+fields[25].value+"\" > \n" ; 
				if(fields[26] && fields[26].value != null && fields[26].value != "")
				hiddenVals   += " <input type='hidden' name='ethnic_group' id='ethnic_group' value=\""+fields[26].value+"\" > \n" ; 

				if(fields[27] && fields[27].value != null && fields[27].value != "")
				hiddenVals   += " <input type='hidden' name='other_alt_id' id='other_alt_id' value=\""+fields[27].value+"\" > \n" ; 
				if(fields[28] && fields[28].value != null && fields[28].value != "")
				hiddenVals   += " <input type='hidden' name='other_alt_Id_no' id='other_alt_Id_no' value=\""+fields[28].value+"\" > \n" ; 
				if(fields[29] && fields[29].value != null && fields[29].value != "")
				hiddenVals   += " <input type='hidden' name='sltDocType' id='sltDocType' value=\""+fields[29].value+"\" > \n" ; 

				if(fields[30] && fields[30].value != null && fields[30].value != "")
				hiddenVals   += " <input type='hidden' name='txtDocType' id='txtDocType' value=\""+fields[30].value+"\" > \n" ; 
				if(fields[31] && fields[31].value != null && fields[31].value != "")
				hiddenVals   += " <input type='hidden' name='family_org_membership' id='family_org_membership' value=\""+fields[31].value+"\" > \n" ; 
				if(fields[32] && fields[32].value != null && fields[32].value != "")
				hiddenVals   += " <input type='hidden' name='organization' id='organization' value=\""+fields[32].value+"\" > \n" ; 

				if(fields[33] && fields[33].value != null && fields[33].value != "")
				hiddenVals   += " <input type='hidden' name='sub_organization' id='sub_organization' value=\""+fields[33].value+"\" > \n" ; 
				if(fields[34] && fields[34].value != null && fields[34].value != "")
				hiddenVals   += " <input type='hidden' name='mother_maiden_name' id='mother_maiden_name' value=\""+fields[34].value+"\" > \n" ; 
				if(fields[35] && fields[35].value != null && fields[35].value != "")
				hiddenVals   += " <input type='hidden' name='first_name_loc_lang' id='first_name_loc_lang' value=\""+fields[35].value+"\" > \n" ; 

				if(fields[36] && fields[36].value != null && fields[36].value != "")
				hiddenVals   += " <input type='hidden' name='second_name_loc_lang' id='second_name_loc_lang' value=\""+fields[36].value+"\" > \n" ; 
				if(fields[37] && fields[37].value != null && fields[37].value != "")
				hiddenVals   += " <input type='hidden' name='third_name_loc_lang' id='third_name_loc_lang' value=\""+fields[37].value+"\" > \n" ; 
				if(fields[38] && fields[38].value != null && fields[38].value != "")
				hiddenVals   += " <input type='hidden' name='family_name_loc_lang' id='family_name_loc_lang' value=\""+fields[38].value+"\" > \n" ; 

				if(fields[39] &&fields[39].checked==true){
					hiddenVals   += " <input type='hidden' name='deceased_yn' id='deceased_yn' value=Y> \n" ; 
				}
				if(fields[40] &&fields[40].checked==true){
					hiddenVals   += " <input type='hidden' name='suspend_yn' id='suspend_yn' value=Y> \n" ; 
				}
				if(fields[41] && fields[41].checked==true){
				hiddenVals   += " <input type='hidden' name='active_yn' id='active_yn' value=Y> \n" ; 
				}

				if(fields[42] && fields[42].value != null && fields[42].value != "")
				hiddenVals   += " <input type='hidden' name='reg_mode' id='reg_mode' value=\""+fields[42].value+"\" > \n" ; 
				if(fields[43] && fields[43].value != null && fields[43].checked==true)
				hiddenVals   += " <input type='hidden' name='IP_yn' id='IP_yn' value=IP> \n" ; 
				if(fields[44] && fields[44].value != null && fields[44].checked==true)
				hiddenVals   += " <input type='hidden' name='DC_yn' id='DC_yn' value=DC> \n" ; 

				if(fields[45] && fields[45].value != null && fields[45].checked==true)
				hiddenVals   += " <input type='hidden' name='OP_yn' id='OP_yn' value=OP> \n" ; 
				if(fields[46] && fields[46].value != null && fields[46].checked==true)
				hiddenVals   += " <input type='hidden' name='EM_yn' id='EM_yn' value=EM > \n" ; 
				if(fields[47] && fields[47].value != null && fields[47].value != "")
				hiddenVals   += " <input type='hidden' name='patient_series' id='patient_series' value=\""+fields[47].value+"\" > \n" ; 
				if(Advnc_Patient_Search_Form.newborn_suffix && trimCheck(Advnc_Patient_Search_Form.newborn_suffix.value))
				hiddenVals   += " <input type='hidden' name='newBorn_sufx' id='newBorn_sufx' value=\""+Advnc_Patient_Search_Form.newborn_suffix.value+"\" > \n" ; 
				 if(Advnc_Patient_Search_Form.org_id && trimCheck(Advnc_Patient_Search_Form.org_id.value))
				hiddenVals   += " <input type='hidden' name='Orgnization_id' id='Orgnization_id' value=\""+Advnc_Patient_Search_Form.org_id.value+"\" > \n" ; 
				if(Advnc_Patient_Search_Form.sub_organization && trimCheck(Advnc_Patient_Search_Form.sub_organization.value))
				hiddenVals   += " <input type='hidden' name='sub_Organisation' id='sub_Organisation' value=\""+Advnc_Patient_Search_Form.sub_organization.value+"\" > \n" ; 
				if(Advnc_Patient_Search_Form.allow_nb_review && trimCheck(Advnc_Patient_Search_Form.allow_nb_review.value))
				hiddenVals   += " <input type='hidden' name='allow_nb_review' id='allow_nb_review' value=\""+Advnc_Patient_Search_Form.allow_nb_review.value+"\" > \n" ; 
				if(Advnc_Patient_Search_Form.patient_id_length && trimCheck(Advnc_Patient_Search_Form.patient_id_length.value))
				hiddenVals   += " <input type='hidden' name='patient_id_length' id='patient_id_length' value=\""+Advnc_Patient_Search_Form.patient_id_length.value+"\" > \n" ; 


				if(document.forms[0].apply_oth_name )
					if(document.forms[0].apply_oth_name.checked )
						hiddenVals   += " <input type='hidden' name='apply_oth_name' id='apply_oth_name' value='y' > \n" ;

				hiddenVals   += " </form></body></html> \n" ; 
				//parent.Pat_Results_Frame.document.body.insertAdjacentHTML('afterbegin',hiddenVals);
			   parent.Pat_Results_Frame.document.write(hiddenVals);
				for (var i=0;i<document.forms[0].elements.length;i++){
					document.forms[0].elements[i].disabled=true;
				}
			
				if (parent.Pat_Search_Toolbar_Frame.document.forms[0].register){
				parent.Pat_Search_Toolbar_Frame.document.forms[0].register.disabled = true;
				}
				if (parent.Pat_Search_Toolbar_Frame.document.forms[0].register1){
				parent.Pat_Search_Toolbar_Frame.document.forms[0].register1.disabled = true;
				}

				parent.Pat_Search_Toolbar_Frame.document.forms[0].Search.focus();
				parent.Pat_Search_Toolbar_Frame.document.forms[0].Search.disabled = true;
//				parent.frames[0].location.href='../../eCommon/html/process.html';
	//						parent.commontoolbar.location.href='../jsp/DupPatientSearchToolBar.jsp'						
	//						parent.Pat_Search_Toolbar_Frame.defaultSetting();
	//						parent.commontoolbar.location.href='../jsp/DupPatientSearchToolBar.jsp'						

				morelessHidden();
				parent.patsearch.document.getElementById('pat_search').rows="20,25,330,20,*";
				parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Moreless.value=getLabel('Common.morecriteria.label','common');
				parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.morelessexpand.value="Y";
				parent.Pat_Results_Frame.document.forms[0].submit();
					
		}//End OF Checking ;
			else {
						flag=false; 
						morelessHidden();
						parent.patsearch.document.getElementById('pat_search').rows="20,25,330,20,*";
						parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Moreless.value=getLabel('Common.morecriteria.label','common');
						parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.morelessexpand.value="Y";

						alert(getMessage("ANY_ONE_CRITERIA",'Common'));
						DefaultSelect('<%=Soundex%>');
						parent.Pat_Search_Toolbar_Frame.defaultSetting();
						parent.Pat_Results_Frame.location.href="../../eCommon/html/blank.html";
		}//End Of Checking for Empty
	}//End oF The Advance Tab 
}//End Of the Function searchForRslt;


/****Posting To Result Page Ends***********/

/*****These are the Functons which work For Advance Search *****************/

/**More Or Less Criteria Logic ***/
function MoreLess(){
//	alert(parent.Pat_Search_Criteria_Frame.document.forms[0].name)
	if(parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.morelessexpand.value=="Y"){
	parent.patsearch.document.getElementById('pat_search').rows="20,25,500,20,*";
	parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Moreless.value=getLabel('Common.lesscriteria.label','common');
	morelessVisible();
	parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.morelessexpand.value="N";
	}
	else if(parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.morelessexpand.value=="N"){
		parent.patsearch.document.getElementById('pat_search').rows="20,25,330,20,*";
		morelessHidden();
		parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Moreless.value=getLabel('Common.morecriteria.label','common');
		parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.morelessexpand.value="Y";
	}
}

function morelessVisible(){
parent.Pat_Search_Criteria_Frame.document.getElementById("rowExpansion").style.display="block";
}
function morelessHidden(){
parent.Pat_Search_Criteria_Frame.document.getElementById("rowExpansion").style.display="none";
}
/*****Ends******/


/***These Functions Are Called From  Result Page**** /
/**Function For Previous Next Arrows**/
  function displayNextSet(mode)
            {
				maxDisplay = parseInt(parent.Pat_Results_Frame.document.forms[0].maxdisplay.value);
                maxDisplay1 = parseInt(parent.Pat_Results_Frame.document.forms[0].maxdisplay1.value);
                searchthreshold = parseInt(parent.Pat_Results_Frame.document.forms[0].searchthreshold.value);
//             alert("maxDisplay=>"+maxDisplay+"==maxDisplay1=="+maxDisplay1)
				if (mode=="next")
                {
                    b = maxDisplay1 - 4;
                    maxDisplay2 = maxDisplay1+1;                
                }
                else
                {
                    maxDisplay2 = maxDisplay1-1;
                    b = maxDisplay1 - 5-1;
                }
                noofRec = 0;
                display_anchors = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
                if (maxDisplay2 != maxDisplay+1)
                {
                    for ( i = b;i<maxDisplay2;i++) {
                            noofRec1 =parseInt(noofRec) + (searchthreshold*(i+1));
                            display_anchors += "<b><a name='str"+noofRec1+"' href='javascript:parent.Pat_Search_Criteria_Frame.passURL("+noofRec1+")'>"+(i+1)+"</a></b>";
                            display_anchors += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
                    }
                    parent.Pat_Search_Toolbar_Frame.document.getElementById('disprec').innerHTML=display_anchors;
                    parent.Pat_Results_Frame.document.forms[0].maxdisplay1.value = maxDisplay2;       
                    parent.Pat_Search_Toolbar_Frame.document.forms[0].prev.disabled = false;
                }
                if (mode=="prev")
                {
                    if (maxDisplay2 != maxDisplay)         
                    {
                        if (parent.Pat_Search_Toolbar_Frame.document.forms[0].next.disabled == true)
                            parent.Pat_Search_Toolbar_Frame.document.forms[0].next.disabled = false;
                    }
                    if (b==0) parent.Pat_Search_Toolbar_Frame.document.forms[0].prev.disabled = true;
                }
                if (mode=="next")
                {
                    if (maxDisplay2!=maxDisplay) {}
                    else
                    {
                        parent.Pat_Search_Toolbar_Frame.document.forms[0].next.disabled = true;                     
                        parent.Pat_Results_Frame.document.forms[0].maxdisplay1.value = maxDisplay2;
                    }
                }
            }
/****Function For Result Page NavigatieNmbers*****/
  function passURL(bttn) {
                for (var i=0;i<document.forms[0].elements.length;i++)
				{
					document.forms[0].elements[i].disabled=true;
				}				
				
				parent.Pat_Search_Toolbar_Frame.document.forms[0].Search.disabled = true;
				if (parent.Pat_Search_Toolbar_Frame.document.forms[0].register)
					parent.Pat_Search_Toolbar_Frame.document.forms[0].register.disabled = true;
				parent.commontoolbar.location.href='../../eCommon/jsp/process.jsp';
				parent.parent.Pat_Results_Frame.location.href="../../eCommon/html/blank.html";
//				parent.Pat_Results_Frame.Pat_Search_Criteria_Frame.location.href="../../eCommon/html/blank.html";
				parent.Pat_Search_Toolbar_Frame.document.getElementById('disprec').style.visibility='hidden';		
				parent.parent.Pat_Search_Toolbar_Frame.document.forms[0].prev.style.visibility = 'hidden';
                parent.parent.Pat_Search_Toolbar_Frame.document.forms[0].next.style.visibility = 'hidden';
				if (parent.Pat_Results_Frame.document.forms[0])
				{
					fromval=parseInt(parent.Pat_Results_Frame.document.forms[0].From.value,10);
					toval=parseInt(parent.Pat_Results_Frame.document.forms[0].To.value,10); 
					var allow=true;
					fromval = bttn - toval+fromval;
					toval = bttn;
					var ordby=parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.ORDERBY.value;
					var mode = "Y";

					maxDisplay = parseInt(parent.Pat_Results_Frame.document.forms[0].maxdisplay.value); 
					maxDisplay1 = parseInt(parent.Pat_Results_Frame.document.forms[0].maxdisplay1.value);
					

					var replace_url1     =   "%";
					var whereClause=parent.parent.Pat_Results_Frame.document.forms[0].final_whereClause.value;
					whereClause=whereClause.replace(replace_url1,"^");
					search_in   = parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.search_in.value;
					//Added by kumar on 8/3/2002 for checking whether national id is displayed or not
					var na_no = "";
					if (parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.National_Id_No.type=='text')
						na_no = parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.National_Id_No.value;
					else
						na_no = "";
					
					var function_id = parent.Pat_Search_Criteria_Frame.document.forms[0].cr_function_id.value;
					 
					if (allow){
						parent.Pat_Results_Frame.document.forms[0].maxdisplay.value = maxDisplay;
						parent.Pat_Results_Frame.document.forms[0].maxdisplay1.value = maxDisplay1;
						parent.Pat_Results_Frame.document.forms[0].From.value = fromval;
						parent.Pat_Results_Frame.document.forms[0].To.value = toval;
						parent.Pat_Results_Frame.document.forms[0].mode.value = mode;
						parent.Pat_Results_Frame.document.forms[0].order_by.value = ordby;
//						parent.Pat_Results_Frame.PatIdResult.document.forms[0].final_whereClause.value = whereClause;
						parent.Pat_Results_Frame.document.forms[0].method = "post";
						parent.Pat_Results_Frame.document.forms[0].action = "../../eMP/jsp/DupPatientIDDisplay.jsp?PagewhereClause="+whereClause+"&Pageflag=Y";
						parent.Pat_Results_Frame.document.forms[0].target = parent.Pat_Results_Frame.name;
						parent.Pat_Results_Frame.document.forms[0].submit();
					}
				}
            }
/************Ends****************/

/**Result Page CallFunctions***End*****/

/*All LookUp Funtions Declaratios Starts  */
async function getNationality(obj)
{
	
	var desc = document.forms[0].nationality_desc_hid;
	var code = document.forms[0].Nationality_hid;
	var nationality_code = document.forms[0].Nationality;
	var nationality_desc = document.forms[0].nationality_desc;
	var locale= document.forms[0].locale.value;
	if ( (desc.value==nationality_desc.value) && (code.value==nationality_code.value) && (desc.value!='') )
	{
		return;
	}
	
	if ( ( obj.type=='text') && (obj.value=='') )
	{
		return;
	}
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";
	tit=getLabel("Common.nationality.label","common");
	sql="Select country_code code,long_desc description from mp_country_lang_vw where eff_status = 'E' and language_id = '"+locale+"' and  upper(country_code) like upper(?) and upper(long_desc) like upper(?)";
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = nationality_desc.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( tit, argumentArray );
	if (retVal=='' || retVal==null)
	{
		 nationality_code.value = ''; 
		 nationality_desc.value = ''; 
	}
	else
	{
		nationality_code.value = retVal[0]; 
		nationality_desc.value = retVal[1]; 
		desc.value=retVal[1];
		code.value=retVal[0];
	}
}
async function getArea(obj)
{
	var desc = document.forms[0].area_desc_hid;
	var code = document.forms[0].Area_hid;
	var area_desc = document.forms[0].area_desc;
	var area_code = document.forms[0].Area;
	var locale= document.forms[0].locale.value;
	if ( (desc.value==area_desc.value) && (code.value==area_code.value) && (desc.value!='')  )
	{
		return;
	}
	if  ( ( obj.type=='text') && (obj.value=='') ) 
	{
		return;
	}
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";
	tit=getLabel("Common.area.label","common");
	sql="Select res_area_code code,long_desc description from mp_res_area_lang_vw where eff_status='E'  and language_id = '"+locale+"' and upper(res_area_code) like upper(?) and upper(short_desc) like upper(?)";
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = area_desc.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( tit, argumentArray );
	
	var ret1=unescape(retVal);
		 	arr=ret1.split(",");
			if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if (retVal=='' || retVal==null)
	{
		area_desc.value='';
		area_code.value='';
	}
	else
	{
		/*area_desc.value=retVal[1];
		area_code.value=retVal[0];
		desc.value=retVal[1];
		code.value=retVal[0];*/
		area_code.value = arr[0]; 
		area_desc.value = arr[1]; 
		desc.value=arr[1];
		code.value=arr[0];
	}
}

async function getRace(obj)
{
	var desc = document.forms[0].ethnic_group_desc_hid;
	var code = document.forms[0].ethnic_group_hid;
	var ethnic_group_desc = document.forms[0].ethnic_group_desc;
	var ethnic_group = document.forms[0].ethnic_group;
		var locale= document.forms[0].locale.value;


	if ( (desc.value==ethnic_group_desc.value) && (code.value==ethnic_group.value) && (desc.value!='')   )
	{
		return;
	}

	if ( ( obj.type=='text') && (obj.value=='') )
	{
		return;
	}

	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";
	tit=getLabel("Common.race.label","common");
	sql="select race_code code,initcap(long_desc) description from  mp_race_lang_vw where EFF_STATUS='E' and language_id = '"+locale+"' and upper(race_code) like upper(?) and upper(long_desc) like upper(?)";
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = ethnic_group_desc.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( tit, argumentArray );
	if (retVal=='' || retVal==null)
	{
		ethnic_group_desc.value='';
		ethnic_group.value='';
	}
	else
	{
		ethnic_group_desc.value=retVal[1];
		ethnic_group.value=retVal[0];
		desc.value=retVal[1];
		code.value=retVal[0];
	}
}
async function get_org_sub_org(organization,sub_organization,obj)
{
	parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.sub_org_desc.value = '';
	parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.sub_organization.value = '';

	var organization_hid = document.forms[0].organization_hid;
		var locale= document.forms[0].locale.value;
	if ( (organization.value==organization_hid.value) &&  (obj.type=='text') )
	{
		return;
	}

	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";				
	
	tit=getLabel("Common.Organization.label","Common");
	sql="select family_org_id code, family_org_name description from MP_FAMILY_ORG_LANG_VW where   language_id = '"+locale+"' AND upper(family_org_id) like upper(?) and upper(family_org_name) like upper(?)";
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = organization.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );
	if(!(retVal== null && retVal== "" ))
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		var org_id = arr[0];
		parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.org_id.value = org_id;
		organization.value = arr[1];
		organization_hid.value = arr[1];
		HTMLVal = "<html><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/DupPatCatOrgMbspValidation.jsp'><input type='hidden' name='organization' id='organization' value='"+org_id+"'><input type='hidden' name='param' id='param' value='PATSEARCH'></form></BODY></HTML>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.messageFrame.document.form1.submit();
	}
	if(retVal==null || retVal=="")
	{
		organization.value='';
		organization.focus();
	}
}

async function get_sub_org(sub_org_desc)
{
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var locale=document.forms[0].locale.value;
	var org_id = parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.org_id.value
	var tit="";	
	
	tit=getLabel("eMP.suborgn.label","MP");

	//sql="select family_org_id code, family_org_name description from MP_FAMILY_ORG_lang_vw where language_id='"+locale+"' and eff_status = 'E' and upper(family_org_id) like upper(?) and upper(family_org_name) like upper(?)";

	sql="select FAMILY_ORG_SUB_ID code, FAMILY_ORG_SUB_NAME description from MP_FAMILY_ORG_SUB_LANG_VW where language_id='"+locale+"' and EFF_STATUS = 'E' and upper(FAMILY_ORG_SUB_ID) like upper(?) and upper(FAMILY_ORG_SUB_NAME) like upper(?)";

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = sub_org_desc.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );
	if(!(retVal== null && retVal== "" ))
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		var sub_org_id = arr[0];
		parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.sub_organization.value = sub_org_id;
		sub_org_desc.value=arr[1];		
	}
	if(retVal==null || retVal=="")
	{
		sub_org_desc.value='';
		sub_org_desc.focus();
	}
}
/******************Ends******************************/

/*Functions For Buttons Register,Emergency Register etc*/
function passValues(func_act){

	var FormName;
	var desc;
    if(func_act=='EMERG')
		desc='../../eMP/jsp/PaintEmergRegn.jsp?';
    else if(func_act=='RPDRG')
		desc='../../eMP/jsp/PaintRapidRegn.jsp?';
    else
		desc='../../eMP/jsp/PatRegLoad.jsp?';                             

	if (parent.Pat_Search_Criteria_Frame.document.forms[0].apply_oth_name)
		if (parent.Pat_Search_Criteria_Frame.document.forms[0].apply_oth_name.checked)
			desc+="apply_oth_name=Y&";
		else
			desc+="apply_oth_name=N&";
	if(parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form){
			FormName=parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form;
		//for Advanced Tab
		if(FormName.First_Name){
		 var FirstName=FormName.First_Name.value;
		 desc+="First_Name="+escape(FirstName)+"&";
		}   
		if(FormName.Second_Name){
		var SecondName=FormName.Second_Name.value;   
		desc+="Second_Name="+escape(SecondName)+"&";
		}                              
		if(FormName.Third_Name){
		var ThirdName=FormName.Third_Name.value; 
		desc+="Third_Name="+escape(ThirdName)+"&";
		}
		if(FormName.Family_Name){
		 var FamilyName=FormName.Family_Name.value;  
		 desc+="Family_Name="+escape(FamilyName)+"&";
		}

		if(FormName.Alt_Id1_No){
		  var AltIdNo=FormName.Alt_Id1_No.value; 
		  desc+="Alt_Id_No="+escape(AltIdNo)+"&";
		}
		if(FormName.Alt_Id2_No){
		  var AltId2No=FormName.Alt_Id2_No.value; 
		  desc+="Alt_Id2_No="+escape(AltId2No)+"&";
		}
		if(FormName.Alt_Id3_No){
		  var AltId3No=FormName.Alt_Id3_No.value; 
		  desc+="Alt_Id3_No="+escape(AltId3No)+"&";
		}
		if(FormName.Alt_Id4_No){
		  var AltId4No=FormName.Alt_Id4_No.value; 
		  desc+="Alt_Id4_No="+escape(AltId4No)+"&";
		}
		if(FormName.National_Id_No){
		var NationalIdNo=FormName.National_Id_No.value;   
		desc+="National_Id_No="+escape(NationalIdNo)+"&";
		}
		if(FormName.MRN){
		var MRN=FormName.MRN.value;  
		desc+="MRN="+escape(MRN)+"&";
		}
		if(FormName.Dob){
		var Dob=FormName.Dob.value;  
		desc+="Dob="+Dob+"&";
		}
		if(FormName.Sex){
		var Sex=FormName.Sex.value;  
		 desc+="Sex="+Sex+"&";
		}
		if(FormName.Area){
		var Area=FormName.Area.value;    
		desc+="Area="+escape(Area)+"&";
		}
		if(FormName.Family_No){
		var FamilyNo=FormName.Family_No.value;                 
		 desc+="Family_No="+escape(FamilyNo)+"&";
		}
		if(FormName.OldFileNo){
		var OldFileNo=FormName.OldFileNo.value;  
		 desc+="OldFileNo="+escape(OldFileNo)+"&";
		}

		if(FormName.first_name_loc_lang){
		var first_name_loc_lang=FormName.first_name_loc_lang.value;  
		 desc+="first_name_loc_lang="+encodeURIComponent(first_name_loc_lang)+"&";
		}
		if(FormName.second_name_loc_lang){
		var second_name_loc_lang=FormName.second_name_loc_lang.value;  
		 desc+="second_name_loc_lang="+encodeURIComponent(second_name_loc_lang)+"&";
		}
		if(FormName.third_name_loc_lang){
		var third_name_loc_lang=FormName.third_name_loc_lang.value;  
		 desc+="third_name_loc_lang="+encodeURIComponent(third_name_loc_lang)+"&";
		}
		if(FormName.family_name_loc_lang){
		var family_name_loc_lang=FormName.family_name_loc_lang.value;  
		 desc+="family_name_loc_lang="+encodeURIComponent(family_name_loc_lang);
		}
	}else if (parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form){
		//Basic Tab
		FormName=parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form;
		if(FormName.First_Name1){
		 var FirstName1=FormName.First_Name1.value;
		 desc+="First_Name="+escape(FirstName1)+"&";
		}   
		if(FormName.Second_Name1){
		var SecondName1=FormName.Second_Name1.value;   
		desc+="Second_Name="+escape(SecondName1)+"&";
		}                              
		if(FormName.Third_Name1){
		var ThirdName1=FormName.Third_Name1.value; 
		desc+="Third_Name="+escape(ThirdName1)+"&";
		}
		if(FormName.Family_Name1){
		 var FamilyName1=FormName.Family_Name1.value;  
		 desc+="Family_Name="+escape(FamilyName1)+"&";
		}

		if(FormName.Alt_Id1_No1){
		  var Alt_Id1_No1=FormName.Alt_Id1_No1.value; 
		  desc+="Alt_Id_No="+escape(Alt_Id1_No1)+"&";
		}
		if(FormName.Alt_Id2_No1){
		  var Alt_Id2_No1=FormName.Alt_Id2_No1.value; 
		  desc+="Alt_Id2_No="+escape(Alt_Id2_No1)+"&";
		}
		if(FormName.Alt_Id3_No1){
		  var Alt_Id3_No1=FormName.Alt_Id3_No1.value; 
		  desc+="Alt_Id3_No="+escape(Alt_Id3_No1)+"&";
		}
		if(FormName.Alt_Id4_No1){
		  var Alt_Id4_No1=FormName.Alt_Id4_No1.value; 
		  desc+="Alt_Id4_No="+escape(Alt_Id4_No1)+"&";
		}
		if(FormName.National_Id_No1){
		var National_Id_No1=FormName.National_Id_No1.value;   
		desc+="National_Id_No="+escape(National_Id_No1)+"&";
		}
		/*if(parent.frames[1].document.Patient_Search_Form.MRN)
		{
		var MRN=parent.frames[1].document.Patient_Search_Form.MRN.value;  
		desc+="MRN="+escape(MRN)+"&";
		}
		if(parent.frames[1].document.Patient_Search_Form.Dob)
		{
		var Dob=parent.frames[1].document.Patient_Search_Form.Dob.value;  
		desc+="Dob="+Dob+"&";
		}
		if(parent.frames[1].document.Patient_Search_Form.Sex)
		{
		var Sex=parent.frames[1].document.Patient_Search_Form.Sex.value;  
		 desc+="Sex="+Sex+"&";
		}
		if(parent.frames[1].document.Patient_Search_Form.Area)
		{
		var Area=parent.frames[1].document.Patient_Search_Form.Area.value;    
		desc+="Area="+escape(Area)+"&";
		}
		if(parent.frames[1].document.Patient_Search_Form.Family_No)
		{
		var FamilyNo=parent.frames[1].document.Patient_Search_Form.Family_No.value;                 
		 desc+="Family_No="+escape(FamilyNo)+"&";
		}
		if(parent.frames[1].document.Patient_Search_Form.OldFileNo)
		{
		var OldFileNo=parent.frames[1].document.Patient_Search_Form.OldFileNo.value;  
		 desc+="OldFileNo="+escape(OldFileNo)+"&";
		}*/

		if(FormName.first_name_loc_lang1){
		var first_name_loc_lang1=FormName.first_name_loc_lang1.value;  
		 desc+="first_name_loc_lang="+encodeURIComponent(first_name_loc_lang1)+"&";
		}
		if(FormName.second_name_loc_lang1){
		var second_name_loc_lang1=FormName.second_name_loc_lang1.value;  
		 desc+="second_name_loc_lang="+encodeURIComponent(second_name_loc_lang1)+"&";
		}
		if(FormName.third_name_loc_lang1){
		var third_name_loc_lang1=FormName.third_name_loc_lang1.value;  
		 desc+="third_name_loc_lang="+encodeURIComponent(third_name_loc_lang1)+"&";
		}
		if(FormName.family_name_loc_lang1){
		var family_name_loc_lang1=FormName.family_name_loc_lang1.value;  
		 desc+="family_name_loc_lang="+encodeURIComponent(family_name_loc_lang1);
		}
	}	 
	 parent.close();   
	 parent.returnValue=desc;
}
async function callRegVisitModal(){
	var retVal =  new String();
	var dialogTop   = "0vh";
    var dialogHeight    = "90vh" ; //30.5
    var dialogWidth = "90vw" ;
	var features  = "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no; scroll=no";
	var arguments = "" ;
	var apply_oth_name = "";                    
	var func_act = parent.frames[3].document.getElementById('func_act').value;
	var dr_function_id = parent.frames[3].document.getElementById('dr_function_id').value;
	var function_id = '';
	
	if(func_act == "Visitreg")
		function_id = 'VISIT_REGISTRATION';
	if(func_act == "ProcdReg")
		function_id = 'PROCD_REGISTRATION';
	if(func_act == "DuplicateRegistration")
		function_id = func_act;
	if (parent.frames[2].document.forms[0].apply_oth_name)
		if (parent.frames[2].document.forms[0].apply_oth_name.checked)
			apply_oth_name="Y";
		else
			apply_oth_name="N"; 
		
	if(parent.Pat_Search_Criteria_Frame.document.forms[0].First_Name){
		var FirstName=parent.Pat_Search_Criteria_Frame.document.forms[0].First_Name.value;
	}   
	if(parent.Pat_Search_Criteria_Frame.document.forms[0].Second_Name){
		var SecondName=parent.Pat_Search_Criteria_Frame.document.forms[0].Second_Name.value;   
	}                              
	 if(parent.Pat_Search_Criteria_Frame.document.forms[0].Third_Name){
		var ThirdName=parent.Pat_Search_Criteria_Frame.document.forms[0].Third_Name.value; 
		
	 }
	 if(parent.Pat_Search_Criteria_Frame.document.forms[0].Family_Name) {
		 var FamilyName=parent.Pat_Search_Criteria_Frame.document.forms[0].Family_Name.value;  
		
	 }
	 if(parent.Pat_Search_Criteria_Frame.document.forms[0].Alt_Id1_No){
		  var AltIdNo=parent.Pat_Search_Criteria_Frame.document.forms[0].Alt_Id1_No.value; 
		
	 }
	 if(parent.Pat_Search_Criteria_Frame.document.forms[0].National_Id_No) {
		   var NationalIdNo=parent.Pat_Search_Criteria_Frame.document.forms[0].National_Id_No.value;   
		
	 }
	if(parent.Pat_Search_Criteria_Frame.document.forms[0].MRN){
		var MRN=parent.Pat_Search_Criteria_Frame.document.forms[0].MRN.value;  
	 }
	 if(parent.Pat_Search_Criteria_Frame.document.forms[0].Dob){
		var Dob=parent.Pat_Search_Criteria_Frame.document.forms[0].Dob.value;  
		
	 }
	  if(parent.Pat_Search_Criteria_Frame.document.forms[0].Sex){
		var Sex=parent.Pat_Search_Criteria_Frame.document.forms[0].Sex.value;  
	 }
	 if(parent.Pat_Search_Criteria_Frame.document.forms[0].Area){
		var Area=parent.Pat_Search_Criteria_Frame.document.forms[0].Area.value;    
	 }
	 if(parent.Pat_Search_Criteria_Frame.document.forms[0].OldFileNo){
		var OldFileNo=parent.Pat_Search_Criteria_Frame.document.forms[0].OldFileNo.value;  
	 }
	 if(parent.Pat_Search_Criteria_Frame.document.forms[0].Family_No){
		var FamilyNo=parent.Pat_Search_Criteria_Frame.document.forms[0].Family_No.value;   
	 }
	if(parent.Pat_Search_Criteria_Frame.document.forms[0].first_name_loc_lang){
		var first_name_loc_lang=parent.Pat_Search_Criteria_Frame.document.forms[0].first_name_loc_lang.value;
	}   
	if(parent.Pat_Search_Criteria_Frame.document.forms[0].second_name_loc_lang){
		var second_name_loc_lang=parent.Pat_Search_Criteria_Frame.document.forms[0].second_name_loc_lang.value;   							
	}                              
	if(parent.Pat_Search_Criteria_Frame.document.forms[0].third_name_loc_lang){
		 var third_name_loc_lang=parent.Pat_Search_Criteria_Frame.document.forms[0].third_name_loc_lang.value; 							
	}
	if(parent.Pat_Search_Criteria_Frame.document.forms[0].family_name_loc_lang){
		 var family_name_loc_lang=parent.Pat_Search_Criteria_Frame.document.forms[0].family_name_loc_lang.value; 							
	}


	 if(func_act=="DuplicateRegistration"){
		retVal = await window.showModalDialog("../../eMP/jsp/PatientRegistrationMain.jsp?apply_oth_name="+apply_oth_name+"&module_id=MP&function_id="+function_id+"&function_type=F&access=YYYNN&func_act="+func_act+"&First_Name="+encodeURIComponent(FirstName)+"&Second_Name="+encodeURIComponent(SecondName)+"&Third_Name="+encodeURIComponent(ThirdName)+"&Family_Name="+encodeURIComponent(FamilyName)+"&Alt_Id_No="+escape(AltIdNo)+"&National_Id_No="+escape(NationalIdNo)+"&MRN="+escape(MRN)+"&Dob="+Dob+"&Sex="+Sex+"&Area="+escape(Area)+"&dr_function_id="+dr_function_id+"&Family_No="+escape(FamilyNo)+"&OldFileNo="+escape(OldFileNo)+"&a_first_name_loc_lang="+encodeURIComponent(first_name_loc_lang)+"&a_second_name_loc_lang="+encodeURIComponent(second_name_loc_lang)+"&a_third_name_loc_lang="+encodeURIComponent(third_name_loc_lang)+"&a_family_name_loc_lang="+encodeURIComponent(family_name_loc_lang),arguments,features);
	}
	else{
		var url="../../eMP/jsp/PatientRegistrationMain.jsp?apply_oth_name="+apply_oth_name+"&module_id=MP&function_id="+function_id+"&function_type=F&access=YYYNN&func_act=Visitreg&First_Name="+encodeURIComponent(FirstName)+"&Second_Name="+encodeURIComponent(SecondName)+"&Third_Name="+encodeURIComponent(ThirdName)+"&Family_Name="+encodeURIComponent(FamilyName)+"&Alt_Id_No="+escape(AltIdNo)+"&National_Id_No="+escape(NationalIdNo)+"&MRN="+escape(MRN)+"&Dob="+Dob+"&Sex="+Sex+"&Area="+escape(Area)+"&Family_No="+escape(FamilyNo)+"&OldFileNo="+escape(OldFileNo)+"&a_first_name_loc_lang="+encodeURIComponent(first_name_loc_lang)+"&a_second_name_loc_lang="+encodeURIComponent(second_name_loc_lang)+"&a_third_name_loc_lang="+encodeURIComponent(third_name_loc_lang)+"&a_family_name_loc_lang="+encodeURIComponent(family_name_loc_lang);
		retVal = await window.showModalDialog(url,arguments,features);
	}

	if(retVal){
		if( retVal != null || retVal.length != 0)
			parent.close();
		retVal = "Y" + retVal;
		window.setTimeout(parent.returnValue=retVal,300);
	}    
}
async function passValuesforEmer(){

	var retVal =  new String();
	var dialogTop= "65";
	var dialogHeight= "44" ;
	var dialogWidth = "65" ;
	var features  = "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no; scroll=no";
	var arguments = "" ;
	var apply_oth_name = "N";
	if (parent.frames[2].document.forms[0].apply_oth_name)
		if (parent.frames[2].document.forms[0].apply_oth_name.checked)
			apply_oth_name="Y";
        else
			apply_oth_name="N"; 

	if(parent.Pat_Search_Criteria_Frame.document.forms[0].First_Name){
		var FirstName=parent.Pat_Search_Criteria_Frame.document.forms[0].First_Name.value;
	}   
	if(parent.Pat_Search_Criteria_Frame.document.forms[0].Second_Name){
		var SecondName=parent.Pat_Search_Criteria_Frame.document.forms[0].Second_Name.value;   							
	}                              
	if(parent.Pat_Search_Criteria_Frame.document.forms[0].Third_Name){
		 var ThirdName=parent.Pat_Search_Criteria_Frame.document.forms[0].Third_Name.value; 							
	}
	if(parent.Pat_Search_Criteria_Frame.document.forms[0].Family_Name){
		 var FamilyName=parent.Pat_Search_Criteria_Frame.document.forms[0].Family_Name.value;  
	}
	if(parent.Pat_Search_Criteria_Frame.document.forms[0].Alt_Id1_No){
		var AltIdNo=parent.Pat_Search_Criteria_Frame.document.forms[0].Alt_Id1_No.value; 								
	}
	if(parent.Pat_Search_Criteria_Frame.document.forms[0].National_Id_No){
		var NationalIdNo=parent.Pat_Search_Criteria_Frame.document.forms[0].National_Id_No.value;   								
	}
	if(parent.Pat_Search_Criteria_Frame.document.forms[0].Dob){
		var Dob=parent.Pat_Search_Criteria_Frame.document.forms[0].Dob.value;  
	}
	if(parent.Pat_Search_Criteria_Frame.document.forms[0].Sex){
		var Sex=parent.Pat_Search_Criteria_Frame.document.forms[0].Sex.value;  
	}
	if(parent.Pat_Search_Criteria_Frame.document.forms[0].Family_No){
		var FamilyNo=parent.Pat_Search_Criteria_Frame.document.forms[0].Family_No.value;   
	}

	if(parent.Pat_Search_Criteria_Frame.document.forms[0].first_name_loc_lang){
		var first_name_loc_lang=encodeURIComponent(parent.Pat_Search_Criteria_Frame.document.forms[0].first_name_loc_lang.value);
	}   
	if(parent.Pat_Search_Criteria_Frame.document.forms[0].second_name_loc_lang){
		var second_name_loc_lang=encodeURIComponent(parent.Pat_Search_Criteria_Frame.document.forms[0].second_name_loc_lang.value);   							
	}                              
	if(parent.Pat_Search_Criteria_Frame.document.forms[0].third_name_loc_lang){
		 var third_name_loc_lang=encodeURIComponent(parent.Pat_Search_Criteria_Frame.document.forms[0].third_name_loc_lang.value); 							
	}
	if(parent.Pat_Search_Criteria_Frame.document.forms[0].family_name_loc_lang){
		 var family_name_loc_lang=encodeURIComponent(parent.Pat_Search_Criteria_Frame.document.forms[0].family_name_loc_lang.value); 							
	}

	var flag="Y";						 
	var url="../../eMP/jsp/EmergRegn.jsp?emerg_reg="+flag+"&apply_oth_name="+apply_oth_name+"&module_id=MP&function_id=EM_PAT_REG&function_name=Emergency%20Patient&function_type=F&access=YYYNN&func_act=Visitreg&First_Name="+encodeURIComponent(FirstName)+"&Second_Name="+encodeURIComponent(SecondName)+"&Third_Name="+encodeURIComponent(ThirdName)+"&Family_Name="+encodeURIComponent(FamilyName)+"&Alt_Id_No="+escape(AltIdNo)+"&National_Id_No="+escape(NationalIdNo)+"&Dob="+Dob+"&Sex="+Sex+"&Family_No="+escape(FamilyNo)+"&a_first_name_loc_lang="+encodeURIComponent(first_name_loc_lang)+"&a_second_name_loc_lang="+encodeURIComponent(second_name_loc_lang)+"&a_third_name_loc_lang="+encodeURIComponent(third_name_loc_lang)+"&a_family_name_loc_lang="+encodeURIComponent(family_name_loc_lang);
	//	alert(url);
	retVal = await window.showModalDialog(url,arguments,features);
	
	if(retVal){
		
		if( retVal != null || retVal.length != 0)
			parent.close();
		retVal = "Y" + retVal;
		window.setTimeout(parent.returnValue=retVal,300);
	}							 
}
/*Ends Here */

/*Function For Encounter details Works By Clocking The Current Patient Class*/
async function encounterDetails(enc_facility_id,curr_encounter_id, patient_id,curr_patient_class){
/*alert('enc_facility_id:'+enc_facility_id);
alert('curr_encounter_id:'+curr_encounter_id);
alert('patient_id:'+patient_id);
alert('curr_patient_class:'+curr_patient_class);*/

	
	var jsp_name="CurrentEncounterMain.jsp";
	var retVal = 	new String();
	var dialogHeight= "250vh";
	var dialogWidth = "100vw";
	var dialogTop	= "72";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eMR/jsp/"+jsp_name+"?encounterId="+curr_encounter_id+"&patientId="+patient_id+"&Patient_Class="+curr_patient_class+"&call_function=MP&facilityId="+enc_facility_id,arguments,features);

}

/***************Ends*******/
/*Function For  TabsChange Strats*/


function ChangeTabs(TabName){
		selectTab(TabName);

var jsp_name			=	document.forms[0].jsp_name.value;				
var window_styl		=	document.forms[0].window_styl.value	;		
var close_yn				=	document.forms[0].close_yn.value;			
var win_height			=	document.forms[0].win_height.value	;		
var win_width			=	document.forms[0].win_width.value	;	
var win_top				=	document.forms[0].win_top.value;		
var act_yn  				=	document.forms[0].act_yn.value	;	
var srr						=	document.forms[0].srr.value	;	
var register_button_yn	=	document.forms[0].register_button_yn.value;		
var func_act					=	document.forms[0].func_act.value;
var default_gender			= document.forms[0].default_gender.value;
var enable_gender_yn		= document.forms[0].enable_gender_yn.value;
var dr_function_id		= document.forms[0].dr_function_id.value;
var func_idpassed			= document.forms[0].func_idpassed.value;


		if (TabName=='BasicTab'){

			parent.patsearch.document.getElementById('pat_search').rows="20,25,245,20,*";
			parent.Pat_Search_Criteria_Frame.location.href="../jsp/BasicPatientSearchCriteria.jsp?func_act="+func_act+"&jsp_name="+jsp_name+"&window_styl="+window_styl+"&close_yn="+close_yn+"&win_height="+win_height+"&win_width="+win_width+"&win_top="+win_top+"&act_yn="+act_yn+"&srr="+srr+"&register_button_yn="+register_button_yn+"&default_gender="+default_gender+"&enable_gender_yn="+enable_gender_yn+"&dr_function_id="+dr_function_id+"&func_idpassed="+func_idpassed;
		parent.Pat_Search_Tabs_Frame.document.getElementById('AdvanceTab').src='../../eCommon/images/LAdditional.gif';
		parent.Pat_Search_Toolbar_Frame.defaultSetting();
//		parent.Pat_Search_Toolbar_Frame.document.getElementById('Moreless').style.visibility="hidden";
		if (parent.Pat_Search_Toolbar_Frame.document.getElementById('register'))
		{
		parent.Pat_Search_Toolbar_Frame.document.getElementById('register').disabled=true;
		}
		if (parent.Pat_Search_Toolbar_Frame.document.getElementById('register1'))
		{
		parent.Pat_Search_Toolbar_Frame.document.getElementById('register1').disabled=true;
		}	


//		parent.Pat_Search_Toolbar_Frame.defaultSetting();
		parent.Pat_Results_Frame.location.href="../../eCommon/html/blank.html";
		}
		 if (TabName=="AdvanceTab"){
		parent.patsearch.document.getElementById('pat_search').rows="20,25,330,20,*";
		parent.Pat_Search_Criteria_Frame.location.href="../jsp/DupPatientSearchCriteria.jsp?func_act="+func_act+"&jsp_name="+jsp_name+"&window_styl="+window_styl+"&close_yn="+close_yn+"&win_height="+win_height+"&win_width="+win_width+"&win_top="+win_top+"&act_yn="+act_yn+"&srr="+srr+"&register_button_yn="+register_button_yn+"&default_gender="+default_gender+"&enable_gender_yn="+enable_gender_yn+"&dr_function_id="+dr_function_id+"&func_idpassed="+func_idpassed;
//		parent.Pat_Search_Toolbar_Frame.document.getElementById('Moreless').style.visibility="visible";
		if (parent.Pat_Search_Toolbar_Frame.document.getElementById('register')){
		parent.Pat_Search_Toolbar_Frame.document.getElementById('register').disabled=true;
		}

		if (parent.Pat_Search_Toolbar_Frame.document.getElementById('register1'))
		{
		parent.Pat_Search_Toolbar_Frame.document.getElementById('register1').disabled=true;
		}	
		parent.Pat_Search_Tabs_Frame.document.getElementById('BasicTab').src='../../eCommon/images/General.gif';
		parent.Pat_Results_Frame.location.href="../../eCommon/html/blank.html";
	}
}
/**Change Tabs Ends***/


/********Focus Logic Starts Here ************/
function MoveFocus(num) {
	if(num == 1) {
	if( trimCheck(parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Alt_Id1_No.value)==false) parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.National_Id_No.focus();
	}
	else if(num == 3) {
	if( trimCheck(parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Contact_No.value)==false ) {
	parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Mode.item(0).selected = true;
	parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Mode.disabled=true;
	}
	else {
	parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Mode.item(0).selected = true;
	parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Mode.disabled=false;
	}
 }
	else {
		if( (trimCheck(parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Patient_Id.value)))
		{
		parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Patient_Id.focus();
		}
		if(parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Alt_Id1_No != null)
			if( (trimCheck(parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Alt_Id1_No.value))) parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Alt_Id1_No.focus();
		if(parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Alt_Id2_No != null)
			if( (trimCheck(parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Alt_Id2_No.value))) parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Alt_Id2_No.focus();
		if(parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Alt_Id3_No != null)
			if( (trimCheck(parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Alt_Id3_No.value))) parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Alt_Id3_No.focus();
		if(parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Alt_Id4_No != null)
			if( (trimCheck(parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Alt_Id4_No.value))) parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Alt_Id4_No.focus();
		if((parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.National_Id_No)&& (trimCheck(parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.National_Id_No.value))) parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.National_Id_No.focus();
  }
}

function moveFocustoAddl(){
	/*tab_click('search_tab');
	if (parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Patient_Id.disabled==false)
		parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Patient_Id.focus();*/
}
function moveFocustoGeneral(obj){                               
	if (obj.name=='active_yn') 
	{
		if ((parent.Pat_Search_Criteria_Frame.document.getElementById('addl_field4').type=='hidden') &&                                        (document.getElementById('addl_field5').type=='hidden'))
		{
			tab_click('additional_tab');
			if(parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.MRN)
			{
			if (parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.MRN.disabled==false)
				parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.MRN.focus();
			}
		}
	}
	else
	{                   
		if (obj.name == 'addl_field5')
		{
			tab_click('additional_tab');
			if(parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.MRN)
			{
			if (parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.MRN.disabled==false)
				parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.MRN.focus();
			}
		}
		else
		{                       
			if (parent.Pat_Search_Criteria_Frame.document.getElementById('addl_field5').type=='hidden')
			{
				//tab_click('additional_tab');
				if(parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.MRN)
				{
				if (parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.MRN.disabled==false)
					parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.MRN.focus();
				}
			}
		}
	}
}
function movefocusout(obj){
	if(obj.name=='oth_no1'){
	document.getElementById('simple').scrollIntoView();
	document.getElementById('Patient_Id1').focus();
	}else if(obj.name=='Moreless'){
		if(document.getElementById('morelessexpand').value=='Y'){
			document.getElementById("PATIENT_ID").focus();
		}
	}else if(obj.name=='EM_yn'){
		document.getElementById("PATIENT_ID").focus();
	}
}
function MoveFocusSimple(num) 
{
	if(num == 1) {
		if( trimCheck(parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.Alt_Id1_No.value)==false) parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.National_Id_No1.focus();
	}
	else if(num == 3) {
		if( trimCheck(parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.Contact_No1.value)==false ) {
			parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.Mode.item(0).selected = true;
			parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.Mode.disabled=true;
		}
		else {
			parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.Mode.item(0).selected = true;
			parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.Mode.disabled=false;
		}
	}
	else {
		if( (trimCheck(parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.Patient_Id1.value))){
			parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.Patient_Id1.focus();
		}
			if(parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.Alt_Id1_No != null)
				if( (trimCheck(parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.Alt_Id1_No.value))) parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.Alt_Id1_No.focus();
			if(parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.Alt_Id2_No != null)
				if( (trimCheck(parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.Alt_Id2_No.value))) parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.Alt_Id2_No.focus();
			if(parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.Alt_Id3_No != null)
				if( (trimCheck(parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.Alt_Id3_No.value))) parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.Alt_Id3_No.focus();
			if(parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.Alt_Id4_No != null)
				if( (trimCheck(parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.Alt_Id4_No.value))) parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.Alt_Id4_No.focus();
			if((parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.National_Id_No1)&& (trimCheck(parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.National_Id_No1.value))) parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.National_Id_No1.focus();
	}
}
/*********************Ends**************************/

/*All Enable Functions Starts*/
function enableOtherAltId(val)
{
	document.forms[0].other_alt_Id_no.value = "";
	if(val != '')
	{
		document.forms[0].other_alt_Id_no.disabled = false;
	}
	else
	{
		document.forms[0].other_alt_Id_no.value = "";
		document.forms[0].other_alt_Id_no.disabled = true;
	}
}
	function enableDocType()
	{
		document.forms[0].txtDocType.value = "";
		var varDoc = document.forms[0].sltDocType.value;
		if(varDoc != "")
		document.forms[0].txtDocType.disabled = false;
		else
		{
			
			document.forms[0].txtDocType.disabled = true;
		}
	}
function EnableFamSearch(obj)
{
	
}
function enableSuffix()
{

	if (trimCheck(parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.Alt_Id1_No1.value)) {
		parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.newborn_suffix.disabled=false;
	}
	else
	{
		parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.newborn_suffix.value = "";
		parent.Pat_Search_Criteria_Frame.document.Basic_Patient_Search_Form.newborn_suffix.disabled=true;
	}
}
function AdnvcenableSuffix()
{

	if (trimCheck(parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.Alt_Id1_No.value)) {
		parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.newborn_suffix.disabled=false;
	}
	else
	{
		parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.newborn_suffix.value = "";
		parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.newborn_suffix.disabled=true;
	}
}
function enableRegister()
{
	if(parent.Pat_Search_Toolbar_Frame.document.search_toolbar.register)	{
		 if(parent.Pat_Search_Toolbar_Frame.document.search_toolbar.register && flag==true) {
			  parent.Pat_Search_Toolbar_Frame.document.search_toolbar.register.disabled=false;
		 } else
			  parent.Pat_Search_Toolbar_Frame.document.search_toolbar.register.disabled=true;
	}

	if(parent.Pat_Search_Toolbar_Frame.document.search_toolbar.register1){
		 if(parent.Pat_Search_Toolbar_Frame.document.search_toolbar.register1 && flag==true){
			  parent.Pat_Search_Toolbar_Frame.document.search_toolbar.register1.disabled=false;
		 }else
			  parent.Pat_Search_Toolbar_Frame.document.search_toolbar.register1.disabled=true;
	}
}
/**Enable Functions Ends**/



	/*Some Common Functions**/
function ChangeCase(obj){
	var pat_id = obj.value;
	pat_id = pat_id.toUpperCase();				
	obj.value = pat_id;
}
function callMouseOver(obj){
    currClass = obj.className ;	
    obj.className = 'TOOLTIPSELECT';
}
function callOnMouseOut(obj){
    obj.className = currClass;
}
function hideToolTip(){
    document.getElementById('tooltiplayer').style.visibility = 'hidden'
}
function callDummy(){}


/*********Ends**********/




/******Functions For Display ToolTip ***********/

	function displayToolTip(patient_id){
	patient_id = unescape(patient_id);
	var func = parent.frames[2].document.forms[0].func_act.value;
    func = func.toUpperCase();	
 /*   if (func=="EMERG" || func=="RPDRG")
    {
        bodwidth  = parent.parent.frames[1].document.body.offsetWidth;
        bodheight = parent.parent.frames[1].document.body.offsetHeight;
        var x     = event.x;
        var y     = event.y;
        x     = x + (document.getElementById('tooltiplayer').offsetWidth);
        y     = y + (document.getElementById('tooltiplayer').offsetHeight);

        if(x<bodwidth)
            x = event.x;
        else
            x = x - (document.getElementById('tooltiplayer').offsetWidth*2);
        if(y<bodheight)
            y = event.y;
        else
            y = y - (document.getElementById('tooltiplayer').offsetHeight*2);

        y+=document.body.scrollTop;
        x+=document.body.scrollLeft;
        document.getElementById('tooltiplayer').style.posLeft= 18;
        document.getElementById('tooltiplayer').style.posTop = y;
        buildTable(patient_id);
    }
    else
    {*/
		alert("in dup patsearch");
        if (func=="NEWBORN_REG")
        {
            parent.parent.Pat_Results_Frame.checkExpiry(patient_id, '','',"NEWBORN_REG");
        }
        else
        {
            parent.parent.Pat_Results_Frame.checkExpiry(patient_id,'','','');
        }

   // }
}

function buildTable(patientid)
{
    var HTMLVal = new String();
    HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eMP/jsp/GetPatientSex.jsp'><input type='hidden' name='PATIENT_ID' id='PATIENT_ID' value=\""+escape(patientid)+"\"></form></BODY></HTML>";
    parent.parent.frames[5].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
    parent.parent.frames[5].document.form1.submit();
}

function buildTableOptions(patientid)
{
	if (parent.Pat_Results_Frame.frames[0].document.forms[0].sex.value=="F")
    {
       // var row      = ("Change Demographics,Register NewBorn,View Mother-Baby Link,Register Visit,Admit Patient");
        var row      = (getLabel('eMP.ChangeDemographics.label','MP')+","+ getLabel('eMP.RegNewBorn.label','MP')+" ,"+ getLabel('eMP.ViewMotherBabyLink.label','MP')+","+ getLabel('eMP.RegisterVisit.label','MP')+","+ getLabel('Common.AdmitPatient.label','common'));
        
        var row_disp      = ("ChangeDemographics,RegisterNewBorn,ViewMotherBabyLink,RegisterVisit,AdmitPatient");
    }
    else
    {
        var row      = (getLabel('eMP.ChangeDemographics.label','MP')+","+ getLabel('eMP.RegisterVisit.label','MP')+","+getLabel('Common.AdmitPatient.label','common'));
        var row_disp      = ("ChangeDemographics,RegisterVisit,AdmitPatient");
    }
    var rowval   = row.split(",");
    var rowval_disp   = row_disp.split(",");
    var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center'>"

    for( var i=0; i<rowval.length; i++ )
    {
        var colval  = rowval[i];
        var colval_disp  = rowval_disp[i];
        tab_dat     += "<tr>";
        tab_dat     += "<td class = 'ORTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:callMenuFunctions('"+colval_disp+"',\""+escape(patientid)+"\")>"+colval+"</a></td>";       tab_dat     += "</tr>";
    }
    tab_dat     += "</table>";
    parent.Pat_Results_Frame.frames[0].document.getElementById('t').innerHTML = tab_dat;
    parent.Pat_Results_Frame.frames[0].document.getElementById('tooltiplayer').style.visibility='visible' ;
    
}
/***********Ends****************/
/**Call Menu Functions Starts***/
function callMenuFunctions(s,patientid){  
	alert("in dup patsearch 12");  
	if (s=="RegisterNewBorn")
	{
		parent.parent.Pat_Results_Frame.checkExpiry(patientid, '','',"NEWBORN_REG",s);
	}			
	else if(s=="ChangeDemographics")
    {
        parent.parent.Pat_Results_Frame.checkExpiry(patientid,'','','',s);
    }
    else
    {
        callMenu(s,patientid);
    }
}
async function callMenu(s,patientid){	 
		
	if(s=="RegisterNewBorn")
    {
        setTimeout("showRegisterNewBorn(\""+patientid+"\")",1000);
    }

    if(s=="ViewMotherBabyLink")
    {
       var dialogHeight= "18" ;
        var dialogWidth = "49.8" ;
        var status = "no";
        var arguments   = "" ;
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status;
        var retVal = await window.showModalDialog("../jsp/PaintNewbornMotherBabyLink.jsp?mother_id="+escape(patientid)+"&function_id=PAT_REG",arguments,features);
        if(retVal != null)
        {
            var arr = retVal.split('`');
            if(arr[1] == 'N')
            {
				alert(parent.getMessage("NO_MOTHER_BABY_LINKS",'MP'));
            }
        }

    }
    if(s=="RegisterVisit"){
        if(parent.parent.Pat_Results_Frame.frames[0].document.result_form.op_install_yn=="N")
            alert(getMessage("OP_NOT_INSTALLED",'SM'));
        else{

        var dialogHeight= "33.4" ;
        var dialogWidth = "50" ;
        var dialogTop = "65"
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";dialogTop:"+dialogTop+";status=no;scroll=no" ;
        var arguments   = "" ;
        var retVal = await window.showModalDialog("../../eOP/jsp/VisitRegistration.jsp?p1="+escape(patientid)+"&function_id=VISIT_REGISTRATION&function_type=F&access=YNNNN",arguments,features);
        }
    }
    if(s=="ChangeDemographics"){
        setTimeout("showChangeDemographics(\""+patientid+"\")",1000);
    }

    if(s=="AdmitPatient"){
        if(parent.parent.Pat_Results_Frame.frames[0].document.result_form.ip_install_yn=="N")
            alert(getMessage("IP_NOT_INSTALLED",'SM'));
        else{
            var dialogHeight= "33.4" ;
            var dialogWidth = "50" ;
			var dialogTop = "65" ;
            var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";dialogTop:"+dialogTop+";status=no;scroll=no" ;
            var arguments   = "" ;
            var retVal = await window.showModalDialog("../../eIP/jsp/AdmitPatient.jsp?patient_id="+escape(patientid)+"&module_id=IP&function_id=ADMISSION&function_name=Admit Patient&function_type=F&access=YNNNN",arguments,features);
        }
    }

} 
/*End of the Function callMenuFunctions*/

    async function showChangeDemographics(patientid){
		var dialogHeight= "35.5" ;
        var dialogWidth = "50" ;
        var wintop = "61"
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:" + wintop +";status=no";
        var arguments   = "" ;
        var param='../../eMP/jsp/ChangePatientDetails.jsp?step=1&function_id=PAT_REG&function_name=Change Patient Details&access=NYNNN&Patient_ID='+escape(patientid)
        var retVal = await window.showModalDialog(param,arguments,features);
    }

    async function showRegisterNewBorn(patientid){        
		var retVal =    new String();
        var dialogHeight= "18" ;
        var dialogWidth = "49.8" ;
        var status = "no";
        var arguments   = "" ;
        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; scroll=no; status:" + status;		
		if (parent.Pat_Results_Frame.frames[0].document.forms[0].min_age.value!=null)
        {
           if (parseInt(parent.Pat_Results_Frame.frames[0].document.forms[0].age.value) < parseInt(parent.Pat_Results_Frame.frames[0].document.forms[0].min_age.value))
           {
			   alert(getMessage("MOTHER_AGE_PARAM",'MP'));
               }
           else
           {
                if(parent.Pat_Results_Frame.frames[0].document.forms[0].allow_nb_review.value!="N")
                {
                    var retVal = await window.showModalDialog("../../eMP/jsp/PaintNewbornMotherBabyLink.jsp?mother_id="+escape(patientid),arguments,features);
                    if(retVal != null)
                    {
                        var arr = retVal.split('`');
                        if(arr[1] == 'N')
                        {
                            alert(getMessage("NO_MOTHER_BABY_LINKS",'MP'));
                            dialogHeight= "34" ;
                            dialogWidth = "50" ;
                            wintop = "61"
                            features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:" + wintop +";status=no";
                            arguments   = "" ;
                            var param="NewbornRegistration.jsp?module_id=MP&function_id=PAT_REG&function_name="+getLabel('eMP.RegNewBorn.label','MP')+"&function_type=F&access=NYNNN&Patient_ID="+escape(patientid);
                           // var param="NewbornRegistration.jsp?module_id=MP&function_id=PAT_REG&function_name=Register New Born&function_type=F&access=NYNNN&Patient_ID="+escape(patientid);
                            var retVal = await window.showModalDialog(param,arguments,features);
                        }
                        else if(arr[1] == 'Y')
                        {
                            dialogHeight= "34" ;
                            dialogWidth = "50" ;
                            wintop = "61"
                            features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:" + wintop +";status=no";
                            arguments   = "" ;
                            var param="NewbornRegistration.jsp?module_id=MP&function_id=PAT_REG&function_name="+getLabel('eMP.RegNewBorn.label','MP')+"&function_type=F&access=NYNNN&Patient_ID="+escape(patientid);
                          //  var param="NewbornRegistration.jsp?module_id=MP&function_id=PAT_REG&function_name=Register New Born&function_type=F&access=NYNNN&Patient_ID="+escape(patientid);
                            var retVal = await window.showModalDialog(param,arguments,features);
                        }
                    }
                }
                else
               {
                    dialogHeight= "34" ;
                    dialogWidth = "50" ;
                    wintop = "61"
                    features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:" + wintop +";status=no";
                    arguments   = "" ;
                   // var param="NewbornRegistration.jsp?module_id=MP&function_id=PAT_REG&function_name=Register New Born&function_type=F&access=NYNNN&Patient_ID="+escape(patientid);
                    var param="NewbornRegistration.jsp?module_id=MP&function_id=PAT_REG&function_name="+getLabel('eMP.RegNewBorn.label','MP')+"&function_type=F&access=NYNNN&Patient_ID="+escape(patientid);
                    var retVal = await window.showModalDialog(param,arguments,features);
               }
            }
       }
       else
        {
            if(parent.Pat_Results_Frame.frames[0].document.forms[0].allow_nb_review.value!="N")
            {
                var retVal =await window.showModalDialog("../../eMP/jsp/PaintNewbornMotherBabyLink.jsp?mother_id="+escape(patientid),arguments,features);
                if(retVal != null)
                {
                    var arr = retVal.split('`');
                    if(arr[1] == 'N')
                    {
                        alert(getMessage("NO_MOTHER_BABY_LINKS",'MP'));
                        dialogHeight= "34" ;
                        dialogWidth = "50" ;
                        wintop = "61"
                        features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:" + wintop +";status=no";
                        arguments   = "" ;
                     //   var param="NewbornRegistration.jsp?module_id=MP&function_id=PAT_REG&function_name=Register New Born&function_type=F&access=NYNNN&Patient_ID="+escape(patientid);
                        var param="NewbornRegistration.jsp?module_id=MP&function_id=PAT_REG&function_name="+getLabel('eMP.RegNewBorn.label','MP')+"&function_type=F&access=NYNNN&Patient_ID="+escape(patientid);
                        var retVal = await window.showModalDialog(param,arguments,features);
                    }
                    else if(arr[1] == 'Y')
                    {
                        dialogHeight= "34" ;
                        dialogWidth = "50" ;
                        wintop = "61"
                        features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:" + wintop +";status=no";
                        arguments   = "" ;
                        var param="NewbornRegistration.jsp?module_id=MP&function_id=PAT_REG&function_name="+getLabel('eMP.RegNewBorn.label','MP')+"&function_type=F&access=NYNNN&Patient_ID="+escape(patientid);
                        //var param="NewbornRegistration.jsp?module_id=MP&function_id=PAT_REG&function_name=Register New Born&function_type=F&access=NYNNN&Patient_ID="+escape(patientid);
                        var retVal = await window.showModalDialog(param,arguments,features);
                    }
                }
            }
            else{
                dialogHeight= "34" ;
                dialogWidth = "50" ;
                wintop = "61"
                features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";dialogTop:" + wintop +";status=no";
                arguments   = "" ;
                var param="NewbornRegistration.jsp?module_id=MP&function_id=PAT_REG&function_name="+getLabel('eMP.RegNewBorn.label','MP')+"&function_type=F&access=NYNNN&Patient_ID="+escape(patientid);
                //var param="NewbornRegistration.jsp?module_id=MP&function_id=PAT_REG&function_name=Register New Born&function_type=F&access=NYNNN&Patient_ID="+escape(patientid);
                var retVal = await window.showModalDialog(param,arguments,features);
            }
        }
    }

