package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __arriveddepartedgetval extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/ArrivedDepartedGetVal.jsp", 1709119424351L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\ttp =\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\t\t\t\t\t\t\n\t\t\t\t\t\t\ttpval=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"; \n\t\t\t\t\t\t\tvar opt;\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\t\t var opt=parent.document.frames[1].document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\tvar opt=parent.document.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\topt.text=tp;\n\t\t\t\t\t\t\topt.value=tpval;  \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\tparent.document.frames[1].document.frames[1].document.forms[0].location_code.add(opt);  \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\tparent.document.frames[1].document.forms[0].location_code1.add(opt);\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t  parent.document.frames[1].document.forms[0].location_code1.value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\t\t//parent.document.frames[1].document.forms[0].location_code1.disabled=true;\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t</script>     \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="          \n            \n            \n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
	request.setCharacterEncoding("UTF-8");	
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
          
	Connection conn = null;           
	PreparedStatement pstmt = null;
	ResultSet rs =null;
	StringBuffer sql1=new StringBuffer();
	//String oper_stn_id="";
	String locncode="";
	String locndesc="";
	String locale=(String)session.getAttribute("LOCALE"); 

	try{
         out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE'  onKeyDown='lockKey();'><form name='nam1' id='nam1'>");

         String facilityid=(String)session.getValue("facility_id");	
		// String userid           = (String) session.getValue("login_user");
		 String locntype=request.getParameter("locn_type");
		 locncode=request.getParameter("locn_code");
		 if(locncode == null) locncode = "";		 
		
	 	 String callvalue=request.getParameter("callval");
		 String locn_ind=request.getParameter("locn_ind");
		 if(locn_ind == null) locn_ind="";
		 
		  String enc_locn_type=request.getParameter("enc_locn_type");
		  if(enc_locn_type == null) enc_locn_type="";
		  String enc_locn_code=request.getParameter("enc_locn_code");
		  if(enc_locn_code == null) enc_locn_code="";
			 

 		 conn=ConnectionManager.getConnection(request);
			
		/* pstmt=conn.prepareStatement("select oper_stn_id from am_user_for_oper_stn where facility_id=? and appl_user_id=? and trunc(sysdate) between trunc(eff_date_from) and trunc(nvl(eff_date_to,sysdate))");

		 pstmt.setString(1,facilityid);
		 pstmt.setString(2,userid);		
		 rs=pstmt.executeQuery();
			if(rs != null)
				{
					while(rs.next())
					{
						oper_stn_id=rs.getString(1);
					}
				}

				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();*/
				
            _bw.write(_wl_block3Bytes, _wl_block3);


		

		  
		  if(locn_ind.equals("N"))
			{

				 //sql1.append("Select  a.nursing_unit_code id ,a.short_desc dat from ip_nursing_unit a  where a.facility_id = '"+facilityid+"' and a.eff_status = 'E' and a.locn_type='"+locntype+"' and a.appl_patient_class = 'IP' ");

				 sql1.append("Select a.nursing_unit_code id ,a.LONG_DESC dat from ip_nursing_unit_lang_vw a  where language_id='"+locale+"' and a.facility_id = '"+facilityid+"' and a.eff_status = 'E' and a.locn_type='"+locntype+"' and a.patient_class = 'IP' ");	

				 if(callvalue.equals("Departed") && !locncode.equals(""))
				{
						sql1.append(" and a.nursing_unit_code != '"+locncode+"'");
				}

				 sql1.append(" order by 2");				 
			}
		else if(locn_ind.equals("R"))
			{
				//sql1.append("Select Room_num Clinic_code, Short_desc from AM_FACILITY_ROOM ");
				//sql1.append("where eff_status = 'E' and operating_facility_id = '"+facilityid+"' and room_type = '"+locntype+"' order by 2");
				sql1.append("Select Room_num Clinic_code, Short_desc from AM_FACILITY_ROOM_lang_vw ");				
				sql1.append("where language_id='"+locale+"' AND eff_status = 'E' and operating_facility_id = '"+facilityid+"' and room_type = '"+locntype+"' order by 2");
			}
			else
			{
				/*sql1.append("select clinic_code,short_desc from op_clinic a");
				sql1.append(" where eff_status='E' ");
				sql1.append("and upper(clinic_type) in (select locn_type from am_care_locn_type where locn_type='"+locntype+"') and facility_id='"+facilityid+"' and (facility_id, clinic_type, clinic_code) in (select facility_id, locn_type, locn_code from am_locn_for_oper_stn where facility_id ='"+facilityid+"' ");
				sql1.append("and oper_stn_id ='"+oper_stn_id+"' )");*/
             sql1.append("select clinic_code,long_desc from op_clinic_lang_vw a where facility_id='"+facilityid+"' and language_id='"+locale+"' AND eff_status='E' and clinic_type = '"+locntype+"'"); 
							  
			//	sql1.append("select clinic_code,short_desc from op_clinic_lang_vw a where language_id='"+locale+"' AND eff_status='E' and upper(clinic_type) in (select locn_type from am_care_locn_type where locn_type='"+locntype+"') and facility_id='"+facilityid+"' and (facility_id, clinic_type, clinic_code) in (select facility_id, locn_type, locn_code from am_locn_for_oper_stn where facility_id ='"+facilityid+"' and oper_stn_id ='"+oper_stn_id+"')");

				if(callvalue.equals("Departed") && !locncode.equals(""))
				{
						sql1.append(" and a.clinic_code != '"+locncode+"'");
				}
				sql1.append(" order by 2");
			}
				
				
				pstmt=conn.prepareStatement(sql1.toString());
				rs=pstmt.executeQuery();				
				if(rs != null)
				{
					while(rs.next())
					{
						locncode=rs.getString(1);
						locndesc=rs.getString(2);
						
						
						
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(locndesc));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(locncode));
            _bw.write(_wl_block6Bytes, _wl_block6);

						if(callvalue.equals("Criteria"))
						{
							
            _bw.write(_wl_block7Bytes, _wl_block7);

						}
						else
						{
            _bw.write(_wl_block8Bytes, _wl_block8);

						}
							
            _bw.write(_wl_block9Bytes, _wl_block9);

						if(callvalue.equals("Criteria"))
						{
							
            _bw.write(_wl_block10Bytes, _wl_block10);

						}
							else if(callvalue.equals("Departed"))
						{
            _bw.write(_wl_block11Bytes, _wl_block11);

					if(enc_locn_type.equals(locntype))	
				    {
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(enc_locn_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
				 }
								
            _bw.write(_wl_block14Bytes, _wl_block14);

					}
				}

				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();

    }catch(Exception e) { 
		e.printStackTrace();
		}
    
	finally
    {
      if(conn!=null) ConnectionManager.returnConnection(conn,request);
    }
    out.println("</form></body></html>");       
                            

            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
