<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonAdapter,java.io.*,java.sql.*" contentType=" text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql_component = "";
	String q1_sno = "";
	String q2_sno = "";
	String tooth_str = "";
	String short_desc = "";
	String display_tooth_str = "";
	int tooth_count = 0;

	//Header Params
	String chart_desc = "";
	String location = "";
	String performed_by = "";
	String performed_date = "";

	//Summary Params
	String index_desc = "" ;
	String index_code = "" ;
	String index_cut_off_value = "" ;
	String value = checkForNull(request.getParameter( "value" )) ;
	String tooth_nos = "";
	String display_index_desc="";

	HashMap tooth_map=new HashMap();
	StringBuffer component_display_text = new StringBuffer() ;

	String[] tooth_str_arr = null;
	String[] display_tooth_str_arr = null;

	String facility_id = (String)session.getValue("facility_id") ;
	String patient_id = CommonAdapter.checkForNull(request.getParameter( "patient_id" )) ;
	String chart_num = CommonAdapter.checkForNull(request.getParameter("chart_num")) ;
	String chart_line_num = CommonAdapter.checkForNull(request.getParameter("chart_line_num")) ;
	String baseline_active_yn = CommonAdapter.checkForNull(request.getParameter("baseline_active_yn")) ;
	String baseline_closed_yn = CommonAdapter.checkForNull(request.getParameter("baseline_closed_yn")) ;
	
	String tooth_numbering_system = "";
	String permanent_deciduous_flag = CommonAdapter.checkForNull(request.getParameter("permanent_deciduous_flag"));
	String perio_chart = CommonAdapter.checkForNull(request.getParameter("perio_chart"));
	String perio_arch = CommonAdapter.checkForNull(request.getParameter("perio_arch"));
	String tab_code = CommonAdapter.checkForNull(request.getParameter("tab_code"));
	String hist_image_values = CommonAdapter.checkForNull(request.getParameter("hist_image_values"));
	
	if(!perio_arch.equals("")){
		if(perio_arch.equals("U")){
			q1_sno = "1";
			q2_sno = "2";
		}
		else if(perio_arch.equals("L")){
			q1_sno = "3";
			q2_sno = "4";
		}
	}

	StringBuilder content									=	new StringBuilder();

	//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
	String oh_chart_level = "";
	//

	try{
		con=ConnectionManager.getConnection(request);

		//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
		//Based on the Chart Level the paramters need to be taken.
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	
		pstmt = con.prepareStatement("SELECT CHART_LEVEL FROM OH_PARAM");
		rs = pstmt.executeQuery();
		while (rs != null && rs.next()){
			oh_chart_level = checkForNull(rs.getString("CHART_LEVEL"));
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		if(oh_chart_level.equals("E")){
			pstmt=con.prepareStatement("SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM");
		}
		else
		{//End
			pstmt=con.prepareStatement("SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?");
			pstmt.setString(1,facility_id);
		}
		rs=pstmt.executeQuery();
		while(rs.next()){
			tooth_numbering_system = CommonAdapter.checkForNull(rs.getString("TOOTH_NUMBERING_SYSTEM"));
		}

		content.append("<HTML><HEAD>");
			
		content.append("<link rel='StyleSheet' href='../../eCommon/html/"+sStyle+"' type='text/css'/><link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>");

		content.append("<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script language='javascript' src='../../eCommon/js/common.js'></script><script language='javascript' src='../../eOH/js/HistPerioChart.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
		content.append("</head>");

		perio_arch = "U";
		if(perio_arch.equals("U")){
			q1_sno = "1";
			q2_sno = "2";
		}

		//To get the No of tooth per Arch
		pstmt = con.prepareStatement("SELECT B.NS_TOOTH_NO DISPLAY_TOOTH_NO, A.TOOTH_NO FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO=B.TOOTH_NO AND B.NUMBERING_SYSTEM=? AND A.PERMANENT_DECIDUOUS = ? AND B.QUADRANT_SNO IN (?,?)");
		pstmt.setString(1,tooth_numbering_system);
		pstmt.setString(2,permanent_deciduous_flag);
		pstmt.setString(3,q1_sno);
		pstmt.setString(4,q2_sno);
		rs = pstmt.executeQuery();
		while(rs.next()){
			if(tooth_count == 0){
				tooth_str = rs.getString("TOOTH_NO");
				display_tooth_str = rs.getString("DISPLAY_TOOTH_NO");
			}
			else{
				tooth_str = tooth_str + "," +rs.getString("TOOTH_NO");
				display_tooth_str = display_tooth_str + "," +rs.getString("DISPLAY_TOOTH_NO");
			}
			tooth_count++;
		}

		content.append("<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'><form name='perioChartDisplayForm' id='perioChartDisplayForm'>");

		content.append("<table width='100%' cellpadding =0 cellspacing=0 border = '1'>");
		content.append("<tr><td class='CAGROUPHEADING'>Sno</td><td class='CAGROUPHEADING'>Index Component</td></tr>");
		content.append("<tr><td>1</td><td><a href='#header'>Header</a></td></tr>");
		content.append("<tr><td>2</td><td><a href='#summary'>Summary</a></td></tr>");
		content.append("<tr><td>3</td><td><a href='#chart'>Chart</a></td></tr>");
		content.append("</table>");

		content.append("<br><br>");

		content.append("<table width='100%' cellpadding =0 cellspacing=0 border = '1'>");
		content.append("<tr><td class='CAGROUPHEADING'><a name='header'>Header</a></td></tr>");

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		
		pstmt=con.prepareStatement("SELECT B.CHART_DESC,(SELECT FACILITY_NAME FROM SM_FACILITY_PARAM WHERE FACILITY_ID = A.OPERATING_FACILITY_ID) LOCATION, (SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE APPL_USER_ID = CHART_COMPLETED_BY) PERFORMED_BY, TO_CHAR(CHART_COMPLETED_DATE,'DD/MM/YYYY HH24:MI') PERFORMED_DATE FROM OH_PERIODONTAL_CHART_HDR_LINE A, OH_PERIODONTAL_CHART_DEF_HDR B WHERE A.OPERATING_FACILITY_ID=? AND A.PATIENT_ID=? AND A.CHART_NUM=? AND A.CHART_LINE_NUM = ? AND A.CHART_CODE=? AND  A.CHART_CODE = B.CHART_CODE ");
		pstmt.setString(1,facility_id);
		pstmt.setString(2,patient_id);
		pstmt.setString(3,chart_num);
		pstmt.setString(4,chart_line_num);
		pstmt.setString(5,perio_chart);
		rs=pstmt.executeQuery();
		while(rs.next()){
			chart_desc = CommonAdapter.checkForNull(rs.getString("CHART_DESC"));
			location = CommonAdapter.checkForNull(rs.getString("LOCATION"));
			performed_by = CommonAdapter.checkForNull(rs.getString("PERFORMED_BY"));
			performed_date = CommonAdapter.checkForNull(rs.getString("PERFORMED_DATE"));
		}

		
		content.append("<tr><td>Chart:"+chart_desc+", Location:"+location+", Performed Date:"+performed_date+", Performed By:"+performed_by+"</td></tr>");
		content.append("</table>");

		content.append("<br><br>");

		content.append("<table width='100%' cellpadding =0 cellspacing=0 border = '1'>");
		content.append("<tr><td class='CAGROUPHEADING' colspan='17'><a name='summary'>Summary</a></td></tr>");

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		pstmt=con.prepareStatement("SELECT A.INDEX_CODE, B.INDEX_DESC, B.INDEX_CUT_OFF_VALUE, A.VALUE FROM OH_PERIODONTAL_CHART_SUMMARY A, OH_INDEXES B WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID= ? AND A.CHART_NUM= ? AND A.CHART_CODE= ? AND A.CHART_LINE_NUM= ? AND A.INDEX_YN = ? AND A.INDEX_CODE= B.INDEX_CODE");
		pstmt.setString(1,facility_id);
		pstmt.setString(2,patient_id);
		pstmt.setString(3,chart_num);
		pstmt.setString(4,perio_chart);
		pstmt.setString(5,chart_line_num);
		pstmt.setString(6,"Y");
		rs = pstmt.executeQuery();	  

		while(rs!= null && rs.next()){
			index_code = rs.getString("INDEX_CODE");		
			index_desc = rs.getString("INDEX_DESC"); 
			index_cut_off_value = rs.getString("INDEX_CUT_OFF_VALUE");		
			value = rs.getString("VALUE");	
			if(index_cut_off_value!=null && !index_cut_off_value.equals("null") && !index_cut_off_value.equals("")){
				if(index_code.equals("BLDIND") || index_code.equals("PLQIND")){
					display_index_desc = index_desc+"("+index_cut_off_value+"%)";
				}else{				
					display_index_desc = index_desc+"("+index_cut_off_value+")";
				}
			}else{
				display_index_desc = index_desc;
			}

			content.append("<tr>");
			//content.append("<td class='label' width='10%'></td>");
			content.append("<td class='label' width='90%' style='text-align:left'>"+display_index_desc+" "+value+"</td>");
			content.append("</tr>");
		}

		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

		pstmt=con.prepareStatement("SELECT TOOTH_NO,NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM WHERE NUMBERING_SYSTEM=? ORDER BY TOOTH_NO");
		pstmt.setString(1,tooth_numbering_system);
		rs=pstmt.executeQuery();
		while(rs.next()){
			tooth_map.put(rs.getString("TOOTH_NO"),rs.getString("NS_TOOTH_NO"));
		}
			
		// Query for Components
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

		pstmt=con.prepareStatement("SELECT A.COMPONENT_CODE, B.COMPONENT_SHORT_DESC_USER_DEF, B.CUT_OFF, A.TOOTH_NOS FROM OH_PERIODONTAL_CHART_SUMMARY A, OH_PERIODONTAL_CHART_COMP B WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID	= ? AND A.CHART_NUM= ? AND A.CHART_CODE= ? AND A.CHART_LINE_NUM = ? AND A.INDEX_YN= ? AND A.COMPONENT_CODE= B.COMPONENT_CODE");
		pstmt.setString(1,facility_id);
		pstmt.setString(2,patient_id);
		pstmt.setString(3,chart_num);
		pstmt.setString(4,perio_chart);
		pstmt.setString(5,chart_line_num);
		pstmt.setString(6,"N");
		rs = pstmt.executeQuery();

		String component_desc = "";
		String component_code = "";
		String cutt_off = "";
		String[] tooth_nos_arr = null;

	    while(rs!= null && rs.next()){
			component_display_text.setLength(0);
			component_code	= rs.getString("COMPONENT_CODE");	
			component_desc	= rs.getString("COMPONENT_SHORT_DESC_USER_DEF");
			cutt_off		= rs.getString("CUT_OFF");

			if(!component_code.equals("MITH")){
				if(cutt_off!=null && !cutt_off.equals("null") && !cutt_off.equals("")){
					component_display_text.append("TeethWith");
					component_display_text.append(" ");
					component_display_text.append(component_desc);
					component_display_text.append(" >= (");
					component_display_text.append(cutt_off);
					component_display_text.append(")mm :   ");
				}else{
					component_display_text.append("TeethWith");
					component_display_text.append(" ");
					component_display_text.append(component_desc);
					component_display_text.append(" :   ");
				}
			} else{
				//Added by Sharon Crasta on 4/20/2009 to display the Legend for Missing tooth
				if(cutt_off!=null && !cutt_off.equals("null") && !cutt_off.equals("")){
					//component_display_text.append(teethwith_legend);
					component_display_text.append(" ");
					component_display_text.append(component_desc);
					//component_display_text.append(" >= (");
					component_display_text.append(" : ");
					//component_display_text.append(cutt_off);
					//component_display_text.append(")mm :   ");
				}else{
					//component_display_text.append(teethwith_legend);
					//component_display_text.append(" ");
					component_display_text.append(component_desc);
					component_display_text.append(" : ");
				}
			}
			tooth_nos	= rs.getString("TOOTH_NOS");
			tooth_nos_arr = tooth_nos.split("#");
		
			int z=0;
			for(int i=0;i<tooth_nos_arr.length;i++){
				if(z==0){
					component_display_text.append((String)tooth_map.get(tooth_nos_arr[i]));
				}else{
					component_display_text.append(",");
					component_display_text.append((String)tooth_map.get(tooth_nos_arr[i]));
				}
				z++;
			}
			String component_display_text_str = component_display_text.toString();

			content.append("<tr>");
			//content.append("<td class='label' width='10%'></td>");
			content.append("<td class='label' width='90%' style='text-align:left'>"+component_display_text_str+"</td>");
			content.append("</tr>");

			
		}
	
		content.append("</table>");

		content.append("<br><br>");

		content.append("<table width='100%' cellpadding =0 cellspacing=0 border = '1'>");
		content.append("<tr><td class='CAGROUPHEADING' colspan='17'><a name='chart'>Chart</a></td></tr>");
		content.append("</table>");
		content.append("<br>");
		content.append("<table width='100%' cellpadding =0 cellspacing=0 border = '1'>");
		content.append("<tr><td style='background-color:#99ddee' colspan='17' align='center'>Upper Arch</td></tr>");

		
		sql_component="SELECT A.COMPONENT_CODE, B.COMPONENT_SHORT_DESC_USER_DEF, B.SURFACES_APPL_YN FROM  OH_PERIODONTAL_CHART_DEF_DTL A, OH_PERIODONTAL_CHART_COMP B WHERE A.CHART_CODE = ? AND A.COMPONENT_CODE = B.COMPONENT_CODE ORDER BY B.SURFACES_APPL_YN, A.SEQUENCE_NO";
		pstmt = con.prepareStatement(sql_component);
		pstmt.setString(1,perio_chart);
		rs = pstmt.executeQuery();
		while(rs.next()){
			if(rs.getString("SURFACES_APPL_YN").equals("N") && !rs.getString("COMPONENT_CODE").equals("MITH")){
				short_desc = rs.getString("COMPONENT_SHORT_DESC_USER_DEF");
				content.append("<tr><td width='10%' class='label'><font size='1'>"+short_desc+"</font></td>");
	
					tooth_str_arr = tooth_str.split(",");
					display_tooth_str_arr = display_tooth_str.split(",");
					/*for(int j=0;j<tooth_str_arr.length;j++){//commented by parul on 24/03/2010 for IN020187
						String td_id = rs.getString("COMPONENT_CODE") + tooth_str_arr[j] ;
	
						content.append("<td id='"+td_id+"' width='2%' align='center'>&nbsp;</td>");
	
					}*/
					if(perio_arch.equals("U")){
						for(int j=0;j<tooth_str_arr.length;j++){
							String td_id = checkForNull(rs.getString("COMPONENT_CODE")) + tooth_str_arr[j] ;
							content.append("<td id='"+td_id+"' width='2%' align='center'>&nbsp;</td>");
						}
					
					}else{
						for(int j=tooth_str_arr.length-1;j>=0;--j){
								String td_id = checkForNull(rs.getString("COMPONENT_CODE")) + tooth_str_arr[j] ;
								content.append("<td id='"+td_id+"' width='2%' align='center'>&nbsp;</td>");
							}

					}
				content.append("</tr>");
	
			}
		}

			
		content.append("<tr><td width='10%' style='background-color:white' colspan='17'>&nbsp;</td></tr>");
		pstmt = con.prepareStatement(sql_component);
		pstmt.setString(1,perio_chart);
		rs = pstmt.executeQuery();
		while(rs.next()){
			if(rs.getString("SURFACES_APPL_YN").equals("Y")){
				short_desc = rs.getString("COMPONENT_SHORT_DESC_USER_DEF");
				content.append("<tr><td width='10%' class='label'><font size='1'>"+short_desc+"</font></td>");
					tooth_str_arr = tooth_str.split(",");
					display_tooth_str_arr = display_tooth_str.split(",");
					/*for(int j=0;j<tooth_str_arr.length;j++){//commented by parul on 24/03/2010 for IN020187
						String td_id = rs.getString("COMPONENT_CODE") + tooth_str_arr[j] +"B";
						content.append("<td id='"+td_id+"' width='2%' align='center'>&nbsp;</td>");
					}*/
					if(perio_arch.equals("U")){
						for(int j=0;j<tooth_str_arr.length;j++){
							String td_id = checkForNull(rs.getString("COMPONENT_CODE")) + tooth_str_arr[j] +"B";
							content.append("<td id='"+td_id+"' width='2%' align='center'>&nbsp;</td>");
						}
					}else if(perio_arch.equals("L")){
						for(int j=tooth_str_arr.length-1;j>=0;--j){
							String td_id = checkForNull(rs.getString("COMPONENT_CODE")) + tooth_str_arr[j] +"B";
							content.append("<td id='"+td_id+"' width='2%' align='center'>&nbsp;</td>");
						}
					}
				content.append("</tr>");
			}
		}

		content.append("<tr><td class='label' width='10%'><B>Buccal</B></td>");
			/*for(int j=1;j<=16;j++){//commented by parul on 24/03/2010 for IN020187
				String img_src = "../../eOH/images/TOP/"+j+"buccal.gif";
				content.append("<td id='"+j+"' class='LABEL' ><img src='"+img_src+"' width='25'></td>");
			}*/

					int startUNo=0,endUNo=0;
					String img_src1="";
					if(perio_arch.equals("L")){ startUNo=32;endUNo=17;}
					else if (perio_arch.equals("U")){startUNo=1;endUNo=16;}
					
					if(perio_arch.equals("U")){
						for(int j=startUNo;j<=endUNo;j++){
							img_src1="../../eOH/images/MXL/MXL"+j+".jpg";
							content.append("<td id='"+j+"' class='LABEL' ><img src='"+img_src1+"' width='25'></td>");	
						}
					}else if(perio_arch.equals("L")){
							for(int k=startUNo;k>=endUNo;k--){
								img_src1="../../eOH/images/MDL/MDL"+k+".jpg";
								content.append("<td id='"+k+"' class='LABEL' ><img src='"+img_src1+"' width='25'></td>");	
							}
					}
				
		content.append("</tr>");

		content.append("<tr><td width='10%' style='background-color:white' colspan='17'>&nbsp;</td></tr>");

		content.append("<tr><td width='10%' class='columnHeader'><img src='../../eOH/images/spacer.gif' height='10' width='66'></td>");
			tooth_str_arr = tooth_str.split(",");
		/*	if(tooth_str_arr.length >1){//commented by parul on 24/03/2010 for IN020187
				display_tooth_str_arr = display_tooth_str.split(",");
				for(int j=0;j<tooth_str_arr.length;j++){
					content.append("<td id='"+tooth_str_arr[j]+"' class='columnHeader'>"+display_tooth_str_arr[j]+"</td>");
				}
			}
			else{
				for(int j=1;j<=16;j++){
					content.append("<td id='"+j+"' class='columnHeader'></td>");
				}
			}*/
			if(perio_arch.equals("L")){
				if(tooth_str_arr.length >1){
					display_tooth_str_arr = display_tooth_str.split(",");
						for(int j=tooth_str_arr.length-1;j>=0;--j){
							content.append("<td id='"+tooth_str_arr[j]+"' class='columnHeader'>"+display_tooth_str_arr[j]+"</td>");
						}
				}else{
					for(int j=1;j<=16;j++){
						content.append("<td id='"+j+"' class='columnHeader'></td>");
					}
				}	
			}else{		
				if(tooth_str_arr.length >1){
					display_tooth_str_arr = display_tooth_str.split(",");
					for(int j=0;j<tooth_str_arr.length;j++){
						content.append("<td id='"+tooth_str_arr[j]+"' class='columnHeader'>"+display_tooth_str_arr[j]+"</td>");
					}
				}else{
					for(int j=1;j<=16;j++){
						content.append("<td id='"+j+"' class='columnHeader'></td>");

					}
				}
			}
		content.append("</tr>");

		content.append("<tr><td width='10%' style='background-color:white' colspan='17'>&nbsp;</td></tr>");

		content.append("<tr><td class='label' width='10%'><B>Lingual</B></td>");
			/*for(int j=1;j<=16;j++){//commented by parul on 24/03/2010 for IN020187
				String img_src = "../../eOH/images/BOTTOM/"+j+"palatal.gif";
				content.append("<td id='"+j+"' class='LABEL' ><img src='"+img_src+"' width='25'></td>");
			}*/

				//	String img_src1="";
					if(perio_arch.equals("L")){
						startUNo=32;endUNo=17;
					}else if (perio_arch.equals("U")){
						startUNo=1;endUNo=16;
					}
					
					if(perio_arch.equals("U")){
						for(int j=startUNo;j<=endUNo;j++){
							img_src1="../../eOH/images/MXL/MXL"+j+".jpg";
							content.append("<td id='"+j+"' class='LABEL' ><img src='"+img_src1+"' width='25'></td>");	
						}
					}else if(perio_arch.equals("L")){
							for(int k=startUNo;k>=endUNo;k--){
								img_src1="../../eOH/images/MDL/MDL"+k+".jpg";
								content.append("<td id='"+k+"' class='LABEL' ><img src='"+img_src1+"' width='25'></td>");	
							}
					}
		content.append("</tr>");
		
		pstmt = con.prepareStatement(sql_component);
		pstmt.setString(1,perio_chart);
		rs = pstmt.executeQuery();
		while(rs.next()){
			if(rs.getString("SURFACES_APPL_YN").equals("Y")){
				short_desc = rs.getString("COMPONENT_SHORT_DESC_USER_DEF");
				content.append("<tr><td width='10%' class='label'><font size='1'>"+short_desc+"</font></td>");
			
					tooth_str_arr = tooth_str.split(",");
					display_tooth_str_arr = display_tooth_str.split(",");
					/*for(int j=0;j<tooth_str_arr.length;j++){//commented by parul on 24/03/2010 for IN020187
						String td_id = rs.getString("COMPONENT_CODE") + tooth_str_arr[j] +"P";
						content.append("<td id='"+td_id+"' width='2%' align='center'>&nbsp;</td>");
					}*/
				if(perio_arch.equals("U")){
						for(int j=0;j<tooth_str_arr.length;j++){
							String td_id = checkForNull(rs.getString("COMPONENT_CODE")) + tooth_str_arr[j] +"P";
							content.append("<td id='"+td_id+"' width='2%' align='center'>&nbsp;</td>");
						}
					}else if(perio_arch.equals("L")){
						for(int j=tooth_str_arr.length-1;j>=0;--j){
							String td_id = checkForNull(rs.getString("COMPONENT_CODE")) + tooth_str_arr[j] +"P";
							content.append("<td id='"+td_id+"' width='2%' align='center'>&nbsp;</td>");
						}
					}
			
				content.append("</tr>");
			
			}
		}
		content.append("</table>");

		content.append("<br><br>");


		//Lower Arch

		perio_arch = "L";
		if(perio_arch.equals("L")){
			q1_sno = "3";
			q2_sno = "4";
		}

		tooth_str = "";
		display_tooth_str = "";
		tooth_count = 0;
		//To get the No of tooth per Arch
		pstmt = con.prepareStatement("SELECT B.NS_TOOTH_NO DISPLAY_TOOTH_NO, A.TOOTH_NO FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO=B.TOOTH_NO AND B.NUMBERING_SYSTEM=? AND A.PERMANENT_DECIDUOUS = ? AND B.QUADRANT_SNO IN (?,?)");
		pstmt.setString(1,tooth_numbering_system);
		pstmt.setString(2,permanent_deciduous_flag);
		pstmt.setString(3,q1_sno);
		pstmt.setString(4,q2_sno);
		rs = pstmt.executeQuery();
		while(rs.next()){
			if(tooth_count == 0){
				tooth_str = rs.getString("TOOTH_NO");
				display_tooth_str = rs.getString("DISPLAY_TOOTH_NO");
			}
			else{
				tooth_str = tooth_str + "," +rs.getString("TOOTH_NO");
				display_tooth_str = display_tooth_str + "," +rs.getString("DISPLAY_TOOTH_NO");
			}
			tooth_count++;
		}

		content.append("<table width='100%' cellpadding =0 cellspacing=0 border = '1'>");
		content.append("<tr><td style='background-color:#99ddee' colspan='17' align='center'>Lower Arch</td></tr>");
		
		sql_component="SELECT A.COMPONENT_CODE, B.COMPONENT_SHORT_DESC_USER_DEF, B.SURFACES_APPL_YN FROM  OH_PERIODONTAL_CHART_DEF_DTL A, OH_PERIODONTAL_CHART_COMP B WHERE A.CHART_CODE = ? AND A.COMPONENT_CODE = B.COMPONENT_CODE ORDER BY B.SURFACES_APPL_YN, A.SEQUENCE_NO";
		pstmt = con.prepareStatement(sql_component);
		pstmt.setString(1,perio_chart);
		rs = pstmt.executeQuery();
		while(rs.next()){
			if(rs.getString("SURFACES_APPL_YN").equals("N") && !rs.getString("COMPONENT_CODE").equals("MITH")){
				short_desc = rs.getString("COMPONENT_SHORT_DESC_USER_DEF");
				content.append("<tr><td width='10%' class='label'><font size='1'>"+short_desc+"</font></td>");
	
					tooth_str_arr = tooth_str.split(",");
					display_tooth_str_arr = display_tooth_str.split(",");
					/*for(int j=0;j<tooth_str_arr.length;j++){//commented by parul on 24/03/2010 for IN020187
						String td_id = rs.getString("COMPONENT_CODE") + tooth_str_arr[j] ;
	
						content.append("<td id='"+td_id+"' width='2%' align='center'>&nbsp;</td>");
	
					}*/
					if(perio_arch.equals("U")){
						for(int j=0;j<tooth_str_arr.length;j++){
							String td_id = checkForNull(rs.getString("COMPONENT_CODE")) + tooth_str_arr[j] ;
							content.append("<td id='"+td_id+"' width='2%' align='center'>&nbsp;</td>");
						}
					
					}else{
						for(int j=tooth_str_arr.length-1;j>=0;--j){
								String td_id = checkForNull(rs.getString("COMPONENT_CODE")) + tooth_str_arr[j] ;
								content.append("<td id='"+td_id+"' width='2%' align='center'>&nbsp;</td>");
							}

					}
	
				content.append("</tr>");
	
			}
		}

			
		content.append("<tr><td width='10%' style='background-color:white' colspan='17'>&nbsp;</td></tr>");
		pstmt = con.prepareStatement(sql_component);
		pstmt.setString(1,perio_chart);
		rs = pstmt.executeQuery();
		while(rs.next()){
			if(rs.getString("SURFACES_APPL_YN").equals("Y")){
				short_desc = rs.getString("COMPONENT_SHORT_DESC_USER_DEF");
				content.append("<tr><td width='10%' class='label'><font size='1'>"+short_desc+"</font></td>");
					tooth_str_arr = tooth_str.split(",");
					display_tooth_str_arr = display_tooth_str.split(",");
					/*for(int j=0;j<tooth_str_arr.length;j++){//commented by parul on 24/03/2010 for IN020187
						String td_id = rs.getString("COMPONENT_CODE") + tooth_str_arr[j] +"B";
						content.append("<td id='"+td_id+"' width='2%' align='center'>&nbsp;</td>");
					}*/
				if(perio_arch.equals("U")){
						for(int j=0;j<tooth_str_arr.length;j++){
							String td_id = checkForNull(rs.getString("COMPONENT_CODE")) + tooth_str_arr[j] +"B";
							content.append("<td id='"+td_id+"' width='2%' align='center'>&nbsp;</td>");
						}
					}else if(perio_arch.equals("L")){
						for(int j=tooth_str_arr.length-1;j>=0;--j){
							String td_id = checkForNull(rs.getString("COMPONENT_CODE")) + tooth_str_arr[j] +"B";
							content.append("<td id='"+td_id+"' width='2%' align='center'>&nbsp;</td>");
						}
					}
				content.append("</tr>");
			}
		}

		content.append("<tr><td class='label' width='10%'><B>Buccal</B></td>");
		/*	for(int j=1;j<=16;j++){//commented by parul on 24/03/2010 for IN020187
				String img_src = "../../eOH/images/TOP/"+j+"buccal.gif";
				content.append("<td id='"+j+"' class='LABEL' ><img src='"+img_src+"' width='25'></td>");
			}*/
			if(perio_arch.equals("L")){ startUNo=32;endUNo=17;}
					else if (perio_arch.equals("U")){
						startUNo=1;endUNo=16;
					}
					if(perio_arch.equals("U")){
						for(int j=startUNo;j<=endUNo;j++){
							img_src1="../../eOH/images/MXL/MXL"+j+".jpg";
							content.append("<td id='"+j+"' class='LABEL' ><img src='"+img_src1+"' width='25'></td>");	
						}
					}else if(perio_arch.equals("L")){
							for(int k=startUNo;k>=endUNo;k--){
								img_src1="../../eOH/images/MDL/MDL"+k+".jpg";
								content.append("<td id='"+k+"' class='LABEL' ><img src='"+img_src1+"' width='25'></td>");	
							}
					}
		content.append("</tr>");

		content.append("<tr><td width='10%' style='background-color:white' colspan='17'>&nbsp;</td></tr>");

		content.append("<tr><td width='10%' class='columnHeader'><img src='../../eOH/images/spacer.gif' height='10' width='66'></td>");
			/*tooth_str_arr = tooth_str.split(",");//commented by parul on 24/03/2010 for IN020187
			if(tooth_str_arr.length >1){
				display_tooth_str_arr = display_tooth_str.split(",");
				for(int j=0;j<tooth_str_arr.length;j++){
					content.append("<td id='"+tooth_str_arr[j]+"' class='columnHeader'>"+display_tooth_str_arr[j]+"</td>");
				}
			}
			else{
				for(int j=1;j<=16;j++){
					content.append("<td id='"+j+"' class='columnHeader'></td>");
				}
			}*/

				tooth_str_arr = tooth_str.split(",");
					if(perio_arch.equals("L")){
						if(tooth_str_arr.length >1){
							display_tooth_str_arr = display_tooth_str.split(",");
								for(int j=tooth_str_arr.length-1;j>=0;--j){
									content.append("<td id='"+tooth_str_arr[j]+"' class='columnHeader'>"+display_tooth_str_arr[j]+"</td>");
								}
						}else{
							for(int j=1;j<=16;j++){
								content.append("<td id='"+j+"' class='columnHeader'></td>");
							}
						}	
					}else{		
						if(tooth_str_arr.length >1){
							display_tooth_str_arr = display_tooth_str.split(",");
							for(int j=0;j<tooth_str_arr.length;j++){
								content.append("<td id='"+tooth_str_arr[j]+"' class='columnHeader'>"+display_tooth_str_arr[j]+"</td>");
							}
						}else{
							for(int j=1;j<=16;j++){
								content.append("<td id='"+j+"' class='columnHeader'></td>");

							}
						}
					}
		content.append("</tr>");

		content.append("<tr><td width='10%' style='background-color:white' colspan='17'>&nbsp;</td></tr>");

		content.append("<tr><td class='label' width='10%'><B>Lingual</B></td>");
		/*	for(int j=1;j<=16;j++){//commented by parul on 24/03/2010 for IN020187
				String img_src = "../../eOH/images/BOTTOM/"+j+"palatal.gif";
				content.append("<td id='"+j+"' class='LABEL' ><img src='"+img_src+"' width='25'></td>");
			}*/
			if(perio_arch.equals("L")){
				startUNo=32;endUNo=17;
				}else if (perio_arch.equals("U")){startUNo=1;endUNo=16;}
					if(perio_arch.equals("U")){
						for(int j=startUNo;j<=endUNo;j++){
							img_src1="../../eOH/images/MXL/MXL"+j+".jpg";
							content.append("<td id='"+j+"' class='LABEL' ><img src='"+img_src1+"' width='25'></td>");	
						}
					}else if(perio_arch.equals("L")){
						for(int k=startUNo;k>=endUNo;k--){
							img_src1="../../eOH/images/MDL/MDL"+k+".jpg";
							content.append("<td id='"+k+"' class='LABEL' ><img src='"+img_src1+"' width='25'></td>");	
						}
					}
		content.append("</tr>");
		
		pstmt = con.prepareStatement(sql_component);
		pstmt.setString(1,perio_chart);
		rs = pstmt.executeQuery();
		while(rs.next()){
			if(rs.getString("SURFACES_APPL_YN").equals("Y")){
				short_desc = rs.getString("COMPONENT_SHORT_DESC_USER_DEF");
				content.append("<tr><td width='10%' class='label'><font size='1'>"+short_desc+"</font></td>");
			
					tooth_str_arr = tooth_str.split(",");
					display_tooth_str_arr = display_tooth_str.split(",");
					/*for(int j=0;j<tooth_str_arr.length;j++){//commented by parul on 24/03/2010 for IN020187
						String td_id = rs.getString("COMPONENT_CODE") + tooth_str_arr[j] +"P";
						content.append("<td id='"+td_id+"' width='2%' align='center'>&nbsp;</td>");
					}*/
				if(perio_arch.equals("U")){
						for(int j=0;j<tooth_str_arr.length;j++){
							String td_id = checkForNull(rs.getString("COMPONENT_CODE")) + tooth_str_arr[j] +"P";
							content.append("<td id='"+td_id+"' width='2%' align='center'>&nbsp;</td>");
						}
					}else if(perio_arch.equals("L")){
						for(int j=tooth_str_arr.length-1;j>=0;--j){
							String td_id = checkForNull(rs.getString("COMPONENT_CODE")) + tooth_str_arr[j] +"P";
							content.append("<td id='"+td_id+"' width='2%' align='center'>&nbsp;</td>");
						}
					}
				content.append("</tr>");
			
			}
		}
		content.append("</table>");
		//Commented and Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
		//content.append("<input type = 'hidden' name= 'params' value = '"+request.getQueryString()+"'><input type = 'hidden' name= 'patient_id' value = '"+patient_id+"'><input type = 'hidden' name= 'permanent_deciduous_flag' value = '"+permanent_deciduous_flag+"'><input type = 'hidden' name= 'tooth_numbering_system' value = '"+tooth_numbering_system+"'><input type = 'hidden' name= 'facility_id' value = '"+facility_id+"'><input type = 'hidden' name= 'chart_num' value = '"+chart_num+"'><input type = 'hidden' name= 'chart_line_num' value = '"+chart_line_num+"'><input type = 'hidden' name= 'perio_chart' value = '"+perio_chart+"'><input type = 'hidden' name= 'baseline_active_yn' value = '"+baseline_active_yn+"'><input type = 'hidden' name= 'baseline_closed_yn' value = '"+baseline_closed_yn+"'><input type = 'hidden' name= 'hist_image_values' value = '"+hist_image_values+"'>");
		content.append("<input type = 'hidden' name= 'params' value = '"+request.getQueryString()+"'><input type = 'hidden' name= 'patient_id' value = '"+patient_id+"'><input type = 'hidden' name= 'permanent_deciduous_flag' value = '"+permanent_deciduous_flag+"'><input type = 'hidden' name= 'tooth_numbering_system' value = '"+tooth_numbering_system+"'><input type = 'hidden' name= 'facility_id' value = '"+facility_id+"'><input type = 'hidden' name= 'chart_num' value = '"+chart_num+"'><input type = 'hidden' name= 'chart_line_num' value = '"+chart_line_num+"'><input type = 'hidden' name= 'perio_chart' value = '"+perio_chart+"'><input type = 'hidden' name= 'baseline_active_yn' value = '"+baseline_active_yn+"'><input type = 'hidden' name= 'baseline_closed_yn' value = '"+baseline_closed_yn+"'><input type = 'hidden' name= 'hist_image_values' value = '"+hist_image_values+"'><input type='hidden' name='oh_chart_level' id='oh_chart_level' value="+oh_chart_level+" >");

		content.append("</form>");
		if(tab_code.equals("BC")){
			content.append("<script>loadSurfaceStaticValuesForHistory();</script>");
		}
		else if(tab_code.equals("EC")){
			content.append("<script>loadEvalSurfaceStaticValuesForHistory();</script>");
		}
		content.append("</body></html>");

		StringReader reader1 = new StringReader(content.toString());
		int len = content.length();

		String updateSql = "UPDATE OH_PERIODONTAL_CHART_HDR_LINE SET  RESULT_TEXT = ?  WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ?";
		pstmt = con.prepareStatement(updateSql);
		pstmt.setCharacterStream(1,reader1,len);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,patient_id);
		pstmt.setString(4,chart_num);
		pstmt.setString(5,chart_line_num);
		pstmt.executeUpdate();
		con.commit();

		
}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}
		
%>
	
	<!-- <script>
		loadSurfaceValues();
	</script> -->

