function resetform(){
		var formobj=document.outcomeMeasuresForm ;
		formobj.id.value="";
		formobj.Desc.value="";
		formobj.score.value="";
		formobj.seq_no.value="";
		if(formobj.mode.value==2)
		{
			formobj.id.enabled=false;
			formobj.Delete.disabled=true;
		}

}

function closewindow(){
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();
	;
}

function applymeasure(mode)
{
	var formobj=document.outcomeMeasuresForm ;
	idobj=eval("formobj.id");
	Descobj=eval("formobj.Desc");
	scoreobj=eval("formobj.score");
	seq_noobj=eval("formobj.seq_no");
	//alert(mode);
	if(mode==1 || mode==2){
		//alert(checkField(idobj,"ID"));
		if(checkField(idobj,getLabel("Common.code.label","common"))){
			if(checkField(Descobj,getLabel("Common.description.label","common"))){
				 if (checkField(scoreobj,getLabel("eCP.CutOffScore.label","CP"))){
					 if (checkField(seq_noobj,"Sequence number")){
						 formobj.submit();
					 }
				}
			}
		}
	}else{
			formobj.mode.value=3;
			formobj.submit();
	}
	

}

function reloadmeasure(msg,outcome_code){
	alert(msg);
	parent.f_query_header.location.href="../../eCP/jsp/OutcomeMeasuresHeader.jsp?mode=1&outcome_code="+outcome_code;
	parent.f_query_detail.location.href="../../eCP/jsp/OutcomeMeasuresDetail.jsp?mode=1&outcome_code="+outcome_code;

}

function changeCursor(obj) {
	obj.style.cursor = "hand" ;
}

function loaddetails(outcome_code,id,desc,score,seqno){
	parent.f_query_detail.location.href="../../eCP/jsp/OutcomeMeasuresDetail.jsp?mode=2&outcome_code="+outcome_code+"&id="+id+"&desc="+desc+"&score="+score+"&seqno="+seqno;
}

function CheckNumber(obj,lowest,highest) {
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
        value=obj.value;
		low=parseInt(lowest);
		high=parseInt(highest);
		if(value<low || value>high){
			message  =getMessage("RANGE_1_TO_100","CP");
			alert(message);
			obj.value="";
			 obj.select();
             obj.focus();
             return false;
		}
    }
    else {
        if ( obj.value.length > 0 ) {
            alert(getMessage("NUM_ALLOWED","CP"));
            obj.select();
            obj.focus();
            return false;
        }
    }
}
