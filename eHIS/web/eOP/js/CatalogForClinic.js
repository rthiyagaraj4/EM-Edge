 /*  Developed By Prabhu.M
		 Date -- 06/07/2004
		 Functionality -- OP/Catalog for Clinic	
*/ 

 var frame_ref;
 var f_query_add_mod1;
 var frame_ref1;
 var messageFrame1;

 function create() {

	f_query_add_mod.location.href = "../../eOP/jsp/AddModifyCatalogForClinic.jsp" ;
	}

function query() {
	
	f_query_add_mod.location.href ="../../eOP/jsp/CatalogForClinicQueryCriteria.jsp" ;
	
}

function checkIsValidForProceed()
{
 var url = eval(f_query_add_mod1).location.href;
 url = url.toLowerCase();
 
 if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
  return true;
 else
  return false;
}

function onBlurgetLoc(fac_id,objval,target)
{

		
		if(target.value == "")
		{
			target.value="";
			document.forms[0].stat_group.value="";
			parent.frames[1].location.href="../../eCommon/html/blank.html";

			return;
		}

 getLocn(fac_id,objval,target);

}

async function getLocn(fac_id,objval,target)
{
	

   var retVal =    new String();
   var argumentArray  = new Array() ;
   var dataNameArray  = new Array() ;
   var dataValueArray = new Array() ;
   var dataTypeArray  = new Array() ;
   var tit="";	
   var index=document.forms[0].lcnsel.options.selectedIndex;
	var care_ind;
	  if(index != 0)
		  care_ind=careArray[index];
	   else
		   care_ind="";
   
	   
   tit=getLabel('Common.Location.label','Common');

   sql ="Select clinic_code code, long_desc description from op_clinic where Facility_ID = '"+fac_id+"' and CARE_LOCN_TYPE_IND='"+care_ind+"' and rd_appl_yn = 'N'  and eff_status='E' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) order by 2";	
	
   

  				
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;				
				retVal = await CommonLookup( tit, argumentArray );			
				
				
				if(retVal != null && retVal != "" )
                {

	             var ret1=unescape(retVal);
					arr=ret1.split(",");
					target.value=arr[1];					
				document.forms[0].stat_group.value=arr[0];

          }
}
function apply(flag)
{
	if(flag=='Y')
	{
		frame_ref='parent.parent.frames[1].frames[0]';
		f_query_add_mod1='parent.parent.parent.frames[2].frames[1]';
		frame_ref1='parent.parent.parent.frames[2].frames[1].frames[1]';
		messageFrame1='parent.parent.parent.frames[2].frames[2]';
		
	}
	else
	{
		frame_ref='frames[1].frames[0]';		
		f_query_add_mod1='parent.frames[2].frames[1]';
		frame_ref1='parent.frames[2].frames[1].frames[1]';
		messageFrame1='parent.frames[2].frames[2]';
		
		//messageFrame1='window.frames[2]';
	}	

	if (! (checkIsValidForProceed()) )
    {
        eval(messageFrame1).location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
    }
	
	var fields = new Array(eval(frame_ref).document.forms[0].stat_group,eval(frame_ref).document.forms[0].lcnsel,eval(frame_ref).document.forms[0].stat_group1);
	var names = new Array ( getLabel('Common.Location.label','Common'),getLabel("Common.locationtype.label",'Common'),getLabel("Common.OrderCategory.label",'Common'));

     var statusval=eval(frame_ref).document.forms[0].statusval.value;	
		
	if(eval(f_query_add_mod1).checkFields( fields, names, eval(messageFrame1))) 
	{
	if(statusval!='')
	{
	if(eval(frame_ref1).document.forms[0].recval.value!=0){
	var n = eval(frame_ref1).document.forms[1].maxrecord.value;
		var m = parseInt(n)*2;
		var dat = "";
		for(var i=2; i<=m; i=i+2)
		{
			dat+=eval(frame_ref1).document.forms[0].elements[i-2].value+ "|";  			
			if(eval(frame_ref1).document.forms[0].elements[i-1].checked ==true)
				dat+='Y'+ '|';
				
			else
				dat+='N' +'|';
			
			dat=dat.substring(0,dat.length-1);
			dat+='~';
	
		}
		dat=dat.substring(0,dat.length-1);
		
		var stat_group =  eval(frame_ref1).document.forms[0].visit_type_id.value;
		var locn = eval(frame_ref).document.forms[0].lcnselval.value;
		var stat_group1 = eval(frame_ref1).document.forms[0].order_cat_id.value;		
		eval(frame_ref1).document.forms[1].insert_to_db.value=dat;	

		var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='statgroupdetail' id='statgroupdetail' method='post' action='../../servlet/eOP.CatalogForClinicServlet'><input type='hidden' name='insert_to_db' id='insert_to_db' value='"+dat+"'><input type='hidden' name='stat_group' id='stat_group' value='"+stat_group+"'><input type='hidden' name='stat_group1' id='stat_group1' value='"+stat_group1+"'><input type='hidden' name='locn' id='locn' value='"+locn+"'></form></body></html>";	
		//top.content.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
		//top.content.frames[2].document.statgroupdetail.submit();
		eval(messageFrame1).document.write(HTMLVal);
		eval(messageFrame1).document.statgroupdetail.submit();
		if(flag!='Y')
		{
		eval(f_query_add_mod1).location.reload();
		}

	}else
		{
		eval(messageFrame1).location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
		}
	}
	}else
	{
		//messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=&err_value=0';
        return false;
	}
}


function onSuccess() {
	//f_query_add_mod.location.reload();
	alert(getMessage('RECORD_INSERTED','SM'));
}

function reset()
{
    if(f_query_add_mod.location.href.indexOf("CatalogForClinicQueryResult.jsp")!=-1)
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
	
	var stat1 = document.forms[0].stat_group.value;
	var stat3 = document.forms[0].lcnsel.value;
	var stat2 = document.forms[0].stat_group1.value;
      document.forms[0].statusval.value="Y";
		if(stat3 == '')
		{
		var err=getMessage("CAN_NOT_BE_BLANK","COMMON");
		err= err.replace('$',getLabel('Common.locationtype.label','Common'));
		alert(err);
		parent.frames[1].location.href='../../eCommon/html/blank.html';
		document.forms[0].lcnsel.focus();
		return false;
		}
		if(stat1 == '')
		{
		var err=getMessage("CAN_NOT_BE_BLANK","COMMON");
		err= err.replace('$',getLabel('Common.Location.label','Common'));
		alert(err);
		parent.frames[1].location.href='../../eCommon/html/blank.html';
		document.forms[0].stat_group2.focus();
		return false;
		}		
		if(stat2 == '')
		{
		var err=getMessage("CAN_NOT_BE_BLANK","COMMON");
		err= err.replace('$',getLabel('Common.OrderCategory.label','Common'));
		alert(err);
		parent.frames[1].location.href='../../eCommon/html/blank.html';
		document.forms[0].stat_group1.focus();
		return false;
		}
		if( document.forms[0].stat_group.value != null && document.forms[0].stat_group1.value != null)
		{
		parent.frames[1].location.href='../../eOP/jsp/CatalogForClinicResult.jsp?dtl_flag=insert&visit_type_id='+stat1+'&order_cat_id='+stat2+'&first_time=1&frmSrch=S';
		}
		else
		{
		 var err=getMessage("CAN_NOT_BE_BLANK","COMMON");
		 err= err.replace("$",getLabel('Common.StatisticsGroup.label','Common'));
		parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err;
		}
	}
	
	function display_query()
	{
	
		parent.frames[1].location.href='../../eOP/jsp/CatalogForClinicResult.jsp?dtl_flag=query&visit_type_id='+document.forms[0].stat_group.value;
	}
	
	function from_query(visit_type_id,order_cat_id)
	{
	parent.frames[1].location.href='../../eOP/jsp/CatalogForClinicResult.jsp?dtl_flag=insert&visit_type_id='+visit_type_id+'&frmqry='+order_cat_id+'';

	}
	function assignVal(val)
	{
		document.forms[0].visit_type_id.value = val;
		
	}
	function assignVal1(val)
	
	{
		
				parent.frames[1].location.href="../../eCommon/html/blank.html";
		

		document.forms[0].order_cat_id.value = val;
		
	}
	function assignval2(obj)
	{
		
		
	parent.frames[1].location.href="../../eCommon/html/blank.html";
		
	document.forms[0].lcnselval.value = obj.value;
		
	document.forms[0].stat_group2.value="";

		
	}
	/*function popctype(obj)
	{
		
		var selclaim ="" ;
		if( obj.value == "C")
		{
			selclaim="C";
		}
		else if( obj.value == "E")
		{
			selclaim="E";
		}
		else
		{
			selclaim="D";
		}
		HTMLVal = "<html><body onKeyDown='lockKey();'><form name='dum_form' id='dum_form' method='post' action='../../eOP/jsp/PopulateLocnforCatalogValues.jsp'><input type='hidden' name='selclaim' id='selclaim' value='"+selclaim+"'></form></body></html>";
		
		parent.parent.messageFrame.document.write(HTMLVal);	
		parent.parent.messageFrame.document.dum_form.submit();
	}*/

//JS functions used in result jsp

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
		// Code added for 22370
		if(confirm(getMessage('WANT_TO_SAVE','common')))
		{
			apply('Y');
		}
	
		if(document.forms[0].visit_type_id.value.length !=0)
		{
			
			document.forms[0].alphabet.value=alpha;
		    document.forms[0].dtl_flag.value='insert';
			document.forms[0].submit();
			
		}
		else{
		var err=getMessage("CAN_NOT_BE_BLANK","COMMON");
		err= err.replace("$",getLabel('Common.Visit.label','Common'));
		parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err;
		}
	}
	

