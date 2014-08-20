// Generated, do not edit by hand
package org.whitehole.assembly.ia32_x64.dom;
import org.whitehole.infra.types.BinaryWidth;

public enum RegisterName {
    AL,
    CL,
    DL,
    BL,
    AH,
    CH,
    DH,
    BH,
    SPL,
    BPL,
    SIL,
    DIL,
    R8B,
    R9B,
    R10B,
    R11B,
    R12B,
    R13B,
    R14B,
    R15B,
    AX,
    CX,
    DX,
    BX,
    SP,
    BP,
    SI,
    DI,
    R8W,
    R9W,
    R10W,
    R11W,
    R12W,
    R13W,
    R14W,
    R15W,
    EAX,
    ECX,
    EDX,
    EBX,
    ESP,
    EBP,
    ESI,
    EDI,
    R8D,
    R9D,
    R10D,
    R11D,
    R12D,
    R13D,
    R14D,
    R15D,
    RAX,
    RCX,
    RDX,
    RBX,
    RSP,
    RBP,
    RSI,
    RDI,
    R8,
    R9,
    R10,
    R11,
    R12,
    R13,
    R14,
    R15,
    ES,
    CS,
    SS,
    DS,
    FS,
    GS,
    CR0,
    CR1,
    CR2,
    CR3,
    CR4,
    CR5,
    CR6,
    CR7,
    CR8,
    CR10,
    CR11,
    CR12,
    CR13,
    CR14,
    CR15,
    DR0,
    DR1,
    DR2,
    DR3,
    DR4,
    DR5,
    DR6,
    DR7,
    DR8,
    DR9,
    DR10,
    DR11,
    DR12,
    DR13,
    DR14,
    DR15,
    MM0,
    MM1,
    MM2,
    MM3,
    MM4,
    MM5,
    MM6,
    MM7,
    ST0,
    ST1,
    ST2,
    ST3,
    ST4,
    ST5,
    ST6,
    ST7,
    XMM0,
    XMM1,
    XMM2,
    XMM3,
    XMM4,
    XMM5,
    XMM6,
    XMM7,
    XMM8,
    XMM9,
    XMM10,
    XMM11,
    XMM12,
    XMM13,
    XMM14,
    XMM15,
    YMM0,
    YMM1,
    YMM2,
    YMM3,
    YMM4,
    YMM5,
    YMM6,
    YMM7,
    YMM8,
    YMM9,
    YMM10,
    YMM11,
    YMM12,
    YMM13,
    YMM14,
    YMM15,
    FLAGS,
    RIP;

    public static RegisterName GPR(BinaryWidth w, int i) {
        switch (w) {
            case _8BIT: {
                return GPR8(i);
            }
            case _16BIT: {
                return GPR16(i);
            }
            case _32BIT: {
                return GPR32(i);
            }
            case _64BIT: {
                return GPR64(i);
            }
            default: {
                break;
            }
        }
        throw new IllegalArgumentException();
    }
    
    public static RegisterName GPR8(int i) {
        switch (i) {
            case 0: {
                return AL;
            }
            case 1: {
                return CL;
            }
            case 2: {
                return DL;
            }
            case 3: {
                return BL;
            }
            case 4: {
                return AH;
            }
            case 5: {
                return CH;
            }
            case 6: {
                return DH;
            }
            case 7: {
                return BH;
            }
            case 8: {
                return SPL;
            }
            case 9: {
                return BPL;
            }
            case 10: {
                return SIL;
            }
            case 11: {
                return DIL;
            }
            case 12: {
                return R8B;
            }
            case 13: {
                return R9B;
            }
            case 14: {
                return R10B;
            }
            case 15: {
                return R11B;
            }
            case 16: {
                return R12B;
            }
            case 17: {
                return R13B;
            }
            case 18: {
                return R14B;
            }
            case 19: {
                return R15B;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }
    
    public static RegisterName GPR16(int i) {
        switch (i) {
            case 0: {
                return AX;
            }
            case 1: {
                return CX;
            }
            case 2: {
                return DX;
            }
            case 3: {
                return BX;
            }
            case 4: {
                return SP;
            }
            case 5: {
                return BP;
            }
            case 6: {
                return SI;
            }
            case 7: {
                return DI;
            }
            case 8: {
                return R8W;
            }
            case 9: {
                return R9W;
            }
            case 10: {
                return R10W;
            }
            case 11: {
                return R11W;
            }
            case 12: {
                return R12W;
            }
            case 13: {
                return R13W;
            }
            case 14: {
                return R14W;
            }
            case 15: {
                return R15W;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }
    
    public static RegisterName GPR32(int i) {
        switch (i) {
            case 0: {
                return EAX;
            }
            case 1: {
                return ECX;
            }
            case 2: {
                return EDX;
            }
            case 3: {
                return EBX;
            }
            case 4: {
                return ESP;
            }
            case 5: {
                return EBP;
            }
            case 6: {
                return ESI;
            }
            case 7: {
                return EDI;
            }
            case 8: {
                return R8D;
            }
            case 9: {
                return R9D;
            }
            case 10: {
                return R10D;
            }
            case 11: {
                return R11D;
            }
            case 12: {
                return R12D;
            }
            case 13: {
                return R13D;
            }
            case 14: {
                return R14D;
            }
            case 15: {
                return R15D;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }
    
    public static RegisterName GPR64(int i) {
        switch (i) {
            case 0: {
                return RAX;
            }
            case 1: {
                return RCX;
            }
            case 2: {
                return RDX;
            }
            case 3: {
                return RBX;
            }
            case 4: {
                return RSP;
            }
            case 5: {
                return RBP;
            }
            case 6: {
                return RSI;
            }
            case 7: {
                return RDI;
            }
            case 8: {
                return R8;
            }
            case 9: {
                return R9;
            }
            case 10: {
                return R10;
            }
            case 11: {
                return R11;
            }
            case 12: {
                return R12;
            }
            case 13: {
                return R13;
            }
            case 14: {
                return R14;
            }
            case 15: {
                return R15;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }
    
    public static RegisterName Segment(int i) {
        switch (i) {
            case 0: {
                return ES;
            }
            case 1: {
                return CS;
            }
            case 2: {
                return SS;
            }
            case 3: {
                return DS;
            }
            case 4: {
                return FS;
            }
            case 5: {
                return GS;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }
    
    public static RegisterName Control(int i) {
        switch (i) {
            case 0: {
                return CR0;
            }
            case 1: {
                return CR1;
            }
            case 2: {
                return CR2;
            }
            case 3: {
                return CR3;
            }
            case 4: {
                return CR4;
            }
            case 5: {
                return CR5;
            }
            case 6: {
                return CR6;
            }
            case 7: {
                return CR7;
            }
            case 8: {
                return CR8;
            }
            case 9: {
                return CR10;
            }
            case 10: {
                return CR11;
            }
            case 11: {
                return CR12;
            }
            case 12: {
                return CR13;
            }
            case 13: {
                return CR14;
            }
            case 14: {
                return CR15;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }
    
    public static RegisterName Debug(int i) {
        switch (i) {
            case 0: {
                return DR0;
            }
            case 1: {
                return DR1;
            }
            case 2: {
                return DR2;
            }
            case 3: {
                return DR3;
            }
            case 4: {
                return DR4;
            }
            case 5: {
                return DR5;
            }
            case 6: {
                return DR6;
            }
            case 7: {
                return DR7;
            }
            case 8: {
                return DR8;
            }
            case 9: {
                return DR9;
            }
            case 10: {
                return DR10;
            }
            case 11: {
                return DR11;
            }
            case 12: {
                return DR12;
            }
            case 13: {
                return DR13;
            }
            case 14: {
                return DR14;
            }
            case 15: {
                return DR15;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }
    
    public static RegisterName MMX(int i) {
        switch (i) {
            case 0: {
                return MM0;
            }
            case 1: {
                return MM1;
            }
            case 2: {
                return MM2;
            }
            case 3: {
                return MM3;
            }
            case 4: {
                return MM4;
            }
            case 5: {
                return MM5;
            }
            case 6: {
                return MM6;
            }
            case 7: {
                return MM7;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }
    
    public static RegisterName ST(int i) {
        switch (i) {
            case 0: {
                return ST0;
            }
            case 1: {
                return ST1;
            }
            case 2: {
                return ST2;
            }
            case 3: {
                return ST3;
            }
            case 4: {
                return ST4;
            }
            case 5: {
                return ST5;
            }
            case 6: {
                return ST6;
            }
            case 7: {
                return ST7;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }
    
    public static RegisterName XMM(int i) {
        switch (i) {
            case 0: {
                return XMM0;
            }
            case 1: {
                return XMM1;
            }
            case 2: {
                return XMM2;
            }
            case 3: {
                return XMM3;
            }
            case 4: {
                return XMM4;
            }
            case 5: {
                return XMM5;
            }
            case 6: {
                return XMM6;
            }
            case 7: {
                return XMM7;
            }
            case 8: {
                return XMM8;
            }
            case 9: {
                return XMM9;
            }
            case 10: {
                return XMM10;
            }
            case 11: {
                return XMM11;
            }
            case 12: {
                return XMM12;
            }
            case 13: {
                return XMM13;
            }
            case 14: {
                return XMM14;
            }
            case 15: {
                return XMM15;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }
    
    public static RegisterName YMM(int i) {
        switch (i) {
            case 0: {
                return YMM0;
            }
            case 1: {
                return YMM1;
            }
            case 2: {
                return YMM2;
            }
            case 3: {
                return YMM3;
            }
            case 4: {
                return YMM4;
            }
            case 5: {
                return YMM5;
            }
            case 6: {
                return YMM6;
            }
            case 7: {
                return YMM7;
            }
            case 8: {
                return YMM8;
            }
            case 9: {
                return YMM9;
            }
            case 10: {
                return YMM10;
            }
            case 11: {
                return YMM11;
            }
            case 12: {
                return YMM12;
            }
            case 13: {
                return YMM13;
            }
            case 14: {
                return YMM14;
            }
            case 15: {
                return YMM15;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }
    

}

