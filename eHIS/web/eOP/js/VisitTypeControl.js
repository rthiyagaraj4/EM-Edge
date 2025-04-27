
function create() 
{
    f_query_add_mod.location.href = "../../eOP/jsp/addModifyOPVisitTypeCtrl.jsp" ;
}

     function onSuccess()
   {
  f_query_add_mod.location.reload();
    }
     function apply()
         {
   	  	  		  
          if (! (checkIsValidForProceed()))
         {
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
          }

		  var fields=new       Array(f_query_add_mod.document.forms[0].clinic_desc,f_query_add_mod.document.forms[0].service,f_query_add_mod.document.forms[0].no_ofvisit_allow,f_query_add_mod.document.forms[0].foll_visit_dura);
	      var names= new Array(getLabel("Common.clinic.label","common"),getLabel("Common.service.label","common"),getLabel("eOP.NoofFollowUpVisitAllowed.label","OP"),	getLabel("eOP.FollowUpVisitDuratin.label","OP"));
       
		  if(f_query_add_mod.checkFields( fields,names,messageFrame))
	     {
			 
		   f_query_add_mod.document.forms[0].submit();
		  
			  }
       }
      
		
	
	function query() {
		
    f_query_add_mod.location.href ="../../eOP/jsp/OpVisitTypeCntrlCriteria.jsp";

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
	
	
     function reset()
	 {
	
      if(f_query_add_mod.document.location.href.indexOf("OpVisitTypeCntrlCriteria.jsp") != -1)
		  return false;
	    else if(f_query_add_mod.document.location.href.indexOf("OpVisitTypeCntrlResult.jsp") != -1)
		        return false;
		 else
		  f_query_add_mod.document.location.reload();
      }
	
	function onBlurgetCli(fac_id ,target)
      {
		if(target.value == "")
		{
			target.value="";
			document.forms[0].clinic_code.value="";
			return;
		}

     getClinic(fac_id,target);

     }
       

async function getClinic(fac_id,target)
{
    
	removeitems(document.forms[0].service);
	
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit="";	
	var sql;
  
    	tit=getLabel('Common.clinic.label','Common');
     
    	sql ="select clinic_code code ,long_desc description from op_clinic where facility_id = '"+fac_id+"' and clinic_type='C' and eff_status = 'E' and upper(clinic_code) like upper(?) and  upper(long_desc) like upper(?) order by long_desc";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;	
	
	retVal = await CommonLookup( tit, argumentArray );
	
	if(retVal != null && retVal != " " )
	{
		var ret1=unescape(retVal);
	 	arr=ret1.split(",");
	 	if(arr[1]==undefined) arr[1]="";	
		 	target.value=arr[1];					
					
		document.forms[0].clinic_code.value=arr[0];					
	
		var v=document.forms[0].clinic_code.value;
		aa(v);		  
			  
	}
  }
function aa(v){
	var HTMLVal = new String();
	var u=v;
	var flag="visit_type";
	HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><BODY class='message' onKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eOP/jsp/getservice.jsp'>	<input type='hidden' name='flag' id='flag' value='"+flag+"'><input type='hidden' name='locn_code' id='locn_code' value='"+u+"'></form></BODY></HTML>";
	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.messageFrame.document.form1.submit();

}
 
	
function checkIsValidForProceed()
{
 var url = f_query_add_mod.location.href;
 url = url.toLowerCase();
 if ( (url.indexOf("blank.html")==-1) && (url.indexOf("cntrl")==-1))
  return true;
 else
  return false;
}
