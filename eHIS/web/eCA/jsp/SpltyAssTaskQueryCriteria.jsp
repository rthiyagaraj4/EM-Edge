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
	secondItem.add("12");						// SIZE
	secondItem.add("6");						//LENGTH
	finAr.add(secondItem);					//add to ArrayList obj finAr

   ArrayList thirdItem = new ArrayList();
	thirdItem.add("Text");  				//Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecialityEventDesc.label","ca_labels"));			// label
	thirdItem.add("event_desc");			//name of field
	thirdItem.add("30");						// SIZE
	thirdItem.add("60");						//LENGTH
	finAr.add(thirdItem);					//add to ArrayList obj finAr

	ArrayList forthItem=new ArrayList();
	forthItem.add("List");					//Type of item
	forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category1.label","common_labels"));	// label
	forthItem.add("category");			//name of field
	forthItem.add("A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","ca_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NonSpecific.label","ca_labels")+",M,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mother.label","common_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Foetus.label","ca_labels")+"");
	
	forthItem.add("4");					// SIZE
	forthItem.add("4");					//LENGTH
	finAr.add(forthItem);					//add to ArrayList obj finAr

	//================= populating the 3rd item in the firstitem object

	ArrayList fifthItem=new ArrayList();
	fifthItem.add("List");					//Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.TaskType.label","ca_labels"));	// label
	fifthItem.add("taskType");	//name of field
	fifthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.note.label","common_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Chart.label","common_labels")+"");
						//LENGTH
	forthItem.add("4")	 ;
	forthItem.add("4");					//LENGTH
	finAr.add(fifthItem);					//add to ArrayList obj finAr

	//================= populating the 4th item in the firstitem object

   
	
	ArrayList sixthItem=new ArrayList();
	sixthItem.add("Hidden");					// Type of item
	sixthItem.add("function_id");	// label
	sixthItem.add(function_id);			// name of field
	finAr.add(sixthItem);					//add to ArrayList obj finAr

	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];

	/*orderByCols[0]		= "Service Code";
	orderByCols[1]		= "Service Description";
	orderByCols[2]		= "Order Catalog Code";
	orderByCols[3]		= "Order Catalog Description";
	*/
	orderByCols[0]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Module.label","common_labels");
	orderByCols[1]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecialityEvent.label","ca_labels");
	orderByCols[2]= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category1.label","common_labels");
	orderByCols[3]= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecialityEventDesc.label","ca_labels");


	orderByColVals[0]	= "MODULE_ID"; 
	orderByColVals[1]	= "EVENT_CODE";    
	orderByColVals[2]	= "CATEGORY";  
	orderByColVals[3]	= "SPLTY_EVENT_DESC";  
	
	
		
	strbuff =qrypg.getQueryPage(null, finAr, "ChiefComplaint", "../../eCA/jsp/SpltyAssTaskQueryResults.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.QueryCriteria.label","or_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ExecuteQuery.label","or_labels"));

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
		//out.println("Exception @ try"+e.toString());//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}

%>
