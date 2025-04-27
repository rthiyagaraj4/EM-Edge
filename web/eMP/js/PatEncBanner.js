function loadPatEncBanner()
{
	var bannerCateg = document.patEncBannerHdrForm.patEncList.value;
	if(parent.patEncBannerDetailsFrame.document.patEncBannerDtlForm != null)
	{
		var msg = getMessage("CHANGES_BANNER_CONTINUE","MP") ;
		var msgConfirm = window.confirm(msg);
		if(msgConfirm == true)
		{
			if(bannerCateg != '')
				parent.patEncBannerDetailsFrame.location.href = '../../eMP/jsp/PatEncBannerDetails.jsp?bannerCateg='+bannerCateg+'&loadFirstTime=Yes';
			else
				parent.patEncBannerDetailsFrame.location.href = '../../eCommon/html/blank.html';
		}
		else
		{
			if(parent.patEncBannerDetailsFrame.document.patEncBannerDtlForm != null)
			{
				bannerCateg = parent.patEncBannerDetailsFrame.document.patEncBannerDtlForm.bannerCateg.value;
			}
			document.patEncBannerHdrForm.patEncList.value = bannerCateg;
			return false;
		}	
	}
	else
		parent.patEncBannerDetailsFrame.location.href = '../../eMP/jsp/PatEncBannerDetails.jsp?bannerCateg='+bannerCateg+'&loadFirstTime=Yes';
}

function apply()
{
	var retFlag=buildHTMLForBanner();
	if(retFlag){
		patEncBannerDetailsFrame.document.patEncBannerDtlForm.action='../../servlet/eMP.PatEncBannerServlet';
		patEncBannerDetailsFrame.document.patEncBannerDtlForm.target='messageFrame';
		patEncBannerDetailsFrame.document.patEncBannerDtlForm.method='post';		
		patEncBannerDetailsFrame.document.patEncBannerDtlForm.submit();
	}else{
		commontoolbarFrame.location.reload();
	}
}


async function callDiagnosis(patient_id,episode_id){

	var query_string	= "patient_id="+patient_id+"&encounter_id="+episode_id;	
	var retVal 			= new String();
	var dialogHeight 	= "700px" ;
	var dialogWidth  	= "500px" ;
	var dialogTop    	= "100";
    var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=no; status:no";
	retVal = await window.showModalDialog("../../eCA/jsp/PatProblemList.jsp?modal_yn=Y&"+query_string,arguments,features);	

}

function buildHTMLForBanner(){
	var defSel = "";
	var HTMLLine1Content = "";
	var tempVal = 2;
	var line1LengthValue=0;
	var line2LengthValue=0;
	var arrStr=new Array(7);
	var patPhotoFlag=false;
	var returFlag=true;
	//var bannerCategory=document.getElementById("bannerCateg").value;
	//alert(bannerCategory)
	arrStr[0]="Patient Profile";
	arrStr[1]="Alerts and Allergies";
	arrStr[2]="Clinical Studies/Research category";
	arrStr[3]="Financial";
	arrStr[4]="Suspended";
	arrStr[5]="Deactivated";
	arrStr[6]="VIP";
	arrStr[7]="Diagnosis";
	defSel = eval(patEncBannerDetailsFrame.document.getElementById("defSelect1"));
	if(defSel.checked == true){
		HTMLLine1Content = "<TR><td rowspan='2' width='48' nowrap id='tdPhoto'><span id='PAT_PHOTO'><img src='../../eCommon/images/PI_Photo.gif'></span><td id='tdLine1' nowrap>";
		//line1LengthValue=10;
		//line2LengthValue=10;
		patPhotoFlag=true;
	}else{
		HTMLLine1Content = "<TR><td name='tdLine1' id='tdLine1' nowrap>"
	}
	var HTMLLine2Content = "<TR><td name='tdLine2' id='tdLine2' nowrap>";
	var HTMLContent = "";
	var lineNum = "";
	var dispOrder = "";
	var dispText = "";
	var toolTip = "";
	var elmtRef = "";
	var numSpaces = "";
	var iconYN = "";
	var imageName = "";
	var displayLength;
	var cntLine1 = patEncBannerDetailsFrame.document.patEncBannerDtlForm.cntLine1.value;
	var cntLine2 = patEncBannerDetailsFrame.document.patEncBannerDtlForm.cntLine2.value;
	for(var v=2;v<=parseInt(cntLine1,10);v++){
		//defSel = eval(patEncBannerDetailsFrame.document.getElementById("defSelect1"+v));
		defSel = eval(patEncBannerDetailsFrame.document.getElementById("defSelect"+v));
		if(defSel.checked == true){	
			dispText = eval(patEncBannerDetailsFrame.document.getElementById("dispText"+v)).value;
			toolTip = eval(patEncBannerDetailsFrame.document.getElementById("toolTip"+v)).value;
			elmtRef = eval(patEncBannerDetailsFrame.document.getElementById("elmt1Ref"+v)).value;
			numSpaces = eval(patEncBannerDetailsFrame.document.getElementById("num1Spaces"+v)).value;			
			iconYN = eval(patEncBannerDetailsFrame.document.getElementById("icon1YN"+v)).value;
			imageName = eval(patEncBannerDetailsFrame.document.getElementById("image1Name"+v)).value;
			displayLength = eval(patEncBannerDetailsFrame.document.getElementById("disp1Length"+v));
			for(var i=0;i<=7;i++){
				if(eval(patEncBannerDetailsFrame.document.getElementById("element1Desc"+v)).value==arrStr[i]){
					line1LengthValue=line1LengthValue+eval("4");
					break;
				}
			}
			if(dispText !=null && dispText!="undefined"){
				line1LengthValue=line1LengthValue+eval(dispText.length);
			}
			if (numSpaces != " "){
				line1LengthValue=line1LengthValue+eval(numSpaces);
			}
			if(displayLength !=null && displayLength!="undefined"){
				line1LengthValue=line1LengthValue+eval(displayLength.value);
			}			
			if(toolTip == ' ') toolTip = '';
			if(numSpaces != '' && numSpaces != ' '){
				for(var t=0;t<parseInt(numSpaces,10);t++){
					HTMLLine1Content += "&nbsp;";
				}
			}
			/*below line condtion added for this CRF Bru-HIMS-CRF-411*/
			if(dispText != '' && dispText != ' ')								
				if(elmtRef !='LENGTH_OF_STAY')			     
				 HTMLLine1Content += "<span class='legendClassRow1'>"+dispText+" : </span>";

			if(iconYN == 'Y' || iconYN == 'y')
				HTMLLine1Content += "<span class='image' title='"+toolTip+"' id='"+elmtRef+"'><img src='../../eCommon/images/"+imageName+"'></span>";
			else if(elmtRef == 'PATIENT_NAME')
				HTMLLine1Content += "<span class='valueClassRow1' title='"+toolTip+"' id='"+elmtRef+"'><a >~"+elmtRef+"`</a></span><span id='long_name'>...</span>";
			else if(elmtRef == 'PAT_NAME_LOCAL_LANG')
				HTMLLine1Content += "<span class='valueClassRow1' title='"+toolTip+"' id='"+elmtRef+"'><a >~"+elmtRef+"`</a></span><span id='long_name_loc'>...</span>";
			else if(elmtRef == 'LENGTH_OF_STAY')
				HTMLLine1Content += "<span class='valueClassRow1' title='"+toolTip+"' id='"+elmtRef+"'>"+dispText+" :<a >~"+elmtRef+"`</a></span>";	
			else if(elmtRef == 'HAAD_DISEASE')
				HTMLLine1Content += "<span id='"+elmtRef+"' name='"+elmtRef+"'><span  id='dis0' name='dis0'></span>&nbsp;<span  id='dis1' name='dis1'></span>&nbsp;<span  id='dis2' name='dis2'></span>&nbsp;<span  id='dis3' name='dis3'></span>&nbsp;<span  id='dis4' name='dis4'></span></span>";	/*Added by Rameswar on 15-Jun-16 for AAKH-CRF-0083*/	
			else 
				HTMLLine1Content += "<span class='valueClassRow1' title='"+toolTip+"'>~"+elmtRef+"`</span>";

			HTMLLine1Content += "&nbsp;"; //Added for PAS-MP-Encounter Context Banner
		}
		//HTMLLine1Content += "&nbsp;"; //Commented for PAS-MP-Encounter Context Banner
	
		/*above line added for this CRF Bru-HIMS-CRF-411*/
	}
	for(var v=1;v<=parseInt(cntLine2,10);v++){
		defSel = eval(patEncBannerDetailsFrame.document.getElementById("defSelect"+v));
		if(defSel.checked == true){
			dispText = eval(patEncBannerDetailsFrame.document.getElementById("dispText"+v)).value;
			toolTip = eval(patEncBannerDetailsFrame.document.getElementById("toolTip"+v)).value;
			elmtRef = eval(patEncBannerDetailsFrame.document.getElementById("elmt2Ref"+v)).value;
			numSpaces = eval(patEncBannerDetailsFrame.document.getElementById("num2Spaces"+v)).value;
			iconYN = eval(patEncBannerDetailsFrame.document.getElementById("icon2YN"+v)).value;
			imageName = eval(patEncBannerDetailsFrame.document.getElementById("image2Name"+v)).value;
			var display2Length = eval(patEncBannerDetailsFrame.document.getElementById("disp2Length"+v));
			if(toolTip == ' ') toolTip = '';
			if(numSpaces != '' && numSpaces != ' '){
				for(var t=0;t<parseInt(numSpaces,10);t++){
					HTMLLine2Content += "&nbsp;";
				}
			}
			for(var i=0;i<=7;i++){
				if(eval(patEncBannerDetailsFrame.document.getElementById("element2Desc"+v)).value==arrStr[i]){
					line2LengthValue=line2LengthValue+eval("4");
					break;
				}
			}
			if(dispText !=null && dispText!="undefined"){
				line2LengthValue=line2LengthValue+eval(dispText.length);
			}
			if (numSpaces != " "){
				line2LengthValue=line2LengthValue+eval(numSpaces);
			}
			if(display2Length !=null && display2Length!="undefined"){
				line2LengthValue=line2LengthValue+eval(display2Length.value);
			}
			/*below line condtion added for this CRF Bru-HIMS-CRF-411*/
			if(dispText != '' && dispText != ' ')
			 if(elmtRef !='LENGTH_OF_STAY')
			      HTMLLine2Content += "<span class='legendClassRow2'>"+dispText+" : </span>";

			if(iconYN == 'Y' || iconYN == 'y')
				HTMLLine2Content += "<span title='"+toolTip+"' id='"+elmtRef+"'><img src='../../eCommon/images/"+imageName+"'></span>";
			else if(elmtRef == 'PATIENT_NAME')
				HTMLLine2Content += "<span class='valueClassRow2' title='"+toolTip+"' id='"+elmtRef+"'><a >~"+elmtRef+"`</a></span><span id='long_name'>...</span>";
			else if(elmtRef == 'PAT_NAME_LOCAL_LANG')
				HTMLLine2Content += "<span class='valueClassRow2' title='"+toolTip+"' id='"+elmtRef+"'><a >~"+elmtRef+"`</a></span><span id='long_name_loc'>...</span>";
			else if(elmtRef == 'LENGTH_OF_STAY')
				HTMLLine2Content += "<span class='valueClassRow2' title='"+toolTip+"' id='"+elmtRef+"'>"+dispText+" :<a >~"+elmtRef+"`</a></span>";		
			else if(elmtRef == 'HAAD_DISEASE')
				HTMLLine2Content += "<span id='"+elmtRef+"' name='"+elmtRef+"'><span  id='dis0' name='dis0'></span>&nbsp;<span  id='dis1' name='dis1'></span>&nbsp;<span  id='dis2' name='dis2'></span>&nbsp;<span  id='dis3' name='dis3'></span>&nbsp;<span  id='dis4' name='dis4'></span></span>";	/*Added by Rameswar on 15-Jun-16 for AAKH-CRF-0083*/	
        	else
				HTMLLine2Content += "<span class='valueClassRow2' title='"+toolTip+"'>~"+elmtRef+"`</span>";

			HTMLLine2Content += "&nbsp;"; //Added for PAS-MP-Encounter Context Banner
		}
		//HTMLLine2Content += "&nbsp;"; //Commented for PAS-MP-Encounter Context Banner
		/*above line added for this CRF Bru-HIMS-CRF-411*/
	}
	var bannerCategory=patEncBannerDetailsFrame.patEncBannerDtlForm.bannerCateg.value;
	if(patPhotoFlag){
		/*
		if(line1LengthValue >90 && line2LengthValue >90){
			//when Line limit exceeds with patient photo
			var msg=getMessage('DISP_EXCEEDS_MAXLENGTH_BOTH','MP');
			msg=msg.replace('!','90');
			alert(msg);
			returFlag=false;
		}else if(line1LengthValue >90){
		*/
		
		 
		 
		if(line1LengthValue >100) {
			var msg=getMessage('DISP_EXCEEDS_MAXLENGTH','MP');
			msg=msg.replace('!','110');
			msg=msg.replace('#','1');
			alert(msg);
			returFlag=false;
		} else if(line2LengthValue >130) {
			var msg=getMessage('DISP_EXCEEDS_MAXLENGTH','MP');
			msg=msg.replace('!','140');
			msg=msg.replace('#','2');
			alert(msg);
			returFlag=false;
		}
	} else {

		/*
		if(line1LengthValue>100 && line2LengthValue >100){
			//when Line limit exceeds without patient photo
			var msg=getMessage('DISP_EXCEEDS_MAXLENGTH_BOTH','MP');
			msg=msg.replace('!','100');
			alert(msg);
			returFlag=false;
		}else if(line1LengthValue>100){
		*/
		
		
		if(line1LengthValue>110) {
			var msg=getMessage('DISP_EXCEEDS_MAXLENGTH','MP');
			msg=msg.replace('!','110');
			msg=msg.replace('#','1');
			alert(msg);
			returFlag=false;
		} else if(line2LengthValue>140) {
			var msg=getMessage('DISP_EXCEEDS_MAXLENGTH','MP');
			msg=msg.replace('!','140');
			msg=msg.replace('#','2');
			alert(msg);
			returFlag=false;
		}
	}
	HTMLLine1Content += "</td></tr>";
	HTMLLine2Content += "</td></tr>";
	HTMLContent = HTMLLine1Content + HTMLLine2Content;
	patEncBannerDetailsFrame.document.patEncBannerDtlForm.htmlContent.value = HTMLContent;
	return	returFlag;
}

function changeColor(dispLine,dispOrder)
{
	var chk = document.patEncBannerDtlForm.firstClick.value;
	var temp;
	var cnt;
	temp = eval(document.getElementById("id"+dispLine+"ForTr"+dispOrder))
	cnt = temp.cells.length;
	if(chk != 'done')
	{
		for(var i=0;i<cnt;i++)
		{
			temp.cells[i].className = 'FIRSTSELECTED';
			document.patEncBannerDtlForm.firstClick.value='done';
		}
		if(dispLine == '1')
		{
			document.getElementById("hiddenTRForLine1").style.display = 'inline';	
		}
		else if(dispLine == '2')
		{
			document.getElementById("hiddenTRForLine2").style.display = 'inline';	
		}
		document.patEncBannerDtlForm.firstDispOrderVal.value = dispOrder;
	}
	var tempVar = eval(document.getElementById("disp"+dispLine+"Order"+dispOrder));
	if(tempVar.className == '')
	{	
		changeDispOrder(dispLine,dispOrder);
	}
}

function addToBean(thisObj,dispLine,dispOrder)
{
	var bannerCateg = document.patEncBannerDtlForm.bannerCateg.value;
	var bannerRef = document.patEncBannerDtlForm.bannerRef.value;
	var maxLen = eval(document.getElementById("max"+dispLine+"Length"+dispOrder));
	var objType = "";
	var objValue = " ";
	if(thisObj.id == eval(document.getElementById("disp"+dispLine+"Text"+dispOrder)).id)
		objType = "dispTextTxt";
	if(thisObj.id == eval(document.getElementById("toolTip"+dispLine+"Text"+dispOrder)).id)
		objType = "toolTipTxt";
	if(maxLen != null)
	{
		if(thisObj.id == eval(document.getElementById("disp"+dispLine+"Length"+dispOrder)).id)
		{
			if(parseInt(maxLen.innerText,10) < parseInt(thisObj.value,10))
			{
				alert(getMessage('DISP_VAL_NOT_GREATER_MAX_VAL','CA'));
				thisObj.select();
				thisObj.focus();
				return false;
			}
			objType = "dispLenTxt";
		}
	}
	else if(maxLen == null)
	{
		objType = "dispLenTxt";
		thisObj.value = " ";
	}
	if(thisObj.id == eval(document.getElementById("num"+dispLine+"Spaces"+dispOrder)).id)
		objType = "numSpacesTxt";

	var url="../../eMP/jsp/PatEncBannerIntermediate.jsp?dispLine="+dispLine+"&dispOrder="+dispOrder+"&objValue="+encodeURIComponent(thisObj.value)+"&sentFromLineChange=fromTextObj&objType="+objType+"&bannerRef="+bannerRef+"&bannerCateg="+bannerCateg;
	parent.patEncBannerIntermediateFrame.location.href =url;
}

function hideToolTip()
{
	if(document.getElementById("linkLine")!=null)
		document.getElementById("linkLine").style.visibility='hidden';
}

function showPopupForLines(dispLine,dispOrder,lineObj){
	var displayLineText = "";
	var newDisplayLine = "";
	if(dispLine == '1'){
		displayLineText = "Move to Line 2";
		newDisplayLine = 2;
	}else if(dispLine == '2'){
		displayLineText = "Move to Line 1";
		newDisplayLine = 1;
	}
	var tabdata = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><body onKeyDown='lockKey()'><table cellpadding=3 cellspacing=0 border=5 bordercolor=BLACK><tr><td><font size=1><b><a href='javascript:moveToLine(\""+newDisplayLine+"\",\""+dispLine+"\",\""+dispOrder+"\")'>"+displayLineText+"</a></b></font></td></tr></table></body></html>";
	document.getElementById("linkLine").innerHTML = tabdata;
	document.getElementById("linkLine").style.top  = lineObj.offsetTop+45;
	document.getElementById("linkLine").style.left  = lineObj.offsetLeft+25;
	document.getElementById("linkLine").style.visibility='visible' ;
}

function moveToLine(newLineNum,dispLine,dispOrder){
	var bannerCateg = document.patEncBannerDtlForm.bannerCateg.value;
	var bannerRef = document.patEncBannerDtlForm.bannerRef.value;
	var defSel = eval(document.getElementById("def"+dispLine+"Sel"+dispOrder));
	var dispText = eval(document.getElementById("disp"+dispLine+"Text"+dispOrder)).value;
	var toolTip = eval(document.getElementById("toolTip"+dispLine+"Text"+dispOrder)).value;
	var numSpaces = eval(document.getElementById("num"+dispLine+"Spaces"+dispOrder)).value;
	var elementDesc = eval(document.getElementById("element"+dispLine+"Desc"+dispOrder)).innerText;
	var maxLength = eval(document.getElementById("max"+dispLine+"Length"+dispOrder));
	if(maxLength != null) maxLength = maxLength.innerText;
	else maxLength = " ";
	var dispLength = eval(document.getElementById("disp"+dispLine+"Length"+dispOrder));
	if(dispLength != null) dispLength = dispLength.value;
	else dispLength = " ";
	var config = eval(document.getElementById("config"+dispLine+"Val"+dispOrder)).value;
	var elmtRef = eval(document.getElementById("elmt"+dispLine+"Ref"+dispOrder)).value;
	var iconYN = eval(document.getElementById("icon"+dispLine+"YN"+dispOrder)).value;
	var imageName = eval(document.getElementById("image"+dispLine+"Name"+dispOrder)).value;

	if(defSel.checked == true) defSel.value = "Y";
	else if(defSel.checked != true) defSel.value = "N";	

	if(dispText == '') dispText = " ";
	if(toolTip == '') toolTip = " ";
	if(numSpaces == '') numSpaces = "0";

	var concatMapValues = dispLine+'`'+defSel.value+'`'+dispOrder+'`'+elementDesc+'`'+maxLength+'`'+dispLength+'`'+numSpaces+'`'+dispText+'`'+toolTip+'`'+config+'`'+elmtRef+'`'+iconYN+'`'+imageName;

	var maxOrderForLine1 = document.patEncBannerDtlForm.maxOrderForLine1.value;
	var maxOrderForLine2 = document.patEncBannerDtlForm.maxOrderForLine2.value;
	parent.patEncBannerIntermediateFrame.location.href = "../../eMP/jsp/PatEncBannerIntermediate.jsp?concatMapValues="+concatMapValues+"&newLineNum="+newLineNum+"&dispLine="+dispLine+"&dispOrder="+dispOrder+"&maxOrderForLine2="+maxOrderForLine2+"&maxOrderForLine1="+maxOrderForLine1+'&sentFromLineChange=Y&bannerRef='+bannerRef+'&bannerCateg='+bannerCateg;
}

function changeDispOrder(dispLine,dispOrder)
{
	var firstDispOrderVal = document.patEncBannerDtlForm.firstDispOrderVal.value;
	var maxOrderForLine1 = document.patEncBannerDtlForm.maxOrderForLine1.value;
	var maxOrderForLine2 = document.patEncBannerDtlForm.maxOrderForLine2.value;
	var bannerCateg = document.patEncBannerDtlForm.bannerCateg.value;
	var bannerRef = document.patEncBannerDtlForm.bannerRef.value;

	if(dispOrder != undefined)
	{
		var defSel = eval(document.getElementById("def"+dispLine+"Sel"+dispOrder));
		var dispText = eval(document.getElementById("disp"+dispLine+"Text"+dispOrder)).value;
		var toolTip = eval(document.getElementById("toolTip"+dispLine+"Text"+dispOrder)).value;
		var numSpaces = eval(document.getElementById("num"+dispLine+"Spaces"+dispOrder)).value;
		var elementDesc = eval(document.getElementById("element"+dispLine+"Desc"+dispOrder)).innerText;
		var maxLength = eval(document.getElementById("max"+dispLine+"Length"+dispOrder));
		if(maxLength != null) maxLength = maxLength.innerText;
		else maxLength = " ";
		var dispLength = eval(document.getElementById("disp"+dispLine+"Length"+dispOrder));
		if(dispLength != null) dispLength = dispLength.value;
		else dispLength = " ";
		var config = eval(document.getElementById("config"+dispLine+"Val"+dispOrder)).value;
		var elmtRef = eval(document.getElementById("elmt"+dispLine+"Ref"+dispOrder)).value;
		var iconYN = eval(document.getElementById("icon"+dispLine+"YN"+dispOrder)).value;
		var imageName = eval(document.getElementById("image"+dispLine+"Name"+dispOrder)).value;

		var defSelFirst = eval(document.getElementById("def"+dispLine+"Sel"+firstDispOrderVal));
		var dispTextFirst = eval(document.getElementById("disp"+dispLine+"Text"+firstDispOrderVal)).value;
		var toolTipFirst = eval(document.getElementById("toolTip"+dispLine+"Text"+firstDispOrderVal)).value;
		var numSpacesFirst = eval(document.getElementById("num"+dispLine+"Spaces"+firstDispOrderVal)).value;
		var elementDescFirst = eval(document.getElementById("element"+dispLine+"Desc"+firstDispOrderVal)).innerText;
		var maxLengthFirst = eval(document.getElementById("max"+dispLine+"Length"+firstDispOrderVal));
		if(maxLengthFirst != null) maxLengthFirst = maxLengthFirst.innerText;
		else maxLengthFirst = " ";
		var dispLengthFirst = eval(document.getElementById("disp"+dispLine+"Length"+firstDispOrderVal));
		if(dispLengthFirst != null) dispLengthFirst = dispLengthFirst.value;
		else dispLengthFirst = " ";
		var configFirst = eval(document.getElementById("config"+dispLine+"Val"+firstDispOrderVal)).value;
		var elmtRefFirst = eval(document.getElementById("elmt"+dispLine+"Ref"+firstDispOrderVal)).value;
		var iconYNFirst = eval(document.getElementById("icon"+dispLine+"YN"+firstDispOrderVal)).value;
		var imageNameFirst = eval(document.getElementById("image"+dispLine+"Name"+firstDispOrderVal)).value;

		if(defSel.checked == true) defSel.value = "Y";
		else if(defSel.checked != true) defSel.value = "N";
		
		if(dispText == '') dispText = " ";
		if(toolTip == '') toolTip = " ";
		if(numSpaces == '') numSpaces = "0";

		if(defSelFirst.checked == true) defSelFirst.value = "Y";
		else if(defSelFirst.checked != true) defSelFirst.value = "N";
		
		if(dispTextFirst == '') dispTextFirst = " ";
		if(toolTipFirst == '') toolTipFirst = " ";
		if(numSpacesFirst == '') numSpacesFirst = "0";

		var concatMapValues = dispLine+'`'+defSel.value+'`'+dispOrder+'`'+elementDesc+'`'+maxLength+'`'+dispLength+'`'+numSpaces+'`'+dispText+'`'+toolTip+'`'+config+'`'+elmtRef+'`'+iconYN+'`'+imageName;

		var concatMapValuesFirst = dispLine+'`'+defSelFirst.value+'`'+firstDispOrderVal+'`'+elementDescFirst+'`'+maxLengthFirst+'`'+dispLengthFirst+'`'+numSpacesFirst+'`'+dispTextFirst+'`'+toolTipFirst+'`'+configFirst+'`'+elmtRefFirst+'`'+iconYNFirst+'`'+imageNameFirst;

		parent.patEncBannerIntermediateFrame.location.href = "../../eMP/jsp/PatEncBannerIntermediate.jsp?concatMapValues="+concatMapValues+"&dispLine="+dispLine+"&dispOrder="+dispOrder+"&concatValsForFirst="+concatMapValuesFirst+"&maxOrderForLine2="+maxOrderForLine2+"&maxOrderForLine1="+maxOrderForLine1+'&sentFromLineChange=N&firstDispOrderVal='+firstDispOrderVal+'&bannerRef='+bannerRef+'&bannerCateg='+bannerCateg;
	}
	else
	{
		var defSel = " ";
		var dispText = " ";
		var toolTip = " ";
		var numSpaces = " ";
		var elementDesc = " ";
		var maxLength = " ";
		var dispLength = " ";
		var config = " ";
		var elmtRef = " ";
		var iconYN = " ";
		var imageName = " ";

		var displayDispOrd = "";

		var defSelFirst = eval(document.getElementById("def"+dispLine+"Sel"+firstDispOrderVal));
		var dispTextFirst = eval(document.getElementById("disp"+dispLine+"Text"+firstDispOrderVal)).value;
		var toolTipFirst = eval(document.getElementById("toolTip"+dispLine+"Text"+firstDispOrderVal)).value;
		var numSpacesFirst = eval(document.getElementById("num"+dispLine+"Spaces"+firstDispOrderVal)).value;
		var elementDescFirst = eval(document.getElementById("element"+dispLine+"Desc"+firstDispOrderVal)).innerText;
		var maxLengthFirst = eval(document.getElementById("max"+dispLine+"Length"+firstDispOrderVal));
		if(maxLengthFirst != null) maxLengthFirst = maxLengthFirst.innerText;
		else maxLengthFirst = " ";
		var dispLengthFirst = eval(document.getElementById("disp"+dispLine+"Length"+firstDispOrderVal));
		if(dispLengthFirst != null) dispLengthFirst = dispLengthFirst.value;
		else dispLengthFirst = " ";
		var configFirst = eval(document.getElementById("config"+dispLine+"Val"+firstDispOrderVal)).value;
		var elmtRefFirst = eval(document.getElementById("elmt"+dispLine+"Ref"+firstDispOrderVal)).value;
		var iconYNFirst = eval(document.getElementById("icon"+dispLine+"YN"+firstDispOrderVal)).value;
		var imageNameFirst = eval(document.getElementById("image"+dispLine+"Name"+firstDispOrderVal)).value;

		if(defSel.checked == true) defSel.value = "Y";
		else if(defSel.checked != true) defSel.value = "N";
		
		if(dispText == '') dispText = " ";
		if(toolTip == '') toolTip = " ";
		if(numSpaces == '') numSpaces = "0";

		if(defSelFirst.checked == true) defSelFirst.value = "Y";
		else if(defSelFirst.checked != true) defSelFirst.value = "N";
		
		if(dispTextFirst == '') dispTextFirst = " ";
		if(toolTipFirst == '') toolTipFirst = " ";
		if(numSpacesFirst == '') numSpacesFirst = "0";

		if(dispLine == '1')
			displayDispOrd = parseInt(maxOrderForLine1,10) + 1;
		else if(dispLine == '2')
			displayDispOrd = parseInt(maxOrderForLine2,10) + 1;

		var concatMapValues = dispLine+'`'+defSel.value+'`'+displayDispOrd+'`'+elementDesc+'`'+maxLength+'`'+dispLength+'`'+numSpaces+'`'+dispText+'`'+toolTip+'`'+config+'`'+elmtRef+'`'+iconYN+'`'+imageName;

		var concatMapValuesFirst = dispLine+'`'+defSelFirst.value+'`'+firstDispOrderVal+'`'+elementDescFirst+'`'+maxLengthFirst+'`'+dispLengthFirst+'`'+numSpacesFirst+'`'+dispTextFirst+'`'+toolTipFirst+'`'+configFirst+'`'+elmtRefFirst+'`'+iconYNFirst+'`'+imageNameFirst;

		parent.patEncBannerIntermediateFrame.location.href = "../../eMP/jsp/PatEncBannerIntermediate.jsp?concatMapValues="+concatMapValues+"&dispLine="+dispLine+"&dispOrder="+displayDispOrd+"&concatValsForFirst="+concatMapValuesFirst+"&maxOrderForLine2="+maxOrderForLine2+"&maxOrderForLine1="+maxOrderForLine1+'&sentFromLineChange=N&firstDispOrderVal='+firstDispOrderVal+'&bannerRef='+bannerRef+'&bannerCateg='+bannerCateg;
	}	
}

function onSuccess()
{
	var bannerCateg = patEncBannerHdrFrame.document.patEncBannerHdrForm.patEncList.value;
	patEncBannerDetailsFrame.location.href = '../../eMP/jsp/PatEncBannerDetails.jsp?bannerCateg='+bannerCateg+'&loadFirstTime=Yes';
}

function chkUnchkSel(dispLine,dispOrder,obj)
{
	var bannerCateg = document.patEncBannerDtlForm.bannerCateg.value;
	var bannerRef = document.patEncBannerDtlForm.bannerRef.value;
	var selValue = "";
	if(obj.checked == true)
		selValue = "Y";
	else
		selValue = "N";

	parent.patEncBannerIntermediateFrame.location.href = "../../eMP/jsp/PatEncBannerIntermediate.jsp?dispOrder="+dispOrder+"&sentFromLineChange=sel&selValue="+selValue+"&dispLine="+dispLine+"&bannerRef="+bannerRef+"&bannerCateg="+bannerCateg;
}

function allowNumbers(event)
{
	var strCheck = '0123456789';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);
	if(strCheck.indexOf(key) == -1) return false;
}

function reset()
{
	patEncBannerHdrFrame.location.href = '../../eMP/jsp/PatEncBannerHeader.jsp';
	patEncBannerDetailsFrame.location.href = '../../eCommon/html/blank.html';
}

async function previewPatBanner(previewContent)
{
	var retVal = "";
	var dialogHeight = "80vh";
	var dialogWidth =	"96vw";
	var dialogTop = "10px";
	var status = "no";
	var arguments ="";
	var action_url = '../../eMP/jsp/PatEncBannerTransMain.jsp?forPreview=Yes';
	var features =	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:" + dialogTop +" ; scroll=auto; status:" + status;
	retVal = await top.window.showModalDialog(action_url,previewContent,features);
}

async function buildHTMLForPreviewBanner()
{
	
	var defSel = "";
	var HTMLLine1Content = "";
	var tempVal = 2;
	//defSel = eval(parent.patEncBannerDetailsFrame.document.getElementById("defSelect1"));
	defSel = eval(parent.patEncBannerDetailsFrame.document.getElementById("defSelect"));
	
	if(defSel && defSel.checked == true)
	{
		HTMLLine1Content = "<TR><td rowspan='2' width='48' nowrap id='tdPhoto'><span id='PAT_PHOTO'></span><img src='../../eCommon/images/PI_Photo.gif'><td id='tdLine1' nowrap>";
	}
	else
	{
		HTMLLine1Content = "<TR><td name='tdLine1' id='tdLine1' nowrap>"
	}
		
	var HTMLLine2Content = "<TR><td  name='tdLine2' id='tdLine2' nowrap>";
	var HTMLContent = "";
	var lineNum = "";
	var dispOrder = "";
	var dispText = "";
	var toolTip = "";
	var elmtRef = "";
	var numSpaces = "";
	var iconYN = "";
	var imageName = "";
	var valueForPreview = "";
	var dispLen = "";

	var cntLine1 = parent.patEncBannerDetailsFrame.document.patEncBannerDtlForm.cntLine1.value;
	var cntLine2 = parent.patEncBannerDetailsFrame.document.patEncBannerDtlForm.cntLine2.value;
	

	for(var v=2;v<=parseInt(cntLine1,10);v++)
	{
		defSel = eval(parent.patEncBannerDetailsFrame.document.getElementById("defSelect"+v));
		valueForPreview = "X";
		if(defSel.checked == true)
		{
			dispText = eval(parent.patEncBannerDetailsFrame.document.getElementById("dispText"+v)).value;
			toolTip =  eval(parent.patEncBannerDetailsFrame.document.getElementById("toolTip"+v)).value;
			elmtRef =  eval(parent.patEncBannerDetailsFrame.document.getElementById("elmt1Ref"+v)).value;
			numSpaces= eval(parent.patEncBannerDetailsFrame.document.getElementById("num1Spaces"+v)).value;
			iconYN =   eval(parent.patEncBannerDetailsFrame.document.getElementById("icon1YN"+v)).value;
			dispLen =  eval(parent.patEncBannerDetailsFrame.document.getElementById("disp1Length"+v));
			imageName =eval(parent.patEncBannerDetailsFrame.document.getElementById("image1Name"+v)).value;
			if(dispLen != null) dispLen = dispLen.value;
			else dispLen = "";

			if(toolTip == ' ') toolTip = '';

			if(numSpaces != '' && numSpaces != ' ')
			{
				for(var t=0;t<parseInt(numSpaces,10);t++)
				{
					HTMLLine1Content += "&nbsp;";
				}
			}
			if(dispText != '' && dispText != ' ')
				HTMLLine1Content += "<span class='legendClassRow1'>"+dispText+" : </span>";

			if(iconYN == 'Y' || iconYN == 'y')
				HTMLLine1Content += "<span class='image' title='"+toolTip+"'><img src='../../eCommon/images/"+imageName+"'>&nbsp;</span>";
			else
			{
				if(dispLen != "")
				{
					for(var t=1;t<parseInt(dispLen,10);t++)
					{
						valueForPreview += 'x';
					}
				}
				HTMLLine1Content += "<span class='valueClassRow1' title='"+toolTip+"'>&nbsp;"+valueForPreview+"</span>";
			}
			//HTMLLine1Content += "&nbsp;";
		}
	}
	
	for(var v=1;v<=parseInt(cntLine2,10);v++)
	{
		defSel = eval(parent.patEncBannerDetailsFrame.document.getElementById("defSelect"+v));
		valueForPreview = "X";
		if(defSel.checked == true)
		{
			dispText = eval(parent.patEncBannerDetailsFrame.document.getElementById("dispText"+v)).value;
			toolTip =  eval(parent.patEncBannerDetailsFrame.document.getElementById("toolTip"+v)).value;
			elmtRef =  eval(parent.patEncBannerDetailsFrame.document.getElementById("elmt2Ref"+v)).value;
			numSpaces =eval(parent.patEncBannerDetailsFrame.document.getElementById("num2Spaces"+v)).value;
			iconYN =   eval(parent.patEncBannerDetailsFrame.document.getElementById("icon2YN"+v)).value;
			dispLen =  eval(parent.patEncBannerDetailsFrame.document.getElementById("disp2Length"+v));
			imageName =eval(parent.patEncBannerDetailsFrame.document.getElementById("image2Name"+v)).value;
			if(dispLen != null) dispLen = dispLen.value;
			else dispLen = "";

			if(toolTip == ' ') toolTip = '';

			if(numSpaces != '' && numSpaces != ' ')
			{
				for(var t=0;t<parseInt(numSpaces,10);t++)
				{
					HTMLLine2Content += "&nbsp;";
				}
			}
			if(dispText != '' && dispText != ' ')
				HTMLLine2Content += "<span class='legendClassRow2'>"+dispText+" : </span>";

			if(iconYN == 'Y' || iconYN == 'y')
				HTMLLine2Content += "<span title='"+toolTip+"'><img src='../../eCommon/images/"+imageName+"'>&nbsp;</span>";
			else
			{
				if(dispLen != "")
				{
					for(var t=1;t<parseInt(dispLen,10);t++)
					{
						valueForPreview += 'x';
					}
				}
				HTMLLine2Content += "<span title='"+toolTip+"' class='ValueClassRow2'>&nbsp;"+valueForPreview+"</span>";
			}
			//HTMLLine2Content += "&nbsp;";
		}
	}
	HTMLLine1Content += "</td></tr>";
	HTMLLine2Content += "</td></tr>";

	HTMLContent = HTMLLine1Content + HTMLLine2Content;
	await previewPatBanner(escape(HTMLContent));
}

function loadDefault()
{
	var bannerCateg = document.patEncBannerDtlForm.bannerCateg.value;
	self.location.href = '../../eMP/jsp/PatEncBannerDetails.jsp?bannerRef=Sys&bannerCateg='+bannerCateg+'&loadFirstTime=Yes';
}

async function callPatientProfile(patient_id,episode_id)
{
	var dialogHeight= "1000px" ;//"29"
	var dialogWidth	= "1200px" ;//"42"
	var dialogTop	= "10px";//76
	var dialogLeft	= "40";//"85"
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no ";

	await top.window.showModalDialog("../../eCA/jsp/PatientProfileMain.jsp?patient_id="+patient_id+"&encounter_id="+episode_id,arguments,features);
}

async function callAllery(patient_id)
{
	var dialogHeight= "1000px" ;//"29"
	var dialogWidth	= "1350px" ;//"42"
	var dialogTop	= "10";
	var features    =  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";scroll=auto; status:no ";

	//var retVal=	window.showModalDialog('../../eCA/jsp/PaintPatAllegyResult.jsp?patient_id='+patient_id+'&modal_yn=Y',arguments,features);
	var retVal=	await top.window.showModalDialog('../../eCA/jsp/AllergyList.jsp?called_from_ip=Y&patient_id='+patient_id,arguments,features);
}

async function researchPatient(patient_id)
{
	var dialogHeight= "400px" ;//"29"
	var dialogWidth	= "700px" ;//"42"
	var dialogTop	= "10";
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+";scroll=no; status:no ";
	await window.showModalDialog("../../eCA/jsp/ResearchPatient.jsp?patient_id="+patient_id,arguments,features);
	return false;
}

async function callDemographics(patient_id)
{
	var dialogHeight= "800px" ;
	var dialogWidth	= "1000px" ;
	var dialogTop	= "76";
	var status = "no";
	var arguments	= "" ;
	/*Below line added for ML-MMOH-CRF-0860.2*/
	//Commented By Dharma for SKR-SCF-1528 
	/*var alternate_id="";
	if(document.patLineForm){
		if((document.patLineForm.increasedaddressLength && document.patLineForm.increasedaddressLength.value=="true") && (document.patLineForm.alterAddressApplicable && document.patLineForm.alterAddressApplicable.value=="true")){
		   alternate_id="ViewAlternateId";
		}
	}*/
	//End ML-MMOH-CRF-0860.2
	
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=yes;  status:" + status;
	//window.showModalDialog("../../eCA/jsp/DemographicsView.jsp?patient_id="+patient_id+"&alternate_id="+alternate_id,arguments,features);
	await window.showModalDialog("../../eCA/jsp/DemographicsView.jsp?patient_id="+patient_id,arguments,features);
	return false;	
}

	//Added the below function for RUT-CRF-0016 IN023399 on 27.09.2010 by Suresh M
    //Below code was modified by N Munisekhar on 15-Nov-2012 against SKR-SCF-0711 [IN036143]
	async function callRemarks(remarks) { 	 
		var obj = new Object(); 	
	//	obj.data =decodeURIComponent(remarks);	 	
		obj.data =remarks;	 		 
		var url="../../eMP/jsp/Remarks.jsp";
		var arg="dialogHeight:25;dialogWidth:28; edge:sunken;resizable:no;status:no;scroll:no";	
		await window.showModalDialog(url,obj,arg);	
	}
 //end SKR-SCF-0711 [IN036143]
 async function callProcedureDetails(patient_id,cnt){  
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;	 
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=auto; resizable:no; status:" + status; 
	await window.showModalDialog("../../eMP/jsp/ViewProcedureDetails.jsp?patient_id="+patient_id,arguments,features);
//	return false;
 }


 async function callAllery(patient_id)
{
	var dialogHeight= "1000px" ;//"29"
	var dialogWidth	= "1350px" ;//"42"
	var dialogTop	= "10";
	var features    =  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";scroll=auto; status:no ";

	//var retVal=	window.showModalDialog('../../eCA/jsp/PaintPatAllegyResult.jsp?patient_id='+patient_id+'&modal_yn=Y',arguments,features);
	var retVal=	await window.showModalDialog('../../eCA/jsp/AllergyList.jsp?called_from_ip=Y&patient_id='+patient_id,arguments,features);
}

/*Below Line Added for this CRF [Bru-HIMS-CRF-178]*/
async function patientNotes(patient_id,encounter_id)
{     
	var visit_date_time = document.forms[0].visit_date_time.value
	var TOOL_TIP_TEXT = document.forms[0].TOOL_TIP_TEXT.value
	var dialogHeight= "700px" ;//"29"
	var dialogWidth	= "1000px" ;//"42"
	var dialogTop	= "76";
	var features    =  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+";resizable:Yes;scroll=no; status:no ";

	var retVal=await window.showModalDialog('../../eMP/jsp/AddPatinetNotesFrames.jsp?patientid='+patient_id+'&encounter_id='+encounter_id+'&visit_date_time='+visit_date_time+'&TOOL_TIP_TEXT='+TOOL_TIP_TEXT,arguments,features);
	
}

//End CRF [Bru-HIMS-CRF-178]
async function callMyHix(pat_id,enc_id){ //Added for MYHIX integration ML-MMOH-CRF-0507.1
		var dialogTop = "10" ;
		var dialogHeight= "400px" ;
		var dialogWidth	= "700px" ;
		var status = "no";
		var arguments	= "" ;
		var tit="locn_Srch";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=yes; status:" + status;
		retVal = await window.showModalDialog('../../eMP/jsp/MyHixSearch.jsp?Patient_ID='+pat_id+'&enc_id='+enc_id+"&title=MyHixSearch",arguments,features);

	
}
/*Added by Thamizh selvi on 4th June 2018 against MMS-DM-CRF-0115 Start*/
//function callClinicalDataRepository(patientId,encounterId,patientClass)
async function callClinicalDataRepository(patientId,nationalityId,altID1)
{
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var dialogTop	= "10";
	var dialogLeft	= "30";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=no; status:no ";

	//window.showModalDialog("../../eCA/jsp/CDRMain.jsp?patient_id="+patientId+"&encounter_id="+encounterId+"&resp_id=CA&patient_class="+patientClass,arguments,features);
	await window.showModalDialog("../../eCA/jsp/CDRMain.jsp?patient_id="+patientId+"&nationalityId="+nationalityId+"&resp_id=CA&altID1="+altID1,arguments,features);
}/*End*/

/* Added by Prakash for PMG2023-COMN-CRF-0002.4 */ 
async function callArchivalData(login_user_id,user_password,facility_id,patient_id,episode_id,ArchivalDBUrl)
{  
	var dialogHeight= "90vh" ;//"29"
	var dialogWidth	= "80vw" ;//"42"
	var dialogTop	= "10";
	var features    =  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+";scroll=auto; status:no ";

	//var retVal=	window.showModalDialog('../../eCA/jsp/PaintPatAllegyResult.jsp?patient_id='+patient_id+'&modal_yn=Y',arguments,features);
	var retVal=	await top.window.showModalDialog(ArchivalDBUrl+'&p_login_user='+login_user_id+'&p_user_password='+user_password+'&p_patient_id='+patient_id+'&p_facility_id='+facility_id+'&p_encounter_id='+episode_id,arguments,features);
}
