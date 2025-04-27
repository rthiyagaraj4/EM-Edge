<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.ArrayList,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>


<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
String sortorder =
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ; 
String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String role_id =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.RoleID.Label","ot_labels") ;
String role_type =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RoleType.label","common_labels") ;
String applicable_for_ot_state =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ApplicableForOTSlate.Label","ot_labels") ;
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String all =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
String  yes=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
String no =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
String enabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
String description =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
String nature =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");

StringBuffer strbuff;

Connection con=null ;
try {

   con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
		
firstItem.add("Text");           //Type of item
firstItem.add(role_id);     // label
firstItem.add("role_id");   //name of field
firstItem.add("20"); // SIZE
firstItem.add("20"); //LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(description);    // label
secondItem.add("role_desc");  //name of field
secondItem.add("30");   // SIZE
secondItem.add("30");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("List");          //Type of item
thirdItem.add(role_type);    // label
thirdItem.add("role_type");  //name of field
//thirdItem.add("SELECT ROLE_TYPE, ROLE_TYPE_DESC FROM OT_ROLE_TYPE ORDER BY ROLE_TYPE_DESC");   // SIZE

thirdItem.add("SELECT ROLE_TYPE, ROLE_TYPE_DESC FROM OT_ROLE_TYPE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' ORDER BY ROLE_TYPE_DESC");   // SIZE


 //LENGTH
finAr.add(thirdItem);    //add to ArrayList obj finAr



ArrayList fourthItem = new ArrayList();

fourthItem.add("List");   //Type of item
fourthItem.add(applicable_for_ot_state);  // label
fourthItem.add("appl_to_ot_slate");//name
fourthItem.add("all,"+all+",Y,"+yes+",N,"+no);//static values that need to be displayed as 
finAr.add(fourthItem);

ArrayList fifthItem = new ArrayList();

fifthItem.add("List");
fifthItem.add(nature);
fifthItem.add("status");
fifthItem.add("B,"+both+",E,"+enabled+",D,"+disabled);
finAr.add(fifthItem);


String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[3];
	orderByColVals = new String[3];

	orderByCols[0] = role_id;
	orderByCols[1] = description;
	orderByCols[2] = role_type;
    

	orderByColVals[0] = "role_id";
	orderByColVals[1] = "role_desc";
	orderByColVals[2] = "role_type_desc";
	


strbuff = qrypg.getQueryPage( con,finAr,"Roles ","../../eOT/jsp/RolesQueryResult.jsp",sortorder,queryCriteria,select ,orderby,orderByCols, orderByColVals,executequery);
out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
