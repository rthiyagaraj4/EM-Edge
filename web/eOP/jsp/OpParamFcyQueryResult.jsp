<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.ConnectionManager,java.sql.*,java.util.*,java.net.*,java.text.*" contentType="text/html;charset=UTF-8"%>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	out.println("<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  OnMouseDown='CodeArrest();' class='CONTENT' onKeyDown = 'lockKey();'>");

    String whereClause = request.getParameter("whereclause");
    if(whereClause==null) whereClause="";

	StringBuffer sql = new StringBuffer("");
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;

  	if ( (whereClause == null || whereClause.equals("")) )
	{
	    String operatingfacilityid= request.getParameter("operating_facility_id");
	    String facilityname=request.getParameter("facility_name");
	    String servicecode= request.getParameter("service_code");
	    String servicedesc= request.getParameter("service_short_desc");
	    int andCheck = 0;

        /* The sql query is dynamically created based on the values of operating facilityid, facility name and service name --- Srijagadeesh.*/

		if ( !(operatingfacilityid== null || operatingfacilityid.equals("")) )
        {
			sql.append(" where upper(operating_facility_id) like upper('"+operatingfacilityid+"%') ");
	        andCheck = 1;
        }

		if ( !(facilityname== null || facilityname.equals("")) )
        {
			if ( andCheck == 1 )
            {
				sql.append(" and ");
                sql.append("upper(facility_name) like  upper('"+facilityname+"%')");
            }
            else
            {
				sql.append("where upper(facility_name) like upper('"+facilityname+"%')");
                andCheck = 1;
            }
        }


        if ( !(servicecode== null || servicecode.equals("")) )
        {
			if ( andCheck == 1 )
            { 
				sql.append(" and ");
                sql.append("upper(service_code) like  upper('"+servicecode+"%')");
            }
            else
            {
				sql.append("where upper(service_code) like upper('"+servicecode+"%')");
                andCheck = 1;
            }
        }

		if ( !(servicedesc== null || servicedesc.equals("")) )
	    {
			if ( andCheck == 1 )
			{
				sql.append(" and ");
	            sql.append("upper(service_short_desc) like  upper('"+servicedesc+"%')");
		    }
			else
	        {
				sql.append("where upper(service_short_desc) like upper('"+servicedesc+"%')");
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

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 14 ;
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

			String sql1="select * from op_param_for_facy_service_vw  "+sql;			
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
					out.println("<A HREF='../../eOP/jsp/OpParamFcyQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
				
					out.println("<A id='nextval' HREF='../../eOP/jsp/OpParamFcyQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			%>
			</td>
			</tr>
			</table>
			<br><br>
			</P>

			<table border="1" width="100%" cellspacing='0' cellpadding='0'>
				<th  class='columnheader'><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
				<th  class='columnheader'><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
				<th  class='columnheader'><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></th>
				<th  class='columnheader'><fmt:message key="Common.ServiceDescription.label" bundle="${common_labels}"/></th>


			<%
				}
			    
					String classValue="";
				
					if ( i % 2 == 0 )
						classValue = "QRYEVEN" ;
				    else
						classValue = "QRYODD" ;

					out.println("<tr><td class='" + classValue + "'>");

					String id = rs.getString("operating_facility_id");
					String name = rs.getString("facility_name");
					String code=rs.getString("service_code");
					String desc=rs.getString("service_short_desc");

					
					

					out.println("<a href='../../eOP/jsp/addModifyOpParamFcy.jsp?operating_facility_id="+id+"&facility_name="+name +"&service_code="+code+"' target='f_query_add_mod'>");
					out.println(id+"</a></td><td  class='" + classValue + "'>");
	
					out.println( name);
					out.println("</td><td class='" + classValue + "'>");

					out.println("<a href='../../eOP/jsp/addModifyOpParamFcy.jsp?operating_facility_id="+id+" &facility_name="+name +"&service_code="+code+"' target='f_query_add_mod'>");
					out.println(code);

					out.println("</a></td><td class='" + classValue + "'>");
    
					out.println(desc);
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

