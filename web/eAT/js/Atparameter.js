function create()
{
	alert("inside create");
	f_query_add_mod.location.href='../../eAT/jsp/ATParameter.jsp?mode=insert';
}
function apply()
{
	alert("inside apply");
	var frm=f_query_add_mod.document.forms[0];
	var fields = new Array (frm.preanaesthesia_noteType,frm.intraanaesthesia_noteType,frm.postanaesthesia_noteType,frm.discrete_measureCode);
		
	var names = new Array ("PREANESNOTETYPE","INTRAANESNOTETYPE","POSTANESNOTETYPE","DISCRMSRID");
	alert(f_query_add_mod.checkFields(fields,names,messageFrame));
	
		
	if(f_query_add_mod.checkFields(fields,names,messageFrame)) 
			{	
					
				alert("else");
					frm.target='f_query_add_mod';
				alert("before submit");
				frm.submit();
			
			}
				
			
	
	}
	
	
	


