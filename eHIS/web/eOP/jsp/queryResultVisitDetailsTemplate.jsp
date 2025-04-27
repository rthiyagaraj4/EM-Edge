<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.ConnectionManager,java.sql.*,java.util.*,java.net.*,java.text.*" contentType="text/html;charset=UTF-8"%>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	out.println("<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  OnMouseDown='CodeArrest();' class='CONTENT' onKeyDown = 'lockKey();'>");
     
    String whereClause = request.getParameter("whereclause");
   // String whereClause="";
	String locale=(String)session.getValue("LOCALE");
	if(whereClause==null) whereClause="";
	StringBuffer sql = new StringBuffer("");
    String from = request.getParameter( "from" );
    String to = request.getParameter( "to" ) ;
   	
	String facilityid  = (String) session.getValue("facility_id");	
  	//String code="";
	/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
	String room_desc="";
	/*CRF end SS-CRF-0010 [IN034516]*/
	//String description="";
	String cliniccode="";
	String clinicdesc="";
	String temp_code="";
	String desc="";
	String locn_code="";
	String room_num="";
	String service_code="";
    String service_desc="";
	String subservice_code="";
    String subservice_desc="";
	String visit_type_code="";
	String visit_type_desc="";
	String practitioner_id="";
	String other_res_class="";
	String other_res_desc="";
	String other_resource_id="";
	String other_resource_code="";
	String order_catlog_code="";
	String order_catlog_desc="";
	String contact_reason_code="";
	String contact_reason_desc="";
	String finval="modify";
	//String locn_decn="";
	String practitioner_code="";
	String locn_type="";
	String locn_desc="";
	if ( (whereClause == null || whereClause.equals("")))
	{
	     cliniccode=request.getParameter("code")==null ? "" : request.getParameter("code").trim();         
	     clinicdesc= request.getParameter("code_desc")==null?"" : request.getParameter("code_desc").trim();
	      	
		
		int andCheck = 0;

        /* The sql query is dynamically created based on the values of operating facilityid, facility name and service name --- Srijagadeesh.*/

		if ( !(cliniccode== null || cliniccode.equals("")))
        {
			if ( andCheck == 1 )
			{
			sql.append(" and ");
			sql.append("upper(TEMPLATE_CODE) like upper('"+cliniccode+"%')");
	        }
		
		   else
		   {    	
				sql.append(" and ");
				sql.append("upper(TEMPLATE_CODE) like upper('"+cliniccode+"%')");
	           andCheck = 1;
            }
		
		
		}

		if ( !(clinicdesc== null || clinicdesc.equals("")))
        {
			if ( andCheck == 1 )
            {
				sql.append(" and ");
                sql.append("upper(DESCRIPTION) like upper('"+clinicdesc+"%')");
            }
            else
            {
				sql.append(" and ");
				sql.append("upper(DESCRIPTION) like upper('"+clinicdesc+"%')");
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
           /* Below line query modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
			String sql1="SELECT template_code, description, locn_code, b.clinic_type locn_type, op_get_desc.op_clinic ('"+facilityid+"', locn_code, '"+locale+"', 1) locn_desc, room_num,am_get_desc.am_facility_room (a.facility_id,room_num,'"+locale+"', 2) room_desc, a.service_code,am_get_desc.am_service(a.service_code,'"+locale+"', 2)service_desc, subservice_code,am_get_desc.am_subservice(a.service_code,subservice_code,'"+locale+"',2)subservice_desc, visit_type_code,op_get_desc.op_visit_type('"+facilityid+"',visit_type_code,'"+locale+"',2)visit_type_desc, practitioner_id, am_get_desc.AM_PRACTITIONER (practitioner_id,'"+locale+"', 1) pract_name, other_res_class,am_get_desc.AM_RESOURCE_TYPE('"+facilityid+"',other_res_class,'"+locale+"',2)other_res_desc, other_resource_id,am_get_desc.AM_RESOURCE ('"+facilityid+"',other_resource_id,'"+locale+"',2) resource_desc,order_catalog_code,or_get_desc.or_order_catalog(order_catalog_code,'"+locale+"',2) order_cat_desc,contact_reason_code,am_get_desc.AM_CONTACT_REASON (contact_reason_code,'"+locale+"',1) reason_desc FROM op_template_for_vis_regn a,  op_clinic b WHERE a.FACILITY_ID ='"+facilityid+"' AND a.FACILITY_ID = b.FACILITY_ID  AND a.LOCN_CODE = b.CLINIC_CODE"+sql;		
           /*CRF end SS-CRF-0010 [IN034516]*/			
			
			
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
					out.println("<A HREF='../../eOP/jsp/queryResultVisitDetailsTemplate.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
				
					out.println("<A id='nextval' HREF='../../eOP/jsp/queryResultVisitDetailsTemplate.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			      %>
			
			 </td>
			 </tr>
			 </table>
			 <br><br>
			 </P>

			 <table border="1" width="100%" cellspacing='0' cellpadding='0'>
				<th class='columnheader' ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
				<th class='columnheader' ><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				<th class='columnheader' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
				<th class='columnheader'><fmt:message key="Common.room.label" bundle="${common_labels}"/></th>
           		<th class='columnheader' ><fmt:message key="Common.service.label" bundle="${common_labels}"/></th>
			  <th class='columnheader'  ><fmt:message key="Common.subservice.label" bundle="${common_labels}"/></th>
			 <th class='columnheader'  ><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></th>
			  <th class='columnheader'  ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
			  <th class='columnheader'  ><fmt:message key="eOP.otherrestype.label" bundle="${op_labels}"/></th>
			  <th class='columnheader'  ><fmt:message key="eOP.OtherResource.label" bundle="${op_labels}"/></th>
			  <th class='columnheader'  ><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></th>
			 <th class='columnheader' ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></th>
			  
			  
			  <%
				
			  }
			    	String classValue="";
					if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				    else
				   classValue = "QRYODD" ;
				 temp_code = rs.getString("TEMPLATE_CODE")==null ? "" : rs.getString("TEMPLATE_CODE"); 
				
				    desc=rs.getString("DESCRIPTION")==null ? "" : rs.getString("DESCRIPTION"); 
				    locn_code=rs.getString("LOCN_CODE")==null ?"" : rs.getString("LOCN_CODE"); 	
					locn_desc=rs.getString("locn_desc")==null ?"" : rs.getString("locn_desc"); 				
					room_num=rs.getString("room_num")==null ?"" : rs.getString("room_num"); 
					/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
                    room_desc=rs.getString("room_desc")==null ?"" : rs.getString("room_desc");
					/*CRF end SS-CRF-0010 [IN034516]*/
					 service_code=rs.getString("service_code")==null ? "" : rs.getString("service_code"); 
					service_desc=rs.getString("service_desc")==null ? "" : rs.getString("service_desc");
					 subservice_code=rs.getString("subservice_code")==null ? "" : rs.getString("subservice_code"); 
					 subservice_desc=rs.getString("subservice_desc")==null ? "" : rs.getString("subservice_desc"); 
					 visit_type_code=rs.getString("visit_type_code")==null ? "" :     rs.getString("visit_type_code");                                            
					visit_type_desc=rs.getString("visit_type_desc")==null ? "" : rs.getString("visit_type_desc"); 
					practitioner_id=rs.getString("pract_name")==null ? "" :          
					 rs.getString("pract_name");                                                
					 practitioner_code=rs.getString("practitioner_id")==null ? "" :     
					 rs.getString("practitioner_id"); 
					 other_res_class=rs.getString("OTHER_RES_CLASS")==null ? "" : rs.getString("OTHER_RES_CLASS"); 
					 other_res_desc=rs.getString("other_res_desc")==null ? "" : rs.getString("other_res_desc"); 
					 other_resource_id=rs.getString("resource_desc")==null ? "" : rs.getString("resource_desc"); 
					 other_resource_code=rs.getString("OTHER_RESOURCE_ID")==null ? "" : rs.getString("OTHER_RESOURCE_ID");
					 order_catlog_desc=rs.getString("order_cat_desc")==null ? "" : rs.getString("order_cat_desc"); 
				      order_catlog_code=rs.getString("ORDER_CATALOG_CODE")==null ? "" : rs.getString("ORDER_CATALOG_CODE"); 
					   
					   contact_reason_desc=rs.getString("reason_desc")==null ? "" :rs.getString("reason_desc");
	                    contact_reason_code=rs.getString("contact_reason_code")==null ? "" :rs.getString("contact_reason_code");
			        locn_type=rs.getString("locn_type")==null ? "" :rs.getString("locn_type");
			
		         	
				
				
				
				/*  temp_code = rs.getString("TEMPLATE_CODE")==null ? "" : rs.getString("TEMPLATE_CODE"); 
				
					 desc=rs.getString("DESCRIPTION")==null ? "" : rs.getString("DESCRIPTION"); 
				    locn_code=rs.getString("locn_code")==null ?"" : rs.getString("locn_code"); 				
					 room_num=rs.getString("room_num")==null ?"" : rs.getString("room_num"); 
					 service_code=rs.getString("service_code")==null ? "" : rs.getString("service_code"); 
					 subservice_code=rs.getString("subservice_code")==null ? "" : rs.getString("subservice_code"); 
					 visit_type_code=rs.getString("visit_type_code")==null ? "" : rs.getString("visit_type_code"); 
					 practitioner_id=rs.getString("PRACTITIONER_ID")==null ? "" : 
					rs.getString("PRACTITIONER_ID"); 
					
					 other_res_class=rs.getString("OTHER_RES_CLASS")==null ? "" : rs.getString("OTHER_RES_CLASS"); 
					 other_resource_id=rs.getString("OTHER_RESOURCE_ID")==null ? "" : rs.getString("OTHER_RESOURCE_ID"); 
					 order_catlog_code=rs.getString("ORDER_CATALOG_CODE")==null ? "" : rs.getString("ORDER_CATALOG_CODE"); 
					
					 contact_reason_code=rs.getString("CONTACT_REASON_CODE")==null ? "" : rs.getString("CONTACT_REASON_CODE"); */
									
					//String  noof_visits=rs.getString("NO_OF_FOLLOW_UP_VISITS_ALLOWED");
                    //String  dura_for_follow=rs.getString("DUR_FOR_FOLLOW_UP_VSTS_IN_DAYS");
					out.println("<tr><td class='" + classValue + "'>");
					out.println("<a href='../../eOP/jsp/addModifyVisitDetailsTemplate.jsp?temp_code="+temp_code +"&finval="+finval+"' target='f_query_add_mod'>");
					out.println(temp_code+"</a></td><td  class='" + classValue + "'>");
				
					if(!desc.equals(""))
					out.println( desc);
					else
                     out.println("&nbsp;");
					out.println("</td><td class='" + classValue + "'>");
					if(!locn_code.equals(""))
					out.println(locn_desc);
					else
                     out.println("&nbsp;");
					out.println("</td><td class='" + classValue + "'>");
					/* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
					if(!room_num.equals(""))
					 out.println(room_num+" "+room_desc);
					/*CRF end SS-CRF-0010 [IN034516]*/
					else
                     out.println("&nbsp;");
					out.println("</td><td class='" + classValue + "'>");
					if(!service_desc.equals(""))
					out.println(service_desc);
					else
                     out.println("&nbsp;");
					out.println("</td><td class='" + classValue + "'>"); 
					if(!subservice_desc.equals(""))
					out.println(subservice_desc);
					else
                     out.println("&nbsp;");
					out.println("</td><td class='" + classValue + "'>"); 
					if(!visit_type_desc.equals(""))
					out.println(visit_type_desc);
					else
                     out.println("&nbsp;");
					out.println("</td><td class='" + classValue + "'>");   
					if(!practitioner_id.equals(""))
					out.println(practitioner_id);
					 else
                     out.println("&nbsp;");
					 out.println("</td><td class='" + classValue + "'>"); 
                  if(other_res_class.equals("E")) {
					  %>
						<fmt:message key='Common.equipment.label'  bundle='${common_labels}'/>
				<%
				  } else if(other_res_class.equals("O")) { %>
					<fmt:message key='Common.others.label' bundle='${common_labels}'/>
				 <% } else {
					 out.println("&nbsp;");
					 }
					 out.println("</td><td class='" + classValue + "'>"); 
				 if(!other_resource_id.equals(""))
					 out.println(other_resource_id);
					 else
                     out.println("&nbsp;");
					 out.println("</td><td class='" + classValue + "'>"); 
					if(!order_catlog_code.equals(""))
					 out.println(order_catlog_desc);
					 else
                     out.println("&nbsp;");
                     out.println("</td><td class='" + classValue + "'>");
				 	if(!contact_reason_code.equals(""))
					out.println(contact_reason_desc);
					 else
                     out.println("&nbsp;");  
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

