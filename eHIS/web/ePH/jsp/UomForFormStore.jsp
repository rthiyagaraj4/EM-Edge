<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, ePH.*" contentType="text/html;charset=ISO-8859-1" %>
<%-- Mandatory declarations start --%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
try {


    Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
    hash						= (Hashtable)hash.get( "SEARCH" ) ;
	String bean_id				= (String) hash.get( "bean_id" );
	String bean_name			= (String) hash.get( "bean_name" );
	int start					= Integer.parseInt((String) hash.get("start"));
	int end						= Integer.parseInt((String) hash.get("end"));
	String def_code				= (String) hash.get( "def_code" );
	ArrayList appl_Uom			=	new ArrayList();
	ArrayList associated_Uom	=	new ArrayList();
	Hashtable record			=	null;
	Hashtable associated_recs	=	null;
	String uom_code				=	"";
	String uom_desc				=	"";
	String uom_select			=	"";
	String uom_default			=	"";
	String uom_flag				=	"";
	UomForFormBean beanObj		= (UomForFormBean)getBeanObject(bean_id,bean_name ,request);
	boolean found				=	false;

	String frm_link				= (String) hash.get( "frm_link" );

	if(frm_link.equals("select"))
	{
		while(start<=end)
		{

		uom_code	=	(String) hash.get( "UomCode_"+start);
		uom_desc	=	(String) hash.get( "UomDesc_"+start);
		uom_default	=	(String) hash.get( "default_"+start);
		uom_select	=	(String) hash.get( "select_"+start);
		uom_flag	=	(String) hash.get( "flag_"+start);
		if(uom_code ==null || uom_desc==null || uom_default==null || uom_select==null)
		break;
		associated_recs	=	new Hashtable();
		associated_recs.put("code",uom_code);
		associated_recs.put("desc",uom_desc);
		associated_recs.put("default",uom_default);
		associated_recs.put("select",uom_select);
		if(uom_flag.equals("I") && uom_select.equals("Y"))	{
			associated_recs.put("flag","I");
		}
		else if(uom_flag.equals("I") && uom_select.equals("N"))	{
			associated_recs.put("default","N");
			associated_recs.put("flag","N");
		}
		else if(uom_flag.equals("DB") && uom_select.equals("Y"))	{
			if(def_code.equals(uom_code) && uom_default.equals("N"))
				associated_recs.put("flag","U");
			else if(!def_code.equals(uom_code) && uom_default.equals("Y"))
				associated_recs.put("flag","U");
			else
				associated_recs.put("flag","DB");
		}
		else if(uom_flag.equals("DB") && uom_select.equals("N"))	{
			associated_recs.put("default","N");
			associated_recs.put("flag","D");
		}
		else if(uom_flag.equals("D") && uom_select.equals("N"))	{
			associated_recs.put("default","N");
			associated_recs.put("flag","D");
		}
		else if(uom_flag.equals("D") && uom_select.equals("Y"))	{
			if(!def_code.equals(uom_code) && uom_default.equals("Y"))
				associated_recs.put("flag","U");
			else
				associated_recs.put("flag","DB");
		}
		else if(uom_flag.equals("U") && uom_select.equals("Y"))	{
			if(!def_code.equals(uom_code) && uom_default.equals("N"))
				associated_recs.put("flag","DB");
			else if(def_code.equals(uom_code) && uom_default.equals("Y"))
				associated_recs.put("flag","DB");
			else
				associated_recs.put("flag","U");
		}
		else if(uom_flag.equals("U") && uom_select.equals("N"))	{
						associated_recs.put("default","N");
						associated_recs.put("flag","D");
		}
		else
		associated_recs.put("flag","N");
		associated_Uom.add(associated_recs);
		start++;
		}

	//Update the newly added Records
		ArrayList vals	=	beanObj.getApplicableUom();
		for(int n=0; n<associated_Uom.size(); n++)	{
		Hashtable	assrec	=	(Hashtable)	associated_Uom.get(n);
		String ass_code		=		(String)assrec.get("code");
				for(int p=0; p<vals.size(); p++)	{
					Hashtable	selrec =	(Hashtable)	vals.get(p);
					String	sel_code   = (String) selrec.get("code");
					if(sel_code.equals(ass_code))	{
					vals.set(p,assrec);
					break;
					}
				}

		}

	}
	else	{

	while(start<=end)
	{
	uom_code	=	(String) hash.get( "UomCode_"+start);
	uom_desc	=	(String) hash.get( "UomDesc_"+start);
	uom_default	=	(String) hash.get( "default_"+start);
	uom_select	=	(String) hash.get( "select_"+start);
	uom_flag	=	(String) hash.get( "flag_"+start);

	if(uom_code ==null || uom_desc==null || uom_default==null || uom_select==null)
		break;
	record	=	new Hashtable();
	record.put("code",uom_code);
	record.put("desc",uom_desc);
		if(uom_default.equals("Y"))	{
		found=true;
		}
	record.put("default",uom_default);
	record.put("select",uom_select);
	if(uom_flag.equals("N") && uom_select.equals("Y"))
		record.put("flag","I");
	else if(uom_flag.equals("I") && uom_select.equals("Y"))
		record.put("flag","I");
	else if(uom_flag.equals("I") && uom_select.equals("N"))	{
		record.put("default","N");
		record.put("flag","N");
	}
	else if(uom_flag.equals("DB") && uom_select.equals("Y"))	{
		if(def_code.equals(uom_code) && uom_default.equals("N"))
			record.put("flag","U");
		else if(uom_default.equals("N"))
			record.put("flag","DB");
		else
			record.put("flag","U");
	}
	else if(uom_flag.equals("DB") && uom_select.equals("N"))	{
			record.put("default","N");
			record.put("flag","D");
	}
	else if(uom_flag.equals("D") && uom_select.equals("N"))	{
			record.put("default","N");
			record.put("flag","D");
		}
	else if(uom_flag.equals("D") && uom_select.equals("Y"))	{
			record.put("flag","D");
		}
	else if(uom_flag.equals("U") && uom_select.equals("Y"))	{
		 	record.put("flag","U");
		}
	else
		record.put("flag","N");

	appl_Uom.add(record);
	start++;
	}

		if(found)	{
		beanObj.makeDefault();
		}
	
	
	//Update the newly added Records
		ArrayList vals	=	beanObj.getApplicableUom();
		for(int n=0; n<appl_Uom.size(); n++)	{
		Hashtable	assrec	=	(Hashtable)	appl_Uom.get(n);
		String ass_code		=		(String)assrec.get("code");
				for(int p=0; p<vals.size(); p++)	{
					Hashtable	selrec =	(Hashtable)	vals.get(p);
					String	sel_code   = (String) selrec.get("code");
					if(sel_code.equals(ass_code))	{
					vals.set(p,assrec);
					break;
					}
				}

		}

	}

putObjectInBean(bean_id	,beanObj,request);

	}catch (Exception e) {
	out.println("alert(\"" + e + "\");") ;
	}

%>
