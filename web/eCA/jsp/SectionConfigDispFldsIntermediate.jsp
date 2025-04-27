<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCA.SectionConfigDispFldBean " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String key = request.getParameter("key")==null?"":request.getParameter("key");
	String fieldCount = request.getParameter("fieldCount")==null?"":request.getParameter("fieldCount");
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	eCA.SectionConfigDispFldBean sectionBean = (eCA.SectionConfigDispFldBean)session.getAttribute("SectionConfigDispFldBean");

	if(sectionBean != null && fieldCount != null)
	{
		if(mode.equals("ADD"))
		{
			sectionBean.addSelected(key, fieldCount);
		}
		else if(mode.equals("REMOVE"))
		{
			sectionBean.removeSelected(key);
		}
	}
%>
