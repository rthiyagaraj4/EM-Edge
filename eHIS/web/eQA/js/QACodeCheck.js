function codeCheck(Obj){
var u=Obj;
if(u==' '){
parent.f_query_add_mod.location.href='../../eCommon/html/blank.html';
}
if(u=="QA_QIND_GROUP"){
	parent.f_query_add_mod.location.href ="../../eQA/jsp/repIndicatorGroup.jsp";
}
if(u=="QA_QIND_CLIND"){
	parent.f_query_add_mod.location.href ="../../eQA/jsp/repIndicator.jsp";
}
if(u=="QA_QIND_CLIND_DIAG_PROC"){
	parent.f_query_add_mod.location.href ="../../eQA/jsp/repDiagnosisProceduresForIndicator.jsp";
} 
if(u=="QA_QIND_DISCIPLINE"){
	parent.f_query_add_mod.location.href ="../../eQA/jsp/repDiscipline.jsp";
}
if(u=="QA_QIND_DISCIPLINE_CLIND"){
	parent.f_query_add_mod.location.href ="../../eQA/jsp/repIndicatorsForDiscipline.jsp";
}
if(u=="QA_QIND_FACILITY_CLIND"){
	parent.f_query_add_mod.location.href ="../../eQA/jsp/repIndicatorsForFacility.jsp";
}
if(u=="QA_QIND_CLIND_COMPL"){
	parent.f_query_add_mod.location.href ="../../eQA/jsp/repComplicationsForIndicator.jsp";
}

}



