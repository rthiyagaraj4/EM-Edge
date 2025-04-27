 <%@page import="java.util.*,java.lang.*, eST.Common.*, eST.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	String bean_id = request.getParameter("bean_id");
	//String bean_name = request.getParameter("bean_name");

	int functionType = Integer.parseInt(request.getParameter("function_type"));
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	String report_type = request.getParameter("report_type");
	switch (functionType) {
	case 1:
		{
			if(report_type.equals("C"))	
			{
			    out.println("clearListItems('document.formConsumptionReportQueryCriteria.p_report_idS'); ");
				out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"STBCONS1"+ "\",\"" +"Item Consolidated"+ "\") ; ");
				out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"STBCONS2"+ "\",\"" +"By Store"+ "\") ; ");
				out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"STBCONS3"+ "\",\"" +"By Store-Item Class"+ "\") ; ");
				out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"STBCONS4"+ "\",\"" +"By Item Class"+ "\") ; ");
				out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"STBCONS5"+ "\",\"" +"By Item"+ "\") ; ");
			}else
					if(report_type.equals("CD"))	
			{
				out.println("clearListItems('document.formConsumptionReportQueryCriteria.p_report_idS'); ");
				out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"STBCNDST"+ "\",\"" +"By Store"+ "\") ; ");
				out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"STBCNDIC"+ "\",\"" +"Item Consolidated"+ "\") ; ");
			
				out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"STBCNDIT"+ "\",\"" +"By Item"+ "\") ; ");
			
			}
			else
			{
			   out.println("clearListItems('document.formConsumptionReportQueryCriteria.p_report_idS'); ");
				 out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"ATCS1"+ "\",\"" +"ATC Classification #1"+ "\") ; ");
				 out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"ATCS2"+ "\",\"" +"ATC Classification #2"+ "\") ; ");
			
				 out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"ATCS3"+ "\",\"" +"ATC Classification #3"+ "\") ; ");
				 out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"ATCS4"+ "\",\"" +"ATC Classification #4"+ "\") ; ");
			
				 out.println("addListItem(\"document.formConsumptionReportQueryCriteria.p_report_idS\", \"" +"ATCS5"+ "\",\"" +"ATC Classification #5"+ "\") ; ");
						}
				}
		break;
		default :
		{
				out.println("alert(\'Invalid Function\');");
			return;
		}
	}
%>
