<!DOCTYPE html>
<!--
Created By: D. Sethuraman
-->
<%@ page language="java" import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*, eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
	<head>
		<title><fmt:message key="eCA.AttachedComponents.label" bundle="${ca_labels}"/></title>
		<%
			
			String sStyle =
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			
			EncSummGroup summGrpDetails = new EncSummGroup();		
			
			String from = request.getParameter("from") ;
		    String to = request.getParameter("to") ;
			StringBuffer sql = new StringBuffer();
			
			String es_summ_code = request.getParameter("es_summ_code");
			String es_summ_desc = request.getParameter("es_summ_desc");
			String es_group_code = request.getParameter("es_group_code");
			String es_group_desc = request.getParameter("es_group_desc");		
			
			String classValue = "", strEmptyStr = "";

			int compFlag = 0, compTemplate = 0, compColumns = 0, seqNo=0;
			String summCode="", summDesc="", groupType="", groupCode="", groupDesc="", groupSeq="";			
		%>
		<!-- <modifeid by Arvind @06-12-2008> -->

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eCA/js/EncSummConfig.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
	</head>
	<body onscroll='scrollTitleTop()' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name = 'SummaryGroupForm' >			
			<table class='grid' cellpadding='3' cellspacing='0' border='0' width='100%'  align='center'>
				<tr id='trcoll'>
					<td class='COLUMNHEADERCENTER' width="100" ><fmt:message key="eCA.SummaryCode.label" bundle="${ca_labels}"/></td>
					<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.SummaryDescription.label" bundle="${ca_labels}"/></td>					
					<td class='COLUMNHEADERCENTER'><fmt:message key="Common.GroupCode.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.groupdesc.label" bundle="${ca_labels}"/></td>					
					<td class='COLUMNHEADERCENTER'><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></td>							
				</tr>
				<%										
					List<EncSummConfigGroupBean> oSummGroupList = null;
					EncSummConfigGroupBean sConfigGroupBean = null;
					
					int nSummGroupListSize = 0;
					
					String prevSumm = "", currSumm = "";

					try
					{
						oSummGroupList = new ArrayList<EncSummConfigGroupBean>();
						sConfigGroupBean = new EncSummConfigGroupBean();
						
						sConfigGroupBean.setRequest(request);			
						sConfigGroupBean.setsSummaryCode(es_summ_code);
						sConfigGroupBean.setsSummaryDesc(es_summ_desc);
						sConfigGroupBean.setsGroupCode(es_group_code);
						sConfigGroupBean.setsGroupDesc(es_group_desc);
						
						oSummGroupList = summGrpDetails.getSummaryConfigAddedGroups(sConfigGroupBean);		
						
						sConfigGroupBean = new EncSummConfigGroupBean();
						
						nSummGroupListSize = oSummGroupList.size();						
						
						classValue = "gridData";
						
						for (int i=0;i<nSummGroupListSize;i++){
							
							sConfigGroupBean = oSummGroupList.get(i);	
							summCode = sConfigGroupBean.getsSummaryCode();
							summDesc = sConfigGroupBean.getsSummaryDesc();
							groupCode = sConfigGroupBean.getsGroupCode();
							groupType = sConfigGroupBean.getsGroupType();
							groupDesc = sConfigGroupBean.getsGroupDesc();	
							seqNo = sConfigGroupBean.getiSequence();					
							
							currSumm = summCode.toLowerCase();																			
							
							if (!currSumm.equalsIgnoreCase(prevSumm))
							{								
								out.println("<tr width='100%'>");		
								out.println("<td colspan='1' class='CAGROUP'>"+summCode+" </td>");
								out.println("<td colspan='4' class='CAGROUP'>"+summDesc+" </td>");								
								out.println("</tr>");							
							}
							
							out.println("<tr>");								
							out.println("<td class='gridData'> "+strEmptyStr+" </td>");
							out.println("<td class='gridData'> "+strEmptyStr+" </td>");
							out.println("<td class='gridData'> "+groupCode+" </td>");
							out.println("<td class='gridData'> "+groupDesc+" </td>");
							out.println("<td class='gridData'> "+seqNo+" </td>");							
							out.println("</tr>");													
							
							prevSumm = summCode.toLowerCase();
						}						
					}
					catch(Exception e)
					{
						//out.println("Exception in try of EncSummGroupCompList.jsp"+e.toString());//common-icn-0181
						e.printStackTrace();
					}				
			%>
			</table>			
			<input type='hidden' name='countOfRows' id='countOfRows' value='<%=nSummGroupListSize%>'>
			<input type='hidden' name='firstPos' id='firstPos' value=''>
			<input type='hidden' name='secPos' id='secPos' value=''>
			<input type='hidden' name='flag' id='flag' value="true">			
			<input type='hidden' name='es_summ_code' id='es_summ_code' value='<%=es_summ_code%>'>
			<input type='hidden' name='es_summ_desc' id='es_summ_desc' value='<%=es_summ_desc%>'>
			<input type='hidden' name='es_group_code' id='es_group_code' value='<%=es_group_code%>'>
			<input type='hidden' name='es_group_desc' id='es_group_desc' value='<%=es_group_desc%>'>
		</form>		
	</body>
</html>

