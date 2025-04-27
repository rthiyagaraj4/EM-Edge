function callSearch(){

	var TermCode	= document.forms[0].TermCode.value;
	if(TermCode==""){
		var error = getMessage('CAN_NOT_BE_BLANK','COMMON');
		error = error.replace('$',getLabel('Common.primary.label','Common')+" "+getLabel('Common.TerminologyCode.label','Common'));
		alert(error);
	}else{
		parent.frames[2].location.href = '../../eMR/jsp/DescriptionSearchResult.jsp?TermCode='+TermCode;
	}
}

  function reset(){
	frames[1].location.reload();
	frames[2].location.href = '../../eCommon/html/blank.html';
	frames[3].location.href = '../../eCommon/jsp/error.jsp'
  }

  function onSuccess()
{

	frames[2].location.href = "../../eCommon/html/blank.html";
	frames[1].location.reload();
}



  function apply()
  {
	
	var url2 = frames[2].location.href;
	
	var msg = "";
	
	
	if(frames[2].document.TermDescResultForm)
	  {
		
		if((frames[2].document.TermDescResultForm.description1.value=="")&&
		  (frames[2].document.TermDescResultForm.description2.value=="")&&
		  (frames[2].document.TermDescResultForm.description3.value=="")&&
		  (frames[2].document.TermDescResultForm.description4.value=="")&&
		  (frames[2].document.TermDescResultForm.description5.value=="")&&
		  (frames[2].document.TermDescResultForm.description6.value=="")&&
		  (frames[2].document.TermDescResultForm.description7.value=="")&&
		  (frames[2].document.TermDescResultForm.description8.value=="")&&
		  (frames[2].document.TermDescResultForm.description9.value=="")&&
		  (frames[2].document.TermDescResultForm.description10.value==""))
		  {
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			msg = getMessage("SEL_DESC_MANDATORY",'MR');
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			msg = "";

		  }

		 else
		  {
		
		frames[2].document.TermDescResultForm.action="../../servlet/eMR.TermCodeOtherDescServlet";
		frames[2].document.TermDescResultForm.target = "messageFrame";
		frames[2].document.TermDescResultForm.submit();
		onSuccess();
		  }

	  }

	  else
	{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		if  ( ( url2.indexOf("blank.html")!= -1 ))
		{
			msg = getMessage("APPLY_NOT_VALID",'MR');
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			msg = "";

		}
	}


  }
