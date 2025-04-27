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
	Connection con = null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	StringBuffer strbuff = new StringBuffer();
	StringBuffer module_buff = new StringBuffer();

	module_buff.append("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels"));
	
	try {
	    String module_query="select MODULE_ID,MODULE_NAME   from SM_module where MODULE_GROUP_ID='SS' order by 2";
	 
		con = ConnectionManager.getConnection(request);
		pstmt=con.prepareStatement(module_query.toString());
		rset = pstmt.executeQuery();
		while(rset!=null && rset.next()){
			module_buff.append(","+rset.getString(1)+","+rset.getString(2));
		}

		if(rset!=null)
		rset.close();
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();


	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();
	firstItem.add("List");  				//Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Module.label","common_labels"));			// label
	firstItem.add("module");			//name of field
	firstItem.add(module_buff.toString());
	firstItem.add("20");						// SIZE
	firstItem.add("20");						//LENGTH
	finAr.add(firstItem);					//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");  				//Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecialityEvent.label","ca_labels"));			// label
	secondItem.add("event_id");			//name of field
	secondItem.add("6");						// SIZE
	secondItem.add("6");						//LENGTH
	finAr.add(secondItem);					//add to ArrayList obj finAr

	//================= populating the second item in the firstitem object

	ArrayList thirdItem=new ArrayList();
	thirdItem.add("Text");					//Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.OrderSequenceNumber.label","ca_labels"));	// label
	thirdItem.add("orderSeqNo");			//name of field
	thirdItem.add("4");					// SIZE
	thirdItem.add("2");					//LENGTH
	finAr.add(thirdItem);					//add to ArrayList obj finAr

	//================= populating the 3rd item in the firstitem object

	ArrayList forthItem=new ArrayList();
	forthItem.add("Text");					//Type of item
	forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecialtyTaskDescription.label","ca_labels"));	// label
	forthItem.add("splty_task_desc");	//name of field
						//LENGTH
	forthItem.add("20")	 ;
	forthItem.add("60");					//LENGTH
	finAr.add(forthItem);					//add to ArrayList obj finAr

	//================= populating the 4th item in the firstitem object

   
	
	ArrayList fifthItem=new ArrayList();
	fifthItem.add("Hidden");					// Type of item
	fifthItem.add("function_id");	// label
	fifthItem.add(function_id);			// name of field
	finAr.add(fifthItem);					//add to ArrayList obj finAr

	String orderByCols[] = new String[3];
	String orderByColVals[] = new String[3];

	/*orderByCols[0]		= "Service Code";
	orderByCols[1]		= "Service Description";
	orderByCols[2]		= "Order Catalog Code";
	orderByCols[3]		= "Order Catalog Description";
	*/
	orderByCols[0]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Module.label","common_labels");
	orderByCols[1]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecialityEvent.label","ca_labels");
	orderByCols[2]= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecialtyTaskDescription.label","ca_labels");


	orderByColVals[0]	= "MODULE_NAME"; 
	orderByColVals[1]	= "SPLTY_EVENT_DESC";    
	orderByColVals[2]	= "SPLTY_TASK_DESC";  
	
	
		
	strbuff =qrypg.getQueryPage(null, finAr, "ChiefComplaint", "../../eCA/jsp/SpecialityTasksForEventsQueryResults.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.QueryCriteria.label","or_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExecuteQuery.label","or_labels"));

	out.println(strbuff.toString());
	strbuff.setLength(0);
		finAr.clear();
       firstItem.clear();
       secondItem.clear();
       thirdItem.clear();
       forthItem.clear(); 
		fifthItem.clear();
	}
	catch (Exception e) 
	{
	//	out.println("Exception @ try"+e.toString());//COMMON-ICN-0181
                  e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}

%>
