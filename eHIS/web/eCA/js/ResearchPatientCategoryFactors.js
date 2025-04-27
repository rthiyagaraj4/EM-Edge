 function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/ResearchPatientCategoryFactorsMaster.jsp?mode=insert';
}

function apply()
{
	if(f_query_add_mod.document.ResearchPatientCategoryFactorsMasterfrm != null)
	{
		var fields = new Array (f_query_add_mod.document.ResearchPatientCategoryFactorsMasterfrm.research_categ_fact_id,f_query_add_mod.document.ResearchPatientCategoryFactorsMasterfrm.research_categ_fact_desc);

		var names = new Array ( getLabel("eCA.ResearchCategoryFactorCode.label",'CA'),getLabel("eCA.ResearchCategoryFactorDescription.label",'CA'));
	
		if(( f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) )
		{
			var total="";
			
			if(f_query_add_mod.document.ResearchPatientCategoryFactorsMasterfrm.Res_Pat_Cate.length!=undefined){			
				var length_= f_query_add_mod.document.ResearchPatientCategoryFactorsMasterfrm.Res_Pat_Cate.length;			
				for(var i=0; i < length_ ; i++)
				{
					if(f_query_add_mod.document.ResearchPatientCategoryFactorsMasterfrm.Res_Pat_Cate[i].checked)
					{	
						if(i==0)						
							total =total +f_query_add_mod.document.ResearchPatientCategoryFactorsMasterfrm.Res_Pat_Cate[i].value;
						else						
							total =total +","+f_query_add_mod.document.ResearchPatientCategoryFactorsMasterfrm.Res_Pat_Cate[i].value;					
					}
				}
			}else{
				if(f_query_add_mod.document.ResearchPatientCategoryFactorsMasterfrm.Res_Pat_Cate.checked)
					total =total +f_query_add_mod.document.ResearchPatientCategoryFactorsMasterfrm.Res_Pat_Cate.value;
			}
				
			if(total=="")
			{
				var errors =getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("eCA.ResearchPatientCategory.label",'CA'))))
				messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors
			}
			else
			{				
				f_query_add_mod.document.ResearchPatientCategoryFactorsMasterfrm.research_categ_fact_select_categ.value=total;
				f_query_add_mod.document.ResearchPatientCategoryFactorsMasterfrm.submit();
			}		
			
		}
	}
	else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}
}


function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/ResearchPatientCategoryFactorsMasterQuery.jsp';
}

function onSuccess()
{
	f_query_add_mod.location.reload();
}

function reset()
{	
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset();
}

 
function assign_desc()
{
	document.forms[0].research_categ_fact_desc1.value = document.forms[0].research_categ_fact_desc.value;
}


function AssignCheck(obj)
{
	if(obj.checked)
		document.ResearchPatientCategoryFactorsMasterfrm.eff_status1.value="E";
	else
		document.ResearchPatientCategoryFactorsMasterfrm.eff_status1.value="D";
}
function CheckSpecChar(event){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}

