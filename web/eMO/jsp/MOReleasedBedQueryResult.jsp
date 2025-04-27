<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,java.net.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
        <%
		request.setCharacterEncoding("UTF-8");
		String area_code= checkForNull(request.getParameter("area_code"));
		if(area_code.equals("")) area_code ="%";
		String bed_no	= checkForNull(request.getParameter("bed_no"));
		if(bed_no.equals("")) bed_no ="%";
		String blocked_until	= checkForNull(request.getParameter("blocked_until"));
		if(blocked_until.equals("")) blocked_until ="";
		String reason_for_blocking="";
		String blocked_until_greg="";
        %>
<html>
    <head>
        <title><fmt:message key="eMO.ReleaseLocation.label" bundle="${mo_labels}"/></title>
		<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <script language='javascript' src='../../eCommon/js/common.js' ></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		
		<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src="../../eMO/js/MOReleaseBedQueryCriteria.js"></script>
        <%
			Connection	con		= null;
            Statement	st		= null;
            ResultSet	rs		= null;
		
		String locale=(String)session.getAttribute("LOCALE"); 
		String	   facilityId 			= (String) session.getValue( "facility_id" ) ;
		String from = request.getParameter( "from" ) ;
	    String to = request.getParameter( "to" ) ;
		int start = 0 ;
	    int end = 0 ;
	    int l=1;
    	if ( from == null )
		start = 1 ;
	    else
		start = Integer.parseInt( from ) ;
    	if ( to == null )
	  	end = 10 ;
	    else
		end = Integer.parseInt( to ) ;
		%>   
	  
    </head>                         
    <body  onMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
    <form name = 'MORelaseBed'  action='../../servlet/eMO.BlockBedServlet'  method='post' target=messageFrame>
	    <%
			String classValue	   = "";
			int rowIndex		   = 1;		
			String AREA_DESC       = "";
			
			int i=1;
			int maxrecord=0;
            try{
                con	= ConnectionManager.getConnection(request);	              

				blocked_until_greg=DateUtils.convertDate(blocked_until,"DMY",locale,"en");

				StringBuffer operSql = new StringBuffer();
			    operSql.setLength(0);
				st	= con.createStatement();
				operSql.append("select Area_code,MO_GET_DESC.mo_area('"+facilityId+"',area_code,'"+locale+"','1')  AREA_DESC, BED_NO, BLOCKED_YN, to_char(BLOCKED_UPTO,'dd/mm/yyyy hh24:mi') BLOCKED_UPTO, REASON_FOR_BLOCKING from mo_bed_for_area_vw where facility_id = '"+facilityId+"' and BLOCKED_YN='Y' and BLOCKED_UPTO>sysdate ");
				if(!area_code.equals(""))
				{
				operSql.append("and upper(AREA_CODE) like upper('"+area_code+"')");
				}
                if(!bed_no.equals(""))
				{operSql.append("and upper(BED_NO) like upper('"+bed_no+"')");
				}
				if(!blocked_until.equals(""))
				{
				operSql.append(" and trunc(BLOCKED_UPTO)<=to_date('"+blocked_until_greg+"','dd/mm/yyyy')");
				}
				
				operSql.append(" order by area_code, area_desc ");						
				rs = st.executeQuery(operSql.toString());

				operSql.setLength(0);
				 if ( start != 1 )
	         for( int j=1; j<start; i++,j++ ){
	         rs.next() ;
            }
				while(i<=end && rs.next())
				{
				
				if(maxrecord==0)
				{
		 %> 
			
		<p>
		<table align='right'>
		<tr>
	
		<%
		if ( !(start <= 1) )
		out.println("<td align ='right' id='prev'><A HREF='../jsp/MOReleasedBedQueryResult.jsp?from="+(start-10)+"&to="+(end-10)+"&area_code="+URLEncoder.encode(area_code)+"&bed_no="+URLEncoder.encode(bed_no)+"&blocked_until="+URLEncoder.encode(blocked_until)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

		//if ( !( (start+10) > ccount ) )
		out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../jsp/MOReleasedBedQueryResult.jsp?from="+(start+10)+"&to="+(end+10)+"&area_code="+URLEncoder.encode(area_code)+"&bed_no="+URLEncoder.encode(bed_no)+"&blocked_until="+URLEncoder.encode(blocked_until)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

		%>
	
		</tr>
		</table>
         </p>
<BR><BR>	
		 
		 
		    <table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0 style="text-align:left;">
				<th class='columnheader'><fmt:message key="Common.area.label" bundle="${common_labels}"/></th> 
				<th class='columnheader'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
				<th class='columnheader'><fmt:message key="Common.blockeduntil.label" bundle="${common_labels}"/></th>
				<th class='columnheader'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
				<th class='columnheader'><fmt:message key="Common.Release.label" bundle="${common_labels}"/></th>
        <% } 		
				classValue	=	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
				rowIndex++;
				area_code = rs.getString("Area_code");
				if(area_code==null) area_code ="";
				AREA_DESC = rs.getString("AREA_DESC");
				if(AREA_DESC==null) AREA_DESC ="";
				bed_no = rs.getString("bed_no");
				if(bed_no==null) bed_no ="";
				blocked_until = rs.getString("BLOCKED_UPTO");
				if(blocked_until==null) blocked_until ="";
				reason_for_blocking = rs.getString("reason_for_blocking");
				if(reason_for_blocking==null) reason_for_blocking ="";

				String blocked_until_disply=DateUtils.convertDate(blocked_until,"DMYHM","en",locale);
				
				
				%>
				<tr>
				<td class='<%=classValue%>'> <font size=1><%=AREA_DESC%></td>
				<td class='<%=classValue%>' align='left'> <font size=1><%=bed_no%></td>
				<td class='<%=classValue%>' align='left'> <font size=1><%=blocked_until_disply%></td>
				<td class='<%=classValue%>' align='left'> <font size=1><%=reason_for_blocking%></td>
                <td class='<%=classValue%>' align='center'> <font size=1><INPUT TYPE="checkbox" name="rel<%=i%>" id="rel<%=i%>" value='<%=area_code%>|<%=bed_no%>'></td> 

				</tr>

	    <%l++;i++; maxrecord++;
			
	            }


				 if(maxrecord == 0)
		{ %>
					 <script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>
		<% }

		if ( maxrecord < 10 || (!rs.next()) ) {
		%>
			<script >
			if (document.getElementById('next'))
				document.getElementById('next').style.visibility='hidden';
			</script>
		<% 
				} else {%>
			<script >
			if (document.getElementById('next'))
				document.getElementById('next').style.visibility='visible';
			</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		<%}
				
				
				if ( rs != null ) rs.close() ;
				if ( st != null ) st.close() ;
	
	    %>
	           </table>
               <br>
	   <% //     }else{%>
		
		<!--   <script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"))</script> -->
		
		<%//}
		       }
            catch(Exception e) {out.println(e.toString());
			e.printStackTrace();}
            finally
            {
      		ConnectionManager.returnConnection(con,request);
		    }
		
	   %>   
	
    <script>
	parent.frames[1].document.forms[0].search.disabled=false
	</script>
	<input type =hidden name='count' id='count' value='<%=i%>'>
	<input type =hidden name='releasedata1' id='releasedata1' value=''>
	
	</form>
    </body>

</html>
<%!
public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}
	
%>

