/*
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
10/12/12      100         Bmohankumar  created
Acts as master script file for Billing Mainatain Previlage card
--------------------------------------------------------------------------------------------------------
Sr No        Version           TFS/Incident        SCF/CRF            		 		 Developer Name
--------------------------------------------------------------------------------------------------------
1		   	    V220323	    		27763			MMS-ME-SCF-0052 			    Mohana Priya K
-----------------------------------------------------------------------------------------------
*/

function addNewRow(tableId,patient_id)
{
	table = document.getElementById(tableId);
	var objDiv = document.getElementById("patient_subscribe_modify_div");
	var rowCount =  table.rows.length;  
	for(var k=0;k<rowCount;k++)
	{
		if(document.getElementById(patient_id+k).value == "")
		{
			alert(getMessage("BL6103","BL"));
			objDiv.scrollTop = objDiv.scrollHeight;
			window.scrollTo(0, objDiv.scrollHeight); 
			return;
		}
	}
	var i=rowCount;
	var index;
	index = i;//-1;
	var row =  table.insertRow(i);
	var cell1=row.insertCell(0);
	var cell2=row.insertCell(1);
	var cell3=row.insertCell(2);
	var cell4=row.insertCell(3);
	var cell5=row.insertCell(4);
	//var cell6=row.insertCell(5);
	cell1.innerHTML="<input type ='text' 	 	name='patient_id"+index+"'  	id='patient_id"+index+"'	 	maxlength=12 	size=17 	onKeyPress='return lockbackSpace();' onBlur='return additionalPatValidation(this,"+index+"); ' /><input type='button' class='button' name='patientidbut"+index+"' id='patientidbut"+index+"' value='?' onClick='return PatientIdLookup("+index+",\"secondary\");'  tabindex='2'>";
	cell2.innerHTML="<input type ='text' 		name='patient_name"+index+"'   	id='patient_name"+index+"' 		maxlength=12 	size=25 	onBlur='ChangeUpperCase( this );'onKeyPress='return CheckForSpecChar1(event);lockbackSpace();'     		/>";
	cell3.innerHTML="<input type ='text' 		name='patient_age"+index+"'   	id='patient_age"+index+"' 		maxlength=12 	size=15     onKeyPress='return CheckForSpecChar1(event);lockbackSpace();'  											/>";
	var cell="<select style='width:200px;'	 name='price_class_Code"+index+"' id='price_class_Code"+index+"' >";
	var cardTypeCode 	= document.getElementById("hiddenCardTypeCode").value;
	var out;
	
	var xmlhttp;    
	/*if (str=="")
	  {
	  document.getElementById("txtHint").innerHTML="";
	  return;
	  }*/
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  //xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  xmlhttp="";
	  }
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
		  out = trimStringValue(xmlhttp.responseText);
		  var showdata = out.substring(out.indexOf("!")+1,out.length);
		  var response=showdata.split(":");
		  var key;
		  var value;
		  var actual;
		  var response1;
		  for(var i=0;i<response.length;i++)
		  {
			  response1=response[i].split("~");
			  for(var j=0;j<response1.length-1;j++)
				  {
				   		actual=response1[j].split("-");
				   		key=actual[0];
				   		key = key.replace(/^\s+|\s+$/g,'');
				   		value=actual[1];
				   		cell=cell+"<option title='"+response1[j]+"' value='"+key+"'>"+response1[j]+"</option>";
				  }
			 
			
		  }
		  cell = cell+"</select>"
		  
		  cell4.innerHTML=cell;
		 
		  		  
	    }
	  }
	xmlhttp.open("POST","../../eBL/jsp/LoadPriceClassCodeAndDesc.jsp?cardTypeCode="+cardTypeCode,true);
	xmlhttp.send(null);
	
	cell5.innerHTML="<input type='hidden'  	    name='type"+index+"'  			id='type"+index+"'	 			value=\"insert\"		 />";
	objDiv.scrollTop = objDiv.scrollHeight;
	window.scrollTo(0, objDiv.scrollHeight); 
}

function ShowCardsubsciptionDetails(hiddenPatientId,index)
{
	var e = document.getElementById("price_class_Code"+index);
	var hCardSeqnNo 	= document.getElementById("hcardseqno"+index).value;
	var selectedValue;
	for(var j=0; j<e.options.length; j++)
    {
		if(e.options[j].selected)
			selectedValue=e.options[j].value;
    }
	var priceClassCode 		= selectedValue;
	var priceClassDesc 		= selectedValue;
	var cardTypeCode 		= document.getElementById("card_type_code"+index).value;
	var cardTypeDesc 		= document.getElementById("card_type"+index).value;
	var fromDate			= document.getElementById("from_date"+index).value;
	var packageCode			= document.getElementById("packageCode"+index).value;
	var toDate				= document.getElementById("to_date"+index).value;
	var mebnmberFees		= document.getElementById("memeber_fees"+index).value;
	var billingServiceCode	= document.getElementById("billingServiceCode"+index).value;
	var primaryPatientId	= document.getElementById("primary_patientId"+index).value;
	parent.BillingPrevilageCardPatientDetailsFrame.location.href = "../../eBL/jsp/BillingMaintainPrevilageCardPatientDetails.jsp?hiddenPatientId="+hiddenPatientId+"&hCardSeqnNo="
		+ hCardSeqnNo+"&priceClassCode="+priceClassCode+"&priceClassDesc="+priceClassDesc+"&cardTypeCode="+cardTypeCode+"&fromDate="+fromDate+"&cardTypeDesc="+cardTypeDesc+"&packageCode="+packageCode+"&toDate="+toDate+"&mebnmberFees="+mebnmberFees+"&billingServiceCode="+billingServiceCode+"&primaryPatientId="+primaryPatientId;
}

async function PatientIdLookup(index,type)
{	
	var pat_id=await PatientSearch();		
	var cardTypeCode 	= document.getElementById("hiddenCardTypeCode").value;
	//var response;
	if( pat_id != null )						
	document.getElementById('patient_id'+index).value = pat_id ;

	/*	document.getElementById("showPatientdetails").style.visibility="visible" ;		
	document.getElementById("hiddenPatientId").value = pat_id ;		
	*/	
	if(type=="primary")
	{
		document.getElementById("hiddenPatientId").value = pat_id ;
		ShowPatientdetails(pat_id,"insert");
	}

	if(type=="secondary")
	{
		/*document.getElementById("price_class_Code"+index).value= document.getElementById("hiddenPriceClasscode").value ;
		document.getElementById("price_class_desc"+index).value= document.getElementById("hiddenPriceClassDesc").value ;*/
		if(pat_id!=undefined && pat_id!='')
		{
			LoadPatientNameAndAgeforPrevilageCard(pat_id,index);
			loadDefaultPriceClassCodeForAdditionalPatient(pat_id,cardTypeCode,index);
		}		
	}	 
} 

function PriceClassCodeLookup(index)
{
	var value  = "";
	sql											=	Billing_Previlage_Price_Class_Lookup_SQL	+" '" +document.forms[0].locale.value+"'";
	var title									= 	getLabel("eBL.PRICE_CLASS.label", 'Bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
	var price_class_Code						=	document.getElementById('price_class_Code'+index); 
	var price_class_desc						=	document.getElementById('price_class_desc'+index); 
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	price_class_Code.value ;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != "")
	{
		price_class_Code.value 				= 	retVal[0];
		price_class_desc.value 				= 	retVal[1];
	}
	else
	{
		price_class_Code.value  				=	"";
		price_class_desc.value  				=	"";		
	}	 
} 

function primaryPatValidation(obj)
{
	var patient_id=obj.value;	
	if(patient_id!=""){
	var function_id = "PAT_CHK";
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "patient_id=\"" + patient_id + "\" " ;					
	xmlStr +=" /></root>";
	var temp_jsp="PkgSubscriptionValidation.jsp?func_mode=CHK_PAT_ID&function_id="+function_id;					
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml"); 
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText);		
	if(responseText=="N")
	{
		alert(getMessage("INVALID_PATIENT","MP"));
		obj.select();
	}else if(responseText=="Y"){
		ShowPrimaryPatientdetails(patient_id,"insert");
	}	
	}
}

function additionalPatValidation(obj,index)
{
	var patient_id=obj.value;	
	var cardTypeCode 	= document.getElementById("hiddenCardTypeCode").value;
	if(patient_id!=""){
	var function_id = "PAT_CHK";
	var xmlStr ="<root><SEARCH ";
	xmlStr+= "patient_id=\"" + patient_id + "\" " ;					
	xmlStr +=" /></root>";
	var temp_jsp="PkgSubscriptionValidation.jsp?func_mode=CHK_PAT_ID&function_id="+function_id;					
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml"); 
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=trimString(xmlHttp.responseText);		
	if(responseText=="N")
	{
		alert(getMessage("INVALID_PATIENT","MP"));
		obj.select();
	}else if(responseText=="Y"){
		//LoadPatientNameAndAgeforPrevilageCard(pat_id,index);
		//ShowAdditionalPatientdetails(patient_id,index);
		LoadPatientNameAndAgeforPrevilageCard(patient_id,index);
				loadDefaultPriceClassCodeForAdditionalPatient(patient_id,cardTypeCode,index);
	}	
	}
}

function showAlert(intialSelectedValue,obj)
{
	var selectedValue;
	for(var j=0; j<obj.options.length; j++)
    {
		if(obj.options[j].selected)
			selectedValue=obj.options[j].value;
    }
	if(intialSelectedValue!=selectedValue)
	{
		alert(getMessage("BL9131","BL"));
	}	
}

function ShowAdditionalPatientdetails(pat_id,index)
{
	document.getElementById("price_class_Code"+index).value= document.getElementById("hiddenPriceClasscode").value ;
	document.getElementById("price_class_desc"+index).value= document.getElementById("hiddenPriceClassDesc").value ;
	LoadPatientNameAndAgeforPrevilageCard(pat_id,index);
}

function ShowPrimaryPatientdetails(patientId,mode)
{
	if(patientId!=null && patientId!="")
		{
		document.getElementById("hiddenPatientId").value = patientId ;
			parent.BillingPrevilageCardDetailsFrame.location.href="../../eBL/jsp/BillingMaintainPrevilageCardDetails.jsp?patientId="+patientId;
		}
}

function ShowPatientdetails(patientId,mode)
{
	if(patientId!=null && patientId!="")
		{
			parent.BillingPrevilageCardDetailsFrame.location.href="../../eBL/jsp/BillingMaintainPrevilageCardDetails.jsp?patientId="+patientId;
		}
}

function LoadPatientNameAndAgeforPrevilageCard(pat_id,index)
{
	var out;
	var response;
	var xmlhttp;    
	if (window.XMLHttpRequest) 
	{// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}
	else
	{// code for IE6, IE5
		//xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		xmlhttp=new XMLHttpRequest();
	}
		xmlhttp.onreadystatechange=function()
	{
	if (xmlhttp.readyState==4 && xmlhttp.status==200)
	{
		out = xmlhttp.responseText;
		var showdata = out.substring(out.indexOf("!")+1,out.length);
		response=showdata.split(":");
		var actual;
		for(var i=0;i<response.length;i++)
		{
			actual=response[i].split("~");
			document.getElementById("patient_name"+index).value = actual[0];
			document.getElementById("patient_age"+index).value  = actual[1] ;		
		}		  
	}
	}
	xmlhttp.open("POST","../../eBL/jsp/LoadPatientNameAndAgeforPrevilageCard.jsp?patientId="+pat_id,true);
	xmlhttp.send(null);	
}

function loadDefaultPriceClassCodeForAdditionalPatient(patientId,cardTypeCode,index)
{	
	var out;
	var response;
	var xmlhttp;    
	if (window.XMLHttpRequest) 
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  //xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  	  xmlhttp="";

	  }
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
		  out = trimStringValue(xmlhttp.responseText);
		  var showdata = out.substring(out.indexOf("!")+1,out.length);
		  response=showdata.split(":");
		  var e = document.getElementById("price_class_Code"+index);
		  var selectedValue;
		  for(var j=0; j<e.options.length; j++)
		   {
				if(e.options[j].value==response[0])
				{
					e.options[j].selected=true;
				}   
				/*if(e.options[j].selected)
				{
					selectedValue=e.options[j].value;
					alert(selectedValue);
				}*/				
		   }
		   document.getElementById("price_class_Code"+index).disabled=true;		  		  
	    }
	  }
	xmlhttp.open("POST","../../eBL/jsp/LoadAdditionalPatientDefaultPriceClassCode.jsp?patientId="+patientId+"&cardTypeCode="+cardTypeCode,true);
	xmlhttp.send(null);
}

function checkSelected(obj)
{
	if(obj.checked)
	{
		obj.value = "Y";
	}
	else
	{
		obj.value = "N";
	}
}

function reset()
{
	parent.frames[2].BillingMaintainPrevilageCard.document.location.reload();	
}

//Function to disable all special characters in master codes.
function restrictCharacters(event){
	if( (event.keyCode >= 48) && (event.keyCode <= 57) )
		return true ;
else
		return false;
}

function create() 
{	
	parent.BillingPrevilageCardPatientFrame.location.href="../../eBL/jsp/BillingPatientIdlookup.jsp";	
}
 
function apply()  
{	
	if(parent.frames[2].BillingMaintainPrevilageCard.BillingPrevilageCardPatientDetailsFrame.document.forms[0]!=undefined)
	{	
		var authorized 			=	parent.frames[2].BillingMaintainPrevilageCard.BillingPrevilageCardPatientDetailsFrame.BillingMaintainPrevilageCardPatientDetails.document.forms[0].authorized.value;
		var mode 				=	parent.frames[2].BillingMaintainPrevilageCard.BillingPrevilageCardPatientDetailsFrame.BillingMaintainPrevilageCardPatientDetails.document.forms[0].mode.value;
		var isUserCanAcess 		=	parent.frames[2].BillingMaintainPrevilageCard.BillingPrevilageCardPatientDetailsFrame.BillingMaintainPrevilageCardPatientDetails.document.forms[0].isUserCanAcess.value;
		parent.frames[2].BillingMaintainPrevilageCard.BillingPrevilageCardPatientDetailsFrame.BillingMaintainPrevilageCardPatientDetails.document.getElementById("rowCount").value = parent.frames[2].BillingMaintainPrevilageCard.BillingPrevilageCardPatientDetailsFrame.BillingMaintainPrevilageCardPatientDetails.document.getElementById("patient_subscribe_modify").rows.length;
		if ((authorized=="Y" && mode=="modify") || (isUserCanAcess=="Y"))
		{			
			//var e = parent.frames[2].BillingMaintainPrevilageCard.BillingPrevilageCardDetailsFrame.BillingMaintainPrevilageCardDetails.document.getElementById("price_class_Code"+index);
			//alert(e.name);
			/*var selectedValue;
			for(var j=0; j<e.options.length; j++)
		    {
				if(e.options[j].selected)
					selectedValue=e.options[j].value;
		    }*/			
			
			var rowCount 		= 	parent.frames[2].BillingMaintainPrevilageCard.BillingPrevilageCardPatientDetailsFrame.BillingMaintainPrevilageCardPatientDetails.document.getElementById("rowCount").value;
			
			var err_mess="";
			var result=true;
			for(var k=0;k<rowCount;k++)
			{				
				if(parent.frames[2].BillingMaintainPrevilageCard.BillingPrevilageCardPatientDetailsFrame.BillingMaintainPrevilageCardPatientDetails.document.getElementById('patient_id'+k).value == "")
				{
					err_mess += "PatientId Cannot Be NULL"+"<br>";
				}
			}
			if (err_mess != "")
			{
				parent.frames[2].frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+err_mess;
			}
			else
			{
				if(err_mess=="" && result)
				{
					parent.frames[2].BillingMaintainPrevilageCard.BillingPrevilageCardPatientDetailsFrame.BillingMaintainPrevilageCardPatientDetails.document.forms[0].target='messageFrame';
					parent.frames[2].BillingMaintainPrevilageCard.BillingPrevilageCardPatientDetailsFrame.BillingMaintainPrevilageCardPatientDetails.document.forms[0].method="post";
					parent.frames[2].BillingMaintainPrevilageCard.BillingPrevilageCardPatientDetailsFrame.BillingMaintainPrevilageCardPatientDetails.document.forms[0].action="../../servlet/eBL.MaintainPrevilageCardServlet";
					parent.frames[2].BillingMaintainPrevilageCard.BillingPrevilageCardPatientDetailsFrame.BillingMaintainPrevilageCardPatientDetails.document.forms[0].submit();
				}
			}		
		}
	}
}

function onSuccess()
{
	parent.frames[2].BillingMaintainPrevilageCard.document.location.reload(); 
	//parent.frames[3].document.location.reload();	
}

function call_pass_valid()
{
	var user = document.forms[0].user.value;
	var err_msg = document.forms[0].err_msg.value; //V220323-MMS-ME-SCF-0052

	var remarks = document.forms[0].remarks.value;
	if(err_msg!=""){
			alert(getMessage(err_msg,'BL'));
			return false;
		}else{
			var returnArray = new Array ("Y","Y",remarks,user);
			parent.window.returnValue=returnArray;
			parent.window.close();
			return true;
		} //V220323
}	

function confirmPasswdchk(obj)
{
	var usr_id=document.forms[0].user_id;
	var pass_wd=document.forms[0].passwd;
	var rmks=document.forms[0].remarks;
	if(usr_id.value=="")
	{
		alert(getMessage("BL9112","BL"));
		usr_id.focus();
		return false;
	}
	if(pass_wd.value=="")  
	{
		alert(getMessage("BL9113","BL"));
		pass_wd.focus();
		return false;
	}
	if(rmks.value=="")
	{
		alert(getMessage("BL9306","BL"));  
		rmks.focus();
		return false;
	}	
	var HTMLVal="<html><body><form name='PrevilageCardPasswrdForm' id='PrevilageCardPasswrdForm' method='post' action='../../eBL/jsp/PrevilageCardPasswrdCheck.jsp'>"+
				"<input type='hidden' name='usr_id' id='usr_id' value='"+usr_id.value+"'>"+
				"<input type='hidden' name='pass_wd' id='pass_wd' value='"+pass_wd.value+"'>"+
				"<input type='hidden' name='remarks' id='remarks' value='"+rmks.value+"'>"+
                "<input type='hidden' name='mod_fin_chk' id='mod_fin_chk' value='Y'>"+
				"</form></body></html>";
	parent.frames[1].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
	parent.frames[1].document.PrevilageCardPasswrdForm.submit();			
}

async function authUser()
{	
	var dialogHeight= "14" ;
	var dialogWidth	= "22" ;
	var dialogTop = "225" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;	
	var modPatientId = document.getElementById("hiddenPatientId").value;
	retVal =await window.showModalDialog("../../eBL/jsp/PrevilageCardAuthorizeMain.jsp?mode=s",arguments,features); 
	if(retVal!=undefined)
	{
		if(retVal.length>0)
		{
			if(retVal[0]=="Y")
			{
				document.forms[0].modify.disabled=true;
				parent.parent.BillingMaintainPrevilageCard.BillingPrevilageCardPatientDetailsFrame.document.forms[0].method="post";
				parent.parent.BillingMaintainPrevilageCard.BillingPrevilageCardPatientDetailsFrame.document.forms[0].action="../../eBL/jsp/BillingPatientIdlookup.jsp?authorized=Y&mode=modify&modPatientId="+modPatientId;
				parent.parent.BillingMaintainPrevilageCard.BillingPrevilageCardPatientDetailsFrame.document.forms[0].submit();
			}
		}
	}
}

function trimStringValue(inString) {
    var outString;
    var startPos;
    var endPos;
    var ch;

    // where do we start?
    startPos = 0;
    ch = inString.charAt(startPos);
    while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
        startPos++;
        ch = inString.charAt(startPos);
    }
    // where do we end?
    endPos = inString.length - 1;
    ch = inString.charAt(endPos);
    while ((ch == " ") || (ch == "\b") || (ch == "\f") || (ch == "\n") || (ch == "\r") || (ch == "\n")) {
        endPos--;
        ch = inString.charAt(endPos);
    }
    // get the string
    outString = inString.substring(startPos, endPos + 1);
	if (startPos>endPos)
	{
		return '';
	}
	else
	    return outString;
}

 async function printPrevilageCardReport(index)
{	
		var cardTypeCode 		= document.getElementById("card_type_code"+index).value;
		var primaryPatientId	= document.getElementById("primary_patientId"+index).value;
		var languageId			= document.forms[0].locale.value;
		var facilityId			= document.forms[0].facilityId.value;	
		var url		= "../../eCommon/jsp/report_options_frameset.jsp?&p_card_type_code="+cardTypeCode+"&p_patient_id="+primaryPatientId+"&p_language_Id="+languageId+"&p_facility_id="+facilityId+"&p_report_id=BLRHLCDPRT&p_module_id=BL";
		var dialogHeight	= "11" ;
		var dialogWidth	= "25" ;
		var arguments	= "" ;
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:no" ;
		var reportURL 	=await window.showModalDialog( url, arguments, features ) ;
		//var reportURL 	= window.open( url, '_blank', features ) ;
		if ( reportURL != null ) {			 
			reportURL		= "../../eCommon/jsp/report_process.jsp?" + reportURL ;
			var myBars 		= 'directories=no,location=no,menubar=no' ;
			var myOptions 	= 'width=' + window.screen.availwidth + ', height=' + window.screen.availheight + ', resizable=yes' ;
			var myFeatures 	= myBars + ', ' + myOptions ;
			var reportWindow 	= open( reportURL, '_blank', myFeatures ) ;
			reportWindow.title= "Medicom Report Viewer" ;
			reportWindow.resizeTo( screen.availWidth, screen.availHeight ) ;
			reportWindow.moveTo( 0,0 ) ;
			reportWindow.focus() ;			
		}
	}

