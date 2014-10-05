package com.hubspot.singularity.config;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.hubspot.singularity.config.EmailConfigurationEnums.EmailDestination;
import com.hubspot.singularity.config.EmailConfigurationEnums.EmailType;

public class SMTPConfiguration {

  @JsonProperty
  private String username;

  @JsonProperty
  private String password;

  @JsonProperty
  private Integer taskLogLength = 512;

  @NotNull
  @JsonProperty
  private String host = "localhost";

  @JsonProperty
  private Integer port;

  @JsonProperty
  @NotNull
  private String from = "singularity-no-reply@example.com";

  @NotNull
  @JsonProperty
  private int mailThreads = 1;

  @NotNull
  @JsonProperty
  private int mailMaxThreads = 3;

  @NotNull
  @JsonProperty
  private boolean ssl = false;

  @NotNull
  @JsonProperty
  private boolean startTLS = false;

  @NotNull
  @JsonProperty
  private List<String> admins = Collections.emptyList();

  @JsonProperty("emails")
  private Map<EmailType, List<EmailDestination>> emailConfiguration = ImmutableMap.<EmailType, List<EmailDestination>>builder()
      .put(EmailType.REQUEST_IN_COOLDOWN, ImmutableList.of(EmailDestination.ADMINS, EmailDestination.OWNERS))
      .put(EmailType.SINGULARITY_ABORTING, ImmutableList.of(EmailDestination.ADMINS))
      .put(EmailType.TASK_FAILED, ImmutableList.of(EmailDestination.ADMINS, EmailDestination.OWNERS))
      .put(EmailType.TASK_LOST, ImmutableList.of(EmailDestination.ADMINS))
      .put(EmailType.TASK_KILLED_UNHEALTHY, ImmutableList.of(EmailDestination.OWNERS, EmailDestination.ADMINS))
      .put(EmailType.REQUEST_PAUSED, ImmutableList.of(EmailDestination.OWNERS, EmailDestination.ADMINS))
      .put(EmailType.REQUEST_REMOVED, ImmutableList.of(EmailDestination.OWNERS, EmailDestination.ADMINS))
      .put(EmailType.REQUEST_UNPAUSED, ImmutableList.of(EmailDestination.OWNERS, EmailDestination.ADMINS))
      .build();

  public Map<EmailType, List<EmailDestination>> getEmailConfiguration() {
    return emailConfiguration;
  }

  public void setEmailConfiguration(Map<EmailType, List<EmailDestination>> emailConfiguration) {
    this.emailConfiguration = emailConfiguration;
  }

  public int getTaskLogLength() {
    return taskLogLength;
  }

  public void setTaskLogLength(Integer length) {
    taskLogLength = length;
  }

  public Optional<String> getUsername() {
    return Optional.fromNullable(username);
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public int getMailThreads() {
    return mailThreads;
  }

  public void setMailThreads(int mailThreads) {
    this.mailThreads = mailThreads;
  }

  public int getMailMaxThreads() {
    return mailMaxThreads;
  }

  public void setMailMaxThreads(int mailMaxThreads) {
    this.mailMaxThreads = mailMaxThreads;
  }

  public Optional<String> getPassword() {
    return Optional.fromNullable(password);
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public Optional<Integer> getPort() {
    return Optional.fromNullable(port);
  }

  public void setPort(Integer port) {
    this.port = port;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public boolean isSsl() {
    return ssl;
  }

  public void setSsl(boolean ssl) {
    this.ssl = ssl;
  }

  public boolean isStartTLS() {
    return startTLS;
  }

  public void setStartTLS(boolean startTLS) {
    this.startTLS = startTLS;
  }

  public List<String> getAdmins() {
    return admins;
  }

  public void setAdmins(List<String> admins) {
    this.admins = admins;
  }

}
