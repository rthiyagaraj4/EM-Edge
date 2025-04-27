<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  contentType="text/html;charset=UTF-8"  import ="webbeans.eCommon.*,java.sql.*, java.util.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
	request.setCharacterEncoding("UTF-8");
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	//String locale			= (String)session.getAttribute("LOCALE");
	StringBuffer strbuff;
	Connection con	= null;
	Statement stmt	= null;
	ResultSet rs	= null;

try 
{
		con = ConnectionManager.getConnection(request);	
		stmt = con.createStatement();

		ArrayList finAr = new ArrayList();


	ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.CurrencyCode.label","sm_labels"));	  // label
		firstItem.add("currency_code");	//name of field
		firstItem.add("4");	// SIZE
		firstItem.add("4");	//LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr	

	ArrayList ninthItem=new ArrayList();
		ninthItem.add("Text");  //Type of item
		ninthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels"));  // label
		ninthItem.add("short_desc");   //name of field
		ninthItem.add("15");
		ninthItem.add("15");
	finAr.add(ninthItem); //add to ArrayList obj finAr	

	ArrayList seventhItem=new ArrayList();
		seventhItem.add("Text");  //Type of item
		seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels"));  // label
		seventhItem.add("long_desc");   //name of field
		seventhItem.add("30");
		seventhItem.add("30");
	finAr.add(seventhItem); //add to ArrayList obj finAr

	
	

	String orderByCols[] = new String[3];
	String orderByColVals[] = new String[3];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.CurrencyCode.label","sm_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels"); 
	

	orderByColVals[0] = "currency_code";
	orderByColVals[1] = "short_desc";	
	orderByColVals[2] = "long_desc";


	strbuff = qrypg.getQueryPage(con,finAr,"FOREIGN_CURRENCY","ForeignCurrQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());

	if(rs != null) rs.close();
	if(stmt != null) stmt.close();

}catch (Exception e) 
{
	out.println(e);
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

%>

<%!
	
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>
