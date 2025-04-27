var prevTabObj=null;
var precount=0;

function loadMatDetailPage(secHdgCode,subSecHdgCode,splty_event_code)
{
	
	/*document.matConsTabsForm.prevSecHdgCode.value = document.matConsTabsForm.sec_hdg_code.value;
	document.matConsTabsForm.prevSubSecHdgCode.value = document.matConsTabsForm.sub_sec_hdg_code.value;
	document.matConsTabsForm.sec_hdg_code.value = secHdgCode;
	document.matConsTabsForm.sub_sec_hdg_code.value = subSecHdgCode;
	var prevSecHdgCode = document.matConsTabsForm.prevSecHdgCode.value;
	var prevSubSecHdgCode = document.matConsTabsForm.prevSubSecHdgCode.value;
	var queryString = document.matConsTabsForm.queryString.value;*/
	assignSectionDetails1(secHdgCode,subSecHdgCode,'','','','','','',splty_event_code);
	//setTimeout("assignSectionDetails1('"+secHdgCode+"','"+subSecHdgCode+"','','','','','','')",1000);

//	document.matConsTabsForm.prevSecHdgCode.value = secHdgCode;
//	document.matConsTabsForm.prevSubSecHdgCode.value = subSecHdgCode;

	//parent.recMatConsBlankFrame.location.href = '../../eCA/jsp/RecMaternityConsControl.jsp?'+queryString+'&sub_sec_hdg_code='+subSecHdgCode+'&prevSecHdgCode='+prevSecHdgCode+'&prevSubSecHdgCode='+prevSubSecHdgCode;

//	alert(" Params " + queryString+'&sub_sec_hdg_code='+subSecHdgCode+'&prevSecHdgCode='+prevSecHdgCode+'&prevSubSecHdgCode='+prevSubSecHdgCode);

/*	if(parent.recMatConsDetailsFrame.document.RecMatConsForm != null)
	{
		parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.target = 'recMatConsBlankFrame';
		parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.method = 'post';
		parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.action	=	'../../eCA/jsp/RecMaternityConsControl.jsp?'+queryString+'&sub_sec_hdg_code='+subSecHdgCode+'&prevSecHdgCode='+prevSecHdgCode+'&prevSubSecHdgCode='+prevSubSecHdgCode+'&tabClick=Y';
		parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.submit();
	}
	else
	{
		parent.recMatConsBlankFrame.document.forms[0].target = 'recMatConsBlankFrame';
		parent.recMatConsBlankFrame.document.forms[0].method = 'post';
		parent.recMatConsBlankFrame.document.forms[0].action	=	'../../eCA/jsp/RecMaternityConsControl.jsp?'+queryString+'&sub_sec_hdg_code='+subSecHdgCode+'&prevSecHdgCode='+prevSecHdgCode+'&prevSubSecHdgCode='+prevSubSecHdgCode+'&tabClick=Y';
		parent.recMatConsBlankFrame.document.forms[0].submit();
	}	*/
}

function addNewRow(tableId, index_to_add)
{
	var table_obj = document.getElementById(tableId);

	if(table_obj != null)
	{		
		var rowId = table_obj.insertRow(index_to_add+1);

		for(i=0;i<table_obj.rows(2).cells.length;i++)
		{
			rowId.insertCell();
			rowId.cells(rowId.cells.length-1).colSpan = table_obj.rows(2).cells(rowId.cells.length-1).colSpan;
			rowId.cells(rowId.cells.length-1).align = table_obj.rows(2).cells(rowId.cells.length-1).align;
			rowId.cells(rowId.cells.length-1).innerHTML = table_obj.rows(2).cells(rowId.cells.length-1).innerHTML;
		}		
	}

	var grid_component_ids = eval("document.RecClinicalNotesTemplateForm.grid_component_ids_" + tableId + ".value");

	var first_component_name = "";
	var calender_named = false;
	var min_max_named = false;
	changeRowIds(tableId);
	var component_wise_details = grid_component_ids.split("~");
	var default_values = eval("document.RecClinicalNotesTemplateForm.default_values_list_" + tableId + ".value");
	var component_default_values = default_values.split("|");
	var grid_name = component_wise_details[0];

	if(grid_name == tableId)
	{
		for(j=1;j<component_wise_details.length;j++)
		{
			calender_named = false;
	
			var component_coll = document.getElementById(component_wise_details[j]);
			var name_index = 0;
			var array_index = 0;
			var array_index1=0;
			var array_index2 = 0;
			var def_value =  component_default_values[j-1];
			for(k=0;k<component_coll.length;k++)
			{
				if(k==0)
				{
					first_component_name = component_coll[k].name;
				}
				else if(first_component_name != null)
				{
					component_coll[k].name = first_component_name + (9999 + name_index);

					if(index_to_add == (k+1))
					{
						if(component_coll[k].type == "checkbox")
							component_coll[k].checked = (def_value=="true"?true:false);
						else
							component_coll[k].value = def_value;
					}					
					
					if(component_wise_details[j].indexOf("list_box_component_of_") != -1)
					{
						var list_box_hidden_field =  document.getElementById(first_component_name+ "_desc" );
						list_box_hidden_field.name = first_component_name+(9999 + name_index)+ "_desc";

						var index_name1 = (component_wise_details[j].substr("list_box_component_of_".length));
						//alert("index_name1.."+index_name1);
							
						var lookup_component = document.getElementById('lookup_component_of_'+index_name1);
						
							
							if(lookup_component != null )
							{
								for(var calender_counter = 0;calender_counter < lookup_component.length ; calender_counter++)
							   {
								  
								if(lookup_component[calender_counter].value == first_component_name || lookup_component[calender_counter].value.indexOf("(") != -1 )
								{
									lookup_component[calender_counter].value = (first_component_name + "(" + array_index1++ + ")");
									 
								}
							  }
							
						  }
							
							  array_index2++;
							  
						}

					if(component_wise_details[j].indexOf("date_time_numeric_component_of_") != -1 )
					{
						var index_name = (component_wise_details[j].substr("date_time_numeric_component_of_".length));
				

						var calender_component_of_date_time_numeric = document.getElementById('calender_component_of_'+ index_name);
						
				
						if(calender_component_of_date_time_numeric != null && !calender_named)
						{
							calender_named = true;

							for(var calender_counter = 0;calender_counter < calender_component_of_date_time_numeric.length ; calender_counter++)
							{
								if(calender_component_of_date_time_numeric[calender_counter].value == first_component_name || calender_component_of_date_time_numeric[calender_counter].value.indexOf("(") != -1 )
								{
									calender_component_of_date_time_numeric[calender_counter].value = (first_component_name + "(" + array_index++ + ")");
								}
							}
						}							
					}

					name_index++;
				}
			}
		}
	}
}

function removeRow(tableId, index_to_delete)
{
	//alert(index_to_delete);
	var no_of_checked = 0;
	var table_obj = document.getElementById(tableId);
	table_obj.deleteRow(index_to_delete+1);
	changeRowIds(tableId);
	var grid_component_ids = eval("document.RecClinicalNotesTemplateForm.grid_component_ids_" + tableId + ".value");
	//alert(grid_component_ids);
	var first_component_name = "";	
	var calender_named = false;
	var component_wise_details = grid_component_ids.split("~");
	var grid_name = component_wise_details[0];
	if(grid_name == tableId)
	{
		for(var j=1;j<component_wise_details.length;j++)
		{
			//alert("component ID=" + component_wise_details[j]);
			var component_coll = document.getElementById(component_wise_details[j]);			
			//alert(component_wise_details[j] + "=" + component_coll.length);			
			var name_index = 0;
			var array_index = 0;
			for(var k=0;k<component_coll.length;k++)
			{
				if(k==0)
					first_component_name = component_coll[k].name;
				else if(first_component_name != null)
				{
					component_coll[k].name = first_component_name+(9999 + name_index) ; 
					if(component_wise_details[j].indexOf("list_box_component_of_") != -1 )
					{
						var list_box_hidden_field = document.getElementById(first_component_name + "_desc" );
						list_box_hidden_field.name = first_component_name+(9999 + name_index)+ "_desc";
						//alert(list_box_hidden_field.name);
					}
					//alert(component_wise_details[j]);
					if(component_wise_details[j].indexOf("date_time_numeric_component_of_") != -1 )
					{						
						var index_name = (component_wise_details[j].substr("date_time_numeric_component_of_".length));	
						//alert(index_name);
						var calender_component_of_date_time_numeric = document.getElementById('calender_component_of_'+ index_name);
						//alert(calender_component_of_date_time_numeric.length );						
						if(calender_component_of_date_time_numeric != null && !calender_named)
						{
							//alert(calender_component_of_date_time_numeric.length);
							calender_named = true;
							for(var calender_counter=0;calender_counter<calender_component_of_date_time_numeric.length;calender_counter++)
							{
								//if(calender_counter != 0)
								{
									//alert(calender_component_of_date_time_numeric[calender_counter].value);
									if(calender_component_of_date_time_numeric[calender_counter].value == first_component_name || calender_component_of_date_time_numeric[calender_counter].value.indexOf("(") != -1 )
									{
										calender_component_of_date_time_numeric[calender_counter].value = (first_component_name + "(" + array_index++ + ")");
									}
									//alert(calender_component_of_date_time_numeric[calender_counter].value);
								}
								//alert("=" + calender_component_of_date_time_numeric[calender_counter].value + "=");
							}
						}							
					}		
					name_index++;
				}
			}
		}
	}
}

function recordF(finalize_yn)
{	
	parent.recMatConsBtnsFrame.document.RecMaternityConsToolbarForm.Save.disabled=true;
	parent.recMatConsBtnsFrame.document.RecMaternityConsToolbarForm.Record.disabled=true;
	
	parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.finalize_yn.value = finalize_yn;
	
	record();
}


function record()
{
	parent.recMatConsBtnsFrame.document.RecMaternityConsToolbarForm.Record.disabled=true;
	if (parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm != null)
	{													
		var formObj = parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm;
		var nodeList = formObj.elements.length;
		var locale = formObj.locale.value
		var p_lmp_val = "";
		var p_edd_val = "";
		var p_ges_val = "";
		var p_corrected_edd_val = "";
		var temp_gestation_age = "";
		var temp_gestation_unit = "";
		var temp_max_ges_val="";
		
		var p_max_ges_val = document.RecMaternityConsToolbarForm.p_max_ges_val.value;
		var p_min_ges_val = document.RecMaternityConsToolbarForm.p_min_ges_val.value;
		var p_ges_unit = document.RecMaternityConsToolbarForm.p_ges_unit.value;

		for (var i=0; i<nodeList;i++ )
		{
			var compObj = formObj.elements[i];
			
			
			if (compObj.type == 'text')
			{
				if(compObj.name.length >= 9 && compObj.name.substring(0,9) == 'C_MC01LMP')
				{
					p_lmp_val = compObj.value;
					if (p_lmp_val != "")
					{
						if(!isBeforeNow(p_lmp_val,"DMY",locale))
						{							
							var msg = getMessage("FROM_DATE_GREATER_SYSDATE","CA");
							msg = msg.replace("From", "Corrected LMP");
							msg = msg.replace("Current", "System");
							alert(msg);
							compObj.focus();
							return false;
						}
					}					
				}else if(compObj.name.length >= 9 && compObj.name.substring(0,14) == 'C_MC01GESTNAGE')
				{
					p_ges_val =  compObj.value;
				
				}else if(compObj.name.length >= 9 && compObj.name.substring(0,9) == 'C_MC01EDD')
				{
					p_edd_val =  compObj.value;
				}else if(compObj.name.length >= 9 && compObj.name.substring(0,17) == 'C_MC01CORRECTDEDD')
				{
					p_corrected_edd_val =  compObj.value;
				}
			}
		}
		if (p_lmp_val != "")
		{		
			var currentDate = getCurrentDate("DMY",'en');		
			var temp_lmp = convertDate(p_lmp_val,"DMY",locale,"en");
			var gestation_age =  daysBetween(temp_lmp,currentDate,"DMY","en");		
			if (p_ges_unit == "W" || p_ges_unit == "w")
			{
				temp_max_ges_val = p_max_ges_val+" Weeks";				
				var ga_weeks = parseInt(gestation_age/7);											
				var ga_days = parseInt(gestation_age%7);		

				var weekLabel = "";
				var daysLabel = "";
				if(ga_weeks == 1)
					weekLabel  = ga_weeks + " Week";
				else if(ga_weeks > 1)
					weekLabel  = ga_weeks + " Weeks";

				if(ga_days == 1)
					daysLabel  = ga_days+" Day";
				else if(ga_days > 1)
					daysLabel  = ga_days+" Days";

				if(weekLabel == "" && daysLabel=="")
					cal_gest_age = "0";
				else
					cal_gest_age =weekLabel+" "+daysLabel;

				temp_gestation_age =cal_gest_age ;
				//temp_gestation_age =ga_weeks+" Weeks  "+ga_days+" Days" ;
				p_min_ges_val  = parseInt(p_min_ges_val * 7);
				p_max_ges_val  = parseInt(p_max_ges_val * 7);
			}else
			{					
				p_min_ges_val  = parseInt(p_min_ges_val * 1);
				p_max_ges_val  = parseInt(p_max_ges_val *1);
				if(parseInt(gestation_age) == 1)
					temp_gestation_age =gestation_age+" Day";
				else
					temp_gestation_age =gestation_age+" Days";		
			//	temp_gestation_age = gestation_age +" Days";
				temp_max_ges_val = p_max_ges_val+" Days";
			}								
			if (trimString(p_ges_val) != "" && trimString(p_ges_val) != trimString(temp_gestation_age))
			{
				var msg = getMessage("INVALID_GESTATION",'CA');
				msg = msg.replace("$"," ("+temp_gestation_age+")");
				msg = msg.replace("#"," ("+p_ges_val+")");
				alert(msg);				
				parent.recMatConsBtnsFrame.document.RecMaternityConsToolbarForm.Record.disabled=false;
				return false;						
			}
			if (gestation_age > p_max_ges_val)
			{											
				var msg = getMessage("INVALID_LMP",'CA');
				msg = msg.replace("$"," ("+temp_gestation_age+")");
				msg = msg.replace("#"," ("+temp_max_ges_val+")");
				alert(msg);
				parent.recMatConsBtnsFrame.document.RecMaternityConsToolbarForm.Record.disabled=false;
				return false;
			}
		}					
	}		
	
	//alert("In function record() .........");
	var secHdgCode= parent.recMatConsTabsFrame.document.matConsTabsForm.sec_hdg_code.value;
	var subSecHdgCode=parent.recMatConsTabsFrame.document.matConsTabsForm.sub_sec_hdg_code.value;
	var no_of_rows =parent.recMatConsTabsFrame.document.matConsTabsForm.no_of_rows.value;


	// alert("secHdgCode"+secHdgCode)
	var queryString = parent.recMatConsTabsFrame.document.matConsTabsForm.queryString.value;
	parent.recMatConsTabsFrame.document.matConsTabsForm.prevSecHdgCode.value = parent.recMatConsTabsFrame.document.matConsTabsForm.sec_hdg_code.value;
	parent.recMatConsTabsFrame.document.matConsTabsForm.prevSubSecHdgCode.value = parent.recMatConsTabsFrame.document.matConsTabsForm.sub_sec_hdg_code.value;
//	document.matConsTabsForm.sec_hdg_code.value = secHdgCode;
//	document.matConsTabsForm.sub_sec_hdg_code.value = subSecHdgCode;

	var prevSecHdgCode = parent.recMatConsTabsFrame.document.matConsTabsForm.prevSecHdgCode.value;
	var prevSubSecHdgCode = parent.recMatConsTabsFrame.document.matConsTabsForm.prevSubSecHdgCode.value;

	 var returnVal =  assignSectionDetails1(secHdgCode,subSecHdgCode,"","","","","","");
	if (returnVal != undefined)
	{
		if (!returnVal)
		{			
			return false;
		}		
	}
	 

//setTimeout('assignSectionDetails1("","","","","","","","")',1000);
	
	no_of_rows =parent.recMatConsTabsFrame.document.matConsTabsForm.no_of_rows.value;
	var sectionType = parent.recMatConsTabsFrame.document.matConsTabsForm.sectionType.value;
	if(sectionType=='OC'){
		//alert("In If   "+sectionType);
		var close_episode_yn = parent.recMatConsTabsFrame.document.matConsTabsForm.close_episode_yn.value;
		
		parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.action='../../eCA/jsp/RecMaternityConsControl.jsp?'+queryString+'&sec_hdg_code='+secHdgCode+'&tabClick=N&sub_sec_hdg_code='+subSecHdgCode+'&prevSecHdgCode='+prevSecHdgCode+'&prevSubSecHdgCode='+prevSubSecHdgCode+'&no_of_rows='+no_of_rows+'&close_episode_yn='+close_episode_yn;
		parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.target='recMatConsBlankFrame';
		//'../../eCA/jsp/RecMaternityConsControl.jsp?'+queryString+'&sec_hdg_code='+curr_sec_hdg_code+'&sub_sec_hdg_code='+curr_child_sec_hdg_code+'&prevSecHdgCode='+prevSecHdgCode+'&prevSubSecHdgCode='+prevSubSecHdgCode+'&tabClick=Y'+'&no_of_rows='+no_of_rows;
		
		parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.method='post';
	
		parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.submit();
	}
	else
	{
	//	alert("In Else");
		parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.action='../../eCA/jsp/RecMaternityConsControl.jsp?'+queryString+'&tabClick=N&sub_sec_hdg_code='+prevSubSecHdgCode+'&prevSecHdgCode='+prevSecHdgCode+'&prevSubSecHdgCode='+prevSubSecHdgCode+'&no_of_rows='+no_of_rows;
		parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.target='recMatConsBlankFrame';
		parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.method='post';
		parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.submit();
	}

  
	/*parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.action='../../servlet/eCA.RecMaternityConsServlet';
	parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.target='messageFrame';
	parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.method='post';
	parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.submit();*/
}


function checkValidRange(numObj, grid_min_max_id)
{	
	//alert("numObj==="+numObj.name );
	//alert("grid_min_max_id==="+grid_min_max_id );
	if(CheckNum(numObj)==false)
		return false;
	if(checkIsNull(numObj))
		return false;
	var min_max_obj;
	var	min_max_value	=	"",	min_num_value	=	0,	max_num_value	=	0;
	var min_max_array	=	new Array();	
	min_max_obj	=	eval("document.RecClinicalNotesTemplateForm.min_max" + numObj.name);

	//alert("min_max_obj==="+min_max_obj)	 ;
	if(grid_min_max_id != null && grid_min_max_id != undefined)
	{		
		var temp_obj = document.getElementById(grid_min_max_id);		
		if(temp_obj.length == null)
			min_max_value	=	temp_obj.value;
		else
			min_max_value	=	temp_obj(0).value;
	}
	else
	{	
		min_max_value	=	 numObj.value;
	}
	min_max_array	=	min_max_value.split("|");
	min_num_value	=	min_max_array[0];
	max_num_value	=	min_max_array[1];		
	entered_value	=	numObj.value;
	if(entered_value=="") entered_value = "0";
	if(parseFloat(max_num_value)==0) return false;

	if( parseFloat(entered_value)<parseFloat(min_num_value) || parseFloat(entered_value)>parseFloat(max_num_value) )
	{
		var msg = getMessage("MIN_MAX_VALUE_RANGE","CA");
		msg=msg.replace('(1)',min_num_value);
		msg=msg.replace('(2)',max_num_value);
		alert(msg);

		numObj.select();
		numObj.focus();
		return false;
	}
}


function assignSectionDetails1(curr_sec_hdg_code,curr_child_sec_hdg_code,editor_title,currr_image_linked_yn,operation_mode,result_link_yn,result_link_type,content_type,splty_event_code)
{
	
	//alert(eval("parent.recMatConsDetailsFrame.document.RecMatConsForm"));

var patient_id						="";
var encounter_id					="";
var episode_type					="";
var accession_num					="";
var patient_class					="";

var section_image_content			="";
var section_content					="";
var template_mode					="";
var prev_image_linked_yn			="";
//var section_content					="";
var image_edited_yn					="";
var section_image_content			="";
var prev_sec_hdg_code				="";
var prev_child_sec_hdg_code			="";
var prev_image_linked_yn	 		="";
var note_type			 			="";
var image_hidden_name				="";
var image_hidden_obj				="";

//var section_content					= parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.section_content;

var Obj =parent.recMatConsTabsFrame.document.matConsTabsForm;

//var sec_obj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm;
//setButtonsforOperations(operation_mode,true);
//expandSectionFrames();
//patient_id					=		Obj.patientId.value;
//prev_sec_hdg_code			=		Obj.secHdgCode.value;
//prev_child_sec_hdg_code		=		Obj.subSecHdgCode.value;
//prev_image_linked_yn		=		Obj.prev_image_linked_yn.value;
//note_type					=		Obj.note_type.value;
//episode_type				=		Obj.episode_type.value;
//accession_num				=		Obj.accessionNum.value;
//patient_class				=		Obj.patientClass.value;
//encounter_id				=		Obj.encounterId.value;
//Sex							=		Obj.Sex.value;
//Dob							=		Obj.Dob.value;

	parent.recMatConsTabsFrame.document.matConsTabsForm.prevSecHdgCode.value = parent.recMatConsTabsFrame.document.matConsTabsForm.sec_hdg_code.value;
	parent.recMatConsTabsFrame.document.matConsTabsForm.prevSubSecHdgCode.value = parent.recMatConsTabsFrame.document.matConsTabsForm.sub_sec_hdg_code.value;
//	document.matConsTabsForm.sec_hdg_code.value = secHdgCode;



   // document.matConsTabsForm.prevSecHdgCode.value = document.matConsTabsForm.sec_hdg_code.value;
	//document.matConsTabsForm.prevSubSecHdgCode.value = document.matConsTabsForm.sub_sec_hdg_code.value;
	parent.recMatConsTabsFrame.document.matConsTabsForm.sec_hdg_code.value = curr_sec_hdg_code;
	parent.recMatConsTabsFrame.document.matConsTabsForm.sub_sec_hdg_code.value = curr_child_sec_hdg_code;
	var prevSecHdgCode = parent.recMatConsTabsFrame.document.matConsTabsForm.prevSecHdgCode.value;
	var prevSubSecHdgCode = parent.recMatConsTabsFrame.document.matConsTabsForm.prevSubSecHdgCode.value;
    //alert("prevSecHdgCode"+prevSecHdgCode);
	//alert("prevSubSecHdgCode"+prevSubSecHdgCode);
	var queryString = parent.recMatConsTabsFrame.document.matConsTabsForm.queryString.value;
	var sectionType = parent.recMatConsTabsFrame.document.matConsTabsForm.sectionType.value;
	

if(parent.recMatConsDetailsFrame!=null)
{
	
	if(!recordTemplateDetails())
	{
		if(parent.recMatConsBtnsFrame.document.RecMaternityConsToolbarForm.Record!=null)
		{
			parent.recMatConsBtnsFrame.document.RecMaternityConsToolbarForm.Record.disabled=false;
		}
		if(parent.recMatConsBtnsFrame.document.RecMaternityConsToolbarForm.Save!=null)
		{
			parent.recMatConsBtnsFrame.document.RecMaternityConsToolbarForm.Save.disabled=false;
		}
		alert(getMessage("TEMPLATE_MANDATORY",'CA'));
		
		return false;
		/*bool = confirm(getMessage("TEMP_MANDATORY",'CA'));
			
		if(bool)
		{
			if(template_mode!=null && template_mode.value=="Insert")
			template_mode.value	=	"RemoveTemplate";			
			//expandSectionFrames();
			//messageFrameReference.location.href = '../../eCA/jsp/CAError.jsp';
		}
		else
			return false;*/
	}
}

/*if(prev_image_linked_yn == 'Y' && parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0 != null) 
{
	var txtRange			=	parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.body.createTextRange();
	section_content.value	=	txtRange.htmlText;

}
else if(parent.RecClinicalNotesSecDetailsFrame.RTEditor0!=null)
{
	var txtRange			=	parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.body.createTextRange();
	section_content.value   =	txtRange.htmlText;
}

if(prev_image_linked_yn == 'Y' && parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame != null) 
{
	image_edited_yn = parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame.document.applets["drawing"].IsChanged();
	
	if(Obj.avl_image_selected.value == 'true')
			image_edited_yn = true;

	if(image_edited_yn == true)
	{
		image_edited_yn = "Y";
		section_image_content = parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesMediPainterFrame.document.applets["drawing"].GetImage("JPEG");
		image_hidden_name = "img_"+prev_sec_hdg_code+"_"+prev_child_sec_hdg_code;
		image_hidden_obj = eval("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm."+image_hidden_name);
		image_hidden_obj.value = section_image_content;
		parent.RecClinicalNotesSecControlFrame.document.forms[0].section_image_content.value = section_image_content;
	}
} */

// assigning the current section values as its preveious values in the header form...

Obj.prevSecHdgCode.value			=		curr_sec_hdg_code;			
Obj.prevSubSecHdgCode.value	=		curr_child_sec_hdg_code;
//Obj.prev_image_linked_yn.value		=		currr_image_linked_yn;		
//Obj.prev_sec_result_link_type.value	=		result_link_type;
//Obj.prev_sec_type.value				=		content_type;

var url = "";
var pars = "";
var no_of_rows = "";
no_of_rows = Obj.no_of_rows.value;
var close_episode_yn = parent.recMatConsTabsFrame.document.matConsTabsForm.close_episode_yn.value;
var outcome_event_code = parent.recMatConsTabsFrame.document.matConsTabsForm.outcome_event_code.value;
var outcome_code = parent.recMatConsTabsFrame.document.matConsTabsForm.outcome_code.value;

//alert("no_of_rows --"+no_of_rows+"-- ");

/*if(parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame != null)
{
//		var returnVals = buildXMLParams();

		url = "../../eCA/jsp/RecClinicalNotesSectionControl.jsp?";
		pars ='curr_sec_hdg_code='+curr_sec_hdg_code+'&curr_child_sec_hdg_code='+curr_child_sec_hdg_code+'&prev_sec_hdg_code='+prev_sec_hdg_code+'&prev_child_sec_hdg_code='+prev_child_sec_hdg_code+'&patient_id='+patient_id+'&encounter_id='+encounter_id+'&section_content='+'&editor_title='+editor_title+'&operation_mode='+operation_mode+'&note_type='+note_type+'&image_edited_yn='+image_edited_yn+'&no_of_rows='+no_of_rows+'&episode_type='+episode_type+'&accession_num='+accession_num+'&patient_class='+patient_class+'&encounter_id='+encounter_id+'&Sex='+Sex+'&Dob='+Dob;
//		pars+="&"+returnVals;
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.target = "RecClinicalNotesSecTempControlFrame";
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.method = "POST";
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.action = url+pars;
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.submit();

}
else
{

		url = "../../eCA/jsp/RecClinicalNotesSectionControl.jsp?";
		pars ='curr_sec_hdg_code='+curr_sec_hdg_code+'&curr_child_sec_hdg_code='+curr_child_sec_hdg_code+'&prev_sec_hdg_code='+prev_sec_hdg_code+'&prev_child_sec_hdg_code='+prev_child_sec_hdg_code+'&patient_id='+patient_id+'&encounter_id='+encounter_id+'&editor_title='+editor_title+'&operation_mode='+operation_mode+'&note_type='+note_type+'&image_edited_yn='+image_edited_yn+'&episode_type='+episode_type+'&accession_num='+accession_num+'&patient_class='+patient_class+'&no_of_rows='+no_of_rows+'&encounter_id='+encounter_id+'&Sex='+Sex+'&Dob='+Dob;

		parent.RecClinicalNotesSecControlFrame.document.forms[0].target =	parent.RecClinicalNotesSecControlFrame.name;
		parent.RecClinicalNotesSecControlFrame.document.forms[0].action	=	url+pars;
		parent.RecClinicalNotesSecControlFrame.document.forms[0].method	=	'post';	
		parent.RecClinicalNotesSecControlFrame.document.forms[0].submit();
} */
/*
var myAjax = new Ajax.Updater(
								{success: 'placeholder'},
								url,
								{
								method: 'post',
								parameters: pars,
								onSuccess: callsuccess,
								onFailure: reportError,
								evalScripts: true
								});


*/
	
	if(parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm != null)
	{	
		
		if(sectionType=='OC')
		{
			parent.recMatConsBlankFrame.document.forms[0].target = 'recMatConsBlankFrame';
			parent.recMatConsBlankFrame.document.forms[0].method = 'post';
			parent.recMatConsBlankFrame.document.forms[0].action	=	'../../eCA/jsp/RecMaternityConsControl.jsp?'+queryString+'&sec_hdg_code='+curr_sec_hdg_code+'&sub_sec_hdg_code='+curr_child_sec_hdg_code+'&prevSecHdgCode='+prevSecHdgCode+'&prevSubSecHdgCode='+prevSubSecHdgCode+'&tabClick=Y'+'&no_of_rows='+no_of_rows+'&close_episode_yn='+close_episode_yn+'&outcome_event_code='+outcome_event_code+'&outcome_code='+outcome_code+'&splty_event_code='+splty_event_code;
			//parent.recMatConsBlankFrame.location.href	=	'../../eCA/jsp/RecMaternityConsControl.jsp?'+queryString+'&sec_hdg_code='+curr_sec_hdg_code+'&sub_sec_hdg_code='+curr_child_sec_hdg_code+'&prevSecHdgCode='+prevSecHdgCode+'&prevSubSecHdgCode='+prevSubSecHdgCode+'&tabClick=Y'+'&no_of_rows='+no_of_rows;
			parent.recMatConsBlankFrame.document.forms[0].submit();
		}
		else
		{			
			parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.target = 'recMatConsBlankFrame';
			parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.method = 'post';
			parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.action	=	'../../eCA/jsp/RecMaternityConsControl.jsp?'+queryString+'&sub_sec_hdg_code='+curr_child_sec_hdg_code+'&prevSecHdgCode='+prevSecHdgCode+'&prevSubSecHdgCode='+prevSubSecHdgCode+'&tabClick=Y'+'&no_of_rows='+no_of_rows+'&splty_event_code='+splty_event_code;
			parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.submit();
		}
	}
	else if(parent.recMatConsBlankFrame != null)//parent.recMatConsBlankFrame.document.forms[0]
	{
		
		if(sectionType=='OC')
		{	
			/*parent.recMatConsBlankFrame.document.forms[0].target = 'recMatConsBlankFrame';
			parent.recMatConsBlankFrame.document.forms[0].method = 'post';
			parent.recMatConsBlankFrame.document.forms[0].action	=	'../../eCA/jsp/RecMaternityConsControl.jsp?'+queryString+'&sec_hdg_code='+curr_sec_hdg_code+'&sub_sec_hdg_code='+curr_child_sec_hdg_code+'&prevSecHdgCode='+prevSecHdgCode+'&prevSubSecHdgCode='+prevSubSecHdgCode+'&tabClick=Y'+'&no_of_rows='+no_of_rows+'&close_episode_yn='+close_episode_yn+'&outcome_event_code='+outcome_event_code+'&outcome_code='+outcome_code;
			parent.recMatConsBlankFrame.document.forms[0].submit(); */

			parent.recMatConsBlankFrame.location.href = '../../eCA/jsp/RecMaternityConsControl.jsp?'+queryString+'&sec_hdg_code='+curr_sec_hdg_code+'&sub_sec_hdg_code='+curr_child_sec_hdg_code+'&prevSecHdgCode='+prevSecHdgCode+'&prevSubSecHdgCode='+prevSubSecHdgCode+'&tabClick=Y'+'&no_of_rows='+no_of_rows+'&close_episode_yn='+close_episode_yn+'&outcome_event_code='+outcome_event_code+'&outcome_code='+outcome_code;
		}
		else
		{
			/*parent.recMatConsBlankFrame.document.forms[0].target = 'recMatConsBlankFrame';
			parent.recMatConsBlankFrame.document.forms[0].method = 'post';
			parent.recMatConsBlankFrame.document.forms[0].action	=	'../../eCA/jsp/RecMaternityConsControl.jsp?'+queryString+'&sub_sec_hdg_code='+curr_child_sec_hdg_code+'&prevSecHdgCode='+prevSecHdgCode+'&prevSubSecHdgCode='+prevSubSecHdgCode+'&tabClick=Y'+'&no_of_rows='+no_of_rows;
			parent.recMatConsBlankFrame.document.forms[0].submit(); */
			parent.recMatConsBlankFrame.location.href = '../../eCA/jsp/RecMaternityConsControl.jsp?'+queryString+'&sub_sec_hdg_code='+curr_child_sec_hdg_code+'&prevSecHdgCode='+prevSecHdgCode+'&prevSubSecHdgCode='+prevSubSecHdgCode+'&tabClick=Y'+'&no_of_rows='+no_of_rows ;
		}
	}
	
	
	
	
	
/*	if(operation_mode != "Preview")
	{
		if(result_link_yn == "Y")
			setTimeout("showLinkDocuments('"+curr_sec_hdg_code+"','"+content_type+"', '"+curr_child_sec_hdg_code+"', '"+content_type+"','"+result_link_type+"','"+currr_image_linked_yn+"')",1000);
	}	 */

}


function recordTemplateDetails()
{
		var messageFrameReference = top.content.messageFrame;
	//calling the function for calculating the values for formula component if any 
	//parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.callForLoadingFormulaResults();	  //commented by Hari
	//-------------------------------------------------------------
	if(parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm != null)
	{
	if(parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.mandatory_fields != null)
	{
		var mandatory_fields	=	parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.mandatory_fields.value;
		var mandatory_names		=	escape(parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.mandatory_names.value);
		mandatory_names=unescape(mandatory_names);
		var	list_item_fields	=	parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.list_item_fields.value;
		//alert(mandatory_fields);
		//alert(mandatory_names);
		var	fields		=	new	Array();
		var	names		=	new	Array();
		if(mandatory_fields.length>0)
		{
			var arr_mandatory_fields	=	mandatory_fields.split("|");
			var arr_mandatory_names		=	mandatory_names.split("|");

			for(var i=0; i<arr_mandatory_fields.length; i++)
			{
				//alert("arr_mandatory_fields["+i+"] : "+arr_mandatory_names[i]);
				fields[i]	=	eval("parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm."+arr_mandatory_fields[i]);
				names[i]	=	arr_mandatory_names[i];
			}

			if(checkFields(fields,names,messageFrameReference)==false)
			{
				//settingsForMandatoryFieldsNotEntered();
				return false;
			}
		}
		//added on 1/5/2004 to take care of the mandatory fields from the paragraph
		//taking into mind that maximum of 20 paragraphs r there in the template	
		if(!checkGridMatrix())
		{
			//var temp_error =getMessage("","CA");
			var temp_error = getMessage("MANDATORY_FOR_GC","CA");
			messageFrameReference.document.location.href="../../eCA/jsp/CAError.jsp?err_num=" + temp_error;
			//settingsForMandatoryFieldsNotEntered();
			return false;
		}
		for(var k=0;k<20;k++)
		{
			var str = eval("parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.mandatory_fields_para"+k);
			if(str!=null)
			{
				if(str.value!="")
				{
					var arr = str.value.split("~");
					var paraCompNames = arr[0]; //comp name and srl no (can be many saparated by |)
					var suffixToBeAttached = arr[1];//para name and para count (will be only one)
					if(paraCompNames.length>0)
					{
						var arr_mandatory_fields	=	paraCompNames.split("|");
						for(var i=0; i<arr_mandatory_fields.length; i++)
						{
							if(arr_mandatory_fields[i] != "")				
							fields[i]	=	eval("parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm."+arr_mandatory_fields[i]+suffixToBeAttached);
							//alert(fields[i].value);
						}

						if(checkParaFields(fields,names,messageFrameReference)==false)
						{
							//settingsForMandatoryFieldsNotEntered();
							return false;

						}
					}
				}
			}
			else
			{
				break;
			}
		}
		//added for template containing the disbled components
/*		
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.target = "RecClinicalNotesSecTempControlFrame";
		//alert('submitting from recordTemplateDetails');
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.method = "POST";
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.action = "../../eCA/jsp/RecClinicalNotesTemplateCtrl.jsp";
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.submit();
		*/
	}
}//end of if form obj not null
//	ResetTemplateToolbar();
	return true;
}

 function checkGridMatrix()
{
	var i = 0;
	var grid_names = new Array();
	var final_grid_names_string = "";
	var final_rows_string = "";	
	var grid_component_ids = parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.grid_component_ids.value;
	var gridwise_details = "";
	//alert(grid_component_ids);
	if(grid_component_ids != "")
	{
		gridwise_details = grid_component_ids.split("|");
		for(i=0;i<gridwise_details.length;i++)
		{
			if(i > 0 )
			{
				final_grid_names_string += "|";
				final_rows_string += "|";
			}
			var component_wise_details = gridwise_details[i].split("~");
			var grid_name = component_wise_details[0];
			final_grid_names_string += grid_name;
			grid_names[grid_names.length] = grid_name;
			var grid_obj = parent.recMatConsDetailsFrame.document.getElementById(grid_name);
			final_rows_string += (grid_obj.rows.length-2);
			//alert("final_rows_string" +final_rows_string);
			if(!checkMandatoryFieldsGrid(grid_name))
			{
				//alert("All the mandatory values in " + grid_name + " have not been entered...");
				return false;
			}
		}
	}

	//
	var matrix_names = parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.matrix_names.value;
	
	var matrix_name_temp = matrix_names.split("|");
	if(matrix_names != "")
	{
		for(var i=0;i<matrix_name_temp.length;i++)
		{
			if(eval("parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.matrix_mandatory_fields_"+ matrix_name_temp[i] + ""))
			{
			var matrix_mandatory_names = eval("parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.matrix_mandatory_fields_" + matrix_name_temp[i] + ".value");
			//alert("matrix_mandatory_names=" + matrix_mandatory_names);
			var component_collection = matrix_mandatory_names.split("|");
			for(var j=0;j<component_collection.length;j++)
			{
				//alert(component_collection[j]);
				if(component_collection[j] != "")
				{
					var comp_temp = eval("parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm." + component_collection[j]);
					if(comp_temp.type == "checkbox")
						comp_temp.value = comp_temp.checked?"Y":"";
					if(comp_temp.value == "")
					{
						//alert("All the mandatory values in " + matrix_name_temp[i] + " have not been entered...");
						return false;
					}
				}
			}
		}
		}
	}
	
//	var HTMLval = "<input type=\"hidden\" name=\"no_of_rows\" value = \"" + final_rows_string + "\">";	
	
//alert("final_rows_string====="+final_rows_string);	
	parent.recMatConsTabsFrame.document.matConsTabsForm.no_of_rows.value = final_rows_string;
//	parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.insertAdjacentHTML('afterbegin', HTMLval);	
	
	return true;
}


function checkMandatoryFieldsGrid(grid_name)
{
	var i = 0;
	var mandatory_fields = eval("parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.mandatory_fields_" + grid_name).value;
	var mandatory_fields_array = mandatory_fields.split("|");
	//alert(mandatory_fields_array);
	if(mandatory_fields_array == "")
		return true;
	for(i=0;i<mandatory_fields_array.length;i++)
	{
		//alert(mandatory_fields_array[i]);
		if(mandatory_fields_array[i] != "")
		{
			var components = parent.recMatConsDetailsFrame.document.getElementById(mandatory_fields_array[i]);
			//alert(mandatory_fields_array[i] + "=" + components.length );
			if(components.length != null)
			{
				for(iii=0;iii<components.length;iii++)
				{
					//alert(iii + "=" + components[iii].value);
					if(components[iii].value == "")
						return false;				
				}
			}
			else
			{
				if(components.type == "checkbox")
					components.value = components.checked?"Y":"";
				if(components.value == "")
					return false;
			}
		}
	}	
	return true;
}

//new functions
function dfltTab()
{
	//document.getElementById("search_tab").className = "tabA";
	var count1 = document.getElementById("count").value;
	var modeValue = document.getElementById("modeValue").value;
	var splty_task_code = document.getElementById("splty_task_code").value;

	if(modeValue!='V')
		{
			if(splty_task_code!='MCT002')
				{
					for (var i=1;i<count1 ;++i )
					{	
						var temp1 = document.getElementById('sh_tab'+i); 
						var temp2 = document.getElementById('sh_tabspan'+i); 
						temp1.className = "tabA";
						temp2.className = "tabAspan"; 
					}
				}
			else
				{
				document.getElementById("view_tab").className = "tabA";
				document.getElementById("view_tabspan").className = "tabAspan";
				}
		}
		else if(modeValue == 'V' && splty_task_code == 'MCT002')
		{
			document.getElementById("view_tab").className = "tabA";
			document.getElementById("view_tabspan").className = "tabAspan";
		}
}

function loadMatDetailPage1(secHdgCode,subSecHdgCode,count)
{
	selectTab1(count);
	//alert('..secHdgCode...'+secHdgCode+'..subSecHdgCode...'+subSecHdgCode);
	loadMatDetailPage(secHdgCode,subSecHdgCode);
}

function loadMatDetailPage2(secHdgCode,subSecHdgCode,count)
{
	
	selectTab1(count);
	//loadMatDetailPage(secHdgCode,subSecHdgCode);
}

function loadMatDetailPage3(secHdgCode,subSecHdgCode,id,splty_event_code)
{
	
	selectTab(id);
	if(document.forms[0].modeValue.value != 'V')
		parent.recMatConsBtnsFrame.location.href = '../../eCA/jsp/RecMaternityConsToolbar.jsp';
	loadMatDetailPage(secHdgCode,subSecHdgCode,splty_event_code);
}

function selectTab1(count)
	{
	
		prevTabObj="sh_tab0";
		var tabObj = document.getElementById('sh_tab'+count);
		//alert(tabObj);
		
		if(prevTabObj!=null)
			{
			
				prevTabObj.className="tabA"
				document.getElementById('sh_tabspan'+precount).className="tabAspan"
			}
			tabObj.className="tabClicked"
			document.getElementById('sh_tabspan'+count).className="tabSpanclicked"
			prevTabObj=tabObj;
			precount=count;
			
	}

function closep()

{
	 parent.recMatConsTabsFrame.location.href = '../../eCommon/html/blank.html';
	 parent.recMatConsDetailsFrame.location.href = '../../eCommon/html/blank.html';
	 parent.recMatConsBtnsFrame.location.href = '../../eCommon/html/blank.html';

	 //parent.recMatConsTabsFrame.document.matConsTabsForm.prevSecHdgCode.value
}

function event_allow_yn(allow_yn)
{
	//alert('allow_yn..1.'+allow_yn);
	if(allow_yn==null||allow_yn==''||allow_yn=='MOTHER_CUTOFF_AGE')
	{
		if(allow_yn=='MOTHER_CUTOFF_AGE')
			{
				alert(getMessage(allow_yn,"MP"));
			}
		
		loadTemplate();
	}
	else
	{
		//alert('in event_allow_yn else....');
		alert(getMessage(allow_yn,"MP"))
			return false;
	}

}

function chk_event_status()
{

		
		var patient_id = document.matConsTabsForm.patient_id.value;
		var outcomeval=document.matConsTabsForm.OutCome.value;
		var splty_event_code = parent.recMatConsTabsFrame.document.matConsTabsForm.splty_event_code.value;
	
		var outval_arr = outcomeval.split("~");
	
		//alert('rajan splty_event_code...'+splty_event_code);
		//alert('rajan outval_arr[0]...'+outval_arr[0]);
		if(outval_arr[0]=='MCO003'||outval_arr[0]=='MCO006'||outval_arr[0]=='MCO008'||outval_arr[0]=='MCO007'||outval_arr[0]=='MCO002')
		{
		//alert('shaiju splty_event_code...'+splty_event_code);
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eCA/jsp/RecMaternityConsIntermediate.jsp?patient_id="+patient_id+"&splty_event_code="+splty_event_code+"&outcome_code="+outval_arr[0], false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = eval(responseText);
		}
		else
		{
			loadTemplate();
		}

}


function loadTemplate()

{
	
	var outcomeval=document.matConsTabsForm.OutCome.value;
	
	var outval_arr = outcomeval.split("~");
	
	document.matConsTabsForm.outcome_code.value= outval_arr[0];
	document.matConsTabsForm.close_episode_yn.value= outval_arr[3];
	document.matConsTabsForm.outcome_event_code.value = outval_arr[4];
	var close_episode_yn = parent.recMatConsTabsFrame.document.matConsTabsForm.close_episode_yn.value;
		
	
	if(outval_arr[2]=="")
	{	
		if (close_episode_yn=='Y')
		{
			//getMessage("TEMP_MANDATORY",'CA')
			//var answer = confirm("This outcome will close the curent Cycle.\nDo you like to continue?");
			var answer = confirm(getMessage("OUTCOME_CLOSE_CURR_CYCLE","CA"));
		}
		else if(close_episode_yn=='H')
		{
				
			if(outval_arr[0]=='MCO001')
			{
				var cycle_no=document.matConsTabsForm.cycle_no.value;
				var module_id=document.matConsTabsForm.module_id.value;
				var patient_id=document.matConsTabsForm.patient_id.value;
				var splty_event_code=document.matConsTabsForm.splty_event_code.value;
				
				//alert('shaiju splty_event_code...'+splty_event_code);
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				xmlStr	="<root><SEARCH " ;
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml"); 
				xmlHttp.open( "POST","../../eCA/jsp/RecMaternityConsIntermediate.jsp?NBmode=ADDLEVNT&patient_id="+patient_id+"&splty_event_code="+splty_event_code+"&outcome_code="+outval_arr[0]+"&cycle_no="+cycle_no+"&module_id="+module_id, false);
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				responseText = eval(responseText);
			}

			var answer =false;
				
				
				//var answer = true ;//confirm("This outcome will close current Event.\nDo you like to continue?");
				//var answer = confirm(getMessage("OUTCOME_CLOSE_CURR_CYCLE","CA"));
				//setTimeout('',1000);
		}
		else 
		{
			//var answer = confirm("This outcome will close current Event and create new Event.\nDo you like to continue?");
			var answer = confirm(getMessage("OUTCOME_CLOSE_CURR_EVENT","CA"));
		}
		if(answer==true)
			closeEvent();	
		else
		{
			 document.matConsTabsForm.OutCome.options[0].selected=true;
			 parent.recMatConsDetailsFrame.location.href = '../../eCommon/html/blank.html';
		}
	}
	else
	{
		loadMatDetailPage(outval_arr[2],outval_arr[2]);
	}

}
function event_close_addlEvnt(additional_event_yn)
{

	if(additional_event_yn=='Y')
	{
       parent.recMatConsTabsFrame.document.matConsTabsForm.close_episode_yn.value='Y';
	   alert(getMessage("OUTCOME_CLOSE_CURR_CYCLE","CA"));

	}
		
	 	 	
	  closeEvent();	
	

	

}

function event_close_delv_yn(allow_yn)
{
		  var queryString = parent.recMatConsTabsFrame.document.matConsTabsForm.queryString.value;
		  var close_episode_yn = parent.recMatConsTabsFrame.document.matConsTabsForm.close_episode_yn.value;
		  var outcome_event_code = parent.recMatConsTabsFrame.document.matConsTabsForm.outcome_event_code.value;
		  var outcome_code = parent.recMatConsTabsFrame.document.matConsTabsForm.outcome_code.value;
	
	if(allow_yn=='Y')
	{

		
		  
			if(parent.recMatConsBlankFrame!=null)
			{
					//alert('in if...');
					parent.recMatConsBlankFrame.location.href ='../../eCA/jsp/RecMaternityConsControl.jsp?'+queryString+'&tabClick=N&close_episode_yn='+close_episode_yn+'&outcome_event_code='+outcome_event_code+'&closeFlag=Y&outcome_code='+outcome_code;
			}

	}
	else
	{
		
		bool = confirm(getMessage("DEL_STAGES_NOT_FINALIZED","CA"));

		if(bool)
		{
			if(parent.recMatConsBlankFrame!=null)
			{
					//alert('in if...');
					parent.recMatConsBlankFrame.location.href ='../../eCA/jsp/RecMaternityConsControl.jsp?'+queryString+'&tabClick=N&close_episode_yn='+close_episode_yn+'&outcome_event_code='+outcome_event_code+'&closeFlag=Y&outcome_code='+outcome_code;
			}


		}
		else
		{

			return false;
		
		}


	}

}


function event_close_yn(allow_yn)
{
	//alert('allow_yn..in close evnt...'+allow_yn);
	if(allow_yn=='Y')
	{
		 
			 var splty_event_code = parent.recMatConsTabsFrame.document.matConsTabsForm.splty_event_code.value;
			 var queryString = parent.recMatConsTabsFrame.document.matConsTabsForm.queryString.value;
		  
			if((splty_event_code=='MCE008')||(splty_event_code=='MCE009'))
			{
				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				xmlStr	="<root><SEARCH " ;
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST","../../eCA/jsp/RecMaternityConsIntermediate.jsp?"+queryString+"&NBmode=ChkDS", false);
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				responseText = eval(responseText);

			} 
		  
		  
		  /*
		  
		  var close_episode_yn = parent.recMatConsTabsFrame.document.matConsTabsForm.close_episode_yn.value;
		  var outcome_event_code = parent.recMatConsTabsFrame.document.matConsTabsForm.outcome_event_code.value;
		  var outcome_code = parent.recMatConsTabsFrame.document.matConsTabsForm.outcome_code.value;
		  
		  if(parent.recMatConsBlankFrame!=null)
			{
					//alert('in if...');
					parent.recMatConsBlankFrame.location.href ='../../eCA/jsp/RecMaternityConsControl.jsp?'+queryString+'&tabClick=N&close_episode_yn='+close_episode_yn+'&outcome_event_code='+outcome_event_code+'&closeFlag=Y&outcome_code='+outcome_code;
			}*/
	}
	else
	{

		alert(getMessage("REGN_NEWBORN_BFR_CLOSE","CA"));
		return false;

	}


}



function closeEvent()
{
 
  
  var queryString = parent.recMatConsTabsFrame.document.matConsTabsForm.queryString.value;
  var close_episode_yn = parent.recMatConsTabsFrame.document.matConsTabsForm.close_episode_yn.value;
  var outcome_event_code = parent.recMatConsTabsFrame.document.matConsTabsForm.outcome_event_code.value;
  var outcome_code = parent.recMatConsTabsFrame.document.matConsTabsForm.outcome_code.value;
  var splty_event_code = parent.recMatConsTabsFrame.document.matConsTabsForm.splty_event_code.value;
  
		//alert('queryString...'+queryString+'..close_episode_yn...'+close_episode_yn+'..outcome_event_code...'+outcome_event_code+'...outcome_code....'+outcome_code);
		//alert('..splty_event_code....'+splty_event_code);
		
		if((splty_event_code=='MCE008')||(splty_event_code=='MCE009'))
		{
			//alert('...if...');
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr	="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST","../../eCA/jsp/RecMaternityConsIntermediate.jsp?"+queryString+"&NBmode=ChkNB", false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText = eval(responseText);

		}
		else
		{
			//alert('...in else...');
		//if(parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm!=null)
			if(parent.recMatConsBlankFrame!=null)
			{
				/*parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.action='../../eCA/jsp/RecMaternityConsControl.jsp?'+queryString+'&tabClick=N&close_episode_yn='+close_episode_yn+'&outcome_event_code='+outcome_event_code+'&closeFlag=Y&outcome_code='+outcome_code;
				parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.target='recMatConsBlankFrame';
				parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.method='post';
				parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.submit();
				*/
				parent.recMatConsBlankFrame.location.href ='../../eCA/jsp/RecMaternityConsControl.jsp?'+queryString+'&tabClick=N&close_episode_yn='+close_episode_yn+'&outcome_event_code='+outcome_event_code+'&closeFlag=Y&outcome_code='+outcome_code;
			}
		}
	
		
}

function loadMatViewPage(secHdgCode,subSecHdgCode,id)
{	
	prevTabObj="record_tab";
	selectTab(id);  
	var queryString =parent.recMatConsTabsFrame.document.matConsTabsForm.queryString.value;

	parent.recMatConsDetailsFrame.location.href = '../../eCA/jsp/ViewSpecialtyEventHist.jsp?'+queryString;
	if(document.forms[0].modeValue.value != 'V')
		parent.recMatConsBtnsFrame.location.href = '../../eCA/jsp/RecMaternityConsToolbar.jsp?modeValue=V';
}

/*function selectTab2(tabObj){
	
//	alert(tabObj);
		if(prevTabObj!=null){
				eval("document.all."+prevTabObj).className="tabA"
				eval("document.all."+prevTabObj+"span").className="tabAspan"
			}
			eval("document.all."+tabObj).className="tabClicked"
			eval("document.all."+tabObj+"span").className="tabSpanclicked"
			prevTabObj=tabObj
}*/

function callview(sub_act_code,splty_task_type,cycle_no,splt_event_code,splty_task_code,accessionNum,i)

{	hideShowNodes(i);
	//alert(sub_act_code+"..."+splty_task_type+"..."+cycle_no+"..."+splt_event_code+"..."+splty_task_code);
	var queryString =document.maternityMenu.queryString.value;

	//alert("queryString.."+queryString); MC1601
	
	top.content.workAreaFrame.location.href='../../eCA/jsp/RecMaternityCons.jsp?'+queryString+'&sec_hdg_code=MC00&sectionType=TG&cycle_no='+cycle_no+'&splty_event_code='+splt_event_code+'&splty_task_code='+splty_task_code+'&accessionNum='+accessionNum+'&modeValue=V&HRmode=H';
	//top.content.workAreaFrame.location.href='../../eCA/jsp/RecMaternityCons.jsp?sec_hdg_code=MC00&sectionType=TG&module_id=MC&option_id=MT_CONSULT1&patient_id=EH00001721&visit_id=&episode_id=100061000001&encounter_id=100061000001&location_code=EMER&location_type=C&bed_num=&room_num=&episode_type=O&discharge_date=&visit_adm_date=01/10/2007%2011:39&episode_Status=04&Sex=F&Age=34Y&Dob=01/10/1973&security_level=&protection_ind=&reln_req_yn=N&patient_class=EM&PQ=Y&CA=Y&from_service_yn=&accession_number=&accession_type=&mode=R&RelnYn=&RelnReqYn=&relationship_id=&window_name=&child_window=Y&child_window=Y&limit_function_id=&chartTitle=&reln_req_yn=N&limit_function_id=&cycle_no=1&splty_event_code=MCE004&splty_task_code=MCT001&trns_datettime=02/10/2007 10:05&accessionNum=MC1601&modeValue=V'
}


async function showPendingTasks()
{
	var queryString = document.recMaternityOCForcedCompForm.queryString.value;
	var dialogTop		=	"150" ;
	var dialogHeight= "25" ;
    var dialogWidth = "40" ;
	var status			=	"no";
	var arguments		=	"" ;
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	'../../eCA/jsp/RecMaternityPendingTasksMain.jsp?'+queryString;
	var retVal=await window.showModalDialog(action_url,arguments,features);
	if(retVal != null && retVal != undefined)
		location.href = '../../eCA/jsp/RecMaternityCons.jsp?'+queryString;
}

function checkAll(obj)
{	
	var count = document.recMaternityPendingTasksForm.count.value;
	var chkboxObj;
	if(obj.checked == true)
	{
		for(var t=0;t<parseInt(count,10);t++)
		{
			chkboxObj = document.getElementById('forceClose'+t);
			if(chkboxObj != null)
				chkboxObj.checked = true;
		}
	}
	else
	{
		for(var t=0;t<parseInt(count,10);t++)
		{
			chkboxObj = document.getElementById('forceClose'+t);
			if(chkboxObj != null)
				chkboxObj.checked = false;
		}
	}
}

function recordForcedClose()
{
	var count = parent.recMatPendingTasksListFrame.document.recMaternityPendingTasksForm.count.value;
	var chkBoxObj;
	var tempCnt = 0;
	for(var t=0;t<parseInt(count,10);t++)
	{
		chkBoxObj = eval("parent.recMatPendingTasksListFrame.document.recMaternityPendingTasksForm.forceClose"+t);
		if(chkBoxObj != null)
		{
			if(chkBoxObj.checked == true)
			{
				tempCnt++;
			}
		}
	}

	//if(tempCnt == count)
	{
		window.returnValue = 'OK';
		window.close();
	}
	/*else
	{
		alert('All tasks are not selected...');	
		return false;
	}*/
}

async function showDetial(acessionNum,outcomedesc,patient_id)
{
	//alert("acessionNum"+acessionNum);
	var retVal = 	new String();
	var dialogHeight= "38" ;
	var dialogWidth	= "60" ;
	var status = "no";
	var tit="Event Group";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=yes; status:" + status;
	retVal =await window.showModalDialog("../../eCA/jsp/OutComeFrame.jsp?accessionNum="+acessionNum+"&outcomedesc="+outcomedesc+"&patient_id="+patient_id,arguments,features);
}

async function funPrint()
{
		 var obj = parent.outcomeDetail.document.OutcomeDetailViewForm;
	  	 var 	accession_num =obj.accession_num.value;
		var outcomedesc= obj.outcomedesc.value;
		var patient_id= obj.patient_id.value;
		// alert("outcomedesc===="+outcomedesc);
		 var dialogTop	= "60";
		 var dialogHeight	= "34" ;
		 var dialogWidth	= "50" ;
		 var features	="dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		 retVal =await window.showModalDialog("../../eCA/jsp/OutComePrinting.jsp?accession_num="+accession_num+"&outcomedesc="+outcomedesc+"&patient_id="+patient_id,arguments,features);
		 
}

  function funClose()
	{
		parent.close();
	}


