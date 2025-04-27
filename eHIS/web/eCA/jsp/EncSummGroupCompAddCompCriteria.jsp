<!DOCTYPE html>
<!--
Created By: D. Sethuraman
-->
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	eCA.EncSummCompRecBean summRecCompBean = (eCA.EncSummCompRecBean)getObjectFromBean("summRecCompBean","eCA.EncSummCompRecBean",session);
	String queryString = request.getQueryString();		
%>
<html>
	<head>
		<title><fmt:message key="eCA.AttachedSectionsForType.label" bundle="${ca_labels}"/></title>
		<%
			
			String sStyle =
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			
			String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
			String groupFlag = request.getParameter("groupFlag") == null ? "" : request.getParameter("groupFlag");
			String groupType = request.getParameter("groupType") == null ? "" : request.getParameter("groupType");
			String groupCode = request.getParameter("groupCode") == null ? "" : request.getParameter("groupCode");
			
			int gFlag = Integer.parseInt(request.getParameter("gFlag"));
			
			List<EncSummHistTypeBean> oHistTypeList = null;
			EncSummHistTypeBean sHistTypeBean = null;
			String oHistType = "";
			int ntypeListSize = 0;			
			
			EncSummGroup summGrpDetails = new EncSummGroup();			
			
			oHistTypeList = new ArrayList<EncSummHistTypeBean>();
			sHistTypeBean = new EncSummHistTypeBean();			
			
			sHistTypeBean.setRequest(request);
			//sHistTypeBean.setsHistTypeRec(groupType);
			oHistTypeList = summGrpDetails.getSummaryGroupType(sHistTypeBean);			
			
			ntypeListSize = oHistTypeList.size();			
			
			if (ntypeListSize>0){
				for (int i=0;i<ntypeListSize;i++){
					sHistTypeBean = oHistTypeList.get(i);
					oHistType = oHistType + "<Option value="+sHistTypeBean.getsHistTypeRec()+">" +sHistTypeBean.getsShortDesc()+ "</option>";
				}
			}
			
			String searchText = request.getParameter("searchText") == null ? "" : request.getParameter("searchText");
			
			

		%> 
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eCA/js/EncSummGroupComp.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onscroll='scrollTitle()' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name = 'encSummGroupSearchCompForm'>			
			<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
				<tr id='trcoll'>
					<td class='COLUMNHEADER' colSpan='2'><fmt:message key="eCA.AvailableComponentList.label" bundle="${ca_labels}"/></td>	
					<td class='COLUMNHEADER' colSpan='2'></td>				
					<td class='COLUMNHEADER' colSpan='2'></td>
					<td class='COLUMNHEADER' colSpan='1'></td>					
				</tr>
				<tr id='trcoll'>
					<td class='label' ><fmt:message key="Common.ComponentFlag.label" bundle="${common_labels}"/></td>
					<td class='fields' >&nbsp;<select name='es_comp_flag' id='es_comp_flag'  onchange='resetValuesCompCrit(this);setSearchCompFlag(this)'>																
								<option value="1">Component</option>
								<%
									if (groupFlag.equalsIgnoreCase("0"))
									{
								%>								
								<option value="0">Sub-Group</option>
								<%
									}
								%>
								
							</select>							
					</td>	
				
					<!-- 
					<td class='label'><fmt:message key="Common.ComponentType.label" bundle="${common_labels}"/></td>
					 -->
					<td class='label' align=right><span id='compTypeList' ><fmt:message key="Common.ComponentType.label" bundle="${common_labels}"/></span></td>				
				
					<td class='fields' >&nbsp;<select name='es_comp_type' id='es_comp_type'  onchange='resetValuesCompCrit(this);setSearchCompType(this)'>						
							<option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
							<%=oHistType%>
							<option value="UG">User Defined</option>					
						</select>
						<img src='../../eCommon/images/mandatory.gif'>
					</td>	
					<td class='label'><fmt:message key="eCA.ComponentStartsWith.label" bundle="${ca_labels}"/></td>
					<td class='fields'><input type='text' name='searchText' id='searchText' value='<%=searchText%>'></td>
					<td align=center><input type='button' name='searchBtn' id='searchBtn' class='button' 
											value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'
											onclick='loadComponents()'>
					</td>					
				</tr>				
			</table>				
			<input type='hidden' name='searchTextHidden' id='searchTextHidden' value='<%=searchText%>'>
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>			
			<input type='hidden' name='groupFlag' id='groupFlag' value='<%=groupFlag%>'>
			<input type='hidden' name='groupType' id='groupType' value='<%=groupType%>'>
			<input type='hidden' name='groupCode' id='groupCode' value='<%=groupCode%>'>
			<input type='hidden' name='gFlag' id='gFlag' value='<%=gFlag%>'>	
			<input type='hidden' name='compType' id='compType' value=''>			
		</form>
		
	</body>
</html>

