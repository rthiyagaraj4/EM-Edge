function getNext(from,to)
{
	document.forms[0].from.value = from;
	document.forms[0].to.value	 = to; 
	document.forms[0].submit();		
}
/*
function defaultOPtion()
{
	var flag =  document.forms[0].OneRecordFlag.value ;
	if(flag == "Yes"  || flag == "yes" )
	{
		document.forms[0].fs_locn_code.selectedIndex = 1 ;
		//getResult();
	}
} */
function getResult()
{
	var criteria		=  document.forms[0].fs_locn_code.value ;
	var facility_id		=  document.forms[0].facility_id.value ;
	parent.frames[2].document.location.href='../../eFM/jsp/QueryFMFileNotReturnedToMRDSearchResult.jsp?' +	'&criteria=' + criteria +'&facility_id=' + facility_id + '&flag=next&nextRecord=0&previousRecord=0'; 
}
function SearchGetResult()
{
	var doc_or_file			= document.forms[0].doc_or_file.value;
	var out_facility_id		= document.forms[0].out_fcy.value;
	var facility_id			= document.forms[0].facility_id.value;
	var out_criteria		= document.forms[0].out_fs_locn.value;
	var criteria			= document.forms[0].fs_locn_code.value;
	var fs_locn_id			= document.forms[0].fs_locn_id.value;
	var file_type_appl_yn	= document.forms[0].file_type_appl_yn.value;
		
	document.forms[0].search.disabled=true;
		
	if(doc_or_file == 'D')
	{
		parent.frames[2].location.href='../../eFM/jsp/QueryDTFileNotReturnedToMRDSearchResult.jsp?'+'&from_search=Y'+'&facility_id='+facility_id+'&out_criteria='+out_criteria+'&criteria='+criteria+'&out_facility_id='+out_facility_id+'&file_type_appl_yn='+file_type_appl_yn+'&fs_locn_id=' + fs_locn_id + '&flag=next&nextRecord=0&previousRecord=0'; 
	}
	else if(doc_or_file == 'F')
	{
		parent.frames[2].location.href='../../eFM/jsp/QueryFMFileNotReturnedToMRDSearchResult.jsp?'+'&from_search=Y'+'&facility_id='+facility_id+'&doc_or_file='+doc_or_file+'&file_type_appl_yn='+file_type_appl_yn+'&out_criteria='+out_criteria+'&criteria='+criteria+'&out_facility_id='+out_facility_id+'&fs_locn_id='+fs_locn_id+'&flag=next&nextRecord=0&previousRecord=0'; /*Added doc_or_file in the above line on 7th Mar 2017 for ML-MMOH-SCF-0588*/
	}
}

function PopulateFSLocn(obj)
{
	var p_facility_id = document.forms[0].facility_id.value;
	var p_curr_fs_loc = document.forms[0].fs_locn_code.value;
	var sel			  = document.forms[0].out_fs_locn;
	var p_fs_locn_id  = document.forms[0].fs_locn_id.value;
	var out_fcy = document.forms[0].out_fcy.value;
	parent.searchResultFrame.document.location.href='../../eCommon/html/blank.html';
	while(sel.options.length>1)
	{
		sel.remove(1);
	}
	var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='populateFSLoc' id='populateFSLoc' method='post' action='../../eFM/jsp/FMReturnPopFSLoc.jsp?p_facility_id="+p_facility_id+"&p_curr_fs_loc="+p_curr_fs_loc+"&p_fs_locn_id="+p_fs_locn_id+"&out_fcy="+out_fcy+"&param_num=4'></form></body></html>" ;

	parent.frames[4].document.write(HTMLVal) ;
	parent.frames[4].document.populateFSLoc.submit() ;

}
function ClearResult()
{
	parent.searchResultFrame.document.location.href='../../eCommon/html/blank.html';
   document.forms[0].fs_locn_id.value="";
   removeitems(document.forms[0].out_fs_locn);
  }
function clearAllValues()
{
	parent.searchResultFrame.document.location.href='../../eCommon/html/blank.html';
	document.forms[0].out_fcy.value='';
	document.forms[0].fs_locn_id.value='';
	var sel	= document.forms[0].out_fs_locn;
	while(sel.options.length > 1)
	{
		sel.remove(1);
	}
}
function reset()
{
	searchFrame.document.forms[0].search.disabled=false;
	searchResultFrame.document.location.href = 	'../../eCommon/html/blank.html';
	searchFrame.location.reload(); 
}

function removeitems(obj)
{
	var len=obj.length;
	var i=1;
	while(i<len)
	{
		len=obj.length
		obj.remove(i)
	}
}

