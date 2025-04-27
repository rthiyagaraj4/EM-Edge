 <%--This file is saved on 07/11/2005 --%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.util.ArrayList, ePH.*" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations end --%>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<!-- <BODY>
 -->
 <body onMouseDown="" onKeyDown="lockKey()">
<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff	= new StringBuffer();
	StringBuffer ageGroup	= new StringBuffer();
	String bean_id	="DispLocnTimeTableBean";
    String bean_name	="ePH.DispLocnTimeTableBean";
	String facility_id          = (String)session.getValue( "facility_id" );
  	String code="";
	String desc="";

	DispLocnTimeTableBean bean	= (DispLocnTimeTableBean)getBeanObject( bean_id,bean_name, request);
    bean.setLanguageId(locale);
	ArrayList arrListDisplocation = (ArrayList)bean.getDispList(facility_id,locale); 
    HashMap Displistvalues=new HashMap();
     ageGroup.append("%,----- Select -----");

	for(int i=0; i<arrListDisplocation.size(); i++)
				{
					Displistvalues = (HashMap)arrListDisplocation.get(i);
					code = (String)Displistvalues.get("code");
                    desc = (String)Displistvalues.get("desc");
			       	ageGroup.append(","+code);
		            ageGroup.append(","+desc);
				}
	
	try {
		ArrayList finAr = new ArrayList();

	
		//================= populating the third item in the firstitem object

		String DispenseLocation= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DispenseLocation.label","ph_labels");

		ArrayList firstItem=new ArrayList();
		firstItem.add("List");								       //	Type of item
		firstItem.add(DispenseLocation);		           //	Label
		firstItem.add("DISP_LOCN_CODE");						           //	Name of field
		firstItem.add(ageGroup.toString());          //	Dynamic age group values from database.
		finAr.add(firstItem);											//	Add to ArrayList obj finAr
		
		//================= populating the third item in the firstitem object
	    ArrayList secondItem = new ArrayList();
	
       String DayTypeL= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DayType.label","ph_labels");
       
	   String Select1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String Monday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Monday.label","common_labels");
		String Tuesday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Tuesday.label","common_labels");
		String Wednesday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Wednesday.label","common_labels");
		String Thursday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Thursday.label","common_labels");
		String Friday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Friday.label","common_labels");

		String Saturday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Saturday.label","common_labels");
		String Sunday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Sunday.label","common_labels");

		String alldays = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllDays.label","common_labels");
		
		String Holidays = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Holidays.label","common_labels");
		
		String WorkingDays = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.WorkingDays.label","common_labels");

		String DayTypeList="  ,"+Select1+",0,"+alldays+",9,"+Holidays+",8,"+WorkingDays+",1,"+Monday+",2,"+Tuesday+",3,"+Wednesday+",4,"+Thursday+",5,"+Friday+",6,"+Saturday+",7,"+Sunday;
		secondItem.add("List");  //Type of item
		secondItem.add(DayTypeL);  // label
		secondItem.add("day_type");   //name of field
		secondItem.add(DayTypeList);
		secondItem.add("30");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr



        //=====================================================================
		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];

		orderByCols[0] = DispenseLocation;
		orderByCols[1] = DayTypeL;
		


		orderByColVals[0] = "DISP_LOCN_CODE";
		orderByColVals[1] = "day_type";
		



String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String TDMAttrbute=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TDMAttributes.label","ph_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

String Select=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Select.label","ph_labels");

String OrderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");

		strbuff = qrypg.getQueryPage(null, finAr, TDMAttrbute, "DispLocnTimeTableQueryResult.jsp",SortOrder, QueryCriteria,Select,OrderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
	%>
<%
 putObjectInBean(bean_id,bean,request); 
 %>
 </BODY>

