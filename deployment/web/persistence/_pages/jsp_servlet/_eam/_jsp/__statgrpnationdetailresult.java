package jsp_servlet._eam._jsp;

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

public final class __statgrpnationdetailresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/StatGrpNationDetailresult.jsp", 1713265654922L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n</head>\n<script Language=\"JavaScript\">\nfunction callMember(alpha)\n{\n\tif(document.statgrpdtlquery.stat_grp_id.value.length !=0)\n\t{\n\t\tdocument.statgrpdtlquery.alphabet.value=alpha;\n\t\tdocument.statgrpdtlquery.dtl_flag.value=\'insert\';\n\t\tdocument.statgrpdtlquery.submit();\n\t\n\t}\n\telse\n\t{\n\t\tparent.parent.messageFrame.location.href=\'../../eCommon/jsp/MstCodeError.jsp?err_num=APP-000001 Statistics Group cannot be blank...\'\n\t}\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' >\n\t<form name=\'stat_grp_nation_detail_result_form\' id=\'stat_grp_nation_detail_result_form\'>\n\t\t<input type =\'hidden\' name =\'stat_grp_id\' id =\'stat_grp_id\' value =\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'>\n\t    <input type =\'hidden\' name =\'alphabet\' id =\'alphabet\' value =\' \'>\n\t    <input type =\'hidden\' name =\'dtl_flag\' id =\'dtl_flag\' value =\' \'>\n\t    <input type =\'hidden\' name =\'totprvrec\' id =\'totprvrec\' value =\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'>\n\t    <table cellspacing=0 cellpadding=0 width=\'100%\' border=1>\n\t\t\t<tr>\n\t\t\t\t<th align=\'left\' width=\'70%\'><fmt:message key=\"Common.Member.label\" bundle=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"/></th>\n\t\t\t\t<th align=\'center\' width=\'30%\'><fmt:message key=\"Common.Include.label\" bundle=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"/></th>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="                          \n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'><input type=\'hidden\' name=code";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" id=code";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" </td>\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' align=\'center\'><input type=\'checkbox\' ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" name=\'inc";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'  id=\'inc";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'></td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"prev_select";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" id=\"prev_select";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n        \n\t\t</table>\n\t\t</form>\n\t\t<form name=\'stat_grp_nation_detail_result_form1\' id=\'stat_grp_nation_detail_result_form1\'  method=\'post\' target=\'parent.parent.messageFrame\'>\n\t\t<input type=\'hidden\' name=\'maxrecord\' id=\'maxrecord\' value=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" >\n\t\t<input type=\'hidden\' name=\'insert_to_db\' id=\'insert_to_db\' value=\'\' >\n\t\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'insert\' >\n\t\t</form>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

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

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
 
String sql="";
String country_name="";
//int maxrec=0;
Hashtable statNationalRecSet= null;
Connection con=null;
try {
 con = ConnectionManager.getConnection(request);
statNationalRecSet=(Hashtable)session.getValue("StatNationalId");
if(statNationalRecSet==null)
{
	statNationalRecSet=new Hashtable();
}

	ResultSet rset=null ;
	Statement stmt=null;
	Statement stmt1=null;
	ResultSet rset1=null ;

	PreparedStatement pstmt1=null;


try{
	
	request.setCharacterEncoding("UTF-8");	
	String param=request.getParameter("param");
	if( param == null) param="";
	int maxrecord=0;
    int totprvrec=0;
	String classValue="";
	String totprvrec1=request.getParameter("totprvrec");
    if(totprvrec1 == null)	totprvrec=0;
	else totprvrec = Integer.parseInt(totprvrec1) ;
	
	String stat_grp_id=request.getParameter("stat_grp_id");
	if( stat_grp_id == null) stat_grp_id="";

	String category=request.getParameter("category");
	if(category == null) category="";

	
	if(!param.equals(""))
	{
		
		if( param.equals("Others"))
		{
			 if(category.equals("S"))
			{
				
				sql="SELECT   b.SERVICE_CODE country_code, NVL (a.member_id, '!'),     b.short_desc long_name, 'Y' cnt  FROM am_stat_grp_detail a, am_service b  WHERE b.SERVICE_CODE = a.member_id  AND a.stat_grp_id = '"+stat_grp_id+"' AND UPPER (substr(b.short_desc,1,1)) not between 'A' and 'Z'	UNION SELECT  SERVICE_CODE country_code, NULL member_id, short_desc long_name,'N' cnt FROM am_service WHERE eff_status = 'E' AND SERVICE_CODE NOT IN (SELECT member_id  FROM am_stat_grp_detail WHERE stat_grp_id = '"+stat_grp_id+"') AND UPPER (short_desc) like '"+param+"%' ORDER BY long_name";
			
			 
			}
			else if(category.equals("N"))
			{
				//Commented on 12/16/2008 by viswanath.b

				//sql="SELECT   b.country_code country_code, NVL (a.member_id, '!'),     b.long_desc long_name, 'Y' cnt  FROM am_stat_grp_detail a, mp_country b  WHERE b.country_code = a.member_id  AND a.stat_grp_id = '"+stat_grp_id+"' AND UPPER (substr(b.long_desc,1,1)) not between 'A' and 'Z' UNION SELECT  country_code country_code, NULL member_id, long_desc long_name,'N' cnt FROM mp_country WHERE eff_status = 'E' AND country_code NOT IN (SELECT member_id  FROM am_stat_grp_detail WHERE stat_grp_id = '"+stat_grp_id+"') AND UPPER (long_desc) like '"+param+"%' ORDER BY long_name";

				sql ="SELECT   b.country_code, NVL (a.member_id, '!'), b.long_name long_name, DECODE(NVL (a.member_id, '!'),'!','N','Y') cnt  FROM am_stat_grp_detail a, mp_country b WHERE b.country_code = a.member_id(+) AND b.eff_status = 'E' AND a.stat_grp_id(+) = '"+stat_grp_id+"' AND UPPER (SUBSTR (b.long_name, 1, 1)) NOT BETWEEN 'A' AND 'Z'   AND b.country_code NOT IN (SELECT member_id FROM am_stat_grp_detail  WHERE stat_grp_id <>'"+stat_grp_id+"')  ORDER BY b.long_name";

				
			
			}
			else if(category.equals("P"))
			{
				
                sql="SELECT   b.SPECIALITY_CODE country_code, NVL (a.member_id, '!'),     b.short_desc long_name, 'Y' cnt  FROM am_stat_grp_detail a, am_speciality b  WHERE b.SPECIALITY_CODE = a.member_id  AND a.stat_grp_id = '"+stat_grp_id+"' AND UPPER (substr(b.short_desc,1,1)) not between 'A' and 'Z'  UNION SELECT   speciality_code country_code, NULL member_id, short_desc long_name,'N' cnt FROM am_speciality WHERE eff_status = 'E' AND speciality_code NOT IN (SELECT member_id  FROM am_stat_grp_detail WHERE stat_grp_id = '"+stat_grp_id+"') AND UPPER (short_desc) like '"+param+"%' ORDER BY long_name";
				
			}

		}
		else
		{
			 if(category.equals("S"))
			{
		
				sql="SELECT   b.SERVICE_CODE country_code, NVL (a.member_id, '!'),     b.short_desc long_name, 'Y' cnt  FROM am_stat_grp_detail a, am_service b  WHERE b.SERVICE_CODE = a.member_id  AND a.stat_grp_id = '"+stat_grp_id+"' AND UPPER (b.short_desc) like '"+param+"%'			UNION SELECT  SERVICE_CODE country_code, NULL member_id, short_desc long_name,'N' cnt FROM am_service WHERE eff_status = 'E' AND SERVICE_CODE NOT IN (SELECT member_id  FROM am_stat_grp_detail WHERE stat_grp_id = '"+stat_grp_id+"') AND UPPER (short_desc) like '"+param+"%' ORDER BY long_name";
				
			}
			else  if(category.equals("N"))
			{
			//Commented on 12/16/2008 by viswanath.b
		
			//sql="SELECT   b.country_code country_code, NVL (a.member_id, '!'),     b.long_desc long_name, 'Y' cnt  FROM am_stat_grp_detail a, mp_country b  WHERE b.country_code = a.member_id  AND a.stat_grp_id = '"+stat_grp_id+"' AND UPPER (b.long_desc) like '"+param+"%' UNION SELECT   country_code country_code, NULL member_id, long_desc long_name,'N' cnt FROM mp_country WHERE eff_status = 'E' AND country_code NOT IN (SELECT member_id  FROM am_stat_grp_detail WHERE stat_grp_id = '"+stat_grp_id+"') AND UPPER (long_desc) like '"+param+"%' ORDER BY long_name";

			sql = "SELECT   b.country_code, NVL (a.member_id, '!'), b.long_name long_name,DECODE(NVL (a.member_id, '!'),'!','N','Y' )cnt FROM am_stat_grp_detail a, mp_country b WHERE b.country_code = a.member_id(+) AND b.eff_status = 'E' AND a.stat_grp_id(+) = '"+stat_grp_id+"' AND UPPER (b.long_name) LIKE'"+param+"%'  AND b.country_code NOT IN (SELECT member_id FROM am_stat_grp_detail WHERE stat_grp_id <> '"+stat_grp_id+"') ORDER BY b.long_name";
					
			
			}
			else  if(category.equals("P"))
			{
				
			
					sql="SELECT   b.SPECIALITY_CODE country_code, NVL (a.member_id, '!'),     b.short_desc long_name, 'Y' cnt  FROM am_stat_grp_detail a, am_speciality b  WHERE b.SPECIALITY_CODE = a.member_id  AND a.stat_grp_id = '"+stat_grp_id+"' AND UPPER (b.short_desc) like '"+param+"%' UNION SELECT   speciality_code country_code, NULL member_id, short_desc long_name,'N' cnt FROM am_speciality WHERE eff_status = 'E' AND speciality_code NOT IN (SELECT member_id  FROM am_stat_grp_detail WHERE stat_grp_id = '"+stat_grp_id+"') AND UPPER (short_desc) like '"+param+"%' ORDER BY long_name";
				
			  
		  }
	  }
	}
	
	stmt			            = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rset=stmt.executeQuery(sql);
	rset.last();
	maxrecord = rset.getRow();
	rset.beforeFirst();
	int i=0;
	if(maxrecord!=0){
    

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(stat_grp_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(maxrecord));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
 
				String chkAttribute="";
                 String cnt="";
			
			    if(rset!=null)
				{
					while(rset.next())
					{
						country_name=rset.getString("LONG_NAME");
						cnt=rset.getString("cnt");
						if(cnt.equals("Y"))
							chkAttribute = "CHECKED";						
						else
								chkAttribute="";
						if ( (i+1) % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;
						
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(rset.getString(1)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rset.getString("long_name")));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(country_name));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(chkAttribute));
            _bw.write(_wl_block22Bytes, _wl_block22);
	
					i++;
				}
			}
	}
			if(maxrecord==0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				}
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(maxrecord));
            _bw.write(_wl_block24Bytes, _wl_block24);




} catch(Exception e){out.println("here: ");out.println(e); } 
finally
{
	try{
	if (rset != null)   rset.close();
	if (rset1 != null)  rset1.close();
	if (stmt != null)   stmt.close();
	if (stmt1 != null)  stmt1.close();
    if(pstmt1!=null)  pstmt1.close(); 
	}
	catch(Exception e)
	{}
	
	
}

}
catch(Exception e) { out.println(e);}
	finally{
		try{
	
		}
		catch(Exception e)
		{}
	ConnectionManager.returnConnection(con,request);
	}


            _bw.write(_wl_block25Bytes, _wl_block25);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
