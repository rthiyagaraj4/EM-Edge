<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

      <html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head></html>
	  <script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eSM/js/DocumentType.js' language='javascript'></script>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;

try {
	request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList(); 
firstItem.add("List");   //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Basedon.label","common_labels"));  // label
firstItem.add("basedon");//name
firstItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.AcctEntity.label","common_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.facility.label","common_labels"));
	finAr.add(firstItem);



ArrayList secondItem = new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DocType.label","sm_labels"));	// label
secondItem.add("doctype");	//name of field
secondItem.add("6");	// SIZE
secondItem.add("6");	//LENGTH
finAr.add(secondItem);//add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();
thirdItem.add("Text");  	//Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels"));	// label
thirdItem.add("longdescription");	//name of field
thirdItem.add("30");	// SIZE
thirdItem.add("100");	//LENGTH
finAr.add(thirdItem);//add to ArrayList obj finAr


ArrayList fourthItem = new ArrayList();
fourthItem.add("Text");  	//Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels"));	// label
fourthItem.add("shortdescription");	//name of field
fourthItem.add("15");	// SIZE
fourthItem.add("40");	//LENGTH
finAr.add(fourthItem);//add to ArrayList obj finAr




String orderByCols[] = new String[4]; 
String orderByColVals[] = new String[4];  

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Basedon.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DocType.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels");

orderByColVals[0] = "A.ENTITY_OR_FACILITY_BASED";
orderByColVals[1] = "DOC_TYPE_CODE";
orderByColVals[2] = "LONG_DESC";
orderByColVals[3] = "SHORT_DESC";

strbuff = qrypg.getQueryPage(con,finAr,"Find Service","../jsp/DocumentTypeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,"Execute Query");

out.println(strbuff.toString());

        strbuff.setLength(0);
		finAr.clear();
        firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();

}catch(Exception e){out.println(e);e.printStackTrace();}
			finally { 
	ConnectionManager.returnConnection(con,request);
}
%>

