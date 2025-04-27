<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  %>


<head>
   <!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
   <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
</head>

<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
  <table width='100%' border='1' align='center'>
    <tr>
      <td width='2%' align='center' class='Label' nowrap><fmt:message key="eOA.FI.label" bundle="${oa_labels}"/></td>
      <td width='10%' align='left' class='Label' nowrap><fmt:message key="Common.first.label" bundle="${common_labels}"/></td>

      <td width='2%' align='center' class='Label' nowrap><fmt:message key="eOA.FU.label" bundle="${oa_labels}"/></td>
      <td width='10%' align='left' class='Label' nowrap><fmt:message key="eOA.Followup.label" bundle="${oa_labels}"/></td>

      <td width='2%' align='center' class='Label' nowrap><fmt:message key="Common.RT.label" bundle="${common_labels}"/></td>
      <td width='10%' align='left' class='Label' nowrap><fmt:message key="Common.routine.label" bundle="${common_labels}"/></td>

      <td width='2%' align='center' class='Label' nowrap><fmt:message key="eOA.SR.label" bundle="${oa_labels}"/></td>
      <td width='10%' align='left' class='Label' nowrap><fmt:message key="Common.Series.label" bundle="${common_labels}"/></td>

      <td width='2%' align='center' class='Label' nowrap><fmt:message key="eOA.CS.label" bundle="${oa_labels}"/></td>
      <td width='10%' align='left' class='Label' nowrap><fmt:message key="Common.Consult.label" bundle="${common_labels}"/></td>

      <td width='2%' align='center' class='Label' nowrap><fmt:message key="eMP.EM.label" bundle="${mp_labels}"/></td>
      <td width='10%' align='left' class='Label' nowrap><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></td>

      <td width='2%' align='center' class='Label' nowrap><fmt:message key="eOA.OB.label" bundle="${oa_labels}"/></td>
      <td width='10%' align='left' class='Label' nowrap><fmt:message key="eOA.overbooking.label" bundle="${oa_labels}"/></td>
    </tr>
  </table>
</body>

