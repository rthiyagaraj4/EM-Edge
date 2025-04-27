function apply()
{
 f_query_add_mod.document.AddModifyAccsRightsforQMgmt.submit();

} 

function onSuccess() 
{  
	 f_query_add_mod.document.location.reload();


}


function reset()	
{
	//parent.content.frames[1].document.forms[0].reset();
	 parent.content.frames[1].location.reload();

}

function Enable_counsl(obj,counter)
{
		if (obj.checked==true)
		{
		document.getElementById("counsulation_yn"+counter).disabled=false;
		obj.value='Y';
		}
		else
	{
		 document.getElementById("counsulation_yn"+counter).checked=false;
		 document.getElementById("counsulation_yn"+counter).disabled=true;
		 obj.value='N';
	}
}

function CounslationCheck(obj)
{
	if (obj.checked==true)
	{
		obj.value='Y';
	}
	else 
	{
		obj.value='N';
	}

}


//<!--Added by Himanshu Saxena on 15-Jun-2023 for ML-MMOH-CRF-1972 Starts-->
function Checkboxcheck(id,count)
{
	var enable_admission_tab=document.getElementById(id+count).checked;
	if(enable_admission_tab)
	{
		document.getElementById(id+count).value="Y"
	}	
	else
	{
		document.getElementById(id+count).value="N";
	}
}

