
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, java.util.StringTokenizer, java.util.HashMap, java.util.ArrayList, java.io.InputStreamReader, java.io.ByteArrayInputStream, java.io.BufferedReader, webbeans.eCommon.ConnectionManager,com.ehis.util.*" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%@ include file="HealthCardInterface.jsp" %>   

<%
     request.setCharacterEncoding("UTF-8");
	String pr_id = request.getParameter("process_id")==null?"0":request.getParameter("process_id");
	 int process = Integer.parseInt(pr_id);
	
	 Hashtable hash =(Hashtable)obj.parseXMLString( request ) ;
	if(process != 11) {		
		hash = (Hashtable)hash.get("SEARCH") ;
		String  function_name = (String) hash.get("function_name")==null?"":(String) hash.get("function_name") ;
		if(function_name.equals("NewBorn")){
			process = Integer.parseInt((String) hash.get("process_id")==null?"":(String) hash.get("process_id"));
		}
	}





	Connection con		= null;
	ResultSet rs			= null;
	//ResultSet rs2			= null;
	//ResultSet rset			= null;
	PreparedStatement stmt	= null;
	//PreparedStatement stmt2	= null;
		
	//String date_of_birth = "";
   
	
	String locale			= (String)session.getAttribute("LOCALE");
	//String defaultSelect		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	try{
		con = ConnectionManager.getConnection(request);
		// Getting DATE OF BIRTH FUNCTION, DAYS, MONTH AND YEAR FUNCTION
		//String nat_id_val = ""  ;
	if(process == 11){
		if(rs!=null) rs.close();

		Properties p;		
		p = (Properties) session.getValue("jdbc");
		String userId				= (String)session.getAttribute("login_user");
		HashMap hashMap		= new HashMap();
		hashMap = eMP.ChangePatientDetails.getSetupData((String)session.getValue("facility_id"),"",con,p);
		String pat_ser_access_by_user_yn = checkForNull((String)hashMap.get("PAT_SER_ACCESS_BY_USER_YN"));
		String usedStatusSql	= " and pat_ser_grp_code IN (SELECT pat_ser_grp_code FROM mp_pat_ser_facility WHERE used_status = 'N') ";
		String userAccessSql	= "";
		if(pat_ser_access_by_user_yn.equals("Y")){
			userAccessSql	= " and pat_ser_grp_code IN (SELECT pat_ser_grp_code FROM MP_PAT_SER_GRP_FOR_USER WHERE APPL_USER_ID = '"+userId+"') ";
		}



       String sql = " select pat_ser_grp_code,initcap(short_desc) short_desc from mp_pat_ser_grp_lang_vw where language_id='"+locale+"' and id_type not in ('R', 'X') and  id_type in ('N','U') and gen_pat_id_yn = 'Y' and (pat_ser_grp_code in (select pat_ser_grp_code from mp_pat_ser_facility where USED_STATUS = 'N' and site_or_facility_id = decode(site_or_facility,'S','"+request.getParameter("Site")+"','F','"+(String)session.getValue("facility_id")+"'))) "+userAccessSql+"  union select pat_ser_grp_code,short_desc from mp_pat_ser_grp_lang_vw where language_id='"+locale+"' and id_type not in ('R', 'X') and id_type in ('N','U') and gen_pat_id_yn = 'N' "+usedStatusSql+" "+userAccessSql+" order by 2  ";

	       
       String def_nat_id = request.getParameter("def_nat_id") ;

       //nat_id_val =request.getParameter("nat_id_val") ;
        
	   stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();

       if( rs !=null ){
			out.println("<script>") ;
			out.println("var frmedoc =parent.f_query_add_mod.patient_sub.document; ") ;
			out.println("var obj =parent.f_query_add_mod.patient_sub.document.getElementById('pat_ser_grp_code'); ") ;
			out.println("var length  = obj.length;");
			out.println("for(i=0;i<length;i++) {obj.remove(0);}");
		
		   out.println ("var opt1= frmedoc.createElement('Option');\nopt1.text='----Select----'; opt1.value='';\nobj.add(opt1)") ;
           while(rs.next()){
               out.println ("var opt= frmedoc.createElement('Option');\nopt.text=\""+rs.getString(2)+"\"; opt.value=\""+rs.getString(1)+"\";if(\""+def_nat_id+"\"== \""+rs.getString(1)+"\") opt.selected = true;\nobj.add(opt)") ;
               

           }
			out.println ("frmedoc.createElement('Option')") ;
           if(request.getParameter("curr_ds_id") != null )
             process =11 ;
           out.println ("frmedoc.all.patient_group.value='N'") ;
           out.println ("parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='") ;
           out.println("</script>");
       }

       if(stmt != null)    stmt.close();
       if(rs != null)    rs.close();
	}else if(process == 234){
		HashMap query_string_map	 = new HashMap();
		String pract_id_still_birth							=	checkForNull((String) hash.get("pract_id_still_birth"));
		String attendant_at_birth							=	checkForNull((String) hash.get("attendant_at_birth"));
		String autopsy_reqd_yn							=	checkForNull((String) hash.get("autopsy_reqd_yn"));
		String mate_cond_main_cod						=	checkForNull((String) hash.get("mate_cond_main_cod"));
		String mate_cond_main_cod_dur				=	checkForNull((String) hash.get("mate_cond_main_cod_dur"));
		String mate_cond_oth_cod						=	checkForNull((String) hash.get("mate_cond_oth_cod"));
		String mate_cond_oth_cod_dur				=	checkForNull((String) hash.get("mate_cond_oth_cod_dur"));
		String mate_cond_preexist_cod				=	checkForNull((String) hash.get("mate_cond_preexist_cod"));
		String mate_cond_preexist_cod_dur			=	checkForNull((String) hash.get("mate_cond_preexist_cod_dur"));
		String oth_rel_mate_cond_rel_cod			=	checkForNull((String) hash.get("oth_rel_mate_cond_rel_cod"));
		String oth_rel_mate_cond_rel_cod_dur		=	checkForNull((String) hash.get("oth_rel_mate_cond_rel_cod_dur"));
		String cond_cau_dea_main_cod				=	checkForNull((String) hash.get("cond_cau_dea_main_cod"));
		String cond_cau_dea_main_cod_dur			=	checkForNull((String) hash.get("cond_cau_dea_main_cod_dur"));
		String cond_cau_dea_oth_cod					=	checkForNull((String) hash.get("cond_cau_dea_oth_cod"));
		String cond_cau_dea_oth_cod_dur			=	checkForNull((String) hash.get("cond_cau_dea_oth_cod_dur"));
		String cond_cau_dea_preexist_cod			=	checkForNull((String) hash.get("cond_cau_dea_preexist_cod"));
		String cond_cau_dea_preexist_cod_dur	=	checkForNull((String) hash.get("cond_cau_dea_preexist_cod_dur"));
		String rel_cond_cau_dea_rel_cod				=	checkForNull((String) hash.get("rel_cond_cau_dea_rel_cod"));
		String rel_cond_cau_dea_rel_cod_dur		=	checkForNull((String) hash.get("rel_cond_cau_dea_rel_cod_dur"));
		String q_finalized_yn									=	checkForNull((String) hash.get("q_finalized_yn"));
		String data_upd_allowed_aft_final_yn		=	checkForNull((String) hash.get("data_upd_allowed_aft_final_yn"));

		query_string_map.put("pract_id_still_birth",pract_id_still_birth);
		query_string_map.put("attendant_at_birth",attendant_at_birth);
		query_string_map.put("autopsy_reqd_yn",autopsy_reqd_yn);
		query_string_map.put("mate_cond_main_cod",mate_cond_main_cod);
		query_string_map.put("mate_cond_main_cod_dur",mate_cond_main_cod_dur);
		query_string_map.put("mate_cond_oth_cod",mate_cond_oth_cod);
		query_string_map.put("mate_cond_oth_cod_dur",mate_cond_oth_cod_dur);
		query_string_map.put("mate_cond_preexist_cod",mate_cond_preexist_cod);
		query_string_map.put("mate_cond_preexist_cod_dur",mate_cond_preexist_cod_dur);
		query_string_map.put("oth_rel_mate_cond_rel_cod",oth_rel_mate_cond_rel_cod);
		query_string_map.put("oth_rel_mate_cond_rel_cod_dur",oth_rel_mate_cond_rel_cod_dur);
		query_string_map.put("cond_cau_dea_main_cod",cond_cau_dea_main_cod);
		query_string_map.put("cond_cau_dea_main_cod_dur",cond_cau_dea_main_cod_dur);
		query_string_map.put("cond_cau_dea_oth_cod",cond_cau_dea_oth_cod);
		query_string_map.put("cond_cau_dea_oth_cod_dur",cond_cau_dea_oth_cod_dur);
		query_string_map.put("cond_cau_dea_preexist_cod",cond_cau_dea_preexist_cod);
		query_string_map.put("cond_cau_dea_preexist_cod_dur",cond_cau_dea_preexist_cod_dur);
		query_string_map.put("rel_cond_cau_dea_rel_cod",rel_cond_cau_dea_rel_cod);
		query_string_map.put("rel_cond_cau_dea_rel_cod_dur",rel_cond_cau_dea_rel_cod_dur);
		query_string_map.put("q_finalized_yn",q_finalized_yn);
		query_string_map.put("data_upd_allowed_aft_final_yn",data_upd_allowed_aft_final_yn);
		session.setAttribute("query_string_map",query_string_map);
		out.print("MAP_UPDATED");
	}else if(process==123){
				session.removeAttribute("query_string_map");
	}

	
	/*
	if(process == 21)
	{
		String result = "";
		String error_message = "";
		String nat_id_no = request.getParameter("nationalidno")==null?"":request.getParameter("nationalidno");
		String nat_id_name = request.getParameter("nationalidname")==null?"":request.getParameter("nationalidname");
		String natlength = request.getParameter("natlength")==null?"":request.getParameter("natlength");
						
		if(stmt!=null) stmt.close();
		if(rs!=null) rs.close();
		stmt = con.prepareStatement("select VERIFY_NATIONAL_ID('"+nat_id_no+"') FROM DUAL");
		rs = stmt.executeQuery();
		if (rs.next())
			result = rs.getString(1);

		if(rs != null) rs.close();
		if(stmt != null) stmt.close();		
		StringTokenizer strTok = new StringTokenizer(result,"$");				
				
		if (strTok.hasMoreTokens()) 
			result = strTok.nextToken();
		if ( result.equals("TRUE") )
		{
			if(nat_id_name.equals("contact1_new_nat_id_no"))
			{
				if (strTok.hasMoreTokens())
					date_of_birth = strTok.nextToken();
					if  ( !date_of_birth.equals("") ) 
					{
							if  ( !localeName.equals("en"))
							date_of_birth= DateUtils.convertDate(date_of_birth,"DMY","en",localeName);
					}	out.println("<script>parent.f_query_add_mod.patient_sub.document.getElementById('contact1_birth_date').value='"+date_of_birth+"'</script>");
			}
		}
		else if ( result.equals("FALSE") )
		{
			if (strTok.hasMoreTokens())
				error_message = strTok.nextToken();
			out.println("<script>var msg = parent.f_query_add_mod.patient_sub.getMessage('"+error_message+"','MP'); msg = msg.replace('#', parent.f_query_add_mod.patient_sub.document.getElementById('nat_id_prompt').value);msg=msg.replace('@',"+natlength+");				alert(msg);parent.f_query_add_mod.patient_sub.document.all."+nat_id_name+".focus();</script>") ;
		}
		strTok = null;
	}
	*/
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
}catch(Exception e){
	out.println("tst "+e);
	e.printStackTrace();
}
finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>


<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
