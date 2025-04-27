<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,webbeans.eCommon.*,eMR.*,eCommon.Common.*,com.ehis.eslp.* " %><!--oracle.jdbc.driver.*-->
<%
String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%

try
{
	request.setCharacterEncoding("UTF-8");
	Connection conn=null ;
	conn = ConnectionManager.getConnection(request);

	ArrayList Terminologyvalues = new ArrayList();
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;
	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  		 //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologyGroup.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels"));	  // label
	firstItem.add("term_group_id");	//name of field
	firstItem.add("10"); //size
	firstItem.add("10"); //maxlength
	Terminologyvalues.add(firstItem); //add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");   //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologyGroup.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels")); //label
	secondItem.add("terminologygroup_desc");//name
	secondItem.add("30"); //size
	secondItem.add("60");  //maxlength
	Terminologyvalues.add(secondItem); //add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();
	thirdItem.add("List");   //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermSet.label","common_labels")); //label
	thirdItem.add("term_set_id");//name
	String term_set ="select TERM_SET_ID, TERM_SET_DESC from mr_term_set where PROC_SPEC_YN = 'Y' and eff_Status = 'E' order by 2";
	PreparedStatement stmt =conn.prepareStatement(term_set);
	ResultSet rset = stmt.executeQuery();
	StringBuffer  a = new StringBuffer("'',------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" -------,");
	while(rset!=null  && rset.next())
	{
		a.append(rset.getString(1)+","+rset.getString(2)+",");	//static values that need to be displayed as option.
	}
	thirdItem.add(a.toString());
	if ( rset != null) rset.close();
	if ( stmt != null) stmt.close();
	Terminologyvalues.add(thirdItem); //add to ArrayList obj finAr


	ArrayList fourthItem = new ArrayList();
	fourthItem.add("List");   //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.IndexType.label","common_labels")); //label
	fourthItem.add("index_type");//name
	fourthItem.add("'',---- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+
		" ----,S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"));//static values that need to be displayed as option.
	Terminologyvalues.add(fourthItem); //add to ArrayList obj finAr

	ArrayList fifthItem = new ArrayList();
	fifthItem.add("Text");  		 //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecialityCode.label","common_labels")); // label
	fifthItem.add("spclt_code");	//name of field
	fifthItem.add("10"); //size
	fifthItem.add("10"); //maxlength
	Terminologyvalues.add(fifthItem); //add to ArrayList obj finAr

	ArrayList sixthItem = new ArrayList();
	sixthItem.add("Text");  		 //Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels") +" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels")); // label
	sixthItem.add("spclt_desc");	//name of field
	sixthItem.add("10"); //size
	sixthItem.add("10"); //maxlength
	Terminologyvalues.add(sixthItem); //add to ArrayList obj finAr

	ArrayList seventhItem = new ArrayList();
	seventhItem.add("Text");  		 //Type of item
	seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels")); // label
	seventhItem.add("pract_id");	//name of field
	seventhItem.add("10"); //size
	seventhItem.add("10"); //maxlength
	Terminologyvalues.add(seventhItem); //add to ArrayList obj finAr

	ArrayList eighthItem = new ArrayList();
	eighthItem.add("Text");  		 //Type of item
	eighthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels")); // label
	eighthItem.add("pract_name");	//name of field
	eighthItem.add("10"); //size
	eighthItem.add("10"); //maxlength
	Terminologyvalues.add(eighthItem); //add to ArrayList obj finAr


	/*ArrayList ninethItem = new ArrayList();
	ninethItem.add("List");   //Type of item
	ninethItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels")); //label
	ninethItem.add("eff_status"); //name
	ninethItem.add("'',"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.
	Terminologyvalues.add(ninethItem); //add to ArrayList obj finAr
	*/
	String orderByCols[] = new String[7];
	String orderByColVals[] = new String[7];

	
	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologyGroup.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologyGroup.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermSetID.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecialityCode.label","common_labels");
	orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels") +" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels");	
	orderByCols[6] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels");	


	orderByColVals[0] = "a.TERM_GROUP_ID";
	orderByColVals[1] = "d.TERM_GROUP_DESC";
	orderByColVals[2] = "a.TERM_SET_ID";
	orderByColVals[3] = "a.SPECIALITY_CODE";
	orderByColVals[4] = "c.SHORT_DESC";
	orderByColVals[5] = "a.PRACTITIONER_ID";
	orderByColVals[6] = "b.PRACTITIONER_NAME";


	
	strbuff = qrypg.getQueryPage(conn,Terminologyvalues,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TerminologyGroup.label","mr_labels"),"../jsp/CustomListTerminologyGroupQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());

	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	fifthItem.clear();
	sixthItem.clear();
	seventhItem.clear();
	eighthItem.clear();
	//ninethItem.clear();
	Terminologyvalues.clear();
	if ( conn != null ) ConnectionManager.returnConnection(conn,request);
}
catch (Exception e) 
{
	//out.println(e.toString());
	e.printStackTrace();
}

finally
{
}
%>
