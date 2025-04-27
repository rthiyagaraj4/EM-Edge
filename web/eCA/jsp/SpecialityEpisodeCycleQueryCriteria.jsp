<!DOCTYPE html>
<%@page import="java.util.*, eCA.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*,webbeans.eCommon.*" %>

<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%
	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<%-- Mandatory declarations end --%>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	StringBuffer sbmod=new StringBuffer();
	sbmod.append("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels"));

	try{
		String sql_module="select MODULE_ID,MODULE_NAME   from SM_module where MODULE_GROUP_ID='SS' order by 2";
		con = ConnectionManager.getConnection(request);
		pstmt=con.prepareStatement(sql_module.toString());
		rset = pstmt.executeQuery();
		while(rset!=null && rset.next()){
			sbmod.append(","+rset.getString(1)+","+rset.getString(2));
		}
	/* Mandatory checks start */
	String function_id = request.getParameter("function_id");
	/* Mandatory checks end */

	/* Initialize Function specific start */
	/* Initialize Function specific end */
	if(rset!=null)
		rset.close();
	if(pstmt!=null)
		pstmt.close();
	if(con!=null)
		con.close();

	StringBuffer strbuff = new StringBuffer();
	ArrayList finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
	firstItem.add("List");  				//Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Module.label","common_labels"));			// label
	firstItem.add("module_id");			//name of field
	firstItem.add(sbmod.toString());						
	finAr.add(firstItem);					//add to ArrayList obj finAr

	//================= populating the second item in the firstitem object

	ArrayList secondItem=new ArrayList();
	secondItem.add("Text");					//Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.EpisodeDescription.label","ca_labels"));		// label
	secondItem.add("speps_desc");			//name of field
	secondItem.add("40");					// SIZE
	secondItem.add("40");					//LENGTH
	finAr.add(secondItem);					//add to ArrayList obj finAr

	//================= populating the 3rd item in the firstitem object

	ArrayList thirdItem=new ArrayList();
	thirdItem.add("Text");					//Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.EventTitleDescription.label","ca_labels"));	// label
	thirdItem.add("sptltevnt_desc");	//name of field
	thirdItem.add("40");					//LENGTH
	thirdItem.add("40");					//LENGTH
	finAr.add(thirdItem);					//add to ArrayList obj finAr


	//================
	ArrayList fourthItem=new ArrayList();
	fourthItem.add("Hidden");					// Type of item
	fourthItem.add("function_id");	// label
	fourthItem.add(function_id);			// name of field
	finAr.add(fourthItem);					//add to ArrayList obj finAr


	String orderByCols[] = new String[3];
	String orderByColVals[] = new String[3];

	/*orderByCols[0]		= "Service Code";
	orderByCols[1]		= "Service Description";
	orderByCols[2]		= "Order Catalog Code";
	orderByCols[3]		= "Order Catalog Description";
	*/

	orderByCols[0]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Module.label","common_labels");
	orderByCols[1]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.EpisodeDescription.label","ca_labels");
	orderByCols[2]= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.EventTitleDescription.label","ca_labels");

	orderByColVals[0]	= "A.module_id";    
	orderByColVals[1]	= "SPLTY_EPISODE_DESC";  
	orderByColVals[2]	= "SPLTY_TITLE_EVENT_DESC";   
		
	strbuff =qrypg.getQueryPage(null, finAr, "SpecialityEpCycle", "../../eCA/jsp/SpecialityEpisodeCycleQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.QueryCriteria.label","or_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExecuteQuery.label","or_labels"));

	out.println(strbuff.toString());
	strbuff.setLength(0);
	if(firstItem != null) firstItem.clear();
	if(secondItem != null) secondItem.clear();
	if(thirdItem != null) thirdItem.clear();
	if(fourthItem != null) fourthItem.clear();
	if(finAr != null) finAr.clear();
	}catch(Exception e){
		e.printStackTrace() ;
	}

%>
