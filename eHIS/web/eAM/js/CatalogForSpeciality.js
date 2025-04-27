function create() {
	var cmf=commontoolbarFrame.document.forms[0];
	if(cmf.apply.disabled==true)
	{
      cmf.apply.disabled=false;
    }
	f_query_add_mod.location.href = "../../eAM/jsp/AddModifyCatalogForSpecialty.jsp" ;
	}

function query() {
	var cmf=commontoolbarFrame.document.forms[0];
	if(cmf.apply.disabled==false)
	{
      cmf.apply.disabled=true;
    }
		f_query_add_mod.location.href ="../../eAM/jsp/CatalogForSpecialtyQueryCriteria.jsp" ;
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

function apply()
{

	if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }
	var fields = new Array(parent.frames[2].document.f_query_add_mod.document.query.document.forms[0].speciality_loc,parent.frames[2].document.f_query_add_mod.document.query.document.forms[0].stat_group1);
	var names = new Array (getLabel("Common.speciality.label","Common"),
							getLabel("Common.OrderCategory.label","Common"));
     var statusval=parent.frames[2].frames[1].frames[0].document.forms[0].statusval.value;
	 
	if(statusval!="")
	{
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
	{
	
	if(parent.frames[2].frames[1].frames[1].document.forms[0].recval.value!=0){
	var n = parent.frames[2].document.f_query_add_mod.document.result.document.forms[1].maxrecord.value;
		var m = parseInt(n)*2;
		var dat = "";
		for(var i=2; i<=m; i=i+2)
		{
			dat+=parent.frames[2].document.f_query_add_mod.document.result.document.stat_grp_nation_detail_result_form.elements[i-2].value+ "|";  
			if(parent.frames[2].document.f_query_add_mod.document.result.document.stat_grp_nation_detail_result_form.elements[i-1].checked ==true)
				dat+='Y'+ '|';
				
			else
				dat+='N' +'|';
			
			dat=dat.substring(0,dat.length-1);
			dat+='~';
	
		}
		dat=dat.substring(0,dat.length-1);
		
		var stat_group =  parent.frames[2].document.f_query_add_mod.document.result.document.forms[0].visit_type_id.value;
		var stat_group1 = parent.frames[2].document.f_query_add_mod.document.result.document.forms[0].order_cat_id.value;
		
	
		parent.frames[2].document.f_query_add_mod.document.result.document.forms[1].insert_to_db.value=dat;
		var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='statgroupdetail' id='statgroupdetail' method='post' action='../../servlet/eAM.CatalogForSpecialtyServlet'><input type='hidden' name='insert_to_db' id='insert_to_db' value='"+dat+"'><input type='hidden' name='stat_group' id='stat_group' value='"+stat_group+"'><input type='hidden' name='stat_group1' id='stat_group1' value='"+stat_group1+"'><input type='hidden' name='locn' id='locn' value=''></form></body></html>";	
		parent.frames[2].document.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		parent.frames[2].document.messageFrame.document.statgroupdetail.submit();
	}else
		{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
		}
	}
	}else
	{
		 //var message="APP-AM0029 Apply is not a valid operation here"; 
		 var message=getMessage("AM0100","AM");
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+message
        return false;
	}
}


function onSuccess() {
	f_query_add_mod.location.reload();
}

function reset()
{
    if(f_query_add_mod.location.href.indexOf("CatalogForSpecialtyQueryResult.jsp")!=-1)
		     return false;
	 else
			f_query_add_mod.location.reload() ;
}

//JS functions used in Criteria jsp

function to_hide()
	{
		document.forms[0].statusval.value="";
		parent.frames[1].location.href='../../eCommon/html/blank.html'
	
	}
	
	function to_visible()
	{
	
	var stat1 = document.forms[0].speciality_loc.value;
//	var stat3 = document.forms[0].lcnsel.value;
	var stat2 = document.forms[0].stat_group1.value;
		        document.forms[0].statusval.value="Y";
				var msg11="";
        parent.parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg11;
		if(stat1 == '')
		{
		var err=getMessage("CAN_NOT_BE_BLANK","Common");
		err= err.replace('$',getLabel("Common.speciality.label","Common"));
		alert(err);
		document.forms[0].speciality_loc.focus();
		return false;
		}
		if(stat2 == '')
		{
		var err=getMessage("CAN_NOT_BE_BLANK","Common");
		err= err.replace('$',getLabel("Common.OrderCategory.label","Common"));
		alert(err);
		document.forms[0].stat_group1.focus();
		return false;
		}
		if(document.forms[0].stat_group1.value != null)
		{
		parent.frames[1].location.href='../../eAM/jsp/CatalogForSpecialtyResult.jsp?dtl_flag=insert&visit_type_id='+stat1+'&order_cat_id='+stat2+'&first_time=1';
		}
		else
		{
		parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=APP-000001 Statistics Group cannot be blank...'
		}
	}
	
	function display_query()
	{
	
		parent.frames[1].location.href='../../eAM/jsp/CatalogForSpecialtyQueryResult.jsp?dtl_flag=query&visit_type_id='+document.forms[0].stat_group.value;
	}
	
	function from_query(visit_type_id,order_cat_id)
	{
	parent.frames[1].location.href='../../eAM/jsp/CatalogForSpecialtyQueryResult.jsp?dtl_flag=insert&visit_type_id='+visit_type_id+'&frmqry='+order_cat_id+'';

	}
	function assignVal1(val)
	{
		parent.frames[1].location.href='../../eCommon/html/blank.html'
		document.forms[0].order_cat_id.value = val;		
	}
	function assignVal5(val)
	{
		parent.frames[1].location.href='../../eCommon/html/blank.html'		
	}

	function assignval2(obj)
	{
		
		document.forms[0].lcnselval.value = obj.value;
	}

function remchk(obj)
{
	var m=obj.value;
	if(obj.checked == false)
	{
	
		if(document.stat_grp_nation_detail_result_form.remmem.value == "R")
		{
		document.stat_grp_nation_detail_result_form.remmem.value=m;
		}
		else
		{
		document.stat_grp_nation_detail_result_form.remmem.value=document.stat_grp_nation_detail_result_form.remmem.value+"|"+m;
		}
		}
		else
			{
			m="";
			}
}

function callMember(alpha)
	{ 
		if(document.forms[0].visit_type_id.value.length !=0)
		{
			document.forms[0].alphabet.value=alpha;
   			document.forms[0].dtl_flag.value='insert';
			document.forms[0].submit();
			
		}
		else{
		parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=APP-000001 Visit cannot be blank...'
		}
	}
	

