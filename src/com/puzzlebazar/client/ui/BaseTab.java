/**
 * Copyright 2010 Philippe Beaudoin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.puzzlebazar.client.ui;

import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.Tab;

/**
 * @author Philippe Beaudoin
 */
public abstract class BaseTab extends Composite implements Tab {

  /**
   * Internal style defined in UiBinder of subclasses.
   */
  protected interface Style extends CssResource {
    String active();
    String inactive();
  }

  @UiField
  Style style;

  @UiField
  Hyperlink hyperlink;

  private final float priority;

  public BaseTab(float priority) {
    super();
    this.priority = priority;
  }

  @Override
  public void setText(String text) {
    hyperlink.setText(text);
  }

  @Override
  public String getText() {
    return hyperlink.getText();
  }

  @Override
  public void setTargetHistoryToken(String historyToken) {
    hyperlink.setTargetHistoryToken(historyToken);      
  }

  @Override
  public void activate() {
    removeStyleName(style.inactive());
    addStyleName(style.active());
  }

  @Override
  public void deactivate() {
    removeStyleName(style.active());
    addStyleName(style.inactive());
  }

  @Override
  public float getPriority() {
    return priority;
  }

  @Override
  public Widget asWidget() {
    return this;
  }

}