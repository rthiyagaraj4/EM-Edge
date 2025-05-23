<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<% 
request.setCharacterEncoding("UTF-8");

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
	Connection con=null ;
	try {
		con = ConnectionManager.getConnection(request);

		String SkillCode= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.SkillCode.label","rs_labels");
		ArrayList finAr = new ArrayList();
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(SkillCode);	  // label
		firstItem.add("skill_code");	//name of field
		firstItem.add("4"); //size
		firstItem.add("4"); //maxlength
		finAr.add(firstItem); //add to ArrayList obj finAr

	    String SkillDescription= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.SkillDescription.label","rs_labels");
		ArrayList secondItem = new ArrayList();
		secondItem.add("Text");   //Type of item
		secondItem.add(SkillDescription); //label
		secondItem.add("skill_desc");//name
		secondItem.add("30"); //size
		secondItem.add("30");  //maxlength
		finAr.add(secondItem); //add to ArrayList obj finAr

		
		String Nature= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String Disable_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String list_values="%,"+Both_legend+",E,"+enabled_legend+",D,"+Disable_legend;




		ArrayList thirdItem = new ArrayList();
		thirdItem.add("List");  //Type of item
		thirdItem.add(Nature);  // name of field
		thirdItem.add("eff_status");   //value of field
		thirdItem.add(list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		finAr.add(thirdItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];
		orderByCols[0] = SkillCode;
		orderByCols[1] = SkillDescription;
		orderByColVals[0] = "skill_code";
		orderByColVals[1] = "skill_desc";

		String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
		String defaultSelect=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");



		strbuff = qrypg.getQueryPage(con,finAr,"Find Skill","../jsp/SkillQueryResult.jsp",SortOrder,QueryCriteria,defaultSelect,orderBy,orderByCols,orderByColVals,ExecuteQuery);
		out.println(strbuff.toString());
	} catch (Exception e) {
		out.println(e.toString());
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
