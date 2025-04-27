/*
-----------------------------------------------------------------------------------------------
Date       		Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             	100         ?           	created
13/11/2013		IN044955	Ramesh G		When recording the OT Recovery notes script errors
-----------------------------------------------------------------------------------------------
*/
function onBlurEvent2()
{
	var firstComponent;
	var secondComponent;
	//alert('xx');
	if (document.RecClinicalNotesTemplateForm.systemDate99999A != null){
		firstComponent = document.RecClinicalNotesTemplateForm.systemDate99999A.value;
	}
	if (document.RecClinicalNotesTemplateForm.C_LMP13 != null){
		secondComponent = document.RecClinicalNotesTemplateForm.C_LMP13.value;
	}
	if (firstComponent != null && secondComponent != null){
		var messageFrameReference = getMessageFrame();	
		if(messageFrameReference != null)	
		{		
			var HTML = '&lt;form name="DateFormulaComputationForm" action="../../eCA/jsp/RecClinicalNotesComputeDateFormula.jsp" >';
			HTML += '&lt;input type="hidden" name = "firstComponent" value = "' + firstComponent + '">';		HTML += '&lt;input type="hidden" name = "secondComponent" value = "' + secondComponent + '">';		HTML += '&lt;input type="hidden" name = "formulaResultUnit" value = "Days">';
			HTML += '&lt;input type="hidden" name = "formulaCompID" value = "C_MC01GESTNAGE20">';
			HTML += '&lt;input type="hidden" name = "formula_result_type" value = "N">';
			HTML += '&lt;input type="hidden" name = "formula_operator" value = "MINUS">';
			HTML += '&lt;/form>';
			messageFrameReference.document.body.insertAdjacentHTML('afterbegin', HTML);		messageFrameReference.document.DateFormulaComputationForm.submit();
		}
	}
}

function onBlurEvent(x)
{
	var firstComponent;var secondComponent;
	if (document.RecClinicalNotesTemplateForm.C_LMP13 != null){ 
		firstComponent = document.RecClinicalNotesTemplateForm.C_LMP13.value;
	}
	secondComponent = 40;
	if (firstComponent != null && secondComponent != null){ 
		var messageFrameReference = getMessageFrame();
		if(messageFrameReference != null) { 
			var HTML = '<form name="DateFormulaComputationForm" id="DateFormulaComputationForm" action="../../eCA/jsp/RecClinicalNotesComputeDateFormula.jsp" >'; HTML += '<input type="hidden" name = "firstComponent" value = "' + firstComponent + '">'; HTML += '<input type="hidden" name = "secondComponent" value = "' + secondComponent + '">'; HTML += '<input type="hidden" name = "formulaResultUnit" value = "Weeks">'; HTML += '<input type="hidden" name = "formulaCompID" value = "C_EDD14">'; HTML += '<input type="hidden" name = "formula_result_type" value = "D">'; HTML += '<input type="hidden" name = "formula_operator" value = "PLUS">'; HTML += '</form>'; messageFrameReference.document.body.insertAdjacentHTML('afterbegin', HTML); messageFrameReference.document.DateFormulaComputationForm.submit(); 
		}
	}
	//alert();
	onBlurEvent2();
	
	return x;
} 
// Added by Sridhar Reddy on 19/10/2009 PMG20089-CRF-0690
function CheckValidDate(obj,edd_val,cr_edd_paramval,p_min_gestation,p_max_gestation,p_gestation_unit)
{		
	
	
	var objName = obj.name;
	var xy = "C_MC01CORRECTDEDD";
	var temp_lmp = "";
	
	if (objName.length >= 17)
	{
		if(objName.substring(2,17) == "MC01CORRECTDEDD")
		{
			if(CheckDate(obj))
			{	
				if (obj.value != "")
				{
					if (document.RecClinicalNotesTemplateForm != null)
					{									
						var locale = document.RecClinicalNotesTemplateForm.locale.value
						var formObj = document.RecClinicalNotesTemplateForm;
						var nodeList = formObj.elements.length;
						var currentDate = getCurrentDate("DMY","en");
												
					/*	if(isAfter(convertDate( minusDate(obj.value,"DMY",locale,40,"w"),"DMY",locale,"en"),currentDate,"DMY",locale))
						{
								var msg = getMessage("INVALID_CORR_EDD",'CA');
								alert(msg);											
								obj.focus();
								return false;
						}*/
						
						for (var i=0; i<nodeList;i++ )
						{
							var compObj = formObj.elements[i];
							
							
							if (compObj.type == 'text')
							{
								if(compObj.name.length >= 9 && compObj.name.substring(0,9) == 'C_MC01LMP')
								{
									
									if (compObj.value == "")
									{											
										var v_lmp = minusDate(obj.value,"DMY",locale,40,"w");
										compObj.value = v_lmp;	
									}	
									if (compObj.value != "")
									{
										
										if(!isBeforeNow(compObj.value,"DMY",locale))
										{										
											return false;
										}
										temp_lmp = convertDate(compObj.value,"DMY",locale,"en");									
										temp_corr_edd = convertDate(obj.value,"DMY",locale,"en");									
										var gestation_age =  daysBetween(temp_lmp,temp_corr_edd,"DMY",locale);
										
										if (p_gestation_unit == "W" || p_gestation_unit == "w")
										{
											p_min_gestation  = parseInt(p_min_gestation * 7);
											p_max_gestation  = parseInt(p_max_gestation * 7);
										}else
										{
											p_min_gestation  = parseInt(p_min_gestation * 1);
											p_max_gestation  = parseInt(p_max_gestation *1);
										}													
													
										if (p_min_gestation > gestation_age)
										{											
											var msg = getMessage("INVALID_CORR_EDD",'CA');
											alert(msg);											
											obj.focus();
											return false;
										}else if (gestation_age > p_max_gestation)
										{											
											var msg = getMessage("INVALID_CORR_EDD",'CA');
											alert(msg);											
											obj.focus();
											return false;
										}
									}
								}else if(compObj.name.length >= 9 && compObj.name.substring(0,14) == 'C_MC01GESTNAGE')
								{
									if (compObj.value == "")
									{						
										
										temp_lmp = convertDate(v_lmp,"DMY",locale,"en");
										var cal_gest_age = daysBetween(temp_lmp,currentDate,'DMY',locale);		
										
										if (p_gestation_unit == "W" || p_gestation_unit == "w")
										{
											var ga_weeks = parseInt(cal_gest_age/7);
											
											var ga_days = parseInt(cal_gest_age%7);			
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
											
										}else{
											if(parseInt(cal_gest_age) == 1)
												cal_gest_age +=" Day";
											else
												cal_gest_age +=" Days";											
										}
										compObj.value = cal_gest_age;
									}										
								}else if(compObj.name.length >= 9 && compObj.name.substring(0,9) == 'C_MC01EDD')
								{																	
									if (compObj.value == "")
									{		
										//compObj.value = plusDate(temp_lmp,"DMY","en",40,"w");
										compObj.value =obj.value;
									}	
									edd_val =compObj.value;
																				
								}			
							
							} 					
							
						}						
						if (edd_val != undefined && cr_edd_paramval != undefined)
						{					
							if (edd_val != "")
							{
								var daysBetween1 = daysBetween(edd_val,obj.value,'DMY',locale);	
								if (cr_edd_paramval.charAt(0) == "0")
								{
									cr_edd_paramval = cr_edd_paramval.substring(1,cr_edd_paramval.length);				
								}								
								if (parseInt(cr_edd_paramval) < Math.abs(parseInt(daysBetween1)))
								{
									var msg = getMessage("INVALID_CORRECTED_EDD",'CA');
									msg = msg.replace("#",cr_edd_paramval);
									alert(msg);
									obj.focus();
									return false;
								}
							}													
						}
					}					
				}
			}
		}
	}
}
//end
function getFormulaResult1(obj,current_item_code,current_item_Srlno,inputComp,p_min_gestation,p_max_gestation,p_gestation_unit)

{   //inputComp="MC01LMP22";				

	var inputComp_array
	var temp= new Array();
	var locale = document.RecClinicalNotesTemplateForm.locale.value
	
	if (CheckDate(obj))
	{
		var xy = "C_MC01LMP";
		objName = obj.name;
		if (objName.length >= 9)
		{
			if(objName.substring(2,12) == "MC01PATLMP")
			{
				if (obj.value != '')
				{
					if(!isBeforeNow(obj.value,"DMY",locale))
					{
						var msg = getMessage("FROM_DATE_GREATER_SYSDATE","CA");
						msg = msg.replace("From", "LMP as per Patient");
						msg = msg.replace("Current", "System");
						alert(msg);
						obj.focus();
						return false;
					}
					if (document.RecClinicalNotesTemplateForm != null)
					{											
						var formObj = document.RecClinicalNotesTemplateForm;
						var nodeList = formObj.elements.length;
						
						for (var i=0; i<nodeList;i++ )
						{
							var compObj = formObj.elements[i];
							if (compObj.type == 'text')
							{								
								if(compObj.name.length >= 9 && compObj.name.substring(0,9) == 'C_MC01LMP')
								{
									if (compObj.value == "")
									{
										compObj.value = obj.value;
									}
								}
							}
						
						}
					}

				}							
			}else if(objName.substring(2,9) == "MC01LMP")
			{
				if (obj.value != '')
				{
					if(!isBeforeNow(obj.value,"DMY",locale))
					{
						var msg = getMessage("FROM_DATE_GREATER_SYSDATE","CA");
						msg = msg.replace("From", "Corrected LMP");
						msg = msg.replace("Current", "System");
						alert(msg);
						obj.focus();
						return false;
					}
					var currentDate = getCurrentDate("DMY",locale);					
					var gestation_age =  daysBetween(obj.value,currentDate,"DMY",locale);
					var temp_gestation_age = weeksBetween(obj.value,currentDate,"DMY",locale);

					if (p_gestation_unit == "W" || p_gestation_unit == "w")
					{
						temp_max_gestation = p_max_gestation;
						p_min_gestation  = parseInt(p_min_gestation * 7);
						p_max_gestation  = parseInt(p_max_gestation * 7);
					}else
					{
						p_min_gestation  = parseInt(p_min_gestation * 1);
						p_max_gestation  = parseInt(p_max_gestation *1);
						temp_max_gestation = p_max_gestation / 7;
					}						
				}else{
					if (document.RecClinicalNotesTemplateForm != null)
					{	
						var formObj = document.RecClinicalNotesTemplateForm;
						var nodeList = formObj.elements.length;
						for (var i=0; i<nodeList;i++ )
						{
							var compObj = formObj.elements[i];
							
							if(compObj.name.length >= 9 && compObj.name.substring(0,14) == 'C_MC01GESTNAGE')
							{
								compObj.value = "";									
							}else if(compObj.name.length >= 9 && compObj.name.substring(0,9) == 'C_MC01EDD')
							{		
								compObj.value = "";		
							}else if(compObj.name.length >= 9 && compObj.name.substring(0,17) == 'C_MC01CORRECTDEDD')
							{		
								compObj.value = "";		
							}
						}
					
					}
				
				}
					
			}
		
		}
		if(inputComp!="")
		{
			inputComp_array = inputComp.split('~');
			
			for(var i=0;i<inputComp_array.length;++i)
			{
				temp[i]=eval("document.RecClinicalNotesTemplateForm.C_"+inputComp_array[i]+".value");
			}
			

		}

		var sec_hdg_code ;
		if (document.RecClinicalNotesTemplateForm.subSecHdgCode != null)
		{ 
			sec_hdg_code = document.RecClinicalNotesTemplateForm.subSecHdgCode.value;
		}
		
		 if(obj.value!=null && obj.value!="")
		 {
			 var messageFrameReference = getMessageFrame(); 
			  if(messageFrameReference != null) 
			  {
				  var HTML = '<form name="DateFormulaComputationForm" id="DateFormulaComputationForm" 	action="../../eCA/jsp/MaternityConsPerformAction.jsp" >'; 
					HTML += '<input type="hidden" name = "sec_hdg_code" value = "' + sec_hdg_code + '">'; 
					HTML += '<input type="hidden" name = "action_item_val" value = "' + obj.value + '">'; 
					HTML += '<input type="hidden" name = "action_item_code" value = "' + current_item_code + '">'; 
					HTML += '<input type="hidden" name = "action_item_srlno" value = "' + current_item_Srlno + '">'; 
					if(inputComp!="")
					{
						for(var j=0;j<temp.length;++j)
						HTML += '<input type="hidden" name = "'+inputComp_array[j]+'" value = "' + temp[j]+ '">'; 
					}
					HTML += '<input type="hidden" name = "inputComp" value = "' + inputComp + '">'; 

					HTML += '</form>'; 
					
					if(messageFrameReference.document.body != null) //by deepa, on 1st of Oct at 1:29 PM
					{
						messageFrameReference.document.body.insertAdjacentHTML('afterbegin', HTML); 
						messageFrameReference.document.DateFormulaComputationForm.submit(); 
					}//by deepa, on 1st of Oct at 1:29 PM
				}
		  }
	}
}


function roundNumber(number,decimal_points)
{
	if(number==undefined ) number=0;  //IN044955
	if(!decimal_points) return Math.round(number); 
	if(number == 0)
	{
		var decimals = '';
		for(var i=0;i<decimal_points;i++) decimals += '0';
		return '0.'+decimals;
	}
	//var exponent = Math.pow(10,decimal_points);// IN044211
	//var num = Math.round((number * exponent)).toString();// IN044211
	//return num.slice(0,-1*decimal_points) + '.' + num.slice(-1*decimal_points);// IN044211
	return number.toFixed(decimal_points);	// IN044211 
}

function allowValidChar()
{
 var strCheck='=+-.';
   var whichCode = (window.Event) ? event.which : event.keyCode;
   key = String.fromCharCode(whichCode);  
   if (strCheck.indexOf(key) != -1) 
		return false;
}


function checkValid(obj,event,val1,val2) 
{
	if (event.keyCode == 13) 
	{
		event.keyCode = "";
		return;
	} 
	else 
	{
		return allowValidNumber(obj,event,val1,val2);
	}
}

