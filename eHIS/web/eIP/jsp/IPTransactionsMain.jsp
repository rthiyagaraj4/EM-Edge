<!DOCTYPE html>
<%
// @MODULE			:	InPatient Management..(IP)
%>
<%@ page  contentType="text/html;charset=UTF-8"  import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'</link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		
	</head>
<script>
	alert("opening IPTransactionsMain.jsp - Post Break-UP ");
</script>
<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String facilityId = (String)session.getValue("facility_id");
	String loginUser = (String)session.getValue("login_user");		
	String function_id = checkForNull(request.getParameter("function_id"));
	Connection con			= null;
	ResultSet rs 			= null; 
	Statement stmt 			= null;
	ResultSet rset_opr 		= null;
	Statement stmt_opr		= null;
	ResultSet rset_clinic	= null;
	Statement stmt_clinic	= null;
	boolean result 			= true;
	String oper_stn_id		= "";
	String oper_stn_func_restrn	= "N";
	StringBuffer operSql	= new StringBuffer();
		String sql_oper_stn_restrn = "";

// transfer patient
	String max_blk_type		= "";
	String bedBlock_normal  = "";
	String bl_install_yn	= "";
	String bed_blk_period_max = "";
	int bed_block_period_max= 0;

	try
	{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();	
		
		if(function_id.equals("PRE_DIS_ADVICE") || function_id.equals("CAN_DIS_ADVICE") || function_id.equals("DISCHARGE_PATIENT") || function_id.equals("DISCHARGE_CHECKLIST") )
		{
			rs = stmt.executeQuery("select 1 from ip_param where facility_id='"+facilityId+"' ") ;
		}
		else if(function_id.equals("TRANSFER_PATIENT"))
		{
			rs	= stmt.executeQuery("select nvl(bl_interfaced_yn,'N')bl_interfaced_yn, BED_BLOCK_PERIOD_MAX, BED_BLOCK_PERIOD_MAX_TYPE, bed_block_period_normal from IP_PARAM where facility_id='"+facilityId+"' ") ;
		}

		if(rs.next())
		{
			if(function_id.equals("TRANSFER_PATIENT"))
			{
				bl_install_yn			= rs.getString("bl_interfaced_yn");
				bedBlock_normal			= rs.getString("bed_block_period_normal");
				bed_block_period_max	= rs.getInt("BED_BLOCK_PERIOD_MAX");
				max_blk_type			= rs.getString("BED_BLOCK_PERIOD_MAX_TYPE");

				if(max_blk_type.equals("D"))
				bed_block_period_max=(bed_block_period_max)*24;
				bed_blk_period_max = ""+bed_block_period_max;
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			//For Operator Station 
			operSql.append(" SELECT a.oper_stn_id  OPER_STN_ID FROM ");
			operSql.append(" am_oper_stn a, am_user_for_oper_stn b  ");
			operSql.append(" WHERE a.facility_id='"+facilityId+"' AND ");
			operSql.append(" a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id ");
			operSql.append(" AND b. appl_user_id ='"+loginUser+"' AND trunc(sysdate) ");
			operSql.append(" between b.eff_date_from and  ");
			operSql.append(" nvl(b.eff_date_to,trunc(sysdate)) ");

			stmt_opr = con.createStatement();
			rset_opr  = stmt_opr.executeQuery(operSql.toString());
			if(rset_opr!=null)
			{
				if(rset_opr.next())
				{
					oper_stn_id = checkForNull(rset_opr.getString("OPER_STN_ID"));
				}	
				else
				{
					out.print(" <script>alert(getMessage('IP_NO_OPER_STN_FOR_USER','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
					result = false;
				}
			}
			if(rset_opr!=null)rset_opr.close();
			if(stmt_opr !=null)stmt_opr .close();

			if (!oper_stn_id.equals("") && result)
			{
				//For Clinic check
				// String sql = " select a.nursing_unit_code from ip_nursing_unit a, am_locn_for_oper_stn b where a.facility_id = '"+facilityId+"' and a.facility_id =b.facility_id and a.nursing_unit_code = b.locn_code and a.eff_status='E' and b.oper_stn_id='"+oper_stn_id+"' and b.eff_status='E' ";


				String sql = " SELECT locn_code FROM AM_LOCN_FOR_OPER_STN WHERE locn_type = 'N' and oper_stn_id='"+oper_stn_id+"' AND eff_status = 'E' and facility_id = '"+facilityId+"' ";

				stmt_clinic  = con.createStatement();
				rset_clinic =  stmt_clinic.executeQuery(sql);

				if (!rset_clinic.next())
				{
					out.println(" <script>alert(getMessage('NURS_UNIT_NOT_DEFINED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
//					result = false;
				}
				if (rset_clinic != null)   rset_clinic.close();
				if (stmt_clinic != null)   stmt_clinic.close();
			} 
//			if(result)

			if(function_id.equals("PRE_DIS_ADVICE"))
			{
				sql_oper_stn_restrn = " select DISCHARGE_ADVICE_YN from AM_OPER_STN where facility_id = '"+facilityId+"' and oper_stn_id = (select oper_stn_id from am_user_for_oper_stn where facility_id='"+facilityId+"' and appl_user_id ='"+loginUser+"' and trunc(sysdate) between eff_date_from and nvl(eff_date_to,trunc(sysdate))) ";
			}
			else if(function_id.equals("TRANSFER_PATIENT"))
			{
				sql_oper_stn_restrn = " select EMERGENCY_TFR_YN from AM_OPER_STN where facility_id = '"+facilityId+"' and oper_stn_id = (select oper_stn_id from am_user_for_oper_stn where facility_id='"+facilityId+"' and appl_user_id ='"+loginUser+"' and trunc(sysdate) between eff_date_from and nvl(eff_date_to,trunc(sysdate))) ";
			}
			else if(function_id.equals("CAN_DIS_ADVICE") || function_id.equals("DISCHARGE_PATIENT") || function_id.equals("DISCHARGE_CHECKLIST") )
			{
				sql_oper_stn_restrn = " select DISCHARGE_PAT_YN from AM_OPER_STN where facility_id = '"+facilityId+"' and oper_stn_id = (select oper_stn_id from am_user_for_oper_stn where facility_id='"+facilityId+"' and appl_user_id ='"+loginUser+"' and trunc(sysdate) between eff_date_from and nvl(eff_date_to,trunc(sysdate))) ";
			}

			stmt = con.createStatement();	
			rs = stmt.executeQuery(sql_oper_stn_restrn);
			if(rs!= null)
			{
				if(rs.next())
				{
					oper_stn_func_restrn = rs.getString(1);
					if(oper_stn_func_restrn == null) oper_stn_func_restrn ="N";			
				}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();

			if(oper_stn_func_restrn.equals("Y"))
			{				
				if(function_id.equals("PRE_DIS_ADVICE"))
				{
					out.println("<script>document.location.href ='../../eIP/jsp/PrepareDischargeAdvice.jsp?source="+source+"&oper_stn_id="+oper_stn_id+"';</script>");
				}
				else if(function_id.equals("TRANSFER_PATIENT"))
				{
					out.println("<script>document.location.href ='../../eIP/jsp/TransferPatient.jsp?source="+source+"&oper_stn_id="+oper_stn_id+"&bl_install_yn="+bl_install_yn+"&bedBlock_normal="+bedBlock_normal+"&bed_blk_period_max="+bed_blk_period_max+"&max_blk_type="+max_blk_type+"';</script>");
			
				}
				else if(function_id.equals("CAN_DIS_ADVICE"))
				{
					out.println("<script>document.location.href ='../../eIP/jsp/CancelDischargeAdvice.jsp?source="+source+"&oper_stn_id="+oper_stn_id+"';</script>");
				}
				else if(function_id.equals("DISCHARGE_PATIENT"))
				{
					out.println("<script>document.location.href ='../../eIP/jsp/DischargePatient.jsp?source="+source+"&oper_stn_id="+oper_stn_id+"';</script>");
				}
				else if( function_id.equals("DISCHARGE_CHECKLIST"))
				{
					out.println("<script>document.location.href ='../../eIP/jsp/DischargeCheckList.jsp?source="+source+"&oper_stn_id="+oper_stn_id+"';</script>");
				}
			}
			else
			{
				out.println("<script>alert(getMessage('OPER_STN_FUNC_RESTRN','IP'))</script>");
				out.println("<script>document.location.href ='../../eCommon/jsp/dmenu.jsp'</script>");
			}
		}
		else
		{
			out.println("<script>alert(getMessage('IP_PARAM_NOT_FOUND','IP'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
		}
			if(rs!=null)rs.close();
			if(rset_opr!=null)rset_opr.close();
			if(rset_clinic!=null)rset_clinic.close();
			if(stmt!=null)stmt.close();
			if(stmt_opr!=null)stmt_opr.close();
			if(stmt_clinic!=null)stmt_clinic.close();

	}catch(Exception e)
	{
		out.println("Exception in tryCatch : "+ e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>


<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

