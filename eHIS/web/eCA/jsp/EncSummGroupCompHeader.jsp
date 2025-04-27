<!DOCTYPE html>
<!--
Created By: D. Sethuraman
-->
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="Common.GroupSubGroup.label" bundle="${common_labels}"/></title>
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String mode = request.getParameter("mode");			
			
			String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			String imgUrl="";
			if(sStyle.equals("IeStyle.css"))
	 		{
				imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 		}
			
			List<EncSummHistTypeBean> oHistTypeList = null;
			EncSummHistTypeBean sHistTypeBean = null;
			String oHistType = "";
			int ntypeListSize = 0;
			
			EncSummGroup summGrpDetails = new EncSummGroup(); 
			
			oHistTypeList = new ArrayList<EncSummHistTypeBean>();
			sHistTypeBean = new EncSummHistTypeBean();
			
			sHistTypeBean.setRequest(request);
			oHistTypeList = summGrpDetails.getSummaryGroupType(sHistTypeBean);		
			
			ntypeListSize = oHistTypeList.size();
			if (ntypeListSize>0){
				for (int i=0;i<ntypeListSize;i++){
					sHistTypeBean = oHistTypeList.get(i);
					oHistType = oHistType + "<Option value="+sHistTypeBean.getsHistTypeRec()+">" +sHistTypeBean.getsShortDesc()+ "</option>";
				}
			}
			
		%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<Script src ='../../eCommon/js/CommonLookup.js'></Script>
		
		<script language='javascript' src='../../eCA/js/EncSummGroupComp.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name = 'EncSummGroupCompPopForm'>
			<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
				<tr>
					<td class=label ><fmt:message key="Common.GroupSubFlag.label" bundle="${common_labels}"/></td>
					<td class='fields' >&nbsp;<select name='es_group_flag' id='es_group_flag'  onchange='resetValuesHeader(this);setGroupFlag(this)'>
							<option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
							<option value="0">Group</option>
							<option value="1">Sub-Group</option>
						</select><img src='../../eCommon/images/mandatory.gif'>
					</td>
					<td class=label ><fmt:message key="Common.GroupType.label" bundle="${common_labels}"/></td>
					<td class='fields' >&nbsp;<select name='es_group_type' id='es_group_type'  onchange='resetValuesHeader(this);setGroupType(this)'>
							<option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
							<%=oHistType%>
							<option value="UG">User Defined</option>
						</select>
						<img src='../../eCommon/images/mandatory.gif'>
					</td>						
					<td class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
					<td class='fields' >
						<input type="text" name="es_group_code" id="es_group_code" value=''  OnKeyPress='return CheckForSpeChar(event)' 
							OnBlur ="ChangeUpperCase(this);getGroupSubGroupCode(this)" 
							OnChange='resetValuesHeader(this);setValue()'>
						<input type="button" value="?"  class="button" name="groupcode_srch" id="groupcode_srch" OnClick="getGroupSubGroupCode(this)">						
						<img src="../../eCommon/images/mandatory.gif"></img>
					</td>
				<td align='right' colspan ='2'><input type='button' class='button' name='search' id='search' 
												value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' 
												onclick="loadFrames();">
				</td>
				</tr>				
			</table>
			<input type='hidden' name='flag' id='flag' value='true'>
			<input type='hidden' name='mode' id='mode' value='<%=mode %>'>
			<input type ="hidden" name ="es_group_flag1" value="">
			<input type ="hidden" name ="es_group_type1" value="">
			<input type ="hidden" name ="es_group_code1" value="">
			
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>			
		</form>
	</body>	
</html>

