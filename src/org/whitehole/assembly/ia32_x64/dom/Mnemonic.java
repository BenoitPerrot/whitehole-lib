// Generated, do not edit by hand
package org.whitehole.assembly.ia32_x64.dom;

public enum Mnemonic {
	INVALID,
	ADD,
	PUSH,
	POP,
	OR,
	ADC,
	SBB,
	AND,
	DAA,
	SUB,
	DAS,
	XOR,
	AAA,
	CMP,
	AAS,
	INC,
	DEC,
	PUSHA,
	POPA,
	BOUND,
	ARPL,
	MOVSXD,
	IMUL,
	INSB,
	INSW,
	OUTSB,
	OUTSW,
	JO,
	JNO,
	JB,
	JAE,
	JZ,
	JNZ,
	JBE,
	JA,
	JS,
	JNS,
	JP,
	JNP,
	JL,
	JGE,
	JLE,
	JG,
	TEST,
	XCHG,
	MOV,
	LEA,
	NOP,
	PAUSE,
	CBW,
	CWD,
	CALL,
	WAIT,
	PUSHFW,
	POPFW,
	SAHF,
	LAHF,
	MOVSB,
	MOVSW,
	CMPSB,
	CMPSW,
	STOSB,
	STOSW,
	LODSB,
	LODSW,
	SCASB,
	SCASW,
	RET,
	LES,
	LDS,
	ENTER,
	LEAVE,
	RETF,
	INT3,
	INT,
	INTO,
	IRETW,
	AAM,
	AAD,
	SALC,
	XLATB,
	LOOPNZ,
	LOOPE,
	LOOP,
	JRCXZ,
	IN,
	OUT,
	JMP,
	INT1,
	HLT,
	CMC,
	CLC,
	STC,
	CLI,
	STI,
	CLD,
	STD,
	LAR,
	LSL,
	SYSCALL,
	CLTS,
	SYSRET,
	INVD,
	WBINVD,
	UD2,
	VMOVUPS,
	VMOVUPD,
	VMOVSS,
	VMOVSD,
	VMOVLPS,
	VMOVLPD,
	VMOVSLDUP,
	VMOVDDUP,
	VUNPCKLPS,
	VUNPCKLPD,
	VUNPCKHPS,
	VUNPCKHPD,
	VMOVHPS,
	VMOVHPD,
	VMOVSHDUP,
	MOVHPS,
	MOVHPD,
	VMOVAPS,
	VMOVAPD,
	CVTPI2PS,
	CVTPI2PD,
	VCVTSI2SS,
	VCVTSI2SD,
	VMOVNTPS,
	VMOVNTPD,
	CVTTPS2PI,
	CVTTPD2PI,
	VCVTTSS2SI,
	VCVTTSD2SI,
	CVTPS2PI,
	CVTPD2PI,
	VCVTSS2SI,
	VCVTSD2SI,
	VUCOMISS,
	VUCOMISD,
	VCOMISS,
	VCOMISD,
	WRMSR,
	RDTSC,
	RDMSR,
	RDPMC,
	SYSENTER,
	SYSEXIT,
	GETSEC,
	CMOVO,
	CMOVNO,
	CMOVB,
	CMOVAE,
	CMOVZ,
	CMOVNZ,
	CMOVBE,
	CMOVA,
	CMOVS,
	CMOVNS,
	CMOVP,
	CMOVNP,
	CMOVL,
	CMOVGE,
	CMOVLE,
	CMOVG,
	VMOVMSKPS,
	VMOVMSKPD,
	VSQRTPS,
	VSQRTPD,
	VSQRTSS,
	VSQRTSD,
	VRSQRTPS,
	VRSQRTSS,
	VRCPPS,
	VRCPSS,
	VANDPS,
	VANDPD,
	VANDNPS,
	VANDNPD,
	VORPS,
	VORPD,
	VXORPS,
	VXORPD,
	VADDPS,
	VADDPD,
	VADDSS,
	VADDSD,
	VMULPS,
	VMULPD,
	VMULSS,
	VMULSD,
	VCVTPS2PD,
	VCVTPD2PS,
	VCVTSS2SD,
	VCVTSD2SS,
	VCVTDQ2PS,
	VCVTPS2DQ,
	VCVTTPS2DQ,
	VSUBPS,
	VSUBPD,
	VSUBSS,
	VSUBSD,
	VMINPS,
	VMINPD,
	VMINSS,
	VMINSD,
	VDIVPS,
	VDIVPD,
	VDIVSS,
	VDIVSD,
	VMAXPS,
	VMAXPD,
	VMAXSS,
	VMAXSD,
	PUNPCKLBW,
	VPUNPCKLBW,
	PUNPCKLWD,
	VPUNPCKLWD,
	PUNPCKLDQ,
	VPUNPCKLDQ,
	PACKSSWB,
	VPACKSSWB,
	PCMPGTB,
	VPCMPGTB,
	PCMPGTW,
	VPCMPGTW,
	PCMPGTD,
	VPCMPGTD,
	PACKUSWB,
	VPACKUSWB,
	PUNPCKHBW,
	VPUNPCKHBW,
	PUNPCKHWD,
	VPUNPCKHWD,
	PUNPCKHDQ,
	VPUNPCKHDQ,
	PACKSSDW,
	VPACKSSDW,
	VPUNPCKLQDQ,
	VPUNPCKHQDQ,
	MOVD,
	VMOVD,
	MOVQ,
	VMOVDQA,
	VMOVDQU,
	PSHUFW,
	VPSHUFD,
	VPSHUFHW,
	VPSHUFLW,
	PCMPEQB,
	VPCMPEQB,
	PCMPEQW,
	VPCMPEQW,
	PCMPEQD,
	VPCMPEQD,
	EMMS,
	VMREAD,
	VMWRITE,
	VHADDPD,
	VHADDPS,
	VHSUBPD,
	VHSUBPS,
	VMOVQ,
	SETO,
	SETNO,
	SETB,
	SETNB,
	SETZ,
	SETNZ,
	SETBE,
	SETA,
	SETS,
	SETNS,
	SETP,
	SETNP,
	SETL,
	SETGE,
	SETLE,
	SETG,
	CPUID,
	BT,
	SHLD,
	RSM,
	BTS,
	SHRD,
	CMPXCHG,
	LSS,
	BTR,
	LFS,
	LGS,
	MOVZX,
	JMPE,
	POPCNT,
	BTC,
	BSF,
	TZNCT,
	BSR,
	LZNCT,
	MOVSX,
	XADD,
	VCMPPS,
	VCMPPD,
	VCMPSS,
	VCMPSD,
	MOVNTI,
	PINSRW,
	PEXTRW,
	SHUFPS,
	SHUFPD,
	BSWAP,
	VADDSUBPD,
	VADDSUBPS,
	PSRLW,
	VPSRLW,
	PSRLD,
	VPSRLD,
	PSRLQ,
	VPSRLQ,
	PADDQ,
	VPADDQ,
	PMULLW,
	MOVQ2DQ,
	MOVDQ2Q,
	PMOVMSKB,
	PSUBUSB,
	VPSUBUSB,
	PSUBUSW,
	VPSUBUSW,
	PMINUB,
	VPMINUB,
	PAND,
	VPAND,
	PADDUSB,
	VPADDUSB,
	PADDUSW,
	VPADDUSW,
	PMAXUB,
	VPMAXUB,
	PANDN,
	VPANDN,
	PAVGB,
	VPAVGB,
	PSRAW,
	VPSRAW,
	PSRAD,
	VPSRAD,
	PAVGW,
	VPAVGW,
	PMULHUW,
	VPMULHUW,
	PMULHW,
	VPMULHW,
	VCVTTPD2DQ,
	VCVTDQ2PD,
	VCVTPD2DQ,
	MOVNTQ,
	MOVNTDQ,
	PSUBSB,
	VPSUBSB,
	PSUBSW,
	VPSUBSW,
	PMINSW,
	VPMINSW,
	POR,
	VPOR,
	PADDSB,
	VPADDSB,
	PADDSW,
	VPADDSW,
	PMAXSW,
	VPMAXSW,
	PXOR,
	VPXOR,
	VLDDQU,
	PSLLW,
	VPSLLW,
	PSLLD,
	VPSLLD,
	PSLLQ,
	VPSLLQ,
	PMULUDQ,
	VPMULUDQ,
	PMADDWD,
	VPMADDWD,
	PSADBW,
	VPSADBW,
	MASKMOVQ,
	VMASKMOVQ,
	PSUBB,
	VPSUBB,
	PSUBW,
	VPSUBW,
	PSUBD,
	VPSUBD,
	PSUBQ,
	VPSUBQ,
	PADDB,
	VPADDB,
	PADDW,
	VPADDW,
	PADDD,
	VPADDD,
	PSHUFB,
	VPSHUFB,
	PHADDW,
	VPHADDW,
	PHADDD,
	VPHADDD,
	PHADDSW,
	VPHADDSW,
	PMADDUBSW,
	VPMADDUBSW,
	PHSUBW,
	VPHSUBW,
	PHSUBD,
	VPHSUBD,
	PHSUBSW,
	VPHSUBSW,
	PSIGNB,
	VPSIGNB,
	PSIGNW,
	VPSIGNW,
	PSIGND,
	VPSIGND,
	PMULHRSW,
	VPMULHRSW,
	VPERMILPS,
	VPERMILPD,
	VTESTPS,
	VTESTPD,
	PBLENDVB,
	VCVTPH2PS,
	BLENDVPS,
	BLENDVPD,
	VPERMPS,
	VPTEST,
	VBROADCASTSS,
	VBROADCASTSD,
	VBROADCASTF128,
	PABSB,
	VPABSB,
	PABSW,
	VPABSW,
	PABSD,
	VPABSD,
	VPMOVSXBW,
	VPMOVSXBD,
	VPMOVSXBQ,
	VPMOVSXWD,
	VPMOVSXWQ,
	VPMOVSXDQ,
	VPMULDQ,
	VPCMPEQQ,
	VMOVNTDQA,
	VPACKUSDW,
	VMASKMOVPS,
	VMASKMOVPD,
	VPMOVZXBW,
	VPMOVZXBD,
	VPMOVZXBQ,
	VPMOVZXWD,
	VPMOVZXWQ,
	VPMOVZXDQ,
	VPERMD,
	VPCMPGTQ,
	VPMINSB,
	VPMINSD,
	VPMINUW,
	VPMINUD,
	VPMAXSB,
	VPMAXSD,
	VPMAXUW,
	VPMAXUD,
	VPMULLD,
	VPHMINPOSUW,
	VPSRLVD,
	VPSRAVD,
	VPSLLVD,
	VBROADCASTD,
	VBROADCASTQ,
	VBROADCASTI128,
	VPBROADCASTB,
	VPBROADCASTW,
	INVEPT,
	INVVPID,
	INVPCID,
	VPMASKMOVD,
	VGATHERDD,
	VGATHERQD,
	VGATHERDPS,
	VGATHERQPS,
	VFMADDSUB132PS,
	VFMSUBADD132PS,
	VFMADD132PS,
	VFMADD132SS,
	VFMSUB132PS,
	VFMSUB132SS,
	VFNMADD132PS,
	VFNMADD132SS,
	VFNMSUB132PS,
	VFNMSUB132SS,
	VFMADDSUB213PS,
	VFMSUBADD213PS,
	VFMADD213PS,
	VFMADD213SS,
	VFMSUB213PS,
	VFMSUB213SS,
	VFNMADD213PS,
	VFNMADD213SS,
	VFNMSUB213PS,
	VFNMSUB213SS,
	VFMADDSUB231,
	VFMSUBADD231,
	VFMADD231PS,
	VFMADD231SS,
	VFMSUB231PS,
	VFMSUB231SS,
	VFNMADD231PS,
	VFNMADD231SS,
	VFNMSUB231PS,
	VFNMSUB231SS,
	VAESIMC,
	VAESENC,
	VAESENCLAST,
	VAESDEC,
	VAESDECLAST,
	MOVBE,
	CRC32,
	ANDN,
	BZHI,
	PEXT,
	PEDP,
	ADCX,
	ADOX,
	MULX,
	BEXTR,
	SHLX,
	SARX,
	SHRX,
	VPERMQ,
	VPERMPD,
	VPBLENDD,
	VPERM2F128,
	VROUNDPS,
	VROUNDPD,
	VROUNDSS,
	VROUNDSD,
	VBLENDPS,
	VBLENDPD,
	VPBLENDW,
	PALIGNR,
	VPEXTRB,
	VPEXTRW,
	VPEXTRD_Q,
	VEXTRACTPS,
	VINSERTF128,
	VEXTRACTF128,
	VCVTPS2PH,
	VPINSRB,
	VINSERTPS,
	VPINSRD_Q,
	VDPPS,
	VDPPD,
	VMPSADBW,
	VPCLMULQDQ,
	VPERM2I128,
	VBLENDVPS,
	VBLENDVPD,
	VBLENDVB,
	VPCMPESTRM,
	VPCMPESTRI,
	VPCMPISTRM,
	VPCMPISTRI,
	AESKEYGEN,
	RORX,
	ROL,
	ROR,
	RCL,
	RCR,
	SHL,
	SHR,
	SAL,
	SAR,
	NOT,
	NEG,
	MUL,
	DIV,
	IDIV,
	SLDT,
	STR,
	LLDT,
	LTR,
	VERR,
	VERW,
	VMRESUME,
	SGDT,
	VMCALL,
	VMLAUNCH,
	VMXOFF,
	SIDT,
	MWAIT,
	MONITOR,
	INVLPG,
	SWAPGS,
	CMPXCHG8B,
	VMCLEAR,
	VMXON,
	VMPTRLD,
	VMPTRST,
	XABORT,
	XBEGIN,
	PSRLDQ,
	PSLLDQ,
	FXSAVE,
	RDFSBASE,
	FXRSTOR,
	RDGSBASE,
	LDMXCSR,
	WRFSBASE,
	STMXCSR,
	WRGSBASE,
	XSAVE,
	XRSTOR,
	LFENCE,
	XSAVEOPT,
	MFENCE,
	CLFLUSH,
	SFENCE,
	PREFETCHNTA,
	PREFETCHT0,
	PREFETCHT1,
	PREFETCHT2,
	BLSR,
	BLSMSK,
	BLSI,
	FADD,
	FMUL,
	FCOM,
	FCOMP,
	FSUB,
	FSUBR,
	FDIV,
	FDIVR,
	FLD,
	FXCH,
	FNOP,
	NONE,
	FCHS,
	FABS,
	FTST,
	FXAM,
	FLD1,
	FLDL2T,
	FLDL2E,
	FLDLPI,
	FLDLG2,
	FLDLN2,
	FLDZ,
	F2XM1,
	FYL2X,
	FPTAN,
	FPATAN,
	FPXTRACT,
	FPREM1,
	FDECSTP,
	FNCSTP,
	FPREM,
	FYL2XP1,
	FSQRT,
	FSINCOS,
	FRNDINT,
	FSCALE,
	FSIN,
	FCOS,
	FST,
	FSTP,
	FLDENV,
	FLDCW,
	FNSTENV,
	FNSTCW,
	FCMOVB,
	FCMOVE,
	FCMOVBE,
	FCMOVU,
	FUCOMPP,
	FIADD,
	FIMUL,
	FICOM,
	FICOMP,
	FISUB,
	FISUBR,
	FIDIV,
	FIDIVR,
	FCMOVNB,
	FCMOVNE,
	FCMOVNBE,
	FCMOVNU,
	FCLEX,
	FNINIT,
	FUCOMI,
	FCOMI,
	FILD,
	FISTTP,
	FIST,
	FISTP,
	FFREE,
	FUCOM,
	FUCOMP,
	FRSTOR,
	FNSAVE,
	FNSTSW,
	FADDP,
	FMULP,
	FCOMPP,
	FSUBRP,
	FSUBP,
	FDIVRP,
	FDIVP,
	FUCOMIP,
	FCOMIP,
	FBLD,
	FBSTP
}
