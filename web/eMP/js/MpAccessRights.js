function apply() {

	if(mp_access_frame.document.MpAccessRightsForm.searchresp) {
		if(mp_access_frame.document.MpAccessRightsForm.searchresp.value=="") { 	
			dtls_url = mp_access_details.document.location.href;
			if(dtls_url.indexOf("blank.html")!=-1) {
				errors = getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("Common.responsibility.label","common_labels"))));
				messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;	
			} else {
			 mp_access_details.document.MpAccessRightsDetailsForm.action="../../servlet/eMP.MpAccessRightsServlet";
			 mp_access_details.document.MpAccessRightsDetailsForm.submit();
			}  
		} else { 		
			mp_access_details.document.MpAccessRightsDetailsForm.action="../../servlet/eMP.MpAccessRightsServlet";
			mp_access_details.document.MpAccessRightsDetailsForm.submit();
		}  		
	}
}


function reset()
{
	
    //parent.frames[1].location.href = '../../eMP/jsp/MP_AccessRights.jsp?module_id=MP&function_id=ACCESSRIGTHS&function_name=Access Rights&function_type=F&access=NYNNN';
	frames[1].location.reload();
	frames[2].location.href="../../eCommon/html/blank.html";
}

function onSuccess()
{
	mp_access_frame.location.href ="../../eMP/jsp/mpaccessrightsform.jsp" ;
    mp_access_details.document.location.reload();



}
function submitPrevNext(from, to)
{
            document.forms[0].from.value = from;
            document.forms[0].to.value = to; 
            document.forms[0].target = "mp_access_frame"
            document.forms[0].submit();
}



//added by cc

/*
	function CheckMaxLen1(lab,obj,max,messageFrame) {
		if(obj.value.length > max) {
			messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=APP-SM0045 - " + lab + " cannot exceed " + max  + " characters" ;
			return false;
		} else return true;
}
*/

function mandatoryChk()
{
 	 var fields = new Array ( document.forms[0].searchresp);
	 var names  = new Array ( getLabel("Common.responsibility.label","common_labels"));
	 if(checkFieldsofMst( fields, names, parent.frames[3])) {
	 parent.frames[3].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='
	 return true;
	 }
	 else
	 return false;
 
}
function displayDetails()
{
clearValues()
if (mandatoryChk())
	{
  
var searchcriteria = parent.frames[1].document.forms[0].search_criteria.value;
var searchresp = escape(parent.frames[1].document.forms[0].searchresp.value);
parent.frames[2].location.href="../../eMP/jsp/MpAccessRightsDetailsForm.jsp?searchresp="+searchresp+"&searchcriteria="+searchcriteria+"&flagSelect=fromSelect";
	}
}


function clearValues()
{
parent.frames[2].location.href="../../eCommon/html/blank.html";

}
function blockevent(event){
       
	 var whichCode = (window.Event) ? event.which : event.keyCode;
    if (whichCode=='13')
	return false ;
}

 function chkValue(obj)
   {
      if(obj.checked==true)
       {
			obj.value='Y';
	   }
      else
      {
		   obj.value='N';
		   			
       }
   } 

