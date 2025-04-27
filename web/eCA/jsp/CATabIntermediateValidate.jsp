<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      		Name        		Rev.Date				Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
25/01/2019		IN057997			Kamalakannan G	  		25/01/2019				Ramesh G.		AAKH-CRF-0079
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	request.setCharacterEncoding("UTF-8");
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	String sql="";
	int resultCount = 0;
	String action = request.getParameter("ACTION") == null ? "": request.getParameter("ACTION");
	obj=new XMLStringParser();
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
	
	if("VALIDATE_PAT_ENC".equals(action)){
		String patient_id = (String)hash.get("patient_id");
		String encounter_id = (String)hash.get("encounter_id");
		
		try{
			con				=	ConnectionManager.getConnection(request);
			sql="select count(*) COUNT from PR_ENCOUNTER where patient_id = ? and encounter_id = ?";
			pstmt			=	con.prepareStatement(sql);
			pstmt.setString(1, patient_id);
			pstmt.setString(2, encounter_id);
			rs				=	pstmt.executeQuery();
			if(rs.next()){
				resultCount=Integer.parseInt(rs.getString("COUNT"));	
			}
			if(resultCount<=0){
				out.println("validationCheck('N','','')");
			}else{
				out.println("validationCheck('Y','"+patient_id+"','"+encounter_id+"')");
			}
		}
		catch(Exception e){
			//out.println("Exception@1: "+e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
					
	}else if("POPULATEENCOUNTERFOROP".equals(action)){
		String patient_id	= request.getParameter( "patient_id" ) ;
		ArrayList encounterDetails = new ArrayList();
		try{
			con = ConnectionManager.getConnection(request) ;
			pstmt		= con.prepareStatement("SELECT   encounter_id FROM pr_encounter WHERE patient_id = ? ORDER BY VISIT_ADM_DATE_TIME DESC");
			pstmt.setString(1, patient_id);
			
			rs			= pstmt.executeQuery();
			if(rs!=null){
				while(rs.next()){
					encounterDetails.add(rs.getString("ENCOUNTER_ID"));
				}
			}
			out.println("clearData('document.formClaimFormsCriteria.encounterId');") ;
			if(encounterDetails.size() <= 0){
				out.println("addEncounter('',' ---Select---','document.formClaimFormsCriteria.encounterId');");
			}
			else {	
				for(int i=0; i<encounterDetails.size(); i++) {			
					out.println("addEncounterDefault('"+ encounterDetails.get(i) + "', '" + encounterDetails.get(i) +"', 'document.formClaimFormsCriteria.encounterId','');") ;			
				}
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		} 
		
			finally
		{
			if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			if(con != null) ConnectionManager.returnConnection(con);
		}
		
	}
	else{
		String patient_id = (String)hash.get("patient_id");
		String encounter_id = (String)hash.get("encounter_id");
		String p_report_id = (String)hash.get("p_report_id");
			
			Clob clobData = null;
			try{
				con				=	ConnectionManager.getConnection(request);
				//sql="select DATA from logo_chk where SNO='"+id+"'";
				sql="select SIGNATURE from CA_PAT_INSU_SIGNATURE where patient_id = ? and encounter_id = ? and report_id = ? ";
				pstmt			=	con.prepareStatement(sql);
				pstmt.setString(1, patient_id);
				pstmt.setString(2, encounter_id);
				pstmt.setString(3, p_report_id);
				rs				=	pstmt.executeQuery();
				if(rs.next()) {
					clobData = rs.getClob("SIGNATURE");
					String wholeClob = clobData.getSubString(1, (int) clobData.length());
						System.out.println("SIGNATURE:"+wholeClob);
						out.println("testView('"+wholeClob+"')");
				}else{
					/* out.println("errorMsg()"); */
				}
			
			}
			
			catch(Exception e){
				//out.println("Exception@1: "+e);//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}
	
	}

%>
