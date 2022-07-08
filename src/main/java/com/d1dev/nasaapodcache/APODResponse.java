package com.d1dev.nasaapodcache;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class APODResponse {

  private String title;
  private String date;
  private String url;
  private String explanation;
  private String copyright;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getExplanation() {
    return explanation;
  }

  public void setExplanation(String explanation) {
    this.explanation = explanation;
  }

  public String getCopyright() {
    return copyright;
  }

  public void setCopyright(String copyright) {
    this.copyright = copyright;
  }

  public APODResponse() {
  }

  public APODResponse(String title, String date, String url, String explanation, String copyright) {
    this.title = title;
    this.date = date;
    this.url = url;
    this.explanation = explanation;
    this.copyright = copyright;
  }

  @Override
  public String toString() {
    return "APODResponse: {" +
        "title: " + title +
        ", date: " + date +
        ", url: " + url +
        ", explanation: " + explanation +
        ", copyright: " + copyright +
        '}';
  }
}
