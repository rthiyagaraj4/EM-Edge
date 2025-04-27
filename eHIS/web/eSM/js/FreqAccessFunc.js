var check;
function check() {
alert(f_query_add_mod.document.forms[0].name);

}

function show() {

}

function create() {
	
	f_query_add_mod.location.href = "../../eSM/jsp/FreqAccessFuncFrameset.jsp" ;
}

function edit() {

}


function apply()
{	
		var n =self.frames[1].frames[0].document.delete_func.nochbox1.value;
				
		var checkval1="" ;
		var c1=0;
		if (n>0) 
		{
			for(j=0;j<self.frames[1].frames[0].document.delete_func.elements.length;j++)	 // for deleting
			{
					if(self.frames[1].frames[0].document.delete_func.elements(j).type=="checkbox") 
				{
						if(self.frames[1].frames[0].document.delete_func.elements(j).checked) // if checked
						{
							checkval1 += self.frames[1].frames[0].document.delete_func.elements(j).value + "!"; //append the row elements values
							c1++;
						}
				}
			}
			self.frames[1].frames[0].document.delete_func.checkval1.value=checkval1;
		}


		var checkval = "";
		var c2=0;
      
		if(self.frames[1].frames[2].document.include_func != null)	 // for adding
		{
			
			var m =self.frames[1].frames[2].document.include_func.nochbox.value;

			if (m>0)
			{
				
				for(var i=0; i<=m; i++)
				{
					if(self.frames[1].frames[2].document.include_func.elements(i).checked ==true) // if checked
					{
						checkval += self.frames[1].frames[2].document.include_func.elements(i).value + "!";	// append all the row elements value
						c2++;
					}
				}
				
				self.frames[1].frames[0].document.delete_func.checkval.value=checkval;
				
				self.frames[1].frames[0].document.delete_func.operation.value=self.frames[1].frames[2].document.include_func.operation.value;
			}
		}
		

			if (c1>0 || c2>0 )
			{
				
				if( n-c1+c2<11)
					self.frames[1].frames[0].document.delete_func.submit();
				else
				{
					alert(f_query_add_mod.frames[2].getMessage("FREQ_FUNCTION_LIMIT_10","SM"));
					frames[0].location.reload();
					f_query_add_mod.location.href = "../../eSM/jsp/FreqAccessFuncFrameset.jsp" ;
					
				}
			}
			else	       
				messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	        

}
function reset() 
{
	f_query_add_mod.frames[0].document.forms[0].reset();
	f_query_add_mod.frames[1].document.forms[0].reset();
	f_query_add_mod.frames[2].document.location.href = "../../eCommon/html/blank.html";
}

function onSuccess() 
{
	var menu=frames[1].frames[0].document.forms[0].menu.value;
	var menu_id=frames[1].frames[0].document.forms[0].menu_id.value;
	frames[1].frames[0].location.href='../../eSM/jsp/AddModifyFreqAccessFunc.jsp?menu='+menu+'&menu_id='+menu_id;
	frames[1].frames[1].location.href='../../eSM/jsp/FreqAccessSearchCriteria.jsp?menu='+menu+'&menu_id='+menu_id;
	frames[1].frames[2].location.href='../../eCommon/html/blank.html';

}

