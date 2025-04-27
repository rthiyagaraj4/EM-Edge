<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*" %>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<% String sStyle =
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
	Connection con=null ;

	try 
	{
		con = (Connection) session.getValue( "connection" );
	
	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		 // Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ShiftID.label","am_labels"));	 // label
	firstItem.add("shift_code");	//name of field
	firstItem.add("4");	// SIZE
	firstItem.add("4");	// LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");  		 //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SHIFT.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
	secondItem.add("shift_desc");	//name of field
	secondItem.add("30");	// SIZE
	secondItem.add("30");	// LENGTH

	finAr.add(secondItem);//add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("List");  		 //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ShiftIndicator.label","common_labels"));	  // label
	thirdItem.add("shift_indicator");	//name of field

	thirdItem.add("'',------ "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") +"------,P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Productive.label","am_labels")+",U,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unproductive.label","common_labels")+"");

	//thirdItem.add("'',&nbsp&nbsp--- Select ---,P,Productive,U,Unproductive,A,Absence,L,Leave");//static values that need to be displayed as amtion.Send it along with the value that is inserted.

	finAr.add(thirdItem);//add to ArrayList obj finAr

	ArrayList forthItem = new ArrayList();

	forthItem.add("List");  		 //Type of item
	forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProductiveFlag.label","common_labels"));	  // label
	forthItem.add("productive_flag");	//name of field

	//forthItem.add("'',------ "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") +"------,W,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels")+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels")+"");

	forthItem.add("'',---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") +"------,W,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Working.label","common_labels")+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.OnCall.label","am_labels")+",T,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Training.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.

	finAr.add(forthItem);//add to ArrayList obj finAr

	ArrayList seventhItem = new ArrayList();

	seventhItem.add("Text");  		 // Type of item
	seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ShiftMnemonic.label","am_labels"));	 // label
	seventhItem.add("mnemonic_key");	//name of field
	seventhItem.add("1");	// SIZE
	seventhItem.add("1");	// LENGTH

	finAr.add(seventhItem);//add to ArrayList obj finAr

	ArrayList fifthItem = new ArrayList();

	fifthItem.add("List");   //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Applicability.label","common_labels"));  // label
	fifthItem.add("applicable");//name
	fifthItem.add("'',---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") +"------,W,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.WorkingDays.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Non-WorkingDays.label","common_labels")+",H,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Holidays.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
	
	finAr.add(fifthItem); //add to ArrayList obj finAr

	ArrayList sixthItem = new ArrayList();

	sixthItem.add("List");   //Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	sixthItem.add("eff_status");//name
	sixthItem.add("'', " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as amtion.Send it along with the value that is inserted.
	
	finAr.add(sixthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];


	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ShiftID.label","am_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SHIFT.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ShiftIndicator.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProductiveFlag.label","common_labels");

	orderByColVals[0] = "shift_code";
	orderByColVals[1] = "LONG_DESC";
	orderByColVals[2] = "shift_indicator";
	orderByColVals[3] = "productive_flag";

	strbuff = qrypg.getQueryPage(con,finAr,"Shift","../../eAM/jsp/ShiftQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());
	} catch (Exception e) {
	
	out.println(e);

}
finally{
ConnectionManager.returnConnection(con,request);
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
