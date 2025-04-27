<!DOCTYPE html>
<!--GradeQueryCriteria.jsp
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 			:
*	Created By		:	Janet George
*	Created On		:	13 Jan 2005-->
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
<html>
<head>
<link rel='stylesheet' type='text/css'
href='../../eCommon/html/<%=sStyle%>'></link>
</head>
</html>
<%	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	Connection con=null ;
	try {
    	con = ConnectionManager.getConnection(request);


		String GradeCode= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.GradeCode.label","rs_labels");

		ArrayList finAr = new ArrayList();
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(GradeCode);	  // label
		firstItem.add("grade_code");	//name of field
		firstItem.add("4"); //size
		firstItem.add("4"); //maxlength
		finAr.add(firstItem); //add to ArrayList obj finAr

     String GradeDescription= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.GradeDescription.label","rs_labels");

		ArrayList secondItem = new ArrayList();
		secondItem.add("Text");   //Type of item
		secondItem.add(GradeDescription); //label
		secondItem.add("grade_desc");//name
		secondItem.add("30"); //size
		secondItem.add("30");  //maxlength
		finAr.add(secondItem); //add to ArrayList obj finAr

	String Level= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.Level.label","rs_labels");

        ArrayList thirdItem = new ArrayList();
		thirdItem.add("Text");   //Type of item
		thirdItem.add(Level); //label
		thirdItem.add("grade_level");//name
		thirdItem.add("3"); //size
		thirdItem.add("3");  //maxlength
		finAr.add(thirdItem); //add to ArrayList obj finAr

      String Yes= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
	  String No = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
		

		String list_values="Y,"+Yes+",N,"+No;  



String ConsiderforScheduling= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.ConsiderforScheduling.label","RS_labels");
		ArrayList fourthItem = new ArrayList();
		fourthItem.add("List");  //Type of item
		fourthItem.add(ConsiderforScheduling);  // name of field
		fourthItem.add("allow_scheduling_yn");   //value of field
		fourthItem.add(list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		finAr.add(fourthItem); //add to ArrayList obj finAr

	String FTHours= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.FTHours.label","rs_labels");
        ArrayList fifthItem = new ArrayList();
		fifthItem.add("Text");   //Type of item
		fifthItem.add(FTHours); //label
		fifthItem.add("ft_work_hours");//name
		fifthItem.add("4"); //size
		fifthItem.add("3");  //maxlength
		finAr.add(fifthItem); //add to ArrayList obj finAr


		String Nature= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Enable.label","common_labels");
		String Disable_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");

		String ADR_list_values="%,"+Both_legend+",E,"+enabled_legend+",D,"+Disable_legend;




		ArrayList sixthItem = new ArrayList();
		sixthItem.add("List");   //Type of item
		sixthItem.add(Nature);  // label
		sixthItem.add("eff_status");//name
		sixthItem.add(ADR_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		finAr.add(sixthItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[3];
		String orderByColVals[] = new String[3];
		orderByCols[0] = GradeCode;
		orderByCols[1] = GradeDescription;
		orderByCols[2] = Level;

		orderByColVals[0] = "grade_code";
		orderByColVals[1] = "grade_desc";
		orderByColVals[2] = "grade_level";

String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String FindGrade=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.FindGrade.label","RS_labels");

  strbuff = qrypg.getQueryPage(con,finAr,FindGrade,"GradeQueryResult.jsp",SortOrder,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);
		out.println(strbuff.toString());

	} catch (Exception e)
	{
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
