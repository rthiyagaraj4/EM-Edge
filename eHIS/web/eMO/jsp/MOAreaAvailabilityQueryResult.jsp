<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,java.net.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
        <%
		request.setCharacterEncoding("UTF-8");
		String atype= checkForNull(request.getParameter("atype"));
		if(atype.equals("")) atype ="%";
		String area	= checkForNull(request.getParameter("area"));
		if(area.equals("")) area ="%";
		String atype1   = "";
		String prevcode = "";
        %>
<html>
    <head>
        <title><fmt:message key="eMO.ViewMovementHistory.label" bundle="${mo_labels}"/></title>
		<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <script language='javascript' src='../../eCommon/js/common.js' ></script>		
		<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src="../../eMO/js/MOAreaAvailabilityQueryCriteria.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

        <%
			Connection	con		= null;
            Statement	st		= null;
            ResultSet	rs		= null;
		%>   
	  
    </head>                         
    <body  onMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
    <form name = "MOAreaAvailabilityQueryResult_form" id="MOAreaAvailabilityQueryResult_form" target="messageFrame">
	    <%
			String locale=(String)session.getAttribute("LOCALE"); 
			String	   facilityId 			= (String) session.getValue( "facility_id" ) ;
			String classValue	   = "";
			int rowIndex		   = 1;
			String AREA_TYPE_DESC  = "";
			String AREA_CODE       = "";
			String AREA_DESC       = "";
			int CAPACITY           = 0;
			int ALLOCATED          = 0;
			int VACANT             = 0;
			int blocked=0;
			int ccount             = 0;
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
            try{
                con	= ConnectionManager.getConnection(request);
                st	= con.createStatement();
                StringBuffer getcount =new StringBuffer();
				getcount.setLength(0);
				getcount.append("select count(*) from(select AREA_TYPE,AREA_TYPE_DESC,AREA_CODE, AREA_DESC,SUM(1) CAPACITY,SUM(CASE WHEN OCCUPYING_PATIENT_ID is not null or REGISTRATION_NO is not null THEN 1 ELSE 0 END) ALLOCATED,SUM(CASE WHEN BLOCKED_YN='Y' AND BLOCKED_UPTO > SYSDATE THEN 1 ELSE 0 END) BLOCKED, SUM(CASE WHEN OCCUPYING_PATIENT_ID is null and REGISTRATION_NO is null and (BLOCKED_YN='N' OR (BLOCKED_YN='Y' AND BLOCKED_UPTO <= SYSDATE)) THEN 1 ELSE 0 END) VACANT from mo_bed_for_area_vw	");
				getcount.append(" where  facility_id = '"+facilityId+"' and  upper(AREA_TYPE) like upper('"+atype+"') ");
				getcount.append(" and upper(AREA_CODE) like upper('"+area+"') ");
				getcount.append(" group by AREA_TYPE,AREA_TYPE_DESC,AREA_CODE, AREA_DESC) ");
				//getcount.append("select count(*) from  mo_area_vw where upper(AREA_TYPE) like upper('"+atype+"') and upper(AREA_CODE) like upper('"+area+"')");
				rs = st.executeQuery(getcount.toString());
				while(rs!=null && rs.next())
				{
					ccount = rs.getInt(1);
					
				}
				getcount.setLength(0);
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				if(ccount > 0)
				{
         %> 
			 
		 
		          <p>
		<table align='right'>
		<tr>
		<td>
		<%
		if ( !(start <= 1) )
		out.println("<A HREF='../jsp/MOAreaAvailabilityQueryResult.jsp?from="+(start-10)+"&to="+(end-10)+"&atype="+URLEncoder.encode(atype)+"&area="+URLEncoder.encode(area)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

		if ( !( (start+10) > ccount ) )
		out.println("<A HREF='../jsp/MOAreaAvailabilityQueryResult.jsp?from="+(start+10)+"&to="+(end+10)+"&atype="+URLEncoder.encode(atype)+"&area="+URLEncoder.encode(area)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

		%>
		</td>
		</tr>
		</table>
         </p>
<BR><BR>	
		 
		        <table cellspacing=0 cellpadding=0 align='center' width='101%' border='1' cellpadding=0 cellspacing=0>
				<th class='columnheader'><fmt:message key="Common.AreaCode.label" bundle="${common_labels}"/></th> 
				<th class='columnheader'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				<th class='columnheader'><fmt:message key="eMO.Capacity.label" bundle="${mo_labels}"/></th>
				<th class='columnheader'><fmt:message key="Common.Allocated.label" bundle="${common_labels}"/></th>
				<th class='columnheader'><fmt:message key="Common.Vacant.label" bundle="${common_labels}"/></th>
			    <th class='columnheader'><fmt:message key="Common.blocked.label" bundle="${common_labels}"/></th>
        <%
				StringBuffer operSql = new StringBuffer();
			    operSql.setLength(0);
				st	= con.createStatement();
				operSql.append("select AREA_TYPE,AREA_TYPE_DESC,AREA_CODE,MO_GET_DESC.mo_area('"+facilityId+"',area_code,'"+locale+"','1') AREA_DESC,SUM(1) CAPACITY,SUM(CASE WHEN OCCUPYING_PATIENT_ID is not null or REGISTRATION_NO is not null THEN 1 ELSE 0 END) ALLOCATED,SUM(CASE WHEN BLOCKED_YN='Y' AND BLOCKED_UPTO > SYSDATE THEN 1 ELSE 0 END) BLOCKED, SUM(CASE WHEN OCCUPYING_PATIENT_ID is null and REGISTRATION_NO is null and (BLOCKED_YN='N' OR (BLOCKED_YN='Y' AND BLOCKED_UPTO <= SYSDATE)) THEN 1 ELSE 0 END) VACANT from mo_bed_for_area_vw	");
				operSql.append(" where facility_id = '"+facilityId+"' and  upper(AREA_TYPE) like upper('"+atype+"') ");
				operSql.append(" and upper(AREA_CODE) like upper('"+area+"') ");
				operSql.append(" group by AREA_TYPE,AREA_TYPE_DESC,AREA_CODE, AREA_DESC ");
				operSql.append(" order by AREA_CODE,AREA_DESC,AREA_TYPE,AREA_TYPE_DESC ");	
				
				rs = st.executeQuery(operSql.toString());
				
				operSql.setLength(0);
				
			 if ( start != 1 )
	         for( int j=1; j<start; l++,j++ ){
	         rs.next() ;
            }
				while(rs.next()&&l<=end)
				{
				classValue	=	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
				rowIndex++;
				atype1  = rs.getString("AREA_TYPE");
				if(atype1==null) atype1 ="";
				AREA_TYPE_DESC = rs.getString("AREA_TYPE_DESC");
				if(AREA_TYPE_DESC==null) AREA_TYPE_DESC ="";
				
				AREA_CODE = rs.getString("AREA_CODE");
				if(AREA_CODE==null) AREA_CODE ="";
				AREA_DESC = rs.getString("AREA_DESC");
				if(AREA_DESC==null) AREA_DESC ="";
				CAPACITY = rs.getInt("CAPACITY");
				ALLOCATED = rs.getInt("ALLOCATED");
				VACANT = rs.getInt("VACANT");
				blocked = rs.getInt("BLOCKED");


						if(atype1.equals("S"))
						{
						AREA_TYPE_DESC=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.StorageArea.label","mo_labels");
						}else if(atype1.equals("R"))
						{
						AREA_TYPE_DESC=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ReleaseArea.label","mo_labels");
						}else if(atype1.equals("P"))
						{
						AREA_TYPE_DESC=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.PostmortemArea.label","mo_labels");
						}else if(atype1.equals("O"))
						{
						AREA_TYPE_DESC=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
						}


				if(prevcode.equals(AREA_TYPE_DESC)) prevcode = "";
				else prevcode = AREA_TYPE_DESC;



				if(!(prevcode.equals("")))
		        { 
		%>
		        <tr><th class='columnheader' colspan=11 align="left"><B><%=prevcode%></B></th></tr>
	    <%       }prevcode =AREA_TYPE_DESC; 
		%>
	
				<tr>
				<td class='<%=classValue%>'>
			<%	if(ALLOCATED>0){%>
			
				<a name='desc1' href='javascript:showAllowedOperations("<%=java.net.URLEncoder.encode(AREA_CODE)%>","<%=java.net.URLEncoder.encode(AREA_DESC)%>")' > <font size=1><%=AREA_CODE%></a>
			<%}else{%>
				<font size=1 ><%=AREA_CODE%>
				<%}%>
				</td>
				<td class='<%=classValue%>'> <font size=1><%=AREA_DESC%></td>
				<td class='<%=classValue%>' > <font size=1><%=CAPACITY%></td>
				<td class='<%=classValue%>' > <font size=1><%=ALLOCATED%></td>
				<td class='<%=classValue%>' > <font size=1><%=VACANT%></td>
				<td class='<%=classValue%>' > <font size=1><%=blocked%></td>
				</tr>

	    <%
			
	            l++;
				}
				if ( rs != null ) rs.close() ;
				if ( st != null ) st.close() ;
	
	    %>
	           </table>
               <br>
	   <%      }    
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
	</form>
    </body>

</html>
<%!
public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}
	
%>

