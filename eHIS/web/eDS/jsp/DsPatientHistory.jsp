<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.util.ArrayList,java.net.URLEncoder" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
	<%
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";
	%>

	<%
		String encounter_Id=request.getParameter("episode_id");
		String facilityId = (String)session.getValue( "facility_id" );
		String locale = (String)session.getAttribute("LOCALE");

		Connection conn   = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs     = null ;
		String dateTime="",dietType="",mealClass="",mealType="",status="",classValue="",item="", itemQty="",scheduledTime="",src="";
		int maxRecord=0;

		String title = request.getParameter("title")==null?"":request.getParameter("title");

	%>
<html>
	<head>
		<TITLE><%=title%></TITLE>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<%-- 	<script Language="JavaScript" src="<%=request.getContextPath()%>/eDS/DsPatientHistory.js"></script> --%>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>


	</head>

<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<div id="mealPlan">
	
		<table width='100%' id="mealContentHeader" >
			<tr>
				<td colspan='5' class="CAGROUP" align="center">Meal Contents - Food Items</td>
			</tr>
		</table>
			
		<table  border=4 width='100%' style='BORDER-STYLE:solid;' id="mealContentTable" >
			<tr>
				<th width='20%' nowrap="nowrap">Date and Time</th>
				<th width='20%' nowrap="nowrap">Diet Type</th>
				<th width='20%' nowrap="nowrap">Meal Type</th>
				<th width='20%' nowrap="nowrap">Meal Class</th>
				<th width='20%' nowrap="nowrap">Patient Served?</th>
			</tr>

			<%
			String sql="select rownum as col_0_0_, to_char(dsepsdmeal0_.EVENT_DATE_TIME, 'dd/mm/yyyy hh24:mi') as col_1_0_, dsdiettype3_.SHORT_DESC as col_2_0_, dsmealclas2_.SHORT_DESC as col_3_0_, dsmealtype1_.SHORT_DESC as col_4_0_, dsepsdmeal0_.STATUS as col_5_0_ from DS_EPSD_MEAL_PLAN_HDR_AUDIT dsepsdmeal0_, DS_MEAL_TYPE_LANG_VW dsmealtype1_, DS_MEAL_CLASS_LANG_VW dsmealclas2_, DS_DIET_TYPE_LANG_VW dsdiettype3_ where (dsepsdmeal0_.OPERATING_FACILITY_ID='"+facilityId+"' )and(dsepsdmeal0_.ENCOUNTER_ID='"+encounter_Id+"' )and(dsepsdmeal0_.MEAL_TYPE=dsmealtype1_.MEAL_TYPE )and(dsepsdmeal0_.MEAL_CLASS=dsmealclas2_.MEAL_CLASS )and(dsepsdmeal0_.DIET_TYPE=dsdiettype3_.DIET_TYPE )and(dsdiettype3_.LANGUAGE_ID='"+locale+"' )and(dsmealclas2_.LANGUAGE_ID='"+locale+"' )and(dsmealtype1_.LANGUAGE_ID='"+locale+"' )and(to_date(to_char(dsepsdmeal0_.EVENT_DATE_TIME , 'dd/mm/yyyy hh24:mi'), 'dd/mm/yyyy hh24:mi')>=to_date(to_char((sysdate-1), 'dd/mm/yyyy hh24:mi'), 'dd/mm/yyyy hh24:mi'))and(nvl(dsepsdmeal0_.STATUS , 'MP')in('MS' , 'MP' , 'MR')) order by  to_char(dsepsdmeal0_.EVENT_DATE_TIME , 'dd/mm/yyyy hh24:mi')desc , 2 , 1";


			try{
				conn			= ConnectionManager.getConnection(request);
				System.out.println("sql"+sql);
				pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

				rs = pstmt.executeQuery();

				//getting maximum record
		    	rs.last();	maxRecord = rs.getRow();
		    	if(maxRecord == 0){ %>
<!-- 		    		<td colspan='5' align='center'>NO RECORDS FOUND</td> -->

				<%}
				//again move the resultset pointer to initial position
				rs.beforeFirst();
		    	int i=1;
				while(rs != null && rs.next()){
				dateTime=(rs.getString("col_1_0_"));
				dietType=(rs.getString("col_2_0_"));
				mealClass=(rs.getString("col_3_0_"));
				mealType=(rs.getString("col_4_0_"));
				status=(rs.getString("col_5_0_"));

				System.out.println("dateTime"+dateTime);
				System.out.println("dietType"+dietType);
				System.out.println("mealClass"+mealClass);
				System.out.println("mealType"+mealType);
				System.out.println("status"+status);%>

				<tr>
					<td class='<%=classValue%>' width='10%' nowrap><%=dateTime%></td>
					<td class='<%=classValue%>' width='8%' nowrap><%=dietType%></td>
					<td class='<%=classValue%>' width='8%' nowrap><%=mealType%></td>
					<td class='<%=classValue%>' width='8%' nowrap><%=mealClass%></td>
					<td class='<%=classValue%>' width='8%' nowrap>

					<%
					if(status.equals("MS"))
					{
							src="../../eCommon/images/enabled.gif";
					}
					else if(status.equals("MP"))
					{
							src="../../eCommon/images/disabled.gif";
					}
					else if(status.equals("MR"))
					{
							src="../../eCommon/images/disabled.gif";
					}
					%>
					<img src="<%=src%>" />
					</td>

				</tr>

				<%
				classValue =(i%2==0)?"qryEven":"qryOdd";
				i++;
				}
			}
			catch(Exception e) {
			    e.printStackTrace();
	            System.err.println("Exception=="+e);
			}
			finally{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) ConnectionManager.returnConnection(conn,request);
	   		}
			%>
		</table>
		<br/><br/>

	</div>
	<div id="nonFreqSplFoodItem">

		<table width='100%' id="splFoodItemNonFreqHeader" >
			<tr>
				<td colspan='5' class="CAGROUP" align="center">Special Food Items - Non Frequency Based</td>
			</tr>
		</table>

		<table  border=4 width='100%' style='BORDER-STYLE:solid;' id="nonFreqSplFoodItemContentTable" >
<!-- 		<table  border='2' width='600' align="center" id="nonFreqSplFoodItemContentTable" > -->
			<tr>
				<th width='20%'  nowrap="nowrap">Date and Time</th>
				<th width='20%'  nowrap="nowrap">Meal Type</th>
				<th width='20%'  nowrap="nowrap">Items</th>
				<th width='20%'  nowrap="nowrap">Item Qty</th>
				<th width='20%'  nowrap="nowrap">Patient Served?</th>
			</tr>

			<%
			String nonfreqSql="select rownum as col_0_0_, to_char(dsepsdmeal0_.EVENT_DATE_TIME, 'dd/mm/yyyy hh24:mi') as col_1_0_, dsepsdmeal0_.MEAL_TYPE as col_2_0_, dsmealtype2_.SHORT_DESC as col_3_0_, dsepsdmeal0_.ITEM_CODE as col_4_0_, dsitems1_.SHORT_DESC as col_5_0_, dsepsdmeal0_.ITEM_QTY as col_6_0_, dsepsdmeal0_.STATUS as col_7_0_ from DS_EPSD_MEAL_PLAN_SPL_AUDIT dsepsdmeal0_, DS_ITEMS dsitems1_, DS_MEAL_TYPE dsmealtype2_ where (dsepsdmeal0_.ITEM_CODE=dsitems1_.FOOD_ITEM_CODE )and(dsepsdmeal0_.MEAL_TYPE=dsmealtype2_.MEAL_TYPE )and (dsitems1_.language_id='"+locale+"') and (dsepsdmeal0_.OPERATING_FACILITY_ID='"+facilityId+"' )and(dsepsdmeal0_.ENCOUNTER_ID='"+encounter_Id+"' )and(to_date(to_char(dsepsdmeal0_.EVENT_DATE_TIME , 'dd/mm/yyyy hh24:mi'), 'dd/mm/yyyy hh24:mi')>=to_date(to_char((sysdate-1), 'dd/mm/yyyy hh24:mi'), 'dd/mm/yyyy hh24:mi'))and(dsepsdmeal0_.FREQ_YN='N' )and(nvl(dsepsdmeal0_.STATUS , 'MP')in('MS' , 'MP' , 'MR')) order by  to_char(dsepsdmeal0_.EVENT_DATE_TIME , 'dd/mm/yyyy hh24:mi')desc , 2 , 1";


			try{
				conn			= ConnectionManager.getConnection(request);
				System.out.println("nonfreqSql"+nonfreqSql);
				pstmt = conn.prepareStatement(nonfreqSql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

				rs = pstmt.executeQuery();

				//getting maximum record
		    	rs.last();	maxRecord = rs.getRow();
		    	if(maxRecord == 0){%>
<!-- 		    		<td colspan='5' align='center'>NO RECORDS FOUND</td> -->
				<% }
				//again move the resultset pointer to initial position
				rs.beforeFirst();
		    	int i=1;
				while(rs != null && rs.next()){
				dateTime=(rs.getString("col_1_0_"));
				mealType=(rs.getString("col_3_0_"));
				item=(rs.getString("col_5_0_"));
				itemQty=(rs.getString("col_6_0_"));
				status=(rs.getString("col_7_0_"));

				System.out.println("dateTime"+dateTime);
				System.out.println("mealType"+mealType);
				System.out.println("item"+item);
				System.out.println("itemQty"+itemQty);
				System.out.println("status"+status);%>

				<tr>
					<td class='<%=classValue%>' width='10%' nowrap><%=dateTime%></td>
					<td class='<%=classValue%>' width='8%' nowrap><%=mealType%></td>
					<td class='<%=classValue%>' width='8%' nowrap><%=item%></td>
					<td class='<%=classValue%>' width='8%' nowrap><%=itemQty%></td>
					<td class='<%=classValue%>' width='8%' nowrap>
					<%
					if(status.equals("MS"))
					{
							src="../../eCommon/images/enabled.gif";
					}
					else if(status.equals("MP"))
					{
							src="../../eCommon/images/disabled.gif";
					}
					else if(status.equals("MR"))
					{
							src="../../eCommon/images/disabled.gif";
					}
					%>
					<img src="<%=src%>"/>
					</td>
				</tr>

				<%
				classValue =(i%2==0)?"qryEven":"qryOdd";
				i++;
				}
			}
			catch(Exception e) {
			    e.printStackTrace();
	            System.err.println("Exception=="+e);
			}
			finally{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) ConnectionManager.returnConnection(conn,request);
	   		}
			%>
		</table>
		<br/><br/>

	</div>
	<div id="freqSplFoodItem">

		<table width='100%' id="splFoodItemFreqHeader" >
			<tr>
				<td colspan='5' class="CAGROUP" align="center">Special Food Items - Frequency Based</td>
			</tr>
		</table>

			<table  border=4 width='100%' style='BORDER-STYLE:solid;' id="freqSplFoodItemContentTable" >
<!-- 		<table  border='2' width='600' align="center" id="freqSplFoodItemContentTable"> -->

			<tr>
				<th width='20%'  nowrap=\"nowrap\">Date and Time</th>
				<th width='20%'  nowrap=\"nowrap\">Scheduled Time</th>
				<th width='20%'  nowrap=\"nowrap\">Items</th>
				<th width='20%'  nowrap=\"nowrap\">Item Qty</th>
				<th width='20%'  nowrap=\"nowrap\">Patient Served?</th>
			</tr>

			<%
// 			String freqSql="select rownum as col_0_0_, to_char(dsepsdmeal0_.EVENT_DATE_TIME, 'dd/mm/yyyy hh24:mi') as col_1_0_, dsepsdmeal0_.MEAL_TYPE as col_2_0_, dsmealtype2_.SHORT_DESC as col_3_0_, dsepsdmeal0_.ITEM_CODE as col_4_0_, dsitems1_.SHORT_DESC as col_5_0_, dsepsdmeal0_.ITEM_QTY as col_6_0_, dsepsdmeal0_.STATUS as col_7_0_ from DS_EPSD_MEAL_PLAN_SPL_AUDIT dsepsdmeal0_, DS_ITEMS dsitems1_, DS_MEAL_TYPE dsmealtype2_ where (dsepsdmeal0_.ITEM_CODE=dsitems1_.FOOD_ITEM_CODE )and(dsepsdmeal0_.MEAL_TYPE=dsmealtype2_.MEAL_TYPE )and(dsepsdmeal0_.OPERATING_FACILITY_ID='"+facilityId+"' )and(dsepsdmeal0_.ENCOUNTER_ID='"+encounter_Id+"' )and(to_date(to_char(dsepsdmeal0_.EVENT_DATE_TIME , 'dd/mm/yyyy hh24:mi'), 'dd/mm/yyyy hh24:mi')>=to_date(to_char((sysdate-1), 'dd/mm/yyyy hh24:mi'), 'dd/mm/yyyy hh24:mi'))and(dsepsdmeal0_.FREQ_YN='N' )and(nvl(dsepsdmeal0_.STATUS , 'MP')in('MS' , 'MP' , 'MR')) order by  to_char(dsepsdmeal0_.EVENT_DATE_TIME , 'dd/mm/yyyy hh24:mi')desc , 2 , 1";
			String freqSql="select rownum as col_0_0_, to_char(dsepsdmeal0_.EVENT_DATE_TIME, 'dd/mm/yyyy hh24:mi') as col_1_0_, to_char(dsepsdmeal0_.SERVING_DATE, 'hh24:mi') as col_2_0_, dsepsdmeal0_.ITEM_CODE as col_3_0_, dsitems1_.SHORT_DESC as col_4_0_, dsepsdmeal0_.ITEM_QTY as col_5_0_, dsepsdmeal0_.STATUS as col_6_0_ from DS_EPSD_MEAL_PLAN_SPL_AUDIT dsepsdmeal0_, DS_ITEMS dsitems1_ where (dsepsdmeal0_.ITEM_CODE=dsitems1_.FOOD_ITEM_CODE )and(dsepsdmeal0_.OPERATING_FACILITY_ID='"+facilityId+"' )and(dsepsdmeal0_.ENCOUNTER_ID='"+encounter_Id+"' )and(to_date(to_char(dsepsdmeal0_.EVENT_DATE_TIME , 'dd/mm/yyyy hh24:mi'), 'dd/mm/yyyy hh24:mi')>=to_date(to_char((sysdate-1), 'dd/mm/yyyy hh24:mi'), 'dd/mm/yyyy hh24:mi'))and(dsepsdmeal0_.FREQ_YN='Y' )and(nvl(dsepsdmeal0_.STATUS , 'MP')in('MS' , 'MP' , 'MR')) order by  to_char(dsepsdmeal0_.EVENT_DATE_TIME , 'dd/mm/yyyy hh24:mi')desc , 2 , 1";


			try{
				conn			= ConnectionManager.getConnection(request);
				System.out.println("freqSql"+freqSql);
				pstmt = conn.prepareStatement(freqSql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

				rs = pstmt.executeQuery();

				//getting maximum record
		    	rs.last();	maxRecord = rs.getRow();
		    	if(maxRecord == 0){%>
<!-- 		    		<td colspan='5' align='center'>NO RECORDS FOUND</td> -->
				<%}
				//again move the resultset pointer to initial position
				rs.beforeFirst();
		    	int i=1;
				while(rs != null && rs.next()){
				dateTime=(rs.getString("col_1_0_"));
				scheduledTime=(rs.getString("col_2_0_"));
				item=(rs.getString("col_4_0_"));
				itemQty=(rs.getString("col_5_0_"));
				status=(rs.getString("col_6_0_"));

				System.out.println("dateTime"+dateTime);
				System.out.println("mealType"+scheduledTime);
				System.out.println("item"+item);
				System.out.println("itemQty"+itemQty);
				System.out.println("status"+status);%>

				<tr>
					<td class='<%=classValue%>' width='10%' nowrap><%=dateTime%></td>
					<td class='<%=classValue%>' width='8%' nowrap><%=scheduledTime%></td>
					<td class='<%=classValue%>' width='8%' nowrap><%=item%></td>
					<td class='<%=classValue%>' width='8%' nowrap><%=itemQty%></td>
					<td class='<%=classValue%>' width='8%' nowrap>
					<%
					if(status.equals("MS"))
					{
							src="../../eCommon/images/enabled.gif";
					}
					else if(status.equals("MP"))
					{
							src="../../eCommon/images/disabled.gif";
					}
					else if(status.equals("MR"))
					{
							src="../../eCommon/images/disabled.gif";
					}
					%>
					<img src="<%=src%>" />
					</td>
				</tr>

				<%
				classValue =(i%2==0)?"qryEven":"qryOdd";
				i++;
				}
			}
			catch(Exception e) {
			    e.printStackTrace();
	            System.err.println("Exception=="+e);
			}
			finally{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) ConnectionManager.returnConnection(conn,request);
	   		}
			%>
		</table>

	</div>
	<input type='hidden' name="encounter_Id" id="encounter_Id" value="<%=encounter_Id%>">
	<input type='hidden' name="facilityId" id="facilityId" value="<%=facilityId%>">
	<input type='hidden' name="locale" id="locale" value="<%=locale%>">
</body>
</html>


