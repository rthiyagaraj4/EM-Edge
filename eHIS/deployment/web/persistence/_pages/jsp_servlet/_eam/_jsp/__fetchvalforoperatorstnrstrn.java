package jsp_servlet._eam._jsp;

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

public final class __fetchvalforoperatorstnrstrn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/FetchValForOperatorStnRstrn.jsp", 1710448375442L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<script language=\"JavaScript\">\n\t\t\tvar f=parent.parent.frames[1].frames[0]\n\t\t</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\t\tvar opt=f.document.createElement(\"OPTION\");\n\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\tvar comp2=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t//comp2.add(opt)\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\t\t\t\n\t\t\t\t<script>\n\t\t\t\t\tvar oOption = f.document.createElement(\"OPTION\");\n\t\t\t\t\toOption.text =\t\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\t\toOption.value=\t\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t\t\tf.document.getElementById(\'locationtype\').add(oOption);\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<script>\n\n\t\t\tvar temp = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\tvar opt=f.document.createElement(\"OPTION\");\n\t\t\topt.text=temp1;\n\t\t\topt.value=temp;\n\t\t\tvar comp=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\tcomp.add(opt)\n\t</script>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n<script language=\"JavaScript\">\n\nvar f=parent.parent.frames[1].frames[0]\n//var f = parent.frames[1].frames[0];\n\n\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<script>\n\t                  \n\t\t\t\t\tvar opt =f.document.createElement(\"OPTION\");\n\t\t\t\t\t\n\t\t\t\t\t//opt=parent.frames[1].frames[1].document.createElement(\"OPTION\");\n\t\t\t\t   \topt.text=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\';\n\t\t\t\t    opt.value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\';\n\t\t\t\t\tf.document.getElementById(\'oprstnid\').add(opt);\n\t\t         </script>\n         ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n</html>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

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
 String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
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
request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String sql="";
	Connection con =null;
	Statement stmt = null;
	Statement stmt2 = null;
	Statement st=null;
	ResultSet rset=null;
	ResultSet rset1=null;
	
	ResultSet rs=null;
	Statement stm= null;
	
	ResultSet rset2=null;
	String code="";
	String desc="";
	String fid=request.getParameter("fid")==null?"":request.getParameter("fid");
	
	con =ConnectionManager.getConnection(request);
    if( !(fid.trim().equals("")))
	{	
            _bw.write(_wl_block7Bytes, _wl_block7);
	try
	{     
		String name=request.getParameter("name");
		String value=request.getParameter("value");
		String locationtype=request.getParameter("locationtype");
		String oid=request.getParameter("oprstn");
		String comp=" ";
		String comp2=" ";
		StringBuffer sql1=new StringBuffer();
		String sel=request.getParameter("selval");
    
		stmt = con.createStatement();
		stmt2 = con.createStatement();
		st=con.createStatement();
	
		if(name!=null)
			name=name.trim();

		if(fid!=null)
			fid=fid.trim();

		if(sel!=null)
			sel=sel.trim();
			
		if(name.equals("oprstnid"))
		{			
			comp="f.document.forms[0].locationtype";
	
			sql1.append(" select a.appl_user_id user_id,b.appl_user_name user_name from ");
			sql1.append(" am_user_for_oper_stn a, sm_appl_user b      ");
			sql1.append(" where a.appl_user_id = b.appl_user_id	     ");	
			sql1.append(" and a.oper_stn_id='"+oid+"' and a.facility_id='"+fid+"' and trunc(sysdate) between trunc(a.eff_date_from) and trunc(nvl(a.eff_date_to,sysdate)) order by 2 ");

			String sql2=" SELECT oper_stn_type FROM  am_oper_stn WHERE  facility_id='"+fid+"' and  oper_stn_id ='"+oid+"' ";
			stm=con.createStatement();
			rs=stm.executeQuery(sql2);
			rs.next();
			String operation_stn_type = rs.getString("oper_stn_type");
			if(operation_stn_type == null) operation_stn_type="";

			if (rs != null)   rs.close();
            if (stm != null) stm.close();

			rset2= stmt2.executeQuery(sql1.toString());

			comp2="f.document.forms[0].user";
			out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'>");
			
			
			if(rset2 != null)
			{
				while( rset2.next() )
				{
					code=rset2.getString(1);
					desc=rset2.getString(2);
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(comp2));
            _bw.write(_wl_block11Bytes, _wl_block11);

					}
				out.println("<script>parent.parent.frames[1].frames[0].document.forms[0].operation_stn_type.value='"+operation_stn_type+"' </script>");
			}

			if (rset2 != null)   rset2.close();
            if (stmt2 != null) stmt2.close();
/*
			String instring = "";
			if(oper_stn_type.equals("I"))
				 instring = "N";
			else if(oper_stn_type.equals("O"))
				instring = "C','D','E";
			else
				instring = "C','N','D','E";
			 String locntypesql = " SELECT   CARE_LOCN_TYPE_IND||'#'||LOCN_TYPE locn_type, SHORT_DESC from am_care_locn_type where CARE_LOCN_TYPE_IND in ('"+instring+"') order by 2 ";
*/
			String locntypesql = "";
			if (operation_stn_type.equals("O"))
			{					
				locntypesql = " select locn_type, short_desc from am_care_locn_type where sys_user_def_ind  = 'S' and locn_type in ('C','E','Y') order by upper(short_desc) ";
			}
			else if (operation_stn_type.equals("I"))
			{
				locntypesql = " select locn_type, short_desc from am_care_locn_type where sys_user_def_ind  = 'S' and locn_type in ('N') order by upper(short_desc) ";
			}
			else if (operation_stn_type.equals("B"))
			{
				locntypesql = " select locn_type, short_desc from am_care_locn_type where sys_user_def_ind  = 'S' and locn_type in ('C','E','Y','N') order by upper(short_desc) ";
			}
			
			if(stmt2 != null )stmt2.close();
			if(rset2 != null )rset2.close();
			stmt2 = con.createStatement();
			rset2= stmt2.executeQuery(locntypesql);
			while(rset2.next())
			{	
				
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(rset2.getString("SHORT_DESC")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rset2.getString("LOCN_TYPE")));
            _bw.write(_wl_block14Bytes, _wl_block14);

			}
			
			 if (rset2 != null)   rset2.close();
             if (stmt2 != null) stmt2.close();
		}
		
		
		if(name.equals("locationtype"))
		{
			sql="select CARE_LOCN_TYPE_IND  from am_care_locn_type where LOCN_TYPE ='"+value+"'";
			String ind= "";
			rset1=st.executeQuery(sql);
			if(rset1.next())
				ind=rset1.getString("CARE_LOCN_TYPE_IND");
			
			if (rset1 != null)   rset1.close();
            if (st != null) st.close();

			if(ind.equals("R"))
				sql=" Select room_num,short_desc from am_facility_room where operating_facility_id = '"+fid+"' and RESIDENT_STAY_YN = 'N'  and ROOM_TYPE='"+locationtype+"' order by short_desc";

			else if(ind.equals("C"))
				sql="Select clinic_code,long_desc from op_clinic where facility_id = '"+fid+"' and clinic_type='"+locationtype+"' and eff_status = 'E' order by long_desc";
			
			else if (ind.equalsIgnoreCase("N"))
				sql="Select NURSING_UNIT_CODE,long_desc from  ip_nursing_unit where facility_id = '"+fid+"' and eff_status = 'E' and locn_type='"+locationtype+"' order by long_desc";
			
			else if (ind.equalsIgnoreCase("S"))
				sql="Select store_code,short_desc from  st_store  where facility_id = '"+fid+"' and eff_status = 'E'  order by short_desc";

			comp="f.document.forms[0].locationid";
		}

		if(sql!=null && !sql.equals(""))
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);

		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
		if(rset != null)
		{
		while( rset.next() )
		{
			code=rset.getString(1);
			desc=rset.getString(2);

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(comp));
            _bw.write(_wl_block18Bytes, _wl_block18);

		}
		}
		if (rset1 != null)   rset1.close();
        if (stmt != null) stmt.close();
	}
	catch(Exception e){e.toString();}

	finally {
	  if (stmt != null) stmt.close();
	  if (rset != null)   rset.close();
	  if (rset1 != null)   rset1.close();
	  if(st !=null) stm.close();
	  if(rs !=null) rs.close();
	 ConnectionManager.returnConnection(con,request);
	}
	}
	else
	{
        
	

            _bw.write(_wl_block19Bytes, _wl_block19);

	
	
	String facid="";
   String	oper_stn_id="";
  String	short_desc="";
   String stb="";
	try
	{
	  //con = ConnectionManager.getConnection(request);
	   stmt = con.createStatement();
			facid=request.getParameter("facid")==null?"":request.getParameter("facid");
	      	
     	   stb= "SELECT oper_stn_id,short_desc  from  am_oper_stn where  facility_id = '"+facid+"' and eff_status= 'E' order by short_desc ";
        
		   rs = stmt.executeQuery(stb) ;
		   	if(rs!=null)
			    {
					while (rs.next())
					{			
                
						 oper_stn_id = rs.getString(1);	
						 if(oper_stn_id==null) oper_stn_id="";
						 
				 
						 short_desc = rs.getString(2);
						 if(short_desc==null) short_desc="";
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
		}
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		finally
		{
			ConnectionManager.returnConnection(con,request); 
		}
		
	
	}
	
            _bw.write(_wl_block23Bytes, _wl_block23);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
