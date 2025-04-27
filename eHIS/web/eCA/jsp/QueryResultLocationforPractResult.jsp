<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		
		<%  
			request.setCharacterEncoding("UTF-8");
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			
		%>
		<!-- ****  Modified by Arvind @10-12-08 **** -->
		
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCA/js/LocationForPractitioner.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body class=content  OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onscroll="scrollTitle()">
	<%
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

try
{
		conn=ConnectionManager.getConnection(request);
		String facility_id=(String) session.getValue("facility_id");
		String mode  = request.getParameter("mode");
		if((mode.trim()).equals("practioner")){
			String practitioner_id  = request.getParameter("pract_id");
			String practitioner_name  = request.getParameter("practitioner_name");
			if(practitioner_name==null) practitioner_name="";
	%>	
		<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3' style="text-align:left;">
			<th class='columnheadercenter' width='30%'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
			<th class='columnheadercenter' width='30%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
			<th class='columnheadercenter' width='20%'><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></th>
			<th class='columnheadercenter' width='20%'><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/></th>
			<%
			try{
					//conn=ConnectionManager.getConnection(request);
					String strsql1=" Select locn_short_desc,to_char(Eff_from_Date,'dd/mm/yyyy') Eff_from_Date,to_char(eff_to_date,'dd/mm/yyyy') eff_to_date, locn_code, locn_type, practitioner_id,locn_type_desc,srl_no From  CA_LOCN_FOR_PRACT_VW Where practitioner_id = ? And facility_id = ? order by locn_type,locn_short_desc";

					pstmt = conn.prepareStatement(strsql1);
					pstmt.setString(1,practitioner_id);
					pstmt.setString(2,facility_id);
					//out.println("practitioner_id***"+practitioner_id);
					//out.println("facility_id***"+facility_id);
					rset = pstmt.executeQuery();
					String locn_short_desc = "";
					String locn_type_desc = "";
					String to_date	=	"";
					String from_date	=	"";
					int i=0;
					String classValue="";
					while(rset.next()){
							locn_short_desc = rset.getString("locn_short_desc");
							locn_type_desc = rset.getString("locn_type_desc");

							/*******added by ankur 26-02-2003********/
							from_date = rset.getString("Eff_from_Date")==null?" ":rset.getString("Eff_from_Date");
							to_date	= rset.getString("eff_to_date")==null?" ":rset.getString("eff_to_date");

							if(!from_date.equals(" ") )
								from_date = com.ehis.util.DateUtils.convertDate(from_date,"DMY","en",locale);
	
							if(!to_date.equals(" ") )
								to_date = com.ehis.util.DateUtils.convertDate(to_date,"DMY","en",locale);
							/****************************/
							if ( i % 2 == 0 )
								classValue = "gridData" ;
							else
								classValue = "gridData" ;
			%>
							<tr>
							    <td class='<%=classValue%>'><%=locn_type_desc%></td>
								<td class='<%=classValue%>'><%=locn_short_desc%></td>
								<td class='<%=classValue%>'><%=from_date%></td>
								<td class='<%=classValue%>'><%=to_date%></td>
							</tr>
							<%	
								i++;
					}
			}catch(Exception e){
	 			//out.println(e);//COMMON-ICN-0181
                               e.printStackTrace();//COMMON-ICN-0181
				}
			finally
			{
				if(pstmt!=null) pstmt.close();
				if(rset!=null) rset.close();
				//if(conn!=null)
					//ConnectionManager.returnConnection(conn,request);
			}
							%>
		</table>
		<%
		}//end of 	if((mode.trim()).equals("practioner"))
		if((mode.trim()).equals("location")){
			String locn_type  = request.getParameter("locn_type");
			//String locn_code  = request.getParameter("locn_code");
			String locaSerch  = request.getParameter("locaSerch");
		%>
			<div id='divTabHead' style='postion:relative'>
				<table border="1" width="100%" cellspacing='0' cellpadding='3' style="text-align:left;">
					<th class='columnheadercenter' width='30%'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></th>
					<th class='columnheadercenter' width='30%'><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></th>
				</table>
			</div>
			<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='0'>
			<%
				try{
						//conn=ConnectionManager.getConnection(request);

						String strsql1=" select a.practitioner_id practitioner_id ,b.practitioner_name practitioner_name from ca_pract_by_locn a,am_practitioner b where a.practitioner_id = b.practitioner_id and locn_type = nvl(?,locn_type) and locn_code =nvl(?,locn_code) and facility_id=? order by 2";



						pstmt = conn.prepareStatement(strsql1);
						pstmt.setString(1,locn_type);
						pstmt.setString(2,locaSerch);
						pstmt.setString(3,facility_id);
						rset = pstmt.executeQuery();
						String practitioner_id = "";
						String practitioner_name = "";
						int i=0;
						String classValue="";

						while(rset.next()){
							practitioner_id = rset.getString("practitioner_id");
							practitioner_name = rset.getString("practitioner_name");
							if ( i % 2 == 0 )
								classValue = "gridData" ;
							else
								classValue = "gridData" ;
			%>
							<tr>
								<td class='<%=classValue%>' width='30%'><%=practitioner_id%></td>
								<td class='<%=classValue%>' width='30%'><%=practitioner_name%></td>
							</tr>
							<%	
							i++;
						}
					if(rset!=null) rset.close();
					if(pstmt!=null) pstmt.close();
				}
				catch(Exception e){out.println(e);}		
				finally
				{
					//if(conn!=null) ConnectionManager.returnConnection(conn,request);
				}
							%>
			</table>
			<%
				}//end of 	if((mode.trim()).equals("location"))
}
catch(Exception e)
{
	//out.println("Exception @ QueryResultLocationforPractResult.jsp"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}
			%>	
	</body>
</html>

