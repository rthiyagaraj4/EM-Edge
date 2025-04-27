
/* Result Sets Interface */
#ifndef SQL_CRSR
#  define SQL_CRSR
  struct sql_cursor
  {
    unsigned int curocn;
    void *ptr1;
    void *ptr2;
    unsigned int magic;
  };
  typedef struct sql_cursor sql_cursor;
  typedef struct sql_cursor SQL_CURSOR;
#endif /* SQL_CRSR */

/* Thread Safety */
typedef void * sql_context;
typedef void * SQL_CONTEXT;

/* Object support */
struct sqltvn
{
  unsigned char *tvnvsn; 
  unsigned short tvnvsnl; 
  unsigned char *tvnnm;
  unsigned short tvnnml; 
  unsigned char *tvnsnm;
  unsigned short tvnsnml;
};
typedef struct sqltvn sqltvn;

struct sqladts
{
  unsigned int adtvsn; 
  unsigned short adtmode; 
  unsigned short adtnum;  
  sqltvn adttvn[1];       
};
typedef struct sqladts sqladts;

static struct sqladts sqladt = {
  1,1,0,
};

/* Binding to PL/SQL Records */
struct sqltdss
{
  unsigned int tdsvsn; 
  unsigned short tdsnum; 
  unsigned char *tdsval[1]; 
};
typedef struct sqltdss sqltdss;
static struct sqltdss sqltds =
{
  1,
  0,
};

/* File name & Package Name */
struct sqlcxp
{
  unsigned short fillen;
           char  filnam[42];
};
static const struct sqlcxp sqlfpn =
{
    41,
    "Y:\\trunk\\eHIS11g\\eHIS2Tier/RD/RDBPURGE.pc"
};


static unsigned int sqlctx = 1288575411;


static struct sqlexd {
   unsigned int   sqlvsn;
   unsigned int   arrsiz;
   unsigned int   iters;
   unsigned int   offset;
   unsigned short selerr;
   unsigned short sqlety;
   unsigned int   occurs;
      const short *cud;
   unsigned char  *sqlest;
      const char  *stmt;
   sqladts *sqladtp;
   sqltdss *sqltdsp;
            void  **sqphsv;
   unsigned int   *sqphsl;
            int   *sqphss;
            void  **sqpind;
            int   *sqpins;
   unsigned int   *sqparm;
   unsigned int   **sqparc;
   unsigned short  *sqpadto;
   unsigned short  *sqptdso;
   unsigned int   sqlcmax;
   unsigned int   sqlcmin;
   unsigned int   sqlcincr;
   unsigned int   sqlctimeout;
   unsigned int   sqlcnowait;
              int   sqfoff;
   unsigned int   sqcmod;
   unsigned int   sqfmod;
            void  *sqhstv[8];
   unsigned int   sqhstl[8];
            int   sqhsts[8];
            void  *sqindv[8];
            int   sqinds[8];
   unsigned int   sqharm[8];
   unsigned int   *sqharc[8];
   unsigned short  sqadto[8];
   unsigned short  sqtdso[8];
} sqlstm = {12,8};

/* SQLLIB Prototypes */
extern void sqlcxt (void **, unsigned int *,
                    struct sqlexd *, const struct sqlcxp *);
extern void sqlcx2t(void **, unsigned int *,
                    struct sqlexd *, const struct sqlcxp *);
extern void sqlbuft(void **, char *);
extern void sqlgs2t(void **, char *);
extern void sqlorat(void **, unsigned int *, void *);

/* Forms Interface */
static const int IAPSUCC = 0;
static const int IAPFAIL = 1403;
static const int IAPFTL  = 535;
extern void sqliem(unsigned char *, signed int *);

 static const char *sq0005 = 
"select SECTION_CODE  from RD_SECTION where STATUS='S' for update of STATUS ";

 static const char *sq0006 = 
"select 'X'  from RD_EXAMINATION where SECTION_CODE=:b0           ";

 static const char *sq0007 = 
"select 'X'  from RD_DEF_STORAGE_LOCN where (OPERATING_FACILITY_ID=:b0 and SE\
CTION_CODE=:b1)           ";

 static const char *sq0008 = 
"select 'X'  from RD_REQUEST where (OPERATING_FACILITY_ID=:b0 and SECTION_COD\
E=:b1)           ";

 static const char *sq0009 = 
"select 'X'  from RD_APPT where (OPERATING_FACILITY_ID=:b0 and SECTION_CODE=:\
b1)           ";

 static const char *sq0010 = 
"select 'X'  from RD_APPT_DEL_TR where (OPERATING_FACILITY_ID=:b0 and SECTION\
_CODE=:b1)           ";

 static const char *sq0011 = 
"select 'X'  from RD_CLINIC where (OPERATING_FACILITY_ID=:b0 and SECTION_CODE\
=:b1)           ";

 static const char *sq0012 = 
"select 'X'  from RD_TRANS_RECORD where (OPERATING_FACILITY_ID=:b0 and SECTIO\
N_CODE=:b1)           ";

 static const char *sq0013 = 
"select 'X'  from RD_APPT_STATS where SECTION_CODE=:b0           ";

 static const char *sq0017 = 
"select EXAM_CODE  from RD_EXAMINATION where STATUS='S' for update of STATUS ";

 static const char *sq0018 = 
"select 'X'  from RD_GROUP_EXAMS where (GROUP_EXAM_CODE=:b0 or COMPONENT_EXAM\
_CODE=:b0)           ";

 static const char *sq0019 = 
"select 'X'  from RD_EXAM_VIEWS where EXAM_CODE=:b0           ";

 static const char *sq0020 = 
"select 'X'  from RD_ITEMS_FOR_EXAM where EXAM_CODE=:b0           ";

 static const char *sq0021 = 
"select 'X'  from RD_CONFLICTING_EXAMS where (EXAM_CODE_1=:b0 or EXAM_CODE_2=\
:b0)           ";

 static const char *sq0022 = 
"select 'X'  from RD_EXAM_VIEW_REQUESTED where (OPERATING_FACILITY_ID=:b0 and\
 EXAM_CODE=:b1)           ";

 static const char *sq0023 = 
"select 'X'  from RD_EXAM_VIEW_REQUESTED where (OPERATING_FACILITY_ID=:b0 and\
 EXAM_CODE=:b1)           ";

 static const char *sq0024 = 
"select 'X'  from RD_ITEMS_CONSUMED where (OPERATING_FACILITY_ID=:b0 and EXAM\
_CODE=:b1)           ";

 static const char *sq0025 = 
"select 'X'  from RD_ITEM_BLNG_SRVC where (OPERATING_FACILITY_ID=:b0 and EXAM\
_CODE=:b1)           ";

 static const char *sq0026 = 
"select 'X'  from RD_ITEM_BATCH where (OPERATING_FACILITY_ID=:b0 and EXAM_COD\
E=:b1)           ";

 static const char *sq0027 = 
"select 'X'  from RD_OTHER_CHARGES where (OPERATING_FACILITY_ID=:b0 and EXAM_\
CODE=:b1)           ";

 static const char *sq0028 = 
"select 'X'  from RD_PAT_EXAM_CONFLICTS where EXAM_CODE=:b0           ";

 static const char *sq0029 = 
"select 'X'  from RD_APPT where (OPERATING_FACILITY_ID=:b0 and EXAM_CODE=:b1)\
           ";

 static const char *sq0030 = 
"select 'X'  from RD_APPT_DEL_TR where (OPERATING_FACILITY_ID=:b0 and EXAM_CO\
DE=:b1)           ";

 static const char *sq0031 = 
"select 'X'  from RD_APPT_STATS where (OPERATING_FACILITY_ID=:b0 and EXAM_COD\
E=:b1)           ";

 static const char *sq0032 = 
"select 'X'  from OR_ORDER_LINE ,OR_ORDER where ((((NVL(OR_ORDER.ORDERING_FAC\
ILITY_ID,OR_ORDER.PERFORMING_FACILITY_ID)=:b0 and OR_ORDER_LINE.ORDER_TYPE_COD\
E=OR_ORDER.ORDER_TYPE_CODE) and OR_ORDER_LINE.ORDER_ID=OR_ORDER.ORDER_ID) and \
OR_ORDER_LINE.ORDER_CATEGORY='RAD') and ORDER_CATALOG_CODE=:b1)           ";

 static const char *sq0035 = 
"select CLINIC_CODE  from RD_CLINIC where (OPERATING_FACILITY_ID=:b0 and STAT\
US='S') for update of STATUS ";

 static const char *sq0036 = 
"select 'X'  from RD_APPT where (OPERATING_FACILITY_ID=:b0 and CLINIC_CODE=:b\
1)           ";

 static const char *sq0037 = 
"select 'X'  from RD_APPT_DEL_TR where (OPERATING_FACILITY_ID=:b0 and CLINIC_\
CODE=:b1)           ";

 static const char *sq0038 = 
"select 'X'  from RD_CLINIC_TIME_TABLE where (OPERATING_FACILITY_ID=:b0 and C\
LINIC_CODE=:b1)           ";

 static const char *sq0039 = 
"select 'X'  from RD_CLINIC_BREAK where (OPERATING_FACILITY_ID=:b0 and CLINIC\
_CODE=:b1)           ";

 static const char *sq0040 = 
"select 'X'  from RD_USER_CLINIC_RIGHTS where (OPERATING_FACILITY_ID=:b0 and \
CLINIC_CODE=:b1)           ";

 static const char *sq0041 = 
"select 'X'  from RD_TRANS_RECORD where (OPERATING_FACILITY_ID=:b0 and CLINIC\
_CODE=:b1)           ";

 static const char *sq0042 = 
"select 'X'  from RD_APPT_STATS where (OPERATING_FACILITY_ID=:b0 and CLINIC_C\
ODE=:b1)           ";

 static const char *sq0045 = 
"select APPT_SERIES_CODE  from RD_APPT_SERIES where (OPERATING_FACILITY_ID=:b\
0 and STATUS='S') for update of STATUS ";

 static const char *sq0046 = 
"select 'X'  from RD_CLINIC where (OPERATING_FACILITY_ID=:b0 and APPT_SERIES_\
CODE=:b1)           ";

 static const char *sq0049 = 
"select VIEW_CODE  from RD_VIEW where STATUS='S' for update of STATUS ";

 static const char *sq0050 = 
"select 'X'  from RD_EXAM_VIEWS where VIEW_CODE=:b0           ";

 static const char *sq0053 = 
"select ORGAN_SITE_ID  from RD_ORGAN_SITE where STATUS='S' for update of STAT\
US ";

 static const char *sq0054 = 
"select 'X'  from RD_EXAMINATION where ORGAN_SITE_ID=:b0           ";

 static const char *sq0057 = 
"select TRANS_MODE_CODE  from RD_TRANSPORT_MODE where STATUS='S' for update o\
f STATUS ";

 static const char *sq0058 = 
"select 'X'  from RD_APPT where (OPERATING_FACILITY_ID=:b0 and TRANSPORT_MODE\
=:b1)           ";

 static const char *sq0059 = 
"select 'X'  from RD_APPT_DEL_TR where (OPERATING_FACILITY_ID=:b0 and TRANSPO\
RT_MODE=:b1)           ";

 static const char *sq0062 = 
"select MEDIA_TYPE_CODE  from RD_RECORDS_MEDIA where STATUS='S' for update of\
 STATUS ";

 static const char *sq0063 = 
"select 'X'  from RD_DEF_STORAGE_LOCN where (OPERATING_FACILITY_ID=:b0 and ME\
DIA_TYPE_CODE=:b1)           ";

 static const char *sq0064 = 
"select 'X'  from RD_EXAMINATION where MEDIA_TYPE_CODE=:b0           ";

 static const char *sq0065 = 
"select 'X'  from RD_EXAM_VIEW_REQUESTED where (OPERATING_FACILITY_ID=:b0 and\
 MEDIA_TYPE_CODE=:b1)           ";

 static const char *sq0068 = 
"select STORAGE_LOCN_CODE  from RD_RECORDS_STORE where (OPERATING_FACILITY_ID\
=:b0 and STATUS='S') for update of STATUS ";

 static const char *sq0069 = 
"select 'X'  from RD_DEF_STORAGE_LOCN where (OPERATING_FACILITY_ID=:b0 and DE\
F_STORAGE_LOCN_CODE=:b1)           ";

 static const char *sq0070 = 
"select 'X'  from RD_EXAM_VIEW_REQUESTED where (OPERATING_FACILITY_ID=:b0 and\
 STORAGE_LOCN_CODE=:b1)           ";

 static const char *sq0071 = 
"select 'X'  from RD_RECORDS_INDEX where (FACILITY_ID=:b0 and STORAGE_LOCN_CO\
DE=:b1)           ";

 static const char *sq0074 = 
"select WING_CODE  from RD_WINGS where (OPERATING_FACILITY_ID=:b0 and STATUS=\
'S') for update of STATUS ";

 static const char *sq0076 = 
"select 'X'  from RD_DEF_STORAGE_LOCN where (OPERATING_FACILITY_ID=:b0 and WI\
NG_CODE=:b1)           ";

 static const char *sq0078 = 
"select 'X'  from RD_REQUEST where (OPERATING_FACILITY_ID=:b0 and WING_CODE=:\
b1)           ";

 static const char *sq0075 = 
"select 'X'  from RD_SECTION_CTL where (OPERATING_FACILITY_ID=:b0 and WING_CO\
DE=:b1)           ";

 static const char *sq0077 = 
"select 'X'  from RD_CLINIC where (OPERATING_FACILITY_ID=:b0 and WING_CODE=:b\
1)           ";

 static const char *sq0081 = 
"select ADMIN_REACTION_CODE  from RD_ADMIN_REACTION where STATUS='S' for upda\
te of STATUS ";

 static const char *sq0082 = 
"select 'X'  from RD_ITEMS_CONSUMED where (OPERATING_FACILITY_ID=:b0 and ADMI\
N_REACTION_CODE=:b1)           ";

 static const char *sq0085 = 
"select ADMIN_ROUTE_CODE  from RD_ADMIN_ROUTE where STATUS='S' for update of \
STATUS ";

 static const char *sq0086 = 
"select 'X'  from RD_ITEMS_CONSUMED where (OPERATING_FACILITY_ID=:b0 and ADMI\
N_ROUTE_CODE=:b1)           ";

 static const char *sq0089 = 
"select ITEM_CLASS_CODE  from RD_ITEM_CLASS where STATUS='S' for update of ST\
ATUS ";

 static const char *sq0090 = 
"select 'X'  from RD_ITEMS where ITEM_CLASS_CODE=:b0           ";

 static const char *sq0093 = 
"select ITEM_CODE  from RD_ITEMS where STATUS='S' for update of STATUS ";

 static const char *sq0094 = 
"select 'X'  from RD_ITEMS_CONSUMED where (OPERATING_FACILITY_ID=:b0 and ITEM\
_CODE=:b1)           ";

 static const char *sq0095 = 
"select 'X'  from RD_ITEMS_FOR_EXAM where ITEM_CODE=:b0           ";

 static const char *sq0099 = 
"select REASON_CODE  from RD_REASONS where STATUS='S' for update of STATUS ";

 static const char *sq0100 = 
"select 'X'  from RD_RECORDS_INDEX_MERGED where (FACILITY_ID=:b0 and REASON_C\
ODE=:b1)           ";

 static const char *sq0101 = 
"select 'X'  from RD_REQUEST_QUEUE where (PERFORMING_FACILITY_ID=:b0 and REAS\
ON_CODE=:b1)           ";

 static const char *sq0105 = 
"select EXAM_CATEGORY_CODE  from RD_EXAM_CATEGORY where STATUS='S' order by 1\
 desc   for update of STATUS ";

 static const char *sq0106 = 
"select 'X'  from RD_EXAMS where EXAM_CATEGORY_CODE=:b0           ";

 static const char *sq0110 = 
"select DIAGNOSIS_CODE  from RD_DIAGNOSIS where STATUS='S' for update of STAT\
US ";

 static const char *sq0113 = 
"select complication_type  from rd_complication where NVL(status,'Y')='S' for\
 update of STATUS ";

 static const char *sq0114 = 
"select 'X'  from rd_request_line_complications where complication_type=:b0  \
         ";

 static const char *sq0117 = 
"select management_type  from rd_comp_management_type where NVL(status,'Y')='\
S' for update of STATUS ";

 static const char *sq0118 = 
"select 'X'  from rd_request_line_complications where management_type=:b0    \
       ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{12,4274,178,0,0,
5,0,0,0,0,0,283,111,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,150,0,260,125,0,0,5,3,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
71,0,0,3,0,0,286,190,0,0,0,0,0,1,0,
86,0,0,4,46,0,257,198,0,0,0,0,0,1,0,
101,0,0,5,75,0,265,270,0,0,0,0,0,1,0,
116,0,0,6,65,0,265,290,0,0,1,1,0,1,0,1,9,0,0,
135,0,0,6,0,0,269,294,0,0,1,0,0,1,0,2,9,0,0,
154,0,0,7,102,0,265,306,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
177,0,0,7,0,0,269,310,0,0,1,0,0,1,0,2,9,0,0,
196,0,0,8,93,0,265,322,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
219,0,0,8,0,0,269,326,0,0,1,0,0,1,0,2,9,0,0,
238,0,0,9,90,0,265,354,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
261,0,0,9,0,0,269,358,0,0,1,0,0,1,0,2,9,0,0,
280,0,0,10,97,0,265,369,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
303,0,0,10,0,0,269,373,0,0,1,0,0,1,0,2,9,0,0,
322,0,0,11,92,0,265,385,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
345,0,0,11,0,0,269,390,0,0,1,0,0,1,0,2,9,0,0,
364,0,0,12,98,0,265,402,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
387,0,0,12,0,0,269,407,0,0,1,0,0,1,0,2,9,0,0,
406,0,0,13,64,0,265,419,0,0,1,1,0,1,0,1,9,0,0,
425,0,0,13,0,0,269,424,0,0,1,0,0,1,0,2,9,0,0,
444,0,0,14,41,0,303,439,0,0,0,0,0,1,0,
459,0,0,15,51,0,258,449,0,0,1,1,0,1,0,1,9,0,0,
478,0,0,5,0,0,271,460,0,0,0,0,0,1,0,
493,0,0,6,0,0,271,462,0,0,0,0,0,1,0,
508,0,0,7,0,0,271,463,0,0,0,0,0,1,0,
523,0,0,8,0,0,271,464,0,0,0,0,0,1,0,
538,0,0,9,0,0,271,466,0,0,0,0,0,1,0,
553,0,0,10,0,0,271,467,0,0,0,0,0,1,0,
568,0,0,11,0,0,271,468,0,0,0,0,0,1,0,
583,0,0,12,0,0,271,469,0,0,0,0,0,1,0,
598,0,0,13,0,0,271,470,0,0,0,0,0,1,0,
613,0,0,5,0,0,269,476,0,0,1,0,0,1,0,2,9,0,0,
632,0,0,16,50,0,257,723,0,0,0,0,0,1,0,
647,0,0,17,76,0,265,842,0,0,0,0,0,1,0,
662,0,0,18,97,0,265,849,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
685,0,0,18,0,0,269,853,0,0,1,0,0,1,0,2,9,0,0,
704,0,0,19,61,0,265,866,0,0,1,1,0,1,0,1,9,0,0,
723,0,0,19,0,0,269,870,0,0,1,0,0,1,0,2,9,0,0,
742,0,0,20,65,0,265,883,0,0,1,1,0,1,0,1,9,0,0,
761,0,0,20,0,0,269,887,0,0,1,0,0,1,0,2,9,0,0,
780,0,0,21,91,0,265,899,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
803,0,0,21,0,0,269,903,0,0,1,0,0,1,0,2,9,0,0,
822,0,0,22,102,0,265,914,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
845,0,0,22,0,0,269,919,0,0,1,0,0,1,0,2,9,0,0,
864,0,0,23,102,0,265,931,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
887,0,0,23,0,0,269,936,0,0,1,0,0,1,0,2,9,0,0,
906,0,0,24,97,0,265,948,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
929,0,0,24,0,0,269,953,0,0,1,0,0,1,0,2,9,0,0,
948,0,0,25,97,0,265,965,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
971,0,0,25,0,0,269,970,0,0,1,0,0,1,0,2,9,0,0,
990,0,0,26,93,0,265,982,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1013,0,0,26,0,0,269,987,0,0,1,0,0,1,0,2,9,0,0,
1032,0,0,27,96,0,265,999,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1055,0,0,27,0,0,269,1004,0,0,1,0,0,1,0,2,9,0,0,
1074,0,0,28,69,0,265,1017,0,0,1,1,0,1,0,1,9,0,0,
1093,0,0,28,0,0,269,1022,0,0,1,0,0,1,0,2,9,0,0,
1112,0,0,29,87,0,265,1052,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1135,0,0,29,0,0,269,1057,0,0,1,0,0,1,0,2,9,0,0,
1154,0,0,30,94,0,265,1070,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1177,0,0,30,0,0,269,1075,0,0,1,0,0,1,0,2,9,0,0,
1196,0,0,31,93,0,265,1088,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1219,0,0,31,0,0,269,1093,0,0,1,0,0,1,0,2,9,0,0,
1238,0,0,32,306,0,265,1106,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1261,0,0,32,0,0,269,1111,0,0,1,0,0,1,0,2,9,0,0,
1280,0,0,33,45,0,303,1145,0,0,0,0,0,1,0,
1295,0,0,17,0,0,271,1154,0,0,0,0,0,1,0,
1310,0,0,18,0,0,271,1155,0,0,0,0,0,1,0,
1325,0,0,19,0,0,271,1156,0,0,0,0,0,1,0,
1340,0,0,20,0,0,271,1157,0,0,0,0,0,1,0,
1355,0,0,21,0,0,271,1158,0,0,0,0,0,1,0,
1370,0,0,22,0,0,271,1159,0,0,0,0,0,1,0,
1385,0,0,23,0,0,271,1160,0,0,0,0,0,1,0,
1400,0,0,24,0,0,271,1161,0,0,0,0,0,1,0,
1415,0,0,25,0,0,271,1162,0,0,0,0,0,1,0,
1430,0,0,26,0,0,271,1163,0,0,0,0,0,1,0,
1445,0,0,27,0,0,271,1164,0,0,0,0,0,1,0,
1460,0,0,28,0,0,271,1165,0,0,0,0,0,1,0,
1475,0,0,29,0,0,271,1167,0,0,0,0,0,1,0,
1490,0,0,30,0,0,271,1168,0,0,0,0,0,1,0,
1505,0,0,31,0,0,271,1169,0,0,0,0,0,1,0,
1520,0,0,32,0,0,271,1170,0,0,0,0,0,1,0,
1535,0,0,17,0,0,269,1179,0,0,1,0,0,1,0,2,9,0,0,
1554,0,0,34,45,0,257,1201,0,0,0,0,0,1,0,
1569,0,0,35,105,0,265,1277,0,0,1,1,0,1,0,1,9,0,0,
1588,0,0,36,89,0,265,1284,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1611,0,0,36,0,0,269,1288,0,0,1,0,0,1,0,2,9,0,0,
1630,0,0,37,96,0,265,1301,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1653,0,0,37,0,0,269,1305,0,0,1,0,0,1,0,2,9,0,0,
1672,0,0,38,102,0,265,1336,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1695,0,0,38,0,0,269,1340,0,0,1,0,0,1,0,2,9,0,0,
1714,0,0,39,97,0,265,1372,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1737,0,0,39,0,0,269,1376,0,0,1,0,0,1,0,2,9,0,0,
1756,0,0,40,103,0,265,1389,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1779,0,0,40,0,0,269,1393,0,0,1,0,0,1,0,2,9,0,0,
1798,0,0,41,97,0,265,1405,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1821,0,0,41,0,0,269,1409,0,0,1,0,0,1,0,2,9,0,0,
1840,0,0,42,95,0,265,1421,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1863,0,0,42,0,0,269,1424,0,0,1,0,0,1,0,2,9,0,0,
1882,0,0,43,40,0,303,1457,0,0,0,0,0,1,0,
1897,0,0,35,0,0,271,1466,0,0,0,0,0,1,0,
1912,0,0,36,0,0,271,1467,0,0,0,0,0,1,0,
1927,0,0,37,0,0,271,1468,0,0,0,0,0,1,0,
1942,0,0,38,0,0,271,1470,0,0,0,0,0,1,0,
1957,0,0,39,0,0,271,1472,0,0,0,0,0,1,0,
1972,0,0,40,0,0,271,1473,0,0,0,0,0,1,0,
1987,0,0,41,0,0,271,1474,0,0,0,0,0,1,0,
2002,0,0,42,0,0,271,1475,0,0,0,0,0,1,0,
2017,0,0,35,0,0,269,1483,0,0,1,0,0,1,0,2,9,0,0,
2036,0,0,44,50,0,257,1503,0,0,0,0,0,1,0,
2051,0,0,45,115,0,265,1524,0,0,1,1,0,1,0,1,9,0,0,
2070,0,0,46,96,0,265,1531,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
2093,0,0,46,0,0,269,1535,0,0,1,0,0,1,0,2,9,0,0,
2112,0,0,47,45,0,303,1551,0,0,0,0,0,1,0,
2127,0,0,45,0,0,271,1562,0,0,0,0,0,1,0,
2142,0,0,46,0,0,271,1563,0,0,0,0,0,1,0,
2157,0,0,45,0,0,269,1570,0,0,1,0,0,1,0,2,9,0,0,
2176,0,0,48,43,0,257,1591,0,0,0,0,0,1,0,
2191,0,0,49,69,0,265,1640,0,0,0,0,0,1,0,
2206,0,0,50,61,0,265,1647,0,0,1,1,0,1,0,1,9,0,0,
2225,0,0,50,0,0,269,1652,0,0,1,0,0,1,0,2,9,0,0,
2244,0,0,51,38,0,303,1741,0,0,0,0,0,1,0,
2259,0,0,49,0,0,271,1752,0,0,0,0,0,1,0,
2274,0,0,50,0,0,271,1753,0,0,0,0,0,1,0,
2289,0,0,49,0,0,269,1764,0,0,1,0,0,1,0,2,9,0,0,
2308,0,0,52,49,0,257,1785,0,0,0,0,0,1,0,
2323,0,0,53,79,0,265,1805,0,0,0,0,0,1,0,
2338,0,0,54,66,0,265,1812,0,0,1,1,0,1,0,1,9,0,0,
2357,0,0,54,0,0,269,1817,0,0,1,0,0,1,0,2,9,0,0,
2376,0,0,55,44,0,303,1834,0,0,0,0,0,1,0,
2391,0,0,53,0,0,271,1845,0,0,0,0,0,1,0,
2406,0,0,54,0,0,271,1846,0,0,0,0,0,1,0,
2421,0,0,53,0,0,269,1854,0,0,1,0,0,1,0,2,9,0,0,
2440,0,0,56,53,0,257,1876,0,0,0,0,0,1,0,
2455,0,0,57,85,0,265,1902,0,0,0,0,0,1,0,
2470,0,0,58,92,0,265,1908,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
2493,0,0,58,0,0,269,1912,0,0,1,0,0,1,0,2,9,0,0,
2512,0,0,59,99,0,265,1922,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
2535,0,0,59,0,0,269,1926,0,0,1,0,0,1,0,2,9,0,0,
2554,0,0,60,48,0,303,1940,0,0,0,0,0,1,0,
2569,0,0,57,0,0,271,1949,0,0,0,0,0,1,0,
2584,0,0,58,0,0,271,1950,0,0,0,0,0,1,0,
2599,0,0,59,0,0,271,1951,0,0,0,0,0,1,0,
2614,0,0,57,0,0,269,1957,0,0,1,0,0,1,0,2,9,0,0,
2633,0,0,61,52,0,257,2255,0,0,0,0,0,1,0,
2648,0,0,62,84,0,265,2293,0,0,0,0,0,1,0,
2663,0,0,63,105,0,265,2300,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
2686,0,0,63,0,0,269,2304,0,0,1,0,0,1,0,2,9,0,0,
2705,0,0,64,68,0,265,2314,0,0,1,1,0,1,0,1,9,0,0,
2724,0,0,64,0,0,269,2318,0,0,1,0,0,1,0,2,9,0,0,
2743,0,0,65,108,0,265,2328,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
2766,0,0,65,0,0,269,2332,0,0,1,0,0,1,0,2,9,0,0,
2785,0,0,66,47,0,303,2360,0,0,0,0,0,1,0,
2800,0,0,62,0,0,271,2368,0,0,0,0,0,1,0,
2815,0,0,63,0,0,271,2369,0,0,0,0,0,1,0,
2830,0,0,64,0,0,271,2370,0,0,0,0,0,1,0,
2845,0,0,65,0,0,271,2371,0,0,0,0,0,1,0,
2860,0,0,62,0,0,269,2379,0,0,1,0,0,1,0,2,9,0,0,
2879,0,0,67,52,0,257,2398,0,0,0,0,0,1,0,
2894,0,0,68,118,0,265,2432,0,0,1,1,0,1,0,1,9,0,0,
2913,0,0,69,111,0,265,2439,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
2936,0,0,69,0,0,269,2443,0,0,1,0,0,1,0,2,9,0,0,
2955,0,0,70,110,0,265,2453,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
2978,0,0,70,0,0,269,2457,0,0,1,0,0,1,0,2,9,0,0,
2997,0,0,71,94,0,265,2467,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
3020,0,0,71,0,0,269,2471,0,0,1,0,0,1,0,2,9,0,0,
3039,0,0,72,47,0,303,2486,0,0,0,0,0,1,0,
3054,0,0,62,0,0,271,2494,0,0,0,0,0,1,0,
3069,0,0,63,0,0,271,2495,0,0,0,0,0,1,0,
3084,0,0,65,0,0,271,2496,0,0,0,0,0,1,0,
3099,0,0,68,0,0,269,2504,0,0,1,0,0,1,0,2,9,0,0,
3118,0,0,73,44,0,257,2525,0,0,0,0,0,1,0,
3133,0,0,74,102,0,265,2576,0,0,1,1,0,1,0,1,9,0,0,
3152,0,0,76,99,0,265,2597,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
3175,0,0,76,0,0,269,2602,0,0,1,0,0,1,0,2,9,0,0,
3194,0,0,78,90,0,265,2615,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
3217,0,0,78,0,0,269,2620,0,0,1,0,0,1,0,2,9,0,0,
3236,0,0,75,94,0,265,2651,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
3259,0,0,75,0,0,269,2656,0,0,1,0,0,1,0,2,9,0,0,
3278,0,0,77,89,0,265,2669,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
3301,0,0,77,0,0,269,2673,0,0,1,0,0,1,0,2,9,0,0,
3320,0,0,79,39,0,303,2687,0,0,0,0,0,1,0,
3335,0,0,74,0,0,271,2705,0,0,0,0,0,1,0,
3350,0,0,7,0,0,271,2706,0,0,0,0,0,1,0,
3365,0,0,8,0,0,271,2707,0,0,0,0,0,1,0,
3380,0,0,11,0,0,271,2709,0,0,0,0,0,1,0,
3395,0,0,75,0,0,271,2710,0,0,0,0,0,1,0,
3410,0,0,74,0,0,269,2718,0,0,1,0,0,1,0,2,9,0,0,
3429,0,0,80,53,0,257,2739,0,0,0,0,0,1,0,
3444,0,0,81,89,0,265,2759,0,0,0,0,0,1,0,
3459,0,0,82,107,0,265,2765,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
3482,0,0,82,0,0,269,2769,0,0,1,0,0,1,0,2,9,0,0,
3501,0,0,83,48,0,303,2781,0,0,0,0,0,1,0,
3516,0,0,81,0,0,271,2790,0,0,0,0,0,1,0,
3531,0,0,82,0,0,271,2791,0,0,0,0,0,1,0,
3546,0,0,81,0,0,269,2797,0,0,1,0,0,1,0,2,9,0,0,
3565,0,0,84,50,0,257,2816,0,0,0,0,0,1,0,
3580,0,0,85,83,0,265,2837,0,0,0,0,0,1,0,
3595,0,0,86,104,0,265,2843,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
3618,0,0,86,0,0,269,2847,0,0,1,0,0,1,0,2,9,0,0,
3637,0,0,87,45,0,303,2863,0,0,0,0,0,1,0,
3652,0,0,85,0,0,271,2872,0,0,0,0,0,1,0,
3667,0,0,86,0,0,271,2873,0,0,0,0,0,1,0,
3682,0,0,85,0,0,269,2880,0,0,1,0,0,1,0,2,9,0,0,
3701,0,0,88,49,0,257,2901,0,0,0,0,0,1,0,
3716,0,0,89,81,0,265,2919,0,0,0,0,0,1,0,
3731,0,0,90,62,0,265,2925,0,0,1,1,0,1,0,1,9,0,0,
3750,0,0,90,0,0,269,2929,0,0,1,0,0,1,0,2,9,0,0,
3769,0,0,91,44,0,303,2941,0,0,0,0,0,1,0,
3784,0,0,89,0,0,271,2949,0,0,0,0,0,1,0,
3799,0,0,90,0,0,271,2950,0,0,0,0,0,1,0,
3814,0,0,89,0,0,269,2956,0,0,1,0,0,1,0,2,9,0,0,
3833,0,0,92,44,0,257,2974,0,0,0,0,0,1,0,
3848,0,0,93,70,0,265,3000,0,0,0,0,0,1,0,
3863,0,0,94,97,0,265,3006,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
3886,0,0,94,0,0,269,3010,0,0,1,0,0,1,0,2,9,0,0,
3905,0,0,95,65,0,265,3020,0,0,1,1,0,1,0,1,9,0,0,
3924,0,0,95,0,0,269,3024,0,0,1,0,0,1,0,2,9,0,0,
3943,0,0,96,39,0,303,3037,0,0,0,0,0,1,0,
3958,0,0,93,0,0,271,3046,0,0,0,0,0,1,0,
3973,0,0,93,0,0,269,3052,0,0,1,0,0,1,0,2,9,0,0,
3992,0,0,97,46,0,257,3071,0,0,0,0,0,1,0,
4007,0,0,98,57,0,257,3080,0,0,0,0,0,1,0,
4022,0,0,99,74,0,265,3108,0,0,0,0,0,1,0,
4037,0,0,100,95,0,265,3114,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
4060,0,0,100,0,0,269,3118,0,0,1,0,0,1,0,2,9,0,0,
4079,0,0,101,99,0,265,3128,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
4102,0,0,101,0,0,269,3132,0,0,1,0,0,1,0,2,9,0,0,
4121,0,0,102,57,0,258,3145,0,0,1,1,0,1,0,1,9,0,0,
4140,0,0,103,41,0,303,3152,0,0,0,0,0,1,0,
4155,0,0,99,0,0,271,3163,0,0,0,0,0,1,0,
4170,0,0,100,0,0,271,3164,0,0,0,0,0,1,0,
4185,0,0,101,0,0,271,3165,0,0,0,0,0,1,0,
4200,0,0,99,0,0,269,3171,0,0,1,0,0,1,0,2,9,0,0,
4219,0,0,104,52,0,257,3190,0,0,0,0,0,1,0,
4234,0,0,105,105,0,265,3211,0,0,0,0,0,1,0,
4249,0,0,106,65,0,265,3218,0,0,1,1,0,1,0,1,9,0,0,
4268,0,0,106,0,0,269,3222,0,0,1,0,0,1,0,2,9,0,0,
4287,0,0,107,138,0,260,3232,0,0,2,1,0,1,0,2,9,0,0,1,9,0,0,
4310,0,0,108,47,0,303,3247,0,0,0,0,0,1,0,
4325,0,0,105,0,0,271,3256,0,0,0,0,0,1,0,
4340,0,0,106,0,0,271,3257,0,0,0,0,0,1,0,
4355,0,0,105,0,0,269,3263,0,0,1,0,0,1,0,2,9,0,0,
4374,0,0,109,48,0,257,3282,0,0,0,0,0,1,0,
4389,0,0,110,79,0,265,3301,0,0,0,0,0,1,0,
4404,0,0,111,43,0,303,3323,0,0,0,0,0,1,0,
4419,0,0,110,0,0,271,3331,0,0,0,0,0,1,0,
4434,0,0,110,0,0,269,3338,0,0,1,0,0,1,0,2,9,0,0,
4453,0,0,112,51,0,257,3356,0,0,0,0,0,1,0,
4468,0,0,113,94,0,265,3378,0,0,0,0,0,1,0,
4483,0,0,114,85,0,265,3384,0,0,1,1,0,1,0,1,9,0,0,
4502,0,0,114,0,0,269,3388,0,0,1,0,0,1,0,2,9,0,0,
4521,0,0,115,46,0,303,3400,0,0,0,0,0,1,0,
4536,0,0,113,0,0,271,3410,0,0,0,0,0,1,0,
4551,0,0,114,0,0,271,3411,0,0,0,0,0,1,0,
4566,0,0,113,0,0,269,3418,0,0,1,0,0,1,0,2,9,0,0,
4585,0,0,116,59,0,257,3438,0,0,0,0,0,1,0,
4600,0,0,117,100,0,265,3460,0,0,0,0,0,1,0,
4615,0,0,118,83,0,265,3466,0,0,1,1,0,1,0,1,9,0,0,
4634,0,0,118,0,0,269,3470,0,0,1,0,0,1,0,2,9,0,0,
4653,0,0,119,54,0,303,3482,0,0,0,0,0,1,0,
4668,0,0,117,0,0,271,3492,0,0,0,0,0,1,0,
4683,0,0,118,0,0,271,3493,0,0,0,0,0,1,0,
4698,0,0,117,0,0,269,3500,0,0,1,0,0,1,0,2,9,0,0,
4717,0,0,120,66,0,259,3530,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,
4764,0,0,121,123,0,258,3545,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
};


/******************************************************************************/
/* OCS MEDICOM VER 1.0                                                        */
/******************************************************************************/
/* PROGRAM NAME     : rdbpgmst.pc                                             */
/* AUTHOR           : VASANT KUMAR											  */	
/*																			  */	 
/* DATE WRITTEN     : 23/04/1995                                              */
/*                                                                            */
/* CALLED FROM      : rdbpgmst.inp                                            */
/*                                                                            */
/* INPUT PARAMETERS : USER_ID/PASSWORD                                        */
/*                    SESSION_ID                                              */
/*                    PGM_DATE IN 'DDMMYYHH24MISS' FORMAT                     */
/*                                                                            */
/* INPUT TAKEN FROM : 1. TABLE ID                                             */
/* SY_PROG_PARAM                                                              */
/*                                                                            */
/* TABLED ACCESSED/ : SY_PROG_PARAM                                           */
/*        UPDATED     SY_PROG_CONTROL                                         */
/*                    SY_DESIGNATION                                          */
/*                    SY_PHYSICIAN_MAST                                       */
/*                    MR_NOTES_SEC_HDG                                        */
/*                    MR_DIAG_STAGE                                           */
/*                    MR_ANALYSIS_CODE                                        */
/*                                                                            */
/* FUNCTION         : This program purges the suspended records from the      */
/*                    specified OP   master table                             */
/*                                                                            */
/*                    Each suspended record is validated and if any OERROR    */
/*                    is found it is recorded in OP_PURGE_MSG, otherwise      */
/*                    it is deleted.                                          */
/* Modified on	    :14/2/2000						      */
/*                                                                            */
/******************************************************************************/
/*                                                                            */
/* VERSION          : eHIS 4.1                                                */
/*                                                                            */
/* AUTHOR           : Rajanish Nambiar                                        */
/*                                                                            */
/* DATE MODIFIED    : 23rd Aug 2003                                           */
/*                                                                            */
/* DATE MODIFIED    : 07th Jan 2004 incorporated new masters                  */
/*                                  RD_DIAGNOSIS & RD_RATE_OF_COMPLICATION	  */
/*                                                                            */
/******************************************************************************/

#include <stdio.h>
#include <string.h>
#include "gl.h"
#include "RD.h"
#define DEBUG 0
#define RESOURCE_BUSY        (sqlca.sqlcode == -54) 
#define VIEW_LOG_FILE  1

/* EXEC SQL BEGIN DECLARE SECTION; */ 


/* varchar d_pgm_id[9],
		uid_pwd[91],
		d_session_id[16],
		d_pgm_date[14],
		d_facility_id[3],
		d_ws_no[31],
		d_table_id[32],
		d_msg_desc[72],
		d_msg_num[8],
		d_master_code[42],
		d_dummy[2]; */ 
struct { unsigned short len; unsigned char arr[9]; } d_pgm_id;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[16]; } d_session_id;

struct { unsigned short len; unsigned char arr[14]; } d_pgm_date;

struct { unsigned short len; unsigned char arr[3]; } d_facility_id;

struct { unsigned short len; unsigned char arr[31]; } d_ws_no;

struct { unsigned short len; unsigned char arr[32]; } d_table_id;

struct { unsigned short len; unsigned char arr[72]; } d_msg_desc;

struct { unsigned short len; unsigned char arr[8]; } d_msg_num;

struct { unsigned short len; unsigned char arr[42]; } d_master_code;

struct { unsigned short len; unsigned char arr[2]; } d_dummy;


/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC ORACLE OPTION(HOLD_CURSOR = YES); */ 

/* EXEC ORACLE OPTION(SELECT_ERROR = NO); */ 

// EXEC ORACLE OPTION(REBIND = NO);

/* EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header: sqlca.h 24-apr-2003.12:50:58 mkandarp Exp $ sqlca.h 
 */

/* Copyright (c) 1985, 2003, Oracle Corporation.  All rights reserved.  */
 
/*
NAME
  SQLCA : SQL Communications Area.
FUNCTION
  Contains no code. Oracle fills in the SQLCA with status info
  during the execution of a SQL stmt.
NOTES
  **************************************************************
  ***                                                        ***
  *** This file is SOSD.  Porters must change the data types ***
  *** appropriately on their platform.  See notes/pcport.doc ***
  *** for more information.                                  ***
  ***                                                        ***
  **************************************************************

  If the symbol SQLCA_STORAGE_CLASS is defined, then the SQLCA
  will be defined to have this storage class. For example:
 
    #define SQLCA_STORAGE_CLASS extern
 
  will define the SQLCA as an extern.
 
  If the symbol SQLCA_INIT is defined, then the SQLCA will be
  statically initialized. Although this is not necessary in order
  to use the SQLCA, it is a good pgming practice not to have
  unitialized variables. However, some C compilers/OS's don't
  allow automatic variables to be init'd in this manner. Therefore,
  if you are INCLUDE'ing the SQLCA in a place where it would be
  an automatic AND your C compiler/OS doesn't allow this style
  of initialization, then SQLCA_INIT should be left undefined --
  all others can define SQLCA_INIT if they wish.

  If the symbol SQLCA_NONE is defined, then the SQLCA variable will
  not be defined at all.  The symbol SQLCA_NONE should not be defined
  in source modules that have embedded SQL.  However, source modules
  that have no embedded SQL, but need to manipulate a sqlca struct
  passed in as a parameter, can set the SQLCA_NONE symbol to avoid
  creation of an extraneous sqlca variable.
 
MODIFIED
    lvbcheng   07/31/98 -  long to int
    jbasu      12/12/94 -  Bug 217878: note this is an SOSD file
    losborne   08/11/92 -  No sqlca var if SQLCA_NONE macro set 
  Clare      12/06/84 - Ch SQLCA to not be an extern.
  Clare      10/21/85 - Add initialization.
  Bradbury   01/05/86 - Only initialize when SQLCA_INIT set
  Clare      06/12/86 - Add SQLCA_STORAGE_CLASS option.
*/
 
#ifndef SQLCA
#define SQLCA 1
 
struct   sqlca
         {
         /* ub1 */ char    sqlcaid[8];
         /* b4  */ int     sqlabc;
         /* b4  */ int     sqlcode;
         struct
           {
           /* ub2 */ unsigned short sqlerrml;
           /* ub1 */ char           sqlerrmc[70];
           } sqlerrm;
         /* ub1 */ char    sqlerrp[8];
         /* b4  */ int     sqlerrd[6];
         /* ub1 */ char    sqlwarn[8];
         /* ub1 */ char    sqlext[8];
         };

#ifndef SQLCA_NONE 
#ifdef   SQLCA_STORAGE_CLASS
SQLCA_STORAGE_CLASS struct sqlca sqlca
#else
         struct sqlca sqlca
#endif
 
#ifdef  SQLCA_INIT
         = {
         {'S', 'Q', 'L', 'C', 'A', ' ', ' ', ' '},
         sizeof(struct sqlca),
         0,
         { 0, {0}},
         {'N', 'O', 'T', ' ', 'S', 'E', 'T', ' '},
         {0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0}
         }
#endif
         ;
#endif
 
#endif
 
/* end SQLCA */
/* EXEC SQL INCLUDE SQLDA.H;
 */ 
/*
 * $Header: sqlda.h 08-may-2007.05:58:33 ardesai Exp $ sqlda.h 
 */

/***************************************************************
*      The SQLDA descriptor definition                         *
*--------------------------------------------------------------*
*      VAX/3B Version                                          *
*                                                              *
* Copyright (c) 1987, 2007, Oracle. All rights reserved.  *
***************************************************************/


/* NOTES
  **************************************************************
  ***                                                        ***
  *** This file is SOSD.  Porters must change the data types ***
  *** appropriately on their platform.  See notes/pcport.doc ***
  *** for more information.                                  ***
  ***                                                        ***
  **************************************************************
*/

/*  MODIFIED
    ardesai    05/08/07  - Bug[6037057] Undef Y
    apopat     05/08/02  - [2362423] MVS PE to make lines shorter than 79
    apopat     07/31/99 -  [707588] TAB to blanks for OCCS
    lvbcheng   10/27/98 -  change long to int for sqlda
    lvbcheng   08/15/97 -  Move sqlda protos to sqlcpr.h
    lvbcheng   06/25/97 -  Move sqlda protos to this file
    jbasu      01/29/95 -  correct typo
    jbasu      01/27/95 -  correct comment - ub2->sb2
    jbasu      12/12/94 - Bug 217878: note this is an SOSD file
    Morse      12/01/87 - undef L and S for v6 include files
    Richey     07/13/87 - change int defs to long 
    Clare      09/13/84 - Port: Ch types to match SQLLIB structs
    Clare      10/02/86 - Add ifndef SQLDA
*/

#ifndef SQLDA_
#define SQLDA_ 1
 
#ifdef T
# undef T
#endif
#ifdef F
# undef F
#endif

#ifdef S
# undef S
#endif
#ifdef L
# undef L
#endif

#ifdef Y
 # undef Y
#endif
 
struct SQLDA {
  /* ub4    */ int        N; /* Descriptor size in number of entries        */
  /* text** */ char     **V; /* Ptr to Arr of addresses of main variables   */
  /* ub4*   */ int       *L; /* Ptr to Arr of lengths of buffers            */
  /* sb2*   */ short     *T; /* Ptr to Arr of types of buffers              */
  /* sb2**  */ short    **I; /* Ptr to Arr of addresses of indicator vars   */
  /* sb4    */ int        F; /* Number of variables found by DESCRIBE       */
  /* text** */ char     **S; /* Ptr to Arr of variable name pointers        */
  /* ub2*   */ short     *M; /* Ptr to Arr of max lengths of var. names     */
  /* ub2*   */ short     *C; /* Ptr to Arr of current lengths of var. names */
  /* text** */ char     **X; /* Ptr to Arr of ind. var. name pointers       */
  /* ub2*   */ short     *Y; /* Ptr to Arr of max lengths of ind. var. names*/
  /* ub2*   */ short     *Z; /* Ptr to Arr of cur lengths of ind. var. names*/
  };
 
typedef struct SQLDA SQLDA;
 
#endif

/* ----------------- */
/* defines for sqlda */
/* ----------------- */

#define SQLSQLDAAlloc(arg1, arg2, arg3, arg4) sqlaldt(arg1, arg2, arg3, arg4) 

#define SQLSQLDAFree(arg1, arg2) sqlclut(arg1, arg2) 





#include "winproc.h"
char string_var[75];
int can_delete;
char filename[150];

void proc_main(argc,argv)
int argc;
char *argv[];
{
	if (argc < 5) {
		disp_message(ERR_MESG, "RDBPGMST : Usage RDBPGMST userid/password session_id pgm_date\n");
		proc_exit();
	}
	strcpy(d_pgm_id.arr, argv[0]);
	d_pgm_id.len = strlen(d_pgm_id.arr); 
	
	strcpy(uid_pwd.arr,argv[1]);
	uid_pwd.len = strlen(uid_pwd.arr);
	strcpy(filename,WORKING_DIR);
	strcat(filename,"rdbpurge.lis");
	
	strcpy(d_session_id.arr,argv[2]);
	d_session_id.len = strlen(d_session_id.arr);
	strcpy(g_session_id,argv[2]);
	
	strcpy(d_pgm_date.arr,argv[3]);
	d_pgm_date.len = strlen(d_pgm_date.arr);
	strcpy(g_pgm_date,argv[3]);
	
	strcpy(d_facility_id.arr, argv[4]);
	d_facility_id.len = strlen(d_facility_id.arr);
	

	/* EXEC SQL CONNECT :uid_pwd; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 4;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )10;
 sqlstm.offset = (unsigned int  )5;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&uid_pwd;
 sqlstm.sqhstl[0] = (unsigned int  )93;
 sqlstm.sqhsts[0] = (         int  )93;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlstm.sqlcmax = (unsigned int )100;
 sqlstm.sqlcmin = (unsigned int )2;
 sqlstm.sqlcincr = (unsigned int )1;
 sqlstm.sqlctimeout = (unsigned int )0;
 sqlstm.sqlcnowait = (unsigned int )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

	

	if (OERROR){
		disp_message(ORA_MESG, "Unable to connect to oracle.\n");
		//	  printf("%s\n",sqlca.sqlerrm.sqlerrmc);
		proc_exit();
	}
		
	set_meduser_role();
	
	strcpy(g_pgm_id,"RDBPURGE");
	
	chk_active();
	
	/* EXEC SQL  
	SELECT PARAM1,PARAM2 
	INTO   :d_table_id,:d_ws_no 
 	FROM   SY_PROG_PARAM
	WHERE  OPERATING_FACILITY_ID = :d_facility_id
	AND    PGM_ID				 = 'RDBPURGE'
	AND    PGM_DATE			     = :d_pgm_date
	AND	   SESSION_ID			 = :d_session_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select PARAM1 ,PARAM2 into :b0,:b1  from SY_PROG_PARAM where\
 (((OPERATING_FACILITY_ID=:b2 and PGM_ID='RDBPURGE') and PGM_DATE=:b3) and SES\
SION_ID=:b4)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )36;
 sqlstm.selerr = (unsigned short)0;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_table_id;
 sqlstm.sqhstl[0] = (unsigned int  )34;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_ws_no;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&d_facility_id;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_pgm_date;
 sqlstm.sqhstl[3] = (unsigned int  )16;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&d_session_id;
 sqlstm.sqhstl[4] = (unsigned int  )18;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		  
	if (OERROR || NO_DATA_FOUND)
		err_mesg("SELECT failed on table SY_PROG_PARAM",0,"");
		d_table_id.arr[d_table_id.len] = '\0';
		start_prog_control();
		start_prog_msg();
		d_table_id.arr[d_table_id.len] = '\0';
		/*  sprintf(string_var, "Purging of suspended %s codes in progress. Please wait ...\n\n",d_table_id.arr);
		disp_message(ERR_MESG, string_var);  */

	if (!strcmp(d_table_id.arr,"RD_SECTION"))
		purge_section();
	else if	(!strcmp(d_table_id.arr,"RD_EXAMINATION"))
		purge_examination();
	else if (!strcmp(d_table_id.arr,"RD_CLINIC"))
		purge_clinic();
	else if (!strcmp(d_table_id.arr,"RD_APPT_SERIES"))
		purge_appt_series();
	else if (!strcmp(d_table_id.arr,"RD_VIEW"))
		purge_view();
	else if (!strcmp(d_table_id.arr,"RD_ORGAN_SITE"))
		purge_organ_site();
	else if (!strcmp(d_table_id.arr,"RD_TRANSPORT_MODE"))
		purge_trans_mode_code();
	else if (!strcmp(d_table_id.arr,"RD_RECORDS_STORE"))
		purge_records_store();
	else if (!strcmp(d_table_id.arr,"RD_RECORDS_MEDIA"))
		purge_records_media();
	else if (!strcmp(d_table_id.arr,"RD_WINGS"))
		purge_wing() ;
	else if (!strcmp(d_table_id.arr,"RD_ITEMS"))
		purge_items() ;
	else if (!strcmp(d_table_id.arr,"RD_ITEM_CLASS"))
		purge_item_class() ;
	else if (!strcmp(d_table_id.arr,"RD_REASONS"))
		purge_reason() ;
	else if (!strcmp(d_table_id.arr,"RD_ADMIN_ROUTE"))
		purge_admin_route() ;
	else if (!strcmp(d_table_id.arr,"RD_ADMIN_REACTION"))
		purge_admin_reaction() ;
	else if (!strcmp(d_table_id.arr,"RD_EXAM_CATEGORY"))
		purge_exam_category() ;
	else if (!strcmp(d_table_id.arr,"RD_DIAGNOSIS"))
		purge_diagnosis() ;
	else if (!strcmp(d_table_id.arr,"RD_COMPLICATION"))
		purge_complication();
	else if (!strcmp(d_table_id.arr,"RD_COMP_MANAGEMENT_TYPE"))
		purge_management_type();
	else
		err_mesg("Invalid table_id",0,"");

	end_prog_msg();

	end_prog_control();

	del_param();

	/* EXEC SQL COMMIT WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )71;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	
	return;

}	//end of main

purge_section()
{
	/* EXEC SQL LOCK TABLE RD_SECTION
			   IN EXCLUSIVE MODE NOWAIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "lock TABLE RD_SECTION IN EXCLUSIVE MODE NOWAIT";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )86;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (RESOURCE_BUSY)
		err_mesg("TABLE cannot be locked in exclusive mode",0,"");
	else
		if (OERROR)
			err_mesg("LOCK failed on table RD_SECTION",0,"");

	/* EXEC SQL DECLARE RD_SECTION_CUR CURSOR FOR 
              SELECT  SECTION_CODE
			  FROM    RD_SECTION
			  WHERE   STATUS  = 'S' 
			  FOR     UPDATE  OF STATUS; */ 


	/*EXEC SQL DECLARE RD_SERVICE_TYPE_1_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_SERVICE_TYPE
			  WHERE   SECTION_CODE = :d_master_code; */

	/* EXEC SQL DECLARE RD_EXAMINATION_1_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_EXAMINATION
			  WHERE   SECTION_CODE = :d_master_code; */ 


	/* EXEC SQL DECLARE RD_DEF_STORAGE_LOCN_1_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_DEF_STORAGE_LOCN
			  WHERE   OPERATING_FACILITY_ID = :d_facility_id
			  AND     SECTION_CODE = :d_master_code; */ 


     /* EXEC SQL DECLARE RD_REQUEST_1_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_REQUEST
			  WHERE   OPERATING_FACILITY_ID = :d_facility_id
			  AND     SECTION_CODE = :d_master_code; */ 


     /*EXEC SQL DECLARE RD_RECORDS_INDEX_1_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_RECORDS_INDEX
			  WHERE   OPERATING_FACILITY_ID = :d_facility_id
			  AND     SECTION_CODE = :d_master_code;*/

     /* EXEC SQL DECLARE RD_APPT_1_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_APPT
			  WHERE   OPERATING_FACILITY_ID = :d_facility_id
			  AND     SECTION_CODE = :d_master_code; */ 


     /* EXEC SQL DECLARE RD_APPT_DEL_TR_1_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_APPT_DEL_TR
			  WHERE   OPERATING_FACILITY_ID = :d_facility_id
			  AND     SECTION_CODE = :d_master_code; */ 


     /* EXEC SQL DECLARE RD_CLINIC_1_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_CLINIC
			  WHERE   OPERATING_FACILITY_ID = :d_facility_id
			  AND     SECTION_CODE = :d_master_code; */ 


     /* EXEC SQL DECLARE RD_TRANS_RECORD_1_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_TRANS_RECORD
			  WHERE   OPERATING_FACILITY_ID = :d_facility_id
			  AND     SECTION_CODE = :d_master_code; */ 


     /* EXEC SQL DECLARE RD_APPT_STATS_1_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_APPT_STATS
			  WHERE   SECTION_CODE = :d_master_code; */ 


     /* EXEC SQL OPEN RD_SECTION_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0005;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )101;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (OERROR)
		err_mesg("OPEN failed on cursor RD_SECTION_CUR",0,"");
		while (fetch_section())
		{
			/****** COMMENTED ON 21/10/1998 RD_SERVICE_TYPE TABLE NOT EXIST****/
			/*EXEC SQL OPEN RD_SERVICE_TYPE_1_CUR;
			if (OERROR) 
			err_mesg("OPEN failed on cursor RD_SERVICE_TYPE_1_CUR",0,"");
			EXEC SQL FETCH RD_SERVICE_TYPE_1_CUR
	     	INTO  :d_dummy;
			if (OERROR) 
			err_mesg("FETCH failed on cursor RD_SERVICE_TYPE_1_CUR",0,"");
			if (sqlca.sqlcode EQ 0)
			{
			log_messg("RD0249","RD_SERVICE_TYPE");
			continue; 
			}*/
		
			/* EXEC SQL OPEN RD_EXAMINATION_1_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0006;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )116;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&d_master_code;
   sqlstm.sqhstl[0] = (unsigned int  )44;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			if (OERROR) 
			err_mesg("OPEN failed on cursor RD_EXAMINATION_1_CUR",0,"");

			/* EXEC SQL FETCH RD_EXAMINATION_1_CUR 
	     			  INTO :d_dummy; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )135;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_dummy;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



			if (OERROR) 
				err_mesg("FETCH failed on cursor RD_EXAMINATION_1_CUR",0,"");

			if (sqlca.sqlcode EQ 0){
			   log_messg("RD0249","RD_EXAMINATION");
			   continue; 
			}
			/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   			/* EXEC SQL OPEN RD_DEF_STORAGE_LOCN_1_CUR; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 5;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = sq0007;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )154;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqcmod = (unsigned int )0;
      sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
      sqlstm.sqhstl[0] = (unsigned int  )5;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_master_code;
      sqlstm.sqhstl[1] = (unsigned int  )44;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqphsv = sqlstm.sqhstv;
      sqlstm.sqphsl = sqlstm.sqhstl;
      sqlstm.sqphss = sqlstm.sqhsts;
      sqlstm.sqpind = sqlstm.sqindv;
      sqlstm.sqpins = sqlstm.sqinds;
      sqlstm.sqparm = sqlstm.sqharm;
      sqlstm.sqparc = sqlstm.sqharc;
      sqlstm.sqpadto = sqlstm.sqadto;
      sqlstm.sqptdso = sqlstm.sqtdso;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			if (OERROR) 
			err_mesg("OPEN failed on cursor RD_DEF_STORAGE_LOCN_1_CUR",0,"");

			/* EXEC SQL FETCH RD_DEF_STORAGE_LOCN_1_CUR 
	     			  INTO :d_dummy; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )177;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_dummy;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



			if (OERROR) 
				err_mesg("FETCH failed on cursor RD_DEF_STORAGE_LOCN_1_CUR",0,"");

			if (sqlca.sqlcode EQ 0){
			   log_messg("RD0249","RD_DEF_STORAGE_LOCN");
			   continue; 
			}
			/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   			/* EXEC SQL OPEN RD_REQUEST_1_CUR; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 5;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = sq0008;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )196;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqcmod = (unsigned int )0;
      sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
      sqlstm.sqhstl[0] = (unsigned int  )5;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_master_code;
      sqlstm.sqhstl[1] = (unsigned int  )44;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqphsv = sqlstm.sqhstv;
      sqlstm.sqphsl = sqlstm.sqhstl;
      sqlstm.sqphss = sqlstm.sqhsts;
      sqlstm.sqpind = sqlstm.sqindv;
      sqlstm.sqpins = sqlstm.sqinds;
      sqlstm.sqparm = sqlstm.sqharm;
      sqlstm.sqparc = sqlstm.sqharc;
      sqlstm.sqpadto = sqlstm.sqadto;
      sqlstm.sqptdso = sqlstm.sqtdso;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			if (OERROR) 
				err_mesg("OPEN failed on cursor RD_REQUEST_1_CUR",0,"");

			/* EXEC SQL FETCH RD_REQUEST_1_CUR 
	     			  INTO :d_dummy; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )219;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_dummy;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



			if (OERROR) 
				err_mesg("FETCH failed on cursor RD_REQUEST_1_CUR",0,"");

			if (sqlca.sqlcode EQ 0){
			   log_messg("RD0249","RD_REQUEST");
			   continue; 
			}
			/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   			/*EXEC SQL OPEN RD_RECORDS_INDEX_1_CUR;
			if (OERROR) 
				err_mesg("OPEN failed on cursor RD_RECORDS_INDEX_1_CUR",0,"");

			EXEC SQL FETCH RD_RECORDS_INDEX_1_CUR 
	     			  INTO  :d_dummy;

			if (OERROR) 
				err_mesg("FETCH failed on cursor RD_RECORDS_INDEX_1_CUR",0,"");

			if (sqlca.sqlcode EQ 0){
			   log_messg("RD0249","RD_RECORDS_INDEX");
			   continue; 
			}	 */ //rvN on 22nd Dec 2003
			/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
			
			/* EXEC SQL OPEN RD_APPT_1_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0009;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )238;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_master_code;
   sqlstm.sqhstl[1] = (unsigned int  )44;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			if (OERROR) 
				err_mesg("OPEN failed on cursor RD_APPT_1_CUR",0,"");

			/* EXEC SQL FETCH RD_APPT_1_CUR 
	     		      INTO  :d_dummy; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )261;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_dummy;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			
			if (OERROR) 
				err_mesg("FETCH failed on cursor RD_APPT_1_CUR",0,"");

			if (sqlca.sqlcode EQ 0){
			   log_messg("RD0249","RD_APPT");
			   continue; 
			}
			/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
			/* EXEC SQL OPEN RD_APPT_DEL_TR_1_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0010;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )280;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_master_code;
   sqlstm.sqhstl[1] = (unsigned int  )44;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			if (OERROR) 
				err_mesg("OPEN failed on cursor RD_APPT_DEL_TR_1_CUR",0,"");

			/* EXEC SQL FETCH RD_APPT_DEL_TR_1_CUR 
	     		      INTO :d_dummy; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )303;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_dummy;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



			if (OERROR) 
				err_mesg("FETCH failed on cursor RD_APPT_DEL_TR_1_CUR",0,"");

			if (sqlca.sqlcode EQ 0){
			   log_messg("RD0249","RD_APPT_DEL_TR");
			   continue; 
			}
			/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
			
			/* EXEC SQL OPEN RD_CLINIC_1_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0011;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )322;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqcmod = (unsigned int )0;
   sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_master_code;
   sqlstm.sqhstl[1] = (unsigned int  )44;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



			if (OERROR) 
				err_mesg("OPEN failed on cursor RD_CLINIC_1_CUR",0,"");

			/* EXEC SQL FETCH RD_CLINIC_1_CUR 
	     			  INTO :d_dummy; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )345;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_dummy;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



			if (OERROR) 
				err_mesg("FETCH failed on cursor RD_CLINIC_1_CUR",0,"");

			if (sqlca.sqlcode EQ 0){
			   log_messg("RD0249","RD_CLINIC");
			   continue; 
			}
			/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   			/* EXEC SQL OPEN RD_TRANS_RECORD_1_CUR; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 5;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = sq0012;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )364;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqcmod = (unsigned int )0;
      sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
      sqlstm.sqhstl[0] = (unsigned int  )5;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqhstv[1] = (         void  *)&d_master_code;
      sqlstm.sqhstl[1] = (unsigned int  )44;
      sqlstm.sqhsts[1] = (         int  )0;
      sqlstm.sqindv[1] = (         void  *)0;
      sqlstm.sqinds[1] = (         int  )0;
      sqlstm.sqharm[1] = (unsigned int  )0;
      sqlstm.sqadto[1] = (unsigned short )0;
      sqlstm.sqtdso[1] = (unsigned short )0;
      sqlstm.sqphsv = sqlstm.sqhstv;
      sqlstm.sqphsl = sqlstm.sqhstl;
      sqlstm.sqphss = sqlstm.sqhsts;
      sqlstm.sqpind = sqlstm.sqindv;
      sqlstm.sqpins = sqlstm.sqinds;
      sqlstm.sqparm = sqlstm.sqharm;
      sqlstm.sqparc = sqlstm.sqharc;
      sqlstm.sqpadto = sqlstm.sqadto;
      sqlstm.sqptdso = sqlstm.sqtdso;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



			if (OERROR) 
				err_mesg("OPEN failed on cursor RD_TRANS_RECORD_1_CUR",0,"");

			/* EXEC SQL FETCH RD_TRANS_RECORD_1_CUR 
	     			  INTO :d_dummy; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )387;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_dummy;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



			if (OERROR) 
				err_mesg("FETCH failed on cursor RD_TRANS_RECORD_1_CUR",0,"");

			if (sqlca.sqlcode EQ 0){
			   log_messg("RD0249","RD_TRANS_RECORD");
			   continue; 
			}
			/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   			/* EXEC SQL OPEN RD_APPT_STATS_1_CUR; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 5;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = sq0013;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )406;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqcmod = (unsigned int )0;
      sqlstm.sqhstv[0] = (         void  *)&d_master_code;
      sqlstm.sqhstl[0] = (unsigned int  )44;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqphsv = sqlstm.sqhstv;
      sqlstm.sqphsl = sqlstm.sqhstl;
      sqlstm.sqphss = sqlstm.sqhsts;
      sqlstm.sqpind = sqlstm.sqindv;
      sqlstm.sqpins = sqlstm.sqinds;
      sqlstm.sqparm = sqlstm.sqharm;
      sqlstm.sqparc = sqlstm.sqharc;
      sqlstm.sqpadto = sqlstm.sqadto;
      sqlstm.sqptdso = sqlstm.sqtdso;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



			if (OERROR) 
				err_mesg("OPEN failed on cursor RD_APPT_STATS_1_CUR",0,"");

			/* EXEC SQL FETCH RD_APPT_STATS_1_CUR 
	     			  INTO  :d_dummy; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )425;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_dummy;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



			if (OERROR) 
				err_mesg("FETCH failed on cursor RD_APPT_STATS_1_CUR",0,"");

			if (sqlca.sqlcode EQ 0){
			   log_messg("RD0249","RD_APPT_STATS");
			   continue; 
			}

		/*******************************************************************/
		/*        If Master Code is not referenced in any table above      */
		/*******************************************************************/

		/* EXEC SQL DELETE RD_SECTION
	   	   WHERE CURRENT OF RD_SECTION_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from RD_SECTION  where rowid = :x";
  sqlstm.iters = (unsigned int  )5;
  sqlstm.offset = (unsigned int  )444;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	  
		if (OERROR)
	    err_mesg("DELETE failed on table RD_SECTION",0,"");

		if (sqlca.sqlcode EQ 0)
	    log_messg("RD0250"," ");


		/* EXEC SQL DELETE RD_SECTION_CTL
		   WHERE SECTION_CODE = :d_master_code ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from RD_SECTION_CTL  where SECTION_CODE=:b0";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )459;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_master_code;
  sqlstm.sqhstl[0] = (unsigned int  )44;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR)
	    err_mesg("DELETE failed on table RD_SECTION_CTL",0,"");
	
		if (sqlca.sqlcode EQ 0)
	    log_messg("RD0250"," ");

	} /* end of while  */

    /* EXEC SQL CLOSE RD_SECTION_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )478;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	//EXEC SQL CLOSE RD_SERVICE_TYPE_1_CUR;
    /* EXEC SQL CLOSE RD_EXAMINATION_1_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )493;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RD_DEF_STORAGE_LOCN_1_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )508;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RD_REQUEST_1_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )523;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    //EXEC SQL CLOSE RD_RECORDS_INDEX_1_CUR;
    /* EXEC SQL CLOSE RD_APPT_1_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )538;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RD_APPT_DEL_TR_1_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )553;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RD_CLINIC_1_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )568;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RD_TRANS_RECORD_1_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )583;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RD_APPT_STATS_1_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )598;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

fetch_section(){
     can_delete = TRUE;

     /* EXEC SQL FETCH RD_SECTION_CUR
              INTO  :d_master_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )613;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&d_master_code;
     sqlstm.sqhstl[0] = (unsigned int  )44;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (OERROR) 
       err_mesg("FETCH failed on cursor RD_SECTION_CUR",0,"");

     if (NO_DATA_FOUND) 
       return 0;
     d_master_code.arr[d_master_code.len] = '\0';

     if (DEBUG) {
       sprintf(string_var, "Section Code = %s\n",d_master_code.arr);
       disp_message(ERR_MESG, string_var); }
     return 1;
}
/***************************** End of SECTION Grp  ****************************/

/*purge_service_type()
{

     EXEC SQL LOCK TABLE RD_SERVICE_TYPE
              IN EXCLUSIVE MODE NOWAIT;

     if (RESOURCE_BUSY)
       err_mesg("TABLE cannot be locked in exclusive mode",0,"");
     else
       if (OERROR)
         err_mesg("LOCK failed on table RD_SERVICE_TYPE",0,"");

     EXEC SQL DECLARE RD_SERVICE_TYPE_CUR CURSOR FOR 
          SELECT  SERVICE_TYPE_CODE
	      FROM    RD_SERVICE_TYPE
	      WHERE   STATUS  = 'S' 
	      FOR     UPDATE  OF STATUS;

     EXEC SQL DECLARE RD_EXAMINATION_2_CUR CURSOR FOR 
              SELECT  'X'
	      FROM    RD_EXAMINATION
	      WHERE   SERVICE_TYPE_CODE = :d_master_code;

     EXEC SQL DECLARE RD_TEXT_BLOCK_2_CUR CURSOR FOR 
              SELECT  'X'
	      FROM    RD_TEXT_BLOCK
	      WHERE   SERVICE_TYPE_CODE = :d_master_code;

     EXEC SQL DECLARE RD_SERVICES_FOR_CLINIC_2_CUR CURSOR FOR 
              SELECT  'X'
	      FROM    RD_SERVICES_FOR_CLINIC
	      WHERE   SERVICE_TYPE_CODE = :d_master_code;

     EXEC SQL DECLARE RD_REQUEST_2_CUR CURSOR FOR 
              SELECT  'X'
	      FROM    RD_REQUEST
	      WHERE   SERVICE_TYPE_CODE = :d_master_code;

     EXEC SQL DECLARE RD_RECORDS_INDEX_2_CUR CURSOR FOR 
              SELECT  'X'
	      FROM    RD_RECORDS_INDEX
	      WHERE   SERVICE_TYPE_CODE = :d_master_code;

     EXEC SQL DECLARE RD_APPT_2_CUR CURSOR FOR 
              SELECT  'X'
	      FROM    RD_APPT
	      WHERE   SERVICE_TYPE_CODE = :d_master_code;

     EXEC SQL DECLARE RD_APPT_DEL_TR_2_CUR CURSOR FOR 
              SELECT  'X'
	      FROM    RD_APPT_DEL_TR
	      WHERE   SERVICE_TYPE_CODE = :d_master_code;

     EXEC SQL OPEN RD_SERVICE_TYPE_CUR;

     if (OERROR)
       err_mesg("OPEN failed on cursor RD_SERVICE_TYPE_CUR",0,"");

     while (fetch_service_type())
       {
   	  EXEC SQL OPEN RD_EXAMINATION_2_CUR;

	  if (OERROR) 
	    err_mesg("OPEN failed on cursor RD_EXAMINATION_2_CUR",0,"");

	  EXEC SQL FETCH RD_EXAMINATION_2_CUR 
	     	   INTO  :d_dummy;

	  if (OERROR) 
	    err_mesg("FETCH failed on cursor RD_EXAMINATION_2_CUR",0,"");

	  if (sqlca.sqlcode EQ 0)
	    {
	       log_messg("RD0249","RD_EXAMINATION");
	       continue; 
	    }

	  EXEC SQL OPEN RD_TEXT_BLOCK_2_CUR;

	  if (OERROR) 
	    err_mesg("OPEN failed on cursor RD_TEXT_BLOCK_2_CUR",0,"");

	  EXEC SQL FETCH RD_TEXT_BLOCK_2_CUR 
	     	   INTO  :d_dummy;

	  if (OERROR) 
	    err_mesg("FETCH failed on cursor RD_TEXT_BLOCK_2_CUR",0,"");

	  if (sqlca.sqlcode EQ 0)
	    {
	       log_messg("RD0249","RD_TEXT_BLOCK");
	       continue; 
	    }

	  EXEC SQL OPEN RD_SERVICES_FOR_CLINIC_2_CUR;

	  if (OERROR) 
	    err_mesg("OPEN failed on cursor RD_SERVICES_FOR_CLINIC_2_CUR",0,"");

	  EXEC SQL FETCH RD_SERVICES_FOR_CLINIC_2_CUR 
	     	   INTO  :d_dummy;

	  if (OERROR) 
	    err_mesg("FETCH failed on cursor RD_SERVICES_FOR_CLINIC_2_CUR",0,"");

	  if (sqlca.sqlcode EQ 0)
	    {
	       log_messg("RD0249","RD_SERVICES_FOR_CLINIC");
	       continue; 
	    }

	  
   	  EXEC SQL OPEN RD_REQUEST_2_CUR;

	  if (OERROR) 
	    err_mesg("OPEN failed on cursor RD_REQUEST_2_CUR",0,"");

	  EXEC SQL FETCH RD_REQUEST_2_CUR 
	     	   INTO  :d_dummy;

	  if (OERROR) 
	    err_mesg("FETCH failed on cursor RD_REQUEST_2_CUR",0,"");

	  if (sqlca.sqlcode EQ 0)
	    {
	       log_messg("RD0249","RD_REQUEST");
	       continue; 
	    }

	  
   	  EXEC SQL OPEN RD_RECORDS_INDEX_2_CUR;

	  if (OERROR) 
	    err_mesg("OPEN failed on cursor RD_RECORDS_INDEX_2_CUR",0,"");

	  EXEC SQL FETCH RD_RECORDS_INDEX_2_CUR 
	     	   INTO  :d_dummy;

	  if (OERROR) 
	    err_mesg("FETCH failed on cursor RD_RECORDS_INDEX_2_CUR",0,"");

	  if (sqlca.sqlcode EQ 0)
	    {
	       log_messg("RD0249","RD_RECORDS_INDEX");
	       continue; 
	    }
 

   	  EXEC SQL OPEN RD_APPT_2_CUR;

	  if (OERROR) 
	    err_mesg("OPEN failed on cursor RD_APPT_2_CUR",0,"");

	  EXEC SQL FETCH RD_APPT_2_CUR 
	     	   INTO  :d_dummy;

	  if (OERROR) 
	    err_mesg("FETCH failed on cursor RD_APPT_2_CUR",0,"");

	  if (sqlca.sqlcode EQ 0)
	    {
	       log_messg("RD0249","RD_APPT");
	       continue; 
	    }

	  

   	  EXEC SQL OPEN RD_APPT_DEL_TR_2_CUR;

	  if (OERROR) 
	    err_mesg("OPEN failed on cursor RD_APPT_DEL_TR_2_CUR",0,"");

	  EXEC SQL FETCH RD_APPT_DEL_TR_2_CUR 
	     	   INTO  :d_dummy;

	  if (OERROR) 
	    err_mesg("FETCH failed on cursor RD_APPT_DEL_TR_2_CUR",0,"");

	  if (sqlca.sqlcode EQ 0)
	    {
	       log_messg("RD0249","RD_APPT_DEL_TR");
	       continue; 
	    }

		
		EXEC SQL DELETE RD_SERVICE_TYPE
	   		   WHERE CURRENT OF RD_SERVICE_TYPE_CUR; 
		if (OERROR)
			err_mesg("DELETE failed on table RD_SERVICE_TYPE",0,"");
		if (sqlca.sqlcode EQ 0)
			log_messg("RD0250"," ");

	} // end of while 

    EXEC SQL CLOSE RD_SERVICE_TYPE_CUR;
    EXEC SQL CLOSE RD_EXAMINATION_2_CUR;
    EXEC SQL CLOSE RD_SERVICES_FOR_CLINIC_2_CUR;
    EXEC SQL CLOSE RD_TEXT_BLOCK_2_CUR;
    EXEC SQL CLOSE RD_REQUEST_2_CUR;
    EXEC SQL CLOSE RD_RECORDS_INDEX_2_CUR;
    EXEC SQL CLOSE RD_APPT_2_CUR;
    EXEC SQL CLOSE RD_APPT_DEL_TR_2_CUR;

}

fetch_service_type()
{
     can_delete = TRUE;

     EXEC SQL FETCH RD_SERVICE_TYPE_CUR 
              INTO  :d_master_code;

     if (OERROR) 
       err_mesg("FETCH failed on cursor RD_SERVICE_TYPE_CUR",0,"");

     if (NO_DATA_FOUND) 
       return 0;

     d_master_code.arr[d_master_code.len] = '\0';

     if (DEBUG)  {
       sprintf(string_var, "Service Type Code = %s\n", d_master_code.arr);
       disp_message(ERR_MESG, string_var); }

     return 1;
}*/ //commented by rvN on 09/10/2003
/***************************** End of SERVICE Grp  ****************************/

purge_examination()
{
     /* EXEC SQL LOCK TABLE RD_EXAMINATION
              IN EXCLUSIVE MODE NOWAIT; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "lock TABLE RD_EXAMINATION IN EXCLUSIVE MODE NOWAIT";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )632;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (RESOURCE_BUSY)
       err_mesg("TABLE cannot be locked in exclusive mode",0,"");
     else
       if (OERROR)
         err_mesg("LOCK failed on table RD_EXAMINATION",0,"");

     /* EXEC SQL DECLARE RD_EXAMINATION_CUR CURSOR FOR 
              SELECT  EXAM_CODE
			  FROM    RD_EXAMINATION
			  WHERE   STATUS  = 'S' 
			  FOR     UPDATE  OF STATUS; */ 


     /* EXEC SQL DECLARE RD_GROUP_EXAMS_3_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_GROUP_EXAMS
			  WHERE   GROUP_EXAM_CODE = :d_master_code
			  OR      COMPONENT_EXAM_CODE = :d_master_code; */ 


     /* EXEC SQL DECLARE RD_EXAM_VIEWS_3_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_EXAM_VIEWS
			  WHERE   EXAM_CODE = :d_master_code; */ 


     /* EXEC SQL DECLARE RD_ITEMS_FOR_EXAM_3_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_ITEMS_FOR_EXAM
			  WHERE   EXAM_CODE = :d_master_code; */ 


     /* EXEC SQL DECLARE RD_CONFLICTING_EXAMS_3_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_CONFLICTING_EXAMS
			  WHERE	  EXAM_CODE_1 = :d_master_code
				 OR   EXAM_CODE_2 = :d_master_code; */ 


     /* EXEC SQL DECLARE RD_EXAMS_REQUESTED_3_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_EXAM_VIEW_REQUESTED
			  WHERE	  OPERATING_FACILITY_ID = :d_facility_id 
			  AND     EXAM_CODE = :d_master_code; */ 


     /* EXEC SQL DECLARE RD_EXAM_VIEW_REQUESTED_3_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_EXAM_VIEW_REQUESTED
			  WHERE	  OPERATING_FACILITY_ID = :d_facility_id 
			  AND     EXAM_CODE = :d_master_code; */ 


     /* EXEC SQL DECLARE RD_ITEMS_CONSUMED_3_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_ITEMS_CONSUMED
			  WHERE	  OPERATING_FACILITY_ID = :d_facility_id 
			  AND     EXAM_CODE = :d_master_code; */ 


     /* EXEC SQL DECLARE RD_ITEM_BLNG_SRVC_3_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_ITEM_BLNG_SRVC
			  WHERE	  OPERATING_FACILITY_ID = :d_facility_id 
			  AND     EXAM_CODE = :d_master_code; */ 


     /* EXEC SQL DECLARE RD_ITEM_BATCH_3_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_ITEM_BATCH
			  WHERE   OPERATING_FACILITY_ID = :d_facility_id 
			  AND     EXAM_CODE = :d_master_code; */ 


     /* EXEC SQL DECLARE RD_OTHER_CHARGES_3_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_OTHER_CHARGES
			  WHERE   OPERATING_FACILITY_ID = :d_facility_id 
			  AND     EXAM_CODE = :d_master_code; */ 


     /* EXEC SQL DECLARE RD_PAT_EXAM_CONFLICTS_3_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_PAT_EXAM_CONFLICTS
			  WHERE   EXAM_CODE = :d_master_code; */ 


     /*EXEC SQL DECLARE RD_RECORDS_INDEX_3_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_RECORDS_INDEX
			  WHERE   OPERATING_FACILITY_ID = :d_facility_id 
			  AND     EXAM_CODE = :d_master_code;*/ //rvN on 22/12/2003

     /* EXEC SQL DECLARE RD_APPT_EXAMS_3_CUR  CURSOR FOR
			  SELECT  'X'
			  FROM    RD_APPT
			  WHERE   OPERATING_FACILITY_ID = :d_facility_id 
			  AND     EXAM_CODE = :d_master_code; */ 


     /* EXEC SQL DECLARE RD_APPT_EXAMS_DEL_TR_3_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_APPT_DEL_TR
			  WHERE   OPERATING_FACILITY_ID = :d_facility_id 
			  AND     EXAM_CODE = :d_master_code; */ 


     /* EXEC SQL DECLARE RD_APPT_STATS_3_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_APPT_STATS
			  WHERE   OPERATING_FACILITY_ID = :d_facility_id 
			  AND     EXAM_CODE = :d_master_code; */ 


     /* EXEC SQL DECLARE OR_ORDER_LINE_3_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    OR_ORDER_LINE, OR_ORDER
			  WHERE   NVL(OR_ORDER.ORDERING_FACILITY_ID,OR_ORDER.PERFORMING_FACILITY_ID) = :d_facility_id 
			  AND     OR_ORDER_LINE.ORDER_TYPE_CODE = OR_ORDER.ORDER_TYPE_CODE
			  AND     OR_ORDER_LINE.ORDER_ID = OR_ORDER.ORDER_ID
			  AND     OR_ORDER_LINE.ORDER_CATEGORY = 'RAD'
			  AND     ORDER_CATALOG_CODE = :d_master_code; */ 


     /*EXEC SQL DECLARE OR_ORDER_LINE_DTL_3_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    OR_ORDER_LINE_DTL, OR_ORDER
			  WHERE   OR_ORDER_LINE_DTL.ORDER_TYPE_CODE = OR_ORDER.ORDER_TYPE_CODE
			  AND     OR_ORDER_LINE_DTL.ORDER_ID = OR_ORDER.ORDER_ID
			  AND     ORDER_CATEGORY = 'RAD'
			  AND     ORDER_CATALOG_CODE= :d_master_code;*/ //commented by rvN on 09/10/2003 table not found OR_ORDER_LINE_DTL

	/* EXEC SQL OPEN RD_EXAMINATION_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0017;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )647;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
      err_mesg("OPEN failed on cursor RD_EXAMINATION_CUR",0,"");

    while (fetch_examination())
	{
   		/* EXEC SQL OPEN RD_GROUP_EXAMS_3_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0018;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )662;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&d_master_code;
     sqlstm.sqhstl[0] = (unsigned int  )44;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_master_code;
     sqlstm.sqhstl[1] = (unsigned int  )44;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_GROUP_EXAMS_3_CUR",0,"");

		/* EXEC SQL FETCH RD_GROUP_EXAMS_3_CUR 
	    		  INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )685;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		
		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_GROUP_EXAMS_3_CUR",0,"");
		
		if (sqlca.sqlcode EQ 0)
		{
			log_messg("RD0249","RD_GROUP_EXAMS");
			continue; 
		}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		/* EXEC SQL OPEN RD_EXAM_VIEWS_3_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0019;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )704;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&d_master_code;
     sqlstm.sqhstl[0] = (unsigned int  )44;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			if (OERROR) 
				err_mesg("OPEN failed on cursor RD_EXAM_VIEWS_3_CUR",0,"");

			/* EXEC SQL FETCH RD_EXAM_VIEWS_3_CUR 
	     			  INTO  :d_dummy; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )723;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_dummy;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


			
			if (OERROR) 
				err_mesg("FETCH failed on cursor RD_EXAM_VIEWS_3_CUR",0,"");

			if (sqlca.sqlcode EQ 0)
			{
				log_messg("RD0249","RD_EXAM_VIEWS");
				continue; 
			}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

		/* EXEC SQL OPEN RD_ITEMS_FOR_EXAM_3_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0020;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )742;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_master_code;
  sqlstm.sqhstl[0] = (unsigned int  )44;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_ITEMS_FOR_EXAM_3_CUR",0,"");
		
		/* EXEC SQL FETCH RD_ITEMS_FOR_EXAM_3_CUR 
				  INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )761;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_ITEMS_FOR_EXAM_3_CUR",0,"");
		
		if (sqlca.sqlcode EQ 0){
			log_messg("RD0249","RD_ITEMS_FOR_EXAM");
			continue; 
		}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		/* EXEC SQL OPEN RD_CONFLICTING_EXAMS_3_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0021;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )780;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&d_master_code;
     sqlstm.sqhstl[0] = (unsigned int  )44;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_master_code;
     sqlstm.sqhstl[1] = (unsigned int  )44;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_CONFLICTING_EXAMS_3_CUR",0,"");

		/* EXEC SQL FETCH RD_CONFLICTING_EXAMS_3_CUR 
	     		  INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )803;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_CONFLICTING_EXAMS_3_CUR",0,"");

		if (sqlca.sqlcode EQ 0){
			log_messg("RD0249","RD_CONFLICTING_EXAMS");
			continue; 
		}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		
		/* EXEC SQL OPEN RD_EXAMS_REQUESTED_3_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0022;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )822;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_master_code;
  sqlstm.sqhstl[1] = (unsigned int  )44;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_EXAMS_REQUESTED_3_CUR",0,"");

		/* EXEC SQL FETCH RD_EXAMS_REQUESTED_3_CUR 
	     		  INTO :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )845;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_EXAMS_REQUESTED_3_CUR",0,"");

		if (sqlca.sqlcode EQ 0){
			log_messg("RD0249","RD_EXAMS_REQUESTED");
			continue; 
		}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		/* EXEC SQL OPEN RD_EXAM_VIEW_REQUESTED_3_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0023;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )864;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_master_code;
     sqlstm.sqhstl[1] = (unsigned int  )44;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_EXAM_VIEW_REQUESTED_3_CUR",0,"");

		/* EXEC SQL FETCH RD_EXAM_VIEW_REQUESTED_3_CUR 
	     		  INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )887;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_EXAM_VIEW_REQUESTED_3_CUR",0,"");

		if (sqlca.sqlcode EQ 0){
			log_messg("RD0249","RD_EXAM_VIEW_REQUESTED");
			continue; 
		}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		/* EXEC SQL OPEN RD_ITEMS_CONSUMED_3_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0024;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )906;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_master_code;
     sqlstm.sqhstl[1] = (unsigned int  )44;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_ITEMS_CONSUMED_3_CUR",0,"");

		/* EXEC SQL FETCH RD_ITEMS_CONSUMED_3_CUR 
	     		  INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )929;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_ITEMS_CONSUMED_3_CUR",0,"");

		if (sqlca.sqlcode EQ 0){
				log_messg("RD0249","RD_ITEMS_CONSUMED");
				continue; 
		}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		/* EXEC SQL OPEN RD_ITEM_BLNG_SRVC_3_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0025;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )948;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_master_code;
     sqlstm.sqhstl[1] = (unsigned int  )44;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_ITEM_BLNG_SRVC_3_CUR",0,"");

		/* EXEC SQL FETCH RD_ITEM_BLNG_SRVC_3_CUR 
	     		  INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )971;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_ITEM_BLNG_SRVC_3_CUR",0,"");

		if (sqlca.sqlcode EQ 0){
			log_messg("RD0249","RD_ITEM_BLNG_SRVC");
			continue; 
		}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		/* EXEC SQL OPEN RD_ITEM_BATCH_3_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0026;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )990;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_master_code;
     sqlstm.sqhstl[1] = (unsigned int  )44;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_ITEM_BATCH_3_CUR",0,"");

		/* EXEC SQL FETCH RD_ITEM_BATCH_3_CUR 
				  INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1013;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_ITEM_BATCH_3_CUR",0,"");

		if (sqlca.sqlcode EQ 0){
			log_messg("RD0249","RD_ITEM_BATCH");
			continue; 
		}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		/* EXEC SQL OPEN RD_OTHER_CHARGES_3_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0027;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1032;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_master_code;
     sqlstm.sqhstl[1] = (unsigned int  )44;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_OTHER_CHARGES_3_CUR",0,"");

		  /* EXEC SQL FETCH RD_OTHER_CHARGES_3_CUR 
	     		   INTO  :d_dummy; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1055;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_dummy;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		  if (OERROR) 
			err_mesg("FETCH failed on cursor RD_OTHER_CHARGES_3_CUR",0,"");

		  if (sqlca.sqlcode EQ 0)
			{
			   log_messg("RD0249","RD_OTHER_CHARGES");
			   continue; 
			}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		  /* EXEC SQL OPEN RD_PAT_EXAM_CONFLICTS_3_CUR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 5;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0028;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1074;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&d_master_code;
       sqlstm.sqhstl[0] = (unsigned int  )44;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqphsv = sqlstm.sqhstv;
       sqlstm.sqphsl = sqlstm.sqhstl;
       sqlstm.sqphss = sqlstm.sqhsts;
       sqlstm.sqpind = sqlstm.sqindv;
       sqlstm.sqpins = sqlstm.sqinds;
       sqlstm.sqparm = sqlstm.sqharm;
       sqlstm.sqparc = sqlstm.sqharc;
       sqlstm.sqpadto = sqlstm.sqadto;
       sqlstm.sqptdso = sqlstm.sqtdso;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		  if (OERROR) 
			err_mesg("OPEN failed on cursor RD_PAT_EXAM_CONFLICTS_3_CUR",0,"");

		  /* EXEC SQL FETCH RD_PAT_EXAM_CONFLICTS_3_CUR 
	     		   INTO  :d_dummy; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1093;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_dummy;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		  if (OERROR) 
			err_mesg("FETCH failed on cursor RD_PAT_EXAM_CONFLICTS_3_CUR",0,"");

		  if (sqlca.sqlcode EQ 0)
			{
			   log_messg("RD0249","RD_PAT_EXAM_CONFLICTS");
			   continue; 
			}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		  /*EXEC SQL OPEN RD_RECORDS_INDEX_3_CUR;
		  if (OERROR) 
			err_mesg("OPEN failed on cursor RD_RECORDS_INDEX_3_CUR",0,"");

		  EXEC SQL FETCH RD_RECORDS_INDEX_3_CUR 
	     		   INTO  :d_dummy;

		  if (OERROR) 
			err_mesg("FETCH failed on cursor RD_RECORDS_INDEX_3_CUR",0,"");

		  if (sqlca.sqlcode EQ 0)
			{
			   log_messg("RD0249","RD_RECORDS_INDEX");
			   continue; 
			}	 */ //rvN on 22nd Dec 2003
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		  /* EXEC SQL OPEN RD_APPT_EXAMS_3_CUR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 5;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0029;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1112;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
       sqlstm.sqhstl[0] = (unsigned int  )5;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_master_code;
       sqlstm.sqhstl[1] = (unsigned int  )44;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqphsv = sqlstm.sqhstv;
       sqlstm.sqphsl = sqlstm.sqhstl;
       sqlstm.sqphss = sqlstm.sqhsts;
       sqlstm.sqpind = sqlstm.sqindv;
       sqlstm.sqpins = sqlstm.sqinds;
       sqlstm.sqparm = sqlstm.sqharm;
       sqlstm.sqparc = sqlstm.sqharc;
       sqlstm.sqpadto = sqlstm.sqadto;
       sqlstm.sqptdso = sqlstm.sqtdso;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		  
		  if (OERROR) 
			err_mesg("OPEN failed on cursor RD_APPT_EXAMS_3_CUR",0,"");

		  /* EXEC SQL FETCH RD_APPT_EXAMS_3_CUR 
	     		   INTO  :d_dummy; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1135;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_dummy;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		  if (OERROR) 
			err_mesg("FETCH failed on cursor RD_APPT_EXAMS_3_CUR",0,"");

		  if (sqlca.sqlcode EQ 0)
			{
			   log_messg("RD0249","RD_APPT_EXAMS");
			   continue; 
			}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		  /* EXEC SQL OPEN RD_APPT_EXAMS_DEL_TR_3_CUR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 5;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0030;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1154;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
       sqlstm.sqhstl[0] = (unsigned int  )5;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_master_code;
       sqlstm.sqhstl[1] = (unsigned int  )44;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqphsv = sqlstm.sqhstv;
       sqlstm.sqphsl = sqlstm.sqhstl;
       sqlstm.sqphss = sqlstm.sqhsts;
       sqlstm.sqpind = sqlstm.sqindv;
       sqlstm.sqpins = sqlstm.sqinds;
       sqlstm.sqparm = sqlstm.sqharm;
       sqlstm.sqparc = sqlstm.sqharc;
       sqlstm.sqpadto = sqlstm.sqadto;
       sqlstm.sqptdso = sqlstm.sqtdso;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		  if (OERROR) 
			err_mesg("OPEN failed on cursor RD_APPT_EXAMS_DEL_TR_3_CUR",0,"");

		  /* EXEC SQL FETCH RD_APPT_EXAMS_DEL_TR_3_CUR 
	     		   INTO  :d_dummy; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1177;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_dummy;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		  if (OERROR) 
			err_mesg("FETCH failed on cursor RD_APPT_EXAMS_DEL_TR_3_CUR",0,"");

		  if (sqlca.sqlcode EQ 0)
			{
			   log_messg("RD0249","RD_APPT_EXAMS_DEL_TR");
			   continue; 
			}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		  /* EXEC SQL OPEN RD_APPT_STATS_3_CUR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 5;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0031;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1196;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
       sqlstm.sqhstl[0] = (unsigned int  )5;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_master_code;
       sqlstm.sqhstl[1] = (unsigned int  )44;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqphsv = sqlstm.sqhstv;
       sqlstm.sqphsl = sqlstm.sqhstl;
       sqlstm.sqphss = sqlstm.sqhsts;
       sqlstm.sqpind = sqlstm.sqindv;
       sqlstm.sqpins = sqlstm.sqinds;
       sqlstm.sqparm = sqlstm.sqharm;
       sqlstm.sqparc = sqlstm.sqharc;
       sqlstm.sqpadto = sqlstm.sqadto;
       sqlstm.sqptdso = sqlstm.sqtdso;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		  if (OERROR) 
			err_mesg("OPEN failed on cursor RD_APPT_STATS_3_CUR",0,"");

		  /* EXEC SQL FETCH RD_APPT_STATS_3_CUR 
	     		   INTO  :d_dummy; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1219;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_dummy;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		  if (OERROR) 
			err_mesg("FETCH failed on cursor RD_APPT_STATS_3_CUR",0,"");

		  if (sqlca.sqlcode EQ 0)
			{
			   log_messg("RD0249","RD_APPT_STATS");
			   continue; 
			}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		  /* EXEC SQL OPEN OR_ORDER_LINE_3_CUR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 5;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0032;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )1238;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
       sqlstm.sqhstl[0] = (unsigned int  )5;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_master_code;
       sqlstm.sqhstl[1] = (unsigned int  )44;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqphsv = sqlstm.sqhstv;
       sqlstm.sqphsl = sqlstm.sqhstl;
       sqlstm.sqphss = sqlstm.sqhsts;
       sqlstm.sqpind = sqlstm.sqindv;
       sqlstm.sqpins = sqlstm.sqinds;
       sqlstm.sqparm = sqlstm.sqharm;
       sqlstm.sqparc = sqlstm.sqharc;
       sqlstm.sqpadto = sqlstm.sqadto;
       sqlstm.sqptdso = sqlstm.sqtdso;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		  if (OERROR) 
			err_mesg("OPEN failed on cursor OR_ORDER_LINE_3_CUR",0,"");

		  /* EXEC SQL FETCH OR_ORDER_LINE_3_CUR 
	     		   INTO  :d_dummy; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1261;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_dummy;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		  if (OERROR) 
			err_mesg("FETCH failed on cursor OR_ORDER_LINE_3_CUR",0,"");

		  if (sqlca.sqlcode EQ 0)
			{
			   log_messg("RD0249","OR_ORDER_LINE");
			   continue; 
			}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		/*EXEC SQL OPEN OR_ORDER_LINE_DTL_3_CUR;

			if (OERROR) 
			err_mesg("OPEN failed on cursor OR_ORDER_LINE_DTL_3_CUR",0,"");

		  EXEC SQL FETCH OR_ORDER_LINE_DTL_3_CUR 
	     		   INTO  :d_dummy;

		  if (OERROR) 
			err_mesg("FETCH failed on cursor OR_ORDER_LINE_DTL_3_CUR",0,"");

		  if (sqlca.sqlcode EQ 0)
			{
			   log_messg("RD0249","OR_ORDER_LINE_DTL");
			   continue; 
		}*/

		/*******************************************************************/
		/*        If Master Code is not referenced in any table above      */
		/*******************************************************************/

		/* EXEC SQL DELETE RD_EXAMINATION
				  WHERE CURRENT OF RD_EXAMINATION_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from RD_EXAMINATION  where rowid = :x";
  sqlstm.iters = (unsigned int  )17;
  sqlstm.offset = (unsigned int  )1280;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

 

		if (OERROR)
			err_mesg("DELETE failed on table RD_EXAMINATION",0,"");
		if (sqlca.sqlcode EQ 0)
			log_messg("RD0250"," ");
	} /* end of while  */

     /* EXEC SQL CLOSE RD_EXAMINATION_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1295;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     /* EXEC SQL CLOSE RD_GROUP_EXAMS_3_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1310;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     /* EXEC SQL CLOSE RD_EXAM_VIEWS_3_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1325;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     /* EXEC SQL CLOSE RD_ITEMS_FOR_EXAM_3_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1340;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     /* EXEC SQL CLOSE RD_CONFLICTING_EXAMS_3_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1355;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     /* EXEC SQL CLOSE RD_EXAMS_REQUESTED_3_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1370;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     /* EXEC SQL CLOSE RD_EXAM_VIEW_REQUESTED_3_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1385;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     /* EXEC SQL CLOSE RD_ITEMS_CONSUMED_3_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1400;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     /* EXEC SQL CLOSE RD_ITEM_BLNG_SRVC_3_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1415;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     /* EXEC SQL CLOSE RD_ITEM_BATCH_3_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1430;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     /* EXEC SQL CLOSE RD_OTHER_CHARGES_3_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1445;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     /* EXEC SQL CLOSE RD_PAT_EXAM_CONFLICTS_3_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1460;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     //EXEC SQL CLOSE RD_RECORDS_INDEX_3_CUR;
     /* EXEC SQL CLOSE RD_APPT_EXAMS_3_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1475;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     /* EXEC SQL CLOSE RD_APPT_EXAMS_DEL_TR_3_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1490;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     /* EXEC SQL CLOSE RD_APPT_STATS_3_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1505;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     /* EXEC SQL CLOSE OR_ORDER_LINE_3_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1520;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     //EXEC SQL CLOSE OR_ORDER_LINE_DTL_3_CUR;
     //EXEC SQL CLOSE RD_RECORDS_INDEX_3_CUR;
  }

fetch_examination()
  {
     can_delete = TRUE;

     /* EXEC SQL FETCH RD_EXAMINATION_CUR
	      INTO  :d_master_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1535;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&d_master_code;
     sqlstm.sqhstl[0] = (unsigned int  )44;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (OERROR) 
       err_mesg("FETCH failed on cursor RD_EXAMINATION_CUR",0,"");

     if (NO_DATA_FOUND) 
       return 0;

     d_master_code.arr[d_master_code.len] = '\0';

     if (DEBUG) {
       sprintf(string_var, "Exam Code = %s\n",d_master_code.arr);
       disp_message(ERR_MESG, string_var);       }

     return 1;
  }

/******************************* End of EXAM Grp  *****************************/
purge_clinic()
{

	/* EXEC SQL LOCK TABLE RD_CLINIC
			   IN EXCLUSIVE MODE NOWAIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "lock TABLE RD_CLINIC IN EXCLUSIVE MODE NOWAIT";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1554;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	
	if (RESOURCE_BUSY)
		err_mesg("TABLE cannot be locked in exclusive mode",0,"");
	else
		if (OERROR)
			err_mesg("LOCK failed on table RD_CLINIC",0,"");

	/* EXEC SQL DECLARE RD_CLINIC_CUR CURSOR FOR 
			 SELECT  CLINIC_CODE 
			 FROM    RD_CLINIC
			 WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 AND     STATUS  = 'S' 
			 FOR     UPDATE  OF STATUS; */ 


	/* EXEC SQL DECLARE RD_APPT_4_CUR CURSOR FOR 
			 SELECT  'X'
			 FROM    RD_APPT
			 WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 AND     CLINIC_CODE = :d_master_code; */ 


	/* EXEC SQL DECLARE RD_APPT_DEL_TR_4_CUR CURSOR FOR 
             SELECT  'X'
			 FROM    RD_APPT_DEL_TR
			 WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 AND     CLINIC_CODE = :d_master_code; */ 


	/*EXEC SQL DECLARE RD_CLINIC_SCHEDULE_4_CUR CURSOR FOR 
              SELECT  'X'
	      FROM    RD_CLINIC_SCHEDULE
	      WHERE   CLINIC_CODE = :d_master_code;
		  *** commented on 19/10/1998 */

	/* EXEC SQL DECLARE RD_CLINIC_TIME_TABLE_4_CUR CURSOR FOR 
			 SELECT  'X'
			 FROM    RD_CLINIC_TIME_TABLE
			 WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 AND     CLINIC_CODE = :d_master_code; */ 


	/*EXEC SQL DECLARE RD_CLINIC_SCHEDULE_VALIDITY_4_CUR CURSOR FOR 
              SELECT  'X'
	      FROM    RD_CLINIC_SCHEDULE_VALIDITY
	      WHERE   CLINIC_CODE = :d_master_code; 
		  ***commented on 24/10/97*/

	/* EXEC SQL DECLARE RD_CLINIC_BREAK_4_CUR CURSOR FOR 
             SELECT  'X'
			 FROM    RD_CLINIC_BREAK
			 WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 AND     CLINIC_CODE = :d_master_code; */ 


	/* EXEC SQL DECLARE RD_USER_CLINIC_RIGHTS_4_CUR CURSOR FOR 
             SELECT  'X'
			 FROM    RD_USER_CLINIC_RIGHTS
			 WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 AND     CLINIC_CODE = :d_master_code; */ 


	/* EXEC SQL DECLARE RD_TRANS_RECORD_4_CUR CURSOR FOR 
             SELECT  'X'
			 FROM    RD_TRANS_RECORD
			 WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 AND     CLINIC_CODE = :d_master_code; */ 


	/* EXEC SQL DECLARE RD_APPT_STATS_4_CUR CURSOR FOR 
             SELECT  'X'
			 FROM    RD_APPT_STATS
			 WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 AND     CLINIC_CODE = :d_master_code; */ 


	/*EXEC SQL DECLARE RD_SERVICES_FOR_CLINIC_4_CUR CURSOR FOR 
              SELECT  'X'
	      FROM    RD_SERVICES_FOR_CLINIC
	      WHERE   CLINIC_CODE = :d_master_code; 
			**** commented on 19/10/1998  ****/

    /* EXEC SQL OPEN RD_CLINIC_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0035;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1569;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
		err_mesg("OPEN failed on cursor RD_CLINIC_CUR",0,"");

	while (fetch_clinic())
	{
		/* EXEC SQL OPEN RD_APPT_4_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0036;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1588;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_master_code;
  sqlstm.sqhstl[1] = (unsigned int  )44;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_APPT_4_CUR",0,"");

		/* EXEC SQL FETCH RD_APPT_4_CUR 
	     		  INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1611;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_APPT_4_CUR",0,"");

		if (sqlca.sqlcode EQ 0)
	    {
	        log_messg("RD0249","RD_APPT");
	        continue; 
	    }
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		
		/* EXEC SQL OPEN RD_APPT_DEL_TR_4_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0037;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1630;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_master_code;
  sqlstm.sqhstl[1] = (unsigned int  )44;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_APPT_DEL_TR_4_CUR",0,"");

		/* EXEC SQL FETCH RD_APPT_DEL_TR_4_CUR 
	     		  INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1653;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_APPT_DEL_TR_4_CUR",0,"");

		if (sqlca.sqlcode EQ 0)
	    {
	       log_messg("RD0249","RD_APPT_DEL_TR");
	       continue; 
	    }
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		/*  commented on 19/10/1998
   		EXEC SQL OPEN RD_CLINIC_SCHEDULE_4_CUR;

		  if (OERROR) 
			err_mesg("OPEN failed on cursor RD_CLINIC_SCHEDULE_4_CUR",0,"");

		  EXEC SQL FETCH RD_CLINIC_SCHEDULE_4_CUR 
	     		   INTO  :d_dummy;

		  if (OERROR) 
			err_mesg("FETCH failed on cursor RD_CLINIC_SCHEDULE_4_CUR",0,"");

		  if (sqlca.sqlcode EQ 0)
			{
			   log_messg("RD0249","RD_CLINIC_SCHEDULE");
			   continue; 
			}******/
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		
		/* EXEC SQL OPEN RD_CLINIC_TIME_TABLE_4_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0038;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1672;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_master_code;
  sqlstm.sqhstl[1] = (unsigned int  )44;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_CLINIC_TIME_TABLE_4_CUR",0,"");

		  /* EXEC SQL FETCH RD_CLINIC_TIME_TABLE_4_CUR 
	     		   INTO  :d_dummy; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1695;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_dummy;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		  if (OERROR) 
			err_mesg("FETCH failed on cursor RD_CLINIC_TIME_TABLE_4_CUR",0,"");

		  if (sqlca.sqlcode EQ 0)
			{
			   log_messg("RD0249","RD_CLINIC_TIME_TABLE");
			   continue; 
			}

		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		/* EXEC SQL OPEN RD_CLINIC_SCHEDULE_VALIDITY_4_CUR;

		  if (OERROR) 
			err_mesg("OPEN failed on cursor RD_CLINIC_SCHEDULE_VALIDITY_4_CUR",0,"");

		  EXEC SQL FETCH RD_CLINIC_SCHEDULE_VALIDITY_4_CUR 
	     		   INTO  :d_dummy;

		  if (OERROR) 
			err_mesg("FETCH failed on cursor RD_CLINIC_SCHEDULE_VALIDITY_4_CUR",0,"");

		  if (sqlca.sqlcode EQ 0)
			{
			   log_messg("RD0249","RD_CLINIC_SCHEDULE_VALIDITY");
			   continue; 
			}
			****commented on 24/10/97 */
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

		/* EXEC SQL OPEN RD_CLINIC_BREAK_4_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0039;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1714;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_master_code;
  sqlstm.sqhstl[1] = (unsigned int  )44;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_CLINIC_BREAK_4_CUR",0,"");

		/* EXEC SQL FETCH RD_CLINIC_BREAK_4_CUR 
	     		  INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1737;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_CLINIC_BREAK_4_CUR",0,"");

		if (sqlca.sqlcode EQ 0)
			{
				log_messg("RD0249","RD_CLINIC_BREAK");
				continue; 
			}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

		/* EXEC SQL OPEN RD_USER_CLINIC_RIGHTS_4_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0040;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1756;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_master_code;
  sqlstm.sqhstl[1] = (unsigned int  )44;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_USER_CLINIC_RIGHTS_4_CUR",0,"");

		/* EXEC SQL FETCH RD_USER_CLINIC_RIGHTS_4_CUR 
				  INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1779;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_USER_CLINIC_RIGHTS_4_CUR",0,"");

		if (sqlca.sqlcode EQ 0)
			{
				log_messg("RD0249","RD_USER_CLINIC_RIGHTS");
				continue; 
			}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		/* EXEC SQL OPEN RD_TRANS_RECORD_4_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0041;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1798;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_master_code;
     sqlstm.sqhstl[1] = (unsigned int  )44;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_TRANS_RECORD_4_CUR",0,"");

		/* EXEC SQL FETCH RD_TRANS_RECORD_4_CUR 
	     		  INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1821;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_TRANS_RECORD_4_CUR",0,"");

		if (sqlca.sqlcode EQ 0)
			{
				log_messg("RD0249","RD_TRANS_RECORD");
				continue; 
			}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		/* EXEC SQL OPEN RD_APPT_STATS_4_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0042;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1840;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_master_code;
     sqlstm.sqhstl[1] = (unsigned int  )44;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_APPT_STATS_4_CUR",0,"");
		/* EXEC SQL FETCH RD_APPT_STATS_4_CUR 
	     		  INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1863;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_APPT_STATS_4_CUR",0,"");

		if (sqlca.sqlcode EQ 0)
			{
				log_messg("RD0249","RD_APPT_STATS");
				continue; 
			}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		/******* commented on 19/10/1998
		EXEC SQL OPEN RD_SERVICES_FOR_CLINIC_4_CUR;

		  if (OERROR) 
			err_mesg("OPEN failed on cursor RD_SERVICES_FOR_CLINIC_4_CUR",0,"");

		  EXEC SQL FETCH RD_SERVICES_FOR_CLINIC_4_CUR 
	     		   INTO  :d_dummy;

		  if (OERROR) 
			err_mesg("FETCH failed on cursor RD_SERVICES_FOR_CLINIC_4_CUR",0,"");

		  if (sqlca.sqlcode EQ 0)
			{
			   log_messg("RD0249","RD_SERVICES_FOR_CLINIC");
			   continue; 
			}**********/

		/*******************************************************************/
		/*        If Master Code is not referenced in any table above      */
		/*******************************************************************/

		/* EXEC SQL DELETE RD_CLINIC
	   		      WHERE CURRENT OF RD_CLINIC_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from RD_CLINIC  where rowid = :x";
  sqlstm.iters = (unsigned int  )35;
  sqlstm.offset = (unsigned int  )1882;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

 
			if (OERROR)
				err_mesg("DELETE failed on table RD_CLINIC",0,"");

			if (sqlca.sqlcode EQ 0)
				log_messg("RD0250"," ");
	} /* end of while  */

    /* EXEC SQL CLOSE RD_CLINIC_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1897;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RD_APPT_4_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1912;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RD_APPT_DEL_TR_4_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1927;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /*** commented on 19/10/1998 EXEC SQL CLOSE RD_CLINIC_SCHEDULE_4_CUR;   ****/
    /* EXEC SQL CLOSE RD_CLINIC_TIME_TABLE_4_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1942;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	//  EXEC SQL CLOSE RD_CLINIC_SCHEDULE_VALIDITY_4_CUR;
    /* EXEC SQL CLOSE RD_CLINIC_BREAK_4_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1957;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RD_USER_CLINIC_RIGHTS_4_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1972;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RD_TRANS_RECORD_4_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1987;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RD_APPT_STATS_4_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2002;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /**** commented on 19/10/1998 EXEC SQL CLOSE RD_SERVICES_FOR_CLINIC_4_CUR; ****/
}

fetch_clinic()
{
	can_delete = TRUE;

    /* EXEC SQL FETCH RD_CLINIC_CUR
              INTO  :d_master_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2017;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_master_code;
    sqlstm.sqhstl[0] = (unsigned int  )44;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR) 
		err_mesg("FETCH failed on cursor RD_CLINIC_CUR",0,"");

	if (NO_DATA_FOUND) 
		return 0;

	d_master_code.arr[d_master_code.len] = '\0';

    if (DEBUG) {
		sprintf(string_var, "Section Code = %s\n",d_master_code.arr);
		disp_message(ERR_MESG, string_var); }
     return 1;
}
/***************************** End of CLINIC Grp ******************************/

purge_appt_series()
{
	/* EXEC SQL LOCK TABLE RD_APPT_SERIES
               IN EXCLUSIVE MODE NOWAIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "lock TABLE RD_APPT_SERIES IN EXCLUSIVE MODE NOWAIT";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2036;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (RESOURCE_BUSY)
		err_mesg("TABLE cannot be locked in exclusive mode",0,"");
	else
		if (OERROR)
			err_mesg("LOCK failed on table RD_APPT_SERIES",0,"");

	/* EXEC SQL DECLARE RD_APPT_SERIES_CUR CURSOR FOR 
			 SELECT  APPT_SERIES_CODE
			 FROM    RD_APPT_SERIES
			 WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 ANd     STATUS  = 'S' 
			 FOR     UPDATE  OF STATUS; */ 


	/* EXEC SQL DECLARE RD_CLINIC_5_CUR CURSOR FOR 
             SELECT  'X'
			 FROM    RD_CLINIC
			 WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 ANd     APPT_SERIES_CODE = :d_master_code; */ 


	/* EXEC SQL OPEN RD_APPT_SERIES_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0045;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2051;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
		err_mesg("OPEN failed on cursor RD_APPT_SERIES_CUR",0,"");

	while (fetch_appt_series())
    {
   		/* EXEC SQL OPEN RD_CLINIC_5_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0046;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )2070;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_master_code;
     sqlstm.sqhstl[1] = (unsigned int  )44;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_CLINIC_5_CUR",0,"");

		/* EXEC SQL FETCH RD_CLINIC_5_CUR 
				  INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2093;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR) 
	    err_mesg("FETCH failed on cursor RD_CLINIC_5_CUR",0,"");

		if (sqlca.sqlcode EQ 0)
	    {
			log_messg("RD0249","RD_CLINIC");
			continue; 
	    }

		/*******************************************************************/
		/*        If Master Code is not referenced in any table above      */
		/*******************************************************************/

		/* EXEC SQL DELETE RD_APPT_SERIES
				  WHERE CURRENT OF RD_APPT_SERIES_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from RD_APPT_SERIES  where rowid = :x";
  sqlstm.iters = (unsigned int  )45;
  sqlstm.offset = (unsigned int  )2112;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

 

		if (OERROR)
			err_mesg("DELETE failed on table RD_APPT_SERIES",0,"");

		if (sqlca.sqlcode EQ 0)
			log_messg("RD0250"," ");

    } /* end of while  */

	/* EXEC SQL CLOSE RD_APPT_SERIES_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2127;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RD_CLINIC_5_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2142;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

fetch_appt_series()
{
     can_delete = TRUE;

     /* EXEC SQL FETCH RD_APPT_SERIES_CUR
              INTO  :d_master_code; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )2157;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqfoff = (           int )0;
     sqlstm.sqfmod = (unsigned int )2;
     sqlstm.sqhstv[0] = (         void  *)&d_master_code;
     sqlstm.sqhstl[0] = (unsigned int  )44;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (OERROR) 
       err_mesg("FETCH failed on cursor RD_APPT_SERIES_CUR",0,"");

     if (NO_DATA_FOUND) 
       return 0;

     d_master_code.arr[d_master_code.len] = '\0';

     if (DEBUG) {
       sprintf(string_var, "Appointment Series Code = %s\n",d_master_code.arr);
       disp_message(ERR_MESG, string_var); }
     return 1;
  }
/************************** End of APPT SERIES grp ****************************/
 
purge_view ()
{

	/* EXEC SQL LOCK TABLE RD_VIEW
               IN EXCLUSIVE MODE NOWAIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "lock TABLE RD_VIEW IN EXCLUSIVE MODE NOWAIT";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2176;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (RESOURCE_BUSY)
       err_mesg("TABLE cannot be locked in exclusive mode",0,"");
     else
       if (OERROR)
         err_mesg("LOCK failed on table RD_VIEW",0,"");

     /* EXEC SQL DECLARE RD_VIEW_CUR CURSOR FOR 
              SELECT  VIEW_CODE
			  FROM    RD_VIEW
			  WHERE   STATUS  = 'S' 
			  FOR     UPDATE  OF STATUS; */ 


     /* EXEC SQL DECLARE RD_EXAM_VIEWS_6_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_EXAM_VIEWS
			  WHERE   VIEW_CODE = :d_master_code; */ 


	/*NO VIEWS AVAILABLE IN TABLE */
    /* EXEC SQL DECLARE RD_EXAM_VIEW_REQUESTED_6_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_EXAM_VIEW_REQUESTED
			  WHERE   VIEW1_CODE = :d_master_code
			  OR      VIEW2_CODE = :d_master_code
			  OR      VIEW3_CODE = :d_master_code;

     EXEC SQL DECLARE RD_APPT_EXAMS_6_CUR  CURSOR FOR
			  SELECT  'X'
			  FROM    RD_APPT
			  WHERE   VIEW1_CODE = :d_master_code
			  OR      VIEW2_CODE = :d_master_code
			  OR      VIEW3_CODE = :d_master_code; 

     EXEC SQL DECLARE RD_APPT_EXAMS_DEL_TR_6_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    RD_APPT_EXAMS_DEL_TR
			  WHERE   VIEW1_CODE = :d_master_code
			  OR      VIEW2_CODE = :d_master_code
			  OR      VIEW3_CODE = :d_master_code;

     EXEC SQL DECLARE OR_ORDER_LINE_DTL_6_CUR CURSOR FOR 
              SELECT  'X'
			  FROM    OR_ORDER_LINE_DTL
			  WHERE   VIEW1_CODE = :d_master_code
			  OR      VIEW2_CODE = :d_master_code
			  OR      VIEW3_CODE = :d_master_code;*/

	/* EXEC SQL OPEN RD_VIEW_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0049;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2191;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
		err_mesg("OPEN failed on cursor RD_VIEW_CUR",0,"");

    while (fetch_view())
	{
   		/* EXEC SQL OPEN RD_EXAM_VIEWS_6_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0050;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )2206;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&d_master_code;
     sqlstm.sqhstl[0] = (unsigned int  )44;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_EXAM_VIEWS_6_CUR",0,"");

		/* EXEC SQL FETCH RD_EXAM_VIEWS_6_CUR 
	     		  INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2225;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_EXAM_VIEWS_6_CUR",0,"");

		if (sqlca.sqlcode EQ 0)
	    {
	       log_messg("RD0249","RD_EXAM_VIEWS");
	       continue; 
	    }
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		
		/*
   		  EXEC SQL OPEN RD_EXAM_VIEW_REQUESTED_6_CUR;

		  if (OERROR) 
			err_mesg("OPEN failed on cursor RD_EXAM_VIEW_REQUESTED_6_CUR",0,"");

		  EXEC SQL FETCH RD_EXAM_VIEW_REQUESTED_6_CUR 
	     		   INTO  :d_dummy;

		  if (OERROR) 
			err_mesg("FETCH failed on cursor RD_EXAM_VIEW_REQUESTED_6_CUR",0,"");

		  if (sqlca.sqlcode EQ 0)
			{
			   log_messg("RD0249","RD_EXAM_VIEW_REQUESTED");
			   continue; 
			}*/
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		/* EXEC SQL OPEN RD_APPT_EXAMS_6_CUR;
		  
		  if (OERROR) 
			err_mesg("OPEN failed on cursor RD_APPT_EXAMS_6_CUR",0,"");

		  EXEC SQL FETCH RD_APPT_EXAMS_6_CUR 
	     		   INTO  :d_dummy;

		  if (OERROR) 
			err_mesg("FETCH failed on cursor RD_APPT_EXAMS_6_CUR",0,"");

		  if (sqlca.sqlcode EQ 0)
			{
			   log_messg("RD0249","RD_APPT_EXAMS");
			   continue; 
			}*/
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		/*EXEC SQL OPEN RD_APPT_EXAMS_DEL_TR_6_CUR;

		  if (OERROR) 
			err_mesg("OPEN failed on cursor RD_APPT_EXAMS_DEL_TR_6_CUR",0,"");

		  EXEC SQL FETCH RD_APPT_EXAMS_DEL_TR_6_CUR 
	     		   INTO  :d_dummy;

		  if (OERROR) 
			err_mesg("FETCH failed on cursor RD_APPT_EXAMS_DEL_TR_6_CUR",0,"");

		  if (sqlca.sqlcode EQ 0)
			{
			   log_messg("RD0249","RD_APPT_EXAMS_DEL_TR");
			   continue; 
			}*/
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		/*EXEC SQL OPEN OR_ORDER_LINE_DTL_6_CUR;

		if (OERROR) 
		  err_mesg("OPEN failed on cursor OR_ORDER_LINE_DTL_6_CUR",0,"");

		EXEC SQL FETCH OR_ORDER_LINE_DTL_6_CUR 
	   		   INTO  :d_dummy;

		if (OERROR) 
		  err_mesg("FETCH failed on cursor OR_ORDER_LINE_DTL_6_CUR",0,"");

		if (sqlca.sqlcode EQ 0)
		  {
			 log_messg("RD0249","OR_ORDER_LINE_DTL");
			 continue; 
		  }*/

		/*******************************************************************/
		/*        If Master Code is not referenced in any table above      */
		/*******************************************************************/

		/* EXEC SQL DELETE RD_VIEW
				  WHERE CURRENT OF RD_VIEW_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from RD_VIEW  where rowid = :x";
  sqlstm.iters = (unsigned int  )49;
  sqlstm.offset = (unsigned int  )2244;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

 

		if (OERROR)
			err_mesg("DELETE failed on table RD_VIEW",0,"");

		if (sqlca.sqlcode EQ 0)
			log_messg("RD0250"," ");

	} /* end of while  */

    /* EXEC SQL CLOSE RD_VIEW_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2259;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RD_EXAM_VIEWS_6_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2274;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RD_EXAM_VIEW_REQUESTED_6_CUR;
    EXEC SQL CLOSE RD_APPT_EXAMS_6_CUR;
    EXEC SQL CLOSE RD_APPT_EXAMS_DEL_TR_6_CUR;
    EXEC SQL CLOSE OR_ORDER_LINE_DTL_6_CUR;*/
}

fetch_view()
{
	can_delete = TRUE;

    /* EXEC SQL FETCH RD_VIEW_CUR
		      INTO  :d_master_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2289;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_master_code;
    sqlstm.sqhstl[0] = (unsigned int  )44;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR) 
		err_mesg("FETCH failed on cursor RD_VIEW_CUR",0,"");

	if (NO_DATA_FOUND) 
		return 0;

	d_master_code.arr[d_master_code.len] = '\0';
	if (DEBUG) {
       sprintf(string_var, "Exam Code = %s\n",d_master_code.arr);
       disp_message(ERR_MESG, string_var); }
       
     return 1;
}
/**********************End of View Purging*******************/

/**********************purging for Organ Sites**************/
purge_organ_site ()
{

	/* EXEC SQL LOCK TABLE RD_ORGAN_SITE
			   IN EXCLUSIVE MODE NOWAIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "lock TABLE RD_ORGAN_SITE IN EXCLUSIVE MODE NOWAIT";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2308;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (RESOURCE_BUSY)
		err_mesg("TABLE cannot be locked in exclusive mode",0,"");
	else
		if (OERROR)
			err_mesg("LOCK failed on table RD_ORGAN_SITE",0,"");

	/* EXEC SQL DECLARE RD_ORGAN_SITE_CUR CURSOR FOR 
			 SELECT  ORGAN_SITE_ID
			 FROM    RD_ORGAN_SITE
			 WHERE   STATUS  = 'S' 
			 FOR     UPDATE  OF STATUS; */ 


	/* EXEC SQL DECLARE RD_EX_CUR CURSOR FOR 
             SELECT  'X'
			 FROM    RD_EXAMINATION
			 WHERE   ORGAN_SITE_ID = :d_master_code; */ 


     /* EXEC SQL OPEN RD_ORGAN_SITE_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0053;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )2323;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (OERROR)
       err_mesg("OPEN failed on cursor RD_ORGAN_SITE_CUR",0,"");

     while (fetch_organ_site())
       {
   	  /* EXEC SQL OPEN RD_EX_CUR; */ 

{
      struct sqlexd sqlstm;
      sqlstm.sqlvsn = 12;
      sqlstm.arrsiz = 5;
      sqlstm.sqladtp = &sqladt;
      sqlstm.sqltdsp = &sqltds;
      sqlstm.stmt = sq0054;
      sqlstm.iters = (unsigned int  )1;
      sqlstm.offset = (unsigned int  )2338;
      sqlstm.selerr = (unsigned short)1;
      sqlstm.cud = sqlcud0;
      sqlstm.sqlest = (unsigned char  *)&sqlca;
      sqlstm.sqlety = (unsigned short)4352;
      sqlstm.occurs = (unsigned int  )0;
      sqlstm.sqcmod = (unsigned int )0;
      sqlstm.sqhstv[0] = (         void  *)&d_master_code;
      sqlstm.sqhstl[0] = (unsigned int  )44;
      sqlstm.sqhsts[0] = (         int  )0;
      sqlstm.sqindv[0] = (         void  *)0;
      sqlstm.sqinds[0] = (         int  )0;
      sqlstm.sqharm[0] = (unsigned int  )0;
      sqlstm.sqadto[0] = (unsigned short )0;
      sqlstm.sqtdso[0] = (unsigned short )0;
      sqlstm.sqphsv = sqlstm.sqhstv;
      sqlstm.sqphsl = sqlstm.sqhstl;
      sqlstm.sqphss = sqlstm.sqhsts;
      sqlstm.sqpind = sqlstm.sqindv;
      sqlstm.sqpins = sqlstm.sqinds;
      sqlstm.sqparm = sqlstm.sqharm;
      sqlstm.sqparc = sqlstm.sqharc;
      sqlstm.sqpadto = sqlstm.sqadto;
      sqlstm.sqptdso = sqlstm.sqtdso;
      sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	  if (OERROR) 
	    err_mesg("OPEN failed on cursor RD_EX_CUR",0,"");

	  /* EXEC SQL FETCH RD_EX_CUR 
	     	   INTO  :d_dummy; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2357;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqfoff = (           int )0;
   sqlstm.sqfmod = (unsigned int )2;
   sqlstm.sqhstv[0] = (         void  *)&d_dummy;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	  if (OERROR) 
	    err_mesg("FETCH failed on cursor RD_EX_CUR",0,"");

	  if (sqlca.sqlcode EQ 0)
	    {
	       log_messg("RD0249","RD_EXAMINATION");
	       continue; 
	    }


		/*******************************************************************/
		/*        If Master Code is not referenced in any table above      */
        /*******************************************************************/

		/* EXEC SQL DELETE RD_ORGAN_SITE
	   			  WHERE CURRENT OF RD_ORGAN_SITE_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from RD_ORGAN_SITE  where rowid = :x";
  sqlstm.iters = (unsigned int  )53;
  sqlstm.offset = (unsigned int  )2376;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

 

		if (OERROR)
			err_mesg("DELETE failed on table RD_ORGAN_SITE",0,"");

		if (sqlca.sqlcode EQ 0)
			log_messg("RD0250"," ");

	} /* end of while  */

    /* EXEC SQL CLOSE RD_ORGAN_SITE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2391;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	/* EXEC SQL CLOSE RD_EX_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2406;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


  
}

fetch_organ_site()
{
	can_delete = TRUE;

    /* EXEC SQL FETCH RD_ORGAN_SITE_CUR
			  INTO  :d_master_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2421;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_master_code;
    sqlstm.sqhstl[0] = (unsigned int  )44;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR) 
		err_mesg("FETCH failed on cursor RD_ORGAN_SITE_CUR",0,"");

	if (NO_DATA_FOUND) 
		return 0;

	d_master_code.arr[d_master_code.len] = '\0';

    if (DEBUG) {
		sprintf(string_var, "Organ Site = %s\n",d_master_code.arr);
		disp_message(ERR_MESG, string_var); }
       
	return 1;
}

/**********************End of organ sites Purging*******************/

/**********************purging for Transport Modes**************/
purge_trans_mode_code ()
{
	/* EXEC SQL LOCK TABLE RD_TRANSPORT_MODE
               IN EXCLUSIVE MODE NOWAIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "lock TABLE RD_TRANSPORT_MODE IN EXCLUSIVE MODE NOWAIT";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2440;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (RESOURCE_BUSY)
		err_mesg("TABLE cannot be locked in exclusive mode",0,"");
	else
		if (OERROR)
			err_mesg("LOCK failed on table RD_TRANSPORT_MODE",0,"");

	/* EXEC SQL DECLARE RD_TRANSPORT_MODE_CUR CURSOR FOR 
			 SELECT  TRANS_MODE_CODE
			 FROM    RD_TRANSPORT_MODE
			 WHERE   STATUS  = 'S' 
			 FOR     UPDATE  OF STATUS; */ 


	/* EXEC SQL DECLARE RD_AP_CUR CURSOR FOR 
             SELECT  'X'
			 FROM    RD_APPT
			 WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 AND	 TRANSPORT_MODE = :d_master_code; */ 


    /* EXEC SQL DECLARE RD_AP_DT_CUR CURSOR FOR 
             SELECT  'X'
			 FROM    RD_APPT_DEL_TR
			 WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 AND	 TRANSPORT_MODE = :d_master_code; */ 


	/* EXEC SQL OPEN RD_TRANSPORT_MODE_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0057;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2455;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR)
		err_mesg("OPEN failed on cursor RD_TRANSPORT_MODE_CUR",0,"");
	
	while (fetch_trans_mode_code())
    {
   		/* EXEC SQL OPEN RD_AP_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0058;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )2470;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_master_code;
     sqlstm.sqhstl[1] = (unsigned int  )44;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_AP_CUR",0,"");

		/* EXEC SQL FETCH RD_AP_CUR 
	     		 INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2493;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_AP_CUR",0,"");

		if (sqlca.sqlcode EQ 0){
	       log_messg("RD0249","RD_APPT");
	       continue; 
		}

		/* EXEC SQL OPEN RD_AP_DT_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0059;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2512;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_master_code;
  sqlstm.sqhstl[1] = (unsigned int  )44;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_AP_DT_CUR",0,"");

		/* EXEC SQL FETCH RD_AP_DT_CUR 
				 INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2535;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_AP_DT_CUR",0,"");

		if (sqlca.sqlcode EQ 0) {
			log_messg("RD0249","RD_APPT_DEL_TR");
			continue; 
		}  
		
		/*******************************************************************/
		/*        If Master Code is not referenced in any table above      */
		/*******************************************************************/

		/* EXEC SQL DELETE RD_TRANSPORT_MODE
				 WHERE  CURRENT OF RD_TRANSPORT_MODE_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from RD_TRANSPORT_MODE  where rowid = :x";
  sqlstm.iters = (unsigned int  )57;
  sqlstm.offset = (unsigned int  )2554;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

 

		if (OERROR)
			err_mesg("DELETE failed on table RD_TRANSPORT_MODE",0,"");

		if (sqlca.sqlcode EQ 0)
			log_messg("RD0250"," ");
	} /* end of while  */
    /* EXEC SQL CLOSE RD_TRANSPORT_MODE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2569;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RD_AP_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2584;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	/* EXEC SQL CLOSE RD_AP_DT_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2599;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

fetch_trans_mode_code()
{
	can_delete = TRUE;
	/* EXEC SQL FETCH RD_TRANSPORT_MODE_CUR
			 INTO  :d_master_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2614;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_master_code;
 sqlstm.sqhstl[0] = (unsigned int  )44;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR) 
		err_mesg("FETCH failed on cursor RD_TRANSPORT_MODE_CUR",0,"");

	if (NO_DATA_FOUND) 
		return 0;

	d_master_code.arr[d_master_code.len] = '\0';

    if (DEBUG) {
		sprintf(string_var, "Taransport Mode = %s\n",d_master_code.arr);
		disp_message(ERR_MESG, string_var); }
     return 1;
}

/**********************End of Transport Mode Purging*******************/

/**********************purging For Reported****************/
/*purge_reporter()
{

     EXEC SQL LOCK TABLE RD_REPORTED
              IN EXCLUSIVE MODE NOWAIT;

     if (RESOURCE_BUSY)
       err_mesg("TABLE cannot be locked in exclusive mode",0,"");
     else
       if (OERROR)
         err_mesg("LOCK failed on table RD_REPORTED",0,"");

     EXEC SQL DECLARE RD_REPORTED_CUR CURSOR FOR 
               SELECT REPORT_ID
	             FROM RD_REPORTED
	            WHERE STATUS  = 'S' 
	              FOR UPDATE  OF STATUS;

     
      EXEC SQL DECLARE RD_EXAM_VIEW_REPORT_CUR CURSOR FOR 
              SELECT  'X'
	      FROM    RD_EXAM_VIEW_REQUESTED
	      WHERE   REPORTER_ID = :d_master_code;
	      

     EXEC SQL OPEN RD_REPORTED_CUR;

     if (OERROR)
       err_mesg("OPEN failed on cursor RD_REPORTED_CUR",0,"");

    while (fetch_reporter())
	{
   		  EXEC SQL OPEN RD_EXAM_VIEW_REPORT_CUR;

		  if (OERROR) 
			err_mesg("OPEN failed on cursor RD_EXAM_VIEW_REPORT_CUR",0,"");

		  EXEC SQL FETCH RD_EXAM_VIEW_REPORT_CUR
	     		   INTO  :d_dummy;

		  if (OERROR) 
			err_mesg("FETCH failed on cursor RD_EXAM_VIEW_REPORT_CUR",0,"");

		  if (sqlca.sqlcode EQ 0)
			{
			   log_messg("RD0249","RD_EXAM_VIEW_REQUESTED");
			   continue; 
			}
	
		//******************************************************************
		//        If Master Code is not referenced in any table above      *
        //******************************************************************

		EXEC SQL DELETE RD_REPORTED
	   			 WHERE  CURRENT OF RD_REPORTED_CUR; 

		if (OERROR)
	    err_mesg("DELETE failed on table RD_REPORTED",0,"");

		if (sqlca.sqlcode EQ 0)
		log_messg("RD0250"," ");

	}  //end of while  
	EXEC SQL CLOSE RD_REPORTED_CUR;
    EXEC SQL CLOSE RD_EXAM_VIEW_REPORT_CUR;
}
fetch_reporter()
{
	can_delete = TRUE;

    EXEC SQL FETCH RD_REPORTED_CUR
			 INTO  :d_master_code;
	if (OERROR) 
		err_mesg("FETCH failed on cursor RD_REPORTED_CUR",0,"");
	if (NO_DATA_FOUND) 
		return 0;
	d_master_code.arr[d_master_code.len] = '\0';

    if (DEBUG) {
		sprintf(string_var, "Report Id  = %s\n",d_master_code.arr);
		disp_message(ERR_MESG, string_var); }
	return 1;
}*/

/**********************End of View Purging*******************/

/**********************purging For Radiologist****************/
/*purge_radiologist()
 {

     EXEC SQL LOCK TABLE RD_RADIOLOGIST
              IN EXCLUSIVE MODE NOWAIT;

     if (RESOURCE_BUSY)
       err_mesg("TABLE cannot be locked in exclusive mode",0,"");
     else
       if (OERROR)
         err_mesg("LOCK failed on table RD_RADIOLOGIST",0,"");

     EXEC SQL DECLARE RD_RADIOLOGIST_CUR CURSOR FOR 
              SELECT  RADIOLOGIST_ID
	      FROM    RD_RADIOLOGIST
	      WHERE   STATUS  = 'S' 
	      FOR     UPDATE  OF STATUS;

     
      EXEC SQL DECLARE RD_EXAM_VIEW_REQUESTED_CUR CURSOR FOR 
              SELECT  'X'
	      FROM    RD_EXAM_VIEW_REQUESTED
	      WHERE   RADIOLOGIST_ID = :d_master_code;
	      

     EXEC SQL OPEN RD_RADIOLOGIST_CUR;

     if (OERROR)
       err_mesg("OPEN failed on cursor RD_RADIOLOGIST_CUR",0,"");

     while (fetch_radiologist())
       {
   	  EXEC SQL OPEN RD_EXAM_VIEW_REQUESTED_CUR;

	  if (OERROR) 
	    err_mesg("OPEN failed on cursor RD_EXAM_VIEW_REQUESTED_CUR",0,"");

	  EXEC SQL FETCH RD_EXAM_VIEW_REQUESTED_CUR
	     	   INTO  :d_dummy;

	  if (OERROR) 
	    err_mesg("FETCH failed on cursor RD_EXAM_VIEW_REQUESTED_CUR",0,"");

	  if (sqlca.sqlcode EQ 0)
	    {
	       log_messg("RD0249","RD_EXAM_VIEW_REQUESTED");
	       continue; 
	    }

	  //*******************************************************************
	  //*        If Master Code is not referenced in any table above      *
	  //*******************************************************************


	  EXEC SQL DELETE RD_RADIOLOGIST
	   	   WHERE CURRENT OF RD_RADIOLOGIST_CUR; 

	  if (OERROR)
	    err_mesg("DELETE failed on table RD_RADIOLOGIST",0,"");

	  if (sqlca.sqlcode EQ 0)
	    log_messg("RD0250"," ");

       } // end of while

     EXEC SQL CLOSE RD_RADIOLOGIST_CUR;
     EXEC SQL CLOSE RD_EXAM_VIEW_REQUESTED_CUR;
     
}

fetch_radiologist()
{
     can_delete = TRUE;

     EXEC SQL FETCH RD_RADIOLOGIST_CUR
	      INTO  :d_master_code;

     if (OERROR) 
       err_mesg("FETCH failed on cursor RD_RADIOLOGIST_CUR",0,"");

     if (NO_DATA_FOUND) 
       return 0;

     d_master_code.arr[d_master_code.len] = '\0';

     if (DEBUG) {
       sprintf(string_var, "Radiologist Id  = %s\n",d_master_code.arr);
       disp_message(ERR_MESG, string_var); }
       
     return 1;
}*/
/**********************End of Radiologist Purging************/

/************************Purging For Technician****************/
/*purge_technician()
{

     EXEC SQL LOCK TABLE RD_TECHNICIAN
              IN EXCLUSIVE MODE NOWAIT;

     if (RESOURCE_BUSY)
       err_mesg("TABLE cannot be locked in exclusive mode",0,"");
     else
       if (OERROR)
         err_mesg("LOCK failed on table RD_TECHNICIAN",0,"");

     EXEC SQL DECLARE RD_TECHNICIAN_CUR CURSOR FOR 
              SELECT  TECHNICIAN_ID
	      FROM    RD_TECHNICIAN
	      WHERE   STATUS  = 'S' 
	      FOR     UPDATE  OF STATUS;

     
      EXEC SQL DECLARE RD_EXAM_VIEW_REQUESTED_CUR1 CURSOR FOR 
              SELECT  'X'
	      FROM    RD_EXAM_VIEW_REQUESTED
	      WHERE   TECHNICIAN_ID = :d_master_code
	      OR      TECHNICIAN_ID2 = :d_master_code
	      OR      TECHNICIAN_ID3 = :d_master_code;
		  

     EXEC SQL OPEN RD_TECHNICIAN_CUR;

     if (OERROR)
       err_mesg("OPEN failed on cursor RD_TECHNICIAN_CUR",0,"");

     while (fetch_technician())
       {
   	  EXEC SQL OPEN RD_EXAM_VIEW_REQUESTED_CUR1;

	  if (OERROR) 
	    err_mesg("OPEN failed on cursor RD_EXAM_VIEW_REQUESTED_CUR1",0,"");

	  EXEC SQL FETCH RD_EXAM_VIEW_REQUESTED_CUR1
	     	   INTO  :d_dummy;

	  if (OERROR) 
	    err_mesg("FETCH failed on cursor RD_EXAM_VIEW_REQUESTED_CUR1",0,"");

	  if (sqlca.sqlcode EQ 0)
	    {
	       log_messg("RD0249","RD_EXAM_VIEW_REQUESTED");
	       continue; 
	    }

		//*****************************************************************
		//        If Master Code is not referenced in any table above      
		//*****************************************************************

		EXEC SQL DELETE RD_TECHNICIAN
	   	   WHERE CURRENT OF RD_TECHNICIAN_CUR; 

	  if (OERROR)
	    err_mesg("DELETE failed on table RD_TECHNICIAN",0,"");

	  if (sqlca.sqlcode EQ 0)
	    log_messg("RD0250"," ");

       } // end of while

     EXEC SQL CLOSE RD_TECHNICIAN_CUR;
     EXEC SQL CLOSE RD_EXAM_VIEW_REQUESTED_CUR1;
}

fetch_technician()
{
     can_delete = TRUE;

     EXEC SQL FETCH RD_TECHNICIAN_CUR
	      INTO  :d_master_code;

     if (OERROR) 
       err_mesg("FETCH failed on cursor RD_TECHNICIAN_CUR",0,"");

     if (NO_DATA_FOUND) 
       return 0;

     d_master_code.arr[d_master_code.len] = '\0';

     if (DEBUG)  {
       sprintf(string_var, "Technician Id  = %s\n",d_master_code.arr);
       disp_message(ERR_MESG, string_var); }
       
     return 1;
}*/
/************************END OF TECHNICIAN PURGING***********************/

/********************Purging for Records Media Type*********************/
purge_records_media()
{

	/* EXEC SQL LOCK TABLE RD_RECORDS_MEDIA
			   IN EXCLUSIVE MODE NOWAIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "lock TABLE RD_RECORDS_MEDIA IN EXCLUSIVE MODE NOWAIT";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2633;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (RESOURCE_BUSY)
		err_mesg("TABLE cannot be locked in exclusive mode",0,"");
	else
		if (OERROR)
			err_mesg("LOCK failed on table RD_RECORDS_MEDIA",0,"");

	/* EXEC SQL DECLARE RD_RECORDS_MEDIA_TYPE_CUR CURSOR FOR 
			 SELECT  MEDIA_TYPE_CODE
			 FROM    RD_RECORDS_MEDIA
			 WHERE   STATUS  = 'S' 
			 FOR     UPDATE  OF STATUS; */ 


	/* EXEC SQL DECLARE RD_DEF_STORAGE_LOCN_CUR CURSOR FOR 
             SELECT  'X'
			 FROM    RD_DEF_STORAGE_LOCN
			 WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 AND     MEDIA_TYPE_CODE = :d_master_code; */ 


    /* EXEC SQL DECLARE RD_EXAM_CUR CURSOR FOR 
             SELECT  'X'
			 FROM    RD_EXAMINATION
			 WHERE   MEDIA_TYPE_CODE = :d_master_code; */ 


    /* EXEC SQL DECLARE RD_EXAM_VIEW_REQ_CUR CURSOR FOR 
             SELECT  'X'
			 FROM    RD_EXAM_VIEW_REQUESTED
			 WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 AND     MEDIA_TYPE_CODE = :d_master_code; */ 

  
    /*EXEC SQL DECLARE RD_RECORDS_IND_1_CUR CURSOR FOR 
             SELECT  'X'
			 FROM    RD_RECORDS_INDEX
			 WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 AND     MEDIA_TYPE_CODE = :d_master_code;	 */ //rvN on 22nd Dec 2003
    
    /* EXEC SQL OPEN RD_RECORDS_MEDIA_TYPE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0062;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2648;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
      err_mesg("OPEN failed on cursor RD_RECORDS_MEDIA_TYPE_CUR",0,"");

	while (fetch_records_media())
	{
   		/* EXEC SQL OPEN RD_DEF_STORAGE_LOCN_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0063;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )2663;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_master_code;
     sqlstm.sqhstl[1] = (unsigned int  )44;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_DEF_STORAGE_LOCN_CUR",0,"");
		
		/* EXEC SQL FETCH RD_DEF_STORAGE_LOCN_CUR
				 INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2686;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_DEF_STORAGE_LOCN_CUR",0,"");
		if (sqlca.sqlcode EQ 0) {
			log_messg("RD0249","RD_DEF_STORAGE_LOCN");
			continue; 
	    }
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		/* EXEC SQL OPEN RD_EXAM_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0064;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )2705;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&d_master_code;
     sqlstm.sqhstl[0] = (unsigned int  )44;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_EXAM_CUR",0,"");

		/* EXEC SQL FETCH RD_EXAM_CUR
				 INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2724;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_EXAM_CUR",0,"");
		if (sqlca.sqlcode EQ 0) {
			log_messg("RD0249","RD_EXAMINATION");
			continue; 
		}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		/* EXEC SQL OPEN RD_EXAM_VIEW_REQ_CUR; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0065;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )2743;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_master_code;
     sqlstm.sqhstl[1] = (unsigned int  )44;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_EXAM_VIEW_REQ_CUR",0,"");
		
		/* EXEC SQL FETCH RD_EXAM_VIEW_REQ_CUR
				 INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2766;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_EXAM_VIEW_REQ_CUR",0,"");
		if (sqlca.sqlcode EQ 0) {
			log_messg("RD0249","RD_EXAM_VIEW_REQUESTED");
			continue; 
		}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

		//EXEC SQL OPEN RD_RECORDS_IND_1_CUR;
		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_RECORDS_IND_1_CUR",0,"");

		//EXEC SQL FETCH RD_RECORDS_IND_1_CUR 
				 INTO  :d_dummy;
		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_RECORDS_IND_1_CUR",0,"");
		if (sqlca.sqlcode EQ 0) {
			log_messg("RD0249","RD_RECORDS_INDEX");
			continue; 
		}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		
		/*******************************************************************/
		/*        If Master Code is not referenced in any table above      */
		/*******************************************************************/

		/* EXEC SQL DELETE RD_RECORDS_MEDIA
	   			 WHERE CURRENT OF RD_RECORDS_MEDIA_TYPE_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from RD_RECORDS_MEDIA  where rowid = :x";
  sqlstm.iters = (unsigned int  )62;
  sqlstm.offset = (unsigned int  )2785;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

 
		if (OERROR)
			err_mesg("DELETE failed on table RD_RECORDS_MEDIA",0,"");
		if (sqlca.sqlcode EQ 0)
			log_messg("RD0250"," ");
	} /* end of while  */

    /* EXEC SQL CLOSE RD_RECORDS_MEDIA_TYPE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2800;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	/* EXEC SQL CLOSE RD_DEF_STORAGE_LOCN_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2815;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	/* EXEC SQL CLOSE RD_EXAM_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2830;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RD_EXAM_VIEW_REQ_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2845;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	//EXEC SQL CLOSE RD_RECORDS_IND_1_CUR;
}

fetch_records_media()
{
	can_delete = TRUE;

    /* EXEC SQL FETCH RD_RECORDS_MEDIA_TYPE_CUR
             INTO  :d_master_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2860;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_master_code;
    sqlstm.sqhstl[0] = (unsigned int  )44;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR) 
		err_mesg("FETCH failed on cursor RD_RECORDS_MEDIA_TYPE_CUR",0,"");
	if (NO_DATA_FOUND) 
		return 0;
	d_master_code.arr[d_master_code.len] = '\0';

    if (DEBUG) {
		sprintf(string_var, "Media Type Code = %s\n",d_master_code.arr);
		disp_message(ERR_MESG, string_var); }
	return 1;
}
/*********************End of Record Media Type Purging*****************/

/********************Purging for Records Stoarage Location*************/
purge_records_store()
{

     /* EXEC SQL LOCK TABLE RD_RECORDS_STORE
              IN EXCLUSIVE MODE NOWAIT; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "lock TABLE RD_RECORDS_STORE IN EXCLUSIVE MODE NOWAIT";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )2879;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



     if (RESOURCE_BUSY)
       err_mesg("TABLE cannot be locked in exclusive mode",0,"");
     else
       if (OERROR)
         err_mesg("LOCK failed on table RD_RECORDS_STORE",0,"");

	/* EXEC SQL DECLARE RD_RECORDS_STORE_CUR CURSOR FOR 
             SELECT  STORAGE_LOCN_CODE
			 FROM    RD_RECORDS_STORE
			 WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 AND     STATUS  = 'S' 
			 FOR     UPDATE  OF STATUS; */ 


    /* EXEC SQL DECLARE RD_DEF_STORAGE_LOCN_CUR1 CURSOR FOR 
             SELECT  'X'
			 FROM     RD_DEF_STORAGE_LOCN
			 WHERE    OPERATING_FACILITY_ID = :d_facility_id
			 AND      DEF_STORAGE_LOCN_CODE = :d_master_code; */ 


	/* EXEC SQL DECLARE RD_EXAM_VIEW_REQ_CUR1 CURSOR FOR 
             SELECT  'X'
			 FROM     RD_EXAM_VIEW_REQUESTED
			 WHERE    OPERATING_FACILITY_ID = :d_facility_id
			 AND      STORAGE_LOCN_CODE = :d_master_code; */ 


    /* EXEC SQL DECLARE RD_RECORDS_IND_1_CUR1 CURSOR FOR 
             SELECT  'X'
			 FROM    RD_RECORDS_INDEX
			 WHERE   FACILITY_ID = :d_facility_id
			 AND     STORAGE_LOCN_CODE = :d_master_code; */ 

	
	/* EXEC SQL OPEN RD_RECORDS_STORE_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0068;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2894;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR)
		err_mesg("OPEN failed on cursor RD_RECORDS_STORE_CUR",0,"");

	while (fetch_records_store())
	{
   		/* EXEC SQL OPEN RD_DEF_STORAGE_LOCN_CUR1; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0069;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )2913;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_master_code;
     sqlstm.sqhstl[1] = (unsigned int  )44;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_DEF_STORAGE_LOCN_CUR1",0,"");
		
		/* EXEC SQL FETCH RD_DEF_STORAGE_LOCN_CUR1
				 INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2936;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_DEF_STORAGE_LOCN_CUR1",0,"");
		if (sqlca.sqlcode EQ 0) {
			log_messg("RD0249","RD_DEF_STORAGE_LOCN");
			continue; 
		}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		/* EXEC SQL OPEN RD_EXAM_VIEW_REQ_CUR1; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 5;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = sq0070;
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )2955;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqcmod = (unsigned int )0;
     sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_master_code;
     sqlstm.sqhstl[1] = (unsigned int  )44;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_EXAM_VIEW_REQ_CUR1",0,"");

		/* EXEC SQL FETCH RD_EXAM_VIEW_REQ_CUR1
				 INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2978;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_EXAM_VIEW_REQ_CUR1",0,"");
		if (sqlca.sqlcode EQ 0) {
			log_messg("RD0249","RD_EXAM_VIEW_REQUESTED");
			continue; 
		}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
			
		/* EXEC SQL OPEN RD_RECORDS_IND_1_CUR1; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0071;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2997;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_master_code;
  sqlstm.sqhstl[1] = (unsigned int  )44;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_RECORDS_IND_1_CUR1",0,"");
		
		/* EXEC SQL FETCH RD_RECORDS_IND_1_CUR1 
				 INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3020;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_RECORDS_IND_1_CUR1",0,"");
		
		if (sqlca.sqlcode EQ 0) {
			log_messg("RD0249","RD_RECORDS_INDEX");
			continue; 
		}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		/*******************************************************************/
		/*        If Master Code is not referenced in any table above      */
		/*******************************************************************/

		/* EXEC SQL DELETE RD_RECORDS_STORE
				 WHERE CURRENT OF RD_RECORDS_STORE_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from RD_RECORDS_STORE  where rowid = :x";
  sqlstm.iters = (unsigned int  )68;
  sqlstm.offset = (unsigned int  )3039;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}

 
		if (OERROR)
			err_mesg("DELETE failed on table RD_RECORDS_MEDIA",0,"");
		if (sqlca.sqlcode EQ 0)
			log_messg("RD0250"," ");
	} /* end of while  */

    /* EXEC SQL CLOSE RD_RECORDS_MEDIA_TYPE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )3054;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	/* EXEC SQL CLOSE RD_DEF_STORAGE_LOCN_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3069;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	/* EXEC SQL CLOSE RD_EXAM_VIEW_REQ_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3084;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	//EXEC SQL CLOSE RD_RECORDS_IND_1_CUR;
}

fetch_records_store()
{
	can_delete = TRUE;

    /* EXEC SQL FETCH RD_RECORDS_STORE_CUR
			 INTO  :d_master_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )3099;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_master_code;
    sqlstm.sqhstl[0] = (unsigned int  )44;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR) 
		err_mesg("FETCH failed on cursor RD_RECORDS_STORE_CUR",0,"");
	if (NO_DATA_FOUND) 
		return 0;
	d_master_code.arr[d_master_code.len] = '\0';

    if (DEBUG) {
		sprintf(string_var, "Storage Location Code = %s\n",d_master_code.arr);
		disp_message(ERR_MESG, string_var); }

     return 1;
  }

/*********************End of Record storage Location Purging*****************/

/************************************Purging for Wings **********************/
purge_wing()
{

	/* EXEC SQL LOCK TABLE RD_WINGS
			 IN EXCLUSIVE MODE NOWAIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "lock TABLE RD_WINGS IN EXCLUSIVE MODE NOWAIT";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3118;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (RESOURCE_BUSY)
		err_mesg("TABLE cannot be locked in exclusive mode",0,"");
	else
		if (OERROR)
			err_mesg("LOCK failed on table RD_WINGS",0,"");

	/* EXEC SQL DECLARE RD_WING_CUR CURSOR FOR 
			 SELECT  WING_CODE
			 FROM    RD_WINGS
			 WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 AND     STATUS  = 'S' 
			 FOR     UPDATE  OF STATUS; */ 


	/*EXEC SQL DECLARE RD_PARAM_1_CUR CURSOR FOR 
			   SELECT  'X'
			   FROM    RD_PARAM
			   WHERE   WING_CODE = :d_master_code;*/ //commented by rvN on 09/10/2003 wing_code not available

	/* EXEC SQL DECLARE RD_SECTION_CTL_1_CUR CURSOR FOR 
			 SELECT  'X'
			 FROM    RD_SECTION_CTL
			 WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 AND     WING_CODE = :d_master_code; */ 


    /* EXEC SQL DECLARE RD_WNG_DEF_STORAGE_LCN_1_CUR CURSOR FOR 
             SELECT  'X'
			 FROM    RD_DEF_STORAGE_LOCN
			 WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 AND     WING_CODE = :d_master_code; */ 


    /*EXEC SQL DECLARE RD_WING_RECORDS_INDEX_1_CUR CURSOR FOR 
             SELECT  'X'
			 FROM    RD_RECORDS_INDEX
			 WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 AND     WING_CODE = :d_master_code;	 */ //rvN on 22nd Dec 2003

    /* EXEC SQL DECLARE RD_WING_CLINIC_1_CUR CURSOR FOR 
             SELECT  'X'
	         FROM    RD_CLINIC
	         WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 AND     WING_CODE = :d_master_code; */ 


    /* EXEC SQL DECLARE RD_WING_REQUEST_1_CUR CURSOR FOR 
             SELECT  'X'
			 FROM    RD_REQUEST
			 WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 AND     WING_CODE = :d_master_code; */ 


	/* EXEC SQL OPEN RD_WING_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0074;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3133;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



    if (OERROR)
		err_mesg("OPEN failed on cursor RD_WING_CUR",0,"");

	while (fetch_wing())
	{
		/*EXEC SQL OPEN RD_PARAM_1_CUR;
		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_PARAM_1_CUR",0,"");
		EXEC SQL FETCH RD_PARAM_1_CUR 
			INTO  :d_dummy;
		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_PARAM_1_CUR",0,"");
		if (sqlca.sqlcode EQ 0)
	    {
			log_messg("RD0249","RD_PARAM");
			continue; 
	    }*/

		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		/* EXEC SQL OPEN RD_WNG_DEF_STORAGE_LCN_1_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0076;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3152;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_master_code;
  sqlstm.sqhstl[1] = (unsigned int  )44;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_WNG_DEF_STORAGE_LCN_1_CUR",0,"");

		/* EXEC SQL FETCH RD_WNG_DEF_STORAGE_LCN_1_CUR 
	    		   INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3175;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_WNG_DEF_STORAGE_LCN_1_CUR",0,"");

		if (sqlca.sqlcode EQ 0)
			{
			   log_messg("RD0249","RD_DEF_STORAGE_LOCN");
			   continue; 
			}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		  /* EXEC SQL OPEN RD_WING_REQUEST_1_CUR; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 12;
       sqlstm.arrsiz = 5;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = sq0078;
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )3194;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)4352;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqcmod = (unsigned int )0;
       sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
       sqlstm.sqhstl[0] = (unsigned int  )5;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&d_master_code;
       sqlstm.sqhstl[1] = (unsigned int  )44;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqphsv = sqlstm.sqhstv;
       sqlstm.sqphsl = sqlstm.sqhstl;
       sqlstm.sqphss = sqlstm.sqhsts;
       sqlstm.sqpind = sqlstm.sqindv;
       sqlstm.sqpins = sqlstm.sqinds;
       sqlstm.sqparm = sqlstm.sqharm;
       sqlstm.sqparc = sqlstm.sqharc;
       sqlstm.sqpadto = sqlstm.sqadto;
       sqlstm.sqptdso = sqlstm.sqtdso;
       sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		  if (OERROR) 
			err_mesg("OPEN failed on cursor RD_WING_REQUEST_1_CUR",0,"");

		  /* EXEC SQL FETCH RD_WING_REQUEST_1_CUR 
	     		   INTO  :d_dummy; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )3217;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_dummy;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		  if (OERROR) 
			err_mesg("FETCH failed on cursor RD_WING_REQUEST_1_CUR",0,"");

		  if (sqlca.sqlcode EQ 0)
			{
			   log_messg("RD0249","RD_REQUEST");
			   continue; 
			}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		  /*EXEC SQL OPEN RD_WING_RECORDS_INDEX_1_CUR;

		  if (OERROR) 
			err_mesg("OPEN failed on cursor RD_WING_RECORDS_INDEX_1_CUR",0,"");

		  EXEC SQL FETCH RD_WING_RECORDS_INDEX_1_CUR 
	     		   INTO  :d_dummy;

		  if (OERROR) 
			err_mesg("FETCH failed on cursor RD_WING_RECORDS_INDEX_1_CUR",0,"");

		  if (sqlca.sqlcode EQ 0)
			{
			   log_messg("RD0249","RD_RECORDS_INDEX");
			   continue; 
			}	 */ //rvN on 22nd Dec 2003
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

		  /* EXEC SQL OPEN RD_SECTION_CTL_1_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0075;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )3236;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[0] = (unsigned int  )5;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_master_code;
    sqlstm.sqhstl[1] = (unsigned int  )44;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		  if (OERROR) 
			err_mesg("OPEN failed on cursor RD_SECTION_CTL_1_CUR",0,"");

		  /* EXEC SQL FETCH RD_SECTION_CTL_1_CUR 
	     		   INTO  :d_dummy; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )3259;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqfoff = (           int )0;
    sqlstm.sqfmod = (unsigned int )2;
    sqlstm.sqhstv[0] = (         void  *)&d_dummy;
    sqlstm.sqhstl[0] = (unsigned int  )4;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		  if (OERROR) 
			err_mesg("FETCH failed on cursor RD_SECTION_CTL_1_CUR",0,"");

		  if (sqlca.sqlcode EQ 0)
			{
			   log_messg("RD0249","RD_SECTION_CTL");
			   continue; 
			}
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

		/* EXEC SQL OPEN RD_WING_CLINIC_1_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0077;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3278;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_master_code;
  sqlstm.sqhstl[1] = (unsigned int  )44;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_WING_CLINIC_1_CUR",0,"");
	  
		/* EXEC SQL FETCH RD_WING_CLINIC_1_CUR 
	     	     INTO  :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3301;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_WING_CLINIC_1_CUR",0,"");
		if (sqlca.sqlcode EQ 0) {
			log_messg("RD0249","RD_CLINIC");
			continue; 
	    }
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

   		/*******************************************************************/
		/*        If Master Code is not referenced in any table above      */
        /*******************************************************************/

 		/* EXEC SQL DELETE RD_WINGS
	   			 WHERE CURRENT OF RD_WING_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from RD_WINGS  where rowid = :x";
   sqlstm.iters = (unsigned int  )74;
   sqlstm.offset = (unsigned int  )3320;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR)
			err_mesg("DELETE failed on table RD_WINGS",0,"");

		if (sqlca.sqlcode EQ 0)
			log_messg("RD0250"," ");

		/* EXEC SQL DELETE RD_SECTION_CTL
		   WHERE SECTION_CODE = :d_master_code ;

		if (OERROR)
			err_mesg("DELETE failed on table RD_SECTION_CTL",0,"");
		if (sqlca.sqlcode EQ 0)
	    log_messg("RD0250"," ");*/

	} /* end of while  */

    /* EXEC SQL CLOSE RD_WING_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )3335;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RD_DEF_STORAGE_LOCN_1_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )3350;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RD_REQUEST_1_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )3365;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    //EXEC SQL CLOSE RD_RECORDS_INDEX_1_CUR;
    /* EXEC SQL CLOSE RD_CLINIC_1_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )3380;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    /* EXEC SQL CLOSE RD_SECTION_CTL_1_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )3395;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	//EXEC SQL CLOSE RD_PARAM_1_CUR;
     
}

fetch_wing()
{
	can_delete = TRUE;
	/* EXEC SQL FETCH RD_WING_CUR
              INTO :d_master_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3410;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_master_code;
 sqlstm.sqhstl[0] = (unsigned int  )44;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR) 
		err_mesg("FETCH failed on cursor RD_WING_CUR",0,"");
	
	if (NO_DATA_FOUND) 
		return 0;

	d_master_code.arr[d_master_code.len] = '\0';
	
	if (DEBUG) {
		sprintf(string_var, "Wing Code = %s\n",d_master_code.arr);
		disp_message(ERR_MESG, string_var); }
	return 1;
}
/***************************** End of Wings ******************************/

/************************************Purging for Admin Reaction **********************/
purge_admin_reaction()
{
	/* EXEC SQL LOCK TABLE RD_ADMIN_REACTION
			 IN EXCLUSIVE MODE NOWAIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "lock TABLE RD_ADMIN_REACTION IN EXCLUSIVE MODE NOWAIT";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3429;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (RESOURCE_BUSY)
		err_mesg("TABLE cannot be locked in exclusive mode",0,"");
	else
		if (OERROR)
			err_mesg("LOCK failed on table RD_ADMIN_REACTION",0,"");

	/* EXEC SQL DECLARE RD_ADMIN_REACTION_CUR CURSOR FOR 
			 SELECT  ADMIN_REACTION_CODE
			 FROM    RD_ADMIN_REACTION
			 WHERE   STATUS  = 'S' 
			 FOR     UPDATE  OF STATUS; */ 


	/* EXEC SQL DECLARE RD_ADMIN_REACTION_ITEMS_CUR CURSOR FOR 
			 SELECT  'X'
		         FROM    RD_ITEMS_CONSUMED
			 WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 AND     ADMIN_REACTION_CODE = :d_master_code; */ 

	/* EXEC SQL OPEN RD_ADMIN_REACTION_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0081;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3444;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR)
		err_mesg("OPEN failed on cursor ADMIN_REACTION_CUR",0,"");

	while (fetch_admin_reaction())
	{
		/* EXEC SQL OPEN RD_ADMIN_REACTION_ITEMS_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0082;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3459;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_master_code;
  sqlstm.sqhstl[1] = (unsigned int  )44;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_ADMIN_REACTION_ITEMS_CUR",0,"");

		/* EXEC SQL FETCH RD_ADMIN_REACTION_ITEMS_CUR 
	    		  INTO :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3482;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_ADMIN_REACTION_ITEMS_CUR",0,"");
		if (sqlca.sqlcode EQ 0)
		{
		   log_messg("RD0249","RD_ITEMS_CONSUMED");
		   continue; 
		}
   		/*******************************************************************/
		/*        If Master Code is not referenced in any table above      */
	        /*******************************************************************/
 		/* EXEC SQL DELETE RD_ADMIN_REACTION
	   		  WHERE CURRENT OF RD_ADMIN_REACTION_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from RD_ADMIN_REACTION  where rowid = :x";
   sqlstm.iters = (unsigned int  )81;
   sqlstm.offset = (unsigned int  )3501;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR)
			err_mesg("DELETE failed on table RD_ADMIN_REACTION",0,"");
		if (sqlca.sqlcode EQ 0)
			log_messg("RD0250"," ");

	} /* end of while  */

    /* EXEC SQL CLOSE RD_ADMIN_REACTION_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )3516;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	/* EXEC SQL CLOSE RD_ADMIN_REACTION_ITEMS_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3531;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

fetch_admin_reaction()
{
	can_delete = TRUE;
	/* EXEC SQL FETCH RD_ADMIN_REACTION_CUR
                  INTO :d_master_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3546;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_master_code;
 sqlstm.sqhstl[0] = (unsigned int  )44;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR) 
		err_mesg("FETCH failed on cursor RD_ADMIN_REACTION_CUR",0,"");
	if (NO_DATA_FOUND) 
		return 0;
	d_master_code.arr[d_master_code.len] = '\0';
	
	if (DEBUG) {
		sprintf(string_var, "Admin Reaction Code = %s\n",d_master_code.arr);
		disp_message(ERR_MESG, string_var); }
	return 1;
}
/***************************** End of Admin Reaction ************************/

/***************************** Purging for Admin Route **********************/
purge_admin_route()
{
	/* EXEC SQL LOCK TABLE RD_ADMIN_ROUTE
			 IN EXCLUSIVE MODE NOWAIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "lock TABLE RD_ADMIN_ROUTE IN EXCLUSIVE MODE NOWAIT";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3565;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (RESOURCE_BUSY)
		err_mesg("TABLE cannot be locked in exclusive mode",0,"");
	else
		if (OERROR)
			err_mesg("LOCK failed on table RD_ADMIN_ROUTE",0,"");

	/* EXEC SQL DECLARE RD_ADMIN_ROUTE_CUR CURSOR FOR 
			 SELECT  ADMIN_ROUTE_CODE
			 FROM    RD_ADMIN_ROUTE
			 WHERE   STATUS  = 'S' 
			 FOR     UPDATE  OF STATUS; */ 


	/* EXEC SQL DECLARE RD_ADMIN_ROUTE_ITEMS_CUR CURSOR FOR 
			 SELECT  'X'
		     FROM    RD_ITEMS_CONSUMED
			 WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 AND     ADMIN_ROUTE_CODE = :d_master_code; */ 


	/* EXEC SQL OPEN RD_ADMIN_ROUTE_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0085;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3580;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR)
		err_mesg("OPEN failed on cursor ADMIN_ROUTE_CUR",0,"");

	while (fetch_admin_route())
	{
		/* EXEC SQL OPEN RD_ADMIN_ROUTE_ITEMS_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0086;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3595;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_master_code;
  sqlstm.sqhstl[1] = (unsigned int  )44;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_ADMIN_ROUTE_ITEMS_CUR",0,"");

		/* EXEC SQL FETCH RD_ADMIN_ROUTE_ITEMS_CUR 
	    		  INTO :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3618;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_ADMIN_ROUTE_ITEMS_CUR",0,"");

		if (sqlca.sqlcode EQ 0)
		{
		   log_messg("RD0249","RD_ITEMS_CONSUMED");
		   continue; 
		}
		
   		/*******************************************************************/
		/*        If Master Code is not referenced in any table above      */
		/*******************************************************************/

 		/* EXEC SQL DELETE RD_ADMIN_ROUTE
	   		  WHERE CURRENT OF RD_ADMIN_ROUTE_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from RD_ADMIN_ROUTE  where rowid = :x";
   sqlstm.iters = (unsigned int  )85;
   sqlstm.offset = (unsigned int  )3637;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR)
			err_mesg("DELETE failed on table RD_ADMIN_ROUTE",0,"");
		if (sqlca.sqlcode EQ 0)
			log_messg("RD0250"," ");

	} /* end of while  */

    /* EXEC SQL CLOSE RD_ADMIN_ROUTE_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )3652;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	/* EXEC SQL CLOSE RD_ADMIN_ROUTE_ITEMS_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3667;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


     
}

fetch_admin_route()
{
	can_delete = TRUE;
	/* EXEC SQL FETCH RD_ADMIN_ROUTE_CUR
              INTO :d_master_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3682;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_master_code;
 sqlstm.sqhstl[0] = (unsigned int  )44;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR) 
		err_mesg("FETCH failed on cursor RD_ADMIN_ROUTE_CUR",0,"");
	
	if (NO_DATA_FOUND) 
		return 0;

	d_master_code.arr[d_master_code.len] = '\0';
	
	if (DEBUG) {
		sprintf(string_var, "Admin Route Code = %s\n",d_master_code.arr);
		disp_message(ERR_MESG, string_var); }
	return 1;
}
/***************************** End of Admin Route ******************************/

/***************************** Purging for Item Class **************************/
purge_item_class()
{
	/* EXEC SQL LOCK TABLE RD_ITEM_CLASS
			 IN EXCLUSIVE MODE NOWAIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "lock TABLE RD_ITEM_CLASS IN EXCLUSIVE MODE NOWAIT";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3701;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (RESOURCE_BUSY)
		err_mesg("TABLE cannot be locked in exclusive mode",0,"");
	else
		if (OERROR)
			err_mesg("LOCK failed on table RD_ITEM_CLASS",0,"");

	/* EXEC SQL DECLARE ITEM_CLASS_CUR CURSOR FOR 
			 SELECT  ITEM_CLASS_CODE
			 FROM    RD_ITEM_CLASS
			 WHERE   STATUS  = 'S' 
			 FOR     UPDATE  OF STATUS; */ 

	/* EXEC SQL DECLARE ITEM_CLASS_ITEMS_CUR CURSOR FOR 
			 SELECT  'X'
		         FROM    RD_ITEMS
			 WHERE   ITEM_CLASS_CODE = :d_master_code; */ 


	/* EXEC SQL OPEN ITEM_CLASS_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0089;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3716;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR)
		err_mesg("OPEN failed on cursor ITEM_CLASS_CUR",0,"");

	while (fetch_item_class())
	{
		/* EXEC SQL OPEN ITEM_CLASS_ITEMS_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0090;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3731;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_master_code;
  sqlstm.sqhstl[0] = (unsigned int  )44;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor ITEM_CLASS_ITEMS",0,"");

		/* EXEC SQL FETCH ITEM_CLASS_ITEMS_CUR
	    		  INTO :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3750;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("FETCH failed on cursor ITEM_CLASS_ITEMS_CUR",0,"");
		if (sqlca.sqlcode EQ 0)
		{
		   log_messg("RD0249","RD_ITEMS_CONSUMED");
		   continue; 
		}
	/*******************************************************************/
	/*        If Master Code is not referenced in any table above      */
	/*******************************************************************/
		/* EXEC SQL DELETE RD_ITEM_CLASS
	   		  WHERE CURRENT OF ITEM_CLASS_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from RD_ITEM_CLASS  where rowid = :x";
  sqlstm.iters = (unsigned int  )89;
  sqlstm.offset = (unsigned int  )3769;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR)
			err_mesg("DELETE failed on table RD_ITEM_CLASS",0,"");
		if (sqlca.sqlcode EQ 0)
			log_messg("RD0250"," ");
	} /* end of while  */

    /* EXEC SQL CLOSE ITEM_CLASS_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )3784;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	/* EXEC SQL CLOSE ITEM_CLASS_ITEMS_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3799;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

fetch_item_class()
{
	can_delete = TRUE;
	/* EXEC SQL FETCH ITEM_CLASS_CUR
                  INTO :d_master_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3814;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_master_code;
 sqlstm.sqhstl[0] = (unsigned int  )44;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR) 
		err_mesg("FETCH failed on cursor ITEM_CLASS_CUR",0,"");
	if (NO_DATA_FOUND) 
		return 0;
	d_master_code.arr[d_master_code.len] = '\0';
	
	if (DEBUG) {
		sprintf(string_var, "Item Class Code = %s\n",d_master_code.arr);
		disp_message(ERR_MESG, string_var); }
	return 1;
}
/***************************** End of Item Class ******************************/

/********************************* Items ************************************/
purge_items()
{
	/* EXEC SQL LOCK TABLE RD_ITEMS
			 IN EXCLUSIVE MODE NOWAIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "lock TABLE RD_ITEMS IN EXCLUSIVE MODE NOWAIT";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3833;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (RESOURCE_BUSY)
		err_mesg("TABLE cannot be locked in exclusive mode",0,"");
	else
		if (OERROR)
			err_mesg("LOCK failed on table RD_ITEMS",0,"");

	/* EXEC SQL DECLARE RD_ITEMS_CUR CURSOR FOR 
			 SELECT  ITEM_CODE
			 FROM    RD_ITEMS
			 WHERE   STATUS  = 'S' 
			 FOR     UPDATE  OF STATUS; */ 


	/* EXEC SQL DECLARE RD_ITM_ITEMS_CONSUMED_CUR CURSOR FOR 
			 SELECT  'X'
		     FROM    RD_ITEMS_CONSUMED
			 WHERE   OPERATING_FACILITY_ID = :d_facility_id
			 AND     ITEM_CODE = :d_master_code; */ 


	/* EXEC SQL DECLARE RD_ITM_ITEMS_FOR_EXAM_CUR CURSOR FOR 
			 SELECT  'X'
		     FROM    RD_ITEMS_FOR_EXAM
			 WHERE   ITEM_CODE = :d_master_code; */ 


	/* EXEC SQL OPEN RD_ITEMS_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0093;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3848;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR)
		err_mesg("OPEN failed on cursor RD_ITEMS_CUR",0,"");

	while (fetch_items())
	{
		/* EXEC SQL OPEN RD_ITM_ITEMS_CONSUMED_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0094;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3863;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_master_code;
  sqlstm.sqhstl[1] = (unsigned int  )44;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_ITM_ITEMS_CONSUMED_CUR CURSOR",0,"");

		/* EXEC SQL FETCH RD_ITM_ITEMS_CONSUMED_CUR
	    		  INTO :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3886;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_ITM_ITEMS_CONSUMED_CUR CURSOR",0,"");
		if (sqlca.sqlcode EQ 0)
		{
		   log_messg("RD0249","RD_ITEMS_CONSUMED");
		   continue; 
		}
   		
		/* EXEC SQL OPEN RD_ITM_ITEMS_FOR_EXAM_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0095;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3905;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_master_code;
  sqlstm.sqhstl[0] = (unsigned int  )44;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_ITM_ITEMS_FOR_EXAM_CUR CURSOR",0,"");

		/* EXEC SQL FETCH RD_ITM_ITEMS_FOR_EXAM_CUR 
	    		  INTO :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3924;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_ITM_ITEMS_FOR_EXAM_CUR CURSOR",0,"");
		if (sqlca.sqlcode EQ 0)
		{
		   log_messg("RD0249","RD_ITEMS_FOR_EXAM");
		   continue; 
		}
		
		/*******************************************************************/
		/*        If Master Code is not referenced in any table above      */
		/*******************************************************************/
 		/* EXEC SQL DELETE RD_ITEMS
	   		  WHERE CURRENT OF RD_ITEMS_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from RD_ITEMS  where rowid = :x";
   sqlstm.iters = (unsigned int  )93;
   sqlstm.offset = (unsigned int  )3943;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR)
			err_mesg("DELETE failed on table RD_ITEMS",0,"");
		if (sqlca.sqlcode EQ 0)
			log_messg("RD0250"," ");

	} /* end of while  */

	/* EXEC SQL CLOSE RD_ITEMS_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3958;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

fetch_items()
{
	can_delete = TRUE;
	/* EXEC SQL FETCH RD_ITEMS_CUR
                  INTO :d_master_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3973;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_master_code;
 sqlstm.sqhstl[0] = (unsigned int  )44;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR) 
		err_mesg("FETCH failed on cursor RD_ITEMS_CUR",0,"");
	if (NO_DATA_FOUND) 
		return 0;
	d_master_code.arr[d_master_code.len] = '\0';
	
	if (DEBUG) {
		sprintf(string_var, "Items Code = %s\n",d_master_code.arr);
		disp_message(ERR_MESG, string_var); }
	return 1;
}
/*********************************** End of Items ************************************/

/***************************** Reason *****************************************/
purge_reason()
{
	/* EXEC SQL LOCK TABLE RD_REASONS
			 IN EXCLUSIVE MODE NOWAIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "lock TABLE RD_REASONS IN EXCLUSIVE MODE NOWAIT";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3992;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (RESOURCE_BUSY)
		err_mesg("TABLE cannot be locked in exclusive mode",0,"");
	else
		if (OERROR)
			err_mesg("LOCK failed on table RD_REASONS",0,"");

	/* EXEC SQL LOCK TABLE RD_REASON_ACTION_TYPE
			 IN EXCLUSIVE MODE NOWAIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "lock TABLE RD_REASON_ACTION_TYPE IN EXCLUSIVE MODE NOWAIT";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4007;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	
	if (RESOURCE_BUSY)
		err_mesg("TABLE cannot be locked in exclusive mode",0,"");
	else
		if (OERROR)
			err_mesg("LOCK failed on table RD_REASON_ACTION_TYPE",0,"");

	
	/* EXEC SQL DECLARE RD_REASONS_CUR CURSOR FOR 
			 SELECT  REASON_CODE
			 FROM    RD_REASONS
			 WHERE   STATUS  = 'S' 
			 FOR     UPDATE  OF STATUS; */ 


	/* EXEC SQL DECLARE RD_RSN_RCD_INDEX_MERGED_CUR CURSOR FOR 
			 SELECT  'X'
		     FROM    RD_RECORDS_INDEX_MERGED
			 WHERE   FACILITY_ID = :d_facility_id
			 AND     REASON_CODE = :d_master_code; */ 


	/* EXEC SQL DECLARE RD_RSN_REQUEST_QUEUE_CUR CURSOR FOR 
			 SELECT  'X'
		     FROM    RD_REQUEST_QUEUE
			 WHERE   PERFORMING_FACILITY_ID = :d_facility_id
			 AND     REASON_CODE = :d_master_code; */ 


	/* EXEC SQL OPEN RD_REASONS_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0099;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4022;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR)
		err_mesg("OPEN failed on cursor RD_REASONS_CUR",0,"");

	while (fetch_reason())
	{
		/* EXEC SQL OPEN RD_RSN_RCD_INDEX_MERGED_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0100;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4037;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_master_code;
  sqlstm.sqhstl[1] = (unsigned int  )44;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_RSN_RCD_INDEX_MERGED_CUR",0,"");

		/* EXEC SQL FETCH RD_RSN_RCD_INDEX_MERGED_CUR 
	    		  INTO :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4060;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_RSN_RCD_INDEX_MERGED_CUR",0,"");
		if (sqlca.sqlcode EQ 0)
		{
		   log_messg("RD0249","RD_RECORDS_INDEX_MERGED");
		   continue; 
		}
   		
		/* EXEC SQL OPEN RD_RSN_REQUEST_QUEUE_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0101;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4079;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
  sqlstm.sqhstl[0] = (unsigned int  )5;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_master_code;
  sqlstm.sqhstl[1] = (unsigned int  )44;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_RSN_REQUEST_QUEUE_CUR",0,"");

		/* EXEC SQL FETCH RD_RSN_REQUEST_QUEUE_CUR 
	    		  INTO :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4102;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_RSN_REQUEST_QUEUE_CUR",0,"");
		if (sqlca.sqlcode EQ 0)
		{
		   log_messg("RD0249","RD_REQUEST_QUEUE");
		   continue; 
		}
		
		/*******************************************************************/
		/*        If Master Code is not referenced in any table above      */
	    /*******************************************************************/
 		/* EXEC SQL DELETE RD_REASON_ACTION_TYPE
	   		  WHERE REASON_CODE = :d_master_code; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 12;
   sqlstm.arrsiz = 5;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from RD_REASON_ACTION_TYPE  where REASON_CODE=:b0";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )4121;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)4352;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_master_code;
   sqlstm.sqhstl[0] = (unsigned int  )44;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqphsv = sqlstm.sqhstv;
   sqlstm.sqphsl = sqlstm.sqhstl;
   sqlstm.sqphss = sqlstm.sqhsts;
   sqlstm.sqpind = sqlstm.sqindv;
   sqlstm.sqpins = sqlstm.sqinds;
   sqlstm.sqparm = sqlstm.sqharm;
   sqlstm.sqparc = sqlstm.sqharc;
   sqlstm.sqpadto = sqlstm.sqadto;
   sqlstm.sqptdso = sqlstm.sqtdso;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR)
			err_mesg("DELETE failed on table RD_REASON_ACTION_TYPE",0,"");
		if (sqlca.sqlcode EQ 0)
			log_messg("RD0250"," ");

		/* EXEC SQL DELETE RD_REASONS
	   		  WHERE CURRENT OF RD_REASONS_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from RD_REASONS  where rowid = :x";
  sqlstm.iters = (unsigned int  )99;
  sqlstm.offset = (unsigned int  )4140;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR)
			err_mesg("DELETE failed on table RD_REASON",0,"");
		if (sqlca.sqlcode EQ 0)
			log_messg("RD0250"," ");

		

	} /* end of while  */

    /* EXEC SQL CLOSE RD_REASONS_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )4155;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	/* EXEC SQL CLOSE RD_RSN_RCD_INDEX_MERGED_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4170;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	/* EXEC SQL CLOSE RD_RSN_REQUEST_QUEUE_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4185;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

fetch_reason()
{
	can_delete = TRUE;
	/* EXEC SQL FETCH RD_REASONS_CUR
              INTO :d_master_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4200;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_master_code;
 sqlstm.sqhstl[0] = (unsigned int  )44;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR) 
		err_mesg("FETCH failed on cursor RD_REASONS_CUR",0,"");
	if (NO_DATA_FOUND) 
		return 0;
	d_master_code.arr[d_master_code.len] = '\0';
	
	if (DEBUG) {
		sprintf(string_var, "Reason Code = %s\n",d_master_code.arr);
		disp_message(ERR_MESG, string_var); }
	return 1;
}
/***************************** End of Reson **************************/

/***************************** Exam Category *************************/
purge_exam_category()
{
	/* EXEC SQL LOCK TABLE RD_EXAM_CATEGORY
			 IN EXCLUSIVE MODE NOWAIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "lock TABLE RD_EXAM_CATEGORY IN EXCLUSIVE MODE NOWAIT";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4219;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (RESOURCE_BUSY)
		err_mesg("TABLE cannot be locked in exclusive mode",0,"");
	else
		if (OERROR)
			err_mesg("LOCK failed on table RD_EXAM_CATEGORY",0,"");

	/* EXEC SQL DECLARE RD_EXAM_CATEGORY_CUR CURSOR FOR 
			 SELECT  EXAM_CATEGORY_CODE
			 FROM    RD_EXAM_CATEGORY
			 WHERE   STATUS  = 'S'
			 ORDER BY 1 DESC 
			 FOR     UPDATE  OF STATUS; */ 


	/* EXEC SQL DECLARE RD_EXM_EXAM_CATEGORY_CUR CURSOR FOR 
			 SELECT  'X'
			 FROM    RD_EXAMS
			 WHERE   EXAM_CATEGORY_CODE = :d_master_code; */ 


    /* EXEC SQL OPEN RD_EXAM_CATEGORY_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 5;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0105;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )4234;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqcmod = (unsigned int )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR)
		err_mesg("OPEN failed on cursor RD_EXAM_CATEGORY_CUR",0,"");

	while (fetch_exam_category())
	{
		
		/* EXEC SQL OPEN RD_EXM_EXAM_CATEGORY_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0106;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4249;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_master_code;
  sqlstm.sqhstl[0] = (unsigned int  )44;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_EXM_EXAM_CATEGORY_CUR",0,"");

		/* EXEC SQL FETCH RD_EXM_EXAM_CATEGORY_CUR
	    		  INTO :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4268;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_EXM_EXAM_CATEGORY_CUR",0,"");
		if (sqlca.sqlcode EQ 0)
		{
		   log_messg("RD0249","RD_EXAMS");
		   continue; 
		}
   		
		/* EXEC SQL SELECT  EXAM_CATEGORY_CODE
				 INTO    :d_dummy
				 FROM    RD_EXAM_CATEGORY
				 WHERE   SUBSTR(EXAM_CATEGORY_CODE,1,2) like :d_master_code||'%'
				 AND     EXAM_CATEGORY_LEVEL =2; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select EXAM_CATEGORY_CODE into :b0  from RD_EXAM_CATEGORY w\
here (SUBSTR(EXAM_CATEGORY_CODE,1,2) like (:b1||'%') and EXAM_CATEGORY_LEVEL=2\
)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4287;
  sqlstm.selerr = (unsigned short)0;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_master_code;
  sqlstm.sqhstl[1] = (unsigned int  )44;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


				 
		if (sqlca.sqlcode EQ 0)
		{
		   log_messg("RD0249","RD_EXAM_CATEGORY");
		   continue; 
		}
		/*******************************************************************/
		/*        If Master Code is not referenced in any table above      */
		/*******************************************************************/

		/* EXEC SQL DELETE RD_EXAM_CATEGORY
	   	   WHERE CURRENT OF RD_EXAM_CATEGORY_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from RD_EXAM_CATEGORY  where rowid = :x";
  sqlstm.iters = (unsigned int  )105;
  sqlstm.offset = (unsigned int  )4310;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR)
			err_mesg("DELETE failed on table RD_EXAM_CATEGORY",0,"");
		if (sqlca.sqlcode EQ 0)
			log_messg("RD0250"," ");

	} /* end of while  */

	/* EXEC SQL CLOSE RD_EXAM_CATEGORY_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4325;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	/* EXEC SQL CLOSE RD_EXM_EXAM_CATEGORY_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4340;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

fetch_exam_category()
{
	can_delete = TRUE;
	/* EXEC SQL FETCH RD_EXAM_CATEGORY_CUR
                  INTO :d_master_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4355;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_master_code;
 sqlstm.sqhstl[0] = (unsigned int  )44;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR) 
		err_mesg("FETCH failed on cursor RD_EXAM_CATEGORY_CUR",0,"");
	if (NO_DATA_FOUND) 
		return 0;
	d_master_code.arr[d_master_code.len] = '\0';
	
	if (DEBUG) {
		sprintf(string_var, "Exam Category = %s\n",d_master_code.arr);
		disp_message(ERR_MESG, string_var); }
	return 1;
}
/***************************** End of Exam Category ********************************/

/***************************** Purging Diagnosis ***********************************/
purge_diagnosis()
{
	/* EXEC SQL LOCK TABLE RD_DIAGNOSIS
			 IN EXCLUSIVE MODE NOWAIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "lock TABLE RD_DIAGNOSIS IN EXCLUSIVE MODE NOWAIT";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4374;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (RESOURCE_BUSY)
		err_mesg("TABLE cannot be locked in exclusive mode",0,"");
	else
		if (OERROR)
			err_mesg("LOCK failed on table RD_DIAGNOSIS",0,"");

	/* EXEC SQL DECLARE RD_DIAGNOSIS_CUR CURSOR FOR 
			 SELECT  DIAGNOSIS_CODE
			 FROM    RD_DIAGNOSIS
			 WHERE   STATUS  = 'S' 
			 FOR     UPDATE  OF STATUS; */ 

	
	/*EXEC SQL DECLARE RD_DIAGN_RQST_LN_DIAGN_CUR CURSOR FOR 
			 SELECT  'X'
			 FROM    RD_REQUEST_LINE_DIAGNOSIS
			 WHERE   DIAGNOSIS_CODE = :d_master_code;*/

	/* EXEC SQL OPEN RD_DIAGNOSIS_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0110;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4389;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR)
		err_mesg("OPEN failed on cursor RD_DIAGNOSIS_CUR",0,"");

	while (fetch_diagnosis())
	{
		/*EXEC SQL OPEN RD_DIAGN_RQST_LN_DIAGN_CUR;
		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_DIAGN_RQST_LN_DIAGN_CUR",0,"");

		EXEC SQL FETCH RD_DIAGN_RQST_LN_DIAGN_CUR
	    		  INTO :d_dummy;
		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_DIAGN_RQST_LN_DIAGN_CUR",0,"");*/
		if (sqlca.sqlcode EQ 0)
		{
		   log_messg("RD0249","RD_REQUEST_LINE_DIAGNOSIS");
		   continue; 
		} 
	/*******************************************************************/
	/*        If Master Code is not referenced in any table above      */
	/*******************************************************************/
		/* EXEC SQL DELETE RD_DIAGNOSIS
	   		  WHERE CURRENT OF RD_DIAGNOSIS_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from RD_DIAGNOSIS  where rowid = :x";
  sqlstm.iters = (unsigned int  )110;
  sqlstm.offset = (unsigned int  )4404;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR)
			err_mesg("DELETE failed on table RD_DIAGNOSIS",0,"");
		if (sqlca.sqlcode EQ 0)
			log_messg("RD0250"," ");
	} /* end of while  */

	/* EXEC SQL CLOSE RD_DIAGNOSIS_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4419;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	//EXEC SQL CLOSE RD_DIAGN_RQST_LN_DIAGN_CUR;
}

fetch_diagnosis()
{
	can_delete = TRUE;
	/* EXEC SQL FETCH RD_DIAGNOSIS_CUR
                  INTO :d_master_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4434;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_master_code;
 sqlstm.sqhstl[0] = (unsigned int  )44;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR) 
		err_mesg("FETCH failed on cursor RD_DIAGNOSIS_CUR",0,"");
	if (NO_DATA_FOUND) 
		return 0;
	d_master_code.arr[d_master_code.len] = '\0';
	
	if (DEBUG) {
		sprintf(string_var, "Diagnosis Code = %s\n",d_master_code.arr);
		disp_message(ERR_MESG, string_var); }
	return 1;
}
/***************************** End of Diagnosis ************************************/

//----------------------- Purging Complication -----------------------
purge_complication()
{
	/* EXEC SQL LOCK TABLE RD_COMPLICATION
			 IN EXCLUSIVE MODE NOWAIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "lock TABLE RD_COMPLICATION IN EXCLUSIVE MODE NOWAIT";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4453;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	
	if (RESOURCE_BUSY)
		err_mesg("TABLE cannot be locked in exclusive mode",0,"");
	else
		if (OERROR)
			err_mesg("LOCK failed on table RD_COMPLICATION",0,"");

	/* EXEC SQL 
	DECLARE RD_COMPLICATION_CUR CURSOR FOR 
	SELECT  complication_type
	FROM    rd_complication
	WHERE   NVL(status, 'Y') = 'S' 
	FOR     UPDATE  OF STATUS; */ 

	
	/* EXEC SQL 
	DECLARE RD_COMP_RQST_LN_COMP_CUR CURSOR FOR 
	SELECT 'X'
	FROM   rd_request_line_complications
	WHERE  complication_type = :d_master_code; */ 


	/* EXEC SQL OPEN RD_COMPLICATION_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0113;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4468;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR)
		err_mesg("OPEN failed on cursor RD_COMPLICATION_CUR",0,"");

	while (fetch_complication())
	{
		/* EXEC SQL OPEN RD_COMP_RQST_LN_COMP_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0114;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4483;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_master_code;
  sqlstm.sqhstl[0] = (unsigned int  )44;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_COMP_RQST_LN_COMP_CUR",0,"");

		/* EXEC SQL FETCH RD_COMP_RQST_LN_COMP_CUR
	    		  INTO :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4502;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_COMP_RQST_LN_COMP_CUR",0,"");
		if (sqlca.sqlcode EQ 0)
		{
		   log_messg("RD0249","RD_REQUEST_LINE_COMPLICATIONS");
		   continue; 
		}
	//+-----------------------------------------------------------------+
	//|        If Master Code is not referenced in any table above      |
	//+-----------------------------------------------------------------+
		/* EXEC SQL 
		DELETE rd_complication
		WHERE  CURRENT OF RD_COMPLICATION_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from rd_complication  where rowid = :x";
  sqlstm.iters = (unsigned int  )113;
  sqlstm.offset = (unsigned int  )4521;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		
		if (OERROR)
			err_mesg("DELETE failed on table rd_complication",0,"");
		if (sqlca.sqlcode EQ 0)
			log_messg("RD0250"," ");
	} // end of while  

	/* EXEC SQL CLOSE RD_COMPLICATION_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4536;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	/* EXEC SQL CLOSE RD_COMP_RQST_LN_COMP_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4551;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

fetch_complication()
{
	can_delete = TRUE;
	
	/* EXEC SQL 
	FETCH RD_COMPLICATION_CUR
    INTO  :d_master_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4566;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_master_code;
 sqlstm.sqhstl[0] = (unsigned int  )44;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR) 
		err_mesg("FETCH failed on cursor RD_COMPLICATION_CUR",0,"");
	if (NO_DATA_FOUND) 
		return 0;
	d_master_code.arr[d_master_code.len] = '\0';
	
	if (DEBUG) {
		sprintf(string_var, "Complication Code = %s\n",d_master_code.arr);
		disp_message(ERR_MESG, string_var); }
	return 1;
}
//------------------------ End of Complication -----------------------

//-------------------------- Management Type -------------------------
purge_management_type()
{
	/* EXEC SQL LOCK TABLE rd_comp_management_type
			 IN EXCLUSIVE MODE NOWAIT; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "lock TABLE rd_comp_management_type IN EXCLUSIVE MODE NOWAIT";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4585;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	
	if (RESOURCE_BUSY)
		err_mesg("TABLE cannot be locked in exclusive mode",0,"");
	else
		if (OERROR)
			err_mesg("LOCK failed on table rd_comp_management_type",0,"");

	/* EXEC SQL 
	DECLARE RD_MANAGEMENT_CUR CURSOR FOR 
	SELECT  management_type
	FROM    rd_comp_management_type
	WHERE   NVL(status, 'Y') = 'S' 
	FOR     UPDATE  OF STATUS; */ 

	
	/* EXEC SQL 
	DECLARE RD_COMP_RQST_LN_MNGMNT_CUR CURSOR FOR 
	SELECT 'X'
	FROM   rd_request_line_complications
	WHERE  management_type = :d_master_code; */ 


	/* EXEC SQL OPEN RD_MANAGEMENT_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0117;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4600;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqcmod = (unsigned int )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR)
		err_mesg("OPEN failed on cursor RD_MANAGEMENT_CUR",0,"");

	while (fetch_management_type())
	{
		/* EXEC SQL OPEN RD_COMP_RQST_LN_MNGMNT_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0118;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4615;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqcmod = (unsigned int )0;
  sqlstm.sqhstv[0] = (         void  *)&d_master_code;
  sqlstm.sqhstl[0] = (unsigned int  )44;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_COMP_RQST_LN_MNGMNT_CUR",0,"");

		/* EXEC SQL FETCH RD_COMP_RQST_LN_MNGMNT_CUR
	    		  INTO :d_dummy; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )4634;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqfoff = (           int )0;
  sqlstm.sqfmod = (unsigned int )2;
  sqlstm.sqhstv[0] = (         void  *)&d_dummy;
  sqlstm.sqhstl[0] = (unsigned int  )4;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqphsv = sqlstm.sqhstv;
  sqlstm.sqphsl = sqlstm.sqhstl;
  sqlstm.sqphss = sqlstm.sqhsts;
  sqlstm.sqpind = sqlstm.sqindv;
  sqlstm.sqpins = sqlstm.sqinds;
  sqlstm.sqparm = sqlstm.sqharm;
  sqlstm.sqparc = sqlstm.sqharc;
  sqlstm.sqpadto = sqlstm.sqadto;
  sqlstm.sqptdso = sqlstm.sqtdso;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_COMP_RQST_LN_MNGMNT_CUR",0,"");
		if (sqlca.sqlcode EQ 0)
		{
		   log_messg("RD0249","RD_REQUEST_LINE_COMPLICATIONS");
		   continue; 
		}
	//+-----------------------------------------------------------------+
	//|        If Master Code is not referenced in any table above      |
	//+-----------------------------------------------------------------+
		/* EXEC SQL 
		DELETE rd_comp_management_type
		WHERE  CURRENT OF RD_MANAGEMENT_CUR; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 12;
  sqlstm.arrsiz = 5;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "delete  from rd_comp_management_type  where rowid = :x";
  sqlstm.iters = (unsigned int  )117;
  sqlstm.offset = (unsigned int  )4653;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)4352;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


		
		if (OERROR)
			err_mesg("DELETE failed on table rd_comp_management_type",0,"");
		if (sqlca.sqlcode EQ 0)
			log_messg("RD0250"," ");
	} // end of while  

	/* EXEC SQL CLOSE RD_MANAGEMENT_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4668;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	/* EXEC SQL CLOSE RD_COMP_RQST_LN_MNGMNT_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4683;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

fetch_management_type()
{
	can_delete = TRUE;
	
	/* EXEC SQL 
	FETCH RD_MANAGEMENT_CUR
    INTO  :d_master_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 12;
 sqlstm.arrsiz = 5;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )4698;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)4352;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqfoff = (           int )0;
 sqlstm.sqfmod = (unsigned int )2;
 sqlstm.sqhstv[0] = (         void  *)&d_master_code;
 sqlstm.sqhstl[0] = (unsigned int  )44;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqphsv = sqlstm.sqhstv;
 sqlstm.sqphsl = sqlstm.sqhstl;
 sqlstm.sqphss = sqlstm.sqhsts;
 sqlstm.sqpind = sqlstm.sqindv;
 sqlstm.sqpins = sqlstm.sqinds;
 sqlstm.sqparm = sqlstm.sqharm;
 sqlstm.sqparc = sqlstm.sqharc;
 sqlstm.sqpadto = sqlstm.sqadto;
 sqlstm.sqptdso = sqlstm.sqtdso;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR) 
		err_mesg("FETCH failed on cursor RD_MANAGEMENT_CUR",0,"");
	if (NO_DATA_FOUND) 
		return 0;
	d_master_code.arr[d_master_code.len] = '\0';
	
	if (DEBUG) {
		sprintf(string_var, "Complication Management Type = %s\n",d_master_code.arr);
		disp_message(ERR_MESG, string_var); }
	return 1;
}
//----------------------- End of Management Type ---------------------

log_messg(l_errid, l_table_name)
char *l_errid;
char *l_table_name;
{
	can_delete = FALSE;
    strcpy(d_msg_num.arr,l_errid);

    get_message(d_msg_num.arr,d_msg_desc.arr);
    strcat(d_msg_desc.arr,l_table_name);

    d_msg_num.len = strlen(d_msg_num.arr);
    d_msg_desc.len = strlen(d_msg_desc.arr);

    /* EXEC SQL INSERT INTO RD_PURGE_MSG
 			 VALUES ( :d_table_id,
	 				  :d_master_code,
					  :d_msg_num,
					  :d_msg_desc,
					  :d_ws_no,
					  :d_facility_id,
					  :d_ws_no,
					  :d_facility_id ) ; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 12;
    sqlstm.arrsiz = 8;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "insert into RD_PURGE_MSG  values (:b0,:b1,:b2,:b3,:b4,:b5\
,:b4,:b5)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )4717;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)4352;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_table_id;
    sqlstm.sqhstl[0] = (unsigned int  )34;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_master_code;
    sqlstm.sqhstl[1] = (unsigned int  )44;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_msg_num;
    sqlstm.sqhstl[2] = (unsigned int  )10;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_msg_desc;
    sqlstm.sqhstl[3] = (unsigned int  )74;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_ws_no;
    sqlstm.sqhstl[4] = (unsigned int  )33;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[5] = (unsigned int  )5;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_ws_no;
    sqlstm.sqhstl[6] = (unsigned int  )33;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_facility_id;
    sqlstm.sqhstl[7] = (unsigned int  )5;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqphsv = sqlstm.sqhstv;
    sqlstm.sqphsl = sqlstm.sqhstl;
    sqlstm.sqphss = sqlstm.sqhsts;
    sqlstm.sqpind = sqlstm.sqindv;
    sqlstm.sqpins = sqlstm.sqinds;
    sqlstm.sqparm = sqlstm.sqharm;
    sqlstm.sqparc = sqlstm.sqharc;
    sqlstm.sqpadto = sqlstm.sqadto;
    sqlstm.sqptdso = sqlstm.sqtdso;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	if (OERROR) 
		err_mesg("INSERT failed on table RD_PURGE_MSG",0,"");
}

del_param()
{
     /* EXEC SQL 
	 DELETE SY_PROG_PARAM
	 WHERE  OPERATING_FACILITY_ID = :d_facility_id 
	 AND	PGM_ID				  = 'RDBPURGE' 
	 AND	PGM_DATE			  = :d_pgm_date
	 AND	SESSION_ID			  = :d_session_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 12;
     sqlstm.arrsiz = 8;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "delete  from SY_PROG_PARAM  where (((OPERATING_FACILITY_\
ID=:b0 and PGM_ID='RDBPURGE') and PGM_DATE=:b1) and SESSION_ID=:b2)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )4764;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)4352;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_facility_id;
     sqlstm.sqhstl[0] = (unsigned int  )5;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_pgm_date;
     sqlstm.sqhstl[1] = (unsigned int  )16;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&d_session_id;
     sqlstm.sqhstl[2] = (unsigned int  )18;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqphsv = sqlstm.sqhstv;
     sqlstm.sqphsl = sqlstm.sqhstl;
     sqlstm.sqphss = sqlstm.sqhsts;
     sqlstm.sqpind = sqlstm.sqindv;
     sqlstm.sqpins = sqlstm.sqinds;
     sqlstm.sqparm = sqlstm.sqharm;
     sqlstm.sqparc = sqlstm.sqharc;
     sqlstm.sqpadto = sqlstm.sqadto;
     sqlstm.sqptdso = sqlstm.sqtdso;
     sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



	if (OERROR) 
		err_mesg("DELETE failed on table SY_PROG_PARAM",0,""); 
}
//----------------------  End of Program  ----------------------------

/*
//--------------------- Purging Complication  ------------------------
purge_complication()
{
	EXEC SQL LOCK TABLE RD_RATE_OF_COMPLICATION
			 IN EXCLUSIVE MODE NOWAIT;
	
	if (RESOURCE_BUSY)
		err_mesg("TABLE cannot be locked in exclusive mode",0,"");
	else
		if (OERROR)
			err_mesg("LOCK failed on table RD_RATE_OF_COMPLICATION",0,"");

	EXEC SQL DECLARE RD_RATE_OF_COMPLICATION_CUR CURSOR FOR 
			 SELECT  RATE_OF_COMP_CODE
			 FROM    RD_RATE_OF_COMPLICATION
			 WHERE   STATUS  = 'S' 
			 FOR     UPDATE  OF STATUS;
	
	EXEC SQL DECLARE RD_COMP_RQST_LN_DIAGN_CUR CURSOR FOR 
			 SELECT  'X'
		     FROM    RD_REQUEST_LINE_DIAGNOSIS
			 WHERE   RATE_OF_COMP_CODE = :d_master_code;

	EXEC SQL OPEN RD_RATE_OF_COMPLICATION_CUR;
	if (OERROR)
		err_mesg("OPEN failed on cursor RD_RATE_OF_COMPLICATION_CUR",0,"");

	while (fetch_complication())
	{
		EXEC SQL OPEN RD_COMP_RQST_LN_DIAGN_CUR;
		if (OERROR) 
			err_mesg("OPEN failed on cursor RD_COMP_RQST_LN_DIAGN_CUR",0,"");

		EXEC SQL FETCH RD_COMP_RQST_LN_DIAGN_CUR
	    		  INTO :d_dummy;
		if (OERROR) 
			err_mesg("FETCH failed on cursor RD_COMP_RQST_LN_DIAGN_CUR",0,"");
		if (sqlca.sqlcode EQ 0)
		{
		   log_messg("RD0249","RD_REQUEST_LINE_DIAGNOSIS");
		   continue; 
		}
	//+--------------------------------------------------------------+
	//       If Master Code is not referenced in any table above     |
	//+--------------------------------------------------------------+
		EXEC SQL DELETE RD_RATE_OF_COMPLICATION
	   		      WHERE CURRENT OF RD_RATE_OF_COMPLICATION_CUR;
		if (OERROR)
			err_mesg("DELETE failed on table RD_RATE_OF_COMPLICATION",0,"");
		if (sqlca.sqlcode EQ 0)
			log_messg("RD0250"," ");
	} // end of while

	EXEC SQL CLOSE RD_RATE_OF_COMPLICATION_CUR;
	EXEC SQL CLOSE RD_COMP_RQST_LN_DIAGN_CUR;
}

fetch_complication()
{
	can_delete = TRUE;
	EXEC SQL FETCH RD_RATE_OF_COMPLICATION_CUR
              INTO :d_master_code;
	if (OERROR) 
		err_mesg("FETCH failed on cursor RD_RATE_OF_COMPLICATION_CUR",0,"");
	if (NO_DATA_FOUND) 
		return 0;
	d_master_code.arr[d_master_code.len] = '\0';
	
	if (DEBUG) {
		sprintf(string_var, "Complication Code = %s\n",d_master_code.arr);
		disp_message(ERR_MESG, string_var); }
	return 1;
}
//----------------------- End of Complication ------------------------
*/