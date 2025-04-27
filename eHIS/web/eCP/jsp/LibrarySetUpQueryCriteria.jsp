<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,eCP.*" contentType="text/html; charset=UTF-8" %>
<BODY style="overflow-y:hidden">
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
 request.setCharacterEncoding("UTF-8");
//This file is saved on 18/10/2005.
String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css"); 
%>
<link rel='stylesheet' type='text/css'href='../../eCommon/html/<%=sStyle%>'></link>

<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();

	try {
		ArrayList finAr = new ArrayList();
		String lib_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.LibraryID.label","cp_labels");
		String lib_des=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.LibraryDescription.label","cp_labels");
		String ver_no=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.VersionNo.label","cp_labels");
		String status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels");
		String all=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
		String draft=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.Draft.label","cp_labels");
		String inactive=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inactive.label","common_labels");
		String fin=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.final.label","common_labels");
		String status_list="%,"+all+",D,"+draft+",I,"+inactive+",F,"+fin;
		String lib=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.Library.label","cp_labels");
		String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String Enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String Nature_List="%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");							//	Type of item
		firstItem.add(lib_id);				//	Label
		firstItem.add("LIBRARY_ID");				//	Name of field
		firstItem.add("20");								//	SIZE
		firstItem.add("20");								//	LENGTH
		finAr.add(firstItem);							//	Add to ArrayList obj finAr

		//================= populating the second item in the firstitem object
		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");									//	Type of item
		secondItem.add(lib_des);					    //	Label
		secondItem.add("SHORT_DESC");					    //	Name of field
		secondItem.add("60");									    //	.SIZE
		secondItem.add("60");									    //   Length
		finAr.add(secondItem);									    //	Add to ArrayList obj finAr

		//================= populating the third item in the firstitem object
		ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");								       //	Type of item
		thirdItem.add(ver_no);		           //	Label
		thirdItem.add("VERSION_NO");						           //	Name of field
		thirdItem.add("5");								               //	SIZE
		thirdItem.add("5");												//	LENGTH
		finAr.add(thirdItem);											//	Add to ArrayList obj finAr

		//================= populating the fourth item in the firstitem object
		ArrayList fourthItem=new ArrayList();
		fourthItem.add("List");								       //	Type of item
		fourthItem.add(status);		           //	Label
		fourthItem.add("STATUS");			//	Name of field
		fourthItem.add(status_list);
		fourthItem.add("5");								               //	SIZE
		fourthItem.add("5");												//	LENGTH
		finAr.add(fourthItem);											//	Add to ArrayList obj finAr
		

	//================= populating the fifth item in the firstitem object
		ArrayList fifthItem = new ArrayList();
		fifthItem.add("List");   //Type of item
		fifthItem.add(Nature);  // Label
		fifthItem.add("EFF_STATUS");//Name
		fifthItem.add(Nature_List);
	
	finAr.add(fifthItem); //add to ArrayList obj finAr
        //=====================================================================
		String orderByCols[] = new String[4];
		String orderByColVals[] = new String[4];

		orderByCols[0] = lib_id;
		orderByCols[1] = lib_des;
		orderByCols[2] = ver_no;
		orderByCols[3]	=	status;
		


		orderByColVals[0] = "LIBRARY_ID";
		orderByColVals[1] = "SHORT_DESC";
		orderByColVals[2] = "VERSION_NO";
		orderByColVals[3] = "STATUS";
		

		strbuff = qrypg.getQueryPage(null, finAr, lib , "LibrarySetUpQueryResult.jsp", Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols,orderByColVals,ExecuteQuery);

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
