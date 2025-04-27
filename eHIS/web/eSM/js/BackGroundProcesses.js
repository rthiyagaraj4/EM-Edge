function reset()
   {

	     f_query_add_mod.frames[2].document.forms[0].reset();
		 messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
		 
	}

function onSuccess()
{
	
	self.frames[1].frames[0].location.href='../../eSM/jsp/BackGroundProcessQuery.jsp';
	self.frames[1].frames[2].location.href='../../eSM/jsp/BackGroundProcessAddModify.jsp';
}
