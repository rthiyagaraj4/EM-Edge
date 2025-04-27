function codeCheck(Obj){
var u=Obj ;
if(u==' '){
parent.searchResultFrame.location.href='../../eCommon/html/blank.html';
}
if(u==1){
parent.searchResultFrame.location.href ="../../eFM/jsp/FMReportNarration.jsp";
}
if(u==2){
parent.searchResultFrame.location.href ="../../eFM/jsp/FMReportDeficiency.jsp";
}
if(u==3){
parent.searchResultFrame.location.href ="../../eFM/jsp/FMReportFSLocation.jsp";
}
if(u==4){
parent.searchResultFrame.location.href ="../../eFM/jsp/FMReportRequestMode.jsp";
}
if(u==5){
parent.searchResultFrame.location.href ="../../eFM/jsp/FMReportFileTransportMode.jsp";
}
}

function run()
{
		if(searchResultFrame.document.reportDeficiency){
		if( CheckString( getLabel('eFM.Deficiency.label','FM') , searchResultFrame.document.reportDeficiency.p_from_code,searchResultFrame.document.reportDeficiency.p_to_code, messageFrame )  )
			{
			searchResultFrame.document.reportDeficiency.submit();
			}
		}

		if(searchResultFrame.document.reportNarration){
		if( CheckString(getLabel('eFM.Narration.label','FM') , searchResultFrame.document.reportNarration.p_from_code,searchResultFrame.document.reportNarration.p_to_code, messageFrame )  )
		searchResultFrame.document.reportNarration.submit();
		}

		if(searchResultFrame.document.reportFSLocation){
		if( CheckString(getLabel('eFM.FSLocation.label','FM') , searchResultFrame.document.reportFSLocation.p_from_code,searchResultFrame.document.reportFSLocation.p_to_code, messageFrame )  )
		searchResultFrame.document.reportFSLocation.submit();
		}

		if(searchResultFrame.document.reportRequest){ 
		if( CheckString(getLabel('Common.RequestMode.label','Common') , searchResultFrame.document.reportRequest.p_from_code,searchResultFrame.document.reportRequest.p_to_code, messageFrame )  )
		searchResultFrame.document.reportRequest.submit();
		}

		if(searchResultFrame.document.reportTransport){
		if( CheckString(getLabel('Common.TransportMode.label','common') , searchResultFrame.document.reportTransport.p_from_code,searchResultFrame.document.reportTransport.p_to_code, messageFrame )  )
		searchResultFrame.document.reportTransport.submit();
		}

}

async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "65vh" ;
			var dialogWidth	= "55vw" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var p_facility_id = document.forms[0].p_facility_id.value;			
			
			if(obj.name=="RequestFrom")
			{
				tit=getLabel('Common.RequestMode.label','Common');
				sql="select req_mode,short_desc from fm_manual_request_mode_lang_vw  where EFF_STATUS=`E` and language_id=`"+localeName+"`";
				search_code="req_mode";
				search_desc= "short_desc";
			}
		
			if(obj.name=="RequestTo")
			{
				tit=getLabel('Common.RequestMode.label','Common');
				sql="select req_mode,short_desc from fm_manual_request_mode_lang_vw  where  language_id=`"+localeName+"`";
				search_code="req_mode";
				search_desc= "short_desc";
			}

			if(obj.name=="FSLocationFrom")
			{
				tit=getLabel('eFM.FSLocation.label','FM');
				sql="select fs_locn_code,short_desc from fm_storage_locn_lang_vw  where  language_id=`"+localeName+"` ";
				search_code="fs_locn_code";
				search_desc= "short_desc";
			}
		
			if(obj.name=="FSLocationTo")
			{
				tit=getLabel('eFM.FSLocation.label','FM')
				sql="select fs_locn_code,short_desc from fm_storage_locn_lang_vw  where  language_id=`"+localeName+"` ";
				search_code="fs_locn_code";
				search_desc= "short_desc";
			}

			if(obj.name=="narrationFrom")
			{
				tit=getLabel('eFM.Narration.label','FM');
				sql="select NARRATION_CODE, SHORT_DESC from fm_narration_lang_vw where EFF_STATUS=`E` and language_id=`"+localeName+"`";
				search_code="NARRATION_CODE";
				search_desc= "SHORT_DESC";
			}
			
			if(obj.name=="narrationTo")
			{
				tit=getLabel('eFM.Narration.label','FM');
				sql="select NARRATION_CODE, SHORT_DESC from fm_narration_lang_vw where EFF_STATUS=`E` and language_id=`"+localeName+"`";
				search_code="NARRATION_CODE";
				search_desc= "SHORT_DESC";
			}

			if(obj.name=="DeficiencyFrom")
			{
				tit=getLabel('eFM.Deficiency.label','FM');
				sql="select DEFICIENCY_CODE, SHORT_DESC from fm_deficiency_lang_vw where EFF_STATUS=`E` and language_id=`"+localeName+"`";
				search_code="DEFICIENCY_CODE";
				search_desc= "SHORT_DESC";
			}
		
			if(obj.name=="DeficiencyTo")
			{
				tit=getLabel('eFM.Deficiency.label','FM');
				sql="select DEFICIENCY_CODE, SHORT_DESC from fm_deficiency_lang_vw where EFF_STATUS=`E` and language_id=`"+localeName+"`";
				search_code="DEFICIENCY_CODE";
				search_desc= "SHORT_DESC";
			}
		
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}

 function reset()
 {
	searchFrame.document.forms[0].reset(); 
	searchResultFrame.document.location.href='../../eCommon/html/blank.html'; 
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp'; 
 }
