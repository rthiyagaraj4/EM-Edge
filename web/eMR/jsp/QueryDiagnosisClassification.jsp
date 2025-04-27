<!DOCTYPE html>
<!--
*	Copyright © iSoft Solutions (P) Ltd. 
*	Created By		:	S.V.Narayana 
*	Created On		:	12 aug 2008
-->


<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,webbeans.eCommon.*,eMR.*,eCommon.Common.*,com.ehis.eslp.* " %>
<%
String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%

try
{
	request.setCharacterEncoding("UTF-8");
	String locale=(String)session.getAttribute("LOCALE");
	Connection conn=null ;
	conn = ConnectionManager.getConnection(request);

	ArrayList Terminologyvalues = new ArrayList();
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;
	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  	
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagnosisClassification.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	  
	firstItem.add("DIAG_CLASS_CODE");	
	firstItem.add("10"); 
	firstItem.add("10"); 
	Terminologyvalues.add(firstItem); 

	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");   
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagnosisClassification.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));
	secondItem.add("LONG_DESC");
	secondItem.add("30"); 
	secondItem.add("60");  
	Terminologyvalues.add(secondItem); 

	ArrayList thirdItem = new ArrayList();
	thirdItem.add("List");  
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagnosisClassification.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.type.label","common_labels"));  
	thirdItem.add("DIAG_CLASS_TYPE");
	String term_set ="SELECT diag_class_type,description FROM   MR_DIAG_CLASS_TYPE_LANG_VW where LANGUAGE_ID = '"+locale+"' and  EFF_STATUS = 'E' ORDER BY 2";
	PreparedStatement stmt =conn.prepareStatement(term_set);
	ResultSet rset = stmt.executeQuery();
	StringBuffer  a = new StringBuffer("'',------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" -------,");
	while(rset!=null  && rset.next())
	{
		a.append(rset.getString(1)+","+rset.getString(2)+",");	
	}
	thirdItem.add(a.toString());
	if ( rset != null) rset.close();
	if ( stmt != null) stmt.close();
	Terminologyvalues.add(thirdItem); 

/*Added by Maheshwaran K for the SKR-CRF-0020 as on 07/05/2012*/
/*Start*/
ArrayList fourthItem = new ArrayList();
fourthItem.add("List"); 
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DefaultPrincipalDiagClassification.label","mr_labels"));  
fourthItem.add("Default");   
fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));
fourthItem.add("4");
Terminologyvalues.add(fourthItem);
/*End*/

ArrayList fifthItem = new ArrayList();
fifthItem.add("List"); 
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  
fifthItem.add("nature");   
fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));
fifthItem.add("4");
Terminologyvalues.add(fifthItem);


	
	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];

	
	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagnosisClassification.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagnosisClassification.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	


	orderByColVals[0] = "DIAG_CLASS_CODE";
	orderByColVals[1] = "LONG_DESC";
	//orderByColVals[2] = "DIAG_CLASS_TYPE";
	//orderByColVals[3] = "nature";


	
	strbuff = qrypg.getQueryPage(conn,Terminologyvalues,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagnosisClassification.label","mr_labels"),"../jsp/DiagnosisClassificationResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());

	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	/*Added by Maheshwaran K for the SKR-CRF-0020 as on 07/05/2012*/
	/*Start*/
	fourthItem.clear();
	/*End*/
	fifthItem.clear();
	
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
