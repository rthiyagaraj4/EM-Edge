<!DOCTYPE html>
<!--  
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V200904            72977         NMC-JD-CRF-0059       Mohana Priya K
2  			 V211020											Mohanapriya K
-->

<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<%@ page import = "java.sql.Connection,java.util.ArrayList, java.sql.*, webbeans.eCommon.ConnectionManager" %>
<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	String sortorder =
	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels") ;
	String queryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels") ;
	String code =
	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.POLICY_TYPE_CODE.label","bl_labels");
	String select   =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ;
	String executequery	 =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
	String shortDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels");
	String nature =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.GosiPolicy.label","bl_labels");
	String description =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels");

	StringBuffer strbuff;
	boolean siteSpec=false;
	String sitespecval="N";
	PreparedStatement stmt = null;
	ResultSet rs = null;

	Connection con=null ;
	try{
		con=ConnectionManager.getConnection(request);
		siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_POLICY_TYPES");
			if(siteSpec){
				sitespecval="Y";
			}else{
				sitespecval="N";
			}
			}catch(Exception e)
			{
				e.printStackTrace();
				out.println("Exception in sitespec is "+e);
			}
			finally{
				try{
					if(stmt!=null) stmt.close();
					if(rs!=null)rs.close();
					//ConnectionManager.returnConnection(con); //V211020
				}catch(Exception e)
				{
					e.printStackTrace();
					//out.println("Exception is "+e);
				}
			}
	try {
			//con  =  ConnectionManager.getConnection(request); //V211020

			ArrayList finAr = new ArrayList();
			ArrayList firstItem = new ArrayList();
			firstItem.add("Text");           //Type of item
			firstItem.add(code);     // label
			firstItem.add("policy_type_code"); 
			firstItem.add("40"); 
			firstItem.add("20"); 
			finAr.add(firstItem);//add to ArrayList obj finAr

			ArrayList secondItem = new ArrayList();

			secondItem.add("Text");          //Type of item
			secondItem.add(description);    // label
			secondItem.add("long_desc");  //name of field
			secondItem.add("40");   // SIZE
			secondItem.add("100");   //LENGTH
			finAr.add(secondItem);    //add to ArrayList obj finAr

			ArrayList thirdItem = new ArrayList();
			thirdItem.add("Text");          //Type of item
			thirdItem.add(shortDesc);    // label
			thirdItem.add("short_desc");  //name of field
			thirdItem.add("40");   // SIZE
			thirdItem.add("40");   //LENGTH
			finAr.add(thirdItem);    //add to ArrayList obj finAr

			if("Y".equals(sitespecval)){
				ArrayList fourthItem = new ArrayList();
				fourthItem.add("Check");   //Type of item
				fourthItem.add(nature);  // label
				fourthItem.add("gosipolicy");//name
				finAr.add(fourthItem);
			}

			String[] orderByCols=null;
			String[] orderByColVals=null;

			orderByCols = new String[2];
			orderByColVals = new String[2];

			orderByCols[0] = description;
			orderByCols[1] = shortDesc;

			orderByColVals[0] = "long_desc";
			orderByColVals[1] = "short_desc";

			strbuff = qrypg.getQueryPage( con,finAr,code ,"../../eBL/jsp/BLPolicyTypeQueryResult.jsp",sortorder,queryCriteria,select ,orderby,orderByCols, orderByColVals,executequery);

			out.println(strbuff.toString());
		} catch (Exception e) {
			e.printStackTrace();
			//out.println("Exception in BLPolicyType=="+e);
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
%>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

