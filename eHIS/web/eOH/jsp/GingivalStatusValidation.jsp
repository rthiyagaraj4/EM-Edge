<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.util.*,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp" %>
<% 
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;

	String facility_id  = (String) session.getAttribute("facility_id");
	//String login_user  = (String) session.getAttribute("login_user");

	String locale = (String)session.getAttribute("LOCALE"); 
	String func_mode = request.getParameter( "func_mode" ) ;

	java.util.Properties prop = null;
	prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	//String client_ip_address = prop.getProperty( "client_ip_address" );

	try{
		con = ConnectionManager.getConnection();

		if(func_mode.equalsIgnoreCase("populateToothNo")){	
			String tooth_numbering_system	= checkForNull(request.getParameter( "tooth_numbering_system" )) ;
			String permanent_deciduous_flag	= checkForNull(request.getParameter( "permanent_deciduous_flag" )) ;
			String ns_quadrant	= checkForNull(request.getParameter( "ns_quadrant" )) ;
			String gingival_recording_by	= checkForNull(request.getParameter( "gingival_recording_by" )) ;
			String mixed_dentition_YN	= checkForNull(request.getParameter( "mixed_dentition_YN" )) ;			
			//String sql				= "";		
			String tooth_no_val = "";
			String tooth_num_val = "";
			String ns_quadrant_val = "";
			//Added by Sharon Crasta on 8/3/2009 for IN009739(SRR20056-CRF-0457)
			String mapped_tooth_num_val = "";
			//
			StringBuffer tooth_no_desc = new StringBuffer();
			

			//sql = "SELECT TOOTH_NO, DECODE(?,'UNI', UNIVERSAL_TOOTH_NO,'FDI',FDI_TOOTH_NO,'') TOOTH_NUM FROM OH_TOOTH WHERE PERMANENT_DECIDUOUS = 'P' ORDER BY TOOTH_NO ASC";
			//sql="SELECT A.TOOTH_NO, A.NS_TOOTH_NO  FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE  A.NUMBERING_SYSTEM = ? AND B.PERMANENT_DECIDUOUS =? and A.NS_QUADRANT=? AND A.TOOTH_NO = B.TOOTH_NO ORDER BY A.NS_TOOTH_NO ";
		if(mixed_dentition_YN.equals("N")){
			if(gingival_recording_by.equals("Q")){
				/* Commented by Sridevi Joshi on 28/11/2008 to remove PERMANENT_DECIDUOUS column reference from OH_QUADRANT */
				//pstmt = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO,C.QUADRANT_SNO  FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B,OH_QUADRANT C WHERE  A.NUMBERING_SYSTEM =? AND B.PERMANENT_DECIDUOUS = 'P' and C.QUADRANT_SNO=? AND C.QUADRANT_ID = A.NS_QUADRANT AND A.TOOTH_NO = B.TOOTH_NO AND A.NUMBERING_SYSTEM = C.NUMBERING_SYSTEM AND B.PERMANENT_DECIDUOUS = C.PERMANENT_DECIDUOUS ORDER BY A.NS_TOOTH_NO");
				//Commented by parul and written new qyery  for IN009737 & IN009739 on 7/17/2009( populating the tooth no in list box of  permanent and deciduous chart for quadrant )

				//pstmt = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO,C.QUADRANT_SNO  FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B,OH_QUADRANT C WHERE  A.NUMBERING_SYSTEM =? AND B.PERMANENT_DECIDUOUS = 'P' and C.QUADRANT_SNO=? AND C.QUADRANT_ID = A.NS_QUADRANT AND A.TOOTH_NO = B.TOOTH_NO AND A.NUMBERING_SYSTEM = C.NUMBERING_SYSTEM ORDER BY A.NS_TOOTH_NO");

				//Commented by Sharon Crasta on 9/5/2009 for IN009739(SRR20056-CRF-0457)
				//pstmt = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO,A.NS_QUADRANT, B.MAPPED_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND B.PERMANENT_DECIDUOUS = ? AND B.QUADRANT_SNO = ? AND A.TOOTH_NO = B.TOOTH_NO ORDER BY A.NS_TOOTH_NO ");
				pstmt = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO,A.NS_QUADRANT, B.MAPPED_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND B.PERMANENT_DECIDUOUS = ? AND B.QUADRANT_SNO = ? AND A.TOOTH_NO = B.TOOTH_NO ORDER BY 1 ");

				//pstmt = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO,C.QUADRANT_SNO  FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B,OH_QUADRANT C WHERE  A.NUMBERING_SYSTEM =? AND B.PERMANENT_DECIDUOUS = ? and C.QUADRANT_SNO=? AND C.QUADRANT_ID = A.NS_QUADRANT AND A.TOOTH_NO = B.TOOTH_NO AND A.NUMBERING_SYSTEM = C.NUMBERING_SYSTEM ORDER BY A.NS_TOOTH_NO");
			
				pstmt.setString(1,tooth_numbering_system);
				pstmt.setString(2,permanent_deciduous_flag);
				pstmt.setString(3,ns_quadrant);
			}
			else{
				//Commented by Sharon Crasta on 9/5/2009 for IN009739(SRR20056-CRF-0457)
				//pstmt = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO,C.SEXTANT_SNO, B.MAPPED_TOOTH_NO  FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B,OH_SEXTANT C WHERE  A.NUMBERING_SYSTEM =? AND B.PERMANENT_DECIDUOUS = ? AND C.SEXTANT_SNO=? AND C.SEXTANT_SNO = B.SEXTANT_SNO AND A.TOOTH_NO = B.TOOTH_NO AND A.NUMBERING_SYSTEM = C.NUMBERING_SYSTEM ORDER BY A.NS_TOOTH_NO");
				pstmt = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO,C.SEXTANT_SNO, B.MAPPED_TOOTH_NO  FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B,OH_SEXTANT C WHERE  A.NUMBERING_SYSTEM =? AND B.PERMANENT_DECIDUOUS = ? AND C.SEXTANT_SNO=? AND C.SEXTANT_SNO = B.SEXTANT_SNO AND A.TOOTH_NO = B.TOOTH_NO AND A.NUMBERING_SYSTEM = C.NUMBERING_SYSTEM ORDER BY 1");
				pstmt.setString(1,tooth_numbering_system);
				pstmt.setString(2,permanent_deciduous_flag);
				pstmt.setString(3,ns_quadrant);
			}
		} else{
			if(permanent_deciduous_flag.equals("P")){
				if(gingival_recording_by.equals("Q")){
					/* Commented by Sridevi Joshi on 28/11/2008 to remove PERMANENT_DECIDUOUS column reference from OH_QUADRANT */
					//pstmt = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO,C.QUADRANT_SNO  FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B,OH_QUADRANT C WHERE  A.NUMBERING_SYSTEM =? AND B.PERMANENT_DECIDUOUS = 'P' and C.QUADRANT_SNO=? AND C.QUADRANT_ID = A.NS_QUADRANT AND A.TOOTH_NO = B.TOOTH_NO AND A.NUMBERING_SYSTEM = C.NUMBERING_SYSTEM AND B.PERMANENT_DECIDUOUS = C.PERMANENT_DECIDUOUS ORDER BY A.NS_TOOTH_NO");
					 //Commented by parul and written new qyery for IN009737 & IN009739 on 7/17/2009( populating the tooth no in listbox of Mixed( permanent/deciduous) chart for quadrant)

					//pstmt = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO,C.QUADRANT_SNO  FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B,OH_QUADRANT C WHERE  A.NUMBERING_SYSTEM =? AND B.PERMANENT_DECIDUOUS = 'P' and C.QUADRANT_SNO=? AND C.QUADRANT_ID = A.NS_QUADRANT AND A.TOOTH_NO = B.TOOTH_NO AND A.NUMBERING_SYSTEM = C.NUMBERING_SYSTEM ORDER BY A.NS_TOOTH_NO");

					//Commented by Sharon Crasta on 8/4/2009 for IN009739(SRR20056-CRF-0457)
					pstmt = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO, B.MAPPED_TOOTH_NO, A.NS_QUADRANT FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND B.QUADRANT_SNO = ? AND A.TOOTH_NO = B.TOOTH_NO AND (B.PERMANENT_DECIDUOUS = ? OR MIXED_DENT_TOOTH_NO IS NOT NULL) ORDER BY 1");
					//Added B.MAPPED_TOOTH_NO to the query and removed ORDER BY 
					//pstmt = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO, B.MAPPED_TOOTH_NO, A.NS_QUADRANT FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND B.QUADRANT_SNO = ? AND A.TOOTH_NO = B.TOOTH_NO AND (B.PERMANENT_DECIDUOUS = ? OR MIXED_DENT_TOOTH_NO IS NOT NULL) ");
				   //
					//pstmt = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO,C.QUADRANT_SNO  FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B,OH_QUADRANT C WHERE  A.NUMBERING_SYSTEM =? AND B.PERMANENT_DECIDUOUS = ? and C.QUADRANT_SNO=? AND C.QUADRANT_ID = A.NS_QUADRANT AND A.TOOTH_NO = B.TOOTH_NO AND A.NUMBERING_SYSTEM = C.NUMBERING_SYSTEM ORDER BY A.NS_TOOTH_NO");
					
					pstmt.setString(1,tooth_numbering_system);
					pstmt.setString(2,ns_quadrant);
					pstmt.setString(3,permanent_deciduous_flag);
				}
				else{
					//Commented by Sharon Crasta on 8/3/2009 for IN009739(SRR20056-CRF-0457)
					//pstmt = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO,C.SEXTANT_SNO  FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B,OH_SEXTANT C WHERE  A.NUMBERING_SYSTEM =? AND B.PERMANENT_DECIDUOUS = 'P' AND C.SEXTANT_SNO=? AND C.SEXTANT_SNO = B.SEXTANT_SNO AND A.TOOTH_NO = B.TOOTH_NO AND A.NUMBERING_SYSTEM = C.NUMBERING_SYSTEM ORDER BY A.NS_TOOTH_NO");
					//Added B.MAPPED_TOOTH_NO to the query and removed ORDER BY 
					pstmt = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO, B.MAPPED_TOOTH_NO, C.SEXTANT_SNO  FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B,OH_SEXTANT C WHERE  A.NUMBERING_SYSTEM =? AND B.PERMANENT_DECIDUOUS = 'P' AND C.SEXTANT_SNO=? AND C.SEXTANT_SNO = B.SEXTANT_SNO AND A.TOOTH_NO = B.TOOTH_NO AND A.NUMBERING_SYSTEM = C.NUMBERING_SYSTEM ORDER BY 1");
					//
					pstmt.setString(1,tooth_numbering_system);
					//pstmt.setString(2,permanent_deciduous_flag);
					pstmt.setString(2,ns_quadrant);
				}
			}
			else if(permanent_deciduous_flag.equals("D")){
			  		if(gingival_recording_by.equals("Q")){
				
					/* Commented by Sridevi Joshi on 28/11/2008 to remove PERMANENT_DECIDUOUS column reference from OH_QUADRANT */
					//pstmt = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO,C.QUADRANT_SNO  FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B,OH_QUADRANT C WHERE  A.NUMBERING_SYSTEM =? AND B.PERMANENT_DECIDUOUS = 'P' and C.QUADRANT_SNO=? AND C.QUADRANT_ID = A.NS_QUADRANT AND A.TOOTH_NO = B.TOOTH_NO AND A.NUMBERING_SYSTEM = C.NUMBERING_SYSTEM AND B.PERMANENT_DECIDUOUS = C.PERMANENT_DECIDUOUS ORDER BY A.NS_TOOTH_NO");
					 //Commented by parul and written new qyery for IN009737 & IN009739 on 7/17/2009( populating the tooth no in listbox of Mixed( permanent/deciduous) chart for quadrant)

					//pstmt = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO,C.QUADRANT_SNO  FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B,OH_QUADRANT C WHERE  A.NUMBERING_SYSTEM =? AND B.PERMANENT_DECIDUOUS = 'P' and C.QUADRANT_SNO=? AND C.QUADRANT_ID = A.NS_QUADRANT AND A.TOOTH_NO = B.TOOTH_NO AND A.NUMBERING_SYSTEM = C.NUMBERING_SYSTEM ORDER BY A.NS_TOOTH_NO");

					//Commented by Sharon Crasta on 8/4/2009 for IN009739(SRR20056-CRF-0457)
					//pstmt = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO, A.NS_QUADRANT FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND B.QUADRANT_SNO = ? AND A.TOOTH_NO = B.TOOTH_NO AND (B.PERMANENT_DECIDUOUS = ? OR MIXED_DENT_TOOTH_NO IS NOT NULL) ORDER BY MIXED_DENT_TOOTH_ORDER");
					//Added B.MAPPED_TOOTH_NO to the query
					//pstmt = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO, B.MAPPED_TOOTH_NO, A.NS_QUADRANT FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND B.QUADRANT_SNO = ? AND A.TOOTH_NO = B.TOOTH_NO AND (B.PERMANENT_DECIDUOUS = ? OR MIXED_DENT_TOOTH_NO IS NOT NULL)  ORDER BY 1");
					//Added by Sridevi Joshi on 090909 for IN009739(SRR20056-CRF-0457) to get correct correct tooth no.Commented above.
					pstmt = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO, B.MAPPED_TOOTH_NO, A.NS_QUADRANT FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B WHERE A.NUMBERING_SYSTEM = ? AND B.QUADRANT_SNO = ? AND A.TOOTH_NO = B.TOOTH_NO AND (B.PERMANENT_DECIDUOUS = ? OR MIXED_DENT_TOOTH_NO IS NOT NULL)  ORDER BY MIXED_DENT_TOOTH_ORDER");
				   //
					//pstmt = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO,C.QUADRANT_SNO  FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B,OH_QUADRANT C WHERE  A.NUMBERING_SYSTEM =? AND B.PERMANENT_DECIDUOUS = ? and C.QUADRANT_SNO=? AND C.QUADRANT_ID = A.NS_QUADRANT AND A.TOOTH_NO = B.TOOTH_NO AND A.NUMBERING_SYSTEM = C.NUMBERING_SYSTEM ORDER BY A.NS_TOOTH_NO");
					
					pstmt.setString(1,tooth_numbering_system);
					pstmt.setString(2,ns_quadrant);
					pstmt.setString(3,permanent_deciduous_flag);
				}
				else{
					//Commented by Sharon Crasta on 8/3/2009 for IN009739(SRR20056-CRF-0457)
					//pstmt = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO,C.SEXTANT_SNO  FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B,OH_SEXTANT C WHERE  A.NUMBERING_SYSTEM =? AND B.PERMANENT_DECIDUOUS = 'P' AND C.SEXTANT_SNO=? AND C.SEXTANT_SNO = B.SEXTANT_SNO AND A.TOOTH_NO = B.TOOTH_NO AND A.NUMBERING_SYSTEM = C.NUMBERING_SYSTEM ORDER BY A.NS_TOOTH_NO");
					pstmt = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO, B.MAPPED_TOOTH_NO, C.SEXTANT_SNO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B, OH_SEXTANT C WHERE A.NUMBERING_SYSTEM = ? AND C.SEXTANT_SNO = ? AND C.SEXTANT_SNO = B.SEXTANT_SNO AND A.TOOTH_NO = B.TOOTH_NO AND A.NUMBERING_SYSTEM = C.NUMBERING_SYSTEM AND (B.PERMANENT_DECIDUOUS = ? OR MIXED_DENT_TOOTH_NO IS NOT NULL)ORDER BY MIXED_DENT_TOOTH_ORDER ");
					//pstmt = con.prepareStatement("SELECT A.TOOTH_NO, A.NS_TOOTH_NO, B.MAPPED_TOOTH_NO, C.SEXTANT_SNO FROM OH_TOOTH_BY_NUMBERING_SYSTEM A, OH_TOOTH B, OH_SEXTANT C WHERE A.NUMBERING_SYSTEM = ? AND C.SEXTANT_SNO = ? AND C.SEXTANT_SNO = B.SEXTANT_SNO AND A.TOOTH_NO = B.TOOTH_NO AND A.NUMBERING_SYSTEM = C.NUMBERING_SYSTEM AND (B.PERMANENT_DECIDUOUS = ? OR MIXED_DENT_TOOTH_NO IS NOT NULL) ORDER BY 1");
					//
					pstmt.setString(1,tooth_numbering_system);
					pstmt.setString(2,ns_quadrant);
					//Uncommented by Sharon Crasta on 8/10/2009 for IN009739(SRR20056-CRF-0457) 
					pstmt.setString(3,permanent_deciduous_flag);
					//
					
				}
			}
		}
            rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				tooth_no_val = rst.getString("TOOTH_NO");
				tooth_num_val = rst.getString("NS_TOOTH_NO");
				//Added by Sharon Crasta on 8/3/2009 for IN009739(SRR20056-CRF-0457)
				//if(mixed_dentition_YN.equals("Y")){
					mapped_tooth_num_val = rst.getString("MAPPED_TOOTH_NO");
				//}
				//
				if(gingival_recording_by.equals("Q")){
					ns_quadrant_val = rst.getString("NS_QUADRANT");
				}else{
					ns_quadrant_val = rst.getString("SEXTANT_SNO");				
				}

				//Commented and Added by Sharon Crasta on 8/3/2009 for IN009739(SRR20056-CRF-0457)
				//tooth_no_desc.append(tooth_no_val+"##"+tooth_num_val+"##"+ns_quadrant_val);
				tooth_no_desc.append(tooth_no_val+"##"+tooth_num_val+"##"+ns_quadrant_val+"##"+mapped_tooth_num_val);
			//	tooth_no_desc.append(tooth_no_val+"##"+tooth_num_val);

				tooth_no_desc.append("~");   

				
			}
			out.println(tooth_no_desc);
		}
		else if(func_mode.equalsIgnoreCase("populateGSArea")){	
			String chart_num	= checkForNull(request.getParameter( "chart_num" ));
			String patient_id	= checkForNull(request.getParameter( "patient_id" ));
			String gingival_recording_by	= checkForNull(request.getParameter( "gingival_recording_by" ));
		
			String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" ));
			String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" ));
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
		

			String sql	= "";		
			String quadrant_no_val= "";
			String tooth_no_val = "";
			String condition_type_val = "";
			String gingival_status_code_val= "";
			//String status_val= "";
			//Commented and Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
			String status= "";
			//
			
			StringBuffer  gingival_desc= new StringBuffer();
		if(oh_chart_level.equals("E")){
			if(gingival_recording_by.equals("Q")){
				//Commented and Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
				//sql="SELECT QUADRANT_SNO QUAD_SEXT_SNO, TOOTH_NO,GINGIVAL_STATUS_CODE FROM OH_RESTORATIVE_CHART_GING_STS WHERE PATIENT_ID=? AND CHART_NUM=? AND NVL(STATUS, 'X') != 'E'";
				//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
				//sql="SELECT QUADRANT_SNO QUAD_SEXT_SNO, TOOTH_NO,GINGIVAL_STATUS_CODE, STATUS FROM OH_RESTORATIVE_CHART_GING_STS WHERE PATIENT_ID=? AND CHART_NUM=? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Y'  AND NVL(STATUS, 'X') != 'N' AND NVL(STATUS, 'X') != 'C'";
				sql="SELECT QUADRANT_SNO QUAD_SEXT_SNO, TOOTH_NO,GINGIVAL_STATUS_CODE, STATUS FROM OH_RESTORATIVE_CHART_GING_STS WHERE PATIENT_ID=? AND CHART_NUM=? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Y'";
			}
			else{
				//Commented and Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
				//sql="SELECT SEXTENT_SNO QUAD_SEXT_SNO, TOOTH_NO, GINGIVAL_STATUS_CODE FROM OH_RESTORATIVE_CHART_GING_STS WHERE PATIENT_ID=? AND CHART_NUM=? AND NVL(STATUS, 'X') != 'E'";
				//sql="SELECT SEXTENT_SNO QUAD_SEXT_SNO, TOOTH_NO, GINGIVAL_STATUS_CODE,STATUS FROM OH_RESTORATIVE_CHART_GING_STS WHERE PATIENT_ID=? AND CHART_NUM=? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Y'";
				//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
				//sql="SELECT SEXTENT_SNO QUAD_SEXT_SNO, TOOTH_NO, GINGIVAL_STATUS_CODE,STATUS FROM OH_RESTORATIVE_CHART_GING_STS WHERE PATIENT_ID=? AND CHART_NUM=? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Y' AND NVL(STATUS, 'X') != 'N'  AND NVL(STATUS, 'X') != 'C'";
				sql="SELECT SEXTENT_SNO QUAD_SEXT_SNO, TOOTH_NO, GINGIVAL_STATUS_CODE,STATUS FROM OH_RESTORATIVE_CHART_GING_STS WHERE PATIENT_ID=? AND CHART_NUM=? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Y'";
			}

				pstmt = con.prepareStatement(sql);
				//pstmt.setString(1,facility_id);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				rst = pstmt.executeQuery();

		}else{
				if(gingival_recording_by.equals("Q")){
					//Commented and Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
					//sql="SELECT QUADRANT_SNO QUAD_SEXT_SNO, TOOTH_NO,GINGIVAL_STATUS_CODE FROM OH_RESTORATIVE_CHART_GING_STS WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND NVL(STATUS, 'X') != 'E'";
					//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
					//sql="SELECT QUADRANT_SNO QUAD_SEXT_SNO, TOOTH_NO,GINGIVAL_STATUS_CODE, STATUS FROM OH_RESTORATIVE_CHART_GING_STS WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Y'  AND NVL(STATUS, 'X') != 'N'";
					sql="SELECT QUADRANT_SNO QUAD_SEXT_SNO, TOOTH_NO,GINGIVAL_STATUS_CODE, STATUS FROM OH_RESTORATIVE_CHART_GING_STS WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Y'";
				}
				else{
					//Commented and Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
					//sql="SELECT SEXTENT_SNO QUAD_SEXT_SNO, TOOTH_NO, GINGIVAL_STATUS_CODE FROM OH_RESTORATIVE_CHART_GING_STS WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND NVL(STATUS, 'X') != 'E'";
					//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
					//sql="SELECT SEXTENT_SNO QUAD_SEXT_SNO, TOOTH_NO, GINGIVAL_STATUS_CODE, STATUS FROM OH_RESTORATIVE_CHART_GING_STS WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND NVL(STATUS, 'X') != 'E'  AND NVL(STATUS, 'X') != 'Y'  AND NVL(STATUS, 'X') != 'N'";
					sql="SELECT SEXTENT_SNO QUAD_SEXT_SNO, TOOTH_NO, GINGIVAL_STATUS_CODE, STATUS FROM OH_RESTORATIVE_CHART_GING_STS WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND NVL(STATUS, 'X') != 'E'  AND NVL(STATUS, 'X') != 'Y'";
				}

					pstmt = con.prepareStatement(sql);
				//	pstmt.setString(1,facility_id);
					pstmt.setString(1,other_chart_facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					rst = pstmt.executeQuery();

		}
			while(rst!= null && rst.next()){
				quadrant_no_val = rst.getString("QUAD_SEXT_SNO");
				tooth_no_val = rst.getString("TOOTH_NO");
				condition_type_val = "";
				gingival_status_code_val = rst.getString("GINGIVAL_STATUS_CODE");
				//Commented and Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
				status = rst.getString("STATUS");
			
			   // gingival_desc.append(quadrant_no_val +"##"+tooth_no_val +"##"+ condition_type_val+"##"+ gingival_status_code_val);
			    gingival_desc.append(quadrant_no_val +"##"+tooth_no_val +"##"+ condition_type_val+"##"+ gingival_status_code_val+"##"+status);
				//
				gingival_desc.append("~"); 
			
				
			}
			out.println(gingival_desc);

		}

		else if(func_mode.equalsIgnoreCase("updateStatus")){	
			String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
			String quadrant_sno_hid	= checkForNull(request.getParameter( "quadrant_sno_hid" )) ;
			String tooth_no_hid	= checkForNull(request.getParameter( "tooth_no_hid" )) ;
			//String condition_type_hid	= checkForNull(request.getParameter( "condition_type_hid" )) ;
			String gingival_status_code_hid	= checkForNull(request.getParameter( "gingival_status_code_hid" )) ;
			//String status_hid	= checkForNull(request.getParameter( "status_hid" )) ;
			String status	= checkForNull(request.getParameter( "status" )) ;
			String gingival_recording_by	= checkForNull(request.getParameter( "gingival_recording_by" )) ;
			//Added by Sharon Crasta on 4/7/2010 for IN018169
			String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
			//End
			/*if(!status.equals("E") && !status.equals("Y")){
				status = "O";
			}  */
			int flag = 0;

			String sql = "";
			String value = "";
			String msg = "";

			if(rst != null) rst.close();
			if(pstmt != null) pstmt.close();

			pstmt=con.prepareStatement("SELECT VALUE FROM OH_GINGIVAL_STATUS_LANG_VW WHERE GINGIVAL_STATUS_CODE=? AND LANGUAGE_ID=?");
			pstmt.setString(1,gingival_status_code_hid);
			pstmt.setString(2,locale);
			rst = pstmt.executeQuery();
			while(rst.next()){
				value=rst.getString("VALUE");
			}

			//String sql="UPDATE OH_RESTORATIVE_CHART_GING_STS SET STATUS ='E' WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ?  AND QUADRANT_SNO= ? AND TOOTH_NO = ? AND CONDITION_TYPE = ? AND GINGIVAL_STATUS_CODE= ? AND NVL(STATUS, 'X') != 'E'";
			if(gingival_recording_by.equals("Q")){
				//sql="UPDATE OH_RESTORATIVE_CHART_GING_STS SET STATUS = ?, GINGIVAL_STATUS_CODE= ?, VALUE = ? WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ?  AND QUADRANT_SNO= ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E'";
				//sql="UPDATE OH_RESTORATIVE_CHART_GING_STS SET STATUS = ?, GINGIVAL_STATUS_CODE= ?, VALUE = ? WHERE PATIENT_ID = ?  AND QUADRANT_SNO= ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E'";
				//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
				//sql="UPDATE OH_RESTORATIVE_CHART_GING_STS SET STATUS = ?, GINGIVAL_STATUS_CODE= ?, VALUE = ? WHERE PATIENT_ID = ?  AND QUADRANT_SNO= ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'N'";
				sql="UPDATE OH_RESTORATIVE_CHART_GING_STS SET STATUS = ?, GINGIVAL_STATUS_CODE= ?, VALUE = ? WHERE PATIENT_ID = ? AND CHART_NUM = ? AND QUADRANT_SNO= ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E'";
			}
			else{
			//	sql="UPDATE OH_RESTORATIVE_CHART_GING_STS SET STATUS = ?, GINGIVAL_STATUS_CODE= ?, VALUE = ? WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ?  AND SEXTENT_SNO= ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E'";
				//sql="UPDATE OH_RESTORATIVE_CHART_GING_STS SET STATUS = ?, GINGIVAL_STATUS_CODE= ?, VALUE = ? WHERE PATIENT_ID = ?  AND SEXTENT_SNO= ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E'";
				//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
				//sql="UPDATE OH_RESTORATIVE_CHART_GING_STS SET STATUS = ?, GINGIVAL_STATUS_CODE= ?, VALUE = ? WHERE PATIENT_ID = ?  AND SEXTENT_SNO= ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'N'";
				sql="UPDATE OH_RESTORATIVE_CHART_GING_STS SET STATUS = ?, GINGIVAL_STATUS_CODE= ?, VALUE = ? WHERE PATIENT_ID = ? AND CHART_NUM = ? AND SEXTENT_SNO= ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E'";
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,status);
			pstmt.setString(2,gingival_status_code_hid);
			pstmt.setString(3,value);
			//pstmt.setString(4,facility_id);
			pstmt.setString(4,patient_id);
			pstmt.setString(5,chart_num);
			pstmt.setString(6,quadrant_sno_hid);
			pstmt.setString(7,tooth_no_hid);
			
			flag = pstmt.executeUpdate();

			if(flag != 0){
				con.commit();
				msg = "UPDATE";
			}
			else{
				con.rollback();
				msg = "";
			}

			out.println(msg);
        }

    else if(func_mode.equalsIgnoreCase("restrictToothGS")){	
		 String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
		 String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
		 String gingival_recording_by	= checkForNull(request.getParameter( "gingival_recording_by" )) ;
		 String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
		 String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
		 if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
		
		 //String tooth_no="";
		 String sql="";
         String quadrant_no_val="";
         int tooth_val=0;
		 //int TOOTH_COUNT=0;
		 StringBuffer  restrict_tooth= new StringBuffer();
		if(oh_chart_level.equals("E")){
			 if(gingival_recording_by.equals("Q")){
			    //Commented and Added by Sharon Crasta on 7/31/2009 for IN009739(SRR20056-CRF-0457)
				//sql="SELECT QUADRANT_SNO QUAD_SEXT_SNO,COUNT(DISTINCT TOOTH_NO) TOOTH_COUNT FROM OH_RESTORATIVE_CHART_GING_STS WHERE PATIENT_ID=? AND CHART_NUM=?  AND NVL(STATUS, 'X') != 'E'  GROUP BY QUADRANT_SNO";
				//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
				//sql="SELECT QUADRANT_SNO QUAD_SEXT_SNO,COUNT(DISTINCT TOOTH_NO) TOOTH_COUNT FROM OH_RESTORATIVE_CHART_GING_STS WHERE PATIENT_ID=? AND CHART_NUM=?  AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Y'  AND NVL(STATUS, 'X') != 'N'  AND NVL(STATUS, 'X') != 'C' GROUP BY QUADRANT_SNO";
				sql="SELECT QUADRANT_SNO QUAD_SEXT_SNO,COUNT(DISTINCT TOOTH_NO) TOOTH_COUNT FROM OH_RESTORATIVE_CHART_GING_STS WHERE PATIENT_ID=? AND CHART_NUM=?  AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Y' GROUP BY QUADRANT_SNO";
				
			 }
			 else{
			    //Commented and Added by Sharon Crasta on 7/31/2009 for IN009739(SRR20056-CRF-0457)
				// sql="SELECT SEXTENT_SNO QUAD_SEXT_SNO,COUNT(DISTINCT TOOTH_NO) TOOTH_COUNT FROM OH_RESTORATIVE_CHART_GING_STS WHERE  PATIENT_ID=? AND CHART_NUM=?  AND NVL(STATUS, 'X') != 'E'  GROUP BY SEXTENT_SNO";
				//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
				// sql="SELECT SEXTENT_SNO QUAD_SEXT_SNO,COUNT(DISTINCT TOOTH_NO) TOOTH_COUNT FROM OH_RESTORATIVE_CHART_GING_STS WHERE  PATIENT_ID=? AND CHART_NUM=?  AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Y'  AND NVL(STATUS, 'X') != 'N'  AND NVL(STATUS, 'X') != 'C'  GROUP BY SEXTENT_SNO";
				 sql="SELECT SEXTENT_SNO QUAD_SEXT_SNO,COUNT(DISTINCT TOOTH_NO) TOOTH_COUNT FROM OH_RESTORATIVE_CHART_GING_STS WHERE  PATIENT_ID=? AND CHART_NUM=?  AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Y' GROUP BY SEXTENT_SNO";
			 }

			pstmt = con.prepareStatement(sql);
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			rst = pstmt.executeQuery();

		}else{
		  if(gingival_recording_by.equals("Q")){
				//Commented and Added by Sharon Crasta on 7/31/2009 for IN009739(SRR20056-CRF-0457)
				//sql="SELECT QUADRANT_SNO QUAD_SEXT_SNO,COUNT(DISTINCT TOOTH_NO) TOOTH_COUNT FROM OH_RESTORATIVE_CHART_GING_STS WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=?  AND NVL(STATUS, 'X') != 'E'  GROUP BY QUADRANT_SNO";
				//Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
				//sql="SELECT QUADRANT_SNO QUAD_SEXT_SNO,COUNT(DISTINCT TOOTH_NO) TOOTH_COUNT FROM OH_RESTORATIVE_CHART_GING_STS WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=?  AND NVL(STATUS, 'X') != 'E'  AND NVL(STATUS, 'X') != 'Y'   AND NVL(STATUS, 'X') != 'N'  AND NVL(STATUS, 'X') != 'C' GROUP BY QUADRANT_SNO";
				sql="SELECT QUADRANT_SNO QUAD_SEXT_SNO,COUNT(DISTINCT TOOTH_NO) TOOTH_COUNT FROM OH_RESTORATIVE_CHART_GING_STS WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=?  AND NVL(STATUS, 'X') != 'E'  AND NVL(STATUS, 'X') != 'Y' GROUP BY QUADRANT_SNO";
				
			 }
			 else{
				 //Commented and Added by Sharon Crasta on 7/31/2009 for IN009739(SRR20056-CRF-0457)
				 //sql="SELECT SEXTENT_SNO QUAD_SEXT_SNO,COUNT(DISTINCT TOOTH_NO) TOOTH_COUNT FROM OH_RESTORATIVE_CHART_GING_STS WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=?  AND NVL(STATUS, 'X') != 'E'  GROUP BY SEXTENT_SNO";
				 //Commented by Sharon Crasta on 11/2/2009. Written for cancelling the Gingival Status.
				// sql="SELECT SEXTENT_SNO QUAD_SEXT_SNO,COUNT(DISTINCT TOOTH_NO) TOOTH_COUNT FROM OH_RESTORATIVE_CHART_GING_STS WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=?  AND NVL(STATUS, 'X') != 'E'  AND NVL(STATUS, 'X') != 'Y'  AND NVL(STATUS, 'X') != 'N'  AND NVL(STATUS, 'X') != 'C'  GROUP BY SEXTENT_SNO";
				 sql="SELECT SEXTENT_SNO QUAD_SEXT_SNO,COUNT(DISTINCT TOOTH_NO) TOOTH_COUNT FROM OH_RESTORATIVE_CHART_GING_STS WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=?  AND NVL(STATUS, 'X') != 'E'  AND NVL(STATUS, 'X') != 'Y'  GROUP BY SEXTENT_SNO";
			 }

			pstmt = con.prepareStatement(sql);
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,other_chart_facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,chart_num);
			rst = pstmt.executeQuery();
		}

		while(rst!= null && rst.next()){
				quadrant_no_val = rst.getString("QUAD_SEXT_SNO");
				tooth_val = Integer.parseInt(rst.getString("TOOTH_COUNT"));
				//tooth_no = rst.getString("TOOTH_NO");
			
				//restrict_tooth.append(quadrant_no_val+"##"+tooth_val+"##"+tooth_no);
				restrict_tooth.append(quadrant_no_val+"##"+tooth_val);
				restrict_tooth.append("~"); 
		 
		   }
			out.println(restrict_tooth);

	 }
	 else if(func_mode.equalsIgnoreCase("selectToothNoRecordedForGS")){	
		 String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
		 String chart_num	= checkForNull(request.getParameter( "chart_num" )) ;
		 String gingival_recording_by	= checkForNull(request.getParameter( "gingival_recording_by" )) ;
		 String quadrant_sno	= checkForNull(request.getParameter( "quadrant_sno" )) ;
		 String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
		 String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
		 if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
		
		 String tooth_no="";
		 String sql="";
		 StringBuffer  restrict_tooth= new StringBuffer();
		if (oh_chart_level.equals("E")){
			 if(gingival_recording_by.equals("Q")){
				sql="SELECT DISTINCT TOOTH_NO FROM OH_RESTORATIVE_CHART_GING_STS WHERE PATIENT_ID=? AND CHART_NUM=?  AND NVL(STATUS, 'X') != 'E'  AND QUADRANT_SNO = ?";
				
			 }
			 else{
				 sql="SELECT DISTINCT TOOTH_NO FROM OH_RESTORATIVE_CHART_GING_STS WHERE PATIENT_ID=? AND CHART_NUM=?  AND NVL(STATUS, 'X') != 'E'  AND SEXTENT_SNO = ?";
			 }

			pstmt = con.prepareStatement(sql);
			//pstmt.setString(1,facility_id);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,chart_num);
			pstmt.setString(3,quadrant_sno);
			rst = pstmt.executeQuery();
	}else{

		 if(gingival_recording_by.equals("Q")){
			sql="SELECT DISTINCT TOOTH_NO FROM OH_RESTORATIVE_CHART_GING_STS WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=?  AND NVL(STATUS, 'X') != 'E'  AND QUADRANT_SNO = ?";
			
		 }
		 else{
			 sql="SELECT DISTINCT TOOTH_NO FROM OH_RESTORATIVE_CHART_GING_STS WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=?  AND NVL(STATUS, 'X') != 'E'  AND SEXTENT_SNO = ?";
		 }

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,other_chart_facility_id);
		pstmt.setString(2,patient_id);
		pstmt.setString(3,chart_num);
		pstmt.setString(4,quadrant_sno);
	 	rst = pstmt.executeQuery();
}
		while(rst!= null && rst.next()){
				tooth_no = rst.getString("TOOTH_NO");
			
				restrict_tooth.append(tooth_no);
				restrict_tooth.append("~"); 
		 
		   }
			out.println(restrict_tooth);

	 }
	else if(func_mode.equalsIgnoreCase("restrictQuadrantGS")){	
		// String tooth_numbering_system	= checkForNull(request.getParameter( "tooth_numbering_system" )) ;
		 String gingival_recording_by	= checkForNull(request.getParameter( "gingival_recording_by" )) ;
		 String other_chart_facility_id	= checkForNull(request.getParameter( "other_chart_facility_id" )) ;
		 String oh_chart_level	= checkForNull(request.getParameter( "oh_chart_level" )) ;
		//Sharon
		 //String mixed_dentition_YN	= checkForNull(request.getParameter( "mixed_dentition_YN" )) ;
		 String chart_type	= checkForNull(request.getParameter( "chart_type" )) ;
		 //Sharon
		 if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			
         int q1_val=0;
         int q2_val=0;
         int q3_val=0;
         int q4_val=0;

		 int q1_dflt_val=0;
         int q2_dflt_val=0;
         int q3_dflt_val=0;
         int q4_dflt_val=0;

 		 String md_q1_dflt_val="";
         String md_q2_dflt_val="";
         String md_q3_dflt_val="";
         String md_q4_dflt_val="";

		 String md_s1_dflt_val="";
         String md_s2_dflt_val="";
         String md_s3_dflt_val="";
         String md_s4_dflt_val="";
		 String md_s5_dflt_val="";
		 String md_s6_dflt_val="";

		 int s1_val = 0;
		 int s2_val = 0;
		 int s3_val = 0;
		 int s4_val = 0;
		 int s5_val = 0;
		 int s6_val = 0;

		 int s1_dflt_val = 0;
		 int s2_dflt_val = 0;
		 int s3_dflt_val = 0;
		 int s4_dflt_val = 0;
		 int s5_dflt_val = 0;
		 int s6_dflt_val = 0;
		 StringBuffer quadrant_no_val = new StringBuffer();
		if(oh_chart_level.equals("E")){
			if(chart_type.equals("RA")){
				if(gingival_recording_by.equals("Q")){
				// below all queries are commented and added "where gingival_recording_by is not null" by parul on 7/13/2009 becoz if record is having null value it should not raise null pointer exception.
					//pstmt = con.prepareStatement("SELECT  GS_NO_OF_TOOTH_FOR_Q1,GS_NO_OF_TOOTH_FOR_Q2,GS_NO_OF_TOOTH_FOR_Q3, GS_NO_OF_TOOTH_FOR_Q4, GS_DFLT_TOOTH_NO_Q1, GS_DFLT_TOOTH_NO_Q2, GS_DFLT_TOOTH_NO_Q3, GS_DFLT_TOOTH_NO_Q4 FROM OH_PARAM_FOR_FACILITY");
					
					//Commented and Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
					//pstmt = con.prepareStatement("SELECT  GS_NO_OF_TOOTH_FOR_Q1,GS_NO_OF_TOOTH_FOR_Q2,GS_NO_OF_TOOTH_FOR_Q3, GS_NO_OF_TOOTH_FOR_Q4, GS_DFLT_TOOTH_NO_Q1, GS_DFLT_TOOTH_NO_Q2, GS_DFLT_TOOTH_NO_Q3, GS_DFLT_TOOTH_NO_Q4 FROM OH_PARAM_FOR_FACILITY WHERE GINGIVAL_RECORDING_BY IS NOT NULL");
					pstmt = con.prepareStatement("SELECT  GS_NO_OF_TOOTH_FOR_Q1,GS_NO_OF_TOOTH_FOR_Q2,GS_NO_OF_TOOTH_FOR_Q3, GS_NO_OF_TOOTH_FOR_Q4, GS_DFLT_TOOTH_NO_Q1, GS_DFLT_TOOTH_NO_Q2, GS_DFLT_TOOTH_NO_Q3, GS_DFLT_TOOTH_NO_Q4 FROM OH_PARAM WHERE GINGIVAL_RECORDING_BY IS NOT NULL");
					//
					//pstmt.setString(1,facility_id);
					//pstmt.setString(1,tooth_numbering_system);


					rst = pstmt.executeQuery();
					while(rst!= null && rst.next()){
							q1_val = Integer.parseInt(rst.getString("GS_NO_OF_TOOTH_FOR_Q1"));
							q2_val = Integer.parseInt(rst.getString("GS_NO_OF_TOOTH_FOR_Q2"));
							q3_val = Integer.parseInt( rst.getString("GS_NO_OF_TOOTH_FOR_Q3"));
							q4_val = Integer.parseInt(rst.getString("GS_NO_OF_TOOTH_FOR_Q4"));

							q1_dflt_val = Integer.parseInt(rst.getString("GS_DFLT_TOOTH_NO_Q1"));
							q2_dflt_val = Integer.parseInt(rst.getString("GS_DFLT_TOOTH_NO_Q2"));
							q3_dflt_val = Integer.parseInt(rst.getString("GS_DFLT_TOOTH_NO_Q3"));
							q4_dflt_val = Integer.parseInt(rst.getString("GS_DFLT_TOOTH_NO_Q4"));
					
						quadrant_no_val.append(q1_val +"##"+q2_val+"##"+q3_val+"##"+q4_val+"##"+q1_dflt_val +"##"+q2_dflt_val+"##"+q3_dflt_val+"##"+q4_dflt_val );
					//	quadrant_no_val.append("~");
					}
				}
				else{
					//pstmt = con.prepareStatement("SELECT GS_NO_OF_TOOTH_FOR_S1, GS_NO_OF_TOOTH_FOR_S2, GS_NO_OF_TOOTH_FOR_S3, GS_NO_OF_TOOTH_FOR_S4, GS_NO_OF_TOOTH_FOR_S5, GS_NO_OF_TOOTH_FOR_S6, GS_DFLT_TOOTH_NO_S1, GS_DFLT_TOOTH_NO_S2, GS_DFLT_TOOTH_NO_S3, GS_DFLT_TOOTH_NO_S4, GS_DFLT_TOOTH_NO_S5, GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM_FOR_FACILITY  ");
					
					//Commented and Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
					//pstmt = con.prepareStatement("SELECT GS_NO_OF_TOOTH_FOR_S1, GS_NO_OF_TOOTH_FOR_S2, GS_NO_OF_TOOTH_FOR_S3, GS_NO_OF_TOOTH_FOR_S4, GS_NO_OF_TOOTH_FOR_S5, GS_NO_OF_TOOTH_FOR_S6, GS_DFLT_TOOTH_NO_S1, GS_DFLT_TOOTH_NO_S2, GS_DFLT_TOOTH_NO_S3, GS_DFLT_TOOTH_NO_S4, GS_DFLT_TOOTH_NO_S5, GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM_FOR_FACILITY WHERE GINGIVAL_RECORDING_BY IS NOT NULL ");
					pstmt = con.prepareStatement("SELECT GS_NO_OF_TOOTH_FOR_S1, GS_NO_OF_TOOTH_FOR_S2, GS_NO_OF_TOOTH_FOR_S3, GS_NO_OF_TOOTH_FOR_S4, GS_NO_OF_TOOTH_FOR_S5, GS_NO_OF_TOOTH_FOR_S6, GS_DFLT_TOOTH_NO_S1, GS_DFLT_TOOTH_NO_S2, GS_DFLT_TOOTH_NO_S3, GS_DFLT_TOOTH_NO_S4, GS_DFLT_TOOTH_NO_S5, GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM WHERE GINGIVAL_RECORDING_BY IS NOT NULL ");
					//
					//pstmt.setString(1,facility_id);
					//pstmt.setString(2,tooth_numbering_system);

					rst = pstmt.executeQuery();
					while(rst!= null && rst.next()){
							s1_val = Integer.parseInt(rst.getString("GS_NO_OF_TOOTH_FOR_S1"));
							s2_val = Integer.parseInt(rst.getString("GS_NO_OF_TOOTH_FOR_S2"));
							s3_val = Integer.parseInt(rst.getString("GS_NO_OF_TOOTH_FOR_S3"));
							s4_val = Integer.parseInt(rst.getString("GS_NO_OF_TOOTH_FOR_S4"));
							s5_val = Integer.parseInt(rst.getString("GS_NO_OF_TOOTH_FOR_S5"));
							s6_val = Integer.parseInt(rst.getString("GS_NO_OF_TOOTH_FOR_S6"));

							s1_dflt_val = Integer.parseInt(rst.getString("GS_DFLT_TOOTH_NO_S1"));
							s2_dflt_val = Integer.parseInt(rst.getString("GS_DFLT_TOOTH_NO_S2"));
							s3_dflt_val = Integer.parseInt(rst.getString("GS_DFLT_TOOTH_NO_S3"));
							s4_dflt_val = Integer.parseInt(rst.getString("GS_DFLT_TOOTH_NO_S4"));
							s5_dflt_val = Integer.parseInt(rst.getString("GS_DFLT_TOOTH_NO_S5"));
							s6_dflt_val = Integer.parseInt(rst.getString("GS_DFLT_TOOTH_NO_S6"));
						
						quadrant_no_val.append(s1_val+"##"+s2_val+"##"+s3_val+"##"+s4_val+"##"+s5_val+"##"+s6_val+"##"+s1_dflt_val+"##"+s2_dflt_val+"##"+s3_dflt_val+"##"+s4_dflt_val+"##"+s5_dflt_val+"##"+s6_dflt_val);
						//quadrant_no_val.append("~");
					}
				}
			}else if(chart_type.equals("RD")){
				if(gingival_recording_by.equals("Q")){
					// below all queries are commented and added "where gingival_recording_by is not null" by parul on 7/13/2009 becoz if record is having null value it should not raise null pointer exception.
					//pstmt = con.prepareStatement("SELECT  GS_NO_OF_TOOTH_FOR_Q1,GS_NO_OF_TOOTH_FOR_Q2,GS_NO_OF_TOOTH_FOR_Q3, GS_NO_OF_TOOTH_FOR_Q4, GS_DFLT_TOOTH_NO_Q1, GS_DFLT_TOOTH_NO_Q2, GS_DFLT_TOOTH_NO_Q3, GS_DFLT_TOOTH_NO_Q4 FROM OH_PARAM_FOR_FACILITY");
					
					//Commented and Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
					//pstmt = con.prepareStatement("SELECT  GS_NO_OF_TOOTH_FOR_Q1,GS_NO_OF_TOOTH_FOR_Q2,GS_NO_OF_TOOTH_FOR_Q3, GS_NO_OF_TOOTH_FOR_Q4, GS_DFLT_TOOTH_NO_Q1, GS_DFLT_TOOTH_NO_Q2, GS_DFLT_TOOTH_NO_Q3, GS_DFLT_TOOTH_NO_Q4 FROM OH_PARAM_FOR_FACILITY WHERE GINGIVAL_RECORDING_BY IS NOT NULL");
					//Sharon
					//pstmt = con.prepareStatement("SELECT  GS_NO_OF_TOOTH_FOR_Q1,GS_NO_OF_TOOTH_FOR_Q2,GS_NO_OF_TOOTH_FOR_Q3, GS_NO_OF_TOOTH_FOR_Q4, GS_DFLT_TOOTH_NO_Q1, GS_DFLT_TOOTH_NO_Q2, GS_DFLT_TOOTH_NO_Q3, GS_DFLT_TOOTH_NO_Q4 FROM OH_PARAM WHERE GINGIVAL_RECORDING_BY IS NOT NULL");
					pstmt = con.prepareStatement("SELECT  DEC_GS_NO_OF_TOOTH_FOR_Q1,DEC_GS_NO_OF_TOOTH_FOR_Q2,DEC_GS_NO_OF_TOOTH_FOR_Q3, DEC_GS_NO_OF_TOOTH_FOR_Q4, DEC_GS_DFLT_TOOTH_NO_Q1, DEC_GS_DFLT_TOOTH_NO_Q2, DEC_GS_DFLT_TOOTH_NO_Q3, DEC_GS_DFLT_TOOTH_NO_Q4 FROM OH_PARAM WHERE GINGIVAL_RECORDING_BY IS NOT NULL");
					//
					//
					//pstmt.setString(1,facility_id);
					//pstmt.setString(1,tooth_numbering_system);


					rst = pstmt.executeQuery();
					while(rst!= null && rst.next()){
							q1_val = Integer.parseInt(rst.getString("DEC_GS_NO_OF_TOOTH_FOR_Q1"));
							q2_val = Integer.parseInt(rst.getString("DEC_GS_NO_OF_TOOTH_FOR_Q2"));
							q3_val = Integer.parseInt( rst.getString("DEC_GS_NO_OF_TOOTH_FOR_Q3"));
							q4_val = Integer.parseInt(rst.getString("DEC_GS_NO_OF_TOOTH_FOR_Q4"));

							q1_dflt_val = Integer.parseInt(rst.getString("DEC_GS_DFLT_TOOTH_NO_Q1"));
							q2_dflt_val = Integer.parseInt(rst.getString("DEC_GS_DFLT_TOOTH_NO_Q2"));
							q3_dflt_val = Integer.parseInt(rst.getString("DEC_GS_DFLT_TOOTH_NO_Q3"));
							q4_dflt_val = Integer.parseInt(rst.getString("DEC_GS_DFLT_TOOTH_NO_Q4"));
					
						quadrant_no_val.append(q1_val +"##"+q2_val+"##"+q3_val+"##"+q4_val+"##"+q1_dflt_val +"##"+q2_dflt_val+"##"+q3_dflt_val+"##"+q4_dflt_val );
						quadrant_no_val.append("~");
					}
				}
				else{
					//pstmt = con.prepareStatement("SELECT GS_NO_OF_TOOTH_FOR_S1, GS_NO_OF_TOOTH_FOR_S2, GS_NO_OF_TOOTH_FOR_S3, GS_NO_OF_TOOTH_FOR_S4, GS_NO_OF_TOOTH_FOR_S5, GS_NO_OF_TOOTH_FOR_S6, GS_DFLT_TOOTH_NO_S1, GS_DFLT_TOOTH_NO_S2, GS_DFLT_TOOTH_NO_S3, GS_DFLT_TOOTH_NO_S4, GS_DFLT_TOOTH_NO_S5, GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM_FOR_FACILITY  ");
					
					//Commented and Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
					//pstmt = con.prepareStatement("SELECT GS_NO_OF_TOOTH_FOR_S1, GS_NO_OF_TOOTH_FOR_S2, GS_NO_OF_TOOTH_FOR_S3, GS_NO_OF_TOOTH_FOR_S4, GS_NO_OF_TOOTH_FOR_S5, GS_NO_OF_TOOTH_FOR_S6, GS_DFLT_TOOTH_NO_S1, GS_DFLT_TOOTH_NO_S2, GS_DFLT_TOOTH_NO_S3, GS_DFLT_TOOTH_NO_S4, GS_DFLT_TOOTH_NO_S5, GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM_FOR_FACILITY WHERE GINGIVAL_RECORDING_BY IS NOT NULL ");
					//Sharon
					//pstmt = con.prepareStatement("SELECT GS_NO_OF_TOOTH_FOR_S1, GS_NO_OF_TOOTH_FOR_S2, GS_NO_OF_TOOTH_FOR_S3, GS_NO_OF_TOOTH_FOR_S4, GS_NO_OF_TOOTH_FOR_S5, GS_NO_OF_TOOTH_FOR_S6, GS_DFLT_TOOTH_NO_S1, GS_DFLT_TOOTH_NO_S2, GS_DFLT_TOOTH_NO_S3, GS_DFLT_TOOTH_NO_S4, GS_DFLT_TOOTH_NO_S5, GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM_FOR_FACILITY WHERE GINGIVAL_RECORDING_BY IS NOT NULL ");
					pstmt = con.prepareStatement("SELECT DEC_GS_NO_OF_TOOTH_FOR_S1, DEC_GS_NO_OF_TOOTH_FOR_S2, DEC_GS_NO_OF_TOOTH_FOR_S3, DEC_GS_NO_OF_TOOTH_FOR_S4, DEC_GS_NO_OF_TOOTH_FOR_S5, DEC_GS_NO_OF_TOOTH_FOR_S6, DEC_GS_DFLT_TOOTH_NO_S1, DEC_GS_DFLT_TOOTH_NO_S2, DEC_GS_DFLT_TOOTH_NO_S3, DEC_GS_DFLT_TOOTH_NO_S4, DEC_GS_DFLT_TOOTH_NO_S5, DEC_GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM WHERE GINGIVAL_RECORDING_BY IS NOT NULL ");
					//
					//
					//pstmt.setString(1,facility_id);
					//pstmt.setString(2,tooth_numbering_system);

					rst = pstmt.executeQuery();
					while(rst!= null && rst.next()){
							s1_val = Integer.parseInt(rst.getString("DEC_GS_NO_OF_TOOTH_FOR_S1"));
							s2_val = Integer.parseInt(rst.getString("DEC_GS_NO_OF_TOOTH_FOR_S2"));
							s3_val = Integer.parseInt(rst.getString("DEC_GS_NO_OF_TOOTH_FOR_S3"));
							s4_val = Integer.parseInt(rst.getString("DEC_GS_NO_OF_TOOTH_FOR_S4"));
							s5_val = Integer.parseInt(rst.getString("DEC_GS_NO_OF_TOOTH_FOR_S5"));
							s6_val = Integer.parseInt(rst.getString("DEC_GS_NO_OF_TOOTH_FOR_S6"));

							s1_dflt_val = Integer.parseInt(rst.getString("DEC_GS_DFLT_TOOTH_NO_S1"));
							s2_dflt_val = Integer.parseInt(rst.getString("DEC_GS_DFLT_TOOTH_NO_S2"));
							s3_dflt_val = Integer.parseInt(rst.getString("DEC_GS_DFLT_TOOTH_NO_S3"));
							s4_dflt_val = Integer.parseInt(rst.getString("DEC_GS_DFLT_TOOTH_NO_S4"));
							s5_dflt_val = Integer.parseInt(rst.getString("DEC_GS_DFLT_TOOTH_NO_S5"));
							s6_dflt_val = Integer.parseInt(rst.getString("DEC_GS_DFLT_TOOTH_NO_S6"));
						
						quadrant_no_val.append(s1_val+"##"+s2_val+"##"+s3_val+"##"+s4_val+"##"+s5_val+"##"+s6_val+"##"+s1_dflt_val+"##"+s2_dflt_val+"##"+s3_dflt_val+"##"+s4_dflt_val+"##"+s5_dflt_val+"##"+s6_dflt_val);
					//	quadrant_no_val.append("~");
					}
				}
			}else{
				if(gingival_recording_by.equals("Q")){
				// below all queries are commented and added "where gingival_recording_by is not null" by parul on 7/13/2009 becoz if record is having null value it should not raise null pointer exception.
					//pstmt = con.prepareStatement("SELECT  GS_NO_OF_TOOTH_FOR_Q1,GS_NO_OF_TOOTH_FOR_Q2,GS_NO_OF_TOOTH_FOR_Q3, GS_NO_OF_TOOTH_FOR_Q4, GS_DFLT_TOOTH_NO_Q1, GS_DFLT_TOOTH_NO_Q2, GS_DFLT_TOOTH_NO_Q3, GS_DFLT_TOOTH_NO_Q4 FROM OH_PARAM_FOR_FACILITY");
					
					//Commented and Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
					//pstmt = con.prepareStatement("SELECT  GS_NO_OF_TOOTH_FOR_Q1,GS_NO_OF_TOOTH_FOR_Q2,GS_NO_OF_TOOTH_FOR_Q3, GS_NO_OF_TOOTH_FOR_Q4, GS_DFLT_TOOTH_NO_Q1, GS_DFLT_TOOTH_NO_Q2, GS_DFLT_TOOTH_NO_Q3, GS_DFLT_TOOTH_NO_Q4 FROM OH_PARAM_FOR_FACILITY WHERE GINGIVAL_RECORDING_BY IS NOT NULL");
					//Sharon
					//pstmt = con.prepareStatement("SELECT  GS_NO_OF_TOOTH_FOR_Q1,GS_NO_OF_TOOTH_FOR_Q2,GS_NO_OF_TOOTH_FOR_Q3, GS_NO_OF_TOOTH_FOR_Q4, GS_DFLT_TOOTH_NO_Q1, GS_DFLT_TOOTH_NO_Q2, GS_DFLT_TOOTH_NO_Q3, GS_DFLT_TOOTH_NO_Q4 FROM OH_PARAM WHERE GINGIVAL_RECORDING_BY IS NOT NULL");
					pstmt = con.prepareStatement("SELECT  MD_GS_NO_OF_TOOTH_FOR_Q1,MD_GS_NO_OF_TOOTH_FOR_Q2,MD_GS_NO_OF_TOOTH_FOR_Q3, MD_GS_NO_OF_TOOTH_FOR_Q4, MD_GS_DFLT_TOOTH_NO_Q1, MD_GS_DFLT_TOOTH_NO_Q2, MD_GS_DFLT_TOOTH_NO_Q3, MD_GS_DFLT_TOOTH_NO_Q4 FROM OH_PARAM WHERE GINGIVAL_RECORDING_BY IS NOT NULL");
					//
					//
					//pstmt.setString(1,facility_id);
					//pstmt.setString(1,tooth_numbering_system);


					rst = pstmt.executeQuery();
					while(rst!= null && rst.next()){
							q1_val = Integer.parseInt(rst.getString("MD_GS_NO_OF_TOOTH_FOR_Q1"));
							q2_val = Integer.parseInt(rst.getString("MD_GS_NO_OF_TOOTH_FOR_Q2"));
							q3_val = Integer.parseInt(rst.getString("MD_GS_NO_OF_TOOTH_FOR_Q3"));
							q4_val = Integer.parseInt(rst.getString("MD_GS_NO_OF_TOOTH_FOR_Q4"));

							/*q1_dflt_val = Integer.parseInt(rst.getString("MD_GS_DFLT_TOOTH_NO_Q1"));
							q2_dflt_val = Integer.parseInt(rst.getString("MD_GS_DFLT_TOOTH_NO_Q2"));
							q3_dflt_val = Integer.parseInt(rst.getString("MD_GS_DFLT_TOOTH_NO_Q3"));
							q4_dflt_val = Integer.parseInt(rst.getString("MD_GS_DFLT_TOOTH_NO_Q4")); */

							md_q1_dflt_val = rst.getString("MD_GS_DFLT_TOOTH_NO_Q1");
							md_q2_dflt_val = rst.getString("MD_GS_DFLT_TOOTH_NO_Q2");
							md_q3_dflt_val = rst.getString("MD_GS_DFLT_TOOTH_NO_Q3");
							md_q4_dflt_val = rst.getString("MD_GS_DFLT_TOOTH_NO_Q4");
							
							if(md_q1_dflt_val != "" && md_q1_dflt_val != null && md_q1_dflt_val != "null")
							{
								q1_dflt_val = Integer.parseInt(md_q1_dflt_val);	
							}								
							if(md_q2_dflt_val != "" && md_q2_dflt_val != null && md_q2_dflt_val != "null")
							{
								q2_dflt_val = Integer.parseInt(md_q2_dflt_val);
							}
							if(md_q3_dflt_val != "" && md_q3_dflt_val != null && md_q3_dflt_val != "null")
							{
								q3_dflt_val = Integer.parseInt(md_q3_dflt_val);
							}
							if(md_q4_dflt_val != "" && md_q4_dflt_val != null && md_q4_dflt_val != "null")
							{
								q4_dflt_val = Integer.parseInt(md_q4_dflt_val); 							
							}
						
						quadrant_no_val.append(q1_val +"##"+q2_val+"##"+q3_val+"##"+q4_val+"##"+q1_dflt_val +"##"+q2_dflt_val+"##"+q3_dflt_val+"##"+q4_dflt_val );
					//	quadrant_no_val.append("~");

					}
				}
				else{
					//pstmt = con.prepareStatement("SELECT GS_NO_OF_TOOTH_FOR_S1, GS_NO_OF_TOOTH_FOR_S2, GS_NO_OF_TOOTH_FOR_S3, GS_NO_OF_TOOTH_FOR_S4, GS_NO_OF_TOOTH_FOR_S5, GS_NO_OF_TOOTH_FOR_S6, GS_DFLT_TOOTH_NO_S1, GS_DFLT_TOOTH_NO_S2, GS_DFLT_TOOTH_NO_S3, GS_DFLT_TOOTH_NO_S4, GS_DFLT_TOOTH_NO_S5, GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM_FOR_FACILITY  ");
					
					//Commented and Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
					//pstmt = con.prepareStatement("SELECT GS_NO_OF_TOOTH_FOR_S1, GS_NO_OF_TOOTH_FOR_S2, GS_NO_OF_TOOTH_FOR_S3, GS_NO_OF_TOOTH_FOR_S4, GS_NO_OF_TOOTH_FOR_S5, GS_NO_OF_TOOTH_FOR_S6, GS_DFLT_TOOTH_NO_S1, GS_DFLT_TOOTH_NO_S2, GS_DFLT_TOOTH_NO_S3, GS_DFLT_TOOTH_NO_S4, GS_DFLT_TOOTH_NO_S5, GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM_FOR_FACILITY WHERE GINGIVAL_RECORDING_BY IS NOT NULL ");
					//Sharon
					//pstmt = con.prepareStatement("SELECT GS_NO_OF_TOOTH_FOR_S1, GS_NO_OF_TOOTH_FOR_S2, GS_NO_OF_TOOTH_FOR_S3, GS_NO_OF_TOOTH_FOR_S4, GS_NO_OF_TOOTH_FOR_S5, GS_NO_OF_TOOTH_FOR_S6, GS_DFLT_TOOTH_NO_S1, GS_DFLT_TOOTH_NO_S2, GS_DFLT_TOOTH_NO_S3, GS_DFLT_TOOTH_NO_S4, GS_DFLT_TOOTH_NO_S5, GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM WHERE GINGIVAL_RECORDING_BY IS NOT NULL ");
					pstmt = con.prepareStatement("SELECT MD_GS_NO_OF_TOOTH_FOR_S1, MD_GS_NO_OF_TOOTH_FOR_S2, MD_GS_NO_OF_TOOTH_FOR_S3, MD_GS_NO_OF_TOOTH_FOR_S4, MD_GS_NO_OF_TOOTH_FOR_S5, MD_GS_NO_OF_TOOTH_FOR_S6, MD_GS_DFLT_TOOTH_NO_S1, MD_GS_DFLT_TOOTH_NO_S2, MD_GS_DFLT_TOOTH_NO_S3, MD_GS_DFLT_TOOTH_NO_S4, MD_GS_DFLT_TOOTH_NO_S5, MD_GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM WHERE GINGIVAL_RECORDING_BY IS NOT NULL ");
					//
					//pstmt.setString(1,facility_id);
					//pstmt.setString(2,tooth_numbering_system);

					rst = pstmt.executeQuery();
					while(rst!= null && rst.next()){
							s1_val = Integer.parseInt(rst.getString("MD_GS_NO_OF_TOOTH_FOR_S1"));
							s2_val = Integer.parseInt(rst.getString("MD_GS_NO_OF_TOOTH_FOR_S2"));
							s3_val = Integer.parseInt(rst.getString("MD_GS_NO_OF_TOOTH_FOR_S3"));
							s4_val = Integer.parseInt(rst.getString("MD_GS_NO_OF_TOOTH_FOR_S4"));
							s5_val = Integer.parseInt(rst.getString("MD_GS_NO_OF_TOOTH_FOR_S5"));
							s6_val = Integer.parseInt(rst.getString("MD_GS_NO_OF_TOOTH_FOR_S6"));

							/*s1_dflt_val = Integer.parseInt(rst.getString("MD_GS_DFLT_TOOTH_NO_S1"));
							s2_dflt_val = Integer.parseInt(rst.getString("MD_GS_DFLT_TOOTH_NO_S2"));
							s3_dflt_val = Integer.parseInt(rst.getString("MD_GS_DFLT_TOOTH_NO_S3"));
							s4_dflt_val = Integer.parseInt(rst.getString("MD_GS_DFLT_TOOTH_NO_S4"));
							s5_dflt_val = Integer.parseInt(rst.getString("MD_GS_DFLT_TOOTH_NO_S5"));
							s6_dflt_val = Integer.parseInt(rst.getString("MD_GS_DFLT_TOOTH_NO_S6"));*/
							
							md_s1_dflt_val = rst.getString("MD_GS_DFLT_TOOTH_NO_S1");
							md_s2_dflt_val = rst.getString("MD_GS_DFLT_TOOTH_NO_S2");
							md_s3_dflt_val = rst.getString("MD_GS_DFLT_TOOTH_NO_S3");
							md_s4_dflt_val = rst.getString("MD_GS_DFLT_TOOTH_NO_S4");
							md_s5_dflt_val = rst.getString("MD_GS_DFLT_TOOTH_NO_S5");
							md_s6_dflt_val = rst.getString("MD_GS_DFLT_TOOTH_NO_S6");

														
							if(md_s1_dflt_val != "" && md_s1_dflt_val != null && md_s1_dflt_val != "null")
							{
								s1_dflt_val = Integer.parseInt(md_s1_dflt_val);	
							}								
							if(md_s2_dflt_val != "" && md_s2_dflt_val != null && md_s2_dflt_val != "null")
							{
								s2_dflt_val = Integer.parseInt(md_s2_dflt_val);
							}
							if(md_s3_dflt_val != "" && md_s3_dflt_val != null && md_s3_dflt_val != "null")
							{
								s3_dflt_val = Integer.parseInt(md_s3_dflt_val);
							}
							if(md_s4_dflt_val != "" && md_s4_dflt_val != null && md_s4_dflt_val != "null")
							{
								s4_dflt_val = Integer.parseInt(md_s4_dflt_val); 							
							}
							if(md_s5_dflt_val != "" && md_s5_dflt_val != null && md_s5_dflt_val != "null")
							{
								s5_dflt_val = Integer.parseInt(md_s5_dflt_val); 							
							}
							if(md_s6_dflt_val != "" && md_s6_dflt_val != null && md_s6_dflt_val != "null")
							{
								s6_dflt_val = Integer.parseInt(md_s6_dflt_val); 							
							}
					
						quadrant_no_val.append(s1_val+"##"+s2_val+"##"+s3_val+"##"+s4_val+"##"+s5_val+"##"+s6_val+"##"+s1_dflt_val+"##"+s2_dflt_val+"##"+s3_dflt_val+"##"+s4_dflt_val+"##"+s5_dflt_val+"##"+s6_dflt_val);
					//	quadrant_no_val.append("~");
					}
				}
			}
		}else{
			if(chart_type.equals("RA")){
				if(gingival_recording_by.equals("Q")) {
					//	pstmt = con.prepareStatement("SELECT  GS_NO_OF_TOOTH_FOR_Q1,GS_NO_OF_TOOTH_FOR_Q2,GS_NO_OF_TOOTH_FOR_Q3, GS_NO_OF_TOOTH_FOR_Q4, GS_DFLT_TOOTH_NO_Q1, GS_DFLT_TOOTH_NO_Q2, GS_DFLT_TOOTH_NO_Q3, GS_DFLT_TOOTH_NO_Q4 FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=?");
					pstmt = con.prepareStatement("SELECT  GS_NO_OF_TOOTH_FOR_Q1,GS_NO_OF_TOOTH_FOR_Q2,GS_NO_OF_TOOTH_FOR_Q3, GS_NO_OF_TOOTH_FOR_Q4, GS_DFLT_TOOTH_NO_Q1, GS_DFLT_TOOTH_NO_Q2, GS_DFLT_TOOTH_NO_Q3, GS_DFLT_TOOTH_NO_Q4 FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=? AND GINGIVAL_RECORDING_BY IS NOT NULL");
					pstmt.setString(1,other_chart_facility_id);
					//pstmt.setString(2,tooth_numbering_system);

					rst = pstmt.executeQuery();
					while(rst!= null && rst.next()){
							q1_val = Integer.parseInt(rst.getString("GS_NO_OF_TOOTH_FOR_Q1"));
							q2_val = Integer.parseInt(rst.getString("GS_NO_OF_TOOTH_FOR_Q2"));
							q3_val = Integer.parseInt( rst.getString("GS_NO_OF_TOOTH_FOR_Q3"));
							q4_val = Integer.parseInt(rst.getString("GS_NO_OF_TOOTH_FOR_Q4"));

							q1_dflt_val = Integer.parseInt(rst.getString("GS_DFLT_TOOTH_NO_Q1"));
							q2_dflt_val = Integer.parseInt(rst.getString("GS_DFLT_TOOTH_NO_Q2"));
							q3_dflt_val = Integer.parseInt(rst.getString("GS_DFLT_TOOTH_NO_Q3"));
							q4_dflt_val = Integer.parseInt(rst.getString("GS_DFLT_TOOTH_NO_Q4"));
						
						quadrant_no_val.append(q1_val +"##"+q2_val+"##"+q3_val+"##"+q4_val+"##"+q1_dflt_val +"##"+q2_dflt_val+"##"+q3_dflt_val+"##"+q4_dflt_val );
						//quadrant_no_val.append("~");
					}
				}
				else{
				//	pstmt = con.prepareStatement("SELECT GS_NO_OF_TOOTH_FOR_S1, GS_NO_OF_TOOTH_FOR_S2, GS_NO_OF_TOOTH_FOR_S3, GS_NO_OF_TOOTH_FOR_S4, GS_NO_OF_TOOTH_FOR_S5, GS_NO_OF_TOOTH_FOR_S6, GS_DFLT_TOOTH_NO_S1, GS_DFLT_TOOTH_NO_S2, GS_DFLT_TOOTH_NO_S3, GS_DFLT_TOOTH_NO_S4, GS_DFLT_TOOTH_NO_S5, GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=? ");
					pstmt = con.prepareStatement("SELECT GS_NO_OF_TOOTH_FOR_S1, GS_NO_OF_TOOTH_FOR_S2, GS_NO_OF_TOOTH_FOR_S3, GS_NO_OF_TOOTH_FOR_S4, GS_NO_OF_TOOTH_FOR_S5, GS_NO_OF_TOOTH_FOR_S6, GS_DFLT_TOOTH_NO_S1, GS_DFLT_TOOTH_NO_S2, GS_DFLT_TOOTH_NO_S3, GS_DFLT_TOOTH_NO_S4, GS_DFLT_TOOTH_NO_S5, GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=? AND GINGIVAL_RECORDING_BY IS NOT NULL");
					pstmt.setString(1,other_chart_facility_id);
					//pstmt.setString(2,tooth_numbering_system);

					rst = pstmt.executeQuery();
					while(rst!= null && rst.next()){
							s1_val = Integer.parseInt(rst.getString("GS_NO_OF_TOOTH_FOR_S1"));
							s2_val = Integer.parseInt(rst.getString("GS_NO_OF_TOOTH_FOR_S2"));
							s3_val = Integer.parseInt(rst.getString("GS_NO_OF_TOOTH_FOR_S3"));
							s4_val = Integer.parseInt(rst.getString("GS_NO_OF_TOOTH_FOR_S4"));
							s5_val = Integer.parseInt(rst.getString("GS_NO_OF_TOOTH_FOR_S5"));
							s6_val = Integer.parseInt(rst.getString("GS_NO_OF_TOOTH_FOR_S6"));

							s1_dflt_val = Integer.parseInt(rst.getString("GS_DFLT_TOOTH_NO_S1"));
							s2_dflt_val = Integer.parseInt(rst.getString("GS_DFLT_TOOTH_NO_S2"));
							s3_dflt_val = Integer.parseInt(rst.getString("GS_DFLT_TOOTH_NO_S3"));
							s4_dflt_val = Integer.parseInt(rst.getString("GS_DFLT_TOOTH_NO_S4"));
							s5_dflt_val = Integer.parseInt(rst.getString("GS_DFLT_TOOTH_NO_S5"));
							s6_dflt_val = Integer.parseInt(rst.getString("GS_DFLT_TOOTH_NO_S6"));
						
						quadrant_no_val.append(s1_val+"##"+s2_val+"##"+s3_val+"##"+s4_val+"##"+s5_val+"##"+s6_val+"##"+s1_dflt_val+"##"+s2_dflt_val+"##"+s3_dflt_val+"##"+s4_dflt_val+"##"+s5_dflt_val+"##"+s6_dflt_val);
						//quadrant_no_val.append("~");
					}
				}
			}else if(chart_type.equals("RD")){
					if(gingival_recording_by.equals("Q")) {
					//	pstmt = con.prepareStatement("SELECT  GS_NO_OF_TOOTH_FOR_Q1,GS_NO_OF_TOOTH_FOR_Q2,GS_NO_OF_TOOTH_FOR_Q3, GS_NO_OF_TOOTH_FOR_Q4, GS_DFLT_TOOTH_NO_Q1, GS_DFLT_TOOTH_NO_Q2, GS_DFLT_TOOTH_NO_Q3, GS_DFLT_TOOTH_NO_Q4 FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=?");
					//Sharon
					//pstmt = con.prepareStatement("SELECT  GS_NO_OF_TOOTH_FOR_Q1,GS_NO_OF_TOOTH_FOR_Q2,GS_NO_OF_TOOTH_FOR_Q3, GS_NO_OF_TOOTH_FOR_Q4, GS_DFLT_TOOTH_NO_Q1, GS_DFLT_TOOTH_NO_Q2, GS_DFLT_TOOTH_NO_Q3, GS_DFLT_TOOTH_NO_Q4 FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=? AND GINGIVAL_RECORDING_BY IS NOT NULL");
					pstmt = con.prepareStatement("SELECT  DEC_GS_NO_OF_TOOTH_FOR_Q1,DEC_GS_NO_OF_TOOTH_FOR_Q2,DEC_GS_NO_OF_TOOTH_FOR_Q3, DEC_GS_NO_OF_TOOTH_FOR_Q4, DEC_GS_DFLT_TOOTH_NO_Q1, DEC_GS_DFLT_TOOTH_NO_Q2, DEC_GS_DFLT_TOOTH_NO_Q3, DEC_GS_DFLT_TOOTH_NO_Q4 FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=? AND GINGIVAL_RECORDING_BY IS NOT NULL");
					pstmt.setString(1,other_chart_facility_id);
					//pstmt.setString(2,tooth_numbering_system);

					rst = pstmt.executeQuery();
					while(rst!= null && rst.next()){
							q1_val = Integer.parseInt(rst.getString("DEC_GS_NO_OF_TOOTH_FOR_Q1"));
							q2_val = Integer.parseInt(rst.getString("DEC_GS_NO_OF_TOOTH_FOR_Q2"));
							q3_val = Integer.parseInt( rst.getString("DEC_GS_NO_OF_TOOTH_FOR_Q3"));
							q4_val = Integer.parseInt(rst.getString("DEC_GS_NO_OF_TOOTH_FOR_Q4"));

							q1_dflt_val = Integer.parseInt(rst.getString("DEC_GS_DFLT_TOOTH_NO_Q1"));
							q2_dflt_val = Integer.parseInt(rst.getString("DEC_GS_DFLT_TOOTH_NO_Q2"));
							q3_dflt_val = Integer.parseInt(rst.getString("DEC_GS_DFLT_TOOTH_NO_Q3"));
							q4_dflt_val = Integer.parseInt(rst.getString("DEC_GS_DFLT_TOOTH_NO_Q4"));
						
						quadrant_no_val.append(q1_val +"##"+q2_val+"##"+q3_val+"##"+q4_val+"##"+q1_dflt_val +"##"+q2_dflt_val+"##"+q3_dflt_val+"##"+q4_dflt_val );
						//quadrant_no_val.append("~");
					}
				}
				else{
				//	pstmt = con.prepareStatement("SELECT GS_NO_OF_TOOTH_FOR_S1, GS_NO_OF_TOOTH_FOR_S2, GS_NO_OF_TOOTH_FOR_S3, GS_NO_OF_TOOTH_FOR_S4, GS_NO_OF_TOOTH_FOR_S5, GS_NO_OF_TOOTH_FOR_S6, GS_DFLT_TOOTH_NO_S1, GS_DFLT_TOOTH_NO_S2, GS_DFLT_TOOTH_NO_S3, GS_DFLT_TOOTH_NO_S4, GS_DFLT_TOOTH_NO_S5, GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=? ");
				//Sharon
					//pstmt = con.prepareStatement("SELECT GS_NO_OF_TOOTH_FOR_S1, GS_NO_OF_TOOTH_FOR_S2, GS_NO_OF_TOOTH_FOR_S3, GS_NO_OF_TOOTH_FOR_S4, GS_NO_OF_TOOTH_FOR_S5, GS_NO_OF_TOOTH_FOR_S6, GS_DFLT_TOOTH_NO_S1, GS_DFLT_TOOTH_NO_S2, GS_DFLT_TOOTH_NO_S3, GS_DFLT_TOOTH_NO_S4, GS_DFLT_TOOTH_NO_S5, GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=? AND GINGIVAL_RECORDING_BY IS NOT NULL");
					pstmt = con.prepareStatement("SELECT DEC_GS_NO_OF_TOOTH_FOR_S1, DEC_GS_NO_OF_TOOTH_FOR_S2, DEC_GS_NO_OF_TOOTH_FOR_S3, DEC_GS_NO_OF_TOOTH_FOR_S4, DEC_GS_NO_OF_TOOTH_FOR_S5, DEC_GS_NO_OF_TOOTH_FOR_S6, DEC_GS_DFLT_TOOTH_NO_S1, DEC_GS_DFLT_TOOTH_NO_S2, DEC_GS_DFLT_TOOTH_NO_S3, DEC_GS_DFLT_TOOTH_NO_S4, DEC_GS_DFLT_TOOTH_NO_S5, DEC_GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=? AND GINGIVAL_RECORDING_BY IS NOT NULL");
					pstmt.setString(1,other_chart_facility_id);
					//pstmt.setString(2,tooth_numbering_system);

					rst = pstmt.executeQuery();
					while(rst!= null && rst.next()){
							s1_val = Integer.parseInt(rst.getString("DEC_GS_NO_OF_TOOTH_FOR_S1"));
							s2_val = Integer.parseInt(rst.getString("DEC_GS_NO_OF_TOOTH_FOR_S2"));
							s3_val = Integer.parseInt(rst.getString("DEC_GS_NO_OF_TOOTH_FOR_S3"));
							s4_val = Integer.parseInt(rst.getString("DEC_GS_NO_OF_TOOTH_FOR_S4"));
							s5_val = Integer.parseInt(rst.getString("DEC_GS_NO_OF_TOOTH_FOR_S5"));
							s6_val = Integer.parseInt(rst.getString("DEC_GS_NO_OF_TOOTH_FOR_S6"));

							s1_dflt_val = Integer.parseInt(rst.getString("DEC_GS_DFLT_TOOTH_NO_S1"));
							s2_dflt_val = Integer.parseInt(rst.getString("DEC_GS_DFLT_TOOTH_NO_S2"));
							s3_dflt_val = Integer.parseInt(rst.getString("DEC_GS_DFLT_TOOTH_NO_S3"));
							s4_dflt_val = Integer.parseInt(rst.getString("DEC_GS_DFLT_TOOTH_NO_S4"));
							s5_dflt_val = Integer.parseInt(rst.getString("DEC_GS_DFLT_TOOTH_NO_S5"));
							s6_dflt_val = Integer.parseInt(rst.getString("DEC_GS_DFLT_TOOTH_NO_S6"));
						
						quadrant_no_val.append(s1_val+"##"+s2_val+"##"+s3_val+"##"+s4_val+"##"+s5_val+"##"+s6_val+"##"+s1_dflt_val+"##"+s2_dflt_val+"##"+s3_dflt_val+"##"+s4_dflt_val+"##"+s5_dflt_val+"##"+s6_dflt_val);
						//quadrant_no_val.append("~");
					}
				}	
			}else{
				if(gingival_recording_by.equals("Q")) {
					//	pstmt = con.prepareStatement("SELECT  GS_NO_OF_TOOTH_FOR_Q1,GS_NO_OF_TOOTH_FOR_Q2,GS_NO_OF_TOOTH_FOR_Q3, GS_NO_OF_TOOTH_FOR_Q4, GS_DFLT_TOOTH_NO_Q1, GS_DFLT_TOOTH_NO_Q2, GS_DFLT_TOOTH_NO_Q3, GS_DFLT_TOOTH_NO_Q4 FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=?");
					//Sharon
					//pstmt = con.prepareStatement("SELECT  GS_NO_OF_TOOTH_FOR_Q1,GS_NO_OF_TOOTH_FOR_Q2,GS_NO_OF_TOOTH_FOR_Q3, GS_NO_OF_TOOTH_FOR_Q4, GS_DFLT_TOOTH_NO_Q1, GS_DFLT_TOOTH_NO_Q2, GS_DFLT_TOOTH_NO_Q3, GS_DFLT_TOOTH_NO_Q4 FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=? AND GINGIVAL_RECORDING_BY IS NOT NULL");
					pstmt = con.prepareStatement("SELECT  MD_GS_NO_OF_TOOTH_FOR_Q1,MD_GS_NO_OF_TOOTH_FOR_Q2,MD_GS_NO_OF_TOOTH_FOR_Q3, MD_GS_NO_OF_TOOTH_FOR_Q4, MD_GS_DFLT_TOOTH_NO_Q1, MD_GS_DFLT_TOOTH_NO_Q2, MD_GS_DFLT_TOOTH_NO_Q3, MD_GS_DFLT_TOOTH_NO_Q4 FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=? AND GINGIVAL_RECORDING_BY IS NOT NULL");
					pstmt.setString(1,other_chart_facility_id);
					//pstmt.setString(2,tooth_numbering_system);

					rst = pstmt.executeQuery();
					while(rst!= null && rst.next()){
							q1_val = Integer.parseInt(rst.getString("MD_GS_NO_OF_TOOTH_FOR_Q1"));
							q2_val = Integer.parseInt(rst.getString("MD_GS_NO_OF_TOOTH_FOR_Q2"));
							q3_val = Integer.parseInt( rst.getString("MD_GS_NO_OF_TOOTH_FOR_Q3"));
							q4_val = Integer.parseInt(rst.getString("MD_GS_NO_OF_TOOTH_FOR_Q4"));

							/*q1_dflt_val = Integer.parseInt(rst.getString("MD_GS_DFLT_TOOTH_NO_Q1"));
							q2_dflt_val = Integer.parseInt(rst.getString("MD_GS_DFLT_TOOTH_NO_Q2"));
							q3_dflt_val = Integer.parseInt(rst.getString("MD_GS_DFLT_TOOTH_NO_Q3"));
							q4_dflt_val = Integer.parseInt(rst.getString("MD_GS_DFLT_TOOTH_NO_Q4"));  */
							
							md_q1_dflt_val = rst.getString("MD_GS_DFLT_TOOTH_NO_Q1");
							md_q2_dflt_val = rst.getString("MD_GS_DFLT_TOOTH_NO_Q2");
							md_q3_dflt_val = rst.getString("MD_GS_DFLT_TOOTH_NO_Q3");
							md_q4_dflt_val = rst.getString("MD_GS_DFLT_TOOTH_NO_Q4");
							
							if(md_q1_dflt_val != "" && md_q1_dflt_val != null && md_q1_dflt_val != "null")
							{
								q1_dflt_val = Integer.parseInt(md_q1_dflt_val);	
							}								
							if(md_q2_dflt_val != "" && md_q2_dflt_val != null && md_q2_dflt_val != "null")
							{
								q2_dflt_val = Integer.parseInt(md_q2_dflt_val);
							}
							if(md_q3_dflt_val != "" && md_q3_dflt_val != null && md_q3_dflt_val != "null")
							{
								q3_dflt_val = Integer.parseInt(md_q3_dflt_val);
							}
							if(md_q4_dflt_val != "" && md_q4_dflt_val != null && md_q4_dflt_val != "null")
							{
								q4_dflt_val = Integer.parseInt(md_q4_dflt_val); 							
							}
						
						quadrant_no_val.append(q1_val +"##"+q2_val+"##"+q3_val+"##"+q4_val+"##"+q1_dflt_val +"##"+q2_dflt_val+"##"+q3_dflt_val+"##"+q4_dflt_val );
						//quadrant_no_val.append("~");
					}
				}
				else{
				//	pstmt = con.prepareStatement("SELECT GS_NO_OF_TOOTH_FOR_S1, GS_NO_OF_TOOTH_FOR_S2, GS_NO_OF_TOOTH_FOR_S3, GS_NO_OF_TOOTH_FOR_S4, GS_NO_OF_TOOTH_FOR_S5, GS_NO_OF_TOOTH_FOR_S6, GS_DFLT_TOOTH_NO_S1, GS_DFLT_TOOTH_NO_S2, GS_DFLT_TOOTH_NO_S3, GS_DFLT_TOOTH_NO_S4, GS_DFLT_TOOTH_NO_S5, GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=? ");
					//Sharon
					//pstmt = con.prepareStatement("SELECT GS_NO_OF_TOOTH_FOR_S1, GS_NO_OF_TOOTH_FOR_S2, GS_NO_OF_TOOTH_FOR_S3, GS_NO_OF_TOOTH_FOR_S4, GS_NO_OF_TOOTH_FOR_S5, GS_NO_OF_TOOTH_FOR_S6, GS_DFLT_TOOTH_NO_S1, GS_DFLT_TOOTH_NO_S2, GS_DFLT_TOOTH_NO_S3, GS_DFLT_TOOTH_NO_S4, GS_DFLT_TOOTH_NO_S5, GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=? AND GINGIVAL_RECORDING_BY IS NOT NULL");
					pstmt = con.prepareStatement("SELECT MD_GS_NO_OF_TOOTH_FOR_S1, MD_GS_NO_OF_TOOTH_FOR_S2, MD_GS_NO_OF_TOOTH_FOR_S3, MD_GS_NO_OF_TOOTH_FOR_S4, MD_GS_NO_OF_TOOTH_FOR_S5, MD_GS_NO_OF_TOOTH_FOR_S6, MD_GS_DFLT_TOOTH_NO_S1, MD_GS_DFLT_TOOTH_NO_S2, MD_GS_DFLT_TOOTH_NO_S3, MD_GS_DFLT_TOOTH_NO_S4, MD_GS_DFLT_TOOTH_NO_S5, MD_GS_DFLT_TOOTH_NO_S6 FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=? AND GINGIVAL_RECORDING_BY IS NOT NULL");
					pstmt.setString(1,other_chart_facility_id);
					//pstmt.setString(2,tooth_numbering_system);

					rst = pstmt.executeQuery();
					while(rst!= null && rst.next()){
							s1_val = Integer.parseInt(rst.getString("MD_GS_NO_OF_TOOTH_FOR_S1"));
							s2_val = Integer.parseInt(rst.getString("MD_GS_NO_OF_TOOTH_FOR_S2"));
							s3_val = Integer.parseInt(rst.getString("MD_GS_NO_OF_TOOTH_FOR_S3"));
							s4_val = Integer.parseInt(rst.getString("MD_GS_NO_OF_TOOTH_FOR_S4"));
							s5_val = Integer.parseInt(rst.getString("MD_GS_NO_OF_TOOTH_FOR_S5"));
							s6_val = Integer.parseInt(rst.getString("MD_GS_NO_OF_TOOTH_FOR_S6"));

							/*s1_dflt_val = Integer.parseInt(rst.getString("MD_GS_DFLT_TOOTH_NO_S1"));
							s2_dflt_val = Integer.parseInt(rst.getString("MD_GS_DFLT_TOOTH_NO_S2"));
							s3_dflt_val = Integer.parseInt(rst.getString("MD_GS_DFLT_TOOTH_NO_S3"));
							s4_dflt_val = Integer.parseInt(rst.getString("MD_GS_DFLT_TOOTH_NO_S4"));
							s5_dflt_val = Integer.parseInt(rst.getString("MD_GS_DFLT_TOOTH_NO_S5"));
							s6_dflt_val = Integer.parseInt(rst.getString("MD_GS_DFLT_TOOTH_NO_S6"));*/
							
							md_s1_dflt_val = rst.getString("MD_GS_DFLT_TOOTH_NO_S1");
							md_s2_dflt_val = rst.getString("MD_GS_DFLT_TOOTH_NO_S2");
							md_s3_dflt_val = rst.getString("MD_GS_DFLT_TOOTH_NO_S3");
							md_s4_dflt_val = rst.getString("MD_GS_DFLT_TOOTH_NO_S4");
							md_s5_dflt_val = rst.getString("MD_GS_DFLT_TOOTH_NO_S5");
							md_s6_dflt_val = rst.getString("MD_GS_DFLT_TOOTH_NO_S6");

														
							if(md_s1_dflt_val != "" && md_s1_dflt_val != null && md_s1_dflt_val != "null")
							{
								s1_dflt_val = Integer.parseInt(md_s1_dflt_val);	
							}								
							if(md_s2_dflt_val != "" && md_s2_dflt_val != null && md_s2_dflt_val != "null")
							{
								s2_dflt_val = Integer.parseInt(md_s2_dflt_val);
							}
							if(md_s3_dflt_val != "" && md_s3_dflt_val != null && md_s3_dflt_val != "null")
							{
								s3_dflt_val = Integer.parseInt(md_s3_dflt_val);
							}
							if(md_s4_dflt_val != "" && md_s4_dflt_val != null && md_s4_dflt_val != "null")
							{
								s4_dflt_val = Integer.parseInt(md_s4_dflt_val); 							
							}
							if(md_s5_dflt_val != "" && md_s5_dflt_val != null && md_s5_dflt_val != "null")
							{
								s5_dflt_val = Integer.parseInt(md_s5_dflt_val); 							
							}
							if(md_s6_dflt_val != "" && md_s6_dflt_val != null && md_s6_dflt_val != "null")
							{
								s6_dflt_val = Integer.parseInt(md_s6_dflt_val); 							
							}
							
					
						quadrant_no_val.append(s1_val+"##"+s2_val+"##"+s3_val+"##"+s4_val+"##"+s5_val+"##"+s6_val+"##"+s1_dflt_val+"##"+s2_dflt_val+"##"+s3_dflt_val+"##"+s4_dflt_val+"##"+s5_dflt_val+"##"+s6_dflt_val);
						//quadrant_no_val.append("~");
					}
				}
			}
		}
		out.println(quadrant_no_val);
	}
	else if(func_mode.equalsIgnoreCase("checkForMissingTooth")){	
		String patient_id = checkForNull(request.getParameter("patient_id")) ;
		String chart_num = checkForNull(request.getParameter("chart_num")) ;
		String dflt_tooth = checkForNull(request.getParameter("dflt_tooth")) ;
		String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system")) ;
		String oh_chart_level = checkForNull(request.getParameter("oh_chart_level")) ;
		String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id")) ;
		String missing_tooth_yn = "N";
		String display_tooth_no = "";
		//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
		String mixed_dentition_YN = checkForNull(request.getParameter("mixed_dentition_YN")) ;
		String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag")) ;
		String erupted_tooth_yn = "N";
		String condition_type = "";
		String super_yn = "";
		String MD_yn = "";
		String exfolth_yn = "N";
		String decith_yn = "N";
		String status = "";
		String mapped_tooth_no = "";
		String exfolth_RD = "";
		String treatment_type = "";
		String super_exfol_deci_tooth = "";

		//
		if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
	if (oh_chart_level.equals("E")){
		//Commented by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
		//Added ERUPTH
		//pstmt = con.prepareStatement("SELECT CONDITION_TYPE,(SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE TOOTH_NO = ? AND NUMBERING_SYSTEM = ?) DISPLAY_TOOTH_NO FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE IN ('MISSTH','EXFOLTH') AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E'");
		//pstmt = con.prepareStatement("SELECT A.CONDITION_TYPE, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN,(SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE TOOTH_NO = ? AND NUMBERING_SYSTEM = ?) DISPLAY_TOOTH_NO , (SELECT B.MAPPED_TOOTH_NO FROM OH_TOOTH B WHERE A.TOOTH_NO = B.TOOTH_NO) MAPPED_TOOTH_NO, A.STATUS FROM OH_RESTORATIVE_CHART_DTL A WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.TOOTH_NO = ? AND A.CONDITION_TYPE IN ('MISSTH','EXFOLTH','ERUPTH','UNERTH','PARERTH','EXTRACT','DECITH') AND NVL(A.COND_CLOSED_YN,'N') = 'N' AND NVL(A.STATUS,'X') != 'E'");
		//pstmt = con.prepareStatement("SELECT A.CONDITION_TYPE, A.TRMT_CATEGORY_TYPE, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN,(SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE TOOTH_NO = ? AND NUMBERING_SYSTEM = ?) DISPLAY_TOOTH_NO , (SELECT B.MAPPED_TOOTH_NO FROM OH_TOOTH B WHERE A.TOOTH_NO = B.TOOTH_NO) MAPPED_TOOTH_NO, A.STATUS FROM OH_RESTORATIVE_CHART_DTL A WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.TOOTH_NO = ? AND (A.CONDITION_TYPE IN  ('MISSTH','EXFOLTH', 'ERUPTH', 'UNERTH','PARERTH', 'DECITH' ) OR  A.TRMT_CATEGORY_TYPE IN ('EXTRACT')) AND NVL(A.COND_CLOSED_YN,'N') = 'N' AND NVL(A.STATUS,'X') != 'E'");
		pstmt = con.prepareStatement("SELECT A.CONDITION_TYPE, A.TRMT_CATEGORY_TYPE, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN,(SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE TOOTH_NO = ? AND NUMBERING_SYSTEM = ?) DISPLAY_TOOTH_NO , (SELECT B.MAPPED_TOOTH_NO FROM OH_TOOTH B WHERE A.TOOTH_NO = B.TOOTH_NO) MAPPED_TOOTH_NO, A.STATUS FROM OH_RESTORATIVE_CHART_DTL A WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.TOOTH_NO = ? AND (A.CONDITION_TYPE IN  ('MISSTH','EXFOLTH', 'ERUPTH', 'UNERTH','PARERTH', 'DECITH', 'IMPACTN' ) OR  (A.TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='E') OR (A.TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='I' AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN (10,25,53,52,55,75,90,70,60,85)))) AND NVL(A.COND_CLOSED_YN,'N') = 'N' AND NVL(A.STATUS,'X') != 'E'");
		
		pstmt.setString(1,dflt_tooth);
		pstmt.setString(2,tooth_numbering_system);
		//pstmt.setString(3,facility_id);
		pstmt.setString(3,patient_id);
		pstmt.setString(4,chart_num);
		pstmt.setString(5,dflt_tooth);
		rst = pstmt.executeQuery();
	}else{
		 //Commented by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
		//Added ERUPTH
		//pstmt = con.prepareStatement("SELECT CONDITION_TYPE,(SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE TOOTH_NO = ? AND NUMBERING_SYSTEM = ?) DISPLAY_TOOTH_NO FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE IN ('MISSTH','EXFOLTH') AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E'");
		//pstmt = con.prepareStatement("SELECT CONDITION_TYPE,SUPERNUMERARY_YN,MIXED_DENT_DECIDUOUS_YN,(SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE TOOTH_NO = ? AND NUMBERING_SYSTEM = ?) DISPLAY_TOOTH_NO , STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE IN ('MISSTH','EXFOLTH','ERUPTH', 'UNERTH','PARERTH','EXTRACT','DECITH') AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E'");
		//pstmt = con.prepareStatement("SELECT A.CONDITION_TYPE, A.TRMT_CATEGORY_TYPE, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN,(SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE TOOTH_NO = ? AND NUMBERING_SYSTEM = ?) DISPLAY_TOOTH_NO , (SELECT B.MAPPED_TOOTH_NO FROM OH_TOOTH B WHERE A.TOOTH_NO = B.TOOTH_NO) MAPPED_TOOTH_NO, A.STATUS FROM OH_RESTORATIVE_CHART_DTL A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.TOOTH_NO = ? AND (A.CONDITION_TYPE IN  ('MISSTH','EXFOLTH', 'ERUPTH', 'UNERTH','PARERTH', 'DECITH'  ) OR  A.TRMT_CATEGORY_TYPE IN ('EXTRACT')) AND NVL(A.COND_CLOSED_YN,'N') = 'N' AND NVL(A.STATUS,'X') != 'E'");
		//Commented above and added by sridevi joshi on 090909 for IN009739(SRR20056-CRF-0457)-Reopened (If treatment is recorded and order is not placed i.e close order placement window without record)
		pstmt = con.prepareStatement("SELECT A.CONDITION_TYPE, A.TRMT_CATEGORY_TYPE, A.SUPERNUMERARY_YN, A.MIXED_DENT_DECIDUOUS_YN,(SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE TOOTH_NO = ? AND NUMBERING_SYSTEM = ?) DISPLAY_TOOTH_NO , (SELECT B.MAPPED_TOOTH_NO FROM OH_TOOTH B WHERE A.TOOTH_NO = B.TOOTH_NO) MAPPED_TOOTH_NO, A.STATUS FROM OH_RESTORATIVE_CHART_DTL A WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.TOOTH_NO = ? AND (A.CONDITION_TYPE IN  ('MISSTH','EXFOLTH', 'ERUPTH', 'UNERTH','PARERTH', 'DECITH', 'IMPACTN'  ) OR  (A.TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='E') OR (A.TRMT_CATEGORY_TYPE = 'EXTRACT' AND TREATMENT_INT_EXT ='I' AND STATUS IN (SELECT ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE WHERE ORDER_STATUS_TYPE IN (10,25,53,52,55,75,90,70,60,85)))) AND NVL(A.COND_CLOSED_YN,'N') = 'N' AND NVL(A.STATUS,'X') != 'E'");
		pstmt.setString(1,dflt_tooth);
		pstmt.setString(2,tooth_numbering_system);
		pstmt.setString(3,other_chart_facility_id);
		pstmt.setString(4,patient_id);
		pstmt.setString(5,chart_num);
		pstmt.setString(6,dflt_tooth);
		rst = pstmt.executeQuery();
}
		while(rst!= null && rst.next()){
			//missing_tooth_yn = "Y";
			display_tooth_no = checkForNull(rst.getString("DISPLAY_TOOTH_NO"));
			//Added by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
			condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
			treatment_type = checkForNull(rst.getString("TRMT_CATEGORY_TYPE"));
			super_yn = checkForNull(rst.getString("SUPERNUMERARY_YN"));
			MD_yn = checkForNull(rst.getString("MIXED_DENT_DECIDUOUS_YN"));
			status = checkForNull(rst.getString("STATUS"));
			mapped_tooth_no = checkForNull(rst.getString("MAPPED_TOOTH_NO"));
		/*	if(condition_type.equals("EXFOLTH")){
				exfolth_yn = "Y";
			}
			else if(condition_type.equals("ERUPTH")){
				erupted_tooth_yn = "Y";
			}
			else if(condition_type.equals("MISSTH")){
				missing_tooth_yn = "Y";
			}
			else if(condition_type.equals("UNERTH") && !status.equals("Z")){
				missing_tooth_yn = "Y";
			}
			else if(condition_type.equals("PARERTH")){
				missing_tooth_yn = "N";
				exfolth_yn = "N";
			}  */
			
			//if(condition_type.equals("EXFOLTH") && !MD_yn.equals("R") && !MD_yn.equals("N")){
			//if(condition_type.equals("EXFOLTH") && !MD_yn.equals("R") ){
			/*if(condition_type.equals("EXFOLTH")){
				exfolth_yn = "Y";
			 }*/
			if(treatment_type.equals("EXTRACT")){
				missing_tooth_yn = "Y";
			}
		/*	if(condition_type.equals("EXFOLTH") && (MD_yn.equals("R") || MD_yn.equals("N"))) {
				exfolth_RD = "Y";
			} */
			if(condition_type.equals("DECITH")){
				decith_yn = "Y";
			}
			
			if(mixed_dentition_YN.equals("Y")  && permanent_deciduous_flag.equals("D")){
				
			   if(condition_type.equals("PARERTH") && status.equals("Z")) {
				   missing_tooth_yn = "N";
			   }
			   else if (condition_type.equals("EXFOLTH") && super_yn.equals("") && MD_yn.equals("")){
			   		 exfolth_yn = "Y";
					 super_exfol_deci_tooth = "Y";
			   }
			   else if(condition_type.equals("EXFOLTH")){
					exfolth_yn = "Y";
			   }
			   else if (condition_type.equals("PARERTH")){
				   missing_tooth_yn = "Y";			   
			   }
			   else if(condition_type.equals("ERUPTH")) {
				erupted_tooth_yn = "Y";
				//exfolth_yn = "N";
				missing_tooth_yn = "N";		
				}
				else if(condition_type.equals("MISSTH") || condition_type.equals("IMPACTN")) {
					missing_tooth_yn = "Y";
				}
			}
			
			else if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("P")){
			   if (condition_type.equals("PARERTH")){
				   missing_tooth_yn = "Y";			   
			   }
			   else if (condition_type.equals("UNERTH")){
				   missing_tooth_yn = "Y";			   
			   }
			   else if(condition_type.equals("ERUPTH")) {
				erupted_tooth_yn = "Y";
				//exfolth_yn = "N";
				missing_tooth_yn = "N";		
				}
				//else if(condition_type.equals("EXFOLTH")){
				else if(condition_type.equals("EXFOLTH") && !MD_yn.equals("R")){
					exfolth_yn = "Y";
			   }
				else if(condition_type.equals("MISSTH") || condition_type.equals("IMPACTN")) {
					missing_tooth_yn = "Y";
				}
		  	}
			
			else if(mixed_dentition_YN.equals("N")){
			  if(condition_type.equals("UNERTH") && status.equals("Z")) {
				   missing_tooth_yn = "N";
			   }
			   if (condition_type.equals("PARERTH")){
				   missing_tooth_yn = "Y";			   
			   }
			   else if (condition_type.equals("UNERTH")){
				   missing_tooth_yn = "Y";			   
			   }
			   else if(condition_type.equals("EXFOLTH")&& !MD_yn.equals("R") && !super_yn.equals("Y")){
				   missing_tooth_yn = "Y";	
				   exfolth_yn = "Y";
			   }
			   else if(condition_type.equals("EXFOLTH") && MD_yn.equals("N") ){
					exfolth_yn = "Y";
					erupted_tooth_yn = "N";
				}
			   else if(condition_type.equals("ERUPTH")) {
				erupted_tooth_yn = "Y";
				exfolth_yn = "N";
				missing_tooth_yn = "N";		
				}
				else if(condition_type.equals("MISSTH") || condition_type.equals("IMPACTN")) {
					missing_tooth_yn = "Y";
				}
		  	}
			else{
				missing_tooth_yn = "N";			
			}

		/*	if(super_yn == "" && super_yn == "null" && super_yn == null && MD_yn == "" && MD_yn == "null" && MD_yn == null){
				 if(condition_type.equals("EXFOLTH")){
					 exfolth_yn = "Y";
				 }
			}  */

			//else if(condition_type.equals("MISSTH") || (condition_type.equals("UNERTH") && !status.equals("Z"))) {
			//else if(condition_type.equals("MISSTH") || condition_type.equals("UNERTH") ||  condition_type.equals("PARERTH")) {
			/*else if(condition_type.equals("MISSTH")) {
				missing_tooth_yn = "Y";
			} */
			/*else if (condition_type.equals("UNERTH")) {
				missing_tooth_yn = "Y";			
			} */
			//else if(condition_type.equals("ERUPTH") || (condition_type.equals("PARERTH"))) {
			//else if(condition_type.equals("ERUPTH") || (condition_type.equals("PARERTH"))) {
		/*	else if(condition_type.equals("ERUPTH")) {
				erupted_tooth_yn = "Y";
				//exfolth_yn = "N";
				//missing_tooth_yn = "N";		
			} */
		/*	else{
				missing_tooth_yn = "N";			
			}*/
			//
	   	}
		if(condition_type.equals("")){
			if(mixed_dentition_YN.equals("Y")){
				if(dflt_tooth.equals("2") || dflt_tooth.equals("3") || dflt_tooth.equals("14") || dflt_tooth.equals("15") || dflt_tooth.equals("18") || dflt_tooth.equals("19") || dflt_tooth.equals("30") || dflt_tooth.equals("31")) {
					missing_tooth_yn = "Y";
					pstmt = con.prepareStatement("SELECT NS_TOOTH_NO DISPLAY_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE TOOTH_NO = ? AND NUMBERING_SYSTEM = ?");
					pstmt.setString(1,dflt_tooth);
					pstmt.setString(2,tooth_numbering_system);
					rst = pstmt.executeQuery();
			
					if(rst!= null && rst.next()){
						display_tooth_no = checkForNull(rst.getString("DISPLAY_TOOTH_NO"));
					}
				}
			}
			else{
			   	if(dflt_tooth.equals("1") || dflt_tooth.equals("16") || dflt_tooth.equals("17") || dflt_tooth.equals("32")) {
					missing_tooth_yn = "Y";
					pstmt = con.prepareStatement("SELECT NS_TOOTH_NO DISPLAY_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE TOOTH_NO = ? AND NUMBERING_SYSTEM = ?");
					pstmt.setString(1,dflt_tooth);
					pstmt.setString(2,tooth_numbering_system);
					rst = pstmt.executeQuery();
			
					if(rst!= null && rst.next()){
						display_tooth_no = checkForNull(rst.getString("DISPLAY_TOOTH_NO"));
					}
				}
			}
		}
		//Commented by Sharon Crasta on 8/6/2009 for IN009739(SRR20056-CRF-0457)
		//out.println(missing_tooth_yn+"##"+display_tooth_no);
		out.println(missing_tooth_yn+"##"+display_tooth_no+"##"+erupted_tooth_yn+"##"+super_yn+"##"+MD_yn+"##"+exfolth_yn+"##"+decith_yn+"##"+mapped_tooth_no+"##"+exfolth_RD+"##"+super_exfol_deci_tooth);
	}
	else if(func_mode.equalsIgnoreCase("getDisplayToothNo")){	
		String dflt_tooth = checkForNull(request.getParameter("dflt_tooth")) ;
		String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system")) ;
		String display_tooth_no = "";

		pstmt = con.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE NUMBERING_SYSTEM = ? AND TOOTH_NO = ?");
		pstmt.setString(1,tooth_numbering_system);
		pstmt.setString(2,dflt_tooth);
		rst = pstmt.executeQuery();

		while(rst!= null && rst.next()){
			display_tooth_no = checkForNull(rst.getString("NS_TOOTH_NO"));
		}
		out.println(display_tooth_no);
	}
	else if(func_mode.equalsIgnoreCase("populateMixedQuadrant")){	
		String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system")) ;
		String dflt_mixed_dentition_chart = checkForNull(request.getParameter("dflt_mixed_dentition_chart")) ;
		String tooth_no_md = "";
		String tooth_num_md = "";
		//HashMap map_md = new HashMap();
		StringBuffer map_md = new StringBuffer();

		pstmt = con.prepareStatement("SELECT A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM =? AND (A.PERMANENT_DECIDUOUS = ? OR MIXED_DENT_TOOTH_NO IS NOT NULL) ORDER BY MIXED_DENT_TOOTH_ORDER ASC");
		//pstmt = con.prepareStatement("SELECT A.TOOTH_NO, B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND B.NUMBERING_SYSTEM =? AND (A.PERMANENT_DECIDUOUS = ? OR MIXED_DENT_TOOTH_NO IS NOT NULL)");
		pstmt.setString(1,tooth_numbering_system);
		pstmt.setString(2,dflt_mixed_dentition_chart);
		rst = pstmt.executeQuery();
		while(rst!=null && rst.next()){
				tooth_no_md=checkForNull(rst.getString("TOOTH_NO"));
				tooth_num_md=checkForNull(rst.getString("TOOTH_NUM"));
				/*if(tooth_num_md.equals("")){
					map_md = new HashMap();
				}
				else{
					map_md.put(tooth_no_md,tooth_num_md);
				}*/
				map_md.append(tooth_no_md+"##"+tooth_num_md);
				map_md.append("~");
			}
		out.println(map_md);
	}	else if(func_mode.equalsIgnoreCase("checkForExfoliatedTooth")){	
		String patient_id = checkForNull(request.getParameter("patient_id")) ;
		String chart_num = checkForNull(request.getParameter("chart_num")) ;
		String dflt_tooth = checkForNull(request.getParameter("dflt_tooth")) ;
		String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system")) ;
		String oh_chart_level = checkForNull(request.getParameter("oh_chart_level")) ;
		String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id")) ;
		String missing_tooth_yn = "N";
		String display_tooth_no = "";
		if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
	if (oh_chart_level.equals("E")){
		pstmt = con.prepareStatement("SELECT CONDITION_TYPE,(SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE TOOTH_NO = ? AND NUMBERING_SYSTEM = ?) DISPLAY_TOOTH_NO FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE IN ('EXFOLTH') AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E'");
		pstmt.setString(1,dflt_tooth);
		pstmt.setString(2,tooth_numbering_system);
		//pstmt.setString(3,facility_id);
		pstmt.setString(3,patient_id);
		pstmt.setString(4,chart_num);
		pstmt.setString(5,dflt_tooth);
		rst = pstmt.executeQuery();
	}else{
		pstmt = con.prepareStatement("SELECT CONDITION_TYPE,(SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE TOOTH_NO = ? AND NUMBERING_SYSTEM = ?) DISPLAY_TOOTH_NO FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE IN ('EXFOLTH') AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E'");
		pstmt.setString(1,dflt_tooth);
		pstmt.setString(2,tooth_numbering_system);
		pstmt.setString(3,other_chart_facility_id);
		pstmt.setString(4,patient_id);
		pstmt.setString(5,chart_num);
		pstmt.setString(6,dflt_tooth);
		rst = pstmt.executeQuery();
}
		while(rst!= null && rst.next()){
			missing_tooth_yn = "Y";
			display_tooth_no = checkForNull(rst.getString("DISPLAY_TOOTH_NO"));
		}
		out.println(missing_tooth_yn+"##"+display_tooth_no);
	} 	
	else if(func_mode.equalsIgnoreCase("checkForDeciduousTooth")){	
		String patient_id = checkForNull(request.getParameter("patient_id")) ;
		String chart_num = checkForNull(request.getParameter("chart_num")) ;
		String dflt_tooth = checkForNull(request.getParameter("dflt_tooth")) ;
		String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system")) ;
		String oh_chart_level = checkForNull(request.getParameter("oh_chart_level")) ;
		String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id")) ;
		String condition_type = "";
		String deciduous_tooth_yn = "Y";
		String deciduous_tooth_exfoliated_yn = "N";
		String display_tooth_no = "";
		if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
	if (oh_chart_level.equals("E")){
		pstmt = con.prepareStatement("SELECT CONDITION_TYPE,(SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE TOOTH_NO = ? AND NUMBERING_SYSTEM = ?) DISPLAY_TOOTH_NO FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE IN ('DECITH') AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E'");
		pstmt.setString(1,dflt_tooth);
		pstmt.setString(2,tooth_numbering_system);
		//pstmt.setString(3,facility_id);
		pstmt.setString(3,patient_id);
		pstmt.setString(4,chart_num);
		pstmt.setString(5,dflt_tooth);
		rst = pstmt.executeQuery();
	}else{
		pstmt = con.prepareStatement("SELECT CONDITION_TYPE,(SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE TOOTH_NO = ? AND NUMBERING_SYSTEM = ?) DISPLAY_TOOTH_NO FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE IN ('DECITH') AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E'");
		pstmt.setString(1,dflt_tooth);
		pstmt.setString(2,tooth_numbering_system);
		pstmt.setString(3,other_chart_facility_id);
		pstmt.setString(4,patient_id);
		pstmt.setString(5,chart_num);
		pstmt.setString(6,dflt_tooth);
		rst = pstmt.executeQuery();
		}
		while(rst!= null && rst.next()){
   			condition_type = checkForNull(rst.getString("CONDITION_TYPE"));

			if(condition_type.equals("EXFOLTH")){
				deciduous_tooth_yn = "N";
				deciduous_tooth_exfoliated_yn = "Y";
				display_tooth_no = checkForNull(rst.getString("DISPLAY_TOOTH_NO"));
		}
		out.println(deciduous_tooth_yn+"##"+deciduous_tooth_exfoliated_yn+"##"+display_tooth_no);
		}
	}  else if(func_mode.equalsIgnoreCase("populateConditions")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String condition_type = "";
			String super_yn = "";
			String MD_yn = "";
			String exfolth_yn = "N";
			String deciduous_tooth_yn = "N";
			/*String RD_yn = "N";
			String status = "";*/

			String oh_chart_level = checkForNull(request.getParameter("oh_chart_level")) ;
			String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id")) ;
			
			
			StringBuffer populateConditionsBuffer = new StringBuffer();

			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			if (oh_chart_level.equals("E")){
				pstmt = con.prepareStatement("SELECT CONDITION_TYPE, SUPERNUMERARY_YN, MIXED_DENT_DECIDUOUS_YN, STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Y' AND NVL(COND_CLOSED_YN,'N') = 'N' AND SITE_TYPE='TOOTH' AND TREATMENT_CONDITION = 'C'");
				//pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
			}else{
				pstmt = con.prepareStatement("SELECT CONDITION_TYPE, SUPERNUMERARY_YN, MIXED_DENT_DECIDUOUS_YN, STATUS FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(COND_CLOSED_YN,'N') = 'N' AND SITE_TYPE='TOOTH' AND TREATMENT_CONDITION = 'C'");
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
			}
			rst=pstmt.executeQuery();
			while(rst!=null && rst.next()){
				condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
				//status = checkForNull(rst.getString("STATUS"));
				if(condition_type.equals("DECITH")){
				   deciduous_tooth_yn = "Y";
				   exfolth_yn = "N";
				   MD_yn = checkForNull(rst.getString("MIXED_DENT_DECIDUOUS_YN"));
				  // RD_yn = "N";
				}
				else if(condition_type.equals("EXFOLTH")){
					super_yn = checkForNull(rst.getString("SUPERNUMERARY_YN"));
					MD_yn = checkForNull(rst.getString("MIXED_DENT_DECIDUOUS_YN"));
					exfolth_yn = "Y";
					deciduous_tooth_yn = "N";
				//	RD_yn = "N";
				}
				else if(condition_type.equals("PARERTH") || condition_type.equals("ERUPTH")){
					super_yn = checkForNull(rst.getString("SUPERNUMERARY_YN"));
					MD_yn = checkForNull(rst.getString("MIXED_DENT_DECIDUOUS_YN"));
					//exfolth_yn = "Y";
					//deciduous_tooth_yn = "N";
				//	RD_yn = "N";
				}
				else if(condition_type.equals("SUPRTH")){ //Added by Sridevi Joshi on 2/8/2010 for IN010894
					super_yn = checkForNull(rst.getString("SUPERNUMERARY_YN"));
					MD_yn = checkForNull(rst.getString("MIXED_DENT_DECIDUOUS_YN"));
					
				}
				populateConditionsBuffer.append(condition_type+"##"+super_yn+"##"+MD_yn+"##"+deciduous_tooth_yn+"##"+exfolth_yn);
				populateConditionsBuffer.append("~");
			}
			
			out.println(populateConditionsBuffer);
		 }
		  else if(func_mode.equalsIgnoreCase("getToothStatus")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String GS_Status = "";

			String oh_chart_level = checkForNull(request.getParameter("oh_chart_level")) ;
			String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id")) ;
			
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			if (oh_chart_level.equals("E")){
				pstmt = con.prepareStatement("SELECT STATUS FROM OH_RESTORATIVE_CHART_GING_STS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Y'");
				//pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
			}else{
				pstmt = con.prepareStatement("SELECT STATUS FROM OH_RESTORATIVE_CHART_GING_STS WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Y'");
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
			}
			rst=pstmt.executeQuery();
			while(rst!=null && rst.next()){
				GS_Status = checkForNull(rst.getString("STATUS"));
			}
			
			out.println(GS_Status);
		 }
		 else if(func_mode.equalsIgnoreCase("getToothCount")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			String GS_Status = "";

			String oh_chart_level = checkForNull(request.getParameter("oh_chart_level")) ;
			String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id")) ;
			
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			if (oh_chart_level.equals("E")){
				pstmt = con.prepareStatement("SELECT COUNT(*) COUNT_TOOTH FROM OH_RESTORATIVE_CHART_GING_STS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Y'");
				//pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
			}else{
				pstmt = con.prepareStatement("SELECT COUNT(*) COUNT_TOOTH FROM OH_RESTORATIVE_CHART_GING_STS WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Y'");
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
			}
			rst=pstmt.executeQuery();
			while(rst!=null && rst.next()){
				GS_Status = checkForNull(rst.getString("COUNT_TOOTH"));
			}
			
			out.println(GS_Status);
		 }
		  else if(func_mode.equalsIgnoreCase("getToothForRHSGS")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			//String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			int tooth_nos = 0;
			String mixed_dent_deciduous_yn = "";
			String supernumerary_yn = "";

			StringBuffer tooth_no_RHS= new StringBuffer();
			String oh_chart_level = checkForNull(request.getParameter("oh_chart_level")) ;
			String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id")) ;
			
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			if (oh_chart_level.equals("E")){
				pstmt = con.prepareStatement("SELECT TOOTH_NO, MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN  FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CONDITION_TYPE = 'EXFOLTH'");
				//pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				//pstmt.setString(3,tooth_no);
			}else{
				pstmt = con.prepareStatement("SELECT TOOTH_NO,MIXED_DENT_DECIDUOUS_YN, SUPERNUMERARY_YN FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND CONDITION_TYPE = 'EXFOLTH'");
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				//pstmt.setString(4,tooth_no);
			}
			rst=pstmt.executeQuery();
			while(rst!=null && rst.next()){
				tooth_nos = rst.getInt("TOOTH_NO");
				mixed_dent_deciduous_yn = checkForNull(rst.getString("MIXED_DENT_DECIDUOUS_YN"));
				supernumerary_yn = checkForNull(rst.getString("SUPERNUMERARY_YN"));
				
				tooth_no_RHS.append(tooth_nos+"##"+mixed_dent_deciduous_yn+"##"+supernumerary_yn);
				tooth_no_RHS.append("~");
			}
			
			out.println(tooth_no_RHS);
		 } else if(func_mode.equalsIgnoreCase("checkForErupthExfolthTooth")){	
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
			String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String tooth_no = checkForNull(request.getParameter( "tooth_no" )) ;
			//String called_from = checkForNull(request.getParameter( "called_from" )) ;
			String condition_type = "";
			String super_num = "";
			String MD_deciduous = "";
			int chart_line_num = 0;					

			StringBuffer condition_before_after = new StringBuffer();

			String oh_chart_level = checkForNull(request.getParameter("oh_chart_level")) ;
			String other_chart_facility_id = checkForNull(request.getParameter("other_chart_facility_id")) ;
			
			if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
					other_chart_facility_id=facility_id;
			}
			if (oh_chart_level.equals("E")){
				pstmt = con.prepareStatement("SELECT CONDITION_TYPE, CHART_LINE_NUM, SUPERNUMERARY_YN, MIXED_DENT_DECIDUOUS_YN FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Z' AND NVL(COND_CLOSED_YN,'N') = 'N' AND (SUPERNUMERARY_YN = 'N' OR SUPERNUMERARY_YN IS NULL) AND CONDITION_TYPE IN ('ERUPTH','EXFOLTH','PARERTH','DECITH') ORDER BY CHART_NUM, CHART_LINE_NUM");
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,tooth_no);
			}
			else{
				//pstmt = con.prepareStatement("SELECT CONDITION_TYPE, CHART_LINE_NUM, SUPERNUMERARY_YN, MIXED_DENT_DECIDUOUS_YN FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Z' AND NVL(COND_CLOSED_YN,'N') = 'N' AND (SUPERNUMERARY_YN = 'N' OR SUPERNUMERARY_YN IS NULL) AND CONDITION_TYPE IN ('ERUPTH','EXFOLTH','PARERTH','DECITH') ORDER BY CHART_NUM, CHART_LINE_NUM");
				pstmt = con.prepareStatement("SELECT CONDITION_TYPE, CHART_LINE_NUM, SUPERNUMERARY_YN, MIXED_DENT_DECIDUOUS_YN FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS,'X') != 'E' AND NVL(STATUS,'X') != 'Z' AND NVL(COND_CLOSED_YN,'N') = 'N' AND (SUPERNUMERARY_YN = 'N' OR SUPERNUMERARY_YN IS NULL) AND CONDITION_TYPE IN ('ERUPTH','EXFOLTH','PARERTH','DECITH') ORDER BY CHART_NUM, CHART_LINE_NUM");
				pstmt.setString(1,other_chart_facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,tooth_no);
			}
			rst=pstmt.executeQuery();
			while(rst.next()){
				condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
				chart_line_num = Integer.parseInt(checkForNull(rst.getString("CHART_LINE_NUM")));
				super_num = checkForNull(rst.getString("SUPERNUMERARY_YN"));
				MD_deciduous = checkForNull(rst.getString("MIXED_DENT_DECIDUOUS_YN"));
				condition_before_after.append(condition_type+"##"+chart_line_num+"##"+super_num+"##"+MD_deciduous);
				condition_before_after.append("~"); 
			}
			out.println(condition_before_after);
		 }
}catch(Exception e){
		con.rollback();
		 System.err.println("Err Msg from GingivalStatusValidation.jsp "+e);
		 System.err.println("func_mode== "+func_mode);
	}
   finally{
		 if(rst!=null) rst.close();
		 if(pstmt!=null)pstmt.close();
		 if(con!=null)
		 ConnectionManager.returnConnection(con,request);
	}
%>


