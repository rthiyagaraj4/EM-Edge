
<%@ page contentType="text/html;charset=UTF-8"%>
<HTML>
<HEAD>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT language="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT language="JavaScript" src="../../eCP/js/LibrarySetUp.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
<%
		//System.err.println("adfasd in frame  "+request.getQueryString());
		String source="";
		String mode=request.getParameter("mode");
		String library_id	= "";
		String eff_status="";
		String version_no="";
		  
		if(mode.equals("2"))
		{
			 library_id	= request.getParameter("library_id");
		 	 eff_status=request.getParameter("eff_status");
			 version_no=request.getParameter("version_no");
		  	source="mode="+mode+"&library_id="+library_id+"&version_no="+version_no+"&eff_status="+eff_status;
			
		}
		else
		source="mode="+mode;
		//System.err.println("source  "+source);

%>

		<iframe name="LibrarySetup_Header" id="LibrarySetup_Header" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../eCP/jsp/LibrarySetUpHeader.jsp?<%=source%>" style="height:25vh;width:100vw"></iframe>
		<iframe name="LibrarySetup_DetailHeader" id="LibrarySetup_DetailHeader" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../eCP/jsp/LibrarySetUpDetailHeadings.jsp" style="height:12vh;width:100vw"></iframe>
		<iframe name="LibrarySetup_Detail" id="LibrarySetup_Detail" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/html/blank.html" style="height:38vh;width:100vw"></iframe>
		<iframe name="LibrarySetupDynamicvalues" id="LibrarySetupDynamicvalues" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../eCP/jsp/LibraryForCaseTypeDynamicValues.jsp" style="height:28vh;width:100vw"></iframe>
	  </HTML>

