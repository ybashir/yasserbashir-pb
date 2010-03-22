package com.puzzlebazar.client.core.presenter;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.philbeaudoin.platform.mvp.client.View;
import com.philbeaudoin.platform.mvp.client.PresenterImpl;
import com.philbeaudoin.platform.mvp.client.EventBus;
import com.philbeaudoin.platform.mvp.client.proxy.Proxy;
import com.philbeaudoin.platform.mvp.client.proxy.RevealContentEvent;
import com.philbeaudoin.platform.mvp.client.proxy.RevealContentHandler;
import com.philbeaudoin.platform.mvp.rebind.ContentSlot;
import com.philbeaudoin.platform.mvp.rebind.ProxyCodeSplit;

public class SplitMainPresenter 
extends PresenterImpl<SplitMainPresenter.MyView, SplitMainPresenter.MyProxy>
implements DisplayShortMessageHandler {

  @ContentSlot
  public static final Type<RevealContentHandler<?>> TYPE_RevealSideBarContent = new Type<RevealContentHandler<?>>();
  
  @ContentSlot
  public static final Type<RevealContentHandler<?>> TYPE_RevealCenterContent = new Type<RevealContentHandler<?>>();
  
  public interface MyView extends View {
    public void showMessage( String message, boolean dismissable );
    public void clearMessage();
    public boolean hasSideBarContent();
  }

  @ProxyCodeSplit
  public interface MyProxy extends Proxy<SplitMainPresenter> {}

  @Inject
  public SplitMainPresenter(
      final EventBus eventBus, 
      final MyView view, 
      final MyProxy proxy ) {
    super(eventBus, view, proxy);
  }  

  @Override
  protected void revealInParent() {
    RevealContentEvent.fire(eventBus, PagePresenter.TYPE_RevealMainContent, this);
  }

  @Override
  protected void onBind() {
    super.onBind();
    registerHandler( eventBus.addHandler( DisplayShortMessageEvent.getType(), this ) );
  }

  @Override
  protected void onReveal() {
    super.onReveal();
    if( !getView().hasSideBarContent() )
      RevealDefaultLinkColumnEvent.fire(eventBus);
  }

  @Override
  public void onDisplayShortMessage(DisplayShortMessageEvent event) {
    if( !isVisible() || event.isAlreadyDisplayed() )
      return;
    String message = event.getMessage();    
    if( message == null )
      view.clearMessage();
    else    
      // TODO Take duration into account
      view.showMessage( event.getMessage(), event.isDismissable() );
    event.setAlreadyDisplayed();
  }
}
