package com.sun.corba.se.spi.activation;


/**
* com/sun/corba/se/spi/activation/ServerHeldDown.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /home/jenkins/node/workspace/Corretto8/generic_linux/x64/build/Corretto8Src/installers/linux/universal/tar/corretto-build/buildRoot/corba/src/share/classes/com/sun/corba/se/spi/activation/activation.idl
* Monday, April 17, 2023 10:45:40 PM UTC
*/

public final class ServerHeldDown extends org.omg.CORBA.UserException
{
  public int serverId = (int)0;

  public ServerHeldDown ()
  {
    super(ServerHeldDownHelper.id());
  } // ctor

  public ServerHeldDown (int _serverId)
  {
    super(ServerHeldDownHelper.id());
    serverId = _serverId;
  } // ctor


  public ServerHeldDown (String $reason, int _serverId)
  {
    super(ServerHeldDownHelper.id() + "  " + $reason);
    serverId = _serverId;
  } // ctor

} // class ServerHeldDown
