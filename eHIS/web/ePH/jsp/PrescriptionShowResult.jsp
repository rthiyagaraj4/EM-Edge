<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<!-- This file is not used anywhere..... so did not done ant convertion for THAI -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* , eCommon.Common.*" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
    <!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
		request.setCharacterEncoding("UTF-8"); 
		String locale = (String) session.getAttribute("LOCALE");
		
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
    <script language="JavaScript" src="../js/Prescription.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">

<%
String patient_id=request.getParameter("patient_id");
String encounter_id=request.getParameter("encounter_id");
String bean_name	= "ePH.PrescriptionBean_1";
String bean_id		= "@PrescriptionBean_1"+patient_id+encounter_id;

PrescriptionBean_1 bean = (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request) ;
bean.setLanguageId(locale);

ArrayList OrderID=(ArrayList)bean.getOrderID();
ArrayList OrderDetails =(ArrayList) bean.getOrderDetails();
ArrayList OrderHeader =(ArrayList)bean.getpresHeader();
out.println("OrderID : "+OrderID);
out.println("");
out.println("OrderDetails : "+OrderDetails);
out.print("");
out.print("OrderDetails size : "+OrderDetails.size()+" ");
out.println("OrderHeader : "+OrderHeader);
ArrayList drug_remarks=(ArrayList)bean.getDrugRemarks();
out.println("drug_remarks "+drug_remarks);


HashMap chk=bean.getscheduleFrequency();
out.println("scheduleFrequency "+chk);

%>
<table border="0" width="100%" cellspacing="0" cellpadding="0">
<tr><td>
plz close window by pressing close button <input type='button' value="Print Plz... and Close" onclick='window.print();parent.window.returnValue="continue";parent.window.close();'></input>
<input type='button' value="Don't Print/Close" onclick='parent.window.returnValue="continue"; parent.window.close();'></input>
</td></tr>
</table>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>


