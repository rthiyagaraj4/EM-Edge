<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet, java.util.ArrayList,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
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
String name =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels");
String transfer =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transfer.label","common_labels");
String cancel =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels");
String login =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.login.label","common_labels");
String book =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Book.Label","ot_labels");
String override_speciality_restriction =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OverrideSpecialtyRestriction.Label","ot_labels");
String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String  yes=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
String no =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");

StringBuffer strbuff;

Connection con=null ;
try {

   con  =  ConnectionManager.getConnection(request);
ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();
		
firstItem.add("Text");           //Type of item
firstItem.add(login);     // label
firstItem.add("appl_user_id");   //name of field
firstItem.add("30"); // SIZE
firstItem.add("30");
//LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");          //Type of item
secondItem.add(name);    // label
secondItem.add("appl_user_name");  //name of field
secondItem.add("30");   // SIZE
secondItem.add("30");   //LENGTH
finAr.add(secondItem);    //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("List");          //Type of item
thirdItem.add(book);    // label
thirdItem.add("book_schedule_yn");  //name of field
 // SIZE
thirdItem.add("B,"+both+",Y,"+yes+",N,"+no);   //LENGTH
finAr.add(thirdItem);    //add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("List");          //Type of item
fourthItem.add(transfer);    // label
fourthItem.add("transfer_schedule_yn");  //name of field
 // SIZE
fourthItem.add("B,"+both+",Y,"+yes+",N,"+no);   //LENGTH
finAr.add(fourthItem);    //add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();

fifthItem.add("List");          //Type of item
fifthItem.add(cancel);    // label
fifthItem.add("cancel_schedule_yn");  //name of field
 // SIZE
fifthItem.add("B,"+both+",Y,"+yes+",N,"+no);   //LENGTH
finAr.add(fifthItem);    //add to ArrayList obj finAr

ArrayList sixthItem = new ArrayList();

sixthItem.add("List");   //Type of item
sixthItem.add(override_speciality_restriction);  // label
sixthItem.add("overide_splty_restriction_yn");//name
sixthItem.add("B,"+both+",Y,"+yes+",N,"+no);//static values that need to be displayed as 
finAr.add(sixthItem);

String[] orderByCols=null;
String[] orderByColVals=null;

	orderByCols = new String[2];
	orderByColVals = new String[2];

	orderByCols[0] = login;
	orderByCols[1] = name;
	
   

	orderByColVals[0] = "appl_user_id";
	orderByColVals[1] = "appl_user_name";
	
	


strbuff = qrypg.getQueryPage( con,finAr,"BookingRights ","../../eOT/jsp/BookingRightsQueryResult.jsp",sortorder,queryCriteria,select ,orderby,orderByCols, orderByColVals,executequery);
out.println(strbuff.toString());
} catch (Exception e) {e.printStackTrace();}

finally
{
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%><input type='hidden' name='locale' id='locale' value="<%=locale%>">

