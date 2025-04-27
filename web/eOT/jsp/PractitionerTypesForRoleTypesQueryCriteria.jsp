<!DOCTYPE html>
<%@ page import ="java.sql.Connection, java.util.ArrayList,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"  %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
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
String role_type =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RoleType.label","common_labels") ;
String description =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
String practitoner_type =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionertype.label","common_labels");

StringBuffer strbuff;

Connection con=null ;
try {

   con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
		
firstItem.add("List");           //Type of item
firstItem.add(role_type);     // label
firstItem.add("role_type");   //name of field
// firstItem.add("SELECT ROLE_TYPE, ROLE_TYPE_DESC FROM OT_ROLE_TYPE ORDER BY 1"); // SIZE

firstItem.add("SELECT ROLE_TYPE, ROLE_TYPE_DESC FROM OT_ROLE_TYPE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' ORDER BY 1"); // SIZE

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(practitoner_type);    // label
secondItem.add("pract_type");  //name of field
secondItem.add("2");   // SIZE
secondItem.add("2");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");          //Type of item
thirdItem.add(description);    // label
thirdItem.add("desc_userdef");  //name of field
thirdItem.add("15");   // SIZE
thirdItem.add("15");   //LENGTH
finAr.add(thirdItem);    //add to ArrayList obj finAr

String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[3];
	orderByColVals = new String[3];

	orderByCols[0] = role_type;
	orderByCols[1] = practitoner_type;
	orderByCols[2] = description;
   // orderByCols[3] = "Select";
    
	orderByColVals[0] = "role_type";
	orderByColVals[1] = "pract_type";
	orderByColVals[2] = "desc_userdef";
	//orderByColVals[3] = "sel";
    
	
	

strbuff = qrypg.getQueryPage( con,finAr,"PractitionerTypesForRoleTypes","../../eOT/jsp/PractitionerTypesForRoleTypesQueryResult.jsp",sortorder,queryCriteria,select ,orderby,orderByCols, orderByColVals,executequery);
out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%><input type='hidden' name='locale' id='locale' value="<%=locale%>">

