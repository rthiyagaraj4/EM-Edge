<%@ page import ="java.util.ArrayList" %>
<%@page  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 <%
 		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<%
		ArrayList components = new ArrayList();
		ArrayList items = new ArrayList();
	try {
		String query = eST.Common.StRepository.getStKeyValue("SQL_AM_MANUFACTURER_LIST");
		String lan_id ="'"+locale+"'";
		query = query.replace("?",lan_id);
		ecis.utils.CommonQueryPage queryPage = new ecis.utils.CommonQueryPage();
		StringBuffer htmlTag = new StringBuffer();
		String function_id = request.getParameter( "function_id" );

		String mahcine_code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.MachineCode.label","st_labels");
		items.add("Text");
		items.add(mahcine_code);
		items.add("machine_code");
		items.add("10");
		items.add("10");
		components.add(items);

		items=new ArrayList();
		String mahcine_name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MachineName.label","common_labels");
		items.add("Text");
		items.add(mahcine_name);
		items.add("machine_name");
		items.add("60");
		items.add("60");
		components.add(items);

		items=new ArrayList();
		String ModelNo = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.ModelNo.label","st_labels");
		items.add("Text");
		items.add(ModelNo);
		items.add("model_no");
		items.add("20");
		items.add("20");
		components.add(items);

		items=new ArrayList();
		String Manufacturer = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Manufacturer.label","common_labels");
		String Manufacturer_id = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ManufacturerID.label","common_labels");
		items.add("List");
		items.add(Manufacturer);
		items.add("manufacturer_id");
		//items.add(eST.Common.StRepository.getStKeyValue("SQL_AM_MANUFACTURER_LIST"));
		items.add(query);
		components.add(items);
		items=new ArrayList();

		items=new ArrayList();
		String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String Enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String Nature_List="%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
		items.add("List");
		items.add(Nature);
		items.add("eff_status");
		items.add(Nature_List);
		items.add("1");
		items.add("1");	
		components.add(items);

		items=new ArrayList();
		items.add("Hidden");
		items.add("function_id");
		items.add(function_id);
		components.add(items);

		String[] headers = new String[4];
		headers[0] = mahcine_code;
		headers[1] = mahcine_name;
		headers[2] = ModelNo;
		headers[3] = Manufacturer_id;

		String[] values = new String[4];
		values[0]="a.machine_code";
		values[1]="a.machine_name";
		values[2]="a.model_no";
		values[3]="b.short_name";

		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
		//htmlTag = queryPage.getQueryPage((( java.util.Properties ) session.getValue("jdbc")),components,"Machine Code" ,"../../eST/jsp/MachineQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",headers, values,"Execute Query",true);
		htmlTag = queryPage.getQueryPage((( java.util.Properties ) session.getValue("jdbc")),components,mahcine_code ,"../../eST/jsp/MachineQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,headers, values,ExecuteQuery,true);
		out.println(htmlTag);
	}
	catch (java.lang.Exception exception) 	{
		out.println(exception.toString());
	}finally{
		components.clear();
		items.clear();
	}
%>
