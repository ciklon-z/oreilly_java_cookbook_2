package com.darwinsys.io;

import java.io.*;

/**
 * Some I-O primitives for datastreams.
 * All methods are static, since there is no state.
 * @version $Id: DataIO.java,v 1.3 2004/03/07 17:14:57 ian Exp $
 */
public class DataIO {

	/** Nobody should need to create an instance; all methods are static */
	private DataIO() { 
		// nothing to do
	}

    /** Read an unsigned int from a DataInput
	 * @param is DataInput (DataInputStream, RandomAccessFile, etc).
	 * @return long, to hold an unsigned int.
	 */
    public static long readUnsignedInt(DataInput is) throws IOException {
		// Need to read 4 bytes from the input, unsigned.
		// Do it yourself; there is no readUnsignedInt().
		return
			((long)(is.readUnsignedByte() & 0xff) << 24) |
			((long)(is.readUnsignedByte() & 0xff) << 16) |
			((long)(is.readUnsignedByte() & 0xff) <<  8) |
			((long)(is.readUnsignedByte() & 0xff) <<  0);
	}
}
