<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.ConnectionManager,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
Connection con=null ;
try 
{
	con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");           //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ImageReferenceID.label","ca_labels"));     // label
	firstItem.add("image_ref");   //name of field
	firstItem.add("4"); // SIZE
	firstItem.add("4"); //LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");          //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ImageDescription.label","common_labels"));    // label
	secondItem.add("image_ref_desc");  //name of field
	secondItem.add("30");   // SIZE
	secondItem.add("30");   //LENGTH
	finAr.add(secondItem);    //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();
	thirdItem.add("Text");          //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ImageFilename.label","common_labels"));    // label
	thirdItem.add("image_url");  //name of field
	thirdItem.add("30");   // SIZE
	thirdItem.add("100");   //LENGTH
	finAr.add(thirdItem);    //add to ArrayList obj finAr

	ArrayList forthItem = new ArrayList();
	forthItem.add("List");   //Type of item
	forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	forthItem.add("enabled");//name
	forthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");
		
	finAr.add(forthItem); //add to ArrayList obj finAr 

	/*ArrayList fifthItem = new ArrayList();
	fifthItem.add("List");   //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ImageExists?.label","ca_labels"));  // label
	fifthItem.add("imgExists");//name
	fifthItem.add("'',"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");
		
	finAr.add(fifthItem); //add to ArrayList obj finAr fifthItem*/

	String[] orderByCols=null;
	String[] orderByColVals=null;
	orderByCols = new String[2];
	orderByColVals = new String[2];

	orderByCols[0] =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ImageReferenceID.label","ca_labels");
	orderByCols[1] =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ImageDescription.label","common_labels");
	//orderByCols[2] = "Image URL";

	orderByColVals[0] = "image_ref";
	orderByColVals[1] = "image_ref_desc";
	//orderByColVals[2] = "image_url";

	strbuff = qrypg.getQueryPage( con,finAr,"Find Clinic","../../eCA/jsp/QueryResultNoteImageList.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());

finAr.clear();
firstItem.clear();
secondItem.clear();
thirdItem.clear();
forthItem.clear();
//fifthItem.clear();
}
catch (Exception e) {
	//out.println("Exception "+e.toString());//COMMON-ICN-0181
      e.printStackTrace();//COMMON-ICN-0181
}
finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

