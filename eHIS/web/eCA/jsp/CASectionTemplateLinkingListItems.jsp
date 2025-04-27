<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*, java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	eCA.CASectionTemplateFieldsAssociationBean templateBean = (eCA.CASectionTemplateFieldsAssociationBean)getObjectFromBean("templateBean","eCA.CASectionTemplateFieldsAssociationBean",session);
%>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String compId=request.getParameter("comp_id")==null?"":request.getParameter("comp_id");
	String compItemId= request.getParameter("compItemId");
	String compIdSrlNo= request.getParameter("compIdSrlNo");
	String currentCompIdSrlNo= request.getParameter("currentCompIdSrlNo");
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	int rowNo=0;
	String classValue = "";
	String checked = "";
	HashMap itemsHash =(HashMap)templateBean.getStatus(currentCompIdSrlNo,compItemId); 
	String checkRadio = "";

%>
<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
    
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		function checkValidRadio(rownum,objr)
		{
			var obj = eval("document.forms[0].check"+rownum);
			if(!obj.checked)
			{
				alert(getMessage("NOT_DFLT_CHECK_ITEM","CA"));
				//alert("APP-CA0003 Can not default the unchecked Item");
				objr.checked = false;
			}
		}
		function checkValidCheck(rownum,objr)
		{
			/*if(!objr.checked)
			{
				alert(document.forms[0].defaultButton.value);
			}*/
		}
	</script>
</head>
<body onKeyDown="lockKey()">
<form name=compLinkingListItemsForm action="CASectionTemplateUpdateListItemsBean.jsp" method ="post">
	<table width='100%' class='grid' align='center' >
		<tr>
			<td class='columnheadercenter'> <fmt:message key="Common.Items.label" bundle="${common_labels}"/> </td>
			<td class='columnheadercenter'> <fmt:message key="Common.Applicable.label" bundle="${common_labels}"/> </td>
			<td class='columnheadercenter'> <fmt:message key="Common.Default.label" bundle="${common_labels}"/> </td>
		</tr>
		<%
		try
		{
			con= ConnectionManager.getConnection(request);
			String listItemId = "";
			String listItemText = "";
			String sql = "Select RESULT_VALUE list_item_id, REF_RNG_DESC list_item_text from AM_DISCR_MSR_REF_RNG_LIST where DISCR_MSR_ID = ?  order by REF_RANGE_SEQ ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,compId);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				rowNo++;
				/*if(rowNo%2!=0)
					classValue = "QRYODD";
				else
					classValue = "QRYEVEN";*/

					classValue = "gridData";


				listItemId = rs.getString(1);	
				listItemText = rs.getString(2);
				if(itemsHash!=null && itemsHash.get(listItemId)!=null)
				{
					checked="checked";
				}
				if(itemsHash!=null && itemsHash.get("DEFAULT_CODE").equals(listItemId))
				{
					checkRadio="checked";
				}
				%>
				<tr>
					<td class="<%=classValue%>"><%=listItemText%></td>
					<td class="<%=classValue%>">
					<input type=checkbox value="Y" name="check<%=rowNo-1%>" id="check<%=rowNo-1%>" onClick="checkValidCheck(<%=rowNo-1%>,this)" <%=checked%>>
					<input type=hidden name="listItemId<%=rowNo-1%>" id="listItemId<%=rowNo-1%>" value="<%=listItemId%>">
					<input type=hidden name="listItemText<%=rowNo-1%>" id="listItemText<%=rowNo-1%>" value="<%=listItemText%>"></td>
					<td class="<%=classValue%>">
					<input type=radio name=defaultButton value="<%=listItemId%>" onclick="checkValidRadio(<%=rowNo-1%>,this)" <%=checkRadio%> ></td>
				</tr>
				<%
					checked = "";
					checkRadio ="";
			}

		}
		catch(Exception e)
		{
			//out.println(e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if (rs!=null) rs.close();
			if (pstmt!=null) pstmt.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);

		}
		%>
		</table>
		<input type=hidden name=count value="<%=rowNo%>">
		<input type=hidden name=compItemId value="<%=compItemId%>">
		<input type=hidden name=compIdSrlNo value="<%=compIdSrlNo%>">		
		<input type=hidden name=currentCompIdSrlNo value="<%=currentCompIdSrlNo%>">
	</form>
</body>
</html>

