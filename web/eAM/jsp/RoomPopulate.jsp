<!DOCTYPE html>
<%--
	FileName	: RoomPopulate.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
request.setCharacterEncoding("UTF-8");	
	String bldngcode = request.getParameter("bldng_code")==null ? "" : request.getParameter("bldng_code");
	

	Connection con= null; //(Connection) session.getValue("connection");
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String operating_facilityID = request.getParameter("operating_facilityID");
		if(operating_facilityID == null) operating_facilityID="";
	
	String fieldName = request.getParameter("fieldName");
		if(fieldName == null) fieldName="";
	String bldng_code="",short_desc="";
	
	out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
	
		
	try{
			con = ConnectionManager.getConnection(request);
			if(fieldName.equals(""))
			{
				String popSql="Select floor_code,short_desc from am_bldng_floor where operating_facility_id =? and bldng_code = ? and eff_status='E' order by short_desc";
				pstmt 	= con.prepareStatement(popSql) ;
				pstmt.setString	(	1,	operating_facilityID		);
				pstmt.setString	(	2,	bldngcode		);
				rs = pstmt.executeQuery() ;
				String str1 = "";
				String str2 = "";

				if( rs != null ) 
				{	
			%>
				<script>
							var n=parent.f_query_add_mod.document.getElementById('floor_code').options.length;
                                                     
							for(var i=0;i<n;i++)
							{
								parent.f_query_add_mod.document.getElementById('floor_code').remove("floor_code");				
							}			
							var tp =" ---"+getLabel("Common.defaultSelect.label","Common")+"--- ";
							var opt=parent.f_query_add_mod.document.createElement("OPTION");
							opt.text=tp;
							opt.value="";
							parent.f_query_add_mod.document.getElementById('floor_code').add(opt);					
				</script>	   
					


			<%
				while( rs.next() ) 
						{
							str1 = rs.getString( "floor_code" ) ;
							str2 = rs.getString( "short_desc" );
							out.println(	"<script> var element = parent.f_query_add_mod.document.createElement('OPTION');"+
								"element.text = '"+str2+"';"+ 
								"element.value= '"+str1+"';"+
								"parent.f_query_add_mod.document.room_form.floor_code.add(element);</script>");
						}
					}
					if(rs!=null) 	rs.close();
	                if(pstmt!=null) 	pstmt.close();
			}
			else
			{
				String strStmt = "select bldng_code,short_desc from am_bldng where eff_status='E'and operating_facility_id =? order by short_desc";
				pstmt 	= con.prepareStatement( strStmt ) ;
				pstmt.setString	(	1,	operating_facilityID		);
				rs = pstmt.executeQuery() ;
				if( rs != null ) 
				{	
			%>
				<script>
							var n=parent.f_query_add_mod.document.getElementById('bldng_code').options.length;
							
							for(var i=0;i<n;i++)
							{
								parent.f_query_add_mod.document.getElementById('bldng_code').remove("floor_code");				
							}			
							var tp =" ---"+getLabel("Common.defaultSelect.label","Common")+"--- ";
							var opt=parent.f_query_add_mod.document.createElement("OPTION");
							opt.text=tp;
							opt.value="";
							parent.f_query_add_mod.document.getElementById('bldng_code').add(opt);					
				</script>	        


			<%
				while( rs.next() ) 
						{
							bldng_code = rs.getString( "bldng_code" ) ;
							short_desc = rs.getString( "short_desc" );
							out.println(	"<script> var element = parent.f_query_add_mod.document.createElement('OPTION');"+
								"element.text = '"+short_desc+"';"+ 
								"element.value= '"+bldng_code+"';"+
								"parent.f_query_add_mod.document.room_form.bldng_code.add(element);</script>");
						}
					}			
			
			}
			if(rs!=null) 	rs.close();
	        if(pstmt!=null) 	pstmt.close();
				out.println("</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>");		
	}
		catch(Exception e) { 
		//out.println(e.toString());
			e.printStackTrace();
		}

		finally 
			{
				try
				{
				  if (pstmt != null)	pstmt.close();
				  if (rs != null)		rs.close();
				}
				catch(Exception e)
				{}
		  ConnectionManager.returnConnection(con,request);
		}

%>	

