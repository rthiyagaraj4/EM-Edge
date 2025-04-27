<!DOCTYPE html>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@page  contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
	<script language='javascript'>
	var rows = new Array();
	var rowLength=0;
	var line_no=0;
	var pre_morbid_rows = new Array();
	var pre_morbid_len=0;
</script>
<script language='javascript'>
	 function checkSpl( val ) {
    var result = "" ;
    var ch = "" ;
//commented for 24816 by AnithaJ
   /* var indVal = 0;
    while ( (indVal = val.indexOf('\n',indVal)) != -1 )
    {
        val = val.replace("\n","\"");
    }*/
    var spChars = new Array( "<", ">", "&", "\"", "'" ) ;
    var chChars = new Array( "&lt;", "&gt;", "&amp;", "&quot;", "&apos;" ) ;

    for(i=0; i<val.length; i++) {
        for(j=0; j<spChars.length; j++) {
            if ( val.substring(i,i+1) == spChars[j] ) {
                ch = chChars[j] ;
                j=spChars.length ;
            } else {
                ch = val.substring(i,i+1) ;
            }
        }
        result += ch ;
    }
    //alert(result)
    return result ;
}
	 function createXMLForPreMorbid(){
	  var rows=parent.pre_anesthesia_objectcollect_frame.pre_morbid_rows;
	  var table_name="AT_RECORD_PREOP_PREMORBID";
	  var len = rows.length;
	  var xmlString ="";
	  for(var i=0;i<len;i++){
		if(rows[i]!=null && rows[i].db_mode!='L'){
		xmlString+="<PREMORBID_DTL"+i+" ";
		xmlString+="pre_morbid_code=\""+rows[i].pre_morbid_code+"\""+" ";
		xmlString+="pre_morbid_desc=\""+rows[i].pre_morbid_desc+"\""+" ";
		xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="remarks=\""+checkSpl( rows[i].remarks )+"\""+" "; 
		xmlString+="table_name=\""+table_name+"\""+" />";		 
		}
	  }
	  return xmlString;
	}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="ObjectsCollectForm" id="ObjectsCollectForm">
</form>
</body>
</html>

