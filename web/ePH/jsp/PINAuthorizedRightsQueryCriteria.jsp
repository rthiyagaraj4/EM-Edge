 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*,java.sql.*,webbeans.eCommon.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	try {
		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object

		String User_id= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels");
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(User_id);	  // label
		firstItem.add("USER_ID");	//name of field
		firstItem.add("12");	// SIZE
		firstItem.add("12");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the firstitem object
		String User_name= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels");
		
		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(User_name);  // label
		secondItem.add("USER_NAME");   //name of field
		secondItem.add("20");	// SIZE
		secondItem.add("20");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		
		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];

		orderByCols[0] = User_id;
		orderByCols[1] = User_name;
		
		orderByColVals[0] = "USER_ID";
		orderByColVals[1] = "USER_NAME";
				
String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String OrderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String Select=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Select.label","ph_labels");

String PinAuthorizationRights = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PINAuthorizationRights.label","ph_labels");

		strbuff = qrypg.getQueryPage(null, finAr,PinAuthorizationRights , "PINAuthorizedRightsQueryResult.jsp",SortOrder,QueryCriteria,Select, OrderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>
