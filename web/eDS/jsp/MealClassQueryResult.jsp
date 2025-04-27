<!DOCTYPE html>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%//String locale = (String)session.getAttribute("LOCALE"); %>
<!--Added Against ML-MMOH-CRF-1005-US1 -->
<jsp:useBean id="DSCommonBeanObj" class="eDS.DSCommonBean"/> 
<jsp:setProperty name="DSCommonBeanObj" property="FacilityId" value='<%=session.getAttribute("facility_id").toString()%>'/> 
<!--Added Against ML-MMOH-CRF-1005-US1 -->
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
	String mealClass = request.getParameter("mealClass")==null?"":request.getParameter( "mealClass" ).trim().toUpperCase();
	String longDesc =request.getParameter("longDesc")==null?"":request.getParameter( "longDesc" ).trim().toUpperCase();
	String shortDesc =request.getParameter("shortDesc")==null?"":request.getParameter( "shortDesc" ).trim().toUpperCase();
	String applstafforder_yn=request.getParameter("applstafforder_yn")==null?"":request.getParameter( "applstafforder_yn");//CRF-0419
	String editmenuappl_yn=request.getParameter("editmenuappl_yn")==null?"":request.getParameter( "editmenuappl_yn");//ML-MMOH-CRF-0669-US1
	String attdntorderappl_yn=request.getParameter("attdntorderappl_yn")==null?"":request.getParameter( "attdntorderappl_yn");//Added Against ML-MMOH-CRF-1005-US1
	String bedClassCode=request.getParameter("bedClassCode")==null?"":request.getParameter( "bedClassCode");//ML-MMOH-CRF-0673
	String enabledYn = request.getParameter("enabledYn")==null?"":request.getParameter( "enabledYn");

    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(mealClass == null || mealClass.equals("")) ){
	        sql = sql + " where upper(MEAL_CLASS ) like upper('"+mealClass +"%')";
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

	//ML-MMOH-CRF-0419 STARTS HERE
	if (!(applstafforder_yn.equals("B"))){
		if(applstafforder_yn.equals("Y")){
			if(cnt>0)
				   sql = sql+" and nvl(APPL_STAFF_ORDER_YN,'N')='Y' ";
				else{
					sql=sql+ " where nvl(APPL_STAFF_ORDER_YN,'N')='Y' ";
					cnt=1;
				}
		}
		else if(applstafforder_yn.equals("N")){
			if(cnt>0)
				   sql = sql+" and nvl(APPL_STAFF_ORDER_YN,'N')='N' ";
				else{
					sql=sql+ " where nvl(APPL_STAFF_ORDER_YN,'N')='N' ";
					cnt=1;
				}
		}
    }
	//ML-MMOH-CRF-0419 ENDS HERE
    //ML-MMOH-CRF-0669-US1 STARTS HERE
	if (!(editmenuappl_yn.equals("B"))){
		if(editmenuappl_yn.equals("Y")){
		if(cnt>0){
				   sql = sql+" and nvl(EDIT_MENU_APPL_YN,'N')='Y' ";
		}else{
					sql=sql+ " where nvl(EDIT_MENU_APPL_YN,'N')='Y' ";
					cnt=1;
				}
		}
		else if(editmenuappl_yn.equals("N")){
		      if(cnt>0){
				  sql = sql+" and nvl(EDIT_MENU_APPL_YN,'N')='N' ";
			  }else{
					sql=sql+ " where nvl(EDIT_MENU_APPL_YN,'N')='N' ";
					cnt=1;
				}
		}
    }
//ML-MMOH-CRF-0669-US1 ENDS HERE

	//ML-MMOH-CRF-1005-US1 STARTS HERE
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
	//ML-MMOH-CRF-1005-US1 ENDS HERE
	
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

		String strsql="select count(*) as total from ds_meal_class "+sql;
		String strsql1="select meal_class,long_desc,short_desc,eff_status,APPL_STAFF_ORDER_YN,EDIT_MENU_APPL_YN,APPL_ATT_YN,BED_CLASS_CODE from ds_meal_class "+sql;//ML-MMOH-CRF-0669-US1 & CRF-673 & CRF-1005-US1
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
		out.println("sdfsadfs "+e);
	}
%>
<form name='QueryResult' id='QueryResult'>

<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eDS/jsp/MealClassQueryResult.jsp?from="+(start-14)+"&ph_module_yn="+ph_module_yn+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eDS/jsp/MealClassQueryResult.jsp?from="+(start+14)+"&ph_module_yn="+ph_module_yn+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.LongDescription.Label" bundle="${ot_labels}"/>
</th>
<th class="columnheadercenter" nowrap>
	<fmt:message key="eOT.ShortDescription.Label" bundle="${ot_labels}"/>
</th>
<!-- CRF-419-US8 -->
<th class="columnheadercenter" nowrap>
	<fmt:message key="eDS.ApplForStaffOrder.Label" bundle="${ds_labels}"/>
</th>
<!-- ML-MMOH-CRF-0669-US1 -->
<th class="columnheadercenter" nowrap>
	<fmt:message key="eDS.ApplicableEditMenu.Label" bundle="${ds_labels}"/>
</th>
<!--Added Against ML-MMOH-CRF-1005-US1 Starts Here -->
<th class="columnheadercenter" nowrap>
	<fmt:message key="eDS.ApplicableFor.Label" bundle="${ds_labels}"/>
	<option><%=DSCommonBeanObj.getAttendantLabel()%></option>
</th>
<!--Added Against ML-MMOH-CRF-1005-US1 Ends Here -->
<th class="columnheadercenter" nowrap>
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
                    classValue = "gridData" ;  // changed by yadav
                else
            classValue = "gridData" ;  // changed by yadav
    	out.println("<tr><td align=='left' class='" + classValue + "' nowrap>");

	mealClass = rset.getString(1);
	longDesc=rset.getString(2);
	shortDesc= rset.getString(3);
	enabledYn = rset.getString(4);
	applstafforder_yn = rset.getString(5);//CRF-419-US8
	editmenuappl_yn = rset.getString(6);//ML-MMOH-CRF-0669-US1  
	attdntorderappl_yn = rset.getString(7);//ML-MMOH-CRF-1005-US1  
	bedClassCode = rset.getString(8);//ML-MMOH-CRF-0673

	String mode="modify";
	out.println("<a href='../../eDS/jsp/MealClassAddModify.jsp?mode="+mode+"&mealClass="+ mealClass+"' target='f_query_add_mod' >");
    out.println(mealClass+"</a></td>");
    out.println("<td class='" + classValue+"' nowrap>"+longDesc+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+shortDesc+"</td>");
    //CRF-419-US8
	 out.println("<td class='" + classValue + "' align='center'>");
    if ( applstafforder_yn.equals("Y") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");
    //CRF-419-US8
	
    //ML-MMOH-CRF-0669-US1
    out.println("<td class='" + classValue + "' align='center'>");
    if ( editmenuappl_yn.equals("Y") ){
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	}else{
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");
	}
    //ML-MMOH-CRF-0669-US1
	
	//ML-MMOH-CRF-1005-US1 Starts Here
	out.println("<td class='" + classValue + "' align='center'>");
    if ( attdntorderappl_yn.equals("Y") ){
        	out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	}else{
	        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		out.println("</td>");
	}
    //ML-MMOH-CRF-1005-US1 Ends Here
	
    out.println("<td class='" + classValue + "' align='center'>");
    if ( enabledYn.equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");

//	out.println("<td class='" + classValue + "' align='center'>");
	/*if ( image_linked_yn.equals("Y") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");*/

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
	out.println("here "+e);
}
%>

</center>
</form>
</BODY>
</HTML>

