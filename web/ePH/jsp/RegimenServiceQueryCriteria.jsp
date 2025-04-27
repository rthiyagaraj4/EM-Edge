 <%--This file is saved on 07/11/2005 --%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//endss
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


		String Indicator= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.INDICATOR.label","common_labels");
		String oncology= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Oncology.label","ph_labels");
		String oncology1="O,"+oncology;
		ArrayList secondItem=new ArrayList();
		secondItem.add("List");  //Type of item
		secondItem.add(Indicator);  // label  
		secondItem.add("indicator");   //name of field
		secondItem.add(oncology1);//static values that need to be displayed as option.Send it along with the value that is inserted.
		secondItem.add("7");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		String ServiceCode= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels");

		ArrayList firstItem=new ArrayList();
		firstItem.add("Text");  //Type of item
		firstItem.add(ServiceCode);  // label  
		firstItem.add("service_code");   //name of field
		firstItem.add("8");	// SIZE
		firstItem.add("8");	//LENGTH
		finAr.add(firstItem); //add to ArrayList obj finAr


		String ServiceDesc= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceDescription.label","common_labels");

		ArrayList seventhItem=new ArrayList();
		seventhItem.add("Text");  //Type of item
		seventhItem.add(ServiceDesc);  // label   
		seventhItem.add("service_desc");   //name of field
		seventhItem.add("15");	// SIZE
		seventhItem.add("15");	//LENGTH
		finAr.add(seventhItem); //add to ArrayList obj finAr

		String Regimen= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Regimen.label","ph_labels");

		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String Enable_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Enable.label","common_labels");
		String Disable_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");

		String Regimen_YNList_values="%,"+Both_legend+",Y,"+Enable_legend+",N,"+Disable_legend;


		ArrayList fourthItem=new ArrayList();
		fourthItem.add("List");  //Type of item
		fourthItem.add(Regimen);  // label	
		fourthItem.add("regimen_yn");   //name of field
		fourthItem.add(Regimen_YNList_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		fourthItem.add("7");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

		String Tpn= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TPN.label","ph_labels");
		String Regimen_Tpn_list_values="%,"+Both_legend+",Y,"+Enable_legend+",N,"+Disable_legend;

		ArrayList thirdItem=new ArrayList();
		thirdItem.add("List");  //Type of item
		thirdItem.add(Tpn);  // label		
		thirdItem.add("tpn_yn");   //name of field
		thirdItem.add(Regimen_Tpn_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		thirdItem.add("7");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr
		//==================== populating the 2nd item in the firstitem object

		String Nature= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");

		String Regimen_list_values="%,"+Both_legend+",E,"+Enable_legend+",D,"+Disable_legend;

		ArrayList fifthItem=new ArrayList();
		fifthItem.add("List");  //Type of item
		fifthItem.add(Nature);  // label
		fifthItem.add("eff_status");   //name of field
		fifthItem.add(Regimen_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		fifthItem.add("7");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr
		function_id = request.getParameter( "function_id" );

		ArrayList sixthItem = new ArrayList();
		sixthItem.add("Hidden");  //Type of item
		sixthItem.add("function_id");  // name of field
		sixthItem.add(function_id);   //value of field
		finAr.add(sixthItem); //add to ArrayList obj finAr
		//=====================================================================
		String orderByCols[] = new String[3];
		String orderByColVals[] = new String[3];

		orderByCols[0] = ServiceCode;
		orderByCols[1] = Regimen;
		orderByCols[2] = Tpn;

		orderByColVals[0] = "a.service_code";
		orderByColVals[1] = "a.regimen_yn";
		orderByColVals[2] = "tpn_yn";
			//===============================================//

		String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

		String Select=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Select.label","ph_labels");

		String Intention=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OrderIntention.label","ph_labels");
 
		strbuff = qrypg.getQueryPage(con, finAr, Intention, "RegimenServiceQueryResult.jsp",SortOrder, QueryCriteria,Select, orderBy, orderByCols, orderByColVals, ExecuteQuery);

		//===================================================================//

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println("main"+e);
	}finally{
		try
		 { 
			ConnectionManager.returnConnection(con);
		 }
		 catch(Exception e){
			e.printStackTrace();
		 }
	}
%>
