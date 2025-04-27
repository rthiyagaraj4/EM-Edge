var dtlExpanded = 0;
var displayHdrVKB = 0;
var rowNumber = 0; //For Resources added
var rsrcIdSelected='`';
var countryRgn = "";
var inputArr ="";

//While loading the page the Virtual key board has to be linked to some field. So defaulted to 'Requester Name'
// To store the current element's id to return text typed from VKB.
var currentEle = 'VkbImg';
var nextId = '';
var keyBoardVisible = 0; // To remember the status of VKB, whether visible or hidden
function assignCurEle(obj) 
	{
	
		if ( currentEle!=obj.id && displayHdrVKB=='Y')
		{
		
			currentEle=obj.id;
			/* If keyboard is in closed state, no need to close it*/
			if (keyBoardVisible==1)
				VKI_close();
			VKI_attach(document.getElementById(currentEle));
			getNextId();
		}
	}

function getNextId()
{
	var ind1 = elemStr.indexOf(currentEle);
	var ind2 = elemStr.indexOf('~',ind1);
	var ind3 = elemStr.indexOf('~',ind2+1);
	nextId= elemStr.substr(ind2+1,(ind3-(ind2+1)));
}

function showActPickUp(obj) 
{
	if (obj.checked==true)
	{
		obj.value= "Y";
		//document.getElementById('actualPickupRow').style.display='inline';
		document.getElementById('ambStartMeter').style.display='inline';
		document.getElementById('ambExpDist').style.display='inline';
		document.getElementById('ambResEq').style.display='inline';
				  d = new Date();
		  var s= padZero(d.getDate()) + "/";
		  s += padZero(d.getMonth()+1)+"/";
		  s += d.getYear()+" ";
		  s += padZero(d.getHours())+":";
		  s += padZero(d.getMinutes());
		  document.getElementById('actualPickupTime').value=s;
		  document.getElementById('ambInput').className='text-box-mand'; 

		var ambid=document.getElementById("ambInputCode").value;
			document.getElementById('tripStatusRow').style.display="none";
		if(!ambid=="" || !ambid==null || !ambid=='null' || !ambid=='undefined')getResourcesAllocated("insert",ambid,"");
	}
	else
	{
		obj.value= "N";
	//	document.getElementById('actualPickupRow').style.display='none';
		document.getElementById('ambStartMeter').style.display='none';
		document.getElementById('ambExpDist').style.display='none';
		document.getElementById('ambResEq').style.display='none';
		document.getElementById('actualPickupTime').value="";
		document.getElementById('ambInput').className='text-box'; 
		document.getElementById('tripStatusRow').style.display="inline";
	}


}
function goHomePage(){
	document.location.href="../../eCommon/jsp/CommonClearObjects.jsp";
}
function goRefreshPage(){

	var formObj=document.frmAmbMangmntSystem;
	from_date	=	formObj.from_date.value;
	to_date		=	formObj.to_date.value;
	document.location.href="../../eAE/jsp/AmbulanceManagementSystem.jsp?from_date="+from_date+"&to_date="+to_date;
}

function callOnClick(){
	
 }

 function expandHorizontaly(div1,div2,imgExp,pos,left1,width1,left2,width2){
  	var imgexp=document.getElementById(imgExp);
	var divExp=document.getElementById(div1);
	var divHide=document.getElementById(div2);
	 divHide.style.display="none";
	 divExp.style.left=left1;
	 divExp.style.width=width1;
	 document.getElementById("menubuttonsfromjavascript").style.display="inline";

	 if(pos=='left'){
		 imgexp.src="../../eAE/images/ADSRight.gif";
		 toggleDataTable('tbl');
		 document.frmAmbMangmntSystem.wStatus.value='rightExp';
		 document.getElementById("spnPrevNext").style.display='none';
	 }else{ 
		 imgexp.src="../../eAE/images/ADSLeft.gif";
		 toggleDataTable('all');
		 divExp.style.zIndex='500';
		 document.frmAmbMangmntSystem.wStatus.value='leftExp';
	 }
	 imgexp.onclick=function(){	
        resizeHorizontaly(div1,div2,imgExp,pos,left2,width2,left1,width1);
	 }
	
	//Set the paginator containers here 
//	window.myDataTable.paginator = window.pag;	
	
 }

 function resizeHorizontaly(div1,div2,imgExp,pos,left1,width1,left2,width2){
	 var imgexp=document.getElementById(imgExp);
	 var divReSize=document.getElementById(div1);
	 var divShow=document.getElementById(div2);
	 divShow.style.display="inline";
	 divReSize.style.left=left1;
	 divReSize.style.width=width1;
	 document.getElementById("menubuttonsfromjavascript").style.display="none";
	  if(pos=='left'){
	
		 imgexp.src="../../eAE/images/ADSLeft.gif"; 
         toggleDataTable('img');
		 document.getElementById("spnPrevNext").style.display='';
	 }else{
		 imgexp.src="../../eAE/images/ADSRight.gif";
		 toggleDataTable('few');
		 divReSize.style.zIndex='4';
	 }

	 document.frmAmbMangmntSystem.wStatus.value='normal';

	 imgexp.onclick=function(){
        expandHorizontaly(div1,div2,imgExp,pos,left2,width2,left1,width1);
	 }

}

function switchView()
{
	if (dtlExpanded==0)
	{
		expandVertically('Layer4A','Layer6A','Layer5A','imgTop','6%','92%','48%','49%');
		dtlExpanded=1;
	}
	else
	{
		resizeVertically('Layer4A','Layer6A','Layer5A','imgTop','48%','49%','6%','92%');
		dtlExpanded=0;
	}
}

function expandVertically(div1,div2,div3,imgExp,top1,height1,top2,height2){

	var imgexp=document.getElementById(imgExp);
	var divExp=document.getElementById(div1);
	var divHide1=document.getElementById(div2);
	var divHide2=document.getElementById(div3);
	 divHide1.style.display="none";
	 divHide2.style.display="none";
	 divExp.style.top=top1;
	 divExp.style.height=height1;
	 
	 if(divExp.id=='Layer4A'){
		 document.getElementById("sexAutoComplete").style.setAttribute("marginTop", 3+"px", false);
	 }
	 
	 imgexp.src="../../eAE/images/ADSDown.gif";
	 imgexp.onclick=function(){

        resizeVertically(div1,div2,div3,imgExp,top2,height2,top1,height1);
	 }
	document.getElementById('pickUpAddRow').style.display="inline";
	document.getElementById('dropAddRow').style.display="inline";
	document.getElementById('escortRow').style.display="inline";
	document.getElementById('attdByRow').style.display="inline";
	document.getElementById('gMapRow').style.display="inline";
	document.getElementById('amdTypeRow').style.display="inline";
	document.getElementById('rsrcAllocDiv').style.display="inline";
	//document.getElementById('distCovered').style.display="inline";
	//For Rounded corners
	document.getElementById('fillerCell').innerHTML="<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>";
 }

 function resizeVertically(div1,div2,div3,imgExp,top1,height1,top2,height2){
	var imgexp=document.getElementById(imgExp);
	var divExp=document.getElementById(div1);
	var divHide1=document.getElementById(div2);
	var divHide2=document.getElementById(div3);
	 divHide1.style.display="inline";
	 divHide2.style.display="inline";
	 divExp.style.top=top1;
	 divExp.style.height=height1;
	 if(divExp.id=='Layer4A'){
		 document.getElementById("sexAutoComplete").style.setAttribute("marginTop", 0+"px", false);
	 }
	 
	 
	 
	 imgexp.src="../../eAE/images/ADSUp.gif";
	 imgexp.onclick=function(){
        expandVertically(div1,div2,div3,imgExp,top2,height2,top1,height1);
	 }
	document.getElementById('pickUpAddRow').style.display="none";
	document.getElementById('dropAddRow').style.display="none";
	document.getElementById('escortRow').style.display="none";
	document.getElementById('attdByRow').style.display="none";
	document.getElementById('gMapRow').style.display="none";
	document.getElementById('amdTypeRow').style.display="none";
	document.getElementById('rsrcAllocDiv').style.display="none";
	
	//document.getElementById('distCovered').style.display="none";
	//For Rounded corners
	document.getElementById('fillerCell').innerHTML="<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>";
 }

 function toggleDataTable(type){

	 divAllObj	=document.getElementById("ambRequstAll");
	 divPagAllObj	=document.getElementById("dt-paginatorAll");
	 divObj		=document.getElementById("ambRequst");
	 divPagObj		=document.getElementById("dt-paginator");
	 divChartTbl=document.getElementById("ambChartTable");
	 divChartPagTbl=document.getElementById("chartPaginatorTbl");
	 divChartPag=document.getElementById("dt-chartPaginator");
	 divChartImg=document.getElementById("ambChartImage");

	 if(type=='all'){

		divObj.style.display="none";
		divPagObj.style.display="none";	
	
		 
		divAllObj.style.display="inline";		
		divPagAllObj.style.display="inline";
		 
	 }else if(type=='few'){
	
		 divAllObj.style.display="none";		
		 divPagAllObj.style.display="none"; 	
		
		 divObj.style.display="inline";
		 divPagObj.style.display="inline";
		 
	 }else if(type=='tbl'){
		 divChartImg.style.display="none";
		 divChartTbl.style.display="inline";
		 divChartPagTbl.style.display="inline";
		 divChartPag.style.display="inline";
	 }else if(type=='img'){
		 divChartTbl.style.display="none";
		 divChartPagTbl.style.display="none";
		 divChartPag.style.display="none";
		 divChartImg.style.display="inline";
	 }
}

function loadAmbEntryDiv(status,ambtype,regno,id,name,phone,patDet,caseno,loc){
	var divObj	=document.getElementById("ambChartImageAll");
    var divObj1,divObj2;
	var classname,imgSRC;
	switch(ambtype){
		case 'R':
		   imgSRC="url('../../eAE/images/Ambulance.gif')";
		break;
				
		case 'M':
			imgSRC="url('../../eAE/images/boatambulance.gif')";
		break;
				
		case 'A':
			imgSRC="url('../../eAE/images/airambulance.gif')";
		break;
	}
    if(status=="B"){
		divObj1	=document.getElementById("ambSatausB");
		divObj2	=document.getElementById("ambSelAmbB");
		classname="ambchartB";
		loadMaintDet(id,"B");
		document.frmAmbMangmntSystem.selAmbId.value=id;
	}else if(status=="M"){
		divObj1	=document.getElementById("ambSatausM");
		divObj2	=document.getElementById("ambSelAmbM");
		classname="ambchartM";
		loadMaintDet(id,'M');
		document.frmAmbMangmntSystem.selAmbId.value=id;
	}else if(status=="A"){
		divObj1	=document.getElementById("ambSatausA");
		divObj2	=document.getElementById("ambSelAmbA");
		classname="ambchartA";
		loadMaintDet(caseno,'A');
		document.frmAmbMangmntSystem.selAmbId.value=id;
		document.frmAmbMangmntSystem.selCaseno.value=caseno;
	}
     divObj.style.display="none";
	divObj1.style.display="inline";

	if(!phone=='')
		divObj2.innerHTML="<div class='chartText'>"+id+"<br>"+regno+"<br>"+loc+"<br>"+name+"("+phone+")<br>"+patDet+"</div>";
	else
		divObj2.innerHTML="<div class='chartText'>"+id+"<br>"+regno+"<br>"+loc+"<br>"+name+"<br>"+patDet+"</div>";
	
	divObj2.className=classname;
	divObj2.style.backgroundImage=imgSRC;
	
}


function closeEntryDiv(divname){
	var divObj	=document.getElementById("ambChartImageAll");
	var divObj1	=document.getElementById(divname);
    divObj.style.display="inline";
	divObj1.style.display="none";
}

function showCalendar1(str1,str2,str3,str4,str5,str6,str7){
	showCalendar(str1,str2,str3,str4);

	if(str6=='To'){
		//if(!ValidateDtTime(document.getElementById("from_date").value+" 00:00",eval("document.all."+str1).value+" 00:01")){
			if(!ValidateDtTime(document.getElementById("from_date").value+" 00:00",document.getElementById(str1).value+" 00:01")){
			//eval("document.all."+str1).value=document.getElementById(str5).innerText;
			//eval("document.all."+str1).value	= str7;
			document.getElementById(str1).value	= str7;
			alert(getMessage("TO_DT_GR_FM_DT","AE"));
			//Alert('APP-000075 To Date should be Greater than From Date.');
			return;
		}
	}else{
		if(!ValidateDtTime(document.getElementById(str1).value+" 00:00",document.getElementById("to_date").value+" 00:01")){
			//eval("document.all."+str1).value=document.getElementById(str5).innerText;
			document.getElementById(str1).value	= str7;
			alert(getMessage("TO_DT_GR_FM_DT","AE"));
			//Alert('APP-000075 To Date should be Greater than From Date.');
			return;
		}
	}
	
	if(document.getElementById(str1).value!=""){
		var lblDate= document.getElementById(str5);
		lblDate.innerText=str6+":"+document.getElementById(str1).value;
	}else{
		document.getElementById(str1).value	= str7;
	}

}

function setSelctedAmbId(txt){
		
	if(txt==""){
		if(document.frmAmbMangmntSystem.dragAmbId.value!="")
			try{
		document.getElementById(document.frmAmbMangmntSystem.dragAmbId.value).style.border="1px solid black";
		}catch(e){}
	}else{
		try{
		document.getElementById(txt).style.border="1px solid red";
		}catch(e){}
	}
	
	document.frmAmbMangmntSystem.dragAmbId.value=txt;
}

function populateReqstdAmb(ambDet){
  /** ambDet will have all selected values 
A,M,BT-41233-3435,AMB-0006,Boat Ambulance -006,john sam,988636755,3,Srinivas Rao Gender: Male Age: 37Y
	*/
	data= ambDet.split("~");
	status = data[0];
	type = data[1];
	regno = data[2];
	ambid = data[3];
	amb_desc = data[4];
	contact_no= data[5];
	phone = data[6];
	ambcaseno = data[7];
	patDet = data[8];
	loc=data[9]
	if (ambcaseno==null)
		ambcaseno = ' ';
	/* To do - Based on Case number need to fire query and get all patient values */

	if(status=='A'){
		callOnClickRequested(ambcaseno);
	}
	else{
	loadAmbReqDiv(status,type,regno,ambid,contact_no,phone,patDet,ambcaseno,loc);
	document.getElementById("ambInput").innerText=amb_desc;
	document.getElementById("ambInputCode").innerText=ambid;
	//getResourcesAllocated("insert",ambid,"");
	document.getElementById("tripStatusRow").style.display='none';
	}
}

function getResourcesAllocated(mode,amb_vehicle_id,amb_case_no)
{
	var rscrAlloc = document.getElementById('rsrcAllocated').value ;

	rsrcIdSelected='`';

	var rowCnt = document.getElementById("rsrcAllocDiv").rows.length;
	for (i=0; i<rowCnt; ++i )
		document.getElementById("rsrcAllocDiv").deleteRow(0);

	/* To clear resource Details */
	var rowCnt = document.getElementById("rsrcDiv").rows.length;
	for (i=0; i<rowCnt; ++i )
		document.getElementById("rsrcDiv").deleteRow(0);
	
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlHttp.open("POST", "../../eAE/jsp/AMBValidate.jsp?function_type=loadResources&amb_vehicle_id="+amb_vehicle_id+"&mode="+mode+"&amb_case_no="+amb_case_no, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;

	var data = (trimString(responseText)).split('`');// The position is appended to the Resource code

	if (data[0]!='' && data[0]!=null && data[0]!='null' && data[0]!='undefined'){
		
		var arr=data[0].split('~');
		document.getElementById('ambStrtMilUom').innerHTML = arr[0];
		document.getElementById('ambEndMilUom').innerHTML = arr[0];
		document.getElementById('totDistUom').innerHTML = arr[0];
		document.getElementById('distCovUom').innerHTML = arr[0];
		document.getElementById('ambUom').value = arr[1];
	}
		
	//document.getElementById('startMileage').value = data[1];
	assignValue('startMileage',data[1]);

	for (var x = 2, rec; rec = data[x++];)
	{
		var resource = rec.split('~');
		var code=resource[0];
		var position = resource[1];
		var positionVal = resource[2];
		var description = resource[3];

		if (position=='') 
		{
			position='&nbsp';
		}

			var rowvar = document.getElementById("rsrcAllocDiv").insertRow();
			//rowvar.id = "trRowId"+rowNumber+noOfRows.value
			var cellvar = rowvar.insertCell();
			cellvar.className=	"label"
			cellvar.width='5%';
			cellvar.insertAdjacentHTML("BeforeEnd","<input type='checkbox' id='rsrcChk"+rowNumber+"' checked value='"+code+"~"+positionVal+"' onclick='changeVal(this);'>");
			cellvar = rowvar.insertCell();
			cellvar.className=	"label";
			cellvar.width='30%';
			cellvar.noWrap=true;
			cellvar.insertAdjacentHTML("BeforeEnd","<b>"+description+"<b>");
			cellvar = rowvar.insertCell();
			cellvar.className=	"label"
			cellvar.insertAdjacentHTML("BeforeEnd","<b>"+position+"<b>");
			rowNumber++;
			rsrcIdSelected = rsrcIdSelected+code+'~'+positionVal+'`';
			document.getElementById('rsrcAllocated').value = rsrcIdSelected;
	}

	if (rsrcIdSelected!='')
		document.getElementById('ambInput').className='text-box-mand';

}

       
function loadAmbReqDiv(status,ambtype,regno,id,name,phone,patDet,ambcaseno,loc){
	var divObj	=document.getElementById("ambChartR");
	var classname,imgSRC;
	switch(ambtype){
		case 'R':
		   imgSRC="url('../../eAE/images/Ambulance.gif')";
		break;
				
		case 'M':
			imgSRC="url('../../eAE/images/boatambulance.gif')";
		break;
				
		case 'A':
			imgSRC="url('../../eAE/images/airambulance.gif')";
		break;
	}
    if(status=="B"){
		bgColor="#DFFFDF";
	}else if(status=="M"){
		bgColor="#E1E1E1";
	}else if(status=="A"){
		bgColor="#ECD9D9";
	}
	
	if(checkNull(phone)!="")
		divObj.innerHTML="<div class='chartText'>"+id+"<br>"+regno+"<br>"+checkNull(loc)+"<br>"+checkNull(name)+"("+checkNull(phone)+")<br>"+checkNull(patDet)+"</div>";
	else
	   divObj.innerHTML="<div class='chartText'>"+id+"<br>"+regno+"<br>"+checkNull(loc)+"<br>"+checkNull(name)+"<br>"+checkNull(patDet)+"</div>";

	divObj.style.backgroundImage=imgSRC;
	divObj.style.backgroundColor=bgColor;
	divObj.style.display="inline";
	divObj.style.border="1px solid black";
}


function getSelctedAmbId(){
	return (document.frmAmbMangmntSystem.dragAmbId.value=="")?true:false;
}


async function searchCode(desc,code,SearchType)	{
			var retVal = 	""; 
			var dialogHeight= "28vh" ;
			var dialogWidth	= "43vw" ;
			var status = "no";
			var arguments	= "" ;
			var search_code="";
			var search_desc="";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll:no; status:" + status;
			var tit = "";
			var sql = "";

			if (SearchType=='pract')
			{
					tit="Resource"
					sql="select practitioner_id, practitioner_name  from am_pract_for_amb_vw";
					search_code ="practitioner_id";
					search_desc = "practitioner_name";
			}
			else if (SearchType=='applUser')
			{
					tit="Resource"
					sql="select appl_user_id,appl_user_name from sm_appl_user where eff_status = `E` ";
					search_code ="appl_user_id";
					search_desc = "appl_user_name";
			}
		
			retVal =await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit+"&dispDescFirst=dispDescFirst",arguments,features);
			var arr=new Array();

			if (retVal != null && retVal != '' && retVal != "null")
			{
				var retVal=unescape(retVal);
		   		arr=retVal.split("::");
				document.getElementById(desc).innerText=arr[0];
				document.getElementById(code).value=arr[1];
			}
} 

function reQueryPage(){
	var formObj=document.frmAmbMangmntSystem;
	var mFlag,aFlag,bFlag,reqFlag,asnFlag,comFlag,canFlag,from_date,to_date;
	mFlag		=	(formObj.ambMntnce.checked)?"M":"N";
	aFlag		=	(formObj.ambAssnd.checked)?"A":"N";
	bFlag		=	(formObj.ambAvlble.checked)?"B":"N";
	
	reqFlag		=	(formObj.chkRqstd.checked)?"R":"X";
	asnFlag		=	(formObj.chkAssnd.checked)?"A":"X";
	comFlag		=	(formObj.chkCmpltd.checked)?"C":"X";
	canFlag		=	(formObj.chkCancld.checked)?"X":"N";
	from_date	=	formObj.from_date.value;
	to_date		=	formObj.to_date.value;
	selOrder=formObj.selOrder.value;
	document.location.href="../../eAE/jsp/AmbulanceManagementSystem.jsp?reqFlag="+reqFlag+"&asnFlag="+asnFlag+"&comFlag="+comFlag+"&canFlag="+canFlag+"&mFlag="+mFlag+"&aFlag="+aFlag+"&bFlag="+bFlag+"&from_date="+from_date+"&to_date="+to_date+"&selOrder="+selOrder;
}

function reQueryPage(pagination){
	var formObj=document.frmAmbMangmntSystem;
	var mFlag,aFlag,bFlag,reqFlag,asnFlag,comFlag,canFlag,from_date,to_date;
	mFlag		=	(formObj.ambMntnce.checked)?"M":"N";
	aFlag		=	(formObj.ambAssnd.checked)?"A":"N";
	bFlag		=	(formObj.ambAvlble.checked)?"B":"N";
	
	reqFlag		=	(formObj.chkRqstd.checked)?"R":"X";
	asnFlag		=	(formObj.chkAssnd.checked)?"A":"X";
	comFlag		=	(formObj.chkCmpltd.checked)?"C":"X";
	canFlag		=	(formObj.chkCancld.checked)?"X":"N";
	from_date	=	formObj.from_date.value;
	to_date		=	formObj.to_date.value;
	selOrder	=	formObj.selOrder.value;
	queStart	=	formObj.queStart.value;
	queEnd		=	formObj.queEnd.value;
	chartStart	=	formObj.chartStart.value;
	chartEnd	=	formObj.chartEnd.value;
	wStatus		=	formObj.wStatus.value;

	if(pagination=='refresh')
		document.location.href="../../eAE/jsp/AmbulanceManagementSystem.jsp?reqFlag="+reqFlag+"&asnFlag="+asnFlag+"&comFlag="+comFlag+"&canFlag="+canFlag+"&mFlag="+mFlag+"&aFlag="+aFlag+"&bFlag="+bFlag+"&from_date="+from_date+"&to_date="+to_date+"&selOrder="+selOrder;
	else
		document.location.href="../../eAE/jsp/AmbulanceManagementSystem.jsp?reqFlag="+reqFlag+"&asnFlag="+asnFlag+"&comFlag="+comFlag+"&canFlag="+canFlag+"&mFlag="+mFlag+"&aFlag="+aFlag+"&bFlag="+bFlag+"&from_date="+from_date+"&to_date="+to_date+"&selOrder="+selOrder+"&pageString="+pagination+"&queStart="+queStart+"&queEnd="+queEnd+"&chartStart="+chartStart+"&chartEnd="+chartEnd+"&wStatus="+wStatus;
}


function getPatID()
{					  
	var pat_id=PatientSearch();
	document.getElementById('patient_id').value = pat_id ;
	if( pat_id != null )						
	{		
		var xmlHttp = new XMLHttpRequest();
		var xmlDoc="";
		xmlHttp.open("POST", "../../eAE/jsp/AMBValidate.jsp?patient_id="+pat_id+"&function_type=patSearch", false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		var data = responseText.split("~");
		
		document.getElementById('patName').value = data[0] ;	
		document.getElementById('sexInput').value = data[1] ;	
		document.getElementById('patAge').value = data[2] ;	
	}
}


function getLocn(locnObj)
{
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlHttp.open("POST", "../../eAE/jsp/AMBValidate.jsp?function_type=getLocn", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	var data = responseText.split("~");
	if (locnObj.id=='pickUpLocn')
	{
		document.getElementById('locnInputCode').value=trimString(data[1]);
		document.getElementById('locnInput').value=data[2];
		document.getElementById('mapLocnRegn').value=data[3];
	}
	else
	if (locnObj.id=='dropLocn')
	{
		document.getElementById('toLocnInputCode').value=trimString(data[1]);
		document.getElementById('toLocnInput').value=data[2];
	}
}
		
//To load UOM and Location Values
function getDfltValues()
{
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlHttp.open("POST", "../../eAE/jsp/AMBValidate.jsp?function_type=getDfltVals", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	var data = responseText.split("~");
	
	document.getElementById('ambStrtMilUom').innerHTML=data[1];
	document.getElementById('ambEndMilUom').innerHTML=data[1];
	document.getElementById('facAStrtMilUom').value = data[5];
	document.getElementById('facAStrtMilUomText').value = data[1];
	document.getElementById('totDistUom').innerHTML=data[1];
/*	if (document.getElementById('distCovered').style.display=='inline')*/
		document.getElementById('distCovUom').innerHTML=data[1];
	document.getElementById('ambUom').value=trimString(data[5],"\\n");

	if (document.getElementById('emRow').style.display=='inline')
		document.getElementById('ambEndMilUom').innerHTML=data[1];

	document.getElementById('virtKeypadDisplayYn').value=data[2]; 
	document.getElementById('virKeypadDispFldYn').value=data[3];
	document.getElementById('mapLocnRegn').value=data[4];
	document.getElementById('amb_prefix_ind').value=data[6];
	countryRgn = data[4];
	
	if (data[2]=='Y')
	{
		document.getElementById('VkbImg').style.display='inline';
	}
	if (data[3]=='Y')
	{
		displayHdrVKB = 0;
		document.getElementById('keyPadId').style.display='none';
	}
	else
	if (data[3]=='N' && data[2]=='N')
	{
		displayHdrVKB = 0; // Do not display hrd key board
	}
	else
		displayHdrVKB = 1;

	loadVirtualKeyPad(data[2],data[3]);
}

function insertMapVals() {
	document.getElementById('mapLocnRegn').value = countryRgn + document.getElementById('locnInput').value;
	
}

function loadVirtualKeyPad(vkbDisplayYn,vkbDispFldYn)
{
	
	if (vkbDispFldYn=='Y')
	{
		displayVirtualKeyPad();
	}
	else
	{
		if (vkbDisplayYn=='Y')
		{
			document.getElementById('VkbImg').classname= document.getElementById('VkbImg').classname+"-vkb";
		}
	}
}

/*function displayVkb()
{
	displayHdrVKB = 1;
	displayVirtualKeyPad();
}
*/
function getElementsByClassName(cl,divID) {
	var retnode = [];
	var myclass = new RegExp('\\b(?![A-Z0-9._-]+)'+cl+'(?![A-Z0-9._-]+)\\b'); // To match whole word. No include/contains search
	var elem = document.getElementById(divID).getElementsByTagName('*');
	for (var i = 0; i < elem.length; i++) {
	var classes = elem[i].className;
	if (myclass.test(classes)) { retnode.push(elem[i]);}
	}
	return retnode;
}

function displayVirtualKeyPad()
{
	
		var inputEle = [
				  getElementsByClassName('text-box','Layer1'),
				  getElementsByClassName('text-box-mand','Layer1'),
				  getElementsByClassName('text-area','Layer1'),
				  getElementsByClassName('text-area-mand','Layer1')
			];
		for (var x = 0, elem; elem = inputEle[x++];)
		  for (var y = 0, ex; ex = elem[y++];)
			{
				if ( ex.className.indexOf("-vkb") == -1 )
				{
					ex.className=ex.className+"-vkb";
				}
			}
			//VKI_buildKeyboardInputs(); // To attach the keypad to the elements
	

}

function getSysDate()
{
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlHttp.open("POST", "../../eAE/jsp/AMBValidate.jsp?function_type=getSysDate", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	return responseText;
}

function clearLocn(locnObj)
{
	if (locnObj.id=='pickUpLocn')
	{
		document.getElementById('locnInputCode').value=''
		document.getElementById('locnInput').value='';
		document.getElementById('mapLocnRegn').value='';
	}
	else
	if (locnObj.id=='dropLocn')
	{
		document.getElementById('toLocnInputCode').value='';
		document.getElementById('toLocnInput').value='';
	}
	
}

function setPicupTime(immChk,pickUpDt)
{
	if (immChk.checked)
	{
		  d = new Date();
		 
		  var s= padZero(d.getDate()) + "/";
		  s += padZero(d.getMonth()+1)+"/";
		  s += d.getYear()+" ";
		  s += padZero(d.getHours())+":";
		  s += padZero(d.getMinutes());
		  document.getElementById(pickUpDt).value=s;
	}
	else
	{
		 document.getElementById(pickUpDt).value='';
		 document.getElementById(pickUpDt).focus();
	}
}

function padZero(value)
{
	if (value<10)
		return '0'+value;
	else
		return value;
}	

function recordDtl()
{
	
	if(trimString(document.getElementById('amb_prefix_ind').value)=='A' && trimString(document.getElementById('ambInput').value)==""){
		Alert(getMessage("AE_AMB_BLANK_AMBULANCE","AE"),'001');
		return;
	}

	if(!validAge()){
	    Alert(getMessage("AE_AMB_VALID_AGE","AE"),'001');
		return;
	}
	
	var valid = ValidateMandFields('Layer4'); // false

	
	if (valid)
	{
		var mode = document.getElementById('mode').value; 
		if (mode=='insert')
		{
			document.frmAmbMangmntSystem.doAction.value="InsertRequest";
		} 
		else if (mode=='update') 
		{
			document.frmAmbMangmntSystem.doAction.value="ModifyRequest";
		}

	

		document.getElementById("ambStartedYn").disabled=false;
		YAHOO.yui.container.alert('msg','id',"Process");
		YAHOO.example.container.submitForm();
		
//document.frmAmbMangmntSystem.submit();
		//document.body.disabled="true";
		

	}
}

function chopText(elem,limit)
	{
		if(elem.value.length>limit){
		elem.value=elem.value.substring(0,limit);
		if(limit==2000)
		alert(getMessage("AE_AMB_NOT_MORE_THAN_TWO_THOUSAND","AE"));
		else
		alert(getMessage("AE_AMB_NOT_MORE_THAN_FIVE_HUND","AE"));
		
		}
	}

/* Check for mandatory fields in the given division */
function ValidateMandFields(divID)
{
	// Mandatory fields class. List all tags with mandatory class
    var mandEle = [
					  getElementsByClassName('text-box-mand',divID),
					  getElementsByClassName('text-box-nkb-mand',divID),
					  getElementsByClassName('text-area-mand',divID),
				  ];
	var i=0;
	var alertStr = "";
	for (var x = 0, elem; elem = mandEle[x++];)
      for (var y = 0, ex; ex = elem[y++];)
		{
			if (document.getElementById(ex.id))
			{
				if	(document.getElementById((ex.id)).value=='')
				{
					alertStr+= "APP-000001 "+getLegend(ex.name)+"cannot be blank.<br>";
				}
			}
		}
	

	if (alertStr!="")
	{
	    Alert(alertStr,'001');
		return false;
	}
	else
		return true;
}

function getLegend(name)
{
	var arr = name.split("_");
	var str = "";
	var i=0;
	while (arr[i] )
	{
		str = str+arr[i]+' ';
		++i;
	}
return str;
}

function clearDtl()
{
	divObj = document.getElementById("Layer4");

	
	
	/* To clear Input Elements */
	document.getElementById("Pickup_Location")[0].checked=true; // To reset radio buttons
	document.getElementById("Pickup_Location").value="Y";
	document.getElementById("Dropping_Locn")[0].checked=true;   // To reset radio buttons
	document.getElementById("Dropping_Locn").value="Y";
	document.getElementById('ambStrtMilUom').innerHTML = document.getElementById('facAStrtMilUomText').value;
	document.getElementById('ambEndMilUom').innerHTML = document.getElementById('facAStrtMilUomText').value;
	document.getElementById('totDistUom').innerHTML = document.getElementById('facAStrtMilUomText').value;
	document.getElementById('distCovUom').innerHTML = document.getElementById('facAStrtMilUomText').value;
	document.getElementById('ambUom').value = document.getElementById('facAStrtMilUom').value;
	

	var inputElements = divObj.getElementsByTagName("input");
	var inputTxtElements = divObj.getElementsByTagName("textarea");
	var cnt=inputElements.length;
	for (i=0; i<cnt; ++i )
	{
		var id = inputElements(i).id;
		try
		{
			if (document.getElementById(id)){
				if(inputElements(i).id!='facAStrtMilUom')
				document.getElementById(inputElements(i).id).value='';
			}
		}
		catch(e)
		{
		}
	}
	/* To clear Text Area */
	cnt=inputTxtElements.length;
	for (i=0; i<cnt; ++i )
	{
		var id = inputTxtElements(i).id;
		try
		{
			if (document.getElementById(id))
			{
				if (document.getElementById(id).id=='pickUpLocn')
					document.getElementById("Pickup_Location")[0].checked=true;

				document.getElementById(id).value='';
			}
		}
		catch(e)
		{
			
		}
	} 

	/* To clear Default resource Details */
	var rowCnt = document.getElementById("rsrcAllocDiv").rows.length;
	for (i=0; i<rowCnt; ++i )
		document.getElementById("rsrcAllocDiv").deleteRow(0);

	/* To clear resource Details */
	var rowCnt = document.getElementById("rsrcDiv").rows.length;
	for (i=0; i<rowCnt; ++i )
		document.getElementById("rsrcDiv").deleteRow(0);

	/* To clear Ambulance image Details */
	var divObj	=document.getElementById("ambChartR");
	divObj.innerHTML="<br>";
	divObj.style.display='none';
	
	/*Clear the selected Ambulance as well as enable ambulance selection*/
	setSelctedAmbId("");
	document.getElementById('ambInput').className='text-box'; // Clear Mandatory class if assigned

	document.getElementById('ambStartedYn').checked = false; //Trip assigned
	document.getElementById('ambStartedYn').disabled = false;
	document.getElementById('ambInput').readOnly = false;

	document.getElementById('bottomRightTab').height = '50%';
	document.getElementById('tripStatusRow').style.display='none';
	document.getElementById('dropTime').style.display='none';
	document.getElementById('distCoveredRow').style.display='none';
	document.getElementById('emRow').style.display='none';
	document.getElementById('ambResEq').style.display='none';
	document.getElementById('ambStartMeter').style.display='none';
	document.getElementById('ambExpDist').style.display='none';
	document.getElementById('actualPickupRow').style.display='none';
	document.getElementById('actualPickupRowText').style.display='none';
	
	document.getElementById('trPickUpTime').style.display='inline';
	document.getElementById('trPickUpTimeText').style.display='none';
	document.getElementById('tripStatusText').style.display='none';
	document.getElementById('btnRec').disabled=false;


	document.getElementById('mode').value='insert'; 
}

function validateDate(dateObj, grThanSys)
{

 if (dateObj.value!='')
 {
	var arr = dateObj.value.split(" ");
	var err=0;
	if (arr.length==2)
	{
		var datearr = arr[0];
		var timearr = arr[1];
		if(!checkDt(datearr)) err=1; 
		if(!chkTime(timearr)) err=1; 
	}
	else
		err=1;
	if (err==1)
	{	
		
		Alert('APP-000037 Invalid '+getLegend(dateObj.name)+'.<br><br><b>Valid Format is "DD/MM/YYYY HH:MM"</b>',dateObj.id);
		dateObj.value='';
		dateObj.focus();
		return false
	}
	else
	{
		//var curDateTime = getSysDate();
		var 
	d = new Date();

	var s= padZero(d.getDate()) + "/";
	s += padZero(d.getMonth()+1)+"/";
	s += d.getYear()+" ";
	s += padZero(d.getHours())+":";
	s += padZero(d.getMinutes());

	curDateTime=s;

		var selDateTime = dateObj.value;

		
	
		if (dateObj.id='pickupTime')
		{
			if (!ValidateDtTime (selDateTime,curDateTime))
			{
				err=0;
			}
			else
				err=1;
		}
		else
		if (dateObj.id='actualPickupTime')
		{
			if (!ValidateDtTime (selDateTime,curDateTime))
			{
				err=0;
			}
			else
				err=1;
		}
		else
		if (dateObj.id='actualDropTime')
		{
			if (!ValidateDtTime (selDateTime,curDateTime))
			{
				err=0;
			}
			else
				err=1;
		}
		
		/* Added for hide current date validation Start*/	
		if (dateObj.name=='Pickup_Time')
		{
			err=0;
		}
		/* Added for hide current date validation End*/
		
		if (err==0)
			return true;
		else
		{
			Alert('APP-000041 '+getLegend(dateObj.name)+' should be Greater than current Date.',dateObj.id);
			dateObj.value='';
			dateObj.focus();
			return false
		}
	}
 }
}

function ValidateDtTime (from,to)
{
	var a=  from.split(" ")
	splitdate=a[0];
	splittime=a[1]

	var splitdate1 =splitdate.split("/")
	var splittime1= splittime.split(":")

	var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

	a=  to.split(" ")
	splitdate=a[0];
	splittime=a[1]

	splitdate1 =splitdate.split("/")
	splittime1= splittime.split(":")

	var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

	if(Date.parse(to_date) <= Date.parse(from_date))
	{
		return false
	}
	else
		return true;
}


function Alert(msg,id)
{
	YAHOO.yui.container.alert(msg,id,"Error");
}
/* On dbl cliking the request details the case number is passed to the below method*/
function callOnClickRequested(tripSheetNo)
{
	//Update mode of transaction
	clearDtl();
	document.getElementById('mode').value='update'; 

	var	caseNo = tripSheetNo;
	var xmlHttp = new XMLHttpRequest();
	var xmlDoc="";
	xmlHttp.open("POST", "../../eAE/jsp/AMBValidate.jsp?function_type=caseRequest&amb_case_no="+caseNo, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	var data = responseText.split("~");

	
		
	assignValue('ambUom',data[21]);
	assignValue('nocInput',data[40]);
	assignValue('nocInputCode',data[16]);
	assignValue('priorityInput',data[17]);
	assignValue('locnInput',data[35]);
	assignValue('locnInputCode',data[34]);
	assignValue('pickupTime',data[5]);
	document.getElementById("tdPickUpTime").innerText=checkNull(data[5]);
	assignValue('toLocnInput',data[26]);
	assignValue('toLocnInputCode',data[25]);
	assignValue('patName',data[31]);
	assignValue('sexInput',data[36]);
	assignValue('patAge',data[0]); 
	assignValue('escortInput',data[38]);
	assignValue('escortcInputCode',data[28]);
	assignValue('attdByInput',data[39]);
	assignValue('attdByInputCode',data[8]);
	assignValue('startMileage',data[19]);
	assignValue('endMileage',data[13]);
	assignValue('totalDist',data[14]);
	assignValue('distCovered',data[12]);
	document.getElementById("tdActPickUpTime").innerText=checkNull(data[9]);
	assignValue('actualPickupTime',data[9]);
	assignValue('actualDropTime',data[6]);
	assignValue('callerName',data[3]);
	assignValue('mapLocnRegn',data[15]);
	assignValue('ambInput',data[41]);
	assignValue('ambInputCode',data[22]);
	assignValue('ambTypeInput',data[47]);
	assignValue('ambTypeInputCode',data[18]);
	assignValue('dropAddress',data[24]);
	assignValue('pickUpAddress',data[32]);

	

	assignValue('requestorphone',checkNull(data[2]));
	assignValue('rqstrRemarks',checkNull(data[4]));
	assignValue('ambTripSheetNo',data[7]);
	assignValue('dispRemarks',data[11]);
	
	//pickUpLocn Radio Button
	if (data[33]=='N')
		document.getElementById("Pickup_Location")[1].checked=true;
	else
		document.getElementById("Pickup_Location")[0].checked=true;
	assignValue('pickUpLocn',data[33]);

	//dropLocn Radio Button
	if (data[27]=='N')
		document.getElementById("Dropping_Locn")[1].checked=true;
	else
		document.getElementById("Dropping_Locn")[0].checked=true;
	assignValue('dropLocn',data[27]);

//	document.getElementById('ageUom').value = data[0]; // * derive from age
	document.getElementById('bottomRightTab').height = '65%' ;

	// Show the fields only in modify mode
	

	//If Trip started
	assignValue('ambStartedYn',data[20]); 
	if ( data[20]=='Y')
	{
		document.getElementById('ambStartedYn').checked = true;
		document.getElementById('ambStartedYn').disabled = true;
		document.getElementById('ambInput').readOnly = true; // If trip is tarted we cannot reassign new vehicle
		document.getElementById('tripStatusAutoComplete1').style.display='inline';
		document.getElementById('tripStatusAutoComplete2').style.display='none';

	document.getElementById('tripStatusRow').style.display='none';
	document.getElementById('dropTime').style.display='inline';
	document.getElementById('distCoveredRow').style.display='inline';
	document.getElementById('ambStartMeter').style.display='inline';
	document.getElementById('ambExpDist').style.display='inline';
	document.getElementById('actualPickupRowText').style.display='inline';
	document.getElementById('ambResEq').style.display='inline';
	document.getElementById('emRow').style.display='inline';

	document.getElementById('trPickUpTime').style.display='none';
	document.getElementById('trPickUpTimeText').style.display='inline';
	setSelctedAmbId(data[22]);
	
	}
	else
	{
		document.getElementById('ambStartedYn').checked = false;
		document.getElementById('tripStatusAutoComplete1').style.display='none';
		document.getElementById('tripStatusAutoComplete2').style.display='inline';

	if(data[10]=='X'){
		document.getElementById('trPickUpTime').style.display='none';
		document.getElementById('trPickUpTimeText').style.display='inline';
		document.getElementById('tripStatusText').style.display='inline';
		document.getElementById('tdCancelled').innerText='Cancelld '+checkNull(data[49])+' '+checkNull(data[50]);
	}else{
	document.getElementById('tripStatusRow').style.display='inline';
	}
	/*document.getElementById('dropTime').style.display='none';
	document.getElementById('distCoveredRow').style.display='none';
	document.getElementById('ambStartMeter').style.display='none';
	document.getElementById('ambExpDist').style.display='none';
	document.getElementById('actualPickupRow').style.display='none';
	document.getElementById('ambResEq').style.display='none';*/

	}

	if(data[46]=='A') document.getElementById('ambStartedYn').disabled=true;

	
	/* If amb_vehicle_id is not blank */
	if ( (data[22]!=null) && (data[22]!='null') && (data[22]!='undefined') )
				getResourcesAllocated("update",data[22],data[7]); // Attach allocated resources

	
	
	if(data[46]!=null && (data[46]!='null') && (data[46]!='undefined'))
		loadAmbReqDiv(trimString(data[46]),trimString(data[42]),trimString(data[45]),trimString(data[22]),trimString(data[43]),trimString(data[44]),trimString(data[31])+"/"+trimString(checkNull(data[36]))+"/"+trimString(data[0]),"",trimString(data[48]));

	if(data[10]=='X' || data[10]=='C' ){
		document.getElementById('btnRec').disabled=true;
		document.getElementById('ambStartedYn').disabled=true;
		
	}

}

function assignStatusDate()
{
	  d = new Date();

	  var s = padZero(d.getDate()) + "/";
	  s += padZero(d.getMonth()+1)+"/";
	  s += d.getYear()+" ";
	  s += padZero(d.getHours())+":";
	  s += padZero(d.getMinutes());
	  document.getElementById('tripStatusTime').value=s;
}

function assignValue(id,value)
{
	if ( (value!=null) && (value!='null') && (value!='undefined') )
	{
		document.getElementById(id).value = value;
	}
}

/* For Rounded Corners*/
function BrowserCheck()
{
if(!document.getElementById || !document.createElement)
    return(false);
var b=navigator.userAgent.toLowerCase();
if(b.indexOf("msie 5")>0 && b.indexOf("opera")==-1)
    return(false);
return(true);
}

function Rounded(selector,bk,color,size){
var i;
var v=getElementsBySelector(selector);
var l=v.length;
for(i=0;i<l;i++){
    AddTop(v[i],bk,color,size);
    AddBottom(v[i],bk,color,size);
    }
}

function RoundedTop(selector,bk,color,size){
var i;
var v=getElementsBySelector(selector);
for(i=0;i<v.length;i++)
    AddTop(v[i],bk,color,size);
}

function RoundedBottom(selector,bk,color,size){
var i;
var v=getElementsBySelector(selector);
for(i=0;i<v.length;i++)
	{
    AddBottom(v[i],bk,color,size);
	}
}

function AddTop(el,bk,color,size){
var i;
var d=document.createElement("b");
var cn="r";
var lim=4;
if(size && size=="small"){ cn="rs"; lim=2}
d.className="rtop";
d.style.backgroundColor=bk;
for(i=1;i<=lim;i++){
    var x=document.createElement("b");
    x.className=cn + i;
    x.style.backgroundColor=color;
    d.appendChild(x);
    }
el.insertBefore(d,el.firstElementChild);
}

function AddBottom(el,bk,color,size){
var i;
var d=document.createElement("b");
var cn="r";
var lim=4;
if(size && size=="small"){ cn="rs"; lim=2}
d.className="rbottom";
d.style.backgroundColor=bk;
for(i=lim;i>0;i--){
    var x=document.createElement("b");
    x.className=cn + i;
    x.style.backgroundColor=color;
    d.appendChild(x);
    }
el.appendChild(d,el.firstElementChild);
}

function getElementsBySelector(selector){
var i;
var s=[];
var selid="";
var selclass="";
var tag=selector;
var objlist=[];
if(selector.indexOf(" ")>0){  //descendant selector like "tag#id tag"
    s=selector.split(" ");
    var fs=s[0].split("#");
    if(fs.length==1) return(objlist);
    return(document.getElementById(fs[1]).getElementsByTagName(s[1]));
    }
if(selector.indexOf("#")>0){ //id selector like "tag#id"
    s=selector.split("#");
    tag=s[0];
    selid=s[1];
    }
if(selid!=""){
    objlist.push(document.getElementById(selid));
    return(objlist);
    }
if(selector.indexOf(".")>0){  //class selector like "tag.class"
    s=selector.split(".");
    tag=s[0];
    selclass=s[1];
    }
var v=document.getElementsByTagName(tag);  // tag selector like "tag"
if(selclass=="")
    return(v);
for(i=0;i<v.length;i++){
    if(v[i].className==selclass){
        objlist.push(v[i]);
        }
    }
return(objlist);
}
/* End For Rounded Corners*/


function toggleDiv(chkObj,divObj,hidObj){
	if(chkObj.checked){
		divObj.style.display="inline"
		hidObj.value="Y";
	}else{
		divObj.style.display="none"
		hidObj.value="N";
	}

}

function ChkDate(Object3) {

	var strDate;
    var strDay;
    var strMonth;
    var strYear;
    var datefield = Object3;
    var strDateArray = new Array();

	var stArray=new Array();
	var strTimeArray=new Array();

    strDate = datefield.value;
  


if(Object3.value.indexOf('.') > 0) return false;
    
	stArray=strDate.split(" ");

		
	if (stArray.length != 2) return false;

    strDateArray = stArray[0].split("/");
	strTimeArray=  stArray[1].split(":");
  
	if(strTimeArray==null || strTimeArray=='undifined') return false;
		
    if (strDateArray.length != 3) {
        return false;
    }
    else {
        strDay = strDateArray[0];
        strMonth = strDateArray[1];
        strYear = strDateArray[2];
    }


    if (strYear.length < 4 || strYear.length > 4) return false;

    if (isNaN(strDay)==true) return false;
    if (isNaN(strMonth)==true) return false;
    if (isNaN(strYear)==true) return false;

    if (strYear < 1800) return false;

        if (strMonth>12 || strMonth<1)  return false;

    if ((strMonth == 1 || strMonth == 3 || strMonth == 5 || strMonth == 7 || strMonth == 8 || strMonth == 10 || strMonth == 12) && (strDay > 31 || strDay < 1)) return false;

    if ((strMonth == 4 || strMonth == 6 || strMonth == 9 || strMonth == 11) && (strDay > 30 || strDay < 1)) return false;

    if (strMonth == 2) {
        if (strDay < 1) return false;

        if (LeapYear(strYear) == true) {
            if (strDay > 29) return false;
        }
        else {
            if (strDay > 28) return false;
        }
    }

	if (strTimeArray.length != 2) {
        return false;
    }else{

		if(isNaN(strTimeArray[0])) return false;
		if(isNaN(strTimeArray[1])) return false;

		if(strTimeArray[0]>23) return false;
		if(strTimeArray[1]>59) return false;
	}
    return true;
}



function RecordChartInfo(type){
	var frmObj=document.frmAmbMangmntSystem;
   
	if(type=='B'){
		if(frmObj.chkUnderRepairB.checked){
		if(!ChkDate(eval(frmObj.txtprdFromB)) || frmObj.txtprdFromB.value==""){
			Alert(getMessage("AE_AMB_DATE","AE"),'001');
			frmObj.txtprdFromB.focus();
			return;
		}else if(isNaN(frmObj.txtPeriodB.value)|| frmObj.txtPeriodB.value==""){
		    Alert(getMessage("AE_AMB_VALID_PERIOD","AE"),'001');
			frmObj.txtPeriodB.focus();
			return;
		}else if(frmObj.txtPeriodType.value==""){
			Alert(getMessage("AE_AMB_PRDTYPEBLANK","AE"),'001');
			frmObj.txtPeriodType.focus();
			return;
		}
		}
		frmObj.doAction.value="RecordB";
	}else if(type=="M"){
		frmObj.doAction.value="RecordM";
	}else if(type=="A"){
		if(!frmObj.txtDistCovrdA.value==""){
			if(!ChkDate(eval(frmObj.txtEndTimeA)) || frmObj.txtEndTimeA.value==""){
				Alert(getMessage("AE_AMB_DATE","AE"),'001');
				frmObj.txtEndTimeA.focus();
				return;
			}else if(isNaN(frmObj.txtDistCovrdA.value)){
				Alert(getMessage("AE_AMB_NUMBER","AE"),'001');
				frmObj.txtDistCovrdA.focus();
				return;
			}
		}

		frmObj.doAction.value="RecordA";
	}
	YAHOO.yui.container.alert('msg','id',"Process");
	YAHOO.example.container.submitForm();
	//document.frmAmbMangmntSystem.submit();
	//document.body.disabled="true";
}

function setValueForCheckbox(chkObj,hidObj){
	hidObj.value=chkObj.checked?"Y":"N";
}

function loadMaintDet(ambid,type){
	var xmlStr ="<root><SEARCH ";
		xmlStr += " ambId=\""+ ambid + "\" ";
		xmlStr += " type=\""+ type + "\" ";
		xmlStr +=" /></root>";

	if(type=="A") action="LOADLOCNDET"; else action="LOADMAINTDET";

	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","AmbulanceManagementSystemValidate.jsp?action="+action,false);
    xmlHttp.send(xmlDoc);
    responseText=xmlHttp.responseText ;
	eval(responseText);
}

function populateMaintDet(list,type){
	var fromObj=document.frmAmbMangmntSystem;
	if(type=="B"){
		fromObj.txtCurrLocB.value=list[0];
	}else if(type=="M"){
		fromObj.txtCurrLocM.value=list[0];
		fromObj.txtprdFromM.value=list[1];
		fromObj.txtPeriodM.value=list[2];
		fromObj.txtRemarksM.value=list[3];
		fromObj.txtPeriodTypeM.value=list[4];
	}else if(type=="A"){
		fromObj.txtCurrLocA.value=list[0];
		fromObj.txtRemarksA.value=list[1];
		//fromObj.txtDistCovrdA.value=list[2];
		document.getElementById("distncUOM").innerText=list[2];
		fromObj.txtStartMeterA.value=list[3];
		fromObj.txtStartTimeA.value=list[4];
	}
}

/**
function openWindow(anchor, options) {
 
	var args = '';
 
	if (typeof(options) == 'undefined') { var options = new Object(); }
	if (typeof(options.name) == 'undefined') { options.name = 'win' + Math.round(Math.random()*100000); }
 
	if (typeof(options.height) != 'undefined' && typeof(options.fullscreen) == 'undefined') {
		args += "height=" + options.height + ",";
	}
 
	if (typeof(options.width) != 'undefined' && typeof(options.fullscreen) == 'undefined') {
		args += "width=" + options.width + ",";
	}
 
	if (typeof(options.fullscreen) != 'undefined') {
		args += "width=" + screen.availWidth + ",";
		args += "height=" + screen.availHeight + ",";
	}
 
	if (typeof(options.center) == 'undefined') {
		options.x = 0;
		options.y = 0;
		args += "screenx=" + options.x + ",";
		args += "screeny=" + options.y + ",";
		args += "left=" + options.x + ",";
		args += "top=" + options.y + ",";
	}
 
	if (typeof(options.center) != 'undefined' && typeof(options.fullscreen) == 'undefined') {
		options.y=Math.floor((screen.availHeight-(options.height || screen.height))/2)-(screen.height-screen.availHeight);
		options.x=Math.floor((screen.availWidth-(options.width || screen.width))/2)-(screen.width-screen.availWidth);
		args += "screenx=" + options.x + ",";
		args += "screeny=" + options.y + ",";
		args += "left=" + options.x + ",";
		args += "top=" + options.y + ",";
	}
 
	if (typeof(options.scrollbars) != 'undefined') { args += "scrollbars=1,"; }
	if (typeof(options.menubar) != 'undefined') { args += "menubar=1,"; }
	if (typeof(options.locationbar) != 'undefined') { args += "location=1,"; }
	if (typeof(options.resizable) != 'undefined') { args += "resizable=1,"; }
 
	var win = window.open(anchor, options.name, args);
	return false;
 
}
*/

function checkNull(val){
	return ( (val==null) || (val=='null') || (val=='undefined') )?"":val;
}

function loadDestn(){
	if(!document.frmAmbMangmntSystem.chkReachDropLocnA.checked) return;
	var caseno=document.frmAmbMangmntSystem.selCaseno.value;
	var action="LOADDESTN";

	var xmlStr ="<root><SEARCH ";
		xmlStr += " caseno=\""+ caseno + "\" ";
		xmlStr +=" /></root>";

	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","AmbulanceManagementSystemValidate.jsp?action="+action,false);
    xmlHttp.send(xmlDoc);
    responseText=trimString(xmlHttp.responseText) ;
	document.frmAmbMangmntSystem.txtCurrLocA.value=responseText;
	//eval(responseText);
}
	

function calcEndMeter(dist,stratmeter,endmeter,endtime){

	var distVal=dist.value;
	var stratMeterVal=stratmeter.value;

	var fromObj=document.frmAmbMangmntSystem;

	if(isNaN(distVal)){
		Alert(getMessage("AE_AMB_NUMBER","AE"),'001');
		//dist.focus();
		return;
	}

	if(!distVal==""){

	d = new Date();

	var s= padZero(d.getDate()) + "/";
	s += padZero(d.getMonth()+1)+"/";
	s += d.getYear()+" ";
	s += padZero(d.getHours())+":";
	s += padZero(d.getMinutes());
		
	endmeter.value=Number(stratMeterVal)+Number(distVal);
	endtime.value=s;
	document.getElementById('tripStatusCode').value='C';
	}

	
}

function calcDistCoverd(dist,stratmeter,endmeter,endtime){

	var endmeterVal=endmeter.value;
	var stratMeterVal=stratmeter.value;

	var fromObj=document.frmAmbMangmntSystem;

	
	if(!endmeterVal==""){

		if(isNaN(endmeterVal)){
		Alert(getMessage("AE_AMB_NUMBER","AE"),'001');
		//dist.focus();
		return;
	}


	d = new Date();

	var s= padZero(d.getDate()) + "/";
	s += padZero(d.getMonth()+1)+"/";
	s += d.getYear()+" ";
	s += padZero(d.getHours())+":";
	s += padZero(d.getMinutes());
	
	if(Number(endmeterVal)-Number(stratMeterVal)<=0){
		Alert(getMessage("AE_AMB_ENDMETER","AE"),'001');
		endmeter.value="";
		//dist.focus();
		return;
	}
	dist.value=Number(endmeterVal)-Number(stratMeterVal);
	endtime.value=s;
	document.getElementById('tripStatusCode').value='C';
}
}

function drawVehicle(){
	
	var vehicleid=document.frmAmbMangmntSystem.amb_vehicle_id.value;
	var action="VEHICLEDET";
	
	var xmlStr ="<root><SEARCH ";
		xmlStr += " vehicleid=\""+ vehicleid + "\" ";
		xmlStr +=" /></root>";

	var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","AmbulanceManagementSystemValidate.jsp?action="+action,false);
    xmlHttp.send(xmlDoc);
    responseText=trimString(xmlHttp.responseText) ;
	eval(responseText);
	
}

function populateVehicleDet(list){
	
	var status		=	list[3];
	var	ambtype		=	list[6];
	var regno		=	list[1];
	var	id			=	list[0];
	var name		=	list[4];
	var	phone		=	list[5];
	var loc			=	list[2];
	var pat_det		=   list[7];
    if(status=='A'){
		document.getElementById('ambStartedYn').value='N'
		document.getElementById('ambStartedYn').checked=false;
		document.getElementById('ambStartedYn').disabled=true;

	}else{
		document.getElementById('ambStartedYn').disabled=false;
	}

	
	loadAmbReqDiv(status,ambtype,regno,id,name,phone,pat_det,'&nbsp;',loc);

}


function validAge(){
	var str		=	"0,1,2,3,4,5,6,7,8,9,Y,M,D";
	var age		=	reOrderAge(document.getElementById('patAge').value.toUpperCase(),str);
   
	
			
	if(age=="") return true;
	if(!checkAgeChars(age,str)) return false;
		
	if(isNaN(age)){
		if(age.indexOf("Y")!=-1){
			yr = age.substring(0,age.indexOf('Y'));
			if(isNaN(yr)) return false;
			if(Number(yr)>999) return false;
		}
		if(age.indexOf("M")!=-1){
			mn = age.substring(age.indexOf('Y')+1,age.indexOf('M'));
			if(isNaN(mn)) return false;
			if(Number(mn)>99) return false;
		}
		if(age.indexOf("D")!=-1){
			dt = age.substring(age.indexOf('M')+1,age.indexOf('D'));
			if(isNaN(dt)) return false;
			if(Number(dt)>99) return false;
		}
	}else{
		if(Number(age)>999 || Number(age)==0) return false;
		
	}
	document.getElementById('patAge').value=age;
	return true;
}


function checkAgeChars(strcheck,strin){
	var yflag=0;
	var mflag=0;
	var dflag=0;

	for(i=0;i<strcheck.length;i++){
		if(strin.indexOf(strcheck.charAt(i))==-1) {
			return false;
		}else{
			switch(strcheck.charAt(i)){
				case 'Y':
					yflag+=1;
					break;
				case 'M':
					mflag+=1;
					break;
				case 'D':
					dflag+=1;
					break;
			}
		}

		if(yflag >1 || mflag >1 || dflag > 1) return false;
	}
	return true;
}

function reOrderAge(age,str){
	if(!isNaN(age)) return age;
	if(!checkAgeChars(age,str)) return age;
	var yr='0Y',mn='0M',dt='0D',ageVal='';
	for(i=0;i<age.length;i++){
		ageVal+=age.charAt(i);
        switch(age.charAt(i)){
				case 'Y':
					yr=ageVal;
					ageVal='';
					break;
				case 'M':
					mn=ageVal;
					ageVal='';
					break;
				case 'D':
					dt=ageVal;
					ageVal='';
					break;
		}

	}
	return yr+mn+dt;
}

function tabOnEnterKey(){
	if(event.target.tagName!='TEXTAREA') {
		if(event.keyCode==13){
			event.keyCode=9; return event.keyCode
		}
	}
}

function CodeArrest() {
try{
	var el=window.event.target.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement;
	var e2=window.event.target.parentElement.parentElement.parentElement.parentElement.parentElement;

	if(el.id!='ambRequst' && el.id!='ambRequstAll' && e2.id!='ambRequst' && e2.id!='ambRequstAll'){

    if((window.event.button == 2) || (window.event.button == 3) || (window.event.button == 4)) {
        alert("Welcome to eHIS");
    }
	}
}catch(e){}
}


/*function lockKey(){
try{
	var el=event.target.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement;
	if(el.id!='ambRequst' && el.id!='ambRequstAll'){
	whichCode = event.keyCode;
    if(whichCode== 93)
        alert("Welcome to eHIS");
	}
}catch(e){}
}*/


function loadPage(pgn){
		frmObj=document.frmAmbMangmntSystem
        var currpage=Number(frmObj.currPage.value);
		var totPage=Number(frmObj.totPage.value);
		
		if(pgn=='chartNext'){
			var nextPage=Number(frmObj.currPage.value)+1;
			eval("divPage"+currpage).style.display='none';
			eval("divPage"+nextPage).style.display='inline';

			if(currpage+1==totPage) document.getElementById('imgNext').style.display='none'
			document.getElementById('imgPrev').style.display='inline'
			frmObj.currPage.value=nextPage;
		}else if(pgn=='chartPrev'){
			prevPage=Number(frmObj.currPage.value)-1;
			eval("divPage"+currpage).style.display='none';
			eval("divPage"+prevPage).style.display='inline';

			if(currpage-1==1) document.getElementById('imgPrev').style.display='none'
			document.getElementById('imgNext').style.display='inline'
           frmObj.currPage.value=prevPage;
		}
	}

function find(){
	var formObj=document.frmAmbMangmntSystem;
	from_date	=	formObj.from_date.value;
	to_date		=	formObj.to_date.value;
	document.location.href="../../eAE/jsp/AmbulanceManagementSystem.jsp?from_date="+from_date+"&to_date="+to_date+"&findText="+formObj.findText.value;
}

function CheckSpecChars(event)
{
    var strCheck =
        '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_.*';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode); // Get key value from key code
    if (strCheck.indexOf(key) ==  - 1)
        return false;
    // Not a valid key
    if ((event.keyCode >= 97) && (event.keyCode <= 122))
        return (event.keyCode);
    return true;
}
/*Added By Dharma on July 31, 2014 Start*/
function FnPosition(){
	document.body.scrollTop = document.documentElement.scrollTop = 0;
	document.body.scrollLeft = document.documentElement.scrollLeft = 0;
}
/*Added By Dharma on July 31, 2014 End*/

