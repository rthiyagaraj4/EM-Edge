<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager,webbeans.eCommon.ConnectionManager,eCommon.Common.*,eOT.*,eOR.OrderEntryBillingQueryBean,eST.OTTransactionBean,eST.*" contentType=" text/html;charset=UTF-8" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%

	String locale = (String)session.getAttribute("LOCALE"); 
	String p_Qty=checkForNull(request.getParameter("p_Qty"));
	String req_store=checkForNull(request.getParameter("req_store"));
	String patient_id=checkForNull(request.getParameter("patient_id"));
	String encounter_id=checkForNull(request.getParameter("encounter_id"));
	String patient_class=checkForNull(request.getParameter("pat_class"));
	String mm_item_code="";
	String item_code=checkForNull(request.getParameter("item_code"));
	String facility_id = (String)session.getValue("facility_id") ;
	String st_charge_based_yn=checkForNull(request.getParameter("st_charge_based_yn"));
	StringBuilder bl_bfr	= new StringBuilder();
	Connection con=null;
	CallableStatement statement =null;
	PreparedStatement pstmt_st=null;
	ResultSet rst_st=null;
 try {
      con = ConnectionManager.getConnection(request);
      String sql_mm_code="select MM_ITEM_CODE from OT_PROSTHESIS where PROSTHESIS_CODE='"+item_code+"'";
	  pstmt_st=con.prepareStatement(sql_mm_code);
	  rst_st=pstmt_st.executeQuery();
	  if(rst_st !=null && rst_st.next())
	  {
		mm_item_code=rst_st.getString(1);
	  }
	  //Maheshwaran K modified for  SKR-SCF-0788 [IN:039522] as on 24/09/2013
      statement=con.prepareCall("{ call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
	  String sal_trn_type="";
	  if(patient_class.equals("IP"))
	  {
	    sal_trn_type="I";
	  }else if(patient_class.equals("OP"))
	  {
	    sal_trn_type="O";
	  }else if(patient_class.equals("EM"))
	  {
		sal_trn_type="E";
	  }else if(patient_class.equals("DC"))
	  {
		sal_trn_type="D";
	  }else if(patient_class.equals("XT"))
	  {
		sal_trn_type="R";
	  }

	statement.setString(1, facility_id);
	statement.setString(2, patient_id);
	statement.setString(3, "ST");
	statement.setString(4, encounter_id);
	statement.setString(5, sal_trn_type);
	statement.setString(6, com.ehis.util.DateUtils.getCurrentDate("DMY","en")); // SRR20056-SCF-6059
	statement.setString(7, mm_item_code);
	statement.setString(8, req_store);
	statement.setInt(9, Integer.parseInt(p_Qty));
	statement.setString(10, ";");

	statement.registerOutParameter(11, Types.VARCHAR);
	statement.registerOutParameter(12, Types.VARCHAR);
	statement.registerOutParameter(13, Types.VARCHAR);
	statement.registerOutParameter(14, Types.VARCHAR);
	statement.registerOutParameter(15, Types.FLOAT);
	statement.registerOutParameter(16, Types.FLOAT);
	statement.registerOutParameter(17, Types.FLOAT);
	statement.registerOutParameter(18, Types.FLOAT);
	statement.registerOutParameter(19, Types.FLOAT);
	statement.registerOutParameter(20, Types.FLOAT);
	statement.registerOutParameter(21, Types.FLOAT);
	statement.registerOutParameter(22, Types.FLOAT);
	statement.registerOutParameter(23, Types.FLOAT);
	statement.registerOutParameter(24, Types.FLOAT);
	statement.registerOutParameter(25, Types.FLOAT);
	statement.registerOutParameter(26, Types.FLOAT);
	statement.registerOutParameter(27, Types.FLOAT);
	statement.registerOutParameter(28, Types.FLOAT);
	statement.registerOutParameter(29, Types.VARCHAR);
	statement.registerOutParameter(30, Types.FLOAT);
	statement.registerOutParameter(31, Types.VARCHAR);
	statement.registerOutParameter(32, Types.VARCHAR);
	statement.registerOutParameter(33, Types.VARCHAR);
	statement.registerOutParameter(34, Types.VARCHAR);
	statement.registerOutParameter(35, Types.VARCHAR);
	statement.registerOutParameter(36, Types.VARCHAR);
	statement.registerOutParameter(37, Types.VARCHAR);
	statement.registerOutParameter(38, Types.VARCHAR);
	statement.setString(39, "");
	statement.setString(40, "");
	//Maheshwaran K added for the  SKR-SCF-0788 [IN:039522] as on 24/09/2013
	//Start
	statement.setString(41, "N"); //Internal Adjestment
    statement.setString(42, "");
	statement.setString(43, "");
	statement.setString(44, "1");
	statement.setString(45, "N");//p_discharge_ind
	statement.registerOutParameter(46, Types.VARCHAR);//p_drug_penalty_str
	//End

	statement.execute();
	String overridden_action_reason_code=null;
	String  overridden_incl_excl_ind=statement.getString(35);
	String override_value=statement.getString(37);
    
	bl_bfr.append(checkForNull(""+(statement.getString(21)),"0.0")).append("::");
	bl_bfr.append(checkForNull(""+(statement.getString(25)),"0.0")).append("::");
	bl_bfr.append(checkForNull(""+(statement.getString(38)),"0.0")).append("::");
	bl_bfr.append(checkForNull(""+st_charge_based_yn,"N")).append("::");///TO CHK WITH DILIP
	bl_bfr.append(overridden_incl_excl_ind).append("::");
	bl_bfr.append(checkForNull(""+(statement.getString(36)),"N")).append("::");
	bl_bfr.append(checkForNull(""+"S")).append("::");//Note: when ST is on serv_panel_ind value passing as "S" for showing excl_incl value(image) always in the screen   but there is no concept of service or panel through ST billing.
	bl_bfr.append(overridden_action_reason_code).append("::");
	bl_bfr.append(checkForNull(""+statement.getString(35),"E")).append("::");
	bl_bfr.append(override_value);
	String bill_str = "";
	bill_str = bl_bfr.toString();
	bl_bfr.setLength(0); 
	out.println(bill_str);
}catch(Exception e){
	out.println("alert(\"" + e + "\");") ;
	e.printStackTrace();
}
%>
