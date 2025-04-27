function create() {
	
    f_query_add_mod.location.href = "../../eOP/jsp/resourceTypeVisitType.jsp" ;
}

function edit() {
    formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	
    f_query_add_mod.location.href ="../../eOP/jsp/QueryResourceTypeForVisitType.jsp";
}

function checkIsValidForProceed()
{
 var url = f_query_add_mod.location.href;
 url = url.toLowerCase();
 if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
  return true;
 else
  return false;
}
function apply() {

	if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }
	if(f_query_add_mod.document.ResourceType_form.function_na.value=="Insert") {
	 
	 var value=f_query_add_mod.document.ResourceType_form.Gifstatus.value;
	 

//commented for resource scheduling changes 
/*
	 if(value=="E")
	{
	 
	 var fields = new Array ( f_query_add_mod.document.ResourceType_form.indicator,
				  f_query_add_mod.document.ResourceType_form.visittype,
				  f_query_add_mod.document.ResourceType_form.resourceclass,
		          f_query_add_mod.document.ResourceType_form.resourcetype
		         );

	 var names  = new Array ( "Indicator",
		                     "Visit Type",
				            "Resource Class",
							"Resource Type"
							 );
	}
	else
	{
	*/	
      var fields = new Array ( f_query_add_mod.document.ResourceType_form.indicator,
				  f_query_add_mod.document.ResourceType_form.visittype,
				  f_query_add_mod.document.ResourceType_form.resourceclass
		          );

	 var names  = new Array ( getLabel("eOP.VisitTypeIndicator.label","Op"),
		                     getLabel("Common.visittype.label","Common"),
				            getLabel("Common.resourceclass.label","Common")
						 );
	//}

if(f_query_add_mod.checkFields( fields, names, messageFrame)) 
			 f_query_add_mod.document.ResourceType_form.submit();


}
else if(f_query_add_mod.document.ResourceType_form.function_na.value=="Modify")
	{
      var fields = new Array ( f_query_add_mod.document.ResourceType_form.indicator,
				  f_query_add_mod.document.ResourceType_form.visit_type,
				  f_query_add_mod.document.ResourceType_form.r_class
			
		          );

	 var names  = new Array ( getLabel("eOP.VisitTypeIndicator.label","Op"),
		                     getLabel("Common.visittype.label","Common"),
				            getLabel("Common.resourceclass.label","Common")
						
						 );

if(f_query_add_mod.checkFields( fields, names, messageFrame)) 
       f_query_add_mod.document.ResourceType_form.submit();
	}

if(f_query_add_mod.document.ResourceType_form.function_na.value=="Delete")
	 f_query_add_mod.document.ResourceType_form.submit();
}


function onSuccess() 
{
 	if(f_query_add_mod.document.ResourceType_form.function_na.value=='Insert')
	{
		f_query_add_mod.location.reload() ;
	}
	else if(f_query_add_mod.document.ResourceType_form.function_na.value=='Delete')
            f_query_add_mod.location.href ="../../eCommon/html/blank.html";
   
}

function reset() {
	
		if(f_query_add_mod.location.href.indexOf("QueryResourceTypeResult.jsp")!=-1)
		     return false;
	 else
			f_query_add_mod.location.reload();

	}

function deleterecord()
{

	if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }
	var source= f_query_add_mod.document.ResourceType_form.sparams.value;
	
	if(f_query_add_mod.document.ResourceType_form.function_na.value !='Insert' )
	{
		
		if(confirm(frames[1].getMessage('DELETE_RECORD','COMMON')))
		{
       f_query_add_mod.document.ResourceType_form.function_na.value = 'Delete';
		f_query_add_mod.document.ResourceType_form.submit();
    	}else
         messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
		//f_query_add_mod.location.reload() ;
	    //self.frames[0].location.href=source;
		//    parent.frames[0].location.href=source;
		  
		  //parent.location.reload();
		  //parent.frames[1].f_query_add_mod.location.reload();
		  //  self.location.href="../../eOP/jsp/AddModifyResTypeforVisitType.jsp?source="+source+"";
	      //  self.location.reload();
	}
	else
	{
		self.location.href="../../eOP/jsp/AddModifyResTypeforVisitType.jsp?source="+source+"&func_name=Delete";
    }
}

//JS functions used in Main jsp

  function fetchVals(form,current)
		   {
          	  func=document.forms[0].function_na.value;
	          var value=current.value;
			  var name=current.name;
			  var visittype="";
			  if(func=="Insert")
			   {
				  if(name=="resourceclass")
			        removeitems(form.resourcetype);
				if(name=="indicator")
				     removeitems(form.visittype);
			   }
      
              var fid=document.forms[0].facility_id.value;
			  var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey();'>";
			  HTMLVal +="<form name='form1' id='form1' method='post' action='../../eOP/jsp/ResourceTypeFetchVal.jsp'>";
			  HTMLVal+="<input name='facility_id' id='facility_id' type='hidden' value='"+fid+"'>";
			  HTMLVal+= "<input name='visit_type_ind' id='visit_type_ind' type='hidden' value='"+name+"'><input name='value' id='value' type='hidden' value='"+value+ "'>";		
			  HTMLVal +="<input name='function' id='function' type='hidden' value='"+func+"'>";	
			  HTMLVal +="</form></BODY></HTML>";
			  parent.messageFrame.document.write(HTMLVal);
			  parent.messageFrame.document.form1.submit();
       
		  }
	/*
	  This function is used to remove the items occured 
	  more than once in a List Box.
	*/	  function removeitems(obj)
		   {
			var len=obj.length;
			var i=1;
			while(i<len)
			{
				len=obj.length
				obj.remove(i)
			}
       	}	

