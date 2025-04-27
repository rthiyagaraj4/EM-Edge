<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*,com.iba.framework.core.vo.UserPreferences,com.iba.framework.cache.pojo.business.Cache,com.iba.framework.cache.pojo.business.CacheManager,com.iba.framework.core.util.Constants,com.iba.framework.core.util.IBADate"%>
<%@ page  import="com.iba.ehis.lc.core.vo.SourceBean"%>
<%@ include file="/framework/html/Tag.text"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<ibaHTML:html>
<head>
<%
			String functionId = (String) request.getParameter("functionId");
			String moduleId = (String) request.getParameter("moduleId");
			session.setAttribute("functionName",request.getParameter("function_name"));
			session.setAttribute("functionId",functionId);
			session.setAttribute("moduleId",moduleId);

			String sourceType = (String) request.getParameter("sourceType");
			String sourcetype = (String) request.getParameter("sourcetype");
			String source = (String) request.getParameter("source");
			String sourceCode = (String) request.getParameter("sourceCode");
			//AMRI-SCF-0679
			session.setAttribute("sourceType",sourceType);
			session.setAttribute("sourcetype",sourcetype);
			session.setAttribute("source",source);
			session.setAttribute("sourceCode",sourceCode);
			//AMRI-SCF-0679

			SourceBean obj=new SourceBean();
			obj.setSourceType(sourceType);
			obj.setSourcetype(sourcetype);
			obj.setSourceCode(sourceCode);
			obj.setSource(source);

			/* CacheManager.getCache().putObject(Constants.USER_SESSION_CACHE,				
					"sessid", "objKey", obj); */ //AMRI-SCF-0679

			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? "IeStyle.css"
			: (String) session.getAttribute("PREFERRED_STYLE");

		
%>
<input type="hidden" name="sourceType" id="sourceType" value="<%=sourceType%>"/>
<input type="hidden" name="sourceCode" id="sourceCode" value="<%=sourceCode%>"/>
	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
		<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>

	<script type="text/javascript" src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>	
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenRequest.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/RequestForCleaning.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenIssue.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/eLC/RequestForLinen/js/RequestForLinen.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/eLC/core/js/dTree.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/eLC/core/js/callReset.js'></script>
	
</head>
<ibaTiles:insert definition="lcwardmasterlayout"></ibaTiles:insert>
<body>
</ibaHTML:html>

