 <%-- saved on 26/10/2005 --%>
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" %>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.* ,ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for MMS-ME-SCF-0097 Starts 
request= new XSSRequestWrapper(request); 
response.addHeader("X-XSS-Protection", "1; mode=block"); 
response.addHeader("X-Content-Type-Options", "nosniff"); 
//Added by Himanshu for MMS-ME-SCF-0097 ends
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<%
//==========================yet to explore==============================//
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
//======================================================================//


	
	/* Mandatory checks start */
	String function_id = request.getParameter("function_id") ;


	StringBuffer strbuff = new StringBuffer();
	Connection con=null ;

	try {
	
		con = ConnectionManager.getConnection(request);
		ArrayList finAr = new ArrayList();

		String Stress_Rel_Option = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.StressRelatedOption.label","ph_labels");
		ArrayList firstItem=new ArrayList();
		firstItem.add("Text");  //Type of item
		firstItem.add(Stress_Rel_Option);  // label
		firstItem.add("stress_related_option");   //name of field
		firstItem.add("60");	// SIZE
		firstItem.add("60");	//LENGTH
		finAr.add(firstItem); //add to ArrayList obj finAr

		String Weightage = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Weightage.label","ph_labels");
		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(Weightage);  // label
		secondItem.add("weightage");   //name of field
		secondItem.add("6");	// SIZE
		secondItem.add("6");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr


		String defalt = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Default.label","common_labels");

		String both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String yes_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
		String no_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
		String stress_item_list_values="%,"+both_legend+",Y,"+yes_legend+",N,"+no_legend;
		ArrayList fourthItem=new ArrayList();
		fourthItem.add("List");  //Type of item
		fourthItem.add(defalt);  // label
		fourthItem.add("default_yn");   //name of field
		fourthItem.add(stress_item_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		fourthItem.add("7");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr


		function_id = request.getParameter( "function_id" );

		ArrayList sixthItem = new ArrayList();
		sixthItem.add("Hidden");  //Type of item
		sixthItem.add("function_id");  // name of field
		sixthItem.add(function_id);   //value of field
		finAr.add(sixthItem); //add to ArrayList obj finAr


		//=====================================================================

		String orderByCols[] = new String[3];
		String orderByColVals[] = new String[3];

		String Srl_no = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SerialNo.label","common_labels");

		orderByCols[0] = Srl_no;
		orderByCols[1] = Stress_Rel_Option;
		orderByCols[2] = Weightage;
	
		orderByColVals[0] = "srl_no";
		orderByColVals[1] = "stress_related_option";
		orderByColVals[2] = "weightage";
	

		//===============yet to explore================================//
		String Order_Intention = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OrderIntention.label","ph_labels");
	
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

		strbuff = qrypg.getQueryPage(con, finAr, Order_Intention, "StressFactorQueryResult.jsp", Sort_order, QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals, ExecuteQuery);

		//===================================================================//

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println("main"+e);
	}finally{
		try
		 { 
			ConnectionManager.returnConnection(con);
		 }catch(Exception e){
				out.println("in finally"+e);
		 }
	}
%>

