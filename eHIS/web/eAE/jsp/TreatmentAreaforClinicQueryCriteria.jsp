<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");

%>
    <html><head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head></html>
<%
 
 ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff = new StringBuffer(" ");
Connection con		= null ;
PreparedStatement pstmt	= null;
ResultSet rset				= null;

 
try 
{  
	String loc_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels");
	String loc_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDesc.label","common_labels");
	String pri_zone=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PriorityZone.label","common_labels");
	String trt_area_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.TreatmentAreaCode.label","ae_labels");
	String trt_area_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.TreatmentAreaDesc.label","ae_labels");

	
	/* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */

	String locale		    = (String)session.getAttribute("LOCALE");
	/* CRF  SKR-CRF-0021 [IN028173] end  */
	
	con				= ConnectionManager.getConnection(request);
	/*Added by lakshmanan for ML-MMOH-CRF-1973 on 01-07-2023 start */
	boolean isAppearAsTabEnable  = eCommon.Common.CommonBean.isSiteSpecific(con,"AE","AE_TREATMENT_AREA_TAB");
	String appear_as_tab=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.AppearAsTab.label","ae_labels");
	/*Added by lakshmanan for ML-MMOH-CRF-1973 on 01-07-2023 end */
	
	//Added By Shanmukh for MMS-DM-CRF-0147
	Boolean isPriorityZoneAppl			= false;
	isPriorityZoneAppl			=	CommonBean.isSiteSpecific(con, "AE", "PRIORITY_ZONE");
	  String	facilityId 			= (String) session.getValue( "facility_id" ) ;
	  String AcessSql   = "SELECT five_level_triage_appl_yn FROM AE_PARAM WHERE OPERATING_FACILITY_ID=? ";
	  String five_level_triage_appl_yn	= "N";
	  pstmt=con.prepareStatement(AcessSql);
	  pstmt.setString(1,facilityId);
	  rset=pstmt.executeQuery();
	  while(rset!=null && rset.next()) {
		  five_level_triage_appl_yn	=  (rset.getString("five_level_triage_appl_yn")==null || rset.getString("five_level_triage_appl_yn")=="")?"N":rset.getString("five_level_triage_appl_yn");
	  }
	  if(rset!=null)  rset.close();
	  if(pstmt!=null)  pstmt.close();
	ArrayList finAr 		= new ArrayList();
	ArrayList firstItem 	= new ArrayList();

	firstItem.add("Text");  		//Type of item
	firstItem.add(loc_code);		//label
	firstItem.add("clinic_code");		//name of field
	firstItem.add("4");				// SIZE
	firstItem.add("4");			    //LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr
	
	ArrayList secondItem	= new ArrayList();

	secondItem.add("Text");  //Type of item
	secondItem.add(loc_desc);  // label
	secondItem.add("clinic_desc");   //name of field
	secondItem.add("30");	// SIZE
	secondItem.add("30");	//LENGTH
	finAr.add(secondItem); //add to ArrayList obj finAr

	/**Added on 09/02/04 by Gomathi Shankar for Priority Zone**/
	ArrayList thirdItem	 = new ArrayList();

	thirdItem.add("List");   //Type of item
	thirdItem.add(pri_zone);  // label
	thirdItem.add("priority_zone");//name

	
/* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
	if(!five_level_triage_appl_yn.equals("Y")){
		 thirdItem.add("SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' and EFF_STATUS='E'  and priority_zone not in ('B','W') order by PRIORITY_ZONE_ORDER ");
	}else{
		thirdItem.add("SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' and EFF_STATUS='E' order by PRIORITY_ZONE_ORDER ");
	}
	/* CRF  SKR-CRF-0021 [IN028173] end  */
	

	finAr.add(thirdItem); //add to ArrayList obj finAr 
   
   //code to add the priority zone completed.

	ArrayList fourthItem	= new ArrayList();

	fourthItem.add("Text");  //Type of item
	fourthItem.add(trt_area_code);  // label
	fourthItem.add("treatment_code");   //name of field
	fourthItem.add("2");	// SIZE
	fourthItem.add("2");	//LENGTH

	finAr.add(fourthItem); //add to ArrayList obj finAr

	ArrayList fifthItem	= new ArrayList();

	fifthItem.add("Text");  //Type of item
	fifthItem.add(trt_area_desc);  // label
	fifthItem.add("long_desc");   //name of field
	fifthItem.add("30");	// SIZE
	fifthItem.add("30");	//LENGTH

	finAr.add(fifthItem); //add to ArrayList obj finAr

	ArrayList sixthItem	 = new ArrayList();

	sixthItem.add("List");   //Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels"));  // label
	sixthItem.add("gender");//name
	sixthItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+",M,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+",U,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
	finAr.add(sixthItem); //add to ArrayList obj finAr 

	ArrayList seventhItem	 = new ArrayList();

	seventhItem.add("List");   //Type of item
	seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.OpentoAllPracLocation.label","ae_labels"));  // label
	seventhItem.add("open_to_all_prac_for_clinic_yn");//name
	seventhItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
	finAr.add(seventhItem); //add to ArrayList obj finAr

	ArrayList eigthItem	 = new ArrayList();

	eigthItem.add("List");   //Type of item
	eigthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	eigthItem.add("eff_status");//name
	//eigthItem.add("B,Both,D,Disabled,E,Enabled");//static values that need to be displayed as amtion.Send it along with the value that is inserted.
	eigthItem.add("B," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as amtion.Send it along with the value that is inserted.
	finAr.add(eigthItem); //add to ArrayList obj finAr
	/*Added by lakshmanan for ML-MMOH-CRF-1973 on 01-07-2023 start*/
	if (isAppearAsTabEnable) {
	ArrayList ninthItem	= new ArrayList();
	ninthItem.add("Check");  //Type of item
	ninthItem.add(appear_as_tab);  // label
	ninthItem.add("appear_as_tab");   //name of field
	finAr.add(ninthItem); //add to ArrayList obj finAr
	}
	/*Added by lakshmanan for ML-MMOH-CRF-1973 on 01-07-2023 end*/
   
	String orderByCols[] 	= new String[5];
	String orderByColVals[] = new String[5];
	

	orderByCols[0] 		 = loc_code;
	orderByCols[1]		 = loc_desc;
	orderByCols[2]		 = pri_zone;
	orderByCols[3]		 = trt_area_code;
	orderByCols[4]		 = trt_area_desc;


	orderByColVals[0] 	 = "clinic_code";
	orderByColVals[1] 	 = "clinic_desc";
	orderByColVals[2] 	 = "priority_zone";
	orderByColVals[3] 	 = "treatment_area_code";
	orderByColVals[4] 	 = "long_desc";

/*Below line modified By Shanmukh for MMS-DM-CRF-0147*/
	strbuff 		= qrypg.getQueryPage(con,finAr,"Find Site" ,"../../eAE/jsp/TreatmentAreaforClinicQueryResult.jsp?isPriorityZoneAppl="+isPriorityZoneAppl+"&isAppearAsTabEnable="+isAppearAsTabEnable+" ",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

	out.println(strbuff.toString());
	strbuff.setLength(0);
	if(finAr!=null)finAr.clear();
	if(firstItem!=null)firstItem.clear();
	if(secondItem!=null)secondItem.clear();
	if(thirdItem!=null)thirdItem.clear();
	if(fourthItem!=null)fourthItem.clear();
	if(fifthItem!=null)fifthItem.clear();
	if(sixthItem!=null)sixthItem.clear();
	if(seventhItem!=null)seventhItem.clear();
	if(eigthItem!=null)eigthItem.clear();
}catch (Exception e)  {e.printStackTrace();}
finally  {
		 if(con!=null)
		 ConnectionManager.returnConnection(con,request);
}
%>  
