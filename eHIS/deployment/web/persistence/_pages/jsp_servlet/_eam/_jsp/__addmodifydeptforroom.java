package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifydeptforroom extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/addmodifyDeptforroom.jsp", 1711622961657L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n<head>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eAM/js/Deptforroom.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\n\t  var sStyle=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\nfunction PopService(nam,code){\n\t\t if(nam==\"department\")\n\t\t {\n\t\t\t\tvar fnval=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\tif (fnval == \"insert\")\n\t\t\t\t\tvar n=parent.f_query_add_mod.document.getElementById(\'service\').length;\n\t\t\t\telse\n\t\t\t\t\tvar n=1;\n\n\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t{\n\t\t\t\t\tparent.f_query_add_mod.document.getElementById(\'service\').remove(\"service\");\n\t\t\t\t}\n\n\t\t\t\tvar HTMLVal = new String();\n\t\t\t\tHTMLVal = \"<HTML><HEAD>\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/\"+sStyle+\"\'></link></HEAD><BODY CLASS=\'MESSAGE\' onKeyDown = \'lockKey()\'><form name=\'dum_form\' id=\'dum_form\' method=\'post\' action=\'../../eAM/jsp/GetDeptRoom.jsp?Chksrc=\"+nam+\"\'><input name=\'Common_Text\' id=\'Common_Text\' type=\'hidden\' value=\'\"+document.getElementById(\"department\").value+\"\'><input name=\'Service_code\' id=\'Service_code\' type=\'hidden\' value=\'\"+code +\"\'></form></BODY></HTML>\";\n\t\t\t\tparent.messageFrame.document.write(HTMLVal);\n\t\t\t\tparent.messageFrame.document.dum_form.submit();\n\t\t }\n\n}\n\nfunction clear()\n{\n\t\t\tvar a=DeptRoom_form.service.length;\n\t\t\tfor(var i=0;i<=a;i++)\n\t\t\t{\n\t\t\t\tDeptRoom_form.service.remove(\"service\");\n\t\t\t}\n\n\t\t\tvar tp =\"\";\n\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\topt.text=tp;\n\t\t\topt.value=\"\";\n\n}\nfunction populateDeptRoom(Obj)\n{\n\t\t\n\t\tvar n=parent.f_query_add_mod.document.getElementById(\"room\").options.length;\n\t\tfor(var i=0;i<n;i++)\n\t\t{\n\t\t\tparent.f_query_add_mod.document.getElementById(\"room\").remove(\"room\");\n\t\t}\n\t\tvar n=parent.f_query_add_mod.document.getElementById(\"department\").options.length;\n\t\tfor(var i=0;i<n;i++)\n\t\t{\n\t\t\tparent.f_query_add_mod.document.getElementById(\"department\").remove(\"department\");\n\t\t}\n\tif(Obj.value !=\'\')\n\t{\n\t\t\tvar HTMLVal = new String();\n\t\t\tHTMLVal = \"<HTML><HEAD><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/\"+sStyle+\"\'></link></HEAD><BODY CLASS=\'MESSAGE\' onKeyDown = \'lockKey()\'><form name=\'dum_form\' id=\'dum_form\' method=\'post\' action=\'../../eAM/jsp/GetDeptRoom.jsp\'> \"+\n\t\t\t\t\t \" <input name=\'operating_facilityID\' id=\'operating_facilityID\' type=\'hidden\' value=\'\"+Obj.value+\"\'></form></BODY></HTML>\";\n\t\t\tparent.dummy.document.write(HTMLVal);\n\t\t\tparent.dummy.document.dum_form.submit();\n\t}\n\telse\n\t{\n\t\tvar tp =\"-----\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"-----\";\n\t\tvar opt=document.createElement(\"OPTION\");\n\t\topt.text=tp;\n\t\topt.value=\"\";\n\t\tdocument.forms[0].room.add(opt);\n\t\t\n\t\tvar tp1 =\"-----\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"-----\";\n\t\tvar opt1=document.createElement(\"OPTION\");\n\t\topt1.text=tp1;\n\t\topt1.value=\"\";\n\t\tdocument.forms[0].department.add(opt1);\n\t}\n}\n</script>\n</head>\n\n\t<body  OnMouseDown=\"CodeArrest()\"onLoad=\"FocusFirstElement();\" onKeyDown = \'lockKey()\'>\n\t\t<form name=\'DeptRoom_form\' id=\'DeptRoom_form\' action=\'../../servlet/eAM.DeptforroomServlet\' method=\'post\' target=\'messageFrame\'>\n\t\t\t<div>\n\t\t\t<br><br><br><br><br><br><br><br><br><br><br>\n\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'auto\' align=\'center\'>\n\t\t\t<tr>\n\t\t\t\t<td width=\'10%\'>&nbsp;</td>\n\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t<td width=\'10%\'>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\'10%\'>&nbsp;</td>\n\t\t\t\t\t\t<td  class=\'label\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\t\t<td  class=\'fields\'>&nbsp;&nbsp;\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t<select name=\'facility\' id=\'facility\'  onChange=\'populateDeptRoom(this)\'>\n\t\t\t\t\t\t <option >--------------";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="-------------</option>\n    \t\t\t\t       ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n    \t\t\t\t    \t\t   \n\t\t\t\t\t\t  </select>&nbsp;\n\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" \n\t\t\t\t\t\t  <img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'>\n\t\t\t\t\t<td width=\'10%\'>&nbsp;</td>\n\t\t\t\t\t</tr>\n\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\'10%\'>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td width=\'10%\'>&nbsp;</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n    \t\t\t\t<tr>\n    \t\t\t\t     <td>&nbsp;</td>\n    \t\t\t\t     <td class=\'label\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n    \t\t\t\t     <td class=\'fields\'>&nbsp;&nbsp;\n    \t\t\t\t     ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t <select name=\'room\' id=\'room\'>\n\t\t\t\t\t\t\t <option>----------";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="---------</option>\n    \t\t\t\t\n    \t\t\t\t    \t\t  </select>&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'>\n    \t\t\t\t    \t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n    \t\t\t\t   </td>\n    \t\t\t\t   <td>&nbsp;</td>\n    \t\t\t\t</tr>\n    \t\t\t\t<tr>\n    \t\t\t\t\t<td>&nbsp;</td>\n    \t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t</tr>\n\n\t\t\t\t    <tr>\n\t\t\t\t     <td>&nbsp;</td>\n    \t\t\t\t     <td  class=\'label\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n    \t\t\t\t     <td class=\'fields\'>&nbsp;&nbsp;\n    \t\t\t\t      ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n    \t\t\t\t   \t<select name=\'department\' id=\'department\' onChange=\"PopService(\'department\');clear()\">\n    \t\t\t\t   \t<option>----------";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="---------</option>\n    \t\t\t\t    \n    \t\t\t\t    \t </select>&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'>\n    \t\t\t\t  ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n   \t\t\t\t     </td>\n   \t\t\t\t     <td>&nbsp;</td>\n    \t\t\t\t</tr>\n    \t\t\t\t<tr>\n    \t\t\t\t\t<td>&nbsp;</td>\n    \t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t</tr>\n\n\t  \t\t\t\t<tr>\n\t  \t\t\t\t     <td>&nbsp;</td>\n\t    \t\t\t\t     <td class=\'label\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t    \t\t\t\t     <td class=\'fields\'>&nbsp;&nbsp;\n\t    \t\t\t\t     <select name=\'service\' id=\'service\' >\n\t    \t\t\t\t     \t<option>----------";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="---------</option>\n\t    \t\t\t\t     </select>\n\t    \t\t\t\t   \t </td>\n\t    \t\t\t\t   \t <td>&nbsp;</td>\n\t    \t\t\t\t   \t ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t    \t\t\t\t   \t <script>\n\t    \t\t\t\t   \t  \t\tPopService(\"department\",\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\');clear();\n\t    \t\t\t\t   \t </script>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t    \t\t\t\t   \t <script>populateDeptRoom(document.forms[0].facility)</script>\n\t    \t\t\t\t   \t \t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" \n\t    \t\t\t</tr>\n\t    \t\t\t<tr>\n\t    \t\t\t\t<td>&nbsp;</td>\n\t    \t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t</table>\n\t\t</div>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\n\t\t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
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

	request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	request.setCharacterEncoding("UTF-8");
	String facility_name=request.getParameter("facility_name");
		if(facility_name == null) facility_name="";
	String operating_facility_id=request.getParameter("operating_facility_id");
		if(operating_facility_id == null) operating_facility_id="";

	Connection con = null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rset=null ;
	String fnval="insert";
	String roomnum="";
	String rnum="";
	String dcode="";
	String scode="";
	String ofid="";
	String deptcode="";
	
	String shortdesc="";
	String deptdesc="";
	
	java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	String facilityid = (String) session.getValue( "facility_id" ) ;
	String fid=p.getProperty( "login_user" ) ;
	
	String facilityId = request.getParameter("facilityId");
	if(facilityId == null || facilityId.equals(""))   facilityId=facilityid; 


	rnum=request.getParameter("room_num");
	dcode=request.getParameter("dept_code");
	ofid=request.getParameter("operating_facility_id");

	try
	{
		con = ConnectionManager.getConnection(request);
	if(rnum != null )
	{
		fnval="modify";
		pstmt=con.prepareStatement("select * from am_dept_for_facility_room_vw where operating_facility_id=? and dept_code=? and room_num=?");
		pstmt.setString(1,ofid);
		pstmt.setString(2,dcode);
		pstmt.setString(3,rnum);
		rset=pstmt.executeQuery();
		rset.next();
		roomnum=rset.getString("room_num");
		shortdesc=rset.getString("room_short_desc");
		deptcode=rset.getString("dept_code");
		deptdesc=rset.getString("dept_short_desc");
		scode=rset.getString("service_code");

	}

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(fnval));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

						if(fnval.equals("modify"))
						{
						out.println("<input type='text' readOnly name='facility_name' id='facility_name' value=\""+facility_name+"\" size='50'>");
						out.println("<input type='hidden' name='facility' id='facility' value='"+operating_facility_id+"'>");
						
						} else { 
						
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

    				    		String ID="",dat1="",en1="";
    				    	    if(rset!=null)rset.close();
								if(stmt!=null)stmt.close();

								stmt=con.createStatement();
    				    		rset=stmt.executeQuery("Select Facility_id,Facility_name Operating_facility_id from SM_FACILITY_FOR_USER_VW where appl_user_id = '"+fid+"' and  NVL(access_eff_date_to,TO_DATE('31/12/9999','dd/mm/rrrr')) >= TRUNC(SYSDATE) order by facility_name ");
    				    		if(rset!=null)
    				    		{
    				    		   while(rset.next())
    				    		   {
    				    			dat1=rset.getString("Operating_facility_id");
    				    			ID=rset.getString("facility_id");
    				    			if(ID.equals(facilityId))
    				    			  en1="selected";
    				    			else
    				    			    en1="";
    				    			out.println("<option value=\""+ID+ "\" "+en1+">"+dat1+"</option>");

    				    		   }
    				    		   }
    				    		   
            _bw.write(_wl_block14Bytes, _wl_block14);
 } 
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
 if(fnval.equals("modify"))
    				     {
    				     	out.println("<input type='text' name='t' id='t' value=\""+shortdesc+"\" readonly>");
    				     	out.println("<img align='center' src='../../eCommon/images/mandatory.gif'>");
    				    	out.println("<input type='hidden' name='room' id='room' value=\""+roomnum+"\">");

    				     }
    				     else
    				     {
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
 
    				    	}
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

    				      if(fnval.equals("modify"))
				          {
								out.println("<input type='text' name='p' id='p' value=\""+deptdesc+"\"  readonly>");
								out.println("<img align='center' src='../../eCommon/images/mandatory.gif'>");
								out.println("<input type='hidden' name='department' id='department' value=\""+deptcode+"\">");
				          }
    				     else
    				     {
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
}
							  
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
if(fnval.equals("modify")){
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(scode));
            _bw.write(_wl_block27Bytes, _wl_block27);
} else { 
            _bw.write(_wl_block28Bytes, _wl_block28);
 } 
            _bw.write(_wl_block29Bytes, _wl_block29);
}
	catch(Exception e){e.printStackTrace();}

	finally
	{
		try{
	   	  if(rset!=null)	rset.close();
		  if(stmt!=null)	stmt.close();
	   	  if(pstmt!=null)	pstmt.close();
		}
		catch(Exception e)
		{}
		  ConnectionManager.returnConnection(con,request);
	}
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(fnval));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(fnval));
            _bw.write(_wl_block32Bytes, _wl_block32);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.room.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.acctdept.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }
}
