<!DOCTYPE html>
<!--,op.CurrencyFormat.*-->
<%@ page import="java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	Connection con	= null;
	Statement stmt1 = null;
	ResultSet rs1	= null;
	Statement stmt2 = null;
	ResultSet rs2	= null;
	
try
{ 
	con = ConnectionManager.getConnection(request);
	request.setCharacterEncoding("UTF-8");
	//con = (Connection) session.getValue("connection" );
	stmt1=con.createStatement();
	stmt2=con.createStatement();	
	
	String err_mesg = "0";
	int v_cnt=0;
	int t_ctr=0;
	String err="";

	String facilityid = (String) session.getValue("facility_id");
	if (facilityid==null) facilityid = "";

	String mode = request.getParameter("mode");
	if (mode==null) mode = "";

	String patient_id = request.getParameter("patient_Id");
	if (patient_id==null) patient_id = "";
	
	String encid		= request.getParameter("encounter_Id");
	if (encid==null) encid = "";
	String encounter_id = encid; //encid.substring(4);

	String practitioner_id = request.getParameter("practitioner_Id");
	if (practitioner_id==null) practitioner_id ="";
	
	String call_function = request.getParameter("call_function");		
	if (call_function==null) call_function ="";

	String sex = request.getParameter("Sex");		
	if (sex==null) sex ="";
	
	String IPval = request.getParameter("IPval");		
	if (IPval==null) IPval ="";
	
	String p_service_type = request.getParameter("p_service_type");	
	if (p_service_type==null) p_service_type =""; 
	
	String allowCancelAdmsn = request.getParameter("allowCancelAdmsn");
	if (allowCancelAdmsn==null) allowCancelAdmsn ="N";//Added by Thamizh selvi on 22nd Feb 2017 against MMS-QH-CRF-0182
	
	/*
	*Commented Below Query and added the below one against 63756 - Rajesh V
	String query_bl_pat_charges_folio="select count(1) as v_cnt from bl_patient_charges_folio where operating_facility_id = '"+facilityid+"' and episode_type IN ('I','D') and patient_id='"+patient_id+"' and  episode_id='"+encounter_id+"' and nvl(trx_finalize_ind,'N') = 'Y' and nvl(trx_status,'N') != 'C'";
	*/
	String query_bl_pat_charges_folio = " SELECT COUNT (1) AS v_cnt "+
			" FROM bl_patient_charges_folio a "+
			  " WHERE operating_facility_id = '"+facilityid+"' "+
			  " AND episode_type IN ('I', 'D') "+
			  " AND patient_id = '"+patient_id+"' "+
			  " AND episode_id = '"+encounter_id+"' "+
			  " AND NVL (trx_finalize_ind, 'N') = 'Y' "+
			    " AND NVL (trx_status, 'N') != 'C' "+
			   "  AND (   module_id NOT IN ('ST', 'PH') "+ 
			"  OR (    module_id IN ('ST', 'PH') "+
			             " AND EXISTS ( "+
			                    " SELECT   1 "+
			                        " FROM bl_patient_charges_folio b "+
			                      "  WHERE a.sec_key_main = b.sec_key_main "+
			                        "  AND a.sec_key_line_no = b.sec_key_line_no "+
			                        "  AND a.operating_facility_id = b.operating_facility_id "+
			                         " AND a.patient_id = b.patient_id "+
			                         " AND a.episode_type = b.episode_type "+
			                         " AND a.episode_id = b.episode_id "+			                         
			                         " AND b.operating_facility_id = '"+facilityid+"' "+
			                         " AND b.patient_id = '"+patient_id+"' "+
			                         " AND b.episode_id = '"+encounter_id+"'  "+                  
			                         " HAVING SUM (b.serv_qty) > 0 "+
			                    " GROUP BY b.sec_key_main, b.sec_key_line_no) "+
			           " ) "+
			        " )  ";
	//out.println("query_bl_pat_charges_folio :"+query_bl_pat_charges_folio);
	System.out.println("query_bl_pat_charges_folio :"+query_bl_pat_charges_folio);
	rs1=stmt1.executeQuery(query_bl_pat_charges_folio);
	if(rs1.next())
	{
		v_cnt=rs1.getInt("v_cnt");
		
	}	

	if(v_cnt > 0)
	{
		err_mesg="1";
		err="Business Amt is greater than zero - Admission cannot be cancelled";
	
	}
	else
	{
		String query_bl_ins_track_dtls="select count(*) as t_ctr from bl_ins_track_dtls where operating_facility_id = '"+facilityid+"' and patient_id = '"+patient_id+"' and episode_type IN ('I','D') and episode_id = '"+encounter_id+"' and adm_status = 'C'";

		try
		{
			//out.println("query_bl_ins_track_dtls :"+query_bl_ins_track_dtls);
			rs2=stmt2.executeQuery(query_bl_ins_track_dtls);
			if(rs2.next())
			{
				t_ctr=rs2.getInt("t_ctr");
							
			}

			if(t_ctr > 1)
			{
				err_mesg="1";
				err="Admission cannot be cancelled - More than one entry in the credit authorization details";
				//out.println("<script>alert('Admission cannot be cancelled - More than one entry in the credit authorization details');</script>");
			}
		}
		catch(Exception ee)
		{
			out.println("Exception @query_bl_ins_track_dtls"+ee);
		}			
	}
	if (err_mesg==null) err_mesg = "0";
	if(!(err_mesg.equals("0")))
	{
		out.println("<html><head>");	
//		out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>");

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		out.println("<link rel='StyleSheet' href='../../eCommon/html/"+sStyle+"' type='text/css'/>");
		out.println("<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>");
//		out.println("<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script>
		out.println("<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");	
		out.println("</head><body class='message'></body></html>");
		out.println("<script>alert('"+err+"');parent.frames[3].document.location = '../../eCommon/jsp/error.jsp';</script>");
	}
	else
	{ 
		out.println("<html><head>");
	//	out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>");

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	out.println("<link rel='StyleSheet' href='../../eCommon/html/"+sStyle+"' type='text/css'/>");

		out.println("<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>");
		out.println("<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script>");
		out.println("<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
		out.println("</head><body class='message'></body></html>");
	
	%>
	<script>
	async function cancelIPadmit (){
	var frames_list = parent.frames[2].document.forms[0];
	if( frames_list.modal.value != 'yes')
	{   
		var jsp_name1=frames_list.jsp_name.value;
		//var jsp_name1='addmodifyCancelDischargeAdvice';
		var patient_id	= "<%=patient_id%>";	

		var allowCancelAdmsn	= "<%=allowCancelAdmsn%>";//Added by Thamizh selvi on 22nd Feb 2017 against MMS-QH-CRF-0182

		var encid		= "<%=encid%>";
		var practitioner_id = "<%=practitioner_id%>";	
		var call_function = "<%=call_function%>";
		var sex = "<%=sex%>";			
		var IPval = "<%=IPval%>";		
		var p_service_type = "<%=p_service_type%>"; 				
		var win_height=frames_list.win_height.value;
		if(win_height == "") win_height="80vh";
				
		var dialogTop=frames_list.dialogTop.value;
		if(dialogTop == "") dialogTop="80";				
				
		var win_width=frames_list.win_width.value;
		if(win_width == "") win_width="80vw";
				
		var module1=frames_list.module.value;
		if(module1 == "") module1="eIP";
				
		var model_window=frames_list.model_window.value;
		if( model_window == "") model_window ="";
						
		if( model_window == 'NO')
		{
			parent.parent.frames[1].document.location.href="../../"+module1+"/jsp/"+jsp_name1+"?encounterId="+encid+"&patientId="+patient_id+"&Practitioner_Id="+practitioner_d+"&callfrom=IP&call_function="+call_function+"&Sex="+sex;
		}
		else
		if( model_window == 'N')
		{
			parent.frames[3].document.location.href="../../"+module1+"/jsp/"+jsp_name1+"?encounterId="+encid+"&patientId="+patient_id+"&Practitioner_Id="+practitioner_id+"&callfrom=IP&call_function="+call_function+"&Sex="+sex;
		}			
		else
		{
			var retVal = 	new String();
			var dialogHeight= win_height ;
			var dialogWidth	= win_width ;
			var dialogTop = dialogTop;
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight: 80vh; scroll=no; dialogWidth: 80vw; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;
					
			retVal = await window.showModalDialog("../../"+module1+"/jsp/"+jsp_name1+"?location_code="+IPval+"&encounterId="+encid+"&allowCancelAdmsn="+allowCancelAdmsn+"&patientId="+patient_id+"&Practitioner_Id="+practitioner_id+"&callfrom=IP&call_function="+call_function+"&p_service_type="+p_service_type.value+"&Sex="+sex+"&mode=modal",arguments,features); //Added "allowCancelAdmsn" on 22nd Feb 2017 against MMS-QH-CRF-0182
			parent.frames[2].document.location.reload();	
			parent.frames[3].document.location = '../../eCommon/jsp/error.jsp';
		}
	}
	else
	{
		window.parent.returnValue=enc;
		window.parent.close();
	}
	}
	cancelIPadmit();
	</script> 
	<%
	}
}
catch(Exception ee)
{
	out.println("Exception @try2"+ee);
}
finally 
{
	if (rs1 != null)   rs1.close();
	if (rs2 != null)   rs2.close();
	if (stmt1 != null) stmt1.close();
	if (stmt2 != null) stmt2.close();
	ConnectionManager.returnConnection(con, request);
}
%>

