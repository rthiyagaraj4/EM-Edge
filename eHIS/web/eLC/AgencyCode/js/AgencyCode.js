
	/***********************************************************
	/*                  AgencyCode.JS
	/***********************************************************/

	function create() {
	content.location.href=contextPath+"/AgencyCodeAction.do?method="+loadMethod+"&vo.functionId="+functionId
	}
	
	function apply() {
		if(checkNullLocal())
			content.AgencyCodeForm.submit(); 
	}
	
	function query() {
		content.location.href=contextPath+"/AgencyCodeAction.do?method="+queryMethod+"&vo.functionId="+functionId
	}

	function deleterecord() {
		var flag=checkNull();
		content.AgencyCodeForm.method.value=deleteMethod
		if(flag==true)
		{
		content.AgencyCodeForm.submit();
		}
	}
	
	function loadResult(agencyCode){
	content.location.href=contextPath+"/AgencyCodeAction.do?vo.agencyCode="+agencyCode+"&method="+loadMethod+"&vo.functionId="+functionId
	}
	
	function addCriteria()
	{
		var criteria;
		criteria=content.QueryCriteriaForm.vo.orderBySelected.itemValue;
	 }
	 function reset()
	 {
	  if(content.AgencyCodeForm.method.value==updateMethod)
	  {
	  var agencyCode=content.document.getElementById("vo.agencyCode").value;
	  loadResult(agencyCode)
	  }
	  else 
	  {
		content.location.href=contextPath+"/AgencyCodeAction.do?method="+loadMethod+"&vo.functionId="+functionId
	   }	
	 }
	 
	function checkNullLocal()
	 { 
		var flag;
		var fieldName=new Array("com.iba.ehis.lc.agencyCode.agencyCode","com.iba.ehis.lc.agencyCode.name");
		var field=new Array(content.document.getElementById("vo.agencyCode"),content.document.getElementById("vo.agencyName"));
		flag=checkNullDS(fieldName,field);
		if(flag==false) return false; else return true;
	 }
	 

	 