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
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePH/js/EDL.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
try{
	String bean_id = "EDLBean" ;
    String bean_name = "ePH.EDLBean";

	int iTotalRecords = 5; // This is Hard coded since only 10 rows are fixed. This should be changed in case of more rows

	String strDrugCode = request.getParameter("DrugCode");
	//String strDrugCode = "TEST11";

	EDLBean bean = (EDLBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	if(strDrugCode!=null)
	{
		String strGetEDLCodesFromDrugQRY = PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT_EDL_CODES");
		String strGetEDLClassficationsQRY = PhRepository.getPhKeyValue("SQL_PH_EDL_CLASSIFICATIONS_SELECT_PATH1");
        String inValues[] = {strDrugCode, locale};
		String inValues1[] = {locale};
		HashMap hmValues = bean.fetchValues(inValues,strGetEDLCodesFromDrugQRY);
		ArrayList pregnancyCategoryInfo = bean.getPregnancyCategoryDetails(strDrugCode);
		ArrayList alEDLCodes = (ArrayList) hmValues.get("EDL_CODES");
		ArrayList alEDLRemarks = (ArrayList) hmValues.get("EDL_REMARKS");
		String categoryCode= "";
		String categoryCode1= "";
		String categoryCode2= "";
		String categoryCode3= "";
		String b2 = "";
		String strQryParams = "";
		if(alEDLCodes!=null && alEDLCodes.size() > 0) 
			strQryParams = (String)alEDLCodes.get(0);
%>
		<!-- <body> -->
		<body onMouseDown="" onKeyDown="">
	<form name='EDLListView' id='EDLListView'>
	<table width="100%">

			<th><fmt:message key="ePH.EDLCLASSIFICATION.label" bundle="${ph_labels}"/></th><br>

		<tr>

<%		if(alEDLCodes!=null && alEDLCodes.size() > 0 && alEDLCodes.get(0)!=null)
		{
			if(strQryParams!=null) 
				strQryParams = "('"+ strQryParams.replace(",","','").concat("')");

			hmValues = bean.fetchValues(inValues1,strGetEDLClassficationsQRY+""+ strQryParams);
			ArrayList alPath = (ArrayList) hmValues.get("PATH");

			int iTreeSize;
			for(int i=0;i<alPath.size();i++)
			{
				String strValues[] = alPath.get(i).toString().split("~");
				iTreeSize = 4;
				for(int iCol=0; iCol< strValues.length; iCol++)
				{
					if(iTreeSize !=4)
						out.println("<td><table width = '100%'><tr><td width="+iTreeSize+"% >&nbsp;</td>");
					if(iCol == strValues.length-1)
						out.print("<td><B>"+strValues[iCol]+"</B></td></tr></table></td></tr>");
					else
						out.print("<td>"+strValues[iCol]+"</td></tr></table></td></tr>");
					iTreeSize += 4; 
				}
			}
		}
%>
		</table>
	<table width="100%">
			<th><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>

		<tr>
			<td>&nbsp;&nbsp;&nbsp;<textarea  rows="5" cols="70"  readOnly> <%=alEDLRemarks.get(0)==null?"":alEDLRemarks.get(0)%> </textarea></td>
		</tr>
	</table>
	
	<br>

  <%
	  if (pregnancyCategoryInfo.size()>0){
		  categoryCode = pregnancyCategoryInfo.get(0).toString();
		  categoryCode1 = pregnancyCategoryInfo.get(1).toString();
		  categoryCode2 = pregnancyCategoryInfo.get(2).toString();
		  categoryCode3 = pregnancyCategoryInfo.get(3).toString();
		
		  if ((!(categoryCode.equals("")))||(!(categoryCode1.equals("")))||(!(categoryCode2.equals("")))||(!(categoryCode3.equals("")))){%>
	  
	  <table width="100%">		
		<th width = "100%"><fmt:message key="ePH.PregnancyEffects.label" bundle="${ph_labels}"/></th>
		<%if (!(categoryCode.equals(""))){%>
		<tr><td><fmt:message key="ePH.PregnancyCategory.label" bundle="${ph_labels}"/> </td></tr>
		<tr><td>&nbsp;&nbsp;<b><%= bean.getFDACategoryDescription(pregnancyCategoryInfo.get(0).toString())%></b></td>
		</tr><%}%>
		<%if (!(categoryCode1.equals(""))){%>
		<tr><td><fmt:message key="ePH.FirstTrimester.label" bundle="${ph_labels}"/></td></tr>
		<%if (!(pregnancyCategoryInfo.get(1).toString().equals("")))
		{
			categoryCode = pregnancyCategoryInfo.get(1).toString()+"   ";
		}
		else 
			categoryCode ="";%>
		<tr><td>&nbsp;&nbsp;&nbsp;<textarea  rows="5" cols="70"  readOnly ><%=categoryCode%><%= bean.getFDAPregnancyCategoryDesc(pregnancyCategoryInfo.get(0).toString(),pregnancyCategoryInfo.get(1).toString())%></textarea>
		</td></tr>
		<%}%>
		<%if (!(categoryCode2.equals(""))){%>
		<tr><td><fmt:message key="ePH.SecondTrimester.label" bundle="${ph_labels}"/></td></tr>
		<%if (!(pregnancyCategoryInfo.get(2).toString().equals("")))
		{
			categoryCode = pregnancyCategoryInfo.get(2).toString()+"   ";
		}
		else 
			categoryCode ="";%>
		<tr><td>&nbsp;&nbsp;&nbsp;
		<textarea  rows="5" cols="70"  readOnly ><%=categoryCode%><%= bean.getFDAPregnancyCategoryDesc(pregnancyCategoryInfo.get(0).toString(),pregnancyCategoryInfo.get(2).toString())%></textarea></td>	
		</tr>
		<%}%>
		<%if (!(categoryCode3.equals(""))){%>
		<tr><td><fmt:message key="ePH.ThirdTrimester.label" bundle="${ph_labels}"/></td></tr>
		<%if (!(pregnancyCategoryInfo.get(3).toString().equals("")))
		{
			categoryCode = pregnancyCategoryInfo.get(3).toString()+"   ";
		}
		else 
			categoryCode ="";%>
		<tr><td>&nbsp;&nbsp;&nbsp;<textarea  rows="5" cols="70"  readOnly ><%=categoryCode%><%= bean.getFDAPregnancyCategoryDesc(pregnancyCategoryInfo.get(0).toString(),pregnancyCategoryInfo.get(3).toString())%></textarea>
		</td></tr>
<%
			}
%>		
	</table>	
<%
			}
		}
%> 
	</form>
</body>
<%//if(alEDLCodes.get(0)==null){ %>
<!-- <script>
	alert(getMessage("NO_EDL_CLASSIFICATION","PH"));
	window.close();
</script> -->
	
<%		
	//}
   
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
</html> 

