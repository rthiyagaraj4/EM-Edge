/*
---------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        		Rev.Date		Rev.Name 		Description
---------------------------------------------------------------------------------------------------------------
22/01/2018  	IN062606            Sharanraj         01/02/2018              Ramesh G        ML-MMOH-CRF-0726
12/02/2018    IN066647            Sharanraj         13/02/2018              Ramesh G        CA-ML-MMOH-CRF-0726/05
---------------------------------------------------------------------------------------------------------------
*/

function searchClick1()
{
	var from_date=document.getElementById('from_date').value;
	var to_date=document.getElementById('to_date').value;
	var locale=document.MyRefNotSeenCriteria_form.locale.value;
	var patientid=document.getElementById('patientId').value;
	
	if(from_date=='')
	{
		var msg =getMessage("CAN_NOT_BE_BLANK","common");
		msg = msg.replace("$","From Date");	
		alert(msg);
		from_date.focus();
		return;
	}
	if(to_date=='')
	{
		var msg =getMessage("CAN_NOT_BE_BLANK","common");
		msg = msg.replace("$","To Date");
		alert(msg);
		to_date.focus();
		return;
	}
	
	
	if(!(from_date == null || from_date == "" ) && !(to_date == null || to_date == "" ))
	{
		var date1 = minusDate(to_date,"DMY",locale,8,"d");
		if(isAfter(date1, from_date, "DMY", locale))
		{
			alert(getMessage("CA_DATE_RANGE_ONE_WEEK","CA"));//IN066647
			document.forms[0].to_date.select();
			return false;
		}
		var passurl = '../jsp/MyRefNotSeenDetails.jsp?search=C'+'&from_date='+from_date+'&to_date='+to_date+'&patientid='+patientid;
		top.content.workAreaFrame.MyRefNotSeenDetailsFrame.location.href = passurl ;
	}
}

function clearClick1()
{	
	top.content.workAreaFrame.MyRefNotSeenDetailsFrame.location.href = "../../eCommon/html/blank.html" ;
	top.content.workAreaFrame.MyRefResultFr.location.href="../../eCommon/html/blank.html";
	document.location.reload();	
}

async function showEncounterDeatils1(i,encounterId,facilityid)
{
	
	var patient_id = eval("self.document.MyRefNotSeenDtl_form.patient_id"+i+".value");
	var dialogTop		= "100";
	var dialogHeight	= "20";
	var dialogWidth		= "65";
	var title ="enc det ";
	var features		= "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; dialogTitle:"+title+ "; status=no" ;
	var arguments		= "";
	var retVal =await window.showModalDialog("../../eCA/jsp/CurrentEncounter.jsp?patientId="+patient_id+"&encounterId="+encounterId+"&facilityid="+facilityid,arguments,features);
}


function callForOrderByLoc1(obj)
{
	//alert(">>.");
	var qryStr = top.content.workAreaFrame.MyRefNotSeenCriteriaFrame.MyRefNotSeenCriteria_form.url.value;
	top.content.workAreaFrame.MyRefNotSeenCriteriaFrame.document.forms[0].order_by.value=obj;
	top.content.workAreaFrame.MyRefNotSeenCriteriaFrame.document.forms[0].re_order.value=reOrder;	        top.content.workAreaFrame.MyRefNotSeenCriteriaFrame.document.forms[0].anchor_id.value=anchorID;
	var url=qryStr+'&orderBy='+obj+'&reOrder='+reOrder+'&anchorID=' + anchorID;
	top.content.workAreaFrame.MyRefNotSeenDetailsFrame.location.href='MyRefNotSeenDetails.jsp?&'+url;
}

function changeColor1(object)
{
	anchorID=object.id;
	//alert("sdfsdf");
	if(object.style.color=='yellow')
	{	
		reOrder='1';
		object.style.color='pink';
		return;
	}

	if(object.style.color=='pink')
	{   
		reOrder='2';
		object.style.color='yellow';
		return;
	}

	reOrder='1';
	
	for(i=0;i<document.anchors.length;i++)
	{
		document.anchors(i).style.color='white';
	}

	object.style.color='pink';	
}
