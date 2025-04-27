 <%@ page contentType="text/html;charset=UTF-8" import ="java.util.*,java.sql.*,webbeans.eCommon.*,ePH.*, ePH.Common.*, eCommon.Common.* " %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<% 
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff = new StringBuffer();
	Connection con=null ;
	try {
		ArrayList finAr = new ArrayList();
		
		con = ConnectionManager.getConnection(request); 

String Phar_trans_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PharmacyTransactionType.label","ph_labels");

		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(Phar_trans_type);	  // label
		firstItem.add("ph_trn_type");	//name of field
		firstItem.add("22");
		firstItem.add("20");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr


	String Phar_trans_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PharmacyTransactionDescription.label","ph_labels");
	
		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(Phar_trans_desc);  // label
		secondItem.add("ph_trn_desc");   //name of field
		secondItem.add("22");
		secondItem.add("20");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr


		//=====================================================================
		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];

		orderByCols[0] = Phar_trans_type;
		orderByCols[1] = Phar_trans_desc;

		orderByColVals[0] = "A.PH_TRN_TYPE_CODE";
		//orderByColVals[1] = "B.SHORT_DESC";
		orderByColVals[1] = "C.LONG_DESC";

String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String Document_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.documenttype.label","common_labels");

	strbuff = qrypg.getQueryPage(con, finAr, Document_type,"DocumentTypeQueryResult.jsp", Sort_order, QueryCriteria,defaultSelect, orderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());
	} 
	catch (Exception e) {
		out.println( "main " + e );
	}
	finally{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>
