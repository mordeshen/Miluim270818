
package com.mordechay.miluim270818;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

public class friends
{
  private String name;
  private java.util.Date created;
  private String objectId;
  private String ownerId;
  private java.util.Date updated;
//  private Integer imagePerson;
  private String phoneNumber;
  public String getName()
  {
    return name;
  }

  public void setName( String name )
  {
    this.name = name;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

//  public Integer getImagePerson()
//  {
//    return imagePerson;
//  }

//  public void setImagePerson( Integer imagePerson )
//  {
//    this.imagePerson = imagePerson;
//  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public void setPhoneNumber( String phoneNumber )
  {
    this.phoneNumber = phoneNumber;
  }

                                                    
  public friends save()
  {
    return Backendless.Data.of( friends.class ).save( this );
  }

  public void saveAsync( AsyncCallback<friends> callback )
  {
    Backendless.Data.of( friends.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( friends.class ).remove( this );
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( friends.class ).remove( this, callback );
  }

  public static friends findById(String id )
  {
    return Backendless.Data.of( friends.class ).findById( id );
  }

  public static void findByIdAsync( String id, AsyncCallback<friends> callback )
  {
    Backendless.Data.of( friends.class ).findById( id, callback );
  }

  public static friends findFirst()
  {
    return Backendless.Data.of( friends.class ).findFirst();
  }

  public static void findFirstAsync( AsyncCallback<friends> callback )
  {
    Backendless.Data.of( friends.class ).findFirst( callback );
  }

  public static friends findLast()
  {
    return Backendless.Data.of( friends.class ).findLast();
  }

  public static void findLastAsync( AsyncCallback<friends> callback )
  {
    Backendless.Data.of( friends.class ).findLast( callback );
  }

  public static List<friends> find(DataQueryBuilder queryBuilder )
  {
    return Backendless.Data.of( friends.class ).find( queryBuilder );
  }

  public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<friends>> callback )
  {
    Backendless.Data.of( friends.class ).find( queryBuilder, callback );
  }
}