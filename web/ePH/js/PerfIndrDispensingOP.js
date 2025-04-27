  var message		= "" ;

function reset() {
frames(1).document.formPhPerfIndrDispensingOPCriteria.reset();
}

function run() {
	frames[1].document.formPhPerfIndrDispensingOPCriteria.p_from_date.value=frames[1].document.formPhPerfIndrDispensingOPCriteria.p_enq_date_from.value;
	frames[1].document.formPhPerfIndrDispensingOPCriteria.p_to_date.value=frames[1].document.formPhPerfIndrDispensingOPCriteria.p_enq_date_to.value;
	var frmObject =frames[1].document.formPhPerfIndrDispensingOPCriteria;
	if(frames[1].document.formPhPerfIndrDispensingOPCriteria) {
		var fields= new Array (frmObject.p_enq_date_from, frmObject.p_enq_date_to);
		var names= new Array ('From Date', 'To Date');
		if(checkFields(fields,names,messageFrame) ) {
			if(DateCheck(frmObject.p_enq_date_from,frmObject.p_enq_date_to)){
				frmObject.submit();
			}
		}
	}
}

function DateCheck(from,to) {
    var fromarray;
    var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
            var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) < Date.parse(fromdt)){		
			alert(getMessage('TO_DT_GR_EQ_FM_DT'));
			return false;
		}
	} 
	return true;
}
