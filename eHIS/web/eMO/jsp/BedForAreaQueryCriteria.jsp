<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

     <%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

      <html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	  <script src='../../eCommon/js/common.js' language='javascript'></script>
	  </head><html>

<%
  request.setCharacterEncoding("UTF-8");
  ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
  StringBuffer strbuff;
  Connection con=null ;
try {

con				= ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  	//Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AreaCode.label","common_labels"));	// label
firstItem.add("area_code");	//name of field
firstItem.add("4");	// SIZE
firstItem.add("4");	//LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AreaDesc.label","mp_labels"));	  // label
secondItem.add("area_desc");	//name of field
secondItem.add("15");	// SIZE
secondItem.add("15");	//LENGTH
finAr.add(secondItem);//add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");  		 //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels"));	  // label
thirdItem.add("bed_no");	//name of field
thirdItem.add("8");	// SIZE
thirdItem.add("8");	//LENGTH
finAr.add(thirdItem);//add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();

fifthItem.add("List");   //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
fifthItem.add("EFF_STATUS");//name
fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(fifthItem); //add to ArrayList obj finAr


String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AreaCode.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AreaDesc.label","mp_labels");

orderByColVals[0] = "area_code";
orderByColVals[1] = "area_desc";


strbuff = qrypg.getQueryPage(con,finAr,"Find Service","../../eMO/jsp/BedForAreaQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
strbuff.setLength(0);

secondItem.clear();
thirdItem.clear();
fifthItem.clear();
firstItem.clear();
finAr.clear();
} catch (Exception e) {}
finally
	{
		 ConnectionManager.returnConnection(con,request);
	}
%>

