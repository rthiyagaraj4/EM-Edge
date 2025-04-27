  //saved on 02.11.2005
var message		= "" ;

function reset() {
//frames[1].location.href="../../ePH/jsp/DrugInfoEnqDtlRepCriteria.jsp";
frames(1).document.formDrugInfoEnqPfCriteria.reset();

}



function validate_date(Obj,ref) {
                

	if (CheckDate(Obj))
	{
	 if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = document.formDrugInfoEnqPfCriteria.p_enq_date_to;
	  to = document.formDrugInfoEnqPfCriteria.p_enq_date_from;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
	 	 
	}
		else if(ref == "TO_DT_GR_EQ_FM_DT1")
	{
	  from = document.formDrugInfoEnqPfCriteria.p_enq_date_from;
	  to = document.formDrugInfoEnqPfCriteria.p_enq_date_to;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
	 	 
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
	  from = parent.frames[1].document.formDrugInfoEnqPfCriteria.p_enq_date_to;
	  to = parent.frames[1].document.formDrugInfoEnqPfCriteria.p_enq_date_from;
	  error_id = getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH');
	}
	
	var fromarray;
	var toarray;
	var fromdate = eval(from).value ;
	var todate = eval(to).value ;
	
	if(fromdate.length > 0 && todate.length > 0 ) {
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if(Date.parse(todt) > Date.parse(fromdt)) {		   
			alert(error_id);
 		    from.focus();
		}
		else if(Date.parse(todt) <= Date.parse(fromdt))
		     {
		       //parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
		       return true;
		      } 
	}
	return true;
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

            if(Date.parse(todt) > Date.parse(fromdt)) 
            {
                var invaldt = getMessage("START_DATE_GREATER_SYSDATE","Common") ;
                alert(invaldt);
                to.select();
                to.focus();
                    
            }
            else if(Date.parse(todt) <= Date.parse(fromdt)) return true;
    }
    return true;
}



function run() {
frames(1).document.formDrugInfoEnqPfCriteria.p_from_date.value=frames(1).document.formDrugInfoEnqPfCriteria.p_enq_date_from.value;
frames(1).document.formDrugInfoEnqPfCriteria.p_to_date.value=frames(1).document.formDrugInfoEnqPfCriteria.p_enq_date_to.value;
	
	var frmObject =frames[1].document.formDrugInfoEnqPfCriteria;
	if(frames[1].document.formDrugInfoEnqPfCriteria) {
		var fields= new Array (frmObject.p_enq_date_from, frmObject.p_enq_date_to);
		var names= new Array (getLabel("ePH.EnquiryDateFrom.label","PH"), getLabel("ePH.EnquiryDateTo.label","PH"));
		if(checkFields(fields,names,messageFrame) ) {
				frames[1].document.formDrugInfoEnqPfCriteria.submit();
		}
	}
}
