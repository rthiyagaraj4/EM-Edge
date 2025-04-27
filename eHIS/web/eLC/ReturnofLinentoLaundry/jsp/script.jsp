<!DOCTYPE html>
<html>
	<%
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";
	
	%>
	<head>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />		<script type="text/javascript" src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>	
		<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/IBADateValidator.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/ReturnofLinentoLaundry.js'></script>
		<Script language="JavaScript" src="<%=request.getContextPath()%>/eLC/ReturnofLinentoLaundry/js/ReturnofLinentoLaundry.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
		

<body>
</body>
</html>

