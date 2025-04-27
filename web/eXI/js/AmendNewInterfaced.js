 function funAction(typ)
{
	document.forms[0].action_type.value=typ;
		document.forms[0].action_type.value = typ;
 
	funSubmit();
}
function checkObj(obj,cou) 
{ 

if(obj.checked==true)
{
	obj.value="Y";

	document.getElementById("sale"+cou).style.display = "block";  
	document.getElementById("saledummy"+cou).style.display = "none";  
	document.getElementById("gen"+cou).style.display = "block";
	document.getElementById("gendummy"+cou).style.display = "none";

	}
	else
	{ 	 
	obj.value="N";
	document.getElementById("gen"+cou).style.display = "none";
	document.getElementById("gendummy"+cou).style.display = "block";
	document.getElementById("sale"+cou).style.display = "none"; 
	document.getElementById("saledummy"+cou).style.display = "block";   
	} 
}
function funSubmit()
{
	//his.document.forms[0].action = act;
	this.document.forms[0].submit();
}
function apply()
{
	frames[3].document.location.href='../../eCommon/jsp/MstCodeError.jsp'; 
	var k=0;
	var falg=true;
	var fields ;
	var names ;
  if(frames[2].document.forms[0])
	{
	var count=parseInt(frames[2].document.forms[0].count_field.value);
for(var i=0;i<count;i++)
{
	 if(frames[2].document.getElementById("select"+i).checked==true)
	{
	k=1;
		 if(frames[2].document.getElementById("_genuomcode"+i).value==''  )
		{
			falg=false;
		}

		if(frames[2].document.getElementById("_saleuomcode"+i).value=='')
		{
falg=false;
		}
	}


}  

if(k==1)
{
	if(falg==false)
{
	  
	fields=new Array (frames[2].document.forms[0].genuomhidden);
    names = new Array (getLabel('eXI.GenUOMSaleUOM.Label','XI')); 
	if(!f_query_add_mod.checkFields( fields, names, messageFrame))
{ 

} 
else
{
}
} 
else
{

	frames[2].document.forms[0].submit();
frames(2).document.location.reload();
}
//
}
else
{


alert(getMessage('ATLEAST_ONE_SELECTED','common'));
}






 
	//frames[2].document.forms[0].submit();
	}

window.commontoolbarFrame.document.location.reload();
}

function reset()
{
	   // alert(window.f_query_add_mod.document.forms[0].name); 
		frames[3].document.location.href="../../eCommon/jsp/error.jsp"; 
        frames[1].document.forms[0].reset();
        frames[2].document.location.href='../../eCommon/html/blank.html';
	

 
}
