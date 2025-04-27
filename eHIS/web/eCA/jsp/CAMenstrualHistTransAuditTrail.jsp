<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
01/10/2024     68508     krishna pranay             13/10/2024  Ashwini Ragupathi  ML-MMOH-CRF-1759							
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,eCA.*,webbeans.eCommon.*,java.io.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>  
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<HTML>
<HEAD>
<link rel='StyleSheet' href='../../eCommon/html/<%= sStyle %>' type='text/css' />
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eCA/js/CAMenstrualHistDtlTrans.js'></script>	
<title>View Audit Trail</title>
</head>
<%
request.setCharacterEncoding("UTF-8");
request = new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
String selectedValue = request.getParameter("selectedValue") == null ? "" : request.getParameter("selectedValue");

String slClassValue = "gridData";
String srl_no = request.getParameter("srl_no") == null ? "" : request.getParameter("srl_no");
String ca_bean_id = "@CAMenstrualHistDtlTransBean";
String ca_bean_name = "eCA.CAMenstrualHistDtlTransBean";
CAMenstrualHistDtlTransBean bean = (CAMenstrualHistDtlTransBean) getBeanObject(ca_bean_id, ca_bean_id, request);
ArrayList resAuditDetails = bean.getMenstrualHistoryAuditTrailDetails(patient_id, srl_no, selectedValue);

%>

<form name="CAMenstrualAuditTrailForm" id="CAMenstrualAuditTrailForm">
    <div id='divDataTitle' style='position:relative; margin: 0 auto; width: 100%;'>
        <table border='1' width='100%' cellpadding='3' cellspacing='0' align='center' style='table-layout: fixed;  border-left: 1px solid lightgray;  border: 1px solid lightgray;'>
            <tr>
                <th class='columnheadercenter'><fmt:message key="eCA.field.label" bundle="${ca_labels}"/></th>
                <th class='columnheadercenter'><fmt:message key="eCA.perviousvalue.label" bundle="${common_labels}"/></th>
                <th class='columnheadercenter'><fmt:message key="eCA.amendby.label" bundle="${common_labels}"/></th>
                <th class='columnheadercenter'><fmt:message key="eCA.amenddateandtime.label" bundle="${common_labels}"/></th>
                <th class='columnheadercenter'><fmt:message key="eCA.modifiedRemarks.label" bundle="${common_labels}"/></th>
            </tr>
        </table>
    </div>
    <div id='divDataTitle' style='position:relative; margin: 0 auto; width: 100%;'>
        <table border='1' width='100%' cellpadding='3' cellspacing='0' align='center' style='table-layout: fixed;  border-left: 1px solid lightgray;  border: 1px solid lightgray;'>
            <%
            if (resAuditDetails.size() > 0) {
                for (int i = 0; i < resAuditDetails.size(); i++) {
                    String[] record = (String[]) resAuditDetails.get(i);
                    String fieldName = CommonBean.checkForNull(record[0]);
                    String previousValue = CommonBean.checkForNull(record[1]);
                    String amendBy = CommonBean.checkForNull(record[2]);
                    String amendDate = CommonBean.checkForNull(record[3]);
                    String modifiedRemarks = CommonBean.checkForNull(record[4]);
                   
            %>
                    <tr>
                        <td class='<%= slClassValue %>' style="text-align: center;"><%= fieldName %></td>
                        <td class='<%= slClassValue %>' style="text-align: center;">
                        <% if ("Remarks".equals(fieldName)) {%>
                       <a href="#" onclick="openRemarksAuditPopup('<%=previousValue %>')">R</a>
                       <%}else{ %>
                        <%= previousValue %>
                        <%} %>
                        </td>
                        <td class='<%= slClassValue %>' style="text-align: center;"><%= amendBy %></td>
                        <td class='<%= slClassValue %>' style="text-align: center;"><%= amendDate %></td>
                        <td class='<%= slClassValue %>' style="text-align: center;"> <a href="#" onclick="openRemarksModifiedPopup('<%=modifiedRemarks %>')">R</a></td>
                    </tr>
            <%
                }
            }
            %>
        </table>
    </div>
</form>
</body>
</html>

