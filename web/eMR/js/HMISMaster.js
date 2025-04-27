function create() {
	frames[2].location.href ="../../eCommon/html/blank.html";
	frames[3].location.href ="../../eCommon/html/blank.html";

	frames[1].location.href = "../../eMR/jsp/HMISMastersCreate.jsp" ;
}

function deleterecord() 
{
	 if (! (checkIsValidForProceed1()) )
    {
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }
   
	 if(frames[3].document.forms[0].ward.value!="")
	{
	 if(confirm(frames[3].getMessage('DELETE_RECORD','Common')))
		{
		frames[3].document.forms[0].func.value="delete";
       frames[3].document.forms[0].submit();

		}
	
		else
		{
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num= "
		}
	}
	else
		{
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num= "
		}
	 
}

 function checkIsValidForProceed()
  {
     var url = frames[2].location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
 }
function checkIsValidForProceed1()
  {
     var url = frames[3].location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
 }

function apply() 
{
var tableId="";

if(frames[2].document.forms[0].tableId.value!=null&&frames[2].document.forms[0].tableId.value!="")
	{ 
 tableId=frames[2].document.forms[0].tableId;
	if (!(checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }
	}
 else
  
	{
		
		 tableId=frames[3].document.forms[0].tableId;
	if (!(checkIsValidForProceed1()) )
    {
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }
	
	} 

 

 
   if(tableId.value == "IP_NURS_UNIT_FOR_SPECIALTY")
       {
      var fields = new Array(frames[3].document.forms[0].hospital_code,frames[3].document.forms[0].hmis_code ,frames[3].document.forms[0].disp);
      var names  = new Array (getLabel("eMR.HospitalCode.label","MR"),getLabel("eMR.WardCode.label","MR"),getLabel("eMR.DisciplineCode.label","MR"));
      if(frames[3].checkFields(fields,names,messageFrame))
	     {
		   frames[3].document.forms[0].submit();
         }
 	  }
    else if(tableId.value== "IP_NURSING_UNIT")
	     {
         
            var fields = new Array(frames[3].document.forms[0].hospital_code,frames[3].document.forms[0].hmis_code);
	        var names  = new Array (getLabel("eMR.HospitalCode.label","MR"),getLabel("eMR.WardCode.label","MR"));
	    	if(frames[3].checkFields( fields,names,messageFrame))
	       {
				frames[3].document.forms[0].submit();
	       }
		}
	else if(tableId.value=="OP_CLINIC")
	        {
               var fields = new Array(frames[3].document.forms[0].hospital_code,frames[3].document.forms[0].hmis_code);
		       var names  = new Array (getLabel("eMR.HospitalCode.label","MR"),getLabel("eMR.ExternalMasterCode.label","MR"));
		    	if(frames[3].checkFields(fields,names,messageFrame))
		       {
          			   frames[3].document.forms[0].submit();
		       }

			}
		   else  if(tableId.value=="IP_DISCHARGE_TYPE" )
	        {
               var fields = new Array(frames[3].document.forms[0].hmis_code,frames[3].document.forms[0].indicator);
		        var names  = new Array (getLabel("eMR.ExternalMasterCode.label","MR"),getLabel("Common.dischargetype.label","Common"));
		        if(frames[3].checkFields( fields,names,messageFrame))
		        {
			      frames[3].document.forms[0].submit();
		        }
		  }
		  else  if( tableId.value == "IP_BED_CLASS")
	        {
               var fields = new Array(frames[3].document.forms[0].hmis_code,frames[3].document.forms[0].indicator);
		        var names  = new Array (getLabel("eMR.ExternalMasterCode.label","MR"),getLabel("Common.BedClass.label","Common"));
		        if(frames[3].checkFields( fields,names,messageFrame))
		        {
			      frames[3].document.forms[0].submit();
		        }
		  }else  if(tableId.value == "MP_NOD_TYPE")
	        {
               var fields = new Array(frames[3].document.forms[0].hmis_code,frames[3].document.forms[0].indicator);
		        var names  = new Array (getLabel("eMR.ExternalMasterCode.label","MR"),getLabel("eMP.DeliveryType.label","MP"));
		        if(frames[3].checkFields( fields,names,messageFrame))
		        {
			      frames[3].document.forms[0].submit();
		        }
		  }
		  else  if(tableId.value == "UTL_FILE_DIR")
	        {
              
			  var fields = new Array(frames[2].document.forms[0].Code);
         	  var names  = new Array (getLabel("eMR.FilePath.label","MR"))
		          if(frames[2].checkFields( fields,names,messageFrame))
		            {
			             
						frames[2].document.forms[0].submit();
		            }
		       
		  }
		  else
				{
                   var fields = new Array(frames[3].document.forms[0].hmis_code);
         	       var names  = new Array (getLabel("eMR.ExternalMasterCode.label","MR"));
		            if(frames[3].checkFields( fields,names,messageFrame))
		            {
			            frames[3].document.forms[0].submit();
		            }
				
			   }

    	

}

function reset() 
{
	frames[1].document.forms[0].reset();
	frames[2].location.href ="../../eCommon/html/blank.html";
	frames[3].location.href ="../../eCommon/html/blank.html";
}

function onSuccess()
   {
      frames[3].location.href ="../../eCommon/html/blank.html";
    frames[2].location.reload(); 
      
  }

  //added from HMISMasterCreate.jsp
  function clf()
{
parent.document.frames[2].location.href ="../../eCommon/html/blank.html";
parent.document.frames[3].location.href ="../../eCommon/html/blank.html";
parent.document.frames[4].location.href ="../../eCommon/jsp/error.jsp";
}

function fetchVals1()
{
	var Obj=document.forms[0].hmisid.value;
	var longdesc=document.forms[0].longdesc.value;

	if(Obj != '')
	{
	  	parent.document.frames[2].document.location.href="../../eMR/jsp/HMISMastersResult.jsp?hmisid="+Obj+"&longdesc="+longdesc;
		parent.document.frames[3].document.location.href='../../eCommon/html/blank.html';
	}
	else
	{
		parent.document.frames[2].document.location.href='../../eCommon/html/blank.html';
		parent.document.frames[3].document.location.href='../../eCommon/html/blank.html';
		var  error = getMessage("CAN_NOT_BE_BLANK",'Common');
		error = error.replace("$",getLabel("eMR.Master.label","MR"))
		alert(error);
		document.forms[0].hmisid.focus();
	}
}


// added from HMISMasterResults.jsp


function refresh()
{
parent.document.frames[3].location.href ="../../eCommon/html/blank.html";
}

//added from HMISMasterframes.jsp


	 
function convertUppercase()
{
	alert(event.keyCode>96);
	
	}
	   function checkEn1()
	   {
	       if(hmis_form.indicator.checked)
		   {
				hmis_form.indicator.value="Y";
		   }
		   else
		   {
			    hmis_form.indicator.value="N";
		   }
	   }

	   function checkEn()
	   {
	       if(hmis_form.emer_maternity_yn.checked)
		   {
				hmis_form.emer_maternity_yn.value="Y";
		   }
		   else
		   {
			    hmis_form.emer_maternity_yn.value="N";
		   }
	   }
