<!DOCTYPE html>

<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<html>
	<head>
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			String facility_id = (String)session.getAttribute("facility_id");
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>	
		<script src='../../eCA/js/RecMaternityCons.js' language='javascript'></script>	
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>
	<body onKeyDown='lockKey()'>
		<form name='recMaternityPendingTasksForm' id='recMaternityPendingTasksForm'>
			<TABLE width='100%' align='center' border=1 cellspacing=0>
				<!-- <tr>
					<th  colspan='3' align='left'>Pending Tasks</th>
				</tr> -->
				<tr>
				<!-- 	<th>Task Code	</th> -->
					<th>Task Description</th>
				<!-- 	<th>Force Complete &nbsp;<input type='checkbox' name='forceCompleteAll' id='forceCompleteAll' onclick='checkAll(this)'></th> -->
				</tr>
	<%
		String queryString= request.getQueryString() == null ? "" : request.getQueryString();
		String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		String module_id = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
		String cycle_no = request.getParameter("cycle_no") == null ? "0" : request.getParameter("cycle_no");
		//String encounter_id = request.getParameter("encounter_id") == null ? "0" : request.getParameter("encounter_id");
		String splty_event_code = request.getParameter("splty_event_code") == null ? "" : request.getParameter("splty_event_code");
//		String splty_task_code = request.getParameter("splty_task_code") == null ? "" : request.getParameter("splty_task_code");
		int count = 0;
		String classValue = "QRYEVEN";
		String splty_task_code = "";
		String no_of_birth = "";
		String birth_order = "";
		String delivery_indicator = "";
		Boolean delv_rec = true;
//		String splty_task_desc = "";
		String sec_hdg_code = "";
		Connection con = null;
		String query_proc = "";
		String  NoOfBirthQry = "";
		String  sec_det_qry = "";
		String  transDateQryNew = "";
		PreparedStatement pstmt = null;
		PreparedStatement stmt=null,pstmt1= null,pstmtSect = null;
		ResultSet res = null,res1=null,rs = null,rsSect = null;
		
		String query = "SELECT a.SPLTY_TASK_CODE, b.splty_task_desc FROM CA_SPLTY_TASKS_FOR_EVENTS A, CA_SPLTY_TASKS B WHERE SPLTY_EVENT_CODE=? AND B.SPLTY_TASK_CODE NOT IN ('MCT003','MCT004') AND a.SPLTY_TASK_CODE = b.SPLTY_TASK_CODE and NOT EXISTS (SELECT 1 FROM CA_PAT_SPLTY_EPISODE_TASK WHERE SPLTY_EVENT_CODE=A.SPLTY_EVENT_CODE    AND SPLTY_TASK_CODE=A.SPLTY_TASK_CODE AND PATIENT_ID=? AND MODULE_ID=?	AND CYCLE_NO=?)";
//order_line_num+"#"+order_id
		try
		{
			con = ConnectionManager.getConnection(request);

			pstmt = con.prepareStatement(query);
			pstmt.setString(1,splty_event_code);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,module_id);
			pstmt.setString(4,cycle_no);

			res = pstmt.executeQuery();
			
			while(res.next())
			{
				if(count % 2 == 0) classValue = "QRYEVEN";
				else classValue = "QRYODD";
				out.println("<tr>");
				/*out.println("<td class='"+classValue+"'>"+res.getString("SPLTY_TASK_CODE"));
				out.println("</td>");*/
				
				splty_task_code = res.getString("splty_task_code") == null ?"": res.getString("splty_task_code");
				

				if(splty_task_code.equals("MCT009")){
					
					query_proc="select (SELECT delivery_indicator FROM mp_nod_type where NOD_TYPE = DELIVERY_TYPE) delivery_indicator from CA_SPL_DELIVERY_RECORD where FACILITY_ID = ?  and MOTHER_PATIENT_ID=? and CYCLE_NO = ? " ;
					
					stmt = con.prepareStatement(query_proc);
					stmt.setString(1,facility_id);
					stmt.setString(2,patient_id);
					stmt.setString(3,cycle_no);
					res1 = stmt.executeQuery();
					if(res1.next()){
					
					 delivery_indicator =  res1.getString("delivery_indicator")==null?"":res1.getString("delivery_indicator");
					}
					
					if(res1 != null)res1.close();
					if(stmt != null)stmt.close();

					if(delivery_indicator.equals("C")||delivery_indicator.equals("O"))
					{
					query = "select 1 from PR_ENCOUNTER_PROCEDURE where ACCESSION_NUM = ? ";
					stmt = con.prepareStatement(query);
					stmt.setString(1,"MC!"+patient_id+"!"+cycle_no+"!");
					res1 = stmt.executeQuery();
					if(!res1.next()){
						out.println("<td class='"+classValue+"'>"+res.getString("splty_task_desc"));
						out.println("</td>");					
					}
					if(res1 != null)res1.close();
					if(stmt != null)stmt.close();
					}
				}else if(splty_task_code.equals("MCT008")){
					//Below query and code is added by Archana Dhal on 5/6/2010 related to IN020935. 
					query = "select (select A.NO_OF_BIRTH  from CA_SPL_DELIVERY_RECORD A where A. FACILITY_ID= ? and A.MOTHER_PATIENT_ID= ? and CYCLE_NO= ?) NO_OF_BIRTH , (select max(B.BIRTH_ORDER)  from MP_birth_register B where B.MOTHER_PATIENT_ID= ? and  MC_CYCLE_NO = ? ) BIRTH_ORDER from dual ";

					NoOfBirthQry = " select (SELECT delivery_indicator FROM mp_nod_type where NOD_TYPE = DELIVERY_TYPE) delivery_indicator  from CA_SPL_DELIVERY_RECORD A where A. FACILITY_ID= ? and A.MOTHER_PATIENT_ID= ? and CYCLE_NO= ? AND ROWNUM=1 ";

		         	sec_det_qry = " select CHILD_SEC_HDG_CODE from CA_SUBSECTION_LINK_VW where HEADER_SEC_HDG_CODE = 'MC25' order by CHILD_SEQ_NUM " ;

			        transDateQryNew = " select 1 from  CA_PAT_SPLTY_TASK_DTL A,CA_PAT_SPLTY_EPISODE_TASK B where A.ACCESSION_NUM=B.ACCESSION_NUM AND B.PATIENT_ID =? AND B.FACILITY_ID=? AND B.MODULE_ID= ? AND B.CYCLE_NO = ? AND A.HDR_CODE= 'MC25' AND A.SUBHDR_CODE = ? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE='MCT005' AND BIRTH_ORDER = ? and FINALIZE_YN='Y' ";

					pstmt1	= con.prepareStatement(NoOfBirthQry);
			        pstmt1.setString(1,facility_id);
			        pstmt1.setString(2,patient_id);
			        pstmt1.setInt(3,Integer.parseInt(cycle_no));
			        rs	 =	pstmt1.executeQuery();
			        while(rs.next())
			          {

				        delivery_indicator = rs.getString("delivery_indicator") == null?"0":rs.getString("delivery_indicator");
							
			          } 
			       // if(rs!=null) rs.close();
			       // if(pstmt1!=null) pstmt1.close();

					stmt = con.prepareStatement(query);
					stmt.setString(1,facility_id);
					stmt.setString(2,patient_id);
					stmt.setString(3,cycle_no);
					stmt.setString(4,patient_id);
					stmt.setString(5,cycle_no);
					res1 = stmt.executeQuery();
					if(res1.next()){
						no_of_birth = res1.getString("NO_OF_BIRTH") == null?"0":res1.getString("NO_OF_BIRTH");
						birth_order = res1.getString("BIRTH_ORDER") == null?"0":res1.getString("BIRTH_ORDER");
						if(Integer.parseInt(no_of_birth) != Integer.parseInt(birth_order))
						{
							out.println("<td class='"+classValue+"'>"+res.getString("splty_task_desc"));
							out.println("</td>");		
						}
						else if(Integer.parseInt(no_of_birth)>0&&!delivery_indicator.equals("C"))
			               {
							  pstmtSect	= con.prepareStatement(sec_det_qry);
				              pstmt1	= con.prepareStatement(transDateQryNew);
							  for(int DLoop=1;DLoop<=Integer.parseInt(no_of_birth);DLoop++)
				              {
				
					             rsSect = pstmtSect.executeQuery();

					             while(rsSect.next())
					           {
						           sec_hdg_code =rsSect.getString("CHILD_SEC_HDG_CODE")==null?"":rsSect.getString("CHILD_SEC_HDG_CODE");

						
						           if(sec_hdg_code.equals("MC05"))
						            {
							          continue;
						            }
						
						        pstmt1.setString(1,patient_id);
						        pstmt1.setString(2,facility_id);
						        pstmt1.setString(3,module_id);
						        pstmt1.setInt(4,Integer.parseInt(cycle_no));
						        //pstmt.setString(5,sub_act_code);
						        pstmt1.setString(5,sec_hdg_code);
						        pstmt1.setString(6,splty_event_code);
						        //pstmt.setString(7,splty_task_code);
						        pstmt1.setInt(7,DLoop);
						        rs = pstmt1.executeQuery();
					
						       if(!rs.next())
						       {
							     delv_rec = false;
							     break;
						       }
					       }
					       if(!delv_rec)
						   {
							 break;
						   }
				          }
						 }
						 //count++;
					}
					if(res1 != null)res1.close();
					if(stmt != null)stmt.close();
					if(rs != null)rs.close();
				    if(pstmt1 != null)pstmt1.close();
				    if(rsSect != null)rsSect.close();
					if(pstmtSect != null)pstmtSect.close();
					if(!delv_rec)
				    {
					   out.println("<td class='"+classValue+"'>"+res.getString("splty_task_desc"));
					   out.println("</td>");
				    }
				  }else{
					out.println("<td class='"+classValue+"'>"+res.getString("splty_task_desc"));
					out.println("</td>");
				}
				/*out.println("<td class='"+classValue+"' align='center'><input type='checkbox' id='forceClose"+count+"'>");
				out.println("</td>");*/
				out.println("</tr>");
				count++;
			}
			if(res != null) res.close();
			if(pstmt != null) pstmt.close();			
		}
		catch(Exception e)
		{
			//out.println("Exception in RecMaternityOutcomeForcedComplete.jsp --"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();
		}
		finally
		{
			if(con!= null) ConnectionManager.returnConnection(con,request);
		}
	%>	
			<input type='hidden' name='queryString' id='queryString' value='<%=queryString%>'>
			<input type='hidden' name='count' id='count' value='<%=count%>'>
		</form>
	</body>
</html>

