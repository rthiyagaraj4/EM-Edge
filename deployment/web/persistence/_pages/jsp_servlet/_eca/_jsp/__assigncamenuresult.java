package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __assigncamenuresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/AssignCAMenuResult.jsp", 1709115457201L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\t\t\n\t\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t\n\t</head>\n\t\n\t<body class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n\t<form>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\n<table cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'center\'>\n<tr>\n<td class=\'white\' width=\'88%\'></td>\n<td align=right>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t</td>\n\t</tr>\n</table>\n\t<table width=\'100%\' class=\'grid\' align=\'center\' >\n\t<!-- <table width=\'100%\' cellpadding=\'3\' cellspacing=\'0\' border=\'1\' align=\'center\' > -->\n\t\n\t<td class=\'COLUMNHEADERCENTER\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t<td class=\'COLUMNHEADERCENTER\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t<td class=\'COLUMNHEADERCENTER\' >Summary</td><!--IN035912-->\n\t<td class=\'COLUMNHEADERCENTER\' >Navigation</td><!--IN035912-->\n\t<td class=\'COLUMNHEADERCENTER\' >Facility</td><!--IN036733-->\n\t\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t</td>\n  </tr>\n</table>\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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
 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
21/11/2012		IN035912		Nijitha			CHL Hospital suggested that the presentation of the Clinician desktop be 												changed and more appealing. Keeping the display of information more clear 												 and visible.   								 
06/08/2013		IN036733		Nijitha			Bru-HIMS-CRF-328
-------------------------------------------------------------------------------------------------------------------------------------
*/

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
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con			=	null ;		
	String whereClause		=	"";
	String mode		=	"";	
	String	practitioner_id	=	"";
	String	practitioner_name	=	"";
	String	patient_class  	=	"";
	String	pract_type     	=	"";
	String  speciality_code	=	"";
	String	menu_id        	=	"";
	String	patient_class_name="";
	String	patient_class1="";
	String speciality_name="";
	String pract_type_name="";
	String pract_type1="";
	String pract_name="";
	String practitioner_id1="";
	String menu_desc="";
	String menu_id1="";
	String legendForSummary="";//IN035912
	String legendForNavigation="";//IN035912
	//IN03673 Starts
	String facilityname ="";
	String facilityID = "";
	String facility_id="";
	//IN036733 Ends

	//Modified by Archana @10-12-2008
	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
	int pageCnt = Integer.parseInt(MstQryPageCnt);

	StringBuffer sql = new StringBuffer();
	StringBuffer sql2 = new StringBuffer();
	
	int maxRecord =	 0;

	try
	{
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null;
		ResultSet rset=null;
		ResultSet rs = null;
		mode="modify";
		whereClause= request.getParameter("whereclause");

		if(whereClause==null) whereClause="";

		String from = request.getParameter( "from" ) ;
		String to = request.getParameter( "to" ) ;

		facility_id = request.getParameter("facility_id");//IN03673
		patient_class=request.getParameter("patient_class");

		//IN03673 Starts
		if( facility_id == null)
			facility_id = "*A";
		//IN03673 Ends
		if( patient_class == null)
			patient_class = "*A";

		pract_type=request.getParameter("pract_type");

		if( pract_type == null)
			pract_type = "*A";

		practitioner_name=request.getParameter("practitioner_name");

		if( practitioner_name == null)
			practitioner_name = "*ALL";

		menu_id=request.getParameter("menu_id");

		if( menu_id == null)
			menu_id = "";

	
	
		if ( (whereClause == null || whereClause.equals("null") || whereClause.equals("") ) )
		{
			int cnt=0;
			if( !(patient_class == null || patient_class.equals("null") || patient_class.equals("") ) )
			if(sql.length() > 0) sql.delete(0,sql.length());
			{
				sql.append("AND a.patient_class like upper('"+patient_class+"%')");
				sql2.append("where PATIENT_CLASS like upper('"+patient_class+"%')");
				cnt++;
			}
			//IN036733 Starts
			if( !(facility_id == null  || facility_id.equals("null") || facility_id.equals("")) )
			{
				if(cnt>0)
				{	
					sql.append("AND a.facility_id like upper('"+facility_id+"%')");
					sql2.append("AND facility_id like upper('"+facility_id+"%')");	
					cnt=1;
				}
				else
				{	
					sql.append("AND a.facility_id like upper('"+facility_id+"%')");
					sql2.append("where facility_id like upper('"+facility_id+"%')");	
					cnt=1;
				}
					
			}
			//IN036733 Ends

			if( !(pract_type == null  || pract_type.equals("null") || pract_type.equals("")) )
			{
				if(cnt>0)
				{	
					sql.append("AND a.pract_type like upper('"+pract_type+"%')");
					sql2.append("AND PRACT_TYPE like upper('"+pract_type+"%')");	
					cnt=1;
				}
				else
				{	
					sql.append("AND a.pract_type like upper('"+pract_type+"%')");
					sql2.append("where PRACT_TYPE like upper('"+pract_type+"%')");	
					cnt=1;
				}
					
			}
			/*Modified by Uma 12/28/2010 for IN025268*/
			if( !(practitioner_name == null  || practitioner_name.equals("null") || practitioner_name.equals("")) )
			{
				if(cnt>0)
				{
					sql.append("AND upper(am_get_desc.am_practitioner(a.practitioner_id,'en',2)) like upper('"+practitioner_name+"%')  ");
					//sql2.append("AND PRACT_NAME like upper('"+practitioner_name+"%') ");
					sql2.append("AND upper(am_get_desc.am_practitioner(practitioner_id,'en',2)) like upper('"+practitioner_name+"%') ");
					cnt=1;
				}
				else
				{
					sql.append("AND upper(am_get_desc.am_practitioner(a.practitioner_id,'en',2)) like upper('"+practitioner_name+"%')  ");
					//sql2.append("where pract_name like upper('"+practitioner_name+"%') ");
					sql2.append("where upper(am_get_desc.am_practitioner(practitioner_id,'en',2)) like upper('"+practitioner_name+"%') ");
					cnt=1;
				}
				
			}
			/*Ends Here*/


		
			if( !(menu_id == null  || menu_id.equals("null") || menu_id.equals("")) )
			{
				if(cnt>0)
				{
					sql.append("AND a.menu_id like upper('"+menu_id+"%')");
					sql2.append("AND MENU_ID like upper('"+menu_id+"%')");
				}
				else
				{
					sql.append("AND a.menu_id like upper('"+menu_id+"%')");
					sql2.append("where MENU_ID like upper('"+menu_id+"%')");
				}
			}

			
			String ord[] = request.getParameterValues("orderbycolumns");
			
			if ( !(ord == null  || ord .equals("null") || ord .equals("")) )
			{
					sql.append(" order by ");
					for ( int i=0;i < ord.length;i++ )
					{
						if ( i == ord.length - 1 )
						{
							sql.append(ord[i]+" ");
						
						}
						else
						{
							sql.append(ord[i]+" , ");
							
						}
					}			
			
			}//if ord

		}// if of where clause

		else
		{
			sql = new StringBuffer();
			sql.append(whereClause);
		}

		int start = 0 ;
	    int end = 0 ;
		int i=1;

		if ( from == null)
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;

	    if ( to == null)
		    end = pageCnt ;
		else
			end = Integer.parseInt( to ) ;	

		con  = ConnectionManager.getConnection(request);	

	try
	{
	    StringBuffer strsql = new StringBuffer();
		if(strsql.length() > 0) strsql.delete(0,strsql.length());
		strsql.append("select count(*) as total from ca_app_custom_menu ");
		strsql.append(sql2.toString());
	
		StringBuffer strsqll = new StringBuffer();
		if(strsqll.length() > 0) strsqll.delete(0,strsqll.length());
		/* In the below query, changed the precedence from DESC_SYSDEF to DESC_USERDEF for the column pract_type_name, updated by Dinesh T on 12/23/2010 for Incident 25303 */
		//strsqll.append("SELECT a.practitioner_id as practitioner_id, NVL(b.short_name,'All') pract_name, a.patient_class as patient_class, NVL(c.short_desc,'All') patient_class_name, a.pract_type as pract_type , NVL(e.DESC_USERDEF, NVL(e.DESC_SYSDEF,'All'))pract_type_name, a.speciality_code as speciality_code, NVL(d.SHORT_DESC,'All') speciality_name, a.menu_id as menu_id, f.SHORT_DESC menu_desc FROM ca_app_custom_menu a , am_practitioner b, am_patient_class c, am_speciality d, am_pract_type e, ca_menu_header f WHERE a.practitioner_id = b.practitioner_id(+) AND a.patient_class = c.patient_class(+) AND a.SPECIALITY_CODE = d.SPECIALITY_CODE(+) AND a.pract_type = e.pract_type(+) AND a.menu_id = f.menu_id(+) ");//IN035912
		//strsqll.append("SELECT a.practitioner_id as practitioner_id, NVL(b.short_name,'All') pract_name, a.patient_class as patient_class, NVL(c.short_desc,'All') patient_class_name, a.pract_type as pract_type , NVL(e.DESC_USERDEF, NVL(e.DESC_SYSDEF,'All'))pract_type_name, a.speciality_code as speciality_code, NVL(d.SHORT_DESC,'All') speciality_name, a.menu_id as menu_id, f.SHORT_DESC menu_desc,a.LEGEND_FOR_SUMMARY,a.LEGEND_FOR_NAVIGATION FROM ca_app_custom_menu a , am_practitioner b, am_patient_class c, am_speciality d, am_pract_type e, ca_menu_header f WHERE a.practitioner_id = b.practitioner_id(+) AND a.patient_class = c.patient_class(+) AND a.SPECIALITY_CODE = d.SPECIALITY_CODE(+) AND a.pract_type = e.pract_type(+) AND a.menu_id = f.menu_id(+)");//IN035912//Commented for IN036733
		strsqll.append("SELECT a.practitioner_id as practitioner_id, NVL(b.short_name,'All') pract_name, a.patient_class as patient_class, NVL(c.short_desc,'All') patient_class_name, a.pract_type as pract_type , NVL(e.DESC_USERDEF, NVL(e.DESC_SYSDEF,'All'))pract_type_name, a.speciality_code as speciality_code, NVL(d.SHORT_DESC,'All') speciality_name, a.menu_id as menu_id, f.SHORT_DESC menu_desc,a.LEGEND_FOR_SUMMARY,a.LEGEND_FOR_NAVIGATION,g.facility_name,a.facility_id FROM ca_app_custom_menu a , am_practitioner b, am_patient_class c, am_speciality d, am_pract_type e, ca_menu_header f,sm_facility_param g WHERE a.practitioner_id = b.practitioner_id(+) AND a.patient_class = c.patient_class(+) AND a.SPECIALITY_CODE = d.SPECIALITY_CODE(+) AND a.pract_type = e.pract_type(+) AND a.menu_id = f.menu_id(+) and a.facility_id=g.facility_id(+) ");//IN035912//IN036733
		stmt = con.prepareStatement(strsql.toString());	
		rs = stmt.executeQuery();
		rs.next();
		maxRecord = rs.getInt("total");
		
		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		stmt1=con.prepareStatement(strsqll.toString()+sql.toString());
		rset = stmt1.executeQuery();
		
	}
	catch (Exception e){
		//out.println("Exception in AssignCAMenuResult.jsp :"+e.getMessage());//COMMON-ICN-0181
          e.printStackTrace();//COMMON-ICN-0181
	}


            _bw.write(_wl_block8Bytes, _wl_block8);

	if ( !(start <= 1) )
		out.println("<A class='gridLink' HREF='../../eCA/jsp/AssignCAMenuResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause=" + URLEncoder.encode(sql.toString()) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	if ( !( (start+pageCnt) > maxRecord ) )
		out.println("<A class='gridLink' HREF='../../eCA/jsp/AssignCAMenuResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

	if ( start != 1 )
    for( int j=1; j<start; i++,j++ )
    rset.next() ;
	String classValue= "gridData";
 
	while ( rset.next() && i<=end  )
	{
	     /* if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
          else
			classValue = "QRYODD" ;*/

		
		patient_class_name	=(rset.getString("patient_class_name")==null)?"":rset.getString("patient_class_name");		
		patient_class1	=(rset.getString("patient_class")==null)?"":rset.getString("patient_class");	
		speciality_code=(rset.getString("speciality_code")==null)?"":rset.getString("speciality_code"); 		
		speciality_name=(rset.getString("speciality_name")==null)?"":rset.getString("speciality_name");
		pract_type_name=(rset.getString("pract_type_name")==null)?"":rset.getString("pract_type_name"); 	
		pract_type1=(rset.getString("pract_type")==null)?"":rset.getString("pract_type"); 
		pract_name=(rset.getString("pract_name")==null)?"":rset.getString("pract_name"); 		
		practitioner_id1=(rset.getString("practitioner_id")==null)?"":rset.getString("practitioner_id"); 
		menu_desc	=(rset.getString("menu_desc")==null)?"":rset.getString("menu_desc");
		menu_id1	=(rset.getString("menu_id")==null)?"":rset.getString("menu_id");
		legendForSummary =(rset.getString("LEGEND_FOR_SUMMARY")==null)?"Summary":rset.getString("LEGEND_FOR_SUMMARY");//IN035912
		legendForNavigation=(rset.getString("LEGEND_FOR_NAVIGATION")==null)?"Navigation":rset.getString("LEGEND_FOR_NAVIGATION");//IN035912
		facilityname = (rset.getString("facility_name")==null)?"All":rset.getString("facility_name");//IN036733
		facilityID = (rset.getString("facility_id")==null)?"*A":rset.getString("facility_id");//IN036733
		out.println("<tr><td class='" + classValue + "'>");
		//out.println("<a class='gridLink' href='../../eCA/jsp/AssignCAMenu.jsp?menu_desc="+ menu_desc+"&mode="+mode+"&menu_id="+menu_id1+"&patient_class1="+patient_class1+"&pract_type="+pract_type1+"&practitioner_id="+practitioner_id1+"&speciality_name="+speciality_name+"&patient_class_name="+patient_class_name+"&pract_name="+pract_name+"&speciality_code="+speciality_code+"&pract_type_name="+pract_type_name+"' target='f_query_add_mod' >");
		out.println("<a class='gridLink' href='../../eCA/jsp/AssignCAMenu.jsp?menu_desc="+ menu_desc+"&mode="+mode+"&menu_id="+menu_id1+"&patient_class1="+patient_class1+"&pract_type="+pract_type1+"&practitioner_id="+practitioner_id1+"&speciality_name="+speciality_name+"&patient_class_name="+patient_class_name+"&pract_name="+pract_name+"&speciality_code="+speciality_code+"&pract_type_name="+pract_type_name+"&facility_id="+facilityID+"' target='f_query_add_mod' >");
		out.println(patient_class_name+"</a></td>");
		out.println("<td class='" + classValue + "'>");
		out.println(pract_type_name);
		out.println("</td><td class='" + classValue + "'>");
		out.println(pract_name);
		out.println("</td><td class='" + classValue + "'>");
		out.println(menu_desc);
		//IN035912 Starts
		out.println("</td><td class='" + classValue + "'>");
		out.println(legendForSummary);
		out.println("</td><td class='" + classValue + "'>");
		out.println(legendForNavigation);
		//IN035912 Ends
		//IN036733 Starts
		out.println("</td><td class='" + classValue + "'>");
		out.println(facilityname);
		//IN036733 Ends
		i++; 
	}

            _bw.write(_wl_block12Bytes, _wl_block12);


	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	if(rset!=null) rset.close();
	if(stmt1!=null) stmt1.close();
}
catch (Exception ei)
{
	ei.printStackTrace();
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitionertype.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.menu.label", java.lang.String .class,"key"));
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
}
