package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;

public final class __healthcardinterface extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/HealthCardInterface.jsp", 1711968138173L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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
   

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
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
