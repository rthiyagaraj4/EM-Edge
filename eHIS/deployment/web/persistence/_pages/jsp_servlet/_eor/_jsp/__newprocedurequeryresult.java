package jsp_servlet._eor._jsp;

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

public final class __newprocedurequeryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/NewProcedureQueryResult.jsp", 1709119748000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\n    ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\"../js/NewProcedure.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n<head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\n\t\n</head>\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n\t<form name=\'query_result_form\' id=\'query_result_form\' action=\'\' method=\'post\' target=\'messageFrame\'>\n\t\n\t<table border=\'0\' width=\'100%\' id=\'dataTitleTable\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' >\n\t\t\t<tr><th align=\'left\' colspan=\'8\' \'><font=\'verdana\' size=\'1\'>Procedure History</font></th>\n\t\t\t</tr>\n\t</table>\n\t<table border=\'0\' width=\'100%\' id=\'\' cellpadding=\'0\' cellspacing=\'1\' align=\'center\' >\n\t<tr>\n\t\t\t\t<!-- <td align=\'center\' width=\'2%\' ><font size=1 ></font></td> -->\n\t\t\t\t<td align=\'center\' width=\'2%\' ><font size=1 ></font></td>\n\t\t\t\t<td align=\'center\' width=\'52%\'><font size=1 >Procedure Description</font></td>\n\t\t\t\t<td align=\'center\' width=\'10%\'><font size=1 >Code</font></td>\n\t\t\t\t<td align=\'center\' width=\'16%\'><font size=1 >Performed On</font></td>\n\t\t\t\t<td align=\'center\' width=\'10%\'><font size=1 >Details</font></td>\n\t\t\t\t<td align=\'center\' width=\'10%\'><font size=1 >Outcome</font></td>\n\t\t\t\t\n\t</tr>\n\t</table>\n\n\t<!-- <table border=\'1\' width=\'100%\' id=\'dataTable\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' style=\"border-bottom:#ffffff\"> -->\n\t\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t<table border=\'1\' width=\'100%\' id=\'dataTable\' cellpadding=\'0\' cellspacing=\'0\' \t\t\t\t\t\talign=\'center\' >\n\t\t\t<tr>\n\t\t\t\t<td colspan=\'\' width=\'2%\' class=\'CAGROUPHEADING\' align=\'center\' style=\'cursor:pointer\' onClick=\'showRelatedProcedure(";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =")\' id=\'proc_tree";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'><font size=\"1\" color=\'#6633FF\'><B>--</B></font></td>\n\t\t\t\t<td colspan=\'8\' width=\'98%\' class=\'CAGROUPHEADING\' align=\'left\'><label onClick=\"callProceduredetail(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\');\" style=\'cursor:pointer\'><font size=\"1\" color=\'#6633FF\'><b>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</b></font></label></td>\n\t\t\t\t\n\t\t\t</tr>\n\t\t\t</table> \n\t\t\t<table border=\'1\' cellspacing=\'0\' cellpadding=\'0\' width=\'100%\' align=\'center\' id=\'proc_detail";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' style=\'display:inline\' >\n\t\t\t\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\n</table>\t\t  \n\n\n\t<input type=\'hidden\' name=\'qryStr\' id=\'qryStr\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >\n\t<input type=\'hidden\' name=\'Patient_Id\' id=\'Patient_Id\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" >\n\t<input type=\'hidden\' name=\'Encounter_Id\' id=\'Encounter_Id\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" >\n\t<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" >\n\t<input type=\"hidden\" name = \"Locn_Code\" value =\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t<input type=\"hidden\" name = \"Locn_Type\" value =\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<input type=\"hidden\" name = \"Practitioner_Id\" value =\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t<input type=\"hidden\" name = \"relationship_id\" value =\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type=\"hidden\" name = \"modal_yn\" value =\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}


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
            _bw.write(_wl_block1Bytes, _wl_block1);
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

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
//out.println("<script>alert('===="+request.getQueryString()+"===')</script>");
		String Patient_Id				= checkForNull(request.getParameter("patient_id"));
		String Encounter_Id				= checkForNull(request.getParameter("encounter_id"));		
		String operating_facility_id	= (String) session.getValue("facility_id");
		String patient_class		    = checkForNull(request.getParameter("patient_class"));
		//String age						= checkForNull(request.getParameter("Age"));	
		//String dob						= checkForNull(request.getParameter("Dob"));	
		String Locn_Code	            = checkForNull(request.getParameter("location_code"));			
		String Locn_Type			    = checkForNull(request.getParameter("location_type"));
		String Practitioner_Id			= checkForNull(request.getParameter("Practitioner_Id"));	
		String relationship_id			= checkForNull(request.getParameter("relationship_id"));
		//String sex						= checkForNull(request.getParameter("Sex"));
		String modal_yn					= checkForNull(request.getParameter("modal_yn"));
		String start_date				= checkForNull(request.getParameter("date_from"));
		String end_date					= checkForNull(request.getParameter("date_to"));
		//String view				= checkForNull(request.getParameter("viewScope"));
		//String restrict					= checkForNull(request.getParameter("restrict"));
		String status				= checkForNull(request.getParameter("status"));
		
		String classValue				= "";
		//String practitioner_type		= checkForNull((String)session.getValue("practitioner_type"));
			
		Connection con			= null;
		PreparedStatement stmt	= null;
		ResultSet rs			= null;		
	
		String term_code = ""; 		//String accuracy_short_desc = "";
		//String onset_nature = "";	
		String onset_date = "";
		//String onset_status = "";	
		String short_desc = "";
		//String term_set_id = "";	
		String term_set_desc = "";
		//String encounter_id1 = "";	
		//String accur_code_ind	=""; 
		//String occur_srl_no	="";
		//String Support_exisist_yn_YN	="";
		StringBuffer associate_codes = new StringBuffer();
		if(Practitioner_Id.equals("") || Practitioner_Id.equals("null")){
			Practitioner_Id		= (String)session.getValue("ca_practitioner_id");
		}

            _bw.write(_wl_block8Bytes, _wl_block8);

	try
	{
		//String status = "";
		//String nature ="";
		//String priority ="";
		String priorityclass ="";
		String prev_term_set_id ="";
		//String Diff_status = "";
		//String not_curr_enc="S";
		//String curr_accuracy_code="";
		//String notifiable_yn="";
        con=ConnectionManager.getConnection(request);
		
		
		int k = 0;
		StringBuffer strBuffer	= new StringBuffer();
	
		if(strBuffer.length() > 0) strBuffer.delete(0,strBuffer.length());
		strBuffer.append("Select a.proc_narration term_code_desc ,a.proc_code term_code,c.Term_Set_Desc  TERM_SET_DESC,to_char(proc_date,'dd/mm/yyyy hh24:mi') proc_date,b.practitioner_name practitioner_name, PATIENT_ID,proc_date dummydate, a.srl_no srl_no,c.term_set_id term_set_id  from pr_encounter_procedure a, am_practitioner b ,mr_term_set  c where a.facility_id = ? and a.PATIENT_ID = ? and a.PROC_CODE_SCHEME = c.TERM_SET_ID and b.practitioner_id=a.practitioner_id and nvl(error_yn,'N')='N' and trunc(proc_date)  between to_date(nvl((?),'01/01/1000'),'dd/mm/yyyy hh24:mi') and to_date(nvl((?),'31/12/9999'),'dd/mm/yyyy hh24:mi') order by dummydate desc");

		stmt = con.prepareStatement(strBuffer.toString());
		stmt.setString(1,operating_facility_id);
		stmt.setString(2,Patient_Id);
		stmt.setString(3,start_date);
		stmt.setString(4,end_date);
		
		rs = stmt.executeQuery();
		int i=0;
		String term_set_id1="";
//System.out.println("rs----------"+rs.next());
		while(rs.next())
		{
			term_set_desc = checkForNull(rs.getString("TERM_SET_DESC"));
			term_set_id1 = checkForNull(rs.getString("TERM_SET_ID"));
			
			if(!prev_term_set_id.equals(term_set_desc))
			{
	
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(k));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(k));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id1));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(term_set_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(k));
            _bw.write(_wl_block14Bytes, _wl_block14);
		i++;
			}
			prev_term_set_id = term_set_desc;
			if ( k%2 == 0 )
                classValue = "QRYEVEN" ;
             else
                classValue = "QRYODD" ;

			short_desc					= checkForNull(rs.getString("term_code_desc"));
			term_code					= checkForNull(rs.getString("term_code"));
			onset_date					= checkForNull(rs.getString("proc_date")); 
			status = "";
			priorityclass = "GREEN";
			out.println("<tr>");
			/*if(encounter_id1.equals("Y"))
				out.println("<td width='2%' class='BLUE'></td>");
			else
				out.println("<td width='2%' class='"+classValue+"'><a href=\"javascript:callsubmit('"+term_code+"','"+term_set_id+"',  	'"+accur_code_ind+"','"+curr_accuracy_code+"','"+sex+"','"+occur_srl_no+"','"+Encounter_Id+"')\">"+not_curr_enc+"</a></td>");
			*/
			out.println("<td width='2%' class='"+priorityclass+"'></td>");
			out.println("<td class='"+classValue+"' width='52%'><font size='1'>"+short_desc+"</font></td>");
			//out.println("<td class='"+classValue+"' width='50%'><font size='1'><a href=\"javascript:callDetails('"+Patient_Id+"','"+term_code+"','"+term_set_id+"','"+patient_class+"','"+onset_date+"', '"+notifiable_yn+"','"+dob+"','"+age+"','"+sex+"','"+occur_srl_no+"','"+(java.net.URLEncoder.encode(associate_codes.toString()))+"','"+Encounter_Id+"')\">"+short_desc+"</a></font><font color='blue' size='1'><b><a href=\"javascript:diffGroup('"+term_set_id+"','update','"+term_code+"')\">"+Diff_status+" </a></b></font></td>");
			out.println("<td class='"+classValue+"' width='10%'><font size='1'>"+term_code+"</font></td>");
			out.println("<td class='"+classValue+"' width='16%'><font size='1'>"+onset_date+"</font></td>");
			//out.println("<td class='"+classValue+"' width='10%' align='center'><font size='1'><img src='../images/flow_text.gif' width='16' height='16' border=0 style='cursor:pointer' onclick=\"callClinicalNotes('','"+Patient_Id+"','"+patient_class+"','"+Encounter_Id+"','"+k+"')\"></font></td>");
			out.println("<td class='"+classValue+"' width='10%' align='center'><font size='1'><img src='../images/flow_text.gif' width='16' height='16' border=0 style='cursor:pointer' ></font></td>");
			out.println("<td class='"+classValue+"' width='10%'><font size='1'>"+status+"</font></td>");
			
			
			out.println("</tr>");		
			out.println("<input type='hidden' name='accession_num"+k+"' id='accession_num"+k+"' value=''>");		
			k++;
			associate_codes = new StringBuffer();
			priorityclass = "";
		}
		
		  if(rs!=null)		rs.close();
		  if(stmt!=null)    stmt.close();

      
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(request.getQueryString()==null?"":request.getQueryString()));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(relationship_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);

}
catch(Exception e)
{
	//out.println("Exception @ try "+e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}
finally
{
	 if(con!=null)
		 ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
