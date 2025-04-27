<!DOCTYPE html>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% 
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language='javascript' src='../../eDS/js/MealStatistics.js'></script>
<HTML>
<head>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
try{
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String kitchenCode = request.getParameter("kitchen_code");
	String mealType =request.getParameter("meal_Type");
	String servDate =request.getParameter("serv_Date");

	String nursingUnit = "";
	String dietType = "";
	String noOfMeals= "";
	String attendants = "";
	//ML-MMOH-CRF-0902
	String menuType ="";
	//String menuTypeCount ="";
	String menuTypeTemp="";
	//ML-MMOH-CRF-0902
	int start = 0 ;
	int end = 0 ;
	int i=1;

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 14 ;
    else
        end = Integer.parseInt( to ) ;

	Connection conn  =  ConnectionManager.getConnection(request);
	//ML-MMOH-CRF-0902
	boolean isMenuType = false;
	isMenuType = CommonBean.isSiteSpecific(conn,"DS","DS_MENU_TYPE");
	//ML-MMOH-CRF-0902
	//ML-MMOH-SCF-2071
	boolean isMealStat = false;
	isMealStat = CommonBean.isSiteSpecific(conn,"DS","DS_MEAL_STAT_QUERY");
	//ML-MMOH-SCF-2071
	PreparedStatement stmt = null;
	int maxRecord = 0;
	ResultSet rset=null;
	//ML-MMOH-CRF-406
	PreparedStatement stmt1 = null,pstmt1=null;
	ResultSet rs = null,rs1=null;
	String DS_Param_Sql="select Attendent_Label_Name from ds_param_for_facility where OPERATING_FACILITY_ID='"+facility_id+"'";
	String Attendent_Label_Name="";
	//ML-MMOH-CRF-0406
	try{
		String strsql = "select count(*) total "+
						"from Ds_Daily_Meal_Statistics mealstat "+
						"where mealstat.kitchen_Code = '"+kitchenCode+"' and mealstat.meal_Type = '"+mealType+"' "+
						"and to_char(mealstat.serv_Date,'dd/mm/yyyy') =  '"+servDate+"' and mealstat.language_Id like '"+locale+"' ";

				
		String strsql1="";		
		if(!isMenuType){
			strsql1 = "select mealstat.cur_Ward_Code,mealstat.diet_Type,mealstat.patient_Meals,"+
						"mealstat.att_Meals, null menu_type_desc "+
						"from Ds_Daily_Meal_Statistics mealstat "+
						"where mealstat.kitchen_Code = '"+kitchenCode+"' and mealstat.meal_Type = '"+mealType+"' "+
						"and to_char(mealstat.serv_Date,'dd/mm/yyyy') =  '"+servDate+"' and mealstat.language_Id like '"+locale+"' order by mealstat.cur_Ward_Code, mealstat.diet_Type ";			
		}
		else if(!isMealStat) // Added Against ML-MMOH-SCF-2071
			{
			strsql1 = "SELECT   cur_ward_code, diet_type, patient_meals, att_meals, wm_concat (menu_type_desc || ' - ' || menu_type_cnt) menu_type_desc "+
			  "FROM (SELECT   mealstat.cur_ward_code, mealstat.diet_type, mealstat.patient_meals, mealstat.att_meals,"+
			  "ds_get_desc.ds_menu_type (menu_type, '"+locale+"', '2') menu_type_desc, COUNT (menu_type) menu_type_cnt FROM "+
			  "ds_daily_meal_statistics mealstat, ds_epsd_meal_plan_hdr a WHERE mealstat.kitchen_code = '"+kitchenCode+"' AND mealstat.meal_type = '"+mealType+"' "+
			  "and to_char(mealstat.serv_Date,'dd/mm/yyyy') =  '"+servDate+"' and mealstat.language_Id = '"+locale+"' "+
			  "AND mealstat.serv_date = a.serving_date AND mealstat.meal_type = a.meal_type AND mealstat.diet_type_code = a.diet_type  GROUP BY mealstat.cur_ward_code,"+
			  "mealstat.diet_type, mealstat.patient_meals, mealstat.att_meals, menu_type UNION "+
			  "SELECT mealstat.cur_ward_code, mealstat.diet_type, mealstat.patient_meals, mealstat.att_meals,"+
			  "ds_get_desc.ds_menu_type (menu_type, '"+locale+"', '2') menu_type_desc, COUNT (menu_type) menu_type_cnt FROM "+
			  "ds_daily_meal_statistics mealstat, ds_epsd_meal_plan_hdr_attnd a WHERE mealstat.kitchen_code = '"+kitchenCode+"' AND mealstat.meal_type = '"+mealType+"' "+
			  "and to_char(mealstat.serv_Date,'dd/mm/yyyy') =  '"+servDate+"' and mealstat.language_Id = '"+locale+"' "+
			  "AND mealstat.serv_date = a.serving_date AND mealstat.meal_type = a.meal_type AND mealstat.diet_type_code = a.diet_type  GROUP BY mealstat.cur_ward_code,"+
			  "mealstat.diet_type, mealstat.patient_meals, mealstat.att_meals, menu_type) WHERE menu_type_desc IS NOT NULL GROUP BY cur_ward_code, diet_type,"+
			  "patient_meals, att_meals order by cur_ward_code, diet_type";			
			}
			else
			{
			strsql1 = "SELECT   cur_ward_code, diet_type, patient_meals, att_meals, LISTAGG (menu_type_desc || ' - ' || menu_type_cnt) menu_type_desc "+
			  "FROM (SELECT   mealstat.cur_ward_code, mealstat.diet_type, mealstat.patient_meals, mealstat.att_meals,"+
			  "ds_get_desc.ds_menu_type (menu_type, '"+locale+"', '2') menu_type_desc, COUNT (menu_type) menu_type_cnt FROM "+
			  "ds_daily_meal_statistics mealstat, ds_epsd_meal_plan_hdr a WHERE mealstat.kitchen_code = '"+kitchenCode+"' AND mealstat.meal_type = '"+mealType+"' "+
			  "and to_char(mealstat.serv_Date,'dd/mm/yyyy') =  '"+servDate+"' and mealstat.language_Id = '"+locale+"' "+
			  "AND mealstat.serv_date = a.serving_date AND mealstat.meal_type = a.meal_type AND mealstat.diet_type_code = a.diet_type  GROUP BY mealstat.cur_ward_code,"+
			  "mealstat.diet_type, mealstat.patient_meals, mealstat.att_meals, menu_type UNION "+
			  "SELECT mealstat.cur_ward_code, mealstat.diet_type, mealstat.patient_meals, mealstat.att_meals,"+
			  "ds_get_desc.ds_menu_type (menu_type, '"+locale+"', '2') menu_type_desc, COUNT (menu_type) menu_type_cnt FROM "+
			  "ds_daily_meal_statistics mealstat, ds_epsd_meal_plan_hdr_attnd a WHERE mealstat.kitchen_code = '"+kitchenCode+"' AND mealstat.meal_type = '"+mealType+"' "+
			  "and to_char(mealstat.serv_Date,'dd/mm/yyyy') =  '"+servDate+"' and mealstat.language_Id = '"+locale+"' "+
			  "AND mealstat.serv_date = a.serving_date AND mealstat.meal_type = a.meal_type AND mealstat.diet_type_code = a.diet_type  GROUP BY mealstat.cur_ward_code,"+
			  "mealstat.diet_type, mealstat.patient_meals, mealstat.att_meals, menu_type) WHERE menu_type_desc IS NOT NULL GROUP BY cur_ward_code, diet_type,"+
			  "patient_meals, att_meals order by cur_ward_code, diet_type";	
			}
			
		System.err.println("strsql1====>"+strsql1);
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();

		rs.next();
		maxRecord = rs.getInt("total");

		if(maxRecord == 0){
			//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");//GDOH-SCF-0160
		}
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();
	
		//ML-ML-MMOH-CRF-0406 STARTS
		pstmt1 = conn.prepareStatement(DS_Param_Sql);
		rs1=pstmt1.executeQuery();
		if(rs1.next()){
			Attendent_Label_Name=rs1.getString("Attendent_Label_Name");
		}
		//ML-MMOH-CRF-0406 ENDS		
	}catch(Exception e){
		e.printStackTrace();
		System.err.println("92->MealStatisticsQueryResult.jsp"+e.getMessage());
	}
%>
<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eDS/jsp/MealStatisticsQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&kitchen_code="+kitchenCode+"&meal_Type="+mealType+"&serv_Date="+servDate+ "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eDS/jsp/MealStatisticsQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&kitchen_code="+kitchenCode+"&meal_Type="+mealType+"&serv_Date="+servDate+ "'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<tr>
				<th>
					<fmt:message key="eOT.NursingUnit.Label" bundle="${ot_labels}"/>
				</th>
				<!-- ML-MMOH-CRF-0902 -->
				<%				
				if(isMenuType){
				%>
				<th>
					<fmt:message key="eDS.MenuType.Label" bundle="${ds_labels}"/>
				</th>
				<%
				}
				%>
				<!-- ML-MMOH-CRF-0902 -->
				
				<th>
					<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}"/>
				</th>
				<th>
					<fmt:message key="eOT.NoOfMeals.Label" bundle="${ot_labels}"/>
				</th>
				<th>
					<!--<fmt:message key="eOT.Attendents.Label" bundle="${ot_labels}"/>-->
					<%=Attendent_Label_Name%><!--ML-MMOH-CRF-406-->
				</th>
			</tr>
<%
	if ( start != 1 )
	for( int j=1; j<start; i++,j++ )
	rset.next() ;
	String classValue= " ";
	while ( rset.next() && i<=end  )
	{
		menuTypeTemp = "";//ML-MMOH-CRF-0902
    if ( i % 2 == 0 )
		classValue = "QRYEVEN";
	else
		classValue = "QRYODD";
		out.println("<tr>");

    nursingUnit = rset.getString("cur_Ward_Code");
    dietType =rset.getString("diet_Type");
    noOfMeals= rset.getString("patient_Meals");
    attendants = rset.getString("att_Meals");

	//ML-MMOH-CRF-0902
	if(isMenuType){
	menuType =checkForNull(rset.getString("menu_type_desc"));
	}
	//ML-MMOH-CRF-0902

	int rowId=1;
	out.println("<td class='" + classValue+"' nowrap>"+nursingUnit+"</td>");
	//ML-MMOH-CRF-0902
	if(isMenuType){
	out.println("<td class='" + classValue+"' nowrap>"+menuType+"&nbsp;</td>");
	}
	//ML-MMOH-CRF-0902
	    out.println("<td class='" + classValue+"' nowrap>"+dietType+"</td>");
	    out.println("<td class='" + classValue+"' nowrap>"+noOfMeals+"</td>");
	    out.println("<td class='" + classValue+"' nowrap>"+attendants+"</td>");
	out.println("</tr>");
	rowId++;
	i++;
} %>
</td></tr>
</table>
</center>

<br><center>
<%
	if(stmt!=null)	stmt.close();
	if(stmt1!=null)	stmt1.close();
	if(rs!=null)	rs.close();
	if(rset!=null) rset.close();
	ConnectionManager.returnConnection(conn,request);
}
catch(Exception e)
{
	e.printStackTrace();
	System.err.println("179->MealStatisticsQueryResult.jsp===>"+e.getMessage());
}
%>
</center>
</form>
</BODY>
</HTML>

