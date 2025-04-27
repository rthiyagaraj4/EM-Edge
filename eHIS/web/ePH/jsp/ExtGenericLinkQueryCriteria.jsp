 <!DOCTYPE html>
 <!-- 
/*
 ------------------------------------------------------------------------------------------------------------------------------
Date		Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------	
28/04/2020  IN:071537        B Haribabu                                         GHL-CRF-0614
-------------------------------------------------------------------------------------------------------------------------------
*/
 -->
<!-- Created on 23 Dec 2009 =====Shyampriya==== -->

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*,ePH.*, ePH.Common.*,eCommon.Common.*,java.util.*,java.text.SimpleDateFormat,java.sql.*,webbeans.eCommon.*" %> <!--Modified for IN:071537 -->
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<% 
    request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
	<HTML>
		<HEAD>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		</HEAD>
	</HTML>

<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
	ArrayList secondItem=new ArrayList();
	ArrayList thirdItem=new ArrayList();
	ArrayList fourthItem=new ArrayList();
	ArrayList fifthItem=new ArrayList();
	ArrayList sixthItem=new ArrayList();//Added for IN:071537
	
	//Added for IN:071537 start
    Connection con				= null;
	 
    boolean type_appl=false;
			
	try 
	{
		con						= ConnectionManager.getConnection(request);
		type_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PH_THIRDPARTY_TYPE_APPL");
	} 
	catch (Exception e) 
	{
		e.printStackTrace(System.err);
		System.out.println(" Error in Criteria Page " + e.getMessage());
	} 
	finally 
	{
		if (con != null) ConnectionManager.returnConnection(con, request);
	}
	
	//Added for IN:071537 end

//	String function_id = request.getParameter( "function_id" );
	try {
		String genericID = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.GenericID.label","ph_labels");

	

		//=============== populating the first item in the firstitem object
		
		firstItem.add("Text");  		 //Type of item
		firstItem.add(genericID);	  // label
		firstItem.add("generic_id");	//name of field
		firstItem.add("20");	// SIZE
		firstItem.add("20");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the seconditem object
		String genericName = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels");

		
		secondItem.add("Text");  //Type of item
		secondItem.add(genericName);  // label
		secondItem.add("generic_name");   //name of field
		secondItem.add("60");	// SIZE
		secondItem.add("60");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		//================= populating the third item in the thirditem object
		String product_id = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ProductID.label","ph_labels");
		

		String cims_legend = "CIMS";
		String Form_db_item_list_values="CIMS,"+cims_legend;

		thirdItem.add("List");  //Type of item
		thirdItem.add(product_id);  // label
		thirdItem.add("product_id");   //name of field
		thirdItem.add(Form_db_item_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		thirdItem.add("15");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr
		//Added for IN:071537 start
		if(type_appl){
		String type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Type.label","ph_labels");
		String type_values="%,-------Select-------,Molecule,Molecule,SubstanceClass,Substance Class,Product,Product,GGPI,GGPI,GenericItem,Generic Item,ActiveCompositionGroup,Active Composition Group";
		sixthItem.add("List");  //Type of item
		sixthItem.add(type);  // label
		sixthItem.add("type");   //name of field
		sixthItem.add(type_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		sixthItem.add("30");	//LENGTH
		finAr.add(sixthItem); //add to ArrayList obj finAr
		}
		//Added for IN:071537 end
		//================= populating the fourth item in the fourthitem object
		String ext_generic_id = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ExternalGenericID.label","ph_labels");
		
		fourthItem.add("Text");  //Type of item
		fourthItem.add(ext_generic_id);  // label
		fourthItem.add("ext_generic_id");   //name of field
		fourthItem.add("40");	// SIZE
		fourthItem.add("40");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

		//================= populating the fifth item in the fifthitem object

	   String Both_legend =     com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String Form_item_list_values="%,"+Both_legend+",E,"+enabled_legend+",D,"+Disabled_legend;

		 String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");

		
   		fifthItem.add("List");  //Type of item
		fifthItem.add(Nature);  // label
		fifthItem.add("eff_status");   //name of field
		fifthItem.add(Form_item_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		fifthItem.add("7");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr


		//=====================================================================
		String orderByCols[] = new String[4];
		String orderByColVals[] = new String[4];

		orderByCols[0] = genericID;
		orderByCols[1] = genericName;
		orderByCols[2] = product_id;
		orderByCols[3] = ext_generic_id;

		orderByColVals[0] = "generic_id";
		orderByColVals[1] = "generic_name";
		orderByColVals[2] = "product_id";
		orderByColVals[3] = "ext_prod_generic_id";

    String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
	//out.println("ExecuteQuery--->"+ExecuteQuery);
	String ExternalGenericLink=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ExternalGenericLink.label","ph_labels");

	strbuff = qrypg.getQueryPage(null, finAr,ExternalGenericLink,"ExtGenericLinkQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect, orderBy, orderByCols,orderByColVals,ExecuteQuery,true);

	out.println(strbuff.toString());

	}
		catch (java.lang.Exception exception)
			{
				out.println(exception.toString());
			}
%>
