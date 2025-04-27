
<%@ page language="java" import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*, java.text.SimpleDateFormat,eBL.Common.*, eBL.*, eCommon.Common.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
  

<%!private String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
} %>
<%

Connection con = null;
CallableStatement cstmt = null;
PreparedStatement pstmt1=null;
ResultSet rs = null;
con = ConnectionManager.getConnection(request);

HttpSession httpSession = request.getSession(false);
Properties p = (Properties)httpSession.getValue("jdbc");


SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");



String facility_id=request.getParameter("facility_id");
System.out.println("facility_id="+facility_id);


String episode_type=request.getParameter("episode_type");
System.out.println("episode_type1="+episode_type);


String patient_id=request.getParameter("patient_id");
System.out.println("patient_id="+patient_id);


String episode_id=CommonBean.checkForNull(request.getParameter("episode_id"));
System.out.println("episode_id="+episode_id);

String visit_id=CommonBean.checkForNull(request.getParameter("visit_id"));
System.out.println("visit_id="+visit_id);


String recpt_refund_ind=request.getParameter("recpt_refund_ind");
System.out.println("recpt_refund_ind="+recpt_refund_ind);


String receipt_nature_code=request.getParameter("receipt_nature_code");
System.out.println("receipt_nature_code="+receipt_nature_code);

String receipt_type_code=request.getParameter("receipt_type_code");
System.out.println("receipt_type_code="+receipt_type_code);

String doc_number=request.getParameter("doc_number");
System.out.println("doc_number="+doc_number);
if (doc_number==null) doc_number = null;

String qty=replaceNull(request.getParameter("qty"));
System.out.println("qty"+qty);

String service_code=replaceNull(request.getParameter("service_code"));
System.out.println("service_code"+service_code);

String service_indicator=replaceNull(request.getParameter("service_indicator"));
System.out.println("service_indicator"+service_indicator);

String strencounter_id=replaceNull(request.getParameter("encounter_id"));
int encounter_id=0;
if("".equals(strencounter_id)){
	encounter_id=0;
}		
else
{
	try
	{
		encounter_id=Integer.parseInt(strencounter_id);	
	}catch(Exception e)
	{
		encounter_id=0;
	}
} 
System.out.println("encounter_id="+encounter_id);


String datetime=replaceNull(request.getParameter("datetime"));
System.out.println("datetime="+datetime);




//System.out.println("doc"+request.getParameter("doc_num"));

String doc_num_req=request.getParameter("doc_num");
int doc_num;
if(doc_num_req==null || ("").equals(doc_num_req)){
	doc_num=0;
}
else
doc_num=Integer.parseInt(doc_num_req);

System.out.println("doc_num="+doc_num);
//if (doc_num==0) doc_num =0;



String docnum_req=request.getParameter("documnumber");
int documnumber;
if(docnum_req==null || ("").equals(docnum_req)){
documnumber=0;
}
else
	documnumber=Integer.parseInt(docnum_req);

System.out.println("documnumber="+documnumber);

	
	
String stlmtamount=request.getParameter("stlmt_amount");
float stmtamt;
if(stlmtamount==null || ("").equals(stlmtamount))
{
	stmtamt=0;
}
else
	stmtamt=Float.parseFloat(stlmtamount);
System.out.println("stlmt_amount="+stmtamt);



String	strloggeduser	=  (String) session.getValue("login_user");	
if (strloggeduser==null) strloggeduser = "";
System.out.println("strloggeduser" +strloggeduser);


String strclientip = p.getProperty("client_ip_address");
if (strclientip==null) strclientip = "";
System.out.println("strclientip "+strclientip);

String locale	= (String)session.getAttribute("LOCALE");	
if(locale==null || locale.equals("")) locale="en";	
System.out.println("locale="+locale);

String operation = request.getParameter("func_mode");


if(operation.equals("remarksdisplay"))
{
try 
{


boolean status=true;
String vnarration="";
String narration="";
//int err_val = 1;
if(status==true)
{
				
		pstmt1=con.prepareStatement("select ibaehis.bl_proc_receipt_refund_main.bl_proc_check_narration(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) check_narration from dual");	
		pstmt1.setString(1,facility_id);
		pstmt1.setString(2,episode_type);
		pstmt1.setString(3,patient_id);
		pstmt1.setString(4,episode_id);
		pstmt1.setString(5,visit_id);		
		pstmt1.setString(6,recpt_refund_ind);		
		pstmt1.setString(7,receipt_nature_code);		
		pstmt1.setString(8,receipt_type_code);		
		pstmt1.setString(9,doc_number);		
		pstmt1.setInt(10,doc_num);		
		pstmt1.setInt(11,documnumber);		
		pstmt1.setFloat(12,stmtamt);		
		pstmt1.setString(13,strloggeduser);		
		pstmt1.setString(14,strclientip);		
		pstmt1.setString(15,locale);  
	 	rs = pstmt1.executeQuery();	
	 	if(rs != null  && rs.next())
	 	{
	 		
			vnarration = rs.getString("check_narration");
			//success = "Y";
		}
	 	if(vnarration==null || vnarration=="null")
	 	{
	 		
		 	narration="";
		 	System.out.println("vnarration="+narration);
		 	out.println(narration);
	 	}
	 	else
	 	{
	 	System.out.println("vnarration="+vnarration);
	 	out.println(vnarration);
	 	}
	}
if(status)
{	
	
	con.commit();
}

else
{
	con.rollback();		
}
//response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( "12","UTF-8" ) +"&err_value="+err_val);

}

catch(Exception e)
{
	//System.out.println("In catch");
	e.printStackTrace(); 	 	
	System.err.println("Exception in ->"+e);

}
finally
{
	rs.close();
	pstmt1.close();
	if(con!=null)
	ConnectionManager.returnConnection(con);
}

}

else if(operation.equals("dischargecheck"))
{
	String pat_id=request.getParameter("pat_id");
	System.out.println("pat_id="+pat_id);
	
	String epi_id=request.getParameter("episode_id");
	System.out.println("epi_id="+epi_id);
	
	
	
System.out.println("facility_id="+facility_id);
	try
	{
	System.out.println("ajax call deducted");
	String dischargeYn="N";
	String openepisode_id="";
	if("I".equals(episode_type) || "D".equals(episode_type)){
	PreparedStatement pstmtEp = con.prepareStatement("SELECT OPEN_EPISODE_ID FROM IP_OPEN_EPISODE  WHERE PATIENT_ID = '"+pat_id+"' AND FACILITY_ID = '"+facility_id+"' ");
			System.out.println("SELECT OPEN_EPISODE_ID FROM IP_OPEN_EPISODE  WHERE PATIENT_ID = '"+pat_id+"' AND FACILITY_ID = '"+facility_id+"'" );
			
			
			 ResultSet rset = pstmtEp.executeQuery();	
			if( rset != null)
			{ 
				while(rset.next())  
			{
					System.out.println("OPEN_EPISODE_ID Inside...............");
				openepisode_id=rset.getString("OPEN_EPISODE_ID");
				System.out.println("openepisode_id"+openepisode_id);
			}
			}
				if(openepisode_id==null || "".equals(openepisode_id))
				{
				
						dischargeYn = "Y";
				
				System.out.println("dischargeYn"+dischargeYn);
		
				}
				/*else if(openepisode_id!=epi_id)
				{
					dischargeYn = "Y";
				}*/
				
			
			out.println(dischargeYn);
			pstmtEp.close();
	}
	}catch(Exception e)
{
	System.out.println("In catch dischargecheck");
	e.printStackTrace(); 	 	
	System.err.println("Exception in dischargecheck->"+e);

}

finally
{
	if(con!=null)
	ConnectionManager.returnConnection(con);
}

	


}

else if(operation.equals("actcode"))
	
{
	System.out.println("else if operation equals actcode");
	try 
	{
	
	String accountcode="";
	String department="";
	String error_id="";
	String error_text="";
	boolean status=true;
	//String vnarration="";
	//int err_val = 1;
	if(status==true)
	{			cstmt= con.prepareCall("{ call blopin.proc_ext_acc_dtls_for_adm_dep(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");			
				cstmt.setString(1,facility_id);
				cstmt.setString(2,patient_id);
				cstmt.setString(3,receipt_nature_code);
				cstmt.setString(4,receipt_type_code);
				cstmt.setString(5,episode_type);
				cstmt.setString(6,episode_id);
				cstmt.setString(7,visit_id);
				cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);	
				cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);	
				cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);	
				cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);	
				cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);	
				cstmt.registerOutParameter(15,java.sql.Types.VARCHAR);
				cstmt.execute();	
				accountcode				=  		replaceNull(cstmt.getString(9));
				department				=  		replaceNull(cstmt.getString(11));
				error_id				=		cstmt.getString(14);
				error_text				=		cstmt.getString(15);
				
				System.out.println("accountcode="+accountcode);
				System.out.println("department="+department);
				System.out.println("error_id="+error_id);
				System.out.println("error_text="+error_text);
				
				
				out.println(accountcode+"::"+department+"::"+error_id+"::"+error_text);
				cstmt.close();
			
	
	}
	if(status)
	{	
		
		con.commit();
	}

	else
	{
		con.rollback();		
	}
	//response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( "12","UTF-8" ) +"&err_value="+err_val);

	}

	catch(Exception e)
	{
		System.out.println("In catch");
		e.printStackTrace(); 	 	
		System.err.println("Exception in ->"+e);

	}
	
	finally
	{
		if(con!=null)
		ConnectionManager.returnConnection(con);
	}
	
}


else if(operation.equals("estdep"))
{
	try 
	{
		
	

		String est_charge="";
		String est_rate="";
		String errr_id="";
		String errrtext="";
		String base_qty="";
		String base_rate="";
		String day_type_code="";
		String time_type_code="";
		
		//String estcharge="";
		java.sql.Date sql_fromDt=null;
		//java.util.Date fromDt=null;
		boolean status=true;
		if(status==true)
		{
					System.out.println("else if in try");
					cstmt= con.prepareCall("{ call ibaehis.bl_proc_receipt_refund_main.populate_charge_bl_serv_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");			
					cstmt.setString(1,facility_id);
					cstmt.setString(2,null);
					cstmt.setString(3,episode_type);
					cstmt.setString(4,patient_id);
					cstmt.setString(5,episode_id);
					cstmt.setString(6,visit_id);
					cstmt.setInt(7,encounter_id);
					cstmt.setString(8,null);
					if((datetime == null) || ("".equals(datetime))){
						cstmt.setString(9, null);
					}
					else{
						//fromDt = sdf.parse(datetime);
						cstmt.setDate(9, new java.sql.Date(sdf.parse(datetime).getTime()));
						//sql_fromDt = new java.sql.Date(sdf.parse(datetime)) ;
						//cstmt.setDate(9, sql_fromDt);
					}					
					cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
					cstmt.setString(15,null);
					cstmt.setString(16,service_indicator);
					cstmt.setString(17,service_code);
					cstmt.setString(18,qty);
					cstmt.setString(19,null);
					cstmt.registerOutParameter(20,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(21,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(22,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(23,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(24,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(25,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(26,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(27,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(28,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(29,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(30,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(31,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(32,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(33,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(34,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(35,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(36,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(37,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(38,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(39,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(40,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(41,java.sql.Types.VARCHAR);
					cstmt.setString(42,locale);
					cstmt.registerOutParameter(43,java.sql.Types.VARCHAR);
					cstmt.setString(44,null);
					cstmt.registerOutParameter(45,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(46,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(47,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(48,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(49,java.sql.Types.VARCHAR);
					cstmt.setString(50,strloggeduser);
					cstmt.registerOutParameter(51,java.sql.Types.VARCHAR);	
					cstmt.registerOutParameter(52,java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(53,java.sql.Types.VARCHAR);	
					cstmt.execute();		
					
					est_rate				=  		replaceNull(cstmt.getString(10));
					day_type_code			=		replaceNull(cstmt.getString(11));
					time_type_code			=		replaceNull(cstmt.getString(13));
					base_qty				=		replaceNull(cstmt.getString(20));
					base_rate				=		replaceNull(cstmt.getString(21));		
					est_charge				=  		replaceNull(cstmt.getString(24));
					errr_id					=		cstmt.getString(52);
					errrtext				=		cstmt.getString(53);
					
					/*System.out.println("est_rate="+est_rate);
					System.out.println("est_charge="+est_charge);
					System.out.println("error_id="+errr_id);
					
					System.out.println("base_qty="+base_qty);
					System.out.println("day_type_code="+day_type_code);
					System.out.println("base_rate="+base_rate);
					System.out.println("time_type_code="+time_type_code);*/
					
					out.println(est_rate+"::"+est_charge+"::"+errr_id+"::"+base_qty+"::"+day_type_code+"::"+base_rate+"::"+time_type_code);
					cstmt.close();
				
		
		}
		if(status)
		{	
			
			con.commit();
		}

		else
		{
			con.rollback();		
		}
	}

	catch(Exception e)
	{
		System.out.println("In catch");
		e.printStackTrace(); 	 	
		System.err.println("Exception in ->"+e);

	}
	finally
	{
		if(con!=null)
		ConnectionManager.returnConnection(con);
		
	}
	}
%>

