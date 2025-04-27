<!DOCTYPE html>
<!--

	Developed by 	:	R.Nanda Kumar
	Created on 	:	18/01/2000
	Module		:	Out Patient Management
	Function	:	Consultation - Patient Arrival

	String p_encounter_id = request.getParameter("encntr_id");
	String p_queue_status = request.getParameter("queuestatus");

-->
<%@ page contentType="text/html;charset=UTF-8"  %>
<%

	String p_encounter_id = "210100000002";
	String p_queue_status = "01";

%>

<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");   
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<script>

		function chgbuttonclr()
		{
			document.getElementById("patarrival").style.background="navy" ;
			document.getElementById("patarrival").style.color="white" ;
			document.getElementById("patarrival").style.fontWeight="700" ;
			document.getElementById("patarrival").style.borderStyle="solid" ;

			document.getElementById("close").style.background="navy" ;
			document.getElementById("close").style.color="white" ;
			document.getElementById("close").style.fontWeight="700" ;
			document.getElementById("close").style.borderStyle="solid" ;
		}

		async function callModal()
		{
			var dialogHeight= "37vh" ;
			var dialogWidth	= "40vw" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status ;
			var arguments	= "" ;

			//var retVal = window.showModalDialog("/eCIS/op/jsp/ConsPatArrival.jsp?encntr_id=<%=p_encounter_id%>&queue_status=<%=p_queue_status%>",arguments,features);
			var retVal = await window.showModalDialog("../op/jsp/CallPatArrival.jsp?encntr_id=<%=p_encounter_id%>&queue_status=<%=p_queue_status%>",arguments,features);

			//window.close();

		}



	</script>

</head>
<body onLoad="chgbuttonclr()" onKeyDown = 'lockKey();'>
<center>
	<table>
		<tr>
			<td><input type='button' name='patarrival' id='patarrival' value='<fmt:message key="Common.patient.label" bundle="${common_labels}"/> <fmt:message key="Common.arrival.label" bundle="${common_labels}"/>' onClick='callModal()'></td>
		</tr>

		<tr valign=bottom>
			<td align='center'><input type='button' name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="parent.parent.document.getElementById('dialog_tag').close();"></td>
		</tr>

	</table>
</center>
</body>
</html>

