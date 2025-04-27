<!DOCTYPE html>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" %>
<%@  page contentType="text/html;charset=UTF-8" %> 
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<HTML>
	<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<!--Added Against ML-MMOH-CRF-0670-US001 -->
<jsp:useBean id="DSCommonBeanObj" class="eDS.DSCommonBean"/> 
<jsp:setProperty name="DSCommonBeanObj" property="FacilityId" value='<%=session.getAttribute("facility_id").toString()%>'/> 
<!--Added Against ML-MMOH-CRF-0670-US001 -->
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
	String dietType = request.getParameter("dietType")==null?"":request.getParameter( "dietType" ).trim().toUpperCase();
	String dietDescription =request.getParameter("longDesc")==null?"":request.getParameter( "longDesc" ).trim().toUpperCase();
	String shortDescription =request.getParameter("shortDesc")==null?"":request.getParameter( "shortDesc" ).trim().toUpperCase();
	String ageGroup =request.getParameter("ageGroup")==null?"":request.getParameter( "ageGroup" ).trim().toUpperCase();
	String defaultDietType = request.getParameter("defaultDiet")==null?"":request.getParameter( "defaultDiet");
	String dietCycleType = request.getParameter("dietCycle")==null?"":request.getParameter( "dietCycle");
	String orderCatlogcode = request.getParameter("orderCatalogDescription")==null?"":request.getParameter( "orderCatalogDescription").trim().toUpperCase();
	String dietCategory = request.getParameter("dietCategory")==null?"":request.getParameter( "dietCategory").trim().toUpperCase();

	String enabled = request.getParameter("enable")==null?"":request.getParameter( "enable");
	String defaultFeedType = request.getParameter("defaultFeed")==null?"":request.getParameter( "defaultFeed").trim().toUpperCase();
	//ML-MMOH-CRF-0820
	String IPDietTypeYn = request.getParameter("ipdiettype_yn")==null?"":request.getParameter( "ipdiettype_yn"); 
	String DCDietTypeYn = request.getParameter("dcdiettype_yn")==null?"":request.getParameter( "dcdiettype_yn"); 
	//ML-MMOH-CRF-0820
	String OPDietTypeYn = request.getParameter("opdiettype_yn")==null?"":request.getParameter( "opdiettype_yn");   //ML-MMOH-CRF-0418
	String EMDietTypeYn = request.getParameter("emdiettype_yn")==null?"":request.getParameter( "emdiettype_yn");   //ML-MMOH-CRF-0418
	String applstafforder_yn=request.getParameter("applstafforder_yn")==null?"":request.getParameter( "applstafforder_yn");//CRF-0419
	String attdntorderappl_yn=request.getParameter("attdntorderappl_yn")==null?"":request.getParameter( "attdntorderappl_yn");//ML-MMOH-CRF-0670-US001
	
    if ( (whereClause == null || whereClause.equals("")) )
    {
		int cnt=0;

		if ( !(dietType == null || dietType.equals("")) ){
	        sql = sql + " where upper(a.diet_type ) like upper('"+dietType +"%')";
			cnt++;
        }

        if ( !(dietDescription == null || dietDescription.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(a.long_desc) like '"+dietDescription+"%'";
			else{
				sql=sql+" where upper(a.long_desc) like '"+dietDescription+"%'";
				cnt=1;
			}

        }
	   if ( !(shortDescription == null || shortDescription.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(a.short_desc) like '"+shortDescription+"%'";
			else{
				sql=sql+" where upper(a.short_desc) like '"+shortDescription+"%'";
				cnt=1;
			}

        }

	if ( !(ageGroup == null || ageGroup.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(a.age_group_code) like '"+ageGroup+"%'";
			else{
				sql=sql+" where upper(a.age_group_code) like '"+ageGroup +"%'";
				cnt =1;
			}
        }

	if (!(defaultDietType.equals("B"))){

		if(defaultDietType.equals("Y")){
			if(cnt>0)
				   sql = sql+" and nvl(a.default_yn,'N')='Y' ";
				else{
					sql=sql+ " where nvl(a.default_yn,'N')='Y' ";
					cnt=1;
				}
		}
		else if(defaultDietType.equals("Y")){
			if(cnt>0)
				   sql = sql+" and nvl(a.default_yn,'N')='N' ";
				else{
					sql=sql+ " where nvl(a.default_yn,'N')='N' ";
					cnt=1;
				}
		}
    }

	if ( !(orderCatlogcode == null || orderCatlogcode.equals("")) ){
		if(cnt>0)
			sql = sql + " and upper(a.order_catalog_code) like '"+orderCatlogcode+"%'";
		else{
			sql=sql+" where upper(a.order_catalog_code) like '"+orderCatlogcode +"%'";
			cnt =1;
		}
    }

	if ( !(defaultFeedType == null || defaultFeedType.equals("")) ){
		if(cnt>0)
			sql = sql + " and upper(a.default_feed_type) like '"+defaultFeedType+"%'";
		else{
			sql=sql+" where upper(a.default_feed_type) like '"+defaultFeedType +"%'";
			cnt =1;
		}
    }

	if (!(dietCycleType.equals("B"))){

		if(dietCycleType.equals("R")){
			if(cnt>0)
				   sql = sql+" and nvl(a.diet_cycle_type,'O')='R' ";
				else{
					sql=sql+ " where nvl(a.diet_cycle_type,'O')='R' ";
					cnt=1;
				}
		}
		else if(dietCycleType.equals("O")){
			if(cnt>0)
				   sql = sql+" and nvl(a.diet_cycle_type,'O')='O' ";
				else{
					sql=sql+ " where nvl(a.diet_cycle_type,'O')='O' ";
					cnt=1;
				}
		}
    }

	if ( !(dietCategory == null || dietCategory.equals("")) ){
		if(cnt>0)
			sql = sql + " and upper(a.diet_category_code) like '"+dietCategory+"%'";
		else{
			sql=sql+" where upper(a.diet_category_code) like '"+dietCategory +"%'";
			cnt =1;
		}
    }

	//ML-MMOH-CRF-0820 STARTS
	if (!(IPDietTypeYn.equals("B"))){
		if(IPDietTypeYn.equals("Y")){
			if(cnt>0)
				   sql = sql+" and nvl(a.ip_diet_type_yn,'N')='Y' ";
				else{
					sql=sql+ " where nvl(a.ip_diet_type_yn,'N')='Y' ";
					cnt=1;
				}
		}
		else if(IPDietTypeYn.equals("N")){
			if(cnt>0)
				   sql = sql+" and nvl(a.ip_diet_type_yn,'N')='N' ";
				else{
					sql=sql+ " where nvl(a.ip_diet_type_yn,'N')='N' ";
					cnt=1;
				}
		}
    	}
	
	if (!(DCDietTypeYn.equals("B"))){
		if(DCDietTypeYn.equals("Y")){
			if(cnt>0)
				   sql = sql+" and nvl(a.dc_diet_type_yn,'N')='Y' ";
				else{
					sql=sql+ " where nvl(a.dc_diet_type_yn,'N')='Y' ";
					cnt=1;
				}
		}
		else if(DCDietTypeYn.equals("N")){
			if(cnt>0)
				   sql = sql+" and nvl(a.dc_diet_type_yn,'N')='N' ";
				else{
					sql=sql+ " where nvl(a.dc_diet_type_yn,'N')='N' ";
					cnt=1;
				}
		}
    	}
	//ML-MMOH-CRF-0820 ENDS
	
	//ML-MMOH-CRF-0418 STARTS
	if (!(OPDietTypeYn.equals("B"))){
		if(OPDietTypeYn.equals("Y")){
			if(cnt>0)
				   sql = sql+" and nvl(a.op_diet_type_yn,'N')='Y' ";
				else{
					sql=sql+ " where nvl(a.op_diet_type_yn,'N')='Y' ";
					cnt=1;
				}
		}
		else if(OPDietTypeYn.equals("N")){
			if(cnt>0)
				   sql = sql+" and nvl(a.op_diet_type_yn,'N')='N' ";
				else{
					sql=sql+ " where nvl(a.op_diet_type_yn,'N')='N' ";
					cnt=1;
				}
		}
    	}

	if (!(EMDietTypeYn.equals("B"))){
		if(EMDietTypeYn.equals("Y")){
			if(cnt>0)
				   sql = sql+" and nvl(a.em_diet_type_yn,'N')='Y' ";
				else{
					sql=sql+ " where nvl(a.em_diet_type_yn,'N')='Y' ";
					cnt=1;
				}
		}
		else if(EMDietTypeYn.equals("N")){
			if(cnt>0)
				   sql = sql+" and nvl(a.em_diet_type_yn,'N')='N' ";
				else{
					sql=sql+ " where nvl(a.em_diet_type_yn,'N')='N' ";
					cnt=1;
				}
		}
    }
    //ML-MMOH-CRF-0418 ENDS

	//ML-MMOH-CRF-0419 STARTS HERE
	if (!(applstafforder_yn.equals("B"))){
		if(applstafforder_yn.equals("Y")){
			if(cnt>0)
				   sql = sql+" and nvl(a.APPL_STAFF_ORDER_YN,'N')='Y' ";
				else{
					sql=sql+ " where nvl(a.APPL_STAFF_ORDER_YN,'N')='Y' ";
					cnt=1;
				}
		}
		else if(applstafforder_yn.equals("N")){
			if(cnt>0)
				   sql = sql+" and nvl(a.APPL_STAFF_ORDER_YN,'N')='N' ";
				else{
					sql=sql+ " where nvl(a.APPL_STAFF_ORDER_YN,'N')='N' ";
					cnt=1;
				}
		}
    }
	//ML-MMOH-CRF-0419 ENDS HERE

	//ML-MMOH-CRF-0670-US001 STARTS HERE
	if (!(attdntorderappl_yn.equals("B"))){
		if(attdntorderappl_yn.equals("Y")){
		if(cnt>0){
			sql = sql+" and nvl(APPL_ATT_YN,'N')='Y' ";
		}else{
			sql=sql+ " where nvl(APPL_ATT_YN,'N')='Y' ";
			cnt=1;
			}
		}
	else if(attdntorderappl_yn.equals("N")){
	      if(cnt>0){
			sql = sql+" and nvl(APPL_ATT_YN,'N')='N' ";
	  	}else{
			sql=sql+ " where nvl(APPL_ATT_YN,'N')='N' ";
			cnt=1;
			}
		}
    }
	//ML-MMOH-CRF-0670-US001 ENDS HERE	
	   if (!(enabled.equals("B"))){
		if(enabled.equals("E")){
			if(cnt>0)
				   sql = sql+" and nvl(a.eff_status,'D')='E' ";
				else{
					sql=sql+ " where nvl(a.eff_status,'D')='E' ";
					cnt=1;
				}
		}
		else if(enabled.equals("D")){
			if(cnt>0)
				   sql = sql+" and nvl(a.eff_status,'D')='D' ";
				else{
					sql=sql+ " where nvl(a.eff_status,'D')='D' ";
					cnt=1;
				}
		}
    }
	   
	if(cnt>0)
		sql = sql+" and  a.ORDER_CATALOG_CODE=b.ORDER_CATALOG_CODE ";
	else{
		sql=sql+ " where a.ORDER_CATALOG_CODE=b.ORDER_CATALOG_CODE ";
		cnt=1;
	}
	
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

	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	int maxRecord = 0;
	ResultSet rset=null;
	ResultSet rs = null;

	try{
		String strsql="select count(*) as total from DS_DIET_TYPE a,or_order_catalog b "+sql;
		String strsql1="SELECT a.diet_type, a.long_desc, a.short_desc, a.age_group_code,ds_get_desc.ds_diet_category(diet_category_code,?,1) diet_category_code,"+
				" ds_get_desc.ds_feed_type (default_feed_type, ?, 2) default_feed_type, a.default_yn, a.diet_cycle_type, a.order_catalog_code,"+
                " a.ip_diet_type_yn,a.dc_diet_type_yn,a.op_diet_type_yn, a.em_diet_type_yn,a.APPL_STAFF_ORDER_YN,a.APPL_ATT_YN, a.eff_status status,"+
				" b.short_desc catalogDesc FROM ds_diet_type a,or_order_catalog b "+sql; //ML-MMOH-CRF-0418 ML-MMOH-CRF-0419 & CRF-0670 and Modified Against PMG2017-COMN-CRF-0012 [IN:066074]
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();
		rs.next();
		maxRecord = rs.getInt("total");

		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		stmt1=conn.prepareStatement(strsql1);
		// Added Against below PMG2017-COMN-CRF-0012 [IN:066074]
		stmt1.setString(1,locale);
		stmt1.setString(2,locale);
		rset = stmt1.executeQuery();
	}catch(Exception e){
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
    out.println("<A HREF='../../eDS/jsp/DietTypeQueryResult.jsp?from="+(start-14)+"&ph_module_yn="+ph_module_yn+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eDS/jsp/DietTypeQueryResult.jsp?from="+(start+14)+"&ph_module_yn="+ph_module_yn+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
<th class="columnheadercenter" >
	<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" >
	<fmt:message key="eOT.LongDescription.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" >
	<fmt:message key="eOT.ShortDescription.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" >
	<fmt:message key="eOT.AgeGroup.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" >
	<fmt:message key="eOT.DefaultDietType.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" >
	<fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/>
</th>
<th class="columnheadercenter" >
	<fmt:message key="eOT.DietCycleType.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" >
	<fmt:message key="eOT.DietCategory.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" >
	<fmt:message key="eOT.DefaultFeedType.Label" bundle="${ot_labels}"/>
</th>
<!--   ML-MMOH-CRF-0820 Starts -->
<th class="columnheadercenter" >
	<fmt:message key="eDS.IPDietType.Label" bundle="${ds_labels}"/>
</th>
<th class="columnheadercenter" >
	<fmt:message key="eDS.DCDietType.Label" bundle="${ds_labels}"/>
</th>
<!--   ML-MMOH-CRF-0820 Ends -->

<!--   ML-MMOH-CRF-0418 -->
<th class="columnheadercenter" >
	<fmt:message key="eDS.OPDietType.Label" bundle="${ds_labels}"/>
</th>
<!--   ML-MMOH-CRF-0418 -->
<th class="columnheadercenter" >
	<fmt:message key="eDS.EMDietType.Label" bundle="${ds_labels}"/>
</th>
<!--CRF-0419-->
<th class="columnheadercenter" >
	<fmt:message key="eDS.ApplForStaffOrder.Label" bundle="${ds_labels}"/>
</th>
<!--Added Against ML-MMOH-CRF-0670-US001 Starts Here -->
<th class="columnheadercenter" >
	<fmt:message key="eDS.ApplicableFor.Label" bundle="${ds_labels}"/>
	<option><%=DSCommonBeanObj.getAttendantLabel()%></option>
</th>
<!--Added Against ML-MMOH-CRF-0670-US001 Ends Here -->

<th class="columnheadercenter" >
	<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
</th>

<%
   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
	String classValue= " ";
      while ( rset.next() && i<=end  )
		{
    if ( i % 2 == 0 )
        classValue = "gridData" ; 
    else
       classValue = "gridData" ;  
    out.println("<tr><td align=='left' class='" + classValue + "' nowrap>");

	dietType = rset.getString(1);
	dietDescription=rset.getString(2);
	shortDescription= rset.getString(3);
	ageGroup = rset.getString(4);
	dietCategory = checkForNull(rset.getString(5));
	orderCatlogcode = checkForNull(rset.getString("catalogDesc"));
	defaultFeedType = checkForNull(rset.getString(6));
    defaultDietType = checkForNull(rset.getString(7));
    dietCycleType = checkForNull(rset.getString(8));
	IPDietTypeYn=checkForNull(rset.getString(10));   //ML-MMOH-CRF-0820
	DCDietTypeYn=checkForNull(rset.getString(11));   //ML-MMOH-CRF-0820
	OPDietTypeYn=checkForNull(rset.getString(12));   //ML-MMOH-CRF-0418
	EMDietTypeYn=checkForNull(rset.getString(13));   //ML-MMOH-CRF-0418
	applstafforder_yn=checkForNull(rset.getString(14));//ML-MMOH-CRF-0419
	attdntorderappl_yn=checkForNull(rset.getString(15));//ML-MMOH-CRF-0670-US001
	enabled = checkForNull(rset.getString(16));

	if(ageGroup==null || ageGroup.equals("null"))
		ageGroup="&nbsp;";

	String mode="modify";
	out.println("<a href='../../eDS/jsp/DietTypeAddModify.jsp?mode="+mode+"&dietType="+ dietType+"' target='f_query_add_mod' >");
    out.println(dietType+"</a></td>");
    out.println("<td class='" + classValue+"' nowrap>"+dietDescription+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+shortDescription+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+ageGroup+"</td>");
    out.println("<td class='" + classValue + "' align='center'>");
    if ( defaultDietType.equals("Y") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");
    out.println("<td class='" + classValue+"' nowrap>"+orderCatlogcode+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+dietCycleType+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+dietCategory+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+defaultFeedType+"</td>");
	//ML-MMOH-CRF-0820
	out.println("<td class='" + classValue + "' align='center'>");
    if ( "Y".equals(IPDietTypeYn) )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");

	out.println("<td class='" + classValue + "' align='center'>");
    if ( "Y".equals(DCDietTypeYn) )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");
	//ML-MMOH-CRF-0820

   	//ML-MMOH-CRF-0418
	out.println("<td class='" + classValue + "' align='center'>");
    if ( "Y".equals(OPDietTypeYn) )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");	
	//ML-MMOH-CRF-0418
	out.println("<td class='" + classValue + "' align='center'>");
    if ( "Y".equals(EMDietTypeYn) )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");	
	//Added against CRF-0419 Starts Here
	 out.println("<td class='" + classValue + "' align='center'>");
    if ( applstafforder_yn.equals("Y") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");
	//Added against CRF-0419 Ends Here
	//ML-MMOH-CRF-0670-US001 Starts Here
	out.println("<td class='" + classValue + "' align='center'>");
    if(attdntorderappl_yn.equals("Y")){
        	out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	}else{
	        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		out.println("</td>");
	}
    //ML-MMOH-CRF-0670-US001 Ends Here
	 out.println("<td class='" + classValue + "' align='center'>");
    if ( enabled.equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");
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
			e.printStackTrace();
		}
%>
</center>
</form>
</BODY>
</HTML>

