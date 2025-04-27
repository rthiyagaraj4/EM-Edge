<!DOCTYPE html>
<%@page  import ="java.sql.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="verifychecklist" class="webbeans.eCommon.RecordSet" scope="session"/>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/> 


 <%
	String locale = (String)session.getAttribute("LOCALE"); 
	String func_mode = request.getParameter("func_mode") ;
	//System.err.println("func_mode : p " +func_mode);

	Connection con = null;
	PreparedStatement pstmt  = null;
	ResultSet rst = null;

	try{
		con = ConnectionManager.getConnection(request);
		if(func_mode.equals("fromSurgicalAcmaster"))
	{
			String appl_desc	=  checkForNull(request.getParameter("appl_desc")) ;
			String splty_code	=  checkForNull(request.getParameter("splty_code")) ;
			String cat_code		=  checkForNull(request.getParameter("cat_code"));
			String sub_cat_code	=  checkForNull(request.getParameter("sub_cat_code"));
			String tab	=  checkForNull(request.getParameter("tab"));
			String function_id	=  checkForNull(request.getParameter("function_id"));
			String sql_one="";
			String sql="";
			String pkg_code="";
			String pref_id="";
			String final_code="";
			String pkg_code_ret="";
			System.err.println(" SQL function_id 1: "+function_id);
/* Added by Suma on 7/01/2010 against incident 17592 (Function id is passed from SurgicalAccessoriesConsumablePacksRecord.jsp to handle Surgical accessories and Surgical Preferences separately)*/
		if(!function_id.equals("OT_MST_CODE_SURGPREF"))
		{
			if(tab.equals("package")){
				sql_one="SELECT PACKAGE_CODE FROM OT_OPER_PACKAGE WHERE APPLICABILITY='"+appl_desc+"'AND SPECIALITY_CODE= NVL('"+splty_code+"',SPECIALITY_CODE) ";
			}else if(tab.equals("equipment")){
				sql_one="SELECT EQUIPMENT_CODE FROM OT_OPER_EQUIPMENT WHERE APPLICABILITY='"+appl_desc+"'AND SPECIALITY_CODE= NVL('"+splty_code+"',SPECIALITY_CODE) ";
			}else if(tab.equals("Instrument")){
				sql_one="SELECT INSTR_CODE FROM OT_OPER_INSTRUMENT WHERE APPLICABILITY='"+appl_desc+"'AND SPECIALITY_CODE= NVL('"+splty_code+"',SPECIALITY_CODE) ";
			}else if(tab.equals("Prosthesis")){
				sql_one="SELECT PROSTHESIS_CODE FROM OT_OPER_PROSTHESIS WHERE APPLICABILITY='"+appl_desc+"'AND SPECIALITY_CODE= NVL('"+splty_code+"',SPECIALITY_CODE) ";
			}else if(tab.equals("PersnlRecrd")){
				sql_one="SELECT ROLE_ID FROM OT_OPER_PERSONNEL_REQD WHERE APPLICABILITY='"+appl_desc+"'AND SPECIALITY_CODE= NVL('"+splty_code+"',SPECIALITY_CODE) ";
			}
			System.err.println(" cat_code test 1: "+cat_code);

			if(!cat_code.equals("")){
			sql=sql_one+"AND OPER_CAT_CODE=NVL('"+cat_code+"',OPER_CAT_CODE)";
			}else
			{
				sql=sql_one;
			}
			if(!sub_cat_code.equals("")){
			sql=sql_one+"AND OPER_SUB_CAT_CODE=NVL('"+sub_cat_code+"',OPER_SUB_CAT_CODE)";
			}else
			{
				sql=sql_one;
			}
		}else
		{
	/* Added by Suma on 7/01/2010 against incident 17592 (This query is newly added for handling update mode of Surgical preferences)*/
			sql="SELECT PREF_ID  FROM ot_oper_dr_preference  WHERE applicability ='"+appl_desc+"' AND SPECIALITY_CODE= NVL('"+splty_code+"',SPECIALITY_CODE) ";
			/*ends here*/
		}
			System.err.println(" SQL test 1: "+sql);
			pstmt=con.prepareStatement(sql);
			System.err.println(" SQL test 2: "+sql);
			rst=pstmt.executeQuery();
			System.err.println(" SQL test : "+sql);
			while(rst.next())
			{
		
				pkg_code=rst.getString(1);
				pkg_code_ret=pkg_code_ret+pkg_code+",";
	
			}
			System.err.println("pkg_code_ret sdfdsf:" +pkg_code_ret);
			if(pstmt!=null)pstmt.close();
			out.println(pkg_code_ret);
	}
	

	}catch(Exception e){
			e.printStackTrace();
			System.err.println("Err Msg from CommonValidation.jsp :"+e);
		}
		finally{
			if(rst!=null) rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null) con.close();
		}

%>

