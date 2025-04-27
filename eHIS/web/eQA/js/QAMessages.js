var messageArray = new Array() ;
messageArray["MANDATORY_YN"]		= "APP-QA0001 This field :1 cannot be null";
messageArray["APPLICABLE_YN"]		= "APP-QA0002 Please select the applicability ";
messageArray["SYSTEM_MODIFY_NO"]	= "APP-QA0003 System generated indicator. Modification not allowed ";
messageArray["COMMENTS_ENTER"]		= "APP-QA0004 Please Enter the comments";
messageArray["SUCCESS"]				= "APP-QA0005 Successfully Recorded";
messageArray["SYSTEM_CREATED"]		= "APP-QA0006 System Indicator. Entry not allowed";
messageArray["DATECHECK_TO"]		= "APP-QA0007 Invalid Date. To Date should be greater than From Date";
messageArray["DATECHECK_FROM"]		= "APP-QA0008 Invalid Date. From Date cannot  be greater than default date";
messageArray["PAT_CLASS_MANDATORY"] = "APP-QA0009 Patient class is mandatory";
messageArray["DATECHECK_TO_1"]		= "APP-QA0010 Invalid Date. TO Date cannot  be greater than default date";
messageArray["SEQUENCE_NOT_ZERO"]	= "APP-QA0011 The value entered should be greater than zero";
messageArray["CHECKPERIODFROMTO"]	= "APP-QA0012 Period From must be greater than  Period To";
messageArray["QA_PARAM_NOT_FOUND"]  = "APP-QA0013 QA Parameter need to be set to step in" ;
messageArray["CHECK_ATLEAST_ONE"]   = "APP-QA0014 Atleast one checkbox should be checked before apply" ;
messageArray["NO_RECORD_FOUND_FOR_CRITERIA"]   = "APP-000061 Query caused no records to be retrieved" ;


function getMessage( message_ref ) {
    var message = messageArray[message_ref] ;
    if ( message == null ) message = message_ref  ;
    return message ;
}
