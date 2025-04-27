
<%@ page import = "java.util.*"%>
<%!
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
   %>
