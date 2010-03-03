package com.puzzlebazar.client.presenter;

import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.philbeaudoin.gwt.presenter.client.PresenterImpl;
import com.philbeaudoin.gwt.presenter.client.EventBus;
import com.philbeaudoin.gwt.presenter.client.Presenter;
import com.philbeaudoin.gwt.presenter.client.PresenterDisplay;
import com.philbeaudoin.gwt.presenter.client.proxy.PresenterProxy;
import com.puzzlebazar.client.proxy.AppProxy;


public class SplitMainPresenter extends PresenterImpl<SplitMainPresenter.Display, SplitMainPresenter.Proxy> {


  public interface Display extends PresenterDisplay {
    void setSideBarContent( Widget sideBarContent );
    void setCenterContent( Widget centerContent );
  }

  public interface Proxy extends PresenterProxy {}
  

  private final LinkColumnPresenter linkColumnPresenter;
  private Presenter sideBarContent = null;
  private Presenter centerContent = null;

  @Inject
  public SplitMainPresenter(
      final EventBus eventBus, 
      final Provider<Display> display, 
      final Proxy proxy,
      final LinkColumnPresenter  linkColumnPresenter ) {
    super(eventBus, display, proxy, AppProxy.TYPE_SetMainContent);

    this.linkColumnPresenter = linkColumnPresenter;
  }  

  @Override
  public void onBind() {
    setSideBarContent( linkColumnPresenter );
  }

  @Override
  public void onUnbind() {
  }

  public void setSideBarContent(Presenter content) {
    if( sideBarContent != content ) {
      sideBarContent = content;
      getDisplay().setSideBarContent( content.getWidget() );      
    }
  }
  
  public void setCenterContent(Presenter content) {
    if( centerContent  != content ) {
      centerContent = content;
      getDisplay().setCenterContent( content.getWidget() );      
    }
  }  
}
