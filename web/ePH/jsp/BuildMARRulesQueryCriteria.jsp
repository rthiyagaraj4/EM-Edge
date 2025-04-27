 <%@ page contentType="text/html;charset=UTF-8" import ="java.util.*,java.sql.*,webbeans.eCommon.*,ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper " %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<% 
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
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
	
	String all=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
	String routine=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
	String urgent=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
	String checked=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Checked.label","ph_labels");
	String unchecked=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.UnChecked.label","ph_labels");
	String checked_disabled=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.CheckedDisabled.label","ph_labels");
	String unchecked_disabled=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.UnCheckedDisabled.label","ph_labels");
	String mar_defaulting_values="*A,"+all+",CE,"+checked+",UE,"+unchecked+",CD,"+checked_disabled+",UD,"+unchecked_disabled;
	String mar_priority_values="A,"+all+",R,"+routine+",U,"+urgent;
	
	String App_pat_classes = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ApplicablePatientClass.label","common_labels");
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		  // Element Type
		firstItem.add(App_pat_classes);	  // label
		firstItem.add("app_pat_class");	  //name of field
		firstItem.add("20");
		firstItem.add("20");			  //LENGTH
		finAr.add(firstItem);			  //add to ArrayList obj finAr

	String Location = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels");
		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  
		secondItem.add(Location); 
		secondItem.add("location");  
		secondItem.add("30");
		secondItem.add("30");	
		finAr.add(secondItem); 
		
	String Priority = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels");
		ArrayList thirdItem=new ArrayList();
		thirdItem.add("List");  
		thirdItem.add(Priority); 
		thirdItem.add("priority");
		thirdItem.add(mar_priority_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		thirdItem.add("3");	//LENGTH
		finAr.add(thirdItem); 
	
	String Form_Code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Form.label","common_labels");
		ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");  
		fourthItem.add(Form_Code);
		fourthItem.add("form_code"); 
		fourthItem.add("30");
		fourthItem.add("30");
		finAr.add(fourthItem); 
		
	String Form_Desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FormDescription.label","ph_labels");
		ArrayList fifthItem=new ArrayList();
		fifthItem.add("Text");  
		fifthItem.add(Form_Desc);  
		fifthItem.add("form_desc"); 
		fifthItem.add("30");
		fifthItem.add("30");	
		finAr.add(fifthItem); 

	String MAR_Defaulting = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MARDefaulting.label","ph_labels");
		ArrayList sixthItem=new ArrayList();
		sixthItem.add("List");  
		sixthItem.add(MAR_Defaulting);  
		sixthItem.add("mar_defaulting");  
		sixthItem.add(mar_defaulting_values);
		sixthItem.add("4");	
		finAr.add(sixthItem); 
		
	//Hidden value for Location Code
		ArrayList seventhItem=new ArrayList();
		seventhItem.add("Hidden");  
		seventhItem.add("Loc_Code"); 
		seventhItem.add("loc_code"); 
		seventhItem.add("10");
		seventhItem.add("10");	
		finAr.add(seventhItem);
	
				
		String orderByCols[] = new String[6];
		String orderByColVals[] = new String[6];

		orderByCols[0] = App_pat_classes;
		orderByCols[1] = Location;
		orderByCols[2] = Priority ;
		orderByCols[3] = Form_Code;
		orderByCols[4] = Form_Desc;
		orderByCols[5] = MAR_Defaulting;

		orderByColVals[0] = "PATIENT_CLASS";
		orderByColVals[1] = "SOURCE_CODE";
		orderByColVals[2] = "PRIORITY";
		orderByColVals[3] = "FORM_CODE";
		orderByColVals[4] = "FORM_DESC";
		orderByColVals[5] = "BUILD_MAR_INDICATOR";
		

		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String Document_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.documenttype.label","common_labels");

		strbuff = qrypg.getQueryPage(con, finAr, Document_type,"BuildMARRulesQueryResult.jsp", Sort_order, QueryCriteria,defaultSelect, orderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());
	} 
	catch (Exception e) {
		out.println( "Exception in Query Criteria Page : " + e );
	}
	finally{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
%>
