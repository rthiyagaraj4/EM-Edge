package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.ByteArrayInputStream;
import java.io.BufferedReader;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;
import java.util.*;

public final class __servervalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/emp/jsp/ServerValidation.jsp", 1742472384699L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/emp/jsp/HealthCardInterface.jsp", 1711968138173L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="   \n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    public HashMap HealthCardData(java.sql.Connection con, String curr_ds_id, String scr_item_name, String scr_item_value,javax.servlet.jsp.JspWriter out, String frame_ref)
    {
        java.sql.PreparedStatement stmt = null;
        java.sql.ResultSet rset = null ;
        String sql ="";
        String ret_script = "" ;
        HashMap return_hash =  new HashMap() ;

        try
        {
            if(curr_ds_id != null)
            {
                sql = "Select Dsrc_Col_Name from MP_DATASOURCE_MAPPING_VW where Datasource_id = ? and Med_scr_item_name = ?" ;
                stmt = con.prepareStatement (sql);
				stmt.setString(1, curr_ds_id ) ;
                stmt.setString(2, scr_item_name ) ;

                rset = stmt.executeQuery();	               
                String ds_col_name = "";
                if(rset !=null)
                {
                    if(rset.next())
                    {
                        ds_col_name = rset.getString(1) ;
                        if(rset != null)  rset.close() ;
                        if(stmt != null)  stmt.close() ;

                        sql  = "select "+ds_col_name+" from mp_patient_hcs_data where "+ds_col_name+"= ? " ;
                        stmt = con.prepareStatement (sql);
                        stmt.setString(1, scr_item_value ) ;

                        rset = stmt.executeQuery();
                       
                        if(rset != null)
                        {
                            if(rset.next())
                            {
                                if(rset != null)  rset.close() ;
                                if(stmt != null)  stmt.close() ;

                                sql =" select med_col_name, med_col_datawidth,med_col_datadec, dsrc_col_datawidth,dsrc_col_datatype,dsrc_col_name, med_scr_item_name, override_yn,med_scr_legend from mp_datasource_mapping_vw where datasource_id = ? " ;
                                stmt = con.prepareStatement (sql);
                                stmt.setString(1, curr_ds_id ) ;

                                rset = stmt.executeQuery() ;
                               // out.println(sql);
                                if( rset!= null ){
                                     ret_script += ("//from here\nif(prev_set_objs !=null)\n");
                                     ret_script += ("{\n");
                                        ret_script += ("for(i =0;i<prev_set_objs.length;i++)\n");
                                         ret_script += ("{\n");
                                         ret_script += ( "if(prev_set_objs[i] != null){" ) ;
                                            ret_script += ("prev_set_objs[i].value = ''\n");
                                            
                                            ret_script += ("if(prev_set_objs[i].name == 'first_name' || prev_set_objs[i].name == 'second_name' || prev_set_objs[i].name == 'third_name' || prev_set_objs[i].name == 'family_name'||(prev_set_objs[i].name).indexOf('oth_lang')!= -1){\n") ;
                                            ret_script += ("parent.f_query_add_mod.patient_sub.ChangeInitCase(prev_set_objs[i])\n") ;
                                            ret_script += ("parent.f_query_add_mod.patient_sub.putPatientName(prev_set_objs[i])}\n") ;
                                            
                                               ret_script += ("if(prev_set_objs[i].name.indexOf('oth_lang') != -1) \n");
                                               ret_script += ("parent.f_query_add_mod.patient_sub.putLocalLangPatientName(obj) \n");

											  ret_script += ( "if( prev_set_objs[i].name == 'date_of_birth'){\n" );
                                              ret_script += ("parent.f_query_add_mod.patient_sub.gotoNext( prev_set_objs[i])\n") ;
                                              ret_script += ("parent.f_query_add_mod.patient_sub.document.getElementById('age_or_dob').disabled = false;}");

                                            ret_script += ("if(prev_set_objs[i].type == 'text')\n");
                                                ret_script += ("prev_set_objs[i].readOnly = false ;\n");
                                            ret_script += ("else\n") ;
                                                 ret_script += ("prev_set_objs[i].disabled = false ;\n");
                                         ret_script += ("}\n");
                                     ret_script += ("}}\n//end here"); 

                                    sql = "select ";
                                    ArrayList screen_items = new ArrayList() ;
                                    ArrayList legends = new ArrayList() ;
                                    while(rset.next())
                                    {
                                        if(rset.getString("DSRC_COL_DATATYPE").equals("D"))
                                            sql += " nvl(to_char("+rset.getString("dsrc_col_name")+",'dd/mm/yyyy'),'')" +"  "+  rset.getString("med_scr_item_name")+", " ;
                                        else
                                            sql += "substr("+rset.getString("dsrc_col_name") +",1,"+rset.getString("med_col_datawidth")+")  "+  rset.getString("med_scr_item_name")+", " ;

                                        if(rset.getString("override_yn").equals("N"))
                                        {
                                            screen_items.add(rset.getString("med_scr_item_name") );
                                        }
                                        
                                        legends.add(rset.getString("med_scr_legend")) ;
                                    }
                                    return_hash.put("disable_items",screen_items) ;
                                    return_hash.put("legends",legends);

                                    if(sql.indexOf(',')!= -1)
                                        sql = sql.substring(0,sql.lastIndexOf(',')) ;

                                    sql += " from  mp_patient_hcs_data where "+ds_col_name+"= ? " ;
                                    
//									 out.println(sql); 
                                    if(rset != null)  rset.close() ;
                                    if(stmt != null)  stmt.close() ;

                                    stmt = con.prepareStatement (sql);
                                    stmt.setString(1,scr_item_value);
                                    rset = stmt.executeQuery();
                                    
                                    java.sql.ResultSetMetaData rsmd = rset.getMetaData();
                                    String cols[] = new String[rsmd.getColumnCount()] ;

                                    if(rset.next()){
                                        for(int i=1; i<=rsmd.getColumnCount();i++){
                                            cols[i-1] = (rsmd.getColumnName(i).toLowerCase()) +"`"+ (rset.getString(i)==null ? " ": rset.getString(i)) ;
                                        }
                                        return_hash.put("disp_vals",cols);
                                    }
                                    if(rset != null)  rset.close() ;
                                }
                                return_hash.put("Return_Script",ret_script);								
                           }
                        }
                    }
                }
            }
        }
        catch(Exception e){try{out.println(e+":"+sql);}catch(Exception e1){}
        }
        finally
        {
            try
            {
            if( stmt != null )  stmt.close() ;
            if( rset != null )  rset.close() ;
            }catch(Exception e){}
        }
        return return_hash ;
   }
   
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

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

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
