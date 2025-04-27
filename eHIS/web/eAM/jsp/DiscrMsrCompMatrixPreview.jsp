<?xml version='1.0' encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="../../eCA/html/RecClinicalNotesTemplateRecordingView.xsl"?>
<DOCUMENT FORM-NAME="RecClinicalNotesTemplateForm" >
<%@page contentType="application/xml" import="java.sql.*,webbeans.eCommon.*" %>
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<CSS sStyle="<%=sStyle%>"/>
<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/common.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/ValidateControl.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/dchk.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCA/js/RecClinicalNotesPart1.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCA/js/RecClinicalNotesPart2.js'></SCRIPT>
<SCRIPT type='text/javascript' SRC='../../eCommon/js/CommonCalendar.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<SCRIPT LANGUAGE="JavaScript">
	document.body.onkeydown=lockKey;
</SCRIPT>

<STYLE type="text/css">
	.READONLY
	{
		BACKGROUND-COLOR: #C0C0C0;
	}
</STYLE>
<%
StringBuffer finalXMLString = null;
Connection con=null;
try
{
	request.setCharacterEncoding("UTF-8");
	 con = ConnectionManager.getConnection(request);
	String matrixComponentDefinition = request.getParameter("matrixComponentDefinition")==null?"":java.net.URLDecoder.decode(request.getParameter("matrixComponentDefinition"));
	String matrixDesc = request.getParameter("matrixDesc")==null?"":request.getParameter("matrixDesc");
	String matrixID = request.getParameter("matrixID")==null?"":request.getParameter("matrixID");
	//int matrix_max_columns_allowed = Integer.parseInt(request.getParameter("matrix_max_columns_allowed")==null?"0":request.getParameter("matrix_max_columns_allowed"));
	matrixComponentDefinition = java.net.URLDecoder.decode(matrixComponentDefinition);
	//out.println(matrixComponentDefinition);
	eAM.DiscrMsrCompMatrixComponentBean matrixComponentBean = new eAM.DiscrMsrCompMatrixComponentBean();
	finalXMLString = matrixComponentBean.changeDefinitionToXML(con, matrixComponentDefinition, matrixID, matrixDesc);

 //  finalXMLString = changeDefinitionToXML(con, matrixComponentDefinition, matrixID, matrixDesc, matrix_max_columns_allowed);   

	if(con != null) ConnectionManager.returnConnection(con,request);
}
catch(Exception e)
{
	out.println(e);
	e.printStackTrace(System.err);
}
%>
<!-- fn -->
<%!

%>

<!-- fn -->

<USER-TEMPLATE>
	<ROW>
		<COL>
			<%=finalXMLString%>
		</COL>
	</ROW>
</USER-TEMPLATE>

</DOCUMENT>

