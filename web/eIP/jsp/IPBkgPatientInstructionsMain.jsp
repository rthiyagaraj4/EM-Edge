<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*,com.ehis.util.*" %>
<html>
	<head>
		<title>
			<fmt:message key="eAM.PatInstructions.label" bundle="${am_labels}"/>
		</title>
		<script src='../../eIP/js/IPBkgPatientInstructions.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>

	<%
	String locale=(String)session.getAttribute("LOCALE");
	String bkg_refno=request.getParameter("booking_ref_no")==null?"":request.getParameter("booking_ref_no");
	String NUInsYN=request.getParameter("NUInsYN")==null?"N":request.getParameter("NUInsYN");
	String from_page=request.getParameter("from_page")==null?"":request.getParameter("from_page");
	String facilityId = (String) session.getValue( "facility_id" ) ;
	String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String viewinsdtlsYN=request.getParameter("viewinsdtlsYN")==null?"N":request.getParameter("viewinsdtlsYN");
	String display_order_instn="";
	String instn_id="";
	String inst_desc="";
	String checkYN="";
	Integer dis_ord;
	String nursing_unit_code=request.getParameter("nursing_unit_code")==null?"":request.getParameter("nursing_unit_code");		
	Connection connection = null;
	Statement stmt = null;
	ResultSet rset = null;
	try{
			String removePatInstruction=request.getParameter("removePatInstruction")==null?"N":request.getParameter("removePatInstruction");
			
			if(removePatInstruction.equals("Y")){
				session.removeAttribute("ipPatInstructionsMap");
			}
			if(!from_page.equals("createBooking")){
				
				connection = ConnectionManager.getConnection(request);
				stmt=connection.createStatement();
				TreeMap patInstructionsMap=(java.util.TreeMap)session.getAttribute("ipPatInstructionsMap");
				if(patInstructionsMap==null){
				patInstructionsMap=new TreeMap();
				String bkg_pat_ins="select count(*) insCount from ip_booking_list where facility_id='"+facilityId+"' and bkg_lst_ref_no='"+bkg_refno+"'";

				if(nursing_unit_code != null)
				{
					if(nursing_unit_code.equals("")){
					bkg_pat_ins=bkg_pat_ins+" and nursing_unit_code is null";
					}
					else{
						bkg_pat_ins=bkg_pat_ins+" and nursing_unit_code ='"+nursing_unit_code+"'";
					}
				}
			
				rset=stmt.executeQuery(bkg_pat_ins);
				int insCount=0;
				while(rset!=null && rset.next()){
					insCount=rset.getInt("insCount");
				}
				if (rset != null)
					rset.close();
				if(stmt != null)
					stmt.close();
					
				if(insCount == 0){			
										
					bkg_pat_ins="SELECT instruction_id, display_order,am_get_desc.am_pat_instructions (instruction_id, '"+locale+"', 1) INSTRUCTION_DESC, DEFAULT_LINKED_YN FROM IP_NURS_PAT_INSTRUCTIONS where facility_id='"+facilityId+"'";
					if(nursing_unit_code != null)
					{
						if(nursing_unit_code.equals("")){
							bkg_pat_ins=bkg_pat_ins+" and nursing_unit_code is null";
						}
						else{
							bkg_pat_ins=bkg_pat_ins+" and nursing_unit_code ='"+nursing_unit_code+"'";
						}
					}
					}else{
						bkg_pat_ins="select INSTRUCTION_ID, INSTRUCTION_DESC, DISPLAY_ORDER,'Y' DEFAULT_LINKED_YN  from ip_bkg_pat_instructions where BKG_REF_NO='"+bkg_refno+"'";
					}
					
					stmt=connection.createStatement();
					rset=stmt.executeQuery(bkg_pat_ins);
					session.removeAttribute("ipPatInstructionsMap");
					while(rset.next()){
						display_order_instn=rset.getString("DISPLAY_ORDER");
						instn_id=rset.getString("INSTRUCTION_ID");
						inst_desc=rset.getString("INSTRUCTION_DESC");
						checkYN=rset.getString("DEFAULT_LINKED_YN");
						String instns=instn_id+"||"+inst_desc+"||"+checkYN;
						dis_ord=new Integer(Integer.parseInt(display_order_instn));
						patInstructionsMap.put(dis_ord,instns);
					}
					session.setAttribute("ipPatInstructionsMap",patInstructionsMap);					
				}	
			}				
				
			
	%>
	 <iframe name='patinsframe' id='patinsframe' src='../../eIP/jsp/IPBkgPatientInstructions.jsp?from_page=<%=from_page%>&nursing_unit_code=<%=nursing_unit_code%>&NUInsYN=<%=NUInsYN%>&patient_id=<%=patient_id%>&booking_ref_no=<%=bkg_refno%>' frameborder=0 noresize scrolling='auto' marginheight='0' marginwidth='0' style='height:80vh;width:100vw'></iframe><iframe name='patinsbuttonframe' id='patinsbuttonframe' src='../../eIP/jsp/IPBkgPatientInstructionsButtons.jsp?viewinsdtlsYN=<%=viewinsdtlsYN%>&from_page=<%=from_page%>&NUInsYN=<%=NUInsYN%>' frameborder=0 noresize scrolling='no' marginheight='0' marginwidth='0' style='height:10vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder=0 scrolling='auto' style='height:10vh;width:100vw'></iframe>
	<%}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		if(rset!=null)rset.close();
		if(stmt!=null)stmt.close();
		ConnectionManager.returnConnection(connection,request);
	}
%>
</html>

