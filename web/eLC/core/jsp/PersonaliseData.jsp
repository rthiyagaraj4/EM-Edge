<!DOCTYPE html>
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate" pageEncoding="ISO-8859-1"%>
<%@ include file="/framework/html/Tag.text"%>
<ibaHTML:html>

<head>
<%
			String facilityId=(String)session.getAttribute("facility_id");
			String moduleId = (String) session.getAttribute("moduleId");
			String user = (String) session.getAttribute("login_user");
			String dateFormat = (String) request.getParameter("dateFormat");
			String timeFormat = (String) request.getParameter("timeFormat");
			String currency = (String) request.getParameter("currency");
			String decimal = (String) request.getParameter("decimal");
			String languageId = (String) session.getAttribute("LOCALE");
	
		
				UserPreferences userPrefs =new UserPreferences();
				userPrefs.setCurrency(currency);
   				userPrefs.setDateFormat(dateFormat) ;
   				userPrefs.setTimeFormat(timeFormat);
				userPrefs.setCurrency(currency);
				userPrefs.setLocale(languageId);

				/* Cache cache = CacheManager.getCache();
				cache.putObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS,userPrefs); */ //AMRI-SCF-0679
				

				
	%>
<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
<script>
function goMain()
{
			getServerMessage("MESSAGE.OPERATION_SUCCESS");
			msg=dwrMessage;
	 		alert(msg);
			parent.parent.parent.frames[1].expand(this);
			   parent.parent.parent.frames[2].location.href = contextPath +"/eCommon/jsp/maindisplay.jsp";
}

</script>

</head>  
<body onload="goMain()">
</body>
</ibaHTML:html>

