package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __fetchval extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/FetchVal.jsp", 1717579655652L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t<!--\t<script>\n\t\t\t\t\t  var opt=parent.document.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t      opt.text=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n\t\t\t\t\t  opt.value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\t\t\t  parent.document.f_query_add_mod.document.forms[0].clinic.add(opt);\n\t\t\t\t  </script> -->\n                  ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script>\n\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\tvar opt=parent.document.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\topt.text=temp1;\n\t\t\t\topt.value=temp;\n\t\t\t\tvar comp=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\tcomp.add(opt)\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="<script>\tparent.document.f_query_add_mod.document.forms[0].radApplYn.value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';\t</script>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n          <html><HEAD>\n\t\t\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'></link>\n\t\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\t\t</HEAD><body CLASS=\'MESSAGE\' onKeyDown = \'lockKey();\'><form name=\'nam1\' id=\'nam1\'>\n        ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<script>\n\t\t\t\t\t\n\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\tcomp.add(opt)\n\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\tvar opt=parent.document.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\t\tvar temp2 = \"W\";\n\t\t\t\t\tvar temp3=\"EMERGENCY FOLLOW-UP\";\n\t\t\t\t\topt.text=temp3;\n\t\t\t\t\topt.value=temp2;\n\t\t\t\tvar comp=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\tcomp.add(opt)\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\n\t\t\t\t\n\t\t\t\t\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="<script>if(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' == 1){comp.selectedIndex = 1;comp.onchange();}</script>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n            <script> \n\t\t\tparent.document.f_query_add_mod.document.forms[0].max_appt_duration.readOnly = true; parent.document.f_query_add_mod.document.forms[0].max_appt_slots.readOnly = true; \n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t <script>\n\t\t\t   parent.document.f_query_add_mod.document.forms[0].max_appt_duration.readOnly = false; parent.document.f_query_add_mod.document.forms[0].max_appt_slots.readOnly = false;\n\t\t\t </script>\n         ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\n     </form></body></html>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

		request.setCharacterEncoding("UTF-8");
		String sql=null;
		Connection con = null;
		Statement pst=null;
		ResultSet rset=null,prs=null;		
		PreparedStatement pstmt=null;
		
		String clinicLevelOfCare = null;
		String rd_appl_yn = "N";
		try{
		con=ConnectionManager.getConnection(request);
		String code="";
		String desc="";
		String name=request.getParameter("name");
		String value=request.getParameter("value");
		String fid=request.getParameter("fid").trim();
		String ccode=request.getParameter("ccode");
		String radApplYn=request.getParameter("radApplYn");
				
		String comp=" ";
		String func=request.getParameter("function");	
		String sel=request.getParameter("selval");
		String ind = request.getParameter("applind");
		
		String proid=request.getParameter("proid");
		String care_ind=request.getParameter("care_ind");
		String allow_visit_reg=null;
		String vsql="";
		//String lsql="";
		String isAERegisterTypeAutoUpdateAppl = request.getParameter("isAERegisterTypeAutoUpdateAppl"); // added by mujafar for KDAH-CRF-0526
	
		

		pst=con.createStatement();					
	try
	{
		if(name!=null)
			name=name.trim();
			
		if(fid!=null)
			fid=fid.trim();
		if(value!=null)
			value=value.trim();
			
		if(sel!=null)
			sel=sel.trim();
			
		if(ccode!=null)
			ccode=ccode.trim();
		if(!value.equals("")){
			
			/* if(name.equals("location"))
			{
			  
			  if(!value.equals(""))
				{
				  lsql="Select clinic_code, long_desc from op_clinic where (care_locn_type_ind='"+care_ind+"') and facility_id='"+fid+"' and clinic_type in (select locn_type from am_care_locn_type where locn_type='"+value+"') and eff_status='E' order by 2";
				 
				 prs=pst.executeQuery(lsql);
			  while(prs.next())
				{
                  code=prs.getString(1);
				  desc=prs.getString(2); */
				  
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(code));
            _bw.write(_wl_block7Bytes, _wl_block7);


				/* }
			 	 if(prs!=null)prs.close();
				
				}
			} */
		if(name.equals("clinic1")){			
	 	   if(func.equals("insert")){
			if(proid.equals("visit_type_for_proc_unit")){
            
			  String psql="select ALLOW_VISIT_REGN_YN from op_clinic where clinic_code='"+value+"' and facility_id='"+fid+"'and CARE_LOCN_TYPE_IND = '"+care_ind+"' ";            prs=pst.executeQuery(psql);			 	
			   
			 	
			  if(prs.next())
				  allow_visit_reg=prs.getString(1);
				
			  if(prs!=null)prs.close();
					
			  if(allow_visit_reg.equals("Y")){
                comp="parent.document.f_query_add_mod.document.forms[0].vitalsignsb";
				vsql="select discr_msr_id,short_desc from am_discr_msr where eff_Status ='E' and result_type ='V' order by short_desc ";
              	
				prs=pst.executeQuery(vsql);
				if(prs != null) {
			while( prs.next() ) {
				code=prs.getString(1);
				desc=prs.getString(2);
			
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(comp));
            _bw.write(_wl_block11Bytes, _wl_block11);
		   	  
			}
		   }
				if(prs != null) prs.close();
			   		
				}
	
			} 
				sql=" select ind, type from op_appl_vtypeind_vw where clinic_code='"+value+"' and facility_id='"+fid+"' order by type ";
				pstmt = con.prepareStatement("Select level_of_care_ind,rd_appl_yn from op_clinic where clinic_code = ? and facility_id = ?");
				pstmt.setString(1, value);
				pstmt.setString(2, fid);

				rset = pstmt.executeQuery();

				if( rset != null && rset.next() ){
					clinicLevelOfCare = rset.getString("level_of_care_ind");
					rd_appl_yn = rset.getString("rd_appl_yn")==null?"N":rset.getString("rd_appl_yn");
				}
			
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(rd_appl_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);


				if(pstmt != null) pstmt.close();
				if(rset != null) rset.close();
			  comp="parent.document.f_query_add_mod.document.forms[0].indicator";
			
			}			
			
		}
		}
			
		if(name.equals("indicator")){ 
			if(radApplYn.equals("Y")){
				sql="select nvl(max_appt_duration,0)||'$'||nvl(max_appt_slots,0)||'$'||visit_type_code code,short_desc from op_visit_type where VISIT_TYPE_IND='"+ind+"' and facility_id='"+fid+"' and EFF_STATUS='E' and rd_appl_yn = 'Y' order by short_desc ";
			}else{
				if(proid.equals("visit_type_for_proc_unit")){
					sql="select nvl(max_appt_duration,0)||'$'||nvl(max_appt_slots,0)||'$'||visit_type_code code,short_desc from op_visit_type where VISIT_TYPE_IND='"+ind+"' and facility_id='"+fid+"' and EFF_STATUS='E' and rd_appl_yn = 'N' order by short_desc ";
				}else{
					sql = "select nvl(max_appt_duration,0)||'$'||nvl(max_appt_slots,0)||'$'||visit_type_code code ,short_desc from op_visit_type where facility_id='"+fid+"' and eff_status='E' and visit_type_ind='"+ind+"' and rd_appl_yn = 'N' order by short_desc ";
			}
			}
		comp="parent.document.f_query_add_mod.document.forms[0].visittype";
		}
		
			if(sql!=null){
				pstmt=con.prepareStatement(sql);
				rset = pstmt.executeQuery();
		}
        					
		
		
            _bw.write(_wl_block14Bytes, _wl_block14);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block16Bytes, _wl_block16);

		int visitTypeCnt = 0 ;
		if(rset != null) 
		{
			while( rset.next() ) 
			{
				code=rset.getString(1);
				desc=rset.getString(2);
				visitTypeCnt++;
			
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(comp));
            _bw.write(_wl_block18Bytes, _wl_block18);

				if(name.equals("clinic1") && isAERegisterTypeAutoUpdateAppl.equals("true") && code.equals("E") )
				{ // added by mujafar for KDAH-CRF-0526
					visitTypeCnt=visitTypeCnt+1;
				
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(comp));
            _bw.write(_wl_block20Bytes, _wl_block20);

				}
				
            _bw.write(_wl_block21Bytes, _wl_block21);
		   	  
			}
		}
		
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(visitTypeCnt));
            _bw.write(_wl_block23Bytes, _wl_block23);

        if(rset != null) rset.close();
		if(pstmt != null) pstmt.close();
	    if(pst != null) pst.close();
	}catch(Exception e) { 
		e.printStackTrace();
		}		   	  
			

		if(clinicLevelOfCare != null)
		if(clinicLevelOfCare.equals("E"))
			{
		
            _bw.write(_wl_block24Bytes, _wl_block24);

			}
		else
			{		
         
            _bw.write(_wl_block25Bytes, _wl_block25);

			}

	}catch(Exception e) { 
		out.println(e.toString());
		e.printStackTrace();
		}
	finally
	{
			if(con!=null) ConnectionManager.returnConnection(con,request);			
	
	}
	
            _bw.write(_wl_block26Bytes, _wl_block26);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
