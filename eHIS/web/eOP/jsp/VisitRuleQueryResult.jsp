<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.ConnectionManager,java.sql.*,java.util.*,java.net.*,java.text.*" contentType="text/html;charset=UTF-8"%>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	out.println("<HTML><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  OnMouseDown='CodeArrest();' class='CONTENT' onKeyDown = 'lockKey();'>");
     
    String whereClause = request.getParameter("whereclause");   
//	String locale=(String)session.getValue("LOCALE");
	if(whereClause==null) whereClause="";
	StringBuffer sql = new StringBuffer("");
    String from = request.getParameter( "from" );
    String to = request.getParameter( "to" ) ;
   	
//	String facilityid  = (String) session.getValue("facility_id");  
	String ruleID="";
	String ruleDesc="";	
	String no_of_followup_visit		= "";		
	String no_of_sec_visit			= "";		
//	String cummulative_allowed_yn	= "";		
	if((whereClause == null || whereClause.equals(""))){
	     ruleID=request.getParameter("code")==null ? "" : request.getParameter("code").trim();         
	     ruleDesc= request.getParameter("code_desc")==null?"" : request.getParameter("code_desc").trim();			
		int andCheck = 0;
		if(!ruleID.equals("")){			
			if(andCheck == 1){			
			sql.append(" upper(RULE_ID) like upper('"+ruleID+"%')");
	        }else{    					
				sql.append(" where upper(RULE_ID) like upper('"+ruleID+"%')");
	           andCheck = 1;
            }
		}
		if(!ruleDesc.equals("")){
			if(andCheck == 1){
				sql.append(" and ");
                sql.append(" upper(RULE_DESC) like upper('"+ruleDesc+"%')");
            }else{				
				sql.append(" where upper(RULE_DESC) like upper('"+ruleDesc+"%')");
                andCheck = 1;
            }
        }
    }

    //appending order by clause

	String ord[] = request.getParameterValues("orderbycolumns");

    if (!(ord == null || ord .equals(""))){
        sql.append(" order by ");
        for( int i=0;i < ord.length;i++){
		    if ( i == ord.length - 1 )
			    sql.append(ord[i]);
	        else
		        sql.append(ord[i]+",");
        }
    }//end of where clause IF
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
	PreparedStatement pstmt1=null;
	ResultSet rs=null;
	
	try
	{
		conn = ConnectionManager.getConnection(request);	
		

			String sql1="select rule_id,rule_desc,follow_up_visit,secondary_visit,no_of_followup_visit, no_of_sec_visit, cummulative_allowed_yn, eff_status from op_visit_rule "+sql;							
		
			pstmt1 = conn.prepareStatement(sql1);
			rs = pstmt1.executeQuery();

			if(start != 1)
			  for( int j=1; j<start; i++,j++ )
				rs.next();
			   while( i<=end && rs.next() ){
				if (cnt == 0){
					
               %>

			<P>
			<table align='right'>
			<tr>
			<td>
			   <%
				if ( !(start <= 1) )
					out.println("<A HREF='../../eOP/jsp/VisitRuleQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
				
					out.println("<A id='nextval' HREF='../../eOP/jsp/VisitRuleQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			      %>
			
			 </td>
			 </tr>
			 </table>
			 <br><br>
			 </P>

			 <table border="1" width="100%" cellspacing='0' cellpadding='0'>				
			  <th class='columnheader' width="6%"><fmt:message key="eOP.RuleID.label" bundle="${op_labels}"/></th>
			  <th class='columnheader' width="12%"><fmt:message key="eOP.RuleDesc.label" bundle="${op_labels}"/></th>
			  <th class='columnheader' width="11%"><fmt:message key="eOP.Followup.label" bundle="${op_labels}"/></th>
			  <th class='columnheader' width="11%"><fmt:message key="eOP.SecondaryVisit.label" bundle="${op_labels}"/></th>
			  <th class='columnheader' width="15%"><fmt:message key="eOP.NoofFollowupAllowed.label" bundle="${op_labels}"/></th>
			  <th class='columnheader' width="15%"><fmt:message key="eOP.NoofSecondaryAllowed.label" bundle="${op_labels}"/></th>
			  <th class='columnheader' width="20%"><fmt:message key="eOP.CummulativevisitsAllowed.label" bundle="${op_labels}"/></th>
			  <th class='columnheader' width="10%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
			  
			  
			  <%
				
			  }
			    	String classValue="";
					if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				    else
				   classValue = "QRYODD" ;
					String rule_id="";
					String rule_desc="";
					String secondary_visit;
					String follow_up;
	
					rule_id					= rs.getString("rule_id")==null?"":rs.getString("rule_id");    
					rule_desc					= rs.getString("rule_desc")==null?"":rs.getString("rule_desc");    				   
					follow_up					= rs.getString("follow_up_visit")==null?"":rs.getString("follow_up_visit");    					
					secondary_visit			= rs.getString("secondary_visit")==null?"":rs.getString("secondary_visit");
					no_of_followup_visit		= rs.getString("no_of_followup_visit")==null?"":rs.getString("no_of_followup_visit");
					no_of_sec_visit			= rs.getString("no_of_sec_visit")==null?"":rs.getString("no_of_sec_visit");
					 
					out.println("<tr><td class='" + classValue + "'>");
					out.println("<a href='../../eOP/jsp/addModifyVisitRule.jsp?rule_id="+rule_id+"' target='f_query_add_mod'>");
					out.println(rule_id+"</a></td><td  class='" + classValue + "'>");					
					out.println(rule_desc);					
					out.println("</td><td class='" + classValue + "'>");					
					out.println(follow_up);					
					out.println("</td><td class='" + classValue + "'>");					
					out.println(secondary_visit);	
					out.println("</td><td class='" + classValue + "'>");					
					out.println(no_of_followup_visit);	
					out.println("</td><td class='" + classValue + "'>");					
					out.println(no_of_sec_visit);	
					out.println("</td><td class='" + classValue + "'>");
					if (rs.getString("cummulative_allowed_yn").equals("Y") )
						out.println("<img src='../../eCommon/images/enabled.gif'></img>");   
					else
						out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
					out.println("</td><td class='" + classValue + "'>");
					if (rs.getString("eff_status").equals("E") )
						out.println("<img src='../../eCommon/images/enabled.gif'></img>");   
					else
						out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
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
	if(pstmt1!=null) pstmt1.close();

	}catch(Exception e){
		out.print(e);
		e.printStackTrace();
	 }
	finally	{	
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

