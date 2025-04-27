function reset()
{
	PkgUtilizationDetailsFrame.PkgPatIdFrame.document.forms[0].patientId.value = "";
	PkgUtilizationDetailsFrame.PkgPatientHdr.location.href="../../eCommon/html/blank.html";
	PkgUtilizationDetailsFrame.PkgUtilizationPatientHdr.location.href="../../eCommon/html/blank.html";
	PkgUtilizationDetailsFrame.PkgDtlsFrame.location.href="../../eCommon/html/blank.html";
	PkgUtilizationDetailsFrame.PkgServDtlsFrame.location.href="../../eCommon/html/blank.html";

}

function callPackageDetails(obj)
{
	parent.PkgUtilizationPatientHdr.location.href="../../eCommon/html/blank.html";
	parent.PkgServDtlsFrame.location.href="../../eCommon/html/blank.html";
	parent.PkgPatientHdr.location.href="../../eCommon/html/blank.html";
	parent.PkgDtlsFrame.location.href="../../eCommon/html/blank.html";

	var patientId=obj.value;
	if(patientId==null || patientId=="")
	{
		//alert(getMessage("BL0002","BL"));
	}
	else
	{
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "patientId=\"" + patientId + "\" " ;					
		xmlStr +=" /></root>";
		var temp_jsp="PkgAdhocDiscountValidation.jsp?func_mode=CHK_PAT_ID";					
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		var responseText=trimString(xmlHttp.responseText);		
		if(responseText=="N")
		{
			alert(getMessage("INVALID_PATIENT","MP"));
			obj.value="";
			obj.focus();
		}
		else if(responseText=="Y")
		{
			parent.PkgDtlsFrame.location.href="../../eBL/jsp/PkgUtilizationDtlsForPatient.jsp?patientId="+patientId;
		}
	}
}
function displayPline(patientId)
{
	parent.PkgPatientHdr.location.href="../../eCommon/jsp/pline.jsp?Patient_ID="+patientId;
}
async function getPatID()
	{	
		parent.PkgUtilizationPatientHdr.location.href="../../eCommon/html/blank.html";
		parent.PkgServDtlsFrame.location.href="../../eCommon/html/blank.html";
		parent.PkgPatientHdr.location.href="../../eCommon/html/blank.html";
		parent.PkgDtlsFrame.location.href="../../eCommon/html/blank.html";

		var pat_id=await PatientSearch();	
//alert("insdie getpatID 60");		
		if( pat_id != null )						
		document.forms[0].patientId.value = pat_id ;					
		document.forms[0].patientId.focus ();					
	}


/*For enquiry package  */
async function displaypkgDtls(packageCode,packageSeqNo)
{
	var retVal				= new String();
	var dialogTop			= "0vh";
	var dialogHeight		= "95vh" ;
	var dialogWidth			= "100vw" ;
	var features			= "dialogTop:"+dialogTop+"; dialogHeight:"+dialogHeight+"; dialogWidth:"+dialogWidth+";status=no" ;
	var sql					= "";
//	var title				= "";
	var title=encodeURIComponent(getLabel("eBL.PACKAGE_DTL.label","BL"))
	var param = "title="+title+"&packageCode="+packageCode+"&packageSeqNo="+packageSeqNo;
	if(packageSeqNo == null || packageSeqNo == "")
		alert("packageSeqNo is null.");
	else
		retVal=await top.window.showModalDialog("../../eBL/jsp/PkgEnqMain.jsp?"+param,arguments,features);	
}
	

function displayServDtls(patientId,packageCode,packageSeqNo,pkgDesc)
{
	parent.PkgUtilizationPatientHdr.location.href="../../eCommon/html/blank.html";
	parent.PkgServDtlsFrame.location.href="../../eBL/jsp/PkgUtilizationServDtlsForPatient.jsp?patientId="+patientId+"&packageCode="+packageCode+"&packageSeqNo="+packageSeqNo+"&pkgDesc="+encodeURIComponent(pkgDesc);
}

function displayPackageHdr(patientId,packageCode,packageSeqNo,pkgDesc)
{
	parent.PkgUtilizationPatientHdr.location.href="../../eBL/jsp/PkgUtilizationPatientHdrDtls.jsp?patientId="+patientId+"&packageCode="+packageCode+"&packageSeqNo="+packageSeqNo+"&pkgDesc="+encodeURIComponent(pkgDesc);
}

function putDecimal_Text(Obj,maxvalue,deci)
{
	var temp1=$.trim(Obj.text());
	var temp4=temp1.length;
	var count=parseInt(maxvalue) -parseInt(deci);
	if (parseInt(deci) > 0)
	{
		if(temp1.indexOf('.') <0)
		{
			if (temp4 <= parseInt(maxvalue))
			{
				if(temp1.length > (parseInt(maxvalue) -parseInt(deci)) && temp1.length <= maxvalue)
				{
					var temp2=temp1.substring(0,count);
					var temp3=temp2+"."+temp1.substring(count,temp1.length)
					if(temp3.length-1 < parseInt(maxvalue))
					{
						for(var t=0;t <=(parseInt(maxvalue)+1-temp3.length);t++)
						{
							temp3+="0";
						}
					}
					Obj.text(temp3);
				}
				else if(temp1.length <= (parseInt(maxvalue) -parseInt(deci)) && temp1.length <= maxvalue)
				{
					var temp3=temp1+'.';
					for(var m=0;m<deci;m++)
					temp3+="0";
					Obj.text(temp3);
				
				}
				if (temp1.length == 0 )
				{
			 		temp3="0.";
					for(var m=0;m<deci;m++)
					temp3+="0";
					Obj.text(temp3);
	 
				}
   
 
			}

		}else{
			var temp5=temp1.indexOf('.');
			var temp7=temp1.substring(0,temp5);
			var tempForMinus = temp7;
			var temp6=temp1.substring(temp7.length+1,(temp7.length+parseInt(deci)+1));
			
			/*Added new Logic for Rounding*/
			var nextDigit = temp1.substring(temp7.length+1,(temp7.length+parseInt(deci)+2));

			if(nextDigit.length>temp6.length){
				var lastDigit = nextDigit.substring(deci,parseInt(deci)+1);
				if(lastDigit>=5){
					if(temp6>(Math.pow(10,deci) - 2)){
						temp7 = parseFloat(temp7)+parseFloat(1);
						temp6=0;
					}
					else{
						if(temp6.charAt(0) == '0'){
							var temp10 = parseFloat(temp6)+parseFloat(1);
							temp6 = '0'+temp10;
						}
						else{
							temp6=parseFloat(temp6)+parseFloat(1);
						}												
					}					
					
				}
			}
			/*Added new Logic for Rounding*/
			var localTemp='';
			var len=parseInt(deci)-parseInt(temp6.toString().length);
			for(var m=0;m<len;m++){
				localTemp+='0';
			}
			
			if(temp5 == 0){
				Obj.text("0."+temp6+localTemp);
			}
			else if(temp5 == 1 && tempForMinus == '-'){
				Obj.text(temp7+"0."+temp6+localTemp);
			}
			else{
				Obj.text(temp7+"."+temp6+localTemp);
			}
	
		}
	}
}


