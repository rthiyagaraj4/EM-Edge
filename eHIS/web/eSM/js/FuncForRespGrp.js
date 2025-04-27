function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) ){
	 return true;
	 }
    else{
	return false;
	}
  }

function apply()
{
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	var fields = new Array(frames[1].frames[0].document.forms[0].resp_group_id);
	var names = new Array (	getLabel("eSM.ResponsibilityGroup.label","SM"));

	if( frames[1].frames[0].checkFieldsofMst( fields, names, messageFrame))
	{
		// Removing Frame
		var file_name = frames[1].frames[2].location.href;
		var ind = file_name.indexOf('?')
		framecount1=0
		framecount2=0
		checkcount=0
		var s
		if(ind == -1)	ind = file_name.length
		file_name = file_name.substring((file_name.lastIndexOf('/')),ind)
		if(file_name!='/blank.html')		//if frame1 has valid data start buiding html text 
		{
			var resp_group_id=frames[1].frames[0].document.forms[0].resp_group_id.value;
			
			s="<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script></head><body class='message' onKeyDown = 'lockKey()'><form name='final' id='final' method='post' action= '../../servlet/eSM.FuncForRespGrpServlet'><input type=hidden name=resp_group_id value='"+resp_group_id+"'>";
			framecount1++;
	    }
		else											
		{
			s="";
		}

// Adding Frame
		
		var file_name1 = frames[1].frames[5].location.href;
		var ind1 = file_name1.indexOf('?')
		if(ind1 == -1)	ind1 = file_name1.length
		file_name1 = file_name1.substring((file_name1.lastIndexOf('/')),ind1)
		if(file_name1!='/blank.html')
		{
		if(framecount1!=0)		// if frame1 ds not have data start building html text here
		{
		}
		else
		{
			s="<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script></head><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body class=message onKeyDown = 'lockKey()'><form name='final' id='final' method='post' action='../../servlet/eSM.FuncForRespGrpServlet'>";
		}
		framecount2++;
		 
		}

		if(framecount1>0)
		{
			var frm1=frames[1].frames[2].document.forms[0];// frame2
			for(i=0;i<frm1.elements.length;i++)
			{
				if(frm1.elements[i].type == "checkbox")
				{
					if(frm1.elements[i].checked) 
					{
						s+="<input type='hidden' name='"+frm1.elements[i].name+"' id='"+frm1.elements[i].name+"' value='"+frm1.elements[i].value+"'>"
						checkcount++;				
					}
				}
				else
					s+="<input type='hidden' name='"+frm1.elements[i].name+"' id='"+frm1.elements[i].name+"' value='"+frm1.elements[i].value+"'>"
			}
		}

		if(framecount2>0)
		{
			var frm2=frames[1].frames[5].document.forms[0];// frame2
			for(i=0;i<frm2.elements.length;i++)
			{
				if(frm2.elements[i].type == "checkbox")
				{
					if(frm2.elements[i].checked)
					{
						s+="<input type='hidden' name='"+frm2.elements[i].name+"' id='"+frm2.elements[i].name+"' value='"+frm2.elements[i].value+"'>"
						checkcount++;
					}
				}
				else
					s+="<input type='hidden' name='"+frm2.elements[i].name+"' id='"+frm2.elements[i].name+"' value='"+frm2.elements[i].value+"'>"
			}
		}

		if(framecount1 >0 || framecount2 >0)
		{
			s+="<input type='hidden' name='framecount1' id='framecount1' value='"+framecount1+"'>"
			s+="<input type='hidden' name='framecount2' id='framecount2' value='"+framecount2+"'>"
			s+="</form>";
			s+="</body>";
			s+="</html>";
			errors="";
			if(checkCount(checkcount))
			{
				messageFrame.document.write(s);
				messageFrame.document.forms[0].submit()
			}
			else
				messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
		}
	}
}
 
 function checkCount(val)
 {
	 var error_id;
	 if(checkcount>0)
	 {
		return true;
	 }
	 else{
			error_id=frames[1].frames[3].getMessage("ATLEAST_ONE_SELECTED","SM");
			
			return false;
		 }
 }
 
 function create()
  {
	
	f_query_add_mod.location.href = "../../eSM/jsp/AddModifyFuncForRespGrp.jsp" ;
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp" ;
  }

function query()
  {
  }

  function chkformfields(obj)	//returns true if atleast one of the form fields are present
{
	var j=0;
	for (var k=0; k<obj.elements.length;k++ )
	{
		if ( obj.elements(k).type=='checkbox')
		{
			if( obj.elements(k).checked )
			{
				j++
			}
		}
	}
	
	if (j>0)	return true;
	else		return false;
}

function onSuccess()
 {
frames(1).location.reload();
 }

function reset()
   {
	   frames[1].location.reload();
    }



