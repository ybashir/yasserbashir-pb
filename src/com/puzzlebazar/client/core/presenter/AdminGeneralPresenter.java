package com.puzzlebazar.client.core.presenter;

import com.google.inject.Inject;
import com.philbeaudoin.gwt.presenter.client.Display;
import com.philbeaudoin.gwt.presenter.client.PresenterImpl;
import com.philbeaudoin.gwt.presenter.client.EventBus;
import com.philbeaudoin.gwt.presenter.client.proxy.Place;
import com.philbeaudoin.gwt.presenter.client.proxy.SetContentEvent;
import com.philbeaudoin.gwt.presenter.client.proxy.TabContentProxy;
import com.puzzlebazar.client.core.proxy.AdminTabProxy;

/**
 * This is the presenter of the general tab in the administration page.
 * 
 * @author Philippe Beaudoin
 */
public class AdminGeneralPresenter 
extends PresenterImpl<AdminGeneralPresenter.MyDisplay, AdminGeneralPresenter.MyProxy> {

  public interface MyDisplay extends Display { }

  public interface MyProxy extends TabContentProxy<AdminGeneralPresenter>, Place {}

  @Inject
  public AdminGeneralPresenter(final EventBus eventBus, 
      final MyDisplay display, 
      final MyProxy proxy ) {
    super(eventBus, display, proxy );
  }

  @Override
  protected void setContentInParent() {
    SetContentEvent.fire(eventBus, AdminTabProxy.TYPE_SetTabContent, this);
  }
}
