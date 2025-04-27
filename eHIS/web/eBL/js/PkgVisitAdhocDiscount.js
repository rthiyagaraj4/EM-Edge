
function callPackageDetails(obj)
{
	parent.PkgVisitAdhocDiscountDtlsFrame.location.href="../../eCommon/html/blank.html";
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	var patientId=obj.value;
	if(patientId=="")
		alert(getMessage("BL0002","BL"));
	else
	{
		parent.PkgVisitAdhocDiscountPatientHdrDtlsFrame.location.href="../../eBL/jsp/PkgVisitAdhocDiscountDtlsForPatient.jsp?patientId="+patientId;
	}
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
	

function displayAdhocDiscountDtls(patientId, packageCode,packageSeqNo,called_from,episode_id,visit_id,blnggrp,billdoctype,billdocnum,packagelongDesc)
{
	saveOnChange();
	parent.PkgVisitAdhocDiscountPatientHdr.location.href="../../eBL/jsp/PkgVisitAdhocDiscountPatientHdrDtls.jsp?patientId="+patientId+"&packageCode="+packageCode+"&packageSeqNo="+packageSeqNo+"&packagelongDesc="+encodeURIComponent(packagelongDesc);
	parent.PkgVisitAdhocDiscountDtlsFrame.location.href="../../eBL/jsp/PkgVisitAdhocDiscountDetails.jsp?patientId="+patientId+"&packageCode="+packageCode+"&packageSeqNo="+packageSeqNo+"&called_from="+called_from+"&episode_id="+episode_id+"&visit_id="+visit_id+"&blnggrp="+blnggrp+"&billdoctype="+billdoctype+"&billdocnum="+billdocnum;
	parent.PkgVisitAdhocDiscountBtnFrame.location.href="../../eBL/jsp/PkgVisitAdhocDiscountBtn.jsp?patientId="+patientId+"&packageCode="+packageCode+"&packageSeqNo="+packageSeqNo;
}

function saveOnChange()
{  
	var frmObj = "";
	if(parent.PkgVisitAdhocDiscountDtlsFrame == undefined)
	{
		if(PkgVisitAdhocDiscountDtlsFrame !=undefined)
		frmObj = PkgVisitAdhocDiscountDtlsFrame.document.forms[0];
	}
	else
		frmObj = parent.PkgVisitAdhocDiscountDtlsFrame.document.forms[0];	

	if(frmObj!=null && frmObj!="" && frmObj!=undefined)
	{
		var xmlString=formXMLString(frmObj);
		//alert("xmlString :"+xmlString);
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc.loadXML(xmlString);
		xmlHttp.open("POST","PkgVisitAdhocDiscountValidation.jsp",false);
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
	//alert("xmlStr :"+xmlStr);
	xmlStr +=" /></root>";
	}

	return xmlStr;
}


function apply()
{
	var tot_records = parent.PkgVisitAdhocDiscountDtlsFrame.document.forms[0].totalRec.value;	
	for(var i=0;i<tot_records;i++)
	{
		if(eval("parent.PkgVisitAdhocDiscountDtlsFrame.document.forms[0].adhocDiscount_"+i).value!="" && eval("parent.PkgVisitAdhocDiscountDtlsFrame.document.forms[0].reason_desc"+i).value=="")
		{
			alert(getMessage("BL9608","BL"));		
			eval("parent.PkgVisitAdhocDiscountDtlsFrame.document.forms[0].reason_desc"+i).focus();
			return false;
		}
	}
	saveOnChange();
	parent.PkgVisitAdhocDiscountDtlsFrame.document.forms[0].target='submit_frame';
	parent.PkgVisitAdhocDiscountDtlsFrame.document.forms[0].method='post';
	parent.PkgVisitAdhocDiscountDtlsFrame.document.forms[0].action="../../servlet/eBL.PkgAdhocDiscountServlet";
	parent.PkgVisitAdhocDiscountDtlsFrame.document.forms[0].submit();	
}

function onSuccess()
{
//	parent.document.location.reload();
}

function validateInd(obj,index)
{
	eval("document.forms[0].adhocDiscount_"+index).value="";
}

function chkAmtPer(obj,index,noofdecimal)
{
	if(document.forms[0].auth_discount.value=="")
	{
		alert(getMessage("BL7495","BL"));
		eval("document.forms[0].adhocDiscount_"+index).value="";
		return false;
	}
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
			obj.value  = "";
			obj.focus();
		}
		else
		{
			putDecimal(obj,13,noofdecimal);
		}
	}
}


function cancel()
{
	//const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    //dialogTag.close();
	toCloseTopShowModal();
}

async function callAuth()
{   
	var retVal=new Array();
	var dialogHeight= "14" ;
	var dialogWidth	= "22" ;
	var dialogTop = "225" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;	
	retVal =await window.showModalDialog("../../eBL/jsp/PkgAdhocDiscAuthoriseMain.jsp?mode=s",arguments,features);
	//alert(retVal);
	parent.PkgVisitAdhocDiscountDtlsFrame.document.forms[0].auth_discount.value=retVal;
	//alert("fsdds :"+parent.PkgVisitAdhocDiscountDtlsFrame.document.forms[0].auth_discount.value);
	/*document.forms[0].auth_discount.value=retVal;
	if(parent.PkgAdhocDiscountDtlsFrame.document.forms[0]!=undefined)
	{
		parent.PkgAdhocDiscountDtlsFrame.document.forms[0].auth_discount.value=retVal;
	}*/
	if(retVal=="Y"){
	parent.PkgVisitAdhocDiscountBtnFrame.document.forms[0].auth_btn.disabled=true;
	}
}

function searchReason(clng_evnt,index)
			{
				if(eval("document.forms[0].adhocDiscount_"+index).value=="")
				{			
					var msg = getMessage("BL6322","BL");
					alert(msg+"/"+"000");
					eval("document.forms[0].reason_desc"+index).value="";
					return false;
				}
				var obj=eval("document.forms[0].reason_desc"+index);
				if(clng_evnt == 'B')
				{
					if(obj.value == "")
					{					
						eval("document.forms[0].reason_desc"+index).value="";
						eval("document.forms[0].reason_code"+index).value="";
						//document.forms[0].reason_code.value="";	
						return;
					}
				}
				var target			= eval("document.forms[0].reason_desc"+index);
				var retVal			=  new String();
				var dialogTop	 = "10";
				var dialogHeight = "10" ;
				var dialogWidth	 = "30" ;
				var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
				var arguments			= "" ;
				var search_desc			= "";
				var title =getLabel("eBL.ADHOC_DISC_REASON.label","BL");		
		//		var title = encodeURIComponent(title);		
				var locale  = document.forms[0].locale.value;		
				
				var sql2="select  a.action_reason_code code,a.action_reason_desc description from bl_action_reason_lang_vw a,bl_action_reason_by_type b where a.action_reason_code  = b.action_reason_code and nvl(a.status,'X') <> 'S' and NVL(b.active_yn, 'N') = 'Y' and upper(language_id) = upper('"+locale+"') AND ACTION_TYPE='PD' and upper(a.action_reason_code) like upper(?) and upper(a.action_reason_desc) like upper(?) order by 1";

				var argArray = new Array();
				var namesArray = new Array();
				var valuesArray = new Array();
				var datatypesArray = new Array();

				argArray[0] = sql2;
				argArray[1] = namesArray;
				argArray[2] = valuesArray;
				argArray[3] = datatypesArray;
				argArray[4] = "1,2";
				argArray[5] = target.value;
				argArray[6] = DESC_LINK;
				argArray[7] = DESC_CODE;		
				retArray = CommonLookup( title, argArray );		
				
				if(retArray != null && retArray !="")
				{				
					eval("document.forms[0].reason_code"+index).value=retArray[0];
					eval("document.forms[0].reason_desc"+index).value=retArray[1];
//					document.forms[0].reason_desc.value=retArray[1];			
								
				}
				else
				{			
					eval("document.forms[0].reason_code"+index).value="";
					eval("document.forms[0].reason_desc"+index).value="";
					//	document.forms[0].reason_code.value="";		
				}
			}
