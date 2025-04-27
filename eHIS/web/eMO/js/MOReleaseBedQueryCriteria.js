function submitPage()
{
parent.frames[2].location.href= "../jsp/MOReleasedBedQueryResult.jsp?area_code="+document.forms[0].area_code.value+"&bed_no="+document.forms[0].bed_no.value+"&blocked_until="+document.forms[0].blocked_until.value;
parent.frames[1].document.forms[0].search.disabled=true;
}

function clearAll()
{
parent.frames[2].document.location.href="../../eCommon/html/blank.html";
}
function reset()
{
frames[1].document.location.reload();
frames[2].document.location.href="../../eCommon/html/blank.html";
}
 async function searchBed()
{
	var retVal =    new String();
	var area_code   =document.forms[0].area_code.value;
	var retVal = "";
	var dialogHeight= "500px" ;
	var dialogWidth	= "800px" ;
	var dialogTop ="60";
	var status = "no";
	var arguments	= " ";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop + ";scroll=no; status:" + status;
    var retVal=await	window.showModalDialog("../../eMO/jsp/MOBayAvailabilityChart.jsp?area_code="+area_code+"&bed_status=BL&disable=yes",arguments,features);
    if(retVal != null && retVal != "" )
     {
	  document.forms[0].bed_no.value=retVal;
	 }
	
	


}

function enableData()
{
if(document.forms[0].area_code.value!="")
{
document.forms[0].search_bed.disabled=false;
document.forms[0].bed_no.disabled=false;
document.forms[0].bed_no.value="";

}else{
document.forms[0].bed_no.disabled=true;
document.forms[0].search_bed.disabled=true;
document.forms[0].bed_no.value="";
}


}

function onSuccess()
{
frames[2].document.location.reload();
}
function apply()
{var releasedata="";
if(frames[2].document.forms[0]!=null)
	{
count=frames[2].document.forms[0].count.value;
for(i=1;i<count;i++)
{
if(eval("frames[2].document.forms[0].rel"+i+".checked"))
 {

 releasedata1=eval("frames[2].document.forms[0].rel"+i+".value")

 releasedata=releasedata+releasedata1+'~'
 }

}



frames[2].document.forms[0].releasedata1.value=releasedata;


if(frames[2].document.forms[0].releasedata1.value!="")
	{
	frames[2].document.forms[0].submit();
	}else
	{
	messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="
	}
	}else
	{
	messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="
	}
}
