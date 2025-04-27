 /*  Developed By Prabhu.M
		 Date -- 06/07/2004
		 Functionality -- OP/Catalog for Visit Type	
*/ 
 
 function create() {

	f_query_add_mod.location.href = "../../eOP/jsp/AddModifyCatalogForVisitType.jsp" ;

}

function query() {
	f_query_add_mod.location.href ="../../eOP/jsp/CatalogForVisitTypeQueryCriteria.jsp" ;
}

function checkIsValidForProceed()
{
	
 var url = parent.frames[1].f_query_add_mod.location.href;
 url = url.toLowerCase();
 if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
  return true;
 else
  return false;
}


function apply()
{

     
	if (! (checkIsValidForProceed()) )
    {
      
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }
	var fields = new Array(parent.frames[1].document.frames[1].document.frames[0].document.forms[0].stat_group,parent.frames[1].document.frames[1].document.frames[0].document.forms[0].stat_group1);
	var names = new Array ( getLabel("Common.visittype.label","Common"),getLabel("Common.OrderCategory.label","Common"));
		
 var statusval=parent.frames[1].frames[1].frames[0].document.forms[0].statusval.value;
	 
	if(statusval!="")
	{

	if(f_query_add_mod.checkFields( fields, names, messageFrame)) 
	{
		if(parent.frames[1].frames[1].frames[1].document.forms[0].recval.value!=0){
	var n = parent.frames[1].document.frames[1].document.frames[1].document.forms[1].maxrecord.value;
		
		var m = parseInt(n)*2;
		var dat = "";
		for(var i=2; i<=m; i=i+2)
		{
			
		dat+=parent.frames[1].document.frames[1].document.frames[1].document.forms[0].elements(i-2).value+ "|";  
			if(parent.frames[1].document.frames[1].document.frames[1].document.forms[0].elements(i-1).checked ==true)
				dat+='Y'+ '|';
				
			else
				dat+='N' +'|';
			
			dat=dat.substring(0,dat.length-1);
			dat+='~';
			
		}
		dat=dat.substring(0,dat.length-1);
		
		var stat_group =  parent.frames[1].document.frames[1].document.frames[1].document.forms[0].visit_type_id.value;
		
		
		var stat_group1 = parent.frames[1].document.frames[1].document.frames[1].document.forms[0].order_cat_id.value;
		
	
		parent.frames[1].document.frames[1].document.frames[1].document.forms[1].insert_to_db.value=dat;
		var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='statgroupdetail' id='statgroupdetail' method='post' action='../../servlet/eOP.ServiceForVisitTypeServlet'><input type='hidden' name='insert_to_db' id='insert_to_db' value='"+dat+"'><input type='hidden' name='stat_group' id='stat_group' value='"+stat_group+"'><input type='hidden' name='stat_group1' id='stat_group1' value='"+stat_group1+"'></form></body></html>";	
		parent.frames[1].document.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[1].document.frames[2].document.statgroupdetail.submit();
		}else
		{
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
		}
	}
	}else{
messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
	}
}


function onSuccess() {
//parent.frames[1].document.frames[1].document.frames[1].location.href='../../eCommon/html/blank.html'
/////////////////Added by Manish Anand on 02-07-2002///////////////
     
	f_query_add_mod.location.reload();

///////////////////////////////////////////////////////////////////

}

function reset()
{
/*parent.frames[1].document.frames[1].document.frames[1].location.href='../../eCommon/html/blank.html';
parent.frames[1].document.frames[1].document.frames[0].document.getElementById("alpha").style.visibility="hidden";
parent.frames[1].document.frames[1].document.frames[0].document.getElementById("alpha1").style.visibility="hidden";
*/
/////////////////Added by Manish Anand on 02-07-2002///////////////
	
	if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }
	if(f_query_add_mod.document.forms[0] || f_query_add_mod.document.frames[0])
		f_query_add_mod.document.location.reload();
///////////////////////////////////////////////////////////////////
}

