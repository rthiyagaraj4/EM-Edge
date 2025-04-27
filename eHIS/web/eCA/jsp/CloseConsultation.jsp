<!DOCTYPE html>
<%@ page import= "java.util.*,java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String encounter_id= request.getParameter("episode_id");	
		String facility_id=(String) session.getValue("facility_id");
		String practitioner_id="";
		String location_code=request.getParameter("location_code");	
		String location_type=request.getParameter("location_type");	
		String patient_id=request.getParameter("patient_id");	

		int visit_status =0;
		String ae_episode_yn ="";
		String ae_brought_dead_yn="";
		String ae_treatment_area_code="";
		String module_id="";
		String episode_id = "";
		String visit_id   = "";
		String allow_chkout_with_bill_stmt_yn = "N";
		/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start*/
		String chk_for_pen_orders_bfr_chkout	= "N";
		String checkout_allow_yn				= "N";
		String pend_ord_stats					= "N";
		/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End*/

		PreparedStatement stmt1=null;
		ResultSet rs1=null;

		PreparedStatement stmt=null;
		ResultSet rs=null;
		Connection con=null;
	%>
<html>
<head>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

	<%
		//String sql="Select visit_status,attend_practitioner_id,ae_episode_yn,brought_dead_yn,episode_id, op_episode_visit_num   from pr_encounter where facility_id  = '"+facility_id+"' and encounter_id = "+encounter_id+" ";//common-icn-0180
	    String sql="Select visit_status,attend_practitioner_id,ae_episode_yn,brought_dead_yn,episode_id, op_episode_visit_num   from pr_encounter where facility_id  = ? and encounter_id = ? ";//common-icn-0180
	
		String ConsOrdChartYn = request.getParameter("ConsOrdChartYn") == null ? "N" : request.getParameter("ConsOrdChartYn");//added for package billing
		if(ConsOrdChartYn.equals("N")){
		try
			{
				con=ConnectionManager.getConnection(request);
				stmt1=con.prepareStatement(sql);
				//common-icn-0180 starts
				stmt1.setString(1, facility_id);
				stmt1.setString(2, encounter_id);
				//common-icn-0180 end
				rs1=stmt1.executeQuery();

				if(rs1!=null)
				{
					while(rs1.next()){
						visit_status=rs1.getInt(1);
						practitioner_id=rs1.getString(2);
						ae_episode_yn=rs1.getString(3);
						ae_brought_dead_yn=rs1.getString(4);
						if(ae_brought_dead_yn==null) ae_brought_dead_yn="N";
						episode_id = rs1.getString("episode_id");
						if(episode_id==null) episode_id="";
						visit_id   = rs1.getString("op_episode_visit_num");
						if(visit_id==null) visit_id="";

					}
				}
				if(rs1!=null) rs1.close();
				if(stmt1!=null) stmt1.close();
/*                
				String sql_ae1="Select allow_chkout_with_bill_stmt_yn from AE_PARAM where OPERATING_FACILITY_ID='"+facility_id+"'";
					stmt=con.prepareStatement(sql_ae1);
					rs=stmt.executeQuery();

					if(rs!=null)
					{
					  if (rs.next())
				      {
						allow_chkout_with_bill_stmt_yn=rs.getString("allow_chkout_with_bill_stmt_yn");
   					    if(allow_chkout_with_bill_stmt_yn==null) allow_chkout_with_bill_stmt_yn="N";
					  }
					}
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
*/

				if(ae_episode_yn.equals("Y"))
				{
					/*Modified By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start*/
					//String sql_ae1="Select allow_chkout_with_bill_stmt_yn from AE_PARAM where OPERATING_FACILITY_ID='"+facility_id+"'";
					//String sql_ae1="Select allow_chkout_with_bill_stmt_yn,chk_for_pen_orders_bfr_chkout,checkout_allow_yn,(select Or_patient_Order_Pend('"+patient_id+"','"+facility_id+"','"+encounter_id+"','C') from dual) pend_ord_stats from AE_PARAM where OPERATING_FACILITY_ID='"+facility_id+"'";//common-icn-0180
					/*Modified By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End*/
					String sql_ae1="Select allow_chkout_with_bill_stmt_yn,chk_for_pen_orders_bfr_chkout,checkout_allow_yn,(select Or_patient_Order_Pend(?,?,?,'C') from dual) pend_ord_stats from AE_PARAM where OPERATING_FACILITY_ID=?";//common-icn-0180
					
					System.err.println("sql_ae1==>"+sql_ae1);
						stmt=con.prepareStatement(sql_ae1);
						//common-icn-0180 starts
						stmt.setString(1, patient_id);
						stmt.setString(2, facility_id);
						stmt.setString(3, encounter_id);
						stmt.setString(4, facility_id);
						//common-icn-0180 ends
						rs=stmt.executeQuery();

						if(rs!=null)
						{
						  if (rs.next())
						  {
							allow_chkout_with_bill_stmt_yn=rs.getString("allow_chkout_with_bill_stmt_yn");
							if(allow_chkout_with_bill_stmt_yn==null) allow_chkout_with_bill_stmt_yn="N";
							/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start*/
							chk_for_pen_orders_bfr_chkout =rs.getString("chk_for_pen_orders_bfr_chkout");
							if(chk_for_pen_orders_bfr_chkout==null) chk_for_pen_orders_bfr_chkout="N";
							checkout_allow_yn =rs.getString("checkout_allow_yn");
							if(checkout_allow_yn==null) checkout_allow_yn="N";
							pend_ord_stats =rs.getString("pend_ord_stats");
							if(pend_ord_stats==null) pend_ord_stats="N";
							/*Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End*/
						  }
						}
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();		
					
					module_id="AE";
					/*String sql_ae1="Select brought_dead_yn from ae_pat_emergency_detail where facility_id='"+facility_id+"' and encounter_id="+encounter_id+" ";
					stmt=con.prepareStatement(sql_ae1);
					rs=stmt.executeQuery();

					if(rs!=null)
					{
						while(rs.next())
						{
							ae_brought_dead_yn=rs.getString(1);
//							if(ae_brought_dead_yn==null) ae_brought_dead_yn="N";
						}
					}*/

				//String sql_ae2="Select treatment_area_code from op_patient_queue where facility_id='"+facility_id+"' and encounter_id="+encounter_id+" ";//common-icn-0180 starts
					String sql_ae2="Select treatment_area_code from op_patient_queue where facility_id=? and encounter_id=? ";//common-icn-0180 starts
					
					stmt=con.prepareStatement(sql_ae2);
					//common-icn-0180 starts starts
					stmt.setString(1, facility_id);
					stmt.setString(2, encounter_id);
					//common-icn-0180 starts ends
					rs=stmt.executeQuery();

					if(rs!=null)
					{
						while(rs.next())
						{
							ae_treatment_area_code=rs.getString(1);
						}
					}

				}
				else
					module_id="OP";

				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();


				if(rs1==null ||  visit_status>=7)
				{
						%>
						<script>
							alert(getMessage('CONS_NOT_APPL','CA'));
						</script>
				<%} 

				else {%>
			
				<script> 
							$(document).ready(function () {
							if("<%=chk_for_pen_orders_bfr_chkout%>"=="Y"){
							showPendingOrderWindow();
							}else{
							frames[1].location.href='../../eOP/jsp/PatCheckoutModel.jsp?called_from=CA&module_id=<%=module_id%>&ae_brought_dead_yn=<%=ae_brought_dead_yn%>&ae_treatment_area_code=<%=ae_treatment_area_code%>&encounterid=<%=encounter_id%>&practitionerid=<%=practitioner_id%>&locationcode=<%=location_code%>&patientid=<%=patient_id%>&locationtype=<%=location_type%>&episode_id=<%=episode_id%>&visit_id=<%=visit_id%>&allow_chkout_with_bill_stmt_yn=<%=allow_chkout_with_bill_stmt_yn%>&<%=request.getQueryString()%>';
							}
							}); 
	
	async function showPendingOrderWindow(){
		var arguments	= "";
		var dialogHeight= "29" ;
		var dialogTop = "125" ;
		var dialogWidth	= "50" ;
		var status = "no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
		var url="../../eOR/jsp/ViewPendingOrders.jsp?patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>&facility_id=<%=facility_id%>&discharge_ind=C";

		 if("<%=pend_ord_stats%>" =="Y"){
			if("<%=checkout_allow_yn%>"=="Y"){ 
					var retVal = new String();
					retVal = await window.showModalDialog(url,arguments,features);
					if(window.confirm(getMessage("PROCEED_CHECKOUT","AE"))) {
						frames[1].location.href='../../eOP/jsp/PatCheckoutModel.jsp?called_from=CA&module_id=<%=module_id%>&ae_brought_dead_yn=<%=ae_brought_dead_yn%>&ae_treatment_area_code=<%=ae_treatment_area_code%>&encounterid=<%=encounter_id%>&practitionerid=<%=practitioner_id%>&locationcode=<%=location_code%>&patientid=<%=patient_id%>&locationtype=<%=location_type%>&episode_id=<%=episode_id%>&visit_id=<%=visit_id%>&allow_chkout_with_bill_stmt_yn=<%=allow_chkout_with_bill_stmt_yn%>&<%=request.getQueryString()%>';
					}
			}else{
				if(window.confirm(getMessage("ORDER_PENDING_CNT_PROCEED_VIEW","IP"))) {
					var retVal = new String();
					retVal = await window.showModalDialog(url,arguments,features);
				}
			}
		}else{
			frames[1].location.href='../../eOP/jsp/PatCheckoutModel.jsp?called_from=CA&module_id=<%=module_id%>&ae_brought_dead_yn=<%=ae_brought_dead_yn%>&ae_treatment_area_code=<%=ae_treatment_area_code%>&encounterid=<%=encounter_id%>&practitionerid=<%=practitioner_id%>&locationcode=<%=location_code%>&patientid=<%=patient_id%>&locationtype=<%=location_type%>&episode_id=<%=episode_id%>&visit_id=<%=visit_id%>&allow_chkout_with_bill_stmt_yn=<%=allow_chkout_with_bill_stmt_yn%>&<%=request.getQueryString()%>';							
		}
	}
				</script>				
				<form name="chkoutmodel" id="chkoutmodel">
				<frameset rows='0%,88%,0%' framespacing=0 id="checkOutFrames">
		    		<frame name='PLINE' id='PLINE' SRC='../../eCommon/html/blank.html' noresize  frameborder=no scrolling='no'>
					<!--Modified By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start-->
					<!--<frame name='detail' id='detail' src='../../eOP/jsp/PatCheckoutModel.jsp?called_from=CA&module_id=<%=module_id%>&ae_brought_dead_yn=<%=ae_brought_dead_yn%>&ae_treatment_area_code=<%=ae_treatment_area_code%>&encounterid=<%=encounter_id%>&practitionerid=<%=practitioner_id%>&locationcode=<%=location_code%>&patientid=<%=patient_id%>&locationtype=<%=location_type%>&episode_id=<%=episode_id%>&visit_id=<%=visit_id%>&allow_chkout_with_bill_stmt_yn=<%=allow_chkout_with_bill_stmt_yn%>&<%=request.getQueryString()%>' noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no'> -->
					<frame name='detail' id='detail' SRC='../../eCommon/html/blank.html' noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no'>
					<!--Modified By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End-->
					<frame name='Dummy_frame' id='Dummy_frame' src='../../eCommon/html/blank.html' framesetborder=0 frameborder=0 noresize scrolling='no'>
        		</frameset>
				</form>
				<!--Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] Start-->
				
					<!--Added By Dharma on 1st Oct 2018 against GHL-CRF-0517 [IN:067155] End-->
<%
				}
				
			}catch(Exception e)
			{
				//out.println("Exception::"+e);//common-icn-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
				if(stmt!=null) stmt.close();
				if(rs!=null) rs.close();

				if(stmt1!=null) stmt1.close();
				if(rs1!=null) rs1.close();
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}
		}else{//added for package billing
			out.println("<script>top.content.CommonToolbar.displayFunctionName('');alert(getMessage('CLOSE_CONSULT_SPLTY','OP'));parent.CommonToolbar.ShowMenu.style.display='none';parent.CommonToolbar.HideMenu.style.display='inline';parent.workArea.cols = '200px,0%,*,0%';</script>");
		}
					%>
				
				</html>

