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
	<form name='EDLModifyForm' id='EDLModifyForm'>
		<table width = "100%">
				<th><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				<th width="10%"><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></th> 
<%
    String mode	  = CommonRepository.getCommonKeyValue("MODE_MODIFY");
	String bean_id = "EDLBean" ;
    String bean_name = "ePH.EDLBean";

	EDLBean bean = (EDLBean)getBeanObject( bean_id,bean_name,request) ;

	String strInValues[] = new String[2];
	String strInValues1[] = new String[1];

	strInValues[0] = locale;
	strInValues[1] = request.getParameter("code");
	strInValues1[0]= locale;

	int iVariableSequence =1;
	if(strInValues[1] != null)
	{
		String strParentQuery = PhRepository.getPhKeyValue("SQL_PH_EDL_CLASSIFICATIONS_PARENT_SELECT");

		String strChildQuery =PhRepository.getPhKeyValue("SQL_PH_EDL_CLASSIFICATIONS_CHILD_SELECT");

		String strLeafNodesQuery = PhRepository.getPhKeyValue("SQL_PH_EDL_CLASSIFICATIONS_LEAF_SELECT");
		
		bean.setMode( mode ) ;
		bean.setLanguageId(locale);

		HashMap hmParentTree = bean.fetchValues(strInValues,strParentQuery); 
		HashMap hmChildTree = bean.fetchValues(strInValues,strChildQuery); 
		HashMap hmLeafNodes = bean.fetchValues(strInValues1,strLeafNodesQuery); 

		ArrayList alEDLCode = null;
		ArrayList alEDLDescription = null;
		ArrayList alEDLStatus = null;
		ArrayList alLevels = null;
		ArrayList alInsertCheckBox =(ArrayList) hmLeafNodes.get("EDL_CODE");

		int iParentMaxLevel=0; // This is used to draw the tree structure

		if(hmParentTree!=null && hmParentTree.size() != 0)
		{
			 alEDLCode = (ArrayList) hmParentTree.get("EDL_CODE");
			 alEDLDescription = (ArrayList) hmParentTree.get("DESCRIPTION");
			 alEDLStatus = (ArrayList) hmParentTree.get("EFF_STATUS");
			 alLevels = (ArrayList) hmParentTree.get("LEVEL");
			 iParentMaxLevel = Integer.parseInt(alLevels.get(0).toString());
		}

		for(int i=0;i<alLevels.size();i++)
		{ 
			out.println("<tr><td><table width = '100%'><tr>");
			//Placing empty <TD> tags based on the levels to draw the tree structure
			for(int iCol = Integer.parseInt(alLevels.get(i).toString()); iCol<iParentMaxLevel;iCol++)
				out.print("<td width='3%'>&nbsp</td>");
			out.println("<td width='1%' class='label'>");
		
			// If the node is the selected note make it bold and put the description in the text box
			if(alEDLCode.get(i).toString().equals(strInValues[1]))
			{
				out.print("<B>"+alEDLCode.get(i)+"</B></td>");
				out.println("<td><input type='hidden' name='EDLCode"+iVariableSequence+"' id='EDLCode"+iVariableSequence+"' value = '"+alEDLCode.get(i)+"'> <input type=text name=EDLDescription"+iVariableSequence+" value='"+alEDLDescription.get(i)+"'  size='60' Maxlength='60'></td></td></tr></table>");

				// add the hidded varibale for the check box, if the selected not is not the leaf node
				if(!alInsertCheckBox.contains(alEDLCode.get(i).toString()))
					out.println("<input type='hidden' name='eff_status"+iVariableSequence+"' id='eff_status"+iVariableSequence+"' value='E'>");
			}
			else
			{
				out.print(alEDLCode.get(i)+"</td> <td  class='label'>"+alEDLDescription.get(i)+"</td></tr></table></td>");
			}
			
			// insert the check box if the current node is the leaf node
			if(alInsertCheckBox.contains(alEDLCode.get(i).toString())) 
			{
				out.println("<td>");
				// For the batch update make the EDLCode and description as a hidden variable
				if(!alEDLCode.get(i).toString().equals(strInValues[1]))
					out.print("<input type='hidden' name='EDLCode"+iVariableSequence+"' id='EDLCode"+iVariableSequence+"' value = '"+alEDLCode.get(i)+"'><input type='hidden' name=EDLDescription"+iVariableSequence+" value='"+alEDLDescription.get(i)+"'>");

				out.print(" <input type = 'checkbox' name = eff_status"+iVariableSequence+" value='E'");

				if(alEDLStatus.get(i).toString().equals("E"))
					out.print(" checked ");
				out.print("></td></tr>");
			}
			else
				out.print("<td>&nbsp;</td></tr>");
			iVariableSequence++;
		}

		if(hmChildTree!=null && hmChildTree.size()!=0)
		{
			 alEDLCode = (ArrayList) hmChildTree.get("EDL_CODE");
			 alEDLDescription = (ArrayList) hmChildTree.get("DESCRIPTION");
			 alEDLStatus = (ArrayList) hmChildTree.get("EFF_STATUS");
			 alLevels = (ArrayList) hmChildTree.get("LEVEL");

			for(int i=0;i<alLevels.size();i++)
			{ 
				out.println("<tr><td><table width = '100%'><tr>");
				for(int iCol = 0; iCol<iParentMaxLevel+Integer.parseInt(alLevels.get(i).toString());iCol++)
					out.print("<td width='3%'>&nbsp</td>");
				out.println("<td width='1%'  class='label'>");
			
				if(alEDLCode.get(i).toString().equals(strInValues[1]))
				{
					out.print("<B>"+alEDLCode.get(i)+"</B></td>");
					out.println("<td><input type='hidden' name='EDLCode"+iVariableSequence+"' id='EDLCode"+iVariableSequence+"' value = '"+alEDLCode.get(i)+"'> <input type=text name=EDLDescription"+iVariableSequence+" value='"+alEDLDescription.get(i)+"'  size='60' Maxlength='60'></td></td></tr></table>");

					// add the hidded varibale for the check box, if the selected not is not the leaf node
					if(!alInsertCheckBox.contains(alEDLCode.get(i).toString()))
						out.println("<td><input type='hidden' name='eff_status"+iVariableSequence+"' id='eff_status"+iVariableSequence+"' value='E'>");
				}
				else
				{
					out.print(alEDLCode.get(i)+"</td> <td class='label'>"+alEDLDescription.get(i)+"</td></tr></table></td>");
				}

				if(alInsertCheckBox.contains(alEDLCode.get(i).toString())) 
				{
					out.println("<td>");
					if(!alEDLCode.get(i).toString().equals(strInValues[1]))
						out.print("<input type='hidden' name='EDLCode"+iVariableSequence+"' id='EDLCode"+iVariableSequence+"' value = '"+alEDLCode.get(i)+"'><input type='hidden' name=EDLDescription"+iVariableSequence+" value='"+alEDLDescription.get(i)+"'>");
					out.print(" <input type = 'checkbox' name = eff_status"+iVariableSequence+" value='E'");

					if(alEDLStatus.get(i).toString().equals("E"))
						out.print(" checked ");
					out.print("></td></tr>");
				}
				else
					out.print("<td>&nbsp;</td></tr>");
				iVariableSequence++;

			}
		}
%>
			<tr>
				<td colspan =3 align ="right"> <input type="button" class="button" VALUE='<fmt:message key="Common.Modify.label" bundle="${common_labels}"/>'  onClick="javascript:if (checkDescriptionNull()){apply()};">
				</td>
			</tr>

<%
}
--iVariableSequence; // This value available in hidden variable, because to get the Maximum number of the variable sequence.
%>
		</table>
		<INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>"/>
	    <INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>"/>
		<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>"/>
		<INPUT TYPE="hidden" name="MaxSeqNumber" id="MaxSeqNumber" value="<%=iVariableSequence%>"/>

	</form>
</body>
</html>

