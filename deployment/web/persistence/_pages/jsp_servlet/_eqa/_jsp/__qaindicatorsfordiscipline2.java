package jsp_servlet._eqa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __qaindicatorsfordiscipline2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QAIndicatorsForDiscipline2.jsp", 1742817544977L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<head>\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/messages.js\' language=\'javascript\'></script>\n    <script src=\'../../eQA/js/QAIndicatorsForDiscipline.js\' language=\'javascript\' ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n <body onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n<form name=\'result_form\' id=\'result_form\' action=\"QAIndicatorsForDiscipline2.jsp\" method=\"post\">\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\'));\n\t\t</script>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<P>\n<table  width=\'90%\' align=\'center\' >\t\n<tr >\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n        \n\t   <td class=\'white\' width=\'95%\'>&nbsp;</td>\n    \t<td  align=\'right\' nowrap>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t    \n\t\t<td class=\'white\'>\n\n\t   ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<a HREF=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =", ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =");\' text-decoration=\'none\'>Previous</a>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =");\'  text-decoration=\'none\'>Next</a>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n</td>\n</tr>\n</table>\n\n\t<table cellpadding=0 cellspacing=0 border=1 width=\'90%\' align=\'center\'>\n\t\t<th nowrap>Indicator ID</th>\n\t\t<th nowrap>Description</th>\n\t    <th nowrap>Select</th>\n\t\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n\t\t\t<tr>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" nowrap align=center  width=10%>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t<input type=hidden name=qd";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\t\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"  width=15% nowrap > ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" &nbsp;&nbsp;\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t   \n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" nowrap align=center>\n\t\t\t\t<input type=checkbox  onclick=\"chkValue(this,";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =")\"  name=\'strKey";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' \t\t\t\t\tvalue =\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'  ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="  value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' > </td>\n                 <input type=hidden name=h";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =">\n\t\t\t\t<input type=hidden name=\'strValue";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' id=\'strValue";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t\t\t<input type=hidden name=\'removedValue";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'removedValue";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n</table>\n\n</div>\n<input type=hidden name=\'count\' id=\'count\' value=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =">\n\n\t\n<input type=\'hidden\' name=dispid id=dispid value=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =">\n<input type=\'hidden\' name=indi id=indi value=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =">\n\n<input type=\'hidden\' name=\'n\' id=\'n\' value=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =">\n<input type=\'hidden\' name=\'fnname\' id=\'fnname\' value=\"Insert\">\n<input type=\'hidden\' name=\'insert_table\' id=\'insert_table\' value=\'Y\'>\n<input type=\'hidden\' name=\'flagYN\' id=\'flagYN\' value=\'Y\'>\n<input type=\'hidden\' name=\'temp\' id=\'temp\'>\n<input type=\"Hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<input type=\"Hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n<input type=\"Hidden\" name=\"counter\" id=\"counter\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

	
	public static String checkForNull(String inputString)
	{
		return( ((inputString==null) || (inputString.equals("null"))) ? "" : inputString );
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return( ((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString );
	}



    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);


Connection con					=	null;
HashMap hashIndicator           =   null;
PreparedStatement pstmt			=	null;
ResultSet rset					=	null ;

String class_value				= "QRYEVEN";
String clindid					= "";
String dispid					= "";
String checked_yn				= "";
String qind_clind_desc			= "";
String checkedValues	        = "";
String checkedKey		        = "";
String strKey			        = "";
String strValue			        = "";

boolean boolFlag                = false;

int	   n						= 0;

try
{
int  count                = request.getParameter("n")==null ? 0 : Integer.parseInt(request.getParameter("n"));
//String	facilityId 		  = (String) session.getValue( "facility_id" ) ;
String from               = request.getParameter( "from" ) ;
String to                 = request.getParameter( "to" ) ;
ArrayList keys            = (ArrayList)session.getValue("arrayKeys");

if(keys == null)
{
	keys = new ArrayList();
}
String flagYN = request.getParameter("flagYN")==null ? "N" : request.getParameter("flagYN");
int counter   = request.getParameter("counter")==null ? 0 : Integer.parseInt(request.getParameter("counter"));

String indi         =  "";
String sql          =  "";

int maxRecord       =  0;
int start           =  0;
int end             =  0;
int i               =  1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt(from) ;

	if ( to == null )
	  	end = 10 ;
	else
		end = Integer.parseInt( to ) ;



            _bw.write(_wl_block4Bytes, _wl_block4);

		
	con					=	ConnectionManager.getConnection(request);
	dispid				=	checkForNull(request.getParameter("dispid"));
	indi				=	checkForNull(request.getParameter("indi"));
	if(indi.equals("null")||indi==null) indi="";
	String removeValue = "";
	String countsql ="select  count(*)  FROM QA_QIND_CLIND  A,QA_QIND_DISCIPLINE_CLIND B WHERE B.QIND_DISCIPLINE_ID(+) ='"+dispid+"' and A.QIND_CLIND_ID=B.QIND_CLIND_ID(+)  and A.QIND_CLIND_ID like '"+indi+"%'";
	hashIndicator   = (HashMap)session.getValue("hashIndicator");
	if(hashIndicator == null)
	{
		hashIndicator = new HashMap();
	}
	int count_value=0;
	if(hashIndicator != null)
	{
		
		for(int index=0 ;index < count;index++)
		{
				checkedKey = request.getParameter("strKey"+index) == null ? "" : request.getParameter("strKey"+index);
				if(!checkedKey.equals(""))
				{
					checkedValues = request.getParameter("strValue"+index) == null ? "" : request.getParameter("strValue"+index);
					hashIndicator.put (checkedKey,checkedValues);
				}
				else
				{
	removeValue = request.getParameter("removedValue"+index) == null ? "" : request.getParameter("removedValue"+index);
					if(!removeValue.equals(""))
					{

						hashIndicator.remove(removeValue);
						counter++;
					}
					}
				}
		
	}
	pstmt	=	con.prepareStatement(countsql);
	rset    =   pstmt.executeQuery();
  	if ((rset != null) && (rset.next()))
	{
		count_value= rset.getInt(1);
		maxRecord=count_value;
	}   if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
	if (count_value==0)
	{

	
            _bw.write(_wl_block5Bytes, _wl_block5);

		return;
	}
	else
	{
		 sql="select  A.QIND_CLIND_ID CLINDID,A.QIND_CLIND_DESC   QIND_DISCIPLINE_DESC,DECODE(B.QIND_DISCIPLINE_ID,'"+dispid+"','CHECKED','UNCHECKED')  CHECKED_YN FROM QA_QIND_CLIND  A,QA_QIND_DISCIPLINE_CLIND  B WHERE B.QIND_DISCIPLINE_ID(+)='"+dispid+"' and A.QIND_CLIND_ID=B.QIND_CLIND_ID(+)  and A.QIND_CLIND_ID like '"+indi+"%' ORDER BY TO_NUMBER(A.QIND_CLIND_ID)";

	}

	pstmt = con.prepareStatement(sql);
	rset  = pstmt.executeQuery();
	
            _bw.write(_wl_block6Bytes, _wl_block6);
if (!(start <= 1) || !( (start+10) > maxRecord ))
		{
            _bw.write(_wl_block7Bytes, _wl_block7);
}else{
            _bw.write(_wl_block8Bytes, _wl_block8);
}
            _bw.write(_wl_block4Bytes, _wl_block4);

if ( !(start <= 1) )
		{

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(start-10));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(end-10));
            _bw.write(_wl_block11Bytes, _wl_block11);

		}

	if ( !( (start+10) > maxRecord ) )
	{

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(start+10));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(end+10));
            _bw.write(_wl_block12Bytes, _wl_block12);

	}

            _bw.write(_wl_block13Bytes, _wl_block13);


	
	  String tempString = "";
	  if(hashIndicator != null)
		{
			if(flagYN.equals("N"))
				hashIndicator.clear();
			if(hashIndicator.size() == 0)
		{
		while(rset.next())
			{
			clindid           = checkForNull(rset.getString("CLINDID"));
			qind_clind_desc   = checkForNull(rset.getString("QIND_DISCIPLINE_DESC"));
	        checked_yn        = rset.getString("CHECKED_YN");
            strKey = dispid + "~" + clindid;
			
			if(checked_yn.equals("CHECKED"))
				{
				
			strValue = ""+"I";
			hashIndicator.put(strKey,strValue);
			}
			if(!keys.contains(strKey))
				{
					
					keys.add(strKey);
				}
			}if(rset!=null) rset.close();
		  }
		}
		rset = pstmt.executeQuery();
		if (rset != null)
	{
		
		if( start != 1 )
	    for( int j=1; j<start; i++,j++ ){
	  rset.next() ;
    
	
	  }

		
		while(rset.next() && i<=end)
		{
			clindid           = checkForNull(rset.getString("CLINDID"));
			qind_clind_desc   = checkForNull(rset.getString("QIND_DISCIPLINE_DESC"));
	        checked_yn        = rset.getString("CHECKED_YN");
           	strKey            = dispid + "~" + clindid;
			strValue          = ""+"I";

			if(class_value.equals("QRYEVEN"))
				class_value = "QRYODD";
			else
				class_value = "QRYEVEN";
						
			if(hashIndicator != null)
			{
				tempString = hashIndicator.get(strKey) == null ? "" : (String) hashIndicator.get(strKey) ;
			    
				
				if(!tempString.equals(""))
				{
					boolFlag=true;
				}
				else
				{
					boolFlag=false;
				}
			}
			
				if(boolFlag==true)
				{
					
					checked_yn = "CHECKED";
				}
				else
				{
					checked_yn = "";
				}


			
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(clindid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(n% id=qd<%=n));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(clindid));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(qind_clind_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(n));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(n));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strKey));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(checked_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strKey));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(n% id=h<%=n));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(n));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(n));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(n));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(n));
            _bw.write(_wl_block31Bytes, _wl_block31);

			

			i++;
		n++;
		
		}
		}if(pstmt!=null) pstmt.close();
		 if(rset!=null)  rset.close();

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(dispid));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(indi));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(n));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(from));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(to));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block39Bytes, _wl_block39);

	
	session.putValue("hashIndicator",hashIndicator);
	session.putValue("arrayKeys",keys);
	}

	catch (Exception e){
	out.println("Exception in QAIndicatorsForDiscipline2"+e.toString());
	}
	finally {
			
		 ConnectionManager.returnConnection(con,request);
	}


            _bw.write(_wl_block40Bytes, _wl_block40);
            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
