package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __aeinternlreportreprintcomp extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEInternlReportReprintComp.jsp", 1709113834194L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\nfunction closewin()  {\n\tparent.window.returnValue=\'agn\' \n    parent.window.close()\n}\n</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</head>\n\n<body onKeyDown = \'lockKey()\'>\n<br><br>\n<form name=\'Report_Form\' id=\'Report_Form\' action=\'AEInternlReportReprintComp.jsp\'>\n<table border=\"1\" width=\"102%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t<tr>\n\t\t<th width=50%>Report Name </th>\n        <th>Reqd</th>\n        <th>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n    </tr>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<tr>\n\t\t<td class=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' >\n\t\t\t<input type=\'hidden\' name=\'report_id";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' id=\'report_id";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t<input type=\'hidden\' name=\'module_id";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' id=\'module_id";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n                      ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" \n\t\t</td>\n        <td class=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' align=\'center\'>\n\t\t\t<input type=\'checkbox\' name=\'reportchk";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' id=\'reportchk";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' value=\'Y\' CHECKED>\n         </td>   \n         <td class=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' align=\'center\'>\n\t\t\t<input type=\'text\' name=\'numofcopies";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' id=\'numofcopies";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' size=4 maxlength=4 onblur=\'CheckNum(this)\'>\n        </td>                                   \n    </tr>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n</table>\n\n<table border=\"0\" width=\"102%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t<tr>  <td class=\'white\' colspan=2>&nbsp</td> </tr>\n     <tr>\n\t\t<td align=\'right\' width=\'50%\' class=\'white\'>\n\t\t\t<input type=\'submit\' name=\'ok\' id=\'ok\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' class=\'button\'>\n        </td>\n        <td align=\'left\' width=\'50%\' class=\'white\'>&nbsp&nbsp\n\t\t\t<input type=\'button\' name=\'cancel\' id=\'cancel\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' class=\'button\' onclick=\'closewin()\'>\n        </td>\n    </tr>\n</table>\n\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'print\'>\n<input type=\'hidden\' name=\'total\' id=\'total\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n<input type=\'hidden\' name=\'p_clinic_code\' id=\'p_clinic_code\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n<input type=\'hidden\' name=\'p_clinic_type\' id=\'p_clinic_type\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n<input type=\'hidden\' name=\'p_patient_id\' id=\'p_patient_id\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n<input type=\'hidden\' name=\'gen_file_no\' id=\'gen_file_no\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n                \n</form>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	Connection con = null;
    PreparedStatement pstmt=null;
    ResultSet rset=null ;
    String facility_id=(String)session.getValue("facility_id");
    String mode=request.getParameter("mode");
    String encounter_id=request.getParameter("encounter_id");
    String sql="";
    String p_clinic_code = "" ;
    String p_clinic_type = "" ; 
    String p_patient_id = "" ;
	ecis.utils.OnlineReports onlineReports  = new ecis.utils.OnlineReports() ;
	ecis.utils.OnlineReport report1 = null;

	String pat_ser_grp_code = "";
	String inhouse_birth_yn = "";
	String gen_file_no = request.getParameter("gen_file_no");
	if (gen_file_no==null || gen_file_no.equals("undefined")) gen_file_no = "";

	String file_created_at_regn_yn = request.getParameter("file_created_at_regn_yn");
	if (file_created_at_regn_yn==null) file_created_at_regn_yn = "N";

    int i=1;

    try{    
		con = ConnectionManager.getConnection(request);
		if(mode.equals("view")) {
			sql = "select ASSIGN_CARE_LOCN_TYPE,ASSIGN_CARE_LOCN_CODE,patient_id from pr_encounter where facility_id = ? and encounter_id= ? ";
            pstmt = con.prepareStatement(sql);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, encounter_id);
            rset      = pstmt.executeQuery();
            if(rset.next()) {
				p_clinic_code = rset.getString("ASSIGN_CARE_LOCN_CODE") ;
                p_clinic_type = rset.getString("ASSIGN_CARE_LOCN_TYPE") ;
                p_patient_id = rset.getString("patient_id") ;
            } 
			pstmt.close();rset.close();
            	
				
			if (file_created_at_regn_yn.equals("Y")) {
				sql = "select pat_ser_grp_code, inhouse_birth_yn from mp_patient where patient_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, p_patient_id);
				rset = pstmt.executeQuery();
				if (rset.next())  {
					pat_ser_grp_code = rset.getString(1);
					inhouse_birth_yn = rset.getString(2);
				}
				if(pstmt!=null) pstmt.close();
				if(rset!=null) rset.close();

				if (inhouse_birth_yn.equals("Y")) {
					sql = "select report_id, report_desc, no_of_copies, orderby, module_id from (select distinct A.report_id,B.report_desc, 1 no_of_copies, 1 orderby, b.module_id from mp_online_reports A, sm_report B, sm_print_routing c where A.pat_ser_grp_code = '"+pat_ser_grp_code+"' and A.print_reqd_yn='Y' and B.report_id=A.report_id and a.report_id = c.report_id (+) and NVL(c.facility_id,'"+facility_id+"') = '"+facility_id+"' and A.report_id in ('MPBNBFRM', 'MPBWBLBL') and b.report_id <> 'OPRECNTR' union select report_id, report_desc, 1 no_of_copies, 2 orderby, module_id  from sm_report where internal_request_yn='Y' and module_id in ('OP','AE')) ORDER BY 4,2 ";
			    }  else  {
					sql = "select report_id, report_desc, no_of_copies, orderby, module_id from (select distinct A.report_id,B.report_desc, 1 no_of_copies, 1 orderby, b.module_id from mp_online_reports A, sm_report B, sm_print_routing c where A.pat_ser_grp_code = '"+pat_ser_grp_code+"' and A.print_reqd_yn='Y' and B.report_id=A.report_id and a.report_id = c.report_id (+) and NVL(c.facility_id,'"+facility_id+"') = '"+facility_id+"' and A.report_id not in ('MPBNBFRM', 'MPBWBLBL') and b.report_id <> 'OPRECNTR' union select report_id, report_desc, 1 no_of_copies, 2 orderby, module_id  from sm_report where internal_request_yn='Y' and module_id in ('OP','AE')) ORDER BY 4,2 ";
				}
			} else {
				sql="select report_id, report_desc, 1 no_of_copies, module_id from "+
		                 "sm_report where internal_request_yn='Y' and "+
			             "module_id in ('OP','AE') and report_id <> 'OPRECNTR'"+
				          "order by 2";
			}
            try {
				pstmt = con.prepareStatement(sql);
				rset      = pstmt.executeQuery();
           } catch(Exception e) { }
		   finally {
				if(pstmt!=null) pstmt.close();
				if(rset!=null) rset.close();
			}


            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

	String cellclass="QRYEVEN";
    try {
		if(rset!=null) {
			while(rset.next()) {
				if(cellclass.equals("QRYEVEN"))
					cellclass="QRYODD";
                else
					cellclass="QRYEVEN";

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(cellclass));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rset.getString("report_id")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rset.getString("module_id")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rset.getString("report_desc")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(cellclass));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(cellclass));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rset.getString("no_of_copies")));
            _bw.write(_wl_block23Bytes, _wl_block23);

				i++;
            }
        }
    } catch(Exception e){/* out.print(e); */ e.printStackTrace();}

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i-1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(p_clinic_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p_clinic_type));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(gen_file_no));
            _bw.write(_wl_block32Bytes, _wl_block32);

        }  else {
			p_clinic_code = request.getParameter("p_clinic_code") ;
            p_clinic_type =request.getParameter("p_clinic_type");
            p_patient_id = request.getParameter("p_patient_id");
            if(mode.equals("print")) {
				out.print("<script>parent.frames[0].location.href='../../eCommon/html/blank.html'</script>");
                int total=Integer.parseInt(request.getParameter("total"));
                String ReportOutput  = "" ;
                while(i<=total) {
					String rs_report_id=request.getParameter("report_id"+String.valueOf(i));
					String rs_module_id=request.getParameter("module_id"+String.valueOf(i));
                    String numofcopies=request.getParameter("numofcopies"+String.valueOf(i));
                    String chkval=  request.getParameter("reportchk"+String.valueOf(i));
                    if (rs_report_id==null) rs_report_id = "";
                    if (numofcopies==null) numofcopies = "";
					if (rs_module_id==null) rs_module_id = "";

                    if(chkval!=null &&chkval.equals("Y"))  {
						report1 = new ecis.utils.OnlineReport( facility_id, rs_module_id, rs_report_id, p_clinic_type, p_clinic_code ) ;
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
                    i++;
                }
                session.putValue( "online_reports", onlineReports ) ;
                       
                ReportOutput = onlineReports.execute( request, response );
						
                if ( ReportOutput.length() > 0 )
				{
					out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/'"+sStyle+"'></link></head><body onKeyDown = 'lockKey()'><br>"+ReportOutput+"<center><input type='button' type='Button' name ='ok' value='   OK   ' class='Button' onclick='parent.parent.window.close()'></center></body></html>");
				}
                else if ( ReportOutput.length() == 0 ) {
					out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/'"+sStyle+"'></link><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head> <body onKeyDown = 'lockKey()'> <center><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"REPORT_GENERATED","sm_messages")+"<br><form><input type='Button' name='ok' id='ok' value='   OK   ' class='Button' onclick='closewin()'> </center></form>   </body> </html>");
                }
			}
        }
    } catch(Exception e) { }
    finally {
	    if (pstmt != null)    pstmt.close();
        if (rset      != null)    rset.close();
        if(con!=null) ConnectionManager.returnConnection(con,request);  
    }

            _bw.write(_wl_block33Bytes, _wl_block33);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.copies.label", java.lang.String .class,"key"));
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
}
