/*
-------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------
28/05/2018	IN065341		Prakash C	29/05/2018		Ramesh G 		MMS-DM-CRF-0115
---------------------------------------------------------------------------------------------
*/
function getCatelogRiskFactorDetails(){   
	var count=document.CAHealthRiskAssessmentDiagnosisForm.diagnosisChk.length;
	var called_from=document.CAHealthRiskAssessmentDiagnosisForm.called_from.value;//IN065341
	var values_="";
	if(count==undefined){
		if(document.CAHealthRiskAssessmentDiagnosisForm.diagnosisChk.checked){			
			values_=document.CAHealthRiskAssessmentDiagnosisForm.diagnosisChk.value;			
		}
	}else{	
		for(var i=0;i<count;i++){   
			if(document.CAHealthRiskAssessmentDiagnosisForm.diagnosisChk[i].checked){
				if(i!=0)
					values_=values_+"|";
				values_=values_+document.CAHealthRiskAssessmentDiagnosisForm.diagnosisChk[i].value;
				 
			}	
		}
	}
	parent.CAHealthRiskAssessmentHealthRiskFactorsFrm.location.href="../../eCA/jsp/CAHealthRiskAssessmentHealthRiskFactors.jsp?"+document.CAHealthRiskAssessmentDiagnosisForm.reqString.value+"&TermSetCode="+values_;
	if(called_from!="CDR"){//IN065341
		parent.CAHealthRiskAssessmentOrderCatalogFrm.location.href="../../eCA/jsp/CAHealthRiskAssessmentOrderCatalogs.jsp?"+document.CAHealthRiskAssessmentDiagnosisForm.reqString.value+"&TermSetCode="+values_;
	}//IN065341
}
//function openGrpah(index,patient_id,event_code,event_group,histRecType)
async function openGrpah(index,patient_id,event_code,event_group,histRecType,RepDb,clob_data)//IN065341
{
	var dialogHeight	= "30" ;
	var dialogWidth		= "50" ;
	var status			= "no";
	var dialogTop		= "140";
	var arguments		= "" ;
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	
	//var action_url		=	'../../eCA/jsp/ChartSummaryResultsGraphMain.jsp?patient_id='+patient_id+'&event_code='+event_code+'&event_group='+event_group+'&histRecType='+histRecType;
	var action_url		=	'../../eCA/jsp/ChartSummaryResultsGraphMain.jsp?patient_id='+patient_id+'&event_code='+event_code+'&event_group='+event_group+'&histRecType='+histRecType+'&RepDb='+RepDb+'&clob_data='+clob_data;
	var retVal=await window.showModalDialog(action_url,arguments,features);
}