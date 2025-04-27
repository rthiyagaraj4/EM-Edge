package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __fetchvalsforbooklodger extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/fetchValsForBookLodger.jsp", 1709117758662L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n    <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n     \n\t\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head> \n<body class = \'message\' onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'> \n    \n    ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n                         <script>\n                            if(parent.frames[1].frames[2].document.forms[0].lodger_name)\n                        {\n                            parent.frames[1].frames[2].document.forms[0].lodger_name.value =\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" \n                            parent.frames[1].frames[2].document.forms[0].lodger_name.readOnly= true;\n                        }\n                           if(parent.frames[1].frames[2].document.forms[0].reln_with_patient)\n                           \tparent.frames[1].frames[2].document.forms[0].reln_with_patient.focus();\n                           \telse\n                           \tparent.frames[1].frames[2].document.forms[0].ln1_lodger_add.focus();\n                           \t\n                           if(parent.frames[1].frames[2].document.forms[0].ln1_lodger_add)\n                            parent.frames[1].frames[2].document.forms[0].ln1_lodger_add.value =\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" \n                            if(parent.frames[1].frames[2].document.forms[0].ln2_lodger_add)\n                            parent.frames[1].frames[2].document.forms[0].ln2_lodger_add.value =\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" \n                            if(parent.frames[1].frames[2].document.forms[0].ln3_lodger_add)\n                            parent.frames[1].frames[2].document.forms[0].ln3_lodger_add.value =\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" \n                            if(parent.frames[1].frames[2].document.forms[0].ln4_lodger_add)\n                            parent.frames[1].frames[2].document.forms[0].ln4_lodger_add.value =\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"\n                            if(parent.frames[1].frames[2].document.forms[0].off_tel_no)\n                            parent.frames[1].frames[2].document.forms[0].off_tel_no.value =\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"\n                            if(parent.frames[1].frames[2].document.forms[0].res_tel_no)\n                            parent.frames[1].frames[2].document.forms[0].res_tel_no.value =\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" \n                            if(parent.frames[1].frames[2].document.forms[0].gender)\n                        {\n                            parent.frames[1].frames[2].document.forms[0].gender.value =\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" \n                            parent.frames[1].frames[2].document.forms[0].gender.disabled= true;\n                        }\n                      \n                        </script> \n                        ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n                   <script>\n                            if(parent.frames[1].frames[2].document.forms[0].lodger_name)\n                            parent.frames[1].frames[2].document.forms[0].lodger_name.readOnly= false;\n                            \n                            if(parent.frames[1].frames[2].document.forms[0].lodger_name)\n                            parent.frames[1].frames[2].document.forms[0].lodger_name.value =\"\" \n                            if(parent.frames[1].frames[2].document.forms[0].ln1_lodger_add)\n                            parent.frames[1].frames[2].document.forms[0].ln1_lodger_add.value =\"\" \n                            if(parent.frames[1].frames[2].document.forms[0].ln2_lodger_add)\n                            parent.frames[1].frames[2].document.forms[0].ln2_lodger_add.value =\"\" \n                            if(parent.frames[1].frames[2].document.forms[0].ln3_lodger_add)\n                            parent.frames[1].frames[2].document.forms[0].ln3_lodger_add.value =\"\" \n                            if(parent.frames[1].frames[2].document.forms[0].ln4_lodger_add)\n                            parent.frames[1].frames[2].document.forms[0].ln4_lodger_add.value =\"\"\n                            if(parent.frames[1].frames[2].document.forms[0].off_tel_no)\n                            parent.frames[1].frames[2].document.forms[0].off_tel_no.value =\"\"\n                            if(parent.frames[1].frames[2].document.forms[0].res_tel_no)\n                            parent.frames[1].frames[2].document.forms[0].res_tel_no.value =\"\" \n                            if(parent.frames[1].frames[2].document.forms[0].gender)\n                            parent.frames[1].frames[2].document.forms[0].gender.value =\"\" \n                            \n\t\t\t\tparent.frames[1].frames[2].document.forms[0].nursing_unit_desc.value=\'\';\n\t\t\t\tparent.frames[1].frames[2].document.forms[0].lodger_nursing_unit.value=\'\';\n\n                        </script> \n                    ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n                         <script>\n                            alert(getMessage(\'INVALID_PATIENT\',\'MP\'));\n                            \n                            if(parent.frames[1].frames[2].document.forms[0].lodger_name)\n                            parent.frames[1].frames[2].document.forms[0].lodger_name.readOnly= false;\n                            \n                            parent.frames[1].frames[2].document.forms[0].lodger_patient_id.focus();\n                            parent.frames[1].frames[2].document.forms[0].lodger_patient_id.select();\n\n                            if(parent.frames[1].frames[2].document.forms[0].lodger_name)\n                            parent.frames[1].frames[2].document.forms[0].lodger_name.value =\"\" \n                            if(parent.frames[1].frames[2].document.forms[0].ln1_lodger_add)\n                            parent.frames[1].frames[2].document.forms[0].ln1_lodger_add.value =\"\" \n                            if(parent.frames[1].frames[2].document.forms[0].ln2_lodger_add)\n                            parent.frames[1].frames[2].document.forms[0].ln2_lodger_add.value =\"\" \n                            if(parent.frames[1].frames[2].document.forms[0].ln3_lodger_add)\n                            parent.frames[1].frames[2].document.forms[0].ln3_lodger_add.value =\"\" \n                            if(parent.frames[1].frames[2].document.forms[0].ln4_lodger_add)\n                            parent.frames[1].frames[2].document.forms[0].ln4_lodger_add.value =\"\"\n                            if(parent.frames[1].frames[2].document.forms[0].off_tel_no)\n                            parent.frames[1].frames[2].document.forms[0].off_tel_no.value =\"\"\n                            if(parent.frames[1].frames[2].document.forms[0].res_tel_no)\n                            parent.frames[1].frames[2].document.forms[0].res_tel_no.value =\"\" \n                            if(parent.frames[1].frames[2].document.forms[0].gender)\n                            parent.frames[1].frames[2].document.forms[0].gender.value =\"\" \n                            \n                            parent.frames[1].frames[2].document.forms[0].nursing_unit_desc.value=\'\';\n                            parent.frames[1].frames[2].document.forms[0].lodger_nursing_unit.value=\'\';\n                            \n                        </script> \n                        \n                        ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n </body>\n</html> \n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
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
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	 request.setCharacterEncoding("UTF-8"); 
	Connection con = null;
	Statement stmt = null;
	ResultSet rs =null;
	Statement stmt1 = null;
	ResultSet rs1 =null;

	try
	{
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get("SEARCH") ;
        con = ConnectionManager.getConnection(request); 
        String encounter_id = request.getParameter( "encounter_id" ) ;
		if(encounter_id == null) encounter_id = "";
        String patient_id = request.getParameter( "patient_id" ) ;
		if(patient_id == null) patient_id = "";
        String facility_id = (String)  session.getValue ( "facility_id" ) ;
        String value = request.getParameter("value");
		if(value == null) value = "";

		if(encounter_id.equals("")) encounter_id  = (String) hash.get("encounter_id" ) ;
		if(patient_id.equals("")) patient_id =(String) hash.get("patient_id" ) ;
		if(value.equals("")) value =(String) hash.get("value");

        String sql = "";
		String str = "";
		int p_count = 0;
    
            _bw.write(_wl_block8Bytes, _wl_block8);

        if(value.equals("Patient"))
        {
            sql = "select nvl(patient_name,' ') patient_name ,nvl(ADDR1_LINE1,' ') resi_addr_line1,nvl(ADDR1_LINE2,' ') resi_addr_line2, nvl(ADDR1_LINE3,' ') resi_addr_line3, nvl(ADDR1_LINE4,' ') resi_addr_line4, nvl(CONTACT2_NO,' ') orn_tel_no, nvl(CONTACT1_NO,' ') prn_tel_no, sex , a.DECEASED_YN DECEASED_YN, a.SUSPEND_YN SUSPEND_YN ,a.ACTIVE_YN ACTIVE_YN FROM MP_PATIENT A ,MP_PAT_ADDRESSES B where A.patient_id='"+patient_id+"' and A.patient_id=B.patient_id ";
            
        boolean result = true;
            try
            {
                stmt = con.createStatement () ;
                rs = stmt.executeQuery( sql );
                if(rs!=null)
                {
                    if(rs.next())
                    {
                        if(rs.getString("DECEASED_YN").equals("Y")) {
                            result = false; 
							
							out.print("alert(getMessage('IP_DECEASED_NOT_ALLOWED','IP'));document.forms[0].lodger_patient_id.value=\"\";document.forms[0].lodger_patient_id.focus();");
                            }
                        if(result)
                        {
                            if(rs.getString("SUSPEND_YN").equals("Y")) {
                             result  = false;
                                
                                out.print("alert(getMessage('PAT_SUSPENDED_NOT_ALLOWED','MP'));document.forms[0].lodger_patient_id.value=\"\";document.forms[0].lodger_patient_id.focus();");
                            }
                        }

						if(result)
                        {
                            if(rs.getString("ACTIVE_YN").equals("N")) {
                             result  = false;
                                 out.print("alert(getMessage('PAT_INACTIVE_NOT_ALLOWED','MP'));document.forms[0].lodger_patient_id.value=\"\";document.forms[0].lodger_patient_id.focus();");
                            }
                        }

						if (result)
						{
							str= "select count(*) total from ip_open_encounter where facility_id='"+facility_id+"' and patient_id='"+patient_id+"' ";

							stmt1 = con.createStatement();
							rs1   = stmt1.executeQuery(str);

							while (rs1.next())
							{
								p_count = rs1.getInt("total");
							}

							if (p_count > 0)
							{
								result = false;
								
								out.print("alert(getMessage('CURRENTLY_IN_PATIENT','IP'));document.forms[0].lodger_patient_id.value=\"\";document.forms[0].lodger_patient_id.focus();");
							}
						}
						
						String patient_name =  rs.getString("patient_name");
						String resi_addr_line1 = rs.getString("resi_addr_line1");
						String resi_addr_line2 = rs.getString("resi_addr_line2");
						String resi_addr_line3 = rs.getString("resi_addr_line3");
						String resi_addr_line4 = rs.getString("resi_addr_line4");
						String orn_tel_no = rs.getString("orn_tel_no");
						String prn_tel_no = rs.getString("prn_tel_no");
						String sex = rs.getString("sex");
						
                        if(result)
                        {
							out.print("if(document.forms[0].lodger_name){document.forms[0].lodger_name.value ='"+patient_name+"'; document.forms[0].lodger_name.readOnly= true;}");
							out.print("if(document.forms[0].reln_with_patient) document.forms[0].reln_with_patient.focus(); else document.forms[0].ln1_lodger_add.focus();");
							out.print("if(document.forms[0].ln1_lodger_add) document.forms[0].ln1_lodger_add.value ='"+resi_addr_line1.trim()+"' ;");
							out.print("if(document.forms[0].ln2_lodger_add) document.forms[0].ln2_lodger_add.value ='"+resi_addr_line2.trim()+"' ;");
							out.print("if(document.forms[0].ln3_lodger_add) document.forms[0].ln3_lodger_add.value ='"+resi_addr_line3.trim()+"';");                             
							out.print("if(document.forms[0].ln4_lodger_add) document.forms[0].ln4_lodger_add.value ='"+resi_addr_line4.trim()+"';");
							out.print("if(document.forms[0].off_tel_no) document.forms[0].off_tel_no.value ='"+orn_tel_no.trim()+"'; ");
							out.print("if(document.forms[0].res_tel_no) document.forms[0].res_tel_no.value ='"+prn_tel_no.trim()+"' ;	");
							out.print("if(document.forms[0].gender){document.forms[0].gender.value ='"+sex+"' ; document.forms[0].gender.disabled= true;}");
						
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( rs.getString("patient_name")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( rs.getString("resi_addr_line1").trim()));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( rs.getString("resi_addr_line2").trim()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( rs.getString("resi_addr_line3").trim()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( rs.getString("resi_addr_line4").trim()));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( rs.getString("orn_tel_no").trim()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( rs.getString("prn_tel_no").trim()));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( rs.getString("sex")));
            _bw.write(_wl_block17Bytes, _wl_block17);

                        }
                        else
                        { 
							
							out.print("if(document.forms[0].lodger_name){document.forms[0].lodger_name.value =''; document.forms[0].lodger_name.readOnly= false;}");
							out.print("if(document.forms[0].ln1_lodger_add) document.forms[0].ln1_lodger_add.value ='' ;");
							out.print("if(document.forms[0].ln2_lodger_add) document.forms[0].ln2_lodger_add.value ='' ;");
							out.print("if(document.forms[0].ln3_lodger_add) document.forms[0].ln3_lodger_add.value ='';");                             
							out.print("if(document.forms[0].ln4_lodger_add) document.forms[0].ln4_lodger_add.value ='';");
							out.print("if(document.forms[0].off_tel_no) document.forms[0].off_tel_no.value =''; ");
							out.print("if(document.forms[0].res_tel_no) document.forms[0].res_tel_no.value ='' ;	");
							out.print("if(document.forms[0].gender){document.forms[0].gender.value ='' ;}");
							out.print("document.forms[0].nursing_unit_desc.value=''; document.forms[0].lodger_nursing_unit.value='';");
							
							
            _bw.write(_wl_block18Bytes, _wl_block18);
  }
                    }
                    else
                    {
						out.print("alert(getMessage('INVALID_PATIENT','MP'));document.forms[0].lodger_patient_id.value=\"\";document.forms[0].lodger_patient_id.focus();");
						out.print("if(document.forms[0].lodger_name){document.forms[0].lodger_name.value =''; document.forms[0].lodger_name.readOnly= false;}");
							out.print("document.forms[0].lodger_patient_id.focus(); document.forms[0].lodger_patient_id.select(); ");
							out.print("if(document.forms[0].ln2_lodger_add) document.forms[0].ln2_lodger_add.value ='' ;");
							out.print("if(document.forms[0].ln3_lodger_add) document.forms[0].ln3_lodger_add.value ='';");                             
							out.print("if(document.forms[0].ln4_lodger_add) document.forms[0].ln4_lodger_add.value ='';");
							out.print("if(document.forms[0].off_tel_no) document.forms[0].off_tel_no.value =''; ");
							out.print("if(document.forms[0].res_tel_no) document.forms[0].res_tel_no.value ='' ;	");
							out.print("if(document.forms[0].gender){document.forms[0].gender.value ='' ;}");
							out.print("document.forms[0].nursing_unit_desc.value=''; document.forms[0].lodger_nursing_unit.value='';");
                        
            _bw.write(_wl_block19Bytes, _wl_block19);
                      
                    }
                } //end of if rs!=null
            } // end of try
            catch (Exception e)
            {
                out.println(e.toString());
            }
            finally
            {
                if(stmt != null)    stmt.close() ; 
                if(rs != null)      rs.close ();
            }
        } // end of if value.equals("Patient")
        else
        {
            if(value.equals("Bed"))
            {
                String nursing_unit = request.getParameter("nursing_unit") ;
				if(nursing_unit == null) nursing_unit = "";
				if(nursing_unit.equals("")) nursing_unit =(String) hash.get("nursing_unit") ;
                String bed_no = request.getParameter("bed_no") ;
				if(bed_no == null) bed_no = "";
				if(bed_no.equals("")) bed_no =(String) hash.get("bed_no") ;

                sql = " select count(*) from ip_nursing_unit_bed where nursing_unit_code= '"+ nursing_unit +"' and bed_no = '"+ bed_no +"' and facility_id ='"+ facility_id +"'" ;
                try
                {
                    stmt = con.createStatement () ;
                    rs = stmt. executeQuery ( sql ) ;
                    if( rs != null )
                    {
                        if(rs.next())
                        {
                            if( rs.getInt(1) == 0 )
                            {
                                  
                                out.println ( "alert(parent.parent.frames[0].getMessage('INVALID_BED','Common'));parent.frames[1].frames[2].document.forms[0].lodger_bed_no.select();parent.frames[1].frames[2].document.forms[0].lodger_bed_no.focus();" ) ;   
                            }
                        }
                    }
                } //end of try
                catch (Exception e)
                {
                    out.println(e.toString());
                }
                finally
                {
                     if(stmt != null)   stmt.close() ; 
                    if(rs != null)      rs.close ();
                }
            } // end of if value.equals("Bed")
        } // end of else part of value.equals("Patient")
	}catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
    finally
    {
		if(stmt != null) stmt.close();
		if(rs != null) rs.close();
		if(stmt1 != null) stmt1.close();
		if(rs1 != null) rs1.close();

		ConnectionManager.returnConnection(con,request);
    }
    
            _bw.write(_wl_block20Bytes, _wl_block20);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
