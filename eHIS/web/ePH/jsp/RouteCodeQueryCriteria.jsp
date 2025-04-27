
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>



<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
	("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<%-- Mandatory declarations end --%>
<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	String exProductLink="N";
	
	try {
		ArrayList finAr = new ArrayList();
      String RouteCode = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RouteCode.label","ph_labels");

		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(RouteCode);	  // label
		firstItem.add("route_code");	//name of field
		firstItem.add("4");	// SIZE
		firstItem.add("4");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the firstitem object
		ArrayList secondItem=new ArrayList();
		 String RouteDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RouteDescription.label","ph_labels");
		secondItem.add("Text");  //Type of item
		secondItem.add(RouteDesc);  // label
		secondItem.add("route_desc");   //name of field
		secondItem.add("22");	// SIZE
		secondItem.add("20");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

	/*	ArrayList localItem=new ArrayList();
 String LocalLanguage
	 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.LocalLanguage.label","ph_labels");
		localItem.add("Text");  //Type of item
		localItem.add(LocalLanguage);  // label
		localItem.add("route_local");   //name of field
		localItem.add("22");	// SIZE
		localItem.add("20");	//LENGTH
		finAr.add(localItem); //add to ArrayList obj finAr*/


String ExternalProductRoute
	 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ExternalProductRoute.label","ph_labels");

		if (exProductLink.equals("Y"))
		{
		ArrayList thirdItem=new ArrayList();
	
		
		thirdItem.add("Text");  //Type of item
		thirdItem.add(ExternalProductRoute);  // label
		thirdItem.add("ext_route_code");   //name of field
		thirdItem.add("22");	// SIZE
		thirdItem.add("20");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr

		ArrayList fourthItem=new ArrayList();
        
		String ExternalRouteDesc
	 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ExternalRouteDesc.label","ph_labels");
		fourthItem.add("Text");  //Type of item
		fourthItem.add(ExternalRouteDesc);  // label
		fourthItem.add("ext_route_desc");   //name of field
		fourthItem.add("22");	// SIZE
		fourthItem.add("20");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

		}

		ArrayList fifthItem=new ArrayList();
       String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String tpn_item_list_values="B,"+Both_legend+",E,"+enabled_legend+",D,"+Disabled_legend;
 
  String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		fifthItem.add("List");  //Type of item
		fifthItem.add(Nature);  // label
		fifthItem.add("eff_status");   //name of field
		fifthItem.add(tpn_item_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		fifthItem.add("7");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr
		//=====================================================================
		

		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String DrugCategory=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugCategory.label","ph_labels");

		if (exProductLink.equals("Y"))
		{
		String orderByCols[] = new String[4];
		String orderByColVals[] = new String[4];
		orderByCols[0] = RouteCode;
		orderByCols[1] = RouteDesc;
		//orderByCols[2] = LocalLanguage;

		orderByColVals[0] = "ROUTE_CODE";
		orderByColVals[1] = "ROUTE_DESC";
		//orderByColVals[2] = "ROUTE_DESC_LOCAL_LANG";

		orderByCols[2] = "External Route Code";
		orderByCols[3] = "External Route Desc";
		
		
		
		orderByColVals[2] = "EXT_ROUTE_CODE";
		orderByColVals[3] = "EXT_ROUTE_DESC";

		strbuff = qrypg.getQueryPage(null, finAr, DrugCategory , "RouteCodeQueryResult.jsp", Sort_order, QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals,ExecuteQuery);

		out.println(strbuff.toString());

		}
		else
		{
		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];
		orderByCols[0] = RouteCode;
		orderByCols[1] = RouteDesc;
		//orderByCols[2] = LocalLanguage;

		orderByColVals[0] = "ROUTE_CODE";
		orderByColVals[1] = "ROUTE_DESC";
		//orderByColVals[2] = "ROUTE_DESC_LOCAL_LANG";
        
		


		strbuff = qrypg.getQueryPage(null, finAr, DrugCategory , "RouteCodeQueryResult.jsp", Sort_order,QueryCriteria, defaultSelect,orderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());

		}
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>
