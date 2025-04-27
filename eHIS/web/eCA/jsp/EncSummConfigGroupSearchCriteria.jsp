<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
17/09/2013     		1   		Sethuraman      Created 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,eCA.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle =

	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	{
		imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	}
	
	EncSummGroup summGrpDetails = new EncSummGroup(); 	
	
	List<EncSummHistTypeBean> oHistTypeList = null;
	EncSummHistTypeBean sHistTypeBean = null;
	
	List<EncSummGroupBean> oSummGrpList = null;
	EncSummGroupBean sSummGroupBean = null;	
	
	String oHistType = "";
	int nGroupListSize = 0;
	int ntypeListSize = 0;
	
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


	ntypeListSize = 0;


%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../js/EncSummConfig.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
     <form name="GroupSearchfrm" id="GroupSearchfrm" >
		 <table  align='center' cellpadding=3 cellspacing=0 border=0 width='100%'>
			<tr><td class='columnHeader' width='100%' colspan='5'><fmt:message key="eCA.SelectGroups.label" bundle="${ca_labels}"/></td></tr>
			<tr>
				<td class=label ><fmt:message key="Common.GroupType.label" bundle="${common_labels}"/></td>
				<td class='fields' >&nbsp;<select name='es_group_type' id='es_group_type'>				
					<option value="">-------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------------</option>	
					<%=oHistType%>
					<option value="UG">User Defined</option>				
				</select><img src='../../eCommon/images/mandatory.gif'></td>			
				<td class='label'  ><fmt:message key="eCA.GroupsStartsWith.label" bundle="${ca_labels}"/></td>
				<td class='fields' ><input type='text' name='searchtext' id='searchtext' size='20' maxlength='20' value="" OnKeyPress ="return CheckForSpecChars(event)"></input></td>
				<td align=right><input type='button' name='search' id='search' class='Button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' OnClick="GroupSearchCriteria()"> </input>
			</tr>
		</table>
		<%if(!imgUrl.equals("")){ %>
			 <img src='<%=imgUrl%>' width='100%' height='15'/> 
		<%}%>
	</form>
</body>
</html>


