//Added by Sethu

function ShowScanner(patientID, doc_main_type, documentId,calledFrom)
{	
	
	var encounterId = ""; var docMainType = ""; var docType = "";

	if(doc_main_type == "MP")
	{
		documentId=documentId+(Math.ceil( Math.random()*1000));
		if(calledFrom.name=='doc1scan'){
			document.forms[0].document_id1.value=documentId;
			docType = document.forms[0].doc_id1.value;					// Added for 4789 on 20/04/2016
			docType = docType +"~"+ document.forms[0].doc_id1_desc.value;
		}else if(calledFrom.name=='doc2scan'){
			document.forms[0].document_id2.value=documentId;			
			docType = document.forms[0].doc_id2.value;					// Added for 4789 on 20/04/2016
			docType = docType +"~"+ document.forms[0].doc_id2_desc.value;
		}else if(calledFrom.name=='doc3scan'){
			document.forms[0].document_id3.value=documentId;
			docType = document.forms[0].doc_id3.value;					// Added for 4789 on 20/04/2016
			docType = docType +"~"+ document.forms[0].doc_id3_desc.value;
		}else if(calledFrom.name=='doc4scan'){
			document.forms[0].document_id4.value=documentId;
			docType = document.forms[0].doc_id4.value;					// Added for 4789 on 20/04/2016
			docType = docType +"~"+ document.forms[0].doc_id4_desc.value;
		}
	}
	
	var dialogHeight= "440px" ;
	var dialogWidth	= "950px" ;
	var dialogTop	= "10";
	var dialogLeft	= "10";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=yes; status:no;help:no ";	

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var searchType="CheckDocumentConfiguration";
	//var docType=doc_main_type;  // Commented for 4789 on 20/04/2016
	var xmlStr ="<root><SEARCH ";	
	xmlStr += " DocType=\""+doc_main_type+"\"";	
	xmlStr += " utilType=\""+searchType+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eCommon/jsp/DocumentScanAjaxUtil.jsp",false);	
	xmlHttp.send(xmlDoc);
							
	var xhcheck=xmlHttp.responseText;

	if(xhcheck.indexOf("Y") < 0)	
	{
		alert("Scanning Document Configuration is not available for the Facility, Kindly contact System Administrator.");
		return;
	}
	

	if (doc_main_type.length > 0) {
		
		if (doc_main_type  == "MP") {
			docMainType = doc_main_type +"~ Patient Registration - Documents ";
		}
		else if (doc_main_type  == "FN"){
			docMainType = doc_main_type +"~ Insurance Documents ";
		}		
	}	

	var ret = window.showModalDialog("../../eCommon/jsp/EM_Scanner_Head.jsp?patient_id="+patientID+"&encounter_Id="+encounterId+"&document_id="+documentId+"&doc_main_type="+docMainType+"&doc_type="+docType,arguments,features);

}

