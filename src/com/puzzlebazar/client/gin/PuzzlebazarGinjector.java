package com.puzzlebazar.client.gin;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

import com.philbeaudoin.platform.dispatch.client.DispatchAsync;
import com.philbeaudoin.platform.dispatch.client.gin.StandardDispatchModule;

import com.philbeaudoin.platform.mvp.client.EventBus;
import com.philbeaudoin.platform.mvp.client.proxy.PlaceManager;

import com.puzzlebazar.client.resources.Resources;

@GinModules({ StandardDispatchModule.class, PuzzlebazarClientModule.class })
public interface PuzzlebazarGinjector extends Ginjector {

  PlaceManager getPlaceManager();
  EventBus getEventBus();
  Resources getResources();
  DispatchAsync getDispatcher();

}