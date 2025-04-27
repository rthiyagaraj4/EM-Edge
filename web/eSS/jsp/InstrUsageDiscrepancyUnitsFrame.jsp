<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="alTrayDiscrepancyList" scope="session" class="java.util.ArrayList"/>

<html>
	<head>
 <%
		 request.setCharacterEncoding("UTF-8");
		 String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
  %>
	    <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../js/InstrUsageDiscrepancyUnitsDetail.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	</head>
	<%
		
		alTrayDiscrepancyList.clear();
		
	%>
<%-- 	<frameset rows='35,*'>
		<frame name='frameInstrUsageDiscrepancyUnitsHeader' src="../../eSS/jsp/InstrUsageDiscrepancyUnitsHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize>
 		<frameset cols="40%,*" >
			<frame name='frameInstrUsageDiscrepancyUnitsDetail' src="../../eSS/jsp/InstrUsageDiscrepancyUnitsDetail.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize>
				<frame name='frameInstrUsageDiscrepancyUnitsList' src='../../eSS/jsp/InstrUsageDiscrepancyUnitsList.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize>
			
		</frameset>
	</frameset>  --%>
<body style="margin: 0; display: flex; flex-direction: column; height: 100vh;">
	 <iframe name="frameInstrUsageDiscrepancyUnitsHeader" 
            src="../../eSS/jsp/InstrUsageDiscrepancyUnitsHeader.jsp?<%=request.getQueryString()%>" 
            style="height: 10vh; border: none; scrolling: no;">
    </iframe>

    <div style="flex: 1; display: flex;">
        <iframe name="frameInstrUsageDiscrepancyUnitsDetail" 
                src="../../eSS/jsp/InstrUsageDiscrepancyUnitsDetail.jsp?<%=request.getQueryString()%>" 
                style="width: 50vw; height: 100vh; border: none; scrolling: no;">
        </iframe>

        <iframe name="frameInstrUsageDiscrepancyUnitsList" 
                src="../../eSS/jsp/InstrUsageDiscrepancyUnitsList.jsp?<%=request.getQueryString()%>" 
                style="width: 50vw; height: 100vh; border: none; scrolling: no;">
        </iframe>
    </div>
	
	</body> 
	
	
	
</html>
