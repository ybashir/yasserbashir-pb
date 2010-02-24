package com.puzzlebazar.shared.model;

import java.io.Serializable;

import com.puzzlebazar.client.util.Validation;

public class UserInfo implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -6968794066096789377L;

  public static final int MIN_FIRSTNAME_LENGTH = 1;
  public static final int MIN_LASTNAME_LENGTH = 1;
  public static final int MIN_NICKNAME_LENGTH = 5;

  public static final int MAX_FIRSTNAME_LENGTH = 30;
  public static final int MAX_LASTNAME_LENGTH = 30;
  public static final int MAX_NICKNAME_LENGTH = 30;
  public static final int MAX_EMAIL_LENGTH = 80;

  public class ErrorFlags {
    public static final int SUCCESS = 0;
    public static final int EMAIL_ALREADY_REGISTERED = 0x0001;
    public static final int UNREGISTERED_EMAIL = 0x0100;
    public static final int NICKNAME_MODIFIED = 0x1000;
    public static final int MODIFYING_OTHER_USER = 0x2000;
    public static final int UNKOWN_ERROR = 0x8000;
  };


  private String email;
  private String firstname;
  private String lastname;
  private String nickname;
  private boolean administrator = false;
  private boolean authenticated = false;;

  public UserInfo() {
    email = "";
    firstname = "";
    lastname = "";
    nickname = "";
  }

  /**
   * @return The email address of this user 
   */
  public String getEmail() {
    return email;
  }

  /**
   * @return The first name of this user 
   */
  public String getFirstname() {
    return firstname;
  }

  /**
   * @return The last name of this user 
   */
  public String getLastname() {
    return lastname;
  }

  /**
   * @return The nickname of this user 
   */
  public String getNickname() {
    return nickname;
  }

  /**
   * @return True if the user is an administrator
   */
  public boolean isAdministrator() {
    return administrator;
  }

  /**
   * @param email The email address to set for this user
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @param firstname The first name to set for this user
   */
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }


  /**
   * @param lastname The last name to set for this user
   */
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  /**
   * @param nickname The nickname to set for this user
   */
  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  /**
   * @param administrator True if the user should be an administrator, false otherwise.
   */
  public void setAdministrator(boolean administrator) {
    this.administrator = administrator;
  }

  /**
   * @param authenticated True if the user is authenticade via Google User Service, false if not.
   */
  public void setAuthenticated(boolean authenticated) {
    this.authenticated = authenticated;
  }
  
  /**
   * @return True if the user is authenticade via Google User Service, false if not.
   */
  public boolean isAuthenticated() {
    return authenticated;
  }

  /**
   * @return True if the information is valid, false if not
   */
  public boolean isValid() {		
    return Validation.validateString( firstname, MIN_FIRSTNAME_LENGTH, MAX_FIRSTNAME_LENGTH ) &&
    Validation.validateString( lastname, MIN_LASTNAME_LENGTH, MAX_LASTNAME_LENGTH ) &&
    Validation.validateString( email, 0, MAX_EMAIL_LENGTH ) &&
    Validation.validateEmail( email ) &&
    Validation.validateString( nickname, MIN_NICKNAME_LENGTH, MAX_NICKNAME_LENGTH );
  }


}