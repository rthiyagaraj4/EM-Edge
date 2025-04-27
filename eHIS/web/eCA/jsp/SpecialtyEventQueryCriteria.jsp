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

	/* Mandatory checks start */
	String function_id = request.getParameter("function_id");
	/* Mandatory checks end */

	/* Initialize Function specific start */
	/* Initialize Function specific end */

	StringBuffer strbuff = new StringBuffer();
	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  				//Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));			// label
	firstItem.add("code");			//name of field
	firstItem.add("10");						// SIZE
	firstItem.add("6");						//LENGTH
	finAr.add(firstItem);					//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");  				//Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));			// label
	secondItem.add("description");			//name of field
	secondItem.add("20");						// SIZE
	secondItem.add("60");						//LENGTH
	finAr.add(secondItem);					//add to ArrayList obj finAr

	//================= populating the second item in the firstitem object

	ArrayList thirdItem=new ArrayList();
	thirdItem.add("Text");					//Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.OrderSequence.label","ca_labels"));	// label
	thirdItem.add("orderSequence");			//name of field
	thirdItem.add("6");					// SIZE
	thirdItem.add("3");					//LENGTH
	finAr.add(thirdItem);					//add to ArrayList obj finAr

	//================= populating the 3rd item in the firstitem object

	ArrayList forthItem=new ArrayList();
	forthItem.add("List");					//Type of item
	forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DefinitionType.label","common_labels"));	// label
	forthItem.add("definitionType");	//name of field
	forthItem.add("%, "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+" ,S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SystemDefined.label","or_labels")+",U,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.UserDefined.label","or_labels")+"");					//LENGTH
	forthItem.add("15");					//LENGTH
	finAr.add(forthItem);					//add to ArrayList obj finAr

	//================= populating the 4th item in the firstitem object

   ArrayList fifthItem=new ArrayList();
	fifthItem.add("List");					// Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels"));	// label
	fifthItem.add("enabled");			// name of field
	fifthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");
	//fifthItem.add("4");					// size
	fifthItem.add("2");					//LENGTH
	finAr.add(fifthItem);					//add to ArrayList obj finAr
	
	ArrayList sixthItem=new ArrayList();
	sixthItem.add("Hidden");					// Type of item
	sixthItem.add("function_id");	// label
	sixthItem.add(function_id);			// name of field
	finAr.add(sixthItem);					//add to ArrayList obj finAr

	String orderByCols[] = new String[5];
	String orderByColVals[] = new String[5];

	/*orderByCols[0]		= "Service Code";
	orderByCols[1]		= "Service Description";
	orderByCols[2]		= "Order Catalog Code";
	orderByCols[3]		= "Order Catalog Description";
	*/
	orderByCols[0]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	orderByCols[1]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	orderByCols[2]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.OrderSequence.label","ca_labels");
	orderByCols[3]= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DefinitionType.label","common_labels");
	orderByCols[4]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");


	orderByColVals[0]	= "SPLTY_EVENT_CODE"; 
	orderByColVals[1]	= "SPLTY_EVENT_DESC";    
	orderByColVals[2]	= "ORDER_SEQ_NO";  
	orderByColVals[3]	= "SYS_IND";   
	orderByColVals[4]	= "EFF_STATUS";
		
	strbuff =qrypg.getQueryPage(null, finAr, "ChiefComplaint", "../../eCA/jsp/SpecialtyEventQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.QueryCriteria.label","or_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExecuteQuery.label","or_labels"));

	out.println(strbuff.toString());
	strbuff.setLength(0);
		finAr.clear();
       firstItem.clear();
       secondItem.clear();
       thirdItem.clear();
       forthItem.clear(); 
		fifthItem.clear();
       

%>
