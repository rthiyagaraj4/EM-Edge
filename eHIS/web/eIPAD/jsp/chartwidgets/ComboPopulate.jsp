<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

 <%@ page import = "java.util.*" %>
 <%@ page import = "com.google.gson.*" %>
 <%@ page import = "eIPAD.chartsummary.allergies.response.EventTypeResponse" %>
 <%@ page import="eIPAD.chartsummary.allergies.healthobject.*"%>
 <%@ page import="eIPAD.chartsummary.common.response.ErrorInfo"%>
 <%
EventTypeResponse oEvntTypeRes = null;
List<EventType> oLstEvntType = null;
String eventTypeResponse = "";
Gson gson = new Gson();
if(request.getAttribute("EventTypeResponse") != null)
{

	oEvntTypeRes = (EventTypeResponse)request.getAttribute("EventTypeResponse");
	if(oEvntTypeRes != null)
	{
		oLstEvntType = oEvntTypeRes.getLstEventTypeDetails();
		if(oLstEvntType != null && oLstEvntType.size() > 0)
		{
			eventTypeResponse = gson.toJson(oLstEvntType);
			
		}
		
	}
}
%>
<%=eventTypeResponse %>
