package jsp_servlet._emp._jsp;

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
import java.util.*;
import com.ehis.util.*;

public final class __viewpatfamilymembers1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/ViewPatFamilyMembers1.jsp", 1725355595415L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eMP/js/ftiens4.js\"></script>\n<script src=\"../../eMP/js/photosturism.js\"></script>\n<script src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<body onLoad=\"test()\" onKeyDown=\'lockKey()\'>\n<form name=\"vpfm\" id=\"vpfm\">\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="<input type=\'hidden\' name=\'s_Style\' id=\'s_Style\' value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</form>\n</body> \n</html>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

String patient = request.getParameter("Patient_ID");
Connection con = null;
PreparedStatement pstmt = null;
PreparedStatement pstmt1= null;
PreparedStatement pstmt2= null;


ResultSet rs =null;
ResultSet rs1=null;
ResultSet rs2=null;
ResultSet rs3=null;

int one=0;
int two=0;
int three=0;
int four=0;

try{

	con = ConnectionManager.getConnection(request);

	String sql="select patient_id, family_link_no, decode(patient_id,?,2,3),sex  from mp_patient "+
	"where patient_id = ? or  "+
	"family_link_no = ? "+
	"union "+
	"select patient_id, family_link_no, 1,sex "+
	"from mp_patient "+
	"where patient_id = (select family_link_no from mp_patient where patient_id = ?) "+
	"union "+
	"select patient_id, family_link_no, 4,sex "+
	"from mp_patient "+
	"where family_link_no = (select family_link_no from mp_patient "+
				"where patient_id = ?) "+
	"and patient_id <> ? "+
	"order by 3,1 ";

	
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,patient);
	pstmt.setString(2,patient);
	pstmt.setString(3,patient);
	pstmt.setString(4,patient);
	pstmt.setString(5,patient);
	pstmt.setString(6,patient);
	rs=pstmt.executeQuery();

	while(rs.next()) 
	{
		
		if(rs.getInt(3)==1) one++;
		if(rs.getInt(3)==2) two++;
		if(rs.getInt(3)==3) three++;
		if(rs.getInt(3)==4) four++;
	}
	
	int z=one + two + three + four;
	
	if(z<2){
		out.println("<script>alert(getMessage('NO_FAMILY_MEMBERS','MP'));</script>");   		
		out.println("<script>parent.plineFrame.location.href ='../../eCommon/html/blank.html'</script>");
		out.println("<script>parent.f_query_add_mod.location.href ='../../eMP/jsp/blank.jsp?step_1=6'</script>");

		for(int b=0;b<z;b++){
			out.println("<input type='hidden'  name='h"+b+"' id='h"+b+"'  >");
		}

		for(int s=0;s<z;s++){
			out.println("<input type='hidden'  name='p"+s+"' id='p"+s+"'  >");
		}

		for(int v=0;v<z;v++){
		out.println("<input type='hidden'  name='k"+v+"' id='k"+v+"'  >");
		}

		out.println("<input type='hidden'  name='hiddenid' id='hiddenid'  >");	
		out.println("<input type='hidden' name='oneu' id='oneu' >");
		out.println("<input type='hidden' name='twou' id='twou' >");
		out.println("<input type='hidden' name='threeu' id='threeu' >");
		out.println("<input type='hidden' name='fouru' id='fouru' >");
		out.println("<input type='hidden' name='zval' id='zval' >");
		//out.println("<input type='hidden' name='p_det' id='p_det' >");
		out.println("<input type='hidden' name='p_id' id='p_id' >");
	}
	else
	{

		/*String sql4;
		String Pat_Details="";
		sql4 = "select get_patient_line(?,?) from dual";
		pstmt1 = con.prepareStatement(sql4);
		pstmt1.setString(1,patient);
		pstmt1.setString(2,localeName);
		rs2 = pstmt1.executeQuery();
		rs2.next();
		Pat_Details = rs2.getString(1);*/
		String s1[]=new String[z];
		String s2[]=new String[z];
		String s3[]=new String[z];
		rs1=pstmt.executeQuery();
		int i=0;
		while(rs1.next()){
		s2[i]=rs1.getString(1);
		s1[i]=rs1.getString(2);
		s3[i]=rs1.getString(4);
		i++;
		}

		String pat_info="";
		String get[]=new String[z];

		for(int k=0;k<z;k++){
		pat_info="select get_patient_reln(?) from dual";
		if(patient.equals(s2[k])) out.println("<input type='hidden'  name='hiddenid' id='hiddenid'  value=" + k + ">");
		pstmt2 = con.prepareStatement(pat_info);
		pstmt2.setString(1,s2[k]);
		rs3=pstmt2.executeQuery();
		while(rs3.next()){
		get[k]=rs3.getString(1);
		
		}
	}

	for(int b=0;b<z;b++){
		out.println("<input type='hidden'  name='h"+b+"' id='h"+b+"'  value=\""+get[b]+"\">");
	}

	for(int s=0;s<z;s++){
		out.println("<input type='hidden'  name='p"+s+"' id='p"+s+"'  value=\""+s2[s]+"\">");
	}

	for(int v=0;v<z;v++){
		out.println("<input type='hidden'  name='k"+v+"' id='k"+v+"'  value=\""+s3[v]+"\">");
	}

	out.println("<input type='hidden' name='oneu' id='oneu' value="+one+">");
	out.println("<input type='hidden' name='twou' id='twou' value="+two+">");
	out.println("<input type='hidden' name='threeu' id='threeu' value="+three+">");
	out.println("<input type='hidden' name='fouru' id='fouru' value="+four+">");
	out.println("<input type='hidden' name='zval' id='zval' value="+z+">");
	//out.println("<input type='hidden' name='p_det' id='p_det' value=\""+Pat_Details+"\">");
	out.println("<input type='hidden' name='p_id' id='p_id' value=\""+patient+"\">");
	
	}
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

}
catch(Exception e){
	out.println("<script>alert(getMessage('NO_FAMILY_MEMBERS','MP'));</script>"); 
	out.println("<script>parent.plineFrame.location.href ='../../eCommon/html/blank.html'</script>");
	out.println("<script>parent.f_query_add_mod.location.href ='../../eMP/jsp/blank.jsp?step_1=6'</script>");
} 
finally
{
	if(pstmt != null) pstmt.close();
	if(pstmt1 != null) pstmt1.close();
	if(pstmt2 != null) pstmt2.close();
	if(rs3 != null) rs3.close();
	if(rs2 != null) rs2.close();
	if(rs1 != null) rs1.close();
	if(rs != null) rs.close();
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block9Bytes, _wl_block9);
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
