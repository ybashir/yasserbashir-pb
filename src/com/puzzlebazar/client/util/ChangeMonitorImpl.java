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

package com.puzzlebazar.client.util;

import java.util.ArrayList;
import java.util.List;

import com.gwtplatform.mvp.client.HandlerContainerImpl;

/**
 * <b>Important:</b> This class participates in dependency injection.
 * Make sure you inject it, never instantiate it with <code>new</code>.
 * <p />
 * 
 * @author Philippe Beaudoin
 */
public class ChangeMonitorImpl 
extends HandlerContainerImpl
implements ChangeMonitor {

  /**
   * This class is used on monitored object.
   */
  private class MonitoredObjectHandler implements MonitorHandler {
    @Override
    public void changeDetected() {
      newChange();
    }

    @Override
    public void changeReverted() {
      newChangeReverted();
    }
  }

  private final List<ChangeMonitorUnit> changeMonitors = new ArrayList<ChangeMonitorUnit>();
  private final MonitoredObjectHandler subHandler = new MonitoredObjectHandler();
  private boolean changed;
  private MonitorHandler handler;
  
  /**
   * Creates a new {@link ChangeMonitor} object.
   */
  public ChangeMonitorImpl() {
    super();
  }
  
  @Override
  protected void onUnbind() {
    super.onUnbind();
    for (ChangeMonitorUnit changeMonitor : changeMonitors) {
      changeMonitor.release();      
    }
    changeMonitors.clear();
    changed = false;
  }    

  @Override
  public void setHandler(MonitorHandler handler) {
    this.handler = handler;
  }
  
  @Override
  public void monitorWidget(Object widget) {
    assert isBound() : "Change monitor must be bound before widgets can be monitored.";
    changeMonitors.add(new ChangeMonitorUnit(widget, subHandler));
  }

  @Override
  public void changeDetected() {
    if (handler != null) {
      handler.changeDetected();
    }
  }

  @Override
  public void changeReverted() {
    if (handler != null) {
      handler.changeReverted();
    }
  }
  
  /**
   * A monitored object has recently changed, see if it affects our status.
   */
  private void newChange() {
    if (changed) {
      return;
    }
    changed = true;
    changeDetected();      
  }

  /**
   * A monitored object has recently reverted its changes, see if it 
   * affects our status.
   */
  private void newChangeReverted() {
    for (ChangeMonitorUnit changeMonitor : changeMonitors) {
      if (changeMonitor.hasChanged()) {
        return;
      }
    }
    changed = false;
    changeReverted();      
  }

  @Override
  public void reset() {
    for (ChangeMonitorUnit changeMonitor : changeMonitors) {
      changeMonitor.reset();
    }
    changed = false;
    changeReverted();      
  }

}
