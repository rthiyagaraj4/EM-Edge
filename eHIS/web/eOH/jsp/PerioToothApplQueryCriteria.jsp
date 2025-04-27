<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import ="java.sql.Connection, java.util.ArrayList, webbeans.eCommon.ConnectionManager,java.sql.PreparedStatement,java.sql.ResultSet" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<% 
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE"); 
	 request.setCharacterEncoding("UTF-8");
	
%>
<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='JavaScript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script> 
</head>
<body onLoad="parent.commontoolbarFrame.document.forms[0].reset.disabled=true;" OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%      String facility_id = (String)session.getValue( "facility_id" ) ;
        String  tooth_numbering_system="";
        String params = request.getParameter( "params" ) ;  
		String sortOrder =
		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String QueryCriteria =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"); 
		String select =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.DefaultSelect.Label","oh_labels");
		String orderby =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");

		String executeQuery =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
		String both =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String enabled=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String disabled =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		//String chartid=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ChartID.label","common_labels");
		String component_desc_user_def=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Component.label","oh_labels");
		String ns_tooth_no=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToothApplicable.Label","oh_labels");
		String chart_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ChartID.label","common_labels");
		//String Required=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.Required?.Label","oh_labels");
		//String chart_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
		String status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels");
		String PeriodontalChartSetup_function_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.PeriodontalChartSetup.Label","oh_labels");


		ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
		StringBuffer strbuff;

		String oh_chart_level = "";
		int i = 0;
		Connection con=null ;
		PreparedStatement pstmt=null;
        ResultSet rs=null;

		try {

				con  =  ConnectionManager.getConnection(request);
				//PreparedStatement pstmt=null;
	            //ResultSet rs=null;
				//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
				//Based on the Chart Level the paramters need to be taken.
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			
				pstmt = con.prepareStatement("SELECT CHART_LEVEL FROM OH_PARAM");
				rs = pstmt.executeQuery();
				while (rs != null && rs.next()){
					oh_chart_level = checkForNull(rs.getString("CHART_LEVEL"));
				}
				if(oh_chart_level.equals("E")){
					String sql="SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM";
	 
					// int total=0;
					//int i=1;
					i=1;
					pstmt = con.prepareStatement(sql);
				}else{//End
					String sql="SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?";
	 
					// int total=0;
					//int i=1;
					i=1;
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,facility_id);
				}
				rs = pstmt.executeQuery();
				while(rs.next()){
					tooth_numbering_system=rs.getString("TOOTH_NUMBERING_SYSTEM");
				}
				ArrayList finAr = new ArrayList();
				
				ArrayList firItem = new ArrayList();

				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();

				firItem.add("List");           //Type of item
				firItem.add(chart_code);     // label
				firItem.add("chart_code");   //name of field
				firItem.add("SELECT CHART_CODE, CHART_DESC FROM OH_PERIODONTAL_CHART_DEF_HDR WHERE EFF_STATUS = 'E' ORDER BY CHART_DESC");   //name of field
				finAr.add(firItem);//add to ArrayList obj finAr
                
				ArrayList firstItem = new ArrayList();
				
				firstItem.add("List");           //Type of item
				firstItem.add(component_desc_user_def);     // label
				firstItem.add("component_desc_user_def");   //name of field
				firstItem.add("SELECT COMPONENT_CODE, COMPONENT_DESC_USER_DEF FROM OH_PERIODONTAL_CHART_COMP ORDER BY COMPONENT_DESC_USER_DEF");   //name of field
				/*firstItem.add("SELECT B.COMPONENT_CODE, A.COMPONENT_DESC_USER_DEF FROM OH_PERIODONTAL_CHART_COMP A, OH_PERIODONTAL_CHART_DEF_DTL B WHERE B.CHART_CODE = ? AND A.COMPONENT_CODE = B.COMPONENT_CODE AND A.FORMULA_YN = 'N' ORDER BY COMPONENT_DESC_USER_DEF");   //name of field*/
				
				finAr.add(firstItem);//add to ArrayList obj finAr

				ArrayList secondItem = new ArrayList();

				secondItem.add("List");          //Type of item
				secondItem.add(ns_tooth_no);    // label
				secondItem.add("ns_tooth_no");  //name of field
				//secondItem.add("SELECT LPAD(TO_CHAR(NS_TOOTH_NO),2,'0') NS_TOOTH_NO, TO_CHAR(TOOTH_NO) TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE NUMBERING_SYSTEM = '"+tooth_numbering_system+"' AND TOOTH_NO IN (SELECT TOOTH_NO FROM OH_TOOTH WHERE PERMANENT_DECIDUOUS = 'P') UNION SELECT '*A' NS_TOOTH_NO, '*A' TOOTH_NO FROM DUAL ORDER BY NS_TOOTH_NO");  //name of field
				secondItem.add("SELECT TO_CHAR(TOOTH_NO) TOOTH_NO,LPAD(TO_CHAR(NS_TOOTH_NO),2,'0') NS_TOOTH_NO  FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE NUMBERING_SYSTEM = '"+tooth_numbering_system+"' AND  TOOTH_NO IN (SELECT TOOTH_NO FROM OH_TOOTH WHERE PERMANENT_DECIDUOUS = 'P') UNION SELECT '*A' NS_TOOTH_NO, '*A' TOOTH_NO FROM DUAL ORDER BY NS_TOOTH_NO");  //name of field

				
				//secondItem.add("30");   // SIZE
				//secondItem.add("30");   //LENGTH
				finAr.add(secondItem);    //add to ArrayList obj finAr

				ArrayList thirdItem = new ArrayList();

				thirdItem.add("List");   //Type of item
				thirdItem.add(status);  // label
				thirdItem.add("status");//name
				thirdItem.add("B,"+both+",Y,"+enabled+",N,"+disabled);//static values that need to be displayed as 
				finAr.add(thirdItem);

				String[] orderByCols=null;
				String[] orderByColVals=null;

				orderByCols = new String[3];
				orderByColVals = new String[3];

				orderByCols[0] = chart_code;
				orderByCols[1] = component_desc_user_def;
				orderByCols[2] = ns_tooth_no;

				orderByColVals[0] = "chart_code";
				orderByColVals[1] = "component_desc_user_def";
				orderByColVals[2] = "ns_tooth_no";

				strbuff = qrypg.getQueryPage( con,finAr,PeriodontalChartSetup_function_name ,"../../eOH/jsp/../../eOH/jsp/PerioToothApplQueryResult.jsp",sortOrder,QueryCriteria,select,orderby,orderByCols,orderByColVals,executeQuery);

				out.println(strbuff.toString());
				} catch (Exception e) {}

		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
%>

<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='params' id='params' value="<%=params%>">


