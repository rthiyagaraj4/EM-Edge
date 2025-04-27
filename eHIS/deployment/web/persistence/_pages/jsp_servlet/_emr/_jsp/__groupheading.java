package jsp_servlet._emr._jsp;

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
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __groupheading extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/GroupHeading.jsp", 1730372982144L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t\t<script src=\'../../eCommon/js/rowcolor.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eMR/js/ICDCodeForDagger.js\' language=\'javascript\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=JavaScript src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<script>\n\t//functions for the file name GroupHeading.jsp-end\nvar prevClassName = \"\";\nvar prevRowObject = \"\";\nfunction changeRowColor(obj, changeClassName)\n{\n\tif( changeClassName==null )\tchangeClassName = \"ITEMSELECT\";\n\tif(\tprevClassName != \"\" )\n\t\tfor(i=0; i<prevRowObject.cells.length; i++)\n\t\t\tif(prevRowObject.cells[i].className==changeClassName)\n\t\t\t\tprevRowObject.cells[i].className = prevClassName;\n\n\tprevRowObject\t=\tobj;\n\tprevClassName\t=\tobj.cells[0].className;\n\n    for(i=0; i<obj.cells.length; i++)\n\t\tif(obj.cells[i].className==\"QRYODD\" || obj.cells[i].className == \"QRYEVEN\" ||  obj.cells[i].className == \"\" )\n\t\t\tobj.cells[i].className = changeClassName;\n}\n\n//functions for the file name GroupHeading.jsp-end\n\t</script>\n<body onKeyDown=\'lockKey()\' >\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<table width=\'100%\' border=\'0\' cellspacing=\'0\' cellpadding=\'0\' id=\'tb\' >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t</table>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection conn= null; 
PreparedStatement pstmt = null ;
ResultSet rset=null;

int MaxRecord=0;

String Diag_groupcode		= "";
String Diag_groupdesc		= "";
String classValue				= "";
String Encounter_Id			= checkForNull(request.getParameter("Encounter_Id"));
//String term_set_id		= checkForNull(request.getParameter("term_set_id"));
String authorize					= checkForNull(request.getParameter("p_auth_yn"));
String cause_indicator		= checkForNull(request.getParameter("cause_indicator"));
String code_indicator		= checkForNull(request.getParameter("code_indicator"));
String diagcode					= checkForNull(request.getParameter("p_diag_code"));
String diagdesc					= checkForNull(request.getParameter("p_diag_scheme_desc"));
String dob							= checkForNull(request.getParameter("Dob"));
String facility_id				= (String)session.getValue("facility_id");
String function_id				= checkForNull(request.getParameter("function_id"));
String sex							= checkForNull(request.getParameter("Sex"));
String speciality_code		= checkForNull(request.getParameter("speciality_code"));
String diagnosis_by_long_desc_yn =	checkForNull(request.getParameter("diagnosis_by_long_desc_yn"));//Maheshwaran added for the HSA-CRF-0234
int rowCount = 1;

String practitioner_id			= checkForNull((String)session.getValue("ca_practitioner_id"));
if (practitioner_id.equals("")||practitioner_id==""){ 
	practitioner_id				= checkForNull(request.getParameter("practitioner_id"));
}
String term_set_id="";
String title		= request.getParameter("title")==null?"":request.getParameter("title");


	/*
		Commented On 10/20/2009
		if(title.equals("ICD10 Code List")){
			term_set_id =(request.getParameter("p_diag_scheme_desc")==null)?"":request.getParameter("p_diag_scheme_desc");
		}else{
			term_set_id =(request.getParameter("term_set_id")==null)?"":request.getParameter("term_set_id");
		}
	*/
	if(title.equals("ICD10 Code List")){
			term_set_id =checkForNull(request.getParameter("p_diag_scheme_desc"));
		}else{
			term_set_id =checkForNull(request.getParameter("term_set_id"));
		}
	try{
			conn = ConnectionManager.getConnection(request);
			StringBuffer sql =new StringBuffer();
			if(sql.length() > 0) sql.delete(0,sql.length());
			if(function_id.equals("ca_diagnosis")){
			/*
					sql.append("SELECT diag_group_code, diag_group_desc FROM mr_diag_group WHERE diag_code_scheme=( select DIAG_CODE_SCHEME from mr_parameter)  and  (practitioner_id = ? or practitioner_id is null) ");
					if (!Encounter_Id.equals("0")) 
						sql.append(" AND (speciality_code is null or speciality_code = (select SPECIALTY_CODE from pr_encounter where facility_id=? and encounter_id=?)) ");
					sql.append(" ORDER BY diag_group_desc ");
			*/
					sql.append( " select a.term_group_id diag_group_code , a.term_group_desc diag_group_desc from MR_TERM_GROUP_HDR a where a.term_set_id = '"+term_set_id+"' and ( a.index_type_yn = 'N' or exists ( select 1 from MR_CUSTOM_LIST_TERM_GROUP_DTL where term_set_id = a.term_set_id and term_group_id = a.term_group_id and index_type='P' and practitioner_id = '"+practitioner_id+"' ) or exists ( select 1 from MR_CUSTOM_LIST_TERM_GROUP_DTL where term_set_id = a.term_set_id and term_group_id = a.term_group_id and index_type='S' and speciality_code = '"+speciality_code+"' ");
					if (!Encounter_Id.equals("0")) {
						sql.append(" AND (speciality_code = (select SPECIALTY_CODE from pr_encounter where facility_id = '"+facility_id+"' and encounter_id = '"+Encounter_Id+"')) ");
					}
					sql.append(" )) and eff_status='E' order by 2 ");
					pstmt=conn.prepareStatement(sql.toString());
			}else{
					//sql.append( " SELECT diag_group_code, diag_group_desc FROM mr_diag_group WHERE diag_code_scheme= ?  AND speciality_code IS NULL AND facility_id IS NULL AND practitioner_id IS NULL UNION SELECT diag_group_code, diag_group_desc FROM mr_diag_group WHERE diag_code_scheme= ? AND facility_id = ? and practitioner_id is null and speciality_code is null UNION select  diag_group_code, diag_group_desc FROM mr_diag_group WHERE practitioner_id = ? AND speciality_code IN ( (SELECT primary_speciality_code FROM am_practitioner WHERE practitioner_id = ? UNION SELECT speciality_code FROM am_pract_specialities WHERE facility_id = ? AND practitioner_id= ? ))");

					sql.append( " select a.term_group_id diag_group_code , a.term_group_desc diag_group_desc from MR_TERM_GROUP_HDR a where a.term_set_id = '"+term_set_id+"' and ( a.index_type_yn = 'N' or exists ( select 1 from MR_CUSTOM_LIST_TERM_GROUP_DTL where term_set_id = a.term_set_id and term_group_id = a.term_group_id and index_type='P' and practitioner_id = '"+practitioner_id+"' ) or exists ( select 1 from MR_CUSTOM_LIST_TERM_GROUP_DTL where term_set_id = a.term_set_id and term_group_id = a.term_group_id and index_type='S' and speciality_code = '"+speciality_code+"' )) and eff_status='E' order by 2 ");
					pstmt=conn.prepareStatement(sql.toString());
			/*		pstmt.setString(1,diagcode);
					pstmt.setString(2,diagcode);
					pstmt.setString(3,facility_id);
					pstmt.setString(4,practitioner_id);
					pstmt.setString(5,practitioner_id);
					pstmt.setString(6,facility_id);
					pstmt.setString(7,practitioner_id);
	*/
		}
		rset=pstmt.executeQuery();
		
            _bw.write(_wl_block8Bytes, _wl_block8);

				while(rset.next()){
						MaxRecord++;
						if(function_id.equals("ca_diagnosis")){
							classValue	=	((rowCount%2)==0)	?	"QRYEVEN"	:	"QRYODD";
							Diag_groupcode=rset.getString("diag_group_code");
							Diag_groupdesc=rset.getString("diag_group_desc");
							//class=\""+classValue+"\"
							out.println("<tr id=\"tbl_row"+rowCount+"\" style='background-color:;'><td valign='top' nowrap class='"+classValue+"'>");
							out.println("<li><a  href=\"CustomICDQueryFrames.jsp?diagnosis_by_long_desc_yn="+diagnosis_by_long_desc_yn+"&term_set_id="+term_set_id+"&Diag_code="+Diag_groupcode+"&Diag_desc="+java.net.URLEncoder.encode(Diag_groupdesc)+"&p_diag_code="+diagcode+"&p_diag_scheme_desc="+java.net.URLEncoder.encode(diagdesc)+"&p_auth_yn="+authorize+"&cause_indicator="+cause_indicator+"&Dob=" + dob + "&Sex=" + sex +"&code_indicator=" +code_indicator+"&function_id="+function_id+"\"   onClick=\"changeRowColor(tbl_row"+rowCount+")\" target='code_description'>");
							out.println(Diag_groupdesc+"</a></td></tr>");
							rowCount++;
						}else{
							classValue	=	((rowCount%2)==0)	?	"QRYEVEN"	:	"QRYODD";
							Diag_groupcode=rset.getString("diag_group_code");
							Diag_groupdesc=rset.getString("diag_group_desc");
							out.println("<tr style='background-color:;'><td valign='top' nowrap class='"+classValue+"'>");
							//out.println("<li><a  href='../../eMR/jsp/CusticdQueryResult.jsp?term_set_id="+term_set_id+"&code_indicator=D&Diag_code="+Diag_groupcode+"&Diag_desc="+Diag_groupdesc+"&p_diag_code="+diagcode+"&p_diag_scheme_desc="+diagdesc+"&p_auth_yn="+authorize+"&cause_indicator="+cause_indicator+"' target='code_description'>"); 
							//Modified for SCR 4833
							out.println("<li><a  href='../../eMR/jsp/CusticdQueryResult.jsp?diagnosis_by_long_desc_yn="+diagnosis_by_long_desc_yn+"&term_set_id="+term_set_id+"&code_indicator="+code_indicator+"&Diag_code="+Diag_groupcode+"&Diag_desc="+Diag_groupdesc+"&p_diag_code="+diagcode+"&p_diag_scheme_desc="+diagdesc+"&p_auth_yn="+authorize+"&cause_indicator="+cause_indicator+"&function_id="+function_id+"' target='code_description'>");
							out.println(Diag_groupdesc+"</a></td</tr>>");
							rowCount++;
						}
				}//End Of While
				if(MaxRecord == 0){
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				}
	}catch(Exception e){
		e.printStackTrace();
		}finally{
		try{
			if (rset!=null) rset.close();
			if (pstmt!=null) pstmt.close();
		}catch(Exception e) {
			 e.printStackTrace();
			//out.println("BB"+e.toString());
			}
		   ConnectionManager.returnConnection(conn,request);
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
