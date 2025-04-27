<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

    <html><head>
   <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");

%>
 
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<% 
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con		= null ;
String pat_ser_grp_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSeriesCode.label","mp_labels");
String pat_ser_grp_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSerieDesc.label","mp_labels");

String blng_grp_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BillingGroup.label","common_labels");
String blng_grp_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.BLNG_GRP_DESC.label","bl_labels");

String payer_grp_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PAYER_GROUP_CODE.label","bl_labels");
String payer_grp_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PAYER_GROUP_DESC.label","bl_labels");

String payer_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PAYER_CODE.label","bl_labels");
String payer_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PAYER_DESC.label","bl_labels");

String serv_panel_ind =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.BILLING_SERVICE_PANEL.label","bl_labels"); 
String serv_panel_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.SERV_PANEL_CODE.label","bl_labels");
String serv_panel_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.SERV_PANEL_DESC.label","bl_labels");

try 
{ 
	con				= ConnectionManager.getConnection(request);
	ArrayList finAr 	= new ArrayList();

	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  		//Type of item
	firstItem.add(pat_ser_grp_code);		//label
	firstItem.add("pat_ser_grp_code");		//name of field
	firstItem.add("2");				// SIZE
	firstItem.add("2");			    //LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem	= new ArrayList();
	secondItem.add("Text");  //Type of item
	secondItem.add(pat_ser_grp_desc);  // label
	secondItem.add("pat_ser_grp_desc");   //name of field
	secondItem.add("15");	// SIZE
	secondItem.add("15");	//LENGTH

	finAr.add(secondItem); //add to ArrayList obj finAr

	ArrayList thirdItem	= new ArrayList();

	thirdItem.add("Text");  //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BillingGroup.label","common_labels"));  // label
	thirdItem.add("blng_grp_id");   //name of field
	thirdItem.add("4");	// SIZE
	thirdItem.add("4");	//LENGTH

	finAr.add(thirdItem); //add to ArrayList obj finAr

	ArrayList forthItem	= new ArrayList();

	forthItem.add("Text");  //Type of item
	forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.BLNG_GRP_DESC.label","bl_labels"));  // label
	forthItem.add("blng_grp_desc");   //name of field
	forthItem.add("40");	// SIZE
	forthItem.add("40");	//LENGTH

	finAr.add(forthItem); //add to ArrayList obj finAr

    ArrayList fifthItem	= new ArrayList();
	fifthItem.add("Text");  //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PAYER_GROUP_CODE.label","bl_labels"));  // label
	fifthItem.add("payer_grp_code");   //name of field
	fifthItem.add("2");	// SIZE
	fifthItem.add("2");	//LENGTH

	finAr.add(fifthItem); //add to ArrayList obj finAr

	ArrayList sixthItem	 = new ArrayList();
	sixthItem.add("Text");  //Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PAYER_GROUP_DESC.label","bl_labels"));  // label
	sixthItem.add("payer_grp_desc");   //name of field
	sixthItem.add("15");	// SIZE
	sixthItem.add("15");	//LENGTH

	finAr.add(sixthItem); //add to ArrayList obj finAr

    ArrayList seventhItem	= new ArrayList();
	seventhItem.add("Text");  //Type of item
	seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PAYER_CODE.label","bl_labels"));  // label
	seventhItem.add("payer_code");   //name of field
	seventhItem.add("8");	// SIZE
	seventhItem.add("8");	//LENGTH

	finAr.add(seventhItem); //add to ArrayList obj finAr

	ArrayList eighthItem	 = new ArrayList();
	eighthItem.add("Text");  //Type of item
	eighthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PAYER_DESC.label","bl_labels"));  // label
	eighthItem.add("payer_desc");   //name of field
	eighthItem.add("40");	// SIZE
	eighthItem.add("40");	//LENGTH

	finAr.add(eighthItem); //add to ArrayList obj finAr

	ArrayList ninthItem	 = new ArrayList();
	ninthItem.add("List");  //Type of item
	ninthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.BILLING_SERVICE_PANEL.label","ae_labels"));  // label
	ninthItem.add("serv_panel_ind"); //name  of field
	ninthItem.add("S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+",L,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Panel.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
	finAr.add(ninthItem); //add to ArrayList obj finAr

	ArrayList tenthItem	 = new ArrayList();
	tenthItem.add("Text");  //Type of item
	tenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.SERV_PANEL_CODE.label","bl_labels"));  // label
	tenthItem.add("serv_panel_code");   //name of field
	tenthItem.add("10");	// SIZE
	tenthItem.add("10");	//LENGTH

	finAr.add(tenthItem); //add to ArrayList obj finAr

	ArrayList eleventhItem	 = new ArrayList();
	eleventhItem.add("Text");  //Type of item
	eleventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.SERV_PANEL_DESC.label","bl_labels"));  // label
	eleventhItem.add("serv_panel_desc");   //name of field
	eleventhItem.add("40");	// SIZE
	eleventhItem.add("40");	//LENGTH

	finAr.add(eleventhItem); //add to ArrayList obj finAr

	String orderByCols[] 	= new String[11];
	String orderByColVals[] = new String[11];

	orderByCols[0] 		 = pat_ser_grp_code;
	orderByCols[1]		 = pat_ser_grp_desc;
	orderByCols[2] 		 = blng_grp_id;
	orderByCols[3]		 = blng_grp_desc;
	orderByCols[4] 		 = payer_grp_code;
	orderByCols[5]		 = payer_grp_desc;
	orderByCols[6] 		 = payer_code;
	orderByCols[7]		 = payer_desc;
	orderByCols[8]		 = serv_panel_ind;
	orderByCols[9] 		 = serv_panel_code;
	orderByCols[10]		 = serv_panel_desc;
	orderByColVals[0] 	 = "pat_ser_grp_code";
	orderByColVals[1] 	 = "pat_ser_grp_desc";
	orderByColVals[2] 	 = "blng_grp_id";
	orderByColVals[3] 	 = "blng_grp_desc";
	orderByColVals[4] 	 = "payer_grp_code";
	orderByColVals[5] 	 = "payer_grp_desc";
	orderByColVals[6] 	 = "payer_code";
	orderByColVals[7] 	 = "payer_desc";
	orderByColVals[8] 	 = "serv_panel_ind";
	orderByColVals[9] 	 = "serv_panel_code";
	orderByColVals[10] 	 = "serv_panel_desc";

	strbuff = qrypg.getQueryPage(con,finAr,"Find Site" ,"../../eBL/jsp/BLPatRegBlngDtlsQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());
	strbuff.setLength(0);
	if(finAr!=null)finAr.clear();
	if(firstItem!=null)firstItem.clear();
	if(secondItem!=null)secondItem.clear();
	if(thirdItem!=null)thirdItem.clear();
	if(forthItem!=null)forthItem.clear();
	if(fifthItem!=null)fifthItem.clear();
	if(sixthItem!=null)sixthItem.clear();
	if(seventhItem!=null)seventhItem.clear();
	if(eighthItem!=null)eighthItem.clear();
	if(ninthItem!=null)ninthItem.clear();
	if(tenthItem!=null)tenthItem.clear();
	if(eleventhItem!=null)eleventhItem.clear();
	
}catch (Exception e)  {
	//out.println("Error  :"+e.toString());
	e.printStackTrace();
}
finally
	{
		 if(con != null)
		 ConnectionManager.returnConnection(con,request);
	}
%>
