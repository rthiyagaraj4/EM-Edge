/**
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V201125            8073       MOHE-CRF-0055      	    Nandhini M
 */

function reset()
{
	summaryreport.location.reload();
}

function run()  
{
  var formsObj = parent.content.summaryreport.document.forms[0];
  var facility_id=formsObj.p_facility_id.value;
  var invoice_yr=formsObj.Year.value;
  var invoice_month=formsObj.Month.value;
  var p_report_id=formsObj.p_report_id.value;
  var locale=formsObj.locale.value;
  var session_id=formsObj.p_session_id.value;
  var p_module_id=formsObj.p_module_id.value;
  //var p_pgm_date=formsObj.p_pgm_date.value;
  var loggedUserId = formsObj.p_user_name.value;

var pgm_id=p_report_id;	

/*var xmlDoc = new ActiveXObject( "Microsoft.XMLDom" ) ;
var xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" ) ;*/
var xmlDoc = "";
var xmlHttp = new XMLHttpRequest();

var xmlStr ="<root><SEARCH ";
xmlStr +=" /></root>";

if(invoice_month.length=="1") //added against 9861
{
	invoice_month="0"+invoice_month;
}

var date = invoice_yr+invoice_month;
//alert(date);
	
var htmlVal = "<html><body>";
htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
htmlVal += "<input type='hidden' name='p_facility' id='p_facility' value='"+facility_id+"'>";
htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+locale+"'>";
htmlVal += "<input type='hidden' name='p_year_month' id='p_year_month' value='"+date+"'>";
htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+p_report_id+"'>";
htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+p_module_id+"'>";
htmlVal += "</form></body></html>";
 
dummy_frame.document.body.insertAdjacentHTML("afterbegin",HTMLVal);
dummy_frame.document.dummy_frm.submit();		 

}	

function trimString(sInString) {
	  return sInString.replace(/^\s+|\s+$/g,"");
}

