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
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __customlistterminologygroupaddmodifydetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/CustomListTerminologyGroupAddModifyDetail.jsp", 1741061114971L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html> \n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\"JavaScript\" src=\"../js/CustomListTerminologyGroup.js\"></script>\n </head>\n ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n <!-- Modified against ARYU-SCF-0115 by Shanmukh on 6th-Mar-2018 -->\n<body  OnMouseDown=\"CodeArrest();\"  class=\'CONTENT\' onLoad=\"chkForSelectAll(";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =",";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =",\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\')\" onKeyDown=\'lockKey()\'>\n<form name=\'customTerminologyGroupResultForm\' id=\'customTerminologyGroupResultForm\' action=\'../../eMR/jsp/CustomListTerminologyGroupAddModifyDetail.jsp\' method=\'post\' >\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<table  width=\'90%\' border=0 align=\'center\'>\n\t<table  align=\'right\'>\n\t<tr>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n\t\t</tr>\n\t\t</table>\n\t\t<br>\n\t\t<br>\n\t\t</table>\n\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<td width=\'60%\' class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t<!--//Modified against ARYU-SCF-0115 by Shanmukh on 6th-Mar-2018 -->\n\t\t\t<td width=\'20%\' class=\'COLUMNHEADERCENTER\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" <br><input type=\'checkbox\' name=\'chkAll\' id=\'chkAll\' onClick=\"selectAll(this,";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\')\" ></td></tr>\n\n\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t<td align=\'left\' class=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'><input type=\'checkbox\' name=\'chk";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' id=\'chk";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'  onclick=\'RemSelectAll();setCheckUncheck(this,\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\");\' ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'removeCode";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'removeCode";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' value=\"\"><input type=\'hidden\' name=\'Code";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'Code";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t\t\t<!--<input type=\'hidden\' name=\'code";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'code";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'  value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>--></td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t<script >\n\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t<input type=hidden name=\'term_set_id\' id=\'term_set_id\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t<input type=hidden name=\'term_grp_id\' id=\'term_grp_id\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t<input type=hidden name=\'index_type\' id=\'index_type\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t<input type=hidden name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t<input type=\'hidden\' name=\'max_record\' id=\'max_record\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t<input type=\'hidden\' name=\'index_desc\' id=\'index_desc\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t<!-- FOR 17211:-- modified by Venkats Modified on 15/12/09-->\n\t<input type=\'hidden\' name=\'search_criteria\' id=\'search_criteria\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t</table>\n\t</form>\n\t<script>\n\t\t\t//if(\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'==2)\n\t\t\t\t//document.forms[0].chkAll.onclick();\t\n\t</script>\n\t</body>\n\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\t\n\n </html>\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\n\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals(""))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals(""))) ? defaultValue : inputString);
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
            webbeans.eCommon.RecordSet PractitionerSpeciality= null;synchronized(session){
                PractitionerSpeciality=(webbeans.eCommon.RecordSet)pageContext.getAttribute("PractitionerSpeciality",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(PractitionerSpeciality==null){
                    PractitionerSpeciality=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("PractitionerSpeciality",PractitionerSpeciality,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String term_set_id		= checkForNull(request.getParameter("term_set_id"));
	String mode				= checkForNull(request.getParameter("mode"));
	String term_grp_id		= checkForNull(request.getParameter("term_grp_id"));
	String index_type		= checkForNull(request.getParameter("index_type"));
	String from				= checkForNull(request.getParameter("from")) ;
    String to				= checkForNull(request.getParameter("to")) ;   
	//String eff_status		= checkForNull(request.getParameter("effect_status")) ; 
	String flagSelect		= checkForNull(request.getParameter("fromSearch"));
	String function_name	= checkForNull(request.getParameter("function_name"));
	String search_criteria  = checkForNull(request.getParameter("search_criteria")) ;	
	String index_desc       = checkForNull(request.getParameter("index_desc")) ;	
	Connection con			= null;
	Statement stmt			= null;
	ResultSet rs			= null;
	StringBuffer sqlQuery	= new StringBuffer();
	String	classValue		= "";
	String code				= "";
	String desc				= "";
	int maxRecord = 0;
    int start = 0 ;
    int end = 0 ;
    int i=1;
	String req_start		= "", req_end	= "";
	String checkBoxAttribute  = "";
	String checkedOnes       = "";
	String removeCode = "";
	try
	{
		if (from == null || from.equals("")){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null ||  to.equals("")){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }  

		req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
		req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");

		

		/*if(mode!=null && mode.equals("2"))
		{
			function_name	= "modify";
		}
		else
		{
			function_name	= "insert";
		}*/
			
		con = ConnectionManager.getConnection(request);
		

		if(flagSelect !=null && !flagSelect.equals(""))
       	{
      		PractitionerSpeciality.clearAll();
			StringBuffer selectedPractitionerSpecialityQuery = new StringBuffer();
			if(index_type!=null && index_type.equals("S"))
			{
				selectedPractitionerSpecialityQuery.append("SELECT a.SPECIALITY_CODE , a.SHORT_DESC FROM AM_SPECIALITY a,MR_CUSTOM_LIST_TERM_GROUP_DTL b WHERE a.SPECIALITY_CODE= b.SPECIALITY_CODE AND b.TERM_GROUP_ID='"+term_grp_id+"' AND b.TERM_SET_ID='"+term_set_id+"' AND b.INDEX_TYPE='"+index_type+"' ");
				//Modified against ARYU-SCF-0115 by Shanmukh on 6th-Mar-2018
				if(search_criteria!=null && search_criteria.equals("S"))
					selectedPractitionerSpecialityQuery.append(" and Upper(a.SHORT_DESC) like Upper('"+index_desc+"%')");
				else if(search_criteria!=null && search_criteria.equals("C"))
					selectedPractitionerSpecialityQuery.append(" and Upper(a.SHORT_DESC) like Upper('%"+index_desc+"%')");
				else if(search_criteria!=null && search_criteria.equals("E"))
					selectedPractitionerSpecialityQuery.append(" and Upper(a.SHORT_DESC) like Upper('%"+index_desc+"')");
				selectedPractitionerSpecialityQuery.append(" order by a.SHORT_DESC");
			}
			else
			{
				selectedPractitionerSpecialityQuery.append("SELECT a.PRACTITIONER_ID , a.PRACTITIONER_NAME FROM AM_PRACTITIONER a,MR_CUSTOM_LIST_TERM_GROUP_DTL b WHERE a.PRACTITIONER_ID= b.PRACTITIONER_ID AND b.TERM_GROUP_ID='"+term_grp_id+"' AND b.TERM_SET_ID='"+term_set_id+"' AND b.INDEX_TYPE='"+index_type+"' "); 
				//Modified against ARYU-SCF-0115 by Shanmukh on 6th-Mar-2018
				if(search_criteria!=null && search_criteria.equals("S"))
					selectedPractitionerSpecialityQuery.append(" and Upper(a.PRACTITIONER_NAME) like Upper('"+index_desc+"%')");
				else if(search_criteria!=null && search_criteria.equals("C"))
					selectedPractitionerSpecialityQuery.append(" and Upper(a.PRACTITIONER_NAME) like Upper('%"+index_desc+"%')");
				else if(search_criteria!=null && search_criteria.equals("E"))
					selectedPractitionerSpecialityQuery.append(" and Upper(a.PRACTITIONER_NAME) like Upper('%"+index_desc+"')");
				
				selectedPractitionerSpecialityQuery.append(" order by a.PRACTITIONER_NAME");
			}
			
			//out.println("<script>alert(\""+selectedPractitionerSpecialityQuery.toString()+"\");</script>");
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectedPractitionerSpecialityQuery.toString());
			if(rs !=null)
			{
				while(rs.next())
				{
					PractitionerSpeciality.putObject(rs.getString(1));
					function_name	= "modify";
				 }
			}

			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}

		 if(from != null && to != null)
        {
			int j=0;
			for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
			{
				if(request.getParameter("chk"+(i)) != null)
				{
					checkedOnes = request.getParameter("chk"+(i));
					if(!(PractitionerSpeciality.containsObject(checkedOnes)))
					{
						//out.println("<script>alert(\""+checkedOnes+"\");</script>");
						PractitionerSpeciality.putObject(checkedOnes);
					}
					j++;
				}

				removeCode = checkForNull(request.getParameter("removeCode"+(i)));
				if(removeCode.equals("Y"))
				{
					String nu_pract_Code = request.getParameter("Code"+(i));
					if((PractitionerSpeciality.containsObject(nu_pract_Code)))
					{
						int removeCodeIndex = PractitionerSpeciality.indexOfObject(nu_pract_Code);
							PractitionerSpeciality.removeObject(removeCodeIndex);
					}
				}
			}			
		}

		if(index_type!=null && index_type.equals("S"))
		{
			//if(mode!=null && mode.equals("2"))
				//sqlQuery.append("SELECT a.SPECIALITY_CODE , a.SHORT_DESC FROM AM_SPECIALITY a,MR_CUSTOM_LIST_TERM_GROUP_DTL b WHERE a.SPECIALITY_CODE= b.SPECIALITY_CODE AND b.TERM_GROUP_ID='"+term_grp_id+"' AND b.TERM_SET_ID='"+term_set_id+"' AND b.INDEX_TYPE='"+index_type+"' ");
			//else
				sqlQuery.append("select SPECIALITY_CODE,SHORT_DESC from AM_SPECIALITY ");
				if(search_criteria!=null && search_criteria.equals("S"))
					sqlQuery.append("where Upper(SHORT_DESC) like Upper('"+index_desc+"%')");
				else if(search_criteria!=null && search_criteria.equals("C"))
					sqlQuery.append("where Upper(SHORT_DESC) like Upper('%"+index_desc+"%')");
				else if(search_criteria!=null && search_criteria.equals("E"))
					sqlQuery.append("where Upper(SHORT_DESC) like Upper('%"+index_desc+"')");
				sqlQuery.append("order by SHORT_DESC");
		}
		else if(index_type!=null && index_type.equals("P"))
		{
			//if(mode!=null && mode.equals("2"))
				//sqlQuery.append("SELECT a.PRACTITIONER_ID , a.PRACTITIONER_NAME FROM AM_PRACTITIONER a,MR_CUSTOM_LIST_TERM_GROUP_DTL b WHERE a.PRACTITIONER_ID= b.PRACTITIONER_ID AND b.TERM_GROUP_ID='"+term_grp_id+"' AND b.TERM_SET_ID='"+term_set_id+"' AND b.INDEX_TYPE='"+index_type+"' ");
			//else
				sqlQuery.append("select PRACTITIONER_ID,PRACTITIONER_NAME from AM_PRACTITIONER  ");
				if(search_criteria!=null && search_criteria.equals("S"))
					sqlQuery.append("where Upper(PRACTITIONER_NAME) like Upper('"+index_desc+"%')");
				else if(search_criteria!=null && search_criteria.equals("C"))
					sqlQuery.append("where Upper(PRACTITIONER_NAME) like Upper('%"+index_desc+"%')");
				else if(search_criteria!=null && search_criteria.equals("E"))
					sqlQuery.append("where Upper(PRACTITIONER_NAME) like Upper('%"+index_desc+"')");
				sqlQuery.append("order by PRACTITIONER_NAME ");
		}
		
		stmt = con.createStatement();
		rs = stmt.executeQuery(sqlQuery.toString());
//		out.println(sqlQuery);
		i = 1 ; 

		if(rs!=null)
		{
			if (start != 0){
				    for(int j=1; j<=start; i++,j++){
					rs.next() ;
				     }
				    }
		}

		//while(i<=end && rs.next()){ 
		
 
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(start));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(end));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(index_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);

	// while(rs!=null && rs.next()){ 
	 while(i<=end && rs.next()){ 
			if(maxRecord == 0)
			{
				
            _bw.write(_wl_block13Bytes, _wl_block13);

		
			if ( !(start <= 1)) {
			out.println("<td align ='right' id='prev' class='BODYCOLORFILLED'><a href='javascript:submitPrevNext("+(start-12)+","+(end-12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a></td>");
	
            _bw.write(_wl_block14Bytes, _wl_block14);

		}
			out.println("<td align ='right' id='next' style='visibility:hidden' class='BODYCOLORFILLED'><a href='javascript:submitPrevNext("+(start+12)+","+(end+12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a></td>");
	
            _bw.write(_wl_block15Bytes, _wl_block15);
 if(index_type!=null && index_type.equals("S"))
				{
		
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

				}
			else if(index_type!=null && index_type.equals("P"))
				{
		
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

				}
		
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(start));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(end));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(index_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);

			}
			code=rs.getString(1);
						
			desc=rs.getString(2);

			if(PractitionerSpeciality.containsObject(code)) 
		 		checkBoxAttribute = "CHECKED";
		 	else
				checkBoxAttribute="";
			//out.println("<script>alert(\""+checkBoxAttribute+"\");</script>");
			int recordIndex = PractitionerSpeciality.indexOfObject(code);
			//out.println("<script>alert(\""+recordIndex+"\");</script>");
	
			if(recordIndex!=-1)
				if(checkBoxAttribute.equals("CHECKED"))   
					PractitionerSpeciality.removeObject(recordIndex);
	
			//out.println("<script>alert(\""+checkBoxAttribute+"\");</script>");
			if( i%2 == 0)  classValue="QRYEVEN";
				else
				classValue="QRYODD";
				
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(checkBoxAttribute));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(code));
            _bw.write(_wl_block37Bytes, _wl_block37);

				i++;
				maxRecord++;
		}

		if(maxRecord == 0)
		{
			//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			out.println("<script>enableCriteria();</script>");
		}
		if ( maxRecord < 12 || (!rs.next()) )
				{
					
            _bw.write(_wl_block38Bytes, _wl_block38);
 
				}
				else
				{
            _bw.write(_wl_block39Bytes, _wl_block39);

				}		
	
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(term_grp_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(index_type));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(start));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(end));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(start));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(end));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(index_desc));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block53Bytes, _wl_block53);

	}
	catch(Exception e)
	{
		//out.println("Exception in CustomListTerminologyGroupAddModifyDetail page:"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		ConnectionManager.returnConnection(con,request);
		session.setAttribute("PractitionerSpeciality", PractitionerSpeciality);
	}		
	
            _bw.write(_wl_block54Bytes, _wl_block54);
            _bw.write(_wl_block55Bytes, _wl_block55);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.selectall.label", java.lang.String .class,"key"));
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
