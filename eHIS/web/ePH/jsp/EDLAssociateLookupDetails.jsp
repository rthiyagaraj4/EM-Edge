<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<head>

<% 
	request.setCharacterEncoding("UTF-8");
    String locale			= (String)session.getAttribute("LOCALE");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?	(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
	
	<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
    <SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/EDL.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
	<form name='EDLAssociateLookUpForm' id='EDLAssociateLookUpForm'>
		<table width = "100%">
				<th><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				<th width="10%"><fmt:message key="Common.Associate.label" bundle="${ph_labels}"/></th> 
<%
    String mode	  = CommonRepository.getCommonKeyValue("MODE_MODIFY");
	String bean_id = "EDLBean" ;
    String bean_name = "ePH.EDLBean";
	ArrayList alEDLCodesSelected = new ArrayList();

	EDLBean bean = (EDLBean)getBeanObject( bean_id,bean_name,request) ;

	String strParentQuery = PhRepository.getPhKeyValue("SQL_PH_EDL_CLASSIFICATIONS_SELECT_PARENT");

	String strLeafNodesQuery = PhRepository.getPhKeyValue("SQL_PH_EDL_CLASSIFICATIONS_SELECT_LEAF_NODE");

	String strPathQuery = PhRepository.getPhKeyValue("SQL_PH_EDL_CLASSIFICATIONS_SELECT_PATH");

	String strCodes = request.getParameter("EDLCodes");
	if(strCodes!=null && !strCodes.equals(""))
		alEDLCodesSelected = new ArrayList(Arrays.asList(strCodes.split(","))); 

	bean.setMode( mode ) ;
	bean.setLanguageId(locale);

	String[] strLanguageId = {locale};
	String[] strLanguageIds = {locale,locale};

	HashMap hmParentTree = bean.fetchValues(strLanguageId,strParentQuery); 
	HashMap hmLeafNodes = bean.fetchValues(strLanguageIds,strLeafNodesQuery); 
	HashMap hmPathValues =  bean.fetchValues(strLanguageId,strPathQuery); ;
	
	ArrayList alEDLCode = null;
	ArrayList alEDLDescription = null;
	ArrayList alEDLStatus = null;
	ArrayList alLevels = null;
	ArrayList alInsertCheckBox =(ArrayList) hmLeafNodes.get("EDL_CODE");
	ArrayList alPathValues = null;

	int iParentMaxLevel=0; // This is used to draw the tree structure

	if(hmParentTree!=null && hmParentTree.size() != 0){
		 alEDLCode = (ArrayList) hmParentTree.get("EDL_CODE");
		 alEDLDescription = (ArrayList) hmParentTree.get("DESCRIPTION");
		 alEDLStatus = (ArrayList) hmParentTree.get("EFF_STATUS");
		 alLevels = (ArrayList) hmParentTree.get("LEVEL");
		 alPathValues = (ArrayList) hmPathValues.get("PATH");
		 // SCF SKR-SCF-0062  
		 if(alLevels!=null && alLevels.size() != 0)
			iParentMaxLevel = Integer.parseInt(alLevels.get(0).toString());
	}

	for(int i=0;i<alLevels.size();i++){ 

		out.println("<tr><td><table width = '100%'><tr>");
		//Placing empty <TD> tags based on the levels to draw the tree structure
		for(int iCol = 1; iCol< Integer.parseInt(alLevels.get(i).toString());iCol++)
			out.print("<td width='2%'>&nbsp</td>");
		out.println("<td width='1%' class='label'>");

		if(alEDLStatus.get(i).toString().equals("D"))
			out.print("<I>"+alEDLCode.get(i)+" </I><input type='hidden' name='enabled' id='enabled' value='T'></td><td class='label'><I>"+alEDLDescription.get(i)+"</I>");
		else
			out.print(alEDLCode.get(i)+" <input type='hidden' name='enabled' id='enabled' value='F'></td><td class='label'>"+alEDLDescription.get(i));
		out.print("<input type='hidden' name='EDLCode' id='EDLCode' value = '"+alEDLCode.get(i)+"'> <input type='hidden' name='EDLDescription' id='EDLDescription' value='"+alPathValues.get(i)+"'> </td></tr></table></td>");
		if(alInsertCheckBox.contains(alEDLCode.get(i).toString()) && (alEDLStatus.get(i).toString().equals("E") || alEDLCodesSelected.contains(alEDLCode.get(i).toString()))){
			// insert the check box if the current node is the leaf node
			out.println("<td>");
			out.print(" <input type = 'checkbox' name = EffectiveStatus value='"+i+"'");
			if(alEDLCodesSelected != null && alEDLCodesSelected.contains(alEDLCode.get(i).toString()) )
				out.print(" checked ");
			out.print("></td>");
		}
		else
			out.println("<input type='hidden' name='EffectiveStatus"+i+"' id='EffectiveStatus"+i+"' value='E'>");
		out.println("</tr>");
	}
%>
		</table>
		<INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>"/>
	    <INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>"/>
		<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>"/>
	</form>
</body>
</html>

