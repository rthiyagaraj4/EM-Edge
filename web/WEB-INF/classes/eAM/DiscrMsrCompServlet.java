/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import oracle.sql.*;
import eAM.DiscrMsrComp.*;
import webbeans.eCommon.*;
public class DiscrMsrCompServlet extends HttpServlet 
{
	    PrintWriter out;
		java.util.Properties p;
	    String  facilityId			  = "" ;
		String  client_ip_address     = "" ;
		String  mode				  = "" ;  
		String  modifiedById		  = "" ;                
		String  modifiedFacilityId    = "" ;               
		String  modifiedAtWorkstation = "" ;     
      
       
	//int		matrix_max_columns_allowed = 0,		
		//grid_max_columns_allowed = 0;
    //java.util.HashMap env;
    //java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }   
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
    {
       
		HttpSession session = req.getSession(false);
        this.p = (java.util.Properties) session.getValue("jdbc") ;
        this.facilityId = (String) session.getValue( "facility_id" ) ;

        /***********************changes made on 20/02/03*******************************/
        client_ip_address = this.p.getProperty("client_ip_address");
        /*****************************ends here**********************************************/
        modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
        modifiedFacilityId        = (this.facilityId==null)?"":this.facilityId;
        modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;
        try
        {
            res.setContentType("text/html");
            this.out = res.getWriter();
            mode =(req.getParameter("mode")==null)?"":req.getParameter("mode");
            insertTemplateComponent(req, res);
        }
        catch(Exception e)
        {
            out.println("Exception @ WatchPoint No. 100->" + e);
            e.printStackTrace();
        }
    }  
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
    {
        doPost(req,res);
    }
    /*
    *    insertNoteTypeParam    -    used to populate the request parameters and
	*                                put in a Hashtable which will be further given as an argument to the
    *                                EJB - SubSection
    */
 private void insertTemplateComponent(HttpServletRequest req, HttpServletResponse res)
 {
	String ref_ranges			= "";
	String maxdgt				= "";
    String mindgt				= "";
    String decimaldgt			= "";
    String ref_low				= "";
    String ref_high				= "";
    String critical_low			= "";
    String critical_high		= "";
	String addedById			= "";
	String addedFacilityId      = "";
	String addedAtWorkstation   = "";
    String service				= "";
	String freetext				= "";
   	String ass_score_yn			= "";
    String nu_pre_yn			= "";
    String link_yn				= "";
    String std_ref				= "";
	String appl_to_all_catg_yn  = "";
    String Rec_vital			= "";
  	String Rec_chart			= "";
    String Res_rep				= "";
    String Note_temp			= "";
	
	String numeric_details_values = "";
	String comp_id    = ""                ,                comp_prompt = "";
    String long_desc = ""                ,                short_desc = "";
    String comp_type = ""                ,                max_allowed_length = "";
    String num_digit_dec = ""            ,                accept_option = "";
    String min_num_value = ""            ,                max_num_value= "";
    String dflt_value = ""                ,                include_for_anal_yn= "";
    String eff_status = ""                ,                alpha_info_values = "";
	String confidential = "";
	String beforeUpdateEff_status = "";
    String gridComponentDefinition = ""	;
	String matrixComponentDefinition	=	"";
    String histype =""; 
	String paragraphDefinition = ""   ;               
	String fieldUnit = "";
	String locale	="";
	String discTypeInd = "";
	String error        = "";
	String error_value  = "0" ; 
	String note_templ_char_allowed = "";  //68801
	Connection con					= null;
	ResultSet rs					= null;  
	PreparedStatement pstmt			= null;
	ResultSet rs1					= null;  
	PreparedStatement pstmt1		= null;
		try
        {
			
		con = ConnectionManager.getConnection(req);
	        locale = (String) this.p.getProperty( "LOCALE" ) ;
			req.setCharacterEncoding("UTF-8");
			//res.setContentType("text/html;charset=UTF-8");
            beforeUpdateEff_status = (req.getParameter("beforeUpdateEff_status")==null)?"":req.getParameter("beforeUpdateEff_status");

			confidential             = (req.getParameter("confidential")==null)?"N":req.getParameter("confidential");
			eff_status             = (req.getParameter("eff_status")==null)?"D":req.getParameter("eff_status");
            if(mode.trim().equalsIgnoreCase("update") )
            {
                comp_id				= (req.getParameter("comp_id_update")==null)?"":req.getParameter("comp_id_update");
                comp_type			= (req.getParameter("comp_type_update")==null)?"":req.getParameter("comp_type_update");
            }
            if(mode.trim().equalsIgnoreCase("insert"))
            {
                comp_id				= (req.getParameter("comp_id")==null)?"":req.getParameter("comp_id");
                comp_type			= (req.getParameter("comp_type")==null)?"":req.getParameter("comp_type");
            }

			comp_prompt				= (req.getParameter("comp_prompt")==null)?"":req.getParameter("comp_prompt");
            long_desc				= (req.getParameter("long_desc")==null)?"":req.getParameter("long_desc");
            short_desc				= (req.getParameter("short_desc")==null)?"N":req.getParameter("short_desc");
            max_allowed_length		= (req.getParameter("len")==null)?"0":req.getParameter("len");//
            num_digit_dec			= (req.getParameter("decimal")==null)?"0":req.getParameter("decimal");//
            
            accept_option			= (req.getParameter("accept_option")==null)?"":req.getParameter("accept_option");
			ref_ranges = (req.getParameter("ref_ranges")==null)?"":req.getParameter("ref_ranges");

			if(ref_ranges.equals("M"))
			{
			min_num_value			= (req.getParameter("min")==null || req.getParameter("min").equals(""))?"":req.getParameter("min");    //
            max_num_value			= (req.getParameter("max")==null || req.getParameter("max").equals(""))?"":req.getParameter("max");  //
            }
			else
			{
            min_num_value			= (req.getParameter("min")==null || req.getParameter("min").equals(""))?"":req.getParameter("min");    //
            max_num_value			= (req.getParameter("max")==null || req.getParameter("max").equals(""))?"":req.getParameter("max");  //
			}

            dflt_value				= (req.getParameter("default_val")==null || req.getParameter("default_val").equals(""))?"":req.getParameter("default_val");
            include_for_anal_yn		= (req.getParameter("include_for_anal_yn")==null)?"N":req.getParameter("include_for_anal_yn");
            alpha_info_values		= (req.getParameter("alpha_info_values")==null)?"":req.getParameter("alpha_info_values");
			alpha_info_values		= java.net.URLDecoder.decode(alpha_info_values,"UTF-8");
			
            paragraphDefinition		= (req.getParameter("paragraphDef")==null)?"":req.getParameter("paragraphDef");
        //    paragraphDefinition		= java.net.URLDecoder.decode(paragraphDefinition,"UTF-8");
            gridComponentDefinition = (req.getParameter("gridComponentDefinition")==null)?"":req.getParameter("gridComponentDefinition");
            matrixComponentDefinition = (req.getParameter("matrixComponentDefinition")==null)?"":req.getParameter("matrixComponentDefinition");
            fieldUnit				= req.getParameter("unit")==null?"":req.getParameter("unit");
            
           maxdgt= (req.getParameter("maxdgt")==null || req.getParameter("maxdgt").equals(""))?"":req.getParameter("maxdgt"); 
           mindgt= (req.getParameter("mindgt")==null || req.getParameter("mindgt").equals(""))?"":req.getParameter("mindgt"); 
           decimaldgt= (req.getParameter("decimaldgt")==null || req.getParameter("decimaldgt").equals(""))?"":req.getParameter("decimaldgt"); 
           ref_low= (req.getParameter("ref_low")==null || req.getParameter("ref_low").equals(""))?"":req.getParameter("ref_low"); 
           ref_high= (req.getParameter("ref_high")==null || req.getParameter("ref_high").equals(""))?"":req.getParameter("ref_high"); 
           critical_low= (req.getParameter("critical_low")==null || req.getParameter("critical_low").equals(""))?"":req.getParameter("critical_low"); 
           critical_high= (req.getParameter("critical_high")==null || req.getParameter("critical_high").equals(""))?"":req.getParameter("critical_high");
            service                 = (req.getParameter("service")==null)?"":req.getParameter("service");
            freetext                = (req.getParameter("freetext")==null)?"":req.getParameter("freetext");
            histype                 = (req.getParameter("histype")==null)?"":req.getParameter("histype");
			ass_score_yn			= (req.getParameter("ass_score_yn")==null)?"N":req.getParameter("ass_score_yn");
			link_yn                 = (req.getParameter("link_yn")==null)?"N":req.getParameter("link_yn");    
			
			nu_pre_yn               = (req.getParameter("nu_pre_yn")==null)?"N":req.getParameter("nu_pre_yn");       
			std_ref                 = (req.getParameter("stdrefval")==null)?"":req.getParameter("stdrefval");

			discTypeInd                  = (req.getParameter("disTypeIndval")==null)?"":req.getParameter("disTypeIndval");
              appl_to_all_catg_yn     = (req.getParameter("sel_all")==null)?"N":req.getParameter("sel_all");   
			Rec_vital				= (req.getParameter("Rec_vital")==null)?"N":req.getParameter("Rec_vital");
	        Rec_chart				= (req.getParameter("Rec_chart")==null)?"N":req.getParameter("Rec_chart");
	        Res_rep				    = (req.getParameter("Res_rep")==null)?"N":req.getParameter("Res_rep");
            Note_temp				= (req.getParameter("Note_temp")==null)?"N":req.getParameter("Note_temp");
			numeric_details_values	= (req.getParameter("numeric_details_values")==null)?"":req.getParameter("numeric_details_values");
            addedById				= (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
            addedFacilityId			= (this.facilityId==null)?"":this.facilityId;
            addedAtWorkstation		= (client_ip_address==null)?"":client_ip_address;
            note_templ_char_allowed   = (req.getParameter("char_limit")==null)?"":req.getParameter("char_limit");//68801

            if (!discTypeInd.equals(""))
            {
			 try
                {
 					int cnt=0;
 					int cnt1=0;
					String sqlQuery		=	"";
					String sqlQuery1	=	"";
					if(mode.trim().equalsIgnoreCase("update") )	{
						sqlQuery = " select count(*) from AM_DISCR_MSR where DISCR_TYPE_ID = ? ";
						pstmt = con.prepareStatement(sqlQuery);
						pstmt.setString(1,discTypeInd);
						rs=pstmt.executeQuery();
						if(rs!=null && rs.next()){
							cnt	=	rs.getInt(1); 	 	
						}
						if (cnt == 1){
							sqlQuery1 ="select count(*) from AM_DISCR_MSR where DISCR_TYPE_ID = ? and DISCR_MSR_ID != ? ";
							pstmt1 = con.prepareStatement(sqlQuery1);
							pstmt1.setString(1,discTypeInd);
							pstmt1.setString(2,comp_id);

							rs1=pstmt1.executeQuery();
							if(rs1!=null && rs1.next()){
								cnt1	=	rs1.getInt(1); 	 	
							}

							if (cnt1 > 0){
								MessageManager mm = new MessageManager();
								final java.util.Hashtable mesg = mm.getMessage(locale, "DISC_TYPE_IND_ALREADY_ASSOCIATED", "AM") ;
								error = ((String) mesg.get("message"));
								error_value="0";
								res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
								mesg.clear();
							}
							if(rs1!=null)  rs1.close();
							if(pstmt1!=null)  pstmt1.close();
						}else {
							error ="";
						}
					}else if(mode.trim().equalsIgnoreCase("insert")){
						sqlQuery = " select count(*) from AM_DISCR_MSR where DISCR_TYPE_ID = ? ";

						pstmt = con.prepareStatement(sqlQuery);
						pstmt.setString(1,discTypeInd);
						rs=pstmt.executeQuery();
						if(rs!=null && rs.next()){
							cnt	=	rs.getInt(1); 	 	
						}
						if (cnt >= 1){
							MessageManager mm = new MessageManager();
							final java.util.Hashtable mesg = mm.getMessage(locale, "DISC_TYPE_IND_ALREADY_ASSOCIATED", "AM") ;
							error = ((String) mesg.get("message"));
							error_value="0";
							res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
							mesg.clear();
						}

						if(rs!=null)  rs.close();
						if(pstmt!=null)  pstmt.close();
					}
                 }catch(Exception e){
					out.println("Exception @ WatchPoint No. 200->" + e);
					e.printStackTrace();
                 }
			}
            if (error.equals(""))
            {
					HashMap tabdata = new HashMap();
					DiscrMsrCompParagraphComponentBean beanObject = null;
					DiscrMsrCompGridComponentBean gridBeanObject = null;
					DiscrMsrCompMatrixComponentBean matrixBeanObject = null;
					if(!(beforeUpdateEff_status.equalsIgnoreCase("checked")) &&  mode.trim().equalsIgnoreCase("update"))
					{				
						tabdata.put("comp_id", comp_id);
						tabdata.put("eff_status",eff_status);
						tabdata.put("confidential_yn",confidential);
						tabdata.put("mode","beforeUpdateEff_status");
						tabdata.put("discTypeInd",discTypeInd);
						tabdata.put("modified_by_id",modifiedById);
						tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
						tabdata.put("modified_facility_id",this.facilityId);
						tabdata.put("modified_at_ws_no",modifiedAtWorkstation);
					}
					else
					{
						tabdata.put("comp_id",comp_id);
						tabdata.put("comp_prompt", comp_prompt);
						tabdata.put("long_desc",long_desc);
						tabdata.put("short_desc",short_desc);
						tabdata.put("comp_type",comp_type);
					// added fields 
						tabdata.put("service",service);
						tabdata.put("freetext",freetext);
						tabdata.put("histype",histype);
						
						tabdata.put("ref_ranges",ref_ranges);
						tabdata.put("maxdgt",maxdgt);
						tabdata.put("mindgt",mindgt);
						tabdata.put("decimaldgt",decimaldgt);
						tabdata.put("ref_low",ref_low);
						tabdata.put("ref_high",ref_high);
						tabdata.put("critical_low",critical_low);
						tabdata.put("critical_high",critical_high); 
						tabdata.put("numeric_details_values",numeric_details_values);

						tabdata.put("appl_to_all_catg_yn",appl_to_all_catg_yn);
						tabdata.put("ass_score_yn",ass_score_yn);
						tabdata.put("nu_pre_yn",nu_pre_yn);
						tabdata.put("link_yn",link_yn);
						tabdata.put("std_ref",std_ref);
						tabdata.put("discTypeInd",discTypeInd);
		 
						
						tabdata.put("Rec_vital",Rec_vital);
						tabdata.put("Rec_chart",Rec_chart);
						tabdata.put("Res_rep",Res_rep);
						tabdata.put("Note_temp",Note_temp);
						
									
						
						tabdata.put("max_allowed_length",max_allowed_length);
						tabdata.put("num_digit_dec",num_digit_dec);

						if(comp_type.equals("A") || comp_type.equals("P") || comp_type.equals("R") ||comp_type.equals("X"))
						{
							tabdata.put("accept_option","D");
							if(comp_type.equals("A")) 
							tabdata.put("field_unit",fieldUnit);
						}
						
						else
						tabdata.put("accept_option",accept_option);
						tabdata.put("min_num_value",min_num_value);
						tabdata.put("max_num_value",max_num_value);
						tabdata.put("field_unit",fieldUnit);
						tabdata.put("dflt_value",dflt_value);
						tabdata.put("include_for_anal_yn",include_for_anal_yn);
						tabdata.put("eff_status",eff_status);
						tabdata.put("confidential_yn",confidential);
						if(comp_type.equals("P"))
						{
						   
							try
							{
							  
								tabdata.put("alpha_info_values",paragraphDefinition);
								beanObject=new DiscrMsrCompParagraphComponentBean();
								tabdata.put("xml_definition",beanObject.changeDefinitionToXML(con,paragraphDefinition,comp_id));
								beanObject=null;
							}
							catch(Exception e)
							{
								out.println("Exception @ WatchPoint No. 101->" + e);
								e.printStackTrace();
							   
							}
							
						}
						else 
						{	
							tabdata.put("alpha_info_values",alpha_info_values);
						}
						//addition for grid component starts here
						StringBuffer xmlDefinition = new StringBuffer();
						
						if(comp_type.equals("R"))
						{
							
							try
							{						
								
								gridBeanObject = new DiscrMsrCompGridComponentBean();
								xmlDefinition = gridBeanObject.changeDefinitionToXML(con, gridComponentDefinition, comp_id, short_desc,locale);
							}
							catch(Exception e)
							{
								out.println("Exception @ WatchPoint No. 102->" + e);
								e.printStackTrace();
							}
							
							
						}
						else if(comp_type.equals("X"))
						{
							
							try
							{						
								
								matrixBeanObject = new DiscrMsrCompMatrixComponentBean();
								xmlDefinition = matrixBeanObject.changeDefinitionToXML(con, matrixComponentDefinition, comp_id, short_desc);						
							}
							catch(Exception e)
							{
								out.println("Exception @ WatchPoint No. 103->" + e);
								e.printStackTrace();
							}
							
						}
						if(comp_type.equals("R") || comp_type.equals("X"))
						{
							try
							{
								if(comp_type.equals("R"))
									tabdata.put("alpha_info_values", gridComponentDefinition);
								else if(comp_type.equals("X"))
									tabdata.put("alpha_info_values", matrixComponentDefinition);						
								tabdata.put("xml_definition", xmlDefinition.toString());						
								gridBeanObject = null;
							}
							catch(Exception e)
							{
								out.println("Exception @ WatchPoint No. 104->" + e);
								e.printStackTrace();
							}
							finally
							{
							}
						}
						//addition for grid component ends here
						tabdata.put("mode",mode);
						tabdata.put("added_by_id",addedById);
						tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
						tabdata.put("added_facility_id", addedFacilityId);
						tabdata.put("added_at_ws_no",addedAtWorkstation);
						tabdata.put("modified_by_id",modifiedById);
						tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
						tabdata.put("modified_facility_id",modifiedFacilityId);
						tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
						tabdata.put("note_templ_char_allowed",note_templ_char_allowed );//68801
					}

				   boolean local_ejbs = false;

				   if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
						local_ejbs = true;


					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/DiscrMsrComp",DiscrMsrCompHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					Object argArray[] = new Object[2];
					argArray[0] = p;
					argArray[1] = tabdata;
					Class [] paramArray = new Class[2];
					paramArray[0] = p.getClass();
					paramArray[1] = tabdata.getClass();
					java.util.HashMap results=new HashMap();

					if(mode.equalsIgnoreCase("insert"))
					{
						results =(HashMap)busObj.getClass().getMethod("insertTemplateComponent", paramArray).invoke(busObj, argArray);
					}
					else
					{
						results =(HashMap)busObj.getClass().getMethod("modifyTemplateComponent", paramArray).invoke(busObj, argArray); 
					}

				   // boolean inserted = (((Boolean) results.get( "status" )).booleanValue() ) ;
					error        = (String) results.get("error") ;
					error_value  = "0" ; 
					tabdata.clear();
					results.clear();
					/*if ( inserted )
					{
						//if the paragraph definition is inserted sucessfully then
						//update each section template definition which is using this paragraph as a component.
						//this will happen only in case of updation
					   // Connection con = null;
						PreparedStatement pstmt = null,ptmtInsert = null;
						ResultSet rs = null, rs1 = null;
						Clob clb = null;
						BufferedWriter w = null;
						DiscrMsrCompSectionTemplateXMLDefinitionBean objBean = new DiscrMsrCompSectionTemplateXMLDefinitionBean();
						String xmlString = null;
						try
						{
							con=ConnectionManager.getConnection(req);
							con.setAutoCommit(false);
							String sqlQuery = "select sec_hdg_code from ca_section_template where comp_id = ? ";
							pstmt = con.prepareStatement(sqlQuery);
							pstmt.setString(1,comp_id);
							rs=pstmt.executeQuery();
							String secHdgCode = "";
							String insertSQL = "";
							while(rs.next())
							{
								secHdgCode = rs.getString("sec_hdg_code");
								//inserting empty clob for updation
								insertSQL="update ca_section_hdg set TEMPLATE_FORMAT = empty_clob() where SEC_HDG_CODE=?";
								ptmtInsert=con.prepareStatement(insertSQL);
								ptmtInsert.setString(1,secHdgCode);
								ptmtInsert.executeUpdate();
								ptmtInsert.close();
								//locking the table and putting the actual data
								insertSQL = "Select TEMPLATE_FORMAT from ca_section_hdg  where SEC_HDG_CODE = ? for update ";
								ptmtInsert=con.prepareStatement(insertSQL);
								ptmtInsert.setString(1,secHdgCode);
								rs1= ptmtInsert.executeQuery() ;
								if(rs1!=null && rs1.next())
								{
									clb = rs1.getClob(1);
									w = new BufferedWriter(((CLOB)clb).getCharacterOutputStream());
									xmlString = objBean.constructXML(con,secHdgCode).toString();
									w.write(xmlString,0,xmlString.length());
									w.flush();
									w.close();
								}if(rs1!= null) rs1.close();
							if(ptmtInsert!= null)ptmtInsert.close();
							}
							
							con.commit();
							error_value = "1" ;
							res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
							if(rs!= null) rs.close();
							
							if(pstmt!= null)pstmt.close();
							rs = null;
							rs1 = null;
							
							 
						}
						catch(Exception e)
						{
							out.println("Exception @ WatchPoint No. 105->" + e);
							e.printStackTrace();
						}
						finally
						{
							objBean = null;
							w = null;
							clb=null;
							xmlString =null;
							if(con!=null)
								ConnectionManager.returnConnection(con,req);
						}
					}
					else
					{
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
					}*/ 
						
					  if(error.indexOf("APP-000064")!=-1)
					{
						 error_value="0";
						 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
					}
					  else
					{
						error_value="1";
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
					} 
			} 
		}
        catch (Exception e)
        {
            out.println("Exception @ WatchPoint No. 106--> " + e);
            e.printStackTrace();
        } finally
       {
                        if(con != null) ConnectionManager.returnConnection(con, req);
       }
    } 
}
