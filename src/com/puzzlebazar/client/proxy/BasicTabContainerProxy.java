package com.puzzlebazar.client.proxy;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Provider;
import com.philbeaudoin.gwt.presenter.client.EventBus;
import com.philbeaudoin.gwt.presenter.client.Presenter;
import com.philbeaudoin.gwt.presenter.client.proxy.BasicProxy;
import com.philbeaudoin.gwt.presenter.client.proxy.SetContentEvent;
import com.philbeaudoin.gwt.presenter.client.proxy.SetContentHandler;
import com.puzzlebazar.client.presenter.TabContainerPresenter;


public class BasicTabContainerProxy<P extends TabContainerPresenter> extends
    BasicProxy<P> implements TabContainerProxy {

  /**
   * The {@link Type} of the event used by {@link Presenter} classes that want
   * to be set within this container.
   */
  private final Type<SetContentHandler> setTabContentEventType;
  
  /**
   * Creates a proxy class for a presenter that can contain tabs.
   * 
   * @param eventBus The event bus.
   * @param presenter A provider for the {@link Presenter} of which this class is a proxy. 
   * @param setTabContentEventType The {@link Type} of the event used by 
   *        {@link Presenter} classes that want to be set within this container.
   */
  public BasicTabContainerProxy(final EventBus eventBus, 
      final Provider<P> presenter,
      final Type<SetContentHandler> setTabContentEventType ) {
    super(eventBus, presenter);
    this.setTabContentEventType = setTabContentEventType;
  }

  @Override
  public void onBind() {
    super.onBind();
    registerHandler( eventBus.addHandler( setTabContentEventType, new SetContentHandler(){
      @Override
      public void onSetContent(SetContentEvent setContentEvent) {
        getPresenter().setTabContent( setContentEvent.getContent() );
        getPresenter().revealDisplay();
      }
    } ) );
  }
}