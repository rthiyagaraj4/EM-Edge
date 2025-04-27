 function create()
  {
	f_query_add_mod.location.href = "../../eSM/jsp/AddModifyMenuAdmin.jsp" ;
  }

function query()
  {
	f_query_add_mod.location.href ="../../eSM/jsp/MenuadminQueryCriteria.jsp" ;
  }

function apply()
  {
	 if( f_query_add_mod.document.Menuadmin_Form!=null)
	  {

if(frames[1].document.forms[0].menu_admin_id_desc.value==""){
	frames[1].document.forms[0].menu_admin_id.value="";
}

	  var sel_obj = f_query_add_mod.document.forms[0].menu_admin_id;
      var fields = new Array(f_query_add_mod.document.forms[0].menu_admin_id,f_query_add_mod.document.forms[0].resp_group_id);
      var names = new Array (getLabel("Common.name.label","Common"),getLabel("eSM.ResponsibilityGroup.label","SM"));


	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
	{
		eff_date_from=f_query_add_mod.document.forms[0].eff_date_from;
		eff_date_to=f_query_add_mod.document.forms[0].eff_date_to;
		//alert("submit");
		f_query_add_mod.document.forms[0].action="../../servlet/eSM.MenuadminServlet";
     f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.forms[0].submit();
		
			
	}
  }
  else{

	  frames[0].location.reload();
	  return false;
  }
  }
function onSuccess()
 {
	 
		frames[0].document.location.reload();
		
 }

function reset()
   {
	if(f_query_add_mod.document.forms[0])
	   	f_query_add_mod.document.location.reload();
//	   	f_query_add_mod.document.forms[0].reset() ;
    }

function doDateChecknew(from,to,messageFrame) {
	var fromarray; var toarray;
	var fromdate = from.value ;
	var todate = to.value ;
	if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);	
			if(Date.parse(todt) < Date.parse(fromdt)) {
				alert(getMessage('TO_DT_GR_EQ_FM_DT','SM'));
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
return true;
}


function validate_date(to_date,from_date)
        {
 			if(!doDateCheckAlert(from_date,to_date))
			{
				alert(getMessage('TO_DT_GR_EQ_FM_DT','SM'));
				to_date.select();
			}
         }


		 function validate_date1(from_date,to_date)
			{
				if(to_date.value != '')
				{
				if(!doDateCheckAlert(from_date,to_date))
				{
					alert(getMessage('TO_DT_GR_EQ_FM_DT','SM'));
					to_date.select();
				}
				}
			}

	
