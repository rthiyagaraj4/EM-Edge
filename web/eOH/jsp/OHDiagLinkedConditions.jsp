<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,eOH.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
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

		String facility_id = "";
		String encounter_id = "";
		String chart_num = "";

        String locale = (String)session.getAttribute("LOCALE"); 
		String patient_id = checkForNull(request.getParameter("patient_id"));
	    String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
		String accession_num = checkForNull(request.getParameter("accession_num"));
		String term_code = checkForNull(request.getParameter("term_code"));
		String term_set_id = checkForNull(request.getParameter("term_set_id"));

		StringTokenizer accession_num_token = new StringTokenizer(accession_num,"||");
		while(accession_num_token.hasMoreTokens()){
			facility_id		=accession_num_token.nextToken();
			encounter_id	=accession_num_token.nextToken();
			chart_num	=accession_num_token.nextToken();
		}
		
		String site_type = "";
		String area = "";
		String surface_desc = "";
	    String condition_type = "";
		String condition_desc = "";
		String site_type_desc = "";
		int row_count = 0;
		String classValue = "";
		
		//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
		String oh_chart_level = "";
		//
%>

<html>
	<head>
        <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	</head>
<%
	try{
			con=ConnectionManager.getConnection(request);
            if(tooth_numbering_system.equals("")){
				//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
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
				}else{//End
					pstmt=con.prepareStatement("SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?");
					pstmt.setString(1,facility_id);
				}
				rs=pstmt.executeQuery();
				while(rs.next()){
					tooth_numbering_system = checkForNull(rs.getString("tooth_numbering_system"));
				}
			}

%>
  <body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
  <form name="OHDiagLinkedConditions" id="OHDiagLinkedConditions"   method="post" target="messageFrame">
      <table align='center' cellpadding='3' cellspacing='0' border='1' width='100%'>
             <%
                            if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
                           
							//pstmt=con.prepareStatement("SELECT A.CONDITION_TYPE, (SELECT F.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW F WHERE A.CONDITION_TYPE = F.CONDITION_TYPE AND F.LANGUAGE_ID = ?) CONDITION_TYPE_DESC, A.SITE_TYPE, (SELECT K.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM K WHERE K.TOOTH_NO = A.TOOTH_NO AND K.NUMBERING_SYSTEM = ?) TOOTH_NO, (SELECT C.ARCH_DESC FROM OH_ARCH_LANG_VW C WHERE C.ARCH_ID=A.ARCH_SNO AND C.LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ?) ARCH_DESC, (SELECT D.QUADRANT_DESC FROM OH_QUADRANT_LANG_VW D WHERE D.QUADRANT_SNO=A.QUADRANT_SNO AND D.LANGUAGE_ID = ? AND D.NUMBERING_SYSTEM = ? AND ROWNUM = '1') QUADRANT_DESC, (SELECT L.SURFACE_NAME FROM OH_SURFACE_LANG_VW L WHERE L.SURFACE_CODE = A.SURFACE_CODE AND L.LANGUAGE_ID = ?) SURFACE_NAME, (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?) CONDITION_DESC FROM OH_RESTORATIVE_CHART_DTL A,  OH_DIAG_COND_LINK E WHERE A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.CONDITION_CODE = E.CONDITION_CODE AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.TREATMENT_CONDITION = 'C' ORDER BY A.CONDITION_TYPE");
							pstmt=con.prepareStatement("SELECT A.CONDITION_TYPE, (SELECT F.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW F WHERE A.CONDITION_TYPE = F.CONDITION_TYPE AND F.LANGUAGE_ID = ?) CONDITION_TYPE_DESC, A.SITE_TYPE, (SELECT G.SITE_DESC FROM OH_SITE_TYPE_LANG_VW G WHERE G.SITE_TYPE = A.SITE_TYPE AND LANGUAGE_ID = ?) SITE_TYPE_DESC,(SELECT K.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM K WHERE K.TOOTH_NO = A.TOOTH_NO AND K.NUMBERING_SYSTEM = ?) TOOTH_NO, (SELECT C.ARCH_DESC FROM OH_ARCH_LANG_VW C WHERE C.ARCH_ID=A.ARCH_SNO AND C.LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ?) ARCH_DESC, (SELECT D.QUADRANT_DESC FROM OH_QUADRANT_LANG_VW D WHERE D.QUADRANT_SNO=A.QUADRANT_SNO AND D.LANGUAGE_ID = ? AND D.NUMBERING_SYSTEM = ? AND ROWNUM = '1') QUADRANT_DESC, (SELECT L.SURFACE_NAME FROM OH_SURFACE_LANG_VW L WHERE L.SURFACE_CODE = A.SURFACE_CODE AND L.LANGUAGE_ID = ?) SURFACE_NAME, (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?) CONDITION_DESC FROM OH_RESTORATIVE_CHART_DTL A,  OH_DIAG_COND_LINK E WHERE A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.CHART_LINE_NUM = E.CHART_LINE_NUM AND A.CONDITION_CODE = E.CONDITION_CODE AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.TREATMENT_CONDITION = 'C' AND E.TERM_CODE = ? AND E.TERM_SET_ID = ? AND NVL(A.STATUS,'X') != 'E' ORDER BY A.CONDITION_TYPE");
						
							pstmt.setString(1,locale);//LANGUAGE_ID
			                pstmt.setString(2,locale);//LANGUAGE_ID
							pstmt.setString(3,tooth_numbering_system);//NUMBERING_SYSTEM
							pstmt.setString(4,locale);//LANGUAGE_ID
							pstmt.setString(5,tooth_numbering_system);//NUMBERING_SYSTEM
							pstmt.setString(6,locale);//LANGUAGE_ID
							pstmt.setString(7,tooth_numbering_system);//LANGUAGE_ID
							pstmt.setString(8,locale);//LANGUAGE_ID
							pstmt.setString(9,locale);//LANGUAGE_ID
							pstmt.setString(10,facility_id);//OPERATING_FACILITY_ID
							pstmt.setString(11,patient_id);//PATIENT_ID
							pstmt.setString(12,chart_num);//CHART_NUM
							pstmt.setString(13,term_code);//CHART_NUM
							pstmt.setString(14,term_set_id);//CHART_NUM
						    rs=pstmt.executeQuery();
							while(rs.next()){
								row_count++;
								condition_type = checkForNull(rs.getString("CONDITION_TYPE"));
					            condition_desc = checkForNull(rs.getString("CONDITION_DESC"));
								site_type_desc = checkForNull(rs.getString("SITE_TYPE_DESC"));
								site_type = checkForNull(rs.getString("SITE_TYPE"));
                               
								if(site_type.equals("ARCH")){
									area = checkForNull(rs.getString("ARCH_DESC"));
								}
								else if(site_type.equals("QUAD")){
									area = checkForNull(rs.getString("QUADRANT_DESC"));
								}
								else{
									area = checkForNull(rs.getString("TOOTH_NO"));
								}

								surface_desc = checkForNull(rs.getString("SURFACE_NAME"));

								if ( row_count % 2 == 0 )
                                         classValue = "QRYEVEN" ;
                               else
				                    	classValue = "QRYODD" ;

                             
						%>

								<tr>
									<td width="10%" align='left' class="<%=classValue%>"><%=checkForNull(rs.getString("CONDITION_TYPE_DESC"))%></td>
									<td width="10%" align='left' class="<%=classValue%>"><%=condition_desc%></td>
									<td width="10%" align='left' class="<%=classValue%>"><%=site_type_desc%></td>
									<td width="10%" align='left' class="<%=classValue%>"><%=area%></td>
									<%
										if(surface_desc.equals("")){
									%>
											<td width="10%" align='left' class="<%=classValue%>">&nbsp;</td>
											
									<%
										}else{
									%>
											<td width="10%" align='left' class="<%=classValue%>"><%=surface_desc%></td>
									<%
										}
									%>
								</tr>
						<%
							}
						%>
			</table>
             <table align='center' cellpadding='3' cellspacing='0' border='0' width='100%'>
					 <tr>
					    <td width="15%" colspan="2" class="button"><input type="button" class="button" name="close" id="close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="parent.window.close();"> 
					</td></tr>
		   </table>
		</form>
 </body> </html>

<%
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

