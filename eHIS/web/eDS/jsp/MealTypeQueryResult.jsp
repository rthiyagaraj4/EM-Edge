<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

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
	String ph_module_yn = request.getParameter("ph_module_yn");
try{
		String whereClause = request.getParameter("whereclause");
		if(whereClause==null) whereClause="";
		String from = request.getParameter( "from" ) ;
		String to = request.getParameter( "to" ) ;
		String sql = " ";
		String mealType = request.getParameter("meal_Type")==null?"":request.getParameter( "meal_Type" ).trim().toUpperCase();
		String longDesc =request.getParameter("long_Desc")==null?"":request.getParameter( "long_Desc" ).trim().toUpperCase();
		String shortDesc =request.getParameter("short_Desc")==null?"":request.getParameter( "short_Desc" ).trim().toUpperCase();
		String order = request.getParameter("order_np")==null?"":request.getParameter( "order_np" ).trim();
		String enabledYn = request.getParameter("enabled_Yn")==null?"":request.getParameter( "enabled_Yn");
		String OPMealOrderYn = request.getParameter("OPMealOrder_Yn")==null?"":request.getParameter( "OPMealOrder_Yn");
		String EMMealOrderYn = request.getParameter("EM_Meal_Order_Yn")==null?"":request.getParameter( "EM_Meal_Order_Yn");
		//MMS-QH-CRF-0079
		String SupplDietOrder = request.getParameter("supldietorder_yn")==null?"":request.getParameter( "supldietorder_yn");
		//MMS-QH-CRF-0079
		String STMealOrderYn = request.getParameter("stmealorder_yn")==null?"":request.getParameter( "stmealorder_yn");//ML-MMOH-CRF-0820
		//ML-MMOH-CRF-409 STARTS
		String ServingTime="",IrregularTime="";
		//ML-MMOH-CRF-409 ENDS
		String ServingTime_OP="",ServingTime_EM="",ServingTime_SUP="",IrregularTime_OP="",IrregularTime_EM="",IrregularTime_SUP=""; //Added Against ML-MMOH-CRF-0825-US3
		String IPMealOrderYn = request.getParameter("IPMealOrderYn")==null?"":request.getParameter( "IPMealOrderYn");
		//Added Against ML-MOH-CRF-1006
		
    if ( (whereClause == null || whereClause.equals("")) )
    {
		int cnt=0;

		if ( !(mealType == null || mealType.equals("")) ){
	        sql = sql + " where upper(meal_type) like upper('"+mealType +"%')";
			cnt++;
        }

        if ( !(longDesc == null || longDesc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(long_desc) like '"+longDesc+"%'";
			else{
				sql=sql+" where upper(long_desc) like '"+longDesc+"%'";
				cnt=1;
			}
        }

	   if ( !(shortDesc == null || shortDesc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(short_desc) like '"+shortDesc+"%'";
			else{
				sql=sql+" where upper(short_desc) like '"+shortDesc+"%'";
				cnt=1;
			}
        }

	   if ( !(order == null || order.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(meal_order) like '"+order+"%'";
			else{
				sql=sql+" where upper(meal_order) like '"+order+"%'";
				cnt=1;
			}
       }

		if (!(enabledYn.equals("B"))){

		if(enabledYn.equals("E")){
			if(cnt>0)
				   sql = sql+" and nvl(eff_status,'D')='E' ";
				else{
					sql=sql+ " where nvl(eff_status,'D')='E' ";
					cnt=1;
				}
		}
		else if(enabledYn.equals("D")){
			if(cnt>0)
				   sql = sql+" and nvl(eff_status,'D')='D' ";
				else{
					sql=sql+ " where nvl(eff_status,'D')='D' ";
					cnt=1;
				}
		}
    }
	
	/* Added Against Start ML-MOH-CRF-1006 */
	if (!(IPMealOrderYn.equals("B"))){
		if(IPMealOrderYn.equals("Y")){
			if(cnt>0)
				   sql = sql+" and nvl(ip_meal_order_yn,'N')='Y' ";
				else{
					sql=sql+ " where nvl(ip_meal_order_yn,'N')='Y' ";
					cnt=1;
				}
		}
		else if(IPMealOrderYn.equals("N")){
			if(cnt>0)
				   sql = sql+" and nvl(ip_meal_order_yn,'N')='N' ";
				else{
					sql=sql+ " where nvl(ip_meal_order_yn,'N')='N' ";
					cnt=1;
				}
		}
    	}	
    	/* Added Against End ML-MOH-CRF-1006 */
	
	if (!(OPMealOrderYn.equals("B"))){

		if(OPMealOrderYn.equals("Y")){
			if(cnt>0)
				   sql = sql+" and nvl(opmealorder_yn,'N')='Y' ";
				else{
					sql=sql+ " where nvl(opmealorder_yn,'N')='Y' ";
					cnt=1;
				}
		}
		else if(OPMealOrderYn.equals("N")){
			if(cnt>0)
				   sql = sql+" and nvl(opmealorder_yn,'N')='N' ";
				else{
					sql=sql+ " where nvl(opmealorder_yn,'N')='N' ";
					cnt=1;
				}
		}
    }

	if (!(EMMealOrderYn.equals("B"))){

		if(EMMealOrderYn.equals("Y")){
			if(cnt>0)
				   sql = sql+" and nvl(em_meal_order_yn,'N')='Y' ";
				else{
					sql=sql+ " where nvl(em_meal_order_yn,'N')='Y' ";
					cnt=1;
				}
		}
		else if(EMMealOrderYn.equals("N")){
			if(cnt>0)
				   sql = sql+" and nvl(em_meal_order_yn,'N')='N' ";
				else{
					sql=sql+ " where nvl(em_meal_order_yn,'N')='N' ";
					cnt=1;
				}
		}
    }

	//MMS-QH-CRF-0079
	if (!(SupplDietOrder.equals("B"))){

			if(SupplDietOrder.equals("Y")){
				if(cnt>0)
					   sql = sql+" and nvl(SUPPL_DIET_ORDER_YN,'N')='Y' ";
					else{
						sql=sql+ " where nvl(SUPPL_DIET_ORDER_YN,'N')='Y' ";
						cnt=1;
					}
			}
			else if(SupplDietOrder.equals("N")){
				if(cnt>0)
					   sql = sql+" and nvl(SUPPL_DIET_ORDER_YN,'N')='N' ";
					else{
						sql=sql+ " where nvl(SUPPL_DIET_ORDER_YN,'N')='N' ";
						cnt=1;
					}
			}
		}
	//MMS-QH-CRF-0079


	//ML-MMOH-CRF-0820
	if (!(STMealOrderYn.equals("B"))){
		if(STMealOrderYn.equals("Y")){
			if(cnt>0)
				   sql = sql+" and nvl(st_meal_order_yn,'N')='Y' ";
				else{
					sql=sql+ " where nvl(st_meal_order_yn,'N')='Y' ";
					cnt=1;
				}
		}
		else if(STMealOrderYn.equals("N")){
			if(cnt>0)
				   sql = sql+" and nvl(st_meal_order_yn,'N')='N' ";
				else{
					sql=sql+ " where nvl(st_meal_order_yn,'N')='N' ";
					cnt=1;
				}
		}
    }
	//ML-MMOH-CRF-0820

    //appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");
    if ( !(ord == null || ord .equals("")) )
    {
        sql=sql+" order by ";
        for ( int i=0;i < ord.length;i++ )
        {
        if ( i == ord.length - 1 )
            sql=sql+ord[i];
        else
            sql=sql+ord[i]+",";
        }
    }
    } //end of where clause IF
    else
            sql = whereClause;

    int start = 0;
    int end = 0;
    int i=1;

    if ( from == null )
        start = 1;
    else
        start = Integer.parseInt( from );

    if ( to == null )
        end = 14;
    else
        end = Integer.parseInt( to );

	Connection conn  =  ConnectionManager.getConnection(request);

	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	int maxRecord = 0;
	ResultSet rset=null;
	ResultSet rs = null;

	try{

		String strsql="select count(*) as total from ds_meal_type "+sql;
		//String strsql1="select meal_type,long_desc,short_desc,meal_order,eff_status,opmealorder_yn,em_meal_order_yn,suppl_diet_order_yn,st_meal_order_yn,(SERVING_START_TIME ||'-'|| SERVING_END_TIME) SERVING_TIME,(IRREGULAR_START_TIME ||'-'|| IRREGULAR_END_TIME)IRREGULAR_TIME,ip_meal_order_yn from ds_meal_type "+sql;//CRF-820 and Commented Against ML-MMOH-CRF-0825-US3
		String strsql1="select meal_type,long_desc,short_desc,meal_order,eff_status,opmealorder_yn,em_meal_order_yn,suppl_diet_order_yn,st_meal_order_yn,(SERVING_START_TIME ||'-'|| SERVING_END_TIME) SERVING_TIME,(IRREGULAR_START_TIME ||'-'|| IRREGULAR_END_TIME)IRREGULAR_TIME,ip_meal_order_yn,(SERVING_START_TIME_OP ||'-'|| SERVING_END_TIME_OP) SERVING_TIME_OP,(IRREGULAR_START_TIME_OP ||'-'|| IRREGULAR_END_TIME_OP)IRREGULAR_TIME_OP,(SERVING_START_TIME_EM ||'-'|| SERVING_END_TIME_EM) SERVING_TIME_EM,(IRREGULAR_START_TIME_EM ||'-'|| IRREGULAR_END_TIME_EM)IRREGULAR_TIME_EM,(SERVING_START_TIME_SUP ||'-'|| SERVING_END_TIME_SUP) SERVING_TIME_SUP,(IRREGULAR_START_TIME_SUP ||'-'|| IRREGULAR_END_TIME_SUP)IRREGULAR_TIME_SUP from ds_meal_type "+sql;//CRF-820 and Modified Against ML-MMOH-CRF-0825-US3
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();

		rs.next();
		maxRecord = rs.getInt("total");

		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();

		}catch(Exception e){
			System.err.println("Exception MealTypeQueryResult.jsp "+e);
			e.printStackTrace();
		}
%>
<form name='QueryResult' id='QueryResult'>

<P>
<table align='right'>
<tr>
<td>
<%
	if ( !(start <= 1) )
		out.println("<A HREF='../../eDS/jsp/MealTypeQueryResult.jsp?from="+(start-14)+"&ph_module_yn="+ph_module_yn+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	if ( !( (start+14) > maxRecord ) )
		out.println("<A HREF='../../eDS/jsp/MealTypeQueryResult.jsp?from="+(start+14)+"&ph_module_yn="+ph_module_yn+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>
	<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
	<th class="columnheadercenter" nowrap>
		<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}"/>
	</th>
	<th class="columnheadercenter" nowrap>
		<fmt:message key="eOT.LongDescription.Label" bundle="${ot_labels}"/>
	</th>
	<th class="columnheadercenter" nowrap>
		<fmt:message key="eOT.ShortDescription.Label" bundle="${ot_labels}"/>
	</th>
	<th class="columnheadercenter" nowrap>
		<fmt:message key="eOT.Order.Label" bundle="${ot_labels}"/>
	</th>
	<th class="columnheadercenter" nowrap>
		<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
	</th>
	<!-- Added Against Start ML-MOH-CRF-1006 -->
	<th class="columnheadercenter" nowrap>
	&nbsp;<fmt:message key="Common.inpatient.label" bundle="${common_labels}"/><BR>
	<fmt:message key="eDS.MealOrder.Label" bundle="${ds_labels}"/>
	</th>
	<!-- Added Against End ML-MOH-CRF-1006 -->
	<!--ML-MMOH-CRF-0825 STARTS-->
	<th class="columnheadercenter" nowrap>
		<fmt:message key="Common.inpatient.label" bundle="${common_labels}"/><BR>
		<fmt:message key="eOT.servingTime.Label" bundle="${ot_labels}"/>
	</th>
	<!--td class="columnheadercenter" nowrap>
		<fmt:message key="eDS.LateIrregularDietOrderTime.Label" bundle="${ds_labels}"/>
	</td--ML-MMOH-CRF-0825>
	<!--ML-MMOH-CRF-409 & ML-MMOH-CRF-0825 ENDS -->	
	<th class="columnheadercenter" nowrap>
	<fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/><BR>
	<fmt:message key="eDS.MealOrder.Label" bundle="${ds_labels}"/>
	</th>
	<!--ML-MMOH-CRF-0825 STARTS -->
	<th class="columnheadercenter" nowrap>
		<fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/><BR>
		<fmt:message key="eOT.servingTime.Label" bundle="${ot_labels}"/>
	</th>
	<!--ML-MMOH-CRF-0825 ENDS -->
	<th class="columnheadercenter" nowrap>
	<fmt:message key="eDS.EmergencyPatient.Label" bundle="${ds_labels}"/><BR>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eDS.MealOrder.Label" bundle="${ds_labels}"/>
	</th>
	<!--ML-MMOH-CRF-0825 STARTS -->
	<th class="columnheadercenter" nowrap>
		<fmt:message key="eDS.EmergencyPatient.Label" bundle="${ds_labels}"/><BR>
		<fmt:message key="eOT.servingTime.Label" bundle="${ot_labels}"/>
	</th>
	<!--ML-MMOH-CRF-0825 ENDS -->
	<!-- MMS-QH-CRF-0079 STARTS -->
	<th class="columnheadercenter" nowrap>
	<fmt:message key="eDS.Supplementary.Label" bundle="${ds_labels}"/><BR>
	&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eDS.DietOrder.Label" bundle="${ds_labels}"/>
	</th>
	<!--ML-MMOH-CRF-0825 STARTS -->
	<th class="columnheadercenter" nowrap>
		<fmt:message key="eDS.Supplementary.Label" bundle="${ds_labels}"/><BR>
		<fmt:message key="eDS.DietOrder.Label" bundle="${ds_labels}"/>
		<fmt:message key="eOT.servingTime.Label" bundle="${ot_labels}"/>
	</th>
	<!--ML-MMOH-CRF-0825 ENDS -->
	<!-- MMS-QH-CRF-0079 ENDS-->
<%
	int mOrder = 0;
	if ( start != 1 )
	for( int j=1; j<start; i++,j++ )
		rset.next() ;
	String classValue= " ";
	while ( rset.next() && i<=end  )
	{
    if ( i % 2 == 0 )
            classValue = "gridData" ;  // changed by yadav
                else
            classValue = "gridData" ;  // changed by yadav
    out.println("<tr><td align=='left' class='" + classValue + "' nowrap>");

    mealType = rset.getString(1);
    longDesc=rset.getString(2);
    shortDesc= rset.getString(3);
    mOrder = rset.getInt(4);
    enabledYn = rset.getString(5);
    OPMealOrderYn = rset.getString(6);
    EMMealOrderYn = rset.getString(7);
	SupplDietOrder = rset.getString(8);//MMS-QH-CRF-0079
	STMealOrderYn = rset.getString(9);//ML-MMOH-CRF-0820
	//ML-MMOH-CRF-409 STARTS
	ServingTime=rset.getString(10);
	IrregularTime=rset.getString(11);
	IPMealOrderYn=rset.getString(12); //Added Against ML-MOH-CRF-1006
	//Added Against ML-MMOH-CRF-0825-US3 Start
	ServingTime_OP=rset.getString(13);
	IrregularTime_OP=rset.getString(14);
	ServingTime_EM=rset.getString(15);
	IrregularTime_EM=rset.getString(16);
	ServingTime_SUP=rset.getString(17);
	IrregularTime_SUP=rset.getString(18);
	if(ServingTime_OP.equals("-")){
		ServingTime_OP="";
	}
	if(ServingTime_EM.equals("-")){
		ServingTime_EM="";
	}
	if(ServingTime_SUP.equals("-")){
		ServingTime_SUP="";
	}
	if(IrregularTime_OP.equals("-")){
		IrregularTime_OP="";
	}
	if(IrregularTime_EM.equals("-")){
		IrregularTime_EM="";
	}
	if(IrregularTime_SUP.equals("-")){
		IrregularTime_SUP="";
	}
	//Added Against ML-MMOH-CRF-0825-US3 End
	
	if(ServingTime.equals("-")){
		ServingTime="";
	}
	if(IrregularTime.equals("-")){
		IrregularTime="";
	}
	//ML-MMOH-CRF-409 ENDS

	String mode="modify";
	out.println("<a href='../../eDS/jsp/MealTypeAddModify.jsp?mode="+mode+"&mealType="+ mealType+"' target='f_query_add_mod' >");
    out.println(mealType+"</a></td>");
    out.println("<td class='" + classValue+"' nowrap>"+longDesc+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+shortDesc+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+mOrder+"</td>");

    out.println("<td class='" + classValue + "' align='center'>");
    if ( "E".equals(enabledYn) )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");

	//Added Against Start ML-MOH-CRF-1006
	out.println("<td class='" + classValue + "' align='center'>");
    if ( "Y".equals(IPMealOrderYn) )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");
	//Added Against End ML-MOH-CRF-1006
	//ML-MMOH-CRF-409 STARTS
	out.println("<td class='" + classValue+"' nowrap>"+ServingTime+"</td>");
	//out.println("<td class='" + classValue+"' nowrap>"+IrregularTime+"</td>");//Commented against ML-MMOH-CRF-0825
	//ML-MMOH-CRF-409 ENDS	
    out.println("<td class='" + classValue + "' align='center'>");
    if ( "Y".equals(OPMealOrderYn) )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");
	out.println("<td class='" + classValue+"' nowrap>"+ServingTime_OP+"</td>");//Added against ML-MMOH-CRF-0825

    out.println("<td class='" + classValue + "' align='center'>");
    if ( "Y".equals(EMMealOrderYn) )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");
	out.println("<td class='" + classValue+"' nowrap>"+ServingTime_EM+"</td>");//Added against ML-MMOH-CRF-0825
	//MMS-QH-CRF-0079
	out.println("<td class='" + classValue + "' align='center'>");
    if ( "Y".equals(SupplDietOrder) )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");
	out.println("<td class='" + classValue+"' nowrap>"+ServingTime_SUP+"</td>");//Added against ML-MMOH-CRF-0825
	//MMS-QH-CRF-0079

	//ML-MMOH-CRF-0820 
	/* Commented Against ML-MOH-CRF-1006
	out.println("<td class='" + classValue + "' align='center'>");
    if ( "Y".equals(STMealOrderYn) )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");
	*/
	//ML-MMOH-CRF-0820
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
		}catch(Exception e){
			System.err.println("446,Exception in MealTypeQueryResult.jsp "+e);
			e.printStackTrace();
		}
%>
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

