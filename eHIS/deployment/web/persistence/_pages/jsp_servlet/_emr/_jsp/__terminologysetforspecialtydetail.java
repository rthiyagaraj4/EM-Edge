package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.*;
import java.util.HashMap;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __terminologysetforspecialtydetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/TerminologySetForSpecialtyDetail.jsp", 1722864657779L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n       \n\tfunction submitPrevNext(from, to){\n\t    document.forms[0].from.value = from;\n\t    document.forms[0].to.value = to; \n\t    document.forms[0].submit();\n\t\tif(document.forms[0].chkAll.checked==true)\n\t\t\tdocument.getElementById(\"selectchkALL\").value=\"Y\";\n\t}\nfunction RemSelectAll(obj, i)\n{\n\tdocument.forms[0].chkAll.checked = false;\n\n\tif(obj.checked == false)\n\t\teval(\"document.forms[0].removeCode\"+i).value = \"Y\";\n\telse\n\t\teval(\"document.forms[0].removeCode\"+i).value = \"N\";\n}\n\nfunction selectAll(Obj,start,end)\n{\n\tif(Obj.checked)\n\t{\n\tfor(var i=start;i<=end;i++)\n\t\t{\n\t\tif(eval(\"document.forms[0].chk\"+i))\n\t\teval(\"document.forms[0].chk\"+i).checked=true;\n\t\t}\n\t\t//Below code was modified by N Munisekhar on 18-Dec-2012 against SKR-SCF-0739 [IN:036606]\n\t var term_set_id = document.forms[0].term_set_id.value;\n\t var specialty_desc_text=document.forms[0].specialty_desc_text.value;\n\t var search_criteria=document.forms[0].search_criteria.value; \n\tvar HTMLVal = \"<HTML><BODY onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'TerminologySetForSpecialtyDynamicValues.jsp\'><input type=\'hidden\' name=\'clearAll\' id=\'clearAll\' value=\'notCleared\'><input type=\'hidden\' name=\'term_set_id\' id=\'term_set_id\' value=\'\"+term_set_id+\"\'><input type=\'hidden\' name=\'specialty_desc_text\' id=\'specialty_desc_text\' value=\'\"+specialty_desc_text+\"\'><input type=\'hidden\' name=\'search_criteria\' id=\'search_criteria\' value=\'\"+search_criteria+\"\'></form></BODY></HTML>\";\n\tparent.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\tparent.frames[2].document.form1.submit();\n\tdocument.getElementById(\"selectchkALL\").value=\"Y\";\n\n\t}\n\telse\n\t{\n\t\tfor(var i=start;i<=end;i++)\n\t\t\t{\n\t\t\tif(eval(\"document.forms[0].chk\"+i))\n\t\t\teval(\"document.forms[0].chk\"+i).checked=false;\n\t\t\t}\n\t\t\tvar term_set_id = document.forms[0].term_set_id.value;\n\t        var specialty_desc_text=document.forms[0].specialty_desc_text.value;\n\t        var search_criteria=document.forms[0].search_criteria.value;\n\tvar HTMLVal = \"<HTML><BODY onKeyDown=\'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'TerminologySetForSpecialtyDynamicValues.jsp\'><input type=\'hidden\' name=\'clearAll\' id=\'clearAll\' value=\'clearAll\'><input type=\'hidden\' name=\'term_set_id\' id=\'term_set_id\' value=\'\"+term_set_id+\"\'><input type=\'hidden\' name=\'specialty_desc_text\' id=\'specialty_desc_text\' value=\'\"+specialty_desc_text+\"\'><input type=\'hidden\' name=\'search_criteria\' id=\'search_criteria\' value=\'\"+search_criteria+\"\'></form></BODY></HTML>\";\n\tparent.frames[2].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\tparent.frames[2].document.form1.submit();\n\tdocument.getElementById(\"selectchkALL\").value=\"N\";\n\t}\n}\n //end SKR-SCF-0739 [IN:036606]\n\nfunction chkForSelectAll(start,end)\n{\n\tif(parent.frames[2].document.forms[0].E.value == \'selectAll\')\n\t{\n\tdocument.forms[0].chkAll.checked=true;\n\tselectAll(document.forms[0].chkAll,start,end)\n\t}\n\n}\n</script>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<body  OnMouseDown=\"CodeArrest();\" onLoad=\'chkForSelectAll(";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =",";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =")\' class=\'CONTENT\' onKeyDown=\'lockKey()\'>\n\t\t<form name=\'facility_form_result\' id=\'facility_form_result\' action=\'../../eMR/jsp/TerminologySetForSpecialtyDetail.jsp\' method=\'post\' >\n\n\t\t<table  width=\'90%\' border=0 align=\'center\'>\n\t\t<tr>\n\t\t<!--<td align=\'right\' class=\'NONURGENT\'>-->\n\t\t<input type=hidden name=\'term_set_id\' id=\'term_set_id\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t<input type=\'hidden\' name=\'finalSelectedValues\' id=\'finalSelectedValues\' value=\'\'>\n\n\t\t<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t<input type=hidden name=\'start\' id=\'start\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t<input type=hidden name=\'end\' id=\'end\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t<input type=hidden name=\'specialty_desc_text\' id=\'specialty_desc_text\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t<input type=hidden name=\'search_criteria\' id=\'search_criteria\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\'>\n\t\t<input type=\'hidden\' name=\'allValues\' id=\'allValues\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'selectchkALL\' id=\'selectchkALL\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\n\t\t<table  align=\'right\'>\n\t\t<tr>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t</tr>\n\t\t</table>\n\t\t<br>\n\t\t<br>\n\t\t</tr>\n\t\t</table>\n\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\n\t\t\t<tr>\n\t\t\t<td width=\'60%\' class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t<td width=\'20%\' class=\'COLUMNHEADERCENTER\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" <br><input type=\'checkbox\' name=\'chkAll\' id=\'chkAll\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" onClick=\'selectAll(this,";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =")\'></td></tr>\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t<td align=\'center\' class=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'><input type=\'checkbox\' ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" name=\'chk";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'  value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' onclick=\"RemSelectAll(this, ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =");\"><input type=\'hidden\' name=\'removeCode";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'removeCode";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' value=\"\"><input type=\'hidden\' name=\'Code";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' id=\'Code";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"></td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t<script >\n\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t<script >\n\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\n</table>\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.RecordSet TerminologyForSpecialty= null;synchronized(session){
                TerminologyForSpecialty=(webbeans.eCommon.RecordSet)pageContext.getAttribute("TerminologyForSpecialty",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(TerminologyForSpecialty==null){
                    TerminologyForSpecialty=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("TerminologyForSpecialty",TerminologyForSpecialty,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);



	String selectchkALLChk="";
	String selectchkALL = checkForNull(request.getParameter("selectchkALL") );
	if(selectchkALL.equals("Y"))
	selectchkALLChk="checked";
	else
	selectchkALLChk=" ";

		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String  req_start   =   "", req_end     =   "";
	
        String  checkedOnes         =   "";
        
        String from = request.getParameter("from") ;
        String to = request.getParameter("to") ;
		String specialty_desc_text = request.getParameter("specialty_desc_text") ;
		String search_criteria = request.getParameter("search_criteria") ;
		String removeCode = "";
        int maxRecord = 0;
        int start = 0 ;
        int end = 0 ;
        int i=1;

        if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
        if (to == null){ end = 12 ; }   else {  end = Integer.parseInt( to ) ; }
       
       req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
       req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");

	//String totAssignreasign="",
		String effStatus="";
		//Statement stmt3 = null;
		PreparedStatement stmt3=null;
		ResultSet rstlRs3 = null;

		effStatus=request.getParameter("effStatus");
		if(effStatus == null) effStatus="";
			Statement stmt=null;
			ResultSet rs=null ;

		Connection con = null;
		try{
			
			con = ConnectionManager.getConnection(request);

	
	//String dat="";
	//String facility="";
	//String pract="";
	//String en="";
	//String fnval="insert";
	//String id="";
	//String fname="";
	//String prname="";
	//String ps="";
//	String facility_id=(String)session.getValue("facility_id");
			String term_set_id=request.getParameter("term_set_id");
			String flagSelect = request.getParameter("fromSearch");


	        	if(flagSelect !=null)
	        	{
	        		TerminologyForSpecialty.clearAll();
	        		 String sqlinsVals= "select specialty_code from mr_term_set_for_specialty where term_set_id=?";
			
				 //stmt3=con.createStatement();
				 stmt3 = con.prepareStatement(sqlinsVals);
				 stmt3.setString(1,term_set_id);
				 rstlRs3 = stmt3.executeQuery();
				if(rstlRs3 !=null)
				{
					 while(rstlRs3.next())
					 {
						TerminologyForSpecialty.putObject(rstlRs3.getString(1));

					 }
				}
	
	        	}
	        //int recordCount			=	0;

             if(from != null && to != null)
             {
                     int j=0;
                     for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
                     {
                         if(request.getParameter("chk"+(i)) != null)
                         {
                             checkedOnes = request.getParameter("chk"+(i));
                             if(!(TerminologyForSpecialty.containsObject(checkedOnes)))
                                 TerminologyForSpecialty.putObject(checkedOnes);
                             j++;
                         }
                         else
                         {
                         
                         }
						 removeCode = checkForNull(request.getParameter("removeCode"+(i)));
						if(removeCode.equals("Y"))
						{
							String spclt_Code = request.getParameter("Code"+(i));
							if((TerminologyForSpecialty.containsObject(spclt_Code)))
							{
								int removeCodeIndex = TerminologyForSpecialty.indexOfObject(spclt_Code);
									TerminologyForSpecialty.removeObject(removeCodeIndex);
}
						}				 
            
                     }

						
                 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
                 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
             }
			i = 1 ;
     
			String classValue="";
			String chkAttribute="";
			//String eff_status="",selectyn="";
			

		StringBuffer sql = new StringBuffer();
		sql.append("select '"+term_set_id+"',speciality_code  specialty_code,long_desc specialty_desc ,'I' db_action from am_speciality where speciality_code not in (select specialty_code from mr_term_set_for_specialty where term_set_id = '"+term_set_id+"') ");
		if(specialty_desc_text!=null && !specialty_desc_text.equals("") && search_criteria!=null && search_criteria.equals("S"))
		sql.append(" and Upper(long_desc) LIKE Upper('"+specialty_desc_text+"%')");
		else if(specialty_desc_text!=null && !specialty_desc_text.equals("") && search_criteria!=null && search_criteria.equals("C"))
			sql.append(" and Upper(long_desc) LIKE Upper('%"+specialty_desc_text+"%')");
		else if(specialty_desc_text!=null && !specialty_desc_text.equals("") && search_criteria!=null && search_criteria.equals("E"))
			sql.append(" and Upper(long_desc) LIKE Upper('%"+specialty_desc_text+"')");
		
		sql.append("  union all select '"+term_set_id+"',a.specialty_code specialty_code,b.long_desc specialty_desc, 'U' db_action from mr_term_set_for_specialty a, am_speciality b where a.term_set_id ='"+term_set_id+"' and b.speciality_code = a.specialty_code ");

		if(specialty_desc_text!=null && !specialty_desc_text.equals("") && search_criteria!=null && search_criteria.equals("S"))
			sql.append(" and Upper(b.long_desc) LIKE Upper('"+specialty_desc_text+"%')");
		else if(specialty_desc_text!=null && !specialty_desc_text.equals("") && search_criteria!=null && search_criteria.equals("C"))
			sql.append(" and Upper(b.long_desc) LIKE Upper('%"+specialty_desc_text+"%')");
		else if(specialty_desc_text!=null && !specialty_desc_text.equals("") && search_criteria!=null && search_criteria.equals("E"))
			sql.append(" and Upper(b.long_desc) LIKE Upper('%"+specialty_desc_text+"')");
		sql.append("  order by 3");	

		//String sql="select '"+term_set_id+"',speciality_code  specialty_code,long_desc specialty_desc ,'I' db_action from am_speciality where speciality_code not in (select specialty_code from mr_term_set_for_specialty where term_set_id = '"+term_set_id+"') union all select '"+term_set_id+"',a.specialty_code specialty_code,b.long_desc specialty_desc, 'U' db_action from mr_term_set_for_specialty a, am_speciality b where a.term_set_id ='"+term_set_id+"' and b.speciality_code = a.specialty_code order by 3";

	
			
		try{
			//stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql.toString());
			//rs.last();
			//maxRecord = rs.getRow();
			//rs.beforeFirst();
		}catch(Exception e){/* out.println(e); */e.printStackTrace();}

		if (start != 0){
				    for(int j=1; j<=start; i++,j++){
					rs.next() ;
				     }
				    }

		while(i<=end && rs.next()){ 
			if(maxRecord == 0)
			{


            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(start));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(end));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(start));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(end));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(start));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(end));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(specialty_desc_text));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(selectchkALL));
            _bw.write(_wl_block19Bytes, _wl_block19);

	
		if ( !(start <= 1)) {
		out.println("<td align ='right' id='prev' class='BODYCOLORFILLED'><a href='javascript:submitPrevNext("+(start-12)+","+(end-12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a></td>");

            _bw.write(_wl_block20Bytes, _wl_block20);

    }
    //if ( !((start+12) >= maxRecord )){
		out.println("<td align ='right' id='next' style='visibility:hidden' class='BODYCOLORFILLED'><a href='javascript:submitPrevNext("+(start+12)+","+(end+12)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a></td>");

            _bw.write(_wl_block21Bytes, _wl_block21);

   // }

            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(selectchkALLChk));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(start));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(end));
            _bw.write(_wl_block26Bytes, _wl_block26);
	 
			}
		//recordCount =TerminologyForSpecialty.getSize();
		/*if (start != 0){
				    for(int j=1; j<=start; i++,j++){
					rs.next() ;
				     }
				    }*/
			//while(rs.next() && i<=end){ 
			String specialty_code=rs.getString("specialty_code");
						
			String specialty_desc=rs.getString("specialty_desc");
			

			if(TerminologyForSpecialty.containsObject(specialty_code)) 
				{
				chkAttribute = "CHECKED";
			
				}
			else
				{
			chkAttribute="";
		
				}

			int recordIndex = TerminologyForSpecialty.indexOfObject(specialty_code);
			if(recordIndex!=-1)
			if(chkAttribute.equals("CHECKED"))    TerminologyForSpecialty.removeObject(recordIndex);
	
	
				if( i%2 == 0)  classValue="QRYEVEN";
				else
				classValue="QRYODD";
				
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(specialty_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block39Bytes, _wl_block39);

			i++;
			maxRecord++;
		}			
			if ( maxRecord < 12 || (!rs.next()) )
				{
					
            _bw.write(_wl_block40Bytes, _wl_block40);
 
				}
				else
				{
            _bw.write(_wl_block41Bytes, _wl_block41);

				}

				if(maxRecord == 0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));parent.frames[1].location.href='../../eCommon/html/blank.html';</script>");
				}

			 }
			  catch(Exception e){/* out.print(e); */e.printStackTrace();}
			  finally
			  {
				  // Added on 25/07/2003 for closing ResultSet & Statements which are not closed Properly.
							 if(rs != null){ rs.close(); }
							  if(rstlRs3 != null){ rstlRs3.close(); }
				            if(stmt != null){ stmt.close(); }
				   		    if(stmt3 != null){ stmt3.close(); }
					    
// End of Addition on 25/07/2003 for closing ResultSet & Statements which are not closed properly.
				ConnectionManager.returnConnection(con,request);
				session.setAttribute("TerminologyForSpecialty", TerminologyForSpecialty);

			  }
            _bw.write(_wl_block42Bytes, _wl_block42);
            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.selectall.label", java.lang.String .class,"key"));
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
}
