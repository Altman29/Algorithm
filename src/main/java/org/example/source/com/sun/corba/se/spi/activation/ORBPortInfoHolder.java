package com.sun.corba.se.spi.activation;

/**
* com/sun/corba/se/spi/activation/ORBPortInfoHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /home/jenkins/node/workspace/Corretto8/generic_linux/x64/build/Corretto8Src/installers/linux/universal/tar/corretto-build/buildRoot/corba/src/share/classes/com/sun/corba/se/spi/activation/activation.idl
* Monday, April 17, 2023 10:45:40 PM UTC
*/

public final class ORBPortInfoHolder implements org.omg.CORBA.portable.Streamable
{
  public com.sun.corba.se.spi.activation.ORBPortInfo value = null;

  public ORBPortInfoHolder ()
  {
  }

  public ORBPortInfoHolder (com.sun.corba.se.spi.activation.ORBPortInfo initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = com.sun.corba.se.spi.activation.ORBPortInfoHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    com.sun.corba.se.spi.activation.ORBPortInfoHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return com.sun.corba.se.spi.activation.ORBPortInfoHelper.type ();
  }

}
