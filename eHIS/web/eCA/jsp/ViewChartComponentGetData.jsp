<!DOCTYPE html>
<%
/*
-----------------------------------------------------------------------
Date		Edit History	Name			Description
-----------------------------------------------------------------------
15/03/2012					Ramesh G           created
				  
-----------------------------------------------------------------------
*/
%>

<%@ page import ="java.sql.*,java.net.*,java.text.*,java.util.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<% request.setCharacterEncoding("UTF-8"); 

	try 
	{
		String SeqNo 		=  request.getParameter("SeqNo")==null ? "" : request.getParameter("SeqNo");
		String DisMeaCode 	= request.getParameter( "DisMeaCode" )==null ? "" : request.getParameter( "DisMeaCode" ) ;
		String ViewChart		= request.getParameter("ViewChart")==null ? "" : request.getParameter("ViewChart");

		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;
			
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rset = null;
		String result=" | | | | ";
				try{
					con = ConnectionManager.getConnection();
					String viewChartSearch=  request.getParameter("viewChartSearch")==null ? "" : request.getParameter("viewChartSearch");
					psmt = con.prepareStatement("SELECT X_AXIS_SCALE,Y_AXIS_SCALE,MIN_Y_AXIS,MAX_Y_AXIS,DISP_ORD_SEQ_NUM FROM CA_VIEW_CHART_CONFIG WHERE CHART_ID=? AND SEQUENCE_NUM=? AND DISCR_MSR_ID=?");					
					psmt.setString(1,ViewChart);	
					psmt.setString(2,SeqNo);
					psmt.setString(3,DisMeaCode);
					rset = psmt.executeQuery();
					if(rset.next())
					{
						String xScal = rset.getString("X_AXIS_SCALE")==null ? "" : rset.getString("X_AXIS_SCALE");
						String yScal = rset.getString("Y_AXIS_SCALE")==null ? "" : rset.getString("Y_AXIS_SCALE");
						String minY  = rset.getString("MIN_Y_AXIS")==null ? "" : rset.getString("MIN_Y_AXIS");
						String maxY  = rset.getString("MAX_Y_AXIS")==null ? "" : rset.getString("MAX_Y_AXIS");
						String disOr  = rset.getString("DISP_ORD_SEQ_NUM")==null ? "" : rset.getString("DISP_ORD_SEQ_NUM");
						result=xScal+" |"+yScal+" |"+minY+" | "+maxY+" | "+disOr;
					}
				}catch(Exception e){					
					System.out.println(e);
					result="Error";
				}finally{
					if(psmt!=null)psmt.close();
					if(rset!=null) rset.close();
					if(con!=null) ConnectionManager.returnConnection(con,request);					
				}
		out.println(result);									

	}
	catch (Exception e) 
	{
		//out.println("alert(\"" + e + "\");") ;//COMMON-ICN-0181
		e.printStackTrace();
	}
%>
