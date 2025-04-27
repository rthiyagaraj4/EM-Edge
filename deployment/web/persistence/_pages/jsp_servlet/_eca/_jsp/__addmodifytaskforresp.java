package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifytaskforresp extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/AddModifyTaskForResp.jsp", 1709115441952L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\n<script language=\'javascript\' src=\'../js/TaskForResp.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nfunction PopulateValues()\n{\n\tdelete_values(parent.frames[1].document.forms[0].pract_reln_id,parent.frames[1].document.forms[0].facility_id);\n\tvar resp_id=document.forms[0].resp_id.value;\n\tvar HTMLVal = \"<HTML><HEAD><link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' /></HEAD><BODY onKeyDown=\'lockKey()\' CLASS=\'MESSAGE\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'PopulateTaskForResp.jsp?resp_id=\"+resp_id+\"\'></form></BODY></HTML>\";\n\tparent.messageFrame.document.write(HTMLVal);\n\tparent.messageFrame.document.forms[0].submit();\n}\n   function delete_values(field,facil)\n\t{\n\t\t\tvar selected = field;\n\t\t\tvar facility =facil;\n\t\t\twhile ( selected.options.length > 0 )\n\t\t\t{\n\t\t\t\tselected.remove(selected.options[0]);\n\t\t\t}\n\t\t\twhile(facility.options.length > 0)\n\t\t\t{\n\t\t\t\tfacility.remove(facility.options[0]);\n\t\t\t}\n\t\t\tvar opt=parent.frames[1].document.createElement(\"Option\");\n\t\t\topt.text=\"------------Select------------\"\n\t\t\topt.value=\"\";\n\t\t\tfield.add(opt);\n\t\t\tvar opt1=parent.frames[1].document.createElement(\"Option\");\n\t\t\topt1.text=\"------------Select------------\"\n\t\t\topt1.value=\"\";\n\t\t\tfacil.add(opt1);\n\t}\n</script>\n</head>\n<body  class=\'CONTENT\' OnMouseDown=\'CodeArrest()\'  onKeyDown =\'lockKey()\' onload=\'FocusFirstElement()\'>\n<form name=\"TaskForResp_form\" id=\"TaskForResp_form\" action=\"../../servlet/eCA.TaskForRespServlet\" method=\"post\" target=\"messageFrame\">\n<br><br><br><br><br><br><br><br>\n<table border=0 cellspacing=0 cellpadding=0 width=\'85%\' align=center>\n<tr>\n\t<td width=\'35%\'>&nbsp;</td>\n\t<td width=\'65%\'>&nbsp;</td>\n</tr>\n<tr>\n\t<td class=label align=right>Task</td>\n\t<td align=left>&nbsp;<select name=appl_task_id ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =">\n\t<option value=\'\'>------------------------------------Select------------------------------------</option>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t</select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></td>\n</tr>\n<tr><td>&nbsp</td><td></td></tr>\n\t<tr>\n\t<td class=label align=right>Responsibility</td>\n\t<td align=left>&nbsp;<select name=resp_id onchange=\'PopulateValues()\'%=dis%>>\n\t<option value=\'\'>------------------Select------------------</option>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t</select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></td>\n</tr>\n<tr><td>&nbsp</td><td></td></tr>\n\t<tr>\n\t<td class=label align=right>Relationship</td>\n\t<td align=left class=label>&nbsp;<select name=pract_reln_id>\n\t<option value=\'\'>------Select------</option>\t\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t</select></td>\n</tr>\n<tr><td>&nbsp</td><td></td></tr>\n<tr>\n\t<td class=label align=right>Facility</td>\n\t<td align=left class=label>&nbsp;<select name=facility_id>\n\t<option value=\'\'>------Select------</option>\t\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t</select></td>\n</tr>\n<tr><td>&nbsp</td><td></td></tr>\n<tr>\n\t<td class=label align=right>Applicable</td>\n\t<td align=left class=label><input type=\"checkbox\" name=\"enabled\" id=\"enabled\" value=\'A\' ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" ></td>\n</tr>\n<tr>\n\t<td width=\'35%\'>&nbsp;</td>\n\t<td width=\'65%\'>&nbsp;</td>\n</tr>\n</table>\n<input type=hidden name=mode value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n<input type=hidden name=appl_task_id1 value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n<input type=hidden name=srl_no value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
Connection con=null;


String sql="";

String resp_id="";
String pract_reln_id="";
String facility_id="";
String privilege_status="";

String dis="";
String mode="";
String enable_checked="";

String srl_no=request.getParameter("srl_no");
if(srl_no==null) srl_no="";

String appl_task_id=request.getParameter("appl_task_id");
if(appl_task_id==null) 
{
	appl_task_id="";
	mode="insert";
	enable_checked="checked";
}
else
	mode="modify";

try
{
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	con=ConnectionManager.getConnection(request);
 if(!mode.equals("insert"))
	{
		dis="disabled";
		sql=" Select  appl_task_id, resp_id, pract_reln_id, facility_id, privilege_status from ca_appl_task_for_resp_reln where appl_task_id=? and srl_no=? ";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,appl_task_id);
		pstmt.setString(2,srl_no);

		rs=pstmt.executeQuery();
		if(rs!=null)
		{
			while(rs.next())
			{
				appl_task_id=rs.getString("appl_task_id");
				resp_id=rs.getString("resp_id");
				pract_reln_id=rs.getString("pract_reln_id");
				if(pract_reln_id==null) pract_reln_id="";
				facility_id=rs.getString("facility_id");
				if(facility_id==null) facility_id="";
				
				privilege_status=rs.getString("privilege_status");
				if(privilege_status.equals("A"))
					enable_checked="checked";
				else 
				{
					enable_checked="";
				}
			}
		}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	}

            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block9Bytes, _wl_block9);

		PreparedStatement stmt1=null;
		ResultSet rs1=null;
		String id="";
		String dat="";
		String sel="";
		try
		{
			String  sql1=" Select appl_task_desc, appl_task_id from ca_appl_task where SPLTY_SPEC_YN = 'N'  order by 1 ";
			stmt1=con.prepareStatement(sql1);
			rs1=stmt1.executeQuery();
			if(rs1!=null)
			{
				while(rs1.next())
				{
					dat=rs1.getString(1);
					id=rs1.getString(2);
					if(id.equals(appl_task_id))
						sel="selected";
					out.println("<option value='"+id+"' "+sel+">"+dat+"</option>");
					sel="";
				}
			}
		if(rs1!=null) rs1.close();
		if(stmt1!=null) stmt1.close();
		}
		catch(Exception e){
			//out.println("Exception in AddModifyTaskForResp.jsp"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		
	
            _bw.write(_wl_block10Bytes, _wl_block10);

		ResultSet rs2=null;
		String id2="";
		String dat2="";
		String sel2="";
		try
		{
			String  sql2=" Select resp_name,resp_id from sm_resp where eff_status='E' and nvl(eff_date_from,trunc(sysdate))<=trunc(sysdate) and nvl(eff_date_to,trunc(sysdate))>=trunc(sysdate) order by resp_name ";
			stmt1=con.prepareStatement(sql2);
			rs2=stmt1.executeQuery();
			if(rs2!=null)
			{
				while(rs2.next())
				{
					dat2=rs2.getString(1);
					id2=rs2.getString(2);
					if(id2.equals(resp_id))
						sel2="selected";
					out.println("<option value='"+id2+"' "+sel2+">"+dat2+"</option>");
					sel2="";
				}
			}
		
		if(rs2!=null) rs2.close();
		if(stmt1!=null) stmt1.close();
		}
		catch(Exception e){
			//out.println("Exception in AddModifyTaskForResp.jsp"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		
	
            _bw.write(_wl_block11Bytes, _wl_block11);
if (mode.equals("modify")){
	try{
					sql=" Select pract_reln_id, pract_reln_name from ca_pract_reln_for_resp_vw where resp_id=?  order by 2 ";
					
			stmt1=con.prepareStatement(sql);
			stmt1.setString(1,resp_id);
			rs2=stmt1.executeQuery();
			if(rs2!=null)
			{
				while(rs2.next())
				{
					dat2=rs2.getString(2);
					id2=rs2.getString(1);
					if(id2.equals(pract_reln_id))
						sel2="selected";
					out.println("<option value='"+id2+"' "+sel2+">"+dat2+"</option>");
					sel2="";
				}
			}
		if(rs2!=null) rs2.close();
		if(stmt1!=null) stmt1.close();
		}
		catch(Exception e){
			//out.println("Exception in AddModifyTaskForResp.jsp"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		
	}
            _bw.write(_wl_block12Bytes, _wl_block12);

	if (mode.equals("modify")){out.println("here");
		try{
			String	sql1=" Select a.facility_id, b.facility_name from sm_facility_for_resp a, sm_facility_param b where a.facility_id=b.facility_id and a.resp_id= ? order by 2 ";

			stmt1=con.prepareStatement(sql1);
			stmt1.setString(1,resp_id);
			rs2=stmt1.executeQuery();
			if(rs2!=null){
				while(rs2.next()){
					id2=rs2.getString(1);
					dat2=rs2.getString(2);
					if(id2.equals(facility_id))
						sel2="selected";
					out.println("<option value='"+id2+"' "+sel2+">"+dat2+"</option>");
					sel2="";
				}
			}
		
		if(rs2!=null) rs2.close();
		if(stmt1!=null) stmt1.close();
		}catch(Exception e){
			//out.println("Exception in AddModifyTaskForResp.jsp"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
	}
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(enable_checked));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block17Bytes, _wl_block17);

	
	
}
catch(Exception e){
	//out.println("Exception in AddModifyTaskForResp.jsp"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

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
