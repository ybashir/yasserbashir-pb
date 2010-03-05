package com.philbeaudoin.gwt.presenter.client;

import com.google.gwt.user.client.ui.Widget;
import com.philbeaudoin.gwt.presenter.client.proxy.PlaceManager;
import com.philbeaudoin.gwt.presenter.client.proxy.PlaceRequest;
import com.philbeaudoin.gwt.presenter.client.proxy.Proxy;
import com.philbeaudoin.gwt.presenter.client.proxy.ProxyPlace;
import com.philbeaudoin.gwt.presenter.client.proxy.SetContentEvent;

public interface Presenter {

  /**
   * <b>Important:</b> Do not call directly. Call {@link ProxyPlace#reveal()}
   * instead. This way you can make sure you don't inadvertently reveal a 
   * non-leaf Presenter. Also, you will benefit from the change confirmation
   * mechanism. (See {@link PlaceManager#setOnLeaveConfirmation(String)}).
   * <p />
   * Requests the presenter to reveal itself on screen.
   * Upon being revealed presenters will ask to be inserted within 
   * their parent presenters by firing a {@link SetContentEvent}
   * which will cause the parent to be revealed too.
   */
  public void reveal();

  /**
   * This method is called when a {@link Presenter} should prepare itself
   * based on a {@link PlaceRequest}. The presenter should extract
   * any parameters it needs from the request. A presenter should override
   * this method if it handles custom parameters, but it should call
   * the parent's <code>prepareFromRequest</code> method.
   *
   * @param request   The request.
   */
  public void prepareFromRequest( PlaceRequest request );
  
  /**
   * Returns the {@link Display} for the current presenter.
   *
   * @return The display.
   */
  public Display getDisplay();

  /**
   * Returns the {@link Proxy} for the current presenter.
   *
   * @return The proxy.
   */
  public Proxy getProxy();

  /**
   * Notify others that this presenter has been changed. This is especially
   * useful for stateful presenters that store parameters within the
   * history token. Calling this will make sure the history token is
   * updated with the right parameters.
   */
  public void notifyChange();

  /**
   * <b>Important:</b> Make sure you call your superclass {@link #onReveal()}.
   * <p />
   * This method will be called whenever the presenter is revealed. Override
   * it to perform any action (such as refreshing content) that needs
   * to be done when the presenter is revealed.
   * <p />
   * This should never be called directly. Call 
   * {@link ProxyPlace#reveal()} instead.
   */
  public void onReveal();
  
  /**
   * <b>Important:</b> Make sure you call your superclass {@link #onHide()}.
   * <p />
   * You should call this method on your child presenters:
   * <ul>
   * <li>Right before you remove it from the DOM; and</li>
   * <li>Whenever you receive a call to {@link #onHide()}.</li>
   * </ul>
   * Override this method to perform any clean-up operation. For example,
   * objects created directly or indirectly during the call to
   * {@link #onReveal()} should be disposed of in this methods.
   */
  public void onHide();
  
  /**
   * This method is called when creating a {@link PlaceRequest} for this
   * {@link Presenter}. The presenter should add all the required parameters to the 
   * request.
   * <p/>
   * <p/>
   * If nothing is to be done, simply return the <code>request</code>
   * unchanged. Otherwise, call {@link PlaceRequest#with(String, String)} to
   * add parameters. Eg:
   * <p/>
   * <pre>
   * return request.with( &quot;id&quot;, getId() );
   * </pre>
   * <p/>
   * A presenter should override this method if it handles custom parameters, but
   * it should call the parent's <code>prepareRequest</code> method.
   * 
   * @param request   The current request.
   * @return The prepared place request.
   */
  public PlaceRequest prepareRequest( PlaceRequest request );

  /**
   * Makes it possible to access the {@link Widget} object associated with that presenter.
   * 
   * @return The Widget associated with that presenter.
   */
  public Widget getWidget();

}
