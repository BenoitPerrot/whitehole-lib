package org.whitehole.binary.pe;

import org.whitehole.infra.types.UInt32;

public abstract class WindowsSpecificPEFields {
    abstract public UInt32 getRvaAndSizeCount();
}
