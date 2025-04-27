<!DOCTYPE html>

	<%@page import="java.sql.*, eCA.*, java.util.*, java.io.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>	
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="JavaScript" src ="../../eCA/js/VaccinesForCategory.js"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown='CodeArrest();' onKeyDown='lockKey()'>
	<form name='vaccinesForCategoryDtlForm' id='vaccinesForCategoryDtlForm'>
	<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

	<%
		eCA.VaccineForCategoryBean vaccinebean = (eCA.VaccineForCategoryBean)getObjectFromBean("vaccinebean","eCA.VaccineForCategoryBean",session);
	%>
	
	<%
	
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		int rowCount = 0;
		int maxRecord = 0;
		int start = 0;
		int end = 0;
		String error_msg = "";	
		String searchText = request.getParameter("categoryDesc");	
//		String mode = request.getParameter("mode")==null ? "" : request.getParameter("mode");
		String categoryId = request.getParameter("categoryId")==null ? "" : request.getParameter("categoryId");
		
		
		if(to == null)
			end = 6;
		else
			end = Integer.parseInt(to);

		if(from == null)
			start = 0;
		else
			start = Integer.parseInt(from);
		

		if(searchText==null || searchText.equals("")||searchText.equals("%"))
				searchText = "%";
		else
			searchText = searchText.toUpperCase() +"%";	

		
			
		try
		{	
			vaccinebean.getQueryVaccineForCategory(categoryId);
			
			CommonCollectionUtils<String, String> vaccList = vaccinebean.getVaccineList(searchText,categoryId);

			List<String> selectedVaccLst =  vaccinebean.getVaccineList().keyList();

			if(vaccList != null)
			{

			maxRecord = vaccList.size();
%>
<table cellpadding='0' cellspacing='0' border='0' width='100%' align='center'>
	<tr>
	 <td class='white' width='100%'></td> 
	<td class='label' width='16%' align='right' nowrap>
	<%
		if ( !(start <= 1) )
			out.println("<A class='gridLink'  href='../../eCA/jsp/VaccinesForCategoryDtl.jsp?from="+(start-6)+"&categoryDesc="+java.net.URLEncoder.encode(searchText)+"&categoryId="+categoryId+"&mode=modify"+"&to="+(end-6)+"'text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		if ( !( (start+6) > maxRecord ) )
			out.println("&nbsp;<A class='gridLink'  href='../../eCA/jsp/VaccinesForCategoryDtl.jsp?from="+(start+6)+"&categoryId="+categoryId+"&categoryDesc="+java.net.URLEncoder.encode(searchText)+"&mode=modify"+"&to="+(end+6)+"'text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	%>
		</td>
	</tr>
</table>	

<div id='divDataTitle' style='postion:relative'>
<table cellpadding='3' cellspacing='0' border='1' id='dataTitleTable' width='100%' align='center' >
		<tr>
			<th class='columnheadercenter' width='73%' align="left"><fmt:message key="eCA.VaccineDescription.label" bundle="${ca_labels}"/></th>
			<th class='columnheadercenter' width='20%' align="left"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
		</tr>
</table>	
</div>	                      
<table class='grid' cellpadding='3' cellspacing='0' border='1' id='dataTitleTable1' width='100%' align='center' >	
<%	
		String vaccId = ""; 
		List<String> vaccIdLst = vaccList.keyList();		
	
		for(int i = start; i < end; i++)
		{
			if(i < vaccList.size())
			{
				vaccId = vaccIdLst.get(i);
			%>
				<tr  id='<%=rowCount%>'>
					<td class='gridData' width='73%' >
						<%=vaccList.get(vaccId)%>
					</td>
					<td class='gridData' width='20%' >
						<input type='checkbox' name='select_yn<%=rowCount%>' id='select_yn<%=rowCount%>'   <%if(selectedVaccLst.contains(vaccId)){%> checked <%}%>onClick="stringConCatenate(this,'<%=vaccId%>','<%=vaccList.get(vaccId)%>')">
					</td>
				</tr>
				<INPUT TYPE="hidden" name="vaccineCode<%=rowCount%>" id="vaccineCode<%=rowCount%>" value='<%=vaccId%>'>
				
			<%				
			rowCount++;	
		}	
	  }
				
			}else
				{
					error_msg ="NO_RECORD_FOUND_FOR_CRITERIA";

					out.println("<script>alert(getMessage('"+error_msg+"','Common'));</script>");
					out.println("<script>parent.VaccinesForCategorySearchFrame.document.vaccinesForCategorySearchForm.searchtext.value=''</script>");

					out.println("<script>document.URL='../../eCommon/html/blank.html'</script>");
					
				}
			out.println("<input type='hidden' name='sequence' id='sequence' value='"+rowCount+"'> ");
			
			
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	%>
	</table>		
	</form>
	</body>
</html>

