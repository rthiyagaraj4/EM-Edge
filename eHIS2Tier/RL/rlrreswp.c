
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
           char  filnam[45];
};
static const struct sqlcxp sqlfpn =
{
    44,
    "d:\\durai\\proc\\facility_corr_proc\\rlrreswp.pc"
};


static unsigned long sqlctx = 1033703381;


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
            void  *sqhstv[74];
   unsigned int   sqhstl[74];
            int   sqhsts[74];
            void  *sqindv[74];
            int   sqinds[74];
   unsigned int   sqharm[74];
   unsigned int   *sqharc[74];
   unsigned short  sqadto[74];
   unsigned short  sqtdso[74];
} sqlstm = {10,74};

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

 static const char *sq0018 = 
"select TEST_CODE  from RL_REQUEST_DETAIL where ((PATIENT_ID=:b0 and SPECIMEN\
_NO=:b1) and OPERATING_FACILITY_ID=:b2) order by TEST_CODE            ";

 static const char *sq0027 = 
"select TEST_CODE  from RL_TEST_QUALITY_MAST where ((OPERATING_FACILITY_ID=:b\
0 and SECTION_CODE=:b1) and qlty_code=:b2)           ";

 static const char *sq0023 = 
"select TEST_CODE ,SEQ_NO ,TEST_INDICATOR  from RL_WORKLIST_FMT_DTL where ((O\
PERATING_FACILITY_ID=:b0 and SECTION_CODE=:b1) and WORKLIST_NAME=:b2) order by\
 SEQ_NO            ";

 static const char *sq0025 = 
"select TO_CHAR(WORKLIST_CUP_NO) ,TO_CHAR(SPECIMEN_NO) ,PATIENT_ID ,WORKLIST_\
CUP_INDICATOR ,TEST_1_YN ,TEST_2_YN ,TEST_3_YN ,TEST_4_YN ,TEST_5_YN ,TEST_6_Y\
N ,TEST_7_YN ,TEST_8_YN ,TEST_9_YN ,TEST_10_YN ,TEST_11_YN ,TEST_12_YN ,TEST_1\
3_YN ,TEST_14_YN ,TEST_15_YN ,TEST_16_YN ,TEST_17_YN ,TEST_18_YN ,TEST_19_YN ,\
TEST_20_YN ,TEST_21_YN ,TEST_22_YN ,TEST_23_YN ,TEST_24_YN ,TEST_25_YN ,QLTY_C\
ODE  from RL_WORKLIST_DTL where ((((OPERATING_FACILITY_ID=:b0 and SECTION_CODE\
=:b1) and WORKLIST_NAME=:b2) and WORKLIST_NO=:b3) and WORKLIST_DATE=TRUNC(TO_D\
ATE(:b4,'DD/MM/YYYY'))) order by WORKLIST_CUP_NO            ";

 static const char *sq0082 = 
"select test_code  from RL_REQUEST_DETAIL where ((patient_id=:b0 and specimen\
_no=TO_NUMBER(:b1)) and operating_facility_id=:b2) order by line_no           \
 ";

 static const char *sq0083 = 
"select A.test_code ,A.numeric_result ,A.numeric_prefix ,A.result_comment_cod\
e1 ,A.result_comment_code2 ,A.result_comment_code3 ,A.result_comment_code4 ,A.\
status ,A.result_comment_desc1 ,A.result_comment_desc2 ,A.result_comment_desc3\
 ,A.result_comment_desc4  from RL_TEST_RESULT A ,RL_WORKLIST_FMT_DTL B where (\
(((((A.patient_id=:b0 and A.specimen_no=TO_NUMBER(:b1)) and A.OPERATING_FACILI\
TY_ID=:b2) and B.section_code=:b3) and B.worklist_name=:b4) and B.OPERATING_FA\
CILITY_ID=:b2) and A.test_code=B.test_code) order by B.seq_no            ";

 static const char *sq0084 = 
"select TO_CHAR(A.specimen_no) ,A.test_code ,A.numeric_result ,A.numeric_pref\
ix ,A.result_comment_code1 ,A.result_comment_code2 ,A.result_comment_code3 ,A.\
result_comment_code4 ,A.status ,A.result_comment_desc1 ,A.result_comment_desc2\
 ,A.result_comment_desc3 ,A.result_comment_desc4 ,TO_CHAR(D.spec_regd_date_tim\
e,'DD/MM/YYYY HH24:MI:SS')  from RL_TEST_RESULT A ,RL_WORKLIST_FMT_DTL B ,RL_W\
ORKLIST_DTL C ,RL_REQUEST_HEADER D where ((((((((((((A.patient_id=:b0 and A.pa\
tient_id=D.patient_id) and A.specimen_no=c.specimen_no) and A.specimen_no=D.sp\
ecimen_no) and A.specimen_no<>TO_NUMBER(:b1)) and A.OPERATING_FACILITY_ID=:b2)\
 and B.section_code=:b3) and B.worklist_name=:b4) and B.OPERATING_FACILITY_ID=\
:b2) and A.test_code=B.test_code) and A.test_code=:b6) and NVL(A.reviewed_date\
,TO_DATE(:b7,'DD/MM/YYYY HH24:MI'))>=TO_DATE(:b8,'DD/MM/YYYY HH24:MI')) and D.\
spec_regd_date_time<TO_DATE(:b7,'DD/MM/YYYY HH24:MI')) order by A.reviewed_dat\
e desc             ";

typedef struct { unsigned short len; unsigned char arr[1]; } VARCHAR;
typedef struct { unsigned short len; unsigned char arr[1]; } varchar;

/* cud (compilation unit data) array */
static const short sqlcud0[] =
{10,4274,0,0,0,
5,0,0,1,0,0,539,420,0,0,4,4,0,1,0,1,9,0,0,1,10,0,0,1,10,0,0,1,10,0,0,
36,0,0,2,0,0,542,471,0,0,0,0,0,1,0,
51,0,0,3,0,0,544,478,0,0,0,0,0,1,0,
66,0,0,4,230,0,516,490,0,0,7,5,0,1,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,
3,0,0,1,9,0,0,
109,0,0,5,0,0,544,504,0,0,0,0,0,1,0,
124,0,0,6,0,0,544,529,0,0,0,0,0,1,0,
139,0,0,7,120,0,518,540,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
162,0,0,8,136,0,518,555,0,0,2,2,0,1,0,2,9,0,0,1,3,0,0,
185,0,0,9,319,0,516,609,0,0,17,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,
2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,1,9,0,0,1,9,0,0,
268,0,0,10,91,0,514,682,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
291,0,0,11,0,0,544,690,0,0,0,0,0,1,0,
306,0,0,12,113,0,516,700,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
333,0,0,13,0,0,544,715,0,0,0,0,0,1,0,
348,0,0,14,171,0,516,724,0,0,5,2,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
383,0,0,15,0,0,544,752,0,0,0,0,0,1,0,
398,0,0,16,1889,0,516,802,0,0,74,3,0,1,0,2,3,0,0,2,3,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,
0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,
9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,
2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,
0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,
0,0,2,9,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,
3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,2,3,0,0,2,3,0,0,2,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,
709,0,0,17,0,0,544,965,0,0,0,0,0,1,0,
724,0,0,19,0,0,544,987,0,0,0,0,0,1,0,
739,0,0,18,146,0,521,995,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
766,0,0,20,0,0,544,999,0,0,0,0,0,1,0,
781,0,0,18,0,0,525,1010,0,0,1,0,0,1,0,2,9,0,0,
800,0,0,21,0,0,544,1028,0,0,0,0,0,1,0,
815,0,0,18,0,0,527,1036,0,0,0,0,0,1,0,
830,0,0,22,0,0,544,1040,0,0,0,0,0,1,0,
845,0,0,24,0,0,544,1073,0,0,0,0,0,1,0,
860,0,0,26,0,0,544,1139,0,0,0,0,0,1,0,
875,0,0,28,0,0,544,1163,0,0,0,0,0,1,0,
890,0,0,29,0,0,529,1263,0,0,1,1,0,1,0,1,97,0,0,
909,0,0,29,0,0,557,1270,0,0,7,7,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1,9,0,0,1,9,0,0,
952,0,0,29,0,0,557,1281,0,0,11,11,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1011,0,0,29,0,0,557,1298,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1066,0,0,30,0,0,544,1322,0,0,0,0,0,1,0,
1081,0,0,31,306,0,516,1360,0,0,7,6,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,
1124,0,0,32,0,0,544,1379,0,0,0,0,0,1,0,
1139,0,0,27,129,0,521,1509,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
1166,0,0,33,0,0,544,1513,0,0,0,0,0,1,0,
1181,0,0,23,173,0,521,1523,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
1208,0,0,34,137,0,516,1524,0,0,4,3,0,1,0,2,3,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1239,0,0,35,0,0,544,1534,0,0,0,0,0,1,0,
1254,0,0,29,0,0,557,1544,0,0,0,0,0,1,0,
1269,0,0,36,0,0,544,1549,0,0,0,0,0,1,0,
1284,0,0,25,604,0,521,1558,0,0,5,5,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,
0,
1319,0,0,37,0,0,544,1563,0,0,0,0,0,1,0,
1334,0,0,27,0,0,527,1572,0,0,0,0,0,1,0,
1349,0,0,38,0,0,544,1576,0,0,0,0,0,1,0,
1364,0,0,23,0,0,525,1603,0,0,3,0,0,1,0,2,9,0,0,2,3,0,0,2,9,0,0,
1391,0,0,39,0,0,544,1631,0,0,0,0,0,1,0,
1406,0,0,27,0,0,525,1644,0,0,1,0,0,1,0,2,9,0,0,
1425,0,0,40,0,0,544,1657,0,0,0,0,0,1,0,
1440,0,0,25,0,0,525,1713,0,0,30,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,1,0,
0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,
0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,
1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,1,0,0,2,9,0,0,
1575,0,0,41,0,0,544,1806,0,0,0,0,0,1,0,
1590,0,0,42,926,0,515,1886,0,0,34,34,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,
0,0,1,3,0,0,1,1,0,0,1,9,0,0,1,9,0,0,1,97,0,0,1,97,0,0,1,97,0,0,1,97,0,0,1,97,0,
0,1,97,0,0,1,97,0,0,1,97,0,0,1,97,0,0,1,97,0,0,1,97,0,0,1,97,0,0,1,97,0,0,1,97,
0,0,1,97,0,0,1,97,0,0,1,97,0,0,1,97,0,0,1,97,0,0,1,97,0,0,1,97,0,0,1,97,0,0,1,
97,0,0,1,97,0,0,1,97,0,0,
1741,0,0,43,0,0,544,1962,0,0,0,0,0,1,0,
1756,0,0,44,399,0,515,1972,0,0,8,8,0,1,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,1,9,0,0,
1803,0,0,45,0,0,544,2006,0,0,0,0,0,1,0,
1818,0,0,46,165,0,516,2015,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1849,0,0,47,79,0,517,2022,0,0,2,2,0,1,0,1,9,0,0,1,9,0,0,
1872,0,0,48,165,0,516,2033,0,0,4,3,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
1903,0,0,49,142,0,517,2041,0,0,3,3,0,1,0,1,3,0,0,1,9,0,0,1,9,0,0,
1930,0,0,50,0,0,544,2052,0,0,0,0,0,1,0,
1945,0,0,51,0,0,544,2160,0,0,0,0,0,1,0,
1960,0,0,52,612,0,516,2388,0,0,18,3,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,
9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2047,0,0,53,0,0,544,2482,0,0,0,0,0,1,0,
2062,0,0,54,115,0,516,2494,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
2089,0,0,55,0,0,544,2508,0,0,0,0,0,1,0,
2104,0,0,56,115,0,516,2520,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
2131,0,0,57,0,0,544,2533,0,0,0,0,0,1,0,
2146,0,0,58,115,0,516,2545,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
2173,0,0,59,0,0,544,2558,0,0,0,0,0,1,0,
2188,0,0,60,0,0,544,2626,0,0,0,0,0,1,0,
2203,0,0,61,236,0,516,2635,0,0,8,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,1,9,0,0,
2250,0,0,62,0,0,544,2668,0,0,0,0,0,1,0,
2265,0,0,63,222,0,516,2677,0,0,7,2,0,1,0,1,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,1,9,0,0,
2308,0,0,64,0,0,544,2708,0,0,0,0,0,1,0,
2323,0,0,29,0,0,525,2776,0,0,6,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
2,9,0,0,
2362,0,0,65,0,0,544,2837,0,0,0,0,0,1,0,
2377,0,0,66,0,0,541,2869,0,0,0,0,0,1,0,
2392,0,0,67,93,0,516,2879,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
2419,0,0,68,0,0,544,2891,0,0,0,0,0,1,0,
2434,0,0,69,100,0,516,2905,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
2461,0,0,70,0,0,544,2922,0,0,0,0,0,1,0,
2476,0,0,71,225,0,516,3441,0,0,7,4,0,1,0,2,3,0,0,2,3,0,0,2,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,1,9,0,0,
2519,0,0,72,116,0,516,3453,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,9,0,0,
2546,0,0,73,115,0,516,3460,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,9,0,0,
2573,0,0,74,102,0,516,3467,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,9,0,0,
2600,0,0,75,102,0,516,3473,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,9,0,0,
2627,0,0,76,107,0,516,3479,0,0,3,2,0,1,0,1,9,0,0,1,3,0,0,2,9,0,0,
2654,0,0,77,100,0,516,3697,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,4,0,0,
2681,0,0,78,99,0,516,3727,0,0,3,2,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
2708,0,0,79,158,0,518,3786,0,0,2,2,0,1,0,1,9,0,0,2,9,0,0,
2731,0,0,80,207,0,518,3831,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
2758,0,0,81,199,0,518,3853,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,2,9,0,0,
2785,0,0,82,155,0,521,3938,0,0,3,3,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,
2812,0,0,82,0,0,525,3946,0,0,1,0,0,1,0,2,9,0,0,
2831,0,0,82,0,0,527,3995,0,0,0,0,0,1,0,
2846,0,0,83,539,0,521,4020,0,0,6,6,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,
0,1,9,0,0,
2885,0,0,84,953,0,521,4054,0,0,10,10,0,1,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,9,0,0,
2940,0,0,83,0,0,525,4092,0,0,12,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
3003,0,0,84,0,0,525,4201,0,0,14,0,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,
0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,
3074,0,0,83,0,0,527,4261,0,0,0,0,0,1,0,
3089,0,0,85,94,0,516,4270,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
3116,0,0,86,94,0,516,4288,0,0,3,2,0,1,0,2,9,0,0,1,9,0,0,1,9,0,0,
3143,0,0,87,336,0,516,4315,0,0,10,5,0,1,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,0,0,2,9,
0,0,1,9,0,0,1,9,0,0,1,9,0,0,1,3,0,0,1,9,0,0,
};


/***************************************************************************** 
  
*  File	         : rlrreswp.pc
   Author        : Sheelvant
   Date Created  : 03/02/1997
   Last Modified : 16/08/1997    ( Sheelvant )   

*  Ver 1.10.01
   
   Modified by   : HAMEED  

*  Purpose : To Create Worklist Date for the given Specimen Range     
            
*  Input Parameters : 
                      Command line inputs
		              1. Usr_id/Password
                      2. Session id
		              3. Program Date

                      Parameters from SY_PROG_PARAM table 
                      4. Preferred range of Specimen Numbers            
                      5. Criteria Flag                                  
                      6. Section Code                                   
                      7. Worklist_name                                  
                      8. Worklist Number                                
                      9. Worklist Date                                  
                      9. User Id                                        
  
*  Table Accessed : RL_WORKLIST_FMT_HDR,RL_WORKLIST_FMT_DTL,RL_TEST_RESULT,
		            RL_WORKLIST_DTL

*****************************************************************************/  

#include <stdio.h>
#include <string.h>
#include <math.h>

#define MAX_LINES 58
#define OERROR (sqlca.sqlcode < 0)
#define NODATAFOUND sqlca.sqlcode==1403
#define LAST_ROW 	(sqlca.sqlcode == 1403)
#define VER  "VER : 1.10.01\n"
#define REP_WIDTH 80
/*#define ONLINE_PRINTING 0*/

#define ESC 0x1B

/*
#define DEBUG   
*/

/* EXEC SQL BEGIN DECLARE SECTION; */ 


       /* increased the length all varchar variables by one to take care */
       /* for null termination */
	/* VARCHAR nd_operating_facility_id   [3],
	        uid_pwd		               [91],
		    nd_file_name               [150], 
 
    /o From RL_WORKLIST_QLTY_CUP_SEQ o/
		d_qlty_code             [5],

	/o from RL_WORKLIST_FMT_HDR o/
		d_worklist_name         [11],
        d_criteria_flag   	    [2],
		d_cup_indicators_1      [51],
		d_cup_indicators_2      [51],
		d_cup_indicators_3      [51],
		d_cup_indicators_4      [51],
		d_cup_indicators_5      [51],
		d_added_by_id           [51],
		rowid_wrk               [31],
		
        /o from RL_WORKLIST_FMT_DTL o/
		d_worklist_test_code	[11],
		d_test_indicator	[2],

        /o from RL_TEST_RESULT o/     
		d_specimen_no           [21],
		nd_specimen_no			[21],
		d_prt_cup_no			[30],
		d_patient_id            [31],
		d_req_test_code		[11],
		d_num_result		[16],
		d_comm_result		[16],
		d_test_result		[16],
		
		/o** To print the Previous Result **o/
		d_test_prv_result		[16],
                
		/o from RL_REQUEST_DETAILo/
		d_req_dtl_test		[11],

        /o from RL_QC_MATERIAL_TEST o/
		d_qc_test_code		[11],

        /o from PATIENT MASTERS     o/
		d_date_of_birth		[11],
		d_short_name   		[240],
        d_nation                [5],
        d_sex                   [2],
		d_pat_mark              [2],
		d_worklist_marker       [11],

        /o from RL_REQUEST_HEADER   o/
		d_source_code 		    [7],
		d_episode_type          [2],
		d_spec_regd_date_time   [17],
		d_l_spec_regd_date_time [17], /oAdded by Durai Rajkumar for Age Calculation on 05-Feb-08 o/
		d_consultant_code		[16],
		d_urgent_indicator      [2],
		d_request_comment_code1 [5],
		d_request_comment_code2 [5],
		d_request_comment_code3 [5],

		/o   from RL_REQUEST_COMMENT_CODE   o/
		d_request_comment_desc1 [42],  
		d_request_comment_desc2 [42],  
		d_request_comment_desc3 [42],  

        /o from RL_WORKLIST_DTL for printing only     o/
		d_prt_specimen_no	[21],
		d_prt_patient_id	[31],
		d_print_cup_indicator   [2],

        /o from RL_TEST_QUALITY_MAST o/
		d_qlty_test             [11],

        /o Dummy Variable o/     
	    nd_chk_test_code	[11],
		nd_ins_specimen_no      [21], 
		nd_ins_patient_id       [31], 


		/o  For Patient Age SYSDATE, MTHS o/
			today				[30],
			t_days				[30],
			mths				[30],
			mths1				[30],
			t_age				[30],

		
		/o input parameters to main() o/
        nd_session_id           [16],
		nd_pgm_date	            [20],

	
		/o************ newly added variable for KN EHNANCMENTS *****o/
		d_section_name		[60],
		d_added_date		[21],
		d_added_date1		[21],
		d_added_time		[21],
	
		/o******* parameters from SY_PROG_PARAM table **********o/
		nd_section_code    	[2],
		nd_worklist_name   	[11],
		nd_worklist_date   	[11],
		nd_worklist_date1   	[11],
		nd_criteria_flag   	[2],
		nd_fr_specimen_no  	[21],
		nd_to_specimen_no  	[21],
		nd_print_yn             [2],
		nd_user_id              [31],
		rp_worklist_name        [11],     
		rp_worklist_date        [11],
		rp_reprint              [8],
		nd_assign_to		[31],
		rp_assign_to		[31],
		nd_field_type		[2],

        /o variable for cursor o/
		nd_cur_specimen_no      [21],
		nd_cur_patient_id       [31],
        nd_file_no              [15],

	       /o for header routine o/
	       //d_acc_entity_name         [61],
		   d_acc_entity_name         [300],
	       d_user                    [31],
	       d_sysdate                 [20],

           /o Fields from table RL_SECTION__CODE o/
	       d_printer_name            [16],

/o  New Fields from RL_WORKLIST_FMT_HDR  o/
		nd_cup_number		    [32],
		nd_cup_indr				[32],
		nd_spec_no				[32],
		nd_wl_marker			[32],
		nd_pat_id			    [32],
		nd_pat_name	     		[61],
		nd_age					[32],
		nd_dob					[32],
		nd_sex					[32],
		nd_source				[32],
		nd_consultant			[32],
		nd_urgency				[32],
		nd_comm_1				[32],
		nd_comm_2				[32],
		nd_comm_3				[32],
		nd_spec_date			[32],
		nd_ref_location			[32],
		nd_collect_date			[32], 
		nd_category_no			[32], 
		nd_race					[32],
		nd_heading				[20],
		
		/o Added on 26/01/2004 to get the Print Previouos Result flag o/
		d_prv_result_yn			[3],
		nd_prv_result_dt        [30],
		d_past_result_unit      [6],
		nd_modified_dt			[30],

		d_test_code				[11],
		/o****variables added for conversion********o/
		l_translated_value		 [100],
		language_id			[5]; */ 
struct { unsigned short len; unsigned char arr[3]; } nd_operating_facility_id;

struct { unsigned short len; unsigned char arr[91]; } uid_pwd;

struct { unsigned short len; unsigned char arr[150]; } nd_file_name;

struct { unsigned short len; unsigned char arr[5]; } d_qlty_code;

struct { unsigned short len; unsigned char arr[11]; } d_worklist_name;

struct { unsigned short len; unsigned char arr[2]; } d_criteria_flag;

struct { unsigned short len; unsigned char arr[51]; } d_cup_indicators_1;

struct { unsigned short len; unsigned char arr[51]; } d_cup_indicators_2;

struct { unsigned short len; unsigned char arr[51]; } d_cup_indicators_3;

struct { unsigned short len; unsigned char arr[51]; } d_cup_indicators_4;

struct { unsigned short len; unsigned char arr[51]; } d_cup_indicators_5;

struct { unsigned short len; unsigned char arr[51]; } d_added_by_id;

struct { unsigned short len; unsigned char arr[31]; } rowid_wrk;

struct { unsigned short len; unsigned char arr[11]; } d_worklist_test_code;

struct { unsigned short len; unsigned char arr[2]; } d_test_indicator;

struct { unsigned short len; unsigned char arr[21]; } d_specimen_no;

struct { unsigned short len; unsigned char arr[21]; } nd_specimen_no;

struct { unsigned short len; unsigned char arr[30]; } d_prt_cup_no;

struct { unsigned short len; unsigned char arr[31]; } d_patient_id;

struct { unsigned short len; unsigned char arr[11]; } d_req_test_code;

struct { unsigned short len; unsigned char arr[16]; } d_num_result;

struct { unsigned short len; unsigned char arr[16]; } d_comm_result;

struct { unsigned short len; unsigned char arr[16]; } d_test_result;

struct { unsigned short len; unsigned char arr[16]; } d_test_prv_result;

struct { unsigned short len; unsigned char arr[11]; } d_req_dtl_test;

struct { unsigned short len; unsigned char arr[11]; } d_qc_test_code;

struct { unsigned short len; unsigned char arr[11]; } d_date_of_birth;

struct { unsigned short len; unsigned char arr[240]; } d_short_name;

struct { unsigned short len; unsigned char arr[5]; } d_nation;

struct { unsigned short len; unsigned char arr[2]; } d_sex;

struct { unsigned short len; unsigned char arr[2]; } d_pat_mark;

struct { unsigned short len; unsigned char arr[11]; } d_worklist_marker;

struct { unsigned short len; unsigned char arr[7]; } d_source_code;

struct { unsigned short len; unsigned char arr[2]; } d_episode_type;

struct { unsigned short len; unsigned char arr[17]; } d_spec_regd_date_time;

struct { unsigned short len; unsigned char arr[17]; } d_l_spec_regd_date_time;

struct { unsigned short len; unsigned char arr[16]; } d_consultant_code;

struct { unsigned short len; unsigned char arr[2]; } d_urgent_indicator;

struct { unsigned short len; unsigned char arr[5]; } d_request_comment_code1;

struct { unsigned short len; unsigned char arr[5]; } d_request_comment_code2;

struct { unsigned short len; unsigned char arr[5]; } d_request_comment_code3;

struct { unsigned short len; unsigned char arr[42]; } d_request_comment_desc1;

struct { unsigned short len; unsigned char arr[42]; } d_request_comment_desc2;

struct { unsigned short len; unsigned char arr[42]; } d_request_comment_desc3;

struct { unsigned short len; unsigned char arr[21]; } d_prt_specimen_no;

struct { unsigned short len; unsigned char arr[31]; } d_prt_patient_id;

struct { unsigned short len; unsigned char arr[2]; } d_print_cup_indicator;

struct { unsigned short len; unsigned char arr[11]; } d_qlty_test;

struct { unsigned short len; unsigned char arr[11]; } nd_chk_test_code;

struct { unsigned short len; unsigned char arr[21]; } nd_ins_specimen_no;

struct { unsigned short len; unsigned char arr[31]; } nd_ins_patient_id;

struct { unsigned short len; unsigned char arr[30]; } today;

struct { unsigned short len; unsigned char arr[30]; } t_days;

struct { unsigned short len; unsigned char arr[30]; } mths;

struct { unsigned short len; unsigned char arr[30]; } mths1;

struct { unsigned short len; unsigned char arr[30]; } t_age;

struct { unsigned short len; unsigned char arr[16]; } nd_session_id;

struct { unsigned short len; unsigned char arr[20]; } nd_pgm_date;

struct { unsigned short len; unsigned char arr[60]; } d_section_name;

struct { unsigned short len; unsigned char arr[21]; } d_added_date;

struct { unsigned short len; unsigned char arr[21]; } d_added_date1;

struct { unsigned short len; unsigned char arr[21]; } d_added_time;

struct { unsigned short len; unsigned char arr[2]; } nd_section_code;

struct { unsigned short len; unsigned char arr[11]; } nd_worklist_name;

struct { unsigned short len; unsigned char arr[11]; } nd_worklist_date;

struct { unsigned short len; unsigned char arr[11]; } nd_worklist_date1;

struct { unsigned short len; unsigned char arr[2]; } nd_criteria_flag;

struct { unsigned short len; unsigned char arr[21]; } nd_fr_specimen_no;

struct { unsigned short len; unsigned char arr[21]; } nd_to_specimen_no;

struct { unsigned short len; unsigned char arr[2]; } nd_print_yn;

struct { unsigned short len; unsigned char arr[31]; } nd_user_id;

struct { unsigned short len; unsigned char arr[11]; } rp_worklist_name;

struct { unsigned short len; unsigned char arr[11]; } rp_worklist_date;

struct { unsigned short len; unsigned char arr[8]; } rp_reprint;

struct { unsigned short len; unsigned char arr[31]; } nd_assign_to;

struct { unsigned short len; unsigned char arr[31]; } rp_assign_to;

struct { unsigned short len; unsigned char arr[2]; } nd_field_type;

struct { unsigned short len; unsigned char arr[21]; } nd_cur_specimen_no;

struct { unsigned short len; unsigned char arr[31]; } nd_cur_patient_id;

struct { unsigned short len; unsigned char arr[15]; } nd_file_no;

struct { unsigned short len; unsigned char arr[300]; } d_acc_entity_name;

struct { unsigned short len; unsigned char arr[31]; } d_user;

struct { unsigned short len; unsigned char arr[20]; } d_sysdate;

struct { unsigned short len; unsigned char arr[16]; } d_printer_name;

struct { unsigned short len; unsigned char arr[32]; } nd_cup_number;

struct { unsigned short len; unsigned char arr[32]; } nd_cup_indr;

struct { unsigned short len; unsigned char arr[32]; } nd_spec_no;

struct { unsigned short len; unsigned char arr[32]; } nd_wl_marker;

struct { unsigned short len; unsigned char arr[32]; } nd_pat_id;

struct { unsigned short len; unsigned char arr[61]; } nd_pat_name;

struct { unsigned short len; unsigned char arr[32]; } nd_age;

struct { unsigned short len; unsigned char arr[32]; } nd_dob;

struct { unsigned short len; unsigned char arr[32]; } nd_sex;

struct { unsigned short len; unsigned char arr[32]; } nd_source;

struct { unsigned short len; unsigned char arr[32]; } nd_consultant;

struct { unsigned short len; unsigned char arr[32]; } nd_urgency;

struct { unsigned short len; unsigned char arr[32]; } nd_comm_1;

struct { unsigned short len; unsigned char arr[32]; } nd_comm_2;

struct { unsigned short len; unsigned char arr[32]; } nd_comm_3;

struct { unsigned short len; unsigned char arr[32]; } nd_spec_date;

struct { unsigned short len; unsigned char arr[32]; } nd_ref_location;

struct { unsigned short len; unsigned char arr[32]; } nd_collect_date;

struct { unsigned short len; unsigned char arr[32]; } nd_category_no;

struct { unsigned short len; unsigned char arr[32]; } nd_race;

struct { unsigned short len; unsigned char arr[20]; } nd_heading;

struct { unsigned short len; unsigned char arr[3]; } d_prv_result_yn;

struct { unsigned short len; unsigned char arr[30]; } nd_prv_result_dt;

struct { unsigned short len; unsigned char arr[6]; } d_past_result_unit;

struct { unsigned short len; unsigned char arr[30]; } nd_modified_dt;

struct { unsigned short len; unsigned char arr[11]; } d_test_code;

struct { unsigned short len; unsigned char arr[100]; } l_translated_value;

struct { unsigned short len; unsigned char arr[5]; } language_id;



		int		d_past_result_period;
		int		d_past_result_no;

float mt;

/* Fields from table SY_PROG_PARAM*/                          

int  		nd_worklist_no;
int             rp_worklist_no;

/* Fields from table RL_WORKLIST_FMT_HDR */                          

int  		d_worklist_no, d_no_of_cups,d_line_spacing;

/* Fields from table RL_WORKLIST_FMT_DTL */                          
/* int  	d_prt_cup_no;      */
int  		d_seq_no; 
int         d_no_of_tests;
int		    tests ;

/* Fields from table RL_WORKLIST_DTL */                          
char            d_prt_test_1_yn,d_prt_test_2_yn,d_prt_test_3_yn,
                d_prt_test_4_yn,d_prt_test_5_yn,d_prt_test_6_yn,
                d_prt_test_7_yn,d_prt_test_8_yn,d_prt_test_9_yn,
                d_prt_test_10_yn,d_prt_test_11_yn,d_prt_test_12_yn,
                d_prt_test_13_yn,d_prt_test_14_yn,d_prt_test_15_yn,
                d_prt_test_16_yn,d_prt_test_17_yn,d_prt_test_18_yn,
                d_prt_test_19_yn,d_prt_test_20_yn,d_prt_test_21_yn,
                d_prt_test_22_yn,d_prt_test_23_yn,d_prt_test_24_yn,
                d_prt_test_25_yn;
  
  
/* Dummy Fields  */                                                  
int  		ic,cup_no = 0,pending_tests = 0;
int  		line_no,page_no,no_of_tests,tests_on_page;
char            test_exists_in_specimen;
char            sql_stmt[5000];
char 		cup_ind;                                  
char		nd_qc_code;
char            dummy_test_array[25];
char            cup_indicator[251];
char            file_name[30],
		file_name2[30];


/************** NEWLY ADDED FOR KNDV ENHANCEMENTS	**************/

	/* VARCHAR		d_tst_test_code		    [11],
				d_tst_numeric_result    [16],
				d_num_prefix			[2],
				d_tst_test_name		    [41],
				d_curr_date			    [11],
				d_curr_date1			[11],
				d_curr_time			    [6],
				d_assign_to			    [21],
				d_category			    [25],
				d_spec_colltd_date_time [20],
				d_race_code				[5],
				d_location				[21],
				d_comm_result1			[16],
				d_comm_result2			[16],
				d_comm_result3			[16],
				d_comm_result4			[16],
				d_status				[2],
				d_comm_result_desc1			[41],
				d_comm_result_desc2			[41],
				d_comm_result_desc3			[41],
				d_comm_result_desc4			[41]; */ 
struct { unsigned short len; unsigned char arr[11]; } d_tst_test_code;

struct { unsigned short len; unsigned char arr[16]; } d_tst_numeric_result;

struct { unsigned short len; unsigned char arr[2]; } d_num_prefix;

struct { unsigned short len; unsigned char arr[41]; } d_tst_test_name;

struct { unsigned short len; unsigned char arr[11]; } d_curr_date;

struct { unsigned short len; unsigned char arr[11]; } d_curr_date1;

struct { unsigned short len; unsigned char arr[6]; } d_curr_time;

struct { unsigned short len; unsigned char arr[21]; } d_assign_to;

struct { unsigned short len; unsigned char arr[25]; } d_category;

struct { unsigned short len; unsigned char arr[20]; } d_spec_colltd_date_time;

struct { unsigned short len; unsigned char arr[5]; } d_race_code;

struct { unsigned short len; unsigned char arr[21]; } d_location;

struct { unsigned short len; unsigned char arr[16]; } d_comm_result1;

struct { unsigned short len; unsigned char arr[16]; } d_comm_result2;

struct { unsigned short len; unsigned char arr[16]; } d_comm_result3;

struct { unsigned short len; unsigned char arr[16]; } d_comm_result4;

struct { unsigned short len; unsigned char arr[2]; } d_status;

struct { unsigned short len; unsigned char arr[41]; } d_comm_result_desc1;

struct { unsigned short len; unsigned char arr[41]; } d_comm_result_desc2;

struct { unsigned short len; unsigned char arr[41]; } d_comm_result_desc3;

struct { unsigned short len; unsigned char arr[41]; } d_comm_result_desc4;


/*** Added to get the print the Previous results ***/

	/* VARCHAR		d_prv_specimen_no			[30],
				d_tst_prv_test_code		    [11],
				d_tst_prv_numeric_result    [16],
				d_num_prv_prefix			[2],
				d_tst_prv_test_name		    [41],
				d_curr_prv_date			    [11],
				d_curr_prv_time			    [6],
				d_assign_prv_to			    [21],
				d_category_prv			    [25],
				d_spec_prv_colltd_date_time [20],
				d_race_code_prv				[5],
				d_location_prv				[21],
				d_comm_prv_result1			[16],
				d_comm_prv_result2			[16],
				d_comm_prv_result3			[16],
				d_comm_prv_result4			[16],
				d_status_prv				[2],
				d_comm_prv_result_desc1			[41],
				d_comm_prv_result_desc2			[41],
				d_comm_prv_result_desc3			[41],
				d_comm_prv_result_desc4			[41],
				d_prv_specimen_regd_date        [30]; */ 
struct { unsigned short len; unsigned char arr[30]; } d_prv_specimen_no;

struct { unsigned short len; unsigned char arr[11]; } d_tst_prv_test_code;

struct { unsigned short len; unsigned char arr[16]; } d_tst_prv_numeric_result;

struct { unsigned short len; unsigned char arr[2]; } d_num_prv_prefix;

struct { unsigned short len; unsigned char arr[41]; } d_tst_prv_test_name;

struct { unsigned short len; unsigned char arr[11]; } d_curr_prv_date;

struct { unsigned short len; unsigned char arr[6]; } d_curr_prv_time;

struct { unsigned short len; unsigned char arr[21]; } d_assign_prv_to;

struct { unsigned short len; unsigned char arr[25]; } d_category_prv;

struct { unsigned short len; unsigned char arr[20]; } d_spec_prv_colltd_date_time;

struct { unsigned short len; unsigned char arr[5]; } d_race_code_prv;

struct { unsigned short len; unsigned char arr[21]; } d_location_prv;

struct { unsigned short len; unsigned char arr[16]; } d_comm_prv_result1;

struct { unsigned short len; unsigned char arr[16]; } d_comm_prv_result2;

struct { unsigned short len; unsigned char arr[16]; } d_comm_prv_result3;

struct { unsigned short len; unsigned char arr[16]; } d_comm_prv_result4;

struct { unsigned short len; unsigned char arr[2]; } d_status_prv;

struct { unsigned short len; unsigned char arr[41]; } d_comm_prv_result_desc1;

struct { unsigned short len; unsigned char arr[41]; } d_comm_prv_result_desc2;

struct { unsigned short len; unsigned char arr[41]; } d_comm_prv_result_desc3;

struct { unsigned short len; unsigned char arr[41]; } d_comm_prv_result_desc4;

struct { unsigned short len; unsigned char arr[30]; } d_prv_specimen_regd_date;



int stimulate = 0;
int num[22];
int cou[22];
char word[22][32];
char str_word[22][32];
char temp_word[32];
char detail[22][44];
int largest_row = 0;
int header_printed = 0;

int l_count = 0;

char	print_temp_line[100];
char	print_test_line[100];

//Added for conversion
int i;
char local_legend[100][100];
char hdr_line1[REP_WIDTH+1],
     hdr_line2[REP_WIDTH+1],
     hdr_line3[REP_WIDTH+1];
int col;
char rep_title1[100] ;
char rep_title2[60];
int rec_len;




/* EXEC SQL END DECLARE SECTION; */ 


/* EXEC SQL INCLUDE SQLCA.H;
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
/* EXEC SQL INCLUDE SQLDA.H;
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

int       rec_inserted;
int       atleast_one_specimen_found;
int       specimen_over;
int       mandatory_tests_exist;
int       worklist_mandatory_tests_exist;
char      worklist_test[26][11];
char      worklist_ind[26][2];
char      mandatory_ind[26];
int       print_line;
char      chk_mand_test[26];
char      string_var[1000];
int       test_ctr;
int       maxx = 0;

int i =  0;
int j = 0 ;
int k = 0;
int ctr = 0;
int str_len = 0 ;
int total = 0 ;
int tot_tests = 0;

char cup_type;

FILE *f1;

void proc_main(argc, argv)
int argc;
char *argv[];
{
  void  get_params(),
  	get_header_dtls(),
	dclr_request_detail_cur(),
    dclr_worklist_dtl_cur(),
    dclr_worklist_prt_dtl_cur(),
  	dclr_specimen_cur(),
  	get_worklist_hdr(),
	get_worklist_specimen_range(),
	dclr_qlty_tests_cur(),
  	do_report(),
	//get_dept_printer(),
	get_worklist_marker(),
	get_prvrslt_flag();

	void print_hyphen(FILE *);
	void patient_age();
	void print_dtl(FILE *);
	void sorting();
	void reverse_sort();
	void prepare_heading(FILE *);

   if(argc < 4) {
     disp_message(ERR_MESG,"Usage rlrcrewl uid/passwd session_id pgm_date\n");
     proc_exit();
   }

   strcpy(uid_pwd.arr, argv[1]);
   uid_pwd.len = strlen(uid_pwd.arr); 

   strcpy(nd_session_id.arr, argv[2]);
   nd_session_id.len = strlen(nd_session_id.arr); 

   strcpy(nd_pgm_date.arr, argv[3]);
   nd_pgm_date.len = strlen(nd_pgm_date.arr); 

   strcpy(OUTPUT_FILE_NAME, argv[5]);

//disp_message(ERR_MESG, uid_pwd.arr);

   /* EXEC SQL CONNECT :uid_pwd; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 4;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )10;
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
}

  

   if(OERROR)
      disp_message(ORA_MESG,"Failed to connect using : %s\n");

#ifdef DEBUG
    printf("Connected to ORACLE as user: %s \n", uid_pwd.arr);
#endif  
    
    set_meduser_role();
	  strcpy(language_id.arr,l_language_id.arr);
	language_id.len =l_language_id.len;
	language_id.arr[l_language_id.len]='\0';
	
   get_legend_value(26);



   /*printf("RLRCREWL : Program Started.\n\n"); */

   get_params();

   get_prvrslt_flag();

   if(strcmp(rp_reprint.arr,"REPRINT") == 0)
   {
      strcpy(nd_worklist_name.arr,rp_worklist_name.arr);
      nd_worklist_name.len = strlen(rp_worklist_name.arr);
      nd_worklist_no = rp_worklist_no;
      strcpy(nd_worklist_date.arr,rp_worklist_date.arr);
      nd_worklist_date.len = strlen(rp_worklist_date.arr);
      get_worklist_specimen_range();
   }
   gen_file_name();
     
   get_worklist_marker();
     
   get_worklist_hdr();
  
   dclr_worklist_dtl_cur();
//   dclr_specimen_cur();
   dclr_worklist_prt_dtl_cur();
   
   get_header_dtls();
   dclr_qlty_tests_cur();

   do_report();

   //get_dept_printer();

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



   fclose(f1);
   return;

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

void get_worklist_specimen_range() 
{
   nd_fr_specimen_no.arr[0] = '\0';
   nd_fr_specimen_no.len = 0;
   nd_to_specimen_no.arr[0] = '\0';
   nd_to_specimen_no.len = 0;
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT MAX(SPECIMEN_NO),MIN(SPECIMEN_NO)
	        INTO :nd_to_specimen_no,:nd_fr_specimen_no
	        FROM RL_WORKLIST_DTL
            WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
			AND SECTION_CODE = :nd_section_code
	        AND WORKLIST_NAME = :nd_worklist_name
	        AND WORKLIST_NO   = :nd_worklist_no 
            AND WORKLIST_DATE = 
  	                TRUNC(TO_DATE(:nd_worklist_date,'DD/MM/YYYY')); */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select max(SPECIMEN_NO) ,min(SPECIMEN_NO) into :b0,:b1  fr\
om RL_WORKLIST_DTL where ((((OPERATING_FACILITY_ID=:b2 and SECTION_CODE=:b3) a\
nd WORKLIST_NAME=:b4) and WORKLIST_NO=:b5) and WORKLIST_DATE=TRUNC(TO_DATE(:b6\
,'DD/MM/YYYY')))";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )66;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&nd_to_specimen_no;
   sqlstm.sqhstl[0] = (unsigned int  )23;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_fr_specimen_no;
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
   sqlstm.sqhstv[3] = (         void  *)&nd_section_code;
   sqlstm.sqhstl[3] = (unsigned int  )4;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_worklist_name;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_worklist_no;
   sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_worklist_date;
   sqlstm.sqhstl[6] = (unsigned int  )13;
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


   nd_fr_specimen_no.arr[nd_fr_specimen_no.len] = '\0';
   nd_to_specimen_no.arr[nd_to_specimen_no.len] = '\0';
   return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )109;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_worklist_specimen_range() occured....\n");
   proc_exit();
}

/* get the printer name */
void get_dept_printer()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /**************COMMENTED ON 16.01.2008 SINCE IT IS NOT USED
   EXEC SQL SELECT  printer_name INTO :d_printer_name
            FROM    RL_SECTION_CODE
	    WHERE   SECTION_CODE = :nd_section_code;
		******************END COMMENTS**********************/

  d_printer_name.arr[d_printer_name.len] = '\0';

#ifdef DEBUG
   printf("d_printer_name = %s\n", d_printer_name.arr);
#endif

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 7;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )124;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_dept_printer() occured....\n");
   proc_exit();
}


/************get_legend_value*******************/
get_legend_value(int cou)
 {
     
   
	/* EXEC SQL EXECUTE
	BEGIN
	  SM_POPULATE_REPORT_LEGEND.FETCH_LEGEND (:nd_operating_facility_id,:language_id,'RLRRESWP.LEGEND_');
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin SM_POPULATE_REPORT_LEGEND . FETCH_LEGEND ( :nd_operati\
ng_facility_id , :language_id , 'RLRRESWP.LEGEND_' ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )139;
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
               :l_translated_value :=    GET_LEGEND(LTRIM(RTRIM('RLRRESWP.LEGEND_'||LTRIM(RTRIM(TO_CHAR(:i,'009'))))));
	END;
	END-EXEC; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 7;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "begin :l_translated_value := GET_LEGEND ( LTRIM ( RTRIM ( 'R\
LRRESWP.LEGEND_' || LTRIM ( RTRIM ( TO_CHAR ( :i , '009' ) ) ) ) ) ) ; END ;";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )162;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&l_translated_value;
 sqlstm.sqhstl[0] = (unsigned int  )102;
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
/****************End****************/
/**********PRINT SPACE*************/
print_space(int aa, int bb, int cc)
{
	if (cc ==1)
	{
  		for(i=1;i <= (aa - bb) ;i++)
		{
			fprintf(f1,"%s"," ");
		}	
	}
	else if (cc ==0)
	{
  		for(i= (aa - bb);i <= aa ;i++)
		{
			fprintf(f1,"%s","-");
		}	
	}
}
/***********end***************/

/* get the parameters from the SY_PROG_PARM table and */
/* delete the record after reading it.                 */
void get_params()
{
		rp_worklist_name.arr[0] = '\0';
		rp_worklist_name.len = 0;
		rp_worklist_date.arr[0] = '\0';
		rp_worklist_date.len = 0;
		rp_reprint.arr[0] = '\0';
		rp_reprint.len = 0;
		rp_assign_to.arr[0]	= '\0';
		rp_assign_to.len		= 0;

   /* read the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT 
           OPERATING_FACILITY_ID,
		   PARAM1,
		   PARAM2,
		   PARAM3,
		   PARAM4,
		   PARAM5,
		   PARAM6,
		   PARAM7,
		   PARAM8,
		   UPPER(PARAM9),
		   PARAM10,
		   PARAM11,
		   PARAM12,
		   PARAM13,
		   PARAM14
            INTO 
		:nd_operating_facility_id,
		:nd_section_code ,  
		:nd_worklist_name,  
		:nd_worklist_no  ,
		:nd_worklist_date,
		:nd_criteria_flag,
		:nd_fr_specimen_no,
		:nd_to_specimen_no,
		:nd_print_yn,
		:nd_user_id,
		:rp_worklist_name,     
		:rp_worklist_no,
		:rp_worklist_date,
		:rp_reprint,
		:rp_assign_to
            FROM SY_PROG_PARAM
	    WHERE   PGM_ID = 'RLRRESWP'
		    AND SESSION_ID = TO_NUMBER(:nd_session_id)
		    AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select OPERATING_FACILITY_ID ,PARAM1 ,PARAM2 ,PARAM3 ,PARA\
M4 ,PARAM5 ,PARAM6 ,PARAM7 ,PARAM8 ,UPPER(PARAM9) ,PARAM10 ,PARAM11 ,PARAM12 ,\
PARAM13 ,PARAM14 into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:\
b13,:b14  from SY_PROG_PARAM where ((PGM_ID='RLRRESWP' and SESSION_ID=TO_NUMBE\
R(:b15)) and PGM_DATE=:b16)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )185;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_section_code;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_worklist_name;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_worklist_no;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_worklist_date;
   sqlstm.sqhstl[4] = (unsigned int  )13;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&nd_criteria_flag;
   sqlstm.sqhstl[5] = (unsigned int  )4;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&nd_fr_specimen_no;
   sqlstm.sqhstl[6] = (unsigned int  )23;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&nd_to_specimen_no;
   sqlstm.sqhstl[7] = (unsigned int  )23;
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&nd_print_yn;
   sqlstm.sqhstl[8] = (unsigned int  )4;
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_user_id;
   sqlstm.sqhstl[9] = (unsigned int  )33;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&rp_worklist_name;
   sqlstm.sqhstl[10] = (unsigned int  )13;
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&rp_worklist_no;
   sqlstm.sqhstl[11] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&rp_worklist_date;
   sqlstm.sqhstl[12] = (unsigned int  )13;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&rp_reprint;
   sqlstm.sqhstl[13] = (unsigned int  )10;
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&rp_assign_to;
   sqlstm.sqhstl[14] = (unsigned int  )33;
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_session_id;
   sqlstm.sqhstl[15] = (unsigned int  )18;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&nd_pgm_date;
   sqlstm.sqhstl[16] = (unsigned int  )22;
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
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
  nd_section_code.arr[nd_section_code.len] 	  = '\0';
  nd_worklist_name.arr[nd_worklist_name.len]  = '\0';
  nd_worklist_date.arr[nd_worklist_date.len]  = '\0';
  nd_criteria_flag.arr[nd_criteria_flag.len]  = '\0';
  nd_fr_specimen_no.arr[nd_fr_specimen_no.len] 	= '\0';
  nd_to_specimen_no.arr[nd_to_specimen_no.len] 	= '\0';
  nd_print_yn.arr[nd_print_yn.len] 				= '\0';
  nd_user_id.arr[nd_user_id.len] 				= '\0';
  rp_worklist_name.arr[rp_worklist_name.len]	= '\0';     
  rp_worklist_date.arr[rp_worklist_date.len]	= '\0';
  rp_reprint.arr[rp_reprint.len]				= '\0';
  rp_assign_to.arr[rp_assign_to.len]			= '\0';


#ifdef DEBUG
   printf("**********Parameters from SY_PROG_PARAM *******************\n");
   printf(" nd_section_code = %s\n",nd_section_code.arr);
   printf(" nd_worklist_name = %s\n",nd_worklist_name.arr);
   printf(" nd_worklist_no = %d\n",nd_worklist_no);
   printf(" nd_worklist_date = %s\n",nd_worklist_date.arr);
   printf(" nd_criteria_flag = %s\n",nd_criteria_flag.arr);
   printf(" nd_fr_specimen_no = %s\n",nd_fr_specimen_no.arr);
   printf(" nd_to_specimen_no = %s\n",nd_to_specimen_no.arr);
   printf(" nd_print_yn = %s\n",nd_print_yn.arr);
   printf(" nd_user_id = %s\n",nd_user_id.arr);
   printf(" rp_worklist_name = %s\n",rp_worklist_name.arr);     
   printf(" rp_worklist_no = %d\n",rp_worklist_no);
   printf(" rp_worklist_date = %s\n",rp_worklist_date.arr);
   printf(" rp_reprint = %s\n",rp_reprint.arr);
   getchar();  
#endif

  /* delete the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL DELETE SY_PROG_PARAM
	   WHERE PGM_ID = 'RLRRESWP'
	         AND SESSION_ID = :nd_session_id
		 AND PGM_DATE = :nd_pgm_date; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "delete  from SY_PROG_PARAM  where ((PGM_ID='RLRRESWP' and \
SESSION_ID=:b0) and PGM_DATE=:b1)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )268;
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
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )291;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_params() occured....\n");
   proc_exit();
}

/*** To get the Previous result flag from section Control parameters ***/

void get_prvrslt_flag()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT  print_prev_results_yn INTO :d_prv_result_yn
            FROM    RL_SECTION_CTL
	    WHERE   SECTION_CODE = :nd_section_code
		AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select print_prev_results_yn into :b0  from RL_SECTION_CTL\
 where (SECTION_CODE=:b1 and OPERATING_FACILITY_ID=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )306;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_prv_result_yn;
   sqlstm.sqhstl[0] = (unsigned int  )5;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_section_code;
   sqlstm.sqhstl[1] = (unsigned int  )4;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}



  d_prv_result_yn.arr[d_prv_result_yn.len] = '\0';

#ifdef DEBUG
   printf("d_prv_result_yn = %s\n", d_prv_result_yn.arr);
#endif

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )333;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_prvrslt_flag() occured....\n");
   proc_exit();
}

/* get the header details */
void get_header_dtls()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT SUBSTR(acc_entity_name, 1, 60), 
   /o
   SUBSTR(LPAD(ACC_ENTITY_NAME_LONG,
		       TRUNC(15 + 0.5*LENGTH(ACC_ENTITY_NAME_LONG))),1,60),
   o/
		   USER,
		   TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI')
	    INTO :d_acc_entity_name,
		 :d_user,
		 :d_sysdate
            FROM SY_ACC_ENTITY_LANG_VW
            WHERE ACC_ENTITY_ID = :nd_operating_facility_id
			AND   LANGUAGE_ID = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(acc_entity_name,1,60) ,USER ,TO_CHAR(SYSDATE\
,'DD/MM/YYYY HH24:MI') into :b0,:b1,:b2  from SY_ACC_ENTITY_LANG_VW where (ACC\
_ENTITY_ID=:b3 and LANGUAGE_ID=:b4)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )348;
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
   sqlstm.sqhstl[1] = (unsigned int  )33;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_sysdate;
   sqlstm.sqhstl[2] = (unsigned int  )22;
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
   sqlstm.arrsiz = 17;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )383;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_header_dtls() occured....\n");
   proc_exit();
}
 

/* get the WORKLIST Header detail from RL_WORKLIST_FMT_HDR */
/* delete the record after reading it.                     */
void get_worklist_hdr()
{

   nd_field_type.arr[0] = '\0';
   nd_field_type.len 	= 0;
   nd_cup_number.arr[0] = '\0';
   nd_cup_number.len = 0 ;
   nd_cup_indr.arr[0] = '\0';
   nd_cup_indr.len = 0 ;
   nd_spec_no.arr[0] = '\0';
   nd_spec_no.len = 0 ;
   nd_wl_marker.arr[0] = '\0';
   nd_wl_marker.len = 0 ;
   nd_pat_id.arr[0] = '\0';
   nd_pat_id.len = 0 ;
   nd_pat_name.arr[0] = '\0';
   nd_pat_name.len = 0 ;
   nd_source.arr[0] = '\0';
   nd_source.len = 0 ;
   nd_consultant.arr[0] = '\0';
   nd_consultant.len = 0 ;
   nd_urgency.arr[0] = '\0';
   nd_urgency.len = 0 ;	
   nd_comm_1.arr[0] = '\0';
   nd_comm_1.len = 0 ;	
   nd_comm_2.arr[0] = '\0';
   nd_comm_2.len = 0 ;	
   nd_comm_3.arr[0] = '\0';
   nd_comm_3.len = 0 ;	
   nd_spec_date.arr[0] = '\0';
   nd_spec_date.len = 0 ;	

    for (i=0;i<21;i++)
    {
	   num[i] = 0;
	   cou[i] = 0;
	  
	   strcpy(word[i],"0");
    }

   /* read the parameter record */
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT NO_OF_CUPS,
		   LINE_SPACING,
		   CUP_INDICATOR_1,
		   CUP_INDICATOR_2,
		   CUP_INDICATOR_3,
		   CUP_INDICATOR_4,
		   CUP_INDICATOR_5, 
		 NVL(row_cup_number,0), NVL(col_cup_number,0),
		 NVL(l_cup_number,'0'), NVL(row_cup_indr,0), NVL(col_cup_indr,0),
		 NVL(l_cup_indr,'0'),NVL(row_wl_marker,0), NVL(col_wl_marker,0),
		 NVL(l_wl_marker,'0'), NVL(row_spec_no,0), NVL(col_spec_no,0),
		 NVL(l_spec_no,'0'),  NVL(row_patient_id,0), NVL(col_patient_id,0),
		 NVL(l_patient_id,'0'), NVL(row_pat_name,0), NVL(col_pat_name,0),
		 NVL(l_pat_name,'0'),NVL(row_age,0), NVL(col_age,0), NVL(l_age,'0'),
		 NVL(row_dob,0), NVL(col_dob,0), NVL(l_dob,'0'), NVL(row_sex,0), NVL(col_sex,0),
		 NVL(l_sex,'0'), NVL(row_source,0), NVL(col_source,0), NVL(l_source,'0'),
		 NVL(row_consultant,0), NVL(col_consultant,0), NVL(l_consultant,'0'),
		 NVL(row_urgency,0), NVL(col_urgency,0), NVL(l_urgency,'0'),
		 NVL(row_comm_1,0), NVL(col_comm_1,0),NVL(l_comm_1,'0'), NVL(row_comm_2,0),
		 NVL(col_comm_2,0), NVL(l_comm_2,0), NVL(row_comm_3,0), NVL(col_comm_3,0),
 	     NVL(l_comm_3,'0'), NVL(row_spec_date,0), NVL(col_spec_date,0),
  	     NVL(l_spec_date,'0'), NVL(field_type, 'A'),
		 NVL(row_assign_to, 0), NVL(col_assign_to, 0), NVL(l_assign_to, '0'),
		 NVL(row_ref_location, 0), NVL(col_ref_location, 0), NVL(l_ref_location, '0'),
		 NVL(row_category_no, 0), NVL(col_category_no, 0), NVL(l_category_no, '0'),
		 NVL(row_collect_date, 0), NVL(col_collect_date, 0), NVL(l_collect_date, '0'),
		 NVL(row_race, 0), NVL(col_race, 0), NVL(l_race, '0')
            INTO 
		:d_no_of_cups,
		:d_line_spacing,
		:d_cup_indicators_1,
		:d_cup_indicators_2,
		:d_cup_indicators_3,
		:d_cup_indicators_4,
		:d_cup_indicators_5,
 :num[0], :cou[0], :nd_cup_number,
 :num[1], :cou[1], :nd_cup_indr,
 :num[2], :cou[2], :nd_wl_marker,
 :num[3], :cou[3], :nd_spec_no,
 :num[4], :cou[4], :nd_pat_id,
 :num[5], :cou[5], :nd_pat_name,
 :num[6], :cou[6], :nd_age,
 :num[7], :cou[7], :nd_dob,
 :num[8], :cou[8], :nd_sex,
 :num[9], :cou[9], :nd_source,
 :num[10], :cou[10], :nd_consultant,
 :num[11], :cou[11], :nd_urgency,
 :num[12], :cou[12], :nd_comm_1,
 :num[13], :cou[13], :nd_comm_2,
 :num[14], :cou[14], :nd_comm_3,
 :num[15], :cou[15], :nd_spec_date, :nd_field_type,
 :num[16], :cou[16], :nd_assign_to,
 :num[17], :cou[17], :nd_ref_location,
 :num[18], :cou[18], :nd_category_no,
 :num[19], :cou[19], :nd_collect_date,
 :num[20], :cou[20], :nd_race
        FROM RL_WORKLIST_FMT_HDR
	    WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
		AND SECTION_CODE  = :nd_section_code 
	    AND WORKLIST_NAME = :nd_worklist_name; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlbuft((void **)0, 
     "select NO_OF_CUPS ,LINE_SPACING ,CUP_INDICATOR_1 ,CUP_INDICATOR_2 ,CUP\
_INDICATOR_3 ,CUP_INDICATOR_4 ,CUP_INDICATOR_5 ,NVL(row_cup_number,0) ,NVL(c\
ol_cup_number,0) ,NVL(l_cup_number,'0') ,NVL(row_cup_indr,0) ,NVL(col_cup_in\
dr,0) ,NVL(l_cup_indr,'0') ,NVL(row_wl_marker,0) ,NVL(col_wl_marker,0) ,NVL(\
l_wl_marker,'0') ,NVL(row_spec_no,0) ,NVL(col_spec_no,0) ,NVL(l_spec_no,'0')\
 ,NVL(row_patient_id,0) ,NVL(col_patient_id,0) ,NVL(l_patient_id,'0') ,NVL(r\
ow_pat_name,0) ,NVL(col_pat_name,0) ,NVL(l_pat_name,'0') ,NVL(row_age,0) ,NV\
L(col_age,0) ,NVL(l_age,'0') ,NVL(row_dob,0) ,NVL(col_dob,0) ,NVL(l_dob,'0')\
 ,NVL(row_sex,0) ,NVL(col_sex,0) ,NVL(l_sex,'0') ,NVL(row_source,0) ,NVL(col\
_source,0) ,NVL(l_source,'0') ,NVL(row_consultant,0) ,NVL(col_consultant,0) \
,NVL(l_consultant,'0') ,NVL(row_urgency,0) ,NVL(col_urgency,0) ,NVL(l_urgenc\
y,'0') ,NVL(row_comm_1,0) ,NVL(col_comm_1,0) ,NVL(l_comm_1,'0') ,NVL(row_com\
m_2,0) ,NVL(col_comm_2,0) ,NVL(l_comm_2,0) ,NVL(row_comm_3,0) ,NVL(col_comm_\
3,0) ,NVL(l_comm_3,'0') ,NVL(row_spec_date");
   sqlstm.stmt = ",0) ,NVL(col_spec_date,0) ,NVL(l_spec_date,'0') ,NVL(field\
_type,'A') ,NVL(row_assign_to,0) ,NVL(col_assign_to,0) ,NVL(l_assign_to,'0') ,\
NVL(row_ref_location,0) ,NVL(col_ref_location,0) ,NVL(l_ref_location,'0') ,NVL\
(row_category_no,0) ,NVL(col_category_no,0) ,NVL(l_category_no,'0') ,NVL(row_c\
ollect_date,0) ,NVL(col_collect_date,0) ,NVL(l_collect_date,'0') ,NVL(row_race\
,0) ,NVL(col_race,0) ,NVL(l_race,'0') into :b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8\
,:b9,:b10,:b11,:b12,:b13,:b14,:b15,:b16,:b17,:b18,:b19,:b20,:b21,:b22,:b23,:b2\
4,:b25,:b26,:b27,:b28,:b29,:b30,:b31,:b32,:b33,:b34,:b35,:b36,:b37,:b38,:b39,:\
b40,:b41,:b42,:b43,:b44,:b45,:b46,:b47,:b48,:b49,:b50,:b51,:b52,:b53,:b54,:b55\
,:b56,:b57,:b58,:b59,:b60,:b61,:b62,:b63,:b64,:b65,:b66,:b67,:b68,:b69,:b70  f\
rom RL_WORKLIST_FMT_HDR where ((OPERATING_FACILITY_ID=:b71 and SECTION_CODE=:b\
72) and WORKLIST_NAME=:b73)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )398;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_no_of_cups;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_line_spacing;
   sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_cup_indicators_1;
   sqlstm.sqhstl[2] = (unsigned int  )53;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_cup_indicators_2;
   sqlstm.sqhstl[3] = (unsigned int  )53;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_cup_indicators_3;
   sqlstm.sqhstl[4] = (unsigned int  )53;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_cup_indicators_4;
   sqlstm.sqhstl[5] = (unsigned int  )53;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_cup_indicators_5;
   sqlstm.sqhstl[6] = (unsigned int  )53;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&num[0];
   sqlstm.sqhstl[7] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[7] = (         int  )0;
   sqlstm.sqindv[7] = (         void  *)0;
   sqlstm.sqinds[7] = (         int  )0;
   sqlstm.sqharm[7] = (unsigned int  )0;
   sqlstm.sqadto[7] = (unsigned short )0;
   sqlstm.sqtdso[7] = (unsigned short )0;
   sqlstm.sqhstv[8] = (         void  *)&cou[0];
   sqlstm.sqhstl[8] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[8] = (         int  )0;
   sqlstm.sqindv[8] = (         void  *)0;
   sqlstm.sqinds[8] = (         int  )0;
   sqlstm.sqharm[8] = (unsigned int  )0;
   sqlstm.sqadto[8] = (unsigned short )0;
   sqlstm.sqtdso[8] = (unsigned short )0;
   sqlstm.sqhstv[9] = (         void  *)&nd_cup_number;
   sqlstm.sqhstl[9] = (unsigned int  )34;
   sqlstm.sqhsts[9] = (         int  )0;
   sqlstm.sqindv[9] = (         void  *)0;
   sqlstm.sqinds[9] = (         int  )0;
   sqlstm.sqharm[9] = (unsigned int  )0;
   sqlstm.sqadto[9] = (unsigned short )0;
   sqlstm.sqtdso[9] = (unsigned short )0;
   sqlstm.sqhstv[10] = (         void  *)&num[1];
   sqlstm.sqhstl[10] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[10] = (         int  )0;
   sqlstm.sqindv[10] = (         void  *)0;
   sqlstm.sqinds[10] = (         int  )0;
   sqlstm.sqharm[10] = (unsigned int  )0;
   sqlstm.sqadto[10] = (unsigned short )0;
   sqlstm.sqtdso[10] = (unsigned short )0;
   sqlstm.sqhstv[11] = (         void  *)&cou[1];
   sqlstm.sqhstl[11] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[11] = (         int  )0;
   sqlstm.sqindv[11] = (         void  *)0;
   sqlstm.sqinds[11] = (         int  )0;
   sqlstm.sqharm[11] = (unsigned int  )0;
   sqlstm.sqadto[11] = (unsigned short )0;
   sqlstm.sqtdso[11] = (unsigned short )0;
   sqlstm.sqhstv[12] = (         void  *)&nd_cup_indr;
   sqlstm.sqhstl[12] = (unsigned int  )34;
   sqlstm.sqhsts[12] = (         int  )0;
   sqlstm.sqindv[12] = (         void  *)0;
   sqlstm.sqinds[12] = (         int  )0;
   sqlstm.sqharm[12] = (unsigned int  )0;
   sqlstm.sqadto[12] = (unsigned short )0;
   sqlstm.sqtdso[12] = (unsigned short )0;
   sqlstm.sqhstv[13] = (         void  *)&num[2];
   sqlstm.sqhstl[13] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[13] = (         int  )0;
   sqlstm.sqindv[13] = (         void  *)0;
   sqlstm.sqinds[13] = (         int  )0;
   sqlstm.sqharm[13] = (unsigned int  )0;
   sqlstm.sqadto[13] = (unsigned short )0;
   sqlstm.sqtdso[13] = (unsigned short )0;
   sqlstm.sqhstv[14] = (         void  *)&cou[2];
   sqlstm.sqhstl[14] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[14] = (         int  )0;
   sqlstm.sqindv[14] = (         void  *)0;
   sqlstm.sqinds[14] = (         int  )0;
   sqlstm.sqharm[14] = (unsigned int  )0;
   sqlstm.sqadto[14] = (unsigned short )0;
   sqlstm.sqtdso[14] = (unsigned short )0;
   sqlstm.sqhstv[15] = (         void  *)&nd_wl_marker;
   sqlstm.sqhstl[15] = (unsigned int  )34;
   sqlstm.sqhsts[15] = (         int  )0;
   sqlstm.sqindv[15] = (         void  *)0;
   sqlstm.sqinds[15] = (         int  )0;
   sqlstm.sqharm[15] = (unsigned int  )0;
   sqlstm.sqadto[15] = (unsigned short )0;
   sqlstm.sqtdso[15] = (unsigned short )0;
   sqlstm.sqhstv[16] = (         void  *)&num[3];
   sqlstm.sqhstl[16] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[16] = (         int  )0;
   sqlstm.sqindv[16] = (         void  *)0;
   sqlstm.sqinds[16] = (         int  )0;
   sqlstm.sqharm[16] = (unsigned int  )0;
   sqlstm.sqadto[16] = (unsigned short )0;
   sqlstm.sqtdso[16] = (unsigned short )0;
   sqlstm.sqhstv[17] = (         void  *)&cou[3];
   sqlstm.sqhstl[17] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[17] = (         int  )0;
   sqlstm.sqindv[17] = (         void  *)0;
   sqlstm.sqinds[17] = (         int  )0;
   sqlstm.sqharm[17] = (unsigned int  )0;
   sqlstm.sqadto[17] = (unsigned short )0;
   sqlstm.sqtdso[17] = (unsigned short )0;
   sqlstm.sqhstv[18] = (         void  *)&nd_spec_no;
   sqlstm.sqhstl[18] = (unsigned int  )34;
   sqlstm.sqhsts[18] = (         int  )0;
   sqlstm.sqindv[18] = (         void  *)0;
   sqlstm.sqinds[18] = (         int  )0;
   sqlstm.sqharm[18] = (unsigned int  )0;
   sqlstm.sqadto[18] = (unsigned short )0;
   sqlstm.sqtdso[18] = (unsigned short )0;
   sqlstm.sqhstv[19] = (         void  *)&num[4];
   sqlstm.sqhstl[19] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[19] = (         int  )0;
   sqlstm.sqindv[19] = (         void  *)0;
   sqlstm.sqinds[19] = (         int  )0;
   sqlstm.sqharm[19] = (unsigned int  )0;
   sqlstm.sqadto[19] = (unsigned short )0;
   sqlstm.sqtdso[19] = (unsigned short )0;
   sqlstm.sqhstv[20] = (         void  *)&cou[4];
   sqlstm.sqhstl[20] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[20] = (         int  )0;
   sqlstm.sqindv[20] = (         void  *)0;
   sqlstm.sqinds[20] = (         int  )0;
   sqlstm.sqharm[20] = (unsigned int  )0;
   sqlstm.sqadto[20] = (unsigned short )0;
   sqlstm.sqtdso[20] = (unsigned short )0;
   sqlstm.sqhstv[21] = (         void  *)&nd_pat_id;
   sqlstm.sqhstl[21] = (unsigned int  )34;
   sqlstm.sqhsts[21] = (         int  )0;
   sqlstm.sqindv[21] = (         void  *)0;
   sqlstm.sqinds[21] = (         int  )0;
   sqlstm.sqharm[21] = (unsigned int  )0;
   sqlstm.sqadto[21] = (unsigned short )0;
   sqlstm.sqtdso[21] = (unsigned short )0;
   sqlstm.sqhstv[22] = (         void  *)&num[5];
   sqlstm.sqhstl[22] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[22] = (         int  )0;
   sqlstm.sqindv[22] = (         void  *)0;
   sqlstm.sqinds[22] = (         int  )0;
   sqlstm.sqharm[22] = (unsigned int  )0;
   sqlstm.sqadto[22] = (unsigned short )0;
   sqlstm.sqtdso[22] = (unsigned short )0;
   sqlstm.sqhstv[23] = (         void  *)&cou[5];
   sqlstm.sqhstl[23] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[23] = (         int  )0;
   sqlstm.sqindv[23] = (         void  *)0;
   sqlstm.sqinds[23] = (         int  )0;
   sqlstm.sqharm[23] = (unsigned int  )0;
   sqlstm.sqadto[23] = (unsigned short )0;
   sqlstm.sqtdso[23] = (unsigned short )0;
   sqlstm.sqhstv[24] = (         void  *)&nd_pat_name;
   sqlstm.sqhstl[24] = (unsigned int  )63;
   sqlstm.sqhsts[24] = (         int  )0;
   sqlstm.sqindv[24] = (         void  *)0;
   sqlstm.sqinds[24] = (         int  )0;
   sqlstm.sqharm[24] = (unsigned int  )0;
   sqlstm.sqadto[24] = (unsigned short )0;
   sqlstm.sqtdso[24] = (unsigned short )0;
   sqlstm.sqhstv[25] = (         void  *)&num[6];
   sqlstm.sqhstl[25] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[25] = (         int  )0;
   sqlstm.sqindv[25] = (         void  *)0;
   sqlstm.sqinds[25] = (         int  )0;
   sqlstm.sqharm[25] = (unsigned int  )0;
   sqlstm.sqadto[25] = (unsigned short )0;
   sqlstm.sqtdso[25] = (unsigned short )0;
   sqlstm.sqhstv[26] = (         void  *)&cou[6];
   sqlstm.sqhstl[26] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[26] = (         int  )0;
   sqlstm.sqindv[26] = (         void  *)0;
   sqlstm.sqinds[26] = (         int  )0;
   sqlstm.sqharm[26] = (unsigned int  )0;
   sqlstm.sqadto[26] = (unsigned short )0;
   sqlstm.sqtdso[26] = (unsigned short )0;
   sqlstm.sqhstv[27] = (         void  *)&nd_age;
   sqlstm.sqhstl[27] = (unsigned int  )34;
   sqlstm.sqhsts[27] = (         int  )0;
   sqlstm.sqindv[27] = (         void  *)0;
   sqlstm.sqinds[27] = (         int  )0;
   sqlstm.sqharm[27] = (unsigned int  )0;
   sqlstm.sqadto[27] = (unsigned short )0;
   sqlstm.sqtdso[27] = (unsigned short )0;
   sqlstm.sqhstv[28] = (         void  *)&num[7];
   sqlstm.sqhstl[28] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[28] = (         int  )0;
   sqlstm.sqindv[28] = (         void  *)0;
   sqlstm.sqinds[28] = (         int  )0;
   sqlstm.sqharm[28] = (unsigned int  )0;
   sqlstm.sqadto[28] = (unsigned short )0;
   sqlstm.sqtdso[28] = (unsigned short )0;
   sqlstm.sqhstv[29] = (         void  *)&cou[7];
   sqlstm.sqhstl[29] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[29] = (         int  )0;
   sqlstm.sqindv[29] = (         void  *)0;
   sqlstm.sqinds[29] = (         int  )0;
   sqlstm.sqharm[29] = (unsigned int  )0;
   sqlstm.sqadto[29] = (unsigned short )0;
   sqlstm.sqtdso[29] = (unsigned short )0;
   sqlstm.sqhstv[30] = (         void  *)&nd_dob;
   sqlstm.sqhstl[30] = (unsigned int  )34;
   sqlstm.sqhsts[30] = (         int  )0;
   sqlstm.sqindv[30] = (         void  *)0;
   sqlstm.sqinds[30] = (         int  )0;
   sqlstm.sqharm[30] = (unsigned int  )0;
   sqlstm.sqadto[30] = (unsigned short )0;
   sqlstm.sqtdso[30] = (unsigned short )0;
   sqlstm.sqhstv[31] = (         void  *)&num[8];
   sqlstm.sqhstl[31] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[31] = (         int  )0;
   sqlstm.sqindv[31] = (         void  *)0;
   sqlstm.sqinds[31] = (         int  )0;
   sqlstm.sqharm[31] = (unsigned int  )0;
   sqlstm.sqadto[31] = (unsigned short )0;
   sqlstm.sqtdso[31] = (unsigned short )0;
   sqlstm.sqhstv[32] = (         void  *)&cou[8];
   sqlstm.sqhstl[32] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[32] = (         int  )0;
   sqlstm.sqindv[32] = (         void  *)0;
   sqlstm.sqinds[32] = (         int  )0;
   sqlstm.sqharm[32] = (unsigned int  )0;
   sqlstm.sqadto[32] = (unsigned short )0;
   sqlstm.sqtdso[32] = (unsigned short )0;
   sqlstm.sqhstv[33] = (         void  *)&nd_sex;
   sqlstm.sqhstl[33] = (unsigned int  )34;
   sqlstm.sqhsts[33] = (         int  )0;
   sqlstm.sqindv[33] = (         void  *)0;
   sqlstm.sqinds[33] = (         int  )0;
   sqlstm.sqharm[33] = (unsigned int  )0;
   sqlstm.sqadto[33] = (unsigned short )0;
   sqlstm.sqtdso[33] = (unsigned short )0;
   sqlstm.sqhstv[34] = (         void  *)&num[9];
   sqlstm.sqhstl[34] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[34] = (         int  )0;
   sqlstm.sqindv[34] = (         void  *)0;
   sqlstm.sqinds[34] = (         int  )0;
   sqlstm.sqharm[34] = (unsigned int  )0;
   sqlstm.sqadto[34] = (unsigned short )0;
   sqlstm.sqtdso[34] = (unsigned short )0;
   sqlstm.sqhstv[35] = (         void  *)&cou[9];
   sqlstm.sqhstl[35] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[35] = (         int  )0;
   sqlstm.sqindv[35] = (         void  *)0;
   sqlstm.sqinds[35] = (         int  )0;
   sqlstm.sqharm[35] = (unsigned int  )0;
   sqlstm.sqadto[35] = (unsigned short )0;
   sqlstm.sqtdso[35] = (unsigned short )0;
   sqlstm.sqhstv[36] = (         void  *)&nd_source;
   sqlstm.sqhstl[36] = (unsigned int  )34;
   sqlstm.sqhsts[36] = (         int  )0;
   sqlstm.sqindv[36] = (         void  *)0;
   sqlstm.sqinds[36] = (         int  )0;
   sqlstm.sqharm[36] = (unsigned int  )0;
   sqlstm.sqadto[36] = (unsigned short )0;
   sqlstm.sqtdso[36] = (unsigned short )0;
   sqlstm.sqhstv[37] = (         void  *)&num[10];
   sqlstm.sqhstl[37] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[37] = (         int  )0;
   sqlstm.sqindv[37] = (         void  *)0;
   sqlstm.sqinds[37] = (         int  )0;
   sqlstm.sqharm[37] = (unsigned int  )0;
   sqlstm.sqadto[37] = (unsigned short )0;
   sqlstm.sqtdso[37] = (unsigned short )0;
   sqlstm.sqhstv[38] = (         void  *)&cou[10];
   sqlstm.sqhstl[38] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[38] = (         int  )0;
   sqlstm.sqindv[38] = (         void  *)0;
   sqlstm.sqinds[38] = (         int  )0;
   sqlstm.sqharm[38] = (unsigned int  )0;
   sqlstm.sqadto[38] = (unsigned short )0;
   sqlstm.sqtdso[38] = (unsigned short )0;
   sqlstm.sqhstv[39] = (         void  *)&nd_consultant;
   sqlstm.sqhstl[39] = (unsigned int  )34;
   sqlstm.sqhsts[39] = (         int  )0;
   sqlstm.sqindv[39] = (         void  *)0;
   sqlstm.sqinds[39] = (         int  )0;
   sqlstm.sqharm[39] = (unsigned int  )0;
   sqlstm.sqadto[39] = (unsigned short )0;
   sqlstm.sqtdso[39] = (unsigned short )0;
   sqlstm.sqhstv[40] = (         void  *)&num[11];
   sqlstm.sqhstl[40] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[40] = (         int  )0;
   sqlstm.sqindv[40] = (         void  *)0;
   sqlstm.sqinds[40] = (         int  )0;
   sqlstm.sqharm[40] = (unsigned int  )0;
   sqlstm.sqadto[40] = (unsigned short )0;
   sqlstm.sqtdso[40] = (unsigned short )0;
   sqlstm.sqhstv[41] = (         void  *)&cou[11];
   sqlstm.sqhstl[41] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[41] = (         int  )0;
   sqlstm.sqindv[41] = (         void  *)0;
   sqlstm.sqinds[41] = (         int  )0;
   sqlstm.sqharm[41] = (unsigned int  )0;
   sqlstm.sqadto[41] = (unsigned short )0;
   sqlstm.sqtdso[41] = (unsigned short )0;
   sqlstm.sqhstv[42] = (         void  *)&nd_urgency;
   sqlstm.sqhstl[42] = (unsigned int  )34;
   sqlstm.sqhsts[42] = (         int  )0;
   sqlstm.sqindv[42] = (         void  *)0;
   sqlstm.sqinds[42] = (         int  )0;
   sqlstm.sqharm[42] = (unsigned int  )0;
   sqlstm.sqadto[42] = (unsigned short )0;
   sqlstm.sqtdso[42] = (unsigned short )0;
   sqlstm.sqhstv[43] = (         void  *)&num[12];
   sqlstm.sqhstl[43] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[43] = (         int  )0;
   sqlstm.sqindv[43] = (         void  *)0;
   sqlstm.sqinds[43] = (         int  )0;
   sqlstm.sqharm[43] = (unsigned int  )0;
   sqlstm.sqadto[43] = (unsigned short )0;
   sqlstm.sqtdso[43] = (unsigned short )0;
   sqlstm.sqhstv[44] = (         void  *)&cou[12];
   sqlstm.sqhstl[44] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[44] = (         int  )0;
   sqlstm.sqindv[44] = (         void  *)0;
   sqlstm.sqinds[44] = (         int  )0;
   sqlstm.sqharm[44] = (unsigned int  )0;
   sqlstm.sqadto[44] = (unsigned short )0;
   sqlstm.sqtdso[44] = (unsigned short )0;
   sqlstm.sqhstv[45] = (         void  *)&nd_comm_1;
   sqlstm.sqhstl[45] = (unsigned int  )34;
   sqlstm.sqhsts[45] = (         int  )0;
   sqlstm.sqindv[45] = (         void  *)0;
   sqlstm.sqinds[45] = (         int  )0;
   sqlstm.sqharm[45] = (unsigned int  )0;
   sqlstm.sqadto[45] = (unsigned short )0;
   sqlstm.sqtdso[45] = (unsigned short )0;
   sqlstm.sqhstv[46] = (         void  *)&num[13];
   sqlstm.sqhstl[46] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[46] = (         int  )0;
   sqlstm.sqindv[46] = (         void  *)0;
   sqlstm.sqinds[46] = (         int  )0;
   sqlstm.sqharm[46] = (unsigned int  )0;
   sqlstm.sqadto[46] = (unsigned short )0;
   sqlstm.sqtdso[46] = (unsigned short )0;
   sqlstm.sqhstv[47] = (         void  *)&cou[13];
   sqlstm.sqhstl[47] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[47] = (         int  )0;
   sqlstm.sqindv[47] = (         void  *)0;
   sqlstm.sqinds[47] = (         int  )0;
   sqlstm.sqharm[47] = (unsigned int  )0;
   sqlstm.sqadto[47] = (unsigned short )0;
   sqlstm.sqtdso[47] = (unsigned short )0;
   sqlstm.sqhstv[48] = (         void  *)&nd_comm_2;
   sqlstm.sqhstl[48] = (unsigned int  )34;
   sqlstm.sqhsts[48] = (         int  )0;
   sqlstm.sqindv[48] = (         void  *)0;
   sqlstm.sqinds[48] = (         int  )0;
   sqlstm.sqharm[48] = (unsigned int  )0;
   sqlstm.sqadto[48] = (unsigned short )0;
   sqlstm.sqtdso[48] = (unsigned short )0;
   sqlstm.sqhstv[49] = (         void  *)&num[14];
   sqlstm.sqhstl[49] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[49] = (         int  )0;
   sqlstm.sqindv[49] = (         void  *)0;
   sqlstm.sqinds[49] = (         int  )0;
   sqlstm.sqharm[49] = (unsigned int  )0;
   sqlstm.sqadto[49] = (unsigned short )0;
   sqlstm.sqtdso[49] = (unsigned short )0;
   sqlstm.sqhstv[50] = (         void  *)&cou[14];
   sqlstm.sqhstl[50] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[50] = (         int  )0;
   sqlstm.sqindv[50] = (         void  *)0;
   sqlstm.sqinds[50] = (         int  )0;
   sqlstm.sqharm[50] = (unsigned int  )0;
   sqlstm.sqadto[50] = (unsigned short )0;
   sqlstm.sqtdso[50] = (unsigned short )0;
   sqlstm.sqhstv[51] = (         void  *)&nd_comm_3;
   sqlstm.sqhstl[51] = (unsigned int  )34;
   sqlstm.sqhsts[51] = (         int  )0;
   sqlstm.sqindv[51] = (         void  *)0;
   sqlstm.sqinds[51] = (         int  )0;
   sqlstm.sqharm[51] = (unsigned int  )0;
   sqlstm.sqadto[51] = (unsigned short )0;
   sqlstm.sqtdso[51] = (unsigned short )0;
   sqlstm.sqhstv[52] = (         void  *)&num[15];
   sqlstm.sqhstl[52] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[52] = (         int  )0;
   sqlstm.sqindv[52] = (         void  *)0;
   sqlstm.sqinds[52] = (         int  )0;
   sqlstm.sqharm[52] = (unsigned int  )0;
   sqlstm.sqadto[52] = (unsigned short )0;
   sqlstm.sqtdso[52] = (unsigned short )0;
   sqlstm.sqhstv[53] = (         void  *)&cou[15];
   sqlstm.sqhstl[53] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[53] = (         int  )0;
   sqlstm.sqindv[53] = (         void  *)0;
   sqlstm.sqinds[53] = (         int  )0;
   sqlstm.sqharm[53] = (unsigned int  )0;
   sqlstm.sqadto[53] = (unsigned short )0;
   sqlstm.sqtdso[53] = (unsigned short )0;
   sqlstm.sqhstv[54] = (         void  *)&nd_spec_date;
   sqlstm.sqhstl[54] = (unsigned int  )34;
   sqlstm.sqhsts[54] = (         int  )0;
   sqlstm.sqindv[54] = (         void  *)0;
   sqlstm.sqinds[54] = (         int  )0;
   sqlstm.sqharm[54] = (unsigned int  )0;
   sqlstm.sqadto[54] = (unsigned short )0;
   sqlstm.sqtdso[54] = (unsigned short )0;
   sqlstm.sqhstv[55] = (         void  *)&nd_field_type;
   sqlstm.sqhstl[55] = (unsigned int  )4;
   sqlstm.sqhsts[55] = (         int  )0;
   sqlstm.sqindv[55] = (         void  *)0;
   sqlstm.sqinds[55] = (         int  )0;
   sqlstm.sqharm[55] = (unsigned int  )0;
   sqlstm.sqadto[55] = (unsigned short )0;
   sqlstm.sqtdso[55] = (unsigned short )0;
   sqlstm.sqhstv[56] = (         void  *)&num[16];
   sqlstm.sqhstl[56] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[56] = (         int  )0;
   sqlstm.sqindv[56] = (         void  *)0;
   sqlstm.sqinds[56] = (         int  )0;
   sqlstm.sqharm[56] = (unsigned int  )0;
   sqlstm.sqadto[56] = (unsigned short )0;
   sqlstm.sqtdso[56] = (unsigned short )0;
   sqlstm.sqhstv[57] = (         void  *)&cou[16];
   sqlstm.sqhstl[57] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[57] = (         int  )0;
   sqlstm.sqindv[57] = (         void  *)0;
   sqlstm.sqinds[57] = (         int  )0;
   sqlstm.sqharm[57] = (unsigned int  )0;
   sqlstm.sqadto[57] = (unsigned short )0;
   sqlstm.sqtdso[57] = (unsigned short )0;
   sqlstm.sqhstv[58] = (         void  *)&nd_assign_to;
   sqlstm.sqhstl[58] = (unsigned int  )33;
   sqlstm.sqhsts[58] = (         int  )0;
   sqlstm.sqindv[58] = (         void  *)0;
   sqlstm.sqinds[58] = (         int  )0;
   sqlstm.sqharm[58] = (unsigned int  )0;
   sqlstm.sqadto[58] = (unsigned short )0;
   sqlstm.sqtdso[58] = (unsigned short )0;
   sqlstm.sqhstv[59] = (         void  *)&num[17];
   sqlstm.sqhstl[59] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[59] = (         int  )0;
   sqlstm.sqindv[59] = (         void  *)0;
   sqlstm.sqinds[59] = (         int  )0;
   sqlstm.sqharm[59] = (unsigned int  )0;
   sqlstm.sqadto[59] = (unsigned short )0;
   sqlstm.sqtdso[59] = (unsigned short )0;
   sqlstm.sqhstv[60] = (         void  *)&cou[17];
   sqlstm.sqhstl[60] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[60] = (         int  )0;
   sqlstm.sqindv[60] = (         void  *)0;
   sqlstm.sqinds[60] = (         int  )0;
   sqlstm.sqharm[60] = (unsigned int  )0;
   sqlstm.sqadto[60] = (unsigned short )0;
   sqlstm.sqtdso[60] = (unsigned short )0;
   sqlstm.sqhstv[61] = (         void  *)&nd_ref_location;
   sqlstm.sqhstl[61] = (unsigned int  )34;
   sqlstm.sqhsts[61] = (         int  )0;
   sqlstm.sqindv[61] = (         void  *)0;
   sqlstm.sqinds[61] = (         int  )0;
   sqlstm.sqharm[61] = (unsigned int  )0;
   sqlstm.sqadto[61] = (unsigned short )0;
   sqlstm.sqtdso[61] = (unsigned short )0;
   sqlstm.sqhstv[62] = (         void  *)&num[18];
   sqlstm.sqhstl[62] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[62] = (         int  )0;
   sqlstm.sqindv[62] = (         void  *)0;
   sqlstm.sqinds[62] = (         int  )0;
   sqlstm.sqharm[62] = (unsigned int  )0;
   sqlstm.sqadto[62] = (unsigned short )0;
   sqlstm.sqtdso[62] = (unsigned short )0;
   sqlstm.sqhstv[63] = (         void  *)&cou[18];
   sqlstm.sqhstl[63] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[63] = (         int  )0;
   sqlstm.sqindv[63] = (         void  *)0;
   sqlstm.sqinds[63] = (         int  )0;
   sqlstm.sqharm[63] = (unsigned int  )0;
   sqlstm.sqadto[63] = (unsigned short )0;
   sqlstm.sqtdso[63] = (unsigned short )0;
   sqlstm.sqhstv[64] = (         void  *)&nd_category_no;
   sqlstm.sqhstl[64] = (unsigned int  )34;
   sqlstm.sqhsts[64] = (         int  )0;
   sqlstm.sqindv[64] = (         void  *)0;
   sqlstm.sqinds[64] = (         int  )0;
   sqlstm.sqharm[64] = (unsigned int  )0;
   sqlstm.sqadto[64] = (unsigned short )0;
   sqlstm.sqtdso[64] = (unsigned short )0;
   sqlstm.sqhstv[65] = (         void  *)&num[19];
   sqlstm.sqhstl[65] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[65] = (         int  )0;
   sqlstm.sqindv[65] = (         void  *)0;
   sqlstm.sqinds[65] = (         int  )0;
   sqlstm.sqharm[65] = (unsigned int  )0;
   sqlstm.sqadto[65] = (unsigned short )0;
   sqlstm.sqtdso[65] = (unsigned short )0;
   sqlstm.sqhstv[66] = (         void  *)&cou[19];
   sqlstm.sqhstl[66] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[66] = (         int  )0;
   sqlstm.sqindv[66] = (         void  *)0;
   sqlstm.sqinds[66] = (         int  )0;
   sqlstm.sqharm[66] = (unsigned int  )0;
   sqlstm.sqadto[66] = (unsigned short )0;
   sqlstm.sqtdso[66] = (unsigned short )0;
   sqlstm.sqhstv[67] = (         void  *)&nd_collect_date;
   sqlstm.sqhstl[67] = (unsigned int  )34;
   sqlstm.sqhsts[67] = (         int  )0;
   sqlstm.sqindv[67] = (         void  *)0;
   sqlstm.sqinds[67] = (         int  )0;
   sqlstm.sqharm[67] = (unsigned int  )0;
   sqlstm.sqadto[67] = (unsigned short )0;
   sqlstm.sqtdso[67] = (unsigned short )0;
   sqlstm.sqhstv[68] = (         void  *)&num[20];
   sqlstm.sqhstl[68] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[68] = (         int  )0;
   sqlstm.sqindv[68] = (         void  *)0;
   sqlstm.sqinds[68] = (         int  )0;
   sqlstm.sqharm[68] = (unsigned int  )0;
   sqlstm.sqadto[68] = (unsigned short )0;
   sqlstm.sqtdso[68] = (unsigned short )0;
   sqlstm.sqhstv[69] = (         void  *)&cou[20];
   sqlstm.sqhstl[69] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[69] = (         int  )0;
   sqlstm.sqindv[69] = (         void  *)0;
   sqlstm.sqinds[69] = (         int  )0;
   sqlstm.sqharm[69] = (unsigned int  )0;
   sqlstm.sqadto[69] = (unsigned short )0;
   sqlstm.sqtdso[69] = (unsigned short )0;
   sqlstm.sqhstv[70] = (         void  *)&nd_race;
   sqlstm.sqhstl[70] = (unsigned int  )34;
   sqlstm.sqhsts[70] = (         int  )0;
   sqlstm.sqindv[70] = (         void  *)0;
   sqlstm.sqinds[70] = (         int  )0;
   sqlstm.sqharm[70] = (unsigned int  )0;
   sqlstm.sqadto[70] = (unsigned short )0;
   sqlstm.sqtdso[70] = (unsigned short )0;
   sqlstm.sqhstv[71] = (         void  *)&nd_operating_facility_id;
   sqlstm.sqhstl[71] = (unsigned int  )5;
   sqlstm.sqhsts[71] = (         int  )0;
   sqlstm.sqindv[71] = (         void  *)0;
   sqlstm.sqinds[71] = (         int  )0;
   sqlstm.sqharm[71] = (unsigned int  )0;
   sqlstm.sqadto[71] = (unsigned short )0;
   sqlstm.sqtdso[71] = (unsigned short )0;
   sqlstm.sqhstv[72] = (         void  *)&nd_section_code;
   sqlstm.sqhstl[72] = (unsigned int  )4;
   sqlstm.sqhsts[72] = (         int  )0;
   sqlstm.sqindv[72] = (         void  *)0;
   sqlstm.sqinds[72] = (         int  )0;
   sqlstm.sqharm[72] = (unsigned int  )0;
   sqlstm.sqadto[72] = (unsigned short )0;
   sqlstm.sqtdso[72] = (unsigned short )0;
   sqlstm.sqhstv[73] = (         void  *)&nd_worklist_name;
   sqlstm.sqhstl[73] = (unsigned int  )13;
   sqlstm.sqhsts[73] = (         int  )0;
   sqlstm.sqindv[73] = (         void  *)0;
   sqlstm.sqinds[73] = (         int  )0;
   sqlstm.sqharm[73] = (unsigned int  )0;
   sqlstm.sqadto[73] = (unsigned short )0;
   sqlstm.sqtdso[73] = (unsigned short )0;
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



  d_cup_indicators_1.arr[d_cup_indicators_1.len]		= '\0';
  d_cup_indicators_2.arr[d_cup_indicators_2.len]		= '\0';
  d_cup_indicators_3.arr[d_cup_indicators_3.len]		= '\0';
  d_cup_indicators_4.arr[d_cup_indicators_4.len]		= '\0';
  d_cup_indicators_5.arr[d_cup_indicators_5.len]		= '\0';

  strcpy(cup_indicator,d_cup_indicators_1.arr);
  strcat(cup_indicator,d_cup_indicators_2.arr);
  strcat(cup_indicator,d_cup_indicators_3.arr);
  strcat(cup_indicator,d_cup_indicators_4.arr);
  strcat(cup_indicator,d_cup_indicators_5.arr);

  /*strncpy(cup_indicator,d_cup_indicators_1.arr,d_cup_indicators_1.len);
  strncpy(cup_indicator+d_cup_indicators_2.len,d_cup_indicators_1.arr,d_cup_indicators_2.len);
  strncpy(cup_indicator+d_cup_indicators_2.len,d_cup_indicators_1.arr,d_cup_indicators_3.len);
  strncpy(cup_indicator+d_cup_indicators_2.len,d_cup_indicators_1.arr,d_cup_indicators_4.len);
  strncpy(cup_indicator+d_cup_indicators_2.len,d_cup_indicators_1.arr,d_cup_indicators_5.len); */

  nd_cup_number.arr[nd_cup_number.len] = '\0';
  nd_cup_indr.arr[nd_cup_indr.len]	   = '\0';
  nd_spec_no.arr[nd_spec_no.len]	   = '\0';
  nd_wl_marker.arr[nd_wl_marker.len]   = '\0';
  nd_pat_id.arr[nd_pat_id.len] = '\0';
  nd_pat_name.arr[nd_pat_name.len]     = '\0';
  nd_age.arr[nd_age.len]			   = '\0';
  nd_dob.arr[nd_dob.len]			   = '\0';
  nd_sex.arr[nd_sex.len]			   = '\0';
  nd_source.arr[nd_source.len]		   = '\0';
  nd_consultant.arr[nd_consultant.len] = '\0';
  nd_urgency.arr[nd_urgency.len]	   = '\0';
  nd_comm_1.arr[nd_comm_1.len]	       = '\0';
  nd_comm_2.arr[nd_comm_2.len]	       = '\0';
  nd_comm_3.arr[nd_comm_3.len]	       = '\0';
  nd_spec_date.arr[nd_spec_date.len]   	 = '\0';
  nd_field_type.arr[nd_field_type.len]	 = '\0';
  nd_assign_to.arr[nd_assign_to.len]	 = '\0';
  nd_ref_location.arr[nd_ref_location.len]	= '\0';
  nd_category_no.arr[nd_category_no.len]	= '\0';
  nd_collect_date.arr[nd_collect_date.len]	= '\0';
  nd_race.arr[nd_race.len]					= '\0';
  
  
#ifdef DEBUG
   printf("**********Parameters from SY_PROG_PARAM *******************\n");
   printf(" d_cup_indicators_1 = %s\n",d_cup_indicators_1.arr);
   printf(" d_cup_indicators_2 = %s\n",d_cup_indicators_2.arr);
   printf(" d_cup_indicators_3 = %s\n",d_cup_indicators_3.arr);
   printf(" d_cup_indicators_4 = %s\n",d_cup_indicators_4.arr);
   printf(" d_cup_indicators_5 = %s\n",d_cup_indicators_5.arr);
   printf(" cup_indicator = %s\n",cup_indicator);

#endif

   strcpy(word[0], nd_cup_number.arr);
   strcpy(word[1], nd_cup_indr.arr);
   strcpy(word[2], nd_wl_marker.arr);
   strcpy(word[3], nd_spec_no.arr);
   strcpy(word[4], nd_pat_id.arr);
   strcpy(word[5], nd_pat_name.arr);
   strcpy(word[6], nd_age.arr);
   strcpy(word[7], nd_dob.arr);
   strcpy(word[8], nd_sex.arr);
   strcpy(word[9], nd_source.arr);
   strcpy(word[10], nd_consultant.arr);
   strcpy(word[11], nd_urgency.arr);
   strcpy(word[12], nd_comm_1.arr);
   strcpy(word[13], nd_comm_2.arr);
   strcpy(word[14], nd_comm_3.arr);
   strcpy(word[15], nd_spec_date.arr);
   strcpy(word[16], nd_assign_to.arr);
   strcpy(word[17], nd_ref_location.arr);
   strcpy(word[18], nd_category_no.arr);
   strcpy(word[19], nd_collect_date.arr);
   strcpy(word[20], nd_race.arr);

   strcpy(str_word[0], "nd_cup_number");
   strcpy(str_word[1], "nd_cup_indr");
   strcpy(str_word[2], "nd_wl_marker");
   strcpy(str_word[3], "nd_spec_no");
   strcpy(str_word[4], "nd_pat_id");
   strcpy(str_word[5], "nd_pat_name");
   strcpy(str_word[6], "nd_age");
   strcpy(str_word[7], "nd_dob");
   strcpy(str_word[8], "nd_sex");
   strcpy(str_word[9], "nd_source");
   strcpy(str_word[10], "nd_consultant");
   strcpy(str_word[11], "nd_urgency");
   strcpy(str_word[12], "nd_comm_1");
   strcpy(str_word[13], "nd_comm_2");
   strcpy(str_word[14], "nd_comm_3");
   strcpy(str_word[15], "nd_spec_date");
   strcpy(str_word[16], "nd_assign_to");
   strcpy(str_word[17], "nd_ref_location");
   strcpy(str_word[18], "nd_category_no");
   strcpy(str_word[19], "nd_collect_date");
   strcpy(str_word[20], "nd_race");
  

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )709;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_worklist_hdr() occured....\n");
   proc_exit();
}
 
void dclr_request_detail_cur()
{
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL DECLARE REQUEST_DETAIL CURSOR FOR
         SELECT TEST_CODE              
          FROM RL_REQUEST_DETAIL
          WHERE PATIENT_ID = :d_prt_patient_id
	      AND SPECIMEN_NO = :d_prt_specimen_no
		  AND OPERATING_FACILITY_ID = :nd_operating_facility_id
          ORDER BY TEST_CODE; */ 

#ifdef DEBUG
    printf("leaving dclr_request_detail_cur()\n");
    fflush(stdout);
#endif
  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )724;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_request_detail_cur() occured....\n");
   proc_exit();
}

void open_request_detail_cur()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL OPEN REQUEST_DETAIL; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0018;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )739;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_prt_patient_id;
   sqlstm.sqhstl[0] = (unsigned int  )33;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_prt_specimen_no;
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
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )766;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error while open_request_detail_cur occured...\n");
   proc_exit();
}

int fetch_request_detail_cur()
{
  d_req_dtl_test.arr[0]    = '\0';
  d_req_dtl_test.len       = 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH REQUEST_DETAIL INTO :d_req_dtl_test; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 74;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )781;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_req_dtl_test;
  sqlstm.sqhstl[0] = (unsigned int  )13;
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



#ifdef DEBUG
         printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
#endif

  if (NODATAFOUND)
    return 0;
  d_req_dtl_test.arr[d_req_dtl_test.len]		= '\0';
#ifdef DEBUG
   printf("********* Details from RL_REQUEST_DETAIL**************\n");
   printf(" d_req_dtl_test= %s\n", d_req_dtl_test.arr);
#endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )800;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_request_detail_cur() occured....\n");
   proc_exit();
}

void close_request_detail_cur()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL CLOSE REQUEST_DETAIL; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )815;
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
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )830;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error while Close_request_detail_Cur() occured....\n");
   proc_exit();
}


/* function declares cursor RL_WORKLIST_FMT_DTL */
void dclr_worklist_dtl_cur()
{

    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL DECLARE WORKLIST_DTL_CUR CURSOR FOR
         SELECT TEST_CODE,              
         	SEQ_NO,                        
	        TEST_INDICATOR             
           FROM RL_WORKLIST_FMT_DTL                        
          WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
		  AND SECTION_CODE  = :nd_section_code 
	      AND WORKLIST_NAME = :nd_worklist_name              
          ORDER BY SEQ_NO ; */ 
                                     

   /*  Done in Do Report   */
   /*EXEC SQL WHENEVER SQLERROR GOTO err_exit;
     EXEC SQL OPEN TRN_ITEMS_CUR; */

#ifdef DEBUG
    printf("leaving dclr_worklist_dtl_cur()\n");
    fflush(stdout);
#endif
 
  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )845;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_worklist_dtl_cur() occured....\n");
   proc_exit();
}

/* function declares cursor RL_WORKLIST_DTL */
/* Used for Printing Worklist               */
void dclr_worklist_prt_dtl_cur()
{

    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

	
    /* EXEC SQL DECLARE WORKLIST_PRT_DTL_CUR CURSOR FOR
         SELECT TO_CHAR(WORKLIST_CUP_NO),        
         	TO_CHAR(SPECIMEN_NO),                   
	        PATIENT_ID,              
		    WORKLIST_CUP_INDICATOR,
	    	TEST_1_YN,
	    	TEST_2_YN,
	    	TEST_3_YN,
	    	TEST_4_YN,
	    	TEST_5_YN,
	    	TEST_6_YN,
	    	TEST_7_YN,
	    	TEST_8_YN,
	    	TEST_9_YN,
	    	TEST_10_YN,
	    	TEST_11_YN,
	    	TEST_12_YN,
	   	    TEST_13_YN,
	    	TEST_14_YN,
	   	    TEST_15_YN,
	    	TEST_16_YN,
	    	TEST_17_YN,
	    	TEST_18_YN,
	    	TEST_19_YN,
	   	    TEST_20_YN,
	    	TEST_21_YN,
	    	TEST_22_YN,
	  	    TEST_23_YN,
	    	TEST_24_YN,
	    	TEST_25_YN,
			QLTY_CODE
          FROM RL_WORKLIST_DTL                        
          WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
		  AND SECTION_CODE  = :nd_section_code
	      AND WORKLIST_NAME = :nd_worklist_name
	      AND WORKLIST_NO   = :nd_worklist_no
          AND WORKLIST_DATE = 
  	      TRUNC(TO_DATE(:nd_worklist_date,'DD/MM/YYYY'))
          ORDER BY WORKLIST_CUP_NO; */ 
                             

	    /*AND SPECIMEN_NO IS NOT NULL*/

   /*  Done in Do Report   */
   /*EXEC SQL WHENEVER SQLERROR GOTO err_exit;
     EXEC SQL OPEN TRN_ITEMS_CUR; */

#ifdef DEBUG
    printf("leaving dclr_worklist_prt_dtl_cur()\n");
    fflush(stdout);
#endif
 
  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )860;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_worklist_prt_dtl_cur() occured....\n");
   proc_exit();
}

void dclr_qlty_tests_cur()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL DECLARE QLTY_TESTS_CUR CURSOR FOR
         SELECT TEST_CODE              
         FROM   RL_TEST_QUALITY_MAST                        
         WHERE  OPERATING_FACILITY_ID = :nd_operating_facility_id
		 AND SECTION_CODE = :nd_section_code
	     AND qlty_code = :d_qlty_code; */ 

		 
		 //AND  QLTY_CODE    = :nd_qc_code;

   #ifdef DEBUG
       printf("leaving dclr_qlty_tests_cur()\n");
       fflush(stdout);
   #endif
   return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )875;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_qlty_tests_cur() occured....\n");
   proc_exit();
}
      
/* function declares SPECIMEN_CUR  cursor on the RL_TEST_RESULT */
/* And RL_WORKLIST_FMT_HDR */
void dclr_specimen_cur()
{
    
	/* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


	if (strcmp(nd_field_type.arr, "B") == 0)
	{
	    strcpy(sql_stmt, 
		   "SELECT A.SPECIMEN_NO,A.PATIENT_ID,A.TEST_CODE, \
			   A.NUMERIC_RESULT, A.numeric_prefix, A.RESULT_COMMENT_CODE1  \
	              FROM RL_TEST_RESULT A \
      	       WHERE A.SPECIMEN_NO BETWEEN NVL(:nd_fr_specimen_no,0) \
                                     AND NVL(:nd_to_specimen_no, 999999999999999) \
            	   AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id \
				   AND 0 < ( \
	           SELECT NVL(COUNT(*),0) FROM RL_TEST_RESULT B \
		       WHERE B.PATIENT_ID=A.PATIENT_ID AND B.SPECIMEN_NO=A.SPECIMEN_NO \
	      	   AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id \
			   AND B.TEST_CODE IN ( \
					  SELECT TEST_CODE FROM RL_WORKLIST_FMT_DTL \
					   WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id \
					   AND SECTION_CODE=:nd_section_code \
					     AND WORKLIST_NAME=:nd_worklist_name \
                                 ) \
      	        AND NVL(B.STATUS,'O') IN ('O','H') \
			       ) "); 
	}
	else if (strcmp(nd_field_type.arr, "N") == 0)
	{
	    strcpy(sql_stmt, 
		   "SELECT A.SPECIMEN_NO,A.PATIENT_ID,A.TEST_CODE, \
			   A.NUMERIC_RESULT,A.numeric_prefix, A.RESULT_COMMENT_CODE1  \
	              FROM RL_TEST_RESULT A, RL_REQUEST_HEADER B \
      	       WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id \
			   AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id \
			   AND A.SPECIMEN_NO BETWEEN NVL(:nd_fr_specimen_no,0) \
                                     AND NVL(:nd_to_specimen_no, 999999999999999) \
			   AND A.SPECIMEN_NO = B.SPECIMEN_NO \
			   AND B.SPECIMEN_NO BETWEEN NVL(:nd_fr_specimen_no,0) \
                                     AND NVL(:nd_to_specimen_no, 999999999999999) \
			   AND B.ASSIGN_TO IS NULL \
            	   AND 0 < ( \
	           SELECT NVL(COUNT(*),0) FROM RL_TEST_RESULT B \
		       WHERE B.PATIENT_ID=A.PATIENT_ID AND B.SPECIMEN_NO=A.SPECIMEN_NO \
	      	   AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id \
			   AND B.TEST_CODE IN ( \
					  SELECT TEST_CODE FROM RL_WORKLIST_FMT_DTL \
					   WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id \
					   AND SECTION_CODE=:nd_section_code \
					     AND WORKLIST_NAME=:nd_worklist_name \
                                 ) \
      	        AND NVL(B.STATUS,'O') IN ('O','H') \
			       ) "); 

	}
	else if (strcmp(nd_field_type.arr, "A") == 0)
	{
	  
//sprintf(string_var, "%s   %s  %s   %s  %s", nd_fr_specimen_no.arr, nd_to_specimen_no.arr,
///					nd_assign_to.arr, nd_section_code.arr, nd_worklist_name.arr);
//disp_message(ERR_MESG, string_var);


	    strcpy(sql_stmt, 
		   "SELECT A.SPECIMEN_NO,A.PATIENT_ID,A.TEST_CODE, \
			   A.NUMERIC_RESULT,A.numeric_prefix, A.RESULT_COMMENT_CODE1  \
	              FROM RL_TEST_RESULT A, RL_REQUEST_HEADER B \
      	       WHERE A.OPERATING_FACILITY_ID = :nd_operating_facility_id \
			   AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id \
			   AND A.SPECIMEN_NO BETWEEN NVL(:nd_fr_specimen_no,0) \
                                     AND NVL(:nd_to_specimen_no, 999999999999999) \
			   AND A.SPECIMEN_NO = B.SPECIMEN_NO \
			   AND B.SPECIMEN_NO BETWEEN NVL(:nd_fr_specimen_no,0) \
                                     AND NVL(:nd_to_specimen_no, 999999999999999) \
			   AND B.ASSIGN_TO = :rp_assign_to \
            	   AND 0 < ( \
	           SELECT NVL(COUNT(*),0) FROM RL_TEST_RESULT B \
		       WHERE B.PATIENT_ID=A.PATIENT_ID AND B.SPECIMEN_NO=A.SPECIMEN_NO \
	      	   AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id \
			   AND B.TEST_CODE IN ( \
					  SELECT TEST_CODE FROM RL_WORKLIST_FMT_DTL \
					   WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id \
					   AND SECTION_CODE=:nd_section_code \
					     AND WORKLIST_NAME=:nd_worklist_name \
                                 ) \
      	        AND NVL(B.STATUS,'O') IN ('O','H') \
			       ) "); 

	}

    strcat(sql_stmt, " ORDER BY A.SPECIMEN_NO ");


    /* EXEC SQL PREPARE S FROM :sql_stmt; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 74;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )890;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)sql_stmt;
    sqlstm.sqhstl[0] = (unsigned int  )5000;
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




    /* EXEC SQL DECLARE SPECIMEN_CUR CURSOR FOR S; */ 


    if (strcmp(nd_field_type.arr, "B") == 0)
    {
	   /* EXEC SQL OPEN SPECIMEN_CUR USING :nd_fr_specimen_no,  
                                     :nd_to_specimen_no,  
                                     :nd_operating_facility_id,
									 :nd_operating_facility_id,
									 :nd_operating_facility_id,
									 :nd_section_code,  
                                     :nd_worklist_name; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 74;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )909;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_fr_specimen_no;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_to_specimen_no;
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
    sqlstm.sqhstv[3] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[3] = (unsigned int  )5;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[4] = (unsigned int  )5;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&nd_section_code;
    sqlstm.sqhstl[5] = (unsigned int  )4;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&nd_worklist_name;
    sqlstm.sqhstl[6] = (unsigned int  )13;
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

  
    }
    else if (strcmp(nd_field_type.arr, "A") == 0)

    { 
	    /* EXEC SQL OPEN SPECIMEN_CUR USING :nd_operating_facility_id,
		                             :nd_operating_facility_id,
		                             :nd_fr_specimen_no,  
                                     :nd_to_specimen_no,  
									 :nd_fr_specimen_no,  
                                     :nd_to_specimen_no,  
						             :rp_assign_to,
                                     :nd_operating_facility_id,
									 :nd_operating_facility_id,
									 :nd_section_code,  
                                     :nd_worklist_name; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 74;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )952;
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
     sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_fr_specimen_no;
     sqlstm.sqhstl[2] = (unsigned int  )23;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_to_specimen_no;
     sqlstm.sqhstl[3] = (unsigned int  )23;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_fr_specimen_no;
     sqlstm.sqhstl[4] = (unsigned int  )23;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_to_specimen_no;
     sqlstm.sqhstl[5] = (unsigned int  )23;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&rp_assign_to;
     sqlstm.sqhstl[6] = (unsigned int  )33;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[7] = (unsigned int  )5;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[8] = (unsigned int  )5;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&nd_section_code;
     sqlstm.sqhstl[9] = (unsigned int  )4;
     sqlstm.sqhsts[9] = (         int  )0;
     sqlstm.sqindv[9] = (         void  *)0;
     sqlstm.sqinds[9] = (         int  )0;
     sqlstm.sqharm[9] = (unsigned int  )0;
     sqlstm.sqadto[9] = (unsigned short )0;
     sqlstm.sqtdso[9] = (unsigned short )0;
     sqlstm.sqhstv[10] = (         void  *)&nd_worklist_name;
     sqlstm.sqhstl[10] = (unsigned int  )13;
     sqlstm.sqhsts[10] = (         int  )0;
     sqlstm.sqindv[10] = (         void  *)0;
     sqlstm.sqinds[10] = (         int  )0;
     sqlstm.sqharm[10] = (unsigned int  )0;
     sqlstm.sqadto[10] = (unsigned short )0;
     sqlstm.sqtdso[10] = (unsigned short )0;
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

    else if (strcmp(nd_field_type.arr, "N") == 0)

    { 
	    /* EXEC SQL OPEN SPECIMEN_CUR USING :nd_operating_facility_id,
		                             :nd_operating_facility_id,
		                             :nd_fr_specimen_no,  
                                     :nd_to_specimen_no,  
									 :nd_fr_specimen_no,  
                                     :nd_to_specimen_no,  
						             :nd_operating_facility_id,
									 :nd_operating_facility_id,
									 :nd_section_code,  
                                     :nd_worklist_name; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 74;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )1011;
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
     sqlstm.sqhstv[1] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[1] = (unsigned int  )5;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&nd_fr_specimen_no;
     sqlstm.sqhstl[2] = (unsigned int  )23;
     sqlstm.sqhsts[2] = (         int  )0;
     sqlstm.sqindv[2] = (         void  *)0;
     sqlstm.sqinds[2] = (         int  )0;
     sqlstm.sqharm[2] = (unsigned int  )0;
     sqlstm.sqadto[2] = (unsigned short )0;
     sqlstm.sqtdso[2] = (unsigned short )0;
     sqlstm.sqhstv[3] = (         void  *)&nd_to_specimen_no;
     sqlstm.sqhstl[3] = (unsigned int  )23;
     sqlstm.sqhsts[3] = (         int  )0;
     sqlstm.sqindv[3] = (         void  *)0;
     sqlstm.sqinds[3] = (         int  )0;
     sqlstm.sqharm[3] = (unsigned int  )0;
     sqlstm.sqadto[3] = (unsigned short )0;
     sqlstm.sqtdso[3] = (unsigned short )0;
     sqlstm.sqhstv[4] = (         void  *)&nd_fr_specimen_no;
     sqlstm.sqhstl[4] = (unsigned int  )23;
     sqlstm.sqhsts[4] = (         int  )0;
     sqlstm.sqindv[4] = (         void  *)0;
     sqlstm.sqinds[4] = (         int  )0;
     sqlstm.sqharm[4] = (unsigned int  )0;
     sqlstm.sqadto[4] = (unsigned short )0;
     sqlstm.sqtdso[4] = (unsigned short )0;
     sqlstm.sqhstv[5] = (         void  *)&nd_to_specimen_no;
     sqlstm.sqhstl[5] = (unsigned int  )23;
     sqlstm.sqhsts[5] = (         int  )0;
     sqlstm.sqindv[5] = (         void  *)0;
     sqlstm.sqinds[5] = (         int  )0;
     sqlstm.sqharm[5] = (unsigned int  )0;
     sqlstm.sqadto[5] = (unsigned short )0;
     sqlstm.sqtdso[5] = (unsigned short )0;
     sqlstm.sqhstv[6] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[6] = (unsigned int  )5;
     sqlstm.sqhsts[6] = (         int  )0;
     sqlstm.sqindv[6] = (         void  *)0;
     sqlstm.sqinds[6] = (         int  )0;
     sqlstm.sqharm[6] = (unsigned int  )0;
     sqlstm.sqadto[6] = (unsigned short )0;
     sqlstm.sqtdso[6] = (unsigned short )0;
     sqlstm.sqhstv[7] = (         void  *)&nd_operating_facility_id;
     sqlstm.sqhstl[7] = (unsigned int  )5;
     sqlstm.sqhsts[7] = (         int  )0;
     sqlstm.sqindv[7] = (         void  *)0;
     sqlstm.sqinds[7] = (         int  )0;
     sqlstm.sqharm[7] = (unsigned int  )0;
     sqlstm.sqadto[7] = (unsigned short )0;
     sqlstm.sqtdso[7] = (unsigned short )0;
     sqlstm.sqhstv[8] = (         void  *)&nd_section_code;
     sqlstm.sqhstl[8] = (unsigned int  )4;
     sqlstm.sqhsts[8] = (         int  )0;
     sqlstm.sqindv[8] = (         void  *)0;
     sqlstm.sqinds[8] = (         int  )0;
     sqlstm.sqharm[8] = (unsigned int  )0;
     sqlstm.sqadto[8] = (unsigned short )0;
     sqlstm.sqtdso[8] = (unsigned short )0;
     sqlstm.sqhstv[9] = (         void  *)&nd_worklist_name;
     sqlstm.sqhstl[9] = (unsigned int  )13;
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

  

    }
   /*  Done in Do Report   */
   /*EXEC SQL WHENEVER SQLERROR GOTO err_exit;
     EXEC SQL OPEN SPECIMEN_CUR; */

#ifdef DEBUG
    printf("leaving dclr_specimen_cur()\n");
    fflush(stdout);
#endif
 
  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1066;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at dclr_specimen_cur() occured....\n");
   proc_exit();
}


/* prints the master-detail record until the cursor is empty */
void do_report()
{
  int fetch_specimen_cur();
  int fetch_worklist_dtl_cur();
  int fetch_qlty_tests_cur();
  int still_wrk_test_left;
  int still_specimen_left;
  int still_qc_left;
  int still_qlty_tests_left =0;
  int rec_no;
  int broken = 0;

       print_worklist();

}

/* function to check if all the mandatory tests exist in the specimen */
void check_mandatory_tests_exist()
{
  int w = 0;
  for(w=0;w<d_no_of_tests;w++)
  {
     if(worklist_ind[w][0] == 'M')
        if(mandatory_ind[w] != 'M')
	   mandatory_tests_exist = 0;
  } 
}
void check_if_any_test_pending()
{
  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  pending_tests = 0;
  /* EXEC SQL SELECT NVL(COUNT(*),0) INTO :pending_tests
	     FROM RL_TEST_RESULT
	    WHERE PATIENT_ID  = :d_patient_id    
	      AND SPECIMEN_NO = :d_specimen_no
	      AND OPERATING_FACILITY_ID = :nd_operating_facility_id
		  AND TEST_CODE IN (SELECT TEST_CODE
				  FROM RL_WORKLIST_FMT_DTL
				 WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
				 AND SECTION_CODE = :nd_section_code
				   AND WORKLIST_NAME = :nd_worklist_name
                               )
              AND NVL(STATUS,'O') IN('O','H'); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 74;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select NVL(count(*) ,0) into :b0  from RL_TEST_RESULT where\
 ((((PATIENT_ID=:b1 and SPECIMEN_NO=:b2) and OPERATING_FACILITY_ID=:b3) and TE\
ST_CODE in (select TEST_CODE  from RL_WORKLIST_FMT_DTL where ((OPERATING_FACIL\
ITY_ID=:b3 and SECTION_CODE=:b5) and WORKLIST_NAME=:b6))) and NVL(STATUS,'O') \
in ('O','H'))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1081;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&pending_tests;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
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
  sqlstm.sqhstv[2] = (         void  *)&d_specimen_no;
  sqlstm.sqhstl[2] = (unsigned int  )23;
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
  sqlstm.sqhstv[4] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[4] = (unsigned int  )5;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_section_code;
  sqlstm.sqhstl[5] = (unsigned int  )4;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_worklist_name;
  sqlstm.sqhstl[6] = (unsigned int  )13;
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


#ifdef DEBUG
  printf("p_id = %s sp_no = %s pending_tests = [%d] \n",
	 d_patient_id.arr,d_specimen_no.arr,pending_tests);getchar();
  return;
#endif
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1124;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at check_if_any_test_pending()...\n");
   proc_exit();
}
	 
/* function to print the worklist */
print_worklist()
{  
     int still_prt_specimen_left;
     void open_wrklst_prt_dtl_cur();
     void print_master_rec(FILE *);
     void print_col_heading(FILE *); 
     int fetch_specimen_prt_cur();
     void prepare_new_page(FILE *);
     void print_footer_rec(FILE *);
     void end_report(FILE *);                   
     void print_detl_rec();
	 void get_request_comment1();
	 void get_request_comment2();
	 void get_request_comment3();
	 void spacing(FILE *);
	 

     line_no = 0;
     if (rec_inserted == 0 || strcmp(rp_reprint.arr,"REPRINT")==0)
     {
       page_no +=1;
       no_of_tests = 0;
       if(strcmp(rp_reprint.arr,"REPRINT") == 0)
       {
             strcpy(nd_worklist_name.arr,rp_worklist_name.arr);
	     nd_worklist_name.len = strlen(rp_worklist_name.arr);
	     nd_worklist_no = rp_worklist_no;
	     strcpy(nd_worklist_date.arr,rp_worklist_date.arr);
	     nd_worklist_date.len = strlen(rp_worklist_date.arr);
       }
       open_wrklst_prt_dtl_cur();
       
       tests_on_page = 16;
       
       tests_on_page = 25;

		header_printed = 0;
		print_title();

		if (header_printed == 0)
		{
			prepare_heading(f1);
			header_printed++;
		}


        /*** newly added for kndv enhancements to get the maxmimum line no for header ***/
	    sorting();

		for (i=0;i<21;i++)
		{

			if (num[i] > 0)
				largest_row = num[i];
			else
				break;
	    }	  
       /*** upto here newly added for kndv enhancements to get the maxmimum line no for header ***/

		cup_type = '\0';

        still_prt_specimen_left = fetch_specimen_prt_cur();

        /* process until first level break group arises */
        while(still_prt_specimen_left) 
        {

         /***** newly added for KNDV EHNAHCEMENTS *****/
		 if (strcmp(d_print_cup_indicator.arr, "P") ==0)
		 {
			chk_break(largest_row);		
            
			/*****************
			if (header_printed == 0)
			{
				prepare_heading(f1);
				header_printed++;
			}
            ******************/

		    //	fprintf(f1, "\n");
		    //	line_no++;

			if (cup_type == 'Q')
			{
		 		fprint_repeat(f1, '_', 79);
				fprintf(f1, "\n");
				line_no++;
			}

			print_detl_rec();

			cup_type = 'P';
		 }
		 else
		 {
			if (cup_type == 'P')
			{
		 		fprint_repeat(f1, '_', 79);
				fprintf(f1, "\n");
				line_no++;
			}

			chk_break(4);
			print_quality_hdr();
			cup_type = 'Q';
		  }

          
          line_no += d_line_spacing;
		
 		  spacing(f1);

          still_prt_specimen_left = fetch_specimen_prt_cur();
       }

	}
	
}

/*This Procedure to open Quality Tests Cursor */
void open_qlty_tests_cur()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL OPEN QLTY_TESTS_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0027;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1139;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_section_code;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_qlty_code;
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


  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1166;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error while Opening qlty tests cur occured...\n");
   proc_exit();
}


/*This Procedure to open Worklist Cursor */
void open_wrklst_dtl_cursor()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL OPEN WORKLIST_DTL_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0023;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1181;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_section_code;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_worklist_name;
   sqlstm.sqhstl[2] = (unsigned int  )13;
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


   /* EXEC SQL SELECT NVL(COUNT(*),0) INTO :d_no_of_tests
	      FROM RL_WORKLIST_FMT_DTL
             WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
			 AND WORKLIST_NAME = :nd_worklist_name
			 AND SECTION_CODE = :nd_section_code ; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select NVL(count(*) ,0) into :b0  from RL_WORKLIST_FMT_DTL\
 where ((OPERATING_FACILITY_ID=:b1 and WORKLIST_NAME=:b2) and SECTION_CODE=:b3\
)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1208;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_no_of_tests;
   sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
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
   sqlstm.sqhstv[2] = (         void  *)&nd_worklist_name;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_section_code;
   sqlstm.sqhstl[3] = (unsigned int  )4;
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
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1239;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error while Opening work list dtl cur occured...\n");
   proc_exit();
}


/*This Procedure to open Specimen Cursor */ 
void open_specimen_cursor()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL OPEN SPECIMEN_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1254;
   sqlstm.selerr = (unsigned short)1;
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
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1269;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"oracle error while Opening Specimen Cur() occured....\n");
   proc_exit();
}

/*This Procedure to open Worklist Detail Printing Cursor */
void open_wrklst_prt_dtl_cur()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL OPEN WORKLIST_PRT_DTL_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = sq0025;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1284;
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
   sqlstm.sqhstv[1] = (         void  *)&nd_section_code;
   sqlstm.sqhstl[1] = (unsigned int  )4;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&nd_worklist_name;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&nd_worklist_no;
   sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&nd_worklist_date;
   sqlstm.sqhstl[4] = (unsigned int  )13;
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



  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1319;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error while Opening Wrklst prt dtl Cur() occured....\n");
   proc_exit();
}

/*This Procedure to Qlty Tests Cursor */
void close_qlty_tests_cur()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL CLOSE QLTY_TESTS_CUR; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1334;
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
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1349;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error while Close Qlty Tests Cur() occured....\n");
   proc_exit();
}

/* prepares for the new page */
void prepare_new_page(afp)
FILE *afp;
{
   fprintf(afp,"");
   line_no = 0;
}


/* fetches the next record from CUR  */
/* returns 0 if the end of cursor is reached */
/* else returns 1.                           */
int fetch_worklist_dtl_cur()
{

  d_worklist_test_code.arr[0]                                   = '\0';
  d_test_indicator.arr[0]                                       = '\0';
 
  d_worklist_test_code.len                                      = 0;
  d_test_indicator.len                                          = 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH WORKLIST_DTL_CUR INTO
		:d_worklist_test_code,  
		:d_seq_no ,             
		:d_test_indicator; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 74;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1364;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_worklist_test_code;
  sqlstm.sqhstl[0] = (unsigned int  )13;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_seq_no;
  sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_test_indicator;
  sqlstm.sqhstl[2] = (unsigned int  )4;
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



#ifdef DEBUG
         printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
#endif


  if (NODATAFOUND)
    return 0;


  d_worklist_test_code.arr[d_worklist_test_code .len]		= '\0';
  d_test_indicator.arr[d_test_indicator.len]			= '\0';


#ifdef DEBUG
   printf("********* Details from RL_WORKLIST_FMT_DTL**************\n");
   printf(" d_worklist_test_code= %s\n", d_worklist_test_code.arr);
   printf(" d_test_indicator= %s\n", d_test_indicator.arr);
#endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1391;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG, "Oracle error at fetch_wrklst_dtl_cur() occured....\n");
   proc_exit();

}

/* Function to fetch data from QLTY_TEST_CUR  */
int fetch_qlty_tests_cur()
{
  d_qlty_test.arr[0]                         = '\0';
  d_qlty_test.len                            = 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH QLTY_TESTS_CUR INTO
		:d_qlty_test; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 74;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1406;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_qlty_test;
  sqlstm.sqhstl[0] = (unsigned int  )13;
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




  if (NODATAFOUND)
    return 0;

  d_qlty_test.arr[d_qlty_test .len]	 		= '\0';

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
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


   disp_message(ORA_MESG,"Oracle error at fetch_qlty_test_cur() occured....\n");
   proc_exit();

}

/* fetches the next record from CUR  */
/* returns 0 if the end of cursor is reached */
/* else returns 1.                           */
int fetch_specimen_prt_cur()
{

 
  d_prt_cup_no.arr[0]				    = '\0';
  d_prt_cup_no.len						= 0;

  d_prt_specimen_no.arr[0]		 		= '\0';
  d_prt_patient_id.arr[0]		 		= '\0';

  d_prt_specimen_no.len		 			= 0;
  d_prt_patient_id.len                		    	= 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /*
    EXEC SQL FETCH WORKLIST_PRT_DTL_CUR INTO
	 	:d_prt_cup_no,       
		:d_prt_specimen_no,  
		:d_prt_patient_id,
		:d_print_cup_indicator,
		:d_prt_test_1_yn,
		:d_prt_test_2_yn,
		:d_prt_test_3_yn,
		:d_prt_test_4_yn,
		:d_prt_test_5_yn,
		:d_prt_test_6_yn,
		:d_prt_test_7_yn,
		:d_prt_test_8_yn,
		:d_prt_test_9_yn,
		:d_prt_test_10_yn,
		:d_prt_test_11_yn,
		:d_prt_test_12_yn,
		:d_prt_test_13_yn,
		:d_prt_test_14_yn,
		:d_prt_test_15_yn,
		:d_prt_test_16_yn,
		:d_prt_test_17_yn,
		:d_prt_test_18_yn,
		:d_prt_test_19_yn,
		:d_prt_test_20_yn,
		:d_prt_test_21_yn,
		:d_prt_test_22_yn,
		:d_prt_test_23_yn,
		:d_prt_test_24_yn,
		:d_prt_test_25_yn;
	*/

    /* EXEC SQL FETCH WORKLIST_PRT_DTL_CUR INTO
	 	:d_prt_cup_no,       
		:d_prt_specimen_no,  
		:d_prt_patient_id,
		:d_print_cup_indicator,
		:d_prt_test_1_yn,
		:d_prt_test_2_yn,
		:d_prt_test_3_yn,
		:d_prt_test_4_yn,
		:d_prt_test_5_yn,
		:d_prt_test_6_yn,
		:d_prt_test_7_yn,
		:d_prt_test_8_yn,
		:d_prt_test_9_yn,
		:d_prt_test_10_yn,
		:d_prt_test_11_yn,
		:d_prt_test_12_yn,
		:d_prt_test_13_yn,
		:d_prt_test_14_yn,
		:d_prt_test_15_yn,
		:d_prt_test_16_yn,
		:d_prt_test_17_yn,
		:d_prt_test_18_yn,
		:d_prt_test_19_yn,
		:d_prt_test_20_yn,
		:d_prt_test_21_yn,
		:d_prt_test_22_yn,
		:d_prt_test_23_yn,
		:d_prt_test_24_yn,
		:d_prt_test_25_yn,
		:d_qlty_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 74;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1440;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_prt_cup_no;
    sqlstm.sqhstl[0] = (unsigned int  )32;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_prt_specimen_no;
    sqlstm.sqhstl[1] = (unsigned int  )23;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_prt_patient_id;
    sqlstm.sqhstl[2] = (unsigned int  )33;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_print_cup_indicator;
    sqlstm.sqhstl[3] = (unsigned int  )4;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_prt_test_1_yn;
    sqlstm.sqhstl[4] = (unsigned int  )1;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_prt_test_2_yn;
    sqlstm.sqhstl[5] = (unsigned int  )1;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_prt_test_3_yn;
    sqlstm.sqhstl[6] = (unsigned int  )1;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_prt_test_4_yn;
    sqlstm.sqhstl[7] = (unsigned int  )1;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_prt_test_5_yn;
    sqlstm.sqhstl[8] = (unsigned int  )1;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_prt_test_6_yn;
    sqlstm.sqhstl[9] = (unsigned int  )1;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_prt_test_7_yn;
    sqlstm.sqhstl[10] = (unsigned int  )1;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&d_prt_test_8_yn;
    sqlstm.sqhstl[11] = (unsigned int  )1;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&d_prt_test_9_yn;
    sqlstm.sqhstl[12] = (unsigned int  )1;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&d_prt_test_10_yn;
    sqlstm.sqhstl[13] = (unsigned int  )1;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&d_prt_test_11_yn;
    sqlstm.sqhstl[14] = (unsigned int  )1;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&d_prt_test_12_yn;
    sqlstm.sqhstl[15] = (unsigned int  )1;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&d_prt_test_13_yn;
    sqlstm.sqhstl[16] = (unsigned int  )1;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&d_prt_test_14_yn;
    sqlstm.sqhstl[17] = (unsigned int  )1;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
    sqlstm.sqhstv[18] = (         void  *)&d_prt_test_15_yn;
    sqlstm.sqhstl[18] = (unsigned int  )1;
    sqlstm.sqhsts[18] = (         int  )0;
    sqlstm.sqindv[18] = (         void  *)0;
    sqlstm.sqinds[18] = (         int  )0;
    sqlstm.sqharm[18] = (unsigned int  )0;
    sqlstm.sqadto[18] = (unsigned short )0;
    sqlstm.sqtdso[18] = (unsigned short )0;
    sqlstm.sqhstv[19] = (         void  *)&d_prt_test_16_yn;
    sqlstm.sqhstl[19] = (unsigned int  )1;
    sqlstm.sqhsts[19] = (         int  )0;
    sqlstm.sqindv[19] = (         void  *)0;
    sqlstm.sqinds[19] = (         int  )0;
    sqlstm.sqharm[19] = (unsigned int  )0;
    sqlstm.sqadto[19] = (unsigned short )0;
    sqlstm.sqtdso[19] = (unsigned short )0;
    sqlstm.sqhstv[20] = (         void  *)&d_prt_test_17_yn;
    sqlstm.sqhstl[20] = (unsigned int  )1;
    sqlstm.sqhsts[20] = (         int  )0;
    sqlstm.sqindv[20] = (         void  *)0;
    sqlstm.sqinds[20] = (         int  )0;
    sqlstm.sqharm[20] = (unsigned int  )0;
    sqlstm.sqadto[20] = (unsigned short )0;
    sqlstm.sqtdso[20] = (unsigned short )0;
    sqlstm.sqhstv[21] = (         void  *)&d_prt_test_18_yn;
    sqlstm.sqhstl[21] = (unsigned int  )1;
    sqlstm.sqhsts[21] = (         int  )0;
    sqlstm.sqindv[21] = (         void  *)0;
    sqlstm.sqinds[21] = (         int  )0;
    sqlstm.sqharm[21] = (unsigned int  )0;
    sqlstm.sqadto[21] = (unsigned short )0;
    sqlstm.sqtdso[21] = (unsigned short )0;
    sqlstm.sqhstv[22] = (         void  *)&d_prt_test_19_yn;
    sqlstm.sqhstl[22] = (unsigned int  )1;
    sqlstm.sqhsts[22] = (         int  )0;
    sqlstm.sqindv[22] = (         void  *)0;
    sqlstm.sqinds[22] = (         int  )0;
    sqlstm.sqharm[22] = (unsigned int  )0;
    sqlstm.sqadto[22] = (unsigned short )0;
    sqlstm.sqtdso[22] = (unsigned short )0;
    sqlstm.sqhstv[23] = (         void  *)&d_prt_test_20_yn;
    sqlstm.sqhstl[23] = (unsigned int  )1;
    sqlstm.sqhsts[23] = (         int  )0;
    sqlstm.sqindv[23] = (         void  *)0;
    sqlstm.sqinds[23] = (         int  )0;
    sqlstm.sqharm[23] = (unsigned int  )0;
    sqlstm.sqadto[23] = (unsigned short )0;
    sqlstm.sqtdso[23] = (unsigned short )0;
    sqlstm.sqhstv[24] = (         void  *)&d_prt_test_21_yn;
    sqlstm.sqhstl[24] = (unsigned int  )1;
    sqlstm.sqhsts[24] = (         int  )0;
    sqlstm.sqindv[24] = (         void  *)0;
    sqlstm.sqinds[24] = (         int  )0;
    sqlstm.sqharm[24] = (unsigned int  )0;
    sqlstm.sqadto[24] = (unsigned short )0;
    sqlstm.sqtdso[24] = (unsigned short )0;
    sqlstm.sqhstv[25] = (         void  *)&d_prt_test_22_yn;
    sqlstm.sqhstl[25] = (unsigned int  )1;
    sqlstm.sqhsts[25] = (         int  )0;
    sqlstm.sqindv[25] = (         void  *)0;
    sqlstm.sqinds[25] = (         int  )0;
    sqlstm.sqharm[25] = (unsigned int  )0;
    sqlstm.sqadto[25] = (unsigned short )0;
    sqlstm.sqtdso[25] = (unsigned short )0;
    sqlstm.sqhstv[26] = (         void  *)&d_prt_test_23_yn;
    sqlstm.sqhstl[26] = (unsigned int  )1;
    sqlstm.sqhsts[26] = (         int  )0;
    sqlstm.sqindv[26] = (         void  *)0;
    sqlstm.sqinds[26] = (         int  )0;
    sqlstm.sqharm[26] = (unsigned int  )0;
    sqlstm.sqadto[26] = (unsigned short )0;
    sqlstm.sqtdso[26] = (unsigned short )0;
    sqlstm.sqhstv[27] = (         void  *)&d_prt_test_24_yn;
    sqlstm.sqhstl[27] = (unsigned int  )1;
    sqlstm.sqhsts[27] = (         int  )0;
    sqlstm.sqindv[27] = (         void  *)0;
    sqlstm.sqinds[27] = (         int  )0;
    sqlstm.sqharm[27] = (unsigned int  )0;
    sqlstm.sqadto[27] = (unsigned short )0;
    sqlstm.sqtdso[27] = (unsigned short )0;
    sqlstm.sqhstv[28] = (         void  *)&d_prt_test_25_yn;
    sqlstm.sqhstl[28] = (unsigned int  )1;
    sqlstm.sqhsts[28] = (         int  )0;
    sqlstm.sqindv[28] = (         void  *)0;
    sqlstm.sqinds[28] = (         int  )0;
    sqlstm.sqharm[28] = (unsigned int  )0;
    sqlstm.sqadto[28] = (unsigned short )0;
    sqlstm.sqtdso[28] = (unsigned short )0;
    sqlstm.sqhstv[29] = (         void  *)&d_qlty_code;
    sqlstm.sqhstl[29] = (unsigned int  )7;
    sqlstm.sqhsts[29] = (         int  )0;
    sqlstm.sqindv[29] = (         void  *)0;
    sqlstm.sqinds[29] = (         int  )0;
    sqlstm.sqharm[29] = (unsigned int  )0;
    sqlstm.sqadto[29] = (unsigned short )0;
    sqlstm.sqtdso[29] = (unsigned short )0;
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
         printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
#endif


  if (NODATAFOUND)
    return 0;


  d_prt_specimen_no.arr[d_prt_specimen_no.len]			= '\0';
  d_prt_patient_id.arr[d_prt_patient_id.len]			= '\0';
  d_print_cup_indicator.arr[d_print_cup_indicator.len]          = '\0';
  d_prt_cup_no.arr[d_prt_cup_no.len]					= '\0';


  strcpy(d_pat_mark.arr,"");
  if(d_print_cup_indicator.arr[0] == 'P')
     get_patient_marker();

#ifdef DEBUG 
   printf("********* Details from RL_WORKLIST_DTL******************\n");
   printf(" d_prt_cup_no        = %d\n",d_prt_cup_no);
   printf(" d_prt_specimen_no   = <%s>\n",d_prt_specimen_no.arr);
   printf(" d_prt_patient_id    = %s\n",d_prt_patient_id.arr);
   printf(" d_prt_test_1_yn     = %c\n",d_prt_test_1_yn);
   printf(" d_prt_test_2_yn     = %c\n",d_prt_test_2_yn);
   printf(" d_prt_test_3_yn     = %c\n",d_prt_test_3_yn);
   printf(" d_prt_test_4_yn     = %c\n",d_prt_test_4_yn);
   printf(" d_prt_test_5_yn     = %c\n",d_prt_test_5_yn);
   printf(" d_prt_test_6_yn     = %c\n",d_prt_test_6_yn);
   printf(" d_prt_test_7_yn     = %c\n",d_prt_test_7_yn);
   printf(" d_prt_test_8_yn     = %c\n",d_prt_test_8_yn);
   printf(" d_prt_test_9_yn     = %c\n",d_prt_test_9_yn);
   printf(" d_prt_test_10_yn     = %c\n",d_prt_test_10_yn);
   printf(" d_prt_test_11_yn     = %c\n",d_prt_test_11_yn);
   printf(" d_prt_test_12_yn     = %c\n",d_prt_test_12_yn);
   printf(" d_prt_test_13_yn     = %c\n",d_prt_test_13_yn);
   printf(" d_prt_test_14_yn     = %c\n",d_prt_test_14_yn);
   printf(" d_prt_test_15_yn     = %c\n",d_prt_test_15_yn);
   printf(" d_prt_test_16_yn     = %c\n",d_prt_test_16_yn);
   printf(" d_prt_test_17_yn     = %c\n",d_prt_test_17_yn);
   printf(" d_prt_test_18_yn     = %c\n",d_prt_test_18_yn);
   printf(" d_prt_test_19_yn     = %c\n",d_prt_test_19_yn);
   printf(" d_prt_test_20_yn     = %c\n",d_prt_test_20_yn);
   printf(" d_prt_test_21_yn     = %c\n",d_prt_test_21_yn);
   printf(" d_prt_test_22_yn     = %c\n",d_prt_test_22_yn);
   printf(" d_prt_test_23_yn     = %c\n",d_prt_test_23_yn);
   printf(" d_prt_test_24_yn     = %c\n",d_prt_test_24_yn);
   printf(" d_prt_test_25_yn     = %c\n",d_prt_test_25_yn);
#endif

#ifdef DEBUG
   printf("********* Details from RL_WORKLIST_DTL******************\n");
   printf(" length of specimen  = %d\n",d_prt_specimen_no.len);
#endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1575;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_prt_specimen_cur() occured....\n");
   proc_exit();

}



/* to initialize worklist array with some default value */
void initialize_worklist_array()
{
  int    i;

  for (i=0;i<25;i++)
  {
    strcpy(worklist_test[i], "     ");
    strcpy(worklist_ind[i]," ");
    chk_mand_test[i]=' ';
  }

}


/* to copy the worklist test indicators array to some dummy array     */
/* before checking whether all tests is there in specimen     */
void copy_dummy_array()                 
{
  int    i;

  for (i=0;i<d_no_of_tests;i++)
  {
    /*dummy_test_array[i]=chk_mand_test[i]; */
    mandatory_ind[i] = ' ';
    dummy_test_array[i]='N';
  }

}


/* to Check specimen test exist in worklist test */            
/* If it exist then updates intermediary array with 'Y' in the respective */
/* position    */
void check_test_exist()
{
  int    w;

  for (w=0;w<d_no_of_tests;w++)
  {


    if (strcmp(worklist_test[w], nd_chk_test_code.arr) == 0)
    {
      mandatory_ind[w] = 'M'; 
      test_exists_in_specimen = 1;
      dummy_test_array[w] = 'Y';
      break;
    }
  }



}



/* INSERT RL_WORKLIST_DTL */
void insert_worklist_data()    
{
  void update_worklist_fmt_hdr()    ;
  void insert_worklist_hdr()    ;
  cup_ind=cup_indicator[ic];
  if (rec_inserted == 1)
  {
     insert_worklist_hdr();
     update_worklist_fmt_hdr() ;
     rec_inserted=0;
  }
  cup_no++;
  
  /* EXEC SQL WHENEVER SQLERROR GO TO err_exit; */ 

  /* EXEC SQL INSERT INTO RL_WORKLIST_DTL         
	   (OPERATING_FACILITY_ID,
	    SECTION_CODE,
	    WORKLIST_NAME,
	    WORKLIST_NO,
	    WORKLIST_DATE,           
	    WORKLIST_CUP_NO,
	    WORKLIST_CUP_INDICATOR,
	    PATIENT_ID,
	    SPECIMEN_NO,
	    TEST_1_YN,
	    TEST_2_YN,
	    TEST_3_YN,
	    TEST_4_YN,
	    TEST_5_YN,
	    TEST_6_YN,
	    TEST_7_YN,
	    TEST_8_YN,
	    TEST_9_YN,
	    TEST_10_YN,
	    TEST_11_YN,
	    TEST_12_YN,
	    TEST_13_YN,
	    TEST_14_YN,
	    TEST_15_YN,
	    TEST_16_YN,
	    TEST_17_YN,
	    TEST_18_YN,
	    TEST_19_YN,
	    TEST_20_YN,
	    TEST_21_YN,
	    TEST_22_YN,
	    TEST_23_YN,
	    TEST_24_YN,
	    TEST_25_YN) 
	   VALUES 
	   (:nd_operating_facility_id,
	    :nd_section_code,
	    :nd_worklist_name,
	    :nd_worklist_no,
	    TO_DATE(:nd_worklist_date,'DD/MM/YYYY'),
	    :cup_no,
	    :cup_ind,
	    :nd_ins_patient_id,
	    TO_NUMBER(:nd_ins_specimen_no),
	    substr(:dummy_test_array,1,1),
	    substr(:dummy_test_array,2,1),
	    substr(:dummy_test_array,3,1),
	    substr(:dummy_test_array,4,1),
        substr(:dummy_test_array,5,1),
	    substr(:dummy_test_array,6,1),
	    substr(:dummy_test_array,7,1),
	    substr(:dummy_test_array,8,1),
	    substr(:dummy_test_array,9,1),
	    substr(:dummy_test_array,10,1),
	    substr(:dummy_test_array,11,1),
	    substr(:dummy_test_array,12,1),
	    substr(:dummy_test_array,13,1),
	    substr(:dummy_test_array,14,1),
	    substr(:dummy_test_array,15,1),
	    substr(:dummy_test_array,16,1),
	    substr(:dummy_test_array,17,1),
	    substr(:dummy_test_array,18,1),
	    substr(:dummy_test_array,19,1),
	    substr(:dummy_test_array,20,1),
	    substr(:dummy_test_array,21,1),
	    substr(:dummy_test_array,22,1),
	    substr(:dummy_test_array,23,1),
	    substr(:dummy_test_array,24,1),
	    substr(:dummy_test_array,25,1)
	    ) ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 74;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "insert into RL_WORKLIST_DTL (OPERATING_FACILITY_ID,SECTION_\
CODE,WORKLIST_NAME,WORKLIST_NO,WORKLIST_DATE,WORKLIST_CUP_NO,WORKLIST_CUP_INDI\
CATOR,PATIENT_ID,SPECIMEN_NO,TEST_1_YN,TEST_2_YN,TEST_3_YN,TEST_4_YN,TEST_5_YN\
,TEST_6_YN,TEST_7_YN,TEST_8_YN,TEST_9_YN,TEST_10_YN,TEST_11_YN,TEST_12_YN,TEST\
_13_YN,TEST_14_YN,TEST_15_YN,TEST_16_YN,TEST_17_YN,TEST_18_YN,TEST_19_YN,TEST_\
20_YN,TEST_21_YN,TEST_22_YN,TEST_23_YN,TEST_24_YN,TEST_25_YN) values (:b0,:b1,\
:b2,:b3,TO_DATE(:b4,'DD/MM/YYYY'),:b5,:b6,:b7,TO_NUMBER(:b8),substr(:b9,1,1),s\
ubstr(:b9,2,1),substr(:b9,3,1),substr(:b9,4,1),substr(:b9,5,1),substr(:b9,6,1)\
,substr(:b9,7,1),substr(:b9,8,1),substr(:b9,9,1),substr(:b9,10,1),substr(:b9,1\
1,1),substr(:b9,12,1),substr(:b9,13,1),substr(:b9,14,1),substr(:b9,15,1),subst\
r(:b9,16,1),substr(:b9,17,1),substr(:b9,18,1),substr(:b9,19,1),substr(:b9,20,1\
),substr(:b9,21,1),substr(:b9,22,1),substr(:b9,23,1),substr(:b9,24,1),substr(:\
b9,25,1))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1590;
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
  sqlstm.sqhstv[1] = (         void  *)&nd_section_code;
  sqlstm.sqhstl[1] = (unsigned int  )4;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_worklist_name;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_worklist_no;
  sqlstm.sqhstl[3] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_worklist_date;
  sqlstm.sqhstl[4] = (unsigned int  )13;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&cup_no;
  sqlstm.sqhstl[5] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&cup_ind;
  sqlstm.sqhstl[6] = (unsigned int  )1;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_ins_patient_id;
  sqlstm.sqhstl[7] = (unsigned int  )33;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_ins_specimen_no;
  sqlstm.sqhstl[8] = (unsigned int  )23;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[9] = (unsigned int  )25;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[10] = (unsigned int  )25;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[11] = (unsigned int  )25;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[12] = (unsigned int  )25;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[13] = (unsigned int  )25;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
  sqlstm.sqhstv[14] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[14] = (unsigned int  )25;
  sqlstm.sqhsts[14] = (         int  )0;
  sqlstm.sqindv[14] = (         void  *)0;
  sqlstm.sqinds[14] = (         int  )0;
  sqlstm.sqharm[14] = (unsigned int  )0;
  sqlstm.sqadto[14] = (unsigned short )0;
  sqlstm.sqtdso[14] = (unsigned short )0;
  sqlstm.sqhstv[15] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[15] = (unsigned int  )25;
  sqlstm.sqhsts[15] = (         int  )0;
  sqlstm.sqindv[15] = (         void  *)0;
  sqlstm.sqinds[15] = (         int  )0;
  sqlstm.sqharm[15] = (unsigned int  )0;
  sqlstm.sqadto[15] = (unsigned short )0;
  sqlstm.sqtdso[15] = (unsigned short )0;
  sqlstm.sqhstv[16] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[16] = (unsigned int  )25;
  sqlstm.sqhsts[16] = (         int  )0;
  sqlstm.sqindv[16] = (         void  *)0;
  sqlstm.sqinds[16] = (         int  )0;
  sqlstm.sqharm[16] = (unsigned int  )0;
  sqlstm.sqadto[16] = (unsigned short )0;
  sqlstm.sqtdso[16] = (unsigned short )0;
  sqlstm.sqhstv[17] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[17] = (unsigned int  )25;
  sqlstm.sqhsts[17] = (         int  )0;
  sqlstm.sqindv[17] = (         void  *)0;
  sqlstm.sqinds[17] = (         int  )0;
  sqlstm.sqharm[17] = (unsigned int  )0;
  sqlstm.sqadto[17] = (unsigned short )0;
  sqlstm.sqtdso[17] = (unsigned short )0;
  sqlstm.sqhstv[18] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[18] = (unsigned int  )25;
  sqlstm.sqhsts[18] = (         int  )0;
  sqlstm.sqindv[18] = (         void  *)0;
  sqlstm.sqinds[18] = (         int  )0;
  sqlstm.sqharm[18] = (unsigned int  )0;
  sqlstm.sqadto[18] = (unsigned short )0;
  sqlstm.sqtdso[18] = (unsigned short )0;
  sqlstm.sqhstv[19] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[19] = (unsigned int  )25;
  sqlstm.sqhsts[19] = (         int  )0;
  sqlstm.sqindv[19] = (         void  *)0;
  sqlstm.sqinds[19] = (         int  )0;
  sqlstm.sqharm[19] = (unsigned int  )0;
  sqlstm.sqadto[19] = (unsigned short )0;
  sqlstm.sqtdso[19] = (unsigned short )0;
  sqlstm.sqhstv[20] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[20] = (unsigned int  )25;
  sqlstm.sqhsts[20] = (         int  )0;
  sqlstm.sqindv[20] = (         void  *)0;
  sqlstm.sqinds[20] = (         int  )0;
  sqlstm.sqharm[20] = (unsigned int  )0;
  sqlstm.sqadto[20] = (unsigned short )0;
  sqlstm.sqtdso[20] = (unsigned short )0;
  sqlstm.sqhstv[21] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[21] = (unsigned int  )25;
  sqlstm.sqhsts[21] = (         int  )0;
  sqlstm.sqindv[21] = (         void  *)0;
  sqlstm.sqinds[21] = (         int  )0;
  sqlstm.sqharm[21] = (unsigned int  )0;
  sqlstm.sqadto[21] = (unsigned short )0;
  sqlstm.sqtdso[21] = (unsigned short )0;
  sqlstm.sqhstv[22] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[22] = (unsigned int  )25;
  sqlstm.sqhsts[22] = (         int  )0;
  sqlstm.sqindv[22] = (         void  *)0;
  sqlstm.sqinds[22] = (         int  )0;
  sqlstm.sqharm[22] = (unsigned int  )0;
  sqlstm.sqadto[22] = (unsigned short )0;
  sqlstm.sqtdso[22] = (unsigned short )0;
  sqlstm.sqhstv[23] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[23] = (unsigned int  )25;
  sqlstm.sqhsts[23] = (         int  )0;
  sqlstm.sqindv[23] = (         void  *)0;
  sqlstm.sqinds[23] = (         int  )0;
  sqlstm.sqharm[23] = (unsigned int  )0;
  sqlstm.sqadto[23] = (unsigned short )0;
  sqlstm.sqtdso[23] = (unsigned short )0;
  sqlstm.sqhstv[24] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[24] = (unsigned int  )25;
  sqlstm.sqhsts[24] = (         int  )0;
  sqlstm.sqindv[24] = (         void  *)0;
  sqlstm.sqinds[24] = (         int  )0;
  sqlstm.sqharm[24] = (unsigned int  )0;
  sqlstm.sqadto[24] = (unsigned short )0;
  sqlstm.sqtdso[24] = (unsigned short )0;
  sqlstm.sqhstv[25] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[25] = (unsigned int  )25;
  sqlstm.sqhsts[25] = (         int  )0;
  sqlstm.sqindv[25] = (         void  *)0;
  sqlstm.sqinds[25] = (         int  )0;
  sqlstm.sqharm[25] = (unsigned int  )0;
  sqlstm.sqadto[25] = (unsigned short )0;
  sqlstm.sqtdso[25] = (unsigned short )0;
  sqlstm.sqhstv[26] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[26] = (unsigned int  )25;
  sqlstm.sqhsts[26] = (         int  )0;
  sqlstm.sqindv[26] = (         void  *)0;
  sqlstm.sqinds[26] = (         int  )0;
  sqlstm.sqharm[26] = (unsigned int  )0;
  sqlstm.sqadto[26] = (unsigned short )0;
  sqlstm.sqtdso[26] = (unsigned short )0;
  sqlstm.sqhstv[27] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[27] = (unsigned int  )25;
  sqlstm.sqhsts[27] = (         int  )0;
  sqlstm.sqindv[27] = (         void  *)0;
  sqlstm.sqinds[27] = (         int  )0;
  sqlstm.sqharm[27] = (unsigned int  )0;
  sqlstm.sqadto[27] = (unsigned short )0;
  sqlstm.sqtdso[27] = (unsigned short )0;
  sqlstm.sqhstv[28] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[28] = (unsigned int  )25;
  sqlstm.sqhsts[28] = (         int  )0;
  sqlstm.sqindv[28] = (         void  *)0;
  sqlstm.sqinds[28] = (         int  )0;
  sqlstm.sqharm[28] = (unsigned int  )0;
  sqlstm.sqadto[28] = (unsigned short )0;
  sqlstm.sqtdso[28] = (unsigned short )0;
  sqlstm.sqhstv[29] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[29] = (unsigned int  )25;
  sqlstm.sqhsts[29] = (         int  )0;
  sqlstm.sqindv[29] = (         void  *)0;
  sqlstm.sqinds[29] = (         int  )0;
  sqlstm.sqharm[29] = (unsigned int  )0;
  sqlstm.sqadto[29] = (unsigned short )0;
  sqlstm.sqtdso[29] = (unsigned short )0;
  sqlstm.sqhstv[30] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[30] = (unsigned int  )25;
  sqlstm.sqhsts[30] = (         int  )0;
  sqlstm.sqindv[30] = (         void  *)0;
  sqlstm.sqinds[30] = (         int  )0;
  sqlstm.sqharm[30] = (unsigned int  )0;
  sqlstm.sqadto[30] = (unsigned short )0;
  sqlstm.sqtdso[30] = (unsigned short )0;
  sqlstm.sqhstv[31] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[31] = (unsigned int  )25;
  sqlstm.sqhsts[31] = (         int  )0;
  sqlstm.sqindv[31] = (         void  *)0;
  sqlstm.sqinds[31] = (         int  )0;
  sqlstm.sqharm[31] = (unsigned int  )0;
  sqlstm.sqadto[31] = (unsigned short )0;
  sqlstm.sqtdso[31] = (unsigned short )0;
  sqlstm.sqhstv[32] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[32] = (unsigned int  )25;
  sqlstm.sqhsts[32] = (         int  )0;
  sqlstm.sqindv[32] = (         void  *)0;
  sqlstm.sqinds[32] = (         int  )0;
  sqlstm.sqharm[32] = (unsigned int  )0;
  sqlstm.sqadto[32] = (unsigned short )0;
  sqlstm.sqtdso[32] = (unsigned short )0;
  sqlstm.sqhstv[33] = (         void  *)dummy_test_array;
  sqlstm.sqhstl[33] = (unsigned int  )25;
  sqlstm.sqhsts[33] = (         int  )0;
  sqlstm.sqindv[33] = (         void  *)0;
  sqlstm.sqinds[33] = (         int  )0;
  sqlstm.sqharm[33] = (unsigned int  )0;
  sqlstm.sqadto[33] = (unsigned short )0;
  sqlstm.sqtdso[33] = (unsigned short )0;
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
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1741;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at Insert Worklist Detail occured....\n");
   proc_exit();

}

/* INSERT RL_WORKLIST_HDR */
void insert_worklist_hdr()    
{
  /* EXEC SQL WHENEVER SQLERROR GO TO err_exit; */ 

  /* EXEC SQL INSERT INTO RL_WORKLIST_HDR         
	   (OPERATING_FACILITY_ID,
	    WORKLIST_NAME,
	    WORKLIST_NO,
	    SECTION_CODE,   
	    WORKLIST_DATE,
		ASSIGN_TO,           
	    ADDED_BY_ID,
	    MODIFIED_BY_ID,
	    ADDED_DATE,
	    MODIFIED_DATE,
		ADDED_AT_WS_NO,
        ADDED_FACILITY_ID,
        MODIFIED_AT_WS_NO,
        MODIFIED_FACILITY_ID) 
	   VALUES 
	   (:nd_operating_facility_id,
	    :nd_worklist_name,
	    :nd_worklist_no,
	    :nd_section_code,
	    TO_DATE(:nd_worklist_date,'DD/MM/YYYY'),
		:rp_assign_to,
	    user,
	    user,
	    SYSDATE,
	    SYSDATE,
		sys_context('USERENV','IP_ADDRESS'),
		:nd_operating_facility_id,
		sys_context('USERENV','IP_ADDRESS'),
		:nd_operating_facility_id
	    ) ; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 74;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "insert into RL_WORKLIST_HDR (OPERATING_FACILITY_ID,WORKLIST\
_NAME,WORKLIST_NO,SECTION_CODE,WORKLIST_DATE,ASSIGN_TO,ADDED_BY_ID,MODIFIED_BY\
_ID,ADDED_DATE,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS_N\
O,MODIFIED_FACILITY_ID) values (:b0,:b1,:b2,:b3,TO_DATE(:b4,'DD/MM/YYYY'),:b5,\
user,user,SYSDATE,SYSDATE,sys_context('USERENV','IP_ADDRESS'),:b0,sys_context(\
'USERENV','IP_ADDRESS'),:b0)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1756;
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
  sqlstm.sqhstv[1] = (         void  *)&nd_worklist_name;
  sqlstm.sqhstl[1] = (unsigned int  )13;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&nd_worklist_no;
  sqlstm.sqhstl[2] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_section_code;
  sqlstm.sqhstl[3] = (unsigned int  )4;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&nd_worklist_date;
  sqlstm.sqhstl[4] = (unsigned int  )13;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&rp_assign_to;
  sqlstm.sqhstl[5] = (unsigned int  )33;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[6] = (unsigned int  )5;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_operating_facility_id;
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
  if (sqlca.sqlcode < 0) goto err_exit;
}


  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1803;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at Insert Worlist HDR occured....\n");
   proc_exit();
}


update_last_spec_no()
{
 
  /* EXEC SQL SELECT rowid INTO :rowid_wrk  
           FROM RL_WORKLIST_FMT_HDR                 
	       WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
	       AND WORKLIST_NAME  = :nd_worklist_name
	       AND SECTION_CODE   = :nd_section_code
           FOR UPDATE OF LAST_NUMBER_USED NOWAIT; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 74;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select rowid into :b0  from RL_WORKLIST_FMT_HDR where ((OPE\
RATING_FACILITY_ID=:b1 and WORKLIST_NAME=:b2) and SECTION_CODE=:b3) for update\
 of LAST_NUMBER_USED nowait ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1818;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&rowid_wrk;
  sqlstm.sqhstl[0] = (unsigned int  )33;
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
  sqlstm.sqhstv[2] = (         void  *)&nd_worklist_name;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_section_code;
  sqlstm.sqhstl[3] = (unsigned int  )4;
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
}



    /* EXEC SQL UPDATE RL_WORKLIST_FMT_HDR         
	 	     SET LAST_SPECIMEN_NO = TO_NUMBER(:nd_specimen_no)
             WHERE rowid = :rowid_wrk; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 74;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "update RL_WORKLIST_FMT_HDR  set LAST_SPECIMEN_NO=TO_NUMBE\
R(:b0) where rowid=:b1";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1849;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&nd_specimen_no;
    sqlstm.sqhstl[0] = (unsigned int  )23;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&rowid_wrk;
    sqlstm.sqhstl[1] = (unsigned int  )33;
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



}


/* UPDATE RL_WORKLIST_FMT_HDR */
void update_worklist_fmt_hdr()    
{
 
  /* EXEC SQL SELECT rowid INTO :rowid_wrk  
           FROM RL_WORKLIST_FMT_HDR                 
	   WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
	   AND WORKLIST_NAME        = :nd_worklist_name        
	   AND SECTION_CODE         = :nd_section_code 
           FOR UPDATE OF LAST_NUMBER_USED NOWAIT; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 74;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select rowid into :b0  from RL_WORKLIST_FMT_HDR where ((OPE\
RATING_FACILITY_ID=:b1 and WORKLIST_NAME=:b2) and SECTION_CODE=:b3) for update\
 of LAST_NUMBER_USED nowait ";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1872;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&rowid_wrk;
  sqlstm.sqhstl[0] = (unsigned int  )33;
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
  sqlstm.sqhstv[2] = (         void  *)&nd_worklist_name;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&nd_section_code;
  sqlstm.sqhstl[3] = (unsigned int  )4;
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
}



  /* EXEC SQL WHENEVER SQLERROR GO TO err_exit; */ 

  /* EXEC SQL UPDATE RL_WORKLIST_FMT_HDR         
	   SET LAST_NUMBER_USED = :nd_worklist_no,
		   LAST_SPECIMEN_NO = TO_NUMBER(:nd_specimen_no),
	       MODIFIED_BY_ID   = user,
	       MODIFIED_DATE    = SYSDATE 
           WHERE rowid = :rowid_wrk; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 74;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "update RL_WORKLIST_FMT_HDR  set LAST_NUMBER_USED=:b0,LAST_S\
PECIMEN_NO=TO_NUMBER(:b1),MODIFIED_BY_ID=user,MODIFIED_DATE=SYSDATE where rowi\
d=:b2";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )1903;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_worklist_no;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&nd_specimen_no;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&rowid_wrk;
  sqlstm.sqhstl[2] = (unsigned int  )33;
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



  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1930;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at UPDATE Worlist FMT HDR occured....\n");
   proc_exit();

}

/* print the master record */
void print_master_rec(afp)
FILE *afp;
{
  int get_col_length(int col_no);
  int    i;
  int    j;
  char l_str[2];
  fprintf(afp,"\n");
  //fprintf(afp,"%-10s WORKLIST",nd_worklist_name.arr);
  fprintf(afp,".%-10s %-8.8s",nd_worklist_name.arr,local_legend[2]);
  fprintf(afp,"\n");
  //fprintf(afp,"WORKLIST NUMBER : %-5d   ", nd_worklist_no);
  fprintf(afp,"%-15.15s : %-5d   ", local_legend[3],nd_worklist_no);
  //fprintf(afp,"DATE : %-10s        ", nd_worklist_date.arr);
	fprintf(afp,"%-4.4s : %-10s        ",local_legend[4], nd_worklist_date.arr);
  d_added_date.arr[0]		= '\0';
  d_added_date.len			= 0;
  d_added_time.arr[0]		= '\0';
  d_added_time.len			= 0;
  d_added_by_id.arr[0]		= '\0';
  d_added_by_id.len			= 0;
  d_curr_date.arr[0]		= '\0';
  d_curr_date.len			= 0;
  d_curr_time.arr[0]		= '\0';
  d_curr_time.len			= 0;

  /* EXEC SQL WHENEVER SQLERROR GO TO err_exit; */ 

  /*******
  EXEC SQL SELECT ADDED_BY_ID, TO_CHAR(added_date, 'DD/MM/YYYY'),
				TO_CHAR(added_time, 'HH24:MI'), TO_CHAR(SYSDATE, 'DD/MM/YYYY'), 
				TO_CHAR(SYSDATE, 'HH24:MI')
		   INTO :d_added_by_id, :d_added_date, :d_added_time,
				:d_curr_date, :d_curr_time	
	       FROM RL_WORKLIST_HDR
           WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
		   AND SECTION_CODE  = :nd_section_code 
	       AND WORKLIST_NAME = :nd_worklist_name
	       AND WORKLIST_NO   = :nd_worklist_no
	       AND TRUNC(WORKLIST_DATE) = TO_DATE(:nd_worklist_date,'DD/MM/YYYY');
*********/
  d_added_by_id.arr[d_added_by_id.len]  = '\0';
  d_added_date.arr[d_added_date.len]	= '\0';
  d_added_time.arr[d_added_time.len]	= '\0';
  d_curr_date.arr[d_curr_date.len]		= '\0';
  d_curr_time.arr[d_curr_time.len]		= '\0';

  //fprintf(afp,"CREATED BY : %-20s ", d_added_by_id.arr);
  fprintf(afp,"%-10.10s : %-20s ", local_legend[5],d_added_by_id.arr);

  if(strcmp(rp_reprint.arr,"REPRINT") == 0)
     //fprintf(afp,"REPRINTED ON : %-10s",d_sysdate.arr);
	 fprintf(afp,"%-12.12s : %-10s",local_legend[6],d_sysdate.arr);

  else
     //fprintf(afp,"  PRINTED ON : %-10s",d_sysdate.arr);
     fprintf(afp,"  %-10.10s : %-10s",local_legend[7],d_sysdate.arr);
  fprintf(afp," ");
  fprintf(afp,"%-4.4s : %4d",local_legend[1], page_no);               
  fprintf(afp,"\n\n");
  line_no += 12;
  i = no_of_tests;

sorting();
j = 21;
while(j >= 0)
{
	
	if (num[j] == 1)
	{
	    tests = 0;
		tests = cou[j];
		tot_tests = get_col_length(j);
		tests = tests + tot_tests + 1;
		break;
	
	}

	j--;

}



  for (j=0;j<10;j++)
  {
	
    fprintf(afp, "%*.*s", tests, tests, "");

    for (no_of_tests = i ; no_of_tests < tests_on_page ; no_of_tests++)
    {
      sprintf(l_str,"%c",worklist_test[no_of_tests][j]);
      fprintf(afp,"%1s     ",l_str);
    }
    fprintf(afp,"\n");

  }

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )1945;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at print_master_rec() occured....\n");
   proc_exit();
}

/******** GETTING COLUMN LENGTH   ********/
int get_col_length(col_no)
int col_no ;
{

 int str_len = 0;
 
 if (strcmp(str_word[col_no],"nd_cup_number") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 3)
   	   return str_len;
	else 
	   return 3 ;
 }
 else if (strcmp(str_word[col_no],"nd_cup_indr") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 1)
   	   return str_len;
	else 
	   return 1 ;
 }
 else if (strcmp(str_word[col_no],"nd_wl_marker") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 1)
   	   return str_len;
	else 
	   return 1 ;
 }
 
 else if (strcmp(str_word[col_no],"nd_spec_no") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 9)
   	   return str_len;
	else 
	   return 9 ;
 }
 else if (strcmp(str_word[col_no],"nd_pat_id") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 30)
   	   return str_len;
	else 
	   return 30 ;
 }
 else if (strcmp(str_word[col_no],"nd_pat_name") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 30)
   	   return str_len;
	else 
	   return 30 ;
 }
 else if (strcmp(str_word[col_no],"nd_age") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 9)
   	   return str_len;
	else 
	   return 9 ;
 }
 else if (strcmp(str_word[col_no],"nd_dob") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 10)
   	   return str_len;
	else 
	   return 10 ;
 }
 else if (strcmp(str_word[col_no],"nd_sex") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 1)
   	   return str_len;
	else 
	   return 1 ;
 }
 else if (strcmp(str_word[col_no],"nd_source") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 4)
   	   return str_len;
	else 
	   return 4 ;
 }
 else if (strcmp(str_word[col_no],"nd_consultant") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 6)
   	   return str_len;
	else 
	   return 6 ;
 }
 else if (strcmp(str_word[col_no],"nd_urgency") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 1)
   	   return str_len;
	else 
	   return 1 ;
 }
 else if (strcmp(str_word[col_no],"nd_comm_1") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 40)
   	   return str_len;
	else 
	   return 40 ;
 }
 else if (strcmp(str_word[col_no],"nd_comm_2") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 40)
   	   return str_len;
	else 
	   return 40 ;
 }
 else if (strcmp(str_word[col_no],"nd_comm_3") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 40)
   	   return str_len;
	else 
	   return 40 ;
 }
 else if (strcmp(str_word[col_no],"nd_spec_date") == 0)
 {
    str_len = strlen(word[col_no]);
    if (str_len > 19)
   	   return str_len;
	else 
	   return 19 ;
 }
 /***added **/
 else if (strcmp(str_word[col_no],"nd_assign_to") == 0)
  {
    str_len = strlen(word[col_no]);
    if (str_len > 20)
   	   return str_len;
	else 
	   return 20 ;
 }
 else if (strcmp(str_word[col_no],"nd_ref_location") == 0)
  {
    str_len = strlen(word[col_no]);
    if (str_len > 10)
   	   return str_len;
	else 
	   return 10 ;
 }
 else if (strcmp(str_word[col_no],"nd_collect_date") == 0)
  {
    str_len = strlen(word[col_no]);
    if (str_len > 19)
   	   return str_len;
	else 
	   return 19;
 }
 else if (strcmp(str_word[col_no],"nd_category_no") == 0)
  {
    str_len = strlen(word[col_no]);
    if (str_len > 20)
   	   return str_len;
	else 
	   return 20 ;
 }
 else if (strcmp(str_word[col_no],"nd_race") == 0)
  {
    str_len = strlen(word[col_no]);
    if (str_len > 4)
   	   return str_len;
	else 
	   return 4 ;
 }


}


/* to print the detailed record */
void print_detl_rec()
{ 
    void print_detl_line(FILE *);
	void print_detl(FILE *);
	void print_all_tests(FILE *);		
    int i;
    int j = 0;
    int  get_in_patient_dtl();
	void get_general_patient_dtl(),
	 get_referral_patient_dtl();



    d_source_code.arr[0]		 		= '\0';
    d_source_code.len		 			= 0;
	d_consultant_code.arr[0]				= '\0';
	d_consultant_code.len				= 0;
	d_urgent_indicator.arr[0]				= '\0';
	d_urgent_indicator.len				= 0;
	d_request_comment_code1.arr[0] 		= '\0';
	d_request_comment_code1.len			= 0;
	d_request_comment_code2.arr[0] 		= '\0';
	d_request_comment_code2.len			= 0;
	d_request_comment_code3.arr[0] 		= '\0';
	d_request_comment_code3.len			= 0;

    d_episode_type.arr[0]                               = '\0';
    d_episode_type.len                                  = 0;
    d_spec_regd_date_time.arr[0]                        = '\0';
    d_spec_regd_date_time.len                           = 0;
	d_l_spec_regd_date_time.arr[0]						= '\0'; /*Added by Durai Rajkumar for Age Calculation on 05-Feb-08 */
	d_l_spec_regd_date_time.len                         = 0;    /*Added by Durai Rajkumar for Age Calculation on 05-Feb-08 */
	d_assign_to.arr[0]					= '\0';
	d_assign_to.len						=  0;
	d_spec_colltd_date_time.arr[0]		= '\0';
	d_spec_colltd_date_time.len			= 0;
	d_category.arr[0]					= '\0';
	d_category.len						= 0;

    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL SELECT SOURCE_CODE,
		    EPISODE_TYPE,
			CONSULTANT_CODE,
			URGENT_INDICATOR,
			REQUEST_COMMENT_CODE1,
			REQUEST_COMMENT_CODE2,
			REQUEST_COMMENT_CODE3,
			REQUEST_COMMENT_DESC1,
			REQUEST_COMMENT_DESC2,
			REQUEST_COMMENT_DESC3,
		    TO_CHAR(SPEC_REGD_DATE_TIME,'DD/MM/YYYY HH24:MI'),
			TO_CHAR(SPEC_COLLTD_DATE_TIME,'DD/MM/YYYY HH24:MI'),
			assign_to,
			category_code || '/' || category_year  || '/' || SUBSTR(category_number, 1, 8),
	        TO_CHAR(SPEC_REGD_DATE_TIME,'DD/MM/YYYY')
		   INTO :d_source_code,
		    :d_episode_type,
			:d_consultant_code,
			:d_urgent_indicator,
			:d_request_comment_code1,
			:d_request_comment_code2,
			:d_request_comment_code3,
 		    :d_request_comment_desc1,    
		    :d_request_comment_desc2,  
		    :d_request_comment_desc3,  
		    :d_spec_regd_date_time,
			:d_spec_colltd_date_time, 
			:d_assign_to,
			:d_category,
			:d_l_spec_regd_date_time
	      FROM RL_REQUEST_HEADER   
	      WHERE PATIENT_ID  = :d_prt_patient_id  
		  AND SPECIMEN_NO = :d_prt_specimen_no
		  AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 74;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select SOURCE_CODE ,EPISODE_TYPE ,CONSULTANT_CODE ,URGENT\
_INDICATOR ,REQUEST_COMMENT_CODE1 ,REQUEST_COMMENT_CODE2 ,REQUEST_COMMENT_CODE\
3 ,REQUEST_COMMENT_DESC1 ,REQUEST_COMMENT_DESC2 ,REQUEST_COMMENT_DESC3 ,TO_CHA\
R(SPEC_REGD_DATE_TIME,'DD/MM/YYYY HH24:MI') ,TO_CHAR(SPEC_COLLTD_DATE_TIME,'DD\
/MM/YYYY HH24:MI') ,assign_to ,((((category_code||'/')||category_year)||'/')||\
SUBSTR(category_number,1,8)) ,TO_CHAR(SPEC_REGD_DATE_TIME,'DD/MM/YYYY') into :\
b0,:b1,:b2,:b3,:b4,:b5,:b6,:b7,:b8,:b9,:b10,:b11,:b12,:b13,:b14  from RL_REQUE\
ST_HEADER where ((PATIENT_ID=:b15 and SPECIMEN_NO=:b16) and OPERATING_FACILITY\
_ID=:b17)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )1960;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_source_code;
    sqlstm.sqhstl[0] = (unsigned int  )9;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_episode_type;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_consultant_code;
    sqlstm.sqhstl[2] = (unsigned int  )18;
    sqlstm.sqhsts[2] = (         int  )0;
    sqlstm.sqindv[2] = (         void  *)0;
    sqlstm.sqinds[2] = (         int  )0;
    sqlstm.sqharm[2] = (unsigned int  )0;
    sqlstm.sqadto[2] = (unsigned short )0;
    sqlstm.sqtdso[2] = (unsigned short )0;
    sqlstm.sqhstv[3] = (         void  *)&d_urgent_indicator;
    sqlstm.sqhstl[3] = (unsigned int  )4;
    sqlstm.sqhsts[3] = (         int  )0;
    sqlstm.sqindv[3] = (         void  *)0;
    sqlstm.sqinds[3] = (         int  )0;
    sqlstm.sqharm[3] = (unsigned int  )0;
    sqlstm.sqadto[3] = (unsigned short )0;
    sqlstm.sqtdso[3] = (unsigned short )0;
    sqlstm.sqhstv[4] = (         void  *)&d_request_comment_code1;
    sqlstm.sqhstl[4] = (unsigned int  )7;
    sqlstm.sqhsts[4] = (         int  )0;
    sqlstm.sqindv[4] = (         void  *)0;
    sqlstm.sqinds[4] = (         int  )0;
    sqlstm.sqharm[4] = (unsigned int  )0;
    sqlstm.sqadto[4] = (unsigned short )0;
    sqlstm.sqtdso[4] = (unsigned short )0;
    sqlstm.sqhstv[5] = (         void  *)&d_request_comment_code2;
    sqlstm.sqhstl[5] = (unsigned int  )7;
    sqlstm.sqhsts[5] = (         int  )0;
    sqlstm.sqindv[5] = (         void  *)0;
    sqlstm.sqinds[5] = (         int  )0;
    sqlstm.sqharm[5] = (unsigned int  )0;
    sqlstm.sqadto[5] = (unsigned short )0;
    sqlstm.sqtdso[5] = (unsigned short )0;
    sqlstm.sqhstv[6] = (         void  *)&d_request_comment_code3;
    sqlstm.sqhstl[6] = (unsigned int  )7;
    sqlstm.sqhsts[6] = (         int  )0;
    sqlstm.sqindv[6] = (         void  *)0;
    sqlstm.sqinds[6] = (         int  )0;
    sqlstm.sqharm[6] = (unsigned int  )0;
    sqlstm.sqadto[6] = (unsigned short )0;
    sqlstm.sqtdso[6] = (unsigned short )0;
    sqlstm.sqhstv[7] = (         void  *)&d_request_comment_desc1;
    sqlstm.sqhstl[7] = (unsigned int  )44;
    sqlstm.sqhsts[7] = (         int  )0;
    sqlstm.sqindv[7] = (         void  *)0;
    sqlstm.sqinds[7] = (         int  )0;
    sqlstm.sqharm[7] = (unsigned int  )0;
    sqlstm.sqadto[7] = (unsigned short )0;
    sqlstm.sqtdso[7] = (unsigned short )0;
    sqlstm.sqhstv[8] = (         void  *)&d_request_comment_desc2;
    sqlstm.sqhstl[8] = (unsigned int  )44;
    sqlstm.sqhsts[8] = (         int  )0;
    sqlstm.sqindv[8] = (         void  *)0;
    sqlstm.sqinds[8] = (         int  )0;
    sqlstm.sqharm[8] = (unsigned int  )0;
    sqlstm.sqadto[8] = (unsigned short )0;
    sqlstm.sqtdso[8] = (unsigned short )0;
    sqlstm.sqhstv[9] = (         void  *)&d_request_comment_desc3;
    sqlstm.sqhstl[9] = (unsigned int  )44;
    sqlstm.sqhsts[9] = (         int  )0;
    sqlstm.sqindv[9] = (         void  *)0;
    sqlstm.sqinds[9] = (         int  )0;
    sqlstm.sqharm[9] = (unsigned int  )0;
    sqlstm.sqadto[9] = (unsigned short )0;
    sqlstm.sqtdso[9] = (unsigned short )0;
    sqlstm.sqhstv[10] = (         void  *)&d_spec_regd_date_time;
    sqlstm.sqhstl[10] = (unsigned int  )19;
    sqlstm.sqhsts[10] = (         int  )0;
    sqlstm.sqindv[10] = (         void  *)0;
    sqlstm.sqinds[10] = (         int  )0;
    sqlstm.sqharm[10] = (unsigned int  )0;
    sqlstm.sqadto[10] = (unsigned short )0;
    sqlstm.sqtdso[10] = (unsigned short )0;
    sqlstm.sqhstv[11] = (         void  *)&d_spec_colltd_date_time;
    sqlstm.sqhstl[11] = (unsigned int  )22;
    sqlstm.sqhsts[11] = (         int  )0;
    sqlstm.sqindv[11] = (         void  *)0;
    sqlstm.sqinds[11] = (         int  )0;
    sqlstm.sqharm[11] = (unsigned int  )0;
    sqlstm.sqadto[11] = (unsigned short )0;
    sqlstm.sqtdso[11] = (unsigned short )0;
    sqlstm.sqhstv[12] = (         void  *)&d_assign_to;
    sqlstm.sqhstl[12] = (unsigned int  )23;
    sqlstm.sqhsts[12] = (         int  )0;
    sqlstm.sqindv[12] = (         void  *)0;
    sqlstm.sqinds[12] = (         int  )0;
    sqlstm.sqharm[12] = (unsigned int  )0;
    sqlstm.sqadto[12] = (unsigned short )0;
    sqlstm.sqtdso[12] = (unsigned short )0;
    sqlstm.sqhstv[13] = (         void  *)&d_category;
    sqlstm.sqhstl[13] = (unsigned int  )27;
    sqlstm.sqhsts[13] = (         int  )0;
    sqlstm.sqindv[13] = (         void  *)0;
    sqlstm.sqinds[13] = (         int  )0;
    sqlstm.sqharm[13] = (unsigned int  )0;
    sqlstm.sqadto[13] = (unsigned short )0;
    sqlstm.sqtdso[13] = (unsigned short )0;
    sqlstm.sqhstv[14] = (         void  *)&d_l_spec_regd_date_time;
    sqlstm.sqhstl[14] = (unsigned int  )19;
    sqlstm.sqhsts[14] = (         int  )0;
    sqlstm.sqindv[14] = (         void  *)0;
    sqlstm.sqinds[14] = (         int  )0;
    sqlstm.sqharm[14] = (unsigned int  )0;
    sqlstm.sqadto[14] = (unsigned short )0;
    sqlstm.sqtdso[14] = (unsigned short )0;
    sqlstm.sqhstv[15] = (         void  *)&d_prt_patient_id;
    sqlstm.sqhstl[15] = (unsigned int  )33;
    sqlstm.sqhsts[15] = (         int  )0;
    sqlstm.sqindv[15] = (         void  *)0;
    sqlstm.sqinds[15] = (         int  )0;
    sqlstm.sqharm[15] = (unsigned int  )0;
    sqlstm.sqadto[15] = (unsigned short )0;
    sqlstm.sqtdso[15] = (unsigned short )0;
    sqlstm.sqhstv[16] = (         void  *)&d_prt_specimen_no;
    sqlstm.sqhstl[16] = (unsigned int  )23;
    sqlstm.sqhsts[16] = (         int  )0;
    sqlstm.sqindv[16] = (         void  *)0;
    sqlstm.sqinds[16] = (         int  )0;
    sqlstm.sqharm[16] = (unsigned int  )0;
    sqlstm.sqadto[16] = (unsigned short )0;
    sqlstm.sqtdso[16] = (unsigned short )0;
    sqlstm.sqhstv[17] = (         void  *)&nd_operating_facility_id;
    sqlstm.sqhstl[17] = (unsigned int  )5;
    sqlstm.sqhsts[17] = (         int  )0;
    sqlstm.sqindv[17] = (         void  *)0;
    sqlstm.sqinds[17] = (         int  )0;
    sqlstm.sqharm[17] = (unsigned int  )0;
    sqlstm.sqadto[17] = (unsigned short )0;
    sqlstm.sqtdso[17] = (unsigned short )0;
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


    
    d_source_code.arr[d_source_code.len] 		= '\0';
    d_episode_type.arr[d_episode_type.len]              = '\0';
    d_spec_regd_date_time.arr[d_spec_regd_date_time.len]= '\0';
	d_l_spec_regd_date_time.arr[d_l_spec_regd_date_time.len] = '\0'; /*Added by Durai Rajkumar for Age Calculation on 05-Feb-08 */
/*	d_4_code.arr[d_consultant_code.len] = '\0'; */
	d_urgent_indicator.arr[d_urgent_indicator.len] ='\0';
	d_request_comment_code1.arr[d_request_comment_code1.len] = '\0';
	d_request_comment_code2.arr[d_request_comment_code2.len] = '\0';
	d_request_comment_code3.arr[d_request_comment_code3.len] = '\0';
/*ADDED FOR PRINTING REQUEST_COMMENT DESCRIPTION  25/06/2002   */
	d_request_comment_desc1.arr[d_request_comment_desc1.len] = '\0';
	d_request_comment_desc2.arr[d_request_comment_desc2.len] = '\0';
	d_request_comment_desc3.arr[d_request_comment_desc3.len] = '\0';

/*********** ADDED ON 28/07/2002 FOR KNDV ENHANCEMENTS *************/
	d_assign_to.arr[d_assign_to.len]							= '\0';
	d_category.arr[d_category.len]								= '\0';
	d_spec_colltd_date_time.arr[d_spec_colltd_date_time.len]	= '\0';

    d_short_name.arr[0]		 			= '\0';
    d_date_of_birth.arr[0]		 		= '\0';
    d_nation.arr[0]                                     = '\0';

    d_short_name.len		 			= 0;
    d_date_of_birth.len                		    	= 0;
    d_nation.len                                        = 0;

	/*get_request_comment1();
	get_request_comment2(); 
 	get_request_comment3(); 
*/

/** ACTUAL S.A VERSION  ****/
if(   strcmp(d_episode_type.arr,"I")==0 
	   || strcmp(d_episode_type.arr,"O")==0
	   || strcmp(d_episode_type.arr,"H")==0 )
    {
       i = get_in_patient_dtl();
       
    }
    else
       if(strcmp(d_episode_type.arr,"R")==0) 
         get_referral_patient_dtl();


    no_of_tests = 16;
    test_ctr=0;
    print_detl_line(f1);
    no_of_tests = 25;

    print_all_tests(f1);
	
	/* Added to Print the Specimen Tests */
	print_spec_tests();

return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2047;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at print_detl_rec() occured....\n");
   proc_exit();
}

void get_request_comment1()
{

 d_request_comment_desc1.arr[0] = '\0';
 d_request_comment_desc1.len = 0;
                                                                                                            
    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL SELECT request_comment
               INTO :d_request_comment_desc1
			   FROM RL_REQUEST_COMMENT_CODE
               WHERE section_code = :nd_section_code
			   AND request_comment_code = :d_request_comment_code1 ; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 74;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select request_comment into :b0  from RL_REQUEST_COMMENT_\
CODE where (section_code=:b1 and request_comment_code=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2062;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_request_comment_desc1;
    sqlstm.sqhstl[0] = (unsigned int  )44;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&nd_section_code;
    sqlstm.sqhstl[1] = (unsigned int  )4;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&d_request_comment_code1;
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


						

    d_request_comment_desc1.arr[d_request_comment_desc1.len] = '\0';

	
	return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2089;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_request_comment1() occured....\n");
   proc_exit();
}

void get_request_comment2()
{

 d_request_comment_desc2.arr[0] = '\0';
 d_request_comment_desc2.len = 0;

    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL SELECT REQUEST_COMMENT
               INTO :d_request_comment_desc2
			FROM RL_REQUEST_COMMENT_CODE
			WHERE request_comment_code = 
                                :d_request_comment_code2
                         AND section_code =  :nd_section_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 74;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select REQUEST_COMMENT into :b0  from RL_REQUEST_COMMENT_\
CODE where (request_comment_code=:b1 and section_code=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2104;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_request_comment_desc2;
    sqlstm.sqhstl[0] = (unsigned int  )44;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_request_comment_code2;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_section_code;
    sqlstm.sqhstl[2] = (unsigned int  )4;
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



    d_request_comment_desc2.arr[d_request_comment_desc2.len] = '\0';

	return ;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2131;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_request_comment2() occured....\n");
   proc_exit();
}

void get_request_comment3()
{

 d_request_comment_desc3.arr[0] = '\0';
 d_request_comment_desc3.len = 0;

    /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

    /* EXEC SQL SELECT REQUEST_COMMENT
               INTO :d_request_comment_desc3
			FROM RL_REQUEST_COMMENT_CODE
			WHERE request_comment_code = 
                                :d_request_comment_code3
                         AND section_code =  :nd_section_code; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 74;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select REQUEST_COMMENT into :b0  from RL_REQUEST_COMMENT_\
CODE where (request_comment_code=:b1 and section_code=:b2)";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2146;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_request_comment_desc3;
    sqlstm.sqhstl[0] = (unsigned int  )44;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_request_comment_code3;
    sqlstm.sqhstl[1] = (unsigned int  )7;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_section_code;
    sqlstm.sqhstl[2] = (unsigned int  )4;
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



    d_request_comment_desc3.arr[d_request_comment_desc3.len] = '\0';

	return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2173;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_request_comment3() occured....\n");
   proc_exit();
}

int space_or_line(prt_yn,ind)
char prt_yn;
char ind;
{
    test_ctr++;
    if(prt_yn == 'Y')
       return 1;
    else
    {
       if(prt_yn == 'N') 
       {
    	  if(ind == 'O' || ind == 'M')
	     return 0;
          else
             return 1;
       }
    }
}

void print_detl_line(afp)
FILE *afp;
{
      
	print_dtl(afp);


}

/* Function to fetch the GENERAL PATIENT details */
void get_general_patient_dtl()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 


   /***********************commented on 16.01.2008 since it is not used
   EXEC SQL SELECT SUBSTR(SHORT_NAME,1,30),
		   TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),
		   NATIONALITY_CODE,
		   SEX
	      INTO :d_short_name, 
		   :d_date_of_birth,
		   :d_nation,
		   :d_sex
              FROM MP_PATIENT_MAST_OTHERS 
	     WHERE PATIENT_ID = :d_prt_patient_id;
**************************end comments****************************/


  d_short_name.arr[d_short_name.len]     = '\0';
  d_date_of_birth.arr[d_date_of_birth.len]                       = '\0';
  d_nation.arr[d_nation.len]                 = '\0';
  d_sex.arr[d_sex.len] = '\0';

  
  patient_age();

  #ifdef DEBUG
   printf("d_short_name= %s\n", d_short_name.arr);
  #endif

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2188;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_general_patient_dtl() occured....\n");
   proc_exit();
}

/* Function to fetch the REFERRAL PATIENT details */
void get_referral_patient_dtl()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT SUBSTR(DECODE (:language_id, 'en',  SHORT_NAME,  NVL(SHORT_NAME_loc_lang, SHORT_NAME)) ,1,30), 
		   TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),
		   NATIONALITY_CODE,
		   SEX, 
		   location,
		   race_code
	      INTO :d_short_name,
		   :d_date_of_birth,
		   :d_nation,
		   :d_sex,
		   :d_location,
		   :d_race_code
         FROM RL_PATIENT_MAST 
	     WHERE PATIENT_ID = :d_prt_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(DECODE(:b0,'en',SHORT_NAME,NVL(SHORT_NAME_lo\
c_lang,SHORT_NAME)),1,30) ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') ,NATIONALITY_CO\
DE ,SEX ,location ,race_code into :b1,:b2,:b3,:b4,:b5,:b6  from RL_PATIENT_MAS\
T where PATIENT_ID=:b7";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2203;
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
   sqlstm.sqhstv[1] = (         void  *)&d_short_name;
   sqlstm.sqhstl[1] = (unsigned int  )242;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_date_of_birth;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_nation;
   sqlstm.sqhstl[3] = (unsigned int  )7;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_sex;
   sqlstm.sqhstl[4] = (unsigned int  )4;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_location;
   sqlstm.sqhstl[5] = (unsigned int  )23;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_race_code;
   sqlstm.sqhstl[6] = (unsigned int  )7;
   sqlstm.sqhsts[6] = (         int  )0;
   sqlstm.sqindv[6] = (         void  *)0;
   sqlstm.sqinds[6] = (         int  )0;
   sqlstm.sqharm[6] = (unsigned int  )0;
   sqlstm.sqadto[6] = (unsigned short )0;
   sqlstm.sqtdso[6] = (unsigned short )0;
   sqlstm.sqhstv[7] = (         void  *)&d_prt_patient_id;
   sqlstm.sqhstl[7] = (unsigned int  )33;
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
   if (sqlca.sqlcode < 0) goto err_exit;
}


		 /* AND OPERATING_FACILITY_ID = :nd_operating_facility_id; */

  d_short_name.arr[d_short_name.len]		 = '\0';
  d_date_of_birth.arr[d_date_of_birth.len]   = '\0';
  d_nation.arr[d_nation.len]                 = '\0';
  d_sex.arr[d_sex.len]						 = '\0';
  d_location.arr[d_location.len]			 = '\0';
  d_race_code.arr[d_race_code.len]			 = '\0';

    patient_age();

  #ifdef DEBUG
   printf("d_short_name= %s\n", d_short_name.arr);
  #endif

  return;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2250;
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

   /* EXEC SQL SELECT SUBSTR(DECODE (:language_id, 'en',  SHORT_NAME,  NVL(SHORT_NAME_loc_lang, SHORT_NAME)) ,1,30),
		   TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY'),
		   NATIONALITY_CODE,
		   SEX,
		   race_code
	      INTO :d_short_name,
		   :d_date_of_birth,
		   :d_nation,
		   :d_sex,
		   :d_race_code
              FROM MP_PATIENT_MAST 
	     WHERE PATIENT_ID = :d_prt_patient_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select SUBSTR(DECODE(:b0,'en',SHORT_NAME,NVL(SHORT_NAME_lo\
c_lang,SHORT_NAME)),1,30) ,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') ,NATIONALITY_CO\
DE ,SEX ,race_code into :b1,:b2,:b3,:b4,:b5  from MP_PATIENT_MAST where PATIEN\
T_ID=:b6";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2265;
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
   sqlstm.sqhstv[1] = (         void  *)&d_short_name;
   sqlstm.sqhstl[1] = (unsigned int  )242;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_date_of_birth;
   sqlstm.sqhstl[2] = (unsigned int  )13;
   sqlstm.sqhsts[2] = (         int  )0;
   sqlstm.sqindv[2] = (         void  *)0;
   sqlstm.sqinds[2] = (         int  )0;
   sqlstm.sqharm[2] = (unsigned int  )0;
   sqlstm.sqadto[2] = (unsigned short )0;
   sqlstm.sqtdso[2] = (unsigned short )0;
   sqlstm.sqhstv[3] = (         void  *)&d_nation;
   sqlstm.sqhstl[3] = (unsigned int  )7;
   sqlstm.sqhsts[3] = (         int  )0;
   sqlstm.sqindv[3] = (         void  *)0;
   sqlstm.sqinds[3] = (         int  )0;
   sqlstm.sqharm[3] = (unsigned int  )0;
   sqlstm.sqadto[3] = (unsigned short )0;
   sqlstm.sqtdso[3] = (unsigned short )0;
   sqlstm.sqhstv[4] = (         void  *)&d_sex;
   sqlstm.sqhstl[4] = (unsigned int  )4;
   sqlstm.sqhsts[4] = (         int  )0;
   sqlstm.sqindv[4] = (         void  *)0;
   sqlstm.sqinds[4] = (         int  )0;
   sqlstm.sqharm[4] = (unsigned int  )0;
   sqlstm.sqadto[4] = (unsigned short )0;
   sqlstm.sqtdso[4] = (unsigned short )0;
   sqlstm.sqhstv[5] = (         void  *)&d_race_code;
   sqlstm.sqhstl[5] = (unsigned int  )7;
   sqlstm.sqhsts[5] = (         int  )0;
   sqlstm.sqindv[5] = (         void  *)0;
   sqlstm.sqinds[5] = (         int  )0;
   sqlstm.sqharm[5] = (unsigned int  )0;
   sqlstm.sqadto[5] = (unsigned short )0;
   sqlstm.sqtdso[5] = (unsigned short )0;
   sqlstm.sqhstv[6] = (         void  *)&d_prt_patient_id;
   sqlstm.sqhstl[6] = (unsigned int  )33;
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
  d_short_name.arr[d_short_name.len]     = '\0';
  d_date_of_birth.arr[d_date_of_birth.len]                       = '\0';
  d_nation.arr[d_nation.len]                 = '\0';
  d_sex.arr[d_sex.len]                 = '\0';
  d_race_code.arr[d_race_code.len]		   = '\0';

   patient_age();

  #ifdef DEBUG
   printf("d_short_name= %s\n", d_short_name.arr);
  #endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2308;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_in_patient_dtl() occured....\n");
   proc_exit();
}


/* print the heading */
void print_col_heading(afp)
FILE *afp;
{
 prepare_heading(afp);

}



/* to print the last line of the report */
void print_footer_rec(afp)
FILE *afp;
{

  fprintf(afp, "--------------------------------------------");
  fprintf(afp, "------------------------------------");
  
  fprintf(afp,"\n\n");
  //fprintf(afp,"ENTERED BY : ________________________________________       ");
  fprintf(afp,"%-10.10s : ________________________________________       ",local_legend[8]);
  //fprintf(afp,"DATE : _________");
  fprintf(afp,"%-4.4s : _________",local_legend[4]);
  fprintf(afp,"\n");
  fprintf(afp, "--------------------------------------------");
  fprintf(afp, "------------------------------------");

}



/* to print the last line of the report */
void end_report(afp)
FILE *afp;
{
  fprintf(afp,"\n");
  fprintf(afp,"");
}

/* fetches the next record from CUR  */
/* returns 0 if the end of cursor is reached */
/* else returns 1.                           */
int fetch_specimen_cur()
{

  d_specimen_no.arr[0]		 		= '\0';
  d_patient_id.arr[0]		 		= '\0';
  d_req_test_code.arr[0] 			= '\0';
  d_test_result.arr[0] 				= '\0';
  d_num_result.arr[0] 				= '\0';
  d_comm_result.arr[0] 				= '\0';

  d_specimen_no.len		 		= 0;
  d_patient_id.len		 		= 0;
  d_req_test_code.len                           = 0;
  d_test_result.len 				= '\0';
  d_num_result.len 				= '\0';
  d_comm_result.len 				= '\0';
  d_num_prefix.arr[0]				= '\0';
  d_num_prefix.len					= 0;

  /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

  /* EXEC SQL FETCH SPECIMEN_CUR INTO
		:d_specimen_no,  
		:d_patient_id,
		:d_req_test_code,
		:d_num_result,
		:d_num_prefix,
		:d_comm_result; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 74;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2323;
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
  sqlstm.sqhstv[2] = (         void  *)&d_req_test_code;
  sqlstm.sqhstl[2] = (unsigned int  )13;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_num_result;
  sqlstm.sqhstl[3] = (unsigned int  )18;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_num_prefix;
  sqlstm.sqhstl[4] = (unsigned int  )4;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_comm_result;
  sqlstm.sqhstl[5] = (unsigned int  )18;
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


   
#ifdef DEBUG
         printf("SQLCA code after fetch :%d\n", sqlca.sqlcode);
#endif


  if (NODATAFOUND)
    return 0;
  
  d_specimen_no.arr[d_specimen_no.len]		 		= '\0';
  d_patient_id.arr[d_patient_id.len]		 		= '\0';
  d_req_test_code.arr[d_req_test_code .len]	 		= '\0';
  d_num_result.arr[d_num_result .len]		 		= '\0';
  d_comm_result.arr[d_comm_result .len]		 		= '\0';
  d_num_prefix.arr[d_num_prefix.len]				= '\0';

  d_test_result.arr[0] = '\0';
  d_test_result.len = 0;

  if(strlen(d_num_result.arr))
  {
	 if (strlen(d_num_prefix.arr))
	 {
		strcpy(d_test_result.arr, d_num_prefix.arr);
		d_test_result.len = strlen(d_test_result.arr);
		strcat(d_test_result.arr,d_num_result.arr);
	 }
	 else
	 {
		strcpy(d_test_result.arr,d_num_result.arr);
	 }
  }
/* commented 30.09.2002 since result comments to be shown seperately
  else
     strcpy(d_test_result.arr,d_comm_result.arr);
*/
  d_test_result.len = strlen(d_test_result.arr);


/***** for updation of last specimen no *****/
	strcpy(nd_specimen_no.arr, d_specimen_no.arr);
	nd_specimen_no.len = strlen(nd_specimen_no.arr);

#ifdef DEBUG
   printf("********* Details from RL_TEST_RESULT ******************\n");
   printf(" d_specimen_no   = %s\n",d_specimen_no.arr);
   printf(" d_patient_id    = %s\n",d_patient_id.arr);
   printf(" d_req_test_code = %s\n", d_req_test_code.arr);
#endif

  return 1;

err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2362;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at fetch_specimen_cur() occured....\n");
   proc_exit();

}

gen_file_name() 
{
	 	 /* For a constant file name (4 lines) */
  	 strcpy(nd_file_name.arr,WORKING_DIR) ;
     nd_file_name.len = strlen(nd_file_name.arr);
//	 strcat(nd_file_name.arr,"rlrwlre1.lis");
	 //strcat(nd_file_name.arr,"rlrreswp.lis");  
	 strcat(nd_file_name.arr,OUTPUT_FILE_NAME);  
	 nd_file_name.len = strlen(nd_file_name.arr);
	 if ((f1 = fopen(nd_file_name.arr,"w")) == NULL)
     {
       sprintf(string_var,"Error while opening file %s\n",nd_file_name.arr);
	   disp_message(ERR_MESG,string_var) ;
       proc_exit();
     }
}

increment_file_no()
{
/***
EXEC SQL UPDATE RL_PARAM
		SET PRINT_FILE_NO = NVL(PRINT_FILE_NO,0) + 1;
		***/
if (OERROR)
       disp_message(ERR_MESG,"Update failed on table RL_PARAM");

/* EXEC SQL COMMIT WORK; */ 

{
struct sqlexd sqlstm;
sqlstm.sqlvsn = 10;
sqlstm.arrsiz = 74;
sqlstm.sqladtp = &sqladt;
sqlstm.sqltdsp = &sqltds;
sqlstm.iters = (unsigned int  )1;
sqlstm.offset = (unsigned int  )2377;
sqlstm.cud = sqlcud0;
sqlstm.sqlest = (unsigned char  *)&sqlca;
sqlstm.sqlety = (unsigned short)256;
sqlstm.occurs = (unsigned int  )0;
sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


      if (OERROR)
         disp_message(ERR_MESG,"COMMIT failed");
}

get_patient_marker()
{
   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   d_pat_mark.arr[0] = '\0';
   d_pat_mark.len = 0;
   /* EXEC SQL SELECT TEST_RESULT INTO :d_pat_mark
	      FROM RL_PATIENT_MARKERS
             WHERE PATIENT_ID = :d_prt_patient_id
	       AND TEST_CODE  = :d_worklist_marker; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select TEST_RESULT into :b0  from RL_PATIENT_MARKERS where\
 (PATIENT_ID=:b1 and TEST_CODE=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2392;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_pat_mark;
   sqlstm.sqhstl[0] = (unsigned int  )4;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&d_prt_patient_id;
   sqlstm.sqhstl[1] = (unsigned int  )33;
   sqlstm.sqhsts[1] = (         int  )0;
   sqlstm.sqindv[1] = (         void  *)0;
   sqlstm.sqinds[1] = (         int  )0;
   sqlstm.sqharm[1] = (unsigned int  )0;
   sqlstm.sqadto[1] = (unsigned short )0;
   sqlstm.sqtdso[1] = (unsigned short )0;
   sqlstm.sqhstv[2] = (         void  *)&d_worklist_marker;
   sqlstm.sqhstl[2] = (unsigned int  )13;
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


  if (NODATAFOUND)
    return 0;
  d_pat_mark.arr[d_pat_mark.len] = '\0';


  return 1;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2419;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_patient_marker() occured....\n");
   proc_exit();
}

void get_worklist_marker()
{
   d_worklist_marker.arr[0] = '\0';
   d_worklist_marker.len = 0;
	
   d_section_name.arr[0] = '\0';
   d_section_name.len = 0;

   /* EXEC SQL WHENEVER SQLERROR GOTO err_exit; */ 

   /* EXEC SQL SELECT  
            //WORKLIST_MARKER, 
			LONG_NAME
			INTO 
			//:d_worklist_marker, 
			:d_section_name
            FROM    RL_SECTION_CODE_LANG_VW
	    WHERE   SECTION_CODE = :nd_section_code
		AND     LANGUAGE_ID = :language_id; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.stmt = "select LONG_NAME into :b0  from RL_SECTION_CODE_LANG_VW wh\
ere (SECTION_CODE=:b1 and LANGUAGE_ID=:b2)";
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2434;
   sqlstm.selerr = (unsigned short)1;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlstm.sqhstv[0] = (         void  *)&d_section_name;
   sqlstm.sqhstl[0] = (unsigned int  )62;
   sqlstm.sqhsts[0] = (         int  )0;
   sqlstm.sqindv[0] = (         void  *)0;
   sqlstm.sqinds[0] = (         int  )0;
   sqlstm.sqharm[0] = (unsigned int  )0;
   sqlstm.sqadto[0] = (unsigned short )0;
   sqlstm.sqtdso[0] = (unsigned short )0;
   sqlstm.sqhstv[1] = (         void  *)&nd_section_code;
   sqlstm.sqhstl[1] = (unsigned int  )4;
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


  d_printer_name.arr[d_printer_name.len] = '\0';
  d_section_name.arr[d_section_name.len] = '\0';
#ifdef DEBUG
   printf("d_worklist_marker = %s\n", d_worklist_marker.arr);
#endif
  return;
err_exit:
   /* EXEC SQL WHENEVER SQLERROR CONTINUE; */ 

   /* EXEC SQL ROLLBACK WORK RELEASE; */ 

{
   struct sqlexd sqlstm;
   sqlstm.sqlvsn = 10;
   sqlstm.arrsiz = 74;
   sqlstm.sqladtp = &sqladt;
   sqlstm.sqltdsp = &sqltds;
   sqlstm.iters = (unsigned int  )1;
   sqlstm.offset = (unsigned int  )2461;
   sqlstm.cud = sqlcud0;
   sqlstm.sqlest = (unsigned char  *)&sqlca;
   sqlstm.sqlety = (unsigned short)256;
   sqlstm.occurs = (unsigned int  )0;
   sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


   disp_message(ORA_MESG,"Oracle error at get_worklist_marker() occured....\n");
   proc_exit();
}


/*------------------ REVERSE SORT ARRAY ------------------*/
void reverse_sort()
{

  for(i=0;i<21;i++)
  {
    if (strcmp(str_word[i],"nd_cup_number") == 0)
		strcpy(detail[i], d_prt_cup_no.arr);	
	else if(strcmp(str_word[i],"nd_cup_indr") == 0) 
		strcpy(detail[i], d_print_cup_indicator.arr);
    else if(strcmp(str_word[i],"nd_wl_marker") == 0) 
		strcpy(detail[i], d_pat_mark.arr);
	else if(strcmp(str_word[i],"nd_spec_no") == 0) 
		strcpy(detail[i], d_prt_specimen_no.arr);
	else if(strcmp(str_word[i],"nd_pat_id") == 0) 
		strcpy(detail[i], d_prt_patient_id.arr);
	else if(strcmp(str_word[i],"nd_pat_name") == 0) 
		strcpy(detail[i], d_short_name.arr);
	else if(strcmp(str_word[i],"nd_age") == 0) 
		strcpy(detail[i], t_age.arr);
	else if(strcmp(str_word[i],"nd_dob") == 0) 
		strcpy(detail[i], d_date_of_birth.arr);
	else if(strcmp(str_word[i],"nd_sex") == 0) 
		strcpy(detail[i], d_sex.arr);
	else if(strcmp(str_word[i],"nd_source") == 0) 
		strcpy(detail[i], d_source_code.arr);
	else if(strcmp(str_word[i],"nd_consultant") == 0) 
		strcpy(detail[i], d_consultant_code.arr);
	else if(strcmp(str_word[i],"nd_urgency") == 0) 
		strcpy(detail[i], d_urgent_indicator.arr);
	else if(strcmp(str_word[i],"nd_comm_1") == 0) 
		strcpy(detail[i], d_request_comment_desc1.arr);
	else if(strcmp(str_word[i],"nd_comm_2") == 0) 
		strcpy(detail[i], d_request_comment_desc2.arr);
	else if(strcmp(str_word[i],"nd_comm_3") == 0) 
		strcpy(detail[i], d_request_comment_desc3.arr);
	else if(strcmp(str_word[i],"nd_spec_date") == 0) 
		strcpy(detail[i], d_spec_regd_date_time.arr);
	else if(strcmp(str_word[i],"nd_assign_to") == 0) 
		strcpy(detail[i], d_assign_to.arr);
	else if(strcmp(str_word[i],"nd_ref_location") == 0) 
		strcpy(detail[i], d_location.arr);
	else if(strcmp(str_word[i],"nd_category_no") == 0) 
		strcpy(detail[i], d_category.arr);
	else if(strcmp(str_word[i],"nd_collect_date") == 0) 
		strcpy(detail[i], d_spec_colltd_date_time.arr);
	else if(strcmp(str_word[i],"nd_race") == 0) 
		strcpy(detail[i], d_race_code.arr);

  }


}

/*------------------ S O R T I N G ------------------*/
void sorting()
{

	maxx = num[0] ;

	for(i=0;i<21;i++)
	{
		for(j=i+1;j<21;j++)
		{
			if (((num[j] < num[i]) || (num[i] == 0))  && (num[j] > 0))
			{
				total  = num[i];
				num[i] = num[j];
				num[j] = total;

				total  = cou[i];
				cou[i] = cou[j];
				cou[j] = total;
			
				strcpy(temp_word,word[i]);
				strcpy(word[i], word[j]);
				strcpy(word[j], temp_word);

				strcpy(temp_word,detail[i]);
				strcpy(detail[i], detail[j]);
				strcpy(detail[j], temp_word);

				strcpy(temp_word,str_word[i]);
				strcpy(str_word[i], str_word[j]);
				strcpy(str_word[j], temp_word);

			}
			else if (num[j] > num[i])
			{
			  if (maxx < num[j])
				maxx = num[j];
			}

		
		}	
	
	}


	for(i=0;i<21;i++)
	{
		for(j=i+1;j<21;j++)
		{
			if ((num[j] == num[i]) && (num[j] > 0))
			{
				if (((cou[j] < cou[i]) || (cou[i] == 0)) && (cou[j] > 0))
				{
				   total = cou[i];
				   cou[i] = cou[j];
				   cou[j] = total;

				   strcpy(temp_word,word[i]);
				   strcpy(word[i], word[j]);
				   strcpy(word[j], temp_word);

				   strcpy(temp_word,detail[i]);
				   strcpy(detail[i], detail[j]);
				   strcpy(detail[j], temp_word);

				   strcpy(temp_word,str_word[i]);
			  	   strcpy(str_word[i], str_word[j]);
				   strcpy(str_word[j], temp_word);

				}

			}
		
		}	
	
	}

	
}

/*-----------------------------------------------------*/
void print_dtl(afp)
FILE *afp;
{

	char fl_ag[3];
	total = 0;
	ctr   = 1;
	strcpy(fl_ag, "F");
	reverse_sort();
	sorting();

	for(i=1;i<=21;i++)
	{

	 
	   k = i;

	   for (j=0;j<21;j++)
	   {
		
		  
	      if (num[j] == ctr)
	      {

			  str_len = strlen(detail[j])  ;


			  if ((strcmp(fl_ag,"F") == 0))
			  	strcpy(fl_ag, "T");
			
			  									 		
			  if ((j > 0) && (num[j - 1] == num[j]))
			  {
			      total = cou[j - 1] ;
			       str_len = strlen(detail[j - 1])  ;
			  }
			
			  if ((j > 0) && (num[j - 1] == num[j]) > 0)
			  {
			     fprintf(afp,"%*s",(cou[j]   - (total + str_len)),"");
  		         fprintf(afp,"%s", detail[j]);
                 tot_tests = get_col_length(j);
                 stimulate = (cou[j]   + tot_tests);


                 stimulate = stimulate - (cou[j] + strlen(detail[j]));
                                                
			  }
			  else
			  {
				fprintf(afp,"%*s", cou[j] - 1, "");
				fprintf(afp,"%s", detail[j]);
                tot_tests = get_col_length(j);
                stimulate = (cou[j]   + tot_tests);

                stimulate = stimulate - (cou[j] + strlen(detail[j]));

			  }
			  

			  k = j ;		   
			  str_len = 0;


			  
	      }
		
      }
	
	   i = k;
	   
	   if ((num[i] > 0) && (maxx >= num[i]))
	   {

/******** not required for kndv enhancments ************
		  if (num[i] == 1)
		  {

			print_hyphen(afp);
			stimulate = 0;
		  }
************ upto here   **************/
		  	
	      if (strcmp(fl_ag,"T") == 0)
		  {
			fprintf(afp,"\n");
		    line_no++;
			strcpy(fl_ag, "F");
		  }
	      total = 0;


	  }

	   ctr = ctr + 1 ;
	   strcpy(fl_ag,"F");

	}

}

void print_hyphen(afp)
FILE *afp;
{
	int space_or_line();
    int i=0,r=0;

  fprintf(afp," ");

  fprintf(afp," ");

  tests = stimulate ;

  fprintf(afp, "%*.*s", tests, tests, "");
  

  if( no_of_tests < 25 )
  { 
  	print_line = 0;
    print_line = space_or_line(d_prt_test_1_yn,worklist_ind[0][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s","_____ ");
    else
	   if (d_no_of_tests >= test_ctr)
	      fprintf(afp,"%-6s","      ");
    print_line = 0;
    print_line = space_or_line(d_prt_test_2_yn,worklist_ind[1][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s","_____ ");
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s","      ");
    print_line = 0;
    print_line = space_or_line(d_prt_test_3_yn,worklist_ind[2][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s","_____ ");
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s","      ");
    print_line = 0;
    print_line = space_or_line(d_prt_test_4_yn,worklist_ind[3][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s","_____ ");
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s","      ");
    print_line = 0;
    print_line = space_or_line(d_prt_test_5_yn,worklist_ind[4][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s","_____ ");
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s","      ");
    print_line = 0;
    print_line = space_or_line(d_prt_test_6_yn,worklist_ind[5][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s","_____ ");
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s","      ");
    print_line = 0;
    print_line = space_or_line(d_prt_test_7_yn,worklist_ind[6][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s","_____ ");
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s","      ");
    print_line = 0;
    print_line = space_or_line(d_prt_test_8_yn,worklist_ind[7][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s","_____ ");
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s","      ");
    print_line = 0;
    print_line = space_or_line(d_prt_test_9_yn,worklist_ind[8][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s","_____ ");
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s","      ");
    print_line = 0;
    print_line = space_or_line(d_prt_test_10_yn,worklist_ind[9][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s","_____ ");
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s","      ");
    print_line = 0;
    print_line = space_or_line(d_prt_test_11_yn,worklist_ind[10][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s","_____ ");
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s","      ");
    print_line = 0;
    print_line = space_or_line(d_prt_test_12_yn,worklist_ind[11][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s","_____ ");
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s","      ");
    print_line = 0;
    print_line = space_or_line(d_prt_test_13_yn,worklist_ind[12][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s","_____ ");
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s","      ");
    print_line = 0;
    print_line = space_or_line(d_prt_test_14_yn,worklist_ind[13][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s","_____ ");
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s","      ");
    print_line = 0;
    print_line = space_or_line(d_prt_test_15_yn,worklist_ind[14][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s","_____ ");
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s","      ");
    print_line = 0;
	print_line = space_or_line(d_prt_test_16_yn,worklist_ind[15][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-5s","_____");
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-5s","     ");
	
   }
   else
   {
    print_line = 0;
    print_line = space_or_line(d_prt_test_17_yn,worklist_ind[16][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s","_____ ");
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s","      ");
    print_line = 0;
    print_line = space_or_line(d_prt_test_18_yn,worklist_ind[17][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s","_____ ");
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s","      ");
    print_line = 0;
    print_line = space_or_line(d_prt_test_19_yn,worklist_ind[18][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s","_____ ");
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s","      ");
    print_line = 0;
    print_line = space_or_line(d_prt_test_20_yn,worklist_ind[19][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s","_____ ");
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s","      ");
    print_line = 0;
    print_line = space_or_line(d_prt_test_21_yn,worklist_ind[20][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s","_____ ");
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s","      ");
    print_line = 0;
    print_line = space_or_line(d_prt_test_22_yn,worklist_ind[21][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s","_____ ");
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s","      ");
    print_line = 0;
    print_line = space_or_line(d_prt_test_23_yn,worklist_ind[22][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s","_____ ");
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s","      ");
    print_line = 0;
    print_line = space_or_line(d_prt_test_24_yn,worklist_ind[23][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s","_____ ");
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s","      ");
    print_line = 0;
    print_line = space_or_line(d_prt_test_25_yn,worklist_ind[24][0]);
    if(print_line  &&  test_ctr <= d_no_of_tests)
       fprintf(afp,"%-6s","_____ ");
    else
	   if (d_no_of_tests >= test_ctr)
          fprintf(afp,"%-6s","      ");
  }
  

}


/* ------------ P R I N T T E S T S --------*/
void print_all_tests(f1)
FILE *f1;
{

	int print_line = 0;
    int i=0,r=0;
	int p_count = 0;

    dclr_test_result_cur();
	
    while(fetch_test_result_cur())
    {
	   chk_break(1);
	   get_test_desc();
	   fprintf(f1,"    ");
/*** modified TEST NAME and TEST RESULT removed 22.10.2002   
       //fprintf(f1,"TEST NAME. %-40.40s ",d_tst_test_name.arr);
	   fprintf(f1,"%-10.10s %-40.40s ",local_legend[10],d_tst_test_name.arr);
	   //fprintf(f1,"TEST RESULT. ");
	   fprintf(f1,"%-12.12s ",local_legend[11]);
***/
       fprintf(f1,"%-52.52s",d_tst_test_name.arr);
	   fprintf(f1,": ");

//	   fprint_repeat(f1, '_', 10);
	   fprintf(f1, "%s", d_test_result.arr);
	   fprintf(f1,"\n");
	   line_no++;
// added 30.09.2002
       if (result_comments_yn())
	   {
		   chk_break(1);
		   fprintf(f1,"               ");
		   //fprintf(f1,"Result Comments:\n");
		   fprintf(f1,"%-15.15s:\n",local_legend[13]);
		   line_no++;
		   if (result_comments_1_yn())
		   {
			   chk_break(1);
			   fprintf(f1,"               ");
			   //fprintf(f1,"Code:%-4.4s  Desc.:%-40.40s\n",d_comm_result1.arr,d_comm_result_desc1.arr);
			   fprintf(f1,"%-4.4s:%-4.4s  %-4.4s.:%-40.40s\n",local_legend[21],d_comm_result1.arr,local_legend[22],d_comm_result_desc1.arr);
			   line_no++;
		   }
		   if (result_comments_2_yn())
		   {
			   chk_break(1);
			   fprintf(f1,"               ");
			   //fprintf(f1,"Code:%-4.4s  Desc.:%-40.40s\n",d_comm_result2.arr,d_comm_result_desc2.arr);
			   fprintf(f1,"%-4.4s:%-4.4s  %-4.4s.:%-40.40s\n",local_legend[21],d_comm_result2.arr,local_legend[22],d_comm_result_desc2.arr);
			   line_no++;
		   }
		   if (result_comments_3_yn())
		   {
			   chk_break(1);
			   fprintf(f1,"               ");
			   //fprintf(f1,"Code:%-4.4s  Desc.:%-40.40s\n",d_comm_result3.arr,d_comm_result_desc3.arr);
			   fprintf(f1,"%-4.4s:%-4.4s  %-4.4s.:%-40.40s\n",local_legend[21],d_comm_result3.arr,local_legend[22],d_comm_result_desc3.arr);
			   line_no++;
		   }
		   if (result_comments_4_yn())
		   {
			   chk_break(1);
			   fprintf(f1,"               ");
			   //fprintf(f1,"Code:%-4.4s  Desc.:%-40.40s\n",d_comm_result4.arr,d_comm_result_desc4.arr);
			   fprintf(f1,"%-4.4s:%-4.4s  %-4.4s.:%-40.40s\n",local_legend[21],d_comm_result4.arr,local_legend[21],d_comm_result_desc4.arr);
			   line_no++;
		   }
	   }

	/*** Code added to check and Print the Previous results based on setup ***/

	if (strcmp(d_prv_result_yn.arr, "Y") == 0 )
	{
		/* EXEC SQL SELECT NVL(PERIOD_FOR_PAST_RESULTS,0),NVL(NO_OF_PAST_RESULTS,0),
		                PAST_RESULT_UNITS
				 INTO :d_past_result_period, :d_past_result_no, :d_past_result_unit
				 FROM RL_WORKLIST_FMT_DTL 
				 WHERE operating_facility_id = :nd_operating_facility_id
				 AND   section_code = :nd_section_code
				 AND   worklist_name = :nd_worklist_name
				 AND   test_code = :d_tst_test_code; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 74;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select NVL(PERIOD_FOR_PAST_RESULTS,0) ,NVL(NO_OF_PAST_RESUL\
TS,0) ,PAST_RESULT_UNITS into :b0,:b1,:b2  from RL_WORKLIST_FMT_DTL where (((o\
perating_facility_id=:b3 and section_code=:b4) and worklist_name=:b5) and test\
_code=:b6)";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2476;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_past_result_period;
  sqlstm.sqhstl[0] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_past_result_no;
  sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_past_result_unit;
  sqlstm.sqhstl[2] = (unsigned int  )8;
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
  sqlstm.sqhstv[4] = (         void  *)&nd_section_code;
  sqlstm.sqhstl[4] = (unsigned int  )4;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_worklist_name;
  sqlstm.sqhstl[5] = (unsigned int  )13;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_tst_test_code;
  sqlstm.sqhstl[6] = (unsigned int  )13;
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
}


		if (d_past_result_period)
		{
			if (strcmp(d_past_result_unit.arr, "YRS") == 0)
			{
				/* EXEC SQL SELECT TO_CHAR(ADD_MONTHS(TO_DATE(:d_spec_regd_date_time,'DD/MM/YYYY HH24:MI'), -12*:d_past_result_period),
					                    'DD/MM/YYYY HH24:MI')
						 INTO :nd_prv_result_dt
						FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 74;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_CHAR(ADD_MONTHS(TO_DATE(:b0,'DD/MM/YYYY HH24:MI\
'),((-12)* :b1)),'DD/MM/YYYY HH24:MI') into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2519;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_spec_regd_date_time;
    sqlstm.sqhstl[0] = (unsigned int  )19;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_past_result_period;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_prv_result_dt;
    sqlstm.sqhstl[2] = (unsigned int  )32;
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


			}
			if (strcmp(d_past_result_unit.arr, "MTHS") == 0)
			{
				/* EXEC SQL SELECT TO_CHAR(ADD_MONTHS(TO_DATE(:d_spec_regd_date_time,'DD/MM/YYYY HH24:MI'), -1*:d_past_result_period),
										'DD/MM/YYYY HH24:MI')
						 INTO :nd_prv_result_dt
						 FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 74;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_CHAR(ADD_MONTHS(TO_DATE(:b0,'DD/MM/YYYY HH24:MI\
'),((-1)* :b1)),'DD/MM/YYYY HH24:MI') into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2546;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_spec_regd_date_time;
    sqlstm.sqhstl[0] = (unsigned int  )19;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_past_result_period;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_prv_result_dt;
    sqlstm.sqhstl[2] = (unsigned int  )32;
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


			}
			if (strcmp(d_past_result_unit.arr, "WKS") == 0)
			{
				/* EXEC SQL SELECT TO_CHAR(TO_DATE(:d_spec_regd_date_time,'DD/MM/YYYY HH24:MI') - 7*:d_past_result_period, 'DD/MM/YYYY HH24:MI')
						 INTO :nd_prv_result_dt
						 FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 74;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_CHAR((TO_DATE(:b0,'DD/MM/YYYY HH24:MI')-(7* :b1\
)),'DD/MM/YYYY HH24:MI') into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2573;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_spec_regd_date_time;
    sqlstm.sqhstl[0] = (unsigned int  )19;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_past_result_period;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_prv_result_dt;
    sqlstm.sqhstl[2] = (unsigned int  )32;
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


			}
			if (strcmp(d_past_result_unit.arr, "DAY") == 0)
			{
				/* EXEC SQL SELECT TO_CHAR(TO_DATE(:d_spec_regd_date_time,'DD/MM/YYYY HH24:MI') - 1*:d_past_result_period, 'DD/MM/YYYY HH24:MI')
						 INTO :nd_prv_result_dt
						 FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 74;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_CHAR((TO_DATE(:b0,'DD/MM/YYYY HH24:MI')-(1* :b1\
)),'DD/MM/YYYY HH24:MI') into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2600;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_spec_regd_date_time;
    sqlstm.sqhstl[0] = (unsigned int  )19;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_past_result_period;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_prv_result_dt;
    sqlstm.sqhstl[2] = (unsigned int  )32;
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


			}
			if (strcmp(d_past_result_unit.arr, "HRS") == 0)
			{
				/* EXEC SQL SELECT TO_CHAR(TO_DATE(:d_spec_regd_date_time,'DD/MM/YYYY HH24:MI') - (1/24)*:d_past_result_period, 'DD/MM/YYYY HH24:MI')
						 INTO :nd_prv_result_dt
						 FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 74;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select TO_CHAR((TO_DATE(:b0,'DD/MM/YYYY HH24:MI')-((1/24)\
* :b1)),'DD/MM/YYYY HH24:MI') into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2627;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_spec_regd_date_time;
    sqlstm.sqhstl[0] = (unsigned int  )19;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_past_result_period;
    sqlstm.sqhstl[1] = (unsigned int  )sizeof(int);
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&nd_prv_result_dt;
    sqlstm.sqhstl[2] = (unsigned int  )32;
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


			}

			fprintf(f1,"    ");
			//fprintf(f1,"[Previous Results]\n");
			fprintf(f1,"[%-16.16s]\n",local_legend[12]);
			line_no++;

			/***
			nd_modified_dt.arr[0] = '\0';
			nd_modified_dt.len = 0;

			EXEC SQL SELECT TO_CHAR(MODIFIED_DATE,'DD/MM/YYYY HH24:MI') 
					 INTO :nd_modified_dt FROM RL_TEST_RESULT
					 WHERE patient_id = :d_prt_patient_id
					 AND specimen_no = TO_NUMBER(:d_prt_specimen_no)
					 AND OPERATING_FACILITY_ID = :nd_operating_facility_id
					 AND test_code = :d_tst_test_code;

			nd_modified_dt.arr[nd_modified_dt.len] = '\0';
            ***/
			
			dclr_test_result_prv_cur();
	
			while(fetch_test_result_prv_cur())
			{
					/***
					EXEC SQL SELECT TO_CHAR(spec_regd_date_time,'DD/MM/YYYY HH24:MI:SS') 
					         INTO :d_prv_specimen_regd_date
							 FROM RL_REQUEST_HEADER
							 WHERE specimen_no = :d_prv_specimen_no
							 AND   operating_facility_id = :nd_operating_facility_id;
					***/

				p_count++;

				chk_break(1);
				get_test_prv_desc();
				fprintf(f1,"    ");
				fprintf(f1,"%-20.20s  %-30.30s", d_prv_specimen_no.arr, d_prv_specimen_regd_date.arr);
				fprintf(f1,": ");
				fprintf(f1, "%s", d_test_prv_result.arr);
				fprintf(f1,"\n");
				line_no++;
			
				/*** Commented since result Comment is not required to get printed 
				     for Previous Results

				if (result_prv_comments_yn())
				{
					chk_break(1);
					fprintf(f1,"               ");
					//fprintf(f1,"Result Comments:\n");
					fprintf(f1,"%-15.15s:\n",local_legend[13]);
					line_no++;
					if (result_prv_comments_1_yn())
					{
						chk_break(1);
						fprintf(f1,"               ");
						fprintf(f1,"Code:%-4.4s  Desc.:%-40.40s\n",d_comm_prv_result1.arr,d_comm_prv_result_desc1.arr);
						
						line_no++;
					}
					if (result_prv_comments_2_yn())
					{
						chk_break(1);
						fprintf(f1,"               ");
						fprintf(f1,"Code:%-4.4s  Desc.:%-40.40s\n",d_comm_prv_result2.arr,d_comm_prv_result_desc2.arr);
						
						line_no++;
					}
					if (result_prv_comments_3_yn())
					{
						chk_break(1);
						fprintf(f1,"               ");
						fprintf(f1,"Code:%-4.4s  Desc.:%-40.40s\n",d_comm_prv_result3.arr,d_comm_prv_result_desc3.arr);
						line_no++;
					}
					if (result_prv_comments_4_yn())
					{
						chk_break(1);
						fprintf(f1,"               ");
						fprintf(f1,"Code:%-4.4s  Desc.:%-40.40s\n",d_comm_prv_result4.arr,d_comm_prv_result_desc4.arr);
						line_no++;
					}
				}
				***/

				if (p_count == d_past_result_no)
				{
					break;
				}
			}
		fprintf(f1,"\n");
		line_no++;
		}
	}

// upto here
    }

	chk_break(1);
    
    close_test_result_cur();
	return;
}


/*------------------ H E A D I N G ------------------*/
void prepare_heading(afp)
FILE *afp;
{

    int i = 0, j = 0, k = 0;
	char heading[60] ;
	int length = 0;

	sorting();

		
    total = 0;
	ctr   = 1;

	for(i=1;i<=21;i++)
	{
	 
	   k = i;

	   for (j=0;j<21;j++)
	   {
		
          		
	      if (num[j] == ctr) 
	      {

			  if ((j > 0) && (num[j - 1] == num[j]) > 0)
			  {

			      total = cou[j - 1] ;
				  str_len = strlen(word[j - 1])  ;
				  
			  }
			
			  if ((j > 0) && (num[j - 1] == num[j]) > 0)
			  {
			     fprintf(afp,"%*s",(cou[j]   - (total + str_len)),"");
  		         fprintf(afp,"%s", word[j]);
			  }
			  else
			  {
				fprintf(afp,"%*s", cou[j] - 1, "");
				fprintf(afp,"%s", word[j]);
			  }

			  k = j ;		   
			  str_len = 0;
			  
	      }

		  

      }

	   i = k;

	   if ((num[i] > 0) && (num[i] <= maxx))
	   {
		  
	  	  fprintf(afp, "\n");
		  fprint_repeat(f1, '_', 79);
		  fprintf(afp, "\n");
		  line_no += 2;
		  total = 0;
		  
 	    }

	   ctr = ctr + 1 ;

	}


	return ;
}


/*----------- S P A C I N G ------------*/
void spacing(afp)
FILE *afp;
{
	 
    for (i=0;i<d_line_spacing;i++)
      fprintf(afp,"\n");
}

/*-------------   Age of Patient in Years, Months, Days --------------*/

 void patient_age()
 {

		 float  lone = 0;
		 float  num1 = 0, yrs = 0, 
				tmp_mths = 0, 
				tmp_days = 0;

		 char st_r[50];

	/*today.arr[0] = '\0';
	today.len = 0;  --Commented by Durai Rajkumar for Age Calculation on 05-Feb-08*/

	mths.arr[0]  = '\0';
	mths.len  = 0;

	
	/*EXEC SQL SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') INTO :today
            FROM DUAL;  --Commented by Durai Rajkumar for Age Calculation on 05-Feb-08 */                                        

    /* EXEC SQL SELECT ABS(MONTHS_BETWEEN(
		/oTO_DATE(:today,'DD/MM/YYYY'),  --Commented by Durai Rajkumar for Age Calculation on 05-Feb-08o/ 
		TO_DATE(:d_l_spec_regd_date_time ,'DD/MM/YYYY'), /oAdded by Durai Rajkumar for Age Calculation on 05-Feb-08 o/
		TO_DATE(:d_date_of_birth, 'DD/MM/YYYY')))
			INTO :mt FROM DUAL; */ 

{
    struct sqlexd sqlstm;
    sqlstm.sqlvsn = 10;
    sqlstm.arrsiz = 74;
    sqlstm.sqladtp = &sqladt;
    sqlstm.sqltdsp = &sqltds;
    sqlstm.stmt = "select ABS(MONTHS_BETWEEN(TO_DATE(:b0,'DD/MM/YYYY'),TO_DA\
TE(:b1,'DD/MM/YYYY'))) into :b2  from DUAL ";
    sqlstm.iters = (unsigned int  )1;
    sqlstm.offset = (unsigned int  )2654;
    sqlstm.selerr = (unsigned short)1;
    sqlstm.cud = sqlcud0;
    sqlstm.sqlest = (unsigned char  *)&sqlca;
    sqlstm.sqlety = (unsigned short)256;
    sqlstm.occurs = (unsigned int  )0;
    sqlstm.sqhstv[0] = (         void  *)&d_l_spec_regd_date_time;
    sqlstm.sqhstl[0] = (unsigned int  )19;
    sqlstm.sqhsts[0] = (         int  )0;
    sqlstm.sqindv[0] = (         void  *)0;
    sqlstm.sqinds[0] = (         int  )0;
    sqlstm.sqharm[0] = (unsigned int  )0;
    sqlstm.sqadto[0] = (unsigned short )0;
    sqlstm.sqtdso[0] = (unsigned short )0;
    sqlstm.sqhstv[1] = (         void  *)&d_date_of_birth;
    sqlstm.sqhstl[1] = (unsigned int  )13;
    sqlstm.sqhsts[1] = (         int  )0;
    sqlstm.sqindv[1] = (         void  *)0;
    sqlstm.sqinds[1] = (         int  )0;
    sqlstm.sqharm[1] = (unsigned int  )0;
    sqlstm.sqadto[1] = (unsigned short )0;
    sqlstm.sqtdso[1] = (unsigned short )0;
    sqlstm.sqhstv[2] = (         void  *)&mt;
    sqlstm.sqhstl[2] = (unsigned int  )sizeof(float);
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



			sprintf(mths.arr,"%f",mt);
			strcpy(mths1.arr, mths.arr);

        	/*today.arr[today.len] = '\0';   --Commented by Durai Rajkumar for Age Calculation on 05-Feb-08*/
							
			lone = atoi(strtok(mths1.arr, ".")) ;

		   if (lone > 0) 
		   {
			  num1 = lone/12 ;
			  sprintf(t_age.arr, "%f", num1);
			  yrs = atoi(strtok(t_age.arr, ".")) ;
		   }
		   else
			  yrs = 0;
            
			tmp_mths   = atoi(mths1.arr) - (yrs * 12) ;
			sprintf(t_age.arr, "%f", tmp_mths);
			tmp_mths   = atoi(strtok(t_age.arr, "."));

			if ((tmp_mths == 0)  && (yrs ==0))
			{

				/*EXEC SQL SELECT TO_CHAR(ROUND((TO_DATE(:today,'DD/MM/YYYY') -      --Commented by Durai Rajkumar for Age Calculation on 05-Feb-08*/
					/* EXEC SQL SELECT TO_CHAR(ROUND((TO_DATE(:d_l_spec_regd_date_time,'DD/MM/YYYY') -  /oAdded by Durai Rajkumar for Age Calculation on 05-Feb-08 o/
					TO_DATE(:d_date_of_birth, 'DD/MM/YYYY')),3))
					INTO :t_days FROM DUAL; */ 

{
     struct sqlexd sqlstm;
     sqlstm.sqlvsn = 10;
     sqlstm.arrsiz = 74;
     sqlstm.sqladtp = &sqladt;
     sqlstm.sqltdsp = &sqltds;
     sqlstm.stmt = "select TO_CHAR(ROUND((TO_DATE(:b0,'DD/MM/YYYY')-TO_DATE(\
:b1,'DD/MM/YYYY')),3)) into :b2  from DUAL ";
     sqlstm.iters = (unsigned int  )1;
     sqlstm.offset = (unsigned int  )2681;
     sqlstm.selerr = (unsigned short)1;
     sqlstm.cud = sqlcud0;
     sqlstm.sqlest = (unsigned char  *)&sqlca;
     sqlstm.sqlety = (unsigned short)256;
     sqlstm.occurs = (unsigned int  )0;
     sqlstm.sqhstv[0] = (         void  *)&d_l_spec_regd_date_time;
     sqlstm.sqhstl[0] = (unsigned int  )19;
     sqlstm.sqhsts[0] = (         int  )0;
     sqlstm.sqindv[0] = (         void  *)0;
     sqlstm.sqinds[0] = (         int  )0;
     sqlstm.sqharm[0] = (unsigned int  )0;
     sqlstm.sqadto[0] = (unsigned short )0;
     sqlstm.sqtdso[0] = (unsigned short )0;
     sqlstm.sqhstv[1] = (         void  *)&d_date_of_birth;
     sqlstm.sqhstl[1] = (unsigned int  )13;
     sqlstm.sqhsts[1] = (         int  )0;
     sqlstm.sqindv[1] = (         void  *)0;
     sqlstm.sqinds[1] = (         int  )0;
     sqlstm.sqharm[1] = (unsigned int  )0;
     sqlstm.sqadto[1] = (unsigned short )0;
     sqlstm.sqtdso[1] = (unsigned short )0;
     sqlstm.sqhstv[2] = (         void  *)&t_days;
     sqlstm.sqhstl[2] = (unsigned int  )32;
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



					tmp_days = atoi(strtok(t_days.arr,"."));
			}
			else
				tmp_days = (atof(mths.arr) - atoi(mths1.arr)) * 31 ;
				
			sprintf(st_r, "%f", yrs);
			strcpy(t_age.arr, strtok(st_r, "."));
			sprintf(st_r, " %f", tmp_mths);
			strcat(t_age.arr, strtok(st_r, "."));
			sprintf(st_r, " %f", tmp_days);
			strcat(t_age.arr, strtok(st_r, "."));
				
 }

/*----------------------------------------------------------------------------*/
print_title()
{
	int l_pos = 0;
	int l_rem_pos = 0;
	int l_len = 0;
	int l_page_pos = 0;
	char l_string[100];
	int page_pos = 0;


	
	line_no = 0;

	/**** first line ***********/	
	fprintf(f1,"\n");
	l_pos = (int)(((80 - d_acc_entity_name.len)/2));
	sprintf(string_var, "%-*s%s", l_pos, " ", 
						d_acc_entity_name.arr);
	fprintf(f1, "%s\n", string_var);


	/**** second line ***********/	
	l_rem_pos = 68 - 22;
	l_len = 22 + l_rem_pos + d_acc_entity_name.len;
	l_page_pos = 62 - l_len;    /*changed to print page number within 80 char (25/06/2002) */

	get_date_time();

//	sprintf(string_var, "RUN DATE : %-10.10s%-*s%s%-*sPAGE NO. %d", d_curr_date.arr,l_rem_pos, " ", 
//						d_acc_entity_name.arr, l_page_pos, " ", page_no);

	//sprintf(string_var, "RUN DATE : %-10.10s%-*sPAGE NO. %d", d_curr_date.arr,l_rem_pos, " ", 
	//					page_no);

	//Added by babu for globalization

	rec_len = strlen(local_legend[1]);
	page_pos = 80-(rec_len + 6);
	rec_len = strlen(local_legend[23]);
    page_pos = page_pos -(rec_len + 6 + 10);
	        /* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				
				BEGIN
				t_date:=GET_LOCALE_DATE.GET_CURRENT_DATE(:language_id);
				:d_curr_date1 := to_char(t_date,'DD/MM/YYYY HH24:MI');
				END;
			END-EXEC; */ 

{
         struct sqlexd sqlstm;
         sqlstm.sqlvsn = 10;
         sqlstm.arrsiz = 74;
         sqlstm.sqladtp = &sqladt;
         sqlstm.sqltdsp = &sqltds;
         sqlstm.stmt = "declare t_date date ; BEGIN t_date := GET_LOCALE_DAT\
E . GET_CURRENT_DATE ( :language_id ) ; :d_curr_date1 := to_char ( t_date , 'D\
D/MM/YYYY HH24:MI' ) ; END ;";
         sqlstm.iters = (unsigned int  )1;
         sqlstm.offset = (unsigned int  )2708;
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
         sqlstm.sqhstv[1] = (         void  *)&d_curr_date1;
         sqlstm.sqhstl[1] = (unsigned int  )13;
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




	sprintf(string_var, "%s : %-10.10s%-*s%s : %d",local_legend[23], d_curr_date1.arr,page_pos, " ",local_legend[1], page_no++);
	fprintf(f1, "%s\n", string_var);


	/**** Third line ***********/	
	/*****************COMMENTED BY BABU FOR GLOBALIZATION
	l_rem_pos = l_pos - 7;
	strcpy(l_string, "DEPT OF ");
	strcat(l_string, d_section_name.arr);
	sprintf(string_var, "RUN TIME : %-5.5s%-*s%s", d_curr_time.arr, l_rem_pos, " ", 
				l_string);
				****************END ********************/

	strcpy(l_string, local_legend[24]);
	strcat(l_string, " ");
	strcat(l_string, d_section_name.arr);
	sprintf(string_var, "%s : %-5.5s  %s",local_legend[25], d_curr_time.arr,  
				l_string);

	fprintf(f1, "%s\n", string_var);

	/**** Fourth line ***********/	
	/**************commented by babu for globalization
	sprintf(string_var, "Worklist Name:%s    Date:%s    Worklist No:%d", nd_worklist_name.arr, 
							nd_worklist_date.arr, nd_worklist_no);
	l_pos = (int)(((80 - strlen(string_var))/2) - 1);

	
	fprintf(f1, "%-*s%s\n", l_pos, " ", string_var);

	fprintf(f1, "%-10.10s/%-5.5s/%s\n", d_added_date.arr, d_added_time.arr, d_added_by_id.arr);
	*****************end***************/
	/********Addded by babu***************/
	        
		/* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				
				BEGIN
				GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:nd_worklist_date,'DD/MM/YYYY'), :language_id , t_date);
				
				:nd_worklist_date1 := to_char(t_date,'DD/MM/YYYY');
				END;
			END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 74;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CONVERT_TO_LO\
CALE_DATE ( to_date ( :nd_worklist_date , 'DD/MM/YYYY' ) , :language_id , t_da\
te ) ; :nd_worklist_date1 := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2731;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&nd_worklist_date;
  sqlstm.sqhstl[0] = (unsigned int  )13;
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
  sqlstm.sqhstv[2] = (         void  *)&nd_worklist_date1;
  sqlstm.sqhstl[2] = (unsigned int  )13;
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



		//End
/*****************end************************/   
	
	sprintf(string_var, "%-13.13s:%s    %-4.4s:%s    %-15.15s:%d",local_legend[26] ,nd_worklist_name.arr, 
						local_legend[4],	nd_worklist_date1.arr,local_legend[3] ,nd_worklist_no);
	l_pos = (int)(((80 - strlen(string_var))/2) - 1);

	fprintf(f1, "%-*s%s\n", l_pos, " ", string_var);

	/********Addded by babu***************/
	        
		/* EXEC SQL EXECUTE
				DECLARE
				t_date   date;
				
				BEGIN
				GET_LOCALE_DATE.CONVERT_TO_LOCALE_DATE (to_date(:d_added_date,'DD/MM/YYYY'), :language_id , t_date);
				
				:d_added_date1 := to_char(t_date,'DD/MM/YYYY');
				END;
			END-EXEC; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 74;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "declare t_date date ; BEGIN GET_LOCALE_DATE . CONVERT_TO_LO\
CALE_DATE ( to_date ( :d_added_date , 'DD/MM/YYYY' ) , :language_id , t_date )\
 ; :d_added_date1 := to_char ( t_date , 'DD/MM/YYYY' ) ; END ;";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2758;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_added_date;
  sqlstm.sqhstl[0] = (unsigned int  )23;
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
  sqlstm.sqhstv[2] = (         void  *)&d_added_date1;
  sqlstm.sqhstl[2] = (unsigned int  )23;
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



		//End
/*****************end************************/   
	
	
	fprintf(f1, "%-10.10s/%-5.5s/%s\n", d_added_date1.arr, d_added_time.arr, d_added_by_id.arr);


	fprint_repeat(f1, '_', 79);
	fprintf(f1, "\n");

	line_no = 6;

}
/*----------------------------------------------------------------------------*/
fprint_repeat(l_fp,l_prn_chr,l_no)
FILE *l_fp;
char l_prn_chr;
int  l_no;
{
   int l_i = 0;

   for (l_i = 0;l_i < l_no;l_i++)
        fputc(l_prn_chr,l_fp);
}
/*-----------------------------------------------------*/

print_quality_hdr()
{
/**********************************commented for globalization
	fprintf(f1, "CUP#");
	fprintf(f1, "     QC");
	fprintf(f1, "            LOT#\n");
	fprintf(f1, "         EXPIRY DATE\n");
	fprintf(f1, "         QC RANGE\n\n");
	fprintf(f1, "         QC RESULT\n");
	*****************************end*********************/

		fprintf(f1, "%-3.3s#",local_legend[14]);
	fprintf(f1, "     %-2.23s",local_legend[15]);
	fprintf(f1, "            %-3.3s#\n,local_legend[16]");
	fprintf(f1, "         %-11.11s\n",local_legend[17]);
	fprintf(f1, "         %-8.8s\n\n",local_legend[18]);
	fprintf(f1, "         %-10.10s\n",local_legend[19]);


//	fprint_repeat(f1, '_', 79);
//	fprintf(f1, "\n");
	line_no += 4;
}
/*-----------------------------------------------------*/
chk_break(int nol, char l_char)
{
	if((line_no + nol) >= MAX_LINES) 
	{
       line_no = 1;
	   fprintf(f1, "\f");
	
	   print_title();	   
	   prepare_heading(f1);
	   
 	}
}

/*-----------------------------------------------------*/
dclr_spec_test_dtl_cur()
{
	/* EXEC SQL DECLARE spec_test_dtl_cur CURSOR FOR
		SELECT test_code
		FROM RL_REQUEST_DETAIL 
		WHERE patient_id = :d_prt_patient_id
		AND specimen_no = TO_NUMBER(:d_prt_specimen_no)
		AND operating_facility_id = :nd_operating_facility_id
		ORDER BY line_no; */ 


	/* EXEC SQL OPEN spec_test_dtl_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 74;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0082;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2785;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_prt_patient_id;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_prt_specimen_no;
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


}
/*-----------------------------------------------------*/
fetch_spec_test_dtl_cur()
{
	d_test_code.arr[0] = '\0';
	d_test_code.len	   = 0;

	/* EXEC SQL FETCH spec_test_dtl_cur
	INTO d_test_code; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 74;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2812;
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



	d_test_code.arr[d_test_code.len] = '\0';

	return (LAST_ROW?0:1);
}
/*-----------------------------------------------------*/
print_spec_tests()
{
	dclr_spec_test_dtl_cur();
	
	strcpy(print_temp_line ,"");
	strcpy(print_test_line, "");

	while(fetch_spec_test_dtl_cur())
	{

		strcpy(print_temp_line, d_test_code.arr);
		
		if (strlen(print_test_line) > 61)
			break;
		else
			if (strlen(print_test_line) == 0 ) 
			{
				strcpy(print_test_line, print_temp_line);
			}
			else
			{
				strcat(print_test_line, ",");
				strcat(print_test_line, print_temp_line);
			}
	}
	chk_break(1);
	fprintf(f1,"\n");
	line_no++;
	//fprintf(f1,"Requested Tests : ");
	fprintf(f1,"%-15.15s : ",local_legend[20]);
	fprintf(f1, print_test_line);
	line_no++;
	fprintf(f1,"\n");
	line_no++;
	
	close_spec_test_dtl_cur();
	return;
}
/*-----------------------------------------------------*/
close_spec_test_dtl_cur()
{
	/* EXEC SQL CLOSE spec_test_dtl_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 74;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2831;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}


}

/*-----------------------------------------------------*/
dclr_test_result_cur()
{
// modified 30.09.2002 result comments also taken

    /* EXEC SQL DECLARE test_result_cur CURSOR FOR
         SELECT A.test_code, A.numeric_result, A.numeric_prefix, 
				A.result_comment_code1, A.result_comment_code2,
				A.result_comment_code3, A.result_comment_code4,
				A.status,
				A.result_comment_desc1, A.result_comment_desc2,
				A.result_comment_desc3, A.result_comment_desc4
           FROM RL_TEST_RESULT A, RL_WORKLIST_FMT_DTL B
           WHERE A.patient_id = :d_prt_patient_id
	       AND A.specimen_no = TO_NUMBER(:d_prt_specimen_no)
		   AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
		   AND B.section_code = :nd_section_code
		   AND B.worklist_name = :nd_worklist_name
		   AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id
		   AND A.test_code = B.test_code
           ORDER BY B.seq_no; */ 


	/* EXEC SQL OPEN test_result_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 74;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0083;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2846;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_prt_patient_id;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_prt_specimen_no;
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
 sqlstm.sqhstv[3] = (         void  *)&nd_section_code;
 sqlstm.sqhstl[3] = (unsigned int  )4;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_worklist_name;
 sqlstm.sqhstl[4] = (unsigned int  )13;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[5] = (unsigned int  )5;
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
}



}

/*** Cursor declared to get the previous results of the Test Code  in the work List ***/
dclr_test_result_prv_cur()
{

    /* EXEC SQL DECLARE test_result_prv_cur CURSOR FOR
         SELECT TO_CHAR(A.specimen_no), A.test_code, A.numeric_result, A.numeric_prefix, 
				A.result_comment_code1, A.result_comment_code2,
				A.result_comment_code3, A.result_comment_code4,
				A.status,
				A.result_comment_desc1, A.result_comment_desc2,
				A.result_comment_desc3, A.result_comment_desc4,
				TO_CHAR(D.spec_regd_date_time,'DD/MM/YYYY HH24:MI:SS')
           FROM RL_TEST_RESULT A, RL_WORKLIST_FMT_DTL B, RL_WORKLIST_DTL C,
		        RL_REQUEST_HEADER D
           WHERE A.patient_id = :d_prt_patient_id
		   AND A.patient_id = D.patient_id
	       AND A.specimen_no = c.specimen_no
		   AND A.specimen_no = D.specimen_no
		   AND A.specimen_no != TO_NUMBER(:d_prt_specimen_no)
		   AND A.OPERATING_FACILITY_ID = :nd_operating_facility_id
		   AND B.section_code = :nd_section_code
		   AND B.worklist_name = :nd_worklist_name
		   AND B.OPERATING_FACILITY_ID = :nd_operating_facility_id
		   AND A.test_code = B.test_code
		   AND A.test_code = :d_tst_test_code
           AND NVL(A.reviewed_date,TO_DATE(:d_spec_regd_date_time,'DD/MM/YYYY HH24:MI')) >= 
		       TO_DATE(:nd_prv_result_dt,'DD/MM/YYYY HH24:MI')
		   AND D.spec_regd_date_time < TO_DATE(:d_spec_regd_date_time,'DD/MM/YYYY HH24:MI')
		   ORDER BY A.reviewed_date desc; */ 


	/* EXEC SQL OPEN test_result_prv_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 74;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = sq0084;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )2885;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_prt_patient_id;
 sqlstm.sqhstl[0] = (unsigned int  )33;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_prt_specimen_no;
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
 sqlstm.sqhstv[3] = (         void  *)&nd_section_code;
 sqlstm.sqhstl[3] = (unsigned int  )4;
 sqlstm.sqhsts[3] = (         int  )0;
 sqlstm.sqindv[3] = (         void  *)0;
 sqlstm.sqinds[3] = (         int  )0;
 sqlstm.sqharm[3] = (unsigned int  )0;
 sqlstm.sqadto[3] = (unsigned short )0;
 sqlstm.sqtdso[3] = (unsigned short )0;
 sqlstm.sqhstv[4] = (         void  *)&nd_worklist_name;
 sqlstm.sqhstl[4] = (unsigned int  )13;
 sqlstm.sqhsts[4] = (         int  )0;
 sqlstm.sqindv[4] = (         void  *)0;
 sqlstm.sqinds[4] = (         int  )0;
 sqlstm.sqharm[4] = (unsigned int  )0;
 sqlstm.sqadto[4] = (unsigned short )0;
 sqlstm.sqtdso[4] = (unsigned short )0;
 sqlstm.sqhstv[5] = (         void  *)&nd_operating_facility_id;
 sqlstm.sqhstl[5] = (unsigned int  )5;
 sqlstm.sqhsts[5] = (         int  )0;
 sqlstm.sqindv[5] = (         void  *)0;
 sqlstm.sqinds[5] = (         int  )0;
 sqlstm.sqharm[5] = (unsigned int  )0;
 sqlstm.sqadto[5] = (unsigned short )0;
 sqlstm.sqtdso[5] = (unsigned short )0;
 sqlstm.sqhstv[6] = (         void  *)&d_tst_test_code;
 sqlstm.sqhstl[6] = (unsigned int  )13;
 sqlstm.sqhsts[6] = (         int  )0;
 sqlstm.sqindv[6] = (         void  *)0;
 sqlstm.sqinds[6] = (         int  )0;
 sqlstm.sqharm[6] = (unsigned int  )0;
 sqlstm.sqadto[6] = (unsigned short )0;
 sqlstm.sqtdso[6] = (unsigned short )0;
 sqlstm.sqhstv[7] = (         void  *)&d_spec_regd_date_time;
 sqlstm.sqhstl[7] = (unsigned int  )19;
 sqlstm.sqhsts[7] = (         int  )0;
 sqlstm.sqindv[7] = (         void  *)0;
 sqlstm.sqinds[7] = (         int  )0;
 sqlstm.sqharm[7] = (unsigned int  )0;
 sqlstm.sqadto[7] = (unsigned short )0;
 sqlstm.sqtdso[7] = (unsigned short )0;
 sqlstm.sqhstv[8] = (         void  *)&nd_prv_result_dt;
 sqlstm.sqhstl[8] = (unsigned int  )32;
 sqlstm.sqhsts[8] = (         int  )0;
 sqlstm.sqindv[8] = (         void  *)0;
 sqlstm.sqinds[8] = (         int  )0;
 sqlstm.sqharm[8] = (unsigned int  )0;
 sqlstm.sqadto[8] = (unsigned short )0;
 sqlstm.sqtdso[8] = (unsigned short )0;
 sqlstm.sqhstv[9] = (         void  *)&d_spec_regd_date_time;
 sqlstm.sqhstl[9] = (unsigned int  )19;
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
}



}

/*-----------------------------------------------------*/
fetch_test_result_cur()
{

  d_tst_test_code.arr[0]		= '\0';
  d_tst_test_code.len			= 0;
  
  d_tst_numeric_result.arr[0]	= '\0';
  d_tst_numeric_result.len		= 0;

  d_num_prefix.arr[0]			= '\0';
  d_num_prefix.len				= 0;

  d_comm_result1.arr[0]			= '\0';
  d_comm_result1.len			= 0;
  d_comm_result2.arr[0]			= '\0';
  d_comm_result2.len			= 0;
  d_comm_result3.arr[0]			= '\0';
  d_comm_result3.len			= 0;
  d_comm_result4.arr[0]			= '\0';
  d_comm_result4.len			= 0;
  d_status.arr[0]				= '\0';
  d_status.len					= 0;
//added following 30.09.2002
  d_comm_result_desc1.arr[0]			= '\0';
  d_comm_result_desc1.len			= 0;
  d_comm_result_desc2.arr[0]			= '\0';
  d_comm_result_desc2.len			= 0;
  d_comm_result_desc3.arr[0]			= '\0';
  d_comm_result_desc3.len			= 0;
  d_comm_result_desc4.arr[0]			= '\0';
  d_comm_result_desc4.len			= 0;
// upto here

  /* EXEC SQL FETCH test_result_cur
		   INTO :d_tst_test_code,
				:d_tst_numeric_result,
				:d_num_prefix,
				:d_comm_result1,
				:d_comm_result2,
				:d_comm_result3,
				:d_comm_result4,
				:d_status,
				:d_comm_result_desc1,
				:d_comm_result_desc2,
				:d_comm_result_desc3,
				:d_comm_result_desc4; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 74;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )2940;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_tst_test_code;
  sqlstm.sqhstl[0] = (unsigned int  )13;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_tst_numeric_result;
  sqlstm.sqhstl[1] = (unsigned int  )18;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_num_prefix;
  sqlstm.sqhstl[2] = (unsigned int  )4;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_comm_result1;
  sqlstm.sqhstl[3] = (unsigned int  )18;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_comm_result2;
  sqlstm.sqhstl[4] = (unsigned int  )18;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_comm_result3;
  sqlstm.sqhstl[5] = (unsigned int  )18;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_comm_result4;
  sqlstm.sqhstl[6] = (unsigned int  )18;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_status;
  sqlstm.sqhstl[7] = (unsigned int  )4;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_comm_result_desc1;
  sqlstm.sqhstl[8] = (unsigned int  )43;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_comm_result_desc2;
  sqlstm.sqhstl[9] = (unsigned int  )43;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_comm_result_desc3;
  sqlstm.sqhstl[10] = (unsigned int  )43;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_comm_result_desc4;
  sqlstm.sqhstl[11] = (unsigned int  )43;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
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



  d_tst_numeric_result.arr[d_tst_numeric_result.len]	= '\0';
  d_tst_test_code.arr[d_tst_test_code.len]				= '\0';
  d_num_prefix.arr[d_num_prefix.len]					= '\0';
  d_comm_result1.arr[d_comm_result1.len]	 			= '\0';
  d_comm_result2.arr[d_comm_result2.len]	 			= '\0';
  d_comm_result3.arr[d_comm_result3.len]	 			= '\0';
  d_comm_result4.arr[d_comm_result4.len]	 			= '\0';
  d_status.arr[d_status.len]							= '\0';
// added 30.09.2002
  d_comm_result_desc1.arr[d_comm_result_desc1.len]	 			= '\0';
  d_comm_result_desc2.arr[d_comm_result_desc2.len]	 			= '\0';
  d_comm_result_desc3.arr[d_comm_result_desc3.len]	 			= '\0';
  d_comm_result_desc4.arr[d_comm_result_desc4.len]	 			= '\0';
//upto here




  d_test_result.arr[0] = '\0';
  d_test_result.len    = 0;

  if(strlen(d_tst_numeric_result.arr))
  {
	 if (strlen(d_num_prefix.arr))
	 {
		strcpy(d_test_result.arr, d_num_prefix.arr);
		d_test_result.len = strlen(d_test_result.arr);
		strcat(d_test_result.arr,d_tst_numeric_result.arr);
	 }
	 else
	 {
		strcpy(d_test_result.arr,d_tst_numeric_result.arr);
	 }
  }
/* commented 30.09.2002,since the result comments to be shown seperately
  else
  {
	 if (strlen(d_comm_result1.arr))
		strcpy(d_test_result.arr,d_comm_result1.arr);
	 else if (strlen(d_comm_result2.arr))
		strcpy(d_test_result.arr,d_comm_result2.arr);
 	 else if (strlen(d_comm_result3.arr))
		strcpy(d_test_result.arr,d_comm_result3.arr);
 	 else if (strlen(d_comm_result4.arr))
		strcpy(d_test_result.arr,d_comm_result4.arr);

  }
*/
  d_test_result.len = strlen(d_test_result.arr);


   return (LAST_ROW?0:1);
}

/*** Added to fetch the Previous results for the Work List ***/

fetch_test_result_prv_cur()
{
  d_prv_specimen_no.arr[0]          = '\0';
  d_prv_specimen_no.len				= 0;

  d_tst_prv_test_code.arr[0]		= '\0';
  d_tst_prv_test_code.len			= 0;
  
  d_tst_prv_numeric_result.arr[0]	= '\0';
  d_tst_prv_numeric_result.len		= 0;

  d_num_prv_prefix.arr[0]			= '\0';
  d_num_prv_prefix.len				= 0;

  d_comm_prv_result1.arr[0]			= '\0';
  d_comm_prv_result1.len			= 0;
  d_comm_prv_result2.arr[0]			= '\0';
  d_comm_prv_result2.len			= 0;
  d_comm_prv_result3.arr[0]			= '\0';
  d_comm_prv_result3.len			= 0;
  d_comm_prv_result4.arr[0]			= '\0';
  d_comm_prv_result4.len			= 0;
  d_status_prv.arr[0]				= '\0';
  d_status_prv.len					= 0;

  d_comm_prv_result_desc1.arr[0]		= '\0';
  d_comm_prv_result_desc1.len			= 0;
  d_comm_prv_result_desc2.arr[0]		= '\0';
  d_comm_prv_result_desc2.len			= 0;
  d_comm_prv_result_desc3.arr[0]		= '\0';
  d_comm_prv_result_desc3.len			= 0;
  d_comm_prv_result_desc4.arr[0]		= '\0';
  d_comm_prv_result_desc4.len			= 0;

  d_prv_specimen_regd_date.arr[0]       = '\0';
  d_prv_specimen_regd_date.len          = 0;

// upto here

  /* EXEC SQL FETCH test_result_prv_cur
		   INTO :d_prv_specimen_no,	
				:d_tst_prv_test_code,
				:d_tst_prv_numeric_result,
				:d_num_prv_prefix,
				:d_comm_prv_result1,
				:d_comm_prv_result2,
				:d_comm_prv_result3,
				:d_comm_prv_result4,
				:d_status_prv,
				:d_comm_prv_result_desc1,
				:d_comm_prv_result_desc2,
				:d_comm_prv_result_desc3,
				:d_comm_prv_result_desc4,
				:d_prv_specimen_regd_date; */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 74;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3003;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_prv_specimen_no;
  sqlstm.sqhstl[0] = (unsigned int  )32;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_tst_prv_test_code;
  sqlstm.sqhstl[1] = (unsigned int  )13;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_tst_prv_numeric_result;
  sqlstm.sqhstl[2] = (unsigned int  )18;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_num_prv_prefix;
  sqlstm.sqhstl[3] = (unsigned int  )4;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_comm_prv_result1;
  sqlstm.sqhstl[4] = (unsigned int  )18;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&d_comm_prv_result2;
  sqlstm.sqhstl[5] = (unsigned int  )18;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&d_comm_prv_result3;
  sqlstm.sqhstl[6] = (unsigned int  )18;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&d_comm_prv_result4;
  sqlstm.sqhstl[7] = (unsigned int  )18;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&d_status_prv;
  sqlstm.sqhstl[8] = (unsigned int  )4;
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&d_comm_prv_result_desc1;
  sqlstm.sqhstl[9] = (unsigned int  )43;
  sqlstm.sqhsts[9] = (         int  )0;
  sqlstm.sqindv[9] = (         void  *)0;
  sqlstm.sqinds[9] = (         int  )0;
  sqlstm.sqharm[9] = (unsigned int  )0;
  sqlstm.sqadto[9] = (unsigned short )0;
  sqlstm.sqtdso[9] = (unsigned short )0;
  sqlstm.sqhstv[10] = (         void  *)&d_comm_prv_result_desc2;
  sqlstm.sqhstl[10] = (unsigned int  )43;
  sqlstm.sqhsts[10] = (         int  )0;
  sqlstm.sqindv[10] = (         void  *)0;
  sqlstm.sqinds[10] = (         int  )0;
  sqlstm.sqharm[10] = (unsigned int  )0;
  sqlstm.sqadto[10] = (unsigned short )0;
  sqlstm.sqtdso[10] = (unsigned short )0;
  sqlstm.sqhstv[11] = (         void  *)&d_comm_prv_result_desc3;
  sqlstm.sqhstl[11] = (unsigned int  )43;
  sqlstm.sqhsts[11] = (         int  )0;
  sqlstm.sqindv[11] = (         void  *)0;
  sqlstm.sqinds[11] = (         int  )0;
  sqlstm.sqharm[11] = (unsigned int  )0;
  sqlstm.sqadto[11] = (unsigned short )0;
  sqlstm.sqtdso[11] = (unsigned short )0;
  sqlstm.sqhstv[12] = (         void  *)&d_comm_prv_result_desc4;
  sqlstm.sqhstl[12] = (unsigned int  )43;
  sqlstm.sqhsts[12] = (         int  )0;
  sqlstm.sqindv[12] = (         void  *)0;
  sqlstm.sqinds[12] = (         int  )0;
  sqlstm.sqharm[12] = (unsigned int  )0;
  sqlstm.sqadto[12] = (unsigned short )0;
  sqlstm.sqtdso[12] = (unsigned short )0;
  sqlstm.sqhstv[13] = (         void  *)&d_prv_specimen_regd_date;
  sqlstm.sqhstl[13] = (unsigned int  )32;
  sqlstm.sqhsts[13] = (         int  )0;
  sqlstm.sqindv[13] = (         void  *)0;
  sqlstm.sqinds[13] = (         int  )0;
  sqlstm.sqharm[13] = (unsigned int  )0;
  sqlstm.sqadto[13] = (unsigned short )0;
  sqlstm.sqtdso[13] = (unsigned short )0;
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



  d_prv_specimen_no.arr[d_prv_specimen_no.len] = '\0';
  d_tst_prv_numeric_result.arr[d_tst_prv_numeric_result.len]	= '\0';
  d_tst_prv_test_code.arr[d_tst_prv_test_code.len]		= '\0';
  d_num_prv_prefix.arr[d_num_prv_prefix.len]			= '\0';
  d_comm_prv_result1.arr[d_comm_prv_result1.len]	 	= '\0';
  d_comm_prv_result2.arr[d_comm_prv_result2.len]	 	= '\0';
  d_comm_prv_result3.arr[d_comm_prv_result3.len]	 	= '\0';
  d_comm_prv_result4.arr[d_comm_prv_result4.len]	 	= '\0';
  d_status_prv.arr[d_status_prv.len]				= '\0';

  d_comm_prv_result_desc1.arr[d_comm_prv_result_desc1.len]	= '\0';
  d_comm_prv_result_desc2.arr[d_comm_prv_result_desc2.len]	= '\0';
  d_comm_prv_result_desc3.arr[d_comm_prv_result_desc3.len]	= '\0';
  d_comm_prv_result_desc4.arr[d_comm_prv_result_desc4.len]	= '\0';

  d_prv_specimen_regd_date.arr[d_prv_specimen_regd_date.len] = '\0';

//upto here

  d_test_prv_result.arr[0] = '\0';
  d_test_prv_result.len    = 0;

  if(strlen(d_tst_prv_numeric_result.arr))
  {
	 if (strlen(d_num_prv_prefix.arr))
	 {
		strcpy(d_test_prv_result.arr, d_num_prefix.arr);
		d_test_prv_result.len = strlen(d_test_result.arr);
		strcat(d_test_prv_result.arr,d_tst_prv_numeric_result.arr);
	 }
	 else
	 {
		strcpy(d_test_prv_result.arr,d_tst_prv_numeric_result.arr);
	 }
  }
  d_test_prv_result.len = strlen(d_test_prv_result.arr);

   return (LAST_ROW?0:1);
}

/*-----------------------------------------------------*/
close_test_result_cur()
{

	/* EXEC SQL CLOSE test_result_cur; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 74;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3074;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlcxt((void **)0, &sqlctx, &sqlstm, &sqlfpn);
}



}
/*-----------------------------------------------------*/
get_test_desc()
{
	d_tst_test_name.arr[0]	= '\0';
	d_tst_test_name.len		= 0;
	
	/* EXEC SQL SELECT long_desc
			 INTO :d_tst_test_name
			 FROM RL_TEST_CODE_LANG_VW
			 WHERE test_code = :d_tst_test_code
			 AND LANGUAGE_ID = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 74;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_desc into :b0  from RL_TEST_CODE_LANG_VW where (\
test_code=:b1 and LANGUAGE_ID=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3089;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_tst_test_name;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_tst_test_code;
 sqlstm.sqhstl[1] = (unsigned int  )13;
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


	
	d_tst_test_name.arr[d_tst_test_name.len]	= '\0';

	if (NODATAFOUND);


}

get_test_prv_desc()
{
	d_tst_prv_test_name.arr[0]	= '\0';
	d_tst_prv_test_name.len		= 0;
	
	/* EXEC SQL SELECT long_desc
			 INTO :d_tst_prv_test_name
			 FROM RL_TEST_CODE_LANG_VW
			 WHERE test_code = :d_tst_prv_test_code
			 AND   LANGUAGE_ID = :language_id; */ 

{
 struct sqlexd sqlstm;
 sqlstm.sqlvsn = 10;
 sqlstm.arrsiz = 74;
 sqlstm.sqladtp = &sqladt;
 sqlstm.sqltdsp = &sqltds;
 sqlstm.stmt = "select long_desc into :b0  from RL_TEST_CODE_LANG_VW where (\
test_code=:b1 and LANGUAGE_ID=:b2)";
 sqlstm.iters = (unsigned int  )1;
 sqlstm.offset = (unsigned int  )3116;
 sqlstm.selerr = (unsigned short)1;
 sqlstm.cud = sqlcud0;
 sqlstm.sqlest = (unsigned char  *)&sqlca;
 sqlstm.sqlety = (unsigned short)256;
 sqlstm.occurs = (unsigned int  )0;
 sqlstm.sqhstv[0] = (         void  *)&d_tst_prv_test_name;
 sqlstm.sqhstl[0] = (unsigned int  )43;
 sqlstm.sqhsts[0] = (         int  )0;
 sqlstm.sqindv[0] = (         void  *)0;
 sqlstm.sqinds[0] = (         int  )0;
 sqlstm.sqharm[0] = (unsigned int  )0;
 sqlstm.sqadto[0] = (unsigned short )0;
 sqlstm.sqtdso[0] = (unsigned short )0;
 sqlstm.sqhstv[1] = (         void  *)&d_tst_prv_test_code;
 sqlstm.sqhstl[1] = (unsigned int  )13;
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


	
	d_tst_prv_test_name.arr[d_tst_prv_test_name.len]	= '\0';

	if (NODATAFOUND);

}

/*-----------------------------------------------------*/
get_date_time()
{

  d_added_date.arr[0]		= '\0';
  d_added_date.len			= 0;
  d_added_time.arr[0]		= '\0';
  d_added_time.len			= 0;
  d_added_by_id.arr[0]		= '\0';
  d_added_by_id.len			= 0;
  d_curr_date.arr[0]		= '\0';
  d_curr_date.len			= 0;
  d_curr_time.arr[0]		= '\0';
  d_curr_time.len			= 0;

  /* EXEC SQL SELECT ADDED_BY_ID, TO_CHAR(added_date, 'DD/MM/YYYY'),
				TO_CHAR(added_date, 'HH24:MI'), TO_CHAR(SYSDATE, 'DD/MM/YYYY'), 
				TO_CHAR(SYSDATE, 'HH24:MI')
			INTO :d_added_by_id, :d_added_date, :d_added_time,
					:d_curr_date, :d_curr_time	
			FROM RL_WORKLIST_HDR
			WHERE OPERATING_FACILITY_ID = :nd_operating_facility_id
			AND SECTION_CODE  = :nd_section_code 
			AND WORKLIST_NAME = :nd_worklist_name
			AND WORKLIST_NO   = :nd_worklist_no
			AND WORKLIST_DATE = TO_DATE(:nd_worklist_date, 'DD/MM/YYYY'); */ 

{
  struct sqlexd sqlstm;
  sqlstm.sqlvsn = 10;
  sqlstm.arrsiz = 74;
  sqlstm.sqladtp = &sqladt;
  sqlstm.sqltdsp = &sqltds;
  sqlstm.stmt = "select ADDED_BY_ID ,TO_CHAR(added_date,'DD/MM/YYYY') ,TO_CH\
AR(added_date,'HH24:MI') ,TO_CHAR(SYSDATE,'DD/MM/YYYY') ,TO_CHAR(SYSDATE,'HH24\
:MI') into :b0,:b1,:b2,:b3,:b4  from RL_WORKLIST_HDR where ((((OPERATING_FACIL\
ITY_ID=:b5 and SECTION_CODE=:b6) and WORKLIST_NAME=:b7) and WORKLIST_NO=:b8) a\
nd WORKLIST_DATE=TO_DATE(:b9,'DD/MM/YYYY'))";
  sqlstm.iters = (unsigned int  )1;
  sqlstm.offset = (unsigned int  )3143;
  sqlstm.selerr = (unsigned short)1;
  sqlstm.cud = sqlcud0;
  sqlstm.sqlest = (unsigned char  *)&sqlca;
  sqlstm.sqlety = (unsigned short)256;
  sqlstm.occurs = (unsigned int  )0;
  sqlstm.sqhstv[0] = (         void  *)&d_added_by_id;
  sqlstm.sqhstl[0] = (unsigned int  )53;
  sqlstm.sqhsts[0] = (         int  )0;
  sqlstm.sqindv[0] = (         void  *)0;
  sqlstm.sqinds[0] = (         int  )0;
  sqlstm.sqharm[0] = (unsigned int  )0;
  sqlstm.sqadto[0] = (unsigned short )0;
  sqlstm.sqtdso[0] = (unsigned short )0;
  sqlstm.sqhstv[1] = (         void  *)&d_added_date;
  sqlstm.sqhstl[1] = (unsigned int  )23;
  sqlstm.sqhsts[1] = (         int  )0;
  sqlstm.sqindv[1] = (         void  *)0;
  sqlstm.sqinds[1] = (         int  )0;
  sqlstm.sqharm[1] = (unsigned int  )0;
  sqlstm.sqadto[1] = (unsigned short )0;
  sqlstm.sqtdso[1] = (unsigned short )0;
  sqlstm.sqhstv[2] = (         void  *)&d_added_time;
  sqlstm.sqhstl[2] = (unsigned int  )23;
  sqlstm.sqhsts[2] = (         int  )0;
  sqlstm.sqindv[2] = (         void  *)0;
  sqlstm.sqinds[2] = (         int  )0;
  sqlstm.sqharm[2] = (unsigned int  )0;
  sqlstm.sqadto[2] = (unsigned short )0;
  sqlstm.sqtdso[2] = (unsigned short )0;
  sqlstm.sqhstv[3] = (         void  *)&d_curr_date;
  sqlstm.sqhstl[3] = (unsigned int  )13;
  sqlstm.sqhsts[3] = (         int  )0;
  sqlstm.sqindv[3] = (         void  *)0;
  sqlstm.sqinds[3] = (         int  )0;
  sqlstm.sqharm[3] = (unsigned int  )0;
  sqlstm.sqadto[3] = (unsigned short )0;
  sqlstm.sqtdso[3] = (unsigned short )0;
  sqlstm.sqhstv[4] = (         void  *)&d_curr_time;
  sqlstm.sqhstl[4] = (unsigned int  )8;
  sqlstm.sqhsts[4] = (         int  )0;
  sqlstm.sqindv[4] = (         void  *)0;
  sqlstm.sqinds[4] = (         int  )0;
  sqlstm.sqharm[4] = (unsigned int  )0;
  sqlstm.sqadto[4] = (unsigned short )0;
  sqlstm.sqtdso[4] = (unsigned short )0;
  sqlstm.sqhstv[5] = (         void  *)&nd_operating_facility_id;
  sqlstm.sqhstl[5] = (unsigned int  )5;
  sqlstm.sqhsts[5] = (         int  )0;
  sqlstm.sqindv[5] = (         void  *)0;
  sqlstm.sqinds[5] = (         int  )0;
  sqlstm.sqharm[5] = (unsigned int  )0;
  sqlstm.sqadto[5] = (unsigned short )0;
  sqlstm.sqtdso[5] = (unsigned short )0;
  sqlstm.sqhstv[6] = (         void  *)&nd_section_code;
  sqlstm.sqhstl[6] = (unsigned int  )4;
  sqlstm.sqhsts[6] = (         int  )0;
  sqlstm.sqindv[6] = (         void  *)0;
  sqlstm.sqinds[6] = (         int  )0;
  sqlstm.sqharm[6] = (unsigned int  )0;
  sqlstm.sqadto[6] = (unsigned short )0;
  sqlstm.sqtdso[6] = (unsigned short )0;
  sqlstm.sqhstv[7] = (         void  *)&nd_worklist_name;
  sqlstm.sqhstl[7] = (unsigned int  )13;
  sqlstm.sqhsts[7] = (         int  )0;
  sqlstm.sqindv[7] = (         void  *)0;
  sqlstm.sqinds[7] = (         int  )0;
  sqlstm.sqharm[7] = (unsigned int  )0;
  sqlstm.sqadto[7] = (unsigned short )0;
  sqlstm.sqtdso[7] = (unsigned short )0;
  sqlstm.sqhstv[8] = (         void  *)&nd_worklist_no;
  sqlstm.sqhstl[8] = (unsigned int  )sizeof(int);
  sqlstm.sqhsts[8] = (         int  )0;
  sqlstm.sqindv[8] = (         void  *)0;
  sqlstm.sqinds[8] = (         int  )0;
  sqlstm.sqharm[8] = (unsigned int  )0;
  sqlstm.sqadto[8] = (unsigned short )0;
  sqlstm.sqtdso[8] = (unsigned short )0;
  sqlstm.sqhstv[9] = (         void  *)&nd_worklist_date;
  sqlstm.sqhstl[9] = (unsigned int  )13;
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
}



  d_added_by_id.arr[d_added_by_id.len]  = '\0';
  d_added_date.arr[d_added_date.len]	= '\0';
  d_added_time.arr[d_added_time.len]	= '\0';
  d_curr_date.arr[d_curr_date.len]		= '\0';
  d_curr_time.arr[d_curr_time.len]		= '\0';



}

#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER

#undef DEBUG
#undef NODATAFOUND
#undef MAX_LINES
#undef VER

/* ----------------added 30.09.2002 -------------------*/
int result_comments_yn()
{
	 if (strlen(d_comm_result1.arr) || strlen(d_comm_result2.arr) ||
	     strlen(d_comm_result3.arr) || strlen(d_comm_result4.arr) ||
		 strlen(d_comm_result_desc1.arr) || strlen(d_comm_result_desc2.arr) ||
		 strlen(d_comm_result_desc3.arr) || strlen(d_comm_result_desc4.arr))
         {
		 return 1;
		 }
	 else
	     return 0;	 	
}

int result_comments_1_yn()
{
	if (strlen(d_comm_result_desc1.arr))
	 {
	  return 1;
	 }
	else
	  return 0;
}
int result_comments_2_yn()
{
	if (strlen(d_comm_result_desc2.arr))
	 {
	  return 1;
	 }
	else
	  return 0;
}
int result_comments_3_yn()
{
	if (strlen(d_comm_result_desc3.arr))
	 {
	  return 1;
	 }
	else
	  return 0;
}
int result_comments_4_yn()
{
	if (strlen(d_comm_result_desc4.arr))
	 {
	  return 1;
	 }
	else
	  return 0;
}
/*----------------------------------upto here--------------*/

/*** Added to print the Previous Results Comments ***/

int result_prv_comments_yn()
{
	 if (strlen(d_comm_prv_result1.arr) || strlen(d_comm_prv_result2.arr) ||
	     strlen(d_comm_prv_result3.arr) || strlen(d_comm_prv_result4.arr) ||
		 strlen(d_comm_prv_result_desc1.arr) || strlen(d_comm_prv_result_desc2.arr) ||
		 strlen(d_comm_prv_result_desc3.arr) || strlen(d_comm_prv_result_desc4.arr))
         {
		 return 1;
		 }
	 else
	     return 0;	 	
}

int result_prv_comments_1_yn()
{
	if (strlen(d_comm_prv_result_desc1.arr))
	 {
	  return 1;
	 }
	else
	  return 0;
}
int result_prv_comments_2_yn()
{
	if (strlen(d_comm_prv_result_desc2.arr))
	 {
	  return 1;
	 }
	else
	  return 0;
}
int result_prv_comments_3_yn()
{
	if (strlen(d_comm_prv_result_desc3.arr))
	 {
	  return 1;
	 }
	else
	  return 0;
}
int result_prv_comments_4_yn()
{
	if (strlen(d_comm_prv_result_desc4.arr))
	 {
	  return 1;
	 }
	else
	  return 0;
}