	<!--
Fine Tuning
-->
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*,ePH.*" %>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<% 
        request.setCharacterEncoding("UTF-8");
	    //String locale			= (String)session.getAttribute("LOCALE");
	    
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

<%
	String licenceRights = PhLicenceRights.getKey();
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	try {

		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();
		String DrugScheduleID = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugScheduleID.label","ph_labels");
		firstItem.add("Text");  		 //Type of item
		firstItem.add(DrugScheduleID);// label
		firstItem.add("schedule_id");//name of field
		firstItem.add("1");	// SIZE
		firstItem.add("2");	//LENGTH
		
		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the firstitem object
		ArrayList secondItem=new ArrayList();

		String DrugScheduleDescription = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugScheduleDescription.label","ph_labels");

		secondItem.add("Text");  //Type of item
		secondItem.add(DrugScheduleDescription);  // label
		secondItem.add("schedule_desc");   //name of field
		secondItem.add("22");	// SIZE
		secondItem.add("20");	//LENGTH
		
		finAr.add(secondItem); //add to ArrayList obj finAr

		//==============================================
		ArrayList thirdItem=new ArrayList();
	String AuthorizationRequiredForOrdering = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AuthorizationRequiredForOrdering.label","ph_labels");

		  String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String yes = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
		String No = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
		String tpn_item_list_values="B,"+Both_legend+",Y,"+yes+",N,"+No;
		String Nature_list_values="B,"+Both_legend+",E,"+yes+",D,"+No;
 
		thirdItem.add("List");  //Type of item
		thirdItem.add(AuthorizationRequiredForOrdering);  // label
		thirdItem.add("order_auth_reqd_yn");   //name of field
		thirdItem.add(tpn_item_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		thirdItem.add("7");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr
		
		//===================================================
		ArrayList fourthItem=new ArrayList();

	 String CosignRequiredForOrdering = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.CosignRequiredForOrdering.label","ph_labels");
		fourthItem.add("List");  //Type of item
		fourthItem.add(CosignRequiredForOrdering);  // label
		fourthItem.add("order_cosign_reqd_yn");   //name of field
		fourthItem.add(tpn_item_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		fourthItem.add("7");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr
		//===================================================
		ArrayList fifthItem=new ArrayList();
        String SpecialApprovalRequired = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecialApprovalRequired.label","common_labels");
		fifthItem.add("List");  //Type of item
		fifthItem.add(SpecialApprovalRequired);  // label
		fifthItem.add("spl_appr_reqd_yn");   //name of field
		fifthItem.add(tpn_item_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		fifthItem.add("7");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr
		//===================================================
		ArrayList sixthItem=new ArrayList();

	   String AllowRefill = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AllowRefill.label","ph_labels");
		sixthItem.add("List");  //Type of item
		sixthItem.add(AllowRefill);  // label
		sixthItem.add("repeat_single_cont_order_yn");   //name of field
		sixthItem.add(tpn_item_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		sixthItem.add("7");	//LENGTH
		finAr.add(sixthItem); //add to ArrayList obj finAr
		//===================================================
		
		if (!licenceRights.equals("PHBASIC")){
			String AuthorizationRequiredForDispensing = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.AuthorizationRequiredForDispensing.label","ph_labels");
			ArrayList seventhItem=new ArrayList();
			seventhItem.add("List");  //Type of item
			seventhItem.add(AuthorizationRequiredForDispensing);  // label
			seventhItem.add("disp_auth_reqd_yn");   //name of field
			seventhItem.add(tpn_item_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
			seventhItem.add("7");	//LENGTH
			finAr.add(seventhItem); //add to ArrayList obj finAr
		}
		//===================================================
		ArrayList eigthItem=new ArrayList();

        String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		eigthItem.add("List");  //Type of item
		eigthItem.add(Nature);  // label
		eigthItem.add("eff_status");   //name of field
		eigthItem.add(Nature_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		eigthItem.add("7");	//LENGTH
		finAr.add(eigthItem); //add to ArrayList obj finAr
		
		
		//=====================================================================
		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];

		orderByCols[0] = DrugScheduleID;
		orderByCols[1] = DrugScheduleDescription;
				
		
		orderByColVals[0] = "SCHEDULE_ID";
		orderByColVals[1] = "SCHEDULE_DESC";
			
		
 String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String DrugCategory=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugCategory.label","ph_labels");
    
  strbuff = qrypg.getQueryPage(null, finAr, DrugCategory, "DrugScheduleQueryResult.jsp", Sort_order,QueryCriteria,defaultSelect,orderBy, orderByCols, orderByColVals,ExecuteQuery );

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}
%>
