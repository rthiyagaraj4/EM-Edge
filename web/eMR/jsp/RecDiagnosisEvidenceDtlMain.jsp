<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<%

String as_evidenced_by_fact = request.getParameter("as_evidenced_by_fact");
String as_evidenced_by_defn = request.getParameter("as_evidenced_by_defn");
String Patient_Id = request.getParameter("Patient_Id")==null?"":request.getParameter("Patient_Id");
String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
String term_code= request.getParameter("term_code")==null?"":request.getParameter("term_code");
String occur_srl_no_hid= request.getParameter("occur_srl_no_hid")==null?"":request.getParameter("occur_srl_no_hid");
String nature= request.getParameter("nature")==null?"":request.getParameter("nature");

%>
<title> <fmt:message key="eMR.AsEvidencedBy.label" bundle="${mr_labels}"/></title>
<!-- <frameset rows='*,10%' cols='50%,*'>
 -->
<frameset rows='*,10%' id='rec_evidence_rows'>
<frameset cols='50%,*' id='rec_evidence_cols'>

<frame name = 'evidence_factor' src = '../../eMR/jsp/RecDiagnosisEvidenceDtlAddModify.jsp?as_evidenced_by_fact=<%=java.net.URLEncoder.encode(as_evidenced_by_fact)%>&Patient_Id=<%=Patient_Id%>&term_set_id=<%=term_set_id%>&term_code=<%=term_code%>&occur_srl_no_hid=
<%=occur_srl_no_hid%>&nature=<%=nature%>' scrolling='auto' noresize frameborder='0' >
<frame name='defining_character'    src = '../../eMR/jsp/RecDiagnosisEvidenceDtlAddModify1.jsp?as_evidenced_by_defn=<%=java.net.URLEncoder.encode(as_evidenced_by_defn)%>&Patient_Id=<%=Patient_Id%>&term_set_id=<%=term_set_id%>&term_code=<%=term_code%>&occur_srl_no_hid=
<%=occur_srl_no_hid%>&nature=<%=nature%>'  noresize scrolling='auto' frameborder='0' >
</frameset>
<frame name='RecDiagnosisEvidenceDtlToolbarFrame' src='../../eMR/jsp/RecDiagnosisEvidenceDtlToolBar.jsp?as_evidenced_by_defn=<%=java.net.URLEncoder.encode(as_evidenced_by_defn)%>&Patient_Id=<%=Patient_Id%>&term_set_id=<%=term_set_id%>&term_code=<%=term_code%>&occur_srl_no_hid=<%=occur_srl_no_hid%>&nature=<%=nature%>' noresize scrolling='no' frameborder='0' >
</frameset>
</head></html>

