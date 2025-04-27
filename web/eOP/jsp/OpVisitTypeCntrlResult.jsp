<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.ConnectionManager,java.sql.*,java.util.*,java.net.*,java.text.*" contentType="text/html;charset=UTF-8"%>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	out.println("<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  OnMouseDown='CodeArrest();' class='CONTENT' onKeyDown = 'lockKey();'>");

    String whereClause = request.getParameter("whereclause");
    //String locale=(String)session.getValue("LOCALE");
	if(whereClause==null) whereClause="";
	StringBuffer sql = new StringBuffer("");
    String from = request.getParameter( "from" );
    String to = request.getParameter( "to" ) ;
   	
	String facilityid  = (String) session.getValue("facility_id");	
  	String cliniccode="";
	String servicecode="";
	String clinicdesc="" ;
	String servicedesc="";
	
	if ( (whereClause == null || whereClause.equals("")))
	{
	     cliniccode=request.getParameter("clinic_code")==null ? "" : request.getParameter("clinic_code").trim();         
	     clinicdesc= request.getParameter("clinic_desc")==null?"" : request.getParameter("clinic_desc").trim();
	      servicedesc=request.getParameter("service_desc")==null?"" :                  request.getParameter("service_desc").trim();
	     servicecode=request.getParameter("service_code")==null?"" :                  request.getParameter("service_code").trim();
		
		
		int andCheck = 0;

        /* The sql query is dynamically created based on the values of operating facilityid, facility name and service name --- Srijagadeesh.*/

		if ( !(cliniccode== null || cliniccode.equals("")))
        {
			if ( andCheck == 1 )
			{
			sql.append(" and ");
			sql.append("upper(b.CLINIC_CODE) like upper('"+cliniccode+"%')");
	        }
		
		   else
		   {    	
				sql.append(" and ");
				sql.append("upper(b.CLINIC_CODE) like upper('"+cliniccode+"%')");
	           andCheck = 1;
            }
		
		
		}

		if ( !(clinicdesc== null || clinicdesc.equals("")))
        {
			if ( andCheck == 1 )
            {
				sql.append(" and ");
                sql.append("upper(b.LONG_DESC) like upper('"+clinicdesc+"%')");
            }
            else
            {
				sql.append(" and ");
				sql.append("upper(b.LONG_DESC) like upper('"+clinicdesc+"%')");
                andCheck = 1;
            }
        }


        if ( !(servicecode== null || servicecode.equals("")))
        {
			if ( andCheck == 1)
            { 
				sql.append(" and ");
                sql.append("upper(c.SERVICE_CODE) like upper('"+servicecode+"%')");
            }
            else
            {
				sql.append(" and ");
				sql.append("upper(c.SERVICE_CODE) like upper('"+servicecode+"%')");
                andCheck = 1;
            }
        }

		if ( !(servicedesc== null || servicedesc.equals("")) )
	    {
			if ( andCheck == 1 )
			{
				sql.append(" and ");
	        			
				sql.append("upper(c.SHORT_DESC) like upper('"+servicedesc+"%')");
		    
			
			}
			else
	        {
				sql.append(" and ");
				sql.append(" upper(c.SHORT_DESC ) like upper('"+servicedesc+"%')");
			    andCheck = 1;
			}
		}
    }

    //appending order by clause

	String ord[] = request.getParameterValues("orderbycolumns");

    if ( !(ord == null || ord .equals("")) )
    {
        sql.append(" order by ");
        for ( int i=0;i < ord.length;i++ )
        {
		    if ( i == ord.length - 1 )
			    sql.append(ord[i]);
	        else
		        sql.append(ord[i]+",");
        }
    }
     //end of where clause IF
    else
        sql.append(whereClause);

    int start = 0 ;
    int end = 0 ;
    int i=1;	
	int cnt = 0;

    if (from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null)
        end = 14;
    else
        end = Integer.parseInt( to ) ;
	
	Connection conn=null;
	//PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	ResultSet rs=null;
	//int maxRecord = 0;
	try
	{
		conn = ConnectionManager.getConnection(request);	
		/*String sql1="select count(*) as total from op_param_for_facy_service_vw  "+sql;
		pstmt = conn.prepareStatement(sql1);
		rs = pstmt.executeQuery();

		if(rs!=null)
		{
			rs.next();
			maxRecord = rs.getInt("total");
			if(maxRecord == 0)
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");*/

			
			String sql1="select a.CLINIC_CODE clinic_code, a.SERVICE_CODE service_code, b.LONG_DESC clinic_desc, c.SHORT_DESC service_desc from OP_VISIT_TYPE_CONTROL a, op_clinic b, am_service c where a.FACILITY_ID ='"+facilityid+"' and a.FACILITY_ID = b.FACILITY_ID and a.CLINIC_CODE = b.CLINIC_CODE and a.SERVICE_CODE = c.SERVICE_CODE"+ sql;				
					
			pstmt1 = conn.prepareStatement(sql1);
			rs = pstmt1.executeQuery();

			if ( start != 1 )
				for( int j=1; j<start; i++,j++ )
					rs.next();
			while( i<=end && rs.next() )
			{
			  if (cnt == 0)
				{
					
               %>

			<P>
			<table align='right'>
			<tr>
			<td>
			   <%
				if ( !(start <= 1) )
					out.println("<A HREF='../../eOP/jsp/OpVisitTypeCntrlResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
				
					out.println("<A id='nextval' HREF='../../eOP/jsp/OpVisitTypeCntrlResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			      %>
			
			 </td>
			 </tr>
			 </table>
			 <br><br>
			 </P>

			 <table border="1" width="100%" cellspacing='0' cellpadding='0'>
				<th class='columnheader'><fmt:message key="Common.ClinicCode.label" bundle="${common_labels}"/></th>
				<th class='columnheader'><fmt:message key="Common.ClinicDescription.label" bundle="${common_labels}"/></th>
				<th class='columnheader'><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></th>
				<th class='columnheader'><fmt:message key="Common.ServiceDescription.label" bundle="${common_labels}"/></th>
           		
			  <%
				}
			    	String classValue="";
					if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				    else
				   classValue = "QRYODD" ;
					out.println("<tr><td class='" + classValue + "'>");
					String clinic_code = rs.getString("clinic_code").trim();
					String clinic_desc=rs.getString("clinic_desc").trim();
					String service_code=rs.getString("service_code").trim()	;									
					String service_desc=rs.getString("service_desc").trim();
					
					
					//String  noof_visits=rs.getString("NO_OF_FOLLOW_UP_VISITS_ALLOWED");
                    //String  dura_for_follow=rs.getString("DUR_FOR_FOLLOW_UP_VSTS_IN_DAYS");
					
					out.println("<a href='../../eOP/jsp/addModifyOPVisitTypeCtrl.jsp?clinic_code="+clinic_code +"&service_code="+service_code+"' target='f_query_add_mod'>");
					out.println(clinic_code+"</a></td><td  class='" + classValue + "'>");
				
					out.println( clinic_desc);
					out.println("</td><td class='" + classValue + "'>");
					
					out.println("<a href='../../eOP/jsp/addModifyOPVisitTypeCtrl.jsp?clinic_code="+clinic_code +"&service_code="+service_code+"' target='f_query_add_mod'>");
					out.println(service_code);

					out.println("</a></td><td class='" + classValue + "'>");
    
					out.println(service_desc);
					i++;
					cnt++;
	}
			
	   if (cnt == 0)
	  out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");

	if (!rs.next() && cnt!=0)
	{
		%>
		
		<script>
			document.getElementById("nextval").innerHTML = " ";
		</script>

		<%
	}	
	
	if(rs != null ) rs.close();
	//if(pstmt!=null) pstmt.close();
	if(pstmt1!=null)    pstmt1.close();

	}
	catch(Exception e){out.print(e);}
	finally
	{
		//if(pstmt!=null) pstmt.close();
		
		System.out.println(request);
		if(pstmt1!=null)    pstmt1.close();
		if(rs!=null)        rs.close();
		  ConnectionManager.returnConnection(conn,request); 

	}
%>
</td></tr>
</table>
<br>
</BODY>
</HTML>

