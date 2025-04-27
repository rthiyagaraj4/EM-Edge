function reset()
{
	PkgPatIdFrame.document.forms[0].patientId.value = "";
	PkgPatientHdr.location.href="../../eCommon/html/blank.html";
	PkgOutsideServicesPatientHdrDtlsFrame.location.href="../../eCommon/html/blank.html";
	PkgOutsideServicesPatientHdr.location.href="../../eCommon/html/blank.html";
	PkgOutsideServicesDtlsFrame.location.href="../../eCommon/html/blank.html";

}

function callPackageDetails(obj)
{
	parent.PkgOutsideServicesPatientHdr.location.href="../../eCommon/html/blank.html";
	parent.PkgOutsideServicesDtlsFrame.location.href="../../eCommon/html/blank.html";
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	var patientId=obj.value;
	if(patientId=="")
		alert(getMessage("BL0002","BL"));
	else
	{
		parent.PkgPatientHdr.location.href="../../eCommon/jsp/pline.jsp?Patient_ID="+patientId;
		parent.PkgOutsideServicesPatientHdrDtlsFrame.location.href="../../eBL/jsp/PkgOutsideServicesDtlsForPatient.jsp?patientId="+patientId;
	}
}

function getPatID()
	{	
		var pat_id=PatientSearch();		
		if( pat_id != null )						
		document.forms[0].patientId.value = pat_id ;					
		document.forms[0].patientId.focus ();					
	}


/*For enquiry package  */
function displaypkgDtls(packageCode,packageSeqNo)
{
	var retVal				= new String();
	var dialogTop			= "10";
	var dialogHeight		= "330" ;
	var dialogWidth			= "200" ;
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:"+dialogHeight+"; dialogWidth:"+dialogWidth+";status=no" ;
	var sql					= "";
//	var title				= "";
	var title=encodeURIComponent(getLabel("eBL.PACKAGE_DTL.label","BL"))
	var param = "title="+title+"&packageCode="+packageCode+"&packageSeqNo="+packageSeqNo;
	if(packageSeqNo == null || packageSeqNo == "")
		alert(getMessage("BL8501",'BL')); 
	else
		retVal=window.showModalDialog("../../eBL/jsp/PkgEnqMain.jsp?"+param,arguments,features);	
}
	

function displayOutsideServicesDtls(patientId,packageCode,packageSeqNo)
{
	saveOnChange();
	parent.PkgOutsideServicesPatientHdr.location.href="../../eBL/jsp/PkgOutsideServicesPatientHdrDtls.jsp?patientId="+patientId+"&packageCode="+packageCode+"&packageSeqNo="+packageSeqNo;
	parent.PkgOutsideServicesDtlsFrame.location.href="../../eBL/jsp/PkgOutsideServicesDetails.jsp?patientId="+patientId+"&packageCode="+packageCode+"&packageSeqNo="+packageSeqNo;
}

function saveOnChange()
{  
	var frmObj = "";
	if(parent.PkgOutsideServicesDtlsFrame == undefined)
	{
		if(PkgOutsideServicesDtlsFrame !=undefined)
		frmObj = PkgOutsideServicesDtlsFrame.document.forms[0];
	}
	else
		frmObj = parent.PkgOutsideServicesDtlsFrame.document.forms[0];
	if(frmObj!=null && frmObj!="" && frmObj!=undefined)
	{
		var xmlString=formXMLString(frmObj);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc.loadXML(xmlString);
		xmlHttp.open("POST","PkgOutsideServicesValidation.jsp",false);
		xmlHttp.send(xmlDoc);
		var responseText=xmlHttp.responseText ;
		eval(responseText);
		return true;
	}
}



function formXMLString(frmObj)
{
    if( frmObj!=null && frmObj != "undefined" && frmObj.length >0)
	{	
		var xmlStr ="<root><SEARCH ";
		if(true)
		{
		var arrObj = frmObj.elements;
		
		for(var i=0;i<arrObj.length;i++)
		{
			var val = "" ;
			if(arrObj[i].type == "checkbox")
			{
				val = arrObj[i].value;
				if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
	        }
		    else if(arrObj[i].type == "radio")
			{
				if(arrObj[i].checked)
				{
					val = arrObj[i].value;
			        if(arrObj[i].name != null && arrObj[i].name != "")
						xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
	            }
		    }
			else if(arrObj[i].type == "select-multiple" )
			{
				for(var j=0; j<arrObj[i].options.length; j++)
			    {
					if(arrObj[i].options[j].selected)
						val+=arrObj[i].options[j].value +"~"
	            }
		        val= val.substring(0,val.lastIndexOf('~'))
			    if(arrObj[i].name != null && arrObj[i].name != "")
				    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
			}
		    else
			{
				val = arrObj[i].value;
		        if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
	        }
		}
	}
	xmlStr +=" /></root>";
	}

	return xmlStr;
}


function apply()
{
	saveOnChange();
	PkgOutsideServicesDtlsFrame.document.forms[0].target='messageFrame';
	PkgOutsideServicesDtlsFrame.document.forms[0].method='post';
	PkgOutsideServicesDtlsFrame.document.forms[0].action="../../servlet/eBL.PkgOutsideServicesServlet";
	PkgOutsideServicesDtlsFrame.document.forms[0].submit();	
}

function onSuccess()
{
	reset()
//	parent.document.location.reload();
}

function validateInd(obj,index)
{
	eval("document.forms[0].OutsideServices_"+index).value="";
}

function chkAmtPer(obj,index)
{
	if(eval("document.forms[0].type_"+index).value == "R")
	{
		if(obj.value>100 || obj.value<0)
		{			
			alert(getMessage("BL8539","BL"));
			obj.value="";
		}
	}
	else
	{
		if(obj.value<0)
		{
			alert(getMessage("BL8640","BL"));
			obj.value="";
		}
	}
}
