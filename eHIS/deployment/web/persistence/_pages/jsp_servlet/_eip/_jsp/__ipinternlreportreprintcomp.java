package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import ecis.utils.*;
import webbeans.eCommon.ConnectionManager;;

public final class __ipinternlreportreprintcomp extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IpinternlReportReprintComp.jsp", 1709117781510L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n    <head>\n        <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n        <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n        <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n          <script>\n            function submitPage()\n\t\t\t{\n\t\t\t\tdocument.forms[0].submit();\n\t\t\t}\n\t\t\tfunction closewin()\n            {\n                parent.window.returnValue=\'agn\'\n                parent.window.close()\n            }\n\t\t\tfunction checkCopy(obj,rowNum)\n\t\t\t{\n\t\t\t\tif(!obj.checked)\n\t\t\t\t{\n\t\t\t\t\tvar num=\"document.Report_Form.numofcopies\"+rowNum;\n\t\t\t\t\teval(num).value=\'\';\n\t\t\t\t\teval(num).readOnly=true;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tvar num=\"document.Report_Form.numofcopies\"+rowNum;\n\t\t\t\t\teval(num).readOnly=false;\n\t\t\t\t}\n\t\t\t}\n        </script>\n        ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n        </head>\n\n        <body onMouseDown=\'CodeArrest()\' onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n        <br>\n        <br>\n            <form name=\'Report_Form\' id=\'Report_Form\' action=\'IpinternlReportReprintComp.jsp\'>\n                <table border=\"1\" width=\"102%\" cellspacing=\'0\' cellpadding=\'0\'>\n                \n                <tr>\n                    <th width=\'50%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n                    <th>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n                </tr>\n                ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n                                <tr>\n                                    <td class=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' >\n                                        <input type=\'hidden\' name=\'report_id";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' id=\'report_id";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'module_id";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' id=\'module_id";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n                                        ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n                                    </td>\n                                    <td class=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' align=\'center\'>\n                                        <input type=\'checkbox\' name=\'reportchk";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' id=\'reportchk";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' value=\'Y\' CHECKED onclick=\'checkCopy(this,";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =")\'>\n                                    </td>   \n                                    <td class=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' align=\'center\'>\n                                        <input type=\'text\' name=\'numofcopies";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' id=\'numofcopies";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' size=4 maxlength=4 onKeyPress=\'return allowValidNumber(this,event,4,0);\' onblur=\'CheckNum(this)\'>\n                                    </td>                                   \n                                </tr>\n                 ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' value=\'1\' size=4 maxlength=4 onblur=\'CheckNum(this)\' OnKeyPress=\'\t\t\t\treturn allowValidNumber(this,event,4,0);\'>\n                                    </td>                                   \n                                </tr>\n                 ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n                </table>\n                <table border=\"0\" width=\"102%\" cellspacing=\'0\' cellpadding=\'0\'>\n                <tr>\n                    <td class=\'white\' colspan=2>&nbsp</td>\n                </tr>\n                <tr>\n                    <td align=\'right\' width=\'50%\' class=\'white\'>\n                        <input type=\'button\' name=\'ok\' id=\'ok\' onClick=\'submitPage();alert(getMessage(\"REPORT_SUBMIT_SERVER\",\"common\"));parent.window.close();\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' class=\'button\'>\n                    </td>\n                    <td align=\'left\' width=\'50%\' class=\'white\'>&nbsp&nbsp\n                        <input type=\'button\' name=\'cancel\' id=\'cancel\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' class=\'button\' onclick=\'closewin()\'>\n                    </td>\n                </tr>\n                </table>\n                <input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'print\'>\n                <input type=\'hidden\' name=\'total\' id=\'total\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n                <input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n                <input type=\'hidden\' name=\'p_clinic_code\' id=\'p_clinic_code\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n                <input type=\'hidden\' name=\'p_clinic_type\' id=\'p_clinic_type\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n                <input type=\'hidden\' name=\'p_patient_id\' id=\'p_patient_id\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'gen_file_no\' id=\'gen_file_no\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'print_yn\' id=\'print_yn\' value=\'Y\'>\n                \n                </form>\n            ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n    </body>\n</html>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

			request.setCharacterEncoding("UTF-8");
            Connection con = null;
            PreparedStatement pstmt=null;
            ResultSet rset=null ;
            String facility_id=(String)session.getValue("facility_id");
            String mode=request.getParameter("mode");

            String encounter_id=request.getParameter("encounter_id");
			String print_yn = request.getParameter("print_yn");
			if (print_yn==null || print_yn== "" || print_yn.equals("")) 
			print_yn="N";	
            StringBuffer sql=new StringBuffer();
            String p_clinic_code = "" ;
            String p_clinic_type = "" ; 
            String p_patient_id = "" ;

			//Added by kumar for calling MP Reports if file is created at the time of visit Registration
			String pat_ser_grp_code = "";
			String inhouse_birth_yn = "";
			String gen_file_no = request.getParameter("gen_file_no");
			if (gen_file_no==null || gen_file_no.equals("undefined")) gen_file_no = "";
			
			String file_created_at_regn_yn = request.getParameter("file_created_at_regn_yn");
			if (file_created_at_regn_yn==null) file_created_at_regn_yn = "N";

			String column_name = request.getParameter("column_name");
			if (column_name==null || column_name.equals("undefined")) column_name = "";
			String nursing_unit_code = request.getParameter("nursing_unit_code");
			if (nursing_unit_code==null || nursing_unit_code.equals("undefined")) nursing_unit_code = "";
            int i=1;
        try{  
			con = ConnectionManager.getConnection(request);
			if(mode.equals("view"))
            {
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" select ASSIGN_CARE_LOCN_TYPE,ASSIGN_CARE_LOCN_CODE,patient_id from PR_ENCOUNTER where facility_id = '"+facility_id+"' and encounter_id="+encounter_id+" ");
				pstmt = con.prepareStatement(sql.toString());
				rset      = pstmt.executeQuery();
				if(rset.next())
				{
					p_clinic_code = rset.getString("ASSIGN_CARE_LOCN_CODE") ;
					p_clinic_type = rset.getString("ASSIGN_CARE_LOCN_TYPE") ;
					p_patient_id = rset.getString("patient_id") ;
				}
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				
		if(print_yn.equals("N"))		 
		  {
				//  Only for Print Admission Patient
				 if (file_created_at_regn_yn.equals("Y"))
				 {
					 if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("select pat_ser_grp_code, inhouse_birth_yn from mp_patient where patient_id=? ");
					 pstmt = con.prepareStatement(sql.toString());
					 pstmt.setString(1, p_patient_id);
					 rset = pstmt.executeQuery();
					 if (rset != null && rset.next())
					 {
						pat_ser_grp_code = rset.getString(1);
						inhouse_birth_yn = rset.getString(2);
						if(rset!=null) rset.close();
						if(pstmt!=null) pstmt.close();
					 }					 					 
					 if (inhouse_birth_yn.equals("Y"))
					 {
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append(" select report_id, report_desc, no_of_copies, orderby, module_id from (select distinct A.report_id,B.report_desc, 1 no_of_copies, 1 orderby, b.module_id from mp_online_reports A, sm_report B, sm_print_routing c where A.pat_ser_grp_code = '"+pat_ser_grp_code+"' and A.print_reqd_yn='Y' and B.report_id=A.report_id and a.report_id = c.report_id (+) and NVL(c.facility_id,'"+facility_id+"') = '"+facility_id+"' and A.report_id in ('MPBNBFRM', 'MPBWBLBL') union select a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, 2 orderby, a.module_id  module_id from IP_ONLINE_REPORT a, SM_REPORT b  where  a.module_id = 'IP' and b.internal_request_yn='Y' and a.facility_id='"+facility_id+"' and a.PRINT_ON_ADMISSION_YN='Y' and a.NURSING_UNIT_CODE ='"+nursing_unit_code+"' and a.report_id = b.report_id) ORDER BY 4,2 ");
					 }
					 else
					 {
					   	if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append("select report_id, report_desc, no_of_copies, orderby, module_id from (select distinct A.report_id,B.report_desc, 1 no_of_copies, 1 orderby, b.module_id from mp_online_reports A, sm_report B, sm_print_routing c where A.pat_ser_grp_code = '"+pat_ser_grp_code+"' and A.print_reqd_yn='Y' and B.report_id=A.report_id and a.report_id = c.report_id (+) and NVL(c.facility_id,'"+facility_id+"') = '"+facility_id+"' and A.report_id not in ('MPBNBFRM', 'MPBWBLBL') union select a.report_id report_id, b.report_desc report_desc, 1 no_of_copies, 2 orderby, a.module_id  module_id from IP_ONLINE_REPORT a, SM_REPORT b  where  a.module_id = 'IP' and b.internal_request_yn='Y' and a.facility_id='"+facility_id+"' and a.PRINT_ON_ADMISSION_YN='Y' and a.NURSING_UNIT_CODE ='"+nursing_unit_code+"' and a.report_id = b.report_id) ORDER BY 4,2 ");
					 }

				 }
                 else
				 {
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" select report_id, report_desc, 1 no_of_copies, module_id from ");
		            sql.append("sm_report where internal_request_yn='Y' and ");
			        sql.append("module_id = 'IP' ");
				    sql.append("order by 2");
		
				 }
			}
			else  
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" select a.REPORT_ID REPORT_ID, b.REPORT_DESC REPORT_DESC, a.MODULE_ID MODULE_ID from IP_ONLINE_REPORT a, SM_REPORT b ");
				sql.append(" where a.module_id='IP' and a.facility_id='"+facility_id+"' and  ");
				sql.append(" a."+column_name+"='Y' and a.NURSING_UNIT_CODE ='"+nursing_unit_code+"' ");
				sql.append(" and a.report_id = b.report_id");
			}
				out.println(sql.toString());
			 try
			 {
				pstmt = con.prepareStatement(sql.toString());
				rset      = pstmt.executeQuery();
			 }
			 catch(Exception e) { out.println(e.toString());}

            
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

                    String cellclass="QRYEVEN";
          if(print_yn.equals("N"))		 
		  {
                    try
                    {
                        if(rset!=null)
                        {
                            while(rset.next())
                            {
                                if(cellclass.equals("QRYEVEN"))
                                    cellclass="QRYODD";
                                else
                                        cellclass="QRYEVEN";
                 
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(cellclass));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rset.getString("report_id")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rset.getString("module_id")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rset.getString("report_desc")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cellclass));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(cellclass));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rset.getString("no_of_copies")));
            _bw.write(_wl_block25Bytes, _wl_block25);

                                i++;
                            }
						if(rset!=null) rset.close();
						if(pstmt!=null) pstmt.close();
                        }
                    }
                    catch(Exception e){out.print(e);}
		  }
		else  // for print_yn='Y'
			{
                    try
                    {
                        if(rset!=null)
                        {
                            while(rset.next())
                            {
								if(cellclass.equals("QRYEVEN"))
                                    cellclass="QRYODD";
                                else
                                        cellclass="QRYEVEN";
                 
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(cellclass));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rset.getString("report_id")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rset.getString("module_id")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rset.getString("REPORT_DESC")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cellclass));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(cellclass));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);

                                i++;
                            }
						if(rset!=null) rset.close();
						if(pstmt!=null) pstmt.close();
                        }
                    }
                    catch(Exception e){out.print(e);}
			}
                
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i-1));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(p_clinic_code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(p_clinic_type));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(gen_file_no));
            _bw.write(_wl_block35Bytes, _wl_block35);

                }       
                else
                {
     
                p_clinic_code = request.getParameter("p_clinic_code") ;
                p_clinic_type =request.getParameter("p_clinic_type");
                p_patient_id = request.getParameter("p_patient_id");
                    if(mode.equals("print"))
                    {
                        out.print("<script>parent.frames[0].location.href='../../eCommon/html/blank.html'</script>");
                        int total=Integer.parseInt(request.getParameter("total"));
                        ecis.utils.OnlineReports onlineReports  = new ecis.utils.OnlineReports() ;
                            
                         String ReportOutput  = "" ;
                        while(i<=total)
                        {
                            String rs_report_id=request.getParameter("report_id"+String.valueOf(i));
							String rs_module_id=request.getParameter("module_id"+String.valueOf(i));
                            String numofcopies=request.getParameter("numofcopies"+String.valueOf(i));
                            String chkval=  request.getParameter("reportchk"+String.valueOf(i));
                            if (rs_report_id==null) rs_report_id = "";
                            if (numofcopies==null) numofcopies = "";
							if (rs_module_id==null) rs_module_id = "";

                            if(chkval!=null)
                            {
                                if(chkval.equals("Y"))
                                {
                                    ecis.utils.OnlineReport report1 = new ecis.utils.OnlineReport( facility_id, rs_module_id, rs_report_id, p_clinic_type, p_clinic_code ) ;
                                   
                                    report1.addParameter( "p_facility_id",  facility_id ) ;
                                    report1.addParameter( "p_encounter_id",encounter_id) ;
                                    report1.addParameter( "p_copies",   numofcopies ) ; 
                                    
                                    report1.addParameter( "p_clinic_code",p_clinic_code);
                                    report1.addParameter( "p_clinic_type",p_clinic_type);
                                    report1.addParameter( "p_patient_id",p_patient_id);
                                    report1.addParameter( "p_report_id",rs_report_id);
									report1.addParameter( "p_module_id",rs_module_id);
									report1.addParameter( "p_file_no",	gen_file_no ) ;
									onlineReports.add( report1) ;
                                }
                            }
                            i++;
                        }
                        session.putValue( "online_reports", onlineReports ) ;

                        
                           ReportOutput = onlineReports.execute( request, response );
                        if ( ReportOutput.length() > 0 )
                                out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' ><br>"+ReportOutput+"<center><input type='button' type='Button' name ='ok' value='   Ok   ' class='Button' onclick='parent.parent.window.close()'></center></body></html>");
                        else if ( ReportOutput.length() == 0 )
                        {
                                out.println("<html> <head> <link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link> </head> <body onKeyDown='lockKey()'> <center><br><script>getMessage('REPORT_GENERATED','SM')</script><br> <form> <input type='Button' name='ok' id='ok' value='   Ok   ' class='Button' onclick='closewin()'> </center></form>   </body> </html>");
                        }
                       
                    }
                }
              if (rset      != null)    rset.close();
			  if (pstmt != null)    pstmt.close();
			}catch(Exception e) { out.println(e.toString());}
            finally 
			{
              if(con!=null) ConnectionManager.returnConnection(con,request);  
            }

            
            _bw.write(_wl_block36Bytes, _wl_block36);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reportname.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.required.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.copies.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }
}
