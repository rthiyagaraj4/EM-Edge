	
	function create() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		f_query_add_mod.location.href="../../eDS/jsp/DietTypeAddModify.jsp?"+params+"&mode=insert";
	}
	
	function apply() {
		var frm=f_query_add_mod.document.forms[0];
		
		document.getElementsByName("longDesc").readOnly=false;
		document.getElementsByName("shortDesc").readOnly=false;
		document.getElementsByName("dietType").readOnly="readonly";
		//content.document.getElementById("OrderCatalogcode").readOnly="readonly";
		document.getElementsByName("lookUp").disabled="disabled";

		document.getElementsByName("orderCatalogDescription").disabled="disabled";
		//content.document.getElementById("vo.dsFeedType.feedType").disabled=true;
		document.getElementsByName("dietCategory").disabled=true;
		document.getElementsByName("enable").disabled=false;
		document.getElementsByName("opdiettype_yn").disabled=false;  //ML-MMOH-CRF-0418
		document.getElementsByName("emdiettype_yn").disabled=false;  //ML-MMOH-CRF-0418
		var fields = new Array (f_query_add_mod.document.forms[0].dietType,f_query_add_mod.document.forms[0].longDesc,f_query_add_mod.document.forms[0].shortDesc,f_query_add_mod.document.forms[0].ageGroup,f_query_add_mod.document.forms[0].orderCatalogDescription,f_query_add_mod.document.forms[0].dietCategory);
		var diet_type=getLabel("eOT.DietType.Label","ot");
		var long_description=getLabel("eOT.LongDescription.Label","ot");
		var short_description=getLabel("eOT.ShortDescription.Label","ot");
		var age_group = getLabel("eOT.AgeGroup.Label","ot");
		var order_catalog = getLabel("eOT.OrderCatalogcode.Label","ot");
		var diet_category = getLabel("eOT.DietCategory.Label","ot");
		var names = new Array ( diet_type,long_description,short_description,age_group,order_catalog,diet_category);
		if(checkFieldsofMst( fields, names, messageFrame)) 
			{	
				f_query_add_mod.document.forms[0].submit();
			}
		}
	
	
	
	function query() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		commontoolbarFrame.document.forms[0].apply.disabled=true;
		f_query_add_mod.location.href="../../eDS/jsp/DietTypeQueryCriteria.jsp?"+params;
	}	
 	 
	 function reset(){
		 if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("DietTypeAddModify.jsp") != -1){

			 if(f_query_add_mod.document.location.href.indexOf("DietTypeMain.jsp") != -1)
				  return false;
			 else
				 f_query_add_mod.document.location.reload();
		 }
		 else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("DietTypeQueryCriteria.jsp") != -1)
		 {
			 f_query_add_mod.document.forms[0].reset();
		 }
	}
		
	function setFieldToUpperCase(obj) {
		obj.value = obj.value.toUpperCase();
		return obj;
	}
	
	function checkAlpha(event){
		var strCheck = '~!@#$%^&*()+=`{}|[]<>"\'';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  
		if (strCheck.indexOf(key) != -1) return false;  
		return true ;
	}
	
	async function getLookup(obj){
		var locale = document.forms[0].locale.value;
		var result		=	false ;
		var message		=	"" ;
		var flag		=	"" ;
		var function_id = "";
		var argumentArray  = new Array();
		var dataNameArray  = new Array();
		var dataValueArray = new Array();
		var dataTypeArray  = new Array();

		//var sql="select instr_code,short_desc from ot_instrument WHERE upper(short_desc) like upper(?) and upper(instr_code) like upper(?) order by 2";
		//var sql="select A.short_desc,A.order_catalog_code from Or_Order_Catalog_Lang_Vw A where A.order_category = 'DS' and language_id = '"+locale+"' and contr_mod_id is  null and contr_msr_panel_id is null and UPPER(short_desc) like UPPER(?) and UPPER(order_catalog_code) like UPPER(?)  and eff_status = 'E' order by 2";
		//var sql= "SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE and upper(A.SHORT_DESC) like upper(?) and upper(A.SPECIALITY_CODE) like upper(?) order by 2";
		var sql= "SELECT A.SHORT_DESC DESCRIPTION,A.order_catalog_code CODE FROM OR_ORDER_CATALOG_LANG_VW A  WHERE A.order_category = 'DS' and A.LANGUAGE_ID='"+locale+"' and  A.contr_mod_id is  null and A.contr_msr_panel_id is null and upper(A.SHORT_DESC) like upper(?) and upper(A.order_catalog_code) like upper(?) and eff_status='E' order by 2";

		argumentArray[0] = sql;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;

		returnedValues = await CommonLookup(getLabel("Common.OrdercatalogCode.label","Common"), argumentArray );
		if((returnedValues != null) && (returnedValues != "") )  {
			var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
		document.diet_form.orderCatalogDescription.value = arr[0];
		//document.forms[0].SPECIALITY_CODE.value = localTrimString(returnedValues[0]);	
		}
	else
		{nationality_code.value = arr[0]; 
			nationality_desc.value = arr[1]; 
			desc.value=arr[1];
			code.value=arr[0];
		document.diet_form.orderCatalogDescription.value = '';
		//document.forms[0].SPECIALITY_CODE.value ='';		
			//obj.value = returnedValues[1];
		} 


	}
	
	function onSuccess()
	{
		var formObj = document.forms[0];
		var params = formObj.params.value;
		if(f_query_add_mod.document.forms[0].mode.value=="insert")
			f_query_add_mod.location.href="../../eDS/jsp/DietTypeAddModify.jsp?"+params+"&mode=insert";
		else
	         f_query_add_mod.location.reload();

	}
