function query() {
       	f_query_add_mod.location.href ="../../eSM/jsp/queryReportForm.jsp?function=Report";
}


function apply() {	

var count=0;
if(f_query_add_mod.document.query_report_table!=null){
	 var i;
  var maxRec=f_query_add_mod.document.forms.query_report_table.maxrecord.value;
	       for( i=1;i<=maxRec-1;i++)
	{	eval("f_query_add_mod.document.forms[0].Facility_Based_Yn"+i).disabled=false;
		  
	}
		 f_query_add_mod.document.query_report_table.submit();
}else{
   frames[0].location.reload();
   return null;
}

	}


function reset() {
	   if(f_query_add_mod.document.forms[0] )
			f_query_add_mod.document.location.reload();
}

function onSuccess() {
      	f_query_add_mod.location.reload();

}
function showWindow(mod_id,rep_id)
		{
			var module=mod_id;
			var report=rep_id;
			var dialogTop   = "175";
			var dialogLeft= "250"
        var dialogHeight    = "400px" ;
        var dialogWidth = "700px" ;
        var arguments   = "" ;
        var features    = "dialogHeight:" + dialogHeight + "; dialogLeft:"+dialogLeft+ ";dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
		var url="../../eSM/jsp/ReportModify.jsp?Module_ID="+module+"&Report_ID="+report;
window.showModalDialog(url,arguments,features);
		}
