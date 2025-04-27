package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __tempqmgmtpract extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/TempQmgmtPract.jsp", 1709119502209L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n            <script>\n                \t\t\t\t\n                var opt = parent.parent.frames[1].document.createElement(\'OPTION\');\n                opt.text = \'-----\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'-----\';\n                opt.value= \'\';\n                opt.selected=\'true\'\n                parent.parent.frames[1].document.forms[0].VAssign.add(opt);\n\n            </script>\n        ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t  <script>\n\t\t\tparent.parent.frames[1].document.forms[0].IDENT_AT_CHECKIN.value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\';\n\t\t\t  </script>\n\t\t\t ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n                    <script>\n                        var element = parent.parent.frames[1].document.createElement(\'OPTION\');\n                            element.text = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n                            element.value= \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"+\"|\"+\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n                            parent.parent.frames[1].document.forms[0].pract_id.add(element);\n\n                    </script>\n\t\t\t    ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<script>        \n\t\t\t\t\tparent.parent.frames[1].document.getElementById(\"practtype\").innerHTML=\"&nbsp;";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t        </script>\n        ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t  parent.frames[1].document.getElementById(\"room_value\").innerHTML=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\t\t\t</script>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\tparent.frames[1].document.getElementById(\"room_num\").value =\"NoRoom\";\n\t\t\t\t\tparent.frames[1].document.getElementById(\"room_value\").innerHTML=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
 
	request.setCharacterEncoding("UTF-8");
	/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
	String   locale = (String)session.getValue("LOCALE");
	/*end SS-CRF-0010 [IN034516]*/
	String chkval=request.getParameter("list_name111");
	String step=request.getParameter("step");
	if(step == null)
	step="";
	
	StringBuffer sql=new StringBuffer();
    Connection con = null;
    String fac_id  =  (String) session.getValue( "facility_id" ) ;
    String locn_code        = request.getParameter("LAssign1");
    String p_pract_id       = request.getParameter("p_pract_id");
   	String str1="";
	String str2="";
	String IDENT_AT_CHECKIN="";
	//int rcnt=0;
	
	//Statement stmt3=null;
    //ResultSet rs3 = null;

	PreparedStatement pstmt =null;
	ResultSet rs = null;
	StringBuffer rstr=new StringBuffer();

	rstr.setLength(0);
	
	
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


	out.println("<html><HEAD><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown ='lockKey()'><script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><form name='testform' id='testform'>");

	try{
		con = ConnectionManager.getConnection(request);
		if(step.equals("2"))
		{
        if (p_pract_id == null)
        {
        
            _bw.write(_wl_block5Bytes, _wl_block5);

            sql.append(" select open_to_all_pract_yn ass_open_to_all_pract_yn, speciality_code ass_speciality_code, pract_type ass_pract_type,IDENT_AT_CHECKIN ");
            sql.append(" from op_clinic where clinic_code = '"+locn_code+"' and facility_id = '"+fac_id+"' ");

			 pstmt = con.prepareStatement(sql.toString());
             rs = pstmt.executeQuery();
          
            sql.setLength(0);
			
            if (rs != null)
            {
                if(rs.next())
                {
                    String p_ass_open_to_all_pract_yn   =   rs.getString("ass_open_to_all_pract_yn");
                    String p_ass_pract_type         =   rs.getString("ass_pract_type");
                    String p_ass_speciality_code        =   rs.getString("ass_speciality_code");
                    String p_ass_locn_code = locn_code;
                    p_ass_pract_type = rs.getString("ass_pract_type");

					IDENT_AT_CHECKIN=rs.getString("IDENT_AT_CHECKIN");

                    if (p_ass_pract_type == null) p_ass_pract_type="";
                                      
                    if ((p_ass_open_to_all_pract_yn).equals("Y"))
                    {
                        sql.append(" select practitioner_id ass_pract_id, practitioner_name, pract_type_desc from am_pract_for_facility_vw ");
                        sql.append(" where nvl(pract_type,'X') = nvl('"+p_ass_pract_type+"', nvl(pract_type,'X')) and primary_speciality_code = '"+p_ass_speciality_code+"' and " );
                        sql.append(" eff_status='E' and operating_facility_id = '"+fac_id+"'");
                        sql.append(" union select b.practitioner_id ass_pract_id,b.practitioner_name, nvl(DESC_USERDEF,DESC_SYSDEF)  pract_type_desc from am_pract_specialities a, am_practitioner b, op_clinic c,am_pract_type d where c.facility_id = a.facility_id and ");
                        sql.append(" b.practitioner_id = a.practitioner_id and c.clinic_code='"+p_ass_locn_code+"' and b.pract_type =  nvl(c.pract_type,b.pract_type) and a.facility_id='"+fac_id+"' and d.pract_type=b.pract_type ");               
                        sql.append(" and  a.speciality_code= c.speciality_code order by 2" );
                    }
                    else
                    {
                        sql.append("select b.practitioner_id ass_pract_id, b.practitioner_name, c.pract_type_desc from op_pract_for_clinic a, am_practitioner b ,am_pract_for_facility_vw c,");
                        sql.append("(select day_no from sm_day_of_week where day_of_week = rtrim(to_char(sysdate,'DAY')))d where decode(d.day_no,'1',a.working_day_1,'2',a.working_day_2,'3',a.working_day_3,'4',a.working_day_4,'5',a.working_day_5,'6',a.working_day_6,a.working_day_7)='Y' and ");
                        sql.append("  a.practitioner_id = b.practitioner_id and a.clinic_code = '"+p_ass_locn_code+"' and b.pract_type = nvl('"+p_ass_pract_type+"',b.pract_type) and a.facility_id = '"+fac_id+"' ");
                        sql.append(" and c.practitioner_id = a.practitioner_id and c.operating_facility_id = '"+fac_id+"' order by 2");
                    }
                }
            }

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

             String str3 = "";
	
		   
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(IDENT_AT_CHECKIN));
            _bw.write(_wl_block7Bytes, _wl_block7);

			 pstmt = con.prepareStatement(sql.toString());
             rs = pstmt.executeQuery();

            if( rs != null )
            {
                while( rs.next() )
                {
                    str1 = rs.getString( "practitioner_name" ) ;
                    str2 = rs.getString( "ass_pract_id" );
                    str3 = rs.getString( "pract_type_desc" );
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(str1));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(str2));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(str3));
            _bw.write(_wl_block11Bytes, _wl_block11);

                }
            }

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			sql.setLength(0);

        }
        else
        {
			String sqlType = "Select pract_type_desc from am_practitioner_vw where practitioner_id='"+p_pract_id+"'";
			
            pstmt = con.prepareStatement(sqlType);
            rs = pstmt.executeQuery();

            if (rs != null)
            {
                while(rs.next())
				{
		
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block13Bytes, _wl_block13);

				}
			}
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
          }
		}
		else
		{
			rstr.append("<option value=''> ----- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ----- </option>");
			
			if(chkval.equals("LAssign1"))
			{
				    /*stmt3 = con.createStatement();
					String Sql3  = "select count(*) as total from op_pract_for_clinic where facility_id='"+fac_id+"' and clinic_code='"+locn_code+"' and eff_status='E' and resource_class='R' order by practitioner_id ";

					rs3 = stmt3.executeQuery(Sql3);
					rs3.next();
					rcnt=rs3.getInt("total");

					if(rs3 != null) rs3.close();
					if(stmt3 != null) stmt3.close();*/
	            
				/*below query was modified by venkatesh.s on 07-Nov-2012 against 36094*/
					 pstmt   = con.prepareStatement( "select practitioner_id ROOM_NO,am_get_desc.am_facility_room (a.facility_id, a.practitioner_id, '"+locale+"', 2) room_desc from op_pract_for_clinic a  where facility_id='"+fac_id+"' and clinic_code='"+locn_code+"' and eff_status='E' and resource_class='R' order by practitioner_id");

					rs = pstmt.executeQuery();
				
						boolean flagvalue=false;
                        String room_desc="";
						while( rs.next())
						{
							flagvalue=true;
							str2 = rs.getString( "ROOM_NO" );	
                             room_desc=rs.getString("room_desc" );	
                             							 
							rstr.append("<option value='"+str2+"' >"+str2+" "+room_desc+"</option>");	   
						}
					 	

					 if(rs != null) rs.close();
					 if(pstmt != null) pstmt.close();

					 if(flagvalue)
					 {	
					  String robj="<select name='room_numsel' id='room_numsel' onChange='chgvalue(this);'>"+rstr.toString()+"</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'>";
                      /*end 36094*/					 
					  
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(robj));
            _bw.write(_wl_block15Bytes, _wl_block15);
					
				     }
					else
					{					
					String robj="<select name='room_numsel' id='room_numsel' onChange='chgvalue(this);'><option value=''>---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---</option></select>";
					
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(robj));
            _bw.write(_wl_block17Bytes, _wl_block17);
	
					}				
				}  
		 }
 rstr.setLength(0);
}
catch(Exception e)
{
   e.printStackTrace();
}
finally{

	if(con != null) ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block18Bytes, _wl_block18);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
