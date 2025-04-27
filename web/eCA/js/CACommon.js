/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
15/04/2023		37866			Ramesh G		 MMS-DM-CRF-0226	
 18/10/2023     32902             Krishna Pranay    	     19/10/2023      Ramesh G      MMS-DM-CRF-0210	

---------------------------------------------------------------------------------------------------------------
*/
async function virtualConsultation(facility_id,patient_id,episode_type,episode_id,clinician_id)
{		
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;	
	xmlStr += " facility_id=\""+ facility_id + "\" ";
	xmlStr += " patient_id=\""+ patient_id + "\" ";
	xmlStr += " episode_type=\""+ episode_type + "\" ";
	xmlStr += " episode_id=\""+ episode_id + "\" ";
	xmlStr += " clinician_id=\""+ clinician_id + "\" ";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "../../eCA/jsp/VirtualConsultationValidate.jsp?facility_id=" + facility_id +"&patient_id=" + patient_id +"&episode_type="+episode_type+"&episode_id="+episode_id+"&clinician_id="+clinician_id, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;	
	var resultVal = (responseText.replace( /^\s+/g, "" ).replace( /\s+$/g, "" )).split("!");
	if(resultVal[0] == "Y" )
	{
		var appDetails = resultVal[1].split("~");
		//alert("--------->"+appDetails[0]+"<--->"+appDetails[1]+"<--->"+appDetails[2]+"<---");
		if(appDetails[1]=="Virtual"){
			if(appDetails[2]=="Complete"){
				
			}else{
				var dialogHeight ='36' ;
				var dialogWidth = '68' ; 
				var dialogTop	= '129';
				var dialogLeft = '110' ;
				var title = ''
				var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';

				var arguments = "";
				var retVals =await window.showModalDialog(appDetails[0],arguments,features);
			}
		}
	}
}


//32902 start
function restrictOpenVIPPat(pat_id,restPatientYN,accessRightsViewPatient)
{	  
  if(pat_id !=="" && restPatientYN =="Y" && accessRightsViewPatient==0){
   alert(getMessage("AC_RSTR_PAT_LMT_AUT","CA"));
    return false;
 } 
}
//32902 end
