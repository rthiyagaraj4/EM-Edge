package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __patsearchresultformatquery extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/PatSearchResultFormatQuery.jsp", 1709118691043L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n<head>\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n    <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n</head>\n<BODY class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<P>\n\t\t\t\t<table align=\'right\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t<td align =\'right\' id=\'next\' style=\'visibility:hidden\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t<BR><BR>\n\t\t\t\t</P>\n\t\t\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t<script >\n\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<script >\n\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n</td></tr>\n</table>\n<br><center>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</center>\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block2Bytes, _wl_block2);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	String whereClause = request.getParameter("whereclause");
	
	if(whereClause == null) whereClause="";

	String sql=" " ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	
	String name_prefix="";
	String first_name="";
	String second_name="";
	String third_name="";
	String family_name="";
	String name_suffix="";
	String link="Y";
	String accept_national_id_no_yn="";
	String alt_id1_type="";
	String addl_field1_prompt=""; 
	String addl_field2_prompt="";
	String addl_field3_prompt="";
	String addl_field4_prompt=""; 
	String addl_field5_prompt="";	
	String maintain_doc_or_file ="";	
	String entitlement_by_pat_cat_yn ="";	
   
    if(!(whereClause == null || whereClause.equals("")))
    {
		sql = whereClause;
    }

	int start = 0 ;
	int end = 0 ;
	int i=1;

	if(from == null) start = 1 ;
	else start = Integer.parseInt( from ) ;

	if(to == null) end = 14 ;
	else end = Integer.parseInt( to ) ;

	Connection conn=null;
	PreparedStatement pstmt=null;
	PreparedStatement pcondstmt=null;
	ResultSet rs=null;
	ResultSet condres=null;
	
//	int maxRecord = 0;
	
	try
	{
		conn = ConnectionManager.getConnection(request);
		pcondstmt=conn.prepareStatement("SELECT first_name_accept_yn, second_name_accept_yn, third_name_accept_yn, family_name_accept_yn, name_suffix_accept_yn, name_prefix_accept_yn, accept_national_id_no_yn, alt_id1_type, addl_field1_prompt, addl_field2_prompt, addl_field3_prompt, addl_field4_prompt, addl_field5_prompt, maintain_doc_or_file,entitlement_by_pat_cat_yn FROM mp_param");
	
		condres = pcondstmt.executeQuery();
		if(condres != null)
		{
			if(condres.next())
			{
				name_prefix					= condres.getString("name_prefix_accept_yn");
				first_name					= condres.getString("first_name_accept_yn");
				second_name					= condres.getString("second_name_accept_yn");
				third_name					= condres.getString("third_name_accept_yn");
				family_name					= condres.getString("family_name_accept_yn");
				name_suffix					= condres.getString("name_suffix_accept_yn");
		 		accept_national_id_no_yn	= condres.getString("accept_national_id_no_yn");
				alt_id1_type				= condres.getString("alt_id1_type");                 addl_field1_prompt			= condres.getString("addl_field1_prompt");         
				addl_field2_prompt			= condres.getString("addl_field2_prompt");         
				addl_field3_prompt			= condres.getString("addl_field3_prompt");         
				addl_field4_prompt			= condres.getString("addl_field4_prompt");         
				addl_field5_prompt			= condres.getString("addl_field5_prompt");	        
				maintain_doc_or_file		= condres.getString("maintain_doc_or_file");	        
				entitlement_by_pat_cat_yn		= condres.getString("entitlement_by_pat_cat_yn");	        
				
				if(name_prefix	==null) name_prefix = "N";
				if(first_name	==null) first_name = "N";
				if(second_name	==null) second_name = "N";
				if(third_name	==null) third_name = "N";
				if(family_name	==null) family_name = "N";
				if(name_suffix	==null) name_suffix = "N";
				if(accept_national_id_no_yn == null) accept_national_id_no_yn = "N";
				if(maintain_doc_or_file == null) maintain_doc_or_file = "F";
				if(entitlement_by_pat_cat_yn == null) entitlement_by_pat_cat_yn = "F";
								
				if(addl_field1_prompt	==null) addl_field1_prompt="";
				if(addl_field2_prompt	==null) addl_field2_prompt="";
				if(addl_field3_prompt	==null) addl_field3_prompt="";
				if(addl_field4_prompt	==null) addl_field4_prompt="";
				if(addl_field5_prompt	==null) addl_field5_prompt="";
			}
			else
			{
				out.println("<script>alert(parent.parent.frames[0].getMessage('MP_PARAM_NOT_FOUND','MP'));");
				out.println("parent.window.location.href ='../../eCommon/html/blank.html'</script>") ;	
			}
		}
		else out.print("No records");

	/*	try
		{
			pstmt = conn.prepareStatement("SELECT count(*) as total FROM mp_pat_search_result "+sql);
			rs = pstmt.executeQuery();
			rs.next();
			maxRecord = rs.getInt("total");
		}
		catch(Exception e) 
		{ 
			out.println(e.toString());
		}
		finally
		{
		if (pstmt != null) pstmt.close();
		if (rs != null) rs.close();
	}*/
	
	try
	{
		pstmt = conn.prepareStatement("SELECT * FROM mp_pat_search_result ORDER BY field_order"+sql);
		rs = pstmt.executeQuery();
		
            _bw.write(_wl_block7Bytes, _wl_block7);

		 	if(start != 1)
				for( int j=1; j<start; i++,j++ )
			 		rs.next();
	 		String classValue="";
			int cnt=0;
		    while(i<=end && rs.next())
			{
				if(cnt==0)
				{
            _bw.write(_wl_block8Bytes, _wl_block8);

						if(!(start <= 1))
							out.println("<td align ='right' id='prev'><A HREF='../jsp/PatSearchResultFormatQuery.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

            _bw.write(_wl_block9Bytes, _wl_block9);

						//if(!((start+14) > maxRecord))
							out.println("<A HREF='../jsp/PatSearchResultFormatQuery.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
						
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
}
				if(i%2==0) classValue="QRYEVEN";
				else classValue="QRYODD";
				out.println("<tr><td class='" + classValue + "'>");
				String code = rs.getString("field_name");
				if(code.equalsIgnoreCase("Patient_Id"))
				{
					//nolink=true;
					link="N";
				}
				/*If Entitlement is unchecked the links of FAMILY_ORG_ID,FAMILY_ORG_SUB_ID, PAT_CAT_CODE,RELATIONSHIP_TO_HEAD should be disabled - Vinod 4/5/2006
				*/
				if (!entitlement_by_pat_cat_yn.equals("Y"))
				{
					if(code.equalsIgnoreCase("FAMILY_ORG_ID"))
					{
						//nolink=true;
						link="N";
					}
					if(code.equalsIgnoreCase("FAMILY_ORG_SUB_ID"))
					{
						//nolink=true;
						link="N";
					}
					if(code.equalsIgnoreCase("PAT_CAT_CODE"))
					{
						//nolink=true;
						link="N";
					}
					if(code.equalsIgnoreCase("RELATIONSHIP_TO_HEAD"))
					{
						//nolink=true;
						link="N";
					}
				}
				if(code.equalsIgnoreCase("Patient_Id"))
				{
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("Name_Prefix") && name_prefix.equals("N"))
				{
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("first_name") && first_name.equals("N"))
				{
					//nolink=true;
					link="N";
				}	
				if(code.equalsIgnoreCase("second_name") && second_name.equals("N"))
				{
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("third_name") && third_name.equals("N"))
				{
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("family_name") && family_name.equals("N"))
				{
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("name_suffix") && name_suffix.equals("N"))
				{	
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("National_ID_No") && accept_national_id_no_yn.equals("N"))
				{	
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("Alt_ID1_No") && alt_id1_type.equals("N"))
				{	
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("ADDL_FIELD1") && addl_field1_prompt.equals(""))
				{	
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("ADDL_FIELD2") && addl_field2_prompt.equals(""))
				{	
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("ADDL_FIELD3") && addl_field3_prompt.equals(""))
				{	
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("ADDL_FIELD4") && addl_field4_prompt.equals(""))
				{	
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("ADDL_FIELD5") && addl_field5_prompt.equals(""))
				{	
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("File_No") && maintain_doc_or_file.equals("D"))
				{	
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("Facility_Id") && maintain_doc_or_file.equals("D"))
				{	
					//nolink=true;
					link="N";
				}
				if(code.equalsIgnoreCase("Old_File_No") && maintain_doc_or_file.equals("D"))
				{	
					//nolink=true;
					link="N";
				}
				
				//if(!nolink)
				if(link.equals("N"))
				{
					out.println(code+"</td>");
				}
				else
				{
					out.println("<a href='../../eMP/jsp/modifyPatSearchForResults.jsp?field_name="+ code + "' target='f_query_add_mod' >"+code+"</a></td>");
				}

				out.println("<td class='" + classValue + "'>");
				out.println( rs.getString("field_desc") );
				out.println("</td><td class='" + classValue + "'><CENTER>");
				//out.println(rs.getString("field_select") );
				if(rs.getString("field_select").equals("Y"))
					out.println("<img src='../../eCommon/images/enabled.gif'></img>");
				else
					out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
				out.println("</CENTER></td> <td class='" + classValue + "'>");

				if(rs.getString("field_order")==null)
					out.println("&nbsp");
				else
					out.println(rs.getString("field_order"));
				i++;
				link="Y";
				cnt++;
			}
			if (cnt==0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
			}
			boolean flag = false;
			if ( cnt < 14 || (!rs.next()) ) { 
			
            _bw.write(_wl_block13Bytes, _wl_block13);
 flag = true;
					} else {
            _bw.write(_wl_block14Bytes, _wl_block14);
}
			out.println("</td>");
			//nolink=false;
		}
		catch(Exception e) 
		{ 
			//out.println(e.toString());
			e.printStackTrace(); // Added by lakshmanan for security issue ID 174219100 on 28-08-2023
		}
		finally
		{
			if (pstmt != null) pstmt.close();
			if (rs != null) rs.close();
		}
	}
	catch(Exception e)
	{ 
		//out.println(e.toString());
		e.printStackTrace(); // Added by lakshmanan for security issue ID 174219101 on 28-08-2023
	}
	finally
	{
		if(pcondstmt!=null)	pcondstmt.close();
		if(condres!=null) 	condres.close();
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block15Bytes, _wl_block15);


            _bw.write(_wl_block16Bytes, _wl_block16);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.FieldName.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.FieldTitle.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Order.label", java.lang.String .class,"key"));
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
