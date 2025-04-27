 <%--This file is saved on 07/11/2005 --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
       request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//endss
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<BODY style="overflow-y:hidden" onMouseDown="" onKeyDown="lockKey()">

<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	String function_id = request.getParameter( "function_id" );

	try {
		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();
		String RemarkCode = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RemarkCode.label","ph_labels");
		firstItem.add("Text");				//	Type of item
		firstItem.add(RemarkCode);		//	Label
		firstItem.add("REMARK_CODE");		//	Name of field
		firstItem.add("4");					//	SIZE
		firstItem.add("4");					//	LENGTH
		finAr.add(firstItem);				//	Add to ArrayList obj finAr

		//================= populating the second item in the firstitem object
		ArrayList secondItem=new ArrayList();
		String RemarkDescription = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RemarkDescription.label","ph_labels");
		secondItem.add("Text");				//	Type of item
		secondItem.add(RemarkDescription);		//	Label
		secondItem.add("REMARK_DESC");		//	Name of field
		secondItem.add("45");				//	SIZE
		secondItem.add("40");				//	LENGTH
		finAr.add(secondItem);				//	Add to ArrayList obj finAr

		//================= populating the third item in the firstitem object
		ArrayList thirdItem=new ArrayList();
		String FormCode = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FormCode.label","ph_labels");
		thirdItem.add("Text");				//	Type of item
		thirdItem.add(FormCode);			//	Label
		thirdItem.add("FORM_CODE");			//	Name of field
		thirdItem.add("4");					//	SIZE
		thirdItem.add("4");					//	LENGTH
		finAr.add(thirdItem);				//	Add to ArrayList obj finAr

		//================= populating the fourth item in the firstitem object
		ArrayList fourthItem=new ArrayList();
		String FormDescription = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FormDescription.label","ph_labels");
		fourthItem.add("Text");				//	Type of item
		fourthItem.add(FormDescription);	//	Label
		fourthItem.add("FORM_DESC");		//	Name of field
		fourthItem.add("45");				//	SIZE
		fourthItem.add("40");				//	LENGTH
		finAr.add(fourthItem);				//	Add to ArrayList obj finAr

		//================= populating the fifth item in the firstitem object
		ArrayList fifthItem=new ArrayList();
		String RouteCode = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RouteCode.label","ph_labels");
		fifthItem.add("Text");				//	Type of item
		fifthItem.add(RouteCode);		    //	Label
		fifthItem.add("ROUTE_CODE");		//	Name of field
		fifthItem.add("4");					//	SIZE
		fifthItem.add("4");					//	LENGTH
		finAr.add(fifthItem);				//	Add to ArrayList obj finAr

		//================= populating the sixth item in the firstitem object
		ArrayList sixthItem=new ArrayList();
		String RouteDescription = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RouteDescription.label","ph_labels");
		sixthItem.add("Text");				//	Type of item
		sixthItem.add(RouteDescription);	//	Label
		sixthItem.add("ROUTE_DESC");		//	Name of field
		sixthItem.add("45");				//	SIZE
		sixthItem.add("40");				//	LENGTH
		finAr.add(sixthItem);				//	Add to ArrayList obj finAr

		ArrayList seventhItem=new ArrayList();
		String SlidingScaleRemarks = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.SlidingScaleRemarks.label","ph_labels");

		 String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String Applicable = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Applicable.label","common_labels");
		String NotApplicable = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
		String tpn_item_list_values="%,"+Both_legend+",Y,"+Applicable+",N,"+NotApplicable;
 

		seventhItem.add("List");  //Type of item
		seventhItem.add(SlidingScaleRemarks);  // label
		seventhItem.add("APPL_SLIDING_SCALE_YN");   //name of field
		seventhItem.add(tpn_item_list_values);//static values that need to be displayed as
		seventhItem.add("7");	//LENGTH
		finAr.add(seventhItem); //add to ArrayList obj finAr

		ArrayList eighthItem = new ArrayList();
		eighthItem.add("Hidden");			//	Type of item
		eighthItem.add("function_id");		//	name of field
		eighthItem.add(function_id);		//	value of field
		finAr.add(eighthItem);				//	add to ArrayList obj finAr

		//=====================================================================
		String orderByCols[] = new String[7];
		String orderByColVals[] = new String[7];

		orderByCols[0] = RemarkCode;
		orderByCols[1] = RemarkDescription;
		orderByCols[2] = FormCode;
		orderByCols[3] = FormDescription;
		orderByCols[4] = RouteCode;
		orderByCols[5] = RouteDescription;
		orderByCols[6] = SlidingScaleRemarks;

		orderByColVals[0] = "A.REMARK_CODE";
		orderByColVals[1] = "A.REMARK_DESC";
		orderByColVals[2] = "A.FORM_CODE";
		orderByColVals[3] = "B.FORM_DESC";
		orderByColVals[4] = "A.ROUTE_CODE";
		orderByColVals[5] = "C.ROUTE_DESC ";
		orderByColVals[6] = "A.APPL_SLIDING_SCALE_YN ";


String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String PrescriptionRemarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PrescriptionRemarks.label","ph_labels");



		strbuff = qrypg.getQueryPage(null, finAr,PrescriptionRemarks,"PresRemarkQueryResult.jsp", Sort_order,QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals,ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>

