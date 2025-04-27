<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<title><fmt:message key="eCA.Graph.label" bundle="${ca_labels}"/></title>
</HEAD>
<script>
/**********************changes made for the multiple graph in one x-y axis******************/
var args0;
var args1;
var args2;
var args3;
var args4;
var args5;			
function splitArray()
{
	
	var arrValues	=	new Array();
	arrValues		=	top.dialogArguments;
	args0 = arrValues[0];
	args1 = arrValues[1];
	args2 = arrValues[2];
	args3 = arrValues[3];
	args4 = arrValues[4];
	args5 = arrValues[5];
	//alert(arrValues[1]);
	//alert(arrValues[0]);
	//document.getElementById("frmset").rows='*%,0%'
	/*alert(args0);
	alert(args1);
	alert(args2);
	alert(args3);
	alert(args4);
	alert(args5);*/
	callGraphDisplay1('0');
	
	

}	
function callGraphDisplay1(val)
{
	var HTMLVal		=	"<html><body class='CONTENT' onMouseDown=CodeArrest()onKeyDown=lockKey()><form name='argumentForm' id='argumentForm' "+
						" action='../../eCA/jsp/FlowSheetMultipleGraphApplet.jsp' method='post'>"+
						"<input type='hidden' name='values' id='values' value='"+args0+"'>"+
						"<input type='hidden' name='dates' id='dates' value='"+args1+"'>"+
						"<input type='hidden' name='totcols' id='totcols' value='"+args2+"'>"+
						"<input type='hidden' name='eventval' id='eventval' value='"+args3+"'>"+
						"<input type='hidden' name='unitval' id='unitval' value='"+args4+"'>"+
						"<input type='hidden' name='seriescount' id='seriescount' value='"+args5+"'>"+
						"</form></body></html>";
		
	eval("self.chart_frame"+val+".document.body.insertAdjacentHTML('afterbegin',HTMLVal)");
	eval("self.chart_frame"+val+".document.argumentForm.submit()");
}

/********************ends here**********/
</script>
<iframe SRC="../../eCommon/html/blank.html" name="chart_frame0" id="chart_frame0" scrolling=auto style="height:100vh;width:100vw"></iframe><iframe SRC="../../eCommon/html/blank.html" name="dummy_frame" id="dummy_frame" scrolling=no style="height:0%;width:100vw"></iframe>
</HTML>


