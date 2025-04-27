package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import java.text.*;
import java.net.*;
import java.util.*;
import com.ehis.util.*;

public final class __regpatcategorytemp extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/RegPatCategoryTemp.jsp", 1709118713464L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\tif (document.forms[0].pat_cat_code)\n\t\t{\n\t\t\tdocument.forms[0].pat_cat_code.value=\"\";\n\t\t}\n\t\tif (document.forms[0].pat_cat_desc)\n\t\t{\n\t\t\tdocument.forms[0].pat_cat_desc.value=\"\";\n\t\t}\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t   document.forms[0].pat_cat_code.value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\t\t   document.forms[0].pat_cat_desc.value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\tdocument.forms[0].pat_cat_sql.value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"; \t\t\t\t\t \n\t\t\t\t  ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t  document.forms[0].pat_cat_code.value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t\t\t      document.forms[0].pat_cat_desc.value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\tif (\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'!=\'\')\n\t\t{\n\t\t\tif (document.forms[0].pat_cat_code)\n\t\t\t\tdocument.forms[0].pat_cat_code.value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'\t;\n\t\t\tif (document.forms[0].imgCatExpDateMan)\n\t\t\t\tdocument.forms[0].imgCatExpDateMan.style.visibility = \'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'\t;\n\t\t}\n\t\tif ( (document.forms[0].pat_cat_code) && \n\t\t\t (document.forms[0].pat_cat_code.value==\'\') && \n\t\t\t (document.forms[0].pat_cat_code_exp_date)  )\t\n\t\t\t\tdocument.forms[0].pat_cat_code_exp_date.value=\'\';\n\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
	public String singleToDoubleQuotes(String strDB)
	{
		/*
		String strModified="";
		try
		{
			if((strDB != null) ||(strDB !=""))
			{
				StringBuffer stringbuffer = new StringBuffer(strDB);
				int i = 0;
				for(int j = 0; strDB.indexOf('\'', i) != -1; j++)
				{
					i = strDB.indexOf('\'', i);
					stringbuffer.insert(i + j, "'");
					i++;
				}
				strModified=stringbuffer.toString();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		*/
		return strDB.replaceAll("'","''");
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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
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

	/*Function called to Load Patient categories based on Membership Type, Org ID, Sub OrgID and Name Prefix*/
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	Hashtable hash = null;

	String family_org_membership = "";
	String family_org_id = "";
	String family_org_sub_id = "";
	String name_prefix =  "";
	String selected_sub = "";
	String relationship_to_head = "";
	String alt_id1_no = "";
	String patCatDB = "";
	String exp_val_appl_yn = "N";
	String visibility = "hidden";
	String code	= "";
	String desc	= "";
	
    StringBuffer sql = new StringBuffer("");   
	StringBuffer where_clause = new StringBuffer();
	String main_sql = "";
	String temp_sql = "";
	//String defaultSelect		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	int maxrecord = 0;
	try
	{
		request.setCharacterEncoding("UTF-8");
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();

		hash = (Hashtable)obj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get("SEARCH") ;
			
		family_org_membership		= (String) hash.get("family_org_membership");
		family_org_id					= (String) hash.get("org_id");
		family_org_sub_id				= (String) hash.get("sub_organization");
		name_prefix						= (String) hash.get("name_prefix");
		selected_sub					= (String) hash.get("selected_sub");
		relationship_to_head			= (String) hash.get("relationship_to_head");
		alt_id1_no						= (String) hash.get("alt_id1_no");
		patCatDB						= (String) hash.get("patCatDB");

		Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
            _bw.write(_wl_block6Bytes, _wl_block6);

			
		if (family_org_membership.equals("1"))
		{
		    main_sql = "select distinct a.pat_cat_code, b.short_desc patcategory, b.exp_val_appl_yn from  mp_pat_category_deriv_rule a,mp_pat_category b where a.pat_cat_code=b.pat_cat_code and a.membership_type='1' ";

			temp_sql = "select distinct a.pat_cat_code code, b.short_desc description from mp_pat_category_deriv_rule a,mp_pat_category b where a.pat_cat_code=b.pat_cat_code and a.membership_type='1' AND UPPER(a.PAT_CAT_CODE) LIKE UPPER(?) AND UPPER(b.short_desc) LIKE UPPER(?)"; 

			where_clause.append("and a.family_org_id = '"+family_org_id+"' and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' and a.family_org_sub_id ='"+family_org_sub_id+"'  and a.relationship_code = '"+relationship_to_head+"'"); 			

		
			rs=stmt1.executeQuery((main_sql+where_clause.toString()));
			
			rs.last();
			maxrecord = rs.getRow();
			rs.beforeFirst();
			if(maxrecord<=0)
            {
				where_clause.delete(0,where_clause.length());
											
				if (!family_org_id.equals(""))
					where_clause.append(" and a.family_org_id = '"+family_org_id+"' ");
				if (!name_prefix.equals(""))
					where_clause.append(" and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
				 
				where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"'  ");
				 
				where_clause.append(" and a.relationship_code = '"+relationship_to_head+"'");
				if(rs != null) rs.close();
				rs=stmt1.executeQuery(main_sql+where_clause.toString());
				rs.last();
				maxrecord = rs.getRow();
				rs.beforeFirst();

						if(maxrecord<=0)
						{
							where_clause.delete(0,where_clause.length());
					 		if (!family_org_id.equals(""))
								where_clause.append(" and a.family_org_id = '"+family_org_id+"' ");
							if (!name_prefix.equals(""))
								where_clause.append(" and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
							 
							where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"'  ");
							 
							where_clause.append(" and a.relationship_code = '*ALL'");
							if(rs != null) rs.close();
							rs=stmt1.executeQuery(main_sql+where_clause.toString());
							rs.last();
							maxrecord = rs.getRow();
							rs.beforeFirst();
							if(maxrecord<=0)
							{
								where_clause.delete(0,where_clause.length());
								if (!family_org_id.equals(""))
									where_clause.append(" and a.family_org_id = '"+family_org_id+"' ");					 
								where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"'  ");
					 
 								where_clause.append(" and a.name_prefix = '*ALL' ");
								where_clause.append(" and a.relationship_code = '"+relationship_to_head+"' ");
								if(rs != null) rs.close();
								rs=stmt1.executeQuery((main_sql+where_clause.toString()));
							    rs.last();
							    maxrecord = rs.getRow();
							    rs.beforeFirst();
								if(maxrecord<=0)
								{
									where_clause.delete(0,where_clause.length());
									if (!family_org_id.equals(""))
										sql.append(" and a.family_org_id = '"+family_org_id+"' "); 				
									where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"'  ");			 
 									where_clause.append(" and a.name_prefix = '*ALL' ");
									where_clause.append(" and a.relationship_code = '*ALL'");
									if(rs != null) rs.close();
									rs=stmt1.executeQuery(main_sql+where_clause.toString());
									rs.last();
									maxrecord = rs.getRow();
									rs.beforeFirst();
									if(maxrecord<=0)
									{
										where_clause.delete(0,where_clause.length());
										if (!family_org_id.equals(""))
											where_clause.append(" and a.family_org_id = '"+family_org_id+"' ");
					 
										where_clause.append(" and a.family_org_sub_id = '*ALL'  ");
					
 										where_clause.append("and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
										where_clause.append(" and a.relationship_code = '"+relationship_to_head+"'");
										if(rs != null) rs.close();
										rs=stmt1.executeQuery(main_sql+where_clause.toString());
										rs.last();
										maxrecord = rs.getRow();
										rs.beforeFirst();
										if(maxrecord<=0)
										{
											where_clause.delete(0,where_clause.length());
						 
											if (!family_org_id.equals(""))
												where_clause.append(" and a.family_org_id = '"+family_org_id+"' ");
											 
											where_clause.append(" and a.family_org_sub_id = '*ALL'  ");
											 
											where_clause.append("and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
											where_clause.append(" and a.relationship_code = '*ALL'");

											if(rs != null) rs.close();
											rs=stmt1.executeQuery(main_sql+where_clause.toString());
											rs.last();
											maxrecord = rs.getRow();
											rs.beforeFirst();
											if(maxrecord<=0)
											{
												where_clause.delete(0,where_clause.length());
						
												 if (!family_org_id.equals(""))
													 where_clause.append("and a.family_org_id = '"+family_org_id+"'");
												
													 where_clause.append(" and a.family_org_sub_id = '*ALL'");
												
												 where_clause.append("and a.name_prefix = '*ALL' ");
												 where_clause.append(" and a.relationship_code = '"+relationship_to_head+"' ");
												 if(rs != null) rs.close();
												 rs=stmt1.executeQuery(main_sql+where_clause.toString());
												 rs.last();
												 maxrecord = rs.getRow();
												 rs.beforeFirst();
												 if(maxrecord<=0)
												 {
													 where_clause.delete(0,where_clause.length());

													 if (!family_org_id.equals(""))
														 where_clause.append(" and a.family_org_id = '"+family_org_id+"' ");
													 if (!family_org_sub_id.equals(""))
														 where_clause.append(" and a.family_org_sub_id = '*ALL'  ");
													
													 where_clause.append("and a.name_prefix = '*ALL' ");
													 where_clause.append(" and a.relationship_code = '*ALL' ");
													 if(rs != null) rs.close();
													 rs=stmt1.executeQuery(main_sql+where_clause.toString());
													 rs.last();
													 maxrecord = rs.getRow();
													 rs.beforeFirst();
													 if(maxrecord<=0)
													 {
														 where_clause.delete(0,where_clause.length());

														 if (!family_org_id.equals(""))
															 where_clause.append(" and a.family_org_id = '*ALL' ");
														 where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"' ");
														 where_clause.append(" and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
														 where_clause.append(" and a.relationship_code = '"+relationship_to_head+"' ");
														 if(rs != null) rs.close();
														 rs=stmt1.executeQuery(main_sql+where_clause.toString());
														 rs.last();
														 maxrecord = rs.getRow();
														 rs.beforeFirst();
													if(maxrecord<=0)
													{
														where_clause.delete(0,where_clause.length());
														if (!family_org_id.equals(""))
																where_clause.append(" and a.family_org_id = '*ALL' ");
														where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"' ");
														where_clause.append(" and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
														where_clause.append(" and a.relationship_code = '*ALL' ");
														if(rs != null) rs.close();
														rs=stmt1.executeQuery(main_sql+where_clause.toString());
														rs.last();
														maxrecord = rs.getRow();
														rs.beforeFirst();

														if(maxrecord<=0)
														{
															
															where_clause.delete(0,where_clause.length());
															if (!family_org_id.equals(""))
																where_clause.append(" and a.family_org_id = '*ALL' ");
															where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"' ");
															where_clause.append(" and a.name_prefix = '*ALL' ");
															where_clause.append(" and a.relationship_code = '"+relationship_to_head+"' ");
															if(rs != null) rs.close();
															rs=stmt1.executeQuery(main_sql+where_clause.toString());
															rs.last();
															maxrecord = rs.getRow();
															rs.beforeFirst();
															if(maxrecord<=0){
																
																where_clause.delete(0,where_clause.length());
							  
															if (!family_org_id.equals(""))
																 where_clause.append(" and a.family_org_id = '*ALL' ");
															where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"' ");
															where_clause.append(" and a.name_prefix = '*ALL' ");
															where_clause.append(" and a.relationship_code = '*ALL' ");
															if(rs != null) rs.close();
															rs=stmt1.executeQuery(main_sql+where_clause.toString());
															rs.last();
															maxrecord = rs.getRow();
															rs.beforeFirst();
                          if(maxrecord<=0)
						  {
							 where_clause.delete(0,where_clause.length()); 
						 if (!family_org_id.equals(""))
							 where_clause.append(" and a.family_org_id = '*ALL' ");
						 where_clause.append(" and a.family_org_sub_id = '*ALL' ");
						 where_clause.append(" and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
						 where_clause.append(" and a.relationship_code = '"+relationship_to_head+"' ");
						if(rs != null) rs.close();
						rs=stmt1.executeQuery(main_sql+where_clause.toString());
						rs.last();
						maxrecord = rs.getRow();
						rs.beforeFirst();
						if(maxrecord<=0){
							where_clause.delete(0,where_clause.length()); 	
						 if (!family_org_id.equals(""))
							 where_clause.append(" and a.family_org_id = '*ALL' ");
						 where_clause.append(" and a.family_org_sub_id = '*ALL' ");
						 where_clause.append(" and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
						 where_clause.append(" and a.relationship_code = '*ALL' ");
						 if(rs != null) rs.close();
						 rs=stmt1.executeQuery(main_sql+where_clause.toString());
						 rs.last();
						 maxrecord = rs.getRow();
						 rs.beforeFirst();
                         if(maxrecord<=0) 
						 {
							where_clause.delete(0,where_clause.length()); 		 
							if (!family_org_id.equals(""))
								 where_clause.append(" and a.family_org_id = '*ALL' ");
							where_clause.append(" and a.family_org_sub_id = '*ALL' ");
							where_clause.append(" and a.name_prefix = '*ALL' ");
							where_clause.append(" and a.relationship_code = '"+relationship_to_head+"' ");
							if(rs != null) rs.close();
							rs=stmt1.executeQuery(main_sql+where_clause.toString());
							rs.last();
							maxrecord = rs.getRow();
							rs.beforeFirst();

						 if(maxrecord<=0)
						 {
							 where_clause.delete(0,where_clause.length()); 							  
							  
							 where_clause.append("and a.family_org_id = '*ALL' and a.name_prefix = '*ALL' and a.family_org_sub_id = '*ALL'  and a.relationship_code = '*ALL' ");
							  
							 rs=stmt1.executeQuery(main_sql+where_clause.toString());
							 rs.last();
							 maxrecord = rs.getRow();
							 rs.beforeFirst();
					      }
					     }
					    }
					   }
					  }
					 }
				    }
				   }
				  }
				 }
				}
			   }
			  }
			 }
			}
		   }    

		    if(maxrecord == 1)
			{
				  rs.next();
				  desc = checkForNull(rs.getString("patcategory"));
				  code = checkForNull(rs.getString("PAT_CAT_CODE"));  
 				  if (!(patCatDB.equals("")) && (patCatDB.equals(code)) )
					  exp_val_appl_yn = 	 checkForNull(rs.getString("exp_val_appl_yn"));
				  
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(code));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block9Bytes, _wl_block9);

			}
				temp_sql = temp_sql+where_clause.toString();
				
			
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(temp_sql));
            _bw.write(_wl_block11Bytes, _wl_block11);


		}
		else
		if ( (family_org_membership.equals("2")) || (family_org_membership.equals("3")) )
		{
			String tsql1="select name_prefix,family_org_membership,family_org_sub_id,family_org_id,relationship_to_head from mp_patient where family_org_membership='1' and alt_id1_no='"+alt_id1_no+"'";
			rs=stmt.executeQuery(tsql1);
			if(rs.next())
			{
			  family_org_sub_id=checkForNull(rs.getString("family_org_sub_id"));
			  family_org_id=checkForNull(rs.getString("family_org_id"));
			}
			if(rs != null) rs.close();	

			main_sql = "select distinct a.pat_cat_code, b.short_desc patcategory, b.exp_val_appl_yn from  mp_pat_category_deriv_rule a,mp_pat_category b where a.pat_cat_code=b.pat_cat_code and (a.membership_type='2' or a.membership_type='3') ";

			temp_sql = "select distinct a.pat_cat_code code, b.short_desc description from mp_pat_category_deriv_rule a,mp_pat_category b where a.pat_cat_code=b.pat_cat_code and (a.membership_type='2' or a.membership_type='3') AND UPPER(a.PAT_CAT_CODE) LIKE UPPER(?) AND UPPER(b.short_desc) LIKE UPPER(?)"; 

			where_clause.append("and a.family_org_id = '"+family_org_id+"' and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' and a.family_org_sub_id ='"+family_org_sub_id+"'  and a.relationship_code = '"+relationship_to_head+"'"); 			

			
			rs=stmt1.executeQuery(main_sql+where_clause.toString());
		
			rs.last();
			maxrecord = rs.getRow();
			rs.beforeFirst();
			if(maxrecord<=0)
            {
				where_clause.delete(0,where_clause.length());
											
				if (!family_org_id.equals(""))
					where_clause.append(" and a.family_org_id = '"+family_org_id+"' ");
				if (!name_prefix.equals(""))
					where_clause.append(" and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
				 
				where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"'  ");
				 
				where_clause.append(" and a.relationship_code = '"+relationship_to_head+"'");
				if(rs != null) rs.close();
				rs=stmt1.executeQuery(main_sql+where_clause.toString());
				rs.last();
				maxrecord = rs.getRow();
				rs.beforeFirst();

						if(maxrecord<=0)
						{
							where_clause.delete(0,where_clause.length());
					 		if (!family_org_id.equals(""))
								where_clause.append(" and a.family_org_id = '"+family_org_id+"' ");
							if (!name_prefix.equals(""))
								where_clause.append(" and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
							 
							where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"'  ");
							 
							where_clause.append(" and a.relationship_code = '*ALL'");
							if(rs != null) rs.close();
							rs=stmt1.executeQuery(main_sql+where_clause.toString());
							rs.last();
							maxrecord = rs.getRow();
							rs.beforeFirst();
							if(maxrecord<=0)
							{
								where_clause.delete(0,where_clause.length());
								if (!family_org_id.equals(""))
									where_clause.append(" and a.family_org_id = '"+family_org_id+"' ");					 
								where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"'  ");
					 
 								where_clause.append(" and a.name_prefix = '*ALL' ");
								where_clause.append(" and a.relationship_code = '"+relationship_to_head+"' ");
								if(rs != null) rs.close();
								rs=stmt1.executeQuery(main_sql+where_clause.toString());
							    rs.last();
							    maxrecord = rs.getRow();
							    rs.beforeFirst();
								if(maxrecord<=0)
								{
									where_clause.delete(0,where_clause.length());
									if (!family_org_id.equals(""))
										sql.append(" and a.family_org_id = '"+family_org_id+"' "); 				
									where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"'  ");			 
 									where_clause.append(" and a.name_prefix = '*ALL' ");
									where_clause.append(" and a.relationship_code = '*ALL'");
									if(rs != null) rs.close();
									rs=stmt1.executeQuery(main_sql+where_clause.toString());
									rs.last();
									maxrecord = rs.getRow();
									rs.beforeFirst();
									if(maxrecord<=0)
									{
										where_clause.delete(0,where_clause.length());
										if (!family_org_id.equals(""))
											where_clause.append(" and a.family_org_id = '"+family_org_id+"' ");
					 
										where_clause.append(" and a.family_org_sub_id = '*ALL'  ");
					
 										where_clause.append("and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
										where_clause.append(" and a.relationship_code = '"+relationship_to_head+"'");
										if(rs != null) rs.close();
										rs=stmt1.executeQuery(main_sql+where_clause.toString());
										rs.last();
										maxrecord = rs.getRow();
										rs.beforeFirst();
										if(maxrecord<=0)
										{
											where_clause.delete(0,where_clause.length());
						 
											if (!family_org_id.equals(""))
												where_clause.append(" and a.family_org_id = '"+family_org_id+"' ");
											 
											where_clause.append(" and a.family_org_sub_id = '*ALL'  ");
											 
											where_clause.append("and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
											where_clause.append(" and a.relationship_code = '*ALL'");

											if(rs != null) rs.close();
											rs=stmt1.executeQuery(main_sql+where_clause.toString());
											rs.last();
											maxrecord = rs.getRow();
											rs.beforeFirst();
											if(maxrecord<=0)
											{
												where_clause.delete(0,where_clause.length());
						
												 if (!family_org_id.equals(""))
													 where_clause.append("and a.family_org_id = '"+family_org_id+"'");
												
													 where_clause.append(" and a.family_org_sub_id = '*ALL'");
												
												 where_clause.append("and a.name_prefix = '*ALL' ");
												 where_clause.append(" and a.relationship_code = '"+relationship_to_head+"' ");
												 if(rs != null) rs.close();
												 rs=stmt1.executeQuery(main_sql+where_clause.toString());
												 rs.last();
												 maxrecord = rs.getRow();
												 rs.beforeFirst();
												 if(maxrecord<=0)
												 {
													 where_clause.delete(0,where_clause.length());

													 if (!family_org_id.equals(""))
														 where_clause.append(" and a.family_org_id = '"+family_org_id+"' ");
													 if (!family_org_sub_id.equals(""))
														 where_clause.append(" and a.family_org_sub_id = '*ALL'  ");
													
													 where_clause.append("and a.name_prefix = '*ALL' ");
													 where_clause.append(" and a.relationship_code = '*ALL' ");
													 if(rs != null) rs.close();
													 rs=stmt1.executeQuery(main_sql+where_clause.toString());
													 rs.last();
													 maxrecord = rs.getRow();
													 rs.beforeFirst();
													 if(maxrecord<=0)
													 {
														 where_clause.delete(0,where_clause.length());

														 if (!family_org_id.equals(""))
															 where_clause.append(" and a.family_org_id = '*ALL' ");
														 where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"' ");
														 where_clause.append(" and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
														 where_clause.append(" and a.relationship_code = '"+relationship_to_head+"' ");
														 if(rs != null) rs.close();
														 rs=stmt1.executeQuery(main_sql+where_clause.toString());
														 rs.last();
														 maxrecord = rs.getRow();
														 rs.beforeFirst();
													if(maxrecord<=0)
													{
														where_clause.delete(0,where_clause.length());
														if (!family_org_id.equals(""))
																where_clause.append(" and a.family_org_id = '*ALL' ");
														where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"' ");
														where_clause.append(" and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
														where_clause.append(" and a.relationship_code = '*ALL' ");
														if(rs != null) rs.close();
														rs=stmt1.executeQuery(main_sql+where_clause.toString());
														rs.last();
														maxrecord = rs.getRow();
														rs.beforeFirst();

														if(maxrecord<=0)
														{
															
															where_clause.delete(0,where_clause.length());
															if (!family_org_id.equals(""))
																where_clause.append(" and a.family_org_id = '*ALL' ");
															where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"' ");
															where_clause.append(" and a.name_prefix = '*ALL' ");
															where_clause.append(" and a.relationship_code = '"+relationship_to_head+"' ");
															if(rs != null) rs.close();
															rs=stmt1.executeQuery(main_sql+where_clause.toString());
															rs.last();
															maxrecord = rs.getRow();
															rs.beforeFirst();
															if(maxrecord<=0){
																
																where_clause.delete(0,where_clause.length());
							  
															if (!family_org_id.equals(""))
																 where_clause.append(" and a.family_org_id = '*ALL' ");
															where_clause.append(" and a.family_org_sub_id ='"+family_org_sub_id+"' ");
															where_clause.append(" and a.name_prefix = '*ALL' ");
															where_clause.append(" and a.relationship_code = '*ALL' ");
															if(rs != null) rs.close();
															rs=stmt1.executeQuery(main_sql+where_clause.toString());
															rs.last();
															maxrecord = rs.getRow();
															rs.beforeFirst();
                          if(maxrecord<=0)
						  {
							 where_clause.delete(0,where_clause.length()); 
						 if (!family_org_id.equals(""))
							 where_clause.append(" and a.family_org_id = '*ALL' ");
						 where_clause.append(" and a.family_org_sub_id = '*ALL' ");
						 where_clause.append(" and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
						 where_clause.append(" and a.relationship_code = '"+relationship_to_head+"' ");
						if(rs != null) rs.close();
						rs=stmt1.executeQuery(main_sql+where_clause.toString());
						rs.last();
						maxrecord = rs.getRow();
						rs.beforeFirst();
						if(maxrecord<=0){
							where_clause.delete(0,where_clause.length()); 	
						 if (!family_org_id.equals(""))
							 where_clause.append(" and a.family_org_id = '*ALL' ");
						 where_clause.append(" and a.family_org_sub_id = '*ALL' ");
						 where_clause.append(" and a.name_prefix='"+singleToDoubleQuotes(name_prefix)+"' ");
						 where_clause.append(" and a.relationship_code = '*ALL' ");
						 if(rs != null) rs.close();
						 rs=stmt1.executeQuery(main_sql+where_clause.toString());
						 rs.last();
						 maxrecord = rs.getRow();
						 rs.beforeFirst();
                         if(maxrecord<=0) 
						 {
							where_clause.delete(0,where_clause.length()); 		 
							if (!family_org_id.equals(""))
								 where_clause.append(" and a.family_org_id = '*ALL' ");
							where_clause.append(" and a.family_org_sub_id = '*ALL' ");
							where_clause.append(" and a.name_prefix = '*ALL' ");
							where_clause.append(" and a.relationship_code = '"+relationship_to_head+"' ");
							if(rs != null) rs.close();
							rs=stmt1.executeQuery(main_sql+where_clause.toString());
							rs.last();
							maxrecord = rs.getRow();
							rs.beforeFirst();

						 if(maxrecord<=0)
						 {
							 where_clause.delete(0,where_clause.length()); 							  
							  
							 where_clause.append("and a.family_org_id = '*ALL' and a.name_prefix = '*ALL' and a.family_org_sub_id = '*ALL'  and a.relationship_code = '*ALL' ");
							  
							 rs=stmt1.executeQuery(main_sql+where_clause.toString());
							 rs.last();
							 maxrecord = rs.getRow();
							 rs.beforeFirst();
					      }
					     }
					    }
					   }
					  }
					 }
				    }
				   }
				  }
				 }
				}
			   }
			  }
			 }
			}
		   }    

		    if(maxrecord == 1)
			{
				  rs.next();
				  desc = checkForNull(rs.getString("patcategory"));
				  code = checkForNull(rs.getString("PAT_CAT_CODE"));  
 				  if (!(patCatDB.equals("")) && (patCatDB.equals(code)) )
					  exp_val_appl_yn = 	 checkForNull(rs.getString("exp_val_appl_yn"));
				  
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(code));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block9Bytes, _wl_block9);

			}
				temp_sql = temp_sql+where_clause.toString();
				
			
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(temp_sql));
            _bw.write(_wl_block11Bytes, _wl_block11);

	  }
	  else
	  if ( family_org_membership.equals("4")) 
	   {
			 main_sql = "select distinct a.PAT_CAT_CODE,b.short_desc patcategory,b.exp_val_appl_yn from mp_pat_category_deriv_rule a,mp_pat_category b where a.pat_cat_code=b.pat_cat_code and a.MEMBERSHIP_TYPE='4' and a.FAMILY_ORG_ID = '*NA' and a.FAMILY_ORG_SUB_ID = '*NA'  and a.RELATIONSHIP_CODE = '*ALL'";

			 temp_sql = "SELECT distinct a.PAT_CAT_CODE code, b.short_desc description FROM mp_pat_category_deriv_rule a,mp_pat_category b WHERE a.pat_cat_code=b.pat_cat_code AND a.MEMBERSHIP_TYPE='4' and a.FAMILY_ORG_ID = '*NA' AND UPPER(a.PAT_CAT_CODE) LIKE UPPER(?) AND UPPER(b.short_desc) LIKE UPPER(?) AND a.FAMILY_ORG_SUB_ID = '*NA'  and a.RELATIONSHIP_CODE = '*ALL'";
		
			 rs=stmt1.executeQuery(main_sql);
			 int cnt = 0;
			 rs.last();
			 maxrecord = rs.getRow();			  
			 rs.beforeFirst();
			 if(maxrecord>0) {
				 if(maxrecord==1) {				
					while(rs.next()) {
						cnt++;
						desc = checkForNull(rs.getString("patcategory"));
						code = checkForNull(rs.getString("PAT_CAT_CODE"));				  
						if (!(patCatDB.equals("")) && (patCatDB.equals(code)) )
							exp_val_appl_yn = 	 checkForNull(rs.getString("exp_val_appl_yn"));
				  
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(code));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block12Bytes, _wl_block12);

					}				  
				 }
			 } else {
				
				main_sql = "select a.PAT_CAT_CODE,b.short_desc patcategory,b.exp_val_appl_yn from mp_pat_category_deriv_rule a,mp_pat_category b where a.pat_cat_code=b.pat_cat_code and a.MEMBERSHIP_TYPE='4' and a.FAMILY_ORG_ID ='*NA' and a.FAMILY_ORG_SUB_ID = '*NA' and a.RELATIONSHIP_CODE = '*ALL' order by b.short_desc"; 
				
				temp_sql = "select distinct a.PAT_CAT_CODE code,b.short_desc description from mp_pat_category_deriv_rule a,mp_pat_category b where a.pat_cat_code=b.pat_cat_code and a.MEMBERSHIP_TYPE='4' and a.FAMILY_ORG_ID ='*NA' AND UPPER(a.PAT_CAT_CODE) LIKE UPPER(?) AND UPPER(b.short_desc) LIKE UPPER(?) and a.FAMILY_ORG_SUB_ID = '*NA' and a.RELATIONSHIP_CODE = '*ALL'"; 

				rs=stmt1.executeQuery(main_sql);
				rs.last();
				maxrecord = rs.getRow();
				rs.beforeFirst();

				if(maxrecord == 1)
				{
					  rs.next();
					  desc = checkForNull(rs.getString("patcategory"));
					  code = checkForNull(rs.getString("PAT_CAT_CODE"));
					  if (!(patCatDB.equals("")) && (patCatDB.equals(code)) )
						  exp_val_appl_yn = 	 checkForNull(rs.getString("exp_val_appl_yn"));
					  
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block15Bytes, _wl_block15);

				 }				
			}
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(temp_sql));
            _bw.write(_wl_block9Bytes, _wl_block9);

		}
		if (exp_val_appl_yn.equals("Y"))
			 visibility = "visible";
		else
			 visibility = "hidden";
		
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patCatDB));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patCatDB));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(visibility));
            _bw.write(_wl_block19Bytes, _wl_block19);

	}catch (Exception e){
		//out.println(e);
		e.printStackTrace();
	}
	finally{
		if(stmt != null) stmt.close();
		if(rs!=null) rs.close();
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
