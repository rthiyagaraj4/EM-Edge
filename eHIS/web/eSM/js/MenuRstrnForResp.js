function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }

function apply()
{

	/*if (! (checkIsValidForProceed()) )
    {
        
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		
        return false;
    } */
	var fields = new Array(frames[1].frames[0].document.forms[0].resp_id);
	var names = new Array (	getLabel("Common.responsibility.label","Common"));

	if( frames[1].frames[0].checkFieldsofMst( fields, names, messageFrame))
	{
				
	// Removing Frame
		var file_name = frames[1].frames[1].location.href;
	
		var ind = file_name.indexOf('?')
		framecount1=0
		framecount2=0
		var s
		if(ind == -1)	ind = file_name.length
		file_name = file_name.substring((file_name.lastIndexOf('/')),ind)
		if(file_name!='/blank.html')		//if frame1 has valid data start buiding html text 
		{
				
			var resp_id=frames[1].frames[0].document.forms[0].resp_id.value;	
			
		//	s="<html><body class='message'><form name='final' id='final' method='post' action= '../../servlet/eSM.MenuRstrnForRespServlet'>";
		//	s+="<input type=hidden name=resp_id value='"+resp_id+"'>";
	s="<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script></head><body class='message' onKeyDown = 'lockKey()'><form name='final' id='final' method='post' action='../../servlet/eSM.MenuRstrnForRespServlet'>";
			s+="<input type=hidden name=resp_id value='"+resp_id+"'>";

			framecount1++;
				
	    }
		else											
		{
			
			s="";
		}


		// Adding Frame
		var file_name1 = frames[1].frames[3].location.href;

		
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
			
				s="<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script></head><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body class=message onKeyDown = 'lockKey()'><form name='final' id='final' method='post' action='../servlet/eSM.MenuRstrnForRespServlet'>";
			}
			framecount2++;
				
		 }

		if(framecount1>0)
		{
			
			var frm1=frames[1].frames[1].document.forms[0];// frame2
		
			for(i=0;i<frm1.elements.length;i++)
			{
				
				if(frm1.elements[i].type == "checkbox")
				{
					if(frm1.elements[i].checked) 
					s+="<input type='hidden' name='"+frm1.elements[i].name+"' id='"+frm1.elements[i].name+"' value='"+frm1.elements[i].value+"'>"
				}
				else
					s+="<input type='hidden' name='"+frm1.elements[i].name+"' id='"+frm1.elements[i].name+"' value='"+frm1.elements[i].value+"'>"
			}
		}

		if(framecount2>0)
		{
				
			var frm2=frames[1].frames[3].document.forms[0];// frame2
			for(i=0;i<frm2.elements.length;i++)
			{
				if(frm2.elements[i].type == "checkbox")
				{
					if(frm2.elements[i].checked)
						s+="<input type='hidden' name='"+frm2.elements[i].name+"' id='"+frm2.elements[i].name+"' value='"+frm2.elements[i].value+"'>"
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
			
			messageFrame.document.write(s);
			messageFrame.document.forms[0].submit()
		}
		
	}
}
 
 function create()
  {
	  frames[2].location.href='../../eCommon/jsp/error.jsp';
	f_query_add_mod.location.href = "../../eSM/jsp/MenuRstrnForRespMain.jsp" ;
  }

function reset()
   {
	   frames[1].location.reload();
    }

function onSuccess()
{
	var resp_id=frames[1].frames[0].document.forms[0].resp_id.value;
	
			var menu_id=frames[1].frames[0].document.forms[0].menu_id.value;
	
			var menu_name=frames[1].frames[0].document.getElementById("menu_name").innerText;
		
	
			frames[1].frames[0].location.href='../../eSM/jsp/RespMenuRstrnForResp.jsp?';
			frames[1].frames[0].document.forms[0].resp_id.value=resp_id;

	
			frames[1].frames[1].location.href='../../eSM/jsp/RemoveMenuRstrnForResp.jsp?';
	
			frames[1].frames[2].location.href='../../eSM/jsp/QueryMenuRstrnForResp.jsp?';
			frames[1].frames[3].location.href='../../eCommon/html/blank.html';
}

