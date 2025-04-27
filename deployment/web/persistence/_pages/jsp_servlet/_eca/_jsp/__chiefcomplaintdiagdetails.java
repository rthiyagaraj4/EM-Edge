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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __chiefcomplaintdiagdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChiefComplaintDiagDetails.jsp", 1709115720449L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<!-- ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<!-- Added by Arvind @ 07-12-08 -->\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script language=\'javascript\' src=\'../js/ChiefComplaintDiag.js\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"ChiefComplaintDiagDetailsfrm\" id=\"ChiefComplaintDiagDetailsfrm\"  method=\"post\" action=\"../../eCA/jsp/ChiefComplaintDiagDetails.jsp\" >\n<table cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'center\'>\n<tr> <td class=\'white\' width=\'88%\'></td> \n\t<td  align=\'right\' width=\'12%\' nowrap>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<a class=\'gridLink\' href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =",";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</a>\n\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<a class=\'gridLink\'  href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =")\' text-decoration=\'none\'>&nbsp;";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a>\n\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n</td></tr>\n</table>\n\n<table class=\'grid\'  border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' align=\'center\'>\n\t<td  class=\'COLUMNHEADERCENTER\' width=\'30%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t<td  class=\'COLUMNHEADERCENTER\' width=\'30%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t<td  class=\'COLUMNHEADERCENTER\' width=\'10%\' >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td> \n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\n</table>\n\n<input type=\'hidden\' name=complaint_id value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'></input>\n<input type=\'hidden\' name=alpha value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'></input>\n<input type=\'hidden\' name=term_set_id value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'></input>\n<input type=\'hidden\' name=from value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'></input>\n<input type=\'hidden\' name=to value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'></input>\n<input type=\'hidden\' name=start_end value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'></input>\n<input type=\'hidden\' name=id value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'></input>\n<input type=\'hidden\' name=count value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'></input>\n\n</form>\n</body>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\n</html>\n\n\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
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


/*webbeans.eCommon.RecordSet associateDiagBean = (webbeans.eCommon.RecordSet)getObjectFromBean("associateDiagBean","webbeans.eCommon.RecordSet",session); 
	

	eCA.RecordDiagnosis RecordDiagnosisBean = (eCA.RecordDiagnosis)getObjectFromBean("RecordDiagnosisBean","eCA.RecordDiagnosis",session); */

            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
	
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
		String diag_desc = "";
		//String diag_exists ="";
		String complaint_id = "";
		//String diag_code = "";
		//String diag_codedesc = "";
		String alpha = "";

		int start = 0,end = 0,chkCounter = 0,addno = 0;
		//int start1 = 0,end1 = 0;

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
		String to = request.getParameter( "to");
		//String mode = request.getParameter( "mode")==null?"":request.getParameter( "mode" ) ;
		//out.println("mode is :"+mode);
		//String add = request.getParameter( "add")==null?"":request.getParameter( "add" ) ;
		int maxRecord =0;

		if ( from == null )
			start = 1;
		else
			start = Integer.parseInt(from);
		if ( to == null )
	  		end = 13 ;
		else
			end = Integer.parseInt( to ) ;
	
	     //start1       =   start;
	     //end1         =  end;

	     int i=0;

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
		maxRecord = rs1.getInt(1);

		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
		}

	if(rs1!=null) rs1.close();	 
	if(stmt1!=null) stmt1.close();
	
//if(from==null){


		//sql.append( "SELECT A.DIAG_SRL_NO, A.SHORT_DESC DIAG_DESC, A.DIAG_CODE DIAG_CODE, NVL ((SELECT 1 FROM CA_CHIEF_COMPLAINT_DIAG WHERE DIAG_SRL_NO=A.DIAG_SRL_NO AND COMPLAINT_ID=?),'0') DIAG_EXISTS FROM MR_ICD_CODE A WHERE A.DIAG_CODE_SCHEME=(SELECT DIAG_CODE_SCHEME FROM mr_parameter)");

		//sql.append( "select a.TERM_SET_ID, b.TERM_CODE,b.short_DESC FROM  MR_TERM_SET a,MR_TERM_CODE b,CA_CHIEF_COMP_TERM_CODE c WHERE c.complaint_id=? and b.term_set_id=c.term_set_id and c.term_code=b.term_code and a.EFF_STATUS='E' and a.term_set_id=b.term_set_id ");


		sql.append("SELECT a.TERM_SET_ID term_set_id ,b.TERM_CODE term_code,b.short_DESC term_desc,a.term_set_desc term_set_desc  FROM  MR_TERM_SET a,MR_TERM_CODE b WHERE a.EFF_STATUS='E' and a.term_set_id=b.term_set_id and a.term_set_id=?  ");
		 
		 
		if(!alpha.equals(""))
		{
			sql.append(" AND UPPER (b.short_DESC) LIKE UPPER('"+alpha+"')");
			sql.append(" ORDER BY 2 ");
		}
		stmt = con.prepareStatement(sql.toString());
		stmt.setString(1,term_set_id);
	
		rs = stmt.executeQuery();
		//associateDiagBeannew.clearAll();
	
		/*while(rs.next())
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

			//associateDiagBeannew.putObject(term_set_id1);
			//associateDiagBeannew.putObject(diag_codedesc);
			//out.println(associateDiagBeannew.putObject(term_set_id1));
			//out.println(associateDiagBeannew.putObject(diag_codedesc));
			//out.println("term_set_id1"+term_set_id1+"<br>");
			//out.println("diag_codedesc"+diag_codedesc);
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();*/

		
	
//}

            _bw.write(_wl_block9Bytes, _wl_block9);

		if ( !(start <= 1)) {
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((start-14)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((end-14)));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

		}
		if ( !((start+14) > maxRecord )){
	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((start+14)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((end+14)));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

		}
	
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
	
if ( start != 1 )
{
	for( int j=1; j<start; i++,j++ )
	   {
		 rs.next() ;
	   }
}
String classValue ="gridData";
String chkAttribute ="";		
String chkval = "";
String icd_code1 = "";
String icd_desc1 = "";
String icd_termdesc = "";
String icd_termid = "";
//String term_set_desc = "";

ArrayList record = RecordDiagnosisBeannew.getAllRecord(); 
//out.println("<script>alert('sizein second"+record.size()+"')</script>");


//if(end1>maxRecord)		//if it exceeds the maxrecord
	//end1=maxRecord;
	//int j=0;
	
 while(rs!=null && rs.next() && i<=end)
{
		
	//diag_srl_no = (String)associateDiagBeannew.getObject(j);
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
			
	diag_desc = diag_desc1+"~"+term_code+"~"+term_set_id1+"~"+term_set_desc1;

	//	j=j+1;
	//diag_desc = (String)associateDiagBeannew.getObject(j);
	
	String desc="";
	String desc1="";
	String desc2="";
	String termdesc2="";
	
	StringTokenizer st1 = new StringTokenizer(diag_desc,"~");
	while(st1.hasMoreTokens())
	{
			icd_desc1    = st1.nextToken();
			icd_code1    = st1.nextToken();
			icd_termid   = st1.nextToken();
			icd_termdesc   = st1.nextToken();
	}	

	if(!(icd_termid==null && icd_code1==null && icd_desc1==null)){

	String recordval = "",key = "";;
	for(int k=0;k<record.size();k++)
	{
		recordval =(String)record.get(k);

		StringTokenizer st = new StringTokenizer(recordval,"~");
		while(st.hasMoreTokens())
		{
			key = st.nextToken();
			desc = st.nextToken();
			desc1 = st.nextToken();
			desc2 = st.nextToken();
			termdesc2 = st.nextToken();

			if(icd_code1.equals(key)){
				chkAttribute="checked";
				k=record.size();	
				}
			else
				chkAttribute="";
		}
	}	
			chkval = icd_termid+"~"+icd_desc1+"~"+icd_code1+"~"+icd_termdesc;
			if ( i % 2 == 0 )
            classValue = "gridData" ;
            else
            classValue = "gridData" ;
			/*sql_desc="SELECT TERM_SET_desc term_set_desc FROM  MR_TERM_SET where term_set_id=?";
		 
		stmt_desc = con.prepareStatement(sql_desc);
		stmt_desc.setString(1,icd_termid);
			
		rs_desc = stmt_desc.executeQuery();
			
		while(rs_desc.next())
		{
			term_set_desc = rs_desc.getString("term_set_desc");
			
		}
		if(rs_desc!=null) rs_desc.close();
		if(stmt_desc!=null) stmt_desc.close();*/
						
			out.println("<tr><td class='" + classValue + "'>"+icd_termdesc+"</td>");
			out.println("<td class='" + classValue + "'>"+icd_code1+"</td>");
			out.println("<td class='" + classValue + "'>"+icd_desc1+"</td>");
			out.println("<td class='"+classValue+"' ><input type='checkbox'  "+chkAttribute +"  name='diag_exists"+chkCounter+"' id='diag_exists"+chkCounter+"'  value='"+chkval+"' onClick='CheckVal(this)'>");
			out.println("<input type='hidden'  name='chk_value"+chkCounter+"' id='chk_value"+chkCounter+"'  value='"+icd_code1+"' >");
			out.println("</td></tr>"); 
			chkCounter++;
i++;
}
}
if(rs!=null) rs.close();
if(stmt!=null)stmt.close();		 
//out.println("term_set_id1"+term_set_id1+"<br>");
//out.println("diag_desc"+diag_desc+"<br>");

//}



            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(complaint_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(alpha));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(start));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(end));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(addno));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(chkCounter));
            _bw.write(_wl_block29Bytes, _wl_block29);
	
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

            _bw.write(_wl_block30Bytes, _wl_block30);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TermSet.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TermCode.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }
}
