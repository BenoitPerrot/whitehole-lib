// Generated, do not edit by hand
package org.whitehole.infra.types;
import org.whitehole.infra.io.LargeByteBuffer;
import java.io.InputStream;
import java.io.IOException;

public class LittleEndianReader {
    public static ByteArray1 readByteArray1(LargeByteBuffer buffer, long offset) {
        return new ByteArray1(buffer.get(offset + 0));
    }
    
    public static UInt8 readUInt8(LargeByteBuffer buffer, long offset) {
        return new UInt8(buffer.get(offset + 0));
    }
    
    public static Int8 readInt8(LargeByteBuffer buffer, long offset) {
        return new Int8(buffer.get(offset + 0));
    }
    
    public static ByteArray2 readByteArray2(LargeByteBuffer buffer, long offset) {
        return new ByteArray2(buffer.get(offset + 1), buffer.get(offset + 0));
    }
    
    public static UInt16 readUInt16(LargeByteBuffer buffer, long offset) {
        return new UInt16(buffer.get(offset + 1), buffer.get(offset + 0));
    }
    
    public static Int16 readInt16(LargeByteBuffer buffer, long offset) {
        return new Int16(buffer.get(offset + 1), buffer.get(offset + 0));
    }
    
    public static ByteArray4 readByteArray4(LargeByteBuffer buffer, long offset) {
        return new ByteArray4(buffer.get(offset + 3), buffer.get(offset + 2), buffer.get(offset + 1), buffer.get(offset + 0));
    }
    
    public static UInt32 readUInt32(LargeByteBuffer buffer, long offset) {
        return new UInt32(buffer.get(offset + 3), buffer.get(offset + 2), buffer.get(offset + 1), buffer.get(offset + 0));
    }
    
    public static Int32 readInt32(LargeByteBuffer buffer, long offset) {
        return new Int32(buffer.get(offset + 3), buffer.get(offset + 2), buffer.get(offset + 1), buffer.get(offset + 0));
    }
    
    public static ByteArray8 readByteArray8(LargeByteBuffer buffer, long offset) {
        return new ByteArray8(buffer.get(offset + 7), buffer.get(offset + 6), buffer.get(offset + 5), buffer.get(offset + 4), buffer.get(offset + 3), buffer.get(offset + 2), buffer.get(offset + 1), buffer.get(offset + 0));
    }
    
    public static UInt64 readUInt64(LargeByteBuffer buffer, long offset) {
        return new UInt64(buffer.get(offset + 7), buffer.get(offset + 6), buffer.get(offset + 5), buffer.get(offset + 4), buffer.get(offset + 3), buffer.get(offset + 2), buffer.get(offset + 1), buffer.get(offset + 0));
    }
    
    public static Int64 readInt64(LargeByteBuffer buffer, long offset) {
        return new Int64(buffer.get(offset + 7), buffer.get(offset + 6), buffer.get(offset + 5), buffer.get(offset + 4), buffer.get(offset + 3), buffer.get(offset + 2), buffer.get(offset + 1), buffer.get(offset + 0));
    }
    
    public static ByteArray16 readByteArray16(LargeByteBuffer buffer, long offset) {
        return new ByteArray16(buffer.get(offset + 15), buffer.get(offset + 14), buffer.get(offset + 13), buffer.get(offset + 12), buffer.get(offset + 11), buffer.get(offset + 10), buffer.get(offset + 9), buffer.get(offset + 8), buffer.get(offset + 7), buffer.get(offset + 6), buffer.get(offset + 5), buffer.get(offset + 4), buffer.get(offset + 3), buffer.get(offset + 2), buffer.get(offset + 1), buffer.get(offset + 0));
    }
    
    public static UInt128 readUInt128(LargeByteBuffer buffer, long offset) {
        return new UInt128(buffer.get(offset + 15), buffer.get(offset + 14), buffer.get(offset + 13), buffer.get(offset + 12), buffer.get(offset + 11), buffer.get(offset + 10), buffer.get(offset + 9), buffer.get(offset + 8), buffer.get(offset + 7), buffer.get(offset + 6), buffer.get(offset + 5), buffer.get(offset + 4), buffer.get(offset + 3), buffer.get(offset + 2), buffer.get(offset + 1), buffer.get(offset + 0));
    }
    
    public static Int128 readInt128(LargeByteBuffer buffer, long offset) {
        return new Int128(buffer.get(offset + 15), buffer.get(offset + 14), buffer.get(offset + 13), buffer.get(offset + 12), buffer.get(offset + 11), buffer.get(offset + 10), buffer.get(offset + 9), buffer.get(offset + 8), buffer.get(offset + 7), buffer.get(offset + 6), buffer.get(offset + 5), buffer.get(offset + 4), buffer.get(offset + 3), buffer.get(offset + 2), buffer.get(offset + 1), buffer.get(offset + 0));
    }
    
    public static ByteArray1 readByteArray1(InputStream i) throws IOException {
        final byte[] buffer = new byte[1];
        i.read(buffer);
        return new ByteArray1(buffer[0]);
    }
    
    public static UInt8 readUInt8(InputStream i) throws IOException {
        final byte[] buffer = new byte[1];
        i.read(buffer);
        return new UInt8(buffer[0]);
    }
    
    public static Int8 readInt8(InputStream i) throws IOException {
        final byte[] buffer = new byte[1];
        i.read(buffer);
        return new Int8(buffer[0]);
    }
    
    public static ByteArray2 readByteArray2(InputStream i) throws IOException {
        final byte[] buffer = new byte[2];
        i.read(buffer);
        return new ByteArray2(buffer[1], buffer[0]);
    }
    
    public static UInt16 readUInt16(InputStream i) throws IOException {
        final byte[] buffer = new byte[2];
        i.read(buffer);
        return new UInt16(buffer[1], buffer[0]);
    }
    
    public static Int16 readInt16(InputStream i) throws IOException {
        final byte[] buffer = new byte[2];
        i.read(buffer);
        return new Int16(buffer[1], buffer[0]);
    }
    
    public static ByteArray4 readByteArray4(InputStream i) throws IOException {
        final byte[] buffer = new byte[4];
        i.read(buffer);
        return new ByteArray4(buffer[3], buffer[2], buffer[1], buffer[0]);
    }
    
    public static UInt32 readUInt32(InputStream i) throws IOException {
        final byte[] buffer = new byte[4];
        i.read(buffer);
        return new UInt32(buffer[3], buffer[2], buffer[1], buffer[0]);
    }
    
    public static Int32 readInt32(InputStream i) throws IOException {
        final byte[] buffer = new byte[4];
        i.read(buffer);
        return new Int32(buffer[3], buffer[2], buffer[1], buffer[0]);
    }
    
    public static ByteArray8 readByteArray8(InputStream i) throws IOException {
        final byte[] buffer = new byte[8];
        i.read(buffer);
        return new ByteArray8(buffer[7], buffer[6], buffer[5], buffer[4], buffer[3], buffer[2], buffer[1], buffer[0]);
    }
    
    public static UInt64 readUInt64(InputStream i) throws IOException {
        final byte[] buffer = new byte[8];
        i.read(buffer);
        return new UInt64(buffer[7], buffer[6], buffer[5], buffer[4], buffer[3], buffer[2], buffer[1], buffer[0]);
    }
    
    public static Int64 readInt64(InputStream i) throws IOException {
        final byte[] buffer = new byte[8];
        i.read(buffer);
        return new Int64(buffer[7], buffer[6], buffer[5], buffer[4], buffer[3], buffer[2], buffer[1], buffer[0]);
    }
    
    public static ByteArray16 readByteArray16(InputStream i) throws IOException {
        final byte[] buffer = new byte[16];
        i.read(buffer);
        return new ByteArray16(buffer[15], buffer[14], buffer[13], buffer[12], buffer[11], buffer[10], buffer[9], buffer[8], buffer[7], buffer[6], buffer[5], buffer[4], buffer[3], buffer[2], buffer[1], buffer[0]);
    }
    
    public static UInt128 readUInt128(InputStream i) throws IOException {
        final byte[] buffer = new byte[16];
        i.read(buffer);
        return new UInt128(buffer[15], buffer[14], buffer[13], buffer[12], buffer[11], buffer[10], buffer[9], buffer[8], buffer[7], buffer[6], buffer[5], buffer[4], buffer[3], buffer[2], buffer[1], buffer[0]);
    }
    
    public static Int128 readInt128(InputStream i) throws IOException {
        final byte[] buffer = new byte[16];
        i.read(buffer);
        return new Int128(buffer[15], buffer[14], buffer[13], buffer[12], buffer[11], buffer[10], buffer[9], buffer[8], buffer[7], buffer[6], buffer[5], buffer[4], buffer[3], buffer[2], buffer[1], buffer[0]);
    }
    
}
