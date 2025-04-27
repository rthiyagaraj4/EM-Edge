function callResult()
{   var flag =checkNull();
	 if(flag==true){ 
	var clinic=parent.frames[0].document.forms[0].blocation.value;
	var location1=parent.frames[0].document.forms[0].locationType.value;
	var care_locn=location1.substring(1,2);
	location1=location1.split("|");
	var care_locn1=location1[0];
	var resource=parent.frames[0].document.forms[0].resource.value;
	clinic = clinic.substring(2,clinic.length)
	var practitioner=parent.frames[0].document.forms[0].practitioner.value;
	var date=parent.frames[0].document.forms[0].date.value;
	if(parent.frames[0].document.forms[0].select)
	parent.frames[0].document.forms[0].select.disabled=false;

	var date_greg=convertDate(date,"DMY",localeName,"en");
	
	parent.parent.frames[2].location.href="../../eCommon/jsp/error.jsp";

	var url="";
	url="../../eOA/jsp/SinglePractVw.jsp?clinic_code="+clinic+"&clinic_type="+care_locn1+"&res_type="+resource+"&practitioner_id="+practitioner+"&Date="+date_greg+"&decide=Query&FromApptForPractQry=YES";
	parent.frames[1].document.location.href=url;

}
}

function checkNull(){
 	var flag;
  	var error="";
  	var dt =parent.frames[0].document.forms[0].date.value;
  	var dt_label=getLabel("Common.date.label","Common");
  	var location=document.QueryLocnForDay.b_loc_val.value;
	var practitioner=parent.frames[0].document.forms[0].practitioner.value;
  	if(dt=="") {
  		flag=false;
  		error+= getMessage("SHOULD_NOT_BE_BLANK","Common").replace("{1}",dt_label)+"<br>";
  	}
  	if(location=="" && practitioner=="" ) {
  		flag=false;
		// Fixed Against CRF - JD-CRF-0184 [IN:041354] By Saanthaakumar 
		if(parent.frames[1]){
		parent.frames[1].location.href='../../eCommon/html/blank.html';} //end here
  		error+= getMessage("LOCATION_RESOURCE_SHOULD_NOT_BE_BLANK","Common")+"<br>";
  	}
  	parent.parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp?err_num='+error;
 	if(flag==false) return false; else return true;
  } 

function clearAll()
{
   parent.frames[0].document.forms[0].select.disabled=false;

   parent.frames[1].document.location.href="../../eCommon/html/blank.html "
}

function reset()
{

   frames[1].frames[0].document.forms[0].select.disabled=false;

 //frames[1].frames[0].document.forms[0].reset();

 frames[1].frames[0].document.location.reload();

 frames[1].frames[1].document.location.href="../../eCommon/html/blank.html "
}

function query()
{
}

function locationPopulate(obj){
	/*var locationType= obj;
	var locnValue1=locationType.options(locationType.options.selectedIndex).value;
	
	locnValue1=locnValue1.split("|");
	var locnValue=locnValue1[0];
	var care_locn1=locnValue1[1];
	if (obj.value!=''){
	var HTMLVal="<html><body onKeyDown = 'lockKey()'><form name='locationManForm' id='locationManForm' method='post' action='../../eOA/jsp/ServerSideValidation.jsp'><input type=hidden name='from' id='from' value='QryApptforPractCriteria'><input type=hidden name='LBoxValue' id='LBoxValue' value='"+locnValue+"'></form></body></html>"
	parent.parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.parent.messageFrame.document.locationManForm.submit();
	}
	else{
	 obj1=document.forms[0].blocation;
	 var len =obj1.options.length;
	  while (len-- >= 0) obj1.remove(obj1.options[0]);
	 opt=document.createElement('OPTION');
	 opt.value='';
	 opt.text="-----------------------"+getLabel("Common.defaultSelect.label","Common")+"-----------------------";
	 obj1.add(opt);
	}*/
	if(obj.value!=""){
	document.getElementById('b_loc_val').value="";
	document.getElementById('blocation').value="";
	document.getElementById('b_loc_val').disabled=false;
	document.getElementById('b_loc_search').disabled=false;
	}else{
	document.getElementById('b_loc_val').value="";
	document.getElementById('blocation').value="";
	document.getElementById('b_loc_val').disabled=true;
	document.getElementById('b_loc_search').disabled=true;
	}
}


		function chgbuttonclr()
		{

			//document.getElementById('select').style.background="navy" ;
			//document.getElementById('select').style.color="white" ;
			//document.getElementById('select').style.fontWeight="700" ;
			//document.getElementById('select').style.borderStyle="solid" ;

			//document.getElementById('clear').style.background="navy" ;
			//document.getElementById('clear').style.color="white" ;
			//document.getElementById('clear').style.fontWeight="700" ;
			//document.getElementById('clear').style.borderStyle="solid" ;
			document.getElementById('b_loc_val').value="";
			document.getElementById('b_loc_val').disabled="true" ;
			document.getElementById('b_loc_search').disabled="true" ;


		}
        function ena_pract()
		{ 
			
		   thisObj=document.forms[0].resource;
		//document.forms[0].practitioner_name.value=''; // Against CRF - JD-CRF-0184 [IN:041354] By Saanthaakumar 
		document.getElementById('resourceType1').value=document.getElementById('resource').value;
	
		 if (thisObj.value!="")
			{
			// Against CRF - JD-CRF-0184 [IN:041354] By Saanthaakumar
			document.forms[0].practitioner.value='';		
			document.forms[0].practitioner_name.value=''; // End here
			document.getElementById('search_pract').disabled = false;
			document.getElementById('practitioner_name').disabled=false;
			
				}
		 else
	      {
			 // Against CRF - JD-CRF-0184 [IN:041354] By Saanthaakumar
			 document.forms[0].practitioner.value='';
			 document.forms[0].practitioner_name.value=''; // End here
			 document.getElementById('search_pract').disabled = true;
			 document.getElementById('practitioner_name').disabled = true;
			 
		  }
		   if (thisObj.value=="B")
			{

			document.getElementById('search_pract').disabled = true;
			document.getElementById('practitioner_name').disabled=true;
			
				}
		//document.forms[0].date.value=''; //Commented by S.Sathish for IN020571 on Thursday, April 08, 2010
		// Against CRF - JD-CRF-0184 [IN:041354] By Saanthaakumar 
		
		//document.forms[0].practitioner.value='';
		//document.forms[0].practitioner_name.value='';
		/*Added by S.Sathish for IN020571 on Thursday, April 08, 2010 starts  here*/
		parent.frames[1].location.href='../../eCommon/html/blank.html';
		 if(parent.frames[0].document.forms[0].select.disabled==true)
				parent.frames[0].document.forms[0].select.disabled=false;
		 /*Ends Here*/
}
	  function frameClear(){ 
	  // Fixed Against CRF - JD-CRF-0184 [IN:041354] By Saanthaakumar 
	  if(parent.frames[0].document.forms[0].date.value=="")
	  {
		  parent.frames[1].location.href='../../eCommon/html/blank.html';} //End here
		
		if(parent.frames[0].document.forms[0].select.disabled==true)
				parent.frames[0].document.forms[0].select.disabled=false;

	  }





function onChangeEvents(){
	 //obj=event.target;
	 //objValue=document.forms[0].blocation.value;
	 
	 //document.getElementById('practitioner_name').value=""; // Against CRF - JD-CRF-0184 [IN:041354] By Saanthaakumar 
	// document.getElementById('practitioner').value = ""; // Against CRF - JD-CRF-0184 [IN:041354] By Saanthaakumar 
	 document.getElementById('location_code1').value= document.forms[0].blocation.value;
	 	 //var check = objValue.substring(0,1);
	 
	// Against CRF - JD-CRF-0184 [IN:041354] By Saanthaakumar 
	/* if (objValue!="")
	{
		document.getElementById('imgpract').style.visibility ='visible';
	}
	else{
		document.getElementById('imgpract').style.visibility='hidden';
	} */
	//End here
	
	/* if (document.forms[0].resource.disabled==false){
	   document.forms[0].resource.selectedIndex=0; // Against CRF - JD-CRF-0184 [IN:041354] By Saanthaakumar 
	    ena_pract();

	   
	} */
// Commented Against CRF - JD-CRF-0184 [IN:041354] By Saanthaakumar 
	/* if (obj.value!='')
	document.forms[0].resource.disabled=false;
	else
	document.forms[0].resource.disabled=true; */
	// End here.
	
}
/* function checkResource(obj)
	{

//var chk='';
var vlschk="";
//vlschk=document.forms[0].identityCheckIn.value;
var si=document.forms[0].blocation.value;
var locn=document.forms[0].locationType.value;
locn=locn.split("|");
var locn1=locn[0];

if(locn1=='D')
{
	var res=document.forms[0].resource;
	 while (res.options.length>0) res.remove(res.options[0]);
	 opt=document.createElement('OPTION');
	 opt.value='';
	 opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	 res.add(opt);
	 opt=document.createElement('OPTION');
	   opt.value='P';
	   opt.text=getLabel("Common.practitioner.label","Common");
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='E';
	   opt.text=getLabel("Common.equipment.label","Common");
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='R';
	   opt.text=getLabel("Common.room.label","Common");
	   res.add(opt);
		 opt=document.createElement('OPTION');
	   opt.value='O';
	   opt.text=getLabel("Common.other.label","Common");
	   res.add(opt);
	   document.forms[0].resource.disabled=false;
}else{ 
	   var res=document.forms[0].resource;
	   	   document.forms[0].resource.disabled=false;

	   while(res.options.length>0) res.remove(res.options[0]);
	   opt=document.createElement('OPTION');
	   opt.value='';
	   opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='P';
	   opt.text=getLabel("Common.practitioner.label","Common");
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='E';
	   opt.text=getLabel("Common.equipment.label","Common");
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='R';
	   opt.text=getLabel("Common.room.label","Common");
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='O';
	   opt.text=getLabel("Common.other.label","Common");
	   res.add(opt);
   }

 return obj;
if (si==""){
// chk='';
 document.forms[0].resource.disabled = true;
 }
else{
 //chk=vlschk.substr(si,1);
 document.forms[0].resource.disabled= false;
}
} */
function onChangeLocType(){ 
	 obj=document.forms[0].b_loc_val;
	//document.forms[0].resource.value='';
	//document.forms[0].resource.disabled=true; // Against CRF - JD-CRF-0184 [IN:041354] By Saanthaakumar
	//document.forms[0].practitioner_name.value='';
	//document.forms[0].practitioner.value='';
	//document.forms[0].practitioner_name.disabled=true;
	//document.forms[0].search_pract.disabled=true;
	 if (obj.value!=''){
	 obj.value="";
	 }
	 if (document.getElementById('imgpract').style.visibility=='visible') document.getElementById('imgpract').style.visibility='hidden';
	 var locn=document.forms[0].locationType.value;
	locn=locn.split("|");
	var locn1=locn[0];

	 if (document.forms[0].resource.disabled==false){
		// document.forms[0].resource.selectedIndex=0;
		 //document.forms[0].resource.disabled=true;    // Against CRF - JD-CRF-0184 [IN:041354] By Saanthaakumar
		 //document.forms[0].practitioner_name.value="";

		 //ena_pract();
	 }
/*Added by S.Sathish for IN020571 on Thursday, April 08, 2010 starts  here*/
	 parent.frames[1].location.href='../../eCommon/html/blank.html';
		 if(parent.frames[0].document.forms[0].select.disabled==true)
				parent.frames[0].document.forms[0].select.disabled=false;
 /*Ends Here*/

}
	
	
	/*function DateCheck(from,to) 
		{
			
			if(to.value !='')
			{
				if (ChkDate(to) == false) 
				{
					var err = getMessage('INVALID_DATE_FMT','SM');
					alert(err);
					to.select();
					to.focus();
					return false;
				}
				else 
				{
					
					var fromarray; var toarray;
					var fromdate = from;
					var todate = to.value ;
					if(fromdate.length > 0 && todate.length > 0 ) 
					{
						fromarray = fromdate.split("/");
						toarray = todate.split("/");
						var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
						var todt = new Date(toarray[2],toarray[1],toarray[0]);	
						if(Date.parse(todt) < Date.parse(fromdt)) 
						{
							var err = getMessage('PREF_FM_DT_VALIDATION','OA');
							alert(err);
							to.select();
							to.focus();
							return false;
						}
						else if(Date.parse(todt) >= Date.parse(fromdt))
						{
							parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp";
							return true;
						}
					}
					parent.parent.frames[2].location.href = "../../eCommon/jsp/error.jsp";
					return true;
				}
			}
		}
*/


function ValidateDate(sys,to)
	{
		if(to.value!="")
		{
		if(!validDateObj(to,"DMY",localeName))
		{
			to.value="";
			return ;
		}
		else{
		
		if(sys.value!="" && to.value!="" )
		{
			if(isBefore(sys,to.value,'DMY',localeName)==false)
				{
				alert(getMessage("PREF_FM_DT_VALIDATION","OA"));
				to.value="";
				to.select();	
				return false;
			}
			else
				return true;
		}
		}
}
	}

async function open_loc_lookup(){
	var location1=document.forms[0].locationType.value;
	var location_val=document.forms[0].b_loc_val.value;
	location1 = location1.split("|");
	locn_type=location1[0];
	var care_locn_ind=location1[0];
	//var dialogTop = "60" ;
	//var dialogHeight= "37" ;
	//var dialogWidth	= "60" ;
	var dialogHeight= "400px" ;
	var dialogTop = "10px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments	= "" ;
	var tit="locn_Srch";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&function_id=QRY_APPT_DOCT",arguments,features);
	if(retVal!=null){
		var rvalues=retVal.split("~");
		var code=rvalues[0];
		var desc=rvalues[1];
		var open_all_pract_yn=rvalues[2];
		document.forms[0].b_loc_val.value=desc;
		document.forms[0].blocation.value=open_all_pract_yn+"$"+code;
		onChangeEvents();
		//checkResource(document.forms[0].blocation)
	}else{
		document.forms[0].b_loc_val.value="";
		document.forms[0].blocation.value="";
		onChangeEvents();
		//checkResource(document.forms[0].blocation)
	}

}


function ena_loc_lookup(obj){

		if(obj.value==null || obj.value==''){
		document.forms[0].blocation.value="";
		onChangeEvents();
		//checkResource(document.forms[0].blocation) // Against CRF - JD-CRF-0184 [IN:041354] By Saanthaakumar
		//document.getElementById('res').disabled=true; // Against CRF - JD-CRF-0184 [IN:041354] By Saanthaakumar
	}else{
	open_loc_lookup()
	}
}

