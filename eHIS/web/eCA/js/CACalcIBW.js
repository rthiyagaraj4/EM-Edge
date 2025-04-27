function calWt(formObj) {
	var weight = formObj.wtInput.value;
	if ( weight > 0) {
		if (formObj.wtUnits.selectedIndex == 1) {	// 0 = pounds.
			formObj.wtInput.value = rounding( weight / 0.45359237,8);
		} else {								// 1 = kilograms.
			if (weight > 219) {
				formObj.wtInput.value = rounding( weight * 0.45359237,8);
			} else {
				formObj.wtInput.value = rounding( weight * 0.45359237,8);
			}
		}
		formObj.wtInput.select()
		formObj.wtInput.focus()
	}
	return true;
}
function rounding(number,decimal) {
	multi = Math.pow(10,decimal);
	number = Math.round(number * multi) / multi;
	return number;
}

function calHt(formObj){
	
	var height = formObj.htInput.value;
	if (height > 0) {
		if (formObj.htUnits.selectedIndex == 1) { // is now inches, was cm.
			//setFeetAndInches(formObj, height / 2.54); 
			setFeetAndInches(formObj, height *0.39 ); 
			//formObj.htInput.value = rounding( height / 2.54,8) ; 
			formObj.htInput.value = rounding( height*0.39 ,8) ; 
		} else {								// is now cm, was inches.
			setFeetAndInches(formObj, height);  // Always pass inches in height to this function.
			//formObj.htInput.value = rounding( height * 2.54,8);
			formObj.htInput.value = rounding( height/0.39 ,8);
			
			}  
		formObj.htInput.select()
		formObj.htInput.focus()
	}
	return true;

}
function callsetFeetAndInches(formObj)
{
	var height = formObj.htInput.value;
	if (height > 0) {
		if (formObj.htUnits.selectedIndex == 1) { // is now inches, was cm.
			setFeetAndInches(formObj, height ); 
			//formObj.htInput.value = rounding( height / 2.54,8) ; 
		} else {		
								// is now cm, was inches.
			//setFeetAndInches(formObj, Math.ceil(height/ 2.54));  // Always pass inches in height to this function.
			//setFeetAndInches(formObj, Math.ceil(height*0.39));  // Always pass inches in height to this function.
			setFeetAndInches(formObj, height*0.39);  // Always pass inches in height to this function.
			//formObj.htInput.value = rounding( height * 2.54,8);  }  
		//formObj.htInput.select()
		//formObj.htInput.focus()
	}
	return true;

	}
	else
	{
		formObj.htInFt.selectedIndex=0;
		formObj.htInInch.selectedIndex=0;
		formObj.IBW.value='';
		
	}
}
function setFeetAndInches(formObj,inchies) {
	
	var feet = Math.min( Math.max( Math.floor( inchies / 12 ), 1), 7);
	formObj.htInFt.selectedIndex = feet - 1;

	inchies = rounding( inchies - feet*12,8);
	formObj.htInInch.selectedIndex = Math.min( Math.max( inchies,0), 11 );
	return true;
}

function feetAndInches(formObj) {
	var inchies = 0;
	inchies = ((formObj.htInFt.selectedIndex+1) * 12) + formObj.htInInch.selectedIndex;

	if (formObj.htUnits.selectedIndex == 1) formObj.htInput.value = inchies;
	//if (formObj.htUnits.selectedIndex == 0) formObj.htInput.value = rounding( inchies * 2.54,0);
	if (formObj.htUnits.selectedIndex == 0) formObj.htInput.value = rounding( inchies/0.39 ,8);
	return true;
}
function calAge(formObj) {
	//if (formObj.ageInput.value > 0) {	// Only change the Age field, if a value is already there.
	
		if (formObj.ageRng.selectedIndex == 0) { // 70+ years,
			formObj.ageInput.value = 75;
		} else {
			if (formObj.ageRng.selectedIndex < 6) { // 1 thru 5 are decades 20s thru 60s.
				formObj.ageInput.value = 65 - (formObj.ageRng.selectedIndex -1)*10;
			} else {
				if (formObj.ageRng.selectedIndex == 6 ) {
					formObj.ageInput.value = 19;
				} else {
					if (formObj.ageRng.selectedIndex < 23) { // 7 thru 22 are ages 17 thru 2.
						formObj.ageInput.value = 17 - (formObj.ageRng.selectedIndex-7);
					} else {
						if (formObj.ageRng.selectedIndex == 23) { // age 1.5 yrs.
							formObj.ageInput.value = 1.5;
						} else {
							if (formObj.ageRng.selectedIndex == 24) {	// age 1 yrs.
								formObj.ageInput.value = 1;
							} else {
								if (formObj.ageRng.selectedIndex == 25) {
									formObj.ageInput.value = 30;
								} else {
									if (formObj.ageInput.value > 19) formObj.ageInput.value = "";
								}
							}
						}
					}
				}
			}
		}
	//}
	return true;
}

function calculateIBW(formObj) {
	var Age = formObj.ageInput.value;

	var weight =  formObj.wtInput.value;

	var formula_ref_id = document.getElementById("formula_ref_id").value;
	
	if (!checkWeight(weight)) return false;
	if (formObj.wtUnits.selectedIndex == 1) {	// 0 = weight in lbs
		kg = weight * 0.45359237;
	} else {								// 1 = weight in kg.
		kg = weight;
	}
	/*if (kg < 10) {
		//alert("Weights should be heavier than 10 kilograms (22 pounds).");
		alert(getMessage("MIN_WEIGHT","CA"));
		return false;
	}
	if (kg > 200) {
		//alert("Weights should be lighter than 200 kilograms (441 pounds).");
		alert(getMessage("MAX_WEIGHT","CA"));
		return false;
	}*/

	var height =  formObj.htInput.value;

	if ((isNaN(height)) || (height == null)  || (height == "") || (height < 0)) {
		feetAndInches(formObj);
		height =  formObj.htInput.value;
	}

	if (formObj.htUnits.selectedIndex == 1) {		//  if height units are "inches"
		heightInches = height;
		//heightMeters = height * 2.54 / 100;
		heightMeters = height/(0.39 *  100);
	} else {									// else if height units are "cm".
		//heightInches = height / 2.54;
		heightInches = height * 0.39;
		heightMeters = height / 100;
	}
	/*
	if (heightMeters < 0.33) {
		alert(getMessage("MIN_HEIGHT","CA"));
		//alert("Heights should be taller than 33 centimeters (31.5 inches).");
		return false;
	}
	if (heightMeters > 2.41) {
		//alert("Heights should be shorter than 241 centimeters ( 7 feet, 11 inches).");
		alert(getMessage("MAX_HEIGHT","CA"));
		return false;
	} */
	setFeetAndInches(formObj,heightInches);

	if(formula_ref_id=="DE")
		{
	
	if ((isNaN(Age)) || (Age == null)  || (Age == "")) {
		Age = GetAge(formObj);
		if (formObj.ageRng.selectedIndex == 26) {
			//alert("Please enter a specific age for a child.");
				var msg = getMessage("AGE_CANT_BLANK","CA");
				msg = msg.replace('$$',getLabel('eCA.Child.label','CA'))
				alert(msg);	
			return false;
		}else if (formObj.ageRng.selectedIndex == 25) {
			//alert("Please enter a specific age for an adult.");
				var msg = getMessage("AGE_CANT_BLANK","CA");
				msg = msg.replace('$$',getLabel('Common.Adult.label','COMMON'))
				alert(msg);
			return false;
		}
	} else {
		if ( Age < 1 ) {

		/*	//alert("Ages younger than 1 year old are too young for this calculation. Sorry.");
			alert(getMessage("MIN_AGE","CA"));
				
			return false; */
		} else {
			if (Age > 120) { /*
				//alert("All ages from 70 to 120 are treated as age 75.");
				alert(getMessage("MAX_AGE","CA"));
				
				return false; */
			}
		}
		if (Age > 18) {
			formObj.ageRng.selectedIndex = 25;	// Set menu to "Adult"
		} else {
			formObj.ageRng.selectedIndex = 26;	// Set menu to "Child".
		}
	}
		}
 
// Calculate IBW using Devine formulas.
	
	var idKg="";
	var exwt="";
	//if(formObj.ageRng.selectedIndex == 25){
		if (formObj.gender.selectedIndex == 1)  {  // sex is female.
			
			if(formula_ref_id=="DE")
			{
				idPivot = 45.5;
				idSlope = 2.3;

			}
			else if(formula_ref_id=="RO")
			{
				idPivot = 49.0;
				idSlope = 1.7;
			}
			else if(formula_ref_id=="MI")
			{
				idPivot = 53.1;
				idSlope = 1.36;

			}
			//idPivot = 45.5;
			//idSlope = 2.3;
		} else {								// sex is male.

			if(formula_ref_id=="DE")
			{
				idPivot = 50;
				idSlope = 2.3;

			}
			else if(formula_ref_id=="RO")
			{
				idPivot = 52.0;
				idSlope = 1.9;
			}
			else if(formula_ref_id=="MI")
			{
				idPivot = 56.2;
				idSlope = 1.41;

			}
			//idPivot = 50;
			//idSlope = 2.3;
		}
		
		if((formula_ref_id=="DE")&&(Age<=18))
		{
			if(heightInches<60)
			{
				
				idKg = 2.05*Math.pow(parseFloat(2.71828182845),(0.02*(heightInches/0.39)))
				
			}
			else
			{
				
				//exwt = 2.27 * (heightInches - 60);
				
				if(formObj.gender.selectedIndex == 0)//male
				{
					
					/*if(exwt>0)
					{
						idKg = 39 + exwt;
					}
					else
					{
						idKg = 39;
					}*/
					
					
					
					idKg = 39+2.27 *(heightInches - 60);
						 
				}
				else //female
				{
					
					/*if(exwt>0)
					{
						idKg = 42.2 + exwt;
					}
					else
					{
						idKg = 42.2;
					} */

					idKg = 42.2 + 2.27 *(heightInches - 60) 
				}
				
			}
			

		}
		else
		{
			exwt = idSlope * (heightInches - 60);
			if(exwt>0)
				{
					idKg = idPivot + exwt;
				}
				else
				{
					idKg = idPivot;
				}
		}
	/*}else{/////
		 if(heightInches>60){
			if(formObj.gender.selectedIndex == 1){// sex is female
				idPivot = 42.2;
				idSlope = 2.27;				
			}else{
				idPivot = 39;
				idSlope = 2.27;				
			}
			idKg=idPivot + idSlope * (heightInches - 60);
		}else{
			var power =0.02 * (heightInches *2.54);
			idKg = 2.05 * Math.pow(2.71828182845, power) ;  
		}
	} */
	
	if (formObj.wtUnits.selectedIndex == 1) {	// 0 = weight in lbs.
		formObj.IBW.value = parseFloat(idKg * 2.2046226).toFixed(8) + " lbs";
	} else {
		formObj.IBW.value = parseFloat(idKg).toFixed(8) + " kg";
	}

return null;
}

function checkWeight(val) {
	if ((isNaN(val)) || (val == null)  || (val == "") || (val < 0)) {
		//alert( "Please enter a value for Weight.");
		alert(getMessage("WGT_CANT_BLANK","CA"));
		return false;
	}
	return true;
}

function GetAge(form) {
	if (form.ageRng.selectedIndex == 0) { // 70+ years,
		return 75;
	} else {
		if (form.ageRng.selectedIndex < 6) { // 1 thru 5 are decades 20s thru 60s.
			return 65 - (form.ageRng.selectedIndex -1)*10;
		} else {
			if (form.ageRng.selectedIndex == 6 ) {
				return 19;
			} else {
				if (form.ageRng.selectedIndex < 23) { // 7 thru 22 are ages 17 thru 2.
					return 17 - (form.ageRng.selectedIndex-7);
				} else {
					if (form.ageRng.selectedIndex == 23) { // age 1.5 yrs.
						return 1.5;
					} else {
						if (form.ageRng.selectedIndex == 24) {	// age 1 yrs.
							return 1;
						} else {
							if (form.ageRng.selectedIndex == 25) {
								return 30;
							} else {
								return 13;
							}
						}
					}
				}
			}
		}
	}
}

function clearIBW(obj)
{

if(obj.value=="")
	{
		document.forms[0].IBW.value='';
	}
}
