package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __aempdynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEMPDynamicValues.jsp", 1728990783175L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t\t    <script language=\'javascript\'>\n\t\t\t\t  var opt\t\t=\tparent.frames[2].document.forms[0].createElement(\'OPTION\'); \n\t\t\t\topt.text\t=\t\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\t\topt.value\t=\t\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\tparent.frames[2].document.forms[0].treatmentGender[";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="] = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\t\t\t\tparent.frames[2].document.forms[0].openToAllPractForClnYN[";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t\t\tparent.frames[2].document.forms[0].document.forms[0].treatment_area_code.add(opt); \n\t\t\t   </script>\n\t\t\t ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t <script language=\'javascript\'>\n\t\t\t\tvar opt\t\t=\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =".document.createElement(\'OPTION\'); \n\t\t\t\topt.text\t=\t\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =".treatmentGender[";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\';\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =".openToAllPractForClnYN[";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\';\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =".document.forms[0].treatment_area_code.add(opt); \n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<script>\n            \t\ttop.content.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<script>\n\t\t\t\t     parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<script language=\'javascript\'>\n\n//\t\t\t\tvar opt\t\t=\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =".document.createElement(\'OPTION\'); \n//\t\t\t\topt.text\t=\t\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n//\t\t\t\topt.value\t=\t\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\t\t\t//";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =".document.forms[0].practitioner_id.add(opt); \n\t\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t<script>\n                        ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =".document.forms[0].open_to_all_prac_for_clinic_yn.value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\';\n\t\t\t\t\t</script>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<script>\n\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =".document.getElementById(\"bed_mand\").style.visibility=\'visible\';\n\t\t        ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =".document.forms[0].bed_count.value=\'Y\';\n\t\t\t\t//";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =".document.forms[0].ok.disabled=true;\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =".document.getElementById(\"bed_mand\").style.visibility=\'hidden\';\n\t\t        ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =".document.forms[0].bed_count.value=\'N\';\n\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =".document.forms[0].ok.disabled=false;\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\n</html>\n\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/common.js' language='javascript'></script><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script></head><body class='MESSAGE' onMouseDown='CodeArrest();' onKeyDown ='lockKey();'></body>");


            _bw.write(_wl_block1Bytes, _wl_block1);

try{
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	PreparedStatement pstmt1   		=	null;
	ResultSet rs1					=	null;
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String locale			= (String)session.getAttribute("LOCALE");

	StringBuffer query_treatment_area	=	new StringBuffer();
	String facility_id				=	"";
	String	treatment_area_gender	=	"";
	String	treatment_area_code		=	"",		treatment_area_desc		=	"";
	String	clinic_code				=	"",		pop_mode				=	"";
	StringBuffer query_practitioner		= new StringBuffer();		
	String open_to_all_pract_yn	=	"";
	String	practitioner_id			=	"",		practitioner_name		=	"";
	String	frame_name				=	"";
	String  called_from_ca			=	"";
	int countBed=0;

	String	open_to_all_prac_for_clinic_yn	=	"";

	int		arrIndex				=	1;
	try
	{
		
		facility_id		=	(String)		session.getValue("facility_id");

		clinic_code		=	request.getParameter("clinic_code")==null ? "" : request.getParameter("clinic_code");
		pop_mode		=	request.getParameter("pop_mode")==null ? "" : request.getParameter("pop_mode");
		frame_name		=	request.getParameter("frame_name")==null ? "" : request.getParameter("frame_name");
		called_from_ca		=request.getParameter("ca")==null ? "" : request.getParameter("ca"); 
		con				=	ConnectionManager.getConnection(request);
        
		if((pop_mode.equals("TreatmentArea")))
		{
			query_treatment_area.append(" select treatment_area_code, short_desc treatment_area_desc,gender treatment_area_gender, open_to_all_prac_for_clinic_yn from AE_TMT_AREA_FOR_CLINIC_LANG_VW where language_id='"+locale+"'  and  facility_id = ? and CLINIC_CODE = ? and eff_status = 'E' order by 2  ");
			pstmt		=	con.prepareStatement(query_treatment_area.toString());

			pstmt.setString	(	1,	facility_id		);
			pstmt.setString	(	2,	clinic_code		);
				
			rs			=	pstmt.executeQuery();
           
			while(rs.next())
			{
				treatment_area_code				=	rs.getString("treatment_area_code");
				treatment_area_desc				=	rs.getString("treatment_area_desc");
				treatment_area_gender			=	rs.getString("treatment_area_gender");
				open_to_all_prac_for_clinic_yn	=	rs.getString("open_to_all_prac_for_clinic_yn");

				if(treatment_area_gender==null)				treatment_area_gender			=	"";
				if(open_to_all_prac_for_clinic_yn==null)	open_to_all_prac_for_clinic_yn	=	"N";
				if (called_from_ca.equals("Y")){
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(treatment_area_desc));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(treatment_area_code));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(arrIndex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(treatment_area_gender));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(arrIndex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(open_to_all_prac_for_clinic_yn ));
            _bw.write(_wl_block11Bytes, _wl_block11);
}else{
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(treatment_area_desc));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(treatment_area_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(arrIndex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(treatment_area_gender));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(arrIndex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(open_to_all_prac_for_clinic_yn ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block19Bytes, _wl_block19);

				}
				arrIndex++;
			} // end of while
			if (called_from_ca.equals("Y")){
            _bw.write(_wl_block20Bytes, _wl_block20);
}else{
            _bw.write(_wl_block21Bytes, _wl_block21);
}
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		}
		
		if(pop_mode.equals("Practitioner") || pop_mode.equals("TreatmentArea") )
		{
			open_to_all_pract_yn			=	(request.getParameter("open_to_all_pract_yn")==null)	?	""	:	request.getParameter("open_to_all_pract_yn");
			treatment_area_code				=	(request.getParameter("treatment_area_code")==null)		?	""	:	request.getParameter("treatment_area_code");
			open_to_all_prac_for_clinic_yn	=	(request.getParameter("open_to_all_prac_for_clinic_yn")==null)	?	""	:	request.getParameter("open_to_all_prac_for_clinic_yn");

			if(open_to_all_pract_yn.equals("Y"))
			{
				if(open_to_all_prac_for_clinic_yn.equals("Y"))
				{
					query_practitioner.append(" Select practitioner_id, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1') practitioner_name from am_pract_for_facility where facility_id = ? and eff_status = 'E' order by 2");

                    if(pstmt!=null) pstmt.close();
					pstmt		=	con.prepareStatement(query_practitioner.toString());

					pstmt.setString	(	1,	facility_id		);
				}
				else if(treatment_area_code.equals(""))
				{
					query_practitioner.append(" select distinct practitioner_id, ");
					query_practitioner.append(" AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','1')  practitioner_name  from ae_pract_for_tmt_area where facility_id = ? and clinic_code = ? and eff_status = 'E' order by 2 ");
                    if(pstmt!=null) pstmt.close();
					pstmt		=	con.prepareStatement(query_practitioner.toString());

					pstmt.setString	(	1,	facility_id		);
					pstmt.setString	(	2,	clinic_code		);
				}
				else
				{
					query_practitioner.append(" select practitioner_id, ");
					query_practitioner.append(" AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','1')   practitioner_name from ae_pract_for_tmt_area where facility_id = ? and clinic_code = ? and treatment_area_code = ? and eff_status = 'E' order by 2");

                    if(pstmt!=null) pstmt.close();
					pstmt		=	con.prepareStatement(query_practitioner.toString());

					pstmt.setString	(	1,	facility_id			);
					pstmt.setString	(	2,	clinic_code			);
					pstmt.setString (	3,	treatment_area_code	);
				}
			}
			else
			{
				if(open_to_all_prac_for_clinic_yn.equals("Y"))
				{
					query_practitioner.append(" Select practitioner_id, AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','1') practitioner_name from op_pract_for_clinic where facility_id = ? and clinic_code = ? and em_visit_type_appl_yn ='Y' and eff_status = 'E' order by 2 ");

                    if(pstmt!=null) pstmt.close();
					pstmt		=	con.prepareStatement(query_practitioner.toString());

					pstmt.setString	(	1,	facility_id			);
					pstmt.setString	(	2,	clinic_code			);
				}
				else if(treatment_area_code.equals(""))
				{
					query_practitioner.append(" select distinct practitioner_id, ");
					query_practitioner.append(" AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','1')  practitioner_name  from ae_pract_for_tmt_area where facility_id = ? and clinic_code = ? and eff_status = 'E' order by 2 ");

                    if(pstmt!=null) pstmt.close();
					pstmt		=	con.prepareStatement(query_practitioner.toString());

					pstmt.setString	(	1,	facility_id			);
					pstmt.setString	(	2,	clinic_code			);
				}
				else
				{
					query_practitioner.append(" select practitioner_id, ");
					query_practitioner.append(" AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','1') practitioner_name  from ae_pract_for_tmt_area where facility_id = ? and clinic_code = ? and treatment_area_code = ?  and eff_status = 'E' order by 2 ");

                    if(pstmt!=null) pstmt.close();
					pstmt		=	con.prepareStatement(query_practitioner.toString());

					pstmt.setString	(	1,	facility_id			);
					pstmt.setString	(	2,	clinic_code			);
					pstmt.setString (	3,	treatment_area_code	);
				}
			}
			rs			=	pstmt.executeQuery();

			while(rs.next())
			{
				practitioner_id		=	rs.getString("practitioner_id");
				practitioner_name	=	rs.getString("practitioner_name");
			
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block26Bytes, _wl_block26);

			} // end of while
            if(rs!=null)rs.close();
		    if(pstmt!=null) pstmt.close();
			try{
				if(!treatment_area_code.equals(""))
				{
				    String sqlTreat    = "select GENDER, OPEN_TO_ALL_PRAC_FOR_CLINIC_YN from AE_TMT_AREA_FOR_CLINIC where FACILITY_ID='"+facility_id+"' and CLINIC_CODE='"+clinic_code+"' and TREATMENT_AREA_CODE ='"+treatment_area_code+"'";
					pstmt1   = con.prepareStatement(sqlTreat);
					rs1		 = pstmt1.executeQuery(); 
					if(rs1!=null)
					{
						while(rs1.next())
							{
								open_to_all_prac_for_clinic_yn=rs1.getString("OPEN_TO_ALL_PRAC_FOR_CLINIC_YN");
								treatment_area_gender=rs1.getString("GENDER");
							}
					}
					if(pstmt1!=null) pstmt1.close();
		            if(rs1!=null) rs1.close(); 
					
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(open_to_all_prac_for_clinic_yn));
            _bw.write(_wl_block29Bytes, _wl_block29);

				 }
			    }
			catch (Exception e)	{}
			finally
		   {	if(pstmt1!=null)pstmt1.close();
		        if(rs1!=null)rs1.close();
 		   }
		  try{
               if(!treatment_area_code.equals(""))
				 {
				    String sqlBed    = "select count(*) from ae_bed_for_trmt_area where FACILITY_ID=?  and  clinic_code=? and  TREATMENT_AREA_CODE=? and EFF_STATUS='E'";
					pstmt1   = con.prepareStatement(sqlBed);
                    pstmt1.setString(1,facility_id);
					pstmt1.setString(2,clinic_code);
                    pstmt1.setString(3,treatment_area_code);
					rs1		 = pstmt1.executeQuery(); 
					if(rs1!=null)
					{
						while(rs1.next())
							{
								countBed=rs1.getInt(1);
							}
					}
					if(pstmt1!=null) pstmt1.close();
		            if(rs1!=null) rs1.close(); 
				   }

			     }
			catch (Exception e)	{}
			finally
		   {	if(pstmt1!=null)pstmt1.close();
		        if(rs1!=null)rs1.close();
 		   }
	  if(!treatment_area_code.equals(""))
	  {
		if (countBed > 0)
		{
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block33Bytes, _wl_block33);
}	else { 
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block36Bytes, _wl_block36);
} 
		 }
		} // end of else if(pop_mode.equals("Practitioner"))
	   
	
	query_treatment_area.setLength(0);
    query_practitioner.setLength(0);

	if(rs!=null)rs.close();
	if(pstmt!=null) pstmt.close();
	}	// end of try
	catch(Exception e)
	{
		e.printStackTrace();
    }
	finally
	{
		
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
	}
}
catch(Exception e)
{
	e.printStackTrace();
}

            _bw.write(_wl_block37Bytes, _wl_block37);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
