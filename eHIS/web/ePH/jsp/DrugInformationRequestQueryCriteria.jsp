 	<%@ page contentType="text/html;charset=UTF-8" import ="java.util.*,java.sql.*,webbeans.eCommon.*,ePH.*, ePH.Common.*, eCommon.Common.* " %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	Connection con = null;
	try {
		StringBuffer strbuff = new StringBuffer();
		
		ArrayList finAr = new ArrayList();
		con = ConnectionManager.getConnection(request); 

String Code= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(Code);  // label
		secondItem.add("code");   //name of field
		secondItem.add("4");	//LENGTH
		secondItem.add("6");	//SIZE
		finAr.add(secondItem); //add to ArrayList obj finAr

String Description= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
		ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");  //Type of item
		thirdItem.add(Description);  // label
		thirdItem.add("description");   //name of field
		thirdItem.add("30");	//SIZE
		thirdItem.add("30");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr

String Nature= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");


		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String Enable_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Enable.label","common_labels");
		String Disable_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String Drug_info_list_values="%,"+Both_legend+",E,"+Enable_legend+",D,"+Disable_legend;
 
		ArrayList fourthItem=new ArrayList();
		fourthItem.add("List");									//	Type of item
		fourthItem.add(Nature);								//	Label
		fourthItem.add("eff_status");							//	Name of field
		fourthItem.add(Drug_info_list_values);	
		finAr.add(fourthItem);		
	 
	String Sys_defined = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SystemDefined.label","common_labels");

		String all_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
		String yes_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
		String no_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
		String Drug_item_list_values="A,"+all_legend+",Y,"+yes_legend+",N,"+no_legend;
		
		ArrayList fifthItem=new ArrayList();
		fifthItem.add("List");									//	Type of item
		fifthItem.add(Sys_defined);								//	Label
		fifthItem.add("sys_def");							//	Name of field
		fifthItem.add(Drug_item_list_values); 
		finAr.add(fifthItem);		


  	String Seq_Number = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DisplaySequenceNo.label","ph_labels");

		String orderByCols[] = new String[5];
		String orderByColVals[] = new String[5];

		orderByCols[0] = Code;
		orderByCols[1] = Description;
		orderByCols[2] = Nature;
		orderByCols[3] = Sys_defined;
		orderByCols[4] = Seq_Number; 

		//SELECT A.PH_TRN_TYPE_CODE, B.SHORT_DESC, A.ST_DOC_TYPE_CODE FROM PH_TRN_DOC_TYPE A, PH_TRN_TYPE B WHERE A.PH_TRN_TYPE_CODE=B.PH_TRN_TYPE AND A.PH_TRN_TYPE_CODE LIKE UPPER(?) AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.ST_DOC_TYPE_CODE) LIKE UPPER(?)


		orderByColVals[0] = "CODE";
		orderByColVals[1] = "DESCRIPTION";
		orderByColVals[2] = "EFF_STATUS";
		orderByColVals[3] = "SYSTEM_DEFINED_YN";
		orderByColVals[4] = "SEQUENCE";


String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

String DrugInfo=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugInformationRequest.label","ph_labels");

String Select=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Select.label","ph_labels");
     

		strbuff = qrypg.getQueryPage(con, finAr, DrugInfo , "DrugInformationRequestQueryResult.jsp", SortOrder, QueryCriteria, Select, orderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}finally{
	if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>
