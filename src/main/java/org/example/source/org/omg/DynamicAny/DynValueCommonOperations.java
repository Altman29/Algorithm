package org.omg.DynamicAny;


/**
* org/omg/DynamicAny/DynValueCommonOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /home/jenkins/node/workspace/Corretto8/generic_linux/x64/build/Corretto8Src/installers/linux/universal/tar/corretto-build/buildRoot/corba/src/share/classes/org/omg/DynamicAny/DynamicAny.idl
* Monday, April 17, 2023 10:45:40 PM UTC
*/


/**
    * DynValueCommon provides operations supported by both the DynValue and DynValueBox interfaces.
    */
public interface DynValueCommonOperations  extends org.omg.DynamicAny.DynAnyOperations
{

  /**
          * Returns true if the DynValueCommon represents a null value type.
          */
  boolean is_null ();

  /**
          * Changes the representation of a DynValueCommon to a null value type.
          */
  void set_to_null ();

  /**
          * Replaces a null value type with a newly constructed value. Its components are initialized
          * to default values as in DynAnyFactory.create_dyn_any_from_type_code.
          * If the DynValueCommon represents a non-null value type, then this operation has no effect. 
          */
  void set_to_value ();
} // interface DynValueCommonOperations
