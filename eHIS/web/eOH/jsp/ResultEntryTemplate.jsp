<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String template_id = request.getParameter("template_id");
	String msr_id = request.getParameter("msr_id");
	String msr_desc = request.getParameter("msr_desc");
	String row_index = request.getParameter("row_index");
	String data_from = request.getParameter("data_from");
	String readonly = request.getParameter("readonly");
	if(template_id==null)	template_id="";

	if(msr_id==null)	msr_id="";
	if(msr_desc==null)	msr_desc="";
	if(row_index==null)	row_index="";
	if(data_from==null)	data_from="";
	if(readonly==null)	readonly="";
	//out.println(template_id+", "+msr_id);
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<title><fmt:message key="eOR.ResultEntryTemplate.label" bundle="${or_labels}"/></title>
<frameset rows='64%,30%,6%'>
	<frame name='ResultEntryTmplTop' src='ResultEntryTemplateTop.jsp?template_id=<%=template_id%>&msr_desc=<%=msr_desc%>&row_index=<%=row_index%>&data_from=<%=data_from%>&readonly=<%=readonly%>' frameborder=no frameborder=0  noresize scrolling=no>
	<%if(readonly.trim().equals("")){%>
	<frameset cols='50%,50%'>
	<frame name='ResultEntryTmplBlock' src='ResultEntryTemplateBlock.jsp?template_id=<%=template_id%>&msr_id=<%=msr_id%>' frameborder=no frameborder=0  noresize>
	<frame name='ResultEntryTmplRight' src='ResultEntryTemplateRight.jsp' frameborder=no frameborder=0 noresize scrolling=no>
	</frameset>
	<%}else{%>
	<frame name='ResultEntryTmplBlank' src='ResultEntryTemplateBlank.jsp' frameborder=no frameborder=0 noresize scrolling=no>
	<%}%>
	<frame name='ResultEntryTmplBtn' src='ResultEntryTemplateBtn.jsp?readonly=<%=readonly%>' frameborder=no frameborder=0  noresize scrolling=no>
</frameset>
