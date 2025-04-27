<!DOCTYPE html>

<%
/*
*
*	Application		:	eAM
*   File Name       :	DispositionTypeQueryCriteria.jsp
*	
*
*	Created On		:	19-02-2005
*/
%>

<%@ page import ="java.sql.*, java.util.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</html></head>
<%
	request.setCharacterEncoding("UTF-8");
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;
	Connection con=null ; 
	Connection conn=null ; //Added by Mano aganist ML-MMOH-CRF-0783
	Boolean isDidCallNotAroundDgnNotAppl; //Added by Mano aganist ML-MMOH-CRF-0783

	try 
	{
		con = (Connection) session.getValue( "connection" );
		conn = ConnectionManager.getConnection(request);
		isDidCallNotAroundDgnNotAppl = CommonBean.isSiteSpecific(conn, "AE", "DID_CALLNOTAROUND_NOT_REQ_DGN"); //Added by Mano aganist ML-MMOH-CRF-0783

	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		 // Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DispType.label","common_labels"));	 // label
	firstItem.add("disp_type");	//name of field
	firstItem.add("2");	// SIZE
	firstItem.add("2");	// LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");  		 //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DispType.label","common_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
	secondItem.add("short_desc");	//name of field
	secondItem.add("30");	// SIZE
	secondItem.add("30");	// LENGTH

	finAr.add(secondItem);//add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("List");  		 //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.DeceasedIndicator.label","am_labels"));	  // label
	thirdItem.add("deceased_yn");	//name of field
	thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.

	finAr.add(thirdItem);//add to ArrayList obj finAr

	//Added by Sangeetha for ML-MMOH-CRF-0630
	ArrayList seventhItem = new ArrayList();

	seventhItem.add("List");  		 //Type of item
	seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.AbscondedIndicator.label","am_labels"));	  // label
	seventhItem.add("absconded_indicator");	//name of field
	seventhItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.

	finAr.add(seventhItem);//add to ArrayList obj finAr
	
	//Added by Mano aganist ML-MMOH-CRF-0783
	
	if(isDidCallNotAroundDgnNotAppl)
	{
	ArrayList eightItem = new ArrayList();

	eightItem.add("List");  		 //Type of item
	eightItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.CallNotAroundIndicator.label","am_labels"));	  // label
	eightItem.add("callnotaround_yn");	//name of field
	eightItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.

	finAr.add(eightItem);//add to ArrayList obj finAr
    }
	ArrayList forthItem = new ArrayList();

	forthItem.add("List");  		 //Type of item
	forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.UseatVisitConclusion.label","am_labels"));	  // label
	forthItem.add("use_at_concl_yn");	//name of field
	forthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.

	finAr.add(forthItem);//add to ArrayList obj finAr

	ArrayList fifthItem = new ArrayList();

	fifthItem.add("List");   //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.UseforMaternalDeath.label","am_labels"));  // label
	fifthItem.add("use_at_disch_yn");//name
	fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
	
	finAr.add(fifthItem); //add to ArrayList obj finAr

	ArrayList sixthItem = new ArrayList();

	sixthItem.add("List");   //Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	sixthItem.add("eff_status");//name
	sixthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
	
	finAr.add(sixthItem); //add to ArrayList obj finAr
	
	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];


	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DispType.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DispType.label","common_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

	orderByColVals[0] = "disp_type";
	orderByColVals[1] = "long_desc";
	
	strbuff = qrypg.getQueryPage(con,finAr,"Find Disposition Type","../../eAM/jsp/DispositionTypeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

	out.println(strbuff.toString());

	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	forthItem.clear();
	fifthItem.clear();
	sixthItem.clear();
	seventhItem.clear();
	finAr.clear();
	} 
	catch (Exception e) {
		
	} finally{
		if(conn != null) 
		ConnectionManager.returnConnection(conn,request);
		if(con != null)  ConnectionManager.returnConnection(con,request);//Added for check style for COMMON-ICN-0056
	}
%>

