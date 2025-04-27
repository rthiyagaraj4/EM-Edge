/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
19/03/2013    IN038746      Chowminya G  clinical calculator for Glomerular Filtration Rate
22/07/2013    IN036900		Akbar		 Bru-HIMS-CRF-330 - Creatitine Clearance Calculator
04/10/2013    IN043652      Vijayakumar K  Alpha-CA-System Allowing user to enter negative values at Age and Weight fields.
29/05/2020	  IN069908		Durga Natarajan	 	To have an additional formula for creatinine clearance calculation for children aged below 18 years old	
---------------------------------------------------------------------------------------------------------------
*/
async function callCalculator(){
	var actionUrl = "../../eCA/jsp/CACalculatorMain.jsp";
	var features ="dialogwidth:800px;dialogheight:500px;status:no;scroll:no;title:Clinical Calculator";
	var arguments="";
	retVal=await window.showModalDialog(actionUrl,arguments,features);
} 

function allowDecimalNums(event){
    var strCheck = '0123456789.';
	var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;	
}

function allowOnlyNums(event){
    var strCheck = '0123456789';
	var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1)  return false;
	// Not a valid key
	return true ;	
}

function allowValidFormat(numData){
	var cnt = 0;
	numDataValue = numData.value;
	if(numDataValue.indexOf(".") != -1){
		var tempNum = numDataValue.split(".");
		if(tempNum.length > 2 || tempNum[1] == ""){
			alert(getMessage('INVALID_NUMBER_FORMAT','CA'));	
			numData.focus();		
			return false;				
		}		
	}
}
function calculateResult(Obj)
{
			if (Obj.value=="")
				parent.frames[1].location='../../eCommon/html/blank.html'
			else
				parent.frames[1].location.href='../../eCA/jsp/'+Obj.value;
}
	function Calculate()
	{
		var cardiacOutput = document.forms[0].cardOutput.value;
		var BSA = document.forms[0].BSA.value;
		var cardiacname=document.forms[0].cardOutput.name;
		var BSAname=document.forms[0].BSA.name;

		if ((cardiacOutput == '') || (BSA =='')) {
			alert(getMessage('VAL_NOT_BLANK','CA'));			
		}
		else if(BSA == 0)
			{
				var mesg = getMessage('REMARKS_MUST_GR_EQUAL','Common');
				mesg = mesg.replace('$' , getLabel('Common.BSA.label','COMMON') );
				mesg = mesg.replace('#' , '1');
				alert(mesg);
				document.forms[0].BSA.select();
			}
		else
		{
		var cardiacIndex = (parseFloat(cardiacOutput)) / (parseFloat(BSA));
		 document.forms[0].cIndex.value =cardiacIndex;
		}
	}
	function calculateBSA()
	{
		var weight = document.forms[0].weight.value;
		var height = document.forms[0].height.value;
		
			if(weight !='' && height !='' && isNaN(height) == false )
			{
				var bSA = (Math.pow(parseFloat(weight),0.425) * Math.pow(parseFloat(height),0.725))*0.007184;
				document.forms[0].BSA.value =bSA;
			}
		
	}
	function round(number,X){
				X = (!X ? 2 : X);
				return Math.round(number*Math.pow(10,X))/Math.pow(10,X);
			}
	function CalculateCenttoFahren()
	{
		var centig = document.forms[0].cent.value;
 		if (isNaN(centig)) {
			
			alert(getMessage('NUM_ALLOWED','CA'));
		}

		else if ((centig=='')) {
			alert(getMessage('VAL_NOT_BLANK','CA'));	
		}else if(centig < 1)
			{
				var mesg = getMessage('REMARKS_MUST_GR_EQUAL','Common');
				mesg = mesg.replace('$' , getLabel('eCA.Centigrade.label','CA') );
				mesg = mesg.replace('#' , '1');
				alert(mesg);
				document.forms[0].cent.select();
			}

		else {
				//Degree Fahrenheit = (Degree centigrade x 9/5) + 32
				var fahr = ((parseInt(centig))*9/5) + 32;
				document.forms[0].fahren.value =round(fahr,2);
			}
	}
 
function CalculateBMI()
{
			var Weight = document.forms[0].weight.value;
			var Height = document.forms[0].height.value;
			if (isNaN(Weight) || isNaN(Height)==true) {
				
				alert(getMessage('NUM_ALLOWED','CA'));
			}else if ((Weight=='') || (Height=='')) {
				
				alert(getMessage('VAL_NOT_BLANK','CA'));
			}
			else if(Height < 1)
			{
				var mesg = getMessage('REMARKS_MUST_GR_EQUAL','Common');
				mesg = mesg.replace('$' , getLabel('Common.height.label','COMMON') );
				mesg = mesg.replace('#' , '1');
				alert(mesg);
			}
			else 
			{
				var BMI = parseFloat(Weight)/(parseInt(Height) * parseFloat(Height)) * 10000
				document.forms[0].resultDisplay.value = round(BMI,2)
			}
		}
function CalculateRedCellVolume(){
				var Weight = document.forms[0].weight.value;
		var Height = document.forms[0].height.value;
		var bSA = (Math.pow(parseFloat(Weight),0.425) * Math.pow(parseFloat(Height),0.725))*0.007184
		var rcVolume ='';
		if (isNaN(Weight) || isNaN(Height)==true) {
			
			alert(getMessage('NUM_ALLOWED','CA'));
		}else if ((Weight=='') || (Height=='')) {
			alert(getMessage('VAL_NOT_BLANK','CA'));
		}else{
			if(document.forms[0].elements[0].checked){
				rcVolume = parseFloat(bSA)*1050
			}else if(document.forms[0].elements[1].checked){
				rcVolume = parseFloat(bSA)*850
				}
			document.forms[0].redCellVolumeValue.value =round(rcVolume,2);
				}

			}

function CalculatePndToKg()
	{
		var pound = document.forms[0].pound.value;
 		if (isNaN(pound)) {
		
			alert(getMessage('NUM_ALLOWED','CA'));
		}

		else if ((pound=='')) {
		
			alert(getMessage('VAL_NOT_BLANK','CA'));
		}else if(pound < 1)
			{
				var mesg = getMessage('REMARKS_MUST_GR_EQUAL','Common');
				mesg = mesg.replace('$' , getLabel('eCA.Pounds.label','CA') );
				mesg = mesg.replace('#' , '1');
				alert(mesg);
				document.forms[0].pound.select();
			}
		else {
				var kilo = (parseInt(pound))/2.2;
				document.forms[0].kilo.value =round(kilo,2);
			}
	}

function CalculateEDD(){
		var lmp = document.forms[0].lmp.value;
		var cycle = document.forms[0].cycle.value;
		 if ((lmp=='') || (cycle=='')) {
		
			alert(getMessage('VAL_NOT_BLANK','CA'));	
		}
		else
			document.forms[0].submit();
	}


	function CalculateCerebralPP()
	{
		var meanABP = document.forms[0].meanABP.value;
		var intracranialP = document.forms[0].intracranialP.value;
 		if (isNaN(meanABP) || isNaN(intracranialP)==true) {
			
			alert(getMessage('NUM_ALLOWED','CA'));
		}else if ((meanABP=='') || (intracranialP=='')) {
			alert(getMessage('VAL_NOT_BLANK','CA'));	
		}else if (meanABP < 1) 
		{
			var mesg = getMessage('REMARKS_MUST_GR_EQUAL','Common');
				mesg = mesg.replace('$' , getLabel('eCA.Meanarterialbloodpressure.label','CA') );
				mesg = mesg.replace('#' , '1');
				alert(mesg);
				document.forms[0].meanABP.select();
		}else if (intracranialP < 1)
		{
			var mesg = getMessage('REMARKS_MUST_GR_EQUAL','Common');
				mesg = mesg.replace('$' , getLabel('eCA.Intracranialpressure.label','CA'));
				mesg = mesg.replace('#' , '1');
				alert(mesg);
				document.forms[0].intracranialP.select();
		}
		else
		{
			if(parseInt(intracranialP) > parseInt(meanABP)){
				alert(getMessage('MABP_LESS_ICP','CA'))
				document.forms[0].cerebralPP.value=''
				document.forms[0].meanABP.focus();
			}else{
				var cerebralPP = parseInt(meanABP)-parseInt(intracranialP);
				document.forms[0].cerebralPP.value =cerebralPP;
			}
		}
	}
		function CalculateMeanBP(){
		var sBP = document.forms[0].sBP.value;
		var dBP = document.forms[0].dBP.value;
		var mBP=''
		if (isNaN(sBP) || isNaN(dBP)==true) {
			
			alert(getMessage('NUM_ALLOWED','CA'));
		}else if ((sBP == '') || (dBP =='')) {
			
			alert(getMessage('VAL_NOT_BLANK','CA'));
		}else if (sBP < 1)
		{
			var mesg = getMessage('REMARKS_MUST_GR_EQUAL','Common');
				mesg = mesg.replace('$' , getLabel('eCA.SystolicBloodPressure.label','CA') );
				mesg = mesg.replace('#' , '1');
				alert(mesg);
				document.forms[0].sBP.select();
		}else if (dBP < 1)
		{
			var mesg = getMessage('REMARKS_MUST_GR_EQUAL','Common');
				mesg = mesg.replace('$' , getLabel('eCA.DiastolicBloodPressure.label','CA') );
				mesg = mesg.replace('#' , '1');
				alert(mesg);
				document.forms[0].dBP.select();
		}
		else{
			mBP = (parseInt(sBP) + 2*(parseInt(dBP))) / 3;
			document.forms[0].mBP.value =mBP;
		}
}
			
function CalculateFahrtoCent()
	{
		var fahr = document.forms[0].fahren.value;
 		if (isNaN(fahr)) {
			
			alert(getMessage('NUM_ALLOWED','CA'));
		}

		else if ((fahr=='')) {
			
			alert(getMessage('VAL_NOT_BLANK','CA'));	
		}
		else if(fahr < 1)
			{
				var mesg = getMessage('REMARKS_MUST_GR_EQUAL','Common');
				mesg = mesg.replace('$' , getLabel('eCA.Fahrenheit.label','CA') );
				mesg = mesg.replace('#' , '1');
				alert(mesg);
				document.forms[0].fahren.select();
			}
		else {
				//Degree Centigrade = (Degree Fahrenheit - 32) x 5/9	
				var centig = ((parseInt(fahr)-32))*5/9;
				document.forms[0].cent.value =round(centig,2);
			}
	}

	function CalculateGlomerular()
	{
		var age = document.forms[0].age.value;
		var weight = document.forms[0].weight.value;
		var sCR =document.forms[0].sCR.value;

		var GFR ='';

 		if (isNaN(age) || isNaN(weight)==true || isNaN(sCR)==true) {

			alert(getMessage('NUM_ALLOWED','CA'));
		}

		else if ((age == '') || (weight == '') || (sCR == '')) {

			alert(getMessage('VAL_NOT_BLANK','CA'));
		}
		else if(age < 1)
		{
			var mesg = getMessage('REMARKS_MUST_GR_EQUAL','Common');
			mesg = mesg.replace('$' , getLabel('Common.age.label','COMMON') );
			mesg = mesg.replace('#' , '1');
			alert(mesg);
			document.forms[0].age.select();
		}
		else if(weight < 1)
		{
			var mesg = getMessage('REMARKS_MUST_GR_EQUAL','Common');
			mesg = mesg.replace('$' , getLabel('Common.weight.label','COMMON') );
			mesg = mesg.replace('#' , '1');
			alert(mesg);
			document.forms[0].weight.select();
		}
		else if(sCR == 0)
		{
			var mesg = getMessage('REMARKS_MUST_GR_EQUAL','Common');
			mesg = mesg.replace('$' , getLabel('eCA.Serumcreatinine.label','CA') );
			mesg = mesg.replace('#' , '1');
			alert(mesg);
			document.forms[0].sCR.select();
		}
		else
		{
				if(document.forms[0].male.checked)
				{
			//	GFR = ((140 -parseInt(age)) * parseInt(weight)) / (sCR * 72) //Commentted IN038746
				GFR = ((140 -parseInt(age)) * parseInt(weight)*1.23) / (sCR) //serum creatinine is measured in µmol/L IN038746
				document.forms[0].GFR.value =round(GFR,2);
				}

				else
				if(document.forms[0].female.checked)
				{
			//	GFR = ((140 -parseInt(age)) * parseInt(weight)*0.85) / (sCR * 72) //Commentted IN038746
				GFR = ((140 -parseInt(age)) * parseInt(weight)*1.04) / (sCR) //serum creatinine is measured in µmol/L IN038746
				document.forms[0].GFR.value =round(GFR,2);
				}
		}

	}


function allowValidNumber(fld, e, maxInt, deci)
{
    var count=fld.value.length;//ok
    var whichCode = (window.Event) ? e.which : e.keyCode;//ok

	var minusOccurance = fld.value.indexOf('-');
	if(minusOccurance != -1)
	{
		maxInt++;
	}
	if(whichCode == 45 && count>0)
	{
		return false
	}

    if(count>=maxInt)
    {
        if(count==maxInt)
        {
            var dotOccurance = fld.value.indexOf('.');
	

            if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt)&& deci>0)
            {
				if(whichCode!=46)
                {
                    fld.value = fld.value+".";
                    //return false;
                }
            }
        }
        else if(count>maxInt)
        {
            var objectValue = fld.value;
            var dotOccurance = objectValue.indexOf('.');
            //alert(objectValue.charAt(maxInt));
            if((objectValue.charAt(maxInt))!='.')
            {
                if(dotOccurance==-1 && parseInt(deci)>0 )
                {
                    fld.value = objectValue.substring(0,maxInt)+".";
                    return false;
                }
            }
        }
    }
	//you donot require this just var strCheck = '.0123456789' for deci > 0
	//strCheck = '0123456789' for deci=0
	      var strCheck = '.0123456789-';

//	alert(e.getKeyCode())
    if (parseInt(deci)==0)//For Only Nos 0 - 9
        strCheck = '0123456789-';

    var fldvalue=fld.value;
    var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) return true;  // Enter
    var pointCount=0;

    for(var i=0;i<fldvalue.length;i++)
    {
        if(fldvalue.charAt(i)=='.') pointCount++;
    }

    if (pointCount>0 && whichCode == 46) return false;

    var fldValue    =   fld.value;
    var dotIndex    =   fldValue.indexOf(".");
    var fldLength   =   fldValue.length;
    if(dotIndex!=-1)
        if( fldLength > (dotIndex+deci) ) return false;


	key = String.fromCharCode(whichCode);  // Get key value from key code

	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	else if(key == "-" && fldValue.indexOf(key) != -1  )
	{
		if(fldValue.indexOf(key) != 1 )
			return false
	}
    return true;
}


function checkValue(Obj)
{
if(Obj.value == 'M')
	document.forms[0].female.checked =false;

if(Obj.value == 'F')
	document.forms[0].male.checked =false;

}

function CalculateCreatinine()
	{
	var uCreatinine = document.forms[0].uCreatinine.value;
	var sCreatinine = document.forms[0].sCreatinine.value;
	var uVolume = document.forms[0].uVolume.value;
	var radio="";
	if (document.forms[0].order(0).checked)
	radio=document.forms[0].order(0).value;
	else
	radio=document.forms[0].order(1).value;
	
		//if (isNaN(uCreatinine)|| isNaN(sCreatinine) ==true) 		//IN036900 - commented
		if (isNaN(uCreatinine)|| isNaN(sCreatinine) || isNaN(uVolume) ==true)  //IN036900 - added
		{
			alert(getMessage('NUM_ALLOWED','CA'));
		}

		else if ((uCreatinine == '') || (sCreatinine == '')|| (uVolume == ''))
		{
			alert(getMessage('VAL_NOT_BLANK','CA'));
		}  
		else if(uVolume == 0)
			{
				var mesg = getMessage('REMARKS_MUST_GR_EQUAL','Common');
				mesg = mesg.replace('$' , getLabel('eCA.PlasmaCreatinine.label','CA') );
				mesg = mesg.replace('#' , '1');
				alert(mesg);
				document.forms[0].uVolume.select();
			}
	   else
		{
			//IN036900 - Start
			//var crcl =((140-parseFloat(uCreatinine))*parseFloat(sCreatinine)*parseFloat("1.23"))/(814*(parseFloat(uVolume)))
			//document.forms[0].crcl.value =round(crcl,2);
			var crcl = "";

			if(radio == 1)
			{
				crcl = ((140 - parseFloat(uCreatinine)) * parseFloat(sCreatinine)*1.23) / (parseFloat(uVolume))
			}
			else
			{	
				crcl = ((140 -parseFloat(uCreatinine)) * parseFloat(sCreatinine)*1.04) / (parseFloat(uVolume)) 			
			}

			document.forms[0].crcl.value =round(crcl,2);			
			//IN036900 - End
		}

	}
	function CaluculateInchCMSbutt()
	{
			var inchObjVal=document.forms[0].inchInput;
			var CMSObjVal=document.forms[0].CMSInput;
			var SqrinchObjVal=document.forms[0].inchSqrInput;
			var SqrCMSObjVal=document.forms[0].CMSSqrInput;
		
		
		if(inchObjVal.value==''&&CMSObjVal.value==''&&SqrinchObjVal.value==''&&SqrCMSObjVal.value=='')
			{
				alert(getMessage('VAL_NOT_BLANK','CA'));
			}
			else
			{
				CaluculateInchCMS();
			}

	}



	function CaluculateInchCMS()
		{

			var inchObjVal=document.forms[0].inchInput;
			var CMSObjVal=document.forms[0].CMSInput;
			var SqrinchObjVal=document.forms[0].inchSqrInput;
			var SqrCMSObjVal=document.forms[0].CMSSqrInput;
			
			/*1. Caluculation Inch To CMS*/
			var inchIPVal;		
			var CMSOPVal;	
			/*2. Caluculation CMS to Inch*/
			var CMSObjName;		
			var CMSIPVal;		
			var inchOPVal;
			/*1. Caluculation SqrInch To SqrCMS*/
			var inchSqrIPVal;		
			var CMSSqrOPVal;	
			/*2. Caluculation SqrCMS to SqrInch*/
			var CMSSqrIPVal;		
			var inchSqrOPVal;		

			
			if (!isNaN(inchObjVal.value)&&inchObjVal.value&&parseFloat(inchObjVal.value)>=0)
			{
					inchIPVal		=	inchObjVal.value;
					CMSOPVal	=	eval(inchIPVal*2.54);
					//CMSOPVal	=	eval(inchIPVal/0.39);
					document.getElementById("CMSOutput").innerText=parseFloat(CMSOPVal).toFixed(8);
			}
			else
				document.getElementById("CMSOutput").innerText=" ";
			 if(!isNaN(CMSObjVal.value)&&CMSObjVal.value&&parseFloat(CMSObjVal.value)>=0)
			{
					CMSIPVal	=	CMSObjVal.value;
					//inchOPVal	=	eval(CMSIPVal/2.54)
					inchOPVal	=	eval(CMSIPVal*0.39)
	
 					document.getElementById("inchOutput").innerText=parseFloat(inchOPVal).toFixed(8);
			}
			else
				document.getElementById("inchOutput").innerText="";
			
			 if(!isNaN(SqrinchObjVal.value)&&SqrinchObjVal.value&&parseFloat(SqrinchObjVal.value)>=0)
			{
					inchSqrIPVal		=	SqrinchObjVal.value;
					CMSSqrOPVal	=	eval(inchSqrIPVal*6.45);
					//CMSSqrOPVal	=	eval(inchSqrIPVal/0.16);
					document.getElementById("CMSSqrOutput").innerText=parseFloat(CMSSqrOPVal).toFixed(8);
			}
			else
				document.getElementById("CMSSqrOutput").innerText="  ";
			 if(!isNaN(SqrCMSObjVal.value)&&SqrCMSObjVal.value&&parseFloat(SqrCMSObjVal.value)>=0)
			{
					CMSSqrIPVal	=	SqrCMSObjVal.value;
					//inchSqrOPVal	=	eval(CMSSqrIPVal/6.4516)
					inchSqrOPVal	=	eval(CMSSqrIPVal*0.16)
					document.getElementById("InchSqrOutput").innerText=parseFloat(inchSqrOPVal).toFixed(8);
			}
				else
				document.getElementById("InchSqrOutput").innerText="  ";


		}

	function CaluculateBSA()
		{
						var bspOPVal;
						var bmpOPVal;
						var heitIPVal=document.forms[0].HeitInput.value;  
						var weitIPVal=document.forms[0].WeitInput.value;
						var formula_ref_id = document.getElementById("formula_ref_id").value;
						if (heitIPVal!="" && weitIPVal!="")
						{
								
								 if(formula_ref_id=="MO")
								 {

										bspOPVal =round(Math.sqrt((heitIPVal*weitIPVal)/3600),8) ;
										document.getElementById("BSAOut").innerText=parseFloat(bspOPVal).toFixed(8);
								 }
								 else if (formula_ref_id=="DO")
								 {
									// bspOPVal = round(0.007184*Math.pow(parseFloat(heitIPVal),0.725) * Math.pow(parseFloat(weitIPVal),0.425),2);
									 bspOPVal = round(0.20247*Math.pow(parseFloat(heitIPVal/100),0.725) * Math.pow(parseFloat(weitIPVal),0.425),8);
								 
									 document.getElementById("BSAOut").innerText=parseFloat(bspOPVal).toFixed(8);

								 }
								 else if (formula_ref_id=="HC")
								 {
										
										bspOPVal =round(0.024265 * Math.pow(parseFloat(heitIPVal),0.3964 )* Math.pow(parseFloat(weitIPVal),0.5378),8);
										
										//round(0.007184*Math.pow(parseFloat(heitIPVal),0.725) * Math.pow(parseFloat(weitIPVal),0.425),2);
										document.getElementById("BSAOut").innerText=parseFloat(bspOPVal).toFixed(8);
										
								 }
								 else if (formula_ref_id=="GG")
								 {
										bspOPVal = round(0.0235  * Math.pow(parseFloat(heitIPVal),0.42246  )* Math.pow(parseFloat(weitIPVal),0.51456),8 );
										document.getElementById("BSAOut").innerText=parseFloat(bspOPVal).toFixed(8);
								 }
								 else if (formula_ref_id=="BO")
								 {
									 
										bspOPVal = round(0.0003207 * Math.pow(parseFloat(heitIPVal),0.3 ) * Math.pow(parseFloat(weitIPVal * 1000),(0.7285 - (0.0188 * Math.LOG10E*Math.log(weitIPVal * 1000)) )),8);
										document.getElementById("BSAOut").innerText=parseFloat(bspOPVal).toFixed(8);

								 }
								 
								// bspOPVal = round(0.007184*Math.pow(parseFloat(heitIPVal),0.725) * Math.pow(parseFloat(weitIPVal),0.425),2);
								//document.getElementById("BSAOut").innerText=parseFloat(bspOPVal).toFixed(2);
						}
						else{
								document.getElementById("BSAOut").innerText= "";
						
						if(heitIPVal==""||heitIPVal==null)
							{
								var msg = getMessage("CAN_NOT_BE_BLANK","COMMON");
								msg=msg.replace("$",getLabel("Common.height.label","COMMON"));
								alert(msg);
								return false;
							}

						if(weitIPVal==""||weitIPVal==null)
							{
								var msg =getMessage("CAN_NOT_BE_BLANK","COMMON");
								msg=msg.replace("$",getLabel("Common.weight.label","COMMON"));
								alert(msg);
								return false;
							}
						}
						

				 
		}

function CheckNoVal(obj)
{
	if (obj.value=='')
	{
		document.getElementById("BSAOut").innerText= "";

	}

}
//IN043652 starts
function allowValidNumberOnKeyPress(fld, e, maxInt, deci)
{

    var count=fld.value.length;//ok
    var whichCode = (window.Event) ? e.which : e.keyCode;//ok
	
	var minusOccurance = fld.value.indexOf('-');
	if(minusOccurance != -1)
	{
		maxInt++;
	}
	if(whichCode == 45 && count>0)
	{
		return false
	}

    if(count>=maxInt)
    {
        if(count==maxInt)
        {
            var dotOccurance = fld.value.indexOf('.');
	

            if(((dotOccurance>=maxInt)||(dotOccurance==-1)) && (count==maxInt)&& deci>0)
            {
				if(whichCode!=46)
                {
                    fld.value = fld.value+".";
                }
            }
        }
        else if(count>maxInt)
        {
            var objectValue = fld.value;
            var dotOccurance = objectValue.indexOf('.');
            if((objectValue.charAt(maxInt))!='.')
            {
                if(dotOccurance==-1 && parseInt(deci)>0 )
                {
                    fld.value = objectValue.substring(0,maxInt)+".";
                    return false;
                }
            }
        }
    }
	//you donot require this just var strCheck = '.0123456789' for deci > 0
	//strCheck = '0123456789' for deci=0
		  var strCheck = '.0123456789';//IN043652
    if (parseInt(deci)==0)//For Only Nos 0 - 9
		strCheck = '0123456789';//IN043652

    var fldvalue=fld.value;
    var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) return true;  // Enter
    var pointCount=0;

    for(var i=0;i<fldvalue.length;i++)
    {
        if(fldvalue.charAt(i)=='.') pointCount++;
    }

    if (pointCount>0 && whichCode == 46) return false;

    var fldValue    =   fld.value;
    var dotIndex    =   fldValue.indexOf(".");
    var fldLength   =   fldValue.length;
    if(dotIndex!=-1)
        if( fldLength > (dotIndex+deci) ) return false;


	key = String.fromCharCode(whichCode);  // Get key value from key code

	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	else if(key == "-" && fldValue.indexOf(key) != -1  )
	{
		if(fldValue.indexOf(key) != 1 )
			return false
	}
    return true;
}

function allowValidNumberOnBlur(objmsg)
{
	var val=objmsg.value;
	var validnumbers = ".0123456789";
	var charval = "";
	
	for(i=0;i<val.length;i++)
	{
     charval = val.charAt(i);
	 if (validnumbers.indexOf(charval) == -1)
	 {
		var msg = getMessage("POSITIVE_NUMBER_ALLOWED","CA");
		alert(msg);
		objmsg.focus();
		return;
	 }
	}
}
//IN043652 ends
//IN069908 starts

function CalculateCreatinineChild()
{
	var serum = document.forms[0].serum.value;
	var height = document.forms[0].height.value;
	if (isNaN(serum)|| isNaN(height)==true) 
		{
			alert(getMessage('NUM_ALLOWED','CA'));
		}

		else if ((serum == '') || (height == ''))
		{
			alert(getMessage('VAL_NOT_BLANK','CA'));
		}  
		else if((height<1) || (serum==0))
			{
				alert("Value of Serum Creatinine should be greater than 0 " +
						"\nValue of Height should be greater than or equal to From 1 ");
				document.forms[0].height.select();
				document.forms[0].serum.select();
			}
		else
		{
			var gfr = ((36.2 * parseFloat(height))  / parseFloat(serum))
			document.forms[0].gfr.value =round(gfr,2); 			
		}	
}

//IN069908 ends
