function searchGrade(target)
{
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0] = "select grade_code code, grade_desc description  from rs_grade where eff_status = 'E' and upper(grade_code) like upper(?) and upper(grade_desc) like upper(?)order by grade_desc ";

	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC

	retVal = RSCommonLookup("Grade", argumentArray );
	if(retVal != null && retVal != "" )  {
	target.value = retVal[1] ;
	}
}

