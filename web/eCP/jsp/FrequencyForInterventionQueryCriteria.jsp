<!DOCTYPE html>


<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*, eCP.*,eCommon.Common.*" %>
<% String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css"); %>
<link rel='stylesheet' type='text/css'href='../../eCommon/html/<%=sStyle%>'></link>


<body style="overflow-y:hidden">
<%
//This file is saved on 18/10/2005.
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	String intvn_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.InterventionCode.label","cp_labels");
	String intvn_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.InterventionDescription.label","cp_labels");
	String FrequencyForIntervention=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.FrequencyForIntervention.label","cp_labels");
	String freq_code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FrequencyCode.label","common_labels");
	String freq_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FrequencyDescription.label","common_labels");
	String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
	try {
		ArrayList finAr = new ArrayList();

		//================= populating the second item in the firstitem object
		ArrayList firstItem=new ArrayList();
		firstItem.add("Text");								//	Type of item
		firstItem.add(freq_code);				    //	Label
		firstItem.add("frequency_code");				    //	Name of field
		firstItem.add("4");								    //	.SIZE
		firstItem.add("4");								    //   Length
		finAr.add(firstItem);							    //	Add to ArrayList obj finAr

		//================= populating the third item in the secondItem object
		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");								       //	Type of item
		secondItem.add(freq_desc);		           //	Label
		secondItem.add("frequency_desc");						           //	Name of field
		secondItem.add("20");								               //	SIZE
		secondItem.add("20");												//	LENGTH
		finAr.add(secondItem);											//	Add to ArrayList obj finAr

		//================= populating the fourth item in the firstitem object
		ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");								       //	Type of item
		thirdItem.add(intvn_code);		           //	Label
		thirdItem.add("intervention_code");			//	Name of field
		thirdItem.add("10");
		thirdItem.add("10");								               //	SIZE
		finAr.add(thirdItem);											//	Add to ArrayList obj finAr


		//================= populating the fifth item in the firstitem object
		ArrayList fourthItem = new ArrayList();
		fourthItem.add("Text");   //Type of item
		fourthItem.add(intvn_desc);  // Label
		fourthItem.add("short_desc");//Name
		fourthItem.add("60");
		fourthItem.add("60");
	
		finAr.add(fourthItem); //add to ArrayList obj finAr
        //=====================================================================
		
		String orderByCols[] = new String[4];
		String orderByColVals[] = new String[4];

		orderByCols[0] = freq_code;
		orderByCols[1] = freq_desc;
		orderByCols[2]	=intvn_code;
		orderByCols[3]	=intvn_desc;


		orderByColVals[0] = "freq_code";
		orderByColVals[1] = "freq_desc";
    	orderByColVals[2] = "intervention_code";
		orderByColVals[3] = "short_desc";

		strbuff = qrypg.getQueryPage(null, finAr, FrequencyForIntervention, "FrequencyForInterventionQueryResult.jsp", Sort_order, QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
	//	out.println( "main " + e );//COMMON-ICN-0181
                e.printStackTrace();//COMMON-ICN-0181
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
