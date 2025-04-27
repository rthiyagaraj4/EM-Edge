<!DOCTYPE html>
<!--
     Program to query the VisitType for Patients 
-->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,eCommon.Common.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<HTML><head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head><BODY  OnMouseDown='CodeArrest();' class='CONTENT'  onKeyDown = 'lockKey();'>

<%
    String whereClause = request.getParameter("whereclause");
   	StringBuffer sql =new StringBuffer();
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    Connection conn = null ;
	ResultSet rs = null;
	Statement stmt =null;

/* The SQL query is used to retrieve the results based on the facilityID,visittypeCode,
 visittype_ind ,LongDesc and Effective Status.*/
 
 try{
	 conn  =  ConnectionManager.getConnection(request);
	 Boolean isAERegisterTypeAutoUpdateAppl =	CommonBean.isSiteSpecific(conn, "AE", "AE_REG_TYPE_AUTO_UPDATE"); // added by mujafar for KDAH-CRF-0526
	 
	 Boolean isVIRTUAL_CONSULTATION  = eCommon.Common.CommonBean.isSiteSpecific(conn,"OP","VIRTUAL_CONSULTATION");//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 on 19-04-2023 -->
	 
    if ( (whereClause == null || whereClause.equals("")) )
    {
   
    String facilityid=(String)session.getValue("facility_id");
    String cd = request.getParameter("visit_type_code");
    String ccd = request.getParameter("visit_type_ind");
    String longdesc = request.getParameter("long_desc");
    String enabled = request.getParameter("eff_status");

    int andCheck = 0;
    cd=cd.toUpperCase();
    

    if ( !(facilityid == null || facilityid.equals("")) )
            {
            sql.append("where upper(facility_id) = upper('"+facilityid+"')");
			
			if(!isAERegisterTypeAutoUpdateAppl && ccd.equals("A") ) // Added by mujafar for KDAH-CRF-0526
				 sql.append(" and visit_type_ind not in ( 'W') ");
            
			andCheck = 1;
        }
    if ( !(cd == null || cd.equals("")) )
        {
        sql.append(" and upper(visit_type_code) like upper('"+cd+"%')");
        andCheck = 1;
        }
    if ( !(ccd == null || ccd.equals("")) &&  !ccd.equals("A") )
    {
        if ( andCheck == 1 )
        {
            sql.append(" and ");
            sql.append("visit_type_ind like  '"+ccd+"%'");
        }
        else
        {
              sql.append("where visit_type_ind like '"+ccd+"%'" );
              andCheck = 1;
        }

    }

    if ( !(longdesc == null || longdesc.equals("")) )
    {
        if ( andCheck == 1 )
        {   sql.append(" and ");
            sql.append("upper(long_desc) like  upper('"+longdesc+"%')");
        }
        else
        {
            sql.append("where upper(long_desc) like upper('"+longdesc+"%')" );
            andCheck = 1;
        }
    }
    if ( !(enabled == null || enabled.equals("")) )
    {
         if( enabled.equals("E") )
         {
            if ( andCheck == 0 )
           sql.append("where eff_status='E'");
        else
           sql.append(" and eff_status='E'");
         }
         if ( enabled.equals("D") )
         {
                    if ( andCheck == 0 )
                       sql.append(" where  eff_status='D'");
                    else
                       sql.append(" and eff_status='D'");
         }    
         
        
    }
  
    String ord[] = request.getParameterValues("orderbycolumns");

    if ( !(ord == null || ord .equals("")) )
    {
        sql.append(" order by ");
        for ( int i=0;i < ord.length;i++ )
        {
        if ( i == ord.length - 1 )
            sql.append(ord[i]);
        else
            sql.append(ord[i]).append(",");
        }
    }
	
    } 
	else
        sql.append(whereClause);

    int start = 0 ;
    int end = 0 ;
    int i=1;
	int cnt=0;
	String endOfRes="1";

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 14 ;
    else
        end = Integer.parseInt( to ) ;	


stmt = conn.createStatement();

/*int maxRecord = 0;
rs = stmt.executeQuery("select count(*) as total from op_visit_type "+sql.toString());
rs.next();
maxRecord = rs.getInt("total");

if(rs != null) rs.close(); */

rs = stmt.executeQuery("select * from op_visit_type "+sql.toString()); 

if ( start != 1 )
    for( int j=1; j<start; i++,j++ )
      rs.next() ;

while(i<=end && rs.next()) 
{
	if(cnt==0)
	{
%>

<P>
<table align='right'>
<tr>
<td>
<%

 /* The Following block displays  14 records per page. we see the records
    bidirectionally by using Next and Previous hiperLinks */

if ( !(start <= 1) )
     
     out.println("<A HREF='../../eOP/jsp/queryVisittype.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
 
if ( endOfRes.equals("1") )
    
     out.println("<A id='nextval' HREF='../../eOP/jsp/queryVisittype.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
  
  %>
</td>
</tr>
</table>
<br><br>
</P>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.Color.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></th> <!-- BRU-HIMS-CRF-177 -->
<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 on 19-04-2023 Started-->
<% if(isVIRTUAL_CONSULTATION){ %>
<td class='columnheader'><fmt:message key="Common.virtualConsultation.label" bundle="${common_labels}"/></td>
<% } %>
<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 on 19-04-2023 End-->


<!--Display the records -->

<%
}    
    String classValue = "" ;
     
    if ( i % 2 == 0 )
                classValue = "QRYEVEN" ;
            else
            classValue = "QRYODD" ;
      
    out.println("<tr><td align='left' class='" + classValue + "'>");
  	String facilityid=(String)session.getValue("facility_id");
    String code = rs.getString("visit_type_code");
    String func="modify";
	String color = rs.getString("color_indicator")==null?"":rs.getString("color_indicator");// BRU-HIMS-CRF-177
    out.println("<a href='../../eOP/jsp/addOPVisitType.jsp?facility_id="+facilityid+" &visit_type_code="+ code + "&fun_value="+func+"' target='f_query_add_mod' >");
   
	out.println(code+"</a></td><td class='" + classValue + "' >");
  	out.println( rs.getString("long_desc") );
    out.println("</td><td class='" + classValue + "'>");
    out.println(rs.getString("short_desc") );
    out.println("</td><td class='" + classValue + "'>");
    String vtype = rs.getString("visit_type_ind");
    if (vtype.equals("F")) {
    out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.first.label","common_labels"));
    }
    else if(vtype.equals("L")) {
    out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels"));
    }
    else if(vtype.equals("R")) {
    out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels"));
    }
    else if(vtype.equals("E")) {
    out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels"));
    }
    else if(vtype.equals("S")) {
    out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Series.label","common_labels"));
    }else if(vtype.equals("W")) { // added by mujafar for KDAH-CRF-0526
	 out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels")+"&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels"));
   
    }
    else {
    out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ReferralfoConsult.label","op_labels"));
    }
	
	 /* BRU-HIMS-CRF-177 */
	out.println("</td><td class='" + classValue + "' style=background-color:"+color+">&nbsp;"); // td Close inside of the if loop
	
	
	 
	
	
	
    out.println("</td><td align='center' class='" + classValue + "'>");

    if ( rs.getString("eff_status").equals("E") )
      out.println("<img src='../../eCommon/images/enabled.gif'></img>");
   
	else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
    
    //<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 on 19-04-2023 Started-->
     if(isVIRTUAL_CONSULTATION)
     {
	    out.println("</td><td align='center' class='" + classValue + "'>");
	    if(rs.getString("VIRTUAL_CONSULTATION").equals("E"))
	    out.println("<img src='../../eCommon/images/enabled.gif'></img></td>");
    
    else
      	out.println("<img src='../../eCommon/images/RRnwd.gif'></img></td>");
	    
     }
   //<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 on 19-04-2023 Ended-->
	
    
	i++;
	cnt++;
} 

if(cnt==0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");

if (!rs.next() && cnt!=0 )
    {
    endOfRes = "0";	
	
%>
<script>
	document.getElementById("nextval").innerHTML=" ";
	//document.getElementById("nextval").style.visibility='hidden';
</script>

<% } %>

</td></tr>
</table>
</center>
<br><center>

<%

sql.setLength(0);
}
catch(Exception e ){}
finally
{
	// Added by Raj when dealing with unclosed connections and resultsets 
	try{
	if (rs!=null) rs.close();
	if(stmt!=null)stmt.close();	
	}catch(Exception e){}
    if(conn!=null) ConnectionManager.returnConnection(conn,request); 
}
%>

</center>
</BODY>
</HTML>

