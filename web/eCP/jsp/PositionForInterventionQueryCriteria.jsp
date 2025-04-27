<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*" %>
<% String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css"); %>
<link rel='stylesheet' type='text/css'href='../../eCommon/html/<%=sStyle%>'></link>

<BODY style="overflow-y:hidden">
<%
//This file is saved on 18/10/2005.
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	String pos_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PositionCode.label","common_labels");
	String pos_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PositionDescription.label","common_labels");
	String intvn_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.InterventionCode.label","cp_labels");
	String intvn_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.InterventionDescription.label","cp_labels");
	String roll_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RoleType.label","common_labels");		
	String practitioner=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");		
	String oth_staff=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OtherStaff.label","common_labels");		
	String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
	String PositionForIntervention=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.PositionForIntervention.label","cp_labels");
	try {
		ArrayList finAr = new ArrayList();

		
		//================= populating the second item in the firstitem object
		ArrayList firstItem=new ArrayList();
		firstItem.add("Text");									//	Type of item
		firstItem.add(pos_code);					    //	Label
		firstItem.add("position_code");					    //	Name of field
		firstItem.add("10");									    //	.SIZE
		firstItem.add("10");									    //   Length
		finAr.add(firstItem);									    //	Add to ArrayList obj finAr

		//================= populating the third item in the secondItem object
		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");								       //	Type of item
		secondItem.add(pos_desc);		           //	Label
		secondItem.add("position_desc");						           //	Name of field
		secondItem.add("30");								               //	SIZE
		secondItem.add("30");												//	LENGTH
		finAr.add(secondItem);											//	Add to ArrayList obj finAr
		//=============== populating the first item in the thirdItem object
		ArrayList thirdItem = new ArrayList();
		thirdItem.add("List");							//	Type of item
		thirdItem.add(roll_type);				//	Label
		thirdItem.add("role_type");				//	Name of field
		thirdItem.add("P,"+practitioner+",O,"+oth_staff);								//	SIZE
		finAr.add(thirdItem);							//	Add to ArrayList obj finAr


		//================= populating the fourth item in the firstitem object
		ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");								       //	Type of item
		fourthItem.add(intvn_code);		           //	Label
		fourthItem.add("intervention_code");			//	Name of field
		fourthItem.add("10");
		fourthItem.add("10");								               //	SIZE
		finAr.add(fourthItem);											//	Add to ArrayList obj finAr


		//================= populating the fifth item in the firstitem object
		ArrayList fifthItem = new ArrayList();
		fifthItem.add("Text");   //Type of item
		fifthItem.add(intvn_desc);  // Label
		fifthItem.add("short_desc");//Name
		fifthItem.add("60");
		fifthItem.add("60");
	
		finAr.add(fifthItem); //add to ArrayList obj finAr
        //=====================================================================

		String orderByCols[] = new String[5];
		String orderByColVals[] = new String[5];

		orderByCols[0]  =  pos_code;
		orderByCols[1]  =   pos_desc;
		orderByCols[2]  =   roll_type;
		orderByCols[3]	=	intvn_code;
		orderByCols[4]	=	intvn_desc;


		orderByColVals[0] = "position_code";
		orderByColVals[1] = "position_desc";
		orderByColVals[2] = "role_type";
    	orderByColVals[3] = "intervention_code";
		orderByColVals[4] = "short_desc";

		strbuff = qrypg.getQueryPage(null, finAr, PositionForIntervention , "PositionForInterventionQueryResult.jsp", Sort_order, QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
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
