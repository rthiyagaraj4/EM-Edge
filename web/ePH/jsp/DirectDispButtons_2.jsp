<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import=" ePH.*, eOR.*, ePH.Common.* , eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
    <!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>


<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/Prescription_1.js"></script>
	<script language="JavaScript" src="../js/PrescriptionTest.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../ePH/js/FDBDrugInfo.js"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
    String facility_id					= (String) session.getValue("facility_id");
    String param_bean_id				= "@DrugInterfaceControlBean";
	String param_bean_name				= "ePH.DrugInterfaceControlBean";
	DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
	String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id); 
	param_bean.clear();
	
%>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name="preview" id="preview">

<table border="0" width="100%" height="100%" cellspacing="0" cellpadding="0" >
 
 <tr>
	<td colspan="2" class="white">
		<table  border="2" bordercolor="black" width="100%" height="75%">
			<tr>
			    <%if(drug_db_interface_yn.equals("Y")){%>
					<td  noWRAP width="20" class="SHIFTTOTAL"	border="1" bordercolor="black"><img src='../../ePH/images/exceed1.gif' ></img></td>
				    <td  WRAP width="35" style="font-size:7pt" class="white" border="0" bordercolor="white"><fmt:message key="ePH.ExternalDataBaseChecks.label" bundle="${ph_labels}"/>  </td> 

				<%}%>
				<td noWRAP width="20" class="ALLERGY2"><img src='../../ePH/images/exceed1.gif' ></img></td> 
				<td  style="font-size:7pt" class="white" border="0" bordercolor="white"><fmt:message key="ePH.Allergic.label" bundle="${ph_labels}"/></td>
				<td  WRAP width="20" class="DOSELIMIT2"  border="1" bordercolor="black"><img src='../../ePH/images/exceed1.gif' ></img></td>
				<td    style="font-size:7pt" class="white" border="0" bordercolor="white" ><fmt:message key="ePH.BeyondDose.label" bundle="${ph_labels}"/> </td> 
				<td  WRAP width="20" class="CURRENTRX2"	border="1" bordercolor="black"><img src='../../ePH/images/exceed1.gif' ></img></td> 
				<td  style="font-size:7pt" class="white" border="0" bordercolor="white"><fmt:message key="ePH.DuplicateDrug.label" bundle="${ph_labels}"/></td>
				
			</tr>
		</table>
	</td>
</tr>

</table> 
</form>
</body>
</html>



