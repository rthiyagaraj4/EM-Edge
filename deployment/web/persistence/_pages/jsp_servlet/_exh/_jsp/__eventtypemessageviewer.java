package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;
import oracle.sql.ARRAY;
import eXH.XHIdentify;
import java.util.Arrays;
import java.util.regex.Pattern;;

public final class __eventtypemessageviewer extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/EventTypeMessageViewer.jsp", 1709122331382L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html> \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<!--head-->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\n<head>\n<link rel=\"StyleSheet\" href=\"../../eXH/html/IeStyle.css\" type=\"text/css\" />\n<link rel=\"StyleSheet\" href=\"../../eXH/html/dtree.css\" type=\"text/css\" />\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n<link rel=\"StyleSheet\" href=\"../../eXH/html/lris_style.css\" type=\"text/css\" />\n<script type=\"text/javascript\" src=\"../../eXH/js/dtree1.js\"></script> \n \n\t<script>\n\t\n\t</script>\n</head>  \n<BODY   >\n<form name=\"view_segment_form\" id=\"view_segment_form\">\n                        \n<div class=\'dtree\'>\n\t<script type=\"text/javascript\" src=\"../../eXH/js/dtree1.js\"></script>\n<script type=\'text/javascript\'>\n\td = new dTree(\'d\');\n\td.config.useStatusText=true;\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<body class=\'TREEBODY\'>\n<script>\nvar count=1;\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\ndocument.write(d);\nd.openAll();\n\n\n\n\nfunction replacefun(str)\n{\nif(str.indexOf(\'+\')!=-1)\n\t{\n\tvar t = /\\+/g; \nstr=str.replace(t,\" \");\n\n    \n\t}\n\telse\n\t{\n\n\t}\n\treturn str;\n}\n\n\n</script>\n\n</body>\n\n\n</form>\n\n</body>\n</div>\n</html>\n\n\n\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

String locale = ((String)session.getAttribute("LOCALE"));
Connection connection = null;
Statement  oraclestatement = null;
HashMap resultsQry = null;
HashMap resultssegQry = null;
Statement  statement = null;

String eventType="";
String eventName="";
String appl_id="";
String Standard_code="";
String System_def_string="";
String appl_name="";
appl_id=(String)session.getAttribute("appl_id");
appl_name=(String)session.getAttribute("appl_name");
eventType=(String)session.getAttribute("Event_id");
eventName=(String)session.getAttribute("event_name");
Standard_code=(String)session.getAttribute("stand_code");
String profile_id="";
int capval=0;
Pattern Regex = null;

ResultSet rset=null; 

ArrayList seg=new ArrayList();
int countpip=0;
String replacestr="";
try
	{
		if(connection==null) connection = ConnectionManager.getConnection();
      
      }
      catch(Exception exp)
      {
		 System.out.println("Error in calling getconnection method of EventTypeMessageViewer.jsp :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }
try
{
	resultsQry=XHIdentify.treeHashMap(connection,locale);
    resultssegQry=XHIdentify.treeSegHashMap(connection,locale); 
	int k=0;
String profileqry="select PROFILE_ID from XH_APPL_EVENT_SEGMENT where application_ID = '"+appl_id+"' and eVENT_TYPE='"+eventType+"'  AND ROWNUM = 1";

//statement=connection.createStatement();
 oraclestatement=connection.createStatement();
//reset=statement.executeQuery(profileqry);
rset=oraclestatement.executeQuery(profileqry);

while(rset.next())
{ 
	profile_id=rset.getString(1);
}
	 
String usrsql="select segment_type from XH_EVENT_TYPE_SEGMENT where event_type='"+eventType+"' and IN_USE_YN='Y' ";
	
	
	 rset=oraclestatement.executeQuery(usrsql);
while(rset.next())
{
	seg.add(k,rset.getString(1));
	k++;
}
 

if(statement!=null)
	statement.close();
if(oraclestatement!=null) 
	oraclestatement.close();
		 
if(rset!=null)	   
{
	rset.close();
}

  out.println("d.add(0,-1,'"+XHDBAdapter.checkNull(appl_name)+"','','"+appl_id+"');"); 
 out.println("d.add(1,0,'"+XHDBAdapter.checkNull(eventName)+"','','"+eventName+"');");
 int count=0;
 int countseg=0;
 countseg=seg.size()+1;
for(int i=0;i<seg.size();i++)
	{ 
count=2+i;


if((String)resultssegQry.get((String)seg.get(i))==null) 
  {
out.println("d.add("+count+",1,'"+(String)seg.get(i)+"','','"+(String)seg.get(i)+"');"); 

  }
  else
	{
	  out.println("d.add("+count+",1,'"+(String)resultssegQry.get((String)seg.get(i))+"','','"+(String)resultssegQry.get(i)+"');"); 
	}
/*String segmentqry="SELECT SYSTEM_DEFINED_STRING FROM XH_EVENT_SEGMENT_CONFIG WHERE PROFILE_ID ='SRRHL7P' AND CONFIG_NAME ='NTE' and STANDARD_CODE='SRRHL7' AND Config_type = 'S'";*/
String segmentqry="SELECT SYSTEM_DEFINED_STRING FROM XH_EVENT_SEGMENT_CONFIG WHERE PROFILE_ID ='"+profile_id+"' AND CONFIG_NAME ='"+(String)seg.get(i)+"' and STANDARD_CODE='"+Standard_code+"' AND Config_type = 'S'";
//System.out.println("EventTypeMessageViewer.jsp : segmentqry "+segmentqry);
ResultSet segset=null;
Statement  segstatement = null;
segstatement=connection.createStatement();
segset=segstatement.executeQuery(segmentqry);
while(segset.next())
{

   System_def_string=segset.getString(1);
   String Systemdefstr=System_def_string.replace("#","|");
   try{
        Regex = Pattern.compile("\\|",Pattern.MULTILINE);
      }
      catch(Exception e)
      {
        System.out.println(" (EventTypeMessageViewer.jsp:Regexerorr )"+e);
      }
      String[] array=Regex.split(Systemdefstr);
      for(int check=2;check<array.length;check++)
	  {
	    if(array[check].equals(""))
	    {
	    }
	    else
	    {
		  countpip=array.length;
		  countseg=countseg+1;
          // if((String)resultsQry.get(array[check])==null)
         // {
 
        
			if(array[check].indexOf("^")!=-1)
	       {
				 
	            countpip=countpip+1;
          try{
                Regex = Pattern.compile("\\^",Pattern.MULTILINE);
             }
             catch(Exception e)
             {
                System.out.println("(EventTypeMessageViewer.jsp:erorrRegex-2) "+e);
             } 
                String[] arraycap=Regex.split(array[check]);
             for(int cap=0;cap<arraycap.length;cap++)
		     {

                 

				
				 if(cap==0)
				 {
				  String validation=((String)resultsQry.get(arraycap[cap]))==null?arraycap[cap]:((String)resultsQry.get(arraycap[cap])); out.println("d.add("+countseg+","+count+",replacefun(unescape('"+java.net.URLEncoder.encode(validation)+"')),'','"+arraycap[cap]+"');");
				 capval=countseg;
				 }
				else 
				 {
				  capval=capval+1; 
				  String validation2=((String)resultsQry.get(arraycap[cap]))==null?arraycap[cap]:((String)resultsQry.get(arraycap[cap]));
				  
				 out.println("d.add("+(capval)+","+(countseg)+",replacefun(unescape('"+java.net.URLEncoder.encode(validation2)+"')),'','"+arraycap[cap]+"');"); 
				 }
				 
				 //countseg=countseg+1; //out.println("d.add("+countpip+","+countseg+",replacefun(unescape('"+arraycap[cap]+"')),'','"+arraycap[cap]+"');");
		     }
			 countseg=capval+1;
	        }
			else
			  {
					  String validation1=((String)resultsQry.get(array[check]))==null?array[check]:java.net.URLEncoder.encode((String)resultsQry.get(array[check]));
							replacestr=validation1;	 out.println("d.add("+countseg+","+count+",replacefun(unescape('"+replacestr+"')),'','"+array[check]+"');");
			  }
         // }
		 // else
		 // {
         //   replacestr=((String)resultsQry.get(array[check]));
            //out.println("d.add("+countseg+","+count+",replacefun(unescape('"+java.net.URLEncoder.encode(replacestr)+"')),'','"+array[check]+"');");
		 //  }

		   
   	    }
	  	  

	}
}

	if(segset!=null)
	{
		segset.close();
	}
	if(segstatement!=null)
	{
		segstatement.close();
	}



	  }


//out.println("d.add("+count+",2,'"+(String)seg.get(i)+"','','"+(String)seg.get(i)+"');")
	


 
} 
catch(Exception exp)
    {
	   exp.printStackTrace(System.err);
    }
	finally
	{
	 try{
			if(rset!=null)	   
			{
				rset.close();
			}
						
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of EventTypeMessageViewer.jsp :"+ex.toString());
		   ex.printStackTrace(System.err); }
	}


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
