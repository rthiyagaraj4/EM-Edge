function searchResult()
{
 
	var frmObj	= document.OrderableSearch;
	
	
	if(frmObj.search_by[0].checked)
	{
		search_by="D";
	}
	else
	{  
		search_by="C";
	}
		description_code=frmObj.search_criteria.value
		search_text=frmObj.search_text.value;
 		var called_from = frmObj.called_from.value;   
 		sql_query=frmObj.sql_query.value;


 		parent.refusal_resultframe1.location.href = "../../eXH/jsp/FileteringAndSchdulingLookupQueryResult.jsp?&search_by="+search_by+"&description_code="+description_code+"&search_text="+encodeURIComponent(search_text)+"&called_from="+called_from+"&sql_query="+encodeURIComponent(sql_query);

		   parent.refusal_addresultframe1.location.href ="../../eCommon/html/blank.html"; 
       parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";

}  
function changeCursor(obj) {
	//obj.style.cursor = "hand" ;
	obj.style.cursor = "pointer";
}

function disableClick(evnt) {
	evnt.cancelBubble = true ;
}
function resetFormSearch(frmObj)
{
		var qry_str= document.forms[0].qry_str.value;


 		parent.parent.refusal_searchframe1.location.href = "../../eXH/jsp/FileteringAndSchdulingLookupSearch.jsp?";
        parent.refusal_resultframe1.location.href = "../../eCommon/html/blank.html";
         parent.frames[2].document.location.href= "../../eCommon/html/blank.html";
	    parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
		frmObj.search_text.value='';		
		
		/*		frmObj.reset();
				frmObj.search_text.value = "";
				n=frmObj.ordercategory.length
				clearList("document");
				clearActivityList("document");
				
		for(i=0;i<n;i++)
		{
				var element = document.createElement('OPTION') ;
				element.value=frmObj.ordercategory[i].value;
				element.text=frmObj.ordercategory[i].text;
				if(element.value!="" && element.text!="All")
				frmObj.typecode.add(element);
		}*/

	

}
async function CallCatalogSearch(Query,target)
{
	//alert("1");
	var module_id='XH';
	var mode="";
	var searchtext=target.value;

	//var clinic_code = parent.frames[3].document.forms[0].assign_care_locn_code.value;
var dialogHeight = "90vh";
var dialogWidth  = "70vw";
var dialogTop    = "250";
var dialogLeft   = "250";
var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
/*	var dialogTop	= "56"; 
	var dialogHeight= "33" ; 
	var dialogWidth = "50" ;
	var status = "no";
	var scroll = "no";
	var features    = "dialogTop:"+dialogTop+"; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;*/
	var arguments   = "" ;			
	var retVal=await window.showModalDialog("../../eXH/jsp/FilteringAndSchdulingLookupFrameset.jsp?searchText="+encodeURIComponent(searchtext)+"&sql_query="+encodeURIComponent(Query)+"&called_from=XH&mode="+mode,arguments,features);	




    return retVal;
	//var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='popordercatalog' id='popordercatalog' method='post' action='../../eOP/jsp/RoomValidationYN.jsp'><input type='hidden' name='callfunc' id='callfunc' value='OrderCatalog'></form></body></html>";		
				
	//parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal); 
	//parent.parent.messageFrame.document.popordercatalog.submit();
}

