<%@ page contentType="text/html;charset=UTF-8" import ="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% 
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	//String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

<%
	
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	

	StringBuffer strbuff = new StringBuffer();
	String function_id = request.getParameter( "function_id" );
	try 
	{
		ArrayList finAr = new ArrayList();

			
	//=============== populating the first item in the firstitem object

		String MedicalItemCode= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MedicalItemCode.label","ph_labels");

		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(MedicalItemCode);	  // label	
		firstItem.add("item_code");	//name of field
		firstItem.add("19");	//LENGTH
		firstItem.add("19");
		finAr.add(firstItem);//add to ArrayList obj finAr
 
	//================= populating the second item in the firstitem object
	
	String  MedicalItemDesc= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MedicalItemDescription.label","ph_labels");

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(MedicalItemDesc);  // label	
		secondItem.add("drug_desc");   //name of field
		secondItem.add("30");	//LENGTH
		secondItem.add("30");	//SIZE
		finAr.add(secondItem); //add to ArrayList obj finAr


		String Nature= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String Enable_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String Disable_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");

		String Nature_list_values="B,"+Both_legend+",Y,"+Enable_legend+",N,"+Disable_legend;


		ArrayList ThirdItem=new ArrayList();
		ThirdItem.add("List");  //Type of item
		ThirdItem.add(Nature);  // label
		ThirdItem.add("disp_alt_form_yn");   //name of field
		ThirdItem.add(Nature_list_values);//static values that need to be displayed as
		ThirdItem.add("7");	//LENGTH
		finAr.add(ThirdItem); //add to ArrayList obj finAr
	
		ArrayList fourthItem=new ArrayList();

		//Type of item
		fourthItem.add("Hidden");  // label
		fourthItem.add("function_id");   //name of field
		fourthItem.add(function_id);//static values that need to be displayed as option.Send it along with the value that is inserted.

		//LENGTH

		finAr.add(fourthItem); //add to ArrayList obj finAr
		//=====================================================================
		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];

		orderByCols[0] = MedicalItemCode;
		orderByCols[1] = MedicalItemDesc;

		orderByColVals[0] = "item_code";
		orderByColVals[1] = "drug_desc";


		String MedicalItemDescription = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MedicalItemDescription.label","ph_labels");

		String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

		String Select=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Select.label","ph_labels");




        strbuff = qrypg.getQueryPage(null, finAr,MedicalItemDescription, "MedicalItemQueryResult.jsp", SortOrder, QueryCriteria, Select,orderBy, orderByCols, orderByColVals,ExecuteQuery);
		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>
