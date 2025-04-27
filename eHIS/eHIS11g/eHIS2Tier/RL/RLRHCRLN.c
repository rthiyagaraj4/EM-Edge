
/* Result Sets Interface */
#ifndef SQL_CRSR
#  define SQL_CRSR
  struct sql_cursor
  {
    unsigned int curocn;
    void *ptr1;
    void *ptr2;
    unsigned long magic;
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
           char  filnam[59];
};
static const struct sqlcxp sqlfpn =
{
    58,
    "D:\\WORK\\ML-MMOH-CRF-0752.6-US001\\Proc\\RLRHCRLN\\RLRHCRLN.pc"
};


static unsigned long sqlctx = 1143621173;


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
            void  *sqhstv[48];
   unsigned int   sqhstl[48];
            int   sqhsts[48];
            void  *sqindv[48];
            int   sqinds[48];
   unsigned int   sqharm[48];
   unsigned int   *sqharc[48];
   unsigned short  sqadto[48];
   unsigned short  sqtdso[48];
} sqlstm = {10,48};

/* SQLLIB Prototypes */
extern void sqlcxt (void **, unsigned long *,
                    struct sqlexd *, const struct sqlcxp *);
extern void sqlcx2t(void **, unsigned long *,
                    struct sqlexd *, const struct sqlcxp *);
extern void sqlbuft(void **, char *);
extern void sqlgs2t(void **, char *);
extern void sqlorat(void **, unsigned long *, void *);

/* Forms Interface */
static const int IAPSUCC = 0;
static const int IAPFAIL = 1403;
static const int IAPFTL  = 535;
extern void sqliem(char *, int *);

 static const char *sq0009 = 
"MM/YYYY')+1)) and A.OPERATING_FACILITY_ID=:b2) and A.SPECIMEN_NO=B.SPECIMEN_\
NO(+)) and A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID(+)) and NVL(A.SPECI\
MEN_TYPE_CODE,'!') between NVL(:b25,NVL(A.SPECIMEN_TYPE_CODE,'!')) and NVL(:b2\
6,NVL(A.SPECIMEN_TYPE_CODE,'!'))) and NVL(B.ANATOMY_SITE_CODE,'!') between NVL\
(:b27,NVL(B.ANATOMY_SITE_CODE,'!')) and NVL(:b28,NVL(B.ANATOMY_SITE_CODE,'!'))\
) and NVL(A.CATEGORY_CODE,'!')=NVL(:b29,NVL(A.CATEGORY_CODE,'!'))) and NVL(A.S\
TATUS,'O')<>'O') and A.SECTION_CODE=:b30) and ((:b31='Y' and exists (select 'X\
'  from rl_result_text X where (((X.patient_id=A.patient_id and X.specimen_no=\
A.specimen_no) and X.operating_facility_id=A.operating_facility_id) and NVL(X.\
cancer_register_yn,'N')='Y'))) or (:b31='N' and 1=1)))))  order by 1          \
  ";

 static const char *sq0011 = 
"YYY')+1)) and A.OPERATING_FACILITY_ID=:b2) and A.SPECIMEN_NO=B.SPECIMEN_NO(+\
)) and A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID(+)) and NVL(A.SPECIMEN_\
TYPE_CODE,'!') between NVL(:b25,NVL(A.SPECIMEN_TYPE_CODE,'!')) and NVL(:b26,NV\
L(A.SPECIMEN_TYPE_CODE,'!'))) and NVL(B.ANATOMY_SITE_CODE,'!') between NVL(:b2\
7,NVL(B.ANATOMY_SITE_CODE,'!')) and NVL(:b28,NVL(B.ANATOMY_SITE_CODE,'!'))) an\
d NVL(A.CATEGORY_CODE,'!')=NVL(:b29,NVL(A.CATEGORY_CODE,'!'))) and NVL(A.STATU\
S,'O')<>'O') and A.SECTION_CODE=:b30) and ((:b31='Y' and exists (select 'X'  f\
rom rl_result_text X where (((X.patient_id=A.patient_id and X.specimen_no=A.sp\
ecimen_no) and X.operating_facility_id=A.operating_facility_id) and NVL(X.canc\
er_register_yn,'N')='Y'))) or (:b31='N' and 1=1)))))  order by 1            ";

 static const char *sq0013 = 
"ODE,'!')) and NVL(:b31,NVL(B.ANATOMY_SITE_CODE,'!'))) and NVL(A.CATEGORY_COD\
E,'!')=NVL(:b32,NVL(A.CATEGORY_CODE,'!'))) and NVL(A.STATUS,'O')<>'O') and A.S\
ECTION_CODE=:b33) and ((:b34='Y' and exists (select 'X'  from rl_result_text X\
 where (((X.patient_id=A.patient_id and X.specimen_no=A.specimen_no) and X.ope\
rating_facility_id=A.operating_facility_id) and NVL(X.cancer_register_yn,'N')=\
'Y'))) or (:b34='N' and 1=1)))) order by PATIENT_ID,SPECIMEN_NO            ";

 static const char *sq0019 = 
"select distinct A.SPECIMEN_NO ,A.TEST_CODE ,A.NUMERIC_RESULT ,A.RESULT_COMME\
NT_DESC1 ,A.RESULT_COMMENT_DESC2 ,A.RESULT_COMMENT_DESC3 ,A.RESULT_COMMENT_DES\
C4  from RL_TEST_RESULT A where ((((A.PATIENT_ID=:b0 and A.SPECIMEN_NO=:b1) an\
d A.SECTION_CODE=:b2) and A.OPERATING_FACILITY_ID=:b3) and ((:b4='Y' and exist\
s (select 'X'  from rl_result_text X where (((X.patient_id=A.patient_id and X.\
specimen_no=A.specimen_no) and X.operating_facility_id=A.operating_facility_id\
) and NVL(X.cancer_register_yn,'N')='Y'))) or (:b4='N' and 1=1)))           ";

 static const char *sq0015 = 
"select A.TEST_CODE ,B.LONG_DESC  from RL_REQUEST_DETAIL A ,RL_TEST_CODE_lang\
_vw B where ((((SPECIMEN_NO=:b0 and OPERATING_FACILITY_ID=:b1) and a.test_code\
=:b2) and A.TEST_CODE=B.TEST_CODE) and b.language_id=:b3) order by LINE_NO    \
        ";

 static const char *sq0017 = 
"select A.TEST_CODE ,B.LONG_DESC  from RL_REQUEST_DETAIL A ,RL_TEST_CODE_lang\
_vw B where ((((SPECIMEN_NO=:b0 and OPERATING_FACILITY_ID=:b1) and A.TEST_CODE\
=:b2) and A.TEST_CODE=B.TEST_CODE) and b.language_id=:b3) order by LINE_NO    \
        ";

 static const char *sq0021 = 
"NATOMY_SITE_CODE,'!')) and NVL(:b7,NVL(B.ANATOMY_SITE_CODE,'!'))) and NVL(A.\
CATEGORY_CODE,'!')=NVL(:b8,NVL(A.CATEGORY_CODE,'!'))) and NVL(A.STATUS,'O')<>'\
O') and A.SECTION_CODE=:b9) and ((:b10='Y' and exists (select 'X'  from rl_res\
ult_text X where (((X.patient_id=A.patient_id and X.specimen_no=A.specimen_no)\
 and X.operating_facility_id=A.operating_facility_id) and NVL(X.cancer_registe\
r_yn,'N')='Y'))) or (:b10='N' and 1=1)))) ) A ,RL_TEST_RESULT B where (A.SPECI\
MEN_NO=B.SPECIMEN_NO and A.SECTION_CODE=B.SECTION_CODE) order by A.SPECIMEN_NO\
            ";

 static const char *sq0034 = 
"select specimen_no ,result_text_code ,result_text  from RL_RESULT_TEXT where\
 ((((patient_id=:b0 and specimen_no=:b1) and operating_facility_id=:b2) and te\
st_code=:b3) and ((:b4='Y' and NVL(cancer_register_yn,'N')='Y') or (:b4='N' an\
d 1=1))) order by specimen_no            ";

 static const char *sq0038 = 
"select specimen_no ,result_text_code ,result_text  from RL_RESULT_TEXT where\
 ((((patient_id=:b0 and specimen_no=:b1) and operating_facility_id=:b2) and TE\
ST_CODE=:b3) and ((:b4='Y' and NVL(cancer_register_yn,'N')='Y') or (:b4='N' an\
d 1=1))) order by specimen_no            ";

 static const char *sq0040 = 
"select specimen_no ,clinical_text_code ,SUBSTR(clinical_text,1,4000)  from R\
L_PATIENT_CLINICAL_TEXT where (((specimen_no=:b0 and patient_id=:b1) and OPERA\
TING_FACILITY_ID=:b2) and NVL(order_questionnaire_yn,'N')<>'Y') order by speci\
men_no            ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,27,264,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,30,293,0,0,0,0,0,1,0,
51,0,0,3,0,0,32,302,0,0,0,0,0,1,0,
66,0,0,4,417,0,4,316,0,0,24,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
177,0,0,5,98,0,2,385,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
200,0,0,6,0,0,32,392,0,0,0,0,0,1,0,
215,0,0,7,150,0,4,402,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
250,0,0,8,0,0,32,424,0,0,0,0,0,1,0,
265,0,0,9,3852,0,9,559,0,0,44,44,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
456,0,0,10,0,0,32,564,0,0,0,0,0,1,0,
471,0,0,11,3848,0,9,699,0,0,44,44,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,
662,0,0,12,0,0,32,704,0,0,0,0,0,1,0,
677,0,0,13,4559,0,9,865,0,0,48,48,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
884,0,0,14,0,0,32,870,0,0,0,0,0,1,0,
899,0,0,16,0,0,32,897,0,0,0,0,0,1,0,
914,0,0,18,0,0,32,923,0,0,0,0,0,1,0,
929,0,0,20,0,0,32,963,0,0,0,0,0,1,0,
944,0,0,22,0,0,32,1162,0,0,0,0,0,1,0,
959,0,0,19,542,0,9,1172,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
998,0,0,23,0,0,32,1177,0,0,0,0,0,1,0,
1013,0,0,15,240,0,9,1184,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1044,0,0,24,0,0,32,1189,0,0,0,0,0,1,0,
1059,0,0,17,240,0,9,1196,0,0,4,4,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1090,0,0,25,0,0,32,1201,0,0,0,0,0,1,0,
1105,0,0,21,2604,0,9,1209,0,0,24,24,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1216,0,0,26,0,0,32,1213,0,0,0,0,0,1,0,
1231,0,0,13,0,0,15,1574,0,0,0,0,0,1,0,
1246,0,0,9,0,0,15,1581,0,0,0,0,0,1,0,
1261,0,0,11,0,0,15,1586,0,0,0,0,0,1,0,
1276,0,0,9,0,0,13,1604,0,0,1,0,0,1,0,2,9,0,0,
1295,0,0,27,0,0,32,1627,0,0,0,0,0,1,0,
1310,0,0,11,0,0,13,1646,0,0,1,0,0,1,0,2,9,0,0,
1329,0,0,28,0,0,32,1669,0,0,0,0,0,1,0,
1344,0,0,13,0,0,13,1695,0,0,9,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1395,0,0,29,0,0,32,1722,0,0,0,0,0,1,0,
1410,0,0,19,0,0,15,1730,0,0,0,0,0,1,0,
1425,0,0,15,0,0,15,1734,0,0,0,0,0,1,0,
1440,0,0,17,0,0,15,1738,0,0,0,0,0,1,0,
1455,0,0,19,0,0,13,1758,0,0,7,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,
1498,0,0,30,0,0,32,1777,0,0,0,0,0,1,0,
1513,0,0,15,0,0,13,1791,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
1536,0,0,31,0,0,32,1802,0,0,0,0,0,1,0,
1551,0,0,17,0,0,13,1816,0,0,2,0,0,1,0,2,9,0,0,2,9,0,0,
1574,0,0,32,0,0,32,1827,0,0,0,0,0,1,0,
1589,0,0,33,0,0,32,2002,0,0,0,0,0,1,0,
1604,0,0,34,273,0,9,2034,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
1643,0,0,34,0,0,15,2040,0,0,0,0,0,1,0,
1658,0,0,35,0,0,32,2045,0,0,0,0,0,1,0,
1673,0,0,21,0,0,15,2273,0,0,0,0,0,1,0,
1688,0,0,21,0,0,13,2296,0,0,10,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
1743,0,0,36,0,0,32,2324,0,0,0,0,0,1,0,
1758,0,0,37,0,0,32,2503,0,0,0,0,0,1,0,
1773,0,0,38,273,0,9,2596,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
1812,0,0,38,0,0,15,2602,0,0,0,0,0,1,0,
1827,0,0,39,0,0,32,2607,0,0,0,0,0,1,0,
1842,0,0,40,250,0,9,2858,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
1869,0,0,40,0,0,15,2864,0,0,0,0,0,1,0,
1884,0,0,34,0,0,13,3107,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1911,0,0,38,0,0,13,3135,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1938,0,0,40,0,0,13,3163,0,0,3,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,
1965,0,0,41,145,0,4,3198,0,0,4,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
1996,0,0,42,0,0,32,3215,0,0,0,0,0,1,0,
2011,0,0,43,145,0,4,3224,0,0,4,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,
2042,0,0,44,0,0,32,3241,0,0,0,0,0,1,0,
2057,0,0,45,115,0,4,3255,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2088,0,0,46,127,0,4,3267,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2119,0,0,47,97,0,4,3285,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
2146,0,0,48,0,0,32,3305,0,0,0,0,0,1,0,
2161,0,0,49,143,0,6,3324,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
2188,0,0,50,143,0,6,3333,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
2215,0,0,51,143,0,6,3342,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
2242,0,0,52,143,0,6,3351,0,0,3,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
2269,0,0,53,100,0,6,3492,0,0,2,2,0,1,0,2,9,0,0,1,9,0,0,
2292,0,0,54,101,0,6,3574,0,0,1,1,0,1,0,2,3,0,0,
2311,0,0,55,49,0,4,3586,0,0,1,0,0,1,0,2,9,0,0,
2330,0,0,56,120,0,6,3608,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
2353,0,0,57,136,0,6,3618,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
};


/***************************************************************************** 
*  File	         : RLRHCRLN.pc
   Author        : Hameed
   Date Created  : 28/02/2005

*  Ver 4.1  

*  Purpose : To Generate Histo/Cyto Correlation Report

*  Input Parameters : 
                      Command line inputs
	              1. Usr_id/Password
                      2. Session id
		              3. Program Date

                      Parameters from SY_PROG_PARAM table
  
*  Tables Accessed :
*****************************************************************************/  

#include <stdio.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>

#define MAX_LINES 55
#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403
#define LAST_ROW                (sqlca.sqlcode == 1403)
#define VER  "VER : 4.1\n"
#define ESC 0x1B
#define REP_WIDTH 78
/*
#define DEBUG 
*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 


    /* increased the length all varchar variables by one to take care
       for null termination 
	 */
	 /* VARCHAR    nd_operating_facility_id [3],
	            uid_pwd		            [91],
				nd_file_name            [150] ,
                nd_file_no              [15],
                nd_session_id      	    [16],
		        nd_pgm_date	   	        [20],
				d_version_no			[20],
				d_version  			    [20],

				/o Specimen Information o/
				d_specimen_no           [21],
				d_specimen_no_prv	    [21],
				d_specimen_no_1         [21],
				d_specimen_no_1_prv     [21],
				d_specimen_no_2         [21],
				d_specimen_no_2_prv     [21],
				d_patient_id            [31],
				
				d_patient_name          [240],  //SD-CRF-20059 from here 
				d_episode_type          [2],
                d_soure_type            [1], 
				d_nationality_id        [20],
				d_source_code           [7] ,
			    d_source_name           [100],  /oModified By Manoj S for ML-MMOH-CRF-0752.6o/
			    d_source_type           [2] ,
                d_test_desc             [40],
                d_test_code             [11], //SD-CRF-20059 upto here 
                d_test_code_1           [11], //added on 26-10-2007 
                d_test_code_2           [11], //added on 26-10-2007 
				
				d_patient_id_prv        [31],
				d_category_code          [5],
				d_category_year          [5],
				d_category_num           [16],

				d_category_code_2        [5],
				d_category_year_2        [5],
				d_category_num_2         [16],

				d_section_ind            [5],
				d_section_ind_prv        [5],

				/o  Patient Master details  o/
				d_short_name            [61],

				d_patient_name_1		[240],
				d_patient_name_2		[240],
				d_patient_name_3		[240],
				d_patient_name_4		[240],

				d_date_of_birth         [11],
				d_sex                   [2],
				d_actual_dob_yn			[2],

				d_numeric_result	    [16],
				d_rc_1         		    [41],
				d_rc_2         		    [41],
				d_rc_3         		    [41],
				d_rc_4         		    [41],

				d_numeric_result_2	    [16],
				d_rc_1_2       		    [41],
				d_rc_2_2       		    [41],
				d_rc_3_2       		    [41],
				d_rc_4_2       		    [41],

                d_clinical_text_code	[5],
			    d_clinical_text		    [4001],
			    d_clinical_spec_no		[21],
 
                d_result_text_code		[5],
			    d_result_text		    [4001],
			    d_result_spec_no		[21],

                d_result_text_code_2	[5],
			    d_result_text_2		    [4001],
			    d_result_spec_no_2		[21],

				/o******* parameters from SY_PROG_PARAM table **********o/
				nd_section_1            [3],
				nd_section_2            [3],
				nd_section_ind_1        [5],
				nd_section_ind_2        [5],
				nd_regd_date_fr_1		[31],
				nd_regd_date_to_1		[31],
				nd_regd_date_fr_2		[31],
				nd_regd_date_to_2		[31],
				nd_regd_date_fr_11		[31], //added for globalisation
				nd_regd_date_to_11		[31], //added for globalisation
				nd_regd_date_fr_21		[31], //added for globalisation
				nd_regd_date_to_21		[31], //added for globalisation

				nd_spec_type_fr_1		[5],
				nd_spec_type_to_1		[5],
				nd_spec_type_fr_2		[5],
				nd_spec_type_to_2		[5],

				nd_site_code			[5],

				nd_anatomy_site_fr_1	[5],
				nd_anatomy_site_to_1	[5],
				nd_anatomy_site_fr_2	[5],
				nd_anatomy_site_to_2	[5],

				nd_category_prfx_1      [5],
				nd_category_prfx_2      [5],
				nd_search_result_text_1 [2],
				nd_search_result_text_2 [2],
				nd_search_type			[2],
				nd_section_code         [3],

				/o for header routine o/
				//d_acc_entity_name        [61],
				d_acc_entity_name        [300],
				d_user                   [21],
				d_sysdate                [17],
				d_sysdate1                [17],
		/o**************added for globalisation************************o/
				l_translated_value		 [500],
				language_id			[5]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[150]; } nd_file_name;

struct { unsigned short len; unsigned char arr[15]; } nd_file_no;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[20]; } d_version_no;

struct { unsigned short len; unsigned char arr[20]; } d_version;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no_prv;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no_1;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no_1_prv;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no_2;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no_2_prv;

struct { unsigned short len; unsigned char arr[31]; } d_patient_id;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[1]; } d_soure_type;

struct { unsigned short len; unsigned char arr[20]; } d_nationality_id;

struct { unsigned short len; unsigned char arr[7]; } d_source_code;

struct { unsigned short len; unsigned char arr[100]; } d_source_name;

struct { unsigned short len; unsigned char arr[2]; } d_source_type;

struct { unsigned short len; unsigned char arr[40]; } d_test_desc;

struct { unsigned short len; unsigned char arr[11]; } d_test_code;

struct { unsigned short len; unsigned char arr[11]; } d_test_code_1;

struct { unsigned short len; unsigned char arr[11]; } d_test_code_2;

struct { unsigned short len; unsigned char arr[31]; } d_patient_id_prv;

struct { unsigned short len; unsigned char arr[5]; } d_category_code;

struct { unsigned short len; unsigned char arr[5]; } d_category_year;

struct { unsigned short len; unsigned char arr[16]; } d_category_num;

struct { unsigned short len; unsigned char arr[5]; } d_category_code_2;

struct { unsigned short len; unsigned char arr[5]; } d_category_year_2;

struct { unsigned short len; unsigned char arr[16]; } d_category_num_2;

struct { unsigned short len; unsigned char arr[5]; } d_section_ind;

struct { unsigned short len; unsigned char arr[5]; } d_section_ind_prv;

struct { unsigned short len; unsigned char arr[61]; } d_short_name;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_1;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_2;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_3;

struct { unsigned short len; unsigned char arr[240]; } d_patient_name_4;

struct { unsigned short len; unsigned char arr[11]; } d_date_of_birth;

struct { unsigned short len; unsigned char arr[2]; } d_sex;

struct { unsigned short len; unsigned char arr[2]; } d_actual_dob_yn;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result;

struct { unsigned short len; unsigned char arr[41]; } d_rc_1;

struct { unsigned short len; unsigned char arr[41]; } d_rc_2;

struct { unsigned short len; unsigned char arr[41]; } d_rc_3;

struct { unsigned short len; unsigned char arr[41]; } d_rc_4;

struct { unsigned short len; unsigned char arr[16]; } d_numeric_result_2;

struct { unsigned short len; unsigned char arr[41]; } d_rc_1_2;

struct { unsigned short len; unsigned char arr[41]; } d_rc_2_2;

struct { unsigned short len; unsigned char arr[41]; } d_rc_3_2;

struct { unsigned short len; unsigned char arr[41]; } d_rc_4_2;

struct { unsigned short len; unsigned char arr[5]; } d_clinical_text_code;

struct { unsigned short len; unsigned char arr[4001]; } d_clinical_text;

struct { unsigned short len; unsigned char arr[21]; } d_clinical_spec_no;

struct { unsigned short len; unsigned char arr[5]; } d_result_text_code;

struct { unsigned short len; unsigned char arr[4001]; } d_result_text;

struct { unsigned short len; unsigned char arr[21]; } d_result_spec_no;

struct { unsigned short len; unsigned char arr[5]; } d_result_text_code_2;

struct { unsigned short len; unsigned char arr[4001]; } d_result_text_2;

struct { unsigned short len; unsigned char arr[21]; } d_result_spec_no_2;

struct { unsigned short len; unsigned char arr[3]; } nd_section_1;

struct { unsigned short len; unsigned char arr[3]; } nd_section_2;

struct { unsigned short len; unsigned char arr[5]; } nd_section_ind_1;

struct { unsigned short len; unsigned char arr[5]; } nd_section_ind_2;

struct { unsigned short len; unsigned char arr[31]; } nd_regd_date_fr_1;

struct { unsigned short len; unsigned char arr[31]; } nd_regd_date_to_1;

struct { unsigned short len; unsigned char arr[31]; } nd_regd_date_fr_2;

struct { unsigned short len; unsigned char arr[31]; } nd_regd_date_to_2;

struct { unsigned short len; unsigned char arr[31]; } nd_regd_date_fr_11;

struct { unsigned short len; unsigned char arr[31]; } nd_regd_date_to_11;

struct { unsigned short len; unsigned char arr[31]; } nd_regd_date_fr_21;

struct { unsigned short len; unsigned char arr[31]; } nd_regd_date_to_21;

struct { unsigned short len; unsigned char arr[5]; } nd_spec_type_fr_1;

struct { unsigned short len; unsigned char arr[5]; } nd_spec_type_to_1;

struct { unsigned short len; unsigned char arr[5]; } nd_spec_type_fr_2;

struct { unsigned short len; unsigned char arr[5]; } nd_spec_type_to_2;

struct { unsigned short len; unsigned char arr[5]; } nd_site_code;

struct { unsigned short len; unsigned char arr[5]; } nd_anatomy_site_fr_1;

struct { unsigned short len; unsigned char arr[5]; } nd_anatomy_site_to_1;

struct { unsigned short len; unsigned char arr[5]; } nd_anatomy_site_fr_2;

struct { unsigned short len; unsigned char arr[5]; } nd_anatomy_site_to_2;

struct { unsigned short len; unsigned char arr[5]; } nd_category_prfx_1;

struct { unsigned short len; unsigned char arr[5]; } nd_category_prfx_2;

struct { unsigned short len; unsigned char arr[2]; } nd_search_result_text_1;

struct { unsigned short len; unsigned char arr[2]; } nd_search_result_text_2;

struct { unsigned short len; unsigned char arr[2]; } nd_search_type;

struct { unsigned short len; unsigned char arr[3]; } nd_section_code;

struct { unsigned short len; unsigned char arr[300]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[21]; } d_user;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate;

struct { unsigned short len; unsigned char arr[17]; } d_sysdate1;

struct { unsigned short len; unsigned char arr[500]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;

		/***************added for globalisation*************************/

				char    sql_stmt[5000];

				int l_count = 0;

	/*  For Patient Age SYSDATE, MTHS */

	 /* VARCHAR tday				[30],
			t_days				[30],
			mths				[30],
			mths1				[30],
			t_age				[30]; */ 
struct { unsigned short len; unsigned char arr[30]; } tday;

struct { unsigned short len; unsigned char arr[30]; } t_days;

struct { unsigned short len; unsigned char arr[30]; } mths;

struct { unsigned short len; unsigned char arr[30]; } mths1;

struct { unsigned short len; unsigned char arr[30]; } t_age;


	float mt;

	int i; //added for globalisation

	int  l_tab_exists ;
	char src_code[11];
	
 /* EXEC SQL END DECLARE SECTION; */ 



	int		l_len = 30;
	char	l_delimeter;

	char    first_section_title[200], second_section_title[200];
    
/*  EXEC SQL INCLUDE SQLCA.H;
 */ 
/*
 * $Header: sqlca.h,v 1.3 1994/12/12 19:27:27 jbasu Exp $ sqlca.h 
 */

/* Copyright (c) 1985,1986, 1998 by Oracle Corporation. */
 
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
/*  EXEC SQL INCLUDE SQLDA.H;
 */ 
/*
 * $Header: sqlda.h 31-jul-99.19:34:41 apopat Exp $ sqlda.h 
 */

/***************************************************************
*      The SQLDA descriptor definition                         *
*--------------------------------------------------------------*
*      VAX/3B Version                                          *
*                                                              *
*  Copyright (c) 1987, 1997, 1998, 1999 by Oracle Corporation                    *
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
  /* ub2*   */ short     *Y; /* Ptr to Arr of max lengths of ind. var. names */
  /* ub2*   */ short     *Z; /* Ptr to Arr of cur lengths of ind. var. names */
  };
 
typedef struct SQLDA SQLDA;
 
#endif

/* ----------------- */
/* defines for sqlda */
/* ----------------- */

#define SQLSQLDAAlloc(arg1, arg2, arg3, arg4) sqlaldt(arg1, arg2, arg3, arg4) 

#define SQLSQLDAFree(arg1, arg2) sqlclut(arg1, arg2) 





#include <winproc.h>

char      sys_command[200];

int   l_length = 0;
int   i,nol = 1;
int   rec_found =0;


FILE *fp;
void print_page_header();
void print_col_heading();
void prepare_new_page();
void end_report();
void print_detl_rec_1();
void print_detl_rec_2();
int  line_no = 0, page_no = 0,d_specimen_count = 0, l_sec_cnt =1;

char word1[2];
char string_var[100] ;
char local_legend[35][500];//added for globalisation

int something_to_print = 0;
int qq = 0, cntr = 0, z = 0, l_var = 0, clt = 0, cmp = 0, t_rue = 0;


char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1],
     hdr_line4[REP_WIDTH+1],
     hdr_line5[REP_WIDTH+1];


//char rep_title1[] = "Histology - Cytology Correlation Report";
char rep_title1[60];
char rep_title2[50];


void proc_main(argc, argv)
int argc;
char *argv[];
{
  void  get_params(),
  		get_header_dtls(),
  		dclr_request_header_cur_1(),
		dclr_request_header_cur(),
		dclr_request_header_cur_bb(),//added on 30/10/2007 against the ML-SD-SCF-1972 
		dclr_test_result_cur_1(),
		dclr_test_result_cur_2(),
		dclr_request_detail(),//SD-CRF-20059
		do_report();

   if(argc < 4) {
     disp_message(ORA_MESG,"Usage rlrhcrln uid/passwd session_id pgm_date\n");
     proc_exit();
   }

   strcpy(uid_pwd.arr, argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr); 

   strcpy(nd_session_id.arr, argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr); 

   strcpy(nd_pgm_date.arr, argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr); 
   
   strcpy(OUTPUT_FILE_NAME, argv[5]);

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


   /* EXEC SQL CONNECT :uid_pwd; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )20;
   sqlstm.offset = (unsigned int  )5;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
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
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
   if (sqlca.sqlcode < 0) goto err_exit;
}



#ifdef DEBUG
    printf("Connected to ORACLE as user: %s \n", uid_pwd.arr);
#endif  
   
   set_meduser_role();
 /*********************** added for globalisation ******************************/
    strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';
/*********************** added for globalisation ******************************/
 
   get_params();

	get_legend_value(33);


   gen_file_name();
   dclr_request_header_cur();
   dclr_request_header_cur_bb();//added on 30/10/2007 against the ML-SD-SCF-1972 
   //dclr_request_header_cur_1();
   dclr_test_result_cur_1();
   dclr_test_result_cur_2();
   get_header_dtls();
   do_report();
     
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


   /* EXEC SQL COMMIT WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )36;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
   if (sqlca.sqlcode < 0) goto err_exit;
}



   fclose(fp);

   return ;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 


   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )51;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at main() occured....\n");
   proc_exit();
}

/* -------------------------------------------------------------------------*/

/* get the parameters from the SY_PROG_PARM table and */
/* delete the record after reading it.                */
void get_params()
{
   /* read the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


   /* EXEC SQL SELECT OPERATING_FACILITY_ID,
                   PARAM1, PARAM2, PARAM3, PARAM4, PARAM5, PARAM6, PARAM7,
				   PARAM8, PARAM9, PARAM19, PARAM10, PARAM11, PARAM12, PARAM13, PARAM14,
				   PARAM15, PARAM16,PARAM17,PARAM18, PARAM20,PARAM21 
            INTO 
		           :nd_operating_facility_id,:nd_section_ind_1,
				   :nd_section_1, :nd_regd_date_fr_1, :nd_regd_date_to_1,
				   :nd_spec_type_fr_1, :nd_spec_type_to_1, 
				   :nd_anatomy_site_fr_1,:nd_anatomy_site_to_1, :nd_category_prfx_1,
				   :nd_search_result_text_1,
				   :nd_section_ind_2,:nd_section_2, :nd_regd_date_fr_2,:nd_regd_date_to_2,
		           :nd_spec_type_fr_2,:nd_spec_type_to_2,:nd_anatomy_site_fr_2,
				   :nd_anatomy_site_to_2,:nd_category_prfx_2,
				   :nd_search_result_text_2,:nd_search_type
            FROM   SY_PROG_PARAM
	        WHERE  UPPER(PGM_ID) = 'RLRHCRLN'
		      AND  SESSION_ID = TO_NUMBER(:nd_session_id)
		      AND  PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,PARAM9 ,PARAM19 ,PARAM10 ,PARAM11 ,PARAM12\
 ,PARAM13 ,PARAM14 ,PARAM15 ,PARAM16 ,PARAM17 ,PARAM18 ,PARAM20 ,PARAM21 into \
:b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b1\
7,:b18,:b19,:b20,:b21  from SY_PROG_PARAM where ((UPPER(PGM_ID)='RLRHCRLN' and\
 SESSION_ID=TO_NUMBER(:b22)) and PGM_DATE=:b23)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )66;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_section_ind_1;
   sqlstm.sqhstl[1] = (unsigned int  )7;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_section_1;
   sqlstm.sqhstl[2] = (unsigned int  )5;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_regd_date_fr_1;
   sqlstm.sqhstl[3] = (unsigned int  )33;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_regd_date_to_1;
   sqlstm.sqhstl[4] = (unsigned int  )33;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_spec_type_fr_1;
   sqlstm.sqhstl[5] = (unsigned int  )7;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_spec_type_to_1;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_anatomy_site_fr_1;
   sqlstm.sqhstl[7] = (unsigned int  )7;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_anatomy_site_to_1;
   sqlstm.sqhstl[8] = (unsigned int  )7;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_category_prfx_1;
   sqlstm.sqhstl[9] = (unsigned int  )7;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&nd_search_result_text_1;
   sqlstm.sqhstl[10] = (unsigned int  )4;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&nd_section_ind_2;
   sqlstm.sqhstl[11] = (unsigned int  )7;
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_section_2;
   sqlstm.sqhstl[12] = (unsigned int  )5;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&nd_regd_date_fr_2;
   sqlstm.sqhstl[13] = (unsigned int  )33;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&nd_regd_date_to_2;
   sqlstm.sqhstl[14] = (unsigned int  )33;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_spec_type_fr_2;
   sqlstm.sqhstl[15] = (unsigned int  )7;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&nd_spec_type_to_2;
   sqlstm.sqhstl[16] = (unsigned int  )7;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&nd_anatomy_site_fr_2;
   sqlstm.sqhstl[17] = (unsigned int  )7;
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&nd_anatomy_site_to_2;
   sqlstm.sqhstl[18] = (unsigned int  )7;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&nd_category_prfx_2;
   sqlstm.sqhstl[19] = (unsigned int  )7;
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&nd_search_result_text_2;
   sqlstm.sqhstl[20] = (unsigned int  )4;
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&nd_search_type;
   sqlstm.sqhstl[21] = (unsigned int  )4;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[22] = (unsigned int  )18;
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[23] = (unsigned int  )22;
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



   nd_operating_facility_id.arr[nd_operating_facility_id.len] = '\0';
   nd_section_ind_1.arr[nd_section_ind_1.len]   = '\0';
   nd_section_1.arr[nd_section_1.len]           = '\0';
   nd_regd_date_fr_1.arr[nd_regd_date_fr_1.len] = '\0';
   nd_regd_date_to_1.arr[nd_regd_date_to_1.len] = '\0';
   nd_spec_type_fr_1.arr[nd_spec_type_fr_1.len] = '\0';
   nd_spec_type_to_1.arr[nd_spec_type_to_1.len] = '\0';
   nd_anatomy_site_fr_1.arr[nd_anatomy_site_fr_1.len] = '\0';
   nd_anatomy_site_to_1.arr[nd_anatomy_site_to_1.len] = '\0';
   nd_category_prfx_1.arr[nd_category_prfx_1.len] = '\0';
   nd_search_result_text_1.arr[nd_search_result_text_1.len] = '\0';

   nd_section_ind_2.arr[nd_section_ind_2.len]   = '\0';
   nd_section_2.arr[nd_section_2.len]           = '\0';
   nd_regd_date_fr_2.arr[nd_regd_date_fr_2.len] = '\0';
   nd_regd_date_to_2.arr[nd_regd_date_to_2.len] = '\0';
   nd_spec_type_fr_2.arr[nd_spec_type_fr_2.len] = '\0';
   nd_spec_type_to_2.arr[nd_spec_type_to_2.len] = '\0';
   nd_anatomy_site_fr_2.arr[nd_anatomy_site_fr_2.len] = '\0';
   nd_anatomy_site_to_2.arr[nd_anatomy_site_to_2.len] = '\0';
   nd_category_prfx_2.arr[nd_category_prfx_2.len] = '\0';
   nd_search_result_text_2.arr[nd_search_result_text_2.len] = '\0';
   nd_search_type.arr[nd_search_type.len] = '\0';

#ifdef DEBUG
   printf("**********Parameters from SY_PROG_PARAM *******************\n");
   printf(" nd_section_1       = %s\n",nd_section_1.arr);
   printf(" nd_regd_date_fr_1  = %s\n",nd_regd_date_fr_1.arr);
   printf(" nd_regd_date_to_1  = %s\n",nd_regd_date_to_1.arr);
   printf(" nd_spec_type_fr_1  = %s\n",nd_spec_type_fr_1.arr);
   printf(" nd_spec_type_to_1  = %s\n",nd_spec_type_to_1.arr);
   printf(" nd_anatomy_site_fr_1  = %s\n",nd_anatomy_site_fr_1.arr);
   printf(" nd_anatomy_site_to_1  = %s\n",nd_anatomy_site_to_1.arr);
   printf(" nd_category_prfx_1 = %s\n",nd_category_prfx_1.arr);
   printf(" nd_search_result_text_1 = %s\n",nd_search_result_text_1.arr);
   printf(" nd_section_2       = %s\n",nd_section_2.arr);
   printf(" nd_regd_date_fr_2  = %s\n",nd_regd_date_fr_2.arr);
   printf(" nd_regd_date_to_2  = %s\n",nd_regd_date_to_2.arr);
   printf(" nd_spec_type_fr_2  = %s\n",nd_spec_type_fr_2.arr);
   printf(" nd_spec_type_to_2  = %s\n",nd_spec_type_to_2.arr);
   printf(" nd_anatomy_site_fr_2  = %s\n",nd_anatomy_site_fr_2.arr);
   printf(" nd_anatomy_site_to_2  = %s\n",nd_anatomy_site_to_2.arr);
   printf(" nd_category_prfx_2 = %s\n",nd_category_prfx_2.arr);
   printf(" nd_search_result_text_2 = %s\n",nd_search_result_text_2.arr);
   printf(" nd_search_type = %s\n",nd_search_type.arr);
#endif
  
   /* delete the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


   /* EXEC SQL DELETE SY_PROG_PARAM
	   WHERE UPPER(PGM_ID)  = 'RLRHCRLN'
	         AND SESSION_ID = :nd_session_id
		     AND PGM_DATE   = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((UPPER(PGM_ID)='RLRHCRL\
N' and SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )177;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[0] = (unsigned int  )18;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[1] = (unsigned int  )22;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}


  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )200;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_params() occured....\n");
   proc_exit();
}

/* get the header details */
void get_header_dtls()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


   /* EXEC SQL SELECT ACC_ENTITY_NAME, USER, TO_CHAR(SYSDATE, 'DD/MM/YYYY')
	        INTO :d_acc_entity_name,:d_user,:d_sysdate
            FROM SY_ACC_ENTITY_lang_vw
		    WHERE ACC_ENTITY_ID = :nd_operating_facility_id
			and language_id = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select ACC_ENTITY_NAME ,USER ,TO_CHAR(SYSDATE,'DD/MM/YYYY'\
) into :b0,:b1,:b2  from SY_ACC_ENTITY_lang_vw where (ACC_ENTITY_ID=:b3 and la\
nguage_id=:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )215;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_acc_entity_name;
   sqlstm.sqhstl[0] = (unsigned int  )302;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_user;
   sqlstm.sqhstl[1] = (unsigned int  )23;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_sysdate;
   sqlstm.sqhstl[2] = (unsigned int  )19;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[3] = (unsigned int  )5;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&language_id;
   sqlstm.sqhstl[4] = (unsigned int  )7;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



  d_acc_entity_name.arr[d_acc_entity_name.len] = '\0';
  d_user.arr[d_user.len]                       = '\0';
  d_sysdate.arr[d_sysdate.len]                 = '\0';



#ifdef DEBUG
   printf("d_acc_entity_name = %s\n", d_acc_entity_name.arr);
   printf("d_user = %s\n", d_user.arr);
   printf("d_sysdate = %s\n", d_sysdate.arr);
#endif

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 24;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )250;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_header_dtls() occured....\n");
   proc_exit();
}

/*-----------------------------------*/
//Start Added Code on 15/05/2007 against scf1664 by ramesh

void dclr_request_header_cur()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 



	/* EXEC SQL DECLARE HEADER_CUR CURSOR FOR
	    SELECT * FROM ((SELECT DISTINCT A.PATIENT_ID PATIENT_ID
		--A.CATEGORY_CODE,A.CATEGORY_YEAR,A.CATEGORY_NUMBER
		FROM RL_REQUEST_HEADER A, RL_SAMPLE_DETAILS B
		WHERE A.SPEC_REGD_DATE_TIME > TO_DATE(:nd_regd_date_fr_1, 'DD/MM/YYYY')
		AND	A.SPEC_REGD_DATE_TIME < TO_DATE(:nd_regd_date_to_1, 'DD/MM/YYYY') + 1
		AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND A.SPECIMEN_NO = B.SPECIMEN_NO
		AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
		AND NVL(A.SPECIMEN_TYPE_CODE, '!') BETWEEN NVL(:nd_spec_type_fr_1, NVL(A.SPECIMEN_TYPE_CODE,'!'))
	        AND NVL(:nd_spec_type_to_1, NVL(A.SPECIMEN_TYPE_CODE,'!'))
		AND NVL(B.ANATOMY_SITE_CODE, '!') BETWEEN NVL(:nd_anatomy_site_fr_1, NVL(B.ANATOMY_SITE_CODE,'!'))
  	        AND NVL(:nd_anatomy_site_to_1, NVL(B.ANATOMY_SITE_CODE,'!'))
		AND NVL(A.CATEGORY_CODE,'!') = NVL(:nd_category_prfx_1, NVL(A.CATEGORY_CODE, '!'))
	AND NVL(A.STATUS,'O') != 'O'
		AND A.SECTION_CODE = :nd_section_1
		AND ( ( :nd_search_result_text_1 = 'Y' AND 
	        EXISTS
            (SELECT 'X' 
            FROM   rl_result_text X
            WHERE  X.patient_id = A.patient_id
            AND    X.specimen_no = A.specimen_no
            AND    X.operating_facility_id = A.operating_facility_id
            AND    NVL(X.cancer_register_yn, 'N') = 'Y' 
            )
		  )
          OR
		  (:nd_search_result_text_1 = 'N' AND 1=1)
		)
		UNION
		SELECT DISTINCT A.PATIENT_ID PATIENT_ID
		       --A.CATEGORY_CODE,A.CATEGORY_YEAR,A.CATEGORY_NUMBER
		FROM RL_REQUEST_HEADER A, RL_SPECIMEN_ANATOMY_DTLS B
		WHERE A.SPEC_REGD_DATE_TIME > TO_DATE(:nd_regd_date_fr_1, 'DD/MM/YYYY') AND
			A.SPEC_REGD_DATE_TIME < TO_DATE(:nd_regd_date_to_1, 'DD/MM/YYYY') + 1
		AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND A.SPECIMEN_NO = B.SPECIMEN_NO(+)
		AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID(+)
		AND NVL(A.SPECIMEN_TYPE_CODE, '!') BETWEEN NVL(:nd_spec_type_fr_1, NVL(A.SPECIMEN_TYPE_CODE,'!'))
 	        AND NVL(:nd_spec_type_to_1, NVL(A.SPECIMEN_TYPE_CODE,'!'))
		AND NVL(B.ANATOMY_SITE_CODE, '!') BETWEEN NVL(:nd_anatomy_site_fr_1, NVL(B.ANATOMY_SITE_CODE,'!'))
		AND NVL(:nd_anatomy_site_to_1, NVL(B.ANATOMY_SITE_CODE,'!'))
		AND NVL(A.CATEGORY_CODE,'!') = NVL(:nd_category_prfx_1, NVL(A.CATEGORY_CODE, '!'))
		AND NVL(A.STATUS,'O') != 'O'
		AND A.SECTION_CODE = :nd_section_1
		AND ( ( :nd_search_result_text_1 = 'Y' AND 
	        EXISTS
            (SELECT 'X' 
            FROM   rl_result_text X
            WHERE  X.patient_id = A.patient_id
            AND    X.specimen_no = A.specimen_no
            AND    X.operating_facility_id = A.operating_facility_id
            AND    NVL(X.cancer_register_yn, 'N') = 'Y' 
            )
		  )
          OR
		  (:nd_search_result_text_1 = 'N' AND 1=1)
		)
		)
		INTERSECT
        (SELECT DISTINCT A.PATIENT_ID PATIENT_ID
		--A.CATEGORY_CODE,A.CATEGORY_YEAR,A.CATEGORY_NUMBER
		FROM RL_REQUEST_HEADER A, RL_SAMPLE_DETAILS B
		WHERE A.SPEC_REGD_DATE_TIME > TO_DATE(:nd_regd_date_fr_2, 'DD/MM/YYYY')
		AND	A.SPEC_REGD_DATE_TIME < TO_DATE(:nd_regd_date_to_2, 'DD/MM/YYYY') + 1
		AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND A.SPECIMEN_NO = B.SPECIMEN_NO
		AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
		AND NVL(A.SPECIMEN_TYPE_CODE, '!') BETWEEN NVL(:nd_spec_type_fr_2, NVL(A.SPECIMEN_TYPE_CODE,'!'))
	        AND NVL(:nd_spec_type_to_2, NVL(A.SPECIMEN_TYPE_CODE,'!'))
		AND NVL(B.ANATOMY_SITE_CODE, '!') BETWEEN NVL(:nd_anatomy_site_fr_2, NVL(B.ANATOMY_SITE_CODE,'!'))
  	        AND NVL(:nd_anatomy_site_to_2, NVL(B.ANATOMY_SITE_CODE,'!'))
		AND NVL(A.CATEGORY_CODE,'!') = NVL(:nd_category_prfx_2, NVL(A.CATEGORY_CODE, '!'))
		AND NVL(A.STATUS,'O') != 'O'
		AND A.SECTION_CODE = :nd_section_2
		AND ( ( :nd_search_result_text_2 = 'Y' AND 
	        EXISTS
            (SELECT 'X' 
            FROM   rl_result_text X
            WHERE  X.patient_id = A.patient_id
            AND    X.specimen_no = A.specimen_no
            AND    X.operating_facility_id = A.operating_facility_id
            AND    NVL(X.cancer_register_yn, 'N') = 'Y' 
            )
		  )
          OR
		  (:nd_search_result_text_2 = 'N' AND 1=1)
		)
		UNION
		SELECT DISTINCT A.PATIENT_ID PATIENT_ID
		       --A.CATEGORY_CODE,A.CATEGORY_YEAR,A.CATEGORY_NUMBER
		FROM RL_REQUEST_HEADER A, RL_SPECIMEN_ANATOMY_DTLS B
		WHERE A.SPEC_REGD_DATE_TIME > TO_DATE(:nd_regd_date_fr_2, 'DD/MM/YYYY') AND
			A.SPEC_REGD_DATE_TIME < TO_DATE(:nd_regd_date_to_2, 'DD/MM/YYYY') + 1
		AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND A.SPECIMEN_NO = B.SPECIMEN_NO(+)
		AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID(+)
		AND NVL(A.SPECIMEN_TYPE_CODE, '!') BETWEEN NVL(:nd_spec_type_fr_2, NVL(A.SPECIMEN_TYPE_CODE,'!'))
 	        AND NVL(:nd_spec_type_to_2, NVL(A.SPECIMEN_TYPE_CODE,'!'))
		AND NVL(B.ANATOMY_SITE_CODE, '!') BETWEEN NVL(:nd_anatomy_site_fr_2, NVL(B.ANATOMY_SITE_CODE,'!'))
		AND NVL(:nd_anatomy_site_to_2, NVL(B.ANATOMY_SITE_CODE,'!'))
		AND NVL(A.CATEGORY_CODE,'!') = NVL(:nd_category_prfx_2, NVL(A.CATEGORY_CODE, '!'))
	AND NVL(A.STATUS,'O') != 'O'
		AND A.SECTION_CODE = :nd_section_2 AND ( ( :nd_search_result_text_2 = 'Y' AND 
	        EXISTS
            (SELECT 'X' 
            FROM   rl_result_text X
            WHERE  X.patient_id = A.patient_id
            AND    X.specimen_no = A.specimen_no
            AND    X.operating_facility_id = A.operating_facility_id
            AND    NVL(X.cancer_register_yn, 'N') = 'Y' 
            )
		  )
          OR
		  (:nd_search_result_text_2 = 'N' AND 1=1)
		))) ORDER BY 1; */ 


		
		

	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL OPEN HEADER_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 44;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select *  from ((select distinct A.PATIENT_ID PATIENT_ID  from RL_REQUES\
T_HEADER A ,RL_SAMPLE_DETAILS B where ((((((((((A.SPEC_REGD_DATE_TIME>TO_DAT\
E(:b0,'DD/MM/YYYY') and A.SPEC_REGD_DATE_TIME<(TO_DATE(:b1,'DD/MM/YYYY')+1))\
 and A.OPERATING_FACILITY_ID=:b2) and A.SPECIMEN_NO=B.SPECIMEN_NO) and A.OPE\
RATING_FACILITY_ID=B.OPERATING_FACILITY_ID) and NVL(A.SPECIMEN_TYPE_CODE,'!'\
) between NVL(:b3,NVL(A.SPECIMEN_TYPE_CODE,'!')) and NVL(:b4,NVL(A.SPECIMEN_\
TYPE_CODE,'!'))) and NVL(B.ANATOMY_SITE_CODE,'!') between NVL(:b5,NVL(B.ANAT\
OMY_SITE_CODE,'!')) and NVL(:b6,NVL(B.ANATOMY_SITE_CODE,'!'))) and NVL(A.CAT\
EGORY_CODE,'!')=NVL(:b7,NVL(A.CATEGORY_CODE,'!'))) and NVL(A.STATUS,'O')<>'O\
') and A.SECTION_CODE=:b8) and ((:b9='Y' and exists (select 'X'  from rl_res\
ult_text X where (((X.patient_id=A.patient_id and X.specimen_no=A.specimen_n\
o) and X.operating_facility_id=A.operating_facility_id) and NVL(X.cancer_reg\
ister_yn,'N')='Y'))) or (:b9='N' and 1=1))) union select distinct A.PATIENT_\
ID PATIENT_ID  from RL_REQUEST_HEADER A ");
 sqlbuft((void **)0, 
   ",RL_SPECIMEN_ANATOMY_DTLS B where ((((((((((A.SPEC_REGD_DATE_TIME>TO_DAT\
E(:b0,'DD/MM/YYYY') and A.SPEC_REGD_DATE_TIME<(TO_DATE(:b1,'DD/MM/YYYY')+1))\
 and A.OPERATING_FACILITY_ID=:b2) and A.SPECIMEN_NO=B.SPECIMEN_NO(+)) and A.\
OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID(+)) and NVL(A.SPECIMEN_TYPE_CO\
DE,'!') between NVL(:b3,NVL(A.SPECIMEN_TYPE_CODE,'!')) and NVL(:b4,NVL(A.SPE\
CIMEN_TYPE_CODE,'!'))) and NVL(B.ANATOMY_SITE_CODE,'!') between NVL(:b5,NVL(\
B.ANATOMY_SITE_CODE,'!')) and NVL(:b6,NVL(B.ANATOMY_SITE_CODE,'!'))) and NVL\
(A.CATEGORY_CODE,'!')=NVL(:b7,NVL(A.CATEGORY_CODE,'!'))) and NVL(A.STATUS,'O\
')<>'O') and A.SECTION_CODE=:b8) and ((:b9='Y' and exists (select 'X'  from \
rl_result_text X where (((X.patient_id=A.patient_id and X.specimen_no=A.spec\
imen_no) and X.operating_facility_id=A.operating_facility_id) and NVL(X.canc\
er_register_yn,'N')='Y'))) or (:b9='N' and 1=1)))) intersect (select distinc\
t A.PATIENT_ID PATIENT_ID  from RL_REQUEST_HEADER A ,RL_SAMPLE_DETAILS B whe\
re ((((((((((A.SPEC_REGD_DATE_TIME>TO_DA");
 sqlbuft((void **)0, 
   "TE(:b22,'DD/MM/YYYY') and A.SPEC_REGD_DATE_TIME<(TO_DATE(:b23,'DD/MM/YYY\
Y')+1)) and A.OPERATING_FACILITY_ID=:b2) and A.SPECIMEN_NO=B.SPECIMEN_NO) an\
d A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID) and NVL(A.SPECIMEN_TYPE_C\
ODE,'!') between NVL(:b25,NVL(A.SPECIMEN_TYPE_CODE,'!')) and NVL(:b26,NVL(A.\
SPECIMEN_TYPE_CODE,'!'))) and NVL(B.ANATOMY_SITE_CODE,'!') between NVL(:b27,\
NVL(B.ANATOMY_SITE_CODE,'!')) and NVL(:b28,NVL(B.ANATOMY_SITE_CODE,'!'))) an\
d NVL(A.CATEGORY_CODE,'!')=NVL(:b29,NVL(A.CATEGORY_CODE,'!'))) and NVL(A.STA\
TUS,'O')<>'O') and A.SECTION_CODE=:b30) and ((:b31='Y' and exists (select 'X\
'  from rl_result_text X where (((X.patient_id=A.patient_id and X.specimen_n\
o=A.specimen_no) and X.operating_facility_id=A.operating_facility_id) and NV\
L(X.cancer_register_yn,'N')='Y'))) or (:b31='N' and 1=1))) union select dist\
inct A.PATIENT_ID PATIENT_ID  from RL_REQUEST_HEADER A ,RL_SPECIMEN_ANATOMY_\
DTLS B where ((((((((((A.SPEC_REGD_DATE_TIME>TO_DATE(:b22,'DD/MM/YYYY') and \
A.SPEC_REGD_DATE_TIME<(TO_DATE(:b23,'DD/");
 sqlstm.stmt = sq0009;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )265;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_regd_date_fr_1;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_regd_date_to_1;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_spec_type_fr_1;
 sqlstm.sqhstl[3] = (unsigned int  )7;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_spec_type_to_1;
 sqlstm.sqhstl[4] = (unsigned int  )7;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_anatomy_site_fr_1;
 sqlstm.sqhstl[5] = (unsigned int  )7;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_anatomy_site_to_1;
 sqlstm.sqhstl[6] = (unsigned int  )7;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_category_prfx_1;
 sqlstm.sqhstl[7] = (unsigned int  )7;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_section_1;
 sqlstm.sqhstl[8] = (unsigned int  )5;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_search_result_text_1;
 sqlstm.sqhstl[9] = (unsigned int  )4;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&nd_search_result_text_1;
 sqlstm.sqhstl[10] = (unsigned int  )4;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&nd_regd_date_fr_1;
 sqlstm.sqhstl[11] = (unsigned int  )33;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&nd_regd_date_to_1;
 sqlstm.sqhstl[12] = (unsigned int  )33;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[13] = (unsigned int  )5;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&nd_spec_type_fr_1;
 sqlstm.sqhstl[14] = (unsigned int  )7;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&nd_spec_type_to_1;
 sqlstm.sqhstl[15] = (unsigned int  )7;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&nd_anatomy_site_fr_1;
 sqlstm.sqhstl[16] = (unsigned int  )7;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&nd_anatomy_site_to_1;
 sqlstm.sqhstl[17] = (unsigned int  )7;
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&nd_category_prfx_1;
 sqlstm.sqhstl[18] = (unsigned int  )7;
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)&nd_section_1;
 sqlstm.sqhstl[19] = (unsigned int  )5;
 sqlstm.sqhsts[19] = (         int  )0;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqhstv[20] = (         void  *)&nd_search_result_text_1;
 sqlstm.sqhstl[20] = (unsigned int  )4;
 sqlstm.sqhsts[20] = (         int  )0;
 sqlstm.sqindv[20] = (         void  *)0;
 sqlstm.sqinds[20] = (         int  )0;
 sqlstm.sqharm[20] = (unsigned int  )0;
 sqlstm.sqadto[20] = (unsigned short )0;
 sqlstm.sqtdso[20] = (unsigned short )0;
 sqlstm.sqhstv[21] = (         void  *)&nd_search_result_text_1;
 sqlstm.sqhstl[21] = (unsigned int  )4;
 sqlstm.sqhsts[21] = (         int  )0;
 sqlstm.sqindv[21] = (         void  *)0;
 sqlstm.sqinds[21] = (         int  )0;
 sqlstm.sqharm[21] = (unsigned int  )0;
 sqlstm.sqadto[21] = (unsigned short )0;
 sqlstm.sqtdso[21] = (unsigned short )0;
 sqlstm.sqhstv[22] = (         void  *)&nd_regd_date_fr_2;
 sqlstm.sqhstl[22] = (unsigned int  )33;
 sqlstm.sqhsts[22] = (         int  )0;
 sqlstm.sqindv[22] = (         void  *)0;
 sqlstm.sqinds[22] = (         int  )0;
 sqlstm.sqharm[22] = (unsigned int  )0;
 sqlstm.sqadto[22] = (unsigned short )0;
 sqlstm.sqtdso[22] = (unsigned short )0;
 sqlstm.sqhstv[23] = (         void  *)&nd_regd_date_to_2;
 sqlstm.sqhstl[23] = (unsigned int  )33;
 sqlstm.sqhsts[23] = (         int  )0;
 sqlstm.sqindv[23] = (         void  *)0;
 sqlstm.sqinds[23] = (         int  )0;
 sqlstm.sqharm[23] = (unsigned int  )0;
 sqlstm.sqadto[23] = (unsigned short )0;
 sqlstm.sqtdso[23] = (unsigned short )0;
 sqlstm.sqhstv[24] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[24] = (unsigned int  )5;
 sqlstm.sqhsts[24] = (         int  )0;
 sqlstm.sqindv[24] = (         void  *)0;
 sqlstm.sqinds[24] = (         int  )0;
 sqlstm.sqharm[24] = (unsigned int  )0;
 sqlstm.sqadto[24] = (unsigned short )0;
 sqlstm.sqtdso[24] = (unsigned short )0;
 sqlstm.sqhstv[25] = (         void  *)&nd_spec_type_fr_2;
 sqlstm.sqhstl[25] = (unsigned int  )7;
 sqlstm.sqhsts[25] = (         int  )0;
 sqlstm.sqindv[25] = (         void  *)0;
 sqlstm.sqinds[25] = (         int  )0;
 sqlstm.sqharm[25] = (unsigned int  )0;
 sqlstm.sqadto[25] = (unsigned short )0;
 sqlstm.sqtdso[25] = (unsigned short )0;
 sqlstm.sqhstv[26] = (         void  *)&nd_spec_type_to_2;
 sqlstm.sqhstl[26] = (unsigned int  )7;
 sqlstm.sqhsts[26] = (         int  )0;
 sqlstm.sqindv[26] = (         void  *)0;
 sqlstm.sqinds[26] = (         int  )0;
 sqlstm.sqharm[26] = (unsigned int  )0;
 sqlstm.sqadto[26] = (unsigned short )0;
 sqlstm.sqtdso[26] = (unsigned short )0;
 sqlstm.sqhstv[27] = (         void  *)&nd_anatomy_site_fr_2;
 sqlstm.sqhstl[27] = (unsigned int  )7;
 sqlstm.sqhsts[27] = (         int  )0;
 sqlstm.sqindv[27] = (         void  *)0;
 sqlstm.sqinds[27] = (         int  )0;
 sqlstm.sqharm[27] = (unsigned int  )0;
 sqlstm.sqadto[27] = (unsigned short )0;
 sqlstm.sqtdso[27] = (unsigned short )0;
 sqlstm.sqhstv[28] = (         void  *)&nd_anatomy_site_to_2;
 sqlstm.sqhstl[28] = (unsigned int  )7;
 sqlstm.sqhsts[28] = (         int  )0;
 sqlstm.sqindv[28] = (         void  *)0;
 sqlstm.sqinds[28] = (         int  )0;
 sqlstm.sqharm[28] = (unsigned int  )0;
 sqlstm.sqadto[28] = (unsigned short )0;
 sqlstm.sqtdso[28] = (unsigned short )0;
 sqlstm.sqhstv[29] = (         void  *)&nd_category_prfx_2;
 sqlstm.sqhstl[29] = (unsigned int  )7;
 sqlstm.sqhsts[29] = (         int  )0;
 sqlstm.sqindv[29] = (         void  *)0;
 sqlstm.sqinds[29] = (         int  )0;
 sqlstm.sqharm[29] = (unsigned int  )0;
 sqlstm.sqadto[29] = (unsigned short )0;
 sqlstm.sqtdso[29] = (unsigned short )0;
 sqlstm.sqhstv[30] = (         void  *)&nd_section_2;
 sqlstm.sqhstl[30] = (unsigned int  )5;
 sqlstm.sqhsts[30] = (         int  )0;
 sqlstm.sqindv[30] = (         void  *)0;
 sqlstm.sqinds[30] = (         int  )0;
 sqlstm.sqharm[30] = (unsigned int  )0;
 sqlstm.sqadto[30] = (unsigned short )0;
 sqlstm.sqtdso[30] = (unsigned short )0;
 sqlstm.sqhstv[31] = (         void  *)&nd_search_result_text_2;
 sqlstm.sqhstl[31] = (unsigned int  )4;
 sqlstm.sqhsts[31] = (         int  )0;
 sqlstm.sqindv[31] = (         void  *)0;
 sqlstm.sqinds[31] = (         int  )0;
 sqlstm.sqharm[31] = (unsigned int  )0;
 sqlstm.sqadto[31] = (unsigned short )0;
 sqlstm.sqtdso[31] = (unsigned short )0;
 sqlstm.sqhstv[32] = (         void  *)&nd_search_result_text_2;
 sqlstm.sqhstl[32] = (unsigned int  )4;
 sqlstm.sqhsts[32] = (         int  )0;
 sqlstm.sqindv[32] = (         void  *)0;
 sqlstm.sqinds[32] = (         int  )0;
 sqlstm.sqharm[32] = (unsigned int  )0;
 sqlstm.sqadto[32] = (unsigned short )0;
 sqlstm.sqtdso[32] = (unsigned short )0;
 sqlstm.sqhstv[33] = (         void  *)&nd_regd_date_fr_2;
 sqlstm.sqhstl[33] = (unsigned int  )33;
 sqlstm.sqhsts[33] = (         int  )0;
 sqlstm.sqindv[33] = (         void  *)0;
 sqlstm.sqinds[33] = (         int  )0;
 sqlstm.sqharm[33] = (unsigned int  )0;
 sqlstm.sqadto[33] = (unsigned short )0;
 sqlstm.sqtdso[33] = (unsigned short )0;
 sqlstm.sqhstv[34] = (         void  *)&nd_regd_date_to_2;
 sqlstm.sqhstl[34] = (unsigned int  )33;
 sqlstm.sqhsts[34] = (         int  )0;
 sqlstm.sqindv[34] = (         void  *)0;
 sqlstm.sqinds[34] = (         int  )0;
 sqlstm.sqharm[34] = (unsigned int  )0;
 sqlstm.sqadto[34] = (unsigned short )0;
 sqlstm.sqtdso[34] = (unsigned short )0;
 sqlstm.sqhstv[35] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[35] = (unsigned int  )5;
 sqlstm.sqhsts[35] = (         int  )0;
 sqlstm.sqindv[35] = (         void  *)0;
 sqlstm.sqinds[35] = (         int  )0;
 sqlstm.sqharm[35] = (unsigned int  )0;
 sqlstm.sqadto[35] = (unsigned short )0;
 sqlstm.sqtdso[35] = (unsigned short )0;
 sqlstm.sqhstv[36] = (         void  *)&nd_spec_type_fr_2;
 sqlstm.sqhstl[36] = (unsigned int  )7;
 sqlstm.sqhsts[36] = (         int  )0;
 sqlstm.sqindv[36] = (         void  *)0;
 sqlstm.sqinds[36] = (         int  )0;
 sqlstm.sqharm[36] = (unsigned int  )0;
 sqlstm.sqadto[36] = (unsigned short )0;
 sqlstm.sqtdso[36] = (unsigned short )0;
 sqlstm.sqhstv[37] = (         void  *)&nd_spec_type_to_2;
 sqlstm.sqhstl[37] = (unsigned int  )7;
 sqlstm.sqhsts[37] = (         int  )0;
 sqlstm.sqindv[37] = (         void  *)0;
 sqlstm.sqinds[37] = (         int  )0;
 sqlstm.sqharm[37] = (unsigned int  )0;
 sqlstm.sqadto[37] = (unsigned short )0;
 sqlstm.sqtdso[37] = (unsigned short )0;
 sqlstm.sqhstv[38] = (         void  *)&nd_anatomy_site_fr_2;
 sqlstm.sqhstl[38] = (unsigned int  )7;
 sqlstm.sqhsts[38] = (         int  )0;
 sqlstm.sqindv[38] = (         void  *)0;
 sqlstm.sqinds[38] = (         int  )0;
 sqlstm.sqharm[38] = (unsigned int  )0;
 sqlstm.sqadto[38] = (unsigned short )0;
 sqlstm.sqtdso[38] = (unsigned short )0;
 sqlstm.sqhstv[39] = (         void  *)&nd_anatomy_site_to_2;
 sqlstm.sqhstl[39] = (unsigned int  )7;
 sqlstm.sqhsts[39] = (         int  )0;
 sqlstm.sqindv[39] = (         void  *)0;
 sqlstm.sqinds[39] = (         int  )0;
 sqlstm.sqharm[39] = (unsigned int  )0;
 sqlstm.sqadto[39] = (unsigned short )0;
 sqlstm.sqtdso[39] = (unsigned short )0;
 sqlstm.sqhstv[40] = (         void  *)&nd_category_prfx_2;
 sqlstm.sqhstl[40] = (unsigned int  )7;
 sqlstm.sqhsts[40] = (         int  )0;
 sqlstm.sqindv[40] = (         void  *)0;
 sqlstm.sqinds[40] = (         int  )0;
 sqlstm.sqharm[40] = (unsigned int  )0;
 sqlstm.sqadto[40] = (unsigned short )0;
 sqlstm.sqtdso[40] = (unsigned short )0;
 sqlstm.sqhstv[41] = (         void  *)&nd_section_2;
 sqlstm.sqhstl[41] = (unsigned int  )5;
 sqlstm.sqhsts[41] = (         int  )0;
 sqlstm.sqindv[41] = (         void  *)0;
 sqlstm.sqinds[41] = (         int  )0;
 sqlstm.sqharm[41] = (unsigned int  )0;
 sqlstm.sqadto[41] = (unsigned short )0;
 sqlstm.sqtdso[41] = (unsigned short )0;
 sqlstm.sqhstv[42] = (         void  *)&nd_search_result_text_2;
 sqlstm.sqhstl[42] = (unsigned int  )4;
 sqlstm.sqhsts[42] = (         int  )0;
 sqlstm.sqindv[42] = (         void  *)0;
 sqlstm.sqinds[42] = (         int  )0;
 sqlstm.sqharm[42] = (unsigned int  )0;
 sqlstm.sqadto[42] = (unsigned short )0;
 sqlstm.sqtdso[42] = (unsigned short )0;
 sqlstm.sqhstv[43] = (         void  *)&nd_search_result_text_2;
 sqlstm.sqhstl[43] = (unsigned int  )4;
 sqlstm.sqhsts[43] = (         int  )0;
 sqlstm.sqindv[43] = (         void  *)0;
 sqlstm.sqinds[43] = (         int  )0;
 sqlstm.sqharm[43] = (unsigned int  )0;
 sqlstm.sqadto[43] = (unsigned short )0;
 sqlstm.sqtdso[43] = (unsigned short )0;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}


	return;
err_exit:

	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 44;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )456;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	disp_message(ORA_MESG,"Oracle error at dclr_request_header_cur() occured....\n");
	proc_exit();
}
/*_______________________________*/

//End Added Code on 15/05/2007 against scf1664 by ramesh
//start added on 30/10/2007 against the ML-SD-SCF-1972 
void dclr_request_header_cur_bb()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 



	/* EXEC SQL DECLARE HEADER_CUR_bb CURSOR FOR
	    SELECT * FROM ((SELECT DISTINCT A.PATIENT_ID PATIENT_ID
		--A.CATEGORY_CODE,A.CATEGORY_YEAR,A.CATEGORY_NUMBER
		FROM RL_REQUEST_HEADER A, RL_SAMPLE_DETAILS B
		WHERE A.SPEC_REGD_DATE_TIME > TO_DATE(:nd_regd_date_fr_1, 'DD/MM/YYYY')
		AND	A.SPEC_REGD_DATE_TIME < TO_DATE(:nd_regd_date_to_1, 'DD/MM/YYYY') + 1
		AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND A.SPECIMEN_NO = B.SPECIMEN_NO
		AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
		AND NVL(A.SPECIMEN_TYPE_CODE, '!') BETWEEN NVL(:nd_spec_type_fr_1, NVL(A.SPECIMEN_TYPE_CODE,'!'))
	        AND NVL(:nd_spec_type_to_1, NVL(A.SPECIMEN_TYPE_CODE,'!'))
		AND NVL(B.ANATOMY_SITE_CODE, '!') BETWEEN NVL(:nd_anatomy_site_fr_1, NVL(B.ANATOMY_SITE_CODE,'!'))
  	        AND NVL(:nd_anatomy_site_to_1, NVL(B.ANATOMY_SITE_CODE,'!'))
		AND NVL(A.CATEGORY_CODE,'!') = NVL(:nd_category_prfx_1, NVL(A.CATEGORY_CODE, '!'))
	AND NVL(A.STATUS,'O') != 'O'
		AND A.SECTION_CODE = :nd_section_1
		AND ( ( :nd_search_result_text_1 = 'Y' AND 
	        EXISTS
            (SELECT 'X' 
            FROM   rl_result_text X
            WHERE  X.patient_id = A.patient_id
            AND    X.specimen_no = A.specimen_no
            AND    X.operating_facility_id = A.operating_facility_id
            AND    NVL(X.cancer_register_yn, 'N') = 'Y' 
            )
		  )
          OR
		  (:nd_search_result_text_1 = 'N' AND 1=1)
		)
		UNION
		SELECT DISTINCT A.PATIENT_ID PATIENT_ID
		       --A.CATEGORY_CODE,A.CATEGORY_YEAR,A.CATEGORY_NUMBER
		FROM RL_REQUEST_HEADER A, RL_SPECIMEN_ANATOMY_DTLS B
		WHERE A.SPEC_REGD_DATE_TIME > TO_DATE(:nd_regd_date_fr_1, 'DD/MM/YYYY') AND
			A.SPEC_REGD_DATE_TIME < TO_DATE(:nd_regd_date_to_1, 'DD/MM/YYYY') + 1
		AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND A.SPECIMEN_NO = B.SPECIMEN_NO(+)
		AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID(+)
		AND NVL(A.SPECIMEN_TYPE_CODE, '!') BETWEEN NVL(:nd_spec_type_fr_1, NVL(A.SPECIMEN_TYPE_CODE,'!'))
 	        AND NVL(:nd_spec_type_to_1, NVL(A.SPECIMEN_TYPE_CODE,'!'))
		AND NVL(B.ANATOMY_SITE_CODE, '!') BETWEEN NVL(:nd_anatomy_site_fr_1, NVL(B.ANATOMY_SITE_CODE,'!'))
		AND NVL(:nd_anatomy_site_to_1, NVL(B.ANATOMY_SITE_CODE,'!'))
		AND NVL(A.CATEGORY_CODE,'!') = NVL(:nd_category_prfx_1, NVL(A.CATEGORY_CODE, '!'))
		AND NVL(A.STATUS,'O') != 'O'
		AND A.SECTION_CODE = :nd_section_1
		AND ( ( :nd_search_result_text_1 = 'Y' AND 
	        EXISTS
            (SELECT 'X' 
            FROM   rl_result_text X
            WHERE  X.patient_id = A.patient_id
            AND    X.specimen_no = A.specimen_no
            AND    X.operating_facility_id = A.operating_facility_id
            AND    NVL(X.cancer_register_yn, 'N') = 'Y' 
            )
		  )
          OR
		  (:nd_search_result_text_1 = 'N' AND 1=1)
		)
		)
		union
        (SELECT DISTINCT A.PATIENT_ID PATIENT_ID
		--A.CATEGORY_CODE,A.CATEGORY_YEAR,A.CATEGORY_NUMBER
		FROM RL_REQUEST_HEADER A, RL_SAMPLE_DETAILS B
		WHERE A.SPEC_REGD_DATE_TIME > TO_DATE(:nd_regd_date_fr_2, 'DD/MM/YYYY')
		AND	A.SPEC_REGD_DATE_TIME < TO_DATE(:nd_regd_date_to_2, 'DD/MM/YYYY') + 1
		AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND A.SPECIMEN_NO = B.SPECIMEN_NO
		AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
		AND NVL(A.SPECIMEN_TYPE_CODE, '!') BETWEEN NVL(:nd_spec_type_fr_2, NVL(A.SPECIMEN_TYPE_CODE,'!'))
	        AND NVL(:nd_spec_type_to_2, NVL(A.SPECIMEN_TYPE_CODE,'!'))
		AND NVL(B.ANATOMY_SITE_CODE, '!') BETWEEN NVL(:nd_anatomy_site_fr_2, NVL(B.ANATOMY_SITE_CODE,'!'))
  	        AND NVL(:nd_anatomy_site_to_2, NVL(B.ANATOMY_SITE_CODE,'!'))
		AND NVL(A.CATEGORY_CODE,'!') = NVL(:nd_category_prfx_2, NVL(A.CATEGORY_CODE, '!'))
		AND NVL(A.STATUS,'O') != 'O'
		AND A.SECTION_CODE = :nd_section_2
		AND ( ( :nd_search_result_text_2 = 'Y' AND 
	        EXISTS
            (SELECT 'X' 
            FROM   rl_result_text X
            WHERE  X.patient_id = A.patient_id
            AND    X.specimen_no = A.specimen_no
            AND    X.operating_facility_id = A.operating_facility_id
            AND    NVL(X.cancer_register_yn, 'N') = 'Y' 
            )
		  )
          OR
		  (:nd_search_result_text_2 = 'N' AND 1=1)
		)
		UNION
		SELECT DISTINCT A.PATIENT_ID PATIENT_ID
		       --A.CATEGORY_CODE,A.CATEGORY_YEAR,A.CATEGORY_NUMBER
		FROM RL_REQUEST_HEADER A, RL_SPECIMEN_ANATOMY_DTLS B
		WHERE A.SPEC_REGD_DATE_TIME > TO_DATE(:nd_regd_date_fr_2, 'DD/MM/YYYY') AND
			A.SPEC_REGD_DATE_TIME < TO_DATE(:nd_regd_date_to_2, 'DD/MM/YYYY') + 1
		AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND A.SPECIMEN_NO = B.SPECIMEN_NO(+)
		AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID(+)
		AND NVL(A.SPECIMEN_TYPE_CODE, '!') BETWEEN NVL(:nd_spec_type_fr_2, NVL(A.SPECIMEN_TYPE_CODE,'!'))
 	        AND NVL(:nd_spec_type_to_2, NVL(A.SPECIMEN_TYPE_CODE,'!'))
		AND NVL(B.ANATOMY_SITE_CODE, '!') BETWEEN NVL(:nd_anatomy_site_fr_2, NVL(B.ANATOMY_SITE_CODE,'!'))
		AND NVL(:nd_anatomy_site_to_2, NVL(B.ANATOMY_SITE_CODE,'!'))
		AND NVL(A.CATEGORY_CODE,'!') = NVL(:nd_category_prfx_2, NVL(A.CATEGORY_CODE, '!'))
	AND NVL(A.STATUS,'O') != 'O'
		AND A.SECTION_CODE = :nd_section_2 AND ( ( :nd_search_result_text_2 = 'Y' AND 
	        EXISTS
            (SELECT 'X' 
            FROM   rl_result_text X
            WHERE  X.patient_id = A.patient_id
            AND    X.specimen_no = A.specimen_no
            AND    X.operating_facility_id = A.operating_facility_id
            AND    NVL(X.cancer_register_yn, 'N') = 'Y' 
            )
		  )
          OR
		  (:nd_search_result_text_2 = 'N' AND 1=1)
		))) ORDER BY 1; */ 


		
		

	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL OPEN HEADER_CUR_bb; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 44;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select *  from ((select distinct A.PATIENT_ID PATIENT_ID  from RL_REQUES\
T_HEADER A ,RL_SAMPLE_DETAILS B where ((((((((((A.SPEC_REGD_DATE_TIME>TO_DAT\
E(:b0,'DD/MM/YYYY') and A.SPEC_REGD_DATE_TIME<(TO_DATE(:b1,'DD/MM/YYYY')+1))\
 and A.OPERATING_FACILITY_ID=:b2) and A.SPECIMEN_NO=B.SPECIMEN_NO) and A.OPE\
RATING_FACILITY_ID=B.OPERATING_FACILITY_ID) and NVL(A.SPECIMEN_TYPE_CODE,'!'\
) between NVL(:b3,NVL(A.SPECIMEN_TYPE_CODE,'!')) and NVL(:b4,NVL(A.SPECIMEN_\
TYPE_CODE,'!'))) and NVL(B.ANATOMY_SITE_CODE,'!') between NVL(:b5,NVL(B.ANAT\
OMY_SITE_CODE,'!')) and NVL(:b6,NVL(B.ANATOMY_SITE_CODE,'!'))) and NVL(A.CAT\
EGORY_CODE,'!')=NVL(:b7,NVL(A.CATEGORY_CODE,'!'))) and NVL(A.STATUS,'O')<>'O\
') and A.SECTION_CODE=:b8) and ((:b9='Y' and exists (select 'X'  from rl_res\
ult_text X where (((X.patient_id=A.patient_id and X.specimen_no=A.specimen_n\
o) and X.operating_facility_id=A.operating_facility_id) and NVL(X.cancer_reg\
ister_yn,'N')='Y'))) or (:b9='N' and 1=1))) union select distinct A.PATIENT_\
ID PATIENT_ID  from RL_REQUEST_HEADER A ");
 sqlbuft((void **)0, 
   ",RL_SPECIMEN_ANATOMY_DTLS B where ((((((((((A.SPEC_REGD_DATE_TIME>TO_DAT\
E(:b0,'DD/MM/YYYY') and A.SPEC_REGD_DATE_TIME<(TO_DATE(:b1,'DD/MM/YYYY')+1))\
 and A.OPERATING_FACILITY_ID=:b2) and A.SPECIMEN_NO=B.SPECIMEN_NO(+)) and A.\
OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID(+)) and NVL(A.SPECIMEN_TYPE_CO\
DE,'!') between NVL(:b3,NVL(A.SPECIMEN_TYPE_CODE,'!')) and NVL(:b4,NVL(A.SPE\
CIMEN_TYPE_CODE,'!'))) and NVL(B.ANATOMY_SITE_CODE,'!') between NVL(:b5,NVL(\
B.ANATOMY_SITE_CODE,'!')) and NVL(:b6,NVL(B.ANATOMY_SITE_CODE,'!'))) and NVL\
(A.CATEGORY_CODE,'!')=NVL(:b7,NVL(A.CATEGORY_CODE,'!'))) and NVL(A.STATUS,'O\
')<>'O') and A.SECTION_CODE=:b8) and ((:b9='Y' and exists (select 'X'  from \
rl_result_text X where (((X.patient_id=A.patient_id and X.specimen_no=A.spec\
imen_no) and X.operating_facility_id=A.operating_facility_id) and NVL(X.canc\
er_register_yn,'N')='Y'))) or (:b9='N' and 1=1)))) union (select distinct A.\
PATIENT_ID PATIENT_ID  from RL_REQUEST_HEADER A ,RL_SAMPLE_DETAILS B where (\
(((((((((A.SPEC_REGD_DATE_TIME>TO_DATE(:");
 sqlbuft((void **)0, 
   "b22,'DD/MM/YYYY') and A.SPEC_REGD_DATE_TIME<(TO_DATE(:b23,'DD/MM/YYYY')+\
1)) and A.OPERATING_FACILITY_ID=:b2) and A.SPECIMEN_NO=B.SPECIMEN_NO) and A.\
OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID) and NVL(A.SPECIMEN_TYPE_CODE,\
'!') between NVL(:b25,NVL(A.SPECIMEN_TYPE_CODE,'!')) and NVL(:b26,NVL(A.SPEC\
IMEN_TYPE_CODE,'!'))) and NVL(B.ANATOMY_SITE_CODE,'!') between NVL(:b27,NVL(\
B.ANATOMY_SITE_CODE,'!')) and NVL(:b28,NVL(B.ANATOMY_SITE_CODE,'!'))) and NV\
L(A.CATEGORY_CODE,'!')=NVL(:b29,NVL(A.CATEGORY_CODE,'!'))) and NVL(A.STATUS,\
'O')<>'O') and A.SECTION_CODE=:b30) and ((:b31='Y' and exists (select 'X'  f\
rom rl_result_text X where (((X.patient_id=A.patient_id and X.specimen_no=A.\
specimen_no) and X.operating_facility_id=A.operating_facility_id) and NVL(X.\
cancer_register_yn,'N')='Y'))) or (:b31='N' and 1=1))) union select distinct\
 A.PATIENT_ID PATIENT_ID  from RL_REQUEST_HEADER A ,RL_SPECIMEN_ANATOMY_DTLS\
 B where ((((((((((A.SPEC_REGD_DATE_TIME>TO_DATE(:b22,'DD/MM/YYYY') and A.SP\
EC_REGD_DATE_TIME<(TO_DATE(:b23,'DD/MM/Y");
 sqlstm.stmt = sq0011;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )471;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_regd_date_fr_1;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_regd_date_to_1;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&nd_spec_type_fr_1;
 sqlstm.sqhstl[3] = (unsigned int  )7;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_spec_type_to_1;
 sqlstm.sqhstl[4] = (unsigned int  )7;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_anatomy_site_fr_1;
 sqlstm.sqhstl[5] = (unsigned int  )7;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_anatomy_site_to_1;
 sqlstm.sqhstl[6] = (unsigned int  )7;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_category_prfx_1;
 sqlstm.sqhstl[7] = (unsigned int  )7;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_section_1;
 sqlstm.sqhstl[8] = (unsigned int  )5;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_search_result_text_1;
 sqlstm.sqhstl[9] = (unsigned int  )4;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&nd_search_result_text_1;
 sqlstm.sqhstl[10] = (unsigned int  )4;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&nd_regd_date_fr_1;
 sqlstm.sqhstl[11] = (unsigned int  )33;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&nd_regd_date_to_1;
 sqlstm.sqhstl[12] = (unsigned int  )33;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[13] = (unsigned int  )5;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&nd_spec_type_fr_1;
 sqlstm.sqhstl[14] = (unsigned int  )7;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&nd_spec_type_to_1;
 sqlstm.sqhstl[15] = (unsigned int  )7;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&nd_anatomy_site_fr_1;
 sqlstm.sqhstl[16] = (unsigned int  )7;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&nd_anatomy_site_to_1;
 sqlstm.sqhstl[17] = (unsigned int  )7;
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&nd_category_prfx_1;
 sqlstm.sqhstl[18] = (unsigned int  )7;
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)&nd_section_1;
 sqlstm.sqhstl[19] = (unsigned int  )5;
 sqlstm.sqhsts[19] = (         int  )0;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqhstv[20] = (         void  *)&nd_search_result_text_1;
 sqlstm.sqhstl[20] = (unsigned int  )4;
 sqlstm.sqhsts[20] = (         int  )0;
 sqlstm.sqindv[20] = (         void  *)0;
 sqlstm.sqinds[20] = (         int  )0;
 sqlstm.sqharm[20] = (unsigned int  )0;
 sqlstm.sqadto[20] = (unsigned short )0;
 sqlstm.sqtdso[20] = (unsigned short )0;
 sqlstm.sqhstv[21] = (         void  *)&nd_search_result_text_1;
 sqlstm.sqhstl[21] = (unsigned int  )4;
 sqlstm.sqhsts[21] = (         int  )0;
 sqlstm.sqindv[21] = (         void  *)0;
 sqlstm.sqinds[21] = (         int  )0;
 sqlstm.sqharm[21] = (unsigned int  )0;
 sqlstm.sqadto[21] = (unsigned short )0;
 sqlstm.sqtdso[21] = (unsigned short )0;
 sqlstm.sqhstv[22] = (         void  *)&nd_regd_date_fr_2;
 sqlstm.sqhstl[22] = (unsigned int  )33;
 sqlstm.sqhsts[22] = (         int  )0;
 sqlstm.sqindv[22] = (         void  *)0;
 sqlstm.sqinds[22] = (         int  )0;
 sqlstm.sqharm[22] = (unsigned int  )0;
 sqlstm.sqadto[22] = (unsigned short )0;
 sqlstm.sqtdso[22] = (unsigned short )0;
 sqlstm.sqhstv[23] = (         void  *)&nd_regd_date_to_2;
 sqlstm.sqhstl[23] = (unsigned int  )33;
 sqlstm.sqhsts[23] = (         int  )0;
 sqlstm.sqindv[23] = (         void  *)0;
 sqlstm.sqinds[23] = (         int  )0;
 sqlstm.sqharm[23] = (unsigned int  )0;
 sqlstm.sqadto[23] = (unsigned short )0;
 sqlstm.sqtdso[23] = (unsigned short )0;
 sqlstm.sqhstv[24] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[24] = (unsigned int  )5;
 sqlstm.sqhsts[24] = (         int  )0;
 sqlstm.sqindv[24] = (         void  *)0;
 sqlstm.sqinds[24] = (         int  )0;
 sqlstm.sqharm[24] = (unsigned int  )0;
 sqlstm.sqadto[24] = (unsigned short )0;
 sqlstm.sqtdso[24] = (unsigned short )0;
 sqlstm.sqhstv[25] = (         void  *)&nd_spec_type_fr_2;
 sqlstm.sqhstl[25] = (unsigned int  )7;
 sqlstm.sqhsts[25] = (         int  )0;
 sqlstm.sqindv[25] = (         void  *)0;
 sqlstm.sqinds[25] = (         int  )0;
 sqlstm.sqharm[25] = (unsigned int  )0;
 sqlstm.sqadto[25] = (unsigned short )0;
 sqlstm.sqtdso[25] = (unsigned short )0;
 sqlstm.sqhstv[26] = (         void  *)&nd_spec_type_to_2;
 sqlstm.sqhstl[26] = (unsigned int  )7;
 sqlstm.sqhsts[26] = (         int  )0;
 sqlstm.sqindv[26] = (         void  *)0;
 sqlstm.sqinds[26] = (         int  )0;
 sqlstm.sqharm[26] = (unsigned int  )0;
 sqlstm.sqadto[26] = (unsigned short )0;
 sqlstm.sqtdso[26] = (unsigned short )0;
 sqlstm.sqhstv[27] = (         void  *)&nd_anatomy_site_fr_2;
 sqlstm.sqhstl[27] = (unsigned int  )7;
 sqlstm.sqhsts[27] = (         int  )0;
 sqlstm.sqindv[27] = (         void  *)0;
 sqlstm.sqinds[27] = (         int  )0;
 sqlstm.sqharm[27] = (unsigned int  )0;
 sqlstm.sqadto[27] = (unsigned short )0;
 sqlstm.sqtdso[27] = (unsigned short )0;
 sqlstm.sqhstv[28] = (         void  *)&nd_anatomy_site_to_2;
 sqlstm.sqhstl[28] = (unsigned int  )7;
 sqlstm.sqhsts[28] = (         int  )0;
 sqlstm.sqindv[28] = (         void  *)0;
 sqlstm.sqinds[28] = (         int  )0;
 sqlstm.sqharm[28] = (unsigned int  )0;
 sqlstm.sqadto[28] = (unsigned short )0;
 sqlstm.sqtdso[28] = (unsigned short )0;
 sqlstm.sqhstv[29] = (         void  *)&nd_category_prfx_2;
 sqlstm.sqhstl[29] = (unsigned int  )7;
 sqlstm.sqhsts[29] = (         int  )0;
 sqlstm.sqindv[29] = (         void  *)0;
 sqlstm.sqinds[29] = (         int  )0;
 sqlstm.sqharm[29] = (unsigned int  )0;
 sqlstm.sqadto[29] = (unsigned short )0;
 sqlstm.sqtdso[29] = (unsigned short )0;
 sqlstm.sqhstv[30] = (         void  *)&nd_section_2;
 sqlstm.sqhstl[30] = (unsigned int  )5;
 sqlstm.sqhsts[30] = (         int  )0;
 sqlstm.sqindv[30] = (         void  *)0;
 sqlstm.sqinds[30] = (         int  )0;
 sqlstm.sqharm[30] = (unsigned int  )0;
 sqlstm.sqadto[30] = (unsigned short )0;
 sqlstm.sqtdso[30] = (unsigned short )0;
 sqlstm.sqhstv[31] = (         void  *)&nd_search_result_text_2;
 sqlstm.sqhstl[31] = (unsigned int  )4;
 sqlstm.sqhsts[31] = (         int  )0;
 sqlstm.sqindv[31] = (         void  *)0;
 sqlstm.sqinds[31] = (         int  )0;
 sqlstm.sqharm[31] = (unsigned int  )0;
 sqlstm.sqadto[31] = (unsigned short )0;
 sqlstm.sqtdso[31] = (unsigned short )0;
 sqlstm.sqhstv[32] = (         void  *)&nd_search_result_text_2;
 sqlstm.sqhstl[32] = (unsigned int  )4;
 sqlstm.sqhsts[32] = (         int  )0;
 sqlstm.sqindv[32] = (         void  *)0;
 sqlstm.sqinds[32] = (         int  )0;
 sqlstm.sqharm[32] = (unsigned int  )0;
 sqlstm.sqadto[32] = (unsigned short )0;
 sqlstm.sqtdso[32] = (unsigned short )0;
 sqlstm.sqhstv[33] = (         void  *)&nd_regd_date_fr_2;
 sqlstm.sqhstl[33] = (unsigned int  )33;
 sqlstm.sqhsts[33] = (         int  )0;
 sqlstm.sqindv[33] = (         void  *)0;
 sqlstm.sqinds[33] = (         int  )0;
 sqlstm.sqharm[33] = (unsigned int  )0;
 sqlstm.sqadto[33] = (unsigned short )0;
 sqlstm.sqtdso[33] = (unsigned short )0;
 sqlstm.sqhstv[34] = (         void  *)&nd_regd_date_to_2;
 sqlstm.sqhstl[34] = (unsigned int  )33;
 sqlstm.sqhsts[34] = (         int  )0;
 sqlstm.sqindv[34] = (         void  *)0;
 sqlstm.sqinds[34] = (         int  )0;
 sqlstm.sqharm[34] = (unsigned int  )0;
 sqlstm.sqadto[34] = (unsigned short )0;
 sqlstm.sqtdso[34] = (unsigned short )0;
 sqlstm.sqhstv[35] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[35] = (unsigned int  )5;
 sqlstm.sqhsts[35] = (         int  )0;
 sqlstm.sqindv[35] = (         void  *)0;
 sqlstm.sqinds[35] = (         int  )0;
 sqlstm.sqharm[35] = (unsigned int  )0;
 sqlstm.sqadto[35] = (unsigned short )0;
 sqlstm.sqtdso[35] = (unsigned short )0;
 sqlstm.sqhstv[36] = (         void  *)&nd_spec_type_fr_2;
 sqlstm.sqhstl[36] = (unsigned int  )7;
 sqlstm.sqhsts[36] = (         int  )0;
 sqlstm.sqindv[36] = (         void  *)0;
 sqlstm.sqinds[36] = (         int  )0;
 sqlstm.sqharm[36] = (unsigned int  )0;
 sqlstm.sqadto[36] = (unsigned short )0;
 sqlstm.sqtdso[36] = (unsigned short )0;
 sqlstm.sqhstv[37] = (         void  *)&nd_spec_type_to_2;
 sqlstm.sqhstl[37] = (unsigned int  )7;
 sqlstm.sqhsts[37] = (         int  )0;
 sqlstm.sqindv[37] = (         void  *)0;
 sqlstm.sqinds[37] = (         int  )0;
 sqlstm.sqharm[37] = (unsigned int  )0;
 sqlstm.sqadto[37] = (unsigned short )0;
 sqlstm.sqtdso[37] = (unsigned short )0;
 sqlstm.sqhstv[38] = (         void  *)&nd_anatomy_site_fr_2;
 sqlstm.sqhstl[38] = (unsigned int  )7;
 sqlstm.sqhsts[38] = (         int  )0;
 sqlstm.sqindv[38] = (         void  *)0;
 sqlstm.sqinds[38] = (         int  )0;
 sqlstm.sqharm[38] = (unsigned int  )0;
 sqlstm.sqadto[38] = (unsigned short )0;
 sqlstm.sqtdso[38] = (unsigned short )0;
 sqlstm.sqhstv[39] = (         void  *)&nd_anatomy_site_to_2;
 sqlstm.sqhstl[39] = (unsigned int  )7;
 sqlstm.sqhsts[39] = (         int  )0;
 sqlstm.sqindv[39] = (         void  *)0;
 sqlstm.sqinds[39] = (         int  )0;
 sqlstm.sqharm[39] = (unsigned int  )0;
 sqlstm.sqadto[39] = (unsigned short )0;
 sqlstm.sqtdso[39] = (unsigned short )0;
 sqlstm.sqhstv[40] = (         void  *)&nd_category_prfx_2;
 sqlstm.sqhstl[40] = (unsigned int  )7;
 sqlstm.sqhsts[40] = (         int  )0;
 sqlstm.sqindv[40] = (         void  *)0;
 sqlstm.sqinds[40] = (         int  )0;
 sqlstm.sqharm[40] = (unsigned int  )0;
 sqlstm.sqadto[40] = (unsigned short )0;
 sqlstm.sqtdso[40] = (unsigned short )0;
 sqlstm.sqhstv[41] = (         void  *)&nd_section_2;
 sqlstm.sqhstl[41] = (unsigned int  )5;
 sqlstm.sqhsts[41] = (         int  )0;
 sqlstm.sqindv[41] = (         void  *)0;
 sqlstm.sqinds[41] = (         int  )0;
 sqlstm.sqharm[41] = (unsigned int  )0;
 sqlstm.sqadto[41] = (unsigned short )0;
 sqlstm.sqtdso[41] = (unsigned short )0;
 sqlstm.sqhstv[42] = (         void  *)&nd_search_result_text_2;
 sqlstm.sqhstl[42] = (unsigned int  )4;
 sqlstm.sqhsts[42] = (         int  )0;
 sqlstm.sqindv[42] = (         void  *)0;
 sqlstm.sqinds[42] = (         int  )0;
 sqlstm.sqharm[42] = (unsigned int  )0;
 sqlstm.sqadto[42] = (unsigned short )0;
 sqlstm.sqtdso[42] = (unsigned short )0;
 sqlstm.sqhstv[43] = (         void  *)&nd_search_result_text_2;
 sqlstm.sqhstl[43] = (unsigned int  )4;
 sqlstm.sqhsts[43] = (         int  )0;
 sqlstm.sqindv[43] = (         void  *)0;
 sqlstm.sqinds[43] = (         int  )0;
 sqlstm.sqharm[43] = (unsigned int  )0;
 sqlstm.sqadto[43] = (unsigned short )0;
 sqlstm.sqtdso[43] = (unsigned short )0;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}


	return;
err_exit:

	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 44;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )662;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	disp_message(ORA_MESG,"Oracle error at dclr_request_header_cur_bb() occured....\n");
	proc_exit();
}
//end
//Start Modified Select Statement on 15/05/2007 against scf1664 by ramesh
/*-----------------------------*/
void dclr_request_header_cur_1()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 



	/* EXEC SQL DECLARE HEADER_CUR1 CURSOR FOR
	    SELECT * FROM(SELECT DISTINCT A.SPECIMEN_NO ,A.PATIENT_ID PATIENT_ID,
		       A.CATEGORY_CODE,A.CATEGORY_YEAR,A.CATEGORY_NUMBER,A.SECTION_CODE,
			   A.SOURCE_CODE,A.EPISODE_TYPE,A.SOURCE_TYPE
		FROM RL_REQUEST_HEADER A, RL_SAMPLE_DETAILS B
		WHERE A.SPEC_REGD_DATE_TIME > TO_DATE(:nd_regd_date_fr_1, 'DD/MM/YYYY') 
		AND	A.SPEC_REGD_DATE_TIME < TO_DATE(:nd_regd_date_to_1, 'DD/MM/YYYY') + 1 
	    AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND A.SPECIMEN_NO = B.SPECIMEN_NO 
		AND A.PATIENT_ID = nvl(:d_patient_id,A.PATIENT_ID)
		AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
		AND NVL(A.SPECIMEN_TYPE_CODE, '!') BETWEEN NVL(:nd_spec_type_fr_1, NVL(A.SPECIMEN_TYPE_CODE,'!'))
										   AND NVL(:nd_spec_type_to_1, NVL(A.SPECIMEN_TYPE_CODE,'!'))
        
		AND NVL(B.ANATOMY_SITE_CODE, '!') BETWEEN NVL(:nd_anatomy_site_fr_1, NVL(B.ANATOMY_SITE_CODE,'!'))
										  AND NVL(:nd_anatomy_site_to_1, NVL(B.ANATOMY_SITE_CODE,'!'))
        AND   NVL(A.CATEGORY_CODE,'!') = NVL(:nd_category_prfx_1, NVL(A.CATEGORY_CODE, '!'))
		AND NVL(A.STATUS,'O') != 'O'
		AND  A.SECTION_CODE = :nd_section_1 
			AND ( ( :nd_search_result_text_1 = 'Y' AND 
	        EXISTS
            (SELECT 'X' 
            FROM   rl_result_text X
            WHERE  X.patient_id = A.patient_id
            AND    X.specimen_no = A.specimen_no
            AND    X.operating_facility_id = A.operating_facility_id
            AND    NVL(X.cancer_register_yn, 'N') = 'Y' 
            )
		  )
          OR
		  (:nd_search_result_text_1 = 'N' AND 1=1)
		)
		
		UNION
		SELECT DISTINCT A.SPECIMEN_NO ,A.PATIENT_ID PATIENT_ID,
		       A.CATEGORY_CODE,A.CATEGORY_YEAR,A.CATEGORY_NUMBER,A.SECTION_CODE,
			   A.SOURCE_CODE,A.EPISODE_TYPE,A.SOURCE_TYPE
		FROM RL_REQUEST_HEADER A, RL_SPECIMEN_ANATOMY_DTLS B
		WHERE A.SPEC_REGD_DATE_TIME > TO_DATE(:nd_regd_date_fr_1, 'DD/MM/YYYY') AND
			A.SPEC_REGD_DATE_TIME < TO_DATE(:nd_regd_date_to_1, 'DD/MM/YYYY') + 1
		AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND A.SPECIMEN_NO = B.SPECIMEN_NO(+) 
		AND A.PATIENT_ID = nvl(:d_patient_id,A.PATIENT_ID)
		AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID(+)
		AND NVL(A.SPECIMEN_TYPE_CODE, '!') BETWEEN NVL(:nd_spec_type_fr_1, NVL(A.SPECIMEN_TYPE_CODE,'!'))
										   AND NVL(:nd_spec_type_to_1, NVL(A.SPECIMEN_TYPE_CODE,'!'))
		AND NVL(B.ANATOMY_SITE_CODE, '!') BETWEEN NVL(:nd_anatomy_site_fr_1, NVL(B.ANATOMY_SITE_CODE,'!'))
										AND NVL(:nd_anatomy_site_to_1, NVL(B.ANATOMY_SITE_CODE,'!'))
        AND  NVL(A.CATEGORY_CODE,'!') = NVL(:nd_category_prfx_1, NVL(A.CATEGORY_CODE, '!'))
	AND NVL(A.STATUS,'O') != 'O'
		AND A.SECTION_CODE = :nd_section_1
			AND ( ( :nd_search_result_text_1 = 'Y' AND 
	        EXISTS
            (SELECT 'X' 
            FROM   rl_result_text X
            WHERE  X.patient_id = A.patient_id
            AND    X.specimen_no = A.specimen_no
            AND    X.operating_facility_id = A.operating_facility_id
            AND    NVL(X.cancer_register_yn, 'N') = 'Y' 
            )
		  )
          OR
		  (:nd_search_result_text_1 = 'N' AND 1=1)
		)
	    )
        UNION ALL
		(SELECT DISTINCT A.SPECIMEN_NO ,A.PATIENT_ID PATIENT_ID,
		       A.CATEGORY_CODE,A.CATEGORY_YEAR,A.CATEGORY_NUMBER,A.SECTION_CODE,
			   A.SOURCE_CODE,A.EPISODE_TYPE,A.SOURCE_TYPE
		FROM RL_REQUEST_HEADER A, RL_SAMPLE_DETAILS B
		WHERE A.SPEC_REGD_DATE_TIME > TO_DATE(:nd_regd_date_fr_2, 'DD/MM/YYYY') 
		AND	A.SPEC_REGD_DATE_TIME < TO_DATE(:nd_regd_date_to_2, 'DD/MM/YYYY') + 1 
	    AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND A.SPECIMEN_NO = B.SPECIMEN_NO 
		AND A.PATIENT_ID = nvl(:d_patient_id,A.PATIENT_ID)
		AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
		AND NVL(A.SPECIMEN_TYPE_CODE, '!') BETWEEN NVL(:nd_spec_type_fr_2, NVL(A.SPECIMEN_TYPE_CODE,'!'))
										   AND NVL(:nd_spec_type_to_2, NVL(A.SPECIMEN_TYPE_CODE,'!'))
        
		AND NVL(B.ANATOMY_SITE_CODE, '!') BETWEEN NVL(:nd_anatomy_site_fr_2, NVL(B.ANATOMY_SITE_CODE,'!'))
										  AND NVL(:nd_anatomy_site_to_2, NVL(B.ANATOMY_SITE_CODE,'!'))
        AND   NVL(A.CATEGORY_CODE,'!') = NVL(:nd_category_prfx_2, NVL(A.CATEGORY_CODE, '!'))
	AND NVL(A.STATUS,'O') != 'O'
		AND  A.SECTION_CODE = :nd_section_2 
			AND ( ( :nd_search_result_text_2 = 'Y' AND 
	        EXISTS
            (SELECT 'X' 
            FROM   rl_result_text X
            WHERE  X.patient_id = A.patient_id
            AND    X.specimen_no = A.specimen_no
            AND    X.operating_facility_id = A.operating_facility_id
            AND    NVL(X.cancer_register_yn, 'N') = 'Y' 
            )
		  )
          OR
		  (:nd_search_result_text_2 = 'N' AND 1=1)
		)
		UNION
		SELECT DISTINCT A.SPECIMEN_NO ,A.PATIENT_ID PATIENT_ID,
		       A.CATEGORY_CODE,A.CATEGORY_YEAR,A.CATEGORY_NUMBER,A.SECTION_CODE,
			   A.SOURCE_CODE,A.EPISODE_TYPE,A.SOURCE_TYPE
		FROM RL_REQUEST_HEADER A, RL_SPECIMEN_ANATOMY_DTLS B
		WHERE A.SPEC_REGD_DATE_TIME > TO_DATE(:nd_regd_date_fr_2, 'DD/MM/YYYY') AND
			A.SPEC_REGD_DATE_TIME < TO_DATE(:nd_regd_date_to_2, 'DD/MM/YYYY') + 1
		AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND A.SPECIMEN_NO = B.SPECIMEN_NO(+) 
		AND A.PATIENT_ID = nvl(:d_patient_id,A.PATIENT_ID)
		AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID(+)
		AND NVL(A.SPECIMEN_TYPE_CODE, '!') BETWEEN NVL(:nd_spec_type_fr_2, NVL(A.SPECIMEN_TYPE_CODE,'!'))
										   AND NVL(:nd_spec_type_to_2, NVL(A.SPECIMEN_TYPE_CODE,'!'))
		AND NVL(B.ANATOMY_SITE_CODE, '!') BETWEEN NVL(:nd_anatomy_site_fr_2, NVL(B.ANATOMY_SITE_CODE,'!'))
										AND NVL(:nd_anatomy_site_to_2, NVL(B.ANATOMY_SITE_CODE,'!'))
        AND  NVL(A.CATEGORY_CODE,'!') = NVL(:nd_category_prfx_2, NVL(A.CATEGORY_CODE, '!'))
		AND NVL(A.STATUS,'O') != 'O'
		AND A.SECTION_CODE = :nd_section_2 
			AND ( ( :nd_search_result_text_2 = 'Y' AND 
	        EXISTS
            (SELECT 'X' 
            FROM   rl_result_text X
            WHERE  X.patient_id = A.patient_id
            AND    X.specimen_no = A.specimen_no
            AND    X.operating_facility_id = A.operating_facility_id
            AND    NVL(X.cancer_register_yn, 'N') = 'Y' 
            )
		  )
          OR
		  (:nd_search_result_text_2 = 'N' AND 1=1)
		)
		)

		ORDER BY PATIENT_ID,SPECIMEN_NO; */ 

	
		/**
		SELECT A.SPECIMEN_NO, A.PATIENT_ID,A.CATEGORY_CODE, A.CATEGORY_YEAR , A.CATEGORY_NUMBER
		FROM RL_REQUEST_HEADER A, RL_SECTION_CODE B
		WHERE A.SPEC_REGD_DATE_TIME > TO_DATE(:nd_regd_date_fr, 'DD/MM/YYYY') AND
		      A.SPEC_REGD_DATE_TIME < TO_DATE(:nd_regd_date_to, 'DD/MM/YYYY') + 1
		AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND NVL(A.SPECIMEN_TYPE_CODE, '!') = NVL(:nd_spec_type, NVL(A.SPECIMEN_TYPE_CODE,'!'))
		AND NVL(A.PERFORM_SITE_CODE, '!') = NVL(:nd_site_code, NVL(A.PERFORM_SITE_CODE,'!'))
		AND NVL(A.CATEGORY_CODE,'!') = NVL(:nd_category_prfx, NVL(A.CATEGORY_CODE, '!'))
		AND NVL(A.STATUS,'O') != 'O'
		AND A.SECTION_CODE = B.SECTION_CODE
		AND NVL(B.SECTION_IND, '!') IN ('HI','CY')
		ORDER BY B.SECTION_IND , A.PATIENT_ID, A.SPECIMEN_NO;
	    **/

	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL OPEN HEADER_CUR1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 48;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlbuft((void **)0, 
   "select *  from (select distinct A.SPECIMEN_NO ,A.PATIENT_ID PATIENT_ID ,\
A.CATEGORY_CODE ,A.CATEGORY_YEAR ,A.CATEGORY_NUMBER ,A.SECTION_CODE ,A.SOURC\
E_CODE ,A.EPISODE_TYPE ,A.SOURCE_TYPE  from RL_REQUEST_HEADER A ,RL_SAMPLE_D\
ETAILS B where (((((((((((A.SPEC_REGD_DATE_TIME>TO_DATE(:b0,'DD/MM/YYYY') an\
d A.SPEC_REGD_DATE_TIME<(TO_DATE(:b1,'DD/MM/YYYY')+1)) and A.OPERATING_FACIL\
ITY_ID=:b2) and A.SPECIMEN_NO=B.SPECIMEN_NO) and A.PATIENT_ID=nvl(:b3,A.PATI\
ENT_ID)) and A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID) and NVL(A.SPEC\
IMEN_TYPE_CODE,'!') between NVL(:b4,NVL(A.SPECIMEN_TYPE_CODE,'!')) and NVL(:\
b5,NVL(A.SPECIMEN_TYPE_CODE,'!'))) and NVL(B.ANATOMY_SITE_CODE,'!') between \
NVL(:b6,NVL(B.ANATOMY_SITE_CODE,'!')) and NVL(:b7,NVL(B.ANATOMY_SITE_CODE,'!\
'))) and NVL(A.CATEGORY_CODE,'!')=NVL(:b8,NVL(A.CATEGORY_CODE,'!'))) and NVL\
(A.STATUS,'O')<>'O') and A.SECTION_CODE=:b9) and ((:b10='Y' and exists (sele\
ct 'X'  from rl_result_text X where (((X.patient_id=A.patient_id and X.speci\
men_no=A.specimen_no) and X.operating_fa");
 sqlbuft((void **)0, 
   "cility_id=A.operating_facility_id) and NVL(X.cancer_register_yn,'N')='Y'\
))) or (:b10='N' and 1=1))) union select distinct A.SPECIMEN_NO ,A.PATIENT_I\
D PATIENT_ID ,A.CATEGORY_CODE ,A.CATEGORY_YEAR ,A.CATEGORY_NUMBER ,A.SECTION\
_CODE ,A.SOURCE_CODE ,A.EPISODE_TYPE ,A.SOURCE_TYPE  from RL_REQUEST_HEADER \
A ,RL_SPECIMEN_ANATOMY_DTLS B where (((((((((((A.SPEC_REGD_DATE_TIME>TO_DATE\
(:b0,'DD/MM/YYYY') and A.SPEC_REGD_DATE_TIME<(TO_DATE(:b1,'DD/MM/YYYY')+1)) \
and A.OPERATING_FACILITY_ID=:b2) and A.SPECIMEN_NO=B.SPECIMEN_NO(+)) and A.P\
ATIENT_ID=nvl(:b3,A.PATIENT_ID)) and A.OPERATING_FACILITY_ID=B.OPERATING_FAC\
ILITY_ID(+)) and NVL(A.SPECIMEN_TYPE_CODE,'!') between NVL(:b4,NVL(A.SPECIME\
N_TYPE_CODE,'!')) and NVL(:b5,NVL(A.SPECIMEN_TYPE_CODE,'!'))) and NVL(B.ANAT\
OMY_SITE_CODE,'!') between NVL(:b6,NVL(B.ANATOMY_SITE_CODE,'!')) and NVL(:b7\
,NVL(B.ANATOMY_SITE_CODE,'!'))) and NVL(A.CATEGORY_CODE,'!')=NVL(:b8,NVL(A.C\
ATEGORY_CODE,'!'))) and NVL(A.STATUS,'O')<>'O') and A.SECTION_CODE=:b9) and \
((:b10='Y' and exists (select 'X'  from ");
 sqlbuft((void **)0, 
   "rl_result_text X where (((X.patient_id=A.patient_id and X.specimen_no=A.\
specimen_no) and X.operating_facility_id=A.operating_facility_id) and NVL(X.\
cancer_register_yn,'N')='Y'))) or (:b10='N' and 1=1))))  union all (select d\
istinct A.SPECIMEN_NO ,A.PATIENT_ID PATIENT_ID ,A.CATEGORY_CODE ,A.CATEGORY_\
YEAR ,A.CATEGORY_NUMBER ,A.SECTION_CODE ,A.SOURCE_CODE ,A.EPISODE_TYPE ,A.SO\
URCE_TYPE  from RL_REQUEST_HEADER A ,RL_SAMPLE_DETAILS B where (((((((((((A.\
SPEC_REGD_DATE_TIME>TO_DATE(:b24,'DD/MM/YYYY') and A.SPEC_REGD_DATE_TIME<(TO\
_DATE(:b25,'DD/MM/YYYY')+1)) and A.OPERATING_FACILITY_ID=:b2) and A.SPECIMEN\
_NO=B.SPECIMEN_NO) and A.PATIENT_ID=nvl(:b3,A.PATIENT_ID)) and A.OPERATING_F\
ACILITY_ID=B.OPERATING_FACILITY_ID) and NVL(A.SPECIMEN_TYPE_CODE,'!') betwee\
n NVL(:b28,NVL(A.SPECIMEN_TYPE_CODE,'!')) and NVL(:b29,NVL(A.SPECIMEN_TYPE_C\
ODE,'!'))) and NVL(B.ANATOMY_SITE_CODE,'!') between NVL(:b30,NVL(B.ANATOMY_S\
ITE_CODE,'!')) and NVL(:b31,NVL(B.ANATOMY_SITE_CODE,'!'))) and NVL(A.CATEGOR\
Y_CODE,'!')=NVL(:b32,NVL(A.CATEGORY_CODE");
 sqlbuft((void **)0, 
   ",'!'))) and NVL(A.STATUS,'O')<>'O') and A.SECTION_CODE=:b33) and ((:b34=\
'Y' and exists (select 'X'  from rl_result_text X where (((X.patient_id=A.pa\
tient_id and X.specimen_no=A.specimen_no) and X.operating_facility_id=A.oper\
ating_facility_id) and NVL(X.cancer_register_yn,'N')='Y'))) or (:b34='N' and\
 1=1))) union select distinct A.SPECIMEN_NO ,A.PATIENT_ID PATIENT_ID ,A.CATE\
GORY_CODE ,A.CATEGORY_YEAR ,A.CATEGORY_NUMBER ,A.SECTION_CODE ,A.SOURCE_CODE\
 ,A.EPISODE_TYPE ,A.SOURCE_TYPE  from RL_REQUEST_HEADER A ,RL_SPECIMEN_ANATO\
MY_DTLS B where (((((((((((A.SPEC_REGD_DATE_TIME>TO_DATE(:b24,'DD/MM/YYYY') \
and A.SPEC_REGD_DATE_TIME<(TO_DATE(:b25,'DD/MM/YYYY')+1)) and A.OPERATING_FA\
CILITY_ID=:b2) and A.SPECIMEN_NO=B.SPECIMEN_NO(+)) and A.PATIENT_ID=nvl(:b3,\
A.PATIENT_ID)) and A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID(+)) and N\
VL(A.SPECIMEN_TYPE_CODE,'!') between NVL(:b28,NVL(A.SPECIMEN_TYPE_CODE,'!'))\
 and NVL(:b29,NVL(A.SPECIMEN_TYPE_CODE,'!'))) and NVL(B.ANATOMY_SITE_CODE,'!\
') between NVL(:b30,NVL(B.ANATOMY_SITE_C");
 sqlstm.stmt = sq0013;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )677;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_regd_date_fr_1;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&nd_regd_date_to_1;
 sqlstm.sqhstl[1] = (unsigned int  )33;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[3] = (unsigned int  )33;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_spec_type_fr_1;
 sqlstm.sqhstl[4] = (unsigned int  )7;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_spec_type_to_1;
 sqlstm.sqhstl[5] = (unsigned int  )7;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&nd_anatomy_site_fr_1;
 sqlstm.sqhstl[6] = (unsigned int  )7;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&nd_anatomy_site_to_1;
 sqlstm.sqhstl[7] = (unsigned int  )7;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_category_prfx_1;
 sqlstm.sqhstl[8] = (unsigned int  )7;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&nd_section_1;
 sqlstm.sqhstl[9] = (unsigned int  )5;
 sqlstm.sqhsts[9] = (         int  )0;
 sqlstm.sqindv[9] = (         void  *)0;
 sqlstm.sqinds[9] = (         int  )0;
 sqlstm.sqharm[9] = (unsigned int  )0;
 sqlstm.sqadto[9] = (unsigned short )0;
 sqlstm.sqtdso[9] = (unsigned short )0;
 sqlstm.sqhstv[10] = (         void  *)&nd_search_result_text_1;
 sqlstm.sqhstl[10] = (unsigned int  )4;
 sqlstm.sqhsts[10] = (         int  )0;
 sqlstm.sqindv[10] = (         void  *)0;
 sqlstm.sqinds[10] = (         int  )0;
 sqlstm.sqharm[10] = (unsigned int  )0;
 sqlstm.sqadto[10] = (unsigned short )0;
 sqlstm.sqtdso[10] = (unsigned short )0;
 sqlstm.sqhstv[11] = (         void  *)&nd_search_result_text_1;
 sqlstm.sqhstl[11] = (unsigned int  )4;
 sqlstm.sqhsts[11] = (         int  )0;
 sqlstm.sqindv[11] = (         void  *)0;
 sqlstm.sqinds[11] = (         int  )0;
 sqlstm.sqharm[11] = (unsigned int  )0;
 sqlstm.sqadto[11] = (unsigned short )0;
 sqlstm.sqtdso[11] = (unsigned short )0;
 sqlstm.sqhstv[12] = (         void  *)&nd_regd_date_fr_1;
 sqlstm.sqhstl[12] = (unsigned int  )33;
 sqlstm.sqhsts[12] = (         int  )0;
 sqlstm.sqindv[12] = (         void  *)0;
 sqlstm.sqinds[12] = (         int  )0;
 sqlstm.sqharm[12] = (unsigned int  )0;
 sqlstm.sqadto[12] = (unsigned short )0;
 sqlstm.sqtdso[12] = (unsigned short )0;
 sqlstm.sqhstv[13] = (         void  *)&nd_regd_date_to_1;
 sqlstm.sqhstl[13] = (unsigned int  )33;
 sqlstm.sqhsts[13] = (         int  )0;
 sqlstm.sqindv[13] = (         void  *)0;
 sqlstm.sqinds[13] = (         int  )0;
 sqlstm.sqharm[13] = (unsigned int  )0;
 sqlstm.sqadto[13] = (unsigned short )0;
 sqlstm.sqtdso[13] = (unsigned short )0;
 sqlstm.sqhstv[14] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[14] = (unsigned int  )5;
 sqlstm.sqhsts[14] = (         int  )0;
 sqlstm.sqindv[14] = (         void  *)0;
 sqlstm.sqinds[14] = (         int  )0;
 sqlstm.sqharm[14] = (unsigned int  )0;
 sqlstm.sqadto[14] = (unsigned short )0;
 sqlstm.sqtdso[14] = (unsigned short )0;
 sqlstm.sqhstv[15] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[15] = (unsigned int  )33;
 sqlstm.sqhsts[15] = (         int  )0;
 sqlstm.sqindv[15] = (         void  *)0;
 sqlstm.sqinds[15] = (         int  )0;
 sqlstm.sqharm[15] = (unsigned int  )0;
 sqlstm.sqadto[15] = (unsigned short )0;
 sqlstm.sqtdso[15] = (unsigned short )0;
 sqlstm.sqhstv[16] = (         void  *)&nd_spec_type_fr_1;
 sqlstm.sqhstl[16] = (unsigned int  )7;
 sqlstm.sqhsts[16] = (         int  )0;
 sqlstm.sqindv[16] = (         void  *)0;
 sqlstm.sqinds[16] = (         int  )0;
 sqlstm.sqharm[16] = (unsigned int  )0;
 sqlstm.sqadto[16] = (unsigned short )0;
 sqlstm.sqtdso[16] = (unsigned short )0;
 sqlstm.sqhstv[17] = (         void  *)&nd_spec_type_to_1;
 sqlstm.sqhstl[17] = (unsigned int  )7;
 sqlstm.sqhsts[17] = (         int  )0;
 sqlstm.sqindv[17] = (         void  *)0;
 sqlstm.sqinds[17] = (         int  )0;
 sqlstm.sqharm[17] = (unsigned int  )0;
 sqlstm.sqadto[17] = (unsigned short )0;
 sqlstm.sqtdso[17] = (unsigned short )0;
 sqlstm.sqhstv[18] = (         void  *)&nd_anatomy_site_fr_1;
 sqlstm.sqhstl[18] = (unsigned int  )7;
 sqlstm.sqhsts[18] = (         int  )0;
 sqlstm.sqindv[18] = (         void  *)0;
 sqlstm.sqinds[18] = (         int  )0;
 sqlstm.sqharm[18] = (unsigned int  )0;
 sqlstm.sqadto[18] = (unsigned short )0;
 sqlstm.sqtdso[18] = (unsigned short )0;
 sqlstm.sqhstv[19] = (         void  *)&nd_anatomy_site_to_1;
 sqlstm.sqhstl[19] = (unsigned int  )7;
 sqlstm.sqhsts[19] = (         int  )0;
 sqlstm.sqindv[19] = (         void  *)0;
 sqlstm.sqinds[19] = (         int  )0;
 sqlstm.sqharm[19] = (unsigned int  )0;
 sqlstm.sqadto[19] = (unsigned short )0;
 sqlstm.sqtdso[19] = (unsigned short )0;
 sqlstm.sqhstv[20] = (         void  *)&nd_category_prfx_1;
 sqlstm.sqhstl[20] = (unsigned int  )7;
 sqlstm.sqhsts[20] = (         int  )0;
 sqlstm.sqindv[20] = (         void  *)0;
 sqlstm.sqinds[20] = (         int  )0;
 sqlstm.sqharm[20] = (unsigned int  )0;
 sqlstm.sqadto[20] = (unsigned short )0;
 sqlstm.sqtdso[20] = (unsigned short )0;
 sqlstm.sqhstv[21] = (         void  *)&nd_section_1;
 sqlstm.sqhstl[21] = (unsigned int  )5;
 sqlstm.sqhsts[21] = (         int  )0;
 sqlstm.sqindv[21] = (         void  *)0;
 sqlstm.sqinds[21] = (         int  )0;
 sqlstm.sqharm[21] = (unsigned int  )0;
 sqlstm.sqadto[21] = (unsigned short )0;
 sqlstm.sqtdso[21] = (unsigned short )0;
 sqlstm.sqhstv[22] = (         void  *)&nd_search_result_text_1;
 sqlstm.sqhstl[22] = (unsigned int  )4;
 sqlstm.sqhsts[22] = (         int  )0;
 sqlstm.sqindv[22] = (         void  *)0;
 sqlstm.sqinds[22] = (         int  )0;
 sqlstm.sqharm[22] = (unsigned int  )0;
 sqlstm.sqadto[22] = (unsigned short )0;
 sqlstm.sqtdso[22] = (unsigned short )0;
 sqlstm.sqhstv[23] = (         void  *)&nd_search_result_text_1;
 sqlstm.sqhstl[23] = (unsigned int  )4;
 sqlstm.sqhsts[23] = (         int  )0;
 sqlstm.sqindv[23] = (         void  *)0;
 sqlstm.sqinds[23] = (         int  )0;
 sqlstm.sqharm[23] = (unsigned int  )0;
 sqlstm.sqadto[23] = (unsigned short )0;
 sqlstm.sqtdso[23] = (unsigned short )0;
 sqlstm.sqhstv[24] = (         void  *)&nd_regd_date_fr_2;
 sqlstm.sqhstl[24] = (unsigned int  )33;
 sqlstm.sqhsts[24] = (         int  )0;
 sqlstm.sqindv[24] = (         void  *)0;
 sqlstm.sqinds[24] = (         int  )0;
 sqlstm.sqharm[24] = (unsigned int  )0;
 sqlstm.sqadto[24] = (unsigned short )0;
 sqlstm.sqtdso[24] = (unsigned short )0;
 sqlstm.sqhstv[25] = (         void  *)&nd_regd_date_to_2;
 sqlstm.sqhstl[25] = (unsigned int  )33;
 sqlstm.sqhsts[25] = (         int  )0;
 sqlstm.sqindv[25] = (         void  *)0;
 sqlstm.sqinds[25] = (         int  )0;
 sqlstm.sqharm[25] = (unsigned int  )0;
 sqlstm.sqadto[25] = (unsigned short )0;
 sqlstm.sqtdso[25] = (unsigned short )0;
 sqlstm.sqhstv[26] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[26] = (unsigned int  )5;
 sqlstm.sqhsts[26] = (         int  )0;
 sqlstm.sqindv[26] = (         void  *)0;
 sqlstm.sqinds[26] = (         int  )0;
 sqlstm.sqharm[26] = (unsigned int  )0;
 sqlstm.sqadto[26] = (unsigned short )0;
 sqlstm.sqtdso[26] = (unsigned short )0;
 sqlstm.sqhstv[27] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[27] = (unsigned int  )33;
 sqlstm.sqhsts[27] = (         int  )0;
 sqlstm.sqindv[27] = (         void  *)0;
 sqlstm.sqinds[27] = (         int  )0;
 sqlstm.sqharm[27] = (unsigned int  )0;
 sqlstm.sqadto[27] = (unsigned short )0;
 sqlstm.sqtdso[27] = (unsigned short )0;
 sqlstm.sqhstv[28] = (         void  *)&nd_spec_type_fr_2;
 sqlstm.sqhstl[28] = (unsigned int  )7;
 sqlstm.sqhsts[28] = (         int  )0;
 sqlstm.sqindv[28] = (         void  *)0;
 sqlstm.sqinds[28] = (         int  )0;
 sqlstm.sqharm[28] = (unsigned int  )0;
 sqlstm.sqadto[28] = (unsigned short )0;
 sqlstm.sqtdso[28] = (unsigned short )0;
 sqlstm.sqhstv[29] = (         void  *)&nd_spec_type_to_2;
 sqlstm.sqhstl[29] = (unsigned int  )7;
 sqlstm.sqhsts[29] = (         int  )0;
 sqlstm.sqindv[29] = (         void  *)0;
 sqlstm.sqinds[29] = (         int  )0;
 sqlstm.sqharm[29] = (unsigned int  )0;
 sqlstm.sqadto[29] = (unsigned short )0;
 sqlstm.sqtdso[29] = (unsigned short )0;
 sqlstm.sqhstv[30] = (         void  *)&nd_anatomy_site_fr_2;
 sqlstm.sqhstl[30] = (unsigned int  )7;
 sqlstm.sqhsts[30] = (         int  )0;
 sqlstm.sqindv[30] = (         void  *)0;
 sqlstm.sqinds[30] = (         int  )0;
 sqlstm.sqharm[30] = (unsigned int  )0;
 sqlstm.sqadto[30] = (unsigned short )0;
 sqlstm.sqtdso[30] = (unsigned short )0;
 sqlstm.sqhstv[31] = (         void  *)&nd_anatomy_site_to_2;
 sqlstm.sqhstl[31] = (unsigned int  )7;
 sqlstm.sqhsts[31] = (         int  )0;
 sqlstm.sqindv[31] = (         void  *)0;
 sqlstm.sqinds[31] = (         int  )0;
 sqlstm.sqharm[31] = (unsigned int  )0;
 sqlstm.sqadto[31] = (unsigned short )0;
 sqlstm.sqtdso[31] = (unsigned short )0;
 sqlstm.sqhstv[32] = (         void  *)&nd_category_prfx_2;
 sqlstm.sqhstl[32] = (unsigned int  )7;
 sqlstm.sqhsts[32] = (         int  )0;
 sqlstm.sqindv[32] = (         void  *)0;
 sqlstm.sqinds[32] = (         int  )0;
 sqlstm.sqharm[32] = (unsigned int  )0;
 sqlstm.sqadto[32] = (unsigned short )0;
 sqlstm.sqtdso[32] = (unsigned short )0;
 sqlstm.sqhstv[33] = (         void  *)&nd_section_2;
 sqlstm.sqhstl[33] = (unsigned int  )5;
 sqlstm.sqhsts[33] = (         int  )0;
 sqlstm.sqindv[33] = (         void  *)0;
 sqlstm.sqinds[33] = (         int  )0;
 sqlstm.sqharm[33] = (unsigned int  )0;
 sqlstm.sqadto[33] = (unsigned short )0;
 sqlstm.sqtdso[33] = (unsigned short )0;
 sqlstm.sqhstv[34] = (         void  *)&nd_search_result_text_2;
 sqlstm.sqhstl[34] = (unsigned int  )4;
 sqlstm.sqhsts[34] = (         int  )0;
 sqlstm.sqindv[34] = (         void  *)0;
 sqlstm.sqinds[34] = (         int  )0;
 sqlstm.sqharm[34] = (unsigned int  )0;
 sqlstm.sqadto[34] = (unsigned short )0;
 sqlstm.sqtdso[34] = (unsigned short )0;
 sqlstm.sqhstv[35] = (         void  *)&nd_search_result_text_2;
 sqlstm.sqhstl[35] = (unsigned int  )4;
 sqlstm.sqhsts[35] = (         int  )0;
 sqlstm.sqindv[35] = (         void  *)0;
 sqlstm.sqinds[35] = (         int  )0;
 sqlstm.sqharm[35] = (unsigned int  )0;
 sqlstm.sqadto[35] = (unsigned short )0;
 sqlstm.sqtdso[35] = (unsigned short )0;
 sqlstm.sqhstv[36] = (         void  *)&nd_regd_date_fr_2;
 sqlstm.sqhstl[36] = (unsigned int  )33;
 sqlstm.sqhsts[36] = (         int  )0;
 sqlstm.sqindv[36] = (         void  *)0;
 sqlstm.sqinds[36] = (         int  )0;
 sqlstm.sqharm[36] = (unsigned int  )0;
 sqlstm.sqadto[36] = (unsigned short )0;
 sqlstm.sqtdso[36] = (unsigned short )0;
 sqlstm.sqhstv[37] = (         void  *)&nd_regd_date_to_2;
 sqlstm.sqhstl[37] = (unsigned int  )33;
 sqlstm.sqhsts[37] = (         int  )0;
 sqlstm.sqindv[37] = (         void  *)0;
 sqlstm.sqinds[37] = (         int  )0;
 sqlstm.sqharm[37] = (unsigned int  )0;
 sqlstm.sqadto[37] = (unsigned short )0;
 sqlstm.sqtdso[37] = (unsigned short )0;
 sqlstm.sqhstv[38] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[38] = (unsigned int  )5;
 sqlstm.sqhsts[38] = (         int  )0;
 sqlstm.sqindv[38] = (         void  *)0;
 sqlstm.sqinds[38] = (         int  )0;
 sqlstm.sqharm[38] = (unsigned int  )0;
 sqlstm.sqadto[38] = (unsigned short )0;
 sqlstm.sqtdso[38] = (unsigned short )0;
 sqlstm.sqhstv[39] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[39] = (unsigned int  )33;
 sqlstm.sqhsts[39] = (         int  )0;
 sqlstm.sqindv[39] = (         void  *)0;
 sqlstm.sqinds[39] = (         int  )0;
 sqlstm.sqharm[39] = (unsigned int  )0;
 sqlstm.sqadto[39] = (unsigned short )0;
 sqlstm.sqtdso[39] = (unsigned short )0;
 sqlstm.sqhstv[40] = (         void  *)&nd_spec_type_fr_2;
 sqlstm.sqhstl[40] = (unsigned int  )7;
 sqlstm.sqhsts[40] = (         int  )0;
 sqlstm.sqindv[40] = (         void  *)0;
 sqlstm.sqinds[40] = (         int  )0;
 sqlstm.sqharm[40] = (unsigned int  )0;
 sqlstm.sqadto[40] = (unsigned short )0;
 sqlstm.sqtdso[40] = (unsigned short )0;
 sqlstm.sqhstv[41] = (         void  *)&nd_spec_type_to_2;
 sqlstm.sqhstl[41] = (unsigned int  )7;
 sqlstm.sqhsts[41] = (         int  )0;
 sqlstm.sqindv[41] = (         void  *)0;
 sqlstm.sqinds[41] = (         int  )0;
 sqlstm.sqharm[41] = (unsigned int  )0;
 sqlstm.sqadto[41] = (unsigned short )0;
 sqlstm.sqtdso[41] = (unsigned short )0;
 sqlstm.sqhstv[42] = (         void  *)&nd_anatomy_site_fr_2;
 sqlstm.sqhstl[42] = (unsigned int  )7;
 sqlstm.sqhsts[42] = (         int  )0;
 sqlstm.sqindv[42] = (         void  *)0;
 sqlstm.sqinds[42] = (         int  )0;
 sqlstm.sqharm[42] = (unsigned int  )0;
 sqlstm.sqadto[42] = (unsigned short )0;
 sqlstm.sqtdso[42] = (unsigned short )0;
 sqlstm.sqhstv[43] = (         void  *)&nd_anatomy_site_to_2;
 sqlstm.sqhstl[43] = (unsigned int  )7;
 sqlstm.sqhsts[43] = (         int  )0;
 sqlstm.sqindv[43] = (         void  *)0;
 sqlstm.sqinds[43] = (         int  )0;
 sqlstm.sqharm[43] = (unsigned int  )0;
 sqlstm.sqadto[43] = (unsigned short )0;
 sqlstm.sqtdso[43] = (unsigned short )0;
 sqlstm.sqhstv[44] = (         void  *)&nd_category_prfx_2;
 sqlstm.sqhstl[44] = (unsigned int  )7;
 sqlstm.sqhsts[44] = (         int  )0;
 sqlstm.sqindv[44] = (         void  *)0;
 sqlstm.sqinds[44] = (         int  )0;
 sqlstm.sqharm[44] = (unsigned int  )0;
 sqlstm.sqadto[44] = (unsigned short )0;
 sqlstm.sqtdso[44] = (unsigned short )0;
 sqlstm.sqhstv[45] = (         void  *)&nd_section_2;
 sqlstm.sqhstl[45] = (unsigned int  )5;
 sqlstm.sqhsts[45] = (         int  )0;
 sqlstm.sqindv[45] = (         void  *)0;
 sqlstm.sqinds[45] = (         int  )0;
 sqlstm.sqharm[45] = (unsigned int  )0;
 sqlstm.sqadto[45] = (unsigned short )0;
 sqlstm.sqtdso[45] = (unsigned short )0;
 sqlstm.sqhstv[46] = (         void  *)&nd_search_result_text_2;
 sqlstm.sqhstl[46] = (unsigned int  )4;
 sqlstm.sqhsts[46] = (         int  )0;
 sqlstm.sqindv[46] = (         void  *)0;
 sqlstm.sqinds[46] = (         int  )0;
 sqlstm.sqharm[46] = (unsigned int  )0;
 sqlstm.sqadto[46] = (unsigned short )0;
 sqlstm.sqtdso[46] = (unsigned short )0;
 sqlstm.sqhstv[47] = (         void  *)&nd_search_result_text_2;
 sqlstm.sqhstl[47] = (unsigned int  )4;
 sqlstm.sqhsts[47] = (         int  )0;
 sqlstm.sqindv[47] = (         void  *)0;
 sqlstm.sqinds[47] = (         int  )0;
 sqlstm.sqharm[47] = (unsigned int  )0;
 sqlstm.sqadto[47] = (unsigned short )0;
 sqlstm.sqtdso[47] = (unsigned short )0;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}


	return;
err_exit:

	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 48;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )884;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	disp_message(ORA_MESG,"Oracle error at dclr_request_header_cur_1() occured....\n");
	proc_exit();
}

/***SD-CRF-20059 from here ************/
void dclr_request_detail()  
{
// char test_error[200];//sunil

 //sprintf(test_error,"inside dclr_request_detail%s",d_specimen_no.arr);
 //disp_message(ERR_MESG,test_error);
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL DECLARE RL_REQ_DTL_CUR CURSOR FOR
              SELECT A.TEST_CODE,B.LONG_DESC
                FROM RL_REQUEST_DETAIL A,RL_TEST_CODE_lang_vw B 
                WHERE SPECIMEN_NO = :d_specimen_no_1
				AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				AND a.test_code = :d_test_code_1  //added condition against ML-SD-SCF-1972
				AND A.TEST_CODE =B.TEST_CODE
				and b.language_id = :language_id
				ORDER BY LINE_NO; */ 

     
	 return;
     err_exit:

    /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

    /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 48;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )899;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    disp_message(ORA_MESG,"Oracle error at dclr_request_detail() occured....\n");
    proc_exit();
}

void dclr_request_detail_2()  
{
 //char test_error[200];//sunil

 //sprintf(test_error,"inside dclr_request_detail_2%s",d_specimen_no_2.arr);
 //disp_message(ERR_MESG,test_error);
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL DECLARE RL_REQ_DTL_CUR_2 CURSOR FOR
              SELECT A.TEST_CODE,B.LONG_DESC
                FROM RL_REQUEST_DETAIL A,RL_TEST_CODE_lang_vw B 
                WHERE SPECIMEN_NO = :d_specimen_no_2
				AND OPERATING_FACILITY_ID = :nd_operating_facility_id
				AND A.TEST_CODE = :d_test_code_2 //added condition against ML-SD-SCF-1972
				AND A.TEST_CODE =B.TEST_CODE
				and b.language_id = :language_id
				ORDER BY LINE_NO; */ 

     
	 return;
     err_exit:

    /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

    /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 48;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )914;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    disp_message(ORA_MESG,"Oracle error at dclr_request_detail() occured....\n");
    proc_exit();
}

/*********laxmna************/

void dclr_test_result_cur_1()
{
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL DECLARE TEST_RESULT_CUR1 CURSOR FOR
//	SELECT DISTINCT A.NUMERIC_RESULT, A.RESULT_COMMENT_DESC1, A.RESULT_COMMENT_DESC2,
//  changed against ML-SD-SCF-1972
	SELECT DISTINCT A.SPECIMEN_NO,A.TEST_CODE, A.NUMERIC_RESULT, A.RESULT_COMMENT_DESC1, A.RESULT_COMMENT_DESC2,
	       A.RESULT_COMMENT_DESC3, A.RESULT_COMMENT_DESC4 
	FROM RL_TEST_RESULT A
	WHERE A.PATIENT_ID = :d_patient_id
	AND A.SPECIMEN_NO =  :d_specimen_no
	AND A.SECTION_CODE=  :nd_section_1
	AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
	AND ( ( :nd_search_result_text_1 = 'Y' AND 
	        EXISTS
            (SELECT 'X' 
            FROM   rl_result_text X
            WHERE  X.patient_id = A.patient_id
            AND    X.specimen_no = A.specimen_no
            AND    X.operating_facility_id = A.operating_facility_id
            AND    NVL(X.cancer_register_yn, 'N') = 'Y' 
            )
		  )
          OR
		  (:nd_search_result_text_1 = 'N' AND 1=1)
		); */ 


    return;

err_exit:

    /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

    /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 48;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )929;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    disp_message(ORA_MESG,"Oracle error at dclr_test_result_cur_1() occured....\n");
    proc_exit();
}

void dclr_test_result_cur_2()
{
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


  /*	EXEC SQL DECLARE TEST_RESULT_CUR2 CURSOR FOR
	SELECT  A.SPECIMEN_NO,B.CATEGORY_CODE, B.CATEGORY_YEAR,B.CATEGORY_NUMBER,
			A.NUMERIC_RESULT, A.RESULT_COMMENT_DESC1, A.RESULT_COMMENT_DESC2,
	        A.RESULT_COMMENT_DESC3, A.RESULT_COMMENT_DESC4 
	FROM RL_TEST_RESULT A,RL_REQUEST_HEADER B
	WHERE A.PATIENT_ID = :d_patient_id_prv
	AND A.SPECIMEN_NO = B.SPECIMEN_NO
	AND A.SPECIMEN_NO =  :d_specimen_no_prv
	AND A.SECTION_CODE=  :nd_section_2
	AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
	AND ( ( :nd_search_result_text_2 = 'Y' AND 
	        EXISTS
            (SELECT 'X' 
            FROM   rl_result_text X
            WHERE  X.patient_id = A.patient_id
            AND    X.specimen_no = A.specimen_no
            AND    X.operating_facility_id = A.operating_facility_id
            AND    NVL(X.cancer_register_yn, 'N') = 'Y' 
            )
		  )
          OR
		  (:nd_search_result_text_2 = 'N' AND 1=1)
		);
*/
/*********start*********commented and changed the query on 26/10/2007 against ML-SD-SCF-1972**********
	EXEC SQL DECLARE TEST_RESULT_CUR2 CURSOR FOR
	SELECT DISTINCT A.SPECIMEN_NO,B.CATEGORY_CODE, B.CATEGORY_YEAR,B.CATEGORY_NUMBER,
	       A.NUMERIC_RESULT, A.RESULT_COMMENT_DESC1, A.RESULT_COMMENT_DESC2,
	       A.RESULT_COMMENT_DESC3, A.RESULT_COMMENT_DESC4
	FROM RL_TEST_RESULT A, RL_REQUEST_HEADER B
	WHERE A.SPECIMEN_NO = B.SPECIMEN_NO
	AND A.SPECIMEN_NO IN (SELECT SPECIMEN_NO FROM RL_SAMPLE_DETAILS C
						  WHERE C.SPECIMEN_NO = A.SPECIMEN_NO
						    AND NVL(C.ANATOMY_SITE_CODE, '!') 
							    BETWEEN NVL(:nd_anatomy_site_fr_2,NVL(C.ANATOMY_SITE_CODE,'!'))
						        AND NVL(:nd_anatomy_site_to_2, NVL(C.ANATOMY_SITE_CODE,'!'))
						 )
	 AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
	 AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
	 AND A.PATIENT_ID = :d_patient_id_prv
	 AND B.SPEC_REGD_DATE_TIME > TO_DATE(:nd_regd_date_fr_2, 'DD/MM/YYYY') 
		 AND B.SPEC_REGD_DATE_TIME < TO_DATE(:nd_regd_date_to_2, 'DD/MM/YYYY') + 1
	 AND NVL(B.SPECIMEN_TYPE_CODE, '!') 
	     BETWEEN NVL(:nd_spec_type_fr_2, NVL(B.SPECIMEN_TYPE_CODE,'!'))
		 AND NVL(:nd_spec_type_to_2, NVL(B.SPECIMEN_TYPE_CODE,'!'))
	 AND NVL(B.CATEGORY_CODE,'!') = NVL(:nd_category_prfx_2, NVL(B.CATEGORY_CODE,'!'))
	 AND NVL(B.STATUS,'O') != 'O'
	 AND B.SECTION_CODE = :nd_section_2
	AND ( ( :nd_search_result_text_2 = 'Y' AND 
	        EXISTS
            (SELECT 'X' 
            FROM   rl_result_text X
            WHERE  X.patient_id = A.patient_id
            AND    X.specimen_no = A.specimen_no
            AND    X.operating_facility_id = A.operating_facility_id
            AND    NVL(X.cancer_register_yn, 'N') = 'Y' 
            )
		  )
          OR
		  (:nd_search_result_text_2 = 'N' AND 1=1)
		)
	 UNION
	 SELECT DISTINCT A.SPECIMEN_NO , B.CATEGORY_CODE, B.CATEGORY_YEAR,B.CATEGORY_NUMBER,
	        A.NUMERIC_RESULT, A.RESULT_COMMENT_DESC1, A.RESULT_COMMENT_DESC2,
			A.RESULT_COMMENT_DESC3, A.RESULT_COMMENT_DESC4
	 FROM RL_TEST_RESULT A, RL_REQUEST_HEADER B
	 WHERE (A.SPECIMEN_NO = B.SPECIMEN_NO
	 AND A.SPECIMEN_NO IN (SELECT SPECIMEN_NO FROM RL_SPECIMEN_ANATOMY_DTLS C  //CHANGED FROM (or) TO (and) on 03/09/2007 SD-CRF-20059
						   WHERE C.SPECIMEN_NO = A.SPECIMEN_NO
						   AND NVL(C.ANATOMY_SITE_CODE, '!') 
						       BETWEEN NVL(:nd_anatomy_site_fr_2, NVL(C.ANATOMY_SITE_CODE,'!'))
						       AND NVL(:nd_anatomy_site_to_2, NVL(C.ANATOMY_SITE_CODE,'!'))
						  ))
	 AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
	 AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
	 AND A.PATIENT_ID = :d_patient_id_prv
	 AND B.SPEC_REGD_DATE_TIME > TO_DATE(:nd_regd_date_fr_2, 'DD/MM/YYYY') 
		 AND B.SPEC_REGD_DATE_TIME < TO_DATE(:nd_regd_date_to_2, 'DD/MM/YYYY') + 1
	 AND NVL(B.SPECIMEN_TYPE_CODE,'!') 
	     BETWEEN NVL(:nd_spec_type_fr_2, NVL(B.SPECIMEN_TYPE_CODE,'!'))
		 AND NVL(:nd_spec_type_to_2, NVL(B.SPECIMEN_TYPE_CODE,'!'))
	 AND NVL(B.CATEGORY_CODE,'!') = NVL(:nd_category_prfx_2, NVL(B.CATEGORY_CODE, '!'))
	 AND NVL(B.STATUS,'O') != 'O'
	 AND B.SECTION_CODE = :nd_section_2
	AND ( ( :nd_search_result_text_2 = 'Y' AND 
	        EXISTS
            (SELECT 'X' 
            FROM   rl_result_text X
            WHERE  X.patient_id = A.patient_id
            AND    X.specimen_no = A.specimen_no
            AND    X.operating_facility_id = A.operating_facility_id
            AND    NVL(X.cancer_register_yn, 'N') = 'Y' 
            )
		  )
          OR
		  (:nd_search_result_text_2 = 'N' AND 1=1)
		)
	 ORDER BY 1;
	 **********************end**********/
	
	/**
	SELECT NUMERIC_RESULT, RESULT_COMMENT_DESC1, RESULT_COMMENT_DESC2,
	       RESULT_COMMENT_DESC3, RESULT_COMMENT_DESC4 
	FROM RL_TEST_RESULT
	WHERE PATIENT_ID = :d_patient_id
	AND SPECIMEN_NO = :d_specimen_no
	AND OPERATING_FACILITY_ID = :nd_operating_facility_id;
    **/
		/* EXEC SQL DECLARE TEST_RESULT_CUR2 CURSOR FOR
	    SELECT DISTINCT A.SPECIMEN_NO,B.TEST_CODE,A.CATEGORY_CODE,A.CATEGORY_YEAR,A.CATEGORY_NUMBER,
		B.NUMERIC_RESULT, B.RESULT_COMMENT_DESC1, B.RESULT_COMMENT_DESC2,
	       B.RESULT_COMMENT_DESC3, B.RESULT_COMMENT_DESC4 
		 FROM 
		 (
		 SELECT DISTINCT * FROM
		(SELECT DISTINCT A.SPECIMEN_NO ,A.PATIENT_ID PATIENT_ID,
		       A.CATEGORY_CODE,A.CATEGORY_YEAR,A.CATEGORY_NUMBER,A.SECTION_CODE,
			   A.SOURCE_CODE,A.EPISODE_TYPE,A.SOURCE_TYPE
		FROM RL_REQUEST_HEADER A, RL_SAMPLE_DETAILS B
		WHERE A.SPEC_REGD_DATE_TIME > TO_DATE(:nd_regd_date_fr_2, 'DD/MM/YYYY') 
		AND	A.SPEC_REGD_DATE_TIME < TO_DATE(:nd_regd_date_to_2, 'DD/MM/YYYY') + 1 
	    AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND A.SPECIMEN_NO = B.SPECIMEN_NO 
		AND A.PATIENT_ID = nvl(:d_patient_id_prv,A.PATIENT_ID)
		AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
		AND NVL(A.SPECIMEN_TYPE_CODE, '!') BETWEEN NVL(:nd_spec_type_fr_2, NVL(A.SPECIMEN_TYPE_CODE,'!'))
										   AND NVL(:nd_spec_type_to_2, NVL(A.SPECIMEN_TYPE_CODE,'!'))
        
		AND NVL(B.ANATOMY_SITE_CODE, '!') BETWEEN NVL(:nd_anatomy_site_fr_2, NVL(B.ANATOMY_SITE_CODE,'!'))
										  AND NVL(:nd_anatomy_site_to_2, NVL(B.ANATOMY_SITE_CODE,'!'))
        AND   NVL(A.CATEGORY_CODE,'!') = NVL(:nd_category_prfx_2, NVL(A.CATEGORY_CODE, '!'))
	AND NVL(A.STATUS,'O') != 'O'
		AND  A.SECTION_CODE = :nd_section_2 
			AND ( ( :nd_search_result_text_2 = 'Y' AND 
	        EXISTS
            (SELECT 'X' 
            FROM   rl_result_text X
            WHERE  X.patient_id = A.patient_id
            AND    X.specimen_no = A.specimen_no
            AND    X.operating_facility_id = A.operating_facility_id
            AND    NVL(X.cancer_register_yn, 'N') = 'Y' 
            )
		  )
          OR
		  (:nd_search_result_text_2 = 'N' AND 1=1)
		)
		UNION
		SELECT DISTINCT A.SPECIMEN_NO ,A.PATIENT_ID PATIENT_ID,
		       A.CATEGORY_CODE,A.CATEGORY_YEAR,A.CATEGORY_NUMBER,A.SECTION_CODE,
			   A.SOURCE_CODE,A.EPISODE_TYPE,A.SOURCE_TYPE
		FROM RL_REQUEST_HEADER A, RL_SPECIMEN_ANATOMY_DTLS B
		WHERE A.SPEC_REGD_DATE_TIME > TO_DATE(:nd_regd_date_fr_2, 'DD/MM/YYYY') AND
			A.SPEC_REGD_DATE_TIME < TO_DATE(:nd_regd_date_to_2, 'DD/MM/YYYY') + 1
		AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND A.SPECIMEN_NO = B.SPECIMEN_NO(+) 
		AND A.PATIENT_ID = nvl(:d_patient_id_prv,A.PATIENT_ID)
		AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID(+)
		AND NVL(A.SPECIMEN_TYPE_CODE, '!') BETWEEN NVL(:nd_spec_type_fr_2, NVL(A.SPECIMEN_TYPE_CODE,'!'))
										   AND NVL(:nd_spec_type_to_2, NVL(A.SPECIMEN_TYPE_CODE,'!'))
		AND NVL(B.ANATOMY_SITE_CODE, '!') BETWEEN NVL(:nd_anatomy_site_fr_2, NVL(B.ANATOMY_SITE_CODE,'!'))
										AND NVL(:nd_anatomy_site_to_2, NVL(B.ANATOMY_SITE_CODE,'!'))
        AND  NVL(A.CATEGORY_CODE,'!') = NVL(:nd_category_prfx_2, NVL(A.CATEGORY_CODE, '!'))
		AND NVL(A.STATUS,'O') != 'O'
		AND A.SECTION_CODE = :nd_section_2 
			AND ( ( :nd_search_result_text_2 = 'Y' AND 
	        EXISTS
            (SELECT 'X' 
            FROM   rl_result_text X
            WHERE  X.patient_id = A.patient_id
            AND    X.specimen_no = A.specimen_no
            AND    X.operating_facility_id = A.operating_facility_id
            AND    NVL(X.cancer_register_yn, 'N') = 'Y' 
            )
		  )
          OR
		  (:nd_search_result_text_2 = 'N' AND 1=1)
		) 
		)
		)
		 A,RL_TEST_RESULT B
		WHERE A.SPECIMEN_NO = B.SPECIMEN_NO
		  AND A.SECTION_CODE = B.SECTION_CODE
     
		ORDER BY A.SPECIMEN_NO; */ 



    return;

err_exit:
    /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

    /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 48;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )944;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    disp_message(ORA_MESG,"Oracle error at dclr_test_result_cur_2() occured....\n");
    proc_exit();
}



void open_test_result_cur_1()
{
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL OPEN TEST_RESULT_CUR1; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 48;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0019;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )959;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_specimen_no;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_section_1;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_search_result_text_1;
    sqlstm.sqhstl[4] = (unsigned int  )4;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_search_result_text_1;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}



	return;
err_exit:
    /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

    /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 48;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )998;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    disp_message(ORA_MESG,"Oracle error at open_test_result_cur_1() occured....\n");
    proc_exit();
}
void open_request_detail_cur() //laxamn
{
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL OPEN RL_REQ_DTL_CUR; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 48;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0015;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1013;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_specimen_no_1;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_test_code_1;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&language_id;
    sqlstm.sqhstl[3] = (unsigned int  )7;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}



	return;
err_exit:
    /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

    /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 48;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1044;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    disp_message(ORA_MESG,"Oracle error at open_request_detail_cur() occured....\n");
    proc_exit();
}
void open_request_detail_cur_2() //laxamn
{
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL OPEN RL_REQ_DTL_CUR_2; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 48;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = sq0017;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1059;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_specimen_no_2;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_test_code_2;
    sqlstm.sqhstl[2] = (unsigned int  )13;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&language_id;
    sqlstm.sqhstl[3] = (unsigned int  )7;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}



	return;
err_exit:
    /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

    /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 48;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1090;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    disp_message(ORA_MESG,"Oracle error at open_request_detail_cur() occured....\n");
    proc_exit();
}
void open_test_result_cur_2()
{
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


    /* EXEC SQL OPEN TEST_RESULT_CUR2; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 48;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlbuft((void **)0, 
      "select distinct A.SPECIMEN_NO ,B.TEST_CODE ,A.CATEGORY_CODE ,A.CATEGO\
RY_YEAR ,A.CATEGORY_NUMBER ,B.NUMERIC_RESULT ,B.RESULT_COMMENT_DESC1 ,B.RESU\
LT_COMMENT_DESC2 ,B.RESULT_COMMENT_DESC3 ,B.RESULT_COMMENT_DESC4  from (sele\
ct distinct *  from (select distinct A.SPECIMEN_NO ,A.PATIENT_ID PATIENT_ID \
,A.CATEGORY_CODE ,A.CATEGORY_YEAR ,A.CATEGORY_NUMBER ,A.SECTION_CODE ,A.SOUR\
CE_CODE ,A.EPISODE_TYPE ,A.SOURCE_TYPE  from RL_REQUEST_HEADER A ,RL_SAMPLE_\
DETAILS B where (((((((((((A.SPEC_REGD_DATE_TIME>TO_DATE(:b0,'DD/MM/YYYY') a\
nd A.SPEC_REGD_DATE_TIME<(TO_DATE(:b1,'DD/MM/YYYY')+1)) and A.OPERATING_FACI\
LITY_ID=:b2) and A.SPECIMEN_NO=B.SPECIMEN_NO) and A.PATIENT_ID=nvl(:b3,A.PAT\
IENT_ID)) and A.OPERATING_FACILITY_ID=B.OPERATING_FACILITY_ID) and NVL(A.SPE\
CIMEN_TYPE_CODE,'!') between NVL(:b4,NVL(A.SPECIMEN_TYPE_CODE,'!')) and NVL(\
:b5,NVL(A.SPECIMEN_TYPE_CODE,'!'))) and NVL(B.ANATOMY_SITE_CODE,'!') between\
 NVL(:b6,NVL(B.ANATOMY_SITE_CODE,'!')) and NVL(:b7,NVL(B.ANATOMY_SITE_CODE,'\
!'))) and NVL(A.CATEGORY_CODE,'!')=NVL(:b8,");
    sqlbuft((void **)0, 
      "NVL(A.CATEGORY_CODE,'!'))) and NVL(A.STATUS,'O')<>'O') and A.SECTION_\
CODE=:b9) and ((:b10='Y' and exists (select 'X'  from rl_result_text X where\
 (((X.patient_id=A.patient_id and X.specimen_no=A.specimen_no) and X.operati\
ng_facility_id=A.operating_facility_id) and NVL(X.cancer_register_yn,'N')='Y\
'))) or (:b10='N' and 1=1))) union select distinct A.SPECIMEN_NO ,A.PATIENT_\
ID PATIENT_ID ,A.CATEGORY_CODE ,A.CATEGORY_YEAR ,A.CATEGORY_NUMBER ,A.SECTIO\
N_CODE ,A.SOURCE_CODE ,A.EPISODE_TYPE ,A.SOURCE_TYPE  from RL_REQUEST_HEADER\
 A ,RL_SPECIMEN_ANATOMY_DTLS B where (((((((((((A.SPEC_REGD_DATE_TIME>TO_DAT\
E(:b0,'DD/MM/YYYY') and A.SPEC_REGD_DATE_TIME<(TO_DATE(:b1,'DD/MM/YYYY')+1))\
 and A.OPERATING_FACILITY_ID=:b2) and A.SPECIMEN_NO=B.SPECIMEN_NO(+)) and A.\
PATIENT_ID=nvl(:b3,A.PATIENT_ID)) and A.OPERATING_FACILITY_ID=B.OPERATING_FA\
CILITY_ID(+)) and NVL(A.SPECIMEN_TYPE_CODE,'!') between NVL(:b4,NVL(A.SPECIM\
EN_TYPE_CODE,'!')) and NVL(:b5,NVL(A.SPECIMEN_TYPE_CODE,'!'))) and NVL(B.ANA\
TOMY_SITE_CODE,'!') between NVL(:b6,NVL(B.A");
    sqlstm.stmt = sq0021;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1105;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_regd_date_fr_2;
    sqlstm.sqhstl[0] = (unsigned int  )33;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_regd_date_to_2;
    sqlstm.sqhstl[1] = (unsigned int  )33;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[2] = (unsigned int  )5;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_patient_id_prv;
    sqlstm.sqhstl[3] = (unsigned int  )33;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_spec_type_fr_2;
    sqlstm.sqhstl[4] = (unsigned int  )7;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_spec_type_to_2;
    sqlstm.sqhstl[5] = (unsigned int  )7;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_anatomy_site_fr_2;
    sqlstm.sqhstl[6] = (unsigned int  )7;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&nd_anatomy_site_to_2;
    sqlstm.sqhstl[7] = (unsigned int  )7;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&nd_category_prfx_2;
    sqlstm.sqhstl[8] = (unsigned int  )7;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&nd_section_2;
    sqlstm.sqhstl[9] = (unsigned int  )5;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&nd_search_result_text_2;
    sqlstm.sqhstl[10] = (unsigned int  )4;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&nd_search_result_text_2;
    sqlstm.sqhstl[11] = (unsigned int  )4;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&nd_regd_date_fr_2;
    sqlstm.sqhstl[12] = (unsigned int  )33;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&nd_regd_date_to_2;
    sqlstm.sqhstl[13] = (unsigned int  )33;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[14] = (unsigned int  )5;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&d_patient_id_prv;
    sqlstm.sqhstl[15] = (unsigned int  )33;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&nd_spec_type_fr_2;
    sqlstm.sqhstl[16] = (unsigned int  )7;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&nd_spec_type_to_2;
    sqlstm.sqhstl[17] = (unsigned int  )7;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&nd_anatomy_site_fr_2;
    sqlstm.sqhstl[18] = (unsigned int  )7;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&nd_anatomy_site_to_2;
    sqlstm.sqhstl[19] = (unsigned int  )7;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&nd_category_prfx_2;
    sqlstm.sqhstl[20] = (unsigned int  )7;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&nd_section_2;
    sqlstm.sqhstl[21] = (unsigned int  )5;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&nd_search_result_text_2;
    sqlstm.sqhstl[22] = (unsigned int  )4;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&nd_search_result_text_2;
    sqlstm.sqhstl[23] = (unsigned int  )4;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}


	return;
err_exit:
    /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

    /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 48;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1216;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


    disp_message(ORA_MESG,"Oracle error at open_test_result_cur_2() occured....\n");
    proc_exit();
}

/* prepares for the new page */
void prepare_new_page()
{
   fprintf(fp,"\n");

   fprintf(fp,"\f");
   line_no = 1;
   // page_no++;
   print_page_header();
   print_col_heading();
}

/* to print the last line of the report */
void end_report()
{
  fprintf(fp,"\n");  
  //fprintf(fp,"                      ******** End of Report *********");
  fprintf(fp,"                      ******** %s *********", local_legend[22]); //added for globalisation
  fprintf(fp,"\n");
  fprintf(fp,"\f");
}

gen_file_name()
{
	 /* For a constant file name (4 lines) */

  	 strcpy(nd_file_name.arr,WORKING_DIR) ;
     nd_file_name.len = strlen(nd_file_name.arr);

	 strcat(nd_file_name.arr,OUTPUT_FILE_NAME);
	 nd_file_name.len = strlen(nd_file_name.arr);
	 if ((fp = fopen(nd_file_name.arr,"w")) == NULL)
     {
       sprintf(string_var,"Error while opening file %s\n",nd_file_name.arr);
	   disp_message(ERR_MESG,string_var) ;
       proc_exit();
     }

}

void do_report()
{
  char l_h_or_c;
    
  void open_test_result_cur_1();
  int fetch_request_header();
  int fetch_request_header_1();
  int still_rec_left;
  int still_rec_left1;
  int still_dtl_left;//SD-CRF-20059
  void print_rep_header();
  void printt_page_header() ;
  
  int  get_in_patient_dtl(); //SD-CRF-20059
  void get_referral_patient_dtl();//SD-CRF-20059
  void get_source_name();//SD-CRF-20059
  void open_request_detail_cur();//SD-CRF-20059
  int fetch_request_detail();//SD-CRF-20059
  page_no = 1;
  line_no = 1;
  
  l_h_or_c = 'Z';
  
  if (strcmp(nd_section_ind_1.arr, "HI") == 0)
     //strcpy(first_section_title, "Histology");
     strcpy(first_section_title, local_legend[2]); //added for globalisation
  else if (strcmp(nd_section_ind_1.arr, "CY") == 0)
     //strcpy(first_section_title, "Cytology");
     strcpy(first_section_title, local_legend[3]); //added for globalisation

  if (strcmp(nd_section_ind_2.arr, "HI") == 0)
     //strcpy(second_section_title, "Histology");
     strcpy(second_section_title, local_legend[2]); //added for globalisation
  else if (strcmp(nd_section_ind_2.arr, "CY") == 0)
     //strcpy(second_section_title, "Cytology");
     strcpy(second_section_title, local_legend[3]); //added for globalisation

  strcpy(d_section_ind_prv.arr, "");

  strcpy(d_patient_id_prv.arr, "");
  
 //Start Added Code on 15/05/2007 against scf1664 by ramesh

if (strcmp(nd_search_type.arr, "Y") == 0)
 {
  still_rec_left1 = fetch_request_header();
  print_rep_header();
  print_page_header();
  print_col_heading();
 
 
  while(still_rec_left1)
  {
          dclr_request_header_cur_1();
		  still_rec_left = fetch_request_header_1();
		 
		  while(still_rec_left)
		  {
			chk_break(line_no);

			if (strcmp(d_patient_id.arr, d_patient_id_prv.arr) != 0)
			{
				if (strlen(d_patient_id_prv.arr) != 0)
				{
			
				if (rec_found == 0 )
				{

		  			  //fprintf(fp,"%c&d0D",ESC);   /* Set  UnderLine ON*/  //ML-SD-SCF-1958
	  		          fprintf(fp, "%s\n", second_section_title);
			          //fprintf(fp,"%c&d@",ESC);   /* Set UnderLine OFF */ //ML-SD-SCF-1958

					  fprint_repeat(fp,'-',strlen(second_section_title)); //ML-SD-SCF-1958
					  fprintf(fp,"\n");                                   //ML-SD-SCF-1958
					line_no = line_no + 2;
					d_patient_id_prv.len = strlen(d_patient_id_prv.arr);
					open_test_result_cur_2();
					print_detl_rec_2();
					close_test_result_cur_2();
					fprint_repeat(fp,'-',78);
					fprintf(fp,"\n");
					line_no = line_no + 1;
                 }
				}
         
		      if(strcmp(d_episode_type.arr,"I")==0 || strcmp(d_episode_type.arr,"O")==0 ||
					strcmp(d_episode_type.arr,"H")==0)
					i = get_in_patient_dtl();
			  else
				if(strcmp(d_episode_type.arr,"R")==0)
					get_referral_patient_dtl();

                get_source_name(); //SD-CRF-20059

          

				strcpy(d_patient_id_prv.arr, d_patient_id.arr);
				//fprintf(fp,"Patient ID : %-15.15s\n", d_patient_id.arr);SD-CRF-20059
				//fprintf(fp,"Patient ID :%-15.15s Name :%-59.59s\n", d_patient_id.arr,d_patient_name.arr);
				fprintf(fp,"%-10.10s :%-15.15s %-4.4s :%-59.59s\n", local_legend[4], d_patient_id.arr,local_legend[5], d_patient_name.arr); //added for globalisation
				//fprintf(fp,"NRIC  :%-20.20s Source :%s\n",d_nationality_id.arr,d_source_name.arr);  
				fprintf(fp,"%-4.4s  :%-20.20s %-6.6s :%s\n",local_legend[6], d_nationality_id.arr,local_legend[6], d_source_name.arr);//added for   
				fprintf(fp,"\n");
				//line_no = line_no + 2;    SD-CRF-20059
				line_no = line_no + 3;
				
				//fprintf(fp,"%c&d0D",ESC);   /* Set  UnderLine ON*/  //ML-SD-SCF-1958
	  		    fprintf(fp, "%s\n", first_section_title);
			    //fprintf(fp,"%c&d@",ESC);   /* Set UnderLine OFF */  //ML-SD-SCF-1958
				fprint_repeat(fp,'-',strlen(first_section_title)); //ML-SD-SCF-1958
				fprintf(fp,"\n");                                  //ML-SD-SCF-1958
				line_no = line_no + 2;

			}
			
			if (strcmp(nd_section_code.arr,nd_section_1.arr)==0 )
			{	
			/*******commednted against ML-SD-SCF-1972
					if (strlen(d_category_num.arr) > 0 )
					{
					fprintf(fp, "%-5.5s/%-4.4s/%-11.11s", d_category_code.arr,
														  d_category_year.arr,
														  d_category_num.arr); 
					}
					else
					{
						fprintf(fp, "%-5.5s %-4.4s %-11.11s", " ",
														  " ",
														  " "); 
					}  ********** end *******/

			open_test_result_cur_1();
			print_detl_rec_1();
		
			}

			still_rec_left = fetch_request_header_1();
			if (still_rec_left == 0)
			{
		
			   rec_found = 1;
		        
				//fprintf(fp,"%c&d0D",ESC);   /* Set  UnderLine ON*/  //ML-SD-SCF-1958
	  		    fprintf(fp, "%s\n", second_section_title);
			    //fprintf(fp,"%c&d@",ESC);   /* Set UnderLine OFF */  //ML-SD-SCF-1958

				fprint_repeat(fp,'-',strlen(second_section_title));  //ML-SD-SCF-1958
				fprintf(fp,"\n");                                    //ML-SD-SCF-1958
				line_no = line_no + 2;
				d_patient_id_prv.len = strlen(d_patient_id_prv.arr);
				open_test_result_cur_2();
				print_detl_rec_2();
				close_test_result_cur_2();
				fprint_repeat(fp,'-',78);
				fprintf(fp,"\n");
				line_no = line_no + 1; 
             }
		     else
			 {
			 rec_found = 0;
			}

			fprintf(fp, "\n");

		  }
	    
		close_request_header_1();
	    close_test_result_cur_1(); 	 
		still_rec_left1 = fetch_request_header();
     }
	
	 close_request_header();
     end_report();
 }
  else
  {	
  

  //End Added Code on 15/05/2007 against scf1664 by ramesh

  //start added on 30/10/2007 against the ML-SD-SCF-1972 
  still_rec_left1 = fetch_request_header_bb();
  print_rep_header();
  print_page_header();
  print_col_heading();

  

 
  while(still_rec_left1)
  {
  //end
          dclr_request_header_cur_1();
		  still_rec_left = fetch_request_header_1();

		  l_sec_cnt = 0; // added on 02-11-2007
		  while(still_rec_left)
		  {
			chk_break(line_no);
			
			if (strcmp(d_patient_id.arr, d_patient_id_prv.arr) != 0)
			{
				if (strlen(d_patient_id_prv.arr) != 0)
				{
			
				if (rec_found == 0 )		//added check condition against ML-SD-SCF-1972
				{
/* from here commented on 02-11-2007	aginst ML-SD-SCF-1972 */
//		  			  fprintf(fp,"%c&d0D",ESC);   /* Set  UnderLine ON*/
//	  		          fprintf(fp, "%s\n", second_section_title);
//			          fprintf(fp,"%c&d@",ESC);   /* Set UnderLine OFF */
//					line_no = line_no + 1;
/* upto here commented on 02-11-2007	aginst ML-SD-SCF-1972 */
					d_patient_id_prv.len = strlen(d_patient_id_prv.arr);
					l_sec_cnt =0; // added on 02-11-2007
					open_test_result_cur_2();
					print_detl_rec_2();
					close_test_result_cur_2();
					fprint_repeat(fp,'-',78);
					fprintf(fp,"\n");
					line_no = line_no + 1;
                 }
				}
         
		      if(strcmp(d_episode_type.arr,"I")==0 || strcmp(d_episode_type.arr,"O")==0 ||
					strcmp(d_episode_type.arr,"H")==0)
					i = get_in_patient_dtl();
			  else
				if(strcmp(d_episode_type.arr,"R")==0)
					get_referral_patient_dtl();

                get_source_name(); //SD-CRF-20059

          

				strcpy(d_patient_id_prv.arr, d_patient_id.arr);
				//fprintf(fp,"Patient ID : %-15.15s\n", d_patient_id.arr);SD-CRF-20059
				//fprintf(fp,"Patient ID :%-15.15s Name :%-59.59s\n", d_patient_id.arr,d_patient_name.arr);
				fprintf(fp,"%-10.10s :%-15.15s %-4.4s :%-59.59s\n", local_legend[4], d_patient_id.arr,local_legend[5],d_patient_name.arr);//added for globalisation
				//fprintf(fp,"NRIC  :%-20.20s Source :%s\n",d_nationality_id.arr,d_source_name.arr);  
				fprintf(fp,"%-4.4s  :%-20.20s %-6.6s :%s\n",local_legend[6], d_nationality_id.arr,local_legend[7], d_source_name.arr); //added for globalisation 
				fprintf(fp,"\n");
				//line_no = line_no + 2;    SD-CRF-20059
				line_no = line_no + 3;
/* from here commented on 02-11-2007	aginst ML-SD-SCF-1972 */
//				fprintf(fp,"%c&d0D",ESC);   /* Set  UnderLine ON*/
//	  		    fprintf(fp, "%s\n", first_section_title);
//			    fprintf(fp,"%c&d@",ESC);   /* Set UnderLine OFF */
//				fprintf(fp,"\n");
//				line_no = line_no + 1;
/* upto here commented on 02-11-2007	aginst ML-SD-SCF-1972 */
			}
			
			if (strcmp(nd_section_code.arr,nd_section_1.arr)==0 )
			{
				
			/*******commednted against ML-SD-SCF-1972
					if (strlen(d_category_num.arr) > 0 )
					{
					fprintf(fp, "%-5.5s/%-4.4s/%-11.11s", d_category_code.arr,
														  d_category_year.arr,
														  d_category_num.arr); 
					}
					else
					{
						fprintf(fp, "%-5.5s %-4.4s %-11.11s", " ",
														  " ",
														  " "); 
					}  ********** end *******/
			
			open_test_result_cur_1();
			print_detl_rec_1();
		
			}
			

			still_rec_left = fetch_request_header_1();
			if (still_rec_left == 0)
			{
		
			   rec_found = 1;   //ML-SD-SCF-1972
/* from here commented on 02-11-2007	aginst ML-SD-SCF-1972 */
//				fprintf(fp,"%c&d0D",ESC);   /* Set  UnderLine ON*/
//	  		    fprintf(fp, "%s\n", second_section_title);
//			    fprintf(fp,"%c&d@",ESC);   /* Set UnderLine OFF */
//				line_no = line_no + 1;
/* upto here commented on 02-11-2007	aginst ML-SD-SCF-1972 */
				d_patient_id_prv.len = strlen(d_patient_id_prv.arr);
				l_sec_cnt =0; // added on 02-11-2007
				open_test_result_cur_2();
				print_detl_rec_2();
				close_test_result_cur_2();
				fprint_repeat(fp,'-',78);
				fprintf(fp,"\n");
				line_no = line_no + 1; 
             }
		     else		//added else condition against ML-SD-SCF-1972
			 {
			 rec_found = 0;   
			}

			fprintf(fp, "\n");

		  }
		close_request_header_1();
	    close_test_result_cur_1(); 	 
		still_rec_left1 = fetch_request_header_bb();//added on 30/10/2007 against the ML-SD-SCF-1972 
     }
	
	 close_request_header_bb();//added on 30/10/2007 against the ML-SD-SCF-1972 
     end_report();
 }
}

close_request_header_1()
{
	/* EXEC SQL CLOSE HEADER_CUR1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 48;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1231;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

/*------------*/
//Start Added Close_request_header on 15/05/2007 against scf1664 by ramesh
close_request_header()
{
	/* EXEC SQL CLOSE HEADER_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 48;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1246;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}
//start added on 30/10/2007 against the ML-SD-SCF-1972 
close_request_header_bb()
{
	/* EXEC SQL CLOSE HEADER_CUR_bb; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 48;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1261;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}
//end
//Start Fetch Request Header Code on 15/05/2007 against scf1664 by ramesh
/*-------------------*/
int fetch_request_header()
{

  /*d_category_code.arr[0]      = '\0';
  d_category_year.arr[0]      = '\0';
  d_category_num.arr[0]       = '\0';

  d_category_code.len      = 0;
  d_category_year.len      = 0;
  d_category_num.len       = 0;*/
  
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


  /* EXEC SQL FETCH HEADER_CUR INTO :d_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 48;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1276;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[0] = (unsigned int  )33;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}


                 /*:d_specimen_no, :d_patient_id,
				 :d_category_code,:d_category_year,:d_category_num;*/
  
  if (NODATAFOUND)
    return 0;
  d_patient_id.arr[d_patient_id.len]        = '\0';
  
  /*d_specimen_no.arr[d_specimen_no.len]      = '\0';
  
  d_category_code.arr[d_category_code.len]  = '\0';
  d_category_year.arr[d_category_year.len]  = '\0';
  d_category_num.arr[d_category_num.len]    = '\0';*/

#ifdef DEBUG
  printf("d_specimen_no = %s\n",d_specimen_no.arr);
  printf("d_patient_id = %s\n",d_patient_id.arr);
#endif

  return 1;

err_exit:
  /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

  /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 48;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1295;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


  disp_message(ORA_MESG,"Oracle error at fetch_request_header() occured....\n");
  proc_exit();
}
/*---------------------*/
//start added on 30/10/2007 against the ML-SD-SCF-1972 
int fetch_request_header_bb()
{

  /*d_category_code.arr[0]      = '\0';
  d_category_year.arr[0]      = '\0';
  d_category_num.arr[0]       = '\0';

  d_category_code.len      = 0;
  d_category_year.len      = 0;
  d_category_num.len       = 0;*/
  
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


  /* EXEC SQL FETCH HEADER_CUR_bb INTO :d_patient_id; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 48;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1310;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[0] = (unsigned int  )33;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}


                 /*:d_specimen_no, :d_patient_id,
				 :d_category_code,:d_category_year,:d_category_num;*/
  
  if (NODATAFOUND)
    return 0;
  d_patient_id.arr[d_patient_id.len]        = '\0';
  
  /*d_specimen_no.arr[d_specimen_no.len]      = '\0';
  
  d_category_code.arr[d_category_code.len]  = '\0';
  d_category_year.arr[d_category_year.len]  = '\0';
  d_category_num.arr[d_category_num.len]    = '\0';*/

#ifdef DEBUG
  printf("d_specimen_no = %s\n",d_specimen_no.arr);
  printf("d_patient_id = %s\n",d_patient_id.arr);
#endif

  return 1;

err_exit:
  /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

  /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 48;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1329;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


  disp_message(ORA_MESG,"Oracle error at fetch_request_header_bb() occured....\n");
  proc_exit();
}
//end
/*---------------------*/




int fetch_request_header_1()
{

  d_category_code.arr[0]      = '\0';
  d_category_year.arr[0]      = '\0';
  d_category_num.arr[0]       = '\0';
  nd_section_code.arr[0]       ='\0';
  
  d_category_code.len      = 0;
  d_category_year.len      = 0;
  d_category_num.len       = 0;
  nd_section_code.len	   =0;	
  
  
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


  /* EXEC SQL FETCH HEADER_CUR1 INTO
                 :d_specimen_no, :d_patient_id,
				 :d_category_code,:d_category_year,:d_category_num,:nd_section_code,
				 :d_source_code,:d_episode_type,:d_source_type; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 48;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1344;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_specimen_no;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_category_code;
  sqlstm.sqhstl[2] = (unsigned int  )7;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_category_year;
  sqlstm.sqhstl[3] = (unsigned int  )7;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_category_num;
  sqlstm.sqhstl[4] = (unsigned int  )18;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_section_code;
  sqlstm.sqhstl[5] = (unsigned int  )5;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_source_code;
  sqlstm.sqhstl[6] = (unsigned int  )9;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_episode_type;
  sqlstm.sqhstl[7] = (unsigned int  )4;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_source_type;
  sqlstm.sqhstl[8] = (unsigned int  )4;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}


  
  if (NODATAFOUND)
    return 0;

  d_specimen_no.arr[d_specimen_no.len]      = '\0';
  d_patient_id.arr[d_patient_id.len]        = '\0';
  d_category_code.arr[d_category_code.len]  = '\0';
  d_category_year.arr[d_category_year.len]  = '\0';
  d_category_num.arr[d_category_num.len]    = '\0';
  nd_section_code.arr[nd_section_code.len]  = '\0';
  d_source_code.arr[d_source_code.len]  = '\0';
  d_episode_type.arr[d_episode_type.len]  = '\0';
  d_source_type.arr[d_source_type.len]  = '\0';

#ifdef DEBUG
  printf("d_specimen_no = %s\n",d_specimen_no.arr);
  printf("d_patient_id = %s\n",d_patient_id.arr);
#endif

  return 1;

err_exit:
  /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

  /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 48;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1395;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


  disp_message(ORA_MESG,"Oracle error at fetch_request_header_1() occured....\n");
  proc_exit();
}


close_test_result_cur_1()
{
	/* EXEC SQL CLOSE TEST_RESULT_CUR1; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 48;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1410;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}
close_request_detail_cur()//SD-CRF-20059
{
	/* EXEC SQL CLOSE RL_REQ_DTL_CUR; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 48;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1425;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}
close_request_detail_cur_2()//SD-CRF-20059
{
	/* EXEC SQL CLOSE RL_REQ_DTL_CUR_2; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 48;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1440;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}
int fetch_test_result_1()
{

  d_numeric_result.arr[0] = '\0';
  d_rc_1.arr[0] = '\0';
  d_rc_2.arr[0] = '\0';
  d_rc_3.arr[0] = '\0';
  d_rc_4.arr[0] = '\0';

  d_numeric_result.len = 0;
  d_rc_1.len = 0;
  d_rc_2.len = 0;
  d_rc_3.len = 0;
  d_rc_4.len = 0;  


  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


  /* EXEC SQL FETCH TEST_RESULT_CUR1 
	    //INTO :d_specimen_no_1,:d_numeric_result,:d_rc_1, :d_rc_2,:d_rc_3,:d_rc_4; 
		//changed against ML-SD-SCF-1972
	    INTO :d_specimen_no_1,:d_test_code_1, :d_numeric_result,:d_rc_1, :d_rc_2,:d_rc_3,:d_rc_4; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 48;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1455;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_specimen_no_1;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_test_code_1;
  sqlstm.sqhstl[1] = (unsigned int  )13;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_numeric_result;
  sqlstm.sqhstl[2] = (unsigned int  )18;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_rc_1;
  sqlstm.sqhstl[3] = (unsigned int  )43;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_rc_2;
  sqlstm.sqhstl[4] = (unsigned int  )43;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_rc_3;
  sqlstm.sqhstl[5] = (unsigned int  )43;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_rc_4;
  sqlstm.sqhstl[6] = (unsigned int  )43;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}


  if (NODATAFOUND)
    return 0;
  d_specimen_no_1.arr[d_specimen_no_1.len] = '\0';
  d_test_code_1.arr[d_test_code_1.len] = '\0';
  d_numeric_result.arr[d_numeric_result.len] = '\0';
  d_rc_1.arr[d_rc_1.len] = '\0';
  d_rc_2.arr[d_rc_2.len] = '\0';
  d_rc_3.arr[d_rc_3.len] = '\0';
  d_rc_4.arr[d_rc_4.len] = '\0'; 


  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 48;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1498;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_test_result_1() occured....\n");
   proc_exit();
}
int fetch_request_detail() //SD-CRF-20059
{
   d_test_desc.arr[d_test_desc.len] = '\0';
   d_test_desc.len = 0;
    d_test_code.arr[d_test_code.len] = '\0';
   d_test_code.len = 0;
  
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 



  /* EXEC SQL FETCH RL_REQ_DTL_CUR 
	    INTO :d_test_code,:d_test_desc; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 48;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1513;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_test_code;
  sqlstm.sqhstl[0] = (unsigned int  )13;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_test_desc;
  sqlstm.sqhstl[1] = (unsigned int  )42;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}



  if (NODATAFOUND)
    return 0;
     d_test_code.arr[d_test_code.len] = '\0';
     d_test_desc.arr[d_test_desc.len] = '\0';
   return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 48;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1536;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_request_detail() occured....\n");
   proc_exit();
}
int fetch_request_detail_2() //SD-CRF-20059
{
   d_test_desc.arr[d_test_desc.len] = '\0';
   d_test_desc.len = 0;
    d_test_code.arr[d_test_code.len] = '\0';
   d_test_code.len = 0;
  
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 



  /* EXEC SQL FETCH RL_REQ_DTL_CUR_2 
	    INTO :d_test_code,:d_test_desc; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 48;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1551;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_test_code;
  sqlstm.sqhstl[0] = (unsigned int  )13;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_test_desc;
  sqlstm.sqhstl[1] = (unsigned int  )42;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}



  if (NODATAFOUND)
    return 0;
     d_test_code.arr[d_test_code.len] = '\0';
     d_test_desc.arr[d_test_desc.len] = '\0';
   return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 48;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1574;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_request_detail_2() occured....\n");
   proc_exit();
}
void print_detl_rec_1()
{
	
	int p_flg2	 = 0;
	int c_no2    = 0;
    
	strcpy(d_specimen_no_1_prv.arr, "");
	d_specimen_no_1_prv.len = strlen(d_specimen_no_1_prv.arr);

	
	while (fetch_test_result_1())
	{
		if (strcmp(d_specimen_no_1.arr, d_specimen_no_1_prv.arr) != 0)
		{
			
		/*	if (strlen(d_specimen_no_1_prv.arr) != 0)
			{
			   chk_break(line_no);
               fprintf(fp, "\n");
               line_no++;
			   print_result_text();
			}
          */  
			strcpy(d_specimen_no_1_prv.arr, d_specimen_no_1.arr);
			d_specimen_no_1_prv.len = strlen(d_specimen_no_1_prv.arr);

            chk_break(line_no);
/*********** commented on 26-10-07 against  ML-SD-SCF-1972
			fprintf(fp, "%-5.5s/%-4.4s/%-11.11s", d_category_code.arr,
										  d_category_year.arr,
										  d_category_num.arr);
										  **************/
            
			p_flg2 = 0;

		}
/* from here added on 02-11-2007	aginst ML-SD-SCF-1972 */
		if (l_sec_cnt ==0)
		{
				//fprintf(fp,"%c&d0D",ESC);   /* Set  UnderLine ON*/  //ML-SD-SCF-1958
	  		    fprintf(fp, "%s\n", first_section_title);
			    //fprintf(fp,"%c&d@",ESC);   /* Set UnderLine OFF */ //ML-SD-SCF-1958
				fprint_repeat(fp,'-',strlen(first_section_title));//ML-SD-SCF-1958
				fprintf(fp,"\n");                                  //ML-SD-SCF-1958
				line_no = line_no + 2;
				l_sec_cnt++;
		}
/* upto here added on 02-11-2007	aginst ML-SD-SCF-1972 */
/******** added on 26-10-2007  against ML-SD-SCF-1972 ****start********/
			if (strlen(d_category_num.arr) > 0 )
			{
				chk_break(line_no);		/* Added by Durai Rajkumar against MF-SCF-0114 */
				fprintf(fp, "%-5.5s/%-4.4s/%-11.11s", d_category_code.arr,
													  d_category_year.arr,
													  d_category_num.arr); 
			}
			else
			{
				chk_break(line_no);		/* Added by Durai Rajkumar against MF-SCF-0114 */
				fprintf(fp, "%-5.5s %-4.4s %-11.11s", " /",
													  " /",
													  " /"); 
			} /***********end*********/

		if (strlen(d_rc_1.arr) != 0) 
		{
		  if (p_flg2 != 0)
		  {
			chk_break(line_no);
			fprintf(fp, "%s","                      ");
		  }

		  c_no2 = 1;
		  fprintf(fp, "%-40.40s\n", d_rc_1.arr);
		  p_flg2 = 1;
		  line_no++;

		}
		if (strlen(d_rc_2.arr) != 0)
		{
		  
		  if (p_flg2 != 0)
		  {
			chk_break(line_no);
		  }
		  if (c_no2 != 1)
		  {
			fprintf(fp, "%s","                                      ");
		  }

		  c_no2 = 2;
		  fprintf(fp, "%-40.40s\n", d_rc_2.arr);
		  p_flg2 = 1;
		  line_no++;
		}
		if (strlen(d_rc_3.arr) != 0) 
		{
		  if (p_flg2 != 0)
		  {
			chk_break(line_no);
		  }

		  if (c_no2 != 2)
		  {
			fprintf(fp, "%s","                                      ");
		  }

		  c_no2 = 3;
		  fprintf(fp, "%-40.40s\n", d_rc_3.arr);
		  p_flg2 = 1;
		  line_no++;
		}
		if (strlen(d_rc_4.arr) != 0)
		{
		  if (p_flg2 != 0)
		  {
			chk_break(line_no);
		  }

		  if (c_no2 != 3)
		  {
			fprintf(fp, "%s","                                      ");
		  }

		  c_no2 = 4;
		  fprintf(fp, "%-40.40s\n", d_rc_4.arr);
		  p_flg2 = 1;
		  line_no++;
		}
    
             //FROM HERE SD-CRF-20059 
			  fprintf(fp,"\n");
			  line_no = line_no + 1;  
  		      dclr_request_detail();
              open_request_detail_cur(); 
   			  //fprintf(fp,"%c&d0D",ESC);   /* Set  UnderLine ON*/ //ML-SD-SCF-1958
			  //fprintf(fp,"Tests Ordered---->  Test Code   Test Description\n");
			  fprintf(fp,"%-13.13s---->  %-9.9s   %-16.16s\n", local_legend[8],local_legend[9], local_legend[10]);//added for globalisation
			  fprintf(fp,"------------------------------------------------\n"); //ML-SD-SCF-1958
			  //fprintf(fp,"%c&d@",ESC);   /* Set UnderLine OFF */  //ML-SD-SCF-1958
			       //fprintf(fp,"\n");
			  line_no = line_no + 2; 
			  while(fetch_request_detail())
              { 
			   fprintf(fp, "%-19.s %-11.11s %s","",d_test_code.arr,d_test_desc.arr);
			   fprintf(fp,"\n");
               line_no = line_no + 1; 
			   print_result_text(); //added on 26/10/2007 against ML-SD-SCF-1972
			   fprintf(fp, "\n");
			   line_no++;
              } 
			 close_request_detail_cur();
			 //UPTO HERE SD-CRF-20059 
  			
           

	}
	
	/*** After Finishing the While Loop , for Last Specimen ***/

    chk_break(line_no);
    fprintf(fp, "\n");
   line_no++;
 // print_result_text(); commented on 26/10/2007 against ML-SD-SCF-1972

	// print_clinical_history();

return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 48;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1589;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at print_detl_rec_1() occured....\n");
   proc_exit();
}


print_result_text()
{
	int ctr = 0;
	int len = 0;
	int r_ctr = 0;
	char l_string[100];

 //char test_error[200];//sunil

// sprintf(test_error,"inside print_result_text%s",d_specimen_no.arr);
// disp_message(ERR_MESG,test_error);

	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	/* EXEC SQL DECLARE result_text_cur CURSOR FOR
		SELECT specimen_no , result_text_code, result_text
		FROM RL_RESULT_TEXT
		WHERE patient_id = :d_patient_id
		AND specimen_no = :d_specimen_no_1
		AND operating_facility_id = :nd_operating_facility_id
		and test_code = :d_test_code_1      // addded condition against ML-SD-SCF-1972
		AND ( ( :nd_search_result_text_1 = 'Y' AND NVL(cancer_register_yn, 'N') = 'Y') OR
		      ( :nd_search_result_text_1 = 'N' AND 1=1)
			)
		ORDER BY specimen_no; */ 


	/* EXEC SQL OPEN result_text_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 48;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0034;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1604;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_patient_id;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_specimen_no_1;
 sqlstm.sqhstl[1] = (unsigned int  )23;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_test_code_1;
 sqlstm.sqhstl[3] = (unsigned int  )13;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_search_result_text_1;
 sqlstm.sqhstl[4] = (unsigned int  )4;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_search_result_text_1;
 sqlstm.sqhstl[5] = (unsigned int  )4;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	ctr = 0;

	split_result_text();

	/* EXEC SQL CLOSE result_text_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 48;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1643;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
 if (sqlca.sqlcode < 0) goto err_exit;
}



	return;
err_exit:
	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 48;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1658;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	disp_message(ORA_MESG,"Oracle error at print_result_text() occured....\n");
	proc_exit();
}

/**** Splitting Result Text ****/
split_result_text()
{
	char word[2];
	char w_flag ;
	char l_first;

    strcpy(word1,"F");

	w_flag = 'T';

	l_first = 'Y';

    while(fetch_result_text())
    {
	  if (l_first == 'Y')
	  {  
	    l_first = 'N';
		/*
		fprintf(fp,"     Text Result\n");
        fprintf(fp,"     -----------\n");
        line_no = line_no + 2;
		*/
	  }

      something_to_print = 1;

	  l_var = strlen(d_result_text.arr);

         z = 0;
	     clt = 0;
	     strcpy(word1,"F"); 
	     cntr = 1;
	     qq = 0;

         while(z<l_var)
         {
             word[0] = d_result_text.arr[z];
 		     word[1] = '\0';

		     if (strcmp(word,"\n") == 0)
		     {
		       cntr = 0;
		       strcpy(word1,"N");
		       qq = z ;
		      }

  		      if(cntr >= 54) 
		      {
		   	
			     cmp = cntr;
			     while((d_result_text.arr[z] != 32) && (cmp > 1))
			     {
			         z--;
				     cmp--;
			      }

				  qq = z;
				  			   
			      word[0] = d_result_text.arr[z];
   			      word[1] = '\0';
		
		  	      if (cmp == 1)
				     strcpy(word1,"W");
			      else
			         strcpy(word1,"T");
			   
		      }


				if (((z == l_var) || (z == l_var - 1)) && (strcmp(word1,"F") == 0))
				{
	
				   chk_break(line_no);

				   fprint_repeat(fp,' ',22);
				   for(i=clt;i < z + 1;i++)
		           {
						if(d_result_text.arr[i] == '\n')
						{


							    w_flag = 'F';
 						 }

						fprintf(fp,"%c",d_result_text.arr[i]);
		
			       }

				   if (w_flag == 'T')
				   {
				   };

			       fprintf	(fp,"\n");
                   line_no++;

				   cntr = 0 ;
				   clt = clt + 53 ;
				   z = clt ;
			       qq = 0;
				   strcpy(word1,"F");
				}

			
		       if (strcmp(word1,"N") == 0) 
		       {
				
		          chk_break(line_no);
				  
				  line_no++;

				  fprint_repeat(fp,' ',22);
				  for(i=clt;i<=qq;i++)
		          {
			         if(d_result_text.arr[i] == '\n')
					{
						  
								w_flag = 'F';

				    }

				    fprintf(fp,"%c",d_result_text.arr[i]);
					
			      }

				  if (w_flag == 'T')
				  {
				  };
					
			      strcpy(word1,"F");
			      cntr = 0 ;
			      clt = qq + 1;
		          qq = 0;
	   	       }

		       if (strcmp(word1,"T") == 0)
		       {
		 										 
			      chk_break(line_no);

				  fprint_repeat(fp,' ',22);		   
				  for(i=clt;i<= qq;i++)
		          {
		             if(d_result_text.arr[i] == '\n')
					 {
						w_flag = 'F';
					  }

					  fprintf(fp,"%c",d_result_text.arr[i]);
				
			      }

				  if (w_flag == 'T')
				  {
				  };

					fprintf	(fp,"\n");
					line_no++;

			       cntr = 0 ;
				   clt = qq + 1 ;
			       qq = 0;
				   strcpy(word1,"F");

				
		        }


		        if (strcmp(word1,"W") == 0)
		        {
		 										 
			       chk_break(line_no);

				   fprint_repeat(fp,' ',22);
				   for(i=clt;i < clt + 53;i++)
		           {
		              if(d_result_text.arr[i] == '\n')
						{

								w_flag = 'F';
						}

						fprintf(fp,"%c",d_result_text.arr[i]);
			       }

				   if (w_flag = 'T')
				   {
				   };

			       fprintf(fp,"\n");
                   line_no++;

				   cntr = 0 ;
				   clt = clt + 53;
				   z = clt ;
			       qq = 0;
				   strcpy(word1,"F");

				
		        }

			w_flag = 'T';	  
	        cntr += 1;
	        z++ ;
          }
		
      }
  
       fflush(fp);

#ifdef DEBUG
   printf("rl_res_result_text = %s\n", d_result_text.arr);
#endif

if (OERROR)
      disp_message(ERR_MESG, "SPLITTING failed on table RL_RESULT_TEXT");

}


/*------------------------------*/
close_test_result_cur_2()
{
	/* EXEC SQL CLOSE TEST_RESULT_CUR2; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 48;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1673;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

/*------------------------------*/
int fetch_test_result_2()
{
  d_specimen_no_2.arr[0] = '\0';
  d_test_code_2.arr[0] = '\0';  //ML-SD-SCF-1972
  d_numeric_result_2.arr[0] = '\0'; 
  d_rc_1_2.arr[0] = '\0';
  d_rc_2_2.arr[0] = '\0';
  d_rc_3_2.arr[0] = '\0';
  d_rc_4_2.arr[0] = '\0';

  d_specimen_no.len = 0;
  d_test_code_2.len = 0;  //ML-SD-SCF-1972
  d_numeric_result_2.len = 0;
  d_rc_1_2.len = 0;
  d_rc_2_2.len = 0;
  d_rc_3_2.len = 0;
  d_rc_4_2.len = 0;  

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH TEST_RESULT_CUR2
 /o* INTO :d_specimen_no_2,:d_category_code_2,d_category_year_2,d_category_num_2,
		     :d_numeric_result_2,:d_rc_1_2, :d_rc_2_2,:d_rc_3_2,:d_rc_4_2;
  ********changed against ML-SD-SCF-1972 *****o/
	    INTO :d_specimen_no_2,:d_test_code_2,:d_category_code_2,d_category_year_2,d_category_num_2,
		     :d_numeric_result_2,:d_rc_1_2, :d_rc_2_2,:d_rc_3_2,:d_rc_4_2; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 48;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1688;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_specimen_no_2;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_test_code_2;
  sqlstm.sqhstl[1] = (unsigned int  )13;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_category_code_2;
  sqlstm.sqhstl[2] = (unsigned int  )7;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_category_year_2;
  sqlstm.sqhstl[3] = (unsigned int  )7;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_category_num_2;
  sqlstm.sqhstl[4] = (unsigned int  )18;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_numeric_result_2;
  sqlstm.sqhstl[5] = (unsigned int  )18;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_rc_1_2;
  sqlstm.sqhstl[6] = (unsigned int  )43;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_rc_2_2;
  sqlstm.sqhstl[7] = (unsigned int  )43;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_rc_3_2;
  sqlstm.sqhstl[8] = (unsigned int  )43;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_rc_4_2;
  sqlstm.sqhstl[9] = (unsigned int  )43;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}


 /*EXEC SQL FETCH TEST_RESULT_CUR2
	    INTO     :d_numeric_result_2,:d_rc_1_2, :d_rc_2_2,:d_rc_3_2,:d_rc_4_2;*/
  

  if (NODATAFOUND)
    return 0;

  d_specimen_no_2.arr[d_specimen_no_2.len] = '\0';
  d_test_code_2.arr[d_test_code_2.len] = '\0';  //against ML-SD-SCF-1972
  d_category_code_2.arr[d_category_code_2.len] = '\0';
  d_category_year_2.arr[d_category_year_2.len] = '\0';
  d_category_num_2.arr[d_category_num_2.len] = '\0';
  d_numeric_result_2.arr[d_numeric_result_2.len] = '\0';
  d_rc_1_2.arr[d_rc_1_2.len] = '\0';
  d_rc_2_2.arr[d_rc_2_2.len] = '\0';
  d_rc_3_2.arr[d_rc_3_2.len] = '\0';
  d_rc_4_2.arr[d_rc_4_2.len] = '\0';

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 48;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1743;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_test_result_1() occured....\n");
   proc_exit();
}

/*------------------------------*/
void print_detl_rec_2()
{
	
	int p_flg2	 = 0;
	int c_no2    = 0;

	strcpy(d_specimen_no_2_prv.arr, "");
	d_specimen_no_2_prv.len = strlen(d_specimen_no_2_prv.arr);

	
	while (fetch_test_result_2())
	{
		if (strcmp(d_specimen_no_2.arr, d_specimen_no_2_prv.arr) != 0)
		{
			
	/***	if (strlen(d_specimen_no_2_prv.arr) != 0)
			{
			   chk_break(line_no);
               fprintf(fp, "\n");
               line_no++;
			   print_result_text_2();
			}  ********* commented on 26/10/2007 against ML-SD-SCF-1972/
            
			strcpy(d_specimen_no_2_prv.arr, d_specimen_no_2.arr);
			d_specimen_no_2_prv.len = strlen(d_specimen_no_2_prv.arr);

	
            chk_break(line_no);
	/**********COMMENTED 26/10/2007******************against ML-SD-SCF-1972
			fprintf(fp, "%-5.5s/%-4.4s/%-11.11s", d_category_code_2.arr,
										  d_category_year_2.arr,
										  d_category_num_2.arr);
        ***************************/    
			p_flg2 = 0;



		}
		if (l_sec_cnt ==0)
		{
		  //fprintf(fp,"%c&d0D",ESC);   /* Set  UnderLine ON*/  //ML-SD-SCF-1958
	  	  fprintf(fp, "%s\n", second_section_title);
		  //fprintf(fp,"%c&d@",ESC);   /* Set UnderLine OFF */ //ML-SD-SCF-1958
		
		  fprint_repeat(fp,'-',strlen(second_section_title));  //ML-SD-SCF-1958
		  fprintf(fp,"\n");                                    //ML-SD-SCF-1958
		  line_no = line_no + 2;
		  l_sec_cnt++;
		}
/********added against ML-SD-SCF-1972 ******START*/
		if (strlen(d_category_num_2.arr) > 0 )
		{
			chk_break(line_no);		/* Added by Durai Rajkumar against MF-SCF-0114 */
			fprintf(fp, "%-5.5s/%-4.4s/%-11.11s", d_category_code_2.arr,
												  d_category_year_2.arr,
												  d_category_num_2.arr); 
		}
		else
		{
			chk_break(line_no);		/* Added by Durai Rajkumar against MF-SCF-0114 */
			fprintf(fp, "%-5.5s %-4.4s %-11.11s", " /",
												  " /",
												  " /"); 
		} /*****************end*************/


		if (strlen(d_rc_1_2.arr) != 0) 
		{
		  if (p_flg2 != 0)
		  {
			chk_break(line_no);
			fprintf(fp, "%s","                      ");
		  }

		  c_no2 = 1;
		  fprintf(fp, "%-40.40s\n", d_rc_1_2.arr);
		  p_flg2 = 1;
		  line_no++;

		}
		if (strlen(d_rc_2_2.arr) != 0)
		{
		  
		  if (p_flg2 != 0)
		  {
			chk_break(line_no);
		  }
		  if (c_no2 != 1)
		  {
			fprintf(fp, "%s","                                      ");
		  }

		  c_no2 = 2;
		  fprintf(fp, "%-40.40s\n", d_rc_2_2.arr);
		  p_flg2 = 1;
		  line_no++;
		}
		if (strlen(d_rc_3_2.arr) != 0) 
		{
		  if (p_flg2 != 0)
		  {
			chk_break(line_no);
		  }

		  if (c_no2 != 2)
		  {
			fprintf(fp, "%s","                                      ");
		  }

		  c_no2 = 3;
		  fprintf(fp, "%-40.40s\n", d_rc_3_2.arr);
		  p_flg2 = 1;
		  line_no++;
		}
		if (strlen(d_rc_4_2.arr) != 0)
		{
		  if (p_flg2 != 0)
		  {
			chk_break(line_no);
		  }

		  if (c_no2 != 3)
		  {
			fprintf(fp, "%s","                                      ");
		  }

		  c_no2 = 4;
		  fprintf(fp, "%-40.40s\n", d_rc_4_2.arr);
		  p_flg2 = 1;
		  line_no++;
		}
    
             //FROM HERE SD-CRF-20059 
			  fprintf(fp,"\n");
			  line_no = line_no + 1;  
  		      dclr_request_detail_2();
              open_request_detail_cur_2(); 
   			  //fprintf(fp,"%c&d0D",ESC);   /* Set  UnderLine ON*/ //ML-SD-SCF-1958
			  //fprintf(fp,"Tests Ordered---->  Test Code   Test Description\n");
			  fprintf(fp,"%-13.13s---->  %-9.9s   %-16.16s\n", local_legend[8],local_legend[9], local_legend[10]);//added for globalisation
			  fprintf(fp,"------------------------------------------------\n"); //ML-SD-SCF-1958
			  //fprintf(fp,"%c&d@",ESC);   /* Set UnderLine OFF */ //ML-SD-SCF-1958
			       //fprintf(fp,"\n");
			  line_no = line_no + 2; 
			  while(fetch_request_detail_2())
              { 
			   fprintf(fp, "%-19.s %-11.11s %s","",d_test_code.arr,d_test_desc.arr);
			   fprintf(fp,"\n");
			   line_no = line_no + 1; 
			   print_result_text_2(); //added on 26/10/2007 against ML-SD-SCF-1972
			   fprintf(fp, "\n");
			   line_no++;
              } 
			 close_request_detail_cur_2();
			 //UPTO HERE SD-CRF-20059 
  			
           

	}
	
	/*** After Finishing the While Loop , for Last Specimen ***/

    chk_break(line_no);
    fprintf(fp, "\n");
    line_no++;
    //print_result_text_2();   commented on 26/10/2007 against ML-SD-SCF-1972

	// print_clinical_history();

return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 48;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1758;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at print_detl_rec_1() occured....\n");
   proc_exit();
}

print_result_text_2()
{
	int ctr = 0;
	int len = 0;
	int r_ctr = 0;

	char l_string[100];

/********************commented  against ML-SD-SCF-1972 ********start****
	
	EXEC SQL WHENEVER SQLERROR GOTO err_exit;
	EXEC SQL DECLARE result_text_cur2 CURSOR FOR
		SELECT distinct A.SPECIMEN_NO , A.RESULT_TEXT_CODE, A.RESULT_TEXT
		FROM RL_RESULT_TEXT A, RL_REQUEST_HEADER B
		WHERE A.SPECIMEN_NO = :d_specimen_no_2
		AND A.SPECIMEN_NO = B.SPECIMEN_NO
		AND A.TEST_CODE = :d_test_code_2
		AND A.SPECIMEN_NO IN (SELECT SPECIMEN_NO FROM RL_SAMPLE_DETAILS C
		                      WHERE C.SPECIMEN_NO = A.SPECIMEN_NO
							  AND NVL(C.ANATOMY_SITE_CODE, '!') 
							  BETWEEN NVL(:nd_anatomy_site_fr_2,NVL(C.ANATOMY_SITE_CODE,'!'))
							  AND NVL(:nd_anatomy_site_to_2, NVL(C.ANATOMY_SITE_CODE,'!'))
							 )
		AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
		AND A.PATIENT_ID = :d_patient_id_prv
		AND B.SPEC_REGD_DATE_TIME > TO_DATE(:nd_regd_date_fr_2, 'DD/MM/YYYY') 
			AND B.SPEC_REGD_DATE_TIME < TO_DATE(:nd_regd_date_to_2, 'DD/MM/YYYY') + 1
		AND NVL(B.SPECIMEN_TYPE_CODE, '!') 
		    BETWEEN NVL(:nd_spec_type_fr_2, NVL(B.SPECIMEN_TYPE_CODE,'!'))
			AND NVL(:nd_spec_type_to_2, NVL(B.SPECIMEN_TYPE_CODE,'!'))
		AND NVL(B.CATEGORY_CODE,'!') = NVL(:nd_category_prfx_2, NVL(B.CATEGORY_CODE,'!'))
		AND NVL(B.STATUS,'O') != 'O'
	//	AND B.SECTION_CODE = :nd_section_1
		AND ( ( :nd_search_result_text_2 = 'Y' AND NVL(A.cancer_register_yn, 'N') = 'Y') OR
		      ( :nd_search_result_text_2 = 'N' AND 1=1)
			)
		UNION
		SELECT distinct A.SPECIMEN_NO , A.RESULT_TEXT_CODE, A.RESULT_TEXT
		FROM RL_RESULT_TEXT A, RL_REQUEST_HEADER B
		WHERE A.SPECIMEN_NO = :d_specimen_no_2
		AND A.TEST_CODE = :d_test_code_2
		AND (A.SPECIMEN_NO = B.SPECIMEN_NO
		or A.SPECIMEN_NO IN (SELECT SPECIMEN_NO FROM RL_SPECIMEN_ANATOMY_DTLS C
		                      WHERE C.SPECIMEN_NO = A.SPECIMEN_NO
		                      AND NVL(C.ANATOMY_SITE_CODE, '!') 
							  BETWEEN NVL(:nd_anatomy_site_fr_2, NVL(C.ANATOMY_SITE_CODE,'!'))
							  AND NVL(:nd_anatomy_site_to_2, NVL(C.ANATOMY_SITE_CODE,'!'))
							 ))
		AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID
		AND A.PATIENT_ID = :d_patient_id_prv
		AND B.SPEC_REGD_DATE_TIME > TO_DATE(:nd_regd_date_fr_2, 'DD/MM/YYYY') 
		AND B.SPEC_REGD_DATE_TIME < TO_DATE(:nd_regd_date_to_2, 'DD/MM/YYYY') + 1
		AND NVL(B.SPECIMEN_TYPE_CODE,'!') 
			BETWEEN NVL(:nd_spec_type_fr_2, NVL(B.SPECIMEN_TYPE_CODE,'!'))
			AND NVL(:nd_spec_type_to_2, NVL(B.SPECIMEN_TYPE_CODE,'!'))
		AND NVL(B.CATEGORY_CODE,'!') = NVL(:nd_category_prfx_2, NVL(B.CATEGORY_CODE, '!'))
		AND NVL(B.STATUS,'O') != 'O'
	//	AND B.SECTION_CODE = :nd_section_1
		AND ( ( :nd_search_result_text_2 = 'Y' AND NVL(A.cancer_register_yn, 'N') = 'Y') OR
		      ( :nd_search_result_text_2 = 'N' AND 1=1)
			)
		ORDER BY 1;   ******************upto here ********/
		
		/*
		SELECT specimen_no , result_text_code, result_text
		FROM RL_RESULT_TEXT
		WHERE patient_id = :d_patient_id
		AND specimen_no = :d_specimen_no
		AND operating_facility_id = :nd_operating_facility_id
		ORDER BY specimen_no;
		sunil */

		/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

		/* EXEC SQL DECLARE result_text_cur2 CURSOR FOR
		SELECT specimen_no , result_text_code, result_text
		FROM RL_RESULT_TEXT
		WHERE patient_id = :d_patient_id_prv
		AND specimen_no = :d_specimen_no_2
		AND operating_facility_id = :nd_operating_facility_id
		AND TEST_CODE = :d_test_code_2  //added condition against ML-SD-SCF-1972
		AND ( ( :nd_search_result_text_1 = 'Y' AND NVL(cancer_register_yn, 'N') = 'Y') OR
		      ( :nd_search_result_text_1 = 'N' AND 1=1)
			)
		ORDER BY specimen_no; */ 
    


	/* EXEC SQL OPEN result_text_cur2; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 48;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0038;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1773;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_patient_id_prv;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_specimen_no_2;
 sqlstm.sqhstl[1] = (unsigned int  )23;
 sqlstm.sqhsts[1] = (         int  )0;
 sqlstm.sqindv[1] = (         void  *)0;
 sqlstm.sqinds[1] = (         int  )0;
 sqlstm.sqharm[1] = (unsigned int  )0;
 sqlstm.sqadto[1] = (unsigned short )0;
 sqlstm.sqtdso[1] = (unsigned short )0;
 sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[2] = (unsigned int  )5;
 sqlstm.sqhsts[2] = (         int  )0;
 sqlstm.sqindv[2] = (         void  *)0;
 sqlstm.sqinds[2] = (         int  )0;
 sqlstm.sqharm[2] = (unsigned int  )0;
 sqlstm.sqadto[2] = (unsigned short )0;
 sqlstm.sqtdso[2] = (unsigned short )0;
 sqlstm.sqhstv[3] = (         void  *)&d_test_code_2;
 sqlstm.sqhstl[3] = (unsigned int  )13;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_search_result_text_1;
 sqlstm.sqhstl[4] = (unsigned int  )4;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_search_result_text_1;
 sqlstm.sqhstl[5] = (unsigned int  )4;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
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
 if (sqlca.sqlcode < 0) goto err_exit;
}



	ctr = 0;

	split_result_text_2();

	/* EXEC SQL CLOSE result_text_cur2; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 48;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1812;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
 if (sqlca.sqlcode < 0) goto err_exit;
}



	return;
err_exit:
	/* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

	/* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 48;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )1827;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


	disp_message(ORA_MESG,"Oracle error at print_result_text_2() occured....\n");
	proc_exit();
}

/**** Splitting Result Text ****/

split_result_text_2()
{
	char word[2];
	char w_flag ;
	char l_first;

    strcpy(word1,"F");

	w_flag = 'T';

	l_first = 'Y';

    while(fetch_result_text_2())
    {
	  if (l_first == 'Y')
	  {  
	    l_first = 'N';
		/*
		fprintf(fp,"     Text Result\n");
        fprintf(fp,"     -----------\n");
        line_no = line_no + 2;
		*/
	  }

      something_to_print = 1;

	  l_var = strlen(d_result_text_2.arr);

         z = 0;
	     clt = 0;
	     strcpy(word1,"F"); 
	     cntr = 1;
	     qq = 0;

         while(z<l_var)
         {
             word[0] = d_result_text_2.arr[z];
 		     word[1] = '\0';

		     if (strcmp(word,"\n") == 0)
		     {
		       cntr = 0;
		       strcpy(word1,"N");
		       qq = z ;
		      }

  		      if(cntr >= 54) 
		      {
		   	
			     cmp = cntr;
			     while((d_result_text_2.arr[z] != 32) && (cmp > 1))
			     {
			         z--;
				     cmp--;
			      }

				  qq = z;
				  			   
			      word[0] = d_result_text_2.arr[z];
   			      word[1] = '\0';
		
		  	      if (cmp == 1)
				     strcpy(word1,"W");
			      else
			         strcpy(word1,"T");
			   
		      }


				if (((z == l_var) || (z == l_var - 1)) && (strcmp(word1,"F") == 0))
				{
	
				   chk_break(line_no);

				   fprint_repeat(fp,' ',22);
				   for(i=clt;i < z + 1;i++)
		           {
						if(d_result_text_2.arr[i] == '\n')
						{


							    w_flag = 'F';
 						 }

						fprintf(fp,"%c",d_result_text_2.arr[i]);
			
			       }

				   if (w_flag == 'T')
				   {
				   };

			       fprintf	(fp,"\n");

                   line_no++;

				   cntr = 0 ;
				   clt = clt + 53 ;
				   z = clt ;
			       qq = 0;
				   strcpy(word1,"F");
				}

			
		       if (strcmp(word1,"N") == 0) 
		       {
				
		          chk_break(line_no);
				  
				  line_no++;

				  fprint_repeat(fp,' ',22);
				  for(i=clt;i<=qq;i++)
		          {
			         if(d_result_text_2.arr[i] == '\n')
					{
						  
								w_flag = 'F';

				    }

				    fprintf(fp,"%c",d_result_text_2.arr[i]);
					
			      }

				  if (w_flag == 'T')
				  {
				  };
					
			      strcpy(word1,"F");
			      cntr = 0 ;
			      clt = qq + 1;
		          qq = 0;
	   	       }

		       if (strcmp(word1,"T") == 0)
		       {
		 										 
			      chk_break(line_no);

				  fprint_repeat(fp,' ',22);		   
				  for(i=clt;i<= qq;i++)
		          {
		             if(d_result_text_2.arr[i] == '\n')
					 {
						w_flag = 'F';
					  }

					  fprintf(fp,"%c",d_result_text_2.arr[i]);
				
			      }

				  if (w_flag == 'T')
				  {
				  };

			       fprintf	(fp,"\n");

                   line_no++;

			       cntr = 0 ;
				   clt = qq + 1 ;
			       qq = 0;
				   strcpy(word1,"F");

				
		        }


		        if (strcmp(word1,"W") == 0)
		        {
		 										 
			       chk_break(line_no);

				   fprint_repeat(fp,' ',22);
				   for(i=clt;i < clt + 53;i++)
		           {
		              if(d_result_text_2.arr[i] == '\n')
						{

								w_flag = 'F';
						}

						fprintf(fp,"%c",d_result_text_2.arr[i]);
				
			       }

				   if (w_flag = 'T')
				   {
				   };

			       fprintf(fp,"\n");

                   line_no++;

				   cntr = 0 ;
				   clt = clt + 53;
				   z = clt ;
			       qq = 0;
				   strcpy(word1,"F");

				
		        }

			w_flag = 'T';	  
	        cntr += 1;
	        z++ ;
          }
		
      }
  
       fflush(fp);

#ifdef DEBUG
   printf("rl_res_result_text = %s\n", d_result_text_2.arr);
#endif

if (OERROR)
      disp_message(ERR_MESG, "SPLITTING failed on table RL_RESULT_TEXT");

}

print_clinical_history()
{

	int ctr = 0;
	int len = 0;
	int r_ctr = 0;

	char l_string[100];     
	
	// sprintf(string_var, "Patient ID %s  Spec No  %s ", d_patient_id.arr, d_specimen_no.arr);
	// disp_message(ERR_MESG, string_var);

		/* EXEC SQL DECLARE rl_clinical_cur CURSOR FOR
				 SELECT specimen_no, clinical_text_code, SUBSTR(clinical_text, 1, 4000) 
				 FROM RL_PATIENT_CLINICAL_TEXT
				 WHERE specimen_no = :d_specimen_no
				   AND patient_id  = :d_patient_id
			       AND OPERATING_FACILITY_ID = :nd_operating_facility_id
			       AND NVL(order_questionnaire_yn, 'N') <> 'Y'
				 ORDER BY specimen_no; */ 



		/* EXEC SQL OPEN rl_clinical_cur; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 48;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = sq0040;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1842;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_specimen_no;
  sqlstm.sqhstl[0] = (unsigned int  )23;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_patient_id;
  sqlstm.sqhstl[1] = (unsigned int  )33;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[2] = (unsigned int  )5;
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



		ctr = 0;

		split_hist();

		/* EXEC SQL CLOSE rl_clinical_cur; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 48;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1869;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}


/********** Splitting Clinical History  **********/
split_hist()
{
  
	char word[2];
	char w_flag ;

    strcpy(word1,"F");

	w_flag = 'T';

    while(fetch_clinical_text())
    {
          
      something_to_print = 1;
	  
	  l_var = strlen(d_clinical_text.arr);

         z = 0;
	     clt = 0;
	     strcpy(word1,"F"); 
	     cntr = 1;
	     qq = 0;

         while(z<l_var)
         {
		 		  	
		 
             word[0] = d_clinical_text.arr[z];
 		     word[1] = '\0';

		     if (strcmp(word,"\n") == 0)
		     {
   
		       cntr = 0;
		       strcpy(word1,"N");
		       qq = z ;
		      }


  		      if(cntr >= 38) //71
		      {
		   	
			     cmp = cntr;
			     while((d_clinical_text.arr[z] != 32) && (cmp > 1))
			     {

			         z--;
				     cmp--;
				  
			      }

				  qq = z;
				  			   
			      word[0] = d_clinical_text.arr[z];
   			      word[1] = '\0';
		
		  	      if (cmp == 1)
				     strcpy(word1,"W");
			      else
			         strcpy(word1,"T");
			   
		
		       }


				if (((z == l_var) || (z == l_var - 1)) && (strcmp(word1,"F") == 0))
				{
	
				   chk_break(line_no);

				   fprint_repeat(fp,' ',38);		   
				   for(i=clt;i < z + 1;i++)
		           {
			       		
						if(d_clinical_text.arr[i] == '\n')
						{


							    w_flag = 'F';
 						 }

						fprintf(fp,"%c",d_clinical_text.arr[i]);
			
			       }

				   if (w_flag == 'T')
				   {
				   };

			       fprintf	(fp,"\n");

                   line_no++;
		           // chk_break(line_no);

				   cntr = 0 ;
				   clt = clt + 37 ; //70
				   z = clt ;
			       qq = 0;
				   strcpy(word1,"F");


				}

			
		       if (strcmp(word1,"N") == 0) 
		       {
				
		          chk_break(line_no);
				  
				  line_no++;

				  fprint_repeat(fp,' ',38);
				  for(i=clt;i<=qq;i++)
		          {
			         if(d_clinical_text.arr[i] == '\n')
					{
						  
								w_flag = 'F';

				    }

				    fprintf(fp,"%c",d_clinical_text.arr[i]);
					
			      }

				  if (w_flag == 'T')
				  {
				  };
					
			      strcpy(word1,"F");
			      cntr = 0 ;
			      clt = qq + 1;
		          qq = 0;
	   	       }

		       if (strcmp(word1,"T") == 0)
		       {
		 										 
			      chk_break(line_no);

				  fprint_repeat(fp,' ',38);		   
				  for(i=clt;i<= qq;i++)
		          {
		             if(d_clinical_text.arr[i] == '\n')
					 {
						w_flag = 'F';
					  }

					  fprintf(fp,"%c",d_clinical_text.arr[i]);
				
			      }

				  if (w_flag == 'T')
				  {
				  };

			       fprintf	(fp,"\n");

                   line_no++;
		           // chk_break(line_no);

			       cntr = 0 ;
				   clt = qq + 1 ;
			       qq = 0;
				   strcpy(word1,"F");

				
		        }


		        if (strcmp(word1,"W") == 0)
		        {
		 										 
			       chk_break(line_no);

				   fprint_repeat(fp,' ',38);
				   for(i=clt;i < clt + 37;i++)   //70
		           {
		              if(d_clinical_text.arr[i] == '\n')
						{

								w_flag = 'F';
						}

						fprintf(fp,"%c",d_clinical_text.arr[i]);
				
			       }

				   if (w_flag = 'T')
				   {
				   };

			       fprintf(fp,"\n");

                   line_no++;
		           // chk_break(line_no);

				   cntr = 0 ;
				   clt = clt + 37 ;  //70
				   z = clt ;
			       qq = 0;
				   strcpy(word1,"F");

				
		        }

			w_flag = 'T';	  
	        cntr += 1;
	        z++ ;
          }

		
      }
  
       fflush(fp);

#ifdef DEBUG
   printf("rl_res_result_text = %s\n", d_clinical_text.arr);
#endif

if (OERROR)
      disp_message(ERR_MESG, "SPLITTING failed on table RL_PATIENT_CLINICAL_TEXT");

}

/*******************************************************************************************/
fetch_result_text()
{

	d_result_text_code.arr[0]	= '\0';
	d_result_text_code.len		= 0;
	d_result_spec_no.arr[0]		= '\0';
	d_result_spec_no.len		= 0;

	d_result_text.arr[0]		= '\0';
	d_result_text.len			= 0;

    /* EXEC SQL FETCH result_text_cur
              INTO :d_result_spec_no,
				   :d_result_text_code, 
				   :d_result_text; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 48;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1884;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_result_spec_no;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_result_text_code;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_result_text;
    sqlstm.sqhstl[2] = (unsigned int  )4003;
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
         disp_message(ORA_MESG,"FETCH failed on cursor RL_RESULT_TEXT");


	d_result_spec_no.arr[d_result_spec_no.len]			= '\0';
	d_result_text_code.arr[d_result_text_code.len]		= '\0';
	d_result_text.arr[d_result_text.len]				= '\0';

    return (LAST_ROW?0:1);
}
/*******************************************************************************************/

fetch_result_text_2()
{

	d_result_text_code_2.arr[0]	    = '\0';
	d_result_text_code_2.len		= 0;
	d_result_spec_no_2.arr[0]		= '\0';
	d_result_spec_no_2.len		    = 0;

	d_result_text_2.arr[0]		    = '\0';
	d_result_text_2.len			    = 0;

    /* EXEC SQL FETCH result_text_cur2
              INTO :d_result_spec_no_2,
				   :d_result_text_code_2, 
				   :d_result_text_2; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 48;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1911;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_result_spec_no_2;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_result_text_code_2;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_result_text_2;
    sqlstm.sqhstl[2] = (unsigned int  )4003;
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
         disp_message(ORA_MESG,"FETCH failed on cursor RL_RESULT_TEXT");

	d_result_spec_no_2.arr[d_result_spec_no_2.len]			= '\0';
	d_result_text_code_2.arr[d_result_text_code_2.len]		= '\0';
	d_result_text_2.arr[d_result_text_2.len]				= '\0';

    return (LAST_ROW?0:1);
}


/*******************************************************************************************/
fetch_clinical_text()
{

	d_clinical_text_code.arr[0]		= '\0';
	d_clinical_text_code.len		= 0;
	d_clinical_spec_no.arr[0]		= '\0';
	d_clinical_spec_no.len			= 0;

	d_clinical_text.arr[0]			= '\0';
	d_clinical_text.len				= 0;

    /* EXEC SQL FETCH rl_clinical_cur
              INTO :d_clinical_spec_no,
				   :d_clinical_text_code, 
				   :d_clinical_text; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 48;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1938;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_clinical_spec_no;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_clinical_text_code;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_clinical_text;
    sqlstm.sqhstl[2] = (unsigned int  )4003;
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
         disp_message(ORA_MESG,"FETCH failed on cursor RL_PATIENT_CLINICAL_TEXT");


	d_clinical_spec_no.arr[d_clinical_spec_no.len]			= '\0';
	d_clinical_text_code.arr[d_clinical_text_code.len]		= '\0';
	d_clinical_text.arr[d_clinical_text.len]				= '\0';

    return (LAST_ROW?0:1);
}
/*******************************************************************************************/

void print_page_header()
{
   printt_page_header() ;
   line_no += 5;
}

void print_col_heading()
{
   //fprintf(fp,"Category Number       Interpretations\n");
   fprintf(fp,"%-15.15s       %-15.15s\n", local_legend[23], local_legend[24]); //added for globalisation
   fprintf(fp,"------------------------------------------------------------------------------\n");
   line_no += 2;
}

/*************SD-CRF-20059 from here *****************/
void get_referral_patient_dtl()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT SUBSTR(DECODE(:language_id, 'en', SHORT_NAME, 'th', SHORT_NAME_LOC_LANG),1,59),NATIONAL_ID_NUM
	           INTO :d_patient_name,:d_nationality_id
            FROM RL_PATIENT_MAST
	    WHERE PATIENT_ID = :d_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 48;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(DECODE(:b0,'en',SHORT_NAME,'th',SHORT_NAME_L\
OC_LANG),1,59) ,NATIONAL_ID_NUM into :b1,:b2  from RL_PATIENT_MAST where PATIE\
NT_ID=:b3";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1965;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&language_id;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_patient_name;
   sqlstm.sqhstl[1] = (unsigned int  )242;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_nationality_id;
   sqlstm.sqhstl[2] = (unsigned int  )22;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_patient_id;
   sqlstm.sqhstl[3] = (unsigned int  )33;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}


		/* AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */

  d_patient_name.arr[d_patient_name.len]     = '\0';
  d_nationality_id.arr[d_nationality_id.len] = '\0';
 
  #ifdef DEBUG
   printf("d_patient_name= %s\n", d_patient_name.arr);
  #endif

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 48;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1996;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_referral_patient_dtl() occured....\n");
   proc_exit();
}

/* Function to fetch the INPATIENT details */
int get_in_patient_dtl()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT SUBSTR(DECODE(:language_id, 'en', SHORT_NAME, 'th', SHORT_NAME_LOC_LANG),1,59),NATIONAL_ID_NUM INTO
	           :d_patient_name,:d_nationality_id
            FROM MP_PATIENT_MAST 
	    WHERE PATIENT_ID = :d_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 48;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(DECODE(:b0,'en',SHORT_NAME,'th',SHORT_NAME_L\
OC_LANG),1,59) ,NATIONAL_ID_NUM into :b1,:b2  from MP_PATIENT_MAST where PATIE\
NT_ID=:b3";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2011;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&language_id;
   sqlstm.sqhstl[0] = (unsigned int  )7;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_patient_name;
   sqlstm.sqhstl[1] = (unsigned int  )242;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_nationality_id;
   sqlstm.sqhstl[2] = (unsigned int  )22;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_patient_id;
   sqlstm.sqhstl[3] = (unsigned int  )33;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



  if (NODATAFOUND)
    return 0;
  d_patient_name.arr[d_patient_name.len]     = '\0';
  d_nationality_id.arr[d_nationality_id.len] = '\0';
  #ifdef DEBUG
   printf("d_patient_name= %s\n", d_patient_name.arr);
  #endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 48;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2042;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_in_patient_dtl() occured....\n");
   proc_exit();
}
/********* GET SOURCE_NAME  **********/
  void get_source_name()
  {
    d_source_name.arr[0]	= '\0';
	d_source_name.len		= 0;

 	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	if(strcmp(d_source_type.arr,"C") == 0)
	{
   				/* EXEC SQL SELECT LONG_DESC 
				INTO :d_source_name
				FROM OP_CLINIC_lang_vw 
				WHERE FACILITY_ID = :nd_operating_facility_id
				AND clinic_code = :d_source_code
				and language_id = :language_id; */ 

{
       struct sqlexd sqlstm;
       sqlstm.sqlvsn = 10;
       sqlstm.arrsiz = 48;
       sqlstm.sqladtp = &sqladt;
       sqlstm.sqltdsp = &sqltds;
       sqlstm.stmt = "select LONG_DESC into :b0  from OP_CLINIC_lang_vw wher\
e ((FACILITY_ID=:b1 and clinic_code=:b2) and language_id=:b3)";
       sqlstm.iters = (unsigned int  )1;
       sqlstm.offset = (unsigned int  )2057;
       sqlstm.selerr = (unsigned short)1;
       sqlstm.cud = sqlcud0;
       sqlstm.sqlest = (unsigned char  *)&sqlca;
       sqlstm.sqlety = (unsigned short)256;
       sqlstm.occurs = (unsigned int  )0;
       sqlstm.sqhstv[0] = (         void  *)&d_source_name;
       sqlstm.sqhstl[0] = (unsigned int  )102;
       sqlstm.sqhsts[0] = (         int  )0;
       sqlstm.sqindv[0] = (         void  *)0;
       sqlstm.sqinds[0] = (         int  )0;
       sqlstm.sqharm[0] = (unsigned int  )0;
       sqlstm.sqadto[0] = (unsigned short )0;
       sqlstm.sqtdso[0] = (unsigned short )0;
       sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
       sqlstm.sqhstl[1] = (unsigned int  )5;
       sqlstm.sqhsts[1] = (         int  )0;
       sqlstm.sqindv[1] = (         void  *)0;
       sqlstm.sqinds[1] = (         int  )0;
       sqlstm.sqharm[1] = (unsigned int  )0;
       sqlstm.sqadto[1] = (unsigned short )0;
       sqlstm.sqtdso[1] = (unsigned short )0;
       sqlstm.sqhstv[2] = (         void  *)&d_source_code;
       sqlstm.sqhstl[2] = (unsigned int  )9;
       sqlstm.sqhsts[2] = (         int  )0;
       sqlstm.sqindv[2] = (         void  *)0;
       sqlstm.sqinds[2] = (         int  )0;
       sqlstm.sqharm[2] = (unsigned int  )0;
       sqlstm.sqadto[2] = (unsigned short )0;
       sqlstm.sqtdso[2] = (unsigned short )0;
       sqlstm.sqhstv[3] = (         void  *)&language_id;
       sqlstm.sqhstl[3] = (unsigned int  )7;
       sqlstm.sqhsts[3] = (         int  )0;
       sqlstm.sqindv[3] = (         void  *)0;
       sqlstm.sqinds[3] = (         int  )0;
       sqlstm.sqharm[3] = (unsigned int  )0;
       sqlstm.sqadto[3] = (unsigned short )0;
       sqlstm.sqtdso[3] = (unsigned short )0;
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
       if (sqlca.sqlcode < 0) goto err_exit;
}


	}
	else
	{
		if(strcmp(d_source_type.arr,"W") == 0) 
		{
		
				/* EXEC SQL 
				/oSELECT LONG_DESC
				INTO :d_source_name
				FROM IP_WARD 
				WHERE FACILITY_ID = :nd_operating_facility_id
				AND ward_code = :d_source_code;
				o/
				SELECT LONG_DESC
				INTO :d_source_name
				FROM IP_NURSING_UNIT_LANG_VW 
				WHERE FACILITY_ID = :nd_operating_facility_id
				AND NURSING_UNIT_CODE = :d_source_code
				and language_id = :language_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 48;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select LONG_DESC into :b0  from IP_NURSING_UNIT_LANG_VW w\
here ((FACILITY_ID=:b1 and NURSING_UNIT_CODE=:b2) and language_id=:b3)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2088;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_source_name;
    sqlstm.sqhstl[0] = (unsigned int  )102;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[1] = (unsigned int  )5;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_source_code;
    sqlstm.sqhstl[2] = (unsigned int  )9;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&language_id;
    sqlstm.sqhstl[3] = (unsigned int  )7;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
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
    if (sqlca.sqlcode < 0) goto err_exit;
}


		}
		else
		{
			if((strcmp(d_source_type.arr,"R") == 0 ) || (strcmp(d_source_type.arr,"E") == 0 ) )
			{
					/* EXEC SQL SELECT LONG_DESC
					INTO :d_source_name
					FROM RL_REFERRAL_lang_vw 
					WHERE referral_code = :d_source_code
					and language_id = :language_id; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 48;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select LONG_DESC into :b0  from RL_REFERRAL_lang_vw wher\
e (referral_code=:b1 and language_id=:b2)";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )2119;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_source_name;
     sqlstm.sqhstl[0] = (unsigned int  )102;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_source_code;
     sqlstm.sqhstl[1] = (unsigned int  )9;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&language_id;
     sqlstm.sqhstl[2] = (unsigned int  )7;
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
     if (sqlca.sqlcode < 0) goto err_exit;
}


			}
		}
	}

#ifdef DEBUG
    printf("leaving dclr_source_cur()\n");
    fflush(stdout);
#endif

	d_source_name.arr[d_source_name.len]	= '\0';


  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 48;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2146;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_source_cur() occured....\n");
   proc_exit();	
  }


/********* GET SECTION_NAME  **********/

/*************SD-CRF-20059 upto here *****************/
/*********** PRINT REPORT HEADER **************/
void print_rep_header()
{
  char nd_fr_process_date_desc[100],
       nd_to_process_date_desc[100],
	   nd_fr_process_date_desc_2[100],
	   nd_to_process_date_desc_2[100];

int rec_len; //added for globalisation

          /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_regd_date_fr_1,'DD/MM/YYYY'), :language_id , t_date);
				//:nd_regd_date_fr_11 := to_char(t_date,'DD/MM/YYYY');
				:nd_regd_date_fr_11 :=sm_convert_date_2t(to_date(:nd_regd_date_fr_1,'DD/MM/YYYY '),:language_id);
				END;
			END-EXEC; */ 

{
          struct sqlexd sqlstm;
          sqlstm.sqlvsn = 10;
          sqlstm.arrsiz = 48;
          sqlstm.sqladtp = &sqladt;
          sqlstm.sqltdsp = &sqltds;
          sqlstm.stmt = "declare t_date date ; BEGIN :nd_regd_date_fr_11 := \
sm_convert_date_2t ( to_date ( :nd_regd_date_fr_1 , 'DD/MM/YYYY ' ) , :languag\
e_id ) ; END ;";
          sqlstm.iters = (unsigned int  )1;
          sqlstm.offset = (unsigned int  )2161;
          sqlstm.cud = sqlcud0;
          sqlstm.sqlest = (unsigned char  *)&sqlca;
          sqlstm.sqlety = (unsigned short)256;
          sqlstm.occurs = (unsigned int  )0;
          sqlstm.sqhstv[0] = (         void  *)&nd_regd_date_fr_11;
          sqlstm.sqhstl[0] = (unsigned int  )33;
          sqlstm.sqhsts[0] = (         int  )0;
          sqlstm.sqindv[0] = (         void  *)0;
          sqlstm.sqinds[0] = (         int  )0;
          sqlstm.sqharm[0] = (unsigned int  )0;
          sqlstm.sqadto[0] = (unsigned short )0;
          sqlstm.sqtdso[0] = (unsigned short )0;
          sqlstm.sqhstv[1] = (         void  *)&nd_regd_date_fr_1;
          sqlstm.sqhstl[1] = (unsigned int  )33;
          sqlstm.sqhsts[1] = (         int  )0;
          sqlstm.sqindv[1] = (         void  *)0;
          sqlstm.sqinds[1] = (         int  )0;
          sqlstm.sqharm[1] = (unsigned int  )0;
          sqlstm.sqadto[1] = (unsigned short )0;
          sqlstm.sqtdso[1] = (unsigned short )0;
          sqlstm.sqhstv[2] = (         void  *)&language_id;
          sqlstm.sqhstl[2] = (unsigned int  )7;
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


          /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_regd_date_to_1,'DD/MM/YYYY'), :language_id , t_date);
				//:nd_regd_date_to_11 := to_char(t_date,'DD/MM/YYYY');
				:nd_regd_date_to_11 :=sm_convert_date_2t(to_date(:nd_regd_date_to_1,'DD/MM/YYYY '),:language_id);
				END;
			END-EXEC; */ 

{
          struct sqlexd sqlstm;
          sqlstm.sqlvsn = 10;
          sqlstm.arrsiz = 48;
          sqlstm.sqladtp = &sqladt;
          sqlstm.sqltdsp = &sqltds;
          sqlstm.stmt = "declare t_date date ; BEGIN :nd_regd_date_to_11 := \
sm_convert_date_2t ( to_date ( :nd_regd_date_to_1 , 'DD/MM/YYYY ' ) , :languag\
e_id ) ; END ;";
          sqlstm.iters = (unsigned int  )1;
          sqlstm.offset = (unsigned int  )2188;
          sqlstm.cud = sqlcud0;
          sqlstm.sqlest = (unsigned char  *)&sqlca;
          sqlstm.sqlety = (unsigned short)256;
          sqlstm.occurs = (unsigned int  )0;
          sqlstm.sqhstv[0] = (         void  *)&nd_regd_date_to_11;
          sqlstm.sqhstl[0] = (unsigned int  )33;
          sqlstm.sqhsts[0] = (         int  )0;
          sqlstm.sqindv[0] = (         void  *)0;
          sqlstm.sqinds[0] = (         int  )0;
          sqlstm.sqharm[0] = (unsigned int  )0;
          sqlstm.sqadto[0] = (unsigned short )0;
          sqlstm.sqtdso[0] = (unsigned short )0;
          sqlstm.sqhstv[1] = (         void  *)&nd_regd_date_to_1;
          sqlstm.sqhstl[1] = (unsigned int  )33;
          sqlstm.sqhsts[1] = (         int  )0;
          sqlstm.sqindv[1] = (         void  *)0;
          sqlstm.sqinds[1] = (         int  )0;
          sqlstm.sqharm[1] = (unsigned int  )0;
          sqlstm.sqadto[1] = (unsigned short )0;
          sqlstm.sqtdso[1] = (unsigned short )0;
          sqlstm.sqhstv[2] = (         void  *)&language_id;
          sqlstm.sqhstl[2] = (unsigned int  )7;
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


          /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_regd_date_fr_2,'DD/MM/YYYY'), :language_id , t_date);
				//:nd_regd_date_fr_21 := to_char(t_date,'DD/MM/YYYY');
				:nd_regd_date_fr_21 :=sm_convert_date_2t(to_date(:nd_regd_date_fr_2,'DD/MM/YYYY '),:language_id);
				END;
			END-EXEC; */ 

{
          struct sqlexd sqlstm;
          sqlstm.sqlvsn = 10;
          sqlstm.arrsiz = 48;
          sqlstm.sqladtp = &sqladt;
          sqlstm.sqltdsp = &sqltds;
          sqlstm.stmt = "declare t_date date ; BEGIN :nd_regd_date_fr_21 := \
sm_convert_date_2t ( to_date ( :nd_regd_date_fr_2 , 'DD/MM/YYYY ' ) , :languag\
e_id ) ; END ;";
          sqlstm.iters = (unsigned int  )1;
          sqlstm.offset = (unsigned int  )2215;
          sqlstm.cud = sqlcud0;
          sqlstm.sqlest = (unsigned char  *)&sqlca;
          sqlstm.sqlety = (unsigned short)256;
          sqlstm.occurs = (unsigned int  )0;
          sqlstm.sqhstv[0] = (         void  *)&nd_regd_date_fr_21;
          sqlstm.sqhstl[0] = (unsigned int  )33;
          sqlstm.sqhsts[0] = (         int  )0;
          sqlstm.sqindv[0] = (         void  *)0;
          sqlstm.sqinds[0] = (         int  )0;
          sqlstm.sqharm[0] = (unsigned int  )0;
          sqlstm.sqadto[0] = (unsigned short )0;
          sqlstm.sqtdso[0] = (unsigned short )0;
          sqlstm.sqhstv[1] = (         void  *)&nd_regd_date_fr_2;
          sqlstm.sqhstl[1] = (unsigned int  )33;
          sqlstm.sqhsts[1] = (         int  )0;
          sqlstm.sqindv[1] = (         void  *)0;
          sqlstm.sqinds[1] = (         int  )0;
          sqlstm.sqharm[1] = (unsigned int  )0;
          sqlstm.sqadto[1] = (unsigned short )0;
          sqlstm.sqtdso[1] = (unsigned short )0;
          sqlstm.sqhstv[2] = (         void  *)&language_id;
          sqlstm.sqhstl[2] = (unsigned int  )7;
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


          /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				BEGIN
				//GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_regd_date_to_2,'DD/MM/YYYY'), :language_id , t_date);
				//:nd_regd_date_to_21 := to_char(t_date,'DD/MM/YYYY');
				:nd_regd_date_to_21 :=sm_convert_date_2t(to_date(:nd_regd_date_to_2,'DD/MM/YYYY '),:language_id);
				END;
			END-EXEC; */ 

{
          struct sqlexd sqlstm;
          sqlstm.sqlvsn = 10;
          sqlstm.arrsiz = 48;
          sqlstm.sqladtp = &sqladt;
          sqlstm.sqltdsp = &sqltds;
          sqlstm.stmt = "declare t_date date ; BEGIN :nd_regd_date_to_21 := \
sm_convert_date_2t ( to_date ( :nd_regd_date_to_2 , 'DD/MM/YYYY ' ) , :languag\
e_id ) ; END ;";
          sqlstm.iters = (unsigned int  )1;
          sqlstm.offset = (unsigned int  )2242;
          sqlstm.cud = sqlcud0;
          sqlstm.sqlest = (unsigned char  *)&sqlca;
          sqlstm.sqlety = (unsigned short)256;
          sqlstm.occurs = (unsigned int  )0;
          sqlstm.sqhstv[0] = (         void  *)&nd_regd_date_to_21;
          sqlstm.sqhstl[0] = (unsigned int  )33;
          sqlstm.sqhsts[0] = (         int  )0;
          sqlstm.sqindv[0] = (         void  *)0;
          sqlstm.sqinds[0] = (         int  )0;
          sqlstm.sqharm[0] = (unsigned int  )0;
          sqlstm.sqadto[0] = (unsigned short )0;
          sqlstm.sqtdso[0] = (unsigned short )0;
          sqlstm.sqhstv[1] = (         void  *)&nd_regd_date_to_2;
          sqlstm.sqhstl[1] = (unsigned int  )33;
          sqlstm.sqhsts[1] = (         int  )0;
          sqlstm.sqindv[1] = (         void  *)0;
          sqlstm.sqinds[1] = (         int  )0;
          sqlstm.sqharm[1] = (unsigned int  )0;
          sqlstm.sqadto[1] = (unsigned short )0;
          sqlstm.sqtdso[1] = (unsigned short )0;
          sqlstm.sqhstv[2] = (         void  *)&language_id;
          sqlstm.sqhstl[2] = (unsigned int  )7;
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




  if(strcmp(nd_regd_date_fr_1.arr, "01/01/1800") == 0)
    //strcpy(nd_fr_process_date_desc, "LOWEST");
    strcpy(nd_fr_process_date_desc, local_legend[11]); //added for globalisation
  else strcpy(nd_fr_process_date_desc, nd_regd_date_fr_11.arr);

  if(strcmp(nd_regd_date_to_1.arr, "31/12/4712") == 0)
    //strcpy(nd_to_process_date_desc, "HIGHEST");
    strcpy(nd_to_process_date_desc, local_legend[12]); //added for globalisation
  else strcpy(nd_to_process_date_desc, nd_regd_date_to_11.arr);

  if(strcmp(nd_regd_date_fr_2.arr, "01/01/1800") == 0)
    //strcpy(nd_fr_process_date_desc_2, "LOWEST");
    strcpy(nd_fr_process_date_desc_2, local_legend[11]); //added for globalisation
  else strcpy(nd_fr_process_date_desc_2, nd_regd_date_fr_21.arr);

  if(strcmp(nd_regd_date_to_2.arr, "31/12/4712") == 0)
    //strcpy(nd_to_process_date_desc_2, "HIGHEST");
    strcpy(nd_to_process_date_desc_2, local_legend[12]); //added for globalisation
  else strcpy(nd_to_process_date_desc_2, nd_regd_date_to_21.arr);
  
  #ifdef DEBUG
      printf("before report header()\n");
  #endif

  printt_page_header();

  #ifdef DEBUG
      printf("after page header()\n");
  #endif
  
  get_version_no();

  fprintf(fp,"%s\n",d_version.arr);
  fprintf(fp,"\n\n\n\n");
  //fprintf(fp,"        ");
  //fprintf(fp,"INPUT PARAMETERS :\n");
  rec_len = strlen(local_legend[13]);//added for globalisation
  print_space(25, rec_len,1);//added for globalisation
  fprintf(fp,"%s:\n", local_legend[13]);//added for globalisation
  //fprintf(fp,"        ");
  //fprintf(fp,"------------------\n\n");
  print_space(25, rec_len,1);//added for globalisation
  print_space(25, rec_len,0);//added for globalisation
  fprintf(fp,"\n\n");//added for globalisation
  //fprintf(fp,"        ");
  //fprintf(fp, "FOR %s\n", first_section_title);
  fprintf(fp, "%11.11s %s\n", local_legend[14],first_section_title); //added for globalisation
  fprintf(fp,"      ");
  fprint_repeat(fp,'-',strlen(first_section_title) + 8);
  fprintf(fp,"\n");

  //fprintf(fp,"                   ");
  //fprintf(fp,"SPEC REGD DATE   FROM : %s\n", nd_fr_process_date_desc);
  fprintf(fp,"%22.22s %8.8s  : %s\n",local_legend[15], local_legend[16], nd_fr_process_date_desc);
  //fprintf(fp,"                   ");
  //fprintf(fp,"                 TO  : %s\n", nd_to_process_date_desc);
  fprintf(fp,"%31.31s  : %s\n", local_legend[17], nd_to_process_date_desc); //added for globalisation
  //fprintf(fp,"                   ");
  //fprintf(fp,"SPECIMEN TYPE    FROM : %s\n", nd_spec_type_fr_1.arr);
  fprintf(fp,"%22.22s %8.8s  : %s\n", local_legend[18], local_legend[16],nd_spec_type_fr_1.arr); //added for globalisation
  //fprintf(fp,"                   ");
  //fprintf(fp,"                 TO  : %s\n", nd_spec_type_to_1.arr);
  fprintf(fp,"%31.31s  : %s\n", local_legend[17], nd_spec_type_to_1.arr); //added for globalisation
  //fprintf(fp,"                   ");
  //fprintf(fp,"ANATOMY SITE     FROM : %s\n", nd_anatomy_site_fr_1.arr);
  fprintf(fp,"%22.22s %8.8s  : %s\n", local_legend[19], local_legend[16],nd_anatomy_site_fr_1.arr);//added for globalisation
  //fprintf(fp,"                   ");
  //fprintf(fp,"                 TO  : %s\n", nd_anatomy_site_to_1.arr);
  fprintf(fp,"%31.31s  : %s\n", local_legend[17],nd_anatomy_site_to_1.arr);//added for globalisation
  //fprintf(fp,"                   ");
  //fprintf(fp,"CATEGORY PREFIX        : %s",   nd_category_prfx_1.arr);
  fprintf(fp,"%31.31s  : %s", local_legend[20], nd_category_prfx_1.arr);//added for globalisation
  fprintf(fp,"\n");
  
  //fprintf(fp,"      ");
  //fprintf(fp, "FOR %s\n", second_section_title);
  fprintf(fp, "%11.11s %s\n", local_legend[14], second_section_title);//added for globalisation
  fprintf(fp,"        ");
  fprint_repeat(fp,'-',strlen(second_section_title) + 8);
  fprintf(fp,"\n");
  //fprintf(fp,"                   ");
  //fprintf(fp,"SPEC REGD DATE   FROM : %s\n", nd_fr_process_date_desc_2);
  fprintf(fp,"%22.22s %8.8s  : %s\n",local_legend[15], local_legend[16], nd_fr_process_date_desc_2);//added for globalisation
  //fprintf(fp,"                   ");
  //fprintf(fp,"                 TO    : %s\n", nd_to_process_date_desc_2);
  fprintf(fp,"%31.31s  : %s\n", local_legend[17], nd_to_process_date_desc_2); //added for globalisation
  //fprintf(fp,"                   ");
  //fprintf(fp,"SPECIMEN TYPE    FROM : %s\n", nd_spec_type_fr_2.arr);
  fprintf(fp,"%22.22s %8.8s  : %s\n", local_legend[18], local_legend[16],nd_spec_type_fr_2.arr); //added for globalisation
  //fprintf(fp,"                   ");
  //fprintf(fp,"                 TO    : %s\n", nd_spec_type_to_2.arr);
  fprintf(fp,"%31.31s  : %s\n", local_legend[17], nd_spec_type_to_2.arr); //added for globalisation
  //fprintf(fp,"                   ");
  //fprintf(fp,"ANATOMY SITE     FROM : %s\n", nd_anatomy_site_fr_2.arr);
  fprintf(fp,"%22.22s %8.8s  : %s\n", local_legend[19], local_legend[16],nd_anatomy_site_fr_2.arr);//added for globalisation
  //fprintf(fp,"                   ");
  //fprintf(fp,"                 TO    : %s\n", nd_anatomy_site_to_2.arr);
  fprintf(fp,"%31.31s  : %s\n", local_legend[17],nd_anatomy_site_to_2.arr);//added for globalisation
  //fprintf(fp,"                   ");
  //fprintf(fp,"CATEGORY PREFIX        : %s",   nd_category_prfx_2.arr);
  fprintf(fp,"%31.31s  : %s", local_legend[20], nd_category_prfx_2.arr);//added for globalisation
  fprintf(fp,"\n");

  fprintf(fp,"\f");
}

/********************* FORM HDR ************************/

void printt_page_header()
{

    static int first = 1;
    char buf[15];
    int col;

        strcpy(rep_title2,"");
        

    if(first) 
	{
        memset(hdr_line1,' ',REP_WIDTH+1);
        memset(hdr_line2,' ',REP_WIDTH+1);
        memset(hdr_line4,' ',REP_WIDTH+1);
		memset(hdr_line5,'-',REP_WIDTH);
		hdr_line5[REP_WIDTH] = '\0';
	
        strncpy(hdr_line1,"MDL : RL",8);
        col = (int)(REP_WIDTH-strlen(d_acc_entity_name.arr))/2;
        strncpy(hdr_line1+col,d_acc_entity_name.arr,strlen(d_acc_entity_name.arr));

  /* EXEC SQL EXECUTE
	DECLARE
		t_date   date;
	BEGIN
		//t_date := GET_LOCALE_DATE.GET_CURRENT_DATE(:language_id);
		//:d_sysdate1 := to_char(t_date,'DD/MM/YYYY HH24:MI'); //Added HH24:MI by srinivas 
		:d_sysdate1 :=sm_convert_datetime_2t(SYSDATE,:language_id);
	END;
  END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 48;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN :d_sysdate1 := sm_convert_datet\
ime_2t ( SYSDATE , :language_id ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2269;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_sysdate1;
  sqlstm.sqhstl[0] = (unsigned int  )19;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&language_id;
  sqlstm.sqhstl[1] = (unsigned int  )7;
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



        col = (REP_WIDTH-strlen(d_sysdate1.arr));
        strcpy(hdr_line1+col,d_sysdate1.arr);
    
        strncpy(hdr_line2,"OPR :",5);
        strcpy(hdr_line2+6,d_user.arr);

    }

    memset(hdr_line3,' ',REP_WIDTH+1);

    strncpy(hdr_line3,"REP : RLRHCRLN",14);

    strcpy(rep_title1,local_legend[1]);

    col = (int)(REP_WIDTH-strlen(rep_title1))/2;
    strncpy(hdr_line3+col,rep_title1,strlen(rep_title1));
    sprintf(buf,"%s : %4d",local_legend[21],page_no++);
    strcpy(hdr_line3+(REP_WIDTH-strlen(buf)),buf);

    col = (int)(REP_WIDTH-strlen(rep_title2))/2;
    strcpy(hdr_line4+col,rep_title2);

    if(first)
        fprintf(fp,"%s\n",hdr_line1);
    else
	 {   fprintf(fp,"\n");
	    fprintf(fp,"%s\n",hdr_line1);
	 }

    fprintf(fp,"%s\n",hdr_line2);
    fprintf(fp,"%s\n",hdr_line3);
    fprintf(fp,"%s\n",hdr_line4);
    fprintf(fp,"%s\n",hdr_line5);

    first = 0;
}

chk_break(nol)
{

	if((line_no + 1) >= MAX_LINES)
	{
	   prepare_new_page();
	   /**
       line_no = 1;
	   fprintf(f1, "\f");
	   form_hdr();
	   do_form_title();
	   **/
 	}
}


fprint_repeat(l_fp,l_prn_chr,l_no)
FILE *l_fp;
char l_prn_chr;
int  l_no;
{
   int l_i = 0;

   for (l_i = 0;l_i < l_no;l_i++)
        fputc(l_prn_chr,l_fp);
}


get_version_no()
{
     d_version_no.arr[0] = '\0';
     d_version_no.len    =  0;

     strcpy(d_version.arr,"VER : ");

	 /* EXEC SQL EXECUTE 
	      begin
			if SM_INSTALLATION_TAB_CHECK THEN
			   :l_tab_exists := 1;
			else
			   :l_tab_exists := 0;
			end if;
		  end;
	 END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 48;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "begin if SM_INSTALLATION_TAB_CHECK THEN :l_tab_exists := 1 \
; else :l_tab_exists := 0 ; end if ; end ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2292;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&l_tab_exists;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
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



    if (l_tab_exists) 
    {
	    /* EXEC SQL SELECT VERSION_NO INTO :d_version_no 
                 FROM   SM_INSTALLATION; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 48;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select VERSION_NO into :b0  from SM_INSTALLATION ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )2311;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_version_no;
     sqlstm.sqhstl[0] = (unsigned int  )22;
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



        d_version_no.arr[d_version_no.len] = '\0';
    }
    else
	    strcpy(d_version_no.arr,"2.1");

	    strcat(d_version.arr,d_version_no.arr);


    if (OERROR)
	{
	    strcpy(d_version_no.arr,"2.1");
	    strcat(d_version.arr,d_version_no.arr);
    }

}

/****************************** added for globalisation *****************************/
get_legend_value(int cou)
 {
	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_operating_facility_id,:language_id,'RLRHCRLN.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 48;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_operati\
ng_facility_id , :language_id , 'RLRHCRLN.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2330;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[0] = (unsigned int  )5;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&language_id;
 sqlstm.sqhstl[1] = (unsigned int  )7;
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



	for (i=1; i<=cou; i++)
	{
	l_translated_value.arr[0]		= '\0';
	
	/* EXEC SQL EXECUTE
	BEGIN
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLRHCRLN.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 48;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
LRHCRLN.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2353;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_translated_value;
 sqlstm.sqhstl[0] = (unsigned int  )502;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&i;
 sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
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


	
	l_translated_value.arr[l_translated_value.len] = '\0';

	//sp_message(ERR_MESG,l_translated_value.arr);

	strcpy(local_legend[i],l_translated_value.arr);
	}
 }

print_space(int aa, int bb, int cc)
{
	if (cc ==1)
	{
  		for(i=1;i <= (aa - bb) ;i++)
		{
			fprintf(fp,"%s"," ");
		}	
	}
	else if (cc ==0)
	{
  		for(i= (aa - bb);i <= aa ;i++)
		{
			fprintf(fp,"%s","-");
		}	
	}
}

/*************************** added for globalisation*************************************/


#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER

#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER