<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, eCommon.XSSRequestWrapper, java.util.* " %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

    request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
Connection con=null ;
//String setup_bl_dtls_in_ip_yn="N";
//String facilityId = (String)session.getValue("facility_id");

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();




	firstItem.add("Text");  		//Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.uom.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	
	// label
	firstItem.add("uom");			//name of field
	firstItem.add("4");			// SIZE
	firstItem.add("4");			//LENGTH
	finAr.add(firstItem);			//add to ArrayList obj finAr
	
	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");  		 //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.uom.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	 // label
	secondItem.add("uomdesc");		 //name of field
	secondItem.add("21");			 // SIZE
	secondItem.add("20");			 //LENGTH
	finAr.add(secondItem);			 //add to ArrayList obj finAr


	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");  		 //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EquivalentUOM.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	 // label
	thirdItem.add("Equom");		 //name of field
	thirdItem.add("4");			 // SIZE
	thirdItem.add("4");			 //LENGTH
	finAr.add(thirdItem);			 //add to ArrayList obj finAr

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text");  		 //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EquivalentUOM.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	 // label
	fourthItem.add("Equomdesc");		 //name of field
	fourthItem.add("21");			 // SIZE
	fourthItem.add("20");			 //LENGTH
	finAr.add(fourthItem);			 //add to ArrayList obj finAr


String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.uom.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.uom.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EquivalentUOM.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EquivalentUOM.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");


orderByColVals[0] = "A.UOM_CODE";
orderByColVals[1] = "B.SHORT_DESC";
orderByColVals[2] = "A.EQVL_UOM_CODE";
orderByColVals[3] = "C.SHORT_DESC";



strbuff = qrypg.getQueryPage(con,finAr,"Find Code","../jsp/EquivalentiUOMQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));


out.println(strbuff.toString());
firstItem.clear();
secondItem.clear();
thirdItem.clear();
fourthItem.clear();
finAr.clear();
%>
