package com.puzzlebazar.client.core.presenter;

import com.google.inject.Inject;
import com.philbeaudoin.gwtp.mvp.client.View;
import com.philbeaudoin.gwtp.mvp.client.PresenterImpl;
import com.philbeaudoin.gwtp.mvp.client.EventBus;
import com.philbeaudoin.gwtp.mvp.client.proxy.Place;
import com.philbeaudoin.gwtp.mvp.client.proxy.RevealContentEvent;
import com.philbeaudoin.gwtp.mvp.client.proxy.TabContentProxy;
import com.philbeaudoin.gwtp.mvp.client.annotations.NameToken;
import com.philbeaudoin.gwtp.mvp.client.annotations.PlaceInstance;
import com.philbeaudoin.gwtp.mvp.client.annotations.ProxyCodeSplit;
import com.philbeaudoin.gwtp.mvp.client.annotations.TabInfo;
import com.puzzlebazar.client.NameTokens;

/**
 * This is the presenter of the general tab in the administration page.
 * 
 * @author Philippe Beaudoin
 */
public class AdminUsersPresenter 
extends PresenterImpl<AdminUsersPresenter.MyView, AdminUsersPresenter.MyProxy> {

  public interface MyView extends View { }

  @ProxyCodeSplit
  @NameToken( NameTokens.adminUsers )
  @PlaceInstance( "new com.puzzlebazar.client.AdminSecurePlace(nameToken, ginjector.getCurrentUser())" )
  @TabInfo(
      container = AdminTabPresenter.class, 
      priority = 1, 
      getLabel="ginjector.getTranslations().tabUsers()")
  public interface MyProxy extends TabContentProxy<AdminUsersPresenter>, Place {}

  @Inject
  public AdminUsersPresenter(final EventBus eventBus, 
      final MyView view, 
      final MyProxy proxy ) {
    super(eventBus, view, proxy );
  }

  @Override
  protected void revealInParent() {
    RevealContentEvent.fire(eventBus, AdminTabPresenter.TYPE_RevealTabContent, this);
  }
}
