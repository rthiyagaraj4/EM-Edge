<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head></html>


<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
String fmode = request.getParameter("mode") ;
StringBuffer strbuff;
Connection con=null ;
try {
con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();


ArrayList firstItem=new ArrayList();

firstItem.add("Text");  //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.WaitlistCategoryCode.label","oa_labels"));  // label
firstItem.add("WAITLIST_CATEGORY_CODE");   //name of field
firstItem.add("4");	// SIZE
firstItem.add("4");	//LENGTH

finAr.add(firstItem); //add to ArrayList obj finAr


ArrayList secondItem=new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.WaitlistCategoryDescription.label","oa_labels"));  // label
secondItem.add("WAITLIST_CATEGORY_DESC");   //name of field
secondItem.add("30");	// SIZE
secondItem.add("30");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr




ArrayList thirdItem=new ArrayList();

thirdItem.add("Text");  //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));  // label10
thirdItem.add("SPECIALTY_CODE");   //name of field
thirdItem.add("4");
thirdItem.add("4");

finAr.add(thirdItem); //add to ArrayList obj finAr

ArrayList forthItem=new ArrayList();

forthItem.add("Text");  //Type of item
forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SpecialityDesc.label","mp_labels"));  // label10
forthItem.add("SPECIALTY_DESC");   //name of field
forthItem.add("30");
forthItem.add("30");

finAr.add(forthItem); //add to ArrayList obj finAr



String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.WaitlistCategoryCode.label","oa_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.WaitlistCategoryDescription.label","oa_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SpecialityDesc.label","mp_labels");


orderByColVals[0] = "waitlist_category_code";
orderByColVals[1] = "waitlist_category_desc";
orderByColVals[2] = "specialty_code";
orderByColVals[3] = "specialty_desc";


strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"eCIS Testing","../../eOA/jsp/WaitlistCategoryForSpltyQryResult.jsp?mode="+fmode,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

String styleString = " style=\"display: block; width: 78%;\"";
String searchString = "value='---->'";
int index = strbuff.indexOf(searchString);
        
if (index != -1) {
    int insertPosition = index + searchString.length();
    strbuff.insert(insertPosition, styleString);
}

out.println(strbuff.toString());
strbuff.setLength(0);
finAr.clear();
firstItem.clear();
secondItem.clear();
thirdItem.clear();
forthItem.clear();

} catch (Exception e) {}
finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
	}

%>
<script>

</script>
