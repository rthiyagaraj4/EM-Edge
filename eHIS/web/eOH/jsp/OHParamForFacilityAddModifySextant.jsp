<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.util.*,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp" %>
<%String mode=request.getParameter("mode");
    String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
	String record_gingival_status_yn = checkForNull(request.getParameter("record_gingival_status_yn")); 
%>
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
	<!-- changed by parul on 211008 forSCR#6126 -->
	<!-- commented by parul on 10/08/2009 for crf 0456(IN009737) written in last AssignSextantValue() -->
	 <!--   <body  onLoad= "AssignSextantValue('<%=tooth_numbering_system%>','<%=record_gingival_status_yn%>');document.getElementById('ohsextant').visibility = 'display';document.getElementById('ohsextant').style.display = ''"; OnMouseDown='CodeArrest()' onKeyDown="lockKey()"> -->
	    <body  onLoad= "document.getElementById('ohsextant').visibility = 'display';document.getElementById('ohsextant').style.display = ''"; OnMouseDown='CodeArrest()' onKeyDown="lockKey()"> 
		<form name="OHParameterForFacilityFormForSextant" id="OHParameterForFacilityFormForSextant" >
		 <%
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String facility_id = (String)session.getValue("facility_id") ;
		  // String mode=request.getParameter("mode");
			//String tooth_numbering_system=""; //commented by parul on 211008 forSCR#6126
		//	String record_gingival_status_yn = ""; //commented by parul on 211008 forSCR#6126
			String record_gingival_status = checkForNull(request.getParameter("record_gingival_status_yn"));
			String from_mixed_dentition = checkForNull(request.getParameter("from_mixed_dentition"));
			String dflt_mixed_dentition_chart_hid = checkForNull(request.getParameter("dflt_mixed_dentition_chart"));
			
			String callFrom = checkForNull(request.getParameter("callFrom"));
			String chart_level = checkForNull(request.getParameter("chart_level"));
			String gs_dflt_tooth_no_S1_disabled = "";
			String gs_dflt_tooth_no_S2_disabled = "";
			String gs_dflt_tooth_no_S3_disabled = "";
			String gs_dflt_tooth_no_S4_disabled = "";
			String gs_dflt_tooth_no_S5_disabled = "";
			String gs_dflt_tooth_no_S6_disabled = "";

			String dec_gs_dflt_tooth_no_S1_disabled = "";
			String dec_gs_dflt_tooth_no_S2_disabled = "";
			String dec_gs_dflt_tooth_no_S3_disabled = "";
			String dec_gs_dflt_tooth_no_S4_disabled = "";
			String dec_gs_dflt_tooth_no_S5_disabled = "";
			String dec_gs_dflt_tooth_no_S6_disabled = "";

			String md_gs_dflt_tooth_no_S1_disabled = "";
			String md_gs_dflt_tooth_no_S2_disabled = "";
			String md_gs_dflt_tooth_no_S3_disabled = "";
			String md_gs_dflt_tooth_no_S4_disabled = "";
			String md_gs_dflt_tooth_no_S5_disabled = "";
			String md_gs_dflt_tooth_no_S6_disabled = "";

		   //paramters forPermanent sextant
			String gs_no_of_tooth_for_S1_hidden = checkForNull(request.getParameter("gs_no_of_tooth_for_S1_hidden"));
			String gs_no_of_tooth_for_S2_hidden  = checkForNull(request.getParameter("gs_no_of_tooth_for_S2_hidden"));
			String gs_no_of_tooth_for_S3_hidden = checkForNull(request.getParameter("gs_no_of_tooth_for_S3_hidden"));
			String gs_no_of_tooth_for_S4_hidden  = checkForNull(request.getParameter("gs_no_of_tooth_for_S4_hidden"));
			String gs_no_of_tooth_for_S5_hidden   = checkForNull(request.getParameter("gs_no_of_tooth_for_S5_hidden"));
			String gs_no_of_tooth_for_S6_hidden   = checkForNull(request.getParameter("gs_no_of_tooth_for_S6_hidden"));
			String gs_dflt_tooth_no_S1_hidden   = checkForNull(request.getParameter("gs_dflt_tooth_no_S1_hidden"));
			String gs_dflt_tooth_no_S2_hidden   = checkForNull(request.getParameter("gs_dflt_tooth_no_S2_hidden"));
			String gs_dflt_tooth_no_S3_hidden   = checkForNull(request.getParameter("gs_dflt_tooth_no_S3_hidden"));
			String gs_dflt_tooth_no_S4_hidden   = checkForNull(request.getParameter("gs_dflt_tooth_no_S4_hidden"));
			String gs_dflt_tooth_no_S5_hidden   = checkForNull(request.getParameter("gs_dflt_tooth_no_S5_hidden"));
			String gs_dflt_tooth_no_S6_hidden   = checkForNull(request.getParameter("gs_dflt_tooth_no_S6_hidden"));

		   //paramters for Deciduous sextant
			String dec_gs_no_of_tooth_for_S1_hidden = checkForNull(request.getParameter("dec_gs_no_of_tooth_for_S1_hidden"));
			String dec_gs_no_of_tooth_for_S2_hidden = checkForNull(request.getParameter("dec_gs_no_of_tooth_for_S2_hidden"));
			String dec_gs_no_of_tooth_for_S3_hidden = checkForNull(request.getParameter("dec_gs_no_of_tooth_for_S3_hidden"));
			String dec_gs_no_of_tooth_for_S4_hidden = checkForNull(request.getParameter("dec_gs_no_of_tooth_for_S4_hidden"));
			String dec_gs_no_of_tooth_for_S5_hidden = checkForNull(request.getParameter("dec_gs_no_of_tooth_for_S5_hidden"));
			String dec_gs_no_of_tooth_for_S6_hidden = checkForNull(request.getParameter("dec_gs_no_of_tooth_for_S6_hidden"));
			String dec_gs_dflt_tooth_no_S1_hidden   = checkForNull(request.getParameter("dec_gs_dflt_tooth_no_S1_hidden"));
			String dec_gs_dflt_tooth_no_S2_hidden   = checkForNull(request.getParameter("dec_gs_dflt_tooth_no_S2_hidden"));
			String dec_gs_dflt_tooth_no_S3_hidden   = checkForNull(request.getParameter("dec_gs_dflt_tooth_no_S3_hidden"));
			String dec_gs_dflt_tooth_no_S4_hidden   = checkForNull(request.getParameter("dec_gs_dflt_tooth_no_S4_hidden"));
			String dec_gs_dflt_tooth_no_S5_hidden   = checkForNull(request.getParameter("dec_gs_dflt_tooth_no_S5_hidden"));
			String dec_gs_dflt_tooth_no_S6_hidden   = checkForNull(request.getParameter("dec_gs_dflt_tooth_no_S6_hidden"));

		   //paramters for Mixed Dentition sextant
			String md_gs_no_of_tooth_for_S1_hidden = checkForNull(request.getParameter("md_gs_no_of_tooth_for_S1_hidden"));
			String md_gs_no_of_tooth_for_S2_hidden = checkForNull(request.getParameter("md_gs_no_of_tooth_for_S2_hidden"));
			String md_gs_no_of_tooth_for_S3_hidden = checkForNull(request.getParameter("md_gs_no_of_tooth_for_S3_hidden"));
			String md_gs_no_of_tooth_for_S4_hidden = checkForNull(request.getParameter("md_gs_no_of_tooth_for_S4_hidden"));
			String md_gs_no_of_tooth_for_S5_hidden = checkForNull(request.getParameter("md_gs_no_of_tooth_for_S5_hidden"));
			String md_gs_no_of_tooth_for_S6_hidden = checkForNull(request.getParameter("md_gs_no_of_tooth_for_S6_hidden"));
			String md_gs_dflt_tooth_no_S1_hidden   = checkForNull(request.getParameter("md_gs_dflt_tooth_no_S1_hidden"));
			String md_gs_dflt_tooth_no_S2_hidden   = checkForNull(request.getParameter("md_gs_dflt_tooth_no_S2_hidden"));
			String md_gs_dflt_tooth_no_S3_hidden   = checkForNull(request.getParameter("md_gs_dflt_tooth_no_S3_hidden"));
			String md_gs_dflt_tooth_no_S4_hidden   = checkForNull(request.getParameter("md_gs_dflt_tooth_no_S4_hidden"));
			String md_gs_dflt_tooth_no_S5_hidden   = checkForNull(request.getParameter("md_gs_dflt_tooth_no_S5_hidden"));
			String md_gs_dflt_tooth_no_S6_hidden   = checkForNull(request.getParameter("md_gs_dflt_tooth_no_S6_hidden"));

		   //paramters for Permanent sextant
			String gs_no_of_tooth_for_S1 = "";
			String gs_no_of_tooth_for_S2= "";
			String gs_no_of_tooth_for_S3 = "";
			String gs_no_of_tooth_for_S4  ="";
			String gs_no_of_tooth_for_S5 = "";
			String gs_no_of_tooth_for_S6 = "";
			String gs_dflt_tooth_no_S1 ="";
			String gs_dflt_tooth_no_S2 ="";
			String gs_dflt_tooth_no_S3 = "";
			String gs_dflt_tooth_no_S4 = "";
			String gs_dflt_tooth_no_S5 = "";
			String gs_dflt_tooth_no_S6 = "";

			 //paramters for Deciduous sextant
			String dec_gs_no_of_tooth_for_S1 = "";
			String dec_gs_no_of_tooth_for_S2 = "";
			String dec_gs_no_of_tooth_for_S3 = "";
			String dec_gs_no_of_tooth_for_S4 = "";
			String dec_gs_no_of_tooth_for_S5 = "";
			String dec_gs_no_of_tooth_for_S6 = "";
		    String dec_gs_dflt_tooth_no_S1 ="";
		    String dec_gs_dflt_tooth_no_S2 ="";
		    String dec_gs_dflt_tooth_no_S3 ="";
		    String dec_gs_dflt_tooth_no_S4 ="";
		    String dec_gs_dflt_tooth_no_S5 ="";
		    String dec_gs_dflt_tooth_no_S6 ="";

		   //paramters for Mixed Dentition sextant
		   String md_gs_no_of_tooth_for_S1 = "";
		   String md_gs_no_of_tooth_for_S2 = "";
		   String md_gs_no_of_tooth_for_S3 = "";
		   String md_gs_no_of_tooth_for_S4 = "";
		   String md_gs_no_of_tooth_for_S5 = "";
		   String md_gs_no_of_tooth_for_S6 = "";
		   String md_gs_dflt_tooth_no_S1 ="";
		   String md_gs_dflt_tooth_no_S2 ="";
		   String md_gs_dflt_tooth_no_S3 ="";
		   String md_gs_dflt_tooth_no_S4 ="";
		   String md_gs_dflt_tooth_no_S5 ="";
		   String md_gs_dflt_tooth_no_S6 ="";

			String dflt_mixed_dentition_chart = "";
		
		    String sql="";
			String checked_yn = "";
			String chk_value = "";
			String tooth_selected="";
			//String interface_flag_checked="";
			//String interface_flag_value="";
			int total_records=0;
			HashMap map = new HashMap();
			HashMap map_dec = new HashMap();
			HashMap map_md = new HashMap();
			String map_val = "";
		//	String map_md = "";
			String map_val_dec = "";
			String map_val_md = "";
			String j="";
			String n="";
			String q="";
			String sextant_sno="";
			String tooth_segment="";
			String map_value="";
			//String map_value_dec="";
			String[] map_value_arr=null;
		//	String[] map_value_arr_dec=null;
 			try{
				con=ConnectionManager.getConnection(request);
                if(chart_level.equals("F")){
					sql="SELECT COUNT(*) AS TOTAL_RECORDS_EXISTING FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?";
					pstmt=con.prepareStatement(sql);
				    pstmt.setString(1,facility_id);
					//rs=pstmt.executeQuery();
				
				}else if (chart_level.equals("E")|| chart_level.equals("") || chart_level.equals("null") || chart_level.equals(null)){
					sql="SELECT COUNT(*) AS TOTAL_RECORDS_EXISTING FROM OH_PARAM";
					pstmt=con.prepareStatement(sql);
				}
				rs=pstmt.executeQuery();
				rs.next();
				
				total_records=Integer.parseInt(checkForNull(rs.getString(1),"0"));
				//total_records=Integer.parseInt(checkForNull(rs.getString(1)));
						
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
							gs_no_of_tooth_for_S1=checkForNull(rs.getString("gs_no_of_tooth_for_S1"));
							gs_no_of_tooth_for_S2=checkForNull(rs.getString("gs_no_of_tooth_for_S2"));
							gs_no_of_tooth_for_S3=checkForNull(rs.getString("gs_no_of_tooth_for_S3"));
							gs_no_of_tooth_for_S4=checkForNull(rs.getString("gs_no_of_tooth_for_S4"));
							gs_no_of_tooth_for_S5=checkForNull(rs.getString("gs_no_of_tooth_for_S5"));
							gs_no_of_tooth_for_S6=checkForNull(rs.getString("gs_no_of_tooth_for_S6"));
							gs_dflt_tooth_no_S1=checkForNull(rs.getString("gs_dflt_tooth_no_S1"));
							gs_dflt_tooth_no_S2=checkForNull(rs.getString("gs_dflt_tooth_no_S2"));
							gs_dflt_tooth_no_S3=checkForNull(rs.getString("gs_dflt_tooth_no_S3"));
							gs_dflt_tooth_no_S4=checkForNull(rs.getString("gs_dflt_tooth_no_S4"));
							gs_dflt_tooth_no_S5=checkForNull(rs.getString("gs_dflt_tooth_no_S5"));
							gs_dflt_tooth_no_S6=checkForNull(rs.getString("gs_dflt_tooth_no_S6"));

							dec_gs_no_of_tooth_for_S1=checkForNull(rs.getString("dec_gs_no_of_tooth_for_S1"));
							dec_gs_no_of_tooth_for_S2=checkForNull(rs.getString("dec_gs_no_of_tooth_for_S2"));
							dec_gs_no_of_tooth_for_S3=checkForNull(rs.getString("dec_gs_no_of_tooth_for_S3"));
							dec_gs_no_of_tooth_for_S4=checkForNull(rs.getString("dec_gs_no_of_tooth_for_S4"));
							dec_gs_no_of_tooth_for_S5=checkForNull(rs.getString("dec_gs_no_of_tooth_for_S5"));
							dec_gs_no_of_tooth_for_S6=checkForNull(rs.getString("dec_gs_no_of_tooth_for_S6"));
							dec_gs_dflt_tooth_no_S1=checkForNull(rs.getString("dec_gs_dflt_tooth_no_S1"));
							dec_gs_dflt_tooth_no_S2=checkForNull(rs.getString("dec_gs_dflt_tooth_no_S2"));
							dec_gs_dflt_tooth_no_S3=checkForNull(rs.getString("dec_gs_dflt_tooth_no_S3"));
							dec_gs_dflt_tooth_no_S4=checkForNull(rs.getString("dec_gs_dflt_tooth_no_S4"));
							dec_gs_dflt_tooth_no_S5=checkForNull(rs.getString("dec_gs_dflt_tooth_no_S5"));
							dec_gs_dflt_tooth_no_S6=checkForNull(rs.getString("dec_gs_dflt_tooth_no_S6"));

							md_gs_no_of_tooth_for_S1=checkForNull(rs.getString("md_gs_no_of_tooth_for_S1"));
							md_gs_no_of_tooth_for_S2=checkForNull(rs.getString("md_gs_no_of_tooth_for_S2"));
							md_gs_no_of_tooth_for_S3=checkForNull(rs.getString("md_gs_no_of_tooth_for_S3"));
							md_gs_no_of_tooth_for_S4=checkForNull(rs.getString("md_gs_no_of_tooth_for_S4"));
							md_gs_no_of_tooth_for_S5=checkForNull(rs.getString("md_gs_no_of_tooth_for_S5"));
							md_gs_no_of_tooth_for_S6=checkForNull(rs.getString("md_gs_no_of_tooth_for_S6"));
							md_gs_dflt_tooth_no_S1=checkForNull(rs.getString("md_gs_dflt_tooth_no_S1"));
							md_gs_dflt_tooth_no_S2=checkForNull(rs.getString("md_gs_dflt_tooth_no_S2"));
							md_gs_dflt_tooth_no_S3=checkForNull(rs.getString("md_gs_dflt_tooth_no_S3"));
							md_gs_dflt_tooth_no_S4=checkForNull(rs.getString("md_gs_dflt_tooth_no_S4"));
							md_gs_dflt_tooth_no_S5=checkForNull(rs.getString("md_gs_dflt_tooth_no_S5"));
							md_gs_dflt_tooth_no_S6=checkForNull(rs.getString("md_gs_dflt_tooth_no_S6"));

							record_gingival_status_yn=checkForNull(rs.getString("record_gingival_status_yn"));
							dflt_mixed_dentition_chart=checkForNull(rs.getString("dflt_mixed_dentition_chart"));
					  }
							if (!gs_dflt_tooth_no_S1.equals("")){
							   gs_dflt_tooth_no_S1_disabled="disabled";
							
							}
							 if(!gs_dflt_tooth_no_S2.equals("")){
								gs_dflt_tooth_no_S2_disabled="disabled";
							}	
							 if(!gs_dflt_tooth_no_S3.equals("")){
								gs_dflt_tooth_no_S3_disabled="disabled";
							}
							 if(!gs_dflt_tooth_no_S4.equals("")){
								gs_dflt_tooth_no_S4_disabled="disabled";
							}
							 if(!gs_dflt_tooth_no_S5.equals("")){
								gs_dflt_tooth_no_S5_disabled="disabled";
							}
							 if(!gs_dflt_tooth_no_S6.equals("")){
								gs_dflt_tooth_no_S6_disabled="disabled";
							}

							 if (!dec_gs_dflt_tooth_no_S1.equals("")){
								dec_gs_dflt_tooth_no_S1_disabled="disabled";
								
							}
							 if (!dec_gs_dflt_tooth_no_S2.equals("")){
								dec_gs_dflt_tooth_no_S2_disabled="disabled";
								
							}
							 if (!dec_gs_dflt_tooth_no_S3.equals("")){
								dec_gs_dflt_tooth_no_S3_disabled="disabled";
								
							}
							 if (!dec_gs_dflt_tooth_no_S4.equals("")){
								dec_gs_dflt_tooth_no_S4_disabled="disabled";
								
							}
							 if (!dec_gs_dflt_tooth_no_S5.equals("")){
								dec_gs_dflt_tooth_no_S5_disabled="disabled";
								
							}
							 if (!dec_gs_dflt_tooth_no_S6.equals("")){
								dec_gs_dflt_tooth_no_S6_disabled="disabled";
								
							}

							 if (!md_gs_dflt_tooth_no_S1.equals("")){
								md_gs_dflt_tooth_no_S1_disabled="disabled";
								
							}
							
							 if (!md_gs_dflt_tooth_no_S2.equals("")){
								md_gs_dflt_tooth_no_S2_disabled="disabled";
								
							}
							
							 if (!md_gs_dflt_tooth_no_S3.equals("")){
								md_gs_dflt_tooth_no_S3_disabled="disabled";
								
							}
							
							 if (!md_gs_dflt_tooth_no_S4.equals("")){
								md_gs_dflt_tooth_no_S4_disabled="disabled";
								
							}
							
							 if (!md_gs_dflt_tooth_no_S5.equals("")){
								md_gs_dflt_tooth_no_S5_disabled="disabled";
								
							}
							
							 if (!md_gs_dflt_tooth_no_S6.equals("")){
								md_gs_dflt_tooth_no_S6_disabled="disabled";
								
							}
				}else if (chart_level.equals("E") || (chart_level.equals("") || chart_level.equals("null") || chart_level.equals(null))){
				        sql="SELECT * FROM OH_PARAM";
						pstmt=con.prepareStatement(sql);
						//pstmt.setString(1,facility_id);
						rs=pstmt.executeQuery();
						while(rs!=null && rs.next()){
							tooth_numbering_system=checkForNull(rs.getString("tooth_numbering_system"));
							gs_no_of_tooth_for_S1=checkForNull(rs.getString("gs_no_of_tooth_for_S1"));
							gs_no_of_tooth_for_S2=checkForNull(rs.getString("gs_no_of_tooth_for_S2"));
							gs_no_of_tooth_for_S3=checkForNull(rs.getString("gs_no_of_tooth_for_S3"));
							gs_no_of_tooth_for_S4=checkForNull(rs.getString("gs_no_of_tooth_for_S4"));
							gs_no_of_tooth_for_S5=checkForNull(rs.getString("gs_no_of_tooth_for_S5"));
							gs_no_of_tooth_for_S6=checkForNull(rs.getString("gs_no_of_tooth_for_S6"));
							gs_dflt_tooth_no_S1=checkForNull(rs.getString("gs_dflt_tooth_no_S1"));
							gs_dflt_tooth_no_S2=checkForNull(rs.getString("gs_dflt_tooth_no_S2"));
							gs_dflt_tooth_no_S3=checkForNull(rs.getString("gs_dflt_tooth_no_S3"));
							gs_dflt_tooth_no_S4=checkForNull(rs.getString("gs_dflt_tooth_no_S4"));
							gs_dflt_tooth_no_S5=checkForNull(rs.getString("gs_dflt_tooth_no_S5"));
							gs_dflt_tooth_no_S6=checkForNull(rs.getString("gs_dflt_tooth_no_S6"));

							dec_gs_no_of_tooth_for_S1=checkForNull(rs.getString("dec_gs_no_of_tooth_for_S1"));
							dec_gs_no_of_tooth_for_S2=checkForNull(rs.getString("dec_gs_no_of_tooth_for_S2"));
							dec_gs_no_of_tooth_for_S3=checkForNull(rs.getString("dec_gs_no_of_tooth_for_S3"));
							dec_gs_no_of_tooth_for_S4=checkForNull(rs.getString("dec_gs_no_of_tooth_for_S4"));
							dec_gs_no_of_tooth_for_S5=checkForNull(rs.getString("dec_gs_no_of_tooth_for_S5"));
							dec_gs_no_of_tooth_for_S6=checkForNull(rs.getString("dec_gs_no_of_tooth_for_S6"));
							dec_gs_dflt_tooth_no_S1=checkForNull(rs.getString("dec_gs_dflt_tooth_no_S1"));
							dec_gs_dflt_tooth_no_S2=checkForNull(rs.getString("dec_gs_dflt_tooth_no_S2"));
							dec_gs_dflt_tooth_no_S3=checkForNull(rs.getString("dec_gs_dflt_tooth_no_S3"));
							dec_gs_dflt_tooth_no_S4=checkForNull(rs.getString("dec_gs_dflt_tooth_no_S4"));
							dec_gs_dflt_tooth_no_S5=checkForNull(rs.getString("dec_gs_dflt_tooth_no_S5"));
							dec_gs_dflt_tooth_no_S6=checkForNull(rs.getString("dec_gs_dflt_tooth_no_S6"));

							md_gs_no_of_tooth_for_S1=checkForNull(rs.getString("md_gs_no_of_tooth_for_S1"));
							md_gs_no_of_tooth_for_S2=checkForNull(rs.getString("md_gs_no_of_tooth_for_S2"));
							md_gs_no_of_tooth_for_S3=checkForNull(rs.getString("md_gs_no_of_tooth_for_S3"));
							md_gs_no_of_tooth_for_S4=checkForNull(rs.getString("md_gs_no_of_tooth_for_S4"));
							md_gs_no_of_tooth_for_S5=checkForNull(rs.getString("md_gs_no_of_tooth_for_S5"));
							md_gs_no_of_tooth_for_S6=checkForNull(rs.getString("md_gs_no_of_tooth_for_S6"));
							md_gs_dflt_tooth_no_S1=checkForNull(rs.getString("md_gs_dflt_tooth_no_S1"));
							md_gs_dflt_tooth_no_S2=checkForNull(rs.getString("md_gs_dflt_tooth_no_S2"));
							md_gs_dflt_tooth_no_S3=checkForNull(rs.getString("md_gs_dflt_tooth_no_S3"));
							md_gs_dflt_tooth_no_S4=checkForNull(rs.getString("md_gs_dflt_tooth_no_S4"));
							md_gs_dflt_tooth_no_S5=checkForNull(rs.getString("md_gs_dflt_tooth_no_S5"));
							md_gs_dflt_tooth_no_S6=checkForNull(rs.getString("md_gs_dflt_tooth_no_S6"));

							record_gingival_status_yn=checkForNull(rs.getString("record_gingival_status_yn"));
							dflt_mixed_dentition_chart=checkForNull(rs.getString("dflt_mixed_dentition_chart"));
						}
						 if (!gs_dflt_tooth_no_S1.equals("")){
							gs_dflt_tooth_no_S1_disabled="disabled";
							
						}
						 if(!gs_dflt_tooth_no_S2.equals("")){
							gs_dflt_tooth_no_S2_disabled="disabled";
						}	
						 if(!gs_dflt_tooth_no_S3.equals("")){
							gs_dflt_tooth_no_S3_disabled="disabled";
						}
						 if(!gs_dflt_tooth_no_S4.equals("")){
							gs_dflt_tooth_no_S4_disabled="disabled";
						}
						 if(!gs_dflt_tooth_no_S5.equals("")){
							gs_dflt_tooth_no_S5_disabled="disabled";
						}
						 if(!gs_dflt_tooth_no_S6.equals("")){
							gs_dflt_tooth_no_S6_disabled="disabled";
						}

						 if (!dec_gs_dflt_tooth_no_S1.equals("")){
							dec_gs_dflt_tooth_no_S1_disabled="disabled";
							
						}
						 if (!dec_gs_dflt_tooth_no_S2.equals("")){
							dec_gs_dflt_tooth_no_S2_disabled="disabled";
							
						}
						 if (!dec_gs_dflt_tooth_no_S3.equals("")){
							dec_gs_dflt_tooth_no_S3_disabled="disabled";
							
						}
						 if (!dec_gs_dflt_tooth_no_S4.equals("")){
							dec_gs_dflt_tooth_no_S4_disabled="disabled";
							
						}
						 if (!dec_gs_dflt_tooth_no_S5.equals("")){
							dec_gs_dflt_tooth_no_S5_disabled="disabled";
							
						}
						 if (!dec_gs_dflt_tooth_no_S6.equals("")){
							dec_gs_dflt_tooth_no_S6_disabled="disabled";
							
						}

						 if (!md_gs_dflt_tooth_no_S1.equals("")){
							md_gs_dflt_tooth_no_S1_disabled="disabled";
							
						}
						
						 if (!md_gs_dflt_tooth_no_S2.equals("")){
							md_gs_dflt_tooth_no_S2_disabled="disabled";
							
						}
						
						 if (!md_gs_dflt_tooth_no_S3.equals("")){
							md_gs_dflt_tooth_no_S3_disabled="disabled";
							
						}
						
						 if (!md_gs_dflt_tooth_no_S4.equals("")){
							md_gs_dflt_tooth_no_S4_disabled="disabled";
							
						}
						
						 if (!md_gs_dflt_tooth_no_S5.equals("")){
							md_gs_dflt_tooth_no_S5_disabled="disabled";
							
						}
						
						 if (!md_gs_dflt_tooth_no_S6.equals("")){
							md_gs_dflt_tooth_no_S6_disabled="disabled";
							
						}
				}

				if(callFrom.equals("T")){
					gs_no_of_tooth_for_S1="";
					gs_no_of_tooth_for_S2="";
					gs_no_of_tooth_for_S3="";
					gs_no_of_tooth_for_S4="";
					gs_no_of_tooth_for_S5="";
					gs_no_of_tooth_for_S6="";
					gs_dflt_tooth_no_S1="";
					gs_dflt_tooth_no_S2="";
					gs_dflt_tooth_no_S3="";
					gs_dflt_tooth_no_S4="";
					gs_dflt_tooth_no_S5="";
					gs_dflt_tooth_no_S6="";

					dec_gs_no_of_tooth_for_S1="";
					dec_gs_no_of_tooth_for_S2="";
					dec_gs_no_of_tooth_for_S3="";
					dec_gs_no_of_tooth_for_S4="";
					dec_gs_no_of_tooth_for_S5="";
					dec_gs_no_of_tooth_for_S6="";
					dec_gs_dflt_tooth_no_S1="";
					dec_gs_dflt_tooth_no_S2="";
					dec_gs_dflt_tooth_no_S3="";
					dec_gs_dflt_tooth_no_S4="";
					dec_gs_dflt_tooth_no_S5="";
					dec_gs_dflt_tooth_no_S6="";

					md_gs_no_of_tooth_for_S1="";
					md_gs_no_of_tooth_for_S2="";
					md_gs_no_of_tooth_for_S3="";
					md_gs_no_of_tooth_for_S4="";
					md_gs_no_of_tooth_for_S5="";
					md_gs_no_of_tooth_for_S6="";
					md_gs_dflt_tooth_no_S1="";
					md_gs_dflt_tooth_no_S2="";
					md_gs_dflt_tooth_no_S3="";
					md_gs_dflt_tooth_no_S4="";
					md_gs_dflt_tooth_no_S5="";
					md_gs_dflt_tooth_no_S6="";				
				}
           
				if(record_gingival_status_yn.equals("Y")){
					checked_yn = "checked";
					chk_value = "Y";
				}
				else{
					checked_yn = "";
					chk_value = "N";
				}
              /*  if (!gs_dflt_tooth_no_S1.equals("")){
				    gs_dflt_tooth_no_S1_disabled="disabled";
					
				}
				 if(!gs_dflt_tooth_no_S2.equals("")){
					gs_dflt_tooth_no_S2_disabled="disabled";
				}	
				 if(!gs_dflt_tooth_no_S3.equals("")){
					gs_dflt_tooth_no_S3_disabled="disabled";
				}
				 if(!gs_dflt_tooth_no_S4.equals("")){
					gs_dflt_tooth_no_S4_disabled="disabled";
				}
				 if(!gs_dflt_tooth_no_S5.equals("")){
					gs_dflt_tooth_no_S5_disabled="disabled";
				}
				 if(!gs_dflt_tooth_no_S6.equals("")){
					gs_dflt_tooth_no_S6_disabled="disabled";
				}

				 if (!dec_gs_dflt_tooth_no_S1.equals("")){
				    dec_gs_dflt_tooth_no_S1_disabled="disabled";
					
				}
				 if (!dec_gs_dflt_tooth_no_S2.equals("")){
				    dec_gs_dflt_tooth_no_S2_disabled="disabled";
					
				}
				 if (!dec_gs_dflt_tooth_no_S3.equals("")){
				    dec_gs_dflt_tooth_no_S3_disabled="disabled";
					
				}
				 if (!dec_gs_dflt_tooth_no_S4.equals("")){
				    dec_gs_dflt_tooth_no_S4_disabled="disabled";
					
				}
				 if (!dec_gs_dflt_tooth_no_S5.equals("")){
				    dec_gs_dflt_tooth_no_S5_disabled="disabled";
					
				}
				 if (!dec_gs_dflt_tooth_no_S6.equals("")){
				    dec_gs_dflt_tooth_no_S6_disabled="disabled";
					
				}

				 if (!md_gs_dflt_tooth_no_S1.equals("")){
				    md_gs_dflt_tooth_no_S1_disabled="disabled";
					
				}
				
				 if (!md_gs_dflt_tooth_no_S2.equals("")){
				    md_gs_dflt_tooth_no_S2_disabled="disabled";
					
				}
				
				 if (!md_gs_dflt_tooth_no_S3.equals("")){
				    md_gs_dflt_tooth_no_S3_disabled="disabled";
					
				}
				
				 if (!md_gs_dflt_tooth_no_S4.equals("")){
				    md_gs_dflt_tooth_no_S4_disabled="disabled";
					
				}
				
				 if (!md_gs_dflt_tooth_no_S5.equals("")){
				    md_gs_dflt_tooth_no_S5_disabled="disabled";
					
				}
				
				 if (!md_gs_dflt_tooth_no_S6.equals("")){
				    md_gs_dflt_tooth_no_S6_disabled="disabled";
					
				}*/
            }
			if(callFrom.equals("S")){
					gs_no_of_tooth_for_S1=gs_no_of_tooth_for_S1_hidden;
					gs_no_of_tooth_for_S2=gs_no_of_tooth_for_S2_hidden;
					gs_no_of_tooth_for_S3=gs_no_of_tooth_for_S3_hidden;
					gs_no_of_tooth_for_S4=gs_no_of_tooth_for_S4_hidden;
					gs_no_of_tooth_for_S5=gs_no_of_tooth_for_S5_hidden;
					gs_no_of_tooth_for_S6=gs_no_of_tooth_for_S6_hidden;
					gs_dflt_tooth_no_S1=gs_dflt_tooth_no_S1_hidden;
					gs_dflt_tooth_no_S2=gs_dflt_tooth_no_S2_hidden;
					gs_dflt_tooth_no_S3=gs_dflt_tooth_no_S3_hidden;
					gs_dflt_tooth_no_S4=gs_dflt_tooth_no_S4_hidden;
					gs_dflt_tooth_no_S5=gs_dflt_tooth_no_S5_hidden;
					gs_dflt_tooth_no_S6=gs_dflt_tooth_no_S6_hidden;

					dec_gs_no_of_tooth_for_S1=dec_gs_no_of_tooth_for_S1_hidden;
					dec_gs_no_of_tooth_for_S2=dec_gs_no_of_tooth_for_S2_hidden;
					dec_gs_no_of_tooth_for_S3=dec_gs_no_of_tooth_for_S3_hidden;
					dec_gs_no_of_tooth_for_S4=dec_gs_no_of_tooth_for_S4_hidden;
					dec_gs_no_of_tooth_for_S5=dec_gs_no_of_tooth_for_S5_hidden;
					dec_gs_no_of_tooth_for_S6=dec_gs_no_of_tooth_for_S6_hidden;
					dec_gs_dflt_tooth_no_S1=dec_gs_dflt_tooth_no_S1_hidden;
					dec_gs_dflt_tooth_no_S2=dec_gs_dflt_tooth_no_S2_hidden;
					dec_gs_dflt_tooth_no_S3=dec_gs_dflt_tooth_no_S3_hidden;
					dec_gs_dflt_tooth_no_S4=dec_gs_dflt_tooth_no_S4_hidden;
					dec_gs_dflt_tooth_no_S5=dec_gs_dflt_tooth_no_S5_hidden;
					dec_gs_dflt_tooth_no_S6=dec_gs_dflt_tooth_no_S6_hidden;

					md_gs_no_of_tooth_for_S1=md_gs_no_of_tooth_for_S1_hidden;
					md_gs_no_of_tooth_for_S2=md_gs_no_of_tooth_for_S2_hidden;
					md_gs_no_of_tooth_for_S3=md_gs_no_of_tooth_for_S3_hidden;
					md_gs_no_of_tooth_for_S4=md_gs_no_of_tooth_for_S4_hidden;
					md_gs_no_of_tooth_for_S5=md_gs_no_of_tooth_for_S5_hidden;
					md_gs_no_of_tooth_for_S6=md_gs_no_of_tooth_for_S6_hidden;
					md_gs_dflt_tooth_no_S1=md_gs_dflt_tooth_no_S1_hidden;
					md_gs_dflt_tooth_no_S2=md_gs_dflt_tooth_no_S2_hidden;
					md_gs_dflt_tooth_no_S3=md_gs_dflt_tooth_no_S3_hidden;
					md_gs_dflt_tooth_no_S4=md_gs_dflt_tooth_no_S4_hidden;
					md_gs_dflt_tooth_no_S5=md_gs_dflt_tooth_no_S5_hidden;
					md_gs_dflt_tooth_no_S6=md_gs_dflt_tooth_no_S6_hidden;

				
				}

			String tooth_no = "";
			String tooth_num = "";
			
            //sql="SELECT TOOTH_NO, DECODE(?,'UNI', UNIVERSAL_TOOTH_NO,'FDI',FDI_TOOTH_NO,'') TOOTH_NUM FROM OH_TOOTH where PERMANENT_DECIDUOUS = 'P' ORDER BY TOOTH_NO ASC";
			//sql="SELECT A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
			sql="SELECT A.SEXTANT_SNO,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
				
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,tooth_numbering_system);
			
			rs=pstmt.executeQuery();
			
			while(rs!=null && rs.next()){
               sextant_sno=checkForNull(rs.getString("SEXTANT_SNO"));
				tooth_no=checkForNull(rs.getString("TOOTH_NO"));
				tooth_num=checkForNull(rs.getString("TOOTH_NUM"));
				if(tooth_num.equals("")){
					map = new HashMap();
				}
				else{
					tooth_segment=tooth_num+"#"+sextant_sno;
					map.put(tooth_no,tooth_segment);
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
	<div id='ohsextant'>
    		  <table border=0 cellspacing=0 cellpadding=1 width='100%' align=center >
			  <tr>
               <td width="10%">
					<table  border=0 cellspacing=0 cellpadding=8 width='100%' align='center' >
						<tr align='center'><th ></th></tr>
						<tr align='center'><th align=center ><fmt:message key="eOH.Sextant.Label" bundle="${oh_labels}"/></th></tr>   
						<tr align='center'><th  align=center></th></tr> 
                        <tr><td width="10%" class="LABEL"><fmt:message key="eOH.UpperRight.Label" bundle="${oh_labels}"/></td></tr>
						<tr><td width="10%" class="LABEL"><fmt:message key="eOH.UpperAnterior.Label" bundle="${oh_labels}"/></td></tr>
						<tr><td width="10%" class="LABEL"><fmt:message key="eOH.UpperLeft.Label" bundle="${oh_labels}"/></td></tr>
						<tr><td width="10%" class="LABEL"><fmt:message key="eOH.LowerLeft.Label" bundle="${oh_labels}"/></td></tr>
						<tr><td width="10%" class="LABEL"><fmt:message key="eOH.LowerAnterior.Label" bundle="${oh_labels}"/></td></tr>
						<tr><td width="10%" class="LABEL"><fmt:message key="eOH.LowerRight.Label" bundle="${oh_labels}"/></td></tr> 
					</table>
					</td>
			  <td width="25%">
					<table  border=0 cellspacing=1 cellpadding=3 width='100%' align=center >
						<tr align=center colspan=2>
							<th align=center colspan=3><fmt:message key="eOH.Decedious.Label" bundle="${oh_labels}"/></th>
						</tr>
						<tr>
							<th ><fmt:message key="eOH.MaxNumOfTooth.Label" bundle="${oh_labels}"/></th>
							<th colspan=2><fmt:message key="eOH.DefaultToothNo.Label" bundle="${oh_labels}"/></th>
						</tr>
						<tr>
							<td width="25%" align="center" id="dec_gs_for_Q1" ><input type="text" name="dec_gs_no_of_tooth_for_S1" id="dec_gs_no_of_tooth_for_S1" value="<%=dec_gs_no_of_tooth_for_S1%>" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)" DB_VALUE="<%=dec_gs_no_of_tooth_for_S1%>">
							<%
									if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="100%" id="dec_gs_dflt_for_S1">
								<select name="dec_gs_dflt_tooth_no_S1" id="dec_gs_dflt_tooth_no_S1" DB_VALUE="<%=dec_gs_dflt_tooth_no_S1%>" <%=dec_gs_dflt_tooth_no_S1_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										for(int m=33;m<=34;m++){
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
							<td width="25%" align="center" id="dec_gs_for_Q2"><input type="text" name="dec_gs_no_of_tooth_for_S2" id="dec_gs_no_of_tooth_for_S2" value="<%=dec_gs_no_of_tooth_for_S2%>" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)" DB_VALUE="<%=dec_gs_no_of_tooth_for_S2%>">
							<%
									if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="100%" id="dec_gs_dflt_for_S2">
								<select name="dec_gs_dflt_tooth_no_S2" id="dec_gs_dflt_tooth_no_S2" DB_VALUE="<%=dec_gs_dflt_tooth_no_S2%>" <%=dec_gs_dflt_tooth_no_S2_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										for(int m=35;m<=40;m++){
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
							<td width="25%" align="center" id="dec_gs_for_Q3" ><input type="text" name="dec_gs_no_of_tooth_for_S3" id="dec_gs_no_of_tooth_for_S3" value="<%=dec_gs_no_of_tooth_for_S3%>" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)" DB_VALUE="<%=dec_gs_no_of_tooth_for_S3%>">
							<%
								if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
							}
							%>
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="100%" id="dec_gs_dflt_for_S3">
								<select name="dec_gs_dflt_tooth_no_S3" id="dec_gs_dflt_tooth_no_S3" DB_VALUE="<%=dec_gs_dflt_tooth_no_S3%>" <%=dec_gs_dflt_tooth_no_S3_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										for(int m=41;m<=42;m++){
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
							<td width="25%" align="center" id="dec_gs_for_Q4"><input type="text" name="dec_gs_no_of_tooth_for_S4" id="dec_gs_no_of_tooth_for_S4" value="<%=dec_gs_no_of_tooth_for_S4%>" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)" DB_VALUE="<%=dec_gs_no_of_tooth_for_S4%>">
							<%
								if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="100%" id="dec_gs_dflt_for_S4">
								<select name="dec_gs_dflt_tooth_no_S4" id="dec_gs_dflt_tooth_no_S4" DB_VALUE="<%=dec_gs_dflt_tooth_no_S4%>" <%=dec_gs_dflt_tooth_no_S4_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										for(int m=43;m<=44;m++){
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
							<td width="25%" align="center" id="dec_gs_for_Q5" ><input type="text" name="dec_gs_no_of_tooth_for_S5" id="dec_gs_no_of_tooth_for_S5" value="<%=dec_gs_no_of_tooth_for_S5%>" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)" DB_VALUE="<%=dec_gs_no_of_tooth_for_S5%>">
							<%
								if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="100%" id="dec_gs_dflt_for_S5">
								<select name="dec_gs_dflt_tooth_no_S5" id="dec_gs_dflt_tooth_no_S5" DB_VALUE="<%=dec_gs_dflt_tooth_no_S5%>" <%=dec_gs_dflt_tooth_no_S5_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										for(int m=45;m<=50;m++){
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
						    <td width="25%" align="center" id="dec_gs_for_Q6" ><input type="text" name="dec_gs_no_of_tooth_for_S6" id="dec_gs_no_of_tooth_for_S6" value="<%=dec_gs_no_of_tooth_for_S6%>" size="1" maxlength="1" onBlur="validateDecNumOfTooth(this)" DB_VALUE="<%=dec_gs_no_of_tooth_for_S6%>">
							<%
								if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="100%" id="dec_gs_dflt_for_S6">
								<select name="dec_gs_dflt_tooth_no_S6" id="dec_gs_dflt_tooth_no_S6" DB_VALUE="<%=dec_gs_dflt_tooth_no_S6%>" <%=dec_gs_dflt_tooth_no_S6_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										for(int m=51;m<=52;m++){
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
					</table>
					</td>
					<td width="25%">
						<table  border=0 cellspacing=1 cellpadding=3 width='100%' align=center >
						<tr align=center colspan=2>
							<% 
								if(from_mixed_dentition.equals("D") || dflt_mixed_dentition_chart.equals("D") || dflt_mixed_dentition_chart_hid.equals("D")){
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
							<td width="25%" align="center" id="md_gs_for_Q1" ><input type="text" name="md_gs_no_of_tooth_for_S1" id="md_gs_no_of_tooth_for_S1" value="<%=md_gs_no_of_tooth_for_S1%>" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)" DB_VALUE="<%=md_gs_no_of_tooth_for_S1%>">
							<%
								if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="100%" id="md_gs_dflt_for_S1">
								<select name="md_gs_dflt_tooth_no_S1" id="md_gs_dflt_tooth_no_S1" DB_VALUE="<%=md_gs_dflt_tooth_no_S1%>" <%=md_gs_dflt_tooth_no_S1_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										//sql="SELECT A.SEGMENT_NO ,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
								if(from_mixed_dentition.equals("P")){
										for(int i=2;i<=5;i++){
											j=""+i;
											if(map.isEmpty() == false){
												map_value = map.get(j).toString();
												map_value_arr=map_value.split("#");
												if(map_value_arr[1].equals("1")){
													map_val = map_value_arr[0];
													out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
												}
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
									for(int s=33;s<=34;s++){
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
							<td width="25%" align="center" id="md_gs_for_Q2"><input type="text" name="md_gs_no_of_tooth_for_S2" id="md_gs_no_of_tooth_for_S2" value="<%=md_gs_no_of_tooth_for_S2%>" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)" DB_VALUE="<%=md_gs_no_of_tooth_for_S2%>">
							<%
								if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="100%" id="md_gs_dflt_for_S2">
								<select name="md_gs_dflt_tooth_no_S2" id="md_gs_dflt_tooth_no_S2" DB_VALUE="<%=md_gs_dflt_tooth_no_S2%>" <%=md_gs_dflt_tooth_no_S2_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										//sql="SELECT A.SEGMENT_NO ,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
									if(from_mixed_dentition.equals("P")){
											for(int i=6;i<=11;i++){
												j=""+i;
												if(map.isEmpty() == false){
													map_value = map.get(j).toString();
													map_value_arr=map_value.split("#");
													if(map_value_arr[1].equals("2")){
														map_val = map_value_arr[0];
														out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
													}
												}
											}
									}else if(from_mixed_dentition.equals("D")){
									for(int s=35;s<=40;s++){
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
							<td width="25%" align="center" id="md_gs_for_Q3" ><input type="text" name="md_gs_no_of_tooth_for_S3" id="md_gs_no_of_tooth_for_S3" value="<%=md_gs_no_of_tooth_for_S3%>" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)" DB_VALUE="<%=md_gs_no_of_tooth_for_S3%>">
							<%
									if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="100%" id="md_gs_dflt_for_S3">
								<select name="md_gs_dflt_tooth_no_S3" id="md_gs_dflt_tooth_no_S3" DB_VALUE="<%=md_gs_dflt_tooth_no_S3%>" <%=md_gs_dflt_tooth_no_S3_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										//sql="SELECT A.SEGMENT_NO ,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
									if(from_mixed_dentition.equals("P")){
										for(int i=12;i<=15;i++){
											j=""+i;
											if(map.isEmpty() == false){
												map_value = map.get(j).toString();
												map_value_arr=map_value.split("#");
												if(map_value_arr[1].equals("3")){
													map_val = map_value_arr[0];
													out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
												}
											}
										}
									}else if(from_mixed_dentition.equals("D")){
									for(int s=41;s<=42;s++){
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
									if(record_gingival_status.equals("Y")){
								%>
										<!-- <img src='../../eCommon/images/mandatory.gif'></img> -->
								<%
									}
								%>
							</td>
						</tr>

						<tr>
							<td width="25%" align="center" id="md_gs_for_Q4"><input type="text" name="md_gs_no_of_tooth_for_S4" id="md_gs_no_of_tooth_for_S4" value="<%=md_gs_no_of_tooth_for_S4%>" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)" DB_VALUE="<%=md_gs_no_of_tooth_for_S4%>">
							<%
								if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="100%" id="md_gs_dflt_for_S4">
								<select name="md_gs_dflt_tooth_no_S4" id="md_gs_dflt_tooth_no_S4" DB_VALUE="<%=md_gs_dflt_tooth_no_S4%>" <%=md_gs_dflt_tooth_no_S4_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										//sql="SELECT A.SEGMENT_NO ,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
									if(from_mixed_dentition.equals("P")){
										for(int i=18;i<=21;i++){
											j=""+i;
											if(map.isEmpty() == false){
												map_value = map.get(j).toString();
												map_value_arr=map_value.split("#");
												if(map_value_arr[1].equals("4")){
													map_val = map_value_arr[0];
													out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
												}
											}
										}
									}
									else if(from_mixed_dentition.equals("D")){
										for(int s=18;s<=19;s++){
												q=""+s;
												if(map_md.isEmpty() == false){
													map_val_md= map_md.get(q).toString();
													out.println("<option value='"+s+"' "+tooth_selected+">"+map_val_md+"</option>");
												}							
										}
										for(int s=43;s<=44;s++){
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
							<td width="25%" align="center" id="md_gs_for_Q5" ><input type="text" name="md_gs_no_of_tooth_for_S5" id="md_gs_no_of_tooth_for_S5" value="<%=md_gs_no_of_tooth_for_S5%>" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)" DB_VALUE="<%=md_gs_no_of_tooth_for_S5%>">
							<%
								if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="100%" id="md_gs_dflt_for_S5">
								<select name="md_gs_dflt_tooth_no_S5" id="md_gs_dflt_tooth_no_S5" DB_VALUE="<%=md_gs_dflt_tooth_no_S5%>" <%=md_gs_dflt_tooth_no_S5_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										//sql="SELECT A.SEGMENT_NO ,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
									if(from_mixed_dentition.equals("P")){
										for(int i=22;i<=27;i++){
											j=""+i;
											if(map.isEmpty() == false){
												map_value = map.get(j).toString();
												map_value_arr=map_value.split("#");
												if(map_value_arr[1].equals("5")){
													map_val = map_value_arr[0];
													out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
												}
											}
										}
									}else if(from_mixed_dentition.equals("D")){
										for(int s=45;s<=50;s++){
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
									//if(record_gingival_status.equals("Y")){
								%>
										<!-- <img src='../../eCommon/images/mandatory.gif'></img> -->
								<%
								//	}
								%>

							</td>
						</tr>
						<tr>
							<td width="25%" align="center" id="md_gs_for_Q6" ><input type="text" name="md_gs_no_of_tooth_for_S6" id="md_gs_no_of_tooth_for_S6" value="<%=md_gs_no_of_tooth_for_S6%>" size="1" maxlength="1" onBlur="validateMDNumOfTooth(this)" DB_VALUE="<%=md_gs_no_of_tooth_for_S6%>">
							<%
								if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="100%" id="md_gs_dflt_for_S6">
								<select name="md_gs_dflt_tooth_no_S6" id="md_gs_dflt_tooth_no_S6" DB_VALUE="<%=md_gs_dflt_tooth_no_S6%>" <%=md_gs_dflt_tooth_no_S6_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										//sql="SELECT A.SEGMENT_NO ,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
										if(from_mixed_dentition.equals("P")){
											for(int i=28;i<=31;i++){
												j=""+i;
												if(map.isEmpty() == false){
													map_value = map.get(j).toString();
													map_value_arr=map_value.split("#");
													if(map_value_arr[1].equals("6")){
														map_val = map_value_arr[0];
														out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
													}
												}
											}
										}else if(from_mixed_dentition.equals("D")){
											for(int s=51;s<=52;s++){
													q=""+s;
													if(map_md.isEmpty() == false){
														map_val_md= map_md.get(q).toString();
														out.println("<option value='"+s+"' "+tooth_selected+">"+map_val_md+"</option>");
													}							
											}
											for(int s=30;s<=31;s++){
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
					<table  border=0 cellspacing=1 cellpadding=3 width='100%' align=center >
						<tr align=center colspan=2>
							<th align=center colspan=3><fmt:message key="Common.Permanent.label" bundle="${common_labels}"/></th>
						</tr>
						<tr>
							<th><fmt:message key="eOH.MaxNumOfTooth.Label" bundle="${oh_labels}"/></th>
							<th colspan=2><fmt:message key="eOH.DefaultToothNo.Label" bundle="${oh_labels}"/></th>
								
						</tr>
						<tr>
							<td width="25%" align="center" id="gs_for_Q1" ><input type="text" name="gs_no_of_tooth_for_S1" id="gs_no_of_tooth_for_S1" value="<%=gs_no_of_tooth_for_S1%>" size="1" maxlength="1" onBlur="validateNumOfTooth(this)" DB_VALUE="<%=gs_no_of_tooth_for_S1%>">
							<%
								if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="100%" id="gs_dflt_for_S1">
								<select name="gs_dflt_tooth_no_S1" id="gs_dflt_tooth_no_S1" DB_VALUE="<%=gs_dflt_tooth_no_S1%>" <%=gs_dflt_tooth_no_S1_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										//sql="SELECT A.SEGMENT_NO ,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
										for(int i=1;i<=32;i++){
											j=""+i;
											if(map.isEmpty() == false){
												map_value = map.get(j).toString();
												map_value_arr=map_value.split("#");
												if(map_value_arr[1].equals("1")){
													map_val = map_value_arr[0];
													out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
												}
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
							<td width="25%" align="center" id="gs_for_Q2"><input type="text" name="gs_no_of_tooth_for_S2" id="gs_no_of_tooth_for_S2" value="<%=gs_no_of_tooth_for_S2%>" size="1" maxlength="1" onBlur="validateNumOfTooth(this)" DB_VALUE="<%=gs_no_of_tooth_for_S2%>">
							<%
								if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="100%" id="gs_dflt_for_S2">
								<select name="gs_dflt_tooth_no_S2" id="gs_dflt_tooth_no_S2" DB_VALUE="<%=gs_dflt_tooth_no_S2%>" <%=gs_dflt_tooth_no_S2_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										//sql="SELECT A.SEGMENT_NO ,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
										for(int i=1;i<=32;i++){
											j=""+i;
											if(map.isEmpty() == false){
												map_value = map.get(j).toString();
												map_value_arr=map_value.split("#");
												if(map_value_arr[1].equals("2")){
													map_val = map_value_arr[0];
													out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
												}
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
						
							<td width="25%" align="center" id="gs_for_Q3" ><input type="text" name="gs_no_of_tooth_for_S3" id="gs_no_of_tooth_for_S3" value="<%=gs_no_of_tooth_for_S3%>" size="1" maxlength="1" onBlur="validateNumOfTooth(this)" DB_VALUE="<%=gs_no_of_tooth_for_S3%>">
							<%
								if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="100%" id="gs_dflt_for_S3">
								<select name="gs_dflt_tooth_no_S3" id="gs_dflt_tooth_no_S3" DB_VALUE="<%=gs_dflt_tooth_no_S3%>" <%=gs_dflt_tooth_no_S3_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										//sql="SELECT A.SEGMENT_NO ,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
										for(int i=1;i<=32;i++){
											j=""+i;
											if(map.isEmpty() == false){
												map_value = map.get(j).toString();
												map_value_arr=map_value.split("#");
												if(map_value_arr[1].equals("3")){
													map_val = map_value_arr[0];
													out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
												}
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
							<td width="25%" align="center" id="gs_for_Q4"><input type="text" name="gs_no_of_tooth_for_S4" id="gs_no_of_tooth_for_S4" value="<%=gs_no_of_tooth_for_S4%>" size="1" maxlength="1" onBlur="validateNumOfTooth(this)" DB_VALUE="<%=gs_no_of_tooth_for_S4%>">
							<%
									if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="100%" id="gs_dflt_for_S4">
								<select name="gs_dflt_tooth_no_S4" id="gs_dflt_tooth_no_S4" DB_VALUE="<%=gs_dflt_tooth_no_S4%>" <%=gs_dflt_tooth_no_S4_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										//sql="SELECT A.SEGMENT_NO ,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
										for(int i=1;i<=32;i++){
											j=""+i;
											if(map.isEmpty() == false){
												map_value = map.get(j).toString();
												map_value_arr=map_value.split("#");
												if(map_value_arr[1].equals("4")){
													map_val = map_value_arr[0];
													out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
												}
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
							<td width="25%" align="center" id="gs_for_Q5" ><input type="text" name="gs_no_of_tooth_for_S5" id="gs_no_of_tooth_for_S5" value="<%=gs_no_of_tooth_for_S5%>" size="1" maxlength="1" onBlur="validateNumOfTooth(this)" DB_VALUE="<%=gs_no_of_tooth_for_S5%>">
							<%
									if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="100%" id="gs_dflt_for_S5">
								<select name="gs_dflt_tooth_no_S5" id="gs_dflt_tooth_no_S5" DB_VALUE="<%=gs_dflt_tooth_no_S5%>" <%=gs_dflt_tooth_no_S5_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										//sql="SELECT A.SEGMENT_NO ,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
										for(int i=1;i<=32;i++){
											j=""+i;
											if(map.isEmpty() == false){
												map_value = map.get(j).toString();
												map_value_arr=map_value.split("#");
												if(map_value_arr[1].equals("5")){
													map_val = map_value_arr[0];
													out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
												}
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
						
							<td width="25%" align="center" id="gs_for_Q6" ><input type="text" name="gs_no_of_tooth_for_S6" id="gs_no_of_tooth_for_S6" value="<%=gs_no_of_tooth_for_S6%>" size="1" maxlength="1" onBlur="validateNumOfTooth(this)" DB_VALUE="<%=gs_no_of_tooth_for_S6%>">
							<%
									if(record_gingival_status.equals("Y")){								
							%>
									<img src='../../eCommon/images/mandatory.gif'></img>
							<%
								}
							%>
							</td>
							<td width="25%" class="LABEL" style="text-align:right"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
							<td width="100%" id="gs_dflt_for_S6">
								<select name="gs_dflt_tooth_no_S6" id="gs_dflt_tooth_no_S6" DB_VALUE="<%=gs_dflt_tooth_no_S6%>" <%=gs_dflt_tooth_no_S6_disabled%>>
									<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
									<%
										//sql="SELECT A.SEGMENT_NO ,A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM = ? AND A.PERMANENT_DECIDUOUS = 'P' ORDER BY A.TOOTH_NO ASC";
										for(int i=1;i<=32;i++){
											j=""+i;
											if(map.isEmpty() == false){
												map_value = map.get(j).toString();
												map_value_arr=map_value.split("#");
												if(map_value_arr[1].equals("6")){
													map_val = map_value_arr[0];
													out.println("<option value='"+i+"' "+tooth_selected+">"+map_val+"</option>");
												}
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

		  <input type="hidden" name="gigival_recorded" id="gigival_recorded" value="S"> 

		  <input type="hidden" name="gs_dflt_tooth_no_S1_hid" id="gs_dflt_tooth_no_S1_hid" value="<%=gs_dflt_tooth_no_S1%>"> 
		  <input type="hidden" name="gs_dflt_tooth_no_S2_hid" id="gs_dflt_tooth_no_S2_hid" value="<%=gs_dflt_tooth_no_S2%>"> 
		  <input type="hidden" name="gs_dflt_tooth_no_S3_hid" id="gs_dflt_tooth_no_S3_hid" value="<%=gs_dflt_tooth_no_S3%>"> 
		  <input type="hidden" name="gs_dflt_tooth_no_S4_hid" id="gs_dflt_tooth_no_S4_hid" value="<%=gs_dflt_tooth_no_S4%>"> 
		  <input type="hidden" name="gs_dflt_tooth_no_S5_hid" id="gs_dflt_tooth_no_S5_hid" value="<%=gs_dflt_tooth_no_S5%>"> 
		  <input type="hidden" name="gs_dflt_tooth_no_S6_hid" id="gs_dflt_tooth_no_S6_hid" value="<%=gs_dflt_tooth_no_S6%>"> 
		  <input type="hidden" name="gs_no_of_tooth_for_S1_hid" id="gs_no_of_tooth_for_S1_hid" value="<%=gs_no_of_tooth_for_S1%>"> 
		  <input type="hidden" name="gs_no_of_tooth_for_S2_hid" id="gs_no_of_tooth_for_S2_hid" value="<%=gs_no_of_tooth_for_S2%>"> 
		  <input type="hidden" name="gs_no_of_tooth_for_S3_hid" id="gs_no_of_tooth_for_S3_hid" value="<%=gs_no_of_tooth_for_S3%>"> 
		  <input type="hidden" name="gs_no_of_tooth_for_S4_hid" id="gs_no_of_tooth_for_S4_hid" value="<%=gs_no_of_tooth_for_S4%>"> 
		  <input type="hidden" name="gs_no_of_tooth_for_S5_hid" id="gs_no_of_tooth_for_S5_hid" value="<%=gs_no_of_tooth_for_S5%>"> 
		  <input type="hidden" name="gs_no_of_tooth_for_S6_hid" id="gs_no_of_tooth_for_S6_hid" value="<%=gs_no_of_tooth_for_S6%>"> 
		  <input type="hidden" name="dec_gs_no_of_tooth_for_S1_hid" id="dec_gs_no_of_tooth_for_S1_hid" value="<%=dec_gs_no_of_tooth_for_S1%>"> 
		  <input type="hidden" name="dec_gs_no_of_tooth_for_S2_hid" id="dec_gs_no_of_tooth_for_S2_hid" value="<%=dec_gs_no_of_tooth_for_S2%>"> 
		  <input type="hidden" name="dec_gs_no_of_tooth_for_S3_hid" id="dec_gs_no_of_tooth_for_S3_hid" value="<%=dec_gs_no_of_tooth_for_S3%>"> 
		  <input type="hidden" name="dec_gs_no_of_tooth_for_S4_hid" id="dec_gs_no_of_tooth_for_S4_hid" value="<%=dec_gs_no_of_tooth_for_S4%>"> 
		  <input type="hidden" name="dec_gs_no_of_tooth_for_S5_hid" id="dec_gs_no_of_tooth_for_S5_hid" value="<%=dec_gs_no_of_tooth_for_S5%>"> 
		  <input type="hidden" name="dec_gs_no_of_tooth_for_S6_hid" id="dec_gs_no_of_tooth_for_S6_hid" value="<%=dec_gs_no_of_tooth_for_S6%>"> 
		  <input type="hidden" name="md_gs_no_of_tooth_for_S1_hid" id="md_gs_no_of_tooth_for_S1_hid" value="<%=md_gs_no_of_tooth_for_S1%>"> 
		  <input type="hidden" name="md_gs_no_of_tooth_for_S2_hid" id="md_gs_no_of_tooth_for_S2_hid" value="<%=md_gs_no_of_tooth_for_S2%>"> 
		  <input type="hidden" name="md_gs_no_of_tooth_for_S3_hid" id="md_gs_no_of_tooth_for_S3_hid" value="<%=md_gs_no_of_tooth_for_S3%>"> 
		  <input type="hidden" name="md_gs_no_of_tooth_for_S4_hid" id="md_gs_no_of_tooth_for_S4_hid" value="<%=md_gs_no_of_tooth_for_S4%>"> 
		  <input type="hidden" name="md_gs_no_of_tooth_for_S5_hid" id="md_gs_no_of_tooth_for_S5_hid" value="<%=md_gs_no_of_tooth_for_S5%>"> 
		  <input type="hidden" name="md_gs_no_of_tooth_for_S6_hid" id="md_gs_no_of_tooth_for_S6_hid" value="<%=md_gs_no_of_tooth_for_S6%>"> 
		<input type="hidden" name="md_gs_dflt_tooth_no_S1_hid" id="md_gs_dflt_tooth_no_S1_hid" value=<%=md_gs_dflt_tooth_no_S1%>> 
		<input type="hidden" name="md_gs_dflt_tooth_no_S2_hid" id="md_gs_dflt_tooth_no_S2_hid" value=<%=md_gs_dflt_tooth_no_S2%>> 
		<input type="hidden" name="md_gs_dflt_tooth_no_S3_hid" id="md_gs_dflt_tooth_no_S3_hid" value=<%=md_gs_dflt_tooth_no_S3%>> 
		<input type="hidden" name="md_gs_dflt_tooth_no_S4_hid" id="md_gs_dflt_tooth_no_S4_hid" value=<%=md_gs_dflt_tooth_no_S4%>> 
		<input type="hidden" name="md_gs_dflt_tooth_no_S5_hid" id="md_gs_dflt_tooth_no_S5_hid" value=<%=md_gs_dflt_tooth_no_S5%>> 
		<input type="hidden" name="md_gs_dflt_tooth_no_S6_hid" id="md_gs_dflt_tooth_no_S6_hid" value=<%=md_gs_dflt_tooth_no_S6%>> 



		<input type="hidden" name="mixed_dentition_from_age_yrs_hid" id="mixed_dentition_from_age_yrs_hid" value="">
		<input type="hidden" name="mixed_dentition_to_age_yrs_hid" id="mixed_dentition_to_age_yrs_hid" value="">
		<input type="hidden" name="mixed_dentition_from_age_days_hid" id="mixed_dentition_from_age_days_hid" value="">
		<input type="hidden" name="mixed_dentition_to_age_days_hid" id="mixed_dentition_to_age_days_hid" value="">
		<input type="hidden" name="deciduous_grace_period_days_hid" id="deciduous_grace_period_days_hid" value="">
		<input type="hidden" name="dflt_mixed_dentition_chart_hid" id="dflt_mixed_dentition_chart_hid" value="">
		<input type="hidden" name="rest_chrt_validity_days_hid" id="rest_chrt_validity_days_hid" value="">
		<input type="hidden" name="peri_chrt_validity_days_hid" id="peri_chrt_validity_days_hid" value="">
		<input type="hidden" name="record_gingival_status_yn_hid" id="record_gingival_status_yn_hid" value="">
		<input type="hidden" name="bl_interface_flag_hid" id="bl_interface_flag_hid" value="">
		<input type="hidden" name="gingival_recording_by_hid" id="gingival_recording_by_hid" value="">
		<input type="hidden" name="tooth_numbering_system_hid" id="tooth_numbering_system_hid" value="">

		</form>
		<script>
			     var chart_level=document.forms[0].chart_level.value;
		         if(chart_level=="E" || (chart_level=="" || chart_level=="null" || chart_level==null)){
					AssignParamSextantValue('<%=tooth_numbering_system%>','<%=record_gingival_status_yn%>');
				 }else if (chart_level=="F" ){
				    AssignSextantValue('<%=tooth_numbering_system%>','<%=record_gingival_status_yn%>');

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
			if(pstmt!=null) pstmt.close();
			ConnectionManager.returnConnection(con);
		}
		catch(Exception e){
			e.printStackTrace() ;
		}
	}
%>

