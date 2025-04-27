<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<html>                                
<head>                                
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<script language="javascript" src="../js/PhCommon.js"></script>
 	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>                               

<%
	String dt_from	=	request.getParameter("dt_from");
	String  dt_to	=	request.getParameter("dt_to");
	String  drug_code	=	request.getParameter("drug_code");


String url1= "../../ePH/jsp/QueryDispSpecialDrugOrder.jsp?drug_code="+drug_code+"&dt_from="+dt_from+"&dt_to="+dt_to;

String url2="../../ePH/jsp/QueryDispSpecialDrugSummary.jsp?drug_code="+drug_code+"&dt_from="+dt_from+"&dt_to="+dt_to;

if ( (!(drug_code.equals("")))&&(drug_code!=null))
	{
		url1= "../../ePH/jsp/QueryDispSpecialDrugOrder.jsp?drug_code="+drug_code+"&dt_from="+dt_from+"&dt_to="+dt_to+"&fromSummary=0";

		out.println("inside if");
%>


<iframe name="f_drugdetailsframe" id="f_drugdetailsframe"  src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="auto" style="height:5%;width:100vw"></iframe><iframe name="f_orderdetailsframe" id="f_orderdetailsframe" src="<%=url1%>" frameborder="0" noresize scrolling="auto" style="height:70%;width:100vw"></iframe><iframe name="f_totaldetailsframe" id="f_totaldetailsframe" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="auto" style="height:15%;width:100vw"></iframe><iframe name="f_orderdetailsframe1" id="f_orderdetailsframe1" src="../../eCommon/html/blank.html" noresize scrolling="auto" frameborder="0"  style="height:100vh;width:100vw"></iframe>
<%
	}
else
{ out.println("inside else");
%>

<iframe name="f_summaryframe" id="f_summaryframe"  src="<%=url2%>" frameborder="0" noresize scrolling="auto" style="height:80%;width:100vw"></iframe><iframe name="f_drugdetailsframe" id="f_drugdetailsframe"  src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="no" style="height:4%;width:100vw"></iframe><iframe name="f_orderdetailsframe" id="f_orderdetailsframe" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="auto" style="height:6%;width:100vw"></iframe><iframe name="f_totaldetailsframe" id="f_totaldetailsframe" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="no"  style="height:4%;width:100vw"></iframe><iframe name="f_orderdetailsframe1" id="f_orderdetailsframe1" src="../../eCommon/html/blank.html" noresize scrolling="auto" frameborder="0"  style="height:6%;width:100vw"></iframe>
<%
	}
%>
</html>

