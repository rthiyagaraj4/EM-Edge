package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __cheifcompalintdiagintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CheifCompalintDiagIntermediate.jsp", 1709115718699L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script language=\'javascript\' src=\'../js/ChiefComplaintDiag.js\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<input type=\'hidden\' name=complaint_id value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></input>\n<input type=\'hidden\' name=alpha value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></input>\n<input type=\'hidden\' name=term_set_id value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'></input>\n<input type=\'hidden\' name=from value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'></input>\n<input type=\'hidden\' name=to value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'></input>\n<input type=\'hidden\' name=start_end value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'></input>\n<input type=\'hidden\' name=id value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'></input>\n<input type=\'hidden\' name=count value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'></input>\n</form>\n</body>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n</html>\n\n\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet associateDiagBeannew= null;synchronized(session){
                associateDiagBeannew=(webbeans.eCommon.RecordSet)pageContext.getAttribute("associateDiagBeannew",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(associateDiagBeannew==null){
                    associateDiagBeannew=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("associateDiagBeannew",associateDiagBeannew,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCA.RecordDiagnosis RecordDiagnosisBeannew= null;synchronized(session){
                RecordDiagnosisBeannew=(eCA.RecordDiagnosis)pageContext.getAttribute("RecordDiagnosisBeannew",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(RecordDiagnosisBeannew==null){
                    RecordDiagnosisBeannew=new eCA.RecordDiagnosis();
                    pageContext.setAttribute("RecordDiagnosisBeannew",RecordDiagnosisBeannew,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
	
	Connection con = null;
	PreparedStatement stmt = null;
    ResultSet rs = null;
	//PreparedStatement stmt_desc = null;
   // ResultSet rs_desc = null;
	PreparedStatement stmt1 = null;
    ResultSet rs1 = null;
	try
	{	StringBuffer sql =new StringBuffer();
		//String sql_desc ="";
		//String diag_srl_no = "";
//		String diag_desc = "";
		//String diag_exists ="";
		String complaint_id = "";
		//String diag_code = "";
		String diag_codedesc = "";
		String alpha = "";

		int start = 0,end = 0,chkCounter = 0,addno = 0;

		String start_end = "";
		//String chkAttribute1="",strExistingSrlNos="";
		String term_code = "";
		String term_set_id = "";
		String term_set_descc= "";
		String diag_desc1 = "";
		String term_set_id1 = "";
		String term_set_desc1 = "";
		


		con	= ConnectionManager.getConnection();
		complaint_id = request.getParameter("complaint_id");
		alpha = request.getParameter("alpha")==null?"":request.getParameter("alpha");
		term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
		term_set_descc= request.getParameter("term_set_descc")==null?"":request.getParameter("term_set_descc");
		String id = request.getParameter("id")==null?"":request.getParameter("id");
		String searchWith = request.getParameter("searchWith")==null ? "" : request.getParameter("searchWith");
		
		start_end = request.getParameter("start_end")==null?"":request.getParameter("start_end");
		String from = request.getParameter( "from");
/*		String to = request.getParameter( "to");
		String mode = request.getParameter( "mode")==null?"":request.getParameter( "mode" ) ;
		//out.println("mode is :"+mode);
	String add = request.getParameter( "add")==null?"":request.getParameter( "add" ) ;
	
	int i=0;*/

		//PreparedStatement pstmtExisting = null;
		//ResultSet rsExisting = null;
		
		
		StringBuffer countsql = new StringBuffer();
		countsql.append("SELECT count(*) total FROM  MR_TERM_SET a,MR_TERM_CODE b WHERE a.EFF_STATUS='E' and a.term_set_id=b.term_set_id and a.term_set_id=? ");

		if(alpha==null || alpha.equals(""))
		{
				alpha = "%";
		}
		else if(searchWith.equals("S")){
			alpha = alpha.toUpperCase()+"%";
		}else if(searchWith .equals( "E")){
			alpha = "%"+alpha.toUpperCase();
		}else if(searchWith.equals( "C")){
			alpha = "%"+alpha.toUpperCase() +"%";
		}
		
		
		//String alpha1 = toUpperCase(alpha);
		if(!alpha.equals(""))
		{
			countsql.append(" AND UPPER (b.short_DESC) LIKE UPPER('"+alpha+"')");
		}
		//countsql.append(" ORDER BY 2 ");
		
		stmt1 = con.prepareStatement(countsql.toString());
		stmt1.setString(1,term_set_id);
		rs1 = stmt1.executeQuery();

		rs1.next();
		int maxRecord = rs1.getInt(1);

		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
		}

	if(rs1!=null) rs1.close();	 
	if(stmt1!=null) stmt1.close();
	
if(from==null){


		
		sql.append("SELECT a.TERM_SET_ID term_set_id ,b.TERM_CODE term_code,b.short_DESC term_desc,a.term_set_desc term_set_desc  FROM  MR_TERM_SET a,MR_TERM_CODE b WHERE a.EFF_STATUS='E' and a.term_set_id=b.term_set_id and a.term_set_id=?  ");
		 
		 
		if(!alpha.equals(""))
		{
			sql.append(" AND UPPER (b.short_DESC) LIKE UPPER('"+alpha+"')");
			sql.append(" ORDER BY 2 ");
		}
		stmt = con.prepareStatement(sql.toString());
		stmt.setString(1,term_set_id);
	
		rs = stmt.executeQuery();
		associateDiagBeannew.clearAll();
	
		while(rs.next())
		{
			term_set_id1 = rs.getString("term_set_id");
			term_code = rs.getString("term_code");
			diag_desc1 = rs.getString("term_desc");
			term_set_desc1 = rs.getString("term_set_desc");

			
				if(term_set_id1 == null)
				term_set_id1 ="";  
			
			
			if(diag_desc1 == null)
				diag_desc1 ="";
			
			if(term_code == null)
				term_code ="";
			if(term_set_desc1 == null)
				term_set_desc1 ="";
			
			diag_codedesc = diag_desc1+"~"+term_code+"~"+term_set_id1+"~"+term_set_desc1;

			associateDiagBeannew.putObject(term_set_id1);
			associateDiagBeannew.putObject(diag_codedesc);
			//out.println(associateDiagBeannew.putObject(term_set_id1));
			//out.println(associateDiagBeannew.putObject(diag_codedesc));
			//out.println("term_set_id1"+term_set_id1+"<br>");
			//out.println("diag_codedesc"+diag_codedesc);
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();

		
	
}


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(complaint_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(alpha));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(start));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(end));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(addno));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(chkCounter));
            _bw.write(_wl_block15Bytes, _wl_block15);
	
	}
			catch(Exception e)
			{
				e.printStackTrace() ;
			}
			finally
			{	
					if(stmt1!=null) stmt1.close();
					if(rs1!=null) rs1.close();
					if(con!=null)ConnectionManager.returnConnection(con,request);
			}	

            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
