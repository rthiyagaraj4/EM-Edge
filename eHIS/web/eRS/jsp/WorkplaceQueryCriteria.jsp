<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
checkForNull((String)session.getAttribute("PREFERRED_STYLE"),
"IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type='text/css'
href='../../eCommon/html/<%=sStyle%>'></link>
</head>
</html>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
		
	StringBuffer strbuff;
	String defaultSelect="";
	Connection con =null;
	Connection connection = ConnectionManager.getConnection(request);
	PreparedStatement stmt = null;
	ResultSet rs=null;
	
	StringBuffer strBuff = new StringBuffer();

    try
	{
	//String query = "select locn_type,short_desc from am_care_locn_type";
	String query = "SELECT locn_type,short_desc FROM am_care_locn_type_lang_vw where language_id like ?";
	stmt = connection.prepareStatement(query);
	stmt.setString(1,locale);
	rs = stmt.executeQuery();
	while(rs.next())
	{
		strBuff.append(",");
		strBuff.append(rs.getString("locn_type"));
		strBuff.append(",");
		strBuff.append(rs.getString("short_desc"));
	}
	}
	catch (Exception e) {out.println(e.toString());}
	finally
	{
		try
		{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		}
	    catch(Exception e)
		{
			out.println(e.toString());
		}
	}
	try 
	{

		String LocationType= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels");
		defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");

	ArrayList finAr = new ArrayList();

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("List");  		 //Type of item
	thirdItem.add(LocationType);	  // label
	thirdItem.add("locn_type");	//name of field
	thirdItem.add("'',&nbsp---"+defaultSelect+"----"+strBuff.toString());//static values that need to be displayed as amtion.Send it along with the value that is inserted.

	finAr.add(thirdItem);//add to ArrayList obj finAr

	String WorkplaceCode= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.WorkplaceCode.label","rs_labels");
	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		 // Type of item
	firstItem.add(WorkplaceCode);	 // label
	firstItem.add("workplace_code");	//name of field
	firstItem.add("15");	// SIZE
	firstItem.add("15");	// LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	String WorkplaceDescription= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.WorkplaceDescription.label","rs_labels");
	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");  		 //Type of item
	secondItem.add(WorkplaceDescription);	  // label
	secondItem.add("workplace_desc");	//name of field
	secondItem.add("20");	// SIZE
	secondItem.add("20");	// LENGTH

	finAr.add(secondItem);//add to ArrayList obj finAr


	String Nature= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String Disable_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String list_values="%,"+Both_legend+",E,"+enabled_legend+",D,"+Disable_legend;

	ArrayList forthItem = new ArrayList();
	forthItem.add("List");   //Type of item
	forthItem.add(Nature);  // label
	forthItem.add("eff_status");//name
	forthItem.add(list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
	finAr.add(forthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[3];
	String orderByColVals[] = new String[3];


	orderByCols[0] = WorkplaceCode;
	orderByCols[1] = WorkplaceDescription;
	
	orderByCols[2] = LocationType;

	orderByColVals[0] = "workplace_code";
	orderByColVals[1] = "workplace_desc";
	orderByColVals[2] = "a.locn_type";


	String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

// defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");



	strbuff = qrypg.getQueryPage(con,finAr,"Shift","../../eRS/jsp/WorkplaceQueryResult.jsp",SortOrder,QueryCriteria,defaultSelect ,orderBy ,orderByCols, orderByColVals,ExecuteQuery);

	out.println(strbuff.toString());
	}
	catch(Exception e)
	{
		out.println(e.toString());
	}
	finally
	{
		try
		{
		ConnectionManager.returnConnection(con,request);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}
%>
<%!
	// By Annadurai 2/23/2004 starts., to handle NullPointerException.
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>
