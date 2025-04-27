<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.util.*,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp" %>
<html>
	<head>
		<%
			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eOH/js/OHParameterForFacility.js'></script> 		
        <script language='javascript' src='../../eOH/js/OHParameters.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

</head>
<!--  <body OnLoad='AssignQuadrantValue();' OnMouseDown='CodeArrest()' onKeyDown="lockKey()"> -->
 	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">  
	 <form name="OHParameterForFacilityFormForQuadrant" id="OHParameterForFacilityFormForQuadrant" >
	
		<%
			Connection con=null;
			PreparedStatement pstmt=null;
			PreparedStatement pstmt1=null;
			ResultSet rs=null;
			ResultSet rs1=null;
			String facility_id = (String)session.getValue("facility_id") ;
			String mode=request.getParameter("mode");
			String tooth_numbering_system=checkForNull(request.getParameter("tooth_numbering_system"));
			String record_gingival_status_yn = "";
			String record_gingival_status = checkForNull(request.getParameter("record_gingival_status_yn"));
			//String dflt_mixed_dentition_chart_hid = checkForNull(request.getParameter("dflt_mixed_dentition_chart"));
			String from_mixed_dentition = checkForNull(request.getParameter("from_mixed_dentition"));
			String callFrom = checkForNull(request.getParameter("callFrom"));
			String chart_level = checkForNull(request.getParameter("chart_level"));

            String gs_dflt_tooth_no_Q1_disabled = "";
            String gs_dflt_tooth_no_Q2_disabled = "";
            String gs_dflt_tooth_no_Q3_disabled = "";
            //String gs_dflt_tooth_no_Q4_disabled = "";
			 String dec_gs_dflt_tooth_no_Q1_disabled = "";
			 String dec_gs_dflt_tooth_no_Q2_disabled = "";
			 String dec_gs_dflt_tooth_no_Q3_disabled = "";
			 String md_gs_dflt_tooth_no_Q1_disabled = "";
			 String md_gs_dflt_tooth_no_Q2_disabled = "";
			 String md_gs_dflt_tooth_no_Q3_disabled = "";
			 String md_gs_dflt_tooth_no_Q4_disabled = "";

             //paramters for Permanet
			String gs_no_of_tooth_for_Q1_hidden = checkForNull(request.getParameter("gs_no_of_tooth_for_Q1_hidden"));
			String gs_no_of_tooth_for_Q2_hidden = checkForNull(request.getParameter("gs_no_of_tooth_for_Q2_hidden"));
			String gs_no_of_tooth_for_Q3_hidden = checkForNull(request.getParameter("gs_no_of_tooth_for_Q3_hidden"));
			String gs_no_of_tooth_for_Q4_hidden = checkForNull(request.getParameter("gs_no_of_tooth_for_Q4_hidden"));
			String gs_dflt_tooth_no_Q1_hidden = checkForNull(request.getParameter("gs_dflt_tooth_no_Q1_hidden"));
			String gs_dflt_tooth_no_Q2_hidden = checkForNull(request.getParameter("gs_dflt_tooth_no_Q2_hidden"));
			String gs_dflt_tooth_no_Q3_hidden = checkForNull(request.getParameter("gs_dflt_tooth_no_Q3_hidden"));
			String gs_dflt_tooth_no_Q4_hidden = checkForNull(request.getParameter("gs_dflt_tooth_no_Q4_hidden"));
            
			 //paramters for Deciduous
			String dec_gs_no_of_tooth_for_Q1_hidden = checkForNull(request.getParameter("dec_gs_no_of_tooth_for_Q1_hidden"));
			String dec_gs_no_of_tooth_for_Q2_hidden = checkForNull(request.getParameter("dec_gs_no_of_tooth_for_Q2_hidden"));
			String dec_gs_no_of_tooth_for_Q3_hidden = checkForNull(request.getParameter("dec_gs_no_of_tooth_for_Q3_hidden"));
			String dec_gs_no_of_tooth_for_Q4_hidden = checkForNull(request.getParameter("dec_gs_no_of_tooth_for_Q4_hidden"));
			String dec_gs_dflt_tooth_no_Q1_hidden = checkForNull(request.getParameter("dec_gs_dflt_tooth_no_Q1_hidden"));
			String dec_gs_dflt_tooth_no_Q2_hidden = checkForNull(request.getParameter("dec_gs_dflt_tooth_no_Q2_hidden"));
			String dec_gs_dflt_tooth_no_Q3_hidden = checkForNull(request.getParameter("dec_gs_dflt_tooth_no_Q3_hidden"));
			String dec_gs_dflt_tooth_no_Q4_hidden = checkForNull(request.getParameter("dec_gs_dflt_tooth_no_Q4_hidden"));
			 
			 //paramters for Mixed Dentition
			String md_gs_no_of_tooth_for_Q1_hidden = checkForNull(request.getParameter("md_gs_no_of_tooth_for_Q1_hidden"));
			String md_gs_no_of_tooth_for_Q2_hidden = checkForNull(request.getParameter("md_gs_no_of_tooth_for_Q2_hidden"));
			String md_gs_no_of_tooth_for_Q3_hidden = checkForNull(request.getParameter("md_gs_no_of_tooth_for_Q3_hidden"));
			String md_gs_no_of_tooth_for_Q4_hidden = checkForNull(request.getParameter("md_gs_no_of_tooth_for_Q4_hidden"));
		    String md_gs_dflt_tooth_no_Q1_hidden = checkForNull(request.getParameter("md_gs_dflt_tooth_no_Q1_hidden"));
		    String md_gs_dflt_tooth_no_Q2_hidden = checkForNull(request.getParameter("md_gs_dflt_tooth_no_Q2_hidden"));
		    String md_gs_dflt_tooth_no_Q3_hidden = checkForNull(request.getParameter("md_gs_dflt_tooth_no_Q3_hidden"));
		    String md_gs_dflt_tooth_no_Q4_hidden = checkForNull(request.getParameter("md_gs_dflt_tooth_no_Q4_hidden"));

             //paramters for Permanet
			String gs_no_of_tooth_for_Q1 = "";
			String gs_no_of_tooth_for_Q2= "";
			String gs_no_of_tooth_for_Q3 = "";
			String gs_no_of_tooth_for_Q4  ="";
			String gs_dflt_tooth_no_Q1 ="";
			String gs_dflt_tooth_no_Q2 ="";
			String gs_dflt_tooth_no_Q3 = "";
			String gs_dflt_tooth_no_Q4 = "";

			 //paramters for Deciduous
			String dec_gs_no_of_tooth_for_Q1 = "";
			String dec_gs_no_of_tooth_for_Q2 = "";
			String dec_gs_no_of_tooth_for_Q3 = "";
			String dec_gs_no_of_tooth_for_Q4 = "";
			String dec_gs_dflt_tooth_no_Q1 ="";
			String dec_gs_dflt_tooth_no_Q2 ="";
			String dec_gs_dflt_tooth_no_Q3 ="";
			String dec_gs_dflt_tooth_no_Q4 ="";

			 //paramters for Mixed Deciduous
			String md_gs_no_of_tooth_for_Q1 = "";
			String md_gs_no_of_tooth_for_Q2 = "";
			String md_gs_no_of_tooth_for_Q3 = "";
			String md_gs_no_of_tooth_for_Q4 = "";
			String md_gs_dflt_tooth_no_Q1 ="";
			String md_gs_dflt_tooth_no_Q2 ="";
			String md_gs_dflt_tooth_no_Q3 ="";
			String md_gs_dflt_tooth_no_Q4 ="";

			String dflt_mixed_dentition_chart = "";
			
		    String sql="";
			String checked_yn = "";
			String chk_value = "";
			String tooth_selected="";
			//String tooth_selected_dec="";
			//String interface_flag_checked="";
			//String interface_flag_value="";
			int total_records=0;
			HashMap map = new HashMap();
			HashMap map_dec = new HashMap();
			HashMap map_md = new HashMap();
			String map_val = "";
			String map_val_dec = "";
			String map_val_md = "";
			String j="";
			String n="";
			String q="";
 			try{
				con=ConnectionManager.getConnection(request);
                if(chart_level.equals("F") || chart_level.equals("") || chart_level.equals("null") || chart_level.equals(null)){
					sql="SELECT COUNT(*) AS TOTAL_RECORDS_EXISTING FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?";
					pstmt=con.prepareStatement(sql);
				    pstmt.setString(1,facility_id);
					//rs=pstmt.executeQuery();
				
				}else if (chart_level.equals("E")){
					sql="SELECT COUNT(*) AS TOTAL_RECORDS_EXISTING FROM OH_PARAM";
					pstmt=con.prepareStatement(sql);
				}
				rs=pstmt.executeQuery();
				rs.next();
				total_records=rs.getInt(1);
						
			if(total_records==1){
				   mode="modify";
			}
			else{
				   mode="insert";
			}
			if(mode.equals("modify")){
				
				sql="SELECT chart_level FROM OH_PARAM";
				pstmt=con.prepareStatement(sql);
				//pstmt.setString(1,facility_id);
				rs=pstmt.executeQuery();

				while(rs!=null && rs.next()){
						chart_level=checkForNull(rs.getString("chart_level"));

				}
                if(chart_level.equals("F")){
					sql="SELECT * FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,facility_id);
					rs=pstmt.executeQuery();
					while(rs!=null && rs.next()){
						tooth_numbering_system=checkForNull(rs.getString("tooth_numbering_system"));
						gs_no_of_tooth_for_Q1=checkForNull(rs.getString("gs_no_of_tooth_for_Q1"));
						gs_no_of_tooth_for_Q2=checkForNull(rs.getString("gs_no_of_tooth_for_Q2"));
						gs_no_of_tooth_for_Q3=checkForNull(rs.getString("gs_no_of_tooth_for_Q3"));
						gs_no_of_tooth_for_Q4=checkForNull(rs.getString("gs_no_of_tooth_for_Q4"));
						gs_dflt_tooth_no_Q1=checkForNull(rs.getString("gs_dflt_tooth_no_Q1"));
						gs_dflt_tooth_no_Q2=checkForNull(rs.getString("gs_dflt_tooth_no_Q2"));
						gs_dflt_tooth_no_Q3=checkForNull(rs.getString("gs_dflt_tooth_no_Q3"));
						gs_dflt_tooth_no_Q4=checkForNull(rs.getString("gs_dflt_tooth_no_Q4"));
						dec_gs_no_of_tooth_for_Q1=checkForNull(rs.getString("dec_gs_no_of_tooth_for_Q1"));
						dec_gs_no_of_tooth_for_Q2=checkForNull(rs.getString("dec_gs_no_of_tooth_for_Q2"));
						dec_gs_no_of_tooth_for_Q3=checkForNull(rs.getString("dec_gs_no_of_tooth_for_Q3"));
						dec_gs_no_of_tooth_for_Q4=checkForNull(rs.getString("dec_gs_no_of_tooth_for_Q4"));
						dec_gs_dflt_tooth_no_Q1=checkForNull(rs.getString("dec_gs_dflt_tooth_no_Q1"));
						dec_gs_dflt_tooth_no_Q2=checkForNull(rs.getString("dec_gs_dflt_tooth_no_Q2"));
						dec_gs_dflt_tooth_no_Q3=checkForNull(rs.getString("dec_gs_dflt_tooth_no_Q3"));
						dec_gs_dflt_tooth_no_Q4=checkForNull(rs.getString("dec_gs_dflt_tooth_no_Q4"));
						md_gs_no_of_tooth_for_Q1=checkForNull(rs.getString("md_gs_no_of_tooth_for_Q1"));
						md_gs_no_of_tooth_for_Q2=checkForNull(rs.getString("md_gs_no_of_tooth_for_Q2"));
						md_gs_no_of_tooth_for_Q3=checkForNull(rs.getString("md_gs_no_of_tooth_for_Q3"));
						md_gs_no_of_tooth_for_Q4=checkForNull(rs.getString("md_gs_no_of_tooth_for_Q4"));
						md_gs_dflt_tooth_no_Q1=checkForNull(rs.getString("md_gs_dflt_tooth_no_Q1"));
						md_gs_dflt_tooth_no_Q2=checkForNull(rs.getString("md_gs_dflt_tooth_no_Q2"));
						md_gs_dflt_tooth_no_Q3=checkForNull(rs.getString("md_gs_dflt_tooth_no_Q3"));
						md_gs_dflt_tooth_no_Q4=checkForNull(rs.getString("md_gs_dflt_tooth_no_Q4"));
						record_gingival_status_yn=checkForNull(rs.getString("record_gingival_status_yn"));
						dflt_mixed_dentition_chart=checkForNull(rs.getString("dflt_mixed_dentition_chart"));
					}
						if (!gs_dflt_tooth_no_Q1.equals("")){
							gs_dflt_tooth_no_Q1_disabled="disabled";
							
						}
						if(!gs_dflt_tooth_no_Q2.equals("")){
							gs_dflt_tooth_no_Q2_disabled="disabled";
						}	
						 if(!gs_dflt_tooth_no_Q3.equals("")){
							gs_dflt_tooth_no_Q3_disabled="disabled";
						}
						 if(!gs_dflt_tooth_no_Q3.equals("")){
							gs_dflt_tooth_no_Q3_disabled="disabled";
						}
			
						if (!dec_gs_dflt_tooth_no_Q1.equals("")){
							dec_gs_dflt_tooth_no_Q1_disabled="disabled";
						}
						if (!dec_gs_dflt_tooth_no_Q2.equals("")){
							dec_gs_dflt_tooth_no_Q2_disabled="disabled";
						}
						if (!dec_gs_dflt_tooth_no_Q3.equals("")){
							dec_gs_dflt_tooth_no_Q3_disabled="disabled";
						}
						if (!md_gs_dflt_tooth_no_Q1.equals("")){
							md_gs_dflt_tooth_no_Q1_disabled="disabled";
						}
						if (!md_gs_dflt_tooth_no_Q2.equals("")){
							md_gs_dflt_tooth_no_Q2_disabled="disabled";
						}
						if (!md_gs_dflt_tooth_no_Q3.equals("")){
							md_gs_dflt_tooth_no_Q3_disabled="disabled";
						}
						if (!md_gs_dflt_tooth_no_Q4.equals("")){
							md_gs_dflt_tooth_no_Q4_disabled="disabled";
						}
               
				}else if (chart_level.equals("E")){
					sql="SELECT * FROM OH_PARAM";
					pstmt=con.prepareStatement(sql);
					rs=pstmt.executeQuery();
						while(rs!=null && rs.next()){
							tooth_numbering_system=checkForNull(rs.getString("tooth_numbering_system"));
							gs_no_of_tooth_for_Q1=checkForNull(rs.getString("gs_no_of_tooth_for_Q1"));
							gs_no_of_tooth_for_Q2=checkForNull(rs.getString("gs_no_of_tooth_for_Q2"));
							gs_no_of_tooth_for_Q3=checkForNull(rs.getString("gs_no_of_tooth_for_Q3"));
							gs_no_of_tooth_for_Q4=checkForNull(rs.getString("gs_no_of_tooth_for_Q4"));
							gs_dflt_tooth_no_Q1=checkForNull(rs.getString("gs_dflt_tooth_no_Q1"));
							gs_dflt_tooth_no_Q2=checkForNull(rs.getString("gs_dflt_tooth_no_Q2"));
							gs_dflt_tooth_no_Q3=checkForNull(rs.getString("gs_dflt_tooth_no_Q3"));
							gs_dflt_tooth_no_Q4=checkForNull(rs.getString("gs_dflt_tooth_no_Q4"));
							dec_gs_no_of_tooth_for_Q1=checkForNull(rs.getString("dec_gs_no_of_tooth_for_Q1"));
							dec_gs_no_of_tooth_for_Q2=checkForNull(rs.getString("dec_gs_no_of_tooth_for_Q2"));
							dec_gs_no_of_tooth_for_Q3=checkForNull(rs.getString("dec_gs_no_of_tooth_for_Q3"));
							dec_gs_no_of_tooth_for_Q4=checkForNull(rs.getString("dec_gs_no_of_tooth_for_Q4"));
							dec_gs_dflt_tooth_no_Q1=checkForNull(rs.getString("dec_gs_dflt_tooth_no_Q1"));
							dec_gs_dflt_tooth_no_Q2=checkForNull(rs.getString("dec_gs_dflt_tooth_no_Q2"));
							dec_gs_dflt_tooth_no_Q3=checkForNull(rs.getString("dec_gs_dflt_tooth_no_Q3"));
							dec_gs_dflt_tooth_no_Q4=checkForNull(rs.getString("dec_gs_dflt_tooth_no_Q4"));
							md_gs_no_of_tooth_for_Q1=checkForNull(rs.getString("md_gs_no_of_tooth_for_Q1"));
							md_gs_no_of_tooth_for_Q2=checkForNull(rs.getString("md_gs_no_of_tooth_for_Q2"));
							md_gs_no_of_tooth_for_Q3=checkForNull(rs.getString("md_gs_no_of_tooth_for_Q3"));
							md_gs_no_of_tooth_for_Q4=checkForNull(rs.getString("md_gs_no_of_tooth_for_Q4"));
							md_gs_dflt_tooth_no_Q1=checkForNull(rs.getString("md_gs_dflt_tooth_no_Q1"));
							md_gs_dflt_tooth_no_Q2=checkForNull(rs.getString("md_gs_dflt_tooth_no_Q2"));
							md_gs_dflt_tooth_no_Q3=checkForNull(rs.getString("md_gs_dflt_tooth_no_Q3"));
							md_gs_dflt_tooth_no_Q4=checkForNull(rs.getString("md_gs_dflt_tooth_no_Q4"));
							record_gingival_status_yn=checkForNull(rs.getString("record_gingival_status_yn"));
							dflt_mixed_dentition_chart=checkForNull(rs.getString("dflt_mixed_dentition_chart"));
					}
						if (!gs_dflt_tooth_no_Q1.equals("")){
							gs_dflt_tooth_no_Q1_disabled="disabled";
							
						}
						if(!gs_dflt_tooth_no_Q2.equals("")){
							gs_dflt_tooth_no_Q2_disabled="disabled";
						}	
						 if(!gs_dflt_tooth_no_Q3.equals("")){
							gs_dflt_tooth_no_Q3_disabled="disabled";
						}
						 if(!gs_dflt_tooth_no_Q3.equals("")){
							gs_dflt_tooth_no_Q3_disabled="disabled";
						}
			
						if (!dec_gs_dflt_tooth_no_Q1.equals("")){
							dec_gs_dflt_tooth_no_Q1_disabled="disabled";
						}
						if (!dec_gs_dflt_tooth_no_Q2.equals("")){
							dec_gs_dflt_tooth_no_Q2_disabled="disabled";
						}
						if (!dec_gs_dflt_tooth_no_Q3.equals("")){
							dec_gs_dflt_tooth_no_Q3_disabled="disabled";
						}
						if (!md_gs_dflt_tooth_no_Q1.equals("")){
							md_gs_dflt_tooth_no_Q1_disabled="disabled";
						}
						if (!md_gs_dflt_tooth_no_Q2.equals("")){
							md_gs_dflt_tooth_no_Q2_disabled="disabled";
						}
						if (!md_gs_dflt_tooth_no_Q3.equals("")){
							md_gs_dflt_tooth_no_Q3_disabled="disabled";
						}
						if (!md_gs_dflt_tooth_no_Q4.equals("")){
							md_gs_dflt_tooth_no_Q4_disabled="disabled";
						}

				}
				if(callFrom.equals("T")){
					gs_no_of_tooth_for_Q1="";
					gs_no_of_tooth_for_Q2="";
					gs_no_of_tooth_for_Q3="";
					gs_no_of_tooth_for_Q4="";
					gs_dflt_tooth_no_Q1="";
					gs_dflt_tooth_no_Q2="";
					gs_dflt_tooth_no_Q3="";
					gs_dflt_tooth_no_Q4="";

					dec_gs_no_of_tooth_for_Q1="";
					dec_gs_no_of_tooth_for_Q2="";
					dec_gs_no_of_tooth_for_Q3="";
					dec_gs_no_of_tooth_for_Q4="";
					dec_gs_dflt_tooth_no_Q1="";
					dec_gs_dflt_tooth_no_Q2="";
					dec_gs_dflt_tooth_no_Q3="";
					dec_gs_dflt_tooth_no_Q4="";

					md_gs_no_of_tooth_for_Q1="";
					md_gs_no_of_tooth_for_Q2="";
					md_gs_no_of_tooth_for_Q3="";
					md_gs_no_of_tooth_for_Q4="";
					md_gs_dflt_tooth_no_Q1="";
					md_gs_dflt_tooth_no_Q2="";
					md_gs_dflt_tooth_no_Q3="";
					md_gs_dflt_tooth_no_Q4="";				
				}

				if(record_gingival_status_yn.equals("Y")){
				checked_yn = "checked";
				chk_value = "Y";

				}
				else{
					checked_yn = "";
					chk_value = "N";
				}
					/*if (!gs_dflt_tooth_no_Q1.equals("")){
						gs_dflt_tooth_no_Q1_disabled="disabled";
						
					}
					if(!gs_dflt_tooth_no_Q2.equals("")){
						gs_dflt_tooth_no_Q2_disabled="disabled";
					}	
					 if(!gs_dflt_tooth_no_Q3.equals("")){
						gs_dflt_tooth_no_Q3_disabled="disabled";
					}
					 if(!gs_dflt_tooth_no_Q3.equals("")){
						gs_dflt_tooth_no_Q3_disabled="disabled";
					}
		
					if (!dec_gs_dflt_tooth_no_Q1.equals("")){
						dec_gs_dflt_tooth_no_Q1_disabled="disabled";
					}
					if (!dec_gs_dflt_tooth_no_Q2.equals("")){
						dec_gs_dflt_tooth_no_Q2_disabled="disabled";
					}
					if (!dec_gs_dflt_tooth_no_Q3.equals("")){
						dec_gs_dflt_tooth_no_Q3_disabled="disabled";
					}
					if (!md_gs_dflt_tooth_no_Q1.equals("")){
						md_gs_dflt_tooth_no_Q1_disabled="disabled";
					}
					if (!md_gs_dflt_tooth_no_Q2.equals("")){
						md_gs_dflt_tooth_no_Q2_disabled="disabled";
					}
					if (!md_gs_dflt_tooth_no_Q3.equals("")){
						md_gs_dflt_tooth_no_Q3_disabled="disabled";
					}
					if (!md_gs_dflt_tooth_no_Q4.equals("")){
						md_gs_dflt_tooth_no_Q4_disabled="disabled";
					}
               */
			  }

			if(callFrom.equals("Q")){
					gs_no_of_tooth_for_Q1=gs_no_of_tooth_for_Q1_hidden;
					gs_no_of_tooth_for_Q2=gs_no_of_tooth_for_Q2_hidden;
					gs_no_of_tooth_for_Q3=gs_no_of_tooth_for_Q3_hidden;
					gs_no_of_tooth_for_Q4=gs_no_of_tooth_for_Q4_hidden;
					gs_dflt_tooth_no_Q1=gs_dflt_tooth_no_Q1_hidden;
					gs_dflt_tooth_no_Q2=gs_dflt_tooth_no_Q2_hidden;
					gs_dflt_tooth_no_Q3=gs_dflt_tooth_no_Q3_hidden;
					gs_dflt_tooth_no_Q4=gs_dflt_tooth_no_Q4_hidden;

					dec_gs_no_of_tooth_for_Q1=dec_gs_no_of_tooth_for_Q1_hidden;
					dec_gs_no_of_tooth_for_Q2=dec_gs_no_of_tooth_for_Q2_hidden;
					dec_gs_no_of_tooth_for_Q3=dec_gs_no_of_tooth_for_Q3_hidden;
					dec_gs_no_of_tooth_for_Q4=dec_gs_no_of_tooth_for_Q4_hidden;
					dec_gs_dflt_tooth_no_Q1=dec_gs_dflt_tooth_no_Q1_hidden;
					dec_gs_dflt_tooth_no_Q2=dec_gs_dflt_tooth_no_Q2_hidden;
					dec_gs_dflt_tooth_no_Q3=dec_gs_dflt_tooth_no_Q3_hidden;
					dec_gs_dflt_tooth_no_Q4=dec_gs_dflt_tooth_no_Q4_hidden;

					md_gs_no_of_tooth_for_Q1=md_gs_no_of_tooth_for_Q1_hidden;
					md_gs_no_of_tooth_for_Q2=md_gs_no_of_tooth_for_Q2_hidden;
					md_gs_no_of_tooth_for_Q3=md_gs_no_of_tooth_for_Q3_hidden;
					md_gs_no_of_tooth_for_Q4=md_gs_no_of_tooth_for_Q4_hidden;
					md_gs_dflt_tooth_no_Q1=md_gs_dflt_tooth_no_Q1_hidden;
					md_gs_dflt_tooth_no_Q2=md_gs_dflt_tooth_no_Q2_hidden;
					md_gs_dflt_tooth_no_Q3=md_gs_dflt_tooth_no_Q3_hidden;
					md_gs_dflt_tooth_no_Q4=md_gs_dflt_tooth_no_Q4_hidden;

				
				}			
			//sql="SELECT TOOTH_NO, DECODE(?,'UNI', UNIVERSAL_TOOTH_NO,'FDI',FDI_TOOTH_NO,'') TOOTH_NUM FROM OH_TOOTH where PERMANENT_DECIDUOUS = 'P' ORDER BY TOOTH_NO ASC";
			//for Permanent and MP chart
			sql="SELECT A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
			
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,tooth_numbering_system);
			rs=pstmt.executeQuery();
			String tooth_no = "";
			String tooth_num = "";
			while(rs!=null && rs.next()){

				tooth_no=checkForNull(rs.getString("TOOTH_NO"));
				tooth_num=checkForNull(rs.getString("TOOTH_NUM"));
				if(tooth_num.equals("")){
					map = new HashMap();
				}
				else{
					map.put(tooth_no,tooth_num);
				}
			}
           //for deciduous tooth
			String sql_dec="SELECT A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'D' ORDER BY A.TOOTH_NO ASC";
				
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			pstmt=con.prepareStatement(sql_dec);
			pstmt.setString(1,tooth_numbering_system);
			rs=pstmt.executeQuery();
			while(rs!=null && rs.next()){

				tooth_no=checkForNull(rs.getString("TOOTH_NO"));
				tooth_num=checkForNull(rs.getString("TOOTH_NUM"));
				if(tooth_num.equals("")){
					map_dec = new HashMap();
				}
				else{
					map_dec.put(tooth_no,tooth_num);
				}
			}
			//MD chart 
			String sql_1="SELECT A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM =? AND (A.PERMANENT_DECIDUOUS = 'D' OR MIXED_DENT_TOOTH_NO IS NOT NULL) ORDER BY MIXED_DENT_TOOTH_ORDER ASC";
			
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			pstmt=con.prepareStatement(sql_1);
			pstmt.setString(1,tooth_numbering_system);
			//pstmt.setString(2,dflt_mixed_dentition_chart);
			rs=pstmt.executeQuery();
			String tooth_no_md = "";
			String tooth_num_md = "";
			while(rs!=null && rs.next()){

				tooth_no_md=checkForNull(rs.getString("TOOTH_NO"));
				tooth_num_md=checkForNull(rs.getString("TOOTH_NUM"));
				if(tooth_num_md.equals("")){
					map_md = new HashMap();
				}
				else{
					map_md.put(tooth_no_md,tooth_num_md);
				}
			}
		%>
		
	<div id='ohquad'>
    	<table border=0 cellspacing=0 cellpadding=1 width='100%' align=center>
    		<tr > 
			 <td width="10%">
				<table border=0 cellspacing=0 cellpadding=8 width='100%' align=center>
					
				<tr align=center ><th ></th> </tr>
				<tr align=center ><th  align=center ><fmt:message key="eOH.Quadrant.Label" bundle="${oh_labels}"/></th></tr>   
				<tr align=center ><th  align=center></th></tr>    
 
				<tr><td width="20%" class="LABEL"><fmt:message key="eOH.UpperRight.Label" bundle="${oh_labels}"/></td></tr>
				<tr><td width="20%" class="LABEL"><fmt:message key="eOH.UpperLeft.Label" bundle="${oh_labels}"/></td></tr>
				<tr><td width="20%" class="LABEL"><fmt:message key="eOH.LowerRight.Label" bundle="${oh_labels}"/></td></tr>
				<tr><td width="20%" class="LABEL"><fmt:message key="eOH.LowerLeft.Label" bundle="${oh_labels}"/></td></tr>
				</table>
			</td>
          
			<td width="25%">
				 <table  border=0 cellspacing=1 cellpadding=3 width='100%' align=center>
					<tr align=center colspan=2>
						<th align=center colspan=3><fmt:message key="eOH.Decedious.Label" bundle="${oh_labels}"/></th>
					</tr>
					<tr >						
						<th ><fmt:message key="eOH.MaxNumOfTooth.Label" bundle="${oh_labels}"/></th>
						<th colspan=2><fmt:message key="eOH.DefaultToothNo.Label" bundle="${oh_labels}"/></th> 
					</tr>
					<tr >
							<!-- <td width="20%" class="LABEL"><fmt:message key="eOH.UpperRight.Label" bundle="${oh_labels}"/></td> -->
							<td width="25%" align="center" id="dec_gs_for_Q1" ><input type="text" name="dec_gs_no_of_tooth_for_Q1" id="dec_gs_no_of_tooth_for_Q1" value="<%=dec_gs_no_of_tooth_for_Q1%>" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)" DB_VALUE="<%=dec_gs_no_of_tooth_for_Q1%>">
							

							<%
								if(record_gingival_status.equals("Y")){
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="100%" id="dec_gs_dflt_for_Q1">
								 <select name="dec_gs_dflt_tooth_no_Q1" id="dec_gs_dflt_tooth_no_Q1" DB_VALUE="<%=dec_gs_dflt_tooth_no_Q1%>" <%=dec_gs_dflt_tooth_no_Q1_disabled%> >
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										for(int m=33;m<=37;m++){
											n=""+m;
											if(map_dec.isEmpty() == false){
												map_val_dec = map_dec.get(n).toString();
												out.println("<option value='"+m+"' "+tooth_selected+">"+map_val_dec+"</option>");
												//out.println("<option value='"+m+"'>map_val_dec+"</option>");
											}
										}
									%>
								</select> 
							
								<%
									if(record_gingival_status.equals("Y")){								
								%>
										<img src='../../eCommon/images/mandatory.gif'></img>
								<%
									}
								%>
							</td>
						</tr>
						<tr>
							<!-- <td width="20%" class="LABEL"><fmt:message key="eOH.UpperLeft.Label" bundle="${oh_labels}"/></td> -->
							<td width="25%" align="center" id="dec_gs_for_Q2"><input type="text" name="dec_gs_no_of_tooth_for_Q2" id="dec_gs_no_of_tooth_for_Q2" value="<%=dec_gs_no_of_tooth_for_Q2%>" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)" DB_VALUE="<%=dec_gs_no_of_tooth_for_Q2%>" >
							<%
								if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>
							
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="100%" id="dec_gs_dflt_for_Q2">
								<select name="dec_gs_dflt_tooth_no_Q2" id="dec_gs_dflt_tooth_no_Q2" DB_VALUE="<%=dec_gs_dflt_tooth_no_Q2%>" <%=dec_gs_dflt_tooth_no_Q2_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										for(int m=38;m<=42;m++){
											n=""+m;
											if(map_dec.isEmpty() == false){
												map_val_dec = map_dec.get(n).toString();
												out.println("<option value='"+m+"'>"+map_val_dec+"</option>");
											}
										}
									%>
								</select>
								<%
									if(record_gingival_status.equals("Y")){								
								%>
										<img src='../../eCommon/images/mandatory.gif'></img>
								<%
								}
								%>
							</td>
						</tr>
						<tr>
							<!-- <td width="20%" class="LABEL"><fmt:message key="eOH.LowerRight.Label" bundle="${oh_labels}"/></td> -->
							<td width="25%" align="center" id="dec_gs_for_Q3"><input type="text" name="dec_gs_no_of_tooth_for_Q3" id="dec_gs_no_of_tooth_for_Q3" value="<%=dec_gs_no_of_tooth_for_Q3%>" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)" DB_VALUE="<%=dec_gs_no_of_tooth_for_Q3%>" >
							<%
									if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>

							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="100%" id="dec_gs_dflt_for_Q3">
								<select name="dec_gs_dflt_tooth_no_Q3" id="dec_gs_dflt_tooth_no_Q3" DB_VALUE="<%=dec_gs_dflt_tooth_no_Q3%>" <%=dec_gs_dflt_tooth_no_Q3_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										for(int m=43;m<=47;m++){
											n=""+m;
											if(map_dec.isEmpty() == false){
												map_val_dec = map_dec.get(n).toString();
												out.println("<option value='"+m+"'>"+map_val_dec+"</option>");
											}
										}
									%>
								</select>
								<%
									if(record_gingival_status.equals("Y")){								
								%>
										<img src='../../eCommon/images/mandatory.gif'></img>
								<%
									}
								%>
							</td>
						</tr>
						<tr>
							<!-- <td width="20%" class="LABEL"><fmt:message key="eOH.LowerLeft.Label" bundle="${oh_labels}"/></td> -->
							<td width="25%" align="center" id="dec_gs_for_Q4" ><input type="text" name="dec_gs_no_of_tooth_for_Q4" id="dec_gs_no_of_tooth_for_Q4" value="<%=dec_gs_no_of_tooth_for_Q4%>" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)" DB_VALUE="<%=dec_gs_no_of_tooth_for_Q4%>" >
							<%
									if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="100%"  id="dec_gs_dflt_for_Q4">
								<select name="dec_gs_dflt_tooth_no_Q4" id="dec_gs_dflt_tooth_no_Q4" DB_VALUE="<%=dec_gs_dflt_tooth_no_Q4%>" <%=dec_gs_dflt_tooth_no_Q3_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										for(int m=48;m<=52;m++){
											n=""+m;
											if(map_dec.isEmpty() == false){
												map_val_dec = map_dec.get(n).toString();
												out.println("<option value='"+m+"'>"+map_val_dec+"</option>");
											}
										}
									%>
								</select>
								<%
									if(record_gingival_status.equals("Y")){								
								%>
										<img src='../../eCommon/images/mandatory.gif'></img>
								<%
									}
								%>
							</td>
						</tr>
					</table>
				</td>
				<td width="25%" >
					<table  border=0 cellspacing=1 cellpadding=3 width='100%' align=center>
						<tr align="center">
						<% 
							if(from_mixed_dentition.equals("D") || dflt_mixed_dentition_chart.equals("D")){
						%>
							<th align="center" colspan=3><fmt:message key="eOH.DeciduousMD.Label" bundle="${oh_labels}"/></th>
						<%
							
						}else if(from_mixed_dentition.equals("P") || dflt_mixed_dentition_chart.equals("P") || dflt_mixed_dentition_chart.equals("")){
						
						%>
							<th align="center" colspan=3 ><fmt:message key="eOH.PermanentMD.Label" bundle="${oh_labels}"/></th>
							
						<%}%>
					   </tr>
						<tr>
									
							<th ><fmt:message key="eOH.MaxNumOfTooth.Label" bundle="${oh_labels}"/></th>
							<th colspan=2><fmt:message key="eOH.DefaultToothNo.Label" bundle="${oh_labels}"/></th> 
							
						</tr>
						<tr>
						
							<!-- <td width="25%" class="LABEL"><fmt:message key="eOH.UpperRight.Label" bundle="${oh_labels}"/></td> -->
							<td width="25%" align="center" id="md_gs_for_Q1" ><input type="text" name="md_gs_no_of_tooth_for_Q1" id="md_gs_no_of_tooth_for_Q1" value="<%=md_gs_no_of_tooth_for_Q1%>" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)" DB_VALUE="<%=md_gs_no_of_tooth_for_Q1%>" >

							<%
								if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="100%" id="md_gs_dflt_for_Q1">
								<select name="md_gs_dflt_tooth_no_Q1" id="md_gs_dflt_tooth_no_Q1" DB_VALUE="<%=md_gs_dflt_tooth_no_Q1%>" <%=md_gs_dflt_tooth_no_Q1_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
								if(from_mixed_dentition.equals("P")){
										for(int s=2;s<=8;s++){
											q=""+s;
											if(map.isEmpty() == false){
												map_val = map.get(q).toString();
												out.println("<option value='"+s+"' "+tooth_selected+">"+map_val+"</option>");
											}							
									}
								}else if(from_mixed_dentition.equals("D")){
									for(int s=2;s<=3;s++){
											q=""+s;
											if(map_md.isEmpty() == false){
												map_val_md= map_md.get(q).toString();
												out.println("<option value='"+s+"' "+tooth_selected+">"+map_val_md+"</option>");
											}							
									}
									for(int s=33;s<=37;s++){
											q=""+s;
											if(map_md.isEmpty() == false){
												map_val_md= map_md.get(q).toString();
												out.println("<option value='"+s+"' "+tooth_selected+">"+map_val_md+"</option>");
										}							
									}			
								}
									%>
								</select>
								<%
									if(record_gingival_status.equals("Y")){
								%>
										<!-- <img src='../../eCommon/images/mandatory.gif'></img> -->
								<%
									}
								%>
							</td>
						</tr>
						<tr>
							<!-- <td width="25%" class="LABEL"><fmt:message key="eOH.UpperLeft.Label" bundle="${oh_labels}"/></td> -->
							<td width="25%" align="center" id="md_gs_for_Q2"><input type="text" name="md_gs_no_of_tooth_for_Q2" id="md_gs_no_of_tooth_for_Q2" value="<%=md_gs_no_of_tooth_for_Q2%>" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)" DB_VALUE="<%=md_gs_no_of_tooth_for_Q2%>" >
							<%
								if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>
							
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="25%" id="md_gs_dflt_for_Q2">
								<select name="md_gs_dflt_tooth_no_Q2" id="md_gs_dflt_tooth_no_Q2" DB_VALUE="<%=md_gs_dflt_tooth_no_Q2%>" <%=md_gs_dflt_tooth_no_Q2_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										if(from_mixed_dentition.equals("P")){
											for(int s=9;s<=15;s++){
												q=""+s;
												if(map.isEmpty() == false){
													map_val = map.get(q).toString();
													out.println("<option value='"+s+"' "+tooth_selected+">"+map_val+"</option>");
												}							
											}
										}else if(from_mixed_dentition.equals("D")){
											for(int s=38;s<=42;s++){
													q=""+s;
													if(map_md.isEmpty() == false){
														map_val_md= map_md.get(q).toString();
														out.println("<option value='"+s+"' "+tooth_selected+">"+map_val_md+"</option>");
													}							
											}
											for(int s=14;s<=15;s++){
													q=""+s;
													if(map_md.isEmpty() == false){
														map_val_md= map_md.get(q).toString();
														out.println("<option value='"+s+"' "+tooth_selected+">"+map_val_md+"</option>");
												}							
											}			
										}
									%>
								</select>
								<%
									if(record_gingival_status.equals("Y") || from_mixed_dentition.equals("") || from_mixed_dentition.equals("null")){
								%>
										<!-- <img src='../../eCommon/images/mandatory.gif'></img> -->
								<%
									}
								%>
							</td>
						</tr>
						<tr>
							<!-- <td width="25%" class="LABEL"><fmt:message key="eOH.LowerRight.Label" bundle="${oh_labels}"/></td> -->
							<td width="25%" align="center" id="md_gs_for_Q3"><input type="text" name="md_gs_no_of_tooth_for_Q3" id="md_gs_no_of_tooth_for_Q3" value="<%=md_gs_no_of_tooth_for_Q3%>" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)" DB_VALUE="<%=md_gs_no_of_tooth_for_Q3%>" >
							<%
									if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>

							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="25%" id="md_gs_dflt_for_Q3">
								<select name="md_gs_dflt_tooth_no_Q3" id="md_gs_dflt_tooth_no_Q3" DB_VALUE="<%=md_gs_dflt_tooth_no_Q3%>" <%=md_gs_dflt_tooth_no_Q3_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										if(from_mixed_dentition.equals("P")){
											for(int s=25;s<=31;s++){
													q=""+s;
													if(map.isEmpty() == false){
														map_val = map.get(q).toString();
														out.println("<option value='"+s+"' "+tooth_selected+">"+map_val+"</option>");
													}							
												}
										}else if(from_mixed_dentition.equals("D")){
											for(int s=48;s<=52;s++){
													q=""+s;
													if(map_md.isEmpty() == false){
														map_val_md= map_md.get(q).toString();
														out.println("<option value='"+s+"' "+tooth_selected+">"+map_val_md+"</option>");
													}							
											}
											for(int s=31;s<=32;s++){
													q=""+s;
													if(map_md.isEmpty() == false){
														map_val_md= map_md.get(q).toString();
														out.println("<option value='"+s+"' "+tooth_selected+">"+map_val_md+"</option>");
												}							
											}			
										}
									%>
								</select>
								<%
									if(record_gingival_status.equals("Y")){
								%>
										<!-- <img src='../../eCommon/images/mandatory.gif'></img> -->
								<%
									}
								%>
							</td>
						</tr>
						<tr>
							<!-- <td width="25%" class="LABEL"><fmt:message key="eOH.LowerLeft.Label" bundle="${oh_labels}"/></td> -->
							<td width="25%" align="center" id="md_gs_for_Q4" ><input type="text" name="md_gs_no_of_tooth_for_Q4" id="md_gs_no_of_tooth_for_Q4" value="<%=md_gs_no_of_tooth_for_Q4%>" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)" DB_VALUE="<%=md_gs_no_of_tooth_for_Q4%>" >
							<%
									if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>
							</td>

							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="25%"  id="md_gs_dflt_for_Q4">
								<select name="md_gs_dflt_tooth_no_Q4" id="md_gs_dflt_tooth_no_Q4" DB_VALUE="<%=md_gs_dflt_tooth_no_Q4%>" <%=md_gs_dflt_tooth_no_Q4_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										if(from_mixed_dentition.equals("P")){
											for(int s=18;s<=24;s++){
													q=""+s;
													if(map.isEmpty() == false){
														map_val = map.get(q).toString();
														out.println("<option value='"+s+"' "+tooth_selected+">"+map_val+"</option>");
													}							
											}
										}else if (from_mixed_dentition.equals("D")){
											for(int s=43;s<=47;s++){
													q=""+s;
													if(map_md.isEmpty() == false){
														map_val_md= map_md.get(q).toString();
														out.println("<option value='"+s+"' "+tooth_selected+">"+map_val_md+"</option>");
													}							
											}
											for(int s=18;s<=19;s++){
													q=""+s;
													if(map_md.isEmpty() == false){
														map_val_md= map_md.get(q).toString();
														out.println("<option value='"+s+"' "+tooth_selected+">"+map_val_md+"</option>");
												}							
											}			
										}
									%>
								</select>
								<%
									if(record_gingival_status.equals("Y")){
								%>
										<!-- <img src='../../eCommon/images/mandatory.gif'></img> -->
								<%
									}
								%>
							</td>
						</tr>
						
					</table>
			  </td>
				
              <td width="25%">
				<table  border=0 cellspacing=1 cellpadding=3 width='100%' align=center>
						<tr align="center">
							<th align="center" colspan=3><fmt:message key="Common.Permanent.label" bundle="${common_labels}"/></th>
						</tr>
						<tr>
										
							<th ><fmt:message key="eOH.MaxNumOfTooth.Label" bundle="${oh_labels}"/></th>
							<th colspan=2><fmt:message key="eOH.DefaultToothNo.Label" bundle="${oh_labels}"/></th> 
							
						</tr>
						<tr>
						
							<!-- <td width="25%" class="LABEL"><fmt:message key="eOH.UpperRight.Label" bundle="${oh_labels}"/></td> -->
							<td width="25%" align="center" id="gs_for_Q1" ><input type="text" name="gs_no_of_tooth_for_Q1" id="gs_no_of_tooth_for_Q1" value="<%=gs_no_of_tooth_for_Q1%>" size="1" maxlength="1" onBlur="validateNumOfTooth(this)" DB_VALUE="<%=gs_no_of_tooth_for_Q1%>" >

							<%
								if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
							}
							%>
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="100%" id="gs_dflt_for_Q1">
								<select name="gs_dflt_tooth_no_Q1" id="gs_dflt_tooth_no_Q1" DB_VALUE="<%=gs_dflt_tooth_no_Q1%>" <%=gs_dflt_tooth_no_Q1_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										for(int i=1;i<=8;i++){
											j=""+i;
											if(map.isEmpty() == false){
												map_val = map.get(j).toString();
												out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
											}
										}
									%>
								</select>
								<%
									if(record_gingival_status.equals("Y")){								
								%>
										<img src='../../eCommon/images/mandatory.gif'></img>
								<%
									}
								%>
							</td>
						</tr>
						<tr>
							<!-- <td width="25%" class="LABEL"><fmt:message key="eOH.UpperLeft.Label" bundle="${oh_labels}"/></td> -->
							<td width="25%" align="center" id="gs_for_Q2"><input type="text" name="gs_no_of_tooth_for_Q2" id="gs_no_of_tooth_for_Q2" value="<%=gs_no_of_tooth_for_Q2%>" size="1" maxlength="1" onBlur="validateNumOfTooth(this)" DB_VALUE="<%=gs_no_of_tooth_for_Q2%>" >
							<%
							if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
							}
							%>
							
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="25%" id="gs_dflt_for_Q2">
								<select name="gs_dflt_tooth_no_Q2" id="gs_dflt_tooth_no_Q2" DB_VALUE="<%=gs_dflt_tooth_no_Q2%>" <%=gs_dflt_tooth_no_Q2_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										for(int i=9;i<=16;i++){
											j=""+i;
											if(map.isEmpty() == false){
												map_val = map.get(j).toString();
												out.println("<option value='"+i+"'>"+map_val+"</option>");
											}
										}
									%>
								</select>
								<%
									if(record_gingival_status.equals("Y")){								
								%>
										<img src='../../eCommon/images/mandatory.gif'></img>
								<%
									}
								%>
							</td>
						</tr>
						<tr>
						<!-- 	<td width="25%" class="LABEL"><fmt:message key="eOH.LowerRight.Label" bundle="${oh_labels}"/></td> -->
							<td width="25%" align="center" id="gs_for_Q3"><input type="text" name="gs_no_of_tooth_for_Q3" id="gs_no_of_tooth_for_Q3" value="<%=gs_no_of_tooth_for_Q3%>" size="1" maxlength="1" onBlur="validateNumOfTooth(this)" DB_VALUE="<%=gs_no_of_tooth_for_Q3%>" >
							<%
								if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>

							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="25%" id="gs_dflt_for_Q3">
								<select name="gs_dflt_tooth_no_Q3" id="gs_dflt_tooth_no_Q3" DB_VALUE="<%=gs_dflt_tooth_no_Q3%>" <%=gs_dflt_tooth_no_Q3_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										for(int i=25;i<=32;i++){
											j=""+i;
											if(map.isEmpty() == false){
												map_val = map.get(j).toString();
												out.println("<option value='"+i+"'>"+map_val+"</option>");
											}
										}
									%>
								</select>
								<%
									if(record_gingival_status.equals("Y")){								
								%>
										<img src='../../eCommon/images/mandatory.gif'></img>
								<%
									}
								%>
							</td>
						</tr>
						<tr>
							<!-- <td width="25%" class="LABEL"><fmt:message key="eOH.LowerLeft.Label" bundle="${oh_labels}"/></td> -->
							<td width="25%" align="center" id="gs_for_Q4" ><input type="text" name="gs_no_of_tooth_for_Q4" id="gs_no_of_tooth_for_Q4" value="<%=gs_no_of_tooth_for_Q4%>" size="1" maxlength="1" onBlur="validateNumOfTooth(this)" DB_VALUE="<%=gs_no_of_tooth_for_Q4%>" >
							<%
									if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="25%"  id="gs_dflt_for_Q4">
								<select name="gs_dflt_tooth_no_Q4" id="gs_dflt_tooth_no_Q4" DB_VALUE="<%=gs_dflt_tooth_no_Q4%>" <%=gs_dflt_tooth_no_Q3_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										for(int i=17;i<=24;i++){
											j=""+i;
											if(map.isEmpty() == false){
												map_val = map.get(j).toString();
												out.println("<option value='"+i+"'>"+map_val+"</option>");
											}
										}
									%>
								</select>
								<%
									if(record_gingival_status.equals("Y")){								
								%>
										<img src='../../eCommon/images/mandatory.gif'></img>
								<%
								}
								%>
							</td>
						</tr>
					</td>
				</table>
					<!-- </td> -->
				</tr>
			</table>
		</div>
 
           
			<input type="hidden" name="mode" id="mode" value=<%=mode%>>
			<input type="hidden" name="locale" id="locale" value=<%=locale%>>
			<input type="hidden" name="checked_yn" id="checked_yn" value=<%=checked_yn%>>
			<input type="hidden" name="chart_level" id="chart_level" value=<%=chart_level%>> 
			<input type="hidden" name="tooth_numbering_system" id="tooth_numbering_system" value=<%=tooth_numbering_system%>> 
			<input type="hidden" name="record_gingival_status_yn" id="record_gingival_status_yn" value=<%=record_gingival_status_yn%>> 
			<input type="hidden" name="dflt_mixed_dentition_chart" id="dflt_mixed_dentition_chart" value=<%=dflt_mixed_dentition_chart%>> 
			<input type="hidden" name="from_mixed_dentition" id="from_mixed_dentition" value=<%=from_mixed_dentition%>> 			
			<input type="hidden" name="gs_dflt_tooth_no_Q1_hid" id="gs_dflt_tooth_no_Q1_hid" value=<%=gs_dflt_tooth_no_Q1%>>  
			<input type="hidden" name="gs_dflt_tooth_no_Q2_hid" id="gs_dflt_tooth_no_Q2_hid" value=<%=gs_dflt_tooth_no_Q2%>>  
			<input type="hidden" name="gs_dflt_tooth_no_Q3_hid" id="gs_dflt_tooth_no_Q3_hid" value=<%=gs_dflt_tooth_no_Q3%>>  
			<input type="hidden" name="gs_dflt_tooth_no_Q4_hid" id="gs_dflt_tooth_no_Q4_hid" value=<%=gs_dflt_tooth_no_Q4%>> 
			<input type="hidden" name="gs_no_of_tooth_for_Q1_hid" id="gs_no_of_tooth_for_Q1_hid" value=<%=gs_no_of_tooth_for_Q1%>> 
			<input type="hidden" name="gs_no_of_tooth_for_Q2_hid" id="gs_no_of_tooth_for_Q2_hid" value=<%=gs_no_of_tooth_for_Q2%>> 
			<input type="hidden" name="gs_no_of_tooth_for_Q3_hid" id="gs_no_of_tooth_for_Q3_hid" value=<%=gs_no_of_tooth_for_Q3%>> 
			<input type="hidden" name="gs_no_of_tooth_for_Q4_hid" id="gs_no_of_tooth_for_Q4_hid" value=<%=gs_no_of_tooth_for_Q4%>> 
			<input type="hidden" name="dec_gs_no_of_tooth_for_Q1_hid" id="dec_gs_no_of_tooth_for_Q1_hid" value=<%=dec_gs_no_of_tooth_for_Q1%>> 
			<input type="hidden" name="dec_gs_no_of_tooth_for_Q2_hid" id="dec_gs_no_of_tooth_for_Q2_hid" value=<%=dec_gs_no_of_tooth_for_Q2%>> 
			<input type="hidden" name="dec_gs_no_of_tooth_for_Q3_hid" id="dec_gs_no_of_tooth_for_Q3_hid" value=<%=dec_gs_no_of_tooth_for_Q3%>> 
			<input type="hidden" name="dec_gs_no_of_tooth_for_Q4_hid" id="dec_gs_no_of_tooth_for_Q4_hid" value=<%=dec_gs_no_of_tooth_for_Q4%>> 
			<input type="hidden" name="md_gs_no_of_tooth_for_Q1_hid" id="md_gs_no_of_tooth_for_Q1_hid" value=<%=md_gs_no_of_tooth_for_Q1%>> 
			<input type="hidden" name="md_gs_no_of_tooth_for_Q2_hid" id="md_gs_no_of_tooth_for_Q2_hid" value=<%=md_gs_no_of_tooth_for_Q2%>> 
			<input type="hidden" name="md_gs_no_of_tooth_for_Q3_hid" id="md_gs_no_of_tooth_for_Q3_hid" value=<%=md_gs_no_of_tooth_for_Q3%>> 
			<input type="hidden" name="md_gs_no_of_tooth_for_Q4_hid" id="md_gs_no_of_tooth_for_Q4_hid" value=<%=md_gs_no_of_tooth_for_Q4%>> 
			<input type="hidden" name="md_gs_dflt_tooth_no_Q1_hid" id="md_gs_dflt_tooth_no_Q1_hid" value=<%=md_gs_dflt_tooth_no_Q1%>> 
			<input type="hidden" name="md_gs_dflt_tooth_no_Q2_hid" id="md_gs_dflt_tooth_no_Q2_hid" value=<%=md_gs_dflt_tooth_no_Q2%>> 
			<input type="hidden" name="md_gs_dflt_tooth_no_Q3_hid" id="md_gs_dflt_tooth_no_Q3_hid" value=<%=md_gs_dflt_tooth_no_Q3%>> 
			<input type="hidden" name="md_gs_dflt_tooth_no_Q4_hid" id="md_gs_dflt_tooth_no_Q4_hid" value=<%=md_gs_dflt_tooth_no_Q4%>> 
			<input type="hidden" name="gigival_recorded" id="gigival_recorded" value="Q">

			<input type="hidden" name="mixed_dentition_from_age_yrs_hid" id="mixed_dentition_from_age_yrs_hid" value="">
			<input type="hidden" name="mixed_dentition_to_age_yrs_hid" id="mixed_dentition_to_age_yrs_hid" value="">
			<input type="hidden" name="mixed_dentition_from_age_days_hid" id="mixed_dentition_from_age_days_hid" value="">
			<input type="hidden" name="mixed_dentition_to_age_days_hid" id="mixed_dentition_to_age_days_hid" value="">
			<input type="hidden" name="deciduous_grace_period_days_hid" id="deciduous_grace_period_days_hid" value="">
			<input type="hidden" name="rest_chrt_validity_days_hid" id="rest_chrt_validity_days_hid" value="">
			<input type="hidden" name="peri_chrt_validity_days_hid" id="peri_chrt_validity_days_hid" value="">
			<input type="hidden" name="record_gingival_status_yn_hid" id="record_gingival_status_yn_hid" value="">
			<input type="hidden" name="bl_interface_flag_hid" id="bl_interface_flag_hid" value="">
			<input type="hidden" name="gingival_recording_by_hid" id="gingival_recording_by_hid" value="">
			<input type="hidden" name="tooth_numbering_system_hid" id="tooth_numbering_system_hid" value="">		
			
		</form>
		<script>
			    var chart_level=document.forms[0].chart_level.value;
		         if(chart_level=="F" || chart_level=="" ||chart_level=="null" || chart_level==null){
					 AssignQuadrantValue();
				 }else if (chart_level=="E"){
					 AssignParamQuadrantValue();
				 }
		 </script>
		
	
	  </body>
	</html>
	<%
	}
	catch(Exception e){
		e.printStackTrace() ;
	}
	finally{
		try{
			
			if(rs!=null)rs.close();
			if(rs1!=null)rs1.close();
			if(pstmt!=null) pstmt.close();
			if(pstmt1!=null) pstmt1.close();
			ConnectionManager.returnConnection(con);
		}
		catch(Exception e){
			e.printStackTrace() ;
		}
		
	}

%>

