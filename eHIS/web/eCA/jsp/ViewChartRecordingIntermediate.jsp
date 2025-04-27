<!DOCTYPE html>
<%
/*
-----------------------------------------------------------------------
Date		Edit History	Name			Description
-----------------------------------------------------------------------
15/03/2012					Ramesh G           created
---------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name		Description
---------------------------------------------------------------------------------------------
23/11/2017	IN061897		Raja S			23/11/2017		Ramesh G		ML-MMOH-CRF-0549				  
---------------------------------------------------------------------------------------------
*/
%>

<%@ page import ="java.sql.*,java.net.*,java.text.*,java.util.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<% 
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	try 
	{
		String modeId 		=  request.getParameter("Mode")==null ? "" : request.getParameter("Mode");		
		String practitionerId 		=  request.getParameter("PractiotionerID")==null ? "" : request.getParameter("PractiotionerID");
		String facility_id 		=  request.getParameter("facility_id")==null ? "" : request.getParameter("facility_id");//IN061897
		String clientIpAddress 		=  request.getParameter("clientIpAddress")==null ? "" : request.getParameter("clientIpAddress");//IN061897
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rset = null;
		Statement stm = null;
		String result="";
		String def_chartId="";
		if("GetChartId".equals(modeId)){
			try{
				con = ConnectionManager.getConnection();
				//psmt = con.prepareStatement("SELECT CHART_ID FROM CA_VIEWCHART_DEF_CONFIG WHERE PRACTITIONER_ID = '"+practitionerId+"'");	//common-icn-0180
				psmt = con.prepareStatement("SELECT CHART_ID FROM CA_VIEWCHART_DEF_CONFIG WHERE PRACTITIONER_ID = ?");	//common-icn-0180
				psmt.setString(1, practitionerId);//common-icn-0180
				rset = psmt.executeQuery();
				if(rset.next()){						
					result=rset.getString("CHART_ID")==null ? "" : rset.getString("CHART_ID");
				}
			}catch(Exception e){					
				System.out.println(e);
				result="Error";
				try {
					con.rollback();
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
			}finally{
				if(psmt!=null)psmt.close();
				if(rset!=null) rset.close();
				if(con!=null) ConnectionManager.returnConnection(con,request);					
			}			
		}else if("SaveChartId".equals(modeId)){
			def_chartId 		=  request.getParameter("Chart_Id")==null ? "" : request.getParameter("Chart_Id");
			try{
				con = ConnectionManager.getConnection();
				//psmt = con.prepareStatement("SELECT CHART_ID FROM CA_VIEWCHART_DEF_CONFIG WHERE PRACTITIONER_ID = '"+practitionerId+"'");	//common-icn-0180
				psmt = con.prepareStatement("SELECT CHART_ID FROM CA_VIEWCHART_DEF_CONFIG WHERE PRACTITIONER_ID = ?");	//common-icn-0180
				psmt.setString(1, practitionerId);//common-icn-0180
				rset = psmt.executeQuery();
				if(rset.next()){
					//stm = con.createStatement();//common-icn-0180
					//stm.execute("UPDATE  CA_VIEWCHART_DEF_CONFIG SET CHART_ID='"+def_chartId+"' WHERE PRACTITIONER_ID='"+practitionerId+"'");//common-icn-0180
					psmt = con.prepareStatement("UPDATE  CA_VIEWCHART_DEF_CONFIG SET CHART_ID=? WHERE PRACTITIONER_ID=?");//common-icn-0180
					psmt.setString(1, def_chartId);//common-icn-0180
					psmt.setString(2, practitionerId);//common-icn-0180
					rset = psmt.executeQuery();//common-icn-0180
				}else{
					//stm = con.createStatement();//common-icn-0180
					//stm.execute("INSERT INTO CA_VIEWCHART_DEF_CONFIG (PRACTITIONER_ID,CHART_ID) VALUES ('"+practitionerId+"','"+def_chartId+"')");//common-icn-0180
					psmt = con.prepareStatement("INSERT INTO CA_VIEWCHART_DEF_CONFIG (PRACTITIONER_ID,CHART_ID) VALUES (?,?)");//common-icn-0180
					psmt.setString(1, practitionerId);//common-icn-0180
					psmt.setString(2, def_chartId);//common-icn-0180
					rset = psmt.executeQuery();//common-icn-0180
				}
				result = "Success";
				con.commit();
			}catch(Exception e){					
				System.out.println(e);
				result=e.getMessage();
				try {
					con.rollback();
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
			}finally{ 
				if(stm!=null)stm.close();
				if(psmt!=null)psmt.close();
				if(rset!=null) rset.close();
				if(con!=null) ConnectionManager.returnConnection(con,request);					
			}			

		}else if("UpdateChartId".equals(modeId)){
			def_chartId 		=  request.getParameter("Chart_Id")==null ? "" : request.getParameter("Chart_Id");
			try{
				con = ConnectionManager.getConnection();				
				//stm = con.createStatement();//common-icn-0180
				//stm.execute("DELETE FROM CA_VIEWCHART_DEF_CONFIG WHERE PRACTITIONER_ID='"+practitionerId+"'");	//common-icn-0180		
				psmt = con.prepareStatement("DELETE FROM CA_VIEWCHART_DEF_CONFIG WHERE PRACTITIONER_ID=?");	//common-icn-0180		
				//stm.execute("UPDATE  CA_VIEWCHART_DEF_CONFIG SET CHART_ID='"+def_chartId+"' WHERE PRACTITIONER_ID='"+practitionerId+"'");
				psmt.setString(1, practitionerId);//common-icn-0180
					
				rset = psmt.executeQuery();//common-icn-0180
				result = "Success";
				con.commit();
			}catch(Exception e){					
				System.out.println(e);
				result=e.getMessage();
				try {
					con.rollback();
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
			}finally{
				if(stm!=null)stm.close();
				if(con!=null) ConnectionManager.returnConnection(con,request);	
				if(psmt!=null)psmt.close();//common-icn-0180
				if(rset!=null) rset.close();//common-icn-0180
			}		
//IN061897 changes starts
		}else if("SetChartToDefault".equals(modeId)){
			def_chartId 		=  request.getParameter("Chart_Id")==null ? "" : request.getParameter("Chart_Id");
				eCA.CAViewChartBean bean = new eCA.CAViewChartBean();
				result = bean.setPracDefaultChart(def_chartId,practitionerId,facility_id,clientIpAddress);
		}
//IN061897 changes ends
		out.println(result);											

	}
	catch (Exception e) 
	{
		//out.println("alert(\"" + e + "\");") ;//COMMON-ICN-0181
		e.printStackTrace();
	}
%>
