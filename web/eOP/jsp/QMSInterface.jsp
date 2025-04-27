<%@ page import="java.sql.*, java.util.*, java.text.*,java.io.*, java.net.*,webbeans.eCommon.*" contentType="text/html;charset=utf-8" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/> 


<%   
request.setCharacterEncoding("UTF-8");
Map hash = (Map)obj.parseXMLString( request ) ;
hash = (Map)hash.get("SEARCH") ;
//webbeans.op.PatientData patdata = new webbeans.op.PatientData();
Connection con=null;

try{

	java.util.Properties dbc_props	=	(Properties)session.getValue("jdbc") ;
	con=ConnectionManager.getConnection(request);
	//request.getParameter 
	
	String called_from=request.getParameter("called_function")==null?"0":request.getParameter("called_function");//Added for the SCF - MMS-SCF-167
	String queue_num=request.getParameter("queue_num")==null?"0":request.getParameter("queue_num");
	String clinic_code=request.getParameter("clinic_code");
	String p_locn_type=request.getParameter("p_locn_type");
	String other_res_type=request.getParameter("other_res_type")==null?"":request.getParameter("other_res_type");
	String other_res_code=request.getParameter("other_res_code")==null?"":request.getParameter("other_res_code");
	String room_num=request.getParameter("room_num");
	String current_queue_id=request.getParameter("queue_id")==null?"":request.getParameter("queue_id");	
	String issueCall=request.getParameter("issueCall")==null?"Y":request.getParameter("issueCall");	
	String pract_id=request.getParameter("pract_id");
	HashMap<String,String> qms_params=new HashMap();
	HashMap<String,String> audit_params=new HashMap();
	String calling_from=request.getParameter("callfunc");
	String patient_id=request.getParameter("patient_id");
	String encounterId1=request.getParameter("encounter_id");
	String queue_date=request.getParameter("queue_date");
	String appt_walk_in=request.getParameter("appt_walk_in");

	String customer_id=(String)session.getAttribute("CUSTOMER_ID");
	String loggedUser=(String) session.getValue("login_user");
	String clientMachine=dbc_props.getProperty("client_ip_address");
	String facilityID=(String)session.getValue("facility_id");
	String sessionID="";
	String qms_room_num=room_num;
	String qms_pract_id="";		
	String errorFromQMS="";//Added for the SCF - ML-BRU-SCF-1074
	if(called_from.equals("BLNGINS")){//Added for the SCF - MMS-SCF-167 - begin
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String VisitRule = "";
		  String strDesc="";
		  String strCode="";					 

		  String visit_type_ind=request.getParameter("vst_typ_frm_blng")==null?"":request.getParameter("vst_typ_frm_blng");
		  String vst_date_time=request.getParameter("vst_date_time")==null?"":request.getParameter("vst_date_time");
		   		  //Changes for the SCF - MMS-SCF-0082
		  String episode_id=request.getParameter("episode_id")==null?"":request.getParameter("episode_id");		
		  String blng_grp_id=request.getParameter("blng_grp_id")==null?"":request.getParameter("blng_grp_id");					 
		  String cust_grp_code=request.getParameter("cust_grp_code")==null?"":request.getParameter("cust_grp_code");
		  String cust_code=request.getParameter("cust_code")==null?"":request.getParameter("cust_code");					 
		  String policy_type_code=request.getParameter("policy_type_code")==null?"":request.getParameter("policy_type_code");					 
		  String old_vst_type_ind=request.getParameter("old_vst_type_ind")==null?"":request.getParameter("old_vst_type_ind");		
		  String frame_ref=request.getParameter("billing_frame")==null?"":request.getParameter("billing_frame");		
		  String locncode    = request.getParameter("care_locn_code")==null?"":request.getParameter("care_locn_code");	
		  String l_patient_id    = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");	
		 
		   int count = 0;
		   String visitTypeQuery = "SELECT visit_type_code,op_get_desc.op_visit_type (facility_id,visit_type_code,'en','2') short_desc FROM op_visit_type_for_clinic WHERE facility_id = '"+facilityID+"' AND clinic_code = '"+locncode+"' AND eff_status = 'E' and visit_type_ind in('"+visit_type_ind+"') order by 2";
		try{
		    pstmt   = con.prepareStatement(visitTypeQuery);
		    rs = pstmt.executeQuery() ;
			  if( rs != null ) { 
				while(rs.next()) {				
					strDesc = rs.getString( "short_desc" ) ;
					strCode = rs.getString( "visit_type_code" );
						%>
					var element = frames[1].frames[3].document.createElement('OPTION');
						element.text = '<%=strDesc%>';
						element.value= '<%=strCode%>';
						frames[1].frames[3].document.forms[0].visit_adm_type.add(element);		<%	
					count++;					
				}
			  }	%>
			frames[1].frames[3].document.forms[0].visit_adm_type.disabled = false;		
			
			<%
			
			
			if(count == 1) {
				%>
				frames[1].frames[3].document.forms[0].visit_adm_type.options[1].selected = true;
				frames[1].frames[3].document.forms[0].visit_adm_type.onchange();
				proceed=true;
				
			<%}else if(!old_vst_type_ind.equals("")){
				%>
				
				alert(getMessage('FIN_CHNGD_SEL_VST_TYPE','OP'));
				proceed=false;
				
				<%
			}%>
			 frames[1].frames[3].document.forms[0].blng_grp_id.value = '<%=blng_grp_id%>'
			 frames[1].frames[3].document.forms[0].cust_grp_code.value = '<%=cust_grp_code%>'
			 frames[1].frames[3].document.forms[0].cust_code.value = '<%=cust_code%>'
			 frames[1].frames[3].document.forms[0].policy_type_code.value = '<%=policy_type_code%>'				
			 
			 <%			
			String setreadonly  = "F";     
			String last_visit_fu_reqd_yn="";	
			int last_visit_num=0;
			String last_visit_date="";
			//String episode_id="";
			String sql="";
		  //  PreparedStatement pstmt=null; 
			//ResultSet rs=null;	 
			try
			  {			
				 sql = "";
				 %>
					 if(frames[1].frames[3].document.getElementById("build_episode_rule") != null){
						frames[1].frames[3].document.getElementById("build_episode_rule").value='S';	
					}		
					<%   sql = "select  last_visit_fu_reqd_yn , to_char(last_visit_date,'yyyy-mm-dd') last_visit_date, nvl(last_visit_num,0)+1 last_visit_num from op_episode_for_service where operating_facility_id='"+facilityID+"' and episode_status='01' and patient_id='"+l_patient_id+"' " ;
					  if(!episode_id.equals(""))
						  sql=sql+" and episode_id='"+episode_id+"'";                     
						else{
							sql=sql+" and clinic_code='"+locncode+"'";
						}
						sql = sql+" order by added_date desc"; 
						pstmt   = con.prepareStatement(sql);
						rs  = pstmt.executeQuery();             
						 if( rs != null && rs.next()){   
						
							if (rs.getString("last_visit_fu_reqd_yn") != null)
							 last_visit_fu_reqd_yn = rs.getString( "last_visit_fu_reqd_yn" );
							 if (rs.getString("last_visit_date") != null)
							 last_visit_date = rs.getString( "last_visit_date" );
							 last_visit_num = rs.getInt( "last_visit_num" );	

							 if(visit_type_ind.equals("F")){						%>			   
								frames[1].frames[3].document.forms[0].new_op_episode_yn.value='Y';
								frames[1].frames[3].document.forms[0].op_episode_visit_num.value='';
								frames[1].frames[3].document.forms[0].op_episode_id.value=''; 		
								frames[1].frames[3].document.forms[0].vst_type_ind.value='F'; 	<%	
							}else{				%>					
								frames[1].frames[3].document.forms[0].new_op_episode_yn.value='N';			
								frames[1].frames[3].document.forms[0].op_episode_visit_num.value='<%=last_visit_num%>';
								frames[1].frames[3].document.forms[0].op_episode_id.value='<%=episode_id%>';
								frames[1].frames[3].document.forms[0].old_episode_no.value='<%=episode_id%>';
								frames[1].frames[3].document.forms[0].vst_type_ind.value='L';<%
							}
						}else{%>
							frames[1].frames[3].document.forms[0].new_op_episode_yn.value='Y';
							frames[1].frames[3].document.forms[0].op_episode_visit_num.value='';
							frames[1].frames[3].document.forms[0].op_episode_id.value='';
							frames[1].frames[3].document.forms[0].vst_type_ind.value='F';<%
						}
										
				  if(rs != null) rs.close();
				  if(pstmt != null)  pstmt.close();
					 
			 }
			 catch(Exception ex){
				 ex.printStackTrace();
			 out.println(ex);
			 out.println("alert('exception');");
			} 		   	
		}catch(IOException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	//Added for the SCF - MMS-SCF-167 - End
	}else{
	if (session != null)
		sessionID=session.getId();

	//loading qms_params
	if (room_num == null || room_num.equals("")){
		room_num = "*ALL";
		qms_room_num = "ALL";
		}
	if (pract_id == null || pract_id.equals("")){
		pract_id = "*ALL";
		qms_pract_id="ALL";
		}
	if (other_res_type.equals(""))
		other_res_type = "*";
	if (other_res_code.equals(""))
		other_res_code = "*ALL";
		
	String em_queue_id="";
	if(calling_from.equals("Arrival") || calling_from.equals("Revise") || calling_from.equals("ReAssign_Pract")){
	em_queue_id=eOP.QMSInterface.getEMQueueId(facilityID,queue_date,clinic_code, p_locn_type,pract_id,room_num,other_res_type,other_res_code,appt_walk_in,clientMachine,loggedUser,con);
	}
	System.out.println("QMSInterface.jsp -- EM Queue ID: "+em_queue_id);	
	System.out.println("QMSInterface.jsp -- current_queue_id: "+current_queue_id);

	qms_room_num=clinic_code+"|"+qms_room_num;
	
	qms_params.put("room_num",qms_room_num);	
	qms_params.put("queue_id",em_queue_id);	
	qms_params.put("pract_id",qms_pract_id);	
	

	//loading audit params
	audit_params.put("siteID",customer_id); //need to uncomment this during patch preparation
	//audit_params.put("siteID","MOHBR");//need to remove this during patch preparation 
	audit_params.put("loggedUser",loggedUser);
	audit_params.put("clientMachine",clientMachine);
	audit_params.put("facilityID",facilityID);
	audit_params.put("sessionID",sessionID);
	audit_params.put("patientID",patient_id);
	audit_params.put("encounterID",encounterId1);
	System.out.println("QMSInterface.jsp -- audit_params sent to QMS for the function " +calling_from+" : "+audit_params.toString());
	//else{
	if(em_queue_id != null && !em_queue_id.equals("0")){
	if((calling_from.equals("CancelVisit") || calling_from.equals("Revert")) && !queue_num.equals("0")){		
		eOP.QMSInterface.cancelQueueNumber(queue_num,audit_params,con);
		out.println("#"+queue_num+"#"+em_queue_id);
	}
	else if(calling_from.equals("Arrival")){
		if(!(em_queue_id.equals("-2")) && !(em_queue_id.equals("-1")) && !(current_queue_id.equals(em_queue_id))){						
			if(!queue_num.equals("0")){

				eOP.QMSInterface.cancelQueueNumber(queue_num,audit_params,con);
			}
			System.out.println("Params sent to QMS: "+qms_params.toString());
			queue_num = eOP.QMSInterface.getQueueNumber(qms_params,audit_params);
		}
		out.println("#"+queue_num+"#"+em_queue_id);
	}
	else if(calling_from.equals("Checkout") && !queue_num.equals("0")){
		eOP.QMSInterface.finishConsultation(queue_num,qms_room_num,audit_params);
	}
	else if((calling_from.equals("Revise") || calling_from.equals("ReAssign_Pract") )){
		
		if(!(em_queue_id.equals("-2")) && !(em_queue_id.equals("-1"))  && !(current_queue_id.equals(em_queue_id))){
		if(!queue_num.equals("0")){
			
			eOP.QMSInterface.cancelQueueNumber(queue_num,audit_params,con);
		}
		if(issueCall.equals("Y")){
			
			queue_num = eOP.QMSInterface.getQueueNumber(qms_params,audit_params);
		}
		}
		out.println("#"+queue_num+"#"+em_queue_id);
		//queue_num="-1";
	}
	else if(calling_from.equals("callTicket")){
		errorFromQMS=eOP.QMSInterface.callPatient(queue_num,audit_params,con);		//Modified for the SCF - ML-BRU-SCF-1074
	}
	else if(calling_from.equals("callNextTicket")){
		//eOP.QMSInterface.callNextPatient(qms_room_num,audit_params);
		errorFromQMS=eOP.QMSInterface.callNextPatient(qms_room_num,audit_params);	//Modified for the SCF - ML-BRU-SCF-1074	
	}
	//out.println("#"+queue_num);
	}else{
		out.println("#"+queue_num+"#"+em_queue_id);
	}
	//Following if condition added for the SCF - ML-BRU-SCF-1074
	if(!errorFromQMS.equals("")){
		out.println(errorFromQMS);
	}else 	if(calling_from.equals("QMSQuery")){
		String qms_int_yn=eOP.QMSInterface.isClinicQMSInterfaced(clinic_code,facilityID,con);
		out.println(qms_int_yn);
		
	}
	
	}
}
	catch(Exception ex){
		ex.getMessage();
	ex.printStackTrace();	
	}
	finally{
		ConnectionManager.returnConnection(con,request);
	}%>

