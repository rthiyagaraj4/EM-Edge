<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

	<%
	request.setCharacterEncoding("UTF-8");

request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	
	StringBuffer strbuff;
	Connection con=null ;
	
try {
    
	con  =  ConnectionManager.getConnection(request);
	String function = request.getParameter("function");
	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();
	firstItem.add("List");           //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels"));     // label
	firstItem.add("unit_type");   //name of field
	firstItem.add("select locn_type,short_desc from am_care_locn_type where care_locn_type_ind in ('C','E','D') and locn_type in('C','E','Y') and sys_user_def_ind='S' order by 2"); 
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList sixthItem =new ArrayList();
	sixthItem.add("Text");
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels"));
	sixthItem.add("resource_unit");
	sixthItem.add("4");
	sixthItem.add("4");
	finAr.add(sixthItem);

	ArrayList seventhItem =new ArrayList();
	seventhItem.add("Text");
	seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels"));
	seventhItem.add("resource_unit_desc");
	seventhItem.add("15");
	seventhItem.add("15");
	finAr.add(seventhItem);

	ArrayList secondItem = new ArrayList();
	secondItem.add("List");          //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourceclass.label","common_labels"));     // label
	secondItem.add("resource_class");    //name of field
	secondItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels")+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels"));  
	finAr.add(secondItem);//add to ArrayList obj finAr
	
	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");           //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResourceCode.label","common_labels"));     // label
	thirdItem.add("resource_code");   //name of field
	thirdItem.add("4");
	thirdItem.add("4");

	finAr.add(thirdItem);//add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();
	fourthItem.add("Text");   //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourcename.label","common_labels"));  // label
	fourthItem.add("resource_desc");//name
	fourthItem.add("15");
	fourthItem.add("15");
	finAr.add(fourthItem);//add to ArrayList obj finAr

	ArrayList fifthItem = new ArrayList();
	fifthItem.add("List");   //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	fifthItem.add("eff_status");//name
	fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));
	finAr.add(fifthItem);//add to ArrayList obj finAr

	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];


	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourcename.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourcename.label","common_labels");

	orderByColVals[0] = "care_locn_type_ind";
	orderByColVals[1] = "resource_class";
	orderByColVals[2] = "clinic_name";
	orderByColVals[3] = "practitioner_short_name";


	strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"Find Clinic","../../eOP/jsp/queryResourceForProcedureUnit.jsp?function="+function,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString().replaceAll("nowrap",""));
	
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	fifthItem.clear();
	sixthItem.clear();
	seventhItem.clear();
	finAr.clear();
	orderByCols = null;
	orderByColVals = null;
	
	}
	catch(Exception e ){}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request); 
	}

	%>

