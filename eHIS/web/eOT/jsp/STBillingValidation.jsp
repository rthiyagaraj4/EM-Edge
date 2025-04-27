<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String locale = (String)session.getAttribute("LOCALE"); 
	String reason_code = request.getParameter("reason_code")== null?"":request.getParameter("reason_code");
	String include_exclude_val = request.getParameter("include_exclude_val")== null?"":request.getParameter("include_exclude_val");

	String patient_id = request.getParameter("patient_id")== null?"":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id")== null?"":request.getParameter("encounter_id");
	String mm_item_code = request.getParameter("mm_item_code")== null?"":request.getParameter("mm_item_code");
	String req_store_code = request.getParameter("req_store_code")== null?"":request.getParameter("req_store_code");
	String quantity = request.getParameter("quantity")== null?"":request.getParameter("quantity");
	String patient_class = request.getParameter("quantity")== null?"":request.getParameter("patient_class");
	String facility_id = request.getParameter("facility_id");
	String sale_doc_no = request.getParameter("sale_doc_no")== null?"":request.getParameter("sale_doc_no");
	String sale_doc_type = request.getParameter("sale_doc_type")== null?"":request.getParameter("sale_doc_type");
	String sql			= "";		
	String sep	= "##";
	Connection conn = null;
	CallableStatement statement =null;
	try{
		conn=ConnectionManager.getConnection(request);
		PreparedStatement pstmt	  = null;
		ResultSet rs		  = null;
		//Maheshwaran K modified for  SKR-SCF-0788 [IN:039522] as on 24/09/2013
		statement=conn.prepareCall("{call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
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
			statement.setString(6, com.ehis.util.DateUtils.getCurrentDate("DMY","en"));
			statement.setString(7, mm_item_code);
			statement.setString(8, req_store_code);
			statement.setInt(9, Integer.parseInt(quantity));
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
			statement.setString(39, include_exclude_val);
			statement.setString(40, reason_code);
			statement.setString(41, "N"); //Internal Adjestment
           statement.setString(42,sale_doc_type );//sale_document_type
		   statement.setString(43, sale_doc_no);//sale_document_no
		   statement.setString(44, "1");
			//Maheshwaran K added for the  SKR-SCF-0788 [IN:039522] as on 24/09/2013
			//Start
			statement.setString(45, "N");//p_discharge_ind
			statement.registerOutParameter(46, Types.VARCHAR);//p_drug_penalty_str
			//End
		

			statement.execute();

String totoal_paid=statement.getString(21);
String pat_payable=statement.getString(25);
String pat_paid=statement.getString(38);
String new_val=statement.getString(36);

out.println(reason_code+"*"+include_exclude_val+"*"+totoal_paid+"*"+pat_payable+"*"+pat_paid);



}catch(Exception e)
	{
		System.out.println("Exception in main room working="+e);
		e.printStackTrace();
	}
	finally{
		if(conn != null)
				ConnectionManager.returnConnection(conn,request);
	}

%>
