
function apply(){
	if(CARoleBasedAccessRightsforTaskListFrame.document.getElementById("facility_id").value!=undefined && CARoleBasedAccessRightsforTaskListFrame.document.getElementById("facility_id").value!="" && CARoleBasedAccessRightsforTaskListFrame.document.getElementById("facility_id").value!=null){
		CARoleBasedAccessRightsforTaskListFrame.document.roleBasedTaskList.submit();
	}
	else
	{
	alert("Facility Cannot be Blank");
	document.location.reload();
	 return false;
	}
	
} 
function reset()
{
	document.location.reload();
	}
function selectfacility(obj)
 {	
	 parent.CARoleBasedAccessRightsforTaskListFrame.document.location.href= "../../eCA/jsp/CARoleBasedAccessRightsforTaskList.jsp?facility="+obj.value+"&function=insert";
 }
 function selectedList(obj,obj1,obj2,obj3)
 {
var check="Y";
var check1=true;

var facility=document.getElementById("facility_id").value;

		 if(obj=="1"){
			 if(obj1.checked==false){
				 check="N"	 
					 check1=false
			 }
		 document.getElementById("checkSepci"+obj2).value=check;
	 	document.getElementById("checkSepci"+obj2).checked=check1;
			 }else if(obj=="2"){
				 if(obj1.checked==false){
					 check="N"	 
						 check1=false
				 }
	 	document.getElementById("checkRegister"+obj2).value=check;
		document.getElementById("checkRegister"+obj2).checked=check1;
	  }else if(obj=="3"){
		  if(obj1.checked==false){
				 check="N"	 
					 check1=false
			 }
	 	document.getElementById("checkresult"+obj2).value=check;
	 	document.getElementById("checkresult"+obj2).checked=check1;
	  }else if(obj=="4"){
		  if(obj1.checked==false){
				 check="N"	 
					 check1=false
			 }
	 	document.getElementById("checkmed"+obj2).value=check;
	 	document.getElementById("checkmed"+obj2).checked=check1;
	  }else if(obj=="5"){
		  if(obj1.checked==false){
				 check="N"	 
					 check1=false
			 }
	 	document.getElementById("checkinterv"+obj2).value=check;;
	 	document.getElementById("checkinterv"+obj2).checked=check1;
	  }else if(obj=="6"){
		  if(obj1.checked==false){
				 check="N"	 
					 check1=false
			 }
	 	document.getElementById("checkblood"+obj2).value=check;
	 	document.getElementById("checkblood"+obj2).checked=check1;
	  }else if(obj=="7"){
		  if(obj1.checked==false){
				 check="N"	 
					 check1=false
			 }
	 	document.getElementById("checkpendcon"+obj2).value=check;
	 	document.getElementById("checkpendcon"+obj2).checked=check1;
	  }else if(obj=="8"){
		  if(obj1.checked==false){
				 check="N"	 
					 check1=false
			 }
	 	document.getElementById("checkvitals"+obj2).value=check;
	 	document.getElementById("checkvitals"+obj2).checked=check1;
	  }
var xmlHttp = new XMLHttpRequest();
xmlStr ="<root><SEARCH " ;	
xmlStr +=" /></root>" ;
var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
xmlHttp.open( "POST", "../../eCA/jsp/CARoleBasedAccessRightsIntermediate.jsp?chkYN="+check+"&index="+obj+"&pract_id="+obj3+"&inner_index="+obj+"&facility="+facility+"&function=MAP_VALUES", false ) ;
xmlHttp.send( xmlDoc ) ;
responseText=trimString(xmlHttp.responseText);
	document.getElementById("TaskMap").value=responseText;
 }
 function selectCategory(obj,obj1)
 {
	 document.getElementById("category"+obj1).value=obj.value;
	 
 }
