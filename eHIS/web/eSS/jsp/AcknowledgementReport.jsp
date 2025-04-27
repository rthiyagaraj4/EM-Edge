<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source%>"  frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eSS/jsp/AcknowledgementReportRun.jsp?mode=<%=eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT")%>' frameborder=0 scrolling='no' noresize style='height:100vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:50%;width:100vw'></iframe>
</html>

