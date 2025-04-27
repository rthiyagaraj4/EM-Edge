<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<script language='javascript' src='../../eOP/js/PatCheckout.js'></script>
   <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown='lockKey();'>
<%
	request.setCharacterEncoding("UTF-8");
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs		 	= null;
	String sql		=" ";
	String locale=(String)session.getAttribute("LOCALE");
	String practtype="";
	String typedesc = "";
	String practspeciality="";
	String  fac_id  	= (String) session.getValue( "facility_id" ) ;
	String  pracid	= request.getParameter("practitionerid");
	if(pracid == null) pracid="";

	String  desttype	= request.getParameter("dest_type");	
	if(desttype == null) desttype="";

	try
	{
		conn=ConnectionManager.getConnection(request);
		if(desttype.length() != 0)
		{			
			try
			{
				if(desttype.equals("XF"))
				{							
					sql = "Select LONG_DESC, referral_code from AM_REFERRAL_lang_vw where eff_status = 'E' and dest_use_at_concl_yn = 'Y' and  language_id='"+locale+"' and facility_id = '"+fac_id+"' order by short_desc";
					pstmt=conn.prepareStatement(sql);
					rs = pstmt.executeQuery();							
					if( rs != null )
					{
						while( rs.next() )
						{
								 String refid = rs.getString( "referral_code" ) ;
								 String refname = rs.getString( "LONG_DESC" ) ;
						%>
							<script>
								var element = parent.frames[1].document.createElement('OPTION');
								element.text = '<%=refname%>'
								element.value= '<%=refid%>'
								parent.frames[1].document.forms[0].destinationlocation.add(element);
							</script>
						<%
						}
					}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close(); 
			
					sql = "Select short_desc, service_code from AM_SERVICE_lang_vw where eff_status = 'E' and  language_id='"+locale+"' order by short_desc";
					pstmt=conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if( rs != null )
					{
							while( rs.next() )
							{
								String serid = rs.getString( "service_code" ) ;
								String serdesc = rs.getString( "short_desc" ) ;
								%>
								<script>
									var element = parent.frames[1].document.createElement('OPTION');
									element.text = '<%=serdesc%>'
									element.value= '<%=serid%>'
									parent.frames[1].document.forms[0].service.add(element);
								</script>
								<%
							}
					}

					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();

				}
				else if(desttype.equals("ZF"))
				{
							
					sql = "Select facility_name, facility_id from SM_FACILITY_PARAM_lang_vw where facility_id != '"+fac_id+"' and language_id='"+locale+"'order by facility_name";
					pstmt=conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
							
					if( rs != null )
					{
						while( rs.next() )
						{
							 String facid = rs.getString( "facility_id" ) ;
							 String facname = rs.getString( "facility_name" ) ;
							%>
							<script>
								var element = parent.frames[1].document.createElement('OPTION');
								element.text = '<%=facname%>'
								element.value= '<%=facid%>'
								parent.frames[1].document.forms[0].destinationlocation.add(element);
							</script>
							<%
						}
					}

					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
							
					sql = "Select short_desc, service_code from AM_SERVICE_lang_vw where language_id='"+locale+"' and eff_status = 'E' order by short_desc";
					pstmt=conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if( rs != null )
					{
						while( rs.next() )
						{
							 String serid = rs.getString( "service_code" ) ;
							 String serdesc = rs.getString( "short_desc" ) ;
							%>
							<script>
								var element = parent.frames[1].document.createElement('OPTION');
								element.text = '<%=serdesc%>'
								element.value= '<%=serid%>'
								parent.frames[1].document.forms[0].service.add(element);
							</script>
							<%
						}
					}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}
				else if(desttype.equals("OP"))
				{						
					sql = "Select long_desc, clinic_code from op_clinic_lang_vw where facility_id = '"+fac_id+"' and eff_status='E' and language_id='"+locale+"' Order By 1";
					pstmt=conn.prepareStatement(sql);
					rs = pstmt.executeQuery();						
					if( rs != null )
					{
						while( rs.next() )
						{
							 String facid = rs.getString( "clinic_code" ) ;
							 String facname = rs.getString( "long_desc" ) ;
							%>
							<script>
								var element = parent.frames[1].document.createElement('OPTION');
								element.text = '<%=facname%>'
								element.value= '<%=facid%>'
								parent.frames[1].document.forms[0].destinationlocation.add(element);
							</script>
							<%
						}
					}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					sql = "SELECT   Am_Get_desc.Am_service(Service_COde,'"+locale+"',2) service_short_desc, service_code FROM     AM_FACILITY_SERVICE WHERE    eff_status = 'E'   AND operating_facility_id = '"+fac_id+"'		ORDER BY 1";		
					
					pstmt=conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if( rs != null )
					{
						while( rs.next() )
						{
							 String serid = rs.getString( "service_code" ) ;
							 String serdesc = rs.getString( "service_short_desc" ) ;
							%>
							<script>
								var element = parent.frames[1].document.createElement('OPTION');
								element.text = "<%=serdesc%>"
								element.value= "<%=serid%>"
								parent.frames[1].document.forms[0].service.add(element);
							</script>
							<%
						}
					}

					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}
			}
			catch ( Exception e ){ }
		}
		else if(pracid.length() != 0)
		{
			try
			{	sql  ="SELECT   pract_type,am_get_desc.AM_PRACT_TYPE(pract_type,'"+locale+"',2) Pract_type_desc,  PRIMARY_SPECIALITY_CODE FROM   AM_PRACT_FOR_FACILITY a,am_practitioner b WHERE   facility_id = '"+fac_id+"' AND  a.practitioner_id ='"+pracid+"' AND a.practitioner_id=b.practitioner_id";
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
				if(rs != null && rs.next())
				{
					practtype=rs.getString("pract_type");
					typedesc = rs.getString( "Pract_type_desc" ) ;
					practspeciality=rs.getString("PRIMARY_SPECIALITY_CODE");
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				%>
				<script>	
					parent.frames[1].document.getElementById("pract_type").value="<%=practtype%>";
					parent.frames[1].document.getElementById("pract_speciality").value="<%=practspeciality%>";
					parent.frames[1].document.getElementById("disptypename").innerText="<%=typedesc%>";
				</script>
				<%					
			}
			catch ( Exception e ){ }
		}
		
	}catch(Exception ec){}
	finally
	{
		//Added by raj on 10/17/2003 while handling unclosed statements, resultsets and connections
		try{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}catch(Exception e){}
		if(conn!=null)
			ConnectionManager.returnConnection(conn,request);
	}
%>
</body>
</html>



