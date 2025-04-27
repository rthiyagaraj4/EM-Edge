//  
 
function reset()
{


window.search.document.location.reload();
//window.search.location.href="../../eCommon/html/blank.html";		
window.filterframe.location.href="../../eCommon/html/blank.html";
window.recordframe_detail.location.href="../../eCommon/html/blank.html";
window.recordframe.location.href="../../eCommon/html/blank.html";
window.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";

}
function filterDetails()
{   
																					    
	if(document.forms[0].Filter_group_desc.value=='')
	{
	}
	else 
	{
    
parent.frames[2].location.href="../../eXH/jsp/FilteringAndSchedulingApplicationSearch.jsp?Filter_group_code="+document.forms[0].Filter_group_desc_id.value;
//parent.frames[3].location.href="../../eXH/jsp/FilteringandschedulingApplicationSearch1.jsp?Filter_group_code="+document.forms[0].Filter_group_desc_id.value;
parent.frames[3].location.href="../../eXH/jsp/FilteringAndSchedulingApplicationLevel.jsp?Filter_group_code="+document.forms[0].Filter_group_desc_id.value+"&rule=R";
parent.frames[4].location.href="../../eCommon/html/blank.html";
	}
}  
