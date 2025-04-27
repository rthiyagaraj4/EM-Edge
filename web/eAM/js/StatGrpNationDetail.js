 function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/AddModifyStatGrpNationDetail.jsp" ;
}

function query() {	
	f_query_add_mod.location.href ="../../eAM/jsp/StatGrpNationDetailQueryCriteria.jsp" ;
}

function checkIsValidForProceed(){
	var url = f_query_add_mod.location.href;
    url = url.toLowerCase();
    if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
}

function apply(){
	
	if (! (checkIsValidForProceed())){
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}
	else{
		//alert(f_query_add_mod.query.document.statgrpdtlquery.category);
		
		var fields = new Array(f_query_add_mod.query.document.statgrpdtlquery.category,f_query_add_mod.query.document.statgrpdtlquery.stat_group);
		var names  = new Array ( parent.frames[0].getLabel("Common.category1.label","Common") ,
							 parent.frames[0].getLabel("Common.StatisticsGroup.label","Common"));
		var statusval=parent.frames[2].frames[1].frames[0].document.forms[0].statusval.value;
		if(statusval!="")
		{
			
			if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
			{
	    var n = parent.frames[2].document.f_query_add_mod.document.result.document.getElementById('maxrecord').value;

		
		
		var j=1;
		var m = parseInt(n)*2;
		var dat = "";
		for(var i=2; i<=m; i=i+2){ 
			var incm=eval("parent.frames[2].document.f_query_add_mod.document.result.document.forms[0].inc"+[n-j]);
			var code=eval("parent.frames[2].document.f_query_add_mod.document.result.document.forms[0].code"+[n-j]);
			dat+=code.value+'|';
			if(incm.checked)
				dat+='Y'+ '|';
			else
				dat+='N' +'|';			
			dat=dat.substring(0,dat.length-1);
			dat+='~';
		j++;
		}
		dat=dat.substring(0,dat.length-1);
		var stat_group=parent.frames[2].document.f_query_add_mod.document.query.document.getElementById('stat_grp_id').value;
		parent.frames[2].document.f_query_add_mod.document.result.document.getElementById('insert_to_db').value=dat;
		var HTMLVal = "<html><head><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='statgroupdetail' id='statgroupdetail' method='post' action='../../servlet/eAM.StatGrpNationDetailServlet' target='messageFrame'><input type='hidden' name='insert_to_db' id='insert_to_db' value='"+dat+"'><input type='hidden' name='stat_group' id='stat_group' value='"+stat_group+"'></form></body></html>";	
		parent.frames[2].document.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		var ret=checkforapply();
			if(ret=="true")
					parent.frames[2].document.messageFrame.document.statgroupdetail.submit();
			 else
			{
				 var message=getMessage('NO_CHANGE_TO_SAVE','common');
				 messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+message
				 return false;
			}
				   
		}
		else{
			
			
			 var message=getMessage("AM0100","AM");
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+message
			return false;

		}
		}else
		{
			
		 //	var message="";
		 //var message="APP-AM0029 Apply is not a valid operation here"; 
		// var message=getMessage("AM0100","AM");
		 if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
			  {
			 
			
				var message=getMessage("AM0100","AM");
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+message
			return false;
		  }
		  else
			  {
			  
			  var message=getMessage("AM0100","AM");
			 messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+message
		   return false;
		  
		 }

			}		
	}
}


function onSuccess() {
		
		parent.frames[2].frames[1].frames[0].document.forms[0].reset()
		parent.frames[2].frames[1].frames[0].document.getElementById('alpha').style.visibility="hidden";
		//parent.frames[2].frames[1].location.href='../../eCommon/html/blank.html'
       // parent.frames[2].frames[2].frames[1].document.forms[0].reset()
		//parent.frames[2].frames[1].frames[1].document.location.href='../../eCommon/html/blank.html';
		//parent.frames[2].frames[1].frames[1].document.stat_grp_nation_detail_result_form.stat_grp_nation_detail_result_form1.reset();
        //parent.frames[2].frames[1].location.href =parent.frames[1].frames[1].location;
		//parent.frames[2].frames[1].frames[1].document.forms[0].category_desc= ''
		//parent.frames[2].frames[1].frames[1].document.forms[0].stat_group= ''
		  
		parent.frames[2].frames[1].frames[1].location.href='../../eCommon/html/blank.html'

}


function reset(){
	if(f_query_add_mod.document.forms[0])
		{
		f_query_add_mod.document.location.reload();
		//f_query_add_mod.document.forms[0].reset() ;
	}else{
		f_query_add_mod.document.location.reload();
	}
}


function checkforapply()
{
	var change_insert="";
	var noOfRecords = parent.frames[2].document.f_query_add_mod.document.result.document.getElementById('maxrecord').value;
    var frmObj= parent.frames[2].document.f_query_add_mod.document.result.document.forms[0];
	for(i=0;i<noOfRecords;i++)
	{
		var prev_select=eval("frmObj.prev_select"+i).value;			
		if(eval("frmObj.inc"+i).checked==true)
		{			
			curr_val = "CHECKED";
			if(curr_val !=prev_select)
				change_insert="true";
		}
		else
		{
			curr_val = "";
			if(curr_val !=prev_select)
					change_insert="true";
		}
	}
		return change_insert;
}

