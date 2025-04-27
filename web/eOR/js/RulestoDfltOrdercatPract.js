function Facilitychange()
 {   
	var facilityid = document.forms[0].facility.value; 
    parent.frames[2].document.location.href='../../eOR/jsp/RulestoDfltOrdercatPractForm.jsp?fac_id='+facilityid;      		
 }


function apply()
 { 
	
   cnt =parent.frames[2].document.frames[2].DfltorderCategoryPract.n.value;
   var ordercat="";
   var ordercat1="";
   var practtype="";
   var practtype1="";
   
  for(i=0;i<cnt;i++)
   {   	   
	 ordercat=eval("parent.frames[2].document.frames[2].DfltorderCategoryPract.strKey"+i+".value");
	 practtype=eval("parent.frames[2].document.frames[2].DfltorderCategoryPract.practitionertype"+i+".value");
	 ordercat1=ordercat1+ordercat+"~";
	 practtype1=practtype1+practtype+"~";
   }
  
	  parent.frames[2].document.frames[2].DfltorderCategoryPract.ordercat.value=ordercat1;
	  parent.frames[2].document.frames[2].DfltorderCategoryPract.practtype.value=practtype1; 
	  parent.frames[2].document.frames[2].DfltorderCategoryPract.submit();
  
} 


function onSuccess() 
{  
	 
	frames[2].document.location.reload();
}


function reset()	
{
	parent.content.frames[1].location.reload();
}
