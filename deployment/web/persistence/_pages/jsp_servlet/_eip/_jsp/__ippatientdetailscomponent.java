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
import java.net.*;
import webbeans.eCommon.*;

public final class __ippatientdetailscomponent extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPPatientDetailsComponent.jsp", 1709117788322L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\t<!--Parimala-->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eIP/html/text.css\'></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t\n\t\t<script>\n\t\tfunction OpenModel() \n\t\t{\n\t\t\t\n\t\t}\n\t\t\n\t\tfunction validpatient() {\n\n\t\t\t}\n\t\t\t\t///// This function is used to validate Nationality ID\n\t\t\n\t\tfunction validateNationality(Nat_Id)\t{\n\t\t\t\n\t\t}\n\t\t// This function is used to validate Alternate Id \nfunction altid(Alt_Id) \n{\n\n}\n\nfunction altidval()\n{\n}\n// This function is used to put the values into the name field \n\nfunction putPatientName(from1,from){}// End of FUNCTION\n\n\n// This function is used to pop up modal window for address details\n\n \tfunction show_window(Val)\n\t{}\n\n\t\t// This Function Calculates Year,Month and Days given D.O.B\n\t\t\t\n\t\t\tfunction calci(Obj)\n\t\t\t{}\n\t\t\t\n\t\t\t\n\t\t\tfunction leapyear(a) {}\n\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\tfunction CheckForNumber_L(Objval) {}\n\n\t\t\t\n\t\t\tfunction calcage(obj1,obj2) {}\n\t\t\n\t\tfunction enable(Obj)\n\t\t{}\n\t\t\n\t\t\n\t\t\n\t\tfunction checkMonth(Obj)\n\t\t{\n\t\t\n\t\t}\n\t\t\n\t\tfunction checkDays(Obj)\n\t\t{\n\t\t}\n\t\t\n\t\t// End By Ush\n\n\t</script>\t\n\t\t\n\t</head>\n \t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t     <body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\t\t\n\t     \t\t<input type=\'hidden\' name=\'name_drvn_logic\' id=\'name_drvn_logic\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' >\n\t     \t\t<input type=\'hidden\' name=\'contactvals\' id=\'contactvals\' value=\'\'>\n\t     \t\t<input type=\'hidden\' name=\'name_prefix\' id=\'name_prefix\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'name_suffix\' id=\'name_suffix\' value=\'\'>\n    \t    \t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\' valign=\'top\' >\n\t\t\t\t\t\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"100%\" class=\"Border\">\n\t    \t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\' valign=\'top\' >\n\t\t    \t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td width=\"100%\" class=\"Border\">\n\t\t\t\t\t\t\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</tr>\n\t\t<tr>\n\t\t\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t    \t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\"  class=\"label\"  nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\'left\'  class=\'label\' colspan=\'2\' nowrap>< Age >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\'left\' class=\'label\'  colspan=\'2\' nowrap>Date of Birth\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\'left\' width=\'2%\' id=\'gender\' class=\'query_data\' align=\'center\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\'left\' width=\'1%\' colspan=\'2\' nowrap id=\'b_age\' class=\'query_data\' align=\'center\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\'left\' width=\'1%\' id=\'date_of_birth\' class=\'query_data\' align=\'center\'>\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t <td align=\'right\' colspan=\'3\' >\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\n\t\t\t\t    \t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t    \t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t    \t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t    \t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t    \t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t    \t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t    \t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t    \t\t\t\t\t\t\t\t\t</table>\n\t\t\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<input type=\'hidden\' name=\'text5\' id=\'text5\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'text6\' id=\'text6\' value=\'\'>\n\t\t\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

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
            _bw.write(_wl_block6Bytes, _wl_block6);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8");
 	String sql="";
 	String First_Name_Accept_Yn ="";
	int First_Name_Order=0;
	String First_Name_Prompt ="";
	String Second_Name_Accept_Yn ="";
	int Second_Name_Order =0;
	String Second_Name_Prompt ="";
	String Third_Name_Accept_Yn ="";
	int Third_Name_Order =0;
	String Third_Name_Prompt ="";
	String Family_Name_Accept_Yn ="";
	int Family_Name_Order =0;
	String Family_Name_Prompt ="";
	String Name_Suffix_Accept_Yn ="";
	String Name_Suffix_Prompt ="";
	String Name_Prefix_Accept_Yn = "";
	String Name_Prefix_Prompt = "";

	String First_Name_Reqd_Yn ="";
	String Second_Name_Reqd_Yn ="";
	String Third_Name_Reqd_Yn ="";
	String Family_Name_Reqd_Yn ="";
	String Name_Prefix_Reqd_Yn ="";
 	String NameDrvnLogic="";

	Statement stmt=null;
	Statement stmtlen=null;
	ResultSet rs=null;

	ResultSet rssd=null;
	ResultSet rslen=null; 
	Connection conn = null;
	try
	{

	conn = ConnectionManager.getConnection(request);;
	String len_check="Select Patient_Id_Length,Nat_Id_Length,alt_id1_length from mp_param";
	stmtlen=conn.createStatement();
	rslen=stmtlen.executeQuery(len_check);
	rslen.next();

	if(rslen!=null)rslen.close();
	if(stmtlen!=null)stmtlen.close();

	
	stmt=conn.createStatement();
	sql= "select nvl(First_Name_Accept_Yn,'N'),First_Name_Order,nvl(First_Name_Prompt,'First Name'),nvl(Second_Name_Accept_Yn,'N'),Second_Name_Order,nvl(Second_Name_Prompt,'Second Name'),nvl(Third_Name_Accept_Yn,'N'),Third_Name_Order,nvl(Third_Name_Prompt,'Third Name'),nvl(Family_Name_Accept_Yn,'N'),Family_Name_Order,nvl(Family_Name_Prompt,'Family Name'),nvl(name_suffix_accept_yn,'N'),nvl(name_prefix_accept_yn,'N'),nvl(name_suffix_prompt,'Name Suffix'),nvl(name_prefix_prompt,'Name Prefix'),nvl(first_name_reqd_yn,'N'),nvl(second_name_reqd_yn,'N'),nvl(third_name_reqd_yn,'N'),nvl(family_name_reqd_yn,'N'),nvl(name_suffix_reqd_yn,'N'),nvl(name_prefix_reqd_yn,'N'),name_dervn_logic, nvl(Alt_Id1_reqd_yn,'N'), Alt_Id1_type, nvl(Alt_Id1_length,0), nvl(Alt_Id1_Unique_yn,'N') from mp_param ";
	rs=stmt.executeQuery(sql);
	rs.next();
	First_Name_Accept_Yn = rs.getString(1);
	First_Name_Order = rs.getInt(2);
	First_Name_Prompt = rs.getString(3);
	Second_Name_Accept_Yn = rs.getString(4);
	Second_Name_Order = rs.getInt(5);
	Second_Name_Prompt = rs.getString(6);
	Third_Name_Accept_Yn = rs.getString(7);
	Third_Name_Order = rs.getInt(8);
	Third_Name_Prompt = rs.getString(9);
	Family_Name_Accept_Yn = rs.getString(10);
	Family_Name_Order = rs.getInt(11);
	Family_Name_Prompt = rs.getString(12);

	Name_Suffix_Accept_Yn = rs.getString(13);
	Name_Prefix_Accept_Yn = rs.getString(14);
	Name_Suffix_Prompt = rs.getString(15);
	Name_Prefix_Prompt = rs.getString(16);

	First_Name_Reqd_Yn = rs.getString(17);
	Second_Name_Reqd_Yn = rs.getString(18);
	Third_Name_Reqd_Yn = rs.getString(19);
	Family_Name_Reqd_Yn = rs.getString(20);
	Name_Prefix_Reqd_Yn = rs.getString(22);
	NameDrvnLogic=rs.getString(23);
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( NameDrvnLogic));
            _bw.write(_wl_block10Bytes, _wl_block10);

		if ( Name_Prefix_Accept_Yn.equals("Y") )
			out.println("<td align='left' class='label'>"+Name_Prefix_Prompt+"</td>");
		
		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) {
				out.println("<td align='left' class='label' >"+ First_Name_Prompt + "</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ) {
			out.println("<td align='left' class='label' >" + Second_Name_Prompt + "</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )  {
			out.println("<td align='left' class='label' >" + Third_Name_Prompt + "</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ) {
			out.println("<td align='left' class='label' >"+Family_Name_Prompt+"</td>");
		}

		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) {
			out.println("<td align='left' class='label' >"+ First_Name_Prompt + "</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
			out.println("<td align='left' class='label' >" + Second_Name_Prompt + "</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
			out.println("<td align='left' class='label' >" + Third_Name_Prompt + "</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ) {
			out.println("<td align='left' class='label' >"+Family_Name_Prompt+"</td>");
		}

		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
			out.println("<td align='left' class='label' >"+ First_Name_Prompt + "</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
			out.println("<td align='left' class='label' >" + Second_Name_Prompt + "</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  {
			out.println("<td align='left' class='label' >" + Third_Name_Prompt + "</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
			out.println("<td align='left' class='label' >"+Family_Name_Prompt+"</td>");
		}
		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
			out.println("<td align='left' class='label' >"+ First_Name_Prompt + "</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
			out.println("<td align='left' class='label' >" + Second_Name_Prompt + "</td>");
		}
			else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
				out.println("<td align='left' class='label' >" + Third_Name_Prompt + "</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 ) {
			out.println("<td align='left' class='label' >"+Family_Name_Prompt+"</td>");
		}
		
		if ( Name_Suffix_Accept_Yn.equals("Y") )
			out.println("<td align='left' class='label' >"+Name_Suffix_Prompt+"</td>");

		
            _bw.write(_wl_block11Bytes, _wl_block11);

		if ( Name_Prefix_Accept_Yn.equals("Y") )
		{
		
				out.println("<td align='left' nowrap id='name_prefix' class='query_data' align='center'>");
				out.println("");
			
			if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==0 ) {
				out.println("<input type='hidden' name='first_name' id='first_name' size='15' maxlength='20'>");
			}
			else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==0 ) {
				out.println("<input type='hidden' name='second_name' id='second_name' size='15' maxlength='20'>");
			}
			else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==0 ) {
				out.println("<input type='hidden' name='third_name' id='third_name' size='15' maxlength='20'>");
			}
			else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==0 ) {
				out.println("<input type='hidden' name='family_name' id='family_name' size='15' maxlength='20'>");
			}
		
			if (Name_Prefix_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='N'></input>");
			}
		
		out.println("</td>");
		}
		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 )
		{
				out.println("<td align='left' id='first_name' class='query_data' align='center'>");
		
			if (First_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 )
		{
			out.println("<td align='left' id='second_name' class='query_data' align='center'>");
		
			if (Second_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>");
			}
		
			out.println("</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )
		{
			out.println("<td align='left' id='third_name' class='query_data' align='center'>");
		
		
			if (Third_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>");
			}
		
			out.println("</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 )
		{
			out.println("<td align='left' id='family_name' class='query_data' align='center'>");
		
		
			if ( Family_Name_Reqd_Yn.equals("Y") )
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
			}
		
			out.println("</td>");
		}

		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 )
		{
			out.println("<td align='left' id='first_name' class='query_data' align='center'>");
		
			if (First_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 )
		{
			out.println("<td align='left' id='second_name' class='query_data' align='center'>");
		
			if (Second_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )
		{
			out.println("<td align='left' id='third_name' class='query_data' align='center'>");
		
			if (Third_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>");
			}
		
		
			out.println("</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 )
		{
			out.println("<td align='left' id='family_name' class='query_data' align='center'>");
		
			if (Family_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}

		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 )
		{
			out.println("<td align='left' id='first_name' class='query_data' align='center'>");
		
			if (First_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
			}
		
			out.println("</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 )
		{
			out.println("<td align='left' id='second_name' class='query_data' align='center'>");
		
			if (Second_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )
		{
			out.println("<td align='left' id='third_name' class='query_data' align='center'>");
		
			if (Third_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>");
			}
		
		
			out.println("</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 )
		{
			out.println("<td align='left' id='family_name' class='query_data' align='center'>");
		
			if (Family_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}

		
		if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 )
		{
			out.println("<td align='left' id='first_name' class='query_data' align='center'>");
		
			if (First_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
		else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 )
		{
			out.println("<td align='left' id='second_name' class='query_data' align='center'>");
		
			if (Second_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input>");
			}
		
		
			out.println("</td>");
		}
		else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )
		{
			out.println("<td align='left' id='third_name' class='query_data' align='center'>");
		
			if (Third_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input>");
			}
		
			out.println("</td>");
		}
		else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 )
		{
			out.println("<td align='left' id='family_name' class='query_data' align='center'>");
		
			if (Family_Name_Reqd_Yn.equals("Y")  )
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y'></input>");
			}
			else
			{
				out.println("<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>");
			}
			out.println("</td>");
		}
				
		if ( Name_Suffix_Accept_Yn.equals("Y") )
		{
			out.println("<td align='left' nowrap id='name_suffix' class='query_data' align='center'>");
			out.println("</td>");
		}
		
		
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
 } 
		catch(Exception e ){out.println(e);} 
		finally
		{
			if(stmt!=null)stmt.close();
			if(stmtlen!=null)stmtlen.close();
			if(rs!=null)rs.close();
			if(rssd!=null)rssd.close();
			if(rslen!=null)rslen.close();
			ConnectionManager.returnConnection(conn,request);
		}
		
            _bw.write(_wl_block14Bytes, _wl_block14);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
